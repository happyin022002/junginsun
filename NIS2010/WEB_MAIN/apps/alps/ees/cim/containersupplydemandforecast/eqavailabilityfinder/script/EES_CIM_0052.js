/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0052.js
*@FileTitle : Past BR
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.02.18 김종준
* 1.0 Creation
=========================================================*/

    /**
    * @extends 
    * @class EES_CIM_0052 : EES_CIM_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_CIM_0052() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
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
                case "btn_Downexcel":
                    doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "Pick-up\nDate|Yard|BKG No.|TP/SZ|Vol|1st  VVD|ETA|Rev.\nTerm|BKG OFC|CMDT|BKG\nDate|Internal Remark";
                    var headCount = ComCountHeadTitle(HeadTitle1);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);

                    CountPosition = 0;  //페이지카운트 없애기

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    sheetObj.FrozenCols = 5; 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenterTop,	true,  "fcast_dt",      false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         60,     daCenterTop,	true,  "yd_cd",   		false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         90,     daCenterTop,	true,  "bkg_no",        false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         50,     daCenter,   	true,  "cntr_tpsz_cd",  false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         40,     daRight,   		true,  "cntr_vol_qty",  false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   	true,  "vvd",         	false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   	true,  "eta",           false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    	true,  "rcv_term_cd",   false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         55,     daCenter,    	true,  "bkg_ofc_cd",    false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         200,    daLeft,    		true,  "cmdt_nm",       false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    	true,  "bkg_cre_dt",    false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         200,    daLeft,    		true,  "inter_rmk",     false,  "", dfNone);
               }
               break;
            case "sheet2":      //sheet1 init
            	with (sheetObj) {

                    // 높이 설정
                    style.height = 50;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
                  
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"d2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"d4_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"d5_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"d7_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"r2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"r5_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"o2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"s2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"o4_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"s4_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"f2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"a2_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"f4_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"a4_qty",	false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		55,	daRight,		true,	"f5_qty",	false,	"",	dfNullInteger);
                       
                    SetSortDialog(false);
                    CountPosition = 0;
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
                sheetObj.DoSearch("EES_CIM_0052GS.do",FormQueryString(formObj));
            	ComOpenWait(false);             	
                break;
            case IBDOWNEXCEL:      // 입력
                if(sheetObjects[0].RowCount > 0){
	    			sheetObjects[0].SpeedDown2Excel(0,false,false,'','',false,false,'',false,'','',false,'',false);
		            if(sheetObjects[1].RowCount > 0){
		            	sheetObjects[1].SpeedDown2Excel(1,true,false,'','',false,false,'',false,'','',false,'',false);
	    	        }
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
    	 if( sheetObj.RowCount == 0 ){
    		 return;
    	 }
    	 
    	 sheetObjects[1].Rows = 2;
    	 var d2_qty = 0;
    	 var d4_qty = 0;
    	 var d5_qty = 0;
    	 var d7_qty = 0;
    	 var r2_qty = 0;
    	 var r5_qty = 0;
    	 var o2_qty = 0;
    	 var s2_qty = 0;
    	 var o4_qty = 0;
    	 var s4_qty = 0;
    	 var f2_qty = 0;
    	 var a2_qty = 0;
    	 var f4_qty = 0;
    	 var a4_qty = 0;
    	 var f5_qty = 0;
         
    	 for( var i=0; i<=sheetObj.LastRow; i++ ){
    	 	var cntr_vol_qty = ComReplaceStr(sheetObj.CellValue(i, "cntr_vol_qty"),",","");
    	 	
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'D2' ){
    	 		d2_qty = d2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'D4' ){
    	 		d4_qty = d4_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'D5' ){
    	 		d5_qty = d5_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'D7' ){
    	 		d7_qty = d7_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'R2' ){
    	 		r2_qty = r2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'R5' ){
    	 		r5_qty = r5_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'O2' ){
    	 		o2_qty = o2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'S2' ){
    	 		s2_qty = s2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'O4' ){
    	 		o4_qty = o4_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'S4' ){
    	 		s4_qty = s4_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'F2' ){
    	 		f2_qty = f2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'A2' ){
    	 		a2_qty = a2_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'F4' ){
    	 		f4_qty = f4_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'A4' ){
    	 		a4_qty = a4_qty + eval(cntr_vol_qty);
    	 	}
    	 	if ( sheetObj.CellValue(i,"cntr_tpsz_cd") == 'F5' ){
    	 		f5_qty = f5_qty + eval(cntr_vol_qty);
    	 	}
    	 }
         
    	 sheetObjects[1].CellValue2(1,"d2_qty") =  d2_qty;
    	 sheetObjects[1].CellValue2(1,"d4_qty") =  d4_qty;
    	 sheetObjects[1].CellValue2(1,"d5_qty") =  d5_qty;
    	 sheetObjects[1].CellValue2(1,"d7_qty") =  d7_qty;
    	 sheetObjects[1].CellValue2(1,"r2_qty") =  r2_qty;
    	 sheetObjects[1].CellValue2(1,"r5_qty") =  r5_qty;
    	 sheetObjects[1].CellValue2(1,"o2_qty") =  o2_qty;
    	 sheetObjects[1].CellValue2(1,"s2_qty") =  s2_qty;
    	 sheetObjects[1].CellValue2(1,"o4_qty") =  o4_qty;
    	 sheetObjects[1].CellValue2(1,"s4_qty") =  s4_qty;
    	 sheetObjects[1].CellValue2(1,"f2_qty") =  f2_qty;
    	 sheetObjects[1].CellValue2(1,"a2_qty") =  a2_qty;
    	 sheetObjects[1].CellValue2(1,"f4_qty") =  f4_qty;
    	 sheetObjects[1].CellValue2(1,"a4_qty") =  a4_qty;
    	 sheetObjects[1].CellValue2(1,"f5_qty") =  f5_qty;
    	     	
         sheetObj.SelectHighLight = false;
     }
     
     /**
      * 셀을 클릭했을때 발생하는 이벤트
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	sheetObj.SelectHighLight = true;
     }	     