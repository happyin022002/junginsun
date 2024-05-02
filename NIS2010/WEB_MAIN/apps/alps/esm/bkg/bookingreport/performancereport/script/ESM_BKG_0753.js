/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0753.js
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
* 1.0 Creation
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
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
     * @class esm_bkg_0753 : esm_bkg_0753 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0753() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

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
            
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            
            initControl();
            
            
            
            document.form.vps_etb_dt.value = getCalculatedDate(0,-1,0,"-");
    		document.form.vps_etd_dt.value = getCalculatedDate(0,0,0,"-");

    		doActionIBSheet(sheetObjects[2],document.form,SEARCH02);
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
                axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
          }
          
          function initTab(tabObj , tabNo) {
         	 switch(tabNo) {
         	 	case 1:
         	 		with (tabObj) {
         	 			var cnt  = 0 ;
         	 			InsertTab( cnt++ , "By SKD" , -1 );
         	 			InsertTab( cnt++ , "By Template" , -1 );
         	 		}
         	 	break;
         	 }
          }
          
          /**
           * IBTab Object를 배열로 등록
           * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
           * 배열은 소스 상단에 정의
           */
          function setTabObject(tab_obj){
              tabObjects[tabCnt++] = tab_obj;
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
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
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
			var sheetID = sheetObj.id;
			switch(sheetID) {
				
				case "sheet1":
						with (sheetObj) {
	
							// 높이 설정
							style.height = 180;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
							
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);
							
							var HeadTitle1 = "|Sel.|LANE|Dir.|VVD|ETA|ETD";
							
							var headCount = ComCountHeadTitle(HeadTitle1);
	
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, true, true, false,false);
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							
							//데이터속성    [  ROW,    COL, DATATYPE,         WIDTH,   DATAALIGN,   COLMERGE,	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0,	cnt++ , dtHiddenStatus,		 30,	daCenter,		true,	"ibflag");
							InitDataProperty(0,	cnt++ , dtCheckBox,			 50,	daCenter,		true,	"Chk",          false,		"",			dfNone,			0,		true,		true ,      -1,		false,		false,		false,		true  );
							InitDataProperty(0,	cnt++ , dtData,				 60,	daCenter,		true,	"slan_cd",		false,		"",			dfNone,			0,		false,		false,		3);
							InitDataProperty(0,	cnt++ , dtData,				 30,	daCenter,		true,	"skd_dir_cd",	false,		"",			dfNone,			0,		false,		false,		3);
							InitDataProperty(0,	cnt++ , dtData,				100,	daCenter,		true,	"vvd",			false,		"",			dfNone,			0,		false,		false,		9);
							InitDataProperty(0,	cnt++ , dtData,				125,	daCenter,		true,	"vps_eta_dt",	false,		"",			dfDateYmd,		0,		false,		false);
							InitDataProperty(0,	cnt++ , dtData,				115,	daCenter,		true,	"vps_etd_dt",	false,		"",			dfDateYmd,		0,		false,		false);

					}
					break;
					

				case "sheet2":
						with (sheetObj) {
	
							// 높이 설정
							style.height = 180;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
							
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);
							
							var HeadTitle1 = "|Sel.|Seq.|VVD|LANE";
							
							var headCount = ComCountHeadTitle(HeadTitle1);
	
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(8, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, true, true, false,false);
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							
							var prefix="sheet2_";
							
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		prefix + "ibflag");
							InitDataProperty(0,		cnt++ , dtCheckBox,				50,		daCenter,		true,		prefix + "Chk",          	false,		"",		dfNone,			0,		true,		true ,      -1,		false,	false,	false,	true  );
							InitDataProperty(0, 	cnt++ , dtSeq,				 	50,		daCenter,		true,		prefix + "Seq");
							InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + "vvd",				false,		"",		dfNone,			0,		true,		true , 		 9);
							InitDataProperty(0,		cnt++ , dtData,					30,		daCenter,		true,		prefix + "slan_cd",			false,		"",		dfNone,			0,		false,		false, 		 3); 
							InitDataProperty(0, 	cnt++ , dtHidden,  				0,      daCenter,    	true,     	prefix + "vsl_cd");
		                    InitDataProperty(0, 	cnt++ , dtHidden,  				0,      daCenter,    	true,     	prefix + "skd_voy_no");
		                    InitDataProperty(0, 	cnt++ , dtHidden,  				0,      daCenter,    	true,     	prefix + "skd_dir_cd");
							
							InitDataValid(0, 	prefix + "vvd", vtEngUpOther,"1234567890");
		                    InitDataValid(0, 	prefix + "slan_cd", vtEngUpOther,"");
					}
					break;
					
				case "sheet3":
					with (sheetObj) {

						// 높이 설정
						style.height = 170;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 3, 100);
						
						var HeadTitle1 = "|Sel.|Template Seq.|Template Type|Template Name|VVD";
						
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(6, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						
						//데이터속성    [ ROW,    COL, DATATYPE,      WIDTH,     DATAALIGN,  COLMERGE,  SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++, dtHiddenStatus,	 30,     daCenter,   false,		"ibflag");
	    				InitDataProperty(0, cnt++, dtCheckBox,    	 50,     daCenter,   false,     "sel");
	    				InitDataProperty(0, cnt++, dtHidden,       	 90,     daCenter,   false,     "tmplt_seq",    false,		"",        dfNone,     0,          true,       true,      10);
	    				InitDataProperty(0, cnt++, dtHidden,       	 90,     daCenter,   false,     "tmplt_tp_cd",  false,		"",        dfNone,     0,          true,       true,      10);
	    				InitDataProperty(0, cnt++, dtData,	       	200,     daLeft,     false,     "tmplt_hdr_nm", false,		"",        dfNone,     0,          true,       true,      10);
	    				InitDataProperty(0, cnt++, dtData,	       	500,     daLeftTop,  false,     "tmplt_ctnt",   false,		"",        dfNone,     0,          true,       true,      2000);
				}
				break;

    		}
    	}
      
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
     			
	     			case "btn_new":
	     				sheetObject2.RemoveAll();
	     				break;
	 				
	     			case "btn_rowAdd":
	     				sheetObjects[1].DataInsert(-1);
	     				break;
     			
     				case "btn_add":
     					addDelRow("add");
     					break;
     				
     				case "btn_del":
     					addDelRow("delete");
     					break;
     				
     				case "btns_up":
     					rowUpDown(sheetObject2, "UP");
     					break;
     					
     				case "btns_down":
     					rowUpDown(sheetObject2, "DOWN");
     					break;
     				
     				case "btn_loadexcel":
     					sheetObject2.LoadExcel();
//     					sheetObject2.Down2Excel();
     					break;
     					
     				case "btn_temp_add":
     					doActionIBSheet(sheetObjects[2],document.form,IBINSERT);
     					break;
     					
     				case "btn_temp_del":
     					doActionIBSheet(sheetObjects[2],document.form, IBDELETE);
     					break;
     					
     				case "btn_temp_save":
     					doActionIBSheet(sheetObjects[2],document.form,COMMAND02);
     					break;
     				
     				case "btn_Retrieve":
     					if( tabObjects[0].SelectedIndex == 0 ){
     						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     					} else{
     						doActionIBSheet(sheetObjects[2],document.form,SEARCH02);
     					}
     					break;
     				
     				case "btn_ok":
     					if( tabObjects[0].SelectedIndex == 0 ){
     						doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
     					} else{
     						doActionIBSheet(sheetObjects[2],document.form,COMMAND03);
     					}
     					break;											
     				
     				case "btn_close":
     					window.close();
     					break;
     				
     				case "btn_calendar":
     					var cal = new ComCalendarFromTo();
     	                cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt, 'yyyy-MM-dd');
     	                break;
     				
     				case "btn_edate":
     					var cal = new ComCalendar();
     					cal.select(formObject.vps_etd_dt, 'yyyy-MM-dd');
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
					
					for(var i = 0 ; i < formObj.check_op.length ; i++){
						
						if (formObj.check_op[i].checked == true){
							
							formObj.vps_eta_dt.value = formObj.check_op[i].value;
						}
					}
				
					formObj.f_cmd.value = SEARCH;  
					sheetObj.WaitImageVisible = false;
			        ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_0753GS.do",FormQueryString(formObj));
					
					break;
				
				case IBSAVE:        //체크
					//if(!validateForm(sheetObj,formObj,sAction)) return;
					
					if (sheetObj.RowCount < 1) {
						
						alert("Select Item");
						return;
					}
				
					for (var i = 1 ; i <= sheetObj.RowCount ; i++){
						
						if (sheetObj.CellValue(i,"sheet2_vvd") == ''){
							
							alert("You must input VVD");   								
							sheetObj.SelectCell(i, "sheet2_vvd", true, ' ');    								
							return;
						}else{
							
							var idx = sheetObj.CellValue(i,"sheet2_vvd");
							
							if (idx.length != 9){
								
								alert("VVD must be 9 characters");   									
								sheetObj.SelectCell(i, "sheet2_vvd", true, ' '); 
								return;
							}
						} 
						
						if (sheetObj.CellValue(i,"sheet2_slan_cd") == ''){
							
							alert("You must input Lanx");   								
							sheetObj.SelectCell(i, "sheet2_slan_cd", true, ' '); 
							return;
						}else{
							
							var idx = sheetObj.CellValue(i,"sheet2_slan_cd");
							
							if (idx.length != 3){
								
								alert("VVD must be 3 characters");    									
								sheetObj.SelectCell(i, "sheet2_slan_cd", true, ' '); 
								return;
							}
						}  	
						
						var vvdValue = sheetObj.CellValue(i,"sheet2_vvd");
						
						sheetObj.CellValue2(i,"sheet2_vsl_cd") = vvdValue.substring(0,4);
						sheetObj.CellValue2(i,"sheet2_skd_voy_no") = vvdValue.substring(4,8);
						sheetObj.CellValue2(i,"sheet2_skd_dir_cd") = vvdValue.substring(8);
					}
					
					formObj.f_cmd.value = MULTI;
					
					var sParam = ComGetSaveString(sheetObjects);
					sheetObj.WaitImageVisible = false;
			        ComOpenWait(true);
                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
        	        
        	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0753GS.do", sParam);
        	        
        	        if (SaveXml.indexOf("OK") > -1){
        	        	
        	        	returnValue();
        	        	self.close();
        	        }else{
        	        	
        	        	alert("Invalid VVD Value");
        	        	return;
        	        }
        	        
        	        break;
				
				case COMMAND01:      //VVD Check
					
					var idx = 0;
					var err_cnt = 0;
					var Row = 0;
					
					for(idx=1;idx<=sheetObj.RowCount;idx++){
						if( sheetObj.CellValue(idx,"sheet2_vvd").length > 0 && sheetObj.CellValue(idx,"sheet2_vvd").length < 9 ){
							err_cnt++;
							Row = idx;
						}
					}
					
					if( err_cnt > 0 ){
						alert("VVD must be 9 characters");
 						sheetObj.SelectCell(Row,"sheet2_vvd");
 						return;
					}
					
					err_cnt = 0;
					
					for(idx=1;idx<=sheetObj.RowCount;idx++){
						if( sheetObj.CellValue(idx,"sheet2_vvd").length == 9 && sheetObj.CellValue(idx,"sheet2_vvd") != "" ){
							formObj.vsl_cd.value 		= sheetObj.CellValue(idx,"sheet2_vvd").substring(0,4);
							formObj.skd_voy_no.value 	= sheetObj.CellValue(idx,"sheet2_vvd").substring(4,8);
							formObj.skd_dir_cd.value 	= sheetObj.CellValue(idx,"sheet2_vvd").substring(8);
							
							document.form.f_cmd.value = SEARCH01;   
	            			sheetObj.WaitImageVisible = false;
	        		        ComOpenWait(true);
	         		        var sXml = sheetObj.GetSearchXml("ESM_BKG_0753GS.do" , FormQueryString(document.form));
	         		        
	         		        if (ComGetEtcData(sXml,"check") == "Y"){
	         		        	sheetObj.CellValue2(idx,"sheet2_slan_cd") = ComGetEtcData(sXml,"lane");  		         
	         		        }else{
	         		        	err_cnt++;
	         		        	Row = idx;
	         		        	
	         		        	sheetObj.CellValue2(idx,"sheet2_slan_cd") = '';
	         		        }
						}
 					}
					
					if( err_cnt > 0 ){
						ComOpenWait(false);
//	         		        	sheetObj.SelectCell(idx,"sheet2_vvd"); 
     		        	
     		        	
     		        	if( sheetObj.SelectRow == Row ){
     		        		sheetObj.SelectCell(Row,"sheet2_vvd");
     		        		alert("Wrong VVD CD");
     		        	}
     		        	
     		        	return;
					}
					
     		        formObj.vsl_cd.value 		= '';
					formObj.skd_voy_no.value 	= '';
					formObj.skd_dir_cd.value 	= '';
				
					break;
				
				case IBINSERT:	  //입력
					var Row = sheetObj.DataInsert(-1);
					sheetObj.cellValue2(Row, "tmplt_tp_cd") = "V";
					break;
					
				case IBDELETE:
					ComRowHideDelete(sheetObj, "sel");
					break;
					
				case SEARCH02:	  //sheet3 조회
					var sParam = "&f_cmd=" + SEARCH + "&tmplt_tp_cd=V&marks_type=V";
					sheetObj.DoSearch("ESM_BKG_0365GS.do", sParam);
					
					//기존 BKG공통 팝업과 같이 사용함에 따라 기존 화면 로직과 비슷하게 필터링 기능 추가
					var idx = 0;
					for (idx = sheetObj.RowCount; idx > 0; idx--) {
						if(sheetObj.CellValue(idx, "tmplt_tp_cd") != "V"){
							sheetObj.RowDelete(idx,false);
						}
					}
					break;
					
				case COMMAND02:	  //sheet3 저장
					var sParam = "&f_cmd=" + MULTI + "&tmplt_tp_cd=V&marks_type=V";
					sheetObj.DoSave("ESM_BKG_0365GS.do", sParam, -1, false, true);

					break;
                    
				case COMMAND03:
 					var chk_cnt = 0;
 		        	var reValue = "";
 		        	for (var i = 1 ; i <= sheetObj.RowCount ; i++){
 		        		if( sheetObj.CellValue(i, "sel") == "1" ){
 		        			reValue = sheetObj.CellValue(i, "tmplt_ctnt");
 		        			chk_cnt++
 		        		}
 		        	}
 		        	
 		        	if( chk_cnt == 0 || chk_cnt > 1 ) {
 						ComShowMessage(ComGetMsg("BKG08040"));
 						return;
 					}
 		        	 
 		        	window.opener.clearVvds();
 		        	window.opener.setVvds(reValue);
 		        	self.close();
 		        	break;
            }
                ComOpenWait(false);
        }



        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 	
        	 	if (formObj.vps_port_cd.value == ''){
					
					alert("You must input port");
					formObj.vps_port_cd.focus();
					return false;
				}else{
					
					if ( formObj.vps_port_cd.value.length < 2 || formObj.vps_port_cd.value.length > 5){
						
						alert("Port must enter at least 2 characters long");
						formObj.vps_port_cd.focus();
						return false;
					}  
				}
				
       			if (formObj.vvd.value == ''){
					
					formObj.vsl_cd.value 		= '';
					formObj.skd_voy_no.value 	= '';
					formObj.skd_dir_cd.value 	= '';
					
        	 	}else{
        	 		
        	 		if (formObj.vvd.value.length < 9){
						alert("VVD must be 9 characters");
						
						formObj.vvd.focus();
						return;
					}else{
						formObj.vsl_cd.value 		= formObj.vvd.value.substring(0,4);
						formObj.skd_voy_no.value 	= formObj.vvd.value.substring(4,8);
						formObj.skd_dir_cd.value 	= formObj.vvd.value.substring(8);
					}   
        	 	}
				
				if (formObj.slan_cd.value != ''){

					if (formObj.slan_cd.value.length < 3){
					
						alert("Lane must be 3 characters");
						
						formObj.slan_cd.focus();
						return false;
					}    								
				}
				/*
				if (formObj.vvd.value != ''){

					if (formObj.vvd.value.length < 9){
					
						alert("VVD must be 9 characters");
						
						formObj.vvd.focus();
						return;
					}else{
						
						formObj.vsl_cd.value 		= formObj.vvd.value.substring(0,4);
						formObj.skd_voy_cd.value 	= formObj.vvd.value.substring(4,8);
						formObj.skd_dir_cd.value 	= formObj.vvd.value.substring(8);
					}   							
				}else{
					
					formObj.vsl_cd.value 		= '';
					formObj.skd_voy_cd.value 	= '';
					formObj.skd_dir_cd.value 	= '';
				}
				*/
            return true;
        }
            
      /**
       * row 추가/삭제
       */    
       function addDelRow(type){
    	   if (type == "add"){
    		   var tmp = "";
    		   for (var i = 1 ; i < sheetObjects[0].RowCount+1 ; i++){
    			   if (sheetObjects[0].CellValue(i,"Chk") == '1'){
    				   var chkValue = true;
    				   for (var j = 1 ; j < sheetObjects[1].RowCount+1 ; j++){
    					   if (sheetObjects[0].CellValue(i,"vvd") == sheetObjects[1].CellValue(j,"vvd")){
    						   tmp += "\n"+sheetObjects[0].CellValue(i,"vvd");
    						   chkValue = false;
    						   break;
    					   }
    				   }
    				   if (chkValue){
	    				   var row = sheetObjects[1].DataInsert(-1);
	    				   sheetObjects[1].CellValue2(row,"sheet2_vvd") = sheetObjects[0].CellValue(i,"vvd");
	    				   sheetObjects[1].CellValue2(row,"sheet2_slan_cd") = sheetObjects[0].CellValue(i,"slan_cd");    				   
    				   }
    				   if (document.form.num_max_knt.value < sheetObjects[1].RowCount) {
    					   for( var idx=sheetObjects[1].RowCount;idx>document.form.num_max_knt.value;idx--){
    						   sheetObjects[1].RowDelete(idx, false);
    					   }
    					   
    					   var strMsg = "VVD input max " + document.form.num_max_knt.value + "!";
    					   ComShowCodeMessage("BKG02006","",strMsg);
    					   break;
    				   }
    			   }
    		   }
    		   if (""!=tmp) {
    			   alert("exist same data\n"+tmp);
    		   }
    	   } else {
    		   var idx = sheetObjects[1].RowCount;
    		   for (var i = 1 ; i < idx+1 ; i++){
    			   for (var j = 1 ; j < sheetObjects[1].RowCount+1 ; j++){
	    			   if (sheetObjects[1].CellValue(j,"sheet2_Chk") == '1'){
	    				   sheetObjects[1].RowDelete(j,false);	   
	    			   }
    			   }
    	       }    			   
    	   }
       }
       
       /**
        * row UP/DOWN
        */
        function rowUpDown(sheetObj, type){
     	   
     	   Row = sheetObj.SelectRow;
     	   
     	   if (sheetObj.RowCount > 0){
     		   
     		   if (type == 'UP'){

     			   if (Row > 1){
     			           			   
     				   tempUPCheck  = sheetObj.CellValue(Row-1,"sheet2_Chk");
     				   tempUPItem   = sheetObj.CellValue(Row-1,"sheet2_vvd");
     				   tempUPLane	= sheetObj.CellValue(Row-1,"sheet2_slan_cd");
     				          				   
     				   tempNowCheck = sheetObj.CellValue(Row,"sheet2_Chk");
     				   tempNowItem  = sheetObj.CellValue(Row,"sheet2_vvd");
     				   tempNowLane	= sheetObj.CellValue(Row,"sheet2_slan_cd");
     				       				   
     				   sheetObj.CellValue(Row-1,"sheet2_Chk") = tempNowCheck;
     				   sheetObj.CellValue(Row-1,"sheet2_vvd") = tempNowItem;
     				   sheetObj.CellValue(Row-1,"sheet2_slan_cd") = tempNowLane;
     				   
     				   sheetObj.CellValue(Row,"sheet2_Chk")   = tempUPCheck;
     				   sheetObj.CellValue(Row,"sheet2_vvd")   = tempUPItem;
     				   sheetObj.CellValue(Row,"sheet2_slan_cd")   = tempUPLane;
     				   
     				   sheetObj.SelectCell(Row-1, "sheet2_Chk");
     			   }
     		   }else{

     			   if (Row < sheetObj.RowCount){
     				   
     				   tempDWCheck  = sheetObj.CellValue(Row+1,"sheet2_Chk");
     				   tempDWItem   = sheetObj.CellValue(Row+1,"sheet2_vvd");
     				   tempDWLane	= sheetObj.CellValue(Row+1,"sheet2_slan_cd");
     				   
     				   tempNowCheck = sheetObj.CellValue(Row,"sheet2_Chk");
     				   tempNowItem  = sheetObj.CellValue(Row,"sheet2_vvd");
     				   tempNowLane	= sheetObj.CellValue(Row,"sheet2_slan_cd");
     				   
     				   sheetObj.CellValue(Row+1,"sheet2_Chk") = tempNowCheck;
     				   sheetObj.CellValue(Row+1,"sheet2_vvd") = tempNowItem;
     				   sheetObj.CellValue(Row+1,"sheet2_slan_cd") = tempNowLane;
     				   
     				   sheetObj.CellValue(Row,"sheet2_Chk")   = tempDWCheck;
     				   sheetObj.CellValue(Row,"sheet2_vvd")   = tempDWItem;
     				   sheetObj.CellValue(Row,"sheet2_slan_cd")   = tempDWLane;
     				   
     				   sheetObj.SelectCell(Row+1, "sheet2_Chk");
     			   }
     		   }
     	   }
        }
        
        /**
         * 셀변경후  이벤트 처리 >>> VVD체크
         */ 
        function sheet2_OnChange(sheetObj, Row, Col) {
        	var colName = sheetObj.ColSaveName(Col);
        	if (colName == "sheet2_vvd"){
        		doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
        	}
        }
        function sheet2_OnLoadExcel(sheetObj) {
	     	if (document.form.num_max_knt.value < sheetObj.RowCount) {
	     		for( var idx=sheetObjects[1].RowCount;idx>document.form.num_max_knt.value;idx--){
	     			sheetObjects[1].RowDelete(idx, false);
	     		}
	     		
	     		var strMsg = "VVD input max " + document.form.num_max_knt.value + "!";
	     		ComShowCodeMessage("BKG02006","",strMsg);
			}
	     	doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
        }
        
        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem) {
	       	var objs = document.all.item("tabLayer");
	     	objs[nItem].style.display = "Inline";
	       	objs[beforetab].style.display = "none";
	
	       	//--------------- 요기가 중요 --------------------------//
	       	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	       	//------------------------------------------------------//
	       	beforetab= nItem;
	       	tabIndex = nItem;
        }
         
         /**
          * Popup Return Value
          */
         function returnValue(){
        	 
        	 var sheet2		= sheetObjects[1];
        	 
        	 var reValue = "";
        	 
        	 for (var i = 1 ; i <= sheet2.LastRow ; i++){
        		 
        		 if (i != 1){
        			 
        			 reValue += ",";
        		 }
        			 
        		 reValue += sheet2.CellValue(i, "sheet2_vvd");
        	 }
        	 
        	 window.opener.clearVvds();
        	 window.opener.setVvds(reValue);
         }
         
         /**
          * 날짜 계산 함수
          */
         function getCalculatedDate(iYear,iMonth,iDay,seperator)
         {
         	//현재 날짜 객체를 얻어옴
         	var gdCurDate = new Date();
         	
         	//현재 날짜에 날짜 계산
         	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
         	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
         	gdCurDate.setDate(gdCurDate.getDate() + iDay);
         	
         	//실제 사용할 연,월,일 변수 받기
         	var giYear = gdCurDate.getFullYear();
         	var giMonth = gdCurDate.getMonth()+1;
         	var giDay = gdCurDate.getDate();

         	//월,일의 자릿수를 2자리로 맞춘다.
         	giMonth = "0" + giMonth;
         	giMonth = giMonth.substring(giMonth.length-2,giMonth.length);
         	giDay   = "0" + giDay;
         	giDay   = giDay.substring(giDay.length-2,giDay.length);
         	//alert(giYear + seperator + giMonth + seperator + giDay);
         	//display 형태 맞추기
         	return giYear + seperator + giMonth + seperator + giDay;	
         }
       

	/* 개발자 작업  끝 */