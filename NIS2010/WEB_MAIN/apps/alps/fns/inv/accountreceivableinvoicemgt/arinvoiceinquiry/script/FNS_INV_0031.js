/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0031.js
*@FileTitle : Invoice Inquiry by Date & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
	 * @class fns_inv_0031 : fns_inv_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0031() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;

	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrive":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;

				case "btn_new":
					removeAll(formObject);
				break;

				case "btn_downExcel":
					sheetObject1.SpeedDown2Excel(-1);
				break;
				
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.from_date, 'yyyy-MM-dd');
	            break;
	            
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.to_date, 'yyyy-MM-dd');
	            break;
				
				case "btns_cust1": //CUST information 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					//ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=600');
					ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 900, 650, 'getFNS_INV_0013', '1,0,1,1,1', false, false);
				break;
				
				case "btns_cust2": //CUST quick search 조회버튼 (팝업에서 조회된 정보 넘겨줌)
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
				break;
				
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.port.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
				break;
				
				case "btns_SCP": //SCP 조회버튼
					var v_svc_scp_cd = formObject.scope.value;
					var classId = "COM_ENS_0L1";
					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
			
					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 455, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function loadPage() {
		sheet1 = sheetObjects[0];
		sheetCnt = sheetObjects.length ;
		
		// combo
		combo1 = comboObjects[1];
		comboCnt = comboObjects.length;
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1,'G');
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		var formObj = document.form;

		doActionIBSheet(sheet1, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		date_option_OnChange('G');
		
		formObj.from_date.focus();
	}

	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initSheet(sheetObj,sheetNo,headType) {
		var formObject = document.form;
		
		var cnt = 0;
		var dpPrcsKntLocal = formObject.dp_prcs_knt_local.value;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;
		
		var setDpPrcsKnt = "";
		if (Number(dpPrcsKntLocal) > Number(dpPrcsKnt)) {
			setDpPrcsKnt = dpPrcsKntLocal;
		}
		else {
			setDpPrcsKnt = dpPrcsKnt;
		}
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 380;
					
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					var HeadTitle = "";
					
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						if (headType == "G") {
							HeadTitle = "|Seq|Good Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Proforma Invoice No.|Auto|Issue Date|User ID|CGST|SGST|UGST|IGST";
						}
						else if(headType == "I"){
							HeadTitle = "|Seq|I/F Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Proforma Invoice No.|Auto|Issue Date|User ID|CGST|SGST|UGST|IGST";
						}
						else if(headType == "E"){															
							HeadTitle = "|Seq|Eff. Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Proforma Invoice No.|Auto|Issue Date|User ID|CGST|SGST|UGST|IGST";														
						}															
						else if(headType == "A"){															
							HeadTitle = "|Seq|S/A Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Proforma Invoice No.|Auto|Issue Date|User ID|CGST|SGST|UGST|IGST";														
						}	
					} else {
						if (headType == "G") {
							HeadTitle = "|Seq|Good Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Auto|Issue Date|User ID";
						}
						else if(headType == "I"){
							HeadTitle = "|Seq|I/F Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Auto|Issue Date|User ID";
						}
						else if(headType == "E"){															
							HeadTitle = "|Seq|Eff. Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Auto|Issue Date|User ID";														
						}															
						else if(headType == "A"){															
							HeadTitle = "|Seq|S/A Date|Office|Bound|Type|VVD|S/A Date|POL|POD|Cust Code|Cust Name|B/L No|I/F No|Ex Rate.|Local Amount|Invoice No.|Auto|Issue Date|User ID";														
						}	
					}

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,  false,    "Seq");
					InitDataProperty(0, cnt++ , dtData,    		75,   	daCenter,  false,	"good_date",	false,    "",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,    		55,     daCenter,  false,	"ar_ofc_cd",	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		45,     daCenter,  false,	"io_bnd_cd",	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		45,  	daCenter,  false,	"type",     	false,    "",	dfNone);
					
					InitDataProperty(0, cnt++ , dtData,    		80,     daCenter,  false,	"vvd",     		false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		75,		daCenter,  false,	"sail_arr_dt",	false,    "",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,    		55,		daCenter,  false,	"pol_cd",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		55,		daCenter,  false,	"pod_cd",     	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		75,  	daCenter,  false,	"customer",   	false,    "",	dfNone);
					
					InitDataProperty(0, cnt++ , dtData,    		145,  	daLeft,    false,	"cust_nm",   	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		95,		daCenter,  false,	"bl_src_no",    false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		85,		daCenter,  false,	"ar_if_no",     false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		90,		daRight,   false,	"inv_xch_rt",	false,    "",	dfNullFloat, 6);
					
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,    	110,	daRight,   false,	"lcl_amt",		false,    "",	dfNullFloat, setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,    	110,	daRight,   false,	"lcl_amt",		false,    "",	dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,    		120,	daCenter,  false,	"inv_no",  	   	false,    "",	dfNone);
					
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						InitDataProperty(0, cnt++ , dtData,    		125,	daCenter,  false,	"pro_inv_no",  	   	false,    "",	dfNone);
					}
					
					InitDataProperty(0, cnt++ , dtData,    		75,	daCenter,  false,	"auto_inv_iss_flg",  	   	false,    "",	dfNone);
					InitDataProperty(0, cnt++ , dtData,    		75,		daCenter,  false,	"iss_dt",  	   	false,    "",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,    		60,		daCenter,  false,	"upd_usr_id",   false,    "",	dfNone);
					
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						InitDataProperty(0, cnt++ , dtData,    	80,	daRight,   false,	"ida_cgst_amt",		false,    "",	dfNullFloat, 2);
						InitDataProperty(0, cnt++ , dtData,    	80,	daRight,   false,	"ida_sgst_amt",		false,    "",	dfNullFloat, 2);
						InitDataProperty(0, cnt++ , dtData,    	80,	daRight,   false,	"ida_ugst_amt",		false,    "",	dfNullFloat, 2);
						InitDataProperty(0, cnt++ , dtData,    	80,	daRight,   false,	"ida_igst_amt",		false,    "",	dfNullFloat, 2);
					}
					
					FrozenCols = 2;
					
					CountPosition = 2;
					
					WaitImageVisible=false;
				}
			break;
		}
	}
 
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
			break;
			case "issue_flag":
				with (comboObj) {
					InsertItem(0, "All",    	"A");
		            InsertItem(1, "Issue",   	"Y");
		            InsertItem(2, "Not Issue",  "N");
		            
		            Code = "A";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			case "rev_tp_cd":
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "B/L",    "B");
		            InsertItem(2, "C/A",    "C");
		            InsertItem(3, "MRI",    "M");
		            
		            //Code = "A";
		            
		    		MultiSelect = true;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
		    		
		            CheckCode("A") = true;
				}
			break;
			case "inv_clr_flg":
				with (comboObj) {
					InsertItem(0, "N",    "N");
		            InsertItem(1, "Y",    "Y");
		            
		            Code = "N";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			case "bound":
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "O/B",    "O");
		            InsertItem(2, "I/B",    "I");
		            
		            Code = "A";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;
			
			case "rev_src_cd":
				with (comboObj) {
					InsertItem(0, "All",    "");

		    		MultiSelect = true;
		    		UseCode = true;

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;		    		
		            CheckCode("") = true;
				}
			break;
			
		}
  	}

  	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		//axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
	}

	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
			
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
			
			case "engup":
				switch(event.srcElement.name){
					case "act_cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
					
	    	        case "act_cust_seq":	    	        	
	    	        	// 숫자만입력하기
	        	        ComKeyOnlyNumber(event.srcElement);
					break;
					
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;

	    	        case "scope":
	    	        	//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
					
					case "port":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
				}
			break;
			
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
            break;
            
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			case "to_date":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			default:
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":	        	
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					var valueCustSeq = formObject.act_cust_seq.value;
					formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
				else {
					formObject.cust_nm.value = '';
				}
	        break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 장문석
	 * @version 2009.05.04
	 */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value) {
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
			break;
	    }
	}

	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;
	 		
			// 날짜 입력 input 뒤에 콤보박스가 올 경우 에러 메시지 2회 표시됨. 이를 방지하기 위해서 더미 input으로 처리한다. 
			case "date_blank":
				var dateOption = formObject.date_option.value;
				var dtBlank = event.srcElement.value;
				
				if (dtBlank == 'blank') {
					if (dateOption == 'I') {
						formObject.good_flag.focus();
					}
					else {
						formObject.ar_ofc_cd.focus();
					}
				}
	 		break;

			case "act_cust_cnt_cd":
				var actCustCntCd = ComReplaceStr(event.srcElement.value,"-","");
				
				if (actCustCntCd.length == 2) {
					formObject.act_cust_seq.focus();
				}
	 		break;
	 	}
	}

	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
		var rtnStr = "Delay Time \n"; // <- 테스트후 삭제처리
		try{ // <- 테스트후 삭제처리
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.office.value = arrStr2[1];
	     			
	     			var dateOption = formObj.date_option.value;
	     			
                    sheetObjects[0].RemoveAll();
		 			ComOpenWait(true);
					
                    formObj.bl_count.value = "";
                    formObj.usd_total.value = "";
                    formObj.lcl_total.value = "";
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0031GS.do", FormQueryString(formObj));
	     			
		 			// 소수점 자리수 설정
		 			formObj.dp_prcs_knt_local.value = ComGetEtcData(sXml,"dp_prcs_knt_local");
		 			formObj.dp_prcs_knt.value = ComGetEtcData(sXml,"dp_prcs_knt");
	     			
	     			var blCount = ComGetEtcData(sXml, "bl_count");
	     			if (blCount != undefined) {
		     			formObj.bl_count.value = ComAddComma(blCount);
	     			}
	     			else {
		     			formObj.bl_count.value = "0";
	     			}
	     			
	     			var usdTotal = ComGetEtcData(sXml, "usd_total");
	     			if (usdTotal != undefined) {
		     			formObj.usd_total.value = ComAddComma(ComRound(usdTotal, 2));
	     			}
	     			else {
		     			formObj.usd_total.value = "0";
	     			}
	     			
	     			var lclTotal = ComGetEtcData(sXml, "lcl_total");
	     			if (lclTotal != undefined) {
		     			formObj.lcl_total.value = ComAddComma(ComRound(lclTotal, formObj.dp_prcs_knt_local.value));
	     			}
	     			else {
		     			formObj.lcl_total.value = "0";
	     			}
	 				
                    sheetObjects[0].Reset();
		 			initSheet(sheetObjects[0], 1, dateOption);
		 			
	     			
	     			sheetObj.LoadSearchXml(sXml);
	     			
	     			ComOpenWait(false); 

	     			
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH02;
 				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		
 				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
 				var arrStr = sStr.split("|");
		
 				MakeComboObject(formObj.ar_ofc_cd, arrStr);
		
 				var arrStr2 = arrStr[1].split("^");
 				var ar_ofc_cd = arrStr2[3];
 				formObj.ar_ofc_cd.text = ar_ofc_cd;
 			break;
 			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.office.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
	
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
				
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.cust_seq, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
			break;
		}
		}catch(e){ // <- 테스트후 삭제처리 시작
			alert(rtnStr);
		} // <- 테스트후 삭제처리 끝
	}
	
	// <- 테스트후 삭제처리
	function textarea_write(msg){
		document.form.SEARCH_LOG.value = 	document.form.SEARCH_LOG.value+"\n"+msg;
	}

	/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 **/
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	   	var formObj = document.form;
	   	
	   	if (Col == '17') {
	   		ComUserPopup(sheetObj.CellValue(sheetObj.SelectRow, "upd_usr_id"));
	   	}
	   	else {
	   		var type = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "type"), " ", "");
	   		var blSrcNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "bl_src_no"), " ", "");
	   		var arIfNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_if_no"), " ", "");
			var arOfcCd = formObj.ar_ofc_cd.text;
			
			var classId = "";
			var param = "";
			
			/**
			 *[Type 필드값의 첫번째 문자가 "M"  인 경우]
			 * UI_INV-0011
			 *[Type 필드값의 "MTH" 이 아닌 경우]
			 * UI_INV-0022
			 *[Type 필드값의 "MTM" 이 아닌 경우]
			 * UI_INV-0071-01, UI_INV-0071-02,
			 *[Type 필드값의 첫번째 문자가 "M" 이 아닌 경우]
			 * UI_INV-0016-01, UI_INV-0016-02
			 **/
			if (type.substring(0,1) == 'M') {
				if (type == 'MTH') {
					classId = "FNS_INV_0022";
					param = '?pgmNo=FNS_INV_0022&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
					
					ComOpenWindow('/hanjin/FNS_INV_0022.do' + param, 'FNS_INV_0022', 'width=1000,height=600');
				}
				else if (type == 'MTM') {
					classId = "FNS_INV_0071";
					param = '?pgmNo=FNS_INV_0071-01&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
									
					ComOpenWindow('/hanjin/FNS_INV_0071.do' + param, 'FNS_INV_0071', 'width=1000,height=585');
				}
				else {
					classId = "FNS_INV_0011";
					param = '?pgmNo=FNS_INV_0011-01&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
									
					ComOpenWindow('/hanjin/FNS_INV_0011.do' + param, 'FNS_INV_0011', 'width=1000,height=595');
				}
			}
			else {
				classId = "FNS_INV_0016";
				param = '?pgmNo=FNS_INV_0016-01&bl_src_no='+blSrcNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
				
				ComOpenWindow('/hanjin/FNS_INV_0016.do' + param, 'FNS_INV_0016', 'width=1050,height=600');
			}
	   	}
	}

	/**
	 * 조회조건에 따른 입력항목 활성상태 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * good date, i/f date 조건에 따른 화면 입력항목 활성상태 변경
	 * </pre>
	 * @param   없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function date_option_OnChange(value) {
		var formObj = document.form;
		if (value == "G") {
			formObj.good_flag.className = "input2";
			formObj.good_flag.value = "Y";
			formObj.good_flag.disabled = true;
		}
		else {
			formObj.good_flag.className = "input1";
			formObj.good_flag.value = "";
			formObj.good_flag.disabled = false;
		}
	}

	/**
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */ 	  	
	function sheet1_OnLoadFinish(sheetObj){
//		var formObj = document.form;
//		
//		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
//		
//		initControl();
//		
//		date_option_OnChange('G');
//		
//		formObj.from_date.focus();
	}

	/**
	 * OnMouseMove 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */ 
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
	        
        //풍선도움말 만들기
		var sText = sheetObj.CellText(Row,Col);
		if(sText != "") {
			sheetObj.MouseToolTipText = sText;
		}
	}

	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
			 var arOfcCd = formObj.ar_ofc_cd.text;
			 var nextDate = "";
			 
			 if(((from_date.value == "") && (to_date.value == "")) && (vvd.value == "")) {          		 
				 ComShowCodeMessage("INV00004");
				 from_date.focus();
				 return false;
			 }
			 
			 // 오피스 코드가 All일 경우 10일
			 if (arOfcCd == 'All') {
				 nextDate = ComGetDateAdd(from_date.value, "D", 10);
			 }
			 // 개별 오피스인 경우는 1달
			 else {
				 nextDate = ComGetDateAdd(from_date.value, "M", 1);
			 }
			 
			 if (to_date.value >= nextDate) {
				 ComShowCodeMessage("INV00043");
				 to_date.focus();
				 return false;
			 }
			 
			 if(rev_tp_cd.text == "") {
				 ComShowCodeMessage("INV00004");
				 rev_tp_cd.focus();
				 return false;
			 }
		 }
		 return true;
	}

	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		formObj.issue_flag.Code = "A";
		formObj.rev_tp_cd.Code = "A";
		formObj.bound.Code = "A";
		formObj.inv_clr_flg.Code = "N";
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.from_date.focus();
	}

	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.InsertItem(0, "All", "ALL^");
		
		cmbObj.BackColor = "#CCFFFD";
	}

	/** 
	 * ar_ofc_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.12.01
	 */
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.office,expensInfo1[1]);
    }

	/** 
	 * rev_tp_cd 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} s_index
	 * @param {object} s_code
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.12.01
	 */
	function rev_tp_cd_OnCheckClick(comboObj, s_index, s_code) {
		if (s_code == "A") {
			if ((comboObj.Code).indexOf("A") >= 0) {
				comboObj.CheckCode("B") = false;
				comboObj.CheckCode("C") = false;
				comboObj.CheckCode("M") = false;
			}
		} else {
			if ((comboObj.Code).indexOf("A") >= 0) {
				comboObj.CheckCode("A") = false;
			}
		}
	}
 
	/** 
	 * 팝업창(FNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function getFNS_INV_0013() {
		
	}

	/** 
	 * 팝업창(COM_ENS_051_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		document.all.port.value = colArray[3];
	}

	/** 
	 * 팝업창(COM_ENS_0L1_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function getCOM_ENS_0L1_1(rowArray) {
		var colArray = rowArray[0];	
		document.all.scope.value = colArray[3];
	}
 
	/** 
	 * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
	 
	 
     
	 /** 
      * Rev Type 변경에 따라 Rev Source 값 세팅 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} thisObj : Rev Type 폼 오브젝트
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doChange(thisObj){
 		var val = thisObj.options[thisObj.selectedIndex].value;
 		var targetE = document.form.rev_src_cd;
 		targetE.RemoveAll();

 		targetE.InsertItem(0, "ALL",    	"");
 		if(val == 'B'){
 			targetE.InsertItem(1, "BBL",    "BL");
 			targetE.InsertItem(2, "BCS",    "CS");
 			targetE.InsertItem(3, "BCC",    "CC"); 		
 		}else if(val == 'C'){
 			targetE.InsertItem(1, "CCA",    "CA");
 			targetE.InsertItem(2, "CCC",    "CC");
 		}else if(val == 'M'){
 			targetE.InsertItem(1, "MIV",    "IV");
 			targetE.InsertItem(2, "MIC",    "IC");
 			targetE.InsertItem(3, "MCT",    "CT");
 			targetE.InsertItem(4, "MOC",    "OC");
 			targetE.InsertItem(5, "MEQ",    "EQ");
 			targetE.InsertItem(6, "MTS",    "TS");
 			targetE.InsertItem(7, "MDM",    "DM");
 			targetE.InsertItem(8, "MDT",    "DT");
 			targetE.InsertItem(9, "MRD",    "RD");
 			targetE.InsertItem(10, "MTH",    "TH");
 			targetE.InsertItem(11, "MTP",    "TP");
 			targetE.InsertItem(12, "MTM",    "TM");
 			targetE.InsertItem(13, "MTN",    "TN");
 			targetE.InsertItem(14, "MWC",    "WC");
 			targetE.InsertItem(15, "MLS",    "LS");
 			targetE.InsertItem(16, "MDO",    "DO");
 			targetE.InsertItem(17, "MDD",    "DD");
 		}
 		targetE.text = "ALL";
 	}
     
    
      /** 
  	 * rev_src_cd 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param {IBMultiCombo} comboObj
  	 * @param {object} s_index
  	 * @param {object} s_code
  	 * @return 없음
  	 * @see #
  	 * @author 박정진
  	 * @version 2009.12.01
  	 */
  	function rev_src_cd_OnCheckClick(comboObj, s_index, s_code) {
  		//alert(comboObj+":"+s_index+":"+s_code);
  		if(s_code == ""){
  			if(comboObj.CheckCode("") == true){
  				comboObj.CheckCode("BL") = false;
  		        comboObj.CheckCode("CS") = false;
  		        comboObj.CheckCode("CC") = false;
  		        comboObj.CheckCode("CA") = false;
  		        comboObj.CheckCode("CC") = false;
  		        comboObj.CheckCode("IV") = false;
  		        comboObj.CheckCode("IC") = false;
  		        comboObj.CheckCode("CT") = false;
  		        comboObj.CheckCode("OC") = false;
  		        comboObj.CheckCode("EQ") = false;
  		        comboObj.CheckCode("TS") = false;
  		        comboObj.CheckCode("DM") = false;
  		        comboObj.CheckCode("DT") = false;
  		        comboObj.CheckCode("RD") = false;
  		        comboObj.CheckCode("TH") = false;
  		        comboObj.CheckCode("TP") = false;
  		        comboObj.CheckCode("TM") = false;
  		        comboObj.CheckCode("TN") = false;
  		        comboObj.CheckCode("WC") = false;
  		        comboObj.CheckCode("LS") = false;
		        comboObj.CheckCode("DO") = false;
		        comboObj.CheckCode("DD") = false;
  			}
  		}else{
  			comboObj.CheckCode("") = false;
  		}
  	}
  	
  /** 
   * 해당 콤보박스에 값을 모두 삭제함. <br>
   * <br><b>Example :</b>
   * <pre>
   * </pre>
   * @param  {object} e : 콤보박스의 오브젝트 값
   * @return 없음
   * @see #
   * @author 한동훈
   * @version 2009.10.19
   */
  function removeCombo(e){
	    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
	        e.remove(1);
	    }
	}
	   
   	/** 
      * 해당 콤보박스에 값을 세팅함. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {String} text : 콤보박스의 text 값
      * @param  {String} value : 콤보박스의 value 값
      * @param  {object} e : 콤보박스의 오브젝트 값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function addOption(text,value, e){
 	    var o = new Option(text,value);
 	    try{
 	        e.add(o);
 	    }catch(ee){
 	        e.add(o, null);
 	    }
 	}
	/* 개발자 작업  끝 */