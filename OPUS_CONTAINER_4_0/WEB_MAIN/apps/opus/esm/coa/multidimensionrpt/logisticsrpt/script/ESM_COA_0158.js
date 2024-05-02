/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0158.jsp
*@FileTitle  : Office/Volum Activity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/**
 * @fileoverview 
 */
/**
* @extends logisticsrpt
* @class ESM_COA_0158 : ESM_COA_0158 Business script for the UI
*/

//Grobal Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var sheet_height=430; 		// sheet height : SJH.20141230.ADD
/* Event handler processing by button click event */
document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bu_zoom_in":	//SJH.20141230.MOD
					getToggleSheetHeight(sheetObject, (sheetObject.GetSheetHeight(sheet_height) * 2), div_zoom_in1, div_zoom_out1, "none", "inline", "0");
					break;
				case "bu_zoom_out":	//SJH.20141230.MOD
					getToggleSheetHeight(sheetObject, sheet_height, div_zoom_in1, div_zoom_out1, "inline", "none", "1");
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e.message);
            }
		}
	}
	/**
     *  Depending on the display of the Month / Week column shows the sheet
     */
    function viewMonWeek(){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
            
        //SJH.20140730.ADD
        if(formObj.f_split_mw.checked){
        	sheetObj.SetColHidden("cost_yrmon",0);
        	sheetObj.SetColHidden("cost_wk",0);
        } else {
        	sheetObj.SetColHidden("cost_yrmon",1);
        	sheetObj.SetColHidden("cost_wk",1);
        }      

        initSheet(sheetObjects[0],1);
        sheetObj.RemoveAll();
    }
    /**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	*/
	function clearDatePeriod(){
		document.form.txtWeek.value="";
		document.getElementById("div_period").innerHTML="<div id='div_period'></div>";
	}
	/**
	* Change period when the month, week changed
	*/
	function setPeriod(obj){
		ComCoaSetPeriod(obj);
	}
	   /**
	    * kpl type
	    */
	   function changeKpiType(kpiType) {
	 	    if(kpiType == '2') {
		        div_mnKpi.style.display="none";
		        div_lgsKpi.style.display="inline";
		    } else {
		        div_mnKpi.style.display="inline";
		        div_lgsKpi.style.display="none";
		    }      
	   }
	 /**
	  * RHQ, OFFICE condition to enable / disable function <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *
	  * </pre>
	  * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	  * @param {int} code  Mandatory Onclick event code
	  * @param {int} text  Text in the mandatory item
	  * @return nothing
	  */
	function f_report_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
	 	if (newCode == "1") {
	 		f_rhq_cd.SetEnable(0);
	 		f_ctrl_ofc_cd.SetEnable(0);
	 		f_rhq_cd.SetSelectIndex(0);
	 		f_ctrl_ofc_cd.SetSelectIndex(0);
	 	} else if(newCode == "2") {
	 		f_rhq_cd.SetEnable(1);
	 		f_ctrl_ofc_cd.SetEnable(0);
	 		f_ctrl_ofc_cd.SetSelectIndex(0);
	 	} else {
	 		f_rhq_cd.SetEnable(1);
	 		f_ctrl_ofc_cd.SetEnable(1);
	 	}
	}
	function changeHideColumn(){
	    if(document.form.f_isViewAct.checked == false)  {
	        sheetObjects[0].SetColHidden("cost_act_grp_nm",1);
	        //sheetObjects[1].ColHidden("cost_act_grp_nm") = true;
	    } else {
	        sheetObjects[0].SetColHidden("cost_act_grp_nm",0);
	        //sheetObjects[1].ColHidden("cost_act_grp_nm") = false;
	    }
	}
	/**
	* Displayed R.Lane by ifram
	*/
	function f_rhq_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true)
			return;
		var formObj=document.form;
		var sheetObj=sheet1;
		if (comboObj.GetSelectText()!= "") {
			formObj.f_cmd.value=SEARCHLIST13;
 			var sXml=sheetObj.GetSearchData("ESM_COA_0081GS.do", coaFormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_ctrl_ofc_cd, "code", "code");
			f_ctrl_ofc_cd.SetSelectIndex(0);
		}
		comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	}

	function f_ctrl_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	}
	/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
	*/
	function loadPage() {
		var formObject=document.form;
		loadingMode=true;
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    // handling multi-combo object
		//---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		//---------------------------------------------
		loadingMode=false;
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
		f_rhq_cd.SetEnable(0);
		f_ctrl_ofc_cd.SetEnable(0);
	}
	/**
 * initializing Tab
 * setting Tab items
	 */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			Index=0;
			SetDropHeight(300);
			SetSelectIndex(0);
			ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
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
			case 1:	//sheet1 init
			    with(sheetObj){
			      var HeadTitle="H|subsum|Month|Week|RHQ|Control Office|H|Cost Group|H|KPI|Volume|Expense|Unit Cost|kpiOrder";
	
			      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0, PrevColumnMergeMode:0} );
	
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_report",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmonwk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cost_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lgs_kpi_cost_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"kpi_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"total_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"unit_cost",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"kpi_order",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];

			      
			      InitColumns(cols);
			      SetEditable(0);//Editkind[optional,Defaultfalse]
			      SetCountPosition(0);
			      
			      if(document.form.f_split_mw.checked){								
					ShowSubSum([{StdCol:"p_report", SumCols:"vol", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"TOTAL"},
								{StdCol:"cost_yrmonwk", SumCols:"vol", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Mon/Week"}]);
				  } else {
					ShowSubSum([{StdCol:"p_report", SumCols:"vol", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"TOTAL"}]);
				  }
//			      SetSheetHeight(430);
				  resizeSheet();

		     }
		    break;
		}
	}
	/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
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
	* Setting the hidden item after sheet1 inquiry
	*/
	function sheet1_OnSearchEnd(sheetObj, errMessge) {
		ComOpenWait(false);
//		sheetObjects[1].RemoveAll();
		//sheetObj.LastRow
		//sheetObj.CellValue(sheetObj.LastRow, "vol") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "vol");
		//1:worldwide, 2:RHQ, 3:Control Office
		//1:RHQ, 2:Control Office, 3:Sub Office
	    sheetObj.SetColHidden("rhq_cd",0);
	    sheetObj.SetColHidden("ctrl_ofc_cd",0);
	    sheetObj.SetColHidden("ofc_cd",0);
	    if(sheetObj.GetCellValue(1, "p_report") == '1'){
		    sheetObj.SetColHidden("rhq_cd",1);
		    sheetObj.SetColHidden("ctrl_ofc_cd",1);
		    sheetObj.SetColHidden("ofc_cd",1);
	    	} else if(sheetObj.GetCellValue(1, "p_report") == '2'){ //2
	 	    sheetObj.SetColHidden("ctrl_ofc_cd",1);
		    sheetObj.SetColHidden("ofc_cd",1);
		}
	    
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:          //Inquiry
        	//SJH.20150106.ADD/MOD
        	formObj.f_yearM.value=ComGetNowInfo("yy");
    	    formObj.f_year.value=ComGetNowInfo("yy");            
    	    formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
    	    formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0"); 
	    	
	        sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
 			var sXml=sheetObj.GetSearchData("ESM_COA_0158GS.do", coaFormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			
          	//SJH.20150106.ADD/MOD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
	        
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], f_report, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_rhq_cd, "code", "code");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], f_ctrl_ofc_cd, "code", "code");
			
			ComOpenWait(false);
			break;	
		case IBSEARCH:	//Inquiry
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1" ) {
						// Prohibit button click when a business transaction is processing 
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCHLIST01;
 						sheetObj.DoSearch("ESM_COA_0158GS.do", coaFormQueryString(formObj) );
//						ComOpenWait(false);
					}
				}
				break;
			case IBSAVE:	//Save
				break;
			case IBINSERT:	// Insert
				sheetObj.DataInsert();
				break;
			case IBCOPYROW:		//copy row
				sheetObj.DataCopy();
				break;
			case IBDOWNEXCEL:		//download excell
				var excelType=selectDownExcelMethod(sheetObj);
				break;
			case IBLOADEXCEL:		//upload excell
 				sheetObj.LoadExcel();
				break;
		}
	}
	
	function callBackExcelMethod(excelType){
		var sheetObj = sheet1;
		switch (excelType) {
	        case "AY":
	            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            break;
	        case "AN":
		    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	        case "DY":
	        	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	        	break;
	        case "DN":
		    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		}
	}	
	
 	/**
	* Handling process for form object input validation
	* SJH.20150106.MOD
	*/
	function validateForm(sheetObj,formObj,sAction){
		if(!chkValidSearch()) return false;
		if(f_report.GetSelectCode()== 3) {//control office
		    if(f_rhq_cd.GetSelectIndex()== 0 || f_rhq_cd.GetSelectCode()== '') {
				ComShowMessage(ComGetMsg("COM12113", "RHQ"));
				return false;
		    }
		}
		return true;
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
