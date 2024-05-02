﻿﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3001.js
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.05.30 서미진 [CHM-201111190-01] Excel Download 시, "Internal Remarks" 부분이 보이도록 수정
* 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
	 * @class ESM_PRI_3001 : ESM_PRI_3001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_3001() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 생성권한자. Proposal을 신규로 생성할수 있는 권한.
	var bIsCreUsr = false;
	// 수정권한자. 기존 생성되어있는 Proposal을 수정하거나 Request할 수 있는 권한.
    var bIsReqUsr = false;
    // 승인권한자. Approve, Publish등을 수행할 수 있는 권한.
    var bIsAproUsr = false;
    
    // 로그인한 사용자가 선택된 Traiff(결국 Scope)에 권한이 있는지를 저장하는 변수.
    var bHasAuthTariff = false;
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();
    
    var BACKEND_JOB_ID  = "";
    var TIMER_ID = "";
    var ARRAY_BACKENDJOB_TYPE = new Array();
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && (srcName.indexOf("btn") == 0 || srcName.indexOf("srch_btn") == 0)) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
	
			case "btn_retrieve_s":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_new_s":
				doActionIBSheet(sheetObjects[0], document.form, IBRESET);
				break;
	
			case "btn_grical_s":
            	ComPriOpenWindowCenter("/hanjin/ESM_PRI_3010.do?" + FormQueryString(formObject), "ESM_PRI_3010", 900, 520, false);
				break;
				
			case "btn_request_s":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
				break;
				
			case "btn_rcancel_s":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC15);
				break;
				
			case "btn_approve_s":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC12);
				break;
				
			case "btn_acancel_s":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC16);
				break;
				
			case "btn_publish_s":
	            if (!validateForm(sheetObjects[0], document.form, IBSEARCH_ASYNC13)) {
	                return false;
	            }
	            
	            var sUrl = "/hanjin/ESM_PRI_3018.do?" + FormQueryString(document.form);
				ComPriOpenWindowCenter(sUrl, "ESM_PRI_3018", 250, 160, true);
				
				break;
/*	
			case "btn_send_s":
	            if (!validateForm(sheetObjects[0], document.form, IBSEARCH_ASYNC17)) {
	                return false;
	            }
	            
	            var sUrl = "/hanjin/ESM_PRI_3014.do?" + FormQueryString(document.form);
				ComPriOpenWindowCenter(sUrl, "ESM_PRI_3014", 900, 460, true);
				
				break;
*/			
				
			case "btn_downexcel_s":
	        	sheetObjects[0].Down2Excel(-1, false, false, true, "", "apps/alps/esm/pri/triproposal/triproposal/script/ESM_PRI_3001.xml", false, false, "", false, "chk");
				break;
	
			case "srch_btn_srch_cmdt":
	            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
	            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";

				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 320, true);
				if (rtnVal != null){
					formObject.srch_cmdt_cd.value = rtnVal.cd;
					//formObject.srch_cmdt_nm.value = rtnVal.nm;
				}
				break;
			
			case "srch_is_gri_appl":

				break;
				
			case "srch_btn_acc_dt":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
			    var cal = new ComCalendar();
			    cal.select(formObject.srch_acc_dt, 'yyyy-MM-dd');
				break;
				
			case "srch_btn_grieffdt":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
                var cal = new ComCalendar();
                cal.select(formObject.srch_gri_eff_dt, 'yyyy-MM-dd');
				break;
	
			case "btn_conversion":
				  var pgmNo = "ESM_PRI_3006";
                  var pgmUrl = "/hanjin/ESM_PRI_3006.do"
                  var parentPgmNo = pgmNo.substring(0, 8)+'M001';  
                  var param = "&trf_cd="+comboObjects[0].Code;
                  var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + param;
                  var sUrl = "alpsMain.screen?parentPgmNo=" + parentPgmNo + src;
                  var iWidth = 1024;
                  var iHeight = 700;
                  var leftpos = (screen.width - iWidth) / 2;
                  if (leftpos < 0)
                      leftpos = 0;
                  var toppos = (screen.height - iHeight) / 2;
                  if (toppos < 0)
                      toppos = 0;

                  var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
                  ComPriOpenWindow(sUrl, "", sFeatures, iHeight);
				break;
	
			case "btn_srch_cmdt":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
	            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
	            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";

				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 320, true);
				if (rtnVal != null){
					formObject.srch_cmdt_cd.value = rtnVal.cd;
					//formObject.srch_cmdt_nm.value = rtnVal.nm;
					formObject.cmdt_cd.value = rtnVal.cd;
					formObject.cmdt_nm.value = rtnVal.nm;
					
					formObject.cmdt_cd.readOnly = true;
					btnImgEnable("btn_srch_cmdt", false);
				}
				break;
	
			case "btn_taalist":
				var sUrl = "/hanjin/ESM_PRI_3004.do?" + FormQueryString(document.form);
				ComPriOpenWindowCenter(sUrl, "ESM_PRI_3004", 900, 300, true);
				break;
	
			case "btn_srch_org_pnt":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
				onClickRoutePoint(srcName);
				break;
	
			case "btn_srch_org_via":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
				onClickRoutePoint(srcName);
				break;
	
			case "btn_srch_dest_via":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
				onClickRoutePoint(srcName);
				break;
	
			case "btn_srch_dest_pnt":
				if (window.event.srcElement.Enable == false) {
					return;
				}
				
				onClickRoutePoint(srcName);
				break;
	
			case "rdoPRSCostLevel":
				onCickRdoPRSCostLevel();
				break;
	
			case "btn_calculate":
            	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC08);
				break;
	
			case "btn_schgdetail":
            	if (sheetObjects[2].IsDataModified) {
            		ComShowCodeMessage("PRI00309", "Rate");
            		return false;
            	}
            	
            	var sUrl = "/hanjin/ESM_PRI_6085.do?" + FormQueryString(formObject);
                
                var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6085", 900, 545, true);
                if (rtnVal == "SUCCESS") {
                	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                }
				break;
	
			case "btn_costdetail":
            	var sUrl = "/hanjin/ESM_PRI_6084.do?" + FormQueryString(formObject);
            	var selRow = sheetObjects[1].SelectRow;
                sUrl += "&cost_tp=" + getRdoPRSCostLevel().charAt(0); //C :CM, O:OP
                sUrl += "&revenue=" + ComTrunc(parseFloat(ComPriNvl(sheetObjects[1].CellValue(selRow, "prop_frt_rt_amt"), 0)) +
                	      parseFloat(ComPriNvl(sheetObjects[1].CellValue(selRow, "prs_scg_amt"), 0)));
                sUrl += "&cargo=" + sheetObjects[1].CellValue(selRow, "prc_cgo_tp_cd");
                sUrl += "&per=" + sheetObjects[1].CellValue(selRow, "rat_ut_cd" );
                sUrl += "&contract_ofc=" + sheetObjects[1].CellValue(selRow, "tri_rqst_ofc_cd" );

                var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6084", 900, 605, true);
                if (rtnVal == "SUCCESS") {
                	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                }
				break;
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
				break;
	
			case "btn_new":
				doActionIBSheet(sheetObjects[1], document.form, IBCREATE);
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				break;
	
			case "btn_request":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
				break;
	
			case "btn_amend":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
				break;
	
			case "btn_coffer":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
				break;
	
			case "btn_approve":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
				break;
	
			case "btn_publish":
	            var sUrl = "/hanjin/ESM_PRI_3015.do?" + FormQueryString(document.form);
	            sUrl += "&eff_dt=" + ComGetMaskedValue(sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "eff_dt"), "ymd");
	            sUrl += "&exp_dt=" + ComGetMaskedValue(sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "exp_dt"), "ymd");
	            sUrl += "&last_pub_dt=";
	            if (sheetObjects[1].RowCount >= 2) {
	            	sUrl += ComGetMaskedValue(sheetObjects[1].CellValue(sheetObjects[1].HeaderRows + 1, "pub_dt"), "ymd");
	            }

				ComPriOpenWindowCenter(sUrl, "ESM_PRI_3015", 500, 280, true);
				
				break;
	
			case "btn_assign":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC06);
				break;
	
			case "btn_cancel":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC07);
				break;
				
			case "btn_copy":
				doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
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
	 * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initControl()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
   function initControl() {
       //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListener('mouseover', 'btn_calculate_OnMouseOver', 'btn_calculate');  
       axon_event.addListener('mouseout', 'btn_calculate_OnMouseOut', 'btn_calculate');
  }    
	
	/**
	 * Route Select - OnClick 이벤트 발생시 호출되는 function <br>
	 *
	 * @param {string} colName 필수 Onclick 이벤트가 발생한 source name
	 * @return 없음
	 * @author 박성수
	 * @version 2009.11.21
	 */
    function onClickRoutePoint(colName) {
        var formObj = document.form;
        
        var sUrl = "/hanjin/ESM_PRI_3016.do?" + FormQueryString(document.form);

        if (colName == "btn_srch_org_pnt") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3016", 550, 320, true);
        }
        if (colName == "btn_srch_org_via") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3016", 550, 320, true);
        }
        if (colName == "btn_srch_dest_via") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3016", 550, 320, true);
        }
        if (colName == "btn_srch_dest_pnt") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3016", 550, 320, true);
        }
    }
	
	/**
	 * PRS Cost Level - OnClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.11.21
	 */
    function onCickRdoPRSCostLevel() {
    	if (bIsReqUsr || bIsAproUsr) {
        	if (getRdoPRSCostLevel() == "CM") {
        		sheetObjects[1].ColHidden("prs_respb_cm_uc_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_opfit_uc_amt") = true;
        		sheetObjects[1].ColHidden("prs_gid_cmpb_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_opb_amt") = true;
        		sheetObjects[1].ColHidden("diff") = false;
        	} else if (getRdoPRSCostLevel() == "OP") {
        		sheetObjects[1].ColHidden("prs_respb_cm_uc_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_opfit_uc_amt") = false;
        		sheetObjects[1].ColHidden("prs_gid_cmpb_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_opb_amt") = false;
        		sheetObjects[1].ColHidden("diff") = true;
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * IBCombo Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setComboObject(combo_obj);
	 * </pre>
	 * @param {ibcombo} combo_obj 필수 IBCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
        for (var i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
	    
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
        
        doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
        
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		
		document.form.is_req_usr.value = bIsReqUsr;
		document.form.is_apro_usr.value = bIsAproUsr;
        
        toggleButtons("CLEAR");
        
        document.form.rdoPRSCostLevel[0].click();
        
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
	}
	
    /**
     * OnKeyDown event를 처리한다. <br> 검색부분에서 엔터키를 치면 검색이 되도록 한다.
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       
   function obj_keydown(){
       var eleName = event.srcElement.name;
       if (eleName.indexOf("srch_") == 0) {
	       var keyValue = null;
	       if (event == undefined || event == null) {
	    	   keyValue = 13;
	       } else {
	    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	       }
	       if (keyValue == 13) {
	    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	       }
       }
   }
	
	/**
	 * OnKeyPress event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_keypress() {
        if (event.srcElement.name == "srch_tri_no") {
        	ComKeyOnlyNumber(event.srcElement);
        }
        
        if (event.srcElement.name == "srch_gri_eff_dt") {
        	ComKeyOnlyNumber(event.srcElement);
        }
        
        if (event.srcElement.name == "srch_acc_dt") {
        	ComKeyOnlyNumber(event.srcElement);
        }
        
		switch (event.srcElement.dataformat) {
		case "int":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
        case "engup":
            if (event.srcElement.name == "srch_tri_prop_no") {
                ComKeyOnlyAlphabet('uppernum');
            } else {
                ComKeyOnlyAlphabet('upper');
            }
            break;
        // 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 추가
        case "uppernum":
        	ComKeyOnlyAlphabet('uppernum');
        	break;
		default:
			break;
		}
	}

	/**
	 * OnBeforeActivate event를 처리한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * obj_activate()
	 * </pre>
	 * 
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_activate() {
		var formObj = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    
	    if (srcName == "srch_gri_eff_dt") {
	    	ComClearSeparator(event.srcElement);
	    } else if (srcName == "srch_acc_dt") {
	    	ComClearSeparator(event.srcElement);
	    // 검색쪽의 tri_no에 '-'제거
	    } else if (srcName == "srch_tri_no") {
	    	formObj.srch_tri_no.value = formObj.srch_tri_no.value.replace(RegExp(/-/ig), "");
	    }
	}
	
	/**
	 * Onbeforedeactivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_deactivate() {
		var formObj = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    
		if (srcName == "srch_gri_eff_dt") {
			ComChkObjValid(event.srcElement);
		} else if (srcName == "srch_acc_dt") {
			ComChkObjValid(event.srcElement);
			// 검색쪽의 tri_no에 '-'다시 붙여주기
	    } else if (srcName == "srch_tri_no") {
	    	var sTriNo = formObj.srch_tri_no.value.replace(/-/g, '');
	    	if (sTriNo.length >= 13) {
	    		formObj.srch_tri_no.value = sTriNo.substring(0, 6) + "-" + sTriNo.substring(6, 10) + "-" + sTriNo.substring(10, 13);
	    	}
	    } else if (srcName == "srch_cmdt_cd") {
	    	if (formObj.srch_cmdt_cd.value.length == 6) {
				formObj.f_cmd.value = SEARCH08;
				var param = "&cd=" + formObj.srch_cmdt_cd.value;
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					//formObj.srch_cmdt_nm.value = arrData[1];
				} else {
		    		formObj.srch_cmdt_cd.value = "";
		    		//formObj.srch_cmdt_nm.value = "";
		    		return false;
				}
	    	} else {
	    		formObj.srch_cmdt_cd.value = "";
	    		//formObj.srch_cmdt_nm.value = "";
	    	}
	    	
	    } else if (srcName == "cmdt_cd") {
	    	if (formObj.cmdt_cd.readOnly) {
	    		return;
	    	}
	    	if (formObj.cmdt_cd.value.length == 6) {
				formObj.f_cmd.value = SEARCH08;
				var param = "&cd=" + formObj.cmdt_cd.value;
				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					formObj.cmdt_nm.value = arrData[1];
					
//					formObj.cmdt_cd.readOnly = true;
//					btnImgEnable("btn_srch_cmdt", false);
				} else {
		    		formObj.cmdt_cd.value = "";
		    		formObj.cmdt_nm.value = "";
		    		return false;
				}
	    	} else {
	    		formObj.cmdt_cd.value = "";
	    		formObj.cmdt_nm.value = "";
	    	}
	    	
	    	sheetObjects[1].CellValue2(sheetObjects[1].LastRow, "cmdt_cd") = formObj.cmdt_cd.value;
	    	if (sheetObjects[1].isDataModified && formObj.ibflag.value != "I") {
	    		formObj.ibflag.value = "U";
	    	}
	    }
	}
	
	/**
	 * 콤보 초기설정값 정의 <br>
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initCombo(comboObj, comboNo);
	 * </pre>
	 * @param {ibcombo} sheetObj 필수 IBSheet Object
	 * @param {int} ComboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "srch_trf_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	MaxLength = 8;
	            	ValidChar(2, 0);
	            }
	            break;
	        
	        case "srch_tri_apro_ofc_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	MaxLength = 5;
	            	ValidChar(2,1);
	            }
	            break;
	            
	        case "srch_prop_sts_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	ValidChar(2,1);
	            }
	            break;
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch (sheetID) {
	
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 260;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				var HeadTitle = "|Sel.|Seq.|Tariff Rate Item\n(TRI)|trf_cd|trf_pfx_cd|trf_no|amdt_seq|Commodity|Commodity|Route|Route|Route|Route|Per|CGO\nType|Cur.|Rate|C.offer|Final|Note|note_conv_mapg_id|Publication\nDate|Effective\nDate|Expiration\nDate|prop_sts_cd|Status|Request\nOffice|Approval\nOffice|Proposal No.|Internal\nRemark|GRI|GRI|Send Date|tri_rqst_usr_id|tri_apro_usr_id|last_pub_dt|org_rout_pnt_loc_nm_snd|org_rout_via_port_nm_snd|dest_rout_via_port_nm_snd|dest_rout_pnt_loc_nm_snd|cur_status|prs_rt_cmpb_calc_flg";
				var HeadTitle1 = "|Sel.|Seq.|Tariff Rate Item\n(TRI)|trf_cd|trf_pfx_cd|trf_no|amdt_seq|Code|Description|Origin|Origin Via|Dest Via|Dest|Per|CGO\nType|Cur.|Rate|C.offer|Final|Note|note_conv_mapg_id|Publication\nDate|Effective\nDate|Expiration\nDate|prop_sts_cd|Status|Request\nOffice|Approval\nOffice|Proposal No.|Internal\nRemark|||Send Date|tri_rqst_usr_id|tri_apro_usr_id|last_pub_dt|org_rout_pnt_loc_nm_snd|org_rout_via_port_nm_snd|dest_rout_via_port_nm_snd|dest_rout_pnt_loc_nm_snd|cur_status|prs_rt_cmpb_calc_flg";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 6, 100);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 14, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "tri_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "trf_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "trf_pfx_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "trf_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "amdt_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 115, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "org_rout_pnt_loc_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daLeft, true, "org_rout_via_port_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daLeft, true, "dest_rout_via_port_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "dest_rout_pnt_loc_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prop_frt_rt_amt", false, "", dfNullFloat, 2, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daRight, true, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daRight, true, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "note_ctnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "note_conv_mapg_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pub_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "prop_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "prop_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "tri_rqst_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "tri_apro_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tri_prop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "tri_rmk", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daRight, true, "gri_appl_amt", false, "",dfNullFloat, 2, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "eml_snd_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "tri_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "tri_apro_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "last_pub_dt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "org_rout_pnt_loc_nm_snd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "org_rout_via_port_nm_snd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "dest_rout_via_port_nm_snd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "dest_rout_pnt_loc_nm_snd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "cur_status", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "prs_rt_cmpb_calc_flg", false, "", dfNone, 0, false, false);
	
				ToolTipOption="balloon:true;width:1000;icon:1;title:Note";
                Ellipsis = true;
				AutoRowHeight = false;
				ShowButtonImage = 2;
				CountPosition = 0;
			}
			break;
	
		case "sheet2":
			with (sheetObj) {
				// 높이 설정
				style.height = 112;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				var HeadTitle = "|tri_prop_no|Seq.|prop_sts_cd|Status|Approval\nOffice|Publication\nDate|Effective\nDate|Expiration\nDate|Per|CGO\nType|Cur|Rate|C.offer|Final|Note|Note|note_conv_mapg_id|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|Approval\nStaff|Approval\nStaff|Request\nOffice|Request\nStaff|Request\nStaff|Internal\nRemark|GRI|GRI|Send Date|tri_no|cmdt_cd|prs_rt_cmpb_calc_flg";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 13, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "tri_prop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "amdt_seq", false, "", dfInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "prop_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "prop_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "tri_apro_ofc_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "pub_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "eff_dt", true, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "exp_dt", true, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "rat_ut_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "curr_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 70, daRight, true, "prop_frt_rt_amt", true, "", dfNullFloat, 2, true, true, 9);
				InitDataProperty(0, cnt++, dtData, 70, daRight, false, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
				InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "note_ctnt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtPopup, 20, daCenter, false, "note_ctnt_pop", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "note_conv_mapg_id", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_respb_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_respb_opfit_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_respb_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);;
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_gid_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "prs_respb_opb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 80, daRight,  false, "diff", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 80, daRight,  false, "prs_pfit_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 80, daRight,  false, "prs_pfit_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "prs_upd_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_apro_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "tri_apro_usr_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "tri_rqst_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "tri_rqst_usr_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "tri_rmk", false, "", dfNone, 0, false, false);					
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daRight, false, "gri_appl_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "eml_snd_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "prs_rt_cmpb_calc_flg", false, "", dfNone, 0, false, false);

                ToolTipOption="balloon:true;width:1000;icon:1;title:Note";
                Ellipsis = true;
				AutoRowHeight = false;
				ShowButtonImage = 2;
				CountPosition = 0;
			}
			break;
			
        case "sheet3":  // Grid 2의 Origin Point
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
                
                var HeadTitle = "3-1|3-2|3-3|3-4|3-5|3-6|3-7|3-8";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet4":  // Grid 2의 Origin Via.
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
                
                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet5":  // Grid 2의 Destination Via.
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
                
                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet6":  // Grid 2의 Destination Point
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
                
                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
            }
            break;
            
            
    	case "sheet7": // Note Conversion
    		with (sheetObj) {
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

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 7, 100);

                var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Per|Cargo\nType|IMDG\nClass|Cal.|Cur.|Amount" +
                		"|Pay Term|Weight\n(Ton < = )|Weight\n( > Ton)|SOC|T/S\nPort|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 6, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
                InitDataProperty(0, cnt++ , dtDummyCheck,     	50,   daCenter,  true,	"chk");
                InitDataProperty(0, cnt++ , dtData,	   			60,   daCenter,  true,	"chg_rule_def_cd",			true,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"eff_dt",  					true,	"",	dfDateYmd,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"exp_dt",     				true,	"",	dfDateYmd, 		 	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,    			90,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   			60,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,  			70,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   	    	70,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,      false, 	3);
                InitDataProperty(0, cnt++ , dtData,  	    	60,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtData,        		60,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     true,       true,	10);
                InitDataProperty(0, cnt++ , dtData,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtData,  			80,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtData,  			80,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtData,				60,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   	 		70,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_pfx_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"tri_prop_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                
    		}
    		break;
	
		}
	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * 하위 테이블(Rate, Route 등)을 조회한다.
	 * 다수의 chk박스를 클릭할시 하위조회때문에 발생하는 딜레이로 빠른 작업이 어려움.
	 * 그래서 chk박스를 클릭하여 행을 이동할때는 바로 하위를 조회하지 않고, chk가 끝난 후 2초 후에 선택된 행에 대한 하위를 조회함.
	 * chk컬럼외를 클릭시에는 바로 하위 테이블 조회를 실행
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	var fireEvent = true;
	var prevTimeoutID = "";
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	var colName = sheetObj.ColSaveName(NewCol);
    	var formObj = document.form;
    	
    	// chk박스 클릭시 바로 하위를 조회하지 않고 2초정도 딜레이를 주고 조회한다.
    	if (colName == "chk") {
    		if (prevTimeoutID) {
    			self.clearTimeout(prevTimeoutID);
    		}
    		prevTimeoutID = self.setTimeout("checkMDSync()", 2000);
    		return false;
    	}
    	
    	if (OldRow != NewRow && fireEvent) {
    		formObj.ibflag.value = "R";
    		formObj.tri_prop_no.value = sheetObj.CellValue(NewRow, "tri_prop_no");
    		formObj.tri_no.value = sheetObj.CellValue(NewRow, "tri_no");
    		formObj.prop_sts_cd.value = sheetObj.CellValue(NewRow, "prop_sts_cd");
    		formObj.amdt_seq.value = sheetObj.CellValue(NewRow, "amdt_seq");
    		formObj.cmdt_cd.value = sheetObj.CellValue(NewRow, "cmdt_cd");
    		formObj.cmdt_nm.value = sheetObj.CellValue(NewRow, "cmdt_nm");
    		
    		if (sheetObj.RowCount > 0) {
        		formObj.trf_pfx_cd.value = sheetObj.CellValue(NewRow, "trf_pfx_cd");
        		formObj.trf_no.value = sheetObj.CellValue(NewRow, "trf_no");
    		}
    		
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	}
    }

	/**
	 * OnClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "tri_rmk") {
			ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.ColWidth(Col), parseInt(sheetObj.DataRowHeight) * 4);
		} 
	}
    
    function checkMDSync() {
    	if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tri_prop_no") != sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "tri_prop_no")) {
    		sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].SelectRow, 0);
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
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.tri_no.value = sheetObj.CellValue(sheetObj.HeaderRows, "tri_no");
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
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	origin_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermOrg[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                
                sStr += "<br>";
                origin_desc.innerHTML += sStr;
            }
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
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	ovia_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_nm");
                
                sStr += "<br>";
                ovia_desc.innerHTML += sStr;
            }
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
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dvia_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_nm");
                
                sStr += "<br>";
                dvia_desc.innerHTML += sStr;
            }
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
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dest_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermDest[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                
                sStr += "<br>";
                dest_desc.innerHTML += sStr;
            }
        }
    }
    
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        if (colName == "note_ctnt_pop") {
        	if (sheetObj.CellValue(Row, "eff_dt") == "" || sheetObj.CellValue(Row, "exp_dt") == "") {
        		ComShowCodeMessage("PRI01024");
        		return;
        	}
        	
        	var sParam = "";
			sParam += "trf_pfx_cd=" 		+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "trf_pfx_cd");
			sParam += "&trf_no=" 			+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "trf_no");
			sParam += "&tri_prop_no=" 		+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tri_prop_no");
			sParam += "&amdt_seq=" 			+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq");
			sParam += "&note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
			sParam += "&eff_dt=" 			+ sheetObj.CellValue(Row, "eff_dt");
			sParam += "&exp_dt=" 			+ sheetObj.CellValue(Row, "exp_dt");
			sParam += "&note_ctnt=" 		+ encodeURIComponent(sheetObj.CellValue(Row, "note_ctnt"));
			
			var isEditable = "N";
			if (bIsReqUsr && sheetObj.CellValue(Row, "prop_sts_cd") == "I") {
				isEditable = "Y";
			} else if (bIsAproUsr && sheetObj.CellValue(Row, "prop_sts_cd") == "Q") {
				isEditable = "M";
			}
			sParam += "&is_editable="		+ isEditable;
			
			
			if(sheetObj.CellValue(Row, "prop_sts_cd") != "I" && sheetObj.CellValue(Row, "prop_sts_cd") != "Q") {
				var sUrl = "/hanjin/ESM_PRI_3003.do?" + sParam;
	            var rtnVal = ComPriOpenWindowCenter(sUrl, window, 800, getHeight(515), true);
			} else {
				var sUrl = "/hanjin/ESM_PRI_3002.do?" + sParam;
	            var rtnVal = ComPriOpenWindowCenter(sUrl, window, 800, getHeight(535), true);
	            
	            if (rtnVal != null) {
	            	sheetObj.CellValue(Row, "note_ctnt") = rtnVal.note_ctnt;
	            	sheetObj.ToolTipText(Row, "note_ctnt") = rtnVal.note_ctnt;
	            }
			}
			
        }
    }
    
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
            	var validPerClass = "D,A,F,O,Q,S,P";
                var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
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
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "DR"
            } else if (perClass == "R") {
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "RF"
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "AK"
            } else {
            	if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
            	}
            }
        }
        
        if (colName == "eff_dt") {
        	// eff_dt가 exp_dt보다 더 큰 경우, clear
        	if (sheetObj.CellValue(Row, "eff_dt") != "" && sheetObj.CellValue(Row, "exp_dt") != "") {
	            if (sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt")) {
	                ComShowCodeMessage("PRI00346");
	            	sheetObj.CellValue2(Row, Col) = "";
	            	sheetObj.SelectCell(Row, Col);
	                return false;
	            }
        	}
            
        	// eff_dt는 이전시퀀스의 duration내에 있어야한다.(이전시퀀스의 eff_dt와  exp_dt 사이에...)
            if (sheetObj.RowCount > 1) {
            	// eff_dt가 이전시퀀스의 exp_dt보다 큰 경우, clear. eff_dt는 이전시퀀스의 duration과 겹치도록 설정되어야함.
                if (sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row + 1, "exp_dt")) {
                    ComShowCodeMessage("PRI00353", ComGetMaskedValue(sheetObj.CellValue(Row + 1, "exp_dt"), "ymd"));
                	sheetObj.CellValue2(Row, Col) = "";
                	sheetObj.SelectCell(Row, Col);
                    return false;
                }
                // eff_dt가 이전시퀀스의 eff_dt보다 더 작은경우
                if (sheetObj.CellValue(Row, "eff_dt") <= sheetObj.CellValue(Row + 1, "eff_dt")) {
                    ComShowCodeMessage("PRI00354", ComGetMaskedValue(sheetObj.CellValue(Row + 1, "eff_dt"), "ymd"));
                	sheetObj.CellValue2(Row, Col) = "";
                	sheetObj.SelectCell(Row, Col);
                    return false;
                }
            }
            
            adjustNoteConvDate();
        }
        
        if (colName == "exp_dt") {
        	if (sheetObj.CellValue(Row, "eff_dt") != "" && sheetObj.CellValue(Row, "exp_dt") != "") {
        		// 시작일, 종료일 역전 현상 체크.
	            if (sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt")) {
	            	ComShowCodeMessage("PRI00345");
	            	sheetObj.CellValue2(Row, Col) = "";
	            	sheetObj.SelectCell(Row, Col);
	                return false;
	            }
	            
	            adjustNoteConvDate();
        	}
        }
        
        /*
        if (colName == "prop_frt_rt_amt") {
        	var scgAmt = sheetObjects[2].CellValue(Row, "prs_scg_amt");
        	var respbCmUcAmt = sheetObjects[2].CellValue(Row, "prs_respb_cm_uc_amt");
        	var respbOpfitUcAmt = sheetObjects[2].CellValue(Row, "prs_respb_opfit_uc_amt");
        	var pfitCmUcAmt = sheetObjects[2].CellValue(Row, "prs_pfit_cm_uc_amt");

        	if (Value != null && Value != "" && scgAmt != null && scgAmt != "") {
        		if (respbCmUcAmt != null && respbCmUcAmt != "") {
        			sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbCmUcAmt);
        		} else {
        			sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = "";
        		}
        		if (respbCmUcAmt != null && respbCmUcAmt != "") {
        			sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbOpfitUcAmt);
        		} else {
        			sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = "";
        		}
        		if (respbCmUcAmt != null && respbCmUcAmt != "") {
        			sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(pfitCmUcAmt);
        		} else {
        			sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = "";
        		}
        	} else {
        		sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = "";
        		sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = "";
        		sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = "";
        	}
        	
        	if (sheetObjects[2].CellValue(Row, "prs_gid_cmpb_amt") != "" && sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") != "") {
        		sheetObjects[2].CellValue(Row, "diff") = parseFloat(sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt")) - parseFloat(sheetObjects[2].CellValue(Row, "prs_gid_cmpb_amt"));
        	} else {
        		sheetObjects[2].CellValue(Row, "diff") = "";
        	}
        }
        */
    }

	/**
	 * OnClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnClick(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "tri_rmk") {
			if (sheetObj.CellEditable(Row, "prop_frt_rt_amt")) {
				ComShowMemoPad(sheetObj, Row, Col, false, sheetObj.ColWidth(Col), parseInt(sheetObj.DataRowHeight) * 4);
			} else {
				ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.ColWidth(Col), parseInt(sheetObj.DataRowHeight) * 4);
			}
		} 
	}
	    
    function adjustNoteConvDate() {
    	var idx = sheetObjects[1].HeaderRows;
    	var effDt = sheetObjects[1].CellValue(idx, "eff_dt");
    	var expDt = sheetObjects[1].CellValue(idx, "exp_dt");
    	
    	for (var i = sheetObjects[6].LastRow; sheetObjects[6].RowCount > 0 && i >= sheetObjects[6].HeaderRows; i--) {
    		if (sheetObjects[6].RowStatus(i) == "D") {
    			continue;
    		}
    		// APP일경우 Conversion 처리를 하지 않는다.
    		if (sheetObjects[6].CellValue(i, "note_conv_rule_cd") == "APP") {
    			continue;
    		}
    		
    		if (sheetObjects[6].CellValue(i, "note_conv_mapg_id") == sheetObjects[1].CellValue(idx, "note_conv_mapg_id")) {
    			// Conversion이 Rate duration을 벗어나 앞쪽에 위치하는 경우. 삭제.
    			if (sheetObjects[6].CellValue(i, "exp_dt") < effDt) {
    				sheetObjects[6].RowHidden(i) = true;
    				sheetObjects[6].RowStatus(i) = "D";
    			}
    			// Conversion이 Rate duration을 벗어나 뒤쪽에 위치하는 경우. 삭제.
    			if (sheetObjects[6].CellValue(i, "eff_dt") > expDt) {
    				sheetObjects[6].RowHidden(i) = true;
    				sheetObjects[6].RowStatus(i) = "D";
    			}
    		}
    	}
    
    	for (var i = sheetObjects[6].LastRow; sheetObjects[6].RowCount > 0 && i >= sheetObjects[6].HeaderRows; i--) {
    		if (sheetObjects[6].RowStatus(i) == "D") {
    			continue;
    		}
    		// Conversion이 Rate의 Duration을 벗어나지 않도록 한다.
    		if (sheetObjects[6].CellValue(i, "note_conv_mapg_id") == sheetObjects[1].CellValue(idx, "note_conv_mapg_id")) {
    			if (sheetObjects[6].CellValue(i, "eff_dt") < effDt) {
    				sheetObjects[6].CellValue2(i, "eff_dt") = effDt;
    			}
    			
    			if (sheetObjects[6].CellValue(i, "exp_dt") > expDt) {
    				sheetObjects[6].CellValue2(i, "exp_dt") = expDt;
    			}
    		}
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			
	        case IBCLEAR: // 화면 로딩시 
	            var sXml = "";  
	            
	            // per combo
	            formObj.f_cmd.value = SEARCH03;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D4");
	            
	            //공통 cargo
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", false, 0, "DR");
	            
	            //currency combo
	            formObj.f_cmd.value = SEARCH06;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "curr_cd", false, 0, "USD");
	            
				//공통 Term Origin
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				for (var i = 0; i < arrTemp.length; i++) {
					arrTermOrg[arrTemp[i][0]] = arrTemp[i][1];
				}
	
				//공통 Term Destination
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				for (var i = 0; i < arrTemp.length; i++) {
					arrTermDest[arrTemp[i][0]] = arrTemp[i][1];
				}
				
				//공통  Trans. Mode
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				for (var i = 0; i < arrTemp.length; i++) {
					arrTransMode[arrTemp[i][0]] = arrTemp[i][1];
				}
				
				// Tariff Code
	            formObj.f_cmd.value = SEARCHLIST12;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1=SMLM");
	            ComPriXml2ComboItem(sXml, formObj.srch_trf_cd, "cd", "cd|nm");
				
				// Approval Office Code
	            formObj.f_cmd.value = COMMAND14;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=APP_CODE");
	            ComPriXml2ComboItem(sXml, formObj.srch_tri_apro_ofc_cd, "cd", "cd|nm");
	            setIBCombo(sheetObjects[1], sXml, "tri_apro_ofc_cd", true, 0, "", "", true);
	            comboObjects[1].InsertItem(0, "", "");
	            
	            // TRI PROPOSAL STATUS CODE
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02395");
	            ComPriXml2ComboItem(sXml, formObj.srch_prop_sts_cd, "cd", "nm");
	            comboObjects[2].InsertItem(0, "", "");
	            
	            break;
	            
			case IBRESET: // New
	            for (var i = 0; i < sheetObjects.length; i++) {
	                sheetObjects[i].RemoveAll();
	            }
	            
	            for (var i = 0; i < comboObjects.length; i++) {
	            	comboObjects[i].Index = -1;
	            }
	            
	            formObj.srch_trf_pfx_cd.value = "";
	            formObj.srch_trf_no.value = "";
	            formObj.ibflag.value = "";
	            formObj.trf_pfx_cd.value = "";
	            formObj.trf_no.value = "";
	            formObj.prop_sts_cd.value = "";
	            formObj.amdt_seq.value = "";
	            
	            formObj.srch_cmdt_cd.value = "";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value = "";
	            formObj.srch_org_rout_pnt_loc_nm.value = "";
	            formObj.srch_org_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_pnt_loc_nm.value = "";
	            formObj.srch_tri_rqst_ofc_cd.value = "";
	            formObj.srch_tri_no.value = "";
	            formObj.srch_tri_prop_no.value = "";
	            formObj.srch_is_gri_appl.checked = false;
	            formObj.srch_gri_eff_dt.value = "";
	            
	            formObj.ibflag.value = "";
	            formObj.tri_no.value = "";
	            formObj.tri_prop_no.value = "";
	            formObj.cmdt_cd.value = "";
	            formObj.cmdt_nm.value = "";
	            formObj.prop_sts_cd.value = "";
	            
	            origin_desc.innerHTML = "";
	            ovia_desc.innerHTML = "";
	            dvia_desc.innerHTML = "";
	            dest_desc.innerHTML = "";
	            
	            toggleButtons("CLEAR");
	            
	            break;
		
			case IBSEARCH: // 조회
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                origin_desc.innerHTML = "";
	                ovia_desc.innerHTML = "";
	                dvia_desc.innerHTML = "";
	                dest_desc.innerHTML = "";
	                
	                // 메인그리드(sheet1)조회시, Approve Auth. Check
	    			formObj.f_cmd.value = SEARCHLIST16;
	    			var sParam = FormQueryString(formObj) + "&etc1=S&etc2=" + formObj.usr_id.value + "&etc3=" + formObj.trf_pfx_cd.value + "&etc4=" + formObj.trf_no.value;
	    			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	    			var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
	    			
	    			if (arrAuth != null && arrAuth.length > 0) {
	    				bHasAuthTariff = true;
	    			} else {
	    				bHasAuthTariff = false;
	    			}
	    			
	    			// Grid1 Search
	                formObj.f_cmd.value = SEARCH01;
	                sheetObj.DoSearch("ESM_PRI_3001GS.do" , FormQueryString(formObj));
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_3001GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);    // Grid3.
	                if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);    // Hidden. Grid2의 Origin Point.
	                if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Via.
	                if (arrXml.length > 3) sheetObjects[4].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Destination Via.
	                if (arrXml.length > 4) sheetObjects[5].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Point.
	                if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Note Conversion.
	                
	                formObj.prop_sts_cd.value = sheetObj.CellValue(sheetObj.HeaderRows, "prop_sts_cd");
	                formObj.amdt_seq.value = sheetObj.CellValue(sheetObj.HeaderRows, "amdt_seq");
	                
	                setAuthority();
	                toggleButtons("INIT");
	                
	            }
	            break;
		
			case IBSAVE: // 저장
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MULTI01;
	            var sParam = FormQueryString(formObj);
	            var sParamSheet2 = sheetObjects[1].GetSaveString();
	            if (sParamSheet2 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	            }
	            var sParamSheet3 = sheetObjects[2].GetSaveString();
	            if (sParamSheet3 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	            }
	            var sParamSheet4 = sheetObjects[3].GetSaveString();
	            if (sParamSheet4 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
	            }
	            var sParamSheet5 = sheetObjects[4].GetSaveString();
	            if (sParamSheet5 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
	            }
	            var sParamSheet6 = sheetObjects[5].GetSaveString();
	            if (sParamSheet6 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
	            }
	            var sParamSheet7 = sheetObjects[6].GetSaveString();
	            if (sParamSheet7 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
	            }
	            
	            if (!ComPriConfirmSave()) {
	                return false;
	            }
	            
	            // Rate의 중복여부를 검사한다.
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            
	            sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            sheetObjects[6].LoadSaveXml(sXml);
	            sheetObjects[5].LoadSaveXml(sXml);
	            sheetObjects[4].LoadSaveXml(sXml);
	            sheetObjects[3].LoadSaveXml(sXml);
	            sheetObjects[2].LoadSaveXml(sXml);
	            sheetObjects[1].LoadSaveXml(sXml);
	            
	            if (sheetObjects[1].IsDataModified
	            		|| sheetObjects[2].IsDataModified
	            		|| sheetObjects[3].IsDataModified
	            		|| sheetObjects[4].IsDataModified
	            		|| sheetObjects[5].IsDataModified
	            		|| sheetObjects[6].IsDataModified) {
	                return false;
	            } else {
	            	comboObjects[2].Index = -1;
	            	
	            	// 신규로 입력된 행이 있다면, 새로 생성된 prop_no를 받아서 전체를 재조회 하고 해당 행으로 찾아감.
	            	if (formObj.ibflag.value == "I") {
	            		var newPropNo = ComGetEtcData(sXml, "NEW_PROP_NO");
	            		reloadRate(newPropNo);
	            	// 
	            	} else if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prop_sts_cd") == "Q") {
	            		reloadRateReverse();
	            	// 일반적인 경우 재조회
	            	} else {
	            		reloadRate();
	            	}
	
	            	formObj.ibflag.value = "R";
	            	ComPriSaveCompleted();
	                return true;
	            }
	            
				break;
		
			case IBCREATE: // 입력
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            formObj.srch_cmdt_cd.value = "";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value = "";
	            formObj.srch_org_rout_pnt_loc_nm.value = "";
	            formObj.srch_org_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_pnt_loc_nm.value = "";
	            formObj.srch_tri_rqst_ofc_cd.value = "";
	            formObj.srch_tri_no.value = "";
	            formObj.srch_tri_prop_no.value = "";
	            formObj.srch_is_gri_appl.checked = false;
	            formObj.srch_gri_eff_dt.value = "";
	            
	            formObj.ibflag.value = "I";
	            formObj.tri_no.value = "";
	            formObj.tri_prop_no.value = "";
	            formObj.amdt_seq.value = "0";
	            formObj.cmdt_cd.value = "";
	            formObj.cmdt_nm.value = "";
	            formObj.prop_sts_cd.value = "I";
	            
	            origin_desc.innerHTML = "";
	            ovia_desc.innerHTML = "";
	            dvia_desc.innerHTML = "";
	            dest_desc.innerHTML = "";
	            
	            for (var i = 1; i < comboObjects.length; i++) {
	            	comboObjects[i].Index = -1;
	            }
	            
	            for (var i = 1; i < sheetObjects.length; i++) {
	                sheetObjects[i].RemoveAll();
	            }
	            
	            var idx = sheetObjects[1].DataInsert();
	            
	            sheetObjects[1].CellValue(idx, "tri_rqst_usr_id") = formObj.usr_id.value;
	            sheetObjects[1].CellValue(idx, "curr_cd") = "USD";
	            sheetObjects[1].CellValue(idx, "prop_frt_rt_amt") = 0.00;
	            sheetObjects[1].CellValue(idx, "curr_cd") = "USD";
	            sheetObjects[1].CellValue(idx, "prop_sts_cd") = "I";
	            sheetObjects[1].CellValue(idx, "prop_sts_nm") = "Initial";
	            
	            // note_conv_mapg_id 새로 채번
	            formObj.f_cmd.value = COMMAND38;
	            var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
	            sheetObjects[1].CellValue(idx, "note_conv_mapg_id") = sysGuid;
	            
	            setAuthority();
	            toggleButtons("INIT");
	            ComBtnDisable("btn_request");
	            ComBtnDisable("btn_cancel");
	            
				break;
				
			case IBSEARCH_ASYNC11: // Request All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Request]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY11;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            reloadRate();
	            ComShowCodeMessage("PRI01045", "Request");
	            
				break;
				
			case IBSEARCH_ASYNC12: // Approve All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Approve]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY12;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            var sCheckedRows = sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	            // 루프를 돌며 Approve한 항목들의 값을 새로 세팅한다. 재조회 안함.
	        	for (var i = 0; i < arrCheckedRows.length; i++) {
		            sheetObjects[0].CellValue(arrCheckedRows[i], "prop_sts_cd") = "A";
		            sheetObjects[0].CellValue(arrCheckedRows[i], "prop_sts_nm") = "Approved";
		            //sheetObjects[0].CellValue(arrCheckedRows[i], "tri_apro_ofc_cd") = formObj.ofc_cd.value;
		            sheetObjects[0].CellValue(arrCheckedRows[i], "tri_apro_usr_id") = formObj.usr_id.value;
		            sheetObjects[0].CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = sheetObjects[0].CellValue(arrCheckedRows[i], "prop_frt_rt_amt");
		            sheetObjects[0].RowStatus(arrCheckedRows[i]) = "R";
	        	}
	        	sheetObjects[0].CheckAll2("chk") = 0;
	            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	            
	            ComShowCodeMessage("PRI01045", "Approve");
	            
				break;
				
			case IBSEARCH_ASYNC15: // Request Cancel All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Request Cancel]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY15;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
	            
				break;
				
			case IBSEARCH_ASYNC16: // Approve Cancel All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Approve Cancel]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY16;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
	            
				break;
				
			case IBSEARCH_ASYNC01: // Request
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Request]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            reloadRate();
	            ComShowCodeMessage("PRI01045", "Request");
	            
				break;
				
			case IBSEARCH_ASYNC02: // Amend
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Amend]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY02;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            formObj.srch_cmdt_cd.value = "";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value = "";
	            formObj.srch_org_rout_pnt_loc_nm.value = "";
	            formObj.srch_org_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_via_port_nm.value = "";
	            formObj.srch_dest_rout_pnt_loc_nm.value = "";
	            formObj.srch_tri_rqst_ofc_cd.value = "";
	            formObj.srch_tri_no.value = "";
	            formObj.srch_tri_prop_no.value = "";
	            formObj.srch_is_gri_appl.checked = false;
	            formObj.srch_gri_eff_dt.value = "";
	            
	            for (var i = 1; i < comboObjects.length; i++) {
	            	comboObjects[i].Index = -1;
	            }
	            
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
	            
				break;
				
			case IBSEARCH_ASYNC03: // C/Offer
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[C/Offer]")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY03;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            // C/Offer, Approve, TRI No. Assign, Publish에서는 재조회 하지 않는다.
	            reloadRateReverse();
	            ComShowCodeMessage("PRI01045", "C/Offer");
	            
				break;
				
			case IBSEARCH_ASYNC04: // Approve
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[Approve]")) {
	                return false;
	            }
	            
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY04;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            reloadRateReverse();
	            ComShowCodeMessage("PRI01045", "Approve");
	            
				break;
				
			case IBSEARCH_ASYNC06: // TRI No. Assign
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "[TRI No. Assign]")) {
	                return false;
	            }
	            
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY06;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            reloadRateReverse();
	            ComShowCodeMessage("PRI05004");
	            
				break;
				
			case IBSEARCH_ASYNC07: // Cancel
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI05005")) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY07;
	            var sParam = FormQueryString(formObj);
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3001GS.do", sParam);
	            
	            comboObjects[2].Index = -1;
	            
	            // Prop전체가 삭제된 경우. 재조회하고 New 상태로 만들어준다.
	            if (formObj.prop_sts_cd.value == "I" && formObj.amdt_seq.value == "0") {
	            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	            	doActionIBSheet(sheetObjects[1], document.form, IBCREATE);
	            } else {
	            	reloadRate();
	            }
	            ComShowCodeMessage("PRI01047");
	            
				break;
				
			case IBCOPYROW:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI00012")) {
	                return false;
	            }
	            
	            formObj.ibflag.value = "I";
	            formObj.tri_no.value = "";
	            formObj.tri_prop_no.value = "";
	            formObj.amdt_seq.value = "0";
	            formObj.prop_sts_cd.value = "I";
	            
	            var idx = sheetObjects[1].HeaderRows;
	            
	            for (var i = sheetObjects[1].LastRow; sheetObjects[1].RowCount > 0 && i >= idx + 1; i--) {
	            	sheetObjects[1].RowDelete(i, false);
	            }
	            
				sheetObjects[1].CellValue(idx, "tri_prop_no") = "";
				sheetObjects[1].CellValue(idx, "amdt_seq") = "0";
	            sheetObjects[1].CellValue(idx, "prop_sts_cd") = "I";
	            sheetObjects[1].CellValue(idx, "prop_sts_nm") = "Initial";
	            sheetObjects[1].CellValue(idx, "pub_dt") = "";
	            sheetObjects[1].CellValue(idx, "rat_ut_cd") = "";
	            sheetObjects[1].CellValue(idx, "prc_cgo_tp_cd") = "";
	            sheetObjects[1].CellValue(idx, "curr_cd") = "";
	            sheetObjects[1].CellValue(idx, "prop_frt_rt_amt") = 0.00;
				sheetObjects[1].CellValue(idx, "coffr_frt_rt_amt") = "";
				sheetObjects[1].CellValue(idx, "fnl_frt_rt_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_scg_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_respb_cm_uc_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_respb_opfit_uc_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_respb_cmpb_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_gid_cmpb_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_respb_opb_amt") = "";
				sheetObjects[1].CellValue(idx, "diff") = "";
				sheetObjects[1].CellValue(idx, "prs_pfit_cm_uc_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_pfit_cmpb_amt") = "";
				sheetObjects[1].CellValue(idx, "prs_upd_dt") = "";
				sheetObjects[1].CellValue(idx, "tri_apro_usr_id") = "";
				sheetObjects[1].CellValue(idx, "tri_rqst_ofc_cd") = "";
				sheetObjects[1].CellValue(idx, "tri_rqst_usr_id") = formObj.usr_id.value;
				sheetObjects[1].CellValue(idx, "tri_rqst_usr_nm") = "";
				sheetObjects[1].CellValue(idx, "gri_appl_tp_cd") = "";
				sheetObjects[1].CellValue(idx, "gri_appl_amt") = "";
				sheetObjects[1].CellValue(idx, "tri_no") = "";
	            
	            formObj.f_cmd.value = COMMAND38;
	            var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
	            var prevMapgId = sheetObjects[1].CellValue(idx, "note_conv_mapg_id");
	            
	            sheetObjects[1].CellValue(idx, "note_conv_mapg_id") = sysGuid;
	            
	            // Route Sheet 처리
	            for (var a = 2; a <= 5; a++) {
		            for (var i = sheetObjects[a].HeaderRows; sheetObjects[a].RowCount > 0 && i <= sheetObjects[a].LastRow; i++) {
		            	sheetObjects[a].RowStatus(i) = "I";
		            }
	            }
	            
	            // Note Coversion Sheet 처리
	            for (var i = sheetObjects[6].LastRow; sheetObjects[6].RowCount > 0 && i >= sheetObjects[6].HeaderRows; i--) {
	            	if (sheetObjects[6].CellValue(i, "note_conv_mapg_id") == prevMapgId) {
	            		sheetObjects[6].CellValue(i, "note_conv_mapg_id") = sysGuid;
	            		sheetObjects[6].CellValue(i, "tri_prop_no") = "";
	            		sheetObjects[6].CellValue(i, "amdt_seq") = "";
	            		sheetObjects[6].RowStatus(i) = "I";
	            	} else {
	            		sheetObjects[6].RowDelete(i, false);
	            	}
	            }
	            
	            sheetObjects[1].RowStatus(idx) = "I";
	            
	            setAuthority();
	            toggleButtons("INIT");
	            ComBtnDisable("btn_request");
	            ComBtnDisable("btn_cancel");
				
				break;
				
	        case IBSEARCH_ASYNC08:
				
	            if (!validateForm(sheetObj, document.form, sAction)) {
	            	ComOpenWait(false);
	                return false;
	            }
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH04;
   		        
				var param = FormQueryString(formObj);
				sXml = sheetObj.GetSearchXml("ESM_PRI_3001GS.do", param);
				
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");		
				if (backendJobKey.length > 0) {
					BACKEND_JOB_ID = backendJobKey;
//					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
//					ARRAY_BACKENDJOB_TYPE[TIMER_ID] = sAction;					
					window.setTimeout(getBackEndJobStatus, 3000); // 3초 후에
				}else{
					ComOpenWait(false);
				}
 						
 
 				break;
 				
 				
 				
				
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        	if(sAction == IBSEARCH_ASYNC08 ){
        		ComOpenWait(false);
        	}
        } finally {
        	
        	if(sAction != IBSEARCH_ASYNC08 ){
        		ComOpenWait(false);
        	}
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            
        case IBSEARCH: // 조회
        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
                return false;
            }
            
        	return true;
            break;
    
        case IBSAVE: // 저장
        	if (formObj.prop_sts_cd.value != "I"
	        		&& formObj.prop_sts_cd.value != "Q"
	        		&& formObj.prop_sts_cd.value != "R") {
        		return false;
        	}
        	
        	// Sheet와 HTML폼에 수정된 내용이 있는지 확인.
            if (formObj.ibflag.value == "R"
            		&& !sheetObjects[1].IsDataModified
                    && !sheetObjects[2].IsDataModified
                    && !sheetObjects[3].IsDataModified
                    && !sheetObjects[4].IsDataModified
                    && !sheetObjects[5].IsDataModified
                    && !sheetObjects[6].IsDataModified) {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            
            if (formObj.cmdt_cd.value == "") {
                ComShowCodeMessage("PRI00316", "Commodity");
                return false;
            }
            
			if (sheetObjects[1].RowCount <= 0
					|| sheetObjects[2].RowCount <= 0
					|| sheetObjects[5].RowCount <= 0) {
				ComShowCodeMessage("PRI00007");
				return false;
			}
            
            if (sheetObjects[1].IsDataModified
                    && sheetObjects[1].GetSaveString() == "") {
                return false;
            }
            if (sheetObjects[2].IsDataModified
                    && sheetObjects[2].GetSaveString() == "") {
                return false;
            }
            if (sheetObjects[3].IsDataModified
                    && sheetObjects[3].GetSaveString() == "") {
                return false;
            }
            if (sheetObjects[4].IsDataModified
                    && sheetObjects[4].GetSaveString() == "") {
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
            
            // Rate의 날짜 역전 확인
            if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "eff_dt") > sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "exp_dt")) {
                ComShowCodeMessage("PRI00345");
                return false;
            }
            
            // eff_dt가 이전 시퀀스의 duration안에 포함되어 있는지 확인.
            if (sheetObjects[1].RowCount > 1) {
                if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "eff_dt") > sheetObjects[1].CellValue(sheetObjects[1].HeaderRows + 1, "exp_dt")) {
                    ComShowCodeMessage("PRI00353", ComGetMaskedValue(sheetObjects[1].CellValue(sheetObjects[1].HeaderRows + 1, "exp_dt"), "ymd"));
                    return false;
                }
                if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "eff_dt") <= sheetObjects[1].CellValue(sheetObjects[1].HeaderRows + 1, "eff_dt")) {
                    ComShowCodeMessage("PRI00354", ComGetMaskedValue(sheetObjects[1].CellValue(sheetObjects[1].HeaderRows + 1, "eff_dt"), "ymd"));
                    return false;
                }
            }
            
            // duration이 30일 이상이 되도록 점검.
            if (document.form.amdt_seq.value == "0") {
	            if (sheetObjects[1].EvalDateDiff("D", sheetObjects[1].CellText(sheetObjects[1].HeaderRows, "eff_dt"), sheetObjects[1].CellText(sheetObjects[1].HeaderRows, "exp_dt")) < 29) {
	            	sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows, "exp_dt", false);
	            	ComShowCodeMessage("PRI05012");
                    return false;
	            }
            }
            
            if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prop_frt_rt_amt") <= 0.00) {
            	sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows, "prop_frt_rt_amt", false);
                ComShowCodeMessage("PRI00321", "Rate", "0.00");
                return false;
            }
    
            return true;
            break;
    
        case IBCREATE: // Row Add
        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
                return false;
            }
            
            return true;
            break;
            
        case IBSEARCH_ASYNC11: // Request All
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasRqstAuth(arrCheckedRows[i])) {
					ComShowCodeMessage("PRI01033", sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no"));
					return false;
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "I"
        			&& sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "R") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        		
            	// Row별 필수값(Approval Office) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "tri_apro_ofc_cd") == "") {
					ComShowCodeMessage("PRI00316", "Approval Office");
					return false;
        		}
        		
            	// Row별 필수값(Rate값) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_frt_rt_amt") == "") {
					ComShowCodeMessage("PRI00316", "Rate");
					return false;
        		}
            	
                if (sheetObj.CellValue(arrCheckedRows[i], "prs_rt_cmpb_calc_flg") != "Y") {
                	ComShowCodeMessage("PRI03022", "Request");
    	            return false;
                }
        	}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC12: // Approve All
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasAproAuth(arrCheckedRows[i])) {
					ComShowCodeMessage("PRI01033", sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no"));
					return false;
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "Q") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        	}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC13: // Publish All
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasAproAuth(arrCheckedRows[i])) {
					ComShowCodeMessage("PRI01033", sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no"));
					return false;
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        		
            	// Row별 필수값(TRI No.) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "tri_no") == "") {
					ComShowCodeMessage("PRI00316", "TRI No.");
					return false;
        		}
        	}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC15: // Request Cancel All
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasAproAuth(arrCheckedRows[i])) {
					ComShowCodeMessage("PRI01033", sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no"));
					return false;
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "Q") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        		
            	// Row별 필수값(Approval Office) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "tri_apro_ofc_cd") == "") {
					ComShowCodeMessage("PRI00316", "Approval Office");
					return false;
        		}
        		
            	// Row별 필수값(Rate값) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_frt_rt_amt") == "") {
					ComShowCodeMessage("PRI00316", "Rate");
					return false;
        		}
        	}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC16: // Approve Cancel All
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasAproAuth(arrCheckedRows[i])) {
					ComShowCodeMessage("PRI01033", sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no"));
					return false;
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        	}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC01: // Request
            if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "tri_apro_ofc_cd") == "") {
	            ComShowCodeMessage("PRI08010", sheetObjects[1].HeaderRows, "Approval Office");
	            return false;
            }
            if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prop_frt_rt_amt") == "") {
            	ComShowCodeMessage("PRI08010", sheetObjects[1].HeaderRows, "Rate");
	            return false;
            }
        	
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prs_rt_cmpb_calc_flg") != "Y") {
            	ComShowCodeMessage("PRI03022", "Request");
	            return false;
            }
            
            return true;
            break;

        case IBSEARCH_ASYNC02: // Amend

            return true;
            break;

        case IBSEARCH_ASYNC03: // C/Offer
	        if (formObj.ibflag.value != "R" 
		    		|| sheetObjects[1].IsDataModified
		    		|| sheetObjects[2].IsDataModified
		    		|| sheetObjects[3].IsDataModified
		    		|| sheetObjects[4].IsDataModified
		    		|| sheetObjects[5].IsDataModified
		    		|| sheetObjects[6].IsDataModified) {
		        ComShowCodeMessage("PRI00309");
		        return false;
		    }
        
			if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "coffr_frt_rt_amt") == "" || sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "coffr_frt_rt_amt") <= 0.00) {
				sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows, "coffr_frt_rt_amt", false);
				ComShowCodeMessage("PRI00321", "C.offer", "0.00");
				return false;
			}

            return true;
            break;

        case IBSEARCH_ASYNC04: // Approve
	        if (formObj.ibflag.value != "R" 
		    		|| sheetObjects[1].IsDataModified
		    		|| sheetObjects[2].IsDataModified
		    		|| sheetObjects[3].IsDataModified
		    		|| sheetObjects[4].IsDataModified
		    		|| sheetObjects[5].IsDataModified
		    		|| sheetObjects[6].IsDataModified) {
		        ComShowCodeMessage("PRI00309");
		        return false;
		    }

            return true;
            break;

        case IBSEARCH_ASYNC06: // TRI No. Assign

            return true;
            break;

        case IBSEARCH_ASYNC07: // Cancel

            return true;
            break;
            
        case IBCOPYROW: // Copy
        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
                return false;
            }
        
	        if (formObj.ibflag.value != "R" 
		    		|| sheetObjects[1].IsDataModified
		    		|| sheetObjects[2].IsDataModified
		    		|| sheetObjects[3].IsDataModified
		    		|| sheetObjects[4].IsDataModified
		    		|| sheetObjects[5].IsDataModified
		    		|| sheetObjects[6].IsDataModified) {
		        ComShowCodeMessage("PRI00309");
		        return false;
		    }
            
            return true;
            break;

        case IBSEARCH_ASYNC17: // Send
            if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	            ComShowCodeMessage("PRI00309");
	            return false;
            }
            
            if (sheetObj.CheckedRows("chk") <= 0) {
	            ComShowCodeMessage("PRI01043");
	            return false;
            }
            
            var sValAuth = "";
            
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	// Row별 권한체크
        		if (!hasAproAuth(arrCheckedRows[i])) {
        			sValAuth += " " + sheetObj.CellValue(arrCheckedRows[i], "tri_prop_no");
        		}
        		
            	// Row별 상태체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
					ComShowCodeMessage("PRI01034");
					return false;
        		}
        		
            	// Row별 필수값(TRI No.) 체크
        		if (sheetObj.CellValue(arrCheckedRows[i], "tri_no") == "") {
					ComShowCodeMessage("PRI00316", "TRI No.");
					return false;
        		}
        	}
        	
        	// Row별 권한체크
    		if (sValAuth != "") {
				ComShowCodeMessage("PRI01033", sValAuth);
				return false;
    		}
            
            return true;
            break;
            
        case IBSEARCH_ASYNC08: // calculate
	        if (formObj.ibflag.value != "R" 
	        		|| sheetObjects[1].IsDataModified
	        		|| sheetObjects[2].IsDataModified
	        		|| sheetObjects[3].IsDataModified
	        		|| sheetObjects[4].IsDataModified
	        		|| sheetObjects[5].IsDataModified
	        		|| sheetObjects[6].IsDataModified) {
	        	ComShowCodeMessage("PRI03026", "Rate");
	            return false;
	        }
        	return true
        	break;

        }
	}
	
	/**
	 * Rate 중복여부 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 유효할 경우<br>
	 *          false : 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.12.01
	 */
	function validateRateDuplicate(sAction) {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH03;
		
		var sOrgPntKey = "";
		var sOrgViaKey = "";
		var sDestViaKey = "";
		var sDestPntKey = "";
		
		// Route Point들을 문자열로 묶어서 서버로 전송. 이 문자열과 서버의 데이타를 Select로 비교한다.
		for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
			if (sheetObjects[2].RowStatus(i) == "D") {
				continue;
			}
			sOrgPntKey += "|" + sheetObjects[2].CellValue(i, "rout_pnt_loc_cd");
			sOrgPntKey += sheetObjects[2].CellValue(i, "rcv_de_term_cd");
			sOrgPntKey += sheetObjects[2].CellValue(i, "prc_trsp_mod_cd");
		}
		for (var i = sheetObjects[3].HeaderRows; sheetObjects[3].RowCount > 0 && i <= sheetObjects[3].LastRow; i++) {
			if (sheetObjects[3].RowStatus(i) == "D") {
				continue;
			}
			sOrgViaKey += "|" + sheetObjects[3].CellValue(i, "rout_via_port_cd");
		}
		for (var i = sheetObjects[4].HeaderRows; sheetObjects[4].RowCount > 0 && i <= sheetObjects[4].LastRow; i++) {
			if (sheetObjects[4].RowStatus(i) == "D") {
				continue;
			}
			sDestViaKey += "|" + sheetObjects[4].CellValue(i, "rout_via_port_cd");
		}
		for (var i = sheetObjects[5].HeaderRows; sheetObjects[5].RowCount > 0 && i <= sheetObjects[5].LastRow; i++) {
			if (sheetObjects[5].RowStatus(i) == "D") {
				continue;
			}
			sDestPntKey += "|" + sheetObjects[5].CellValue(i, "rout_pnt_loc_cd");
			sDestPntKey += sheetObjects[5].CellValue(i, "rcv_de_term_cd");
			sDestPntKey += sheetObjects[5].CellValue(i, "prc_trsp_mod_cd");
		}
		
		var sParam = "f_cmd=" + SEARCH03;
		sParam += "&srch_trf_pfx_cd=" + formObj.trf_pfx_cd.value;
		sParam += "&srch_trf_no=" + formObj.trf_no.value;
		sParam += "&srch_tri_prop_no=" + formObj.tri_prop_no.value;
		sParam += "&srch_cmdt_cd=" + formObj.cmdt_cd.value;
		sParam += "&srch_org_rout_pnt_loc_nm=" + sOrgPntKey;
		sParam += "&srch_org_rout_via_port_nm=" + sOrgViaKey;
		sParam += "&srch_dest_rout_via_port_nm=" + sDestViaKey;
		sParam += "&srch_dest_rout_pnt_loc_nm=" + sDestPntKey;
		sParam += "&srch_rat_ut_cd=" + sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "rat_ut_cd");
		sParam += "&srch_prc_cgo_tp_cd=" + sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prc_cgo_tp_cd");
		sParam += "&srch_curr_cd=" + sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "curr_cd");
		sParam += "&srch_eff_dt=" + sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "eff_dt");
		sParam += "&srch_exp_dt=" + sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "exp_dt");
		sParam += "&srch_action=" + sAction;
		
		var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_3001GS.do" , sParam);
        var dupPropNo = ComGetEtcData(sXml, "DUP_PROP_NO");
        // 중복항목이 있다면.....
        if (dupPropNo != null && dupPropNo != "") {
        	// Save시
    		if (sAction == IBSAVE) {
    			// Cargo Type이 AK나 BB 일 경우에는 저장을 진행할지 확인만 한다. 
    			if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prc_cgo_tp_cd") == "AK" || sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "prc_cgo_tp_cd") == "BB") {
	    			if (!ComShowCodeConfirm("PRI00343", dupPropNo)) {
	    				return false;
	    			}
	    		// 그 외의 Cargo Type일 경우 Block.
    			} else {
            		ComShowCodeMessage("PRI00342", dupPropNo);
            		return false;
    			}
    		// Approve시
    		} else if (sAction == IBSEARCH_ASYNC04) {
    			if (!ComShowCodeConfirm("PRI00344", dupPropNo)) {
    				return false;
    			}
    		// TRI No. Assign시
    		} else if (sAction == IBSEARCH_ASYNC06) {
        		ComShowCodeMessage("PRI05009", dupPropNo);
        		return false;
    		}
        }
        
        return true;
	}
	
    /**
	 * OnKeyDown event를 처리한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.12.17
	 */
	function srch_trf_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}

	/**
	 * OnKeyDown event를 처리한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.12.17
	 */
	function srch_tri_apro_ofc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}

	/**
	 * OnKeyDown event를 처리한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.12.17
	 */
	function srch_prop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param {ibcombo}
	 *            comboObj 필수 IBSheet Combo Object
	 * @param {int}
	 *            code 필수 Onclick 이벤트가 발생한 해당 code
	 * @param {int}
	 *            text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function srch_trf_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		formObj.srch_trf_pfx_cd.value = code.substring(0, 4);
		formObj.srch_trf_no.value = code.substring(5, 8);
		formObj.trf_pfx_cd.value = code.substring(0, 4);
		formObj.trf_no.value = code.substring(5, 8);
		formObj.srch_trf_nm.value = comboObj.GetText(code, 1);
		
		// 바로 재조회 하지 않도록 한다. - 송현애 대리.
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
    
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        if (sheetNo == 0) {
            sCol = "chk";
            sValue = "1";
        } else if (sheetNo == 6) {
            sCol = "note_conv_mapg_id";
            sValue = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_mapg_id");
        }

        sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        
        return sXml;
    }
    
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        var sCol = "";
        var sValue = "";
        var bAppendMode = 0;
        
        if (sheetNo == 6) {
            bAppendMode = 1;
            sCol = "note_conv_mapg_id";
            sValue = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_mapg_id");
        }
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
    
    function getRdoPRSCostLevel() {
        for (var i = 0; i < document.form.rdoPRSCostLevel.length; i++) {
            if (document.form.rdoPRSCostLevel[i].checked) {
                return document.form.rdoPRSCostLevel[i].value;
            }
        }
    }
    
	/**
	 * GRI Apply후 재조회.
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadRate4GRIApply(trfCd, griEffDt) {
    	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	
    	document.form.srch_gri_eff_dt.disabled = false;
		btnImgEnable("srch_btn_grieffdt", true);
    	document.form.srch_is_gri_appl.checked = true;
    	document.form.srch_gri_eff_dt.value = griEffDt;
    	comboObjects[2].Code = "I";
    	comboObjects[0].Code = trfCd;
    }
    
	/**
	 * GRI Cancel후 재조회.
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadRate4GRICancel(trfCd, trfNm) {
    	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	
    	comboObjects[0].Code = trfCd;
    }
    
	/**
	 * 일반적인 재조회. Sheet1을 재조회하고 그 이벤트로 sheet2를 재조회 한다.
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadRate(propNo) {
		if (propNo == null || propNo == ""){
			propNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tri_prop_no");
		}
		
		fireEvent = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		fireEvent = true;
		var newIdx = sheetObjects[0].FindText("tri_prop_no", propNo);
		if (newIdx >= 0) {
			sheetObjects[0].SelectRow = newIdx;
			sheet1_OnSelectCell(sheetObjects[0], -1, -1, newIdx, -1);
		} else {
			sheetObjects[0].SelectRow = sheetObjects[0].HeaderRows;
			sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].HeaderRows, -1);
		}
    }
    
	/**
	 * 재조회하지 말아야 할 경우에 사용하는 함수. Rate(sheet2)를 먼저 조회하고,
	 * 그 데이타를 바탕으로 sheet1을 역으로 세팅해준다.
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadRateReverse() {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	
    	var curHdrRow = sheetObjects[0].SelectRow;
    	var curDtlRow = sheetObjects[1].HeaderRows;
    	
    	comboObjects[2].Index = -1;
    	
        sheetObjects[0].CellValue(curHdrRow, "prop_sts_cd") = sheetObjects[1].CellValue(curDtlRow, "prop_sts_cd");
        sheetObjects[0].CellValue(curHdrRow, "prop_sts_nm") = sheetObjects[1].CellValue(curDtlRow, "prop_sts_nm");
        sheetObjects[0].CellValue(curHdrRow, "tri_apro_ofc_cd") = sheetObjects[1].CellValue(curDtlRow, "tri_apro_ofc_cd");
        sheetObjects[0].CellValue(curHdrRow, "tri_apro_usr_id") = sheetObjects[1].CellValue(curDtlRow, "tri_apro_usr_id");
        sheetObjects[0].CellValue(curHdrRow, "fnl_frt_rt_amt") = sheetObjects[1].CellValue(curDtlRow, "fnl_frt_rt_amt");
        sheetObjects[0].CellValue(curHdrRow, "tri_no") = sheetObjects[1].CellValue(curDtlRow, "tri_no");
        sheetObjects[0].CellValue(curHdrRow, "eff_dt") = sheetObjects[1].CellValue(curDtlRow, "eff_dt");
        sheetObjects[0].CellValue(curHdrRow, "pub_dt") = sheetObjects[1].CellValue(curDtlRow, "pub_dt");
        sheetObjects[0].CellValue(curHdrRow, "note_ctnt") = sheetObjects[1].CellValue(curDtlRow, "note_ctnt");
        
        sheetObjects[0].RowStatus(curHdrRow) = "R";
    }
    
	/**
	 * Publish All 후 sheet1의 값들을 다시 세팅함.
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadRate4PublishAll(pubDate) {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	
    	comboObjects[2].Index = -1;
    	
    	var sCheckedRows = sheetObjects[0].FindCheckedRow("chk");
        var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
    	for (var i = 0; i < arrCheckedRows.length; i++) {
            sheetObjects[0].CellValue(arrCheckedRows[i], "prop_sts_cd") = "F";
            sheetObjects[0].CellValue(arrCheckedRows[i], "prop_sts_nm") = "Published";
            sheetObjects[0].CellValue(arrCheckedRows[i], "eff_dt") = pubDate;
            sheetObjects[0].CellValue(arrCheckedRows[i], "pub_dt") = pubDate;
            sheetObjects[0].RowStatus(arrCheckedRows[i]) = "R";
    	}
    	sheetObjects[0].CheckAll2("chk") = 0;
        
    }
    
	/**
	 * 권한 세팅
	 * 
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function setAuthority() {
		var formObj = document.form;
		
		bIsCreUsr = false;
	    bIsReqUsr = false;
	    bIsAproUsr = false;
		
	    // 생성권자 권한. Sales Rep. Code를 가지거나, Scope에 권한이 있는  경우.
		if (formObj.srep_cd.value != "" || bHasAuthTariff) {
			bIsCreUsr = true;
		} else {
			bIsCreUsr = false;
		}
		
		// 수정권자 권한. 생생권자의 권한이 있으며, 해당  Prop를 생성한 경우.
		if ((formObj.srep_cd.value != "" || bHasAuthTariff) && formObj.usr_id.value == sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "tri_rqst_usr_id")) {
			bIsReqUsr = true;
		} else {
			bIsReqUsr = false;
		}
		
		
		// 승인권자 권한. Tariff에 권한이 있으며, Prop의 Approval Office에 소속된 사람일 경우.
		// 또는 자신이 속한 오피스의 HQ 오피스가 SHARC HAMRU NYCRA SINRS이고, Prop의 Approval Office가 그 HQ 오피스중 하나일때.
		// 승인권자는 수정권한도 같이 갖는다.
		if (bHasAuthTariff && (formObj.ofc_cd.value == sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "tri_apro_ofc_cd") ||  ((formObj.rhq_ofc_cd.value == "SHARC" || formObj.rhq_ofc_cd.value == "HAMRU" || formObj.rhq_ofc_cd.value == "NYCRA" || formObj.rhq_ofc_cd.value == "SINRS") && formObj.rhq_ofc_cd.value == sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "tri_apro_ofc_cd")))) {
			bIsAproUsr = true;
			bIsReqUsr = true;
		} else {
			bIsAproUsr = false;
		}

		formObj.is_req_usr.value = bIsReqUsr;
		formObj.is_apro_usr.value = bIsAproUsr;
	}
	
	/**
	 * 사용자가 주어진 row의 Prop에 승인권한이 있는지 확인.
	 * 
	 * @param {int} row row number
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function hasAproAuth(row) {
		var formObj = document.form;
		
		if (bHasAuthTariff && (formObj.ofc_cd.value == sheetObjects[0].CellValue(row, "tri_apro_ofc_cd") ||  ((formObj.rhq_ofc_cd.value == "SHARC" || formObj.rhq_ofc_cd.value == "HAMRU" || formObj.rhq_ofc_cd.value == "NYCRA" || formObj.rhq_ofc_cd.value == "SINRS") && formObj.rhq_ofc_cd.value == sheetObjects[0].CellValue(row, "tri_apro_ofc_cd")))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 사용자가 주어진 row의 Prop에 수정(Request)권한이 있는지 확인. 승인권한자는 수정권한도 갖는다.
	 * 
	 * @param {int} row row number
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function hasRqstAuth(row) {
		var formObj = document.form;
		
		if ((formObj.srep_cd.value != "" || bHasAuthTariff) && formObj.usr_id.value == sheetObjects[0].CellValue(row, "tri_rqst_usr_id")) {
			return true;
		} else if (hasAproAuth(row)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function toggleButtons(mode) {
    	var formObj = document.form;
    	
        switch (mode) {
        case "CLEAR":
        	ComBtnEnable("btn_retrieve_s");
            ComBtnEnable("btn_new_s");
            ComBtnDisable("btn_grical_s");
            ComBtnDisable("btn_request_s");
            ComBtnDisable("btn_rcancel_s");
            ComBtnDisable("btn_approve_s");
            ComBtnDisable("btn_acancel_s");
            ComBtnDisable("btn_publish_s");
/*          ComBtnDisable("btn_send_s"); */
            
            ComBtnDisable("btn_taalist");
            formObj.cmdt_cd.readOnly = true;
            btnImgEnable("btn_srch_cmdt", false);
            btnImgEnable("btn_srch_org_pnt", false);
            btnImgEnable("btn_srch_org_via", false);
            btnImgEnable("btn_srch_dest_via", false);
            btnImgEnable("btn_srch_dest_pnt", false);
            
        	ComBtnDisable("btn_calculate");
        	ComBtnDisable("btn_schgdetail");
        	ComBtnDisable("btn_costdetail");
        	
        	ComBtnDisable("btn_retrieve");
        	ComBtnDisable("btn_new");
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_publish");
        	ComBtnDisable("btn_assign");
            ComBtnDisable("btn_cancel");
            ComBtnDisable("btn_copy");
            
    		sheetObjects[1].ColHidden("prs_scg_amt") = true;
    		sheetObjects[1].ColHidden("prs_respb_cm_uc_amt") = true;
    		sheetObjects[1].ColHidden("prs_respb_opfit_uc_amt") = true;
    		sheetObjects[1].ColHidden("prs_respb_cmpb_amt") = true;
    		sheetObjects[1].ColHidden("prs_gid_cmpb_amt") = true;
    		sheetObjects[1].ColHidden("prs_respb_opb_amt") = true;
    		sheetObjects[1].ColHidden("diff") = true;
    		
    		for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
				sheetObjects[1].CellEditable(i, "curr_cd") = false;
				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
				sheetObjects[1].CellEditable(i, "eff_dt") = false;
				sheetObjects[1].CellEditable(i, "exp_dt") = false;
				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
    		}
    		
            break;
            
        case "INIT":
        	ComBtnEnable("btn_retrieve_s");
        	ComBtnEnable("btn_new_s");
        	if (bHasAuthTariff) {
	        	ComBtnEnable("btn_grical_s");
	        	ComBtnEnable("btn_request_s");
	        	ComBtnEnable("btn_rcancel_s");
	        	ComBtnEnable("btn_approve_s");
	        	ComBtnEnable("btn_acancel_s");
	        	ComBtnEnable("btn_publish_s");
/*		       	ComBtnEnable("btn_send_s"); */
        	} else {
                ComBtnDisable("btn_grical_s");
                ComBtnDisable("btn_request_s");
                ComBtnDisable("btn_rcancel_s");
                ComBtnDisable("btn_approve_s");
                ComBtnDisable("btn_acancel_s");
                ComBtnDisable("btn_publish_s");
/*              ComBtnDisable("btn_send_s"); */
        	}
            
        	if (formObj.tri_no.value == "") {
        		ComBtnDisable("btn_taalist");
        	} else {
        		ComBtnEnable("btn_taalist");
        	}
        	
        	// CMDT는 tri_no가 아직 Assign되지 않았고, AMDT_SEQ가 0이고, Initial단계에서만 수정가능.
        	// Route도 마찬가지이지만, Route는 창은 띄울수 있고 팝업 안에서 권한 적용
            if (bIsReqUsr && sheetObjects[1].RowCount > 0 
            		&& formObj.amdt_seq.value == "0"
            		&& formObj.prop_sts_cd.value == "I"
            		&& formObj.tri_no.value == "") {
            	formObj.cmdt_cd.readOnly = false;
            	btnImgEnable("btn_srch_cmdt", true);
            } else {
            	formObj.cmdt_cd.readOnly = true;
            	btnImgEnable("btn_srch_cmdt", false);
            }
            btnImgEnable("btn_srch_org_pnt", true);
            btnImgEnable("btn_srch_org_via", true);
            btnImgEnable("btn_srch_dest_via", true);
            btnImgEnable("btn_srch_dest_pnt", true);
        	
        	ComBtnEnable("btn_retrieve");
        	
        	if (bIsCreUsr) {
        		ComBtnEnable("btn_new");
        		ComBtnEnable("btn_copy");
        	} else {
        		ComBtnDisable("btn_new");
        		ComBtnDisable("btn_copy");
        	}
        	
        	if (bIsReqUsr || bIsAproUsr) {
        		sheetObjects[1].ColHidden("prs_scg_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_cm_uc_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_opfit_uc_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_cmpb_amt") = false;
        		sheetObjects[1].ColHidden("prs_gid_cmpb_amt") = false;
        		sheetObjects[1].ColHidden("prs_respb_opb_amt") = false;
        		sheetObjects[1].ColHidden("diff") = false;
        	} else {
        		sheetObjects[1].ColHidden("prs_scg_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_cm_uc_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_opfit_uc_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_cmpb_amt") = true;
        		sheetObjects[1].ColHidden("prs_gid_cmpb_amt") = true;
        		sheetObjects[1].ColHidden("prs_respb_opb_amt") = true;
        		sheetObjects[1].ColHidden("diff") = true;
        	}
        	
        	ComBtnDisable("btn_calculate");
        	ComBtnDisable("btn_schgdetail");
        	ComBtnDisable("btn_costdetail");
        	
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_assign");
        	ComBtnDisable("btn_publish");
            ComBtnDisable("btn_cancel");
    		
        	if (formObj.prop_sts_cd.value == "I") {
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_calculate");
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
                	
        			ComBtnEnable("btn_save");
        			ComBtnEnable("btn_request");
                	ComBtnEnable("btn_cancel");
        		}
        		if (bIsAproUsr) {
                    ComBtnEnable("btn_calculate");
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
        		}
        	} else if (formObj.prop_sts_cd.value == "Q") {
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
                    
                    ComBtnEnable("btn_cancel");
        		}
        		if (bIsAproUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
                	
        			ComBtnEnable("btn_save");
                	ComBtnEnable("btn_coffer");
                	ComBtnEnable("btn_approve");
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "R") {
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_calculate");
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
                    
        			ComBtnEnable("btn_save");
        			ComBtnEnable("btn_request");
        		}
        		if (bIsAproUsr) {
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "A") {
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
        		}
        		if (bIsAproUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
                    
                	if (formObj.tri_no.value == "") {
                		ComBtnEnable("btn_assign");
                	} else {
                		ComBtnEnable("btn_publish");
                	}
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "F") {
        		if (bIsCreUsr) {
        			ComBtnEnable("btn_amend");
        		}
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
        		}
        		if (bIsAproUsr) {
                    ComBtnEnable("btn_schgdetail");
                    ComBtnEnable("btn_costdetail");
        		}
        	}
        	
        	if (bIsReqUsr || bIsAproUsr) {
        		sheetObjects[1].Editable = true;
        		
	        	for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
	        		var stsCd = sheetObjects[1].CellValue(i, "prop_sts_cd");
//	        		if (stsCd == "A" || stsCd == "F") {
	        		sheetObjects[1].RowEditable(i) = true;
	        		if (i == sheetObjects[1].HeaderRows) {
	        			if (bIsReqUsr && stsCd == "I") {
	        				if (formObj.amdt_seq.value == "0") {
		        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = true;
		        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = true;
		        				sheetObjects[1].CellEditable(i, "curr_cd") = true;
	        				} else {
		        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
		        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
		        				sheetObjects[1].CellEditable(i, "curr_cd") = false;
	        				}
	        				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = true;
	        				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
	        				sheetObjects[1].CellEditable(i, "eff_dt") = true;
	        				sheetObjects[1].CellEditable(i, "exp_dt") = true;
	        				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = true;
	        			} else if (stsCd == "Q") {
	        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
	        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
	        				sheetObjects[1].CellEditable(i, "curr_cd") = false;
	        				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
	        				if (bIsAproUsr) {
	        					sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = true;
	        				} else {
	        					sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
	        				}
	        				sheetObjects[1].CellEditable(i, "eff_dt") = false;
	        				sheetObjects[1].CellEditable(i, "exp_dt") = false;
	        				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
	        			} else if (stsCd == "R") {
	        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
	        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
	        				sheetObjects[1].CellEditable(i, "curr_cd") = false;
	        				if (bIsReqUsr) {
	        					sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = true;
	        				} else {
	        					sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
	        				}
	        				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
	        				sheetObjects[1].CellEditable(i, "eff_dt") = false;
	        				sheetObjects[1].CellEditable(i, "exp_dt") = false;
	        				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
	        			//} else if (stsCd == "A" || stsCd == "F") {
	        			} else {
	        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
	        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
	        				sheetObjects[1].CellEditable(i, "curr_cd") = false;
	        				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
	        				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
	        				sheetObjects[1].CellEditable(i, "eff_dt") = false;
	        				sheetObjects[1].CellEditable(i, "exp_dt") = false;
	        				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
	        			}
	        		} else {
        				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
        				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
        				sheetObjects[1].CellEditable(i, "curr_cd") = false;
        				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
        				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
        				sheetObjects[1].CellEditable(i, "eff_dt") = false;
        				sheetObjects[1].CellEditable(i, "exp_dt") = false;
        				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
	        		}
	        	}
        	} else {
        		for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
    				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
    				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
    				sheetObjects[1].CellEditable(i, "curr_cd") = false;
    				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
    				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
    				sheetObjects[1].CellEditable(i, "eff_dt") = false;
    				sheetObjects[1].CellEditable(i, "exp_dt") = false;
    				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
        		}
        	}
        	
            break;
            
        case "READONLY":
        	ComBtnEnable("btn_retrieve_s");
        	ComBtnEnable("btn_new_s");
            ComBtnDisable("btn_grical_s");
            ComBtnDisable("btn_request_s");
            ComBtnDisable("btn_rcancel_s");
            ComBtnDisable("btn_approve_s");
            ComBtnDisable("btn_acancel_s");
            ComBtnDisable("btn_publish_s");
/*          ComBtnDisable("btn_send_s"); */
            
        	if (formObj.tri_no.value == "") {
        		ComBtnDisable("btn_taalist");
        	} else {
        		ComBtnEnable("btn_taalist");
        	}
        	formObj.cmdt_cd.readOnly = true;
            btnImgEnable("btn_srch_cmdt", false);
        	btnImgEnable("btn_srch_org_pnt", true);
        	btnImgEnable("btn_srch_org_via", true);
        	btnImgEnable("btn_srch_dest_via", true);
        	btnImgEnable("btn_srch_dest_pnt", true);
            
        	ComBtnDisable("btn_calculate");
        	ComBtnDisable("btn_schgdetail");
        	ComBtnDisable("btn_costdetail");
        	
        	ComBtnEnable("btn_retrieve");
        	ComBtnDisable("btn_new");
        	ComBtnDisable("btn_copy");
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_publish");
        	ComBtnDisable("btn_assign");
            ComBtnDisable("btn_cancel");
    		
    		for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellEditable(i, "rat_ut_cd") = false;
				sheetObjects[1].CellEditable(i, "prc_cgo_tp_cd") = false;
				sheetObjects[1].CellEditable(i, "curr_cd") = false;
				sheetObjects[1].CellEditable(i, "prop_frt_rt_amt") = false;
				sheetObjects[1].CellEditable(i, "coffr_frt_rt_amt") = false;
				sheetObjects[1].CellEditable(i, "eff_dt") = false;
				sheetObjects[1].CellEditable(i, "exp_dt") = false;
				sheetObjects[1].CellEditable(i, "tri_apro_ofc_cd") = false;
    		}
            break;
        }
        
        onCickRdoPRSCostLevel();
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
		if (obj.constructor == String) {
			obj = document.getElementsByName(obj)[0];
		}
		var btnStyle = obj.style;
	
		if (gb) {
			obj.Enable = true;
			btnStyle.cursor = "hand";
			btnStyle.filter = "";
			ComBtnEnable(obj.name);
		} else {
			obj.Enable = false;
	
			btnStyle.cursor = "auto";
			btnStyle.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
			ComBtnDisable(obj.name);
		}
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
     function btn_calculate_OnMouseOver(e){
     	//var parentObj = document.getElementById("btn_calculate");
     	//openDynamicPopup(-12,parentObj.clientHeight*-1 - 2,100,20,parentObj);
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
     function btn_calculate_OnMouseOut(e){
     	if( oPopup != null){
     		//oPopup.hide();
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
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
      * 
      * <br><b>Example :</b>
      * <pre>
      *      sheet6LoadEnd(sheetObj)
      * </pre>
      * 
      * 
      * @return 없음
      */              
     function getBackEndJobStatus() {
     	var form = document.form;	
// 		var sheetObj = sheetObjects[0];
 		var sheetObj = sheetObjects[5];
     	form.f_cmd.value = SEARCH05;
     	var sXml = sheetObj.GetSearchXml("ESM_PRI_3001GS.do", "f_cmd="+SEARCH05+"&backendjob_key="+BACKEND_JOB_ID);
     	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
      
     	if (jobStatus == "3") {
//     		clearInterval(TIMER_ID);
     		ComOpenWait(false);		
     		reloadRate();
     		ComShowCodeMessage("PRI03025");
     	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
     		
     		ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
//     	    clearInterval(TIMER_ID);	
     		ComOpenWait(false);	
     	} else if (jobStatus == "5") {
     		
     		ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
//     		clearInterval(TIMER_ID);
     		ComOpenWait(false);	
     	} else {
     		window.setTimeout(getBackEndJobStatus, 3000); // 3초 후에
     	}
     }
 
     

/* 개발자 작업 끝 */