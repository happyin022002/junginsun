/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0054.js
 *@FileTitle : TDR Creation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.04
 *@LastModifier : 장창수
 *@LastVersion : 1.0
 * 2009.09.04 장창수
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
 * @class fns_joo_0054 : fns_joo_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0054() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;

					case "btnCalFr":
						var cal = new ComCalendar();
						cal.select(form.from_dt, 'yyyy-MM-dd');
						break;

					case "btnCalTo":
						var cal = new ComCalendar();
						cal.select(form.to_dt, 'yyyy-MM-dd');
						break;
						
					case "btn1_pop_lane":

	                     ComOpenPopup("/hanjin/COM_ENS_081.do", 820, 460, "getCOM_ENS_081", "1,0,1,1,1");
					break;		
					
					case "btn_downexcel":
						sheetObject1.SpeedDown2Excel();
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
        initControl();
		//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	var form = document.form;
     	
         //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerFormat('blur', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        //axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  form);    
     	axon_event.addListener  ('blur'  , 'from_dt_onblur', 'from_dt');//- customer code 입력 후 name 가져오기
        axon_event.addListener  ('blur'  , 'to_dt_onblur', 'to_dt');//- customer code 입력 후 name 가져오기
        axon_event.addListener  ('keyup', 'slan_cd_keyup', 'slan_cd');	

      }
     //Axon 이벤트 처리2. 이벤트처리함수
     function obj_deactivate(){
         ComChkObjValid(event.srcElement);
     }

     function obj_activate(){
         ComClearSeparator(event.srcElement);
     }
     
 	 function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ymd":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		    case "engup":
		        
		         ComKeyOnlyAlphabet('upper');
		    break;
		    
		    case "uppernum":
		    	ComKeyOnlyAlphabet('uppernum');
		    	break;
           
		}
	 }   

     //stl_yr 변경시 조회 
     function from_dt_onblur(){
     	
     	var formObject = document.form;
        
		if (formObject.from_dt.value ==null || formObject.from_dt.value ==""){
			
			ComShowCodeMessage('JOO00116','from date');
			ComSetFocus(formObject.from_dt);
			
			return false;
		}
     }   
     
     //stl_yr 변경시 조회 
     function to_dt_onblur(){
     	//alert("e_stl_yrmon_onblur");
     	var formObject = document.form;

		if (formObject.to_dt.value ==null || formObject.to_dt.value ==""){
			
			ComShowCodeMessage('JOO00116','to date');
			ComSetFocus(formObject.to_dt);
			
			return false;
		}	
	}

     function slan_cd_keyup(){
    	
 	    var formObject = document.form;

 	    if (formObject.slan_cd.value.length == 3){
 	    	 //alert("slan_cd_keyup");
 	    	setSlanCdYn();
 		}
 	}
     
     /*
     * 팝업으로 lane코드 입력시 해당 lane코드의 유무조회한다.  <br>
     */
     
     function setSlanCdYn(){
    	 
    	 var formObj = document.form;
    	
    	 formObj.f_cmd.value = SEARCHLIST01;
    	 var prefix = "sheet1_";
    	 //alert(formObj.slan_cd.value);
    	 var sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0054GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

     	 if(ComGetEtcData(sXml,"vslSlanCd") == ""){
				 ComShowCodeMessage('JOO00110');
				 formObj.slan_cd.value = "";
				 ComSetFocus(formObj.slan_cd);
				 return;
 	     }else{
 	    	formObj.slan_cd.value = ComGetEtcData(sXml,"vslSlanCd");
 	     }
  
     }  
     
	 function getCOM_ENS_081(rowArray) {
		 
	     var colArray = rowArray[0];
	     document.all.slan_cd.value = colArray[3];
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
                    style.height = 418;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Lane|V.V.D|V.V.D|V.V.D|Seq.|Port|ETD|Change Status|Creation DT|Slot Used|Upload\nStatus";
											
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix = "sheet1_";	
                    	
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,	"Status");
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		prefix+"slan_cd",				false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,		true,		prefix+"vsl_cd",				false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					55,		daCenter,		true,		prefix+"skd_voy_no",				false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		true,		prefix+"skd_dir_cd",				false,		"",						dfNone,			0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,		prefix+"clpt_seq",				false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		prefix+"vps_port_cd",				false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		true,		prefix+"vps_etd_dt",				false,		"",						dfUserFormat2,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					160,	daCenter,		true,		prefix+"skd_cng_sts_cd",			false,		"",						dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					160,	daCenter,		true,		prefix+"update_time",		false,		"",						dfUserFormat2,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				    80,	daCenter,		true,		prefix+"slot_used",			false,		"",						dfNone,			0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,                 80,    daCenter,       true,       prefix+"pagerows",         false,      "",                     dfNone,         0,          false,      false);
                    
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"update_time", "####-##-## ##:##", "-|:" );										

			    }
                break;
          
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
	             if (validateForm(sheetObj, formObj, sAction)){
	             	
	                 if ( sheetObj.id == "sheet1"){
	     				 formObj.f_cmd.value = SEARCH;
	     				 var prefix = "sheet1_";	//prefix 문자열 배열
	
		    			var sXml = sheetObj.GetSearchXml("FNS_JOO_0054GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		    			sheetObjects[0].LoadSearchXml(sXml);
	
	                 }
	                 
	             }
				
			break;
			
			case IBSAVE:        //저장	
				break;	
			case IBINSERT:      // 입력
				break;
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
 		sheetObj.ShowDebugMsg = false;
 		var formObject = document.form;
 		var prefix="sheet1_";
       var from_dt = formObject.from_dt.value;
       var to_dt = formObject.to_dt.value;
 		switch (sAction) {

			
			   case IBSEARCH: //조회

				    if (formObject.slan_cd.value ==null || formObject.slan_cd.value ==""){
					    //ComShowCodeMessage('TOT00054');
					    ComShowCodeMessage('JOO00116','Lane code');
					    ComSetFocus(formObject.slan_cd);
					    return false;
				    }
					if (formObject.from_dt.value ==null || formObject.from_dt.value ==""){
						ComShowCodeMessage('JOO00116','From date');
  						ComSetFocus(formObject.from_dt);
  						return false;
  					}

					if (formObject.to_dt.value ==null || formObject.to_dt.value ==""){
						ComShowCodeMessage('JOO00116','To date');
  						ComSetFocus(formObject.to_dt);
  						return false;
  					}			   

					var frDt = ComReplaceStr(formObject.from_dt,"-","");

					var toDt = ComReplaceStr(formObject.to_dt,"-","");

					if (ComGetDaysBetween(frDt, toDt) < 0){
						ComShowCodeMessage("JOO00078");
						ComSetFocus(formObject.to_dt);
						return false;
					}
				break;
			   case IBSAVE:   //저장
			   
			   break;
 			default:
 				break;
 		}
 		return true;

  }
