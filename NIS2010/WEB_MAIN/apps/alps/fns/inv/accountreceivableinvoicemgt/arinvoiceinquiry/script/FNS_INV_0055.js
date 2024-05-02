/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0055.js
*@FileTitle : Invoice Issue Report by Date (for TVA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.03 박정진
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
     * @class fns_inv_0055 : fns_inv_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0055() {
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
	 * @version 2009.06.03
	 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];

		/*******************************************************/
		var formObject = document.form;
		var officeCode = formObject.ar_ofc_cd.text;
        
        try {
        	var srcName = window.event.srcElement.getAttribute("name");
        	
        	switch(srcName) {
        	    case "btn_new":
					sheetObject1.RemoveAll();
					
					with(formObject){
						iss_fm_dt.value = "";
						iss_to_dt.value = "";
						act_cust_cnt_cd.value = "";
						act_cust_seq.value = "";
						cust_nm.value = "";
 					 	vvd.value = "";
 					 	port.value = "";
 					 	bound.value = "";
 					 }
 					 
					 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
					 setDefaultDateValue(document.form);
 					 document.form.ar_ofc_cd.focus();
                break;
                
				case "btn_save":
					if (officeCode == 'SGNSC') {
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					}
					else if (officeCode == 'SYDSC') {
						doActionIBSheet(sheetObject3,formObject,IBSEARCH);
					}
					else {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
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
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					if (v_act_cust_cnt_cd != '' && v_act_cust_seq != '') {
						var classId = "FNS_INV_0013";
						var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
				
						ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
					}
				break;
				
				case "btns_cust2": //CUST 조회버튼
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
					var param = '?loc_cd='+loc_cd_val+'&loc_eq_ofc='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
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
	 * @version 2009.06.03
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
	 * @version 2009.06.03
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
	 * @version 2009.06.03
	 */
     function loadPage() {
 		for(i=0;i<sheetObjects.length;i++){
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
 		
		initControl();
		 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(document.form);
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
 	 * @version 2009.06.03
 	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 320;
					
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
					
					var HeadTitle = " |I/F No|Issue Date|Customer|Invoice No.|VVD|BND|PORT|S/A Date|B/L No|REV TYPE|FRT USD|Ex. Rate|EQV LCL|TVA LCL|CHG LCL|TTL LCL|VAT No.|TAXABLE AMT|NON TAXABLE AMT|EFF Date|DP PRCS KNT";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet1_";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "ar_if_no",		false,		"",		dfNone,			0,		false,		false,		10);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "iss_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "customer",		false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "inv_no",			false,		"",		dfNone,			0,		false,		false,		3);
					
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daCenter,		false,		prefix + "vvd",				false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "io_bnd_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "port",			false,		"",		dfNone,			0,		false,		false,		20);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "sail_arr_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "rev_tp_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "frt_usd",			false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		prefix + "usd_xch_rt",		false,		"",		dfNullFloat,	6,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "eqv_lcl",			false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "tva_lcl",			false,		"",		dfNullFloat,	2,		false,		false);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "chg_lcl",			false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ttl_lcl",			false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daCenter,		false,		prefix + "vat_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "taxable_amt",		false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "non_taxable_amt",	false,		"",		dfNullFloat,	2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "gl_eff_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					InitDataProperty(0, cnt++ , dtHidden,    	100,	daCenter,		false,		prefix + "dp_prcs_knt",		false,		"",		dfNone,			0,		false,		false,		12);

					CountPosition = 0;
				}
			break;
			case "sheet2":
				with (sheetObj) {
					//높이 설정
					style.height = 320;
					
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
					
					//var HeadTitle = " |Invoice No.|Issue Date|B/L No|G/L Date|Customer|BND|VDT TTL(VND)|VTT TTL(VND)|Ex. Rate|DHF VND|DHF USD|DDF VND|DDF USD|OBS VND|OBS USD|OTH VND|OTH USD|DTH VND|DTH USD|DDC VND|DDC USD|ORC VND|ORC USD";
					var HeadTitle = " |INV Type|Issue Date|Invoice No|Actual INV No|Customer Code|Customer Name|TVA No|BL No|Net Amount|VAT Amount|Gross Amount|USD Amount|Ex.Rate|Bound|User ID";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet2_";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "inv_type",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "iss_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "inv_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "act_inv_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "act_cust_cd",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "cust_lgl_eng_nm",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "cust_rgst_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "net_amt",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "vat_amt",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "gross_amt",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "usd_amt",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "inv_xch_rt",			false,		"",		dfNullFloat,	6);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "io_bnd_cd",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "upd_usr_id",			false,		"",		dfNone,			0,		false,		false,		3);
					/*
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "inv_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "iss_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "gl_eff_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "customer",		false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "io_bnd_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "vdt_ttl",			false,		"",		dfInteger);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "vtt_ttl",			false,		"",		dfInteger);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		prefix + "usd_xch_rt",		false,		"",		dfNullFloat,	6);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dhf_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dhf_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ddf_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ddf_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "obs_vnd",			false,		"",		dfNullFloat,	2);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "obs_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "oth_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "oth_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dth_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dth_usd",			false,		"",		dfNullFloat,	2);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ddc_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ddc_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "orc_vnd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "orc_usd",			false,		"",		dfNullFloat,	2);
					*/

					CountPosition = 0;
				}
			break;
			
			case "sheet3":
				with (sheetObj) {
					//높이 설정
					style.height = 320;
					
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
					
					var HeadTitle = " |G/L Date|Issue Date|Invoice No.|B/L No|Cust Code|Cust Name|BND|CMR AUD|CMR USD|DHF AUD|DHF USD|DTH AUD|DTH USD|EHC AUD|EHC USD|DTS AUD|DTS USD|DPS AUD|DPS USD|DTC AUD|DTC USD|AST AUD|AST USD|TVA AUD|TVA USD|NON TAXABLE AUD|NON TAXABLE USD|Ex. Rate|LCL AMT|USD AMT|EQV LCL|GRAND TOTAL";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet3_";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "gl_eff_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "iss_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "inv_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "customer",		false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "cust_lgl_eng_nm",	false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "io_bnd_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "cmr_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "cmr_usd",			false,		"",		dfNullFloat,	2);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dhf_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dhf_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dth_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dth_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ehc_aud",			false,		"",		dfNullFloat,	2);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ehc_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dts_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dts_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dps_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dps_usd",			false,		"",		dfNullFloat,	2);
					
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dtc_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "dtc_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ast_aud",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "ast_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "tva_aud",			false,		"",		dfNullFloat,	2);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "tva_usd",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "non_taxable_aud",	false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "non_taxable_usd",	false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		prefix + "usd_xch_rt",		false,		"",		dfNullFloat,	6);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "lcl_amt",			false,		"",		dfNullFloat,	2);

					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "usd_amt",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "eqv_lcl",			false,		"",		dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daRight,		false,		prefix + "grand_total",		false,		"",		dfNullFloat,	2);

					CountPosition = 0;
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
	 * @version 2009.06.03
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
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
	 * @version 2009.06.03
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
		axon_event.addListenerForm ('focusout', 'obj_focusout', form);
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
	 * @version 2009.06.03
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
					
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
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
	 * @version 2009.06.03
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
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
	 * @version 2009.06.03
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				
			break;
			
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
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
	 * @version 2009.06.03
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "iss_fm_dt":
				var issFmDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issFmDt.length == 8) {
					//formObject.iss_to_dt.value = formObject.iss_fm_dt.value;
					formObject.iss_to_dt.focus();
				}
	 		break;
			case "iss_to_dt":
				var issToDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issToDt.length == 8) {
					//formObject.act_cust_cnt_cd.focus();
				}
	 		break;
			case "act_cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObject.act_cust_seq.focus();
				}
	 		break;
			case "act_cust_seq":
				var custSeq = event.srcElement.value;
				
				if (custSeq.length == 6) {
					formObject.vvd.focus();
				}
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
	 * @author 박정진
	 * @version 2009.06.03
	 */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				var valueCustCntCd = formObject.act_cust_cnt_cd.value;
				var valueCustSeq = formObject.act_cust_seq.value;
				
				if (valueCustCntCd != '' && valueCustSeq != '') {
					if (valueCustSeq != '') {
						formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					}
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
				else {
					formObject.act_cust_cnt_cd.value = "";
					formObject.act_cust_seq.value = "";
					formObject.cust_nm.value = "";
					
					formObject.vvd.focus();
				}
			break;
			/*
			case "iss_fm_dt":
				var iss_fm_dt = formObject.iss_fm_dt.value;
				if(iss_fm_dt != ""){
					formObject.iss_to_dt.value = formObject.iss_fm_dt.value;
				}
			break;
			*/	
			case "iss_to_dt":
				//조회기간 입력값 체크(3달)
				var nextDate = ComGetDateAdd(formObject.iss_fm_dt.value, "M", 1);
				
				if (ComReplaceStr(formObject.iss_to_dt.value,"-","") >= ComReplaceStr(nextDate,"-","")) {		
					ComShowCodeMessage("INV00043");
					//formObject.iss_to_dt.value = formObject.iss_fm_dt.value;
					formObject.iss_to_dt.focus();
					return false;
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
	 * @version 2009.06.03
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var filePath = "";

					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.office.value = arrStr2[1];
	     			
	     			sheetObjects[0].RemoveAll();
	     			sheetObjects[1].RemoveAll();

					if (sheetObj.id == "sheet1") {
		     			var office = arrStr2[1];
						if ('' == office) office = "ALL";
						
						filePath = "C:\\Users\\Public\\"+ office +"_TVA_INV.xls";
		     			
						ComOpenWait(true);  //대기이미지 표시
						
						sheetObj.DoSearch("FNS_INV_0055GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
		            	if (sheetObj.RowCount > 0) {
		            		var prefix="sheet1_";
		            		
							for(var i=sheetObj.rowCount; i>0; i--) {
								sheetObj.InitCellProperty(i , prefix + "frt_usd", dtData , daRight , prefix + "frt_usd", "", dfNullFloat, 2 );
								sheetObj.InitCellProperty(i , prefix + "eqv_lcl", dtData , daRight , prefix + "eqv_lcl", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
								sheetObj.InitCellProperty(i , prefix + "tva_lcl", dtData , daRight , prefix + "tva_lcl", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
								sheetObj.InitCellProperty(i , prefix + "chg_lcl", dtData , daRight , prefix + "chg_lcl", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
								sheetObj.InitCellProperty(i , prefix + "ttl_lcl", dtData , daRight , prefix + "ttl_lcl", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
								sheetObj.InitCellProperty(i , prefix + "taxable_amt", dtData , daRight , prefix + "taxable_amt", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
								sheetObj.InitCellProperty(i , prefix + "non_taxable_amt", dtData , daRight , prefix + "non_taxable_amt", "", dfNullFloat, sheetObj.CellValue(i,prefix + "dp_prcs_knt") );
							}
		            		
							if(ComShowCodeConfirm("INV00049")) {
								ComOpenWait(false); //대기이미지 숨김	
								sheetObj.SpeedDown2Excel(-1);
							}
							else {
								var downResult = sheetObj.SpeedDown2Excel(-1, false,false,filePath);
								ComOpenWait(false); //대기이미지 숨김
								if(downResult){
									alert("Saved File Path : "+ filePath);
								}
							}
						}
		            	
						ComOpenWait(false); //대기이미지 숨김
					}
					else if (sheetObj.id == "sheet2") {
		     			var office = arrStr2[1];
						if ('' == office) office = "ALL";
						
						filePath = "C:\\Users\\Public\\"+ office +"_VAT_INV.xls";
		     			
						ComOpenWait(true);  //대기이미지 표시
						
						sheetObj.DoSearch("FNS_INV_0055GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet2_"));
		            	if (sheetObj.RowCount > 0) {
							if(ComShowCodeConfirm("INV00049")) {
								ComOpenWait(false); //대기이미지 숨김	
								sheetObj.SpeedDown2Excel(-1);
							}
							else {
								var downResult = sheetObj.SpeedDown2Excel(-1, false,false,filePath);
								ComOpenWait(false); //대기이미지 숨김
								if(downResult){
									alert("Saved File Path : "+ filePath);
								}
							}
		            	}
		            	else {
							ComOpenWait(false); //대기이미지 숨김
		            	}
					}
					else if (sheetObj.id == "sheet3") {
		     			var office = arrStr2[1];
						if ('' == office) office = "ALL";
						
						filePath = "C:\\Users\\Public\\"+ office +"_AST_INV.xls";
		     			
						ComOpenWait(true);  //대기이미지 표시
						
						sheetObj.DoSearch("FNS_INV_0055GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet3_"));
		            	if (sheetObj.RowCount > 0) {
							if(ComShowCodeConfirm("INV00049")) {
								ComOpenWait(false); //대기이미지 숨김	
								sheetObj.SpeedDown2Excel(-1);
							}
							else {
								var downResult = sheetObj.SpeedDown2Excel(-1, false,false,filePath);
								ComOpenWait(false); //대기이미지 숨김
								if(downResult){
									alert("Saved File Path : "+ filePath);
								}
							}
		            	}
		            	else {
							ComOpenWait(false); //대기이미지 숨김
		            	}
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

				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
	
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
				
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.act_cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.act_cust_seq, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.act_cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
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
	 * @version 2009.06.03
	 */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
			 if(ar_ofc_cd.text == "") {
				 ComShowCodeMessage("COM12114", "Office");
				 ar_ofc_cd.focus();
				 return false;
			 }
         }

         return true;
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
 	 * @version 2009.06.03
 	 */
 	function MakeComboObject(cmbObj, arrStr) {
 		cmbObj.RemoveAll(); 
 		
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ar_ofc_cd = arrStr2[1];
 			
 			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
 		}
 		cmbObj.BackColor = "#CCFFFD";
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
 	 * @version 2009.06.03
   	 */
   	function setDefaultDateValue(formObj) {
   		today= new Date();
   		
   		var year  =today.getYear();
   		var mon  =today.getMonth()+1;
   		var sday =today.getDate();
   		
   		formObj.iss_fm_dt.value = year+"-"+ComLpad(mon,2,"0")+"-01";
   		formObj.iss_to_dt.value = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
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
	 * @version 2009.06.03
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		
		document.all.port.value = colArray[3];
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
	 * @version 2009.06.03
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
	
	/** 
     * 업무 자바스크립트 OnChange 이벤트 처리 <br>
     * 선택한 항목이 combo list에 있는 데이타 인지 체크 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} comboObj : 폼 오브젝트
     * @param  {int} idx_cd : 선택한 항목에 대한 value값
     * @param  {String} text : 선택한 항목에 대한 text값
     * @param  {String} code : 선택한 항목에 대한 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function ar_ofc_cd_OnChange(comboObj,Index_Code, Text){
   	 if(Text == "SGNSC"){
   		document.getElementById('categories1').style.display='block';
   		document.getElementById('categories2').style.display='block';
   	 }else{
   		document.getElementById('categories1').style.display='none';
   		document.getElementById('categories2').style.display='none';
   	 }
    }

	/* 개발자 작업  끝 */