package com.rdf.jena;

import javax.xml.validation.Schema;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.SchemaDO;


public class TpRdf {
	public static void main(String[] args) {
		//Déclaration de varaibles
		String uriMozart,uriEpouse,uriFather,uriAutriche, uriVienna, uriSalzburg,uriJupiter,uriFluteEnch,
		uriOrchestreSymph,uriDirectionOrchestre,uriLondon,uriJupiterP1,uriJupiterP2,uriJupiterP3,uriJupiterP4,uriAngleterre,uriRecord;
		//Initialisation
		uriMozart="https://dbpedia.org/page/Wolfgang_Amadeus_Mozart";
		uriEpouse="https://dbpedia.org/page/Constanze_Mozart";
		uriFather="https://dbpedia.org/page/Leopold_Mozart";
		uriAutriche="http://fr.dbpedia.org/resource/Autriche";
		uriVienna="http://dbpedia.org/resource/Vienna";
		uriSalzburg="http://dbpedia.org/resource/Salzburg";
		uriLondon="https://dbpedia.org/page/London";
		uriAngleterre="http://fr.dbpedia.org/page/Angleterre";
		uriJupiter="https://dbpedia.org/page/Symphony_No._41_(Mozart)";
		uriFluteEnch="https://dbpedia.org/page/The_Magic_Flute";
		uriOrchestreSymph="https://dbpedia.org/page/BBC_Symphony_Orchestra";
		uriDirectionOrchestre="https://dbpedia.org/page/Claudio_Abbado";
		uriJupiterP1="https://dbpedia.org/page/Symphony_No._41_(Mozart)__Sound__1";
		uriJupiterP2="https://dbpedia.org/page/Symphony_No._41_(Mozart)__Sound__2";
		uriJupiterP3="https://dbpedia.org/page/Symphony_No._41_(Mozart)__Sound__3";
		uriJupiterP4="https://dbpedia.org/page/Symphony_No._41_(Mozart)__Sound__4";
		uriRecord="https://schema.org/MusicRecording";


		Model model= ModelFactory.createDefaultModel();

		model.createResource(uriJupiter).
		addProperty(SchemaDO.name, "la 41 Symphonie en ut majeur ").
		addProperty(SchemaDO.alternateName, "Jupiter ").
		addProperty(SchemaDO.datePublished, "1980").
		addProperty(SchemaDO.composer, model.createResource(uriMozart).
				addProperty(SchemaDO.givenName, "Wolfgang Amadeus ").
				addProperty(SchemaDO.familyName, "Mozart").
				addProperty(SchemaDO.birthDate,  "1756-01-27").
				addProperty(SchemaDO.deathDate , "1791-12-05").
				addProperty(SchemaDO.birthPlace, model.createResource(uriVienna)).
				addProperty(SchemaDO.birthPlace, model.createResource(uriVienna)).
				addProperty(SchemaDO.deathPlace, model.createResource(uriSalzburg)).
				addProperty(SchemaDO.spouse,model.createResource(uriEpouse)).
				addProperty(SchemaDO.parent, model.createResource(uriFather)).	
				addProperty(SchemaDO.creativeWorkStatus , model.createResource(uriJupiter)).
				addProperty(SchemaDO.creativeWorkStatus, model.createResource(uriFluteEnch)).
				addProperty(RDF.type, model.createResource(SchemaDO.Person))).
		addProperty(SchemaDO.subEvent, model.createResource(uriRecord).
				addProperty(RDF.type, SchemaDO.Event).
				addProperty(SchemaDO.director, model.createResource(uriDirectionOrchestre).
														addProperty(FOAF.givenName, "Claudio ").
														addProperty(FOAF.familyName, "Abbado").
														addProperty(RDF.type,SchemaDO.Person).
														addProperty(SchemaDO.jobTitle,SchemaDO.director)).
				addProperty(SchemaDO.location,model.createResource(uriLondon).
						addProperty(SchemaDO.name, "London").
						addProperty(RDF.type, model.createResource(SchemaDO.City))).
				addProperty(SchemaDO.dateCreated, "1980").
				addProperty(SchemaDO.byArtist,model.createResource(uriOrchestreSymph).
							addProperty(RDF.type, SchemaDO.Event).
							addProperty(SchemaDO.name, "L'orchestre symphonique de Londre").
							addProperty(SchemaDO.isBasedOn, model.createResource(uriLondon)))).
		addProperty(RDF.type,model.createResource(SchemaDO.MusicComposition)).
		addProperty(SchemaDO.genre, model.createResource("https://dbpedia.org/page/Symphony")).
		addProperty(SchemaDO.musicalKey, model.createResource("https://dbpedia.org/page/C_major").
				addProperty(RDF.type, SchemaDO.musicalKey)).
		addProperty(SchemaDO.includedComposition, model.createResource(uriJupiterP1).
				addProperty(SchemaDO.name, "Allegro Vivace ").
				addProperty(SchemaDO.isPartOf, model.createResource(uriJupiter)).
				addProperty(RDF.type, model.createResource(SchemaDO.MusicComposition))).
		addProperty(SchemaDO.includedComposition, model.createResource(uriJupiterP2).
				addProperty(SchemaDO.name, "Andante Cantabile").
				addProperty(SchemaDO.isPartOf, model.createResource(uriJupiter)).
				addProperty(RDF.type, model.createResource(SchemaDO.MusicComposition))).
		addProperty(SchemaDO.includedComposition, model.createResource(uriJupiterP3).
				addProperty(SchemaDO.name, "Menuetto").
				addProperty(SchemaDO.isPartOf, model.createResource(uriJupiter)).
				addProperty(RDF.type, model.createResource(SchemaDO.MusicComposition))).
		addProperty(SchemaDO.includedComposition, model.createResource(uriJupiterP4).
				addProperty(SchemaDO.name, "Molto Allegro").
				addProperty(SchemaDO.isPartOf, model.createResource(uriJupiter)).
				addProperty(RDF.type, model.createResource(SchemaDO.MusicComposition)));

		System.out.println("######################################################################################################  Résultat en RDF/XML   ####################################################################################################");
		model.write(System.out,"RDF/XML");
		System.out.println();
		System.out.println();
		System.out.println("--------################################################################################  Résultat en Turtle  ########################################################################################################################");
		model.write(System.out,"Turtle");
		System.out.println();
		System.out.println();
		System.out.println("######################################################################################################  Résultat en RDF/XML-ABREV ####################################################################################################");

		model.write(System.out, "RDF/XML-ABBREV");
		System.out.println();
		System.out.println();
		System.out.println("######################################################################################################  Résultat en N-TRIPLE ####################################################################################################");
		model.write(System.out, "N-TRIPLE");
		System.out.println();
		System.out.println();
		System.out.println("######################################################################################################  Résultat en JSON ####################################################################################################");
		
		model.write(System.out, "JSON-LD");
										
			
	}

}
