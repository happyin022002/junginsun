/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0214.js
*@FileTitle  : Reefer Spare Part Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
		  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
							MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
							COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* Developer's task	*/
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Defining event handler of button click */
	document.onclick=processButtonClick;
	//Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
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
			case "btn_ok":
				if(sheetObjects[0].FindCheckedRow("sel_chk") == ""){
					ComShowCodeMessage("MNR00038","SELECT ");
				} else {
					var opener = window.dialogArguments;
					if (!opener) opener = parent;
					if(opener != undefined)
					{
						var checkValue=sheetObjects[0].GetRangeText(sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(),  sheetObjects[0].LastCol(), "|", "^");
						opener.setPopUpParam_EES_MNR_0214(checkValue);
						ComClosePopup(); 
					}else{
						comPopupOK();
					}
				}
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
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
				var HeadTitle1="|SEL.|Seq.|Unit Type|Part Name|Part No.|Type A|Type B|Type C|Remark(s)";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet1_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
	            if(typeof(window.dialogArguments)!="undefined")
	            {
	            	if(window.dialogArguments.document.form.sel_type.value=="M")
	            		cols.push({Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk" });
	            	else if(window.dialogArguments.document.form.sel_type.value=="S")
	            		cols.push({Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk" });
	            }else{
	            	cols.push({Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk" });
	            }
	            cols.push({Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" });
	            cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_ut_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            cols.push({Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:prefix+"spr_prt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 });
	            cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 });
	            cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 });
	            cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	 
	            InitColumns(cols);
	            SetSheetHeight(200);
	            SetEditable(1);
            }
		    break;
		}
	}
	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		MnrWaitControl(true);
		for(i=0;i<sheetObjects.length;i++)
		{
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		var formObject=document.form;
		combo_spr_ut_tp_nm.SetSelectCode(opener.sheetObjects[0].GetCellValue(opener.sheetObjects[0].GetSelectRow(),"sheet1_spr_prt_ut_tp_nm"));

		formObject.combo_spr_ut_tp_nm_text.value = combo_spr_ut_tp_nm.GetSelectCode();
		combo_spr_ut_tp_nm.SetEnable(0);
		formObject.spr_prt_spl_tp_cd.value=opener.combo_spr_prt_spl_tp_cd.GetSelectCode();
		formObject.spr_prt_spl_tp_nm.value=opener.combo_spr_prt_spl_tp_cd.GetSelectText();
		if(opener.document.form.cost_ofc_cd!=undefined)
		{
			formObject.cost_ofc_cd.value=opener.document.form.cost_ofc_cd.value;
		}
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		MnrWaitControl(false);
	}
	/**
	 * Initializing multi combo
	 * @return
	 */
	function initCombo() {
		var formObject=document.form
		with (combo_spr_ut_tp_nm)
		{
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "100");
			SetDropHeight(160);
			SetEnable(1);
		}
	}
	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction)
		{
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value="";
			formObj.cost_ofc_cd.value=currOfcCd;
			combo_spr_ut_tp_nm.RemoveAll();
			combo_spr_ut_tp_nm.SetSelectCode("-1",false);
			var sCondition=new Array (
					new Array("MnrGenCd","CD00009", "COMMON")	//Unit Type
				);
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			var sheetComboText="";
			var sheetComboCode="";
			var sheetComboCodeText="";
			var sheetComboDefault="";
			for(var i=0; i<comboList.length; i++)
			{
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboDefault="";
				if(comboList[i] != null)
				{
					if(i==0){
						combo_spr_ut_tp_nm.InsertItem(0, "All" ," ");
					}
					for(var j=0; j < comboList[i].length;j++)
					{
						var xmlVal=comboList[i][j].split("|");
						sheetComboText +=  xmlVal[1] + "|";
						sheetComboCode +=  xmlVal[0] + "|";
						sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
						if(j ==0){
							sheetComboDefault=xmlVal[0];
						}
						if(i==0){
							combo_spr_ut_tp_nm.InsertItem(j+1, xmlVal[1] ,xmlVal[0]);
						}
					}
					if(i==0){
						sheetObjects[0].InitDataCombo(0, "sheet1_spr_ut_tp_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
				else
				{
					if(i==0){
						ComShowCodeMessage("MNR00005", "Unit Type   ");
					}
				}
			}
			combo_spr_ut_tp_nm.SetSelectIndex(0);
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			break;
		case IBSEARCH:      //Retrieving
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="";
			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			formObj.spr_ut_tp_nm.value=combo_spr_ut_tp_nm.GetSelectCode();
			var sParam="";
			var aryPrefix=new Array("sheet1_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			//alert("IBSEARCH : " + "\n"+ sParam);
			var sXml=sheetObj.GetSearchData("EES_MNR_0214GS.do", sParam);
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
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet1_";
		MnrWaitControl(false);
		nowLoad=0;
	}
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		var checkValue=sheetObjects[0].GetRangeText(Row, 1, Row,  sheetObj.LastCol(), "|", "^");
		opener.setPopUpParam_EES_MNR_0214(checkValue);
		ComClosePopup(); 
	}
