var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObj = sheetObjects[0];
	 /*******************************************************/
	 var formObj = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

	 		case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case "btn_save":
			
			/* 유저의 요청으로  20071012에 막음*/
				//doActionIBSheet(sheetObj,formObj,IBSAVE);
			
				break;

			case "btng_rowadd":
				doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;

		}

	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
				MergeSheet = msNone;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "STS|Seq|Logic No.|Basic Activity|Activity Name|Fomula|Hour|Dwell Time %|Effective\nDate From|Effective\nDate To" ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성	[ROW, COL,  DATATYPE,			WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  	  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,	daCenter,	false,	"ibflag",			false,		  "",	   dfNone,   		0,	 false,		true);
				InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,	false,	"r_skd_lgc_seq",	false,		  "",	   dfNone,   		0,	 false,		true);				
				InitDataProperty(0, cnt++ , dtData,	  		 80,	daCenter,	false,	"cop_skd_lgc_no",	true,		  "",	   dfEngUpKey, 		0,	 false,		true,			7);
				InitDataProperty(0, cnt++ , dtCombo,	  	 95,	daCenter,	false,	"act_cd",			true,		  "",	   dfNone,	 		0,	 true,		true);
				InitDataProperty(0, cnt++ , dtData,	  		200,	daLeft,		false,	"act_nm",			true,		  "",	   dfNone,   		0,	 false,		false);
				InitDataProperty(0, cnt++ , dtCombo, 		 100,	daCenter,	false,	"cop_foml_cd",	true,		  "",	   dfNone,   		0,	 true,		true);
				InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	false,	"foml_tm_hrs",	false,		  "",	   dfNullFloat,		2,	 true,		true);
				InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	false,	"foml_pct_no",	false,		  "",	   dfNullInteger,	0,	 true,		true);
				InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"fm_eff_dt",		true,		  "",	   dfDateYmd,  		0,	 false,		true);
				InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"to_eff_dt",		false,		  "",	   dfDateYmd, 		0,	 false,		true);
				
				InitDataValid(0,  2, vtEngOther, "1234567890-");
				InitDataValid(0,  2, vtEngOther, "1234567890-");

				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
				InitDataCombo (0, "act_cd" , " |" + actCDText, " |"+actCDCode);
				InitDataCombo (0, "cop_foml_cd", " |+|-", " |+|-");

				style.height = GetSheetHeight(15) ;
		   }
			break;
 
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {

	   case IBSEARCH:	  //조회
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = SEARCHLIST ;
			   	sheetObj.DoSearch4Post("ESD_SCE_0024GS.do", SceFrmQryString(formObj));
			}
			break;

		case IBINSERT:	  // 입력
			var row = sheetObj.DataInsert();
			sheetObj.CellValue2(row, "fm_eff_dt") = today ;

			break;

		case IBSAVE:
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = MULTI ;
				sheetObj.DoSave("ESD_SCE_0024GS.do", SceFrmQryString(formObj));
			}
			break;

	   case IBDOWNEXCEL:		//엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}


function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			var chgRows   = sheetObj.FindStatusRow("I|U").split(";") ;
			var dtNullCnt = 0 ;
			var preLgcNo  = "" ;
			for(i=0; i<chgRows.length-1; i++){
				if(ComIsEmpty(sheetObj.CellValue(chgRows[i], "foml_tm_hrs"))&&
				   ComIsEmpty(sheetObj.CellValue(chgRows[i], "foml_pct_no"))){
					ComShowMessage(ComGetMsg("COM12138","Hour", "Dwell Time")) ;
					sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
					return false ;
				}
				else if(!ComIsEmpty(sheetObj.CellValue(chgRows[i], "foml_tm_hrs"))&&
				   		!ComIsEmpty(sheetObj.CellValue(chgRows[i], "foml_pct_no"))){
				
					ComShowMessage(ComGetMsg("SCE90021", "Hour", "Dwell Time")) ;
					sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
					return false ;
				}
				else if(!chkNullT0EffDT(sheetObj,sheetObj.CellValue(chgRows[i], "cop_skd_lgc_no"))){
				
					ComShowMessage(ComGetMsg("SCE90022", sheetObj.CellValue(chgRows[i], "cop_skd_lgc_no"))) ;
					sheetObj.SelectCell(chgRows[i], "to_eff_dt") ;
					return false ;
				}
			}
			
			break;

		default:
			break;
	}

	return true;
}

function sheet1_OnChange(sheetObj, row, col){
	
	// Activity Name 세팅
	if(col==2){
		sheetObj.CellValue2(row, "act_nm") = actNames[sheetObj.CellValue(row, "act_cd")] ;
	}
	else if(col==3){
		sheetObj.CellValue2(row, "cop_skd_lgc_no") = sheetObj.CellValue(row, "cop_skd_lgc_no").toUpperCase() ;
	}

}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	if(errMsg==""){
		doActionIBSheet(sheetObj, document.form, IBSEARCH) ;
		ComShowMessage(ComGetMsg('SCE90005')) ;
	}	
}


function chkNullT0EffDT(sheetObj, skdLgcNo){
	var nullCnt = 0 ;
	for(j=1; j<=sheetObj.RowCount; j++){
		if(sheetObj.CellValue(j, "cop_skd_lgc_no")==skdLgcNo && 
		   ComIsEmpty(sheetObj.CellValue(j, "to_eff_dt"))){
			nullCnt ++ ;
			if(nullCnt>1){
				return false ;
			}
		}
	}

	return true ;
}

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt = sheetObj.CellValue(3, "totcnt");
    var formObj = document.form;	

	if(sheetObj.TotalRows > 0){
		sheetObj.TotalRows = totalCnt;
		for(var i=0; i<totalCnt; i++){
			if(sheetObj.CellValue(i, "to_eff_dt") == '' ){
				sheetObj.CellEditable(i, "to_eff_dt") = true;				
			}else{
				sheetObj.CellEditable(i, "to_eff_dt") = false;			
			}
		}		
	}
}

function changeLogicNo(){
	 var sheetObj = sheetObjects[0];
	 var formObj = document.form;	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);	
}