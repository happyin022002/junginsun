/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0095.js
*@FileTitle : Booking Fax & EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.16 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2012.06.21 조정민 [CHM-201218361] [삼성전자] BOKCON 재전송 기능 검토 요청
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
* 2012.08.28 조정민 [CHM-201219643] [BKG] Fax/EDI => EDIT VVD 기능 관련 보완 요청
* 2013.05.27 최문환 [CHM-201324826] BKG receipt 리마크 하드코딩 제거 요청 (POL 영국일 경우)
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
     * @class ESM_BKG_0095 : ESM_BKG_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0095() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject1 = sheetObjects[0];
	         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

//    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
			
			case "btn_RemarkTemplate":
				if(!validateForm(sheetObjects[0],formObject,"btn_RemarkTemplate")) {
					return false;
				}
				//comBkgCallPop0384('callBack0384');
		        ComOpenPopup("ESM_BKG_0384POP.do?pgmNo=ESM_BKG_0384", 620, 440, "callBack0384","1,0,0,0,1,1", true);
			break;

			case "btn_Remark":
				if(!validateForm(sheetObjects[0],formObject,"btn_Remark")) {
					return false;
				}
				var arrRow = ComFindText(sheetObjects[0],"slct_flg", 1);
				var rmk = "";
				if (arrRow && 0<arrRow.length) {
					rmk = 1==arrRow.length ? sheetObjects[0].CellValue(arrRow[0],"remark") : "";
				}
				formObject.elements["inter_rmk"].value = rmk;
				ComOpenWindow("ESM_BKG_0913.do?screen_id=0218","ESM_BKG_0913","dialogWidth:500px;dialogHeight:320px;toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=yes,alwaysRaised,dependent,titlebar=no",true);
				 
			break;
			

			case "btn_EditVVD":

				var vslCd = sheetObjects[0].CellValue(2,"vsl_cd");
				var skdVoyNo = sheetObjects[0].CellValue(2,"skd_voy_no");
				var skdDirCd = sheetObjects[0].CellValue(2,"skd_dir_cd");
				//open popup 
				var sUrl = "/hanjin/ESM_BKG_1150.do?vslCd="+vslCd+"&skdVoyNo="+skdVoyNo+"&skdDirCd="+skdDirCd;
				ComOpenPopup(sUrl, 500, 430, "", "0,0", true);
			
			break;

			
			case "btn_Preview":
				if(!validateForm(sheetObjects[0],formObject,"btn_Preview")) {
					return false;
				}
				rdOpen(rdObjects[0], formObject, "preview");
			break; 

			case "btn_FaxSend":
				if(!validateForm(sheetObjects[0],formObject,"btn_FaxSend")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_FaxSend");
			break; 

			case "btn_Email":
				if(!validateForm(sheetObjects[0],formObject,"btn_Email")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_Email");
			break; 

			case "btn_EmailEdit":
				if(!validateForm(sheetObjects[0],formObject,"btn_EmailEdit")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_EmailEdit");
			break;

			case "btn_EDITransmission":
				  var iCheckRow = sheetObjects[1].FindCheckedRow("slct_flg");
				  if(iCheckRow.length==0){
					  ComShowCodeMessage("BKG00155");
				  }else{
					  var arrRow = iCheckRow.split("|");
					  var arrRow2 = ComFindText(sheetObjects[1],"slct_flg2", 1);
					  var popFlag=false;
					  var popRcvId="";
					  if (arrRow && 0<arrRow.length) {
						  for (var idx=0; idx<arrRow.length-1; idx++) {
							if (sheetObjects[1].CellValue(arrRow[idx],"ntc_knd_cd")=="EX"){
								popFlag=true;
								popRcvId=sheetObjects[1].CellValue(arrRow[idx],"edi_receive_id");
								break;
							}
						  }
					  }
					  if (arrRow2 && 0<arrRow2.length) {
						  for (var idx=0; idx<arrRow2.length; idx++) {
						      sheetObjects[1].CellValue2(arrRow2[idx],"func_code") = "9";
						  }
					  }
					  if (popFlag){
						  var param="?pgmNo=ESM_BKG_0904&bkg_no="+ComGetObjValue(formObject.bkg_no);
						  param+="&pol_cd="+ComGetObjValue(formObject.pol_cd);
						  param+="&pgmNo=ESM_BKG_0904";
						  param+="&rcv_Id="+popRcvId;
						  ComOpenPopup("/hanjin/ESM_BKG_0904.do"+param, 500, 370, '','1,0,1,1,1', true);
					  }else{
						doActionIBSheet(sheetObjects[1],formObject,"btn_EDITransmission");	
					  }
				  }
			break; 
			case "btn_Yard":
				 var param="?pgmNo=ESM_BKG_0096&bkg_no="+ComGetObjValue(formObject.bkg_no);
				 param+="&callSheetIdx=2";
				 ComOpenPopup("/hanjin/ESM_BKG_0096.do"+param, 500, 400, '','1,0,1,1,1', true);
			break; 

			case "btn_Retrieve":
				reSearch();
			break; 

			case "btn_Close":
				window.close();
			break; 

            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
    	if (!opener) opener = window.dialogArguments;
        for(var i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		gridState(sheetObjects[0]);
		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
			ComSetDisplay("btn_FaxSend1", false);
		}
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
                    style.height = 185;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    RequestTimeOut = 30;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

                    var HeadTitle1 = "| |Document Kind|Fax|Fax|Fax|Fax|Fax|Fax|Freight|Freight|Freight|E-mail|E-mail|E-mail|E-mail|E-mail|E-mail|||||||||||";
                    var HeadTitle2 = "| |Document Kind|Fax No.|Fax No.|Sender|Send Date|Result|Result| | | |E-mail Address|E-mail Address|Sender|Send Date|Result|Result||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,				WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");

					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	"slct_flg",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	"ntc_knd_nm",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,	"fax_no",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtPopup,		20,		daCenter,	true,	"fax_no_btn",		false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"fax_sender",		false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"fax_send_dt",		false,	"",	dfUserFormat2,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"fax_send_result",	false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++,  dtPopup,        20,     daCenter,   true,	"fax_his_btn",		false,  "", dfNone,         0,  true,   true);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	"frt_term",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		20,		daCenter,	true,	"frt_clt_flg",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"display_hidden",	false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"eml",				false,	"",	dfNone,			0,	true,	true,	200);
					InitDataProperty(0, cnt++ , dtPopup,		20,		daCenter,	true,	"eml_btn",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"eml_sender",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"eml_send_dt",		false,	"",	dfUserFormat2,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"eml_send_result",	false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++,  dtPopup,        0,		daCenter,   true,	"eml_his_btn",		false,  "", dfNone,         0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"new_flg");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"ntc_knd_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"remark");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"enable");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"fax_sender_nm");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"eml_sender_nm");

					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"bkg_no");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"por_cd");

					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"skd_dir_cd");  

					InitUserFormat2(0, "fax_send_dt",  "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, "eml_send_dt",  "####-##-## ##:##", "-|:" );
					InitDataCombo(0, "frt_term", " |All Charge|Collect|Prepaid|No Charge|Arranged", " |ALL|C|P|N|A");

					PopupImage  =  "img/btns_multisearch.gif";
					ShowButtonImage = 1;
					ImageList(0) = "img/btns_plus.gif";
					ImageList(1) = "img/btns_minus.gif";
					ImageList(2) = "img/btns_multisearch.gif";
					//특정컬럼에 팝업버튼 이미지 변경
					PopupButtonImage(0, "fax_no_btn") = 0;
					PopupButtonImage(0, "eml_btn") = 0;

					CountPosition = 0;
					
               	}
                break;

            case 'sheet2':      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 225;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    RequestTimeOut = 30;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Sel.|EDI Kind|EDI Kind|Code|Code|Receiver(TP ID)|Group ID/Name|Group ID/Name|Sender|Last Sent Date|Result|Result|||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"slct_flg",				false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			120,daLeft,		true,	"ntc_knd_nm",			false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"slct_flg2",			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"ref_tp_cd",			false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		true,	"ref_code",				false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,daLeft,		true,	"edi_receive_id",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"group_edi_id",			false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			105,daLeft,		true,	"group_nm",				false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,daLeft,		true,	"sender",				false,	"",	dfNone,			0,	false,	true);

					InitDataProperty(0, cnt++ , dtData,			110,daCenter,	true,	"send_dt",				false,	"",	dfUserFormat2,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			67,	daCenter,	true,	"result",				false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++,  dtPopup,        16,	daCenter,   true,	"edi_his_btn",			false,  "", dfNone,         0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"bkg_ntc_snd_rslt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		false,	"bkg_no");

					InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		false,	"ntc_knd_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		false,	"sender_nm");
					InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		false,	"func_code");

					InitUserFormat2(0, "send_dt",  "####-##-## ##:##", "-|:" );

					PopupImage  =  "img/btns_multisearch.gif";
					ShowButtonImage = 1;
					ImageList(0) = "img/btns_multisearch.gif";
					PopupButtonImage(0, "edi_his_btn") = 0;

					CountPosition = 0;
                }
                break;
			  	case "sheet3"://0096의 sheet
					with (sheetObj) {

						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
	                    RequestTimeOut = 30;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 3, 100);

						var HeadTitle1 = "|TP/SZ|Q'ty|P/Up CY|Return CY";
						
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
														
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,	true,		"ibflag");
						InitDataProperty(0,		cnt++ , dtData,	    40,			daCenter,	true,		"cntr_tpsz_cd",     false,		"",		dfEngUpKey,				0,		true,		true,   2);
						InitDataProperty(0,		cnt++ , dtData,		80,			daCenter,	true,		"op_cntr_qty",		false,		"",		dfFloat,				2,		true,		true);
						InitDataProperty(0,		cnt++ , dtData,		140,		daCenter,	true,		"mty_pkup_yd_cd",    false,		"",		dfEngUpKey,				0,		true,		true,   7);
						InitDataProperty(0,		cnt++ , dtData,		120,		daCenter,	true,		"full_rtn_yd_cd",  	false,		"",		dfEngUpKey,				0,		true,		true,   7);
			  		}
				break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
//      sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		case IBSEARCH:      //조회
			var sXml = formObj.sXml.value;
        	var arrXml = sXml.split("|$$|");
        	for(var i = 0; i < arrXml.length; i++){ 
        		sheetObjects[i].Redraw = false;    
        		if(i > 0) {
        			sheetObjects[i].WaitImageVisible = false;	
        		}  
        		sheetObjects[i].LoadSearchXml(arrXml[i]); 
        		sheetObjects[i].Redraw = true; 
        	}
			freightEnabled(sheetObjects[0]);
			faxEnabled(sheetObjects[0]);
			noticeTypeEnabled(sheetObjects[0]);
			
	 		with(sheetObj){
	 			ColBackColor("RFQTY") = RgbColor(204, 255, 253);
	            for(i=1 ; i<=LastRow; i++) {
					if("Draft B/L"==CellValue(i, "ntc_knd_nm") 
							|| "N/N Copy"==CellValue(i, "ntc_knd_nm") 
							|| "Waybill"==CellValue(i, "ntc_knd_nm")
							|| "Revised Rate"==CellValue(i, "ntc_knd_nm")){
						if(0==GetComboInfo(i,"frt_term", "SelectedIndex")){
							CellText(i, "frt_term") = "All Charge";
						}
					}
					
					//CN186396에 대해서 기존 email 지정 주소가 없다면 아래 주소로 넣어줌
					//기존 지정 주소가 있어도 bl.hanjin.woox@infodis.net가 없으면 넣어줌
					if (document.form.opener_pgm.value=='ESM_BKG_0079_01'){
						var s_cust_cnt = opener.document.form.s_cust_cnt_cd.value;
						var s_cust_seq = opener.document.form.s_cust_seq.value;
						var f_cust_cnt = opener.document.form.f_cust_cnt_cd.value;
						var f_cust_seq = opener.document.form.f_cust_seq.value;
						var c_cust_cnt = opener.document.form.c_cust_cnt_cd.value;
						var c_cust_seq = opener.document.form.c_cust_seq.value;
						
						if(("CN"==s_cust_cnt && "186396"==s_cust_seq) ||("CN"==f_cust_cnt && "186396"==f_cust_seq)){
							if("Draft B/L"==CellValue(i, "ntc_knd_nm")&&""==CellValue(i, "eml")){
								CellValue2(i, "eml") = "bl.hanjin.woox@infodis.net";
							}else if("Draft B/L"==CellValue(i, "ntc_knd_nm")&&""!=CellValue(i, "eml")&& -1==CellValue(i, "eml").toLowerCase().indexOf("bl.hanjin.woox@infodis.net")){
								CellValue2(i, "eml") = CellValue(i, "eml")+";bl.hanjin.woox@infodis.net";
							}
						}
						
						if(("CN"==s_cust_cnt && "186396"==s_cust_seq) ||("CN"==f_cust_cnt && "186396"==f_cust_seq)){
							if("Waybill"==CellValue(i, "ntc_knd_nm")&&""==CellValue(i, "eml")){
								CellValue2(i, "eml") = "bl.hanjin.woox@infodis.net";
							}else if("Waybill"==CellValue(i, "ntc_knd_nm")&&""!=CellValue(i, "eml")&& -1==CellValue(i, "eml").toLowerCase().indexOf("bl.hanjin.woox@infodis.net")){
								CellValue2(i, "eml") = CellValue(i, "eml")+";bl.hanjin.woox@infodis.net";
							}
						}
					}
					
					
	            }
	 		}
		break;

		case "btn_FaxSend":
			formObj.f_cmd.value = MULTI01;
			
			var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
			
			var remarkArr = sheetObjects[0].CellValue(chkRow[0], "remark").split("\r\n");
			var remark="";
			 
			for(var idx=0;idx<remarkArr.length-1;idx++){
				remark = remark + remarkArr[idx] + "(##)";
			}
			remark = remark + remarkArr[remarkArr.length-1];
			remark = encodeRemark(remark);
			sheetObjects[0].CellValue(chkRow[0], "remark") = remark;

			var sXml = formObj.sXml.value;
			formObj.sXml.value = "";
			var params = FormQueryString(formObj);
			formObj.sXml.value = sXml;
			
			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
			sXml = sheetObj.GetSaveXml("ESM_BKG_0095GS.do", params);
			if (ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00496']);
				reSearch();
			} else {
				sheetObj.loadSaveXml(sXml);
			}
		break;

		case "btn_Email":
			formObj.f_cmd.value = MULTI02;

			var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");

			var emlArr = null;
			if(sheetObjects[0].CellValue(chkRow[0], "eml") != ""){
				emlArr = sheetObjects[0].CellValue(chkRow[0], "eml").split(";");
				for(var i = 0; i < emlArr.length; i++){
					if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
    					ComShowCodeMessage("BKG40021" , emlArr[i]);
    					return false;
					}
				}
            }
			var remarkArr = sheetObjects[0].CellValue(chkRow[0], "remark").split("\r\n");
			var remark="";
			for(var idx=0;idx<remarkArr.length-1;idx++){
				remark = remark + remarkArr[idx] + "(##)";
			}
			remark = remark + remarkArr[remarkArr.length-1];
			remark = encodeRemark(remark);
			sheetObjects[0].CellValue(chkRow[0], "remark") = remark;

			var sXml = formObj.sXml.value;
			formObj.sXml.value = "";
			var params = FormQueryString(formObj);
			formObj.sXml.value = sXml;
			
			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");

			sXml = sheetObj.GetSaveXml("ESM_BKG_0095GS.do", params);
			//sXml = GetSaveXml("ESM_BKG_0095GS.do", params);
			if (ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00497']);
				ComSetObjValue(formObj.elements["edt_ntc_knd_cd" ],"");
				ComSetObjValue(formObj.elements["edt_bkg_no_list"],"");
				ComSetObjValue(formObj.elements["edt_to_eml"     ],"");
				ComSetObjValue(formObj.elements["edt_cc_eml"     ],"");
				ComSetObjValue(formObj.elements["edt_from_eml"   ],"");
				ComSetObjValue(formObj.elements["edt_subject"    ],"");
				ComSetObjValue(formObj.elements["edt_contents"   ],"");
				reSearch();
			} else {
				sheetObj.loadSaveXml(sXml);
			}
		break;

		case "btn_EmailEdit":
			var arrRow = ComFindText(sheetObjects[0], "slct_flg", 1);
			var bkg_no = "";
			var ntc_knd_cd = "";
			var edt_to_eml = "";
			if (arrRow && 1==arrRow.length) {
				bkg_no = sheetObjects[0].CellValue(arrRow[0],"bkg_no");
				ntc_knd_cd = sheetObjects[0].CellValue(arrRow[0],"ntc_knd_cd");
				edt_to_eml = sheetObjects[0].CellValue(arrRow[0],"eml");
				ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0095&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 700, true);
			}
		break;

		case "btn_EDITransmission":
			formObj.f_cmd.value = MULTI03;
			
			var sXml = formObj.sXml.value;
			formObj.sXml.value = "";
			var params = FormQueryString(formObj);
			formObj.sXml.value = sXml;
			
			params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false, true, 1), "sheet2_");
			sXml = sheetObj.GetSaveXml("ESM_BKG_0095GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00693']);
				reSearch();
			} else {
				sheetObj.loadSaveXml(sXml);
			}
		break;
		

        }
    }
  
//    /**
//    * GetSaveXml 을 Ajax 로 직접 호출하도록 함수 개발 및 테스트
//    * FROM 송유성
//    */
//   var isXMLHttpRequest = false;
//   var xmlhttp = false;
//   function getHTTPObject() {
//   	if (! xmlhttp) {	
//   		try {
//   			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
//   		} catch (e) {
//   			try {
//   				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//   			} catch (E) {
//   				xmlhttp = false;
//   			}
//   		}
//   	
//   	    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
//   	        try {
//   	            xmlhttp = new XMLHttpRequest();
//   				isXMLHttpRequest = true;
//   	        } catch (e) {
//   	            xmlhttp = false;
//   	        }
//   	    }
//   	}
//       return xmlhttp;
//   }

//   function GetSaveXml(url,param) {
//   	var retxml = null;
//
//   	var xmlhttp = getHTTPObject();
//
//   	xmlhttp.open('POST', url+"?"+param,false);
//
//   	xmlhttp.onreadystatechange = function() {
//   		if(xmlhttp.readyState==4 && xmlhttp.status == 200 && xmlhttp.statusText=='OK') {
//   			retxml =  xmlhttp.responseText;
//   		}
//   	}
//   	xmlhttp.send(null);
//   	
//   	if (isXMLHttpRequest) {
//   		retxml =  xmlhttp.responseText;
//   	}
//   	return retxml;
//   }
//   /**
//    * 여기까지 Ajax 호출을 위한 테스트 함수
//    * FROM 송유성
//    */
   

	/*
	 * Sheet1 Freight 비활성 처리
	 */
	function freightEnabled(sheetObj){ 
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			if (sheetObj.CellValue(iRow, "ntc_knd_cd") == "BL" || sheetObj.CellValue(iRow, "ntc_knd_cd") == "WB" || sheetObj.CellValue(iRow, "ntc_knd_cd") == "NN"||sheetObj.CellValue(iRow, "ntc_knd_cd") == "RR"){
				sheetObj.CellEditable(iRow,"frt_term") = true;
				sheetObj.CellEditable(iRow,"frt_clt_flg") = true;
				if (""==sheetObj.CellValue(iRow,"frt_term")) {
					sheetObj.CellValue2(iRow,"frt_term") = "";
				}
			}
		}
	}
	
	/*
	 * Sheet1 Fax 비활성 처리
	 */
	function faxEnabled(sheetObj){ 
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			if (sheetObj.CellValue(iRow, "ntc_knd_cd") == "NN" || sheetObj.CellValue(iRow, "ntc_knd_cd") == "SN"){
				sheetObj.CellEditable(iRow,"fax_no") = false;
				sheetObj.CellEditable(iRow,"fax_no_btn") = false;
			}
		}
	}
	
	/*
	* Notice Type 별로 data에 따라 활성화 처리 
	*/
	function noticeTypeEnabled(sheetObj){ 
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			 if (sheetObj.CellValue(iRow, "enable") == "N"){
				 sheetObj.RowEditable(iRow)=false;
			 }
		}
	}


	/**
	* IBSheet Object에서 팝업을 클릭시
	*/
 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var formObject = document.form;
		var param = "";
		if (sheetObj.ColSaveName(Col) == "fax_no_btn" || sheetObj.ColSaveName(Col) == "eml_btn") {
			if ( sheetObj.CellValue(Row, "new_flg") == "Y" ) {
//				ComRowHideDelete(sheetObject,"checkbox");
				sheetObj.RowHidden(Row)= true;		//2.행 숨기기
				sheetObj.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			} else {
				//var Row = sheetObj.DataCopy();
				sheetObj.DataInsert();
				var Row =Row+1;
				sheetObj.RowStatus(Row) = "R";
				sheetObj.CellValue(Row, "ntc_knd_nm") = sheetObj.CellValue(Row-1, "ntc_knd_nm");
				sheetObj.CellValue(Row, "fax_sender") = sheetObj.CellValue(Row-1, "fax_sender");
				sheetObj.CellValue(Row, "frt_term") = sheetObj.CellValue(Row-1, "frt_term");
				sheetObj.CellValue(Row, "frt_clt_flg") = sheetObj.CellValue(Row-1, "frt_clt_flg");
				sheetObj.CellValue(Row, "display_hidden") = sheetObj.CellValue(Row-1, "display_hidden");
				sheetObj.CellValue(Row, "ntc_knd_cd") = sheetObj.CellValue(Row-1, "ntc_knd_cd");
				sheetObj.CellValue(Row, "remark") = sheetObj.CellValue(Row-1, "remark");
				sheetObj.CellValue(Row, "fax_no") = "";
				sheetObj.CellValue(Row, "eml") = "";
				sheetObj.CellValue(Row, "fax_no_btn") = "";
				sheetObj.CellValue(Row, "eml_btn") = "";
				sheetObj.CellValue(Row, "new_flg") = "Y";
				sheetObj.CellValue(Row, "fax_send_result") = "";
				sheetObj.CellValue(Row, "fax_send_dt") = "";
				sheetObj.CellValue(Row, "eml_send_result") = "";
				sheetObj.CellValue(Row, "eml_send_dt") = ""; 
				sheetObj.CellValue2(Row, "slct_flg")=0; 
				sheetObj.PopupButtonImage(Row, "fax_no_btn") = 1;
				sheetObj.PopupButtonImage(Row, "eml_btn") = 1;

			}
		} else if ("fax_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.CellValue(Row,"fax_send_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		} else if ("eml_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.CellValue(Row,"eml_send_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
 	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		if ("edi_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.CellValue(Row,"result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
 	function sheetMultiBtnClick(sheetObject, Row, Col) {
		var formObject = document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo = ComGetObjValue(formObject.bkg_no);
		ntcKndCd = sheetObject.CellValue(Row,"ntc_knd_cd");
 		if ("fax_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "F";
 		} else if ("eml_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "M";
 		} else if ("edi_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "E";
 		}
		ComOpenWindowCenter("/hanjin/ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, "ESM_BKG_1071", 800, 530, true);
 	}

    /**
     * Remark 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0384(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 전용진
     * @version 2009.10.06
     */
    function callBack0384(rArray){
    	var formObj = document.form;
    	if(rArray != null){
		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
			for (var idx=0;idx<chkRow.length-1;idx++) {
				sheetObjects[0].CellValue(chkRow[idx], "remark") = rArray[0][6];
			}
		}
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {
		case "btn_Preview":
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}

			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			break;

		case "btn_Remark":
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}

			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			break;

		 case "btn_RemarkTemplate":
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}

			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			break;

		case "btn_FaxSend":
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			break;

		case "btn_Email":
		case "btn_EmailEdit":
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			break;

		}
        }

        return true;
    }

 	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			ColBackColor("RFQTY") = RgbColor(204, 255, 253);
            for(i=1 ; i<=LastRow; i++) {
				if ("Failed"==CellValue(i,"fax_send_result")) {
					CellFontUnderline(i,"fax_send_result") = true;
				} else if ("Failed"==CellValue(i,"eml_send_result")) {
					CellFontUnderline(i,"eml_send_result") = true;
				}
				if (""!=CellValue(i,"fax_send_result")) {
					PopupButtonImage(i, "fax_his_btn") = 2;
				} else {
				    SetMergeCell(i,7,1,2);
				}
				if (""!=CellValue(i,"eml_send_result")) {
					PopupButtonImage(i, "eml_his_btn") = 2;
				} else {
                    SetMergeCell(i,16,1,2);
                }
            }
		}
	}

	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
            for(i=1 ; i<=LastRow; i++) {
            	if (ComIsNull(CellValue(i,"edi_receive_id"))) {
            		CellEditable(i,"slct_flg") = false;
            		CellEditable(i,"slct_flg2") = false;
            	}
            	if ("EX"==CellValue(i,"ntc_knd_cd") || "IM"==CellValue(i,"ntc_knd_cd") || "PS"==CellValue(i,"ntc_knd_cd")
            			|| "BO"==CellValue(i,"ntc_knd_cd") ) {
            		CellEditable(i,"slct_flg") = true;
            	}
            	if ("BL"!=CellValue(i,"ntc_knd_cd")) {
            		CellEditable(i,"slct_flg2") = false;
            	}
                if (!ComIsNull(CellValue(i,"result"))) {
					PopupButtonImage(i, "edi_his_btn") = 0;
                } else {
                    SetMergeCell(i,11,1,2);
                }
            }
		}
	}

	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
		Rdviewer.style.height = 0;

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.AutoAdjust = 0;
		Rdviewer.ZoomRatio  = 180; 
	}

	function rdOpen(rdObject, formObject, viewType){
		var sheetObj = sheetObjects[0];
		var Rdviewer = rdObject;

		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		 
		var remarkArr = sheetObj.CellValue(chkRow[0], "remark").split("\r\n");
		var remark="";
		for(var idx=0;idx<remarkArr.length-1;idx++){
			remark = remark + remarkArr[idx] + "(##)";
		}
		remark = remark + remarkArr[remarkArr.length-1];
		remark = encodeRemark(remark);
		
		var rdParam = "";
		var rdUrl = "";
		var rdFile = "";

		if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "BK" ) {

			rdParam = " /rv " + "BKG_NO['"+formObject.bkg_no.value+"'] USR_ID["+formObject.usr_id.value+"] O_PS["+encodeRemark(sheetObj.CellValue(chkRow[0], "remark"))+"]";
			formObject.com_mrdBodyTitle.value = "Booking Receipt Notice";
			rdUrl = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			if ( formObject.receipt_type.value == "China" ) {
				rdFile = "ESM_BKG_5005C.mrd";
				rdParam = rdParam + "[Y]";
			} else {
				rdFile = "ESM_BKG_5005G.mrd";
				rdParam = rdParam + "P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]";
			}
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";

		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "CN" ) {

			var strBkgNo = " bkg_no[( '" + formObject.bkg_no.value + "' )] ";
			var strRemark = " remark[" + encodeRemark(sheetObj.CellValue(chkRow[0], "remark")) + " ] ";
			var strIsEncode = " isEncode[Y] ";
			var strUsrId = " usr_id[" + formObject.usr_id.value + "] ";
			var strType ="type[detail]";
			formObject.com_mrdBodyTitle.value = "Empty Container Release Order";
			rdParam = "/rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;

			rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/emptyreleaseorder/report/";
			rdFile = "ESM_BKG_0861.mrd";

			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";

		//} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "BL" || sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "WB" ) {
		//	ComOpenWindow("/hanjin/ESM_BKG_0927.do?bkg_no=" + formObject.bkg_no.value, "PopupEsmBkg0927", "width=916, height=768, scrollbars=no", false);
		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "SN" ) {
			var strBkgNo = formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value = "Surrender Notice";
			rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
			rdFile = "ESM_BKG_0866.mrd";
			rdParam = "/rp ["+ strBkgNo + "] ["+formObject.signFlag.value+"]";
			
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";

		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "HO" ) {					
			var strBkgNo = formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value = "Carrier's Haulage Notice";
			rdUrl = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/transferorderissue/report/";
			rdFile = "ESM_BKG_5021.mrd";
			rdParam = "/rv BKG_NO['"+ strBkgNo + "'] IO_BND_CD['O'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']";
			
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "HI" ) {					
			var strBkgNo = formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value = "Carrier's Haulage Notice";
			rdUrl = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/transferorderissue/report/";
			rdFile = "ESM_BKG_5021.mrd";
			rdParam = "/rv BKG_NO['"+ strBkgNo + "'] IO_BND_CD['I'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']";
			
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "BL" || sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "NN" ) {
			var strBkgNo = formObject.bkg_no.value;
			var sLevel="";	
			var comboValue = (sheetObj.GetComboInfo(chkRow[0], "frt_term","Code").split("|"))[sheetObj.GetComboInfo(chkRow[0], "frt_term","SelectedIndex")];
			var hiddenFlg = "N";
			if("1" == sheetObj.CellValue(chkRow[0],"frt_clt_flg")){
				hiddenFlg = "Y";
			}
			if ("ALL"==comboValue) {
				sLevel="1";
			} else if ("C"==comboValue) {
				sLevel="5";
			} else if ("P"==comboValue) {
				sLevel="4";
			} else if ("N"==comboValue) {
				sLevel="6";
			} else if ("A"==comboValue) {
				sLevel="3";
			} else {
				sLevel="1";
			}
			rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
			if (sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "BL") {
				rdFile = "ESM_BKG_0109_DBL.mrd";
			} else {
				if (0==sheetObj.CellValue(chkRow[0], "por_cd").indexOf("US")) {
					rdFile = "ESM_BKG_0109_OBL_LETTER.mrd";
				} else {
					rdFile = "ESM_BKG_0109_OBL_A4.mrd";
				}
			}
			rdParam = "/rv form_bkgNo[( '" + strBkgNo + "') ]"
				  + " form_type[2]"
			      + " form_dataOnly[N]"
			      + " form_manifest[N]"
			      + " form_usrId[" +formObject.usr_id.value+"] "
			      + " form_hiddeData["+hiddenFlg+"]"
			      + " form_level[("+sLevel+")]"
				  + " form_remark["+remark+"]"
				  + " form_Cntr[1]"
				  + " form_mainOnly[N]"
				  + " form_CorrNo[]"
				  + " form_his_cntr[BKG_CONTAINER]"
				  + " form_his_bkg[BKG_BOOKING]"
				  + " form_his_mkd[BKG_BL_MK_DESC]"
				  + " form_his_xpt[BKG_XPT_IMP_LIC]"
				  + " form_his_bl[BKG_BL_DOC]"
				  + " isEncode[Y]"
				  + " /rp []"
				  + " /riprnmargin";
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="SM Line Draft B/L Copies";
		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "WB" ) {	
			var strBkgNo = formObject.bkg_no.value;
			var sLevel="";					 
			var comboValue = (sheetObj.GetComboInfo(chkRow[0], "frt_term","Code").split("|"))[sheetObj.GetComboInfo(chkRow[0], "frt_term","SelectedIndex")];
			var hiddenFlg = "N";
			if("1" == sheetObj.CellValue(chkRow[0],"frt_clt_flg")){
				hiddenFlg = "Y";
			}
			if ("ALL"==comboValue) {
				sLevel="1";
			} else if ("C"==comboValue) {
				sLevel="5";
			} else if ("P"==comboValue) {
				sLevel="4";
			} else if ("N"==comboValue) {
				sLevel="6";
			} else if ("A"==comboValue) {
				sLevel="3";
			} else {
				sLevel="1";
			}
			rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
			if (0==sheetObj.CellValue(chkRow[0], "por_cd").indexOf("US")) {
				rdFile = "ESM_BKG_0109_OBL_LETTER.mrd";
			} else {
				rdFile = "ESM_BKG_0109_OBL_A4.mrd";
			}
			rdParam = "/rv form_bkgNo[( '" + strBkgNo + "') ]"
				  + "  form_type[2]"
			      + " form_dataOnly[N]"
			      + " form_manifest[N]"
			      + " form_usrId[" +formObject.usr_id.value+"] "
			      + " form_hiddeData["+hiddenFlg+"]"
			      + " form_level[("+sLevel+")]"
				  + " form_remark["+remark+"]"
				  + " form_Cntr[1]"
				  + " form_mainOnly[N]"
				  + " form_CorrNo[]"
				  + " form_his_cntr[BKG_CONTAINER]"
				  + " form_his_bkg[BKG_BOOKING]"
				  + " form_his_mkd[BKG_BL_MK_DESC]"
				  + " form_his_xpt[BKG_XPT_IMP_LIC]"
				  + " form_his_bl[BKG_BL_DOC]"
				  + " /rp []"
				  + " /riprnmargin";
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="SM Line Draft B/L Copies";
		
		} else if ( sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "RR") {
			var strBkgNo = formObject.bkg_no.value;
			var sLevel="";	
			var comboValue = (sheetObj.GetComboInfo(chkRow[0], "frt_term","Code").split("|"))[sheetObj.GetComboInfo(chkRow[0], "frt_term","SelectedIndex")];
			var hiddenFlg = "N";
			if("1" == sheetObj.CellValue(chkRow[0],"frt_clt_flg")){
				hiddenFlg = "Y";
			}
			if ("ALL"==comboValue) {
				sLevel="1";
			} else if ("C"==comboValue) {
				sLevel="5";
			} else if ("P"==comboValue) {
				sLevel="4";
			} else if ("N"==comboValue) {
				sLevel="6";
			} else if ("A"==comboValue) {
				sLevel="3";
			} else {
				sLevel="1";
			}
			rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
			if (sheetObj.CellValue(chkRow[0], "ntc_knd_cd") == "BL") {
				rdFile = "ESM_BKG_0109_DBL.mrd";
			} else {
				if (0==sheetObj.CellValue(chkRow[0], "por_cd").indexOf("US")) {
					rdFile = "ESM_BKG_0109_OBL_LETTER.mrd";
				} else {
					rdFile = "ESM_BKG_0109_OBL_A4.mrd";
				}
			}
			rdParam = "/rv form_bkgNo[( '" + strBkgNo + "') ]"
				  + " form_type[2]"
			      + " form_dataOnly[N]"
			      + " form_manifest[N]"
			      + " form_usrId[" +formObject.usr_id.value+"] "
			      + " form_hiddeData["+hiddenFlg+"]"
			      + " form_level[("+sLevel+")]"
				  + " form_remark["+remark+"]"
				  + " form_Cntr[1]"
				  + " form_mainOnly[N]"
				  + " form_CorrNo[]"
				  + " form_his_cntr[BKG_CONTAINER]"
				  + " form_his_bkg[BKG_BOOKING]"
				  + " form_his_mkd[BKG_BL_MK_DESC]"
				  + " form_his_xpt[BKG_XPT_IMP_LIC]"
				  + " form_his_bl[BKG_BL_DOC]"
				  + " isEncode[Y]"
				  + " /rp []"
				  + " /riprnmargin";
			formObject.com_mrdPath.value = rdUrl+rdFile;
			formObject.com_mrdArguments.value = rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="SM Line Draft B/L Copies";
		}
			formObject.com_mrdSaveDialogFileName.value = formObject.bkg_no.value;
			ComOpenRDPopupModal("dialogWidth:900px;dialogHeight:800px");
	}

	/*
	 * sheet1 OnChange이벤트
	 */
	var chkNtcKndCd;
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with (sheetObj) { 
			if (1==Col) {
				if (CellValue(Row,Col)) {
					chkNtcKndCd = CellValue(Row,"ntc_knd_cd");
					ufUncheckPrev(sheetObj);
				}
				if(chkNtcKndCd=="SS"){
					if (CellValue(Row,Col)) {
						ComBtnDisable("btn_RemarkTemplate");
						ComBtnDisable("btn_Remark");
						ComBtnDisable("btn_EditVVD");
						ComBtnDisable("btn_Preview");
						ComBtnDisable("btn_FaxSend");
					} else {
						ComBtnEnable("btn_RemarkTemplate");
						ComBtnEnable("btn_Remark");
						ComBtnEnable("btn_EditVVD");
						ComBtnEnable("btn_Preview");
						ComBtnEnable("btn_FaxSend");
					}	
				} else if(chkNtcKndCd=="NN" || chkNtcKndCd=="SN"){
					if (CellValue(Row,Col)) {
						ComBtnEnable("btn_RemarkTemplate");
						ComBtnEnable("btn_Remark");
						ComBtnEnable("btn_EditVVD");
						ComBtnEnable("btn_Preview");
						ComBtnDisable("btn_FaxSend");
					} else {
						ComBtnEnable("btn_RemarkTemplate");
						ComBtnEnable("btn_Remark");
						ComBtnEnable("btn_EditVVD");
						ComBtnEnable("btn_Preview");
						ComBtnEnable("btn_FaxSend");
					}	
				} else {
					ComBtnEnable("btn_RemarkTemplate");
					ComBtnEnable("btn_Remark");
					ComBtnEnable("btn_EditVVD");
					ComBtnEnable("btn_Preview");
					ComBtnEnable("btn_FaxSend");
				}	
			}
		}
	}
	function ufUncheckPrev(sheetObj) {
		with (sheetObj) {
			var arrRow = ComFindText(sheetObj, "slct_flg", 1);
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
					if (chkNtcKndCd!=CellValue(arrRow[i],"ntc_knd_cd")) {
						CellValue2(arrRow[i],"slct_flg") = 0;
					}
				}
			}
		}
	}

	/*
	* sheet2 OnChange이벤트
	*/
	function sheet2_OnChange(sheetObj,Row, Col, Value) {
		with (sheetObj) {
			if ("EX"==CellValue(Row,"ntc_knd_cd") && 0==Value) {
				CheckAll2("slct_flg") = 0;
				CellValue2(Row,"slct_flg") = Value;
			} else {
				var iCheckRow = FindCheckedRow("slct_flg"); 
				var arrRow = iCheckRow.split("|"); 
				for (var idx=0; idx<arrRow.length-1; idx++) {
					if ("EX"==CellValue(arrRow[idx],"ntc_knd_cd") && 1==Value) {
						CheckAll2("slct_flg") = 0;
						CellValue2(arrRow[idx],"slct_flg") = Value;
						break;
					}
				}
			}
		}
	}

	/*
	* sheet1 OnMouseMove 이벤트
	*/
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
		 
		if (sheetObj.ColSaveName(sheetObj.MouseCol)=="fax_sender"){
			sheetObj.ToolTipText(sheetObj.SelectRow,"fax_sender")=sheetObj.CellValue(sheetObj.SelectRow,"fax_sender_nm");
		}else if (sheetObj.ColSaveName(sheetObj.MouseCol)=="eml_sender"){
			sheetObj.ToolTipText(sheetObj.SelectRow,"eml_sender")=sheetObj.CellValue(sheetObj.SelectRow,"eml_sender_nm");
		}
		
	}

	/*
	* sheet2 OnMouseMove 이벤트
	*/
	function sheet2_OnMouseMove(sheetObj,Button, Shift, X, Y){
		 
		if (sheetObj.ColSaveName(sheetObj.MouseCol)=="sender"){
			sheetObj.ToolTipText(sheetObj.SelectRow,"sender")=sheetObj.CellValue(sheetObj.SelectRow,"sender_nm");
		}
		
	}
	
	/*
	* sheet1 OnAfterEdit 이벤트
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col) {
		with (sheetObj) {
			if ("fax_no"==ColSaveName(Col)) {
				CellValue2(Row,Col) = EditValue.replace(/[^\d-]/g,"");
			}
		}
	}

	/*
	*팝업 속성에 따라 그리드 제한처리
	*/
	function gridState(sheetObj){
		var formObj = document.form;
		if (ComGetObjValue(formObj.docType)=="S"){
			for(var iRow=1;iRow<sheetObj.Rows;iRow++){
				if (sheetObj.CellValue(iRow, "ntc_knd_cd") == "SN"){ 
					sheetObj.CellValue(iRow, "slct_flg")=1;
			 	}else{
			 		sheetObj.RowEditable(iRow)=false;
			 	}
			}
			ComBtnDisable("btn_EDITransmission");
			sheetObjects[1].Enable =false;
		}else if (ComGetObjValue(formObj.docType)=="W"){
			for(var iRow=1;iRow<sheetObj.Rows;iRow++){
				if (sheetObj.CellValue(iRow, "ntc_knd_cd") == "WB"){ 
					sheetObj.CellValue(iRow, "slct_flg")=1;
				} else {
			 		sheetObj.RowEditable(iRow)=false;					
				}
			}
			sheetObj.TopRow = 5;
			sheetObj.LeftCol = 7;
//			alert(sheetObj.TopRow);
//			alert(sheetObj.LeftCol);

			
		}
/*
		if(formObj.pol_cd.value=="SGSIN"){
//			ComBtnDisable("btn_Yard");
			sheetObjects[1].DataInsert(-1);
			sheetObjects[1].CellValue2(sheetObjects[1].Rows - 1, "bkg_no") = ComGetObjValue(formObj.bkg_no);
			sheetObjects[1].CellValue2(sheetObjects[1].Rows - 1, "ntc_knd_cd") = "PS";
			sheetObjects[1].CellValue2(sheetObjects[1].Rows - 1, "ntc_knd_nm") = "PSA I/F";
		}
*/
	}
//	
//	function sheet1_OnScroll(OlTopRow, OldLeftCol, NewTopRow, NewLeftCol){
//		alert(NewTopRow);
//		alert(NewLeftCol);
//	}
	/*
	* 재조회
	*/
	function reSearch(){
		var formObj =document.form;
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0095GS.do", FormQueryString(formObj)); 
		var arrXml = sXml.split("|$$|");
		for(var i = 0; i < arrXml.length; i++){ 
			sheetObjects[i].Redraw = false;    
			if(i > 0) {
				sheetObjects[i].WaitImageVisible = false;	
			}  
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
			sheetObjects[i].Redraw = true; 
		}
		freightEnabled(sheetObjects[0]);
		faxEnabled(sheetObjects[0]);
		noticeTypeEnabled(sheetObjects[0]);
		// 버튼 refresh
		ComBtnEnable("btn_RemarkTemplate");
		ComBtnEnable("btn_Remark");
		ComBtnEnable("btn_EditVVD");
		ComBtnEnable("btn_Preview");
		ComBtnEnable("btn_FaxSend");
	}
	
	/*
	* remark popup(0913)에서 호출됨
	*/
    function setRemark(remark) {
		var arrRow = ComFindText(sheetObjects[0], "slct_flg", 1);
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				sheetObjects[0].CellValue2(arrRow[i],"remark") = remark;
			}
		}
    }
	
	/*
	* remark popup(0913)에서 호출됨
	*/
    function refresh() {
    	reSearch();
    }

	//remark를 encoding함
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
