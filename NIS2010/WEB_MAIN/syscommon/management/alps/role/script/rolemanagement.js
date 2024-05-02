/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_007.js
*@FileTitle : 역할관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
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

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_Save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

            	case "btn_Copy":
            		ComOpenWindowCenter('ADM_SYS_0010.do?MENU=Y', '', 640, 460);
            		break;

        	    case "btn_Add":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

              case "btn_DownExcel":
                  doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    
    function initControl() {
       	var formObject = document.form;
           //Axon 이벤트 처리1. 이벤트catch(개발자변경)
           axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
           axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
       }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //IBSheet1 init

                with (sheetObj) {

                    // 높이 설정
                    style.height = 380 ;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;

                    var HeadTitle = "Del|STS|Level|Role Cd|Role Name|Role Description|Upper Role Cd|Last Updated|Update Id|Updated By|User Assign|Prog Assign|Reg Date|adm_yn" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
                    var prefix = "sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,      50,   daCenter,  false,   prefix + "delcheck");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,  false,   prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,  false,   prefix + "level",             false,        "",     dfNone,       0,        false,      false);
                    InitDataProperty(0, cnt++ , dtData,          70,   daCenter,  false,   prefix + "usr_role_cd",       true,         "",     dfNone,       0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,         120,   daLeft,    false,   prefix + "usr_role_nm",       true,         "",     dfNone,	     0,        true,       true);
                    InitDataProperty(0, cnt++ , dtData,         300,   daLeft,    false,   prefix + "usr_role_desc",     false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtPopup,         90,   daCenter,  false,   prefix + "prnt_usr_role_cd",  false,        "",     dfNone,       0,        true,       true);
                    
                    //InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  false,   prefix + "ofc_cd",  false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtData,         90,   daLeft,  false,   prefix + "upd_dt",  false,        "",     dfNone,       0,        false,       true);
                    InitDataProperty(0, cnt++ , dtData,         90,   daLeft,  false,   prefix + "upd_id",  false,        "",     dfNone,       0,        false,       true);
                    InitDataProperty(0, cnt++ , dtData,         90,   daLeft,  false,   prefix + "usr_nm",  false,        "",     dfNone,       0,        false,       true);
                    
                    InitDataProperty(0, cnt++ , dtPopup,         90,   daCenter,  false,   prefix + "user_assign",       false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtPopup,         90,   daCenter,  false,   prefix + "prog_assign",       false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,  false,   prefix + "cre_dt",            false,        "",     dfDateYmd,    0,        false,      false);
                    InitDataProperty(0, cnt++ , dtData,        80,   daCenter,  false,    prefix + "adm_yn",            false,        "",     dfNone,    0,        false,      false);
                    
                    ImageList(0) = "/hanjin/img/alps/button/btns_search.gif";
                    PopupButtonImage(0,prefix + "prnt_usr_role_cd") = 0;
                    PopupButtonImage(0,prefix + "user_assign") = 0;
                    PopupButtonImage(0,prefix + "prog_assign") = 0;
                    InitTreeInfo(2, prefix + "level");
               }                                                      
                                                          
               break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))
                    //sheetObj.DoSearch("UI_COM_SYS_007_DATA.html");
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("searchRole.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
               //sheetObj.DoSearch4Post("com.hanjin.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001ActionENIS.do", FormQueryString(formObj));
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("searchRole.do", FormQueryString(formObj),"ibflag",false);
              }
                break;
           case IBINSERT:      // 입력
                sheetObj.DataInsert(-1,1);
                break;
           case IBDOWNEXCEL:  //엑셀내려받기
                //[Mode,UseOpenFile,NewSheet,Merge,SaveAsName,ReportPageUrl,HideExcelMsg,WriteTreeLevel,WorkSheetName,FocusFirstSheet]
                //sheetObj.Down2Excel(1,false,false,true,'','',false,false,'',false);
                sheetObj.SpeedDown2Excel(1);
                break;
        }
    }

    
    function sheet1_OnChange(sheetObj,Row,Col){
   	 if(Col == 3){
   		 var code = sheetObj.CellValue(Row, Col).trim();
   		 for(var int = 1; int < sheetObj.RowCount; int++) {
   			 var orlcode = sheetObj.CellValue(int, Col);
   			 if(code == orlcode){
   				 ComShowMessage("Role Code \"" + code + "\" you are about to add\nalready exists. Please input another code.");
   				 sheetObj.CellValue(Row, Col) = "";
   				 return;
   			 }
   		 }
   	 }
    }
   
    
    function sheet1_OnPopupClick(sheetObj,Row,Col){
    			var prefix = "sheet1_";
    			
        switch (sheetObj.ColSaveName(Col)) {
        case prefix + "prnt_usr_role_cd" :
        			ComOpenPopup('/hanjin/viewUpperRole.do', 700, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
             break;
        case prefix + "user_assign" :
        	 if( checkAleadySaveRow(sheetObj,Row,Col )){
            	 ComOpenPopup('/hanjin/userMapping.do?role_cd='+sheetObj.CellValue(Row,prefix + "usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,prefix + "usr_role_nm")), 800, 574, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
            	 doActionIBSheet(sheetObj,document.form,IBSEARCH);
             }
             break;
        case prefix + "prog_assign" :
        	if( checkAleadySaveRow(sheetObj,Row,Col )){
        		ComOpenPopup('/hanjin/programMapping.do?role_cd='+sheetObj.CellValue(Row,prefix + "usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,prefix + "usr_role_nm")), 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
            	doActionIBSheet(sheetObj,document.form,IBSEARCH);
             }
             break;
        }
    }
   function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
			var sheetObject = sheetObjects[0];
			sheetObject.CellValue(row,col)= aryPopupData[0][3];
		}

//   function sheet1_OnSearchEnd(sheetObj) {
//   	for(var i=1; i<sheetObj.rowCount+1; i++) {
//   		if(sheetObj.CellValue(i, "sheet1_adm_yn") == "N") {
//   			sheetObj.CellEditable(i, "sheet1_user_assign") = false;
//   			sheetObj.CellEditable(i, "sheet1_prog_assign") = false;    			
//  		} else {
//  			sheetObj.CellEditable(i, "sheet1_user_assign") = true;
//   			sheetObj.CellEditable(i, "sheet1_prog_assign") = true;
//  		}
//  	}
//  }
   
//    function setPrntUsrRoleCd
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

    
    /**
     * Role이 저장되기 전에는 사용자와 프로그램 부여 불가 
     * 2011.01.06 류현수 
    */
    function checkAleadySaveRow(sheetObj,Row,Col){
    	var updateable = false;
			
    	 if(sheetObj.CellValue(Row,"sheet1_ibflag")=="I"){
    		 ComShowCodeMessage('COM131604', 'this assignment setting at this time.  Please set this assignment after saving this role and getting a permission from a ALPS almighty user(SELXWP/ Yang-Sun Yang, Inkuk Choi).');
    		 updateable = false;	
    	 }else if(sheetObj.CellValue(Row, "sheet1_adm_yn") == "N"){
    		 ComShowCodeMessage('COM12157' , 
				 'Please set this assignment after getting a permission from a ALPS almighty user(SELXWP/ Yang-Sun Yang, Inkuk Choi).'
    		 );    		 
    		 updateable = false;
    	 }else{
    		 updateable = true;
    	 }
    	return updateable;
    }
    
    
    
    
    
    