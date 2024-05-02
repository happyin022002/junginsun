function ESD_TES_0032() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				case "btn_vndr":
	                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
	                var classId = "COM_ENS_0C1";
	                var param = '?classId='+classId;
	                var chkStr = dispaly.substring(0,3);
	
	                // radio PopUp
	                if(chkStr == "1,0") {
	                	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
	                } else {
	                	ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
	                	return;
	                }
	                break;
	                
				case "btn_retrieve":	
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_new":	
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					formObject.reset();
					break;
					
				case "btn_save":	
					if(formObject.ida_spcl_ecn_zn_ut_flg.value == "Y" && formObject.ida_spcl_ecn_zn_doc_no.value == ""){
						ComShowMessage("Please register SEZ Certificate.");
						return false;
					} 
					
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_upload":	
					openFileUpload();
					break;				

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(getMsg('TES21025'));
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
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * @return
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:	  //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(12);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(17, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "S/P Code|S/P Name|Location|State Code|State Name|Country|Zip Code|Address|Control Office|Tel No.|Fax No.|E-Mail|Abbreciation Name|Register No|Contact Person|Payment Term Type|Payment Term" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"vndr_seq",			false,			"",			dfNone,			0,			false,		    false );
					InitDataProperty(0, cnt++ , dtData,	 		250,	daLeft,			false,	"vndr_lgl_eng_nm",	false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"loc_cd",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_ste_cd",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_ste_nm",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"vndr_cnt_cd",		false,			"",			dfNone,			0,			false,			false );
					
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"zip_cd",		false,			"",			dfNone,			0,			false,			false );
					
					InitDataProperty(0, cnt++ , dtData,	 		250,	daLeft,			false,	"eng_addr",			false,			"",			dfNone,			0,			false,			false );					
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ofc_cd",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"phn_no",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"fax_no",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daLeft,			false,	"vndr_eml",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daLeft,			false,	"vndr_abbr_nm",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"rgst_no",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daLeft,			false,	"cntc_pson_nm",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"pay_term_tp_cd",	false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"gen_pay_term_cd",	false,			"",			dfNone,			0,			false,			false );
					
			   }
				break; 
				
			case 2:	  //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(10);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "S/P Code|S/P Name|State Code|State Name|PAN No|GST Req No|SEZ Unit|Contact Person|Altr Payee|Email|Company Type|SEZ Certificate|GST Registration Status|No. of GST Registration" ;
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_vndr_seq",			false,			"",			dfNone,			0,			false,		    false );
					InitDataProperty(0, cnt++ , dtData,	 		250,	daCenter,		false,	"ida_vndr_nm",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_ste_cd",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_ste_nm",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_pan_no",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_gst_rgst_no",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_spcl_ecn_zn_ut_flg",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_cntc_pson_nm",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_altn_rcvr_nm",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_vndr_eml",			false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_co_type_cd",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_spcl_ecn_zn_doc_desc",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_gst_rgst_sts_cd",		false,			"",			dfNone,			0,			false,			false );
					InitDataProperty(0, cnt++ , dtData,	 		100,	daCenter,		false,	"ida_gst_rgst_tp_cd",	false,			"",			dfNone,			0,			false,			false );
			   }
				break;
				

		}
	}
	
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	        sheetObj.ShowDebugMsg = false;
	        switch(sAction) {
	            case IBSEARCH:  
	                formObj.f_cmd.value = SEARCH;
	                var searchXml = sheetObj.GetSearchXml("ESD_TES_0032GS.do", tesFrmQryStr(formObj));
	                if (searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
	                searchXml = null;
	                break;
         
	            case IBSEARCH_ASYNC01:  
	                formObj.f_cmd.value = SEARCH01;
	                var searchXml = sheetObj.GetSearchXml("ESD_TES_0032GS.do", tesFrmQryStr(formObj));
	                if (searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
	                searchXml = null;
	                break;
	                
	            case IBSAVE:
	            	formObj.f_cmd.value = MODIFY;	                
	                var saveXml = sheetObj.GetSaveXml("ESD_TES_0032GS.do", tesFrmQryStr(formObj));	   
	                
	                if (saveXml.length > 0){
	    				var State = ComGetEtcData(saveXml,"TRANS_RESULT_KEY");
	    				if ( State == "S" ) {	
	    					ComShowMessage("Data has been saved sucessfully.");
	    				}
	                }
	                saveXml = null;
	                break;                
	        }
	 }
	  
	 function sheet1_OnSearchEnd(sheetObj) {
		 var formObj = document.form;
		 var sheetObject1 = sheetObjects[1];
		 		 
		 if(sheetObj.RowCount > 0 && formObj.f_cmd.value == SEARCH){
			 formObj.ida_vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow,'vndr_seq');
			 doActionIBSheet(sheetObject1,formObj,IBSEARCH_ASYNC01);
		 }
	 }
	 
	 function sheet1_OnClick(sheetObj, Row, Col, Value) {//alert("sheet1_OnClick");
		 var formObj = document.form;
		 var sheetObject1 = sheetObjects[1];
		 
		 sheetObject1.RemoveAll();
		 
		 formObj.ida_vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow,'vndr_seq');
		 doActionIBSheet(sheetObject1,formObj,IBSEARCH_ASYNC01);
	 }
	 
	 function sheet2_OnSearchEnd(sheetObj) { 
		 var formObj = document.form;
		  
			 formObj.ida_vndr_seq.value = sheetObj.CellValue(1, "ida_vndr_seq");
			 formObj.ida_vndr_nm.value = sheetObj.CellValue(1, "ida_vndr_nm");
			 formObj.ida_ste_cd.value = sheetObj.CellValue(1, "ida_ste_cd");
			 formObj.ida_ste_nm.value = sheetObj.CellValue(1, "ida_ste_nm");
			 formObj.ida_pan_no.value = sheetObj.CellValue(1, "ida_pan_no");
			 formObj.ida_gst_rgst_no.value = sheetObj.CellValue(1, "ida_gst_rgst_no");
			 formObj.ida_spcl_ecn_zn_ut_flg.value = sheetObj.CellValue(1, "ida_spcl_ecn_zn_ut_flg");
			 formObj.ida_cntc_pson_nm.value = sheetObj.CellValue(1, "ida_cntc_pson_nm");
			 formObj.ida_altn_rcvr_nm.value = sheetObj.CellValue(1, "ida_altn_rcvr_nm");
			 formObj.ida_vndr_eml.value = sheetObj.CellValue(1, "ida_vndr_eml");		
			 formObj.ida_co_type_cd.value = sheetObj.CellValue(1, "ida_co_type_cd");
			 formObj.ida_spcl_ecn_zn_doc_desc.value = sheetObj.CellValue(1, "ida_spcl_ecn_zn_doc_desc");
			 formObj.ida_gst_rgst_sts_cd.value = sheetObj.CellValue(1, "ida_gst_rgst_sts_cd");
			 formObj.ida_gst_rgst_tp_cd.value = sheetObj.CellValue(1, "ida_gst_rgst_tp_cd");
			 
	 }
	 
	//================================= Vendor Code 관련 함수 시작 =============================================
    /**
	 * 입력된 vndr_seq값을 Validation하는 함수
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()==''){
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}


	/**
	 *  VndrCode Validation 함수
	 */
	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';

		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_nm.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
	}

	/**
	 *  Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param(rowArray) 로우배열
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray);
		document.all.vndr_seq.value = colArray[2];
		document.all.vndr_seq_nm.value = colArray[4];
	}

	/**
	 * Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param {int}	rowArray	로우배열
	 *  @param {int}	row 		셀의 row index
	 *  @param {int}	col 		셀의 col index	
	 */
	function getVenderGrid(rowArray, row ,col) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray[2].substr(2,6));
		//ComShowMessage(row+" : "+ col);
		sheetObjects[2].CellValue(row, col) =colArray[2];
	}

	//================================= Vendor Code 관련 함수 끝 =============================================
	 
	function chkSezDoc(){
		var formObj = document.form;
		
		if(formObj.ida_spcl_ecn_zn_ut_flg.value == "Y"){
			openFileUpload();
		}
	}
	
	
	function openFileUpload(){
		var formObj = document.form;
		var returnValue = openUpload("TES","1","1");
		
        if( returnValue == undefined || returnValue == "" ){
            return;
        }

        if(returnValue != undefined && returnValue != "" ){
     	   var fileInfo = returnValue.split('<>');
     	   
     	   formObj.ida_spcl_ecn_zn_doc_no.value = fileInfo[0];
     	   formObj.ida_spcl_ecn_zn_doc_desc.value = fileInfo[1].replace(/^.*[\\\/]/, '');
        }
	}
	 