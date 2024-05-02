/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0304.jsp
*@FileTitle : Special SO for Transportation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2015.01.22 KIM HYUN JOO
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
     * @class ESD_EAS_0304 : ESD_EAS_0304 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0304() {
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
		var sheetObject2 = sheetObjects[1]; 
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
				
				case "btn_vndr_seq":
					rep_OnPopupClick();
					break;
				
                case "btn_auditdetail":
                	openAuditdetail();
                	break; 
					
                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
    	            cal.select(frm.s_fm_dt, "yyyy-MM-dd");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
                	cal.select(frm.s_to_dt, "yyyy-MM-dd");
                	break;
                	
					
    			case "btn_eacif": // EAC transfer
    				eac_transfer(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
    				break; 			
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
	    
	    doActionIBSheet(sheetObjects[0], frm, "offce_level");
//	    
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}	    
//		frm.s_snd_fm_dt.value = ComGetDateAdd(ComGetNowInfo(),"D",-90, "-");
//		getMonthBetween(frm.s_snd_fm_dt);
		initControl();
		
		getEasIbComboList(frm.s_bnd_cd , s_bnd_cdCode , s_bnd_cdText , 'ALL'); // Bound Type
		getEasIbComboList(frm.s_trsp_crr_mod_cd , s_trsp_crr_mod_cdCode , s_trsp_crr_mod_cdText , 'ALL'); // Trans Mode 
	}

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj) {
		
		switch(comboObj.id) {
 
			case "s_snd_tp_cd":		
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "FAX", "F");
				comboObj.InsertItem(2, "e-Mail", "M");
				comboObj.Index2=0;
				break;  
			case "s_snd_rslt_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Success", "S");
				comboObj.InsertItem(2, "Fail", "F");
				comboObj.Index2=0;
				break; 
			case "s_eac_if":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
				break;  
		}
	
	}	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      	, document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     	, document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' 	 , 'obj_change' 	, document.form );
		axon_event.addListenerFormat( 'keypress' ,'obj_keypress'	, document.form); //- 키보드 입력할때
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
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
			case "s_snd_fm_dt":
			case "s_snd_to_dt":
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
		case "s_fm_dt":
//			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	//월에 더하기를 한다.
//	function getMonthBetween(obj) {
//		var formObj = document.form;
//		if(obj.value.length >= 8) {
//			formObj.s_fm_dt.value = ComGetDateAdd(obj.value,"D", 90, "-");
//		}else{
//			formObj.s_to_dt.value = "";
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
					style.height = GetSheetHeight(21);
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

					var HeadTitle1 = "||Seq.|EQ No.|TP/\nSZ|Trans\nMode|S/O TP|S/O No.|S/O CRE DT|S/O UPD Name|W/O No.|W/O ISS DT|W/O ISS\nOFC|W/O ISS Name|From|Via|To|Door|W/O S/P|W/O S/P|Parent S/P|Parent S/P|3rd Party|Work Order Amount|Work Order Amount";
					HeadTitle1 += 	 "|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Invoice No|INV S/P|Reason|Internal Remark|Special Instruction|BKG No.|POR|POL|POD|DEL|EAC I/F";

					var HeadTitle2 = "||Seq.|EQ No.|TP/\nSZ|Trans\nMode|S/O TP|S/O No.|S/O CRE DT|S/O UPD Name|W/O No.|W/O ISS DT|W/O ISS\nOFC|W/O ISS Name|From|Via|To|Door|Code|Name|Code|Name|3rd Party|Currency|Basic"
					HeadTitle2 += 	 "|Negotiated|Fuel|VAT|Additional|Total|Total(USD)|Invoice No|INV S/P|Reason|Internal Remark|Special Instruction|BKG No.|POR|POL|POD|DEL|EAC I/F";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 7, 0, true);
					
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
					InitDataProperty(0, cnt++ , dtData,         85,  	daCenter,   true,   "eq_no",           false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,   "eq_tpsz_cd",      false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,   "trsp_crr_mod_cd", false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daLeft,     true,   "trsp_so_tp_cd",   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         85,  	daCenter,   true,   "so_no",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         115,  	daCenter,   true,   "so_locl_cre_dt",  false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "so_usr_nm",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "wo_no",           false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         115,  	daCenter,   true,   "wo_locl_cre_dt",  false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         65,  	daCenter,   true,   "wo_ofc_cd",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "wo_usr_nm",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "fm_nod_cd",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "via_nod_cd",      false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "to_nod_cd",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "dor_nod_cd", 	   false,    "",      dfNone,         		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "vndr_seq",        false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,   	true,   "vndr_nm",         false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "prnt_vndr_seq",   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,   	true,   "prnt_vndr_nm",    false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "n3tpy_bil_flg",   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "curr_cd",   	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "bzc_amt",         false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "nego_amt",    	   false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "fuel_scg_amt",    false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "scg_vat_amt",     false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "etc_add_amt",     false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "wo_tot_amt",      false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daRight,    true,   "wo_usd_tot_amt",  false,    "",      dfNullFloat,          2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "inv_no",  		   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "inv_vndr_seq",    false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         200,  	daLeft,     true,   "trsp_purp_rsn",   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "inter_rmk",       false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "spcl_instr_rmk",  false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "bkg_no",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "por_cd",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "pol_cd",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "pod_cd",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "del_cd",      	   false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "eac_if_flg",      false,    "",      dfNone,          		0,          false,        false,   0,  false, true,  "", false);					
				}
				break;
//	    	case 2:      //sheet1 init
//	    		with (sheetObj) {
//	    		// 높이 설정
//	    		style.height = 0;
//	    		//전체 너비 설정
//	    		SheetWidth = mainTable.clientWidth;
//	    		
//	    		//Host정보 설정[필수][HostIp, Port, PagePath]
//	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//	    		
//	    		//전체Merge 종류 [선택, Default msNone]
//	    		MergeSheet = msHeaderOnly;
//	    		
//	    		//전체Edit 허용 여부 [선택, Default false]
//	    		Editable = false;
//	    		
//	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//	    		InitRowInfo(1, 1, 10, 100);
//	    		
//	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//	    		InitColumnInfo(3, 3, 0, true);
//	    		
//	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
//	    		InitHeadMode(true, true, true, true, false,false) ;
//	    		
//	    		var HeadTitle1 = "|SEQ.|EAC No";
//	    		
//	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	    		InitHeadRow(0, HeadTitle1, true);
//	    		
//	    		HeadRowHeight = 12;
//	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
//	    		InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
//	    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "eac_no",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
//	    		
//	    	    }
//	    		break;
			}
		}	
	 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
//			var frm = document.form;
			
			switch (sAction) {

				// SEARCH LOGIC
				case IBSEARCH:
					if(validateForm(sheetObj,frm,sAction)){
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0304GS.do", sParam);
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
//	        		frm.s_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
	        			        		
// 이폼에서는 권한 체크를 하지 않는다.	        		
//	        		if(ofcLevel=="O"){
//	        			// 일반 OFFICE
//	            		rhqSearchFlag = false;
//	            		ofcSearchFlag = true;        			
//	            		frm.s_rhq_ofc_cd.Enable=false;	
//	            		frm.s_ofc_cd.Enable=false;  	
//	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
//	            		frm.s_ofc_cd.code2 = frm.ofc_cd.value; 
//	        		}else if(ofcLevel=="R"){
//	        			// RHQ
//	        			rhqSearchFlag = false;
//	        			ofcSearchFlag = false;
//	        			frm.s_rhq_ofc_cd.Enable=false;	
//	        			frm.s_ofc_cd.Enable=true;      		
//	        			frm.s_rhq_ofc_cd.Index2=0;
//	        			doActionIBCombo(frm.s_rhq_ofc_cd)
//	        			
//	        		}else if(ofcLevel=="H"){
//	        			// 심사팀 )
//	            		rhqSearchFlag = true;
//	            		ofcSearchFlag = false;
//	            		frm.s_rhq_ofc_cd.Enable=true;	
//	            		frm.s_ofc_cd.Enable=true; 		             		
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
//	        			doActionIBCombo(frm.s_ofc_cd)
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
		
		/**
	     * Sheet 조회완료 후 이벤트 발생
	     */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			with(sheetObj) {
				ColFontUnderline("bkg_no") = true;
				DataLinkMouse("bkg_no") = true;
			}
			// EAC I/F된 자료는 체크박스 비활성
			for (var idx = sheetObj.HeaderRows ; idx< sheetObj.RowCount + sheetObj.HeaderRows ; idx++) { 
				if(sheetObj.CellValue(idx, "eac_if_flg") == "Y"){ 
					sheetObj.CellEditable(idx, "chk") = false;
					sheetObj.CellValue2(idx, "chk") = "";
				}
			}	
		}
		
		function openAuditdetail(){
			
			var eacNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eac_no");
			var pgmNo = 'ESD_EAS_0304';
			var pgmUrl = 'ESD_EAS_0304.do?';
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
		        frm.s_ofc_cd.RemoveAll();
		    	ComXml2ComboItem(sXml, frm.s_ofc_cd, "ofc_cd", "ofc_cd");
		    	frm.s_ofc_cd.InsertItem(0, "", "");
//		    	frm.s_ofc_cd.Index=0;
		    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
		    	doActionIBCombo(frm.s_ofc_cd)
		    	
		    	break;  
		    case "s_ofc_cd":
//		    	frm.f_cmd.value = SEARCH02;
//		    	var sParam = FormQueryString(frm);
//		    	var sXml = sheetObj.GetSearchXml("ESD_EAS_0205GS.do", sParam);
//		    	
//		    	
//		    	if(ofcLevel=="O"){
//		    		frm.s_eac_reg_usr_id.InsertItem(0, frm.session_usr_nm.value+"("+frm.usr_id.value+")", frm.usr_id.value);
//		    	}else{
//		    			ComXml2ComboItem(sXml, frm.s_eac_reg_usr_id, "eac_usr_id", "eac_usr_code");
//		    			frm.s_eac_reg_usr_id.InsertItem(0, "", "");
//		    	}
//		    	
//		    	frm.s_eac_reg_usr_id.Code2=frm.usr_id.value;
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
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0304GS.do", FormQueryString(frm));
//				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
		
//		function s_ofc_cd_OnChange(comboObj,Index_Code, Text){
//			if(Index_Code!=0){
//				doActionIBCombo(frm.s_ofc_cd); // Audit Office
//			}else{
//				frm.s_eac_reg_usr_id.RemoveAll();
//			}
//		}	 

		
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
			var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0304GS.do", FormQueryString(frm));
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

				if(formObj.s_fm_dt.value == "" || formObj.s_to_dt.value == ""){
					ComShowCodeMessage("COM130403", "S/O Issue Date"); // S/O Issue Date 값을 입력하셔야 합니다;
					return false;
				}
				
				if (!checkPeriodValidation(formObj.s_fm_dt,formObj.s_to_dt)) {
					return false;
				}
				break;
			} // end switch()
			return true;
		}	
		
		// hjkim - Check Period Validation 
		function checkPeriodValidation(objFm,objTo){
			
			// from > to 
			var sFm = ComTrimAll(objFm.value, "-"); 
			var sTo = ComTrimAll(objTo.value, "-"); 
			
			if ( sFm > sTo) {
				ComShowCodeMessage("COM132002"); 	// msgs['COM132002'] = 'End date must be greater than start date';
				return false;
			}
			
			// to < fm + 2 Month
			var sMax = ComGetDateAdd(objFm.value,"M", 2, "");
			
			if ( sTo > sMax){
				ComShowCodeMessage("COM132001","S/O Issue Date","2 Months" );
				return false;
			}
			
			return true;
		}
		
		/**
		 * EAC transfer
		 * Special So Of Transport 은 EAC I/F 를 다 건으로 처리 한다.
		 */		
		function eac_transfer(sheetObj,Row,Col){
			
			// interface variable
			var orgKey = "";
			var tempKey = "";
			var invList = "";
			var woList = "";
			var tpSzList = "";
			var eqNoList = "";
			var soNoList = "";
			var costCdList = "";	// Cost Code doesn't exist in 0304. but this value need for eac i/f. ( default : XXXXXX )
			var temp = "";	
			var ofc_cd = "";
			var vndr_seq = "";
			var cur_cd = "";
			var bkg_no = "";
			
			//selected row
			var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
			var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
			
			//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
			if (arrRow.length == 1) {
				ComShowCodeMessage("COM12189");
		   		return;
			}

			for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
  					
  					// 다건 선택시  선택된 Row 들은  BKG NO, W/O Currency, W/O Issue Office, Invoice S/P 가 동일한 경우만 EAC I/F창 팝업 가능 
  					if (idx == 0 ) {
  						orgKey = ComTrim(sheetObj.CellValue(arrRow[idx],"bkg_no")) + ComTrim(sheetObj.CellValue(arrRow[idx],"curr_cd")) + ComTrim(sheetObj.CellValue(arrRow[idx],"wo_ofc_cd")) + ComTrim(sheetObj.CellValue(arrRow[idx],"vndr_seq")); 
  					} else {
  						tempKey = ComTrim(sheetObj.CellValue(arrRow[idx],"bkg_no")) + ComTrim(sheetObj.CellValue(arrRow[idx],"curr_cd")) + ComTrim(sheetObj.CellValue(arrRow[idx],"wo_ofc_cd")) + ComTrim(sheetObj.CellValue(arrRow[idx],"vndr_seq"));
  					}
  					
  					if ( orgKey != tempKey && tempKey != "") {
  						ComShowMessage(ComGetMsg("EAS90102"));
  						return;
  					}
  					
					// EAC Interfce 된 Row 가 EAC Interface 대상인 경우 Error.
  					eac_if_flg = ComTrim(sheetObj.CellValue(arrRow[idx],"eac_if_flg"))
					if (eac_if_flg == "Y") {
						ComShowCodeMessage("EAS90103");
						return;
					}
  					
  					// 다건 선택시 Invoice No, W/O No, EQ No, Type Size, So No, Cost Code는  "1,2,3,4,5" 처럼 , 로 구분해서 한개의 문자열로 변환해서 넘긴다.
  					// 1) Invoice No, W/O No, EQ No, Type Size 는 중복값 없이 넘긴다.  	ex) "1,1,3" 일 경우 "1,3" 으로 Interface 
  					// 2) So No, Cost Code는 중복값이 있으면 그대로 넘긴다.  		    ex)"1,1,3" 일 경우 "1,1,3" 으로 Interface 
  					
  					// Making Invoice No List (Invoice No must be unique)
  					temp = ComTrim(sheetObj.CellValue(arrRow[idx],"inv_no"));
  					if(invList.search(temp) == -1 ){
  						invList = invList + temp + ",";	
  					}
  					//  Making & W/O No List (WO No must be unique)
  					temp = ComTrim(sheetObj.CellValue(arrRow[idx],"wo_no"));
  					if(woList.search(temp) == -1 ){
  						woList = woList + temp + ",";	
  					}
  					//  Making & E/Q No List & Type Size List (EQ No & Type Size must be unique)
  					temp = ComTrim(sheetObj.CellValue(arrRow[idx],"eq_no"));
  					if(eqNoList.search(temp) == -1 ){
  						eqNoList = eqNoList + temp + ",";
  						tpSzList = tpSzList + sheetObj.CellValue(arrRow[idx],"eq_tpsz_cd") + ",";
  					}
  					
  					// Making So No List
  					soNoList = soNoList + sheetObj.CellValue(arrRow[idx],"so_no") + ",";
  					// Making Cost Code List
  					costCdList = costCdList + "XXXXXX" + ",";			//Cost Code 값이 존재 하지 않을 경우. Interface 하는 Row 수 만큼 'XXXXXX'을 보내준다. 
  					
  					if (idx == 0 ) { 
  						ofc_cd = ComTrim(sheetObj.CellValue(arrRow[idx],"wo_ofc_cd"));
  						vndr_seq = ComTrim(sheetObj.CellValue(arrRow[idx],"vndr_seq"));
  						cur_cd = ComTrim(sheetObj.CellValue(arrRow[idx],"curr_cd"));
  						bkg_no = ComTrim(sheetObj.CellValue(arrRow[idx],"bkg_no"));
  					}
			}
			
			// remove last "," character.
			if (invList != "" ) {
				invList = invList.substring(0, invList.length-1);
			}
			if (woList != "" ) {
				woList = woList.substring(0, woList.length-1);
			}
			if (tpSzList != "" ) {
				tpSzList = tpSzList.substring(0, tpSzList.length-1);
			}	
			if (eqNoList != "" ) {
				eqNoList = eqNoList.substring(0, eqNoList.length-1);
			}			
			if (soNoList != "" ) {
				soNoList = soNoList.substring(0, soNoList.length-1);
			}			
			if (costCdList != "" ) {
				costCdList = costCdList.substring(0, costCdList.length-1);
			}	
			
			// for Data Setting
		   	var theURL = "ESD_EAS_0224.do?p_sys_div_cd="	+ "TRS"													//  System 구분 : Transportation 
										+"&p_sys_if_cd="	+ "TR1"													// 	System 별 interface 구분 : TR1( Special SO for Transportation - ESD_EAS_0304 )						
										+"&p_eq_no="		+ eqNoList												
										+"&p_tp_sz="		+ tpSzList												
										+"&p_eq_knd="		+ "U"													// Container Code Setting
										+"&p_ofc_cd="		+ ofc_cd												// resp. office
										+"&p_vndr_seq="		+ vndr_seq												// S/P Code
										+"&p_cur_cd="		+ cur_cd												// Currency
		   								+"&p_wo_no="		+ woList												// Work order No
		   								+"&p_inv_no="		+ invList												// Invoice No
		   								+"&p_bkg_no="		+ bkg_no												// BKG No.
		   								
		   								// for Interface Key
		   								+"&p_if_so_no="		+ soNoList												// So No.
		   								+"&p_if_cost_cd="	+ costCdList;											// Cost Code.		

		   	var winName = "EACTransferPopup";
		   	var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";			
		   	ComOpenWindow(theURL,winName,features,true);

		}		
		
		/**
		 * EAC transfer 팝업호출 및 저장 후 eac_no 선택한 Row에 셋팅.
		 */	
		function fn_setEacNo(eac_no){
			if (eac_no.length == 14) {
				var sRow = sheetObjects[0].FindCheckedRow("chk");					
				var arrRow = sRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++){ 
					sheetObjects[0].CellValue2(arrRow[idx],'eac_if_flg') = "Y";
					sheetObjects[0].CellEditable(arrRow[idx], "chk") = false;
					sheetObjects[0].CellValue2(arrRow[idx], "chk") = "";
				}
			}
		}		
	/* 개발자 작업  끝 */
		