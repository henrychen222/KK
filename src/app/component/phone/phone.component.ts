import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {PhoneService} from '../../service/phone.service';
import {Combination} from '../../model/combination';
import {FormControl, Validators} from '@angular/forms';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css']
})
export class PhoneComponent implements OnInit {

  combinationList: Combination;
  count: string;
  combination: any[];

  displayedColumns: string[] = ['combination'];
  dataSource: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  paginatorLength: number;

  inputFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(7),
    Validators.maxLength(10)
  ]);

  constructor(private ps: PhoneService) {
  }

  ngOnInit() {

  }

  fetchCombination(): void {
    // const pn = '240 386 6106';
    const combination$ = this.ps.getCombination(this.inputFormControl.value);
    combination$.subscribe(reps => {
      this.combinationList = reps;
      console.log(this.combinationList);
      this.getCount();
      this.getCombination();
      this.build();
    });
  }

  getCount(): void {
    this.count = this.combinationList[0].count.toString();
  }

  getCombination(): void {
    const combination: string = this.combinationList[0].combination;
    console.log(combination);

    // this.combination = JSON.parse(JSON.stringify(this.combinationList[0].combination)); // string to array
    this.combination = combination.substring(1, combination.length - 1).split(', ');
    console.log(this.combination);
  }

  build(): void {
    const data: any[] = [];
    for (const i of this.combination) {
      data.push({
        combination: i
      });
    }
    console.log(data);
    this.dataSource = new MatTableDataSource(data);
    console.log(this.dataSource);

    // Paginator control
    this.paginatorLength = data.length;
    this.dataSource.paginator = this.paginator;
  }

}
