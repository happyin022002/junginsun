/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_COA_0182.js
*@FileTitle : Average 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.21 최성민
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
     * @class ESM_COA_0182 : ESM_COA_0182 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0182() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

  //공통전역변수
  var sheetObjects = new Array();
  var sheetCnt = 0;

  var comboObjects = new Array();
  var comboCnt = 0;
  var costCdArr;

  var loadingMode = false;
  /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  	function processButtonClick(){
  		var sheetObject = sheetObjects[0];
          var formObject = document.form;

  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {
  				case "btn_Retrieve":		//조회
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;

  				case "btn_Save":			//저장
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  					
  				case "btn_Create":			//Creation
  					doActionIBSheet(sheetObject,formObject,IBCREATE);
  					break;

  				case "btn_Downexcel":		//엑셀다운로드
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  					
  				case "btn_Month_Copy":		//팝업창(Month Copy)
  	        	       var display = "0,1";
  	        	       ComOpenPopup("ESM_COA_0173.do?classId=ESM_COA_0182", 250, 200, "AverageUcCopy", display, true, false);
  	        	       break;	
  				case "btn_Rowadd":
  					doActionIBSheet(sheetObject, formObject, IBINSERT);
  					break;
  			} // end switch
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg("COM12111", "", ""));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}

  	/**
  	* Sheet 기본 설정 및 초기화
  	* body 태그의 onLoad 이벤트핸들러 구현
  	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	*/
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		loadingMode = true;
  		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
  		
  		for(k=0;k<comboObjects.length;k++){
              initCombo(comboObjects[k],comboObjects[k].id);
          }
  		loadingMode = false;
  		// 월/주 입력 창에 금월 셋팅
  		setYrMon();	
  		document.form.f_cost_yrmon.focus();
  	}

	
    /**
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 최성민
     * @version 2011.12.26
     */ 
 	function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "f_trd_cd":
 	            with(comboObj) {
 	            	DropHeight = 300;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	MaxLength = 3;
 	            	UseAutoComplete = false;
 	            	InsertItem(0, 'All' ,'');
 	            	InsertItem(1, 'IAS' ,'IAS');
 	            	InsertItem(2, 'IMS' ,'IMS');
 	            	InsertItem(3, 'IES' ,'IES');
 	            	ValidChar(2, 0);	//영문만 입력
 	        	 	Index = 0;
 	            }
 	            break;
 	        case "f_rlane_cd":
 	            with(comboObj) {
 	            	DropHeight = 300;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	MaxLength = 5;
 	            	UseAutoComplete = false;
 	            	InsertItem(0, 'All' ,'');
 	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
 	        	 	Index = 0;
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
  			case 1:		//sheet1 init
  				with (sheetObj) {
  					
  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo(1 , 1, 8, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					
  					var HeadTitle	= "STS|Trade|R.Lane|BD|Name|Amount|BSA|Amount/BSA|U/C Amount|stnd_cost_cd";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false);

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					
  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0,	cnt++,	dtStatus,	30,	daCenter,	false,	"ibflag");
  					InitDataProperty(0,	cnt++,	dtCombo,	70,	daCenter,	true,	"trd_cd",		true,		"",		dfNone,		0,		false,		true);
  					InitDataProperty(0,	cnt++,	dtCombo,	70,	daCenter,	true,	"rlane_cd",		true,		"",		dfNone,		0,		false,	 	true);
  					InitDataProperty(0, cnt++ , dtData,		50, daCenter,	false,	"dir_cd",		true,		"",		dfNone,		0,		false,		true);
  					InitDataProperty(0, cnt++ , dtData,		200,daCenter,	false,	"stnd_cost_nm",	true,		"",		dfNone,		0,		false,		false);
  					InitDataProperty(0, cnt++ , dtData,		150,daRight,	false,	"op_cost_amt",	false,		"",		dfFloatOrg,  3,		false,		false);
  					InitDataProperty(0, cnt++ , dtData,		150,daRight,	false,	"bsa_capa",		false,		"",		dfFloatOrg,  3,		false,		false);
  					InitDataProperty(0, cnt++ , dtData,		100,daRight,	false,	"bsa_capa_cal",	false,		"",		dfFloatOrg,  3,		false,		false);
  					InitDataProperty(0, cnt++ , dtData	,	130,daRight ,	false,	"op_uc_amt",	false,		"",		dfFloatOrg,  3,		true,		true);
  					InitDataProperty(0, cnt++ , dtHidden,	50,	daCenter,	false,	"stnd_cost_cd" );
  					
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(16) ;

	 				InitDataCombo(0, "trd_cd", "IAS|IMS|IES", "IAS|IMS|IES", "", "");     
  					InitComboNoMatchText(true," "); 
  					
  					WaitImageVisible = false;
  				}
  				break;
  		}
  	}
  	
  	/**
       * IBCombo Object를 배열로 등록
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의
       */
      function setComboObject(combo_obj){
          comboObjects[comboCnt++] = combo_obj;
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
   	 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
   	 */
   	function f_trd_cd_OnChange(obj,value,text) {
   		if (loadingMode == true) return; 
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
  		formObj.f_cmd.value = SEARCHLIST10;
  		var sXml = sheetObj.GetSearchXml("ESM_COA_0182GS.do", coaFormQueryString(formObj));
  		var arrXml = sXml.split("|$$|");
  		if (arrXml.length > 0)
  			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
  		formObj.f_rlane_cd.InsertItem(0, "All", "All");
  		formObj.f_rlane_cd.Index = 0;   		
   	}
   
      /**
       * 입력창에 금월 셋팅
       * 사용 : setYrMon()
       *
       * @param NONE
       * @return NONE
       */        
      function setYrMon(){
      	var formObj = document.form;
      	with(formObj){
              var nowYear = ComGetNowInfo("yy");
              var nowMon  = ComGetNowInfo("mm").lpad(2, "0"); 	            
      		var nowYrMon = nowYear + nowMon;
      		
      		f_cost_yrmon.value = ComGetMaskedValue(nowYrMon,'ym');
      	}
      }	
      
  	// Sheet관련 프로세스 처리
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		
  		switch(sAction) {
  			case IBCLEAR:          //조회
  				ComOpenWait(true);
  				formObj.f_cmd.value = INIT;
  				
  				var sXml = sheetObj.GetSearchXml("ESM_COA_0182GS.do", coaFormQueryString(formObj));
  				var arrXml = sXml.split("|$$|");
  				if (arrXml.length > 0)
  					ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true, 0);
  		
  				ComOpenWait(false);
  				break;	
  			case IBSEARCH:		//조회			
  				if(validateForm(sheetObj,formObj,sAction)){	
  					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCHLIST01;
  					sheetObj.DoSearch4Post("ESM_COA_0182GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;

  			case IBSAVE:        // 저장
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI01;
  					sheetObj.DoSave("ESM_COA_0182GS.do", FormQueryString(formObj), -1, false);
  					ComOpenWait(false);
  				//}
  				break;
  				
  			case IBCREATE:		//CREATE
  				var nowYear = ComGetNowInfo("yy");
  	            var nowMon  = ComGetNowInfo("mm").lpad(2, "0"); 	            
  	    		var nowYrMon = nowYear + nowMon;
  	    		
  	    		//Creation시 생성날짜가 조회조건날짜보다 작으면 안된다.
  				if(ComReplaceStr(formObj.f_cost_yrmon.value,'-','') < nowYrMon){
  			        
  					ComShowCodeMessage('COA10053');
  			        formObj.f_cost_yrmon.focus();
  			        return false;
  				}else{
  					// 업무처리중 버튼사용 금지 처리
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI02;
  					sheetObj.DoSearch4Post("ESM_COA_0182GS.do", FormQueryString(formObj));
  					ComOpenWait(false);
  				}	
  				break;				

  			case IBDOWNEXCEL:        //엑셀 다운로드
                  var excelType = selectDownExcelMethod(sheetObj);
                  switch (excelType) {
                      case "AY":
                          sheetObj.Down2Excel(0, false, false, true);
                          break;
                      case "DY":
                          sheetObj.Down2Excel(-1, false, false, true);
                          break;
                      case "AN":
                          sheetObj.SpeedDown2Excel(0, false, false);
                          break;
                      case "DN":
                          sheetObj.SpeedDown2Excel(-1, false, false);
                          break;
                  }               
  				break;
  			/*	
  			case IBINSERT:                  // 입력
  				if(sheetObj.SelectRow>0 && sheetObj.CellValue(sheetObj.SelectRow, "trd_cd") != ""){
      				sheetObj.DataInsert(-1);
      				sheetObj.CellValue(sheetObj.SelectRow, "trd_cd") = sheetObj.CellValue(sheetObj.SelectRow-1, "trd_cd");
      				sheetObj.CellValue(sheetObj.SelectRow, "wky_tgt_flg") = "NO";
      				sheetObj.CellValue(sheetObj.SelectRow, "mon_tgt_flg") = "NO";
      				sheetObj.CellValue(sheetObj.SelectRow, "delt_flg") = "NO";
  				}
  				break;	
  			*/	
  		}
  	}
      
  	/**
  	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	*/
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if (f_cost_yrmon.value == "") {
  				ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
  				f_cost_yrmon.focus();
  				return false;
  			} 
              if(f_cost_yrmon.value.replace("-","").length != 6) {
  			    // [COM12114] : YYYY-MM 를(을) 확인하세요.
              	ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
              	f_cost_yrmon.focus();
                  return false;
              }
              //if(!isValidYYYYWW(f_cost_yrmon, false, '-', false)) return false;
              if(!ComChkObjValid(f_cost_yrmon, null, null, "yw")) return false;
              
  		}
  		return true;
  	}

  	/**ESM_COA_182
  	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	* "Trade|R.Lane|Sub Group|Name|Amount|BSA|Amount/BSA|U/C Amount|Remark"
  	*/
  	
      function Dup_CheckForm(sheetObj,formObj,sAction){
  		var rtn = true;
  		with(formObj){
  			var dr = sheetObj.ColValueDup("trd_cd|rlane_cd|dir_cd|stnd_cost_cd|op_cost_amt|BSA_CAPA|BSA_CAPA_CAL|op_uc_amt");
  			if(dr>0){//중복된 값이 있는경우
  				ComShowMessage(ComGetMsg('COM12115', 'DATA'));
  				sheetObj.SelectCell(dr,"trd_cd|rlane_cd|dir_cd|stnd_cost_cd|op_cost_amt|BSA_CAPA|BSA_CAPA_CAL|op_uc_amt");
  				rtn = false;
  			}
  		}
  		return rtn;
  	}
      /**
      * ESM_COA_177 화면을 오픈한다.
      * 
      * @return
      */
     function openLaneDetail(){
  	    var formObj = document.form;
  		  
  	    //ComOpenWindow('ESM_COA_0177.do?cost_use_tp_cd=C','Lane_Detail', 'width=330, height=350,menubar=0,status=0,scrollbars=0,resizable=1');
  	    ComOpenWindow('ESM_COA_0177.do?cost_use_tp_cd=C','Lane_Detail', 'width=400, height=350,menubar=0,status=0,scrollbars=0,resizable=1');

     }
