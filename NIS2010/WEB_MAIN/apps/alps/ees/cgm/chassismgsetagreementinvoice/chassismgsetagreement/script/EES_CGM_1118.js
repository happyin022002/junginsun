/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1118.js
*@FileTitle : Lease Term Change Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.30 김창식
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
     * @class ees_cgm_1118 : ees_cgm_1118 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1118() {
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


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */ 
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
        var sheetObject1 = sheetObjects[0];
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
       
 				case "btn_Retrieve":
 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
 						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					}
 					break;
 			
 				case "btn_New":
 					initControl();
 					break;
 					
 				case "btn_loadexcel":
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;
	
 				case "btns_sts_evnt_dt" :
					var cal = new ComCalendarFromTo();
					cal.select(formObject.sts_evnt_dt_fr, formObject.sts_evnt_dt_to, "yyyy-MM-dd");
 					break;	
 				
 				case "btns_office1":	// Office Code 가져오기 팝업 (단건)
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;
					
 				case "btns_office2":	// Office Code 가져오기 팝업 (복수건)
 					ComOpenPopup('/hanjin/COM_ENS_071.do', 800, 480, "setCallback_Office", "0,1,1,1,1,1,1,1", true, false);
 					break;
 					
 				case "btns_vndr1":	// Lessor Code 가져오기 팝업
 					ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq", "1,0,1,1,1,1", true);
 					break;	
 					
 				case "btns_vndr2":	// Lessor Code 가져오기 팝업
 					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "setCallback_Vendor", "0,1,1,1,1,1", true, false);
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function setSheetObject(sheet_obj){
    	
        sheetObjects[sheetCnt++] = sheet_obj;
        
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function loadPage() {

    	var formObj = document.form;
    	
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('keydown', 'obj_keydown', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
        
    	for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i] );

        	initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
        	ComEndConfigSheet(sheetObjects[i]);
        }	
    	
    	// IBMultiCombo 초기화
        comboObjects[comboCnt++] = document.old_agmt_lstm_cd;
        comboObjects[comboCnt++] = document.new_agmt_lstm_cd;
     	for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
     	
     	// Lease Term Combo Control에  초기값을  설정한다.
//        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
     	
        doActionIBSheet(sheetObjects[0], formObj,IBRESET);
        
        // Form Control 초기화
     	initControl();
    }

    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function initControl(){
    	
    	// Form 객체 선언
     	formObj = document.form;
         
        // Form Object 초기화 
        with(formObj){
        	ComCgmSetObjectValue(sts_evnt_ofc_cd);
        	ComCgmSetObjectValue(sts_evnt_dt_fr);
        	ComCgmSetObjectValue(sts_evnt_dt_to);
        	ComCgmSetObjectValue(vndr_seq);
        }
        
        // Option 버튼 초기화
        //formObj.viewflg(0).checked = true;
        
        // MultiCombo 초기화
        comboObjects[0].Text2 = "";
        comboObjects[1].Text2 = "";
        
        // Sheet Object 초기화
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        
        //doOptionBtnAction(formObj,"viewflg");
        
    	// 초기 focus
        formObj.sts_evnt_ofc_cd.focus();
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
 		var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 422;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                     
                    var HeadTitle1 = "|Office|Old|Old|Old|New|New|New|";
                    HeadTitle1 = HeadTitle1 + "Term Change Quantity|Term Change Quantity|Term Change Quantity|Term Change Quantity|";
                    HeadTitle1 = HeadTitle1 + "Term Change Quantity|Term Change Quantity|Term Change Quantity|Term Change Quantity|";
                    HeadTitle1 = HeadTitle1 + "Term Change Quantity|Term Change Quantity|Term Change Quantity";
                    
                    var HeadTitle2 = "|Office|Lessor|AGMT No.|Term|Lessor|AGMT No.|Term|";
                    HeadTitle2 = HeadTitle2 + "Total|SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					var totalVal = "|9|+|10|+|11|+|12|+|13|+|14|+|15|+|16|+|17|+|18|";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,	"ibflag");
 					InitDataProperty(0, cnt++ , dtData,		60,	daCenter, true,	"sts_evnt_ofc_cd",	false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"old_vndr_seq",	  	false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtData,		80,	daCenter, true,	"old_agmt_no", 		false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtData,		70,	daCenter, true,	"old_agmt_lstm_cd",	false, "", dfNone,		0, false, true);
 					
 					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"new_vndr_seq",	  	false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtData,		80,	daCenter, true,	"new_agmt_no", 		false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtData,		70,	daCenter, true,	"new_agmt_lstm_cd",	false, "", dfNone,		0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,  true,	"Total",	  		false, totalVal, dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_sf2",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_sl2",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_ta2",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_sf4",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_gn4",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_cb4",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_eg5",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_eg8",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_gn5",	false, "", dfNullInteger,	0, false, true);
 					InitDataProperty(0, cnt++ , dtAutoSum,	45,	daRight, true,	"eq_tpsz_cd_zt4",	false, "", dfNullInteger,	0, false, true);
 															
 					CountPosition = 0;
 					
 					EditableColorDiff = false;

 				}
 				break;
 				
            case "sheet2":
            	with (sheetObj) {
                    // 높이 설정
                    style.height = 302;
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
                    
                    var HeadTitle1 = "|Old|Old|New|New|Change Date|Type/Size|Chassis No.|Chassis No.|Chassis No.|Chassis No.|Chassis No.";
                    var HeadTitle2 = "|Agreement No.|Term|Agreement No.|Term|Change Date|Type/Size| | | | | ";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,	"Status");
					InitDataProperty(0, cnt++ , dtData,			110,daCenter, true,	"Old_AgreeNo",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter, true,	"Old_Term",		false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			110,daCenter, true,	"New_AgreeNo",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter, true,	"New_Term",		false,	"",	dfNone,		0, true, true);
										
					InitDataProperty(0, cnt++ , dtData,			100,daCenter, true,	"ChangeDate",	false,	"",	dfDateYmd,	0, true, true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter, true,	"TypeSize",		false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter, false,"ChassisNo1",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter, false,"ChassisNo2",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter, false,"ChassisNo3",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter, false,"ChassisNo4",	false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter, false,"ChassisNo5",	false,	"",	dfNone,		0, true, true);
															
					CountPosition = 0;

				}
				break;
        }
    }
     
    /** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
     * @version 2009.05.30
     */ 
    function initCombo(comboObj) {
     	switch(comboObj.id) {
 	    	case "old_agmt_lstm_cd":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code = "";
 	  	            Text = "";
 	  	            DropHeight = 200;
 	  	            MultiSelect = true;
 	  	            MaxSelect = 100;	    
 	  	            UseCode = true;
 	  	            Enable = true;
 	  	        }
 	  	        
 	  	        break;
   	        
     	 	case "new_agmt_lstm_cd":
     	 		var cnt=0;
      	        with(comboObj) {
      	        	Code = "";
      	            Text = "";
      	            DropHeight = 200;
      	            MultiSelect = true;
      	            MaxSelect = 100;	    
      	            UseCode = true;
      	            Enable = true;
      	        }
      	        
      	        break;
     	}
    } 

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	
        	case IBSEARCH:      //조회
        		formObj.f_cmd.value = SEARCH;
        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
        	    sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
        		// 조회실행
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1118GS.do" , FormQueryString(formObj), '', true);
	     		sheetObj.LoadSearchXml(sXml);
	     		ComOpenWait(false);
 				break;
 					
 			case IBDOWNEXCEL:        //엑셀 다운로드
 				sheetObj.SpeedDown2Excel(-1);
 				break;
 					 			
 			case IBSEARCH_ASYNC01:	// Term Code MultiCombo 조회
    		
	        	formObj.f_cmd.value = SEARCH;
	        	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	    		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	    			    			
	    		var sStr = ComGetEtcData(sXml,"comboList");    			
	    		var arrStr = sStr.split("@");
	    			
	    		// combo control, 결과 문자열, Text Index, Code Index
	   			MakeComboObject(formObj.old_agmt_lstm_cd, arrStr, 0, 0);
	   			MakeComboObject(formObj.new_agmt_lstm_cd, arrStr, 0, 0);
	        	break;
			 case IBRESET:
	     	 		var idx = 0
	     	 		var sXml2 = document.form2.sXml.value;
	     	 		var arrXml = sXml2.split("|$$|");
	     	
	     	 		//agmt_lstm_cd
	     	 		if ( arrXml[idx] == null ) {return;}
	     	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	     	 	    var arrStr1 = new Array();
	     	 		for ( var i = 0; i < vArrayListData.length; i++) {
	     	 		    vListData = vArrayListData[i];
	     	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	     	 		}
	     	 		// combo control, 결과 문자열, Text Index, Code Index
	     		  	MakeComboObject(formObj.old_agmt_lstm_cd, arrStr1, 0, 0);
		   			MakeComboObject(formObj.new_agmt_lstm_cd, arrStr1, 0, 0); 
	     	 		idx++;  
 			
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.06.30
     */  
    function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction){
        	 	case IBSEARCH:	// 조회
	        	 	if(sts_evnt_dt_fr.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Change Period');
	    	 			sts_evnt_dt_fr.focus();
	    	 			return false;
	        	 	} else if(sts_evnt_dt_to.value == ''){
	        	 		ComShowCodeMessage('CGM10004','Change Period');
	        	 		sts_evnt_dt_to.focus();
	    	 			return false;
	        	 	} else {
	        	 		return true;
	        	 	}
        	 		break;
        	 }
         }
    }
         
    /**
     * Option 버튼의 설정에 따른 동작을 정의한다. <br>
     * @param  {object} formObj	필수
     * @param  {string} srcName	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
/*     
    function doOptionBtnAction(formObj, srcName){
    	switch(srcName){
        	case "viewflg":
          			
        		var viewLayer1 = document.getElementById("viewLayer1");
        		var viewLayer2 = document.getElementById("viewLayer2");
          		   				
        		if(formObj.viewflg[0].checked){
        			viewLayer1.style.display = "block";
        			viewLayer2.style.display = "none";
        	    		
        		} else if(formObj.viewflg[1].checked){
        			viewLayer1.style.display = "none";
        			viewLayer2.style.display = "block";
        		}
        		break;
        }
    }
*/       
    /**
     * Office 팝업창 호출시 설정된 Callback 함수
     * @author 김창식
     * @version 2009.06.30
     */
    function setCallback_Office(aryPopupData, row, col, sheetIdx){
    	var formObj = document.form;
    	var ofcCd = "";
    	
    	for(i = 0; i < aryPopupData.length; i++){
    		
    		ofcCd = ofcCd + aryPopupData[i][3];
   		 
   		 	if(i < aryPopupData.length - 1){
   		 		ofcCd = ofcCd + ",";
   		 	}
    	}
    	
    	formObj.sts_evnt_ofc_cd.value = ofcCd;

    }
    
    /*
     * Lessor 팝업창 호출시 설정된 Callback 함수
     * @author 김창식
     * @version 2009.06.30
     */
    function setCallback_Vendor(aryPopupData, row, col, sheetIdx){
    	var formObj = document.form;
    	var vndrSeq = "";
    	
    	for(i = 0; i < aryPopupData.length; i++){
    		
    		vndrSeq = vndrSeq + aryPopupData[i][2];
   		 
   		 	if(i < aryPopupData.length - 1){
   		 	vndrSeq = vndrSeq + ",";
   		 	}
    	}
    	
    	formObj.vndr_seq.value = vndrSeq;

    }

    /**
     * Sheet1 의 Total Sum을 위한 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} Row			필수 Row
     * @author 김창식
     * @version 2009.06.30
     */  
 	function sheet1_OnChangeSum(sheetObj, Row){
 		with(sheetObj)
 		{
 			SumText(0, "Office") = "";
 			SumText(0, "New_Term") = "Grand Total";
 			CellAlign(Row, "New_Term") = daCenter;
 		}
 	}

    /**
     * Sheet1 의 Office Total 를 위한 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 ErrMsg
     * @author 김창식
     * @version 2009.06.30
     */  
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			ShowSubSum("sts_evnt_ofc_cd", "8|9|10|11|12|13|14|15|16|17|18", -1, false, false, 0, "new_agmt_lstm_cd=Office Total");
 		}
 	} 
     
     /**
      * Sheet1 의 OnMouseDown 이벤트처리 <br>
      * @param  {Integer} Button	필수 Integer
      * @param  {integer} Shift	필수 Integer
      * @param  {Integer} X	필수 Integer
      * @param  {integer} Y	필수 Integer
      * @return 없음
      * @author 조재성
      * @version 2009.09.16
      */ 
      function sheet1_OnMouseDown(Button, Shift, X, Y) {
     	 var sheetObj = sheetObjects[0];
     	 var formObj = document.form;
     	 if(sheetObj.rowcount + 2 == sheetObj.mouseRow)
      	 {
      		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
      	 }
     	 
      }
    
    /**
     * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 김창식
     * @version 2009.06.30
     */   
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	
    	var eqKndCd			= EQ_KND_CD_CHASSIS;
    	var stsEvntDtFr		= document.form.sts_evnt_dt_fr.value;
    	var stsEvntDtTo		= document.form.sts_evnt_dt_to.value;
    	
    	var stsEvntOfcCd 	= sheetObj.cellValue(Row, "sts_evnt_ofc_cd");
    	var oldAgmtNo 		= sheetObj.cellValue(Row, "old_agmt_no");
    	var oldAgmtOfcCtyCd = oldAgmtNo.substring(0,3);
    	var oldAgmtSeq		= oldAgmtNo.substring(3);
    	var newAgmtNo 		= sheetObj.cellValue(Row, "new_agmt_no");
    	var newAgmtOfcCtyCd = newAgmtNo.substring(0,3);
    	var newAgmtSeq		= newAgmtNo.substring(3);
    	var old_agmt_lstm_cd = "";
    	var new_agmt_lstm_cd = "";
    	var vndr_seq     = "";
    	var eqTpszCd	=  "";
    	var colSaveName = sheetObj.ColSaveName(Col);
    	
    	if(colSaveName == 'eq_tpsz_cd_sf2') 		eqTpszCd = "SF2";
    	else if(colSaveName == 'eq_tpsz_cd_sl2')	eqTpszCd = "SL2";
    	else if(colSaveName == 'eq_tpsz_cd_ta2')	eqTpszCd = "TA2";
    	else if(colSaveName == 'eq_tpsz_cd_sf4')	eqTpszCd = "SF4";
    	else if(colSaveName == 'eq_tpsz_cd_gn4')	eqTpszCd = "GN4";
    	else if(colSaveName == 'eq_tpsz_cd_cb4')	eqTpszCd = "CB4";
    	else if(colSaveName == 'eq_tpsz_cd_eg5')	eqTpszCd = "EG5";
    	else if(colSaveName == 'eq_tpsz_cd_eg8')	eqTpszCd = "EG8";
    	else if(colSaveName == 'eq_tpsz_cd_gn5')	eqTpszCd = "GN5";
    	else if(colSaveName == 'eq_tpsz_cd_zt4')	eqTpszCd = "ZT4";
    	
    	if( sheetObj.CellValue(Row, "new_agmt_no")== "" && sheetObj.CellValue(Row, "new_agmt_lstm_cd") == "Office Total"){
    		stsEvntOfcCd = sheetObj.CellValue(Row-1, "sts_evnt_ofc_cd");
    		old_agmt_lstm_cd =  document.form.old_agmt_lstm_cd.Text;
 	    	new_agmt_lstm_cd =  document.form.new_agmt_lstm_cd.Text;
 	    	vndr_seq         =  document.form.vndr_seq.value;
 	    } else if( stsEvntOfcCd == "TOTAL"  ){
 	    	stsEvntOfcCd     =  document.form.sts_evnt_ofc_cd.value;
 	    	old_agmt_lstm_cd =  document.form.old_agmt_lstm_cd.Text;
 	    	new_agmt_lstm_cd =  document.form.new_agmt_lstm_cd.Text;
 	    	vndr_seq         =  document.form.vndr_seq.value;
 	    }
//    	alert(sheetObj.CellValue("|"+Row, "sts_evnt_ofc_cd")+"|");
//    	alert(sheetObj.CellValue(Row, "new_agmt_lstm_cd"));
    	var param = "?program_id=1118";
    	param = param + "&eq_knd_cd=" + eqKndCd;
    	param = param + "&sts_evnt_dt_fr=" + stsEvntDtFr;
    	param = param + "&sts_evnt_dt_to=" + stsEvntDtTo;
    	param = param + "&sts_evnt_ofc_cd=" + stsEvntOfcCd;
    	param = param + "&old_agmt_ofc_cty_cd=" + oldAgmtOfcCtyCd;
    	param = param + "&old_agmt_seq=" + oldAgmtSeq;
    	param = param + "&new_agmt_ofc_cty_cd=" + newAgmtOfcCtyCd;
    	param = param + "&new_agmt_seq=" + newAgmtSeq;
    	param = param + "&eq_tpsz_cd=" + eqTpszCd;
    	param = param + "&old_agmt_lstm_cd=" + old_agmt_lstm_cd;
    	param = param + "&new_agmt_lstm_cd=" + new_agmt_lstm_cd;
    	param = param + "&vndr_seq=" + vndr_seq;
    	
 
    	
	    if(Col >= 8  ){
	    	ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 580, "", "1,0", true, false);
	    }  
    	
    }
    
    /** 
      * Object 의 Keydown 이벤트에 대한 처리  <br>
      * enter 키 발생시 조회실행.  <br>
      * @param  없음
      * @return 없음
      * @author 김창식
      * @version 2009.06.30
      */ 
    function obj_keydown(){
    	
     	obj = event.srcElement;
     	
     	var keyValue = null;
    	if(event == undefined || event == null) {
    		keyValue = 13;
    	} else {
    		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		}
    	
    	if(keyValue != 13) return;
		
		ComKeyEnter();
    }
     
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */ 
    function obj_keypress(){
       	obj = event.srcElement;
       	if(obj.dataformat == null) return;
       	 	
       	window.defaultStatus = obj.dataformat;
       	 
       	switch(obj.dataformat) {
       	 	case "ym": case "ymd":
       	 		ComKeyOnlyNumber(obj);
       	 		break;
       	 	case "int":
       	 		ComKeyOnlyNumber(obj);
       	        break;
       	 	case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;    
       	    case "eng":
       	    	if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
       	    	else ComKeyOnlyAlphabet(); 
       	        break;
       	    case "engup":
       	        if(obj.name=="sts_evnt_ofc_cd") ComKeyOnlyAlphabet('uppernum',"44");
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    case "engdn":
       	        ComKeyOnlyAlphabet('lower');
       	        break;
       	}
    } 
    
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function obj_activate(){
      	ComClearSeparator(event.srcElement);
    }
    
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */
    function obj_deactivate(){
      	var formObj = document.form;
      	obj = event.srcElement;      	
      	
      	if(obj.name == 'sts_evnt_dt_fr' || obj.name == 'sts_evnt_dt_to'){
      		with(formObj){
      			var fromDt = ComReplaceStr(sts_evnt_dt_fr.value,"-","");
	   	 		var toDt = ComReplaceStr(sts_evnt_dt_to.value,"-","");
	   	 		
	      		switch(obj.name) {
		      		case "sts_evnt_dt_fr": 
			   	 		if(fromDt != '' && toDt != ''){
			    			if(fromDt > toDt){
			    				ComShowCodeMessage('COM12133','To date','From date','greater');
			    				sts_evnt_dt_fr.value = "";
			    				ComSetFocus(sts_evnt_dt_fr);
			    			}
			    		}
			   	 		
			   	 		break;
			   	 		
		      		case "sts_evnt_dt_to":
	    	    		if(fromDt != '' && toDt != ''){
	    	    			if(fromDt > toDt){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				sts_evnt_dt_to.value = "";
	    	    				ComSetFocus(sts_evnt_dt_to);
	    	    			}
	    	    		}
	    	           	break;	
	      		}	
      		}
      		
      		ComChkObjValid(event.srcElement);	
      	}
    }
     
    /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.30
     */  
    function obj_change(){
    	var formObj = document.form;
	   	var sheetObj = sheetObjects[0];
	   	 
	   	obj = event.srcElement;
	   	switch(obj.name){
		   	case "sts_evnt_ofc_cd":
		   	 	var ofcCd = ComTrimAll(formObj.sts_evnt_ofc_cd.value);
		 		
		 		if(ofcCd != ''){
		 			var arrOfcCd = ofcCd.split(",");
		 			
		 			for(var i = 0; i < arrOfcCd.length; i++){
	    	 			// 입력오류 체크 (예> ,,)
	    	 			if(arrOfcCd[i] == ''){
	    	 				ComShowCodeMessage('CGM10009','Change Office');
	    	 				formObj.sts_evnt_ofc_cd.value = "";
	    	 				ComSetFocus(formObj.sts_evnt_ofc_cd);
	    	 				break;
	    	 			}
	    	 		}
		 		}
	   	 		break;
	   	 
	   	 	case "vndr_seq":
		   	 	var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
		 		
		 		if(vndrSeq != ''){
		 			var arrVndrSeq = vndrSeq.split(",");
		 			
		 			for(var i = 0; i < arrVndrSeq.length; i++){
	    	 			// 입력오류 체크 (예> ,,)
	    	 			if(arrVndrSeq[i] == ''){
	    	 				ComShowCodeMessage('CGM10009','Lessor');
	    	 				formObj.vndr_seq.value = "";
	    	 				ComSetFocus(formObj.vndr_seq);
	    	 				break;
	    	 			}
	    	 		}
		 		}
	   	 		break;
	   	}
    }
     
    /** 
     * Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
     * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */ 
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	cmbObj.RemoveAll();
      	for (var i = 0; i < arrStr.length;i++ ) {
      		var arrCode = arrStr[i].split("|");
      		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
      	}
      	cmbObj.Index2 = "" ;
    }  
 	
 	