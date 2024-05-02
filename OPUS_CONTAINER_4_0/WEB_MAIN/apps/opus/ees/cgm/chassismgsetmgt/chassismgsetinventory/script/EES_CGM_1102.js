/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1102.js
*@FileTitle  : Chassis Variation Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_CGM_1102 : EES_CGM_1102 business script for
 */

   	/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version
 */ 
function processButtonClick(){
     /***** use additional sheet var in case of more than 2 tap each sheet *****/
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
	 try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
 				if(formObject.doc_type[0].checked==true) // summary
 				{
            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            		}
 				}else //detail
 				{
            		if(validateForm(sheetObject2,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject2, formObject, IBSEARCH);
            		}
 				}
            	//formObject.crnt_loc_cd.focus(); //             	
                break;
            case "btn_new":
            	initControl();
                break; 
            case "btn_downexcel":
 				if(formObject.doc_type[0].checked==true) // summary
 				{
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 				}else 
 				{
 					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
 				}
                break;
            case "btns_crnt_loc_cd":	// Location Popup
                var tmp=formObject.combo_location_text.value;
            	if(tmp == "RCC"){
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
            	} else if(tmp == "LCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	} else if(tmp == "SCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	}
            	break;                                                            
		case "btns_Calendar2" :		// Agreement Date (To Date)
//				var cal = new ComCalendar();
			var cal=new ComCalendarFromTo();
//	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
    		cal.select(formObject.inq_fm_dys,  formObject.inq_to_dys,  'yyyy-MM-dd');
// 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
    		break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
     		ComShowMessage(OBJECT_ERROR);
		} else {
     		ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list <br>
 * @param  {object} sheet_obj	
 * @return 
 * @author 
 * @version
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function loadPage() 
{
	  var formObject=document.form;    	
	   for(i=0;i<sheetObjects.length;i++){
   		//
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
   		//
        ComEndConfigSheet(sheetObjects[i]);
        
        
    }
    comboObjects[comboCnt++]=combo_location;
  	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
    }  
  	sheet1_OnLoadFinish(sheetObjects[0]);

}
 /**
 * sheet setting and init in case of load finish <br>
 * @param  
 * @return 
 * @author 
 * @version
 */     
 function sheet1_OnLoadFinish(sheetObj) {//Cuong Le : not support anymore,but I don't know how to converted this function
    var formObject=document.form;    	
    sheetObj.SetWaitImageVisible(0);
	// axon event regist
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	axon_event.addListener('click', 'doc_type_change', 'doc_type');
	//axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
	//axon_event.addListener('keyup', 'enterFire', 'inq_fm_dys');
	//axon_event.addListener('keyup', 'enterFire', 'inq_to_dys');
	axon_event.addListenerForm('keyup', 'obj_keyup', form);	 
 	// Multi Combo reset
 	comboObjects[comboCnt++]=combo_location;
  	for(var k=0;k<comboObjects.length;k++){//
        initCombo(comboObjects[k]);
    }
  	/*
    // Location MultiCombo value setting
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);	
	*/
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	// Sheet Object reset
    initControlWithParam();
    sheetObjects[0].RemoveAll();
    sheetObj.SetWaitImageVisible(1);
}
function initControlWithParam(){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    // init value setting
    comboObjects[0].DeleteItem(comboObjects[0].FindItem("SCC", 0, true)); //document. RCC/LCC만.
    if(formObj.location_param.value != "")
    {
    	comboObjects[0].SetSelectText(formObj.location_param.value,false);
    }else
   	{
    	comboObjects[0].SetSelectIndex(0,false);
   	}
    formObj.crnt_loc_cd.focus(); 
}
/**
  * init control of form <br>
  * @param  
  * @return 
  * @author 
  * @version
  */
function initControl(){
	var formObj=document.form;
  	var sheetObj=sheetObjects[0];
  	var sheetObj2=sheetObjects[1];
  	// Form Object reset
  	with(formObj){
  		 crnt_loc_cd.value="";
  		 include_np.checked=false;
         include_en.checked=false;
         inq_fm_dys.value="";
         inq_to_dys.value="";
         doc_type[0].checked=true;
    }
  	// MultiCombo reset
  	for(var i=0; i<comboObjects.length; i++){
  		comboObjects[i].SetSelectText("",false);
  	}
  	// Sheet Object reset
  	sheetObj.RemoveAll();
  	sheetObj2.RemoveAll();
	// init value setting
//	comboObjects[0].DeleteItem("SCC"); //document. RCC/LCC
	comboObjects[0].SetSelectIndex(0,false);
	doc_type_change();
	//formObj.crnt_loc_cd.focus(); //
}
function resizeSheet(){
	ComResizeSheet( sheetObjects[0] );
}
/**
  * setting sheet initial values and header <br>
  * adding case as numbers of counting sheets <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {int} sheetNo
  * @return 
  * @author 
  * @version 
  */
function initSheet(sheetObj,sheetNo) 
{
	  var cnt=0;
	  var sheetID=sheetObj.id;
      switch(sheetID) {
      case "sheet1":
        with (sheetObj) {
          var HeadTitle="LCC|Reason|Total|20'|40'|45'";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"location",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Right",   ColMerge:0,   SaveName:"eq_aset_sts_cd_total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"eq_tp_sz_20",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"eq_tp_sz_40",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"eq_tp_sz_45",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
           
          InitColumns(cols);
//          SetSheetHeight(422);
          SetEditable(0);
		  SetEditableColorDiff(0);
		  resizeSheet();
       }
       break;
    case "sheet2":
        with (sheetObj) {
	        var HeadTitle1="|Seq.|Chassis No.|Type/Size|Office|Previous Status|Previous Status|Previous Status|Previous Status|After Status|After Status|After Status|After Status";
	        var HeadTitle2="|Seq.|Chassis No.|Type/Size|Office|Status|Event Date|LCC|Yard|Status|Event Date|LCC|Yard";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"},
	                    { Text:HeadTitle2, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
	               {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pre_eq_aset_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pre_sts_event_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_sts_event_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pre_sts_evnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"sts_event_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_event_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	         
	        InitColumns(cols);
	        SetSheetHeight(302);
	        SetEditable(0);
			SetEditableColorDiff(0);
       }
       break;               
    case "sheet3":
        with (sheetObj) {
            
		}
        break;		       
    }
}
/**
 * handling process for Sheet <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type
 * @return 
 * @author 
 * @version 
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
     	case IBSEARCH:      //retrieve
        	// Form Object value setting
     		if(formObj.include_np.checked){
 				formObj.include_np.value="Y";
 			} else {
 				formObj.include_np.value="";
 			}
 			if(formObj.include_en.checked){
 				formObj.include_en.value="Y";
 			} else {
 				formObj.include_en.value="";
 			}
 			
 			if(!ComIsEmpty(combo_location.GetSelectCode())) {
 	 			formObj.location.value = combo_location.GetSelectCode();
 	 		}
 			
 			if(validateForm(sheetObj,formObj,sAction))
 			{
 				if(formObj.include_en.checked== false) // EN UNCHECKED
 				{
	 				if(formObj.doc_type[0].checked==true) // sheet 1
	 				{
	 			 		sheetObj.SetWaitImageVisible(0);
	 			 		ComOpenWait(true);
		 				formObj.f_cmd.value=SEARCH;
			 			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
  			 			var sXml=sheetObj.GetSearchData("EES_CGM_1102GS.do" , FormQueryString(formObj));
		 				sheetObj.LoadSearchData(sXml,{Sync:1} );
				 		ComOpenWait(false);
	 				}else // sheet 2
	 				{
	 			 		sheetObj.SetWaitImageVisible(0);
	 			 		ComOpenWait(true);
		 				formObj.f_cmd.value=SEARCH;
			 			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
  			 			var sXml=sheetObj.GetSearchData("EES_CGM_1103GS.do" , FormQueryString(formObj));
		 				sheetObj.LoadSearchData(sXml,{Sync:1} );
		 				ComOpenWait(false);
	 				}
 				}else 
 				{
	 				if(formObj.doc_type[0].checked==true) // sheet 1
	 				{
						formObj.f_cmd.value=SEARCH01;
			 			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			 			sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);			
  						var sXml=sheetObj.GetSearchData("EES_CGM_1102GS.do" , FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						var backEndJobKey=ComGetEtcData(arrXml[0], "BackEndJobKey");
						ComOpenWait(true);				
						if(backEndJobKey.length > 0)
						{
							formObj.back_end_job_key.value=backEndJobKey;
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.SetWaitTimeOut(400000);
							timer=setInterval(getBackEndJobStatus, 3000); 
						}		 				
	 				}else // sheet 2
	 				{
						formObj.f_cmd.value=SEARCH01;
			 			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			 			sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);					
 						var sXml=sheetObj.GetSearchData("EES_CGM_1103GS.do" , FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						var backEndJobKey=ComGetEtcData(arrXml[0], "BackEndJobKey");
						ComOpenWait(true);				
						if(backEndJobKey.length > 0)
						{
							formObj.back_end_job_key.value=backEndJobKey;
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.SetWaitTimeOut(400000);
							timer=setInterval(getBackEndJobDtlStatus, 3000); 
						}
	 				} 					
 				}
 			}	 			
 			break;
     	case IBSEARCH_ASYNC01:	// Location Combo retrieve
   			formObj.f_cmd.value=SEARCH;
   			formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting (Location)
   			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
   			var sStr=ComGetEtcData(sXml,"comboList");    			
   			var arrStr=sStr.split("@");
   			// combo control, result string, Text Index, Code Index
   			makeComboObject(combo_location, arrStr, 1, 1, 0);
   			combo_location.SetSelectIndex(0);
   			break;
  	    case IBSEARCH_ASYNC08:
  	       	//formObj.f_cmd.value = SEARCH;
  	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
  	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	   		formObj.f_cmd.value=SEARCH17;
	    	var location=formObj.combo_location_text.value;
	    	if(location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="RCC";
	    		formObj.eq_orz_cht_rcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="LCC";
	    		formObj.eq_orz_cht_lcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="SCC";
	    		formObj.eq_orz_cht_scc_cd.value=formObj.crnt_loc_cd.value;
	    	}else
	    	{
	    		formObj.eq_orz_cht_chktype.value="";
	    		formObj.eq_orz_cht_scc_cd.value="";
	    	}
     		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
  	   		// data count
  	        var dataCount=ComGetTotalRows(sXml);
  	        if(dataCount==0){
  	        	ComShowCodeMessage('CGM10009','location cd');
  		   		formObj.crnt_loc_cd.value="";
  	        }
  	        formObj.crnt_loc_cd.focus(); //   	        
  	   		break;	
     	case IBDOWNEXCEL:        //down excel
     		if(sheetObj.RowCount() < 1){//no data
     			ComShowCodeMessage("COM132501");
     		}else{
     			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObj), SheetDesign:1,Merge:1 });
     		}
			break;
    	case IBRESET:
    		var idx=0
    		var sXml2=document.form2.sXml.value;
    		var arrXml=sXml2.split("|$$|");
    		//Location
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
    		// combo control, result string, Text Index, Code Index
	  		makeComboObject(combo_location, arrStr1, 1, 1, 0);       
	  		combo_location.SetSelectIndex(0);
    		idx++;        		
    		break;			
    }
}
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version
 */ 
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
					crnt_loc_cd.focus();
					return false;
				} else {
					if(crnt_loc_cd.value.length != 5) 
    				{
						ComShowCodeMessage('CGM10044','Location(5)');
						crnt_loc_cd.focus();
    					return false;
    				}
				}
 		 		if(inq_fm_dys.value == ''){
        				ComShowCodeMessage('CGM10004','Period ');
        				inq_fm_dys.focus();
        				return false;
        		}	
 		 		if(inq_to_dys.value == ''){
        				ComShowCodeMessage('CGM10004','Period ');
        				inq_to_dys.focus();
        				return false;
        		}
 		 		var dt_str=ComReplaceStr(document.form.inq_fm_dys.value,"-","");
     			var dt_end=ComReplaceStr(document.form.inq_to_dys.value,"-","");
     	    	if(dt_str != '' && dt_end != ''){
 	    		if(dt_end < dt_str){
 	    			ComShowCodeMessage('COM12133','To date','From date','greater');
 	    			inq_fm_dys.value='';
 	    			inq_fm_dys.focus();
 	    			return false;
 	    		}
 	    	}
			break;
        }
	}
    return true;
}
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version
 */
function validateFormNoPopup(sheetObj,formObj,sAction){
    with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					//ComShowCodeMessage('CGM10004','Location');
					crnt_loc_cd.focus();
					return false;
					}
 		 		if(inq_fm_dys.value == ''){
        				//ComShowCodeMessage('CGM10004','Period ');
        				inq_fm_dys.focus();
        				return false;
        			}	
 		 		if(inq_to_dys.value == ''){
        				//ComShowCodeMessage('CGM10004','Period ');
        				inq_to_dys.focus();
        				return false;
        			}
 		 		 var dt_str=ComReplaceStr(document.form.inq_fm_dys.value,"-","");
     			 var dt_end=ComReplaceStr(document.form.inq_to_dys.value,"-","");
 	    		if(dt_str != '' && dt_end != ''){
 	    			if(dt_end < dt_str){
 	    				//ComShowCodeMessage('COM12133','To date','From date','greater');
 	    				inq_fm_dys.value='';
 	    				inq_fm_dys.focus();
 	    				return false;
 	    			}
 	    		}
				break;
            }
	}
    return true;
}     
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version
 */   
function callBackLocation(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var location=formObj.combo_location_text.value;
    var crntLocCd="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][8];
    	}
    	if(i < aryPopupData.length - 1){
    		crntLocCd=crntLocCd + ",";
     	}
    }
    formObj.crnt_loc_cd.value=crntLocCd;
}
function sheet1_OnChangeSum(sheetObj, Row )
{
	with(sheetObj)
	{
		//SumText(0,"Seq") = "";
		//SumText(0,"location") = "Grand Total";
		//CellAlign(Row, "location") = daCenter;
	}
} 
/**
 * Sheet1  OnSearchEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version 
 */ 	
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	orderTitle();
	with(sheetObj)
	{
		var color1="#FFDCDC";
		var color2="#DCDCFF";
		for(var i=1; i <= LastRow(); i ++)
		{
			if( GetCellValue(i,"eq_aset_sts_cd") == "Sub. Total")
			{
				SetCellBackColor(i, "eq_aset_sts_cd",color1);
				SetCellBackColor(i, "eq_aset_sts_cd_total",color1);
				SetCellBackColor(i, "eq_tp_sz_20",color1);
				SetCellBackColor(i, "eq_tp_sz_40",color1);
				SetCellBackColor(i, "eq_tp_sz_45",color1);
			}
			if( GetCellValue(i,"location") == "Sts. Total")
			{
				//CellBackColor(i, "location") = color2;
				SetCellBackColor(i, "eq_aset_sts_cd",color2);
				SetCellBackColor(i, "eq_aset_sts_cd_total",color2);
				SetCellBackColor(i, "eq_tp_sz_20",color2);
				SetCellBackColor(i, "eq_tp_sz_40",color2);
				SetCellBackColor(i, "eq_tp_sz_45",color2);
			}
			if( GetCellValue(i,"eq_aset_sts_cd") == "G. Total")
			{
				SetCellBackColor(i, "eq_aset_sts_cd",color1);
				SetCellBackColor(i, "eq_aset_sts_cd_total",color1);
				SetCellBackColor(i, "eq_tp_sz_20",color1);
				SetCellBackColor(i, "eq_tp_sz_40",color1);
				SetCellBackColor(i, "eq_tp_sz_45",color1);
			}
		}
	}
}
 /**
  * Sheet1  OnSearchEnd event handling <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {string} ErrMsg		 String
  * @return 
  * @version 
  */ 	
 function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 {
 	orderTitle();
 }
 function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	 var formObj=document.form;
     if(formObj.doc_type[0].checked==true) // Summary
     {
     }else //Detail
     {
    	if(Row > 1)
    	{
			if(sheetObj.GetCellValue(Row, "eq_no") == null || sheetObj.GetCellValue(Row, "eq_no") == "")
			{
				return;
			}
			var eqNo=sheetObj.GetCellValue(Row, "eq_no");
			var param="?pgmNo=EES_CGM_1003&eq_no=" + eqNo;
			var seq=sheetObj.GetCellValue(Row, "Seq");
			if(seq != ''){
				// ComOpenPopup('/opuscntr/EES_CGM_1003.do' + param, 1100, 500, "", "1,0", true, false);
		  		var pgmNo='EES_CGM_1003';
		  		var pgmUrl='/opuscntr/EES_CGM_1003.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
		    	
  		    	ComOpenWindowCenter('/opuscntr/EES_CGM_1003.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 600, false);
			}
    	}
     }
 }           
/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function domFunFocusDel(a)
{
  	var formObj=document.form;
    obj=ComGetEvent();
    if(obj.name=="evnt_dt_str"  ){
    	document.form.evnt_dt_str.value=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
    }
    if(obj.name=="evnt_dt_end"  ){
      		document.form.evnt_dt_end.value=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
    }
    //ComShowMessage("domFunFocusDel");
}
/**
 * Location Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.crnt_loc_cd.value="";
//	form.combo_location_text.value = comboObj.GetText(parseInt(newIndex), 0);
	
}
function combo_location_OnBlur() {
//	document.form.combo_location_text.value = combo_location.GetSelectCode();
}
/** 
 * Object activate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function obj_activate(){
   	ComClearSeparator(ComGetEvent());
} 
/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function obj_deactivate(){
    var formObj=document.form;
    obj=ComGetEvent();
    if(obj.name=="inq_fm_dys"  ){
        with(formObj){
            var creDtFr=ComReplaceStr(inq_fm_dys.value,"-","");
        }
        ComChkObjValid(ComGetEvent());
    }
   	if(obj.name=="inq_to_dys"  ){
   		with(formObj){
       		 var creDtFr=ComReplaceStr(inq_to_dys.value,"-","");
        }
        ComChkObjValid(ComGetEvent());
    }    	
}
/** 
 * Object Keypress event handling  <br>
 * 
 * @param  
 * @return 
 * @author 
 * @version 
 */ 

/** 
 * Object change event handling  <br>
 * @param  
 * @return 
  * @author 
 * @version
 */  
function obj_change(){
 	 var formObj=document.form;
 	 var sheetObj=sheetObjects[0]; 
 	 obj=ComGetEvent();
 	 switch(ComGetEvent("name")){
	 	case "crnt_loc_cd":
    	 	break;
 	 }   
}
/** 
 * Object obj_focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */  
function obj_focusout(){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 obj=ComGetEvent();
}
/** 
 * Combo Object reset  <br>
 * @param  {object} comboObj	Combo Object
 * @return 
  * @author 
 * @version
 */ 
function initCombo(comboObj) {
 	switch(comboObj.options.id) {
    	case "combo_location":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(100);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	            SetSelectIndex(0, false);
  	        }
 	        break;
 	}
}       
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	if(opt == 0) {
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
        }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
        }
 	}
 	cmbObj.SetSelectIndex("" ,false);
}   
/** 
 * Summary/Detail Change <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */ 
function doc_type_change() {
    var formObj=document.form;
	document.getElementById('summaryLayer').style.display="none";
	document.getElementById('detailLayer').style.display="none";
	//
	if(formObj.doc_type[0].checked==true)
	{
		//document.getElementById('chartLayer').style.visibility = 'hidden';
		//document.getElementById('sheetLayer').style.visibility = 'visible';
		document.getElementById('summaryLayer').style.display="";
		//sheet reset
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}else //
	{
		//document.getElementById('sheetLayer').style.visibility = 'hidden';
		//document.getElementById('chartLayer').style.visibility = 'visible';
		document.getElementById('detailLayer').style.display="";
		//sheet reset
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    }
}      
      
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	 	 	case "crnt_loc_cd":
		 		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_loc_cd.value = "";
		 				ComSetFocus(formObj.crnt_loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.crnt_loc_cd.value != ''){
		    	 		if(formObj.crnt_loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
    	 }
}   

function orderTitle()
{
    var formObj=document.form;
    var sheetObj1=sheetObjects[0];
    var sheetObj2=sheetObjects[1];
	if(formObj.doc_type[0].checked==true) // sheet 1
	{
		if(comboObjects[0].GetSelectCode()== 'RCC')
			sheetObj1.SetCellValue(0, "location", 'LCC[Location]');
		else
			sheetObj1.SetCellValue(0, "location", 'SCC[Location]');
		
		if(sheetObj1.RowCount("R") > 0)
		{
			
			for(var i=1; i< sheetObj1.RowCount("R")+1; i++)
			{
				if(sheetObj1.GetCellValue(i,"location")=="" && sheetObj1.GetCellValue(i,"eq_aset_sts_cd")!= "") {
					sheetObj1.SetCellValue(i,"location", "Sts. Total");
				} else if(sheetObj1.GetCellValue(i,"location")!="" && sheetObj1.GetCellValue(i,"eq_aset_sts_cd")== "") {
					sheetObj1.SetCellValue(i,"eq_aset_sts_cd", "Sub. Total");
				} else if(sheetObj1.GetCellValue(i,"location")=="" && sheetObj1.GetCellValue(i,"eq_aset_sts_cd")== "") {
					sheetObj1.SetCellValue(i,"eq_aset_sts_cd", "G. Total");
					//sheetObj1.RowDelete(i, false); // G.Total은 deleting
				}
			}
		}		
	}else{
		if(comboObjects[0].GetSelectCode()== 'RCC')
		{
			sheetObj2.SetCellValue(1, "pre_sts_event_loc_cd", 'LCC');
			sheetObj2.SetCellValue(1, "sts_event_loc_cd", 'LCC');
		}
		else
		{
			sheetObj2.SetCellValue(1, "pre_sts_event_loc_cd", 'SCC');
			sheetObj2.SetCellValue(1, "sts_event_loc_cd", 'SCC');
		}			
	}
}
function comShowBackEndErrorMsg(errCode) {
    ComShowCodeMessage(errCode);
 	clearInterval(timer);
 	ComOpenWait(false);
}
function getBackEndJobStatus() {
    var sheetObj=sheetObjects[2]; 
    var formObj=document.form;
    formObj.f_cmd.value=SEARCH02;
 	var sXml="";
  	sXml=sheetObj.GetSearchData("EES_CGM_1102GS.do", FormQueryString(formObj));
 	var arrXml=sXml.split("|$$|");
 	var jobState=ComGetEtcData(arrXml[0], "jb_sts_flg");
 	//ComDebug("chungpa ID: "+formObj.back_end_job_key.value+"   jobState: "+ jobState);
 	if(jobState == "3") {
 	 	getBackEndJobResult();
  	    clearInterval(timer);
    } else if(jobState == "4") {
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	
		ComOpenWait(false);	    	
    } else if(jobState == "5") {
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	
		ComOpenWait(false);	  	  
    }  
}
 function getBackEndJobDtlStatus() {
    var sheetObj=sheetObjects[2]; 
    var formObj=document.form;
    formObj.f_cmd.value=SEARCH02;
 	var sXml="";
  	sXml=sheetObj.GetSearchData("EES_CGM_1103GS.do", FormQueryString(formObj));
 	var arrXml=sXml.split("|$$|");
 	var jobState=ComGetEtcData(arrXml[0], "jb_sts_flg");
 	//ComDebug("chungpa ID: "+formObj.back_end_job_key.value+"   jobState: "+ jobState);
 	if(jobState == "3") {
 	 	getBackEndJobDtlResult();
  	    clearInterval(timer);
    } else if(jobState == "4") {
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	
		ComOpenWait(false);	  	
    } else if(jobState == "5") {
  	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	
		ComOpenWait(false);	  	
    } 
 }
function getBackEndJobResult() {
    var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.f_cmd.value=SEARCH03;
 	var sXml="";
	ComOpenWait(false);	
  	sXml=sheetObj.GetSearchData("EES_CGM_1102GS.do", FormQueryString(formObj),-1,false);
	var arrXml=sXml.split("|$$|");
	if(arrXml.length > 0) {
		sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	}
	if (sheetObj.RowCount()<= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		//끝.
	}   
}
 function getBackEndJobDtlResult() {
     var formObj=document.form;
 	var sheetObj=sheetObjects[1];
 	formObj.f_cmd.value=SEARCH03;
  	var sXml="";
	ComOpenWait(false);
   	sXml=sheetObj.GetSearchData("EES_CGM_1103GS.do", FormQueryString(formObj),-1,false);
 	var arrXml=sXml.split("|$$|");
 	if(arrXml.length > 0) {
 		sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
 		orderTitle();
 	}
 	if (sheetObj.RowCount()<= 0 ) {
 		// There is no related data!
 		ComCodeMsgByNoRelatedData();
 		return;
 	} else {
 		//끝.
 	}   
 } 
	/* developer job end */
