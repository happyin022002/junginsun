/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0079_06.js
 *@FileTitle : Marks & Number/Description of Goods
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.01
 *@LastModifier : 최 선
 *@LastVersion : 1.3
 * 2009.04.28 김영출
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2010.09.13 이일민 1.1 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2010.10.20 이일민 1.2 [CHM-201006496-01] M&D No of PKG/CNTR Copy의 버그 수정 요청
 * 2010.12.01 최 선     1.3 [CHM-201007417] PO & Other No (General) Incoterms Column Add, Validation
 * 2011.03.23 이일민 [CHM-201109452] Missing link to open Attachment screen
 * 2011.05.17 최도순 [CHM-201110713-01] 미주 T&E,IE화물구분표시 및 관련정보 조회기능 개발(*PKGSC로 미주업무 이행관련)
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.10.15 김기택 [CHM-201218571-01] [BKG] C/A 항목 추가 요청
 * 2015.04.27 양동훈 [CHM-201535466] - 도착지가 중국(CN)인 BKG에 대해서 조회 시에 M&D의 Customs Description 항목이 Descrption of goods항목에 표기되어 있지 않으면 메세지 alert출력. 
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
     * @class esm_bkg_0079_06 : esm_bkg_0079_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079_06() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var wgt_ut_idx = 0;
	var meas_ut_idx = 0;
	var frt_term_idx = 0;
	var scrnAuth = '';
	var descFlag = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display = "none";
        		}    	    			
    		}
			
			switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				
				case "btn_copy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
				break;

				case "btn_t8Retrieve":
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
				break;

				case "btn_t8New":
					formObject.reset();
					formObject.bkg_no.value = '';
				break;

				case "btn_t8Save":
				    
				//P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회	
				poExistFn();						
				
				//M&D의 Customs Description 문구가 Descrption of goods body에 포함되어 있지 않은 경우 warning popup
				if(compareDescriptionToBody()==false){
					ComShowMessage(ComGetMsg("BKG95085"));					
				}
				//reefer cargo 일때 메시지로 확인 사항 체크
				if(document.form.rc_flg.value == 'Y' && document.form.dg_cmdt_desc.value != ''){	 
					if (!ComShowConfirm(ComGetMsg("BKG08258"))){
						return false; 
					}else{
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					}
				}else{
					doActionIBSheet(sheetObject2, formObject, IBSAVE);
				}
				break;

				case "btn_t8CopyfromDG":
					doActionIBSheet(sheetObject2, formObject, SEARCH02);
				break;

				case "btn_t8CopyfromCM":
					//alert("btn_t8CopyfromCM -> ESM_BKG_0707");
					//ComOpenWindow("ESM_BKG_0707.do", "ESM_BKG_0707", "width=500,height=290", false);
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0707.do?func=callbackCmdtDesc&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0707", 540, 400, true);
				break;

				case "btn_t8CopyfromHouseBL":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0360.do?func=callbackCopyFromHBL&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0360", 700, 420, true);
				break;

				case "btn_t8BLRider":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0369.do?bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0369", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
				break;
/*
				case "btn_t8NVOHouseBL":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0366.do?pgmNo=ESM_BKG_0366&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0366", 1014, 640, false);
				break;
*/
				case "find_tmplt_t":
					var bkg_no = formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=T&rtn=ttl_pck_desc&bkg_no="+bkg_no, "MnD Template", 600, 390, true);
				break;

				case "find_tmplt_m":
					var bkg_no = formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=M&rtn=mk_desc&bkg_no="+bkg_no, "MnD Template", 600, 390, true);
				break;

				case "find_tmplt_d":
					var bkg_no = formObject.bkg_no.value;
					ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=D&rtn=dg_cmdt_desc&bkg_no="+bkg_no, "MnD Template", 600, 390, true);
				break;

				case "btn_t8ExportImportInfo":
					var bkg_no  = formObject.bkg_no.value;
					var pkg_qty = formObject.pck_qty.value;
					var pkg_tp  = formObject.pck_tp_cd.value;
					var wgt_qty = formObject.act_wgt.value;
					var wgt_tp  = formObject.wgt_ut_cd.value;
					var pol_cd  = formObject.pol_cd.value;
					var pod_cd  = formObject.pod_cd.value;

					if(bkg_no == ''){
						alert("bkg_no!!!!");
						formObject.bkg_no.focus();
						return;
					}

					//var url = "ESM_BKG_0361_01.do?popUpTpCd=B&bkg_no=" + bkg_no + "&pkg_qty=" + pkg_qty + "&pkg_tp=" + pkg_tp + "&wgt_qty=" + wgt_qty + "&wgt_tp=" + wgt_tp + "&pol_cd=" + pol_cd + "&pod_cd=" + pod_cd;
					var url = "ESM_BKG_0361_01.do";

					if(pol_cd!=''){
						switch(pol_cd.substring(0,2)) {
							case "US":
								url = "ESM_BKG_0361_01.do";
							break;
							case "KR":
								url = "ESM_BKG_0361_02.do";
							break;
							case "BR":
								url = "ESM_BKG_0361_03.do";
							break;
							case "IN":
								url = "ESM_BKG_0361_04.do";
							break;
							case "ID":
								url = "ESM_BKG_0361_05.do";
							break;
							case "CA":
								url = "ESM_BKG_0361_06.do";
							break;
						}
					}

					url += "?popUpTpCd=B&io_bnd_cd=O&bkg_no=" + bkg_no + "&pkg_qty=" + pkg_qty + "&pkg_tp=" + pkg_tp + "&wgt_qty=" + wgt_qty + "&wgt_tp=" + wgt_tp + "&pol_cd=" + pol_cd + "&pod_cd=" + pod_cd;
					//alert("open --> " + url);
					ComOpenWindow(url, "ESM_BKG_0361_01", "dialogWidth:600px;dialogHeight:510px", true);
				break;

				case "btn_t8POOtherNo":
					var bkg_no = formObject.bkg_no.value;
					var ca_flg = formObject.corr_flg.value;
					var url = "ESM_BKG_0367_01.do?func=callbackPOOtherNo&popUpTpCd=B&bkg_no=" + bkg_no +"&ca_flg=" + ca_flg;
					//alert("open --> " + url);
					ComOpenWindow(url, "ESM_BKG_0367_01", "dialogWidth:800px;dialogHeight:520px", true);
				break;


				case "btn_find_package":
					//var url = "ESM_BKG_0696.do";
					//ComOpenWindow(url, "ESM_BKG_0696", "width=400,height=389", false);
					//comBkgCallPop0696("callbackPckTp", formObject.pck_tp_cd.value);
					comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value);
				break;
				
//				case "btn_wpm_trt":
//					var url = "ESM_BKG_3005.do?bkg_no="+formObject.bkg_no.value
//							+ "&wpm_trt_cd="+formObject.wpm_trt_cd.value
//			        ComOpenPopup(url, 370, 150, "","1,0,1,1,1", true);
//				break;
				
				case "wgt_ut_cd":
					if(formObject.bdr_flg.value == 'Y' && formObject.corr_flg.value == 'N'){
						formObject.wgt_ut_cd.selectedIndex = wgt_ut_idx;
					}				
				break;
				//case "meas_ut_cd":
				//	if(formObject.bdr_flg.value == 'Y' && formObject.corr_flg.value == 'N'){
				//		formObject.meas_ut_cd.selectedIndex = meas_ut_idx;
				//	}				
				//break
				case "frt_term_cd":
					if(formObject.bdr_flg.value == 'Y' && formObject.corr_flg.value == 'N'){
						formObject.frt_term_cd.selectedIndex = frt_term_idx;
					}				
				break;
				
				case "btn_Clz_Add":
					var newRow = sheetObject3.DataInsert(-1);
					sheetObject3.CellValue(newRow, "bkg_no") = formObject.bkg_no.value;
					sheetObject3.CellValue(newRow, "cluz_lck_tp_cd") ="D";
					formObject.dirty_flag.value = 'Y';
					break;      
				
				case "btn_Clz_Delete":
					if (!ComShowCodeConfirm("COM12188")) return;
					sheetObject3.RowStatus(sheetObject3.SelectRow) = "D";
					sheetObject3.RowHidden(sheetObject3.SelectRow) = true;
					formObject.dirty_flag.value = 'Y';
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].WaitImageVisible=false;
		}
		//iframe 생성 
//    	CofigIframe();

    	//------------------------------------------------>
    	//setInquiryDisableButton 이벤트 호출
   		setInquiryDisableButton();
     	//------------------------------------------------>
   		
		// set init-data for sheets
		if(document.form.bkg_no.value != ''){
			//retrieveSplitNo();
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH) ;
		}
		doActionIBSheet(sheetObjects[1], document.form, SEARCH01);

		initControl();
	}

	function initControl() {
		//add listener
		axon_event.addListenerForm('beforeactivate', 'form1_focus', document.form);
		axon_event.addListenerForm('deactivate', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		applyShortcut();
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
					InitRowInfo(1, 1, 5, 100);

					var HeadTitle = "|Seq.|Val|Name|Desc";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtSeq,		20,		daCenter,	false,	"seq");
					InitDataProperty(0,	cnt++,	dtData,		40,		daCenter,	false,	"val");
					InitDataProperty(0,	cnt++,	dtData,		130,	daLeft,		false,	"name",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	false,	"desc",		false,	"",			dfNone,		0,			false,		false);

				}
			break;
			case 2:      //sheet1 init
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
					InitRowInfo(1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					var HeadTitle1 = "|Template Seq.|Template Type|Template Name|Contents";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtStatus,	20,		daCenter,	false,	"ibflag");
					//InitDataProperty(0, cnt++, dtSeq, 40, daCenter, false, "Seq");
					InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	false,	"tmplt_seq",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	false,	"tmplt_tp_cd",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		false,	"tmplt_hdr_nm",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,		200,	daLeftTop,	false,	"tmplt_ctnt",	false,		"",      dfNone,			0,		true,		true, 45);

					WordWrap = true;
					CountPosition = 0;

				}
			break;
			
			case 3:      //clause lock
				with (sheetObj) {	
					// 높이 설정
					style.height = 43;
					// 전체 너비 설정
					SheetWidth = 480;
			
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
			
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					// 자동 트림하여 조회및 저장
					DataAutoTrim = true;
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(0, 1, 2, 100);
			
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(6, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false)
			
					var HeadTitle1 = "|||||";
			
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true,true);	
					
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
					//InitDataProperty(0, cnt++, dtCheckBox, 		20, daCenter, 	true,  "check");
					InitDataProperty(0,	cnt++, 	dtSeq,				30,		daCenterTop ,	false, 	"seq");
					InitDataProperty(0, cnt++, dtData, 			400, daLeft, 	true,  "cluz_lck_desc",			false, "", dfNone, 		0, true, true, 50, 	false);
					InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"bkg_no",					false,			"",   dfNone, 0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cluz_lck_seq",					false,			"",   dfNone, 0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cluz_lck_tp_cd",					false,			"",   dfNone, 0,	true,	true);
			
					//InitDataValid(0, "cluz_lck_desc", vtEngUpOther);
					
					MultiSelection = false;
					SelectHighLight = true;
					CountPosition = 0;
					sheetObj.ScrollTrack = true;
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
	//	sheetObj.ShowDebugMsg = 1;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value = SEARCH;
					//sheetObj.DoSearch("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
					
					var arrXml = rXml.split("|$$|");
					
					sheetObjects[2].LoadSearchXml(arrXml[0], false);
					
					// etcData to Form
					ComEtcDataXmlToForm(rXml, formObj);
					formObj.old_bkg_no.value = ComGetEtcData(rXml,"bkg_no");
					// BDR시 사용하게될 변수
					wgt_ut_idx = formObj.wgt_ut_cd.selectedIndex;
					meas_ut_idx = formObj.meas_ut_cd.selectedIndex;
					frt_term_idx = formObj.frt_term_cd.selectedIndex;

					// set Format
					formObj.pck_qty.value = ComAddComma3(formObj.pck_qty.value, "#,###");
					formObj.act_wgt.value = ComAddComma3(formObj.act_wgt.value, "#,###.000");
					formObj.meas_qty.value = ComAddComma3(formObj.meas_qty.value, "#,###.000");

					/* Export & Import Licence */
					//if(document.form.isInquiry.value == "N"){
						if(ComIsEmpty(formObj.xpt_imp_seq.value)){
							getBtnObject("btn_t8ExportImportInfo").style.color = "#737373";
						}else{
							getBtnObject("btn_t8ExportImportInfo").style.color = "blue";
						}
					//}
					
				    //Initialize	 Edit-Enabled, Color-white
				    // POD CD = 'BR' 일 경우 Edit:Disabled, Color:gray초기화 ,C/A Issue confirm, cancel 이후 초기화 되어야 함
                    formObj.mk_desc.readOnly = false;
                    formObj.dg_cmdt_desc.readOnly = false;
                    formObj.mk_desc.className = "textarea";
                    formObj.dg_cmdt_desc.className = "textarea";
                    
					//BDR flag = "Y" 일 경우 BKG no 바탕색을 파랑게 변경. "N"일 경우 흰색으로 변경
					if(formObj.bdr_flg.value == 'Y'){
						document.getElementById("bkg_no").className = "input1";
					}else{
						document.getElementById("bkg_no").className = "input";
					}
					
				    var podCd = formObj.pod_cd.value;
				    var shprCd = formObj.shpr_cd.value;
				    var strOfc_cd = formObj.strOfc_cd.value;
					//
					// POD 의 Country Code AR,UY인 경우만  Auto clause display버튼 보임
				    if(podCd.substring(0,2)=="AR"||podCd.substring(0,2)=="UY"||podCd.substring(0,2)=="SA"
				    	||(podCd=="JOAQJ" && strOfc_cd=="JORBA")
				    	||(podCd=="JOAQJ" && strOfc_cd!="JORBA" && (formObj.cust_flg.value=="N"||formObj.cust_flg.value=="Y"))){
				    	document.getElementById("display_yn1").style.display = "inline";
				    	document.getElementById("display_yn2").style.display = "inline";
				    }else{
				    	document.getElementById("display_yn1").style.display = "none";
				    	document.getElementById("display_yn2").style.display = "none";
				    }
					if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
					    
					    // Marks & Numbers 및 Description of Goods 항목 비활성화
    					//if(podCd.substring(0, 2) == "BR" || podCd.substring(0, 2) == "IT" ){ //BDR 이후 POD 의 Country Code 가 BR 인 경우, IT 인 경우(2012.10.23 by wonjoo)
    					    //CHM-201221060-01 전지역 모두 block되도록 
						   //Edit-disabled
							formObj.mk_desc.readOnly = true;
	                        formObj.dg_cmdt_desc.readOnly = true;
	                        
						    //Color-gray
							formObj.mk_desc.className = "textarea2";
							formObj.dg_cmdt_desc.className = "textarea2";
    					//}
					    
						formObj.pck_qty.readOnly = true;
						formObj.pck_tp_cd.readOnly = true;
						formObj.act_wgt.readOnly = true;
						//formObj.meas_qty.readOnly = true;
						formObj.cstms_desc.readOnly = true;
                        
						//alert("pck_qty");
						formObj.pck_qty.className = "input2";
						formObj.pck_tp_cd.className = "input2";
						formObj.act_wgt.className = "input2";
						formObj.wgt_ut_cd.className = "input2";
						//formObj.meas_qty.className = "input2";
						//formObj.meas_ut_cd.className = "input2";
						formObj.cstms_desc.className = "input2";
						formObj.frt_term_cd.className = "input2";
						
					    if(podCd.substring(0,2)=="AR"||podCd.substring(0,2)=="UY"||podCd.substring(0,2)=="SA"
					    	||(podCd.substring(0,2)=="JO"&&shprCd != "KR19301")){
					    	formObj.display_chk.disabled = true;
					    }
						
					}else{
					    //BDR 이후 POD 의 Country Code 가 BR 인 경우, 
					    //Marks & Numbers 및 Description of Goods 항목 비활성화
    					if(podCd.substring(0, 2) == "BR"){
    					    //Edit-Enabled
							formObj.mk_desc.readOnly = false;
	                        formObj.dg_cmdt_desc.readOnly = false;
	                        
						    //Color-white
							formObj.mk_desc.className = "textarea";
							formObj.dg_cmdt_desc.className = "textarea";
    					}
					    
						formObj.pck_qty.readOnly = false;
						formObj.pck_tp_cd.readOnly = false;
						formObj.act_wgt.readOnly = false;
						//formObj.meas_qty.readOnly = false;
						formObj.cstms_desc.readOnly = false;
						//alert("pck_qty");
						
                        
						formObj.pck_qty.className = "input1";
						formObj.pck_tp_cd.className = "input1";
						formObj.act_wgt.className = "input1";
						formObj.wgt_ut_cd.className = "input1";
						//formObj.meas_qty.className = "input";
						//formObj.meas_ut_cd.className = "input";
						formObj.cstms_desc.className = "input1";
						formObj.frt_term_cd.className = "input1";
						
					    if(podCd.substring(0,2)=="AR"||podCd.substring(0,2)=="UY"||podCd.substring(0,2)=="SA"
					    	||(podCd.substring(0,2)=="JO"&&shprCd != "KR19301")){
					    	formObj.display_chk.disabled = false;
					    }
						
					}
					/*
					 * - 2009.05.22일 추가 -
					 * Mandatory Item(s) Setup for Customized Service (UI_BKG-1030) 에 등록된 화주의 B/L인 경우, 빨간색으로 버튼 highlight 함
					 * UI_BKG-0367-01에 입력된 데이터가 있는 경우 파란색으로 highlight 함
					 */
					var r_po_other_mdt_itm = formObj.r_po_other_mdt_itm.value;
					var bkg_ref_tp_ml_cd = formObj.bkg_ref_tp_ml_cd.value; 

					var po1 = formObj.po_cust_flag.value;
					var po2 = formObj.po_ref_flag.value;
					var po3 = formObj.po_ref_dtl_flag.value;
					//alert("po1 = " + po1 + ", po2 = " + po2 + ", po3 = " + po3);
					//if(document.form.isInquiry.value == "N"){
//						if(po2 != '0' || po3 != '0'){
//							getBtnObject("btn_t8POOtherNo").style.color = "blue";
//						}else{
//							if(po1 != '0'){
//								//getBtnObject("btn_t8POOtherNo").className = "btn2_3";
//								getBtnObject("btn_t8POOtherNo").style.color = "red";
//							}else{
//								getBtnObject("btn_t8POOtherNo").style.color = "#737373";
//							}
//						}
//						if(formObj.img_flg.value =='Y'){
//							document.getElementById('btn_t8BLRider').style.color ='blue';
//						}else{
//							document.getElementById('btn_t8BLRider').style.color ='';
//						}		
					//}

//					alert("r_po_other_mdt_itm: "+r_po_other_mdt_itm+", bkg_ref_tp_ml_cd: "+bkg_ref_tp_ml_cd);
					if(r_po_other_mdt_itm != "" && bkg_ref_tp_ml_cd != "" && r_po_other_mdt_itm == bkg_ref_tp_ml_cd){
						getBtnObject("btn_t8POOtherNo").style.color = "blue";
					}else{
						if(po1 != '0'){
							getBtnObject("btn_t8POOtherNo").style.color = "red";
						}else{
							getBtnObject("btn_t8POOtherNo").style.color = "#737373";
						}
					}

					if(formObj.img_flg.value =='Y'){
						document.getElementById('btn_t8BLRider').style.color ='blue';
					}else{
						document.getElementById('btn_t8BLRider').style.color ='';
					}
					
					formObj.po_cust_flag.value    = (po1=='0') ? 'N' : 'Y';
					formObj.po_ref_flag.value     = (po2=='0') ? 'N' : 'Y';
					formObj.po_ref_dtl_flag.value = (po3=='0') ? 'N' : 'Y';

					// 데이터 변경 여부 체크
					formObj.dirty_flag.value = 'N';
					// ca controll
					//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
					if(parent.t8frame != undefined && typeof(parent.t8frame) == "object") {
						parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);  
					}
//					if ("W"==formObj.bl_tp_cd.value) {
//						formObj.bl_no.value += "W";
//					} else if ("Y"==formObj.obl_iss_flg.value) {
//						formObj.bl_no.value += "S";
//					}
					
				}finally{
					ComOpenWait(false);
				}
				}
				//조회가 다 끝난 후에 Customs Description내용이 body에 없는지 비교해서 메시지를 띄어줌
//				if(compareDescriptionToBody()==-1){
//					ComShowMessage(ComGetMsg("BKG95085"));
//				}
			break;

			case SEARCH01:      //word template 조회
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_BKG_0079_06GS.do", FormQueryString(formObj));

				copyTemplateList(sheetObj, formObj);
			break;

			case SEARCH02:      //DG 조회
				if(validateForm(sheetObj,formObj,sAction)) {
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value = SEARCH02;
					//sheetObj.DoSearch("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					//formObj.dg_cmdt_desc.value = (sheetObj.EtcData("copy_from_dg")=='')
					//						   ? formObj.dg_cmdt_desc.value
					//						   : formObj.dg_cmdt_desc.value + '\n' + sheetObj.EtcData("copy_from_dg");
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					var etcData = ComGetEtcData(rXml, "copy_from_dg");
					//alert(etcData);
					formObj.dg_cmdt_desc.value = (etcData == '')
					                           ? formObj.dg_cmdt_desc.value
											   : formObj.dg_cmdt_desc.value + '\r\n' + etcData;
					// 수정
					formObj.dirty_flag.value = 'Y';
				}finally{
					ComOpenWait(false);
				}
				}
			break;
			

			case IBSAVE:        //저장
				if(document.form.isInquiry.value == "Y") return false;
				if(validateForm(sheetObj,formObj,sAction)) {
				try {

					ComOpenWait(true); 
					
					//[CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block
					if(formObj.meas_qty.value<=0 && "BH"==formObj.del_cd.value.substring(0,2)){
						ComShowMessage(ComGetMsg("BKG95112"));
						return false;
					}
					
					//[CHM-201326628] JPFUS-POD:KNPNH/KHSIH의 Used Commodity대상 Booking Block 요청 2013.09.13
					if(formObj.por_cd.value=="JPFUS" || formObj.pol_cd.value=="JPFUS"){
					formObj.f_cmd.value = SEARCH04;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage("BKG08273"); 
				        return false;	
				     }
					}	
					formObj.f_cmd.value = MULTI;
					//alert("sheetObj.RowCount : " + sheetObj.RowCount);
					if(sheetObj.RowCount==0){
						sheetObj.DataInsert(1);
					}else{
						sheetObj.RowStatus(1) = "U";
					}
					// unmasked;
					ComClearSeparator(formObj.pck_qty);
					ComClearSeparator(formObj.act_wgt);
					ComClearSeparator(formObj.meas_qty); 
					
					// 특수문자 제거 로직 추가
					var v_mk_desc 		= chekcSpecialValue(ComGetObjValue(formObj.mk_desc));
					var v_dg_cmdt_desc 	= chekcSpecialValue(ComGetObjValue(formObj.dg_cmdt_desc));
					var v_cstms_desc 	= chekcSpecialValue(ComGetObjValue(formObj.cstms_desc));
					
					ComSetObjValue(formObj.mk_desc, v_mk_desc);
					ComSetObjValue(formObj.dg_cmdt_desc, v_dg_cmdt_desc);
					ComSetObjValue(formObj.cstms_desc, v_cstms_desc);
					
					// 글자 자릿수 만큼 개행 처리 하기
//					lineColsSize(20, formObj.mk_desc);
//					lineColsSize(46, formObj.dg_cmdt_desc);
					// whitesapce validation check.....
					if(!dataCheck(formObj.mk_desc.value, 55)){
						alert("Marks & Numbers over line (>55)!!");
						return; 
					}
					if(!dataCheck(formObj.dg_cmdt_desc.value, 55)){
						alert("Description of Goods over line (>55)!!");
						return; 
					}
					
					//체크박스는 unchecked 되어 있으면 값을 안 넘겨주기 때문에 따로 컬럼 값을 두고 값을 받아서 처리
					if (formObj.frt_term_prn_flg_chkbox.checked) {
						ComSetObjValue(formObj.frt_term_prn_flg, "Y");
					} else {
						ComSetObjValue(formObj.frt_term_prn_flg, "N");
					}
					descFlag = true;
					formObj.action = "/hanjin/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_WordWrap.jsp";
					formObj.method = "post";
					formObj.target = "descRequest";
					formObj.submit();
				}finally{
					ComOpenWait(false);
				}
				}
			break;
			
			case COMMAND04:      //booking split no조회 
				if(validateForm(sheetObj,formObj,sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.WaitImageVisible = false;
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.WaitImageVisible = true;
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
			
			case IBCOPYROW:      // copy 
				formObj.pck_cmdt_desc.value = getPckDesc();
				if(formObj.rcv_term_cd.value != 'S'
					||(formObj.pod_cd.value.substring(0,2)=="VN" 
						&& formObj.pol_cd.value.substring(0,2)=="KR"
						&& formObj.de_term_cd.value == 'Y'
						&& formObj.rcv_term_cd.value == 'S')){
					formObj.cntr_cmdt_desc.value = formObj.cntr_desc.value;
				}
				formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\r\n" + formObj.cstms_desc.value;
				// 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
			break;					
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		var bkgNo = formObj.bkg_no.value;
		switch(sAction) {

			case IBSEARCH:
				with(formObj){
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.select();
							return false;
						}
					}
				}
			break;
			case IBSAVE:
				/*
				 * 1. 변경된 값이 있는지 체크한다. - 변경된 값이 없으면 리턴 처리한다.
				 * 2. 메시지 [BKG00350]를 표시한다.
				 * 3. 1. Route 별 문구 시트 참조하여 화면상에는 보이지 않게 하고 실제 Data에는 추가
				 * 4. BKG status를 체크한다. - "X" (Cancel)일 경우 메시지 [BKG00433] 표시 후 리턴 처리한다.
				 * 5. 입력값 확인 - Package qty/tp, Weight qty/tp, Description이 없을 경우 메세지 [BKG00505],[BKG00504],[BKG00765],[BKG00766],[BKG00767] 를 각각 표시하고 focus 한다.
				 * 6. B/L Confirm, B/L Issue 인 경우 Warning Message    - B/L Confirm만 된 경우 진행여부 확인 메세지 [BKG08234] 표시   - B/L Issue가 된 경우 진행여부 확인 메세지 [BKG08235] 표시
				*/
				if(document.form.isInquiry.value == "Y") return false;
				with(formObj){
					
					if("" != ComGetObjValue(formObj.old_bkg_no) && ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
	    				
						ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
						ComSetFocus(formObj.bkg_no);
	    				return false;    				
	    			}
					if(dirty_flag.value != 'Y'){
						//alert("변경된 데이타가 없습니다.");
						return false;
					}

					if(!confirm(ComGetMsg("BKG00350"))){
						return false
					}

					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}

					if(ComIsEmpty(bkg_no.value) || bkg_no.value.length < 11){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.select();
						return false;
					}

					if(ComIsEmpty(bl_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bl_no.select();
						return false;
					}

					if (ComIsEmpty(pck_qty.value) || pck_qty.value == '0') {
						ComShowMessage(ComGetMsg('BKG00505'));
						pck_qty.select();
						return false;
					}
					if (ComIsEmpty(pck_tp_cd.value)) {
						ComShowMessage(ComGetMsg('BKG00504'));
						pck_tp_cd.select();
						return false;
					}
					if (ComIsEmpty(act_wgt.value) || act_wgt.value == '0') {
						ComShowMessage(ComGetMsg('BKG00765'));
						act_wgt.select();
						return false;
					}
					if (!ComIsEmpty(meas_qty.value) && parseFloat(meas_qty.value) != 0 && ComIsEmpty(meas_ut_cd.value)) {
						ComShowMessage(ComGetMsg('BKG00445', "Measure Unit"));
						act_wgt.select();
						return false;
					}
					if (ComIsEmpty(cstms_desc.value)) {
						ComShowMessage(ComGetMsg('BKG00767', "[Customs Description]"));
						cstms_desc.focus();
						return false;
					}
					if(formObj.nl_cmdt_flg.value=="Y"){
						ComShowMessage(ComGetMsg('BKG95092')); 
					}
					//if (ComIsEmpty(ttl_pck_desc.value)) {
				    //    ComShowMessage(ComGetMsg('BKG08070'));
					//	ttl_pck_desc.focus();
					//	return false;
					//}
					//if(!confirm("Save")){
						//return false;
					//}
				    
				   	// 2012.04.24 BKG/DOC System 보완 요청 START
	    			if (!checkBkgIssStatus(formObj)) {
	    				return false;
	    			}
	    			// 2012.04.24 BKG/DOC System 보완 요청 END
	    			
				}
			break;
			
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;			
		}
		return true;
	}

	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		var obj = event.srcElement;
		if (obj && ("pck_qty"==obj.name || "act_wgt"==obj.name || "meas_qty"==obj.name)) {
			ComClearSeparator(event.srcElement);
		}
	}

	function form1_blur(){
		var obj = event.srcElement;
		if (obj && ("pck_qty"==obj.name || "act_wgt"==obj.name || "meas_qty"==obj.name)) {
			ComAddSeparator(obj);
		}
	}

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
	
	function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}

		/* 데이터 변경 여부 체크 */
		document.form.dirty_flag.value = 'Y';

		var srcName = event.srcElement.getAttribute("name");
		switch(srcName){

			case "pck_qty":
				//1. BL이 Issue된 상태이면 변경없이 리턴
				//2. Package Qty 및 Type이 변경될 때 Description of Goods의 첫줄을 변경한다. QTY + TYPE의 desc + " IN TOTAL"
				//3. RCV TERM 이 'S' (CFS)인 경우 Total Package in Word를 다음과 같이 수정한다. (TTL PKG값) + (PKG 코드 description) IN TOTAL
				//6. 미세관 신고 완료여부 체크하여 했을 경우 Package나 Weight가 변경된 경우 메시지 [BKG00087] 표시
				if(document.form.cstms_clr_cd.value == 'Y') {
					ComShowMessage(ComGetMsg('BKG00087'));
					event.srcElement.select();
					return false;
				}
				// changePackageDesc
				changePackageDesc();
			break;

			case "pck_tp_cd":
				var cVal = event.srcElement.value;
				if(cVal==''){
					//event.srcElement.focus();
					return false;
				}

				var rXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_06GS.do", "f_cmd="+SEARCH03+"&pck_tp_cd="+cVal);
				var pckNm = ComGetEtcData(rXml, "pck_nm");
				if(pckNm == undefined || pckNm == ''){
					alert("Can't find package code!");
					//event.srcElement.value = before_change_val;
					event.srcElement.select();
					return false;
				}
				//pck_nm
				document.form.pck_nm.value = pckNm;
				// changePackageDesc
				changePackageDesc();
			break;

			case "act_wgt":
				//6. 미세관 신고 완료여부 체크하여 했을 경우 Package나 Weight가 변경된 경우 메시지 [BKG00087] 표시
				if(document.form.cstms_clr_cd.value == 'Y') {
					ComShowMessage(ComGetMsg('BKG00087'));
				}
			break;

			case "frt_term_cd":
				/* Reefer Cargo인지 확인하여 C-Collect 선택시 Warning 메시지 [BKG00718] 팝업 */
				if(document.form.rc_flg.value == 'Y'){
					if (document.form.frt_term_cd.options[document.form.frt_term_cd.selectedIndex].value == 'C') {
						ComShowMessage(ComGetMsg('BKG00718'));
						return false;
					}
				}
			break;

			case "tp_word_template":
				setTemplateValues('T');
			break;

			case "mk_word_template":
				setTemplateValues('M');
			break;

			case "dg_word_template":
				setTemplateValues('D');
			break;
			
			case "mk_desc":
			case "dg_cmdt_desc":
				event.srcElement.value = event.srcElement.value.toUpperCase();
				event.srcElement.value = event.srcElement.value.replace(/\t/g, " ");				
			break;

		}
	}

	function t8sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if ('Y' == ComGetObjValue(formObj.frt_term_prn_flg)) {
			formObj.frt_term_prn_flg_chkbox.checked = true;
		}else{
			formObj.frt_term_prn_flg_chkbox.checked = false;
		}
		//alert(sheetObj.id + "_OnSearchEnd : " + ErrMsg);
	}

	function t8sheet2_OnSearchEnd(sheetObj, ErrMsg){
		//alert(sheetObj.id + "_OnSearchEnd : " + ErrMsg);
	}
	
	function t8sheet3_OnMouseDown(button, shift, X, Y){
		var selText = "";
		var formObj = document.form;
		if (window.getSelection) {
			selText =  window.getSelection().toString();
	    } else if (document.selection) {
	    	selText =  document.selection.createRange().text;
	    }
		
		if(selText != "" ){	
			formObj.dirty_flag.value = 'Y';
			sheetObjects[2].CellValue(sheetObjects[2].MouseRow,"cluz_lck_desc") = selText;				
		}
	}
	
	function t8sheet3_OnDblClick(sheetObj, row, col) {
		if (col != 1) {		
			var col_save_name = sheetObj.ColSaveName(col);
			if (col_save_name == "cluz_lck_desc") {
				ComShowMemoPad(sheetObj, row, "rjct_rsn_rmk", false, 250, 300);
			} 
		}
	} 

	function copyTemplateList(sheetObj, formObj){
		/* combo object */
		var TCombo = formObj.tp_word_template;
		var MCombo = formObj.mk_word_template;
		var DCombo = formObj.dg_word_template;

		/* remove old value */
		removeOptions(TCombo);
		removeOptions(MCombo);
		removeOptions(DCombo);

		/* set new value */
		var rcnt = sheetObj.RowCount;
		for(ir=1;ir<=rcnt;ir++){
			var tmplt_type = sheetObj.CellValue(ir, "tmplt_tp_cd");
			if(tmplt_type=='D'){
				DCombo.options[DCombo.length] = new Option(sheetObj.CellValue(ir, "tmplt_hdr_nm") , sheetObj.CellValue(ir, "tmplt_seq"));
			}else if(tmplt_type=='M'){
				MCombo.options[MCombo.length] = new Option(sheetObj.CellValue(ir, "tmplt_hdr_nm") , sheetObj.CellValue(ir, "tmplt_seq"));
			}else if(tmplt_type=='T'){
				TCombo.options[TCombo.length] = new Option(sheetObj.CellValue(ir, "tmplt_hdr_nm") , sheetObj.CellValue(ir, "tmplt_seq"));
			}
		}
	}

	function setTemplateValues(tmplt_type){
		var sheetObj = sheetObjects[1];
		var lstObj = '';
		var tgtObj = '';
		var tmplt_seq = '';
		var tmplt_ctnt = '';

		if(tmplt_type=='D'){
			lstObj = document.form.dg_word_template;
			tgtObj = document.form.dg_cmdt_desc;
		}else if(tmplt_type=='M'){
			lstObj = document.form.mk_word_template;
			tgtObj = document.form.mk_desc;
		}else if(tmplt_type=='T'){
			lstObj = document.form.tp_word_template;
			tgtObj = document.form.ttl_pck_desc;
		}

		tmplt_seq = lstObj.options[lstObj.selectedIndex].value;
		var rowCnt = sheetObj.RowCount;
		for(ir=1;ir<=rowCnt;ir++){
			if(sheetObj.CellValue(ir, "tmplt_tp_cd") == tmplt_type && sheetObj.CellValue(ir, "tmplt_seq") == tmplt_seq){
				if(tmplt_type=='T'){
					tgtObj.value = sheetObj.CellValue(ir, "tmplt_ctnt");
				}else{
					tgtObj.value += sheetObj.CellValue(ir, "tmplt_ctnt");
				}
			}
		}

	}

	function changePackageDesc() {
		//1. BL이 Issue된 상태이면 변경없이 리턴
		//if(document.form.obl_iss_flg.value == 'Y') {
		//	alert("B/L Issued");
		//	return;
		//}
		//2. Package Qty 및 Type이 변경될 때 Description of Goods의 첫줄을 변경한다. QTY + TYPE의 desc + " IN TOTAL"
		//3. RCV TERM 이 'S' (CFS)인 경우 Total Package in Word를 다음과 같이 수정한다. (TTL PKG값) + (PKG 코드 description) IN TOTAL
		//document.form.pck_cmdt_desc.value = getPckDesc();
		//alert("RCV_Term : " + flag);
		if(document.form.rcv_term_cd.value == 'S'){
			document.form.ttl_pck_desc.value = getPckDesc();
		}
	}

	function getPckDesc(){
		var p = (document.form.pck_qty.value=='') ? 0 : BkgParseInt(ComTrimAll(document.form.pck_qty.value, ','));
		if(p > 1){
			return p + " " + document.form.pck_nm.value + ("BOX"==document.form.pck_nm.value ? "E":"") + "S IN TOTAL";
		}else if(p == 1){
			return p + " " + document.form.pck_nm.value + " IN TOTAL";
		}else{
			return "";
		}
	}

	/* common script */
	function removeOptions(comboObj) {
		var len = comboObj.length;
		for(i=1;i<len;i++) {
			comboObj.remove(len-i);
		}
	}
	
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	
	function callbackCopyFromHBL(bl_mk_desc, bl_cmdt_desc){
		document.form.mk_desc.value = bl_mk_desc;
		document.form.dg_cmdt_desc.value = bl_cmdt_desc;
		// 수정
		document.form.dirty_flag.value = 'Y';
	}

	function callbackPckTp(returnVal){
		if(document.form.obl_iss_flg.value == 'Y') return false;
		document.form.pck_tp_cd.value = returnVal[0][3];
		document.form.pck_nm.value = returnVal[0][4];
		changePackageDesc();
		// 수정
		document.form.dirty_flag.value = 'Y';
	}

	function callbackCmdtDesc(pck_cmdt_desc, cntr_cmdt_desc, dg_cmdt_desc, cm_cstms_desc){
		document.form.pck_cmdt_desc.value = pck_cmdt_desc;
		document.form.cntr_cmdt_desc.value = cntr_cmdt_desc;
		document.form.dg_cmdt_desc.value = document.form.dg_cmdt_desc.value + "\r\n" + dg_cmdt_desc;
		if(cm_cstms_desc != '') document.form.cstms_desc.value = cm_cstms_desc;
		// 수정
		document.form.dirty_flag.value = 'Y';
	}
	
	function callbackPOOtherNo(po_cust_flag, po_ref_flag, po_ref_dtl_flag, dgc_desc){
		
		var po1 = po_cust_flag;
		var po2 = po_ref_flag;
		var po3 = po_ref_dtl_flag;
		//alert("po_cust_flag = " + po1 + ", po_ref_flag=" + po2 + ", po_ref_dtl_flag=" + po3);

		if(document.form.isInquiry.value == "N"){
			if(po2 == 'Y' || po3 == 'Y'){
				getBtnObject("btn_t8POOtherNo").style.color = "blue";
			}else{
				if(po1 == 'Y'){
					getBtnObject("btn_t8POOtherNo").style.color = "red";
				}else{
					getBtnObject("btn_t8POOtherNo").style.color = "#737373";
				}
			}
		}

		document.form.po_cust_flag.value    = po1;
		document.form.po_ref_flag.value     = po2;
		document.form.po_ref_dtl_flag.value = po3;
		
		/**/
		if(dgc_desc != undefined) {
			document.form.dg_cmdt_desc.value =  document.form.dg_cmdt_desc.value + "\r\n" + dgc_desc;
		}
		// 수정
		document.form.dirty_flag.value = 'Y';
	}

	/* 탭이동 시 화면의 데이타 변경여부 체크 */
	function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				//ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
//			}
		}
//		else{ //데이터 변경이 없어도 Customs Description 문구가 body안에 들어가 있지 않은 경우
//			compareDescriptionToBody();
//		}
	}

	function searchData(bkgNo){
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_t8Save");
			ComBtnDisable("btn_t8CopyfromDG");
			ComBtnDisable("btn_t8CopyfromCM");
			ComBtnDisable("btn_t8CopyfromHouseBL");
//			ComBtnDisable("btn_t8BLRider");
//			ComBtnDisable("btn_t8ExportImportInfo");
//			ComBtnDisable("btn_t8POOtherNo");
		}
	}

	function descSend() {
		if (descFlag) {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			var sheetObj2 = sheetObjects[2];
			formObj.mk_desc.value = descRequest.document.getElementById("mk_desc").value;
			formObj.dg_cmdt_desc.value = descRequest.document.getElementById("dg_cmdt_desc").value;
			var fstr = FormQueryString(formObj);
			fstr = fstr + "&" + ComSetPrifix(sheetObj2.GetSaveString(true), "t8sheet3_");
			
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0079_06GS.do", fstr);
			var dgKeyFlg = ComGetEtcData(rXml, "dg_key_flg");
			var dgKeyFlg2 = ComGetEtcData(rXml, "dg_key_flg2");
			var rMsg = ComResultMessage(rXml);
			if (rMsg == '') {
				sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
				formObj.dirty_flag.value = 'N';
				
				//아래 2개 flg에 걸리면 mntr로 데이터 인터페이스 (sc단에 로직있음)
				if(dgKeyFlg=="Y")
					ComShowMessage(ComGetMsg("BKG08314"));
				//해당 키워드에 걸리면 키워드가 return, 아니면 N 리턴
				if(dgKeyFlg2!="N")
					ComShowCodeMessage("BKG95100",dgKeyFlg2);
				ComShowMessage(ComGetMsg("BKG00166"));
			} else {
				ComShowMessage(rMsg);
			}
			window.focus();
			descFlag = false;
		}
	}
	
	/**
	 * HTML Control의 onblur이벤트 <br>
	 **/
	function obj_deactivate() {
		var formObj = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (srcName == "bkg_no" || srcName == "bl_no") {
			formObj.elements[srcName].value = srcValue.toUpperCase();
		}
	}	
	 
	 
	 /**
	  * BKG B/L Confirm, B/L Issued 여부 판단
	  * 2012.04.24 오요한 BKG/DOC System 보완 요청
	  * @param formObj
	  * @return
	  */
	function checkBkgIssStatus(formObj) {
		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH12+"&bkg_no="+formObj.bkg_no.value);
		var bkgIssStatus = ComGetEtcData(sXml, "BKG_ISS_STATUS");
		if ("C" == bkgIssStatus) {
			if(ComShowConfirm(ComGetMsg("BKG08234"))) {//"B/L was already confirmed by shipper, do you want to still change?";
				return true;
			} else {
				return false;
			}
		} else if ("I" == bkgIssStatus) {
			if (ComShowConfirm(ComGetMsg("BKG08235"))) { //"B/L was already issued, do you want to still change?";
				return true;
			} else {
				return false;
			}
		} else {
			// C / I 가 아닌경우엔 체크를 하지 않는다.
			return true;
		}
	} 
	
	
	
	function poExistFn() {
		var formObj = document.form;

		//P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회
		var rXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_06GS.do", "f_cmd="+SEARCH05+"&bkg_no="+formObj.bkg_no.value);
		var poNm = ComGetEtcData(rXml, "po_nm");
		var sManItmDesc = "";
		if (poNm != '' || poNm.length > 0){
			var ifilter = poNm.split(",");
			for ( var inx = 0; inx < ifilter.length; inx++) {
				if ('POB' == ifilter[inx]) {
					sManItmDesc += " P/O No.(by BKG),"
				}
				if ('POC' == ifilter[inx]) {
					sManItmDesc += " P/O No.(by CNTR),"
				} 
				if ('POM' == ifilter[inx]) {
					sManItmDesc += " P/O No.(by Item)," 
				} 
				if ('INV' == ifilter[inx]) {
					sManItmDesc += " Invoice No.," 
				} 
				if ('DPT' == ifilter[inx]) {
					sManItmDesc += " Department No.," 
				} 
				if ('LCN' == ifilter[inx]) {
					sManItmDesc += " L/C No.," 
				} 
				if ('SHP' == ifilter[inx]) {
					sManItmDesc += " Ship ID," 
				} 
				if ('PRT' == ifilter[inx]) {
					sManItmDesc += " Part No.," 
				} 
				if ('INC' == ifilter[inx]) {
					sManItmDesc += " Incoterms," 
				} 
				
			}
			sManItmDesc = sManItmDesc.substring(0,sManItmDesc.length-1);
			ComShowMessage(ComGetMsg('BKG95076', sManItmDesc));
		}
	}
	 
	/* 
	 * 2015.04.27 양동훈 로직추가
	 * - 도착지가 중국(CN)인 BKG에 대해서 조회 시에 
	 * M&D의 Customs Description 항목이 Descrption of goods항목에 
	 * 표기되어 있지 않으면 메세지 alert출력. 
	 * Customs Description 항목이 입력되어있지 않은 경우는 제외. 
	 */
	function compareDescriptionToBody(){
		if("CN"==document.form.pod_cd.value.substring(0,2)){ //도착지 중국일 경우
			var customsDescription = document.form.cstms_desc.value.replace(/\s/g,'').replace(/\r/g,'');
			var arrayForKeyword = customsDescription.split("/"); // 슬래쉬(/)로 키워드를 나눔
			var tm = new Array();
//			for(var i=0;i<arrayForKeyword.length;i++){
//				tm = arrayForKeyword[i].split(","); // 쉼표(,)로 키워드를 나눔
//			}
//			for(var i=0;i<tm.length;i++){
//				alert(tm[i]);
//			}
			
			var resultArray = new Array(); //결과 값을 저장할 배열
			var words = new Array("/",","); // split 할 문자를 담은 배열
			var arrayedDescription = new Array(customsDescription); // description 문자열을 array형태로 초기화. split이 될 때 배열로 계속 쪼개지기 때문
			var result = splitWords(words,arrayedDescription,0,resultArray); //result에 split 된 문자를 배열형태로 담음
			
			var flag = true;
			var blBody = document.form.dg_cmdt_desc.value.replace(/\s/g,'').replace(/\r/g,'');
			blBody = blBody.replace(/\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\-|\_|\=|\+|\,|\.|\<|\>|\:|\;|\?|\[|\]/g,'');
			for(var i=0;i<result.length;i++){
				result[i] = result[i].replace(/\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\-|\_|\=|\+|\,|\.|\<|\>|\:|\;|\?|\[|\]/g,'');
				if(blBody.indexOf(result[i])==-1)
					flag = false;
			}
			return flag;
		}
	}
	/*
	 * 재귀function
	 * words 배열에 담긴 문자들로 각각 split을 한다.
	 * @param words       -> split할 단어 배열
	 * @param description -> 비교문자를 담은 배열
	 * @param idx         -> 인덱스 값. 초기값은 0
	 * @return resultArray-> 결과 값을 반환할 배열
	 */
	function splitWords(words, description, idx, resultArray){
		var word = words[idx]; //split할 문자를 가져옴
		var temp; //임시배열
		//마지막 문자까지 다 split하기 전에는 계속해서 결과값 배열을 초기화
		if(words.length!=idx){
			resultArray = new Array();
		}
		//반복문을 돌며 word에 담긴 문자로 split 하고 그것을 resultArray에 넣는다.
		for(var i=0;i<description.length;i++){
			temp = description[i].split(word);
			for(var j=0;j<temp.length;j++){
				if(temp[j]!=null)
					resultArray.push(temp[j]);	
			}
		}
		//words배열에 담긴 문자로 모두 split 했으면 결과값 배열 리턴
		if(words.length-1==idx){
			return resultArray;
		}
		//그렇지 않다면 idx값을 더해주고 결과값 배열(resultArray)를 비교할 새 배열로 설정
		else{
			return splitWords(words,resultArray,++idx,resultArray);
		}
	}
	/* 개발자 작업  끝 */
