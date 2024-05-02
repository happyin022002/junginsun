/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_CIM_0066.js
*@FileTitle : UC Activity
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
     * @class EES_CIM_0066 : EES_CIM_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_0066() {
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
  		case 1:      
  			with (sheetObj) {
  				//세로높이설정
  				style.height = 400;// 252 ;
  				//전체 너비 설정
  				SheetWidth = mainTable.clientWidth;

  				//Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  				//전체Merge 종류 [선택, Default msNone]
  				MergeSheet = msAll;

  				//전체Edit 허용 여부 [선택, Default false]
  				Editable = true;

  				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  				InitRowInfo( 1, 1, 10, 100);

  				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(12, 2, 0, true);

  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, false, true, false,false)

  				var HeadTitle = "Del.|STS|UC NO.|uc_cgo_file_id|Seq.|Title|Upload date|Upload By|Upload By|File Attached|file_cnt|file_sav_id" ;
  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성     [ROW,     COL,   DATATYPE,WIDTH, DATAALIGN, COLMERGE, SAVENAME, 			 KEYFIELD, CALCULOGIC, 	 DATAFORMAT, POINTCOUNT,  UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0, cnt++ , dtDelCheck,   30,  daCenter,  false,    "sel");
  				InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,  false,    "ibflag");
  				InitDataProperty(0, cnt++ , dtData,      120,  daLeft,    true,     "uc_cs_no",          	false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     80,  daRight,   false,     "uc_cgo_file_id",      false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  false,    "file_no_seq", 			false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,      350,  daLeft,    false,    "file_desc",           	true,          "",       dfNone,   			0,     true,      true,		500);
  				InitDataProperty(0, cnt++ , dtData,       80,  daLeft,    false,    "upd_dt",       		false,         "",       dfUserFormat2,     0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       70,  daLeft,    false,    "ofc_cd",				false,         "",       dfNone,   			0,     false,     false,	6);
  				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  false,    "upd_usr_id",        	false,         "",       dfNone,   			0,     false,     false,	20);
  				InitDataProperty(0, cnt++ , dtData,       55,  daCenter,  false,    "img_file_no",       	false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     55,  daCenter,  false,    "file_cnt",				false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     55,  daCenter,  false,    "file_sav_id",       	false,         "",       dfNone,           	0,     false,     false,	8);
  				 
  				// ImageList(0) = "/hanjin/img/enis/button/btns_filesearch.gif";
  				InitUserFormat2(0, "upd_dt", "####-##-##", "-|:" );
  				DataLinkMouse("img_file_no") = true;
  				
  				ColHidden('sel')= true;
  				ColHidden('ibflag')= true;
  				
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
  				case "btn_add1":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save1":
  					doActionIBSheet(sheetObject,formObject,MULTI01);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
  				sheetObj.DoSearch4Post("EES_CIM_0066GS.do", FormQueryString(formObj));
  				//retrieveEnd(sheetObj);
  				break;
 			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert(-1);

  				if(sheetObj.CellValue(Row - 1,"file_no_seq") == 'Seq.'){
  	  				sheetObj.CellValue2(Row,"file_no_seq") = 1;
  				}else{
  	  				sheetObj.CellValue2(Row,"file_no_seq") = ComParseInt(sheetObj.CellValue(Row - 1,"file_no_seq")) + 1;
  				}
  				
  				sheetObj.CellValue2(Row,"upd_usr_id") = formObj.s_user_id.value;
//  				sheetObj.CellValue2(Row,"img_file_no") = "File Attach";
  				sheetObj.CellValue2(Row,"img_file_no") = "FILE ATTACH";
				sheetObj.CellValue(Row,"uc_cs_no") = formObj.s_uc_cs_no.value;
				sheetObj.CellValue(Row,"ofc_cd") = formObj.s_if_ofc_cd.value;
				sheetObj.CellValue(Row,"uc_cgo_file_id") = formObj.s_uc_cgo_file_id.value;
  					
  				// 입력 한도 설정 - 초기 row add시 문구 설정
//  				sheetObj.CellValue2(Row,"file_desc") = " Max. 500 charactors allowed as the remark. If more, please attach it with file afer 'Confirmation'";
  				sheetObj.CellFontColor(Row,"file_desc") = sheetObj.RgbColor(153, 153, 153);
  				sheetObj.CellFont("FontItalic",Row,"file_desc") = true;

  				break;
  			case MULTI01:		//저장

  				// Title 입력 한도 설정
	  			for(var idx=1;idx<=sheetObj.RowCount;idx++){
//	  	        	if (sheetObj.CellValue(idx,"ibflag") == "I" 
//	  	        		&& sheetObj.CellValue(idx,"file_desc") == " Max. 500 charactors allowed as the remark. If more, please attach it with file afer 'Confirmation'"){       		
//	  	        		sheetObj.CellValue2(idx,"file_desc") = "";
//	  	        		sheetObj.CellFontColor(idx,"file_desc") = sheetObj.RgbColor(0, 0, 0);
//	  	        		sheetObj.CellFont("FontItalic",idx,"file_desc") = false;
//	  	        	}
	  	        	
	  	        	if (sheetObj.CellValue(idx,"ibflag") == "D"){
	  	        		if(sheetObj.CellValue(idx,"file_cnt") != 0){
		  	        		ComShowMessage(ComGetMsg("CIM30034"));
		  	        		return false;
	  	        		}
	  	        	}else if (sheetObj.CellValue(idx,"ibflag") == "I"){
	  	        		if(sheetObj.CellValue(idx,"file_cnt") == 0){
		  	        		ComShowMessage(ComGetMsg("CIM30038"));
		  	        		return false;
	  	        		}
	  	        	}

	  	  		}
  			
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}

  				formObj.f_cmd.value = MULTI01;
  				sheetObj.DoSave("EES_CIM_0066GS.do", FormQueryString(formObj));
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
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
  			/**
  			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
  			 */
  			//if (!isNumber(formObj.iPage)) {
  			//	return false;
  		   // }
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
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){

  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg("CIM30031"));
  		}else{
  			ComShowMessage(errMsg);
  		}
  	}

  	var fileAttchRow = "0";
      function sheet1_OnClick(sheetObj,Row,Col,Value){
          if(sheetObj.ColSaveName(Col) == "img_file_no"){ // sheetObj.RowEditable(Row) && 
              var fileAttachAuthYn = "N";
    			if (sheetObj.CellValue(Row, "img_file_no").length>0) { // MANUAL INPUT 
  				if ( isReadOnly != "Y" // not read only
              		&& document.form.s_uc_cs_no.value != ""  // inv 기준일 경우 
              		&& ( sheetObj.CellValue(Row,"upd_usr_id") == document.form.s_user_id.value ) // same user
              	   ){
              	    fileAttachAuthYn = "Y";
  				}
  				fileAttchRow = Row;

  			    //var rtnValue = openFileUploadPopup(sheetObj.CellValue(Row,"uc_cs_no"),sheetObj.CellValue(Row,"uc_cgo_file_id"),sheetObj.CellValue(Row,"file_sav_id"),sheetObj.CellValue(Row,"file_desc"), '', 'Y', fileAttachAuthYn);
  			    var rtnValue = openFileUploadPopup(sheetObj.CellValue(Row,"uc_cs_no"),sheetObj.CellValue(Row,"uc_cgo_file_id"),sheetObj.CellValue(Row,"file_sav_id"),sheetObj.CellValue(Row,"file_desc"));
  			  
  			    getFileNoSheet(rtnValue);
  			}
  		}
          
  	}

  	function getFileNoSheet(fileNoReceive){
      	var currentFileNo = sheetObjects[0].CellValue(fileAttchRow, "uc_cgo_file_id");
          if ( currentFileNo==undefined || currentFileNo==null || currentFileNo=="" || currentFileNo=="0" ) { // 현재 file no가 유효하지 않았을 경우
      		if ( fileNoReceive!=undefined && fileNoReceive!=null && fileNoReceive!="" && fileNoReceive!="0" ) {
                  sheetObjects[0].CellValue(fileAttchRow, "uc_cgo_file_id") = fileNoReceive;
                  sheetObjects[0].CellFontUnderline(i, "img_file_no") = true;
              }
          }
  		fileAttchRow = "0"; // 초기화 
  	}
  	
  	// Remark 입력 한도 설정
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		var colNm = sheetObj.ColSaveName(NewCol);
//  		if( colNm == "file_desc"){
//  			for(var idx=1;idx<=sheetObj.RowCount;idx++){
//	        	if (sheetObj.CellValue(NewRow,"ibflag") == "I" 
//	        		&& sheetObj.CellValue(NewRow,"file_desc") == " Max. 500 charactors allowed as the remark. If more, please attach it with file afer 'Confirmation'"){       		
//	        		sheetObj.CellValue2(NewRow,"file_desc") = "";
//	        		sheetObj.CellFontColor(NewRow,"file_desc") = sheetObj.RgbColor(0, 0, 0);
//	        		sheetObj.CellFont("FontItalic",NewRow,"file_desc") = false;
//	        	}
//  			}
//  		}
    }
