/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3016.js
*@FileTitle : OP-MT Detention Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.07.23 Kim Hyun Hwa
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.12.11 김현화 [CHM-201221701-01]OP-MT Detention 계산 방법 보완 2차(Status code 추가 : Long Staying/No Charge/Unfinished)
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
     * @class ees_dmt_3016 : ees_dmt_3016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_3016() {
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
	
	var IBSEARCH_LOC    = 100;
	var IBSEARCH_YD     = 101;
	var IBDELREQCANCEL 	= 96;	//DEL Request Cancel 기능 추가됨.	2015.02.14
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");
     		
     		// 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
     		if(!ComIsBtnEnable(srcName)) return;

             switch(srcName) {
	          	case "btns_calendar1": //달력 버튼
		     		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');
		     		}
					break;
	     	   case "btns_calendar2": //달력 버튼
			 		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.fm_mvmt_dt2, formObj.to_mvmt_dt2, 'yyyy-MM-dd');
			 		}
					break;
		     	case "btns_calendar3": //달력 버튼
			 		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.fm_mvmt_dt3, formObj.to_mvmt_dt3, 'yyyy-MM-dd');
			 		}
			    	break;

 				case "btn_Retrieve":
 					doActionRetrieve();
 					break;

 				case "btn_New":
 					doInit();	// 조회조건 초기화
 					break; 
 					
 				case "btn_Minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display = 'none';
 						sheetObj.style.height = 348+110;
 					} else {
 						schCondDiv.style.display = 'block';
 						sheetObj.style.height = 348;
 					}
 					break;
 				
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
// 					
// 				case "btn_Demand":
// 					openPopup('demand');
// 					break;
// 					
// 				case "btn_GRPDemand":
// 					openPopup('grp_demand');
// 					break;
 					
 				case "btn_Billing":
 					openPopup('billing');
 					break;
 					
// 				case "btn_GRPINVCreation":
// 					openPopup('grp_inv_cre');
// 					break;
// 					
// 				case "btn_OFCTrans":
// 					openPopup('ofc_trans');
// 					break;	
 					
 				case "btn_Delete":
 					doActionIBSheet(sheetObj,formObj,IBDELETE);
 					break;
 					
 				case "btn_DelReqCancel":
 					doActionDelRequestCancel();
 					break;
 					
// 				case "btn_ByBKG":
// 					openPopup('by_bkg');
// 					break;
 					
 				case "btn_ByCNTR":
 					openPopup('by_cntr');
 					break;
 					
 				case "btn_MVMTInq":
 					openPopup('mvmt_inq');
 					break;
 				
// 				case "btn_ExceptionInq":
// 					openPopup('by_excinq');
// 					break;
 				
 				case "btn_DownExcel":
 					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
 					break;
 					
 				case "btn_Close":
					window.close();
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
    	 var formObj = document.form;
    	 
    	 // 팝업으로 호출시에 타이틀 표시 처리
    	 if(ComGetObjValue(formObj.call_flag) == "P") {
        	 var spanObj = document.getElementById("title2");
        	 spanObj.innerText = "OP-MT Detention Calculation";
        	 ComSetDisplay('btnCloseLayer', true);
    	 }
    	 
    	 for(var i=0;i<sheetObjects.length;i++){
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
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    }
     
     // 'by ETA' onMouseover 이벤트  (버튼 말풍선  보여줌)
     function btn_mouseover() {
    	 var bak = 'lightyellow';
    	 var msg = 'Manual Batch by POD ETA';
    	 var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
    	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
    	var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x-150;
		skn.top  = y+20;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
     }
     
     // 'by ETA' onMouseout 이벤트  (버튼 말풍선 숨김)
     function btn_mouseout() {
    	 var skn = document.all("topdeck").style;
    	 skn.visibility = 'hidden';
     }
     function condType_click() {
    	 doEnableCondObj(event.srcElement.value);
     }
     
     function doEnableCondObj(condType) {
    	 var formObj = document.form;
    	 
    	 with (formObj) {
	    	 switch(condType){
	    	    case "bkg":
		    	    	ComEnableManyObjects(true, bkg_no);
		    	    	DmtComSetClassManyObjects('input1', bkg_no);
		    	 		ComEnableManyObjects(false, office, yd_cd, cntr_no, chk_sub_ofc);
		    	 		ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar1, fm_mvmt_dt2, to_mvmt_dt2, btns_calendar2, fm_mvmt_dt3, to_mvmt_dt3, btns_calendar3);
			    		DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1,fm_mvmt_dt2, to_mvmt_dt2, fm_mvmt_dt3, to_mvmt_dt3, yd_cd,cntr_no);
			    		ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, fm_mvmt_dt2, to_mvmt_dt2, fm_mvmt_dt3, to_mvmt_dt3);
			    		ComClearManyObjects(yd_cd,cntr_no);		
			    		comboObjects[0].Enable = false;
			    		comboObjects[1].Enable = false;
			    		comboObjects[2].Enable = false;
			    		comboObjects[3].Enable = false;
			    		comboObjects[1].Code ="";
						comboObjects[2].Code ="";
						comboObjects[3].Code ="";
			    		
		    	    	break;
	    	    case "ofc":
	    	    	    ComEnableManyObjects(true, office, chk_sub_ofc);
	    	    	    ComEnableManyObjects(false, bkg_no, yd_cd, cntr_no);
		    		    ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar1);
		    		    DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
		    	 		ComEnableManyObjects(false, fm_mvmt_dt2, to_mvmt_dt2, btns_calendar2, fm_mvmt_dt3, to_mvmt_dt3, btns_calendar3);
			    		DmtComSetClassManyObjects('input2', fm_mvmt_dt2, to_mvmt_dt2,  fm_mvmt_dt3, to_mvmt_dt3, bkg_no, yd_cd, cntr_no);
			    		ComClearManyObjects(fm_mvmt_dt2, to_mvmt_dt2, fm_mvmt_dt3, to_mvmt_dt3);
			    		ComClearManyObjects(bkg_no, yd_cd,cntr_no);
			    		comboObjects[0].Enable = true;
			    		comboObjects[1].Enable = true;
			    		comboObjects[2].Enable = false;
			    		comboObjects[3].Enable = false;
			    		comboObjects[1].Code ="F";
						comboObjects[2].Code ="";
						comboObjects[3].Code ="";
	    	    	    break;
	    	    case "loc":
		    	    	ComEnableManyObjects(true, yd_cd);
		    	 		ComEnableManyObjects(true, fm_mvmt_dt2, to_mvmt_dt2, btns_calendar2);
			    		DmtComSetClassManyObjects('input1', yd_cd, fm_mvmt_dt2, to_mvmt_dt2);
		    	 		ComEnableManyObjects(false, bkg_no, office, cntr_no, chk_sub_ofc);
		    	 		ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar1, fm_mvmt_dt3, to_mvmt_dt3, btns_calendar3);
			    		DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1, fm_mvmt_dt3, to_mvmt_dt3, bkg_no, cntr_no);
			    		ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, fm_mvmt_dt3, to_mvmt_dt3);

			    		ComClearManyObjects(bkg_no, cntr_no);
			    		comboObjects[0].Enable = false;
			    		comboObjects[1].Enable = false;
			    		comboObjects[2].Enable = true;
			    		comboObjects[3].Enable = false;
			    		comboObjects[1].Code ="";
						comboObjects[2].Code ="F";
						comboObjects[3].Code ="";
    	    	    break;

	    	 	case "cntr":
	    	    	ComEnableManyObjects(true, cntr_no);
		    		ComEnableManyObjects(true, fm_mvmt_dt3, to_mvmt_dt3, btns_calendar3);
		    		DmtComSetClassManyObjects('input1', cntr_no, fm_mvmt_dt3, to_mvmt_dt3);
		    		
	    	 		ComEnableManyObjects(false, bkg_no, office, yd_cd, chk_sub_ofc);
	    	 		ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar1, fm_mvmt_dt2, to_mvmt_dt2, btns_calendar2);
		    		DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1, fm_mvmt_dt2, to_mvmt_dt2, bkg_no, yd_cd);
		    		ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, fm_mvmt_dt2, to_mvmt_dt2);
		    		ComClearManyObjects(bkg_no, yd_cd);
		    		comboObjects[0].Enable = false;
		    		comboObjects[1].Enable = false;
		    		comboObjects[2].Enable = false;
		    		comboObjects[3].Enable = true;
		    		comboObjects[1].Code ="";
					comboObjects[2].Code ="";
					comboObjects[3].Code ="F";
	    	 		break;
	    	 }
	    	 

    	 }
     }
     
     
     function setStatusCombo(condType) {
    	 var comboObj = comboObjects[2];
    	 var orgCode = comboObj.Code;
    	 
    	 if(condType=='date') {
    		 if(comboObj.GetCount() != 5) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 3);
    		 }
    	 } else {
    		 if(comboObj.GetCount() != 4) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 4);
    			 
    			 if(orgCode.indexOf('R') != -1) {
    				 orgCode = ComReplaceStr(orgCode, 'R', 'L');
    				// 전체선택('All') 항목 체크 처리
    				 if(orgCode == 'F,E,L')
    					 orgCode = 'A,F,E,L';
    			 }
    		 }
    	 }
    	 
    	 comboObj.Code = orgCode;
     }
     
     
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
   		// Office MultiCombo List조회
   		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST02);
   		
   		// Tariff Type MultiCombo List조회
 		doActionIBCombo(sheetObj, formObj, comboObjects[1], SEARCHLIST);
 		
 		// 조회조건 초기화
 		doInit();
	}
    
	
	/*
	 * INIT SETTING 
	 */
   	function doInit() {
  		var formObj = document.form;
  		
  		sheetObjects[0].CheckAll("chk") = 0;
  		ComResetAll();
  		
  		//조회조건 부분적으로 활성화/비활성화  처리
  		doEnableCondObj("ofc");
  		
  		//Status 멀티콤보 초기화
  		comboObjects[1].Code = 'F';
  		comboObjects[2].Code = '';
  		comboObjects[3].Code = '';
  		
  		initBtns();
   	}
   	
   	
   	// 버튼 상태 초기화
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_Confirm", "btn_Demand", "btn_GRPDemand", "btn_Billing", "btn_GRPINVCreation", "btn_OFCTrans"
									,"btn_Delete", "btn_DelReqCancel", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel");
	}
	
   	
   	
   	// IBMultiCombo Office 초기화
   	function initComboValue_office() {
   		var formObj = document.form;
   		
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			comboObjects[0].Enable = true;
   	   		ComSetObjValue(comboObjects[0], formObj.usr_ofc_cd.value);
   		} else {
   			comboObjects[0].Enable = false;
   			comboObjects[0].Code = ComGetObjValue(formObj.ofc_cd);
   		}
   	}
   	
   	
   	// IBMultiCombo Status 초기화
   	function initComboValue_status() {
   		var formObj = document.form;
   		
   		if(ComGetObjValue(formObj.call_flag)=='M') {
	   		comboObjects[2].Enable = true;
	   		ComSetObjValue(comboObjects[2], "F");
   		} else {
   			comboObjects[2].Enable = false;
	   		ComSetObjValue(comboObjects[2], formObj.dmdt_chg_sts_cd);
   		}
   	}

     
     //포커스가 나갈 때
     function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기

    	 var obj = event.srcElement;
         if(obj.name != 'bkg_no' && obj.name != 'yd_cd' && obj.name != 'cntr_no' ) {
    	     ComChkObjValid(obj);    		  
    	 }
 		 var condType = ComGetObjValue(document.form.cond_type);  
 		 if (condType == 'loc' && obj.name == 'yd_cd') {
 			  checkLocYdCd(obj);  }
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
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	// 영문대+숫자+예외문자
         		DmtComKeyOnlyAlphabet('uppernum', ',');
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
     
	
//	/*
//	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation을 위한 KeyUp 이벤트 처리 함수
//	 */
//	function obj_keyup() {
//		var srcObj = event.srcElement;
//	 var condType = ComGetObjValue(document.form.cond_type);  
//		 if (condType == 'loc' && srcObj.name == 'yd_cd') {
//			  checkLocYdCd(srcObj);  }
//	}
	
	/*
	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation 처리 함수
	 */
	function checkLocYdCd(srcObj) {
			var formObj = document.form;
			var sheetObj 	= sheetObjects[0];
			var cd = ComTrim(ComGetObjValue(srcObj));
			
            if  (cd.length > 1 ) {
					if (cd.length == 5) {
						 formObj.loc_cd.value = cd;
						 doActionIBCommon(sheetObj,formObj,IBSEARCH_LOC,COMMAND07);
						 if ( ComGetObjValue(formObj.chk_loc_cd) != "Y") {
								ComShowCodeMessage("DMT00110", "MT.Loc/Yard");
								ComClearObject(srcObj);
								ComSetFocus(srcObj);
								return;
							}
					  }	else if	(cd.length == 7) {
						
						 doActionIBCommon(sheetObj,formObj,IBSEARCH_YD, COMMAND20);
						
						 if (ComGetObjValue(formObj.chk_yd_cd) != "Y" ) {
								ComShowCodeMessage("DMT00110", "MT.Loc/Yard");
								ComClearObject(srcObj);
								ComSetFocus(srcObj);
								return;
							}
					  } else {
						
						    ComShowCodeMessage("DMT00110", "MT.Loc/Yard");
							ComClearObject(srcObj);
							ComSetFocus(srcObj);
							return;
						  
					  }
            }
            
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
                     style.height = 348; //120;
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
                     InitColumnInfo(66, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);
                     
                     // Ctrl키를 눌러 다중행 선택가능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;

                     var HeadTitle1 = " ||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|Tariff|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT";
			 			HeadTitle1 += "|Billable AMT|BKG No.|B/L No.|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|A/Cust.|G/B|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|WEB";
			 			HeadTitle1 += "|Payer CD|Payer Name|SHPR CD|Shipper Name|CNEE CD|Cosignee Name|NTFY CD|Notify Name|A/R Cust.|A/R Actual Payer Name|S/P CD|Service Provider Name";
 												
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	30,	daCenter,	true,	"chk");
					InitDataProperty(0, cnt++ , dtSeq,		40,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"dmdt_chg_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"cntr_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"ofc_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"to_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"fm_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"to_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
												
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"dmdt_trf_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ft_dys",			false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"fx_ft_ovr_dys",	false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"to_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_cmnc_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_end_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"bzc_trf_curr_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daRight,	true,	"org_chg_amt",		false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,daRight,	true,	"sc_rfa_expt_amt",	false,	"",		dfNullFloat,	2,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	90,	daRight,	true,	"aft_expt_dc_amt",	false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"bil_amt",			false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		100,daCenter,	true,	"bkg_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"bl_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"vvd_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"lane",				false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"por_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pol_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pod_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"del_cd",			false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_rcv_term_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_de_term_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"sc_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"rfa_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"acust",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"chg_type",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "General/Balance Charge Type");
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"soc_flg",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"li",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Local/Intransit DEM Type");
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ch",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Carrier's Haulage");
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"d_o",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release");
					
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"rlse_ofc",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release Office");
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"clt_ofc_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ofc_trns_flg",		false,	"",		dfNone,			0,	false,	true, -1, false, true, "Office Transferred");
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"roll_ovr",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Roll Over due to Customs or Customer Request"); 
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"web_ind_flg",		false,	"",		dfNone,			0,	false,	true, -1, false, true, "Web Empty Notification"); 
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"payer_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"payer_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"shipper_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"shipper_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"cnee_cd",			false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"cnee_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ntfy_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ntfy_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ar_act_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ar_act_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"svc_provdr_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"svc_provdr_nm",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"svr_id",			false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"cntr_cyc_no",		false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_chg_loc_div_cd",false,"",		dfNone,			0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"chg_seq",			false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"ofc_cd",			false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"ofc_rhq_cd",		false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"ar_curr_cd",		false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"dmdt_delt_rqst_sts_cd", false,	"",	dfNone,			0,	false,  false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("cntr_tpsz_cd");
					ToolTipOption="balloon:true;width:50;";
					Ellipsis = true;
                 }
                 break;
                 
			case 2:      // Hidden Sheet(4013 - GRP INV Creation 처리용)
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 130;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false, false);
	
	                //var HeadTitle  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq";
	                var HeadTitle = "||Seq.|bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt"
	                				+ "|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|vvd_cd|payer_cd";
	                //var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                //InitColumnInfo(29, 0, 0, true);//CheckBox추가 kimtk.2009.12.07
	                InitColumnInfo(30, 0, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
					//InitHeadRow(1, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,   true,       "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		0,			daCenter,	true,		"CheckBox");
					InitDataProperty(0, cnt++ , dtSeq,			30,			daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bl_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"cntr_cnt",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"ofc_cd",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"cust_cd",			false,		"",			dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"sc_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"rfa_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"ar_curr_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"org_chg_amt",		false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"sc_rfa_expt_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"bil_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"inv_xch_rt",		false,		"",			dfNullFloat,	6,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"vsl_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"skd_voy_no");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"pol_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"pod_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"por_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"del_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"vvd_cd");
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"payer_cd");
					
					
	                FrozenCols = SaveNameCol("cntr_cnt");
					CountPosition = 0;
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
   	    	case "office": 
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 6;
   		    	}
   				break; 
   				
  	    	case "status1":
   	    	case "status2":
   	    	case "status3":
   	    		with (comboObj) { 
   	    			if(comboNo==2 ||comboNo==3 ||comboNo==4) {
   	    				MultiSelect = true;
   						SetColAlign("left|left");        
   						SetColWidth("100|140");
   						DropHeight = 190;
   						ColBackColor(0) = "#CCFFFD";
   						ColBackColor(1) = "#CCFFFD";
   						addComboItem(comboObj, comboNo);
   	    			} 
   		    	}
   	    		break;
   	     }
   	}
	
   	/**
   	 * Sheet관련 프로세스 처리
   	 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      //조회
            	if (!validateForm(sheetObj,formObj,sAction)) return;
            	
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
        	
            	formObj.f_cmd.value = SEARCH;
            	
            	// Office 콤보리스트에 없는 코드도 입력가능하나, 대신 자기 지역이 아니면 조회가 되지 않음.(2010-02-22 요청사항)
            	formObj.ofc_cd.value = comboObjects[0].Code;
            	
            	sheetObj.DoSearch("EES_DMT_3016GS.do", FormQueryString(formObj));	// + "&" + ComGetPrefixParam(prefix));
            	ComOpenWait(false);
            	
	               	for (var j=1; j<=sheetObj.RowCount; j++) {
		   		        var deltRqstStsCd = sheetObj.CellValue(j,"dmdt_delt_rqst_sts_cd");
		   		        
		   		        // 1. 파랑색 : Charge Deletion 요청한 상태로 Charge Deletion 취소가 가능한 상태입니다.(승인처리가 전혀 이루어지지 않은 상태임)
		   		        if (deltRqstStsCd == 'R') {
		   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(30,144,255);
		   		            sheetObj.CellFont("FontBold", j, 3) = true;	   		        	
		   		        }
		   		        // 2. 분홍색 : Charge Deletion 요청에 대해서 승인처리가 진행중인 상태로 Charge Deletion 취소가 불가한 상태입니다.
		   		        else if (isProcessingInactive(deltRqstStsCd)) {
		   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,100,255);
		   		            sheetObj.CellFont("FontBold", j, 3) = true;
		   		        }
		   		        // 3. 녹색 : Charge Deletion 요청에 대해서 필수최종승인단계까지의 처리가 완료된 상태입니다.
		   		        else if (deltRqstStsCd == 'X') {
		   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(207,240,88);
		   		        	sheetObj.CellFont("FontBold", j, 3) = true;
		   		        } 	   		        
		   		        // 4. 빨간색 : 기존 상태값으로 Charge Deletion 요청에 대해서 취소한 상태입니다.
		   		        else if (isProcessingInactiveReject(deltRqstStsCd)) {
		   		        	sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(255,0,0);
		   		        	sheetObj.CellFont("FontBold", j, 3) = true;
		   		        } 
		   		        // 5. 검정색 : 그 이외의 상태입니다.
		   		        else { 
		   		              sheetObj.CellFontColor(j, "dmdt_chg_sts_cd") = sheetObj.RgbColor(0,0,0); 
		   		              sheetObj.CellFont("FontBold", j, 3) = false;	 
		   		        }
		            }
	           	
            	break;
            	
 			 case IBSAVE:        // Confirm
 				if (!validateForm(sheetObj,formObj,sAction)) return;
 				
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
 				formObj.f_cmd.value = MULTI;
		      	sheetObj.DoSave("EES_DMT_3001GS.do", FormQueryString(formObj), "chk");
		      	ComOpenWait(false);
                break;

 			 case IBDELETE:      // 삭제
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				openPopup('delete');
                break;
                
   			case IBDELREQCANCEL:	// Deletion Cancel 에서 기능개선으로 Delete Request Cancel 로 변경됨. 2015.02.14
				 if (!validateForm(sheetObj,formObj,sAction)) return;
				 
				 // 서버로 전달할 매개변수 세팅
				 ComSetObjValue(formObj.f_cmd, MULTI01);
				 
	 			sheetObj.WaitImageVisible=false;
	     		ComOpenWait(true);
				sheetObj.DoSave("EES_DMT_3001GS.do", FormQueryString(formObj), "chk");
				ComOpenWait(false);
				
				// Charge Deletion 취소처리가 되었으면, 조회를 실행합니다.
				doActionRetrieve();
				break;                  
         }
     }

     
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
    	 sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
    	 formObj.f_cmd.value = formCmd;
    	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 
    	 switch(comboObj.id) {
 	       case "office":
 	    	   if(formCmd == SEARCHLIST02) {
	 	    	   	// Office List
					var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
					
					if (ofc_cds != undefined && ofc_cds != '') {
						var comboCodeArr = ofc_cds.split("|");
			    	    var comboTextArr = ofc_nms.split("|");
			    	    
			    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
		    	  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
		    	  		var idx = 0; 
		    	  		
			    	    if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			    	    	comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
			    	    	idx = 1;
			    	    }
			    	    
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
			    	    
			    	    comboObj.Code = usr_ofc_cd;
					}
	    	  		
 	    	   } else { // formCmd == COMMAND01 (Incl. Sub Office)
 	    		   	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
 	    	   			var arrOfcCd = subOfcCds.split(',');
 	    	   			var str = '';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {
 	    	   				var idx = comboObj.FindIndex(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str = str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str = str.substring(1);
 	    	   			
 	    	   			// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
 	    	   			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
 	    	   			if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str = usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.Code = str;
 	    			 }
 	    	   }
    	 		break;
 	        	
 	      
         }
         sheetObj.WaitImageVisible = true;
     }
   	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
	    sheetObj.ShowDebugMsg 		= false;
		sheetObj.WaitImageVisible 	= false;
		
	    switch(sAction) {
	    	//Location 을 조회한다.
	    	case IBSEARCH_LOC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
               
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var locCd = ComGetEtcData(sXml, "LOC_CD");
				
				ComSetObjValue(formObj.chk_loc_cd, locCd != "" ? "Y" : "N");
				ComSetFocus(formObj.fm_mvmt_dt2);
				break;
				
	     	case IBSEARCH_YD:
	     		
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				 
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var chk_yd_cd = ComGetEtcData(sXml, "chk_yd_cd");
           
				ComSetObjValue(formObj.chk_yd_cd, chk_yd_cd);
				ComSetFocus(formObj.fm_mvmt_dt2);
				break;
   		
	    }
	    
		sheetObj.WaitImageVisible = true;
	}
    
     
     
     /**
      * 콤보필드에 데이터를 추가해준다.
      */	
  	function addComboItem(comboObj,comboItems) {
   		switch(comboObj.id) {
    			case "status1":
    			case "status2":
    			case "status3":
        			 comboObj.InsertItem(0, "All", "A");
        			 comboObj.InsertItem(1, "Finished|To Date", "F");
       	  		     comboObj.InsertItem(2, "Long Staying|From Date", "L");
       	  		     comboObj.InsertItem(3, "System Error|From Date/To Date", "E");
       	  		     comboObj.InsertItem(4, "No Charge|To Date", "N");
     	  			 //comboObj.InsertItem(5, "Deleted|From Date", "D");
       	  		     comboObj.InsertItem(5, "D / Inactive|From Date", "D");
     	  			 comboObj.InsertItem(6, "Unfinished|From Date", "U");
     	  			 comboObj.InsertItem(7, "Confirmed|To Date", "C");
     	  			 comboObj.InsertItem(8, "Invoiced|To Date", "I");
    			break;
  		   }
    	}
  	
  	/**
  	 * Tariff Type 선택값에 따른 DEM Type 선택항목 활성화/비활성화 처리
  	 */
  	function setDemType() {
  		var formObj = document.form;
  		
  		with(formObj) {
	  		if(ComGetObjValue(cond_type) != 'vvd_cd') return;
	  		
	  		var trf_tp = comboObjects[1].Code;
	  		if(trf_tp.indexOf('DMIF') != -1 || trf_tp.indexOf('DMOF') != -1) {
	  			ComEnableObject(dem_type, true);
	  			dem_type.className = 'input';
	  			ComClearObject(dem_type);
	  		} else {
	  			ComEnableObject(dem_type, false);
	  			dem_type.className = 'input2';
	  			ComClearObject(dem_type);
	  		}
  		}
  	}
  	
  	
	//멀티콤보 클릭 이벤트
	function tariff_type_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else if(comboObj.CheckIndex(0)) {
			comboObj.CheckIndex(0) = false;
	    } else if(comboObj.Code == 'DMIF,DTIC,DMOF,DTOC,CTIC,CTOC') {
	    	comboObj.CheckIndex(0) = true;
	    }
	    setDemType();
	}
	
	function status1_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.Code;
		var formObj = document.form;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All
					comboObj.Code = "A,L,F,E,N,D,U,C,I";
				else
					comboObj.Code = "";
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			} else if(codes == "L,F,E,N,D,U,C,I") {
				comboObj.CheckIndex(0) = true;
			}
		}
	}
	
	function status2_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.Code;
		var formObj = document.form;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All
					comboObj.Code = "A,L,F,E,N,D,U,C,I";
				else
					comboObj.Code = "";
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			} else if(codes == "L,F,E,N,D,U,C,I") {
				comboObj.CheckIndex(0) = true;
			}
		}
	}
	
	function status3_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.Code;
		var formObj = document.form;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All
					comboObj.Code = "A,L,F,E,N,D,U,C,I";
				else
					comboObj.Code = "";
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			} else if(codes == "L,F,E,N,D,U,C,I") {
				comboObj.CheckIndex(0) = true;
			}
		}
	}
	
	/**
	 * 선택된 Row의 해당정보를 EES_DMT_3003.do 페이지로 전달해서 팝업으로 호출한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;

		openPopup('by_cntr', Row);
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
	 
	
	/*
	 * Grid에서 말풍선 처리
	 */
	/*
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			Col = MouseCol;
			if (Row > 0) {
				var ttText='';
				var colSaveNm = ColSaveName(Col);
				switch(colSaveNm) {
					case "chg_type": 
						ttText = 'General/Balance Charge Type';
						break;
					case "li": 
						ttText = 'Local/Intransit DEM Type';
						break;
					case "ch":
						ttText = "Carrier's Haulage";
						break;
					case "d_o":
						ttText = 'Cargo Release';
						break;
					case "rlse_ofc":
						ttText = 'Cargo Release Office';
						break;
					case "ofc_trns_flg":
						ttText = 'Office Transferred';
						break;
					case "roll_ovr":
						ttText = 'Roll Over due to Carrier Schedule Change';
						break;	
					case "web_ind_flg":
						ttText = 'Web Empty Notification';
						break;	
				}
				MouseToolTipText = ttText;
			} else {
				MouseToolTipText = "";
			}
		}
	}*/
	
	
	/**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form;
		with(formObj) {
			sheetObj.CheckAll("chk") = 0;
			
  			// 결과데이터가 없을경우, 검색조건 입력데이터 유지
        	if(sheetObj.SearchRows == 0) {
        		initBtns();
        	} else {
        		// ****** 검색 데이터 존재 ********
        		
        		if(formObj.f_cmd.value == SEARCH01) {
        			ComEnableManyObjects(false, cond_type[0], cond_type[1], cond_type[2]);
        		        			
        			        			
        			// 버튼 활성화
        			DmtComEnableManyBtns(true,  "btn_MVMTInq", "btn_DownExcel");
        			// 버튼 비활성화
        			DmtComEnableManyBtns(false, "btn_Confirm", "btn_Billing", "btn_Delete", "btn_DelReqCancel",  "btn_ByCNTR");
        		} else {
        			// 버튼 활성화
        			DmtComEnableManyBtns(true,	"btn_Confirm", "btn_Billing", "btn_Delete", "btn_DelReqCancel",  "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
        			
        		}
        		
        		// 페이지 접근 권한정보
        		var rolePermit	= sheetObj.EtcData("ROLE_PERMIT");
        		var roleAuth	= sheetObj.EtcData("ROLE_AUTH");
        		ComSetObjValue(role_permit, rolePermit);
        		ComSetObjValue(role_auth,	roleAuth);	
        		
  			}
		} // with end

  	}
	
	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		 if(ErrMsg != '') {	// 저장 오류 발생
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			var chkRows = sheetObj.FindCheckedRow("chk").split("|");
			
      		for(var i=0; i < chkRows.length-1; i++) {
      			sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd") = 'C';
      		}
      		
      		//전체 UnCheck --> sheetObj.RowStatus(i)가  모두  'R' 로  바뀜
			sheetObj.CheckAll("chk") = 0;
		 }
    }
	
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
    }
    
    /*
  	 * Service Provider Inquiry 공통팝업 호출
  	 */
    function getSvcProvdr(aryPopupData) {
    	document.form.svc_provdr.value = aryPopupData[0][2];
    }
    
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    
    
  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		var paramVal = '';
  		var sScroll = 'no';
  		
  		with(sheetObj) {
	  		switch(flag) {
			
//	  			case 'bkg_no':		// BKG No. 멀티입력 팝업 호출
//	  			case 'cntr_no':		// CNTR No. 멀티입력 팝업 호출
//	  				// 멀티입력 팝업 타이틀 세부 내용 지정
//	  				var returntitle = '';
//	  				if(flag == 'bkg_no')
//	  					returntitle = 'BKG No.';
//	  				else if(flag == 'bl_no')
//	  					returntitle = 'B/L No.';
//	  				else if(flag == 'cntr_no')
//	  					returntitle = 'CNTR No.';
//	  				
//	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
//	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
//					break;
//					
	  			case 'delete':
	  				if (CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		
             		var chkCnt = 0;
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");

             		var old_delt_rqst_sts= "";
		  			var paramVal    = "";
             		
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chgStsCd      = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
             			var cntrNo        = sheetObj.CellValue(chkRows[i], "cntr_no");
             			var bkgNo         = sheetObj.CellValue(chkRows[i], "bkg_no");
             			var trfCd         = sheetObj.CellValue(chkRows[i], "dmdt_trf_cd");
             			var deltRqstStsCd = sheetObj.CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd");

            			// Charge Deletion 요청상태 코드값 변경에 따라 체크로직을 DMT 공통함수로 변환함. 
            			if (!isValidChgDeltRqst(bkgNo, cntrNo, trfCd, deltRqstStsCd)) return;  
//               			2011.10.10 KHH [CHM-201113639-01]
//            			if(delt_rqst_sts=='R'){
//            				ComShowCodeMessage('DMT01155');
//            				return;
//            			}

            			if (deltRqstStsCd != '') {
	            			if ( old_delt_rqst_sts == '' ){
	            				old_delt_rqst_sts = deltRqstStsCd;
	            			} else {
	            				if (deltRqstStsCd != old_delt_rqst_sts) {
	            					ComShowCodeMessage('DMT01155');
	                				return;
	            				}
	            			}
	            			if (deltRqstStsCd == 'R' && paramVal == '') {
	            				var svrId_r 		= CellValue(chkRows[i] , "svr_id");
	            				var cntrNo_r		= CellValue(chkRows[i] , "cntr_no");
	            				var cntrCycNo_r		= CellValue(chkRows[i] , "cntr_cyc_no");
	            				var trfCd_r			= CellValue(chkRows[i] , "dmdt_trf_cd");
	            				var chgLocDivCd_r	= CellValue(chkRows[i] , "dmdt_chg_loc_div_cd");
	            				var chgSeq_r		= CellValue(chkRows[i] , "chg_seq");
	            				var chgDeltStsCd_r  = CellValue(chkRows[i] , "dmdt_delt_rqst_sts_cd");
	        		  			
	        		  			paramVal  = "?";
	        		  			paramVal += "sys_area_grp_id="      + svrId_r;
	        		  			paramVal += "&cntr_no="             + cntrNo_r;
	        		  			paramVal += "&cntr_cyc_no="         + cntrCycNo_r;
	        		  			paramVal += "&dmdt_trf_cd="         + trfCd_r;
	        		  			paramVal += "&dmdt_chg_loc_div_cd=" + chgLocDivCd_r;
	        		  			paramVal += "&chg_seq="             + chgSeq_r;
	        		  			paramVal += "&chg_delt_sts_cd="     + chgDeltStsCd_r;
	        		  			paramVal += "&prnt_mnu_id="         + "EES_DMT_3014";
	        		  			paramVal += "&save_flg="            + "D";
	            			}
            			}
             			if (chg_sts == '') {
             				ComShowCodeMessage('DMT01060');
             				sheetObj.SelectRow = i;
             				return;
             			} 
             			else if(chg_sts == 'D') {
             				ComShowCodeMessage("DMT00176", sheetObj.CellValue(chkRows[i], "cntr_no"));
    	  					return;
             			} 
             			else if(chg_sts != 'I' ) { // 2011.10.10 D 추가
         					chkCnt++;
         				}
             		}
             		if (chkCnt == 0) {
             			ComShowCodeMessage('DMT01026');
     					return;
             		}
             		
	  				sUrl	= 'EES_DMT_3104.do'+ paramVal;
              		sWidth	= '770';
              		sHeight	= '720';   
	  				break;
	  				
	  			case 'demand':
	  				var chkRow = SelectRow;
         			var chgStsCd = CellValue(chkRow, "dmdt_chg_sts_cd");
         			
     				if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I' || chgStsCd == 'L' || chgStsCd == 'U') {
     				} else {
     					ComShowCodeMessage('DMT01077');
        				return;
     				}
     	 	 		
     				chgStsCd = "F,C,I,L,U";
     				paramVal =	"?group_by=2"
		     	 	 			+"&chg_type="	+ "A"
		     	 	 			+"&ofc_cd="		+ ComGetObjValue(formObj.ofc_cd)
		     	 				+"&dmdt_chg_sts_cd=" + chgStsCd
		     	 				+"&bkg_no="		+ CellValue(chkRow, "bkg_no")
		     	 				+"&dmdt_trf_cd="+ CellValue(chkRow, "dmdt_trf_cd")
		     	 				+"&cntr_no="	+ CellValue(chkRow, "cntr_no")
		     	 				+"&dmdt_inv_no="
		     	 				+"&invoice_issue=1"	//Invoice Issue BEFORE
		     	 				;
     				
             		sUrl	= 'EES_DMT_3109.do' + paramVal;
              		sWidth	= EES_DMT_3109_WIDTH;
              		sHeight	= EES_DMT_3109_HEIGHT;
	  				break;
	  				
	  			case 'grp_demand':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		
             		var chkRows = FindCheckedRow("chk").split("|");
             		var firstTrfCd = CellValue(chkRows[0], "dmdt_trf_cd"); 
             		
             		for(var i=1; i < chkRows.length-1; i++) {
             			if(CellValue(chkRows[i], "dmdt_trf_cd") != firstTrfCd)
             				CellValue2(chkRows[i], "chk") = "0";
             		}
             		
             		var chkCnt = 0;
             		chkRows = FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts == 'F' || chg_sts == 'C' || chg_sts == 'I' || chg_sts == 'L' || chg_sts == 'U') {
         				} else {
         					ComShowCodeMessage('DMT01077');
            				return;
         				}
             		}
             		
             		var chgStsCd = comboObjects[2].Text;
             		chgStsCd = ComReplaceStr(chgStsCd, "System Error", "");
             		
             		var chgStsCd2 = comboObjects[2].Code;
             		chgStsCd2 = ComReplaceStr(chgStsCd2, "E", "");
             		
         			paramVal =	"?ofc_cd="				+ CellValue(chkRows[0], "ofc_cd")
		        				+ "&dmdt_trf_cd="		+ CellValue(chkRows[0], "dmdt_trf_cd")
		        				+ "&dmdt_chg_sts_cd="	+ chgStsCd
		        				+ "&dmdt_chg_sts_cd_2="	+ chgStsCd2
		        				;
         			
             		sUrl	= 'EES_DMT_3108.do' + paramVal;
              		sWidth	= '1020';
              		sHeight	= '730';
             		break;
             		
	  			case 'billing':
	  				var chkRow = SelectRow;
	  				
	  				var chgStsCd      = CellValue(chkRow, "dmdt_chg_sts_cd");
	  				var cntrNo        = CellValue(chkRow, "cntr_no");
	  				var bkgNo         = CellValue(chkRow, "bkg_no");
	  				var trfCd         = CellValue(chkRow, "dmdt_trf_cd");             			
	  				var deltRqstStsCd = CellValue(chkRow, "dmdt_delt_rqst_sts_cd"); 				
	  				
            		if (deltRqstStsCd == 'R') {
            			ComShowCodeMessage('DMT01154');
            			return;   
            		}
            		else if (isProcessingInactive(deltRqstStsCd)) {
            			ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
            			return;         					
            		}
            		else if (chgStsCd != 'C') {
             			ComShowCodeMessage('DMT01076', 'Billing');
             			return;
             		}
         			
         			var paramVal =	"?group_by=2"
			        				+"&chg_type="	+ "A"
			        				+"&ofc_cd="		+ CellValue(chkRow, "ofc_cd")
			        				+"&bkg_no="		+ CellValue(chkRow, "bkg_no")
			        				+"&dmdt_trf_cd="+ CellValue(chkRow, "dmdt_trf_cd")
			        				+"&invoice_issue=1";	//Invoice Issue BEFORE
			        				
			        sUrl	= 'EES_DMT_4002.do' + paramVal;
              		sWidth	= EES_DMT_4002_WIDTH;
              		sHeight	= EES_DMT_4002_HEIGHT;
             		break;
             		
	  			case 'grp_inv_cre':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
	  				
             		var chkRows = FindCheckedRow("chk").split("|");
	  				for(var i=0; i < chkRows.length-1; i++) {
             			var chgStsCd = CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chgStsCd != 'C') {
         					ComShowCodeMessage('DMT01076', 'GRP INV Creation');
         					return;
         				}
    			       var delt_rqst_sts = CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); 
             			
               			// 2011.10.10 KHH [CHM-201113639-01]
            			if(delt_rqst_sts=='R'){
            				ComShowCodeMessage('DMT01154');
            				return;
            			}
         				
         				
             		}
             		
             		// Hidden Sheet
             		var sheetObj2 = sheetObjects[1];
             		sheetObj2.RemoveAll();
             		
             		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
             		var sXml = ComMakeSearchXml(sheetObj, false, "chk", "bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|vvd_cd|payer_cd|chg_cust_cnt_cd|chg_cust_seq");             		
             		//sheet2로 조회XML 로드하기
             		sheetObj2.LoadSearchXml(sXml, true);
             		
             		with(sheetObj2) {
	             		for(var i=TopRow; i <= LastRow; i++) {
	             			var vvdCd = CellValue(i, "vvd_cd");
	             			CellValue2(i, "vsl_cd")		= vvdCd.substring(0, 4);
	             			CellValue2(i, "skd_voy_no") = vvdCd.substring(4, 8);
	             			CellValue2(i, "skd_dir_cd") = vvdCd.substring(8);
	             			CellValue2(i, "cust_cd")	= CellValue(i, "payer_cd");
	             		}
	             		
	             		//formObj.f_cmd.value = SEARCH02;
	             		var sParam = GetSaveString(true) + "&f_cmd=" + SEARCH02;	// + FormQueryString(formObj);
	             		
	             		var sXml = GetSaveXml("EES_DMT_3016GS.do", sParam);
	             		LoadSaveXml(sXml);
	             		
	             		for(var i=TopRow; i <= LastRow; i++) {
	             			CellValue2(i, "cust_cd") = CellValue(i, "payer_cd");
	             		}
             		}
             		//추가.kimtk.2009.12.7
             		sheetObj2.CheckAll("CheckBox") = 1;
             		
             		var chgType = ComGetObjValue(formObj.chg_type);
             		if(chgType == '') chgType = 'A'; 
             			
             		paramVal =	"?jspno=3016"
             					+ "&s_group_by=2"	//Invoice Issue BEFORE
		        				+ "&s_chg_type=" + chgType
		        				+ "&inv_xch_rt="
		        				;

			        sUrl	= 'EES_DMT_4013.do' + paramVal;
              		sWidth	= '1020';
              		sHeight	= '645';
             		break;
             		
	  			case 'ofc_trans':	
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		
             		var chkRows = FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = CellValue(chkRows[i], "dmdt_chg_sts_cd");
             			var delt_rqst_sts = ""; 
             			delt_rqst_sts = CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); //2011.10.10
             			
         				if(chg_sts != 'F' && chg_sts != 'L') {
         					ComShowCodeMessage('DMT01019');
         					return;
         				}
        				if(delt_rqst_sts == "R") {
         					ComShowCodeMessage('DMT01153');
         					return;
         				}
         				
             		}
             		
             		var fmOfcCd = CellValue(chkRows[0], "ofc_cd");		//comboObjects[0].Code;
             		var ofcRhqCd = CellValue(chkRows[0], "ofc_rhq_cd");
		  			var paramVal = "?fm_ofc_cd=" + fmOfcCd + "&ofc_rhq_cd=" + ofcRhqCd;
             		
             		sUrl	= 'EES_DMT_3101.do' + paramVal;
              		sWidth	= '618';
              		sHeight	= '490';
             		break;
             	
	  			case 'by_eta':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		
             		var chkRows = FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = CellValue(chkRows[i], "dmdt_chg_sts_cd");
             			if(chg_sts != '') {
             				ComShowCodeMessage('DMT01054');
             				SelectRow = chkRows[i];
             				return;
             			}
             		}
             		
	  				sUrl	= 'EES_DMT_3106.do' + '?call_flag=byofc';
              		sWidth	= '780';
              		sHeight	= '450';
              		//ComOpenWindow(sUrl, 'EES_DMT_3106', "width="+sWidth+",height="+sHeight);
              		//return;
	  				break;
	  				
	  			case 'by_bkg':
	  				var chkRow		= SelectRow;
		  			var bkgNo		= CellValue(chkRow , "bkg_no");
		  			var blNo		= CellValue(chkRow , "bl_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal	= "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
		  			
	  				sUrl	= 'EES_DMT_3002P.do' + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  			
	  			case 'by_cntr':
	  				var chkRow		= SelectRow;
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			
		  			
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl = 'EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl = 'EES_DMT_3006P.do' + paramVal;
		  			}
	  			

	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  				
	  			case 'mvmt_inq':
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
					sHeight	= '680';
	  				break;
	  				
	  			case 'by_excinq':
	  				/*
	  				if(SearchRows == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');
	         			return;
	         		}
	  				
	  				var inqRow = 0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows = FindCheckedRow("chk").split("|");
	  					inqRow = chkRows[0];
	  				} else if(SelectRow > 0) {
	  					inqRow = SelectRow;
	  				}*/
	  				var selRow = SelectRow;
	  				var scNo = CellValue(selRow , "sc_no");
	  				var rfaNo = CellValue(selRow , "rfa_no");
	  				
	  				if(scNo != '' && rfaNo != '') scNo = '';
	  				
	  				var paramVal = "?caller=3016&sc_no=" + scNo
	  								+ "&rfa_no=" + rfaNo 
	  								+ "&trf_cd=" + CellValue(selRow , "dmdt_trf_cd")
	  								;

	  				sUrl	= 'EES_DMT_2007_1.do' + paramVal;
              		sWidth	= '1024';
              		sHeight	= '780';
              		sScroll = 'yes';
	  				break;
	  				
	  		} // switch - end
  		} // with(sheetObj) - end
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
  			
  			/*if(returnValue == "Y") {
 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
 			}*/
  		}
  	}
  	
    
    /**
     * 기존 ComResetAll() 함수에서 IBSheet Clear 처리로직만 제거한다.
     * document 안에 있는 모든 Object의 값을 초기화한다. <br>
     * Form.reset() 처리한다. IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()" 라는 <br>
     * 자바스크립트 함수가 정의되어 있다면 해당 함수를 호출하고, 해당 함수가 없다면 아무것도도 선택되지 않도록 IBMultiCombo.Code2="-1";로 설정한다. <br>
     * @return 없음
     */
    function resetSearchControls(){

        try {
            for(var i=0; i<document.forms.length; i++){
                document.forms[i].reset();
            }

            var objs = document.getElementsByTagName("OBJECT");

            for(var i = 0 ; i < objs.length ; i++){
                var sObjId = objs[i].classid;
                switch(sObjId){
//                    case CLSID_IBSHEET: //IBSheet
//                        objs[i].RemoveAll();
//                        break;
                    case CLSID_IBMCOMBO: //IBMultiCombo 경우
                        var id = objs[i].id;
                        var funcName = "initComboValue_" + id;
                        if (ComFuncCheck(funcName)) {
                            ComFunc();
                        } else {
                            objs[i].Code2="-1";
                        }
                        break;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    		 
         with(formObj){
        	 switch(sAction) {
             	case IBSEARCH:      //조회
        		
         		var condType = ComGetObjValue(cond_type);            		
         		var startDt ;
     			var endDt ;
     			var limitDt;
     			//******************** bkg 조건  ************************
     			if(condType == 'bkg') {
     				if(ComIsNull(bkg_no)) {
         				ComShowCodeMessage('DMT00102', 'BKG No.');
             			return false;
     				}
         			
         			var bkgNo = ComGetObjValue(bkg_no);
         			if(bkgNo != '') {
         				var arrBkgNo = bkgNo.split(',');
         				for(var i=0; i<arrBkgNo.length; i++) {
         					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
         						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
	                 			return false;
         					}
         				}
         			}
         			//******************** office 조건  ************************	
     			} else if(condType == 'ofc') {
             		// Office Combo Check
             		if(comboObjects[0].Text == '') {
             			ComShowCodeMessage('COM12113', "Office");
             			return false;
             		}
             		
             		if(comboObjects[1].Code == '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}else {
                    	var chgStsCd1 = comboObjects[1].Code;
                    	if(chgStsCd1.indexOf('A') != -1)
                    		chgStsCd1 = ComReplaceStr(chgStsCd1, "A,", "");	
             			formObj.dmdt_chg_sts_cd.value = chgStsCd1;
             		}
             		
        			if(!ComIsDate(fm_mvmt_dt1)) {
         				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_mvmt_dt1)) {
         				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}
         			 startDt = ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
         			 endDt = ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
          			// 기간체크
                     if (ComChkPeriod(startDt, endDt) == 0) {
                     	ComShowCodeMessage("DMT01020");
                     	return false;
                     }
                     
                     limitDt = ComGetDateAdd(startDt, "M", 1);
                     if (ComChkPeriod(endDt, limitDt) == 0) {
                     	ComShowCodeMessage("DMT00162", "1 month");
                     	return false;
                     }
                     
                     formObj.ofc_cd.value = comboObjects[0].Text;
                     ComSetObjValue(fm_mvmt_dt, startDt);
                     ComSetObjValue(to_mvmt_dt, endDt);
                //******************** MT.Loc/Yard 조건  ************************	
             	} else if(condType == 'loc')	{
             		var yardCd = ComGetObjValue(yd_cd);
             		if(ComIsNull(yd_cd)) {
         				ComShowCodeMessage('DMT00102', 'MT.Loc/Yard VVVV');
             			return false;
     				}
                    if( yardCd != '' &&  yardCd.length != 7 && yardCd.length != 5) {
                    	ComShowCodeMessage('DMT00110', 'Yard');
    					return false;
    	       		}
             		
             		if(comboObjects[2].Code == '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}else {
                    	var chgStsCd2 = comboObjects[2].Code;
                    	if(chgStsCd2.indexOf('A') != -1)
                    		chgStsCd2 = ComReplaceStr(chgStsCd2, "A,", "");	
             			formObj.dmdt_chg_sts_cd.value = chgStsCd2;
             		}
        			if(!ComIsDate(fm_mvmt_dt2)) {
         				ComAlertFocus(fm_mvmt_dt2, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_mvmt_dt2)) {
         				ComAlertFocus(to_mvmt_dt2, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}
        			 startDt = ComGetUnMaskedValue(fm_mvmt_dt2, 'ymd');
         			 endDt = ComGetUnMaskedValue(to_mvmt_dt2, 'ymd');
           			// 기간체크
                     if (ComChkPeriod(startDt, endDt) == 0) {
                     	ComShowCodeMessage("DMT01020");
                     	return false;
                     }
                     
                     limitDt = ComGetDateAdd(startDt, "M", 1);
                     if (ComChkPeriod(endDt, limitDt) == 0) {
                     	ComShowCodeMessage("DMT00162", "1 month");
                     	return false;
                     }
                     
                     ComSetObjValue(fm_mvmt_dt, startDt);
                     ComSetObjValue(to_mvmt_dt, endDt);

                 //******************** Cntr no 조건  ************************	
             	} else if(condType == 'cntr')	{
             		if(ComIsNull(cntr_no)) {
         				ComShowCodeMessage('DMT00102', 'CNTR No.');
             			return false;
     				}
         			var cntrNo = ComGetObjValue(cntr_no);
         			if(cntrNo != '') {
         				var arrCntrNo = cntrNo.split(',');
         				for(var i=0; i<arrCntrNo.length; i++) {
         					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
         						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
	                 			return false;
         					}
         				}
         			}
             		
             		if(comboObjects[3].Code == '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}else {
                    	var chgStsCd3 = comboObjects[3].Code;
                    	if(chgStsCd3.indexOf('A') != -1)
                    		chgStsCd3 = ComReplaceStr(chgStsCd3, "A,", "");	
             			formObj.dmdt_chg_sts_cd.value = chgStsCd3;
             		}
        			if(!ComIsDate(fm_mvmt_dt3)) {
         				ComAlertFocus(fm_mvmt_dt3, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_mvmt_dt3)) {
         				ComAlertFocus(to_mvmt_dt3, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}
        			 startDt = ComGetUnMaskedValue(fm_mvmt_dt3, 'ymd');
         			 endDt = ComGetUnMaskedValue(to_mvmt_dt3, 'ymd');
            			// 기간체크
                     if (ComChkPeriod(startDt, endDt) == 0) {
                     	ComShowCodeMessage("DMT01020");
                     	return false;
                     }
                     
                     limitDt = ComGetDateAdd(startDt, "M", 1);
                     if (ComChkPeriod(endDt, limitDt) == 0) {
                     	ComShowCodeMessage("DMT00162", "1 month");
                     	return false;
                     }
                     
                     ComSetObjValue(fm_mvmt_dt, startDt);
                     ComSetObjValue(to_mvmt_dt, endDt);
             	}
        		break;
        		
             	case IBSAVE:      //Confirm
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
             	
             	case IBDELETE:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Delete');
             			return false;
             		}
             		
             		var chkCnt = 0;
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'I') {
         					chkCnt++;
         				}
             		}
             		if(chkCnt == 0) {
             			ComShowCodeMessage('DMT01026');
     					return false;
             		}
             		break;
        	 } // switch-end
        	 
         } // with-end
         
         return true;
     }
      
  	/*
  	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
  	 */
  	function doInclSubOfc() {
  		var formObj = document.form;
  		
  		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
  			if( ComIsEmpty(comboObjects[0].Code) ) {
  				ComShowCodeMessage('COM12113', "Office");
  				formObj.chk_sub_ofc.checked = false;
  				return;
  			}
  			formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
  			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
  			doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND01)
  		} else {
  			ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
  		}
  	}


    /*
     * Charge Deletion 요청내용을 취소시킨다.
     */
    function doActionDelRequestCancel() {
   	 
   	 doActionIBSheet(sheetObjects[0], document.form, IBDELREQCANCEL);
    }

    /*
     * 조회를 실행합니다.
     */
    function doActionRetrieve() {
   	 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
	/* 개발자 작업  끝 */