	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName : EES_MNR_0217.js
	*@FileTitle : M&R Colleague Tree
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/05/22
	=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends 
	 * @class EES_MNR_0217 : business script for EES_MNR_0217.
	 */
	/* developer job	*/
	//common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var initInd='N';
	var mainMsg='M&R Colleague Tree';
	var subMsg='XXX';
	var nowLoad=0;
	var regionalHQ="";
	var operationOfc="";
	var HOOfc="";	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_RowAdd":
				doRowAdd(sheetObjects[0], formObject);
				break;
			case "btn_RowDelete":
				ComRowHideDelete(sheetObjects[0],"del_chk");
				break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
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
		MnrWaitControl(true);
		nowLoad=1;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
		///sheetObjects[0].SetWaitImageVisible(0);
		initCombo(); 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		nowLoad=0;
		MnrWaitControl(false);
	}
	/**
	 * setting Operation Office on loading
	 * @return
	 */
	function initOperationOfc(){
		var result="";
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH","NOTHQ")   //Office
			);   
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		if(comboList[0] != null){
			for(var i=0; i < comboList[0].length;i++){ 
				var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				result=result + code + "|";
			}
			result=result.substring(0, result.length - 1);
			sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("ofc_cd"), {ComboText:result, ComboCode:result} );
		}
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch(sheetId) {
		case "sheet1":
			    with(sheetObj){
						
					  var HeadTitle="|Del|Seq.|Regional HQ|Operation Office|Work Type|User Id|User Name|User E-mail|Remark(s)";
					  var headCount=ComCountHeadTitle(HeadTitle);

					  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );

					  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);

					  var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
							 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
							 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ar_hd_qtr_ofc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"ComboEdit", Hidden:0, Width:125,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:6 },
							 {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"mnr_grp_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"cntc_usr_id",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"usr_eml",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"mnr_cntc_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
							 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_mnr_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_cntc_usr_id",    KeyField:0,   CalcLogic:"",   Format:"" } ];
					   
						InitColumns(cols);

						SetEditable(1);
						SetCountPosition(0);
						SetSelectionMode(smSelectionRow);
						SetColProperty(0 ,"mnr_cntc_rmk" , {AcceptKeys:"E|[0123456789]|[~`!@#$%^&*()-_+=:;\"' ]"});
						SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
						PopupImage="img/btns_search.gif";
						SetShowButtonImage(2);
//						SetSheetHeight(342);
						resizeSheet( sheetObj );
					  }


			break;
		}
	}
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		///sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBSEARCH:      //retrieving
			MnrWaitControl(true);
			sheetObjects[0].SetWaitImageVisible(0);
			formObj.f_cmd.value=SEARCH;
			//alert(FormQueryString(formObj));
			var sXml=sheetObj.GetSearchData("EES_MNR_0217GS.do",  FormQueryString(formObj));
			//alert(sXml);
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );

			break;
		case IBSAVE:        //saving
		doIBSAVE(sheetObj,formObj,sAction);
		break;
		case IBCLEAR:
			MnrWaitControl(true);
			nowLoad=1;
	    	ComOpenWait(true);
			//initializing Combo Data
			combo1.RemoveAll();
			combo2.RemoveAll();
			//retrieving Combo
			var sCondition=new Array (
					new Array("MnrGenCd","HOOFC", "COMMON") //Regional HQ
					,new Array("MnrGenCd","CD00006", "COMMON")  //Work Type
					,new Array("MdmOrganization","RHQ","FALSE")   //Regional HQ
			);
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			//setting sheet
			var sheetComboText="";
			var sheetComboCode="";
			var sheetComboCodeText="";
			var sheetComboDefault="";
			regionalHQ="";
			for(var i=0; i < comboList.length;i++)
			{
				//initializing sheetCombo
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboDefault=""; 
				if(comboList[i] != null)
				{
					for(var j=0; j < comboList[i].length;j++)
					{ 
						var tempText=comboList[i][j].split("|");   
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						if(j ==0){	
							sheetComboDefault=tempText[0];      	
						}
						if(i==0) {
							HOOfc=tempText[0];
						}else if(i==2)
						{
							combo1.InsertItem(j, comboList[i][j] , tempText[0]);
							combo1.SetSelectCode(tempText[0]);
							regionalHQ=regionalHQ + tempText[0] + "|";
						}
					}
					sheetComboText = MnrDelLastDelim(sheetComboText);
					sheetComboCode = MnrDelLastDelim(sheetComboCode);
					//setting sheet combo
					if(i == 1) {
						sheetObjects[0].SetColProperty(0,"mnr_grp_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
					}else if(i==2)
					{
						regionalHQ=regionalHQ.substring(0, regionalHQ.length - 1);
						combo1.SetSelectCode(rhqOfcCd);
						combo2.SetSelectCode("ALL");
					}
				}else{
					if(i==0){
						HOOfc="";
					}
				}
			}	    
			//initializing sheet
			sheetObj.RemoveAll();
			sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), {ComboText:regionalHQ, ComboCode:regionalHQ} );
			initOperationOfc();
			comboOnChange(combo1,combo1.GetSelectText(), combo1.GetSelectText());
			nowLoad=0;     
			MnrWaitControl(false);
	    	ComOpenWait(false);
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction==IBSAVE) {
				if (!ComChkValid(formObj)) return false;
				//duplicate checking When saving 
				for (var i=0; i<sheetObjects.length; i++){
					var Row=sheetObjects[i].ColValueDup("ofc_cd|mnr_grp_tp_cd|cntc_usr_id");
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	/**
	 * initializing multi Combo 
	 * @return
	 */
	function initCombo() {
		var formObject=document.form
		with (combo1) { 
			SetMultiSeparator("|");
			SetTitle("Office Code|Office Name");
			//MultiSelect = false;
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			//SetColWidth("100|150");    
			SetDropHeight(160);
			SetTitleVisible(1);
		} 
		with (combo2) { 
			SetMultiSeparator("|");
			SetTitle("Office Code|Office Name");
			//MultiSelect = false;
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			//SetColWidth("100|150");    
			SetDropHeight(160);
			SetTitleVisible(1);
		} 
	}
	/**
	 * //handling event in case of clicking row add button
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function doRowAdd(sheetObj, formObj){
		nowLoad=1;
		var iRow=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("cntc_usr_id"),"",0);
		sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
		//alert(HOOfc + " :: " + currOfcCd);
		//sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), formObj.combo1.Code, formObj.combo1.Code, formObj.combo1.Code);
	//	if(HOOfc != currOfcCd){ 
	//	sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = rhqOfcCd;
	//	cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
	//	sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
	//	}else{
		sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),combo1.GetSelectCode(),0);
		cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].GetCellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
		sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
	//	}
		nowLoad=0;
	}	  
	/**
	 * in case of onChange combo event
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function combo1_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if(nowLoad == 0){
			comboOnChange(combo1,newCode);
		}
	}
	/**
	 * handling in case of onChange combo event 
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function comboOnChange(comboObj,Index_Code){ 
		//alert(comboObj +" :: "+ Index_Code + " :: "+ Text);
		var formObj=document.form;
		combo2.RemoveAll();
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
			);   
		sheetObjects[0].SetWaitImageVisible(0);
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].SetWaitImageVisible(1);
		if(comboList[0] != null){
			for(var i=0; i < comboList[0].length;i++){ 
				var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				combo2.InsertItem(i, comboList[0][i] , code);
				combo2.SetSelectCode(code);
			}
			combo2.InsertItem(0, "ALL" , "ALL");
			combo2.SetSelectCode("ALL");
		}
		//sheetObjects[0].RemoveAll(); 
	} 
	/**
	 * checking validation of operation office.
	 * @param strhq
	 * @param strofc
	 * @param Row
	 * @param Col
	 * @return
	 */
	function  checkOperationOfc(strhq, strofc, Row, Col){
		var srchStr=strofc+","+strhq;
		var retArray=MnrGeneralCodeCheck(sheetObjects[0],"OFC",srchStr);
		if(retArray == null){
			ComShowCodeMessage("MNR00010", "Office");
			sheetObjects[0].SetCellValue(Row, sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
			sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ofc_cd"));
		}
	}
	/**
	 * handling OnChange event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
	//		if(HOOfc != currOfcCd){
	//		sheetObj.CellValue2(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = currOfcCd;
	//		cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), currOfcCd);
	//		}else{
			// setting value to Operation Office
			cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), Value);
	//		}  
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") ,"",0);
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm"),"");
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml"),"");
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("mnr_cntc_rmk"),"");
			sheetObjects[0].SetCellValue(Row,  sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
		}else if(sheetObj.ColSaveName(Col) == "cntc_usr_id"){
			checkUsrId(sheetObj.GetCellValue(Row, Col), Row, Col);
		}else if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			if(sheetObj.GetCellValue(Row, Col) != ""){
				checkOperationOfc(sheetObj.GetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")), sheetObj.GetCellValue(Row, Col), Row, Col);
			}
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") ,"",0);
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm"),"");
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml"),"");
			sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("mnr_cntc_rmk"),"");
		}
	}
	function checkUsrId(strid, Row, Col){
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("ComUser",strid,"COMMON") //Regional HQ
		);
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++)
		{
			if(comboList[i] != null){
				var xmlVal=comboList[i][0].split("|");
				//alert(xmlVal[0] + " ** "+ xmlVal[1]);
				sheetObjects[0].SetCellValue(Row,  sheetObjects[0].SaveNameCol("usr_nm"),xmlVal[0]);
				sheetObjects[0].SetCellValue(Row,  sheetObjects[0].SaveNameCol("usr_eml"),xmlVal[1]);
				return true;
			}else{
				ComShowCodeMessage("MNR00005", "USR_ID  ");
				sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") ,"",0);
				sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm"),"");
				sheetObjects[0].SetCellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml"),"");
				sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("cntc_usr_id"));
				return false;
			}
		}	
	}
	/**
	 * handling click event on sheet1.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnClick(sheetObj,Row, Col, Value){
		//alert("ONClick "+Value+ "<<<<<"+ HOOfc + " >>>> "+ currOfcCd); 
		if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			nowLoad=1;
	//		if(HOOfc != currOfcCd){
	//		sheetObj.CellValue2(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = currOfcCd;
	//		cellSetItems(sheetObjects[0], Row, sheetObjects[0].SaveNameCol("ofc_cd"),   currOfcCd);
	//		}else{
			// setting value to Operation Office
			cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"),  sheetObj.GetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
	//		}
			nowLoad=0;
		}
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		nowLoad=0;
		MnrWaitControl(false);
	}
	/**
	 * setting combo of operation office.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function cellSetItems(sheetObj, Row, Col, Value){
//		alert(sheetObj + " :: "+ Row + " :: "+ Col + " :: "+ Value);
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH",Value)   //Office
			);   
		sheetObjects[0].SetWaitImageVisible(0);
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].SetWaitImageVisible(1);
		if(comboList[0] != null){
			operationOfc="";
			for(var i=0; i < comboList[0].length;i++){ 
				var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				operationOfc=operationOfc + code + "|";
			}
			operationOfc=operationOfc.substring(0, operationOfc.length - 1);
			sheetObjects[0].CellComboItem(Row,Col, {ComboText:operationOfc, ComboCode:operationOfc} );
		}else{
			ComShowCodeMessage("MNR00010", "Regional H/Q Office");
			sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"));
		}
	}
	/**
	 * handling event when saving.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSAVE(sheetObj,formObj,sAction){
		MnrWaitControl(true);
		if(!validateForm(sheetObj,formObj,sAction)){
			MnrWaitControl(false);
			return;
		}
		formObj.f_cmd.value=MULTI;
		var sParam=ComGetSaveString(sheetObjects[0]);
		if (sParam == "")
		{
			MnrWaitControl(false);
			return;
		}
		sParam += "&" + FormQueryString(formObj) ;
		var sXml=sheetObj.GetSaveData("EES_MNR_0217GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
//		sheetObj.DoSave("EES_MNR_0217GS.do", sParam);
	}
	/**
	 * handling in case of clicking image button on sheet1
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObject=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch (sName) {
			case "cntc_usr_id":
				//alert(sheetObj.CellValue(Row, "ofc_cd"));
				ComOpenPopup("COM_ENS_091.do?ofc_cd="+ sheetObj.GetCellValue(Row, "ofc_cd"), 770, 580, 'setPopupParam', '1,0,1,1,1,1,1,1', true, false, Row, Col, 0);
				break;
			}
		}
	}
	/**
	 * function get parameter from popup
	 * @param aryPopupData
	 * @param Row
	 * @param Col
	 * @param SheetIdx
	 * @return
	 */
	function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
		//alert( aryPopupData + "::"+ Row + "::"+ Col+ "::"+SheetIdx);
		var str=aryPopupData +"";
		var arr=str.split(',');
		var sheetObj=sheetObjects[SheetIdx];
		sheetObj.SetCellValue( Row, Col ,arr[4],0);
		if(checkUsrId(arr[4], Row, Col)){
			sheetObj.SetCellValue( Row, ++Col ,arr[5]);
			sheetObj.SetCellValue( Row, ++Col ,arr[6]);
		}
	}
	/**
	 * loading message after saving
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */   
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		 var formObj=document.form;
		if (ErrMsg == "" || ErrMsg == -4) { 
			ComShowCodeMessage("MNR00023");   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	/* developer job */
