import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bloc } from '../Models/Bloc';
import { Observable } from 'rxjs';
import { Foyer } from '../Models/Foyer';


const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
    providedIn: 'root'
})
export class CrudService {
     apiUrl = "http://localhost:8081/PremierProjetTest/Bloc";
    apiUrlFoyer = "http://localhost:8081/PremierProjetTest/Foyer";
    constructor(private http: HttpClient) { }
    addBloc(bloc: Bloc) {
        return this.http.post<any>(this.apiUrl + "/add-Bloc", bloc, httpOptions);
    }
    deleteBloc(id: number) {
        const url = `${this.apiUrl + "/remove-Bloc"}/${id}`
        return this.http.delete(url, httpOptions)
    }
    getBlocs() {
        return this.http.get<Bloc[]>(this.apiUrl + "/retrieve-all-Blocs");
    }
    getListFoyers() {
        return this.http.get<Foyer[]>(this.apiUrlFoyer + "/retrieve-all-Foyers");

    }
    findBlocById(id: number): Observable<Bloc> {
        const url = `${this.apiUrl }/${id}`;
        return this.http.get<Bloc>(url, httpOptions)
    }
    updateBloc(id: number, bloc: Bloc) {
        const url = `${this.apiUrl + "/modify-Bloc"}/${id}`
        return this.http.put<any>(url, bloc);
    }
}
