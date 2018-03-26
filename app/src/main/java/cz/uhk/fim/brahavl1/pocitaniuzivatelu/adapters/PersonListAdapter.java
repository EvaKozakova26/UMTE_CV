package cz.uhk.fim.brahavl1.pocitaniuzivatelu.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cz.uhk.fim.brahavl1.pocitaniuzivatelu.Editor;
import cz.uhk.fim.brahavl1.pocitaniuzivatelu.MainActivity;
import cz.uhk.fim.brahavl1.pocitaniuzivatelu.Person;
import cz.uhk.fim.brahavl1.pocitaniuzivatelu.R;

/**
 * Created by brahavl1 on 12.03.2018.
 */

//bude to spravovat jeden radek seznamu, toho podtim

    //view holder děla vlastni radek
    //person adapter to cely
public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.PersonViewHolder> {


    private List<Person> persons;

    public PersonListAdapter (List<Person> persons){
        super();
        this.persons = persons;
    }

    @Override
    //tad vytvarim radek
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //taha to vytvorenej linear layout, kterej jsme si udelali v layoutech - konkretne item_person
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, null);

        //tohle pošleme do te verejne tridy dole
        PersonViewHolder personViewHolder = new PersonViewHolder(itemView);
        return personViewHolder;
    }

    @Override//vola se pokazdy, kdy rolujeme
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person p = persons.get(position);
        holder.textViewName.setText(p.getName());
        holder.textViewAge.setText("Vek: " + p.getName());
        holder.textViewMale.setText(p.isMale() ? "Chlap" : "Zenska");

        if (p.isMale()){
            holder.textViewName.setTextColor(0xFF00FF00);

        }
        //TODO

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName, textViewAge, textViewMale; //tady muze byt colikov z view

        public PersonViewHolder(View itemView){ //sem prijde linear layout
            super(itemView); //je to potreba

            //natahneme si z linearu pozadovane editboxy - vime co tam bude - pak se s tim muze pracovat u onbindviewholderu
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewMale = itemView.findViewById(R.id.textViewMale);
            //this.textViewName = (TextView) itemView;

        }
    }


}
