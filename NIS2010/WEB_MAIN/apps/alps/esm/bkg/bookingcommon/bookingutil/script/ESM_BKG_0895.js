/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0895.js
*@FileTitle : bookingutil
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.09 강동윤
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
     * @class esm_bkg_0895 : esm_bkg_0895 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0895() {
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

            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
                
            	//khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
            
            if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
    		}
        }


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

    		switch(sheetObj.id) {
    			case "sheet1":      //sheet1 init
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 520;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					
    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msNone;
    					
    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
    					
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 3, 100);
    					
    					var HeadTitle = "|Sel.|Seq.|Item Group|Item List";
    					var headCount = ComCountHeadTitle(HeadTitle);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(7, 0, 0, true);
    					
    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, true, true, false,false);
    					
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					
    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++ , dtHiddenStatus,			30,		daCenter,	true,		"ibflag");
    					InitDataProperty(0,	cnt++,	dtCheckBox,				40,		daCenter,	false,		"check");
    					InitDataProperty(0,	cnt++,	dtSeq,					30,		daCenter,	false,		"seq");
    					InitDataProperty(0,	cnt++,	dtData,					100,	daLeft,		false,		"sql_ctnt",	false,	"",			dfNone,		0,			false,		false);
    					InitDataProperty(0,	cnt++,	dtData,					180,	daLeft,		false,		"item_nm",	false,	"",			dfNone,		0,			false,		false);
    					InitDataProperty(0,	cnt++ , dtHidden,				30,		daCenter,	true,		"tbl_nm");
    					InitDataProperty(0,	cnt++ , dtHidden,				30,		daCenter,	true,		"col_nm");

    				}
    				break;

    			case "sheet2":      //sheet2 init
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 520;
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					
    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msNone;
    					
    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
    					
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1, 1, 5, 100);
    					
    					var HeadTitle = "|Seq.|Item Group|Selected Items||";
    					var headCount = ComCountHeadTitle(HeadTitle);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(headCount, 0, 0, true);
    					
    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, true, true, false,false);
    					
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					
    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++,	dtCheckBox,	20,		daCenter,	false,	"check");
    					InitDataProperty(0,	cnt++,	dtDataSeq,	30,		daCenter,	false,	"seq");
    					InitDataProperty(0,	cnt++,	dtData,		100,	daLeft,		false,	"sql_ctnt",	false,	"",			dfNone,		0,			false,		false);
    					InitDataProperty(0,	cnt++,	dtData,		180,	daLeft,		false,	"item_nm",	false,	"",			dfNone,		0,			false,		false);
    					InitDataProperty(0,	cnt++ , dtHidden,	30,		daCenter,	true,	"tbl_nm");   
    					InitDataProperty(0,	cnt++ , dtHidden,	30,		daCenter,	true,	"col_nm");
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
     				case "btns_add":
     					addDelRow("add");
     					break;

     				case "btns_del":
     					addDelRow("del");
     					break;
     					
     				case "btns_up":
     					rowUpDown(sheetObject2, "UP");
     					break;
     					
     				case "btns_down":
     					rowUpDown(sheetObject2, "DOWN");
     					break;

     				case "btn_OK":
     					returnValue();
     					/* 2010.01.21 0104 의 Save 버튼을 눌러준다 */
	 					opener.setSearchSaveOption();
     					break;

     				case "btn_Close":
     					self.close();
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
    	          	
	              	formObj.f_cmd.value = SEARCH;   
	              	
					sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 					
					var resultXml = sheetObj.GetSearchXml("ESM_BKG_0895GS.do", FormQueryString(formObj)); 
					
					var arrXml = resultXml.split("|$$|"); 	
					
					sheetObjects[0].LoadSearchXml(arrXml[0], false);
					sheetObjects[1].LoadSearchXml(arrXml[1], false);
					
					ComOpenWait(false);
					
                    break;

    	 		case IBSAVE:        //저장
    	          	if(validateForm(sheetObj,formObj,sAction)) alert (" Save .. ");
                    break;

    			case IBINSERT:      // 입력
                    break;
            }
        }



        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }

            return true;
        }
            
            /**
             * ok event
             */
        function returnValue(){
        	
            var reValue = '';	 
            	 
        	for (var i = 1 ; i < sheetObjects[1].RowCount+1 ; i++){
        		
        		//if (sheetObjects[1].CellValue(i,0) == '1'){
        			
        			reValue = reValue + "|" + sheetObjects[1].CellValue(i,"tbl_nm") + ">" + sheetObjects[1].CellValue(i,"col_nm");        			
   			    //}
        	}
        	
        	opener.setTemplate(reValue);
        	
        	self.close();
        }
            
            /**
             * row 추가/삭제
             */    
             function addDelRow(type){
          	   
          	   if (type == "add"){
          		   
	          	   for (var i = 1 ; i < sheetObjects[0].RowCount+1 ; i++){
	      			   
	      			   if (sheetObjects[0].CellValue(i,1) == '1'){
	      				   
	      				   var chkValue = true;
	      				   
	      				   for (var j = 1 ; j < sheetObjects[1].RowCount+1 ; j++){
	      					   
	      					   if (sheetObjects[0].CellValue(i,"tbl_nm") == sheetObjects[1].CellValue(j,"tbl_nm") && 
	      						   sheetObjects[0].CellValue(i,"col_nm") == sheetObjects[1].CellValue(j,"col_nm")){
	      						   
	      						   chkValue = false;
	      						   break;
	      					   }
	      				   }
	      				  
	      				   if (chkValue){
	  	    				   var row = sheetObjects[1].DataInsert(-1);

	  	    				   sheetObjects[1].CellValue2(row,"sql_ctnt") = sheetObjects[0].CellValue(i,"sql_ctnt"); 
	  	    				   sheetObjects[1].CellValue2(row,"item_nm") = sheetObjects[0].CellValue(i,"item_nm");	
	  	    				   sheetObjects[1].CellValue2(row,"tbl_nm") = sheetObjects[0].CellValue(i,"tbl_nm");	
	  	    				   sheetObjects[1].CellValue2(row,"col_nm") = sheetObjects[0].CellValue(i,"col_nm");
	      				   }else{
	      					   alert("exist same data");
	      				   }
	      			   }
	      		   }
          	   }else{
          		   
          		   var idx = sheetObjects[1].RowCount;
          		   
          		   for (var i = 1 ; i < idx+1 ; i++){
          			   
          			   for (var j = 1 ; j < sheetObjects[1].RowCount+1 ; j++){
      	    			   
      	    			   if (sheetObjects[1].CellValue(j,0) == '1'){
      		    				   
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
        			           			   
        				   var tempUPCheck  = sheetObj.CellValue(Row-1,"check");
        				   var tempUPCtnt	= sheetObj.CellValue(Row-1,"sql_ctnt");
        				   var tempUPItem   = sheetObj.CellValue(Row-1,"item_nm");
        				   var tempUPTbl    = sheetObj.CellValue(Row-1,"tbl_nm");
        				   var tempUPCol	= sheetObj.CellValue(Row-1,"col_nm");
        				          				   
        				   var tempNowCheck = sheetObj.CellValue(Row,"check");
        				   var tempNowCtnt	= sheetObj.CellValue(Row,"sql_ctnt");
        				   var tempNowItem  = sheetObj.CellValue(Row,"item_nm");
        				   var tempNowTbl   = sheetObj.CellValue(Row,"tbl_nm");
        				   var tempNowCol   = sheetObj.CellValue(Row,"col_nm");
        				   
        				   sheetObj.CellValue(Row-1,"check") 	= tempNowCheck;
        				   sheetObj.CellValue(Row-1,"sql_ctnt") = tempNowCtnt;
        				   sheetObj.CellValue(Row-1,"item_nm") 	= tempNowItem;
        				   sheetObj.CellValue(Row-1,"tbl_nm") 	= tempNowTbl;
        				   sheetObj.CellValue(Row-1,"col_nm") 	= tempNowCol;
        				   
        				   sheetObj.CellValue(Row,"check")   	= tempUPCheck;
        				   sheetObj.CellValue(Row,"sql_ctnt")   = tempUPCtnt;
        				   sheetObj.CellValue(Row,"item_nm")   	= tempUPItem;
        				   sheetObj.CellValue(Row,"tbl_nm")   	= tempUPTbl;
        				   sheetObj.CellValue(Row,"col_nm")   	= tempUPCol;
        				   
        				   sheetObj.SelectCell(Row-1, 1); 
        			   }
        		   }else{

        			   if (Row < sheetObj.RowCount){
        				   
        				   var tempDWCheck  = sheetObj.CellValue(Row+1,"check");
        				   var tempDWCtnt	= sheetObj.CellValue(Row+1,"sql_ctnt");
        				   var tempDWItem   = sheetObj.CellValue(Row+1,"item_nm");
        				   var tempDWTbl    = sheetObj.CellValue(Row+1,"tbl_nm");
        				   var tempDWCol	= sheetObj.CellValue(Row+1,"col_nm");
        				   
        				   var tempNowCheck = sheetObj.CellValue(Row,"check");
        				   var tempNowCtnt	= sheetObj.CellValue(Row,"sql_ctnt");
        				   var tempNowItem  = sheetObj.CellValue(Row,"item_nm");
        				   var tempNowTbl   = sheetObj.CellValue(Row,"tbl_nm");
        				   var tempNowCol   = sheetObj.CellValue(Row,"col_nm");
        				   
        				   sheetObj.CellValue(Row+1,"check") = tempNowCheck;
        				   sheetObj.CellValue(Row+1,"sql_ctnt") = tempNowCtnt;
        				   sheetObj.CellValue(Row+1,"item_nm") = tempNowItem;
        				   sheetObj.CellValue(Row+1,"tbl_nm") = tempNowTbl;
        				   sheetObj.CellValue(Row+1,"col_nm") = tempNowCol;
        				   
        				   sheetObj.CellValue(Row,"check")   = tempDWCheck;
        				   sheetObj.CellValue(Row,"sql_ctnt")   = tempDWCtnt;
        				   sheetObj.CellValue(Row,"item_nm")   = tempDWItem;
        				   sheetObj.CellValue(Row,"tbl_nm")   = tempDWTbl;
        				   sheetObj.CellValue(Row,"col_nm")   = tempDWCol;
        				   
        				   sheetObj.SelectCell(Row+1, 1); 
        			   }
        		   }
        	   }
           }
    /* version up 2010.1.22 */
	/* 개발자 작업  끝 */