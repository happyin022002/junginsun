/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_SCE_0050.js
*@FileTitle : Rail Transit Report Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-05-02 Poong-yeon Cho
* 1.0 최초생성
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM 상선
 */

/**
 * @extends 
 * @class esd_sce_0050 : esd_sce_0050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esd_sce_0050() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.initComboSetVal		= initComboSetVal;
	this.checkKeyInSlanCd	    = checkKeyInSlanCd;
	this.callDatePop			= callDatePop;
	this.setCallBack0B2         = setCallBack0B2;
}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject = sheetObjects[0];
     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
			case "btn_retrieve":			
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
			
			case "btn_new":
				formObject.reset();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			break;
			
			case "dbtn_excel":			
				doActionIBSheet(sheetObjects[0],document.form, IBDOWNEXCEL);
			break;
			
			case "dbtn_detailInquiry":			
				if(sheetObjects[0].RowCount<1){
					ComShowCodeMessage("COM12176");
					return false;
				}
				openRTRDetail();
			break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj){
   	comboObjects[comboCnt++] = combo_obj;
 }

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
   for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
   }	    
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
                 // 높이 설정
				style.height=GetSheetHeight(12);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1,12, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

                var HeadTitle1 = "|Sel.|Month|Week|F/M|Bound|Origin|Dest|Volumn\n(box)|Terminal\nDwell|Origin\nDwell|Run Time|Run Time|Run Time|"
                	            + "Dest\nDwell I|Transit Time\n(Measuring)|Dest\nDwell II|Total\nTransit Time||||";
                var HeadTitle2 = "|Sel.|Month|Week|F/M|Bound|Origin|Dest|Volumn\n(box)|Terminal\nDwell|Origin\nDwell|TTL Run\nTime|Interchange\nDwell I|Interchange\nDwell II|"
                                + "Dest\nDwell I|Transit Time\n(Measuring)|Dest\nDwell II|Total\nTransit Time||||";

                var headCount = ComCountHeadTitle(HeadTitle2);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 8, 0, true);
                 
 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 				InitHeadRow(0, HeadTitle1, true);
 				InitHeadRow(1, HeadTitle2, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                     
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,  true, "ibflag",					false,	"",	   dfNone,   	0,	true,	   true);
                 InitDataProperty(0, cnt++ , dtCheckBox,   		50,	daCenter,  true, "chk",						false,	"",	   dfNone,   	0,	true ,	   true);
                 InitDataProperty(0, cnt++ , dtData,	   		60,	daCenter,  true, "mnth",					false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		60,	daCenter,  true, "week",					false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		60,	daCenter,  true, "cgo_tp_cd",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		60,	daCenter,  true, "trsp_bnd_cd",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		70,	daCenter,  true, "fm_nod_cd",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		70,	daCenter,  true, "to_nod_cd",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		70,	daCenter,  true, "box_cnt",					false,	"",	dfInteger,	    0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		70,	daCenter,  true, "tml_dwll_tm_hrs",			false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		70,	daCenter,  true, "org_dwll_tm_hrs",			false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		80,	daCenter,  true, "rail_run_tm_hrs",			false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		90,	daCenter,  true, "itchg_n1st_dwll_tm_hrs",	false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		90,	daCenter,  true, "itchg_n2nd_dwll_tm_hrs",	false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		90,	daCenter,  true, "dest_n1st_dwll_tm_hrs",	false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		90,	daCenter,  true, "rail_tztm_hrs",			false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   		90,	daCenter,  true, "dest_n2nd_dwll_tm_hrs",	false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtData,	   	   100,	daCenter,  true, "ttl_tztm_hrs",			false,	"",	 dfNumber,	 	0,	 false,	   false);                //Container
                 InitDataProperty(0, cnt++ , dtHidden,	   		0,	daCenter,  true, "sls_fm_dt",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtHidden,	   		0,	daCenter,  true, "sls_to_dt",				false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtHidden,	   		0,	daCenter,  true, "rank_cd",					false,	"",	   dfNone,	 	0,	 false,	   false);                //Container               
                 InitDataProperty(0, cnt++ , dtCheckBox, 		50,	daCenter,  true, "rank_chk",				false,	"",	   dfNone,   	0,	true ,	   true);
                 ColHidden('rank_chk') = true;
         }
             break;
             
 		case 2:      //sheet2 init
			with (sheetObj) {
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle1 = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				InitDataProperty(0, cnt++,  dtHidden		,  	 0	,   daCenter,  false,   "base" );  //25

    		}
    		break;
    		
 		case 3:      //sheet3 init
			with (sheetObj) {
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle1 = "";
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				InitDataProperty(0, cnt++,  dtStatus	,  	 100	,   daCenter,  false,   "ibflag" );		
				InitDataProperty(0, cnt++,  dtData		,  	 100	,   daCenter,  false,   "c_fm_nod_cd" );
				InitDataProperty(0, cnt++,  dtData		,  	 100	,   daCenter,  false,   "c_to_nod_cd" );
				InitDataProperty(0, cnt++,  dtData		,  	 100	,   daCenter,  false,   "c_cgo_tp_cd" );
				InitDataProperty(0, cnt++,  dtData		,  	 100	,   daCenter,  false,   "c_trsp_bnd_cd" );
			}
			break;
     }
}

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				bindRoute();
				var route_condition = sheetObjects[2].GetSaveString(true, false);
				formObj.f_cmd.value = SEARCH10;
				sheetObj.DoSearch("ESD_SCE_0045GS.do", route_condition + '&'+ SceFrmQryString(formObj));
			}
			break;
			
		case IBDOWNEXCEL:      //조회
		if(sheetObj.RowCount>0){
			sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, "chk");
		}
		break;
			
     }
 }

/**
 * Onchange Event 처리
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colName = sheetObj.ColSaveName(Col);
	
	switch(colName) {
    	case "chk":
    		if(Value == '1' && sheetObj.CellValue(Row,"mnth") == 'Total') {
    			
    			sheetObj.CellValue2(Row,'rank_chk') = !sheetObj.CellValue(Row,'rank_chk');

    			var rank_no =  sheetObj.CellValue(Row,"rank_cd");
    			// fm_nod_cd, to_nod_cd가 동일한 group(rank_cd 동일)이  함께 toggle 된다.
    			for(var k=sheetObj.HeaderRows; k <= sheetObj.RowCount+sheetObj.HeaderRows; k++){
    				if(sheetObj.CellValue(k,"mnth") != 'Total' && sheetObj.CellValue(k,"rank_cd") == rank_no) {
    					sheetObj.CellValue2(k,"chk") = sheetObj.CellValue(Row,'rank_chk');
    	    		}
    			}
    			// Total row는 check 되지 않는다.
    			sheetObj.CellValue2(Row,"chk") = 0;
    		}
    	break;
	}
}
   
/**
 * Onchange Event 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	 var formObj = document.form;
	 if(formObj.f_cmd.value == SEARCH10) {
		 // 조회후 Total row에 대한 배경색을 변경한다
		for(var row=sheetObj.HeaderRows; row <= sheetObj.RowCount+sheetObj.HeaderRows; row++){
			if(sheetObj.CellValue(row,"mnth") == 'Total') {
				sheetObj.RowBackColor(row) = sheetObj.RgbColor(192,192,192);
    		}
		}
	}
}

   
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction, srcName){

    var formObject = document.form;	
 	
    if(formObject.date_kind.options[0].selected){
    	ComShowMessage(ComGetMsg("COM12113", "Date Kind"));
    	formObject.date_kind.focus();
    	return false;
    }
    
 	if (formObj.f_chkprd[1].checked ){
 		if( formObj.f_fm_mon.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Month"))
 			formObj.f_fm_mon.focus();
 			return false;
 		}else if(formObj.f_to_mon.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Month"))
 			formObj.f_to_mon.focus();
 			return false;
 		}
 	}
 	
 	if ( formObj.f_chkprd[0].checked ){
 		if( formObj.f_fm_wk.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Week"))
 			formObj.f_fm_wk.focus();
 			return false;
 		}else if(formObj.f_to_wk.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Week"))
 			formObj.f_to_wk.focus();
 			return false;
 			
 		}
 	}
 	
 	var check_fm_date 	= formObject.fm_date.value ;
 	var check_to_date 	= formObject.to_date.value ;
 	
 	if(check_fm_date == "" || check_to_date == "" || dateCalcuration(check_fm_date, check_to_date) > 365){
 		ComShowMessage(ComGetMsg("SCE02004"));
 		return false;
 	}
 	
 	var r_cnt = 0;
    for(var i=1; 6>i; i++){
    	var val_p_rout_check =  eval('formObj.p_rout_'+i);
    	var val_fm_nod_cd  = eval('formObj.fm_nod_cd'+i);
    	var val_to_nod_cd  = eval('formObj.to_nod_cd'+i);
    	var val_cgo_tp_cd  = eval('formObj.cgo_tp_cd'+i);
    	var val_trsp_bnd_cd  = eval('formObj.trsp_bnd_cd'+i);
    	var rowNum = 0;
    	
    	if(val_p_rout_check.checked){
    		if(val_fm_nod_cd.value.length != 0 && val_fm_nod_cd.value.length != 5 && val_fm_nod_cd.value.length != 7){
     			ComShowMessage(ComGetMsg("SCE02003"))
     			val_fm_nod_cd.focus();
     			return false;	
     		}
    		
    		if(val_to_nod_cd.value.length != 0 && val_to_nod_cd.value.length != 5 && val_to_nod_cd.value.length != 7){
     			ComShowMessage(ComGetMsg("SCE02003"))
     			val_to_nod_cd.focus();
     			return false;	
     		}
    		r_cnt++;
    	}
    }
 	
    if(r_cnt == 0){
    	ComShowMessage(ComGetMsg("SCE02005"));
    	formObj.p_rout_1.checked = true;
    	checkRoute(formObj.p_rout_1);
    	formObj.fm_nod_cd1.focus();
    	return false;
    }
 		
 	return true;
 }   
   
   
 /**
 * Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
 */
 function chkWM(param1, param2){ 	
	if(param1 == 'W'){
 		    document.all.div_week.style.display = "inline";
 			document.all.div_month.style.display = "none";
 			setPeriod(document.form.f_to_wk);
 	} else {
 		    document.all.div_week.style.display = "none";
 			document.all.div_month.style.display = "inline";
 			setPeriod(document.form.f_to_mon);
 	}
 }

 /**
 * month, week가 변경되었을때 Period를 변경한다.
 */
 function setPeriod(obj){
 	var formObj = document.form;
 	if(obj == null){
       return;
   }
   if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
       if(obj.name == "f_to_mon" ){
           formObj.f_fm_mon.value = "";
       } else if (obj.name == "f_to_wk"){
           formObj.f_fm_wk.value = "";
       }
       return false;
   } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
       if(obj.name == "f_fm_mon") return false;
       if(obj.name == "f_fm_wk") return false;
   }
   if(chkValidSearch()){
       var sheetObj = sheetObjects[1];
 	  	sheetObj.RemoveEtcData();
 	  	formObj.fm_date.value = "";
 		formObj.to_date.value = "";
 		document.getElementById("div_period").innerHTML = ".....";
 		formObj.f_cmd.value = SEARCH02;
 		sheetObj.DoSearch4Post("ESD_TRS_0999GS.do", SceFrmQryString(formObj));
 		var fm_date = sheetObj.EtcData('FM_DATE');
 		var to_date = sheetObj.EtcData('TO_DATE');
 		if( fm_date != null && to_date != null){
 			formObj.fm_date.value=doSepRemove(doSepRemove(fm_date, " "), "-");
 			formObj.to_date.value=doSepRemove(doSepRemove(to_date, " "), "-");
 			document.getElementById("div_period").innerHTML = "( "+fm_date + " ~ "+ to_date +" )";
 			ComBtnEnable("btn_retrieve");
 		}
   }
 }
 
 /*
 * 입력 키 체크
 */
 function keyCheck(obj){
 	if(event.keyCode == '9'){
 		check_format(obj);
 	}else{
 		ComKeyOnlyNumberChk(obj);
 	}
 }
 
 /*
 * 제대로된  month, week 입력시 검색 기간 조회로 넘김
 */
 function checkLength(obj){
 	var formObj = document.form;
 	var inputValue = obj.value;
 	var year = null;
 	var month = null;
 	var week = null;
 	if( inputValue.length == 6 ){
 		if(formObj.f_chkprd[0].checked){
 			 year  = inputValue.substring(0,4);
              week = inputValue.substring(4,6);
              if ((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54)){
             	 setPeriod(obj);
              }
              
 		}
 		if(formObj.f_chkprd[1].checked){
 			 year  = inputValue.substring(0,4);
 			 month = inputValue.substring(4,6);
             if ((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13)){
             	setPeriod(obj);
             }
 		}
 	}
 }
 
 /*
 * Month(YYYYMM), Week(YYYYWW) Format check
 */
 function check_format(obj){
 	var formObj = document.form;
 	if(formObj.f_chkprd[0].checked){
 		if( !ComIsDate(obj,'yw')){
 			ComShowMessage(ComGetMsg("COM12114", "Week Format(YYYYWW)"));
 			obj.focus();
 			return;
 		}
 	}else if(formObj.f_chkprd[1].checked){
 		if( !ComIsDate(obj,'ym')){
 			ComShowMessage(ComGetMsg("COM12114", "Month Format(YYYYMM)"));
 			obj.focus();
 			return;
 		}
 	}
 }
 
 /**
 * 검색시 필수입력사항 체크
 */
 function chkValidSearch(){
 	var formObj = document.form;

 	with(formObj){
 		if (f_chkprd[1].checked && f_fm_mon.value != "" && f_to_mon.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Month"))
 			f_to_mon.focus();
 			return false;
 		}
 		if (f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value != "") {
 			ComShowMessage(ComGetMsg("COM12114", "Month"));
 			f_fm_mon.focus();
 			return false;
 		}
 		if (f_chkprd[1].checked && f_fm_mon.value > f_to_mon.value) {
 			ComShowMessage(ComGetMsg("SCE02002","Month of From should be equal to or less than To."));
 			f_to_mon.focus();
 			return false;
 		}	
 		if (f_fm_wk.value != "" && f_to_wk.value == ""){
 			ComShowMessage(ComGetMsg("COM12114", "Week"));
 			f_to_wk.focus();
 			return false;
 		}
 		if (f_fm_wk.value == "" && f_to_wk.value != ""){
 			ComShowMessage(ComGetMsg("COM12114", "Week"));
 			f_fm_wk.focus();
 			return false;
 		}
 		if (f_fm_wk.value > f_to_wk.value) {
 			ComShowMessage(ComGetMsg("SCE02002","Week of From should be equal to or less than To."));
 			f_to_wk.focus();
 			return false;
 		}
 		if(f_fm_mon.value == "" && f_fm_wk.value == ""){
 			return false;
 		}
 		if(f_chkprd[1].checked){
 			 var inputValue = f_fm_mon.value;
 			 var year  = inputValue.substring(0,4);
 			 var month = inputValue.substring(4,6);
          if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13))){
        	  return false;
          }
 		}
 		if(f_chkprd[1].checked){
 			 var inputValue = f_to_mon.value;
 			 var year  = inputValue.substring(0,4);
 			 var month = inputValue.substring(4,6);
         if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13))){
        	 return false;
         }
 		}
 		if(f_chkprd[0].checked){
 			var inputValue = f_fm_wk.value;
 			var year  = inputValue.substring(0,4);
           var week = inputValue.substring(4,6);
           if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54))){
        	   return false;
           }
 		}
 		if(f_chkprd[0].checked){
 			var inputValue = f_to_wk.value;
 			var year  = inputValue.substring(0,4);
           var week = inputValue.substring(4,6);
           if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54))){
        	   return false;
           }
 		}
 	}
 	return true;
 }
 
 /**
 * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다.
 * 예를 들어 다음과 같이 사용한다.
 * 인자로 사용되는 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.
 */
 function ComKeyOnlyNumberChk(obj,sSubChar)
 {
    try {
        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

        if(keyValue >= 48 && keyValue <= 57) {//숫자
            event.returnValue = true;

        } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
        	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
        	for(var i=0; i<sSubChar.length; i++) {
         		if (keyValue == sSubChar.charCodeAt(i)) {
 	                event.returnValue = true;
 	                return;
        		}
        	}
            event.returnValue = false;
        } else {
            event.returnValue = false;
        }
        ComBtnDisable("btn_retrieve");
    } catch(err) { ComFuncErrMsg(err.message); }
}
 
/**
* cargo Type에 따른 bound 변경
*/
 function chgBound(obj){
	var formObj = document.form;
	var RouteNo = obj.name.substring(obj.name.length-1,obj.name.length);
	if (obj.value =="M" || obj.value== ""){
		eval('formObj.trsp_bnd_cd'+RouteNo).value="";
	}else if (obj.value ="F"){
		eval('formObj.trsp_bnd_cd'+RouteNo).value="I";
	}
}

/**
* Route check 여부에 따른 검색조건 활성/비활성화
*/
function checkRoute(obj){
	var RouteNo = obj.name.substring(obj.name.length-1,obj.name.length);
	var formObj = document.form;
	var val_fm_nod_cd    = eval('formObj.fm_nod_cd'+RouteNo);
	var val_to_nod_cd    = eval('formObj.to_nod_cd'+RouteNo);
	var val_cgo_tp_cd    = eval('formObj.cgo_tp_cd'+RouteNo);
	var val_trsp_bnd_cd  = eval('formObj.trsp_bnd_cd'+RouteNo);
	
	var val_check = !obj.checked;
	
	if(val_check){
		val_fm_nod_cd.value = '';
		val_to_nod_cd.value = '';
		val_cgo_tp_cd.options[1].selected = true;;
		val_trsp_bnd_cd.options[1].selected = true;
	}
	
	val_fm_nod_cd.disabled = val_check;
	val_to_nod_cd.disabled = val_check;
	val_cgo_tp_cd.disabled = val_check;
	val_trsp_bnd_cd.disabled = val_check;
}

/**
* Route check 여부에 따른 검색조건 활성/비활성화
*/
function openNode(obj){
	var RouteNo = obj.substring(obj.length-1,obj.length);
	var val_check = eval('document.form.p_rout_'+RouteNo).checked;
	
	if(val_check){
		openNodePop(false,obj)
	}
}

/**
* Route 조회조건을 Sheet에 입력한다.
*/
function bindRoute(){
	
    var sheetObj = sheetObjects[2];
    var formObj = document.form;

    sheetObj.RemoveAll();
    
    for(var i=1; 6>i; i++){
    	var val_p_rout_check =  eval('formObj.p_rout_'+i);
    	var val_fm_nod_cd  = eval('formObj.fm_nod_cd'+i);
    	var val_to_nod_cd  = eval('formObj.to_nod_cd'+i);
    	var val_cgo_tp_cd  = eval('formObj.cgo_tp_cd'+i);
    	var val_trsp_bnd_cd  = eval('formObj.trsp_bnd_cd'+i);
    	var rowNum = 0;
    	
    	if(val_p_rout_check.checked){
    		rowNum = sheetObj.DataInsert(-1);
    		sheetObj.CellValue2(rowNum,'c_fm_nod_cd') = val_fm_nod_cd.value;
    		sheetObj.CellValue2(rowNum,'c_to_nod_cd') = val_to_nod_cd.value;
    		sheetObj.CellValue2(rowNum,'c_cgo_tp_cd') = val_cgo_tp_cd.value;
    		sheetObj.CellValue2(rowNum,'c_trsp_bnd_cd') = val_trsp_bnd_cd.value;
    	}
    }
}

/**
* RTR Detail 화면을 open 한다.
*/
function openRTRDetail(){
	//var newWin = window.showModalDialog("ESD_SCE_0045.do?openMode=smmy", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1024px;dialogHeight:550px");
	//var newWin = window.open("ESD_SCE_0045.do?openMode=smmy", 'rtrdetail', "scroll=no, status=YES, help=no ,width=1024,height=550");
	var formObj = document.form;
	var scNo = "";
	scNo = formObj.sc_no.value;
	var newWin = window.open("ESD_SCE_0045.do?openMode=smmy&parentScNo="+scNo, 'rtrdetail', "scroll=no, status=YES, help=no ,width=1024,height=550");
}
