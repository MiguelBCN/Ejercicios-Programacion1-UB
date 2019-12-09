import java.sql.SQLOutput;

public class LloguerCotxes {
    /*

    A continuació feu una classe (LloguerCotxes) que permetra guardar un conjunt
de cotxes, i les opcions del menú seran:
• Afegir cotxe: demanarà les dades del nou cotxe i l'afegirà al conjunt de cotxes.
• Veure cotxes disponibles: mostrarà informació dels cotxes no llogats.
• Veure cotxes llogats: mostrarà informació dels cotxes llogats, mostrant per a
cadascun d'ells els dies que està llogat.
• Esborrar cotxe: mostrarà informació dels cotxes disponibles, amb el seu ID (els
cotxes llogats no els podem eliminar). A continuació, donat l’ID, s'eliminarà el
cotxe amb aquest identificador.
• Llogar cotxe: mostrarà informació dels cotxes disponibles, cadascun amb el seu
ID. A continuació es demanarà el ID del cotxe a llogar i el número de dies que es
desitja llogar. El cotxe quedarà com a llogat des d'aquell moment.
• Lliurar cotxe: mostrarà els cotxes llogats, cadascun amb el seu ID. A continuació.
Es demanarà el ID del cotxe a lliurar. El cotxe quedarà com a disponible des
d'aquell moment.
• Veure preu de lloguer: mostrarà informació dels cotxes llogats, cadascun amb el
seu ID. A continuació es demanarà el ID del cotxe a veure i es mostrarà el preu
total del seu lloguer.

*/
    public static void main(String[] args) {
        TaulaCotxe tablaCoche;
        


    }
    static void imprimirMenu(){
        System.out.println("---MENU---");
        System.out.println("1.-Añadir coche");
        System.out.println("2.-Ver coches disponibles");
        System.out.println("3.-Ver coches alquilados");
        System.out.println("4.-Borrar coche");
        System.out.println("5.-Alquilar coche");
        System.out.println("6.-Liberar coche");
        System.out.println("7.-Ver precio de alquiler");
    }
}

    class Cotxe {
        /*
        Definiu una classe Cotxe amb els següents atributs i els següents mètodes:
        Atributs
        • int iD;
        • String marca;
        • String model;
        • String color;
        • float preuPerDia;
        • boolean llogat;
        • int numDiesLloguer;
*/
        int iD;
        String marca;
        String model;
        String color;
        float preuPerDia;
        boolean llogat;
        int numDiesLloguer;

        public Cotxe(int iD, String marca, String model, String color, float preuPerDia, boolean llogat, int numDiesLloguer) {
            this.iD = iD;
            this.marca = marca;
            this.model = model;
            this.color = color;
            this.preuPerDia = preuPerDia;
            this.llogat = llogat;
            this.numDiesLloguer = numDiesLloguer;
        }

        boolean estaLlogat() {
            //veure si el cotxe està llogat.
            return this.llogat;
        }

        void llogar(int numDiesLloguer) {
            //llogar el cotxe el nombre de dies indicats al parèmetre numDiesLloguer.
            this.numDiesLloguer = numDiesLloguer;
        }

        float getPreuTotalLloguer() {
            //obtenir preu total del lloguer (multiplica el preu de lloguer pel número de dies que s'ha llogat el cotxe).
            return this.preuPerDia * this.numDiesLloguer;
        }


    }


    /*Per guardar el conjunt de cotxes, definiu la classe TaulaCotxe que emmagatzema
    un conjunt de cotxes (màxim seran 100). En aquesta classe tindreu els següents
    mètodes:*/
    class TaulaCotxe {

        Cotxe[] coches;
        int limit;
        int totalAutos;

        public TaulaCotxe(int limit) {
            //TaulaCotxe(int limit), mètode constructor.
            this.coches = new Cotxe[limit];
            this.limit=limit;
            totalAutos=0;
        }

        void afegir(String marca, String model, String color, float preu) {
            //mètode per afegir un nou cotxe al conjunt de cotxes.
            coches[totalAutos]  = new Cotxe(totalAutos, marca, model, color, preu, false, 0);
            totalAutos++;
            System.out.printf("Se a añadido correctamente el auto con el id:%s ,marca:%s ,modelo:%s ,color:%s ,precio por dia:",totalAutos,marca,model,color,preu);
        }

        void veurePreu(int id) {
            //mètode per veure el preu total del lloguer del cotxe amb l’id indicat al paràmetre.
            System.out.println(coches[id].preuPerDia);
        }

        void llogar(int id, int dies) {
            //mètode per llogar un cotxe amb l’id indicat al paràmetre, i un nombre de dies, dies.
            coches[id].llogat=true;
            coches[id].numDiesLloguer=dies;
            System.out.printf("El auto con la id: %s se ha alquilado correctamente por %s dias%n",id,dies);
        }

        void lliurar(int id) {
            //mètode per lliurar un cotxe a partir del seu id.
            coches[id].llogat=false;
            coches[id].numDiesLloguer=0;
            System.out.printf("El auto con la id: %s se ha libreado correctamente%n",id);
        }

        void esborrar(int id) {
            /*mètode per esborrar un cotxe del conjunt, amb id
        indicat al paràmetre. Quan s’esborra un cotxe de l’array, aquest array s’ha de
        quedar sense “buits”. Això vol dir que s’han de desplaçar tots els elements de
        l’array (que estaven a la dreta del cotxe a esborrar) per a ocupar l’espai que deixa
        aquest cotxe.*/
            //NOTA:Entonces


        }

        void veureDisponibles() {
            //mètode per llistar els IDs de tots els cotxes que estiguin disponibles en el conjunt.
            for (int i = 0; i <coches.length ; i++) {
                if (!coches[i].llogat){
                    System.out.println("La id de los autos disponibles es :");
                    System.out.print(coches[i].iD+" ");

                }
            }
            System.out.println();
        }

        void veureLlogats() {
            //mètode per llistat els IDs de tots els cotxes que estan llogats del conjunt de cotxes.
            for (int i = 0; i <coches.length ; i++) {
                if (coches[i].llogat){
                    System.out.println("La id de los autos ya alquilados es :");
                    System.out.print(coches[i].iD+" ");
                }
            }
            System.out.println();
        }

    }




