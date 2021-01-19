import{ Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'reverse' })
export class Reversepipe implements PipeTransform{
    transform(value){
        return value.slice().reverse();
    }
}
