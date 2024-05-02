/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6014_03.js
*@FileTitle : RFA Quotation Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
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
     * @class ESM_PRI_6014_03 : ESM_PRI_6014_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6014_03() {
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
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var tabLoad = new Array();
    tabLoad[0] = 0;
    tabLoad[1] = 0;
    
    var LoadingComplete = false;
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();
    
    var isOViaMandatory = false;
    var isDViaMandatory = false;
    
    var s1PrevRow = -1;
    var s2PrevRow = -1;
    var s3PrevRow = -1;
    //rout delete row
    var isDelete = false;
    
    var isOk = true;
    
    //현재 이벤트를 저장
    var eventStatus = "";
    
    //현재 선택한  sheet1의 cmdt_seq
    var selectedCmdtHdrSeq = -1;
    
    //현재 선택한  sheet2의 rout_seq
    var selectedRoutSeq = -1;
    
    //현재 선택한  sheet4의 rt_seq
    var selectedRtSeq = -1;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    
        var sheetObject1 = sheetObjects[0];
    
        /** **************************************************** */
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
    
//            case "btn_Copy":
//            	doActionIBSheet(sheetObjects[9],document.form,IBSEARCH_ASYNC01);
//                break;
                
            case "btn_Adjust":

            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
					var sUrl = "/hanjin/ESM_PRI_6061.do?";
					sUrl += "cust_cnt_cd=" + parent.document.form.cust_cnt_cd.value;
					sUrl += "&cust_seq=" + parent.document.form.cust_seq.value;
					sUrl += "&qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&cmdt_hdr_seq=" + formObject.cmdt_hdr_seq.value;
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
//					alert(sUrl)
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6012", 900, 437, true);
					if (rtnVal == "SUCCESS" ){
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						popupSearch();
	 	  			}
				}
                break;
                
            case "btn_checkduplicate":
//            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
            		var sParam = FormQueryString(formObject);
            		ComPriOpenWindowCenter("/hanjin/ESM_PRI_6045.do?" + sParam, "ESM_PRI_6045", 1000, 435, false);
//                }
                break;
                
            case "btn_Excel":
            	execScript("rtn = msgbox(\"" + ComGetMsg("PRI01080") + "\", 3, \"Download Excel\")", "vbscript");
                if (rtn == 6) {
                	ComOpenWait(true);
                    doActionIBSheet(sheetObjects[9], formObject, IBDOWNEXCEL);
                } else if (rtn == 7) {
                	ComOpenWait(true);
                    doActionIBSheet(sheetObjects[10], formObject, IBDOWNEXCEL);
                }
                break;  
                
            case "btn_Load":
//            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	
					execScript("rtn = msgbox(\"" + ComGetMsg("PRI01080") + "\", 3, \"Load Excel\")", "vbscript");
	            	if (rtn == 6) {
	            		var sUrl = "/hanjin/ESM_PRI_6057.do?";
						sUrl += "qttn_no=" + formObject.qttn_no.value;
						sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value;
						sUrl += "&svc_scp_cd=" + parent.getSvcScpCd(); 
						sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
						ComPriOpenWindowCenter(sUrl, "ESM_PRI_6057", 955, 556, true, "no");
	            	} else if (rtn == 7) {
	            		var sUrl = "/hanjin/ESM_PRI_6056.do?";
						sUrl += "qttn_no=" + formObject.qttn_no.value;
						sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value;
						sUrl += "&svc_scp_cd=" + parent.getSvcScpCd(); 
						sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
						ComPriOpenWindowCenter(sUrl, "ESM_PRI_6056", 955, 556, true, "no");
	            	}
					
//				}	
                break;      
    
            case "btn1_Add":
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                break;
    
            case "btn1_Copy":
                doActionIBSheet(sheetObjects[0], document.form, IBCOPYROW);
                break;
                
            case "btn1_Delete":
                doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
                break;
                
            case "btn1_Save":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
    
            case "btn2_Add":
                doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                break;
                
            case "btn2_Copy":
                doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
                break;
    
            case "btn2_Delete":
                doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
                break;

            case "btn3_Add":
                doActionIBSheet(sheetObjects[3], document.form, IBINSERT);
                break;
                
            case "btn3_Copy":
                doActionIBSheet(sheetObjects[3], document.form, IBCOPYROW);
                break;    

            case "btn3_Delete":
                doActionIBSheet(sheetObjects[3], document.form, IBDELETE);
                break;

            case "btn3_Save":
                doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
                break;

            case "bkg_cm_op_radio":
				obj_click2();
				break;  	
            case "btn3_Calculate":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
            		doActionIBSheet(sheetObjects[9],document.form,IBSEARCH_ASYNC03);
            	}	
                break;		
                
            case "btn_SchgDetail":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
            		var sUrl = "/hanjin/ESM_PRI_6069.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value;
					sUrl += "&cmdt_hdr_seq=" + formObject.cmdt_hdr_seq.value;
					sUrl += "&rout_seq=" + formObject.rout_seq.value;
					sUrl += "&rt_seq=" + sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "rt_seq");
					sUrl += "&svc_scp_cd=" + parent.getSvcScpCd(); 
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
					sUrl += "&auth_code=" + parent.document.form.authCode.value;
//					alert(sUrl)
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6069", 900, 570, true);
					if (rtnVal == "SUCCESS" ){
						popupSearch();
	 	  			}
            	}	
                break;    

            case "btn_SchgAdjust":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6072.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&svc_scp_cd=" + parent.getSvcScpCd();
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
					sUrl += "&auth_code=" + parent.document.form.authCode.value;
//					alert(sUrl)
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6072", 900, 423, true);
					if (rtnVal == "SUCCESS" ){
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						popupSearch();
	 	  			}
            	}	
                break;  
                
            case "btn_CostDetail":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6063.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&cmdt_hdr_seq=" + formObject.cmdt_hdr_seq.value;
					sUrl += "&rout_seq=" + formObject.rout_seq.value;
					sUrl += "&rt_seq=" + sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "rt_seq");
					sUrl += "&cost_tp=" + getBkgCmOp(formObject).charAt(0);
					sUrl += "&revenue=" + (parseFloat(ComPriNvl(sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "qttn_rt_amt"),0)) +
							parseFloat(ComPriNvl(sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "prs_scg_amt"),0)));
					sUrl += "&cargo=" + sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "prc_cgo_tp_cd");
					sUrl += "&per=" + sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "rat_ut_cd");
					sUrl += "&contract_ofc=" + parent.document.form.qttn_ofc_cd.value;
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
					sUrl += "&auth_code=" + parent.document.form.authCode.value;
//					alert(sUrl)
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6063", 900, 607, true);
					if (rtnVal == "SUCCESS" ){
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						popupSearch();
	 	  			}
            	}	
                break;  

            case "btn_CostbyTransMode":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6066.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&cost_tp=" + getBkgCmOp(formObject).charAt(0);
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
					sUrl += "&auth_code=" + parent.document.form.authCode.value;
//					alert(sUrl)
					ComPriOpenWindowCenter(sUrl, "ESM_PRI_6066", 900, 402, true);
            	}	
                break;  
            case "btn_schgviewall":
            	if (sheetObjects[9].IsDataModified) {
            		ComShowCodeMessage("PRI00309", "Rate");
            		return false;
            	}
            	var sUrl = "/hanjin/ESM_PRI_6089.do?" + FormQueryString(formObject);
                var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6089", 1000, 620, true);
                break;                
                
            case "btn_CMPBViewAll":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6076.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&bkg_cm_op=" + getBkgCmOp(formObject);
					ComPriOpenWindowCenter(sUrl, "ESM_PRI_6076", 1020, 494, true);
            	}	
                break;  
                
            case "btn_CMViewAll":
            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6077.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
					sUrl += "&cost_tp=" + getBkgCmOp(formObject).charAt(0);	
					sUrl += "&qttn_sts_cd=" +  parent.document.form.qttn_sts_cd.value;
					sUrl += "&auth_code=" + parent.document.form.authCode.value;
//					alert(sUrl)
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6077", 1000, 511, true);
					if (rtnVal == "SUCCESS" ){
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						popupSearch();
						parent.getPRSCMData();
	 	  			}
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
     * @author 이승준
     * @version 2009.04.17
     */ 
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }
     var intervalID = "";
     
     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
    function loadPage() {
        for (var i = 0; i < sheetObjects.length; i++) {
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
    
            initSheet(sheetObjects[i], i + 1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var iWidth = window.document.body.clientWidth;
        
//        if(iWidth > 1024) {
        	sheetColResize();
//        }

    }
    
    
    /**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet4_OnLoadFinish(sheetObj) {
	   	 sheetObj.WaitImageVisible = false; 
	   	 doActionIBSheet(sheetObj, document.form, IBCLEAR);
	   	 
	   	 toggleButtons("CLEAR");
	   	 parent.loadTabPage();
	   	 initControl() ;
	   	 
//	   	 parent.loadComboList();
	   	 
//	   	 sheetObj.WaitImageVisible = true; 
    }
    
    
    /**
     * Axon 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListener('mouseover', 'btn3_Calculate_OnMouseOver', 'btn3_Calculate');  
        axon_event.addListener('mouseout', 'btn3_Calculate_OnMouseOut', 'btn3_Calculate');
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
     * @author 이승준
     * @version 2009.04.17
     */
    function initSheet(sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        case "sheet1":  // Grid 1
            with (sheetObj) {
                // 높이 설정
                style.height = 224;
                // 전체 너비 설정
//                SheetWidth = mainTable.clientWidth;
                SheetWidth = 260;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|Commodity Group|Commodity Group|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|src_info_cd";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
//                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtPopup,    180, daCenter, false, "prc_cmdt_def_cd", 	true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,    180, daLeft, false, "prc_cmdt_def_nm", 	true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_no", 		 	true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_ver_no", 		true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "gen_spcl_rt_tp_cd",  false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "cmdt_hdr_seq", 		true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "src_info_cd", 		true, "", dfNone, 0, false, false);
                
                Ellipsis = true;
                CountPosition = 0;
                PopupImage  =  "img/btns_search.gif";
				ShowButtonImage = 1;
//                ColHidden("del_chk") = true;
				WaitImageVisible = false;
            }
            break;
    
        case "sheet2":  // Grid 2
            with (sheetObj) {
                // 높이 설정
                style.height = 224;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|dataSeq|Seq.|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|" +
                				"Origin|O.Via|D.Via|Dest.";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "dataSeq");
                InitDataProperty(0, cnt++, dtData,   40, daCenter, false, "seq",    false,"",dfNone,0,false,	false);	
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtPopup, 110, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 110, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 110, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 115, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
                
                Ellipsis = true;
                PopupImage  =  "img/btns_search.gif";
				ShowButtonImage = 1;
                CountPosition = 0;
                ColHidden("dataSeq") = true;
                WaitImageVisible = false;
            }
            break;
    
        case "sheet3":  // Grid 3 description
        	with (sheetObj) {
                // 높이 설정
                style.height = 84;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1  = "|Sel.|Seq.|Commodity Group|Origin|Origin Via|Destination Via|Destination";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
                InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "prc_cmdt_def_nm",			false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "org_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "org_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "dest_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "dest_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
				
				Ellipsis = true;
//				WordWrap = true;
				CountPosition = 0;
				ColHidden("chk") = true;
				ColHidden("del_chk") = true;
				ColHidden("seq") = true;
				//Editable  = false;
				SelectHighLight = false;
				WaitImageVisible = false;
		    }
            break;
            
        case "sheet4":  // Grid 4 Rate
        	with (sheetObj) {
                // 높이 설정
                style.height = 152;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1  = "|Sel.|Seq.|Per|Cargo Type|Cur.|Quotation|Surcharge|Cost|Cost|CMPB|CMPB\nGuideline|OPB|Diff.|Source" +
                				  "|Rate Adjust|Rate Adjust|qttn_no|qttn_ver_no|cmdt_hdr_seq|rout_seq|rt_seq|src_info_cd" +
                				  "|qttn_init_rt_amt|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, true, "seq");
				InitDataProperty(0, cnt++ , dtCombo,		60,daCenter,	true,  "rat_ut_cd",			true,	"",	dfNone,		0,	true,	true);	
				InitDataProperty(0, cnt++ , dtCombo,		90,daCenter,	true,  "prc_cgo_tp_cd",		true,	"",	dfNone,		0,	true,	true);	
				InitDataProperty(0, cnt++ , dtCombo,		50,daCenter,	true,  "curr_cd",			true,	"",	dfNone,		0,	true,	true);	
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "qttn_rt_amt",		true,	"",	dfNullFloat,2,	true,	true, 9);	
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_scg_amt",		false,	"",	dfNullFloat,2,	false,	false);
				
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_respb_cm_uc_amt",		false,	"",	dfNullFloat,2,	false,	false);//CM Cost
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_respb_opfit_uc_amt",false,	"",	dfNullFloat,2,	false,	false);//OP Cost
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_respb_cmpb_amt",false,	"",	dfNullFloat,2,	false,	false);//CMPB
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_gid_cmpb_amt",  false,	"",	dfNullFloat,2,	false,	false);//Guideline
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_respb_opb_amt",  false,	"",	dfNullFloat,2,	false,	false);//OPB											
				
				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "diff",  false,	"",	dfNullFloat,2,	false,	false);//diff	
//				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "diff", false,	"|prs_gid_cmpb_amt|-|prs_respb_cmpb_amt|",	dfFloat,2,	false,	false);
//				InitDataProperty(0, cnt++ , dtData,			85,daRight,	true,  "prs_gid_opb_amt",  false,	"",	dfFloat,2,	false,	false);//OPB
				InitDataProperty(0, cnt++ , dtData,			70,daCenter,	true,  "src_info_nm",		false,	"",	dfNone,		0,	false,	false);	
				InitDataProperty(0, cnt++ , dtData,			20,daCenter,	true,  "qttn_rt_adj_tp_cd",		false,	"",	dfNone,0,false,	false);
				InitDataProperty(0, cnt++ , dtData,			60,daRight,	true,  "rate_adjust",  		false,	"",	dfNullFloat,2,	false,	false);
				
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
//                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);     
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", true, "", dfNone, 0, false, false);   
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "src_info_cd", true, "", dfNone, 0, false, false);  
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_init_rt_amt", true, "", dfFloat, 0, false, false); 
                
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prs_pfit_cm_uc_amt", true, "", dfNullFloat, 2, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prs_pfit_cmpb_amt", true, "", dfNullFloat, 2, false, false); 
	            
                CountPosition = 0;
                ColHidden("del_chk") = true;
                ColHidden("prs_respb_opfit_uc_amt") = true;
                ColHidden("prs_respb_opb_amt") = true;
                WaitImageVisible = false;
		    }
            break;
            
        	case "sheet5":  // commodity
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 100;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(10, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false)
	    
	                var HeadTitle = "5-1|5-2|5-3|cmdt_hdr_seq|cmdt_seq|prc_cmdt_tp_cd|prc_cmdt_def_cd|5-9|5-10";
	    
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	    
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	                // SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);        
	                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cmdt_seq", true, "", dfNone, 0, false, false);     
	                
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", 	false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "src_info_cd", true, "", dfNone, 0, false, false);  
	                WaitImageVisible = false;
	            }
	            break;   
            
        	case "sheet6":  // point origin
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 100;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(18, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false)
	    
	                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq|Term|rcv_de_term_nm|Trans. Mode";
	    
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	    
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	                // SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtData,	  40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtData,	  40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
	                
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
// 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);
 					
 					InitDataProperty(0, cnt++ , dtData, 105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData, 190, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
 					
 					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
 					
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "prc_trsp_mod_cd",	  false, "",	dfNone,	0,	true,	true);
					WaitImageVisible = false;
	            }
	            break; 
	            
	            
			case "sheet7":  // via origin
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 100;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(15, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false)
	    
	                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq";
	                 var headCount = ComCountHeadTitle(HeadTitle);
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, true, true, false,false)
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	
	//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
	//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
	//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
	//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
						InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
	 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
	 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
//	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);
						
						InitDataProperty(0, cnt++ , dtData,    90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
						WaitImageVisible = false;
	            }
	            break; 
	            
	            
			case "sheet8":  // point via
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 100;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(15, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false)
	    
	                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq";
	                 var headCount = ComCountHeadTitle(HeadTitle);
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, true, true, false,false)
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	
	//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
	//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
	//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
	//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
						InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
	 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
	 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
//	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
	 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
						
						InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
						InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);
						
						InitDataProperty(0, cnt++ , dtData,    90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
						WaitImageVisible = false;
	            }
	            break;      
	            
	            
			case "sheet9":  // point dest
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 100;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(18, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false)
	    
	                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq|Term|rcv_de_term_nm|Trans. Mode";
	        	    
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	    
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	                // SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtData,	    40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
	                
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
// 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);
 					
 					InitDataProperty(0, cnt++ , dtData, 105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
 					InitDataProperty(0, cnt++ , dtData, 190, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
 					
 					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
 					
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "prc_trsp_mod_cd",	  false, "",	dfNone,	0,	true,	true);
					WaitImageVisible = false;
	            }
	            break;
	            
			case "sheet10": // Excel Download용 Sheet(Vertical)
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 300;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 3, 100);
	    
	                var HeadTitle1 = "CMDT\nSeq.|Commodity Group|Commodity Group|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)";
	                var HeadTitle2 = "CMDT\nSeq.|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Rate";
	                var headCount = ComCountHeadTitle(HeadTitle2);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	        
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, false);
	    
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	                // SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNullInteger, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNullInteger, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "qttn_rt_amt", true, "", dfNullFloat, 2, false, false);
	                WaitImageVisible = false;
	            }
	            break;
	            
	        case "sheet11": // Excel Download용 Sheet(Horizontal)
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 300;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	    
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	    
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	    
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	    
	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 3, 100);
	    
	                var HeadTitle1 = "CMDT\nSeq.|Commodity Group|Commodity Group|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
	                var HeadTitle2 = "CMDT\nSeq.|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Y/N|Dry 20'|Dry 40'|Dry 40'HC|Dry 45'|RF 40'HC|RD 40'HC";
	                var headCount = ComCountHeadTitle(HeadTitle2);
	    
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	        
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, false);
	    
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	                // SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNullInteger, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNullInteger, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "dir_call_flg", true, "", dfNone, 0, false, false);	
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_dry20", true, "", dfNullFloat, 2, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_dry40", true, "", dfNullFloat, 2, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_dry40hc", true, "", dfNullFloat, 2, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_dry45", true, "", dfNullFloat, 2, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_rf40hc", true, "", dfNullFloat, 2, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "rate_rd40hc", true, "", dfNullFloat, 2, false, false);
	                WaitImageVisible = false;
	            }
	            break;      
        
        }
    }
    
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
        }
    }
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
        }
    }
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet4_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
        }
    }
    
    /**
     * description sheet에서 전체로우의 데이터가 없는 경우 row delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *    deleteRowEmpty(sheetObj, Row)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {int} Row  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function deleteRowEmpty(sheetObj, Row) {
 		
 		if(ComIsEmpty(sheetObj.CellValue(Row,"prc_cmdt_def_nm")) &&		
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_pnt_loc_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_pnt_loc_def_nm")) ) {
     			
 			sheetObj.RowDelete(Row, false);
     	}
 	}
    
    
    /**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet4_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
 		
 		for(var i=1; i<=sheetObj.RowCount; i++) {
 			
 			if (sheetObj.CellValue(i, "diff") < 0 ) {
   				sheetObj.CellFontColor(i, "diff") = sheetObj.RgbColor(255, 0, 0);
   			} else {
 	 			sheetObj.CellFontColor(i, "diff") = sheetObj.DataFontColor;
 	 		}
 			
 		}
 			
 	}
    
   
    /**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet5_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "prc_cmdt_def_nm");
//        	if (contentXml.length > 2) {
       		
 				sheetObjects[2].RemoveAll();
 			
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "prc_cmdt_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "prc_cmdt_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		var insertRow = 0;
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
		        		
		        		//키값이 같은 것만 걸른다	
		        		if (sheetObj.CellValue(i+1, "qttn_no") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "qttn_no")
		                        && sheetObj.CellValue(i+1, "qttn_ver_no") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "qttn_ver_no")
		                        && sheetObj.CellValue(i+1, "cmdt_hdr_seq") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq")) {
	
		        			if(insertCount > 0 ) {
		        				insertRow++;
			        			sheetObjects[2].DataInsert();
			        			
			        		}
		        			if(insertRow == 0) continue;
			        		sheetObjects[2].CellValue2(insertRow,"prc_cmdt_def_nm") = arrData[i];
		        		}
		        		
		        		insertCount--;
		        		
		         		
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//        	}	
//	        	sheetObjects[2].SelectCell(1,"prc_cmdt_def_nm");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet6_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_pnt_loc_def_nm");
//        	if (contentXml.length > 3) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");

	        	if(typeof arrData != "undefined" && arrData != null) {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		var rcv_de_term_nm = "";

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		//rcv_de_term_nm
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        			
		        		
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"org_rout_pnt_loc_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet7_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_via_port_def_nm");
//        	if (contentXml.length > 4) {

	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = arrData[i];
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet8_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		
	   	if (ErrMsg == "") {
//	    	sXmlContents += ComPriSheet2XmlContent(sheetObj, "dest_rout_via_port_def_nm");
//	    	if (contentXml.length > 5) {
	    		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
		        		
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = arrData[i];
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
	    }
          
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet9_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "dest_rout_pnt_loc_def_nm");
        	//if (contentXml.length > 6) {
        		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	
	        	if(typeof arrData != "undefined") {
	        		
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}

		        		var rcv_de_term_nm = "";
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
	        	
        	//}	
 		}		

 		sheetObjects[2].SelectCell(1,"seq");
// 		makeLoadXml(sheetObjects[2]);
    }
    
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet10_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
        	ComOpenWait(true);
            if (sheetObj.RowCount > 1000) {
                sheetObj.SpeedDown2Excel();
            } else {
                sheetObj.Down2Excel();
            }
            ComOpenWait(false);
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(CMDT)<br>
     * 엑셀 조회용 쉬트<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet11_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet11_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
        	ComOpenWait(true);
            if (sheetObj.RowCount > 1000) {
                sheetObj.SpeedDown2Excel(-1);
            } else {
                sheetObj.Down2Excel(-1);
            }
            ComOpenWait(false);
        }
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (errMsg != "") {
        	isOk = false;
        } else {
        	isOk = true;
        }
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet9_OnSaveEnd (sheetObj, errMsg) {
        if (errMsg != "") {
        	isOk = false;
        } else {
        	isOk = true;
        }
    }
    
 	
    /**
     * cm/op 라디오 버튼의 현재 세팅값을 리턴한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getBkgCmOp(formObj)
     * </pre>
     * @param {form} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function getBkgCmOp(formObj) {
 		if (formObj.bkg_cm_op_radio[0].checked == true){
        	return formObj.bkg_cm_op_radio[0].value;
        } else if(formObj.bkg_cm_op_radio[1].checked == true) {
        	return formObj.bkg_cm_op_radio[1].value;
        }
 	}

 	/**
     * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
     * 팝업 호출 후 리턴 값을 sheet에 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnPopupClick(sheetObj, Row, Col) 
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {int}  Row        
     * @param {int}  Col    
     * @return 없음
     * @version 2009.06.10
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
//        setGenSpclRtTpCd(formObj);
        
        if (colName == "prc_cmdt_def_cd") {
            var sUrl = "/hanjin/ESM_PRI_6060.do?qttn_no=" + formObj.qttn_no.value + 
            			"&qttn_ver_no=" + formObj.qttn_ver_no.value +
            			"&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value;

            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6060", 700, 259, true);
            
//            if (rtnVal == "O" && sheetObjects[4].IsDataModified) {
                var prevStatus = sheetObj.RowStatus(Row);
                var sCd = "";
                var sNm = "";
                
                for (var i = sheetObjects[4].HeaderRows; i <= sheetObjects[4].LastRow; i++) {
                    if (sheetObjects[4].CellValue(i, "qttn_no") == formObj.qttn_no.value
                            && sheetObjects[4].CellValue(i, "qttn_ver_no") == formObj.qttn_ver_no.value
                            && sheetObjects[4].CellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
                        if (sheetObjects[4].RowStatus(i) == "D") {
                            continue;
                        }
                        sCd += sheetObjects[4].CellValue(i, "prc_cmdt_def_cd");
                        sNm += sheetObjects[4].CellValue(i, "prc_cmdt_def_nm");
                        sCd += " / ";
                        sNm += " / ";
                    }
                }
                
                if (sCd != "") {
                	var lastIdx = sCd.lastIndexOf("/");
                	sCd = sCd.substring(0, lastIdx - 1);
                }
                if (sNm != "") {
                	var lastIdx = sNm.lastIndexOf("/");
                	sNm = sNm.substring(0, lastIdx - 1);
                }
                
                sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = sCd;
                sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = sNm;

                sheetObj.RowStatus(Row) = prevStatus;
            }
//        }
        
    }
    
    /**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * Location PopUp을 호출한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 이승준
	 * @version 2009.05.07
	 */  	
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        if (!LoadingComplete) {
            return;
        }
        
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        var sUrl = "/hanjin/ESM_PRI_6059.do?";
        var keyParam = "qttn_no=" + formObj.qttn_no.value + "&qttn_ver_no=" + formObj.qttn_ver_no.value + 
        			   "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&rout_seq=" + formObj.rout_seq.value + "&svc_scp_cd=" + parent.getSvcScpCd();
        sUrl += keyParam;

        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6059", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6059", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6059", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6059", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
    }
    
    /**
     * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
     * 팝업 화면에서 히든 쉬트로 값을 로드하면 각행을 구분자로 붙여서 한행으로 메인쉬트에 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheet2RowData(sheetObj, Row, Col)
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {int}  Row        
     * @param {int}  Col    
     * @return 없음
     * @version 2009.06.10
     */
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj = document.form;
        var prevStatus = sheetObj.RowStatus(Row);
        
//        if (sheetObjects[5].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[5].HeaderRows; i <= sheetObjects[5].LastRow; i++) {
                if (sheetObjects[5].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[5].CellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sCd;
//        }
        
//        if (sheetObjects[6].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
                if (sheetObjects[6].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[6].CellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sCd;
//        }
        
//        if (sheetObjects[7].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[7].HeaderRows; i <= sheetObjects[7].LastRow; i++) {
                if (sheetObjects[7].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[7].CellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sCd;
//        }
        
//        if (sheetObjects[8].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[8].HeaderRows; i <= sheetObjects[8].LastRow; i++) {
                if (sheetObjects[8].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[8].CellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sCd;
//        }
        
//        sheetObj.RowStatus(Row) = prevStatus;
    }
    
	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	if(!isFiredNested) {
    		selectedCmdtHdrSeq = sheetObj.CellValue(NewRow,"cmdt_hdr_seq");
    		doRowChange1(OldRow, NewRow, OldCol, NewCol);
    	}	
    }
    
    /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
        var adjNewRow = ComGetValidRow(sheetObjects[0],"cmdt_hdr_seq",selectedCmdtHdrSeq);
   
        if (!isFiredNested && OldRow != NewRow && !isDelete ) {
            if (sheetObjects[0].IsDataModified || sheetObjects[4].IsDataModified) {
            	isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW && sAction != IBDELETE) {
	                	isFiredNested = true;
	                    sheetObjects[0].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested = false;
                	}    
                } else {
                	isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
                
            }
            
            if (sheetObjects[1].IsDataModified
            		|| sheetObjects[3].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified) {
                isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    var rslt = doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested = true;
	                    sheetObjects[0].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested = false;
                	}    
                } else {
                    isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            } 
            else {
    
	            if (sAction == IBINSERT) {
	                isFiredNested = true;
	                var idx = sheetObjects[0].DataInsert();
	                selectedCmdtHdrSeq = parseInt(ComPriGetMax(sheetObjects[0], "cmdt_hdr_seq"),10) + 1;
	                isFiredNested = false;
	                return idx;
	            } else if (sAction == IBCOPYROW) {
	                isFiredNested = true;
	                var idx = sheetObjects[0].DataCopy();
	                selectedCmdtHdrSeq = parseInt(ComPriGetMax(sheetObjects[0], "cmdt_hdr_seq"),10) + 1;
	                isFiredNested = false;
	                return idx;
	            } else if(sAction != IBDELETE) {
	            	formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(adjNewRow, "cmdt_hdr_seq");
	                formObj.src_info_cd.value = sheetObjects[0].CellValue(adjNewRow, "seq");
	                
	                if(formObj.cmdt_hdr_seq.value == undefined || formObj.cmdt_hdr_seq.value == null || ComIsEmpty(formObj.cmdt_hdr_seq.value) || !ComIsNumber(formObj.cmdt_hdr_seq.value)) {
	                	formObj.cmdt_hdr_seq.value = sheetObjects[1].CellValue(sheetObjects[0].SelectRow,"cmdt_hdr_seq");
	                }
	                
	                if(formObj.src_info_cd.value == undefined || formObj.src_info_cd.value == null || ComIsEmpty(formObj.src_info_cd.value)) {
	                	formObj.src_info_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"seq");
	                }
	                
	                isFiredNested = true;
	                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	                isFiredNested = false;
	                
	                adjNewRow = ComGetValidRow(sheetObjects[1],"rout_seq",selectedRoutSeq);
	                
	                
	                if(adjNewRow != -1 && adjNewRow != 1) {
	                     sheetObjects[1].SelectCell(adjNewRow,0,false);
	                } else {
	                	doRowChange(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);
	                }
	                
	                selectedRoutSeq = -1;
	            }
            }    
        }
    }
    
    
    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	if(!isFiredNested || eventStatus != "IBSAVE") {
    		selectedRoutSeq = sheetObj.CellValue(NewRow,"rout_seq");
    		doRowChange(OldRow, NewRow, OldCol, NewCol);
    	}
        
    }
    
   
    
    var isFiredNested = false;
    var supressConfirm = false;
    /**
     * sheet2_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
        var adjNewRow = ComGetValidRow(sheetObjects[1],"rout_seq",selectedRoutSeq);
     
        if (!isFiredNested && OldRow != NewRow && !isDelete ) {
        	
        	if (sheetObjects[0].IsDataModified || sheetObjects[4].IsDataModified) {
            	
	              var rslt = false;
	              if (ComShowCodeConfirm("PRI00006")) {
	                  supressConfirm = true;
	                  var rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	                  supressConfirm = false;
	              }
	              if (rslt) {
	                  isFiredNested = true;
	                  sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
	                  isFiredNested = false;
	                  return -1;
	              } else {
	                  isFiredNested = true;
	                  sheetObjects[1].SelectCell(OldRow, OldCol, false);
	                  isFiredNested = false;
	              	  return -1;
	              }
            
            }
        	
        	
            if (sheetObjects[1].IsDataModified
                    || sheetObjects[3].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified) {
                isFiredNested = true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    var rslt = doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW && sAction != IBDELETE) {
	                    isFiredNested = true;
	                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested = false;
	                    return -1;
                	}    
                } else {
                    isFiredNested = true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            } 
//            else {
    
	            if (sAction == IBINSERT) {
	                isFiredNested = true;
	                var idx = sheetObjects[1].DataInsert();
	                selectedRoutSeq = parseInt(ComPriGetMax(sheetObjects[1], "rout_seq"),10) + 1;
	                isFiredNested = false;
	                return idx;
	            } else if (sAction == IBCOPYROW) {
	                isFiredNested = true;
	                var idx = sheetObjects[1].DataCopy();
	                selectedRoutSeq = parseInt(ComPriGetMax(sheetObjects[1], "rout_seq"),10) + 1;
	                isFiredNested = false;
	                return idx;
	            } else {
	                formObj.rout_seq.value = sheetObjects[1].CellValue(adjNewRow, "rout_seq");
	                
	                if(formObj.rout_seq.value == undefined || ComIsEmpty(formObj.rout_seq.value) || !ComIsNumber(formObj.rout_seq.value)) {
	                	formObj.rout_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rout_seq");
	                }
	                
	                LoadingComplete = false;
	                doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
	                adjNewRow = ComGetValidRow(sheetObjects[3],"rt_seq",selectedRtSeq);
	                sheetObjects[3].SelectCell(adjNewRow,0,false);
	                LoadingComplete = true;
	            }
//            }    
        }
    }
    
    
    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
     function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	   	  if(eventStatus != "IBSAVE") {
	   		  selectedRtSeq = sheetObj.CellValue(NewRow,"rt_seq");
	      }
     }
    
    
    /**
     * radio버튼 click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 이승준
     * @version 2009.04.17
     */ 	
 	function obj_click()
 	{	 		
 		var formObj = document.form;
         
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
 	
 	
 	/**
     * radio버튼 click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_click2()
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 이승준
     * @version 2009.04.17
     */ 	
 	function obj_click2()
 	{	 		
 		var formObj = document.form;
 		var auth = parent.document.form.authCode.value;
  		//권한이 없을경우 해당 로직을 수행하지 않는다.
  		if(auth != "S" && auth != "A") { 
  			return;
  		}
 		if(getBkgCmOp(formObj) == "CM") {
 			sheetObjects[3].ColHidden("prs_respb_cm_uc_amt")  = false;
 			sheetObjects[3].ColHidden("prs_gid_cmpb_amt")  = false;
 			sheetObjects[3].ColHidden("diff")  = false;

 			sheetObjects[3].ColHidden("prs_respb_opfit_uc_amt")  = true;
 			sheetObjects[3].ColHidden("prs_respb_opb_amt")  = true;
 			
 			//버튼명 수정
 			btn_cmpbviewall.innerText = "CMPB View All";
    		btn_cmviewall.innerText = "CM View All";
 		} else {
 			sheetObjects[3].ColHidden("prs_respb_cm_uc_amt")  = true;
 			sheetObjects[3].ColHidden("prs_gid_cmpb_amt")  = true;
 			sheetObjects[3].ColHidden("diff")  = true;

 			sheetObjects[3].ColHidden("prs_respb_opfit_uc_amt")  = false;
 			sheetObjects[3].ColHidden("prs_respb_opb_amt")  = false;
 			
 			//버튼명 수정
 			btn_cmpbviewall.innerText = "OPB View All";
    		btn_cmviewall.innerText = "OP View All";
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
     * @author 이승준
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
        
        case IBCLEAR: // 화면 로딩시 
            
            var sXml = "";
            var arrTemp;
            
            // per combo
            formObj.f_cmd.value = SEARCH03;
            formObj.etc5.value = "PRS";
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
//            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0, "D2");
            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D2","",true);
            
            //공통 cargo
            formObj.f_cmd.value = SEARCH19;
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
//            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", false, 0, "DR");
            
            //currency combo
            formObj.f_cmd.value = SEARCH06;
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
            setIBCombo(sheetObj, sXml, "curr_cd", false, 0, "USD");           
            
            isDelete = false;
           
            break;
            
            
        case IBSEARCH: // 조회
            if (!validateForm(sheetObj, document.form, sAction)) {
                return false;
            }
            
            try {
            	for (var i = 0; i < sheetObjects.length; i++) {
                	sheetObjects[i].WaitImageVisible = false;
                }
            	ComOpenWait(true);
            	
           
	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                	if (i == 4) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	
	                
	                if(formObj.cmdt_hdr_seq.value == undefined || formObj.cmdt_hdr_seq.value == null || ComIsEmpty(formObj.cmdt_hdr_seq.value) || !ComIsNumber(formObj.cmdt_hdr_seq.value)) {
	                	formObj.cmdt_hdr_seq.value = "";
	                }
	                
	                formObj.f_cmd.value = SEARCH01;
	                sheetObj.DoSearch("ESM_PRI_6014_03GS.do" , FormQueryString(formObj));
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    if (i == 4) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                if(formObj.cmdt_hdr_seq.value == undefined || formObj.cmdt_hdr_seq.value == null || ComIsEmpty(formObj.cmdt_hdr_seq.value) || !ComIsNumber(formObj.cmdt_hdr_seq.value)) {
	                	formObj.cmdt_hdr_seq.value = "";
	                }
	                
	                if(formObj.rout_seq.value == undefined || ComIsEmpty(formObj.rout_seq.value) || !ComIsNumber(formObj.rout_seq.value)) {
	                	formObj.rout_seq.value = "";
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                sheetObj.DoSearch("ESM_PRI_6014_03GS.do" , FormQueryString(formObj));
	                
	            } else if (sheetObj.id == "sheet4") {
	                for (var i = 3; i < sheetObjects.length; i++) {
	                    if (i == 4) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                isDelete = false;
	                
	                if(formObj.cmdt_hdr_seq.value == undefined || formObj.cmdt_hdr_seq.value == null || ComIsEmpty(formObj.cmdt_hdr_seq.value) || !ComIsNumber(formObj.cmdt_hdr_seq.value)) {
	                	formObj.cmdt_hdr_seq.value = "";
	                }
	                
	                if(formObj.rout_seq.value == undefined || ComIsEmpty(formObj.rout_seq.value) || !ComIsNumber(formObj.rout_seq.value)) {
	                	formObj.rout_seq.value = "";
	                }
	                
	                formObj.f_cmd.value = SEARCH03;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_6014_03GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[4].LoadSearchXml(arrXml[0]);    // commodity.
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[1]);    // Grid3.
	                if (arrXml.length > 2) sheetObjects[5].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Point.
	                if (arrXml.length > 3) sheetObjects[6].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Origin Via.
	                if (arrXml.length > 4) sheetObjects[7].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Via.
	                if (arrXml.length > 5) sheetObjects[8].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Destination Point.
	                
	            }    
	            
	            ComOpenWait(false);

            } catch (e) {
                if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e);
                }
            } finally {
               ComOpenWait(false);
            }
            
            toggleButtons("INIT");
             
            break;
    
        case IBSAVE: // 저장
            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
                return false;
            }


            if (sheetObj.id == "sheet1") {
            	
            	if(!supressConfirm && !ComPriConfirmSave()) return;
            	
            	try {
                	ComOpenWait(true);
               
            	
	            	eventStatus = "IBSAVE";
	            	
	            	setRowStatus(sheetObjects[4],"I");
	                
	            	
	                formObj.f_cmd.value = MULTI01;
	                
	                var sParam = FormQueryString(formObj);
	                var sParamSheet1 = sheetObjects[0].GetSaveString();
	                if (sParamSheet1 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	                }
	                
	                var sParamSheet5 = sheetObjects[4].GetSaveString();
	                if (sParamSheet5 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
	                }
	               
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_6014_03GS.do", sParam);
	                sheetObjects[4].LoadSaveXml(sXml);
	                sheetObjects[0].LoadSaveXml(sXml);
	                
	                ComOpenWait(false);

            	} catch (e) {
            	    if (e == "[object Error]") {
            	        ComShowMessage(OBJECT_ERROR);
            	    } else {
            	        ComShowMessage(e);
            	    }
            	} finally {
            	   ComOpenWait(false);
            	}
                
				parent.setTabStyle();
                if(isOk) ComPriSaveCompleted();

 
                isFiredNested = true;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                isFiredNested = false;
                
                
                var validRow = ComGetValidRow(sheetObj,"cmdt_hdr_seq",selectedCmdtHdrSeq);
                
                if(validRow != -1 && validRow != 1) {
                	formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cmdt_hdr_seq");
	            	formObj.src_info_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "seq");
	            	
		 			sheetObjects[0].SelectCell(validRow,0,false);
		 		} else {
		 			
		 			 formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cmdt_hdr_seq");
	            	 formObj.src_info_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "seq");
	               
	            	 isFiredNested = true;
	            	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	            	 isFiredNested = false;
	            	 
	            	 validRow = ComGetValidRow(sheetObjects[1],"rout_seq",selectedRoutSeq);
		             sheetObjects[1].SelectCell(validRow,0,false);
		             
		             
		             if(validRow == -1 || validRow == 1) {
		            	 
		            	 doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);

             			 validRow = ComGetValidRow(sheetObjects[3],"rt_seq",selectedRtSeq);
    	                 sheetObjects[3].SelectCell(validRow,0,false);
		             }
		             
		 		}
                
                eventStatus = "";

               
            } else if (sheetObj.id == "sheet4") {
            	
            	for (var i = 5; i < 9; i++) {
                    setRowStatus(sheetObjects[i],"I");
                }
            	
                formObj.f_cmd.value = MULTI02;
                var sParam = FormQueryString(formObj);
                var sParamSheet2 = sheetObjects[1].GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                var sParamSheet3 = sheetObjects[3].GetSaveString();
                if (sParamSheet3 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet4_");
                }
                var sParamSheet5 = sheetObjects[5].GetSaveString();
                if (sParamSheet5 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet6_");
                }
                var sParamSheet6 = sheetObjects[6].GetSaveString();
                if (sParamSheet6 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet7_");
                }
                var sParamSheet7 = sheetObjects[7].GetSaveString();
                if (sParamSheet7 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet8_");
                }
                var sParamSheet8 = sheetObjects[8].GetSaveString();
                if (sParamSheet8 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet9_");
                }
        
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }
                
                eventStatus = "IBSAVE";
                
                isDelete = false;
                
                try {
                	ComOpenWait(true);
               
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_6014_03GS.do", sParam);
	                sheetObjects[8].LoadSaveXml(sXml);
	                sheetObjects[7].LoadSaveXml(sXml);
	                sheetObjects[6].LoadSaveXml(sXml);
	                sheetObjects[5].LoadSaveXml(sXml);
	                sheetObjects[3].LoadSaveXml(sXml);
	                sheetObjects[1].LoadSaveXml(sXml);
	                
	                ComOpenWait(false);

                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                   ComOpenWait(false);
                }
	                
                
                if (sheetObjects[1].IsDataModified
                        || sheetObjects[3].IsDataModified
                        || sheetObjects[5].IsDataModified
                        || sheetObjects[6].IsDataModified
                        || sheetObjects[7].IsDataModified
                        || sheetObjects[8].IsDataModified) {
                	eventStatus = "";
                    return false;
                } else {
//					if (getValidRowCount(sheetObjects[2]) <= 0) {
//						doRowChange2(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);
//					}
                	
                	if(isOk) ComPriSaveCompleted();
					
					parent.setTabStyle();
                	
                	
                	isFiredNested = true;
                	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                	isFiredNested = false;
                	
                	var validRow = ComGetValidRow(sheetObjects[1],"rout_seq",selectedRoutSeq);

                	
                	if(validRow != -1 && validRow != 1) {
             			sheetObjects[1].SelectCell(validRow,0,false);
             		} else {
             			formObj.rout_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
    	                
             			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);

             			validRow = ComGetValidRow(sheetObjects[3],"rt_seq",selectedRtSeq);
    	                sheetObjects[3].SelectCell(validRow,0,false);
    	     		}
                	
                	eventStatus = "";
                    
                    return true;
                }
            }
            return true;
            break;
    
       
        case IBINSERT: // Row Add
            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
                return false;
            }
            
            
            if (sheetObj.id == "sheet1") {
                
            	var idx = doRowChange1(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
                if (idx < 0) {
                    return false;
                }
                
                isDelete = false;
            	
                sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
                sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
                sheetObj.CellValue(idx, "cmdt_hdr_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
                sheetObj.CellValue(idx, "src_info_cd") = "NW";
                
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
//                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                sheetObjects[6].RemoveAll();
                sheetObjects[7].RemoveAll();
                sheetObjects[8].RemoveAll();
                
                formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
                
                sheet1_OnPopupClick(sheetObj, idx, 3);

            }
            if (sheetObj.id == "sheet2") {
                var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
                if (idx < 0) {
                    return false;
                }
                
                isDelete = false;
            	
//            	var idx = sheetObj.DataInsert();
            	
                sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
                sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
                sheetObj.CellValue(idx, "cmdt_hdr_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
                sheetObj.CellValue(idx, "rout_seq") = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
                sheetObj.CellValue(idx, "dir_call_flg") = "N";
                sheetObj.CellValue(idx, "src_info_cd") = "NW";
                formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
                //route seq
                sheetObj.CellValue(idx, "seq") = getMaxRoutDetailSeq();
                
                sheetObjects[3].RemoveAll();
                sheetObjects[5].RemoveAll();
                sheetObjects[6].RemoveAll();
                sheetObjects[7].RemoveAll();
                sheetObjects[8].RemoveAll();
                
                sheet2_OnPopupClick(sheetObj, idx, 9);
                
//                setDescSheet();
            }
            if (sheetObj.id == "sheet4") {
            	
            	isDelete = false;
            	
                var idx = sheetObj.DataInsert();
                
                sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
                sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
                sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
                sheetObj.CellValue(idx, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
                sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;
                sheetObj.CellValue(idx, "src_info_cd") = "NW";
                
                sheetObj.SelectCell(idx, "rat_ut_cd", false);
            	
            }
            break;
            
        case IBCOPYROW: // Row Add
            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
                return false;
            }
            
            isDelete = false;
            
            
            if (sheetObj.id == "sheet1") {
                
            	var prevCmdtHdrSeq = sheetObj.CellValue(sheetObj.SelectRow, "cmdt_hdr_seq");
                
                var idx = doRowChange1(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
                if (idx < 0) {
                    return false;
                }
                
                var newCmdtHdrSeq = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
                
                sheetObj.CellValue(idx, "cmdt_hdr_seq") = newCmdtHdrSeq;
                
                formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
                
                //sheetObjects[4] copy
                for (var i = sheetObjects[4].LastRow; i >= sheetObjects[4].HeaderRows; i--) {
                    if (sheetObjects[4].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
                        sheetObjects[4].SelectCell(i, 0);
                        var insIdx = sheetObjects[4].DataCopy();
                        sheetObjects[4].CellValue(insIdx, "cmdt_hdr_seq") = newCmdtHdrSeq;
                    }
                }
                
                for (var i = 1; i < sheetObjects.length; i++) {
                	if (i == 4) {
                		continue;
                	}
                	sheetObjects[i].RemoveAll();
                }

            }
            if (sheetObj.id == "sheet2") {
            	var prevRoutSeq = sheetObj.CellValue(sheetObj.SelectRow, "rout_seq");
                
                var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
                if (idx < 0) {
                    return false;
                }
                
                var newRoutSeq = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
                sheetObj.CellValue(idx, "rout_seq") = newRoutSeq;
                
                formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
                //route seq
                sheetObj.CellValue(idx, "seq") = getMaxRoutDetailSeq();
                
                //sheetObjects[5,6,7,8] copy
                for (var a = 5; a <= 8; a++) {
                	if (sheetObjects[a].RowCount <= 0) {
                		continue;
                	}
                    for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
                        var colName = "";
                        if (a == 5 || a == 8) {
                            colName = "rout_pnt_seq";
                        } else if (a == 5 || a == 6) {
                            colName = "rout_via_seq";
                        }
                        sheetObjects[a].CellValue(i, "rout_seq") = newRoutSeq;
                        sheetObjects[a].CellValue(i, colName) = i;
                        sheetObjects[a].RowStatus(i) = "I";
                    }
                }
                
                for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow && sheetObjects[3].RowCount > 0; i++) {
                    sheetObjects[3].CellValue(i, "rout_seq") = newRoutSeq;
                    sheetObjects[3].CellValue(i, "rt_seq") = i;
                    sheetObjects[3].RowStatus(i) = "I";
                }
            }
            
            if (sheetObj.id == "sheet4") {
            	var idx = sheetObj.DataCopy();
            	sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
                sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
                sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
                sheetObj.CellValue(idx, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
                sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;
                sheetObj.CellValue(idx, "src_info_cd") = "NW";
                sheetObj.SelectCell(idx, "rat_ut_cd", false);
            
                //CALCULATE로 생성된 값은 COPY하지 않는다.
                sheetObjects[3].CellValue(i, "prs_scg_amt") = "";
                sheetObjects[3].CellValue(i, "prs_respb_cm_uc_amt") = "";
                sheetObjects[3].CellValue(i, "prs_respb_opfit_uc_amt") = "";
                sheetObjects[3].CellValue(i, "prs_respb_cmpb_amt") = "";
                sheetObjects[3].CellValue(i, "prs_gid_cmpb_amt") = "";
                sheetObjects[3].CellValue(i, "prs_respb_opb_amt") = "";
                sheetObjects[3].CellValue(i, "diff") = "";
            
            }
            
            
            break;
            
        case IBDELETE: // Delete
        	if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
                return false;
            }
        	
        	
        	//삭제 플래그 세팅
        	isDelete = true;
        	
        	if (sheetObj.CheckedRows("chk") <= 0) {
        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
        	}
           
            
            var delCnt = deleteRowCheck(sheetObj, "chk");
            
            isDelete = false;
            
            if (delCnt > 0 && sheetObj.id == "sheet1") {
         	
            	 
                 var chkArr = ComPriSheetFilterRows(sheetObj, "ibflag", "D");
                 
                 for(var i=0;i < chkArr.length;i++) {
                 	var delSeq = sheetObj.CellValue(chkArr[i],"cmdt_hdr_seq");
                 	
                 	for (var k = sheetObjects[4].HeaderRows; k <= sheetObjects[4].LastRow; k++) {
                 		if(delSeq == sheetObjects[4].CellValue(k,"cmdt_hdr_seq") ) {
//                 			sheetObjects[4].RowDelete(k, false);
                 			sheetObjects[4].RowStatus(k) = "D";
                 		}
                 	}
                 }
            	
                isDelete = true;
                for (var i = 1; i < sheetObjects.length; i++) {
                	if (i == 4) {
                		continue;
                	}
                    sheetObjects[i].RemoveAll();
                }
                isDelete = false;
            }
            
            
            isDelete = true;
            if (delCnt > 0 && sheetObj.id == "sheet2") {
                for (var i = 2; i < sheetObjects.length; i++) {
                	if (i == 4) {
                		continue;
                	}
                    sheetObjects[i].RemoveAll();
                }
            }
            isDelete = false;
            
            break;
            
            
        case IBDOWNEXCEL:

        	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			}
          
            if (sheetObj.id == "sheet10") {
                formObj.f_cmd.value = SEARCH10;
                sheetObj.DoSearch("ESM_PRI_6014_03GS.do", FormQueryString(formObj));
            } else if (sheetObj.id == "sheet11") {
                formObj.f_cmd.value = SEARCH11;
                sheetObj.DoSearch("ESM_PRI_6014_03GS.do", FormQueryString(formObj));                
            }
          
            break;
            
//        case IBSEARCH_ASYNC01: // GLINE COPY
//        	
//        	if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
//				return false;
//			}
//        	
////        	if (!ComShowCodeConfirm('PRI03006')) return;
//			
//			formObj.f_cmd.value = MULTI03;
//			
//			var sParam = FormQueryString(formObj);
//			
//			var prcCustTpCd = parent.document.form.estm_mqc_qty.value;
//			if(ComIsEmpty(parent.document.form.estm_mqc_qty.value)) {
//				prcCustTpCd = "0";
//			}
//			
//			sParam += "&prc_cust_tp_cd="+parent.getPrcCustTpCd();
//			sParam += "&estm_mqc_qty="+prcCustTpCd;
//			
//			var sXml = sheetObj.GetSaveXml("ESM_PRI_6014_03GS.do", sParam);
//			sheetObj.LoadSaveXml(sXml);
//			
//			ComPriSaveCompleted();
//			
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			
//			break;
			
		case IBSEARCH_ASYNC02: // GLINE 존재여부
//			if (validateForm(sheetObj,document.form,sAction)) {
			
			try {
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH03;
//				var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
				
				
				var sParam = FormQueryString(formObj);
				
				var prcCustTpCd = parent.document.form.estm_mqc_qty.value;
				if(ComIsEmpty(parent.document.form.estm_mqc_qty.value)) {
					prcCustTpCd = "0";
				}
				
				sParam += "&prc_cust_tp_cd="+parent.getPrcCustTpCd();
				sParam += "&estm_mqc_qty="+prcCustTpCd;
				
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6014GS.do", sParam);
				
				
				var arrTabCnt = ComPriXml2Array(sXml, "rate_chk|loc_chk|cmdt_chk|cmdt_tpw_chk");
				if (arrTabCnt != null && arrTabCnt.length > 0) {
					formObj.rate_cnt.value = arrTabCnt[0][0];
					formObj.loc_chk.value = arrTabCnt[0][1];
					formObj.cmdt_chk.value = arrTabCnt[0][2];
					formObj.cmdt_tpw_chk.value = arrTabCnt[0][3];
					
					if(formObj.loc_chk.value != "0" || formObj.cmdt_chk.value != "0" || formObj.cmdt_tpw_chk.value != "0") {
						//LOC OR CMDT DATE EXIST 시 COPY 불가
						formObj.rate_chk.value = "-1"
					} else {
						formObj.rate_chk.value = arrTabCnt[0][0];
					}
				}
				
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}
//			}
			break;	   
			
			
        case IBSEARCH_ASYNC03:
        	try {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH04;
				param = FormQueryString(formObj);
				sXml = sheetObj.GetSearchXml("ESM_PRI_6014_03GS.do", param);
				if( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == 'F' ){
					sheetObj.LoadSearchXml(sXml);
				}else{
					ComBtnDisable("btn3_Calculate");
					initBatchJobMonitor();
					calcStatusStr = getScheduleUtilStatusStr("1");
					PRE_STATUS = "1";
					monitoringBatchJob();
				}
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}
        	break;
        	
        	
        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
	          var sXml = ""; 
	          
	          isOViaMandatory = false;
	          isDViaMandatory = false;
	          
				formObj.f_cmd.value = COMMAND17;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i = 0; i < arrTemp.length; i++) {
						var pptCd = arrTemp[i][1];
						if (pptCd == "ROVA") {
							isOViaMandatory = true;
						} else if (pptCd == "RDVA") {
							isDViaMandatory = true;
						} 
					}
				}
				
				break;
    
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
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
    function validateForm(sheetObj, formObj, sAction) {
    	
    	var qttn_sts_cd  = parent.document.form.qttn_sts_cd.value;
    	
        switch (sAction) {
        case IBSEARCH: // 조회
            if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                return false;
            } else {
                return true;
            }
            break;
    
        case IBSAVE: // 저장
            if (sheetObj.id == "sheet1") {
            	
            	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                    return false;
                }
            	
            	if(qttn_sts_cd == 'P') return false;
            	
                if (!sheetObjects[0].IsDataModified && !sheetObjects[4].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (sheetObjects[0].IsDataModified
                        && sheetObjects[0].GetSaveString() == "") {
                    return false;
                }
                
                
//                var rowDup = sheetObjects[0].ColValueDup("prc_cmdt_def_cd", false);
//                if (rowDup >= 0) {
//                    ComShowCodeMessage("PRI00303", "Sheet1", rowDup);
//                    return false;
//                }
                
            } else if (sheetObj.id == "sheet4") {
            	
            	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                    return false;
                }
            	
            	if(qttn_sts_cd == 'P') return false;
            	
            	if (sheetObjects[4].RowCount <= 0 || sheetObjects[4].SelectRow <= 0 
						|| getValidRowCount(sheetObjects[4]) <= 0) {

					ComPriInputValueFailed("input ","Commodity Group","");
//					sheet2_OnPopupClick(sheetObjects[1], idx, 8);
                    return false;
                }
            	
            	
                if (!sheetObjects[1].IsDataModified
                        && !sheetObjects[3].IsDataModified
                        && !sheetObjects[5].IsDataModified
                        && !sheetObjects[6].IsDataModified
                        && !sheetObjects[7].IsDataModified
                        && !sheetObjects[8].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                
                if (sheetObjects[0].IsDataModified) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
                
                
                if (sheetObjects[1].IsDataModified
                        && sheetObjects[1].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[3].IsDataModified
                        && sheetObjects[3].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[5].IsDataModified
                        && sheetObjects[5].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[6].IsDataModified
                        && sheetObjects[6].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[7].IsDataModified
                        && sheetObjects[7].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[8].IsDataModified
                        && sheetObjects[8].GetSaveString() == "") {
                    return false;
                }
                
  
				if ((sheetObjects[5].RowCount <= 0 || sheetObjects[5].SelectRow <= 0 
						|| getValidRowCount(sheetObjects[5]) <= 0) 
						&& !isDeleted(sheetObjects[1])) {
					ComPriInputValueFailed("input ","Origin","");
//    					doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
//    					sheet2_OnPopupClick(sheetObjects[1], idx, 8);
                    return false;
                }
				
				if ((sheetObjects[6].RowCount <= 0 || sheetObjects[6].SelectRow <= 0 
						|| getValidRowCount(sheetObjects[6]) <= 0)
						&& isOViaMandatory
						&& !isDeleted(sheetObjects[1])) {
					ComPriInputValueFailed("input","O.Via","");
//    					doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
//    					sheet2_OnPopupClick(sheetObjects[1], idx, 9);
                    return false;
                }
				
				if ((sheetObjects[7].RowCount <= 0 || sheetObjects[7].SelectRow <= 0 
						|| getValidRowCount(sheetObjects[7]) <= 0)
						&& isDViaMandatory
						&& !isDeleted(sheetObjects[1])) {
					ComPriInputValueFailed("input ","D.Via","");
//    					doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
//    					sheet2_OnPopupClick(sheetObjects[1], idx, 10);
                    return false;
                }
				
				if ((sheetObjects[8].RowCount <= 0 || sheetObjects[8].SelectRow <= 0 
						|| getValidRowCount(sheetObjects[8]) <= 0)
						&& !isDeleted(sheetObjects[1])) {
					ComPriInputValueFailed("input ","Destiantion","");
//    					doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
//    					sheet2_OnPopupClick(sheetObjects[1], idx, 11);
                    return false;
                }
    			
    			
    			
    			if (!isDeleted(sheetObjects[1])	&& getValidRowCount(sheetObjects[3]) <= 0) {
    				ComShowCodeMessage("PRI00007");
    				doActionIBSheet(sheetObjects[3], document.form, IBINSERT);
    				return false;
    			}
    			
                var rowDup = sheetObjects[3].ColValueDup("rat_ut_cd|prc_cgo_tp_cd", false);
                if (rowDup >= 0) {
                    ComShowCodeMessage("PRI00303", "Rate", rowDup);
                    return false;
                }
                
            }
    
            return true;
            break;
    
     
        case IBINSERT: // Row Add
            if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                return false;
            }
            
            if(qttn_sts_cd == 'P') return false;
            
            if (sheetObj.id == "sheet2" || sheetObj.id == "sheet4") {
                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0 
                		|| sheetObjects[0].SearchRows <= 0 || sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != 'R') {
                	ComShowCodeMessage("PRI03009", "Commodity Group");
                    return false;
                }
            } 
            
//            else if (sheetObj.id == "sheet4") {
//                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0 || sheetObjects[1].SearchRows <= 0) {
//                	ComShowCodeMessage("PRI03009", "Route Detail");
//                    return false;
//                }
//            }
            
            return true;
            break;
            
        case IBCOPYROW: // Row Add
        	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                return false;
            }
        	
        	if(qttn_sts_cd == 'P') return false;
        	
        	if (sheetObj.id == "sheet2" || sheetObj.id == "sheet4") {
                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0 
                		|| sheetObjects[0].SearchRows <= 0 || sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != 'R') {
                	ComShowCodeMessage("PRI03009", "Commodity Group");
                    return false;
                }
            } 
        	
//        	if (sheetObj.id == "sheet2") {
//                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
//                    return false;
//                }
//            } 
//        	else if (sheetObj.id == "sheet4") {
//                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
//                    return false;
//                }
//            }
        	
            if (sheetObj.RowCount <= 0 || sheetObj.SelectRow <= 0) {
                return false;
            }
            
            return true;
            break;
    
        case IBDELETE: // Delete
        	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                return false;
            } 
        	
        	if(qttn_sts_cd == 'P') return false;
        	
        	if (sheetObj.id == "sheet2" || sheetObj.id == "sheet4") {
                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0 
                		|| sheetObjects[0].SearchRows <= 0 || sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != 'R') {
                	ComShowCodeMessage("PRI03009", "Commodity Group");
                    return false;
                }
            } 
        	
        	return true;
            break;
            
        case IBSEARCH_ASYNC01: // GLINE COPY
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			}
			
			if(qttn_sts_cd == 'P') return false;
			
			if (sheetObjects[0].SearchRows != 0) {
				return false;
			}
			
			doActionIBSheet(sheetObjects[9],document.form,IBSEARCH_ASYNC02);
			
			if(formObj.rate_cnt.value == '0') {
				ComShowCodeMessage("PRI00331", "Copy");
				return false;
			}
			
//			if(formObj.rate_cnt.value == '-1') {
////				ComShowCodeMessage("PRI00331", "Copy");
//				alert("not copy");
//				return false;
//			}
			
			return true;
			break;  
			
			
        case IBSEARCH_ASYNC02: // GLINE COPY
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			}
			
//			if(qttn_sts_cd == 'P') return false;
			
			if (sheetObjects[0].SearchRows == 0) {
				return false;
			}
			
//			doActionIBSheet(sheetObjects[9],document.form,IBSEARCH_ASYNC02);
			
//			if(formObj.rate_cnt.value == '0') {
//				ComShowCodeMessage("PRI00331", "Copy");
//				return false;
//			}
		
			return true;
			break; 	
            
        }
    }
    
    
    /**
     * 히든 쉬트의 정보를 XML로 변환하여 리턴한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getSheetXml(sheetNo)
     * </pre>
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function getSheetXml(sheetNo) {
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        if (sheetNo == 4) {
            sCol = "qttn_no|qttn_ver_no|cmdt_hdr_seq";
            sValue = formObj.qttn_no.value + "|" + formObj.qttn_ver_no.value + "|" + formObj.cmdt_hdr_seq.value;
        }

        sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        
        return sXml;
    }
    
    /**
 	 * popup 창에서 선택한 row 를 hidden grid에 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        var sCol = "";
        var sValue = "";
        var bAppendMode = 0;
        
        if (sheetNo == 4) {
            bAppendMode = 1;
            sCol = "qttn_no|qttn_ver_no|cmdt_hdr_seq";
            sValue = formObj.qttn_no.value + "|" + formObj.qttn_ver_no.value + "|" + formObj.cmdt_hdr_seq.value;
        } else {
        	sheetObjects[sheetNo].RemoveAll();
        }
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
        
        if (sheetNo != 4) {
        	setRowStatus(sheetObjects[sheetNo],"I");
        }	
    }
    
    /**
 	 * 쉬트를 초기화한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    removeSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        
        sheetObjects[sheetNo].RemoveAll();
       
    }
    
    
    /**
 	 * popup에서 값 세팅 시 row status 세팅.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowStatus(sheetObj,status)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} status 쉬트 상태값 (curd)
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setRowStatus(sheetObj,status)  {
 		
 		for(var i=1; i<=sheetObj.RowCount; i++) {
 			
 			sheetObj.RowStatus(i) = status;
 			
 		}

 	}

 	/**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function toggleButtons(mode) {
    	
    	var qttn_sts_cd  = parent.document.form.qttn_sts_cd.value;
    	//권한
    	var auth = parent.document.form.authCode.value;
    	
    	var isEmpty = true;
//    	var rate_cnt = parent.document.form.rate_cnt.value;

    	if (sheetObjects[0].SearchRows > 0) {
    		isEmpty = false;
    	}
    	
    	switch (mode) {
        case "CLEAR":
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_Adjust");
        	ComBtnDisable("btn_checkduplicate");
        	ComBtnDisable("btn_Excel");
        	ComBtnDisable("btn_Load");
        	
        	ComBtnDisable("btn1_Add");
        	ComBtnDisable("btn1_Copy");
        	ComBtnDisable("btn1_Delete");
        	ComBtnDisable("btn1_Save");
        	ComBtnDisable("btn2_Add");
        	ComBtnDisable("btn2_Copy");
        	ComBtnDisable("btn2_Delete");
        	ComBtnDisable("btn3_Add");
        	ComBtnDisable("btn3_Copy");
        	ComBtnDisable("btn3_Delete");
        	ComBtnDisable("btn3_Save");
            
            ComBtnDisable("btn3_Calculate");
            ComBtnDisable("btn_SchgDetail");
            ComBtnDisable("btn_schgviewall");
            ComBtnDisable("btn_SchgAdjust");
            ComBtnDisable("btn_CostDetail");
            ComBtnDisable("btn_CostbyTransMode");
            ComBtnDisable("btn_CMPBViewAll");
            ComBtnDisable("btn_CMViewAll");
        
            break;
        case "INIT":
        	//상태가 proposed 인 경우가 아니면
        	if(qttn_sts_cd == 'N') {
        	
        		if(isEmpty) {
        			if(auth == "S" || auth == "A") {
	        			ComBtnEnable("btn_Retrieve");
		        		ComBtnDisable("btn_Adjust");
		        		ComBtnDisable("btn_checkduplicate");
		        		ComBtnEnable("btn_Excel");
		        		ComBtnEnable("btn_Load");
		        		
		        		ComBtnEnable("btn1_Add");
		        		ComBtnEnable("btn1_Copy");
		        		ComBtnEnable("btn1_Delete");
		        		ComBtnEnable("btn1_Save");
		        		ComBtnEnable("btn2_Add");
		        		ComBtnEnable("btn2_Copy");
		        		ComBtnEnable("btn2_Delete");
		        		ComBtnEnable("btn3_Add");
		        		ComBtnEnable("btn3_Copy");
		        		ComBtnEnable("btn3_Delete");
		        		ComBtnEnable("btn3_Save");
		        		
		        		ComBtnDisable("btn3_Calculate");
		        		ComBtnDisable("btn_SchgDetail");
		        		ComBtnDisable("btn_schgviewall");
		        		ComBtnDisable("btn_SchgAdjust");
		        		ComBtnDisable("btn_CostDetail");
		        		ComBtnDisable("btn_CostbyTransMode");
		        		ComBtnDisable("btn_CMPBViewAll");
		        		ComBtnDisable("btn_CMViewAll");
		        		
		        		sheetControl(true);
		        		
        			} else {
        				ComBtnEnable("btn_Retrieve");
	            		ComBtnDisable("btn_Adjust");
	            		ComBtnDisable("btn_checkduplicate");
	            		ComBtnEnable("btn_Excel");
	            		ComBtnDisable("btn_Load");
	            		
	            		ComBtnDisable("btn1_Add");
	                	ComBtnDisable("btn1_Copy");
	                	ComBtnDisable("btn1_Delete");
	                	ComBtnDisable("btn1_Save");
	                	ComBtnDisable("btn2_Add");
	                	ComBtnDisable("btn2_Copy");
	                	ComBtnDisable("btn2_Delete");
	                	ComBtnDisable("btn3_Add");
	                	ComBtnDisable("btn3_Copy");
	                	ComBtnDisable("btn3_Delete");
	                	ComBtnDisable("btn3_Save");
	                    
	                    ComBtnDisable("btn3_Calculate");
	                    ComBtnDisable("btn_SchgDetail");
	                    ComBtnDisable("btn_schgviewall");
	                    ComBtnDisable("btn_SchgAdjust");
	                    ComBtnDisable("btn_CostDetail");
	                    ComBtnDisable("btn_CostbyTransMode");
	                    ComBtnDisable("btn_CMPBViewAll");
	                    ComBtnDisable("btn_CMViewAll");
	                    
	                    sheetControl(false);
        				
        			}
	                
	        	} else {
	        		if(auth == "S" || auth == "A") {
		        		ComBtnEnable("btn_Retrieve");
		        		ComBtnEnable("btn_Adjust");
		        		ComBtnEnable("btn_checkduplicate");
		        		ComBtnEnable("btn_Excel");
		        		ComBtnEnable("btn_Load");
		        		
		        		ComBtnEnable("btn1_Add");
		        		ComBtnEnable("btn1_Copy");
		        		ComBtnEnable("btn1_Delete");
		        		ComBtnEnable("btn1_Save");
		        		ComBtnEnable("btn2_Add");
		        		ComBtnEnable("btn2_Copy");
		        		ComBtnEnable("btn2_Delete");
		        		ComBtnEnable("btn3_Add");
		        		ComBtnEnable("btn3_Copy");
		        		ComBtnEnable("btn3_Delete");
		        		ComBtnEnable("btn3_Save");
			        	
			        	ComBtnEnable("btn3_Calculate");
			        	ComBtnEnable("btn_SchgDetail");
			        	ComBtnEnable("btn_schgviewall");
			        	ComBtnEnable("btn_SchgAdjust");
			        	ComBtnEnable("btn_CostDetail");
			        	ComBtnEnable("btn_CostbyTransMode");
			        	ComBtnEnable("btn_CMPBViewAll");
			        	ComBtnEnable("btn_CMViewAll");
			        	
			        	sheetControl(true);
			        	
	        		} else {
	        			ComBtnEnable("btn_Retrieve");
	            		ComBtnDisable("btn_Adjust");
	            		ComBtnDisable("btn_checkduplicate");
	            		ComBtnEnable("btn_Excel");
	            		ComBtnDisable("btn_Load");
	            		
	            		ComBtnDisable("btn1_Add");
	                	ComBtnDisable("btn1_Copy");
	                	ComBtnDisable("btn1_Delete");
	                	ComBtnDisable("btn1_Save");
	                	ComBtnDisable("btn2_Add");
	                	ComBtnDisable("btn2_Copy");
	                	ComBtnDisable("btn2_Delete");
	                	ComBtnDisable("btn3_Add");
	                	ComBtnDisable("btn3_Copy");
	                	ComBtnDisable("btn3_Delete");
	                	ComBtnDisable("btn3_Save");
	                    
	                    ComBtnDisable("btn3_Calculate");
	                    ComBtnDisable("btn_SchgDetail");
	                    ComBtnDisable("btn_schgviewall");
	                    ComBtnDisable("btn_SchgAdjust");
	                    ComBtnDisable("btn_CostDetail");
	                    ComBtnDisable("btn_CostbyTransMode");
	                    ComBtnDisable("btn_CMPBViewAll");
	                    ComBtnDisable("btn_CMViewAll");
	                    
	                    sheetControl(false);
	        		}
	        	}
        	} else if(qttn_sts_cd == 'P' || qttn_sts_cd == 'C') {
        		ComBtnEnable("btn_Retrieve");
        		ComBtnDisable("btn_Adjust");
        		ComBtnDisable("btn_checkduplicate");
        		ComBtnEnable("btn_Excel");
        		ComBtnDisable("btn_Load");
        		
        		ComBtnDisable("btn1_Add");
            	ComBtnDisable("btn1_Copy");
            	ComBtnDisable("btn1_Delete");
            	ComBtnDisable("btn1_Save");
            	ComBtnDisable("btn2_Add");
            	ComBtnDisable("btn2_Copy");
            	ComBtnDisable("btn2_Delete");
            	ComBtnDisable("btn3_Add");
            	ComBtnDisable("btn3_Copy");
            	ComBtnDisable("btn3_Delete");
            	ComBtnDisable("btn3_Save");
                ComBtnDisable("btn3_Calculate");
                
                if(auth == "S" || auth == "A") {
	                ComBtnEnable("btn_SchgDetail");
	                ComBtnEnable("btn_schgviewall");
	                ComBtnEnable("btn_SchgAdjust");
	                ComBtnEnable("btn_CostDetail");
	                ComBtnEnable("btn_CostbyTransMode");
	                ComBtnEnable("btn_CMPBViewAll");
	                ComBtnEnable("btn_CMViewAll");
                }else{
                	ComBtnDisable("btn_SchgDetail");
                	ComBtnDisable("btn_schgviewall");
                	ComBtnDisable("btn_SchgAdjust");
                	ComBtnDisable("btn_CostDetail");
                	ComBtnDisable("btn_CostbyTransMode");
                	ComBtnDisable("btn_CMPBViewAll");
                	ComBtnDisable("btn_CMViewAll");
                }
                
                sheetControl(false);
                
        	} else {
        		ComBtnDisable("btn_Retrieve");
        		ComBtnDisable("btn_Adjust");
        		ComBtnDisable("btn_checkduplicate");
        		ComBtnDisable("btn_Excel");
        		ComBtnDisable("btn_Load");
        		
        		ComBtnDisable("btn1_Add");
            	ComBtnDisable("btn1_Copy");
            	ComBtnDisable("btn1_Delete");
            	ComBtnDisable("btn1_Save");
            	ComBtnDisable("btn2_Add");
            	ComBtnDisable("btn2_Copy");
            	ComBtnDisable("btn2_Delete");
            	ComBtnDisable("btn3_Add");
            	ComBtnDisable("btn3_Copy");
            	ComBtnDisable("btn3_Delete");
            	ComBtnDisable("btn3_Save");
                
                ComBtnDisable("btn3_Calculate");
                ComBtnDisable("btn_SchgDetail");
                ComBtnDisable("btn_schgviewall");
                ComBtnDisable("btn_SchgAdjust");
                ComBtnDisable("btn_CostDetail");
                ComBtnDisable("btn_CostbyTransMode");
                ComBtnDisable("btn_CMPBViewAll");
                ComBtnDisable("btn_CMViewAll");
                
                sheetControl(false);
        	}
            break;

       
        }
    }
    
    
 	/**
     * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag 필수          
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */   
     function sheetControl(flag) {
	     	var sheetObj1 = sheetObjects[0];
	     	var sheetObj2 = sheetObjects[1];
	     	var sheetObj3 = sheetObjects[3];
	     	
			for (var i = 1; i <= sheetObj1.RowCount;i++) {
				sheetObj1.CellEditable(i, "chk") = flag;
				sheetObj1.CellEditable(i, "prc_cmdt_def_cd") = flag;
		    }
			
			for (var i = 1; i <= sheetObj2.RowCount;i++) {
				sheetObj2.CellEditable(i, "chk") = flag;
				sheetObj2.CellEditable(i, "org_rout_pnt_loc_def_cd") = flag;
				sheetObj2.CellEditable(i, "org_rout_via_port_def_cd") = flag;
				sheetObj2.CellEditable(i, "dest_rout_via_port_def_cd") = flag;
				sheetObj2.CellEditable(i, "dest_rout_pnt_loc_def_cd") = flag;
			}
			
			for (var i = 1; i <= sheetObj3.RowCount;i++) {
				sheetObj3.CellEditable(i, "chk") = flag;
				sheetObj3.CellEditable(i, "rat_ut_cd") = flag;
				sheetObj3.CellEditable(i, "prc_cgo_tp_cd") = flag;
				sheetObj3.CellEditable(i, "curr_cd") = flag;
				sheetObj3.CellEditable(i, "qttn_rt_amt") = flag;
				sheetObj3.CellEditable(i, "prs_scg_amt") = flag;
				sheetObj3.CellEditable(i, "prs_respb_cm_uc_amt") = flag;
				sheetObj3.CellEditable(i, "prs_respb_opfit_uc_amt") = flag;
				sheetObj3.CellEditable(i, "prs_respb_cmpb_amt") = flag;
				sheetObj3.CellEditable(i, "prs_gid_cmpb_amt") = flag;
				sheetObj3.CellEditable(i, "prs_respb_opb_amt") = flag;
				sheetObj3.CellEditable(i, "diff") = flag;
				sheetObj3.CellEditable(i, "qttn_rt_adj_tp_cd") = flag;
				sheetObj3.CellEditable(i, "rate_adjust") = flag;
			}

     }  
 	
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Min값이나 Max값을 변경 시 입력된 값의 validation을 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 이벤트가 발생한 해당 셀의 Column Index
     * @param {string, int, number, bool} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.22
     */
    function sheet4_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
                var validPerClass = "A,F,O,Q,S,P";
                var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
                }
            }
        }
        
        if (colName == "rat_ut_cd") {
        	var validPerClass = "A,F,O,Q,S,P";
            var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "DR"
            } else if (perClass == "R") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "RF"
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "AK"
            } else {
            	if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
            	}
            }
        }
        
        
        if (colName == "qttn_rt_amt") {
        	if(sheetObj.RowStatus(Row) == "U") {
	        	sheetObj.CellValue2(Row, "qttn_rt_adj_tp_cd") = "M";

	        	////////////////////rate 수정시 값 세팅/////////////////////////////////
	        	var qttn_rt_amt = ComNullToZero(ComTrimAll(sheetObj.CellValue(Row, "qttn_rt_amt")));
	        	var prs_scg_amt = ComNullToZero(ComTrimAll(sheetObj.CellValue(Row, "prs_scg_amt")));
	        	
	        	var prs_respb_cm_uc_amt = ComNullToZero(ComTrimAll(sheetObj.CellValue(Row, "prs_respb_cm_uc_amt")));
	        	
	        	var prs_pfit_cm_uc_amt = ComNullToZero(ComTrimAll(sheetObj.CellValue(Row, "prs_pfit_cm_uc_amt")));
	        	var prs_respb_opfit_uc_amt = ComNullToZero(ComTrimAll(sheetObj.CellValue(Row, "prs_respb_opfit_uc_amt")));
	        	
	        	
	        	//1.qttn_rt_amt + prs_scg_amt - prs_respb_cm_uc_amt = prs_respb_cmpb_amt
	        	sheetObj.CellValue2(Row,"prs_respb_cmpb_amt") = 
	        		parseFloat(Number(qttn_rt_amt)) + parseFloat(Number(prs_scg_amt)) - parseFloat(Number(prs_respb_cm_uc_amt));
	        	
	        	//2.qttn_rt_amt + prs_scg_amt - prs_respb_cm_uc_amt = prs_pfit_cmpb_amt
	        	sheetObj.CellValue2(Row,"prs_pfit_cmpb_amt") = 
	        		parseFloat(Number(qttn_rt_amt)) + parseFloat(Number(prs_scg_amt)) - parseFloat(Number(prs_pfit_cm_uc_amt));
	        	
	        	//3.qttn_rt_amt + prs_scg_amt - prs_respb_opfit_uc_amt = prs_respb_opb_amt
	        	sheetObj.CellValue2(Row,"prs_respb_opb_amt") = 
	        		parseFloat(Number(qttn_rt_amt)) + parseFloat(Number(prs_scg_amt)) - parseFloat(Number(prs_respb_opfit_uc_amt));
	        	
        	}
        }              
    }
    
 	/**
     * excel upload 후 재조회용 함수.<br>
     * <br><b>Example :</b>
     * <pre>
     *     reSearch()
     * </pre>
     * @param 없음    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function reSearch() {
    	parent.setTabStyle();
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    
    /**
     * Duplicate pop 에서 sheet click 시 이벤트 발생시 호출되는 function <br>
     * 선택된 데이터로 다시 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 이벤트가 발생한 해당 셀의 Column Index
     * @param {string, int, number, bool} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.22
     */
    function moveRowPosTo(cmdtHdrSeq, routeSeq, rtSeq) {

    	if (cmdtHdrSeq != null && cmdtHdrSeq != "" && cmdtHdrSeq != undefined) {
    		s1PrevRow = sheetObjects[0].FindText("cmdt_hdr_seq", cmdtHdrSeq);
            s2PrevRow = 1;
    	} else {
            s1PrevRow = 1;
            s2PrevRow = 1;
    	}

        sheetObjects[0].SelectRow = s1PrevRow;
        sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, false);
        doRowChange1(-1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, IBSEARCH);
    	
    	if (routeSeq != null && routeSeq != "" && routeSeq != undefined) {
    		s2PrevRow = sheetObjects[1].FindText("rout_seq", routeSeq);
    	} else {
            s2PrevRow = 1;
    	}

    	sheetObjects[1].SelectRow = s2PrevRow;
    	sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, false);
    	doRowChange(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);

    	if (rtSeq != null && rtSeq != "" && rtSeq != undefined) {
    		s3PrevRow = sheetObjects[3].FindText("rt_seq", rtSeq);
    	} else {
            s3PrevRow = 1;
    	}

    	sheetObjects[3].SelectRow = s3PrevRow;
    	sheetObjects[3].SelectCell(sheetObjects[3].SelectRow, sheetObjects[3].SelectCol, false);
    }
    
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 활성화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr)
     * </pre>
     * @param {String} qttn_no   	
     * @param {String} qttn_ver_no 
     * @param {String} svc_scp_cd 
     * @param {String} eff_dt 
     * @param {String} exp_dt 
     * @param {boolean} isAproUsr  권한이 있는지 여부
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr) {
        var formObject = document.form;
        
        if (formObject.qttn_no.value != qttn_no || formObject.qttn_ver_no.value != qttn_ver_no || sheetObjects[0].RowCount <= 0) {
	    	formObject.qttn_no.value = qttn_no;
			formObject.qttn_ver_no.value = qttn_ver_no;
			formObject.svc_scp_cd.value = svc_scp_cd;
			formObject.eff_dt.value = eff_dt;
			formObject.exp_dt.value = exp_dt;
			
			
			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC20);
			
			// O.Via 필수여부
            if (isOViaMandatory) {
                sheetObjects[1].InitDataProperty(0, 10, dtPopup, 110, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
                sheetObjects[1].InitDataProperty(0, 10, dtPopup, 110, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
            
            // D.Via 필수여부
            if (isDViaMandatory) {
                sheetObjects[1].InitDataProperty(0, 11, dtPopup, 110, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
                sheetObjects[1].InitDataProperty(0, 11, dtPopup, 110, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
			
			
			
	        
	        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	        
	        toggleButtons("INIT");
	        //권한에 따라 PRS 컬럼들을 숨긴다.
	        hidePRSColumns();
	        
	        /* Calculate Button 관련 로직 시작*/
	        initBatchJobMonitor()
	        monitoringBatchJob();    
	        
        }    

    }
    
	/**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 초기화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabClearSheet()
     * </pre>
     * @param 없음 
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabClearSheet() {
        var formObject = document.form;
    
        formObject.reset();
        
        for (var i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
       
        toggleButtons("CLEAR");
        
        obj_click2();
    }
    
    var enableFlag = true;
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 초기화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabClearSheet()
     * </pre>
     * @param 없음 
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabEnableSheet(flag) {

        toggleButtons("INIT");
        hidePRSColumns();
        
    }
    
    
   
 	/**
 	 * Route Detail sheet에서 Row add 시 호출된다.<br>
 	 * 현재 cmdt seq와 조합하여 Route seq를 하나 증가한 값을 리턴한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getMaxRoutDetailSeq()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function getMaxRoutDetailSeq()  {
 		var sheetObj1 = sheetObjects[0];
 		var sheetObj2 = sheetObjects[1];
 		//cmdt seq
 		var cmdtSeq = sheetObj1.CellValue(sheetObj1.SelectRow,"seq");
 		var maxRoutSeq = ComPriGetMax(sheetObj2, "dataSeq");
 
 

 		return cmdtSeq + "." + maxRoutSeq;
 	}
 	
 	/**
 	 * window가 resize 시 sheet col width를 재조정한다.<br>
 	 * <br><b>Example :</b>
     * <pre>
     *    onResize="cellWidthResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheetColResize() {

// 		var sheetObj1 = sheetObjects[0];
 		var sheetObj2 = sheetObjects[1];
 		var sheetObj3 = sheetObjects[2];
 		var sheetObj4 = sheetObjects[3];
 		
 		sheetObj2.FitColWidth("0|7.5|0|7|0|0|0|0|0|21|20.5|20.5|20");
  		sheetObj3.FitColWidth("0|0|0|30|18|16.5|16.5|16");
  		sheetObj4.FitColWidth("0|5|5|6|9|5|8.5|8.5|8.5|8.5|8.5|8.5|8.5|8.5|7.6|2|7|0|0|0|0|0|0|0|0|0");
 		
 	}
 	
 	/**
     * popup 저장후 재조회시 호출한다. <br>
     * 조회 후 선택된 로우에 다시 포커스를 맞춘다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     popupSearch();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
    function popupSearch() {
    	
    	var formObj = document.form;
    	
    	eventStatus = "IBSAVE";
    	
    	isFiredNested = true;
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        isFiredNested = false;
        
        
        var validRow = ComGetValidRow(sheetObjects[0],"cmdt_hdr_seq",selectedCmdtHdrSeq);
        
        if(validRow != -1 && validRow != 1) {
        	formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cmdt_hdr_seq");
        	formObj.src_info_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "seq");
        	
 			sheetObjects[0].SelectCell(validRow,0,false);
 		} else {
 				 
        	 formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cmdt_hdr_seq");
        	 formObj.src_info_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "seq");
           
        	 isFiredNested = true;
        	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        	 isFiredNested = false;
        	 
        	 validRow = ComGetValidRow(sheetObjects[1],"rout_seq",selectedRoutSeq);
        	 
        	 if(validRow != -1 && validRow != 1) {
        		 sheetObjects[1].SelectCell(validRow,0,false);
        	 } else {
        		 doRowChange(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);
	         }
        	 
 		}
        
        eventStatus = "";
    }
 	
 	


  	/**
  	 * calculate 버튼에 마우스가 over됐을때 상태 Text를 보여준다..<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *
  	 * </pre>
  	 * @param {object} e 필수, Event Object
  	 * @return 없음
  	 * @author 송민석
  	 * @version 2009.10.01
  	 */
      function btn3_Calculate_OnMouseOver(e){
      	var parentObj = document.getElementById("btn3_Calculate");
      	openDynamicPopup(-12,parentObj.clientHeight*-1 - 2,100,20,parentObj);
      }
      
  	/**
  	 * calculate 버튼에 마우스가 over됐을때 상태 Text를 감춰준다..<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *
  	 * </pre>
  	 * @param {object} e 필수, Event Object
  	 * @return 없음
  	 * @author 송민석
  	 * @version 2009.10.01
  	 */    
      function btn3_Calculate_OnMouseOut(e){
      	if( oPopup != null){
      		oPopup.hide();
      	}
      }
      var oPopup = null;
      var calcStatusStr = "Nothing";
      var timeID = "";
      var PRE_STATUS = "";
  	/**
  	 * calculate 버튼에 마우스가 over됐을때 보여줄 Text Div 생성 <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *
  	 * </pre>
  	 * @param {object} x 필수, x좌표
  	 * @param {object} y 필수, y좌표
  	 * @param {object} width 필수, 넓이
  	 * @param {object} height 필수, 높이
  	 * @param {object} parentObj 필수, parent Object
  	 * @return object, div object
  	 * @author 송민석
  	 * @version 2009.10.01
  	 */    
      function openDynamicPopup(x,y,width,height,parentObj){
          if( oPopup == null){
              oPopup = window.createPopup(); 
              var oPopBody = oPopup.document.body;
              oPopBody.style.backgroundColor = "lightyellow";
              oPopBody.style.border = "solid black 1px";
              oPopBody.style.padding= "2px"
             	oPopBody.style.fontFamily="Tahoma,verdana,arial,dotum,gulim";
              oPopBody.style.fontSize="12px"
              	 
          }
          oPopup.document.body.innerHTML =calcStatusStr;
          oPopup.show(x,y,width,height,parentObj);
          return oPopup;

      } 
      
      
  	/**
  	 * 현재 batch 수행상태에 따라 버튼의 활성,비활시 시키고 <br>
  	 * 수행상태 Text를 변화시킨다.
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *
  	 * </pre>
  	 * @param {string} sXml, sheet를 이용해 조회된 조회 xml
  	 * @return 없음
  	 * @author 송민석
  	 * @version 2009.10.01
  	 */        
      function updateMonitoringValue(sXml){
  		var status = ComGetEtcData(sXml,"BATCH_STATUS");
  		var jobid = ComGetEtcData(sXml,"JOB_ID");   
  		var isFinish = false;
  		calcStatusStr = getScheduleUtilStatusStr(status);// +"/jobid="+jobid+"/status="+status ;
  		if( ( (jobid == undefined || jobid == "") && status == "0" ) // 최초 실행시 버튼이 비활성화 되는것을 막고
  		    || ( status == "4"                                       // direct로 Batch Job을 실행시킬때 생기는 Delay로 몇초간은 상태가 Nothing으로 return되는것을 대비
  			|| status == "5" 
  			|| status == "6" 
  			|| status == "7" 
  			|| status == "10"
  			|| status == "90"
  			|| status == "99" ) ){ //수행 성공과 무관하게 수행 종료 버튼 활성화

  	    	var qttn_sts_cd  = parent.document.form.qttn_sts_cd.value;
  			var auth  = parent.document.form.authCode.value;
  	    	
  	    	var isEmpty = true;
 
  			
  			
  			if(sheetObjects[0].SearchRows > 0) {
  				isEmpty = false;
  			}
			//상태가 proposed 인 경우가 아니면
        	if(qttn_sts_cd == 'N') {
        		if(isEmpty) {
	        		ComBtnDisable("btn3_Calculate");
	        	} else {
	        		if(auth == "S" || auth == "A") {
			        	ComBtnEnable("btn3_Calculate");
	        		} else {
		        		ComBtnDisable("btn3_Calculate");
	        		}
	        	}
        	} else if(qttn_sts_cd == 'P' || qttn_sts_cd == 'C') {
                ComBtnDisable("btn3_Calculate");
        	} else {
                ComBtnDisable("btn3_Calculate");
        	} 			
  			
  			//성공일경우 Rate Sheet를 Retrieve 시킨다.
  			if( (PRE_STATUS == "1" || PRE_STATUS == "0") && status == "4"){
  				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  				parent.getPRSCMData();
  			}
  			isFinish = true;
  		}else{
  			ComBtnDisable("btn3_Calculate");
  			isFinish = false;
  		}
  		PRE_STATUS = status;
  		return isFinish;
      }
       
      function monitoringBatchJob(){
      	//개발시에는 모니터링을 하지 않는다.
      	if(ComPriIsLocalhost() == true){
      		return;
      	}  	  
 
      	if( document.form.qttn_no.value == "" ){
      		getScheduleUtilStatusStr("0");
      		disableButton("btn3_Calculate");
      		return;
      	}
      	var sheetObj = sheetObjects[10];
      	var formObj = document.form;
  		formObj.f_cmd.value = SEARCH05;
  		 
  		var sXml = sheetObj.GetSearchXml("ESM_PRI_6014_03GS.do", FormQueryString(formObj) ) ;

		if( updateMonitoringValue(sXml) == false ){
			timeID = setTimeout(monitoringBatchJob,3000);
		}
  
   
  /*  
  			status	0	<NULL>	알수없음 
  			status	1	RUNNING	수행중 
  			status	3	STARTING	시작(시스템)
  			status	4	SUCCESS	성공 
  			status	5	FAILURE  실패 	
  			status	6	TERMINATED	강제종료 
  			status	7	ON_ICE	 논리삭제 
  			status	8	INACTIVE	실행대기
  			status	9	ACTIVATED	 활성화(시스템)
  			status	10	RESTART	시작시에러
  			status	11	ON_HOLD	일시정지 
  			status	12	QUE_WAIT	 로드밸런싱 대기 

   */		

      }
      
      
  	/**
  	 * 메인페이지에서 retrieve,new 됐을때 호출된다.<BR>
  	 * batch job 관련 초기화
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *
  	 * </pre>
  	 * @return 없음
  	 * @author 송민석
  	 * @version 2009.11.25
  	 */      
      function initBatchJobMonitor(){
         if( timeID != "" ){
         	clearTimeout(timeID)
         }
      	PRE_STATUS = "";
      }     	
  	 
   	/**
   	 *권한에 따라 PRS컬럼을 숨긴다..<BR>
   	 * 
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @return 없음
   	 * @author 송민석
   	 * @version 2010.02.18
   	 */     	 
  	function hidePRSColumns(){
   		 
   	
  		var sheetObj = sheetObjects[3];
  		var auth  = parent.document.form.authCode.value;
  		//권한이 없을경우 컬럼들을 숨긴다.
  		if(auth != "S" && auth != "A") { 
  			sheetObj.ColHidden("prs_scg_amt")  = true;
  			sheetObj.ColHidden("prs_respb_cm_uc_amt")  = true;
  			sheetObj.ColHidden("prs_respb_opfit_uc_amt")  = true;
  			sheetObj.ColHidden("prs_respb_cmpb_amt")  = true;
  			sheetObj.ColHidden("prs_gid_cmpb_amt")  = true;
  			sheetObj.ColHidden("prs_respb_opb_amt")  = true;
  			sheetObj.ColHidden("diff")  = true;
  		}else{
  			sheetObj.ColHidden("prs_respb_cmpb_amt")  = false;
  			sheetObj.ColHidden("prs_scg_amt")  = false;
  			obj_click2();
  		}
  		
  	}
    
    
	/* 개발자 작업  끝 */