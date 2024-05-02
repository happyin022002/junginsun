/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0054.js
*@FileTitle : Invoice Inquiry by Issue Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.01 박정진
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
     * @class fns_inv_0054 : fns_inv_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0054() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
		var sheetObject = sheetObjects[0];
		
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
				break;
				
				//2017.09.08 TAX Invoice Summary 조회 로직 추가
				case "btn_tax_inv":
					formObject.tax_inv_flg.value = "Y";
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
					formObject.tax_inv_flg.value = "N";
				break;
				
				case "btn_new":
					sheetObject.RemoveAll();
					
					formObject.reset();
 					 
					doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC10);
					
					formObject.iss_fm_dt.focus();
				break;
				
				case "btn_downexcel":
					sheetObject.SpeedDown2Excel(-1);
				break;
				
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.iss_fm_dt, 'yyyy-MM-dd');
	            break;
				
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.iss_to_dt, 'yyyy-MM-dd');
	            break;
				
				case "btns_cust1": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_act_cust_seq = formObject.cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_cust_nm = sheetObject.UrlEncoding(formObject.cust_nm.value);
					
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
			
					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
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
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
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
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		
		var dpPrcsKntLocal = formObject.dp_prcs_knt_local.value;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;
		var svrId = formObject.svr_id.value;
		
		var setDpPrcsKnt = "";
		if (Number(dpPrcsKntLocal) > Number(dpPrcsKnt)) {
			setDpPrcsKnt = dpPrcsKntLocal;
		}
		else {
			setDpPrcsKnt = dpPrcsKnt;
		}
		
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 402;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone] msPrevColumnMerge / msAll
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						if(formObject.tax_inv_flg.value == "Y"){	//2017.09.08 TAX Invoice Summary 조회 로직 추가
							var HeadTitle1 = "|Issue Office|SM GSTN No|BKG No|SEZ(Y/N)|Cust GSTN No|Cust Name|Inv No|Org Inv No|Issue Date|Total Inv Amount|SM State Code|Cust State Code|Reverse Charge|POR|DEL|SAC Code|Total Taxable Amount|IGST Rate|IGST Amount|CGST Rate|CGST Amount|SGST Rate|SGST Amount|UGST Rate|UGST Amount|Total Amount";
						} else {
							var HeadTitle1 = "|Issue Date|Office|Bound|Type|Inv No.|Auto|B/L No.|I/F No.|Cust. Code|VVD|S/A Date|POL|POD|Curr|Amount|Ex. Rate|Local Amount|User ID|CGST|SGST|UGST|IGST";
						}
					} else {
						var HeadTitle1 = "|Issue Date|Office|Bound|Type|Inv No.|Auto|B/L No.|I/F No.|Cust. Code|VVD|S/A Date|POL|POD|Curr|Amount|Ex. Rate|Local Amount|User ID";
					}
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					if(formObject.ar_ofc_cd.text == "BOMSC" && formObject.tax_inv_flg.value == "Y"){	//2017.09.08 TAX Invoice Summary 조회 로직 추가
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter, 	true,		"ibflag");
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter, 	false,		"iss_ofc_cd",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		110,	daCenter, 	false,		"iss_ofc_gst_no",	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,		daCenter, 	false,		"bkg_no",    		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		60,		daCenter, 	false,		"sez_flg",    		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		110,	daCenter, 	false,		"cust_gst_no",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		120,	daLeft, 	false,		"cust_nm",			false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		110,    daCenter,  	false,    	"inv_no",			false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		110,    daCenter,  	false,    	"org_inv_no",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter, 	false,		"iss_dt",			false,      "",      dfDateYmd);
						InitDataProperty(0, cnt++ , dtData,    		110,   	daRight,  	false,    	"inv_ttl_locl_amt",	false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		100,	daCenter, 	false,		"iss_ofc_ste_cd",	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		100,	daCenter, 	false,		"cust_ste_cd",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		95,		daCenter, 	false,		"rvs_chg_flg",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		50,     daCenter,  	false,    	"por_cnt_cd",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		50,     daCenter,  	false,    	"del_cnt_cd",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		70,     daCenter,  	false,    	"ida_sac_cd",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		130,   	daRight,  	false,    	"taxable_amt",		false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		70,     daRight,  	false,    	"ida_igst_rto",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daRight,  	false,    	"ida_igst_amt",		false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		70,     daRight,  	false,    	"ida_cgst_rto",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daRight,  	false,    	"ida_cgst_amt",		false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		70,     daRight,  	false,    	"ida_sgst_rto",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daRight,  	false,    	"ida_sgst_amt",		false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		70,     daRight,  	false,    	"ida_ugst_rto",	  	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daRight,  	false,    	"ida_ugst_amt",		false,      "",      dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,    	"ttl_amt",			false,      "",      dfNullFloat, 	2);
					} else {
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter, 	true,		"ibflag");
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter, 	false,		"iss_dt",		false,      "",      dfDateYmd);
						InitDataProperty(0, cnt++ , dtData,    		45,		daCenter, 	false,		"ar_ofc_cd",	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		45,		daCenter, 	false,		"io_bnd_cd",	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		45,     daCenter,  	false,    	"rev_tp_cd",	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		110,    daCenter,  	false,    	"inv_no",		false,      "",      dfNone);
						InitDataProperty(0,  cnt++, dtData,     	65,		daCenter,  	false,	    "auto_inv_iss_flg",  	false,    "",	dfNone);
						InitDataProperty(0, cnt++ , dtData,    		90,		daCenter, 	false,		"bl_src_no",    false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		85,	    daCenter,  	false,    	"ar_if_no",		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter, 	false,    	"cust_cd",     	false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter, 	false,    	"vvd",      	false,      "",      dfNone);
	                    InitDataProperty(0, cnt++ , dtData,    		75,     daCenter,  	false,    	"sail_arr_dt",	false,      "",      dfDateYmd);
	                    
	                    InitDataProperty(0, cnt++ , dtData,    		50,     daCenter,  	false,    	"pol_cd",	  	false,      "",      dfNone);
	                    InitDataProperty(0, cnt++ , dtData,    		50,     daCenter,  	false,    	"pod_cd",  		false,      "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,    		45, 	daCenter, 	false,    	"curr_cd",	false,      "",      dfNone);
	                    if (setDpPrcsKnt > 0) {
	                    	InitDataProperty(0, cnt++ , dtData,    	110,   	daRight,  	false,    	"chg_amt", 		false,      "",      dfNullFloat, 	setDpPrcsKnt);
	                    }
	                    else {
	                    	InitDataProperty(0, cnt++ , dtData,    	110,   	daRight,  	false,    	"chg_amt", 		false,      "",      dfInteger);
	                    }
						InitDataProperty(0, cnt++ , dtData,    		90,		daRight, 	false,    	"inv_xch_rt",	false,      "",      dfNullFloat,	6);
	                    if (setDpPrcsKnt > 0) {
	    					InitDataProperty(0, cnt++ , dtAutoSum, 	110,    daRight,   	false,    	"local_total",	false,      "",      dfNullFloat, 	setDpPrcsKnt);
	                    }
	                    else {
	    					InitDataProperty(0, cnt++ , dtAutoSum, 	110,    daRight,   	false,    	"local_total",	false,      "",      dfInteger);
	                    }
						InitDataProperty(0, cnt++ , dtData,    		65,		daCenter, 	false,     	"cre_usr_id1",	false,      "",      dfNone);
						
						if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
							InitDataProperty(0, cnt++ , dtData,    	80,   	daRight,  	false,    	"ida_cgst_amt", 		false,      "",      dfNullFloat, 	2);
							InitDataProperty(0, cnt++ , dtData,    	80,   	daRight,  	false,    	"ida_sgst_amt", 		false,      "",      dfNullFloat, 	2);
							InitDataProperty(0, cnt++ , dtData,    	80,   	daRight,  	false,    	"ida_ugst_amt", 		false,      "",      dfNullFloat, 	2);
							InitDataProperty(0, cnt++ , dtData,    	80,   	daRight,  	false,    	"ida_igst_amt", 		false,      "",      dfNullFloat, 	2);
						}
						
						if (svrId == 'KOR') {
							colHidden(4) = true;
							colHidden(7) = true;
							colHidden(10) = true;
						}
						else {
							colHidden(4) = false;
							colHidden(7) = false;
							colHidden(10) = false;
						}
					}
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
			case "rev_type": 
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "B/L",    "B");
		            InsertItem(2, "C/A",    "C");
		            InsertItem(3, "MRI",    "M");
		            
		            Code = "A";
		            
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
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('focus', 'obj_activate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
		axon_event.addListenerForm ('blur', 'obj_deactivate', form);
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
		var formObject = document.form;
		
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
					case "inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "ar_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
					case "cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "currency":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "scope":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "port":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "iss_office":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
				}
			case "eng":
				switch(event.srcElement.name){
					case "usr_id":
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
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
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
			case "iss_fm_dt":
				var issFmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issFmDt.length == 8) {
					formObject.iss_to_dt.focus();
				}
	 		break;
			case "cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObject.cust_seq.focus();
				}
	 		break;
			case "cust_seq":
				var custSeq = event.srcElement.value;
				
				if (custSeq.length == 6) {
					formObject.rev_type.focus();
				}
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
			case "cust_seq":
				if (formObject.cust_cnt_cd.value != '' && formObject.cust_seq.value != '') {
					var valueCustSeq = formObject.cust_seq.value;
					formObject.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
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
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
	
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.office.value = arrStr2[1];
	     			formObj.svr_id.value = arrStr2[7];
	     			
	     			sheetObj.Reset();
	     			
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0054GS.do", FormQueryString(formObj));
	     			
     				// 소수점 자리수 설정
		 			formObj.dp_prcs_knt_local.value = ComGetEtcData(sXml,"dp_prcs_knt_local");
		 			formObj.dp_prcs_knt.value = ComGetEtcData(sXml,"dp_prcs_knt");
		 			var ttlLoclSum = ComGetEtcData(sXml,"ttl_locl_amt");
		 			
		 			initSheet(sheetObj,1);
		 			
		 			sheetObj.LoadSearchXml(sXml);
		 			
		 			if (ttlLoclSum !=''){
			 			var sumRow = sheetObj.LastRow;		 			
			 			sheetObj.CellValue(sumRow,"local_total") = ttlLoclSum;
		 			}
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
				
				var actCustCntCd = formObj.cust_cnt_cd.value;
				var actCustSeq = formObj.cust_seq.value;
	
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
			
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(1);
			break;
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
			if(inv_no.value == "" && bl_src_no.value == "") {
				if(iss_fm_dt.value == "" || iss_to_dt.value == "") {
					//ComShowCodeMessage("COM12114", "Issue Date");
					ComShowCodeMessage("INV00004");
					if(iss_fm_dt.value == "") {
						iss_fm_dt.focus();
					}
					else {
						iss_to_dt.focus();
					}
					
					return false;
				}
				else {
					if (ComGetDaysBetween(iss_fm_dt.value,iss_to_dt.value) < 0) {
						ComShowCodeMessage("INV00043");
						iss_to_dt.focus();
						
						return false;
					}
					else {
						//조회기간 입력값 체크(1달)
						var nextDate = ComGetDateAdd(iss_fm_dt.value, "M", 1);
						
						if (iss_to_dt.value >= nextDate) {
							ComShowCodeMessage("INV00043");
							iss_to_dt.focus();
							return false;
						}
					}
				}
			}
			if(ar_ofc_cd.text == "") {
				ComShowCodeMessage("INV00004");
				ar_ofc_cd.focus();
				return false;
			 }
		}
		return true;
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
 		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		formObj.iss_fm_dt.focus();
		
		//2017.09.08 TAX Invoice Summary 조회 로직 추가
		if(formObj.ar_ofc_cd.text == "BOMSC"){
			document.getElementById('tax_inv_sum').style.display = "block";
		} else {
			document.getElementById('tax_inv_sum').style.display = "none";	
		}
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
		var userCntCd = document.form.user_cnt_cd.value;
		if (userCntCd == 'KR') {
			cmbObj.InsertItem(0, "All", "ALL^^^^^^^KOR");
		}
		else {
			cmbObj.InsertItem(0, "All", "ALL^^^^^^^");
		}
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
	 * @version 2009.10.19
	 */
    function ar_ofc_cd_OnChange(ar_ofc_cd , code, text) {
    	var formObject = document.form;
    	var expensInfo1 = code.split("^");
    	
    	ComSetObjValue(formObject.office,expensInfo1[1]);
    	
    	//2017.09.08 TAX Invoice Summary 조회 로직 추가
		if(text == "BOMSC"){
			document.getElementById('tax_inv_sum').style.display = "block";
		} else {
			document.getElementById('tax_inv_sum').style.display = "none";	
		}	
    }

	/**
	 * 날짜조건의 값을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * 
	 * @param formObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setDefaultDateValue(formObj) {
		today = new Date();
  		
		var year = today.getYear();
		var mon  = today.getMonth()+1;
		var sday = today.getDate();
		
		var vDay = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
		
		formObj.iss_fm_dt.value = ComGetMaskedValue(ComGetDateAdd(vDay, "D", -7, ""), "ymd");
		formObj.iss_to_dt.value = vDay;
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
	function getFNS_INV_0013 () {
		var colArray = rowArray[0];
		
		var formObject = document.form;
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
		
		formObject.cust_cnt_cd.value = colArray[8];
		formObject.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
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

	/* 개발자 작업  끝 */