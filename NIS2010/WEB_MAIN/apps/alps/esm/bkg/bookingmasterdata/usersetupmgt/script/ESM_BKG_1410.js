/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1410.jsp
*@FileTitle : Web Booking Manual Upload Setup Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2014.10.13 김도현
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
     * @class ESM_BKG_1410 : ESM_BKG_1410 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1410() {
    	this.processButtonClick		= processButtonClick;
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
	
	//Delete시 Validation을 위한 HeadCount 변수와 SelRow변수
	var delSelRow ="";
	var delHeadCount ="";
	var delStat ="";
	
	//T.LANE VALIDATION시 대상을 폼으로 볼지 시트로 볼지 결정하는 변수
	var sheetFlag ="";
	
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

            switch(srcName) {

				case "btn_Retrieve":
					if(formObject.dirty_flag.value == 'Y' && formObject.screenName.value == 'ESM_BKG_1410' && confirm(ComGetMsg("BKG00254"))){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_rowadd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;																	
	
				case "btn_rowdel":	
					
					if(sheetObject1.LastRow =="1"){
						//아무것도 없는 상태에서 삭제를 시도할 경우 대상이 없음을 알린다.
		            	ComShowMessage(ComGetMsg("BKG03055"));
					}else if(!validateForm(sheetObject1,formObject,IBDELETE) && delStat == "0"){
						//insert만 하고 바로지울 경우 경고없이 지운다. 
						sheetObject1.RowDelete(delSelRow,false);
					} else if(!validateForm(sheetObject1,formObject,IBDELETE) && delStat == "1"){
						//특정 Raw를 추가후 정보를 입력하고 저장하지 않고 지울경우 Confirm을 한다.. 
						sheetObject1.RowDelete(delSelRow,true);
					} else if(validateForm(sheetObject1,formObject,IBDELETE)){
						//일반적으로 data를 지울경우 변경사항이 있을 경우 변경사항에 대한 저장여부를 물어보고 삭제여부를 물어본다.
						if(sheetObject1.CellValue(delSelRow, "blck_seq") != 0){
							if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
								doActionIBSheet(sheetObject1,formObject,IBSAVE);
							}
						}
						
						if(sheetObject1.CellValue(delSelRow, "blck_seq") == 0){
							sheetObject1.RowDelete(delSelRow,false);
						}else{
							if(confirm(ComGetMsg("BKG00535"))){
								doActionIBSheet(sheetObject1, formObject, IBDELETE);
							}
						}
					}
				break;	
				
				case "btn_copy":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
				break;
				
				case "btn_excel":
					 sheetObjects[0].SpeedDown2Excel(-1);
				break;
					
				case "btn_new":
					init_form();
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;			
    }

  	/**
  	 * Sheet 기본 설정 및 초기화 <br>
  	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     loadPage();
  	 * </pre>
  	 * @return 없음
  	 */                   
    function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// add listener
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
        
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

    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
    }
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|Seq|BKG Office|Block Sequence|Lane|Vessel\nDirection|VVD|Customer|POL|POL|POD|POD|Remark|Create|Create|Update|Update";
					var HeadTitle2 = "|Seq|BKG Office|Block Sequence|Lane|Vessel\nDirection|VVD|Customer|Country|Location|Country|Location|Remark|User|Date|User|Date";

					var headCount = ComCountHeadTitle(HeadTitle2);
					
					delHeadCount = headCount;
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    FrozenCols = 5;
                                        
                    //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 20,    daCenter,  true,     "ibflag");
                    InitDataProperty(0,	cnt++, dtSeq,		    30,    daCenter,  true,	    "seq",			false,	"",			dfNone,		0,			 false,		 true);
                    InitDataProperty(0, cnt++, dtData,          75,    daCenter,  true,     "bkg_ofc_cd",	true,   "",         dfNone,     0,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtHidden,         0,    daCenter,  true,     "blck_seq",    	false,  "",         dfNone,     0,           true,      false,     9);
                    InitDataProperty(0, cnt++, dtData,          35,    daCenter,  true,     "vsl_slan_cd",	false,  "",         dfNone,     0,           true,      true,     3);
                    InitDataProperty(0, cnt++, dtCombo,          55,    daCenter,  true,     "lodg_dir_cd",	false,  "",         dfNone,     0,           true,      true,     3);
                    InitDataProperty(0, cnt++, dtData,          70,    daCenter,  true,     "vvd",    		false,  "",         dfNone,     0,           true,      true,     9);
                    InitDataProperty(0, cnt++, dtData,          65,    daCenter,  true,     "cust_cnt_cd",	false,  "",         dfNone,     0,           true,      true,     8);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  true,     "pol_cnt_cd",   false,  "",         dfNone,     0,           true,      true,     2);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  true,     "pol_cd",    	false,  "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  true,     "pod_cnt_cd",   false,  "",         dfNone,     0,           true,      true,     2);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  true,     "pod_cd",      	false,	"",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,          60,    daCenter,  true,     "xter_rmk",     false,	"",         dfNone,     0,           true,      true,     2000);
                    InitDataProperty(0, cnt++, dtData,          65,    daCenter,  true,     "cre_usr_id",   false,  "",         dfNone,     0,           true,      true,     0);
                    InitDataProperty(0, cnt++, dtData,         110,    daCenter,  true,     "cre_dt",    	false,  "",         dfNone,     0,           true,      true,     0);
                    InitDataProperty(0, cnt++, dtData,          65,    daCenter,  true,     "upd_usr_id",   false,  "",         dfNone,     0,           true,      true,     0);
                    InitDataProperty(0, cnt++, dtData,         110,    daCenter,  true,     "upd_dt",      	false,  "",         dfNone,     0,           true,      true,     0);
            	}
                break;
        }
    }

  /**
    * Sheet관련 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @return 없음
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCLEAR: // 화면 로딩시 코드 조회
	        	var formObj = document.form;
	        	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
	        	var param = FormQueryString(formObj);
	        	param = param + "&cm_code=CD00593";
	        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	        	var arrXml = sXml.split("|$$|");
	        	if (arrXml[0].length > 0) {
					arrXml[0] = ComReplaceStr(arrXml[0], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObjects[0],arrXml[0],"lodg_dir_cd",true,"","","","cd");
	        	}
			break;	
        
			case IBSEARCH:      //조회
					formObj.f_cmd.value = SEARCH;		
					sheetObj.DoSearch("ESM_BKG_1410GS.do", FormQueryString(formObj));
					// 데이터 변경 여부 체크
					formObj.dirty_flag.value = 'N';
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;	
					sheetObj.DoSave("ESM_BKG_1410GS.do", FormQueryString(formObj));
                }else{
					return false;					
				}
			break;

			case IBINSERT:      //Row 추가
				var newRow = sheetObj.DataInsert(-1);
			    // 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
			break;
			
			case IBDELETE:        //삭제
				formObj.f_cmd.value = REMOVE;
				sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = 'D';
				sheetObj.DoSave("ESM_BKG_1410GS.do", FormQueryString(formObj));
			break;
			
			case IBCOPYROW: // Row Copy                                                                                                                                                                                                                                                                                                                                                                                                                                   
				var oldIdx = sheetObj.SelectRow;  
				var newIdx = sheetObj.DataCopy();    
				sheetObj.CellValue2(newIdx, "blck_seq") = 0;
			break;  
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

            case IBSAVE:
				if(/*formObj.dirty_flag.value == 'N' ||*/ sheetObj.GetSaveString() == ""){
					ComShowMessage(ComGetMsg("BKG00737"));
					return false;
				}
				with(sheetObj){	
					if(formObj.dirty_flag.value == 'Y'){							
					    for (i=HeaderRows ; i<= LastRow; i++) {
					    	if(CellValue(i, "ibflag") == "I" || CellValue(i, "ibflag") == "U"){
				    			if(CellValue(i, "bkg_ofc_cd") == ""){
				    				ComShowMessage(ComGetMsg("BKG00887","BKG Office"));
				    				SelectCell(i,"bkg_ofc_cd");
				    				return false;
				    			}
					    	}
					    }
					}
					
				    
		    		formObj.f_cmd.value = SEARCH01;
		    		var sParam = sheetObj.GetSaveString(false, true, "bkg_ofc_cd") + "&" + FormQueryString(formObj);
     	    		var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
     	    		if(ComGetEtcData(sXml, "chk_flg") != '0'){
     	    			ComShowCodeMessage("BKG95069");
     	    			return false;
     	    		}
     	    		
				    
					
				}
			break;	
			
            case IBDELETE:
            	delStat = "";
            	delSelRow = sheetObj.SelectRow;            	
            	//선택한 행이 Insert한 경우이며 Data 가 없을 경우 바로 지운다.
            	if(sheetObj.CellValue(delSelRow, "blck_seq") ==""){
            		var rowData ="";
            		for(var i=3; i <= delHeadCount-1; i++){
            			if(sheetObj.CellValue(delSelRow, i) != "" && sheetObj.ColSaveName(i) !="bkg_ofc_cd"){
            					rowData = "N";          				
            			}
            		}
            		if(rowData ==""){
            			//지우고자 하는 행에 Data가 없는 경우 바로 지운다.            			
            			delStat = "0";
            			return false;
            		}else {
            			//지우고자 하는 행에 Data가 있음에도 지우면 삭제 여부 알림창을 띄움.
            			delStat = "1";
            			return false;
            		}            		
            	}
            	//Detele 대상 로우외에 변동사항이 없다면 dirty_flag를 N으로 변경시킨다.
            	formObj.dirty_flag.value = 'N';
    			for(var i=2; i <= sheetObj.RowCount+1; i++){
    				if(i != delSelRow){
    					if(sheetObj.CellValue(i, "ibflag") == "I" || sheetObj.CellValue(i, "ibflag") == "U"){
            				formObj.dirty_flag.value = "Y";
            			}
    				}                			
        		}
			break;
        }
        return true;
    }
     
    /**
     * Event 처리 <br>
     * </pre>
     * @return 없음
     */
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		switch(event.srcElement.dataformat){
			case "engupnum":
				ComKeyOnlyAlphabet("uppernum");
			break;
		}	
	}
	
	/**
	 * 화면 시트값의 변화에 따라 수행될 동작을 정의한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @returns 없음
	 */
	function sheet1_OnChange(sheetObj, row, col, val) {
		
		var formObj = document.form;
		var val_type = "";
		var val_value = "";
		
		// 데이터 변경 여부 체크
		formObj.dirty_flag.value = 'Y';
		sheetFlag ="Y";
		
		/* ColSaveName */
		var col_save_name = sheetObj.ColSaveName(col);
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		/* 대문자 */
		if(data_type == dtData && col_save_name != "xter_rmk") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}

		if (col_save_name == "vsl_slan_cd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "LANE";
        		val_value = sheetObj.CellValue(row,col_save_name);

        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        		
        		if(val_value != "" && sheetObj.CellValue(row,"vvd") != ""){
    	        	formObj.f_cmd.value  = SEARCH02;
    	        	var sParam = FormQueryString(formObj)+"&val_value="+sheetObj.CellValue(row,"vvd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(val_value != ComGetEtcData(sXml,"vsl_slan_cd")){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
    	        	
        		}
        	}
        } else if(col_save_name == "bkg_ofc_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	formObj.ofc_cd.value = sheetObj.CellValue(row,col);
	        	formObj.ofc_ty.value = 1;
	        	formObj.f_cmd.value  = SEARCH01;
	        	var sParam = FormQueryString(formObj);
	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0741GS.do", sParam);
	   	     
		   	     if (ComGetEtcData(sXml,"check") == "N"){
		   	    	 ComShowCodeMessage("BKG01107");//사용가능한 Office Code가 아닙니다.
		   	    	 sheetObj.SelectCell(row, col, true, '');
		       	 }
        	}
        } else if(col_save_name == "vvd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	if (sheetObj.CellValue(row,col).length != 9){
					 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
					 sheetObj.SelectCell(row, col, true, '');
					 return false;
	        	}
	        	formObj.f_cmd.value = SEARCH01;   
	        	formObj.vvd_sig.value = sheetObj.CellValue(row,col);
				 
				 var searchXml = sheetObj.GetSearchXml("ESM_BKG_0632GS.do" , FormQueryString(formObj));
				 if (ComGetEtcData(searchXml,"lane") == "none"){
					 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
					 sheetObj.SelectCell(row, col, true, '');
				 }
				 
        		val_value = sheetObj.CellValue(row,col_save_name);
				 
        		if(val_value != "" && sheetObj.CellValue(row,"vsl_slan_cd") != ""){
    	        	formObj.f_cmd.value  = SEARCH02;
    	        	var sParam = FormQueryString(formObj)+"&val_value="+sheetObj.CellValue(row,"vvd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(sheetObj.CellValue(row,"vsl_slan_cd") != ComGetEtcData(sXml,"vsl_slan_cd")){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
    	        	
        		}
        		
        		if(val_value != "" && sheetObj.CellValue(row,"pol_cd") != ""){
    	        	formObj.f_cmd.value  = SEARCH03;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+val_value+"&pol_cd="+sheetObj.CellValue(row,"pol_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
    	        	
        		}
        		
        		if(val_value != "" && sheetObj.CellValue(row,"pod_cd") != ""){
    	        	formObj.f_cmd.value  = SEARCH03;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+val_value+"&pol_cd="+sheetObj.CellValue(row,"pod_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
        		}
        		
        		if(val_value != "" && sheetObj.CellValue(row,"pol_cnt_cd") != ""){
    	        	formObj.f_cmd.value  = SEARCH04;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+val_value+"&pol_cnt_cd="+sheetObj.CellValue(row,"pol_cnt_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
        		}
        		
        		if(val_value != "" && sheetObj.CellValue(row,"pod_cnt_cd") != ""){
    	        	formObj.f_cmd.value  = SEARCH04;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+val_value+"&pod_cnt_cd="+sheetObj.CellValue(row,"pod_cnt_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
        		}
        	}
        } else if(col_save_name == "cust_cnt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CUSTOMER";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		// 첫 두자리를 제외한 나머지 숫자 체크
        		if(!ComIsNumber(val_value.substring(2,val_value.length))) {
        			ComShowCodeMessage("BKG00340");
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "pod_cd" || col_save_name == "pol_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "Location";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        		
        		if(sheetObj.CellValue(row,"pol_cd") != "" && sheetObj.CellValue(row,"vvd") != ""){
    	        	formObj.f_cmd.value  = SEARCH03;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+sheetObj.CellValue(row,"vvd")+"&pol_cd="+sheetObj.CellValue(row,"pol_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, col, true, '');
    	        	}
        		}
        		
        		if(sheetObj.CellValue(row,"pod_cd") != "" && sheetObj.CellValue(row,"vvd") != ""){
    	        	formObj.f_cmd.value  = SEARCH03;
    	        	var sParam = FormQueryString(formObj)+"&vvd="+sheetObj.CellValue(row,"vvd")+"&pod_cd="+sheetObj.CellValue(row,"pod_cd");
    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
    	        	
    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
   		   	    	 	sheetObj.SelectCell(row, 10, true, '');
    	        	}
        		}
        		
        	}	
        } else if(col_save_name == "pol_cnt_cd" || col_save_name == "pod_cnt_cd"){
		    	if(sheetObj.CellValue(row,col_save_name)!="" ){
		    		val_type = "CNT";
		    		val_value = sheetObj.CellValue(row,col_save_name); 
		    		if(!searchValidationData(sheetObj, val_type, val_value)) {
		    			sheetObj.CellValue2(row,col_save_name) = "";
		    			sheetObj.SelectCell(row, col);
		    		}
		    		
	        		if(sheetObj.CellValue(row,"pol_cnt_cd") != "" && sheetObj.CellValue(row,"vvd") != ""){
	    	        	formObj.f_cmd.value  = SEARCH04;
	    	        	var sParam = FormQueryString(formObj)+"&vvd="+sheetObj.CellValue(row,"vvd")+"&pol_cnt_cd="+sheetObj.CellValue(row,"pol_cnt_cd");
	    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
	    	        	
	    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
	    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
	   		   	    	 	sheetObj.SelectCell(row, col, true, '');
	    	        	}
	        		}
		    		
	        		if(sheetObj.CellValue(row,"pod_cnt_cd") != "" && sheetObj.CellValue(row,"vvd") != ""){
	    	        	formObj.f_cmd.value  = SEARCH04;
	    	        	var sParam = FormQueryString(formObj)+"&vvd="+sheetObj.CellValue(row,"vvd")+"&pod_cnt_cd="+sheetObj.CellValue(row,"pod_cnt_cd");
	    	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1410GS.do", sParam);
	    	        	
	    	        	if(ComGetEtcData(sXml,"chk_flg") == "0"){
	    	        		ComShowCodeMessage("BKG95070");//You have set the same before. Please, check again.
	   		   	    	 	sheetObj.SelectCell(row, 9, true, '');
	    	        	}
	        		}
		    		
		    	}
	    }
		
 	}
	
	/**
	 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} lane_cd  
	 * @param {String} dir_cd  
	 * @param {String} cmdt_cd 
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 */
	function searchValidationData(sheetObj, val_type, val_value) {
		var formObj = document.form;
		var sParam  = "";
		//sheetFlag Y이면 시트에 입력된값을 기준으로 Validation하고 ""이면 FormObject를 기준으로 Validation한다.
    	if(sheetFlag == "Y"){
    		sParam = "f_cmd=102&" + "&val_type="+val_type+"&val_value="+val_value;
    	} else{
    		formObj.f_cmd.value = SEARCH01;
    		sParam = FormQueryString(formObj);    		
    	}
    	
    	sheetFlag = "";
    	
//    	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1410GS.do", sParam);
    	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1215GS.do", sParam);
    	
    	var val_cnt  = ComGetEtcData(sXml, "val_cnt");

		if(val_cnt < 1 && val_cnt != ""){
			ComShowCodeMessage('BKG00993',val_type + " : " + val_value);			
			return false;
		}
		 
		return true;
	}
	
	/**
	 * IBSheet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} ErrMsg 저장 후 메시지
	 * @return 없음
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if (ErrMsg == "") {
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
			formObj.dirty_flag.value = 'N';
		}
    }
	
	/**
	 * IBSheet 저장 함수를 이용하여 조회가 완료되고 발생하는 Event<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} ErrMsg 저장 후 메시지
	 * @return 없음
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    }    
    
    /**
     * New 버튼 클릭시 화면 초기화.
     */
    function init_form() {
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		
  		formObj.bkg_ofc_cd.value = "";
  		sheetObj.RemoveAll();
  	}
