/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0002.js
*@FileTitle : Manual Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
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
     * @class EES_DOD_0002 : EES_DOD_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DOD_0002() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 각각의 메인 화면에서 각각의 팝업화면을 띄우기 위해 사용
	var POPUP_OPEN_ID = parseInt(Math.random() * 100).toString(10);
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

       /*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {

            	case "btn_retrieve":
            		if(!validateForm(sheetObject, formObject, IBSEARCH)) {
						return;
					}
	             	doActionIBSheet(sheetObject, formObject, IBSEARCH);
	             	break;

				case "btn_ar_inv":
					var authorization_flg = false;
					
					if(!validateForm(sheetObject, formObject, IBSAVE)) {
						return;
					}
					
					// authorization
					for(var i=0; i<sheetObjects[2].RowCount; i++) {
						if(sheetObjects[2].CellValue(i+1,'sub_sys_cd') == "DOD" && sheetObjects[2].CellValue(i+1,'pgm_no') == "EES_DOD_0002" && 
								sheetObjects[2].CellValue(i+1,'pgm_btn_id') == "btn_ar_inv" && sheetObjects[2].CellValue(i+1,'btn_use_flg') == "Y"){
							// dc_amt, fld_use_flg
							if(sheetObjects[2].CellValue(i+1,'pgm_fld_id') == "dc_amt" && sheetObjects[2].CellValue(i+1,'fld_use_flg') == "Y"){
								authorization_flg = true;
							}

						}
					}

					if(authorization_flg){
						// Discount가 0인놈을 인보이스할때
						var cnt = 0;
						// 선택 한 체크박스의 갯수를 가져온다.
						var chkRowCount = sheetObject.CheckedRows("selChk");
						// 선택 한 체크박스의 rownum을 가져온다.
				 		var iCheckRow = sheetObject.FindCheckedRow("selChk");
						// 가져온 행을 배열로 만든다.
						var arrRow = iCheckRow.split("|");	
								
						for(var i = 0; i < arrRow.length-1; i++){
							if(sheetObject.CellValue(arrRow[i], "dc_amt") == "0"){
								cnt++;
							}
						}

//						alert("sheetObject.CheckedRows : " + sheetObject.CheckedRows("selChk") + " cnt : " + cnt);
						if(chkRowCount != cnt) {
							var param = "?ofc_cd=" + formObject.ofc_cd.value+"&sub_sys_cd=DOD&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no=EES_DOD_0002&auth_apro_tp_cd=AF&auth_pgm_btn_seq=" + sheetObjects[2].CellValue(1,'auth_pgm_btn_seq');
							ComOpenPopup('/hanjin/COM_APR_0T1.do' + param, 915, 522, '', 'none', true);
							
							if(formObject.AUTH_APRO_RQST_NO.value == undefined || formObject.AUTH_APRO_RQST_NO.value == null ||
									ComTrim(formObject.AUTH_APRO_RQST_NO.value) == '' || ComTrim(formObject.AUTH_APRO_RQST_NO.value).length != 30) return;
						}
					}

					doActionIBSheet(sheetObject, formObject, IBSAVE);
					
					break;

     			case "btn_new":
     				if(!initConfirm()) {
	        			return;
	        		}
	        		ComResetAll();
	        		
	        		//사후 결재 사전정보 가져오기
	        		sheetObjects[2].DoSearch4Post("COM_APR_0S1GS.do", 'f_cmd=&ofc_cd=' + document.form.ofc_cd.value + '&sub_sys_cd=DOD&pgm_no=EES_DOD_0002&auth_apro_tp_cd=Atfer');
     				break;
     				
     			case "bkg_no_multi1":
     				rep_Multiful_inquiry("bkg_no", "BKG NO."); 

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
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//html컨트롤 이벤트초기화
		initControl();

    }

    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;

		//사후 결재 사전정보 가져오기
		sheetObjects[2].DoSearch4Post("COM_APR_0S1GS.do", 'f_cmd=&ofc_cd=' + document.form.ofc_cd.value + '&sub_sys_cd=DOD&pgm_no=EES_DOD_0002&auth_apro_tp_cd=Atfer');

		sheetObj.WaitImageVisible = true;   
    }
    
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerForm  ('change', 'obj_change', document.form);
		
    }
    
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
        var okYn = true;

     	if(sheetObjects[0].isDataModified) {     		
     		var okYn = confirm(ComGetMsg('DOD00003'));
     		
     	}
     	return okYn;
     	
    }
    
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				if(obj.name=="vndr_seq"){
					//ComKeyOnlyNumber(obj,",");
					ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
				} else {
					ComKeyOnlyNumber(obj);
				}
				break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	}
    
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {

			case "cntr_no":		// CNTR_NO VAILIDATION
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH04 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "CNTR No."));
						obj.value = "";
						obj.focus();
					}
				}
			break;

		}		
	} 
	
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
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(36, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "|SEQ||BKG No.|CNTR No.|TP/SZ|BKG POD|RTN CY|INV CUST|INV CUST Name|Special CUST|Special CUST Name|RFA No.|S/C No.|CUR|General Tariff|Special Tariff|Discount|Final Amt|File|Remark";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,   daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++,	dtSeq,			 30,   daCenter,	false,	"seq",					false,    		"",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	 30,   daCenter,   	false,  "selChk");
                    InitDataProperty(0, cnt++ , dtData,      	 90,   daCenter,  	true,   "bkg_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,   daCenter,  	true,   "cntr_no",	 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,   daCenter,  	true,   "cntr_tpsz_cd",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,   daCenter,  	true,   "del_cd", 				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,   daCenter,  	true,   "cntr_rtn_yd_cd",		false,          "",      dfNone,	 0,     true,       false);
					InitDataProperty(0, cnt++ , dtPopupEdit,   	 80,   daCenter,  	true,   "cust_cd_seq",			false,          "",      dfNone,     0,     true,      	true);
					InitDataProperty(0, cnt++ , dtData,      	 160,  daLeft,  	true,   "cust_lgl_eng_nm",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,   	 110,  daCenter,  	false,  "spcl_cd_seq",			false,          "",      dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 160,  daLeft,  	true,   "spcl_cust_lgl_eng_nm",	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,   daCenter,  	false,	"rfa_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,   daCenter,  	false,	"sc_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,   daCenter,  	true,   "curr_cd",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,   daRight,  	true,   "gen_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,   daRight,  	true,   "spcl_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 70,   daRight,  	true,   "dc_amt",	 			false,          "",      dfFloat,	 2,     true,       false);
					InitDataProperty(0, cnt++ , dtData,      	 70,   daRight,  	true,   "ttl_amt",				false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,     60,	daCenter,  	false,	"atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 180,  daLeft,  	false,	"dc_rmk",				false,          "",      dfNone,     0,     true,       false);
				
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"drp_off_chg_trf_seq",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"drp_off_chg_trf_spcl_seq",	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"cust_cnt_cd",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"cust_seq",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"tmp_cust_cnt_cd",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"tmp_cust_seq",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,     	 30,	daCenter,  	false,	"tmp_cust_cd_seq",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 100,	daLeft,  	false,	"tmp_cust_lgl_eng_nm", 	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,  "spcl_cust_cnt_cd",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,  "spcl_cust_seq",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,    	 30,   daCenter,  	false,	"tro_ib_cfm_ofc_cd",	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"tro_ib_cfm_dt",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"cntr_rtn_dt", 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	false,	"bl_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,        40,	daCenter,  	false,	"atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
					
					ShowButtonImage = 2;
//			        ImageList(0) = "img/btns_search_off.gif"; // btns_search_off.gif
//			        ImageList(1) = "img/btns_search.gif";

			        InitDataValid(0, "cntr_rtn_yd_cd", vtEngUpOther, "0123456789");
			        InitDataValid(0, "cust_cd_seq", vtEngUpOther, "0123456789");
			        InitDataValid(0, "spcl_cd_seq", vtEngUpOther, "0123456789");
               }
               break;
           case 2:      //sheet1 init
               with (sheetObj) {

					// 높이 설정
					style.height = 0;
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "||Office|BKG No.|TRO Date|CNTR No.|TP/SZ|BKG DEL|RTN CY|RTN Date|Cust Code|Cust Name|Special Cust Code|Special Cust Name|RFA No.|S/C No.|CUR|General Tariff|Special Tariff|Discount|Final AMT|Remark";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,  "ibflag");
					/*
					InitDataProperty(0, cnt++ , dtCheckBox,  	 30,	daCenter,	false,  "selChk");
					InitDataProperty(0, cnt++ , dtData,    		 50,	daCenter,  	false,	"tro_ib_cfm_ofc_cd",	false,          "",      dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"bkg_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"tro_ib_cfm_dt",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"cntr_no",	 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"cntr_tpsz_cd",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"del_cd", 				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"cntr_rtn_yd_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"cntr_rtn_dt", 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"cust_cd_seq",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 100,	daLeft,  	false,	"cust_lgl_eng_nm", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,  "spcl_cd_seq",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 100,	daLeft,  	false,	"spcl_cust_lgl_eng_nm", false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daLeft,  	false,	"rfa_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daLeft,  	false,	"sc_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"curr_cd",	 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"gen_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"spcl_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"dc_amt",	 			false,          "",      dfFloat,	 2,     true,       false);
					InitDataProperty(0, cnt++ , dtData,      	 70,	daCenter,  	false,	"ttl_amt", 				false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 180,	daCenter,  	false,	"dc_rmk",				false,          "",      dfNone,     0,     true,       true, 10);
					
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"drp_off_chg_trf_seq",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"drp_off_chg_trf_spcl_seq",	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"cust_cnt_cd",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,	"cust_seq",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,  "spcl_cust_cnt_cd",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,  "spcl_cust_seq",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,	daCenter,  	false,  "inv_src_no",			false,          "",      dfNone,     0,     false,      false);
					*/
               }
               break;
               
           case 3:      //sheet1 init
        	   with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = hiddenTableAuth.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0 , 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;
					
					var HeadTitle = "ibflag|sub_sys_cd|pgm_no|auth_pgm_btn_seq|auth_apro_tp_cd|pgm_btn_id|pgm_btn_nm|btn_use_flg|pgm_fld_id|fld_use_flg";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,  100,   daCenter,   true,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "sub_sys_cd");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_no");
					InitDataProperty(0, cnt++ , dtData,    150,   daCenter,   true,    "auth_pgm_btn_seq");
					InitDataProperty(0, cnt++ , dtData,    150,   daCenter,   true,    "auth_apro_tp_cd");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_btn_id");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_btn_nm");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "btn_use_flg");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_fld_id");
					InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "fld_use_flg");

           	   }
        	   break;
               
        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Col, Row) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //Retrieve
				/*
				if(!validateForm(sheetObj, formObj, sAction)) {
					return;	
				}
				*/
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_DOD_0002GS.do", FormQueryString(formObj));
				break;
			
			case IBSAVE:      //AR INV

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				formObj.f_cmd.value = MULTI;
//				sheetObj.DoSave("EES_DOD_0001GS.do", FormQueryString(formObj));
				var sParam = sheetObj.GetSaveString(false, true, "selChk") +"&" + FormQueryString(formObj);
//				alert(sParam);
				var sXml = sheetObj.GetSaveXml("EES_DOD_0002GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				
				// AR Invoice보내고 나서 Issue화면으로 보낼 BL No. 먼저 저장 ---------------
				var param = "";
				var blNo = "";
		 		var iCheckRow = sheetObj.FindCheckedRow("selChk");
				var arrRow = iCheckRow.split("|");	
						
				for(var i = 0; i < arrRow.length-1; i++){
					if(i==0){
						blNo += sheetObj.CellValue(arrRow[i], "bl_no") + ",";							
					}else if(sheetObj.CellValue(arrRow[0], "bl_no") != sheetObj.CellValue(arrRow[i], "bl_no")){
						blNo += sheetObj.CellValue(arrRow[i], "bl_no") + ",";
					}
					
				}
				if (blNo != "")       
					blNo = EasDelLastDelim(blNo);
				// -------------------------------------------------------------
				ComOpenWait(false);
				
				if(ComGetEtcData(sXml, "SUCCESS_YN") == "Y"){
					// Invoice보내고나서 재조회
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("EES_DOD_0002GS.do", FormQueryString(formObj));
					
					var okYn = confirm(ComGetMsg('DOD00023'));
					if(okYn){
						// Login한 사용자가 AR Invoice Issue화면에 접근권한이 있는지 확인한다.
						var param = "f_cmd=" + SEARCH12 + "&s_value=" + formObj.usr_id.value;				
						var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);			
						var count = ComGetEtcData(sXml, "count");
						var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
						
						if(result == "S"){
							if(parseInt(count) == 0) {
								ComShowMessage(ComGetMsg('DOD00025'));
								return false;
							}
						}
						
						param = "ofc_cd=" + formObj.ofc_cd.value + "&bl_no=" + blNo;
						
						ComOpenWindowCenter2("FNS_INV_0034_01.do?popup=yes&" + param, "Invoice Issue", 1024, 700, false, "scrollbars=yes,resizable=yes");
					}
					
				}
				
    			/*
    			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    			formObj.f_cmd.value = COMMAND02;
    			ComSetObjValue(formObj.backendjob_id, "INVMNLCREATE");

    			var sParam = sheetObj.GetSaveString(false) +"&" + FormQueryString(formObj);
    			var sXml = sheetObj.GetSaveXml("EES_DOD_0001GS.do", sParam);
    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//alert(sParam + " : " + sXml);    			
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
//alert("backendjob_key : " + formObj.backendjob_key.value + " | formObj.backendjob_id : " + formObj.backendjob_id.value);
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
				*/
				break;
				
			case IBROWSEARCH:

				if (Col == "cntr_rtn_yd_cd") {
					
					var rtnCY = sheetObj.CellValue(Row, "cntr_rtn_yd_cd");
					if(rtnCY.trim() == ""){
						return;
					}
					var param = "f_cmd=" + SEARCH09 + "&s_value=" + rtnCY;
					var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
					var count = ComGetEtcData(sXml, "count");
					var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					
					if(result == "S"){
						if(parseInt(count) == 0) {
							ComShowMessage(ComGetMsg("DOD00021", "Return CY"));
							sheetObj.CellValue(Row, "cntr_rtn_yd_cd") = "";
							return;
						}
						
					}
					
					formObj.f_cmd.value = SEARCH09;
					var sParam = "bkg_no=" + sheetObj.CellValue(Row, "bkg_no") +
								"&cntr_no=" + sheetObj.CellValue(Row, "cntr_no") + 
								"&cntr_rtn_yd_cd=" + sheetObj.CellValue(Row, "cntr_rtn_yd_cd") +
								"&spcl_cd_seq=" + sheetObj.CellValue(Row, "spcl_cd_seq") +
								"&" + FormQueryString(formObj);

					var sXml = sheetObj.GetSearchXml("EES_DOD_0002GS.do", sParam);
					
					var currCd = ComGetEtcData(sXml, "currCd");
					var genTrfAmt = ComGetEtcData(sXml, "genTrfAmt");
					var spclTrfAmt = ComGetEtcData(sXml, "spclTrfAmt");
					var drpOffChgTrfSeq = ComGetEtcData(sXml, "drpOffChgTrfSeq");
					var drpOffChgTrfSpclSeq = ComGetEtcData(sXml, "drpOffChgTrfSpclSeq");

					if(typeof currCd == "undefined" || typeof genTrfAmt == "undefined" || typeof spclTrfAmt == "undefined") {
						ComShowCodeMessage('DOD00016');
						sheetObj.CellValue(Row, "cntr_rtn_yd_cd") = "";
						sheetObj.CellValue(Row, "curr_cd") = "";
						sheetObj.CellValue(Row, "drp_off_chg_trf_seq") = "";
						sheetObj.CellValue(Row, "gen_trf_amt") = "";
						sheetObj.CellValue(Row, "drp_off_chg_trf_spcl_seq") = "";
						sheetObj.CellValue(Row, "spcl_trf_amt") = "";
						return;
						
					} else {
						if(currCd != "" || genTrfAmt != "" || spclTrfAmt != "") {
							sheetObj.CellValue(Row, "curr_cd") = currCd;
							sheetObj.CellValue(Row, "drp_off_chg_trf_seq") = drpOffChgTrfSeq;
							sheetObj.CellValue(Row, "gen_trf_amt") = genTrfAmt;
							sheetObj.CellValue(Row, "drp_off_chg_trf_spcl_seq") = drpOffChgTrfSpclSeq;
							sheetObj.CellValue(Row, "spcl_trf_amt") = spclTrfAmt;
							if(spclTrfAmt != ""){
								sheetObj.CellValue(Row, "ttl_amt") = spclTrfAmt;
							}else{
								sheetObj.CellValue(Row, "ttl_amt") = genTrfAmt;
							}
							
						}else{
							ComShowCodeMessage('DOD00016');
							sheetObj.CellValue(Row, "cntr_rtn_yd_cd") = "";
							sheetObj.CellValue(Row, "curr_cd") = "";
							sheetObj.CellValue(Row, "drp_off_chg_trf_seq") = "";
							sheetObj.CellValue(Row, "gen_trf_amt") = "";
							sheetObj.CellValue(Row, "drp_off_chg_trf_spcl_seq") = ""; 
							sheetObj.CellValue(Row, "spcl_trf_amt") = "";
						}
						
					}

				}

				break;
				
		}
	}

    /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
/*
    function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND03);
	
	 	var params		= "f_cmd=" + COMMAND03 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml		= sheetObj.GetSearchXml("EES_DOD_0001GS.do", params);
	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");
	 	
	 	// jobState == "2" BackEndJob 진행중......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob이 성공 하였습니다.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// BackEndJob을 실패 하였습니다.
	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DOD00015");
	 		
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
	 		ComShowCodeMessage("DOD00015");
	 		ComOpenWait(false);
	 	}
	 }

	// BackEndJob 성공종료시 결과데이터를 반영한다.
	function getBackEndJobLoadFile() {
//alert("getBackEndJobLoadFile()");
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[1];
	 	
	 	var backendjobId = ComGetObjValue(formObj.backendjob_id);
	 	
	 	ComSetObjValue(formObj.f_cmd, MULTI);	//SAVE

	 	var params = "f_cmd=" + ComGetObjValue(formObj.f_cmd) + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml = sheetObj.GetSaveXml("EES_DOD_0001GS.do", params);
	 	sheetObj.LoadSaveXml(sXml);
//		 	alert("Sheet2 > Load : " + sXml);
	 	
	 	//create Invoice Data
	 	ComSetObjValue(formObj.f_cmd, COMMAND01);

	 	var sParam = sheetObj.GetSaveString(true) +"&" + FormQueryString(formObj);
//		 	alert("sParam : " + sParam);
	 	var sXml = sheetObj.GetSaveXml("EES_DOD_0001GS.do", sParam);
//		 	alert("sXml : " + sXml);

	 	ComOpenWait(false);

	}
*/
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		for(var i = 1; i < sheetObj.Rows; i++){
			if(sheetObj.CellValue(i, "spcl_trf_amt") != "0"){
				sheetObj.CellValue(i, "ttl_amt") = sheetObj.CellValue(i, "spcl_trf_amt");
			}else{
				sheetObj.CellValue(i, "ttl_amt") = sheetObj.CellValue(i, "gen_trf_amt");
			}
		}
		//test data
//		sheetObj.CellValue(1, "spcl_trf_amt") = '150';
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var ttlAmt = "";
		if(sheetObj.ColSaveName(Col) == "dc_amt") {// Discount컬럼에 값이 변경되면
			ttlAmt = sheetObj.CellValue(Row, "ttl_amt");

			if(sheetObj.CellValue(Row, "spcl_trf_amt") > 0) {
				ttlAmt = sheetObj.CellValue(Row, "spcl_trf_amt");
//				ttlAmt = ( parseFloat(ttlAmt) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt")) ) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
				ttlAmt = parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
				
			}else{// Special Tariff가 존재하지 않으면 General Tariff에서 차감
				ttlAmt = sheetObj.CellValue(Row, "gen_trf_amt");
//				ttlAmt = ( parseFloat(ttlAmt) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt")) ) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));
				ttlAmt = parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt"));

			}
			
			if(ttlAmt == 0 || ttlAmt < 0) {
//				ComShowCodeMessage('DOD00004');					
//				sheetObj.CellValue(Row, "dc_amt") = "";
				sheetObj.CellValue(Row, "ttl_amt") = "";
				
			}else{
				sheetObj.CellValue(Row, "ttl_amt") = ttlAmt;
				
			}
			
		} else if(sheetObj.ColSaveName(Col) == "svc_fee_amt") {// Correction Fee컬럼에 값이 변경되면
			ttlAmt = sheetObj.CellValue(Row, "ttl_amt");

			if(sheetObj.CellValue(Row, "spcl_trf_amt") > 0) {
				ttlAmt = sheetObj.CellValue(Row, "spcl_trf_amt");
				ttlAmt = ( parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt")) ) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt"));
				
			}else{// Special Tariff가 존재하지 않으면 General Tariff에서 차감
				ttlAmt = sheetObj.CellValue(Row, "gen_trf_amt");
				ttlAmt = ( parseFloat(ttlAmt) - parseFloat(sheetObj.CellValue(Row, "dc_amt")) ) + parseFloat(sheetObj.CellValue(Row, "svc_fee_amt"));

			}
			
			if(ttlAmt == 0 || ttlAmt < 0) {						
//				ComShowCodeMessage('DOD00004');					
//				sheetObj.CellValue(Row, "dc_amt") = "";
				sheetObj.CellValue(Row, "ttl_amt") = "";
				
			}else{
				sheetObj.CellValue(Row, "ttl_amt") = ttlAmt;
				
			}
			
			
		} else if(sheetObj.ColSaveName(Col) == "cntr_rtn_yd_cd") {
			if(sheetObj.CellValue(Row, "cntr_rtn_yd_cd") != "") {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, 'cntr_rtn_yd_cd', Row);
				
			}
			
		} else if(sheetObj.ColSaveName(Col) == "cust_cd_seq") {
			var custCdSeq = sheetObj.CellValue(Row, "cust_cd_seq");
			
			if(checkINVCustomer(sheetObj, Row, custCdSeq)) {				
				changeINVCustomer(sheetObj, Row, custCdSeq);
				
			}
	
		} else if(sheetObj.ColSaveName(Col) == "spcl_cd_seq") {
			var spclCdSeq = sheetObj.CellValue(Row, "spcl_cd_seq");
			var param = "f_cmd=" + SEARCH + "&cust_cd=" + spclCdSeq.substr(0,2) +"&cust="+ spclCdSeq.substr(2);
			var sXml = sheetObj.GetSearchXml("COM_ENS_041GS.do", param);
			var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
			if(rtnArr != null && rtnArr.length > 1){
				sheetObj.CellValue2(Row, Col) = rtnArr[0];
				sheetObj.CellValue2(Row, Col + 1) = rtnArr[1];
				sheetObj.CellValue2(Row, "spcl_cust_cnt_cd") = rtnArr[0].substr(0,2);
				sheetObj.CellValue2(Row, "spcl_cust_seq") = rtnArr[0].substr(2);
//				alert("SpecialCustCode : " + rtnArr[0] + " SpecialCustName : " + rtnArr[1] + " CD : " + rtnArr[0].substr(0,2) + " SEQ : " + rtnArr[0].substr(2) );
			} else {
				ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
				sheetObj.CellValue2(sheetObj.SelectRow, "spcl_cd_seq") = "";
				sheetObj.CellValue2(sheetObj.SelectRow, "spcl_cust_lgl_eng_nm") = "";
				sheetObj.SelectCell(sheetObj.SelectRow, "spcl_cd_seq");
			}
			
		}
	}
	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		switch (sheetObj.ColSaveName(Col)) {
		case "selChk":
//			alert("Row : " + Row + " > Col : " + Col + " > Value : " + Value); // Test BKG_NO : BKK443503700
			
			var selBkgNo = sheetObj.CellValue(Row, "bkg_no");
			if(Value == 0) {
				for(var i = 1; i < sheetObj.Rows; i++){
					if(selBkgNo == sheetObj.CellValue(i, "bkg_no") && Row != i){
						sheetObj.CellValue2(i, "selChk") = 1;
					}
				}
//				alert("선택한 " + selBkgNo + " 와 동일한 BKG_NO를 가진 CNTR의 갯수는? " + cnt);
			}
			break;
			
		case "atch_file_lnk_cnt":
			dodFileUploadPopUp(sheetObj, Row, "CHG", "Y", "");
			break;
			
		default:
			break;
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
	 * @version 2012.12.06
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		if(sheetObj.ColSaveName(Col) == "cust_cd_seq") {
			ComOpenPopup('COM_ENS_041.do', 770, 470, "getINVCustomer", "1,0,1,1,1,1,1", true, false, Row);
			
		} else if(sheetObj.ColSaveName(Col) == "spcl_cd_seq") {
			ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustomer", "1,0,1,1,1,1,1", true, false, Row);
			
		}
	}

    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 : INV Customer
  	 */
    function getINVCustomer(aryPopupData, Row) {
    	var custCdSeq = aryPopupData[0][3];
    	sheetObjects[0].CellValue2(Row, 'cust_cd_seq') = custCdSeq;
    	sheetObjects[0].CellValue2(Row, 'cust_lgl_eng_nm') = aryPopupData[0][4];
    	
//    	alert(custCdSeq.substr(0, 2) + " + " + custCdSeq.substr(2, custCdSeq.length));
    	sheetObjects[0].CellValue2(Row, 'cust_cnt_cd') = custCdSeq.substr(0, 2);
    	sheetObjects[0].CellValue2(Row, 'cust_seq') = custCdSeq.substr(2, custCdSeq.length);
    			
    }
    
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 : Special Customer
  	 */
    function getCustomer(aryPopupData, Row) {
    	var spclCdSeq = aryPopupData[0][3];
    	sheetObjects[0].CellValue2(Row, 'spcl_cd_seq') = spclCdSeq;
    	sheetObjects[0].CellValue2(Row, 'spcl_cust_lgl_eng_nm') = aryPopupData[0][4];
    	
//    	alert(spclCdSeq.substr(0, 2) + " + " + spclCdSeq.substr(2, spclCdSeq.length));
    	sheetObjects[0].CellValue2(Row, 'spcl_cust_cnt_cd') = spclCdSeq.substr(0, 2);
    	sheetObjects[0].CellValue2(Row, 'spcl_cust_seq') = spclCdSeq.substr(2, spclCdSeq.length);
    			
    }
    
	/** 
	 * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 * @param {int} x 필수, X 좌표
	 * @param {int} y 필수, Y 좌표
	 * @return 없음
	 */   
	function sheet1_OnMouseMove(sheetObj, button, shift, x, y) {
		with(sheetObj){
			if(ColSaveName(MouseCol) == "cust_cd_seq" || ColSaveName(MouseCol) == "spcl_cd_seq") {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
	 	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	//공통 체크	       
    	with(formObj){        	
    		if (sAction == IBSEARCH){
    			if(bkg_no.value == "") {
    				ComShowCodeMessage('DOD00001', bkg_no.caption);
    				return false;
    			}
    		} else if (sAction == IBSAVE) {
//    		alert(">>> Validation <<<");
    			// 선택 한 체크박스의 갯수를 가져온다
    			var cnt = sheetObj.CheckedRows("selChk");
    			if(cnt < 1) {
    				ComShowCodeMessage('DOD00002');
    				return false;
    				
    			}else{
    				// 선택 한 체크박스의 rownum을 가져온다.
    				var iCheckRow = sheetObj.FindCheckedRow("selChk");
    				// 가져온 행을 배열로 만든다.
    				var arrRow = iCheckRow.split("|");	
    				
    				for(var i = 0; i < arrRow.length - 1; i++){
    					if(sheetObj.CellValue(arrRow[i], "dc_amt") != "0" &&
    							sheetObj.CellValue(arrRow[i], "dc_rmk") == ""){
    						ComShowCodeMessage('DOD00001', 'Remark');
    						sheetObj.SelectCell(arrRow[i], "dc_rmk");
    						return false;
    					}else if(sheetObj.CellValue(arrRow[i], "spcl_trf_amt") == "0" && sheetObj.CellValue(arrRow[i], "gen_trf_amt") == "0"){
    						ComShowCodeMessage('DOD00016');
    						return false;
    					}else if(sheetObj.CellValue(arrRow[i], "cust_seq") == ""){
    						ComShowCodeMessage('DOD00024');
    						return false;
    					}else if(sheetObj.CellValue(arrRow[i], "dc_rmk").length > 100){
    						ComShowCodeMessage('COM12173', '[Discount Remark]', '100');
    						sheetObj.SelectCell(arrRow[i], "dc_rmk");
    						return false;
    					}
    					
    					var custCdSeq = sheetObj.CellValue(arrRow[i], "cust_cd_seq");
    					checkINVCustomer(sheetObj, arrRow[i], custCdSeq);
    				}
    			}
    		}
        } 
        return true;
    }
    
	/* 개발자 작업  끝 */