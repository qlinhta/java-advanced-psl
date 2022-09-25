package fr.dauphine.javaavance.td2;/*

EXO 1 :

1/ Cela affiche :
    42 //normal
    42 //normal
    24 //normal car valeur de meth() dans la classe Fille est = 24
    24 // la classe Fille est une sous-classe de la classe Mère donc il a hérité la méthode printMeth() ;
    24 //normal car la variable mereFille est un objet de classe Fille donc la valeur de meth() = 24
    24 // la classe Fille est une sous-classe de la classe Mère donc il a hérité la méthode printMeth() ;

2/
    S’il est dans la classe Fille, il a accès à 2 méthode meth(). Pour l’utiliser celle dans la classe Mère, il faut utiliser le mot clé « super »
    S’il est dans la classe Main, il a accès qu’à la méthode meth() de la classe Fille

3/
    Si elle devient une méthode statique, la méthode « meth() » ne s’agit pas sur des variables d’instance mais que sur des variables de classes.
    Le mot clé « instant » garantit qu'une seule instance d'une méthode d'objet ou d'une variable concernée est créée en mémoire.
    Lors qu’on met le mot static, il faut changer la syntaxe lors des appels de la méthode : ClassName.VariableName.
    La classe Main devient :
        public static void main(String[] args) {
                Mere mere = new Mere();
                System.out.println(Mere.meth());
                mere.printMeth();
                Fille fille = new Fille();
                System.out.println(Fille.meth());
                fille.printMeth();
                Mere mereFille = new Fille();
                System.out.println(Fille.meth());
                mereFille.printMeth();
    Ca affiche donc :
    42
    42
    24
    42
    24
    42
    La méthode meth() appelée vient de la classe Mère donc à chaque appel de la méthode printMeth(), ça renvoie la valeur 42
4/
    Cela ne change rien en termes d’affichage. La méthode printMeth() comprend qu'elle doit
    prendre la valeur du champ meth de sa classe. Et le mot clé « static » » garantit qu'une seule instance d'une
    méthode d'objet ou d'une variable concernée est créée en mémoire. Donc il a gardé la première déclaration dont la valeur = 42

EXO2

1/
    Dans la classe Fille, les erreurs viennent des méthodes:
    -	private void e()  à cause de la visibilité
    -	char h(),int i(). Car dans sa super classe qui est la classe Mère, ce n’est pas le même type de valeur renvoyée.
    La méthode h() est censé de renvoyer un int et i() n’est censé de ne rien renvoyer.
    -	void k(). Car le type de throw clause n’est pas compatible avec celui de sa super classe
    Dans la classe Main , les erreurs viennent des méthodes :
    -	a(),b(),c(),d(),printF(),j(),k(),l(),m(), miage() car elles n’ont pas été déclarées dans la classe Mere

2/
    •	Classe Mère
    public void a() //Redéfinition
    void b(Fille fille) //Redéfinition
    void c() //Surchage
    void c(Mere mere) // Surcharge
    static void d() //Redéfinition
    private void f() //Redéfinition

    •	Classe Fille
    public void a() //Redéfinition avec sa super classe Mere
    protected void b(Fille fille) //Redéfinition avec sa super classe Mere
    public void c(Mere mere) //Redéfinition avec sa super classe Mere
    void c(Fille b) //Redéfinition avec sa super classe Mere
    static void d() //Redéfinition avec sa super classe Mere
    static void d(Mere mere) //Surcharge
    protected void f() //Redéfinition avec sa super classe Mere

3/

    fille.miage(); //Miage
    ((Fille)mereFille).miage();	//Miage
    fille.a();//Fille_a

    mereFille.c();//Mere_c
    mereFille.c(mere); //Fille_c(Mere)
    mereFille.c(mereFille);// Fille_c(Mere)
    mereFille.c(fille); //Fille_c(Mere)

    mere.d(); // static Mere_d
    mereFille.d();// static Mere_d

    mere.printF();//Mere_f
    mereFille.printF();//Mere_f

    mereFille.j(); //Fille_j
    mereFille.k(); //Mere_k
    mereFille.l(); //Fille_l
    mereFille.m(); //Fille_m

    //Toutes ces méthodes appelées par mereFille sont celles de classe Fille héritées de sa super classe


 */


