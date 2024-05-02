/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0338.js
*@FileTitle : MSN & Bonded Inform Designate-Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0338()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.msn1_onChange				= msn1_onChange;
	this.msn2_onChange				= msn2_onChange;
	this.loadPage					= loadPage;
	this.sheet1_OnLoadFinish		= sheet1_OnLoadFinish;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.checkBlankMsn				= checkBlankMsn;
	this.validateDischCY			= validateDischCY;
	this.validateMsn				= validateMsn;
	this.validateForm				= validateForm;
	this.sheet1_OnPopupClick		= sheet1_OnPopupClick;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;

		case "btn_listprint":
			var exceptLines = "";
			var chkCnt = 0;
			// 체크 안된 데이터들 묶음
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				if (sheetObject1.CellValue(i, "Sel")==0) 
					exceptLines = exceptLines + "|" + i;
				else
					chkCnt++;
			}			
			if (chkCnt > 0) {				
				sheetObject1.Redraw = false; 
				sheetObject1.SpeedDown2Excel(-1, false, false, "", "",
						                     false, false, "", false, "Sel", exceptLines 
											);
				sheetObject1.Redraw = true; 
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;	

		case "btn_confirm":
			// Confirm 처리
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				if (sheetObject1.CellValue(i, "mf_cfm_flg")=="Y") continue;
				sheetObject1.CellValue(i, "mf_cfm_flg") = "Y";
				sheetObject1.CellFontColor(i, "mf_cfm_flg") = sheetObject1.RgbColor(255,0,0);
			}
			break;	

		case "btn_close":
			window.close();
			break;																				

		case "btn_msn":
			if (formObject.msn2.value.length > 0) formObject.msn2.value = ComLpad(formObject.msn2.value, 4, "0");
			if (formObject.msn1.value=="0000") formObject.msn1.value="0001";
			// 유효성 체크
			if (formObject.msn2.value.length > 0 && formObject.msn2.value < formObject.msn1.value) {
				ComShowCodeMessage("BKG00689");
				formObject.msn2.focus();
			}else if (validateMsn()==false) {
				// 유효성 체크2
				ComShowCodeMessage("BKG95024");
				formObject.msn2.focus();
			}else {
				// MSN 배정
				sheetObject1.WaitImageVisible = false;
				ComOpenWait(true);
				var nowMsn=formObject.msn1.value;
				var maxMsn=formObject.msn2.value;
				if (maxMsn.length < 1) maxMsn=9999;
				for(var i=1; i <= sheetObject1.RowCount; i++) {
					if (sheetObject1.CellValue(i, "mf_seq_no").trim().length > 0) continue;
					if ( nowMsn > maxMsn ) break;
					sheetObject1.CellValue(i, "mf_seq_no") = ComLpad(nowMsn, 4, "0");
					sheetObject1.CellFontColor(i, "mf_seq_no") = sheetObject1.RgbColor(255,0,0);
					nowMsn++;
				}
				// 자동 저장
				formObject.f_cmd.value = MULTI;				
				sheetObject1.DoSave("ESM_BKG_0338GS.do", FormQueryString(formObject),-1,false);
				// 배정완료후 폼 업데이트
				formObject.msn1.value = ComLpad(nowMsn, 4, "0");
				formObject.msn2.value = "";
				ComOpenWait(false);
			}
			checkBlankMsn(sheetObject1, formObject);
			break;				
		case "btn_editBl":
			if (sheetObject1.RowCount < 1) {
				ComShowCodeMessage('BKG00249');
			}else {
				var sUrl = "/hanjin/ESM_BKG_0333.do?bl_no="+sheetObject1.CellValue(sheetObject1.SelectRow, "bl_no");
				sUrl = sUrl + "&pgmNo=ESM_BKG_0333";
	  			ComOpenWindowCenter(sUrl, "ESM_BKG_0333", 1024, 560, false);
			}
  			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
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

/**
 * MSN1 입력 항목 변경시 처리
 * @return
 */
function msn1_onChange() {
	document.form.msn1.value = ComLpad(document.form.msn1.value,4,"0");
}

/**
 * MSN2 입력 항목 변경시 처리
 * @return
 */
function msn2_onChange() {
	document.form.msn2.value = ComLpad(document.form.msn2.value,4,"0");
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	var formObj = document.form;
	
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	
	// ETA, ETD 포맷팅
	formObj.eta.value = ComGetMaskedValue(formObj.eta.value, "ymd");
	formObj.etd.value = ComGetMaskedValue(formObj.etd.value, "ymd");
	formObj.msn2.className="input2";
	formObj.msn2.readOnly=true;
	
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);		
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 400;

		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(32, 11, 0, true); 

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)

		var HeadTitle = "|Sel.|Seq.|Confirm|MSN|B/L No.|B/L Type|Entry Type|Carry-In CY|Disch. CY|Bonded W/H|Bonded Type|Consignee Name|Package|Package|Weight(KGS)|POL|POD|DEL|Bulk|Reefer|DG|AKW|BDR|C/A|STS|Bkg No.|BL Type|MSN NO|Next VVD|Relay POL|Relay POD";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);


		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   	daCenter,  	 false,  	"ibflag");
		InitDataProperty(0, cnt++ , dtCheckBox,    	50,     daCenter,    false,     "Sel");
		InitDataProperty(0, cnt++ , dtSeq,      	30,     daCenter,    false,     "Seq", 					false, 	  "", 	   dfNone, 			0, 	   false, 		false, 0, false, false);
		InitDataProperty(0, cnt++ , dtData,      	50,     daCenter,    false,     "mf_cfm_flg",        	false,    "",      dfEngUpKey, 		0,     true,		true,  1);
		InitDataProperty(0, cnt++ , dtData,      	40,     daCenter,    false,     "mf_seq_no",         	false,    "",      dfUserFormat, 	0,     true,		true);
		InitDataProperty(0, cnt++ , dtData,      	90,     daCenter,    false,     "bl_no",         		false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtCombo, 		65,     daCenter,    false,     "kr_cstms_bl_tp_cd",    false,    "",      dfNone, 		0,     true,		true);
		InitDataProperty(0, cnt++ , dtPopupEdit, 	70,     daCenter,  	 false,     "cstms_clr_tp_cd",      false,    "",      dfEngUpKey, 	0,     true,		true);
		InitDataProperty(0, cnt++ , dtPopupEdit, 	90,     daCenter,  	 false,     "cstms_dchg_loc_wh_cd", false,    "",      dfNone, 		0,     true,		true);
		InitDataProperty(0, cnt++ , dtPopupEdit, 	90,     daCenter,  	 false,     "cstms_crr_in_loc_wh_cd", false,  "",      dfNone, 		0,     true,		true);  // 사용자 요청으로 Disch. CY, Carry-in CY 이름이 바뀜.
		InitDataProperty(0, cnt++ , dtPopupEdit, 	90,     daCenter,  	 false,     "cstms_clr_wh_cd",      false,    "",      dfNone, 			0,     true,		true,	10); 
		InitDataProperty(0, cnt++ , dtCombo, 		80,     daCenter,    false,     "bd_tp_cd",   			false,    "",      dfNone,			0,     true,		true);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtData,      	190,    daLeft,		 false,     "cust_nm",   			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daRight, 	 false,     "pck_qty",    			false,    "",      dfNullInteger, 	0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	25,     daRight, 	 false,     "pck_tp_cd",         	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	80,     daRight, 	 false,     "act_wgt",           	false,    "",      dfNullInteger, 	0,     false,		false); 
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "pol_cd",          		false,    "",      dfNone,			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "pod_cd",         		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "del_cd",         		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "bb_cgo_flg",           false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "rc_flg",           	false,    "",      dfNone, 			0,     false,		false); 
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "dcgo_flg",          	false,    "",      dfNone,			0,     false,		false);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "awk_cgo_flg",         	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "bdr_flg",         		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "bdr_cng_flg",          false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	55,     daCenter,    false,     "bkg_sts_cd",           false,    "",      dfNone, 		0,     false,		false); 
		InitDataProperty(0, cnt++ , dtHidden,      	55,     daCenter,    false,     "bkg_no",          		false,    "",      dfNone, 			0,     false,		false); 
		InitDataProperty(0, cnt++ , dtHidden,      	55,     daCenter,    false,     "bl_tp_cd",        		false,    "",      dfNone, 			0,     false,		false); 
		InitDataProperty(0, cnt++ , dtHidden,      	55,     daCenter,    false,     "mf_ref_no",       		false,    "",      dfNone, 			0,     false,		false); 		
		// TS 인 경우 보여주고 LOCAL 은 숨기기
		if (document.form.type.value=='Local') {
			InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,    false,     "next_vvd",	        false,    "",      dfNone, 			0,     false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,    false,     "relay_pol_cd",     false,    "",      dfNone, 			0,     false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,    false,     "relay_pod_cd",     false,    "",      dfNone, 			0,     false,		false);
		}else {
			InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,    false,     "next_vvd",	        false,    "",      dfNone, 			0,     false,		false);
			InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,    false,     "relay_pol_cd",    false,    "",      dfNone, 			0,     false,		false);
			InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,    false,     "relay_pod_cd",    false,    "",      dfNone, 			0,     false,		false);
		}

		InitDataCombo(0, "kr_cstms_bl_tp_cd","S\tSimple|C\tConsole|E\tEmpty", "S|C|E");
		var arrayKind = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S' ];
		var arrayBondedType = [ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
		                       '부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
		                       'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
		                       '자선', '타소 장치', 'Empty 컨테이너' , '부두창고' ];
		var bd_tp_cd_text=" \t선택안함", bd_tp_cd_code=" ";
		for(var i=0; i < arrayKind.length; i++) {
			bd_tp_cd_text = bd_tp_cd_text + "|";
			bd_tp_cd_code = bd_tp_cd_code + "|";
			bd_tp_cd_text = bd_tp_cd_text + arrayKind[i]+"\t"+arrayBondedType[i];
			bd_tp_cd_code = bd_tp_cd_code + arrayKind[i];
		}
		InitDataCombo(0, "bd_tp_cd",   bd_tp_cd_text, bd_tp_cd_code);

		InitUserFormat(0, "mf_seq_no", "####", "");
		ShowButtonImage = 2;

	}
	break;
	case "sheet2":      //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(1, 0, 0, true); 
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
			
			var HeadTitle = "Sel";
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   daCenter,  	 false,  	"ibflag");
		}
		break;


	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw = false; 
			sheetObj.DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj));
			sheetObj.Redraw = true;
			
			checkBlankMsn(sheetObj, formObj);
			
			formObj.msn1.value = ComLpad(sheetObj.EtcData('msn1').trim(),4,"0");
			if (formObj.msn1.value=="0000") formObj.msn1.value="0001";
			ComOpenWait(false);
			
		}
		break;

	case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)) {
			if (ComShowCodeConfirm("BKG00350")) {
				formObj.f_cmd.value = MULTI;
				// 저장
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoSave("ESM_BKG_0338GS.do", FormQueryString(formObj) , -1, false);
				ComOpenWait(false);
			}
		}
		break;

	}
}

/**
 * 빈 MSN 체크 
 * @param sheetObj
 * @param formObj
 * @return
 */
function checkBlankMsn(sheetObj, formObj) {
	// MSN 빈 놈이 있는지 체크하여 빈것이 있으면 MSN2 활성화
	var blankMsn = false;
	for(var i=1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.CellValue(i, "mf_seq_no").trim().length < 1) {
			blankMsn = true;
			break;
		}
	}
	if (blankMsn) {
		formObj.msn2.className="input1";
		formObj.msn2.readOnly = false;
		document.all.btn_msn.style.color='#FF0000';
		ComBtnEnable("btn_msn");
	}else {
		formObj.msn2.className="input2";
		formObj.msn2.readOnly = true;
		document.all.btn_msn.style.color='#C0C0C0';
		ComBtnDisable("btn_msn");
	}
}

/**
 * MSN 변경시 버튼 체크
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Col==4) checkBlankMsn(sheetObj, document.form);
	if (Col==8) {
		// 입력한 Disch CY 값의 유효성 검증
		if (validateDischCY(Value)==false) {
			sheetObj.CellValue2(Row, Col) = "";
			ComShowCodeMessage("BKG95022", Value);		
			sheetObj.SelectCell(Row, Col);	
		}
	}
}

// 입력한 Disch CY의 유효성 검사
function validateDischCY(cyVal)
{
	var check = false;
	var formObj = document.form;
	form.f_cmd.value = SEARCH01;
	
	var params = "&disch_cy="+cyVal;
	
	sheetObjects[1].DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj) + params);
	
	if (sheetObjects[1].EtcData("disc_valid")!="X") {
		check = false;
	} else {
		check = true;
	}
	return check;
}

// MSN 유효성 검사
function validateMsn()
{
	var check = false;
	var formObj = document.form;
	var params = "&mf_seq_no="+ComLpad(formObj.msn1.value,4,"0");
	
	form.f_cmd.value = SEARCH02;
	
	sheetObjects[1].DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj)+params);
	
	if (sheetObjects[1].EtcData("msn_valid")!="X") {
		check = false;
	} else {
		check = true;
	}
	return check;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSAVE:			
			// Entry Type 과 Disch.CY 빈값 체크
			for(var i=1; i <= sheetObj.RowCount; i++) {
				
				if (sheetObj.CellValue(i, "cstms_dchg_loc_wh_cd").trim().length < 1) {
					ComShowCodeMessage("BKG95023");
					sheetObj.SelectCell(i, "cstms_dchg_loc_wh_cd");
					return false;
				}
				if (sheetObj.CellValue(i, "cstms_crr_in_loc_wh_cd").trim().length < 1) {
					ComShowCodeMessage("BKG95023");
					sheetObj.SelectCell(i, "cstms_crr_in_loc_wh_cd");
					return false;
				}
				if (sheetObj.CellValue(i, "cstms_clr_tp_cd").trim().length < 1) {
					ComShowCodeMessage("BKG95023");
					sheetObj.SelectCell(i, "cstms_clr_tp_cd");
					return false;
				}
			}
			break;
		}
	}

	return true;
}

/**
 * sheet1 의 POP-UP 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col)
{
	with(sheetObj)
	{
		var sName = ColSaveName(Col);				

		if(sName == "cstms_clr_tp_cd"){
			// Entry Type
			var sUrl = "/hanjin/ESM_BKG_0335_Q.do?view_type=inquiry&entry_code="+sheetObj.CellValue(Row, Col);
			sUrl = sUrl + "&pgmNo=ESM_BKG_0335_Q";
  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0335", 510, 400, true);
  			if (rtnVal != null) sheetObj.CellValue(Row, Col) = rtnVal;
		}else if(sName == "cstms_dchg_loc_wh_cd"){
			// Disch Type
			var sUrl = "/hanjin/ESM_BKG_0334_Q.do?view_type=inquiry&otr_dchg_cd="+sheetObj.CellValue(Row, Col);
			sUrl = sUrl + "&pgmNo=ESM_BKG_0334_Q";
  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 700, 450, true);
  			if (rtnVal != null) sheetObj.CellValue(Row, Col) = rtnVal.cd;						
		}else if(sName == "cstms_crr_in_loc_wh_cd"){
			// Disch Type
			var sUrl = "/hanjin/ESM_BKG_0334_Q.do?view_type=inquiry&otr_dchg_cd="+sheetObj.CellValue(Row, Col);
			sUrl = sUrl + "&pgmNo=ESM_BKG_0334_Q";
  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 700, 450, true);
  			if (rtnVal != null) sheetObj.CellValue(Row, Col) = rtnVal.cd;						
		}else if (sName == "cstms_clr_wh_cd"){
			// Bonded WH Type
			var sUrl = "/hanjin/ESM_BKG_0345.do?cstms_cd="+sheetObj.CellValue(Row, Col);
			sUrl = sUrl + "&pgmNo=ESM_BKG_0345";
  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0345", 1024, 570, true);
  			if (rtnVal != null) sheetObj.CellValue(Row, Col) = rtnVal.cd;						
		}
	}
}			