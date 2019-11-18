import { TestBed, async } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { AppMaterialModule } from './shared/app-material/app-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { HarryPotterComponent } from './harry-potter/harry-potter.component';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [BrowserAnimationsModule, FormsModule, AppMaterialModule],
      declarations: [
        AppComponent, HarryPotterComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });
});
