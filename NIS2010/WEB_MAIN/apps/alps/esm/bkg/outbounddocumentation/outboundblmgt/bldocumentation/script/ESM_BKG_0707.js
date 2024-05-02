/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0707.js
*@FileTitle : Mark And Description for C/M
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
     * @class esm_bkg_0707 : esm_bkg_0707 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0707() {
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
	var callback_func = '';

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		//var sheetObject1 = sheetObjects[0];

        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_OK":
					//alert("btn_OK");
					var pck_cmdt_desc = formObject.pck_cmdt_desc.value;
					var cntr_cmdt_desc = formObject.cntr_cmdt_desc.value;
					var dg_cmdt_desc = formObject.dg_cmdt_desc.value;
					var cm_cstms_desc = '';
					if(formObject.cntr_knt.value == 1 && sheetObjects[0].RowCount == 1){
						//alert("* cntr_knt=" + formObject.cntr_knt.value + ", cm_knt=" + sheetObjects[0].RowCount + " -> " + sheetObjects[0].CellValue(1, "cntr_mf_gds_desc"));
						cm_cstms_desc = sheetObjects[0].CellValue(1, "cntr_mf_gds_desc");
					}

					if(!opener) opener = window.dialogArguments;
					if(callback_func != ''){
						eval('opener.'+callback_func)(pck_cmdt_desc, cntr_cmdt_desc, dg_cmdt_desc, cm_cstms_desc);
					}
                //break;

            	case "btn_Close":
					window.close();
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

		// set init-data for sheets
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
		}

		//add listener
		//axon_event.addListenerForm('focus', 'form1_focus', document.form);
		//axon_event.addListenerForm('blur', 'form1_blur', document.form);
		//axon_event.addListenerForm('change', 'form1_change', document.form);
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|Seq.|CntrNo|PckQty|PckTp|WgtQty|WgtUt|Desc|HTS Code|HS Code|NCM Code|MeasQty|MeasUt";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,  cnt++,  dtHiddenStatus,  20,    daCenter,  false,    "ibflag");
                    InitDataProperty(0,  cnt++,  dtSeq,           20,    daCenter,  false,    "seq");
                    InitDataProperty(0,  cnt++,  dtData,          90,    daLeft,    false,    "cntr_no",          false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          80,    daCenter,  false,    "pck_qty",          false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          40,    daLeft,    false,    "pck_tp_cd",        false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          80,    daCenter,  false,    "cntr_mf_wgt",      false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          40,    daLeft,    false,    "wgt_ut_cd",        false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          160,   daCenter,  false,    "cntr_mf_gds_desc", false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          160,   daLeft,    false,    "hamo_trf_cd",      false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          160,   daLeft,    false,    "cmdt_hs_cd", 	  false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          160,   daLeft,    false,    "ncm_no",		 	  false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          80,    daCenter,  false,    "meas_qty",         false,   "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,  cnt++,  dtData,          40,    daLeft,    false,    "meas_ut_cd",       false,   "",         dfNone,     0,          false,      false);
				}
			break;
		}
	}

	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0707GS.do", FormQueryString(formObj));
					//var rXml = sheetObj.GetSearchXml("ESM_BKG_0707GS.do", FormQueryString(formObj));
					//ComEtcDataXmlToForm(rXml, formObj);
					formObj.pck_cmdt_desc.value = sheetObj.EtcData("pck_cmdt_desc");
					formObj.cntr_cmdt_desc.value = sheetObj.EtcData("cntr_cmdt_desc");
					formObj.cntr_knt.value = sheetObj.EtcData("cntr_knt");
					formObj.dg_cmdt_desc.value = getGoodsDesc();
				}
			break;
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }

	function getGoodsDesc(){
		var sheetObj = sheetObjects[0];
		var goodsDesc = '';
		var rCnt = sheetObj.RowCount;
		//alert("* rCnt : " + rCnt);
		if(rCnt == 0) {
			// do nothing!
		} else if(rCnt == 1) {
			goodsDesc += sheetObj.CellValue(1, "cntr_no") + ": \n";
			goodsDesc += ComLpad(sheetObj.CellValue(1, "pck_qty"), 7, " ") + " " +
			             sheetObj.CellValue(1, "pck_tp_cd") + " / " +
			             sheetObj.CellValue(1, "cntr_mf_wgt") + " " +
			             sheetObj.CellValue(1, "wgt_ut_cd") + ", "
			             if (sheetObj.CellValue(1, "meas_qty") != 0){
							 goodsDesc += sheetObj.CellValue(1, "meas_qty") + " " 
							 			+ sheetObj.CellValue(1, "meas_ut_cd") + ", ";
						 }
			goodsDesc += sheetObj.CellValue(1, "cntr_mf_gds_desc").split('\n').join('');
						 if (sheetObj.CellValue(1, "hamo_trf_cd") != '' && sheetObj.CellValue(1, "hamo_trf_cd") != null){
							 goodsDesc += ", HTS Code " + sheetObj.CellValue(1, "hamo_trf_cd");
						 } 
						 if (sheetObj.CellValue(1, "cmdt_hs_cd") != '' && sheetObj.CellValue(1, "cmdt_hs_cd") != null) {
							 goodsDesc += ", HS Code " + sheetObj.CellValue(1, "cmdt_hs_cd");
						 }
						 if (sheetObj.CellValue(1, "ncm_no") != '' && sheetObj.CellValue(1, "ncm_no") != null) {
							 goodsDesc += ", NCM Code " + sheetObj.CellValue(1, "ncm_no") + "\n";
						 }else {
							 goodsDesc += "\n";
						 }
		} else {
			var tmpCntr = '';
			for(ir=1;ir<=rCnt;ir++){
				if(tmpCntr!=sheetObj.CellValue(ir, "cntr_no")){
					goodsDesc += sheetObj.CellValue(ir, "cntr_no") + ": \n";
					tmpCntr = sheetObj.CellValue(ir, "cntr_no");
				}
				goodsDesc += ComLpad(sheetObj.CellValue(ir, "pck_qty"), 7, " ") + " " +
							 sheetObj.CellValue(ir, "pck_tp_cd") + " / " +
							 sheetObj.CellValue(ir, "cntr_mf_wgt") + " " +
							 sheetObj.CellValue(ir, "wgt_ut_cd") + ", "
							 if (sheetObj.CellValue(ir, "meas_qty") != 0){
								 goodsDesc += sheetObj.CellValue(ir, "meas_qty") + " " 
								 			+ sheetObj.CellValue(ir, "meas_ut_cd") + ", ";
							 }
				goodsDesc += sheetObj.CellValue(ir, "cntr_mf_gds_desc").split('\n').join('');
							 if (sheetObj.CellValue(ir, "hamo_trf_cd") != '' && sheetObj.CellValue(ir, "hamo_trf_cd") != null){
								 goodsDesc += ", HTS Code " + sheetObj.CellValue(ir, "hamo_trf_cd");
							 }
							 if (sheetObj.CellValue(ir, "cmdt_hs_cd") != '' &&  sheetObj.CellValue(ir, "cmdt_hs_cd") != null) {
								 goodsDesc += ", HS Code " + sheetObj.CellValue(ir, "cmdt_hs_cd");
							 }
							 if (sheetObj.CellValue(ir, "ncm_no") != '' && sheetObj.CellValue(ir, "ncm_no") != null) {
								 goodsDesc += ", NCM Code " + sheetObj.CellValue(ir, "ncm_no") + "\n";
							 }else {
								 goodsDesc += "\n";
							 }
			}
		}
		return goodsDesc;
	}

	/* 개발자 작업  끝 */
