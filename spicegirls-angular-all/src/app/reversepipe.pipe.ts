import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reversepipe'
})
export class ReversepipePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any{
    return value.slice().reverse();
  }

}
