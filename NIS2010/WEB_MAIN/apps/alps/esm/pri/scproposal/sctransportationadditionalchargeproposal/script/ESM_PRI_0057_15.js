/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_15.js
*@FileTitle : Amend History Inquiry Origin/Destination IHC 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.11 김재연
* 1.0 Creation
* 
* 2012.02.23 이석준 [CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
* 2015.05.15 송호진 [CHM-201535875] Line 513 con_chk 값 오류 수정
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
     * @class ESM_PRI_0057_15 : ESM_PRI_0057_15 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0057_15() {
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
	
    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;
	
	
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
     * @version 2009.09.11
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
    	var sheetObject1 = sheetObjects[0];

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

              }
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
     * @version 2009.09.11
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
     * @version 2009.09.11
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
     * @version 2009.09.11
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

    				var HeadTitle = "Seq.|Point|Description|Zip Code|Zip Code|Trans Mode|Term|Base Port|Per|Cargo Type|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date|prop_no|amdt_seq||||||||";
    				var headCount = ComCountHeadTitle(HeadTitle);
    				
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
    				// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtDataSeq,    	30,   daCenter,  true,	"seq");
    				InitDataProperty(0, cnt++, dtPopupEdit,  	60,   daCenter,  false, "rout_pnt_loc_def_cd");
    				InitDataProperty(0, cnt++, dtData,    		150,  daLeft,	 false, "rout_pnt_loc_def_nm");
    				InitDataProperty(0, cnt++, dtData,    		20,   daLeft,	 false, "loc_grd_cnt_cd");
    				InitDataProperty(0, cnt++, dtData,    		60,   daLeft,	 false, "loc_grd_cd");
    				InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false, "prc_trsp_mod_cd");
    				InitDataProperty(0, cnt++, dtCombo,      	50,   daCenter,  false, "rcv_de_term_cd");
    				InitDataProperty(0, cnt++, dtPopupEdit,   	60,   daCenter,  false, "bse_port_def_cd");
    				InitDataProperty(0, cnt++, dtCombo,  		40,   daCenter,  false, "rat_ut_cd");
    				InitDataProperty(0, cnt++, dtCombo,     	70,   daCenter,  false, "prc_cgo_tp_cd");
    				InitDataProperty(0, cnt++, dtCombo,      	60,   daCenter,  false, "curr_cd");
    				InitDataProperty(0, cnt++, dtData,      	70,   daRight,   false, "prop_frt_rt_amt",	false,  "", dfFloat,	 2);
    				InitDataProperty(0, cnt++, dtData,      	70,   daCenter,  false, "coffr_frt_rt_amt", false,  "", dfNullFloat, 2);
    				InitDataProperty(0, cnt++, dtData,      	70,   daRight,   false, "fnl_frt_rt_amt",   false,  "", dfNullFloat, 2);
    				InitDataProperty(0, cnt++, dtData,      	70,   daCenter,  false, "eff_dt",    		false,	"", dfDateYmd);
    				InitDataProperty(0, cnt++, dtData,      	70,   daCenter,  false, "exp_dt",      		false,  "",	dfDateYmd);
    				InitDataProperty(0, cnt++, dtCombo,     	60,   daCenter,  false, "src_info_cd");
    				InitDataProperty(0, cnt++, dtCombo,  		60,   daCenter,  false, "prc_prog_sts_cd");
    				InitDataProperty(0, cnt++, dtData,      	180,  daLeft,    false,	"acpt_usr_nm");
    				InitDataProperty(0, cnt++, dtData,      	70,   daCenter,  false,	"acpt_dt",			false,	"",	dfDateYmd);
    				
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"prop_no");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"add_chg_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false, "rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false, "bse_port_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false, "add_chg_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false, "n1st_cmnc_amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,	"acpt_usr_id");
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
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
		            // 전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            // 전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            // 전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            var HeadTitle = "status";
		            var headCount = ComCountHeadTitle(HeadTitle);
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 6, 100);
		
		            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
		
		            Visible = false;
		        }
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
     * @version 2009.09.11
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
  			var formObj = document.form;
			setSheetDisplay(sheetObj);
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
 
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet에서 User Name 를 클릭 시 User Info Popup이 호출됨<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author  김재연
     * @version 2009.09.11
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);
     
        switch(colname)
        {
            case "acpt_usr_nm":
                if (Value != "") {
                    ComUserPopup(sheetObj.CellValue(Row,"acpt_usr_id"));
                }
                break;
        }
    }
    
    /**
   	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.09.11
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
  	   	loadSts = true;
     	parent.loadTabPage();
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
     * @version 2009.09.11
 	 **/
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
     * @version 2009.09.11
     */
	function obj_click(){
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		
		if (event.srcElement.name == "org_dest_tp_cd") {
			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
     * @version 2009.09.11
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	     	
	     	case IBSEARCH:
	     		ComOpenWait(true);	
	     		formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_0057_15GS.do", FormQueryString(formObj));
				ComOpenWait(false);
	     		break;
	     	
			case IBSEARCH_ASYNC02: // font style 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.getSaveXml("ESM_PRI_0057_15GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
		
			case IBSEARCH_ASYNC03:
				formObj.f_cmd.value = SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
				}
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
			
			case IBSEARCH_ASYNC04: // radio button 선택
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.getSaveXml("ESM_PRI_0057_15GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked = true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 			}
				}
				break;
	    }
	}
	
	/**
     * sheet 의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.09.11
     */
	function setSheetDisplay(sheetObj) {
		var formObj = document.form;
		var amdtSeq = formObj.amdt_seq.value;
		var lgcyIfFlg = form.lgcy_if_flg.value;
		var rCnt = sheetObj.RowCount;
		
		for(var i=1 ; i<=rCnt; i++) {
			if(sheetObj.CellValue(i ,"amdt_seq") != amdtSeq) { //이전회차는 줄긋고 전부 Edit불가 
				sheetObj.CellFont("FontStrikethru", i, "seq", i, "acpt_dt") = true;
			} else if(lgcyIfFlg != "Y") {
				sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
			}
		}
	}
	
	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("SHA090001", 2, "ACE", true)
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sConChk 필수 con_chk 값
     * @return 없음
     * @author 김재연
     * @version 2009.09.11
     */    	
     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
 		var formObj = document.form;
 		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd) {
 			formObj.prop_no.value 		= sPropNo;
 			formObj.amdt_seq.value 		= sAmdtSeq;
 			formObj.svc_scp_cd.value 	= sSvcScpCd;
 			formObj.lgcy_if_flg.value 	= sLgcyIfFlg;
 			formObj.con_flg.value 	= sConChk;
 			
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC04); //Radio Button Default 설정
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03); //Term
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
 		}
 	}
	
     /**
      * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      * 		tabClearSheet()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 김재연
      * @version 2009.09.11
      */
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		
		sheetObjects[0].RemoveAll();
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
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
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
     * @version 2009.09.11
     */
     function setTypeFontStyle(sXml) {
     	var arrDesc = ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	var lgcyIfFlg = form.lgcy_if_flg.value;
     	
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color = "blue";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color = "black";
 				}
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color = "red";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color = "black";
 				}
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				document.getElementById("org_dest_tp_cd1").style.color = "black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
 				document.getElementById("org_dest_tp_cd1").style.color = "black";
 			}
 			
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color = "blue";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color = "black";
 				}
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color = "red";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color = "black";
 				}
 			} else if(arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				document.getElementById("org_dest_tp_cd2").style.color = "black";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
 				document.getElementById("org_dest_tp_cd2").style.color = "black";
 			}
 		}
    }
	
    var loadSts = false;
    
    /**
     * 메인에서 호출하는 function <br>
     * Loading 이 완료 되었을때 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.10
     */
    function loadFinishCheck(){
        return loadSts;
    }	 

	/* 개발자 작업  끝 */