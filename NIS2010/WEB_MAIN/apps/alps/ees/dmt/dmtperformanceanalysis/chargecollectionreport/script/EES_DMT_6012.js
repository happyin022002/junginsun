/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ees_dmt_6012.js
 *@FileTitle : Pre-Advice Report (Vessel Loading)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : Cho won joo
 *@LastVersion : 1.0
 * 2012.06.22  Cho won joo
 * 1.0 Creation
 * 2012.08.29  Cho won joo 
 * ------------------------------------------------------

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
 * @class EES_DMT_6012 : EES_DMT_6012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_dmt_6012() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.tsTpCd_OnChange=tsTpCd_OnChange;
}
/* 개발자 작업 */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

		 var sheetObject = sheetObjects[0];
         var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_down_excel":
					
						doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
					
						//doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
					
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
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * 
      * @param {IBMultiCombo}
      *            combo_obj IBMultiCombo Object
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
     }
     
//     /**
//      * IBTab Object를 배열로 등록
//      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
//      * 배열은 소스 상단에 정의
//      */
//     function setTabObject(tab_obj){
//         tabObjects[tabCnt++] = tab_obj;
//     }
           
     /**
      * OP DATE  기간 선택 달력 띄우기
      */
     function callDatePop(val){
		var formObj = document.form;
        var cal = new ComCalendarFromTo();
        cal.select(formObj.s_fm_dt, formObj.s_to_dt, 'yyyy-MM-dd');
   	}




    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
    	var formObj = document.form;

        for(i=0;i<sheetObjects.length;i++){
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}        

        //=========================================================================================
        // 변경일자 : 2017.10.16 
        // 변경내용 : Period 를 12개월로 변경함.
        // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
        //==========================================================================================     
		formObj.s_fm_dt.value = ComGetDateAdd(null, "M", -1 * REPORT_INQUIRY_PERIOD, "-");
		formObj.s_to_dt.value = ComGetNowInfo();
		
		initControl();
    }
  
//     /**
//      * 조회조건 입력할 때 처리
//      */
//     function obj_KeyUp() {
//    	  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//    	  var formObject = document.form;
//	     var srcName = window.event.srcElement.getAttribute("name");
//	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
//	     var srcValue = window.event.srcElement.getAttribute("value");
//	     if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
//	     	ComSetNextFocus();
//	     }
//     }
     
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {

		DATE_SEPARATOR = "-";
  	
		var formObject = document.form;
		
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
		
	}


    /**
     * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
    * @author  김민정
     */
  function obj_KeyPress(){
      var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
      var srcName = event.srcElement.getAttribute("name");
      var srcValue = event.srcElement.getAttribute("value");

      switch(event.srcElement.dataformat) {
          case "ymd":
        	  ComKeyOnlyNumber(event.srcElement);
        	  if (srcValue.length == 4) {
        		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
        	  }
        	  if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
        		  return;
        	  }
        	  if (srcValue.length == 7) {
        		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
        	  }
              break;
          case "ymdhm":
        	  ComKeyOnlyNumber(event.srcElement);
        	  if (srcValue.length == 4) {
        		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
        	  }
        	  if (srcValue.length == 7) {
        		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
        	  }
        	  if (srcValue.length == 10) {
        		  document.form.elements[srcName].value = srcValue.substring(0,10) + " "
        	  }
        	  if (srcValue.length == 13) {
        		  document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
        	  }
              break;
          case "ym":
              ComKeyOnlyNumber(event.srcElement);
              if (srcValue.length == 4) {
                document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
              }
              break;
          case "yw":
          case "jumin":
          case "saupja":  //숫자 + "-"
              ComKeyOnlyNumber(event.srcElement, "-"); break;
          case "hms":
              ComKeyOnlyNumber(event.srcElement, ":");
              if (srcValue.length == 2) {
            	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
              }
              if (srcValue.length == 5) {
            	  document.form.elements[srcName].value = srcValue.substring(0,5) + ":"
              }
              break;
          case "hm":    //숫자 + ":"
              ComKeyOnlyNumber(event.srcElement, ":");
              if (srcValue.length == 2) {
            	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
              }
              break;
          case "yy":    //숫자 + "0"
              ComKeyOnlyNumber(event.srcElement, "0"); break;
          case "int":    //숫자
              ComKeyOnlyNumber(event.srcElement);  break;
          case "float":  //숫자+"."
              ComKeyOnlyNumber(event.srcElement, "."); break;
          case "signedfloat":  //숫자+".-"
            ComKeyOnlyNumber(event.srcElement, ".-"); break;
          case "commafloat":  //숫자+",-"
                ComKeyOnlyNumber(event.srcElement, ",-"); break;
          case "dashfloat":  //숫자+",-"
            ComKeyOnlyNumber(event.srcElement, "-"); break;
          case "eng":    //영문 + 숫자
            // 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
              ComKeyOnlyAlphabet('uppernum'); break;
          case "engup":  //영문대문자
              ComKeyOnlyAlphabet('upper'); break;
          case "engdn":  //영문소문자
              ComKeyOnlyAlphabet('upper'); break;
          case "engupnum"://숫자+"영문대분자"입력하기
          	  ComKeyOnlyAlphabet('uppernum'); break;
          case "engnum"://숫자+"영문대소"입력하기
      	  	  ComKeyOnlyAlphabet('num'); break;
          case "engupspace": //영문대문자 + Space
              if(event.keyCode != 32) {
                  ComKeyOnlyAlphabet('uppernum');
              }
          case "engupspace2": //영문대문자 + Space
	          if(event.keyCode != 32) {
	        	  ComKeyOnlyAlphabet('upper');
	          }
              break;
          case "engupspecial": // 영문대문자 + Space + &-,.
              ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
              break;
          case "etc": //모든 문자 가능하지만 영문은 대문자로
              if(keyValue >= 97 && keyValue <= 122) {//소문자
                  event.keyCode = keyValue + 65 - 97;
              }
          	  break;
          default:     //영문 + 숫자
              ComKeyOnlyAlphabet('uppernum'); break;
        }
    }
     
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var sheetID = sheetObj.id;
				
        switch(sheetID) {

		      case "sheet1":      //sheet1 init
			        with (sheetObj) {
			
			        	var cnt = 0;
			            // 높이 설정
			            style.height = 180;
			            
			            //전체 너비 설정
			            SheetWidth = 100;
			
			            //Host정보 설정[필수][HostIp, Port, PagePath]
			            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			            //전체Merge 종류 [선택, Default msNone]
			            MergeSheet = msHeaderOnly;
			
			           //전체Edit 허용 여부 [선택, Default false]
			            Editable = true;
			
			            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			            InitRowInfo(1, 1, 4);
			
			            var HeadTitle1 = "|TMNL|Lane|VVD|Vessel Name|OPR|ETA|ETB|ETD|";
						var headCount = ComCountHeadTitle(HeadTitle1);					
			
			            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			            InitColumnInfo(headCount, 0, 0, true);
			
			            // 해더에서 처리할 수 있는 각종 기능을 설정한다
			            InitHeadMode(true, true, true, true, false,false)
			            
			            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			            InitHeadRow(0, HeadTitle1, true);
			
			            //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,	"ibflag");
						InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	false,	"tml_yd_cd",		false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	false,	"tml_lan_cd",			false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	false,	"tml_vvd",				false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 150,	daLeft,		false,	"tml_vsl_nm",  			false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"tml_opr",   			false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,		 	 80,	daCenter,	false,	"tml_vps_eta_dt",   	false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,		 	 80,	daCenter,	false,	"tml_vps_etb_dt",   	false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,		 	 80,	daCenter,	false,	"tml_vps_etd_dt",   	false,		"", 	dfNone,		0,			false,		false);

						InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"tml_clpt_ind_seq",   	false,		"", 	dfNone,		0,			false,		false);
			       }
			       break;
            case "sheet2":      //sheet3 init
                with (sheetObj) {

	            	var cnt = 0;
                    // 높이 설정
                    style.height = 220;
                    
                    //전체 너비 설정
                    SheetWidth = 400;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet =  msHeaderOnly ;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7);
                    

                    var HeadTitle1 = "|Seq.|M.B/L No.|VVD|CNTR No.|Type|OC|VD|Stat|POL|POD|Consignee|Notify|SC No|RFA No|Tariff|S/C or APVL No.|Requset|APVL|Add|Total|SAT|SUN|H/Day";
					var headCount = ComCountHeadTitle(HeadTitle1);					

	    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(headCount, 0, 0, true);
	    			
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	    			

                    //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		 30,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"bl_no",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"vvd",				false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"cntr_no",			false,		"", 	dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		     40,	daCenter,	true,	"cntr_tpsz_cd",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     80,	daCenter,	true,	"oc_evnt_dt",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     80,	daCenter,	true,	"vd_evnt_dt",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     40,	daCenter,	true,	"cnmv_sts_cd",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     60,	daCenter,	true,	"pol_cd",			false,		"", 	dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,		     60,	daCenter,	true,	"pod_cd",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daLeft,		true,	"cnee_nm",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daLeft,		true,	"noty_nm",			false,		"", 	dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"sc_no",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"rfa_no",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"dmdt_trf_cd",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     100,	daCenter,	true,	"prop_no",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     60,	daCenter,	true,	"rqst_ofc_cd",		false,		"", 	dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,		     60,	daCenter,	true,	"apvl_ofc_cd",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     40,	daRight,	true,	"add_dys",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     40,	daRight,	true,	"ttl_dys",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     40,	daCenter,	true,	"excl_sat",			false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     40,	daCenter,	true,	"excl_sun",			false,		"", 	dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,		     40,	daCenter,	true,	"excl_holi",		false,		"", 	dfNone,		0,			false,		false);
					

               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("EES_DMT_6012GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				}
				break;
				
			case SEARCH01:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObjects[1].RemoveAll();
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("EES_DMT_6012GS.do", FormQueryString(formObj));
			
				sheetObj.LoadSearchXml(sXml); 
//				var arrXml = sXml.split("|$$|");
//				if (arrXml.length > 0) {
//					sheetObjects[1].LoadSearchXml(arrXml[0]);
//					
//				}
				break;
			
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel(-1, false, false, true);
				break;

        }
  	}
   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
					if(!ComIsDate(formObj.s_fm_dt)) {
         				ComAlertFocus(formObj.s_fm_dt, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(formObj.s_to_dt)) {
         				ComAlertFocus(formObj.s_to_dt, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}        	 		
	                
  					var startDt = ComGetUnMaskedValue(formObj.s_fm_dt, 'ymd');
         			var endDt = ComGetUnMaskedValue(formObj.s_to_dt, 'ymd');
         			/*
         			ComChkPeriod(fromDate, toDate)
         			0 : fromDate > toDate
         			1 : fromDate < toDate
         			2 : fromDate = toDate
         			*/
                    // 기간체크
                    if (ComChkPeriod(startDt, endDt) == 0) {
                    	ComShowCodeMessage("DMT01020");
                    	return false;
                    }
                    
                    //=========================================================================================
                    // 변경일자 : 2017.10.16 
                    // 변경내용 : Period 를 12개월로 변경함.
                    // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
                    //==========================================================================================
                    var limitDt = ComGetDateAdd(startDt, "M", REPORT_INQUIRY_PERIOD);
                    if (ComChkPeriod(endDt, limitDt) == 0) {
                    	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
                    	return false;
                    }
				break;

			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;	
    	}
        return true;
    }
//    /**
//     * 조회완료후 이벤트
//     */
//	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
//    	document.form.tot_bl_cnt.value = sheetObj.RowCount;
//
//
//	}
     
//    /**
//     * 조회완료후 이벤트
//     */
// 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
//     	document.form.tot_cntr_cnt.value = sheetObj.RowCount;
//
// 	}
     
    /**
     * Booking Creation 화면 이동
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	 document.form.tml_yd_cd.value = sheetObjects[0].CellValue(Row,"tml_yd_cd")
    	 document.form.tml_clpt_ind_seq.value = sheetObjects[0].CellValue(Row,"tml_clpt_ind_seq")
    	 document.form.tml_vvd.value = sheetObjects[0].CellValue(Row,"tml_vvd")
    	 doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
    }
     
     
     
//    /**
//     * Tab 클릭시 이벤트 관련
//     * 선택한 탭의 요소가 활성화 된다.
//     */
//    function tab1_OnChange(tabObj, nItem) {
//    	var objs = document.all.item("tabLayer");
//
//    	objs[nItem].style.display = "Inline";
//    	objs[beforetab].style.display = "none";
//
//		// --------------- 요기가 중요 --------------------------//
//		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
//		// ------------------------------------------------------//
//		beforetab = nItem;
//    }

