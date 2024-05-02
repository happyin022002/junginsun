/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0208.js
*@FileTitle : EAC Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0208 : ESD_EAS_0208 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0208() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.doActionIBCombo         = doActionIBCombo;    	
    }
    
    
   	/* 개발자 작업	*/

	//공통전역변수
    var frm = null;

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	


	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;	

	    
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
     
     
     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
    	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	 var sheetObject1 = sheetObjects[0];
    	 
    	 /*******************************************************/
    	 
    	 try {
    		 var srcName = window.event.srcElement.getAttribute("name");
    		 
    		 switch(srcName) {
    		 
    		 case "btn_retrieve":
    			   doActionIBSheet(sheetObject1,frm,IBSEARCH);
    		 break;
 			 /* [2.1.엑셀다운로드 버튼] */
			 case "btn_downexcel":
				   doActionIBSheet(sheetObject1,frm,"btn_downexcel");
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
        
	    // 콤보 초기값 조회
	    doActionIBCombo(frm.s_eac_tp_cd); // EAC Type
	    doActionIBCombo(frm.s_eac_expn_tp_cd); // Expense Type
//        doActionIBCombo(comboObjects[1]); // Expense Type
	    
	    //IBMultiCombo 설정
        for(var k = 0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k]);
        }
        
        
        
	    
	}

    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj) {
    	
    	 switch(comboObj.id) {
   	  		case "s_eac_tp_cd":  
   	  		      comboObj.InsertItem(0, "", "");
   	  		      comboObj.Index=0;
   	  		break;  
   	  		case "s_eac_expn_tp_cd":  
   	  			comboObj.InsertItem(0, "", "");
   	  			comboObj.Index2=0;
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
					style.height = GetSheetHeight(22);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "|SEQ.|EAC Type|EAC Code Name|Sub-Code|Sub-code Name|Description|TPB I/F Type|TPB Expense Type";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          35,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtComboEdit,    70,  	daCenter,   true,   "tp_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,     true,   "tp_nm",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "bil_tp_cd",   false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,     true,   "bil_tp_nm",   false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         300,  	daLeft,     true,   "bil_tp_desc", false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "if_tp_nm",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "expn_tp_nm",  false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					
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
	    		Editable = false;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "|SEQ";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
	    		InitDataProperty(0, cnt++ , dtSeq,          35,  	daCenter,   true,   "seq");
	    		
	    	}
	    		break;
			}
		}	
	 
	 
	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	        switch(comboObj.id) {

			    case "s_eac_tp_cd":    
			    	searchCommonCombo("CD00587",frm.s_eac_tp_cd);
			    	break;  
			    case "s_eac_expn_tp_cd":    
			    	searchCommonCombo("CD03352",frm.s_eac_expn_tp_cd);
			    	break;  
		    }
	    }
		
	    // 공통테이블에 등록된 코드값을 조회 한다.    
		function searchCommonCombo(codeKey,comboObj){
			var sheetObj = sheetObjects[1];
				frm.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				frm.code_key.value = codeKey
				sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}	    
	    

	 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			sheetObj.ShowDebugMsg = false;
			var sheetObj = sheetObjects[0];
			
			switch (sAction) {

				// SEARCH LOGIC
				case IBSEARCH:
					if(validateForm(sheetObj,frm,sAction)){
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObjects[1].GetSearchXml("ESD_EAS_0208GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					}
					break;
			
				case "btn_downexcel":	// EXCEL DOWNLOAD
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
					break;
			}
		}
		
		 /**
		  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		  */
		  function validateForm(sheetObj,frm,sAction){
		 	 switch(sAction) {
		 	 case IBSEARCH : 
		 		 break;
		 	 } // end switch()
		 	 return true;
		  }	 		
		  
		  function eac_type1_OnChange(comboObj,Index_Code, Text){   
				
				if(Index_Code=="T"){ 
					// Missing 3rd Party Billing 일경우만 콤보값 셋팅
					doActionIBCombo(comboObjects[1]); // EAC Type2
					comboObjects[1].Enable=true;
				}else{
					// Missing 3rd Party Billing 아닐 경우 삭제
//					comboObjects[2].RemoveAll(); 
					comboObjects[1].index=0;
					comboObjects[1].Enable=false;
				}
					
				//doActionIBSheet(SEARCHLIST01);		
		  }		  
		  
		  
		  function expense_type_OnChange(comboObj,Index_Code, Text){   
			  
		  }		  
  		  function s_eac_tp_cd_OnChange(comboObj,Index_Code, Text){
		      if(Index_Code == "T"){
		    	  frm.s_eac_expn_tp_cd.Enable = true; // s_eac_tp_cd
		      }else{
		    	  frm.s_eac_expn_tp_cd.Enable = false ; // s_eac_tp_cd
		      }
  			  frm.s_eac_expn_tp_cd.Index2=0
		  }				  
		  

		
	/* 개발자 작업  끝 */