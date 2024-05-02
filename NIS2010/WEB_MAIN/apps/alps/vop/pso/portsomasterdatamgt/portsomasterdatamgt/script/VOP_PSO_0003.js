/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0003.js
*@FileTitle : Vessel  management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명종 
*@LastVersion : 1.0
* 2009.05.19 박명종
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
     * @class VOP_PSO_0003 : VOP_PSO_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0003() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

	    		case "btn_retrieve":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	    			break;
	
	    		case "btn_new":
	    			//Grid Data Clear 및 날짜 
	    			//clearCondition();
	    			sheetObject1.RemoveAll();
	    			formObject.srh_cnd.value = 1;
	    			setToday(formObj.from_date,"ym");
	    			setToday(formObj.to_date,"ym");
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

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }

            //for(i=0;i<sheetObjects.length;i++){
            //}
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            initControl(sheetObjects[0]);  
        }

        
        /**
         * Form의 Conrol 를 초기화 시킨다. <br>
         * @param  {object} sheetObj	필수
         * @return 없음
         * @author 김창식
         * @version 2009.05.20
         */
        function initControl(sheetObj){
        	// Form 객체 선언
        	formObj = document.form;
        	setToday(formObj.from_date,"ym");
        	setToday(formObj.to_date,"ym");
            // axon event 등록
            axon_event.addListenerFormat('keypress', 'obj_keypress', form);
            axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
            axon_event.addListenerForm('keyup', 'obj_keyup', form);
        }
        
        

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    			var sheetid = sheetObj.id;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 448;
    
        					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(2, 1, 3, 100);

//					var HeadTitle1 = "Seq.|VSL CD|VSL Name|Vessel particular|||||||||||";

var tempTilte = "Vessel particular"; 
var HeadTitle = "Vessel particular"; 

for (var i = 1; i < 11; i++) { 
HeadTitle = HeadTitle + "|" + tempTilte; 
} 


					var HeadTitle1 = "Seq.|VSL CD|VSL Name|"+HeadTitle;
					var HeadTitle2 = "Seq.|VSL CD|VSL Name|GRT|NRT|Class|LOA|DWT|SCNT|Allowance TEU|BM|Summer Draft";
    					
    					var headCount = ComCountHeadTitle(HeadTitle2);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 3, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					//InitHeadMode(true, true, false, true, false,false);

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, true);
    					InitHeadRow(1, HeadTitle2, false);
    					var prefix = "sheet1_";



      					InitDataProperty(0, cnt++ , dtDataSeq,			40,			daCenter,	true,	"seq");
      					InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix+"vsl_cd");
      					InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix+"vsl_eng_nm");
      					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"grs_rgst_tong_wgt");
      					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	prefix+"net_rgst_tong_wgt");
      					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"cntr_vsl_clss_capa");
      					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"loa_len");
      					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix+"dwt_wgt");
      					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	prefix+"crw_knt");
      			//		InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	prefix+"vsl_rgst_cnt_cd");
      					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"cntr_pnm_capa");
      					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix+"vsl_wdt");
      					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	prefix+"smr_drft_hgt");

    						}
    						break;
            }
        }

 
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	  if( !validateForm(sheetObj,formObj,sAction) )
        	  	return;
        	  
        	  
        	  sheetObj.ShowDebugMsg = false;
        	  var aryPrefix = new Array("sheet1_", "sheet2_");
        	    switch(sAction) {
        	      case IBSEARCH:      //조회
        	        sheetObjects[0].WaitImageVisible = false;
        	        ComOpenWait(true);
	                formObj.f_cmd.value = SEARCH;
	                sheetObj.DoSearch("VOP_PSO_0003GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
//        	    	  formObj.f_cmd.value = SEARCH;

					//다중조회
//					var sXml = sheetObj.GetSearchXml("VOP_PSO_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
//					var arrXml = sXml.split("|$$|");
//					for(var i = 0; i < arrXml.length; i++){ 
//						sheetObjects[i].Redraw = false;    
//						if(i > 0) {
//							sheetObjects[i].WaitImageVisible = false;	
//						}  
//						sheetObjects[i].LoadSearchXml(arrXml[i]); 
//						sheetObjects[i].Redraw = true; 
//					}
	                
	                ComOpenWait(false);
        	        break;
        	    }
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            
                  if(! ComIsDate( formObj.from_date.value , "ym" ) ) {
                  	ComShowCodeMessage('PSO00014', "[from_date]");
                  	return false;
                  }

                  if(! ComIsDate( formObj.to_date.value , "ym" ) ) {
                	ComShowCodeMessage('PSO00014', "[to_date]");
                  	return false;
                  }
                  
                  
                  if( ComTrimAll(formObj.from_date.value, "-" ) > ComTrimAll(formObj.to_date.value, "-" ) ) {
                	ComShowCodeMessage('PSO00014', "[date]");
                  	return false;
                  }	
            
            }

            return true;
        }

	
	function validMonth(obj){
            if(! ComIsDate( obj.value , "ym" ) ) {
            	obj.value = "";
            	return false;
            }
	}

	function setMonth(obj){
            var cal = new ComCalendar();
            cal.setDisplayType('month');
            cal.select(obj, "yyyy-MM");
	}
	
	
	function setToDate(obj){
	   if( !validMonth(obj) )
	   	return;
	   form.to_date.value = ComGetDateAdd(form.from_date.value, "M", 12, "-").substring(0,7);	
	}
	
	
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "from_date":
		    	if(eleObj.value.length == 6){
		    		formObj.to_date.focus();
		    	}
				break; 
		    case "to_date":
		    	if(eleObj.value.length == 6){
		    		formObj.srh_cnd.focus();
		    	}
				break;
		}
	}
	
	
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */ 
    function obj_keypress(){
   	 obj = event.srcElement;
   	 if(obj.dataformat == null) return;
   	 	
   	 window.defaultStatus = obj.dataformat;
   	 
	   	 switch(obj.dataformat) {
	   	 	case "ym": case "ymd":
	   	 		ComKeyOnlyNumber(obj);
	   	 		break;
	   	 }
    }
     
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_activate(){
   	 ComClearSeparator(event.srcElement);
    }
    
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_deactivate(){
 	
   	 var formObj = document.form;
   	 obj = event.srcElement;      	
   	 
   	 with(formObj){
   		 if(obj.name=="from_date" || obj.name=="to_date"){
   			 var creDtFr = ComReplaceStr(from_date.value,"-","");
   			 var creDtTo = ComReplaceStr(to_date.value,"-","");
	        	
   			 switch(obj.name) {
	    	    	case "from_date":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				from_date.value='';
	    	    				document.form.from_date.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    			
	    	            break;
	    	            
	    	    	case "to_date":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				to_date.value='';
	    	    				to_date.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	           	break;	
	        	}
	        
   			ComChkObjValid(event.srcElement);
   		 }
       }
       return true;	
   }	
	/* 개발자 작업  끝 */