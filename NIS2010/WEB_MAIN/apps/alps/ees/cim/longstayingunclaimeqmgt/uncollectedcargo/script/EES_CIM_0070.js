/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_CIM_0070.js
*@FileTitle : UC-VOL_DTL
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/

    /**
     * @extends 
     * @class EES_CIM_0070 : EES_CIM_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_0070() {
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
    /* 공통전역변수 */
	//var calPop = new calendarPopupGrid();
	var curTab = 1;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	
	var isReadOnly = "";
	
	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다.  */

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
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
  		//alert('refresh-3');
  		isReadOnly = document.form.s_readonly.value;
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  		
  		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
 		chg_pop_gb();
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  		case 1:      //t1sheet1 init
  			with (sheetObj) {
  				//세로높이설정
  				style.height = 400;// 252 ;
  				//전체 너비 설정
  				SheetWidth = 100;
  				//alert(SheetWidth);
  				//Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  				//전체Merge 종류 [선택, Default msNone]
  				MergeSheet = msHeaderOnly;

  				//전체Edit 허용 여부 [선택, Default false]
  				Editable = true;

  				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  				InitRowInfo( 1, 1, 10, 100);

  				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(3, 0, 0, true);

  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, true, true, false,false);

  				var HeadTitle = "|CNTR|TYPE" ;

  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성     [ROW,     COL,   DATATYPE,WIDTH, DATAALIGN, COLMERGE, SAVENAME, 			 KEYFIELD, CALCULOGIC, 	 DATAFORMAT, POINTCOUNT,  UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0, cnt++ , dtCheckBox,	   30,	daCenter,   false,	"sel", 			false,    "",      	dfNone,          0,         true,        true);
  				InitDataProperty(0, cnt++ , dtData,       150,  daCenter,   true,   "cntr_no",		false,    "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   false,  "cntr_tpsz_cd", false,    "",       dfNone,           	0,     false,     false,	8);

  				WordWrap = true;
  			}
  			break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_ok":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_close":
  					window.close();
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case SEARCH01:	  //조회
  				formObj.f_cmd.value = SEARCH01;
  				sheetObj.DoSearch4Post("EES_CIM_0070GS.do", FormQueryString(formObj));
  				break;
 			case IBINSERT:	  //입력
  				// Title 입력 한도 설정
 				var rst_cntr_no = "";
 				var rst_cntr_tpsz_cd = "";
 				var str_cntr_tpsz_cd = "";
 				var temp_cntr_tpsz_cd = "";
 				var rst_cnt = 0;
 				var cntcnt = 0;
 				var dff_cnt = 0;
 				
 				var comboNoArray = new Array();
	  			for(var idx=1;idx<=sheetObj.RowCount;idx++){
	  	        	if (sheetObj.CellValue(idx,"sel") == "1"){
	  	        		comboNoArray[cntcnt] = sheetObj.CellValue(idx,"cntr_tpsz_cd");
	  	        		
        				if(cntcnt == 0){
        					rst_cntr_no = sheetObj.CellValue(idx,"cntr_no");
        				}else{
        					rst_cntr_no += ", "+sheetObj.CellValue(idx,"cntr_no");
        				}
	  	        		
	  	        		cntcnt++;
	  	        	}
	  			}
	  			
	  			comboNoArray.sort();
	  			
	  	   		for(var i=0; i<=comboNoArray.length; i++)
	  	   		{
  	        		if(i == 0){
	        			str_cntr_tpsz_cd = comboNoArray[i];
	        			temp_cntr_tpsz_cd = comboNoArray[i];
	        			rst_cnt = 1;
	        		}else{
	        			str_cntr_tpsz_cd = comboNoArray[i];
	        			
	        			if(str_cntr_tpsz_cd == temp_cntr_tpsz_cd){
		        			str_cntr_tpsz_cd = comboNoArray[i];
		        			rst_cnt++;
	        			}else{
	        				if(dff_cnt == 0){
	        					rst_cntr_tpsz_cd += temp_cntr_tpsz_cd +"X"+rst_cnt;
	        				}else{
	        					rst_cntr_tpsz_cd += ", "+temp_cntr_tpsz_cd +"X"+rst_cnt;
	        				}

		        			temp_cntr_tpsz_cd = comboNoArray[i];
		        			rst_cnt = 1;
		        			dff_cnt++;
	        			}
	        		}
	  	   		}
	  			//호출한 Form 의 해당 Object에 결과값 Return
	  			window.dialogArguments.document.form.ctrt_ttl_vol_ctnt.value = rst_cntr_tpsz_cd;
	  			window.dialogArguments.document.form.cntr_list.value = rst_cntr_no;
	  			window.close();
	  			
  				break;
  		}
  	}
  	
  	function retrieveEnd(sheetObj){
  		var cnt = sheetObj.RowCount;
  		var idx;
  		
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
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
     * 팝업 구분
     */
    function chg_pop_gb() {
  		var formObj = document.form;
  		
//  		alert("formObj.bl_no.value : " + formObj.bl_no.value);
//  		alert("formObj.ctrt_ttl_vol_ctnt.value: " + formObj.ctrt_ttl_vol_ctnt.value);
//  		alert("formObj.cntr_list.value: " + formObj.cntr_list.value);
  		
  		if(formObj.bl_no.value != ''){
  			sheetObjects[0].ColHidden('sel')= false;
  			if(ComTrim(formObj.ctrt_ttl_vol_ctnt.value) == ''){
  				// 최초 Open이면 아무것도 안하는 것이 맞음.
//	  			for(var idx=1;idx<=sheetObjects[0].RowCount;idx++){
//	  				sheetObjects[0].CellValue2(idx, 'sel') = "0";
//	  			}

  			}else{
	  			if(ComTrim(formObj.ctrt_ttl_vol_ctnt.value) != '' && ComTrim(formObj.cntr_list.value) != ''){
	  	 			var checkCntrArray = formObj.cntr_list.value.split(',');
		  	 		checkCntrArray.sort();

		  			for(var idx=1;idx<=sheetObjects[0].RowCount;idx++){
		  				sheetObjects[0].CellValue2(idx, 'sel') = "0";
		  			}
		  	 		
		  			for(var idx=1;idx<=sheetObjects[0].RowCount;idx++){
		  	  	 		for(i=0;i<checkCntrArray.length;i++){
		  	  	 			if(ComTrim(sheetObjects[0].CellValue(idx,"cntr_no")) == ComTrim(checkCntrArray[i])){
		  	  	 				sheetObjects[0].CellValue2(idx, 'sel') = "1";
		  	  	 			}
		  	  	 		}
		  			}
	  	 		}
  			}
  		}else{
  	 		sheetObjects[0].ColHidden('sel')= true;
  	 	}
  		
  		if(isReadOnly=="Y"){
  			sheetObjects[0].ColHidden('sel')= true;
  		}
    }
  	