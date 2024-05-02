/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0073.js
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
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
     * @class fns_joo_0073 : fns_joo_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0073() {
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
 var prefix = "sheet1_";
 
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

                 case "btn_Retrieve":
                  
                     break;

                 case "btn_New":
                    alert(srcName);
                     break;

                 case "btn_DownExcel":
                    alert(srcName);
                     break;

                 case "btn_Close":
					 window.close();
                 break;
                 
                 case "btn_OK": 
                	 //alert('sheetObj___>'+sheetObjects[0]+', formObject__>'+formObject);
                	 comPopupOK2(sheetObjects[0],formObject);
                 break;
                 
             } // end switch
     	}catch(e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 			
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
 

 	/**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetObj.id) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
            	 	 ScrollBar = 2;
                     // 높이 설정
                     style.height = 230;
                    
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 20, 100);

 					var HeadTitle1 = "Name|Attention|Copy|Attn.: E-Mail|CC:E-Mail|Fax|jo_cntc_eml|jo_cntc_fax_no";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true); 

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN,		COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     //팝업 
                     //InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",       false,          "",       dfNone,	    0,     true,       true);
                     //InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "check",       false,          "",       dfNone,   	0,     true,       true);

                     InitDataProperty(0, cnt++ , dtData,				 150,		daLeft,		  true,			prefix+"cntc_pson_nm",			false,          "",      dfNone,      0,     true,       true);    
        			 InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			prefix+"at1",			false,          "",      dfNone,      0,     true,       true);
        			 InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			prefix+"cc1",			false,          "",      dfNone,      0,     true,       true);
        			 InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			prefix+"at2",			false,          "",      dfNone,      0,     true,       true);
        			 InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			prefix+"cc2",			false,          "",      dfNone,      0,     true,       true);
        			 InitDataProperty(0, cnt++ , dtCheckBox,			80,		daCenter,		true,			prefix+"f1",			false,          "",      dfNone,      0,     true,       true);
        			
        			 InitDataProperty(0, cnt++ , dtHidden,		   		150,		daLeft,		  true,			prefix+"jo_cntc_eml",	false,          "",      dfNone,      0,     true,       true);
        			 InitDataProperty(0, cnt++ , dtHidden,		   		150,		daLeft,		  true,			prefix+"jo_cntc_fax_no",false,          "",      dfNone,      0,     true,       true);
                 
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
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true); 
                
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("FNS_JOO_0073GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    			
                ComOpenWait(false);
            }
             break;

 			case IBSAVE:        //저장
 				if(validateForm(sheetObj,formObj,sAction))
 					alert (" Save .. ");
 					break;

 			case IBINSERT:      // 입력
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
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }         


         /**
          * 셀의 값이 바뀌었을 때 발생하는 Event
          * @param sheetObj
          * @param row
          * @param col
          * @return
          */
         function sheet1_OnChange(sheetObj, row, col) {
         	// Key Setting(필수)
         	//initKeySetting();
         	var rows = sheetObj.Rows;
         	
         	//alert(sheetObj.ColSaveName(col));
         	 
         	/*1. Attention을 클릭시 Attn:E-Mail 도 함께 클릭된다 (역으로도 가능하도록 처리)
             *2. Copy를 클릭시 CC:E-Mail도 함께 클릭되도록 한다(역으로도 가능)
             *3. Attention을 클릭시 클릭한 행 이외의 모든 행은 disabled처리한다
             *4. 클릭된 데이타를 찾아서 부모창에 전달할 데이타를 정의한다 
         	 */
         	 switch (sheetObj.ColSaveName(col)) {
         	 //1 
         		case prefix+"at1" :
         			if(row > 0) {
         				if(sheetObj.cellvalue(row,prefix+"at1") == 0) {	//unCheck
         					sheetObj.CellValue(row,prefix+"at2") = 0;
	             			//3  
	             			for(var i=0; i < rows; i++ ){
	             				if(i!=row){
	             					sheetObj.CellEditable(i,prefix+"at1") = true;
	             					sheetObj.CellEditable(i,prefix+"at2") = true;
	             				}
	             			}
         					return;
         				}
         				if(sheetObj.cellvalue(row,prefix+"at1") == 1) {	 //Check
         					sheetObj.CellValue(row,prefix+"at2") = 1;
	             			//3  
	             			for(var i=0; i < rows; i++ ){
	             				if(i!=row){
	             					sheetObj.CellEditable(i,prefix+"at1") = false;
	             					sheetObj.CellEditable(i,prefix+"at2") = false;
	             				}
	             			}
         					return;
         				}
         			}
         			break;
         		case prefix+"at2" :
         			if(row > 0) {
         				if(sheetObj.cellvalue(row,prefix+"at2") == 0) {	//unCheck
         					sheetObj.CellValue(row,prefix+"at1") = 0;
	             			//3  
	             			for(var i=0; i < rows; i++ ){
	             				if(i!=row){
	             					sheetObj.CellEditable(i,prefix+"at1") = true;
	             					sheetObj.CellEditable(i,prefix+"at2") = true;
	             				}
	             			}
         					return;
         				}
         				if(sheetObj.cellvalue(row,prefix+"at2") == 1) {	 //Check
         					sheetObj.CellValue(row,prefix+"at1") = 1;
	             			//3  
	             			for(var i=0; i < rows; i++ ){
	             				if(i!=row){
	             					sheetObj.CellEditable(i,prefix+"at1") = false;
	             					sheetObj.CellEditable(i,prefix+"at2") = false;
	             				}
	             			}
         					return;
         				}
         			}
         			break;
         		//2
         		case prefix+"cc1" :
         			if(row > 0) {
         				if(sheetObj.cellvalue(row,prefix+"cc1") == 0) {	//unCheck
         					sheetObj.CellValue(row,prefix+"cc2") = 0;
         					return;
         				}
         				if(sheetObj.cellvalue(row,prefix+"cc1") == 1) {	 //Check
         					sheetObj.CellValue(row,prefix+"cc2") = 1;
         					return;
         				}
         			}
         			break;
         		case prefix+"cc2" :
         			if(row > 0) {
         				if(sheetObj.cellvalue(row,prefix+"cc2") == 0) {	//unCheck
         						sheetObj.CellValue(row,prefix+"cc1") = 0;
         						return;
         				}
         				if(sheetObj.cellvalue(row,prefix+"cc2") == 1) {	 //Check
         						sheetObj.CellValue(row,prefix+"cc1") = 1;
         				}
         			}
         			break;
         	 }
         }
          
	/* 개발자 작업  끝 */
          

////////////////////////////////////////////////////팝업스크립트 
      	function comPopupOK2(sheetObj,formObject) {
    		var formObject = document.form;
    		var checkRows;
    		var colsCnt = sheetObj.LastCol + 1;
    		var rows = sheetObj.Rows;
    		//리턴값 셋팅
			var at1Rth = '';
			var at2Rth = '';
			var cc1Rth = '';
			var cc2Rth = '';
			var faxRth = '';
			rArray = new Array(checkRows);
    		/*
    		 * 1. 전체 로우중 체크된 해당 열의 값들을 하나의 텍스트형태로 만든다
    		 * 2. 상위 함수를 이용하여 1에서 얻은 값을 넣는다
    		 */
    		if(checkRows == 0) {
    			ComShowCodeMessage("MNR00164", ""); 
    			return;
    		} else {
    			for(var i = 0; i < rows; i++) {
    				//attention name & attention email
					if(sheetObj.CellValue(i,prefix+"at1") == 1 && sheetObj.CellValue(i,prefix+"at2") == 1){	
						at1Rth = sheetObj.CellValue(i,prefix+"cntc_pson_nm");
						at2Rth = sheetObj.CellValue(i,prefix+"jo_cntc_eml");
					}
					//cc name & cc email
    				if(sheetObj.CellValue(i,prefix+"cc1") == 1 || sheetObj.CellValue(i,prefix+"cc2") == 1){	
    					cc1Rth += ";" + sheetObj.CellValue(i,prefix+"cntc_pson_nm");
    					cc2Rth += ";" + sheetObj.CellValue(i,prefix+"jo_cntc_eml");
    				}
					//fax
    				if(sheetObj.CellValue(i,prefix+"f1") == 1){	
    				    if( faxRth != ""){  faxRth += ",";}
                        if(sheetObj.CellValue(i,prefix+"jo_cntc_fax_no") != ""){
                            faxRth += ";"+sheetObj.CellValue(i,prefix+"jo_cntc_fax_no");
                        }
    					//faxRth += sheetObj.CellValue(i,prefix+"jo_cntc_fax_no");
    				}
    			}
 
    			if(cc1Rth.length>1){
    				cc1Rth = cc1Rth.substring(1 ,cc2Rth.length);
    				cc2Rth = cc2Rth.substring(1 ,cc2Rth.length);
    			}
    			if(faxRth.length>1){
    				faxRth = faxRth.substring(0 ,faxRth.length);
    			}
				
    			// alert('at1Rth____>'+at1Rth+', at2Rth___>'+at2Rth+', cc1Rth___>'+cc1Rth+', cc2Rth___>'+cc2Rth+', faxRth___>'+faxRth);
    			opener.setAttenCC(at1Rth, at2Rth, cc1Rth, cc2Rth, faxRth);
    		} 
    		window.close();
      	}
