/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1123.js
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier :  채창호
*@LastVersion : 1.0
* 2011.06.22 채창호
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
     * @class ESM_BKG_1123 : ESM_BKG_1123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1123() {
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

    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
               
		                case "btn_Retrieve":
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);		                	
	                    	if ( formObject.io_bnd_cd[0].checked ) {
	                    		sheetObjects[0].ColHidden("de_term_cd") = true;
	                    		sheetObjects[0].ColHidden("rcv_term_cd") = false;
	                    	} else {
	                    		sheetObjects[0].ColHidden("de_term_cd") = false;
	                    		sheetObjects[0].ColHidden("rcv_term_cd") = true;
	                    	} 
							break;
		                case "btn_New":
		                	 ComResetAll();
		                	 sheetObjects[0].RemoveAll();
    						 break
		                case "btn_DownExcel":
    	 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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

        function setComboObject(combo_obj){
        	comboObjects[comboCnt++] = combo_obj;
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
    		initControl();
    		doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
    		
    		sheetObjects[0].ColHidden("de_term_cd") = true;
    		
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
        	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
     	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	    //axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     	   // axon_event.addListenerForm  ('beforedeactivate', 'getStaffList',  formObject); //- 포커스 나갈때
        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	
        	combo1 = comboObjects[0];
    		comboCnt = comboObjects.length;

    		// IBMultiCombo초기화
    	    /*for(var k=0; k<comboObjects.length; k++){
    	        initCombo(comboObjects[k]);
    	    }*/
    		
    	    initCombo(formObject.bkg_sts_cd);
    	    
        	ComSetObjValue(formObject.door_dt_fr,ComGetNowInfo());
        	ComSetObjValue(formObject.door_dt_to,ComGetNowInfo());
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
    					style.height = 300;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					
    					//전체Merge 종류 [선택, Default msNone] msPrevColumnMerge + msHeaderOnly;            
    					MergeSheet = msAll; 
    					
    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
    					
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(2, 2, 2, 100);

    					var HeadTitle1 = "| |B/L No.|Seq.|Booking Q'ty|Booking Q'ty|TRO|TRO Q'ty|TRO Q'ty|P/Up Date|Request|P/Up CY|Return CY|R/Term|D/Term|S/O|W/O|Door|EQ Office|POL|POD|S/O#|W/O#|Remark(s)";                                                                                                                                                                                                 
                        var HeadTitle2 = "| |B/L No.|Seq.|TEU|FEU|TRO|TRO Q'ty|TRO Q'ty|P/Up Date|Request|P/Up CY|Return CY|R/Term|D/Term|S/O|W/O|Door|EQ Office|POL|POD|S/O#|W/O#|Remark(s)";                                                                                                                                                                                                                 
                        var headCount = ComCountHeadTitle(HeadTitle1);
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
 
                        var rowIdx = 0;                                                                                                                                                                                                                                                                                                                      
                        
                        //데이터속성    [	ROW, 		COL,  DATATYPE,   				WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  				KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(rowIdx, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		    "ibflag");                                                                                                                                                                                               
						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"Seq",					false,			"",      dfNone,			0,		true,		true);                       
						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	true,			"bl_no",				false,			"",      dfNone,			0,		true,		true);                               
						InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	true,			"tro_seq",				false,			"",      dfNone,			0,		true,		true);                       
						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"teu_a",				false,			"",      dfNone,			0,		true,		true);                       
						                                                                                                                                                                                                                                                                                                             
						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"teu_b",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"cfm_flg",				false,			"",      dfNone,			0,		true,		true);                       
						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"cntr_tpsz_cd",			false,			"",      dfNone,			0,		true,		true);                               
						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"tro_qty",				false,			"",      dfNone,			0,		true,		true);                       
						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"cntr_pkup_dt",			false,			"",      dfNone,			0,		true,		true);  
						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"rqst_dt",				false,			"",      dfDateYmd,			0,		true,		true);                       
						
						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"cntr_pkup_yd_cd",			false,			"",      dfNone,			0,		true,		true);                               
						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"cntr_rtn_yd_cd",			false,			"",      dfNone,			0,		true,		true);                               
						                                                                                                                                                                                                                                                                                                             
						InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	true,			"rcv_term_cd",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	true,			"de_term_cd",			false,			"",      dfNone,			0,		true,		true);						
						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"so_flg",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"wo_flg",				false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(rowIdx, cnt++ , dtData,					70,		daCenter,	true,			"zone_code",			false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					70,		daCenter,	true,			"eq_ctrl_ofc_cd",		false,			"",      dfNone,			0,		true,		true);
						//InitDataProperty(rowIdx, cnt++ , dtData,					120,	daLeft,		true,			"act_shpr_nm",			false,			"",      dfNone,			0,		true,		true);                                       
						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"pol_cd",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"pod_cd",				false,			"",      dfNone,			0,		true,		true);                       
						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	true,			"so_number",				false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	true,			"wo_number",				false,			"",      dfNone,			0,		true,		true);
						
						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,		true,			"diff_rmk",				false,			"",      dfNone,			0,		true,		true);
					//	InitDataProperty(rowIdx, cnt++ , dtHidden,					30,		daCenter,	false,			"subgroup_title");
						
//						DataLinkMouse("bkg_no") = true;
//						ColFontUnderline("bkg_no") = true;
//		        		
		        		var color1 = RgbColor(129, 0, 129);
		        		ColFontColor("bkg_no") = color1;
//						cnt = 0;                                                                                                                                                                                                                                                                                                     
//						rowIdx ++;     
//						
//						InitDataProperty(rowIdx, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		    "ibflag");                                                                                                                                                                                               
//						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"Seq",					false,			"",      dfNone,			0,		true,		true);                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	true,			"bkg_no",				false,			"",      dfNone,			0,		true,		true);                               
//						InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	true,			"tro_seq",				false,			"",      dfNone,			0,		true,		true);                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"teu_a",				false,			"",      dfNone,			0,		true,		true);                       
//						                                                                                                                                                                                                                                                                                                             
//						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"teu_b",				false,			"",      dfNone,			0,		true,		true);                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"cntr_tpsz_cd",			false,			"",      dfNone,			0,		true,		true);                               
//						InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	true,			"tro_qty",				false,			"",      dfNone,			0,		true,		true);                       
//						
//						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"rqst_dt",				false,			"",      dfDateYmd,			0,		true,		true);                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					90,		daCenter,	true,			"rtn_loc_cd",			false,			"",      dfNone,			0,		true,		true);                               
//						                                                                                                                                                                                                                                                                                                             
//						InitDataProperty(rowIdx, cnt++ , dtData,					70,		daCenter,	true,			"eq_ctrl_ofc_cd",		false,			"",      dfNone,			0,		true,		true);                               
//						InitDataProperty(rowIdx, cnt++ , dtData,					120,	daLeft,		true,			"cntc_pson_nm",			false,			"",      dfNone,			0,		true,		true);                                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	true,			"pod_cd",				false,			"",      dfNone,			0,		true,		true);                       
//						InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,		true,			"diff_rmk",				false,			"",      dfNone,			0,		true,		true);                               
//					//	InitDataProperty(rowIdx, cnt++ , dtHidden,					30,		daCenter,	false,			"subgroup_title");
//					
//						DataRowMerge(0) = true;
//						DataRowMerge(1) = true;
//						
//						DataLinkMouse("bkg_no") = true;
//						ColFontUnderline("bkg_no") = true;
//		        		
//		        		var color1 = RgbColor(129, 0, 129);
//		        		ColFontColor("bkg_no") = color1;
//		        		
		        		SetMergeCell(0, 7, 2, 2);

		        		
    	                SetSortDialog(false);
                   }
                    break;

            }
        }

       // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            
             case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1123GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], formObj.bkg_sts_cd, "val", "val|name");
				
				formObj.bkg_sts_cd.InsertItem(0, '', '');
				
				break;
              case IBSEARCH:      //조회
    	          if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1123_1GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) 
						sheetObj.LoadSearchXml(arrXml[0]); 
	 	          	ComEtcDataXmlToForm(sXml, formObj);
    	          }
                  break;

              case IBDOWNEXCEL:      // 다운로드
	   				sheetObj.SpeedDown2Excel(-1);
	   				break;	
            }
        }
        /*
        BKG Staff 콤보리스트 조회-BKG Office 값 입력 후 포커스를 잃었을 때..
        */
//        function getStaffList(){
//          	var formObj = document.form;
//          	
//          	if (ComGetObjValue(formObj.tro_ofc_cd) == "" || ComGetObjValue(formObj.tro_ofc_cd).length < 5 ){
//          		return;
//          	}
//          	
//          	switch( event.srcElement.name ){
//          		case "tro_ofc_cd":
//    	 	 		formObj.f_cmd.value = COMMAND01;
//    	 	 		
//    	 	 		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1123GS.do", FormQueryString(formObj));
//    	 	 		
//    	 	 		var arrXml = sXml.split("|$$|");
//    	 	 			  
//    	 	 		if (arrXml.length > 0) {
//    	 	 			ComXml2ComboItem(arrXml[0], formObj.bkg_staff, "usr_id", "usr_id|usr_nm");
//    	 	 			formObj.bkg_staff.InsertItem(0, '', '');
//    	 	 		}	
//    	 	 		formObj.bkg_staff.DropHeight = 150;
//     		 	break;	
//          	}	
//         }
        
        /**
         * 콤보 초기설정값
         * @param {IBMultiCombo} comboObj  comboObj
         */
         function initCombo(comboObj) {
         	comboObj.MultiSelect = true;
         	comboObj.UseCode = true;
         	//comboObj.LineColor = "#ffffff";
         	//comboObj.SetColAlign("left|left");
         	comboObj.MultiSeparator = ",";
         	comboObj.DropHeight = 150;
         	
         }     
         /**
          * Status 콤보를 클릭할 때 전체체크
          * @param comboObj
          * @param index
          * @param code
          * @return
          */
         function bkg_sts_cd_OnCheckClick(comboObj, index, code) {
         	if(code == "") {
         		var bChk = comboObj.CheckIndex(index);
         		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
         			comboObj.CheckIndex(i) = bChk;
             	}
             }
         }
         /**
          * 조회조건 입력할 때 처리
          */
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
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {
					case IBSEARCH: // 조회시 확인
		         		if (!ComChkValid(formObj)) return false;
//		         		if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.door_dt_fr) || ComIsNull(formObj.bkg_dt_to))){
//							ComShowCodeMessage('BKG00626', 'BKG Date or VVD or BKG No.');
//
//							return false;
//						}
		         		
		         		if (!ComIsNull(formObj.door_dt_fr) && !ComIsNull(formObj.door_dt_to) && ComGetDaysBetween(formObj.door_dt_fr.value, formObj.door_dt_to.value) > 31){
		           		 
		         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
		         			formObj.bkg_dt_fr.focus();
		         			return false;
		         		}
		         		
		         		if (!ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to) && ComGetDaysBetween(formObj.bkg_dt_fr.value, formObj.bkg_dt_to.value) > 31){
			           		 
		         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
		         			formObj.tro_dt_fr.focus();
		         			return false;
		         		}
		         		
		         		if (!ComIsNull(formObj.pup_dt_fr) && !ComIsNull(formObj.pup_dt_to) && ComGetDaysBetween(formObj.pup_dt_fr.value, formObj.pup_dt_to.value) > 31){
			           		 
		         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
		         			formObj.pup_dt_fr.focus();
		         			return false;
		         		}
		         
		         		break;
             	}	
             }
             return true;
        }
        
        /**
         * ETD,ETB 기간 선택 달력 띄우기
         */
      	function callDatePop(val){
      		var cal = new ComCalendarFromTo();
      		if (val == 'DOOR_DATE'){
      			cal.select(form.door_dt_fr,  form.door_dt_to,  'yyyy-MM-dd');
      		}
      		if (val == 'BKG_DATE'){
      			cal.select(form.bkg_dt_fr,  form.bkg_dt_to,  'yyyy-MM-dd');
      		}
      		if (val == 'PUP_DATE'){
      			cal.select(form.pup_dt_fr,  form.pup_dt_to,  'yyyy-MM-dd');
      		}
      		
      	}
      	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      		comBkgIndicateLink(sheetObj,"bl_no"); 
      	}
      	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    		var colName = sheetObj.ColSaveName(colIdx);
    		if (colName == "bl_no"){
    			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
     		}
      	}
		 
	/* 개발자 작업  끝 */