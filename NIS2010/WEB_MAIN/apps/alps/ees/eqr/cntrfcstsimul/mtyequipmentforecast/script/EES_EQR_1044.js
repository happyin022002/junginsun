/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1044.js
*@FileTitle : MTY Repo In/ Out Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.11 김종준
* 1.0 Creation 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var headCount = 0;
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1044 : EES_EQR_1044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1044() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheetObject = sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_downexcel":
                    if(sheetObjects[1].RowCount > 0){
                        doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
                    }
                    break;
                case "btn_Close":
                    window.close();
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        if(document.form.curr_flag.value == "T"){
        	document.all.dis_vol.style.display = "Inline";
        }
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle = "Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|Remark|";
                    headCount = ComCountHeadTitle(HeadTitle);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    CountPosition = 0;  //페이지카운트 없애기

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    sheetObj.FrozenCols = 5; 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtAutoSum,      60,     daCenter,   true,  "to_yd_cd",         false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenter,   true,  "vsl_lane_cd",  	   false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         75,     daCenter,   true,  "vvd",              false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   true,  "to_etb_dt",        false,  "", dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenter,   true,  "to_etb_day",        false,  "", dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d7_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r9_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "s2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "s4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,        500,    	daLeft,   	true,  "remark",           false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,        0,    	daLeft,   	true,  "lvl",           false,  "", dfNone);
               }
               break;
               
            case "sheet2":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                if(document.form.curr_flag.value == "T"){
                	style.height = 300;
                }else{
                	style.height = 522;
                }
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
//                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                MergeSheet = msNone;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);

                var HeadTitle = "Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|Remark|";
                headCount = ComCountHeadTitle(HeadTitle);                    

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                CountPosition = 0;  //페이지카운트 없애기

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                sheetObj.FrozenCols = 5; 
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtAutoSum,      60,     daCenter,   true,  "to_yd_cd",         false,  "", dfNone);
                InitDataProperty(0, cnt++ , dtData,         35,     daCenter,   true,  "vsl_lane_cd",  	   false,  "", dfNone);
                InitDataProperty(0, cnt++ , dtData,         75,     daCenter,   true,  "vvd",              false,  "", dfNone);
                InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   true,  "to_etb_dt",        false,  "", dfDateYmd);
                InitDataProperty(0, cnt++ , dtData,         35,     daCenter,   true,  "to_etb_day",        false,  "", dfDateYmd);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d4_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d5_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "d7_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r5_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "r9_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "s2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o4_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "s4_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "o5_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a2_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f4_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a4_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "f5_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,         35,     daRight,    true,  "a5_fcast_qty",     false,  "", dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,        500,    	daLeft,   	true,  "remark",           false,  "", dfNone);
                InitDataProperty(0, cnt++ , dtHidden,        0,    	daLeft,   	true,  "lvl",           false,  "", dfNone);
           }
           break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {

            case IBSEARCH:      //조회
            	sheetObj.WaitImageVisible=false;
            	ComOpenWait(true); 
                formObj.f_cmd.value = SEARCH;
                sheetObj.Redraw = false;
                var sXml = sheetObj.GetSearchXml("EES_EQR_1044GS.do",FormQueryString(formObj));
                if(formObj.curr_flag.value == "T"){
                	var arrXml = sXml.split("|$$|");
                	sheetObjects[0].LoadSearchXml(arrXml[1]);
                	sheetObjects[1].LoadSearchXml(arrXml[0]);
                }else{
                	sheetObjects[1].LoadSearchXml(sXml);
                }
                ComOpenWait(false); 
                break;
            case IBDOWNEXCEL:      // 입력
            	if(formObj.curr_flag.value == "T"){	
            		sheetObjects[0].Down2Excel(0,false,true,true,'','',false,false,'',false,'lvl',sheetObjects[0].LastRow-1);
            		sheetObj.Down2Excel(0,true,true,true,'','',false,false,'',false,'lvl',sheetObj.LastRow-1);
            	}else{
            		sheetObj.Down2Excel(0,false,true,true,'','',false,false,'',false,'lvl',sheetObj.LastRow-1);
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
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
    	 if(sheetObj.RowCount > 0) {
    		 for(var i=0; i<=sheetObj.LastRow; i++){
    			 if (sheetObj.CellValue(i,"lvl") == '111111') {
    				 sheetObj.CellFont("FontBold", i,"to_yd_cd") = true;
    				 sheetObj.CellFont("FontBold", i,"vsl_slan_cd") = true;
    				 sheetObj.CellFont("FontBold", i,"vvd") = true;
    				 sheetObj.CellFont("FontBold", i,"total") = true;
    				 //for ( var j=5; j<=20; j++ ) {
    			     for ( var j=5; j<=22; j++ ) {  // A5,O5  					 
    					 sheetObj.CellFont("FontBold", i,j) = true;
    				 }
    				 for ( var j=0; j<headCount; j++ ) {
    					 if ( j < 4 ) {
    						 sheetObj.CellValue(i,j) = '';
    					 } else {
    						 sheetObj.CellValue(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
    					 }
    				 }
    			 } 
			}
    		sheetObj.CellValue2(sheetObj.LastRow,"to_yd_cd") = 'MTY Repo. In Total';
    		sheetObj.CellAlign(sheetObj.LastRow,"to_yd_cd") = daCenter;
			sheetObj.RowHidden(sheetObj.LastRow-1) = true;
			
			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 4);
			sheetObj.SumBackColor  = sheetObj.WebColor2SysColor("#D3EBED");
			sheetObj.SumFontBold = true;
			
			//for ( var j=5; j<=20; j++ ) {
			for ( var j=5; j<=22; j++ ) {				
				if ( sheetObj.CellValue(sheetObj.LastRow,j) > 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(0,0,255);
				}
				if ( sheetObj.CellValue(sheetObj.LastRow,j) < 0 ) {
					sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(255,0,0);
				}
			} 
			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");

    	 }
    	 sheetObj.SelectHighLight = false;
    	 sheetObj.Redraw = true;
     }
     
 /**
  * Tab1 조회종료
  * Tab1 조회종료후 이벤트 호출
  */
  function sheet2_OnSearchEnd(sheetObj, msg){
 	 if(sheetObj.RowCount > 0) {
 		 for(var i=0; i<=sheetObj.LastRow; i++){
 			 if (sheetObj.CellValue(i,"lvl") == '111111') {
 				 sheetObj.CellFont("FontBold", i,"to_yd_cd") = true;
 				 sheetObj.CellFont("FontBold", i,"vsl_slan_cd") = true;
 				 sheetObj.CellFont("FontBold", i,"vvd") = true;
 				 sheetObj.CellFont("FontBold", i,"total") = true;
 				 //for ( var j=5; j<=20; j++ ) {
 				 for ( var j=5; j<=22; j++ ) { // A5,O5 					 
 					 sheetObj.CellFont("FontBold", i,j) = true;
 				 }
 				 for ( var j=0; j<headCount; j++ ) {
 					 if ( j < 4 ) {
 						 sheetObj.CellValue(i,j) = '';
 					 } else {
 						 sheetObj.CellValue(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
 					 }
 				 }
 			 } 
		}
 		sheetObj.CellValue2(sheetObj.LastRow,"to_yd_cd") = 'MTY Repo. In Total';
 		sheetObj.CellAlign(sheetObj.LastRow,"to_yd_cd") = daCenter;
		sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		
		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 4);
		sheetObj.SumBackColor  = sheetObj.WebColor2SysColor("#D3EBED");
		sheetObj.SumFontBold = true;
		
		//for ( var j=5; j<=20; j++ ) {
		for ( var j=5; j<=22; j++ ) {  //A5,O5			
			if ( sheetObj.CellValue(sheetObj.LastRow,j) > 0 ) {
				sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(0,0,255);
			}
			if ( sheetObj.CellValue(sheetObj.LastRow,j) < 0 ) {
				sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(255,0,0);
			}
		} 
		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");

 	 }
 	 sheetObj.SelectHighLight = false;
 	 sheetObj.Redraw = true;
  }
     
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	if ( row == sheetObj.LastRow ) {
          	sheetObj.SelectHighLight = false;
      		sheetObj.RowBackColor(row) = -1;
      	} else {
          	sheetObj.SelectHighLight = true;
      	}
      	
     }	    
      
  /**
   * 셀을 클릭했을때 발생하는 이벤트 <br>
   * 선택시 선택행 배경색 세팅
   */
  function sheet2_OnClick(sheetObj, row, col, value) {
   	if ( row == sheetObj.LastRow ) {
       	sheetObj.SelectHighLight = false;
   		sheetObj.RowBackColor(row) = -1;
   	} else {
       	sheetObj.SelectHighLight = true;
   	}
   	
  }	