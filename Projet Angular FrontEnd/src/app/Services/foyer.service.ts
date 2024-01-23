import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Foyer } from 'src/app/Models/Foyer';
import { BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Universite } from '../Models/Universite';


@Injectable({
  providedIn: 'root'
})
export class FoyerService {

  private apiUrl = "http://localhost:8081/PremierProjetTest/Foyer/retrieve-all-Foyers";
 // private apiUrl = 'http://localhost:8089/GestionFoyer/foyer/all'; 

  
  private modificationReussieMessageSource = new BehaviorSubject<string>('');
  modificationReussieMessage$ = this.modificationReussieMessageSource.asObservable();



  constructor(private http: HttpClient) {}

  getFoyers(): Observable<Foyer[]> {
    const headers =new HttpHeaders({'Content-Type':'application/json','Access-Control-Allow-Origin': 'http://localhost:4200'});

    return this.http.get<Foyer[]>(this.apiUrl,{headers});
  }

  ajouterFoyer(foyer: Foyer): Observable<Foyer> {
    const ajouterEndpoint = 'http://localhost:8081/PremierProjetTest/Foyer/add-Foyer'; // Endpoint pour ajouter un foyer
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });

    return this.http.post<Foyer>(ajouterEndpoint, foyer, { headers });
  }

  supprimerFoyer(idFoyer: number): Observable<void> {
    const supprimerEndpoint = `http://localhost:8081/PremierProjetTest/Foyer/remove-Foyer/${idFoyer}`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
  
    return this.http.delete<void>(supprimerEndpoint, { headers });
  }

  getFoyerById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  

  
  informerModificationReussieMessage(message: string): void {
    this.modificationReussieMessageSource.next(message);
  }  


  // Méthode pour effectuer la modification d'un foyer
  modifierFoyer(foyer: Foyer): Observable<Foyer> {
    const modifierEndpoint = `http://localhost:8081/PremierProjetTest/Foyer/modify-Foyer`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
  
    return this.http.put<Foyer>(modifierEndpoint, foyer, { headers }).pipe(
      tap(response => {
        console.log('Foyer modifié avec succès', response);
        // Informez les abonnés du message de modification réussie
        this.informerModificationReussieMessage('Foyer modifié avec succès');
      })
    );
  }

  getUniversites(): Observable<Universite[]> {
  const universiteApiUrl = "http://localhost:8081/PremierProjetTest/Universite/retrieve-all-Universites"; // Replace with your actual URL
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
 });

  return this.http.get<Universite[]>(universiteApiUrl, { headers });
}


  
}




