/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0028.js
*@FileTitle :  Container Status Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.17 이호선
* 1.0 Creation
==============================================================
* 2010.07.05 남궁진호 - function setFieldOfStatusCode() 수정
* - Movement 발생이 180일 이상인건도 SELCOE에서 삭제가능하도록 함.
* 2010.08.31 남궁진호 - Ticket ID : CHM-201005684-01,function setFieldOfStatusCode()
* - SOC에 대한 LSI 삭제 조건을 Movement와 짝이 일치하는 경우(MT일때)
*   현장에서 삭제 가능 및 180 Days 조건 삭제
* - Status삭제시 Movement의 yard가 일치해야 가능하도록 변경           
* 2013.05.08 채창호 [CHM-201323977] FCIU4458183의 Min Day 수정 요청    
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
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
     * @class ees_mst_0028 : ees_mst_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0028() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;    
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var curdate = "";
    var tmpdate = "";
    var tmpagmtseq = "";
    var IBSEARCH01  = 29;
    var SEARCH_ENABLE = true;    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
     	var sheetObject2 = sheetObjects[1];
     	/*******************************************************/
     	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "New":
					formObject.cntr_no.value = "";
					formObject.aciac_div_cd.value = "";
					formObject.chk_dgt.value = "";
					formObject.cntr_tpsz_cd.value = "";
					formObject.lstm_cd.value = "";
					formObject.cntr_tpsz_iso_cd.value = "";
					formObject.ownr_co_cd.value = "";
					formObject.cntr_use_co_cd.value = "";
					formObject.cntr_use_co_cd.value = "";
					formObject.mnr_sld_chk.value = "N";
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					ComSetFocus(formObject.cntr_no);
				break;
				
				case "Save":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
				break;
				
				case "btn_Master":
					var cntr_no = formObject.cntr_no.value+formObject.chk_dgt.value;
					ComOpenPopup("/hanjin/EES_MST_0019.do?popup_mode=Y&cntr_no="+cntr_no,1020, 685, "", "1,0,1,1,1,1,1,1", true);
				break;
				
				case "Delete":
					doActionIBSheet(sheetObject2,document.form,IBDELETE);
				break;
				
				case "re_creation":
					doActionIBSheet(sheetObject2,document.form,MULTI);
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
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            sheetObjects[i].CountPosition = 0;
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }

 	// Axon 이벤트 처리
 	// 1. 이벤트catch
 	function initControl() {
 		var formObj = document.form;
 	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
 		axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
 		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- 키 눌렸을때
 		axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때
 		axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때.
 		axon_event.addListenerForm('onpaste',	'obj_change',	form); //- 변경될때.
 		formObj.cntr_no.focus();
 	}      
     
 	//Axon 이벤트 처리2. 이벤트처리함수
 	function obj_deactivate(){
 	    //ComChkObjValid(event.srcElement);
 	}
 	
 	function obj_activate(){
 	    //ComClearSeparator(event.srcElement);
 	}	
 	
   	/**
   	 * Key-Down Event 처리
   	 */
  	function obj_keydown() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;
  		
  		switch (obj.name) {
			case "cntr_no":
			if ( vKeyCode == 9 || vKeyCode == 13 ) {
	  			SEARCH_ENABLE = false;
	  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	  			SEARCH_ENABLE = true;
	  			ComSetFocus(formObj.cntr_no);	  			
	  		}
	  		break;
		}	  		
  	}
 	
   	function obj_keyup() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch(obj.name) {
  			case "cntr_no":
				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
					ComKeyEnter('LengthNextFocus');
				}
				break;
		}
  	}  	 
   	 
  	function obj_keypress(){
 	    
 	    obj = event.srcElement;
 	    if(obj.dataformat == null) return;
 	    window.defaultStatus = obj.dataformat;
 	    
 	    switch(obj.dataformat) {
 	        case "engup":
 	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
 	        break;
 	        case "int":
	        	if(obj.name=="chk_dgt") ComKeyOnlyNumber('int');
	        break;
 	    }        
 	}
  	
	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.chk_dgt.value ="";
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase();  // Copy&paste 소문자를 대문자로 변경
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
		    }
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
            case 1: // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 170;
                    // 전체 너비 설정
                	SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle1 = "|Seq.|H|CYC|STS|Auto|Origin Yard|Return Yard|Input Yard|Event Date|Act|Remark(s)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtHiddenStatus,			0,	daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,					40,	daCenter,	true,		"seq1");
					InitDataProperty(0, cnt++ , dtData,					30,	daCenter,	true,		"cnmv_co_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		"cnmv_cyc_no",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		"mvmt_sts_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		"mvmt_cre_tp_cd",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					85,	daCenter,	true,		"crnt_yd_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					85,	daCenter,	true,		"dest_yd_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					85,	daCenter,	true,		"inp_yd_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				 	120,daCenter,	true,		"cnmv_evnt_dt",		false,	"",		dfUserFormat2,0,			true,		true);					
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		"cntr_act_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		"cnmv_rmk",			false,	"",		dfNone,				0,			true,		true);
					
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "cnmv_yr",       false,     "",      dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "cnmv_id_no",    false,     "",      dfNone,        0,     true,       true);

					InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
			   }
         break;

		 case 2:    // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    var HeadTitle1 = "|Seq.|Del.|STS|ACT Date|Yard|AGMT No.|AGMT No.|Term|Contract No.|Lessor|Lessor Name|D/I Vendor|D/I Vendor Name|Office|Old/New|Pick Up Charge|Pick Up Credit|Min On-hire Days|Free Days|DII/DIO Fee|DOC Charge|DOC Credit|Lift On/Off Charge|Lift On/Off Charge|Term Change|Created Date|Update Date|Remark(s)|A|B|C|D";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 8, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false, false);
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,				0,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtDelCheck,			40,		daCenter,	true,		"sel",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"cntr_sts_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,		110,	daCenter,	true,		"cntr_sts_evnt_dt",		false,	"",		dfDateYmd,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	true,		"yd_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,	    daCenter,	true,		"agmt_cty_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,		90,	    daCenter,	true,		"agmt_seq",				false,	"",		dfNone,				0,			true,		true,6);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"lstm_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"ref_no",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				0,		daCenter,	true,		"vndr_seq",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		true,		"vndr_lgl_eng_nm",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"dir_itchg_vndr_seq",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				0,		daLeft,		true,		"dir_vndr_lgl_eng_nm",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtPopup,			80,		daCenter,	true,		"ofc_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,			0,		daCenter,	true,		"cntr_old_van_flg",		false,	"",		dfNone,				0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_pkup_chg_amt",	false,	"",		dfFloat,			2,			true,		true,7);
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_pkup_cr_chg_amt",	false,	"",		dfFloat,			2,			true,		true,7);
					
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_min_onh_dys",		false,	"",		dfInteger,			0,			true,		true,5);
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"rntl_chg_free_dys",	false,	"",		dfInteger,			0,			true,		true,5);
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_dir_itchg_fee_amt",false,	"",		dfFloat,			2,			true,		true,5);
					
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_drff_amt",		false,	"",		dfFloat,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				0,		daRight,	true,		"cntr_drff_cr_amt",		false,	"",		dfFloat,			2,			true,		true);
					
					InitDataProperty(0, cnt++ , dtPopup,			80,		daCenter,	true,		"curr_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"cntr_lft_chg_amt",		false,	"",		dfFloat,			2,			true,		true,7);
					InitDataProperty(0, cnt++ , dtData,				0,		daCenter,	true,		"cntr_lstm_cng_flg",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				110,		daCenter,	true,		"cre_dt",				false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				110,		daCenter,	true,		"upd_dt",				false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				200,		daLeft,		true,		"cntr_sts_rmk",			false,	"",		dfNone,				0,			true,		true);

                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "mvmt_sts_cd",       false,     "",      dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "cntr_sts_seq",       false,     "",      dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "time_local",       false,     "",      dfNone,        0,     true,       true);                    
                    InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "del_flg",       false,     "",      dfNone,        0,     true,       true);                    
					
                    InitDataCombo(0, "cntr_old_van_flg", "Old|New", "Y|N");	
                    
				    //각 필드마다 입력 형태 CHECK
					InitDataValid(0, "agmt_seq", vtNumericOnly);   //영문만 
					InitDataValid(0, "yd_cd", vtEngUpOther, "0123456789"); //영문과 숫자
					InitDataValid(0, "cntr_sts_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+()' ");   //영문만                    
                    
                    ImageList(0) = "img/btns_search.gif";
                    ImageList(1) = "img/btns_search.gif";
                    ImageList(2) = "img/btns_search.gif";
                    
                    PopupButtonImage(0, "agmt_seq") = 0;
                    PopupButtonImage(0, "ofc_cd") = 0;
                    PopupButtonImage(0, "curr_cd") = 0;
                    
                    PopupImage  =  "img/btns_calendar.gif";
                    ShowButtonImage = 1;
                    SelectFontBold = true;
                    SelectHighLight = false;                      
			   }
         break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
					
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
	            	formObj.f_cmd.value = SEARCH;
	            	if (formObj.cntr_no.value.trim().length == 0) {
	            		ComOpenWait(false);	            		
	            		ComShowCodeMessage("MST00001","Cntr No.");
	            		formObj.cntr_no.focus();
	            		return;
	            	} 
	            	
	            	var sXml = sheetObj.GetSearchXml("EES_MST_0028GS.do", FormQueryString(formObj));
	    			if (sXml.indexOf("# ERROR") != -1 || sXml.indexOf("# Error") != -1){
	     			   sheetObj.LoadSearchXml(sXml);
	     			   ComOpenWait(false);
	     			   return;
	     			}    
	            	var arrXml = sXml.split("|$$|");
	                // 입력 박스 데이타 채우기 	  
	            	formObj.chk_dgt.value          = ComXmlString(arrXml[0], "chk_dgt");
	            	formObj.aciac_div_cd.value     = ComXmlString(arrXml[0], "aciac_div_cd");
	            	formObj.cntr_tpsz_cd.value     = ComXmlString(arrXml[0], "cntr_tpsz_cd");
	            	formObj.lstm_cd.value          = ComXmlString(arrXml[0], "lstm_cd");
	            	formObj.cntr_tpsz_iso_cd.value = ComXmlString(arrXml[0], "cntr_tpsz_iso_cd");
	            	formObj.ownr_co_cd.value       = ComXmlString(arrXml[0], "ownr_co_cd");
	            	formObj.cntr_use_co_cd.value   = ComXmlString(arrXml[0], "cntr_use_co_cd");
	            	formObj.mnr_sld_chk.value  	   = ComXmlString(arrXml[0], "mnr_sld_chk");
	            	//시트 데이타 채우기
	            	if (arrXml.length > 1) sheetObjects[0].LoadSearchXml(arrXml[1]);            	
	            	if (arrXml.length > 2) sheetObjects[1].LoadSearchXml(arrXml[2]);
	                //STS별  Cell 수정여부 Set 
	            	setFieldOfStatusCode();
	            	//re-creation 버튼 set
	            	setBtnReCreation();
	            	sheetObjects[0].SelectRow = sheetObjects[0].RowCount;
	            	sheetObjects[0].TopRow = sheetObjects[0].RowCount;
	            	sheetObjects[1].SelectRow = sheetObjects[1].RowCount;
	            	sheetObjects[1].TopRow = sheetObjects[1].RowCount;
	            	ComOpenWait(false);
				}
			break;
			
            case IBSEARCH01:
				formObj.f_cmd.value = SEARCH05;
            	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", "f_cmd=105&agmt_cty_cd="+sheetObj.CellValue(sheetObj.SelectRow, "agmt_cty_cd")+"&agmt_seq="+sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq"));
    			var chk = sXml.indexOf("ERROR");
    			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    			   sheetObj.LoadSearchXml(sXml);
    			   return;
    			}            	
           	    var lstmcd = ComXmlString(sXml, "lstm_cd");
       	    	if ((lstmcd == "OW" || 
       	    		 lstmcd == "LP" ||
       	    		 lstmcd == "OL" ||
       	    		 lstmcd == "SO" ||
       	    		 lstmcd == "MO") && sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "LSI"){
          	    	 ComShowCodeMessage("MST01003");
          	    	 sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq") = tmpagmtseq;
          	    	 return;
          	    }       	    	
      	    	if (sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "SBO" && lstmcd != "SO"){
      	    		ComShowCodeMessage("MST01003");
      	    		sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq") = tmpagmtseq;
      	    		return;
      	    	}
      	    	if (sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "MUO" && lstmcd != "MO"){
      	    		ComShowCodeMessage("MST01003");
      	    		sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq") = tmpagmtseq;
      	    		return;
      	    	}       	    	

     	    	if (ComXmlString(sXml, "ref_no") != ""){
	       	    	sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq") = ComXmlString(sXml, "agmt_seq");
	       	    	sheetObj.CellValue(sheetObj.SelectRow, "lstm_cd") = lstmcd;
	       	    	sheetObj.CellValue(sheetObj.SelectRow, "ref_no") = ComXmlString(sXml, "ref_no");
	       	    	sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq") = ComXmlString(sXml, "vndr_seq");
	       	    	sheetObj.CellValue(sheetObj.SelectRow, "vndr_lgl_eng_nm") = ComXmlString(sXml, "vndr_lgl_eng_nm");
	       	    	
	       	    	if ((sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "SBO" ||
	       	    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "MUO") && sheetObj.SelectRow != sheetObj.LastRow){
		       	    	sheetObj.CellValue(sheetObj.SelectRow+1, "agmt_seq") = ComXmlString(sXml, "agmt_seq");
		       	    	sheetObj.CellValue(sheetObj.SelectRow+1, "lstm_cd") = lstmcd;
		       	    	sheetObj.CellValue(sheetObj.SelectRow+1, "ref_no") = ComXmlString(sXml, "ref_no");
		       	    	sheetObj.CellValue(sheetObj.SelectRow+1, "vndr_seq") = ComXmlString(sXml, "vndr_seq");
		       	    	sheetObj.CellValue(sheetObj.SelectRow+1, "vndr_lgl_eng_nm") = ComXmlString(sXml, "vndr_lgl_eng_nm");	       	    		
	       	    	} else if (sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_cd") == "LSI"){
       	    	             for(var k = sheetObj.SelectRow+1; k <= sheetObj.LastRow; k++){
       	    	    	         if (sheetObj.CellValue(k, "cntr_sts_cd") == "LSO" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "LST" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "FND" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "SCR" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "DON" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "TLL" ||
       	    	    	             sheetObj.CellValue(k, "cntr_sts_cd") == "SRO"){
	       	    	    	    
       	    	    	        	 	sheetObj.CellValue(k, "agmt_seq") = ComXmlString(sXml, "agmt_seq");
       	    	    	        	 	sheetObj.CellValue(k, "ref_no") = ComXmlString(sXml, "ref_no");
       	    	    	        	 	sheetObj.CellValue(k, "lstm_cd") = lstmcd;
       	    	    	        	 	sheetObj.CellValue(k, "vndr_seq") = ComXmlString(sXml, "vndr_seq");
       	    	    	        	 	sheetObj.CellValue(k, "vndr_lgl_eng_nm") = ComXmlString(sXml, "vndr_lgl_eng_nm");	   
       	    	    	         } else if (sheetObj.CellValue(k, "cntr_sts_cd") == "LSI" || 
       	    	    	        		sheetObj.CellValue(k, "cntr_sts_cd") == "DII" || 
       	    	    	        		sheetObj.CellValue(k, "cntr_sts_cd") == "OWN"){
       	    	    	        	 	break;
       	    	    	         }
       	    	    	    }
       	    	       }
     	    	} else {
     	    		ComShowCodeMessage("MST01003");
     	    		sheetObj.CellValue(sheetObj.SelectRow, "agmt_seq") = tmpagmtseq;
     	    		doActionIBSheet(sheetObj, formObj, IBSEARCH01);
     	    	}
   	    	
            break;			
			
			case IBSAVE:        //저장
		    	if (sheetObj.RowCount == 0){
			       ComShowCodeMessage("MST00001", "Status History Row");
			       return;
			    }
			
			    var chgflg = false; 
			    var gubun = "";
			    for (var i = 1; i <= sheetObj.RowCount; i++){
			    	if (sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "D") {
			    		chgflg = true;
			    		if (sheetObj.CellValue(i, "cntr_sts_cd") == "LSI"){
			    			gubun = "1";
			    		}
			    	}
			    	var lftamt = parseFloat(sheetObj.CellValue(i,"cntr_lft_chg_amt"));
			    	var currcd = sheetObj.CellValue(i,"curr_cd");
			    	if (lftamt > 0 && currcd == ""){
			    		ComShowCodeMessage("MST00001", "Lift On/Off Charge Currency.");
			    		sheetObj.SelectCell(i,"cntr_lft_chg_amt");
			    		return;
			    	}
			    }
			    
			    if (chgflg == false){
			       ComShowCodeMessage("MST00012");
			       return;
			    }
			    
			    if (sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "LSO" && 
			    	sheetObj.RowStatus(sheetObj.RowCount) == "D" &&
			    	formObj.lstm_cd.value == "SH"){
			    	ComShowCodeMessage("MST02025");
			    	return;
			    }
			    
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
			    	formObj.f_cmd.value = MULTI;			
	     	        var sParam = ComGetSaveString(sheetObj);
	     	        
	     	        //마지막 것이 LSI인것을 변경 저장할때 GUBUN : 1
	     	        if (gubun == "1" && sheetObj.RowStatus(sheetObj.RowCount) == "U") {
	     	            sParam += "&" + FormQueryString(formObj)+"&gubun="+gubun+"&chk_dgt="+formObj.chk_dgt.value;	
	     	        } 
	     	        else if ((sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "LSO" || 
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "SBO" || 
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "MUO" ||
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "LST" ||
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "SRO" )
	     	        	      && sheetObj.RowStatus(sheetObj.RowCount) == "D"){
	     	            sParam += "&" + FormQueryString(formObj)+"&gubun=2&chk_dgt="+formObj.chk_dgt.value+
	     	            "&cnmv_yr="+sheetObjects[0].CellValue(sheetObjects[0].RowCount, "cnmv_yr")+
	     	            "&cnmv_id_no="+sheetObjects[0].CellValue(sheetObjects[0].RowCount, "cnmv_id_no");
	     	        } 
	     	        else if ((sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "LSI" || 
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "SBI" ||
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "MUI" ||
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "FND" ||
	     	        		  sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "SRI" )
		     	       	      && sheetObj.RowStatus(sheetObj.RowCount) == "D"){
		     	        sParam += "&" + FormQueryString(formObj)+"&gubun=3&chk_dgt="+formObj.chk_dgt.value+
	     	            "&cnmv_yr="+sheetObjects[0].CellValue(sheetObjects[0].RowCount, "cnmv_yr")+
	     	            "&cnmv_id_no="+sheetObjects[0].CellValue(sheetObjects[0].RowCount, "cnmv_id_no");
		     	       
		     	       if (sheetObj.CellValue(sheetObj.RowCount, "seq") == "1"){
		     	    	   sParam += "&mst_del_flg=Y";
		     	       }
	     	        }
	     	        else if (sheetObj.CellValue(sheetObj.RowCount, "cntr_sts_cd")== "SLD" &&
		     	       	     sheetObj.RowStatus(sheetObj.RowCount) == "D"){
		     	        sParam += "&" + FormQueryString(formObj)+"&gubun=4";
		     	       if (sheetObj.CellValue(sheetObj.RowCount, "seq") == "1"){
		     	    	   sParam += "&mst_del_flg=Y";
		     	       }
	     	        }
	     	        else {
	     	            sParam += "&" + FormQueryString(formObj);
	     	        }
					var sXml = sheetObj.GetSaveXml("EES_MST_0028GS.do", sParam);
					ComOpenWait(false);
					var chk = sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") == -1 && sXml.indexOf("Error") == -1){
						ComShowCodeMessage("MST01025");
					} else {
						sheetObj.LoadSearchXml(sXml);
						return;
					}
					
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
			break;
			
			case IBDELETE:
	   	   		if (sheetObj.id == 'sheet2') {  
	   	   		    sheetObj.SelectFontBold = false;
		   	   		if(sheetObj.FindCheckedRow("sel") != ""){
						ComRowHideDelete(sheetObj,"sel"); 
						sheetObj.SelectFontBold = true;
					}
				}    			
			    break;
			    
			case MULTI:        //re-creation
			if(validateForm(sheetObj,formObj,sAction)){
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);					
		    	formObj.f_cmd.value = MULTI01;			
     	        var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("EES_MST_0028GS.do", sParam);
				ComOpenWait(false);
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") == -1 && sXml.indexOf("Error") == -1){
					ComShowCodeMessage("MST01025");
				} else {
					sheetObj.LoadSearchXml(sXml);
					return;
				}
				
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		break;
			
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
        
	function setFieldOfStatusCode(){
	  	var formObj = document.form;
	    var sheetObj = sheetObjects[1];
	    var ofcCd	= formObj.hid_ofc_cd.value;
	    var lstmCd  = formObj.lstm_cd.value;  //SH Term 체크 하기위해 추가
	    
	    var stsval = sheetObjects[0].CellValue(sheetObjects[0].RowCount, "mvmt_sts_cd");
		var stsrmk = sheetObjects[0].CellValue(sheetObjects[0].RowCount, "cnmv_rmk");
		var ststpcd = sheetObjects[0].CellValue(sheetObjects[0].RowCount, "mvmt_cre_tp_cd");
		var stsyard = sheetObjects[0].CellValue(sheetObjects[0].RowCount, "crnt_yd_cd");   // yard
		    
		stsrmk = stsrmk.substring(0,3);
//	    alert("stsval:"+stsval + ":"+ "ststpcd:"+ststpcd+":"+"stsrmk:"+stsrmk)
	    for (var i = 1; i <= sheetObj.RowCount; i++){
	       SetCellEditableFalse(i);
	       if (sheetObj.CellValue(i,"cntr_lstm_cng_flg") == "N"){
 	    	   var edt 	  = sheetObj.CellValue(i,"cntr_sts_evnt_dt");
		       var retgap = getMonthInterval(edt.replace("-",""), toTimeString(new Date()).substring(0,8)+"0001");
		       var ydcd   = sheetObj.CellValue(i,"yd_cd");
		     
		       if (sheetObj.CellValue(i, "cntr_sts_cd") == "LSI" && i == sheetObj.RowCount){		    	   
		    	   if (retgap < 7){
		    		   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능 	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   if (stsyard == ydcd ){ // yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
	    			   }
	    			   
		    		   /*
		    		   if(sheetObj.CellValue(i,"del_flg") == "O") {
		    			   sheetObj.CellEditable(i,"sel") = true;
	    		   		} else {
	    		   			sheetObj.CellEditable(i,"sel") = false; 
	    		   		}
		    	   		*/		    			   
	    			   //end
		    		   
				       sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
				       if (sheetObj.CellValue(i,"cntr_lstm_cng_flg") == "Y"){
				          sheetObj.CellEditable(i,"yd_cd") = true;
				       }
				       //sheetObj.CellEditable(i,"agmt_cty_cd") = true; 
				       sheetObj.CellEditable(i,"agmt_seq") = true;
				       //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함		       
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
				       sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
				       sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;
				       sheetObj.CellEditable(i,"cntr_min_onh_dys") = true;
				       sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
				       if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.CellEditable(i,"curr_cd") = true;
				       }
				       sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
				       sheetObj.CellEditable(i,"curr_cd") = true;
				       sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
				       
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_min_onh_dys") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0 && lstmCd != "SH"){  // 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		  // var lstmCd = sheetObj.CellValue(i,"lstm_cd");  //SH Term 체크 하기위해 추가
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){		    			 
		    		 // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능 	     			   
		    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
		    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
		    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
		    					   sheetObj.CellEditable(i,"sel") = true;
		    				   }
		    			   }
		    		   }
		    		 //Lease Term이 SH 이고 MVMT STS가 MT (LSI매칭)일경우는 180일이 지난경우에도 삭제가능하도록 처리함 2010.08.30
//		    		   if (lstmCd =="SH" && stsval == "MT" && stsrmk == "LSI"){  
//		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
//	    					   sheetObj.CellEditable(i,"sel") = true;
//	    				   }
//		    		   }
		    	   }else if(lstmCd =="SH" && stsval == "MT" && stsrmk == "LSI" && stsyard == ydcd){
		    		   //Lease Term이 SH 이고 MVMT STS가 MT (LSI매칭)일경우는 180일이 지난경우에도 삭제가능하도록 처리함 2012.05.11
                      sheetObj.CellEditable(i,"sel") = true;
                      sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
			          if (sheetObj.CellValue(i,"cntr_lstm_cng_flg") == "Y"){
			             sheetObj.CellEditable(i,"yd_cd") = true;
			          }
			          //sheetObj.CellEditable(i,"agmt_cty_cd") = true; 
			          sheetObj.CellEditable(i,"agmt_seq") = true;
			          //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함                            
			          if (formObj.hid_ofc_cd.value == "SELCON") {
			                    sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
			          }
			          sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			          sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;
			          sheetObj.CellEditable(i,"cntr_min_onh_dys") = true;
			          sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
			          if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
			              sheetObj.CellEditable(i,"curr_cd") = true;
			          }
			          sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
			          sheetObj.CellEditable(i,"curr_cd") = true;
			          sheetObj.CellEditable(i,"cntr_sts_rmk")          = true;
			          
			          sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
			          sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
			          sheetObj.MinimumValue(i, "cntr_min_onh_dys") = 0;
			          sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
			          sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;                                                                                  
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "LSI" && i != sheetObj.RowCount) {
		    	   if (retgap < 7){	       
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
				       if (sheetObj.CellValue(i,"cntr_lstm_cng_flg") == "Y"){
				          sheetObj.CellEditable(i,"yd_cd") = true;
				       } 
				       //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함		       
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }				       
			    	   //sheetObj.CellEditable(i,"agmt_cty_cd") = true;            
			    	   sheetObj.CellEditable(i,"agmt_seq") = true;               
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_min_onh_dys") = true;       
			    	   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
				       if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.CellEditable(i,"curr_cd") = true;
				       }
				       sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
				       sheetObj.CellEditable(i,"curr_cd") = true;
			    	   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
			    	   
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_min_onh_dys") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;		    	   
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "LSO" && i == sheetObj.RowCount){	
		    	   //ComDebug("retgap : " + retgap);
		    	   if (retgap < 7){		    	   
		    		   sheetObj.CellEditable(i,"sel") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;
				       if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.CellEditable(i,"curr_cd") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   //ComDebug("cntr_sts_rmk - 1 : " + sheetObj.CellEditable(i,"cntr_sts_rmk"));
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
		    			       if(lstmCd =="SH"){
		    			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;  
		    			       }
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "LSO" && i != sheetObj.RowCount){	
		    	   if (retgap < 7){	
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;
				       if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.CellEditable(i,"curr_cd") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "MUO" && i == sheetObj.RowCount){  
		    	   if (retgap < 7){
		    		   sheetObj.CellEditable(i,"sel") = true;	    	   
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;         
		    		   sheetObj.CellEditable(i,"agmt_seq") = true;                 
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
			    	   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;				       
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "MUO" && i != sheetObj.RowCount){
		    	  if (retgap < 7){		    	   
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;         
		    		   sheetObj.CellEditable(i,"agmt_seq") = true;                 
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
			    	   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;			    	   
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
		    	   }	    	   
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "MUI" && i != sheetObj.RowCount){
		    	   if (retgap < 7){		       
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (ofcCd == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;		    		   
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "MUI" && i == sheetObj.RowCount){
		    	   if (retgap < 7){		
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (ofcCd == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
				       
	    			   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   sheetObj.CellEditable(i,"sel") = true;
	    			   }
	    			   //end
	    			   
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;					       
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			// XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능
			    		   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
			    			   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
				    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
			    					   sheetObj.CellEditable(i,"sel") = true;
			    				   }
			    			   }
			    			   //end
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SRO" && i == sheetObj.RowCount ){  
		    	   if (retgap < 7){
		    		   sheetObj.CellEditable(i,"sel") = true;	    	   
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;         
		    		   sheetObj.CellEditable(i,"agmt_seq") = true;                 
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
			    	   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;				       
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SRO" && i != sheetObj.RowCount){
		    	  if (retgap < 7){		    	   
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;         
		    		   sheetObj.CellEditable(i,"agmt_seq") = true;                 
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
			    	   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;			    	   
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
		    	   }	    	   
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SRI" && i != sheetObj.RowCount){
		    	   if (retgap < 7){		       
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (ofcCd == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;		    		   
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SRI" && i == sheetObj.RowCount){
		    	   if (retgap < 7){		
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (ofcCd == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }
				       
	    			   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "SRI" || stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
	    			   }
	    			   //end
	    			   
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;					       
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			// XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능
			    		   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
			    			   stsrmk == "SRI" ||   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
				    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
			    					   sheetObj.CellEditable(i,"sel") = true;
			    				   }
			    			   }
			    			   //end
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SBO" && i == sheetObj.RowCount){
		    	   if (retgap < 7){		    	   
		    		   sheetObj.CellEditable(i,"sel") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   sheetObj.CellEditable(i,"agmt_seq") = true;
		    		   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;    
		    		   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SBO" && i != sheetObj.RowCount){
		    	   if (retgap < 7){		    	   
		    		   sheetObj.CellEditable(i,"agmt_seq") = true; 
		    		   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
			    	   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;    
		    		   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;				       
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SBI" && i == sheetObj.RowCount){
		    	   if (retgap < 7){
				       if (sheetObj.CellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.CellEditable(i,"curr_cd") = true;
				       }

	    			   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
	    			   }
	    			   //end
				       
				       sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;		    		   
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			// XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
		    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
		    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
		    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
		    					   sheetObj.CellEditable(i,"sel") = true;
		    				   }
		    			   }
		    			   //end
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SBI" && i != sheetObj.RowCount){
		    	   if (retgap < 7){		    	   
			    	   //3.Old/New는 Lease 장비만 해당되므로 edit가 가능하지만, 단 SELCON 만 변경 가능하게 해야 함
				       if (formObj.hid_ofc_cd.value == "SELCON") {
				    	   sheetObj.CellEditable(i,"cntr_old_van_flg") = true;
				       }	   
				       sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;
		    		   sheetObj.CellEditable(i,"cntr_min_onh_dys") = true;       
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   sheetObj.CellEditable(i,"cntr_drff_amt") = true;          
		    		   sheetObj.CellEditable(i,"cntr_drff_cr_amt") = true;
		    		   sheetObj.CellEditable(i,"cntr_lft_chg_amt") = true;
		    		   sheetObj.CellEditable(i,"curr_cd") = true;
		    		   
				       sheetObj.MinimumValue(i, "cntr_min_onh_dys") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;	
				       sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;				       
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "TTL"){
		    	   if (retgap < 7){		    	   
			    	   sheetObj.CellEditable(i,"sel") = true;
		    		   sheetObj.CellEditable(i,"cntr_pkup_chg_amt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_pkup_cr_chg_amt") = true;    
		    		   sheetObj.CellEditable(i,"rntl_chg_free_dys") = true;       
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk")	= true;
		    		   
				       sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				       sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "LST" && i == sheetObj.RowCount){
		    	 
		    	   if (retgap < 7){
		    		   sheetObj.CellEditable(i,"sel") = true;
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk") = true;
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "LST" && i != sheetObj.RowCount){
		    	   if (retgap < 7){	
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk") = true;
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "FND" && i == sheetObj.RowCount){
		    	   if (retgap < 7){
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
		    		   sheetObj.CellEditable(i,"cntr_sts_rmk") = true;
		    		   
	    			   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR" || stsrmk == "FND"))){
	    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
	    					   sheetObj.CellEditable(i,"sel") = true;
	    				   }
	    			   }
	    			   //end
		    	   }else if(retgap >= 7 && sheetObjects[0].RowCount >0){// 180일이 지난건에 대해서도 SELCON에서는 삭제가능 
		    		   if(ofcCd=="SELCON" || ofcCd=="CLTCO" ){
		    			   // XX 이거나  Movement 자동생성 이거나 MT이면서 remark가 LSI, ....일때만 삭제 가능	    			   
		    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
		    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR" || stsrmk == "FND"))){
		    				   if (stsyard == ydcd ){// yd cd가 같을경우만 삭제
		    					   sheetObj.CellEditable(i,"sel") = true;
		    				   }
		    			   }
		    			   //end
		    		   }
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "FND" && i != sheetObj.RowCount){
		    	   if (retgap < 7){	 
			    	   sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
			    	   sheetObj.CellEditable(i,"cntr_sts_rmk") = true;
		    	   }
		       } else if (sheetObj.CellValue(i, "cntr_sts_cd") == "SLD"){
		    	   if (retgap < 7){	
				       sheetObj.CellEditable(i,"cntr_sts_evnt_dt") = true;       
				       sheetObj.CellEditable(i,"cntr_sts_rmk") = true;
				       if(ofcCd=="SELCON"){
				    	   sheetObj.CellEditable(i,"sel") = true;
				       }
		    	   }
		       }
	       }
	    }
	    //min_onh_dys 활성화를 위한 조치  맨 마지막 첫번째 LSI만   min_onh_dys 컬럼 활성화 시킨다.
	    var key = 0;
	    for (var j = sheetObj.RowCount; j > 0; j--){
	    	if (sheetObj.CellValue(j, "cntr_sts_cd") == "LSI"){
	    		if(key == 0){
	    		sheetObj.CellEditable(j,"cntr_min_onh_dys") = true;
	    		   key = 1;
	    		}
	    	}
	    }
	}
	
	function SetCellEditableFalse(cnt){
		var sheetObj = sheetObjects[1];
		sheetObj.CellEditable(cnt,"sel") = false;
		sheetObj.CellEditable(cnt,"cntr_sts_cd") = false;                
		sheetObj.CellEditable(cnt,"cntr_sts_evnt_dt") = false;           
		sheetObj.CellEditable(cnt,"yd_cd") = false;                      
		sheetObj.CellEditable(cnt,"agmt_cty_cd") = false;                
		sheetObj.CellEditable(cnt,"agmt_seq") = false;                   
		sheetObj.CellEditable(cnt,"lstm_cd") = false;                    
		sheetObj.CellEditable(cnt,"ref_no") = false;                     
		sheetObj.CellEditable(cnt,"vndr_seq") = false;                   
		sheetObj.CellEditable(cnt,"vndr_lgl_eng_nm") = false;            
		sheetObj.CellEditable(cnt,"dir_itchg_vndr_seq") = false;         
		sheetObj.CellEditable(cnt,"dir_vndr_lgl_eng_nm")	= false;       
		sheetObj.CellEditable(cnt,"ofc_cd") = false;                     
		sheetObj.CellEditable(cnt,"cntr_old_van_flg") = false;           
		sheetObj.CellEditable(cnt,"cntr_pkup_chg_amt") = false;          
		sheetObj.CellEditable(cnt,"cntr_pkup_cr_chg_amt") = false;       
		sheetObj.CellEditable(cnt,"cntr_min_onh_dys") = false;           
		sheetObj.CellEditable(cnt,"rntl_chg_free_dys") = false;          
		sheetObj.CellEditable(cnt,"cntr_dir_itchg_fee_amt") = false;     
		sheetObj.CellEditable(cnt,"cntr_drff_amt") = false;              
		sheetObj.CellEditable(cnt,"cntr_drff_cr_amt") = false;           
		sheetObj.CellEditable(cnt,"cntr_lft_chg_amt") = false;           
		sheetObj.CellEditable(cnt,"cntr_lstm_cng_flg")	= false;       
		sheetObj.CellEditable(cnt,"cre_dt") = false;                     
		sheetObj.CellEditable(cnt,"upd_dt") = false;                     
		sheetObj.CellEditable(cnt,"cntr_sts_rmk")	= false;  
		sheetObj.CellEditable(cnt,"curr_cd")	= false;
	}
	
    /**
     * 아이비시트 팝업 클릭시 이벤트
     */
    function sheet2_OnPopupClick(sheetObj, Row,Col,Value){
         if (sheetObj.ColSaveName(Col) == "cntr_sts_evnt_dt" ) {
        	 
        	 tmpdate = sheetObj.CellValue(Row,"cntr_sts_evnt_dt" );
	         var cal = new ComCalendarGrid("myCal");
	         cal.setEndFunction("nextFocusOut");
	         cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	         
         } else if (sheetObj.ColSaveName(Col) == "agmt_seq"){ 
        	 ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true, true, Row, Col);
         } else if (sheetObj.ColSaveName(Col) == "ofc_cd"){
        	 ComOpenPopup('/hanjin/COM_ENS_071.do', 770, 510, 'getCOM_ENS_071_1', '1,0,1,1,1,1,1,1', true, true, Row, Col);
         } else if (sheetObj.ColSaveName(Col) == "curr_cd"){
        	 var param = "cnt_cd=&curr_cd="+sheetObj.CellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/hanjin/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 500, 420, 'setPopData_Currency', '0,0,1', true, true, Row, "curr_cd", 1);
         }
    }
     
    function nextFocusOut(){
    	checkACTDate();
     }
    
     function sheet2_OnBeforeEdit(sheetObj, Row,Col){
    	var sName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
        if (sName == "cntr_sts_evnt_dt"){
    	   tmpdate = sheetObj.CellValue(sheetObj.SelectRow,"cntr_sts_evnt_dt");
        } else if (sName == "agmt_seq"){
        	tmpagmtseq = sheetObj.CellValue(sheetObj.SelectRow,"agmt_seq");	
        }
     }
    
     function sheet2_OnAfterEdit(sheetObj, Row,Col){
    	var sName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
    	if (sName == "cntr_sts_evnt_dt"){
           checkACTDate();
    	} else if (sName == "agmt_seq"){
    		var agmt_seq = sheetObj.CellValue(sheetObj.SelectRow,"agmt_seq")
	    	if (agmt_seq.trim().length > 0){    			
	    	   doActionIBSheet(sheetObj, formObj, IBSEARCH01);
		   	}    		
    	}
     }
     
     function sheet2_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	 var sName = SheetObj.ColSaveName(Col);
         if (sName == "cntr_pkup_chg_amt"){
        	 if(SheetObj.CellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||
        		SheetObj.CellEditable(Row,"cntr_pkup_chg_amt") == true){
         	    if (KeyCode != 9)
          	       SheetObj.CellValue(Row,"cntr_pkup_cr_chg_amt") = 0;
        	 }
         }
         else if (sName == "cntr_pkup_cr_chg_amt"){
        	 if(SheetObj.CellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||
             	SheetObj.CellEditable(Row,"cntr_pkup_chg_amt") == true){
        		 
        		 if (KeyCode != 9)
        	    SheetObj.CellValue(Row,"cntr_pkup_chg_amt") = 0;
        	 }
         }
         else if (sName == "cntr_drff_amt"){
        	 if(SheetObj.CellEditable(Row,"cntr_drff_cr_amt") == true ||
        		SheetObj.CellEditable(Row,"cntr_drff_amt") == true){
         	    if (KeyCode != 9)
          	       SheetObj.CellValue(Row,"cntr_drff_cr_amt") = 0;
        	 }
         }
         else if (sName == "cntr_drff_cr_amt"){
        	 if(SheetObj.CellEditable(Row,"cntr_drff_cr_amt") == true ||
             	SheetObj.CellEditable(Row,"cntr_drff_amt") == true){
        		 
        		 if (KeyCode != 9)
        	    SheetObj.CellValue(Row,"cntr_drff_amt") = 0;
        	 }
         }         
     }       
     
     function checkACTDate(){
    	var sheetObj = sheetObjects[1];
  	    var edt = sheetObj.CellValue(sheetObj.SelectRow,"cntr_sts_evnt_dt");
  	    
    	if (ComGetNowInfo("ymd") < edt){
    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
    		ComShowCodeMessage("MST01006");
    		return;
    	}     
  	    
	    var retgap = getMonthInterval(edt.replace("-",""), toTimeString(new Date()).substring(0,8)+"0001");
	    if (retgap < 7){    
	     	if (sheetObj.SelectRow != 1) {
	 	    	if (sheetObj.CellValue(sheetObj.SelectRow - 1, "cntr_sts_evnt_dt") > sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02016");
	 	    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
	 	    		return;
	 	    	}
	     	}
	     	
	     	if(sheetObj.SelectRow == 1 && sheetObj.RowCount != 1) {
	 	    	if (sheetObj.CellValue(sheetObj.SelectRow + 1, "cntr_sts_evnt_dt") < sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02017");
	 	    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
	 	    		return;
	 	    	} 	     		
	     	}
	     	
	     	if(sheetObj.SelectRow == sheetObj.RowCount && sheetObj.RowCount != 1) {
	 	    	if (sheetObj.CellValue(sheetObj.SelectRow - 1, "cntr_sts_evnt_dt") > sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02016");
	 	    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
	 	    		return;
	 	    	}	     		
	     	}
	     	
	     	if (sheetObj.SelectRow != sheetObj.RowCount && sheetObj.SelectRow != 1){
	 	    	if (sheetObj.CellValue(sheetObj.SelectRow + 1, "cntr_sts_evnt_dt") < sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02017");
	 	    		sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
	 	    		return;
	 	    	}     		
	     	}
	    } else {
    		ComShowCodeMessage("MST02018");
	    	sheetObj.CellValue(sheetObj.SelectRow, "cntr_sts_evnt_dt") = tmpdate;
 	    	return;	    	
	    }    	 
     }
     
   	/**
   	 * Currency Pop-up Return Value 처리 부분<br>
   	 * @param {arry} returnedValues Pop-up 화면의 Return value array
   	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
   	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
   	 * @param 대상IBSheet의 Sheet Array index
   	 */
   	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
   	    var formObj  = document.form;
   	    var sheetObj = sheetObjects[1];
   	    if ( aryPopupData.length > 0 ) {
   	    	if ((aryPopupData[0][6] == "OW" || 
   	    		 aryPopupData[0][6] == "LP" ||
   	    		 aryPopupData[0][6] == "OL" ||
   	    		 aryPopupData[0][6] == "SO" ||
   	    		 aryPopupData[0][6] == "MO") && sheetObj.CellValue(Row, "cntr_sts_cd") == "LSI"){
   	    		ComShowCodeMessage("MST01003");
   	    		return;
   	    	}
  	    	if (sheetObj.CellValue(Row, "cntr_sts_cd") == "SBO" && aryPopupData[0][6] != "SO"){
  	    		ComShowCodeMessage("MST01003");
  	    		return;
  	    	}
  	    	if (sheetObj.CellValue(Row, "cntr_sts_cd") == "MUO" && aryPopupData[0][6] != "MO"){
  	    		ComShowCodeMessage("MST01003");
  	    		return;
  	    	}
   	    	
   	    	sheetObj.CellValue(Row, "agmt_cty_cd") = aryPopupData[0][3];
   	    	sheetObj.CellValue(Row, "agmt_seq") = aryPopupData[0][4];
   	    	sheetObj.CellValue(Row, "ref_no") = aryPopupData[0][5];
   	    	sheetObj.CellValue(Row, "lstm_cd") = aryPopupData[0][6];
   	    	sheetObj.CellValue(Row, "vndr_seq") = aryPopupData[0][7];
   	    	sheetObj.CellValue(Row, "vndr_lgl_eng_nm") = aryPopupData[0][8];
   	    	
   	    	if ((sheetObj.CellValue(Row, "cntr_sts_cd") == "SBO" ||
    	    	 sheetObj.CellValue(Row, "cntr_sts_cd") == "MUO") && sheetObj.SelectRow != sheetObj.LastRow){
   	    	     sheetObj.CellValue(Row+1, "agmt_cty_cd") = aryPopupData[0][3];
	       	     sheetObj.CellValue(Row+1, "agmt_seq") = aryPopupData[0][4];
	       	     sheetObj.CellValue(Row+1, "ref_no") = aryPopupData[0][5];
	       	     sheetObj.CellValue(Row+1, "lstm_cd") = aryPopupData[0][6];
	       	     sheetObj.CellValue(Row+1, "vndr_seq") = aryPopupData[0][7];
	       	     sheetObj.CellValue(Row+1, "vndr_lgl_eng_nm") = aryPopupData[0][8];
       	    } else if (sheetObj.CellValue(Row, "cntr_sts_cd") == "LSI"){
   	    	     for(var k = Row+1; k <= sheetObj.LastRow; k++){
   	    	    	if (sheetObj.CellValue(k, "cntr_sts_cd") == "LSO" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "LST" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "FND" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "SCR" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "DON" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "TLL" ||
   	    	    	    sheetObj.CellValue(k, "cntr_sts_cd") == "SRO"){
   	    	    	    
   	    	    		sheetObj.CellValue(k, "agmt_cty_cd") = aryPopupData[0][3];
   	    	    		sheetObj.CellValue(k, "agmt_seq") = aryPopupData[0][4];
   	    	    		sheetObj.CellValue(k, "ref_no") = aryPopupData[0][5];
   	    	    		sheetObj.CellValue(k, "lstm_cd") = aryPopupData[0][6];
   	    	    		sheetObj.CellValue(k, "vndr_seq") = aryPopupData[0][7];
   	    	    		sheetObj.CellValue(k, "vndr_lgl_eng_nm") = aryPopupData[0][8];
   	    	    	} else if (sheetObj.CellValue(k, "cntr_sts_cd") == "LSI" || 
   	    	    			   sheetObj.CellValue(k, "cntr_sts_cd") == "DII" || 
   	    	    			   sheetObj.CellValue(k, "cntr_sts_cd") == "OWN"){
   	    	    	    break;
   	    	    	}
   	    	    }
       	    }
   	    }    
   	}
   	 
	function getCOM_ENS_071_1(aryPopupData, Row, Col, SheetIdx) {
   	    var formObj  = document.form;
   	    var sheetObj = sheetObjects[1];
   	    if ( aryPopupData.length > 0 ) {
   	    	sheetObj.CellValue(Row, "ofc_cd") = aryPopupData[0][3];
   	    }    
   	}
	
 	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[1];
		if ( aryPopupData.length > 0 ) {
			sheetObj.CellValue(Row,Col) = aryPopupData[0][2];
		}
	} 		
	
	/**
	 * Re-Creation 버튼을 보여주고 숨기는 로직 
	 */
	function setBtnReCreation(){
		var mnrSldChk = document.form.mnr_sld_chk.value;
		var ofcCd = document.form.hid_ofc_cd.value;
		if(ofcCd=="SELCON" && mnrSldChk == "Y"){
			div_reCreation.style.display = "inline";
		}else{
			div_reCreation.style.display = "none";
		}
	}
	/* 개발자 작업  끝 */
