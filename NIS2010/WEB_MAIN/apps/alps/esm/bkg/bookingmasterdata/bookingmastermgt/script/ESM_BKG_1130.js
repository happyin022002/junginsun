/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1130.js
*@FileTitle :Chinese Agent Set-up(China 24hr Manifest)
*Open Issues :
*Change history :
*@LastModifyDate :2011.09.26
*@LastModifier : Lee InYoung
*@LastVersion : 1.0
* 2011.09.26 Lee InYoung
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
     * @class esm_bkg_1130 : esm_bkg_1130 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1130() {
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
    		         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                	case "btn_attach":
    	        		if (sheetObject.FindCheckedRow("del_chk") == "") {
    	        			ComShowCodeMessage("BKG00249");//"No Selected Row";
    	        		} else if (sheetObject.CheckedRows(1) > 1) {
    	        			ComShowCodeMessage("BKG04019");//"Please Select One Row in the list";
    	        		} else if (sheetObject.CellValue( sheetObject.SelectRow, "saved_flg") != "Y") {
    	        			ComShowCodeMessage("BKG08208");//"Data was changed.Please save first.";
    	        		} else {
                			var urlParam = "ESM_BKG_1131.do?rgn_ofc_cd="+sheetObject.CellValue(sheetObject.SelectRow, "rgn_ofc_cd")+"&loc_cd="
                							+sheetObject.CellValue(sheetObject.SelectRow,"loc_cd")+"&cnt_cd="+sheetObject.CellValue(sheetObject.SelectRow, "cnt_cd")
                							+"&dp_seq="+sheetObject.CellValue(sheetObject.SelectRow, "dp_seq")
                							+"&file_up_title="+sheetObject.CellValue(sheetObject.SelectRow,"rstr_cmdt_grp_nm");
            				ComOpenPopup(urlParam, 525, 520, "", "0,0,1,1,1,1,1", true);
    	        		}
            			break;
                	break;
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					
					case "btn_downexcel":
						sheetObject.SpeedDown2Excel(-1);
					break;			
					
					case "btn_add":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
					
					case "btn_RowCopy":
						sheetObject.DataCopy();
						// Row Copy 된 경우, saved flg를 N으로 설정한다. (Save 처리 후, Attach 처리를 하기 위해)
						sheetObject.CellValue( sheetObject.SelectRow, "saved_flg") = "N";
						// Copy한 후, 다음의 값들을 초기화 한다.
						sheetObject.CellValue( sheetObject.SelectRow, "rstr_cmdt_grp_nm") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "file_upld_nm") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "rstr_cmdt_nm") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "prohi_cmdt_nm") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "eff_dt") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "exp_dt") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "upd_usr_id") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "upd_dt") = "";
						sheetObject.CellValue( sheetObject.SelectRow, "inter_rmk") = "";
						break;
						
					case "btn_del":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
        	var formObject = document.form;
        	
			for(i=0;i<sheetObjects.length;i++){
	
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
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
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- 키보드 입력할때
            axon_event.addListenerForm('keyup', 'obj_keyup', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            axon_event.addListenerForm ('blur', 'obj_deactivate', form);
            axon_event.addListenerForm ('activate', 'obj_activate', form);

            // Effective Date를 현재 날짜로 Default 세팅
        	//formObject.eff_dt.value=ComGetNowInfo('ymd','-');
 
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
                        style.height = 400;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;  
                        

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                      
                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(1, 1, 15, 100);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)                       
 
                        var HeadTitle = "||Seq.|RHQ|Dest.\nCountry|Dest\nLocation\nCode|Incl.\nT/S\nCargo|Incl.\nFROB\nCargo|Main Contents|Attachments|Restricted|Prohibited|Effective\ndate|Expired\ndate|User ID|Update Date|Remarks||||";
                        var headCount = ComCountHeadTitle(HeadTitle);
                        
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);                        
                    

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        
                        //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
 						InitDataProperty(0,	cnt++,	dtCheckBox,		30, 	daCenter,	true,	"del_chk", 		    false,		"",		 dfNone,	0,		true,	    true);
	                    InitDataProperty(0, cnt++ , dtDataSeq,	    40,	    daCenter,	true,	"Seq",	            false,	 	"",	  	 dfNone,	0,	    false,      false);
 						InitDataProperty(0, cnt++ , dtCombo,		70,  	daCenter,	true,	"rgn_ofc_cd",   	false,		"",      dfEngUpKey,0,		false,		false,	5);
						InitDataProperty(0, cnt++ , dtData,			80,     daCenter,	true,	"cnt_cd",	        false,		"",      dfEngUpKey,0,		false,		false,	2);
						InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	true,	"loc_cd",		    false,		"",      dfEngUpKey,0,		false,		false,  5);
						InitDataProperty(0, cnt++ , dtCheckBox,		70,	    daCenter,	true,	"ts_flg",		    false,		"",      dfNone,	0,		true,		true,   5);
						InitDataProperty(0, cnt++ , dtCheckBox,		70,	    daCenter,	true,	"frob_flg",		    false,		"",      dfNone,	0,		true,		true,   5);
						InitDataProperty(0, cnt++ , dtData,			100,    daCenter,	true,	"rstr_cmdt_grp_nm", false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			220,	daCenter,	true,	"file_upld_nm",		false,		"",      dfNone,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,	    200,	daCenter,	true,	"rstr_cmdt_nm",		false,		"",      dfNone,	0,		true,		true,	50);
						InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,	"prohi_cmdt_nm",	false,		"",      dfNone,	0,		true,		true,	50);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"eff_dt",			false,		"",      dfDateYmd,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"exp_dt",			false,		"",      dfDateYmd,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"upd_usr_id",		false,		"",      dfNone,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"upd_dt",			false,		"",      dfNone,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,	"inter_rmk",		false,		"",      dfNone,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,	    85,    	daCenter,	true,	"dp_seq",			false,		"",      dfNone,	0,		false,		true,   2);
						InitDataProperty(0, cnt++ , dtHidden,	    85,    	daCenter,	true,	"file_sav_id",		false,		"",      dfNone,	0,		false,		true,   2);
						InitDataProperty(0, cnt++ , dtHidden,	    85,    	daCenter,	true,	"saved_flg",		false,		"",      dfNone,	0,		false,		true,   2);
						InitDataProperty(0, cnt++ , dtHidden,	85,    	daCenter,	true,	"dup_chk_flg",		false,		"",      dfNone,	0,		false,		true,   2);

		                InitDataCombo(0, "rgn_ofc_cd", 	"NYCRA|HAMRU|SINRS|SHARC", 	"NYCRA|HAMRU|SINRS|SHARC");
		                
						AutoRowHeight = false;
						Ellipsis = true;
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
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.WaitImageVisible = false;
		        	  
		        	  ComOpenWait(true);
		        	  sheetObj.DoSearch("ESM_BKG_1130GS.do", FormQueryString(formObj)
					  			+ "&" + ComGetPrefixParam(""));
		        	  
		        	  ComOpenWait(false);
		          }	
	               	break;
	               	
	           case IBSAVE:        //저장
					if(validateForm(sheetObj,formObj,sAction)){
						
						sheetObj.WaitImageVisible = false;
			        	ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						
						var sXml = sheetObj.DoSave("ESM_BKG_1130GS.do", FormQueryString(formObj));
						ComOpenWait(false);
						
						// 조회
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					break;
	           
				case IBINSERT:      // 입력

					//신규행 추가
	 				sheetObj.DataInsert(-1);
	
	 				sheetObj.CellEditable(sheetObj.SelectRow, "rgn_ofc_cd") = true;
	 				sheetObj.CellEditable(sheetObj.SelectRow, "cnt_cd") = true;
					sheetObj.CellEditable(sheetObj.SelectRow, "loc_cd") = true;

	 				// Log User ID를 Setting 한다.
	 				sheetObj.CellValue2(sheetObj.SelectRow, "upd_usr_id") = strUsr_id;
					break;
					
				case IBDELETE:      // 삭제
					//행 삭제 FLAG처리
					sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
					if(sheetObj.FindCheckedRow("del_chk")!= ""){
						ComRowHideDelete(sheetObj, "del_chk");
					}
					break;	
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
	            case IBSAVE: // 저장시 확인
	         		if (!ComChkValid(formObj)){
	         			 return false;
	         		}
	         		
	         	    var maxRow = sheetObj.LastRow;
	         	    var ibFlg = "";
	         	    
		     	    for(var i=1;i <= maxRow ; i++){

		     	    	ibFlg = sheetObj.CellValue(i, "ibflag");
		     	    	if(ibFlg == "I" || ibFlg == "U") {

			         		// 필수 입력 항목 체크
							if(sheetObj.CellValue(i, "rgn_ofc_cd") == ""){
								ComShowCodeMessage('BKG00104', 'RHQ');
								return false;
							}
							if(sheetObj.CellValue(i, "cnt_cd") == ""){
								ComShowCodeMessage('BKG00104', 'Dest Country');
								return false;
							}
							if(sheetObj.CellValue(i, "loc_cd") == ""){
								ComShowCodeMessage('BKG00104', 'Dest Location Code');
								return false;
							}
							if(sheetObj.CellValue(i, "eff_dt") == ""){
								ComShowCodeMessage('BKG00104', 'Effective date');
								return false;
							}
					
							// Dest Location Code가 해당 Dest.Country 인지 체크
							var locCd = sheetObj.CellValue(i, "loc_cd");
							var upperLocCd = (sheetObj.CellValue(i, "loc_cd")).toUpperCase();
		
							if(upperLocCd != "ALL"){
								if(sheetObj.CellValue(i, "cnt_cd") != locCd.substr(0,2)){
									ComShowCodeMessage('BKG08210',locCd);
									return false;
								}
							} else {
								sheetObj.CellValue2(i,"loc_cd") = upperLocCd;
							}

							// Effective date < Expired date인지 체크
							if(sheetObj.CellValue(i, "exp_dt") != ""){
								if(ComChkPeriod(sheetObj.CellValue(i, "eff_dt"), sheetObj.CellValue(i, "exp_dt")) < 1){
									ComShowCodeMessage('BKG08211');
									return false;
								}
							}
					
							// 변경된 Row에 대해서 아래의 Validation 체크를 함.
							// 1. Restricted, Prohibited 둘 중 하나는 필수 입력.
							// 2. Restricted, Prohibited 의 값이 중복되어 있는지 체크.
							formObj.f_cmd.value = SEARCH01;
		     	    
							// 1. Restricted, Prohibited 둘 중 하나는 필수 입력.
		     	    		if(sheetObj.CellValue(i, "rstr_cmdt_nm") == "" && sheetObj.CellValue(i, "prohi_cmdt_nm") == ""){
		     	    			ComShowCodeMessage('BKG08212');
		     	    			return false;
		     	    		}
			     	    	
		     	    		sheetObj.CellValue(i, "dup_chk_flg") = ibFlg;
		     	    		var sParam = sheetObj.GetSaveString(false, true, "dup_chk_flg") + "&" + FormQueryString(formObj);
		     	    		var sXml = sheetObj.GetSaveXml("ESM_BKG_1130GS.do", sParam);
		     	    		sheetObj.CellValue(i, "dup_chk_flg") = "";

		     	    		var dupFlg = ComGetEtcData(sXml, "dup_flg");
		     	    		var chkLocCd = ComGetEtcData(sXml, "chk_loc_cd");
		     	    		var chkCntCd = ComGetEtcData(sXml, "chk_cnt_cd");
		     	    		var chkCntKnt = ComGetEtcData(sXml, "chk_cnt_knt");
		     	    		var restricted = sheetObj.CellValue(i, "rstr_cmdt_nm");
		     	    		var prohibited = sheetObj.CellValue(i, "prohi_cmdt_nm");
		     	    		var commoDisp = "";
		     	    		
		     	    		if(restricted != "" && prohibited != ""){
		     	    			commoDisp = restricted + " OR " + prohibited;  
		     	    		} else if (restricted != "" && prohibited == ""){
		     	    			commoDisp = restricted;
		     	    		} else if (restricted == "" && prohibited != ""){
		     	    			commoDisp = prohibited;
		     	    		}
		     	    		
		     	    		// Location
		     	    		// Insert일 경우는 1건 이상 등록된 경우, Update일 경우는 2건 이상 등록된 경우가 에러.
		     	    		if ( (ibFlg == "I" && dupFlg >= 1) || (ibFlg == "U" && dupFlg >= 2 )) {
		     	    			if(!ComShowCodeConfirm("BKG08207", commoDisp)) {
		     	    				return false;
		     	    			}
		     	    			
		     	    		} else {
			     	    		// country
			     	    		// Insert일 경우는 1건 이상 등록된 경우, Update일 경우는 2건 이상 등록된 경우가 에러.
			     	    		if ( (ibFlg == "I" && chkCntKnt >= 1) || (ibFlg == "U" && chkCntKnt >= 2)) {
			     	    			if(!ComShowCodeConfirm("BKG08215", commoDisp,chkCntCd)) {
			     	    				return false;
			     	    			}
			     	    		}

		     	    		}
		     	    	}
		     	    }
	         	break;
            }
            return true;
        }
        
    	/**
         * 조회 완료 후 실행
         * saved_flg(DB에 저장된 값인지 여부)를 Y로 설정한다.
         * @param sheetObj
         * @param ErrMsg
         */
     	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

     	    var maxRow = sheetObj.LastRow;
     	    var cellValue = "";
     	    for(i=1;i <= maxRow ; i++){
     	    	
     	    	// 결과가 있는 행에 대해서만 수정.
     	    	if(sheetObj.CellValue(i, "rgn_ofc_cd") != ""){
	     			sheetObj.CellValue( i, "saved_flg") = "Y";
	
	    			// Sheet 내용을 임의로 변경했으므로 Read Type으로 수정한다.
	    			sheetObj.CellValue( i, "ibflag") = "R";
     	    	}
     	    }
     	    
     	    sheetObj.ColFontUnderline("file_upld_nm") = true;
     	    sheetObj.DataLinkMouse("file_upld_nm") = true;
     	    
     	}
     	
      	/**
      	 * Form Object가 Active될때 발생하는 이벤트를 처리한다.
      	 * @return
      	 */
      	function obj_activate(){
      	    var objName = event.srcElement.name;
      	    var formObj = document.form;
      	    switch(objName) {
      	        case "eff_dt":
      	            formObj.eff_dt.value = formObj.eff_dt.value.replace(eval("/-/gi"), "");
      	            break;
      	    }
      	}
      	
      	/**
      	  * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
      	  * @return
      	  */
      	function obj_deactivate(){
      	    var objName = event.srcElement.name;
      	    var formObj = document.form;
      	    switch(objName) {
      	        case "eff_dt":
      	            ComChkObjValid(event.srcElement);
      	            break;
      	    }
      	}
      	
      	/**
      	 * 화면 개체가 변경되었을 때의 이벤트 처리
      	 * @return
      	 */
      	function obj_keyup() {
      	    var objName = event.srcElement.name;
      	    var formObj = document.form;

      	    // 변경이 일어나면 변경 flag를 true로 변경한다.(여기는 queryStrChange를 위한 if문처럼 사용한다. 다른 이벤트를 처리하기 위해서는 별도 switch문을 사용할 것)
      	    switch(objName) {
      	        case "eff_dt":
      	            queryStrChange = true;
      	            break;djw
      	    }
      	}
      	
        /**
         * 입력한 Country Code가 해당 RHQ 인지를 체크한다. <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {ibsheet} Row     	sheetObj의 선택된 Row
         * @param {ibsheet} Col     	sheetObj의 선택된 Col
         **/
        function sheet1_OnChange(sheetObj, Row, Col) {

        	var colName = sheetObj.ColSaveName(Col);
        	var formObj = document.form;
       	 
        	if (colName == "rgn_ofc_cd") {
        		sheetObj.CellValue2(Row, "cnt_cd") = "";
        	
        	} else if (colName == "cnt_cd") {
        	
	     	    formObj.f_cmd.value = SEARCH02;
        		
 	    		var sParam = sheetObj.GetSaveString() + "&" + FormQueryString(formObj);
 	    		var sXml = sheetObj.GetSaveXml("ESM_BKG_1130GS.do", sParam);
 	    		var existFlg = ComGetEtcData(sXml, "exist_loc_flg");
 	    		if(existFlg == "N"){
 	    			ComShowCodeMessage('BKG08213', sheetObj.CellValue(Row, "cnt_cd"), sheetObj.CellValue(Row, "rgn_ofc_cd"));
 	    		}
        	}	     	    
        }
        
         /**
          * 파일 다운받기 <br>
          * @param {ibsheet} sheetObj    IBSheet Object
          * @param {ibsheet} Row     	sheetObj의 선택된 Row
          * @param {ibsheet} Col     	sheetObj의 선택된 Col
          * @param {String} 	Value     	파일명
          **/
         function sheet1_OnClick(sheetObj, Row, Col, Value) {

        	var colName = sheetObj.ColSaveName(Col);
        	 
         	if (colName == "file_upld_nm") {
         	
         		// 파일이 존재시 다운로드 받는다.
         		var key_id = sheetObj.CellValue(Row, "file_sav_id");
         		
         		if(key_id != ""){
	         		var exist = fnSaveFileExist(key_id , sheetObj);
	         		// 서버에 파일존재유무확인 
	         		if(eval(exist)){
	         			hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	         		}else{
	         			ComShowMessage(ComGetMsg("BKG08127"));
	         		}
         		}
         		
         	} else if( colName == "inter_rmk"){
                sheetObj.CellEditable(Row, colName) = false;
                ComShowMemoPad(sheetObj, Row, colName, false, 240, 100, 5000);
            }
         }
         
         /**
          * 파일존재유무판단  
          * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
          * param :file_id
          * return :boolean
          */
         function fnSaveFileExist(file_id,sheetObj) {
         	var formObj = document.form;
         	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
         	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
         	var output_text = ComGetEtcData(sXml, "output_text");
         	return output_text;
         }
         
	/* 개발자 작업  끝 */