import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../login.component';
import { LayoutComponentComponent } from 'src/app/layout-component/layout-component.component';

const routes: Routes = [
    {
      path: 'login',
      component: LayoutComponentComponent,
      children: [
        { path: '', component: LoginComponent },
        
      ],
    },
    { path: '', redirectTo: '/login', pathMatch: 'full' },
  ];

  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
  })
  export class LoginRoutingModule {}