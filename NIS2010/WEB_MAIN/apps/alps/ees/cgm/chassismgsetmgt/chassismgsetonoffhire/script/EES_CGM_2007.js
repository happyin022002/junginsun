/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2007.js
 *@FileTitle : Chassis On-Hire Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.06.26 박의수
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.09.14 허철용 [CSR 선처리] 날짜 Validation 오류수정
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
 * @class ees_cgm_2007 : ees_cgm_2007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2007() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


/* 개발자 작업 */

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var sheetObject = sheetObjects[0];

      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {
             case "New":
            	// SHEET RESET
            	sheetObject.RemoveAll();
     			
     			// HTML OBJECT RESET
     			formObject.reset();
     			chk('O');
                break;
             case "Row_Add":
            	 sheetObject.DataInsert();
     			for(i=1; i<sheetObject.rowCount+1; i++){
     				sheetObject.CellValue(i, "eq_knd_cd") = formObject.eq_knd_cd.value;	
    				if(sheetObject.CellValue(i, "cre_usr_id") == ""){
    					sheetObject.CellValue(i, "cre_usr_id") = formObject.cre_id.value;	
    				}
    			}
				 break;
             case "Delete":
            	 rowDelete(sheetObject);
				 break;
     		 case "btn_verify":
    			doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			break;
    		 case "btn_excel":
    			doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    			break;
             case "Save":
    			doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
     		 case "btn_Calendar_a":
    			if(window.event.srcElement.disabled) {
    				return;
    			}
    			var cal = new ComCalendar();
    		 
    			cal.select(formObject.onh_dt, "yyyy-MM-dd");
    			break;
     		 case "ComOpenPopupWithTargetOffice":
    			ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?pgmNo=COM_ENS_071', 800, 480, "ofc_cd:onh_ofc_cd", "1,0,1,1,1,1,1", true);
    			Matched_Chk('Office');
    		    Verify_Status_chk();
    			break;
     		 case "ComOpenPopupWithTargetYard":
    			ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:onh_yd_cd", "1,0,1,1,1,1,1", true);
    			Matched_Chk('Yard');
    			Verify_Status_chk();
    			break;
     		case "ComOpenPopupWithTargetAgree":
     			if(formObj.ownleas[1].checked == true){
     				ComOpenPopup('/hanjin/EES_CGM_2022.do?pgmNo=EES_CGM_2022', 820, 435, "setProgramNo", "1,0,1,1,1,1", true, false);
     			}
    			
    			break;
            case "btn_downexcel":
            	sheetObject.SpeedDown2Excel(-1);  
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
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
     for(i=0;i<sheetObjects.length;i++){

     //khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);
     //khlee-마지막 환경 설정 함수 추가
         ComEndConfigSheet(sheetObjects[i]);
     }

     for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
     }
     

 }

  /**
  * 
  * @param sheetObj
  * @return
  */
 function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.WaitImageVisible = false;
     formObj = document.form;
     axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form);
 	 axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
     axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
     axon_event.addListener('focusout', 'obj_focusout' , 'onh_ofc_cd'  , 'agreement_no','onh_dt','onh_yd_cd'  ); 
     axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
     // 초기화
     initControl(sheetObjects[0]); 
     sheetObj.WaitImageVisible = true; 
}
 
  /**
   * Form의 Conrol 를 초기화 시킨다. <br>
   * @param  {object} sheetObj	필수
   * @return 없음
   * @author 최민회
   * @version 2009.05.20
   */
  function initControl(sheetObj){
  	// Form 객체 선언
  	  formObj = document.form;
      // axon event 등록

    doActionIBSheet(sheetObj, formObj, SEARCH04); // COMBO 조회(TYPE SIZE)
    doActionIBSheet(sheetObj, formObj, SEARCH03); // COMBO 조회(TYPE SIZE)
    yard_Chk();
    
  }


/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
         case 1:      //t1sheet1 init
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
                 InitRowInfo( 1, 1, 3, 100);

				 var HeadTitle = "||Seq.|M.G.Set No.|Type|Manufacture Date|Model No.|Machine Serial No.|Voltage (V)|Fuel Capacity (ltr)|Verify Status|Created By|||||||||";
				 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus,30, daCenter, false, "ibflag" ); 
//                 InitDataProperty(0, cnt++, dtStatus,30, daCenter, false, "ibflag" ); 
    			 InitDataProperty(0, cnt++, dtCheckBox,    30, daCenter, false, "del_chk" );  
    			 InitDataProperty(0, cnt++, dtDataSeq,     40, daCenter, false, "Seq"); 
    			 InitDataProperty(0, cnt++, dtData,        80, daCenter,  true, "eq_no",             false,	"",	dfNone,0,  true,  true,	10);                                                                               
    			 InitDataProperty(0, cnt++, dtCombo,       70, daCenter,  true, "eq_tpsz_cd",        false, "", dfNone,0, false, false);
             
    			 
                 InitDataProperty(0, cnt++, dtPopupEdit,  120, daCenter,  true, "mft_dt",            false, "",  dfDateYmd);
                 InitDataProperty(0, cnt++, dtCombo,      120, daCenter, false, "eq_spec_no",        false, "",  dfNone,0, false, false);
                 InitDataProperty(0, cnt++, dtData,       130, daCenter,   false, "mgst_mchn_ser_no",  false, "",  dfNone,0, false, false);                                                                  
                 InitDataProperty(0, cnt++, dtCombo,      90, daCenter, false, "mgst_vltg_capa",    false, "",  dfNone,0, false, false);                                                                  
                 InitDataProperty(0, cnt++, dtData,       110, daCenter, false, "mgst_fuel_capa",    false, "",  dfNone,0, false, false); 
                 
                 InitDataProperty(0, cnt++, dtData,        110, daCenter, false, "verify",            false, "",  dfNone,0, false, false);                                                                  
                 InitDataProperty(0, cnt++, dtData,        70, daCenter, false, "cre_usr_id",        false, "",  dfNone,0, false, false);  
                 InitDataProperty(0, cnt++, dtHidden,      60, daCenter, false, "own_lse"   );  
                 InitDataProperty(0, cnt++, dtHidden,      60, daCenter, false, "eq_knd_cd"   ); 
                 
                 
     			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_dt",			false,	"",	dfNone,			0,	true,	true);
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agreement_no",		false,	"",	dfNone,			0,	true,	true);
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agmt_ver_no",		false,	"",	dfNone,			0,	true,	true);
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_ofc_cd",		false,	"",	dfNone,			0,	true,	true);
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_yd_cd",		false,	"",	dfNone,			0,	true,	true);
    			
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"vndr_seq",		    false,	"",	dfNone,			0,	true,	true);
    			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agmt_lstm_cd",		false,	"",	dfNone,			0,	true,	true);
                InitDataCombo(0, "mgst_vltg_capa", " |220|440", " |220|440");
//		        InitDataCombo(0, "Model", "1998-NJG234X-005|", "1998-NJG234X-005|", "1998-NJG234X-005","1");
										

				PopupImage  =  "img/btns_calendar.gif";
				ShowButtonImage = 1; 
				SelectionMode   = smSelectionFree;

            }
            sheetObj.InitDataValid(0, "eq_no", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
            sheetObj.InitDataValid(0, "mgst_mchn_ser_no", vtEngUpOther, "1234567890 `~!@#$%^&*()_+=|  \\ \/?><,. -[]{}"); // 영문 대문자와 숫자만 입력

//            sheetObj.InitDataValid(0, "mgst_vltg_capa", vtNumericOnly);  
            sheetObj.InitDataValid(0, "mgst_fuel_capa", vtNumericOnly);  
             break;



     }
 }

// Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

	     case IBSEARCH: // 조회
			var verifyFlag = false;
			var chkFlag    = false;
			
			formObj.f_cmd.value = SEARCHLIST;
			queryString = "f_cmd=" + SEARCHLIST;
			
			if(formObj.onh_ofc_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Office");
				formObj.onh_ofc_cd.focus();
				return;
			}
			if(formObj.onh_dt.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Date");
				formObj.onh_dt.focus();
				return;
			}
			if(formObj.onh_yd_cd.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Yard");
				formObj.onh_yd_cd.focus();
				return;
			}
			if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
				 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
			 	 formObj.onh_yd_cd.focus();
			     return false;
			}
			if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
				ComShowCodeMessage("CGM10004", "Agreement No");
				formObj.agreement_no.focus();
				return;
			}
			
			for(i=1; i<sheetObj.rowCount+1; i++){
				var del_chk = sheetObj.CellValue(i, "del_chk");
				// 필수 입력값 검증
				if(del_chk == "1" && sheetObj.CellValue(i, "eq_no")==""){
					sheetObj.RowStatus(i) = "R";
					sheetObj.CellValue(i, "del_chk")= "0";
				} else if(del_chk == "1" && sheetObj.CellValue(i, "eq_no")!=""){
					sheetObj.CellValue(i, "own_lse")   = formObj.own_lse.value;
					sheetObj.CellValue(i, "eq_knd_cd") = formObj.eq_knd_cd.value;
					chkFlag = true;
				}
				if(formObj.ownleas[1].checked == true  ){
					sheetObj.CellValue(i, "agreement_no") = formObj.agreement_no.value;
				}
				sheetObj.CellValue(i, "onh_dt")       =  formObj.onh_dt.value ;
			}
			var params = sheetObj.GetSaveString(true);
			if(sheetObj.rowCount>0 && chkFlag){
				sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
				sheetObj.DoSearch("EES_CGM_2007GS.do", queryString+"&"+params);
				for(i=1; i<sheetObj.rowCount+1; i++){
					var verify = sheetObj.CellValue(i, "verify")
					// 필수 입력값 검증
					if(verify != "OK"){
						if(sheetObj.CellValue(i, "eq_no") == ""){
//							sheetObj.CellValue(i, "del_chk") = "1";
						} else {
							verifyFlag = true;
						}
					}
				}
				ComOpenWait(false);
				if(verifyFlag){
					// 상태 확인 메세지 
					ComShowCodeMessage("CGM10005");
					//return;
				}
			} else {
				// 행 선택 메세지
				ComShowCodeMessage("CGM10008");	
				return;
			}

			// Verify 가 OK 아니면   1.체크박스 선택 불가처리 및  2.글자색을 빨간색으로변경
			for(i=1; i<sheetObj.rowCount+1; i++){
				if(sheetObj.CellValue(i, "verify") == "OK" && sheetObj.CellValue(i, "del_chk") == "1"){
					sheetObj.CellEditable(i, "del_chk") = true;
					sheetObj.CellEditable(i, "eq_no") = false;
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 0);
					sheetObj.RowStatus(i) = "I";
					if(formObj.ownleas[0].checked == false  ){
						sheetObj.CellEditable(i, "eq_tpsz_cd")       = false;
						sheetObj.CellEditable(i,"eq_spec_no")        = false;
						sheetObj.CellEditable(i,"mgst_mchn_ser_no")  = false;
						sheetObj.CellEditable(i,"mgst_vltg_capa")    = false;
					}
					
				} else if(sheetObj.CellValue(i, "verify") != "OK" && sheetObj.CellValue(i, "del_chk") == "1"){
					sheetObj.CellValue(i, "del_chk") = "0";
					sheetObj.CellEditable(i, "del_chk")          = true;
					sheetObj.CellEditable(i, "mft_dt")           = true;
					sheetObj.CellEditable(i, "eq_tpsz_cd")       = true;
					sheetObj.CellEditable(i,"eq_spec_no")        = true;
					sheetObj.CellEditable(i,"mgst_mchn_ser_no")  = true;
					sheetObj.CellEditable(i,"mgst_vltg_capa")    = true;
					sheetObj.CellEditable(i,"mgst_fuel_capa")    = true;
					
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
				}
			}
			break;

			 case IBSAVE:        //저장
		 		var actionFlag = false; 
	 		    var VerifyFlag = false; 
				if(formObj.onh_ofc_cd.value == ""){
					ComShowCodeMessage("CGM10004", "Office");
					formObj.onh_ofc_cd.focus();
					return;
				}
				if(formObj.onh_dt.value == ""){
					ComShowCodeMessage("CGM10004", "On-Hire Date");
					formObj.onh_dt.focus();
					return;
				}
				if(formObj.onh_yd_cd.value == ""){
					ComShowCodeMessage("CGM10004", "On-Hire Yard");
					formObj.onh_yd_cd.focus();
					return;
				}
				if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
					 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
				 	 formObj.onh_yd_cd.focus();
				     return false;
				}
				if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
					ComShowCodeMessage("CGM10004", "Agreement No");
					formObj.agreement_no.focus();
					return;
				}
				formObj.f_cmd.value = MULTI;
				for(i=1; i<sheetObj.rowCount+1; i++){
					var verify = sheetObj.CellValue(i, "verify");
					if(verify == "OK" && sheetObj.CellValue(i, "del_chk") == "1"){
						// 필수 입력값 검증
						sheetObj.CellValue(i, "onh_dt")       =  formObj.onh_dt.value ;
						if(formObj.ownleas[1].checked){
							sheetObj.CellValue(i, "agreement_no") =  formObj.agreement_no.value ;
							sheetObj.CellValue(i, "agmt_ver_no")  =  formObj.agmt_ver_no.value ;
							sheetObj.CellValue(i, "vndr_seq")     =  formObj.vndr_seq.value ;
						}
						
						sheetObj.CellValue(i, "onh_yd_cd")    =  formObj.onh_yd_cd.value ;
						sheetObj.CellValue(i, "onh_ofc_cd")   =  formObj.onh_ofc_cd.value ;
						sheetObj.CellValue(i, "own_lse")   = formObj.own_lse.value;
						sheetObj.CellValue(i, "eq_knd_cd") = formObj.eq_knd_cd.value;
						
						sheetObj.CellValue(i, "agmt_lstm_cd") =  formObj.agmt_lstm_cd.value ;
						
						sheetObj.RowStatus(i) = "I";
						actionFlag = true; 
					}
					else if(verify == "" && sheetObj.CellValue(i, "del_chk")== "1" ) {
						ComShowCodeMessage("CGM10004", "verify");
						sheetObj.RowStatus(i) = "R";
						actionFlag = false; 
						break;
					}
					else if(verify != "OK" && sheetObj.CellValue(i, "del_chk")== "1" ) {
						sheetObj.RowStatus(i) = "R";
						VerifyFlag = true; 
						break;
					}
					else {
						sheetObj.RowStatus(i) = "R";
					}
				}
				
				if(VerifyFlag){
			        	ComShowCodeMessage("CGM10005");
		        }else if(actionFlag){
					var params = sheetObj.GetSaveString(true);
					formObj.f_cmd.value = MULTI;
					queryString = "f_cmd=" + MULTI ;
					sheetObj.WaitImageVisible=false;
			 	    ComOpenWait(true);
					if(sheetObj.DoSave("EES_CGM_2007GS.do", FormQueryString(formObj)))
					{
						
					}
					 ComOpenWait(false);
				}
				else
				{
					ComShowCodeMessage("CGM10008");
				}
				// CONFIRM
				
             break;

		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCH12;
		    formObj.agmt_no.value = formObj.agreement_no.value;
		    var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj));
		    
		    // 데이터 건수
		    var dataCount = ComGetTotalRows(sXml);
		    
		    // 데이터가 존재할 경우
		    if(dataCount > 0){
		    	
		    	var lstmCd                    = DomXml2String(sXml,"agmt_lstm_cd");
		    	
		        if(formObj.ownleas[0].checked == true  ){
			       	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){ 
						 ComShowCodeMessage("CGM10067",formObj.agreement_no.value);
			           	 return false;
			       	 } else {
			       		formObj.agreement_no.value    = DomXml2String(sXml,"agmt_no");
			        	formObj.agmt_ref_no.value     = DomXml2String(sXml,"agmt_ref_no");
			        	formObj.agmt_lstm_cd.value    = DomXml2String(sXml,"agmt_lstm_cd");
			        	// AGREEMENT NO POST PROCESS CALL
			        	formObj.vndr_lgl_eng_nm.value = DomXml2String(sXml,"vndr_lgl_eng_nm");
			        	formObj.vndr_seq.value        = DomXml2String(sXml,"vndr_seq");
			        	formObj.agmt_ver_no.value     = DomXml2String(sXml,"agmt_ver_no");
			       	 }
		       	 
		        } else if(formObj.ownleas[1].checked == true ){
			       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
			       		 ComShowCodeMessage("CGM10068",formObj.agreement_no.value);
			           	 return false;
			       	 } else {
			       		formObj.agreement_no.value    = DomXml2String(sXml,"agmt_no");
			        	formObj.agmt_ref_no.value     = DomXml2String(sXml,"agmt_ref_no");
			        	formObj.agmt_lstm_cd.value    = DomXml2String(sXml,"agmt_lstm_cd");
			        	// AGREEMENT NO POST PROCESS CALL
			        	formObj.vndr_lgl_eng_nm.value = DomXml2String(sXml,"vndr_lgl_eng_nm");
			        	formObj.vndr_seq.value        = DomXml2String(sXml,"vndr_seq");
			        	formObj.agmt_ver_no.value     = DomXml2String(sXml,"agmt_ver_no");
			       	 }
		       	 
		        }
		    	return true;
		    } else {
		    	// Form Object 초기화
		    	ComShowCodeMessage("CGM10009","Agreement No");
		    	formObj.agreement_no.value    = "";
		    	formObj.agmt_ref_no.value     = "";
		    	formObj.agmt_lstm_cd.value    = "";
		    	formObj.vndr_lgl_eng_nm.value = "";
		    	formObj.vndr_seq.value        = "";
		    	return false;
		    }
            break;

        // LOAD EXCEL
		case IBLOADEXCEL:
	 			if (sheetObj.id == "sheet1") {
	 				sheetObj.RemoveAll(); 				
	 				sheetObj.LoadExcel();
	 			}
				// Expiry Date 가 PMNT인 경우 Data Disable
				for(i=1; i<sheetObj.rowCount+1; i++){
					
					if(formObj.ownleas[1].checked == true){ //Leased 
      					// 데이타가 존재하지 않을 경우
	  					sheetObj.CellValue2(i,"cre_usr_id")       = formObj.cre_id.value;
	  					sheetObj.CellEditable(i, "eq_tpsz_cd")       = true;
	 					sheetObj.CellEditable(i,"eq_spec_no")        = true;
	 					sheetObj.CellEditable(i,"mgst_mchn_ser_no")  = true;
	  					sheetObj.CellEditable(i,"mgst_vltg_capa")    = true;
	  					sheetObj.CellEditable(i,"mgst_fuel_capa")    = true;
	  					sheetObj.CellValue2(i,"eq_tpsz_cd")          = "UMG";
					}else{	//OWN					
						// chungpa 20100115 1008, 2007 : Own 장비의 verify 시 입력된 eq_no 별 agmt_no(agmt_ver_no 포함) 를 조회하여 가져오도록 event 발생 처리.
						// start
				     	formObj.f_cmd.value = SEARCH;
						formObj.eq_no.value = sheetObj.CellValue(i, "eq_no");
						if(formObj.eq_no.value !=""){
							var sXml = sheetObj.GetSearchXml("EES_CGM_2007GS.do", FormQueryString(formObj));
					 		var dataCount = ComGetTotalRows(sXml);
					 		if(dataCount > 0){
								sheetObj.CellValue2(i,"agreement_no")     = DomXml2String(sXml,"agreement_no");
								sheetObj.CellValue2(i,"agmt_ver_no")      = DomXml2String(sXml,"agmt_ver_no");
								sheetObj.CellValue2(i,"vndr_seq")         = DomXml2String(sXml,"vndr_seq");
								sheetObj.CellValue2(i,"eq_tpsz_cd")    = DomXml2String(sXml,"eq_tpsz_cd");
							} else {
								sheetObj.CellValue2(i,"eq_no") = "";
								ComShowCodeMessage("CGM20003");
							}
						}			
						// chungpa 20100115 1008, 2007 : Own 장비의 verify 시 입력된 eq_no 별 agmt_no(agmt_ver_no 포함) 를 조회하여 가져오도록 event 발생 처리.
						// end			
					}
				}
	 			break;
		case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
		   	formObj.f_cmd.value = COMMAND01;
		   	formObj.ofc_cd.value = formObj.onh_ofc_cd.value;
		   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
		   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
		   	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Office');
		   		formObj.onh_ofc_cd.value = "";
		   		formObj.onh_ofc_cd.focus();
		   	} else {
		   		formObj.onh_yd_cd.focus();
		   		Matched_Chk('Office');
		   	}
		   	
		   	break;
		case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
		   	formObj.f_cmd.value = COMMAND01;
		   	formObj.yd_cd.value = formObj.onh_yd_cd.value;
		   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
		   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
		   	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Yard');
		   		formObj.onh_yd_cd.value = "";
		   		formObj.onh_yd_cd.focus();
		   	} else {
		   		formObj.onh_dt.focus();
		   		Matched_Chk('Yard');
		   	}
		   	break;
		case SEARCH03: //그리드내  다중콤보(TYPE/SIZE)
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"comboList");
			var arrStr = sStr.split("@");
	        var arrCode1 ="";
	        var arrCode2 ="";
	        
	        for (var i = 0; i < arrStr.length;i++ ) {
	        	var arrCode = arrStr[i].split("|");
	        	if(i==0){
	        		arrCode1 = arrCode1+" " +"|"+ arrCode[1];
	        		arrCode2 = arrCode2+" " +"|"+ arrCode[0];
	        	} else {
	        		arrCode1 = arrCode1 +"|"+ arrCode[1];
	        		arrCode2 = arrCode2 +"|"+ arrCode[0];
	        	}
	        }
	        sheetObj.InitDataCombo(0, "eq_spec_no",   arrCode1,   arrCode2, "", "", 0);
		 	break;
		case SEARCH04: //그리드내  다중콤보(TYPE/SIZE)
	        formObj.f_cmd.value = SEARCH04;
	        var sXml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
	        var sStr = ComGetEtcData(sXml,"comboList");
	        var arrStr = sStr.split("@");
	        var arrCode1 ="";
	        var arrCode2 ="";
	        for (var i = 0; i < arrStr.length;i++ ) {
	        	var arrCode = arrStr[i].split("|");
	        	if(i==0){
	        		arrCode1 = arrCode1+" " +"|"+ arrCode[0];
	        		arrCode2 = arrCode2+" " +"|"+ arrCode[1];
	        	} else {
	        		arrCode1 = arrCode1 +"|"+ arrCode[0];
	        		arrCode2 = arrCode2 +"|"+ arrCode[1];
	        	}
	        }
	        sheetObj.InitDataCombo(0, "eq_tpsz_cd",   arrCode1,   arrCode2, "", "", 0);
		 	break;
		    // LOAD EXCEL
 
			
     }
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
  * Tab 기본 설정
  * 탭의 항목을 설정한다.
  */
 function initTab(tabObj , tabNo) {
      switch(tabNo) {
          case 1:
             with (tabObj) {

             }
          break;

      }
 }

 /**
  * Tab 클릭시 이벤트 관련
  * 선택한 탭의 요소가 활성화 된다.
  */
 function tab1_OnChange(tabObj , nItem)
 {


     var objs = document.all.item("tabLayer");

 	objs[nItem].style.display = "Inline";
 	objs[beforetab].style.display = "none";

 	//--------------- 요기가 중요 --------------------------//
 	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
 	//------------------------------------------------------//
 	beforetab= nItem;
		

 }



 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//         if (!isNumber(formObj.iPage)) {
//             return false;
//         }
     }

     return true;
 }
 /** 
  * Object 의 change 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 최민회
  * @version 2009.05.20
  */  
     function obj_focusout(){
     	 var formObj = document.form;
     	 var sheetObj = sheetObjects[0]; 
     	 obj = event.srcElement;
     	 switch(obj.name){
  	 
     	   case "onh_ofc_cd":
     	 		if(formObj.onh_ofc_cd.value != ''){
     	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
     	 			Verify_Status_chk();
     	 			break;
     	 		} 
     	   // chungpa 20100414 keyup->focusout start     	 		
     	   case "onh_yd_cd":
	       	    var onh_yd_cd;
	   	    	onh_yd_cd = formObj.onh_yd_cd.value;
	   	    	if (onh_yd_cd.length == 7) {
	   	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	   	    	}
				break;
  		  // chungpa 20100414 keyup->focusout end
     	   case "agreement_no":
     		   
     		   if(formObj.agreement_no.value != ''){
       	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
       	 		    Verify_Status_chk();
       	 			break;
     		   }else if(formObj.agreement_no.value == ''){
    			   formObj.agmt_ref_no.value ="";
    			   formObj.agmt_lstm_cd.value ="";
    			   formObj.vndr_lgl_eng_nm.value ="";
    			   Verify_Status_chk();
      	 			break;
    		   }
     		   break;
    	   case "onh_dt":
    		   
    		   if(formObj.onh_dt.value != ''){
      	 			if(ComGetUnMaskedValue(formObj.onh_dt.value, "ymd") > ComGetUnMaskedValue(formObj.form_day.value, "ymd")){
      	 				ComShowCodeMessage("CGM10062");
      	 				formObj.onh_dt.value ="";
      	 				formObj.onh_dt.focus();
      	 			}
    		   } 
    		   Verify_Status_chk();
    		   break;

    	   case "onh_dt_hm" :
	    	   Verify_Status_chk();
			   break;
     	 }   
     }

 /**
  * YA_CD 값 체크
  * @return
  */
 function obj_keyup(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
	 	case "onh_yd_cd":
		    // chungpa 20100414 keyup->focusout start
		    ComKeyEnter('lengthnextfocus');
		    /*
    	    var onh_yd_cd;
	    	onh_yd_cd = formObj.onh_yd_cd.value;
	    	if (onh_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	}
	    	*/
		    // chungpa 20100414 keyup->focusout end
	    	break;
	 }
}
 /**
  * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
  */
 function obj_keypress(){
 	 obj = event.srcElement;
 	 if(obj.dataformat == null){
 		 return;
 	 }
 	 window.defaultStatus = obj.dataformat;
 	 
 	 switch(obj.dataformat) {
   	    case "engup":
     		ComKeyOnlyAlphabet("uppernum");
 	        break;
   	    case "enghi":
   	    	ComKeyOnlyAlphabet("upper");
   	    	break;
 	    case "isnum":
 	    	ComKeyOnlyNumber(obj);
 	    	break;
 	    case "int":
  	    	ComKeyOnlyNumber(obj);
  	        break;
  	    // 일달력
   	 	case "ymd":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	  	   // 월달력
   	 	case "ym":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	  	   // 시분
   	 	case "hm":
   	 		ComKeyOnlyNumber(obj);
   	        break;
 	 }
 }
  /**
   * AXON 이벤트 처리
   */
  function obj_activate(){
      ComClearSeparator(event.srcElement);
  }


  /** 
   * OBJECT DEACTIVATE 이벤트에 대한 처리  <br>
   */
  function obj_deactivate(){
  	var formObj = document.form;
  	obj = event.srcElement;
  	
  	if(obj.name == "onh_dt"){
  		with(formObj){
  			var creDtFr = ComReplaceStr(onh_dt.value, "-", "");
  		}
          ComChkObjValid(event.srcElement);
  	}
  }

   /**
    * PROGRAMNO POPUP 에서 해당하는 값들 입력부분.
    */   
   function setProgramNo(aryPopupData, row, col, sheetIdx){
   	 var formObj  = document.form;
   	 var sheetObj = sheetObjects[0];
   	 var agreeNo  = "";
   	 var referNo  = "";
   	 var lessNm   = "";
   	 var lstmCd   = "";
   	 var vndrSq   = "";
   	 var agmtVerNo   = "";
   	 var i = 0;
   	 for(i = 0; i < aryPopupData.length; i++){
   /*
   		 //유지보수시 값 확인 하기 위하여 아래 로그 남겨 놓음 지우지 마세요.
   		 ComShowMessage(aryPopupData[i][0]); // 1
   		 ComShowMessage(aryPopupData[i][1]); // 0
   		 ComShowMessage(aryPopupData[i][2]); // NYC000027
   		 ComShowMessage(aryPopupData[i][3]); // ZOWGN85003
   		 ComShowMessage(aryPopupData[i][4]); // OW
   		 ComShowMessage(aryPopupData[i][5]); // 111635
   		 ComShowMessage(aryPopupData[i][6]); // SM Line Corporation
   		 ComShowMessage(aryPopupData[i][7]); // 19930601
   		 ComShowMessage(aryPopupData[i][8]); // 20101231
   		 ComShowMessage(aryPopupData[i][9]); // SELCOE
   		 ComShowMessage(aryPopupData[i][10]);// 19980329  
   */
   		 vndrSq   = vndrSq  + aryPopupData[i][5];  // vndr_seq
   		 agreeNo  = agreeNo + aryPopupData[i][2];  // agreement_no
   		 referNo  = referNo + aryPopupData[i][3];  // reference_no
   		 lstmCd   = lstmCd  + aryPopupData[i][4];  // lease term
   		 lessNm   = lessNm  + aryPopupData[i][6];  // lessor
   		 agmtVerNo = aryPopupData[i][11];  // lessor
   	 }
   	 
        if(formObj.ownleas[0].checked == true  ){
	       	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
	       		 ComShowCodeMessage("CGM10067",agreeNo);
	           	 return false;
	       	 } else {
	       		 formObj.vndr_seq.value        = vndrSq;
	       		 formObj.agreement_no.value    = agreeNo;
	       		 formObj.agmt_ref_no.value     = referNo;
	       		 formObj.agmt_lstm_cd.value    = lstmCd;
	       		 // AGREEMENT NO POST PROCESS CALL
	       		 formObj.vndr_lgl_eng_nm.value = lessNm;
	       		 formObj.agmt_ver_no.value     = agmtVerNo;
	       	 }
       	 
        } else if(formObj.ownleas[1].checked == true ){
	       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
	       		 ComShowCodeMessage("CGM10068",agreeNo);
	           	 return false;
	       	 } else {
	       		 formObj.vndr_seq.value        = vndrSq;
	       		 formObj.agreement_no.value    = agreeNo;
	       		 formObj.agmt_ref_no.value     = referNo;
	       		 formObj.agmt_lstm_cd.value    = lstmCd;
	       		 // AGREEMENT NO POST PROCESS CALL
	       		 formObj.vndr_lgl_eng_nm.value = lessNm;
	       		 formObj.agmt_ver_no.value     = agmtVerNo;
	       	 }
       	 
        }
        
   	
   }

    /**
     * 선택된 ROW 삭제 
     */
    function rowDelete(sheetObj){
    	for(i=sheetObj.rowCount; i>0; i--){
    		if(sheetObj.CellValue(i, "ibflag") != ""   &&  sheetObj.CellValue(i, "del_chk") == "1") {
    			sheetObj.RowDelete(i, false);
    		}
    	}
    }
     
     /**
      * 시트내 팝업 클릭(달력 호출)
      */
     function sheet1_OnPopupClick(sheetObj, row, col){
     	switch (sheetObj.ColSaveName(col)) {
     	case "mft_dt" :
     		if (sheetObj.ColSaveName(col) != "mft_dt"){
     			return;
     		}
     		var cal = new ComCalendarGrid("myCal");
     		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
     		break;

//     	case "chss_rgst_exp_dt" :
//     		if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt"){
//     			return;
//     		}
//     		var cal = new ComCalendarGrid("myCal");
//     		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
//     		break;
     	}
     }
      
      /**
       * SHEET1 ONCHANGE EVENT
       */
      function sheet1_OnChange(sheetObj, Row, Col, Value) {
      	var formObj   = document.form;
      	var sheetObj  = sheetObjects[0];
      	
      	var targetCol = sheetObj.SaveNameCol("eq_no");
      	var eqNo      = sheetObj.CellValue(Row, "eq_no");
      	
      	with(sheetObj){
      		var colName = colSaveName(Col);
      		switch(colName){
      		case "eq_no":
      	     	formObj.f_cmd.value = SEARCH;
      			formObj.eq_no.value = eqNo;
      			
      			if(Row >1){
      				// chassis no 체크
      				for(i=1; i<sheetObj.rowCount; i++){

      					if(sheetObj.CellValue(i, "eq_no")== Value && Row != i && sheetObj.CellValue(i, "eq_no")!='')
       					{
      						// 체크 메시지 출력
      			        	//ComShowMessage('CGM20007');      			        
							ComShowCodeMessage("CGM20004",sheetObj.CellValue(i, "eq_no") );
      			        	// 해당 Cell 값을 Null로 설정
      						sheetObj.CellValue(Row, "eq_no") = "";
      			        	return false;
       					}
      				}
      				
      				 
      			} 
      		
      			if(formObj.eq_no.value !=""){
      				var sXml = sheetObj.GetSearchXml("EES_CGM_2007GS.do", FormQueryString(formObj));
      		 		//ComShowMessage("####### "+sXml);
      		 		// 데이터 건수
      		 		var dataCount = ComGetTotalRows(sXml);
      		 		
      		 		if(dataCount > 0){
      					var lstmCd = DomXml2String(sXml,"agmt_lstm_cd");
      					if(formObj.ownleas[1].checked == true){
      						if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
      				       		 ComShowCodeMessage("CGM10068",formObj.eq_no.value);
      				           	 return false;
      				       	 }
      						sheetObj.CellValue2(Row,"cre_usr_id")   = DomXml2String(sXml,"cre_usr_id");
      					} else {
      						sheetObj.CellValue2(Row,"cre_usr_id")   = "";
      						if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
      				       		 ComShowCodeMessage("CGM10067",formObj.eq_no.value);
      				           	 return false;
      				       	} 
      					}
      					
      					sheetObj.CellValue2(Row,"eq_tpsz_cd")       = DomXml2String(sXml,"eq_tpsz_cd");
      					sheetObj.CellValue2(Row,"mft_dt")           = DomXml2String(sXml,"mft_dt");
      					sheetObj.CellValue2(Row,"eq_spec_no")       = DomXml2String(sXml,"eq_spec_no");
      					sheetObj.CellValue2(Row,"mgst_mchn_ser_no") = DomXml2String(sXml,"mgst_mchn_ser_no");
      					sheetObj.CellValue2(Row,"mgst_vltg_capa")   = DomXml2String(sXml,"mgst_vltg_capa");
      					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = DomXml2String(sXml,"mgst_fuel_capa");
      					sheetObj.CellValue2(Row,"cre_usr_id")       = DomXml2String(sXml,"cre_usr_id");
      					
      					sheetObj.CellValue2(Row,"agreement_no")     = DomXml2String(sXml,"agreement_no");
      					sheetObj.CellValue2(Row,"agmt_ver_no")      = DomXml2String(sXml,"agmt_ver_no");
      					sheetObj.CellValue2(Row,"vndr_seq")         = DomXml2String(sXml,"vndr_seq");
      					sheetObj.CellEditable(Row, "eq_tpsz_cd")       = true;
  						sheetObj.CellEditable(Row,"eq_spec_no")        = true;
  						sheetObj.CellEditable(Row,"mgst_mchn_ser_no")  = true;
  						sheetObj.CellEditable(Row,"mgst_vltg_capa")    = true;
  						sheetObj.CellEditable(Row,"mgst_fuel_capa")    = true;
      					
      				} else {
      					// 데이타가 존재하지 않을 경우
//      					ComShowMessage("데이타가 존재하지 않을 경우");
      					sheetObj.CellValue2(Row,"eq_tpsz_cd")       = "";
      					sheetObj.CellValue2(Row,"mft_dt")           = "";
      					sheetObj.CellValue2(Row,"eq_spec_no")       = "";
      					sheetObj.CellValue2(Row,"mgst_mchn_ser_no") = "";
      					sheetObj.CellValue2(Row,"mgst_vltg_capa")   = "";
      					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = "";
      					sheetObj.CellValue2(Row,"agreement_no")     = "";
      					sheetObj.CellValue2(Row,"agmt_ver_no")      = "";
      					sheetObj.CellValue2(Row,"vndr_seq")         = "";
      					sheetObj.CellValue2(Row,"cre_usr_id")       = formObj.cre_id.value;
      					if(formObj.ownleas[0].checked == true){
 
      						ComShowCodeMessage("CGM20003");
      			        	// 해당 Cell 값을 Null로 설정
      						sheetObj.CellValue(Row, "eq_no") = "";
      						return false;
      					} else {
      						sheetObj.CellEditable(Row, "eq_tpsz_cd")       = true;
      						sheetObj.CellEditable(Row,"eq_spec_no")        = true;
      						sheetObj.CellEditable(Row,"mgst_mchn_ser_no")  = true;
      						sheetObj.CellEditable(Row,"mgst_vltg_capa")    = true;
      						sheetObj.CellEditable(Row,"mgst_fuel_capa")    = true;
      						sheetObj.CellValue2(Row,"eq_tpsz_cd")          = "UMG";
      					}
      				}
      			} else {
    				// 데이타가 존재하지 않을 경우
    				sheetObj.CellValue2(Row,"eq_tpsz_cd")       = "";
  					sheetObj.CellValue2(Row,"mft_dt")           = "";
  					sheetObj.CellValue2(Row,"eq_spec_no")       = "";
  					sheetObj.CellValue2(Row,"mgst_mchn_ser_no") = "";
  					sheetObj.CellValue2(Row,"mgst_vltg_capa")   = "";
  					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = "";
  					sheetObj.CellValue2(Row,"agreement_no")     = "";
  					sheetObj.CellValue2(Row,"agmt_ver_no")      = "";
  					sheetObj.CellValue2(Row,"vndr_seq")         = "";
  					sheetObj.CellValue2(Row,"cre_usr_id")       = formObj.cre_id.value;
  					sheetObj.CellEditable(Row, "eq_tpsz_cd")       = false;
					sheetObj.CellEditable(Row,"eq_spec_no")        = false;
					sheetObj.CellEditable(Row,"mgst_mchn_ser_no")  = false;
					sheetObj.CellEditable(Row,"mgst_vltg_capa")    = false;
					sheetObj.CellEditable(Row,"mgst_fuel_capa")    = false;
    			}
      			break;
      		case "eq_spec_no":
      			formObj.f_cmd.value = SEARCH01;
      			formObj.eq_spec_no.value = sheetObj.CellValue(Row, "eq_spec_no");
      			if(formObj.eq_spec_no.value !=""){
      				var sXml = sheetObj.GetSearchXml("EES_CGM_2007GS.do", FormQueryString(formObj));
      		 		//ComShowMessage("####### "+sXml);
      		 		// 데이터 건수
      		 		var dataCount = ComGetTotalRows(sXml);
      		 		
      		 		if(dataCount > 0){
      		 			sheetObj.CellValue2(Row,"mgst_vltg_capa")   = DomXml2String(sXml,"mgst_vltg_capa");
      					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = DomXml2String(sXml,"mgst_fuel_capa");
      		 		} else {
      		 			sheetObj.CellValue2(Row,"mgst_vltg_capa")   = "";
      					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = "";
      		 		}
      			} else {
      				sheetObj.CellValue2(Row,"mgst_vltg_capa")   = "";
  					sheetObj.CellValue2(Row,"mgst_fuel_capa")   = "";
      			}

      		    break;
      		}
      	}
      }
      
/**
 * OWN, Leased 라디오 버튼
 */
function obj_onclick(radioObj){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	if(formObj.ownleas[0].checked == true){
		formObj.own_lse.value = "O";
	} else {
		formObj.own_lse.value = "L";
	}
}
 
 /**
 * OWN,Leased 선택시 화면 초기 화 
 * @param a
 * @return
 */
 function chk(a){
   	var formObj = document.form;
   	 var sheetObj = sheetObjects[0]; 
   	 sheetObj.RemoveAll();
			// HTML OBJECT RESET
   	 formObj.reset();
   	 if(a=="O"){
   		 formObj.ownleas[0].checked = true;
   	 } else {
   		 formObj.ownleas[1].checked = true;
   	 }
     formObj.own_lse.value=a;
   	 yard_Chk();
   }
 
//저장후 조회 기능 
 function sheet1_OnSaveEnd(sheetObj, errMsg) {
	 if(errMsg =='') {   
		  ComShowCodeMessage('CGM00003');
          for(i=sheetObj.LastRow; i>0; i--){
			  if(sheetObj.CellValue(i, "del_chk") == "1" ){
				  sheetObj.RowDelete(i, false);
			  } 
		  }
	 }
 }    


/**
* Form 의 Date yard 제어
* @return
* @author 최민회
* @version 2009.06.04
*/
function yard_Chk(){
	  formObj = document.form;
	  var l_chk ,f_chk;
	  var l_cName,f_cName;
	  if(formObj.ownleas[0].checked == true){

		  l_chk = true;
		  f_chk = false;
		  l_cName = "input2";
		  formObj.agreement_no.value="";
	  } else {
		  l_chk = false;
		  f_chk = true;
		  l_cName = "input1";
	  }
	  
	  formObj.agreement_no.readOnly = l_chk;
     ComEnableObject(formObj.ComOpenPopupWithTargetAgree, f_chk);
     formObj.agreement_no.className = l_cName;
}

/**
 * 야드와 오피스 체크
 * @param chk
 * @return
 */
function Matched_Chk(chk){
	 formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 if(formObj.onh_yd_cd.value != "" && formObj.onh_ofc_cd.value != "" ){
		 
		    formObj.f_cmd.value = SEARCH01;
		    formObj.ofc_cd.value = formObj.onh_ofc_cd.value;		//   ( location)
		    formObj.loc_cd.value = formObj.onh_yd_cd.value.substr(0,5);
	   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
		    if(DomXml2String(sXml, "chk")!="OK"){
				ComShowCodeMessage("CGM10028");
				if(chk == 'Yard'){
					formObj.onh_yd_cd.value = "";
					formObj.onh_yd_cd.focus();
				} else {
					formObj.onh_ofc_cd.value = "";
					formObj.onh_ofc_cd.focus();
				}
				
				return;
		    }
		 
	 }
	 
}

function Verify_Status_chk(){
	 var sheetObj = sheetObjects[0];
	 for(i=1; i<sheetObj.rowCount+1; i++){
		 sheetObj.CellValue(i, "verify") = "";
	 }
	 
}

/**
  * 엑셀 업로드시 체크
  * @param sheetObj
  * @return
  */
function sheet1_OnLoadExcel(sheetObj){
  var formObj   = document.form;  
  for(iChk=1; iChk<sheetObj.rowCount+1; iChk++){
		
		var cellValue = sheetObj.cellValue(iChk, "eq_spec_no"); 
//		alert(sheetObj.cellValue(iChk, "eq_spec_no"));
		
		if (cellValue != ''){
			formObj.f_cmd.value = SEARCH01;
		    formObj.eq_spec_no.value = sheetObj.CellValue(iChk, "eq_spec_no");
		    
	 		//alert(Row);
		    if(formObj.eq_spec_no.value !=""){
				var sXml = sheetObj.GetSearchXml("EES_CGM_2007GS.do", FormQueryString(formObj));
		 		//ComShowMessage("####### "+sXml);
		 		// 데이터 건수
		 		var dataCount = ComGetTotalRows(sXml);
		 		
		 		if(dataCount > 0){
		 			sheetObj.CellValue2(iChk,"mgst_vltg_capa")   = DomXml2String(sXml,"mgst_vltg_capa");
					sheetObj.CellValue2(iChk,"mgst_fuel_capa")   = DomXml2String(sXml,"mgst_fuel_capa");
		 		} else {
		 			sheetObj.CellValue2(iChk,"mgst_vltg_capa")   = "";
					sheetObj.CellValue2(iChk,"mgst_fuel_capa")   = "";
		 		}
			} else {
				sheetObj.CellValue2(iChk,"mgst_vltg_capa")   = "";
				sheetObj.CellValue2(iChk,"mgst_fuel_capa")   = "";
			}
		}
	}
  
}

/* 개발자 작업 끝 */
