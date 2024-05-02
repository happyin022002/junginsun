/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3511.js
*@FileTitle : Tariff General Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.27
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.27 김민아
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
     * @class ESM_PRI_3511 : ESM_PRI_3511 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3511() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject         = setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    }

   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

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
     * @version 2010.10.27
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObjects[1],formObject,IBCREATE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
					
				case "btn_creation":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01);
					break;

				case "btn_history":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC02);
					break;
					
				case "btn_print":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC03);
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
	 * @version 2010.10.27
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
     * @version 2010.10.27
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
    * @version 2010.10.27
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
        
        //IBMultiCombo 데이터 셋팅
        //Tariff No
        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
        //Status
        ComPriTextCode2ComboItem(trfBzcStsCdComboValue, trfBzcStsCdComboText, getComboObject(comboObjects, 'trf_bzc_sts_cd') ,"|","\t" );
        
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
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
     * @version 2010.10.27
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
     	switch(sheetID) {
         	case "sheet1":
         		with (sheetObj) {
         			/*
                     // 높이 설정
                     style.height = 250;
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
                    	 			+"PUB_CNTC_PSON_NM|PUB_OFC_ADDR|PUB_OFC_PHN_NO|PUB_OFC_CTY_NM|PUB_OFC_STE_CD|PUB_OFC_ZIP_CD|PUB_OFC_CNT_NM|PUB_OFC_FAX_NO|PRE_PUB_DT";

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
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|TRF_PFX_CD|TRF_NO|Tariff Code|Tariff Name|Tariff Type|Effective Date|Publish Date|Status|Inland Rates|Amend No.";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	true,	"trf_pfx_cd",		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	true,	"trf_no",			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	true,	"trf_cd",			false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	350,  	daLeft,		true,	"trf_nm",    		false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	80,  	daCenter,	true,	"trf_bzc_tp_cd",	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"eff_dt",     		false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"pub_dt",  			false,	"",	dfDateYmd,	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,	80,  	daCenter, 	true,	"trf_bzc_sts_cd",  	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	90,  	daCenter, 	true,	"trf_inlnd_flg",  	false,	"",	dfNone, 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	80,  	daCenter, 	true,	"amdt_seq",     	false,	"",	dfNone, 	0,     false,	false);
                     
                     InitDataCombo(0, "trf_bzc_sts_cd", trfBzcStsCdComboText, trfBzcStsCdComboValue);
                     
                     WaitImageVisible = false
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

                     var HeadTitle = "|SEQ|Origin|Origin Description";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	false,	"seq");
                     InitDataProperty(0, cnt++ , dtPopupEdit,	100,  	daCenter,	false,	"trf_bzc_rout_pnt_def_cd",  false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200,  	daLeft, 	false,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false);
                     
                     WaitImageVisible = false
         		}
              	break;
              	
         	case "sheet4":
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

                     var HeadTitle = "|SEQ|Destination|Destination Description";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	false,	"seq");
                     InitDataProperty(0, cnt++ , dtPopupEdit,	100,  	daCenter,	false,	"trf_bzc_rout_pnt_def_cd",  false,	"",	dfNone,  	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200,  	daLeft, 	false,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false);
                     
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
     * @version 2010.10.27
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
            case "trf_bzc_sts_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                    ValidChar(1, 0);
                    MaxLength = 10;
                }
                break;
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
   * @version 2010.10.27
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
	 			case IBSEARCH: // 조회
	 				
		 			formObj.f_cmd.value = SEARCHLIST01;
		 			var param = "f_cmd="           + formObj.f_cmd.value
		 					  + "&trf_pfx_cd="     + formObj.trf_pfx_cd.value
		 					  + "&trf_no="         + formObj.trf_no.value
		 					  + "&trf_bzc_sts_cd=" + comboObjects[1].Code;
//		 			alert(param);
		 			ComOpenWait(true); //->waiting->start
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3511GS.do", param);
	  				sheetObj.LoadSearchXml(sXml);
	  				
	  				if(sheetObjects[1].rowCount == 0){
	  					clearAllForms();
	  				}
	  				
	  				ComOpenWait(false); //->waiting->End
	  				
	  				sheetObjects[1].selectCell(1, 1);
	  				
	 				break;
	 				
	 			case IBCREATE: // New

	                ComOpenWait(true); //->waiting->start
	                clearAllForms();
					comboObjects[0].Index = -1;
					comboObjects[1].Index = -1;
					formObj.trf_pfx_cd.value="";
					formObj.trf_no.value="";
					
	                sheetObjects[0].RemoveAll();
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                sheetObjects[3].RemoveAll();
	                                
	                ComOpenWait(false); //->waiting->End
                    formObj.tariff_cd.focus();
					break;
					
				case IBSEARCH_ASYNC01: // Open Creation
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					goCreation(sheetObj);
				
					break;
					
				case IBSEARCH_ASYNC02: // History
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					goHistory(sheetObj);
				
					break;
					
				case IBSEARCH_ASYNC03: // Print
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					goPrint(sheetObj);
				
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
   	 * @version 2010.12.24
     */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
   		case IBSEARCH_ASYNC01:
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Tariff Code");
 				return false;
 			}
 			break;

   		case IBSEARCH_ASYNC02:
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Tariff Code");
 				return false;
 			}
 			break;

   		case IBSEARCH_ASYNC03:
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Tariff Code");
 				return false;
 			}
 			break;

 			
 		}

 		return true;
 	}
 	
/////////////////////// Sheet Event (S) ///////////////////////
 	
 	/**
 	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
 	 * @version 2010.10.27
 	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;

		if (OldRow != NewRow) {	
			formObj.f_cmd.value = SEARCH01;
			var param = "f_cmd="           + formObj.f_cmd.value
					  + "&trf_pfx_cd="     + sheetObj.cellValue(NewRow, "trf_pfx_cd")
					  + "&trf_no="         + sheetObj.cellValue(NewRow, "trf_no")
					  + "&amdt_seq="       + sheetObj.cellValue(NewRow, "amdt_seq");
	//		alert	(param);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_3511GS.do", param);
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1){
	        	sheetObjects[2].LoadSearchXml(arrXml[1]);
				}
				if (arrXml.length > 2){
	        	sheetObjects[3].LoadSearchXml(arrXml[2]);
				}
			}
		}
		sheetObj.selectCell(NewRow, 1);
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
 	 * @version 2010.10.27
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		
 		// sheet에 조회된 내용을 form Object에 셋팅한다.
// 		formObj.trf_pfx_cd.value = sheetObj.CellValue(1, "trf_pfx_cd");
// 		formObj.trf_no.value = sheetObj.CellValue(1, "trf_no");
// 		formObj.trf_bzc_sts_cd.value = sheetObj.CellValue(1, "trf_bzc_sts_nm");

 		if(sheetObj.RowCount>0){
	 		formObj.sh_trf_cd.value = sheetObj.CellValue(1, "trf_pfx_cd")+"-"+sheetObj.CellValue(1, "trf_no")
	 		formObj.trf_nm.value = sheetObj.CellValue(1, "trf_nm");
	 		
	 		
	 		formObj.rqst_ofc_cd.value = sheetObj.CellValue(1, "rqst_ofc_cd");
	 		formObj.cre_usr_id.value = sheetObj.CellValue(1, "cre_usr_id");
	 		formObj.apro_ofc_cd.value = sheetObj.CellValue(1, "apro_ofc_cd");
	 		formObj.amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
	 		
	 		formObj.eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"), "ymd");
	 		formObj.exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"), "ymd");
	 		formObj.pub_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "pub_dt"), "ymd");
	 		formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "cre_dt"), "ymd");
	 		
	 		formObj.trf_bzc_tp_cd.value = sheetObj.CellValue(1, "trf_bzc_tp_cd");
	 		formObj.trf_bzc_wgt.value = sheetObj.CellText(1, "trf_bzc_wgt");
	 		formObj.trf_bzc_wgt_ut_cd.value = sheetObj.CellValue(1, "trf_bzc_wgt_ut_cd");
	 		formObj.trf_bzc_vol_qty.value = sheetObj.CellText(1, "trf_bzc_vol_qty");
	 		formObj.trf_bzc_vol_ut_cd.value = sheetObj.CellValue(1, "trf_bzc_vol_ut_cd");
	 		formObj.curr_cd.value = sheetObj.CellValue(1, "curr_cd");
	 		
	 		formObj.pub_cntc_pson_nm.value = sheetObj.CellValue(1, "pub_cntc_pson_nm");
	 		formObj.pub_ofc_addr.value = sheetObj.CellValue(1, "pub_ofc_addr");
	 		formObj.pub_ofc_phn_no.value = sheetObj.CellValue(1, "pub_ofc_phn_no");
	 		formObj.pub_ofc_cty_nm.value = sheetObj.CellValue(1, "pub_ofc_cty_nm");
	 		formObj.pub_ofc_ste_cd.value = sheetObj.CellValue(1, "pub_ofc_ste_cd");
	 		formObj.pub_ofc_zip_cd.value = sheetObj.CellValue(1, "pub_ofc_zip_cd");
	 		formObj.pub_ofc_cnt_nm.value = sheetObj.CellValue(1, "pub_ofc_cnt_nm");
	 		formObj.pub_ofc_fax_no.value = sheetObj.CellValue(1, "pub_ofc_fax_no");
 		}
 	}
 	
/////////////////////// Sheet Event (E) ///////////////////////
 	
/////////////////////// Combo Event (S) ///////////////////////
 	
   	/**
   	 * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 		tariff_cd_OnChange(comboObj, code, text)
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.27
   	 */
   	function tariff_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		
   		var arrText = text.split("|");
   		if (arrText != null && arrText.length > 0) {
   			if (ComIsEmpty(comboObj.Text)) {
   				formObj.trf_pfx_cd.value = "";
   				formObj.trf_no.value = "";
   			}else{
				var arr = code.split("-");
				formObj.trf_pfx_cd.value = arr[0];
				formObj.trf_no.value = arr[1];
   			}
   		}
   	}
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    tariff_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.13
   	 */   	
   	function tariff_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   		var text = comboObj.GetText(code, 1);
   		
   		if(ComIsEmpty(code) || text == null || text == "") code = "";		
   		
   		if (code == null || code == "") {
   			formObj.trf_pfx_cd.value = "";
   			formObj.trf_no.value = "";
   		}else {
   			var arr = code.split("-");
   			formObj.trf_pfx_cd.value = arr[0];
   			formObj.trf_no.value = arr[1];
   		}
   	}
   	
   	/**
   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnKeyDown(comboObj, KeyCode) {
   			
   		var formObj = document.form;
   		
   		if (KeyCode == 13){
		 	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
   		}
   	}
   	
   	/**
   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 김민아
   	 * @version 2010.10.13
   	 */
   	function trf_bzc_sts_cd_OnKeyDown(comboObj, KeyCode) {
   		var formObj = document.form;
   		if (KeyCode == 13){
   			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
   		}
   	}
   	
/////////////////////// Combo Event (E) ///////////////////////
    
    /**
     * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
     * </pre>
     * @param  없음
     * @return 없음
 	 * @author 김민아
 	 * @version 2010.10.27
     */  
     function clearAllForms(){
         
         var formObj = document.form;
         
//         comboObjects[0].Index = -1;
//         comboObjects[1].Index = -1;
//         formObj.trf_pfx_cd.value="";
//         formObj.trf_no.value="";
//         formObj.trf_bzc_sts_cd.value="";
         formObj.sh_trf_cd.value="";
         formObj.trf_nm.value=""
         
         formObj.rqst_ofc_cd.value ="";
         formObj.cre_usr_id.value="";
         formObj.apro_ofc_cd.value="";
         formObj.amdt_seq.value="";
         
         
         formObj.eff_dt.value="";
         formObj.exp_dt.value="";
         formObj.pub_dt.value="";
         formObj.cre_dt.value="";
         
         formObj.trf_bzc_tp_cd.value="";
         formObj.trf_bzc_wgt.value="";
         formObj.trf_bzc_wgt_ut_cd.value="";
         formObj.trf_bzc_vol_qty.value="";
         formObj.trf_bzc_vol_ut_cd.value="";
         formObj.curr_cd.value="";

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
	 * Print버튼 클릭시 Main 창으로 Print 창을 띄운다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetObj sheetObject
	 * @author 김민아
	 * @version 2010.10.27
	 */   
  function goPrint(sheetObj){
	  sParam = "trfPfxCd=" + sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd")
	         + "&trfNo="   + sheetObj.cellValue(sheetObj.selectRow, "trf_no")
	         + "&amdtSeq=" + sheetObj.cellValue(sheetObj.selectRow, "amdt_seq");
	  rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_3506.do?"+sParam, "", 1024, 700, true);
  }
  
	/**
	 * History버튼 클릭시 Main 창으로 History 창을 띄운다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetObj sheetObject
	 * @author 김민아
	 * @version 2010.11.08
	 */   
	function goHistory(sheetObj){
			var pgmNo = "ESM_PRI_3504";
			var pgmUrl = "/hanjin/ESM_PRI_3504.do"
			var params = "&trfPfxCd=" + sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd")
	      		       + "&trfNo="    + sheetObj.cellValue(sheetObj.selectRow, "trf_no")
	                   + "&amdtSeq="  + sheetObj.cellValue(sheetObj.selectRow, "amdt_seq");
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
			var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
	}
  
	/**
	 * Open Creation버튼 클릭시 Main 창으로 Creation 창을 띄운다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetObj sheetObject
	 * @author 김민아
	 * @version 2010.10.27
	 */   
	function goCreation(sheetObj){
		var pgmNo = "ESM_PRI_3501";
		var pgmUrl = "/hanjin/ESM_PRI_3501.do"
		var params = "&trfPfxCd=" + sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd")
        		   + "&trfNo="    + sheetObj.cellValue(sheetObj.selectRow, "trf_no")
                   + "&amdtSeq="  + sheetObj.cellValue(sheetObj.selectRow, "amdt_seq");
		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
		var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
		var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
}
   
	/* 개발자 작업  끝 */