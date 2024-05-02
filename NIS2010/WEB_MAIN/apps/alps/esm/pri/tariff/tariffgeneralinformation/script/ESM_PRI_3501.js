/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3501.js
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.13 김민아
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
     * @class ESM_PRI_3501 : ESM_PRI_3501 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3501() {
    	this.processButtonClick         = tprocessButtonClick;
    	this.setSheetObject             = setSheetObject;
    	this.setComboObject             = setComboObject;
    	this.loadPage                   = loadPage;
    	this.initSheet                  = initSheet;
    	this.initCombo                  = initCombo;
    	this.doActionIBSheet            = doActionIBSheet;
    	this.validateForm               = validateForm;
    }

   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;
	
	//저장 메세지를 구분하기 위해 사용됨.
	var supressConfirm = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김민아
     * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObjects[0],formObject,IBCREATE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;

				case "btn_amend":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY01);
					break;

				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
					
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY02);
					break;
					
				case "btn_request":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY03);
					break;

				case "btn_approve":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY04);
					break;
					
				case "btn_cancel":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY06);
					break;

				case "btn_publish":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY05);
					break;

				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
					break;

				case "btn_rowdelete1":
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
					break;
					
				case "btn_amend1":
					doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
					break;
					
				case "btn_amendcancel1":
					doActionIBSheet(sheetObjects[1],formObject,COMMAND03);
					break;
					
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[2],formObject,IBINSERT);
					break;

				case "btn_rowdelete2":
					doActionIBSheet(sheetObjects[2],formObject,IBDELETE);
					break;
					
				case "btn_amend2":
					doActionIBSheet(sheetObjects[2],formObject,COMMAND02);
					break;
					
				case "btn_amendcancel2":
					doActionIBSheet(sheetObjects[2],formObject,COMMAND03);
					break;
					
	            case "btns_calendar1": //달력버튼
	            	if(!document.getElementById(srcName).disabled){
		                var cal = new ComCalendar();                
		                cal.select(document.form.eff_dt, 'yyyy-MM-dd');
	            	}
	                break; 
	                
	            case "btns_calendar2": //달력버튼
	            	if(!document.getElementById(srcName).disabled){
		                var cal = new ComCalendar();                
		                cal.select(document.form.exp_dt, 'yyyy-MM-dd');
	            	}
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

	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 김민아
	 * @version 2010.10.13
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 김민아
     * @version 2010.10.13
     */      
    function setComboObject(combo_obj){
	        comboObjects[comboCnt++] = combo_obj;
	    }

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 김민아
    * @version 2010.10.13
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        
   	 	var formObj = document.form;
        if (formObj.trf_no.value != "") {//다른 화면에서 호출,Tariff General Information Inquiry에서 조회
           doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
           comboObjects[0].text2 = formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value;
           doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
       } else {
    	   doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
       }
	}


    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김민아
     * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
     	switch(sheetID) {
         	case "sheet1":
         		with (sheetObj) {
         			/*
                     // 높이 설정
                     style.height = 100;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     */

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|TRF_PFX_CD|TRF_NO|TRF_NM|TRF_ORZ_NM|TRF_ORZ_TP_NM|AMDT_SEQ|TRF_BZC_STS_CD|TRF_BZC_STS_NM|EFF_DT|EXP_DT|PUB_DT|CRE_DT|UPD_DT|"
                    	 			+"RQST_OFC_CD|CRE_USR_ID|APRO_OFC_CD|TRF_BZC_TP_CD|TRF_BZC_WGT|TRF_BZC_WGT_UT_CD|TRF_BZC_VOL_QTY|TRF_BZC_VOL_UT_CD|CURR_CD|"
                    	 			+"PUB_CNTC_PSON_NM|PUB_OFC_ADDR|PUB_OFC_PHN_NO|PUB_OFC_CTY_NM|PUB_OFC_STE_CD|PUB_OFC_ZIP_CD|PUB_OFC_CNT_NM|PUB_OFC_FAX_NO|PRE_PUB_DT|TRF_INLND_FLG|ROUT_UPD_DT|APRO_USR_FLG";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,	"trf_pfx_cd",			false,	"",	dfNone, 	0,     false,	false,	10);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter,	true,	"trf_no",  				false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter,	true,	"trf_nm",     			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter,	true,	"trf_orz_nm",  			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter,	true,	"trf_orz_tp_nm",     	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"amdt_seq",     		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"trf_bzc_sts_cd",     	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"trf_bzc_sts_nm",     	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"eff_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"exp_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"pub_dt",  				false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"cre_dt",     			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,    90,   	daCenter, 	true,	"upd_dt",     			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"rqst_ofc_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"cre_usr_id",      		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"apro_ofc_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"trf_bzc_tp_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"trf_bzc_wgt",      	false,	"",	dfNullFloat,3,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"trf_bzc_wgt_ut_cd",	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"trf_bzc_vol_qty",      false,	"",	dfNullFloat,3,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"trf_bzc_vol_ut_cd",	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,  	90,   	daCenter, 	true,	"curr_cd",      		false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,	90,   	daCenter, 	true,	"pub_cntc_pson_nm",     false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,   	daCenter, 	true,	"pub_ofc_addr",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_phn_no",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_cty_nm",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_ste_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_zip_cd",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_cnt_nm",      	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	90,   	daCenter, 	true,	"pub_ofc_fax_no",      	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"pre_pub_dt",  			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	30,  	daCenter, 	true,	"trf_inlnd_flg",		false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	30,  	daCenter, 	true,	"rout_upd_dt",			false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	30,  	daCenter, 	true,	"apro_usr_flg",			false,	"",	dfNone,		0,     false,	false);
                     
	                 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet2":
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 150;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 5, 100);

                     var HeadTitle = "|Sel.|Seq.|TRF_PFX_CD|TRF_NO|AMDT_SEQ|ORG_DEST_TP_CD|TRF_BZC_ROUT_PNT_SEQ|TRF_BZC_ROUT_PNT_TP_CD|Origin|Origin Description|N1ST_CMNC_AMDT_SEQ|Source|UPD_DT";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	false,	"seq",						false,	"",	dfNone,		0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"trf_pfx_cd",				false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	true,	"trf_no",  					false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		10,  	daCenter,	false,	"amdt_seq",  				false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		10,  	daCenter,	false,	"org_dest_tp_cd",  			false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	false,	"trf_bzc_rout_pnt_seq",     false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	false,	"trf_bzc_rout_pnt_tp_cd",	false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtPopupEdit,	100,  	daCenter,	false,	"trf_bzc_rout_pnt_def_cd",  true,	"",	dfNone,  	0,     true,	true,	 2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200,  	daLeft, 	false,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		10,  	daLeft, 	false,	"n1st_cmnc_amdt_seq",  		false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		70,  	daCenter, 	false,	"src_info_cd",     			false,	"",	dfNone,  	0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,    	10,   	daCenter, 	true,	"upd_dt",     				false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");
                     InitDataValid(0,  "trf_bzc_rout_pnt_def_cd",	vtEngUpOnly);		// 영문대문자만 입력
                     
                     ShowButtonImage	= 2;	// 항상 팝업 이미지 표시
                     ImageList(0) = "img/btns_search_off.gif";
                     ImageList(1) = "img/btns_search.gif";
                     
                     WaitImageVisible = false;
         		}
              	break;
              	
         	case "sheet3":
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 150;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 5, 100);

                     var HeadTitle = "|Sel.|Seq.|TRF_PFX_CD|TRF_NO|AMDT_SEQ|ORG_DEST_TP_CD|TRF_BZC_ROUT_PNT_SEQ|TRF_BZC_ROUT_PNT_TP_CD|Destination|Destination Description|N1ST_CMNC_AMDT_SEQ|Source|UPD_DT";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	"seq",						false,	"",	dfNone,		0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"trf_pfx_cd",				false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	true,	"trf_no",  					false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	true,	"amdt_seq",  				false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		10,  	daCenter,	true,	"org_dest_tp_cd",  			false,	"",	dfNone,		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	true,	"trf_bzc_rout_pnt_seq",     false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daCenter,	true,	"trf_bzc_rout_pnt_tp_cd",	false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtPopupEdit,	100,  	daCenter,	true,	"trf_bzc_rout_pnt_def_cd",  true,	"",	dfNone,  	0,     true,	true,	 2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200,  	daLeft, 	true,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,  	daLeft, 	true,	"n1st_cmnc_amdt_seq",  		false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		70,  	daCenter, 	true,	"src_info_cd",     			false,	"",	dfNone,  	0,     false,	false,	-1,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,    	10,   	daCenter, 	true,	"upd_dt",     				false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");
                     InitDataValid(0,  "trf_bzc_rout_pnt_def_cd",	vtEngUpOnly);		// 영문대문자만 입력
                     
                     ShowButtonImage	= 2;	// 항상 팝업 이미지 표시
                     ImageList(0) = "img/btns_search_off.gif";
                     ImageList(1) = "img/btns_search.gif";
                     
                     WaitImageVisible = false
         		}
              	break;
     	}
	}
	
    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김민아
     * @version 2010.10.13
     */        
    function initCombo(comboObj, comboNo) {

    	switch(comboObj.id) {     
	    	case "tariff_cd":
//	            var i=0;
	            with(comboObj) {
	                //UseEdit = true;
	                //BackColor = "cyan";
	                DropHeight = 200;
	                MultiSelect = false;
	                MaxSelect = 1;
	                IMEMode = 0;
	                UseAutoComplete = true;
	                ValidChar(1, 3);
	                MaxLength = 8;
	            }
	            break;
            case "apro_ofc_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 6;
                }
                break;
            case "trf_bzc_tp_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 2;
                }
                break; 
            case "trf_bzc_wgt_ut_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
//                    MaxLength = 6;
                }
                break; 
            case "trf_bzc_vol_ut_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
//                    MaxLength = 6;
                }
                break;
            case "curr_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 3;
                }
                break;
        }
    }
    
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김민아
     * @version 2010.10.13
     */ 	    
     function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);                      
//        axon_event.addListenerFormat ('blur', 'obj_OnBlur', document.form);
        
     }
     
     /**
      * OnBeforeActivate   event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_activate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 김민아
      * @version 2010.10.13
      */   
      function obj_activate() {
          var srcName = event.srcElement.getAttribute("name");
          ComClearSeparator (event.srcElement);
      }
     
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_deactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 김민아
      * @version 2010.10.13
      */   
      function obj_deactivate() {
          var formObj = document.form;
          var sheetObj = sheetObjects[0];   
          var eleName = event.srcElement.name;
          
    	  //한글체크
    	  if(chkIsNaH(eleName)){
    		  document.getElementById(eleName).value = "";
      		  return false;
    	  }

          switch(eleName){
              case "trf_pfx_cd":    
                  break;
              case "trf_no":     
                  break;
              case "trf_nm":
                  break;          
              case "trf_orz_nm":
                  break;
              case "trf_orz_tp_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;          
              case "amdt_seq":
                  break;      
              case "trf_bzc_sts_cd": 
                  break;
                  
              case "cre_dt":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "eff_dt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;              
              case "exp_dt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;
              case "pub_dt":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "rqst_ofc_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;              
              case "cre_usr_id":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "apro_ofc_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
                  
              case "trf_bzc_tp_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "trf_bzc_wgt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;              
              case "trf_bzc_wgt_ut_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "trf_bzc_vol_qty":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;
              case "trf_bzc_vol_ut_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;              
              case "curr_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
                  
              case "pub_cntc_pson_nm":
          		  ComChkObjValid(event.srcElement)
          		  com_change_sheet( sheetObj, eleName );
                  break;
              case "pub_ofc_addr":
          		  com_change_sheet( sheetObj, eleName );
          		  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_phn_no":
              	//숫자 체크
              	if(chkIsNaN(eleName, "-")){
              		formObj.pub_ofc_phn_no.value = "";
              		formObj.pub_ofc_phn_no.focus();
              		return false;
              	}else{
            	  com_change_sheet( sheetObj, eleName );
              	}
                  break;              
              case "pub_ofc_cty_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_ste_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_zip_cd":
          		  com_change_sheet( sheetObj, eleName );
//                  ComChkObjValid(event.srcElement);
                  break;              
              case "pub_ofc_cnt_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_fax_no":
              	//숫자 체크
              	if(chkIsNaN(eleName, "-")){
              		formObj.pub_ofc_fax_no.value = "";
              		formObj.pub_ofc_fax_no.focus();
              		return false;
              	}else{
            	  com_change_sheet( sheetObj, eleName );
              	}
//                  ComChkObjValid(event.srcElement);
                  break;
              	
              default:
                  ComChkObjValid(event.srcElement);       
          }
          
      }
      
      /**
       * OnKeyPress event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 김민아
       * @version 2010.10.13
       */     
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
         	case "float":
         		//숫자+"." 입력가능
         		ComKeyOnlyNumber(event.srcElement, ".");
         		break;
         	case "eng":
         		//영문 대문자만 입력가능
         		ComKeyOnlyAlphabet("upper");
         		break;
         	case "num"://only zip code
         		//영문+숫자 입력가능
         		ComKeyOnlyAlphabet("num");
                break;
         	case "ymd":
         		//숫자+"-" 입력가능
         		ComKeyOnlyNumber(event.srcElement, "-");
         		break;
         	case "tel":
         		//숫자+"-" 입력가능
         		ComKeyOnlyNumber(event.srcElement, "-");
         		break;
         	default:
         }

     }
     
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 김민아
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
	 			case IBSEARCH: // 조회
	 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
	 					return false;
	                }
	  				ComOpenWait(true); //->waiting->start
		 			formObj.f_cmd.value = SEARCH01;
		 			var param = "f_cmd="       +formObj.f_cmd.value
		 					  + "&trf_pfx_cd=" +formObj.trf_pfx_cd.value
		 					  + "&trf_no="     +formObj.trf_no.value;
//		 			alert(param);
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3501GS.do", param);
	 				
	  				var arrXml = sXml.split("|$$|");
	  				if (arrXml.length > 0) {
	  					sheetObj.LoadSearchXml(arrXml[0]);
	  					// Tariff Code만 존재할 경우 Initial 셋팅 
	  					if(formObj.trf_bzc_sts_cd.value == "") formObj.trf_bzc_sts_cd.value = "Initial";
	  					if (arrXml.length > 1){
                        	sheetObjects[1].LoadSearchXml(arrXml[1]);
	  					}
	  					if (arrXml.length > 2){
                        	sheetObjects[2].LoadSearchXml(arrXml[2]);
	  					}
	  				}
	  				ComOpenWait(false); //->waiting->End
	  				//Form Disable/Enable 처리(Multi Combo 때문에 ComOpenWait(false); 이후에 셋팅해야 함 )
	  				formControl(sheetObj, formObj);
	  				
	  		 		// Status에 따른 버튼 Control
	  		 		if(formObj.trf_pfx_cd.value == "") buttonControl(""); // 화면 로드
	  		 		else buttonControl(sheetObj.CellValue(1,"trf_bzc_sts_cd"));
	  				
	 				break;
	 				
	            case IBSEARCH_ASYNC01: // Approval Office, Tariff Type, Weight Ton Unit, Volume Ton Unit, Currency 셋팅
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }

	    	        comboObjects[0].RemoveAll();
	    	        comboObjects[1].RemoveAll();
	    	        comboObjects[2].RemoveAll();
	    	        comboObjects[3].RemoveAll();
	    	        comboObjects[4].RemoveAll();
	    	        comboObjects[5].RemoveAll();
	    	        
	    	        //Tariff No
	    	        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
	    	        //Approval Office
	    	        ComPriTextCode2ComboItem(aproOfcCdComboValue, aproOfcCdComboText, getComboObject(comboObjects, 'apro_ofc_cd') ,"|","\t" );
	    			//Tariff Type
	    	        ComPriTextCode2ComboItem(trfBzcTpCdComboValue, trfBzcTpCdComboText, getComboObject(comboObjects, 'trf_bzc_tp_cd') ,"|","\t" );
	    	        //Weight Ton Unit
	    	        ComPriTextCode2ComboItem(trfBzcWgtUtCdComboValue, trfBzcWgtUtCdComboText, getComboObject(comboObjects, 'trf_bzc_wgt_ut_cd') ,"|","\t" );    	        
	    	        //Volume Ton Unit
	    	        ComPriTextCode2ComboItem(trfBzcVolUtCdComboValue, trfBzcVolUtCdComboText, getComboObject(comboObjects, 'trf_bzc_vol_ut_cd') ,"|","\t" );
	    	        //Currency
	    	        ComPriTextCode2ComboItem(currCdComboValue, currCdComboText, getComboObject(comboObjects, 'curr_cd') ,"|","\t" );
	                break;

	 			case IBCREATE: // New
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }
	                ComOpenWait(true); //->waiting->start
	                clearAllForms();
	                sheetObjects[0].RemoveAll();
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	                sheetObjects[0].DataInsert();
	                var sheetObj = sheetObjects[0];
//	                var formObj = document.form;
//	                sheetObj.CellValue2(1,"amdt_seq")= "0";
	                sheetObj.CellValue2(1,"trf_bzc_sts_cd") = "I";
	                sheetObj.CellValue2(1,"rqst_ofc_cd")= formObj.strofc_cd.value;
	                sheetObj.CellValue2(1,"cre_usr_id") = formObj.strusr_id.value;
	                sheet1_OnSearchEnd(sheetObj);
	                
	                // Status에 따른 버튼 Control
	  		 		if(formObj.trf_pfx_cd.value == "") buttonControl(""); // 화면 로드
	  		 		else buttonControl(sheetObj.CellValue(1,"trf_bzc_sts_cd"));
	  		 		ComOpenWait(false); //->waiting->End
	                
	  		 		//Form Disable/Enable 처리(Multi Combo 때문에 ComOpenWait(false); 이후에 셋팅해야 함 )
	                formDisableControl();
                    formObj.tariff_cd.focus();
					break;
	 				
				case IBSAVE: // Save
					if (!validateForm(sheetObjects[0],document.form,sAction)) {
					    return false;
					}
					//저장 확인 메세지
					if (!supressConfirm && !ComPriConfirmSave()) {
					    return false;
					}
					ComOpenWait(true); //->waiting->start
					
					formObj.f_cmd.value = MULTI01;
					var sParam = "";
					
					//amdt_seq가 존재하지 않을 경우 Status는 I로 셋팅한다
					if(formObj.hid_amdt_seq.value == ""){
						sheetObjects[0].RowStatus(1) = "I";
					}
					
					//서버로 넘길 값을 변수에 담는다(Html Objects), 
					var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					
					if (sheetObjects[0].IsDataModified && sParamSheet1 == "") { 
					    return;
					}                
					if (sParamSheet1 != "") {         	
						sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					
					var sParamSheet2 = sheetObjects[1].GetSaveString(true);
					
					if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
					    return;
					}                
					if (sParamSheet2 != "") {
					    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					
					var sParamSheet3 = sheetObjects[2].GetSaveString(true);
					
					if (sheetObjects[2].IsDataModified && sParamSheet3 == "") {
					    return;
					}                
					if (sParamSheet3 != "") {
					    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
					}
					
					sParam += "&f_cmd=" + formObj.f_cmd.value;
					
					var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_3501GS.do", sParam);                 
					sheetObjects[0].LoadSaveXml(sXml);  
					sXml = ComDeleteMsg(sXml);//저장완료 메세지 삭제 
					sheetObjects[1].LoadSaveXml(sXml);
					sXml = ComDeleteMsg(sXml);//저장완료 메세지 삭제 
					sheetObjects[2].LoadSaveXml(sXml); 
					
			        if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
			        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			        	ComOpenWait(false); //->waiting->End
						return true;
			        }else{
			        	ComOpenWait(false); //->waiting->End
						return false;
			        }
			        
					break;
					
				case MODIFY01: // Amend
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3518.do";
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3518", 450, 220, true);

					//ComDebug(rtnVal);
					
		            if (rtnVal) {
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
		            }				
					break;
					
				case MODIFY02: // Delete
					if (!validateForm(sheetObjects[0],document.form,sAction)) {
					    return false;
					}
					//저장 확인 메세지
					if (!ComPriConfirmDelete()) {
					    return false;
					}

	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY02;
					var sParam = "f_cmd="       +formObj.f_cmd.value
					           + "&trf_pfx_cd=" +formObj.trf_pfx_cd.value
 					           + "&trf_no="     +formObj.trf_no.value
 					           + "&amdt_seq="   +formObj.amdt_seq.value;
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        }
					ComOpenWait(false);
					break;
					
				case MODIFY03: // Request
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					//수정사항이 존재할경우 저장후 REQUEST 처리한다.
		 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
		 				if (ComShowCodeConfirm("PRI00006")) {
		 					supressConfirm = true;
							var rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
							supressConfirm = false;
						}
		   				
		   				if (!rslt) {
		   					return false;
		   				}
					}
					
					if (!ComShowCodeConfirm("PRI06001")) {
						return false;
					}
					
	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY03;
					sheetObjects[0].CellValue2(1,"trf_bzc_sts_cd") = "Q";
					var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					var sParam = sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].RowStatus(1) = "R";
					
					ComOpenWait(false);
					break;

				case MODIFY04: // Approve
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI06002")) {
						return false;
					}
					
	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY04;
					sheetObjects[0].CellValue2(1,"trf_bzc_sts_cd") = "A";
					var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					var sParam = sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].RowStatus(1) = "R";
					
					ComOpenWait(false);
					break;
					
				case MODIFY05: // Publish
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3505.do";
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3505", 500, 220, true);

					//ComDebug(rtnVal);
					
		            if (rtnVal) {
						doActionIBSheet(sheetObj,document.form,IBSEARCH);					
		            }				
					break;
					
				case MODIFY06: // Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI00015")) {
						return false;
					}
					
	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY06;
					if(sheetObjects[0].CellValue(1,"trf_bzc_sts_cd")=="Q"){
						sheetObjects[0].CellValue(1,"trf_bzc_sts_cd") = "I";
					}else if(sheetObjects[0].CellValue(1,"trf_bzc_sts_cd")=="A"){
						sheetObjects[0].CellValue(1,"trf_bzc_sts_cd") = "Q";
					}
					// amdtSeq가 0이 아닌 경우 Cancel 가능 -> 현재 amdtSeq는 삭제되고 이전 amdtSeq의 Publish 상태로 변경
					else if(sheetObjects[0].CellValue(1,"trf_bzc_sts_cd")=="I"){
						sheetObjects[0].CellValue(1,"trf_bzc_sts_cd") = "F";
					}
					
					var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					var sParam = sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].RowStatus(1) = "R";
					
			        ComOpenWait(false);
					break;
					
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				var amdt_seq = formObj.amdt_seq.value;
	 				
	 				var idx = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(idx, "trf_pfx_cd") = formObj.trf_pfx_cd.value;
					sheetObj.CellValue2(idx, "trf_no") = formObj.trf_no.value;
					sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
					if(sheetObj==sheetObjects[1]) sheetObj.CellValue2(idx, "org_dest_tp_cd") = "O";
					if(sheetObj==sheetObjects[2]) sheetObj.CellValue2(idx, "org_dest_tp_cd") = "D";
					sheetObj.CellValue2(idx, "trf_bzc_rout_pnt_tp_cd") = "C";
					sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
					sheetObj.CellValue2(idx, "src_info_cd") = "NW";
					
	 				if(amdt_seq != 0) sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
	 				
	 				//하이라이트처리
					changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.hid_amdt_seq.value);

					//하단버튼 컨트롤
					buttonControlBottom();
					sheetObj.SelectCell(idx, "trf_bzc_rout_pnt_def_cd");
	 				break;

	 			case IBDELETE: // Delete
	 				var amdt_seq = formObj.amdt_seq.value;
					var sel_row  = sheetObj.SelectRow;
					
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length==0) sheetObj.CellValue2(sel_row, "chk")="1";
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					
					// 선택된 ROW 중 Delete 불가능한 row가 하나라도 존재하면 return
					for(i=0 ; i<chkArr.length ; i++){
						if(amdt_seq == sheetObj.CellValue(chkArr[i], "amdt_seq") && amdt_seq == sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")
								&& (sheetObj.CellValue(chkArr[i], "src_info_cd") == "AM" || sheetObj.CellValue(chkArr[i], "src_info_cd") == "AD")){
							ComShowCodeMessage("PRI01002");//Please check valid row
							return false;
						}
					}
					
					var tRow = 0;
					for(i=0 ; i<chkArr.length ; i++){
						if(sheetObj.CellValue(parseInt(chkArr[i])+tRow, "n1st_cmnc_amdt_seq")!= amdt_seq){
							setSheetAmendRow(sheetObj,formObj,parseInt(chkArr[i])+tRow,"AD");
							tRow++;
						}
					}
					
					deleteRowCheck(sheetObj, "chk");
					
					//하단버튼 컨트롤
					buttonControlBottom();
					break;
					
				case COMMAND02: // Amend
					
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length > 0){
						if(chkArr.length > 1) ComShowCodeMessage("PRI00310");
						else setSheetAmendRow(sheetObj,formObj,chkArr[0],"AM");
					} else setSheetAmendRow(sheetObj,formObj,"","AM");
					
					//하단버튼 컨트롤
					buttonControlBottom();
					sheetObj.SelectCell(sheetObj.SelectRow, "trf_bzc_rout_pnt_def_cd");
				
					break;
					
				case COMMAND03: // Amend Cancel
					var sel_row = sheetObj.SelectRow;
					
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length > 0){
						if(chkArr.length > 1) ComShowCodeMessage("PRI00310");
						else setSheetAmendRow(sheetObj,formObj,chkArr[0],"");
					} else setSheetAmendRow(sheetObj,formObj,"","");
	 				
	 				sheetObj.SelectCell(sel_row-1, "trf_bzc_rout_pnt_def_cd");
	 				
	 				//하단버튼 컨트롤
					buttonControlBottom();
					
					break;
					
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		}finally {
 			 ComOpenWait(false);
 		}
 	}
 	

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 김민아
     * @version 2010.10.13
     */
 	function validateForm(sheetObj, formObj, sAction) {

 		switch (sAction) {
 		case IBSEARCH: // 조회
			if (ComIsEmpty(comboObjects[0].Text)) {
				ComPriInputValueFailed("select","Tariff Code",comboObjects[0]);
				return false;
			}
			break;

        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified||sheetObjects[2].IsDataModified){
                return ComPriClearChange;
            }
            break;
            
  		case IBINSERT: // Row Add
	  		if(formObj.tariff_cd.value == "" || formObj.amdt_seq.value == "") {
				return false;
			}
  			break;
  			
  		case IBDELETE: // Delete  	
  			if(formObj.tariff_cd.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			}
  			break;

        case IBSAVE: // Save
            var formObj = document.form;
            
//	        if(!ComChkValid(document.form)){
//	        	return false;
//	        }
            
            //콤보 필수입력 체크
            if (ComIsEmpty(comboObjects[0].Text)) {
                ComShowCodeMessage('PRI00316','Tariff Code'); 
                comboObjects[0].focus();
                return false;
            }
            
            if (formObj.eff_dt.value == ""){
            	ComShowCodeMessage('PRI00316','Effective Date'); 
            	formObj.eff_dt.focus();
                return false;
            }
            if (!ComChkObjValid(formObj.eff_dt)){ 
            	formObj.eff_dt.focus();
                return false;
            }
            
            if (ComIsEmpty(comboObjects[1].Text)) {
                ComShowCodeMessage('PRI00316','Approval Office');   
                comboObjects[1].focus();
                return false;
            }
            
            if (ComIsEmpty(comboObjects[2].Text)) {
                ComShowCodeMessage('PRI00316','Tariff Type');   
                comboObjects[2].focus();
                return false;
            }
        	if (formObj.trf_bzc_wgt.value == ""){
            	ComShowCodeMessage('PRI00316','Weight Ton'); 
            	formObj.trf_bzc_wgt.focus();
                return false;
        	}
        	if (!ComChkObjValid(formObj.trf_bzc_wgt)){
            	formObj.trf_bzc_wgt.focus();
                return false;
        	}
            if (ComIsEmpty(comboObjects[3].Text)) {
                ComShowCodeMessage('PRI00316','Weight Ton Unit');   
                comboObjects[3].focus();
                return false;
            }
        	if (formObj.trf_bzc_vol_qty.value == ""){
            	ComShowCodeMessage('PRI00316','Volume Ton'); 
            	formObj.trf_bzc_vol_qty.focus();
                return false;
        	}
        	if (!ComChkObjValid(formObj.trf_bzc_vol_qty)){
            	formObj.trf_bzc_vol_qty.focus();
                return false;
        	}
            if (ComIsEmpty(comboObjects[4].Text)) {
                ComShowCodeMessage('PRI00316','Volume Ton Unit');   
                comboObjects[4].focus();
                return false;
            }
            if (ComIsEmpty(comboObjects[5].Text)) {
                ComShowCodeMessage('PRI00316','Currency');   
                comboObjects[5].focus();
                return false;
            }

        	if (formObj.pub_cntc_pson_nm.value == ""){
            	ComShowCodeMessage('PRI00316','Contact');
            	formObj.pub_cntc_pson_nm.focus();
                return false;
        	}
        	if (formObj.pub_ofc_addr.value == ""){
            	ComShowCodeMessage('PRI00316','Address'); 
            	formObj.pub_ofc_addr.focus();
                return false;
        	}
        	if (formObj.pub_ofc_phn_no.value == ""){
            	ComShowCodeMessage('PRI00316','Phone'); 
            	formObj.pub_ofc_phn_no.focus();
                return false;
        	}
        	if (formObj.pub_ofc_cty_nm.value == ""){
            	ComShowCodeMessage('PRI00316','City'); 
            	formObj.pub_ofc_cty_nm.focus();
                return false;
        	}
//        	if (formObj.pub_ofc_ste_cd.value == ""){
//            	ComShowCodeMessage('PRI00316','State'); 
//            	formObj.pub_ofc_ste_cd.focus();
//                return false;
//        	}
//        	if (formObj.pub_ofc_zip_cd.value == ""){
//            	ComShowCodeMessage('PRI00316','Zip Code'); 
//            	formObj.pub_ofc_zip_cd.focus();
//                return false;
//        	}
        	if (formObj.pub_ofc_cnt_nm.value == ""){
            	ComShowCodeMessage('PRI00316','Country'); 
            	formObj.pub_ofc_cnt_nm.focus();
                return false;
        	}
//        	if (formObj.pub_ofc_fax_no.value == ""){
//            	ComShowCodeMessage('PRI00316','Fax'); 
//            	formObj.pub_ofc_fax_no.focus();
//                return false;
//        	}
            
            var effDt = sheetObjects[0].CellValue(1, "eff_dt");
            var expDt = sheetObjects[0].CellValue(1, "exp_dt");
            if (effDt != "" && expDt != ""){
            	if(effDt>expDt){
            		ComShowCodeMessage('PRI00346');
            		return false;
            	}
            }
            
            //Mandatory 필수 데이터 체크 && Tariff Scope Origin/Destination 중복 데이터 체크
            var sCol = "trf_bzc_rout_pnt_def_cd";//n1st_cmnc_amdt_seq
            var amdtSeq = formObj.amdt_seq.value;
            
            //1.Tariff Scope Origin 필수 데이터 체크
            var sParamSheet2 = sheetObjects[1].GetSaveString(true);
            if(sheetObjects[1].IsDataModified && sParamSheet2 == "") return false;
            //2.Tariff Scope Origin 중복 데이터 체크
            var dupIdx1 = ComPriAmendDupCheck(sheetObjects[1], sCol, amdtSeq)
            if(dupIdx1 != -1){
            	ComShowCodeMessage("PRI00342", "Tariff Scope Origin");
            	sheetObjects[1].SelectCell(dupIdx1, sCol);
            	return false;
            }
            //1.Tariff Scope Destination 필수 데이터 체크
            var sParamSheet3 = sheetObjects[2].GetSaveString(true);
            if(sheetObjects[2].IsDataModified && sParamSheet3 == "") return false;
            //2.Tariff Scope Destination 중복 데이터 체크
            var dupIdx2 = ComPriAmendDupCheck(sheetObjects[2], sCol, amdtSeq)
            if(dupIdx2 != -1){
            	ComShowCodeMessage("PRI00342", "Tariff Scope Destination");
            	sheetObjects[2].SelectCell(dupIdx2, sCol);
            	return false;
            }
            
            //수정된자료가 없다.
            if(!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified){
                ComShowCodeMessage('PRI00301'); //There is no data to save.
                return false;
            }
            
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사 : Main
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date 검사 : Tariff Scope
	        checkTpCd = "CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            break;
            
 		case MODIFY02: // Delete
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date 검사 : Tariff Scope
	        checkTpCd = "CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;

 		case MODIFY03: // Request
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
 			
            var effDt = sheetObjects[0].CellValue(1, "eff_dt");
            var expDt = sheetObjects[0].CellValue(1, "exp_dt");
            if (effDt != "" && expDt != ""){
            	if(effDt>expDt){
            		ComShowCodeMessage('PRI00346');
            		return false;
            	}
            }
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date 검사 : Tariff Scope
	        checkTpCd = "CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;

 		case MODIFY04: // Approve
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date 검사 : Tariff Scope
	        checkTpCd = "CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
			break;
			
 		case MODIFY06: // Cancel
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date 검사 : Tariff Scope
	        checkTpCd = "CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
			break;
 		}

 		return true;
 	}

/////////////////////// Sheet Event (S) ///////////////////////

 	/**
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		
 		// sheet에 조회된 내용을 form Object에 셋팅한다.
 		formObj.hid_amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
 		// Basic 정보가 존재하지 않을 경우 Default 셋팅
 		if(formObj.hid_amdt_seq.value == ""){
            sheetObj.CellValue2(1,"amdt_seq")= "0";
            sheetObj.CellValue2(1,"trf_bzc_sts_cd") = "I";
            sheetObj.CellValue2(1,"rqst_ofc_cd")= formObj.strofc_cd.value;
            sheetObj.CellValue2(1,"cre_usr_id") = formObj.strusr_id.value;
 		}
 		formObj.trf_nm.value = sheetObj.CellValue(1, "trf_nm");
 		formObj.trf_orz_nm.value = sheetObj.CellValue(1, "trf_orz_nm");
 		formObj.trf_orz_tp_nm.value = sheetObj.CellValue(1, "trf_orz_tp_nm");
 		formObj.amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
 		formObj.trf_bzc_sts_cd.value = sheetObj.CellValue(1, "trf_bzc_sts_nm");
 		formObj.trf_inlnd_flg.value  = sheetObj.CellValue(1, "trf_inlnd_flg");
 		
 		formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "cre_dt"), "ymd");
 		formObj.eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"), "ymd");
 		formObj.exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"), "ymd");
 		formObj.pub_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "pub_dt"), "ymd");
 		formObj.rqst_ofc_cd.value = sheetObj.CellValue(1, "rqst_ofc_cd");
 		formObj.cre_usr_id.value = sheetObj.CellValue(1, "cre_usr_id");
 		comboObjects[1].Code2 = sheetObj.CellValue(1, "apro_ofc_cd");
 		
 		comboObjects[2].Code2 = sheetObj.CellValue(1, "trf_bzc_tp_cd");
 		formObj.trf_bzc_wgt.value = sheetObj.CellText(1, "trf_bzc_wgt");
 		comboObjects[3].Code2 = sheetObj.CellValue(1, "trf_bzc_wgt_ut_cd");
 		formObj.trf_bzc_vol_qty.value = sheetObj.CellText(1, "trf_bzc_vol_qty");
 		comboObjects[4].Code2 = sheetObj.CellValue(1, "trf_bzc_vol_ut_cd");
 		comboObjects[5].Code2 = sheetObj.CellValue(1, "curr_cd");
 		
 		formObj.pub_cntc_pson_nm.value = sheetObj.CellValue(1, "pub_cntc_pson_nm");
 		formObj.pub_ofc_addr.value = sheetObj.CellValue(1, "pub_ofc_addr");
 		formObj.pub_ofc_phn_no.value = sheetObj.CellValue(1, "pub_ofc_phn_no");
 		formObj.pub_ofc_cty_nm.value = sheetObj.CellValue(1, "pub_ofc_cty_nm");
 		formObj.pub_ofc_ste_cd.value = sheetObj.CellValue(1, "pub_ofc_ste_cd");
 		formObj.pub_ofc_zip_cd.value = sheetObj.CellValue(1, "pub_ofc_zip_cd");
 		formObj.pub_ofc_cnt_nm.value = sheetObj.CellValue(1, "pub_ofc_cnt_nm");
 		formObj.pub_ofc_fax_no.value = sheetObj.CellValue(1, "pub_ofc_fax_no");
 	}
 	
 	/**
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
 	 */
 	function sheet2_OnSearchEnd(sheetObj, errMsg){
 		manageCellEditable (sheetObj);
 	}
 	
 	/**
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
 	 */
 	function sheet3_OnSearchEnd(sheetObj, errMsg){
 		manageCellEditable (sheetObj);
 	}
 	
	 /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
  	  * @author 김민아
  	  * @version 2010.10.13
     */
     function sheet2_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname = sheetObj.ColSaveName(Col);
      	switch(colname)
      	{
  	    	case "trf_bzc_rout_pnt_def_cd":
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?";
	  			sUrl += "location_cmd=C";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, Col)     = rtnVal.cd;
	  				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
	  			}
  				break;
      	}

     }
     
	 /**
      * OnPopupClick 이벤트 발생시 호출되는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
      * @return 없음
   	  * @author 김민아
   	  * @version 2010.10.13
      */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname = sheetObj.ColSaveName(Col);
       	switch(colname)
       	{
   	    	case "trf_bzc_rout_pnt_def_cd":
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?";
 	  			sUrl += "location_cmd=C";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, Col)     = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
 	  			}
   				break;
       	}

      }
      
      /**
       * OnChange 이벤트 발생시 호출되는 function <br>
       * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
       * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
       * @return 없음
   	   * @author 김민아
   	   * @version 2010.10.13
       */  	
		  function sheet2_OnChange(sheetObj, Row, Col, Value){
         	var colname = sheetObj.ColSaveName(Col);  
         	switch(colname)
         	{
     	    	case "trf_bzc_rout_pnt_def_cd":
     	    		if (Value.length==2){ 
     	    			var param = "f_cmd="       +SEARCH07
	 					          + "&cd=" +sheetObj.Cellvalue(Row,Col)
	   	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", param);
	   	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  	
	 					if (arrData[1] != ""){
	 						sheetObj.CellValue2(Row,"cnt_nm") = arrData[1];
	 					}else{
	 						locationCellClear(sheetObj,Row);
	 					}
     	    		}else{
    	    			locationCellClear(sheetObj,Row);
             			
    	    		}
     	    		break; 	    		
         	}
         	
         }
		  
	  /**
	   * OnChange 이벤트 발생시 호출되는 function <br>
	   * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
	   * <br><b>Example :</b>
	   * <pre>
	   *
	   * </pre>
	   * @param {ibsheet} sheetObj 필수 IBSheet Object
	   * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	   * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	   * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	   * @return 없음
	   * @author 김민아
	   * @version 2010.10.13
	   */  	
	  function sheet3_OnChange(sheetObj, Row, Col, Value){
	 	var colname = sheetObj.ColSaveName(Col);  
	 	switch(colname)
	 	{
		case "trf_bzc_rout_pnt_def_cd":
			if (Value.length==2){  
				var param = "f_cmd="       +SEARCH07
				          + "&cd=" +sheetObj.Cellvalue(Row,Col)
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  	
				if (arrData[1] != ""){
					sheetObj.CellValue2(Row,"cnt_nm") = arrData[1];
				}else{
					locationCellClear(sheetObj,Row);
				}
			}else{
				locationCellClear(sheetObj,Row);
	 			
			}
			break; 	     		
	 	}
	 	
	 }
		  
     /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
      * 클릭시 수정된 Scope(Text Color : RED)인 경우 바탕색을 노란색으로 셋팅한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *	
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
      * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
      * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
      * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
      * @return 없음
      * @author 김민아
	  * @version 2010.10.13
      */  
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {   
    	if(OldRow != NewRow){
    		//하이라이트처리
    		changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.hid_amdt_seq.value);
    		//하단버튼 컨트롤
			buttonControlBottom();
    	}
    }
    
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 클릭시 수정된 Scope(Text Color : RED)인 경우 바탕색을 노란색으로 셋팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김민아
	 * @version 2010.10.13
     */  
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {   
		if(OldRow != NewRow){
			//하이라이트처리
			changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.hid_amdt_seq.value);
			//하단버튼 컨트롤
			buttonControlBottom();
		}
    }
   
/////////////////////// Sheet Event (E) ///////////////////////
		  
/////////////////////// Combo Event (S) ///////////////////////
 	
   	/**
   	 * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 	
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		
   		var arrText = text.split("|");
   		
   		if (arrText != null && arrText.length > 1) { 
   			
   			formObj.trf_nm.value = comboObj.GetText(code, 1);
   			
			var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
			
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		}
   	}
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *  
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.13
   	 */   	
   	function tariff_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   		
   		if (code != null && code != "") {
   	   		var arr = code.split("-");				
   			formObj.trf_pfx_cd.value = arr[0];
   			formObj.trf_no.value = arr[1];

   			var text = comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.trf_nm.value) {
   				formObj.trf_nm.value = comboObj.GetText(code, 1);
   	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   	 			
   			}
   		}
   	}
   	
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 김민아
   	 * @version 2010.10.13
     */     
    function apro_ofc_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.apro_ofc_cd.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "apro_ofc_cd" );
    }
    
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 김민아
   	 * @version 2010.10.13
     */     
    function trf_bzc_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_tp_cd.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_tp_cd" );
    }
    
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 김민아
   	 * @version 2010.10.13
     */     
    function trf_bzc_wgt_ut_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_wgt_ut_cd.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_wgt_ut_cd" );
    }
    
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 김민아
   	 * @version 2010.10.13
     */     
    function trf_bzc_vol_ut_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_vol_ut_cd.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_vol_ut_cd" );
    }
    
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 김민아
   	 * @version 2010.10.13
     */     
    function curr_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.curr_cd.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "curr_cd" );
    }
    
/////////////////////// Combo Event (E) ///////////////////////
    
 	/**
 	 * 화면의 모든 버튼들의 Disable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 		allButtonDisable()
 	 * </pre>
 	 * @author 김민아
 	 * @version 2010.10.13
 	 */
 	function allButtonDisable() {
 		ComBtnDisable("btn_new");
 		ComBtnDisable("btn_retrieve");
 		ComBtnDisable("btn_amend");
 		ComBtnDisable("btn_save");
 		ComBtnDisable("btn_delete");
 		ComBtnDisable("btn_request");
 		ComBtnDisable("btn_approve");
 		ComBtnDisable("btn_publish");
 		ComBtnDisable("btn_cancel");

 		ComBtnDisable("btn_rowadd1");
 		ComBtnDisable("btn_rowdelete1");
 		ComBtnDisable("btn_amend1");
 		ComBtnDisable("btn_amendcancel1");
 		ComBtnDisable("btn_rowadd2");
 		ComBtnDisable("btn_rowdelete2");
 		ComBtnDisable("btn_amend2");
 		ComBtnDisable("btn_amendcancel2");
 	}

 	/**
 	 * 화면의 Status에 따른 모든 버튼들의 Enable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 		buttonControl(mode)
 	 * </pre>
 	 * @param {string} mode 필수 status나 모드
 	 * @author 김민아
 	 * @version 2010.10.13
 	 */
 	function buttonControl(mode) {
 		allButtonDisable();
 		var formObj    = document.form;
 		var amdtNo     = formObj.hid_amdt_seq.value;
 		var effDt      = formObj.eff_dt.value;
 		var loginOfcCd = formObj.strofc_cd.value;
 		var reqOfcCd   = sheetObjects[0].CellValue(1, "rqst_ofc_cd");
// 		var aproOfcCd  = sheetObjects[0].CellValue(1, "apro_ofc_cd");
 		var aproFlg    = sheetObjects[0].CellValue(1, "apro_usr_flg");
 		
 		switch (mode) {
 		case "":	// 화면 로드
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			break;
 		case "I":	// Basic 데이터 존재할 때
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			if(loginOfcCd == reqOfcCd){
	 			ComBtnEnable("btn_save");
	 			//Basic 데이터가 존재하지 않을 경우 Request, Delete 버튼 비활성
	 			if(effDt!=""){
		 			ComBtnEnable("btn_request");
					if(amdtNo == 0){
						ComBtnEnable("btn_delete");
					}else{
						// amdtNo가 0이 아닌 경우 Cancel 가능 -> 현재 amdtNo는 삭제되고 이전 amdtNo의 Publish 상태로 변경
						ComBtnEnable("btn_cancel");
					}
	 			}
				//하단 sheet 버튼 control
				buttonControlBottom();
 			}
 			break;
 		case "Q":	// Request
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			
// 			//Login Office와 Approval Office 체크를 먼저한다. 
// 			if(loginOfcCd == aproOfcCd){
//	 			ComBtnEnable("btn_approve");
//	 			ComBtnEnable("btn_cancel");
// 			} else if(loginOfcCd == reqOfcCd){
//	 			ComBtnEnable("btn_cancel");
// 			}
 			
 			//Approve 버튼 활성화
 			if(aproFlg == "Y"){
	 			ComBtnEnable("btn_approve");
	 			ComBtnEnable("btn_cancel");
 			}
 			if(loginOfcCd == reqOfcCd)
	 			ComBtnEnable("btn_cancel");
 			
 			break;
 		case "A":	// Approve
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_publish");
// 			if(loginOfcCd == aproOfcCd){
//	 			ComBtnEnable("btn_cancel");
// 			}
 			if(aproFlg == "Y")
 				ComBtnEnable("btn_cancel");
 			break;
 		case "F":	// Publish
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_amend");
 			break;
 		}
 	}
 	
 	/**
 	 * 하단 sheet row 데이터에 따른 버튼들의 Enable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 		buttonControlBottom(amdtNo)
 	 * </pre>
 	 * @param {string} amdtNo 필수 Amend No
 	 * @author 김민아
 	 * @version 2010.11.23
 	 */
 	function buttonControlBottom(){
 		var loginOfcCd = document.form.strofc_cd.value;
 		var reqOfcCd   = sheetObjects[0].CellValue(1, "rqst_ofc_cd");
 		
 		if(sheetObjects[0].CellValue(1,"trf_bzc_sts_cd") != "I") return;
 		if(loginOfcCd != reqOfcCd) return;
 		
 		var amdtNo     = document.form.hid_amdt_seq.value;
 		
 		var sheet1     = sheetObjects[1];
 		var rowCnt1    = sheet1.RowCount;
 		var amdtSeq1   = sheet1.CellValue(sheet1.SelectRow, "amdt_seq");
 		var n1stSeq1   = sheet1.CellValue(sheet1.SelectRow, "n1st_cmnc_amdt_seq");
 		var srcInfoCd1 = sheet1.CellValue(sheet1.SelectRow, "src_info_cd");
 		
 		var sheet2     = sheetObjects[2];
 		var rowCnt2    = sheet2.RowCount;
 		var amdtSeq2   = sheet2.CellValue(sheet2.SelectRow, "amdt_seq");
 		var n1stSeq2   = sheet2.CellValue(sheet2.SelectRow, "n1st_cmnc_amdt_seq");
 		var srcInfoCd2 = sheet2.CellValue(sheet2.SelectRow, "src_info_cd");
 		
 		ComBtnDisable("btn_rowadd1");
 		ComBtnDisable("btn_rowdelete1");
 		ComBtnDisable("btn_amend1");
 		ComBtnDisable("btn_amendcancel1");
 		ComBtnDisable("btn_rowadd2");
 		ComBtnDisable("btn_rowdelete2");
 		ComBtnDisable("btn_amend2");
 		ComBtnDisable("btn_amendcancel2");
 		
		// Tariff Scope Origin Sheet
		if(rowCnt1 == 0 || amdtSeq1 == amdtNo || amdtNo == 0) {
			ComBtnEnable("btn_rowadd1");
			ComBtnEnable("btn_rowdelete1");
		}
		if(amdtSeq1 != n1stSeq1 && amdtNo == amdtSeq1 && (srcInfoCd1 == "AM" || srcInfoCd1 == "NW") ){
			ComBtnEnable("btn_amend1");
		} else if(amdtSeq1 == n1stSeq1 && amdtNo == amdtSeq1 && (srcInfoCd1 == "AM" || srcInfoCd1 == "AD")) {
			ComBtnEnable("btn_amendcancel1");
			ComBtnDisable("btn_rowdelete1");
		}
		// Tariff Scope Destination Sheet
		if(rowCnt2 == 0 || amdtSeq2 == amdtNo || amdtNo == 0) {
			ComBtnEnable("btn_rowadd2");
			ComBtnEnable("btn_rowdelete2");
		}
		if(amdtSeq2 != n1stSeq2 && amdtNo == amdtSeq2 && (srcInfoCd2 == "AM" || srcInfoCd2 == "NW") ){
			ComBtnEnable("btn_amend2");
		} else if(amdtSeq2 == n1stSeq2 && amdtNo == amdtSeq2 && (srcInfoCd2 == "AM" || srcInfoCd2 == "AD")) {
			ComBtnEnable("btn_amendcancel2");
			ComBtnDisable("btn_rowdelete2");
		}
 	}
 	
    /**
     * 화면상의 입력 필드를 Disable/Enable 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     formControl(sheetObj, formObj)
     * </pre>
     * @param  {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param  {form} formObj 필수 html form object
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
     */ 
 	function formControl(sheetObj, formObj){
 		var loginOfcCd = formObj.strofc_cd.value;
 		var reqOfcCd   = sheetObjects[0].CellValue(1, "rqst_ofc_cd");
 		
		if(formObj.hid_amdt_seq.value == "" || sheetObj.CellValue(1,"trf_bzc_sts_cd") == "I"){
			// login Office와 request Office가 다른경우 FormDisable
			if(loginOfcCd == reqOfcCd) formEnableControl(); //Enable
			else formDisableControl(); //Disable
		}else {
			//Disable
	 		formDisableControl();
		}
 	}
 	
    /**
     * 화면상의 입력 필드를 모두 Disable 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     formDisableControl()
     * </pre>
     * @param  없음
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
     */  
     function formDisableControl(){
         var formObj = document.form;
         var sheetObj1 = sheetObjects[1];
         var sheetObj2 = sheetObjects[2];
         
         formObj.eff_dt.readOnly = true;
         formObj.exp_dt.readOnly = true;

         comboObjects[1].Enable = false;
         comboObjects[2].Enable = false;
         formObj.trf_bzc_wgt.readOnly = true;
         comboObjects[3].Enable = false;
         formObj.trf_bzc_vol_qty.readOnly = true;
         comboObjects[4].Enable = false;
         comboObjects[5].Enable = false;
         
         formObj.pub_cntc_pson_nm.readOnly = true;
         formObj.pub_ofc_addr.readOnly = true;
         formObj.pub_ofc_phn_no.readOnly = true;
         formObj.pub_ofc_cty_nm.readOnly = true;
         formObj.pub_ofc_ste_cd.readOnly = true;
         formObj.pub_ofc_zip_cd.readOnly = true;
         formObj.pub_ofc_cnt_nm.readOnly = true;
         formObj.pub_ofc_fax_no.readOnly = true;
         
         btnImgEnable(formObj.btns_calendar1, false);
         btnImgEnable(formObj.btns_calendar2, false);
         
         formObj.eff_dt.className = "input2";
         formObj.trf_bzc_wgt.className = "input2";
         formObj.trf_bzc_vol_qty.className = "input2";
         
         formObj.pub_cntc_pson_nm.className = "input2";
         formObj.pub_ofc_addr.className   = "input2";
         formObj.pub_ofc_phn_no.className = "input2";
         formObj.pub_ofc_cty_nm.className = "input2";
         formObj.pub_ofc_cnt_nm.className = "input2";
         
         formObj.exp_dt.className = "input2";
         formObj.pub_ofc_ste_cd.className = "input2";
         formObj.pub_ofc_zip_cd.className = "input2";
         formObj.pub_ofc_fax_no.className = "input2";
     }
     
     /**
      * 화면상의 입력 필드를 모두 Enable 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     formEnableControl()
      * </pre>
      * @param  없음
      * @return 없음
 	  * @author 김민아
 	  * @version 2010.10.13
      */  
      function formEnableControl(){
    	  formDisableControl();
    	  
          var formObj = document.form;
          
          //amdt_seq=0인 경우에만 수정 가능하다.
          if(formObj.hid_amdt_seq.value == "" || formObj.hid_amdt_seq.value == 0){
        	  formObj.eff_dt.readOnly = false;
        	  btnImgEnable(formObj.btns_calendar1, true);
        	  formObj.eff_dt.className = "input1";
        	  comboObjects[2].Enable = true;
          }
          
          formObj.exp_dt.readOnly = false;
          comboObjects[1].Enable = true;
          formObj.trf_bzc_wgt.readOnly = false;
          comboObjects[3].Enable = true;
          formObj.trf_bzc_vol_qty.readOnly = false;
          comboObjects[4].Enable = true;
          comboObjects[5].Enable = true;

          formObj.pub_cntc_pson_nm.readOnly = false;
          formObj.pub_ofc_addr.readOnly = false;
          formObj.pub_ofc_phn_no.readOnly = false;
          formObj.pub_ofc_cty_nm.readOnly = false;
          formObj.pub_ofc_ste_cd.readOnly = false;
          formObj.pub_ofc_zip_cd.readOnly = false;
          formObj.pub_ofc_cnt_nm.readOnly = false;
          formObj.pub_ofc_fax_no.readOnly = false;
          
          btnImgEnable(formObj.btns_calendar2, true);
          
          formObj.trf_bzc_wgt.className = "input1";
          formObj.trf_bzc_vol_qty.className = "input1";
          
          formObj.pub_cntc_pson_nm.className = "input1";
          formObj.pub_ofc_addr.className = "input1";
          formObj.pub_ofc_phn_no.className = "input1";
          formObj.pub_ofc_cty_nm.className = "input1";
          formObj.pub_ofc_cnt_nm.className = "input1";
          
          formObj.exp_dt.className = "input";
          formObj.pub_ofc_ste_cd.className = "input";
          formObj.pub_ofc_zip_cd.className = "input";
          formObj.pub_ofc_fax_no.className = "input";
          
      }
      
      /**
       * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *    btnImgEnable(obj, gb);
       * </pre>
       * @param  {form} obj 필수 Html Object
       * @param  {bool} gb  필수 true : 활성화 false : 비활성화
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */ 
     function btnImgEnable(obj, gb) {
         if(obj.constructor == String){
             obj = document.getElementsByName(obj)[0];        
         }
         var btnStyle = obj.style;
         
         if (gb){
             obj.Enable = true;
             btnStyle.cursor = "hand";
             btnStyle.filter="";
             obj.disabled = false;
         } else {
             obj.Enable = false;        
             btnStyle.cursor = "auto";
             btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
             obj.disabled = true;
         }

     }
 	
    /**
     * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
     * </pre>
     * @param  없음
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
     */  
     function clearAllForms(){
         
         var formObj = document.form;
         
         comboObjects[0].Index = -1;
         formObj.trf_pfx_cd.value="";
         formObj.trf_no.value="";
         formObj.trf_nm.value="";
         formObj.trf_orz_nm.value="";
         formObj.trf_orz_tp_nm.value="";
         formObj.amdt_seq.value="";
         formObj.trf_bzc_sts_cd.value="";
         formObj.trf_inlnd_flg.value="";
         formObj.eff_dt.value="";
         formObj.exp_dt.value="";
         formObj.pub_dt.value="";
         
         formObj.cre_dt.value="";
         
         comboObjects[1].Index = -1;
         formObj.cre_usr_id.value="";
         formObj.apro_ofc_cd.value="";
         comboObjects[2].Index = -1;
         formObj.trf_bzc_wgt.value="";
         comboObjects[3].Index = -1;
         formObj.trf_bzc_vol_qty.value="";
         comboObjects[4].Index = -1;
         comboObjects[5].Index = -1;

         formObj.pub_cntc_pson_nm.value="";
         formObj.pub_ofc_addr.value="";
         formObj.pub_ofc_phn_no.value="";
         formObj.pub_ofc_cty_nm.value="";
         formObj.pub_ofc_ste_cd.value="";
         formObj.pub_ofc_zip_cd.value="";
         formObj.pub_ofc_cnt_nm.value="";
         formObj.pub_ofc_fax_no.value="";
     }
 	
   /**
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 김민아
 	* @version 2010.10.13
    */  
    function com_change_sheet( sheetObj, colNm ){
    	var formObj = document.form;
        var eleValue = "";
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "exp_dt":
                	eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;

                case "trf_bzc_wgt":
                	//format 적용 및 숫자 체크
                	if(!setFormat(colNm)) return;
                	eleValue = formObj.trf_bzc_wgt.value;
                    break;
                case "trf_bzc_vol_qty":
                	//format 적용 및 숫자 체크
                	if(!setFormat(colNm)) return;
                	eleValue = formObj.trf_bzc_vol_qty.value;
                    break;
                    
                case "pub_ofc_phn_no":
                	eleValue = formObj.pub_ofc_phn_no.value;
                	break;
                case "pub_ofc_fax_no":
                	eleValue = formObj.pub_ofc_fax_no.value;
                	break;
                    
                default:
                    eleValue = document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.CellValue(1,colNm) = eleValue;

        }else{
            sheetObj.CellValue(1,colNm) = document.getElementById(colNm).Code;          
        }
    }
    
	/**
	 * SHEET의 CELL 수정권한을 제어하는 function <br>
	 * 
	 * <br><b>Example :</b>
	 * <pre>
	 * 	manageCellEditable (sheetObj);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
	 */
	 function manageCellEditable (sheetObj) {
		 //header의 체크박스를  uncheck한다.
		 sheetObj.headCheck(0, 1) = false;
		 
		 var formObj = document.form;
		 var trf_bzc_sts_cd = formObj.trf_bzc_sts_cd.value;
		 var amdt_seq = formObj.amdt_seq.value;
	 	 var loginOfcCd = formObj.strofc_cd.value;
	 	 var reqOfcCd   = sheetObjects[0].CellValue(1, "rqst_ofc_cd");
		 
		 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {

			 //Amend 원본 데이터에 대한 Row 취소선 셋팅
			 if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
				 sheetObj.CellFont("FontStrikethru", i, "seq", i, sheetObj.LastCol)=true;
				 sheetObj.RowEditable(i) = false;
			 }
			//Amend 데이터에 대한 Row 색 셋팅
			 if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq && amdt_seq > 0){
				 sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				 sheetObj.RowEditable(i) = true;
			 }
			 
			 if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdt_seq){
				 sheetObj.CellEditable(i,"trf_bzc_rout_pnt_def_cd") = false;
			 }else{
				 if(sheetObj.CellValue(i,"src_info_cd")=="AM") sheetObj.CellEditable(i,"trf_bzc_rout_pnt_def_cd") = true;
			     else if(sheetObj.CellValue(i,"src_info_cd")=="AD") sheetObj.CellEditable(i,"trf_bzc_rout_pnt_def_cd") = false;
			 }
			 
			 sheetObj.PopupButtonImage(i, "trf_bzc_rout_pnt_def_cd") = 1;
			 if(trf_bzc_sts_cd != "Initial"){
				 sheetObj.CellEditable(i,"trf_bzc_rout_pnt_def_cd") = false;
				 sheetObj.PopupButtonImage(i, "trf_bzc_rout_pnt_def_cd") = 0;
				 sheetObj.CellEditable(i,"chk") = false;
			 }
			 // login Office와 request Office가 다른경우 FormDisable
			 if(loginOfcCd != reqOfcCd){
				 sheetObj.CellEditable(i,"trf_bzc_rout_pnt_def_cd") = false;
				 sheetObj.PopupButtonImage(i, "trf_bzc_rout_pnt_def_cd") = 0;
				 sheetObj.CellEditable(i,"chk") = false;
			 }
		 }
	 }
	 
	 
    /**
     * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		locationCellClear(sheetObj,Row)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
     */  	    
  	function locationCellClear(sheetObj,Row){
    	sheetObj.CellValue2(Row,"trf_bzc_rout_pnt_def_cd")= ""; 		
  		sheetObj.CellValue2(Row,"cnt_nm")= "";
  		sheetObj.SelectCell(Row,"trf_bzc_rout_pnt_def_cd");
  	}
  	
    /**
     * Delete, Amend, Amend Cancel Event에 따른 row 셋팅 <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSheetAmendRow(sheetObj,formObj,srcInfo)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {String} row의 Event 정보
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.13
     */  
  	function setSheetAmendRow(sheetObj,formObj,row,srcInfo){
		var amdt_seq = formObj.amdt_seq.value;
		var sel_row  = "";
		
		if(row=="") sel_row = sheetObj.SelectRow;
		else sel_row = row;
		
		//Delete
		if(srcInfo=="AD"){
			if(sheetObj.CellValue(sel_row,"amdt_seq")!=amdt_seq
					||(sheetObj.CellValue(sel_row,"n1st_cmnc_amdt_seq")==amdt_seq
							&& (sheetObj.CellValue(sel_row,"src_info_cd")=="AM" || sheetObj.CellValue(sel_row,"src_info_cd")=="AD")))
			{
				ComShowCodeMessage("PRI01002");//Please check valid row
				return false;
			}
		}
		//Amend
		if(srcInfo=="AM"){
			if(sheetObj.CellValue(sel_row,"amdt_seq")!= amdt_seq 
					|| sheetObj.CellValue(sel_row,"n1st_cmnc_amdt_seq")== amdt_seq)
			{
	            ComShowCodeMessage("PRI00313");
	            return false;
	        }
		}
		//Amend Cancel
		if(srcInfo==""){
			if(sheetObj.CellValue(sel_row,"n1st_cmnc_amdt_seq")!= amdt_seq ||
					(sheetObj.CellValue(sel_row,"src_info_cd")!="AD"&&sheetObj.CellValue(sel_row,"src_info_cd")!="AM"))
			{
                ComShowCodeMessage("PRI00313");
                return false;
			}
		}
		
		// chebox 를 이용할 경우 해당 chk 를 제거
        sheetObj.CellValue2(sel_row, "chk") = 0;
        sheetObj.headCheck(0, 1) = false;
		
		//Amend Cancel
		if(srcInfo==""){
			var bf_row = sel_row-1;
			
			//신규row
			sheetObj.RowDelete(sel_row, false);
			//기존row
			sheetObj.RowStatus(bf_row) = "U";
			sheetObj.CellValue2(bf_row,"amdt_seq")=amdt_seq;
			sheetObj.CellFont("FontStrikethru", bf_row, 1, bf_row, sheetObj.LastCol)=false;
			sheetObj.RowEditable(bf_row) = true;
			
		}else{
			if(sheetObj.CellValue(sel_row, "n1st_cmnc_amdt_seq")!= amdt_seq){
				
				// DataCopy/ Insert 기준 row 를 잡기 위해 Row 설정
		        sheetObj.SelectRow = sel_row;
		        
		        var idx = sheetObj.DataCopy();     // 신규 row
		        var idx2 = idx-1;                  // 기존 row
		        //신규row
		        sheetObj.CellValue2(idx, "src_info_cd") = srcInfo;
		        sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
		        sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
		        sheetObj.RowStatus(idx) = "U";
		        if(srcInfo=="AM") sheetObj.CellEditable(idx,"trf_bzc_rout_pnt_def_cd") = true;
		        else if(srcInfo=="AD") sheetObj.CellEditable(idx,"trf_bzc_rout_pnt_def_cd") = false;
		        
		        //기존row
		        sheetObj.CellValue2(idx2,"amdt_seq")=amdt_seq-1;
		        sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
		        sheetObj.RowStatus(idx2) = "R"; // 기존 Row 의 상태를 R로 변경해서 저장되지 않도록 함
		        sheetObj.CellEditable(idx2,"trf_bzc_rout_pnt_def_cd") = false;
		        sheetObj.RowEditable(idx2) = false;
			}else{
				if(srcInfo=="AD"){
					sheetObj.RowStatus(sel_row) = "D";
					sheetObj.RowHidden(sel_row) = true;
				}
			}
		}
		changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.hid_amdt_seq.value);
  	}
  	
    /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확인한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     checkChangingUpdateDate(sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
	                       + "&key1="  + checkSheetObj.CellValue(1, "trf_pfx_cd") 
	                       + "&key2="  + checkSheetObj.CellValue(1, "trf_no") 
	                       + "&key3="  + checkSheetObj.CellValue(1, "amdt_seq")
	                       + "&upd_dt="+ checkSheetObj.CellValue(1, "upd_dt");
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   case "CHECK2" : //amend
	   	    var amdt_seq = parseInt(checkSheetObj.CellValue(1, "amdt_seq"));
	   		//다음 seq가 이미 생성되었는지 확인한다.
	   		amdt_seq++;
	        var checkParam = "f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
	                       + "&key1="  + checkSheetObj.CellValue(1, "trf_pfx_cd") 
	                       + "&key2="  + checkSheetObj.CellValue(1, "trf_no") 
	                       + "&key3="  + amdt_seq
	                       + "&upd_dt="+ checkSheetObj.CellValue(1, "upd_dt");
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   case "CHECK3" : //tariff scope
	        var checkParam = "f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC_ROUT_PNT&page_name=Tariff General Information"
	                       + "&key1="  + checkSheetObj.CellValue(1, "trf_pfx_cd") 
	                       + "&key2="  + checkSheetObj.CellValue(1, "trf_no") 
	                       + "&key3="  + checkSheetObj.CellValue(1, "amdt_seq")
	                       + "&upd_dt="+ checkSheetObj.CellValue(1, "rout_upd_dt");
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
   
     /**
      * 숫자인 경우 숫자 포맷을 소수점 셋째자리(999.999)로 셋팅한뒤 true 리턴한다. <br>
      * 숫자가 아닌경우 "" 셋팅 false 리턴한다.
      * <br><b>Example :</b>
      * <pre>
      *     setFormat()
      * </pre>
      * @param Object Name
      * @return 없음
      * @author 김민아
      * @version 2010.11.10
      */   
     function setFormat(eleName){
         var eleVal = document.getElementById(eleName).value;
         
         //숫자가 아닌경우 ""
         if(chkIsNaN(eleName, "")) {
//        	 document.getElementById(eleName).value = "";
        	 return false;
         //숫자인 경우
         }else {
	         var eleValArr = eleVal.split(".");
	         
	         if(eleVal != ""){
	        	//소수점이 존재하는 경우
	        	 if(eleValArr.length > 1){
	        		 if(eleValArr[1].length == 1){
	        			 eleVal = eleVal + "00";
	        		 }else if(eleValArr[1].length == 2){
	        			 eleVal = eleVal + "0";
	        		 }
	        	 //소수점이 존재하지 않는 경우
	        	 }else{
	        		 eleVal = eleVal + ".000";
	        	 }
	         }
         	document.getElementById(eleName).value = eleVal;
         	return true;
         }
     }
     
     /**
      * 숫자인지 아닌지 체크한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     chkIsNaN()
      * </pre>
      * @param Object Name
      * @param String char : 숫자체크시 제외 문자
      * @return Flag flg true  : 숫자가 아닌경우
      *                  false : 숫자인 경우
      * @author 김민아
      * @version 2010.11.12
      */  
     function chkIsNaN(eleName, char){
    	 var eleVal = document.getElementById(eleName).value;
    	 var flg = false;
    	 var eleValArr;
    	 if(char == ""){
    		 flg = isNaN(ComGetUnMaskedValue(eleVal, "float"));
    	 } else{
    		 eleValArr = eleVal.split(char);
    		 for(i=0 ; i<eleValArr.length ; i++){
    			 if(isNaN(eleValArr[i])) return true;
    		 }
    	 }
    	 return flg;
     }
     
     /**
      * 한글인지 아닌지 체크한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     chkIsNaH()
      * </pre>
      * @param Object Name
      * @return Flag flg true  : 한글이 아닌경우
      *                  false : 한글인 경우
      * @author 김민아
      * @version 2010.11.12
      */  
     function chkIsNaH(eleName){
    	 var eleVal = document.getElementById(eleName).value;
    	 var cnt = 0;
    	 
    	 for(i=0 ; i<eleVal.length ; i++){
    		 if(eleVal.charCodeAt(i) >= 0 && eleVal.charCodeAt(i) <= 127){
    			 //
    		 }else{
    			 cnt++;
    		 }
    	 }
    	 if(cnt>0) return true;
    	 else return false;
     }
   
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		getSheetXml()
	 * </pre>
	 * @param {int} sheetObj sheetObject
  	 * @author 최성민
  	 * @version 2010.10.13
	 */
   function getSheetXml() { 
	   var sheetObj = sheetObjects[0];       
	   sXml = ComPriSheet2Xml(sheetObj);
       
	   return sXml;
   }
   
	/**
	 * 상단 Code Creation Text 클릭시 Main 창으로 Code Creation 창을 띄운다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		goCodeCreation()
	 * </pre>
 	 * @author 김민아
 	 * @version 2010.10.22
	 */   
   function goCodeCreation(){
		var pgmNo = "ESM_PRI_3502";
		var pgmUrl = "/hanjin/ESM_PRI_3502.do"
		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo;
		var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
   }
	  	

	/* 개발자 작업  끝 */