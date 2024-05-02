/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0205.js
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.04.27 김진일
* 1.0 Creation
* 
* 2010.11.24 이석준 CHM-201007129-01 Service provider help pop-up내 Delete 칼럼 추가
* 2012.08.02 진마리아 CHM-201219306-01 팝업 오류 수정
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
     * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0205() {
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
    var usrOfcCd = "";/*SSO 유저의 office cd를 저장 */
    var isShift = false;
    
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
        		//alert(srcName);
            switch(srcName) {
    							
    						case "btn_Retrieve":
    							//alert(srcName);
    							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    							break;

    						case "btn_OK":
    							//alert(srcName);
    							comPopupOK(); //--> 선택된 로우가 넘어 간다. 이넘을 호출 하면.. 
    							break;
    							
    						case "btn_Close":
    							window.close();
    							break;
    						case "btns_search":
////    							alert('VOP_VSK-0244 PopUp');
//    							sUrl = "/hanjin/VOP_VSK_0244.do";
//    	                		ComOpenPopup(sUrl, 430, 440, "getCntCdData", "0,0", true);
								var sUrl = "/hanjin/COM_ENS_0M1.do";
								ComOpenPopup(sUrl, 565, 470, "getCntCdData", "1,0,1,1,1,1,1,1", true);
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
         * 국가 Code설정 
         * @param obj
         * @return
         */
        function getCntCdData(obj){
        	if(obj){
    			var rtnDatas = obj[0];
    			if(rtnDatas){
    				if(rtnDatas.length > 0){
    					document.form.vndr_cnt_cd.value = rtnDatas[3];
    				}
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
        	
        	var formObject = document.form;
        	formObject.ofc_cd.value = usrOfcCd; //ofc cd 설정.
        	
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

            for(i=0;i<sheetObjects.length;i++){
            	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }
            initControl();
            self.focus();
        }
         /**
          * 컨트롤 초기화 
          * @return
          */
        function initControl(){
//        	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        	axon_event.addListener ('keydown', 'obj_keydown', 'form');
        	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
        	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
        	axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        }

        function obj_activate(){
        	ComSetFocus(event.srcElement);//포커스 설명 및 select설정
      	}
        
        function obj_keydown(){
        	isShift = event.shiftKey ? true : false;
        	ComKeyEnter();
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
    							style.height = 202;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = false;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, 100);

    							//var HeadTitle1 = "|#|S/P Code|Service Provider Name";
    							var HeadTitle1 = "|S/P Code|Service Provider Name|Delete";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							var prefix="sheet1_";
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		"Status");
    							//InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,		prefix+"tcnt"); //COUNT를 위해 추가 
    							InitDataProperty(0, cnt++ , dtData,				70 ,	daCenter,	true,	prefix+"vndr_seq",			false,		"",	dfNone,				0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,				300,	daLeft,		true,	prefix+"vndr_lgl_eng_nm",	false,		"",	dfNone,				0,		false,	false);    							
    							InitDataProperty(0, cnt++ , dtData,				60 ,	daCenter,	true,	prefix+"delt_flg",			false,		"",	dfNone,				0,		false,	false);
    							
    							
    							//카운트를 표시할 포지션 /0의 경우 비표시 
    							CountPosition = 0;
    							
    							//토탈카운트표시
    							//CountFormat = "[SELECTDATAROW / TOTALROWS]"; 

    						}
    					break;
            }
        }

       /**
        *  Sheet관련 프로세스 처리
        */ 
       function doActionIBSheet(sheetObj,formObj,sAction) {
        	sheetObj.WaitImageVisible=false;
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            	case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction)){
						if ( sheetObj.id == "sheet1"){
							ComOpenWait(true);
							formObj.f_cmd.value = SEARCH;
			                sheetObj.DoSearch("VOP_PSO_0205GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			                ComOpenWait(false);
						}
						else if(sheetObj.id=="sheet2"){
							//sheetObj.DoSearch("vop_PSO_0205_DATA1.html");
							formObj.f_cmd.value = SEARCH;
					        sheetObj.DoSearch("VOP_PSO_0205GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
						}
					}
					break;
            }
        }
        

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
			with(formObj){
				var ofcCd 	  = ComTrim(ofc_cd.value); 
				var vndrCntCd = ComTrim(vndr_cnt_cd.value);
				
				switch(sAction) {
					case IBSEARCH:
						if(ofcCd == "" && vndrCntCd == ""){
							ComShowCodeMessage("PSO00036", "[Office or Country]");
							ofc_cd.focus();
							return false;
						}
					break;
				}
			}	
			
            return true;
        }

        /**
         * 검색된 열에서 Double Click 시 PopUp을 발생시킨 위치에 데이터를 설정한다.
         */
        function sheet1_OnDblClick(sheetObj, Row, Col) {
        	comPopupOK();
        }
         /**
          * keypress처리 함수
          * @return
          */
         function obj_keypress(){
       	    obj = event.srcElement;
       	
       	    //KEYTYPE이 마우스 클릭이면 리턴.
			if (!event.keyCode) return true;
			
			if(obj.dataformat == null) return;
       	    window.defaultStatus = obj.dataformat;
       	
       	    switch(obj.dataformat) {
       	        case "ymd":
       	        case "ym":
       	        case "hms":
       	        case "hm":
       	        case "jumin":
       	        case "saupja":
       	            ComKeyOnlyNumber(obj);
       	            break;
       	        case "int":
       	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
       	            else ComKeyOnlyNumber(obj);
       	            break;
       	        case "float":
       	            ComKeyOnlyNumber(obj, "-.");
       	            break;
       	        case "eng":
       	            ComKeyOnlyAlphabet(); break;
       	        case "engup":
       	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
       	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
       	            else ComKeyOnlyAlphabet('upper');
       	            break;
       	        case "engdn":
       	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	            else ComKeyOnlyAlphabet('lower');
       	            break;
       	    }
       	}
        /**
         * KEYUP의 경우 FOCUS이동 처리를 한다. 
         * @return
         */
		function obj_keyup() {
			var eleObj = event.srcElement;
			var formObj = document.form;
			
			//KEYTYPE이 마우스 클릭이면 리턴.
			if (!event.keyCode) return;
			
			if(event.keyCode === 9 || isShift ) return ;
			
//			alert(event.keyCode);//Shift+Tab
			
			switch (eleObj.name) {
			case "ofc_cd":
				if (eleObj.value.length == 6) {
					formObj.vndr_cnt_cd.focus();
				}
				break;
			case "vndr_cnt_cd":
				if (eleObj.value.length == 2) {
					formObj.vndr_lgl_eng_nm.focus();
				}
				break;
			default:
				break;
		
			}
		}
		
		/*
		 * sheet1 조회후처리
		 */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			if(sheetObj.RowCount==0) return;
			markDeletedSP(sheetObj);
		}
		
		/*
		 * Delete가 'Y'인 Row 구분 표기
		 */
		function markDeletedSP(sheetObj){
			var prefix = sheetObj.id + "_";
			for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+sheetObj.RowCount; Row++){
				if("Y"==sheetObj.CellValue(Row, prefix+"delt_flg")){
					sheetObj.RowFontColor(Row) = sheetObj.RgbColor(192, 192, 192);
				}
			}	
		}

	/* 개발자 작업  끝 */