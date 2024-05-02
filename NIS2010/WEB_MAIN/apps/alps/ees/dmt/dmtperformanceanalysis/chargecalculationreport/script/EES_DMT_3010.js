/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3010.js
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
* 1.0 Creation
* 2011.08.11 김경섭[CHM-201112592-01][DMT]Deleted Charge Report by Office 화면 보완 3010 > 3011조회시 Office 다중조회 가능토록함.
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
     * @class EES_DMT_3010 : EES_DMT_3010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3010() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
	
 var IBDELTRSN = 99;
 var IBDELTSPCERSN = 98;
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	//try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
	     		case "btns_calendar": //달력 버튼
					var cal = new ComCalendarFromTo();
                    cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
					break;
	
				case "btn_New":
					doInit();
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				
				case "btn_Minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display = 'none';
 						sheetObj.style.height = 510;
 					} else {
 						schCondDiv.style.display = 'block';
 						sheetObj.style.height = 410;
 					}
 					break;
					
				case "btn_Detail":
					doProcessPopup(srcName);
					break;
					
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
 					break;	

             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
     }

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         // IBMultiCombo초기화 
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],k+1);
         }
         
         // html컨트롤 이벤트초기화
         initControl();
	}
	  
	  
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
		sheetObjects[0].WaitImageVisible = false;
		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		
  		// 화면 초기화
        doInit();
        
        //Delete Reason Type List 조회
        doActionIBSheet(sheetObj, formObj, IBDELTRSN);
        doActionIBSheet(sheetObj, formObj, IBDELTSPCERSN);      
        sheetObjects[0].WaitImageVisible = true; 
	}  
     
	
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		sheetObj.CheckAll("chk") = 0;
		ComResetAll();
		
		// 조회기간(Period) 설정
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
		
        //=========================================================================================
        // 변경일자 : 2017.10.16 
        // 변경내용 : Period 를 12개월로 변경함.
        // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
        //==========================================================================================	
		var fmDt = ComGetDateAdd(ofcCurrDate, "M", -1 * REPORT_INQUIRY_PERIOD);
		var toDt = ComGetMaskedValue(ofcCurrDate, "ymd");
		ComSetObjValue(formObj.fm_dt, fmDt);
		ComSetObjValue(formObj.to_dt, toDt);
		
		// DEM/DET Office - RHQ list 조회
		ofc_flg_click();
	}
	
	// 이벤트 처리 함수 선언
	function initControl() {
		axon_event.addListener('blur',	'obj_blur',	'fm_dt', 'to_dt'); //- 포커스 나갈때
 		axon_event.addListener('focus',	'obj_focus', 'fm_dt', 'to_dt'); //- 포커스 들어갈때
 		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
 		axon_event.addListener('change', 'del_cd_click', 'del_cd');
	}

	
	// DEM/DET Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[0];
		
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		else
	   			comboObj.Enable = false;
	   			
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
	   		ComEnableObject(formObj.grp_flg, true);
		} else {
			// Office
			comboObj.Enable = true;
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
			
			ComEnableObject(formObj.chk_sub_ofc, true);
			ComEnableObject(formObj.grp_flg, false);
			formObj.grp_flg.className = 'input2';
		}
	}
	
	

	function del_cd_click() {
  		var sheetObj = sheetObjects[0];
		var formObj = document.form;
        doActionIBSheet(sheetObj, formObj, IBDELTSPCERSN);    
	}
	
	// Office IBMultiCombo 초기값 설정
   	function initComboValue_office() {
   		var usrRhqOfcCd = ComGetObjValue(document.form.usr_rhq_ofc_cd);
   		
   		if(usrRhqOfcCd == 'SELHO') usrRhqOfcCd = "All";
   		comboObjects[0].Code = usrRhqOfcCd;
   	}
   	
	
     
	//포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
    	var obj = event.srcElement;
    	ComChkObjValid(obj);
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj = event.srcElement;
    	ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
     
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	/*
    	 	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	*/
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }

	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObjects[0].Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND01);
			
		} else {
			ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
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
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 410;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 10, 100);

					var HeadTitle1 = "||Seq.|Office|Inactivated Reason|TTL CNTR|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)";
					var HeadTitle2 = "||Seq.|Office|Inactivated Reason|TTL CNTR|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	"chk",				false,	"",		dfNone,		0,	true,	false);
					InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"ofc_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			280,	daLeft,		true,	"delt_rsn_desc",	false,	"",		dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daCenter,	true,	"ttl_cntr",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"dmif_sum",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"dtic_sum",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"dmof_sum",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"dtoc_sum",			false,	"",		dfInteger,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"ctic_sum",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	"ctoc_sum",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0, 		daCenter,	true,	"delt_rsn_cd",		false,  "",		dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0, 		daCenter,	true,	"delt_spec_rsn_cd",		false,  "",		dfNone,		0,	false,  false);
				}
                 break;

         }
     }
     

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      // 조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
            	formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("EES_DMT_3010GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
            	break;

 			case IBDELTRSN:		// Delete Reason 정보 조회
 				formObj.f_cmd.value = SEARCHLIST;
 				var sXml = sheetObj.GetSearchXml("EES_DMT_3010GS.do", FormQueryString(formObj));
 				var etcData = ComGetEtcData(sXml, "DELT_RSN");
 				
 				if (etcData != undefined && etcData != '') {
 					
 					ComAddComboItem(formObj.del_cd, "All", "All");
 					
					var comboItems = etcData.split("|");
					for (var i = 0 ; i < comboItems.length ; i++) {
						
						var item = comboItems[i].split("=");
						var deltRsnCd = item[0];
						var deltRsnDesc = item[1];
						
						ComAddComboItem(formObj.del_cd, deltRsnDesc, deltRsnCd);
		         	}
				}
 				

 			case IBDELTSPCERSN:		// Delete Reason 정보 조회
 				formObj.f_cmd.value = SEARCH01;
 				var sXml = sheetObj.GetSearchXml("EES_DMT_3010GS.do", FormQueryString(formObj));
 				var deltSpecRsn = ComGetEtcData(sXml, "DELT_SPEC_RSN");			
 				
				ComClearCombo(formObj.spec_cd);
				ComAddComboItem(formObj.spec_cd, "All", "All");
				
 				if (deltSpecRsn != undefined && deltSpecRsn != '') {
 					
					var comboItems1 = deltSpecRsn.split("|");
					for (var i = 0 ; i < comboItems1.length ; i++) {
						
						var item = comboItems1[i].split("=");
						var deltSpecRsnCd = item[0];
						var deltSpecRsnDesc = item[1];
						
						ComAddComboItem(formObj.spec_cd, deltSpecRsnDesc, deltSpecRsnCd);
		         	}
				}

 				break;
         }
	}
     
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {  
	    	case "office": 
	    		with (comboObj) { 
					//MultiSelect = false;
	    			UseAutoComplete = true;
					SetColAlign("left");     
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
					
					//ValidChar(2);	// 영어대문자 사용
					//MaxLength = 6;
			    }
		    	break;
	    }
	}
     
	// IBCombo 데이터 조회 및 세팅
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
    	 formObj.f_cmd.value = formCmd;
    	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 
    	 switch(formCmd) {
    	 	case COMMAND06:	// RHQ
    	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = false;
					SetColWidth("45");
					ValidChar(2);	// 영대문자만 사용
					//MaxLength = 6;
    	 		}
    	 		
    	 		var data = ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				break;
    	 
    	 	case SEARCHLIST02: // Office
    	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = true;
					SetColWidth("95");
					ValidChar(2, 2); // 영대문자, 특수문자만 가능
    	 		}
    	  		
				var data = ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					var idx = 0;
 					
 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx = 1;
 					}
					
		    	    var comboItems = data.split("|");
		    	    for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);		
		         	}
		    	    
		    	    // 로그인 User Office를 Default
	    	  		comboObj.Code = usrOfcCd;
				}
	    	    break;
	    	    
    	 	case COMMAND01:	// Incl. Sub Office
    	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
    	 		if (subOfcCds != undefined && subOfcCds != '') {
    	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
				}
    	 		break;
    	 }
	}
	
	// 멀티콤보 Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	
 	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
	// 팝업 처리
	function doProcessPopup(srcName) {
   		var sheetObj = sheetObjects[0];
   		var formObj = document.form;
   		var sUrl = '';
   		var iWidth	= '';
   		var iHeight = '';
   		
   		with(sheetObj) {
 	  		switch(srcName) {
 	  			case 'btn_Detail':
 	  				
 	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'Deleted Charge');
             			return;
             		}
             		
             		var chkCnt = 0;
             		var chkRows = FindCheckedRow("chk").split("|");
             		
             		var prevOfcCd = CellValue(chkRows[0], "ofc_cd");
             		var chkDelCd = '';
             		var ofc_cd_delt_rsn_cd_list = '';
             		for(var i=0; i < chkRows.length-1; i++) {
             			//var currOfcCd = CellValue(chkRows[i], "ofc_cd");
             			// 한 Office 에 대해서만 복수건 선택가능(서로 다른 Office의 항목이 선택되었는지 체크)
             			// 2011.08.11 중복허용
             			/*
             			 if(currOfcCd != prevOfcCd) {
             				ComShowCodeMessage('DMT01066');
         					return;
             			}
             			*/
             			
             			//var delCd = CellValue(chkRows[i], "delt_rsn_cd");
             			//chkDelCd += ',' + delCd; 
             			ofc_cd_delt_rsn_cd_list += CellValue(chkRows[i], "ofc_cd") +",";
             			ofc_cd_delt_rsn_cd_list += CellValue(chkRows[i], "delt_rsn_cd") +",";
             			ofc_cd_delt_rsn_cd_list += CellValue(chkRows[i], "delt_spec_rsn_cd") +"@";
             		}
             		
             		if(ComGetLenByByte(ofc_cd_delt_rsn_cd_list) > 4000){
             			ofc_cd_delt_rsn_cd_list = getStringToClobString(ofc_cd_delt_rsn_cd_list, 100,"@");
    				} else{
    					ofc_cd_delt_rsn_cd_list = "'"+ofc_cd_delt_rsn_cd_list+"'";
    				}

             		//chkDelCd = chkDelCd.substring(1);
             		
             		var dtFlg	= ComGetObjValue(formObj.dt_flg);
             		var fmDt	= ComGetUnMaskedValue(formObj.fm_dt, 'ymd');
         			var toDt	= ComGetUnMaskedValue(formObj.to_dt, 'ymd');
             		var grpFlg	= ComGetObjValue(formObj.grp_flg);
             		
             		var paramVal =	"?dt_flg=" + dtFlg + "&fm_dt=" + fmDt + "&to_dt=" + toDt + "&grp_flg=" + grpFlg;
             						//ofc_cd_delt_rsn_cd_list는 데이타 사이즈가 클수 있으므로 겟방식으로 넘긴다.	
             						//+ "&ofc_cd_delt_rsn_cd_list=" + ofc_cd_delt_rsn_cd_list;
             						//+ "&ofc_cd=" + prevOfcCd + "&del_cd=" + chkDelCd;
             		
		 	  		 sUrl	= 'EES_DMT_3011.do' + paramVal;
		 	  		//post로 창을 띄우기 위해 새로 정의함
		      		 iWidth	= '900';
		      		 iHeight	= '610';
		      		var sScroll  = 'no';
		       		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		    		//ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
		       		var leftpos = (screen.width - iWidth) / 2;
		    		if (leftpos < 0)
		    			leftpos = 0;
		    		var toppos = (screen.height - iHeight) / 2;
		    		if (toppos < 0)
		    			toppos = 0;
		    		var sFeatures =	"scroll:"+sScroll+";status:no;help:no;dialogWidth:" + iWidth
		    						+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
		    						+ leftpos + ";dialogTop:" + toppos;
		       		
		       		var args = new Array();
		       		args["ofc_cd_delt_rsn_cd_list"] = ofc_cd_delt_rsn_cd_list;
		    		window.showModalDialog(sUrl, args,sFeatures);
		      		break;
 	  		}
   		}
   		

	}
     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
          		case IBSEARCH:
          			
          			if(!ComIsDate(fm_dt)) {
         				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_dt)) {
         				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}
         			
         			var startDt = ComGetUnMaskedValue(fm_dt, 'ymd');
         			var endDt = ComGetUnMaskedValue(to_dt, 'ymd');
 					//기간체크
                    if (startDt > endDt) {
                    	ComShowCodeMessage("COM12133", "'Period From Date'", "'Period To Date'", "earlier");
                    	return false;
                    }
                    
                    //=========================================================================================
                    // 변경일자 : 2017.10.16 
                    // 변경내용 : Period 를 12개월로 변경함.
                    // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
                    //==========================================================================================                                               
                    var limitDt = ComGetDateAdd(startDt, "M", REPORT_INQUIRY_PERIOD);
                    if (ComChkPeriod(endDt, limitDt) == 0) {
                    	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
                    	return false;
                    }
                    
                    var ofcCd = comboObjects[0].Code;
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
          			break;
        	 }
         }

         return true;
     }

 	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		with(sheetObj){
 			CheckAll("chk") = 0;
 			sheetObj.ShowSubSum("ofc_cd", "ttl_cntr|dmif_sum|dtic_sum|dmof_sum|dtoc_sum|ctic_sum|ctoc_sum", -1, true, false, -1, "chk=;ofc_cd=%s;seq=S.TTL");
     	}
     }
 	
 	
	// IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
        with(sheetObj) {
            if (ColSaveName(Col) == "chk") {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리, ComSyncAllCheck(sheetObj, Col, Value);
            	var cnt = SearchRows - CheckedRows("chk");
            	if (cnt == 0) {
            		HeadCheck(0, "chk") = false;
                    HeadCheck(1, "chk") = false;
                } else if(cnt == 1 && Value == '0') {
	            	HeadCheck(0, "chk") = true;
                    HeadCheck(1, "chk") = true;
                }
            }
        }
 	}


	/* 개발자 작업  끝 */