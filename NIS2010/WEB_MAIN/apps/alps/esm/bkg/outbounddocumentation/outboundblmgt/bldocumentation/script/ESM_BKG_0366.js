/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_366.js
*@FileTitle : Marks And Number/Description of Goods
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.22 김영출
* 1.0 Creation
=========================================================*/
/*
 * History 
 2010.09.07 김태경 [CHM-201005694-01] [M&D] 부동소수점 계산오류 수정
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * */
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
     * @class ESM_BKG_366 : ESM_BKG_366 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0366() {
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
				
				case "btn_split":
					var org_bl_no = formObject.org_bl_no.value;
					var org_cntr_mf_no = formObject.org_cntr_mf_no.value;
					var url = "ESM_BKG_0959.do?func=callbackSplit&bkg_no="+org_bl_no+"&org_cntr_mf_no="+org_cntr_mf_no;
					ComOpenWindowCenter(url, "ESM_BKG_0959", 400, 180, true);
				break;

				case "btn_hbl_tmplt":
					var shpr_nm = formObject.shpr_nm.value;
					var cnee_nm = formObject.cnee_nm.value;
					var url = "ESM_BKG_0399.do?func=callbackHblTmplt&shpr_nm="+shpr_nm+"&cnee_nm="+cnee_nm;
					ComOpenWindowCenter(url, "ESM_BKG_0399", 720, 540, false);
				break;

				case "btn_PCKPop":
					comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value   );
				break;

				case "btn_add":
					if(ComIsEmpty(formObject.cntr_mf_no.value)){
						ComShowMessage(ComGetMsg("BKG00237"));
						return;
					}
					
					if(sheetObject1.RowCount > 0 && sheetObject1.SelectRow > 0){
						// add row
						var bkg_no = formObject.bkg_no.value;
						var cntr_mf_no = formObject.cntr_mf_no.value;
						var cntr_no = sheetObject1.CellValue(sheetObject1.SelectRow, "cntr_no");
						var wgt_ut_cd = sheetObject1.CellValue(sheetObject1.SelectRow, "wgt_ut_cd");
						var meas_ut_cd = sheetObject1.CellValue(sheetObject1.SelectRow, "meas_ut_cd");
						var nrow = sheetObject2.DataInsert(-1);
						sheetObject2.CellValue2(nrow, "bkg_no") = bkg_no;
						sheetObject2.CellValue2(nrow, "cntr_no") = cntr_no;
						sheetObject2.CellValue2(nrow, "cntr_mf_no") = cntr_mf_no;
						sheetObject2.CellValue2(nrow, "wgt_ut_cd") = wgt_ut_cd;
						sheetObject2.CellValue2(nrow, "meas_ut_cd") = meas_ut_cd;
						// Set Seq
						var rseq = 0;
						var rcnt = sheetObjects[1].RowCount;
						for(rn=1; rn <= rcnt; rn++){
							if(sheetObjects[1].RowStatus(rn) != 'D' && 
							   sheetObjects[1].CellValue(rn, "cntr_no") == cntr_no &&
							   sheetObjects[1].CellValue(rn, "cntr_mf_no") == cntr_mf_no) {
								rseq++;
							}
						}
						sheetObject2.CellValue2(nrow, "seq") = rseq;
						// 수정 여부 기록
						formObject.dirty_flag.value = 'Y'
					} else {
						ComShowMessage(ComGetMsg("BKG08130"));
						return;
					} 
				break;

				case "btn_delete":
					ComRowDelete(sheetObject2, "sel", 1);
					// calculatePackage
					calculatePackage();
					// 수정 여부 기록
					formObject.dirty_flag.value = 'Y'
				break;

				case "btn_t9CopyMnd":
					if(ComIsBtnEnable("btn_t9CopyMnd")){
						doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					}
				break;

				case "btn_retrieve":
					/* 변경 사항이 있을 경우 "SAVE_CNFM" 메시지를 표시한다. - Yes를 선택하면 save를 호출한다. */
					if(formObject.dirty_flag.value == 'Y'){
						if(confirm(ComGetMsg("BKG00254"))){
							doActionIBSheet(sheetObject3, formObject, IBSAVE);
						}
					}				
					doActionIBSheet(sheetObject3, formObject, IBSEARCH) ;
				break;

				case "btn_save":
					/* 변경 사항이 있을 경우 "SAVE_CNFM" 메시지를 표시한다. - Yes를 선택하면 save를 호출한다. */
					
					//if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
						var rflag = doActionIBSheet(sheetObject3, formObject, IBSAVE) ;
						if(rflag) {
							 //성공메세지
							ComShowMessage(ComGetMsg("BKG00166"));
						}
						rflag = false;
					//}
				break;

				case "btn_addHBl":
					doActionIBSheet(sheetObject3, formObject, IBINSERT);
				break;

				case "btn_deleteHBl":
					doActionIBSheet(sheetObject3, formObject, IBDELETE);
				break;

				case "btn_copyHBl":
					if(sheetObjects[2].SelectRow <= 0) {
//						alert("no selected row!");
						ComShowMessage(ComGetMsg("BKG00249"));
						return;
					}
					//alert("UI_BKG-0960");
					var url = "ESM_BKG_0960.do?func=callbackCopyHbl";
					ComOpenWindowCenter(url, "ESM_BKG_0960", 250, 160, false);
				break;

				case "btn_copyCM":
					var selIdx = sheetObject1.SelectRow;
					if(selIdx > 0){
						var cntr_no  = sheetObject1.CellValue(selIdx, "cntr_no");
						var cntr_tpsz_cd = sheetObject1.CellValue(selIdx, "cntr_tpsz_cd");
						var url = "ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
						ComOpenWindow(url, "ESM_BKG_0176", "width=400,height=300", false);
					}else{
						ComShowMessage(ComGetMsg("BKG00188"));
					}
				break;
				
				case "btn_amsFileNoAssign":
					if(ComIsBtnEnable("btn_amsFileNoAssign")){
						if(confirm(ComGetMsg("BKG00240"))) {
							if(formObject.dirty_flag.value == 'Y'){
								var rflag = doActionIBSheet(sheetObject3, formObject, IBSAVE);
								if(!rflag) return;
							}					
							doActionIBSheet(sheetObject3, formObject, MULTI01) ;
						}
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
   		
        // set init-data
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH) ;
		}
		initControl();
    }

	function initControl() {
        //add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
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
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "Seq.|HBL|Container|Container|C/M|Cfm";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,  COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtSeq,      40,    daCenter,   false,    "seq");
                    InitDataProperty(0, cnt++,  dtHidden,   70,    daCenter,   false,    "hbl_seq",       false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtData,     90,    daCenter,   false,    "cntr_no",       false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cntr_tpsz_cd",  false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtData,     30,    daCenter,   false,    "cntr_mf_flag",  false,    "",         dfNone,     0,          true,        true);

                    InitdataProperty(0, cnt++,  dtHidden,   10,    daLeft,     false,    "mf_cfm_flg",    false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,   10,    daLeft,     false,    "wgt_ut_cd",     false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,   10,    daLeft,     false,    "meas_ut_cd",    false,    "",         dfNone,     0,          true,        true);

                    CountPosition = 0;
               }
            break;

            case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(22, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "|Sel.|Seq.|BkgNo|MF Seq.|CntrNo|MF No|Package|Package|Package|Weight|Measure|Marks|Marks|Description|HTS Code|HTS Code|NCM Code|NCM Code|BB";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN,   COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus, 30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,   30,    daCenter,    false,    "sel",              false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,         40,    daCenter,    false,    "seq",              false,    "",         dfNone,     0,          false,       false);

                    InitDataProperty(0, cnt++,  dtHidden,       70,    daCenter,    false,    "bkg_no",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtHidden,       70,    daCenter,    false,    "cntr_mf_seq",      false,    "",         dfNone,     0,          true,       true);
					InitDataProperty(0, cnt++,  dtHidden,       70,    daCenter,    false,    "cntr_no",          false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtHidden,       70,    daCenter,    false,    "cntr_mf_no",       false,    "",         dfNone,     0,          true,       true);

					InitDataProperty(0, cnt++,  dtData,         60,    daRight,     false,    "pck_qty",          false,    "",         dfInteger,  0,          true,       true, 7);
                    InitDataProperty(0, cnt++,  dtData,         40,    daCenter,    false,    "pck_tp_cd",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,    false,    "PCKPop",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,         90,    daRight,     false,    "cntr_mf_wgt",      false,    "",         dfFloat,    3,          true,       true, 13);
                    InitDataProperty(0, cnt++,  dtData,         90,    daRight,     false,    "meas_qty",         false,    "",         dfFloat,    3,          true,       true, 9);

                    InitDataProperty(0, cnt++,  dtData,         120,   daLeft,      false,    "cntr_mf_mk_desc",  false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daLeft,      false,    "MDPop",            false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,         120,   daLeft,      false,    "cntr_mf_gds_desc", false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,         70,    daCenter,    false,    "hamo_trf_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,    false,    "HTCPop",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,         50,    daCenter,    false,    "ncm_no",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,    false,    "NCMPop",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtHidden,       30,    daCenter,    false,    "bb_cgo_flg",       false,    "",         dfNone,     0,          true,       true);

                    InitDataProperty(0, cnt++,  dtHidden,       10,    daLeft,      false,    "wgt_ut_cd",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtHidden,       10,    daLeft,      false,    "meas_ut_cd",       false,    "",         dfNone,     0,          true,       true);

                    ShowButtonImage = 2;
					CountPosition = 0;
					AutoRowHeight = false;
               }
            break;

            case 3:      //sheet3 init
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
                    InitRowInfo(1, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(35, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "|Seq.|BKG_NO|HBL_SEQ|HBL_NO|CNTR_MF_NO|ORG_CNTR_MF_NO|BL_MK_DESC|BL_MK_DESC|PCK_QTY|PCK_TP_CD|HBL_WGT|WGT_UT_CD|CMDT_MEAS_QTY|CMDT_MEAS_UT_CD|HBL_MF_TP_CD|IDA_IEC_NO|SHPR_NM|SHPR_ADDR|SHPR_CTY_NM|SHPR_STE_CD|SHPR_CNT_CD|SHPR_ZIP_CD|CNEE_NM|CNEE_ADDR|CNEE_CTY_NM|CNEE_STE_CD|CNEE_CNT_CD|CNEE_ZIP_CD|NOTI_NM|NOTI_ADDR|NOTI_CTY_NM|NOTI_STE_CD|NOTI_CNT_CD|NOTI_ZIP_CD";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,  COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   20,    daCenter,   false,    "ibflag");
                    InitDataProperty(0, cnt++,  dtDataSeq,  20,    daCenter,   false,    "seq");
                    
					InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "bkg_no",           false,    "",         dfNone,     0,          true,       true);
                    //InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "hbl_ttl_knt",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "hbl_seq",          false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "hbl_no",           false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cntr_mf_no",       false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "org_cntr_mf_no",   false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "bl_mk_desc",       false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "bl_gds_desc",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "pck_qty",          false,    "",         dfNullInteger,  0,          true,       true, 7);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "pck_tp_cd",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "hbl_wgt",          false,    "",         dfFloat,    3,          true,       true, 13);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "wgt_ut_cd",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cmdt_meas_qty",    false,    "",         dfFloat,    3,          true,       true, 9);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cmdt_meas_ut_cd",  false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "hbl_mf_tp_cd",     false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "ida_iec_no",       false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_nm",          false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_addr",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_cty_nm",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_ste_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_cnt_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "shpr_zip_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_nm",          false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_addr",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_cty_nm",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_ste_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_cnt_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "cnee_zip_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_nm",          false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_addr",        false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_cty_nm",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_ste_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_cnt_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++,  dtData,     40,    daCenter,   false,    "noti_zip_cd",      false,    "",         dfNone,     0,          true,       true);

					CountPosition = 0;
					AutoRowHeight = false;
               }
            break;

        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	//	sheetObj.ShowDebugMsg = 1;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value = SEARCH;
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0366GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
										
                    var arrXml = rXml.split("|$$|");
                    if(arrXml.length==3){
						var hblXml  = arrXml[0];
						var cntrXml = arrXml[1];
						var cmXml   = arrXml[2];
						// Container Info
						sheetObjects[0].LoadSearchXml(cntrXml, false);
						// Cntr MF Info
						sheetObjects[1].LoadSearchXml(cmXml, false);
						// hbl Info
						sheetObjects[2].LoadSearchXml(hblXml, false);
						// booking info
						ComEtcDataToForm(formObj, sheetObjects[2], "");
						//
						formObj.old_bkg_no.value = ComGetEtcData(arrXml[0],"bkg_no");
						
						if(sheetObjects[2].TotalRows > 0){
							//
							changeComboDataByHbl();
							// change View Data
							changeViewDataByHbl(sheetObjects[2].CellValue(1, "hbl_seq"));
							//calculatePackage
							calculatePackage();
						}else{
							//formObj.hbl_seq.value = '0';
							doActionIBSheet(sheetObjects[2], formObj, IBINSERT);		
						}
						// 수정 여부 기록
						formObj.dirty_flag.value = 'N';
						// ca controll
						//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
						if(parent.t12frame != undefined && typeof(parent.t12frame) == "object") {
							parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);  
						}
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}
					}else{
						return false;
					}
				}finally{
					ComOpenWait(false);
				}
				}else{
					return false;
				}
			break;

			case IBSAVE:        //저장
				if(document.form.isInquiry.value == "Y") return;
				if(validateForm(sheetObj,formObj,sAction)){
					//추가조원주
					if(formObj.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
						try {
							ComOpenWait(true); 
							formObj.f_cmd.value = MULTI;
											
							var sParam = FormQueryString(formObj);
							// Sheet2 param
							var sParamSheet1 = sheetObjects[1].GetSaveString();
							if (sParamSheet1 != "") {
								sParam = sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
							}
							// Sheet3 param
							var sParamSheet2 = sheetObjects[2].GetSaveString();
							if (sParamSheet2 != "") {
								sParam = sParam + "&sheet3_" + sParamSheet2.replace(/&/g, '&sheet3_');
							}
							// return xML
							var rXml = sheetObj.GetSaveXml("ESM_BKG_0366GS.do", sParam);
							var rMsg = ComResultMessage(rXml);
							if(rMsg == ''){
								// Transaction 상태 복원
								sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
								sheetObjects[2].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
								// 성공메세지
								//ComShowMessage(ComGetMsg("BKG00166"));
							} else {
								//alert(rMsg.split('<||>').join('\n'));
								ComShowMessage(rMsg);
								return false
							}
							
							// 수정 여부 기록
							formObj.dirty_flag.value = 'N';
						
						}finally{
					ComOpenWait(false);
					
				}
			
			}else{
				return false;
			}
					
				}else{
					
					return false;
				}
				
			break;


			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)){
					var nrow = sheetObj.DataInsert(-1);
					var maxSeq = ComGetMaxValue(sheetObj, "hbl_seq");
					sheetObj.CellValue2(nrow, "bkg_no") = formObj.bkg_no.value;
					sheetObj.CellValue2(nrow, "hbl_seq") = maxSeq + 1;
					sheetObj.CellValue2(nrow, "org_cntr_mf_no") = formObj.org_cntr_mf_no.value;
					sheetObj.CellValue2(nrow, "wgt_ut_cd") = formObj.default_wgt_ut_cd.value;
					sheetObj.CellValue2(nrow, "cmdt_meas_ut_cd") = formObj.default_meas_ut_cd.value;
	
					// change Combo Data
					changeComboDataByHbl();			
					// change View Data
					changeViewDataByHbl(maxSeq + 1);
					//calculatePackage
					calculatePackage();
					// 수정 여부 기록
					formObj.dirty_flag.value = 'Y';
				}else{
					return false;
				}
			break;

			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){
					// check Hbl Seq
					var hbl_seq = formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
					//alert("hbl_seq -> "+hbl_seq)
					if(hbl_seq == undefined || hbl_seq == '') return false;
					// delete grid
					var seqArr = ComGetColumnData(sheetObj, "hbl_seq");
					var idxArr = ComFindText(sheetObj, "hbl_seq", hbl_seq);
					//alert(hbl_seq + "\n"+ seqArr +"\n"+ idxArr);
					sheetObj.RowHidden(idxArr[0]) = true;
					sheetObj.RowStatus(idxArr[0]) = 'D';
					// change Combo Data
					changeComboDataByHbl();
					// change View Data
					if(seqArr.length > 0){
						var currIdx = -1;
						for(rn = 0; rn < seqArr.length; rn++){
							//alert(hbl_seq +"="+ seqArr[rn]);
							if(hbl_seq == seqArr[rn]){
								currIdx = rn;
								break;
							}
						}
						//alert("currIdx : " + currIdx + " : " + (seqArr.length-1));
						if(currIdx < 0){
							changeViewDataByHbl(0);
						}else if(currIdx == (seqArr.length-1)){
							changeViewDataByHbl(seqArr[currIdx-1]);
						}else{
							changeViewDataByHbl(seqArr[currIdx+1]);
						}
					}
					//calculatePackage
					calculatePackage();
					// 수정 여부 기록
					formObj.dirty_flag.value = 'Y';
				}else{
					return false;
				}
			break;

			case IBCOPYROW:
				if(sheetObj.RowCount > 0 && sheetObj.SelectRow > 0 && sheetObj.RowHidden(sheetObj.SelectRow)==false) {
					// description
					sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_mk_desc") = formObj.bkg_mk_desc.value;
					sheetObj.CellValue2(sheetObj.SelectRow, "cntr_mf_gds_desc") = formObj.bkg_cstms_desc.value;
					/* 수정 여부 기록 */
					formObj.dirty_flag.value = 'Y';
				}

			break;
			
			case MULTI01:
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value = MULTI01;
					// return xML
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0366GS.do", FormQueryString(formObj));
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						var mfNo = ComGetEtcData(rXml, "cntr_mf_no");
						if(mfNo == undefined || mfNo == ''){
							ComShowMessage(ComGetMsg("BKG06012", "Manifest File No."));
							return false
						}
						//alert("mfNo -> "+ mfNo);
						// 성공시 처리.
						formObj.cntr_mf_no.value = mfNo;
						// set 'cntr_mf_no' 
						var hbl_seq = formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
						var idxArr = ComFindText(sheetObj, "hbl_seq", hbl_seq);
						//alert("idxArr[0] -> "+ idxArr[0]);
						sheetObj.CellValue2(idxArr[0], "cntr_mf_no") = mfNo;
						// disable Assign. button
						ComBtnDisable("btn_amsFileNoAssign");
						//
						if(sheetObjects[0].RowCount == 1){
							//
							var bkg_no = formObj.bkg_no.value;
							var cntr_no = sheetObjects[0].CellValue(1, "cntr_no");
							var pck_qty = formObj.pck_qty.value;
							var pck_tp_cd = formObj.pck_tp_cd.value;
							var cntr_mf_wgt = formObj.hbl_wgt.value;
							var meas_qty = formObj.cmdt_meas_qty.value;
							//alert("bkg_no="+bkg_no+", cntr_no="+cntr_no+", mfNo="+mfNo);
							var nrow = sheetObjects[1].DataInsert(-1);
							sheetObjects[1].CellValue2(nrow, "bkg_no")      = bkg_no;
							sheetObjects[1].CellValue2(nrow, "cntr_no")     = cntr_no;
							sheetObjects[1].CellValue2(nrow, "cntr_mf_no")  = mfNo;
							sheetObjects[1].CellValue2(nrow, "pck_qty")     = pck_qty;
							sheetObjects[1].CellValue2(nrow, "pck_tp_cd")   = pck_tp_cd;
							sheetObjects[1].CellValue2(nrow, "cntr_mf_wgt") = cntr_mf_wgt;
							sheetObjects[1].CellValue2(nrow, "meas_qty")    = meas_qty;
							// Set Seq
							var rseq = 0;							
							var cm_cnt = sheetObjects[1].RowCount;
							for(rn=1; rn <= cm_cnt; rn++){
								if(sheetObjects[1].RowStatus(rn) != 'D' && 
								   sheetObjects[1].CellValue(rn, "cntr_no") == cntr_no &&
								   sheetObjects[1].CellValue(rn, "cntr_mf_no") == mfNo) {
									rseq++;
								}
							}
							sheetObjects[1].CellValue2(nrow, "seq") = rseq;
							// calculatePackage
							calculatePackage();
							// 수정 여부 기록
							formObj.dirty_flag.value = 'Y'
						}
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false
					}
				}finally{
					ComOpenWait(false);
				}
				}else{
					return false;
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
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 15); 
					sheetObj.WaitImageVisible = true;
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;			
		}
		return true;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 var bkgNo = formObj.bkg_no.value;
    	 switch(sAction) {
			case IBSEARCH:      //조회
				// make empty
				ComMakeEmptyForm(formObj, "bkg_no,bl_no,bl_tp_cd,isInquiry");
			break;

			case IBSAVE:        //저장
				if(document.form.isInquiry.value == "Y") return false;
			
			if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시

				ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
				ComSetFocus(formObj.bkg_no);
				return false;    				
			}
				/*
				1. 변경사항이 있을 경우 메시지 [BKG00254] 표시하고 Yes를 선택하면 Save 호출
				2. BKG status 체크 - status가 "X"일 경우 메시지 [BKG00433] 표시 후 리턴
				3. BDR 및 CA 체크 - BDR = "Y", CA = "N"일 경우 메시지 [BKG00004] 표시 후 리턴 처리

				5. HB/L 별 Mandatory Item Check
				5.a Actual Shipper Name/Address, Actual Consignee Name/Address, Package Quantity/Type, Weight Quantity/Type 필수 여부 체크하여 없을 경우 메시지 [BKG00961] 표시 후 리턴
				5.b POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우 Shipper City/Country, Consignee City/Country 필수 여부 체크하여 없을 경우 메시지 [BKG00234], [BKG00236] 표시
				5.c POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우이고 Actual Notify 있을 경우 City/Country 필수 여부 체크하여 없을 경우 메시지 [BKG00234], [BKG00236] 표시
				5.d POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우이고 Country 가 US 또는 CA 일경우 State, ZipCode 없을 경우 메시지 [BKG00235] 표시

				6. Container 별 Mandatory Item Check
				6.a Package Quantity/Type 필수 여부 체크하여 없을 경우 메시지 [BKG00961] 표시 후 리턴
				6.b Description of Goods 나 HTS code 둘중 하나 없을 경우 메시지 [BKG00961] 표시 후 리턴
				6.c POD가 US로 시작하고 DEL이 US가 아닐때 HTS code가 없을  경우 메시지 [BKG00961] 표시 후 리턴
				6.d POR/POL/POD/DEL 에 BR 의 국가 코드가 있으면 NCM code가 없을 경우 메시지 [BKG00961] 표시 후 리턴
				*/
				with(formObj){

					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}
					if(bdr_flg.value == 'Y' && ca_flg.value == 'N'){
						ComShowMessage(ComGetMsg("BKG00004"));
						return false;
					}
					//if(cnd_cstms_file_cd.value != '1' && cnd_cstms_file_cd.value != '1'){
					//	ComShowMessage(ComGetMsg("BKG00960"));
					//	return false;
					//}
				}

				var rcnt = sheetObj.RowCount;
				for(rn=1;rn<=rcnt;rn++){
					if(sheetObj.RowStatus(rn) == 'D') continue;
					//shpr_nm shpr_addr cnee_nm cnee_addr pck_qty pck_tp_cd hbl_wgt wgt_ut_cd [BKG00961] 표시 후 리턴
					
					if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_nm"))){
						ComShowMessage(ComGetMsg("BKG00961", "Shipper Name [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_addr"))){
						ComShowMessage(ComGetMsg("BKG00961", "Shipper Address [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_nm"))){
						ComShowMessage(ComGetMsg("BKG00961", "Consignee Name [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_addr"))){
						ComShowMessage(ComGetMsg("BKG00961", "Consignee Address [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "pck_qty")) || sheetObj.CellValue(rn, "pck_qty") == '0'){
						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "pck_tp_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Package Type [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "hbl_wgt")) || sheetObj.CellValue(rn, "hbl_wgt") == '0'){
						ComShowMessage(ComGetMsg("BKG00961", "Weight [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, "wgt_ut_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Weight Unit [H.B/L Seq." + rn + "]"));
						return false;
					}			
				}

				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				//alert("* pod_cnty=" +pod_cnty+ ", del_cnty=" +del_cnty+ ", cnd_flg=" + cnd_flg);
				if(pod_cnty == 'CA' || del_cnty == 'CA'){
					for(rn=1;rn<=rcnt;rn++){
						if(sheetObj.RowStatus(rn) == 'D') continue;
						// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
						if(cnd_flg == 'Y'){
							if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_cty_nm"))){
								ComShowMessage(ComGetMsg("BKG00234", "Shipper City Name [H.B/L Seq." + rn + "]"));
								formObj.shpr_cty_nm.select();
								return false;
							}
							if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_cnt_cd"))){
								ComShowMessage(ComGetMsg("BKG00236", "Shipper Country [H.B/L Seq." + rn + "]"));
								formObj.shpr_cnt_cd.select();
								return false;
							}
							if(sheetObj.CellValue(rn, "shpr_cnt_cd") == "CA" || sheetObj.CellValue(rn, "shpr_cnt_cd") == "US"){
								if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_ste_cd"))){
									ComShowMessage(ComGetMsg("BKG00235", "Shipper State [H.B/L Seq." + rn + "]"));
									formObj.shpr_ste_cd.select();
									return false;
								}
								if(ComIsEmpty(sheetObj.CellValue(rn, "shpr_zip_cd"))){
									ComShowMessage(ComGetMsg("BKG08238", "Shipper Zip Code [H.B/L Seq." + rn + "]"));
									formObj.shpr_zip_cd.select();
									return false;
								}
							}
							// POD 가 CA이고 Canada FROB인 경우,  Actual Consignee 정보 중 City/State, Country, Zip Code에 대해 Validation 추가 - 2012.06.11 이병동 대리
							if(pod_cnty == 'CA'){
								if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_cty_nm"))){
									ComShowMessage(ComGetMsg("BKG00234", "Consignee City Name [H.B/L Seq." + rn + "]"));
									formObj.cnee_cty_nm.select();
									return false;
								}
								if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_cnt_cd"))){
									ComShowMessage(ComGetMsg("BKG00236", "Consignee Country [H.B/L Seq." + rn + "]"));
									formObj.cnee_cnt_cd.select();
									return false;
								}
							}
							// POD 가 CA이고 Canada FROB인 경우,  Actual Consignee 정보 중 City/State, Country, Zip Code에 대해 Validation 추가 - 2012.06.11 이병동 대리
							//if(sheetObj.CellValue(rn, "cnee_cnt_cd") == "CA" || sheetObj.CellValue(rn, "cnee_cnt_cd") == "US"){
							if(pod_cnty == 'CA'){
								if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_ste_cd"))){
									ComShowMessage(ComGetMsg("BKG00235", "Consignee State [H.B/L Seq." + rn + "]"));
									formObj.cnee_ste_cd.select();
									return false;
								}
								if(ComIsEmpty(sheetObj.CellValue(rn, "cnee_zip_cd"))){
									ComShowMessage(ComGetMsg("BKG08238", "Consignee Zip Code [H.B/L Seq." + rn + "]"));
									formObj.cnee_zip_cd.select();
									return false;
								}
							}
							if(!ComIsEmpty(sheetObj.CellValue(rn, "noti_nm")) || !ComIsEmpty(sheetObj.CellValue(rn, "noti_addr"))){
								if(ComIsEmpty(sheetObj.CellValue(rn, "noti_cty_nm"))){
									ComShowMessage(ComGetMsg("BKG00234", "Notify City Name [H.B/L Seq." + rn + "]"));
									formObj.noti_cty_nm.select();
									return false;
								}
								if(ComIsEmpty(sheetObj.CellValue(rn, "noti_cnt_cd"))){
									ComShowMessage(ComGetMsg("BKG00236", "Notify Country [H.B/L Seq." + rn + "]"));
									formObj.noti_cnt_cd.select();
									return false;
								}
								if(sheetObj.CellValue(rn, "noti_cnt_cd") == "CA" || sheetObj.CellValue(rn, "noti_cnt_cd") == "US"){
									if(ComIsEmpty(sheetObj.CellValue(rn, "noti_ste_cd"))){
										ComShowMessage(ComGetMsg("BKG00235", "Notify State [H.B/L Seq." + rn + "]"));
										formObj.noti_cnt_cd.select();
										return false;
									}
									if(ComIsEmpty(sheetObj.CellValue(rn, "noti_zip_cd"))){
										ComShowMessage(ComGetMsg("BKG08238", "Notify Zip Code [H.B/L Seq." + rn + "]"));
										return false;
									}
								}								
							}
						}
					}
				}

				var xcnt = sheetObjects[1].RowCount;
				for(xn=1;xn<=xcnt;xn++){
					if(sheetObjects[1].RowStatus(xn) == 'D') continue;
					
					if(ComIsEmpty(sheetObjects[1].CellValue(xn, "pck_qty"))){
						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [CM]"));
						return false;
					}
					if(sheetObjects[1].CellValue(xn, "bb_cgo_flg") != 'Y' && sheetObjects[1].CellValue(xn, "pck_qty") == '0'){
						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [CM]"));
						return false;
					}					
					if(ComIsEmpty(sheetObjects[1].CellValue(xn, "pck_tp_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Package Type [CM]"));
						return false;
					}
					if(sheetObjects[1].CellValue(xn, "wgt_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Weight Unit Code");
						return false;
					}
					if(sheetObjects[1].CellValue(xn, "meas_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Measure Unit Code");
						return false;
					}
					if(ComIsEmpty(sheetObjects[1].CellValue(xn, "cntr_mf_gds_desc")) && ComIsEmpty(sheetObjects[1].CellValue(xn, "hamo_trf_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Mark & Description [CM]"));
						return false;
					}
					if(formObj.hts_flg.value == 'Y' && sheetObjects[1].CellValue(xn, "hamo_trf_cd") == ''){
						var cntr_mf_no = sheetObjects[1].CellValue(xn, "cntr_mf_no");
						var idxArr = ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
						var hbl_seq = sheetObjects[2].CellValue(idxArr[0], "hbl_seq");
						ComShowMessage(ComGetMsg("BKG00961", "HTS Code [H.B/L Seq. "+hbl_seq+"]"));
						return false;
					}					
					if(sheetObjects[1].CellValue(xn, "hamo_trf_cd") != '' && (sheetObjects[1].CellValue(xn, "hamo_trf_cd").length < 6 || sheetObjects[1].CellValue(xn, "hamo_trf_cd").length > 10)) {
						var cntr_mf_no = sheetObjects[1].CellValue(xn, "cntr_mf_no");
						var idxArr = ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
						var hbl_seq = sheetObjects[2].CellValue(idxArr[0], "hbl_seq");
						ComShowMessage(ComGetMsg("BKG06065", "HTS Code [H.B/L Seq. "+hbl_seq+"]"));
						return false;
					}
					if((por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || del_cnty == 'BR') && ComIsEmpty(sheetObjects[1].CellValue(xn, "ncm_no"))){
						var cntr_mf_no = sheetObjects[1].CellValue(xn, "cntr_mf_no");
						var idxArr = ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
						var hbl_seq = sheetObjects[2].CellValue(idxArr[0], "hbl_seq");
						ComShowMessage(ComGetMsg("BKG00961", "NCM Code [H.B/L Seq. "+hbl_seq+"]"));
						return false;
					}
					if(sheetObjects[1].CellValue(xn, "ncm_no") != '' && (sheetObjects[1].CellValue(xn, "ncm_no").length < 4 || sheetObjects[1].CellValue(xn, "ncm_no").length > 8)) {
						var cntr_mf_no = sheetObjects[1].CellValue(xn, "cntr_mf_no");
						var idxArr = ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
						var hbl_seq = sheetObjects[2].CellValue(idxArr[0], "hbl_seq");
						ComShowMessage(ComGetMsg("BKG06065", "NCM Code [H.B/L Seq. "+hbl_seq+"]"));
						return false;
					}
				}
			break;
			
			case IBINSERT:
				if(sheetObjects[0].SelectRow < 1){
					ComShowMessage(ComGetMsg("BKG08019"));
					return false;
				}
				if(document.form.dirty_flag.value == 'Y'){
					if(confirm(ComGetMsg("BKG00962"))){
						var rflag = doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
						return rflag;
					}else{
						return false;
					}
				}				
			break;
			
			case IBDELETE:
				// check empty
				if(formObj.hbl_seq.selectedIndex < 0){
					ComShowMessage(ComGetMsg("BKG04010 "));
					return false;
				}
				//
				return confirm(ComGetMsg("BKG00535"));
			break;
			
			case MULTI01:
				var hbl_seq = document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				var idx_arr = ComFindText(sheetObj, "hbl_seq", hbl_seq);
				var sts_cd = sheetObj.RowStatus(idx_arr[0]);
				if(sts_cd == 'I'){
					ComShowMessage(ComGetMsg("BKG00178"));
					return false;
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
		//ComClearSeparator(event.srcElement);
	}

    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
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
		// 대문자
		//if(event.srcElement.type =="text" || event.srcElement.type =="textarea") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
//       validateCol('','35',document.form.shpr_nm, 'Shipper');
//       validateCol('','35',document.form.shpr_addr, 'Shipper');
//       validateCol('','35',document.form.cn_nm, 'Shipper');
//       validateCol('','35',document.form.shpr_nm, 'Shipper');
//       validateCol('','35',document.form.shpr_nm, 'Shipper');
//       validateCol('','35',document.form.shpr_nm, 'Shipper');
       
        var srcName = event.srcElement.getAttribute("name");	
        switch(srcName){
            case "hbl_seq":
				var old_seq = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "hbl_seq");
				var tgt_seq = event.srcElement.value;
				
				changeViewDataByHbl(tgt_seq);
				calculatePackage();
            break;
			
			case "shpr_nm":
			case "shpr_addr":
			case "cnee_nm":
			case "cnee_addr":
			case "noti_nm":
			case "noti_addr":
            
			case "cntr_mf_no":
			case "hbl_no":
			case "ida_iec_no":
			case "hbl_mf_tp_cd":
			
			case "shpr_addr":
			case "shpr_cty_nm":
			case "shpr_ste_cd":
			case "shpr_cnt_cd":
			case "shpr_zip_cd":
			
			case "cnee_cty_nm":
			case "cnee_ste_cd":
			case "cnee_cnt_cd":
			case "cnee_zip_cd":
			
			case "noti_cty_nm":
			case "noti_ste_cd":
			case "noti_cnt_cd":
			case "noti_zip_cd":
			case "pck_qty":
			case "pck_tp_cd":
			case "hbl_wgt":
			case "wgt_ut_cd":
			case "cmdt_meas_qty":
			case "cmdt_meas_ut_cd":
			case "bl_mk_desc":
			case "bl_gds_desc":
				if(document.form.hbl_seq.selectedIndex < 0){
					ComShowMessage(ComGetMsg("BKG01105"));
					
					event.srcElement.value = '';
					return;
				}				
				var hbl_seq = document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				//alert("-> hbl_seq : "+ hbl_seq);
				var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
				//alert("-> gridIdx : "+ idxArr[0]);
				
				if(srcName=="shpr_nm"){
					validateCol('','35',document.form.shpr_nm, 'Shipper');
				}else if (srcName=="shpr_addr"){
					validateCol('','35',document.form.shpr_addr, 'Shipper');
					
				}else if (srcName=="cnee_nm"){
					validateCol('','35',document.form.cnee_nm, 'Consignee');
				}else if (srcName=="cnee_addr"){
					validateCol('','35',document.form.cnee_addr, 'Consignee');
				}else if (srcName=="noti_nm"){
					validateCol('','35',document.form.noti_nm, 'Notify');
				}else if (srcName=="noti_addr"){
					validateCol('','35',document.form.noti_addr, 'Notify');
				}
				
				sheetObjects[2].CellValue2(idxArr[0], srcName) = event.srcElement.value;
				// 수정 여부 기록
				document.form.dirty_flag.value = 'Y';
			break;
        }
		
        //var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
			case "shpr_cty_nm":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y' && ComIsEmpty(formObj.shpr_cty_nm.value)){
					ComShowMessage(ComGetMsg("BKG00234", "SHPR_CTY_NM"));
					formObj.shpr_cty_nm.select();
					return false;
				}
			break;
			case "shpr_ste_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.shpr_cnt_cd.value == "CA" || formObj.shpr_cnt_cd.value == "US") && ComIsEmpty(formObj.shpr_ste_cd.value)){
						ComShowMessage(ComGetMsg("BKG00235", "SHPR_STE_CD"));
						formObj.shpr_ste_cd.select();
						return false;
					}
				}
			break;
			case "shpr_cnt_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y' && ComIsEmpty(formObj.shpr_cnt_cd.value)){
//					alert("pod_cnty=" + pod_cnty + ", del_cnty=" + del_cnty + ", cnd_flg=" + cnd_flg + ", shpr_cnt_cd=" + formObj.shpr_cnt_cd.value);
					ComShowMessage(ComGetMsg("BKG00234", "SHPR_CNT_CD"));
					formObj.shpr_cnt_cd.select();
					return false;
				}
			break;
			case "shpr_zip_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;

				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.shpr_cnt_cd.value == "CA" || formObj.shpr_cnt_cd.value == "US") && ComIsEmpty(formObj.shpr_zip_cd.value)){
						ComShowMessage(ComGetMsg("BKG08238", "SHPR_ZIP_CD"));
						formObj.shpr_zip_cd.select();
						return false;
					}
				}			
			break;
			case "cnee_cty_nm":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우 (DEL이 CA인 경우 조건에서 제외) - 2012.06.11 이병동 대리
				if(pod_cnty == 'CA' && cnd_flg == 'Y'){
					if(ComIsEmpty(formObj.cnee_cty_nm.value)){
						ComShowMessage(ComGetMsg("BKG00234", "CNEE_CTY_NM"));
						formObj.cnee_cty_nm.select();
						return false;
					}
				}
			break;
			case "cnee_ste_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우 (DEL이 CA인 경우 조건에서 제외) - 2012.06.11 이병동 대리
				if(pod_cnty == 'CA' && cnd_flg == 'Y'){
					if((formObj.cnee_cnt_cd.value == "CA" || formObj.cnee_cnt_cd.value == "US") && ComIsEmpty(formObj.cnee_ste_cd.value)){
						ComShowMessage(ComGetMsg("BKG00235", "CNEE_STE_CD"));
						formObj.cnee_ste_cd.select();
						return false;
					}
				}

			break;
			case "cnee_cnt_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우 (DEL이 CA인 경우 조건에서 제외) - 2012.06.11 이병동 대리
				if(pod_cnty == 'CA' && cnd_flg == 'Y'){
					if(ComIsEmpty(formObj.cnee_cnt_cd.value)){
						ComShowMessage(ComGetMsg("BKG00236", "CNEE_CNT_CD"));
						formObj.cnee_cnt_cd.select();
						return false;
					}
				}
			break;
			case "cnee_zip_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우 (DEL이 CA인 경우 조건에서 제외) - 2012.06.11 이병동 대리
				if(pod_cnty == 'CA' && cnd_flg == 'Y'){
					if((formObj.cnee_cnt_cd.value == "CA" || formObj.cnee_cnt_cd.value == "US") && ComIsEmpty(formObj.cnee_zip_cd.value)){
						ComShowMessage(ComGetMsg("BKG08238", "CNEE_ZIP_CD"));
						formObj.cnee_zip_cd.select();
						return false;
					}
				}
			break;
			case "noti_cty_nm":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(ComIsEmpty(formObj.noti_cty_nm.value)){
							ComShowMessage(ComGetMsg("BKG00234", "NOTI_CTY_NM"));
							formObj.noti_cty_nm.select();
							return false;
						}
					}
				}
			break;
			
			case "noti_ste_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(formObj.noti_cnt_cd.value == "CA" || formObj.noti_cnt_cd.value == "US"){
							if(ComIsEmpty(formObj.noti_ste_cd.value)){
								ComShowMessage(ComGetMsg("BKG00235", "NOTI_STE_CD"));
								formObj.noti_ste_cd.select();
								return false;
							}
						}
					}
				}
			break;
			
			case "noti_cnt_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(ComIsEmpty(formObj.noti_cnt_cd.value)){
							ComShowMessage(ComGetMsg("BKG00236", "NOTI_CNT_CD"));
							formObj.noti_cnt_cd.select();
							return false;
						}
					}
				}
			break;			
			case "noti_zip_cd":
				var formObj = document.form;
				
				var por_cnty = (formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty = (formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty = (formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty = (formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg  = formObj.cnd_flg.value;
				// POD 또는 DEL이 CA인 경우 또는 Canada FROB인 경우
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(formObj.noti_cnt_cd.value == "CA" || formObj.noti_cnt_cd.value == "US"){
							if(ComIsEmpty(formObj.noti_zip_cd.value)){
								ComShowMessage(ComGetMsg("BKG08238", "NOTI_ZIP_CD"));
								formObj.noti_zip_cd.select();
								return false;
							}
						}
					}
				}
			break;
        }		
    }

	function sheet1_OnClick(sheetObj, row, col, val){
		var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			case "cntr_no":
				var hbl_seq = document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
				var cntr_mf_no = sheetObjects[2].CellValue(idxArr[0], "cntr_mf_no");
				//showAndHideCM
				showAndHideCM(val, cntr_mf_no);
				//calculatePackage
				calculatePackage();
			break;
		}
	}

	function sheet2_OnChange(sheetObj, row, col, val){
		// 데이터 변경 여부 체크
		document.form.dirty_flag.value = 'Y'

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
		//
		var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "pck_qty":
				calculatePackage();
			break;

			case "cntr_mf_wgt":
				calculatePackage();
			break;

			case "meas_qty":
				calculatePackage();
			break;
		}
	}

	function sheet2_OnPopupClick(sheetObj, row, col){
		var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "PCKPop":
				comBkgCallPop0696("callbackPckTp2", sheetObj.CellValue(row, "pck_tp_cd"));
			break;

			case "MDPop":
				var frm = document.form2;
				var width = 400;
				var height = 390;
				var left = (screen.width-width)/2;
				var top = (screen.height-height)/2;
				var win = window.open("", "ESM_BKG_0706", "width="+width+",height="+height+",left="+left+",top="+top+",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
				frm.mk_desc.value = sheetObj.CellValue(row, "cntr_mf_mk_desc");
				frm.gds_desc.value = sheetObj.CellValue(row, "cntr_mf_gds_desc");
				frm.func.value = "callbackMFDesc";
				frm.action = "ESM_BKG_0706.do";
				frm.method = "POST"
				frm.target = "ESM_BKG_0706";
				frm.submit();

			break;

			case "HTCPop":
				//var cmdt_hs_cd = document.form.cmdt_hs_cd.value;
				//var url = "ESM_BKG_0607.do?cmdt_hs_cd="+cmdt_hs_cd;
				//ComOpenWindowCenter(url, "ESM_BKG_0607" , 1024, 530, false);
				comBkgCallPop0607("callbackHTSCode", 'T', sheetObj.CellValue(row, "hamo_trf_cd"));
			break;

			case "NCMPop":
				// BKG Commodity가 F.A.K/Console/Mixed Cargo 일때는 제외하고 BKG commodity 6자리를 넘겨서 Pop-Up(ESM_BKG_0745)을 호출한다.
				var sUrl = "ESM_BKG_0745_P.do?page_gubun=popup";
	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 530, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(row, 'ncm_no') = rtnVal.cd;
	  			}
			break;

		} // end switch
	}

	/* --------------------------------------------------------------------
	 * Functions
	 ---------------------------------------------------------------------- */
	function changeComboDataByHbl(){
		var sheetObj = sheetObjects[2];
		var comboObj = document.form.hbl_seq;
		var ttlCount = document.form.hbl_ttl_knt;

		// remove all combo-data
		var clen = (comboObj==null) ? 0 : comboObj.length;
		for(ic=0;ic<clen;ic++){
			comboObj.remove(clen-1-ic);
		}

		var tcnt = 0;
		var rkey = '';
		var rval = '';
		var rcnt = sheetObj.RowCount;
		for (ix = 1; ix <= rcnt; ix++) {
			if(sheetObj.RowStatus(ix) != 'D'){
				rval = sheetObj.CellValue(ix, "seq");
				rkey = sheetObj.CellValue(ix, "hbl_seq");
				//alert(rval +" / "+ rkey);
				comboObj.add(new Option(rval, rkey));
				tcnt++;
			}
		}

		ttlCount.value = tcnt;

	}

	function changeViewDataByHbl(hbl_seq){	
		// make empty
		//ComMakeEmptyForm(document.form, "dirty_flag,bkg_sts_cd,bdr_flg,ca_flg,cnd_flg,org_cntr_mf_no,bkg_no,bl_no,bl_tp_cd,por_cd,pol_cd,pod_cd,del_cd,usa_cstms_file_cd,cnd_cstms_file_cd,hbl_ttl_knt");
		with (document.form) {
			cntr_mf_no.value = '';
			hbl_no.value = '';
			ida_iec_no.value = '';
			hbl_mf_tp_cd.value = '';
			shpr_nm.value = '';
			shpr_addr.value = '';
			shpr_cty_nm.value = '';
			shpr_ste_cd.value = '';
			shpr_cnt_cd.value = '';
			shpr_zip_cd.value = '';
			cnee_nm.value = '';    
			cnee_addr.value = '';  
			cnee_cty_nm.value = '';
			cnee_ste_cd.value = '';
			cnee_cnt_cd.value = '';
			cnee_zip_cd.value = '';
			noti_nm.value = '';
			noti_addr.value = '';
			noti_cty_nm.value = '';
			noti_ste_cd.value = '';
			noti_cnt_cd.value = '';
			noti_zip_cd.value = '';
			bl_mk_desc.value = '';
			bl_gds_desc.value = '';
			pck_qty.value = '';
			pck_tp_cd.value = '';
			hbl_wgt.value = '';
			wgt_ut_cd.value = '';
			cmdt_meas_qty.value = '';
			cmdt_meas_ut_cd.value = '';
			cm_pck_qty.value = '';
			cm_wgt_qty.value = '';
			cm_meas_qty.value = '';		
			bk_pck_qty.value = '';
			bk_pck_qty.value = '';
			bk_pck_qty.value = '';			
		}
		//
		if(hbl_seq>0){
			var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
			if(idxArr.length == 0) return; 
			// row number
			var row = idxArr[0];
			// set focus
			sheetObjects[2].SelectCell(row, 2, false); 
			// Container Filtering
			//ComShowAndHideSheet(sheetObjects[0], "hbl_seq", sheetObjects[2].CellValue(row, "hbl_seq"));
			//ComRenumberSeq(sheetObjects[0], "seq");
			var cntr_mf_no = sheetObjects[2].CellValue(row, "cntr_mf_no");
			var cm_flg = 0;
			var xcnt = sheetObjects[0].RowCount;
			for(xn=1; xn <= xcnt; xn++){
				cm_flg = getCMFlag(sheetObjects[0].CellValue(xn, "cntr_no"), cntr_mf_no);
				sheetObjects[0].CellValue2(xn, "cntr_mf_flag") = (cm_flg==0) ? 'N' : 'Y';
			}
			// Container Manifest Filtering
			var cntr_no = '';
			if(sheetObjects[0].RowCount > 0){
				sheetObjects[0].SelectCell(1, "cntr_no", false);
				cntr_no = sheetObjects[0].CellValue(1, "cntr_no");
			}
			//alert("cntr_no    ->" + cntr_no + "\ncntr_mf_no ->" + cntr_mf_no)
			showAndHideCM(cntr_no, cntr_mf_no);	
			//calculatePackage
			//calculatePackage();
			// set HBL Info.
			ComCopyRowToForm(sheetObjects[2], row, document.form, '');
			// Manifest File Assign Enable
			if(ComIsEmpty(document.form.cntr_mf_no.value) && document.form.isInquiry.value == "N"){
				ComBtnEnable("btn_amsFileNoAssign");
			}else{
				ComBtnDisable("btn_amsFileNoAssign");
			}
			//
			document.form.pck_qty.value  = ComAddComma3(document.form.pck_qty.value, "#,###");
			document.form.hbl_wgt.value  = ComAddComma3(document.form.hbl_wgt.value, "#,###.000");
			document.form.cmdt_meas_qty.value = ComAddComma3(document.form.cmdt_meas_qty.value, "#,###.000");			
			//POD 또는 DEL 이 “CA”인 경우만 ACI Type 활성화.
			//   1) DEL=“CA”일 때 24: Import
			//   2) POD=“CA”이고 DEL≠“CA”  일 때 23: In-Transit 로 디폴트 설정 후 수정가능
			var pod = document.form.pod_cd.value.length > 2 ? document.form.pod_cd.value.substring(0, 2) : '';
			var del = document.form.del_cd.value.length > 2 ? document.form.del_cd.value.substring(0, 2) : '';
			if(pod == "CA" || del == "CA"){
				document.form.hbl_mf_tp_cd.disabled = false;
				if(document.form.hbl_mf_tp_cd.value == ''){
					if(del == "CA"){
						document.form.hbl_mf_tp_cd.value = "24";
					}else{
						document.form.hbl_mf_tp_cd.value = "23";
					}
				}
			}else{
				document.form.hbl_mf_tp_cd.disabled = true;
			}			
			
			
		}
	}

	function showAndHideCM(cntr_no, cntr_mf_no){
		var rseq = 1;
		var rsts = '';
		var rcnt = sheetObjects[1].RowCount;
		for(rn=1; rn <= rcnt; rn++){
			rsts = sheetObjects[1].RowStatus(rn);
			if(sheetObjects[1].RowStatus(rn) != 'D' && 
			   sheetObjects[1].CellValue(rn, "cntr_no") == cntr_no &&
			   sheetObjects[1].CellValue(rn, "cntr_mf_no") == cntr_mf_no){
				sheetObjects[1].CellValue2(rn, "seq") = rseq++;
				sheetObjects[1].RowStatus(rn) = rsts;
				sheetObjects[1].RowHidden(rn) = false;
			}else{
				sheetObjects[1].RowHidden(rn) = true;
			}
		}	
	}
	
	function getCMFlag(cntr_no, cntr_mf_no){
		var cm_cnt = 0;
		var rcnt = sheetObjects[1].RowCount;
		for(rn=1; rn <= rcnt; rn++){
			rsts = sheetObjects[1].RowStatus(rn);
			if(sheetObjects[1].RowStatus(rn) != 'D' && 
			   sheetObjects[1].CellValue(rn, "cntr_no") == cntr_no &&
			   sheetObjects[1].CellValue(rn, "cntr_mf_no") == cntr_mf_no){
				cm_cnt = 1;
				break;
			}
		}
		return cm_cnt;
	}

	function calculatePackage(){
		var sheetObj = sheetObjects[1];
		var formObj  = document.form;
		
		var pSum = 0;
		var wSum = 0;
		var mSum = 0;
		var pBkgSum = 0;
		var wBkgSum = 0;
		var mBkgSum = 0;
		var icnt = sheetObj.RowCount;
		//var amount = Math.round(parseFloat(val1) * parseFloat(val2) * 100)/100;
		for (ix = 1; ix <= icnt; ix++) {
			if(sheetObj.RowStatus(ix) != 'D') {
				if(sheetObj.RowHidden(ix) == false){
					pSum += parseInt(sheetObj.CellValue(ix, "pck_qty"));
					wSum += parseFloat(sheetObj.CellValue(ix, "cntr_mf_wgt"));
					mSum += parseFloat(sheetObj.CellValue(ix, "meas_qty"));
				}

				if(sheetObj.CellValue(ix, "cntr_mf_no") == formObj.cntr_mf_no.value) {
					pBkgSum += parseInt(sheetObj.CellValue(ix, "pck_qty"));
					wBkgSum += parseFloat(sheetObj.CellValue(ix, "cntr_mf_wgt"));
					mBkgSum += parseFloat(sheetObj.CellValue(ix, "meas_qty"));
				}
			}
		}
		/* 부동 소수점 문제 해결
		 * 2010.09.07 김태경  
		 * */
		mBkgSum = Math.round(parseFloat(mBkgSum)* 1000)/1000;
		wBkgSum = Math.round(wBkgSum* 1000)/1000;
		
		formObj.cm_pck_qty.value  = ComAddComma3(''+pSum, "#,###");
		formObj.cm_wgt_qty.value  = ComAddComma3(''+wSum, "#,###.000");
		formObj.cm_meas_qty.value = ComAddComma3(''+mSum, "#,###.000");
		formObj.bk_pck_qty.value  = ComAddComma3(''+pBkgSum, "#,###");
		formObj.bk_wgt_qty.value  = ComAddComma3(''+wBkgSum, "#,###.000");
		formObj.bk_meas_qty.value = ComAddComma3(''+mBkgSum, "#,###.000");
	}

	function rollbackData(){
		// CM Grid
		var rcnt = sheetObjects[1].RowCount;
		for(ir = 1; ir <= rcnt; ir++){
			for(ic = 0; ic <= sheetObjects[1].LastCol; ic++){
				var orgVal = sheetObjects[1].CellSearchValue(ir, ic);
				if (orgVal != sheetObjects[1].CellValue(ir, ic)){
					sheetObjects[1].CellValue2(ir, ic) = orgVal;
				}							
			}		
		}
		// HBL Grid
		var ir = sheetObjects[2].SelectRow ;
		for(ic = 0; ic <= sheetObjects[2].LastCol; ic++){
			var orgVal = sheetObjects[2].CellSearchValue(ir, ic);
			if (orgVal != sheetObjects[2].CellValue(ir, ic)){
				sheetObjects[2].CellValue2(ir, ic) = orgVal;
			}							
		}
	}

	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	
	function callbackSplit(returnVal){
		//alert(returnVal);
		if(!ComIsEmpty(returnVal)){
			var hbl_seq = document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
			var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
			sheetObjects[2].CellValue2(idxArr[0], "org_cntr_mf_no") = returnVal;
			document.form.org_cntr_mf_no.value = returnVal;
		}
	}

	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		document.form.pck_tp_cd.value = returnVal[0][3];
		var hbl_seq = document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
		var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
		sheetObjects[2].CellValue2(idxArr[0], "pck_tp_cd") = returnVal[0][3];
	}

	function callbackPckTp2(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][3];
	}

	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_mk_desc") = mk_desc;
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_gds_desc") = gds_desc;
	}

	function callbackHTSCode(returnValue){
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "hamo_trf_cd") = returnValue[0][3];
	}

	function callbackCopyHbl(returnVal){
		var sheetObj = sheetObjects[2];
		var sel_row = sheetObj.SelectRow;
		//alert("* Copy HBL : " + sel_row + " -> " + returnVal);
		for(ir=0;ir<returnVal;ir++){
			var max_seq = ComGetMaxValue(sheetObj, "hbl_seq");
			var new_row = sheetObj.DataInsert(-1);
			var col_name = ''
			//alert("* Max Seq : " + max_seq + " -> " + (max_seq+1));
			for(ic=0;ic<=sheetObj.LastCol;ic++){
				col_name = sheetObj.ColSaveName(ic);
				if(col_name == "ibflag"         ||
				   col_name == "seq"            ||
				   col_name == "hbl_no"         ||
				   col_name == "cntr_mf_no"     ||
				   col_name == "org_cntr_mf_no" ||
				   col_name == "hbl_mf_tp_cd"   ||
				   col_name == "ida_iec_no") continue;
				if(col_name == "hbl_seq") sheetObj.CellValue2(new_row, ic) = max_seq + 1;
				else sheetObj.CellValue2(new_row, ic) = sheetObj.CellValue(sel_row, ic);
			}
		}
		//
		changeComboDataByHbl();
		// change View Data
		changeViewDataByHbl(sheetObj.CellValue(sel_row, "hbl_seq"));
		//calculatePackage
		calculatePackage();		
		// 수정 여부 기록
		document.form.dirty_flag.value = 'Y';
	}
	
	function callbackHblTmplt(rd_target, cstm_arr, desc_cstm_arr){
		//alert("* target : " + rd_target + "\n " +
		//	  "* customer("+cstm_arr.length+") : " + cstm_arr + "\n" +
		//	  "* description("+desc_cstm_arr.length+") : " + desc_cstm_arr);
		var formObj = document.form;
		var hbl_seq = formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
		var idxArr = ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
		if(cstm_arr != null && cstm_arr.length > 0){
			if(rd_target == 'B' || rd_target == 'S'){
				formObj.shpr_nm.value = cstm_arr[0];
				formObj.shpr_addr.value = cstm_arr[1];
				sheetObjects[2].CellValue2(idxArr[0], "shpr_nm") = cstm_arr[0];
				sheetObjects[2].CellValue2(idxArr[0], "shpr_addr") = cstm_arr[1];
			}
			if(rd_target == 'B' || rd_target == 'C'){
				formObj.cnee_nm.value = cstm_arr[2];
				formObj.cnee_addr.value = cstm_arr[3];
				sheetObjects[2].CellValue2(idxArr[0], "cnee_nm") = cstm_arr[2];
				sheetObjects[2].CellValue2(idxArr[0], "cnee_addr") = cstm_arr[3];
			}
			// 수정 여부 기록
			formObj.dirty_flag.value = 'Y';
		}
		
		if(desc_cstm_arr != null && desc_cstm_arr.length > 0 && sheetObjects[0].SelectRow > 0){
			for(rx=0;rx<desc_cstm_arr.length;rx++){
				var arr = desc_cstm_arr[rx];
				var nrow = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].CellValue2(nrow, "bkg_no") = formObj.bkg_no.value;
				sheetObjects[1].CellValue2(nrow, "cntr_no") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cntr_no");
				sheetObjects[1].CellValue2(nrow, "cntr_mf_no") = formObj.cntr_mf_no.value;
				sheetObjects[1].CellValue2(nrow, "cntr_mf_gds_desc") = arr[0];
				sheetObjects[1].CellValue2(nrow, "hamo_trf_cd") = arr[1];
			}
			// 수정 여부 기록
			formObj.dirty_flag.value = 'Y';
		}
	}

	function copyCm(fmCntr, toCntrArr){
		if(fmCntr == '' || toCntrArr == ''){
			return;
		}
		//alert(fmCntr + " => " + toCntrArr)
		var tgtCnt = toCntrArr.length;
		//alert("tgtCnt==>" + tgtCnt)
		var cArr = ComFindText(sheetObjects[1], "cntr_no", fmCntr);
		//alert("cArr==>" + cArr)
		for(ix=0;ix<tgtCnt;ix++){
			//alert("\ttgt" +ix+ ". "+ toCntrArr[ix]);
			for(ir=0;ir<cArr.length;ir++) {
				var nRow = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowHidden(nRow) = true;
				for(ic = 0; ic <=  sheetObjects[1].LastCol; ic++){
					if(sheetObjects[1].ColSaveName(ic) == "ibflag") continue;
					if(sheetObjects[1].ColSaveName(ic) == "cntr_no"){
						sheetObjects[1].CellValue2(nRow, ic) = toCntrArr[ix];
					}else{
						sheetObjects[1].CellValue2(nRow, ic) = sheetObjects[1].CellValue(cArr[ir], ic);
					}
				}
			}
		}
	}

	/* 탭이동 시 화면의 데이타 변경여부 체크 */
	function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
			if(ComShowCodeConfirm("BKG00350")){
//				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[2], formObj, IBSAVE);
			}
		}
	}

	function searchData(bkgNo){
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
	}
	
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_addHBl");
			ComBtnDisable("btn_deleteHBl");
			ComBtnDisable("btn_copyHBl");
			ComBtnDisable("btn_copyCM");
			ComBtnDisable("btn_amsFileNoAssign");
			ComBtnDisable("btn_hbl_tmplt");			
			ComBtnDisable("btn_add");			
			ComBtnDisable("btn_delete");			
			ComBtnDisable("btn_t9CopyMnd");			
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
	 
	 /*
	    * TextArea 글자수,Row수 제한 Validation 체크
	    * @param rows : 최대Row수
	    * @param cols : 한Row에 표시될 최대글자수
	    * @param obj : Textarea Object
	    * @author 김병규
	    * @version 2009.09.01
	    */
	     function validateCol(rows, cols, obj, custTp){
	         var str       = obj.value;
	         var displayText;
	         var parseCols = parseInt(cols);
	         var rowArr = str.split("\n");

	         for(var i =0 ; i < rowArr.length ; i++){
	             if(countLineBreaks(rowArr[i]) > 0){
	                 if(rowArr[i].length > parseCols+1){
	                     var loopCnt;
	                     if(rowArr[i].length%parseCols > 0){
	                         loopCnt = rowArr[i].length/parseCols + 1;
	                     }else{
	                         loopCnt = rowArr[i].length/parseCols;
	                     }
	                     for(var j = 0 ; j < Math.floor(loopCnt) ; j++){
	                         if(i < 1){
	                             if(j < 1){
	                                 displayText = rowArr[i].substring(0,parseCols*(j+1));
	                             }else{
	                                 displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
	                             }
	                         }else{
	                             displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
	                         }
	                     }
	                     if(countLineBreaks(displayText) > 0){
	                         displayText = displayText.substring(0,displayText.length-1);
	                     }
	                 }else{
	                     if(i < 1){
	                         displayText = rowArr[i];
	                     }else{
	                         displayText = displayText + "\n" + rowArr[i];
	                     }
	                 }
	             }else{
	                 if(rowArr[i].length > parseCols){
	                     var loopCnt;
	                     if(rowArr[i].length%parseCols > 0){
	                         loopCnt = rowArr[i].length/parseCols + 1;
	                     }else{
	                         loopCnt = rowArr[i].length/parseCols;
	                     }
	                     for(var j = 0 ; j < Math.floor(loopCnt) ; j++){
	                         if(i < 1){
	                             if(j < 1){
	                                 displayText = rowArr[i].substring(0,parseCols*(j+1));
	                             }else{
	                                 displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
	                             }
	                         }else{
	                             displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
	                         }
	                     }
	                 }else{
	                     if(i < 1){
	                         displayText = rowArr[i];
	                     }else{
	                         displayText = displayText + "\n" + rowArr[i];
	                     }
	                 }
	             }
	         }

	         var enterCnt = countLineBreaks(displayText);
//	         if(rows-1 < enterCnt){
//	             ComShowCodeMessage("BKG02006", custTp, rows);
//	             obj.focus();
//	             obj.value = displayText;
//	             return false;
//	         }else{
	             obj.value = displayText;
//	         }
	         return true;
	     }
	/* 개발자 작업  끝 */
