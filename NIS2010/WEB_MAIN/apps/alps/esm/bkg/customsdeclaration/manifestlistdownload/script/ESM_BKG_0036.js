/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0036.js
 *@FileTitle : B/L Inquiry: C/M Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.02 이수빈
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
 * @class B/L Inquiry: C/M Information : B/L Inquiry: C/M Information 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0036() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
    this.setComboObject 		= setComboObject;
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
	  var sheetObject1 = sheetObjects[0]; // Cntr
	  var sheetObject2 = sheetObjects[1]; // C/M
	  var sheetObject3 = sheetObjects[2]; // B/L Info
	  /*******************************************************/
	  var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

			case "btn_retrieve":
				//doActionIBSheet(sheetObject3,document.form,IBSEARCH);
				doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			break;
			
			case "btn_save":
				doActionIBSheet(sheetObject2,document.form,IBSAVE);
			break;
			
			case "btn_copy":
				var selIdx = sheetObject1.SelectRow;
				if(selIdx > 0){
					var cntr_no  = sheetObject1.CellValue(selIdx, "cntr_no");
					var cntr_tpsz_cd = sheetObject1.CellValue(selIdx, "cntr_tpsz_cd");
					var url = "ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
					ComOpenWindowCenter(url, "ESM_BKG_0176", 400, 300);
				}else{
					ComShowCodeMessage('BKG00249');  // No Selected Row
				}
			break;
			
			case "btn_clm":
				var params = "pgmNo=ESD_SCE_0043&f_cmd=0&row_size=50&" +
							 "cntr_no=" + document.form.cntr_no.value + 
							 "&tpsz_cd=" + document.form.tpsz_cd.value +
							 "&arr_dt1=" + document.form.vps_eta_dt.value + 
							 "&arr_dt2=" + getTimeStamp();
				ComOpenWindowCenter("ESD_SCE_0043.do?"+params, "ESD_SCE_0043", 1024, 530);
			break;				
			
			case "btn_close":
				window.close();
			break;
			
			case "btn_add":
				doActionIBSheet(sheetObject2,document.form,IBINSERT);
			break;
			
			case "btn_del":
				doActionIBSheet(sheetObject2,document.form,IBDELETE);
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

    	 //khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
         ComEndConfigSheet(sheetObjects[i]);
     }

	var formObj = document.form;
 	//화면에서 필요한 이벤트
 	axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
 	axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
 	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

 /**
  * sheet2 로드 완료 후 조회
  */
 function sheet2_OnLoadFinish(sheetObj) {
	 var formObj = document.form;
	 doActionIBSheet(sheetObj,formObj,IBSEARCH);
 }

/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;
     var sheetId = sheetObj.id;

     switch(sheetId) {	         
         case "sheet1":      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 100;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(10, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "|Seq.|bl_no|Container|TY/SZ|Seal No.|Seal No.|STS||";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	 false,  	"ibflag");
                 InitDataProperty(0, cnt++ , dtSeq,				50,		daCenter,	 true,		"Seq");
                 InitDataProperty(0, cnt++ , dtHidden,		 	120,   	daCenter,    false,     "bl_no",   			false,    "",      dfNone,		0,     true,		true);
                 InitDataProperty(0, cnt++ , dtData,		 	250,   	daCenter,    false,     "cntr_no",   		false,    "",      dfEngUpKey,	0,     false,		false);      
                 InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,    false,     "cntr_tpsz_cd", 	false,    "",      dfNone, 		0,     false,		false);

                 InitDataProperty(0, cnt++ , dtCombo, 			250,   	daCenter,    false,     "combo_seal_no",    false,    "",      dfNone, 		0,     true,		false);
                 InitDataProperty(0, cnt++ , dtHidden,      	100,   	daCenter,    false,     "seal_no", 			false,    "",      dfNone, 		0,     false,		false);
                 InitDataProperty(0, cnt++ , dtCombo,      		100,   	daCenter,    false,     "ibd_cntr_sts_cd",  false,    "",      dfNone, 		0,     false,		false);
                 InitDataProperty(0, cnt++ , dtHidden,      	100,   	daCenter,    false,     "cntr_mf_flag", 	false,    "",      dfNone, 		0,     false,		false);
                 InitDataProperty(0, cnt++ , dtHidden,      	100,   	daCenter,    false,     "mf_cfm_flg", 		false,    "",      dfNone, 		0,     false,		false);

		   	 	 InitDataCombo(0,	"ibd_cntr_sts_cd",	"Active|Deleted", "A|D");
             }
             break;

         case "sheet2":      //sheet2 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 122;
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

				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(18, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, false, false, false);

                 var HeadTitle1 = "|Sel.|Seq.|GDS Seq|PACKAGE|PACKAGE|WEIGHT|WEIGHT|MK|DESCRIPTION|HTS CODE|HTS CODE|FDA|PN CONFIRM BY CONSIGNEE|PN CONFIRM BY CONSIGNEE|PN CONFIRM BY CONSIGNEE||";
                 var HeadTitle2 = "|Sel.|Seq.|GDS Seq|PACKAGE|PACKAGE|WEIGHT|WEIGHT|MK|DESCRIPTION|HTS CODE|HTS CODE|PN|C|DATE|REMARK||"; 
                 
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    daCenter,    true,  	 "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 		40,   daCenter,    true,     "Sel");
                 InitDataProperty(0, cnt++ , dtData,       		30,   daCenter,    true,     "seq");
                 InitDataProperty(0, cnt++ , dtHidden, 		 	80,   daCenter,    true,     "cmdt_gds_seq",        false,    "",      dfNone, 			0,     true,		true);
                 InitDataProperty(0, cnt++ , dtData, 		 	60,   daCenter,    true,     "pck_qty",          	false,    "",      dfNullInteger, 	0,     true,		true);
                 
                 InitDataProperty(0, cnt++ , dtData, 		 	30,   daCenter,    true,     "ams_pck_tp_cd",    	false,    "",      dfEngUpKey, 		0,     true,		true,	3);
                 InitDataProperty(0, cnt++ , dtData,      		70,   daRight,     true,     "grs_wgt",     	 	false,    "",      dfNullFloat, 	3,     true,		true);
                 InitDataProperty(0, cnt++ , dtCombo,      		55,   daCenter,    true,     "wgt_ut_cd",        	false,    "",      dfEngUpKey, 		0,     true,		true,	3);
                 InitDataProperty(0, cnt++ , dtData,		 	70,   daCenter,    true,     "mk_desc",       	 	false,    "",      dfNone, 			0,     false,		false);
                 InitDataProperty(0, cnt++ , dtData,      		120,  daLeft,	   true,     "cgo_desc",   	 	 	false,    "",      dfNone, 			0,     true,		true);

                 InitDataProperty(0, cnt++ , dtData, 		 	70,   daCenter,    true,     "hamo_cmdt_cd",     	false,    "",      dfNone,			0,     true,		true,	10);
				 InitDataProperty(0, cnt++ , dtPopup,     		20,   daCenter,    true,     "hts_cd",      		false,    "",      dfNone, 			0,     true,		true);
				 InitDataProperty(0, cnt++ , dtData, 		 	35,   daCenter,    true,     "prior_ntc_snd_flg",	false,    "",      dfNone,	 		0,     false,		false,	1);
				 InitDataProperty(0, cnt++ , dtCheckBox,  		40,   daCenter,    true,     "prior_ntc_cfm_flg",	false,    "",      dfNone, 			0,     true,		true,	-1,	false,	true,	"",	false);
                 InitDataProperty(0, cnt++ , dtData, 		 	70,   daCenter,    true,     "prior_ntc_cfm_dt", 	false,    "",      dfDateYmd,		0,     true,		true);

                 InitDataProperty(0, cnt++ , dtData,      		70,   daLeft,      true,     "prior_ntc_rmk",    	false,    "",      dfNone, 			0,     true,		true);
                 InitDataProperty(0, cnt++ , dtHidden,      	70,   daLeft,      true,     "bl_no",    			false,    "",      dfNone, 			0,     true,		true);
                 InitDataProperty(0, cnt++ , dtHidden,      	70,   daLeft,      true,     "cntr_no",    			false,    "",      dfNone, 			0,     true,		true);

                 InitDataValid(0, "ams_pck_tp_cd", vtEngUpOnly);
//                 InitDataValid(0, "wgt_ut_cd", vtEngUpOnly);
                 InitDataValid(0, "hamo_cmdt_cd", vtNumericOnly);
                 
	             InitDataCombo(0, "wgt_ut_cd", " |KGS|LBS"," |KGS|LBS");
                 
 				 //InitUserFormat2(0, "hamo_cmdt_cd", "##########", "" );
				 ShowButtonImage = 2;
		   	 	 
				 CountPosition = 0;
				 //CountFormat = "[SELECTDATAROW / BOTTOMDATA]";
             }
             sheetObj.SetMergeCell (0, 4, 2, 2); 
             sheetObj.SetMergeCell (0, 6, 2, 2); 
             sheetObj.SetMergeCell (0, 10, 2, 2); 
             break; 
             
	     case "sheet3":      //sheet3 init
	         with (sheetObj) {
	             // 높이 설정
	             //style.height = 100;
	             //전체 너비 설정
	             SheetWidth = mainTable.clientWidth;
	
	             //Host정보 설정[필수][HostIp, Port, PagePath]
	             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	             //전체Merge 종류 [선택, Default msNone]
	             MergeSheet = msHeaderOnly;
	
	             //전체Edit 허용 여부 [선택, Default false]
	             Editable = true;
	
	             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             InitRowInfo( 1, 1, 3, 100);
	
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             InitColumnInfo(19, 0, 0, true);
	
	             // 해더에서 처리할 수 있는 각종 기능을 설정한다
	             InitHeadMode(true, true, false, true, false,false)
	
	             var HeadTitle = "|bl_no|pod_cd|pol_cd|del_cd|usa_lst_loc_cd|pck_qty|ams_pck_tp_cd|cgo_wgt|wgt_ut_cd|ibd_trsp_no|ibd_trsp_tp_cd|cstms_clr_tp_cd|mf_sts|f_flg|o_flg|c_flg|cstms_mf_tp_cd|vps_eta_dt";
	
	             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             InitHeadRow(0, HeadTitle, true);
	
	
	             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,   daCenter,  	false,     "ibflag");
	             InitDataProperty(0, cnt++ , dtData,      		 70,   daCenter,    false,     "bl_no",     		false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "pod_cd",          	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData,      		 70,   daCenter,    false,     "pol_cd",     		false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData,      		 70,   daCenter,    false,     "del_cd",     		false,    "",      dfNone, 		0,     false,		false);
	                                                                                                                                                        
	             InitDataProperty(0, cnt++ , dtData,      		 65,   daCenter,    false,     "usa_lst_loc_cd",    false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "pck_qty",       	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "ams_pck_tp_cd",     false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "cgo_wgt",       	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "wgt_ut_cd",       	false,    "",      dfNone, 		0,     false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "ibd_trsp_no",       false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "ibd_trsp_tp_cd",    false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "cstms_clr_tp_cd",   false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "mf_sts",       	 	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "f_flg",       	 	false,    "",      dfNone, 		0,     false,		false);

	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "o_flg",       	 	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "c_flg",       	 	false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "cstms_mf_tp_cd",    false,    "",      dfNone, 		0,     false,		false);
	             InitDataProperty(0, cnt++ , dtData, 		 	 70,   daCenter,    false,     "vps_eta_dt",       	false,    "",      dfNone, 		0,     false,		false);
	             
	     	}
	         break;
     }
 }

/**
 * Sheet관련 프로세스 처리
 */ 
 function doActionIBSheet(sheetObj,formObj,sAction) {
     //sheetObj.ShowDebugMsg = false;
	 sheetObjects[0].WaitImageVisible = false;
	 sheetObjects[1].WaitImageVisible = false;
	 
     switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
    		ComOpenWait(true);
	        formObj.f_cmd.value = SEARCH;
	        var sXml = sheetObj.GetSearchXml("ESM_BKG_0036GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if(arrXml.length > 0){
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[1].SelectCell(0,0);

		        ComEtcDataXmlToForm(arrXml[0], formObj);

		        var stsCd = ComGetEtcData(arrXml[0],"mf_sts");
		        document.getElementById("mf_sts").innerHTML = (stsCd != undefined ? stsCd : "");
				if(stsCd == "Active"){
					document.getElementById("mf_sts").style.color = "blue";
				}else if(stsCd == "Deleted"){
					document.getElementById("mf_sts").style.color = "red";
				}

				var etcData;
				etcData = ComGetEtcData(arrXml[0],"cstms_clr_tp_cd");
		        document.getElementById("cstms_clr_tp_cd").innerHTML = (etcData != undefined ? etcData : "");
		        etcData = ComGetEtcData(arrXml[0],"f_flg");
		        document.getElementById("f_flg").innerHTML = (etcData != undefined ? etcData : "");
		        etcData = ComGetEtcData(arrXml[0],"o_flg");
		        document.getElementById("o_flg").innerHTML = (etcData != undefined ? etcData : "");
		        etcData = ComGetEtcData(arrXml[0],"c_flg");
		        document.getElementById("c_flg").innerHTML = (etcData != undefined ? etcData : "");
		        
		        if(formObj.pck_qty.value != "" && formObj.cgo_wgt.value != ""){
					AddComma(formObj.pck_qty,"#,###");
					AddComma(formObj.cgo_wgt,"#,###.###");
		        }
			}
    		ComOpenWait(false);
	        break;
		
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			//적어도 3자리 알파벳이 들어가도록 validation 요청.
			for(var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++){
				var cgoDesc = sheetObj.CellValue(i, "cgo_desc");
			    var cnt = 0;
				for (var inx = 0; inx < cgoDesc.length; inx++) {
					if ( ComIsAlphabet(cgoDesc.charAt(inx))) cnt++;
					if ( cnt == 3 ) break;
		        }			 
				if ( cnt < 3 ) {
					ComShowCodeMessage('BKG95108'); //At least, 3 alphabet characters should be included in description column. please check it again.
					return false;
				}
			}
			
		 	if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
	    		ComOpenWait(true);
		        formObj.f_cmd.value = MODIFY;
				sheetObj.DoSave("ESM_BKG_0036GS.do", FormQueryString(formObj), -1, false);
	    		ComOpenWait(false);
		 	}
			break;
		
		case IBINSERT:      // 입력
			sheetObj.DataInsert(-1);
			sheetObj.CellValue(sheetObj.SelectRow, "bl_no") = formObj.bl_no.value;
			sheetObj.CellValue(sheetObj.SelectRow, "cntr_no") = formObj.cntr_no.value;
			setSeq();
			break;
		
		case IBDELETE:      // 삭제
			if(sheetObj.CheckedRows(1) == 0){
				ComShowCodeMessage('BKG00249'); // No Selected Row
				return;
			}
			if(sheetObj.CheckedRows(1) > 0){
				if(ComShowCodeConfirm('BKG03037')){
					/* Row 삭제 */
					rowDelete(sheetObj, "Sel", 1);
					/* Queantity 재계산*/
					syncQuantity("pck_qty");
					syncQuantity("grs_wgt");
					setSeq();
				}
			}
			break;
     }
 }


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
	case IBSEARCH: // 조회
		//기본포멧체크
		if (!ComChkObjValid(formObj.bl_no)) return false;
		return true;
	    break;
	
	case IBSAVE: // 저장
	 	if (!ComChkValid(formObj)) return false;
	    return true;
	    break;
	}
}

/**
 * 조회 후 콤보 데이터 세팅
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(ErrMsg != "") return;
	var sealNo;
	for (i=1; i<=sheetObj.RowCount; i++){
		sealNo = sheetObj.CellValue(i,"seal_no");
		sheetObj.CellComboItem(i, "combo_seal_no", sealNo, sealNo);
		sheetObj.CellBackColor(i, "combo_seal_no") = sheetObj.RgbColor(239, 235, 239);
		sheetObj.CellValue2(i,"mf_cfm_flg") = 0;
	}
    document.form.cntr_no.value = sheetObj.CellText(1,"cntr_no");
}

/**
 * 시트의 선택한 Row의 Container 에 해당하는 CM을 하단 그리드에 표시
 */ 
function sheet1_OnClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) != "cntr_no") return;
    document.form.cntr_no.value = sheetObj.CellText(Row,"cntr_no");
    document.form.tpsz_cd.value = sheetObj.CellText(Row,"cntr_tpsz_cd");
	setCMInfo(Row);
}

/**
 * 조회 후 처리
 */ 
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	if(ErrMsg != "") return;
	var formObj = document.form;
    if(sheetObj.RowCount > 0){
    	//setCMInfo(1);
    	//alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "Seq"));
    	sheet1_OnClick(sheetObjects[0], sheetObjects[0].SelectRow, sheetObjects[0].SaveNameCol("cntr_no"));
    }
}

/**
 * 저장 후 처리
 */ 
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj,document.form,IBSEARCH);
}

/**
 * 시트의 package, weight 값이 변경될 경우 Total 값 재 계산
 */ 
function sheet2_OnChange(sheetObj, Row, Col, Val) {
    var col_name = sheetObj.ColSaveName(Col);
    
	switch(col_name) {
		case "pck_qty":
		case "grs_wgt":
			syncQuantity(col_name);
			break;
	}
}

/**
 * 시트의 mk_desc 컬럼 클릭 시 메모패드 팝업
 */ 
function sheet2_OnClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) == "mk_desc") {
		ComShowMemoPad(sheetObj, null, null, false, 200, 100);
		
		if(sheetObj.CellValue(Row, Col) == ""){
		    var frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
			frameDoc.getElementById(MEMO_TEXT_NAME).value = "NO MARKS";
		}
    }

	document.getElementById("total_cnt").innerHTML = "["+sheetObj.CellText(Row,"seq")+" / "+cmTotal+"]";
}

/**
 * 시트내 돋보기 이미지 선택 시 팝업 호출
 */ 
function sheet2_OnPopupClick(sheetObj, Row, Col){
    if (sheetObj.ColSaveName(Col) == "hts_cd"){
    	comBkgCallPop0607("setCallBack0607","","");
    }
}

/**
 * 돋보기 이미지 선택 시 팝업이 닫히면서 호출됨
 */ 
function setCallBack0607(aryPopupData) {
	var sheetObj = sheetObjects[1];
	sheetObj.CellValue(sheetObj.SelectRow,"hamo_cmdt_cd")= aryPopupData[0][3];
	sheetObj.CellValue(sheetObj.SelectRow,"prior_ntc_snd_flg")= aryPopupData[0][6];
}


/**
 * 문자열을 숫자포멧에 맞게 변경하여 리턴한다.
 */
function AddComma(obj, sFormat){
    try {
        var sVal = obj.value.replace(/\,/g,"");
    	switch(sFormat){
    		case "#,###":
    			obj.value = ComAddComma(sVal);
    			break;
    		case "#,###.###":
    	    	p = sVal.split(".");
                p[0] = ComAddComma(p[0]);
                if      (p.length <= 1) obj.value = p[0]+".000";
                else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,3);
                else if (p.length > 2) obj.value = p[0]+"."+p[1].substr(0,3);
                else sVal = "";
    			break;
    	}
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * 이하는 ESM_BKG_0079_07.js 에 정의된 함수를 복사한 것
 * Copy C/M 팝업을 띄우기 위한 관련 함수이다.
 * 원본 대비 약간의 변경 있음.
 */ 

/**
 * Cntr 그리드에서 컨테이너 선택시, Cntr 정보 및 CM grid 세팅 
 */
var cmTotal;
function setCMInfo(row){
	if(row > 0) {
		// retrieve CM
		showAndHideSheet(sheetObjects[1], "cntr_no", sheetObjects[0].CellValue(row, "cntr_no"));
		// rearangeSeq
		setSeq();
		// calculate sum
		syncQuantity("pck_qty");
		syncQuantity("grs_wgt");
		
		sheetObjects[0].SelectCell(row,"cntr_no");
	}
}

/**
 * 상위 그리드의 Container 에 해당하는 CM 만 남기고 Hidden 처리
 */ 
function showAndHideSheet(sheetObj, colName, colValue){
	var rcnt = sheetObj.RowCount + 2;
	for(rn=2;rn<rcnt;rn++){
		if(sheetObj.RowStatus(rn) != 'D' && sheetObj.CellValue(rn, colName) == colValue){
			sheetObj.RowHidden(rn) = false;
			//sheetObj.CellValue2(rn, "Sel") = '0';
		}else{
			sheetObj.RowHidden(rn) = true;
			//sheetObj.CellValue2(rn, "Sel") = '1';
		}
	}
}

/**
 * Row Delete 버튼 클릭 시 처리
 */ 
function rowDelete(sheetObj, colName, colValue){
	var arrRow = findText(sheetObj, colName, colValue);
	for (ir = 0; ir < arrRow.length; ir++) {
		if(arrRow[arrRow.length-1-ir]=='') continue;
		sheetObj.RowHidden(arrRow[arrRow.length-1-ir]) = true;
		sheetObj.RowStatus(arrRow[arrRow.length-1-ir]) = 'D';
	}
}

/**
 * Package, Weight 값 계산
 */
function syncQuantity(col_name){
	var formObj = document.form;
	var vSum = 0;
	// CM
	var CmArr = findText(sheetObjects[1], "cntr_no", document.form.cntr_no.value);
	for(rx=0;rx<CmArr.length;rx++){
		//alert(CmArr[rx] + " : " + sheetObjects[1].CellValue(CmArr[rx], col_name));
		vSum += ComParseFloat(sheetObjects[1].CellValue(CmArr[rx], col_name));
	}
	// Set Value
	if(col_name=="pck_qty") {
		formObj.tot_pkg.value = ''+vSum;
		AddComma(formObj.tot_pkg, "#,###");
	}
	if(col_name=="grs_wgt") {
		formObj.tot_wgt.value = ''+vSum;
		AddComma(formObj.tot_wgt, "#,###.###");
	}
}

/**
 * 상위 그리드 Container 에 따라 보여지는 CM 그리드 Seq No. 재 설정
 */ 
function setSeq(){
	var rSeq = 1;
	var rCnt = sheetObjects[1].RowCount + 2;
	for (rn = 2; rn < rCnt; rn++) {
		var rsts = sheetObjects[1].RowStatus(rn);
		if(rsts != 'D' && sheetObjects[1].RowHidden(rn) == false){
		//if(rsts != 'D' && sheetObjects[1].CellValue(rn, "Sel") == '0'){
			sheetObjects[1].CellValue2(rn, "seq") = rSeq++;
			sheetObjects[1].RowStatus(rn) = rsts;
		}
		if(rSeq == 1) sheetObjects[1].SelectCell(0,0);
	}
	cmTotal = rSeq-1;
	if(cmTotal == 0){
		document.getElementById("total_cnt").innerHTML = "[0 / "+cmTotal+"]";
	}else{
		document.getElementById("total_cnt").innerHTML = "[1 / "+cmTotal+"]";
	}
}

/**
 * Copy CM 팝업에서 선택된 Container 의 CM 데이터를 현재 Container 의 CM으로 등록
 */ 
function copyCm(fmCntr, toCntrArr){
	if(fmCntr == '' || toCntrArr == ''){
		return;
	}
	var sheetObj = sheetObjects[1];
	var tgtCnt = toCntrArr.length;
	var cArr = findText(sheetObj, "cntr_no", fmCntr);
	for(ix=0;ix<tgtCnt;ix++){
		for(ir=0;ir<cArr.length;ir++) {
			var nRow = sheetObj.DataInsert(-1);
			sheetObj.RowHidden(nRow) = true;
			for(ic = 0; ic <=  sheetObj.LastCol; ic++){
				try{
					if(sheetObj.ColSaveName(ic) == "ibflag") continue;
					if(sheetObj.ColSaveName(ic) == "cmdt_gds_seq") continue;
					if(sheetObj.ColSaveName(ic) == "cntr_no"){
						sheetObj.CellValue2(nRow, ic) = toCntrArr[ix];
					}else{
						sheetObj.CellValue2(nRow, ic) = sheetObj.CellValue(cArr[ir], ic);
					}
				} catch(err) { }
			}			
		}
	}
}

/**
 * Integer형 데이터로 변환
 * @param p
 * @return int
 */
function ComParseInt(p){
	return (p == null || p == '') ? 0 : parseInt(p);
}

/**
 * Float형 데이터로 변환
 * @param p
 * @return float
 */
function ComParseFloat(p){
	return (p == null || p == '') ? 0 : parseFloat(p);
}

/**
 * sheetObject의 특정 컬럼의 조건값에 해당하는 열의 Index를 구하는 함수.
 */
function findText(sheetObj, colName, colValue){
	var idxs = new Array();
	var firstRow;
	var cnt;
	
	if(sheetObj.id == "sheet2"){
		firstRow = 2;
		cnt = sheetObj.RowCount + 2;
	}else{
		firstRow = 1;
		cnt = sheetObj.RowCount + 1;
	}
	
	for (ix = firstRow; ix < cnt; ix++) {
		if(sheetObj.RowStatus(ix) != 'D' && sheetObj.CellValue(ix, colName) == colValue){
			idxs.push(''+ix);
		}
	}
	return idxs;
}

/**
 * 현재 날짜 구하기
 */
  function getTimeStamp() {
    var d = new Date();
    var s =
      leadingZeros(d.getFullYear(), 4) + '-' +
      leadingZeros(d.getMonth() + 1, 2) + '-' +
      leadingZeros(d.getDate(), 2) ;

    return s;
  }


/**
 * yyyy,mm,dd 타입으로 변환
 */
  function leadingZeros(n, digits) {
    var zero = '';
    n = n.toString();

    if (n.length < digits) {
      for (i = 0; i < digits - n.length; i++)
        zero += '0';
    }
    return zero + n;
  }
		
/* 개발자 작업  끝 */