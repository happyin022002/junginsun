	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0155.js
	 *@FileTitle : Disposal Buyer Management
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.11.08
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 * 2009.10.05  권영법
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * History
	 * 2011.03.09 김종옥 [CHM-201109260-01] 조회목록에 CRE Office 컬럼 추가 및 CTRL Office 컬럼 위치 변경.
	 * 2011.05.09 김종옥 [선처리] P.I.C Email '@' 체크 및 Control Office & Buyer Contact Info - Buyer Email '@' 체크 적용.
	 * 2011.09.06 신혜정 [CHM-201113288-01] Customer Code 중복 등록 불가도록 로직 처리
	 * 2012.05.08 신혜정 [CHM-201217734] 저장시, Control Office & Buyer Contact Info [Row Add]시 Customer 셋팅 로직 추가
	 * 2012.06.19 김창헌 [CHM-201218379-01] E-Mail을 multi로 보내는 기능 추가
	 * 2012.11.08 조경완 [CHM-201220026-01] CTRL RHQ AND OFFICE 로 조회하는 기능 구현 요청
	 * 									- Creation Office 조건은 MNR_PARTNER.CTRL_OFC_CD IN (Multi CreOfc), 
	 * 									  CTRL Office 조회는 MNR_PRNR_CNTC_PNT.OFC_CD IN (Multi CtrlOfc) 로 조회된 Data Display되도록 개발
	 * 2012.11.08 Jonghee HAN [선처리] CTRL OFC와 CRE OFC Header Name Switch 
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
	 * @class ess_mnr_0155 : ess_mnr_0155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0155() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	/* ********* General Functions ************* */
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var MnrPrnrStsCode="";
	var saveTextIndex=0;
	var nowLoad=0;
	
	
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
				saveTextIndex="";
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	
			case "btn_new":
	
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				break;
	
			case "btn_save":
				MnrPrnrStsCode="S";
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_remove":
				doActionIBSheet(sheetObjects[0],document.form,REMOVE);
				break;
			case "btn_reject":
				MnrPrnrStsCode="J";
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_confirm":
				MnrPrnrStsCode="C";
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_expire":
				MnrPrnrStsCode="X";
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
	
			case "btn_rowadd":
				doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
				break;
			case "btn_customer":
				ComOpenPopup("COM_ENS_041.do", 780, 520, 'setPopUpParam_COM_ENS_041', '1,0', true);
				break;	
			case "btn_calendar":
				var cal = new ComCalendarFromTo();
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;	
			case "btn_calendar2":
				var cal = new ComCalendarFromTo();
				cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
				break;	
	
			case "btn_send":					
				var emalAdd = "";
				for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
					if((sheetObjects[0].CellValue(i, "sheet1_send_yn") == 1) &&
					   (sheetObjects[0].CellValue(i, "sheet1_mnr_prnr_eml") != "")){
						emalAdd += sheetObjects[0].CellValue(i, "sheet1_mnr_prnr_eml") +"; ";	
					}
				}
				formObject.com_recipient.value = emalAdd;
				ComSendMailModal();	//공통 MAIL 팝업 호출
				break;
			
			case "cre_ofc_cd_popup":
			    ComOpenPopup('/hanjin/COM_ENS_071.do', 770, 450, 'setPopUpParam_cre_ofc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
			
			case "ctrl_ofc_cd_popup":
				ComOpenPopup('/hanjin/COM_ENS_071.do', 770, 450, 'setPopUpParam_ctrl_ofc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
	
			} 
				// end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	
	}             
	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
		ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
	}        
	
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if(sheetObj.RowCount <=0 &&(obj.name!="mnr_prnr_cnt_cd" && obj.name!="mnr_prnr_seq")) return;
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name) 
			{      
			case "mnr_prnr_cnt_cd":   
				setCustomerName();
				break;  
			case "mnr_prnr_seq":   
				setCustomerName();
				break;  
		    case "cre_ofc_cd":   
				cre_ofc_cd_Check();
				break; 
			case "param_ctrl_ofc_cd":   
				ctrl_ofc_cd_Check();
				break; 
			}       
		} 
	}    
	
	
	function obj_keypress(){   
		obj = event.srcElement;    
		keys = event.keyCode;
		if(obj.dataformat == null) return; 
		window.defaultStatus = obj.dataformat;
		var formObj  = document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
			case "empty":   
				break;   
			}
	
		}				 			              
		switch(obj.dataformat) {   
		case "ymd":   
		case "int":       
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":    
			ComKeyOnlyNumber(obj, "-.");
			break; 
		case "eng":   
			ComKeyOnlyAlphabet();
			break;   
		case "engup":  
			if(event.srcElement.name == "mnr_prnr_seq"){
				ComKeyOnlyNumber(obj);
			}
			else
			{
				ComKeyOnlyAlphabet('uppereng');     
			}
			break; 
		}         
	}     	
	function setPopUpParam_COM_ENS_041(array) {
	
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	
		formObj.mnr_prnr_cnt_cd.value = arr[3].substring(0,2);
		formObj.mnr_prnr_seq.value = arr[3].substring(2);
		formObj.mnr_prnr_cnt_nm.value = arr[4];
		var sheetObj=sheetObjects[0];
		if(sheetObj.RowCount > 0)
		{
			sheetObj.CellValue2(sheetObj.SelectRow,"sheet1_mnr_prnr_cnt_cd")=formObj.mnr_prnr_cnt_cd.value;
			sheetObj.CellValue2(sheetObj.SelectRow,"sheet1_mnr_prnr_seq")=formObj.mnr_prnr_seq.value;
			sheetObj.CellValue2(sheetObj.SelectRow,"sheet1_mnr_prnr_cnt_nm")=formObj.mnr_prnr_cnt_nm.value;
			sheetObj.CellValue2(sheetObj.SelectRow,"sheet1_mnr_prnr_cnt_cd_seq")=formObj.mnr_prnr_cnt_cd.value + "" + formObj.mnr_prnr_seq.value;
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){	     
    	comboObjects[comboCnt++] = combo_obj;  
	} 
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();		 
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
	}
	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 500;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
			var HeadTitle1 = "|Sel|Seq|Buyer\nCode|Buyer\nName|Customer\nCode|Req. DT|Buyer\nType|CRE\nOffice|Status|Delete|CTRL\nOffice|Email\nSending";
			//HeadTitle1 += "|delt_flg";
			HeadTitle1 += "|mnr_prnr_cre_seq";
			HeadTitle1 += "|mnr_grp_tp_cd";
			HeadTitle1 += "|mnr_prnr_tp_cd";
			HeadTitle1 += "|ctrl_ofc_cd";
			HeadTitle1 += "|mnr_prnr_knd_dtl_cd";
			HeadTitle1 += "|mnr_prnr_sts_cd";
			HeadTitle1 += "|mnr_prnr_cnt_cd";
			HeadTitle1 += "|mnr_prnr_seq";
			HeadTitle1 += "|edi_id";
			HeadTitle1 += "|sp_ptal_id";
			HeadTitle1 += "|sp_ptal_pwd";
			HeadTitle1 += "|mnr_prnr_locl_lang_nm";
			HeadTitle1 += "|mnr_prnr_addr";
			HeadTitle1 += "|bzet_addr";
			HeadTitle1 += "|mnr_bil_to_nm";
			HeadTitle1 += "|eff_dt";
			HeadTitle1 += "|exp_dt";
			HeadTitle1 += "|bank_nm";
			HeadTitle1 += "|bank_acct_no";
			HeadTitle1 += "|pay_mzd_cd";
			HeadTitle1 += "|pay_term_dys";
			HeadTitle1 += "|zip_cd";
			HeadTitle1 += "|ownr_nm";
			HeadTitle1 += "|bzct_nm";
			HeadTitle1 += "|bztp_nm";
			HeadTitle1 += "|biz_rgst_no";
			HeadTitle1 += "|mnr_shop_flg";
			HeadTitle1 += "|mnr_payr_cnt_cd";
			HeadTitle1 += "|mnr_payr_seq";
			HeadTitle1 += "|mnr_prnr_capi_amt";
			HeadTitle1 += "|empe_knt";
			HeadTitle1 += "|dpt_desc";
			HeadTitle1 += "|mnr_prnr_abbr_nm";
			HeadTitle1 += "|intl_phn_no";
			HeadTitle1 += "|intl_fax_no";
			HeadTitle1 += "|fax_no";
			HeadTitle1 += "|mnr_prnr_rmk";
			HeadTitle1 += "|trsm_mod_cd";
			HeadTitle1 += "|file_seq";
			HeadTitle1 += "|cre_usr_id";
			HeadTitle1 += "|cre_dt";
			HeadTitle1 += "|upd_usr_id";
			HeadTitle1 += "|upd_dt";  
			HeadTitle1 += "|mnr_prnr_cnt_nm";  
			HeadTitle1 += "|mnr_swift_no"; 
			HeadTitle1 += "|disp_cnt";	 
			HeadTitle1 += "|btn_flg";	 
							
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,  	0,	daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtRadioCheck,     	0, 	daCenter,   true,   prefix+"checkbox",              false,	"", dfNone,	0, true,  true);
			InitDataProperty(0, cnt++ , dtSeq,				35,	daCenter,	true,		    "Seq");
			InitDataProperty(0, cnt++ , dtData,				50,	daLeft,		true,	prefix+"mnr_prnr_cre_seq",		false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				120,daLeft,		true,	prefix+"mnr_prnr_lgl_eng_nm",	false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				63, daCenter,	true,	prefix+"mnr_prnr_cnt_cd_seq",	false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtPopupEditFormat,  80, daCenter, 	true, 	prefix+"cre_dt",                false,  "",  	dfDateYmd,      	0,     		true,   	true);
			InitDataProperty(0, cnt++ , dtCombo,		    75, daLeft,  	true,	prefix+"mnr_prnr_knd_cd",		false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,   			80, daCenter, 	true, 	prefix+"cre_ofc_cd",           false,  "",   	dfNone,       		0,      	false,   	false);	
			InitDataProperty(0, cnt++ , dtData,		    	50, daLeft,  	true,	prefix+"mnr_prnr_sts_nm",		false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtCheckBox,			50, daCenter,   true,	prefix+"delt_flg",				false,	"",		dfNone,				0,			false,		false);		//Delete
			InitDataProperty(0, cnt++ , dtData,   			50, daCenter, 	true, 	prefix+"ctrl_ofc_cd",           false,  "",   	dfNone,       		0,      	false,   	false);		//CTRL Office
			InitDataProperty(0, cnt++ , dtCheckBox,			50, daCenter,   true,	prefix+"send_yn",				false,	"",		dfNone,				0,			true,		false);		//Email Sending
						
			//	var HeadTitle1 = "|Seq|Buyer Code|Buyer Name|Request|C.Office|Status";
			//히든 영역
			InitDataProperty(0, cnt++ , dtHidden,	0,	daLeft,	  true,	prefix+"phn_no",			    false,	"",	  dfNone,		0,		true,	true);
			InitDataProperty(0, cnt++ , dtHidden,	0,	daLeft,	  true,	prefix+"mnr_prnr_eml",	     	false,	"",	  dfNone,		0,		true,	true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_grp_tp_cd",         false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_tp_cd",        false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"ctrl_ofc_cd",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_knd_dtl_cd",   false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_sts_cd",       false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_cnt_cd",       false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_seq",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"edi_id",                false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"sp_ptal_id",            false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"sp_ptal_pwd",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_locl_lang_nm", false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_addr",         false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"bzet_addr",             false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_bil_to_nm",         false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"eff_dt",                false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"exp_dt",                false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"bank_nm",               false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"bank_acct_no",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"pay_mzd_cd",            false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"pay_term_dys",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"zip_cd",                false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"ownr_nm",               false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"bzct_nm",               false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"bztp_nm",               false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"biz_rgst_no",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_shop_flg",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_payr_cnt_cd",       false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_payr_seq",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_capi_amt",     false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"empe_knt",              false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"dpt_desc",              false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_abbr_nm",      false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"intl_phn_no",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"intl_fax_no",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"fax_no",                false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_rmk",          false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"trsm_mod_cd",           false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"file_seq",              false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"cre_usr_id",            false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"upd_usr_id",            false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"upd_dt",                false,  "",   dfNone,       0,      true,   true);
	
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_prnr_cnt_nm",       false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"mnr_swift_no",   	    false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"disp_cnt",       		false,  "",   dfNone,       0,      true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter, true, prefix+"btn_flg",       		false,  "",   dfNone,       0,      true,   true);
	
			ColHidden(prefix+"checkbox")=true;
			PopupImage  =  "/hanjin/img/btns_calendar.gif";
			ShowButtonImage = 0;     
		}
	
		break;
	
	
		case 2:
			with (sheetObj) {
				// 높이 설정
				style.height = 120;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				//Sel, Seq, Office(돋보기), Name, Phone No, Email
				var HeadTitle1 = "|Sel|Seq.|CTRL Office|Buyer Name|Buyer Phone|Buyer Email|aply_flg|mnr_prnr_cre_seq|prmry_chk_flg|Interested Location";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "sheet2_";
				InitDataProperty(0, cnt++ , dtHiddenStatus, 0,	daCenter,	true,	prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,     25, daCenter,   true,          "del_chk",           false,	"",	dfNone,	0, true,  true);
				InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,		   "Seq");
				InitDataProperty(0, cnt++ , dtData,		   	80,	daCenter,	true,	prefix+"ofc_cd",			false,	"",	dfEngUpKey,	0,	true,	true,	6);
				InitDataProperty(0, cnt++ , dtData,       	110,daLeft,   	true,	prefix+"mnr_cntc_prnr_nm",	false,	"",	dfNone,		0,	true,	true,	1000);
				InitDataProperty(0, cnt++ , dtData,        	110,daCenter,   true,	prefix+"phn_no",			false,	"",	dfNone,		0,	true,	true,	20);
				InitDataProperty(0, cnt++ , dtData,        	80,	daLeft,   	true,	prefix+"mnr_prnr_eml",		false,	"",	dfNone,		0,	true,	true,	200);
				//히든 영역
				InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	prefix+"aply_flg",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,	     0,	daCenter,   true,	prefix+"mnr_prnr_cre_seq",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,        0,	daCenter,   true,	prefix+"prmry_chk_flg",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,	   130,	daCenter,	true,	prefix+"cnt_cd",			false,	"",	dfNone,		0,	true,	true,	2);
	
				ColHidden(prefix+"aply_flg")=true;
				
				InitDataValid(0,  prefix+"phn_no", vtNumericOther, "-");
			}
			break;
	
		}
	}
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObj = document.form
	
		with (formObj.combo_in_mnr_prnr_knd_cd) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("100");
			DropHeight = 160;
		}
	
		with (formObj.combo_in_mnr_prnr_sts_cd) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
		}
	
		with (formObj.combo_mnr_prnr_knd_cd) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
		}
	
		with (formObj.combo_mnr_prnr_knd_dtl_cd) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("90");
			DropHeight = 160;
		}
	
		with (formObj.combo_pay_mzd_cd) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("100");
			DropHeight = 160;
		}
	
		with (formObj.combo_dpt_desc) {
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
		}
	
		var sheetObj=sheetObjects[0];
		//콤보조회
		var sCondition = new Array (
				new Array("MnrGenCd"  ,"CD00034", "COMMON") //Buyer Type _MNR_PRNR_KND_CD and Buyer Type Infomation 부문 _MNR_PRNR_KND_CD2			
				,new Array("MnrGenCd" ,"CD00054", "COMMON")  //Buyer Detail Type _mnr_prnr_knd_dtl_cd
				,new Array("MnrGenCd" ,"CD00053", "COMMON")  //Buyer Status MNR_PRNR_STS_CD
				,new Array("ComIntgCd","CD00809", "COMMON")  //P.Method
				,new Array("MnrGenCd" ,"CD00070", "COMMON")	 //Deposit Info
		)
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i = 0; i < comboList.length;i++){
			//쉬트콤보별 초기화
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = ""; 
			if(comboList[i] != null){
				if(i==0)
				{
					formObj.combo_in_mnr_prnr_knd_cd.InsertItem(0, "All", " ");
				}else if (i==2) {
					formObj.combo_in_mnr_prnr_sts_cd.InsertItem(0, "All", " ");
				}
				for(var j = 0; j < comboList[i].length;j++){ 
					var tempText = comboList[i][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){	
						sheetComboDefault = tempText[0];      	
					}
					if(i==0) {
						formObj.combo_in_mnr_prnr_knd_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
						formObj.combo_mnr_prnr_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}else if (i==1) {
						formObj.combo_mnr_prnr_knd_dtl_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}else if (i==2) {
						formObj.combo_in_mnr_prnr_sts_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
					}else if (i==3) {
						formObj.combo_pay_mzd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}else if (i==4) {
						formObj.combo_dpt_desc.InsertItem(j, tempText[1], tempText[0]);
	
					}
				}
				if(i==0){
					formObj.combo_in_mnr_prnr_knd_cd.Code2=" ";
					formObj.combo_mnr_prnr_knd_cd.Code2="-1";
				}else if(i==1){
					formObj.combo_mnr_prnr_knd_dtl_cd.Code = "";
				}else if(i==2){
					formObj.combo_in_mnr_prnr_sts_cd.Code = " ";
				}else if(i==3){
					formObj.combo_pay_mzd_cd.Index = 1;
				}else if(i==4){
					formObj.combo_dpt_desc.Code2="-1";
				}
	
				//쉬트 콤보 설정
				if(i == 0) {
					sheetObjects[0].InitDataCombo(0, "sheet1_mnr_prnr_knd_cd", sheetComboText, sheetComboCode, sheetComboDefault);
				}
			}
		}
	}
	
	function combo_mnr_prnr_knd_cd_OnChange(indexCode, Text){
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
		formObj.mnr_prnr_knd_cd.value=formObj.combo_mnr_prnr_knd_cd.Code;
	
	}
	
	function combo_mnr_prnr_knd_dtl_cd_OnChange(indexCode, Text){
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
		formObj.mnr_prnr_knd_dtl_cd.value=formObj.combo_mnr_prnr_knd_dtl_cd.Code;
	
	}
	
	function combo_pay_mzd_cd_OnChange(indexCode, Text){
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
		if(sheetObj.RowCount >0)
		{
			formObj.pay_mzd_cd.value=formObj.combo_pay_mzd_cd.Code;
		}
	}
	
	function combo_dpt_desc_OnChange(indexCode, Text){
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
		formObj.dpt_desc.value=formObj.combo_dpt_desc.Code;
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			clearFormObjectValues();
			//콤보 초기화  
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].Code = "-1";  
				comboObjects[i].RemoveAll(); 	
			}  
			initCombo();
			formObj.ctrl_ofc_cd.value=currOfcCd;
			formObj.combo_pay_mzd_cd.Index = 1;
			formObj.pay_term_dys.value = "0";
			formObj.tocal.value = ComGetNowInfo();
			formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
			formObj.cre_dt.value =ComGetNowInfo();
			ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
			formObj.mnr_prnr_lgl_eng_nm.className="input1";
			formObj.combo_mnr_prnr_knd_cd.Code2 = "-1";
			ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
			MnrWaitControl(false);        
			break;
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction))return;
			nowLoad = 1;
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			//sheetObjects[0].getStatus
			formObj.f_cmd.value = SEARCH; 
			formObj.in_mnr_prnr_knd_cd.value=formObj.combo_in_mnr_prnr_knd_cd.Code;
			formObj.in_mnr_prnr_sts_cd.value=formObj.combo_in_mnr_prnr_sts_cd.Code;
			formObj.ctrl_ofc_cd.value=""; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
			formObj.mnr_prnr_tp_cd.value=""; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
			formObj.mnr_prnr_cnt_cd.value=""; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
			formObj.mnr_prnr_seq.value=""; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
			formObj.sp_ptal_id.value=""; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
			var sParam = "";
			var aryPrefix = new Array("sheet1_", "sheet2_");
	
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0155GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
			for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
	
				sheetObjects[i].Redraw = false;
				sheetObjects[i].WaitImageVisible = false;
	
				sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
				sheetObjects[i].Redraw = true;
			}   		 	   
			break;

		case COMMAND02:      //DTL만 조회
			nowLoad = 1;
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value = SEARCH; 
			var aryPrefix = new Array("sheet1_", "sheet2_");
			var sParam = "";
				sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0155GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
			for ( var i = 1; i < arrDataSearchDbXml.length; i++) {
				sheetObjects[1].Redraw = false;
				sheetObjects[1].WaitImageVisible = false;
	
				sheetObjects[1].LoadSearchXml(arrDataSearchDbXml[i]);
				sheetObjects[1].Redraw = true;
			}   	
			break;
	
		case IBSAVE:        //저장
			if(nowLoad != 0) return;
			if(!validateForm(sheetObj,formObj,sAction))return;
			nowLoad=1;
			formObj.f_cmd.value = MULTI;
			if(sheetObj.RowCount>0)
			{
				saveTextIndex=formObj.mnr_prnr_cre_seq.value;
			}else{
				saveTextIndex="";
			}
	
			if(formObj.mnr_prnr_sts_cd.value=="C")
			{  
				MnrPrnrStsCode="C";
			}else{
				formObj.mnr_prnr_sts_cd.value=MnrPrnrStsCode;
			}
	
			var aryPrefix = new Array("sheet1_", "sheet2_");
			var sParam1 = ComGetSaveString(sheetObjects, true, true);
			var sParam = FormQueryString(formObj) + "&" + sParam1 + "&" + FormQueryString(formObj)+ "&" 
			+ ComGetPrefixParam(aryPrefix);
			//ComDebug(sParam);
			/*
			var formObj  = document.form;
			if(formObj.delt_flg_Ctr.checked == true){
				formObj.delt_flg.value  ="Y";
			} else {
				formObj.delt_flg.value  ="N";
			}
			*/
			var sXml = sheetObj.GetSaveXml("EES_MNR_0155GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);
			break;

		case REMOVE:        //삭제
			if(nowLoad != 0) return;
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_cmd.value = REMOVE;
			var aryPrefix = new Array("sheet1_", "sheet2_");
			var sParam1 = ComGetSaveString(sheetObjects, true, true);
			if (sParam1 == "")
			{
				MnrWaitControl(false);
				return false;
			}
	
			var sParam =FormQueryString(formObj) + "&"+ sParam1 + "&"
						+ ComGetPrefixParam(aryPrefix);
			var sXml = sheetObj.GetSaveXml("EES_MNR_0155GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);
		break;

		//행추가
		case IBINSERT:
			if(!validateForm(sheetObj,formObj,sAction))return;
			var Row = sheetObj.DataInsert(-1); 
			sheetObj.CellValue2(Row, "sheet2_aply_flg")	= "1";	//Apply
			if(sheetObjects[0].RowCount >0)
			{
				sheetObj.CellValue2(Row, "sheet2_mnr_prnr_cre_seq")	=  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_mnr_prnr_cre_seq");
			}
			sheetObj.CellValue2(Row, "sheet2_ofc_cd")	= currOfcCd;
			sheetObj.CellValue2(Row, "sheet2_mnr_cntc_prnr_nm")	= formObj.mnr_prnr_cnt_nm.value;
			sheetObj.CellValue2(Row, "sheet2_prmry_chk_flg")	="N";
			sheetObj.CellValue2(Row, "sheet2_cnt_cd")="";
			//set Focus 
			sheetObj.SelectCell(Row, "sheet2_ofc_cd");
			break;
			//행삭제
		case IBDELETE:
			if(validateForm(sheetObj,formObj,sAction)) {
				ComRowHideDelete(sheetObj, "del_chk");
			}    
			break;	

		}
	}
	
	function setCustomerName(){
		MnrWaitControl(true);
		nowLoad=1;
		sheetObj=sheetObjects[0];
		sheetObj.Enable=false;
		var Row = sheetObj.SelectRow
		var formObj=document.form;
		var CustCd=ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
		var CustSeq=ComTrimAll(formObj.mnr_prnr_seq.value," ");
		if(CustCd =="" || CustSeq =="" )
		{
			nowLoad=0;
	
			sheetObjects[0].Enable=true;
			MnrWaitControl(false);
			return;
	
		}
		var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],CustCd,CustSeq);
		var arrResult = MnrXmlToArray(sXml);	
		if(arrResult != null){	 	     
			for(var i = 0; i < arrResult.length;i ++){
				formObj.mnr_prnr_seq.value=ComLpad(formObj.mnr_prnr_seq, 6, "0");
				formObj.mnr_prnr_cnt_nm.value  =arrResult[i][10];
				formObj.mnr_prnr_cnt_nm.title=arrResult[i][10];
	
				break;                                       
			}	
		}else{
			ComShowCodeMessage("MNR00121"); // 'Please connect Customer Code'
			formObj.mnr_prnr_cnt_cd.value="";
			formObj.mnr_prnr_seq.value="";
			formObj.mnr_prnr_cnt_nm.value  ="";
			formObj.mnr_prnr_cnt_nm.title ="";
			ComSetFocus(formObj.mnr_prnr_cnt_cd);
	
		}
		sheetObjects[0].Enable=true;
		MnrWaitControl(false);
		nowLoad=0;
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//추가시
			if(sAction==IBINSERT)
			{
				if(sheetObj.CellValue(1, "Seq")=="0" )
				{
					sheetObj.RemoveAll();
				}
	
				if(sheetObjects[1].CellValue(1, "Seq")=="0")
				{
					sheetObjects[1].RemoveAll();
				}
				var checkValue =ComTrimAll(formObj.mnr_prnr_lgl_eng_nm.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
					return false;  
				}
	
				var checkValue =ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					return false;  
				}
	
				var checkValue =ComTrimAll(formObj.mnr_prnr_seq.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_seq);
					return false;  
				}
				
				// Customer 셋팅(obj_change 이벤트가 skip 되는 경우가 있으므로 여기서 한번더 셋팅)
				setCustomerName();
				
				var checkValue =ComTrimAll(formObj.combo_mnr_prnr_knd_cd.Code," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.combo_mnr_prnr_knd_cd2);
					return false;  
				}
				
				var checkValue =ComTrimAll(formObj.combo_mnr_prnr_knd_dtl_cd.Code," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.combo_mnr_prnr_knd_dtl_cd);
					return false;  
				}
	
				for(var i=sheetObjects[1].HeaderRows ;i<=sheetObjects[1].LastRow;i++)
				{
					//2. 해당 Office 빈값일 경우
					var strCostDtlCD =ComTrimAll(sheetObjects[1].CellValue(i, "sheet2_ofc_cd")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Office");
						sheetObjects[1].SelectCell(i, "sheet2_ofc_cd",true);
						return false; 
					}
	
					//2. 해당 BuyerName 빈값일 경우
					var strCostDtlCD =ComTrimAll(sheetObjects[1].CellValue(i, "sheet2_mnr_cntc_prnr_nm")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Name");
						sheetObjects[1].SelectCell(i, "sheet2_mnr_cntc_prnr_nm",true);
						return false; 
					}
				}
			}		
			//조회시
			else if(sAction==IBSEARCH)
			{
				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
				if(sRow != "") // sheet 수정내용 있음
				{                               	
					if(!ComShowCodeConfirm("MNR00007"))
					{
						nowLoad=0;
						return false;
					}
				}
	
			}
			//저장(확정)시
			else if(sAction==IBSAVE) {
				
				// Customer 셋팅(obj_change 이벤트가 skip 되는 경우가 있으므로 여기서 한번더 셋팅)
				if(formObj.mnr_prnr_cnt_cd.value != "" || formObj.mnr_prnr_seq.value != ""){
					setCustomerName();
				}				
				
				//P.I.C Email '@' 체크
				var vMnrPrnrEmlCheck =ComTrimAll(formObj.mnr_prnr_eml.value," ").indexOf("@");
				if( vMnrPrnrEmlCheck == -1){
					ComShowCodeMessage("MNR00165", "\'@\'");
					ComSetFocus(formObj.mnr_prnr_eml);
					return false;
				}
				
				//Control Office & Buyer Contact Info - Buyer Email '@' 체크
				for(var i=sheetObjects[1].HeaderRows ; i<=sheetObjects[1].LastRow ; i++)
				{
					if( sheetObjects[1].FindText("sheet2_mnr_prnr_eml", "@", i, 2) == -1){
						ComShowCodeMessage("MNR00165", "\'@\'");
						sheetObjects[1].SelectCell(i, "sheet2_mnr_prnr_eml", true);
						return false;
					}
				}
				
				nowLoad=1;
				var sheetObj=sheetObjects[0];
	
				if(sheetObj.RowCount ==1)
				{
					if(sheetObj.CellValue(1, "Seq")=="0" )
					{
						sheetObj.RemoveAll();
					}
				}
				var checkValue =ComTrimAll(formObj.mnr_prnr_lgl_eng_nm.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
					return false;  
	
				}
	
				var checkValue =ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					return false;  
	
				}
	
				var checkValue =ComTrimAll(formObj.mnr_prnr_seq.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_seq);
					return false;  
	
				}
				var checkValue =ComTrimAll(formObj.combo_mnr_prnr_knd_cd.Code," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.combo_mnr_prnr_knd_cd2);
					return false;  
	
				}
				var checkValue =ComTrimAll(formObj.combo_mnr_prnr_knd_dtl_cd.Code," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.combo_mnr_prnr_knd_dtl_cd);
					return false;  
	
				}
	
				//Pay Term이 빈값시 기본값으로 0셋팅
				var checkValue =ComTrimAll(formObj.pay_term_dys.value," ");
				if(checkValue=="")
				{
					formObj.pay_term_dys.value="0";
				}
					
				if(!sheet1_mnr_prnr_seq_UniqueCheck(sheetObj,formObj))
				{
					nowLoad=0;
					formObj.mnr_prnr_cnt_cd.value="";
					formObj.mnr_prnr_seq.value="";
					formObj.mnr_prnr_cnt_nm.value  ="";
					formObj.mnr_prnr_cnt_nm.title ="";
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					ComShowCodeMessage("MNR00006","Customer."); // '{?msg1} is duplicated.'
					ComSetFocus(formObj.mnr_prnr_cnt_cd);	
					return false; 
				}
				
				if(!sheet1_sp_ptal_id_UniqueCheck(sheetObj,formObj) && formObj.sp_ptal_id.value !="" )
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00006","[SPP ID]");
					return false; 
				}
				
				var sheetObj=sheetObjects[1];
				if(sheetObj.CellValue(1, "Seq")=="0")
				{
					sheetObj.RemoveAll();
				}
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
				{
					//1. 해당 Office 빈값일 경우
					var strCostDtlCD =ComTrimAll(sheetObj.CellValue(i, "sheet2_ofc_cd")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Office");
						sheetObj.SelectCell(i, "sheet2_ofc_cd",true);
						return false; 
					}
	
					//2. 해당 BuyerName 빈값일 경우
					var strCostDtlCD =ComTrimAll(sheetObj.CellValue(i, "sheet2_mnr_cntc_prnr_nm")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Name");
						sheetObj.SelectCell(i, "sheet2_mnr_cntc_prnr_nm",true);
						return false; 
					}
				}
	
				//3.Control Office 중복체크
				var Row = sheetObjects[1].ColValueDup("sheet2_ofc_cd",false);
				if(sheetObjects[1].IsDataModified){ 
					if(Row>0){ 
						nowLoad=0;
						ComShowCodeMessage("MNR00006","CTRL Office of " + (Row) + " row");
						sheetObjects[1].SelectCell(Row, "sheet2_ofc_cd", true);  
						return false;	
					} 	 	
				}	 
				
				var rowCnt = sheetObjects[1].RowCount("R")+sheetObjects[1].RowCount("I")+sheetObjects[1].RowCount("U");
				if(rowCnt < 1)
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00348");
					return false;
				}
				
				nowLoad=0;
				return true;	
			}
	
	
			//삭제시
			else if (sAction==REMOVE) {
				//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
				if(sheetObj.FindCheckedRow("sheet1_checkbox") == ""){ 
					nowLoad=0;
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
				var findRow= sheetObj.FindText("sheet1_mnr_prnr_cre_seq", formObj.mnr_prnr_cre_seq.value, 0);
				if(sheetObj.CellValue(findRow,"sheet1_disp_cnt") != "0"){ 
					nowLoad=0;
					ComShowCodeMessage("MNR00320");
					return false;             	   
				}
	
				if(!ComShowCodeConfirm("MNR00026"))
				{
					nowLoad=0;
					return false;
				}
			}		
			//복사시
			else if (sAction=="COPY") {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {nowLoad=0;return false;}
			}
			//행 삭제시
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){ 
					nowLoad=0;
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
			//행 복사시
			else if (sAction==IBCOPYROW) {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//Tariff상태값 체크
				if(!checkTariffStatus()) {return false;}
			}
		}
		return true;
	}
	
	function clearFormObjectValues(){
		var formObj = document.form;
		formObj.mnr_prnr_cre_seq.value  		 ="";
		formObj.mnr_prnr_lgl_eng_nm.value  		 =""; 
		formObj.mnr_prnr_lgl_eng_nm.title ="";
		formObj.mnr_prnr_cnt_cd.value   =""; 
		formObj.mnr_prnr_cnt_nm.title =""
		formObj.mnr_prnr_seq.value   =""; 
		formObj.mnr_prnr_cnt_nm.value   =""; 
		formObj.mnr_prnr_knd_cd.value   =""; 
		formObj.combo_mnr_prnr_knd_cd.Code2   =""; 
		formObj.mnr_prnr_knd_dtl_cd.value   =""; 
		formObj.combo_mnr_prnr_knd_dtl_cd.Code2   =""; 
		formObj.mnr_shop_flg.checked=false;
		formObj.delt_flg.checked=false;
		formObj.mnr_prnr_sts_cd.value   =""; 
		formObj.mnr_prnr_sts_nm.value   =""; 
		formObj.bzct_nm.value   =""; 
		formObj.bztp_nm.value   =""; 
		formObj.empe_knt.value   =""; 
		formObj.ownr_nm.value   =""; 
		formObj.biz_rgst_no.value   =""; 
		formObj.zip_cd.value   =""; 
		formObj.phn_no.value   =""; 
		formObj.fax_no.value   =""; 
		formObj.mnr_prnr_eml.value   =""; 
		formObj.mnr_bil_to_nm.value   =""; 
		formObj.mnr_prnr_addr.value   =""; 
		formObj.sp_ptal_id.value   =""; 
		formObj.sp_ptal_pwd.value   =""; 
		formObj.eff_dt.value   =""; 
		formObj.exp_dt.value   =""; 
		formObj.bank_nm.value   =""; 
		formObj.bank_acct_no.value   =""; 
		formObj.pay_term_dys.value   ="0"; 
		formObj.combo_pay_mzd_cd.Code2   ="CHK"; 
		formObj.pay_mzd_cd.value   =""; 
		formObj.mnr_prnr_rmk.value  =""; 
		formObj.combo_dpt_desc.Code2  =" "; 
		formObj.dpt_desc.value  =""; 			
		formObj.mnr_swift_no.value =""; 
		formObj.upd_dt.value  ="";
		formObj.ctrl_ofc_cd.value   ="";
		formObj.mnr_prnr_tp_cd.value   ="";
		formObj.edi_id.value    ="";
		formObj.mnr_prnr_locl_lang_nm.value    ="";
		formObj.bzet_addr.value   ="";
		formObj.mnr_payr_cnt_cd.value    ="";
		formObj.mnr_payr_seq.value    ="";
		formObj.mnr_prnr_capi_amt.value    ="";
		formObj.mnr_prnr_abbr_nm.value    ="";
		formObj.intl_phn_no.value    ="";
		formObj.intl_fax_no.value    ="";
		formObj.trsm_mod_cd.value   ="";
		formObj.file_seq.value   ="";
	}		
		
	function setFormObjectValues(NewRow){
		if(nowLoad != 0) return;
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
	
		if(sheetObj.RowCount<=0) return;
		formObj.mnr_prnr_cre_seq.value  		 =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_cre_seq");
		formObj.mnr_prnr_lgl_eng_nm.value  		 =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_lgl_eng_nm");
		formObj.mnr_prnr_lgl_eng_nm.title=sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_lgl_eng_nm");
		formObj.mnr_prnr_cnt_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_cnt_cd");
		formObj.mnr_prnr_seq.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_seq");
		formObj.mnr_prnr_cnt_nm.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_cnt_nm");
		formObj.mnr_prnr_cnt_nm.title=sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_cnt_nm");
		formObj.mnr_prnr_knd_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_knd_cd");
		formObj.combo_mnr_prnr_knd_cd.Code2  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_knd_cd");
		formObj.mnr_prnr_knd_dtl_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_knd_dtl_cd");
		formObj.combo_mnr_prnr_knd_dtl_cd.Code2  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_knd_dtl_cd");
	
		if(sheetObj.CellValue(NewRow,"sheet1_mnr_shop_flg")=="Y")
			formObj.mnr_shop_flg.checked=true;
		else if(sheetObj.CellValue(NewRow,"sheet1_mnr_shop_flg")=="N")
			formObj.mnr_shop_flg.checked=false;
		else
			formObj.mnr_shop_flg.checked=false;
			
		if(sheetObj.CellValue(NewRow,"sheet1_delt_flg")=="Y") {
			formObj.delt_flg.checked=true;
		} else if(sheetObj.CellValue(NewRow,"sheet1_delt_flg")=="N") {
			formObj.delt_flg.checked=false;
		}
		
		
			
	
		formObj.mnr_prnr_sts_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_sts_cd");
		formObj.mnr_prnr_sts_nm.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_sts_nm");
		formObj.bzct_nm.value  =sheetObj.CellValue(NewRow,"sheet1_bzct_nm");
		formObj.bztp_nm.value  =sheetObj.CellValue(NewRow,"sheet1_bztp_nm");
		formObj.empe_knt.value  =sheetObj.CellValue(NewRow,"sheet1_empe_knt");
		formObj.ownr_nm.value  =sheetObj.CellValue(NewRow,"sheet1_ownr_nm");
		formObj.biz_rgst_no.value  =sheetObj.CellValue(NewRow,"sheet1_biz_rgst_no");
		formObj.zip_cd.value  =sheetObj.CellValue(NewRow,"sheet1_zip_cd");
		formObj.phn_no.value  =sheetObj.CellValue(NewRow,"sheet1_phn_no");
		formObj.fax_no.value  =sheetObj.CellValue(NewRow,"sheet1_fax_no");
		formObj.mnr_prnr_eml.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_eml");
		formObj.mnr_bil_to_nm.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_bil_to_nm");
		formObj.mnr_prnr_addr.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_addr");
		formObj.sp_ptal_id.value  =sheetObj.CellValue(NewRow,"sheet1_sp_ptal_id");
		formObj.sp_ptal_pwd.value  =sheetObj.CellValue(NewRow,"sheet1_sp_ptal_pwd");
		formObj.eff_dt.value  =sheetObj.CellValue(NewRow,"sheet1_eff_dt");
		formObj.exp_dt.value  =sheetObj.CellValue(NewRow,"sheet1_exp_dt");
		formObj.bank_nm.value  =sheetObj.CellValue(NewRow,"sheet1_bank_nm");
		formObj.bank_acct_no.value  =sheetObj.CellValue(NewRow,"sheet1_bank_acct_no");
		if(sheetObj.CellValue(NewRow,"sheet1_pay_term_dys")=="")
		{	
			formObj.pay_term_dys.value = "0"; 
		}else{
			formObj.pay_term_dys.value = sheetObj.CellValue(NewRow,"sheet1_pay_term_dys");
		}
	
		formObj.pay_mzd_cd.value  =sheetObj.CellValue(NewRow,"sheet1_pay_mzd_cd");
		formObj.combo_pay_mzd_cd.Code2  =sheetObj.CellValue(NewRow,"sheet1_pay_mzd_cd");
	
		formObj.mnr_prnr_rmk.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_rmk");
		formObj.dpt_desc.value  =sheetObj.CellValue(NewRow,"sheet1_dpt_desc");
		formObj.combo_dpt_desc.Code2  =sheetObj.CellValue(NewRow,"sheet1_dpt_desc");
		formObj.mnr_swift_no.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_swift_no");
	
		formObj.upd_dt.value  =sheetObj.CellValue(NewRow,"sheet1_upd_dt");	
		formObj.ctrl_ofc_cd.value  =sheetObj.CellValue(NewRow,"sheet1_ctrl_ofc_cd");	
		formObj.mnr_prnr_tp_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_tp_cd");
		formObj.edi_id.value  =sheetObj.CellValue(NewRow,"sheet1_edi_id");
		formObj.mnr_prnr_locl_lang_nm.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_locl_lang_nm");
		formObj.bzet_addr.value  =sheetObj.CellValue(NewRow,"sheet1_bzet_addr");
		formObj.mnr_payr_cnt_cd.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_payr_cnt_cd");
		formObj.mnr_payr_seq.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_payr_seq");	
		formObj.mnr_prnr_capi_amt.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_capi_amt");
		formObj.mnr_prnr_abbr_nm.value  =sheetObj.CellValue(NewRow,"sheet1_mnr_prnr_abbr_nm");
		formObj.intl_phn_no.value  =sheetObj.CellValue(NewRow,"sheet1_intl_phn_no");
		formObj.intl_fax_no.value  =sheetObj.CellValue(NewRow,"sheet1_intl_fax_no");
		formObj.trsm_mod_cd.value  =sheetObj.CellValue(NewRow,"sheet1_trsm_mod_cd");
		formObj.file_seq.value  =sheetObj.CellValue(NewRow,"sheet1_file_seq");
		
		if(sheetObj.CellValue(NewRow,"sheet1_delt_flg")=="1") {
			formObj.delt_flg.checked=true;
		} else if(sheetObj.CellValue(NewRow,"sheet1_delt_flg")=="0"){
			formObj.delt_flg.checked=false;
		}
		//alert(sheetObj.CellValue(NewRow,"sheet1_delt_flg"));
	    
		nowLoad=0; 
			 					
		//박명신 권한 설정 2010-02-25 	
		//A	
		if(sheetObj.CellValue(NewRow,"sheet1_btn_flg") == "A"){ 
			ComBtnEnable("btn_retrieve"); 			    
			ComBtnEnable("btn_new");  	
			ComBtnEnable("btn_save"); 
			ComBtnEnable("btn_remove"); 			
			ComBtnEnable("btn_reject"); 			
			ComBtnEnable("btn_confirm");	 
			ComBtnEnable("btn_expire");	
		//B
		} else if(sheetObj.CellValue(NewRow,"sheet1_btn_flg") == "B"){
			ComBtnEnable("btn_retrieve");			    
			ComBtnEnable("btn_new");  	
			ComBtnEnable("btn_save"); 
			ComBtnDisable("btn_remove"); 			
			ComBtnDisable("btn_reject"); 			
			ComBtnDisable("btn_confirm");	 
			ComBtnDisable("btn_expire");
		//C			  
		} else {
			ComBtnEnable("btn_retrieve");			    
			ComBtnEnable("btn_new");  	
			ComBtnDisable("btn_save"); 
			ComBtnDisable("btn_remove"); 			
			ComBtnDisable("btn_reject"); 			
			ComBtnDisable("btn_confirm");	 
			ComBtnDisable("btn_expire");
		}	 
	}	
	
	function setRowCreDtChange(){
		var formObj = document.form;
		var Row = sheetObjects[0].SelectRow;
		formObj.cre_dt.value=sheetObjects[0].CellValue(Row,"sheet1_cre_dt");
	}
	
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
		if(nowLoad==1)return;
		var formObj = document.form;
	
		var sRow = sheetObjects[1].FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
		if(sRow != "") // sheet 수정내용 있음
		{                               	
			if(!ComShowCodeConfirm("MNR00007"))
			{
	
				sheetObj.SelectCell(OldRow,OldCol,false);
				sheetObj.Enable=false;
				return false;
			}
		}
				
		sheetObj.Enable=false;
			
		setFormObjectValues(Row);
		formObj.f_gubuns.value="DTL";
	
		formObj.mnr_prnr_cre_seq.value=sheetObjects[0].CellValue(Row,"sheet1_mnr_prnr_cre_seq");
		doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
	
	}	
	/*
	function delt_flg_Ctr_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		var strDeltFlg = sheetObj.CellValue(Row, "sheet1_delt_flg");
		
		
		alert(111111);
		
		if(sheetObj.ColSaveName(Col) == "sheet1_delt_flg"){
			if(strDeltFlg=="0"){
				sheetObj.CellValue2(Row, "sheet1_delt_flg") = "1";
				formObj.delt_flg.value  ="1";
			} else if(strDeltFlg=="1"){
				sheetObj.CellValue2(Row, "sheet1_delt_flg") = "0";
				formObj.delt_flg.value  ="0";
			}
		}
	}
	*/
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		if(sheetObjects[0].RowCount <= 0)
		{
			ComShowCodeMessage("MNR00005", "Disposal Partner");  
			ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
			ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
			formObj.mnr_prnr_lgl_eng_nm.className="input1";
			sheetObjects[0].RemoveAll();
			clearFormObjectValues();
		} else {
			nowLoad = 0;
			var orgIbflag=sheetObj.CellValue(1,"sheet1_ibflag");
			sheetObj.CellValue2(1,"sheet1_checkbox")="1";
			sheetObj.CellValue2(1,"sheet1_ibflag")=orgIbflag;
			setFormObjectValues(1);		
			ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,false);
			formObj.mnr_prnr_lgl_eng_nm.className="input2";
		}
			
		var Row = sheetObj.FindText("sheet1_mnr_prnr_cre_seq", saveTextIndex);
		if(Row > 0)
		{
			sheetObj.SelectRow=Row;
			sheetObj.CellValue2(Row,"sheet1_checkbox")="1";
			sheetObj.CellValue2(Row,"sheet1_ibflag")="R";
			setFormObjectValues(Row);
			formObj.f_gubuns.value="DTL";
			formObj.mnr_prnr_cre_seq.value=sheetObjects[0].CellValue(Row,"sheet1_mnr_prnr_cre_seq");
			doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
		}
		nowLoad = 0;
		sheetObj.Enable=true;
	}
	
	function sheet1_OnChange(sheetObj,Row, Col, Value)
	{
		if(nowLoad == 0)
		{
			if(sheetObj.ColSaveName(Col) == "sheet1_cre_dt")
			{
				var formObj = document.form;
				formObj.cre_dt.value=Value;
			}
		}
	} 
	
	function sheet2_OnChange(sheetObj,Row, Col, Value)
	{
		if(nowLoad == 0)
		{
			if(sheetObj.ColSaveName(Col) == "sheet2_ofc_cd")
			{
				//ofc_cd 존재여부 체크    
				var retArray =  null;        
				if (Value!="")
				{
					retArray = MnrGeneralCodeCheck(sheetObj,"OFC",Value);      
					if(retArray == null)
					{           
						ComShowCodeMessage("MNR00165",Value);  
						sheetObj.CellValue2(Row,Col)="";
						sheetObj.SelectCell(Row,Col,true);
					}   
				}
			}
		}
	} 
	
	function sheet2_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet2_";
		if(sheetObjects[0].RowCount <=0)
		{
			ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
			ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
			formObj.mnr_prnr_lgl_eng_nm.className="input1";
			sheetObjects[1].RemoveAll();	
		}
		formObj.f_gubuns.value="";
		nowLoad = 0;
		sheetObjects[0].Enable=true;
	}	
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
				if(MnrPrnrStsCode=="S")
					ComShowCodeMessage("MNR00122");
				else if(MnrPrnrStsCode=="J")
					ComShowCodeMessage("MNR00267"); //reject
				else if(MnrPrnrStsCode=="C")
					ComShowCodeMessage("MNR00124");
				else if(MnrPrnrStsCode=="X")
					ComShowCodeMessage("MNR00269"); //expire
	
			} else { 
				if(MnrPrnrStsCode=="S")
					ComShowCodeMessage("MNR00008",ErrMsg);
				else if(MnrPrnrStsCode=="J")
					ComShowCodeMessage("MNR00268",ErrMsg); //reject
				else if(MnrPrnrStsCode=="C")
					ComShowCodeMessage("MNR00025",ErrMsg);
				else if(MnrPrnrStsCode=="X")
					ComShowCodeMessage("MNR00270",ErrMsg); //expire
			}
		}
		else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "") { 
				ComShowCodeMessage("MNR00127");
			} else { 	
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}	
		MnrPrnrStsCode=""; 
		nowLoad = 0;
		MnrWaitControl(false);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}	 
	
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != "sheet1_cre_dt")
		{
			return;
		}
		var cal = new ComCalendarGrid();     
		cal.setEndFunction("setRowCreDtChange");
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd'); 
	}  
	/**
	 * 그리드 고객 코드(Customer Code) 입력값에 대한 고유성검증 프로세스 처리
	 */
	function sheet1_mnr_prnr_seq_UniqueCheck(sheetObj,formObj){
		var mnr_prnr_cnt_cd=formObj.mnr_prnr_cnt_cd.value; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
		var mnr_prnr_seq=formObj.mnr_prnr_seq.value; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
		var sParam = "";
		var aryPrefix = new Array("sheet1_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + "f_cmd="+SEARCH+"&f_gubuns=EXIST&mnr_grp_tp_cd=DSP&mnr_prnr_cnt_cd="+ mnr_prnr_cnt_cd + "&mnr_prnr_seq="+mnr_prnr_seq;
	
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0155GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
		var Slength=arrDataSearchDbXml[0].indexOf("TOTAL='");
		var intSize=arrDataSearchDbXml[0].substring(Slength + 7,Slength + 8);
		if(intSize>0 )
		{
			var retValue = MnrXml2ComboString(sXml, "sheet1_mnr_prnr_cre_seq", "sheet1_vndr_seq");    
			if (retValue != null)
			{
				if(retValue[0].split("|")[0]!=formObj.mnr_prnr_cre_seq.value)
				{
					return false;
				}
			}
		}
	
		if(intSize>1 )
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 그리드 고객 코드(SPP ID) 입력값에 대한 고유성검증 프로세스 처리
	 */
	function sheet1_sp_ptal_id_UniqueCheck(sheetObj,formObj){
		var sp_ptal_id=formObj.sp_ptal_id.value; //순수 리스트 조회시 빈값으로 반드시 넘겨야 함
		if(sp_ptal_id=="")return true;
		var sParam = "";
		var aryPrefix = new Array("sheet1_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + "f_cmd="+SEARCH+"&f_gubuns=EXIST&mnr_grp_tp_cd=DSP&sp_ptal_id="+ sp_ptal_id;
	
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0155GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
		var Slength=arrDataSearchDbXml[0].indexOf("TOTAL='");
		var intSize=arrDataSearchDbXml[0].substring(Slength + 7,Slength + 8);
		if(intSize>0 )
		{
			var retValue = MnrXml2ComboString(sXml, "sheet1_mnr_prnr_cre_seq", "sheet1_vndr_seq");    
			if (retValue != null) {
				if(retValue[0].split("|")[0]!=formObj.mnr_prnr_cre_seq.value)
				{
					return false;
				}
			}
		}
		if(intSize>1 )
		{
			return false;
		}
		return true;
	}
	
	function setPopUpParam_cre_ofc(array) {
	
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
		formObj.cre_ofc_cd.value=arr[3];
		formObj.cre_ofc_nm.value=arr[4];

	}
	
	function setPopUpParam_ctrl_ofc(array) {
	
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
		formObj.param_ctrl_ofc_cd.value=arr[3];
		formObj.param_ctrl_ofc_nm.value=arr[4];

	}
	
	function cre_ofc_cd_Check(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.cre_ofc_cd.value," ")!="")
		{
			var retArray=null;
			retArray = MnrGeneralCodeCheck(sheetObj,"OFC",formObj.cre_ofc_cd.value);  
			if(retArray == null){           
				ComShowCodeMessage("MNR00165",formObj.cre_ofc_cd.value,"OFFICE"); 
				formObj.cre_ofc_cd.value="";
				formObj.cre_ofc_nm.value="";
				ComSetFocus(formObj.cre_ofc_cd);
				return false;
			} else {	  
				var retArray=retArray[0].split("|");
				formObj.cre_ofc_cd.value=retArray[0];
				formObj.cre_ofc_nm.value=retArray[1];
			}
		}
		return true;
	}
	
	function ctrl_ofc_cd_Check(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.param_ctrl_ofc_cd.value," ")!="")
		{
			var retArray=null;
			retArray = MnrGeneralCodeCheck(sheetObj,"OFC",formObj.param_ctrl_ofc_cd.value);  
			if(retArray == null){           
				ComShowCodeMessage("MNR00165",formObj.param_ctrl_ofc_cd.value,"OFFICE"); 
				formObj.param_ctrl_ofc_cd.value="";
				formObj.param_ctrl_ofc_nm.value="";
				ComSetFocus(formObj.param_ctrl_ofc_nm);
				return false;
			} else {	  
				var retArray=retArray[0].split("|");
				formObj.param_ctrl_ofc_cd.value=retArray[0];
				formObj.param_ctrl_ofc_nm.value=retArray[1];
			}
		}
		return true;
	}