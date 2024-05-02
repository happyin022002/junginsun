/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1049.js 
*@FileTitle : MTY Repo Out 상세내역 조회 및 Loading List 수기수정
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.22
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.10.22 신용찬
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
    * @class EES_EQR_1049 : EES_EQR_1049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1049() {
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
            		//sheetObjects[0].CellEditable(0, "to_etb_day")= false;
            		sheetObjects[0].SetMergeCell (sheetObjects[0].LastRow, 1, 1, 5);
            		
            		sheetObjects[0].InitCellProperty(1, "to_yd_cd", dtCombo); // CELL TYPE을 DTDATA으로 변경
            		sheetObjects[0].InitCellProperty(1, "to_etb_dt", dtCombo); // CELL TYPE을 DTDATA으로 변경
            		sheetObjects[0].CellComboItem(1, "to_yd_cd", " |"+to_yd_cd, " |"+to_yd_cd);  // " |" 은 첫째줄을 비우기 위한 조치임
            		sheetObjects[0].CellComboItem(1, "to_etb_dt", " |"+to_etb_dt, " |"+to_etb_dt);  
	            	
//	                InitDataCombo(0, "to_yd_cd", to_yd_cd, to_yd_cd, " ","");
//	                InitDataCombo(0, "to_etb_dt", " |"+to_etb_dt, " |"+to_etb_dt, " ","");	            	
            		
            		for ( var j=6; j<headCount2-1; j++ ) {
            			if(sheetObjects[0].ColSaveName(j).substring(3) == "fcast_qty"){
            				//alert(j + " : " +sheetObjects[0].ColSaveName(j));
            				sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, j) = 0;
            			}
            		}            		            
            		
            		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "cre_seq") = 1;
            		
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
                    
                case "btn_apply":
                	applyParent(); // 부모창에 total 값 반영
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
//        if(level_cd == "3") {
//        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
//        	ComBtnDisable("btn_apply");   // APPLY 버튼 잠금
//        	ComBtnDisable("btn_RowAdd");  // ROW ADD 버튼 잠금
//        	ComBtnDisable("btn_Delete");  // ROW DELETE 버튼 잠금
//        	
//        	sheetObjects[0].Editable = false; // 쉬트 잠금
//        	
//        }else if (level_cd == "2") {
//        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
//        	
//        	sheetObjects[0].Editable = true;
//        }        
        
        if (level_cd == "2" || level_cd == "3") {
        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
        	
        	sheetObjects[0].Editable = true;
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
        var shtID = sheetObj.id;

        switch(shtID) {
               
            case "sheet2":      
            with (sheetObj) {

                // 높이 설정
               	style.height = 522;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
//                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                MergeSheet = msNone;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);

                var HeadTitle = "Del.|Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|Remark||||||";
                headCount2 = ComCountHeadTitle(HeadTitle);                    

                //div|lvl|cre_seq|rpt_seq|to_etb_dt_org|ibflag	
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount2, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                CountPosition = 0;  //페이지카운트 없애기

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                sheetObj.FrozenCols = 6; 
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtDummyCheck,	  30,	  daCenter,	  true,  "check"		  );
                InitDataProperty(0, cnt++ , dtData,           60,     daCenter,   true,  "to_yd_cd",         true,   "",        dfNone, 		0,		false,		true,	5);
                InitDataProperty(0, cnt++ , dtData,           35,     daCenter,   true,  "vsl_lane_cd",  	 false,  "",        dfNone, 		0,		true,		false,	3);
                InitDataProperty(0, cnt++ , dtData,           75,     daCenter,   true,  "vvd",              false,  "",        dfNone, 		0,		true,		true,	9);
                InitDataProperty(0, cnt++ , dtCombo,          70,     daCenter,   true,  "to_etb_dt",        true,   "",        dfDateYmd, 	    0,		true,		true);
                InitDataProperty(0, cnt++ , dtData,           35,     daCenter,   true,  "to_etb_day",       false,  "",        dfDateYmd, 	    0,		false,		false);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "d2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "d4_fcast_qty",     false,  "",        dfNullInteger); 
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "d5_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "d7_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "r2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "r5_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "r9_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "o2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "s2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "o4_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "s4_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "o5_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "f2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "a2_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "f4_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "a4_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "f5_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      35,     daRight,    true,  "a5_fcast_qty",     false,  "",        dfNullInteger);
                InitDataProperty(0, cnt++ , dtData,           500,    daLeft,     true,  "remark",           false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "div",		         false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,         30,     daLeft,     true,  "lvl",              false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "cre_seq",		     false,  "",        dfNone);
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "rpt_seq",		     false,  "",        dfNone);   
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "to_etb_dt_org",	 false,  "",        dfNone);    // update, delete 에 사용되는 정보                
                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,     daCenter,   false, "ibflag"        );                                         
                
                InitDataCombo(0, "to_etb_dt", " |"+to_etb_dt, " |"+to_etb_dt, " ","");

                InitDataValid(0, "vvd", vtEngUpOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
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
                var sXml = sheetObj.GetSearchXml("EES_EQR_1049GS.do",FormQueryString(formObj));

                sheetObjects[0].LoadSearchXml(sXml);

                ComOpenWait(false); 
                break;
                
    		case IBSEARCH02:      //공통조회
    			form.f_cmd.value = SEARCH02;
    			var sXml = sheetObj.GetSearchXml("EES_EQR_1049GS.do" , FormQueryString(form));

    			to_yd_cd  = ComGetEtcData(sXml,"to_yd_cd");
    			to_yd_nm  = ComGetEtcData(sXml,"to_yd_nm");
    			to_etb_dt = ComGetEtcData(sXml,"to_etb_dt");

    			break;
    			
            case IBDOWNEXCEL:      // 입력
            	sheetObj.Down2Excel(0,false,true,true,'','',false,false,'',false,'div|lvl|cre_seq|rpt_seq|to_etb_dt_org|ibflag');
            	break;
             
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){            		           	            		
            		
		        	sheetObj.WaitImageVisible=false;
		        	ComOpenWait(true); 
		            formObj.f_cmd.value = MULTI;
		            sheetObj.DoSave("EES_EQR_1049GS.do",FormQueryString(formObj), "ibflag");
		            ComOpenWait(false);
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
      * 조회종료후 이벤트 호출
     */
     function sheet2_OnSearchEnd(sheetObj, msg){	  
       if(sheetObj.RowCount==1) {
    	   sheetObj.RowDelete(sheetObj.LastRow-1, false);
    	   
       }else if(sheetObj.RowCount > 1) {
    	 sheetObj.RowDelete(sheetObj.LastRow-1, false);
    	  	 
  	  	 // 색상변경
  	  	 //for ( var j=6; j<=21; j++ ) {
  	  	 //for ( var j=6; j<=22; j++ ) {		 
  	  	 for ( var j=6; j<=23; j++ ) {	 // A5	 
 	  		if ( sheetObj.CellValue(sheetObj.LastRow,j) > 0 ) {
 	  			sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(0,0,255);
 	  		}
 	  		if ( sheetObj.CellValue(sheetObj.LastRow,j) < 0 ) {
 	  			sheetObj.CellFontColor(sheetObj.LastRow,j) = sheetObj.RgbColor(255,0,0);
 	  		}
  	  	 } 
  	  	 sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");
  	  	 
  	  	 for(var i=0; i<=sheetObj.LastRow; i++){
  	  		 // cre_seq = 'N' 은 라인전체 수정 불가, Remark 만 수정 가능 			
  	  		 if(sheetObj.CellValue(i,"cre_seq") == '0') { 				 
  	  			 //sheetObj.RowEditable(i) = false;
  	  			 for ( var j=0; j<=sheetObj.LastCol; j++ ) {
  	  				sheetObj.CellEditable(i, j) = false;
  	  			 }
  	  			 sheetObj.CellEditable(i, "remark") = true; // remark 만 수정으로 변경 
  	  			 
  	  		 }else if(sheetObj.CellValue(i,"cre_seq") == '1') { // 1은 적색으로 표시(수정 가능)
  	  			//for ( var j=6; j<=21; j++ ) {  // QTY 만 대상
  	  			//for ( var j=6; j<=22; j++ ) {  // QTY 만 대상
  	  			for ( var j=6; j<=23; j++ ) {  // A5		
  	  				if(sheetObj.CellValue(i,j) != 0) { // 0 이 아니면 대상
  	  					sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255,0,0); // red  	  				
  	  				}
  	  			} 
  	  		 }else if(sheetObj.CellValue(i,"cre_seq") == '2') { // 2는 수정 불가(mty bkg loading )
  	  			 for ( var j=0; j<=sheetObj.LastCol; j++ ) {
   	  				sheetObj.CellEditable(i, j) = false;
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
     function sheet2_OnClick(sheetObj, row, col, value) {
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
     function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	 var formObj = document.form;
    	 with(sheetObj){
    		 switch (ColSaveName(Col)) {
    		 
    		 	 case "vvd":    		 	
    		 		if(Value.length != 9){
	     				ComShowCodeMessage("EQR90078","9");
	     				CellValue2(Row, Col) = "";
	     				SelectCell(Row, Col);
	     			}else{	//VVD로 lane 조회 및 from, to yard combo list 만들기
		      			WaitImageVisible=false;
		                ComOpenWait(true); 
		                formObj.f_cmd.value = SEARCH01;
		                var sXml = GetSearchXml("EES_EQR_1049GS.do",FormQueryString(formObj)+"&vvd="+Value);
		                    
		                var arrXml = sXml.split("|$$|");
		                var slnaCd = ComGetEtcData(arrXml[0], "slan_cd");
		                
		                if(slnaCd != ""){
		                	CellValue2(Row, "vsl_lane_cd") = slnaCd;		               
			                ComOpenWait(false);
		                }else{
		                    ComOpenWait(false);
		                    ComShowCodeMessage("EQR90001","accurate vvd code");
		                    CellValue2(Row, "vvd") = "";
		                    SelectCell(Row, Col);
		                }
	     			}
  			   
    		 		break;    
        			   			
    		 }
    	 }
     }
   	
     /**
      * 저장 완료시 처리
      */
     function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
  		save_flag = true;
  		
  		if ( ErrMsg == "" ) {
  			if ( save_flag ) { 
  				
  		    	var opener_obj = window.opener;
  		    	var week_seq  = formObj.dp_seq.value;
  		    	var sheet_row  = formObj.row.value;

  		    	for ( var j=6; j<=23; j++ ) { // A5  		   		    		
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
     
     /*
      * parent 에 total 값을 반영
      */
     function applyParent() {

    	var formObj    = document.form;
	    var opener_obj = window.opener;
		var week_seq   = formObj.dp_seq.value;
		var sheet_row  = formObj.row.value;

	    for ( var j=6; j<=23; j++ ) { // A5  		   		    		
		    if ( sheetObjects[0].rowCount > 0 ) {
		    	opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0,2), sheetObjects[0].CellValue(sheetObjects[0].LastRow, sheetObjects[0].ColSaveName(j)));
		    } else { //sheet_num
		    	// 0 으로 셋팅합니다.(모두 삭제한 경우)
		    	opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0,2), 0);
		    }
		}
		
		ComShowCodeMessage("EQR01145");

     }     
  
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj){
			switch (sAction) {
			case IBSAVE:
				for(var i = 1; i <= LastRow; i++){
					if(RowStatus(i) == "I"  ) {
						if(CellValue(i, "to_yd_cd") == "" || CellValue(i, "to_yd_cd") == null) {
							ComShowCodeMessage("COM130403", "Yard");
							SelectCell(i, "to_yd_cd");
							return false;							
						}	
					} 
					
					var qty_vol=0;
					if(RowStatus(i) == "I" || RowStatus(i) == "U"  ) {
						//for ( var j=6; j<=21; j++ ) { // QTY 만 선택
						for ( var j=6; j<=23; j++ ) { // A5							
							qty_vol += sheetObjects[0].CellValue(i, sheetObjects[0].ColSaveName(j));
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
                 
				break;
			}
	    }
	    return true;
	}  
   	
	
  	