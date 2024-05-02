
var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
var fmActNm = "";
var toActNm = "";


document.onclick = processButtonClick;

function processButtonClick(){

	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObj = sheetObjects[0];
	 /*******************************************************/
	 var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btn_save":
			// 유저의 요청으로  20080221 에 막음
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;

			case "btng_rowadd":

				doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;

		} // end switch
	}catch(e) {

		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111') ;
		} else {
			ComShowMessage(e);
		}
	}
}

function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	fun_getExptTP();

}

function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = 1;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "Del.|STS|SEQ|Exception Type|Exception Type Detail|From-Activity|From-Activity|To-Activity|To-Activity|Location|Node|Day/Hour/Minute|Day/Hour/Minute|Day/Hour/Minute|User ID|Updated Date|Active";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);


				//데이터속성		[ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,		  KEYFIELD, CALCULOGIC, DATAFORMAT, 	POINTCOUNT,    UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,  false,	"r_ibflag",			false,		  "",	   dfNone,   		0,			true,	   true);
        InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,  false,   "sDelCheck",        false,        "",      dfNone,   	    0,          true,      true);				
				InitDataProperty(0, cnt++ , dtSeq,			 30,	daCenter,  false,	"r_seq",			false,		  "",	   dfNone,   		0,			true,	   true);
				InitDataProperty(0, cnt++ , dtCombo,		  170,	daCenter,  false,	"r_expt_tp",		false,		  "",	   dfNone,   		0,			false,	   true);
				InitDataProperty(0, cnt++ , dtCombo,		  180,	daCenter,  false,	"r_expt_tp_dtl",    false,		  "",	   dfNone,   		0,			false,	   true);
				InitDataProperty(0, cnt++ , dtCombo,	  	 80,	daCenter,  false,	"r_fm_act",         false,		  "",	   dfNone,   		0,			false,     true);
				InitDataProperty(0, cnt++ , dtHidden,	  	  0,	daCenter,  false,	"r_fm_act_nm",      false,		  "",	   dfNone,   		0,			false,     false);
				InitDataProperty(0, cnt++ , dtCombo,		 80,	daCenter,  false,	"r_to_act",         false,		  "",	   dfNone,   		0,			false,     true);
				InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,  false,	"r_to_act_nm",      false,		  "",	   dfNone,   		0,			false,     false);
				InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,  false,	"r_loc_cd",			false,		  "",	   dfEngUpKey, 		0,			false,	   true,		5);
				InitDataProperty(0, cnt++ , dtPopupEdit,    100,    daCenter,  false,   "r_nod_cd",         false,        "",      dfEngUpKey,   	0,          false,     true,        7);
				InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,  false,	"r_foml_tm_dys",	false,		  "",	   dfUserFormat2,  	0,			true,	   true);
				InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,  false,	"r_foml_tm_hrs",	false,		  "",	   dfUserFormat2,  	0,			true,	   true);
				InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,  false,	"r_foml_tm_min",	false,		  "",	   dfUserFormat2,  	0,			true,	   true);
				InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,  false,	"r_usr_id",	        false,        "",      dfNone,       	0,			false,      false,		20);
				InitDataProperty(0, cnt++ , dtData,			120,	daCenter,  false,	"r_upd_dt",		    false,        "",      dfNone,       	0,			false,      false,		20);
				InitDataProperty(0, cnt++ , dtCombo,		 70,	daCenter,  false,	"r_act_flg",		false,		  "",	   dfNone,   		0,			true,	    false);

        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd1_nm",         false,        "",      dfNone,     	0,          false,     false);
        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd2_nm",         false,        "",      dfNone,     	0,          false,     false);

				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT] 			//sheetObj.CellValue2(sheetObj.SelectRow, "r_loc_cd") = "ALL";

				InitDataCombo (0, "r_expt_tp" , r_expt_tpText , r_expt_tpCode);
				InitDataCombo (0, "r_expt_tp_dtl" , r_expt_tp_dtlText , r_expt_tp_dtlCode);
				InitDataCombo (0, "r_fm_act" , r_fm_actText , r_fm_actCode);
				InitDataCombo (0, "r_to_act" , r_to_actText , r_to_actCode);
				InitDataCombo (0, "r_act_flg"    , "Y|N", "Y|N");
				InitUserFormat2(0, "r_foml_tm_dys", "##D", "D" );
				InitUserFormat2(0, "r_foml_tm_hrs", "##H", "H" );
				InitUserFormat2(0, "r_foml_tm_min", "##M", "M" );

				style.height = GetSheetHeight(16) ;
			}
			break;
		}
	}

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:	  //조회
	   	
			sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , r_expt_tp_dtlText , r_expt_tp_dtlCode);
			sheetObj.InitDataCombo (0, "r_fm_act" , r_fm_actText , r_fm_actCode);
			sheetObj.InitDataCombo (0, "r_to_act" , r_to_actText , r_to_actCode);
			
			formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0029GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("r_"));
			
			break;

	   case IBINSERT:	  // 입력
			sheetObj.DataInsert();
			sheetObj.CellValue2(sheetObj.SelectRow, "r_expt_tp") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_expt_tp_dtl") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_fm_act") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_to_act") = "";
			//sheetObj.CellValue2(sheetObj.SelectRow, "r_loc_cd") = "";
			//sheetObj.CellValue2(sheetObj.SelectRow, "r_nod_cd") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_foml_tm_dys") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_foml_tm_hrs") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_foml_tm_min") = "";
			sheetObj.CellValue2(sheetObj.SelectRow, "r_usr_id") = formObj.usr_id.value;

			break;

		case IBSAVE:		//저장
			//alert("fm == " + sheetObj.CellValue(sheetObj.SelectRow, "r_fm_act"));
			//alert("to == " + sheetObj.CellValue(sheetObj.SelectRow, "r_to_act"));
//			var valueTF = false;
			if(validateForm(sheetObj, formObj, sAction)){
				valueTF = true;
				formObj.f_cmd.value = MULTI ;
				sheetObj.DoSave("ESD_SCE_0029GS.do", SceFrmQryString(formObj));
			}
			
//			if (valueTF == true) {
//				formObj.f_cmd.value = SEARCHLIST ;
//				alert("before retreieve 1");
//				sheetObj.DoSearch4Post("ESD_SCE_0029GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("r_"));
//				alert("after retreieve 1");
//				ComShowMessage("Updated properly.");
//			}				
//			
			break;

	   case IBDOWNEXCEL:		//엑셀 다운로드
//			sheetObj.Down2Excel(-1, false, false, true);
		    sheetObj.SpeedDown2Excel();
			break;

	   case COMMAND02:

		}
		var rowCnt = sheetObj.RowCount('');
			for (var row = 1; row < rowCnt; row++) {
				if(sheetObj.CellValue(row, "r_act_flg") == 'N') {
					sheetObj.CellEditable(row,"r_foml_tm_dys") = false;
					sheetObj.CellEditable(row,"r_foml_tm_hrs") = false;
					sheetObj.CellEditable(row,"r_foml_tm_min") = false;
				}
			}
		}

function sheet1_OnPopupClick(sheetObj, row, col){

	if(sheetObj.ColSaveName(col)=="r_loc_cd"){
	
		openLocPopSheet(sheetObj, row, false, "r_loc_cd");
	
		if(sheetObj.CellValue(row, col)==""){
		    //sheetObj.CellValue2(row, col)="";
		    //openLocPopSheet(sheetObj, row, false, "r_loc_cd", "");
		    //sheetObj.CellValue2(row, "r_loc_cd")="ALL";
		}
		sheetObj.CellValue2(row, "r_nod_cd")="";
		sheetObj.CellEditable(row, "r_nod_cd")  = false ;		
	}
	else if(sheetObj.ColSaveName(col)=="r_nod_cd" ){
		openNodePopSheet(sheetObj, row, false, "r_nod_cd") ;
		
		sheetObj.CellValue2(row, "r_loc_cd")="";
		sheetObj.CellEditable(row, "r_loc_cd")  = false ;

	}

}

function getcomText(sheetObj, row, col){

  var sText = sheetObj.GetComboInfo(row,col, "Text");
  var sCode = sheetObj.GetComboInfo(row,col, "Code");
  
  //각각 배열로 구성한다.
  var arrText = sText.split("|");
  var arrCode = sCode.split("|");

  var idx   = sheetObj.GetComboInfo(row,col, "SelectedIndex");

  return arrText[idx];
}

function comboChange(){

}

function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){

	var colName = sheetObj.ColSaveName(sheetObj.MouseCol);
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	var formObj = document.form;
	
	if(colName == 'r_expt_tp_dtl' && ( sheetObj.MouseRow > 0 )){

		var chkVal =  sheetObj.CellValue(row, col-1);
		
		var nCode = r_expt_tp_dtlCode.split("|");
		var nText = r_expt_tp_dtlText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,1) == chkVal.substring(0,1)) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , tmpText , tmpCode);
			
	}else 	if(colName == 'r_fm_act' && ( sheetObj.MouseRow > 0 )){

		var chkdtlcd = sheetObj.CellValue(row, col-1);

		var nCode = r_fm_actCode.split("|");
		var nText = r_fm_actText.split("|");
		var tmpCode="";
	    var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3) == chkdtlcd.substring(0,3) ) {
	
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_fm_act" , tmpText , tmpCode);		
		
	}else 	if(colName == 'r_to_act' && ( sheetObj.MouseRow > 0 )){

		var chkdtlcd = sheetObj.CellValue(row, col-2); 
	
		var nCode = r_to_actCode.split("|");
		var nText = r_to_actText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3)+nCode[i].substring(4,6)== chkdtlcd.substring(0,3)+chkdtlcd.substring(4,6) ) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_to_act" , tmpText , tmpCode);
		
	}
	
}

function sheet1_OnChange(sheetObj, row, col){
    var vcntCd;
	
	if( sheetObj.ColSaveName(col)=="r_expt_tp_dtl") {
	
		var chkVal =  sheetObj.CellValue(row, col-1);
		
		var nCode = r_expt_tp_dtlCode.split("|");
		var nText = r_expt_tp_dtlText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,1) == chkVal.substring(0,1)) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , tmpText , tmpCode);
		
	}
   
	if( sheetObj.ColSaveName(col)=="r_fm_act") {
	
		var chkdtlcd = sheetObj.CellValue(row, col-1);
		var nCode = r_fm_actCode.split("|");
		var nText = r_fm_actText.split("|");
		var tmpCode="";
	  var tmpText="";
	  
		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3) == chkdtlcd.substring(0,3) ) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_fm_act" , tmpText , tmpCode);
		
		for( var j =0; j < nCode.length ; j++) {
			if(nCode[j] == sheetObj.CellValue(row, col)) {
				sheetObj.CellValue2(row, col+1) = nText[j];
			}
		}
	}


	if( sheetObj.ColSaveName(col)=="r_to_act") {
		var chkdtlcd = sheetObj.CellValue(row, col-2); 
		var nCode = r_to_actCode.split("|");
		var nText = r_to_actText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3)+nCode[i].substring(4,6)== chkdtlcd.substring(0,3)+chkdtlcd.substring(4,6) ) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_to_act" , tmpText , tmpCode);
		
		for( var j =0; j < nCode.length ; j++) {
			if(nCode[j] == sheetObj.CellValue(row, col)) {
				sheetObj.CellValue2(row, col+1) = nText[j];
			}
		}
	}
	
    if(sheetObj.ColSaveName(col)=="r_loc_cd"){

	        sheetObj.CellValue2(row, "r_loc_cd") = sheetObj.CellValue(row, "r_loc_cd").toUpperCase() ;
        
	        if( sheetObj.CellValue(row, "r_loc_cd") ==  "" ){
	        	sheetObj.CellEditable(row, "r_nod_cd")  = true ;
	        }else{
	        	sheetObj.CellValue2(row, "r_nod_cd") = "";
	        	sheetObj.CellEditable(row, "r_nod_cd")  = false ;
	        
	        }

	}
	else if(sheetObj.ColSaveName(col)=="r_nod_cd"){
	        sheetObj.CellValue2(row, "r_nod_cd") = sheetObj.CellValue(row, "r_nod_cd").toUpperCase() ;

	        if( sheetObj.CellValue(row, "r_nod_cd") ==  "" ){
	        	sheetObj.CellEditable(row, "r_loc_cd")  = true ;
	        }else{
		        sheetObj.CellValue2(row, "r_loc_cd") = "";
		        sheetObj.CellEditable(row, "r_loc_cd")  = false ;	        
	        }	        

	}
	else if(sheetObj.ColSaveName(col)=="r_foml_tm_hrs"){

	}
	else if(sheetObj.ColSaveName(col)=="r_foml_tm_min"){
	    if(sheetObj.CellValue(row, "r_foml_tm_min")>59){
            ComShowCodeMessage('SCE90041');
            sheetObj.SelectCell(row, "r_foml_tm_min") ;
	    }

	}
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){

    //화면 선택 Value
		//alert(sheetObj.CellValue(Row,Col));
    if(sheetObj.ColSaveName(Col)=="r_fm_act" || sheetObj.ColSaveName(Col)=="r_to_act"){
        
    	var nCode = (sheetObj.ColSaveName(Col)=="r_fm_act")?r_fm_actCode.split("|"):r_to_actCode.split("|");
    	var nText = (sheetObj.ColSaveName(Col)=="r_fm_act")?r_fm_actText.split("|"):r_to_actText.split("|");
    	var tmpCode="";
    	var tmpText="";
    
    	for( var i =0; i < nCode.length ; i++) {
    	    if(nCode[i]==sheetObj.CellValue(Row,Col)){
    	        sheetObj.CellValue2(Row,Col+1) = nText[i];		
    	        //alert("화면 선택 : "+sheetObj.CellValue(Row,Col+1));
    	    }
    	}
    }
    
    
}

function sheet1_OnSaveEnd(sheetObj,errMsg){
	var formObj = document.form;
	if(errMsg==""){
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
		ComShowCodeMessage('SCE90005') ;
	}
}

function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			var chgRows = sheetObj.FindStatusRow("U|I").split(";") ;
			var all_rowcnt = sheetObj.RowCount;
			var dayhourMin    = null ;
			var pct     = null ;
			var loc     = null ;
			var nod     = null ;
			var act     = null ;

			for(i=0; i<chgRows.length-1; i++){
				dayhourMin = sheetObj.CellValue(chgRows[i], "r_foml_tm_dys")||sheetObj.CellValue(chgRows[i], "r_foml_tm_hrs")||sheetObj.CellValue(chgRows[i], "r_foml_tm_min") ;
				loc  = sheetObj.CellValue(chgRows[i], "r_loc_cd") ;
				nod  = sheetObj.CellValue(chgRows[i], "r_nod_cd") ;
				act  = sheetObj.CellValue(chgRows[i], "r_act_flg") ;

				if((ComIsEmpty(loc) && ComIsEmpty(nod)) || (!ComIsEmpty(loc) && !ComIsEmpty(nod))) {
					ComShowCodeMessage('SCE90034','Location', 'Node') ;
					sheetObj.SelectCell(chgRows[i], "r_loc_cd") ;
					return false ;
				}
				else if(ComIsEmpty(loc) && nod.length<7){
				    ComShowCodeMessage('SCE90039');
				    sheetObj.SelectCell(chgRows[i], "r_nod_cd") ;
				    return false ;
				}
				else if(ComIsEmpty(nod) && loc.length<5 && loc!="ALL"){
				    ComShowCodeMessage('SCE90040');
				    sheetObj.SelectCell(chgRows[i], "r_loc_cd") ;
				    return false ;
				}
				if(ComIsEmpty(act)){
				    ComShowCodeMessage('SCE90044');
					sheetObj.SelectCell(chgRows[i], "r_act_flg") ;
					return false ;
				}
				if(ComIsEmpty(sheetObj.CellValue(chgRows[i], 'r_expt_tp'))){
				    ComShowMessage('Please enter Exception Type') ;
					sheetObj.SelectCell(chgRows[i], "r_expt_tp") ;
					return false ;
				} else if(ComIsEmpty(sheetObj.CellValue(chgRows[i], 'r_expt_tp_dtl'))){
				    ComShowMessage('Please enter Exception Type Detail') ;
					sheetObj.SelectCell(chgRows[i], "r_expt_tp_dtl") ;
					return false ;
				} else if(ComIsEmpty(sheetObj.CellValue(chgRows[i], 'r_fm_act'))){
				    ComShowMessage('Please enter From-Activity') ;
					sheetObj.SelectCell(chgRows[i], "r_fm_act") ;
					return false ;
				}								
			}

		for( var cnti = 0; cnti < chgRows.length-1; cnti++ ){
	    	for( var i = 1; i <= all_rowcnt; i++ ){

	    	    if( chgRows[cnti] != i ){
				    if(sheetObj.CellValue(i, 'r_fm_act') == sheetObj.CellValue(chgRows[cnti], 'r_fm_act') ){

				      if(sheetObj.CellValue(i, 'r_to_act') == sheetObj.CellValue(chgRows[cnti], 'r_to_act') ){
				      
					      if(sheetObj.CellValue(i, 'r_loc_cd') == sheetObj.CellValue(chgRows[cnti], 'r_loc_cd') ){
						
						      if(sheetObj.CellValue(i, 'r_nod_cd') == sheetObj.CellValue(chgRows[cnti], 'r_nod_cd') ){
							     ComShowMessage('Duplicate Exception Type/Exception Type Detail/From-Activity/To-Activity/Location/Node');
							     sheetObj.SelectCell(chgRows[cnti], 'r_loc_cd');
							     return false;
						      }
					      }
				      }
				    }
	    	    }

			    var cost_cd = sheetObj.CellValue(chgRows[cnti], 'r_expt_tp');
			    if(cost_cd.substring(0,1) == '1' ){
				    if(sheetObj.CellValue(chgRows[cnti], 'r_to_act') == "" ){
				     ComShowMessage('Input To-Activity Code!');
				     sheetObj.SelectCell(i, 'r_to_act');
				     return false;
				    }
			    }
	    	}
		}
		
			break;

		default:
			break;
	}

	return true;
}


/**
 *  Location 공통 팝업 오픈
 *
 * @param multi check 여부
 * @param cntCd Loc Code
 * @param locDesc Loc Name
 * @param contiCd Conti
 * @param ScontiCd Sub Conti
 * @param cntCd Country
 * @param locState State
 * @param locEqOfc Control Office
 * @param locPortInd Port Only
 * @param sysCode System
 */
function openCntPop(multi, cntCd, sysCode){
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "cnt_cd",       cntCd) ;
	param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;
	//alert("param == " + param);
	multiChkYN    = multi
	contiCdFld    = cntCd ;
	sysCodeFld    = sysCode ;
	ComOpenPopup('ESD_SCE_0106.do' + param, 800, 415, 'setValFromContPop', display, true) ;
	
}



/**
 * Contry 공통 팝업에서 호출하는 함수
 *
 * @param rowArray 결과값
 */
function setValFromContPop(rowArray){
	var colArray = null ;
	var gubun    = '';

	if(multiChkYN){
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromLocArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0][1] ;
	}

		document.form.cnt_cd.value=colArray;
 }



//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}


// 초기 화면 생성 시 Exception Type을 가져다가 뿌린다...
function fun_getExptTP() {

		var url = "ESD_SCE_0029GS.do?f_cmd="+SEARCH12;
		createHttpRequestToLocal();
		request.open("GET", url, true);
		
		request.onreadystatechange = subExptTp;
		
		request.send(null);

}

var request = null;
function createHttpRequestToLocal() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}

	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}


// Exception Type의 값을 가지고 온다.
function subExptTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
			
			text_effS = "<select style=\"width:150;\" name=\"h_expt_tp\" onChange=\"fun_getExptDTLTP();\">";
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");
				var valLen = val.length;
				var val2 = val.substring(0, valLen-8);
				var valStr = val.substring(valLen-8, valLen-7);
				
				if( n == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
					}
			}
			
			text_effE = "</SELECT>";
			
			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}
			
			document.form.all.ExptTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}


// Exception Type Select시 Detail Type을 가져다가 뿌린다...
function fun_getExptDTLTP() {

		var expt_type = document.form.h_expt_tp.value;
		
		var url = "ESD_SCE_0029GS.do?f_cmd="+SEARCH13+"&expt_type="+expt_type;
		createHttpRequestToLocal();
		request.open("GET", url, true);

		request.onreadystatechange = subExptDTLTp;
		
		request.send(null);

}


// Detail Type의 값을 가지고 온다.
function subExptDTLTp() {
	
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
				
			text_effS = "<select style=\"width:150;\" name=\"h_expt_tp_dtl\" >";

			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");		
				var valLen = val.length;
				var val2 = val.substring(0, valLen-8);
				var valStr = val.substring(valLen-8, valLen-5);
				
				if( n == 0){
					text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
					text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
				}else{
					text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
				}
			}
			
			text_effE = "</SELECT>";
			
			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}
			
			document.form.all.ExptDTLTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}

function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
{
     if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act") || sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act")){
//alert("alert(OnMouseMove);");

              //마우스 모양 설정하기
//            sheetObj.MousePointer = "Default";  //기본 화살표 모양
              sheetObj.MousePointer = "Hand";     //손가락 모양
              var sText="";
              if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd1_nm");
              else if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd2_nm");
           	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
              //풍선도움말 만들기
          	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
     }

}

