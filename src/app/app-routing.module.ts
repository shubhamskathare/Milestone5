import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { CreateVehicleComponent } from './create-vehicle/create-vehicle.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';
import {  VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';


const routes: Routes = [
  {path: 'vehicles', component:  VehicleListComponent},
  {path:'create-vehicle', component:CreateVehicleComponent},
  {path: '', redirectTo: 'vehicles', pathMatch: 'full'},
  {path:'update-vehicle/:id',component:UpdateVehicleComponent},
  {path:'vehicle-details/:id', component: VehicleDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
