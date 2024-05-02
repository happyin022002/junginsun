/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0614.js
*@FileTitle : Work With Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20 
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.20 전용진
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
* 2011.12.05 전성진 [] 튜닝 요소 반영 - 탭이 들어간 경우 mandatory 값 확인하는 로직에서 걸리지게 함 
* 2012.08.20 조정민 [CHM-201219641] Workwith Booking Inquiry 기능 추가 개발 요청
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
 * @class ESM_BKG_0614 : ESM_BKG_0614 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0614() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
//      var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
					break;

				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");
					ComClearObject(document.form.bkg_from_dt);
					ComClearObject(document.form.bkg_to_dt);
					ComClearObject(document.form.bkg_ofc_cd);
					ComClearObject(document.form.bkg_stf_cd);
					btn0614Control(true, "btn_Split");
					btn0614Control(true, "btn_Combine");   
					break;

				case "btn_DownExcel":
					if ( sheetObjects[0].TotalRows > 0 ) {
						doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL,"","");
					}
					break;
					
				case "btn_BookingMain":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BookingMain")) {
						return false;
					}
					var param = "";
					var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow = chkRowArr.split("|");
					if ( chkRowArr != "" ) {
						ComBkgCall0079(sheetObjects[0].CellValue(chkRow[0], "bkg_no")); 										
					}
					break;

				case "btn_BKGCopy":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BKGCopy")) {
						return false;
					}
					var param = "";
					var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow = chkRowArr.split("|");
//					if ( sheetObjects[0].CellValue(chkRow[0], "st") == "X" ) {
//						ComShowMessage(msgs['BKG00090']);
//						return;
//					} else if ( sheetObjects[0].CellValue(chkRow[0], "bdr") == "YES" ) {
//						ComShowMessage(msgs['BKG00091']);
//						return;
//					}
					if ( chkRowArr != "" ) {
						param  = "?bkg_no="+sheetObjects[0].CellValue(chkRow[0], "bkg_no");
						ComOpenWindowCenter("/hanjin/ESM_BKG_0077.do" + param, "PopupEsmBkg0614", 720, 730, false);
					}
					break;

				case "btn_BLCopy":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BLCopy")) {
						return false;
					}
					if (sheetObjects[0].CheckedRows("slct_flg") > 0) {
						ComOpenWindowCenter("/hanjin/ESM_BKG_0648.do?isPop=Y", "PopupEsmBkg0648", 500, 502, false);
					}
					break;

				case "btn_Split":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_Split")) {
						return false;
					}
					var param = "";
					var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow = chkRowArr.split("|");

					if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
						ComShowMessage(msgs['BKG00154']);
						return;
					}
					if ( chkRowArr != "" ) {
//			        	var sUrl = "/hanjin/alpsMain.screen";
//			        	sUrl += "?parentPgmNo=ESM_BKG_M001";
//			        	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0099.do";
//			        	sUrl += "&pgmNo=ESM_BKG_0099";
//			        	sUrl += "&bkg_no="+sheetObjects[0].CellValue(chkRow[0], "bkg_no");
//			        	ComOpenWindowCenter(sUrl, "ESM_BKG_0099", 1024, 750, false);
						var params = "?bkg_no="+sheetObjects[0].CellValue(chkRow[0], "bkg_no")+"&popUpFlag=Y";
						params += "&pgmNo=ESM_BKG_0099";  
						ComOpenPopup("/hanjin/ESM_BKG_0099.do" + params, 1024, 700, "", "0,1,1,1,1", false);
			        }
					break;

				case "btn_Combine":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_Combine")) {
						return false;
					}
					comBkgCallPop0974('callBack0974');
					break;

				case "btn_BLPrint":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BLPrint")) {
						return false;
					}
					var param = bkgNos = "";
					var arrRow = ComFindText(sheetObjects[0], "slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							bkgNos += sheetObjects[0].CellValue(arrRow[i],"bkg_no")+",";
						}
						if (0<bkgNos.indexOf(",")) bkgNos = bkgNos.substring(0,bkgNos.length-1);
					} else {
    					ComShowCodeMessage("COM12176");
						return false;
					}
					param  = "?bkg_no="+bkgNos;
					ComOpenWindowCenter("/hanjin/ESM_BKG_0743_01.do"+param, "PopupEsmBkg074301", 900, 370, false);
					break;

				case "btns_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
					break;
					
				case "btn_ComEns041Pop": // com customer pop-up
					var custCntCd = formObject.cust_cnt_cd.value;
					var custSeq = formObject.cust_seq.value;
					var custNm = formObject.cust_nm.value;
	        		ComOpenPopup("/hanjin/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+ custCntCd+custSeq+"&cust_nm="+custNm, 770, 440, "callBackComEns041", '0,1,1,1,1,1,1', true);
            } // end switch
    	} catch(e) {
    		if (e == "[object Error]") {
    			alert(e.description);
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
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
    function initCombo(comboObj) {
      	comboObj.MultiSelect = true;
//      	comboObj.UseCode = true;
      	comboObj.LineColor = "#ffffff";
      	comboObj.SetColAlign("left|left");
        comboObj.MultiSeparator = "|";	
        
        with (comboObj) {
     		if(id == "rtro_knd_cd"){
     			MultiSelect = true;
     		}
     	}
    }
    
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
   	    // IBMultiCombo초기화
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");
		initControl();	
		sheetObjects[0].AutoRowHeight = false;
		if(ComGetObjValue(document.form.isInquiry) == "Y"){
			setWorkDisableButton();
		}
    }

	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
		axon_event.addListenerForm('beforedeactivate', 'bkg0614_obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',   'bkg0614_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
					style.height = 320;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					
					var HeadTitle1 = "|Sel.|Seq.|Booking No.|Filer Code|Filer Code|Shipper|Lane|T/VVD|CNTR Vol|ETB|POR|POL|POL|T/S Port|T/S Port|T/S Port|T/S Port|POD|POD|DEL|DEL|ST|R|D|BDR|Special|Special|Special|Special|Special|Special|S/I|Via|Via";
							HeadTitle1 += "|Forwarder|Consignee / Notify|Customer Ref No.|C/OFC|C/Rep.|L/OFC|L/Rep.|Commodity|Commodity|Contract|OFT Change\nafter PCT|VGM Cut-off Time|External Remark|Weight|Unit|S/Rep Name|Commodity DESC|Cntr Vol|SHIPPER|POR NODE|BROKER|BKG OFC";
					var HeadTitle2 = "|Sel.|Seq.|Booking No.|US|CA|Shipper|Lane|T/VVD|CNTR Vol|ETB|POR|POL|POL|Pre|Pre|Port|Port|POD|POD|DEL|DEL|ST|R|D|BDR|DG|RF|AK|BB|RD|HG|S/I|BKG|S/I";
							HeadTitle2 += "|Forwarder|Consignee / Notify|Customer Ref No.|C/OFC|C/Rep.|L/OFC|L/Rep.|Commodity|Commodity|Contract|OFT Change\nafter PCT|VGM Cut-off Time|External Remark|Weight|Unit|S/Rep Name|Commodity DESC|Cntr Vol|SHIPPER|POR NODE|BROKER|BKG OFC";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					
					SetMergeCell(0,10,2,2);
 					SetMergeCell(0,16,2,2);
 					SetMergeCell(0,18,2,2);
 					SetMergeCell(0,40,2,2);
 					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 60,  daCenter, true,  "ibflag"       );
                    InitDataProperty(0, cnt++, dtCheckBox,     40,  daCenter, true,  "slct_flg",    false, "", dfNone, 0, true,  true, 0, true, false, "", 1);
                    InitDataProperty(0, cnt++, dtSeq,          40,  daCenter, true,  "seq"          );
                    InitDataProperty(0, cnt++, dtData,         90,  daLeft,   true,  "bkg_no",      false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "us_file_cd",  false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "ca_file_cd",  false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true,  "shipper",     false, "", dfNone, 0, false, true);

                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "lane",        false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter, true,  "tvvd",        false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daLeft,   true,  "cntr_vol",    false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,        100,  daLeft,   true,  "vps_etb_dt",  false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "por",         false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pol",         false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         20,  daCenter, true,  "pol_nod_cd",  false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pre_loc",     false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         20,  daCenter, true,  "pre_yd",      false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pst_loc",     false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         20,  daCenter, true,  "pst_yd",      false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pod",         false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         20,  daCenter, true,  "pod_nod_cd",  false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "del",         false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         20,  daCenter, false, "del_nod_cd",  false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "st",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "r",           false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "d",           false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "bdr",         false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "dg",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "rf",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "awk",         false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "bb",          false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "rd",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         22,  daCenter, true,  "hg",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         25,  daCenter, true,  "si",          false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "bkg_via",     false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "si_via",      false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true,  "forwarder",   false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true,  "cn_nt",       false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         110, daCenter, true,  "cust_ref_no", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "c_ofc",       false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "c_rep",       false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "sales_ofc",   false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "srep_cd",     false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "rep_cmdt",    false, "", dfNone, 0, false, true);
                    
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true,  "cmdt",        false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         70,  daLeft,   true,  "sc_rfa",      false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         85,  daLeft,   true,  "rtro_knd_cd", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         120, daCenter, true,  "sys_set_dt_desc", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true,  "ext_rmk", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daLeft,   true,  "wgt", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtData,         50,  daLeft,   true,  "wgt_ut_cd", false, "", dfNone, 0, false, true);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "srep_nm"      );
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "cmdt_nm"      );
                    
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "cntr_vol_tot" );
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "shipper_code" );
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "por_nod_cd" 	);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "broker" 		);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daLeft,   false, "bkg_ofc_cd"	);

                    CountPosition = 2;
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
	    sheetObj.ShowDebugMsg = false;	
	    switch(sAction) {	
		    case IBCLEAR:      //조회		  
//			 	formObj.f_cmd.value = INIT;
//			  	var sXml = sheetObj.GetSaveXml("ESM_BKG_0614GS.do", FormQueryString(formObj));
		    	var sXml = formObj.sXml.value;
				var arrXml = sXml.split("|$$|");  
				// Combo 셋팅
				if (arrXml.length > 0){	// BKG Via
					ComBkgXml2ComboItem2(arrXml[0], comboObjects[0], "val", "name");				
				}             		
				if (arrXml.length > 1){	// S/I Via
					ComBkgXml2ComboItem2(arrXml[1], comboObjects[1], "val", "name");		
				}   
				if (arrXml.length > 2){	// E/Q Type
					ComBkgXml2ComboItem2(arrXml[2], comboObjects[2], "val", "name");		
				}   
				if (arrXml.length > 3){	// OTF Type
					ComBkgXml2ComboItem2(arrXml[3], comboObjects[3], "val", "name");		
				}   
			    formObj.sXml.value = null;
				// Display T/S Port 정보 감추기
				sheetObj.ColHidden(12) = true;
				sheetObj.ColHidden(13) = true;
				sheetObj.ColHidden(14) = true;
				sheetObj.ColHidden(15) = true;
			
				ComClearObject(formObj.por_cd);
				ComClearObject(formObj.rf_flg);
				ComClearObject(formObj.bkg_via_cd);
				ComClearObject(formObj.cust_nm);
				ComClearObject(formObj.rd_cgo_flg);
				ComClearObject(formObj.hngr_flg);
				ComClearObject(formObj.bdr_flg);
				ComClearObject(formObj.bkg_sts_cd);
				ComClearObject(formObj.srep_cd);
				ComClearObject(formObj.pol_cd);
				ComClearObject(formObj.si_via_cd);
				ComClearObject(formObj.bb_cgo_flg);
				ComClearObject(formObj.sls_ofc_cd);
				ComClearObject(formObj.dcgo_flg);
				ComClearObject(formObj.bkg_cust_tp_cd);
				ComClearObject(formObj.si_cd);
				ComClearObject(formObj.bkg_ofc_cd);
				ComClearObject(formObj.cust_ref_no);
				ComClearObject(formObj.ts_port);
				ComClearObject(formObj.awk_cgo_flg);
				ComClearObject(formObj.del_cd);
				ComClearObject(formObj.cust_seq);
				ComClearObject(formObj.pod_cd);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.bkg_stf_cd);
				ComClearObject(formObj.cust_ref_tp_cd);
				ComClearObject(formObj.bkg_no);
				ComClearObject(formObj.sc_rfa_no);
				ComClearObject(formObj.pol_yd_cd);
				ComClearObject(formObj.pod_yd_cd);
				ComClearObject(formObj.dlv_ctnt_cd);				
				ComClearObject(formObj.eq_tp_sz_cd);
				ComClearObject(formObj.spot_guide_flg);
				ComClearObject(formObj.rtro_knd_cd);
				
				
				formObj.date_gbn[0].checked = true;
				formObj.sc_rfa_gbn[0].checked = true;
				formObj.bkg_from_dt.value = ComGetNowInfo();
				formObj.bkg_to_dt.value = ComGetNowInfo();
				formObj.bkg_ofc_cd.value = userOfc_cd;
				formObj.bkg_stf_cd.value = userId;
				formObj.bkg_cust_tp_cd.selectedIndex = 1;
				formObj.non_rt_sts_cd.selectedIndex = 0;
				formObj.aloc_sts_cd.selectedIndex = 0;
				sheetObj.RemoveAll();
			
				sheetObj.HeadCheck(0, 1) = true;
				sheetObj.HeadCheck(1, 1) = true;
				break;
		
		    case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
		    
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
			   	formObj.f_cmd.value = SEARCH;
			   	sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj), "page_no=1", false);
				ComOpenWait(false);
		
				for (var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++) {
					sheetObjects[0].CellFontColor(i, 3) = sheetObjects[0].RgbColor(0, 0, 255);
				}
				
				sheetObj.SelectCell(0,0,false);
		        break;
		        
		    case "run_combine":        //Combine 처리 서버호출
				formObj.f_cmd.value = MODIFY01;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0614GS.do", params);
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
		
//			case IBSEARCHAPPEND:
//				sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj),"page_no=" + PageNo , false);
//		    	break;
		
		    case IBDOWNEXCEL:
		    	sheetObj.SpeedDown2Excel(1);
		//           	formObj.f_cmd.value = SEARCH;
		//           	ComOpenWait(true,true);
		//           	sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj) + "&excel_flg=Y"  );
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
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if(!ComIsNull(formObj.cust_seq)){
						if(!ComIsNumber(formObj.cust_seq)){
				 			ComShowCodeMessage("BKG00340");
							formObj.cust_seq.focus();
							return false;
						}
					}
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
						return false;
					}		
					if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 1) {
						if((formObj.vvd.value == "" || ComIsNull(formObj.vvd)) 
								&& (formObj.pol_cd.value == "" || ComIsNull(formObj.pol_cd)) 
								&& (formObj.pod_cd.value == "" || ComIsNull(formObj.pod_cd))
								&& (formObj.por_cd.value == "" || ComIsNull(formObj.por_cd)) 
								&& (formObj.del_cd.value == "" || ComIsNull(formObj.del_cd)) 
								&& (ComGetObjValue(formObj.dlv_ctnt_cd) == "All" || ComGetObjValue(formObj.dlv_ctnt_cd) == null || ComGetObjValue(formObj.dlv_ctnt_cd) == "")
								&& (ComGetObjValue(formObj.bkg_sts_cd)  == "All" || ComGetObjValue(formObj.bkg_sts_cd)  == null || ComGetObjValue(formObj.bkg_sts_cd)  == "")
								&& (formObj.bkg_ofc_cd.value == "" || ComIsNull(formObj.bkg_ofc_cd)) 
								&& (formObj.bkg_stf_cd.value == "" || ComIsNull(formObj.bkg_stf_cd))
								&& (formObj.sls_ofc_cd.value == "" || ComIsNull(formObj.sls_ofc_cd))
								&& (formObj.srep_cd.value    == "" || ComIsNull(formObj.srep_cd))
								&& formObj.dcgo_flg.checked 	== false
								&& formObj.rf_flg.checked 		== false
								&& formObj.awk_cgo_flg.checked 	== false
								&& formObj.bb_cgo_flg.checked 	== false
								&& formObj.rd_cgo_flg.checked 	== false
								&& formObj.hngr_flg.checked 	== false
								&& (formObj.bkg_no.value       == "" || ComIsNull(formObj.bkg_no)) 
								&& (formObj.cust_cnt_cd.value  == "" || ComIsNull(formObj.cust_cnt_cd))
								&& (formObj.cust_seq.value     == "" || ComIsNull(formObj.cust_cnt_seq)) 
								&& (formObj.cust_nm.value      == "" || ComIsNull(formObj.cust_nm)) 	
								&& (ComGetObjValue(formObj.cust_ref_tp_cd) == "All" || ComGetObjValue(formObj.cust_ref_tp_cd) == null || ComGetObjValue(formObj.cust_ref_tp_cd) == "")
								&& (formObj.cust_ref_no.value == "" || ComIsNull(formObj.cust_ref_no))
								&& (formObj.sc_rfa_no.value   == "" || ComIsNull(formObj.sc_rfa_no))
								&& (ComGetObjValue(formObj.bdr_flg)    == "All" || ComGetObjValue(formObj.bdr_flg) == null || ComGetObjValue(formObj.bdr_flg) == "") 
								&& (ComGetObjValue(formObj.si_cd)      == "All" || ComGetObjValue(formObj.si_cd)   == null || ComGetObjValue(formObj.si_cd)   == "")
								&& (ComGetObjValue(formObj.bkg_via_cd) == "" || ComGetObjValue(formObj.bkg_via_cd) == null)
								&& (ComGetObjValue(formObj.si_via_cd)  == "" || ComGetObjValue(formObj.si_via_cd) == null)
								&& (ComGetObjValue(formObj.eq_tp_sz_cd)  == "" || ComGetObjValue(formObj.eq_tp_sz_cd) == null)
								&& (ComGetObjValue(formObj.rtro_knd_cd)  == "" || ComGetObjValue(formObj.rtro_knd_cd) == null)
								){
							ComShowCodeMessage( "BKG00104", "at least one optional item");
							return false;		
						}
					}
					return true;
					break;
		
				case IBDOWNEXCEL:
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
		
				case "btn_BookingMain":
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
		
				case "btn_BKGCopy":
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
		
				case "btn_BLCopy":
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
		
				case "btn_Split":
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
		
				case "btn_BLPrint":
					result = checkMendatoryDt(formObj);
					if (!result) result = checkMendatoryVVD(formObj);
					if (!result) result = checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\n\tDate or\n\tVVD or\n\tBooking No.\n");
					}
					return result;
					break;
				
				case "btn_Combine":
					var param = "";
					var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
					var chkRow = chkRowArr.split("|");
					var bdrBkgList = "";
		
					if ( sheetObj.CheckedRows("slct_flg") > 1 ) {
						var bkgNo = sheetObj.CellValue(chkRow[0], "bkg_no").substring(0, 3);
						var shCd  = sheetObj.CellValue(chkRow[0], "shipper_code");
						var vvdCd  = sheetObj.CellValue(chkRow[0], "tvvd");
						var porCd = sheetObj.CellValue(chkRow[0], "por");
						var polCd = sheetObj.CellValue(chkRow[0], "pol");
						var podCd = sheetObj.CellValue(chkRow[0], "pod");
						var delCd = sheetObj.CellValue(chkRow[0], "del");
						var porNodCd = sheetObj.CellValue(chkRow[0], "por_nod_cd");
						var delNodCd = sheetObj.CellValue(chkRow[0], "del_nod_cd");
						var broker   = sheetObj.CellValue(chkRow[0], "broker");
	    				var bkgOfcCd = sheetObj.CellValue(chkRow[0], "bkg_ofc_no");						
		
						for (var idx=0;idx<chkRow.length-1;idx++) {
							if (bkgOfcCd != sheetObj.CellValue(chkRow[idx], "bkg_ofc_no")) {
	    						ComShowMessage(msgs['BKG00160']);
	    						return false;
							}
							if (shCd != sheetObj.CellValue(chkRow[idx], "shipper_code")) {
								ComShowMessage(msgs['BKG00157']);
								return false;
							}
							if (vvdCd != sheetObj.CellValue(chkRow[idx], "tvvd")) {
								ComShowMessage(msgs['BKG00998']);
								return false;
							}
							if (porCd != sheetObj.CellValue(chkRow[idx], "por")) {
								ComShowMessage(msgs['BKG00158']);
								return false;
							}
							if (polCd != sheetObj.CellValue(chkRow[idx], "pol")) {
								ComShowMessage(msgs['BKG00997']);
								return false;
							}
							if (podCd != sheetObj.CellValue(chkRow[idx], "pod")) {
								ComShowMessage(msgs['BKG03159']);
								return false;
							} 
							if (delCd != sheetObj.CellValue(chkRow[idx], "del")) {
								ComShowMessage(msgs['BKG00159']);
								return false;
							}
							if (porNodCd != sheetObj.CellValue(chkRow[idx], "por_nod_cd")) {
								ComShowMessage(msgs['BKG02014']);
							}
							if (delNodCd != sheetObj.CellValue(chkRow[idx], "del_nod_cd")) {
								ComShowMessage(msgs['BKG02015']);
							}
							if (broker != sheetObj.CellValue(chkRow[idx], "broker")) {
								ComShowMessage(msgs['BKG02015']);
								return false;
							}
							if(sheetObj.CellValue(chkRow[idx],"bdr")=="YES"){
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
	
			}
		}	
        return true;
    }

    /**
     * Display T/S Port 선택하거나 해제하는 경우 Port 정보가 나오도록 한다.
     * @return
     */
    function showTsPortInfo() {
    	var sheetObj = sheetObjects[0];

    	if ( document.form.ts_port.checked ) {
			sheetObj.ColHidden(12) = false;
			sheetObj.ColHidden(13) = false;
			sheetObj.ColHidden(14) = false;
			sheetObj.ColHidden(15) = false;
		} else {
			sheetObj.ColHidden(12) = true;
			sheetObj.ColHidden(13) = true;
			sheetObj.ColHidden(14) = true;
			sheetObj.ColHidden(15) = true;
		}
    }

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColFontUnderline("bkg_no")   = true;
		sheetObj.ColFontUnderline("srep_cd")  = true;
		sheetObj.ColFontUnderline("rep_cmdt") = true;
		sheetObj.ColFontUnderline("cmdt")     = true;
		for(var i = 2; i<=sheetObj.RowCount;i++){
			sheetObj.CellFontColor(i, "dg")  = getSpclCgoColor(sheetObj, sheetObj.CellValue(i, "dg"));
			sheetObj.CellFontColor(i, "rf")  = getSpclCgoColor(sheetObj, sheetObj.CellValue(i, "rf"));
			sheetObj.CellFontColor(i, "awk") = getSpclCgoColor(sheetObj, sheetObj.CellValue(i, "awk"));
			sheetObj.CellFontColor(i, "bb")  = getSpclCgoColor(sheetObj, sheetObj.CellValue(i, "bb"));
		}
	}	
	
	function getSpclCgoColor(sheetObj, aproDspCd){
//		A:APPROVE -> Blue
//		N:REJECT  -> Red
// 		P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST -> black
		if(aproDspCd=="A"){
			return sheetObj.RgbColor(0, 0, 255);
		} else if(aproDspCd=="N"){ 
			return sheetObj.RgbColor(255, 0, 0);
		} else {
			return sheetObj.RgbColor(0, 0, 0);
		}
	}
	
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			var colName = ColSaveName(MouseCol);
			if ("srep_cd" == colName) {
				MousePointer = "Hand";
				sText = CellText(Row,"srep_nm");
				MouseToolTipText = sText;
			} else if ("cmdt" == colName) {
			  MousePointer = "Hand";
				sText = CellText(Row,"cmdt_nm");
				MouseToolTipText = sText;
//			} else if ("cntr_vol" == colName) {
//			    MousePointer = "Hand";
//				sText = CellText(Row,"cntr_vol_tot");
//				MouseToolTipText = sText;
			} else {
				MouseToolTipText = "";
			}
		}
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
				if(ComGetObjValue(document.form.isInquiry) == "Y"){
					comBkgCallPopBkgDetail(chkBkgNo); 
				}else
					ComBkgCall0079(chkBkgNo);				  
			}
		}
    }

	function bkg0614_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				event.srcElement.onfocus = new Function("this.select()");
				break;
		}
	}
	
    function bkg0614_obj_deactivate(){
    	switch(event.srcElement.name){
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "cust_seq":
	    		if ( event.srcElement.value != '' && event.srcElement.value.length < 6 ) {
	    			var fillZero = "";
	    			for (var i=0;i<(6-event.srcElement.value.length);i++) {
	    				fillZero += "0";
	    			}
	    			event.srcElement.value = fillZero + event.srcElement.value;
	    		}
    			break;
    		default:
    			break; 
    	}
    }

	function form1_blur(){
		ComChkObjValid(event.srcElement,null,null,false);
	}

   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH,"page_no=1", false);
   		}
   	}
   	
	function checkMendatoryDt(formObj){
		if( formObj.bkg_from_dt.value == "" ){
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
			formObj.bkg_from_dt.focus();
			return false;
		}
		if( formObj.bkg_to_dt.value == "" ){
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
			formObj.bkg_to_dt.focus();
			return false;
		}
		if(!ComIsDate(formObj.bkg_from_dt.value)){
			ComShowCodeMessage( "BKG00651", formObj.bkg_from_dt.value);			
			return false;
		}
		if(!ComIsDate(formObj.bkg_to_dt.value)){
			ComShowCodeMessage( "BKG00651", formObj.bkg_to_dt.value);
			return false;
			
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowMessage(msgs['BKG00112']);
				return false;
			} 		
			if (ComGetDaysBetween(formObj.bkg_from_dt.value, formObj.bkg_to_dt.value)>31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		} 				
		return true;
	}

	function checkMendatoryVVD(formObj){
		if( ComIsEmpty(formObj.vvd.value)){
//			ComShowCodeMessage('BKG00104');
			formObj.vvd.focus();
			return false;
		}
		return true;
	}

	function checkMendatoryBkgNo(formObj){
		if( ComIsEmpty(formObj.bkg_no.value)){
//			ComShowCodeMessage('BKG00104');
			formObj.bkg_no.focus();
			return false;
		}
		return true;
	}
    	
   /**
    * Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBackComEns041(arrBal);
    * </pre>
    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
    * @return 없음
    * @author 류대영
    * @version 2010.05.06
    */    	
    function callBackComEns041(rArray){
  		var formObj = document.form;
   		if(rArray != null){
   			ComSetObjValue(formObj.cust_cnt_cd, rArray[0][3].substring(0,2));
   			ComSetObjValue(formObj.cust_seq, ComLpad(rArray[0][3].substring(2),6,"0"));
   			ComSetObjValue(formObj.cust_nm, rArray[0][4]);    		    			   			
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
			              	  +"&sheet1_bdr_flg=" + sheetObjects[0].CellValue(chkRow[idx], "bdr");
					} else {
						param = param +"&sheet1_ibflag=U&sheet1_bkg_no=" + sheetObjects[0].CellValue(chkRow[idx], "bkg_no")
						              +"&sheet1_bdr_flg=" + sheetObjects[0].CellValue(chkRow[idx], "bdr");
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
				if(sheetObjects[0].CellValue(chkRow[idx], "bdr") == "YES"){
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
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
     
    // Work with booking 화면 Button Control
    function btn0614Control(isEnable, btnName){
     	if(isEnable){
     		ComBtnEnable(btnName);
     	}else{
     		ComBtnDisable(btnName);
     	}
    }     
         
    function setWorkDisableButton(){    	 
    	 btn0614Control(false, "btn_BKGCopy");    	 
    	 btn0614Control(false, "btn_Split");
    	 btn0614Control(false, "btn_BLCopy");
    	 btn0614Control(false, "btn_Combine");
    	 btn0614Control(false, "btn_BLPrint");					
    }
    

    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	if(Col == 1){
			var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
			var isExistMemoBl = false;
			if ( chkRowArr != "" ) {
				for(var i = 0; i < chkRow.length - 1; i++){
		    		if(sheetObj.CellValue(chkRow[i], "st") == "S"){    	 
		    	    	btn0614Control(false, "btn_Split");
		    	    	btn0614Control(false, "btn_Combine");    		
		    	    	isExistMemoBl = true;
		    		}					
		    		if(sheetObj.CellValue(chkRow[i], "bkg_no").substring(10,11) == "9"){    	 
		    	    	btn0614Control(false, "btn_Split");
		    	    	btn0614Control(false, "btn_Combine");    		
		    	    	isExistMemoBl = true;
		    		}							    		
				}
			}
			if(!isExistMemoBl){ 	 
				btn0614Control(true, "btn_Split");
				btn0614Control(true, "btn_Combine");   	
			}
    	}
    }
    
    // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(bkgNo){
    	var formObj = document.form;
    	var bkg_no = formObj.bkg_no.value;
    	var _Width = '400';
		var _Height = '420';
//    	var newWin = window.showModalDialog("ESM_BKG_9457.do?bkg_no="+bkgNo, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
    	var newWin = ComOpenWindow("ESM_BKG_9457.do?bkg_no="+formObj.bkg_no.value, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
    }
    
    // Pop UP 에서 입력된 No 를 전달 받는다.
    function addValueNo(multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
    	if(multi_value != ''){
    		document.getElementById('bkg_no').value = multi_value;	
    	}
	}	