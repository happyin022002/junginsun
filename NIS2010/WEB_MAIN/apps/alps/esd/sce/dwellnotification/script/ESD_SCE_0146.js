/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0146.js
*@FileTitle : Microsoft Exception Management
*Open Issues :
*@LastModifyDate : 2016-02-01
*@LastModifier : Poong Yeon CHO, Min Jung KIM
*@LastVersion : 1.0
* 2015-09-23 Poong Yeon CHO, Min Jung KIM
* 1.0 최초 생성
=========================================================*/


/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends 
 * @class ESD_SCE_0146 : ESD_SCE_0146 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_SCE_0146() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.sheet1_OnChange        = sheet1_OnChange;
}
    
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var sheetObjects = new Array();
var sheetCnt = 0;
var isSearch = false;
var selRow = 0;
var isFirst1 = 0;
var isFirst2 = 0; 
var grp_cust;
var firstSel = -1;

// 공통전역변수
var pageNo =1 ;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄 처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}	

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트 핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 *****/
    var sheetObject = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

        	case "btn_retrieve":
        		doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
			break;

			case "btn_loadexcel":
				sheetObject.RemoveAll();
    	    	doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
			break;
			
			case "btn_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
			
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
			case "btn_send":
				if(sheetObject.CheckedRows("chk")>0){
	        	    doActionIBSheet(sheetObject, formObject, IBINSERT);
	            }else{
	                alert("There is no data to send.");
	            }
			break;

        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			//showErrMessage("지금은 사용하실 수가 없습니다");
		} else {
			//showErrMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){
    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1); 
    //khlee-마지막 환경 설정 함수 추가
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
     
    	case 1:      //IBSheet1 init
        	 
    		with (sheetObj) {
				//전체 너비 설정
    			style.height = 320;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 30);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(22, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle0 = "Seq.||flg|Container No.|Type Size|Booking No.|POL|POD|DEL|VVD|Estimated|Estimated|Estimated|Actual|Actual|Actual|Diff|Sent Flag|Event DT|Event DT|Dwell Reason|Comment" ;
				var HeadTitle1 = "Seq.||flg|Container No.|Type Size|Booking No.|POL|POD|DEL|VVD|ID|OC|Transit Time|ID|OC|Transit Time|Diff|Sent Flag|Event DT|Event DT|Dwell Reason|Comment" ;

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,    SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "chk", false, "", dfNone, 0, true, true);//check box
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 106, daCenter, true, "cntr_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 106, daCenter, true, "bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "estm_id", false, "", dfUserFormat2, 0, false, false, 12, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "estm_oc", false, "", dfUserFormat2, 0, false, false, 12, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "estm_tt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "act_id", false, "", dfUserFormat2, 0, false, false, 12, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "act_oc", false, "", dfUserFormat2, 0, false, false, 12, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "act_tt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "diff", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "snt_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "act_dt1", false, "", dfDateYmd, 0, true, true, 30);
                InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "act_dt2", false, "", dfTimeHms, 0, true, true, 30);
				InitDataProperty(0, cnt++, dtCombo, 230, daLeft, true, "ms_dwll_rsn_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "ms_dwll_rmk", false, "", dfNone, 0, true, true);
		        
				InitUserFormat2(0, "estm_id", "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "estm_oc", "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "act_id", "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "act_oc", "####-##-## ##:##", "-|:" );
				
				InitDataCombo(0, 'ms_dwll_rsn_cd', ms_dwll_rsn_cdText, ms_dwll_rsn_cdCode);

             }
             break;
     } 
 }

	
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
    	case IBSEARCH:      // 조회
    		if(formObj.vvd_.value == "" && formObj.bl_no_.value == "" && formObj.cntr_no_.value == "") {
    			ComShowCodeMessage("SCE90064"); // "Please enter one of followings : VVD, B/L No. and Container No."
    			formObj.pod_cd_.focus();
    			break;
    		}else{
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch4Post("ESD_SCE_0146GS.do", SceFrmQryString(formObj));
    			initCkCount();
    			absCkColor(sheetObj);
    		}
    		break;
				
    	case IBSAVE:		// 저장
    		
    		var empty_count = 0;
			for(var i = 1 ; i <= sheetObj.RowCount ; i++){
				var rsn_cd = sheetObj.CellValue(i, "ms_dwll_rsn_cd");
				var flg = sheetObj.CellValue(i, "ibflag");
				if(flg == "U" && ComIsEmpty(rsn_cd)){
					ComShowMessage("Dwell Reason Code is mandatory column/value for updating data.");
					empty_count += 1;
				    break;
				}
		    }
			
			if(empty_count > 0){
				sheetObj.SelectCell(1, "ms_dwll_rsn_cd", false);
				break;
			}
			
    		formObj.f_cmd.value = MULTI01;
       		initCkCount();
       		sheetObj.DoSave("ESD_SCE_0146GS.do", SceFrmQryString(formObj), "chk");
       		absCkColor(sheetObj);
       		sheetObj.CheckAll("chk") = 0;
    		break;
    		
    	case IBDOWNEXCEL:		// excel down
    		sheetObj.SpeedDown2Excel(-1); //, false, false, '', '', false, false, '', false, "chk"
    		break;
  			
    	case IBLOADEXCEL:		// excel load
    		sheetObj.LoadExcel();
    		for(var i = 1 ; i <= sheetObj.RowCount+1 ; i++){
    			sheetObj.CellBackColor(i,"diff") = sheetObj.RgbColor(255, 229, 204);
    		}
    		absCkColor(sheetObj);
    		break;

    	case IBINSERT:        	// SD EDI Send
    		
    		var empty_count = 0;
			for(var i = 1 ; i <= sheetObj.RowCount ; i++){
				var rsn_cd = sheetObj.CellValue(i, "ms_dwll_rsn_cd");
				var flg = sheetObj.CellValue(i, "ibflag");
				if(flg == "U" && ComIsEmpty(rsn_cd)){
					ComShowMessage("Dwell Reason Code is mandatory column/value for updating data.");
					empty_count += 1;
				    break;
				}
		    }
			
			if(empty_count > 0){
				sheetObj.SelectCell(1, "ms_dwll_rsn_cd", false);
				break;
			}
			
    		formObj.f_cmd.value = MULTI02;
       		initCkCount();
       		sheetObj.DoSave("ESD_SCE_0146GS.do", SceFrmQryString(formObj), "chk");
       		absCkColor(sheetObj);
       		sheetObj.CheckAll("chk") = 0;
    		break;                

    }
}
   
	
/**
 * General Tab IBSheet Object Change Event
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObject = document.form;
	var rowPostion = 1;
	if (sheetObj.ColSaveName(Col) == "chk" && sheetObj.RowCount >= 0){
		document.form.ckCount.value = sheetObj.CheckedRows("chk");
		if(sheetObj.CellValue(Row,"chk") == "1"){
			if(rowPostion < Row){
				formObject.tab1_position.value = Row;
			}
		}
	}
}
	
//Initiating Check Box for Flag
function initCkCount(){
	document.form.ckCount.value = 0;
}

// diff의 절대값 확인
function absCkColor(sheetObj){
	var sheetObject = sheetObj;
	for(var i = 1 ; i <= sheetObject.RowCount+1 ; i++){
		sheetObject.CellBackColor(i,"diff") = sheetObject.RgbColor(255, 229, 204);
		if(sheetObject.CellValue(i+1,"act_tt") > sheetObject.CellValue(i+1,"estm_tt")){
			sheetObject.CellFontColor(i+1,"diff") = sheetObject.RgbColor(255,0,0);
		}
	}
}

// Open VVD Search POP UP
function openVVDList(){
	var newWin = window.showModalDialog("ESD_SCE_0063.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:450px");
}


// Open Multi Select POP UP
function openAddPaste(dist){
	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
}


// Multi Values 연결
function addValueNo(dist, multi_value){
	var multis = multi_value.split('\n');

	multi_value = '';
	for(var i = 0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
	}
	if(multi_value != ''){
		document.getElementById(dist).value = multi_value;
	}
}
    

// opener function
function addVVDNo(vvds, dist, loc_cd){
	var formObject = document.form;
	if(vvds != ''){
		document.getElementById('vvd_').value = vvds;
	}
}
    

// opener function
function onbuttondisable(){
	ComBtnDisable("btn_retrieve"); 		
}


function onObjectFocusout1(formObj){
	if(formObj.cs_grp_id.value.length  > 6){
    	  formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
 	    	var sheetObj = sheetObjects[0];
 	    	
 	    	sheetObj.ShowDebugMsg = false;
 	    	formObj.f_cmd.value = MULTI05;
 	    	sheetObj.RemoveEtcData();
 	    	if(formObj.cs_grp_id.value !=''){  
 	    	  sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));

   		      ComEtcDataToForm(formObj,sheetObj);
   		      /*초기화*/
   		      if(formObj.tp_id.value == ''){
   		    	formObj.cs_grp_id.value = ''
   		      }
 	    	}
 	    	ComBtnEnable("btn_retrieve");	
 	   }   
 }


// 대문자 변경 function
function toUpperCase(str_){
    str="";
    for(i=0;i<str_.length;i++){
        str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
    }
    return str;
}


// Customer 입력 받는 메소드(POP UP 에서 호출한다.)
function openCustomer(){
	var newWin = window.showModalDialog("ESD_SCE_0062.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
}


// 0062 POP-UP에서 호출하는 opener function
function openESD009Screen(cs_grp_id, tp_id, grp_nm){

	var formObject = document.form;
	formObject.cs_grp_id.value = cs_grp_id;
	onObjectFocusout(formObject);

	formObject.cs_grp_id.value = cs_grp_id;
	formObject.tp_id.value = tp_id;
	formObject.grp_nm.value = grp_nm;
	
}


// openESD009Screen 내 function
function onObjectFocusout(formObj){
	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	var sheetObj = sheetObjects[0];
	sheetObj.ShowDebugMsg = false;
	formObj.f_cmd.value = MULTI05;
	sheetObj.RemoveEtcData();
	if(formObj.cs_grp_id.value !=''){  
	  sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));
      ComEtcDataToForm(formObj,sheetObj);
      /*초기화*/
      if(formObj.tp_id.value == ''){
    	formObj.cs_grp_id.value = ''
      }
	}
}