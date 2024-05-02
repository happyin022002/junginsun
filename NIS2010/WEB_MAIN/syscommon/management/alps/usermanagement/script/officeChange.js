var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

            	case "btn_Copy":
            		ComOpenWindowCenter('ADM_SYS_0010.do?MENU=Y', '', 640, 460);
            		break;

        	    case "btn_DownExcel":
            		doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            		break;
                case "btn_select":
    	            officeChange(sheetObject, formObject);
        	        break;
        	     case "btng_delete":
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;
        	     
        	     case "btn_Close":
     	            self.close();
         	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function officeChange(sheetObject, formObject) {
    	var usr_id = "";
    	var cng_ofc_cd = "";
    	var default_lgin_ofc="";
    	
    	var selRow = sheetObject.SelectRow;
    	
    	
        if(selRow == 0) {
        	ComShowCodeMessage("COM12176");
            return;
        }

        if(confirm("Default login office has been set.\n"+
	 			"To change login office, go to ALPS main page and \n" + 
	 			"click a office code from a drop-down list box."))
	 	{
	        for(var i=1; i<sheetObject.rowCount+1; i++) {
	    		if(sheetObject.CellValue(i, "default_lgin_ofc") == "1") {
	    			default_lgin_ofc = sheetObject.CellValue(i, "cng_ofc_cd");
	   			}
	   		}
	        /*if(default_lgin_ofc == 0)
	        {
	        	ComShowCodeMessage("COM12176");
	              return;
	        }*/
	        //alert(default_lgin_ofc);
	        
	        cng_ofc_cd = sheetObject.CellValue(selRow, "cng_ofc_cd");
	        usr_id = sheetObject.CellValue(selRow, "usr_id");
	       
	        
	        if(cng_ofc_cd == "" && usr_id == "") {
	        	ComShowCodeMessage("COM12113", "Row");
	        	return;        	
	        }
	        
	        if(sheetObject.CellValue(selRow, "expire") == "Y") {
	        	ComShowMessage("The selected Office is expired");
	        	return;
	        }
        
 	        formObject.f_cmd.value = MODIFY;
	        formObject.action = "UserManagementOfcCng.do";
	        formObject.cng_ofc_flg.value = "Y";
	        formObject.cng_ofc_cd.value = cng_ofc_cd;
	        formObject.default_ofc_cd.value = default_lgin_ofc;
	        formObject.submit();
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
    	if(document.form.admin_page.value != "Y") {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		sheet1_OnSearchEnd(sheetObjects[0]);
    	}
    }
     
     function initControl() {
    	 var formObject = document.form;
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
	    var admin_page = document.form.admin_page.value;
	   //admin_page="Y";
        switch(sheetNo) {
             case 1:      //IBSheet1 init

                with (sheetObj) {

                    // 높이 설정
                    style.height = 400 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);
                   //alert(admin_page);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    if(admin_page == 'Y')//어드민 권한이 있을 경우 삭제가능
                    {
                    	InitColumnInfo(16, 0, 0, true);
                    }else{
                    	InitColumnInfo(16, 0, 0, true);
					}
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;
					
					if(admin_page == 'Y')//어드민 권한이 있을 경우 삭제가능
                    {
                    	 var HeadTitle = "Del|STS|User ID|User Name|User Local Name|Office Code|Office Code2|RHQ|FM Date |To Date|Remarks|Create User ID|Create Date|Modi. User ID|Modi. Date|" ;
                    }else{
                    	 var HeadTitle = "STS|Default Login Office|User ID|User Name|User Local Name|Office Code|Office Code2|RHQ|FM Date |To Date|Remarks|Create User ID|Create Date|Modi. User ID|Modi. Date|" ;
					}
					
                    //var HeadTitle = "Del|STS|User ID|User Name|User Local Name|Office Code|Office Code2|FM Date |To Date|Remarks|Create User ID|Create Date|Modi. User ID|Modi. Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if(admin_page == 'Y')//어드민 권한이 있을 경우 삭제가능
                    {
                    	//if(sheetObj.CellValue(Row, "cng_ofc_to_dt") < get_NowDate()) {
                    		
                    		//InitDataProperty(0, cnt++ , dtDelCheck,         40,  daCenter,  false,    false);
                    	
                    	//}
                    	//else
                    	//{
                    		InitDataProperty(0, cnt++ , dtDelCheck,         40,  daCenter,  false,    "");
                    		InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
                    	//}
                    }
                    else
                    {
                    	InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
                    	InitDataProperty(0, cnt++ , dtRadioCheck,   120,  daCenter,    false,   "default_lgin_ofc", false);
                    	//InitDataProperty(0, cnt++ , dtDelCheck,         80,  daCenter,  false,    "");
                    }                    
                   
                    InitDataProperty(0, cnt++ , dtData,         70,    daLeft,    false,   "usr_id",           true,        "",     dfNone,           0,    false,       true);
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,    false,   "usr_nm",           false,        "",     dfNone,           0,    false,        false);
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,    false,   "usr_locl_nm",      false,        "",     dfNone,           0,    false,        false);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,    false,   "ofc_cd",           false,        "",     dfNone,           0,    false,        false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,       100,    daLeft,    false,   "cng_ofc_cd",           true,        "",     dfNone,           0,    false,        true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,    false,   "rhq",           false,        "",     dfNone,           0,    false,        false);
                    if(admin_page == 'Y')//어드민 권한이 있을 경우 삭제가능
                    {
                		InitDataProperty(0, cnt++ , dtPopup,         80,    daCenter,  false,   "cng_ofc_fm_dt",          false,       "",     dfDateYmd,           0,    true,        true);
                		InitDataProperty(0, cnt++ , dtPopupEdit,         80,    daCenter,  false,   "cng_ofc_to_dt",       false,       "",     dfDateYmd,           0,    true,        true);
                		InitDataProperty(0, cnt++ , dtData,       150,    daLeft,    false,   "rqst_ctnt",      false,       "",     dfNone,          	0,    true,        true);
                	}
                	else
                	{
                		InitDataProperty(0, cnt++ , dtPopup,         80,    daCenter,  false,   "cng_ofc_fm_dt",          false,       "",     dfDateYmd,           0,    false,        true);
                		InitDataProperty(0, cnt++ , dtPopupEdit,         80,    daCenter,  false,   "cng_ofc_to_dt",       false,       "",     dfDateYmd,           0,    false,        true);
                		InitDataProperty(0, cnt++ , dtData,       150,    daLeft,    false,   "rqst_ctnt",      false,       "",     dfNone,          	0,    false,        true);
                	}
                	
                    //InitDataProperty(0, cnt++ , dtPopupEdit,         80,    daCenter,  false,   "cng_ofc_to_dt",       false,       "",     dfDateYmd,           0,    true,        true);
                	
                	
                    //InitDataProperty(0, cnt++ , dtData,       150,    daLeft,    false,   "rqst_ctnt",      false,       "",     dfNone,          	0,    true,        true);
                   
                    InitDataProperty(0, cnt++ , dtHidden,         90,    daCenter,  false,   "cre_usr_id",       false,       "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,         90,    daCenter,  false,   "cre_dt",           false,       "",     dfDateYmd,        0,    false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,         90,    daCenter,  false,   "upd_usr_id",       false,       "",     dfNone,           0,    false,        false);
                    InitDataProperty(0, cnt++ , dtHidden,         90,    daCenter,  false,   "upd_dt",           false,       "",     dfDateYmd,        0,    false,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,         90,    daCenter,  false,   "expire",           false,       "",     dfNone,        0,    false,       false);
                    
                  
                    InitDataValid(0, SaveNameCol("cng_ofc_cd"), vtEngUpOther, "1234567890");
                    //ImageList(0) = "/hanjin/img/enis/button/btns_calendar.gif";
                    //ImageList(1) = "/hanjin/img/enis/button/btns_search.gif";
                    //PopupButtonImage(0,"roles") = 1;
                    //sheetObj.InitUserFormat2(0, "frDate", "####-##-##", "-|:" );
                    //sheetObj.InitUserFormat2(0, "toDate", "####-##-##", "-|:" );
               }                                                      
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		switch(sAction) {

           case IBSEARCH:      //조회
           		if(validateForm(sheetObj,formObj,sAction)) {
                	formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("searchUserManagementOfcCng.do", FormQueryString(formObj));
                }
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("searchUserManagementOfcCng.do", FormQueryString(formObj));
              }
                break;

           case IBINSERT:      // 입력
        	   for (var i=0;i<formObj.addrows.value;i++) sheetObj.DataInsert();
                break;
         
           
        	case IBDELETE:                
   			     if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("searchUserManagementOfcCng.do", FormQueryString(formObj));
              }
                break;			
                 
           case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(1);
                break;
        }
    }
    
    function sheet1_OnPopupClick(sheetObj,Row,Col){
        switch (sheetObj.ColSaveName(Col)) {
            case "roles" :
                 if(sheetObj.CellValue(Row,"ibflag")=="I"){
                   showErrMessage(getMsg('COM12151','user'));
                 }else{
                   noRtnPopup('roleMapping.do?usr_id='+sheetObj.CellValue(Row,"usr_id")+"&usr_nm="+escape(sheetObj.CellValue(Row,"usr_nm")),'width=700,height=474,left=200,top=100,menubar=0,status=0,scrollbars=0,resizable=1');
                 }
                 break;
            case "ofc_cd" :
            	ComOpenPopup('/hanjin/viewOrg.do', 700, 474, 'setOfcCd', '0,1', false, false, Row, Col, 0);
                 break;
            case "cng_ofc_cd" :
            	 ComOpenPopup('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 474, 'setPrntUsrRoleCd', '0,0,1,1,1,1,1,1', false, false, Row, Col, 0);
                 break;
           case "cng_ofc_fm_dt" :
        	   if (sheetObj.ColSaveName(Col) != "cng_ofc_fm_dt") return;
        	   var cal = new ComCalendarGrid("myCal");
        	   cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
        	   break;
		   case "cng_ofc_to_dt" :
			   if (sheetObj.ColSaveName(Col) != "cng_ofc_to_dt") return;
               var cal = new ComCalendarGrid("myCal");
               cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
               break;
        }
    }
    
    function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
		var sheetObject = sheetObjects[0];
		sheetObject.CellValue(row,col)= aryPopupData[0][3];
	}
    
    function sheet1_OnSearchEnd(sheetObj){
    	var admin_page = document.form.admin_page.value;
    	if(admin_page == "Y") {	// 관리자 화면
    		for(var i=1; i<sheetObj.rowCount+1; i++) {
	    		if(sheetObj.CellValue(i, "expire") == "Y") {
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(192,192,192);	   				
	   			}
	   		}
    	} else {	// 사용자 화면	
    		// Sheet 의 Selection 모드를 Row 단위로 변경
    		sheetObj.SelectionMode = smSelectionRow; 
    		
	    	var login_ofc_cd = document.form.login_ofc_cd.value;

	    	for(var i=1; i<sheetObj.rowCount+1; i++) {
	    		if(sheetObj.CellValue(i, "expire") == "Y") {
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(192,192,192);
	   			}
	    		if(sheetObj.CellValue(i, "cng_ofc_cd") == login_ofc_cd) {
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,255);
	   			}
	   		}
    	}
    }
   
    function sheet1_OnChange(sheetObj,Row,Col) {
    	var dept_id = "";
    	var usr_id = "";
    	var formObject = document.form;

    	if(Col == 2) {
    		usr_id = sheetObj.CellValue(Row, 2);
    		if ( usr_id == "") return;
    		formObject.f_cmd.value = SEARCH01;
    		var sXml = sheetObj.GetSearchXml("searchUserManagementOfcCng.do?usr_id="+usr_id+"&row="+Row, FormQueryString(formObject));
    		if(ComGetEtcData(sXml,"total") != "0"){
    			sheetObj.CellValue(Row, "usr_nm") = ComGetEtcData(sXml,"usr_nm");
    			sheetObj.CellValue(Row, "usr_locl_nm") = ComGetEtcData(sXml,"usr_locl_nm");
    			sheetObj.CellValue(Row, "ofc_cd") = ComGetEtcData(sXml,"ofc_cd");
    			sheetObj.CellValue(Row, "cng_ofc_cd") = ComGetEtcData(sXml,"cng_ofc_cd");
    			sheetObj.CellValue(Row, "rhq") = ComGetEtcData(sXml,"rhq");
    			sheetObj.CellValue(Row, "cng_ofc_fm_dt") = ComGetEtcData(sXml,"cng_ofc_fm_dt");
    		}
    	}    	
    	
    	if(Col == 6) {
    		usr_id = sheetObj.CellValue(Row, 2);
    		dept_id = sheetObj.CellValue(Row, Col);
    		
    		for(var i=1; i<sheetObj.rowCount+1; i++) {
    			if((sheetObj.CellValue(i, 2) == usr_id && sheetObj.CellValue(i, Col) == dept_id )&& i != Row) {
    			
    				alert("office code2["+sheetObj.CellValue(Row, Col)+"] is duplicated.");
    				sheetObj.CellValue2(Row, Col) = "";
    				break;
    			} 
    		}    		
    		
    		formObject.f_cmd.value = SEARCH02;
    		var sXml = sheetObj.GetSearchXml("searchUserManagementOfcCng.do?usr_id="+usr_id+"&cng_ofc_cd="+dept_id+"&row="+Row, FormQueryString(formObject));
    		if(ComGetEtcData(sXml,"total") != "0"){
    			sheetObj.CellValue(Row, "rhq") = ComGetEtcData(sXml,"rhq");
    		}
    	}
		
		// 변경일이 현재일 이전이면 회색 폰트로 변경
//    	if(sheetObj.CellValue(Row, "cng_ofc_to_dt") < get_NowDate()) {
//    		sheetObj.RowFontColor(Row) = sheetObj.RgbColor(192,192,192);
//    	} else {
//    		sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0,0,0);
//    	}
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
