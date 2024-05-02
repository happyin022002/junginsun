/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0703.js
*@FileTitle  : Berth window input 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_vsk_0703 : business script for vop_vsk_0703
     */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var openerSheet=parent.t4sheet1;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
		        var sheetObject1=sheetObjects[0];   //sheet1
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
					switch(srcName) {
						case "btn_ok":
							setOpnerValue();
							ComClosePopup(); 
						case "btn_close":
							ComClosePopup(); 
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
     * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	function initCombo(comboObj, comboNo) {
		var i=0;
		with(comboObj) {
//			style.width=100;
			var arrWeek=parent.marrWeekNm;
			for(var cnt=0; cnt < arrWeek.length; cnt++){
				InsertItem(i++,  arrWeek[cnt].toUpperCase(),   arrWeek[cnt].toUpperCase());
			}
		}
	}
	/**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		var frm=document.form;
		with(openerSheet){
			frm.loc_cd.value=GetCellValue(GetSelectRow(), "t4sheet1_loc_cd");
			frm.yd_cd.value=GetCellValue(GetSelectRow(), "t4sheet1_yd_cd");
			frm.skd_dir_cd.value=GetCellValue(GetSelectRow(), "t4sheet1_skd_dir_cd");
			frm.crr_cd.value=GetCellValue(GetSelectRow(), "t4sheet1_crr_cd");
			etb_dy_cd.SetSelectCode(GetCellValue(GetSelectRow(), "t4sheet1_etb_dy_cd"));
			etd_dy_cd.SetSelectCode(GetCellValue(GetSelectRow(), "t4sheet1_etd_dy_cd"));			

			if(GetCellText(GetSelectRow(), "t4sheet1_etd_tm_hrmnt").substring(0, 2) == "00"){
				var idx = parseInt(etd_dy_cd.GetSelectIndex());
				if(idx == 6){
					etd_dy_cd.SetSelectIndex(0, 0);
				}else{
					etd_dy_cd.SetSelectIndex(idx + 1, 0);	
				}
				
			}

			frm.etb_tm_hrmnt.value=GetCellText(GetSelectRow(), "t4sheet1_etb_tm_hrmnt").substring(0, 2);
			frm.etd_tm_hrmnt.value=GetCellText(GetSelectRow(), "t4sheet1_etd_tm_hrmnt").substring(0, 2);
		}
		axon_event.addListenerForm  ('blur',		'obj_deactivate',  form);
        axon_event.addListenerFormat('focus',		'obj_activate',    form);
        axon_event.addListenerFormat('keypress',    'obj_keypress', 	form);
		if(document.form.enableForm.value == "N"){
			frm.etb_dy_cd.SetEnable(0);
			frm.etd_dy_cd.SetEnable(0);
			frm.etb_tm_hrmnt.disabled=true;
			frm.etd_tm_hrmnt.disabled=true;
		}
    }
    /**
     * Deleting mask separator in onfocus event
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
		event.srcElement.select();
    }
    /**
     * Making mask separator, Checking Validation
     **/
	function obj_deactivate(){
		if(event.srcElement.name == "etb_tm_hrmnt" || event.srcElement.name == "etd_tm_hrmnt"){
			if(parseInt(event.srcElement.value) < 10){
				event.srcElement.value="0" + parseInt(event.srcElement.value);
			}else if(parseInt(event.srcElement.value) > 23){
				var name = "";
				if(  event.srcElement.name == "etb_tm_hrmnt" ){
					name = "etb_hour";
				}else if(event.srcElement.name == "etd_tm_hrmnt"){
					name = "etd_hour";
				}
				var sMsg="'" + name + "' is not valid. Please enter a correct Hour."
				ComShowMessage(sMsg);
				event.srcElement.select();
				event.srcElement.value = "";
			}
		}
	}
    /**
     * Handling key press event
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
	function setOpnerValue(){
		
		var frm=document.form;
		with(openerSheet){
			var prefix="t4sheet1_";
			
			SetCellValue(GetSelectRow(), prefix + "etb_dy_cd", etb_dy_cd.GetSelectCode());
			SetCellValue(GetSelectRow(), prefix + "etd_dy_cd", etd_dy_cd.GetSelectCode());
			SetCellText(GetSelectRow(), prefix + "etb_tm_hrmnt" ,frm.etb_tm_hrmnt.value + "00");
			SetCellText(GetSelectRow(), prefix + "etd_tm_hrmnt" ,frm.etd_tm_hrmnt.value + "00");
			for(var col=parseInt(SaveNameCol(prefix + "etd_tm_hrmnt")) + 1; col <= LastCol(); col++){
//no support[check again]CLT 				CellBackColor(SelectRow, col)=UnEditableColor;
				SetCellValue(GetSelectRow(), col,"");
			}

			
			var etbTmHrmnt = parseInt(GetCellValue(GetSelectRow(), prefix + "etb_tm_hrmnt").substring(0, 2));
			var etdTmHrmnt = parseInt(GetCellValue(GetSelectRow(), prefix + "etd_tm_hrmnt").substring(0, 2));

			var amPmS = etbTmHrmnt <  12 ? "am" : "pm";
			var amPmE = etdTmHrmnt <= 12 ? "am" : "pm";

			if(etdTmHrmnt == "00"){
				amPmE = "pm";
				if(etd_dy_cd.GetSelectIndex() == "0"){
					etd_dy_cd.SetSelectIndex(6, 0);	
				}else{
					etd_dy_cd.SetSelectIndex(etd_dy_cd.GetSelectIndex() - 1, 0);
				}
				
				SetCellValue(GetSelectRow(), prefix + "etd_dy_cd", etd_dy_cd.GetSelectCode());
			}
			
			var colName3 = prefix +  "etd_tm_" + GetCellValue(GetSelectRow(), prefix + "etb_dy_cd").toLowerCase() + "_"  + amPmS;
			var colName4 = prefix +  "etd_tm_" + GetCellValue(GetSelectRow(), prefix + "etd_dy_cd").toLowerCase() + "_"  + amPmE;

			parent.sheetSetBackColor(openerSheet, GetSelectRow(), colName3, colName4);
			for(var col=SaveNameCol(prefix + "etd_tm_sun_am");
					col <= SaveNameCol(prefix + "etd_tm_sat_pm"); col++){
				SetCellValue(GetSelectRow(), col,"    ");
			}
			if(colName3 == colName4){
				SetCellValue(GetSelectRow(), colName3,GetCellValue(GetSelectRow(), prefix + "etb_tm_hrmnt").substring(0, 2) + "/" + GetCellValue(GetSelectRow(), prefix + "etd_tm_hrmnt").substring(0, 2));
			}else{
				SetCellValue(GetSelectRow(), colName3,GetCellValue(GetSelectRow(), prefix + "etb_tm_hrmnt").substring(0, 2));
				SetCellValue(GetSelectRow(), colName4,GetCellValue(GetSelectRow(), prefix + "etd_tm_hrmnt").substring(0, 2));
			}
			parent.sheetSetForeColor(openerSheet, GetSelectRow(), colName3, colName4);
		}
	}
