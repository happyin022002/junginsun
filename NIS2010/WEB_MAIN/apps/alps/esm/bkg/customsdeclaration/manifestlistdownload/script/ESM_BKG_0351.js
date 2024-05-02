/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0351.js
*@FileTitle : ESM_BKG-0351
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0351() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
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
    		         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;
             

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    							case "btn_Retrieve":
    								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    								break;

    							case "btn_Save":
    								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    								break;

    							 
    							case "btn_Print":    		
    								doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
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
            var formObject = document.form;
            
            if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
            {
            	if(formObject.vvd_no.value.length > 0)
            	{
            		formObject.vsl_cd.value     = formObject.vvd_no.value.substring(0,4);
            		formObject.skd_voy_no.value = formObject.vvd_no.value.substring(4,8);
            		formObject.skd_dir_cd.value = formObject.vvd_no.value.substring(8);
            		formObject.vvd_number.value = formObject.vvd_no.value;
            		
            		//Add. 2015.04.20
                	if(formObject.pod_clpt_ind_seq.value !=""){
                		formObject.frm_pod_clpt_ind_seq.value = formObject.pod_clpt_ind_seq.value;
                	}
            	}
            	 
            	formObject.frm_crn_number.value = formObject.cn_no.value;
            	
            	formObject.f_cmd.value = SEARCH;    					 
				sheetObjects[0].RemoveAll();    					     					
					sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0351GS.do", FormQueryString(formObject));
				    
				var arrXml = sXml.split("|$$|");
				 
		   	  	if (arrXml.length > 0) {			   	  		 
		   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
		   	  	}
            }
    			axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);        	 
            	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
            	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
            	 
        }
         
        


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    				var sheetID = sheetObj.id;
            switch(sheetID) {

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 342;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 16, 100);

    					var HeadTitle1 = " |Chk.|Seq.|B/L No.|CRN|Container No.|Type|QTY|POL|POD|POD Calling\nSeq.|Consignee|TTL WGT|Unit|";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,		true,		"ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,				40,		daCenter,		true,		"CHK",				    false,			"",      dfNone,			0,		true,	true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,		"ib_file_seq",			false,			"",      dfNone,			0,		true,	true);
						InitDataProperty(0, cnt++ , dtData,					110,	daCenter,		true,		"bl_no",				false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					110,	daCenter,		true,		"frm_crn_number",		false,			"",      dfNone,			0,		false,	true);

						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,		true,		"cntr_no",	            false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,		"cntr_tpsz_cd",			false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,		"pck_qty",				false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		"pol_cd",				false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		"pod_cd",				false,			"",      dfNone,			0,		false,	true);
						
						InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		"pod_clpt_ind_seq",		false,			"",      dfNone,			0,		false,	true);

						InitDataProperty(0, cnt++ , dtData,					280,	daLeft,			true,		"ntfy_addr",		    false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					80,		daRight,		true,		"bkg_ttl_qty",			false,			"",      dfNullFloat,		3,		false,	true);
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		true,		"bkg_ttl_qty_ut_cd",	false,			"",      dfNone,			0,		false,	true);
						InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,		true,		"bkg_no",	            false,			"",      dfNone,			0,		false,	true);    					 


    										CountPosition = 0;
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
          
            switch(sAction) {
             
            			case COMMAND01:        
            				 vIsCheck = 0;
            				 for(i=1; i<=sheetObjects[0].RowCount; i++) {        				    	          				    	
         				    		if(sheetObj.CellValue(i, "CHK") == 1)
         				    			vIsCheck++;         				    		          				    	 		    		   
         				    }
         				    
          					if (vIsCheck == 0) {
          						ComShowCodeMessage('BKG00249');	
          						return;
          					}
            				
            				
            				var bl_no = loadBlNo(sheetObj,formObj);
            				 
            				var sParam = "bl_no="+bl_no;        					
            				ComOpenWindowCenter("/hanjin/ESM_BKG_0352.do?pgmNo=ESM_BKG_0352&"+sParam, "ESM_BKG_0352", 1024, 600, true);
            				break;
            				 
    					case IBSEARCH:      //조회
    					if(!validateForm(sheetObj,formObj,sAction)) {
     						return false;
     					}
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;    					 
    					sheetObjects[0].RemoveAll();
    					formObj.vsl_cd.value = formObj.vvd_number.value.substring(0,4);
     					formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4,8);
     					formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
     					
     					//Add. 2015.04.20
                    	if(formObj.pod_clpt_ind_seq.value !=""){
                    		formObj.frm_pod_clpt_ind_seq.value = formObj.pod_clpt_ind_seq.value;
                    	}
                    	
     					sXml = sheetObj.GetSearchXml("ESM_BKG_0351GS.do", FormQueryString(formObj));
     				    
    					var arrXml = sXml.split("|$$|");
    					 
    			   	  	if (arrXml.length > 0) {			   	  		 
    			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
    			   	  	}
    			   	  	ComOpenWait(false);
    					break;

    					case IBSAVE:        //저장
    					if(!validateForm(sheetObj,formObj,sAction)) {
     						return false;
     					}
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = MULTI;
    					var sParam = "";					 
    					var sParamSheet = sheetObjects[0].GetSaveString();
    					if (sParamSheet != "") {
    						sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
    					}					 
    					sParam += "&" + FormQueryString(formObj);    					
    					var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0351GS.do", sParam);
    					sheetObjects[0].LoadSaveXml(sXml);
    					sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
    					formObj.f_cmd.value = SEARCH;    					 
    					sheetObjects[0].RemoveAll();    					     					
     					sXml = sheetObj.GetSearchXml("ESM_BKG_0351GS.do", FormQueryString(formObj));
     				    
    					var arrXml = sXml.split("|$$|");
    					 
    			   	  	if (arrXml.length > 0) {			   	  		 
    			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
    			   	  	}
    			   	  	ComOpenWait(false);
    					break;

    					 
            }
        }

        /**
         * 
         * @param sheetObj
         * @param formObj
         * @return
         */
        function loadBlNo(sheetObj,formObj)
        {
        	var chkBlNo = "";     
        	var cnt = 0;
        	var bl_no = "";
        	for (var i=1; i <= sheetObj.RowCount; i++) {
		    		
		    		if(sheetObj.CellValue(i, "CHK") == 1)
		    		{	
		    			cnt++;
		    			bl_no = "";
		    			bl_no = sheetObj.CellValue(i, "bl_no");		    			 		    			 		    					    				
		    			chkBlNo = chkBlNo + bl_no.substring(0,12);
		    			chkBlNo = chkBlNo + "|";		    			 
		    		} 							 
				} 	
        	return chkBlNo;
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch (sAction) {
     			case IBSEARCH: // 조회
     		 
     			if (formObj.frm_crn_number.value == "" && formObj.vvd_number.value == "" ) 
     			{
     				ComShowCodeMessage('BKG00591');
     				formObj.vvd_number.focus();
     				return false;
     			}  
     			if (formObj.vvd_number.value.length > 0 && formObj.vvd_number.value.length < 9) {
     				ComShowCodeMessage('BKG00710');
     				formObj.vvd_number.focus();
     				return false;
     			}
     			if (formObj.pol_cd.value.length > 0 && formObj.pol_cd.value.length < 5) {
     				ComShowCodeMessage('BKG00711');
     				formObj.pol_cd.focus();
     				return false;
     			}
     			return true;  
     			break;
     			case IBSAVE: // 저장
     			var vIsCheck = false;
     			for(var i=1; i <= sheetObj.RowCount; i++) {     				
     				if (sheetObj.CellValue(i, "ibflag") == "U") {
     					vIsCheck = true;
     					break;
     				}
     			}
     			if (!vIsCheck) {
     				ComShowCodeMessage('BKG00737');
     				return false;
     			}
     		    return true;
     			 break;
        	 }
        } 
         /**
         * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
         **/
         function obj_KeyUp() {
         	     
         	    var formObject = document.form;        
         	    var srcName = window.event.srcElement.getAttribute("name");
         	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
         	    var srcValue = window.event.srcElement.getAttribute("value");
         	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
         	    	ComSetNextFocus();        	    		
         	    }
         }
       /**
        * 엔터 입력시 조회 
        * @return
        */  
         function obj_ComKeyEnter() {
         	
             var formObject = document.form;
             var srcName = window.event.srcElement.getAttribute("name");
                  
             if(srcName != "") {         		 
               	ComKeyEnter();
              }         	         
      }