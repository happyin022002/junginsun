/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1150.js
*@FileTitle : Edit VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.20
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.07.20 조정민
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
     * @class esm_bkg_1150 : esm_bkg_1150 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1150() {
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
  //공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    //버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    		case "btn_RowAdd":
    			if(formObject.vsl_cd.value == ''){
    				ComShowCodeMessage("BKG00401");//Vessel Code is missing !    
    				document.form.vsl_cd.focus();
    				return false;
    			}
				addRow();
    			break;

    		case "btn_Delete":
    			if(ComShowCodeConfirm('BKG95003', 'delete')){ 
					deleteRow();
    			}
    			break;

    		case "btn_Retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;

    		case "btn_Save":
    			
    			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    			break;
    			
			case "btn_Close":
				self.close();
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

    	// Key 입력 처리
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListenerFormat("KeyUp", "obj_KeyUp",  document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    	if (document.form.vsl_cd.value.length == 4) {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	}

    }

    /**
     * VVD 탭키 없이 이동 처리
     * @return
     */
    function obj_KeyUp()
    {
    	var formObj = document.form;
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName = event.srcElement.getAttribute("name");
        var srcValue = event.srcElement.getAttribute("value");
        
        if (keyValue <=16 || keyValue==46 || ( keyValue >= 35 && keyValue <=40) ) return;
        
        switch(srcName) {
        case "vsl_cd":
        	if (formObj.vsl_cd.value.length > 3) formObj.skd_voy_no.focus();
        	break;
        case "skd_voy_no":
        	if (formObj.skd_voy_no.value.length > 3) formObj.skd_dir_cd.focus();
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
    	var sheetID = sheetObj.id;
    	
    	switch(sheetID) {

    	case "sheet1":
    		with (sheetObj) {

    			// 높이 설정
    			style.height = 220;
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

    			var HeadTitle1 = "|Sel.|Seq.|VVD|VVD|VVD|Vessel Name|Voy/Dir";
    			var headCount = ComCountHeadTitle(HeadTitle1);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false);

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle1, true);

    			//데이터속성    [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
    			InitDataProperty(0,		cnt++ , dtCheckBox,			40,		daCenter,		true,		"Sel",					false,		"",		dfNone,			0,		true,	true);
    			InitDataProperty(0,		cnt++ , dtDataSeq,			30,		daCenter,		true,		"Seq",					false,     "",		dfNone,			0,		false, false, 0, 		false, false);
    			InitDataProperty(0,		cnt++ , dtData,				40,		daCenter,		true,		"vsl_cd",				true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
    			InitDataProperty(0,		cnt++ , dtData,				40,		daCenter,		true,		"skd_voy_no",			true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
    			InitDataProperty(0,		cnt++ , dtData,				20,		daCenter,		true,		"skd_dir_cd",			true,		"",		dfEngUpKey,		0,		true,	true,	1,		true);
    			InitDataProperty(0,		cnt++ , dtData,				180,	daLeft,			true,		"mapg_vsl_nm",			true,		"",		dfEngUpKey,		0,		true,	true,	100);
    			InitDataProperty(0,		cnt++ , dtData,				60,	daLeft,			true,		"mapg_voy_dir_nm",		true,		"",		dfEngUpKey,		0,		true,	true,	6);

    			CountPosition = 0;
    			InitDataValid(0, 	3, vtEngUpOther,"1234567890");vtNumericOnly
    			InitDataValid(0, 	4, vtNumericOnly);
    			InitDataValid(0, 	5, vtEngOnly);

    		}
    		break;
    	}
    }

     
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    	case IBSEARCH:      //조회		
    		if(validateForm(sheetObj,formObj,sAction)) {
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.WaitImageVisible = false;
    			ComOpenWait(true);

    			var sXml = sheetObj.GetSaveXml("ESM_BKG_1150GS.do", FormQueryString(formObj));
    			var valResult = ComGetEtcData(sXml, "vessel_nm");
    			formObj.vsl_nm.value = valResult;
    			
    			var arrXml = sXml.split("|$$|");
    	       	if(arrXml.length > 0) {
    	       		sheetObj.LoadSearchXml(arrXml[0]); 
    	       	}
    	       	
    			ComOpenWait(false);
    		}
    	break;
    	
    	case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
	    		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
		    		formObj.f_cmd.value = MULTI;
					ComOpenWait(true);
					var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
					var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_1150GS.do", "f_cmd=" + MULTI + "&" +sParam);
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if(State != "S"){
						ComOpenWait(false, false);
						ComShowMessage(ComResultMessage(sXml));					
						return false;
					}else if(State == "S"){
						ComShowCodeMessage('BKG00166');
					}
					ComOpenWait(false);
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	    			
	    		}
			}
    		break;

    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){

    		switch(sAction) {
    		case IBSEARCH:
    			if (formObj.vsl_cd.value.length < 4) {
    				ComShowCodeMessage("BKG00115");
    				formObj.vsl_cd.focus();
    				return false;
    			}
    			break;
    			
    		case IBSAVE:
      	     	if (! sheetObj.IsDataModified){
      	     		ComShowCodeMessage('BKG00989');
    				return false; //There is no updated data to save.
    		      	}
		      	for (var i = 1 ; i < sheetObj.RowCount +1 ; i++){
		  	    	if (sheetObj.CellValue(i, "vsl_cd") == '' || sheetObj.CellValue(i, "skd_voy_no") == ''
		  	    		||sheetObj.CellValue(i, "skd_dir_cd") == '' || sheetObj.CellValue(i, "mapg_vsl_nm") == '' 
		  	    		|| sheetObj.CellValue(i, "mapg_voy_dir_nm") == '' ){
		  	    		
		  	    		var msg = '';
		  	    		if(sheetObj.CellValue(i, "vsl_cd") == '' || sheetObj.CellValue(i, "skd_voy_no") == '' 
		  	    			|| sheetObj.CellValue(i, "skd_dir_cd") == '')
		  	    			msg = 'VVD';
		  	    		else if(sheetObj.CellValue(i, "mapg_vsl_nm") == '' )
		  	    			msg = 'Vessel Name';
		  	    		else
		  	    			msg = 'Voy/Dir';
		  	 
	  	    			ComShowCodeMessage("BKG01101", msg);//{?msg1} is mandatory. 
	  	    			
		  	    		return false;
		  	    		
		  	    	}
		      	}
		      	break;
        	  
    			
    		}
    	}

    	return true;
    }
     
     
 	/**
 	 * add row process in sheet1
 	 * add one row
 	 */
  	function addRow() {
  	  with (sheetObjects[0]) {
  		  var formObject = document.form;
          var nowRow = SelectRow;
        	 nowRow = DataInsert(-1); 
        	 sheetObjects[0].CellValue(nowRow,"vsl_cd") = formObject.str_vsl_cd.value;
        	 sheetObjects[0].CellValue(nowRow,"skd_voy_no") = formObject.str_skd_voy_no.value;
        	 sheetObjects[0].CellValue(nowRow,"skd_dir_cd") = formObject.str_skd_dir_cd.value;
        	 sheetObjects[0].CellValue(nowRow,"mapg_vsl_nm") = formObject.vsl_nm.value;
          return true;
           }
 	 }
 	/**
 	 * delete row process in sheet1
 	 * delete one row
 	 */  
 	 function deleteRow() {
  
 	     with (sheetObjects[0]) {
 	  		if (sheetObjects[0].CheckedRows("Sel") <= 0 ) {
 				ComShowCodeMessage("BKG00249");
 	 		}	 
 	         var sRowStr = FindCheckedRow("Sel");
 	         var arr = sRowStr.split("|");
 	
 	
 	         for (var i=0; i<arr.length - 1; i++) {
 	             
 	        	 RowStatus(arr[i]) = "D";    
 	             RowHidden(arr[i]) = "true"; 
 	                 
 	         }
 	
 	     }         
 	 }    
