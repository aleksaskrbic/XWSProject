import { Component, OnInit } from '@angular/core';
import { JobOffer } from '../model/JobOffer';
import { JobsService } from '../service/jobs.service';

@Component({
  selector: 'app-create-job-offer',
  templateUrl: './create-job-offer.component.html',
  styleUrls: ['./create-job-offer.component.css']
})
export class CreateJobOfferComponent implements OnInit {

  newOffer: JobOffer;
  newOffers: JobOffer[];  
  
  listOfQualifications:string = '';
  listOfactivities: string = '';

  constructor(private jobsService: JobsService) 
  {
      this.newOffer = new JobOffer
      (
        {
          id:0,
          position: "",
          description: "",
          daily_activities: [],
          qualifications: []

        }
      )
 

  }

  ngOnInit(): void 
  {
     this.CreateJobOffer();
  }


  CreateJobOffer()
  {
    console.log(this.newOffer)
    this.newOffer.qualifications = this.listOfQualifications.split(",");
    this.newOffer.daily_activities = this.listOfactivities.split(",");
    this.jobsService.createNewOffer(this.newOffer)

    .subscribe(res => {this.newOffer = res})

  }

  //Dodavanje Listi za Konverziju kvalifikacija i dnevnih aktivnosti

  insertQualificationsIntoString(qualifications: string[])
  {
    var listQualifications:string[]=[];
    qualifications.forEach(function(lan:string)
    {
      listQualifications.push(lan);
    })

    this.listOfQualifications = listQualifications.join(",");
  }


  insertDailyActivitiesIntoString(daily_activities: string[])
  {
    var listActivities:string[]=[];
    daily_activities.forEach(function(lan:string)
    {
      listActivities.push(lan);
    })

    this.listOfQualifications = listActivities.join(",");
  }

}
