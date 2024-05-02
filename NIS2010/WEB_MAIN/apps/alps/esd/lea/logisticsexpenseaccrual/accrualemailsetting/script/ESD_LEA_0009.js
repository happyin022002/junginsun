/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0009.js
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.09
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.09 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
/*********************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 *********************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_LEA_0009 : ESD_LEA_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0009() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){	
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		
		var formObject = document.form;

		try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
				
					case "btn_parameter":            	   
						var strToolTip	=	"$FROM       : From mail Address"	+"\n"+
											"$TO         : To mail Address"		+"\n"+      
											"$EXE_YRMON  : Execute Year Month"	+"\n"+      
											"$ST_TM      : Batch Start Time"	+"\n"+      
											"$END_TM     : Batch End Time"		+"\n"+      
											"$WRK_FLAG   : Success/Fail";
						//formObject.btn_parameter.title = strToolTip;
						ComShowMessage(strToolTip);  
            	        break;

					case "btn_parameter2":          	   
						var strToolTip	=	"$FROM      : From mail Address"	+"\n"+
											"$TO        : To mail Address"		+"\n"+      
											"$EXE_YRMON : Execute Year Month"	+"\n"+      
											"$ST_TM     : Batch Start Time"		+"\n"+      
											"$END_TM    : Batch End Time"		+"\n"+      
											"$WRK_FLAG  : Success/Fail";
						//formObject.btn_parameter.title = strToolTip;
						ComShowMessage(strToolTip);  
            	        break;

					case "btn_settingapply":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						//onSaveEnd(sheetObject);
						break;

            	    case "btn_mailsendtest":
           	    	
            	    	if(formObject.frm_save_div.value != "Y" ){
							//ComShowMessage("Please, Save setting values!");
							ComShowMessage(ComGetMsg("LEA90014"));
							return false;
            	    	}
            	    	doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
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
    			for(k=0;k<tabObjects.length;k++){
    				initTab(tabObjects[k],k+1);
    			}
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

           
		document.form.frm_mail_div.value = "B";
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		lea_sheetToFormValue(sheetObjects[0],document.form);   		
		
	}


	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}


	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {	
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++, "Batch" , -1 );
					InsertTab( cnt++, "Interface" , -1 );
				}
				break;
		}
	}

	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 중요 ---------------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		
		beforetab= nItem;
    		
		var formObj = document.form;
		
		switch(nItem) {
			case 0:
				formObj.frm_mail_div		.value = "B";
				formObj.frm_bat_fm_eml    	.valid = "1";
				formObj.frm_bat_to_eml    	.valid = "1";
				formObj.frm_bat_subj_nm   	.valid = "1";
				formObj.frm_bat_ctnt   	  	.valid = "1";
				formObj.frm_if_fm_eml     	.valid = "0";
				formObj.frm_if_to_eml     	.valid = "0";
				formObj.frm_if_subj_nm    	.valid = "0";
				formObj.frm_if_ctnt    		.valid = "0";
				//formObj.frm_if_snd_flg    .value = "";
				break;
				
			case 1:
				formObj.frm_mail_div		.value = "I";
				formObj.frm_bat_fm_eml    	.valid = "0";
				formObj.frm_bat_to_eml    	.valid = "0";
				formObj.frm_bat_subj_nm   	.valid = "0";
				formObj.frm_bat_ctnt   	  	.valid = "0";
				formObj.frm_if_fm_eml     	.valid = "1";
				formObj.frm_if_to_eml     	.valid = "1";
				formObj.frm_if_subj_nm    	.valid = "1";
				formObj.frm_if_ctnt    		.valid = "1";
				//formObj.frm_bat_snd_flg   .value = "";
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
			case 1: //IBSheet1 init
				with (sheetObj) {
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(16, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
		
					var HeadTitle = "|";
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtStatus,     30,    daCenter,  true,    	"ibflag");
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"pgm_sub_sys_cd" ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"eml_svr_ip"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"port_no"        ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_fm_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_to_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_cc_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_subj_nm"    ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_ctnt"       ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_snd_flg"    ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_fm_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_to_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_cc_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_subj_nm"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_ctnt"        ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_snd_flg"     ,        false,          "",       dfNone,     	0,     false,   false);
					
					style.height = GetSheetHeight(13) ;
				}
				break;		
		}
	}

	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH: //조회
				formObj.f_cmd.value = SEARCH01;
				
				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", FormQueryString(formObj));	
				
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", leaFormQueryString(formObj));
				
				//ComShowMessage(searchXml);
				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
				break;

			case IBSAVE: //저장
				if (!lea_comm_validChkForm(formObj)){
					return false;
				}				
				
				lea_formValueToSheet(sheetObj,formObj);
				
				formObj.f_cmd.value = MULTI;
				
				var param = sheetObj.GetSaveString(true);
				
				//var savexml = sheetObj.GetSaveXml("ESD_LEA_0009GS.do", param+"&"+FormQueryString(formObj));	
				
				var savexml = sheetObj.GetSaveXml("ESD_LEA_0009GS.do", param+"&"+ leaFormQueryString(formObj));	
				
				
				
				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
				break;

			case IBSEARCH_ASYNC01:  //SEND MAIL
				if (!lea_comm_validChkForm(formObj)){
					return false;
				}
				
				lea_formValueToSheet(sheetObj,formObj);
				
				formObj.f_cmd.value = SEARCH03;
				
				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", FormQueryString(formObj));	
				
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", leaFormQueryString(formObj));
				
				
				//ComShowMessage(searchXml);
				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
				ComShowMessage(ComGetMsg("LEA90023"));
				break;				
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//			if (!isNumber(iPage)) {
//				return false;
//			}
		}
		return true;
	}
	
	
	/*
	 * Sheet Save 끝난후 발생하는 Event처리 함수
	 */

	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			document.form.frm_save_div.value = "Y";
			ComShowMessage(ComGetMsg("LEA90024"));
			document.form.frm_mail_div.value = "B";
			doActionIBSheet(sheetObj,document.form,IBSEARCH);

		} else {
			ComShowMessage(ComGetMsg("LEA90009"));
			return;
		}
	}
	 
	
	/**
	 * 화면 Sheet값을  폼입력값으로 Copy한다
	 */
	function lea_sheetToFormValue(sheetObj,formObj){
		if (sheetObj.RowCount > 0){
			formObj.frm_save_div		.value = "Y";
			formObj.frm_eml_svr_ip    	.value = sheetObj.CellValue(1, "eml_svr_ip"     );
			formObj.frm_port_no       	.value = sheetObj.CellValue(1, "port_no"        );
			formObj.frm_bat_fm_eml    	.value = sheetObj.CellValue(1, "bat_fm_eml"     );
			formObj.frm_bat_to_eml    	.value = sheetObj.CellValue(1, "bat_to_eml"     );
			formObj.frm_bat_cc_eml    	.value = sheetObj.CellValue(1, "bat_cc_eml"     );
			formObj.frm_bat_subj_nm   	.value = sheetObj.CellValue(1, "bat_subj_nm"    );
			formObj.frm_bat_ctnt      	.value = sheetObj.CellValue(1, "bat_ctnt"       );
			formObj.frm_bat_snd_flg   	.value = sheetObj.CellValue(1, "bat_snd_flg"    );
			formObj.frm_if_fm_eml     	.value = sheetObj.CellValue(1, "if_fm_eml"      );
			formObj.frm_if_to_eml     	.value = sheetObj.CellValue(1, "if_to_eml"      );
			formObj.frm_if_cc_eml     	.value = sheetObj.CellValue(1, "if_cc_eml"      );
			formObj.frm_if_subj_nm    	.value = sheetObj.CellValue(1, "if_subj_nm"     );
			formObj.frm_if_ctnt       	.value = sheetObj.CellValue(1, "if_ctnt"        );
			formObj.frm_if_snd_flg    	.value = sheetObj.CellValue(1, "if_snd_flg"     );	
			formObj.frm_bat_to_eml_len	.value = ComGetLenByByte(sheetObj.CellValue(1, "bat_to_eml"    ));
			formObj.frm_bat_cc_eml_len	.value = ComGetLenByByte(sheetObj.CellValue(1, "bat_cc_eml"    ));
			formObj.frm_if_to_eml_len 	.value = ComGetLenByByte(sheetObj.CellValue(1, "if_to_eml"     ));
			formObj.frm_if_cc_eml_len 	.value = ComGetLenByByte(sheetObj.CellValue(1, "if_cc_eml"     ));
		}			
	}
	
	
	/**
	 * 화면 폼입력값을 Sheet로 Copy한다
	 */
	function lea_formValueToSheet(sheetObj,formObj){
		if (sheetObj.RowCount == 0){
			//Add row
			sheetObj.DataInsert(-1);
		}
		sheetObj.CellValue(1, "eml_svr_ip"     ) = formObj.frm_eml_svr_ip    .value;
		sheetObj.CellValue(1, "port_no"        ) = formObj.frm_port_no       .value;
		sheetObj.CellValue(1, "bat_fm_eml"     ) = formObj.frm_bat_fm_eml    .value;
		sheetObj.CellValue(1, "bat_to_eml"     ) = formObj.frm_bat_to_eml    .value;
		sheetObj.CellValue(1, "bat_cc_eml"     ) = formObj.frm_bat_cc_eml    .value;
		sheetObj.CellValue(1, "bat_subj_nm"    ) = formObj.frm_bat_subj_nm   .value;
		sheetObj.CellValue(1, "bat_ctnt"       ) = formObj.frm_bat_ctnt      .value;
		sheetObj.CellValue(1, "bat_snd_flg"    ) = formObj.frm_bat_snd_flg   .value;
		sheetObj.CellValue(1, "if_fm_eml"      ) = formObj.frm_if_fm_eml     .value;
		sheetObj.CellValue(1, "if_to_eml"      ) = formObj.frm_if_to_eml     .value;
		sheetObj.CellValue(1, "if_cc_eml"      ) = formObj.frm_if_cc_eml     .value;
		sheetObj.CellValue(1, "if_subj_nm"     ) = formObj.frm_if_subj_nm    .value;
		sheetObj.CellValue(1, "if_ctnt"        ) = formObj.frm_if_ctnt       .value;
		sheetObj.CellValue(1, "if_snd_flg"     ) = formObj.frm_if_snd_flg    .value;			
	}
	
	
	/**
	 * 화면 입력 필드의 문자 크기를 얻고 문자 크기를 한정시킨다.
	 */
	function lea_getLenByByte(obj,toObj){
		if(!ComChkLenByByte(obj, 200)){
			ComShowMessage(ComGetMsg("COM12142",obj.desc,"200"));
			return false;
		}
		toObj.value = ComGetLenByByte(obj.value);

	}

	
	/**
	 * 화면 내용 입력 필드의 Parameter 포함여부를 확인한다.
	 */
	function lea_validParameterValue(obj){
		if(obj.value == "" || obj.value == null) return false;
		var str = obj.value;
		var buff = str.split("$");
		if(buff.length > 0){
			for(i=1; i<buff.length; i++) {
				if(buff[i].indexOf("FROM") < 0 && buff[i].indexOf("TO") < 0 && 
						buff[i].indexOf("EXE_YRMON") < 0 && buff[i].indexOf("ST_TM"   ) < 0 &&  
						buff[i].indexOf("END_TM"   ) < 0 && buff[i].indexOf("WRK_FLAG") < 0  ){
					//ComShowMessage("The Parameter was designated by mistake");
					ComShowMessage(ComGetMsg("LEA90005"));
					obj.focus();
					return false;
				}
			}
		}
		return true;	
	}

	/* 개발자 작업  끝 */