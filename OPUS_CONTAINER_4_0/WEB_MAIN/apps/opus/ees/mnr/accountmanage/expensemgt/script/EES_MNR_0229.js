/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0229.js
*@FileTitle : M&R Estimate expense
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0229 : business script for EES_MNR_0229.
 */

/* developer job	*/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var HOOfc="";
var initLoader=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;	
				case "btn_Confirm": 
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBSAVE); 
					break;   	    
				case "cre_dt_cal_from":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.month, "yyyy-MM");
					break;	    	
				case "exe_dt_cal_from":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.exe_month, "yyyy-MM");
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	 MnrWaitControl(true);
     for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i + 1); 
        ComEndConfigSheet(sheetObjects[i]);
     }	              
	 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	 MnrWaitControl(false);
} 
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
		var sheetID=sheetObj.id;
     		switch(sheetID) {
	         case "sheet1":
	        	    with(sheetObj){        
	         
	        	 	var HeadTitle1="|Seq.|Actual Month|SYS Name|Rev Month|ACCT Code|Biz Unit|loc_cd|vsl_cd|skd_voy_no|skd_dir_cd|REV VVD|wo_no|cntr_tpsz_cd|cntr_qty|Estimated Cost|Actual Cost|Accural Cost|estm_vvd_tp_cd|estm_ioc_div_cd|estm_bc_div_cd";
	        	 	var headCount=ComCountHeadTitle(HeadTitle1);
	
	        	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        	 	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	 	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	 	InitHeaders(headers, info);

	        	 	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exe_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sys_src_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"biz_ut_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"estm_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"actu_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"accl_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_vvd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_ioc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_bc_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            
		           InitColumns(cols);
	
		           SetEditable(0);
		           SetColHidden("loc_cd",1);
		           SetColHidden("vsl_cd",1);
		           SetColHidden("skd_voy_no",1);
		           SetColHidden("skd_dir_cd",1);
		           SetColHidden("wo_no",1);
		           SetColHidden("cntr_tpsz_cd",1);
		           SetColHidden("cntr_qty",1);
		           SetColHidden("estm_vvd_tp_cd",1);
		           SetColHidden("estm_ioc_div_cd",1);
		           SetColHidden("estm_bc_div_cd",1);
		           SetSheetHeight(420);
		           }
			break;  	
	         case "sheet2":
	             with(sheetObj){
	                     
		            var HeadTitle1="|Seq.|Actual Month|SYS Name|Rev Month|ACCT Code|Biz Unit|Location|Vessel|Schedule Voyage Number|Vessel Direction Code|REV VVD|W/O No|TS|QTY|Estimated Cost|Actual Cost|Accural Cost|estm_vvd_tp_cd|estm_ioc_div_cd|estm_bc_div_cd";
		            var headCount=ComCountHeadTitle(HeadTitle1);
	
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		            var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exe_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sys_src_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"biz_ut_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"estm_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"actu_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"accl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_vvd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_ioc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"estm_bc_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		            InitColumns(cols);	
		            SetEditable(0);		           
		            SetVisible(false);
	         	}
	             break; 	
     }
 }
function initControl() {  
    //Axon handling event1. event catch  
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
 //   axon_event.addListenerFormat('focus',   'obj_activate',    form);            
//    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
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
 * HTML Control deactivate event <br>
 **/
function obj_deactivate(){    
	obj=event.srcElement;       
    ComChkObjValid(ComGetEvent()); 
} 
/**
 * HTML Control activate event <br>
 **/
function obj_activate(){   
    ComClearSeparator(ComGetEvent());
} 
/**
 * HTML Control keypress event <br>
 **/     
 /**
  * handling process after ending sheet1 retrieve.
  * @param sheetObj
  * @return
  */
  function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	  MnrWaitControl(false);
  }
  /**
   * handling process after ending sheet2 retrieve.
   * @param sheetObj
   * @return
   */
   function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
	    //sheetObj.SpeedDown2Excel(-1);  
	    sheetObjects[0].SetSheetHeight(500);
	    sheetObjects[1].SetSheetHeight(0);
		MnrWaitControl(false);
   }
 function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
 	if (ErrMsg == "") {  
		ComShowCodeMessage("MNR00340");   
		MnrWaitControl(false);	
	} 	
 	MnrWaitControl(false);
 }	
 // handling process for sheet
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	// getting the current date
 	var today=new Date();
 	var year=today.getFullYear();
 	var month=today.getMonth();	
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
			case IBSEARCH:      //retrieving
				ComOpenWait(false);
				if(validateForm(sheetObj,formObj,sAction))					
					if (sheetObj.id == "sheet1"){	
						MnrWaitControl(true);
						formObj.f_cmd.value=SEARCH;     						
						sheetObj.DoSearch("EES_MNR_0229GS.do",FormQueryString(formObj) );
					}
				break; 
			case IBCLEAR:        //initializing
				MnrWaitControl(true);
				ComOpenWait(false);
			    sheetObj.SetWaitImageVisible(0);
				//initializing sheet   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();
		        }  
				formObj.month.value=dateFormat(year,4) + "-" + dateFormat(month,2);
				formObj.exe_month.value=dateFormat(year,4) + "-" + dateFormat(month,2);
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);    			
				break;
			case IBSAVE:  
				ComOpenWait(false);
				if(validateForm(sheetObj,formObj,sAction)) { 
					 MnrWaitControl(true);
					 formObj.f_cmd.value=MODIFY;     
					 var sXml=sheetObj.GetSaveData("EES_MNR_0229GS.do",FormQueryString(formObj));
					 sheetObj.LoadSaveData(sXml);
				}	 
				break;
     }
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
	 	switch(sAction) {  	
			//RE-Bidding 
			case IBSEARCH:  
				if(formObj.month.value == "") {
					ComAlertFocus(formObj.month, ComGetMsg('MNR00003'));
					return false;
				}  
			break;
			case IBSAVE:  
				if(formObj.exe_month.value == "") {
					ComAlertFocus(formObj.month, ComGetMsg('MNR00003'));
					return false;
				}  
			break;	 	
     	}
	 }	
     return true;
 }
 function dateFormat(n, digits) {
 	var zero='';
 	n=n.toString();
 	if (n.length < digits) {
 		for (i=0; i < digits - n.length; i++)
 	    zero += '0';
 	}
 	return zero + n;
 }	  
/* developer job end */
