/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0001.js
*@FileTitle  : Default Setting 화면 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var usrOfcCd="";/*office cd of SSO user */
var isDup=true;
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Add":
			
			var temp=sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_yd_cd1")+sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_yd_cd2");
			var Row=-1;
			for( var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow(); i++ ) {
				if( temp == sheetObjects[0].GetCellValue( i, "sheet1_yd_cd1")+sheetObjects[0].GetCellValue(i, "sheet1_yd_cd2") && sheetObjects[0].GetCellValue( i, "sheet1_ibflag") != "D" )
					Row=i;
			}	
			if( sheetObject1.LastRow()> 0 ) {
				if(sheetObject1.GetCellValue(sheetObject1.LastRow(), 0) == "R" && sheetObject1.GetCellValue(sheetObject1.LastRow(), 3) == "" ){
					sheetObject1.RemoveAll();
				}	
				if(sheetObject1.GetCellValue(sheetObject1.LastRow(), 3) == "" ){
					ComShowCodeMessage('PSO00001','');
					return;    	  		
				} else if ( Row != "" && Row != "-1" ){
					ComShowCodeMessage('PSO00002','');
					return;    	  		
				}
			}	
			var insertRow = sheetObject1.DataInsert(-1);
			//var vals = comboItems2.split("|");
			sheetObject1.CellComboItem(insertRow,3, {ComboText:"|", ComboCode:"|"} );
			sheetObject1.SelectCell(insertRow,"sheet1_yd_cd1");
			break;
		case "btn_Add2":
			var temp=sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), 2);
			var Row=-1;
			for( var i=sheetObjects[1].HeaderRows(); i < sheetObjects[1].LastRow(); i++ ) {
				if( temp == sheetObjects[1].GetCellValue( i, 2) && sheetObjects[1].GetCellValue( i, "sheet2_ibflag") != "D" )
					Row=i;
			}
			if( sheetObject2.LastRow()> 0 ) {
				if(sheetObject2.GetCellValue(sheetObject2.LastRow(), 0) == "R" && sheetObject2.GetCellValue(sheetObject2.LastRow(), 3) == "" ){
					sheetObject2.RemoveAll();
				}	
				if(sheetObject2.GetCellValue(sheetObject2.LastRow(), 3) == "" ){
					ComShowCodeMessage('PSO00001','');
					return;    	  		
				} else if ( Row != "-1" ){
					ComShowCodeMessage('PSO00002','');
					return;    	  		
				}
			}	
			var insertRow = sheetObject2.DataInsert(-1);
			sheetObject2.SelectCell(insertRow,"sheet2_vndr_seq");
			break;
		case "btn_Del":
			ComRowHideDelete(sheetObject1, "sheet1_del_chk");
			break;
		case "btn_Del2":
			ComRowHideDelete(sheetObject2, "sheet2_del_chk");
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	var formObject=document.form;
	formObject.ofc_cd.value=usrOfcCd; //ofc cd
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	resizeSheet();
	
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Sel.|Terminal|Terminal|Updated User|Updated Date";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet1_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
				             {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_usr_id"	, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_dt"		, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
				SetShowButtonImage(1);
				SetShowMsgMode(0);
				SetSheetHeight(180);
				SetCountPosition(0);
				SetColProperty(0, prefix+"yd_cd1" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			}
		    break;
		case "sheet2":
		    with(sheetObj){
				var HeadTitle1="|Sel.|Service Provider Code|Service Provider Name|Updated User|Updated Date";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet2_";
	
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
				             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"Number",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0, Width:400,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:90,  Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_usr_id"	, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_dt"		, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(0);
				SetShowButtonImage(1);
				SetShowMsgMode(0);
				SetSheetHeight(180);
				SetColProperty(prefix+"vndr_seq" , {AcceptKeys:"N" , InputCaseSensitive:1});
				SetEditTabBehavior(true);
			}
		    break;
		case "sheet3":
			with(sheetObj){
				var HeadTitle1="Status|Seq.|Account Code||Cost Code|Description|Updated User|Updated Date|";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet3_";
	
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk" },
				             {Type:"Text",      Hidden:0,  Width:155,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:650,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_usr_id"	, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",    ColMerge:1,   SaveName:prefix+"upd_dt"		, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:25,  Align:"Left",    ColMerge:1,   SaveName:prefix+"charge_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
	
				SetEditable(1);
				SetCountPosition(0);
	            SetShowMsgMode(0);
	            //SetSheetHeight(280);
	            
	      	}
			break;
		}
}

function doSearch(){
	var formObject=document.form;
	doActionIBSheet( sheetObjects[0], formObject,IBSEARCH);
}

// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet3_" );
	switch(sAction) {
		case IBSEARCH:      //Retrieving
			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[1].SetWaitImageVisible(0);
			sheetObjects[2].SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObjects[2].GetSearchData("VOP_PSO_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var comboItems=ComGetEtcData(sXml, "lane");
			var comboItems1="";
			var comboItems2="";
			if ( !comboItems.length ) {
				var comboItem=comboItems.split(",");
				comboItems1=comboItem[0];
				comboItems2=comboItem[1]; 		
			} else {
				comboItems=comboItems.split("|");
				for (var i=0 ; i < comboItems.length ; i++) {
					var comboItem=comboItems[i].split(",");
					if( i == 0 ){
						comboItems1=comboItem[0];
						comboItems2=comboItem[1]; 
					} else {
						comboItems1=comboItems1 + "|" +comboItem[0];
						comboItems2=comboItems2 + "|" +comboItem[1]; 
					}	
				}   		
			}
			sheetObj.SetColProperty(aryPrefix[0]+"yd_cd2", {ComboText:comboItems1, ComboCode:comboItems2} );
			formObj.f_cmd.value=SEARCH;//COMBO
			var sXml=sheetObjects[2].GetSearchData("VOP_PSO_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			for(var i=0; i < arrXml.length; i++){    
				if(i < 2) {
					sheetObjects[i].SetWaitImageVisible(0);
				}  
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
			}
			ComOpenWait(false);
			gf_SetGetHeaderCheck(sheetObjects[2], "0", "sheet3_chk");
		break;
		case IBSAVE:        //Save
			sheetObj.ShowDebugMsg(false);
			formObj.f_cmd.value=MULTI;
			isDup=validateForm(sheetObj,formObj,sAction);
			if( !isDup ) return;
			
			var iSheet1ModCnt = sheetObjects[0].RowCount("I") + sheetObjects[0].RowCount("U") + sheetObjects[0].RowCount("D") ;
			var iSheet2ModCnt = sheetObjects[1].RowCount("I") + sheetObjects[1].RowCount("U") + sheetObjects[1].RowCount("D") ;
			var iSheet3ModCnt = sheetObjects[2].RowCount("I") + sheetObjects[2].RowCount("U") + sheetObjects[2].RowCount("D") ;
			
			if(iSheet1ModCnt == 0 && iSheet2ModCnt == 0 && iSheet3ModCnt == 0){
				return;
			}
			
			ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[1].SetWaitImageVisible(0);
			sheetObjects[2].SetWaitImageVisible(0);
			var sParam=ComGetSaveString(sheetObjects, true, true, -1);
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObjects[2].GetSaveData("VOP_PSO_0001GS.do", sParam);
			sheetObjects[2].LoadSaveData(sXml, {Sync:1});
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);	//재Retrieving
			ComOpenWait(false);
		break;
	}
} 

function valid() {
	var Row=sheetObjects[0].ColValueDup(2);
	if( Row != -1 || sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), 3) == "" ){
		return false;    	  		
	}	
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){

		if( sheetObjects[0].RowCount()> 0 ) {
			for( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++ ) {
				if(sheetObjects[0].GetCellValue(i, "sheet1_yd_cd1") == "" ||  sheetObjects[0].GetCellValue(i, "sheet1_yd_cd2") == "" ){
					ComShowCodeMessage('PSO00001',"Terminal");
					return false;    	  		
				}
			}
		}
		//Terminal Dup Check
		var iDupRow = sheetObjects[0].ColValueDup("sheet1_yd_cd1|sheet1_yd_cd2", false);
		if( iDupRow != -1){
			var varYdCd1 = sheetObjects[0].GetCellValue(iDupRow, "sheet1_yd_cd1");
			var varYdCd2 = sheetObjects[0].GetCellValue(iDupRow, "sheet1_yd_cd2");
			 ComShowCodeMessage("PSO00002", "["+varYdCd1 +" , "+ varYdCd2+"] Terminal");
			 return false;
		}
		
		//Service Provider Name input check
		if( sheetObjects[1].RowCount()> 0 ) {
			for( var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++ ) {
				if(sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), 3) == "" && sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), 0) != "D"  ){
					ComShowCodeMessage('PSO00001',"Service Provider");
					return false;       	  		
				}
			}
		}
		
		//Service Provider Code duplicate check
		var iVndrDupRow = sheetObjects[1].ColValueDup("sheet2_vndr_seq", false);
		if( iVndrDupRow != -1){
			var varVndrSeq = sheetObjects[1].GetCellValue(iVndrDupRow, "sheet2_vndr_seq");
			 ComShowCodeMessage("PSO00002", "["+varVndrSeq +"] Service Provider");
			 return false;
		}
		
	}
	return true;
}

/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var sUrl="/opuscntr/VOP_VSK_0043.do?op=0043";
	ComOpenPopup(sUrl, 805, 510, "getVOP_VSK_0043", "0,0,1,1,1,1,1,1", true);//NYK Modify 2014.10.21
}

/**
 * Location: In the single-selection pop-up hangyeongwoo.
 */
function getVOP_VSK_0043(rowArray) {
	var formObject=document.form;
	//Multi-select in the pop-up and made ​​ready to take over in the set-ateum!
//	var colArray=rowArray[0];
	var row_val=sheetObjects[0].GetSelectRow();   	//putting a value to the value hidden row
	var col_val=2;   								//putting the value of col value hidden
//	var in_val=colArray[3]; 
	sheet1.SetCellValue(row_val, col_val, rowArray,0);
	if(rowArray!=""){
		selectYard( row_val,col_val , rowArray);
	}
	
}

/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
 	ComOpenPopup('/opuscntr/COM_COM_0007.do?mdm_yn=Y', 770, 420, 'setPrntUsrRoleCd', '0,0', true, false, Row, Col, 0);
	//ComOpenPopup('/opuscntr/VOP_PSO_0205.do', 805, 510, 'setPrntUsrRoleCd', '0,0', true, false, Row, Col, 0);
}

function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
	var sheetObject=sheetObjects[1];
	var prefix="sheet2_";
	sheetObject.SetCellValue(row, prefix+"vndr_seq", aryPopupData[0][2]); //vndr_seq
	sheetObject.SetCellValue(row, prefix+"vndr_lgl_eng_nm", aryPopupData[0][3]); //vndr_nm
}

/**
 * IBSheet OnAfterEdit Event
 */
function selectYard( Row,Col , yardValue) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var prefix="sheet1_";
	formObj.f_cmd.value=SEARCHLIST;
	var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
	param=param + "&yd_cd1=" + yardValue; 
	var sXml=sheetObj.GetSearchData("VOP_PSO_0001GS.do", param );
	var comboItems=ComGetEtcData(sXml, "lane");
	comboItems1="";
	comboItems2="";
	if( comboItems == "" ){
		sheetObj.CellComboItem(Row,Col+1, {ComboText:"|", ComboCode:"|"} );
		ComShowCodeMessage('PSO00014','');
		sheetObj.SetCellValue(Row, prefix+"yd_cd1","",0);
		sheetObj.SetCellValue(Row, prefix+"yd_cd2","",0);
		sheetObj.SelectCell( Row , prefix+"yd_cd1" , true);
		return;
	}
	if ( !comboItems.length ) {
		var comboItem=comboItems.split(",");
		comboItems1=comboItem[0];
		comboItems2=comboItem[0]+"\t"+comboItem[1]; 		
	} else {
		comboItems=comboItems.split("|");
		for (var i=0 ; i < comboItems.length ; i++) {
			var comboItem=comboItems[i].split(",");
			if( i == 0 ){
				comboItems1=comboItem[0];
				comboItems2=comboItem[0]+"\t"+comboItem[1]; 
			} else {
				comboItems1=comboItems1 + "|" +comboItem[0];
				comboItems2=comboItems2 + "|" +comboItem[0]+"\t"+comboItem[1]; 
			}	
		}   		
	}
	if( comboItems1.trim() == undefined )
		comboItems1="";
	if( comboItems2.trim() == undefined )
		comboItems2="";
	sheetObj.CellComboItem(Row,Col+1, {ComboText:comboItems2, ComboCode:comboItems1} );
	sheetObj.SelectCell( Row , Col+1 , true);
}

/**
 * IBSheet OnKeyUp Event
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var prefix=sheetObj.id + "_";
	var formObj=document.form;
	if(Col == 2){
		var isEditableCell=sheetObj.GetCellEditable(Row, Col);
		if(!isEditableCell){
			return;
		}
		if(Value.length == 5){
			selectYard(Row, Col,Value);
			/*NYK MOdify 2014.10.29
			if(Value == "EGSCA" || Value == "PAPCA"){
				ComShowCodeMessage("PSO00040", "[EGSCA or PAPCA]");	//It is not permitted to input 'EGSCA' or 'PAPCA'.
				sheetObj.CellComboItem(Row,Col+1, {ComboText:"|", ComboCode:"|"} );
				sheetObj.SetCellValue(Row, prefix + "yd_cd2","");
				sheetObj.SetCellValue(Row, prefix + "yd_cd1","");
				sheetObj.SelectCell(Row, Col);
			} else{
				selectYard(Row, Col,Value);
			}*/
		} else{
			sheetObj.CellComboItem(Row,Col+1, {ComboText:"|", ComboCode:"|"} );
		}
	}
}

function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :
			//if Data check cancel, Canceling Header Check
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
		break;
	}
}

/**
 * IBSheet OnChange Event
 */
function sheet2_OnChange(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
	case prefix + "vndr_seq" :  
		formObj.f_cmd.value=SEARCHLIST01;
		var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		param=param + "&vndr_seq=" + sheetObj.GetCellValue(Row, Col);
		var sXml=sheetObj.GetSearchData("VOP_PSO_0001GS.do", param );
		var items=ComGetEtcData(sXml, "vendor");
		sheetObj.SetCellValue(Row,Col+1,items,0);
		if( items == "" || items == undefined ){
			ComShowCodeMessage('PSO00014','');
			sheetObj.SetCellValue(Row,Col,"",0);
			sheetObj.SelectCell( Row , prefix+"vndr_seq", true  );
		}
		break;
	}
}	

function sheet2_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet2_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :
			//if Data check cancel, Canceling Header Check
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
		break;
	}
} 

function sheet3_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet3_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "chk" :
			//if Data check cancel, Canceling Header Check
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "chk"));
		break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[2]);
	/*for (var i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }*/
}

