
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;
var beforetab2 = 1

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            
                case "btn_close":
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
    */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);

        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//        var formObj = document.form;
//        var sXml = formObj.sXml.value;   
//        var arrXml = sXml.split("|$$|");   
//        for(var i = 0; i < arrXml.length; i++){  
////            sheetObjects[i].ShowDebugMsg = true;
//            sheetObjects[i].Redraw = false;       
//            if(i > 0) {   
//            sheetObjects[i].WaitImageVisible = false;     
//            }     
//            sheetObjects[i].LoadSearchXml(arrXml[i]);   
//            sheetObjects[i].Redraw = true;   
//        }          
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
                style.height = 0;
                                    
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 21, 100);
                           

                var HeadTitle1 = "SVC|Network Unit|Item|Point of Port|Lane|VVD|CNTR Type|Commodity Code|Remark|Office|By|";
                var headCount = ComCountHeadTitle(HeadTitle1);
                                    
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
               
                //데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            
                InitDataProperty(0, cnt++ , dtData,    30,    daCenter,   true,   "svc_use_flg", false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,   80,    daCenter,   true,   "ntwk_ut_nm",  false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    90,    daCenter,   true,   "itm_nm",      false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,   80,    daCenter,   true,   "ctrl_pnt_nm", false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    40,    daCenter,   true,   "vsl_slan_cd", false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,   true,   "vvd",         false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,   80,    daCenter,   true,   "cntr_tp_cd",  false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    110,   daCenter,   true,   "cmdt_cd",     false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    150,   daLeft,     true,   "cnst_rmk",    false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    60,    daCenter,   true,   "cre_ofc_cd",  false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    80,    daCenter,   true,   "cre_usr_id",  false,      "",    dfNone,         0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    1,     daCenter,   true,   "dummy",       false,      "",    dfNone,         0,        false,       false);
                
                InitDataCombo(0, "ntwk_ut_nm", ' |'+cnst_cdText, ' |'+cnst_cdCode);
                InitDataCombo (0, "ctrl_pnt_nm", " |ALL|POR|POL|T/S|POD|DEL", " |ALL|POR|POL|TS|POD|DEL", "");
                InitDataCombo (0, "cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
                
                CountPosition = 0;
                SelectionMode = smSelectionFree;
                
                WaitImageVisible=false;
           }
            break;
        case "sheet2":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
                                
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 21, 100);
                       

            var HeadTitle1 = "SVC|Network Unit|Item|Mode|Lane|VVD|CNTR Type|Commodity Code|Remark|Office|By|";
            var headCount = ComCountHeadTitle(HeadTitle1);
                                
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        
            InitDataProperty(0, cnt++ , dtData,   40,    daCenter,    true,  "svc_use_flg", false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   100,   daCenter,    true,  "ntwk_ut_nm",  false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtCombo,  90,    daCenter,    true,  "itm_nm",      false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtCombo,  60,    daCenter,    true,  "trsp_mod_cd", false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   40,    daCenter,    true,  "vsl_slan_cd", false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   70,    daCenter,    true,  "vvd",         false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtCombo,  80,    daCenter,    true,  "cntr_tp_cd",  false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   110,   daCenter,    true,  "cmdt_cd",     false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   150,   daLeft,      true,  "cnst_rmk",    false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   60,    daCenter,    true,  "cre_ofc_cd",  false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,   80,    daCenter,    true,  "cre_usr_id",  false,      "",       dfNone,        0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,    1,     daCenter,   true,   "dummy",       false,      "",    dfNone,         0,        false,       false);
            
            InitDataCombo(0, "trsp_mod_cd", ' |'+trsp_mod_cdText, 'AL|'+trsp_mod_cdCode);
            InitDataCombo (0, "cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
            InitDataCombo(0, "itm_nm", ' |'+cnst_cdText, ' |'+cnst_cdCode);
            
            CountPosition = 0;
            SelectionMode = smSelectionFree;
            
            WaitImageVisible=false;
       }
        break;
        case "sheet3":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
                                
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 21, 100);
                       

            var HeadTitle1 = "SVC|Network Unit|Item|BD|T.Lane|VVD|CNTR Type|Commodity Code|Remark|Office|By|";
            var headCount = ComCountHeadTitle(HeadTitle1);
                                
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        
            InitDataProperty(0, cnt++ , dtData,   40,     daCenter,  true,  "svc_use_flg", false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   100,    daCenter,  true,  "ntwk_ut_nm",  false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   90,     daCenter,  true,  "itm_nm",      false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   30,     daCenter,  true,  "dir_cd",      false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   50,     daCenter,  true,  "vsl_slan_cd", false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   70,     daCenter,  true,  "vvd",         false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtCombo,  80,     daCenter,  true,  "cntr_tp_cd",  false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   110,    daCenter,  true,  "cmdt_cd",     false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   150,    daCenter,  true,  "cnst_rmk",    false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   60,     daCenter,  true,  "cre_ofc_cd",  false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,   80,     daCenter,  true,  "cre_usr_id",  false,      "",       dfNone,        0,     false,        false);
            InitDataProperty(0, cnt++ , dtData,    1,     daCenter,   true,   "dummy",       false,      "",    dfNone,         0,        false,       false);

            InitDataCombo (0, "cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
            
            CountPosition = 0;
            SelectionMode = smSelectionFree;
            
            WaitImageVisible=false;
       }
        break;
        case "sheet4":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
                                
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 12, 100);
                       

            var HeadTitle1 = "SVC|Network Unit|Item|BD|T.Lane|R/D Term|Trans Mode|Imdg|Remark|Office|By|";
            var headCount = ComCountHeadTitle(HeadTitle1);
                                
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        
            InitDataProperty(0, cnt++ , dtData,   40,   daCenter,  true,  "svc_use_flg",    false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   100,  daCenter,  true,  "ntwk_ut_nm",     false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   90,   daCenter,  true,  "itm_nm",         false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtCombo,  30,   daCenter,  true,  "pctl_io_bnd_cd", false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "vsl_slan_cd",    false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtCombo,  70,   daCenter,  true,  "bkg_de_term_cd", false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtCombo,  80,   daCenter,  true,  "trsp_mod_cd",    false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   50,  daLeft,    true,  "pctl_imdg_clss_ctnt",       false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   150,  daLeft,    true,  "cnst_rmk",       false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   60,   daCenter,  true,  "cre_ofc_cd",     false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,   80,   daCenter,  true,  "cre_usr_id",     false,     "",       dfNone,        0,        false,      false);
            InitDataProperty(0, cnt++ , dtData,    1,     daCenter,   true,   "dummy",       false,      "",    dfNone,         0,        false,       false);

            InitDataCombo(0, "pctl_io_bnd_cd", "I/B|O/B", "I|O");
            InitDataCombo(0, "bkg_de_term_cd", "ALL|CY|Door", "A|Y|D");
            InitDataCombo(0, "trsp_mod_cd", "ALL|TD|RD|RT|WD|WT|WR", "AL|TD|RD|RT|WD|WT|WR");
            
            CountPosition = 0;
            SelectionMode = smSelectionFree;
            
            WaitImageVisible=false;
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
                     formObj.f_cmd.value = SEARCHLIST;
             		node_div.style.visibility = "hidden";
            		link_div.style.visibility = "hidden";
            		route_div.style.visibility = "hidden";
            		inland_div.style.visibility = "hidden";
                     var sXml = sheetObj.GetSearchXml("ESD_PRD_0082GS.do?pctl_no="+formObj.pctl_no.value+ "&pop_mode=1&display=1,0,1,1,1&func=", PrdFQString(formObj));
                     var arrXml = sXml.split("|$$|");
                     	
                     for(var idx = 0; idx < arrXml.length; idx++){
                        sheetObjects[idx].LoadSearchXml(arrXml[idx]);
                        
                        for(var i = sheetObjects[idx].HeaderRows ; i < sheetObjects[idx].Rows ; i++){
	                        if(sheetObjects[idx].CellValue(i,'svc_use_flg')=='N'){
	                            sheetObjects[idx].RowFontColor(i)  =sheetObjects[idx].RgbColor(255,0,0);
	                        }
                        }
                    }
                    for (var idx = 0; idx < 4; idx ++) {
                        if (sheetObjects[idx].CellValue(1,'svc_use_flg') == 'Y' || sheetObjects[idx].CellValue(1,'svc_use_flg') == 'N' ) {
                    		sheetObjects[idx].style.height = 110;
                        	if(idx==0){
                        		node_hd_div.style.display = "block";
                        		node_div.style.visibility = "visible";
                        	} else if (idx == 1) {
                        		link_hd_div.style.display = "block";
                        		link_div.style.visibility = "visible";
                        	} else if (idx == 2) {
                        		route_hd_div.style.display = "block";
                        		route_div.style.visibility = "visible";
                        	} else if (idx == 3) {
                        		inland_hd_div.style.display = "block";
                        		inland_div.style.visibility = "visible";
                        	}
                        } else {
                        	if(idx==0){
                        		node_div.style.display = "none";
                        	} else if (idx == 1) {
                        		link_div.style.display = "none";
                        	} else if (idx == 2) {
                        		route_div.style.display = "none";
                        	} else if (idx == 3) {
                        		inland_div.style.display = "none";
                        	}
                        }
                    }
                    if(ComGetEtcData(arrXml[0],"CA_CNST")=="Y"){
                    	canada_hd_div.style.display  = "block";
           		 	}else {
           		 		canada_hd_div.style.display = "none";
           		 	}
                 }
             
             break;

         }
     }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
    
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
    */
    function tab2_OnChange(tabObj , nItem){

        var objs = document.all.item("tabLayer2");

            objs[nItem].style.display = "Inline";
            objs[beforetab2].style.display = "none";

            //--------------- 요기가 중요 --------------------------//
            objs[beforetab2].style.zIndex = objs[nItem].style.zIndex -1 ;
            //------------------------------------------------------//
            beforetab2= nItem;
    }
     
    function sheet4_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

//    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//        var chkPnt = 0;
//        for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
//            if(sheetObj.CellValue(i,'svc_use_flg')=='N'){
//                sheetObj.RowFontColor(i)  =sheetObj.RgbColor(255,0,0);
//            }
//            if(sheetObj.CellValue(i,'port_pnt_cd')!=''){
//                if(sheetObj.CellValue(i,'port_pnt_cd').length>0){
//                    chkPnt++;
//                }
//            }
//        }
//        if(chkPnt==0){
//            sheetObj.ColHidden(2) = true;
//        }
//        
//    }    

 	 	/**
 	     * OnClick 이벤트 발생시 호출되는 function <br>
 	     * 주소입력시 메모장을 화면에 표시한다. <br>
 	     * @param sheetObj
 	     * @param Row
 	     * @param Col
 	     * @param Value
 	     */
 	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
 	    	sheetCommonMemoPad(sheetObj, Row, Col, Value);
 	    }
  	    function sheet2_OnClick(sheetObj, Row, Col, Value) {
  	    	sheetCommonMemoPad(sheetObj, Row, Col, Value);
  	    }
  	    function sheet3_OnClick(sheetObj, Row, Col, Value) {
  	    	sheetCommonMemoPad(sheetObj, Row, Col, Value);
  	    }
   	    function sheet4_OnClick(sheetObj, Row, Col, Value) {
   	    	sheetCommonMemoPad(sheetObj, Row, Col, Value);
   	    }
 	    function sheetCommonMemoPad(sheetObj, Row, Col, Value) {
  		    // 셀 클릭시 MemoPad를 표시한다.(MemoPad 편집가능)
  		    var colname = sheetObj.ColSaveName(Col);  	 
  	     	switch(colname){
  	 	    	case "cnst_rmk":
  	 	    		ComShowMemoPad(sheetObj,Row,Col,true,200,200); 
  	 	    		break;
  	 	    	default : 
  	 	    		break;
  	     	}
  	    }