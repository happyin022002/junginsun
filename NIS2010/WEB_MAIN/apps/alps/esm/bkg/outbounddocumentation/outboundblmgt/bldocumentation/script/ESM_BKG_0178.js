/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0178.js
*@FileTitle : C/M by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
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
     * @class esm_bkg_0178 : esm_bkg_0178 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0178() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "dcgo_flg":
				case "bb_cgo_flg":
				case "awk_cgo_flg":
				case "rc_flg":
				case "rd_cgo_flg":
				case "hngr_flg":
					return false;
				break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;

				case "btn_new":
					resetPage();
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;

				case "btn_cntrlist":
					var vvd = formObject.t_vvd.value;
					var ofc_cd = formObject.bkg_ofc_cd.value;
					var pol = formObject.pol_cd.value;
					var pod = formObject.pod_cd.value;

					var url = "ESM_BKG_0892.do?func=callbackCntr&bkg_vvd="+vvd+"&bkg_ofc_cd="+ofc_cd+"&bkg_pol="+pol+"&bkg_pod="+pod;
					ComOpenWindow(url, "ESM_BKG_0892", "width=400,height=370", true);
				break;

				case "btn_add":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
				break;

				case "btn_del":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
				break;

				case "btn_copy":
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
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
		}

		// search init value
		if(document.form.cntr_no.value != ''){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}

        //add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);		
        axon_event.addListenerForm('change', 'form1_change', document.form);
        
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
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(25, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|C|Seq.|Booking No.|B/L No.|B/L No.|BDR|Issued|Cntr|Package|Package|Weight|Weight|Measure|Measure|Ratio|R/D|R/D|DG|AK|HG|POR|DEL|Commodity|Commodity";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,      30,    daCenter,    false,    "mf_cfm_flg");
                    InitDataProperty(0, cnt++, dtSeq,           40,    daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++, dtData,          90,    daLeft,      false,    "bkg_no",         false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,    daLeft,      false,    "bl_no",          false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          20,    daCenter,    false,    "bl_tp_cd",       false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          30,    daCenter,    false,    "bdr_flg",        false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          46,    daCenter,    false,    "obl_iss_flg",    false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtHidden,        90,    daLeft,      false,    "cntr_no",        false,    "",    dfNone,         0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,          50,    daRight,     false,    "pck_qty",        false,    "",    dfInteger,      0,    false,    false, 7);
                    InitDataProperty(0, cnt++, dtData,          30,    daCenter,    false,    "pck_tp_cd",      false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          70,    daRight,     false,    "cntr_wgt",       false,    "",    dfFloat    ,    3,    false,    false, 13);
                    InitDataProperty(0, cnt++, dtData,          30,    daCenter,    false,    "wgt_ut_cd",      false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          70,    daRight,     false,    "meas_qty",       false,    "",    dfFloat    ,    3,    false,    false, 9);
                    InitDataProperty(0, cnt++, dtData,          30,    daCenter,    false,    "meas_ut_cd",     false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          40,    daCenter,    false,    "cntr_vol_qty",   false,    "",    dfFloat,        2,    false,    false, 3);

                    InitDataProperty(0, cnt++, dtData,          20,    daCenter,    false,    "rcv_term_cd",    false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          20,    daCenter,    false,    "de_term_cd",     false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtCheckBox,      20,    daCenter,    false,    "dcgo_flg",       false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtCheckBox,      20,    daCenter,    false,    "awk_cgo_flg",    false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtCheckBox,      20,    daCenter,    false,    "hngr_flg",       false,    "",    dfNone,         0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,          50,    daCenter,    false,    "por_cd",         false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          50,    daCenter,    false,    "del_cd",         false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          50,    daCenter,    false,    "cmdt_cd",        false,    "",    dfNone,         0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         250,    daLeft,      false,    "cmdt_nm",        false,    "",    dfNone,         0,    false,    false);

                    CountPosition = 0;

			   }
			break;


            case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Seq.|BkgNo|CntrNo|MF Seq.|RDTerm|RDTerm|Package|Package|Package|Weight|Weight|Measure|Measure|Marks|Marks|Description|DG|AK|HG";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,  30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,   40,    daCenter,    false,    "sel");
                    InitDataProperty(0, cnt++,  dtData,         40,    daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++,  dtHidden,       80,    daRight,     false,    "bkg_no",             false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtHidden,       80,    daRight,     false,    "cntr_no",            false,    "",    dfNone,    0,    true,    true);
					InitDataProperty(0, cnt++,  dtHidden,       80,    daRight,     false,    "cntr_mf_seq",        false,    "",    dfNone,    0,    true,    true);
					InitDataProperty(0, cnt++,  dtHidden,       80,    daRight,     false,    "rcv_term_cd",        false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtHidden,       80,    daRight,     false,    "de_term_cd",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtData,         90,    daRight,     false,    "pck_qty",            false,    "",    dfInteger, 0,    true,    true, 7);
                    InitDataProperty(0, cnt++,  dtData,         40,    daCenter,    false,    "pck_tp_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,    false,    "PCKPop",             false,    "",    dfNone,    0,    true,    true);

                    InitDataProperty(0, cnt++,  dtData,         120,   daRight,     false,    "cntr_mf_wgt",        false,    "",    dfFloat,   3,    true,    true, 13);
                    InitDataProperty(0, cnt++,  dtHidden,       100,   daRight,     false,    "wgt_ut_cd",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtData,         120,   daRight,     false,    "meas_qty",           false,    "",    dfFloat,   3,    true,    true, 9);
                    InitDataProperty(0, cnt++,  dtHidden,       100,   daRight,     false,    "meas_ut_cd",         false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtData,         150,   daCenter,    false,    "cntr_mf_mk_desc",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtPopup,         20,   daCenter,    false,    "MDPop",              false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtData,         200,   daLeft,      false,    "cntr_mf_gds_desc",   false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtCheckBox,      30,   daCenter,    false,    "dcgo_flg",           false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtCheckBox,      30,   daCenter,    false,    "awk_cgo_flg",        false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,  dtCheckBox,      30,   daCenter,    false,    "hngr_flg",           false,    "",    dfNone,    0,    true,    true);

                    ShowButtonImage = 2;

					AutoRowHeight = false;
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
                    formObj.f_cmd.value = SEARCH;
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_0178GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
										
                    var arrXml = rXml.split("|$$|");

					if(arrXml.length==2){
						var cmCntrXml  = arrXml[0];
						var cmDescXml  = arrXml[1];
						// CM Container Info
						sheetObjects[0].LoadSearchXml(cmCntrXml, false);
						sheetObjects[1].LoadSearchXml("<SHEET><DATA TOTAL='0'/></SHEET>", false);
						if(sheetObjects[0].TotalRows > 0){
							// CM Booking Info
							ComEtcDataXmlToForm(cmCntrXml, formObj);
							formObj.pck_qty.value = ComAddComma3(formObj.pck_qty.value, "#,###");
							formObj.cntr_wgt.value = ComAddComma3(formObj.cntr_wgt.value, "#,###.000");
							formObj.meas_qty.value = ComAddComma3(formObj.meas_qty.value, "#,###.000");							
							//
							var sealNos = ComGetEtcData(cmCntrXml, "cntr_seal_no");
							if(sealNos != undefined && sealNos != ''){
								var seal_arr = (sealNos.indexOf(',') == -1) ? new Array(sealNos) : sealNos.split(',');
								ComArrayToOptions(seal_arr, formObj.cntr_seal_no);
							}
							// CM Cntr MF Info
							sheetObjects[1].LoadSearchXml(cmDescXml, false);
							// bdr_flag = 'Y'
							var rcnt = sheetObjects[0].RowCount;
							for(rn=1;rn<=rcnt;rn++){
								if (sheetObjects[0].CellValue(rn, "bdr_flg") == 'Y') {
									sheetObjects[0].CellFontColor(rn, "bkg_no") = sheetObjects[0].RgbColor(0, 0, 255);
								}
							}							
							//sheetObjects[0].SelectCell(1, "bkg_no", false);
							formObj.bkg_no.value = sheetObjects[0].CellValue(1, "bkg_no");
							// change view/hide
							setCMInfo(1);
							//changeEditable
							changeEditable();								
							
						}
					}else{
						return;
					}
				}
			break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					// form param
					var sParam = FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					// Sheet2 param
					var sParamSheet2 = sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					// return xML
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0178GS.do", sParam);
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction 상태 복원 */
						sheetObjects[0].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						/* 성공메세지 */
						ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
					}
				}
			break;

			case IBINSERT:      // 입력
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bkg_no") == ''){
					return;
				}
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bdr_flg") == 'Y'){
					ComShowMessage(ComGetMsg("BKG08003"));
					return;
				}
				var nRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(nRow, "bkg_no") = formObj.bkg_no.value;
				sheetObj.CellValue2(nRow, "cntr_no") = formObj.cntr_no.value;
				sheetObj.CellValue2(nRow, "rcv_term_cd") = formObj.rcv_term_cd.value;
				sheetObj.CellValue2(nRow, "de_term_cd") = formObj.de_term_cd.value;
				//changeEditable
				changeEditable();
				//setSeq
				setSeq();
			break;

			case IBDELETE:      // 삭제
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bdr_flg") == 'Y'){
					ComShowMessage(ComGetMsg("BKG08003"));
					return;
				}
				ComRowHideDelete(sheetObj, "sel", true)
				//changeEditable
				//changeEditable();
				//setSeq
				setSeq();
			break;

			case IBCOPYROW:      // 복사
				var cp_cnt = formObj.cp_cnt.value
				for(ix=0;ix<cp_cnt;ix++){
					sheetObj.DataCopy();
				}
				// setSeq
				setSeq();
			break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

		switch(sAction) {

			case IBSEARCH:
				/*
				1. Container No가 없는 경우 메시지 [BKG00753] 표시후 리턴
				2. VVD가 없는 경우 메시지 [BKG00754] 표시후 리턴
				*/
				with(formObj){
					if(cntr_no.value == ''){
						ComShowMessage(ComGetMsg("BKG00753"));
						cntr_no.focus();
						return false;
					}
					if(t_vvd.value == ''){
						ComShowMessage(ComGetMsg("BKG00754"));
						t_vvd.focus();
						return false;
					}
				}
			break;

			case IBSAVE:
				/*
				1. Container No가 없는 경우 메시지 [BKG00753] 표시후 리턴
				2. VVD가 없는 경우 메시지 [BKG00754] 표시후 리턴
				*/
				with(formObj){
					if(cntr_no.value == ''){
						ComShowMessage(ComGetMsg("BKG00753"));
						cntr_no.focus();
						return false;
					}
					if(t_vvd.value == ''){
						ComShowMessage(ComGetMsg("BKG00754"));
						t_vvd.focus();
						return false;
					}
					// bdr flag
					//if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bdr_flg")=='Y'){
					//	ComShowMessage(ComGetMsg("BKG00335"));
					//	return false;
					//}
				}
				var rCnt = sheetObjects[1].RowCount;
				for(rn=1;rn <= rCnt;rn++){
					//1. Package Qty, Package Type, Customs Description이 없을 경우 각각 [BKG00504],[BKG00505],[BKG00510] 메시지 표시 후 리턴
					if(sheetObjects[1].CellValue(rn, "pck_qty") == ''){
						ComShowMessage(ComGetMsg("BKG00504"));
						return false;
					}
					if(sheetObjects[1].CellValue(rn, "pck_tp_cd") == ''){
						ComShowMessage(ComGetMsg("BKG00505"));
						return false;
					}
					if(sheetObjects[1].CellValue(rn, "cntr_mf_gds_desc") == ''){
						ComShowMessage(ComGetMsg("BKG00510"));
						return false;
					}
					//Package Qty는 BB가 아니면 0보다 큰 값만 허용. BB의 경우 0 입력가
					if(sheetObjects[1].CellValue(rn, "pck_qty") == 0 && !formObj.bb_cgo_flg.checked){
						ComShowMessage(ComGetMsg("BKG00504"));
						return false;
					}
				}
			break;

		} // end switch

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

        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "bkg_no":
				//retrieveSplitNo();
            break;
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
		//document.form.dirty_flag.value = 'Y'

        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "bkg_no":

            break;
        }
    }


	
	// 조회 함수
	function sheet1_OnClick(sheetObj, row, col, val) {
		document.form.bkg_no.value = sheetObj.CellValue(row, "bkg_no");

        if(sheetObj.ColSaveName(col) != "mf_cfm_flg") {
			// change view/hide
			setCMInfo(row);
			//changeEditable
			changeEditable();
		}

	}

	function sheet1_OnChange(sheetObj, row, col, val){

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "mf_cfm_flg":
				/*
				1. Check 할 경우 변경된 Row의 CM Total Package/Weight/Measure 및 Package type 중 하나라도 BKG와 다를 경우 메시지 [BKG00752] 표시하고 'Yes'를 선택한 경우 BKG의 Package/Weight/Measure 및 Package Type을 변경
				Package type이 여러개일 경우 PK 로 변경
				2. Check 할 경우 CM 그리드 및 Row Add, Delete 버튼 비활성화, Uncheck 하고 BDR이 안된 경우 CM 그리드 및 Row Add, Delete 버튼 활성화
				*/
				//
				// change view/hide
				setCMInfo(row);				
				//changeEditable
				changeEditable();
				// validation
				if(val == 1){
					//var bkg_pck_qty   = ComTrimAll(document.form.pck_qty.value, ",");
					//var bkg_wgt_qty   = ComTrimAll(document.form.cntr_wgt.value, ",");
					//var bkg_meas_qty  = ComTrimAll(document.form.meas_qty.value, ",");
					//var cm_pck_qty    = ComColumnSum(sheetObjects[1], "pck_qty");
					//var cm_wgt_qty    = ComColumnSum(sheetObjects[1], "cntr_mf_wgt");
					//var cm_meas_qty   = ComColumnSum(sheetObjects[1], "meas_qty");
					var bkg_pck_qty   = sheetObjects[0].CellValue(row, "pck_qty");
					var bkg_wgt_qty   = sheetObjects[0].CellValue(row, "cntr_wgt");
					var bkg_meas_qty  = sheetObjects[0].CellValue(row, "meas_qty");
					var cm_pck_qty    = ComColumnSum(sheetObjects[1], "pck_qty", true);
					var cm_wgt_qty    = ComColumnSum(sheetObjects[1], "cntr_mf_wgt", true);
					var cm_meas_qty   = ComColumnSum(sheetObjects[1], "meas_qty", true);
					if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty){
						if(confirm(ComGetMsg("BKG00752"))) {
							sheetObjects[0].CellValue2(row, "pck_qty") = ComColumnSum(sheetObjects[1], "pck_qty", true);
							sheetObjects[0].CellValue2(row, "cntr_wgt") = ComColumnSum(sheetObjects[1], "cntr_mf_wgt", true);
							sheetObjects[0].CellValue2(row, "meas_qty") = ComColumnSum(sheetObjects[1], "meas_qty", true);
							document.form.pck_qty.value = ComAddComma3(ComColumnSum(sheetObjects[1], "pck_qty"), "#,###");
							document.form.cntr_wgt.value = ComAddComma3(ComColumnSum(sheetObjects[1], "cntr_mf_wgt"), "#,###.000");
							document.form.meas_qty.value = ComAddComma3(ComColumnSum(sheetObjects[1], "meas_qty"), "#,###.000");
						}else{
							return false;
						}
					}
				}
			break;

		} // end switch
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var rCnt = sheetObj.RowCount;
		//alert("rCnt : " + rCnt);
		for(ir=1;ir<=rCnt;ir++){
			//alert("bdr_flg : " + sheetObj.CellValue(ir, "bdr_flg") );
			if (sheetObj.CellValue(ir, "bdr_flg") == 'Y') {
				sheetObj.CellFontColor(ir, "bkg_no") = sheetObj.RgbColor(0, 0, 255);
			}
		}		
		
		// BKG중 하나라도 BDR 또는 Issue 상태이면 Save Block
		var rcnt = sheetObjects[0].RowCount;
		var saveCheck = false;
		for(rn = 1; rn <= rcnt; rn++){
			var bdrFlg = sheetObjects[0].CellValue(rn, "bdr_flg");//document.form.bdr_flg.value
			var issFlg = sheetObjects[0].CellValue(rn, "obl_iss_flg");		

			if(bdrFlg == 'Y' || issFlg == 'Y'){
				saveCheck = true;
			}
		}

		if(saveCheck){
			ComBtnDisable("btn_save");
		} else {
			ComBtnEnable("btn_save");
		}
	}

	function sheet2_OnChange(sheetObj, row, col, val){
		// 'obl_iss_flg'가 'Y'일 경우 'BKG08003'

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "pck_qty":
				document.form.cm_pck_qty.value = ComAddComma3(ComColumnSum(sheetObj, "pck_qty", true), "#,###");
			break;

			case "cntr_mf_wgt":
				document.form.cm_cntr_wgt.value = ComAddComma3(ComColumnSum(sheetObj, "cntr_mf_wgt", true), "#,###.000");
			break;

			case "meas_qty":
				document.form.cm_meas_qty.value = ComAddComma3(ComColumnSum(sheetObj, "meas_qty", true), "#,###.000");
			break;

		} // end switch
	}

	function sheet2_OnPopupClick(sheetObj, row, col){
		//alert(sheetObj.id + " -> " + sheetObj.ColSaveName(col));

        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {

			case "PCKPop":
				//var url = "ESM_BKG_0696.do";
				//ComOpenWindow(url, "ESM_BKG_0696", "width=400,height=389", false);
				comBkgCallPop0696("callbackPckTp", sheetObj.CellValue(row, "pck_tp_cd"));
			break;

			case "MDPop":
				//var mk_desc = sheetObj.CellValue(row, "cntr_mf_mk_desc");
				//var gds_desc = sheetObj.CellValue(row, "cntr_mf_gds_desc");
				//var callback_func = "callbackMFDesc";
				//var url = "ESM_BKG_0706.do?func="+callback_func+"&mk_desc="+mk_desc+"&gds_desc="+gds_desc;
				//ComOpenWindowCenter(url, "ESM_BKG_0706", 400, 389, true);

				var frm = document.form2;
				var win = window.open("","ESM_BKG_0706","toolbar=0,location=0,status=0,menubar=0,scrollbars=0,resizable=0,width=400,height=389");
				frm.mk_desc.value = sheetObj.CellValue(row, "cntr_mf_mk_desc");
				frm.gds_desc.value = sheetObj.CellValue(row, "cntr_mf_gds_desc");
				frm.func.value = "callbackMFDesc";
				frm.action = "ESM_BKG_0706.do";
				frm.method = "POST"
				frm.target = "ESM_BKG_0706";
				frm.submit();

			break;

		} // end switch
	}


	function setCMInfo(row){
		//alert(row + ". BkgNo : " + sheetObjects[0].CellValue(row, "bkg_no"));
		if(row > 0) {
			// retrieve CM
			ComShowAndHideSheet(sheetObjects[1], "bkg_no", sheetObjects[0].CellValue(row, "bkg_no"));
			//setSeq
			setSeq();
			//get total
			document.form.cm_pck_qty.value = ComAddComma3(ComColumnSum(sheetObjects[1], "pck_qty", true), "#,###");
			document.form.cm_cntr_wgt.value = ComAddComma3(ComColumnSum(sheetObjects[1], "cntr_mf_wgt", true), "#,###.000");
			document.form.cm_meas_qty.value = ComAddComma3(ComColumnSum(sheetObjects[1], "meas_qty", true), "#,###.000");			
		}
	}


	function setSeq(){
		var rSeq = 1;
		var rCnt = sheetObjects[1].RowCount;
		for (rn = 1; rn <= rCnt; rn++) {
			var rsts = sheetObjects[1].RowStatus(rn);
			if(rsts != 'D' && sheetObjects[1].RowHidden(rn) == false){
				sheetObjects[1].CellValue2(rn, "seq") = rSeq++;
				sheetObjects[1].RowStatus(rn) = rsts;
			}
		}
	}

	function changeEditable(){
		var dcFlg = (document.form.dcgo_flg != undefined && document.form.dcgo_flg.checked);
		var bbFlg = (document.form.bb_cgo_flg != undefined && document.form.bb_cgo_flg.checked);
		var akFlg = (document.form.awk_cgo_flg != undefined && document.form.awk_cgo_flg.checked);
		var rcFlg = (document.form.rc_flg != undefined && document.form.rc_flg.checked);
		var rdFlg = (document.form.rd_cgo_flg != undefined && document.form.rd_cgo_flg.checked);
		var hgFlg = (document.form.hngr_flg != undefined && document.form.hngr_flg.checked);
		document.form.dcgo_flg.disabled    = !dcFlg;
		document.form.bb_cgo_flg.disabled  = !bbFlg;
		document.form.awk_cgo_flg.disabled = !akFlg;
		document.form.rc_flg.disabled      = !rcFlg;
		document.form.rd_cgo_flg.disabled  = !rdFlg;
		document.form.hngr_flg.disabled    = !hgFlg;

		var rcnt = sheetObjects[1].RowCount;
		for(rn = 1; rn <= rcnt; rn++){
			sheetObjects[1].CellEditable(rn, "dcgo_flg") = dcFlg;
			sheetObjects[1].CellEditable(rn, "awk_cgo_flg") = akFlg;
			sheetObjects[1].CellEditable(rn, "hngr_flg") = hgFlg;
		}

		var cfmFlg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "mf_cfm_flg");
		var bdrFlg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bdr_flg");//document.form.bdr_flg.value
		var issFlg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "obl_iss_flg");

		if(cfmFlg == 1){
			sheetObjects[1].Editable = false;
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_del");
		}else{
			sheetObjects[1].Editable = true;
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_del");
		}
	}
	
	function resetPage(){
		document.form.reset();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		var comboObj = document.form.cntr_seal_no;
		var clen = (comboObj==null) ? 0 : comboObj.length;
		for(ic=0;ic<clen;ic++){
			comboObj.remove(clen-1-ic);
		}		
	}

	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][3];
	}

	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_mk_desc") = mk_desc;
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cntr_mf_gds_desc") = gds_desc;
	}
	
	function callbackCntr(cntr_no, t_vvd){
		/*
		var len = rtnArr.length;
		for(i=0;i<len;i++){
			//alert(rtnArr[i]);
			var cntr_no = rtnArr[i][0]; 
			var cntr_tp_sz = rtnArr[i][1]; 
			var cntr_mf_flg = rtnArr[i][2]; 
		}
		*/
		
		//alert(cntr_no +" / "+ t_vvd);
		document.form.cntr_no.value = cntr_no;
		document.form.t_vvd.value = t_vvd;
		
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}

	/* 개발자 작업  끝 */

