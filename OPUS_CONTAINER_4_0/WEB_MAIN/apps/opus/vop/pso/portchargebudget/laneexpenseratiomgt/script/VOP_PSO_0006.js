/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0006.js
*@FileTitle  : Lane/Port Expense Ratio Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class VOP_PSO_0006 : business script for VOP_PSO_0006
 */
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var iTempSeq = 999;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */

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
    	 		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    	 		break;
    	 	case "btn_new":
    	 		sheetObject2.RemoveAll();
    	 		break;
    	 	case "btn_save":
    	 		doActionIBSheet(sheetObject1,formObject,IBSAVE);
    	 		break;
    	 	case "btn_add":
    	 		var rowIdx=sheetObject1.RowCount()+ sheetObject1.HeaderRows();
    	 		if( rowIdx > sheetObject2.HeaderRows()) {
    	 			if(sheetObject1.GetCellValue(sheetObject1.rowIdx, "sheet1_vsl_slan_cd") == "" ){
    	 				ComShowCodeMessage('PSO00001','');
    	 				return;
    	 			}
    	 		}
    	 		doActionIBSheet(sheetObject1,formObject,IBINSERT);
    	 		createSeq(sheetObject1, "sheet1_seq");
    	 		break;
    	 	case "btn_del":
    	 		ComRowHideDelete(sheetObject1, "sheet1_del_chk");
    	 		sheetObjects[1].RemoveAll();
    	 		createSeq(sheetObject1, "sheet1_seq");
    	 		break;
    	 	case "btn_add2":
    	 		/*var max=1;
    	 		for( var i=sheetObject2.HeaderRows(); i < sheetObject2.RowCount()+1 ; i++ ) {
    	 			if( max <= eval(sheetObject2.GetCellValue( i , "sheet2_seq" )) && sheetObject2.GetCellValue( i , "sheet2_ibflag" ) != "D" )
    	 				max=eval(sheetObject2.GetCellValue( i , "sheet2_seq" ))+1;
    	 		}*/
    	 		sheetObject2.DataInsert(-1);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_slan_cd" ,sheetObject2.GetCellValue(sheetObject2.HeaderRows(), "sheet2_slan_cd" ),0);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_port_seq" , iTempSeq,0);
    	 		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "sheet2_seq", iTempSeq,0);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_rlane_cd","",0);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_rlane_dir_cd","",0);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_skd_dir_cd","",0);
    	 		sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_loc_cd","",0);
    	 		createSeq(sheetObject2, "sheet2_seq");
    	 		break;
    	 	case "btn_insert2":
    	 		var selectRow=eval(sheetObject2.GetSelectRow());
    	 		//modifySeq(sheetObject2 , selectRow );
    	 		/*var max=1;
    	 		for( var i=sheetObject2.HeaderRows(); i < sheetObject2.RowCount()+1 ; i++ ) {
    	 			if( max <= eval(sheetObject2.GetCellValue( i , "sheet2_seq" )) && sheetObject2.GetCellValue( i , "sheet2_ibflag" ) != "D" )
    	 				max=eval(sheetObject2.GetCellValue( i , "sheet2_seq" ))+1;
    	 		}*/
    	 		sheetObject2.DataInsert();
    	 		sheetObject2.SetCellValue(selectRow+1, "sheet2_port_seq", iTempSeq,0);
    	 		sheetObject2.SetCellValue(selectRow+1, "sheet2_slan_cd", sheetObject2.GetCellValue(selectRow,"sheet2_slan_cd"),0);
    	 		sheetObject2.SetCellValue(selectRow+1, "sheet2_slan_cd", sheetObject2.GetCellValue(sheetObject2.HeaderRows(), "sheet2_slan_cd" ),0);
    	 		sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "sheet2_seq", iTempSeq,0);
    	 		createSeq(sheetObject2, "sheet2_seq");
    	 		break; 
    	 	case "btn_del2":
    	 		var sRowStr=sheetObject2.FindCheckedRow(1);
    	 		var delCnt=ComRowHideDelete(sheetObject2, "sheet2_del_chk");
    	 		if(delCnt == 0) return;
    	 		createSeq(sheetObject2, "sheet2_seq");
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }    
    resizeSheet();    
    sheet1_OnLoadFinish(sheetObjects[0])
}

function sheet1_OnLoadFinish(sheetObj){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
             
/**
 * registering initial event 
 */
function initControl(sheetObj){

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
		    	var HeadTitle1="||Seq.|Lane CD|Standard\nP/F SKD|Pendulum\nSVC Check|skd_dir_cd";
		    	var headCount=ComCountHeadTitle(HeadTitle1);
		    	var prefix="sheet1_";
		    	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		    	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	InitHeaders(headers, info);
		    	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pndlm_flg" },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd" } ];
		    	InitColumns(cols);
		    	SetEditable(1);
              	//SetSheetHeight(530);
		    	//resizeSheet(sheetObj);
		    	SetColProperty(0, prefix+"vsl_slan_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	      	}
			break;
		
		case "sheet2":
		    with(sheetObj){
		      	var HeadTitle1="||Seq.|SEQ|Rev. Lane|Direction|Rev. \nDirection|Calling Port|I/B Ratio|O/B Ratio||||||";
		      	var headCount=ComCountHeadTitle(HeadTitle1);
		      	var prefix="sheet2_";
		      	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      	InitHeaders(headers, info);
		      	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_seq",       KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_rto",         KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_rto",         KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_seq_b",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd_b",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_dir_cd_b", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd_b",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd_b",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      	InitColumns(cols);
		      	SetEditable(1);
		      	//SetSelectionMode(smSelectionList);
		      	SetColProperty(0, prefix+"rlane_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		      	SetColProperty(0, prefix+"rlane_dir_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		      	SetColProperty(0, prefix+"skd_dir_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		      	SetColProperty(0, prefix+"loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		      	FitColWidth("5|5|20|10|10|30|10|10");
		      	//SetSheetHeight(530);
		      	//resizeSheet(sheetObj);
		     	}
		    break;
    	}
}

// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction,etc) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array( "sheet1_", "sheet2_" );
	switch(sAction) {
		case IBSEARCH:      //Retrieving
			sheetObjects[0].SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("VOP_PSO_0006GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
			break;
		case IBSAVE:        //Save
	  		//2015.03.19 선택된 Row의 Lane CD 를 파람으로 저장한다.
	  		var selVslSlanCd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_vsl_slan_cd");
	  		
            if( !validateForm(sheetObj,formObj,sAction)) return;
			var sParam=ComGetSaveString(sheetObjects);
			if (sParam == "") return;
	        sheetObjects[0].SetWaitImageVisible(0);
	        ComOpenWait(true);
	  		formObj.f_cmd.value=MULTI;
	        sParam += "&vsl_slan_cd="+selVslSlanCd;
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			
			var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0006GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			//sheetObjects[1].RemoveAll(); 
			//저장전에 선택된 LaneCD 정보.
			var selVslSlanCd=ComGetEtcData(sXml, "vsl_slan_cd");
			ComOpenWait(false);
			
	   		if( selVslSlanCd == "" ) {
	   			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	   		} else {
	   			var iSelRow = sheetObjects[0].FindText("sheet1_vsl_slan_cd",selVslSlanCd);
	   			var iSelCol = sheetObjects[0].SaveNameCol("sheet1_vsl_slan_cd");
	   			sheet1_OnDblClick(sheetObjects[0],iSelRow, iSelCol); // 3 index
	   		}
			
			
			break;
		case IBINSERT:
            sheetObj.DataInsert(-1);
			sheetObjects[1].RemoveAll();
			break;
    	case IBINSERT2:
    		sheetObj.DataInsert(-1);
    		break;
    	case IBINSERT3:
    		sheetObject2.DataInsert();
    		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSAVE:
				//jmh
				for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++){
					if(sheetObjects[1].GetRowStatus(i) == "D") continue;
					if(sheetObjects[1].GetCellValue(i, "sheet2_rlane_cd") == ""){
						ComShowCodeMessage('COM130403', " [Rev.Lane]");
						return;
					}
					
					if(sheetObjects[1].GetCellValue(i, "sheet2_rlane_dir_cd") == ""){
						ComShowCodeMessage('COM130403', " [Rev. Direction]");
						return;
					}
					
					if(sheetObjects[1].GetCellValue(i, "sheet2_skd_dir_cd") == ""){
						ComShowCodeMessage('COM130403', " [Direction]");
						return;
					}
					
					if(sheetObjects[1].GetCellValue(i, "sheet2_loc_cd") == ""){
						ComShowCodeMessage('COM130403', " [Calling Port]");
						return;
					}
					
					if( sheetObjects[1].GetCellValue( i , "sheet2_rlane_cd_b") == "" && sheetObjects[1].GetCellValue( i , "sheet2_ibflag") != "D"){
						sheetObjects[1].SetRowStatus(i,"I");
					}
					
				}
				var prefix1="sheet1_";
				var dupRow1=sheetObjects[0].ColValueDup(prefix1 + "vsl_slan_cd", false);
				if(dupRow1 != -1){
					ComShowCodeMessage('PSO00002', dupRow1 + " Row");
					sheetObjects[0].SetSelectRow(dupRow1);
					return false;
				}
				
				var dupRows2=sheetObjects[1].ColValueDup("sheet2_rlane_cd|sheet2_rlane_dir_cd|sheet2_skd_dir_cd|sheet2_loc_cd", false);
                if( dupRows2 != -1){
                	ComShowCodeMessage('PSO00002', dupRows2 + " Row");
                	sheetObjects[1].SetSelectRow(dupRows2);
                    return false;
                }
				
				//[2015.07.02]NYK Add Check Rev.Lane, Rev.Direction, Direction 
				for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++){
					if(sheetObjects[1].GetRowStatus(i) == "D") continue;
					//상단에서 null Check 하므로 정합성 체크만 하면 됨.
					var checkYn = checkRevenueLaneAndDirection(sheetObjects[1], i);
					var seq = sheetObjects[1].GetCellValue(i, "sheet2_seq");
					if(checkYn == "N"){
						//There is no Rev. lane and Direction in Register Lane & Revenue port (STM Setup)
						ComShowCodeMessage('PSO01010', " [Seq:"+seq+"]");
						sheetObjects[1].SetSelectRow(i);
						return false;
					}
					
					//[2015.09.15]NYK Modify seq > port_seq 로 Set 한다.
					sheetObjects[1].SetCellValue(i, "sheet2_port_seq", seq, 0);
				}
       		break;
	 	}      
	}
	return true;
}
/**
 * IBSheet OnAfterEdit Event
 */
function sheet1_OnDblClick(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObjects[1].RemoveAll();
	if(sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col)) == ""){
		return;
	}
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "vsl_slan_cd" :   
	        sheetObjects[1].SetWaitImageVisible(0);
	        ComOpenWait(true);
			formObj.f_cmd.value=SEARCHLIST;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
			param=param + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, Col);
			sheetObjects[1].ReDraw=false;
			sheetObjects[1].DoSearch("VOP_PSO_0006GS.do",param );
			sheetObjects[1].ReDraw=true;
			ComOpenWait(false);
			break;
		
		case prefix + "pf_svc_tp_cd" :   
			if( sheetObj.GetCellValue(Row, 4) == '') return;
	        sheetObjects[1].SetWaitImageVisible(0);
	        ComOpenWait(true);
			formObj.f_cmd.value=SEARCHLIST;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
			param=param + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, Col-1);
			sheetObjects[1].DoSearch("VOP_PSO_0006GS.do",param );
				ComOpenWait(false);
			break;
	}
}	
 /**
  * IBSheet OnAfterEdit Event
  */
 function sheet1_OnChange(sheetObj,Row,Col,val) {
	 var formObj=document.form;
	 var prefix="sheet1_";
	 
	 switch (sheetObj.ColSaveName(Col)) {
    	 case prefix + "vsl_slan_cd" :   
    		 var dupRow=sheetObj.ColValueDup(Col, false);
    		 if( dupRow != -1 ){
    			 ComShowCodeMessage('COM12115', dupRow + " Row");
    			 sheetObj.SetCellValue(dupRow,Col,"",0);
    			 sheetObjects[0].SetSelectRow(dupRow);
    			 return;    	  		
    		 }	
    		 formObj.f_cmd.value=SEARCHLIST01;
    		 var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
    		 param=param + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, Col).toUpperCase();
    		 var sXml=sheetObj.GetSearchData("VOP_PSO_0006GS.do", param );
    		 var items=ComGetEtcData(sXml, "PfSvcTpCd");
    		 sheetObj.SetCellValue(sheetObj.GetSelectRow(),Col+1,items,0); 
    		 //sheetObj.SetCellValue(sheetObj.GetSelectRow(),Col+1,items);
    		 if( items == "" ) {
    			 ComShowCodeMessage('COM132201', 'Lane Code');
    			 sheetObj.SetCellValue(Row,Col,"",0);
    		 } else {
    			 sheet1_OnDblClick(sheetObj,Row,Col);
    		 }		
    		 break;
	 }
 }
 
 function sheet2_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
	 if(Value == OldValue) return;
	 
	 var formObj = document.form;
	 var tmpPrefix="sheet2_";
	 switch (sheetObj.ColSaveName(Col)) {
	 	case tmpPrefix+"rlane_cd" :
	 		var slanCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"slan_cd");
   		 	var rlaneCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_cd");
   		 	var skdDirCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"skd_dir_cd");
	 		
    		var param = "f_cmd=" + COMMAND01;
	 	    param += "&vsl_slan_cd="+rlaneCd;//rlane_cd 값을 넣는다.
		 	param += "&slan_cd="+slanCd;
		 	param += "&rlane_cd="+rlaneCd;
		 	param += "&skd_dir_cd="+skdDirCd;    
		 	var sXml=sheetObj.GetSearchData("VOP_PSO_0006GS.do", param);
    		 
	 		var isLane=ComGetEtcData(sXml, "isLane");
	 		var rlaneDirCd=ComGetEtcData(sXml, "rlaneDirCd");
			if(isLane != "Y"){
				ComShowCodeMessage('PSO00014', '[Rev.Lane]');
				sheetObj.SetCellValue(Row, tmpPrefix+"rlane_cd","",0);
				//sheetObj.SelectCell(Row, tmpPrefix+"rlane_cd");
				return;
			}else{
				sheetObj.SetCellValue(Row, tmpPrefix+"rlane_dir_cd",rlaneDirCd,0);
				//sheetObj.SelectCell( Row , tmpPrefix+"rlane_dir_cd" , true);
			}
	 		break;
	 	case tmpPrefix+"skd_dir_cd" :
	 		var slanCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"slan_cd");
   		 	var rlaneCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_cd");
   		 	var skdDirCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"skd_dir_cd");
	 		
    		var param = "f_cmd=" + SEARCH02;
	 	    param += "&vsl_slan_cd="+rlaneCd;//rlane_cd 값을 넣는다.
		 	param += "&slan_cd="+slanCd;
		 	param += "&rlane_cd="+rlaneCd;
		 	param += "&skd_dir_cd="+skdDirCd;    
		 	var sXml=sheetObj.GetSearchData("VOP_PSO_0006GS.do", param);
    		 
	 		var rlaneDirCd=ComGetEtcData(sXml, "rlaneDirCd");
	 		sheetObj.SetCellValue(Row, tmpPrefix+"rlane_dir_cd",rlaneDirCd,0);
	 		break;
	 	case tmpPrefix+"rlane_dir_cd" :
	 		/*var slanCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"slan_cd");
	 		var rlaneCd 	= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_cd");
	 		var rlaneDirCd 	= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_dir_cd");
	 		var skdDirCd 	= sheetObj.GetCellValue(Row, tmpPrefix+"skd_dir_cd");
	 		
	 		checkRevenueLaneAndDirection(sheetObj, Row);
	 		*/
	 		break;
	 	case tmpPrefix+"loc_cd" :
	 		if( checkYard( Row, Col , Value) ) {
	 			sheetObj.SelectCell( Row , Col+1 , true);
			} else {
				ComShowCodeMessage("PSO00001");	//Invalid Data
				sheetObj.SetCellValue(Row, tmpPrefix+"loc_cd","",0);
				sheetObj.SelectCell( Row , tmpPrefix+"loc_cd", true);
			}	 		
	 		break;
	 }
 }
 
 function checkRevenueLaneAndDirection(sheetObj, Row){
	 var formObj = document.form;
	 var tmpPrefix="sheet2_";
	 var checkYn = "N";
	 var slanCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"slan_cd");
	 var rlaneCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_cd");
	 var rlaneDirCd 	= sheetObj.GetCellValue(Row, tmpPrefix+"rlane_dir_cd");
	 var skdDirCd 		= sheetObj.GetCellValue(Row, tmpPrefix+"skd_dir_cd");
	 
	 if(!ComIsEmpty(slanCd) && !ComIsEmpty(rlaneCd) && !ComIsEmpty(rlaneDirCd) && !ComIsEmpty(skdDirCd)){
		 //formObj.f_cmd.value=SEARCH01;
		 var param = "f_cmd=" + SEARCH01;
		 	 param += "&slan_cd="+slanCd;
		 	 param += "&rlane_cd="+rlaneCd;
		 	 param += "&rlane_dir_cd="+rlaneDirCd;
		 	 param += "&skd_dir_cd="+skdDirCd;    
		 var sXml=sheetObj.GetSearchData("VOP_PSO_0006GS.do", param);
		 checkYn=ComGetEtcData(sXml, "checkYn");
	 }
	 
	 return checkYn;
	 
 }
 
 /**
  * Creating seq when modifying
  */
/* function modifySeq(sheetObj,Row) {
	var prefix="sheet2_";  
 	for(var i=Row+1 ; i <= sheetObj.LastRow() ; i++ ){
 		if(sheetObj.GetCellValue(i, "sheet2_port_seq") == '1'){
 			break;
 		}
 		var tmpPortSeq = eval(sheetObj.GetCellValue(i,"sheet2_port_seq"))+1;
 		sheetObj.SetCellValue(i,"sheet2_port_seq",tmpPortSeq,0);
 	}	
}*/
/**
 *  Creating seq when Deleting
 */
function createSeq(sheetObj, colName){
	 var xxx="";
	 var prefix="sheet2_";
	 var k=0;
	 for(var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount(); i++){
		 if(sheetObj.GetRowStatus(i) != "D"){
			 k++;
			 sheetObj.SetCellValue(i, colName,k,0);
		 }
	 }
	 sheetObj.RenderSheet(1);
}
/**
 * IBSheet OnSearchEnd Event
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	createSeq(sheetObjects[0], "sheet1_seq");
	ComOpenWait(false);
	sheet1_OnDblClick(sheetObjects[0], 1 , 3 );
}
 /**
  * IBSheet OnSearchEnd Event
  */
 function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
 	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
		sheetObj.SetCellValue( i , "sheet2_seq" ,i,0);
		if( sheetObj.GetCellValue(i, "sheet2_ib_rto") == 100 ){
 			sheetObj.SetCellEditable(i, "sheet2_ob_rto",0);
 		}	
		if( sheetObj.GetCellValue(i, "sheet2_ob_rto") == 100 ){
 			sheetObj.SetCellEditable(i, "sheet2_ib_rto",0);
		}
 	}
}
/**
 * IBSheet OnAfterEdit Event
 */
function sheet2_OnAfterEdit(sheetObj,Row,Col) {
	var prefix="sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
    	case prefix + "ib_rto" :  
    		var ratio = Number(sheetObj.GetCellValue(Row,Col));
    		if( ratio == 100 ){
    			sheetObj.SetCellValue(Row, "sheet2_ob_rto",0,0);
       			sheetObj.SetCellEditable(Row, "sheet2_ob_rto",0);
     		} else if( ratio != 0 && ratio != 50 ){
       			 ComShowCodeMessage("PSO00026", "0,50,100");
       			 sheetObj.SetCellValue(Row, Col,"0",0);
       			 sheetObj.SelectCell( Row , Col , true);
       			 sheetObj.SetCellEditable(Row, "sheet2_ob_rto",1);
       		}else{ 
       		    sheetObj.SetCellEditable(Row, "sheet2_ob_rto",1);
       		}     
        	break;
     	case prefix + "ob_rto" :
     		var ratio = Number(sheetObj.GetCellValue(Row,Col));
     		if( ratio == 100 ){
       		     sheetObj.SetCellValue(Row, "sheet2_ib_rto",0,0);
       		     sheetObj.SetCellEditable(Row, "sheet2_ib_rto",0);
     		} else if( ratio != 0 && ratio != 50 ){
       			 ComShowCodeMessage("PSO00026", "0,50,100");
       			 sheetObj.SetCellValue(Row, Col,"0",0);
       			 sheetObj.SelectCell( Row , Col , true);
       			 sheetObj.SetCellEditable(Row, "sheet2_ib_rto",1);
       		} else {      
       		     sheetObj.SetCellEditable(Row, "sheet2_ib_rto",1);
       		}     
     		break;
    }
}

function sheet2_OnEditValidation(sheetObj,Row, Col, Value) { 
	var prefix="sheet2_";
    
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "ib_rto" :
			if( Value != 0 && Value != 50 && Value != 100){
				 ComShowCodeMessage("PSO00026", "0,50,100");
				 sheetObj.ValidateFail(2);
			}
			break;
		case prefix + "ob_rto" : 
			if( Value != 0 && Value != 50 && Value != 100){
				 ComShowCodeMessage("PSO00026", "0,50,100");
				 sheetObj.ValidateFail(2);
			}
			break;
	}
}
/*
function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){ 
	var prefix=sheetObj.id + "_";
	var formObj=document.form;
	if(Col == 3){
		var tempVal=sheetObj.GetEditText();
		if(tempVal.length == 3){
			sheetObj.SelectCell( Row , Col+1 , true);
		}
	}
}	
function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
	var prefix=sheetObj.id + "_";
	var formObj=document.form;
	if(Col == 5){
		var tempVal=sheetObj.GetEditText();
		if(tempVal.length == 1){
			sheetObj.SelectCell( Row , Col+1 , true);
		}
	} else if(Col == 6){
		var tempVal=sheetObj.GetEditText();
		if(tempVal.length == 1){
			sheetObj.SelectCell( Row , Col+1 , true);
		}
	} else if(Col == 8){ //"sheet2_ib_rto"
		var tempVal=sheetObj.GetEditText();
		if( parseInt(tempVal) < 0 ||  parseInt(tempVal) > 100 ){
			ComShowCodeMessage("PSO00001");	//Invalid Data
			sheetObj.SetCellValue(Row, Col,"0",0);
			sheetObj.SelectCell( Row , Col , true);
		}
		if(tempVal.length == 3 && tempVal == 100 ){
			sheetObj.SelectCell( Row , Col+1 , true);
		}
	} else if(Col == 9){//"sheet2_ob_rto"
		var tempVal=sheetObj.GetEditText();
		if( parseInt(tempVal) < 0 ||  parseInt(tempVal) > 100 ){
			ComShowCodeMessage("PSO00001");	//Invalid Data
			sheetObj.SetCellValue(Row, Col,"0",0);
			sheetObj.SelectCell( Row , Col , true);
		}
	}
}*/				
/**
 * IBSheet OnAfterEdit Event
 */
function checkYard( Row,Col , yardValue) {
	var sheetObj=sheetObjects[0];
 	var formObj=document.form;
	var prefix="sheet1_";
  	formObj.f_cmd.value=SEARCHLIST;
    
  	var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
        param=param + "&yd_cd1=" + yardValue; 
    
    var sXml=sheetObj.GetSearchData("VOP_PSO_0001GS.do", param );
	
    var comboItems=ComGetEtcData(sXml, "lane");
	
    if( comboItems == "" ) return false;
	return true;	
}	
 
function checkVvd( Row,Col,yardValue ) {
	var sheetObj=sheetObjects[0];
 	var formObj=document.form;
	var prefix="sheet1_";
  	formObj.f_cmd.value=SEARCHLIST;
    
  	var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
    param=param + "&yd_cd1=" + yardValue; 
    
    var sXml=sheetObj.GetSearchData("VOP_PSO_0001GS.do", param );
	var comboItems=ComGetEtcData(sXml, "lane");
	
	if( comboItems == "" ) return false;
	return true;	
}	

function resizeSheet(){
	for (var i=0; i<sheetObjects.length; i++){
		ComResizeSheet(sheetObjects[i]);
	}
}