import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EquipmentCreateComponent } from './Equipment/equipment-create/equipment-create.component';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CatalogComponent } from './Equipment/catalog/catalog.component';
import { TopNavBarComponent } from './top-nav-bar/top-nav-bar.component';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { EditComponent } from './Equipment/edit/edit.component';
import { CommandComponent } from './Command/command/command.component';




const appRoutes: Routes = [
  { path: 'EquipmentCreate', component: EquipmentCreateComponent },
  {path: 'catalog', component: CatalogComponent },
  {path: 'command', component: CommandComponent },
  {path: 'aboutUs', component: AboutUsComponent },
  {path: 'edit', component: EditComponent },
  
];

@NgModule({
  declarations: [
    AppComponent,
    EquipmentCreateComponent,
    CatalogComponent,
    TopNavBarComponent,
    CommandComponent,
    AboutUsComponent,
    EditComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule ,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true , onSameUrlNavigation: 'reload'} // <-- debugging purposes only
      
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
