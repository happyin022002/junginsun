﻿﻿﻿/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : STM_SCO_9999.js
*@FileTitle : Closing Accrual Monthly Job Execute
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
    
/**
 * @extends 
 * @class stm_sco_9999 : stm_sco_9999 Defining business script.
 */
var sheetObjects=new Array();
var sheetCnt=0;

document.onclick=processButtonClick;

/**
 * Handling button event. <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  none.  
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    var formObject=document.form;
    try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
           case "btn_new":
				ComResetAll(); 
				break; 
           
           case "btn_all_refresh":
        	    fncRefresh("ACCLTES");
        		fncRefresh("ACCLTRS");
               	break; 
  
       		case "btnTesYm":
       			formObject.job_nm.value = "ACCLTES";
       			var cal=new ComCalendar();
       			cal.setDisplayType('month');
       			cal.endFunction="ComCalendar_EndFunction_acclYm";
       			cal.select(form.tes_ym, 'yyyy-MM');   
       			break;     
       		
       		case "btn_exeTES": 
       			formObject.job_nm.value = "ACCLTES";
       			formObject.accl_ym.value=formObject.tes_ym.value;
    			ComBtnDisable("btn_exeTES");
            	doActionIBSheet(sheetObjects[0],formObject,COMMAND01);
            	break;
            
       		case "btn_refreshTES":  
       			fncRefresh("ACCLTES");       			
            	break;
            
            case "btnTrsYm":
            	formObject.job_nm.value = "ACCLTRS";
       			var cal=new ComCalendar();
       			cal.setDisplayType('month');
       			cal.endFunction="ComCalendar_EndFunction_acclYm";
       			cal.select(form.trs_ym, 'yyyy-MM');   
       			break;     
            	
            case "btn_exeTRS": 
            	formObject.job_nm.value = "ACCLTRS";
            	formObject.accl_ym.value=formObject.trs_ym.value;
    			ComBtnDisable("btn_exeTRS");
            	doActionIBSheet(sheetObjects[0],formObject,COMMAND02);
            	break;
            	
            case "btn_refreshTRS":  
            	fncRefresh("ACCLTRS");
            	break;
            /*	
			case "btn_TesDataDownExcel":
       			formObject.job_nm.value = "ACCLTES";
       			formObject.accl_ym.value=formObject.tes_ym.value;
            	doActionIBSheet(sheetObjects[0],formObject,"TesDataDownExcel");
				break;	
            	
			case "btn_TrsDataDownExcel":
            	formObject.job_nm.value = "ACCLTRS";
            	formObject.accl_ym.value=formObject.trs_ym.value;
            	doActionIBSheet(sheetObjects[0],formObject,"TrsDataDownExcel");
				break;	
            */	
        }
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/** 
 * Register IBSheet object on sheetObjects array. <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj IBSheet Object
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}

/** 
 * Coding event handler for body tag's OnLoad. <br>
 * Add  pre-process functions after loading by browser. <br> 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  none.
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function loadPage() {
	
	var formObject=document.form;
	
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    axon_event.addListenerForm ('focusout', 'obj_focusout', document.form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');		
	initControl();
	
	fncRefresh("ACCLTES");
	fncRefresh("ACCLTRS");
	
}

function fncRefresh(argJobNm) {
	
	var formObject=document.form;
	
	if (argJobNm == "ACCLTES") { 
		formObject.job_nm.value = "ACCLTES";
		formObject.accl_ym.value=formObject.tes_ym.value;
		doActionIBSheet(sheetObjects[0],formObject,COMMAND11);
	} else {	
		formObject.job_nm.value = "ACCLTRS";
		formObject.accl_ym.value=formObject.trs_ym.value;
		doActionIBSheet(sheetObjects[0],formObject,COMMAND12);	
	}
}

function ComCalendar_EndFunction_acclYm(argJobNm) {
	var formObj=document.form;
	
	var jobNm = "";
	if ( argJobNm == undefined || argJobNm == ""  ) {
		jobNm = formObj.job_nm.value;
	} else {
		jobNm = argJobNm;
	}
	
	if (jobNm == "ACCLTES" ) {
		fncRefresh("ACCLTES");
	} else if (jobNm == "ACCLTRS" ) {
		fncRefresh("ACCLTRS");
	}
}

/** 
 * Coding event for OnLoad. <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  none.
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function initControl() {
}

/** 
 * Initialize sheets. <br>
 * Add  pre-process functions after loading by browser. <br>
 * Coding initial modules as sheet's count. <br> 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {IBSheet} sheetObj : Sheet object.
 * @param Serial number for sheet object's ID.  
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function initSheet(sheetObj,sheetNo) {
	 var cnt=0;
     switch(sheetObj.id) {
     	case "sheet1":
             with (sheetObj) {	
			}
        break;
    }
}

/** 
 * Coding retrieve, save... <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : Sheet object.  
 * @param  {object} formObj : Form object.
 * @param  {sAction} sAction : f_cmd.
 * @param  {int} Row : Selected row.
 * @param  {int} Col : Selected column.
 * @param  {String}Val : Selected row, column value
 * @return none.
 * @see #
 * @author 
 * @version 2009.10.19
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        
        case COMMAND01:		//Execute TES
        case COMMAND02:		//Execute TRS
        	if(validateForm(sheetObj,formObj,sAction) == false) return false;         	
        	formObj.f_cmd.value=COMMAND01;
        	var sXml;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				sXml=sheetObj.GetSearchData("STM_SAC_0030GS.do", FormQueryString(formObj));
				ScoOpenWait(false,true);
			} , 100);
			
			setTimeout( function () {
				if(ScoShowXmlMessage(sXml) != "") {
					ComShowMessage(ScoShowXmlMessage(sXml));
				}else{
					ComShowCodeMessage('SCO00015');
					if (formObj.job_nm.value == "ACCLTES" ) {
						fncRefresh("ACCLTES");
		        	} else if (formObj.job_nm.value == "ACCLTRS" ) {
		        		fncRefresh("ACCLTRS");
		        	}
				}
			} , 3000);			
			
			/* 
			if(ScoShowXmlMessage(sXml) != "") {
				ComShowMessage(ScoShowXmlMessage(sXml));
			}else{
				ComShowCodeMessage('SCO00015');
			}
			
			if (formObj.job_nm.value == "ACCLTES" ) {
				fncRefresh("ACCLTES");
        	} else if (formObj.job_nm.value == "ACCLTRS" ) {
        		fncRefresh("ACCLTRS");
        	}
			*/
			
        	break;
        case COMMAND11:	//Refresh TES
        case COMMAND12:	//Refresh TRS	
        	if(validateForm(sheetObj,formObj,sAction) == false) return false; 
        	formObj.f_cmd.value=COMMAND11;
        	var sXml;
			sheetObj.WaitImageVisible=false;
			sXml=sheetObj.GetSearchData("STM_SAC_0030GS.do", FormQueryString(formObj));
			
        	var strStatus = ComGetEtcData(sXml, "job_status");
        	
        	if (formObj.job_nm.value == "ACCLTES" ) {
        		formObj.tesStatus.value = strStatus;
    			(strStatus=="Running")?ComBtnDisable("btn_exeTES"):ComBtnEnable("btn_exeTES");
        	} else if (formObj.job_nm.value == "ACCLTRS" ) {
        		formObj.trsStatus.value = strStatus;
    			(strStatus=="Running")?ComBtnDisable("btn_exeTRS"):ComBtnEnable("btn_exeTRS");
        	}
        	
        	break;
		case "TesDataDownExcel":		// Tes Accrual Raw Data Export
		case "TrsDataDownExcel":		// Trs Accrual Raw Data Export
        	if(validateForm(sheetObj,formObj,sAction) == false) return false;         	
			ComOpenWait(true);
			formObj.f_cmd.value=COMMAND13;
            formObj.target="_top";
            formObj.action="STM_SAC_0030DL.do?"+FormQueryString(formObj);
            formObj.submit();
			ComOpenWait(false);
			break;	
    }
}

/** 
 * Validating input value. <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : Sheet object.  
 * @param  {object} formObj : Form object.
 * @param  {sAction} sAction : f_cmd.
 * @return true, false
 * @see #
 * @author 
 * @version 2009.10.19
 */
function validateForm(sheetObj,formObj,sAction) {
	switch(sAction) {
		case COMMAND01:			//Execute TES   
		case COMMAND11:   		//Refresh TES
		case "TesDataDownExcel":  //Tes Accrual Raw Data Export
			if (ComIsNull(formObj.tes_ym)) {
				ComShowCodeMessage('COM130403','Accrual Month(TES)');
				ComSetFocus(formObj.tes_ym);
				return false;
			}
			
			break;
		case COMMAND02:			//Execute TRS
		case COMMAND12:			//Refresh TRS
		case "TrsDataDownExcel":	//Trs Accrual Raw Data Export
			if (ComIsNull(formObj.trs_ym)) { 
				ComShowCodeMessage('COM130403','Accrual Month(TRS)');
				ComSetFocus(formObj.trs_ym);
				return false;
			}
			break;
		
	}
    return true;
}