/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0949.js
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.14 강동윤
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
     * @class ESM_BKG_0949 : ESM_BKG_0949 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0949() {
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
	var prefix="sheet1_";

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
    					case "btn2_RowAdd":
    							alert(srcName);
    					break;

    					case "btn2_Delete":
    							alert(srcName);
    					break;

    					case "btn1_Retrieve":
    							alert(srcName);
    					break;

    					case "btn1_Save":
    							alert(srcName);
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
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
            }	
            
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
    		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    		
    		document.form.yd_cd.focus(); 
    		initControl();
        }

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
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리

      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
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

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 422;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 15, 100);

    					var HeadTitle1 = "| |  |VVD|POL|Destination Country|Lane|Conti|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|User ID|Office|Update Date";
	   					var HeadTitle2 = "| |  |VVD|POL|Destination Country|Lane|Conti|ETA|ETB|ETD|DAY|Time|Time|DAY|DAY|Excluding Holiday|User ID|Office|Update Date";
                        //var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(23, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
    					InitHeadRow(1, HeadTitle2, true);
    					
                        //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		prefix + "ibflag");
    					InitDataProperty(0, cnt++ , dtDelCheck,			50,		daCenter,	true,		prefix + "del");
    					InitDataProperty(0, cnt++ , dtSeq,				50,		daCenter,	true,		prefix + "Seq");
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "vvd_cd",			false,		"",		dfNone,			0,		false,		true,	9);
    					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix + "yd_cd",			false,		"",		dfEngUpKey,		0,		false,		true,	7);
    					InitDataProperty(0, cnt++ , dtCombo,			200,	daCenter,	true,		prefix + "dest_cnt_cd",		false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtCombo,			60,		daCenter,	true,		prefix + "vsl_slan_cd",		false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtCombo,			60,		daCenter,	true,		prefix + "conti_cd",		false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		prefix + "eta",				false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		prefix + "etb",				false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		prefix + "etd",				false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		prefix + "day",				false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix + "itval_hrs",		false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix + "hour",			false,		"",		dfNone,			0,		false,		true);
    		            InitDataProperty(0, cnt++,  dtCombo,     		110,   	daLeft, 	true, 		prefix + "doc_clz_dy_cd",   false, 		"", 	dfNone,         0,  	true,  		true);
    		            InitDataProperty(0, cnt++, 	dtData,      		80,   	daLeft, 	true, 		prefix + "doc_clz_dy_hrs",  false, 		"", 	dfTimeHm,       0,  	true, 		false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			160,	daCenter,	true,		prefix + "hol_chk",			false,		"",		dfNone,			0,		true,		true);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "upd_usr_id",		false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtData,				0,		daCenter,	true,		prefix + "ofc_cd",			false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtData,				0,		daCenter,	true,		prefix + "upd_dt",			false,		"",		dfNone,			0,		false,		true);
    					InitDataProperty(0, cnt++ , dtHidden,  			0,     	daCenter,   true,   	prefix + "doc_clz_tp_cd"); 
    					InitDataProperty(0, cnt++ , dtHidden,  			0,     	daCenter,   true,   	prefix + "xcld_hol_flg");
    					InitDataProperty(0, cnt++ , dtHidden,  			0,     	daCenter,   true,   	prefix + "usr_nm");
    					
    		            InitViewFormat(0, prefix + "doc_clz_dy_hrs", "hh:mm");
    		            InitDataValid(0, 3, vtEngUpOther, "1234567890");
    					//InitDataCombo(0, "dest_cnt_cd", "All|Korea", "All|Korea",	"", "", 0);
    					//InitDataCombo(0, "vsl_slan_cd", "All|CAX", "All|CAX",	"", "", 0);
    					//CountPosition = 0;
    		            
    		            // 칼럼 Lane 에서 고정틀 설정
    		            sheetObj.FrozenCols = 7;
    			}
    			break;
            }
        }
         
      // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
         function processButtonClick(){
              /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
              var sheetObject = sheetObjects[0];

              /*******************************************************/
              var formObject = document.form;

         	try {
         		var srcName = window.event.srcElement.getAttribute("name");

     				switch(srcName) {
     					case "btn2_RowAdd":
     						sheetObject.DataInsert(-1);
     						sheetObject.CellValue2(sheetObject.SelectRow, prefix + "hour") = "Hour";
     						sheetObject.CellValue2(sheetObject.SelectRow, prefix + "itval_hrs") = " ";
     						sheetObject.CellValue2(sheetObject.SelectRow, prefix + "doc_clz_dy_cd") = " ";
     						sheetObject.SelectCell(sheetObject.SelectRow, prefix + "vvd_cd", true, '');
     					break;

     					case "btn2_Delete":
     						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
     					break;

     					case "btn_Retrieve":
     						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);  
     					break;

     					case "btn1_Save":
     						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
         
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              	case IBSEARCH:      //조회
              		if(!validateForm(sheetObj,formObj,sAction)) return;
              		
              		sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 						
		            formObj.f_cmd.value = SEARCH;   
		            sheetObj.DoSearch("ESM_BKG_0949GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		            
		            break;

		 		case IBSAVE:        //저장
		 			if(!validateForm(sheetObj,formObj,sAction)) return;
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
 						
			 		formObj.f_cmd.value = MULTI;	
			 		
			 		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");

	                sheetObj.DoSave("ESM_BKG_0949GS.do", sParam);
	
					break;
	
				case SEARCH01:      //조회(service lane code)
				
					formObj.f_cmd.value = SEARCH01;   
					var searchXml = sheetObj.GetSearchXml("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
					
					var slanCd = ComGetEtcData(searchXml,"slanCd");
					var slanVa = ComGetEtcData(searchXml,"slanVa");
					var cntNm  = ComGetEtcData(searchXml,"cntNm");
					var cntCd  = ComGetEtcData(searchXml,"cntCd");
					var contiNm  = ComGetEtcData(searchXml,"contiNm");
					var contiCd  = ComGetEtcData(searchXml,"contiCd");
					
					sheetObj.InitDataCombo(0, "sheet1_conti_cd", contiNm, contiCd,	"", "", 0);
					sheetObj.InitDataCombo(0, "sheet1_vsl_slan_cd", slanCd, slanVa,	"", "", 0);
					sheetObj.InitDataCombo(0, "sheet1_dest_cnt_cd", cntNm, cntCd,	"", "", 0);
					
					var temp = slanVa.split("|");
					
					for (var i = 1 ; i < temp.length ; i++){
					
						ComAddComboItem(formObj.vsl_slan_cd, temp[i], temp[i]);
					}
					
					break;

		            // Day Type 코드 가져오기
	            case IBSEARCH_ASYNC02:
					var prefix="sheet1_";
					
	            	formObj.f_cmd.value = SEARCH03;
	            	var sXml = sheetObj.GetSearchXml("ESM_BKG_0949GS.do", FormQueryString(formObj));
	            	
	                var arrData = ComXml2ComboString(sXml, "val", "name");
	                if (arrData != null && arrData.length == 2) {
					    sheetObj.InitDataCombo(0, prefix + "doc_clz_dy_cd", arrData[1], arrData[0]);
	                }
	            	
	                break;

				case IBDELETE:      // 삭제	 					
				
					ComRowHideDelete(sheetObj, "sheet1_del");	
				
					break;
            }
            
            ComOpenWait(false);
        }



        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            
        	switch(sAction) {
        	
        		case IBSEARCH:      //조회
        		
        			/*if (formObj.yd_cd.value == ''){
        				
        				ComShowCodeMessage("BKG00137");//POL/POD is not available
        				formObj.yd_cd.focus();        				
        				return false;
        			}*/
        		
        			break;
        			
        		case IBSAVE:        //저장

        			for(var i = 2 ; i < sheetObj.RowCount+2  ; i++){

        				if (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U'){

        					if (sheetObj.CellValue(i, prefix + "yd_cd") == ''){

        						ComShowCodeMessage("BKG00137");//POL/POD is not available
        						sheetObj.SelectCell(i, "POL", true, ''); 
        						return false;
        					}

        					if (sheetObj.CellValue(i, prefix + "eta") == '1'){
        						
        						sheetObj.CellValue2(i, prefix + "doc_clz_tp_cd") = 'A';
        					}else if (sheetObj.CellValue(i, prefix + "etb") == '1'){
        						
        						sheetObj.CellValue2(i, prefix + "doc_clz_tp_cd") = 'B';
        					}else if (sheetObj.CellValue(i, prefix + "etd") == '1'){
        						
        						sheetObj.CellValue2(i, prefix + "doc_clz_tp_cd") = 'D';
        					}else if (sheetObj.CellValue(i, prefix + "day") == '1'){
        						
        						sheetObj.CellValue2(i, prefix + "doc_clz_tp_cd") = 'Y';
        					}
        					
        					if (sheetObj.CellValue(i, prefix + "hol_chk") == '1'){
        						
        						sheetObj.CellValue2(i, prefix + "xcld_hol_flg") = 'Y';
        					}else{
        						
        						sheetObj.CellValue2(i, prefix + "xcld_hol_flg") = 'N';
        					} 
        				}
        			}

        			break;
        	}

            return true;
        }
        
         
         /**
          * ETA,ETB,ETD,DAY 체크 값 라디오 버튼 처리
          */
        function sheet1_OnClick(sheetObj,Row, Col, Value){

        	// ETA, ETB, ETD, DAY 체크 값 라디오 버튼 처리
    		if (sheetObj.ColSaveName(Col) == ( prefix + "eta")){

    			if (sheetObj.CellValue(Row, (prefix + "eta")) == 0){
    				
    				sheetObj.CellValue2(Row, (prefix + "etb")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "etd")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "day")) = 0;
    			}
    			
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_cd") = "";
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_hrs") = "";
    			
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "etb")){
    			
    			if (sheetObj.CellValue(Row, (prefix + "etb")) == 0){
    				
    				sheetObj.CellValue2(Row, (prefix + "eta")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "etd")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "day")) = 0;
    			}
    			
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_cd") = "";
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_hrs") = "";
    			
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "etd")){
    			
    			if (sheetObj.CellValue(Row, (prefix + "etd")) == 0){
    				
    				sheetObj.CellValue2(Row, (prefix + "eta")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "etb")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "day")) = 0;
    			}
    			
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_cd") = "";
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_hrs") = "";
    			
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "day")){
    			
    			if (sheetObj.CellValue(Row, (prefix + "day")) == 0){
    				
    				sheetObj.CellValue2(Row, (prefix + "eta")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "etb")) = 0;
    				sheetObj.CellValue2(Row, (prefix + "etd")) = 0;
    			}
    			
    			sheetObj.CellValue2(Row, prefix + "itval_hrs") = "";
    			sheetObj.CellValue2(Row, prefix + "doc_clz_dy_hrs") = "17:00";
    		}
    		
    		// ETA, ETB, ETD, DAY 값에 따른 활성화 항목 설정
    		keyFieldEnable (sheetObj,Row, Col, Value);
    		
    	    sheetObj.EditableColorDiff = true;

        }
          
          /**
           * POL - Destination이 같은 국가는 저장이 안되도록 처리함
           */
         function sheet1_OnAfterEdit(sheetObj,Row, Col, Value){

        	var formObj = document.form;
        	
    		if (Col == '3'){
    			if(sheetObj.CellValue(Row,Col)==""){
    				sheetObj.CellValue2(Row,Col) = "ALL";
    			}
    			
    			if(sheetObj.CellValue(Row,Col) != "ALL"){
    				
        			formObj.vvd_cd.value = sheetObj.CellValue(Row,Col);
            		 
        			formObj.f_cmd.value = SEARCH04;   					  
	       			
        			var searchXml = sheetObj.GetSearchXml("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
        			
        			var vvd_flg = ComGetEtcData(searchXml,"vvd_flg");
	       			
        			if (vvd_flg == 'N'){
	       				
        				ComShowCodeMessage("BKG00163");//VVD is NOT Registered
        				sheetObj.SelectCell(Row, Col, true, ''); 
        				
        				return;
        			}
    			}

    		}   
        	   
        	if (Col == '4' || Col == '5'){
        		
        		var polCd = sheetObj.CellValue(Row, 3);
        		var cntCd = sheetObj.CellValue(Row, 4);
        		
        		if (polCd == ''){

        			ComShowCodeMessage("BKG00137");//POL/POD is not available
        			
        			sheetObj.SelectCell(Row, 3, true, ''); 
        			
        			return;
        		}
        		
        		if (Col == '4'){
        			formObj.pol.value = sheetObj.CellValue(Row,Col);
	             		 
        			formObj.f_cmd.value = SEARCH02;   					  
	       			
        			var searchXml = sheetObj.GetSearchXml("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
	       			
        			var check = ComGetEtcData(searchXml,"check");
	       			
        			if (check == 'N'){
	       				
        				ComShowCodeMessage("BKG00164");//POL is NOT Registered
	       				 
        				sheetObj.SelectCell(Row, Col, true, ''); 
        				
        				return;
        			}
        		}        		        		
        		
        		if (polCd.substring(0,2) == cntCd){
        			
        			ComShowCodeMessage("BKG00053");//POL and POD are the same. Check booking route again.
        			
        			sheetObj.CellValue2(Row, 4) = "*";
        			
        			return;
        		}
        	}        		
        }
        
      /**
       * 셀변경후  이벤트 처리 >>> POL체크
       */ 
      /*
      function sheet1_OnChange(sheetObj, Row, Col) {
      	 
    	 var formObj = document.form;
    	 
      	 if (Col == 3){
      		 formObj.pol.value = sheetObj.CellValue(Row,Col);
      		 
      		 formObj.f_cmd.value = SEARCH02;   					  
			
			 var searchXml = sheetObj.GetSearchXml("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
			
			 var check = ComGetEtcData(searchXml,"check");
			
			 if (check == 'N'){
				
				 ComShowCodeMessage("BKG00164");//POL is NOT Registered
				 
				 sheetObj.SelectCell(Row, Col, true, ''); 
			 }
      	 }

      }
      */
       
       /**
   	 * 마이스 이동시 이벤트
   	 * @param Button
   	 * @param Shift
   	 * @param X
   	 * @param Y
   	 * @return
   	 */
   	function sheet1_OnMouseMove(Button, Shift, X, Y) {
   		//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;

   		Row = sheetObjects[0].MouseRow;
   		Col = sheetObjects[0].MouseCol;
   		
        var colSaveName = sheetObjects[0].ColSaveName(Col);
   		
   		if(colSaveName == "sheet1_upd_usr_id") {
   			sText = sheetObjects[0].CellValue(Row,16);
   		} else {
   			sText = "";
   		}

   		//풍선도움말 만들기
   		sheetObjects[0].MouseToolTipText = sText;
   		  
   	}
   	
    /**
   	 * ETA, ETB, ETD, DAY 값에 따른 활성화 항목 설정
   	 * ETA, ETB, ETD 항목 체크시 Time Field를 활성화
   	 * DAY 			 항목 체크시 Day Field를 활성화
   	 * @param sheetObj
   	 * @param Row
   	 * @param Col
   	 * @param Value
   	 * @return
   	 */
   	function keyFieldEnable (sheetObj,Row, Col, Value) {
   		
		// ETA, ETB, ETD, DAY 값에 따른 활성화 항목 설정
		if (sheetObj.ColSaveName(Col) == ( prefix + "eta") || sheetObj.ColSaveName(Col) == ( prefix + "etb") || sheetObj.ColSaveName(Col) == ( prefix + "etd")){
			
			if (sheetObj.CellValue(Row, (prefix + "eta")) == 0 || sheetObj.CellValue(Row, (prefix + "etb")) == 0 || sheetObj.CellValue(Row, (prefix + "etd")) == 0){
				sheetObj.CellEditable(Row, prefix + "doc_clz_dy_cd") = false;
				sheetObj.CellEditable(Row, prefix + "doc_clz_dy_hrs") = false;
				
        	    sheetObj.CellEditable(Row, prefix + "itval_hrs") = true;
        	    sheetObj.CellEditable(Row, prefix + "hour") = true;
        	    
			}
			
		} else if (sheetObj.ColSaveName(Col) == ( prefix + "day")) {

			if (sheetObj.CellValue(Row, (prefix + "day")) == 0 ){
        	    sheetObj.CellEditable(Row, prefix + "itval_hrs") = false;
        	    sheetObj.CellEditable(Row, prefix + "hour") = false;
        	     
				sheetObj.CellEditable(Row, prefix + "doc_clz_dy_cd") = true;
				sheetObj.CellEditable(Row, prefix + "doc_clz_dy_hrs") = true;
			}
			
		}
   	}
    
	/* 개발자 작업  끝 */