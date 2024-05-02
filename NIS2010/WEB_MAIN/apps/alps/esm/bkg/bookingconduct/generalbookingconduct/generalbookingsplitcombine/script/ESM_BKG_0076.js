/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0076.js
*@FileTitle : Booking Combine
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.25 전용진
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
     * @class ESM_BKG_0076 : ESM_BKG_0076 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0076() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
         /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_rowadd":
					var Row = sheetObjects[0].DataInsert(-1);
					sheetObjects[0].CellEditable(Row, 0) = true;
					sheetObjects[0].CellEditable(Row, 1) = true;
					sheetObjects[0].CellEditable(Row, 2) = true;
					sheetObjects[0].CellEditable(Row, 3) = true;
					for (var i=4;i<15;i++) {
						sheetObjects[0].CellEditable(Row,i) = false;
					}
					break;

				case "btn_rowdelete":
					var delRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
					var delRow = delRowArr.split("|");

					if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
						for (var idx=delRow.length-2; idx>=0; idx--){
							sheetObjects[0].RowDelete(delRow[idx], false);
						}
					}
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_combine":
					if(!validateForm(sheetObjects[0],document.form,"btn_combine")) {
						return false;
					}
					comBkgCallPop0974('callBack0974');
					break;
				
				case "btn_container":
					doActionIBSheet(sheetObjects[0],document.form,"btn_container");
					break;

				case "btn_cancel":
					doActionIBSheet(sheetObjects[0],document.form,"btn_cancel");
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
		ComBtnDisable("btn_rowadd");
		ComBtnDisable("btn_rowdelete");
    }

 	function initControl() {
 		var formObject = document.form;
 		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
 		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
 		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
// 		axon_event.addListenerForm('blur', 'form1_blur', formObject);
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
                    style.height = 442;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 19, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = " ||Booking Number|B/L No.|Status|Shipper|POR|POR|POL|POL|POD|POD|DEL|DEL|CNTR Vol||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,		false,		"ibflag",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,				30,		daCenter,		false,		"slct_flg",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		"bkg_no",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		"bl_no",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"bkg_sts_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					150,	daLeft,			false,		"cust_nm",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		false,		"por_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		"por_nod_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		false,		"pol_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		"pol_nod_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		false,		"pod_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		"pod_nod_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		false,		"del_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,		false,		"del_nod_cd",	false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daLeft,			false,		"cntr_vol",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"cust_cd");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"bdr_flg");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"vvd");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"master_flg");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"bkg_ofc_cd");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,			false,		"broker");
					InitDataValid(0, 2, vtEngUpOther, "0123456789#$");
					InitDataValid(0, 3, vtEngUpOther, "0123456789#$");
					
					WordWrap = false;
					CountPosition = 0;
               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	        	formObj.f_cmd.value = SEARCH;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");

	           	var sXml = sheetObj.GetSearchXml("ESM_BKG_0076GS.do", params);
	           	
         		sheetObjects[0].Redraw = false;
         		sheetObjects[0].LoadSearchXml(sXml);
         		sheetObjects[0].Redraw = true;

				if ( formObj.search_gbn[0].checked ) {
					for (var i=1;i<=sheetObjects[0].TotalRows;i++) {
						sheetObjects[0].CellEditable(i, 0) = true;
						sheetObjects[0].CellEditable(i, 1) = true;
						sheetObjects[0].CellEditable(i, 2) = true;
						sheetObjects[0].CellEditable(i, 3) = true;
					}
				}

				break;

			case "run_combine":        //Combine 처리 서버호출
				formObj.f_cmd.value = MODIFY01;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0076GS.do", params);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComShowCodeMessage("BKG00166");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					
					if("Y" == ComGetEtcData(sXml, "pre_checking")){
						comBkgCallPop0200(formObj.mst_bkg_no.value, "N");
					}
				} else {
	         		sheetObjects[0].LoadSearchXml(sXml);     
				}
				break;

			case "btn_container":        //컨테이너 목록 조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var param = "";
				var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
				var chkRow = chkRowArr.split("|");
				param  = "?bkg_no="+sheetObj.CellValue(chkRow[0], "bkg_no");
				ComOpenWindowCenter("/hanjin/ESM_BKG_0732.do" + param, "PopupEsmBkg0076", 700, 500, false);

				break;

			case "btn_cancel":        //Booking 취소
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var sMsg = ComGetMsg("BKG00359");
				if(ComShowConfirm(sMsg)){
					formObj.f_cmd.value = MODIFY02;
					var params = FormQueryString(formObj);
					params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0076GS.do", params);
					if(ComGetEtcData(sXml, "isSuccess") == "Y"){
						ComShowCodeMessage("BKG00590");
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
    			if ( formObj.search_gbn[0].checked ) {
    				if ( sheetObj.RowCount < 1 ) {
    					ComShowCodeMessage('BKG00104');
    					return false;
    				}
    			} else {
    				// by route
    				if( formObj.vvd.value == "" ){
    					ComShowCodeMessage('BKG00104');
    					formObj.vvd.focus();
    					return false;
    				} else if ( formObj.vvd.value.length < 9 ) {
    					ComShowCodeMessage('BKG00007');
    					formObj.vvd.focus();
    					return false;
    				}
    				if( formObj.hitchment_yn.checked == false && formObj.pol_cd.value == "" ){
    					ComShowCodeMessage('BKG00104');
    					formObj.pol_cd.focus();
    					return false;
    				}
    				if( formObj.pod_cd.value == "" ){
    					ComShowCodeMessage('BKG00104');
    					formObj.pod_cd.focus();
    					return false;
    				}
					if(!ComIsNull(formObj.cust_seq)){
						if(!ComIsNumber(formObj.cust_seq)){
				 			ComShowCodeMessage("BKG00340");
							formObj.cust_seq.focus();
							return false;
						}
					}
    			}
    			break;

    		case "btn_combine":
    			var param = "";
    			var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
    			var chkRow = chkRowArr.split("|");
    			var bdrBkgList = "";

    			if ( sheetObj.CheckedRows("slct_flg") > 1 ) {
    				var bkgNo = sheetObj.CellValue(chkRow[0], "bkg_no").substring(0, 3);
    				var shCd  = sheetObj.CellValue(chkRow[0], "cust_cd");
    				var vvdCd = sheetObj.CellValue(chkRow[0], "vvd");
    				var porCd = sheetObj.CellValue(chkRow[0], "por_cd");
    				var polCd = sheetObj.CellValue(chkRow[0], "pol_cd");
    				var podCd = sheetObj.CellValue(chkRow[0], "pod_cd");
    				var delCd = sheetObj.CellValue(chkRow[0], "del_cd");
    				var porNodCd = sheetObj.CellValue(chkRow[0], "por_nod_cd");
    				var delNodCd = sheetObj.CellValue(chkRow[0], "del_nod_cd");
    				var porCntCd = sheetObj.CellValue(chkRow[0], "por_cd").substring(0, 2);
    				var polCntCd = sheetObj.CellValue(chkRow[0], "pol_cd").substring(0, 2);
    				var broker   = sheetObj.CellValue(chkRow[0], "broker");
    				var bkgOfcCd = sheetObj.CellValue(chkRow[0], "bkg_ofc_no");
    				
    				for (var idx=0;idx<chkRow.length-1;idx++) {
						if (ComIsEmpty(sheetObj.CellValue(chkRow[idx], "del_cd"))) {
    						ComShowMessage(msgs['BKG00012']);
    						return false;
    					}
						if (bkgOfcCd != sheetObj.CellValue(chkRow[idx], "bkg_ofc_no")) {
    						ComShowMessage(msgs['BKG00160']);
    						return false;
    					}
    					if (shCd != sheetObj.CellValue(chkRow[idx], "cust_cd")) {
    						ComShowMessage(msgs['BKG00157']);
    						return false;
    					}
    					if (vvdCd != sheetObj.CellValue(chkRow[idx], "vvd")) {
    						ComShowMessage(msgs['BKG00998']);
    						return false;
    					}
    					if (porCd != sheetObj.CellValue(chkRow[idx], "por_cd") 
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG00158']);
    						return false;
    					}
    					if (polCd != sheetObj.CellValue(chkRow[idx], "pol_cd") 
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG00997']);
    						return false;
    					}
    					if (podCd != sheetObj.CellValue(chkRow[idx], "pod_cd")) {
    						ComShowMessage(msgs['BKG03159']);
    						return false;
    					}
    					if (delCd != sheetObj.CellValue(chkRow[idx], "del_cd")) {
    						ComShowMessage(msgs['BKG00159']);
    						return false;
    					}
    					if (porNodCd != sheetObj.CellValue(chkRow[idx], "por_nod_cd") 
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG02014']);
    					}
    					if (delNodCd != sheetObj.CellValue(chkRow[idx], "del_nod_cd")) {
    						ComShowMessage(msgs['BKG02015']);
    					}
    					if(formObj.hitchment_yn.checked == true){
    						if (porCntCd != sheetObj.CellValue(chkRow[idx], "por_cd").substring(0, 2)) {
    							ComShowMessage(msgs['BKG02017']);
    							return false;
    						}
    						if (polCntCd != sheetObj.CellValue(chkRow[idx], "pol_cd").substring(0, 2)) {
    							ComShowMessage(msgs['BKG02044']);
    							return false;
    						}
    					}
    					if (broker != sheetObj.CellValue(chkRow[idx], "broker")) {
    						ComShowMessage(msgs['BKG02015']);
    						return false;
    					}
    					if(sheetObj.CellValue(chkRow[idx],"bdr_flg")=="Y"){
    						if(bdrBkgList ==""){
    							bdrBkgList = sheetObj.CellValue(chkRow[idx], "bkg_no");
    						} else {
    							bdrBkgList = bdrBkgList + ", " + sheetObj.CellValue(chkRow[idx], "bkg_no");
    						}
    					}
    					
    				}
    				if(bdrBkgList !=""){
    					if (!ComShowCodeConfirm("BKG02038", bdrBkgList)) {
            	    		return false;
    					} 
    				}
    			}
    			break;

    		case "btn_container":
    			if (sheetObj.CheckedRows("slct_flg") == 0) {
    				ComShowMessage(msgs['BKG00155']);
    				return false;
    			}
    			if (sheetObj.CheckedRows("slct_flg") > 1) {
    				ComShowMessage(msgs['BKG00362']);
    				return false;
    			}
    			break;

    		case "btn_cancel":
    			if (sheetObj.CheckedRows("slct_flg") == 0) {
    				ComShowMessage(msgs['BKG00155']);
    				return false;
    			}
    			for (var i=1;i<=sheetObj.RowCount;i++) {
    				if ( ComIsNull(sheetObj.CellValue(i, "bkg_sts_cd")) ) {
    					ComShowCodeMessage("BKG00048");
    					return false;
    				}
    			}
    			break;

    		}
    	}

    	return true;
    }
    function changeSearchGbn(){
		var formObj = document.form;
		if ( formObj.search_gbn[0].checked ) {
			changeRouteEnable("N");
			ComBtnEnable("btn_rowadd");
			ComBtnEnable("btn_rowdelete");
			formObj.hitchment_yn.disabled = false;
		} else {
			changeRouteEnable("Y");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			formObj.hitchment_yn.disabled = false;
		}
		sheetObjects[0].RemoveAll();
		ComClearObject(formObj.vvd);
		ComClearObject(formObj.pol_cd);
		ComClearObject(formObj.pol_nod_cd);
		ComClearObject(formObj.pod_cd);
		ComClearObject(formObj.pod_nod_cd);
		ComClearObject(formObj.del_cd);
		ComClearObject(formObj.del_nod_cd);
		ComClearObject(formObj.cust_cnt_cd);
		ComClearObject(formObj.cust_seq);
		ComClearObject(formObj.cust_nm);
		formObj.hitchment_yn.checked = false;
    }

	function changeRouteEnable(enableYn) {
		var formObj = document.form;
		var bg_color1 = (enableYn == "Y")?"#CCFFFD":"#E8E7EC";
		var bg_color2 = (enableYn == "Y")?"#FFFFFF":"#E8E7EC";
		var ro_yn = (enableYn == "Y")?false:true;
		formObj.vvd.style.background = bg_color1;
		formObj.pol_cd.style.background = bg_color1;
		formObj.pol_nod_cd.style.background = bg_color2;
		formObj.pod_cd.style.background = bg_color1;
		formObj.pod_nod_cd.style.background = bg_color2;
		formObj.del_cd.style.background = bg_color2;
		formObj.del_nod_cd.style.background = bg_color2;
		
		formObj.vvd.readOnly = ro_yn;
		formObj.pol_cd.readOnly = ro_yn;
		formObj.pol_nod_cd.readOnly = ro_yn;
		formObj.pod_cd.readOnly = ro_yn;
		formObj.pod_nod_cd.readOnly = ro_yn;
		formObj.del_cd.readOnly = ro_yn;
		formObj.del_nod_cd.readOnly = ro_yn;

	}

    function changeHitchGbn(){
		var formObj = document.form;
		if ( formObj.hitchment_yn.checked ) {
			if ( formObj.search_gbn[0].checked ){
				formObj.pol_cd.style.background = "#E8E7EC";
			} else {
				formObj.pol_cd.style.background = "#FFFFFF";
			}
		} else {
			if ( formObj.search_gbn[0].checked ){
				formObj.pol_cd.style.background = "#E8E7EC";
			} else {
				formObj.pol_cd.style.background = "#CCFFFD";
			}
		}
    }

//	function form1_blur(){
//		ComChkObjValid(event.srcElement);
//	}

   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

	function obj_keypress(){
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
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
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
//	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
   
    function comBkgCallPop0974(callback_func){
		if (sheetObjects[0].CheckedRows("slct_flg") > 1) {			
			var param = "";
			var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
 
			if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
				for(var idx=0;idx<chkRow.length-1;idx++) {
					if(idx == 0){
						param = "sheet1_ibflag=U&sheet1_bkg_no=" + sheetObjects[0].CellValue(chkRow[idx], "bkg_no")
			              	  +"&sheet1_bdr_flg=" + sheetObjects[0].CellValue(chkRow[idx], "bdr_flg");
					} else {
						param = param +"&sheet1_ibflag=U&sheet1_bkg_no=" + sheetObjects[0].CellValue(chkRow[idx], "bkg_no")
						              +"&sheet1_bdr_flg=" + sheetObjects[0].CellValue(chkRow[idx], "bdr_flg");
					}
				}
			}
			ComOpenPopup("/hanjin/ESM_BKG_0974.do?"+param, 800, 350, callback_func, "1,0,1,1,1", true);
		}
    }

    function callBack0974(rArray){
    	var formObj = document.form;
    	formObj.mst_bkg_no.value=rArray[0];

		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		var bdrFlg = "N";
		if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
			for(var idx=0;idx<chkRow.length-1;idx++) {
				if(sheetObjects[0].CellValue(chkRow[idx], "bdr_flg") == "Y"){
					bdrFlg="Y";
					break;
		    	}
			}
			if(bdrFlg=="Y"){
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.mst_bkg_no), "C");
		 		doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			} else {
				doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			}
		}
    }         
    
	/**
    * CA Reason 후속 처리 : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj = document.form;
          
    	//01. CA ReasonCd, Remark 입력정보 받아서,
    	var strRsnCd   = nullToBlank(arrPopupData[0][2]);
    	var strRemark  = nullToBlank(arrPopupData[0][3]);
        
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value  = strRsnCd;
        formObj.ca_remark.value  = strRemark;
    }
    