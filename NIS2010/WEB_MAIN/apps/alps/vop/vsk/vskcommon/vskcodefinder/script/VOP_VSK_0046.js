/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0046.js
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
* 
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
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
     * @class VOP_VSK_0046 : VOP_VSK_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0046() {
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

var bakObj = null;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObj,IBSEARCH)
					break;
					
				case "btns_calendar_s":
					var cal = new ComCalendar();
					cal.select(formObj.fm_dt, 'yyyy-MM-dd');

					break;

				case "btns_calendar_e":
					var cal = new ComCalendar();
					cal.select(formObj.to_dt, 'yyyy-MM-dd');

					break;
					
//				case "btn_pop":
//					var landCd = formObj.vsl_slan_cd.value;
//					var sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + landCd;
//        			var rVal = ComOpenPopupWithTarget(sUrl, 422, 490, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
//					if(rVal){
//						//formObj.vsl_slan_cd.value = rVal;
//					}
//					break;
					
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
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
        
        initControl();
        document.form.vsl_slan_cd.focus();

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
            case "sheet1":      // sheet1 init
                with (sheetObj) {
                	
                	tabIndex = -1;
                	
                    // 높이 설정
                    style.height = 440;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
//                    InitHeadMode(false, true, false, true, false,false);

                    var HeadTitle1 = "|S.Lane Code|Rev.Lane\nCD|Lane Name|Service Type|Trade|Sub-Trade|Direction Code|Direction Code"
                    var HeadTitle2 = "|S.Lane Code|Rev.Lane\nCD|Lane Name|Service Type|Trade|Sub-Trade|1st|2nd"

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);



                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,	daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					true,		"vsl_slan_cd",		false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					true,		"rlane_cd",			false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		260,	daLeft,						true,		"vsl_slan_nm",		false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					true,		"vsl_svc_tp_cd",	false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					true,		"trd_cd",			false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					true,		"sub_trd_cd",		false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					false,		"dir_cd1",			false,	"",		dfNone,			0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,					false,		"dir_cd2",			false,	"",		dfNone,			0,			false,	false);

					DataRowMerge(0) = true;
					ScrollBar = 2;

			   }
                break;
                 
                

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
	           if(validateForm(sheetObj,formObj,sAction)){
	        	   sheetObj.WaitImageVisible = false;
	        	   formObj.f_cmd.value = SEARCH;
        		   var sParam = FormQueryString(formObj);
        		   ComOpenWait(true);
        		   sheetObj.DoSearch("VOP_VSK_0046GS.do" , sParam);
        		   ComOpenWait(false);
        		   formObj.vsl_slan_cd.focus();
        	   }
               break;
                
           case SEARCH01: //Trade, Sub Trade, Service Type 조회
           		formObj.f_cmd.value = SEARCH01;
           		var sParam = FormQueryString(formObj);
           		var sXml = sheetObj.GetSearchXml("VOP_VSK_0046GS.do", sParam);
           		
           		//trd_cd, sub_trd_cd, svc_tp_cd setting.
           		var trd_cd_arr = ComGetEtcData(sXml, "trd_cd");
           		var sub_trd_cd_arr = ComGetEtcData(sXml, "sub_trd_cd");
           		var vsl_svc_tp_cd_arr = ComGetEtcData(sXml, "vsl_svc_tp_cd");
           		
    			var svcTpCdcomboObj = formObj.vsl_svc_tp_cd;
    			svcTpCdcomboObj.options.length = 0;
    			svcTpCdcomboObj.options.add(new Option("ALL", ""));
    			
    			if(vsl_svc_tp_cd_arr){
    				vsl_svc_tp_cd_arr = vsl_svc_tp_cd_arr.split("|");
    				for(var i=0; i<vsl_svc_tp_cd_arr.length; i++){
    					svcTpCdcomboObj.options.add(new Option(vsl_svc_tp_cd_arr[i], vsl_svc_tp_cd_arr[i]));	
    				}
    			}
           
           		var trdCdcomboObj = formObj.trd_cd;
           		trdCdcomboObj.options.length = 0;
           		trdCdcomboObj.options.add(new Option("ALL", ""));
           		
           		if(trd_cd_arr){
           			trd_cd_arr = trd_cd_arr.split("|");
           			for(var i=0; i<trd_cd_arr.length; i++){
           				trdCdcomboObj.options.add(new Option(trd_cd_arr[i], trd_cd_arr[i]));	
           			}
           		}
           		
           		var subTrdCdcomboObj = formObj.sub_trd_cd;
           		subTrdCdcomboObj.options.length = 0;
           		subTrdCdcomboObj.options.add(new Option("ALL", ""));
           		
           		if(sub_trd_cd_arr){
           			sub_trd_cd_arr = sub_trd_cd_arr.split("|");
           			for(var i=0; i<sub_trd_cd_arr.length; i++){
           				subTrdCdcomboObj.options.add(new Option(sub_trd_cd_arr[i], sub_trd_cd_arr[i]));	
           			}
           		}
           		
           		break;
           		
//           case SEARCH01:	// Lane Code 조회
//        	   formObj.f_cmd.value = SEARCH;
//       		   var sParam = FormQueryString(formObj);
//       		   var rXml = sheetObj.GetSearchXml("VOP_VSK_0046GS.do" , sParam);
//       		   var nm = ComGetEtcData(rXml, "vsl_slan_nm");
//	       		if(nm!=null){
//	       			formObj.vsl_slan_nm.value = nm;
////	       			formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
//	       			ComSetNextFocus();
//	       		}else{
//	       			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
//	       			formObj.vsl_slan_cd.value = "";
////	       			formObj.tmp_vsl_slan_cd.value = "";
//	       			formObj.vsl_slan_nm.value = "";
//	       			formObj.vsl_slan_cd.focus();
//	       		}
//        	   break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

    	var vsl_slan_cd = formObj.vsl_slan_cd;
    	var vsl_slan_nm = formObj.vsl_slan_nm;

//    	with(formObj){
//    		if (ComChkLen(vsl_slan_cd, 1)==1 && ComChkLen(vsl_slan_nm, 1)==1){
//    			ComShowCodeMessage("VSK00022", "1", "'Lane Code' or 'Lane Name'");
//    			formObj.vsl_slan_cd.focus();
//    			return false;
//    		}
//    	}
    	if(!(formObj.fm_dt.value=="" && formObj.to_dt.value=="")){
    		if(formObj.fm_dt.value==""){
    			ComShowCodeMessage("COM12114", "Period");
    			formObj.fm_dt.focus();
    			return false;
    		}else if(formObj.to_dt.value==""){
    			ComShowCodeMessage("COM12114", "Period");
    			formObj.to_dt.focus();
    			return false;
    		}
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
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('deactivate', "obj_deactivate", formObj);		//- 변경이벤트 처리
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
    axon_event.addListener('keypress', 'eng_keypress' , 'form');		//- 영문 입력하기
    axon_event.addListener('keypress', 'enter_keypress', 'form');		//- Enter 키 처리
	axon_event.addListener('keyup', "VskKeyFocus", 'form');			//- 자동포커스 처리
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur', formObj); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	
// 	setToday(document.form.fm_dt, "ymd");//today 설정
//	setToday(document.form.to_dt, "ymd");
}

function obj_focus() {
	switch(event.srcElement.name){
		case "vsl_slan_cd":
			bakObj = event.srcElement.value;
			break;
	}
	
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문자 입력 처리한다. <br>
 **/
function eng_keypress() {
	var name = event.srcElement.name;
	switch(name){
		case "vsl_slan_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "vsl_slan_nm":
			if(event.keyCode!=32){ // 공백입력가능
				ComKeyOnlyAlphabet('uppernum');
			}
			break;
		default:
	}
}

/**
 * HTML Control의 포커스를 잃었을때 발생하는 이벤트를 처리한다.
 */
function obj_deactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(obj.value=="" || ComChkLen(obj.value, 3)!=2){
				break;
			}
			if(bakObj != obj.value){
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
			break;
	}

}
 
 /**
  * onBlur처리 
  * @return
  */
 function obj_blur(){

	 var formObj = document.form;
   	 obj = event.srcElement;      	
   	 
   	 with(formObj){
   		 if(obj.name=="fm_dt" || obj.name=="to_dt"){
   			 var fmDt = ComReplaceStr(fm_dt.value,"-","");
   			 var toDt = ComReplaceStr(to_dt.value,"-","");
   			 
   			 switch(obj.name) {
	    	    	case "fm_dt":	// From Date
    	    			if(fmDt != ""){
    	    				var dt = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
    	    				if(dt != ""){
    	    					if(toDt != ""){
    	    						if(fmDt > toDt){
    	    							ComShowCodeMessage('COM12133','To date','From date','greater');
    	    							fm_dt.value='';
    	    							document.form.fm_dt.focus();
    	    							return false;
    	    						}
    	    					}
    	    					formObj.fm_dt.value = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
    	    				}else{
    	    					ComShowCodeMessage('VSK00003');
    	    					fm_dt.value='';
    	    					document.form.fm_dt.focus();
    	    				}
    	    			}
	    	            break;
	    	            
	    	    	case "to_dt":	// To Date
	    	    		if(toDt != ""){
	    	    			var dt = ComGetMaskedValue(formObj.to_dt.value, "ymd");
	    	    			if(dt != ""){
	    	    				if(fmDt != ""){
	    	    					if(fmDt > toDt){
	    	    						ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    						to_dt.value='';
	    	    						to_dt.focus();
	    	    						return false;
	    	    					}
	    	    				}
	    	    				formObj.to_dt.value = ComGetMaskedValue(formObj.to_dt.value, "ymd");
	    	    			}else{
	    	    				ComShowCodeMessage('VSK00003');
	    	    				to_dt.value='';
	    	    				to_dt.focus();
	    	    			}
	    	    		}
	    	           	break;	
	        	}
   		 	}
       }
       return true;	
 } 

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}
 

 /* 개발자 작업  끝 */
