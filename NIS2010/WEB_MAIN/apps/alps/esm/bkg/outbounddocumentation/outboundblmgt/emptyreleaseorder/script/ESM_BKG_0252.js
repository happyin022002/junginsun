/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0252.js
*@FileTitle : Empty Container Release Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.10 최도순
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
     * @class ESM_BKG_0252 : ESM_BKG_0252 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0252() {
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

    var rdObjects = new Array();
    var rdCnt = 0;

	var from_hm;
	var to_hm;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
            var sheetObject = sheetObjects[0];
            var sheetObject1 = sheetObjects[1];

            /*******************************************************/
            var formObject = document.form;
            var param="";
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
    					case "btn_CheckAll":
    						CellCheckAll(sheetObject,true,"Check");
    						break;

    					case "btn_UncheckAll":
    						CellCheckAll(sheetObject,false,"Check");
    						break;

    					case "btn_Print":
    						if (CheckGrid(sheetObject,"")){ 
    							rdOpen(rdObjects[0],formObject,sheetObject);
    						}
    						break;

    					case "btn_Preview":
    						if (CheckGrid(sheetObject,"")){ 
    							rdOpenWindow(rdObjects[0],formObject,sheetObject);
    						}
    						break;

    					case "btn_EditFAXEmail":
    						/*
    						UI_BKG-0221	"btnDisableFlg = 'N',
    						editDisableFlg = 'N',
    						rdId, bkgNoList"""	"Fax No
    						E-Mail 주소"	"입력된 Fax,E-Mail주소를 
    						전체 해당되는 Fax,Mail로 변경한다"
    						 */
    						if (CheckGrid(sheetObject,"")){ 
    				        	var width = 355;
    							var height = 170;
    							var left = (screen.width-width)/2;
    							var top = (screen.height-height)/2;
    							ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
    							//send popup
    							var formObject3 = document.form3;
    							formObject3.elements["pop_mode"   ].value = "1";
    							formObject3.elements["display"    ].value = "1,0,1,1,1,1,1";
    							formObject3.elements["func"       ].value = "getCOM_Fax_Email_POPUP";
    							formObject3.elements["row"        ].value = "0";
    							formObject3.elements["col"        ].value = "0";
    							formObject3.elements["sheetIdx"   ].value = "0";
    							formObject3.elements["bkg_no"     ].value = "";
    							formObject3.elements["send_hidden"].value = "Y";
    							formObject3.action = "/hanjin/ESM_BKG_0221.do";
    							formObject3.target = "ESM_BKG_0221";
    							formObject3.submit();
    						}
    						break;

    					case "btn_FAX":
    						if (!ComShowCodeConfirm("BKG00734")) return;    
    						
    						if (CheckGrid(sheetObject,"")){ 
    							makeRdParam(rdObjects[0],formObject,sheetObject);
    							doActionIBSheet(sheetObject,formObject,"FAX");
    						}
    						
    						break;  

    					case "btn_EMail":
    						if (!ComShowCodeConfirm("BKG00735")) return;
    						
    						if (CheckGrid(sheetObject,"")){
    							makeRdParam(rdObjects[0],formObject,sheetObject);
    							doActionIBSheet(sheetObject,formObject,"EMAIL");
    						}
    						break;  

    					case "btn_EDI":
    						if (!ComShowCodeConfirm("BKG00447")) return;    
    						
    						if (CheckGrid(sheetObject,"")){
    							makeRdParam(rdObjects[0],formObject,sheetObject);
    							doActionIBSheet(sheetObject,formObject,"EDI");
    						}
    						break;  

    					case "btn_EmailEdit":
    						if(!validateForm(sheetObject,formObject,"btn_EmailEdit")) {
    							return false;
    						}
    						doActionIBSheet(sheetObject,formObject,"btn_EmailEdit");
    						break;

    					case "btn_Retrieve":
    						sheetObject.Redraw = false;
    						doActionIBSheet(sheetObject,formObject,IBSEARCH);
    						sheetObject.Redraw = true;
    						break;  

    					case "btn_New":
    						backupHhmm(formObject);
    						sheetObject.RemoveAll();
    						ComResetAll();
    				    	ComClearObject(formObject.elements["from_dt"]);
    				    	ComClearObject(formObject.elements["end_dt"]);
    				    	ComClearObject(formObject.elements["bkg_ofc_cd"]);
    				    	break;

    					case "btn_DownExcel":
    	 					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	 					break;

    					case "btns_calendar":
    						var cal = new ComCalendarFromTo();
    						backupHhmm(formObject);
    						cal.setEndFunction("restoreHhmm");
    						cal.select(formObject.from_dt, formObject.end_dt,'yyyy-MM-dd hh:mm');
    						break;

    					case "btns_calendar2":
    						var cal = new ComCalendarFromTo();
    						cal.select(formObject.from_dt2, formObject.end_dt2,'yyyy-MM-dd');
    						break;

    					case "btn_Remark":
    						if (CheckGrid(sheetObject,"")){ 
    							var arrRow = ComFindText(sheetObject,"Check", 1);
    							var rmk = "";
    							if (arrRow && 0<arrRow.length) {
    								rmk = 1==arrRow.length ? sheetObject.CellValue(arrRow[0],"diff_rmk") : "";
    							}
    							formObject.elements["inter_rmk"].value = rmk;
    							ComOpenWindow("ESM_BKG_0913.do?screen_id=0252","ESM_BKG_0913","toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=500,height=320",true);
    						}
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
    		initRdConfig(rdObjects[0]);
    		initControl();
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		
    		
    		if(document.form.cnt_cd.value =="US"){
    			document.form.ser_type[2].checked = true;
    			chkSerType(document.form.ser_type[2]);
    		}else{
    			chkSerType(document.form.ser_type[1]);
    		}
    		
    		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
    			ComSetDisplay("btn_Fax1", false);
    		}
    		

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
        	//** Date 구분자 **/
        	DATE_SEPARATOR = "-";
        	
        	var formObject = document.form;
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
                        style.height = 340;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;
                        
                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                        
                        //데이터 행의 높이를 자동으로 조정할지 여부를 확인하거나 설정 [선택, Default false]
                        AutoRowHeight = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 100);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false, false);

                        var HeadTitle1 = "|Seq.|Sel.|Booking No.|Booking No.|R|D|CNTR Qty|FH|POR|POL|E/Q OFC|SCC|P/UP CY|CY Name|Fax No.|E-mail|P/UP Date|VVD|T.VVD|VVD Name|RTN CY|Shipper|Commodity|Commodity Detail(s)|Loading Date|I/P|Empty/Full/Terminal|Empty/Full/Terminal|EDI Receiver|EDI Send Date|Fax Sent Date|Fax Result|E-mail Sent Date|E-mail Result|External Remark|Remark(s)|col_chk|tmpl_param|fax_snd_rslt_nm|eml_snd_rslt_nm";
                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 5, 0, true);
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [		ROW, COL,  	DATATYPE,   			WIDTH, DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                    	InitDataProperty(0, cnt++ , dtData,	       	40,     daCenter,   true,   "Seq",				false,	"",	dfNone,			0,	false,	false,	-1,	false,	false);
						InitDataProperty(0,	cnt++,	dtData,			40, 	daCenter,	false,	"Check",        	false,	"",	dfNone,			0,	true,	false,	-1,	false,	false,	false,	true);
                    	InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,	"bkg_no",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,	"bkg_sts_cd",		false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,	"rcv_term_cd",		false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,	"de_term_cd",		false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"cntr_qty",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			22,		daCenter,	true,	"flex_hgt_flg",		false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			42,		daCenter,	true,	"por_cd",			false,	"",	dfNone,			0,	false,	false,	-1,	false);

						InitDataProperty(0, cnt++ , dtData,			42,		daCenter,	true,	"pol_cd",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"eq_ctrl_ofc_cd",	false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			42,		daCenter,	true,	"scc_cd",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"mty_pkup_yd_cd",	false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			240,	daLeft,		true,	"cy_name",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ntc_fax_no",		false,	"",	dfNone,			0,	true,	true,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ntc_eml",			false,	"",	dfNone,			0,	true,	true,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"mty_pkup_dt",		false,	"",	dfNone,	        0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			72,		daCenter,	true,	"vvd",				false,	"",	dfNone,			0,	false,	false,	20,	false);
						InitDataProperty(0, cnt++ , dtData,			72,		daCenter,	true,	"tvvd",				false,	"",	dfNone,			0,	false,	false,	20,	false);

						InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,	"vvd_name",			false,	"",	dfNone,			0,	false,	false,	-1,	false);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"full_rtn_yd_cd",	false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"cust_nm",			false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cmdt_cd",			false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"cmdt_nm",			false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lodg_due_dt",		false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"ip",				false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"yard_type",		false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"yard",				false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"edi_id",			false,	"",	dfNone,			0,	false,	false,	30,	false);

						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"edi_snd_dt",		false,	"",	dfUserFormat2,	0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"fax_snd_dt",		false,	"",	dfUserFormat2,	0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"fax_snd_rslt_cd",	false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"eml_snd_dt",		false,	"",	dfUserFormat2,	0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"eml_snd_rslt_cd",	false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		true,	"xter_rmk",			false,	"",	dfNone,			0,	false,	false,	30,	false);
						InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,	"diff_rmk",			false,	"",	dfNone,			0,	true,	true,	30,	false);
						InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,	"col_chk",			false,	"",	dfNone,			0,	false,	false,	30,	false);						
						InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,	"tmpl_param",		false,	"",	dfNone,			0,	false,	false,	30,	false);						
						InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,	"fax_snd_rslt_nm",	false,	"",	dfNone,			0,	false,	false,	30,	false);						

						InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,	"eml_snd_rslt_nm",	false,	"",	dfNone,			0,	false,	false,	30,	false);						

//						InitUserFormat2(0, "mty_pkup_dt", "####-##-## ##:##", "-|:" );
						InitUserFormat2(0, "edi_snd_dt",  "####-##-## ##:##", "-|:" );
						InitUserFormat2(0, "fax_snd_dt",  "####-##-## ##:##", "-|:" );
						InitUserFormat2(0, "eml_snd_dt",  "####-##-## ##:##", "-|:" );
                    }
                    break;

            }
        }

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	            /* case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					
					break;*/
	            case IBSEARCH:      //조회
	 	            if(validateForm(sheetObj,formObj,sAction)){
	 	        	    for(i=0;i< formObj.ser_type.length;i++){ 
	 	        		    if (formObj.ser_type[i].checked){ 
	 	        			    v_ser_type = formObj.ser_type[i].value; 
	 	        		    } 
	 	        	     }
		 	        	 if(v_ser_type=="simple"){	 	        		
		 	        		 formObj.f_cmd.value = SEARCH; 
		 	        	 }else if(v_ser_type=="detail"){
		 	        		 formObj.f_cmd.value = SEARCH01;
		 	        	 }else{
		 	        		 formObj.f_cmd.value = SEARCH02; 
		 	        	 }
		 	          	 sheetObj.DoSearch4Post("ESM_BKG_0252GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
		 	        }	  
		            break;
	              
	            case IBDOWNEXCEL:      // 입력
	   				sheetObj.Down2Excel(-1);
	   				break;	

	            case "FAX":   
	            	if(validateForm(sheetObj,formObj,sAction)){
	            		formObj.f_cmd.value = MULTI01;
	            		sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	            	}
	            	break;			

	            case "EMAIL": 
	        	    if(validateForm(sheetObj,formObj,sAction)){
		        	    formObj.f_cmd.value = MULTI02;
		        	    sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	        	    }
	        	    break;

	            case "EDI": 
	        	    if(validateForm(sheetObj,formObj,sAction)){
	        	    	formObj.f_cmd.value = MULTI03;
		 	            sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	        	    }
	        	    break;	

	    		case "btn_EmailEdit":
	    			var arrRow = ComFindText(sheetObjects[0], "Check", 1);
	    			var bkg_no_list = "";
	    			if (arrRow && 0<arrRow.length) {
	    				for (var i=0; i<arrRow.length; i++) {
	    					bkg_no_list += sheetObjects[0].CellValue(arrRow[i],"bkg_no")+'|';
	    				}
	    				if (0<bkg_no_list.indexOf("|")) bkg_no_list = bkg_no_list.substring(0,bkg_no_list.length-1);
	    				ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0252&ntc_knd_cd=CN&bkg_no_list="+bkg_no_list, "ESM_BKG_1096", 700, 670, true);
	    			}
	    			break;
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {

					case IBSEARCH: // 조회시 확인
		         		if (!ComChkValid(formObj)) return false;
					
						if(formObj.bkg_no.value==""&&formObj.vvd.value==""&&formObj.from_dt.value==""){
							ComShowCodeMessage("BKG00738");  //please Input Date or VVD or Booking NO.
			    			return false;
						}
						if(formObj.from_dt.value!=""||formObj.vvd.value!=""){
							if(formObj.bkg_ofc_cd.value==""&&formObj.eq_ctrl_ofc_cd.value==""&&formObj.por_cd.value==""&&formObj.pol_cd.value==""&&formObj.mty_pkup_yd_cd.value==""&&formObj.full_rtn_yd_cd.value==""){
								ComShowCodeMessage("BKG00739");  //please Input BKG OFC or EQ CTL OFC or POR or POL or P/U CY or FULL RTN CY.
    			    			return false;
							}
						}
		                if (ComGetDaysBetween(formObj.from_dt.value,formObj.end_dt.value) > 31 ) {
		                    ComShowCodeMessage("BKG00756","Duration","31Days");  //{?msg1} exceeds maximum duration {?msg2}.
		                    formObj.from_dt.focus();
		                    return false;
		                }
		                if (ComGetDaysBetween(formObj.from_dt2.value,formObj.end_dt2.value) > 31 ) {
		                    ComShowCodeMessage("BKG00756","Duration","31Days");  //{?msg1} exceeds maximum duration {?msg2}.
		                    formObj.from_dt2.focus();
		                    return false;
		                }
						break;
					case "FAX":
						with(sheetObj){
							for(var i = 1; i <= LastRow; i ++){
								if (CellValue(i, "Check") == "1"&&CellValue(i, "ntc_fax_no") == ""){
									ComShowCodeMessage("BKG00365");  //Fax No is either missing or not number!
        			    			return false;
								}
							}
						}
						break;
					case "EMAIL":
						with(sheetObj){
							for(var i = 1; i <= LastRow; i ++){
								if (CellValue(i, "Check") == "1"){
									if(CellValue(i, "ntc_eml") == ""){
    									ComShowCodeMessage("BKG00366");  //E-mail Address is missiong or not correct format
            			    			return false;
									}else{
										  reg = new RegExp("^[\\w\\-]+(\\.[\\w\\-_]+)*@[\\w\\-]+(\\.[\\w\\-]+)*(\\.[a-zA-Z]{2,3})$", "gi");
										  if (!reg.test(CellValue(i, "ntc_eml"))){
											  ComShowCodeMessage("BKG00366");  //E-mail Address is missiong or not correct format
											  return false;
										  }
									}
								}
							}
						}
						break;
					case "btn_EmailEdit":
						if (sheetObj.RowCount == 0) {
							ComShowCodeMessage("BKG00155");
							return false;
						}
						if (sheetObj.CheckedRows("Check") == 0) {
							ComShowCodeMessage("BKG00155");
							return false;
						}
						break;
             	}	
             }
             return true;
        }
        
        function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){	
        	//풍선도움말 만들기
            if (sheetObj.ColSaveName(sheetObj.MouseCol)=="fax_snd_rslt_cd"){
            	sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,"fax_snd_rslt_nm");
            }else if(sheetObj.ColSaveName(sheetObj.MouseCol)=="eml_snd_rslt_cd"){
            	sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,"eml_snd_rslt_nm");
            }else{
            	sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
            }
        }
        
        // 그리드에 마우스를 클릭했을때의 이벤트
        function sheet1_OnMouseDown(Button, Shift, X, Y) {
        	var sheetObj = sheetObjects[0];
        	var m_row = sheetObj.MouseRow;
        	var m_col = sheetObj.MouseCol;

        	try {
        		//Booking NO.  컬럼에서만 팝업창 열림   
        		if (m_row > 0 && m_col == 3 && sheetObj.CellValue(m_row, m_col).length > 1) {
//        			ComOpenWindow("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(m_row, m_col), "ESM_BKG_0079", "width=1024,height=768", false);
        			comBkgCallPopBkgDetail(sheetObj.CellValue(m_row, m_col));
        		}
        	} catch (ex) {
        		bkg_error_alert(ex);
        		return false;
        	}
        }

        // 저장 함수를 이용하여 조회가 완료되고 발생하는 Event
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        	with(sheetObj) {
        		for(i=0;i< document.form.ser_type.length;i++){ 
 	        		if (document.form.ser_type[i].checked){ 
 	        			v_ser_type = document.form.ser_type[i].value; 
 	        		} 
 	        	}
    			if ("usa"==v_ser_type) {
    				for (var i=1; i<=LastRow; i++) {
        				if ("1"!=CellValue(i,"col_chk")) {
	        				for (var j=1; j<=14; j++) {
		            			CellValue2(i, j) = "";
		            			CellBackColor(i, j-1) = RgbColor(255,255,255);
	        				}
	            		}
	    			}
				}
	    	}
			ComSetObjValue(document.form.elements["edt_ntc_knd_cd" ],"");
			ComSetObjValue(document.form.elements["edt_bkg_no_list"],"");
			ComSetObjValue(document.form.elements["edt_to_eml"     ],"");
			ComSetObjValue(document.form.elements["edt_cc_eml"     ],"");
			ComSetObjValue(document.form.elements["edt_from_eml"   ],"");
			ComSetObjValue(document.form.elements["edt_subject"    ],"");
			ComSetObjValue(document.form.elements["edt_contents"   ],"");
        }

        // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	var cnt = 0;
        	var rownum = 1;
        	with(sheetObj)
        	{
        		if (0==RowCount) {
        			ComBtnDisable("btn_CheckAll");
        			ComBtnDisable("btn_UncheckAll");
        			ComBtnDisable("btn_Print");
        			ComBtnDisable("btn_Preview");
        			ComBtnDisable("btn_EditFAXEmail");
        			ComBtnDisable("btn_FAX");
        			ComBtnDisable("btn_EMail");
        			ComBtnDisable("btn_EDI");
        			ComBtnDisable("btn_Remark");
        			ComBtnDisable("btn_EmailEdit");
        		} else {
	        		ComBtnEnable("btn_CheckAll");
	        		ComBtnEnable("btn_UncheckAll");
	        		ComBtnEnable("btn_Print");
	        		ComBtnEnable("btn_Preview");
	        		ComBtnEnable("btn_EditFAXEmail");
	        		ComBtnEnable("btn_FAX");
	        		ComBtnEnable("btn_EMail");
	        		ComBtnEnable("btn_EDI");
	        		ComBtnEnable("btn_Remark");
	        		ComBtnEnable("btn_EmailEdit");
        		}
        		
        		for(i=0;i< document.form.ser_type.length;i++){ 
 	        		if (document.form.ser_type[i].checked){ 
 	        			v_ser_type = document.form.ser_type[i].value; 
 	        		} 
 	        	}
        		
    			if (RowCount == 0) return;;
        		
    			var bef_yard_type="";
    			var bef_bkg_no="";

        		for(var i = 1; i <= LastRow; i ++){
        			if(v_ser_type=="usa"){

        				InitCellProperty(i, "Check", dtDummyCheck  ,daCenter);

        				if (CellValue(i, "col_chk") == "1"){
	        				CellValue2(i, "Seq") = rownum;
	        				rownum++;
	        			}else{
	        				if(CellValue(i, "yard_type")==bef_yard_type&&CellValue(i, "bkg_no")==bef_bkg_no){
	        					RowHidden(i)=true ;
		            		}

	        				bef_yard_type=CellValue(i, "yard_type");
		        			bef_bkg_no=CellValue(i, "bkg_no");

	        				for(var j = 1; j <= 14; j ++){
		            			CellValue2(i, j) = "";
		            			CellBackColor(i, j-1) = RgbColor(255,255,255);
		            		}
		            		RowMerge(i) = true;
	        			}
        			}else{
        				InitCellProperty(i, "Check", dtDummyCheck  ,daCenter);
        				CellValue2(i, "Seq") = rownum;
        				rownum++;
        			}
					cnt =0 ;
				}
        	}

        	with (sheetObj) {
        		var color1 = RgbColor(129, 0, 129);
        		ColFontUnderline("bkg_no") = true;
        		DataLinkMouse("bkg_no") = true;
        		ColFontColor("bkg_no") = color1;
        	}
        }
        

        /*
    	*Rd 설정
    	*/
    	function initRdConfig(rdObject){
    		var Rdviewer = rdObject;

    		Rdviewer.AutoAdjust = true;
    		Rdviewer.ViewShowMode(0); 
    		Rdviewer.setbackgroundcolor(128,128,128);
    		Rdviewer.SetPageLineColor(128,128,128);
    	}
    	


    	function CheckGrid(sheetObject,prefix){
    		var iCheckRow = sheetObject.FindCheckedRow("Check"); 
    		
    		for(i=0;i< document.form.ser_type.length;i++){ 
	        		if (document.form.ser_type[i].checked){ 
	        			v_ser_type = document.form.ser_type[i].value; 
	        		} 
	        }
    		var max_cnt = 50;
    		if(v_ser_type=='simple'){
    			max_cnt = 100;
    		}
    		
    		if (iCheckRow== "") {
    			ComShowCodeMessage("BKG00249");
    			return false;
    		}
			if ( max_cnt <sheetObject.CheckedRows("Check")) {
				ComShowCodeMessage("BKG08124",max_cnt);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
				return false;
			}
    		return true;
    	}
    	
    	function chkSerType(serType){
    		sheetObjects[0].RemoveAll();
    		sheetObjects[0].Redraw = false;

        	if ("simple"==serType.value) {
        		sheetObjects[0].ColHidden("Seq"            ) = false;
        		sheetObjects[0].ColHidden("Check"          ) = false;
        		sheetObjects[0].ColHidden("bkg_no"         ) = false;
        		sheetObjects[0].ColHidden("bkg_sts_cd"     ) = false;
        		sheetObjects[0].ColHidden("rcv_term_cd"    ) = false;
        		sheetObjects[0].ColHidden("de_term_cd"     ) = false;
        		sheetObjects[0].ColHidden("cntr_qty"       ) = false;
        		sheetObjects[0].ColHidden("flex_hgt_flg"   ) = false;
        		sheetObjects[0].ColHidden("por_cd"         ) = false;
        		sheetObjects[0].ColHidden("pol_cd"         ) = false;
        		sheetObjects[0].ColHidden("eq_ctrl_ofc_cd" ) = true;
        		sheetObjects[0].ColHidden("scc_cd"         ) = false;
        		sheetObjects[0].ColHidden("mty_pkup_yd_cd" ) = false;
        		sheetObjects[0].ColHidden("cy_name"        ) = false;
        		sheetObjects[0].ColHidden("ntc_fax_no"     ) = false;
        		sheetObjects[0].ColHidden("ntc_eml"        ) = false;
        		sheetObjects[0].ColHidden("mty_pkup_dt"    ) = false;
        		sheetObjects[0].ColHidden("vvd"            ) = false;
        		sheetObjects[0].ColHidden("tvvd"           ) = true;
        		sheetObjects[0].ColHidden("vvd_name"       ) = false;
        		sheetObjects[0].ColHidden("full_rtn_yd_cd" ) = false;
        		sheetObjects[0].ColHidden("cust_nm"        ) = false;
        		sheetObjects[0].ColHidden("cmdt_cd"        ) = false;
        		sheetObjects[0].ColHidden("cmdt_nm"        ) = false;
        		sheetObjects[0].ColHidden("lodg_due_dt"    ) = true;
        		sheetObjects[0].ColHidden("ip"             ) = true;
        		sheetObjects[0].ColHidden("yard_type"      ) = true;
        		sheetObjects[0].ColHidden("yard"           ) = true;
        		sheetObjects[0].ColHidden("edi_id"         ) = true;
        		sheetObjects[0].ColHidden("edi_snd_dt"     ) = true;
        		sheetObjects[0].ColHidden("fax_snd_dt"     ) = true;
        		sheetObjects[0].ColHidden("fax_snd_rslt_cd") = true;
        		sheetObjects[0].ColHidden("eml_snd_dt"     ) = true;
        		sheetObjects[0].ColHidden("eml_snd_rslt_cd") = true;
        		sheetObjects[0].ColHidden("xter_rmk"       ) = false;
        		sheetObjects[0].ColHidden("diff_rmk"       ) = false;
        		sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
        		sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
        		sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
        		sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
        		sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
        		sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
        		sheetObjects[0].MoveColumnPos("cntr_qty"       ,7 ,false);
        		sheetObjects[0].MoveColumnPos("flex_hgt_flg"   ,8 ,false);
                sheetObjects[0].MoveColumnPos("por_cd"         ,9 ,false);
                sheetObjects[0].MoveColumnPos("pol_cd"         ,10,false);
                sheetObjects[0].MoveColumnPos("scc_cd"         ,11,false);
                sheetObjects[0].MoveColumnPos("mty_pkup_yd_cd" ,12,false);
                sheetObjects[0].MoveColumnPos("cy_name"        ,13,false);
                sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,14,false);
                sheetObjects[0].MoveColumnPos("ntc_eml"        ,15,false);
                sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,16,false);
                sheetObjects[0].MoveColumnPos("vvd"            ,17,false);
                sheetObjects[0].MoveColumnPos("vvd_name"       ,18,false);
                sheetObjects[0].MoveColumnPos("full_rtn_yd_cd" ,19,false);
                sheetObjects[0].MoveColumnPos("cust_nm"        ,20,false);
                sheetObjects[0].MoveColumnPos("cmdt_cd"        ,21,false);
                sheetObjects[0].MoveColumnPos("cmdt_nm"        ,22,false);
        		sheetObjects[0].MoveColumnPos("xter_rmk"       ,23,false);
        		sheetObjects[0].MoveColumnPos("diff_rmk"       ,24,false);
			} else if("detail"==serType.value) {
				sheetObjects[0].ColHidden("Seq"            ) = false;
				sheetObjects[0].ColHidden("Check"          ) = false;
				sheetObjects[0].ColHidden("bkg_no"         ) = false;
				sheetObjects[0].ColHidden("bkg_sts_cd"     ) = false;
				sheetObjects[0].ColHidden("rcv_term_cd"    ) = false;
				sheetObjects[0].ColHidden("de_term_cd"     ) = false;
				sheetObjects[0].ColHidden("cntr_qty"       ) = false;
        		sheetObjects[0].ColHidden("flex_hgt_flg"   ) = false;
				sheetObjects[0].ColHidden("por_cd"         ) = false;
				sheetObjects[0].ColHidden("pol_cd"         ) = false;
				sheetObjects[0].ColHidden("eq_ctrl_ofc_cd" ) = false;
				sheetObjects[0].ColHidden("scc_cd"         ) = false;
				sheetObjects[0].ColHidden("mty_pkup_yd_cd" ) = false;
				sheetObjects[0].ColHidden("cy_name"        ) = true;
				sheetObjects[0].ColHidden("ntc_fax_no"     ) = false;
				sheetObjects[0].ColHidden("ntc_eml"        ) = false;
				sheetObjects[0].ColHidden("mty_pkup_dt"    ) = false;
				sheetObjects[0].ColHidden("vvd"            ) = false;
				sheetObjects[0].ColHidden("tvvd"           ) = true;
				sheetObjects[0].ColHidden("vvd_name"       ) = true;
				sheetObjects[0].ColHidden("full_rtn_yd_cd" ) = false;
				sheetObjects[0].ColHidden("cust_nm"        ) = true;
				sheetObjects[0].ColHidden("cmdt_cd"        ) = true;
				sheetObjects[0].ColHidden("cmdt_nm"        ) = true;
				sheetObjects[0].ColHidden("lodg_due_dt"    ) = true;
				sheetObjects[0].ColHidden("ip"             ) = true;
				sheetObjects[0].ColHidden("yard_type"      ) = true;
				sheetObjects[0].ColHidden("yard"           ) = true;
				sheetObjects[0].ColHidden("edi_id"         ) = false;
				sheetObjects[0].ColHidden("edi_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("fax_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("fax_snd_rslt_cd") = false;
				sheetObjects[0].ColHidden("eml_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("eml_snd_rslt_cd") = false;
				sheetObjects[0].ColHidden("xter_rmk"       ) = false;
				sheetObjects[0].ColHidden("diff_rmk"       ) = false;
				sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
				sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
				sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
				sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
				sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
				sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
				sheetObjects[0].MoveColumnPos("cntr_qty"       ,7 ,false);
        		sheetObjects[0].MoveColumnPos("flex_hgt_flg"   ,8 ,false);
				sheetObjects[0].MoveColumnPos("por_cd"         ,9 ,false);
				sheetObjects[0].MoveColumnPos("pol_cd"         ,10,false);
				sheetObjects[0].MoveColumnPos("eq_ctrl_ofc_cd" ,11,false);
				sheetObjects[0].MoveColumnPos("scc_cd"         ,12,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_yd_cd" ,13,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,14,false);
				sheetObjects[0].MoveColumnPos("vvd"            ,15,false);
				sheetObjects[0].MoveColumnPos("full_rtn_yd_cd" ,16,false);
				sheetObjects[0].MoveColumnPos("edi_id"         ,17,false);
				sheetObjects[0].MoveColumnPos("edi_snd_dt"     ,18,false);
				sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,19,false);
				sheetObjects[0].MoveColumnPos("fax_snd_dt"     ,20,false);
				sheetObjects[0].MoveColumnPos("fax_snd_rslt_cd",21,false);
				sheetObjects[0].MoveColumnPos("ntc_eml"        ,22,false);
				sheetObjects[0].MoveColumnPos("eml_snd_dt"     ,23,false);
				sheetObjects[0].MoveColumnPos("eml_snd_rslt_cd",24,false);
				sheetObjects[0].MoveColumnPos("xter_rmk"       ,25,false);
				sheetObjects[0].MoveColumnPos("diff_rmk"       ,26,false);
			} else {
				sheetObjects[0].ColHidden("Seq"            ) = false;
				sheetObjects[0].ColHidden("Check"          ) = false;
				sheetObjects[0].ColHidden("bkg_no"         ) = false;
				sheetObjects[0].ColHidden("bkg_sts_cd"     ) = false;
				sheetObjects[0].ColHidden("rcv_term_cd"    ) = false;
				sheetObjects[0].ColHidden("de_term_cd"     ) = false;
				sheetObjects[0].ColHidden("cntr_qty"       ) = true;
        		sheetObjects[0].ColHidden("flex_hgt_flg"   ) = true;
				sheetObjects[0].ColHidden("por_cd"         ) = false;
				sheetObjects[0].ColHidden("pol_cd"         ) = false;
				sheetObjects[0].ColHidden("eq_ctrl_ofc_cd" ) = false;
				sheetObjects[0].ColHidden("scc_cd"         ) = false;
				sheetObjects[0].ColHidden("mty_pkup_yd_cd" ) = true;
				sheetObjects[0].ColHidden("cy_name"        ) = true;
				sheetObjects[0].ColHidden("ntc_fax_no"     ) = false;
				sheetObjects[0].ColHidden("ntc_eml"        ) = false;
				sheetObjects[0].ColHidden("mty_pkup_dt"    ) = false;
				sheetObjects[0].ColHidden("vvd"            ) = true;
				sheetObjects[0].ColHidden("tvvd"           ) = false;
				sheetObjects[0].ColHidden("vvd_name"       ) = true;
				sheetObjects[0].ColHidden("full_rtn_yd_cd" ) = true;
				sheetObjects[0].ColHidden("cust_nm"        ) = true;
				sheetObjects[0].ColHidden("cmdt_cd"        ) = true;
				sheetObjects[0].ColHidden("cmdt_nm"        ) = true;
				sheetObjects[0].ColHidden("lodg_due_dt"    ) = false;
				sheetObjects[0].ColHidden("ip"             ) = false;
				sheetObjects[0].ColHidden("yard_type"      ) = false;
				sheetObjects[0].ColHidden("yard"           ) = false;
				sheetObjects[0].ColHidden("edi_id"         ) = false;
				sheetObjects[0].ColHidden("edi_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("fax_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("fax_snd_rslt_cd") = false;
				sheetObjects[0].ColHidden("eml_snd_dt"     ) = false;
				sheetObjects[0].ColHidden("eml_snd_rslt_cd") = false;
				sheetObjects[0].ColHidden("xter_rmk"       ) = true;
				sheetObjects[0].ColHidden("diff_rmk"       ) = false;
				sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
				sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
				sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
				sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
				sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
				sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
				sheetObjects[0].MoveColumnPos("eq_ctrl_ofc_cd" ,7 ,false);
				sheetObjects[0].MoveColumnPos("scc_cd"         ,8 ,false);
				sheetObjects[0].MoveColumnPos("tvvd"           ,9 ,false);
				sheetObjects[0].MoveColumnPos("por_cd"         ,10,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,11,false);
				sheetObjects[0].MoveColumnPos("pol_cd"         ,12,false);
				sheetObjects[0].MoveColumnPos("lodg_due_dt"    ,13,false);
				sheetObjects[0].MoveColumnPos("ip"             ,14,false);
				sheetObjects[0].MoveColumnPos("yard_type"      ,15,false);
				sheetObjects[0].MoveColumnPos("yard"           ,16,false);
				sheetObjects[0].MoveColumnPos("edi_id"         ,17,false);
				sheetObjects[0].MoveColumnPos("edi_snd_dt"     ,18,false);
				sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,19,false);
				sheetObjects[0].MoveColumnPos("fax_snd_dt"     ,20,false);
				sheetObjects[0].MoveColumnPos("fax_snd_rslt_cd",21,false);
				sheetObjects[0].MoveColumnPos("ntc_eml"        ,22,false);
				sheetObjects[0].MoveColumnPos("eml_snd_dt"     ,23,false);
				sheetObjects[0].MoveColumnPos("eml_snd_rslt_cd",24,false);
				sheetObjects[0].MoveColumnPos("diff_rmk"       ,25,false);
			}
        	
        	sheetObjects[0].Redraw = true;
        	
    		if(serType.value=="usa"){
    			document.form.pi_type.disabled=false;
    			document.form.from_dt2.disabled=false;
    			document.form.end_dt2.disabled=false;
    			document.form.empty_full_chk.disabled=false;
    			ComEnableObject(document.form.btns_calendar2,true);
    			document.form.pi_type.className = "input";
    			document.form.from_dt2.className = "input";
    			document.form.end_dt2.className = "input";			
    		}else{
    			document.form.pi_type.disabled=true;
    			document.form.from_dt2.disabled=true;
    			document.form.end_dt2.disabled=true;
    			document.form.empty_full_chk.disabled=true;
    			ComEnableObject(document.form.btns_calendar2,false);
    			document.form.pi_type.className = "input2";
    			document.form.from_dt2.className = "input2";
    			document.form.end_dt2.className = "input2";		
    		}
    	}
    	
    	function rdOpen(rdObject, formObject, sheetObject){
    		var ret = rdOpenCommon(rdObject, formObject, sheetObject);
			rdObject.FileOpen(RD_path + ret[0], RDServer + ret[1]);
			if ("US"==formObject.strCnt_cd.value) {
				rdObject.SetPrint2(4,1,1,100);
			}
			rdObject.PrintDialog();
    	}
    	
    	function makeRdParam(rdObject, formObject, sheetObject){
    		var iCheckRow = sheetObject.FindCheckedRow("Check");   		
    		
    		var strBkgNo = "";
    		var strRemark = "";
    		var strType = "";
    		var strIsEncode = "";
    		var strUsrId = "";
    		var rdParam = "";
    		var arrRow = iCheckRow.split("|");
    		
    		for(var i=0;i< formObject.ser_type.length;i++){ 
        		if (formObject.ser_type[i].checked){ 
        			v_ser_type = formObject.ser_type[i].value; 
        		} 
        	}
    		
    		if ("simple"==v_ser_type) {
    			for (var idx=0; idx<arrRow.length-1; idx++) {
        			strBkgNo += "'" + sheetObject.CellValue(arrRow[idx], "bkg_no") + "',";
        			strRemark += sheetObject.CellValue(arrRow[idx], "diff_rmk") + "@@";
        		}
    			strRemark = encodeRemark(strRemark);
        		strBkgNo = " bkg_no[( " + strBkgNo.substring(0, eval(strBkgNo.lengthByte()) - 1) + " )] ";
        		strRemark = " remark[" + strRemark + " ] ";
        		strUsrId = " usr_id[" + formObject.usr_id.value + "] ";  
        		strType =" type[simple] ";
        		strIsEncode = " isEncode[Y] ";
        		
        		rdParam = " /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
        		
        		for (var idx=0; idx<arrRow.length-1; idx++) {
        			sheetObject.CellValue2(arrRow[idx], "tmpl_param") = rdParam;
        		}
    		} else {
    			//check row만큼 반복하면서
    			for (var idx=0; idx<arrRow.length-1; idx++) {
    				//bkg_no가 있으면
    				if (""!=sheetObject.CellValue(arrRow[idx], "bkg_no")) {
    					//기존에 bkg_no가 추가되어있지 않은 경우에
    					if (0 > strBkgNo.indexOf(sheetObject.CellValue(arrRow[idx], "bkg_no"))) {
		    				strBkgNo = " bkg_no[(  '" + sheetObject.CellValue(arrRow[idx], "bkg_no") + "' )] ";
		    	    		strRemark = " remark[" + encodeRemark(sheetObject.CellValue(arrRow[idx], "diff_rmk") + "@@") + " ] ";
		    	    		strUsrId = " usr_id[" + formObject.usr_id.value + "] ";
		    	    		strType =" type[detail] ";
		    	    		strIsEncode = " isEncode[Y] ";
		    	    		rdParam = " /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
		    	    		sheetObject.CellValue2(arrRow[idx], "tmpl_param") = rdParam;
    					}
    				//bkg_no가 없으면
    				} else {
    					//check row를 거꾸로 반복
    					for (var ii=arrRow[idx]-1; ii>0; ii--) {
    						//bkg_no가 있으면
    						if (""!=sheetObject.CellValue(ii, "bkg_no")) {
			    				strBkgNo = " bkg_no[(  '" + sheetObject.CellValue(ii, "bkg_no") + "' )] ";
			    	    		strRemark = " remark[" + encodeRemark(sheetObject.CellValue(ii, "diff_rmk") + "@@") + " ] ";
			    	    		strUsrId = " usr_id[" + formObject.usr_id.value + "] ";
			    	    		strType =" type[detail] ";
			    	    		strIsEncode = " isEncode[Y] ";
			    	    		rdParam = " /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
			    	    		sheetObject.CellValue2(arrRow[idx], "tmpl_param") = rdParam;
			    	    		sheetObject.CellValue2(arrRow[idx], "bkg_no") = sheetObject.CellValue(ii, "bkg_no");
								break;
    						}
    					}
    				}
        		}
    		}
    	}

    //remark popup(0913)에서 호출됨
    function setRemark(remark) {
    	var sheetObject = sheetObjects[0];
		var arrRow = sheetObject.FindCheckedRow("Check").split("|");
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length-1; i++) {
				sheetObject.CellValue2(arrRow[i],"diff_rmk") = remark;
			}
		}
    }
    //edit fax/email 팝업에서 호출됨
    function getCOM_Fax_Email_POPUP(rowArray) {
    	if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
	    	var faxno = rowArray[0][21];
	        var email = rowArray[0][22];
	    	var sheetObject = sheetObjects[0];
			var arrRow = sheetObject.FindCheckedRow("Check").split("|");
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length-1; i++) {
 					sheetObject.CellValue2(arrRow[i],"ntc_fax_no") = faxno;
 					sheetObject.CellValue2(arrRow[i],"ntc_eml") = email;
				}
			}
    	}
    }

    function rdOpenWindow(rdObject, formObject,sheetObject) {
		var ret = rdOpenCommon(rdObject, formObject, sheetObject);
		formObject.elements["com_mrdPath"     ].value = ret[0];
    	formObject.elements["com_mrdArguments"].value = ret[1];
		formObject.elements["com_mrdSaveDialogFileName"].value = sheetObject.CellValue(sheetObject.FindCheckedRow("Check").split("|")[0],"bkg_no");
    	ComOpenRDPopup("width=800, height=600");
    }

    function rdOpenCommon(rdObject, formObject, sheetObject) {
		var Rdviewer = rdObject;
		// /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait -- 파라메터 순서
		//var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
		
		var iCheckRow = sheetObject.FindCheckedRow("Check");
		
		var strBkgNo = "";
		var strRemark = "";
		var strType = "";
		var strUsrId = "";
		var strIsEncode = "";
		var arrRow = iCheckRow.split("|");
	
		for (var idx=0; idx<arrRow.length-1; idx++) {
			if (""!=sheetObject.CellValue(arrRow[idx], "bkg_no")) {
				if (0 > strBkgNo.indexOf(sheetObject.CellValue(arrRow[idx], "bkg_no"))) {
	    			strBkgNo += "'" + sheetObject.CellValue(arrRow[idx], "bkg_no") + "',";
	    			strRemark += sheetObject.CellValue(arrRow[idx], "diff_rmk") + "@@";
				}
			} else {
				for (var ii=arrRow[idx]-1; ii>0; ii--) {
					if (""!=sheetObject.CellValue(ii, "bkg_no")) {
						if (0 > strBkgNo.indexOf(sheetObject.CellValue(ii, "bkg_no"))) {
							strBkgNo += "'" + sheetObject.CellValue(ii, "bkg_no") + "',";
							strRemark += sheetObject.CellValue(ii, "diff_rmk") + "@@";
						}
						break;
					}
				}
			}
		}
		strBkgNo = " bkg_no[( " + strBkgNo.substring(0, eval(strBkgNo.lengthByte()) - 1) + " )] ";
		strRemark = " remark[" + encodeRemark(strRemark) + " ] ";
		strUsrId = " usr_id[" + formObject.usr_id.value + "] ";
		strIsEncode = " isEncode[Y] ";
		
		for(var i=0;i< formObject.ser_type.length;i++){ 
			if (formObject.ser_type[i].checked){ 
				v_ser_type = formObject.ser_type[i].value; 
			} 
		}
		
		if(v_ser_type=='simple'){
			strType ="type[simple]";
		}else{
			strType ="type[detail]";
		}
		
		var rdParam = "/rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
		// 열고자 하는 RD 파일을 지정한다.
		
		var strPath = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/emptyreleaseorder/report/ESM_BKG_0861.mrd";
		return [strPath,rdParam];
    }

    function backupHhmm(formObject) {
    	if (!ComIsEmpty(formObject.from_dt)) {
    		from_hm = formObject.from_dt.value.split(" ")[1];
    	}
    	if (!ComIsEmpty(formObject.end_dt)) {
    		to_hm = formObject.end_dt.value.split(" ")[1];
    	}
    }

    function restoreHhmm() {
        var formObject = document.form;
        formObject.from_dt.value = formObject.from_dt.value.split(" ")[0]+" "+from_hm;
        formObject.end_dt.value = formObject.end_dt.value.split(" ")[0]+" "+to_hm;
	}

    //remark를 encoding함
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
    /* 개발자 작업  끝 */
