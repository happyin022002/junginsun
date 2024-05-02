/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESM_PRI_2220.js
 *@FileTitle : Master RFA View
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
 * History
 * Master RFA Creation 화면을 BKG에서 조회용 화면을 위해 별도 제작 (모든 버튼 제거)
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
     * @class ESM_PRI_2220 : ESM_PRI_2220 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2220() {
    	this.processButtonClick	= tprocessButtonClick;
    	this.setSheetObject			= setSheetObject;
    	this.loadPage					= loadPage;
    	this.initSheet					= initSheet;
    	this.initControl					= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    /**
     * Copy Date 여부체크
     */
    var cpPriMnFlag = false;

    //New 버튼 클릭시 탭이외 control이 Hidden일 경우 Hidden부분을 Display 하기위한 변수 
    var controlHidden = false;
    
    /**
     * Main 이하 Sheet 관리용
     */
    // Sheet2(Route Group Grid)가 완전히 로드되지 않은경우, OnClick 이벤트를 무시하기 위한 플래그
    var LoadingComplete = false;
    // 사용자가 작성권자인지를 나타내는 플래그
    var bIsReqUsr = false;
    // 사용자가 승인권자인지를 나타내는 플래그
    var bIsAproUsr = false;
    
    // 현재Rate에 승인된 건수가 몇개인지를 저장하는 변수.
    var acptCnt = null;
    // 현재Rate에 미승인 건수가 몇개인지를 저장하는 변수.
    var notAcptCnt = null;
    
    // Origin Via.가 Mandatory인지 여부.
    var isOViaMandatory = true;
    // Dest. Via.가 Mandatory인지 여부.
    var isDViaMandatory = true;
    
    // 화면 reload시 Sheet1,2,3의 현재 Row 및 key값을 미리 저장하는 변수들. s1:Sheet1, s2:Sheet2, s3:Sheet3
    var s1PrevRow = -1;
    var s2PrevRow = -1;
    var s3PrevRow = -1;
//    var s1PrevKey = null;
    var s2PrevKey = null;
    var s3PrevKey = null;
    // 
    var sChgCdVisiable = "";
    
    // Main의 Summary테이블에 저정하기 위한 코드값.
    var TERMS_TYPE_CODE_GEN = 71;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
	 /** 
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  *
	  * @return 없음
	  */ 
	function processButtonClick() {
        
		 /********************* 시트에 대한 설명 *********************/
		 var sheetObject1 = sheetObjects[0];	// Main Info
		 var sheetObject2 = sheetObjects[1];	// Commodity
		 var sheetObject3 = sheetObjects[2];	// Route & Summary
		 var sheetObject4 = sheetObjects[3];	// Rate
		 var sheetObject5 = sheetObjects[4];	// Charge Term (Conversion)
		 var sheetObject6 = sheetObjects[5];	// Service Scope
		 var sheetObject7 = sheetObjects[6];	// sheet3의 Origin Point(Hidden)
		 var sheetObject8 = sheetObjects[7];	// sheet3의 Origin Via.(Hidden)
		 var sheetObject9 = sheetObjects[8];	// sheet3의 Destination Via.(Hidden)
		 var sheetObject10 = sheetObjects[9];	// sheet3의 Destination Point(Hidden)
		 var sheetObject11 = sheetObjects[10];	// sheet3의 Direct Call(Hidden)
		 var sheetObject12 = sheetObjects[11];	// sheet3의 Rnote(Hidden)

		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
				if (getButtonTable(srcName).disabled) {
					return false;
				}
			}
			
			switch(srcName) {
	            case "btn_hidden":            	
	            	setControlHidden();
	            	break;
	            	
	            case "btn_retrieve":
	                doActionIBSheet(sheetObject1,document.form,IBSEARCH);
	                break;
	                
	            case "btn_new":
	                doActionIBSheet(sheetObject1,document.form,IBCREATE);
	                // Service Scope 활성화
	                document.form.ssvc_scp_cd.enable = true;
	                document.form.req_usr_nm.enable = true;
	                break;
	                
	            case "btn_amend":
	            	if (formObj.prop_no.value ==""){
	            		ComShowCodeMessage('PRI01021');
	            		return;
	            	}
	            	//이행 된 데이터의 경우 AMEND 금지
	            	if (sheetObjects[0].CellValue(1, "cre_tp") == "I"){
	            		ComShowCodeMessage('PRI01130');
	            		return;
	            	}
	            	/////////////////////////////////////////////////////////////////////
	            	// update date 검사
	            	var checkSheetObj = sheetObjects[0];
	            	var checkTpCd = "CHECK1";
	            	if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	            		return false;
	            	}
	            	checkTpCd = "CHECK2";
	            	if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	            		return false;
	            	}
	            	/////////////////////////////////////////////////////////////////////
	            	// Amend popup
	                var sParam = getParameters("btn_amend");
	                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2240.do?"+sParam, "ESM_PRI_2240", 500, 245, true);   

	                if (rtnVal != null && rtnVal =="Y"){
	                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	                }
	            	break;
	                
	            case "btn_save":
	                var effDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
	                var sEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
	                
	                // eff date를 수정했음에도 시트에 반영되지 않을 경우를 대비해서 Save 시 값을 다시 넣는다.
	                if (sheetObjects[0].CellValue(1, "amdt_seq") == "0" && effDt != sEffDt){
	                	com_change_sheet( sheetObjects[0], "ctrt_eff_dt" );
	                	com_change_sheet( sheetObjects[5], "ctrt_eff_dt" ); // Service Scope
	                }
	                
	                // Service Scope의 Duration 관리.
	                // 기존 RFA에서는 Duration 입력 후 Service scope를 생성하기 때문에 해줄필요가 없으나 여긴 hidden으로 하나만 먼저 생성하기 때문에 별도로 넣어줘야 한다.
	                if (sheetObjects[0].CellValue(1, "amdt_seq") == "0") {
	                	sheetObjects[5].CellValue2(1, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
	                	sheetObjects[5].CellValue2(1, "eff_dt") = formObj.ctrt_eff_dt.value;
	                } else {
//	                	sheetObjects[5].CellValue2(1, "ctrt_eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
	                	sheetObjects[5].CellValue2(1, "eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
	                }
	                sheetObjects[5].CellValue2(1, "exp_dt") = formObj.ctrt_exp_dt.value; 
	                sheetObjects[5].CellValue2(1, "n1st_cmnc_dt") = sheetObjects[0].CellValue(1,"eff_dt");
	                
					if (!ComPriConfirmSave()) {
						return false;
					}
					
	                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	                break;
	                
	            case "btn_request":
	            	doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
	            	
	                break;
	                
	            case "btn_cancel":
	                if (formObj.prop_no.value ==""){
	                    ComShowCodeMessage('PRI01021');
	                    return;
	                }
	                doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
	                //승인권자 Request Cancel시 공통쪽지 연결
	                var aproUsrFlg = sheetObjects[0].CellValue(1, "apro_usr_flg");
	                
	                if (sheetObjects[0].CellValue(1,"prop_sts_cd") =="I" && aproUsrFlg == "Y"){
//	                    ComOpenWait(true); //->waiting->start
//	                    openMessagePopup(sheetObjects[0].CellValue(1,"prop_sts_cd"), sheetObjects[0].CellValue(1,"prop_srep_cd"));
//	                    ComOpenWait(false); //->waiting->End
	                }
	                break;
	                
	            case "btn_approve":
	                if (formObj.prop_no.value ==""){
	                    ComShowCodeMessage('PRI01021');
	                    return;
	                }               
	                doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
	                break;
	                
	            case "btn_copy":
	                if (formObj.prop_no.value ==""){
	                    ComShowCodeMessage('PRI01021');
	                    return;
	                }
	                var sheetObj = sheetObjects[0];
	                var sRfa_No = sheetObj.CellValue(1,"rfa_no");
	                var sPropNo = sheetObj.CellValue(1,"prop_no");
	                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
	                var ssvcScpCd = sheetObj.CellValue(1, "svc_scp_cd");
	                var sEff_dt = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"), "ymd");
	                var sExp_dt = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"), "ymd");
	                
	                var sParam = "copyFlg=basic&" + "rfa_no="+sRfa_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq + "&svc_scp_cd=" + ssvcScpCd + "&cmdt_hdr_seq=1";
                	sParam += "&eff_dt=" + sEff_dt + "&exp_dt=" + sExp_dt;
	                
	                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2244.do?"+sParam, "ESM_PRI_2244",1100, 465, true);
	                if(str != null){
	                    formObj.prop_no.value = str;
	                    formObj.rfa_no.value ="";
	                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	                }
	                break;
	                
	            case "btn_copy_to_rfa":
	                if (formObj.prop_no.value ==""){
	                    ComShowCodeMessage('PRI01021');
	                    return;
	                }
	                var sheetObj = sheetObjects[0];
	                var sRfa_No = sheetObj.CellValue(1,"rfa_no");
	                var sPropNo = sheetObj.CellValue(1,"prop_no");
	                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
	                var ssvcScpCd = sheetObj.CellValue(1, "svc_scp_cd");
	                var sEff_dt = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"), "ymd");
	                var sExp_dt = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"), "ymd");
	                
	                var sParam = "copyFlg=spot&" + "rfa_no="+sRfa_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq + "&svc_scp_cd=" + ssvcScpCd + "&cmdt_hdr_seq=1";
	                	sParam += "&eff_dt=" + sEff_dt + "&exp_dt=" + sExp_dt;
	                
	                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2244.do?"+sParam, "ESM_PRI_2244", 1100, 485, true);
	                if(str != null){
	                	// RFA Proposal & Amendment Creation 호출
	                	var popParams = "mst_prop_no=" + str;
	                	comCallPop("ESM_PRI_2003", "ESM_PRI_2203", popParams, "");
	                }
	                break;
	                
	            case "btn_acceptall":
	            	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	            		return;
	            	}
	            	
	            	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
	            	
	            	break;
	            	
	            case "btn_acceptcancel":
	            	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC04);
	            	
	            	break;
	            	
	            case "btn_gricalc":
	            	if (formObj.prop_no.value != "" && formObj.amdt_seq.value != "" && formObj.svc_scp_cd.value != "") {
						ComPriOpenWindowCenter("/hanjin/ESM_PRI_2233.do?" + FormQueryString(formObj), "ESM_PRI_2233", 1000, 490, false);
					}
	            	
	            	break;
	                
				case "btn_downexcel":
					if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
						return;
					}
					
					sheetObjects[2].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk");
					
					break;
	            	
				case "btn_loadexcel":
					if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
						return;
					}
					
					formObj.f_cmd.value = "";
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2208.do?" + FormQueryString(formObj), "ESM_PRI_2208", 950, 563, false);
					break;
	            	
	            case "btns_calendar1": //달력버튼
	                var cal = new ComCalendar();
	                cal.select(document.form.ctrt_exp_dt, 'yyyy-MM-dd');
	                break;
	                
	            case "btn_rowadd1":
	                doActionIBSheet(sheetObject3,document.form,IBINSERT);
	                break;

	            case "btn_rowcopy":
	                doActionIBSheet(sheetObject3, document.form, IBCOPYROW);
	                break;
	                
	            case "btn_delete1":
	                doActionIBSheet(sheetObject3,document.form,IBDELETE);
	                break;
	                
	            case "btn_save1":
	            	doActionIBSheet(sheetObject3, document.form, IBSAVE);
	                break;
	                
	            case "btn_accept1":
	                doActionIBSheet(sheetObject3, document.form, IBSEARCH_ASYNC13);
	                break;
	                
	            case "btn_acceptcancel1":
	                doActionIBSheet(sheetObject3, document.form, IBSEARCH_ASYNC14);
	                break;
	                
	            case "btn_rowadd2":
	                doActionIBSheet(sheetObject4,document.form,IBINSERT);
	                break;
	                
	            case "btn_delete2":
	                doActionIBSheet(sheetObject4,document.form,IBDELETE);
	                break;

	            case "btn_save2":
	            	doActionIBSheet(sheetObject3, document.form, IBSAVE);
	                break;
	                
	            case "btn_amend2":
	                doActionIBSheet(sheetObject4, document.form, IBSEARCH_ASYNC11);
	                break;

	            case "btn_amendcancel2":
	                doActionIBSheet(sheetObject4, document.form, IBSEARCH_ASYNC12);
	                break;

	            case "btn_accept2":
	                doActionIBSheet(sheetObject4, document.form, IBSEARCH_ASYNC13);
	                break;

	            case "btn_acceptcancel2":
	                doActionIBSheet(sheetObject4, document.form, IBSEARCH_ASYNC14);
	                break;

	            case "btn_rowadd3":
	                doActionIBSheet(sheetObject5,document.form,IBINSERT);
	                break;
	                
	            case "btn_delete3":
	                doActionIBSheet(sheetObject5,document.form,IBDELETE);
	                break;

	            case "btn_save3":
	            	doActionIBSheet(sheetObject3, document.form, IBSAVE);
	                break;
	                
	            case "btn_amend3":
	            	doActionIBSheet(sheetObject5, document.form, IBSEARCH_ASYNC11);
	                break;

	            case "btn_amendcancel3":
	                doActionIBSheet(sheetObject5, document.form, IBSEARCH_ASYNC12);
	                break;
	                
	            case "btn_accept3":
	                doActionIBSheet(sheetObject5, document.form, IBSEARCH_ASYNC13);
	                break;
	                
	            case "btn_acceptcancel3":
	            	doActionIBSheet(sheetObject5, document.form, IBSEARCH_ASYNC14);
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
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 *
	 * @param  {object}   sheet_obj 필수, sheet Object
	 * @return 없음
	 */ 
	function setSheetObject(sheet_obj) {
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
     * @author 공백진
     * @version 2009.04.17
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
	 * </pre>
	 * 
	 * @return 없음
	 */ 
	function loadPage() {
		
        for (var i = 0; i < sheetObjects.length; i++) {
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);   
            initSheet(sheetObjects[i], i + 1);          
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            sheetObjects[i].XmlHttpVer = 2;
        }
		
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);	
        
        var form = document.form; 
		// TODO 완료 후 제거
		//http://localhost:7001/hanjin/ESM_PRI_2220.do
        
        form.rfa_no.value= form.bkg_rfa_no.value ;
        form.amdt_seq.value = form.bkg_amdt_seq.value ;
		//## 임시 사용 #################################
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	/**
	 * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initControl()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 공백진
	 * @version 2009.04.17
	 */    
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)            
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
		axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
		axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
	}
	
	/**
	 * OnKeyPress event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 공백진
	 * @version 2009.04.17
	 */
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				if (event.srcElement.name == "rfa_no" || event.srcElement.name =="prop_no") {
					ComKeyOnlyAlphabet('uppernum');
				} else {
					ComKeyOnlyAlphabet('upper');
				}
				break;
			case "int":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			default:
		}
	}
	
	/**
	 * OnKeyDown event를 처리한다. <br>
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
	//enter key조회
	var eleName = event.srcElement.name;
		if (eleName == "prop_no" || eleName == "rfa_no"){
			var keyValue = null;
			if(event == undefined || event == null) {
				keyValue = 13;
			} else {
				keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			}
			if (keyValue == 13){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}
	
	/**
	 * On before deactivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 공백진
	 * @version 2009.04.17
	 */        
	function obj_deactivate() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];	// Main Info
		var sheetObj1 = sheetObjects[5]; // Hidden. Service scope
		var eleName = event.srcElement.name;
		
		switch(eleName){
			case "rfa_no":
				break;
			case "prop_no":
				break;
			case "ctrt_exp_dt":
				ComChkObjValid(event.srcElement);
				
				var effDt = "";
				if(formObj.amdt_seq.value == "0") {
					effDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value, "ymd");
				} else {
					effDt = ComGetUnMaskedValue(formObj.eff_dt.value, "ymd");
				}
				var expDt = ComGetUnMaskedValue(formObj.ctrt_exp_dt.value, "ymd");
				
				// 현재 Eff Date 기준으로 14일 체크
//				if(ComGetDaysBetween(effDt, expDt) >= 15) {
//					ComShowCodeMessage("PRI07060"); // Duration should not be more than 14 days for Master RFA Publishing.
//					formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "ctrt_exp_dt"), "ymd"); // 원래 ctrt_exp_dt로 원복 시킨다.
//					return;
//				}
				
				com_change_sheet( sheetObj, eleName );
				com_change_sheet( sheetObj1, eleName );
				sheetObj.CellValue2(1, "exp_dt") = expDt;
				break;
				
			case "ctrt_eff_dt":
				ComChkObjValid(event.srcElement);
				
				if(formObj.amdt_seq.value == "0") {
					if(ComGetDaysBetween(ComGetNowInfo('ymd', ''), formObj.ctrt_eff_dt.value) < 0 && formObj.amdt_seq.value == "0"  && prop_sts_cd == "I") {
						ComShowCodeMessage("PRI01160"); // Retroactive Filing is not allowed
						formObj.ctrt_eff_dt.focus();
						return;
					}
					com_change_sheet( sheetObj, eleName );
					com_change_sheet( sheetObj1, eleName );
				}
				break;
			default:
				ComChkObjValid(event.srcElement);
		}
	}
	
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**
     * service scope combo 초기화시 동작함<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {comboObj} comboObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function ssvc_scp_cd_OnClear(comboObj) {
    	var formObject = document.form;
    	comboObj.Index2 = -1;
    	formObject.svc_scp_cd.value = "";
    }
    
    /**
     * service scope combo 초기화시 동작함<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {comboObj} comboObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function ssvc_scp_cd_OnChange(comboObj) {
    	var formObject = document.form;
    	formObject.svc_scp_cd.value = formObject.ssvc_scp_cd.Code;
    	sheetObjects[0].CellValue(1, "svc_scp_cd") = formObject.ssvc_scp_cd.Code;
    	sheetObjects[5].CellValue(1, "svc_scp_cd") = formObject.ssvc_scp_cd.Code;
    }
    
    /**
     * service scope combo 초기화시 동작함<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {comboObj} comboObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function req_usr_nm_OnClear(comboObj) {
    	var formObject = document.form;
    	comboObj.Index2 = -1;
    	formObject.req_usr_id.value = "";
    	//sheetObjects[0].CellValue2(1, "prop_usr_id") = "";
    }
    
    /**
     * service scope combo 초기화시 동작함<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {comboObj} comboObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function req_usr_nm_OnChange(comboObj) {
    	var formObject = document.form;
    	formObject.req_usr_id.value = formObject.req_usr_nm.Code;
    	sheetObjects[0].CellValue2(1, "prop_usr_id") = formObject.req_usr_nm.Code;
    }
    
    /**
     * Master RFA의 Request Staff 리스트를 취득한다.<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @author 전지예
     * @version 2016.04.22
     */
    function getMstRfaRequestorList() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(formObj.prop_ofc_cd.value == "") {
        	formObj.etc1.value = formObj.in_usr_ofc_cd.value;
        } else {
        	formObj.etc1.value = formObj.prop_ofc_cd.value;
        }
        formObj.f_cmd.value = SEARCH32;//SEARCH32 <-- SEARCH15
        var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.req_usr_nm, "cd", "nm|cd");
        formObj.req_usr_nm.InsertItem(0, "", "");
        formObj.req_usr_nm.value = "";
    }
    
	/**
	 * 팝업화면에서 변경된 내용을 Route(sheet3) 에 반영한다.<br>
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
    function setSheetRowData(sheetObj, Row, Col) {
        var formObj = document.form;
        var prevStatus = sheetObj.RowStatus(Row);
        
        // Origin
        sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sheetObjects[6].CellValue(1, "rout_pnt_loc_def_cd");
        sheetObj.CellValue2(Row, "rcv_de_term_cd_ori") = sheetObjects[6].CellValue(1, "rcv_de_term_cd");
        // Origin via.
        sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sheetObjects[7].CellValue(1, "rout_via_port_def_cd");
        // Dest via.
        sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sheetObjects[8].CellValue(1, "rout_via_port_def_cd");
        // Dest
        sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sheetObjects[9].CellValue(1, "rout_pnt_loc_def_cd");
        sheetObj.CellValue2(Row, "rcv_de_term_cd_dest") = sheetObjects[9].CellValue(1, "rcv_de_term_cd");
        
        sheetObj.RowStatus(Row) = prevStatus;
    }
    
	/**
	 * OnBeforeActivate   event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_activate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 공백진
	 * @version 2009.04.17
	 */
	function obj_activate() {
		var formObj = document.form;
		var srcName = event.srcElement.getAttribute("name");
		ComClearSeparator (event.srcElement);
	}
	
	/** 
	 * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {object} formObj 필수, html document form Object
	 * @param {int} sAction 필수, action의 구분
	 * @return 없음
	 */   
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		try {
            
			switch(sAction) {
	 			case IBSEARCH:	 //조회
	            	ComOpenWait(true); //->waiting->start
	 				cpPriMnFlag = false;
	                
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    ComShowCodeMessage('PRI08001');
	                    return false;
	                }
	                
	                if (sheetObj.id == "sheet1") {
	                	for (var i = 0; i < sheetObjects.length; i++) {
	                		sheetObjects[i].RemoveAll();
	                	}
	                	formObj.f_cmd.value = SEARCH01;
	                	if(formObj.rfa_no.value!=""){
	                		formObj.prop_no.value = "";
	                	}
	                	
	                	// 데이터 취득
	                	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2203GS.do" , FormQueryString(formObj));
	                	var arrXml = sXml.split("|$$|");
	                	
	                	// Basic Info
	                	if (arrXml.length > 0) {
	                		sheetObjects[0].LoadSearchXml(arrXml[0]);
	                		formObj.ori_prop_no.value = sheetObjects[0].CellValue(1, "prop_no");
	                		formObj.ori_rfa_no.value = sheetObjects[0].CellValue(1, "rfa_no");
	                		formObj.svc_scp_cd.value = sheetObjects[0].CellValue(1, "svc_scp_cd");
	                		formObj.prc_prop_sts_cd.value = sheetObjects[0].CellValue(1, "prop_sts_cd");
	                		
	                		if(!ComIsNull(sheetObjects[0].CellValue(1, "prop_no")) && ComIsNull(sheetObjects[0].CellValue(1, "eff_dt")) &&  ComIsNull(sheetObjects[0].CellValue(1, "exp_dt"))) {
	                			cpPriMnFlag = true;
	                		}
	                	}
	                	
	                	if (arrXml.length > 1) sheetObjects[5].LoadSearchXml(arrXml[1]);	// Hidden. Service Scope
	                	if (arrXml.length > 2) sheetObjects[1].LoadSearchXml(arrXml[2]);	// sheet2. Commodity
	                	
	                	if (sheetObjects[1].RowCount > 0) sheetObjects[1].PopupButtonImage(1, "prc_cmdt_def_cd") = 0; // Commodity 돋보기 비활성
	                	
	                	// Charge Term (Conversion)의 Code Combo 설정 
	                	if (arrXml.length > 3) {
	                		// ComboBox에는 표시되지 않지만 이행데이타에 존재하는 Rule Code
	                		var unDisplayCode = "|APP";
	                		
	                		var arrData = ComPriXml2ComboString(arrXml[3], "cd", "nm");
	                		sheetObjects[4].InitDataCombo(0,"chg_rule_def_cd", arrData[1] + unDisplayCode, arrData[0] + unDisplayCode, "", "", 0, "", "", arrData[1]);
	                		
	                		sChgCdVisiable = arrData[1];
	                	}
	                	
	                	ComOpenWait(false); //->waiting->End
	                	
	                	// 초기화
	                	if (ComPriGetRowCountFromXML(arrXml[0]) == -1){
	                		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
	                	} else {
	                        // Search Sheet3
	                        doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
	                	}

	                	buttonControl();
	                	formObj.prop_no.focus();
	                	
	                // Route & Summary
	                } else if (sheetObj.id == "sheet3") {
 		        		for (var a = 2; a < sheetObjects.length; a++) {
 		        			if (a == 5 || a == 10) { // hidden. Service Scope & Direct Call(Hidden)은 제외. 
 		        				continue;
 		        			}
 		        			sheetObjects[a].RemoveAll();
 		        		}
 		        		
		                formObj.f_cmd.value = SEARCH02;
		                sheetObj.DoSearch("ESM_PRI_2203_01GS.do" , FormQueryString(formObj)); // 화면에 색을 먹히기 위해
	                	
		            // Rate & Conversion
	                } else if (sheetObj.id == "sheet4") {
 		        		for (var a = 3; a < sheetObjects.length; a++) {
 		        			if (a == 5 || a == 10) { // hidden. Service Scope & Direct Call(Hidden)은 제외. 
 		        				continue;
 		        			}
 		        			sheetObjects[a].RemoveAll();
 		        		}
 		        		
		                formObj.f_cmd.value = SEARCH03;
		                var sXml = sheetObj.GetSearchXml("ESM_PRI_2203GS.do" , FormQueryString(formObj));
		                var arrXml = sXml.split("|$$|");
		                
		                if (arrXml.length > 0) sheetObjects[3].LoadSearchXml(arrXml[0]);    // Rate
		                if (arrXml.length > 1) sheetObjects[6].LoadSearchXml(arrXml[1]);    // Hidden. Grid2의 Origin Point.
		                if (arrXml.length > 2) sheetObjects[7].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Via.
		                if (arrXml.length > 3) sheetObjects[8].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Destination Via.
		                if (arrXml.length > 4) sheetObjects[9].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Point.
		                if (arrXml.length > 5) sheetObjects[11].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Route Note.
		                if (arrXml.length > 6) sheetObjects[4].LoadSearchXml(arrXml[6]);    // Charge Term (Conversion)
		                
		                setSheet4Style(sheetObj, -1);
		                setSheet5Style(sheetObjects[4], -1);
	                }
	                	
                	ComOpenWait(false); //->waiting->End
                	
					break;

	            case IBCREATE: // New
	            	ComOpenWait(true); //->waiting->start
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }
	                
	                clearAllForms();
	                
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                // Service Scope
	                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	                
	                // Request Staff
	                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	                
	                // Main Info
	                sheetObjects[0].DataInsert();
	                var sheetObj = sheetObjects[0];
	                
	                sheetObj.CellValue2(1,"prop_sts_cd")= "I";
	                sheetObj.CellValue2(1,"prc_prog_sts_cd")= "I";
	                sheetObj.CellValue2(1,"src_info_cd")= "NW";
	                sheetObj.CellValue2(1,"prop_ofc_cd")= formObj.in_usr_ofc_cd.value;
	                sheetObj.CellValue2(1,"cntr_lod_ut_cd")= "T"; // 	TEU
	                sheetObj.CellValue2(1,"dmdt_ft_tp_cd")= "T";	// DMDT Tariff 고정
	                sheetObj.CellValue2(1, "prc_prop_cre_tp_cd") = "G";
	                sheetObj.CellValue2(1, "rfa_ctrt_tp_cd") = "M";
	                sheet1_OnSearchEnd(sheetObj); 
	                
	                sheetObj.CellValue2(1,"amdt_seq")= "0";
	                formObj.amdt_seq.value = "0";
	                
	 		        /** hidden. Service Scope  - Start **/
	                sheetObj = sheetObjects[5];
					var idx = sheetObj.DataInsert();
					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
					sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
					sheetObj.CellValue2(idx, "prop_scp_ofc_cd") = formObj.in_usr_ofc_cd.value;
					sheetObj.CellValue2(idx, "tgt_mvc_qty") = "0";
					sheetObj.CellValue2(idx, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
					sheetObj.CellValue2(idx, "ctrt_exp_dt") = formObj.ctrt_exp_dt.value;
					sheetObj.CellValue2(idx, "eff_dt") = formObj.ctrt_eff_dt.value;
					sheetObj.CellValue2(idx, "exp_dt") = formObj.ctrt_exp_dt.value;
					sheetObj.CellValue2(idx, "pre_exp_dt") = sheetObjects[0].CellValue(1, "pre_exp_dt");
					sheetObj.CellValue2(idx, "prop_scp_sts_cd") = "I";
					sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
					sheetObj.CellValue2(idx, "cntr_lod_ut_cd") = "T";	// TEU
					sheetObj.CellValue2(idx, "prop_scp_srep_cd") = "00000";	// NOT NULL 값이나, Sales Rep.이 없기 때문에 임의로 입력.
					sheetObj.CellValue2(idx, "src_info_cd") = "NW";
					sheetObj.CellValue2(idx, "n1st_cmnc_dt") = sheetObjects[0].CellValue(1,"eff_dt");
	 				/** hidden. Service Scope  - end */
	                
	            	ComOpenWait(true); //->waiting->start
	            	// effective date 현재 날짜로 시작
	            	formObj.ctrt_eff_dt.value = ComGetNowInfo('ymd', '-');
	            	// expired date 2주 후로 시작
	            	formObj.ctrt_exp_dt.value = ComGetDateAdd(null, "D", '14');
	                formObj.ctrt_exp_dt.focus();
	                buttonControl();
	                
	                formObj.ctrt_eff_dt.readOnly = false;
	                formObj.ctrt_exp_dt.readOnly = false; 
	                btnImgEnable(formObj.btns_calendar1, true);
	                
	                break;
	                
	            case COMMAND02: // Request
	            	ComOpenWait(true); //->waiting->start
	        		if (!validateForm(sheetObj,document.form,sAction)) {
	        			return false;
	        		}
	    	        
	    	        // Request Popup
	    	        var sParam = "prop_no="+sheetObjects[0].CellValue(1,"prop_no")+"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");
	    	        var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2007.do?"+sParam, "ESM_PRI_2007", 820, 405, true);
	    	        if(str == null){
	    	            return false;
	    	        }
	    	        
	    	        formObj.f_cmd.value = MULTI03;
	    	        sheetObjects[0].CellValue2(1,"prop_sts_cd") = "Q";
	    	        
	    	        var sParam = "";
	    	        var sParamSheet1 = sheetObjects[0].GetSaveString(true); // Main Info
	    	        if (sParamSheet1 != "") {
	    	            sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
	    	        }
	    	        var sParamSheet2 = sheetObjects[5].GetSaveString(true); // Service Scope             
	    	        if (sParamSheet2 != "") {
	    	            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet5_");
	    	        }
	    	        sParam += "&" + FormQueryString(formObj);
	    	        sParam += "&arbiExecSvcScpCd=" + guideExcepSvcScpCd.toString();
	    	        
	    	        var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2203GS.do", sParam);
	    	        sheetObjects[0].LoadSaveXml(sXml);
	    	        
	    	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    	        ComOpenWait(false); //->waiting->End
	            	
	            	break;

	            case COMMAND04: // Approve
	            	ComOpenWait(true); //->waiting->start	
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }      
	            
	                formObj.f_cmd.value = MULTI04;
	                sheetObj.CellValue2(1,"prop_sts_cd") = "A";
	                var sParam = "prop_no=" + sheetObjects[0].CellValue(1, "prop_no") +"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");            
	                sParam += "&"+ sheetObjects[0].GetSaveString(true);
	                sParam += "&"+FormQueryString(formObj);
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
	                sheetObjects[0].LoadSaveXml(sXml);
	                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	                ComOpenWait(false); //->waiting->End
	                break;    
	                
	                
	            case COMMAND05: // Cancel
	            	ComOpenWait(true); //->waiting->start
	                var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
	            	var amdtSeq = formObj.amdt_seq.value;
	            	var sXml = "";
	            	
	            	if (amdtSeq == "0"){
	        	        if (prop_sts_cd !="I" && !ComShowCodeConfirm("PRI01046")) {
	        	            return false;
	        	        }   
	            	}else{
	        	        if (!ComShowCodeConfirm("PRI01046")) {
	        	            return false;
	        	        }   
	            	}
	            	
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }    
	                
	                formObj.f_cmd.value = MULTI05;            
	            
	                switch(prop_sts_cd) {
	                case 'I':   // Initial 모든 데이터 삭제
	    	        	if (amdtSeq == "0"){
	    	                if (!ComShowCodeConfirm("PRI01124")) {
	    	                    return false;
	    	                }    
	    	        	}else{
	    	                if (!ComShowCodeConfirm("PRI01050")) {
	    	                    return false;
	    	                }    
	    	        	}

	                    sheetObj.CellValue2(1,"prop_sts_cd") = "D";     
	                
	                    var sParam = "";
	                    
	                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
	                    if (sParamSheet1 != "") {
	                        sParam += ComPriSetPrifix(sParamSheet1, "sheet1_");
	                    }else{
	                    	sheetObj.CellValue2(1,"prop_sts_cd") = "I";
	                    	return false
	                    }
	                    var sParamSheet2 = sheetObjects[5].GetSaveString(true);// scope의모든 데이터를 넘긴다.
	                    if (sParamSheet2 != "") {
	                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet6_");
	                    }else{
	                    	sheetObj.CellValue2(1,"prop_sts_cd") = "I";
	                    	return false
	                    }
	                    sParam += "&" + FormQueryString(formObj);
	                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2203GS.do", sParam);
	                    
	                    var amdtSeq = formObj.amdt_seq.value;
	                    if (amdtSeq != "0"){
	                        formObj.amdt_seq.value = ComParseInt(amdtSeq) - 1;
	                    }else{
	                        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
	                    }
	                    break;
	                case 'Q':   // Requested    
		            	var reqUsrFlg  = sheetObjects[0].CellValue(1, "req_usr_flg");
	                	var aproUsrFlg = sheetObjects[0].CellValue(1, "apro_usr_flg");

	                	if (reqUsrFlg == "Y" && aproUsrFlg !="Y"){
		            		if (checkRequestCancel() != "Y"){	            			
		            			return false;
		            		}
		            	}
		            	formObj.f_cmd.value = MULTI05;
	                    sheetObj.CellValue2(1,"prop_sts_cd") = "I";             
	                         
	                	var sParam = "";
	                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);             
	                    if (sParamSheet1 != "") {
	                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	                    }               
	                    var sParamSheet2 = sheetObjects[5].GetSaveString(true);             
	                    if (sParamSheet2 != "") {
	                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet6_");
	                    }       
	                    sParam += "&" + FormQueryString(formObj);
	                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2203GS.do", sParam);             
	        
	                    break;
	                case 'A':   // Approved
	    	            var sParamSheet2 = sheetObjects[5].GetSaveString(true);// scope의모든 데이터를 넘긴다.
	    	            if (sParamSheet2 == "") {
	    	            	return;
	    	            }
	    	            
	                    sheetObj.CellValue2(1,"prop_sts_cd") = "Q";
	                    
	                    var sParam = "";
	                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
	                    if (sParamSheet1 != "") {
	                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	                    }
	                     sParamSheet2 = sheetObjects[5].GetSaveString(true);             
	                    if (sParamSheet2 != "") {
	                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet6_");
	                    }
	                    sParam += "&" + FormQueryString(formObj);
	                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2203GS.do", sParam);
	               
	                    break;
	        
	                }   
	                sheetObjects[0].LoadSaveXml(sXml);
	                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	                ComOpenWait(false); //->waiting->End
	                break;
	            	
	            case IBSEARCH_ASYNC01: // Service Scope 설정
	            	comboObjects[0].RemoveAll();
	            	ComPriTextCode2ComboItem(scopeCdValue, scopeCdText, getComboObject(comboObjects, 'ssvc_scp_cd'), "|", "\t" );
	    	        
	                break;

	            case IBSEARCH_ASYNC02: // Request Staff 설정
	            	comboObjects[1].RemoveAll();
	            	getMstRfaRequestorList();
	    	        
	                break;
	                
	 			case IBSAVE:
	            	ComOpenWait(true); //->waiting->start
	            	if (!validateForm(sheetObj,document.form,sAction)) {
	                    return false;
	                }
	 				
	                // Main Save
	                if (sheetObj.id == "sheet1") {
                        // Commodity가 없으면 강제로 Default값 rowadd
                        if(sheetObjects[1].RowCount == 0) {
                        	var idx = sheetObjects[1].DataInsert();
                        	
                        	sheetObjects[1].CellValue(idx, "prop_no") = formObj.prop_no.value;
                        	sheetObjects[1].CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
                        	sheetObjects[1].CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
                        	sheetObjects[1].CellValue(idx, "cmdt_hdr_seq") = 1;
                        	sheetObjects[1].CellValue(idx, "blet_dp_seq") = 1;
                        	sheetObjects[1].CellValue(idx, "cmdt_seq") = 1;
                        	sheetObjects[1].CellValue(idx, "prc_cmdt_tp_cd") = "C";	// Commodity
                        	sheetObjects[1].CellValue(idx, "prc_cmdt_def_cd") = "000000";
                        	sheetObjects[1].CellValue(idx, "prc_cmdt_def_nm") = "FAK OR CARGO, NOS";
                        	sheetObjects[1].CellValue(idx, "fic_rt_tp_cd") = formObj.fic_rt_tp_cd.value;
    	 		            sheetObjects[1].CellValue(idx, "prc_prog_sts_cd") = "I";
    	 		            sheetObjects[1].CellValue(idx, "prc_prog_sts_nm") = "Initial";
    	 		            sheetObjects[1].CellValue(idx, "src_info_cd") = "NW";
    	 		            sheetObjects[1].CellValue(idx, "src_info_nm") = "New";
    	 		            sheetObjects[1].CellValue(idx, "eff_dt") = formObj.eff_dt.value;
    	 		            sheetObjects[1].CellValue(idx, "exp_dt") = formObj.ctrt_exp_dt.value;
                        	sheetObjects[1].CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
                        }
                		
	                	// proposal 여부를 포함하여 parameter 에 보내준다. main 관련 이외의 것들은
	                	// proposal 이 아닌 경우는 건너뜀
	                	var mstAmdtSeq = formObj.amdt_seq.value;
	                	
	                	formObj.f_cmd.value = MULTI01;
	                	var sParam = "";
	                	var sParamSheet1 = sheetObjects[0].GetSaveString(true);
	                	if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
	                		return;
	                	}
	                	if (sParamSheet1 != "") {
	                		sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
	                	}
	                	var sParamSheet2 = sheetObjects[1].GetSaveString();
	                	if (sParamSheet2 != "") {
	                		sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	                	}
	                	var sParamSheet6 = sheetObjects[5].GetSaveString(true);
	                	if (sParamSheet6 != "") {
	                		sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
	                	}
	                	
	                	sParam += "&" + FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;
	                	sParam += "&cpPriMnFlag=" + cpPriMnFlag;
	                	sParam += "&arbiExecSvcScpCd=" + guideExcepSvcScpCd.toString();
	                	var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
	                	
	                	sheetObjects[0].LoadSaveXml(sXml);
	                	sXml = ComDeleteMsg(sXml);//메세지를 하나만 보여주기 위하여
	                	sheetObjects[1].LoadSaveXml(sXml);
	                	var formObj = document.form;
	                	if(formObj.rfa_no.value=="" && formObj.prop_no.value==""){
	                		formObj.prop_no.value = ComGetEtcData(sXml,"prop_no");
	                	}
	                	doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
	                } else if (sheetObj.id == "sheet3") {
		            	for (var a = 3; a <= 11; a++) {
		                    if (a == 5 || a == 10) { // hidden. Service Scope & Direct Call(Hidden)제외
		                        continue;
		                    }
		                    // Source가 GC나 PC인 데이타가 수정된 경우 GM, PM으로 변경한다.
		            		for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
		                		// Proposal단계이고 src_info_cd가 PC(Previous Contract)인 경우, 수정되면 PM(Previous Contract Modification)으로 바꿔준다.
		                		if (sheetObjects[a].RowStatus(i) == "U"
		                				&& sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
		    	        				&& sheetObjects[a].CellValue(i, "src_info_cd") == "PC") {
		                			sheetObjects[a].CellValue(i, "src_info_cd") = "PM";
		                			sheetObjects[a].CellValue(i, "src_info_nm") = "Prev. RFA (M)";
		                		}
		            		}
		            	}
		            	
		                var sParam = "";
		                
		                // Route & Summary
		                var sParamSheet3 = sheetObjects[2].GetSaveString();
		                if (sParamSheet3 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
		                }
		                // Rate
		                var sParamSheet4= sheetObjects[3].GetSaveString();
		                if (sParamSheet4 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
		                }
		                // Charge Term (Conversion)
		                var sParamSheet5= sheetObjects[4].GetSaveString();
		                if (sParamSheet5 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
		                }
		                // Origin
		                var sParamSheet7 = sheetObjects[6].GetSaveString();
		                if (sParamSheet7 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
		                }
		                // Origin via.
		                if(sheetObjects[7].RowCount != 0) {
		                	if(sheetObjects[7].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[7].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[7].RowDelete(1, false);
		                	} else {
		                		var sParamSheet8 = sheetObjects[7].GetSaveString();
		                		if (sParamSheet8 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
		                		}
		                	}
		                }
		                // Dest via.
		                if(sheetObjects[8].RowCount != 0) {
		                	if(sheetObjects[8].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[8].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[8].RowDelete(1, false);
		                	} else {
		                		var sParamSheet9 = sheetObjects[8].GetSaveString();
		                		if (sParamSheet9 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
		                		}
		                	}
		                }
		                // Dest
		                var sParamSheet10 = sheetObjects[9].GetSaveString();
		                if (sParamSheet10 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet10, "sheet10_");
		                }

		                // Route & Summary의 APP Note Conversion
		                var sParamSheet22 = sheetObjects[2].GetSaveString();
		                if(sParamSheet22 != "") {
		 					// 신규 등록 시 Note Content가 없을 경우 생성 && 전체 삭제인 경우는 생성하지 않는다.
		 					if(sheetObjects[11].RowCount == 0 && sheetObjects[2].RowCount != sheetObjects[2].RowCount("D")) {
		 						doActionIBSheet(sheetObjects[11],document.form,IBINSERT);
		 					}
		 					// note_conv_seq 없을 경우
		                	if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "note_conv_seq") == "") {
		                		var seq = 1;
		                		if(sheetObjects[4].RowCount > 0) { seq = parseInt(ComPriGetMax(sheetObjects[4], "note_conv_seq")) + 1; }
		                		
		                		sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "note_conv_seq") = seq;
		                	}
		                	// Duration
		                	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "eff_dt") = formObj.eff_dt.value;
		                	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "exp_dt") = formObj.ctrt_exp_dt.value;
		                	sParamSheet22 = sheetObjects[2].GetSaveString();
		                	
		                	sParam += "&" + ComPriSetPrifix(sParamSheet22, "sheet22_");
		                }
		                
		                // Route Note
		                var sParamSheet12 = sheetObjects[11].GetSaveString();
		                if (sParamSheet12 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet12, "sheet12_");
		                }
		                
		                if (!supressConfirm && !ComPriConfirmSave()) {
		                    return false;
		                }
		                
		                saveCurRowPos();
		                formObj.f_cmd.value = MULTI02;
		                
		                var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", FormQueryString(formObj) + sParam);
		                sheetObjects[4].LoadSaveXml(sXml);
		                sheetObjects[11].LoadSaveXml(sXml);
		                sheetObjects[9].LoadSaveXml(sXml);
		                sheetObjects[8].LoadSaveXml(sXml);
		                sheetObjects[7].LoadSaveXml(sXml);
		                sheetObjects[6].LoadSaveXml(sXml);
		                sheetObjects[3].LoadSaveXml(sXml);
		                sheetObjects[2].LoadSaveXml(sXml);
		                
		                if (sheetObjects[2].IsDataModified
		                        || sheetObjects[3].IsDataModified
		                        || sheetObjects[6].IsDataModified
		                        || sheetObjects[7].IsDataModified
		                        || sheetObjects[8].IsDataModified
		                        || sheetObjects[9].IsDataModified
		                        || sheetObjects[11].IsDataModified
		                        || sheetObjects[4].IsDataModified) {
		                    return false;
		                } else {
		                	restylingPagePostTr(true);
		                    ComPriSaveCompleted();
		                    doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
		                    return true;
		                }
	                }
		            return true;
		            
	        		ComOpenWait(false); //->waiting->End
	 				break;
	 				
	 			case IBINSERT: // Row Add
	                var formObj = document.form;
	                if (!validateForm(sheetObj, document.form, sAction)) {
	 					return false;
	 				}
	 				
	 				// Route & Summary
	 				if (sheetObj.id == "sheet3") {
	 					// RowAdd시 Row가 이동하므로 doRowChange함수를 이용한다.
	 					var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
	 					if (idx < 0) {
	 						return false;
	 					}

	 					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
	 					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
	 					sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	 					sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	 					sheetObj.CellValue2(idx, "cmdt_hdr_seq") = "1";
	 					if(sheetObj.RowCount == 0) {
	 						sheetObj.CellValue2(idx, "rout_seq") = 1;
	 					} else {
	 						sheetObj.CellValue2(idx, "rout_seq") = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	 					}
	 					
	 					// DB에서 저장할것이지만 임의로 route_seq와 동일한 번호로 보여준다.
	 					sheetObj.CellValue2(idx, "mst_rout_id") = sheetObj.CellValue(idx, "rout_seq");
	 					
	 					sheetObj.CellValue2(idx, "nd_cnt") = 1;
	 					sheetObj.CellValue2(idx, "na_cnt") = 1;
	 					
	 					for (var i = 3; i < sheetObjects.length; i++) {
	 						if (i == 5) {	// hidden. Service Scope 제외
	 							continue;
	 						}
	 						sheetObjects[i].RemoveAll();
	 					}
	 					formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
	 					
	 					// Term값 저장을 위해 Origin과 Dest의 Hidden Sheet에 Row 생성
	 					editRoutePntNViaSheet(sheetObjects[6], "P", "O", "", "", "Insert");
	 					editRoutePntNViaSheet(sheetObjects[9], "P", "D", "", "", "Insert");
	 					
//	 					sheet3_OnPopupClick(sheetObj, idx, 8);
	 					
	 				/** Rate **/
	 				} else if (sheetObj.id == "sheet4") {
	 					var idx = sheetObj.DataInsert();
		                
		                sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
		                sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
		                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
		                sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
		                sheetObj.CellValue(idx, "rout_seq") = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "rout_seq");
		                sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;
		                sheetObj.CellValue(idx, "prop_frt_rt_amt") = 0.00;
		                
		                sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
		                sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
		                sheetObj.CellValue(idx, "src_info_cd") = "NW";
		                sheetObj.CellValue(idx, "src_info_nm") = "New";
		                sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
		                sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
		                sheetObj.CellValue(idx, "exp_dt") = formObj.ctrt_exp_dt.value;
		                
		                setSheet4Style(sheetObj, idx);
		                
		                sheetObj.SelectCell(idx, "rat_ut_cd", false);
		                
					/** Charge Term (Conversion) **/
	 				} else if (sheetObj.id == "sheet5") {
	 					
	 					// Note Content가 없을 경우 생성
	 					if(sheetObjects[11].RowCount == 0) {
	 						doActionIBSheet(sheetObjects[11],document.form,IBINSERT);
	 					}
	 					
	 					// Note Conversion 생성
	 					var idx = sheetObj.DataInsert();
	 					sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;
	 					sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
	 					sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	 					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
	 					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
	 					sheetObj.CellValue2(idx, "note_conv_mapg_id") = sheetObjects[11].CellValue(1,"note_conv_mapg_id");
	 					sheetObj.CellValue2(idx, "note_conv_tp_cd") = "R"; // Route Note
	 					sheetObj.CellValue2(idx, "rt_appl_tp_cd") = ""; // Application
	 					sheetObj.CellValue2(idx, "note_conv_seq") = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;	
	 					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
	 					
		                sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
		                sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
		                sheetObj.CellValue(idx, "src_info_cd") = "NW";
		                sheetObj.CellValue(idx, "src_info_nm") = "New";
		                sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	 								
	 					sheetObj.Editable = true;
	 					
	 					//Code 에 Default 값이 존재할경우 적용
	 					noteConvDefaultColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
	 					//Editable를 세팅한다.
	 					noteConvDisableColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
	 					
	 					/** sheet3의 Rnote(Hidden) **/
	 				} else if (sheetObj.id == "sheet12") {
	 					
	 					// Note Content가 없을 경우 생성
	 					if(sheetObj.RowCount == 0) {
	 						// get NOTE Convesoin Mapping ID
	 						formObj.f_cmd.value = COMMAND38;
	 						var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	 						var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
	 						if (sysGuid == null || sysGuid.length < 16) {
	 							return false;
	 						} else {
	 							formObj.note_conv_mapg_id.value = sysGuid;
	 						}
	 						
	 						var idx = sheetObj.DataInsert();
	 						
	 						sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
	 						sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
	 						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	 						sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
	 						sheetObj.CellValue(idx, "rout_seq") = formObj.rout_seq.value;
	 						sheetObj.CellValue(idx, "rout_note_seq") = 1;
	 						sheetObj.CellValue(idx, "note_ctnt") = "conversion";
	 						sheetObj.CellValue(idx, "note_conv_mapg_id_chk") = "1";
	 						sheetObj.CellValue(idx, "note_conv_mapg_id") = sysGuid;
	 						
	 						sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
	 						sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
	 						sheetObj.CellValue(idx, "src_info_cd") = "NW";
	 						sheetObj.CellValue(idx, "src_info_nm") = "New";
	 						sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
	 						sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	 						sheetObj.CellValue(idx, "exp_dt") = formObj.ctrt_exp_dt.value;
	 					}
	 				}
	 				
	 				break;

	 			case IBDELETE: // Delete
	 				if (!validateForm(sheetObj, document.form, sAction)) {
	 					return false;
	 				}
	 				if (sheetObj.CheckedRows("chk") <= 0) {
	 					sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "1";
	 				}

	 				var sCheckedRows = sheetObj.FindCheckedRow("chk");
	 				var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	 	        	
	 	        	// Route & Summary
	 	        	if (sheetObj.id == "sheet3") {
	 	        		// sheet4, Sheet7 ~ Sheet12을 처리
	 					if (sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
	 		        		for (var a = 3; a <= 11; a++) {
	 							if (a == 5 || a == 10) { // hidden. Service Scope & Direct Call(Hidden)은 제외. 
	 								continue;
	 							}
	 		        			// 기존 Amend를 모두 Cancel한다.
	 		        			if (formObj.amdt_seq.value != "0") {
	 			                	for (var i = sheetObjects[a].HeaderRows; sheetObjects[a].RowCount > 0 && i <= sheetObjects[a].LastRow; i++) {
	 			                		if (sheetObjects[a].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	 			                			sheetObjects[a].SelectRow = i + 1;
	 			                			
	 			                        	var prevIdx = doRowAmendCancel(sheetObjects[a]);

		 		                       		// Rate
	 			                        	if (a == 3) {
	 			                        		setSheet4Style(sheetObjects[a], prevIdx);
	 			                        	}
		 		                       		// Conversion
		 		                       		if (a == 4) {
		 		                    			setSheet5Style(sheetObjects[a], prevIdx);
		 		                       		}
	 			                		}
	 			                	}
	 		        			}
	 		                	// 새로 Amend Delete 또는 Delete한다.
	 		        			// 하위에 sheet 정보 모두 click 해서 삭제 해야 한다.
	 		                	for (var i = sheetObjects[a].LastRow; sheetObjects[a].RowCount > 0 && i >= sheetObjects[a].HeaderRows; i--) {
	 		                    	if (sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	 		                    		sheetObjects[a].SelectRow = i;
	 		                    		sheetObjects[a].CellValue2(i, "chk") = "0";
	 		                       		var idx = doRowAmend(sheetObjects[a], "AD");
	 		                       		
	 		                       		// Rate
	 		                       		if (a == 3) {
	 		                    			setSheet4Style(sheetObjects[a], idx - 1);
	 		                    			setSheet4Style(sheetObjects[a], idx);
	 		                       		}
	 		                       		// Conversion
	 		                       		if (a == 4) {
	 		                    			setSheet5Style(sheetObjects[a], idx - 1);
	 		                    			setSheet5Style(sheetObjects[a], idx);
	 		                       		}
	 		                       		
//	 		                			sheetObjects[a].RowStatus(idx) = "R";
	 		                    	} else if (sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	 		                    			&& (sheetObjects[a].CellValue(i, "src_info_cd") == "NW"
	 		                    				|| sheetObjects[a].CellValue(i, "src_info_cd") == "GC"
	 		                    				|| sheetObjects[a].CellValue(i, "src_info_cd") == "GM"
	 		                    				|| sheetObjects[a].CellValue(i, "src_info_cd") == "PC"
	 		                    				|| sheetObjects[a].CellValue(i, "src_info_cd") == "PM")) {
	 		                    		// 그냥 Delete해도 관계가 없나?
	 				                    sheetObjects[a].RowDelete(i, false);
	 		                    	}
	 		                	}
	 		        		}
	 	        		}
	 					
	 					// Sheet3를 Delete 처리
	 					for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
	 						if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	 							sheetObj.CellValue2(arrCheckedRows[i], "chk") = 0;
	 							setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
	 						}
	 					}
	 					deleteRowCheck(sheetObj, "chk");
	 	        		
	 	    		// Rate
	 	        	} else if (sheetObj.id == "sheet4") {
	 					for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
	 						if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	 							sheetObj.SelectRow = arrCheckedRows[i];
	 							sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";

	 							var idx = doRowAmend(sheetObj, "AD");
	 							setSheet4Style(sheetObj, idx - 1);
	 							setSheet4Style(sheetObj, idx);
	 						}
	 					}
	 					deleteRowCheck(sheetObj, "chk");
	 	        		
	 	        	// Charge Term (Conversion)
	 	        	} else if (sheetObj.id == "sheet5") {
	 					for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
	 						if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	 							sheetObj.SelectRow = arrCheckedRows[i];
	 							sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";

	 							var idx = doRowAmend(sheetObj, "AD");
	 							setSheet5Style(sheetObj, idx - 1);
	 							setSheet5Style(sheetObj, idx);
	 						}
	 					}
	 					deleteRowCheck(sheetObj, "chk");
	 	        	}
	 	        	
	 				break;
	 				
	 				/** Rate start **/
		        case IBSEARCH_ASYNC03: // Accept All
		        	if (formObj.prop_no.value != "" && formObj.amdt_seq.value != "" && formObj.svc_scp_cd.value != "") {
		        		ComOpenWait(true);
		        		
		        		if (!ComShowCodeConfirm("PRI01035")) {
		        			return false;
		        		}
		        		
		        		formObj.f_cmd.value = MULTI06;
		        		var sParam = FormQueryString(formObj);

			            // 재조회를 위해 Sheet1,2,3의 현재 선택된 Row를 기억한다.
			            saveCurRowPos();
			            
		        		// Rate
		        		var sParamSheet1 = sheetObjects[3].GetSaveString(true);
		        		if (sParamSheet1 != "") {
		        			sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
		        		}
		        		
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObjects[3].LoadSaveXml(sXml);
		        		ComShowCodeMessage("PRI00108");
		        		
		        		// 재조회
		        		reloadPagePostTr();
		        		
		        		buttonControl();
		        		ComOpenWait(false);
		        		
		        	}
		        	
		            break;
		            
		        case IBSEARCH_ASYNC04: //  Accept Cancel all
		        	if (!validateForm(sheetObj,document.form,sAction)) {
		        		return false;
		        	}
		        	
		        	if (!ComShowCodeConfirm("PRI01010")) {
		        		return false;
		        	}
		            
		        	formObj.f_cmd.value = MULTI07;
		            var sParam = FormQueryString(formObj);
		            
		            // 재조회를 위해 Sheet1,2,3의 현재 선택된 Row를 기억한다.
		            saveCurRowPos();

		            var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		            ComShowCodeMessage("PRI00109");
		            
		            // 재조회
		        	reloadPagePostTr();
		        	
		        	buttonControl();
		        	
		            break;
		            
		        case IBSEARCH_ASYNC11: // Amend
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
	            	
		            var checkedCnt = sheetObj.CheckedRows("chk");
		        	if (checkedCnt == 1) {
		        		var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
		        		sheetObj.SelectRow = curRow;
		        		sheetObj.CellValue2(curRow, "chk") = "0";
		        	}
		        	
		        	// Rate
		        	if(sheetObj.id == "sheet4") {
		        		// Amend 처리하고 해당 Row들에 대해 색상/취소선등을 처리한다.
		        		var idx = doRowAmend(sheetObj, "AM");
		        		setSheet4Style(sheetObj, idx - 1);
		        		setSheet4Style(sheetObj, idx);
		        		
		        		// Amend시 클리어되어야 할 항목들
		        		sheetObj.CellValue(idx, "prop_frt_rt_amt") = 0.00;
		        		sheetObj.CellValue(idx, "fnl_frt_rt_amt") = "";
		        		sheetObj.CellValue(idx, "prs_scg_amt") = "";
		        		sheetObj.CellValue(idx, "prs_respb_cm_uc_amt") = "";
		        		sheetObj.CellValue(idx, "prs_respb_opfit_uc_amt") = "";
		        		sheetObj.CellValue(idx, "prs_respb_cmpb_amt") = "";
		        		sheetObj.CellValue(idx, "prs_gid_cmpb_amt") = "";
		        		sheetObj.CellValue(idx, "prs_respb_opb_amt") = "";
		        		sheetObj.CellValue(idx, "diff") = "";
		        		sheetObj.CellValue(idx, "prs_pfit_cm_uc_amt") = "";
		        		sheetObj.CellValue(idx, "prs_pfit_cmpb_amt") = "";
		        		sheetObj.CellValue(idx, "prs_upd_dt") = "";
		        		sheetObj.CellValue(idx, "gri_appl_tp_cd") = "";
		        		sheetObj.CellValue(idx, "gri_appl_amt") = "";
		        		sheetObj.CellValue(idx, "acpt_usr_id") = "";
		        		
		        	// Conversion
		        	} else if(sheetObj.id == "sheet5") {
		        		// Amend 처리하고 해당 Row들에 대해 색상/취소선등을 처리한다.
		        		var idx = doRowAmend(sheetObj, "AM");
		        		setSheet5Style(sheetObj, idx - 1);
		        		setSheet5Style(sheetObj, idx);
		        		
		        		// Amend 시 클리어되어야 할 항목들 있나?
		        	}
		            
		            break;
		            
		        case IBSEARCH_ASYNC12: // Amend Cancel
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            var checkedCnt = sheetObj.CheckedRows("chk");
		        	if (checkedCnt == 1) {
		        		var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
		        		sheetObj.SelectRow = curRow;
		        		sheetObj.CellValue2(curRow, "chk") = "0";
		        	}
		        	
		        	// Amend Cancel 처리하고 해당 Row들에 대해 색상/취소선등을 처리한다.
		        	var prevIdx = doRowAmendCancel(sheetObj);

		        	// Rate
		        	if(sheetObj.id == "sheet4") {
		        		setSheet4Style(sheetObj, prevIdx);
		        	// Conversion
		        	} else if(sheetObj.id == "sheet5") {
		        		setSheet5Style(sheetObj, prevIdx);
		        	}
		            
		            break;
		            
		        case IBSEARCH_ASYNC13: // Accept
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            
		            if (!ComShowCodeConfirm("PRI00008")) {
		            	return false;
		            }
		            
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}
		           
		            var sCheckedRows = sheetObj.FindCheckedRow("chk");
		            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
		        	for (var i = 0; i < arrCheckedRows.length; i++) {
		        		// Rate
		        		if(sheetObj.id == "sheet4") {
		        			sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "prop_frt_rt_amt");
		        		}
		        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "A";
		        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Accepted";
		        	}
		            
		        	// Check된 항목에 대해서만 Query String 을 생성한다.
		        	var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
		        	if (sSheetParam == "") {
		        		return false;
		        	}
		        	
		        	// Rate
		        	if(sheetObj.id == "sheet4") {
		        		formObj.f_cmd.value = MODIFY01;
		        		var sParam = FormQueryString(formObj) + "&" + sSheetParam;
		        		
		        		saveCurRowPos();
		        		
		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");
		        		
		        		restylingPagePostTr();
		        		setSheet4Style(sheetObj, -1);
		        		sheetObj.CheckAll2("chk") = 0;
		        		
	        		// Conversion
		        	} else if(sheetObj.id == "sheet5") {
		        		formObj.f_cmd.value = MODIFY03;
		        		var sParam = FormQueryString(formObj) + "&" + sSheetParam;
		        		
		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");

		        		restylingPagePostTr();
		        		sheetObj.CheckAll2("chk") = 0;
		        		setSheet5Style(sheetObj, -1);
		        		
		        	// Route & Summary
		        	} else if(sheetObj.id == "sheet3") {
		        		formObj.f_cmd.value = MODIFY05;
		        		var sParam = FormQueryString(formObj);
		        		
		                // Origin
		        		if(sheetObjects[6].RowCount != 0) {
		        			sheetObjects[6].CellValue2(1, "ibflag") = "U";
		        			var sParamSheet7 = sheetObjects[6].GetSaveString();
		        			sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
		        		}
		                // Origin via.
		                if(sheetObjects[7].RowCount != 0) {
		                	if(sheetObjects[7].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[7].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[7].RowDelete(1, false);
		                	} else {
		                		sheetObjects[7].CellValue2(1, "ibflag") = "U";
		                		var sParamSheet8 = sheetObjects[7].GetSaveString();
		                		if (sParamSheet8 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
		                		}
		                	}
		                }
		                // Dest via.
		                if(sheetObjects[8].RowCount != 0) {
		                	if(sheetObjects[8].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[8].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[8].RowDelete(1, false);
		                	} else {
		                		sheetObjects[8].CellValue2(1, "ibflag") = "U";
		                		var sParamSheet9 = sheetObjects[8].GetSaveString();
		                		if (sParamSheet9 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
		                		}
		                	}
		                }
		                // Dest
		        		if(sheetObjects[9].RowCount != 0) {
		        			sheetObjects[9].CellValue2(1, "ibflag") = "U";
		        			var sParamSheet10 = sheetObjects[9].GetSaveString();
		        			sParam += "&" + ComPriSetPrifix(sParamSheet10, "sheet10_");
		        		}
		        		
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");
		        		
		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		restylingPagePostTr();
		        		sheetObj.CheckAll2("chk") = 0;
		        	}
		            
		            ComShowCodeMessage("PRI00108");
		            break;
		            
		        case IBSEARCH_ASYNC14: // Accept Cancel
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            
		            if (!ComShowCodeConfirm("PRI00009")) {
		            	return false;
		            }
		            
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}
		            
		            var sCheckedRows = sheetObj.FindCheckedRow("chk");
		            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
		        	for (var i = 0; i < arrCheckedRows.length; i++) {
		        		// Rate
		        		if(sheetObj.id == "sheet4") {
		        			sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = "";
		        		}
		        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "I";
		        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Initial";
		        	}
		        	
		        	// Check된 항목에 대해서만 Query String 을 생성한다.
		        	var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
		        	if (sSheetParam == "") {
		        		return false;
		        	}
		        	
		        	// Rate
		        	if(sheetObj.id == "sheet4") {
		        		formObj.f_cmd.value = MODIFY02;
		        		var sParam = FormQueryString(formObj) + "&" + sSheetParam;
		        		
		        		saveCurRowPos();
		        		
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");
		        		
		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		restylingPagePostTr();
		        		setSheet4Style(sheetObj, -1);
		        		sheetObj.CheckAll2("chk") = 0;
		        		
	        		// Conversion
		        	} else if(sheetObj.id == "sheet5") {
		        		formObj.f_cmd.value = MODIFY04;
		        		var sParam = FormQueryString(formObj) + "&" + sSheetParam;
		        		
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");
		        		
		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		restylingPagePostTr();
		        		setSheet5Style(sheetObj, -1);
		        		sheetObj.CheckAll2("chk") = 0;

		        	// Route & Summary
		        	} else if(sheetObj.id == "sheet3") {
		        		formObj.f_cmd.value = MODIFY06;
		        		var sParam = FormQueryString(formObj);
		        		
		                // Origin
		        		if(sheetObjects[6].RowCount != 0) {
		        			sheetObjects[6].CellValue2(1, "ibflag") = "U";
		        			var sParamSheet7 = sheetObjects[6].GetSaveString();
		        			sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
		        		}
		                // Origin via.
		                if(sheetObjects[7].RowCount != 0) {
		                	if(sheetObjects[7].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[7].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[7].RowDelete(1, false);
		                	} else {
		                		sheetObjects[7].CellValue2(1, "ibflag") = "U";
		                		var sParamSheet8 = sheetObjects[7].GetSaveString();
		                		if (sParamSheet8 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
		                		}
		                	}
		                }
		                // Dest via.
		                if(sheetObjects[8].RowCount != 0) {
		                	if(sheetObjects[8].CellValue(1, "rout_via_port_tp_cd") == "" || sheetObjects[8].CellValue(1, "rout_via_port_def_cd") == "") {
		                		sheetObjects[8].RowDelete(1, false);
		                	} else {
		                		sheetObjects[8].CellValue2(1, "ibflag") = "U";
		                		var sParamSheet9 = sheetObjects[8].GetSaveString();
		                		if (sParamSheet9 != "") {
		                			sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
		                		}
		                	}
		                }
		                // Dest
		        		if(sheetObjects[9].RowCount != 0) {
		        			sheetObjects[9].CellValue2(1, "ibflag") = "U";
		        			var sParamSheet10 = sheetObjects[9].GetSaveString();
		        			sParam += "&" + ComPriSetPrifix(sParamSheet10, "sheet10_");
		        		}
		        		
		        		var sXml = sheetObj.GetSaveXml("ESM_PRI_2203GS.do", sParam);
		        		sheetObj.LoadSaveXml(sXml, false, "chk");

		        		// 저장이 완료된 후, Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
		        		restylingPagePostTr();
		        		sheetObj.CheckAll2("chk") = 0;
		        	}
		            
		            ComShowCodeMessage("PRI00109");
		            
		            break;
		            
		            /** Rate end **/
		            
		        case IBCOPYROW:
	                var prevRoutSeq = sheetObj.CellValue(sheetObj.SelectRow, "rout_seq");
	                
	                var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	                
	                var newRoutSeq = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                sheetObj.CellValue(idx, "rout_seq") = newRoutSeq;
	                formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
	                
	                formObj.f_cmd.value = COMMAND38;
	                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	                var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
	                
	                var prevNoteConvMapgId = "";
	                
	                //sheetObjects[6,7,8,9,10,11] copy
	                for (var a = 6; a <= 11; a++) {
	                	if (sheetObjects[a].RowCount <= 0) {
	                		continue;
	                	}
	                    for (var i = sheetObjects[a].LastRow; i >= sheetObjects[a].HeaderRows && sheetObjects[a].RowCount > 0; i--) {
	                    	if (sheetObjects[a].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                    		sheetObjects[a].RowDelete(i, false);
	                    		continue;
	                    	}
	                    	if (sheetObjects[a].CellValue(i, "src_info_cd") == "AD") {
	                    		sheetObjects[a].RowDelete(i, false);
	                    		continue;
	                    	}
	                    	
	                        var colName = "";
	                        if (a == 6 || a == 9) {
	                            colName = "rout_pnt_seq";
	                        } else if (a == 7 || a == 8) {
	                            colName = "rout_via_seq";
	                        } else if (a == 11) {
	                            colName = "rout_note_seq";
	                            prevNoteConvMapgId = sheetObjects[a].CellValue(i, "note_conv_mapg_id");
	                            sheetObjects[a].CellValue(i, "note_conv_mapg_id") = sysGuid;
	                        }
	                        sheetObjects[a].CellValue(i, "rout_seq") = newRoutSeq;
	                        sheetObjects[a].CellValue(i, "mst_rout_id") = newRoutSeq;	// 
	                        if (colName != "") {
	                        	sheetObjects[a].CellValue(i, colName) = i;
	                        }
	                        sheetObjects[a].CellValue(i, "prc_prog_sts_cd") = "I";
	                        sheetObjects[a].CellValue(i, "prc_prog_sts_nm") = "Initial";
	                        sheetObjects[a].CellValue(i, "src_info_cd") = "NW";
	                        sheetObjects[a].CellValue(i, "src_info_nm") = "New";
	                        sheetObjects[a].CellValue(i, "eff_dt") = formObj.eff_dt.value;
	                        sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	                        sheetObjects[a].CellValue(i, "exp_dt") = formObj.exp_dt.value;
	                        
	                        sheetObjects[a].RowStatus(i) = "I";
	                    }
	                }
	                
	                // Route Note Conversion
	                for (var i = sheetObjects[4].LastRow; i >= sheetObjects[4].HeaderRows && sheetObjects[4].RowCount > 0; i--) {
	                	if (sheetObjects[2].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                	if (sheetObjects[2].CellValue(i, "src_info_cd") == "AD") {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                	
	                	sheetObjects[4].CellValue(i, "note_conv_mapg_id") = sysGuid;
	                	sheetObjects[4].CellValue(i, "note_conv_seq") = i;
	                	sheetObjects[4].CellValue(i, "prc_prog_sts_cd") = "I";
	                	sheetObjects[4].CellValue(i, "prc_prog_sts_nm") = "Initial";
	                	sheetObjects[4].CellValue(i, "src_info_cd") = "NW";
	                	sheetObjects[4].CellValue(i, "src_info_nm") = "New";
	                	sheetObjects[4].CellValue(i, "eff_dt") = formObj.eff_dt.value;
	                	sheetObjects[4].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	                	sheetObjects[4].CellValue(i, "exp_dt") = formObj.exp_dt.value;
	                	
	                	sheetObjects[4].RowStatus(i) = "I";
	                }
	                
	                setSheet4Style(sheetObjects[4], -1);
	                
	                for (var i = sheetObjects[2].LastRow; i >= sheetObjects[2].HeaderRows && sheetObjects[2].RowCount > 0; i--) {
	                	if (sheetObjects[2].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                	if (sheetObjects[2].CellValue(i, "src_info_cd") == "AD") {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                	
	                    sheetObjects[2].CellValue(i, "rout_seq") = newRoutSeq;
	                    sheetObjects[2].CellValue(i, "rt_seq") = i;
	                    sheetObjects[2].CellValue(i, "prc_prog_sts_cd") = "I";
	                    sheetObjects[2].CellValue(i, "prc_prog_sts_nm") = "Initial";
	                    sheetObjects[2].CellValue(i, "src_info_cd") = "NW";
	                    sheetObjects[2].CellValue(i, "src_info_nm") = "New";
	                    sheetObjects[2].CellValue(i, "eff_dt") = formObj.eff_dt.value;
	                    sheetObjects[2].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	                    sheetObjects[2].CellValue(i, "exp_dt") = formObj.exp_dt.value;
	                    
	                    // Row Copy시 Clear되어야하는 항목
	                    sheetObjects[2].CellValue(i, "coffr_frt_rt_amt") = "";
	                    sheetObjects[2].CellValue(i, "fnl_frt_rt_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_scg_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_respb_cm_uc_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_respb_opfit_uc_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_respb_cmpb_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_gid_cmpb_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_respb_opb_amt") = "";
	                    sheetObjects[2].CellValue(i, "diff") = "";
	                    sheetObjects[2].CellValue(i, "prs_pfit_cm_uc_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_pfit_cmpb_amt") = "";
	                    sheetObjects[2].CellValue(i, "prs_upd_dt") = "";
	                    sheetObjects[2].CellValue(i, "gri_appl_tp_cd") = "";
	                    sheetObjects[2].CellValue(i, "gri_appl_amt") = "";
	                    sheetObjects[2].CellValue(i, "acpt_usr_id") = "";
	                    
	                    sheetObjects[2].RowStatus(i) = "I";
	                }
	                
	                setSheet3Style(sheetObjects[2], -1);
		        	break;
			}
			
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC02 || sAction == IBDELETE || sAction == IBINSERT) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
	}
	
	/** 
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {String} sheetNo 필수, sheet의 ID
	 * @return 없음
	 */ 
	function initSheet(sheetObj,sheetNo) {
		
		var cnt = 0;
		sheetObj.WaitImageVisible = false;
		
		switch(sheetObj.id) {

        case "sheet1":
            with (sheetObj) {
        	
        	/////////////////////////////////////////////////// TODO 완료 후 삭제 ///////////////////////////////////////////////////
//			// 높이 설정
//			style.height = 100;
//			// 전체 너비 설정
//			SheetWidth = mainTable.clientWidth;
        	///////////////////////////////////////////////////// TODO 여기까지 삭제///////////////////////////////////////////////////////////
        	
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;         

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
                
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                
                var HeadTitle  = "|rfa_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_dt|prc_prog_sts_cd"                 
                HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
                HeadTitle += "|request user flag|approval user flag|all user flg|ctrt_eff_dt_ori|ctrt_exp_dt_ori"
                HeadTitle += "|prc_ctrt_cust_tp_nm|file_dt|prop_prpr_flg|createtype|prop_apro_staff|dur_dup_flg" 
                HeadTitle += "|act_cm|est_cm|cre_tp|copy_auth|upd_dt|rfa_ctrt_tp_cd|svc_scp_cd|req_usr_id|req_usr_nm|prop_usr_id|prop_usr_nm"
                var headCount = ComCountHeadTitle(HeadTitle);               
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);
   
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);    
                
                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_amdt_seq", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);                             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "n1st_cmnc_dt", false, "", dfDateYmd, 0, false, false);                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);                               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false); 
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);	// 삭제              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_dt", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "apro_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "all_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_nm", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "file_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dur_dup_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);  
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_tp", false, "", dfNone, 0, false, false);//이행데이터확인
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "copy_auth", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "upd_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_usr_nm", false, "", dfNone, 0, false, false);
                
                WaitImageVisible = false;
            }
            break;
            
		case "sheet2": // CMDT (화면표시)
			with (sheetObj) {
				// 높이 설정
				style.height = 100;
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
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.||Bullet No.|Commodity Type|Commodity|Commodity|prc_prog_sts_cd|prc_prog_sts_nm|src_info_cd|src_info_nm|eff_dt|exp_dt|n1st_cmnc_amdt_seq|acpt_usr_id|n1st_ord_ref|n2nd_ord_ref|fic_rt_tp_cd";
				var headCount = ComCountHeadTitle(HeadTitle);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq,	40,	daCenter,	true,	"seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "blet_dp_seq", true, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtPopupEdit,	100, daCenter, true, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData,			100, daCenter, true, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false,	"fic_rt_tp_cd", true,	"", dfNone, 0, false, false);	// G : CY Only, A : IHC

                ShowButtonImage = 2;
                ImageList(0) = "img/btns_search_off.gif";
                ImageList(1) = "img/btns_search.gif";
				AutoRowHeight = false;
			}
			break;
				
		case "sheet3": // Route & Summary
			with (sheetObj) {
			// 높이 설정
			style.height = 182;
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

			var HeadTitle1 = "|Sel.|Route\nID|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|R Term|O.Via|D.Via|Dest|D Term|";
			HeadTitle1 += "Direct\nCall|T/S\nPort|Lane|VVD|Prev Rate|Prev Rate|Prev Rate|Current Rate|Current Rate|Current Rate|Charge\nTerm|";
			HeadTitle1 += "Not Deleted Rows|Not Accepted Rows|Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|rout_seq_prop|note_conv_seq|eff_dt|exp_dt|mst_rfa_no";
				
			var HeadTitle2 = "|Sel.|Route\nID|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|R Term|O.Via|D.Via|Dest|D Term|";
			HeadTitle2 += "Direct\nCall|T/S\nPort|Lane|VVD|D2|D4|D5|D2|D4|D5|Charge\nTerm|";
			HeadTitle2 += "Not Deleted Rows|Not Accepted Rows|Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|rout_seq_prop|note_conv_seq|eff_dt|exp_dt|mst_rfa_no";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk");
            InitDataProperty(0, cnt++ , dtData,			50,	daCenter,  true,	"mst_rout_id",		false,	"",	dfNone, 			0,		false,	false);
//			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtPopupEdit,		70,	daLeft,		true,	"org_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++ ,dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_ori",	true,	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit,		70,	daLeft,		true,	"org_rout_via_port_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopupEdit,		70,	daLeft,		true,	"dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopupEdit,		70,	daLeft,		true,	"dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtCombo,			60,	daCenter,	true,	"rcv_de_term_cd_dest",	true,	"", dfNone, 0, true, true);
			
            InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtPopupEdit,		70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
            InitDataProperty(0, cnt++ , dtPopupEdit,  	50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
            InitDataProperty(0, cnt++ , dtPopupEdit,		85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
            
            // Summary
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d2",		false,	"", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d4",		false,	"", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"prev_d5",		false,	"", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d2",		false,	"", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d4",		false,	"", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,	 40,	daCenter,	 true,		"curr_d5",		false,	"", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++ , dtData,	 50, daLeft, true,	 "note_conv_chg_cd",				false, "", dfNone, 0, false, false); // Charge Term. mouse over tool tip
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt",									false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt",									false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ac_cnt",									false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_dp_seq",						false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq",			true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "org_n1st_cmnc_amdt_seq",	true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq_prop",						false, "", dfNone, 0, false, false);
			
			// App note conversion용 data
			InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
            InitDataProperty(0, cnt++ , dtHidden,			85,	daCenter,  true,	"eff_dt",				false,	"",	dfDateYmd,		0,		false,	false);
            InitDataProperty(0, cnt++ , dtHidden,			85,	daCenter,  true,	"exp_dt",				false,	"",	dfDateYmd, 		0,		false,	false);
            InitDataProperty(0, cnt++ , dtHidden,			85,	daCenter,  true,	"mst_rfa_no",		false,	"",	dfNone,			0,		false,	false);
			
			InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "1234567890");
			
			InitDataCombo(0, "rcv_de_term_cd_ori", termOrgCdText, termOrgCdValue);
			InitDataCombo(0, "rcv_de_term_cd_dest", termDestCdText, termDestCdValue);
			
			InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
			InitDataValid(0, "bkg_ts_port_def_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "bkg_slan_cd", 			vtEngUpOther, "1234567890");
			InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
			
			SetMergeCell(1, 13, 0, 3); // Row : 1 Col : 13에서 시작해서 세로로 0개 가로로 3개를 머지하겠다. 
			
            // 설정값 ScrollBar 
//          0  둘 다 없음 
//          1  수평스크롤만 허용 
//          2  수직스크롤만 허용 
//          3  모두 허용, Default 
//			ScrollBar = 1;
			
			ToolTipOption = "balloon:true;width:1000;icon:1;title:Route Note";
			Ellipsis = true;
			ShowButtonImage = 2;
//			AutoRowHeight = false;
			
		}
		break;
			
		case "sheet4": // Rate
			with (sheetObj) {
				// 높이 설정
				style.height = 142;
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
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Amount|Final|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|Update|Update|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
				var headCount = ComCountHeadTitle(HeadTitle);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,	30, daCenter,	false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck,	40, daCenter,	false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq,			40, daCenter,	true, "seq");
				InitDataProperty(0, cnt++, dtHidden,			90, daLeft,		false, "prop_no", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,			40, daLeft,		false, "amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,			90, daLeft,		false, "svc_scp_cd", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,			90, daLeft,		false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,			90, daLeft,		false, "rout_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,			90, daLeft,		false, "rt_seq", true, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtCombo,	70,	daCenter,	false, "rat_ut_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo,	70,	daCenter,	false, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo,	70,	daCenter,	false, "curr_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData,		100, daRight,	false, "prop_frt_rt_amt", true, "", dfNullFloat, 2, true, true, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_respb_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_respb_opfit_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_respb_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_gid_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_respb_opb_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "diff", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_pfit_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_pfit_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
				InitDataProperty(0, cnt++, dtHidden,	100,	daRight,	false, "prs_upd_dt", false, "", dfDateYmd, 0, false, false);

				InitDataProperty(0, cnt++, dtData,		100, daCenter,	true,	"eff_dt",									false,	"",	dfDateYmd,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden,	70,	daCenter,	false,	"next_n1st_cmnc_amdt_seq",	false,	"",	dfDateYmd,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData,		100, daCenter,	true,	"exp_dt",     								false,	"",	dfDateYmd,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	false,	"src_info_cd",							false,	"",	dfNone,		0, false,	false);
				InitDataProperty(0, cnt++, dtData,		110,	daCenter,	false,	"src_info_nm",							false,	"",	dfNone,		0, false,	false);
				InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	false,	"prc_prog_sts_cd",					false,	"",	dfNone,		0, false,	false);
				InitDataProperty(0, cnt++, dtData,		110,	daCenter,	false,	"prc_prog_sts_nm",					false,	"",	dfNone,		0, false,	false);
				
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "gri_appl_amt", false, "", dfNullFloat, 2, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);

				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue, "D2", "D2", 0, "", "", ratUtCdText);
				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue, "DR");
				InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");

				Ellipsis = true;
				ShowButtonImage = 2;
//				CountPosition = 0;
//				FrozenCols = 15;
			}
			break;
			

        case "sheet5": // Charge Term (Conversion)
	 		with (sheetObj) {
	            // 높이 설정
	            style.height = 170; 
	            
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 100);
	
	            var HeadTitle = "|Sel.|Seq.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|Direct\nCall|IMDG\nClass" +
                     	"|T/S\nPort|Lane|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Bar Type" +
                     	"|next_n1st_cmnc_amdt_seq|src_info_cd|Source|prc_prog_sts_cd|Status|n1st_cmnc_amdt_seq" +
	            		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
	            var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 6, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, true, true, true, false,false);
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
                InitDataProperty(0, cnt++ , dtDummyCheck,	40,   daCenter,  true,	"chk");
				InitDataProperty(0, cnt++, dtDataSeq,			40, daCenter,	true, "seq");
                InitDataProperty(0, cnt++ , dtComboEdit,		50,   daCenter,  true,	"chg_rule_def_cd",		true,	"",	dfNone, 			0,		true,	true);
                InitDataProperty(0, cnt++ , dtData,				85,	daCenter,  true,	"eff_dt",						false,	"",	dfDateYmd,		0,		false,	false);
                InitDataProperty(0, cnt++ , dtData,				85,	daCenter,  true,	"exp_dt",						false,	"",	dfDateYmd, 		0,		false,	false);
                InitDataProperty(0, cnt++ , dtCombo,    		75,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,		true,	true);
                InitDataProperty(0, cnt++ , dtCombo,  	    	40,   daCenter,  true,	"curr_cd",      				false,	"",	dfNone, 			0,		true,	true);
                InitDataProperty(0, cnt++ , dtCombo,        	35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,		true,	true);
                InitDataProperty(0, cnt++ , dtData,         		75,   daRight,    true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   	2,		true,	true,	9);
                InitDataProperty(0, cnt++ , dtCombo,      		75,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,			0,		true,	true);
                
                InitDataProperty(0, cnt++ , dtCombo,   		35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,  			35,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,   	    40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
                InitDataProperty(0, cnt++ , dtPopupEdit,		60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtPopupEdit,  	50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
                InitDataProperty(0, cnt++ , dtPopupEdit,		85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
                InitDataProperty(0, cnt++ , dtHidden,			35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,    		65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtHidden,    		65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
                InitDataProperty(0, cnt++ , dtHidden,    		65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
                
                InitDataProperty(0, cnt++ , dtHidden,    		65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtHidden,			150,  daCenter, true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtPopupEdit,    	80,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true,	7);
                InitDataProperty(0, cnt++ , dtHidden,    		70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
                InitDataProperty(0, cnt++ , dtData,  				70,   daRight,    true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtData,  				70,   daRight,    true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtHidden,   	 	55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
                
                InitDataProperty(0, cnt++, dtHidden,			70,	daCenter,	false,	"next_n1st_cmnc_amdt_seq",	false,	"",	dfDateYmd,	0,	false,	false);
                InitDataProperty(0, cnt++, dtHidden,			90,	daCenter,	false,	"src_info_cd",							false,	"",	dfNone,		0, false,	false);
                InitDataProperty(0, cnt++, dtData,				110,	daCenter,	false,	"src_info_nm",							false,	"",	dfNone,		0, false,	false);
                InitDataProperty(0, cnt++, dtHidden,			90,	daCenter,	false,	"prc_prog_sts_cd",					false,	"",	dfNone,		0, false,	false);
                InitDataProperty(0, cnt++, dtData,				110,	daCenter,	false,	"prc_prog_sts_nm",					false,	"",	dfNone,		0, false,	false);
                InitDataProperty(0, cnt++, dtHidden,			90,	daCenter, false,	"n1st_cmnc_amdt_seq",			true,	"",	dfNone,		0, false,	false);
                
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");    
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_cmdt_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_tp_cd");
	            
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_tp_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_vsl_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_voy_no");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_dir_cd");
	            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");

                /////////////////////////////////////////////////////////////////////////////////////////
                //STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_cnt_cd");
                  
                // Subjects는 APP Conversion에서만 보여짐.
                InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText + "|Subject", rtApplTpCdComboValue + "|S", "", "", 0, "", "", rtApplTpCdComboText);
                InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
                InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);
                InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
                InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
                
                InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
	            InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");										
                
	            InitDataValid(0, "chg_rule_def_cd", 			vtEngUpOnly);
	            InitDataValid(0, "bkg_imdg_clss_cd", 		vtNumericOther, "."); 
				InitDataValid(0, "bkg_cmdt_def_cd", 		vtEngUpOther, "1234567890");
				
				InitDataValid(0, "bkg_ts_port_def_cd", vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_slan_cd", 			vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_yd_cd", 				vtEngUpOther, "1234567890"); // 영문대문자와 숫자만 입력
				 
		 		ShowButtonImage = 2;	// Edit 가능할때 팝업 이미지 표시
//		 		CountPosition = 0;		// Total 숨김
		 		ImageList(0) = "img/btns_calendar.gif";
		 		PopupButtonImage(0, "eff_dt") = 0;
		 		PopupButtonImage(0, "exp_dt") = 0;
			}
	     	break;
			
        case "sheet6":	// Service Scope
            with (sheetObj) {
                // 높이 설정
                style.height = 120;
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
                InitRowInfo(1, 1, 3, 100);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false, false);
    
                var HeadTitle =  "|Sel.|Seq.|Prop No.|Amendment Seq|SVC Scope|Duration|Duration|Duration|Target MQC|Unit";
                    HeadTitle += "|G/L Copy|Request Office|Sales Rep|Status|eff_dt|exp_dt|n1st_cmnc_dt|pre_exp_dt";
                    HeadTitle += "|Status|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|DUR_DUP_FLG|pre_ext_scp";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck,  	40,  daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 		30,  daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no", 		  true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtComboEdit, 	100, daCenter, false, "svc_scp_cd", 	  true,  "", dfNone, 	0, false, true, 3);
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "ctrt_eff_dt", 	  true,  "", dfDateYmd, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "ctrt_exp_dt", 	  true,  "", dfDateYmd, 0, true, true);
                InitDataProperty(0, cnt++, dtPopupEdit, 	20,  daCenter, false, "scp_dur_pop", 	  false, "", dfNone, 	0, true,  false);
                InitDataProperty(0, cnt++, dtData, 			110, daCenter, false, "tgt_mvc_qty", 	  false, "", dfInteger, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,  		60,  daCenter, false, "cntr_lod_ut_cd",   false, "", dfNone,    0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 		60,  daCenter, false, "gline_cp_flg_lnk", false, "", dfNone, 	0, true,  false);
                InitDataProperty(0, cnt++, dtData, 			110, daCenter, false, "prop_scp_ofc_cd",  true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtData,   		110, daCenter, false, "prop_scp_srep_cd", false,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtCombo,  		100, daCenter, false, "prop_scp_sts_cd",  false, "", dfNone, 	0, false, false, 100);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "eff_dt", 		  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "exp_dt", 		  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "n1st_cmnc_dt", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "pre_exp_dt", 	  false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prop_scp_sts", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "req_usr_flg", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "apro_usr_flg", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prc_prog_sts_cd",  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "src_info_cd", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "tgt_mvc_qty_ori",  false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		90,  daCenter, false, "dur_dup_flg", 	  false, "", dfNone, 	0, false, false);
                //이전 AMEND SEQ에 추가된 SCOPE확인
                InitDataProperty(0, cnt++, dtHidden, 		90,  daCenter, false, "pre_ext_scp", 	  false, "", dfNone, 	0, false, false);
            }
            break;

        case "sheet7":  // sheet3의 Origin Point(Hidden)
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
                
                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet8":  // sheet3의 Origin Via.(Hidden)
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
                
                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet9":  // sheet3의 Destination Via.(Hidden)
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
                
                var HeadTitle = "9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet10":  // sheet3의 Destination Point(Hidden)
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
                
                var HeadTitle = "10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet11":  // sheet3의 Direct Call(Hidden)
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
                
                var HeadTitle = "status";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

                Visible = false;
            }
            break;
            
        case "sheet12":  // sheet3의 Rnote(Hidden)
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
                
                var HeadTitle = "12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_note_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prev_note_conv_mapg_id", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet13": // Request 클릭시, Route 중에 term이 빠진 Location check
            with (sheetObj) {
                // 높이 설정
//                style.height = 120;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false, false)
                var HeadTitle = "|SVC_SCP_CD|ORG_DEST_TP_CD|ROUT_PNT_LOC_DEF_CD";
                var headCount = ComCountHeadTitle(HeadTitle);
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "svc_scp_cd", 	  	 false,  "", dfNone,	0, false, false);                
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "org_dest_tp_cd",   	 false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "rout_pnt_loc_def_cd", false,  "", dfNone, 0, false, false); 
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
	 * @author 공백진
	 * @version 2009.04.17
	 */         
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
	        // Service Scope
	        case "ssvc_scp_cd":
	            var i = 0;
	            with (comboObj) {
	                DropHeight = 200;
	                UseAutoComplete = true;
	                ValidChar(2, 0);    // 영문대문자만 입력
	                MaxLength = 3;      // 3자리만 입력
	            }
	            break;
            case "req_usr_nm":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                }
                                
                break;
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * <br><b>Example :</b>
	 * <pre>
	 *	  if (!validateForm(sheetObj,document.form,sAction)) {
	 *		  return false;
	 *	   }
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {object} formObj 필수, html document form Object
	 * @param {int} sAction 필수, action의 구분
	 *
	 * @return boolean, true: 유효, false: 비유효
	 */
	function validateForm(sheetObj, formObj, sAction) {
		
		var rfa_no = formObj.rfa_no.value;
		var prop_no = formObj.prop_no.value;
		var amdt_seq = formObj.amdt_seq.value;
		
		switch (sAction) {
			case IBSEARCH: // 조회
				if(sheetObj.id == "sheet1") {
					if ((rfa_no == null || rfa_no == "") && (prop_no == null || prop_no == "")) {
	                    ComShowCodeMessage('PRI01042', "RFA No. or Proposal No"); // Please input {?msg1}.
						return false;
					}
				} else {
					if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
						return false;
					}
				}
				
				return true;
	        	
				break;
				
			case IBCREATE: // New
				if(sheetObjects[0].IsDataModified){
					return ComPriClearChange;
				}
				break;
				
			case COMMAND02://REQUEST 
				if (formObj.prop_no.value ==""){
					ComShowCodeMessage('PRI01021');
					return;
				}	 
				
				if(!addOnTariffDurationCheck(amdt_seq, formObj)) {
					return false;
				}
				
				if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified || sheetObjects[3].IsDataModified || sheetObjects[4].IsDataModified){
					ComShowCodeMessage('PRI01057'); // msgs['PRI01057'] = 'Updated data exists, Please save it first.';
					return false;
				}
				 
				/////////////////////////////////////////////////////////////////////
				// update date 검사
				var checkSheetObj = sheetObjects[0];
				var checkTpCd = "CHECK1";
				// 다른 사용자가 해당 RFA 상태 update 했는지 check하는 로직
				if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
					return false;
				}
				/////////////////////////////////////////////////////////////////////
				var rValue = "";
				if (formObj.rfa_no.value == "" && formObj.prop_no.value == "") {
					return false;
				}
				if (sheetObjects[1].RowCount == 0){
					return false;
				}
				
				//Route 중에 term이 빠진 Location check
				formObj.f_cmd.value = SEARCH15;
				var termCheckMsg = '';
				var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_2003GS.do", FormQueryString(formObj)); // 기존것을 그냥 사용
				sheetObjects[12].LoadSearchXml(sXml);				
				if(sheetObjects[12].RowCount > 0){
					for(var i=sheetObjects[12].HeaderRows; i <= sheetObjects[12].LastRow; i++){
						termCheckMsg = termCheckMsg + '\n['
									 + sheetObjects[12].CellValue(i,'svc_scp_cd')+'-'
									 + sheetObjects[12].CellValue(i,'org_dest_tp_cd')+'-'
									 + sheetObjects[12].CellValue(i,'rout_pnt_loc_def_cd')+']';
					}
					if(termCheckMsg != ''){
						ComShowCodeMessage("PRI07054", termCheckMsg);
						// Rate tab focus
						tabObjects[0].SelectedIndex = 3;
						tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex);
						return false;
					}				
				}
				
				if (!ComShowCodeConfirm("PRI01032","Request")){
					return false;
				}
				
				// Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
				if(checkIHCRateAmt() != 'Y') {
					return false;
				}
				
				//Main,Scope Duration Eff_dt,Exp_dt 일치 체크 -> 항상 일치
				var mainCtrtEffDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
				var mainCtrtExpDt = ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd");
				var scpCtrtEffDt = "";
				var scpCtrtExpDt = "";
				var ctrtDateMatch = false;  
		
				for (var i = 1; i <= getValidRowCount(sheetObjects[5]); i++){
					scpCtrtEffDt = sheetObjects[5].CellValue(i, "ctrt_eff_dt");
					scpCtrtExpDt = sheetObjects[5].CellValue(i, "ctrt_exp_dt");
					if (mainCtrtEffDt == scpCtrtEffDt && mainCtrtExpDt == scpCtrtExpDt ){
						ctrtDateMatch = true;
						continue;
					}
				}
				//MAIN과 일치하는 SCOPE이 하나도 없을 경우
				if (!ctrtDateMatch){
					 ComShowCodeMessage("PRI01096");
				}				
				
				// Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다
				rValue = checkRequest();
				if (rValue !="Y"){
					return false;
				}
				
				break;
				
			case COMMAND04: // Approve		
				var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
				var req_usr_flg = sheetObjects[0].CellValue(1, "req_usr_flg");
				var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
		
				// 승인권한
				if (apro_usr_flg=="N"){
					ComShowCodeMessage('PRI01033','Approve');	//msgs['PRI01033'] = 'You have no authority. [{?msg1}]';
					return false;
				}
				
				if (!ComShowCodeConfirm("PRI01032","Approve")){  // msgs['PRI01032'] = 'Do you want to proceed {?msg1}?';
					return false;
				}
				//status Request 일 경우에만 Approve 가능
				if (prop_sts_cd !="Q" ){
					ComShowCodeMessage('PRI01034');		// msgs['PRI01034'] = 'Please check status.';
					return false;
				}
				
				// 하위값 모두 승인되었는가 check
				var rValue = checkAccept();
				
				// 하위 탭 이외에 승인되지 않았을 경우 메세지
				if (rValue != "Y" || rValue == "MN") {
					ComShowCodeMessage('PRI01031');		//msgs['PRI01031'] = 'There is service scope which is not accepted.';
					return false;
				}
				/////////////////////////////////////////////////////////////////////
				// update date 검사
				var checkSheetObj = sheetObjects[0];
				var checkTpCd = "CHECK1";
				if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
					return false;
				}
		 
				break;
			case COMMAND05: // Cancel
				/////////////////////////////////////////////////////////////////////
				// update date 검사
				var checkSheetObj = sheetObjects[0];
				var checkTpCd = "CHECK1";
				if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
					return false;
				}
				/////////////////////////////////////////////////////////////////////
				var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
				var amdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
				
				if(prop_sts_cd == "A") {
					if (checkApproveCancel() != "Y"){
						return false;
					}
				}
				
				break;
	
	        case IBINSERT: // Row Add
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	
	        	// Route & Summary
	        	if (sheetObj.id == "sheet3") {
	    			
	    		// Rate
	        	} else if (sheetObj.id == "sheet4") {
	    			if (sheetObjects[2].RowCount <= 0 || sheetObjects[2].SelectRow <= 0) {
	    				return false;
	    			}
	    			
	    			// Route가 삭제되었는지 확인.
	    			if (isRouteGroupDeleted()) {
	    				return false;
	    			}
	    			
	            	if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
	            		ComShowCodeMessage("PRI00313");
	            		return false;
	            	}
	        	// Charge Term (Conversion)
	        	} else if (sheetObj.id == "sheet5") {
	    			if (sheetObjects[2].RowCount <= 0 || sheetObjects[2].SelectRow <= 0) {
	    				return false;
	    			}
	    			
	        		if (isRouteGroupDeleted()) {
	        			return false;
	        		}
	        		
	        		// Amend된 Rate 클릭 후 Row add 선택 시
	        		if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
	        			ComShowCodeMessage("PRI00313");
	        			return false;
	        		}
	        	}
	            
	            return true;
	            break;
				
			case IBSAVE: // Save
				var formObj = document.form;
				if(!ComChkRequired(document.form)){
					return false;
				}
				
				var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
				
				// Main Info & Commodity
				if (sheetObj.id == "sheet1") {
//					if (prop_sts_cd != "I") {
//	            		return false;
//	            	}
					if(!sheetObjects[0].IsDataModified &&!sheetObjects[1].IsDataModified){
	                    ComShowCodeMessage("PRI00301");
	                    return false;
	                }
					
					if(formObj.ssvc_scp_cd.Code == "") {
						ComShowCodeMessage('PRI00316','Service Scope'); 
						return false;
					}
	
					if(formObj.req_usr_nm.Code == "") {
						ComShowCodeMessage('PRI00316','Request Staff'); 
						return false;
					}
					
					//if(sheetObjects[0].CellValue(1,"eff_dt") != "" && sheetObjects[0].CellValue(1,"ctrt_exp_dt") != "" && ComGetDaysBetween(sheetObjects[0].CellValue(1, "eff_dt"), sheetObjects[0].CellValue(1, "ctrt_exp_dt")) >= 15){
					
					if( sheetObjects[0].CellValue(1,"eff_dt") != "" && sheetObjects[0].CellValue(1,"ctrt_exp_dt") != "" && PriCheckMonthBetween(sheetObjects[0].CellValue(1, "eff_dt"), sheetObjects[0].CellValue(1, "ctrt_exp_dt") ,1) < 1 ){
					    ComShowCodeMessage("PRI07060"); // Duration should not be more than 14 days for Master RFA Publishing.
						return false;
					}
					
					if(ComGetDaysBetween(ComGetNowInfo('ymd', ''), sheetObjects[0].CellValue(1, "eff_dt")) < 0 && formObj.amdt_seq.value == "0" && sheetObjects[0].CellValue(1, "prop_sts_cd") == "I") {
	           			ComShowCodeMessage("PRI01160"); // Retroactive Filing is not allowed
	           			formObj.ctrt_eff_dt.focus();
						return false;
					}
					
					return true;
				// Route & Summary
				} else if(sheetObj.id == "sheet3") {
					// RFA의 경우 Initial뿐만 아니라 Requested상태에서도 저장가능.
	            	if (formObj.prc_prop_sts_cd.value != "I"
	            		&& formObj.prc_prop_sts_cd.value != "Q") {
	            		return false;
	            	}
	            	
	                if (!sheetObjects[2].IsDataModified
	                        && !sheetObjects[3].IsDataModified
	                        && !sheetObjects[4].IsDataModified
	                        && !sheetObjects[6].IsDataModified
	                        && !sheetObjects[7].IsDataModified
	                        && !sheetObjects[8].IsDataModified
	                        && !sheetObjects[9].IsDataModified
	                        && !sheetObjects[11].IsDataModified) {
	                    ComShowCodeMessage("PRI00301");
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
	                if (sheetObjects[9].IsDataModified
	                        && sheetObjects[9].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[11].IsDataModified
	                        && sheetObjects[11].GetSaveString() == "") {
	                    return false;
	                }
	                
	                // Origin, O.Via, D.Via, Dest. 필수입력체크. Route그룹이 삭제된 경우는 체크하지 않음.
	                if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
	                	&& sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
	                	&& getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value) <= 0) {
	                	if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "org_rout_pnt_loc_def_cd") == "") {
	                		ComShowCodeMessage("PRI00316", "Origin");
	                	}
	                    return false;
	                }
	                if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
	                	&& sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
	                	&& isOViaMandatory
	                	&& getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value) <= 0) {
	                	if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "org_rout_via_port_def_cd") == "") {
	                		ComShowCodeMessage("PRI00316", "O.Via");
	                		return false;
	                	}
	                }
	                if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
	                	&& sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
	                	&& isDViaMandatory
	                	&& getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value) <= 0) {
	                	if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "dest_rout_via_port_def_cd") == "") {
	                		ComShowCodeMessage("PRI00316", "D.Via");
	                	}
	                    return false;
	                }
	                if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
	                	&& sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
	                	&& getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value) <= 0) {
	                	if(sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "dest_rout_pnt_loc_def_cd") == "") {
	                		ComShowCodeMessage("PRI00316", "Dest.");
	                	}
	                    return false;
	                }
	                
	                // Route Group이 삭제되지 않은 경우 해당 Rate가 존재하는 체크.
	    			if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
	    				&& sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
	    				&& getAmendValidRowCount(sheetObjects[3], formObj.amdt_seq.value) <= 0) {
	    				ComShowCodeMessage("PRI01125");
	    				return false;
	    			}
	    			
	    			// Rating Unit, Cargo Type 별로 중복이 있는지 체크.
	            	var dupRow = ComPriAmendDupCheck(sheetObjects[3], "rat_ut_cd|prc_cgo_tp_cd", formObj.amdt_seq.value);
	            	if (dupRow >= 0) {
	            		sheetObjects[3].SelectRow = dupRow;
	    				ComShowCodeMessage("PRI00302");
	    				return false;
	            	}
	            	
	            	// Rate값에 0보다 작은 수가 있는지 체크.
	                for (var i = sheetObjects[3].HeaderRows; sheetObjects[3].RowCount > 0 && i <= sheetObjects[3].LastRow; i++) {
	                	//2011.04.20 이행지 [선조치 후CSR] Delete시 0이하의 마이너스 값 체크시 수정가능한 항목들만 체크하도록 변경
	                    if (sheetObjects[3].CellEditable(i, "prop_frt_rt_amt") == true 
	                        && sheetObjects[3].RowStatus(i) != "D" && sheetObjects[3].CellValue(i, "prop_frt_rt_amt") <= 0) {
	                    	sheetObjects[3].SelectCell(i, "prop_frt_rt_amt", false);
	                        ComShowCodeMessage("PRI00321", "Rate", "0.00");
	                        return false;
	                    }
	                }
	                
	    			// Route & Summary  정보에 중복이 있는지 체크한다.
	                var rowM = sheetObjects[2].ColValueDupRows("org_rout_pnt_loc_def_cd|rcv_de_term_cd_ori|org_rout_via_port_def_cd|dest_rout_via_port_def_cd|dest_rout_pnt_loc_def_cd|rcv_de_term_cd_dest|"+
	                												"bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_slan_cd|bkg_vvd_cd", false, true);
	                
					if (rowM != "") {
						var arrRow = rowM.split("|");
						var dupList = "";
						
						for (idx=0; idx<arrRow.length; idx++) {
							if(idx != 0) {
								dupList += ", ";
							}
							dupList += parseInt(arrRow[idx]) -1; // Header Row가 두줄이기 때문에 -1
						}
						
						 ComShowCodeMessage("PRI00303", "Route & Summary Sheet", dupList);
						 return false;
					}
	    			
	    			/* CONVERSION - START */
	    			
	       			//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
	       			for(var i = sheetObjects[4].HeaderRows; getValidRowCount(sheetObjects[4]) > 0 && i <= sheetObjects[4].LastRow; i++) {
	       				if(!sheetObjects[4].RowHidden(i)) {
	    	   				if(!checkConvNoteMandatoryValidation(sheetObjects[4], i)) {
	    	 					return false;
	    	 				}
	       				}
	       			}
	       			
	    			
	    			if (sheetObjects[4].IsDataModified ) {
	    				
	    				for(var i = sheetObjects[4].HeaderRows; i <= sheetObjects[4].LastRow; i++) {
	    		 			if(sheetObjects[4].CellValue(i, "bkg_vvd_cd") != ""  && sheetObjects[4].CellValue(i, "bkg_vvd_cd").length != 9 && sheetObjects[4].RowStatus(i) != "D") {
	    		 				sheetObjects[4].SelectCell(i, "bkg_vvd_cd");
	    		 				ComShowCodeMessage("PRI01065", "VVD", "9");
	    		 				return false;
	    		 			}
	    		 		}
	    				
	    				//중복체크
	    				if(!validateDupCheck(sheetObjects[4])) {
	    					 return false;
	    				}
	    			}
	    			/* CONVERSION - END */
	    			
				}
				
				return true;
				break;
			
	        case IBDELETE: // Delete
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	
	            if (sheetObj.id == "sheet3") {
	            	if (isRouteGroupDeleted()) {
	            		return false;
	            	}
	            } else if (sheetObj.id == "sheet4") {
	            	if (isRouteGroupDeleted4Rate()) {
	            		return false;
	            	}
	            	
	            	var sCheckedRows = sheetObj.FindCheckedRow("chk");
	            	var arrCheckedRows = new Array();
	            	if (sCheckedRows == "") {
	            		arrCheckedRows.push(sheetObj.SelectRow);
	            	} else {
	            		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	            	}
	            	for (var i = 0; i < arrCheckedRows.length; i++) {
	                	if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
	                		ComShowCodeMessage("PRI00313");
	                		return false;
	                	}
	    				if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW"
	    					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
	    					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM"
	    					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
	    					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM"
	    					&& sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
	    					ComShowCodeMessage("PRI00313");
	    					return false;
	    				}
	            	}
	            } else if (sheetObj.id == "sheet5") {
		        	// Conversion의 APP는 Amend 불가
	        		if(sheetObj.CellValue(sheetObj.SelectRow, "chg_rule_def_cd") == "APP") {
	        			ComShowCodeMessage("PRI01022" , "\n please modity/delete APP Charge in Route & Summary "); // msgs['PRI01022'] = 'You can not modity/delete data in use. {?msg1}';
	        			return false;
	        		}
	            }
	        	
	        	return true;
	            break;
	        
	    	case IBSEARCH_ASYNC04: //  Accept Cancel all
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	
	        	if (sheetObjects[2].RowCount <= 0) {
	        		return false;
	        	}
	        	// 승인권자가 아니거나, 상태가 Requested가 아닌 경우.
	        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
	        		return false;
	        	}
	        	// Accept된 항목이 하나도 없을 경우
	        	if (parseInt(acptCnt) <= 0) {
	        		ComShowCodeMessage("PRI00330");
	        		return false;
	        	}
	            
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC11: // Amend
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	
	        	var checkedCnt = sheetObj.CheckedRows("chk");
	        	if (checkedCnt > 1) {
	        		ComShowCodeMessage("PRI00310");
	        		return false;
	        	}
	        	var curRow = -1;
	        	if (checkedCnt == 1) {
	        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        	} else if (checkedCnt == 0) {
	        		curRow = sheetObj.SelectRow;
	        	}
	        	
	        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01011");
	        		return false;
	        	}

	        	// Conversion의 APP는 Amend 불가
	        	if(sheetObj.id == "sheet5") {
	        		if(sheetObj.CellValue(curRow, "chg_rule_def_cd") == "APP") {
	        			ComShowCodeMessage("PRI07062"); // You can not amend APP Charge Code
	        			return false;
	        		}
	        	}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC12: // Amend Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	
	        	var checkedCnt = sheetObj.CheckedRows("chk");
	        	if (checkedCnt > 1) {
	        		ComShowCodeMessage("PRI00310");
	        		return false;
	        	}
	        	var curRow = -1;
	        	if (checkedCnt == 1) {
	        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        	} else if (checkedCnt == 0) {
	        		curRow = sheetObj.SelectRow;
	        	}
	        	
	        	// Amend된 행이 아닌경우
	        	if (sheetObj.CellValue(curRow, "src_info_cd") != "AM" && sheetObj.CellValue(curRow, "src_info_cd") != "AD") {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01012");
	        		return false;
	        	}

	        	// Conversion의 APP는 Amend 불가
	        	if(sheetObj.id == "sheet5") {
	        		if(sheetObj.CellValue(curRow, "chg_rule_def_cd") == "APP") {
	        			ComShowCodeMessage("PRI07062"); // You can not amend APP Charge Code
	        			return false;
	        		}
	        	}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC13: // Accept
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	
	        	// 승인권자나 작성권자가 아니거나, Accept할 수 있는 상태(Requested, Returned)가 아닌 경우.
	        	if ((!bIsAproUsr && !bIsReqUsr) || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
	        		return false;
	        	}
	        	
	        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
	        	var arrCheckedRows = new Array();
	        	if (sCheckedRows == "") {
	        		arrCheckedRows.push(sheetObj.SelectRow);
	        	} else { 
	        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	        	}
	        	for (var i = 0; i < arrCheckedRows.length; i++) {
	        		// 이미 Accept된 행인 경우.
	        		if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
						ComShowCodeMessage("PRI01037");
						return false;
	        		}
	        		// 현재 Seq.의 데이터가 아닌 경우 또는 승인권한없는 작성권자가 Returned상태가 아닌 경우에 Accept하려고 한 경우.
					if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value
						|| (bIsReqUsr && !bIsAproUsr && sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "R")) {
						ComShowCodeMessage("PRI00313"); // msgs['PRI00313'] = 'This sequence can not be selected.';
//						alert('이전 회차에 승인된 대상은 승인 취소 및 재승인이 불가능 합니다.');
						return false;
					}
					if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
						ComShowCodeMessage("PRI00313"); // msgs['PRI00313'] = 'This sequence can not be selected.';
//						alert('이전 회차에 승인된 대상은 승인 취소 및 재승인이 불가능 합니다.');
						return false;
					}
	        	}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC14: // Accept Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	// 승인권자가 아니거나, Accept할 수 있는 상태(Requested, Returned)가 아닌 경우.
	        	if (!bIsAproUsr || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
	        		return false;
	        	}
	        	
	        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
	        	var arrCheckedRows = new Array();
	        	if (sCheckedRows == "") {
	        		arrCheckedRows.push(sheetObj.SelectRow);
	        	} else { 
	        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	        	}
	        	for (var i = 0; i < arrCheckedRows.length; i++) {
	        		// Cancel하려는 행이 Accepted상태가 아닌 경우.
	        		if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A" && sheetObj.id != "sheet3") {
						ComShowCodeMessage("PRI01038");
						return false;
	        		}
					if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value){
						ComShowCodeMessage("PRI00313"); // msgs['PRI00313'] = 'This sequence can not be selected.';
//						alert('이전 회차에 승인된 대상은 승인 취소 및 재승인이 불가능 합니다.');
						return false;
					}
					if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
						ComShowCodeMessage("PRI00313");// msgs['PRI00313'] = 'This sequence can not be selected.';
//						alert('이전 회차에 승인된 대상은 승인 취소 및 재승인이 불가능 합니다.');
						return false;
					}
	        	}
	        	
	            return true;
	            break;
	            
		}
		return true;
	}
	
	/**
	 * SHEET ROW 중복체크를 하는 FUNCTION <br>
	 * 모든 항목이 같고 EFF_DT와 EXP_DT가 중첩이 발생할경우에 중복체크를 한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * validateDupCheck(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return boolean
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function validateDupCheck(sheetObj) {
		
		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
			 		"|bkg_slan_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|note_conv_mapg_id", false, true);
		
		if (rowM != "") {
			// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
			// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
			var rowDupKeyList = rowM.split("|");
			
			//var rowDup = rowM.replace("|", ","); 			
			//중복되는 모든ROW
			//var rowArr = rowDup.split(",");
			
			var rowArr = rowDupKeyList[0].split(",");
			var rowObj = rowDupKeyList[1].split(",");
				
			var dupValue = "";
			var temValue = "";						
			var firstEffDt = "";
			var firstExpDt = "";						
			var SecondEffDt = "";
			var SecondExpDt = "";
			var hrows = sheetObj.HeaderRows;
			
			for(var i=0; i<rowArr.length; i++) {
				if (sheetObj.RowHidden(rowArr[i])) {
					continue;
				}
				dupValue  = sheetObj.CellValue(rowArr[i], "chg_rule_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rat_ut_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_imdg_clss_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_cmdt_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pod_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_del_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_por_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pol_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_slan_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_vvd_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_soc_flg");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dir_call_flg");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_ts_port_def_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_min_cgo_wgt");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_max_cgo_wgt");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_hngr_bar_tp_cd");
				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "note_conv_mapg_id");
				
				for(var j=0; j<rowObj.length; j++) {
	 				if (sheetObj.RowHidden(rowObj[j])) {
	 					continue;
	 				}
					temValue  = sheetObj.CellValue(rowObj[j], "chg_rule_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rat_ut_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_prc_cgo_tp_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_imdg_clss_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_cmdt_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pod_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_del_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_por_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pol_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_slan_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_vvd_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_soc_flg");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dir_call_flg");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_ts_port_def_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_min_cgo_wgt");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_max_cgo_wgt");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_hngr_bar_tp_cd");
					temValue += "\t" + sheetObj.CellValue(rowObj[j], "note_conv_mapg_id");
					
					//if(i != j) {
	  					if(dupValue == temValue) {
	  						firstEffDt = sheetObj.CellValue(rowArr[i], "eff_dt");
	  						firstExpDt = sheetObj.CellValue(rowArr[i], "exp_dt");
	  						
	  						SecondEffDt = sheetObj.CellValue(rowObj[j], "eff_dt");
	  						SecondExpDt = sheetObj.CellValue(rowObj[j], "exp_dt");
	  						
	  						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	  							ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  			 			
	  			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	  			 				ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  						
	  					} //if
					//} //if
				} //for
				
			} //for
			
		} //if
		
		return true;
	}
	
    /**
     * Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *         checkRequest
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function checkRequest(){
       document.form.f_cmd.value = SEARCH07;
       var rMsg = "";
       var rValue = "N"; // Request 금지
       var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+ "&" + FormQueryString(document.form) ;        
       var errMsg ="";
       // Reqeust 시 Calcualte or M/B조회 하지 않은 scope를 검색
       var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2203GS.do", sParam);
       var chkType = "";
       var arrData = ComPriXml2Array(sXml, "terms|cnt");
       var amendChk = false;
       if (arrData != null && arrData.length > 0) {
           for (var i = 0; i < arrData.length; i++){
//               if (arrData[i][0] == "CALC_CHK"){// RATE CALCULATE
//               	chkType = "1";
//               	if (arrData[i][1] != ""){
//               		rValue = "N";
//               		errMsg = arrData[i][1];
//               		break;
//               	}else{
//               		rValue = "Y";
//               	}
//               } else if(arrData[i][0] == "MB_CHK") {// RATE MATCH BACK
//               	chkType = "1";
//               	if (arrData[i][1] != "") {
//               		rValue = "N";
//               		errMsg = arrData[i][1];
//               		break;
//               	} else {
//               		rValue = "Y";
//               	}
//               }else{
               	chkType = "2";
               	if (arrData[i][1] != "0"){
                       rValue = "Y";
                   }else{
                       rMsg += " "+arrData[i][0]+" "                    
                       rValue = "N";
                   	if (arrData[i][0] == "AMEND"){
                   		amendChk = true;
                   	}
                       break;
                   }                	
//               }
           }            
           if (rValue == "N" && amendChk == false && chkType == "2"){//RATE필수입력
               ComShowCodeMessage("PRI01042",rMsg);
           }else if (rValue == "N" && amendChk == true && chkType == "2"){//AMEND DATA없음
           	ComShowCodeMessage("PRI01105"); 
//           }else if (rValue == "N" && chkType == "1"){//RATE CALCULATE or MATCH BACK
//           	ComShowCodeMessage("PRI03027",errMsg,"Request");
           }
       }else{
       	ComShowMessage(OBJECT_ERROR);
       }
       
       return rValue;
    }
	
	/**
	 * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
	 * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확인을 한다.<BR>
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
		case "CHECK1" : // request
			var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+checkSheetObj.CellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
			var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
    * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllForms()
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function clearAllForms(){
        var formObj = document.form;
        formObj.rfa_no.value="";
        formObj.prop_no.value="";
        formObj.amdt_seq.value="";
        formObj.svc_scp_cd.value = "";
        formObj.prc_prop_sts_cd.value = "";
        formObj.ctrt_eff_dt.value=ComGetNowInfo('ymd', '-');
        formObj.ctrt_exp_dt.value="";
        formObj.prop_ofc_cd.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.eff_dt.value = "";
        formObj.exp_dt.value = "";
        formObj.rout_seq.value = "";
        comboObjects[0].Index = -1;
        comboObjects[1].Index = -1;
        formObj.ssvc_scp_cd.enable = true;
        formObj.req_usr_nm.enable = true;
        document.getElementById("btns_calendar1").style.visibility = "visible";
    }
	
    //  ===================================================================================
    //  Button Object Event Handler
    //  ===================================================================================
    
    /**
     * 화면의 버튼을 상태에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @param   없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 
    function buttonControl(){
        var formObj = document.form;
        var sts = sheetObjects[0].CellValue(1, "prop_sts_cd");
        var req_usr_flg  = sheetObjects[0].CellValue(1, "req_usr_flg");
        var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
        var all_usr_flg = sheetObjects[0].CellValue(1, "all_usr_flg");
        var copy_auth_flg = sheetObjects[0].CellValue(1, "copy_auth");

        var scp_req_usr_flg = "";
        var scp_apro_usr_flg = "";
        var amdt_seq = sheetObjects[0].CellValue(1, "amdt_seq");
        var sheetObj = sheetObjects[1];
 
        scp_req_usr_flg = req_usr_flg;
        scp_apro_usr_flg = apro_usr_flg; 
        
        bIsReqUsr = sheetObjects[0].CellValue(1, "req_usr_flg") == "Y"? true : false;;
        bIsAproUsr = sheetObjects[0].CellValue(1, "apro_usr_flg") == "Y"? true : false;
        
        try{
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_save");
            ComBtnDisable("btn_amend");
            btnImgEnable(formObj.btns_calendar1, false);
            ComBtnDisable("btn_request");
            ComBtnDisable("btn_approve");
            ComBtnDisable("btn_cancel");
            ComBtnDisable("btn_copy");
            ComBtnDisable("btn_copy_to_rfa");
            
            ComBtnDisable("btn_acceptall");
            ComBtnDisable("btn_acceptcancel");
            ComBtnDisable("btn_gricalc");
            ComBtnDisable("btn_downexcel");
            ComBtnDisable("btn_loadexcel");
            
        	ComBtnDisable("btn_rowadd1");
        	ComBtnDisable("btn_rowadd2");
        	ComBtnDisable("btn_rowadd3");
        	ComBtnDisable("btn_rowcopy");
        	ComBtnDisable("btn_delete1");
        	ComBtnDisable("btn_delete2");
        	ComBtnDisable("btn_delete3");
        	ComBtnDisable("btn_save1");
        	ComBtnDisable("btn_save2");
        	ComBtnDisable("btn_save3");
        	ComBtnDisable("btn_amend2");
        	ComBtnDisable("btn_amend3");
        	ComBtnDisable("btn_amendcancel2");
        	ComBtnDisable("btn_amendcancel3");
        	ComBtnDisable("btn_accept1");
        	ComBtnDisable("btn_accept2");
        	ComBtnDisable("btn_accept3");
        	ComBtnDisable("btn_acceptcancel1");
        	ComBtnDisable("btn_acceptcancel2");
        	ComBtnDisable("btn_acceptcancel3");
      
            formObj.ctrt_eff_dt.readOnly = false;
            formObj.ctrt_exp_dt.readOnly = false;
            // 처음이나 Initial 상태에서만 Duration 등록 가능
            if(sts=="I" ||  sts=="" ) {
            	document.getElementById("btns_calendar1").style.visibility = "visible"; 
            } else {
            	document.getElementById("btns_calendar1").style.visibility = "hidden";
            }
            formObj.ssvc_scp_cd.enable = false;
            
            //작성자  Initial, Request Cancel 할수있다.
            if ((req_usr_flg =="Y" && sts=="Q") || apro_usr_flg =="Y"){
            	ComBtnEnable("btn_cancel");
            }
            
            // Request 한 사람도 Request Cancel 할 수 있다. 
//            alert('  usr_id  ' + formObj.str_usr_id.value + '   req : ' + sheetObjects[0].CellValue(1,"req_usr_id"));
            if(sts=="Q"){
            	if((formObj.str_usr_id.value == sheetObjects[0].CellValue(1,"req_usr_id"))) {
            		ComBtnEnable("btn_cancel");
            	}
            }
            
            // 승인권자는 Request Staff를 Status 상관없이 변경 가능 
            if(apro_usr_flg == "Y") {
            	formObj.req_usr_nm.enable = true;
            }
            
            formObj.prop_ofc_cd.readOnly = true; //Proposal Requect Office
            
            /******** 승인 권한이나 PRI17 권한이 있어야 활성화 05.02.*****/
//            alert('auth02N17 : ' + auth02N17 + ' apro_usr_flg : ' + apro_usr_flg);
//            alert(' copy_auth_flg :  ' + copy_auth_flg);
            
        	if(sts=="A" && copy_auth_flg=="Y") {
       			ComBtnEnable("btn_copy_to_rfa");	// PRI02 + S.Rep 코드
        	}
        	
            if(auth02N17 == "Y") {
            	ComBtnEnable("btn_new");
            	ComBtnEnable("btn_save");
            	
            	ComBtnEnable("btn_downexcel");
            } else {
            	// 권한이 없는 사람의 처리
            	ComBtnDisable("btn_new");
            	ComBtnDisable("btn_save");
            	
                btnImgEnable(formObj.btns_calendar1, false);
                formObj.ctrt_eff_dt.readOnly = true;
                formObj.ctrt_exp_dt.readOnly = true;
                formObj.req_usr_nm.enable = false;
                ComBtnDisable("btn_cancel");
                
//                return;
            }
            /******** 승인 권한이나 PRI17 권한이 있어야 활성화 05.02.*****/
            
//            //모든권한 없음...
//            if(req_usr_flg !="Y" && apro_usr_flg !="Y"){
//                btnImgEnable(formObj.btns_calendar1, false);
//                formObj.ctrt_eff_dt.readOnly = true;
//                formObj.ctrt_exp_dt.readOnly = true;
////                document.getElementById("btns_calendar1").style.visibility = "hidden";
//                formObj.req_usr_nm.enable = false;
//                
//                if (formObj.prop_sts.value == "") {
//                	ComBtnEnable("btn_save");
//                }else{
//                	ComBtnDisable("btn_save");
//                }
//                return;
//            } else {
//            	ComBtnEnable("btn_downexcel");
//            }

            switch(sts) {
                case 'I':   // Initial
//                    if(req_usr_flg=="Y"||apro_usr_flg=="Y"){
                	if(auth02N17 == "Y") {
                        if (formObj.prop_no.value !=""){
                            ComBtnEnable("btn_request");
                            ComBtnEnable("btn_cancel");
                    		ComBtnEnable("btn_gricalc");
                    		ComBtnEnable("btn_loadexcel");
                    		
                    		// Commodity가 있어야 버튼 활성화
                    		if(sheetObjects[1].RowCount != 0) {
                    			ComBtnEnable("btn_rowadd1");
                    			ComBtnEnable("btn_delete1");
                    		}
                    		
                    		btnImgEnable(formObj.btns_calendar1, true);
                        } else {
                        	ComBtnDisable("btn_gricalc");
                        	ComBtnDisable("btn_loadexcel");
                        }
                        
                    }
                	
                    break;
                    
                case 'Q':   // Requested
                    if(apro_usr_flg=="Y"){
                        var rValue = checkAccept();
                        
                        // all accept일 경우 approve 활성화
                        if (rValue == "Y"){
                            ComBtnEnable("btn_approve");
                        // 미승인이 있는 경우
                        } else {
                            ComBtnDisable("btn_approve");
                        }
                    }
                    
                	// Duration
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;
//                    document.getElementById("btns_calendar1").style.visibility = "hidden";
                    break;
                    
                case 'A':   // Approved
                	if(auth02N17 == "Y") {
                		ComBtnEnable("btn_amend");
                		// Approved RFA일 경우만 copy 가능
                		ComBtnEnable("btn_copy"); // PRI02 + PRI17
                	}
                    
                	// Duration
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;
//                    document.getElementById("btns_calendar1").style.visibility = "hidden";
                    break;
                    
            }
            otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
            
            // Sub Grid Button Setting
            if (document.form.prc_prop_sts_cd.value == "I") {
        		if (auth02N17 == "Y") {
                    // Commodity가 있어야 버튼 활성화
                    if(sheetObjects[1].RowCount != 0) {
                    	ComBtnEnable("btn_rowadd1");
                    	ComBtnEnable("btn_rowadd2");
                    	ComBtnEnable("btn_rowadd3");
                    	ComBtnEnable("btn_rowcopy");
                    	ComBtnEnable("btn_delete1");
                    	ComBtnEnable("btn_delete2");
                    	ComBtnEnable("btn_delete3");
                    	ComBtnEnable("btn_save1");
                    	ComBtnEnable("btn_save2");
                    	ComBtnEnable("btn_save3");
                    }
                    
                	if(amdt_seq != 0) {
                		ComBtnEnable("btn_amend2");
                		ComBtnEnable("btn_amend3");
                		ComBtnEnable("btn_amendcancel2");
                		ComBtnEnable("btn_amendcancel3");
                	}
        		}
        	} else if (document.form.prc_prop_sts_cd.value == "Q") {
        		if (apro_usr_flg=="Y") {
        			ComBtnEnable("btn_acceptall");
        			ComBtnEnable("btn_acceptcancel");
        			ComBtnEnable("btn_cancel");
        			
                	ComBtnEnable("btn_accept1");
                	ComBtnEnable("btn_accept2");
    	        	ComBtnEnable("btn_accept3");
    	        	ComBtnEnable("btn_acceptcancel1");
    	        	ComBtnEnable("btn_acceptcancel2");
    	        	ComBtnEnable("btn_acceptcancel3");
        		}
        	}

        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
    /**
    * Html 태그 오브젝트,IBMultiCombo를 메인의 상태에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
    * </pre>
    * @param   {string} sts 필수          메인의 상태코드
    * @param   {string} amdt_seq 필수     amend seq Number
    * @param   {string} req_usr_flg 필수  화면에대한 작성자권한 <br>
    *                   Y : 작성자 권한 있음
    *                   N : 작성자 권한 없음
    * @param   {string} apro_usr_flg 필수 화면에대한 승인권한 <br>
    * 					Y : 승인권한 있음
    * 					N : 승인권한 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function otherFormControl(sts,amdtSeq,reqUsrFlg,aproUsrFlg){
        var formObj = document.form;

    	switch (sts){
	    	case "I":
	    		if (amdtSeq =="0"){
//	    			formObj.prop_srep_cd.enable = true; // Request Staff
	    			
                    formObj.ctrt_eff_dt.readOnly = false;
                    formObj.ctrt_exp_dt.readOnly = false;
	    		}else{
//	    			if (aproUsrFlg == "Y" || reqUsrFlg =="Y" ){ //Request User도 S.rep 변경 가능 [CHM-201323523]
	    			if (aproUsrFlg == "Y" ){ // 승인권자만 S.Rep 수정 가능
	    				formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
		            	ComBtnEnable("btn_save");
	    			} else {
	    				formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
	    				ComBtnDisable("btn_save");
	    			}
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;   
	    		} 		
	    		break;
	    	case "Q":	
				if (aproUsrFlg == "Y"){ 
					formObj.prop_srep_cd.enable = true; // Request Staff
	            	ComBtnEnable("btn_save");
				} else {
    				formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
    				ComBtnDisable("btn_save");
				}
	    		break;
	    	case "R":  	
				if (aproUsrFlg == "Y" ){ 
					formObj.prop_srep_cd.enable = true; // Request Staff
	            	ComBtnEnable("btn_save");
				} else {
    				formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
    				ComBtnDisable("btn_save");
				}
	    		break;
	    	case "A":
				if (aproUsrFlg == "Y" ){ 
					formObj.prop_srep_cd.enable = true; // Request Staff
	            	ComBtnEnable("btn_save");
				} else {
    				formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
    				ComBtnDisable("btn_save");
				}
	    		break;

    	}
    	
    }
    
    /**
    * Pop화면 호출시 공통적으로 넘겨주는 Parameter를 생성한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    getParameters(srcName, param);
    * </pre>
    * @param   {string} srcName 필수  Html Object Name
    * @param   {string} param   선택  화면별로 넘겨주는 Parameter
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */     
    function getParameters(srcName){
    	
        var sheetObj = sheetObjects[0];
        var sRfaNo = sheetObj.CellValue(1,"rfa_no");
        var sPropNo = sheetObj.CellValue(1,"prop_no");
        var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
        var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
        var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");        
        var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
        var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
        var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
        
        var sRfaCtrtTpCd = sheetObj.CellValue(1, "rfa_ctrt_tp_cd");
        var sDurDt = sheetObj.CellValue(1,"ctrt_eff_dt");
        var eDurDt = sheetObj.CellValue(1,"ctrt_exp_dt");
        var nowEffDt = sheetObj.CellValue(1,"eff_dt"); 
        var effDt = ComGetDateAdd(sheetObj.CellValue(1,"eff_dt"), "D", 1);
        
        var sParam = "sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                   +"&sPropStsCd="+sPropStsCd+"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr
                   +"&sRfaCtrtTpCd="+sRfaCtrtTpCd + "&sSdurDt=" + sDurDt + "&sEdurDt=" + eDurDt+ "&sEffDt=" + effDt + "&nowEffDt=" + nowEffDt;
        
        return sParam;
    }
    
    /**
     * 메인의 상태에 따라 Cancel 버튼의 text를 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setCancelText();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 
    function setCancelText(){
        var formObj = document.form;
        var cancelTxt = formObj.prop_sts.value ;
        if (cancelTxt == "Requested"){
            cancelTxt = "Request ";
        }else if(cancelTxt == "Approved"){
            cancelTxt = "Approve ";
        }else{
            cancelTxt = "";
        }
        document.getElementById("btn_cancel_txt").innerText = cancelTxt +"Cancel";
        
    }

    /**
     * 화면의 지정된 부분을 숨기거나 표시하여 화면을 넓게 쓸수 있게한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setControlHidden();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */   
   	function setControlHidden(){
   		if (!controlHidden){
   			document.all.subterms.style.display = "none";
   			controlHidden = true;
   		}else{
   			document.all.subterms.style.display = "inline";
   			controlHidden = false;
   			sheet3_OnSearchEnd(sheetObjects[2], "");
   		}
   		try{
   		    parent.syncHeight();  // 펼쳤을때 화면하단 안보이는 문제 해결
   			}catch(e){}
   	}
//form 관련 (S) -----
    
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
    * @author 공백진
    * @version 2009.04.17
    */      
    function com_change_sheet( sheetObj, colNm ){
        var eleValue = "";      
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "ctrt_eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;
                case "ctrt_exp_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "cre_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "prop_apro_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;

                case "n1st_cmnc_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
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
    
//  form  관련   (E)   -----

    //  ===================================================================================
    //  Sheet Object Event Handler
    //  ===================================================================================
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Amend Seq.가 0일 경우 Main Duration을 변경할 경우 Main의 Effective,Expire Date도 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
     function sheet1_OnChange(sheetObj, Row, Col)
     {
         var colName = sheetObj.ColSaveName(Col);
         var formObj = document.form;
         
         switch(colName)
         {
             case "ctrt_eff_dt":
                 if (sheetObj.CellValue(Row,"amdt_seq") == "0") {
                     sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                     sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                     sheetObjects[5].CellValue2(1, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                 }
                 break;
                 
             case "ctrt_exp_dt":
                 if (sheetObj.CellValue(Row,"amdt_seq") == "0") {
                     sheetObj.CellValue2(Row, "exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
                 }
                 break;
                 
         }
     }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    	var formObj = document.form;
    	var prevStatus = sheetObj.RowStatus(1);
    	
        formObj.rfa_no.value = sheetObj.CellValue(1,"rfa_no");
        formObj.prop_no.value = sheetObj.CellValue(1,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"),"ymd");
        formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_exp_dt"),"ymd");
        formObj.prop_sts.value = sheetObj.CellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value = sheetObj.CellValue(1,"prop_ofc_cd");
        
        formObj.req_usr_id.value = sheetObj.CellValue(1,"req_usr_id");
        comboObjects[1].Code2 = sheetObj.CellValue(1,"prop_usr_id"); // Request Staff
        
        // Office Code가 달라서 가져온 정보가 없는 경우 원래 Request Staff를 보여주고 disable로 설정
        if(formObj.in_usr_ofc_cd.value != sheetObj.CellValue(1, "prop_ofc_cd")) {
        	if( sheetObj.CellValue(1,"prop_usr_id") != "" && comboObjects[1].Code == "") {
        		comboObjects[1].RemoveAll();
        		formObj.req_usr_nm.InsertItem(0, sheetObj.CellValue(1,"prop_usr_nm"), sheetObj.CellValue(1,"prop_usr_id"));
        		comboObjects[1].Code2 = sheetObj.CellValue(1,"prop_usr_id");
        		formObj.req_usr_nm.enable = false;
        	}
        }
        
        formObj.prop_apro_ofc_cd.value = sheetObj.CellValue(1,"prop_apro_ofc_cd");
        formObj.prop_apro_staff.value = sheetObj.CellValue(1,"prop_apro_staff");
		
        formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"cre_dt"),"ymd");
        formObj.eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"eff_dt"),"ymd");
        formObj.exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"exp_dt"),"ymd"); 
        formObj.prop_apro_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"prop_apro_dt"),"ymd");
        
        // prop_prpr_flg 는 항상 Y
        sheetObj.CellValue2(1, "prop_prpr_flg") = "Y";
        setCancelText();
        
        sheetObj.RowStatus(1) = prevStatus;
    }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
		var formObj = document.form;
		
        if (ErrMsg == "") {
        	if (sheetObj.RowCount > 0) {
	        	notAcptCnt = sheetObj.ComputeSum("|na_cnt|");
	        	acptCnt = sheetObj.ComputeSum("|ac_cnt|");
        	}
        	
        	for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
        		// 취소선이 있는 경우 다른 값들도 취소선을 넣어준다.
        		if(sheetObj.CellFont("FontStrikethru", i, "org_rout_pnt_loc_def_cd")) {
        			// Term
        			sheetObj.CellFont("FontStrikethru", i, "rcv_de_term_cd_ori") = true;
        			sheetObj.CellFont("FontStrikethru", i, "rcv_de_term_cd_dest") = true;
        			// APP
        			sheetObj.CellFont("FontStrikethru", i, "bkg_dir_call_flg") = true;
        			sheetObj.CellFont("FontStrikethru", i, "bkg_ts_port_def_cd") = true;
        			sheetObj.CellFont("FontStrikethru", i, "bkg_slan_cd") = true;
        			sheetObj.CellFont("FontStrikethru", i, "bkg_vvd_cd") = true;
        			
        		}
        		// Route Summary에 기존에 등록한 데이터는 편집 불가능.
        		if(sheetObj.CellValue(i, "rout_seq_prop") == "edit:false;") {
        			// Term
        			sheetObj.CellEditable(i, "rcv_de_term_cd_ori") = false;
        			sheetObj.CellEditable(i, "rcv_de_term_cd_dest") = false;
        			// APP
        			sheetObj.CellEditable(i, "bkg_dir_call_flg") = false;
        			sheetObj.CellEditable(i, "bkg_ts_port_def_cd") = false;
        			sheetObj.CellEditable(i, "bkg_slan_cd") = false;
        			sheetObj.CellEditable(i, "bkg_vvd_cd") = false;
        		}
        	}
        	
        	if(formObj.prc_prop_sts_cd.value == "I") {
        		for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
        			if(sheetObj.CellValue(i, "amdt_seq") == sheetObj.CellValue(i, "n1st_cmnc_amdt_seq")) {
        				// Direct Call 이 Y인 경우 T/S Port 변경 불가
        				if(sheetObj.CellValue(i, "bkg_dir_call_flg") == "Y") {
        					sheetObj.CellEditable(i, "bkg_ts_port_def_cd") = false;
        				} else {
        					sheetObj.CellEditable(i, "bkg_ts_port_def_cd") = true;
        				}
        			}
        		}
        	}
        	
//        	restylingPagePostTr(true);
//        	toggleButtons("INIT");
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
	 * @author 전지예
	 * @version 2016.04.22
	 */
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		// Route
        var curOrgDestType = "";
        var curPntViaType = "";
        var routeObject;
        
        /** Location **/ 
        if (colName == "org_rout_pnt_loc_def_cd" || colName == "org_rout_via_port_def_cd" || colName == "dest_rout_via_port_def_cd" || colName == "dest_rout_pnt_loc_def_cd") {
        	// Origin sheet7
        	if (colName == "org_rout_pnt_loc_def_cd") {
        		routeObject = sheetObjects[6];
        		curPntViaType = "P";
        		curOrgDestType = "O";
        	// Origin Via. sheet8
        	} else if (colName == "org_rout_via_port_def_cd") {
        		routeObject = sheetObjects[7];
        		curPntViaType = "V";
        		curOrgDestType = "O";
        	// Dest Via. sheet9
        	} else if (colName == "dest_rout_via_port_def_cd") {
        		routeObject = sheetObjects[8];
        		curPntViaType = "V";
        		curOrgDestType = "D";
            // Dest sheet10
        	} else if (colName == "dest_rout_pnt_loc_def_cd") {
        		routeObject = sheetObjects[9];
        		curPntViaType = "P";
        		curOrgDestType = "D";
        	}
        	
        	if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				formObj.cd.value = Value;
				var param =  "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + curOrgDestType;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					// Hidden. Route Sheet에 값을 보낸다.
					editRoutePntNViaSheet(routeObject, curPntViaType, curOrgDestType, arrData[0], arrData[1], "Edit");
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
				} else {
		    		sheetObj.CellValue2(Row, colName) = "";
		    		sheetObj.SelectCell(Row, colName, false);
		    		editRoutePntNViaSheet(routeObject, curPntViaType, curOrgDestType, "", "", "Delete");
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
        	} else {
        		sheetObj.CellValue2(Row, colName) = "";
        		editRoutePntNViaSheet(routeObject, curPntViaType, curOrgDestType, "", "", "Delete");
        	}
        /** R Term **/
        } else if(colName == "rcv_de_term_cd_ori") {
        	sheetObjects[6].CellValue2(1, "rcv_de_term_cd") = Value;
        /** D Term **/
        } else if(colName == "rcv_de_term_cd_dest") {
        	sheetObjects[9].CellValue2(1, "rcv_de_term_cd") = Value;
    	/** APP Charge **/
        } else if(colName == "bkg_dir_call_flg" || colName == "bkg_ts_port_def_cd" || colName == "bkg_slan_cd" || colName == "bkg_vvd_cd") {
        	// Direct Call
        	if(colName == "bkg_dir_call_flg") {
        		if (Value == "Y"){
        			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
        			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
        			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
        		} else {
        			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
        		}
        		
        	// T/S Port
        	} else if(colName == "bkg_ts_port_def_cd") {
        		if (Value.length == 5){
        			formObj.f_cmd.value = COMMAND24;
        			formObj.cd.value = Value;
        			var sParam = FormQueryString(formObj);
        			sParam += "&etc1="+formObj.svc_scp_cd.value;
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
    					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";
    					 						
    					//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
    					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
    					
    				}else{
      					sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = "";
      					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "";
      					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
      					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
    				}
        		} else {
					sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
        		}
        		
        		sheetObj.CellBackColor(Row,"bkg_ts_port_def_cd") = 0;
        		
        	} else if(colName == "bkg_slan_cd") {
    			if (Value.length == 3){
        			formObj.f_cmd.value = COMMAND26;
        			formObj.cd.value = Value;
        			var sParam = FormQueryString(formObj);
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
      				
      				if (arrData != null && arrData.length > 0) {
    					sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
    					}else{
      					sheetObj.CellValue2(Row,"bkg_slan_cd") = "";
      					sheetObj.SelectCell(Row,"bkg_slan_cd");
    					}
        		} else {
    					sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
    					sheetObj.SelectCell(Row, "bkg_slan_cd");  				
        		}
    			
        	} else if(colName == "bkg_vvd_cd") {
    			if (Value.length == 9){
    				
    				var vslCd 		= Value.substring(0,4);
    				var skdVoyNo 	= Value.substring(4,8);
    				var skdDirCd 	= Value.substring(8,9);
    						
        			var sParam = "f_cmd="+COMMAND27;
        			sParam += "&cd="+vslCd;
        			sParam += "&etc1="+skdVoyNo;
        			sParam += "&etc2="+skdDirCd;
      
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
      				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

      				if (arrData != null && arrData.length > 0) {
      					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= arrData[0];
    					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= vslCd;
    					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= skdVoyNo;
    					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= skdDirCd;
    					
    					}else{
    					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
    					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
    					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
    					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
    						sheetObj.SelectCell(Row, "bkg_vvd_cd");
      					
    					}
        		} else{
        			sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
    				sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
    				sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
    				sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
        			sheetObj.SelectCell(Row, "bkg_vvd_cd");
    					
        		}
        		
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
    function sheet3_OnPopupClick(sheetObj, Row, Col) {
		// Route가 모두 로드되지 않았으면, 이벤트를 무시한다.
        if (!LoadingComplete) {
            return;
        }
        
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        var sUrl = "/hanjin/ESM_PRI_2225.do?" + FormQueryString(document.form) + "&rout_seq=" + sheetObj.CellValue(Row,"rout_seq");

        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P" + "&rcv_de_term_cd=" + sheetObj.CellValue(Row,"rcv_de_term_cd_ori");
            
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2225", 980, 324, true);
            
            if (rtnVal == "O") {
                setSheetRowData(sheetObj, Row, Col);
            }
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2225", 980, 324, true);
            
            if (rtnVal == "O") {
            	setSheetRowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2225", 980, 324, true);
            
            if (rtnVal == "O") {
            	setSheetRowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P" + "&rcv_de_term_cd=" + sheetObj.CellValue(Row,"rcv_de_term_cd_dest");
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2225", 980, 324, true);
            
            if (rtnVal == "O") {
            	setSheetRowData(sheetObj, Row, Col);
            }
        }
        if(colName == "bkg_ts_port_def_cd") {
			var sUrl = "/hanjin/ESM_PRI_4026.do?";
			var sParam = "&location_cmd=L";
			
			var rtnVal = ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;
				sheetObj.SelectCell(Row, Col);
			}
        }
        if(colName == "bkg_slan_cd") {
			var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.toString();
				sheetObj.SelectCell(Row, Col);
			}
        }
        if(colName == "bkg_vvd_cd") {
			var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.toString();
				sheetObj.SelectCell(Row, Col);
			}
        }
        
    }
    
    
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * Check할 경우, 하위 Grid들도 모두 체크되고, Uncheck할 경우, 상위 Grid의 Check도 풀리도록 한다.
	 *
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet3_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(2, 5), 0, Row, Col);
        }
    }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet5_OnSearchEnd(sheetObj,ErrMsg) {
        if (ErrMsg == "") {
        	if (sheetObj.RowCount > 0) {
        		// APP인 경우 Edit 못하도록 한다.
            	for(var i=0; i<=sheetObj.RowCount; i++) {
            		// Direct Call 이 Y인 경우 T/S Port 변경 불가
            		if(sheetObj.CellValue(i, "bkg_dir_call_flg") == "Y") {
            			sheetObj.CellEditable(i, "bkg_ts_port_def_cd") = false;
            		} else {
            			sheetObj.CellEditable(i, "bkg_ts_port_def_cd") = true;
            		}
            	}
        	}
        	
        }
    }
    
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 달력 DIV를 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.06.18
     */
     function sheet5_OnPopupClick(sheetObj, Row, Col, Value) {
      var colname = sheetObj.ColSaveName(Col);
      var formObj = document.form;
      var pinkColor = sheetObj.RgbColor(255,192,203);
      
      	switch(colname)
      	{
//  	    	case "eff_dt":
//  	    		cal = new ComCalendarGrid();
//  	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
//  	    		break;
//  	    	case "exp_dt":
//  	    		cal = new ComCalendarGrid();
//  	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
//  	    		break;
  	    		
  	    	case "bkg_cmdt_def_cd":
  	    		var sUrl = "/hanjin/ESM_PRI_4027.do?"
  	   	    		sUrl += "commodity_cmd=CG";
  	   	    		sUrl += "&grp_cd="+PRI_RP_SCP;
  	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
  	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
  	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
  	   	    	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;	
  	  				//6자리일경우 COMMODITY CODE임
  	  				sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = rtnVal.tp;
  	  			}
  	  			break;
  	  			
  	    	case "bkg_por_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
  	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
  	  			sUrl += "&location_cmd=LGTCR";
  	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, "bkg_por_def_cd") = rtnVal.cd;
  	  				sheetObj.CellValue2(Row, "bkg_por_tp_cd") = rtnVal.tp;
  	  				
  	  				//State 일경우 배경에 분홍처리
  	  				if(rtnVal.tp == "T"){
  		 	  			sheetObj.CellValue2(Row, "bkg_por_cnt_cd") = rtnVal.cnt_cd;
  	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
  	  				} else {
  	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
  	  				}
  	  			}
  				break;
  				
  	    	case "bkg_pol_def_cd":
  	  			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
  	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
  	  			sUrl += "&location_cmd=LGTCR";
  	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, "bkg_pol_def_cd") = rtnVal.cd;
  	  				sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = rtnVal.tp;
  	  				//State 일경우 배경에 분홍처리
  	  				if(rtnVal.tp == "T"){
  		 	  			sheetObj.CellValue2(Row, "bkg_pol_cnt_cd") = rtnVal.cnt_cd;
  	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
  	  				} else {
  	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
  	  				}
  	  			}
  				break;
  				
  	    	case "bkg_pod_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
  	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
  	  			sUrl += "&location_cmd=LGTCR";
  	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, "bkg_pod_def_cd") = rtnVal.cd;
  	  				sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = rtnVal.tp;
  	  				//State 일경우 배경에 분홍처리
  	  				if(rtnVal.tp == "T"){
   	 	  				sheetObj.CellValue2(Row, "bkg_pod_cnt_cd") = rtnVal.cnt_cd;
  	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
  	  				} else {
  	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
  	  				}
  	  			}
  				break;
  				
  	    	case "bkg_del_def_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
  	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
  	  			sUrl += "&location_cmd=LGTCR";
  	
  	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
  	  			if (rtnVal != null){
  	  				sheetObj.CellValue2(Row, "bkg_del_def_cd") = rtnVal.cd;
  	  				sheetObj.CellValue2(Row, "bkg_del_tp_cd") = rtnVal.tp;
  	  				//State 일경우 배경에 분홍처리
  	  				if(rtnVal.tp == "T"){
   	 	  				sheetObj.CellValue2(Row, "bkg_del_cnt_cd") = rtnVal.cnt_cd;
  	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
  	  				} else {
  	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
  	  				}
  	  			}
  				break;
  				  				
  	    	case "bkg_ts_port_def_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4026.do?";
  				var sParam = "&location_cmd=L";
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026", 700, 325, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.cd;
  					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;			
  				}
  				break;	
  				
  	    	case "bkg_slan_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
  				}
  				break;		
  				
  	    	case "bkg_vvd_cd":	
  				var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
  					
  				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
  				if (rtnVal != null){
  					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
  					sheetObj.SelectCell(Row, Col);
  				}
  				break;	

    	    	case "bkg_yd_cd":
    				var bkgYdCd = sheetObj.CellValue(Row, Col);
    				var display = '0,0,1,1,1,1,1,1,1,1,1,1';
    				var param = '?mode=yard&node_cd='+bkgYdCd;
    				//공통사용 팝업 호출
    				ComPriOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'callBackTerminalCode', display, true);
    				break;
      	}    	 

     }
    
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 전지예
	 * @version 2016.04.22
	 */
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
        doRowChange(OldRow, NewRow, OldCol, NewCol);
    }

	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
    }

	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
    function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 승인 완료 후 호출 창에 action을 취해준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 전지예
     * @version 2016.05.03
     */
    function sheet4_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	//저장 후 후처리
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
//        	ComShowCodeMessage("PRI00108");
        	
//        	saveCurRowPos();
//        	reloadPagePostTr();
        }
        	
    }
    
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
    function sheet12_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			var noteCtnt = sheetObj.SelectRow <= 0 || sheetObj.RowStatus(sheetObj.SelectRow) == "D" || sheetObj.RowHidden(sheetObj.SelectRow) ? "" : sheetObj.CellValue(NewRow, "note_ctnt");
			var noteConvMapgId = sheetObj.SelectRow <= 0 || sheetObj.RowStatus(sheetObj.SelectRow) == "D" || sheetObj.RowHidden(sheetObj.SelectRow) ? "XXX" : sheetObj.CellValue(NewRow, "note_conv_mapg_id");
			
			ComPriSheetFilter(sheetObjects[11], "note_conv_mapg_id", noteConvMapgId);
			
			formObj.ta_note_ctnt.value = noteCtnt;
			if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I"
				&& sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") != "AD"
				&& sheetObj.RowHidden(sheetObj.SelectRow) != true) {
				document.form.ta_note_ctnt.readOnly = false;
				sheetObjects[11].Editable = true;
				for (var i = sheetObjects[11].HeaderRows; i <= sheetObjects[11].LastRow; i++) {	
					if(sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") == "AM") {
		 				sheetObjects[11].CellEditable(i, "chg_rule_def_cd") = false;
		 			} else {
		 				sheetObjects[11].CellEditable(i, "chg_rule_def_cd") = true;
		 			}
		 			noteConvDisableColumnValidation(sheetObjects[11], i, 2, sheetObjects[11].CellValue(i,"chg_rule_def_cd"));
		 			
			 		//Route 에서 State 코드일 경우 색상처리
			 		setStateColor(sheetObjects[11], i);
					
			 		//Rule Code 일 경우에는 색상을 지정
			 		//setChargeRuleColor(sheetObjects[11], i);
		 		}
			} else {
				document.form.ta_note_ctnt.readOnly = true;
				sheetObjects[11].Editable = false;
			}
			
//			buttonControlConv();
		}
		
		sheetObjects[11].Redraw = true;
		
		changeSelectBackColor4Rate(sheetObj);
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
    function sheet5_OnChange(sheetObj, Row, Col, Value) {	// Charge Term (Conversion)
	  	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		switch(colName)
	  	{
			case "chg_rule_def_cd":
				
				if (Value != null && Value != "" && Value.length == 3 && Value != "APP") { // APP Charge Code 손으로 직접 입력 못하게 막음
					//DEFAULT 데이터처리
					noteConvDefaultColumnValidation(sheetObj, Row, Col, Value);
					//컬럼 disable 처리
					noteConvDisableColumnValidation(sheetObj, Row, Col, Value);
					
					var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
					
					if (sCode.indexOf(Value) < 0) {
						formObj.f_cmd.value = COMMAND09;
						sXml = sheetObjects[11].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
						
						var arrData = ComPriXml2Array(sXml, "cd|nm");
						if (arrData != null && arrData.length > 0) {
							sCode += "|" + Value;
							sText += "|" + Value;
							sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
							
							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
						} else {
							sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
						}
					}
					
					insertChargeRuleType(sheetObj, Row);
				} else {
					sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
				}

				// Rule & Charge Code 색 구분
				//setChargeRuleColor(sheetObj, Row);
				break;
				
				
			case "eff_dt":	
				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				
				if(sheetObj.CellValue(Row, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(Row, "eff_dt") = effDt;
					sheetObj.SelectCell(Row,"eff_dt");
				}
				
				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.CellValue2(Row, "eff_dt") = effDt;
					sheetObj.SelectCell(Row,"eff_dt");
				}
				break;
				
			case "exp_dt":	
				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				
				if(sheetObj.CellValue(Row, "exp_dt") > expDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.CellValue2(Row, "exp_dt") = expDt;
					sheetObj.SelectCell(Row,"exp_dt");
				}
				
				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.CellValue2(Row, "exp_dt") = expDt;
					sheetObj.SelectCell(Row,"exp_dt");
				}
				break;
				
			case "bkg_prc_cgo_tp_cd":
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
						sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
					}
				}
				
				if(Value == "DG") {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
				} else {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
				}
				break;	
				
			case "bkg_cmdt_def_cd":	
				
				if (Value.length == 5) { //Group Commodity
					var propNo = formObj.prop_no.value;
					var amdtSeq = formObj.amdt_seq.value;
					var svcScpCd = formObj.svc_scp_cd.value;

					formObj.f_cmd.value = SEARCH10;
					formObj.cd.value = Value;
					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=rpscp");
					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
					if(arrData[1] != ""){
						sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") = Value;
						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = 'G';
					} else {
						sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
						sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
					}

				} else if (Value.length == 6) {
	    			formObj.f_cmd.value = SEARCH08;
	    			//COMMODITY CODE 앞에 '0'문자로 채움
	    			formObj.cd.value = ComLpad(Value, 6, "0");
	    			
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
					if (arrData[1] != "") {
						sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = Value;
						//6자리일경우 COMMODITY CODE임
						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "C";
					}else{
	  					sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
					}
				} else {
					sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
					sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
				}
				
	    		break;
	    		
			case "bkg_por_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_por_def_cd") = arrData[0];
//						getLocationTypeCode(sheetObj, Row, Col, Value.length);
						}else{
	  					sheetObj.CellValue2(Row,"bkg_por_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_por_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_por_def_cd") = "";
						sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "";
						sheetObj.SelectCell(Row, "bkg_por_def_cd") ; 				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
	    		break;	
	    		
			case "bkg_pol_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_pol_def_cd") = arrData[0];
//						getLocationTypeCode(sheetObj, Row, Col, Value.length);
						}else{
	  					sheetObj.CellValue2(Row,"bkg_pol_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_pol_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_pol_def_cd") = "";
						sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "";
						sheetObj.SelectCell(Row, "bkg_pol_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
	    		break;	
	    		
			case "bkg_pod_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_pod_def_cd") = arrData[0];
//						getLocationTypeCode(sheetObj, Row, Col, Value.length);
						}else{
	  					sheetObj.CellValue2(Row,"bkg_pod_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_pod_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_pod_def_cd") = "";
						sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "";
						sheetObj.SelectCell(Row, "bkg_pod_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
	    		break;	
	    		
			case "bkg_del_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_del_def_cd") = arrData[0];
//						getLocationTypeCode(sheetObj, Row, Col, Value.length);
						}else{
	  					sheetObj.CellValue2(Row,"bkg_del_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_del_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_del_def_cd") = "";
						sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "";
						sheetObj.SelectCell(Row, "bkg_del_def_cd");  				
	    		}
	    		sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
	    		break;	
	    		
			case "rt_appl_tp_cd":	
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				var rtOpCd = 	sheetObj.CellValue(Row, "rt_op_cd");

				// Application에서 Subject는 입력 못하도록 제어.
				if(Value == "S") {
					sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "";
				}
				
				if(Value == "A" || Value == "F") {
						sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
						sheetObj.CellValue2(Row, "curr_cd") 		= "USD";
						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
						sheetObj.CellEditable(Row, "rt_op_cd")		= true;
					sheetObj.CellEditable(Row, "curr_cd")		= true;
					sheetObj.CellEditable(Row, "frt_rt_amt")	= true;
					} else {
						sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
						sheetObj.CellValue2(Row, "curr_cd") 		= "";
						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
						sheetObj.CellEditable(Row, "rt_op_cd")		= false;
						sheetObj.CellEditable(Row, "curr_cd") 		= false;
						sheetObj.CellEditable(Row, "frt_rt_amt")	= false;
					}
					
					if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
						&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
						&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
						&& chgRuleDefCd != "RAC" ) {
			    		 					
						if( Value == "F") {
							sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
							sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
						}
						
						if( Value == "A") {
							sheetObj.CellValue2(Row, "curr_cd") 	= "";
							sheetObj.CellEditable(Row, "curr_cd") 	= false;
						}
						
		    		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
		    			if (Value == "I" || Value == "A"){ 	   
		    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
		    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
		    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
		    				sheetObj.CellValue2(Row, "curr_cd") 	= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
							
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
		    			} else if (Value == "S" || Value == "N"){
							sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
							sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
							sheetObj.CellValue2(Row, "curr_cd") 	= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
						} else {
							sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= true;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
							sheetObj.CellValue2(Row, "curr_cd") 	= "USD";
							sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
						}
		    		} else if(chgRuleDefCd == "NOT") {
		    			if (Value != "I" && Value != "N"){ 	   
		    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
		    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "I";
		    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
							sheetObj.CellValue2(Row, "curr_cd") 	= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
		    			}
		    		} else if(chgRuleDefCd == "APP") {
		    			if (Value != "S" && Value != "N"){ 	   
		    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
		    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
		    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
							sheetObj.CellValue2(Row, "curr_cd") 		= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
		    			}
		    		} else if(chgRuleDefCd == "TYP") {
		    			
		    			if (Value == "A"){ 	    	    				
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
							sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
		    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
		    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
		    			} else if (Value == "N"){ 	    	    				
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
							sheetObj.CellValue2(Row, "curr_cd") 	= "";
							sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
		    			} else {
		    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
		    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
							sheetObj.CellEditable(Row, "curr_cd") 				= false;
							sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
		    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
		    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
		    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
		    			}
		    		}
				
	    		break;
	    		
			case "rt_op_cd":
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				var rtApplTpCd = 	sheetObj.CellValue(Row, "rt_appl_tp_cd");
				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
										
					if( rtApplTpCd == "F") {
			    		if(Value == ">" || Value == "<" ) {
			    			ComShowCodeMessage("PRI00326");
			    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
			    			sheetObj.SelectCell(Row, "rt_op_cd");
			    		}
		    		}
				} else if(chgRuleDefCd == "RAR") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
				} else if(chgRuleDefCd == "RAP") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		} else if(chgRuleDefCd == "DOR") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		} else if(chgRuleDefCd == "TYP") {
					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		}
	    		break;	
	    		    		    		
			case "bkg_ts_port_def_cd":	    		
	    		if (Value.length == 5){
	    			formObj.f_cmd.value = COMMAND24;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_RP_SCP;
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
						sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";
						 						
						//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
						
					}else{
	  					sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = "";
	  					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
	  					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
						sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
						sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");  	
						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
	    		}
	    	
	    		sheetObj.CellBackColor(Row,"bkg_ts_port_def_cd") = 0;
	    		break;	
	    		
			case "bkg_dir_call_flg":
	    		if (Value == "Y"){
	    			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
	    			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
	    		} else {
	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
	    		}
	    		break;	
	    		
			case "bkg_slan_cd":
				if (Value.length == 3){
	    			formObj.f_cmd.value = COMMAND26;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
						}else{
	  					sheetObj.CellValue2(Row,"bkg_slan_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_slan_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
						sheetObj.SelectCell(Row, "bkg_slan_cd");  				
	    		}
	    		break;
	    		
			case "bkg_vvd_cd":
				if (Value.length == 9){
					
					var vslCd 		= Value.substring(0,4);
					var skdVoyNo 	= Value.substring(4,8);
					var skdDirCd 	= Value.substring(8,9);
							
	    			var sParam = "f_cmd="+COMMAND27;
	    			sParam += "&cd="+vslCd;
	    			sParam += "&etc1="+skdVoyNo;
	    			sParam += "&etc2="+skdDirCd;
	  
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= arrData[0];
						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= vslCd;
						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= skdVoyNo;
						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= skdDirCd;
						
						}else{
						sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
							sheetObj.SelectCell(Row, "bkg_vvd_cd");
	  					
						}
	    		} else{	
	    			sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
	    			sheetObj.SelectCell(Row, "bkg_vvd_cd");	
						
	    		}
	    		break;
	    		
			case "bkg_imdg_clss_cd":
				if (Value.length > 0){
	    			formObj.f_cmd.value = COMMAND30;
	    			formObj.cd.value = Value;
	    			var sParam = FormQueryString(formObj);
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

	  				if (arrData != null && arrData.length > 0) {
						sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = arrData[0];
						}else{
	  					sheetObj.CellValue2(Row,"bkg_imdg_clss_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
						}	  				
	    		}else{	 	
						sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
						sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");  				
	    		}
	    		break;
	    		
			case "curr_cd":
				var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
				if(chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD"){
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
	 	    			
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
	 					sheetObj.CellValue2(Row, "curr_cd") = "USD";
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
				}
	    		break;
	  	}
    }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet6_OnSearchEnd(sheetObj,ErrMsg) {
    	var formObj = document.form;
    	comboObjects[0].Code2 = sheetObj.CellValue(1,"svc_scp_cd");
    }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet12_OnSearchEnd(sheetObj,ErrMsg) {
    	var formObj = document.form;
        if (ErrMsg == "") {
        	if (sheetObj.RowCount > 0) {
        		formObj.note_conv_mapg_id.value = sheetObj.CellValue(1,"note_conv_mapg_id");
        	}
        }
    }
    
    
	// Row이동시 Validation결과 등에 따라 이동을 실행하고 취소하는 등의 처리를 위해 잠시 이벤트를 off하기 위해 사용하는 변수.
	// 사용하지않고 행이동 등을 처리할시 이벤트가 중첩하여 발생하여 꼬이는 현상이 나타난다.
    var isFiredNested = false;
    // GRI Calc등 전체화면 재조회시 이전에 선택되어진 행을 찾아가기 위해 잠시 이벤트를 off하기 위해 사용하는 변수.
    // 이를 사용하지 않고도 처리가능하나, 같은 그리드가 2번 조회되는 등의 문제가 발생한다.
    var isFiredNestedExt = false;
    // Row이동시 변경된 내용을 저장할때, Confirm메시지를 표시하지 않기 위한 지시자.
    var supressConfirm = false;
	/**
	 * Sheet에서 Row 변경되었을 때 이벤트를 처리할 함수. <br>
	 * Route & Summary 그리드에 대한 이벤트를 처리한다. doRowChange 함수 참조.
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 전지예
	 * @version 2016.04.22
	 */
	function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
//		alert(' init doRowChange()  isFiredNested : ' + isFiredNested + '  isFiredNestedExt ' + isFiredNestedExt + ' OldRow : ' + OldRow + ' NewRow ' + NewRow );
        // 중첩으로 발생한 이벤트이거나, 같은 행을 선택한 경우에는 처리하지 않는다.
		if (!isFiredNested && !isFiredNestedExt && (OldRow != NewRow)) {
//			alert(' sheetObj3  modifide :  ' +sheetObjects[3].IsDataModified );
			
			// Route & Summary의 OldRow에 수정된 사항이 있을 경우, 이를 처리하는 블럭.
            if (sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) != "D"
            	&& (sheetObjects[2].IsDataModified
		            || sheetObjects[3].IsDataModified
		            || sheetObjects[4].IsDataModified
		            || sheetObjects[6].IsDataModified
		            || sheetObjects[7].IsDataModified
		            || sheetObjects[8].IsDataModified
		            || sheetObjects[9].IsDataModified
		            || sheetObjects[11].IsDataModified)) {
            	// 이벤트를 끄고, Selected Row를 OldRow로 돌려놓고 시작한다.
            	// 지우는게 낫지 않나?
                isFiredNested = true;
                sheetObjects[2].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                	// 저장 수행. 저장할지를 물어보는 Confirm는 표시하지 않는다.
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetObjects[2].RowCount("D"), sheetObjects[2].HeaderRows);
                    rslt = doActionIBSheet(sheetObjects[2], document.form, IBSAVE);	// Save Rate
                    supressConfirm = false;
                }
                if (rslt) {
                	// 저장결과가 성공이면 NewRow로 이동한다. 단 RowAdd나 RowCopy일 경우에는 이동하지 않는다.
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested = true;
	                    sheetObjects[2].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                	// 저장결과가 실패이면 다시 OldRow로 돌아간다.
                    isFiredNested = true;
                    sheetObjects[2].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            }
            
            if (sAction == IBINSERT) {
                isFiredNested = true;
                var idx = sheetObjects[2].DataInsert();
                isFiredNested = false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested = true;
                var idx = sheetObjects[2].DataCopy();
                isFiredNested = false;
                return idx;
            } else {
                LoadingComplete = false;
                formObj.rout_seq.value = sheetObjects[2].CellValue(adjNewRow, "rout_seq");
                doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
                LoadingComplete = true;
            }
		}
	}
	
	/**
	 * Sheet Data를 XML형태로 변환하여 넘겨준다.<br>
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
        
        if (sheetNo == 3 || sheetNo == 4) {
            sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue = formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
        }

        sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        
        return sXml;
    }
    
	/**
	 * 재조회 후, 기존 선택된 행을 찾아가기 위해 현재 Row위치를 전역변수에 저장. reloadPagePostTr 함수와 같이 사용.
	 * 
	 * @returns 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function saveCurRowPos() {
        s2PrevRow = sheetObjects[2].SelectRow;
        s3PrevRow = sheetObjects[3].SelectRow;
        s4PrevRow = sheetObjects[4].SelectRow;
        s2PrevKey = sheetObjects[2].CellValue(s2PrevRow, "rout_seq");
        s3PrevKey = sheetObjects[3].CellValue(s3PrevRow, "rt_seq");
        s4PrevKey = sheetObjects[3].CellValue(s4PrevRow, "note_conv_seq");
    }
    
	/**
	 * 재조회. saveCurRowPos를 미리 호출하고 사용해야 기존 선택된 행을 찾아간다.
	 * 
	 * @param {int} sheetNo 선택 0:CMDT부터 1:Route부터 재조회. Default는 0.
	 * @returns 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function reloadPagePostTr(sheetNo) {
    	if (sheetNo == null || sheetNo == "" || sheetNo < 0) {
    		sheetNo = 2;
    	}
    	
    	// 하위그리드들이 이벤트를 타고 재조회 되는걸 막기위해 이벤트 플래그를 off한다.
    	isFiredNested = true;
    	isFiredNestedExt = true;
    	
    	if (sheetNo == 2) {
    		// Sheet2 재조회.
	    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
	    	if (sheetObjects[2].RowCount > 0) {
	    		// 미리 저장된 Sheet3의 선택된  Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
	        	if (s2PrevRow > sheetObjects[2].LastRow) {
	        		s2PrevRow = sheetObjects[2].LastRow;
	        	} else if (s2PrevRow <= 0) {
	        		s2PrevRow = 1;
	        	}
	        	// 미리 저장된 Row로 강제 이동한다.
	            sheetObjects[2].SelectRow = s2PrevRow;
	            sheetObjects[2].SelectCell(sheetObjects[2].SelectRow, sheetObjects[2].SelectCol, false);
	    	} else {
	    		isFiredNested = false;
	    		isFiredNestedExt = false;
	    		return;
	    	}
    	}
    	
    	// Sheet3의 이벤트를 다시 On.
    	isFiredNested = false;
    	
    	// Sheet3의 이벤트를 다시 On.
    	isFiredNestedExt = false;
    	
    	// Sheet3 OnSelectCell 이벤트 처리자를 호출하여, Sheet4를 조회.
    	doRowChange(-1, sheetObjects[2].SelectRow, sheetObjects[2].SelectCol, sheetObjects[2].SelectCol, IBSEARCH);
    	if (sheetObjects[3].RowCount > 0) {
    		// 미리 저장된 Sheet4의 선택된  Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
        	if (s3PrevRow > sheetObjects[3].LastRow) {
        		s3PrevRow = sheetObjects[3].LastRow;
        	} else if (s3PrevRow <= 0) {
        		s3PrevRow = 1;
        	}
        	// 미리 저장된 Row로 강제 이동한다.
        	sheetObjects[3].SelectRow = s3PrevRow;
        	sheetObjects[3].SelectCell(sheetObjects[3].SelectRow, sheetObjects[3].SelectCol, false);
    	} else {
    		return;
    	}
    }
    
	/**
	 * XML형태의 데이타를 Sheet에 Load한다.<br>
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
        
        if (sheetNo == 3 || sheetNo == 4) {
            bAppendMode = 1;
            sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue = formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
        }
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
    
	/**
	 * Route & Summary 에서 입력한 Route 정보를 Hidden Sheet에 반영한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {sheetObj} sheetObj 편집할 Hidden Route Sheet Object
	 * @param {String} curPntViaType P : Point, V : Via
	 * @param {String} curOrgDestType O : Origin, D : Destination
	 * @param {String} code Route Code
	 * @param {String} name Route Name
	 * @param {String} edit Edit 입력/수정, Delete 제거
	 * @author 전지예
	 * @version 2016.04.06
	 */
    function editRoutePntNViaSheet(sheetObj, curPntViaType, curOrgDestType, code, name, edit) {
    	var formObj = document.form;
    	var idx = sheetObj.SelectRow;
    	
    	if(edit == "Edit" || edit == "Insert") {
    		if(sheetObj.RowCount == 0) {
    			idx = sheetObj.DataInsert();
    		}
    		
    		sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
    		sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
    		sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
    		sheetObj.CellValue2(idx, "cmdt_hdr_seq") = 1;
    		sheetObj.CellValue2(idx, "org_dest_tp_cd") = curOrgDestType;
    		sheetObj.CellValue2(idx, "rout_seq") = formObj.rout_seq.value;
    		
    		if(curPntViaType == "P") {
    			sheetObj.CellValue2(idx, "rout_pnt_seq") = 1;
    			sheetObj.CellValue2(idx, "rout_pnt_loc_tp_cd") = "L";
    			sheetObj.CellValue2(idx, "rout_pnt_loc_def_cd") = code;
    			sheetObj.CellValue2(idx, "rout_pnt_loc_def_nm") = name;
    		} else if(curPntViaType == "V") {
    			sheetObj.CellValue2(idx, "rout_via_seq") = 1;
    			sheetObj.CellValue2(idx, "rout_via_port_tp_cd") = "L";
    			sheetObj.CellValue2(idx, "rout_via_port_def_cd") = code;
    			sheetObj.CellValue2(idx, "rout_via_port_def_nm") = name;
    		}
    		
    		sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
    		sheetObj.CellValue2(idx, "prc_prog_sts_nm") = "Initial";
    		sheetObj.CellValue2(idx, "src_info_cd") = "NW";
    		sheetObj.CellValue2(idx, "src_info_nm") = "New";
    		sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
    		sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;
    		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
    		
    		if(edit == "Insert") {
    			if(curOrgDestType == "O") {
    				sheetObjects[6].CellValue2(idx, "rcv_de_term_cd") = "Y"; // CY
    				
    			} else if(curOrgDestType == "D") {
    				sheetObjects[9].CellValue2(idx, "rcv_de_term_cd") = "Y"; // CY
    			}
    		}
    		
    	} else {
    		if(curPntViaType == "P") {
    			sheetObj.CellValue2(idx, "rout_pnt_loc_def_cd") = "";
    			sheetObj.CellValue2(idx, "rout_pnt_loc_def_nm") = "";
    		} else if(curPntViaType == "V") {
    			sheetObj.CellValue2(idx, "rout_via_port_tp_cd") = "";
    			sheetObj.CellValue2(idx, "rout_via_port_def_nm") = "";
    		}
    	}
    }
	

	/**
	 * Route & Summary의 Row가 삭제되었는지 확인. RowStatus와 취소선 여부로 판별한다.
	 * 
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function isRouteGroupDeleted(row) {
    	if (row == null  || row == "" || row == undefined) {
    		row = sheetObjects[2].SelectRow;
    	}
    	return (sheetObjects[2].RowStatus(row) == "D" || sheetObjects[2].CellFont("FontStrikethru", row, "org_rout_pnt_loc_def_cd") || sheetObjects[2].CellFont("FontStrikethru", row, "dest_rout_pnt_loc_def_cd"))
    }
    
	/**
	 * Route Group의 Row가 삭제되었는지 확인. 각 세부그리드의 Row수를 Count하여 판별하며,
	 * paramter로 주어지는 showMsg에 따라 메시지를 출력한다.
	 * 
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function isRouteGroupDeleted4Rate(showMsg) {
    	if (showMsg == null  || showMsg == "" || showMsg == undefined) {
    		showMsg = false;
    	}
        
    	if (getAmendValidRowCount(sheetObjects[6], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "Origin");
    		}
    		return true;
    	}
    	if (isOViaMandatory && getAmendValidRowCount(sheetObjects[7], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "O.Via");
    		}
    		return true;
    	}
    	if (isDViaMandatory && getAmendValidRowCount(sheetObjects[8], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "D.Via");
    		}
    		return true;
    	}
    	if (getAmendValidRowCount(sheetObjects[9], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "Dest.");
    		}
    		return true;
    	}
    	return false;
    }
    
    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * 이미지만 비활성 시키므로 processButtonClick()에서 클릭시 처리한다.
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
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
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
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+checkSheetObj.CellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
	       var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
   
// TODO CHECK 와 TEST 가 필요하다.
   function addOnTariffDurationCheck(amdt_seq, formObj) {
	    var rowCnt = getValidRowCount(sheetObjects[5]);
	    var ctrtEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
	    var ctrtExpDt = sheetObjects[0].CellValue(1, "ctrt_exp_dt");
	    var ctrtEffDtTo = ComGetUnMaskedValue(sheetObjects[0].CellValue(1, "ctrt_eff_dt"),"ymd");
	    var ctrtEffDtOri = ComGetUnMaskedValue(sheetObjects[0].CellValue(1, "ctrt_eff_dt_ori"),"ymd");
	    var sheet2 = sheetObjects[5];
	    
	    var excepSvcScpCd_Cnt = 0;
	    /**
	     * 202.05.25일 추가
	     * AMD No. == 0 이고 Status가 Initial 인 경우 저장 안되게...
	     * START
	     */
	    var propStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
	    var mnStatus = sheetObjects[0].RowStatus(1);         // 최초 insert시에는 해당 로직을 skip한다.   
	    if(amdt_seq == 0 && propStsCd == 'I'  ) {
	    	//예외 Service Scope만 가진 경우는 Duration Check 제외.
	    	if(excepSvcScpCd_Cnt != rowCnt ) {
		    	if(!saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, addOnEndExpDt, 'PRI07039')) {
		    		return false;
		    	}
		    	if(sheet2.FindText("svc_scp_cd", 'AEE') > -1 || sheet2.FindText("svc_scp_cd", 'AEW') > -1) {
		    		if(!saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, endExpDt, 'PRI07009')) {
		        		return false;
		        	}
		    	}
//		    	if(!checkDurationBeforeData()) {
//	    			return false;
//	    		}
	    	} 
	    }	             
	    
	    if (rowCnt <= 0){
	        ComShowCodeMessage('PRI01029'); 
	        return false;
	    }  
	    return true;     	
   }
   
   /** Port CY 운임에 입력한 Origin, Dest Location 을 체크하여 
    * MDM에 call_port_flg가 'N' 인 location 이 있을 경우 메시지를 보여줌 
    *
    **/
   function addOnTariffPortLocationCheck(){
   	 var formObj = document.form;
        var sheetObj = sheetObjects[0]        
        formObj.f_cmd.value = SEARCH21;         
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq")+ "&" + FormQueryString(formObj) ; 
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2203GS.do" , sParam);    
        var arrData = ComPriXml2Array(sXml, "etc1");
 
        if (arrData != null && arrData.length > 0) {  
       	 for(i=0; i < arrData.length;i++){
       		 if(i==0){
       			 arrData[i] = arrData[i];
       		 }else{
       			 arrData[i] = "\n " + arrData[i];
       		 }
       	 }        	 
       	 ComShowCodeMessage('PRI00308','input at "Rate of including IHC".\n', arrData );
       	 return false;
        } else {
    		return true; 
        } 
        return true;
   }
   
   /**
	 * Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
	 */
	function checkIHCRateAmt() {
       var formObj = document.form;
       var sheetObj = sheetObjects[0]
       var rValue = 'N';                          
       formObj.f_cmd.value = SEARCH20;
       var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ; 
       var sXml = sheetObj.GetSearchXml("ESM_PRI_2203GS.do" , sParam);
       rValue = ComGetEtcData(sXml, "RSLT");
       if(rValue != '') {
       	ComShowCodeMessage('PRI07024', rValue);
       	rValue = 'N';
       }  else {
       	rValue = 'Y';
       }
       return rValue;
	}
   
	/**
	 * Main Save시 Duration 체크
	 * @returns {Boolean}
	 */
   function saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, expiredDate, messageCode) {
   	if((ctrtEffDt < expiredDate && ctrtExpDt >= expiredDate) || (ctrtEffDt > expiredDate && ctrtExpDt <= expiredDate)) {
    		ComShowCodeMessage(messageCode); 		
   		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
   		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
   		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	  	            		
   		return false;
   	}            	
   	//2012-06-16 서미진
   	//DURATION EFF. DATE 7/01일 이전인 경우 7/1 이후로 변경 불가
   	
    	if(ctrtEffDtOri != '' && ctrtEffDtOri < expiredDate && ctrtEffDtTo >= expiredDate && mnStatus != 'I' ){
    		ComShowCodeMessage(messageCode); 		
   		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
   		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
   		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	            		
   		return false;
   	}
   	
   	//DURATION EFF. DATE 7/01일 이후인 경우 7/1 이전로 변경 불가
   	if(ctrtEffDtOri != '' && ctrtEffDtOri >= expiredDate && ctrtEffDtTo < expiredDate && mnStatus != 'I'){
    		ComShowCodeMessage(messageCode); 	
   		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
   		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
   		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
   		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	  	            		
   		return false;
   	}
   	return true;
   }
   
   /**
   * Terms가 모두 Accept 되었는지 확인한다.<br>
   * Approve 버튼 활성화와 Approve시 확인한다.<br> 
   * <br><b>Example :</b>
   * <pre>
   *		checkAccept();
   * </pre>
   * @param  없음
   * @return {string} <br>
   *          Y : 모두 Accept되었다.<br>
   *          N : 하나이상 Accept 안된 데이터가 있다.<br>
   * @author 공백진
   * @version 2009.05.07
   */  
   function checkAccept(){
       
   	var formObj = document.form;
       var sheetObj = sheetObjects[0]
       var rValue = "Y";// 모두 accept 되었다.
       formObj.f_cmd.value = SEARCH05;
       var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;                     
       var sXml = sheetObj.GetSearchXml("ESM_PRI_2203GS.do" , sParam);
       // [CHM-201538236] 미승인이 있는 경우가 메인(MN)인지 Scope(SCP)인지에 따라 값이 나오도록 수정 2015.10.26
       var arrData = ComPriXml2ComboString(sXml, "prop_no","prop_no");
       if (arrData !=null && arrData.length > 0){
       	//  Terms에 승인이 진행이 필요한 경우
       	if(arrData[0] == "SCP") {
       		rValue ="SCP";
       	// Duration, Free Time, Affiliate에 승인이 진행이 필요한 경우
       	} else {
       		rValue ="MN";
       	}
       }
       
       return rValue;
       
   }
   
   //BKG에 유효한 데이터가 있는지 조회한다.
   //BKG_Booking ,BKG_RATE 를 조회한다.
   
   /**
   * Approve Cancel시 BKG에 데이터가 있는지 조회한다.<br>
   * return 값이 N 일 경우 Approve Cancel 할 수 없다.<br> 
   * <br><b>Example :</b>
   * <pre>
   *		checkApproveCancel();
   * </pre>
   * @param  없음
   * @return {string} <br>
   *          Y : BKG에 데이터가 없다.<br>
   *          N : BKG에 데이터가 있다.<br>
   * @author 공백진
   * @version 2009.05.07
   */     
   function checkApproveCancel(){
       var formObj = document.form;
       var sheetObj = sheetObjects[0]
       var rValue = "N";//  Approve Cancel 을 할 수 없다.
               
       formObj.f_cmd.value = SEARCH14;
       var sParam = "rfa_no="+sheetObj.CellValue(1, "rfa_no")+"&eff_dt="
       +sheetObj.CellValue(1, "eff_dt")+"&exp_dt="+sheetObj.CellValue(1, "exp_dt")+"&"+FormQueryString(formObj);
       var sXml = sheetObj.GetSearchXml("ESM_PRI_2203GS.do" , sParam);

       var arrData = ComPriXml2Array(sXml, "cd|etc1");
       var strMsg = "";
       var chkData = "";
       if (arrData !=null && arrData.length > 0){
       	chkData = arrData[0][0];
       	for (var i = 1; i < arrData.length; i++){
       		if (i == 6){
       			strMsg += " ..."
       			break;
       		}else if (i !=1){
       			strMsg += ", "
       		}
       		strMsg+=arrData[i][0]
       	}        	
       }

       if (strMsg == "" && chkData == "OK"){
       	rValue ="Y";
       }else{
       	ComShowCodeMessage('PRI01107',strMsg);
       }
       return rValue;
       
   }
   
   /**
    * 작성자가 Request Cancel시 해당 데이터중 Accept,Returned인 데이터가 있는지 조회하여<br>
    * 한건이라도 데이터가 있다면 Request Cancel을 금지한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		checkRequestCancel();
    * </pre>
    * @param  없음
    * @return {string} <br>
    *          Y : Request Cancel할 수 있다.<br>
    *          N : Request Cancel할 수 없다.<br>
    * @author 공백진
    * @version 2009.05.07
    */  
   function checkRequestCancel(){
       var formObj = document.form;
       var sheetObj = sheetObjects[0];
       var rValue = "N";                          
       formObj.f_cmd.value = SEARCH19;
       
       try{
           var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
           sParam += "&" + FormQueryString(formObj);
           var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);            
           var arrData = ComPriXml2Array(sXml, "cnt");
           
           if (arrData != null && arrData.length > 0) {
         	  if (arrData[0][0] == "0" ){
         		  rValue = "Y";	
               }  
           }        	
       	  if (rValue == "N"){
       		  ComShowCodeMessage("PRI01129");
       	  }
       } catch (e) {
 		  	if (e == "[object Error]") {
 		          ComShowMessage(OBJECT_ERROR);
 		      } else {
 		          ComShowMessage(e);
 		      }
 		  	rValue = "N";
       }finally{
     	  return rValue;
       }       
               
   }
   
	/**
	 * 재조회가 없는 CUD후, CMDT & Route Group의 폰트색상 및 취소선표시 등을 처리. 
	 * 
	 * @param {boolean} reloadAll 선택 CMDT Group그리도 전체 행에 대해 처리할지 여부. Default는 false.
	 * @returns 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
  function restylingPagePostTr(reloadAll) {
  	var formObj = document.form;
//  	alert('init restylingPagePostTr ' + reloadAll);
  	
  	if (formObj.amdt_seq.value == "0") {
  		return true;
  	}
  	
  	var routCurRow = sheetObjects[2].SelectRow;
  	sheetObjects[sheetObjects.length - 1].WaitImageVisible = false;
  	
      formObj.f_cmd.value = SEARCH15;
      var param = FormQueryString(formObj);
      param += "&reload_all=N";
      if (reloadAll) {	// CMDT전체에 대해 조회.
      	param += "&reload_all=Y";
      } else {			// 현재 선택된 row만 조회.
      }
      var sXml = sheetObjects[sheetObjects.length - 1].GetSearchXml("ESM_PRI_2003_07GS.do" , param);
      // arrXml의 0번째 요소 : CMDT Group XML, 1번째 요소 : Route Group XML
      var arrXml = sXml.split("|$$|");
      
      // Route Group 그리드에 대해 스타일 적용
      if (arrXml.length > 1) {
    	  var arrTemp = ComPriXml2Array(arrXml[1], "nd_cnt|na_cnt|up_cnt");
    	  
    	  if (arrTemp != null && arrTemp.length > 0) {
    		  var ndCnt = parseInt(arrTemp[0][0]);
    		  var naCnt = parseInt(arrTemp[0][1]);
    		  var upCnt = parseInt(arrTemp[0][2]);
    		  
    		  // 하위항목이 모두 삭제된 경우 취소선 처리.
    		  if (ndCnt == 0) {
    			  sheetObjects[2].CellFont("FontStrikethru", routCurRow, 1, routCurRow, sheetObjects[2].LastCol) = true;
    		  } else {
    			  sheetObjects[2].CellFont("FontStrikethru", routCurRow, 1, routCurRow, sheetObjects[2].LastCol) = false;
    		  }
    		  
    		  // Accept되지 않는 하위항목이 존재하는 경우 font-color = red
    		  if (naCnt == 0) {
    			  // 하위에 수정된 항목이 존재하고, 그 항목들이 모두 Accept되었을 경우, font-color : blue 
    			  if (upCnt == 0) {
    				  sheetObjects[2].RowFontColor(routCurRow) = sheetObjects[2].RgbColor(0,0,0);
    			  } else {
    				  sheetObjects[2].RowFontColor(routCurRow) = sheetObjects[2].RgbColor(0,0,255);
    			  }
    		  } else {
    			  sheetObjects[2].RowFontColor(routCurRow) = sheetObjects[2].RgbColor(255,0,0);
    		  }
    	  }
      }
      
      // 기존 선택된 row와 현재 선택된 row가 다를 경우  Sheet4 재조회.
      if (s2PrevKey != sheetObjects[2].CellValue(routCurRow, "rout_seq")) {
    	  doRowChange(-1, sheetObjects[2].SelectRow, sheetObjects[2].SelectCol, sheetObjects[2].SelectCol, IBSEARCH);
      }
      
//      sheetObjects[sheetObjects.length - 1].WaitImageVisible = true;
      
      // 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
      changeSelectBackColor4Rate(sheetObjects[2]);
  }
   
	/**
	 * 선택된 Row에 대해 Amend or Amend Delete 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function doRowAmend(sheetObj, sAction) {
		var idx = sheetObj.DataCopy();
		var prevIdx = idx - 1;
		
		sheetObj.CellValue2(idx, "eff_dt") = document.form.eff_dt.value;
		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = document.form.amdt_seq.value;
		sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
		sheetObj.CellValue2(idx, "prc_prog_sts_nm") = "Initial";
		sheetObj.CellValue2(idx, "src_info_cd") = sAction;
		if (sAction == "AM") {
			sheetObj.CellValue2(idx, "src_info_nm") = "Amend";
		} else if (sAction == "AD") {
			sheetObj.CellValue2(idx, "src_info_nm") = "Delete";
		}
		
		sheetObj.CellValue2(prevIdx, "exp_dt") = sheetObjects[0].CellValue(1, "pre_exp_dt");
		sheetObj.CellValue2(prevIdx, "amdt_seq") = sheetObjects[0].CellValue(1, "pre_amdt_seq");
		
		sheetObj.RowStatus(prevIdx) = "R";
		sheetObj.RowStatus(idx) = "U";
		
		return idx;
   }
   
	/**
	 * 선택된 Row에 대해 Amend Cancel 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function doRowAmendCancel(sheetObj) {
   		var idx  = sheetObj.SelectRow;
		var prevIdx = idx - 1;
		
		if (sheetObj.CellValue(idx, "ibflag") != "I") {
			sheetObj.CellValue2(prevIdx, "exp_dt") = document.form.exp_dt.value;
			sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value;
			// 이 부분은 Amend와 Amend Cancel을 반복할 경우, 저장이 안되는 경우를 위한 코드.
			// 이는 IBSheet에서 Amend Cancel시  다시 원복된 값이 조회당시 값과 같다고 인식해서 row의 status를 R로 인식하는 문제. 
			if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
				sheetObj.RowStatus(prevIdx) = "U";
			}
		}
		sheetObj.RowDelete(idx, false);
		
		return prevIdx;
   }
   
	/**
	 * 특정 row, 또는 Sheet전체에 대해 setLineStyle, setLineEnable함수를 호출하여
	 * 라인의 스타일(폰트색상, 취소선 등)을 만들어준다.
	 * setLineStyle은 메인화면의 함수를 팝업들이 공통적으로 같이 이용하며,
	 * setLineEnable은 각 화면이나 팝업별로 따로 구현되어 있다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setSheet4Style(sheetObj, idx) {
       if (idx == null || idx < 0) {
           for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
           	setLineStyle(sheetObj, i);
           	setLineEnable(sheetObj, i);
           }
       } else {
       	setLineStyle(sheetObj, idx);
       	setLineEnable(sheetObj, idx);
       }
   }
   
	/**
	 * CMDT & Route Group 데이터가 삭제된 경우 삭제표시를 한다.(Amend Seq. 1 이상인 경우에만)
	 * n1st_cmnc_amdt_seq를 -1로 박아주는 것은 서버에서 그룹단위로 삭제됨을 인식하여 처리하기 위함. 
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setHdrLineDeleted(sheetObj, idx) {
		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = "-1";
		sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
		sheetObj.RowFontColor(idx) = sheetObj.RgbColor(255,0,0);
   }
   
	/**
	 * Note Convesrsion Sheet에서 조회 후, 색상이나 Strike등의 스타일을 처리하는 함수.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setSheet5Style(sheetObj, idx) {
	   	if (sheetObj.RowCount <= 0) {
	   		return;
	   	}
	   	
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
        	    setLineStyle(sheetObj, i);
        	    
              	// APP Chage Term은 편집 불가능하게 한다.
               	if(sheetObj.CellValue(i, "note_conv_rule_cd") == "APP") {
            		sheetObj.RowEditable(i) = false;
            	} else {
            		setLineEnable4Conv(sheetObj, i);
            	}
            }
        } else {
    	    setLineStyle(sheetObj, idx);
          	
          	// APP Chage Term은 편집 불가능하게 한다.
           	if(sheetObj.CellValue(idx, "note_conv_rule_cd") == "APP") {
        		sheetObj.RowEditable(idx) = false;
        	} else {
        		setLineEnable4Conv(sheetObj, idx);
        	}
        }
   }
   
	/**
	 * 주어진 로우에 대해 스타일(색상, 취소선 등)을 적용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setLineStyle(sheetObj, idx) {
   	if (idx <= 0) {
   		return false;
   	}
   	
   	if (sheetObj.RowStatus(idx) == "D") {
   		sheetObj.RowHidden(idx) = true;
   	}
   	
   	// Proposal단계 일 경우 색상처리를 하지 않는다.
   	if (document.form.amdt_seq.value == "0") {
   		return true;
   	}
   	
   	// 이전Seq의 데이터는 Amend된 데이터로 간주하고, 취소선을 긋고, Row를 수정불가로 한다.
   	// 다만 RFA는 RowEditable메쏘드를 이용해 전체 Row를 Uneditable로 처리하고,
   	// S/C의 경우는 Note쪽에서 Conversion화면을 띠워야 하므로 루프를 돌면서 컬럼단위로 Uneditable 처리한다.
   	if (sheetObj.CellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
			sheetObj.RowEditable(idx) = false;
			
			return true;
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.RowEditable(idx) = true;
   	}
   	
   	// 이번 회차의 데이타(Insert or Amend)는 font-color를 red로 표시.
   	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
			sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
   	} else {
   		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
   	}
   	
   	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
   	changeSelectBackColor4Rate(sheetObj);
   }
   
	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리.
	 * 이 함수는 Sheet4(Rate)를 위한 것이고, 각 팝업마다 같은 이름의 함수들이 각 sheet에 맞게 정의되어 있다.
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setLineEnable(sheetObj, idx) {
   	if (idx <= 0) {
   		return false;
   	}
   	
   	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
		   		&& document.form.prc_prop_sts_cd.value == "I"
		   		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
        	sheetObj.CellEditable(idx, "rat_ut_cd") = true;
        	sheetObj.CellEditable(idx, "prc_cgo_tp_cd") = true;
        	sheetObj.CellEditable(idx, "curr_cd") = true;
        	sheetObj.CellEditable(idx, "prop_frt_rt_amt") = true;
		} else {
	       	sheetObj.CellEditable(idx, "rat_ut_cd") = false;
	       	sheetObj.CellEditable(idx, "prc_cgo_tp_cd") = false;
	       	sheetObj.CellEditable(idx, "curr_cd") = false;
           if ((bIsReqUsr)
               	&& document.form.prc_prop_sts_cd.value == "R"
               	&& sheetObj.CellValue(idx, "prc_prog_sts_cd") == "R") {
           	sheetObj.CellEditable(idx, "prop_frt_rt_amt") = true;
           } else {
           	sheetObj.CellEditable(idx, "prop_frt_rt_amt") = false;
           }
		}
   	
//       if (bIsAproUsr
//       	&& document.form.prc_prop_sts_cd.value == "Q"
//       	&& sheetObj.CellValue(idx, "prc_prog_sts_cd") != "A") {
//       	sheetObj.CellEditable(idx, "coffr_frt_rt_amt") = true;
//       } else {
//       	sheetObj.CellEditable(idx, "coffr_frt_rt_amt") = false;
//       }
       
       sheetObj.MinimumValue(idx, "prop_frt_rt_amt") = 0.00;
//       sheetObj.MinimumValue(idx, "coffr_frt_rt_amt") = 0.00;
   }
   
	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리<br>
	 * Note Conversion 전용.
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function setLineEnable4Conv(sheetObj, idx) {
   	if (idx <= 0) {
   		return false;
   	}

   	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
   		&& document.form.prc_prop_sts_cd.value == "I"
   		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
				sheetObj.CellEditable(idx,"chg_rule_def_cd") = true;
				sheetObj.CellEditable(idx,"rt_appl_tp_cd") = true;
				sheetObj.CellEditable(idx,"curr_cd") = true;
				sheetObj.CellEditable(idx,"rt_op_cd") = true;
				sheetObj.CellEditable(idx,"frt_rt_amt") = true;
				sheetObj.CellEditable(idx,"pay_term_cd") = true;
				sheetObj.CellEditable(idx,"bkg_rat_ut_cd") = true;
				sheetObj.CellEditable(idx,"bkg_prc_cgo_tp_cd") = true;
				sheetObj.CellEditable(idx,"bkg_dir_call_flg") = true;
				sheetObj.CellEditable(idx,"bkg_ts_port_def_cd") = true;
				sheetObj.CellEditable(idx,"bkg_slan_cd") = true;
				sheetObj.CellEditable(idx,"bkg_vvd_cd") = true;
				sheetObj.CellEditable(idx,"bkg_yd_cd") = true;
				sheetObj.CellEditable(idx,"bkg_min_cgo_wgt") = true;
				sheetObj.CellEditable(idx,"bkg_max_cgo_wgt") = true;
		} else {
			sheetObj.CellEditable(idx,"chg_rule_def_cd") = false;
			sheetObj.CellEditable(idx,"rt_appl_tp_cd") = false;
			sheetObj.CellEditable(idx,"curr_cd") = false;
			sheetObj.CellEditable(idx,"rt_op_cd") = false;
			sheetObj.CellEditable(idx,"frt_rt_amt") = false;
			sheetObj.CellEditable(idx,"pay_term_cd") = false;
			sheetObj.CellEditable(idx,"bkg_rat_ut_cd") = false;
			sheetObj.CellEditable(idx,"bkg_prc_cgo_tp_cd") = false;
			sheetObj.CellEditable(idx,"bkg_dir_call_flg") = false;
			sheetObj.CellEditable(idx,"bkg_ts_port_def_cd") = false;
			sheetObj.CellEditable(idx,"bkg_slan_cd") = false;
			sheetObj.CellEditable(idx,"bkg_vvd_cd") = false;
			sheetObj.CellEditable(idx,"bkg_yd_cd") = false;
			sheetObj.CellEditable(idx,"bkg_min_cgo_wgt") = false;
			sheetObj.CellEditable(idx,"bkg_max_cgo_wgt") = false;
		}
   	
   	if (sheetObj.CellValue(idx, "amdt_seq") == document.form.amdt_seq.value) {
   		// true
   	} else {
   		// false
   	}
   }
   
   /**
    * Note Conversion의 CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
    * 
    * <br><b>Example :</b>
    * <pre>
    *	checkConvNoteMandatoryValidation(sheetObj, Row);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.02
    */ 	
 	function checkConvNoteMandatoryValidation(sheetObj, Row) {
    	
 		var rowCount = sheetObj.RowCount; 		
 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 		
		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
			
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
			//} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
	 				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
	 			ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
			}
		} else if (chgRuleDefCd == "APP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} 
		} else if (chgRuleDefCd == "NOT") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}  			
		} else if (chgRuleDefCd == "RAS") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001) {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} 
		} else if (chgRuleDefCd == "ARB") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}
		} else if (chgRuleDefCd == "ADD") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}
		} else if (chgRuleDefCd == "TYP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "" && sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
				ComShowCodeMessage("PRI00325","Per","Cargo Type");
				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAR") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_por_def_cd") == "" && sheetObj.CellValue(Row, "bkg_pol_def_cd") == "" 
				 && sheetObj.CellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.CellValue(Row, "bkg_del_def_cd") == "") {
				//POR, POL,POD,DEL중 1개이상 입력 				 				
				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
				sheetObj.SelectCell(Row, "bkg_por_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_cmdt_def_cd") == "") {
				ComShowCodeMessage("PRI00316","Commodity");
				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "DOR") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			}
		} 

		return true;
 	}
 	

    /**
     * CODE항목 선택시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	noteConvDisableColumnValidation(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */           
    function noteConvDisableColumnValidation(sheetObj, Row, Col, Value) {
  	
  	initColumnEditable(sheetObj, Row, Col, Value);
  	
 	switch(Value)
   	{
  		case "APP":	
  			sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= false;
  			//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
  			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
  			sheetObj.CellEditable(Row, "curr_cd") 					= false;
  			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
  			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
  			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= false;
  			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= false;
			break;
			
  		case "NOT":	
  			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
  			sheetObj.CellEditable(Row, "curr_cd") 					= false;
  			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
  			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
			break;
				
  		case "RAS":	
  			
  			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
  			sheetObj.CellEditable(Row, "curr_cd") 					= false;
  			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
			break;
				
		case "ARB":	
			//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

			if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
	    		
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
			}
			break;
			
		case "ADD":
			//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

			if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
	    		
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
			}
			break;
			
		case "TYP":
			//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "curr_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
			break;
			
		case "RAR":
			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "curr_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
			break;
			
		case "RAP":
			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "curr_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
			break;
			
		case "DOR":
			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "curr_cd") 					= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
			break;
			
		default:  //SURCHARGE 												
	    	if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
				|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
	    		
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
			} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
			} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
			}
			break;
   		}
	 }
    
    /**
     * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	initColumnEditable(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */           
    function initColumnEditable(sheetObj, Row, Col, Value) {    	   
 	   	sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= true;
   	   	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= true;
   	   	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= true;
			
   	   	if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd")		= true;
   	   	} else {
   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") 		= false;
   	   	}
		sheetObj.CellEditable(Row, "rt_op_cd") 					= true;
		sheetObj.CellEditable(Row, "curr_cd") 					= true;
		sheetObj.CellEditable(Row, "frt_rt_amt") 				= true;
		sheetObj.CellEditable(Row, "pay_term_cd") 				= true;
		sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= true;
		sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= true;
		sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= true;
		sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= true;
		sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= true;
		
		sheetObj.CellEditable(Row, "bkg_slan_cd") 				= true;
		sheetObj.CellEditable(Row, "bkg_vvd_cd") 				= true;
		sheetObj.CellEditable(Row, "bkg_soc_flg") 				= true;
		sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= true;
		
		if(sheetObj.CellValue(Row, "bkg_ts_port_def_cd") != "") {
			sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= false;
		} else {
			sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= true;
		}
		
		if(sheetObj.CellValue(Row, "bkg_dir_call_flg") == "Y") {
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= false;
		} else {
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= true;
		}	

		sheetObj.CellEditable(Row, "bkg_yd_cd") 				= true;
		sheetObj.CellEditable(Row, "bkg_esvc_tp_cd") 			= true;
     }
     
 	
    /**
     * Note Conversion의 CODE항목 선택시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	noteConvDefaultColumnValidation(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */ 	
 	function noteConvDefaultColumnValidation(sheetObj, Row, Col, Value) {
  	 	
     	initColumnValue(sheetObj, Row);
     	
  		switch(Value)
      	{	
  			case "TYP":
  				sheetObj.CellValue2(Row, "curr_cd") 			= "";
  				sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 		= "D4";
  				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";	
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "A";
  				break;
  				
  			case "NOT":
  				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "I";			
  				break;
  			
  			case "RAS":
  				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			case "RAR":
  				sheetObj.CellValue2(Row, "curr_cd") 			= "";
  				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			case "RAP":
  				sheetObj.CellValue2(Row, "curr_cd") 			= "";
  				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			case "DOR":
  				sheetObj.CellValue2(Row, "curr_cd") 			= "";
  				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			case "ARB":
//  				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
  				//sheetObj.CellValue2(Row, "curr_cd") 			= "USD";
  				//sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				//sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			case "ADD":
//  				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
  				//sheetObj.CellValue2(Row, "curr_cd") 			= "USD";
  				//sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				//sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  				
  			default:
//  				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
  				break;
  				
      	}
   	}
 	
    /**
     * 데이터를 초기화하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	initColumnValue(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */ 	
     	function initColumnValue(sheetObj, Row) {
     		
     		sheetObj.CellValue2(Row, "rt_appl_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "rt_op_cd") 						= "";
     		sheetObj.CellValue2(Row, "curr_cd") 						= "";
     		sheetObj.CellValue2(Row, "frt_rt_amt") 					= "";
     		sheetObj.CellValue2(Row, "pay_term_cd") 					= "";
     		sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") 			= "";
     		sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_por_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_por_def_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_pol_def_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_pod_def_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_del_tp_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_del_def_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_slan_cd") 					= "";
     		sheetObj.CellValue2(Row, "bkg_vsl_cd") 					= "";
     		sheetObj.CellValue2(Row, "bkg_skd_voy_no") 				= "";
     		sheetObj.CellValue2(Row, "bkg_skd_dir_cd") 				= "";
     		sheetObj.CellValue2(Row, "bkg_soc_flg") 					= "";
     		sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") 			= "";
     		sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") 			= "";
     		sheetObj.CellValue2(Row, "bkg_dir_call_flg") 				= "";

     		sheetObj.CellValue2(Row, "bkg_vvd_cd") 					= "";

     		sheetObj.CellValue2(Row, "bkg_hngr_bar_tp_cd") 			= "";
     		sheetObj.CellValue2(Row, "bkg_min_cgo_wgt") 				= "";
     		sheetObj.CellValue2(Row, "bkg_max_cgo_wgt") 				= "";
     		sheetObj.CellValue2(Row, "bkg_yd_cd") 					= "";
     		sheetObj.CellValue2(Row, "bkg_esvc_tp_cd") 				= "";
      	}
 	
	/**
	 * Conversion Note Duration 의 Validation function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 최성민
	 * @version 2009.07.15
	 */ 
	function checkConvDuration(sheetObj) {
		var formObj = document.form;
		
		for (var a = sheetObjects[11].HeaderRows; sheetObjects[11].RowCount > 0 && a <= sheetObjects[11].LastRow; a++) {
			if (sheetObjects[11].RowHidden(a) == true) {
				continue;
			}
			if (sheetObjects[11].CellValue(a, "amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			if (sheetObjects[11].CellValue(a, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			
			var noteConvMapgId = sheetObjects[11].CellValue(a, "note_conv_mapg_id");
			
			for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "note_conv_mapg_id") == noteConvMapgId) {
					if (sheetObj.RowStatus(i) == "D") {
						continue;
					}
					
					if (sheetObj.CellValue(i, "eff_dt") < formObj.eff_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					
					if (sheetObj.CellValue(i, "eff_dt") > sheetObj.CellValue(i, "exp_dt")) {
						ComShowCodeMessage("PRI00306");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					
					if (sheetObj.CellValue(i, "exp_dt") > formObj.exp_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "exp_dt", false);
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
    /**
     * SHEET ROW를 멀티 복사하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copyNoteConvSheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.03.23
     */	
 	function copyNoteConvSheetData(sheetObj) {
	    
  		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
  		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
  		var sCheckRow = sheetObj.FindCheckedRow("chk");
		if(sCheckRow == ""){
			sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
		}
		sCheckRow = sheetObj.FindCheckedRow("chk");	
		
 		var aCheckArr = ComRtrim(sCheckRow, '|').split("|");
 		
 		if(aCheckArr != null && aCheckArr.length > 0) {
 			for(var i=aCheckArr.length-1; i>=0; i--) {
 				sheetObj.SelectRow = aCheckArr[i];
 				var idx = sheetObj.DataCopy();
      			sheetObj.CellValue2(idx, "note_conv_seq") 	= maxSeq;      	
      			sheetObj.CellValue2(idx, "chk") = 0;

      			// State 색 구분
      			setStateColor(sheetObj, idx);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObj, idx);
      			   
      			maxSeq++;
 			}
 		}
 	}
 	
  	/**
       * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
       * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
       * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
       * <br><b>Example :</b>
       * <pre>
       *	insertChargeRuleType(sheetObj);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */	
  	function insertChargeRuleType(sheetObj, Row) {
  		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
  		
  		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
  			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
  			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
  			
  			//CHARGE
  			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
  			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
  			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
  		} else {
  			//RULE
  			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
  			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
  			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
  		}
  	}
  	
  	/**
  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State 색 구분
 		var pinkColor = sheetObj.RgbColor(255,192,203);
 		
		if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 		}
		
		if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
 		} 		
 	
 	}
 	
  	/**
  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 색 구분
 		var sCodeColor = sheetObj.RgbColor(255,200,200);
 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
	 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
 		} 
 	}

 	/**
     * OnChange 이벤트 발생시 호출되는 function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     */  	
    function sheet4_OnChange(sheetObj, Row, Col, Value) {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form;
     	
     	switch(colname)  //SEL160547
     	{
 	    	case "prop_frt_rt_amt":
 	    		//[요건청]//RFA 효율화를 위한 요청 (1차) (CHM-201640671) 
 	    		//GRI Cal. 사용 여부로 보여줄 필요는 없고 Amount 변동값으로 표시 요망.
 	    		//A 가 아닌 경우에는 아래 값으로 Diff. 를 보여줌. 현재 업데이트 Amount - Prev Amount
 	    		//[처리방법] 현재의 값 - (현재 ROW - 1 ) = 값을   gri_appl_amt 에 입력 , gri_appl_tp_cd 는 빈값
 	    		if( sheetObj.CellValue(Row,"src_info_cd")  == "AM" &&  sheetObj.CellValue(Row,"gri_appl_tp_cd")  == "A" &&  sheetObj.CellValue(Row,"next_n1st_cmnc_amdt_seq")  == "" ) { //현재 AM + GRI 적용일 경우.
 	    			sheetObj.CellValue2(Row,"gri_appl_tp_cd") = "M";
 	 	    		sheetObj.CellValue2(Row,"gri_appl_amt") = ( Value - sheetObj.CellValue(Row-1,"prop_frt_rt_amt") );
 	    		} else if( sheetObj.CellValue(Row,"src_info_cd")  == "AM" && (sheetObj.CellValue(Row,"gri_appl_tp_cd") == "N" || sheetObj.CellValue(Row,"gri_appl_tp_cd") == "" ) &&  sheetObj.CellValue(Row,"next_n1st_cmnc_amdt_seq")  == "" ) {  //현재 AM (수동으로 AMD 되었을 경우)
 	    			sheetObj.CellValue2(Row,"gri_appl_tp_cd") = "";
 	 	    		sheetObj.CellValue2(Row,"gri_appl_amt") = ( Value - sheetObj.CellValue(Row-1,"prop_frt_rt_amt") );
 	    		}  
// 	    		else if(sheetObj.CellValue(Row,"src_info_cd")  == "NW"  && ( sheetObj.CellValue(Row,"gri_appl_tp_cd") == "A" || sheetObj.CellValue(Row,"gri_appl_tp_cd") == "M" ) ) {
// 	    			sheetObj.CellValue2(Row,"gri_appl_tp_cd") = "M";
// 	 	    		sheetObj.CellValue2(Row,"gri_appl_amt") = Value ;
// 	    		}
 	    		
 	    		break;
     	}
    }
    
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet4_OnSearchEnd(sheetObj,ErrMsg) {
    	var formObj = document.form;
        for(var i = 1 ; i < sheetObj.Rows; i++) {
        	if(sheetObj.CellValue(i,"src_info_cd")  == "AM"  && sheetObj.CellValue(i,"gri_appl_tp_cd") == "A" &&  sheetObj.CellValue(i,"next_n1st_cmnc_amdt_seq")  == "" ) {
        		sheetObj.CellValue2(i,"gri_appl_tp_cd") = "A";
	    		sheetObj.CellValue2(i,"gri_appl_amt") = sheetObj.CellValue(i,"gri_appl_amt");     
        	} else if(sheetObj.CellValue(i,"src_info_cd")  == "AM"  && sheetObj.CellValue(i,"gri_appl_tp_cd") == "M" &&  sheetObj.CellValue(i,"next_n1st_cmnc_amdt_seq")  == "" ) {
     			sheetObj.CellValue2(i,"gri_appl_tp_cd") = "M";
	    		sheetObj.CellValue2(i,"gri_appl_amt") = ( sheetObj.CellValue(i,"prop_frt_rt_amt") - sheetObj.CellValue(i-1,"prop_frt_rt_amt") );     
            } else if(sheetObj.CellValue(i,"src_info_cd")  == "AM"  && (sheetObj.CellValue(i,"gri_appl_tp_cd") == "N" || sheetObj.CellValue(i,"gri_appl_tp_cd") == "" ) &&  sheetObj.CellValue(i,"next_n1st_cmnc_amdt_seq")  == "") {
     			sheetObj.CellValue2(i,"gri_appl_tp_cd") = "";
	    		sheetObj.CellValue2(i,"gri_appl_amt") = ( sheetObj.CellValue(i,"prop_frt_rt_amt") - sheetObj.CellValue(i-1,"prop_frt_rt_amt") );     
            } 
//            else if(sheetObj.CellValue(i,"src_info_cd")  == "NW"  && sheetObj.CellValue(i,"gri_appl_tp_cd") == "M") {
//            	//조회시 Rate 내용 중 AMEND 면서 GRI 적용 이후 Manual 로 금액을 변경한 내용이 있을 시 사용.
//     			sheetObj.CellValue2(i,"gri_appl_tp_cd") = "M";
//	    		sheetObj.CellValue2(i,"gri_appl_amt") =  sheetObj.CellValue(i,"prop_frt_rt_amt") ;     
//            } 
        	
        	sheetObj.RowStatus(i) = "R";
        }
    }
    	
    	