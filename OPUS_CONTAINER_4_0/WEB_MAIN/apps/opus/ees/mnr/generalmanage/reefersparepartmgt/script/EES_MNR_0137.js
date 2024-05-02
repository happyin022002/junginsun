	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName : EES_MNR_0137.js
	*@FileTitle : Standard Reefer Spare Parts List of the vsl
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/05/09
	=========================================================*/
	/****************************************************************************************
					  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
										MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
										COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0137 : ees_mnr_0137 - Defining a script used by screen
	 */
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
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_del":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
					calReq=0;
				}
				break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
				break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_downexcel":
				
				 if(sheetObj.RowCount() < 1){//no data
					  ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel();
					}
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
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
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
			  var HeadTitle1="|Sel|Seq.|Unit Type|Part Name|Part No.|Type|Type A|Type B|Type C|Remark(s)";
			  var prefix="sheet1_";

			  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_ut_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"spr_prt_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"spr_prt_spl_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_tp_flg3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"spr_prt_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
					InitColumns(cols);

					SetEditable(1);
					SetColProperty(0, prefix + "spr_prt_no", {AcceptKeys:"E|N|[-]", InputCaseSensitive:1});
					resizeSheet();
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
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
	}
	/**
	 * Initializing multi combo
	 * @return
	 */
	function initCombo() {
		var formObject=document.form
		with (combo_spr_ut_tp_nm) {
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "100");
			SetDropHeight(160);
			SetEnable(1);
		}
		with (combo_spr_tp_cd) {
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
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
			combo_spr_ut_tp_nm.SetSelectCode("-1",false);
			combo_spr_tp_cd.SetSelectCode("-1",false);
			combo_spr_ut_tp_nm.RemoveAll();
			combo_spr_tp_cd.RemoveAll();
			var sCondition=new Array (
					new Array("MnrGenCd","CD00009", "COMMON")	//Unit Type
					,new Array("MnrGenCd","CD00031", "CUSTOM8") // Spare Type
					,new Array("MnrGenCd","CD00037", "COMMON") //Supply To
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
					}else if(i==1){
						combo_spr_tp_cd.InsertItem(0, "All" ," ");
					}
					for(var j=0; j < comboList[i].length;j++)
					{
						var xmlVal=comboList[i][j].split("|");
						if(i==0){
							combo_spr_ut_tp_nm.InsertItem(j+1, xmlVal[1] ,xmlVal[0]);
							sheetComboText +=  xmlVal[1] + "|";
							sheetComboCode +=  xmlVal[0] + "|";
							sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
							if(j ==0){
								sheetComboDefault=xmlVal[0];
							}
						}else if(i==1){
							combo_spr_tp_cd.InsertItem(j+1, xmlVal[1] , xmlVal[0]);
						}else if(i==2){
							sheetComboText +=  xmlVal[1] + "|";
							sheetComboCode +=  xmlVal[0] + "|";
						}
					}
					if(i==0){
						sheetObjects[0].InitDataCombo (0, "sheet1_spr_ut_tp_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}else if(i==2){
						sheetObjects[0].InitDataCombo (0, "sheet1_spr_prt_spl_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
				else
				{
					if(i==0){
						ComShowCodeMessage("MNR00005", "EQ Type   ");
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Status    ");
					}
				}
			}
			combo_spr_ut_tp_nm.SetSelectIndex(0);
			combo_spr_tp_cd.SetSelectIndex(0);
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
			formObj.spr_prt_no.value="";
			formObj.spr_ut_tp_nm.value=combo_spr_ut_tp_nm.GetSelectCode();
			formObj.spr_tp_cd.value=combo_spr_tp_cd.GetSelectCode();
			formObj.spr_prt_spl_tp_cd.value='';
			var sParam="";
			var aryPrefix=new Array("sheet1_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0137GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				//sheetObjects[i].RenderSheet(0);
				sheetObjects[i].SetWaitImageVisible(0);
				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
				//sheetObjects[i].RenderSheet(1);
			}
			break;
		case IBINSERT:
			nowLoad=1;
			if(!validateForm(sheetObj,formObj,sAction))return;
			//MnrWaitControl(true);
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellBackColor(row,"sheet1_spr_prt_no","#NANNANNAN");
			sheetObj.SetCellEditable(row,"sheet1_spr_prt_no",1);
			sheetObj.SetCellEditable(row,"sheet1_spr_prt_spl_tp_cd",1);
			sheetObj.SetCellValue(row, "sheet1_spr_prt_qty","1",0);
			sheetObj.SetCellValue(row, "sheet1_spr_ut_tp_nm","",0);
			sheetObj.SelectCell(row, "sheet1_spr_ut_tp_nm");
			break;
		case IBSAVE:        //Saving
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet1_");
			var sParam=ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
			//ComDebug(sParam);
			var sXml=sheetObj.GetSaveData("EES_MNR_0137GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			break;
		}
	}
	/**
	 * Checking part number of input data of unique
	 */
	function sheet1_spr_prt_no_UniqueCheck(sheetObj,formObj,Row){
		formObj.f_cmd.value=SEARCH;
		formObj.spr_prt_no.value=sheetObj.GetCellValue(Row,"sheet1_spr_prt_no");
		formObj.spr_ut_tp_nm.value="";
		formObj.spr_tp_cd.value="";
		formObj.spr_prt_spl_tp_cd.value=sheetObj.GetCellValue(Row,"sheet1_spr_prt_spl_tp_cd");
		formObj.spr_work_type.value='check';
		var sParam="";
		var aryPrefix=new Array("sheet1_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("EES_MNR_0137GS.do", sParam);
	    if(!MnrIsEmptyXml(sXml)) {
			return false;
	    }
	    return true;
	}
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//Saving
			if(sAction==IBSAVE)
			{
				//Checking row count
				var rCnt=sheetObj.RowCount();
				if(rCnt<=0)
				{
					return false;
				}
				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
				{
					//Checking mandatory of unit type
					var strSel=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_ut_tp_nm")," ");
					if(strSel=="")
					{
						ComShowCodeMessage("MNR00036","Unit Type");
						sheetObj.SelectCell(i, "sheet1_spr_ut_tp_nm",true);
						return false;
					}
					//Checking mandatory of part name
					var strInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_prt_nm")," ");
					if(strInput=="")
					{
						ComShowCodeMessage("MNR00172","Part Name ");
						sheetObj.SelectCell(i, "sheet1_spr_prt_nm",true);
						return false;
					}
					//Checking mandatory of part number
					var strInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_prt_no")," ");
					if(strInput=="")
					{
						ComShowCodeMessage("MNR00172","Part No.");
						sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
						return false;
					}
					if(sheetObj.GetRowStatus(i) == 'I')
					{
						if(!sheet1_spr_prt_no_UniqueCheck(sheetObj,formObj,i)){
							sheetObj.SetCellValue(i,"sheet1_spr_prt_no","",0);
							sheetObj.SetCellValue(i,"sheet1_spr_prt_spl_tp_cd","",0);
							ComShowCodeMessage("MNR00006","Part No and Type");
							sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
							return false;
						}
					}
					//Checking option by Type (Type A, Type B, Type C)
					if(sheetObj.GetCellValue(i, "sheet1_spr_prt_spl_tp_cd")=="V"){
					var strFlg_1=sheetObj.GetCellValue(i, "sheet1_spr_prt_tp_flg1");
					var strFlg_2=sheetObj.GetCellValue(i, "sheet1_spr_prt_tp_flg2");
					var strFlg_3=sheetObj.GetCellValue(i, "sheet1_spr_prt_tp_flg3");
						if(strFlg_1=="0" && strFlg_2=="0"  && strFlg_3=="0")
						{
							ComShowCodeMessage("MNR00239","Type A, Type B, Type C");
							sheetObj.SelectCell(i, "sheet1_spr_prt_tp_flg1",true);
							return false;
						}
					}
				}
			}
			//Checking duplicate inputting data (PART NO)
			var Row=sheetObj.ColValueDup("sheet1_spr_prt_no|sheet1_spr_prt_spl_tp_cd",false);
			if(Row>0){
				sheetObj.SetCellValue(Row,"sheet1_spr_prt_no","",0);
				sheetObj.SetCellValue(Row,"sheet1_spr_prt_spl_tp_cd","",0);
				ComShowCodeMessage("MNR00006","Part No and Type");
				sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
				return false;
			}
			//At retrieving
			else if(sAction==IBSEARCH)
			{
				var sRow=sheetObj.FindStatusRow("I|U|D");
				if(sRow != "")
				{
					if(!ComShowCodeConfirm("MNR00007"))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_spl_tp_cd"){
			if(sheetObj.GetCellValue(Row, "sheet1_spr_prt_spl_tp_cd")=="V"){
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg1",1);
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg2",1);
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg3",1);
			}else{
				sheetObj.SetCellValue(Row, "sheet1_spr_prt_tp_flg1","0",0);
				sheetObj.SetCellValue(Row, "sheet1_spr_prt_tp_flg2","0",0);
				sheetObj.SetCellValue(Row, "sheet1_spr_prt_tp_flg3","0",0);
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg1",0);
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg2",0);
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_tp_flg3",0);
			}
		}
	}
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj=document.form;
		if(OldRow !=NewRow){
			if (nowLoad != 0) return;
				if(sheetObj.GetCellValue(NewRow,"sheet1_ibflag")== "I"){
					sheetObj.SetCellBackColor(NewRow,"sheet1_spr_prt_no","#NANNANNAN");
					sheetObj.SetCellEditable(NewRow,"sheet1_spr_prt_no",1);
				}else{
					sheetObj.SetCellBackColor(NewRow,"sheet1_spr_prt_no","#NANNANNAN");
					sheetObj.SetCellEditable(NewRow,"sheet1_spr_prt_no",0);
				}
			return;
		}
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet1_";
		MnrWaitControl(false);
		nowLoad=0;
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)	{
			if(sheetObj.GetCellValue(i, "sheet1_spr_prt_spl_tp_cd")=="V"){
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg1",1);
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg2",1);
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg3",1);
			}else{
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg1",0);
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg2",0);
				sheetObj.SetCellEditable(i,"sheet1_spr_prt_tp_flg3",0);
			}
		}
		formObj.spr_prt_no.value="";
		formObj.spr_ut_tp_nm.value="";
		formObj.spr_tp_cd.value="";
		formObj.spr_prt_spl_tp_cd.value="";
		formObj.spr_ut_tp_nm.value="";
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") {
				ComShowCodeMessage("MNR00009","Standard Reefer Spare Parts List");
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad=0;
		MnrWaitControl(false);
	}
