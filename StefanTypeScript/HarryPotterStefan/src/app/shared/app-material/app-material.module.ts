import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
// import {
//   MatToolbarModule,
//   MatIconModule,
//   MatButtonModule,
//   MatMenuModule,
//   MatCardModule,
//   MatFormFieldModule,
//   MatInputModule,
//   MatDatepickerModule,
//   MatNativeDateModule,
//   MatSelectModule,
//   MatListModule,
//   MatDialogModule,
//   MatCheckboxModule,
//   MatAutocompleteModule,
//   MatSnackBarModule,
//   MatExpansionModule,
//   MatBadgeModule,
//   MatTableModule,
//   MatGridListModule
// } from '@angular/material';

@NgModule({
  imports: [CommonModule],
  exports: [
    MatToolbarModule,
    // MatIconModule,
    // MatButtonModule,
    // MatMenuModule,
    // MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    // MatDatepickerModule,
    // MatNativeDateModule,
    // MatSelectModule,
    // MatListModule,
    // MatDialogModule,
    // MatCheckboxModule,
    // MatAutocompleteModule,
    // MatSnackBarModule,
    // MatExpansionModule,
    // MatTooltipModule,
    // MatBadgeModule,
    // MatTableModule,
    // MatGridListModule
  ],
  declarations: [],
  providers: [{ provide: MAT_DATE_LOCALE, useValue: 'de-DE' }]
})
export class AppMaterialModule { }
