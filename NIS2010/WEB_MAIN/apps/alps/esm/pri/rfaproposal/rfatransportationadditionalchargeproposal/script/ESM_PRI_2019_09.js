/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_2019_09.js
*@FileTitle : RFA Proposal &amp; Amendment Inquiry - Arbitrary (For AEE/AEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.25 서미진
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
     * @class ESM_PRI_2019_09 : ESM_PRI_2019_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2019_09() {
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
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
	
    var sheetObjects = new Array();
    var sheetCnt = 0;
	
	var CONFIRM_ORG_GLINE = false; // guideline copy 여부
	var CONFIRM_DEST_GLINE = false; // guideline copy 여부
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
	
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
//    	var sheetObject1 = sheetObjects[0];
    	var sheetObject1 = getActSheet();

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
    		
    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				break;
    				
              } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
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
     * @author 김재연
     * @version 2009.10.19
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
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
     * @author 김재연
     * @version 2009.10.19
     */
    function loadPage() {
    	 
    	for(i=0;i<sheetObjects.length;i++){
	
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );
	
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	pageOnLoadFinish();
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
     * @author 김재연
     * @version 2009.10.19
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;

    	switch (sheetID) {

    		case "sheet1":
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 280;
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 3, 100);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false, false);

    				var HeadTitle = "Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|cust_nm|Per|CGO\nType|Cur.|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date";
    				var headCount = ComCountHeadTitle(HeadTitle);
    				
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
    				// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtDataSeq,	30, daCenter,  	true,	"seq"					);
    				InitDataProperty(0, cnt++, dtData,  	45, daCenter,  	true,  	"rout_pnt_loc_def_cd"	);
    				InitDataProperty(0, cnt++, dtData,    	100,daLeft,		true,  	"rout_pnt_loc_def_nm"	);
    				InitDataProperty(0, cnt++, dtCombo,     70, daCenter,  	true,  	"prc_trsp_mod_cd"		);
    				InitDataProperty(0, cnt++, dtCombo,     50, daCenter,  	true,  	"rcv_de_term_cd"		);
    				InitDataProperty(0, cnt++, dtData, 		70,	daRight,	true, 	"min_cgo_wgt", 			false, 	"", dfNullFloat,	2);
					InitDataProperty(0, cnt++, dtData, 		70, daRight, 	true, 	"max_cgo_wgt", 			false, 	"", dfNullFloat,	2);
    				InitDataProperty(0, cnt++, dtData,   	45, daCenter,  	true,  	"bse_port_def_cd"		);
    				InitDataProperty(0, cnt++, dtData, 		65,	daCenter, 	true,	"cust_cnt_cd");
    				InitDataProperty(0, cnt++, dtHidden, 	30, daCenter,  	true,	"cust_nm");
    				InitDataProperty(0, cnt++, dtCombo,  	40,	daCenter, 	true,  	"rat_ut_cd"				);
    				InitDataProperty(0, cnt++, dtCombo,     40, daCenter, 	true,  	"prc_cgo_tp_cd"			);
    				InitDataProperty(0, cnt++, dtCombo,     40, daCenter,  	true,  	"curr_cd"				);
    				InitDataProperty(0, cnt++, dtData,      80,	daRight,   	true,  	"prop_frt_rt_amt",     	false, 	"", dfNullFloat,	2);
    				InitDataProperty(0, cnt++, dtData,      80, daRight,   	true,  	"coffr_frt_rt_amt",    	false,  "", dfNullFloat, 	2);
    				InitDataProperty(0, cnt++, dtData,      80, daRight,   	true,  	"fnl_frt_rt_amt",     	false,  "", dfNullFloat, 	2);
    				InitDataProperty(0, cnt++, dtData,      80, daCenter,  	true,  	"eff_dt", 				false,	"", dfDateYmd);
    				InitDataProperty(0, cnt++, dtData,      80, daCenter,  	true,  	"exp_dt",      			false,  "", dfDateYmd);
    				InitDataProperty(0, cnt++, dtCombo,     90, daCenter,  	true,  	"src_info_cd"			);
    				InitDataProperty(0, cnt++, dtCombo,  	80, daCenter,  	true,  	"prc_prog_sts_cd"		);
    				InitDataProperty(0, cnt++, daLeft,      120,daLeft,  	true,	"acpt_usr_nm"			);
    				InitDataProperty(0, cnt++, dtData,      70, daCenter,  	true,	"acpt_dt",				false,	"",	dfDateYmd);
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue,"USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
    				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
    				
    				AutoRowHeight = false;
    				WaitImageVisible = false;
    			}
    			break;
    			
    		case "sheet2":
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 260;
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 3, 100);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false, false);

//    				var HeadTitle = "state|Sel.|Seq.|Point|Description|Term|Base\nPort|LOC\nGroup|Trans\nMode|Per|CGO\nType|Actual\nCustomer|Customer Name|Cur.|Proposal|G/L|Diff\nWith G/L|Weight\n(Ton<=)|Weight\n(<Ton)|C.Offer|Final|EFF Date|EXP Date|Source|Status||||||||||||||";
    				var HeadTitle = "state|Seq.|Point|Description|Term|Base\nPort|Trans\nMode|Per|CGO\nType|Actual\nCustomer|Customer Name|Cur.|Proposal|G/L|Diff|Weight\n(Ton<=)|Weight\n(<Ton)|C.Offer|Final|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date||||||||||||||";
    				var headCount = ComCountHeadTitle(HeadTitle);
    				
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
    				// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtHiddenStatus, 40,   daCenter,  false,	"ibflag");
    				InitDataProperty(0, cnt++, dtDataSeq,    	30, daCenter,  	false,  "seq");
    				InitDataProperty(0, cnt++, dtPopupEdit,  	57, daCenter,  	false,  "rout_pnt_loc_def_cd" );
    				InitDataProperty(0, cnt++, dtData,    		100,daLeft,		false,  "rout_pnt_loc_def_nm",  false,  "", dfNone, 		0,  false,  false);
    				InitDataProperty(0, cnt++, dtCombo,      	55, daCenter,  	false,  "rcv_de_term_cd" );
    				
//    				InitDataProperty(0, cnt++, dtPopupEdit,   	57, daCenter,  	false,  "bse_port_def_cd",     	true,  	"", dfEngUpKey, 	0,  true,   true,	5);
    				InitDataProperty(0, cnt++, dtComboEdit,   	57, daCenter,  	false,  "bse_port_def_cd" );
    				
//    				InitDataProperty(0, cnt++, dtData,   		57, daCenter,  	false,  "loc_group",     		false,  "", dfNone, 		0,  false,  false);
    				InitDataProperty(0, cnt++, dtCombo,      	70, daCenter,  	false,  "prc_trsp_mod_cd" );
    				InitDataProperty(0, cnt++, dtCombo,  		38,	daCenter, 	false,  "rat_ut_cd" );
    				InitDataProperty(0, cnt++, dtCombo,     	47, daCenter, 	false,  "prc_cgo_tp_cd" );
    				InitDataProperty(0, cnt++, dtCombo, 		70,	daCenter, 	false, 	"cust_cnt_cd" );
    				InitDataProperty(0, cnt++, dtHidden, 		0, 	daCenter,  	true,	"cust_nm");
    				InitDataProperty(0, cnt++, dtCombo,      	43, daCenter,  	false,  "curr_cd" );
    				InitDataProperty(0, cnt++, dtData,      	68,	daRight,   	false,  "prop_frt_rt_amt" );
    				InitDataProperty(0, cnt++, dtHidden,      	68,	daRight,   	false,  "fic_gline_rt_amt",    	false, 	"", dfFloat,		2,  true,	true,	9);
    				InitDataProperty(0, cnt++, dtData,      	68,	daRight,   	false,  "diff_with_gl",     	false, 	"", dfNone,			2,  false,	false,	9);
    				InitDataProperty(0, cnt++, dtData, 			55,	daRight,	true, 	"min_cgo_wgt", 			false, 	"", dfNullFloat,	2, 	true, 	true,	6);
					InitDataProperty(0, cnt++, dtData, 			55, daRight, 	true, 	"max_cgo_wgt", 			false, 	"", dfNullFloat,	2,	true, 	true, 	6);
    				InitDataProperty(0, cnt++, dtData,      	68, daRight,   	false,  "coffr_frt_rt_amt",    	false,  "", dfNullFloat, 	2,  false,  false,	9);
    				InitDataProperty(0, cnt++, dtData,      	68, daRight,   	false,  "fnl_frt_rt_amt",     	false,  "", dfNullFloat, 	2,  false,  false);
    				InitDataProperty(0, cnt++, dtData,      	80, daCenter,  	false,  "eff_dt", 				false,	"", dfDateYmd, 		0,  false,  false);
    				InitDataProperty(0, cnt++, dtData,      	80, daCenter,  	false,  "exp_dt",      			false,  "", dfDateYmd, 		0,  false,  false);
    				InitDataProperty(0, cnt++, dtCombo,     	90, daCenter,  	false,  "src_info_cd",     		false,  "", dfNone, 		0,  false,  false);
    				InitDataProperty(0, cnt++, dtCombo,  		80, daCenter,  	false,  "prc_prog_sts_cd",      false,  "", dfNone, 		0,  false,  false);
    				InitDataProperty(0, cnt++, daLeft,      120,daLeft,  	true,	"acpt_usr_nm"			);
    				InitDataProperty(0, cnt++, dtData,      70, daCenter,  	true,	"acpt_dt",				false,	"",	dfDateYmd);

    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"prop_no");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"add_chg_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"add_chg_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,	"n1st_cmnc_amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"bse_port_tp_cd");
    				
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"base_port_list");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"optm_trsp_mod_flg");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rout_cmb_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rt_use_sts_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_gline_upd_dt");
    				
    				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
					InitDataValid(0,  "rout_pnt_loc_def_cd",	vtEngUpOther, "1234567890");
    				InitDataValid(0,  "bse_port_def_cd",		vtEngUpOther,"1,2,3,4,5,6,7,8,9,0");
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue,"USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
    				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
    				
    				EnterBehavior = "tab";
    				AutoRowHeight = false;
    				WaitImageVisible = false;
    			}
    			break;

    	}
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.10.19
	 */
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "/";
 	
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */
	function obj_click(){
		var formObject = document.form;
		var bakDestTpCd = formObject.bak_dest_tp_cd.value;
		
		if (event.srcElement.name == "org_dest_tp_cd") {
			
			if(formObject.org_dest_tp_cd[0].checked){
				formObject.bak_dest_tp_cd.value = formObject.org_dest_tp_cd[0].value;
			}else if(formObject.org_dest_tp_cd[1].checked){
				formObject.bak_dest_tp_cd.value = formObject.org_dest_tp_cd[1].value;
			}
			
     		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(getActSheet(), formObject, IBSEARCH);
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
     * @author 김재연
     * @version 2009.10.19
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	      		
	     	case IBSEARCH:
	     		ComOpenWait(true);	
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value = SEARCH01;
//				sheetObj.DoSearch("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
	     		var sXml = sheetObj.getSearchXml("ESM_PRI_2019_09GS.do", FormQueryString(formObj));
				showSheetObj(sXml);
				ComOpenWait(false);
	     		break;
	     	
			case IBSEARCH_ASYNC02: // font type 조회
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.getSaveXml("ESM_PRI_2019_09GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
			
			case IBSEARCH_ASYNC03: //
				formObj.f_cmd.value = SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				setIBCombo(sheetObjects[1],sXml,"rcv_de_term_cd",true,0);
				break;
			
			case IBSEARCH_ASYNC04:
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.getSaveXml("ESM_PRI_2019_09GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 				CONFIRM_ORG_GLINE = true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked = true;
		 				CONFIRM_DEST_GLINE = true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 			}
				}
				break;		
				
			case IBSEARCH_ASYNC05:
				//공통 Actual Customer
				formObj.f_cmd.value = COMMAND28;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObj,sXml,"cust_cnt_cd",true,0,"","",true);
				break;
	    }
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
     * @author 김재연
     * @version 2009.10.19
     */
     function sheet1_OnSearchEnd(sheetObj, errMsg)  {
   		if (errMsg == "") {
   			var formObj = document.form;
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
  		}
  	}   
	
    /**
     * OnMouseMove 이벤트 발생시 호출되는 function <br>
     * Tool Tip 을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} Button 필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {int} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param (Long) X 필수 X 좌표
     * @param (Long) Y 필수 Y 좌표
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */ 
    function sheet1_OnMouseMove(Button, Shift, X, Y) {
    	var sheetObj = sheetObjects[0];
    	if(sheetObj.MouseRow > 1 && sheetObj.MouseCol == 8) {
    		sheetObj.MouseToolTipText = sheetObj.CellValue(sheetObj.MouseRow, "cust_nm");
    	} else {
    		sheetObj.MouseToolTipText = "";
    	}
    }
    
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
    	parent.loadTabPage();
    }
     
    /**
     * org_dest_tp_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.10.19
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	
	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("SHA090012", "1", "ACE")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */ 		    	
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
		var formObj = document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd) {
			formObj.prop_no.value 		= sPropNo;
			formObj.amdt_seq.value 		= sAmdtSeq;
			formObj.svc_scp_cd.value 	= sSvcScpCd;
			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC04); //Radio Button Default 설정
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03); //Term
			doActionIBSheet(getActSheet(), document.form,IBSEARCH);
		}
	}
	
	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */ 		 
 	function tabClearSheet() {
		var formObject = document.form;

		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	
	var enableFlag = true;
	
	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */
	function validateForm(sheetObj,formObj,sAction){
		
		switch (sAction) {
			
			case IBSEARCH: // 조회			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
		}
		return true;
	}
	
	/**
	 * TYPE RADIO 버튼의 폰트색을 변경하는 function <br>
     * 1) ALL ACCEPT일 경우는 파란색 <br>
     * 2) AMEND할 건수가 존재할 경우 빨간색 <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml 필수 Xml Object
     * @return 없음
     * @author 김재연
     * @version 2009.10.19
     */
	function setTypeFontStyle(sXml) {
    	var arrDesc = ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue" || arrDesc[0][0] == "red" || arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
 			}
 			
 			if(arrDesc[0][1] == "blue" || arrDesc[0][1] == "red" || arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
 			}
 		}
	}
	
    /**
     * sheet 지정 function <br>
     * sheet1, sheet2 중에 조건에 맞는 sheet를 선택한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		getActSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function getActSheet(){
    	var actSheetObj = null;
    	var sheetObjs = document.getElementsByName("mainTable"); 
    	for(var i=0; i<sheetObjs.length; i++){
    		if(sheetObjs[i].style.display==""){
    			actSheetObj = sheetObjects[i];
    			break;
    		}
    	}
    	return actSheetObj;
    }
    
    /**
     * sheet 컨트롤 function <br>
     * sheet1, sheet2 display 속성을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		showSheetObj()
     * </pre>
     * @param {object} sXml 필수 Xml Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function showSheetObj(sXml){
    	
    	var formObj = document.form;
    	var svcScpCd = formObj.svc_scp_cd.value;
    	var sheetObjs = document.getElementsByName("mainTable");
//    	var divLoadExcel = document.getElementById("div_loadexcel");
    	
    	sheetObjects[0].Redraw = false;
    	sheetObjects[1].Redraw = false;
    	
    	if("AEE"==svcScpCd){
			if(formObj.org_dest_tp_cd[0].checked){ //Origin checked
				sheetObjs[1].style.display = "";
				sheetObjs[0].style.display = "none";
				sheetObjects[1].LoadSearchXml(sXml);
//				divLoadExcel.style.display = "none";
//				ComBtnDisable("btn_loadexcel");
//				ComBtnEnable("btn_glinerouteselect");
			}else{
				sheetObjs[1].style.display = "none";
				sheetObjs[0].style.display = "";
				sheetObjects[0].LoadSearchXml(sXml);
//				divLoadExcel.style.display = "";
//				ComBtnEnable("btn_loadexcel");
//				ComBtnDisable("btn_glinerouteselect");
			}
		}else if("AEW"==svcScpCd){
			if(formObj.org_dest_tp_cd[1].checked){ //Dest checked
				sheetObjs[1].style.display = "";
				sheetObjs[0].style.display = "none";
				sheetObjects[1].LoadSearchXml(sXml);
//				divLoadExcel.style.display = "none";
//				ComBtnDisable("btn_loadexcel");
//				ComBtnEnable("btn_glinerouteselect");
			}else{
				sheetObjs[1].style.display = "none";
				sheetObjs[0].style.display = "";
				sheetObjects[0].LoadSearchXml(sXml);
//				divLoadExcel.style.display = "";
//				ComBtnEnable("btn_loadexcel");
//				ComBtnDisable("btn_glinerouteselect");
			}
		}
    	
    	sheetObjects[0].Redraw = true;
    	sheetObjects[1].Redraw = true;
    	
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
     * @author 김재연
     * @version 2009.05.20
     */
	function sheet2_OnSearchEnd(sheetObj, errMsg)  {
		
		sheet_OnSearchEnd(sheetObj, errMsg);
		
		var sRow = sheetObj.HeaderRows;
		var eRow = sRow + sheetObj.SearchRows;
		
		var strPropFrtRtAmt = "";
		var strFicGlineRtAmt = "";
		var numPropFrtRtAmt = 0;
		var numFicGlineRtAmt = 0;
		
		for(var i=sRow; i<eRow; i++){
			
			calcProposalAmt(sheetObj, i);
			
			// base port list 구성
			var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
			var basePortList = sheetObj.CellValue(i, "base_port_list");
			if(bsePortDefCd != basePortList){
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList,  " |" + basePortList);
			}else{
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd,  " |" + bsePortDefCd);
			}
			sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;
			
			sheetObj.RowStatus(i) = "R";
			sheetObj.CellValue2(i, "prop_frt_rt_amt") =  ComAddComma2(sheetObj.CellValue(i, "prop_frt_rt_amt") , '#,###.00');
		}
		
		sheetObj.SelectCell(1, 1);
		
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
     * @author 김재연
     * @version 2009.05.20
     */
	function sheet_OnSearchEnd(sheetObj, errMsg){
		if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
   			var formObj = document.form;
   			var propStsCd = formObj.prop_sts_cd.value;
   			var rCnt = sheetObj.RowCount;
//   			setSheetDisplay(sheetObj);
  			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
  		}
	}
	
    /**
     * Propocal Amount 계산 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		calcProposalAmt(sheetObj, Row)
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function calcProposalAmt(sheetObj, Row){
    	
    	var strPropFrtRtAmt = "";
		var strFicGlineRtAmt = "";
		var numPropFrtRtAmt = 0;
		var numFicGlineRtAmt = 0;
		
		if("S"==sheetObj.CellValue(Row, "fic_rt_use_sts_cd")){
    		
    		strPropFrtRtAmt = sheetObj.CellValue(Row, "prop_frt_rt_amt");
			if(strPropFrtRtAmt){
				numPropFrtRtAmt = Number(strPropFrtRtAmt);
			}
			
			strFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
			if(strFicGlineRtAmt){
				numFicGlineRtAmt = Number(strFicGlineRtAmt);
			}
			
			// 부동소수점 제어를 위해 정수형 변경후 처리
			numPropFrtRtAmt = numPropFrtRtAmt * 100;
			numFicGlineRtAmt = numFicGlineRtAmt * 100;
			
			numPropFrtRtAmt = numPropFrtRtAmt.toFixed();
			numFicGlineRtAmt = numFicGlineRtAmt.toFixed();
			
			sheetObj.CellValue2(Row, "diff_with_gl") =  ComAddComma2(((numPropFrtRtAmt - numFicGlineRtAmt)/100).toString(), '#,###.00');
			
		}else{
			sheetObj.CellValue2(Row, "diff_with_gl") = "N/A";
		}
    }

	/* 개발자 작업  끝 */