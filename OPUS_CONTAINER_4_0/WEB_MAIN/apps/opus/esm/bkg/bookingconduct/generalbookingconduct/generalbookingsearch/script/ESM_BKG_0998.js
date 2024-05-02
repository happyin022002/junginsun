/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0998.js
*@FileTitle : Constraints
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */

    /**
     * @extends 
     * @class esm_bkg_0998 : esm_bkg_0998 - task script definition for screen
     */
    function esm_bkg_0998() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	

 // public variable
 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
          var sheetObject1 = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
 			switch(srcName) {
 				case "btn_Close":
 					window.close();
 					break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }

     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }



     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }	
 		
     }

   	 function sheet1_OnLoadFinish(sheetObj) {   
 		sheetObj.WaitImageVisible = false;   
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		sheetObj.WaitImageVisible = true;   
 	 }             

   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

             case "sheet1":
                 with (sheetObj) {

                     // setting height
                     style.height = 102;
                     
                     //setting width
                     SheetWidth = mainTable.clientWidth;

                     //setting Host information[mandatory][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //Merge kind [Default msNone]
                     MergeSheet = msHeaderOnly;

                    //Edit kind [Default false]
                     Editable = true;

                     //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

 					var HeadTitle1 = "|T.Lane|POL|Lane|1st T/S|1st T/S|2nd T/S|2nd T/S|POD / Node|POD / Node|DEL|Remarks";
 					var HeadTitle2 = "|T.Lane|POL|Lane|Port|Lane|Port|Lane|Location|Node|DEL|Remarks";
 					var headCount = ComCountHeadTitle(HeadTitle1);

                     //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // setting Header Mode
                     InitHeadMode(true, true, false, true, false,false)

                     //setting Header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                    
                     //data attribute    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,		0,    	daCenter,  true,    	"ibflag");
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"slan_cd",				false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"pol_cd",				false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"trnk_lane_cd",		false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"n1st_lane_cd",		false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"n1st_ts_port_cd",	false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"n2nd_lane_cd",		false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"n2nd_ts_port_cd",	false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	true,		"pod_cd",				false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"pod_nod_cd",		false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		"del_cd",				false,		"",			dfNone,		0,			false,		false);
			 		 InitDataProperty(0, cnt++ , dtData,					50,	daLeft,		true,		"rout_cnst_rmk",		false,		"",			dfNone,		0,			false,		false);
 					
			 		 CountPosition = 0;
 				}
 				break;
         }
     }

   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 			case IBSEARCH:      //retrieve
            	formObj.f_cmd.value = SEARCH;
            	sheetObj.DoSearch("ESM_BKG_0998GS.do" , FormQueryString(formObj));
 			break;
         }
     }

	