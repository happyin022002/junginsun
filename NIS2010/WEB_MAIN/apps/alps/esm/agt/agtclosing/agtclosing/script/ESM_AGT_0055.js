// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    //시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	    
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
/*	var formObj = document.form;
	//Date 날짜 세팅	
	form.search_dt_fr.value = ComGetDateAdd(null, "M", -1);
	form.search_dt_to.value = ComGetNowInfo();*/
	
    // Subj.Month 날짜 세팅
    var formObj = document.form;
    var temp = "0";
    var temp_array = "0";
    var temp_year = "0";
    var temp_mon = "0";
    
    temp = ComGetDateAdd(null, "M", -1);
    temp_array = temp.split("-");
    temp_year = temp_array[0];
    temp_mon = temp_array[1];
    formObj.search_dt_fr.value = temp_year.concat("-",temp_mon);
    
    
    formObj.search_dt_to.value = ComGetNowInfo("ym");
    
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(16);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 1000);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				var HeadTitle1 = "REV_YRMON|R.VVD|IOC|R.Lane|VVD Type|Estimated Total|Actual Total|Accral Total";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);


				//데이터속성  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
				//InitDataProperty(0, cnt++ , dtRadioCheck,	50,		daCenter,   true,    	"check",    false,		"",			dfNone,		0,			true,		false);
				//InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,   true,    	"seq",     	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,    	"rev_yrmon_cd",     false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		130,	daCenter,   true,    	"rev_vvd_cd",    false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,   true,    	"ioc_cd", false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,   true,    	"rev_lane_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,   true,    	"vvd_tp_cd",	false,	"",			dfNone,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,		150,		daRight,   true,    	"estm_ttl",	false,		"",			dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,		150,		daRight,   true,    	"act_ttl",	false,		"",			dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,		150,		daRight,    true,    	"accl_ttl",   false,		"",			dfFloat,	2,			false,		false);

				//전체선택시 이벤트 발생안함
                AllowEvent4CheckAll = false;
			}
			break;
	}
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObj = sheetObjects[0];
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
				loadPage();
				//formObj.search_dt.value = ComGetNowInfo();
				break;
				
			case "btn_creation":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_dt_fr":
				var cal = new ComCalendar();
				cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;
			case "btn_dt_to":
				var cal = new ComCalendar();
				cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;
			case "btn_0B2pop":
				openWindowVvd(formObj);	
				
			
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111", "", "");
		} else {
			ComShowMessage(e);
		}
	}
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0055GS.do", agtQryStr(formObj));
			

			break;
			
		case IBSEARCH_ASYNC01:	//Detail
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			row = sheetObj.SelectRow;
			
			var csr_no  = sheetObj.CellText(row,"csr_no");
			var comm_stnd_cost_cd  = sheetObj.CellText(row,"comm_stnd_cost_cd");
			var agn_cd  = sheetObj.CellText(row,"agn_ofc_cd");
			var rev_vvd_cd  = sheetObj.CellText(row,"rev_vvd_cd");

			var param = "s_csr_no=" + csr_no+"&comm_stnd_cost_cd=" + comm_stnd_cost_cd+"&agn_cd=" + agn_cd+"&rev_vvd_cd=" + rev_vvd_cd;
            
			ComOpenWindowCenter("ESM_AGT_0055.do?" + param, "compop1", "800", "460", false);
            break;
		
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;
			
		case "btn_0B2pop":
			window.close();
			break;		
	}
}


/**
 * A/R Office를 변경하면, 해당 Subject Office를 다시 조회한다.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0055FR.do";
    formObj.submit();
}

 /**
  * Subject Office를 변경하면, 그리드를 초기화한다.
  */
 function agn_cd_OnChange(obj){
     var sheetObj = sheetObjects[0];
     
     //Grid Reset
 	sheetObj.RemoveAll();
 }

/**
 * 컬럼을 더블클릭하면 Detail 이벤트를 발생시킨다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
		var formObj = document.form;
		
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);

}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/*
 * VVD 검색
 */

function openWindowVvd(formObj) {
	var formObj = document.form;
		var param = "";
	    param += "s_r_vvd="+ComGetObjValue(formObj.s_r_vvd);
	    /*param += "&lane_cd="+ComGetObjValue(formObj.slan_cd);*/
	    /*param += "&loc_cd="+ComGetObjValue(formObj.vps_port_pol);*/
  
		ComOpenPopup('/hanjin/COM_ENS_0B2.do?'+param , 780, 465, 'getCOM_ENS_0B2', '1,0,1,1,1,1,1,1', true);
	}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	formObj = document.form;
	var result = true ;
	
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		case IBSEARCH:	//Retrieve

			if( ComIsEmpty(formObj.search_dt_fr) ){
				ComShowCodeMessage("COM130403", "the Period.", "", "");
				result = false;
			}
			else if(ComIsEmpty(formObj.search_dt_to)){
				ComShowCodeMessage("COM130403", "the Period.", "", "");
				result = false;
			}
/*			
			if(!/[가-히]{2,3}/.test(formObj.s_r_vvd) ){
				alert("fucked up");
				//ComShowMessage(ComGetMsg("CIO_TEST","이름을 확인해주세요"));
    			formObj.s_r_vvd.focus();
    			return false;    			    
            }*/
			
/*			if( formObj.s_r_vvd != ""){			
				rvvd_validate();
			}*/
			
		}
	}
	return result;
}
		    	
/**
 * 화면 VAT 항목에 FOCUS가 왔을때 처리
 */
function rvvd_onfocus(obj){
	obj.select();
}

/**
 * 화면 VAT 항목에 FOCUS가 나갈때 유효성검증 프로세스 처리
 */
function rvvd_validate(obj){
	var formObj = document.form;
	
	if(formObj.s_r_vvd == ""){
		return true;
	}
	
	else{
		if(!/[A-z]{4}[0-9]{4}[A-z]{1,2}/.test(formObj.s_r_vvd.value) ){
			//alert("fucked up");
			//ComShowMessage(ComGetMsg("CIO_TEST","이름을 확인해주세요"));
			//formObj.s_r_vvd.focus();
			//formObj.s_r_vvd.select();
			//ComShowCodeMessage("AGT10017", "R.VVD", "", "");
			ComShowMessage(ComGetMsg("AGT10017","the value of R.VVD"));
			formObj.s_r_vvd.value = "";
			return false;
		}
    }

	
	
/*	if(!ComIsNumber(obj,'.')){
   		ComShowMessage(ComGetMsg("AGT10003", "", "", ""));
   		//obj.value = "0.00";
   		formObj.s_r_vvd.focus();
   		formObj.s_r_vvd.select();
   		return false;
	}*/

}	    	
		    	
		    	
		    	
/*		    	if(ar_ofc_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "A/R Office", "", "");
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "Subject Office", "", "");
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;*/
		    	
/*		    case IBSEARCH_ASYNC01:	//Detail
				//선택건수 체크(Header가 1줄이므로, SelectRow가 1보다 작으면 선택한 행이 없는것임)
				var sRow = sheetObj.SelectRow;
				if(sRow < 1){
					ComShowCodeMessage("COM12113", "row for detail information", "", "");
					return false;
				}	  
				break; */

/*	}

	return true;
}*/

	
/*function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		ShowSubSum("rev_yrmon_cd", "7|8|9", -1, false, false, 0, "rct_rhq_cd=%s;rct_ofc_cd=Sub Total");
		var sRow = FindSubSumRow();
		var arrRow = sRow.split("|");
		for (idx=0; idx < arrRow.length-1; idx++){ 
//				SetMergeCell (arrRow[idx], 2, 0, 3);
//				CellAlign(arrRow[idx], "rct_rhq_cd") = daRight;
//				CellAlign(arrRow[idx], "rct_ofc_cd") = daLeft;
			}
		SetMergeCell (LastRow, 1, 0, 4);
		SumText(0, "rev_yrmon_cd") = "Grand Total";
		SumBackColor = RgbColor(0,255,255);
	}
}*/




	
