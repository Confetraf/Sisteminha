import { Component } from '@angular/core';
import { SharedMaterialModule } from '../../shared-material/shared-material.module';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-header',
  imports: [SharedMaterialModule, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  menuAberto = false;

  toggleMenu() {
    this.menuAberto = !this.menuAberto;
  }
}
