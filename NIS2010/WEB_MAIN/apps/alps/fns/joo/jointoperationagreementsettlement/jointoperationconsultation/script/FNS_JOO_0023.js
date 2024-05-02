/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0023.js
 *@FileTitle : CSR Approval
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.11 박희동
 * 1.0 Creation
 * 
 * 2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
 * 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class fns_joo_0023 : fns_joo_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0023() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
//		if (srcName == null || srcName == "apro_flg" || srcName == "cxl_flg" || srcName == "urg_pay_flg") {
		if (srcName == null || srcName == "apro_flg" || srcName == "cxl_flg") {		
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
			case "btn_calendar":
				var cal = new ComCalendar();
				cal.select(formObj.slp_iss_dt, 'yyyy-MM-dd');
				break;
				
			case "btn_csr":
				var csrNo = formObj.csr_no.value;
				if (csrNo.length < 19){
					ComShowCodeMessage("JOO00074");
					return;
				}
				var param = '?csrNo='+csrNo;
				ComOpenPopup("/hanjin/FNS_JOO_0024.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
				break;

			case "btn_evd":
				var csrNo = formObj.csr_no.value;
				if (csrNo.length < 19){
					ComShowCodeMessage("JOO00074");
					return;
				}
				//AP인경우에는 Evidence가 없으므로...
				if (csrNo.substring(0,2) != "06"){
					ComShowCodeMessage("JOO00119");
					return;
				}
				//Evidence Type이 TAX인 경우만 Evidence가 있음
				if (formObj.evid_tp_cd.value != "1"){
					ComShowCodeMessage("JOO00119");
					return;
				}

				var param = '?csrNo='+csrNo+'&editable=N';
				ComOpenPopup("/hanjin/FNS_JOO_0018.do"+param, 900, 600, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop2");
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
			
			case "btn_close":
				self.close();
				break;

			case "btn_apro_step_edit":
				var v_ofc_cd = formObj.ofc_cd.value;
				var v_sub_sys_cd = "JOO";
				var param = '?mode=save&ofc_cd='+v_ofc_cd+'&csr_no='+formObj.csr_no.value+'&sub_sys_cd='+v_sub_sys_cd+'&classId=COM_ENS_0T1&target_obj_nm=apro_step';
				ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 540, 'afterAproStepEdit', 'none', true);
				break;
				
			case "btn_apro_step_view":
				var param = "?apro_rqst_no="+formObj.apro_rqst_no.value;
				ComOpenPopup('/hanjin/COM_ENS_0W1.do' + param, 640, 310, '', 'none', true);
				break;
																
			case "btn_attach":
				if (formObj.csr_no.value==undefined ||
						formObj.csr_no.value==null ||
						formObj.csr_no.value.trim()==''){
			    		ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
						return false;
				}								
				var param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"Y";
				ComOpenPopup("/hanjin/FNS_JOO_0098.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
				break;
				
			case "btn_gwcl":
				if (formObj.csr_no.value==undefined ||
						formObj.csr_no.value==null ||
						formObj.csr_no.value.trim()==''){
					    ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
						return false;
				}				

				var param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"Y";													
//				ComOpenPopup("/hanjin/FNS_JOO_0099.do"+param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
				window.open("/hanjin/FNS_JOO_0099.do"+param, "", "status=no, width=835, height=380, resizable=no, scrollbars=no");				
				break;						
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function popupFinish(rowArray){
	var fstArray;
	var scnArray;
//
//	for (var i=0; i < rowArray.length; i++){
//		fstArray = rowArray[i];
//		
//		for(var j=0; j < fstArray.length; j++){
//		}
//	}
}

function afterAproStepEdit(){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
    
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetNo) {
		case 1: //t1sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "radio|checkbox|ibflag|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_iss_dt|slp_ser_no|vndr_seq|cust_cnt_cd|cust_seq|csr_desc|csr_locl_curr_cd|csr_locl_amt|csr_usd_amt|eff_dt|evid_tp_cd|apro_flg|apro_dt|cxl_flg|cxl_desc|csr_offst_no|ddct_flg|ddct_locl_amt|ddct_desc|rqst_locl_amt|rqst_dt|csr_tp_cd|rvs_csr_flg|org_slp_tp_cd|org_slp_func_cd|org_slp_ofc_cd|org_slp_iss_dt|org_slp_ser_no	|csr_no	|issuer	|vndr_cust_seq	|lgl_eng_nm	|evid_tp_nm|clz_sts_cd|auth_cd|lst_apro_flg|apro_rqst_no|apro_rqst_seq|urg_pay_flg|urg_pay_yn|atch_file_cnt|gw_ctrt_cnt";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck  , 30, daCenter,false, "radio"               );
				InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter,false, "check"               );
				InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, prefix+"ibflag"           );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"slp_tp_cd"        );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"slp_func_cd"      );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"slp_ofc_cd"       );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"slp_iss_dt"       ,false,"",dfUserFormat2);
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"slp_ser_no"       );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"vndr_seq"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"cust_cnt_cd"      );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"cust_seq"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_desc"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_locl_curr_cd" );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_locl_amt"     ,false,"",dfNullFloat, 2);
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_usd_amt"      );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"eff_dt"           ,false,"",dfUserFormat2);
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"evid_tp_cd"       );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"apro_flg"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"apro_dt"          );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"cxl_flg"          );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"cxl_desc"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_offst_no"     );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"ddct_flg"         );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"ddct_locl_amt"    );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"ddct_desc"        );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"rqst_locl_amt"    );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"rqst_dt"          ,false,"",dfUserFormat2);
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_tp_cd"        );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"rvs_csr_flg"      );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"org_slp_tp_cd"    );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"org_slp_func_cd"  );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"org_slp_ofc_cd"   );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"org_slp_iss_dt"   );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"org_slp_ser_no"   );	
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"csr_no"           );	
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"issuer"           );	
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"vndr_cust_seq"    );	
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"lgl_eng_nm"       );	
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"evid_tp_nm"       );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"clz_sts_cd"       );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"auth_cd"          );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"lst_apro_flg"     );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"apro_rqst_no"     );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"apro_rqst_seq"    );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"urg_pay_flg"    );				
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"urg_pay_yn"    );
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"atch_file_cnt"    );				
				InitDataProperty(0, cnt++, dtData  , 30, daCenter, false, prefix+"gw_ctrt_cnt"    );
				
				InitUserFormat2(0, prefix+"slp_iss_dt", "####-##-##", "-");				
				InitUserFormat2(0, prefix+"eff_dt"    , "####-##-##", "-");				
				InitUserFormat2(0, prefix+"rqst_dt"   , "####-##-##", "-");				
			}
		break;		
		case 2:      //sheet3 init
			with (sheetObj) {
	            // 높이 설정
	            style.height = 0;
	            //전체 너비 설정
	        	SheetWidth = 665;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msNone;

	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 5, 100);

	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(5, 0, 0, true);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, true, true, false, false, false)

	            var HeadTitle = "|";

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	            
	            InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,  "ibflag");
	        }
	        break;		
		
	}
}

function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur' , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_focus', formObj);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    
    axon_event.addListener('keypress', 'csr_no_keypress' , 'csr_no');		
    axon_event.addListener('keypress', 'slp_iss_dt_keypress' , 'slp_iss_dt');		
    axon_event.addListener('click', 'apro_flg_click', 'apro_flg');    
    axon_event.addListener('click', 'cxl_flg_click', 'cxl_flg');
//    axon_event.addListener('click', 'urg_pay_flg_click', 'urg_pay_flg');       
}


//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
    ComChkObjValid(event.srcElement);
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function csr_no_keypress(){
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
    if (document.form.slp_iss_dt.value != "")
    	document.form.slp_iss_dt.value = "";
}

function slp_iss_dt_keypress(){
    ComKeyOnlyNumber(document.form.slp_iss_dt);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0023GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
									
			setSheet2Input(formObj, sheetObj);
//			setUrgPayFlg(sheetObj);
			setCxlFlg(sheetObj);		// 201407 민정호, 초기화 : Cancel, FMS와 같이 처리
			break;
			
		case IBSAVE: //저장						
			var SaveStr = ComGetSaveString(sheetObj);
					
			if (SaveStr==""){
				ComShowCodeMessage("JOO00036");
				return;
			}
														
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
												
			var param = SaveStr + "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
								
			//var sXml = sheetObj.DoSave("FNS_JOO_0023GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), -1, false);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0023GS.do", param);
			
			var key = ComGetEtcData(sXml,"key");

            if (key.length > 0) {
                formObj.key.value = key;
                sheetObj.RequestTimeOut = 10000;
                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
            }			
			break;
			
		//BackEndJob Status 조회
		case IBSEARCH_ASYNC02: 			
		    formObj.f_cmd.value = SEARCHLIST;
		    var sXml = sheetObj.GetSearchXml("FNS_JOO_0023GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix));
		    var jobState = ComGetEtcData(sXml, "jb_sts_flg")

		    if (jobState == "3") {
		        ComOpenWait(false);
		        ComShowCodeMessage("JOO00160");
		        clearInterval(timer);
		        //save 완료 후 창을 닫고 opener를 refresh한다.
			    for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
			      	sheetObj.CellValue2(inx, "radio") = "1";
			      	sheetObj.CellValue2(inx, "check") = "1";
			    }
//			    comPopupOK();
			    //201407 민정호 Save 한 후 재조회 후 화면 닫음
			    opener.popupFinish1();		
			    window.close(); 		 			    
		    } else if (jobState == "4") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // BackEndJob을 실패 하였습니다.
		        ComShowCodeMessage('JOO00151');
		    } else if (jobState == "5") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // 이미 BackEndJob 결과 파일을 읽었습니다.
		        ComShowCodeMessage('JOO00152');
		    }			
			break;									
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			break;
			
		case IBSAVE: //저장
			if (JooGetRadioValue(formObj.cxl_flg) == "Y" && formObj.cxl_desc.value.length == 0){
				ComShowCodeMessage("JOO00077");
				formObj.cxl_desc.focus();
				return false;
			}
			//2010.01.06 박효숙 차장 ==> Approval인데 eff.date가 close면 처리불가함
			if (JooGetRadioValue(formObj.apro_flg) == "Y" && sheetObj.CellValue(sheetObj.LastRow, prefix+"clz_sts_cd") == "C"){
				ComShowCodeMessage("JOO00170");
				return false;
			}
			setInput2Sheet(formObj, sheetObj);
			break;			
	}

	return true;
}

/**
 * sheet -> input
 * @param formObj
 * @param sheetObj
 * @return
 */
function setSheet2Input(formObj, sheetObj){
	formObj.slp_team_cd     .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"slp_ofc_cd"       );
	formObj.slp_iss_dt      .value = sheetObj.CellText (sheetObj.LastRow, prefix+"slp_iss_dt"       );
	formObj.rqst_dt         .value = sheetObj.CellText (sheetObj.LastRow, prefix+"rqst_dt"          );
	formObj.eff_dt      	.value = sheetObj.CellText (sheetObj.LastRow, prefix+"eff_dt"	        );
	formObj.issuer          .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"issuer"           );	
	formObj.csr_desc        .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"csr_desc"         );
	formObj.vndr_cust_seq   .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"vndr_cust_seq"    );
	formObj.lgl_eng_nm      .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"lgl_eng_nm"       );	
	formObj.csr_locl_curr_cd.value = sheetObj.CellValue(sheetObj.LastRow, prefix+"csr_locl_curr_cd" );
	formObj.csr_locl_amt    .value = sheetObj.CellText (sheetObj.LastRow, prefix+"csr_locl_amt"     );
	formObj.evid_tp_nm      .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"evid_tp_nm"       );	
	formObj.evid_tp_cd      .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"evid_tp_cd"       );	
	formObj.apro_flg        .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"apro_flg"         );
	formObj.apro_dt         .value = sheetObj.CellText (sheetObj.LastRow, prefix+"apro_dt"          );
	formObj.old_apro_dt     .value = sheetObj.CellText (sheetObj.LastRow, prefix+"apro_dt"          );
	formObj.cxl_flg         .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"cxl_flg"          );
	formObj.cxl_desc        .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"cxl_desc"         );
//	formObj.urg_pay_flg         .value = sheetObj.CellValue(sheetObj.LastRow, prefix+"urg_pay_flg"          );	
	
	var aproFlg = sheetObj.CellValue(sheetObj.LastRow, prefix+"apro_flg");
	if (aproFlg == "Y"){
		setCxlFlgDisable(true);
		document.form.apro_flg[0].checked = true;
	}else{
		setCxlFlgDisable(false);
		document.form.apro_flg[1].checked = true;
	}
	
	var cxlFlg = sheetObj.CellValue(sheetObj.LastRow, prefix+"cxl_flg");
	if (cxlFlg == "Y"){
		document.form.cxl_flg[0].checked = true;
		document.form.cxl_desc.readOnly  = false;
		document.form.cxl_desc.className = "input";
	}else{
		document.form.cxl_flg[1].checked = true;
		document.form.cxl_desc.readOnly  = true;
		document.form.cxl_desc.className = "input2";
	}
	
	// Attachment, GW Contract Link 활성화 수정
	var atchFileCnt = parseInt(sheetObj.CellValue(sheetObj.LastRow, prefix+"atch_file_cnt"));
	var gwCtrtCnt = parseInt(sheetObj.CellValue(sheetObj.LastRow, prefix+"gw_ctrt_cnt"));
	
	if(atchFileCnt > 0){
		document.getElementById("btn_attach").style.color = "blue";
	}
	if(gwCtrtCnt > 0){
		document.getElementById("btn_gwcl").style.color = "blue";
	}
	
//	var urgPayFlg = sheetObj.CellValue(sheetObj.LastRow, prefix+"urg_pay_flg");
//	if (urgPayFlg == "Y"){
//		document.form.urg_pay_flg[0].checked = true;
//	}else{
//		document.form.urg_pay_flg[1].checked = true;
//	}	
}

/**
 * input -> sheet
 * @param formObj
 * @param sheetObj
 * @return
 */
function setInput2Sheet(formObj, sheetObj){
	var aproFlg = JooGetRadioValue(formObj.apro_flg);
	var cxlFlg  = JooGetRadioValue(formObj.cxl_flg);
//	var urgPayFlg  = JooGetRadioValue(formObj.urg_pay_flg);	
	
	sheetObj.CellValue(sheetObj.LastRow, prefix+"apro_flg") = aproFlg;
	sheetObj.CellValue(sheetObj.LastRow, prefix+"apro_dt" ) = ComReplaceStr(formObj.apro_dt .value,"-","");
	sheetObj.CellValue(sheetObj.LastRow, prefix+"cxl_flg" ) = cxlFlg;
	sheetObj.CellValue(sheetObj.LastRow, prefix+"cxl_desc") = formObj.cxl_desc.value;
//	sheetObj.CellValue(sheetObj.LastRow, prefix+"urg_pay_flg" ) = urgPayFlg;	
}

/**
 * approval flag 클릭
 * @return
 */
function apro_flg_click(){
	if (document.form.apro_flg[0].checked){
		setCxlFlgDisable(true);
	}else{
		setCxlFlgDisable(false);
		document.form.cxl_flg[0].checked = true;	
		document.form.cxl_desc.readOnly  = false;
		document.form.cxl_desc.className = "input";
		document.form.cxl_desc.value     = "";		
	}	
}

function cxl_flg_click(){
	if (document.form.cxl_flg[0].checked){
		document.form.cxl_desc.readOnly = false;
		document.form.cxl_desc.className = "input";
		document.form.cxl_desc.focus();
	}else{
		document.form.cxl_desc.value    = "";
		document.form.cxl_desc.readOnly = true;
		document.form.cxl_desc.className = "input2";
		
		document.form.apro_flg[0].checked = true;
	}	
}

//function urg_pay_flg_click(){
//	if (document.form.urg_pay_flg[0].checked){
//		document.form.apro_flg[0].checked = true;
//		
//		document.form.cxl_flg[1].checked = true;
//		document.form.cxl_desc.value    = "";
//		document.form.cxl_desc.readOnly = true;
//		document.form.cxl_desc.className = "input2";		
//	}else{
//		document.form.apro_flg[1].checked = true;
//		
//		document.form.cxl_flg[0].checked = true;
//		document.form.cxl_desc.value    = "";
//		document.form.cxl_desc.readOnly = false;
//		document.form.cxl_desc.className = "input";		
//		
//	}	
//}

/**
 * Cancel reason disabled 시키기
 * @param argBol
 * @return
 */
function setCxlFlgDisable(argBol){
	if (argBol){
		//approval 했을경우 기존에 apro_dt가 있으면 그것을 쓰고 아니면 sysdate를 넣는다.
		if (document.form.old_apro_dt.value == ""){
			document.form.apro_dt.value = document.form.sysdate.value;
		}else{
			document.form.apro_dt.value = document.form.old_apro_dt.value;
		}
		//cancel의 값은 No...disable
		document.form.cxl_flg[1].checked = true;
		document.form.cxl_desc.readOnly  = true;
		document.form.cxl_desc.className = "input2";
		document.form.cxl_desc.value     = "";				
	}else{
		document.form.apro_dt.value  = "";
	}

	for (var inx=0; inx < document.form.cxl_flg.length; inx++){
		document.form.cxl_flg[inx].disabled = argBol;		
	} 	
}

function sheet1_OnSearchEnd(sheetObj, errMsg){	
	if (sheetObj.RowCount > 0 ){
		var auth_cd = sheetObj.CellValue(sheetObj.LastRow, prefix+"auth_cd");
		if (auth_cd == "W"){
			JooSetBtnClass("C", true);
		}else{
			JooSetBtnClass("C", false);
		}
		
		if (sheetObj.CellValue(sheetObj.LastRow, prefix+"evid_tp_cd") == "1"){
			JooSetBtnClass("U", true);
		}else{
			JooSetBtnClass("U", false);
		}
		
		document.form.apro_rqst_no.value = sheetObj.CellValue(sheetObj.LastRow, prefix+"apro_rqst_no");
		
    	//민정호(201407)
    	//joo csr no에서 앞에 2자리가 18 이면 둘다 비활성화		
    	if(document.form.csr_no.value.substr(0,2) == '18'){
			JooSetBtnClass("A", false);
    	}else{
			JooSetBtnClass("A", true);    		
    	}			 	    	    	
	}else{
		JooSetBtnClass("C", false);
		JooSetBtnClass("U", false);
	}
}

function UF_getBackEndJobStatus() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}


///**
// * 10만불 이상만 후결처리 가능하게 후결 활성화 세팅 <br>
// **/
//function setUrgPayFlg(sheetObj){
//	var urgPayYn = sheetObj.CellValue(sheetObj.LastRow, prefix+"urg_pay_yn");
//	
//	if(urgPayYn == 'Y'){
//		document.form.urg_pay_flg[0].disabled = false;
//		document.form.urg_pay_flg[1].disabled = false;		
//	}else{
//		document.form.urg_pay_flg[0].disabled = true;
//		document.form.urg_pay_flg[1].disabled = true;		
//		document.form.urg_pay_flg[1].checked = true;		
//	}	
//}

/**
 * 화면로드시 Cancel은 상태가 N으로 세팅(FMS랑 동일하게 구현) <br>
 **/
function setCxlFlg(sheetObj){
	//민정호(201407)
	document.form.cxl_flg[0].checked = true;
	cxl_flg_click();
}

/* 개발자 작업  끝 */