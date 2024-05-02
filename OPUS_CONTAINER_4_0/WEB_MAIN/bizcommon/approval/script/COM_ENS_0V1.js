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
            	case "btn_Search":
            		if ( document.getElementById("search_text").value == "" ) return;	
            		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
            		break;
            		
            	case "btn_retrieve":   
            		if(formObject.sub_sys_cd.value == "") {
        	        	ComShowCodeMessage("COM12113", "Module");
        	        	return;
        	        }
            		doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                    break;
                    
            	case "btn_save":
        	        if(formObject.sub_sys_cd.value == "") {
        	        	ComShowCodeMessage("COM12113", "Module");
        	        	return;
        	        }
        	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
        	        break;
        	       
            	case "btns_add":
            		var selrow = sheetObjects[0].SelectRow;
                    if ( selrow > 0 ){
                    	sheet1_OnDblClick("", "", "", "");
            		}     	        
            		break;

         	    case "btns_del":
         	    	var selrow = sheetObjects[1].SelectRow;
                    if ( selrow > 0 ){
                    	sheet2_OnDblClick("", "", "", "");
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
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     0,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
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
     
     // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadData(data) {
    	var sheetObject = sheetObjects[0];

    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4);
    		sheetXml += "]]></TR>";
    	}
    	sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
     }
     
    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
  
        var selrow = sheetObject1.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject1.CellValue(selrow, "CN");
            var usr_nm = sheetObject1.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject1.CellValue(selrow, "TEAMNM");
            var title = sheetObject1.CellValue(selrow, "BUJAE");
            
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
    
 // 소속 Office 자동 펼침 처리
    function officeSearch() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd").value);
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

	/* 개발자 작업  끝 */