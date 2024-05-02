/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0551.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0551() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    function initControl() {
    	var formObject = document.form;
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        formObject.s_vps_eta_dt.focus();
    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}        


    
   	/* 개발자 작업	*/
    

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

 var sheetObjects = new Array();
 var sheetCnt = 0;

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
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
			case "btn_New":
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				formObject.reset();
				break;
				
			case "btn_DownExcel":
				sheetObject1.Down2Excel(-1);
				sheetObject2.Down2Excel(-1);
				break;
				
			case "btn_Print":
				doActionIBSheet(sheetObject1,formObject,RDPRINT);
				break;
				
			case "btn_BLList":
				doActionIBSheet(sheetObject1,formObject,COMMAND01);
				break;
				
			case "btn_SSRView":
				doActionIBSheet(sheetObject1,formObject,COMMAND02);
				break;
				
			case "btn_Download":
				if(validateForm(sheetObject1,formObject,MULTI)){
					var dnldCnt = sheetObject2.CellValue( sheetObject2.selectRow, "dnld" );
					if(dnldCnt != ""){
						var param = "?message=" + ComGetMsg("BKG08247");
						var returnVal = ComOpenWindowCenter("./apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_YNC.jsp" + param, window, "400", "110", true);
						if(returnVal!=undefined){
							formObject.chk_down.value = returnVal;
							doActionIBSheet(sheetObject1,formObject,MULTI);
						} else {
							return false;
						}
					} else {
						// dnld count가 0일 경우 chk_down "C" 넘김
						formObject.chk_down.value = "C";
						doActionIBSheet(sheetObject1,formObject,MULTI);
					}
				}
     			break;
				
			case "btn_calendar":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
				break;	
				
			case "btn_addLane":
				doActionIBSheet(sheetObject1,formObject,COMMAND03);
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
         initControl();
         
     }
     
     function selDateToCalendar(){
    	 
    	var now   = new Date();
	    var year  = now.getFullYear();
	    var month = now.getMonth() + 1;	// 1월=0,12월=11이므로 1더함
	    var day   = now.getDate();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    var dateval = '' + year + '-' + month + '-' + day;
	    document.form.e_vps_eta_dt.value = dateval;
	    document.form.s_vps_eta_dt.value = dateval;
	    document.form.e_vps_eta_dt.focus();
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
 								style.height = 222;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(1, 1, 3, 100);
 								
 								var HeadTitle1 = "|Seq.|Lane|VVD|SSR No.|Vessel Name|Lloyd No.|Call Date|A|Last  EDI|B/L|DNLD|DIFF|POD|SEND ID|SEND Date|Receive Date";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtSeq,					30,		daCenter,		true,		"SEQ");
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"slan_cd",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"vvd",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"ssr_no",					false,		"",		dfNone,					0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					150,	daLeft,			true,		"vvd_nm",			false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"lloyd_no",				false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"eta_dt",				false,		"",		dfUserFormat2,			0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					25,		daCenter,		true,		"msg_sts_cd",							false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"edi_sts",				false,		"",		dfNone,					0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					30,		daCenter,		true,		"bkg_count",							false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		"dnld_count",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					30,		daCenter,		true,		"DIFF",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"port_cd",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"snd_usr_id",					false,		"",		dfNone,					0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"snd_dt",				false,		"",		dfUserFormat2,	0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"rcv_dt",		false,		"",		dfUserFormat2,	0,		false,	true);
 								
 								
 								
 								InitUserFormat2(0, "eta_dt", "####-##-##", "-|:" );
 								InitUserFormat2(0, "snd_dt", "####-##-## ##:##", "-|:" );
 								InitUserFormat2(0, "rcv_dt", "####-##-## ##:##", "-|:" );
 								CountPosition = 0;
 		
 						}
 						break;

 					case "sheet2":
 							with (sheetObj) {
 		
 								// 높이 설정
 								style.height = 202;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(1, 1, 3, 100);
 								
 								var HeadTitle1 = "|Seq.|POL|POL ATD|POD|BDR|BDR Date|B/L|DNLD|DIFF|POL Seq|POD Seq";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtSeq,					50,		daCenter,		true,		"Seq");
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"pol",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"pol_atd",					false,		"",		dfUserFormat2,	0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"pod",						false,		"",		dfNone,					0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"bdr",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"bdr_date",				false,		"",		dfUserFormat2,	0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"bkg_cnt",							false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"dnld",						false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"diff",						false,		"",		dfNone,					0,		false,	true);
 								
 								InitDataProperty(0,		cnt++ , dtHidden,					60,		daCenter,		true,		"pol_clpt_ind_seq",					false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,					60,		daCenter,		true,		"pod_clpt_ind_seq",					false,		"",		dfNone,					0,		false,	true);
 								
 								CountPosition = 0;
 								
 								InitUserFormat2(0, "pol_atd", "####-##-## ##:##", "-|:" );
 								InitUserFormat2(0, "bdr_date", "####-##-## ##:##", "-|:" );
 		
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
	 	        	formObj.f_cmd.value = SEARCH;
				    sheetObj.DoSearch("ESM_BKG_0551GS.do", FormQueryString(formObj));
				    
				    if( sheetObj.RowCount == 0 ){
					    var vSSR = formObj.svc_rqst_no.value;
					    if( '' != vSSR  ){
					    	ComShowCodeMessage('BKG06107', vSSR);
					    }else{
					    	ComShowCodeMessage('BKG06106');
					    }
				    }
				    
				    sheetObjects[1].RemoveAll();
				    formObj.vvd1.value = sheetObj.CellValue( 1, 3 );
				    formObj.pol1.value = '';
         		}
                break;
         	case MULTI:        //저장
         		if(validateForm(sheetObj,formObj,sAction)){
         			formObj.f_cmd.value = MULTI;
         			var vVvd = formObj.vvd1.value;
         			var vPol = formObj.pol1.value;
         			var chkDown = formObj.chk_down.value;
         			
         			var selectPolSeq = sheetObjects[1].CellValue(sheetObjects[1].selectRow,"pol_clpt_ind_seq");
         			var selectPodSeq = sheetObjects[1].CellValue(sheetObjects[1].selectRow,"pod_clpt_ind_seq");
         			var vPod = sheetObjects[0].CellValue(sheetObjects[0].selectRow,"port_cd");
         			
//         			sheetObj.RowStatus(1) = "U";
         			sheetObj.RowStatus(sheetObj.SelectRow) = "U";
         			sheetObj.DoSave("ESM_BKG_0551GS.do?vvd=" + vVvd + "&pol=" + vPol+ "&chk_down=" + chkDown+ "&pod=" + vPod + "&pol_clpt_ind_seq=" + selectPolSeq+ "&pod_clpt_ind_seq=" + selectPodSeq, FormQueryString(formObj));
         			
         			doActionIBSheet(sheetObj,formObj,IBSEARCH); // 재조회
         		}
                break;
 			case IBINSERT:      // 입력
                break;
                
 			case RDPRINT:        // print
				if(validateForm(sheetObj,formObj,sAction)) return false;
				alert("출력을 위한 팝업 UI 호출 (UI_BKG-0868)");
				break;    
				
 			case COMMAND01:
				if(validateForm(sheetObj,formObj,sAction)) 
					ComOpenWindowCenter("ESM_BKG_0063.do?popup=y&vvd=" + formObj.vvd1.value+"&pod="+sheetObj.CellValue(sheetObj.selectRow, "port_cd") , "0063", 1020, 650);
				break;	
 			case COMMAND02:
 				if(validateForm(sheetObj,formObj,sAction)) 
 					ComOpenWindowCenter("ESM_BKG_0494.do?vvd=" + formObj.vvd1.value+"&pod="+sheetObj.CellValue(sheetObj.selectRow, "port_cd") , "0494", 1020, 470);
 				break;	
 			case COMMAND03:
					ComOpenWindowCenter("ESM_BKG_1095.do" , "1095", 400, 280, true);
				break;	 				
 	        
         }
     }
     /**
      * EDI Code 를 EDI DESC 로 맵핑하는 메서드.
      * @return
      */
     function changeEDICodeToEDIDesc(sCode){
    	 switch ( sCode ){
	    	 case 'NN' :
	    	 	return 'Initial';
	    	 break;
	    	 case 'ON' :
	    	 	return 'Sending';
	    	 break;
	    	 case 'OA' :
	    	 	return 'Sent';
	    	 break;
	    	 case 'RN' :
	    	 	return 'Replacing'
	    	 break;
	    	 case 'RA' :
	    	 	return 'Replaced'
	    	 break; 
	    	 case 'CN' :
	    	 	return 'Cancelling'
	    	 break;
	    	 case 'CA' :
	    	 	return 'Cancelled'
	    	 break;
	    	 case 'OE' :
	    	 	return 'Error(S)'
	    	 break;
	    	 case 'CE' :
	    	 	return 'Error(C)'
	    	 break;
	    	 case 'RE' :
	    	 	return 'Error(R)'
	    	 break;
    	 
    	 }
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	 		case IBSEARCH: // 조회
	 			
	 			//기본포멧체크
    			if (!ComChkValid(formObj)) return false;
	 			
	 			if(formObj.s_vps_eta_dt.value == '')
	    		 {
	    			 ComShowCodeMessage('BKG00626');
	    			 ComSetFocus(formObj.s_vps_eta_dt)
	    			 return false;
	    		 }
	    		 if(formObj.e_vps_eta_dt.value == '')
	    		 {
	    			 ComShowCodeMessage('BKG00626');
	    			 formObj.date_to.focus();
	    			 return false;
	    		 }
	    		 
	    		 var diffDate = ComGetDaysBetween( formObj.s_vps_eta_dt.value, formObj.e_vps_eta_dt.value)
	    		 var y = formObj.s_vps_eta_dt.value.substring( 0, 4 );
	    		 var m = formObj.s_vps_eta_dt.value.substring( 5, 7 );
	    		 var lastDay = ComGetLastDay( y, parseInt( m, 10 ) );
	 			 
	    		 if ( diffDate+1 > lastDay ){
	    			 ComShowCodeMessage('BKG01080');
	    			 return false;
	    		 }	 
	    		 return true;
	 		break;
	 		case MULTI:
	 			if (formObj.vvd1.value.length != 9 || (formObj.pol1.value.length != 5 ) ) 
	 			{ 
	 				ComShowCodeMessage('BKG00886');
	 				formObj.vvd1.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case COMMAND01:
	 			return true;
	 			break;
	 		case COMMAND02:
	 			return true;
	 			break;	
 		 			
    	 }
    }

 	/**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	
    	var vVvd = sheetObj.CellValue( row, 3 );
    	var vPod = sheetObj.CellValue( row, "port_cd" );
    	document.form.f_cmd.value = SEARCH01;
    	sheetObjects[1].DoSearch("ESM_BKG_0551GS.do?vvd="+vVvd + "&pod="+vPod, FormQueryString(document.form));
    	document.form.vvd1.value = vVvd;    	
    	
    	if( sheetObjects[1].RowCount == 0 ){
		    ComShowCodeMessage('BKG06108');
	    }
    	
    	var vPol = sheetObjects[1].CellValue( 1, 2 ) ;
    	var vIsYNToBDR = 'Y' ;
    	for( var i=1; i<sheetObjects[1].RowCount+1; i++ ){
    		var vBDR = sheetObjects[1].CellValue( i, 'bdr' );
    		if( 'N' == vBDR )
    			vIsYNToBDR = 'N' ;
    			
    	}
    	if ( 'N' == vIsYNToBDR )
    		 ComShowCodeMessage('BKG06109');
    	
    	document.form.pol1.value = vPol; 
    }
    
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet2_OnClick(sheetObj, row, col) {
    	
    	var vPol = sheetObj.CellValue( row, 2 );
    	document.form.pol1.value = vPol;    	
    }	
 		
	/* 개발자 작업  끝 */    