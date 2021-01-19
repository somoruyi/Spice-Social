package com.revature.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.revature.controller.PostController;
import com.revature.models.Post;
import com.revature.repository.S3Repository;

@Service
public class S3Service implements S3Repository{

	private Logger logger = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3Client;
	
	@Autowired
	private PostController postCon;
	
	private String bucketName = "spice-sm";
	
	private String endpoint;
	
	private String objectKey;

	@Override
	public ByteArrayOutputStream downloadFile(String keyName) {
		try {
			S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, keyName));
			InputStream is = s3object.getObjectContent();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len;
			byte[] buffer = new byte[4096];
			 while ((len = is.read(buffer, 0, buffer.length)) != -1) {
	                baos.write(buffer, 0, len);
	            }
			 return baos;
		} catch (IOException ioe) {
			logger.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException ase) {
          logger.info("sCaught an AmazonServiceException from GET requests, rejected reasons:");
          logger.info("Error Message:    " + ase.getMessage());
          logger.info("HTTP Status Code: " + ase.getStatusCode());
          logger.info("AWS Error Code:   " + ase.getErrorCode());
          logger.info("Error Type:       " + ase.getErrorType());
          logger.info("Request ID:       " + ase.getRequestId());
          throw ase;
        } catch (AmazonClientException ace) {
          logger.info("Caught an AmazonClientException: ");
          logger.info("Error Message: " + ace.getMessage());
          throw ace;
        }
    
		return null;
	}

	//send endpoint to database
	@Override
	public void uploadFile(String keyName, MultipartFile file) {
		   try {
			      ObjectMetadata metadata = new ObjectMetadata();
			      metadata.setContentLength(file.getSize());
			      s3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
			      endpoint = "https://spice-sm.s3.us-east-2.amazonaws.com" + "/" + keyName;
			      objectKey = keyName;

			      
			    } catch(IOException ioe) {
			      logger.error("IOException: " + ioe.getMessage());
			    } catch (AmazonServiceException ase) {
			      logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			      logger.info("Error Message:    " + ase.getMessage());
			      logger.info("HTTP Status Code: " + ase.getStatusCode());
			      logger.info("AWS Error Code:   " + ase.getErrorCode());
			      logger.info("Error Type:       " + ase.getErrorType());
			      logger.info("Request ID:       " + ase.getRequestId());
			      throw ase;
			        } catch (AmazonClientException ace) {
			            logger.info("Caught an AmazonClientException: ");
			            logger.info("Error Message: " + ace.getMessage());
			            throw ace;
			        }
		
	}

	@Override
	public List<String> listFiles() {
		 ListObjectsRequest listObjectsRequest = 
	              new ListObjectsRequest()
	                    .withBucketName(bucketName);
	                    //.withPrefix("test" + "/");
	    
	    List<String> keys = new ArrayList<>();
	    
	    ObjectListing objects = s3Client.listObjects(listObjectsRequest);
	    
	    while (true) {
	      List<S3ObjectSummary> summaries = objects.getObjectSummaries();
	      if (summaries.size() < 1) {
	        break;
	      }
	      
	      for (S3ObjectSummary item : summaries) {
	              if (!item.getKey().endsWith("/"))
	                keys.add(item.getKey());
	          }
	      
	      objects = s3Client.listNextBatchOfObjects(objects);
	    }
	    
	    return keys;
	}
	
	
	
}
