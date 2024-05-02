/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_9425.js
*@FileTitle  : MTY BKG Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    
   	/* Developer Work	*/

	// global variable

	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	
	var comboObjects=new Array();
	var comboCnt=0;
	
	 // Event handler processing by button click event */ 
	 document.onclick=processButtonClick;
	 
	 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject=sheetObjects[0];
          /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 		         case "btn_Retrieve":
 	          		 doActionIBSheet(sheetObject,formObject,SEARCH);
                     break;
 		        case "btn_New":
 		        	ComResetAll();
 		        	setInitData();
                    break;
 		        case "btn_Cntr":
 		        	if(sheetObject.RowCount()< 1){
 		        		ComShowCodeMessage("BKG00567");
 		        	}else{
 		        		var bkgNo=sheetObject.GetCellValue(sheetObject.GetSelectRow(), "bkg_no");
 	 		        	ComOpenPopup("ESM_BKG_9450.do?pgmNo=ESM_BKG_9450&bkg_no="+bkgNo, 520, 520, "","0,1,1,1,1,1", true); 		        		
 		        	}
                    break;
		        case "btns_Calendar": //calendar button
	            	var cal=new ComCalendarFromTo();
	            	cal.select(formObject.cre_from_dt,formObject.cre_to_dt, 'yyyy-MM-dd');
	            	break;	
		        case "btn_Update":
		        	var bkgno="";
		        	var bkgdiv="";
		        	var selRow="";
		        	var sheetObj=sheetObjects[0];
		        	if(sheetObj.RowCount()> 0) {
		        		selRow=sheetObj.GetSelectRow();   // 선택된 ROW
		        		if(selRow != null) {
		        			bkgno=sheetObj.GetCellValue(selRow, "bkg_no");  // lane copy
		        		}
		        	}
		        	var param = "";
		        	param = "?pop_mode=Y&mainPage=false&pgmNo=ESM_BKG_9424&bkgno="+bkgno;
		        	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_9424_POP.do'+ param, 1124, 580, "ESM_BKG_9424", "0,1,1,1,1,1,1", true);
                    break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
         setInitData();
     	 for(var j=0; j<comboObjects.length; j++){
             initCombo(comboObjects[j]);
         }
    	 doActionIBSheet(sheetObjects[2],document.form,INIT);
         initControl();
     }
      /**
       * set Combo
       */
      function initCombo(comboObj) {
      	comboObj.SetMultiSelect(0);
      	//comboObj.UseCode = true;
      	//no support[check again]CLT 	comboObj.LineColor="#ffffff";
      	comboObj.SetColAlign(0, "left");
      	comboObj.SetColAlign(1, "left");
      	comboObj.SetMultiSeparator("|");
      }
      /**
       * Set IBCombo Object In comboObjects array
       * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
       **/
      function setComboObject(combo_obj){
          comboObjects[comboCnt++]=combo_obj;
      }
    function setInitData(){
        var formObj=document.form;       
        var todate=new Date();
        var calToDate=new Date(new Date(Date.parse(todate)-30*1000*60*60*24));
        ComSetObjValue(formObj.cre_from_dt, ""+calToDate.getFullYear()+"-"+ComLpad(calToDate.getMonth()+1,2,"0")+"-"+ComLpad(calToDate.getDate(),2,"0"));
        ComSetObjValue(formObj.cre_to_dt, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
    }
    function initControl() {
    	var formObject=document.form;
      	axon_event.addListenerFormat('keypress','obj_KeyPress',formObject); //- When typing the keyboard
      	axon_event.addListenerForm('beforedeactivate', 'bkg9425_deactivate',  formObject); 
      	axon_event.addListenerForm('click', 'bkg9425_click',    formObject); //- click
      	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }        
	function bkg9425_deactivate(){
		var srcName=ComGetEvent("name");
		var srcValue=event.srcElement.getAttribute("value");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var formObject=document.form;
		if(srcName == "cntr_no1"){
			if (ComChkLen(srcValue, srcMaxLength) == "2") {
    			ComSetObjValue(formObject.f_cmd, SEARCHLIST11);
    			var sXml=sheetObjects[1].GetSearchData("ESM_BKG_9424GS.do?cntr_no="+srcValue, FormQueryString(formObject));
    			if(ComGetEtcData(sXml,"chk_digit") == undefined || ComGetEtcData(sXml,"chk_digit") == ""){
    				ComShowCodeMessage("BKG01028");
    				ComSetObjValue(formObject.cntr_no2,"");
    			}else{
    				ComSetObjValue(formObject.cntr_no2, ComGetEtcData(sXml,"chk_digit"));
    			}    			
			}
			if(ComIsNull(ComGetObjValue(formObject.cntr_no1))){
				ComSetObjValue(formObject.cntr_no2,"");
			}
	    }
	}  
	function bkg9425_click(){
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	if(srcName == "cre_from_dt"){
    		ComSetFocus(formObject.cre_from_dt);
    	}else if(srcName == "cre_to_dt"){
    		ComSetFocus(formObject.cre_to_dt);
    	}
	}
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
            	    with(sheetObj){		                 
		               //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		               var HeadTitle="|Seq.|Booking No.|B/L No.|Ind.|B|T/S|VVD Code|Lane|EMT|POL|POL ETD|POL ATD|POD|POD ETA|POD ATA|TEU|FEU|RHQ OFC|BKG OFC|CNTR Volume|Booking date|CNTR Attach date|D2|D4|D5|D7|R2|R4|R5|F2|F4|F5|O2|O4|A2|A4|S2|S4|Remarks";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ind",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bundle",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"ts",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"emt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"pol_etd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"pol_atd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"pod_eta_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"pod_ata_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"teu",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"feu",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rsm_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:"cntr_volumn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"booking_date",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_attach_date",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d5",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d7",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"r2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"r4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"r5",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"f2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"f4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"f5",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"a2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"a4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"s2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"s4",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"emt_desc" },
		                      {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ind_desc" } ];
		                
		               InitColumns(cols);		
		               SetEditable(1);
		               SetShowButtonImage(2);
		               //SetSheetHeight(410);
		               resizeSheet();
                 }
                 break;
             case 2:
            	    with(sheetObj){		                 
		               //no support[check again]CLT 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		               var HeadTitle="";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		                
		               InitColumns(cols);		
		               SetEditable(1);
		               SetSheetHeight(300);
             	 }
            	 break;                 
             case 3:
            	 with(sheetObj){	                 
		               //no support[check again]CLT 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		               var HeadTitle="|";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
		                
		               InitColumns(cols);	
		               SetEditable(1);
		               SetSheetHeight(300);
             	 }
            	 break;
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) 
         {
         	case SEARCH:      //Retrieve         		
            	if(validateForm(sheetObj,formObj,sAction)){            		
            		resetData(sheetObj,formObj);
            		ComSetObjValue(formObj.f_cmd, SEARCH);
            		sheetObj.SetWaitImageVisible(0);
            		ComOpenWait(true);             		
            		var sXml=sheetObj.GetSearchData("ESM_BKG_9425GS.do", FormQueryString(formObj));
         			        		
            		sheetObj.LoadSearchData(sXml,{Sync:1} );
            		BkgEtcDataXmlToForm(sXml, formObj);	
         			var teuSum=0;
         			var feuSum=0;        			
         			for(var i=1; i<=sheetObj.RowCount(); i++) {         				
         				teuSum=teuSum + BkgParseInt(sheetObj.GetCellValue(i, "teu"));
         				feuSum=feuSum + BkgParseInt(sheetObj.GetCellValue(i, "feu"));
         			}
         			ComSetObjValue(formObj.sum_teu, teuSum);
         			ComSetObjValue(formObj.sum_feu, feuSum);   
         			ComSetObjValue(formObj.sum_box, teuSum+feuSum);
            	}            	
            	break;
         }
     }
   // data clear.
   function resetData(sheetObj, formObj){
	   sheetObj.RemoveAll();
	   ComSetObjValue(formObj.sum_teu , "0");
	   ComSetObjValue(formObj.sum_feu , "0");
	   ComSetObjValue(formObj.sum_box , "0");
	   ComSetObjValue(formObj.sum_d2 , "0");
	   ComSetObjValue(formObj.sum_d4 , "0");
	   ComSetObjValue(formObj.sum_d5 , "0");
	   ComSetObjValue(formObj.sum_d7 , "0");
	   ComSetObjValue(formObj.sum_r2 , "0");
	   ComSetObjValue(formObj.sum_r4 , "0");
	   ComSetObjValue(formObj.sum_r5 , "0");
	   ComSetObjValue(formObj.sum_f2 , "0");
	   ComSetObjValue(formObj.sum_f4 , "0");
	   ComSetObjValue(formObj.sum_f5 , "0");
	   ComSetObjValue(formObj.sum_o2 , "0");
	   ComSetObjValue(formObj.sum_o4 , "0");
	   ComSetObjValue(formObj.sum_a2 , "0");
	   ComSetObjValue(formObj.sum_a4 , "0");
	   ComSetObjValue(formObj.sum_s2 , "0");
	   ComSetObjValue(formObj.sum_s4 , "0");	   
   }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if(ComIsNull(formObj.bkg_no) && ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd)){
    		 if(ComIsNull(formObj.cre_from_dt)){
    			 ComSetFocus(formObj.cre_from_dt);
    			 ComShowCodeMessage("BKG00819");
    			 return false;
    		 }
    		 if(ComIsNull(formObj.cre_to_dt)){
    			 ComSetFocus(formObj.cre_to_dt);
    			 ComShowCodeMessage("BKG00819");
    			 return false;    			 
    		 }
    		 
    		 //alert(formObj.bkg_ofc_cd);
    		 if(ComIsNull(formObj.cntr_no1)){    			 
    			 //if(ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && "" == formObj.bkg_ofc_cd.GetSelectCode()){
	    		 if(ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && "" == formObj.bkg_ofc_cd){ // GetSelectText()
	    			 ComShowCodeMessage("BKG00820");
	    			 ComSetFocus(formObj.vvd_cd);
	    			 return false;    			     			 
	    		 }
    		 }
    		 
    		 if(ComGetObjValue(formObj.vvd_cd_flg) == "E" && ComIsNull(formObj.vvd_cd)){
    			 ComShowCodeMessage("BKG00115");
    			 ComSetFocus(formObj.vvd_cd);
    			 return false;    			 
    		 }    		 
    		 if(ComGetObjValue(formObj.bkg_date_tp) == "E" && ComIsNull(formObj.pod_cd)){
    			 ComShowCodeMessage("BKG00104","POD");
    			 ComSetFocus(formObj.pod_cd);
    			 return false;    			     			 
    		 }
    	 } else {
    		 if(!ComIsNull(formObj.bkg_no) && formObj.bkg_no.value.length < 11){
    			 ComShowCodeMessage("BKG00835");
    			 ComSetFocus(formObj.bkg_no);
    			 return false;    			 
    		 }
    		 if(!ComIsNull(formObj.bl_no) && formObj.bl_no.value.length != 12){
    			 ComShowCodeMessage("BKG00241");
    			 ComSetFocus(formObj.bl_no);
    			 return false;    			 
    		 }
    		 if(!ComIsNull(formObj.vvd_cd) && formObj.vvd_cd.value.length != 9){
    			 ComShowCodeMessage("BKG00833");
    			 ComSetFocus(formObj.vvd_cd);
    			 return false;    			 
    		 }
    	 }
         return true;
     }
     
     
 	// Search End Event Handling
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{		
 		ComOpenWait(false);
 		var formObject=document.form;
 		if(ErrMsg == ""){
 		}
 	}
 	
 	
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
 	{
 		with(sheetObj){ 			
 			if (GetCellValue(Row,Col) == "Y") {
 				ComOpenPopup("ESM_BKG_9454.do?pgmNo=ESM_BKG_9454&bkg_no="+sheetObj.GetCellValue(Row,"bkg_no"), 600, 480, "","1,0,1,1,1", true);
 			}else { 				
 			   return
 			} 			
 		}
 	}
 	function sheet1_OnMouseMove(sheetObj,Button,Shift, X, Y) 
 	{ 
 		sheetObj.SetToolTipText(0,"ind","S: Sound, H: Hanger rack, D: Damaged");
 		sheetObj.SetToolTipText(0,"bundle","Bundle");
 	}
	/* Developer Work End */
 	
 	function resizeSheet(){
 	        ComResizeSheet(sheetObjects[0], 90);
 	}

