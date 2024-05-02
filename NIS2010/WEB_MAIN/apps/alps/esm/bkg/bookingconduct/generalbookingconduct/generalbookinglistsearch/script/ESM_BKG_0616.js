/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0616.js
*@FileTitle : Booking EDI Transmit to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
* 2011.07.28 정선용 [CHM-201112575-01] Forwarder Code table 추가/수정 (MYTPPM1, 301))
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
     * @class ESM_BKG_0616 : ESM_BKG_0616 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESM_BKG_0616() {
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

    		var sheetObject = null;
    		if (formObject.search_type[0].checked) {
    			sheetObject = sheetObjects[0];
    		} else {
    			sheetObject = sheetObjects[1];
    		}

            switch(srcName) {
			case "btn2_EDITransmit":
				//alert("brac_cd:"+ComGetObjValue(formObject.brac_cd));
				if(!validateForm(sheetObject,formObject,"btn2_EDITransmit")) {
					return false;
				}
				doActionIBSheet(sheetObject,document.form,"btn2_EDITransmit");
				break;

			case "btn2_CheckAll":
				if (sheetObject.RowCount == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				sheetObject.CheckAll(1) = 1;
				break;

			case "btn2_UncheckAll":
				if (sheetObject.RowCount == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				sheetObject.CheckAll(1) = 0;
				break;

			case "btn2_Save":
				doActionIBSheet(sheetObject,document.form,IBSAVE);
				break;

			case "btn1_Retrieve":
				doActionIBSheet(sheetObject,document.form,IBSEARCH);
				break;

			case "btn1_New":
				doActionIBSheet(sheetObject,document.form,IBCLEAR);
				ComClearObject(formObject.bkg_from_dt);
				ComClearObject(formObject.bkg_to_dt);
				break;

			case "btn1_DownExcel":
				doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
				break;

			case "btns_calendar":
				var cal = new ComCalendarFromTo();
				cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
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
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }

 	function initControl() {
 		var formObject = document.form;
 		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
 		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
 		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
 		axon_event.addListenerForm  ('beforedeactivate', 'bkg0616_obj_deactivate', formObject); //- 포커스 나갈때
 		axon_event.addListenerFormat('beforeactivate', 'bkg0616_activate', formObject); //- 포커스 들어갈때
 		axon_event.addListenerForm	('blur', 'form1_blur', formObject);
 	}
 	
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);
                    var HeadTitle1 = "|CHK|Seq.|Booking No.|ST|F/M|First VVD|ETB|Lane|POL|POL|FWDR CD|Voyage|CRN|UVI|BKG Date|BKG Staff|EDI Send Date|EDI Send ID|Export MRN No.|";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,				WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"slct_flg",			false,			"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bkg_no",			false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"bkg_sts_cd",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"f_m",				false,			"",		dfNone,			0,		false,		true);			
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"first_vvd",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"etb",				false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"lane",				false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pol_cd",			false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pol_yd_cd",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"my_fwrd_ref_cd",	false,			"",		dfNone,			0,		true,		true, 4);
		
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"my_fwrd_vsl_desc",	false,			"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"crn",				false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"uvi",				false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bkg_date",			false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"bkg_staff",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"send_date",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"send_usr_id",		false,			"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"bp_xmrn",			false,			"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"bkg_staff_nm");
		
					InitDataValid(0, "my_fwrd_ref_cd", vtEngUpOther, "1234567890 ");
					InitDataValid(0, "my_fwrd_vsl_desc", vtEngUpOther, "1234567890 ");
					sheetObj.FrozenCols = 4;

               }
                break;

            case 'sheet2':      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                   //전체 너비 설정
                    SheetWidth = 0;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
                    MergeSheet = msPrevColumnMerge;
//                    
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);
                    var HeadTitle1 = "|CHK|Seq|Booking No.|ST|F/M|FH|SP|T/VVD|VVD History|ETB|Lane|POL|POL|BKG Date|ACK|EDI Send Date|ACK Receive|EDI Send ID|Export MRN No.|Terminal Error Message|";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"slct_flg",		false,			"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bkg_no",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"bkg_sts_cd",	false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"f_m",			false,			"",		dfNone,		0,		false,		true);			
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"f_h",			false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"sp",			false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"t_vvd",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"vvd_history",	false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"etb",			false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"lane",			false,			"",		dfNone,		0,		false,		true);
		
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pol_cd",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"yd_cd",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bkg_date",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"ack",			false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"send_date",	false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"ack_date",		false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"send_usr_id",	false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"bp_xmrn",		false,			"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"tml_err_msg",	false,			"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"send_usr_nm");
		
					CountPosition = 1;
					sheetObj.FrozenCols = 4;
               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		case IBCLEAR:      //초기화
			ComClearObject(formObj.bkg_from_dt);
			ComClearObject(formObj.bkg_to_dt);
			ComClearObject(formObj.vvd);
			ComClearObject(formObj.pol_cd);
			ComClearObject(formObj.bkg_ofc_cd);
			ComClearObject(formObj.slan_cd);
			ComClearObject(formObj.bkg_no);
			ComClearObject(formObj.bkg_staff);
			ComClearObject(formObj.bkg_sts_cd);
			ComClearObject(formObj.edi_send_sts_cd);
			ComClearObject(formObj.ack);

			sheetObjects[0].ColHidden("my_fwrd_ref_cd") = true;
			sheetObjects[0].ColHidden("my_fwrd_vsl_desc") = true;
			sheetObjects[0].ColHidden("crn") = true;
			sheetObjects[0].ColHidden("uvi") = true;

			// 사용자의 Location Code에 따라 그리드와 조건을 정한다.
			if (formObj.usr_cnt_cd.value == "US" || formObj.usr_cnt_cd.value == "CA") {
				formObj.search_type[1].checked = true;
			} else {
				formObj.search_type[0].checked = true;
			}
			clickSearchType();

			formObj.brac_cd.selectedIndex = 1;
			formObj.bkg_from_dt.value = ComGetNowInfo();
			formObj.bkg_to_dt.value = ComGetNowInfo();
			sheetObj.RemoveAll();
		break;

		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
		
			ComClearSeparator(formObj.bkg_from_dt);
			ComAddSeparator(formObj.bkg_from_dt);
			ComClearSeparator(formObj.bkg_to_dt);
			ComAddSeparator(formObj.bkg_to_dt);
			
			if (formObj.search_type[0].checked) {
	        	formObj.f_cmd.value = SEARCH;

	        	if ( formObj.pol_cd.value == "MYPGU" || formObj.pol_cd.value == "MYTPP"  ) {
					sheetObj.ColHidden("my_fwrd_ref_cd") 	= false;
					sheetObj.ColHidden("my_fwrd_vsl_desc")	= false;
					sheetObj.ColHidden("crn")				= false;
					sheetObj.ColHidden("uvi") 				= true;
	        	} else if ( formObj.pol_cd.value.substring(0,2) == "GB" ) {
					sheetObj.ColHidden("my_fwrd_ref_cd") 	= true;
					sheetObj.ColHidden("my_fwrd_vsl_desc") 	= true;
					sheetObj.ColHidden("crn") 				= true;
					sheetObj.ColHidden("uvi") 				= false;
	        	} else {
					sheetObj.ColHidden("my_fwrd_ref_cd") 	= true;
					sheetObj.ColHidden("my_fwrd_ref_cd") 	= true;
					sheetObj.ColHidden("crn") 				= true;
					sheetObj.ColHidden("uvi")				= true;
	        	}
			} else {
		        formObj.f_cmd.value = SEARCH01;
			}

	  		sheetObj.WaitImageVisible=false;
			ComOpenWait(true);       			
        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0616GS.do", FormQueryString(formObj));
        	ComOpenWait(false);       			
        	
        	sheetObj.Redraw = false;
        	sheetObj.LoadSearchXml(sXml);
       		sheetObj.Redraw = true;

			for (var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++) {
//				if (formObj.search_type[0].checked) {
//					if(i>sheetObj.HeaderRows){
//						sheetObj.CellFontColor(i, "bkg_no") = sheetObj.RgbColor(0, 0, 255);
//					}
//				} else {
		       		if(i>sheetObj.HeaderRows){
		       			if(sheetObj.CellValue(i, "bkg_no") == sheetObj.CellValue(i - 1, "bkg_no")){
				       		sheetObj.CellFontColor(i, "bkg_no") = sheetObj.RgbColor(240, 240, 240);
//				       		sheetObj.CellFontColor(i, "bkg_no") = sheetObj.RgbColor(192,192,192);
//				       		sheetObj.RangeBackColor(i, 3, i, 3) = sheetObj.RgbColor(192,192,192);
		       			} else {
		       				sheetObj.CellFontColor(i, "bkg_no") = sheetObj.RgbColor(0, 0, 255);
		       			}		       				
		       		} else {
		       			sheetObj.CellFontColor(i, "bkg_no") = sheetObj.RgbColor(0, 0, 255);
		       		}
//		       	}
			}

			formObj.bkg_total.value = ComAddComma(ComGetEtcData(sXml, "bkgTotal"));
			formObj.crn.value 		= ComAddComma(ComGetEtcData(sXml, "crnTotal"));
			formObj.sent.value 		= ComAddComma(ComGetEtcData(sXml, "ediSent"));
			formObj.unsent.value 	= ComAddComma(ComGetEtcData(sXml, "ediUnSent"));
			formObj.ack_cnt.value 	= ComAddComma(ComGetEtcData(sXml, "ackRcv"));
			formObj.tml.value 		= ComAddComma(ComGetEtcData(sXml, "tmlErr"));			
			
//			if (formObj.search_type[0].checked) {
//				
//			} else {
//				sheetObj.SetMergeCell()
//			}
//			
		break;

		case IBSAVE:
			if(!validateForm(sheetObj,formObj,sAction)) {
			    return false;
			}
			ComOpenWait(true);       		
			formObj.f_cmd.value = MULTI;
			var params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"slct_flg"),"sheet1_");
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0616GS.do", params);
			ComOpenWait(false);       		
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComBkgSaveCompleted();
			} else {
				sheetObj.loadSaveXml(sXml);
			}
		break;

		case "btn2_EDITransmit":
			formObj.f_cmd.value = MULTI01;

			var chkRowArr = null;
			var chkRow = null;			
			var sheetObj = null;
			var strBkgNos = null;
			var arrBkgNos = null;
    		if (formObj.search_type[0].checked) {
    			sheetObj = sheetObjects[0];    			
    		} else {
    			sheetObj = sheetObjects[1];
    		}
    		
    		// bkg no 추출
			chkRowArr = sheetObj.FindCheckedRow("slct_flg");
			chkRow = chkRowArr.split("|");
			for (var idx = 0; idx < chkRow.length - 1; idx++) {
				if(idx == 0){
					strBkgNos = sheetObj.CellValue(chkRow[idx], "bkg_no");
				} else {
					strBkgNos = strBkgNos + "," + sheetObj.CellValue(chkRow[idx], "bkg_no");
				}
			}			
			arrBkgNos = strBkgNos.split(",");

			// bkg no 중복 제거
			for(var i = 0; i < arrBkgNos.length; i++){
				if(i == 0){
					strBkgNos = arrBkgNos[i];
				} else {
					if(strBkgNos.indexOf(arrBkgNos[i]) == -1){
						strBkgNos = strBkgNos + "," + arrBkgNos[i];
					}
				}
			}
			arrBkgNos = strBkgNos.split(",");
			
			// edi 전송
			var params = FormQueryString(formObj);
			var sXml = "";			
			for (var idx = 0; idx < arrBkgNos.length; idx++) {
				sXml = sheetObj.GetSaveXml("ESM_BKG_0616GS.do", params + "&sheet1_ibflag=U&sheet1_bkg_no="+ arrBkgNos[idx]);
				if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
					break;
				}
			}
			
			// 중복 제거전 로직			
//			chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
//			chkRow = chkRowArr.split("|");
//				for (var idx=0;idx<chkRow.length-1;idx++) {
//					bkgNo = sheetObjects[0].CellValue(chkRow[idx], "bkg_no");
//					sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0616GS.do", params + "&sheet1_ibflag=U&sheet1_bkg_no="+ bkgNo);
//					if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
//						break;
//					}
//				}
//    		} else {
//				chkRowArr = sheetObjects[1].FindCheckedRow("slct_flg");
//				chkRow = chkRowArr.split("|");
//
//				for (var idx=0;idx<chkRow.length-1;idx++) {
//					bkgNo = sheetObjects[1].CellValue(chkRow[idx], "bkg_no");
//					sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0616GS.do", params + "&sheet1_ibflag=U&&sheet1_bkg_no="+ bkgNo);
//					if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
//						break;
//					}
//				}    			
//    		}

    		// 기존 방식
//    		if (formObj.search_type[0].checked) {
//    			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"slct_flg"), "sheet1_");
//    		} else {
//    			params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false,true,"slct_flg"), "sheet1_");
//    		}
//			var sXml = sheetObj.GetSaveXml("ESM_BKG_0616GS.do", params);
			
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowCodeMessage("BKG00693");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}else {
				sheetObj.LoadSearchXml(sXml);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;

		case IBDOWNEXCEL:
			if (sheetObj.RowCount > 0) {
				sheetObj.SpeedDown2Excel(1);
			} else {
				ComShowMessage(msgs['BKG00155']);
			}
		break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result = false;
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:
    				if ( ComIsNull(formObj.bkg_no) ) {
    					if ( !ComIsNull(formObj.vvd) ) {
    						if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) ) {
    							result = true;
    						} else {
    							ComShowCodeMessage('BKG00104');
    						}
    						return result;
    					} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
    						if ( checkMendatoryDt(formObj)){
    							if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) ) {
    								result = true;
    							} else {
    								ComShowCodeMessage('BKG00104');
    							}
    						}
    					} else return result;
    				} else return true;
    	
    				break;
    	
    			case IBSAVE:
    				if (sheetObj.RowCount == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				if (sheetObj.CheckedRows("slct_flg") == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				result = true;
    				break;
    	
    			case "btn2_EDITransmit":
    				if (sheetObj.RowCount == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				if (sheetObj.CheckedRows("slct_flg") == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				result = true;
    				break;
    		}
        }
        return result;
    }

	function clickSearchType(){
		var formObj = document.form;
		if (formObj.search_type[0].checked) {
			sheetObjects[0].style.height=320;
			sheetObjects[0].SheetWidth=mainTable.clientWidth;
			sheetObjects[1].style.height=0;
			sheetObjects[1].SheetWidth=0;
			ComBtnEnable("btn2_Save");
		} else {
			sheetObjects[0].style.height=0;
			sheetObjects[0].SheetWidth=0;
			sheetObjects[1].style.height=320;
			sheetObjects[1].SheetWidth=mainTable.clientWidth;
			ComBtnDisable("btn2_Save");
		}
	}


	 /**
	 * 마우스 IN일때 
	 */
	function bkg0616_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}

	 /**
	 * 마우스 out일때 
	 */
	function bkg0616_deactivate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
				ComAddSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
				ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	
	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}

   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
    		if (formObj.search_type[0].checked) {
    			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    		} else {
    			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
    		}
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
	        case "engnum"://숫자+"영문대소"입력하기
		  	  	ComKeyOnlyAlphabet('num'); 
	        	break;    
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
//			formObj.bkg_from_dt.focus();
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
//			formObj.bkg_to_dt.focus();
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowMessage(msgs['BKG00112']);
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		}
		return true;
	}

	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
//			ComShowCodeMessage('BKG00104');
//			formObj.vvd.focus();
			return false;
		}
		return true;
	}

	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
//			ComShowCodeMessage('BKG00104');
//			formObj.pol_cd.focus();
			return false;
		}
		return true;
	}

	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
//			ComShowCodeMessage('BKG00104');
//			formObj.bkg_ofc_cd.focus();
			return false;
		}
		return true;
	}

    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
		if ( col == 3 ) {
			var param = "";
			var chkBkgNo = sheetObjects[0].CellValue(row, "bkg_no");
	
			if ( chkBkgNo != "" ) {
				//freezing 관련 작업
//				ComBkgCall0079(chkBkgNo);				
				comBkgCallPopBkgDetail(chkBkgNo);  
			}
		}
    }

    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet2_OnDblClick(sheetObj, row, col) {
		if ( col == 3 ) {
			var param = "";
			var chkBkgNo = sheetObjects[1].CellValue(row, "bkg_no");
	
			if ( chkBkgNo != "" ) {
				param  = "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObjects[1].CellValue(row, "bkg_no");
//				ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0616", 1005, 650, false);
				//freezing관련 수정
				comBkgCallPopBkgDetail(sheetObjects[1].CellValue(row, "bkg_no"));   
			}
		}
    }

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			ColFontUnderline("bkg_no") = true;
		}			
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			ColFontUnderline("bkg_no") = true;
		}			
	}
