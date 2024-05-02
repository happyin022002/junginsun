/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0074.jsp
*@FileTitle  : Prepayments Settlement / Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
				case "btn_confirm":
					comPopupOK();
	            break;
				case "btn_close":
					ComClosePopup(); 
				break;  
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
     /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	//initControl();
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
            	//UI개선(201408 민정호)
                var HeadTitle="||Seq|Description|CSR Number|Slip SEQ|Account Code|Curr|Amount";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
                       //UI개선(201408 민정호)     
                       {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       //UI개선(201408 민정호)                       
                       {Type:"CheckBox",  Hidden:1, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"checkbox",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       //{Type:"CheckBox",  Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"checkbox"},
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:175,  Align:"Center",  ColMerge:0,   SaveName:"org_slip_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"slp_seq_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_tp_cd" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_func_cd" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_ofc_cd" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_iss_dt" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_ser_no" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ctr_cd" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"slp_loc_cd" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vvd_exp_dt" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vvd_eff_dt" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"inv_seq" } ];
                 
                InitColumns(cols);

                SetEditable(1);
                
                SetSheetHeight(240); 
               }
                break;
        }
    }
    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction, col) {
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      //조회
       			formObj.f_cmd.value=SEARCH;
         	   	sheetObj.DoSearch("ESM_FMS_0074GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(new Array("popup")) );
        		break;
        }
    }
   /**
      * IBSheet를 조회 후 실행되는 이벤트
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	
	}
	/* 개발자 작업  끝 */
