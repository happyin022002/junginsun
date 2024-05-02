/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3005.js
*@FileTitle : Charge Inquiry by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.07 황효근
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
     * @class ees_dmt_3005 : ees_dmt_3005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_3005() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var USR_TRF_TP;

	// 버튼 기능 구분을 위한  Action 변수 정의
	var IBPRECAL	= 99;
	var IBCONFIRM	= 97;
	var IBDELCANCEL = 96;
	var IBDRSAVE	= 94;
	var IBCHKBKGNO	= 93;
	
	// BKG No 체크시   이벤트 충돌에 따른 중복 처리를 방지하기 위한  FLAG 전역변수
 	var G_BKGNO_CHK_FLG = false;
 	var timer;
 	
	// 'Retrieve 버튼' 마우스 클릭시 실행 로직을 위한 전역변수
	var G_CHANGE_SKIP = false;
	
	// BKG_NO Validation 결과
	var G_BKGNO_CHK_OK = false;
	
	// BKG_NO, BL_NO 중  onchange 이벤트가 발생한 객체
	var G_CHANGE_OBJ = null;
	

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObj1 = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
     		// 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
     		if(!ComIsBtnEnable(srcName)) return;

             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj1,formObj,IBPRECAL);
					break;
					
             	case "btn_DRSave":
             		doActionIBSheet(sheetObj1,formObj,IBDRSAVE);
					break;
				
             	case "btn_Retrieve":
             		// formObj의 bkg_no에 강제로 onchange 이벤트를 발생
             		if( ComGetObjValue(formObj.bkg_no) != '' || ComGetObjValue(formObj.bl_no) != '') {
             			var chgObj = G_CHANGE_OBJ;
             			if(chgObj == null) chgObj = formObj.bkg_no;
             			
             			G_CHANGE_SKIP = false;
             			chgObj.fireEvent("onchange");
             			
             			if(!G_BKGNO_CHK_OK) return;
             		}
             		
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;

				case "btn_New":
					doInit();
					break;
					
				case "btn_Minimize":
					var miniDiv = document.getElementById("mini_div");
 					if(miniDiv.style.display == 'block') {
 						miniDiv.style.display = 'none';
 						sheetObj1.style.height = 455;
 					} else {
 						miniDiv.style.display = 'block';
 						sheetObj1.style.height = 278;
 					}
					break;
					
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj1,formObj,IBCONFIRM);
 					break;
 					
 				case "btn_DELCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDELCANCEL);
 					break;
 					
 				case "btn_DownExcel":
 					sheetObj1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
 					break;
 					
 				case "btn_Close":
 					//window.returnValue = "Y";
					window.close();
					break;
 					
 				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObj.dr_dt, 'yyyy-MM-dd');
					break;
 					
 				//----------- 팝업 처리 --------------------	
 				case "btn_Demand":
 				case "btn_Billing":
 				case "btn_OFCTrans":
 				case "btn_Delete":
 				case "btn_ByETA":
 				case "btn_ByCNTR":
 				case "btn_ROInfo":
 				case "btn_MVMTInq":
 				case "btn_ExceptionInq":
 					doProcessPopup(srcName);
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
     
     //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}


     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	 
    	 // 팝업으로 호출시에 타이틀 표시 처리
    	 if(ComGetObjValue(document.form.call_flag) == "P") {
			var spanObj = document.getElementById("title2");
			spanObj.innerText = " Charge Inquiry by Booking";
			ComSetDisplay('btnCloseLayer', true);
		 }
    	  
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         // IBMultiCombo초기화 
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],k+1);
         }
  
         //html컨트롤 이벤트초기화
         initControl();
	}

     
     function initControl() {
 		axon_event.addListenerFormat('keypress',	'obj_keypress', document.form); // 키보드 입력할때
 		axon_event.addListener('focus',		'obj_focus',		'bkg_no', 'bl_no', 'dr_dt');
 		axon_event.addListener('keydown',	'obj_keydown',		'form');
 		axon_event.addListener('click',		'byPODDTA_click',	'bypodeta');
 		axon_event.addListener('mouseover', 'obj_mouseover',	'tdROffice', 'tdDRDate');	// 말풍선 표시
		axon_event.addListener('mouseout',	'obj_mouseout',		'tdROffice', 'tdDRDate');	// 말풍선 숨김
 		axon_event.addListener('blur',		'obj_blur',			'dr_dt');
 		axon_event.addListener('change',	'obj_change',		'bkg_no', 'bl_no');
 		axon_event.addListener('mousedown', 'obj_mousedown',	'btn_Retrieve');
      }
 	
 	
	// 'by ETA' onMouseover 이벤트  (버튼 말풍선  보여줌)
 	function obj_mouseover() {
 		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;
 		
     	switch(event.srcElement.id){
      		case 'tdROffice':
      			msg = "Cargo Release Office";
      			x = x;
      			y = y-20;
      			break;
      			
      		case 'tdDRDate':
      			msg = "Delivery & Return Date";
      			x = x;
      			y = y+20;
      			break;
     	}
 		
 		var bak = 'lightyellow';
 		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn = document.all("topdeck").style;
 		skn.left = x;
 		skn.top  = y;
 		document.all("topdeck").innerHTML = content;
 		skn.visibility = 'visible';
	}
      
	// 'by ETA' onMouseout 이벤트  (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
	skn.visibility = 'hidden';
	}

 	
 	function obj_keydown() {
 		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 		if (keyValue != 13) return;
 		
 		var obj = event.srcElement;
 		var formObj = document.form;
 		
 		if(!doCheckBKGNo(obj)) return;
 		
 		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 	}
 	
 	
	// 'Retrieve 버튼' 마우스 클릭시 실행 로직 - 1순위
	function obj_mousedown() {
		G_CHANGE_SKIP = true;
	}
	
 	
	// BKG No, BL No 입력값의  Validation을 처리하기 위한 이벤트 함수
	function obj_change() {
		var obj = event.srcElement;
		
		// BKG_NO, BL_NO 입력란 중  onchange 이벤트가 발생한 객체를 전역변수에 저장
		G_CHANGE_OBJ = obj;
		
		// 전역변수(G_CHANGE_SKIP)가 false일때만 실행
        if (!G_CHANGE_SKIP) {
	 		if(G_BKGNO_CHK_FLG) return;
	 		
	 		doCheckBKGNo(obj);
        }
		
		// BKG_NO, BL_NO Validation 로직이 다시 실행되게끔 전역변수(G_CHANGE_SKIP)를  false로 setting
		G_CHANGE_SKIP = false;
	}
 	
 	
	function doCheckBKGNo(obj) {
		var formObj = document.form;
		
		if(obj.name == 'bkg_no') {
			var bkgNo = ComGetObjValue(obj);
			
			if (bkgNo.length >= 11 && bkgNo.length <= 13) {
				G_BKGNO_CHK_FLG = true;
				doActionIBSheet(sheetObjects[0], formObj, IBCHKBKGNO, obj);
				G_BKGNO_CHK_FLG = false;
				
				if(!G_BKGNO_CHK_OK) return false;
				
			} else if(bkgNo != '') {
				ComShowCodeMessage('DMT00110', 'BKG No.');
				ComClearObject(formObj.bl_no);
				ComSetFocus(formObj.bkg_no);
				G_BKGNO_CHK_OK = false;
				return false;
			}
		} else if(obj.name == 'bl_no') { 
			 var blNo = ComGetObjValue(obj);
			 if (blNo.length == 12) {
				 G_BKGNO_CHK_FLG = true;
				 doActionIBSheet(sheetObjects[0], formObj, IBCHKBKGNO, obj);
				 G_BKGNO_CHK_FLG = false;
				 
				 if(!G_BKGNO_CHK_OK) return false;
				
			 } else if(blNo != '') {
				 ComShowCodeMessage('DMT00110', 'BL No.');
				 ComClearObject(formObj.bkg_no);
				 ComSetFocus(formObj.bl_no);
				 G_BKGNO_CHK_OK = false;
				 return false;
			 }
		}

		return true;
	}
 	
 	
	//포커스가 나갈 때
 	function obj_blur() {
 		//입력Validation 확인하기 + 마스크구분자 넣기
 		var obj = event.srcElement;
		ComChkObjValid(obj);
 	}
  	
     
  	/**
	* HTML Control Foucs in
	*/
  	function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
         
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
  	
     
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	
	
	// 버튼 상태 초기화
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_PreCal", "btn_ByCNTR", "btn_ROInfo", "btn_MVMTInq", "btn_DownExcel");
		
		document.getElementById("btn_PreCal").style.color = '';
		document.getElementById("btn_ROInfo").style.color = '';
	}


	/**
  	  * INIT SETTING
  	  */
  	function doInit() {
  		G_BKGNOCHK_OK = false;
  		
  		sheetObjects[0].CheckAll("chk") = 0;
  		ComResetAll();
  		initBtns();
  	}
	
  	// IBMultiCombo Office 초기화
   	function initComboValue_tariff_type() {
   		var formObj = document.form;
   		
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			// 'M'emu를 통해서 호출
   			comboObjects[0].Enable = true;
   			comboObjects[0].Code = USR_TRF_TP;
   			ComSetObjValue(formObj.usr_trf_tp, USR_TRF_TP);
   		} else {
   			// 'P'opup으로 호출
   			comboObjects[0].Enable = false;
   			comboObjects[0].Code = ComGetObjValue(formObj.dmdt_trf_cd);
   		}
   	}
   	
   	// IBMultiCombo Office 초기화
   	function initComboValue_status() {
		//comboObjects[1].Enable = true;
		comboObjects[1].CheckIndex(0) = true;
		status_OnCheckClick(comboObjects[1], 0, 'A');
   	}
   	
	// RHQ IBMultiCombo 초기화
   	function initComboValue_rhq_ofc() {
   		var formObj = document.form;
   		
   		// 로그인 User의 RHQ가 Default(SELHO는 All)
		var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
   		if(usrRhqOfcCd == 'SELHO')
   			usrRhqOfcCd = "All";
   		
   		ComSetObjValue(comboObjects[2], usrRhqOfcCd);
   	}
	
   	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 252;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 7, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(68, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);
                     
                     // Ctrl키를 눌러 다중행 선택가능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;

                     var HeadTitle1 = "||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|F/T|Over|Overdue|From DT|From DT|To DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT"
                     				+ "|Billable AMT|G/B|UC|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No.|ISS DT|INV Cur.|Billing AMT|A/R|WEB|Web M'ty|Grace End|PIC Name|Exception Day|Exception Cost|AFT DAR No.|AFT DAR Status|Inactive Status|bkgteu||||||||";
 												
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 			
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,0,daCenter, true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,30,	daCenter,	true,	"chk");
                     InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,	true,	"seq");
                     InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"dmdt_chg_sts_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"cntr_no",			false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"ofc_cd",			false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"to_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"fm_mvmt_sts_cd",	false,	"",	dfNone,		0,	false,	false);
                     									
                     InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"to_mvmt_sts_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"ft_dys",			false,	"",	dfInteger,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"fx_ft_ovr_dys",	false,	"",	dfInteger,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	60,	daCenter,	true,	"ovr_due",			false,	"",	dfInteger,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"fm_mvmt_dt_time",	false,	"",	dfTimeHm,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"to_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"to_mvmt_dt_time",	false,	"",	dfTimeHm,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_cmnc_dt",		false,	"",	dfDateYmd,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_end_dt",		false,	"",	dfDateYmd,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bzc_trf_curr_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,    100,daRight,	true,	"org_chg_amt",		false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,    100,daRight,	true,	"sc_rfa_expt_amt",	false,	"",	dfNullFloat,2,	false,	false); 

                     InitDataProperty(0, cnt++ , dtData,    100,daRight,	true,	"aft_expt_dc_amt",	false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,    100,daRight,	true,	"bil_amt",			false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"chg_type",			false,	"",	dfNone,		0,	false,	false, -1, false, true, "General/Balance Charge Type");
 				     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"uclm_flg",			false,	"",	dfNone,			0,	false,	true, -1, false, true, "Uclaimed Cargo Flag");
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"soc_flg",			false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"li",				false,	"",	dfNone,		0,	false,	false, -1, false, true, "Local/Intransit DEM Type");
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ch",				false,	"",	dfNone,		0,	false,	false, -1, false, true, "Carrier's Haulage");
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"d_o",				false,	"",	dfNone,		0,	false,	false, -1, false, true, "Cargo Release");
                     InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"rlse_ofc",			false,	"",	dfNone,		0,	false,	false, -1, false, true, "Cargo Release Office");
                     InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"clt_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ofc_trns_flg",		false,	"",	dfNone,		0,	false,	false, -1, false, true, "Office Transferred");
                     
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"roll_ovr",			false,	"",	dfNone,		0,	false,	false, -1, false, true, "Roll Over due to Customs or Customer Request");
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"dmdt_inv_no",		false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"iss_dt",			false,	"",	dfDateYmd,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"inv_curr_cd",		false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"cntr_inv_amt",		false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"dmdt_ar_if_cd",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"web_ind_flg",		false,	"",	dfNone,		0,	false,	false, -1, false, true, "Web Empty Notification");
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"web_cre_dt",		false,	"",	dfDateYmd,	0,	false,	false, -1, false, true, "Web Empty Notified Date");
                     InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"web_mty_dt",		false,	"",	dfDateYmd,	0,	false,	false, -1, false, true, "Grace Period End Date");
                     InitDataProperty(0, cnt++ , dtData,    100,daLeft,  	true,	"web_ntfy_pic_nm",	false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	100,daCenter,	true,	"expt_dys",		    false,	"",	dfNone,		0,	false,	false);
                     InitDataProperty(0, cnt++ , dtData,   	100,daRight,	true,	"expt_cost_amt",	false,	"",	dfNullFloat,2,	false,	false);

                     InitDataProperty(0, cnt++ , dtData,    100, daCenter,	true,	"aft_expt_dar_no",  false,	"",	dfNone,	0,	false,  false);
                     InitDataProperty(0, cnt++ , dtData,    100, daCenter,	true,	"dmdt_expt_rqst_sts_cd_desc", false,	"",	dfNone,	0,	false,  false);
                     InitDataProperty(0, cnt++ , dtData,    100, daCenter,	true,	"inact_sts_mn", false,	"",	dfNone,	0,	false,  false);
                     
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"incur_amt",	    false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"bkg_qty",	        false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"incur_qty",	    false,	"",	dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"expt_qty",	          false, "", dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"incur_cntr_teu_knt", false, "", dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"expt_cntr_teu_knt",  false, "", dfNullFloat,2,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden, 	100,daRight,	true,	"bkg_cntr_teu",	      false, "", dfNullFloat,2,	false,	false);

                     InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"svr_id",			false,  "",	dfNone,		0,	false,  false);
                     InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"dmdt_trf_cd",		false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"chg_seq",			false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"cntr_cyc_no",		false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"dmdt_chg_loc_div_cd",false,"",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"ofc_rhq_cd",		false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"bkg_no",			false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"bl_no",			false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"dul_tp_expt_flg",	false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,	0, daCenter,	true,	"cxl_bkg_chg_flg",	false,  "",	dfNone,		0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,  0, daCenter,	true,	"dmdt_expt_rqst_sts_cd", false, "",	dfNone,			0,	false,  false);
					 InitDataProperty(0, cnt++ , dtHidden,  0, daCenter,	true,	"dmdt_expt_rqst_sts_color", false, "",	dfNone,			0,	false,  false);
					
                     CountPosition = 0;
                     // 좌측 틀고정 컬럼 설정
                     FrozenCols = SaveNameCol("cntr_tpsz_cd");
                     // 말풍선 기능 설정
                     ToolTipOption="balloon:true;width:50;";
                     Ellipsis = true;
                }
                 break;

         }
     }
     
     
     /**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj = document.form;
	    
	    switch(comboObj.id) {  
	    	case "tariff_type":
	    		with (comboObj) { 
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left|left");        
					SetColWidth("45|300");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
		    	}
				break;
				
	    	case "status":
   	    		with (comboObj) { 
    				MultiSelect = true;
					SetColAlign("left");        
					SetColWidth("120");
					DropHeight = 170;
					ColBackColor(0) = "#CCFFFD";
					addComboItem(comboObj, comboNo);
					Code = "C";
   		    	}
   	    		break;
   	    		
	    	case "rhq_ofc":
   	    		with (comboObj) { 
    				MultiSelect = false;
					SetColAlign("left");
					SetColWidth("45");
					DropHeight = 170;
					ColBackColor(0) = "#CCFFFD";
					BackColor = "#CCFFFD";
   		    	}
   	    		break;
	    }
	}
	

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction, srcObj) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
         	case IBSEARCH:		// 조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
	         	sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
            	formObj.f_cmd.value = SEARCH;
            	sheetObj.DoSearch("EES_DMT_3005GS.do", FormQueryString(formObj));
            	
            	ComOpenWait(false);
            	break;
            	
         	case IBCHKBKGNO:
         		if(srcObj.name == 'bkg_no')
         			ComClearObject(formObj.bl_no);
         		else
         			ComClearObject(formObj.bkg_no);
         		
				formObj.f_cmd.value = COMMAND02;
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				var bkgNo = ComGetEtcData(sXml, "BKG_NO");
				var blNo = ComGetEtcData(sXml, "BL_NO");
				
				if (bkgNo != undefined && bkgNo != '') {
					ComSetObjValue(formObj.bkg_no, bkgNo);
					ComSetObjValue(formObj.bl_no, blNo);
					G_BKGNO_CHK_OK = true;
				} else {
					var objName = srcObj.caption;
					ComShowCodeMessage('DMT00110', objName);
					ComSetFocus(srcObj);
					G_BKGNO_CHK_OK = false;
				}
				break;
                
 			case IBPRECAL:
	         	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	
	         	//formObj.f_cmd.value = MULTI02;
	         	//sheetObj.DoSave("EES_DMT_3005GS.do", FormQueryString(formObj),"chk");
	         	sheetObj.WaitImageVisible = false;
	         	ComOpenWait(true);
	         	
	         	formObj.f_cmd.value = COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "PRECAL");
	         	var params = sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_3005GS.do", params);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
	         	break;
         }
     }
   
   
	 /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	 function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	
	 	var params		= "f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key); // FormQueryString(formObj)
	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_3005GS.do", params);
	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");
	 	
	 	// jobState == "2" BackEndJob 진행중......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob이 성공 하였습니다.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// BackEndJob을 실패 하였습니다.
	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }

	// BackEndJob 성공종료시 결과데이터를 반영한다. 
	function getBackEndJobLoadFile() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It returns a result. 3
	 	ComSetObjValue(formObj.f_cmd, MULTI02);
	 	
	 	var params = "f_cmd=" + MULTI02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key); // FormQueryString(formObj)
	 	var sXml = sheetObj.GetSaveXml("EES_DMT_3005GS.do", params);
	 	sheetObj.LoadSaveXml(sXml);
	 	ComOpenWait(false);
	}


     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
    	 formObj.f_cmd.value = formCmd;
    	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 
    	 switch(comboObj.id) {
 	        case "tariff_type":
 		 		// Tariff type comboList
 				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems = data.split(ROWMARK);
 					addComboItem(comboObj,comboItems);
 				}
 				
 				// User별 Tariff Type Set-Up 값 조회
 				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				
 				// User별 Tariff Type Set-Up 값이 없을 경우 Default값으로 세팅.
 				if(data2 == '')
 					data2 = 'DMIF';
 				else {
 					// Tariff Type Set-Up값이 여러 건일 경우 첫번째 Tariff Type으로 설정
 					data2 = data2.split(',')[0];
 				}
 				
 				// Tariff Type IBMultiCombo 초기값 설정
 				comboObj.Code = data2;
 				
 				// IBMultiCombo Tariff Type 초기화 함수(initComboValue_tariff_type())에서 사용하기 위해 전역변수(USR_TRF_TP)에 세팅
 				USR_TRF_TP = data2;
 				
 				formObj.usr_trf_tp.value = data2;
 				break;
 				
 	        case "rhq_ofc":	// RHQ
		 		var data = ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				break;
         }
         sheetObj.WaitImageVisible = true;
     }
     
     /**
      * 콤보필드에 데이터를 추가해준다.
      */	
  	function addComboItem(comboObj,comboItems) {
  		switch(comboObj.id) {
  			case "tariff_type":
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
	  		
  			case "status":
				comboObj.InsertItem(0, "All", "A");
  				comboObj.InsertItem(1, "Finished",	"F");
  				comboObj.InsertItem(2, "Confirmed",	"C");
  				comboObj.InsertItem(3, "Invoiced",	"I");
  				comboObj.InsertItem(4, "Long Staying", "L");
  				comboObj.InsertItem(5, "Error", 	"E");
  				comboObj.InsertItem(6, "No Charge", "N");
  				comboObj.InsertItem(7, "Unfinished","U");
  				//comboObj.InsertItem(8, "Deleted",	"D");
  				comboObj.InsertItem(8, "D / Inactive",	"D");
  				comboObj.InsertItem(9, "R / US Inland Delivery",	"R");
				break;
  		}
  	}
  	
  	
  	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "chk")) {
                        	// 토글 기능
                            CellValue2(arr[i], "chk") = (CellValue(arr[i], "chk") == '0') ? "1" : "0";
                        }
                    }
                    
                    // AllCheck box 상태 동기화
                    HeadCheck(0, "chk") = (CheckedRows("chk") == RowCount);
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
  	
  	
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		var sheetObj = sheetObjects[0];
  		//sheetObj.WaitImageVisible = false;
  			
  		// Tariff Type MultiCombo List조회
  		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
  		
  		// RHQ 정보
		doActionIBCombo(sheetObj, formObj, comboObjects[2], COMMAND06);
  		//sheetObj.WaitImageVisible = true;
  		
		var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
		if(usrRhqOfcCd != 'NYCRA') {
  			// 비 미주지역 로그인시 그리드의 해당 컬럼을 숨김.
  			with(sheetObj) {
  				ColHidden("web_ind_flg")	= true;
  				ColHidden("web_cre_dt")		= true;
  				ColHidden("web_mty_dt")		= true;
  				ColHidden("web_ntfy_pic_nm")= true;
  			}
  		}
  		
  		doInit();
		
		/*********************************************
         * 팝업으로 호출시 처리 (Retrieve 실행)
         **********************************************/
		if(ComGetObjValue(formObj.call_flag) == "P") {
			
			// 검색조건 항목 비활성화
			ComEnableManyObjects(false, formObj.bkg_no, formObj.bl_no);
       	 
			// Retrieve 실행
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
  	}
      
      
  	/**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form;
		var fCmd = formObj.f_cmd.value;
		
		sheetObj.CheckAll("chk") = 0;
		
		if(fCmd == SEARCH || fCmd == SEARCH01) {
  			var bkgNo = ComGetObjValue(formObj.bkg_no);
        	var blNo = ComGetObjValue(formObj.bl_no);
        	
        	// Sheet에 존재하는 EtcData의 값을 Form 객체에 채운다.
        	ComEtcDataToForm(formObj, sheetObj);
  			
  			// 결과데이터가 없을경우, 검색조건 입력데이터 유지
        	if(sheetObj.SearchRows == 0) {
        		ComSetObjValue(formObj.bkg_no, bkgNo);
        		ComSetObjValue(formObj.bl_no, blNo);
        		ComClearManyObjects(formObj.tot_bil_amt, formObj.cntr_qty);
        		
        		initBtns();
        		
        	} else {
        		var cellBackColor = sheetObj.RgbColor(118, 222, 225);
    			
    			for(var i=sheetObj.TopRow; i <= sheetObj.SearchRows; i++) {
    				if(sheetObj.CellValue(i, "dmdt_ar_if_cd") == 'Y') {
    					sheetObj.RowBackColor(i) = cellBackColor;
    				}
    			}
    			
        		// 버튼 활성화
        		DmtComEnableManyBtns(true,	"btn_PreCal", "btn_ByCNTR", "btn_ROInfo", "btn_MVMTInq", "btn_DownExcel");
        		
        		if(sheetObj.CellValue(sheetObj.TopRow, "roll_ovr") == 'S')
			  		document.getElementById("btn_ROInfo").style.color = "red";
        		else
        			document.getElementById("btn_ROInfo").style.color = "";
        		
        		// Total Billable AMT 필드값 설정
            	var bilAmt = sheetObj.ComputeSum("bil_amt");
            	ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
               	var exptAmt  = sheetObj.ComputeSum("expt_cost_amt");
            	var incurAmt = sheetObj.ComputeSum("incur_amt");
            	var bkgQty   =  sheetObj.CellValue(1, "bkg_qty"); 
            	var exptQty  = sheetObj.ComputeSum("expt_qty");
            	var incurQty = sheetObj.ComputeSum("incur_qty");
            	var exptTeu  = sheetObj.ComputeSum("expt_cntr_teu_knt");
            	var incurTeu = sheetObj.ComputeSum("incur_cntr_teu_knt");
            	var bkgTeu   = sheetObj.CellValue(1, "bkg_cntr_teu");
            	ComSetObjValue(formObj.tot_expt_amt, ComAddComma2(exptAmt+'', "#,###.00"));
            	ComSetObjValue(formObj.tot_incur_amt, ComAddComma2(incurAmt+'', "#,###.00"));
            	ComSetObjValue(formObj.tot_bkg_qty, ComAddComma2(bkgQty+'', "#,###"));
            	ComSetObjValue(formObj.tot_expt_qty, ComAddComma2(exptQty+'', "#,###"));
            	ComSetObjValue(formObj.tot_incur_qty, ComAddComma2(incurQty+'', "#,###"));
            	ComSetObjValue(formObj.tot_expt_cntr_teu_knt, ComAddComma2(exptTeu+'', "#,###"));
            	ComSetObjValue(formObj.tot_incur_cntr_teu_knt, ComAddComma2(incurTeu+'', "#,###"));
            	ComSetObjValue(formObj.bkg_cntr_teu, ComAddComma2(bkgTeu+'', "#,###"));
            	ComSetObjValue(formObj.tot_expt_cur, "USD");
            	ComSetObjValue(formObj.tot_incur_cur, "USD");
        	}
        	
        	ComClearObject(formObj.dr_dt); 
  			
  			// 'Pre Cal.' 버튼색 초기화
	  		document.getElementById("btn_PreCal").style.color = "";
	  		
	  		// AFT DAR 상태별 색상 추가
	  		for (var j=1; j<=sheetObj.RowCount; j++) {
   		        var aftDarStsColor = sheetObj.CellValue(j,"dmdt_expt_rqst_sts_color");
   		        switch(aftDarStsColor) {
   		        case 'BLUE':
   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(30,144,255);
   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
//   		        	sheetObj.RowFontColor(j) = sheetObj.RgbColor(30,144,255);
   		        	break;
   		        case 'RED':
   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,0,0);
   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
   		        	break;
   		        case 'PINK':
   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,100,255);
   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
   		        	break;
   		        case 'BLACK':
   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(0,0,0);
   		        	sheetObj.CellFont("FontBold", j, "dmdt_chg_sts_cd") = true;
   		        	break;
   		        }
	  		}
		}
  	}
  	
  	
  	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		 if(ErrMsg != '') {	// 저장 오류 발생
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			var formObj = document.form;
			var fCmd = formObj.f_cmd.value;
			
			if(fCmd == MULTI02) {	// PreCal
				// Total Billable AMT 필드값 설정
	        	var bilAmt = sheetObj.ComputeSum("bil_amt");
	  			ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
	  			
				ComBtnDisable("btn_PreCal");
			
				// 'Pre Cal.' 버튼 색깔을 빨간색으로 변경
	  			document.getElementById("btn_PreCal").style.color = "red";
			}
		 }
    }
  	
  	
    /**
	 * 선택된 Row의 해당정보를 EES_DMT_3003.do 페이지로 전달해서 팝업으로 호출한다.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		
		doProcessPopup('btn_ByCNTR');
	}

	
  	/**
  	 * Status 멀티콤보 CheckClick 이벤트 처리
  	 * @param comboObj
  	 * @param index
  	 * @param code
  	 * @return
  	 */
  	function status_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//var codes = comboObj.Code;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All check
					comboObj.Code = "A,F,C,I,L,E,N,U,D,R";
				else // All uncheck
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			}
		}
	}

  	
  	/*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj = sheetObjects[0];
  		var sUrl = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_ByCNTR':
	  				var chkRow = SelectRow;
		  			
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			
	  				sUrl	= 'EES_DMT_3006P.do' + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	          		
	          		ComOpenWindowCenter(sUrl, null, sWidth, sHeight, true);
	          		return;
	  				break;
             	
	  			case 'btn_ROInfo':
	  				var bkgNo = ComGetObjValue(document.form.bkg_no);
	  				if(ComIsEmpty(bkgNo)) {
	  					ComShowCodeMessage('DMT03028', 'BKG No.');
	  					return;
	  				}
	  				
	  				var paramVal = "?bkg_no=" + bkgNo;
	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
              		sWidth	= '1000';
              		sHeight	= '450';
	  				break;
             		
	  			case 'btn_MVMTInq':
	  				if(SearchRows == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				
	  				var inqRow = 0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows = FindCheckedRow("chk").split("|");
	  					inqRow = chkRows[0];
	  				} else if(SelectRow > 0) {
	  					inqRow = SelectRow;
	  				}
	  				
	  				var cntrNo = CellValue(inqRow , "cntr_no");
	  				var cntrTpszCd = CellValue(inqRow , "cntr_tpsz_cd");
	  				var paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '690';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		}
  	}
  	
  	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 
         with(formObj){
        	 switch(sAction) {
          		case IBSEARCH:      //조회
          			var bkgNo = ComGetObjValue(bkg_no);
          			var blNo = ComGetObjValue(bl_no);
          			
          			if(bkgNo == '' && blNo == '') {
          				ComShowCodeMessage('DMT00102', "BKG No. or B/L No.");
             			return false;
          			}
          			
          			// Tariff Type Combo Check
             		if(comboObjects[0].Code == '') {
             			ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
             		}
             		
             		// Status Combo Check
             		if(comboObjects[1].Code == '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}
             		
          			ComSetObjValue(dmdt_trf_cd,		comboObjects[0].Code);
          			ComSetObjValue(dmdt_chg_sts_cd,	comboObjects[1].Code);
          			ComSetObjValue(rhq_ofc_cd,		comboObjects[2].Code);
          			ComBtnEnable("btn_PreCal");
          			
          			break;
          			
          		case IBCONFIRM:      //Confirm
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'F') {
         					ComShowCodeMessage('DMT03018');
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
             		}
             		break;
             	
             	case IBDELCANCEL:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('DMT01042');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'D') {
         					ComShowCodeMessage('DMT01042');
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
             		}
             		break;
             		
             	case IBPRECAL:	
             		var drDt = ComGetObjValue(dr_dt);
             		if(drDt == '') {
             			ComShowCodeMessage('DMT02002', 'D/R Date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		
             		drDt = ComGetUnMaskedValue(dr_dt, "ymd");
             		//User Office별 현재일자 조회(2010.04.06 수정)
					var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
             		
             		if(ComChkPeriod(drDt, ofcCurrDate) == 1) { //1 : fromDate < toDate
             			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var fmMvmtDt = sheetObj.CellValue(chkRows[i], "fm_mvmt_dt");
             			
             			/*
	           	    	 ComChkPeriod(fromDate, toDate)
	           	    	 0 : fromDate > toDate
	           	    	 1 : fromDate < toDate
	           	    	 2 : fromDate = toDate
	           	    	 */
     					if(ComChkPeriod(drDt, fmMvmtDt) == 1) {
                 			ComShowCodeMessage('DMT01031', 'D/R Date', 'From date');
                 			sheetObj.SelectRow = chkRows[i];
                 			return false;
                 		}
             			
             			var chgStsCd = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
             			var toMvmtSts = sheetObj.CellValue(chkRows[i], "to_mvmt_sts_cd");
             			
         				if((chgStsCd == 'F' && toMvmtSts == 'DR') || chgStsCd == 'U' || chgStsCd == 'L') {
         					
         				} else {
         					ComShowCodeMessage('DMT01060');
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
             		}
             		
             		// Status 검색조건 값을 변수에 저장
             		ComSetObjValue(sch_chg_sts, comboObjects[1].Code);
             		break;
        	 }
         }

         return true;
     }
    

	/* 개발자 작업  끝 */