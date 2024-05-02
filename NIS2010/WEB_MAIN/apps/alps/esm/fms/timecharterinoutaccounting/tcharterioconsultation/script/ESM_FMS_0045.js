/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0045.js
*@FileTitle : Sublet Revenue Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.24 최우석
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 eng_keypress에서 uppernum으로세팅
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
     * @class esm_fms_0045 : esm_fms_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0045() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initControl			= initControl;
    	this.obj_blur				= obj_blur;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.setVslCd				= setVslCd;
    	this.setContractNo			= setContractNo;
    	this.sheet1_OnClick			= sheet1_OnClick;
    	this.inputReadOnly			= inputReadOnly;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //2017.05.15 contract type 콤보로 변경
    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	    var sheetObject = sheetObjects[0];
	    var sheetObject1 = sheetObjects[1];
	
	    /*******************************************************/
	    var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_Retrieve":
						if(validateForm(sheetObject,formObject,IBSEARCH)) {
							if(form.to_inv_no1.value == "") {
								form.to_inv_no.value = "";
							} else {
								form.to_inv_no.value = form.to_inv_no1.value;
							}
							form.curr_cd.value = "";
							form.csr_amt.value = "";
							sheetObject1.RemoveAll();
							doActionIBSheet(sheetObject,document.form,IBSEARCH);
						}
						break;
	
					case "btn_New":
						ComResetAll();
						inputReadOnly();
						break;

					case "btn_vslCd":
	     				ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0022");
	     				break;

	    			case "btn_fletCtrtNo":
	    				if(form.vsl_cd.disabled == true) {
	    					return;
	    				}
	    				
	     				if(formObject.vsl_cd.value == "") {
	     					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
	     					return;
	     				}
	     				var param = "typeFlag=" + "TO" + "&vsl_cd=" + formObject.vsl_cd.value;
	     				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 405, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0023");
	     				break;

	    			case "btn_condition":
	    				inputReadOnly();
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

	//2017.05.15 contract type 콤보로 변경
	function setComboObject(combo_obj){          
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
	
	    	//khlee-시작 환경 설정 함수 이름변경
	        ComConfigSheet (sheetObjects[i] );
	
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	        
	        sheetObjects[i].ExtendLastCol = false;
	    }
	    
	    initControl();
	    
	    inputReadOnly();
	    
	    //2017.05.15 contract type 콤보로 변경
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "ComCd");
    }

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
	    var cnt = 0;
	    var sheetID = sheetObj.id;
	    switch(sheetID) {
	    	
	        case "sheet1":
	            with (sheetObj) {
	
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 3, 100);
	 
	                var HeadTitle1 = "Seq|Invoice No.|VVD CD|Currency|CSR Amount|CSR Description";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	 
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtSeq,	30,		daCenter,	true,	"Seq");
	                InitDataProperty(0, cnt++, dtData,  120,	daCenter,	false,	"to_inv_no",	false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++, dtData,  120,	daCenter,	false,	"vvd_cd",		false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++, dtData,  100,	daCenter,	true,	"csr_curr_cd",	false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++, dtData,  120,	daRight,	true,	"csr_amt",		false,	"",	dfNullFloat,	2,	false,	true);
	                InitDataProperty(0, cnt++, dtData, 	400,	daLeft,		true,	"csr_desc",		false,	"",	dfNone,			0,	false,	true);

	                DataLinkMouse("to_inv_no") = true;
	                DataLinkMouse("vvd_cd") = true;
	                DataLinkMouse("csr_curr_cd") = true;
	                DataLinkMouse("csr_amt") = true;
	                DataLinkMouse("csr_desc") = true;
	            }
	            break;
	    	
	        case "sheet2":
	            with (sheetObj) {
	
	                // 높이 설정
	                style.height = 260;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msAll;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 2, 3, 100);

	                var HeadTitle1 = "Seq|Acct Code|Vendor Code|Vendor Code|Center Code|City|Effective Date|Slip Amount";
	                var HeadTitle2 = "Seq|Description|Description|Description|Description|Description|VVD Code|Key Number";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                cnt = 0;
	                InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,	true,	"Seq");
	                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	true,	"acct_cd",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,     		40,		daCenter,	false,	"cust_cnt_cd",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,     		90,		daCenter,	false,	"cust_seq",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"ctr_cd",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"slp_loc_cd",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"eff_dt",		false,	"",	dfDateYmd,		0,	false,	false);
	                InitDataProperty(0, cnt++, dtData,   		110,	daRight,	false,	"csr_amt",		false,	"",	dfFloat,		2,	false,	false);
	
	                cnt = 0;
	                InitDataProperty(1, cnt++, dtSeq,			30,		daCenter,	true,	"Seq1");
	                InitDataProperty(1, cnt++, dtData,     		125,	daLeft,		true,	"csr_desc",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,     		40,		daCenter,	false,	"csr_desc1",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,     		90,		daCenter,	false,	"csr_desc2",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"csr_desc3",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"csr_desc4",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"vvd_cd",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(1, cnt++, dtData,   		110,	daCenter,	false,	"to_inv_no",	false,	"",	dfNone,			0,	false,	false);
	                
	                DataRowMerge(0) = true;
	                DataRowMerge(1) = true;
	            }
	            break;
	    }
	}

    /**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, objNm) {
	
		sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	    	case IBSEARCH:      //조회
	    		//2017.05.15 contract type 콤보로 변경
	    		/*
		    	if(objNm == "flet_ctrt_tp_nm") {
		 			formObj.f_cmd.value = SEARCH04;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do", FormQueryString(formObj));
		   			var ctrtType = ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.flet_ctrt_tp_nm.value = ctrtType;
					}
				} else
				*/
	    		
				if(objNm == "vsl_cd") {
	    			formObj.f_cmd.value = SEARCH01;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
	
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				form.flet_ctrt_no.value = "";
	     				//form.flet_ctrt_tp_nm.value = "";		//2017.05.15 contract type 콤보로 변경
	     				initDefaultContractNo(); //선박 대 계약 자동 매치
					} else {
						formObj.vsl_cd.value = "";
						form.flet_ctrt_no.value = "";
	     				//form.flet_ctrt_tp_nm.value = "";		//2017.05.15 contract type 콤보로 변경
						// 존재하지 않는 Vessel Code입니다
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
					}
				} else if(objNm == "vvd_cd") {
					formObj.f_cmd.value = SEARCH06;
					var param = "f_cmd=" + formObj.f_cmd.value + "&vvd_cd=" + formObj.vvd_cd.value;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
					if(CoFmsShowXmlMessage(sXml) != "") {
						formObj.vvd_cd.value = "";
						ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
					}
				} else if(objNm == "ComCd") {		//2017.05.15 contract type 콤보로 변경
					
					sheetObj.WaitImageVisible = false;
					
					formObj.f_cmd.value = SEARCH04;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
		   			
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
	    				var comboCode = fletCtrtTpCd;
	    				var comboText = fletCtrtTpNm;

	    				setDataCombo(comboObjects[0], comboText, comboCode);
	    			}
		   			
		   			sheetObj.WaitImageVisible = true;
		   			
				} else {
					if(validateForm(sheetObj,formObj,sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value = SEARCH;
							sheetObj.DoSearch("ESM_FMS_0045GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("sheet1_")));
						} else if(sheetObj.id == "sheet2") {
							formObj.f_cmd.value = SEARCH01;
							sheetObj.DoSearch("ESM_FMS_0045GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("sheet2_")));
						}
					}
				}
	    		break;

	    	case IBSAVE:        //저장
	    		if(validateForm(sheetObj,formObj,sAction))
	    			alert (" Save .. ");
	            break;
	
	    	case IBINSERT:      // 입력
	            break;
	            
	    	case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치			
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdTO; 
				
				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");		//2017.05.15 contract type 콤보로 변경
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
					formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;		//2017.05.15 contract type 콤보로 변경
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
	   			
	   			//2017.05.15 contract type 콤보로 변경
				/*
	   			if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				*/
	   			
				break;    
	    }
	}

	/**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
	function validateForm(sheetObj,formObj,sAction) {
	    var exptElems = "";
	    if(form.btn_condition[0].checked) {
	    	exptElems = "vvd_cd|to_inv_no1";
	    } else  if(form.btn_condition[1].checked) {
	    	exptElems = "to_inv_no1|vsl_cd|flet_ctrt_no";
	    } else  if(form.btn_condition[2].checked) {
	    	exptElems = "vsl_cd|flet_ctrt_no|vvd_cd";
	    }

	    if (!ComFmsChkValid(formObj, exptElems)) {
	    	return false;
	    }
		 
	    return true;
	}

	/**
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 	 **/
 	function initControl() {
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('blur'		, 'obj_blur'	, form);	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
 		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
 		axon_event.addListenerForm  ('change'	, 'obj_change'	, form); 	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
 	}
 	
 	/**
     * HTML Control의 ondeactivate이벤트에서 Validation을 체크한다.<br>
     **/
    function obj_blur(){
    	ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     **/
     //2010.11.24 이상민 vsl_cd는 upper --> uppernum
    function eng_keypress() {
    	if(event.srcElement.name == "csr_curr_cd") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper');
    	}else if(event.srcElement.name == "vsl_cd") {
    		//대소영문자숫자 자동변환
    		ComKeyOnlyAlphabet('uppernum');
    	}else if(event.srcElement.name == "vvd_cd") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
    	} else if(event.srcElement.name == "to_inv_no1") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
    	}
    }
    
    /**
     * HTML Control의 onchange이벤트에서 Vessel Code의 Validation을 체크한다.<br>
     */
	function obj_change() {
		if((event.srcElement.name == "vsl_cd")) {
			if(form.vsl_cd.value.length == 4) {
		    	form.vsl_eng_nm.value = "";
		    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
			}
		}
	}
	
	/**
 	 * Vessel Code 팝업창에서 선택한 Vessel정보를 Form항목에 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setVslCd(aryPopupData) {
 		form.vsl_cd.value = aryPopupData[0][2];
 		form.vsl_eng_nm.value = aryPopupData[0][3];
 		
 		//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
		}
 	}
 	
 	/**
	 * Contract Code 팝업창에서 선택한 Contract No.을 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];		//2017.05.15 contract type 콤보로 변경
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
		
		//contract_no_change();		//2017.05.15 contract type 콤보로 변경
	}
	 
	//선박 대 계약 자동 매치
	//2017.05.15 contract type 콤보로 변경
	/*
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
    }
    */
	
    //선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
    
	/**
	 * Invoicd No에 해당하는 상세정보를 조회한다.<br>
	 */ 
	function sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
		form.to_inv_no.value = sheetObj.CellValue(row, "to_inv_no");
		form.curr_cd.value = sheetObj.CellValue(row, "csr_curr_cd");
		form.csr_amt.value = ComAddComma(sheetObj.CellValue(row, "csr_amt"), 2);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
	
	/**
	 * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
	 **/
    function inputReadOnly() {
    	if(form.btn_condition[0].checked) {
    		form.vsl_cd.disabled = false;
   			form.vsl_cd.className = "input";
   			
	    	document.images["btn_vslCd"].name = "btn_vslCd";
	    	form.btn_vslCd.style.cursor = "hand";
	    	document.images["btn_fletCtrtNo"].name = "btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor = "hand";
	    	
	    	form.vvd_cd.disabled = true;
   			form.vvd_cd.value = "";
   			form.vvd_cd.className = "input2";

	    	form.to_inv_no1.disabled = true;
   			form.to_inv_no1.value = "";
   			form.to_inv_no1.className = "input2";
   			
   			//2017.05.15 contract type 콤보로 변경
   			form.flet_ctrt_tp_cd.Enable = true;
   			
   			if(form.vsl_cd.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}
    		
    	} else if(form.btn_condition[1].checked) {
    		form.vvd_cd.disabled = false;
   			form.vvd_cd.className = "input";
    		
   			form.vsl_cd.disabled = true;
   			form.vsl_cd.value = "";
   			form.vsl_cd.className = "input2";
   			
	    	document.images["btn_vslCd"].name = "no_btn_vslCd";
	    	form.btn_vslCd.style.cursor = "default";
	    	document.images["btn_fletCtrtNo"].name = "no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor = "default";
	    	
	    	form.to_inv_no1.disabled = true;
   			form.to_inv_no1.value = "";
   			form.to_inv_no1.className = "input2";
   			
   			form.vsl_eng_nm.value = "";
   			form.flet_ctrt_no.value = "";
   			
   			//2017.05.15 contract type 콤보로 변경
   			//form.flet_ctrt_tp_nm.value = "";
   			form.flet_ctrt_tp_cd.Code2 = "";
   			form.flet_ctrt_tp_cd.Enable = false;
   			
   			if(form.vvd_cd.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}

    	} else if(form.btn_condition[2].checked) {
    		form.to_inv_no1.disabled = false;
   			form.to_inv_no1.className = "input";
    		
    		form.vsl_cd.disabled = true;
   			form.vsl_cd.value = "";
   			form.vsl_cd.className = "input2";
   			
	    	document.images["btn_vslCd"].name = "no_btn_vslCd";
	    	form.btn_vslCd.style.cursor = "default";
	    	document.images["btn_fletCtrtNo"].name = "no_btn_fletCtrtNo";
	    	form.btn_fletCtrtNo.style.cursor = "default";
	    	
	    	form.vvd_cd.disabled = true;
   			form.vvd_cd.value = "";
   			form.vvd_cd.className = "input2";
   			
   			form.vsl_eng_nm.value = "";
   			form.flet_ctrt_no.value = "";
   			
   			//2017.05.15 contract type 콤보로 변경
   			//form.flet_ctrt_tp_nm.value = "";
   			form.flet_ctrt_tp_cd.Code2 = "";
   			form.flet_ctrt_tp_cd.Enable = false;
   			
   			if(form.to_inv_no1.value == "") {
   				sheetObjects[0].RemoveAll();
   				sheetObjects[1].RemoveAll();
   			}
   			
    	}
    }
    
    /**
     * Sheet1에 OnSearchEnd 이벤트 발생시 첫번째 Row의 상세정보를 조회한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
		form.to_inv_no.value = sheetObj.CellValue(1, "to_inv_no");
		form.curr_cd.value = sheetObj.CellValue(1, "csr_curr_cd");
		form.csr_amt.value = ComAddComma(sheetObj.CellValue(1, "csr_amt"), 2);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		
		ComColFontName(sheetObj, "vvd_cd", "Courier New");
  	}
    
    /**
     * Sheet2에 OnSearchEnd 이벤트 발생시 VVD Code, City의 Font를 변경한다.<br>
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	for(var i=2; i<=sheetObj.LastRow; i++) {
    		if(i%2 > 0) {
    			sheetObj.CellFont("FontName", i, "vvd_cd") = "Courier New";
    		} else {
    			sheetObj.CellFont("FontName", i, "slp_loc_cd") = "Courier New";
    		}
    	}
    }
    
    //2017.05.15 contract type 콤보로 변경
    function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[1];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
        } 
    }

    //2017.05.15 contract type 콤보로 변경
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		
		if(form.vsl_cd.value == "") return;	
	
		var f_query = "";					
		f_query += "f_cmd=" + SEARCH01; 
		f_query += "&vsl_cd="+form.vsl_cd.value;	 			
		f_query += "&type_flag="+text;  
	
		var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
		var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
			
		if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
			form.flet_ctrt_no.value = varFletCtrtNo;
		}else{
			ComShowCodeMessage("FMS20001","Agreement");
			clearAll();
			return;
		}
			
	}
	/* 개발자 작업  끝 */