import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PhoneComponent} from './component/phone/phone.component';

const routes: Routes = [
  {path: 'phone', component: PhoneComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
