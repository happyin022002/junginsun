/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0198.js 
*@FileTitle  : Reefer Spare Kit Type Inquiry_Pop Up 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
		  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_mnr_0198 : business script for ees_mnr_0198.
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
    var comboCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
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
    /**
     * registering IBCombo Object as list
     * param : combo_obj
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|Seq.|Unit Type|Part Name|Part No.|Type A|Type B|Type C|Remark(s)";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet1_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_ut_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"spr_prt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(260);
	            }
		    break;
		}
	}
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value="";
			formObj.cost_ofc_cd.value=currOfcCd;
			combo_spr_tp_cd.SetSelectCode("-1",false);
			combo_spr_tp_cd.RemoveAll();
			var sCondition=new Array (
				new Array("MnrGenCd","CD00031", "CUSTOM8") //Spare Type			
				,new Array("MnrGenCd","CD00009", "COMMON")  //Unit Type Sheet Combo 
			);
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			//setting sheet
			var sheetComboText="";
			var sheetComboCode="";
			var sheetComboCodeText="";
			var sheetComboDefault="";
			for(var i=0; i < comboList.length;i++){
				//initializing sheetCombo
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboDefault=""; 
				if(comboList[i] != null){
					if(i==0)
					{
						combo_spr_tp_cd.InsertItem(0, "All", " ");
					}
					for(var j=0; j < comboList[i].length;j++){ 
						var tempText=comboList[i][j].split("|");   
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						if(j ==0){	
							sheetComboDefault=tempText[0];      	
						}
						if(i==0) {
							combo_spr_tp_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
						}
					}
					if(i==0){
						combo_spr_tp_cd.SetSelectIndex("0");
					}
					//setting sheet combo
					if(i == 0) {
						sheetObjects[0].SetColProperty(0,"sheet1_spr_ut_tp_nm", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
					}
				}
			}
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			break;	
		case IBSEARCH:      //retrieving
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="";
			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value=SEARCH; 
			formObj.spr_tp_cd.value=combo_spr_tp_cd.GetSelectCode();
			var sParam="";
			var aryPrefix=new Array("sheet1_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0198GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				sheetObjects[i].RenderSheet(0);
				sheetObjects[i].SetWaitImageVisible(0);
				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
				sheetObjects[i].RenderSheet(1);
			}   
			break;		
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}		
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
//		combo_spr_tp_cd_text.value = "All";
		MnrWaitControl(false);
	}
	/**
	 * initializing multi Combo 
	 * @return
	 */
	function initCombo() {
		var formObject=document.form
		with (combo_spr_tp_cd) {
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
			SetDropHeight(160);
			SetEnable(1);
		}
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet1_";
		MnrWaitControl(false);
		nowLoad=0;
	}
	
//	function combo_spr_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//		 document.form.combo_spr_tp_cd_text.value = combo_spr_tp_cd.GetText(parseInt(combo_spr_tp_cd.GetSelectIndex()), 0);
//	}
//	
//	function combo_spr_tp_cd_OnBlur() {
//		document.form.combo_spr_tp_cd_text.value = combo_spr_tp_cd.GetText(parseInt(combo_spr_tp_cd.GetSelectIndex()), 0);
//	}