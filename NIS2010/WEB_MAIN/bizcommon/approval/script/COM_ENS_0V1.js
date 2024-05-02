/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_0V1.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.11.10 정인선
* 1.0 최초 생성
* History
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
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
     * @class Error Message Management : Error Message Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function errormessagemanagement() {
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
	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_Search":
            		if(beforetab == 0){
            			if ( document.getElementById("search_text").value == "" ) return;	
                		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
        	    	}else if(beforetab ==1){
        	    		if ( document.getElementById("search_text_auth").value == "" ) return;	
                		findXML(document.getElementById("search_auth").value, document.getElementById("search_text_auth").value);
        	    	}
            		break;
            		
            	case "btn_retrieve":   
            		if(beforetab == 0){
            			if(formObject.sub_sys_cd.value == "") {
            	        	ComShowCodeMessage("COM12113", "Module");
            	        	formObject.sub_sys_cd.focus();
            	        	return;
            	        }
                		doActionIBSheet(sheetObject2,formObject,IBSEARCH);
        	    	}else if(beforetab ==1){
        	    		var subSysCdAuth = formObject.sub_sys_cd_auth.value;
        	    		var pgmNo = formObject.pgm_no.value;
        	    		
        	    		if(formObject.ofc_cd_auth.value == "") {
            	        	ComShowCodeMessage("COM12113", "Office");
            	        	formObject.ofc_cd_auth.focus();
            	        	return;
            	        }else if( subSysCdAuth == "" || subSysCdAuth == null || subSysCdAuth == "undefined") {
            	        	ComShowCodeMessage("COM12113", "Module");
            	        	formObject.sub_sys_cd_auth.focus();
            	        	return;
            	        }else if(pgmNo == "" || pgmNo == null || pgmNo == "undefined") {
            	        	ComShowCodeMessage("COM12113", "Menu");
            	        	formObject.pgm_no.focus();
            	        	return;
            	        }else if(formObject.auth_apro_tp_cd.value == "") {
            	        	ComShowCodeMessage("COM12113", "Type");
            	        	formObject.auth_apro_tp_cd.focus();
            	        	return;
            	        }
        	    		doActionIBSheet2(sheetObject4,formObject,IBSEARCH);
        	    	}
            		
                    break;
                    
            	case "btn_save":
        	        if(beforetab == 0){
        	        	if(formObject.sub_sys_cd.value == "") {
            	        	ComShowCodeMessage("COM12113", "Module");
            	        	formObject.sub_sys_cd.focus();
            	        	return;
            	        }
            	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
        	    	}else if(beforetab ==1){
        	    		var subSysCdAuth = formObject.sub_sys_cd_auth.value;
        	    		var pgmNo = formObject.pgm_no.value;
        	    		
        	    		if(formObject.ofc_cd_auth.value == "") {
            	        	ComShowCodeMessage("COM12113", "Office");
            	        	formObject.ofc_cd_auth.focus();
            	        	return;
            	        }else if( subSysCdAuth == "" || subSysCdAuth == null || subSysCdAuth == "undefined") {
            	        	ComShowCodeMessage("COM12113", "Module");
            	        	formObject.sub_sys_cd_auth.focus();
            	        	return;
            	        }else if(pgmNo == "" || pgmNo == null || pgmNo == "undefined") {
            	        	ComShowCodeMessage("COM12113", "Menu");
            	        	formObject.pgm_no.focus();
            	        	return;
            	        }else if(formObject.auth_apro_tp_cd.value == "") {
            	        	ComShowCodeMessage("COM12113", "Type");
            	        	formObject.auth_apro_tp_cd.focus();
            	        	return;
            	        }
        	    		
        	    		doActionIBSheet2(sheetObject4, formObject, IBSAVE);
        	    		doActionIBSheet2(sheetObject4,formObject,IBSEARCH);
        	    	}
        	        break;
        	       
            	case "btns_add":
                    if(beforetab == 0){
                    	var selrow = sheetObjects[0].SelectRow;
                        if ( selrow > 0 ){
                        	sheet1_OnDblClick("", "", "", "");
                		}
        	    	}else if(beforetab ==1){
        	    		var selrow = sheetObjects[2].SelectRow;
                        if ( selrow > 0 ){
                        	sheet3_OnDblClick("", "", "", "");
                		}
        	    	}
            		break;

         	    case "btns_del":
                    if(beforetab == 0){
                    	var selrow = sheetObjects[1].SelectRow;
                        if ( selrow > 0 ){
                        	sheet2_OnDblClick("", "", "", "");
                		}  
        	    	}else if(beforetab ==1){
        	    		var selrow = sheetObjects[3].SelectRow;
                        if ( selrow > 0 ){
                        	sheet4_OnDblClick("", "", "", "");
                		}
        	    	}
         	    	break;
         	    	
         	   case "btns_up":
                   if(beforetab == 0){
                	   changeUpApproval(sheetObjects[1]);  
       	    	}else if(beforetab ==1){
       	    		changeUpApproval(sheetObjects[3]); 
       	    	}
        	    	break;
        	    	
         	  case "btns_down":
	         		 if(beforetab == 0){
	              	   changeDownApproval(sheetObjects[1]); 
	     	    	}else if(beforetab ==1){
	     	    		changeDownApproval(sheetObjects[3]); 
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
     * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
     * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
     * @param {ibsheet} sheet_obj    IBSheet Object
     **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	
    	 // IBTab 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		
		//IBMultiCombo 초기화
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		
    	
    }

    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "Name|Dept|Title|" ;
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     120,   	daLeft,  	false,    	"NAME",        	false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     80,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,   0,    	daCenter,  	false,    	"CN",       	false,          "",       dfNone,     0,     false,       false);
                    
                    CountPosition = 0;
                }
                break;
                
            case "sheet2":     //IBSheet2 init
            	with (sheetObj) {
	                //전체 너비 설정
	                style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|No|Name|Dept|Title|" ;
	               
	                var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
	                //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    	daCenter,  	true,    	"ibflag",           	false,        "",       dfNone,   		0,     false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	30,    	daCenter,  	false, 		"apro_seq",    			false,          "",       dfNone,   	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	130,    daLeft,  	false,   	"apro_usr_nm",      	false,          "",       dfNone,     	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	130,    daCenter,  	false,    	"apro_ofc_cd",      	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	85,    	daLeft,    	false,    	"apro_usr_jb_tit_nm",   false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,     	0,    	daLeft,    	false,    	"apro_usr_id",      	false,          "",       dfNone,     0,     false,       false);
	                
	                CountPosition = 0
	                CellBackColor(0,"name") = RgbColor(222,251,248);
	                CellBackColor(0,"mail") = CellBackColor(0,"name")  ;

	           }
            break;
            
            case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "Name|Dept|Title|" ;
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     120,   	daLeft,  	false,    	"NAME",        	false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     80,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,   0,    	daCenter,  	false,    	"CN",       	false,          "",       dfNone,     0,     false,       false);
                    
                    CountPosition = 0;
                }
                break;
                
            case "sheet4":     //IBSheet4 init
            	with (sheetObj) {
	                //전체 너비 설정
	                style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|No|Name|Dept|Title|" ;
	               
	                var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
	                //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    	daCenter,  	true,    	"ibflag",           	false,        "",       dfNone,   		0,     false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	30,    	daCenter,  	false, 		"auth_apro_rout_usr_seq",    			false,          "",       dfNone,   	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	130,    daLeft,  	false,   	"auth_apro_usr_nm",      	false,          "",       dfNone,     	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	130,    daCenter,  	false,    	"auth_apro_ofc_cd",      	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	85,    	daLeft,    	false,    	"auth_apro_usr_jb_tit_nm",   false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,     	0,    	daLeft,    	false,    	"auth_apro_usr_id",      	false,          "",       dfNone,     0,     false,       false);
	                
	                CountPosition = 0
	                CellBackColor(0,"name") = RgbColor(222,251,248);
	                CellBackColor(0,"mail") = CellBackColor(0,"name")  ;

	           }
            break;

        }
    }

     /* Sheet관련 프로세스 처리 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
            case IBSAVE:        //저장
	            // 모두 재입력을 원칙으로 함
	            for(var i=0; i<sheetObj.RowCount; i++) {
	                sheetObj.CellValue2(i + 1, "ibflag") = "I";
	            }
            
               formObj.f_cmd.value = MULTI; 
               var SaveStr = sheetObj.GetSaveString();
               var sXml = sheetObj.GetSaveXml("COM_ENS_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));
               sheetObj.LoadSaveXml(sXml);
            break;
            
            case IBSEARCH:      //조회
            	formObj.f_cmd.value = SEARCH03;
            	sheetObj.DoSearch("COM_ENS_0V1GS2.do", FormQueryString(formObj));
            break;
         }
     }
     
     /* Sheet관련 프로세스 처리 */
     function doActionIBSheet2(sheetObj,formObj,sAction) {
         switch(sAction) {
            case IBSAVE:        //저장
	            // 모두 재입력을 원칙으로 함
	            for(var i=0; i<sheetObj.RowCount; i++) {
	                sheetObj.CellValue2(i + 1, "ibflag") = "I";
	            }
            
               formObj.f_cmd.value = COMMAND01; 
               var SaveStr = sheetObj.GetSaveString();
               var sXml = sheetObj.GetSaveXml("COM_ENS_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));
               sheetObj.LoadSaveXml(sXml);
            break;
            
            case IBSEARCH:      //조회
            	formObj.f_cmd.value = COMMAND02;
            	sheetObj.DoSearch("COM_ENS_0V1GS2.do", FormQueryString(formObj));
            break;
         }
     }
     
     // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadData(data) {
    	var sheetObject = null;
    	
    	if(beforetab == 0){
    		sheetObject=sheetObjects[0];
    	}else if(beforetab == 1){
    		sheetObject=sheetObjects[2];
    	}
    	
    	
    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4);
    		sheetXml += "]]></TR>";
    	}
    	sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
     }
    
 // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadDataAuth(data) {
    	var sheetObject3 = sheetObjects[2];
    	
    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4);
    		sheetXml += "]]></TR>";
    	}
    	sheetObject3.LoadSearchXml(sheetXml+"</DATA></SHEET>");
     }
//    
    
     
    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
  
        var selrow = sheetObject1.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject1.CellValue(selrow, "CN");
            var usr_nm = sheetObject1.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject1.CellValue(selrow, "TEAMNM");
            var title = sheetObject1.CellValue(selrow, "BUJAE");
            
            // ALPS 계정 유무 확인 2018.01.16
            formObject.f_cmd.value = SEARCH06;
    		var sXml = sheetObject1.GetSearchXml("COM_ENS_0V1GS2.do?usr_id="+usr_id, FormQueryString(formObject));

    		if(ComGetEtcData(sXml,"ep_id") == ""){
    			ComShowMessage("No ALPS user!");
    			return;
    		}

            // Duplication(중복) 체크
            for(var i=0; i<sheetObject2.RowCount; i++) {
                if(sheetObject2.CellValue(i + 1, "apro_usr_id") == usr_id) {
                    ComShowMessage(usr_id + " is already added");
                    return;
                }
            }
            
            // 대상 Sheet로 데이타 이행
            row = sheetObject2.DataInsert(0);
			sheetObject2.CellValue2(row, "apro_usr_nm") =  usr_nm;
			sheetObject2.CellValue2(row, "apro_ofc_cd") =  ofc_cd;            			
			sheetObject2.CellValue2(row, "apro_usr_jb_tit_nm")  =  title; 
			sheetObject2.CellValue2(row, "apro_usr_id") =  usr_id;
			
            // APPROVAL SEQ 재정렬
            var rowCount = sheetObject2.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject2.CellValue2(i + 1, "apro_seq") = rowCount - i;
            }
        }   
    }
    
    function sheet3_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        var selrow = sheetObject3.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject3.CellValue(selrow, "CN");
            var usr_nm = sheetObject3.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject3.CellValue(selrow, "TEAMNM");
            var title = sheetObject3.CellValue(selrow, "BUJAE");
            
            // Duplication(중복) 체크
            for(var i=0; i<sheetObject4.RowCount; i++) {
                if(sheetObject4.CellValue(i + 1, "auth_apro_usr_id") == usr_id) {
                    ComShowMessage(usr_id + " is already added");
                    return;
                }
            }
            
            // 대상 Sheet로 데이타 이행
            row = sheetObject4.DataInsert(0);
			sheetObject4.CellValue2(row, "auth_apro_usr_nm") =  usr_nm;
			sheetObject4.CellValue2(row, "auth_apro_ofc_cd") =  ofc_cd;            			
			sheetObject4.CellValue2(row, "auth_apro_usr_jb_tit_nm")  =  title; 
			sheetObject4.CellValue2(row, "auth_apro_usr_id") =  usr_id;
			
            // APPROVAL SEQ 재정렬
            var rowCount = sheetObject4.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject4.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
            }
        }   
    }
    
 // 소속 Office 자동 펼침 처리
    function officeSearch() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd").value);
    }
    
 // 소속 Office 자동 펼침 처리
    function officeSearchAuth() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd_auth").value);
    }
    

    
    
    
    function sheet2_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;
                    
        if(selrow > 0) {
            sheetObject2.RowDelete(selrow, false);
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject2.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject2.CellValue2(i + 1, "apro_seq") = rowCount - i;
        }
    }
    
    function sheet4_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject4 = sheetObjects[3];
        var selrow = sheetObject4.SelectRow;
                    
        if(selrow > 0) {
            sheetObject4.RowDelete(selrow, false);
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject4.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject4.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
        }
    }
    
    /**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Expense", -1);
				InsertTab(cnt++, "Basic Data", -1);
			}
			break;
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		//------------------------------------------------------//
		beforetab = nItem;
		
		if(beforetab == 0){
			if(document.form.search_text.value == ""){
				officeSearch();
			}			
		}else if(beforetab == 1){
			if(document.form.search_text_auth.value == ""){
				officeSearchAuth();
			}
		}
	}
	
	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++] = combo_obj;  
	}	
	
	/**
	 * IBCombo 기본 설정
	 * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "pgm_no": 	//Year
				with (comboObj) { 
				
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					
					setComboData(comboObj);
				}
			break;
			
							
			case "sub_sys_cd_auth": 	
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					
					setComboData(comboObj);
				}
			break;
			
		
		}
	}
	
	function setComboData(comboObj, param){ 
			var comboID = comboObj.id;
			var formObj = document.form;
			var sheetObj = sheetObjects[3];
			switch(comboID){
				case "pgm_no":	
					var sParam = "f_cmd=" + COMMAND02 + "&sub_sys_cd_auth="+param;
					var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
					ComXml2ComboItem(xml,formObj.pgm_no,"pgm_no","pgm_nm");				
					break;
					
				
				case "sub_sys_cd_auth":		
					var sParam = "f_cmd=" + COMMAND01;
			
					var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
					ComXml2ComboItem(xml,formObj.sub_sys_cd_auth,"sub_sys_cd_auth","sub_sys_cd");
					
					break;
				
			}
			
			
		}
	
	/**
	 * 모듈 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function sub_sys_cd_auth_OnChange(comboObj, Index_Code, Text){
		setComboData(comboObjects[1], Index_Code);
		document.form.sub_sys_cd_auth.value = Index_Code;
	}
	
	/**
	 * 메뉴 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function pgm_no_OnChange(comboObj, Index_Code, Text){
		document.form.pgm_no.value = Index_Code;
	}

	
	function search() {	
		if(beforetab == 0){
			if ( document.getElementById("search_text").value == "" ) return;	
    		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
    	}else if(beforetab ==1){
    		if ( document.getElementById("search_text_auth").value == "" ) return;	
    		findXML(document.getElementById("search_auth").value, document.getElementById("search_text_auth").value);
    	}
	}
	
	
	/*
     * 선택된 결재자 아래로 한칸 식 내리기
     */
    function changeDownApproval(sheetObject){
    	var formObject = document.form;
        var selrow = sheetObject.SelectRow;
        if(selrow > 0) {
        	if(sheetObject.CellValue(selrow, sheetObject.ColSaveName(1))==1){
        		//ComShowMessage('최하단입니다.');
        	}else{
	        	var temp1 = sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(2));
	        	var temp2 = sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(3));            			
	        	var temp3 = sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(4)); 
	        	var temp4 = sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(5));
	        	
	        	sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(2)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(2)) ;
	        	sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(3)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(3)) ;
	        	sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(4)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(4));
	        	sheetObject.CellValue(selrow+1, sheetObject.ColSaveName(5)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(5));  
	        	
	        	
	
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(2)) = temp1;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(3)) = temp2;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(4)) = temp3;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(5)) = temp4;
	        	
	        	sheetObject.SelectCell(selrow+1, 0);
        	}
            
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject.CellValue2(i + 1, sheetObject.ColSaveName(1)) = rowCount - i;
        }
    }
    
    
    /*
     * 선택된 결재자 위로 한칸 씩 올리기
     */
    function changeUpApproval(sheetObject){
    	var formObject = document.form;
        var selrow = sheetObject.SelectRow;

        if(selrow > 0) {
        	if(sheetObject.CellValue(selrow, sheetObject.ColSaveName(1))==sheetObject.RowCount){
        		//ComShowMessage('최상단입니다.');
        	}else{
	        	var temp1 = sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(2));
	        	var temp2 = sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(3));            			
	        	var temp3 = sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(4)); 
	        	var temp4 = sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(5));
	        	
	        	sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(2)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(2)) ;
	        	sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(3)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(3)) ;
	        	sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(4)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(4));
	        	sheetObject.CellValue(selrow-1, sheetObject.ColSaveName(5)) = sheetObject.CellValue(selrow, sheetObject.ColSaveName(5));  
	        	
	        	
	
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(2)) = temp1;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(3)) = temp2;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(4)) = temp3;
	        	sheetObject.CellValue(selrow, sheetObject.ColSaveName(5)) = temp4;
	        	
	        	sheetObject.SelectCell(selrow-1, 0);
        	}
            
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject.CellValue2(i + 1, sheetObject.ColSaveName(1)) = rowCount - i;
        }
    }
	/* 개발자 작업  끝 */