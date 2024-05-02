/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0044.js
*@FileTitle : W/O 발행화면 - Appt.Deli. Excel Import 팝업 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011-02-10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2006-08-17 Hyung Choon
* 1.0 최초 생성
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var mainPage;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
        /***********************************************************************************************************
            이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
            공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.        
         **********************************************************************************************************/
        /*
           이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
           메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
           (순서상도 form[1]이 되겠죠?) 
           그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
            document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
        */
        switch(srcName) {
            case "btn_FileImport":
            	doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    	        break;

    	    case "btn_Verify":
    	    	var opener_sheetObj = opener.sheetObjects[0];
    	    	var sheetObj = sheetObjects[0];
    	    	    	    	    	    	
    	    	if(opener_sheetObj.RowCount < 1){    	    		
    	    		return;
    	    	}
    	    	
    	    	if(sheetObj.RowCount < 1){    	    		
    	    		return;
    	    	}
    	    	
    	    	var temp = "";
    	    	var sw = 1;
    	    	
				for(var j=1; j<sheetObj.RowCount+1; j++){       	    	  	    	
    				sw = 1;
        			for(var i=2; i<opener_sheetObj.RowCount+2; i++){  
    	    			if(opener_sheetObj.CellText(i,"eq_no") == sheetObj.CellText(j,"cntr_no")){
    	    				sheetObj.CellValue2(j,"verify_result") = "";
	    	    			if(opener_sheetObj.CellText(i,"trsp_bnd_cd") == 'I'){
	    	    				sheetObj.CellValue2(j,"verify_result") = "OK";
	    	    				sheetObj.CellValue2(j,"opener_row") = i;	    	    				
	    	    			}else{
	    	    				sheetObj.CellValue2(j,"verify_result") = "No I/B CNTR";
	    	    			}	    	    			
	    	    			sw = 2;
    	    			}else{ 
    	    				if(sw == 1){
    	    					sheetObj.CellValue2(j,"verify_result") = "No matching CNTR";
    	    				}
    	    			}    	    			    	    	
    	    		}    	    		  	    		
    	    	}    	    	    	    	
    	        break;

    	    case "btn_Apply":    	    	
    	    	var opener_sheetObj = opener.sheetObjects[0];
    	    	var sheetObj = sheetObjects[0];
    	    	var opener_row = 0;
    	    	
    	    	for(var j=1; j<sheetObj.RowCount+1; j++){    	    		    	    		
    	    		if(sheetObj.CellText(j,'verify_result') == 'OK'){
	    	    		opener_row = sheetObj.CellValue(j,'opener_row');
	    	    		opener_sheetObj.CellValue2(opener_row,'ibcheck') = '1';
		    	    	opener_sheetObj.CellValue2(opener_row,'appo_time_dt') = sheetObj.CellValue(j,'appointment_time_dt');
		    	    	opener_sheetObj.CellValue2(opener_row,'appo_time_hms') = sheetObj.CellValue(j,'appointment_time_hms');		    	    	
		    	    	opener_sheetObj.CellValue2(opener_row,'deli_time_dt') = sheetObj.CellValue(j,'delivery_time_dt');
		    	    	opener_sheetObj.CellValue2(opener_row,'deli_time_hms') = sheetObj.CellValue(j,'delivery_time_hms');		    	    			    	    	
    	    		}
    	    	}    	
    	    	
    	    	if(sheetObj.RowCount > 0){
    	    		self.close();
    	    	}
    	        break;
    	        
            case "btn_Close":
	            self.close();
    	        break;    	        
        } // end switch
    }catch(e) {            
        /*
        자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
        if( e == "[object Error]") {
        	ComShowMessage(OBJECT_ERROR);
        } else {
        	ComShowMessage(e);
        }
    }
}

    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
        initControl();
    }
    
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(mainpage) {
    	 mainPage = mainpage;
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }        
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제      	
    }

     function initControl() {
     	var formObject = document.form;
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }

     //업무 자바스크립트 OnKeyPress 이벤트 처리
     function keypressFormat() {
     	obj = event.srcElement;
   	    if(obj.dataformat == null) return;
   	    window.defaultStatus = obj.dataformat;
   	    switch(obj.dataformat) {
   	        case "engup":
   	        	ComKeyOnlyAlphabet('uppernum','32');
   	            break;
   	    }
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        sheetObj.UseUtf8 = true;
        var cnt = 0;
        
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    var HeadTitle = "CNTR No.|Appointment Time|Appointment Time|Delivery Time|Delivery Time|Verify Result|";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "cntr_no",        	false,          "",       dfNone,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    "appointment_time_dt",   false,          "",       dfDateYmd,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  false,    "appointment_time_hms",   false,          "",       dfTimeHms,       0,     false,       false);                    
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    "delivery_time_dt",      false,          "",       dfDateYmd,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  false,    "delivery_time_hms",      false,          "",       dfTimeHms,       0,     false,       false);                    
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "verify_result",      false,          "",       dfNone,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    	 10,    daCenter,  false,    "opener_row");                    
                }                
                break;           
        }
    }
     
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction){
        switch(sAction) {
        	case IBLOADEXCEL:
        		sheetObj.LoadExcel();
        		break;
        	case IBSEARCH:      //조회            
           		break;
        }
    }
    
    function sheet_OnLoadExcel(sheetObj){
    	for(var j=1; j<sheetObj.RowCount+1; j++){    	    		    	    		
    		sheetObj.CellValue2(j,'cntr_no') = sheetObj.CellValue(j,'cntr_no').toUpperCase();
    	}
    }    