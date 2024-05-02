/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName 		: ESM_FMS_0051.js
*@FileTitle 	: BOD, BOR Monthly Interface
*Open Issues 	:
*Change history :
*@LastModifyDate: 2009.03.26
*@LastModifier 	: 정윤태
*@LastVersion 	: 1.0
* 2009.03.26 정윤태
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
     * @class BOD, BOR Monthly Interface : BOD, BOR Monthly Interface 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0051() {
    	this.processButtonClick 	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initControl 			= initControl;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_activate			= obj_activate;
    	this.obj_keypress			= obj_keypress;
    	this.sheet1_OnChangeSum		= sheet1_OnChangeSum;
    }

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
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
        		case "btn_retrieve":
        			doActionIBSheet(sheetObject,formObject,IBSEARCH);
        			break;

				case "btn_new":
					ComResetAll();
					
					//Interface To P.O.Module Button Disable 하기
			  		ComBtnDisable("btn_Interface");
					break;

				case "btn_Interface":
					
					if(sheetObjects[0].RowCount > 0) {
						doActionIBSheet(sheetObject,formObject,IBROWSEARCH);
					} else {
						ComShowMessage(ComGetMsg('FMS01230'));
						return;
					}
					
					break;
					
				case "btn_savetofile":
					
					if(sheetObjects[0].RowCount > 0) {
						sheetObject.SpeedDown2Excel(-1);
					} else {
						ComShowMessage(ComGetMsg('FMS01230'));
						return;
					}
                    break;

				case "btn_print":
					alert("btn_print");				
					break;
                	
				case "tar_mon" :
					 var cal = new ComCalendar();
					 cal.setDisplayType('month');
	                 cal.select(form.ori_bnk_yrmon, 'yyyy-MM');
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

       sheetObjects [sheetCnt++] = sheet_obj;

    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects [i]);
            
            initSheet(sheetObjects [i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

//        for(k=0;k<tabObjects.length;k++){
//            initTab(tabObjects[k],k+1);
//        }
        
        //마지막 컬럼을 전체 너='비에 맞춘다.
        sheetObjects[0].ExtendLastCol = false;

		//doActionIBSheet(sheetObjects [0],document.form,IBSEARCH);
        initControl();
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
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq|Type|Vessel Code|Acct Code|Item|Del/Re Date|Del/Re Port|UOM|Quantity|Price(USD)|Amount|VVD|If Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, 				DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,       40,    daCenter,  false,   "Seq");
                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,   "bnk_tp_cd",   		false,          "",      				dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  false,   "vsl_cd",     		false,          "",     			 	dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      72,    daCenter,  false,   "acct_cd",     		false,          "",      				dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      136,   daLeft,    false,   "acct_itm_nm",  	false,          "",      				dfNone,   	 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,   "bnk_dt",     		false,          "",      				dfUserFormat2,  0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      78,    daCenter,  false,   "port_cd",     		false,          "",      				dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      37,    daCenter,  false,   "flet_meas_ut_cd",  false,          "",      				dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      63,    daRight,   false,   "bnk_qty",     		false,          "",      				dfNullFloat, 	3,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      110,   daRight,   false,   "bnk_prc_amt",    	false,          "",      				dfNullFloat, 	4,     true,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   105,   daRight,   false,   "total_amt",     	false,          "",      				dfNullFloat, 	4,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      93,    daCenter,  false,   "bunker_vvd",     	false,          "",     				dfNone, 	 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    93,    daCenter,  false,   "if_dt",     		false,          "",     				dfNone, 	 	0,     true,       true);
					
					InitUserFormat2(0, "bnk_dt", "####-##-## ##:##", "-|:" );
					
					// 연산 +,/,+,-  (CALCULOGIC 해드 부분)||<-- 컬럼으로 인식  |bnk_qty|*|bnk_prc_amt|
					// save 를할때 dtHIDDENStatus, dtStatus(DATATYPE) 둘중에 하나 가 반드시 있어야 한다

					//MessageText ("Sum")  = ""; 
               }
               break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
          		if(validateForm(sheetObj,formObj,sAction)){
         		   formObj.f_cmd.value = SEARCH;
         		   sheetObj.DoSearch("ESM_FMS_0051GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
         	   	}
         	   	break;
         		   
          	case IBROWSEARCH:	//조회
       	   		if(validateForm(sheetObj,formObj,sAction)){
       	   			
       	   			//Interface To P.O.Module Button Disable 하기
       	   			ComBtnDisable("btn_Interface");
       	   			
	       	   		for (var ir=1; ir<=sheetObj.LastRow-1; ir++){
	       				if(sheetObj.CellText(ir,"acct_cd") == "956115") {
	       					sheetObj.CellValue2(ir,"if_dt") = "Y";
	       				}
	       			}
       	 		
       	   			formObj.f_cmd.value = MULTI;
       	   			sheetObj.DoSearch("ESM_FMS_0051GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
       	   		}
       	   		break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	화면 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj의 입력값
     * @return {boolean} 정상 여부
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){

    	if (!ComChkValid(formObj)) return false;
    	
    	if(formObj.ori_bnk_yrmon.value != "") {
         	formObj.bnk_yrmon.value = formObj.ori_bnk_yrmon.value.trimAll("-");
        }
    
        return true;
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
    	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'		   , 'obj_keypress'  , 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        //Interface To P.O.Module Button Disable 하기
  		ComBtnDisable("btn_Interface");
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    		
	    	case "ori_bnk_yrmon":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
     
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
     * IBSheet Object 합 구하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
	function sheet1_OnChangeSum( sheetObj, Row ) {
		sheetObj.SumText(0,"Seq") = "";
		sheetObj.SumText(0,"bnk_prc_amt") = "Sub-Total Amount";
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * 행 전체의 글자색을 설정하거나 확인한다
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var ifCnt = 0;
		
		for (var ir=1; ir<=sheetObj.LastRow-1; ir++){
			if(sheetObj.CellText(ir,"acct_cd") != "956115") {
				sheetObj.RowFontColor(ir) = sheetObj.WebColor("#FF0000");
			} else {
				if(sheetObj.CellValue(ir,"if_dt") == "Y") {
					ifCnt = ifCnt + 1;
				}
			}
		}

		if(ifCnt == 0 && sheetObj.rowCount > 0) {
			//Interface To P.O.Module Button Enable 하기
			ComBtnEnable("btn_Interface");
		} else {
			//Interface To P.O.Module Button Disable 하기
	  		ComBtnDisable("btn_Interface");
		}
		
		ComColFontName(sheetObj, "2"); 
		ComColFontName(sheetObj, "6"); 
		ComColFontName(sheetObj, "11");
	}
