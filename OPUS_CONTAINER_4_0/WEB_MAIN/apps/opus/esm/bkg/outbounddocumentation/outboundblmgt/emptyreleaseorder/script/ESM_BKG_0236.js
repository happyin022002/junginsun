/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0236.js
*@FileTitle  : OPUS Container Office Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
	var currRows=0;
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	    function processButtonClick(){
	        /***** using extra sheet valuable if there are more 2 sheets *****/
	        var sheetObject = sheetObjects[0];
	        /*******************************************************/
	        var formObject=document.form;
	    	try {
	    		var srcName= ComGetEvent("name");
	            switch(srcName) {
				case "btn_Retrieve":
			        formObject.ldf_dl_dt.value = "";
			        formObject.bkg_ofc_cd.value = "";
					sheetObjects[0].RemoveAll();
	                tabObjects[0].SetTabDisable(0 , false); 
	                tab1.SetTabDisable(1, true);	                
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	            case "btn_Close":
	            	ComClosePopup(); 
	            	break;
	            case "btn_retry":
					doActionIBSheet(sheetObjects[0],document.form,"btn_retry");
	            	break;
				case "btns_calendar":
					var cal=new ComCalendar();
					cal.select(formObject.ldf_dt, 'yyyy-MM-dd');
					break;
		        } // end switch
	    	}catch(e) {
	    		if( e == "[object Error]") {
	     			ComShowCodeMessage("COM12111");
	    		} else {
	    			ComShowMessage(e.message);
	    		}
	    	}
	    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++]=tabObj;
    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	for (var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k], k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
    	for(i=0;i<sheetObjects.length;i++){        	  
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
        tab1.SetTabDisable(1, true);
        tab1sheet1_OnLoadFinish(sheetObjects[0]);// 메서드 존재시 반드시 참조
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt=0 ;
			InsertItem( " Header ", "");
			InsertItem( " Detail", "");
        }
    }

    function initControl() {
        axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
   	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="Chk.||Send Time|Office|File Name|Send YN|From Date|To Date";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Radio",     Hidden:0, Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"slct_flg",     KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     					  {Type:"Text",      Hidden:1, Width:0,    	Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:"ldf_dl_dt",   	KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:80,  	Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",	KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"file_dl_nm",  	KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"file_dl_flg",  KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:120,  	Align:"Left",  	 ColMerge:1,   SaveName:"bkg_fm_dt",   	KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0, Width:120,  	Align:"Left",  	 ColMerge:1,   SaveName:"bkg_to_dt",   	KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(330);
                 }
            break;
            case 2:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="Chk.||Send Time|Office|Booking No.|Send YN|From Date|To Date";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Radio",     Hidden:1, Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"radio",        KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     					  {Type:"Text",      Hidden:1, Width:0,    	Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                          {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:"ldf_dl_dt",   	KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:0, Width:80,  	Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",	KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",  	KeyField:0,   CalcLogic:"",   Format:"" } ];
		             InitColumns(cols);
		             SetEditable(0);
		             SetSheetHeight(350);
                 }
            break;
        }
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * (***** 기본 Event (중요) *****)
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
        beforetab=nItem;
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function tab1sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Select Object 생성
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }    
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0236GS.do", FormQueryString(formObj)+"&"+ "page_no=1" ,{Sync:2} );
			break;
        
        case SEARCH02:      //Retrieve
			formObj.f_cmd.value=SEARCH02;
			sheetObj.DoSearch("ESM_BKG_0236GS.do", FormQueryString(formObj)+"&"+ "page_no=1" ,{Sync:2} );
			break;
		case "btn_retry":      //retry
			if(!validateForm(sheetObj,formObj,sAction))  return false;
			var row = "0";
	        for (var i=1; i <= sheetObjects[0].LastRow(); i ++) {	        	
	    		if (sheetObjects[0].GetCellValue(i,"slct_flg") == "1") {
	    			row = i;
	    			formObj.ldf_dl_dt.value = sheetObjects[0].GetCellValue(i, "ldf_dl_dt");
	    			formObj.bkg_ofc_cd.value = sheetObjects[0].GetCellValue(i, "bkg_ofc_cd");
	    			formObj.bkg_fm_dt.value = sheetObjects[0].GetCellValue(i, "bkg_fm_dt");
	    			formObj.bkg_to_dt.value = sheetObjects[0].GetCellValue(i, "bkg_to_dt");
	    			formObj.file_dl_nm.value = sheetObjects[0].GetCellValue(i, "file_dl_nm");
	    		}
	        }
			formObj.f_cmd.value=MULTI01;
 			var sXml=sheetObj.GetSaveData("ESM_BKG_0236GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml, "SuccessYn") == "Y" || ComGetEtcData(sXml, "SuccessYn") == "R"){
//				sheetObjects[0].SetCellValue(row, "file_dl_nm", ComGetEtcData(sXml, "fileNm"));
//				sheetObjects[0].SetCellValue(row, "file_dl_flg", "Y");
				ComShowCodeMessage("BKG00166");
			}else{
				ComShowCodeMessage("BKG00167");
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 	case IBSEARCH: 
	 		if (ComChkLen(formObj.hndl_ofc_cd,2) < 1 ) {
	 			ComShowCodeMessage("BKG00186");
				formObj.cust_cnt_cd.focus();
				return false;
			}
			break;
		case "btn_retry":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} else if (sheetObj.CheckedRows("slct_flg") > 0) {
				if(ComShowCodeConfirm('BKG95003', 'Retry')){
					return true;
				}else{
					return false;
				}
			}
			break;
			
		break;
	  }
      return true;
    }
    
	function sheet1_OnClick(sheetObj, row, col, val) {
		if ( col == 0) {
			if (sheetObjects[0].GetCellValue(row, "slct_flg") == "1" && sheetObjects[0].GetCellValue(row, "file_dl_flg") != "N") {
				document.form.btn_retry.disabled=true;
			}else{
				document.form.btn_retry.disabled=false;
			}
		}
	}

	function sheet1_OnDblClick(sheetObj, row, col) {
        var formObject=document.form;
        formObject.ldf_dl_dt.value = sheetObj.GetCellValue(row, "ldf_dl_dt");
        formObject.bkg_ofc_cd.value = sheetObj.GetCellValue(row, "bkg_ofc_cd");
        sheetObjects[1].RemoveAll();    // sheet2 Clear
    	doActionIBSheet(sheetObjects[1],document.form,SEARCH02);
	}

    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (sheetObj) {
            if (RowCount()> 0) {
                tabObjects[0].SetTabDisable(1 , false); 
            }
        }
    }
	