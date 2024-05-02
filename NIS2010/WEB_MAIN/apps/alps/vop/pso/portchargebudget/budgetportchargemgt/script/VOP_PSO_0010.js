/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0010.js
*@FileTitle : Estimate Expense Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
* 
* History
* 2010.10.04 유혁 CHM-201006127-01 운하 통항비 tariff Cost 생성 로직 변경
* 2011.04.12 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완 - vsl popup 호출로직 수정
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
     * @class VOP_PSO_0010 : VOP_PSO_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.clearConditon			= clearConditon;//조회 조건 클리어 
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var isShift = false;
    var arrChk = [0, 0, false];	//sheet1의 chk 컬럼을 하나만 선택할 수 있도록.. [현재 Row, 이전 Row, checked]

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
                case "btn_detail":
                	sUrl = "/hanjin/VOP_PSO_0213.do?";
                	sUrl += "sdt="+formObject.txtsdate.value + "&edt="+formObject.txtedate.value
                	     +"&vslCd="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_vsl_cd")
                	     +"&skdVoyNo="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_skd_voy_no")
                	     +"&skdDirCd="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_skd_dir_cd")
                	     +"&ydCd="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_tmnl_code")
                		 +"&revYrmon="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_rev_yrmon")
                		 +"&psoBztpCd=2" //2009.12.07 add 
                		 ;
            		ComOpenPopup(sUrl, 1030, 625, "", "0,0", true);
            		break;
                case "btns_search":
                	openLaneCode();
                	break;
                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
    	            cal.select(form.txtsdate, "yyyy-MM");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
                	cal.select(form.txtedate, "yyyy-MM");
                	break;
                case "btn_vvd_search":
					var vsl_cd = formObject.vsl_cd.value;
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
                		ComOpenPopup(sUrl, 460, 493, "getVslCdData", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 340, 393, "getVvdData", "0,0", true);
                	}
				break;
              case "btn_retrieve":
//    						alert(srcName);
            	  			if(!checkVvd(document.form)) break;
            	  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    						break;

              case "btn_new":
//    						alert(srcName);
            	  			clearConditon(document.form);
    						break;

              case "btn_exp":
		            	    if(arrChk[2] == false){	//Checked된 Row가 없을 경우,
		            		    ComShowCodeMessage("PSO00039");
		            		    return;
		            	    }
            	  			
    						doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
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
         * VVD의 3항목에 한개라도 값이 셋팅되면 3개 모두 셋팅되어야 함을 체크 한다. 
         * @param formObj
         * @return
         */
        function checkVvd(formObj){
        	
        	formObj.vvd.value = ""; 
        	 
        	if( formObj.vsl_cd.value != "" 
	          ||formObj.skd_voy_no.value != ""
	          ||formObj.skd_dir_cd.value != "")
        	{
        		if(formObj.vsl_cd.value == "")
        		{
        			ComShowCodeMessage("PSO00031");
        			formObj.vsl_cd.focus();
        			return false;
        		}
        		else if(formObj.skd_voy_no.value == "")
        		{
        			ComShowCodeMessage("PSO00032");
        			formObj.skd_voy_no.focus();
        			return false;
        		}
        		else if(formObj.skd_dir_cd.value == "")
        		{
        			ComShowCodeMessage("PSO00033");
        			formObj.skd_dir_cd.focus();
        			return false;
        		}
        		else{
        			formObj.vvd.value = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
        			return true;
        		}
        	}
        	return true;
        }
        
        /**
         * 조회 조건을 Clear한다. 
         * @return
         */	
        function clearConditon (formObj)
        {
//        	formObj.txtsdate.value = "";
//        	formObj.txtedate.value = "";
//        	formObj.lane.value = "";
//        	formObj.vsl_cd.value = "";
//        	formObj.skd_voy_no.value = "";
        	formObj.reset();
        	setToday(document.form.txtsdate, "ym");//올해 설정
         	setToday(document.form.txtedate, "ym");//올해 설정
         	sheetObjects[0].RemoveAll();//Grid Clear 
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
//            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

            initControl();
    	}
         /**
          * 컨트롤 관련 초기화 처리 
          */
         function initControl(){
        	axon_event.addListener ('keydown', 'obj_keydown', 'form');
         	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
          	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
          	axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
          	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
         	//budget year필드를 올해로 설정
         	//alert(setToday("y"));
         	setToday(document.form.txtsdate, "ym");//올해 설정
         	setToday(document.form.txtedate, "ym");//올해 설정
         }
          function obj_keydown(){
          	isShift = event.shiftKey ? true : false;
          	ComKeyEnter();
          }
          /**
           * onBlur처리 
           * @return
           */
          function obj_blur(){
         	  var formObj = document.form;
         	   	 obj = event.srcElement;      	
         	   	 
         	   	 with(formObj){
         	   		 if(obj.name=="txtsdate" || obj.name=="txtedate"){
         	   			 var creDtFr = ComReplaceStr(txtsdate.value,"-","");
         	   			 var creDtTo = ComReplaceStr(txtedate.value,"-","");
         		        	
         	   			 switch(obj.name) {
         		    	    	case "txtsdate":	// Agreement From Date
         		    	    		if(creDtFr != '' && creDtTo != ''){
         		    	    			if(creDtFr > creDtTo){
         		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
         		    	    				txtsdate.value='';
         		    	    				txtsdate.focus();
         		    	    				return false;
         		    	    			}
         		    	    		}
         		    	    			
         		    	            break;
         		    	            
         		    	    	case "txtedate":	// Agreement To Date
         		    	    		if(creDtFr != '' && creDtTo != ''){
         		    	    			if(creDtFr > creDtTo){
         		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
         		    	    				txtedate.value='';
         		    	    				txtedate.focus();
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

          /**
           * onFocus처리 
           * @return
           */
          function obj_focus(){
              ComClearSeparator(event.srcElement);
          }
         /**
          * keypress처리 함수
          * @return
          */
         function obj_keypress(){
       	    obj = event.srcElement;
       	    
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
       	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum');
       	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
       	            else if(obj.name==="lane" || obj.name==="vsl_cd") ComKeyOnlyAlphabet('uppernum');	//영대문자와 숫자
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
    		if (!event.keyCode) return true;
    		
			if(event.keyCode === 9 || isShift ){
//				alert(event.keyCode);
				return true;
			}
			
     		switch (eleObj.name) {
     		case "txtsdate":
     			if (eleObj.value.length == 6) {
     				formObj.txtedate.focus();
     			}
     			break;
     		case "txtedate":
     			if (eleObj.value.length == 6) {
     				formObj.lane.focus();
     			}
     			break;
     		case "lane":
     			if (eleObj.value.length == 3) {
     				formObj.vsl_cd.focus();
     			}
     			break;
     		case "vsl_cd":
     			if (eleObj.value.length == 4) {
     				formObj.skd_voy_no.focus();
     			}
     			break;
     		case "skd_voy_no":
     			if (eleObj.value.length == 4) {
     				formObj.skd_dir_cd.focus();
     			}
     			break;
     		default:
     			break;
     	
     		}
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
    							style.height = 447;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msAll;//msNone;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, 100);

//    							var HeadTitle1 = "|Seq.|YYYYMM|LANE|IND|ERR|CHK|VVD|TMNL 1|TMNL 2|TMNL 3|TMNL 4|TMNL 5|TMNL 6";
    							var HeadTitle1 = "|Seq.|Rev. Month|LANE|CHK|VVD|TMNL Code|Color|hvvd|vsl_cd|skd_voy_no|skd_dir_cd|turn_port_flg|turn_port_ind_cd|turn_skd_voy_no|turn_skd_dir_cd|turn_clpt_ind_seq|clpt_ind_seq|vir_turn_port_flg|vir_turn_port_ind_cd";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							var prefix = "sheet1_";
    							//데이터속성    [ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
//    							InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	true,		prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	false,		"Seq");
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"rev_yrmon",			false,		"",			dfDateYm,	0,			false,		true);
    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,		prefix+"lane",				false,		"",			dfNone,		0,			false,		true);
//    							InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"IND",						false,		"",			dfNone,		0,			true,		true);
//                                                                  	                                                         
//    							InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"ERR",						false,		"",			dfNone,		0,			true,		true);
    							InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	false,		prefix+"chk",				false,		"",			dfNone,		0,			true,		true);
    							InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		prefix+"vvd",				false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,		prefix+"tmnl_code",			false,		"",			dfNone,		0,			false,		true);
//                                                                  	                                                         
//    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"TMNL2",					false,		"",			dfNone,		0,			true,		true);
//    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"TMNL3",					false,		"",			dfNone,		0,			true,		true);
//    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"TMNL4",					false,		"",			dfNone,		0,			true,		true);
//    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"TMNL5",					false,		"",			dfNone,		0,			true,		true);
//    							InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"TMNL6",					false,		"",			dfNone,		0,			true,		true); 
    							InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	false,		prefix+"txtcolor",			false,		"",			dfNone,		0,			false,		true); 
    							InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	false,		prefix+"hvvd",				false,		"",			dfNone,		0,			false,		true); 
    							//T1.VSL_CD,  T1.SKD_VOY_NO, T1.SKD_DIR_CD,
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"vsl_cd",			false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"skd_voy_no",		false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"skd_dir_cd",		false,		"",			dfNone,		0,			false,		true);
    							
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"turn_port_flg",		false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"turn_port_ind_cd",	false,		"",			dfNone,		0,			false,		true);
    							
    							// CHM-201006127-01
    							// Estimate Expense Creation 관련 Turning Port에 대한 정보
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"turn_skd_voy_no",	false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"turn_skd_dir_cd",	false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"turn_clpt_ind_seq",	false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"clpt_ind_seq",		false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"vir_turn_port_flg",		false,		"",			dfNone,		0,			false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		prefix+"vir_turn_port_ind_cd",	false,		"",			dfNone,		0,			false,		true);
    							
//    							MassOfSearch = 1;//2009.12.22. added
//    							ScrollTrack = false;
    						}
    						break;

    						
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            sheetObj.WaitImageVisible=false;
            switch(sAction) {
              case IBSEARCH:      //조회
              	if (validateForm(sheetObj, formObj, sAction)){
					if (sheetObj.id == "sheet1") {
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH;
						formObj.mismatched.value = formObj.mismatched.checked == true ? "checked" : "";
						sheetObj.DoSearch("VOP_PSO_0010GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam("sheet1_"));
						ComOpenWait(false);
					}
               	}
				break;
              case IBCREATE://Expense Apply 버튼 Click
	              if (sheetObj.id == "sheet1") {
						ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						sheetObj.DoSave("VOP_PSO_0010GS.do", FormQueryString(formObj) + "&"
								+ ComGetPrefixParam("sheet1_"));
						ComOpenWait(false);
					}
              	  break;
              default: 
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
            }

            return true;
        }
            
            /**
             * VVD관련 데이터 설정 
             * @param obj
             * @return
             */
            function getVslCdData(obj){
            	if(obj){
        			var rtnDatas = obj[0];
        			if(rtnDatas){
        				if(rtnDatas.length > 0){
        					document.form.vsl_cd.value = rtnDatas[1];
        				}
        			}
            	}
            }

        	function getVvdData(obj){
            	if(obj){
        			var rtnDatas = obj[0];
        			if(rtnDatas){
        				if(rtnDatas.length > 0){
        					document.form.skd_voy_no.value = rtnDatas[2];
        					document.form.skd_dir_cd.value = rtnDatas[3];
        				}
        			}
            	}
            }

        	/*
        	 * sheet1의 chk 컬럼을 하나만 선택할 수 있도록
        	 */            
        	function sheet1_OnBeforeCheck(sheetObj, Row, Col){
        		var formObj = document.form;
        		var prefix = "sheet1_";
        		sheetObj.ShowDebugMsg = false;
        		 	 
        		switch (sheetObj.ColSaveName(Col)) {
        			case prefix + "chk" :
        				var valChk = sheetObj.CellValue(Row, Col);
        				arrChk[1] = arrChk[0];	
        				arrChk[0] = Row;	
        				
        				if(arrChk[1] != 0 && arrChk[0] != arrChk[1]){
        					sheetObj.CellValue(arrChk[1], Col) = false;	//previous
        				}

        				arrChk[2] = valChk == true ? false : true;	//checked
        			break;
        		}
        	}
        	
	/* 개발자 작업  끝 */