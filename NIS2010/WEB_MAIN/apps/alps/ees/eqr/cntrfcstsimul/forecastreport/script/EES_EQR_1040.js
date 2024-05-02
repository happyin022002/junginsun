/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1040.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1040 : EES_EQR_1040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1040() {
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
    var headCount = 0;
    var headCount2= 0;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var to_yd_cd  = ""; // yard cd 조회
    var to_yd_nm  = "";
    var to_etb_dt = "";  
    
    var IBSEARCH02  = 30;    

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
            	case "btn_RowAdd":
            		sheetObjects[0].DataInsert(0);            		            		
            		sheetObjects[0].SetMergeCell (sheetObjects[0].LastRow, 1, 1, 5);
            		
            		sheetObjects[0].InitCellProperty(1, "etb", dtCombo); // CELL TYPE을 DTDATA으로 변경
            		sheetObjects[0].CellComboItem(1, "etb", " |"+to_etb_dt, " |"+to_etb_dt);  

	            	sheetObjects[0].CellValue2(1,"sts") = "M";
					sheetObjects[0].CellValue2(1,"vsl_cd") = "XXXX";
					sheetObjects[0].CellValue2(1,"skd_voy_no") = "0000";
					sheetObjects[0].CellValue2(1,"skd_dir_cd") = "X";
					sheetObjects[0].CellValue2(1,"lane") = "XXX";
					sheetObjects[0].CellValue2(1,"week") = formObject.fcast_yrwk.value;
					sheetObjects[0].CellValue2(1,"show_week") = formObject.fcast_yrwk.value.substr(4,2);
					sheetObjects[0].CellValue2(1,"loc_cd") = formObject.loc_cd.value;
					
            		for ( var j=6; j<headCount2-1; j++ ) {
            			if(sheetObjects[0].ColSaveName(j).substring(3) == "qty"){
            				sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, j) = 0;
            			}
            		}            		            
            		
            		break;

                case "btn_Delete":
                	
                	if(sheetObjects[0].FindCheckedRow("check") != ""){
    					ComRowHideDelete(sheetObjects[0],"check"); 
    					sheetObjects[0].SetMergeCell (sheetObjects[0].LastRow, 1, 1, 5);
    				}

                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                    break;
                    
                case "btn_downexcel":
                    if(sheetObjects[0].RowCount > 0){
                        doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);    	

        for(i=0;i<sheetObjects.length;i++){        
            ComConfigSheet (sheetObjects[i] );  //khlee-시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);        
            ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
        }
        
        var level_cd = document.form.level_cd.value;
        
        // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
        if(level_cd != "1") {
        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
        	ComBtnDisable("btn_RowAdd");  // ROW ADD 버튼 잠금
        	ComBtnDisable("btn_Delete");  // ROW DELETE 버튼 잠금
        	
        	sheetObjects[0].Editable = false; // 시트 잠금
        }        
		setHiddenCol(sheetObjects[0], document.form.tpsz_flag.value); // column 히든
    
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                style.height = 522;
				
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);

                var HeadTitle = "Del.|WK|STS|Lane|VVD|Yard|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|BSA|EQ L/F(%)|vsl_cd|skd_voy_no|skd_dir_no|week|lane|loc_cd|"
				              + "d2_f|d4_f|d5_f|d7_f|r2_f|r5_f|r9_f|o2_f|s2_f|o4_f|s4_f|o5_f|f2_f|a2_f|f4_f|a4_f|f5_f|a5_f|d2_ef|d4_ef|d5_ef|d7_ef|r2_ef|r5_ef|r9_ef|o2_ef|s2_ef|o4_ef|s4_ef|o5_ef|f2_ef|a2_ef|f4_ef|a4_ef|f5_ef|a5_ef|ibflag";
                headCount2 = ComCountHeadTitle(HeadTitle);                    

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount2, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                CountPosition = 0;  //페이지카운트 없애기

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                sheetObj.FrozenCols = 8; 
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,       DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtDummyCheck,  30,     daCenter,   true,  "check"          );
                InitDataProperty(0, cnt++ , dtData,        30,     daCenter,   true,  "show_week",  false,  "",        dfNone,         0,      false,      false,   6);
                InitDataProperty(0, cnt++ , dtData,        30,     daCenter,   true,  "sts",        false,  "",        dfNone,         0,      false,      false,   1);
                InitDataProperty(0, cnt++ , dtData,        40,     daCenter,   true,  "show_lane",  false,  "",        dfNone,         0,      false,      false,   3);
                InitDataProperty(0, cnt++ , dtData,        80,     daCenter,   true,  "show_vvd",   false,  "",        dfNone,         0,      false,      false,   9);
                InitDataProperty(0, cnt++ , dtData,        70,     daCenter,   true,  "yard",       true,   "",        dfNone,         0,      false,      true,    7);
                InitDataProperty(0, cnt++ , dtCombo,       80,     daCenter,   true,  "etb",        true,   "",        dfDateYmd,      0,      false,      true);
                InitDataProperty(0, cnt++ , dtData,        35,     daCenter,   true,  "etb_day",    false,  "",        dfNone,         0,      false,      false);
                
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "d2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "d4_qty",     false,  "",        dfInteger,   0,      true,       true); 
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "d5_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "d7_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "r2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "r5_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "r9_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "o2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "s2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "o4_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "s4_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "o5_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "f2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "a2_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "f4_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "a4_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "f5_qty",     false,  "",        dfInteger,   0,      true,       true);
                InitDataProperty(0, cnt++ , dtAutoSumEx,   70,     daRight,    true,  "a5_qty",     false,  "",        dfInteger,   0,      true,       true);
                
                InitDataProperty(0, cnt++ , dtData,        120,    daCenter,   true,  "bsa",        false,  "",        dfNone,      0,      false,      false,   10);
                InitDataProperty(0, cnt++ , dtData,        120,    daCenter,   true,  "eqlf",       false,  "",        dfNone,      0,      false,      false,   10);
                
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "vsl_cd",     false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "skd_voy_no", false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "skd_dir_cd", false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "week",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "lane",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,   true,  "loc_cd",     false,  "",        dfNone);                
                                              
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d4_f",       false,  "",        dfNone); 
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d5_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d7_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r5_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r9_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "s2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o4_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "s4_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o5_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a2_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f4_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a4_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f5_f",       false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a5_f",       false,  "",        dfNone);
                                                                                       
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d4_ef",      false,  "",        dfNone); 
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d5_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "d7_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r5_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "r9_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "s2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o4_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "s4_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "o5_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a2_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f4_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a4_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "f5_ef",      false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,      0,     daRight,    true,  "a5_ef",      false,  "",        dfNone);
        
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,   false, "ibflag"        );                             

                InitDataCombo(0, "etb", " |"+to_etb_dt, " |"+to_etb_dt, " ","");
				
                // 입력 형식 지정
                InitDataValid(0, "yard", vtEngUpOther, "1234567890");
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
                var sXml = sheetObj.GetSearchXml("EES_EQR_1040GS.do",FormQueryString(formObj));
                
                sheetObjects[0].LoadSearchXml(sXml);

                ComOpenWait(false); 
                break;
                
    		case IBSEARCH02:      // 공통조회 (ETB)
    			form.f_cmd.value = SEARCH02;
    			var sXml = sheetObj.GetSearchXml("EES_EQR_1040GS.do" , FormQueryString(form));
    			to_etb_dt = ComGetEtcData(sXml,"to_etb_dt");

    			break;
    		
            case IBDOWNEXCEL:      // 입력
                sheetObj.Down2Excel(-1,false,false,true,'','',false,false,'',false,'check');
            	break;
             
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){            		           	            		
            		
		        	sheetObj.WaitImageVisible=false;
		        	ComOpenWait(true); 
		            formObj.f_cmd.value = MULTI;
		            sheetObj.DoSave("EES_EQR_1040GS.do",FormQueryString(formObj), "ibflag");
		            ComOpenWait(false);
            	}
	            break;             
        }
    }

     
     /**
      * Tab1 조회종료
      * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){	  
       if(sheetObj.RowCount==1) {
    	 sheetObj.RowDelete(sheetObj.LastRow-1, false);
    	   
       }else if(sheetObj.RowCount > 1) {
    	 sheetObj.RowDelete(sheetObj.LastRow-1, false);
    	  	 
  	    // 색상변경
  	    //for ( var j=8; j<24; j++ ) {
  	  	//for ( var j=8; j<25; j++ ) {	
  	  	for ( var j=8; j<26; j++ ) {	  	// A5 추가  		
 	  		if ( sheetObj.CellValue(sheetObj.LastRow,j) > 0 ) {
 	  			sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(0,0,255);
 	  		}else if ( sheetObj.CellValue(sheetObj.LastRow,j) < 0 ) {
 	  			sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(255,0,0);
 	  		}
  	  	 } 
		 
  	  	 sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");
  	  	 
		 var level_cd = document.form.level_cd.value;
  	  	 for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow; i++){
		 	if(sheetObj.CellValue(i,"sts") != "M"){
				sheetObj.CellEditable(i,"check") = false;
				sheetObj.RowEditable(i) = false;  // G 표시는 수정금지
			}
			

			//for ( var j=8; j<24; j++ ) {  // QTY 만 대상
			//for ( var j=8; j<25; j++ ) {  // QTY 만 대상
			for ( var j=8; j<26; j++ ) {  // A5			
			    if(sheetObj.CellValue(i,sheetObj.ColSaveName(j).substr(0,2)+"_f")=="Y"){
			        sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255,0,0); // red                    
			    }
				if(sheetObj.CellValue(i,"sts")=="M" && sheetObj.CellValue(i,j)>0){
					sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255,0,0); // red    
				}
			}

  	  	 }
  	  	 
  	  	 sheetObj.SetMergeCell (sheetObj.LastRow, 1, 1, 5);
  	  	 sheetObj.SumBackColor  = sheetObj.WebColor2SysColor("#D3EBED");
  	  	 sheetObj.SumFontBold = true;
  	   }
       sheetObj.SelectHighLight = false;
  	   sheetObj.Redraw = true;
  	   
     }
     
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
    	 var level_cd = document.form.level_cd.value;
		 if(  level_cd == '1' // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
			  && sheetObj.ColSaveName(col).substr(3) == "qty" 
			  && sheetObj.CellValue(row,"sts") != "M"
			  && sheetObj.CellValue(row, sheetObj.ColSaveName(col).substr(0,2)+"_f") == "Y" ){
              show_del_btn(sheetObj, row, col);
         }
		 
		 if ( row == sheetObj.LastRow ) {
    		 sheetObj.SelectHighLight = false;
   			 sheetObj.RowBackColor(row) = -1;
    	 } else {
    		 sheetObj.SelectHighLight = true;
    	 }
    	   
     } 	
     
     /**
      * 셀에 키입력 했을때 발생하는 이벤트 <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {ibsheet} row     	sheetObj의 선택된 Row
      * @param {ibsheet} col     	sheetObj의 선택된 Col
      **/
     function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 var formObj = document.form;
    	 with(sheetObj){
    		 switch (ColSaveName(Col)) {  
  			   
     			case "yard":
     				
     				// validation
					form.f_cmd.value = SEARCH04;
                    var sXml = sheetObj.GetSearchXml("EES_EQR_1040GS.do" , FormQueryString(form)+"&yard="+Value);
                    if(ComGetEtcData(sXml,"yard_chk") != "T"){
						ComShowCodeMessage("COM132201", "Yard Code");
						CellValue2(Row,Col) = "";
						SelectCell(Row,Col);
					}
        			break;  	
    		 }
			 
			 if(ColSaveName(Col).substr(3) == "qty"){
			 	if(Value == "Return"){
	                CellValue2(Row, ColSaveName(Col).substr(0,2)+"_f") = "N";
	                CellFont("FontBold", Row, Col, Row, Col) = false;
	                CellFontColor(Row, Col) = RgbColor(0,0,0);
	                click_del_btn(sheetObj, Row, Col);
					CellValue(Row,ColSaveName(Col).substr(0,2)+"_ef") = "D";
					CellFontColor(Row,Col) = sheetObj.RgbColor(0,0,0); // black    
	            }else{
				 	CellValue2(Row,ColSaveName(Col).substr(0,2)+"_ef") = "U";
					CellValue2(Row,ColSaveName(Col).substr(0,2)+"_f")  = "Y";
					CellFontColor(Row,Col) = sheetObj.RgbColor(255,0,0); // red    	
                }
			 }
    	 }
     }
   	
     /**
      * 저장 완료시 처리
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
  		save_flag = true;
  		
  		if ( ErrMsg == "" ) {
  			if ( save_flag ) { 
  		    	var opener_obj = window.opener;
  		    	var week_seq  = formObj.dp_seq.value;
  		    	var sheet_row  = formObj.row.value;
  		    	
  		    	//for ( var j=6; j<=21; j++ ) { // QTY 만 선택
  		    	//for ( var j=6; j<=22; j++ ) { // QTY 만 선택	
  		    	for ( var j=6; j<=25; j++ ) { // A5  		    		
  		    		if ( sheetObjects[0].rowCount > 0 ) {						
  		    			opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0,2), sheetObjects[0].CellValue(sheetObjects[0].LastRow, sheetObjects[0].ColSaveName(j)));
  		    		} else { //sheet_num
  		    			// 0 으로 셋팅합니다.(모두 삭제한 경우)
  		    			opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0,2), 0);
  		    		}
  		    	}
  			}
  			ComShowCodeMessage("EQR70002");
  		}
     }     

    /**
     * 모든 sheet 클릭시 이벤트 발생
     */
    function click_del_btn(sheetObj, Row, Col){
         with (sheetObj) {
             ComOpenWait(true);
             var formObj = document.form;
               formObj.f_cmd.value = SEARCH03;
               
             var param = FormQueryString(formObj)
                       + "&week="        + CellValue(Row, "week")    
                       + "&sts="         + CellValue(Row, "sts")     
                       + "&lane="        + CellValue(Row, "lane")    
                       + "&vsl_cd="      + CellValue(Row, "vsl_cd")  
                       + "&skd_voy_no="  + CellValue(Row, "skd_voy_no")
                       + "&skd_dir_cd="  + CellValue(Row, "skd_dir_cd")
                       + "&yard="        + CellValue(Row, "yard")    
                       + "&etb="         + CellValue(Row, "etb")     
                       + "&tpsz="        + ColSaveName(Col).substr(0,2).toUpperCase();    
                       ;
             var sXml = GetSearchXml("EES_EQR_1040GS.do", param);
			 
             if(ComGetEtcData(sXml, "cntr_qty") != null && ComGetEtcData(sXml, "cntr_qty") != "" && ComGetEtcData(sXml, "cntr_qty") != "0"){
                 CellValue2(Row, Col) = ComGetEtcData(sXml, "cntr_qty");
				 CellText(Row, Col)   = ComGetEtcData(sXml, "cntr_qty");
             }else{
                 CellValue(Row, Col) = 0;
				 CellText(Row, Col) = 0;
             }
             ComOpenWait(false);
         }
    }

   /**
    * 모든 sheet 클릭시 이벤트 발생
    */
    function show_del_btn(sheetObj, Row, Col){
       if(true){
           sheetObj.InitColumnPopup(Col, 1, "Return", "");
           sheetObj.ShowColumnPopup(Row, Col, false);
       }
       sheetObj.InitColumnPopup(Col, 0, "", "");
    }   
  
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj){
			switch (sAction) {
			case IBSAVE:
				for(var i = HeaderRows; i < LastRow; i++){
					if(RowStatus(i) == "I"  ) {
						if(CellValue(i, "yard") == "" || CellValue(i, "yard") == null) {
							ComShowCodeMessage("COM130403", "Yard");
							SelectCell(i, "yard");
							return false;							
						}	
						if(CellValue(i, "etb") == "" || CellValue(i, "etb") == null) {
                            ComShowCodeMessage("COM130403", "ETB");
                            SelectCell(i, "vvd");
                            return false;
                        }
					}
					
					var qty_vol=0;
					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i,"sts") == "M" ) {
						for ( var j=8; j<=24; j++ ) { // QTY 만 선택
							qty_vol += CellValue(i,j)*1;
						}
						if(qty_vol==0) {
							ComShowCodeMessage("COM130403", "QTY Volume");
							return false;	
						}
					}
					
					// 삭제표시
					if(CellValue(i, "check") != "") {
						sheetObj.RowStatus(i) = "D"
					}
				}
				
                // 중복체크
				var dupRow = ColValueDup("vsl_cd|skd_voy_no|skd_dir_cd|sts|yard|etb");
				if(dupRow != -1) {
					ComShowCodeMessage("EQR01014");
                    return false;
				}
				
				break;
			}
	    }
	    return true;
	}  
   	
    function setHiddenCol(sheetObj, tpszStr){
        if(tpszStr != ""){
            var arr_tpsz = tpszStr.split(",");
            var consTpszArr = "D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,O5,F2,A2,F4,A4,F5,A5".split(",");//전체의 Container Type/Size

            for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size     
                for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                    if(consTpszArr[i] == arr_tpsz[j]){
                        sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_qty")= false;
                        break;
                    }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                        sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_qty")= true;
                    }
                }
            }
        }
    }	
  	