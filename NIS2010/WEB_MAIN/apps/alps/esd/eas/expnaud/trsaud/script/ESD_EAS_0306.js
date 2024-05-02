/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0306.jsp
*@FileTitle : Tariff Comparison by TRS Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2014.12.26 KIM HYUN JOO
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
     * @class ESD_EAS_0306 : ESD_EAS_0306 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0306() {
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

	//공통전역변수
    var frm = null;
    var ofcLevel = null;

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;    
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/	
		var sheetObject = sheetObjects[0]; 
		/*******************************************************/

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				/* [1.1.조회로직] */
				case "btn_retrieve":
					doActionIBSheet(sheetObject,frm,IBSEARCH);
					break;
				case "btn_new":
					ComResetAll();
					loadPage();
					break;

				/* [2.1.엑셀다운로드 버튼] */
				case "btn_downexcel":
					doActionIBSheet(sheetObject,frm,"btn_downexcel");
					break;
				
//				case "btn_vndr_seq":
//					rep_OnPopupClick();
//					break;
				
                case "btns_calendar_s":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(frm.s_fm_yrmon, 'yyyy-MM');
					break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
                	cal.select(frm.s_to_yrmon, "yyyy-MM");
                	break;  			
                	
//    			case "btn_eacif": // EAC transfer
//    				eac_transfer(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
//    				break; 			
                	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TRS90404');
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
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {

		frm = document.form;

	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
//	    
	    doActionIBSheet(sheetObjects[0], frm,"offce_level");

		getEasIbComboList(frm.s_so_tp_cd , s_so_tp_cdCode , s_so_tp_cdText , 'ALL'); 	// Trans mode
		getEasIbComboList(frm.s_trsp_cost_dtl_mod_cd , s_trsp_cost_dtl_mod_cdCode , s_trsp_cost_dtl_mod_cdText , 'ALL'); 		// S/O Type
		getEasIbComboList(frm.s_trsp_cost_dtl_mod_cd , s_trsp_cost_dtl_mod_cdCode , s_trsp_cost_dtl_mod_cdText , 'ALL'); 		// Cost Mode
		getEasIbComboList(frm.s_trsp_crr_mod_cd , s_trsp_crr_mod_cdCode , s_trsp_crr_mod_cdText , 'ALL'); 						// Trans Mode
		getEasIbComboList(frm.s_trsp_bnd_cd , s_trsp_bnd_cdCode , s_trsp_bnd_cdText , 'ALL'); 									// Bound
		
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}	    
		
		initControl();
		comboLoding();
		
		//EAS TRS Auto Audit에서 팝업 했을 경우 자동 조회
		if (frm.sel_rhq_ofc_cd.value != "") {
			initValues();
			doActionIBSheet(sheetObjects[0],frm,IBSEARCH);
		}
	}

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
			case "s_dt_tp_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "W/O Issued Date", "W");
				comboObj.InsertItem(2, "Invoice Confirmed Date", "I");
				comboObj.Index2=0;
				break;
			case "s_ofc_tp_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "W/O", "W");
				comboObj.InsertItem(2, "Invoice", "I");
				comboObj.Index2=0;
				break;  
			case "s_eac_if":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
				break;
			case "s_srch_opt_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "W/O Plus Amount", "WM");
				comboObj.InsertItem(2, "W/O NonZero Amount", "WN");
				comboObj.InsertItem(2, "Invoice Plus Amount", "IP");
				comboObj.InsertItem(2, "Invoice Minus Amount", "IM");
				comboObj.InsertItem(2, "Invoice NonZero Amount", "IN");
				comboObj.Index2=0;
				break;
			case "s_so_tp_cd":
				// Combo 내용 중에서 (R)Rail Billing, (S)Supplement, (H)CHASSIS/GENSET는 제거- AA 요청사항 
				comboObj.DeleteItem("S");
				comboObj.DeleteItem("R");
				comboObj.DeleteItem("H");
				break;
			case "s_trsp_cost_dtl_mod_cd":
				// Combo 내용 중에서    HD : CHASSIS DRAYAGE, HF : CHASSIS S/T OFF-HIRE, HN : CHASSIS S/T ON-HIRE, GD : GENSET DRAYAGE, GF : GENSET S/T OFF-HIRE 제거 - AA 요청사항 
				comboObj.DeleteItem("HD");
				comboObj.DeleteItem("HF");
				comboObj.DeleteItem("HN");
				comboObj.DeleteItem("GD");
				comboObj.DeleteItem("GF");
				break;
		}
	
	}	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 	'obj_blur'      	, document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 	'obj_focus'     	, document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' 	 , 	'obj_change' 	, document.form );
		axon_event.addListenerFormat( 'keypress' ,	'obj_keypress'	, document.form); //- 키보드 입력할때
	}
	
	function initValues() {
		var formObj = document.form;
		formObj.s_rhq_ofc_cd.Code = formObj.sel_rhq_ofc_cd.value;
		formObj.s_wo_ofc_cd.Code = formObj.sel_wo_ofc_cd.value;
		formObj.s_fm_yrmon.value = formObj.wo_iss_pre_mon.value;
		formObj.s_to_yrmon.value = formObj.wo_iss_pre_mon.value;
		formObj.s_so_tp_cd.Code = formObj.sel_trsp_so_tp_cd.value;
		formObj.s_trsp_cost_dtl_mod_cd.Code = formObj.sel_trsp_cost_dtl_mod_cd.value;
		formObj.s_trsp_crr_mod_cd.Code = formObj.sel_trsp_crr_mod_cd.value;
		formObj.s_trsp_bnd_cd.Code = formObj.sel_trsp_bnd_cd.value;
		formObj.s_fm_nod_cd.value = formObj.sel_fm_nod_cd.value;
		formObj.s_to_nod_cd.value = formObj.sel_to_nod_cd.value;
		formObj.s_via_nod_cd.value = formObj.sel_via_nod_cd.value;
		formObj.s_dor_nod_cd.value = formObj.sel_dor_nod_cd.value;		
	}
	
	//
	function comboLoding(){
		var sheetObj = sheetObjects[0]; 
		var combosXml = "";
		
		frm.f_cmd.value = SEARCH02;
		combosXml = sheetObj.GetSearchXml("ESD_EAS_0306GS.do", FormQueryString(frm));
		ComXml2ComboItem(combosXml, frm.s_scg_cd,   "code_cd", "code_nm");			// surcharge type
	}
	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {				
	        case "int":
	            if(obj.name=="s_vndr_seq") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, "-.");
            	break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
			case "s_fm_yrmon":
			case "s_to_yrmon":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();  
				};
			break;
		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_yrmon":
//			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;	
		case "s_to_yrmon":
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_yrmon":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_yrmon":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
//	//월에 더하기를 한다.
//	function getMonthBetween(obj) {
//		var formObj = document.form;
//		if(obj.value.length >= 8) {
//			formObj.s_to_yrmon.value = ComGetDateAdd(obj.value,"D", 90, "-");
//		}else{
//			formObj.s_to_yrmon.value = "";
//		}
//	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {

	 	var cnt = 0;
	 	
	 	switch(sheetNo) {
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
	    			// 높이 설정
					style.height = GetSheetHeight(20);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;
				    
				    Ellipsis = true; 
				    
				    
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 10, 100);
	
					var HeadTitle1 = "||Seq.|RHQ|Office|W/O Issued\nMonth|S/O Type|Cost Mode|Trans\nMode|Bound|From|Via|To|Door|S/P Code|S/P Name|Agreement Rate|Agreement Rate|Agreement Rate|Agreement Rate|Agreement Rate";
					HeadTitle1 += 	 "|Agreement Rate(USD)|Agreement Rate(USD)|Agreement Rate(USD)|Agreement Rate(USD)|COA Rate|COA Rate|COA Rate|COA Rate|S/O CNTR Vol.|S/O CNTR Vol.|S/O CNTR Vol.|S/O CNTR Vol.|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)|Average Rate(3 Month)";
	
					var HeadTitle2 = "||Seq.|RHQ|Office|W/O Issued\nMonth|S/O Type|Cost Mode|Trans\nMode|Bound|From|Via|To|Door|S/P Code|S/P Name|CUR|20ft Dry|40ft Dry|20ft R/F|40ft R/F"
					HeadTitle2 += 	 "|20ft Dry|40ft Dry|20ft R/F|40ft R/F|20ft Dry|40ft Dry|20ft R/F|40ft R/F|20ft|40ft|TEU|BOX|CUR|20ft|40ft|45ft|RF20|RF40|DG20|DG40|AK20|AK40";
						
					var headCount = ComCountHeadTitle(HeadTitle1);
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);
						
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
					HeadRowHeight = 12;
					
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 10,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox,		30,		daCenter, 	true,	"chk");
					InitDataProperty(0, cnt++ , dtSeq,          30,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "wo_rhq_cd",          			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "wo_ofc_cd",      	   			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "inlnd_cost_yrmon", 			false,    "",      dfDateYm,        0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daLeft,  	true,   "trsp_so_tp_cd",   	   			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,  	true,   "trsp_cost_dtl_mod_cd", 		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,  	true,   "trsp_crr_mod_cd", 				false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,  	true,   "trsp_bnd_cd",           		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "fm_nod_cd",      				false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         65,  	daCenter,   true,   "via_nod_cd",  	  	 			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         65,  	daCenter,   true,   "to_nod_cd",         			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         65,  	daCenter,   true,   "dor_nod_cd",         			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "vndr_seq",         			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         210,  	daLeft,   	true,   "vndr_nm",     					false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "agmt_curr_cd", 	   			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_20ft_dry_amt",     		false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_40ft_dry_amt", 			false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_20ft_rf_amt", 			false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_40ft_rf_amt",       		false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_20ft_dry_usd_amt",      	false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true, 	"agmt_40ft_dry_usd_amt",   	   	false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_20ft_rf_usd_amt",      	false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,   	true,   "agmt_40ft_rf_usd_amt",     	false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "trsp_avg_20ft_dry_usd_amt",    false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "trsp_avg_40ft_dry_usd_amt",   	false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "trsp_avg_20ft_rf_usd_amt",     false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "trsp_avg_40ft_rf_usd_amt",     false,    "",      dfNullFloat,   	2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,    true,   "so_20ft_vol_knt",  	   		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   	true,   "so_40ft_vol_knt",  	   		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   	true,   "so_teu_qty",       			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,    true,   "so_bx_qty",       				false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);

					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "wo_curr_cd", 	   			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_20ft_dry_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_40ft_dry_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_45ft_dry_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_20ft_rf_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_40ft_rf_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_20ft_dg_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_40ft_dg_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_20ft_awk_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,   "wo_40ft_awk_avg_amt",       				false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);

					
				}
				break;
			}
		}	
	 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			var frm = document.form;
			
			switch (sAction) {

				// SEARCH LOGIC
				case IBSEARCH:
					if(validateForm(sheetObj,frm,sAction)){
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0306GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					}
					break;

				case "btn_downexcel":	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
					sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;

				case "offce_level":

		  			// ofcLevel, rqh_ofc_cd 값을 구한다. 
					frm.f_cmd.value = COMMAND01;
	        		var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
	        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");

// 이폼에서는 권한 체크를 하지 않는다.
//	        		var rhqSearchFlag = false;
//	        		var ofcSearchFlag = false;
	        		
//	        		// 로그인한 RHQ OFFCD 셋팅
//	        		frm.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
//	        		// 로그인한 OFFCD 셋팅
//	        		frm.s_wo_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
	        			        		
// 이폼에서는 권한 체크를 하지 않는다.	        		
//	        		if(ofcLevel=="O"){
//	        			// 일반 OFFICE
//	            		rhqSearchFlag = false;
//	            		ofcSearchFlag = true;        			
//	            		frm.s_rhq_ofc_cd.Enable=false;	
//	            		frm.s_wo_ofc_cd.Enable=false;  	
//	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
//	            		frm.s_wo_ofc_cd.code2 = frm.ofc_cd.value; 
//	        		}else if(ofcLevel=="R"){
//	        			// RHQ
//	        			rhqSearchFlag = false;
//	        			ofcSearchFlag = false;
//	        			frm.s_rhq_ofc_cd.Enable=false;	
//	        			frm.s_wo_ofc_cd.Enable=true;      		
//	        			frm.s_rhq_ofc_cd.Index2=0;
//	        			doActionIBCombo(frm.s_rhq_ofc_cd)
//	        			
//	        		}else if(ofcLevel=="H"){
//	        			// 심사팀 )
//	            		rhqSearchFlag = true;
//	            		ofcSearchFlag = false;
//	            		frm.s_rhq_ofc_cd.Enable=true;	
//	            		frm.s_wo_ofc_cd.Enable=true; 		             		
//	        		}
	    			
	        		var rhqSearchFlag = true;
	        		
	        		if(rhqSearchFlag){
	        			//RHQ 콤보 리스트 조회
	        			frm.s_rhq_ofc_cd.RemoveAll();
	        			frm.f_cmd.value = COMMAND02;
	        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	        			// 이폼에서는 권한 체크를 하지 않는다.
		        		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
		        		
		        		// RHQ에 해당하는 Office 조회
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}
//	        		if(ofcSearchFlag){
//	        			doActionIBCombo(frm.s_wo_ofc_cd)
//	        		}
		  		break;  				
			}
		}

		/**
		* sheet1 Click후 이벤트 
		* @param {ibsheet} sheet 해당 시트   
		* @param {long} row 해당 셀의 Row Index
		* @param {long} col 해당 셀의 Column Index
		*/
		function sheet1_OnClick(sheetObj, Row, Col) {
			
			var bkg_no = "";
			var param =  "";
			if (sheetObj.ColSaveName(Col) == "bkg_no")	{
				// B8 Charge Tab ( from ESM_BKG_0079 : Booking Creation )
				bkg_no = sheetObj.CellValue(Row, "bkg_no");
				if (bkg_no != "" && bkg_no != null) {
					param = "pgmNo=ESM_BKG_0079&openTab=B8&bkg_no=" + bkg_no;
					ComOpenWindowCenter("ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650,true);	
				}
			} 
		}
		
		function openAuditdetail(){
			
			var eacNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eac_no");
			var pgmNo = 'ESD_EAS_0306';
			var pgmUrl = 'ESD_EAS_0306.do?';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&EAC_NO=" + eacNo+"&READ_ONLY_FLG=N"
			ComOpenPopup(pgmUrl + src, 1024, 610, "", "1,0", true, false);			
		}

	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[0];
	    	
	    	switch(comboObj.id) {
		    case "s_rhq_ofc_cd":  
		        frm.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		        frm.s_wo_ofc_cd.RemoveAll();
		    	ComXml2ComboItem(sXml, frm.s_wo_ofc_cd, "ofc_cd", "ofc_cd");
		    	frm.s_wo_ofc_cd.InsertItem(0, "", "");
//		    	frm.s_wo_ofc_cd.Index=0;
		    	frm.s_wo_ofc_cd.code2 = frm.ofc_cd.value
		    	doActionIBCombo(frm.s_wo_ofc_cd)
		    	
		    	break;  
	        }
	    }
	    
		
		/*
		* rep_commodity팝업호출
		*/
		function rep_OnPopupClick() {
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_rep";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getComEnsRep', '1,0,1,1,1');
		}	  

		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
		function getComEnsRep(rowArray){
			for(var i=0; i<rowArray.length; i++){
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				frm.s_vndr_seq.value =colArray2;
				frm.s_vndr_nm.value =colArray4;
			}
		}	
		
		// 공통테이블에 등록된 코드값을 조회 한다.    
		function searchCommonCombo(codeKey,comboObj){
			var sheetObj = sheetObjects[1];
				frm.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				frm.code_key.value = codeKey
//				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0306GS.do", FormQueryString(frm));
//				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
		
		function s_wo_ofc_cd_OnChange(comboObj,Index_Code, Text){
			if(Index_Code!=0){
				doActionIBCombo(frm.s_wo_ofc_cd); // Audit Office
			}else{
				frm.s_eac_reg_usr_id.RemoveAll();
			}
		}	 

		
		/**
		* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
		*/
		function  vender_change(){
			if(frm.s_vndr_seq.value =="" ){
				frm.s_vndr_seq.value="";
				frm.s_vndr_nm.value="";
				return;
			}
			frm.f_cmd.value = SEARCH05;
			var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0306GS.do", FormQueryString(frm));
			var vndrNm = EasXmlString(sXml,"vndr_nm");
			
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.s_vndr_seq.value="";
				frm.s_vndr_nm.value="";
				return;
			}
			frm.s_vndr_nm.value = vndrNm;
		
		}	  		
		
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
			switch(sAction) {
			case IBSEARCH :
				// Mandatory Item Check
		
				if(formObj.s_rhq_ofc_cd.Code == "" ){
					ComShowCodeMessage("COM130403", "RHQ"); // S/O Issue Date 값을 입력하셔야 합니다;
					return false;
				}

				if(formObj.s_fm_yrmon.value == "" || formObj.s_to_yrmon.value == "" ){
					ComShowCodeMessage("COM130403", "W/O Issued Month"); // S/O Issue Date 값을 입력하셔야 합니다;
					return false;
				}
				
				// 최대 조회 기간은 2달. 
				if(formObj.s_fm_yrmon.value != "" && formObj.s_to_yrmon.value != "" ){
					
					var iDiff;
				
					iDiff = calMnthDiff (formObj.s_fm_yrmon.value, formObj.s_to_yrmon.value);
					
					if (iDiff < 0) {
						// from < to 
						ComShowCodeMessage("COM132002"); // From 월이 To 월 보다 이전이어야 한다.;
						return false;
					} else if ( iDiff > 1) {
						ComShowCodeMessage("COM132001", "W/O Issued Month", "2 Months"); // MAX 2달 까지 조회 ;
						return false;
					}
				}

				break;
			} // end switch()
			return true;
		}	
		
		function calMnthDiff(fromYM,toYM){
			// YYYYMM 형식의 날짜의 월 차이를 구한다.
			fromYM = ComTrimAll(fromYM,"-","/");
			toYM = ComTrimAll(toYM,"-","/");
						
			var iFrom = fromYM.substring(0,4)*12 + fromYM.substring(4) * 1; 
			var iTo = toYM.substring(0,4)*12 + toYM.substring(4) * 1;

			return (iTo - iFrom);
		}
		
		/**
	     * Sheet 조회완료 후 이벤트 발생
	     */
//	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//		}
		
	/* 개발자 작업  끝 */