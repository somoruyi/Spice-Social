import { Component, OnInit } from '@angular/core';
import { UploadService } from '../../upload.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-upload',
  templateUrl: './list-upload.component.html',
  styleUrls: ['./list-upload.component.css']
})
export class ListUploadComponent implements OnInit {

  showFile = false;
  fileUploads: Observable<string[]>;

  constructor(private uploadService:UploadService) { }

  ngOnInit(): void {
  }

  showFiles(enable: boolean){
    this.showFile = false;

    if(enable){
      // this.fileUploads = this.uploadService.getFiles();
    }
  }


}
