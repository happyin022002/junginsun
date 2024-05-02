/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1044.js
*@FileTitle  : MTY Repo In/ Out Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt=0;
        var sheetObject=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_downexcel":
                    if(sheetObjects[1].RowCount()> 0){
                        doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
                    }
                    break;
                case "btn_Close":
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
        //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        if(document.form.curr_flag.value == "T"){
        	document.all.dis_vol.style.display="Inline";
        }
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                var HeadTitle="Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark|";
                headCount=ComCountHeadTitle(HeadTitle);
                sheetObj.FrozenCols=5;
                SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" },
              {Type:"Date",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_day",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r9_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
              {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"" },
              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"" } ];
                InitColumns(cols);
                SetEditable(0);
                SetSheetHeight(200);
               }
               break;
            case "sheet2":      //sheet1 init
            with (sheetObj) {
                if(document.form.curr_flag.value == "T"){
                    SetSheetHeight(300);
                    }else{
                    SetSheetHeight(522);
                    }
                    var HeadTitle="Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark|";
                    headCount=ComCountHeadTitle(HeadTitle);
                    sheetObj.FrozenCols=5;
                    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:0, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                        {Type:"Date",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_day",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r9_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"" } ];
                    InitColumns(cols);
                    SetEditable(0);
           }
           break;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //조회
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true); 
                formObj.f_cmd.value=SEARCH;
                sheetObj.RenderSheet(0);
                var sXml=sheetObj.GetSearchData("EES_EQR_1044GS.do",FormQueryString(formObj));
                if(formObj.curr_flag.value == "T"){
                	var arrXml=sXml.split("|$$|");
                	sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
                	sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
                }else{
                	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
                }
                ComOpenWait(false); 
                break;
            case IBDOWNEXCEL:      // 입력
            	if(formObj.curr_flag.value == "T"){	
            		if(sheetObjects[0].RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            		}else{
            				sheetObjects[0].Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
            			}
            		if(sheetObj.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            		}else{
            				sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
            			}
            	}else{
            		if(sheetObj.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            		}else{
            				sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
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
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
    	 if(sheetObj.RowCount()> 0) {
    		 for(var i=0; i<=sheetObj.LastRow(); i++){
    			 if (sheetObj.GetCellValue(i,"lvl") == '111111') {
					sheetObj.SetCellFont("FontBold", i,"to_yd_cd",1);
					sheetObj.SetCellFont("FontBold", i,"vsl_slan_cd",1);
					sheetObj.SetCellFont("FontBold", i,"vvd",1);
					sheetObj.SetCellFont("FontBold", i,"total",1);
    				 for ( var j=5; j<=20; j++ ) {
    					 sheetObj.SetCellFont("FontBold", i,j,1);
    				 }
    				 for ( var j=0; j<headCount; j++ ) {
    					 if ( j < 4 ) {
    						 sheetObj.SetCellValue(i,j,'');
    					 } else {
    						 sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j));
    					 }
    				 }
    			 } 
			}
    		sheetObj.SetCellValue(sheetObj.LastRow(),"to_yd_cd",'MTY Repo. In Total',0);
    		sheetObj.SetCellAlign(sheetObj.LastRow(),"to_yd_cd","Center");
			sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 4);
//no support[check again]CLT 			sheetObj.SetSumBackColor(sheetObj.WebColor2SysColor("#D3EBED"));
			sheetObj.SetSumFontBold(1);
			for ( var j=5; j<=20; j++ ) {
				if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) > 0 ) {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#0000FF");
				}
				if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) < 0 ) {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#FF0000");
				}
			} 
//no support[check again]CLT 			sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
    	 }
    //no support[implemented common]CLT 	 sheetObj.SelectHighLight=false;
    	 sheetObj.RenderSheet(1);
     }
 /**
  * Tab1 조회종료
  * Tab1 조회종료후 이벤트 호출
  */
  function sheet2_OnSearchEnd(sheetObj, msg){
 	 if(sheetObj.RowCount()> 0) {
 		 for(var i=0; i<=sheetObj.LastRow(); i++){
 			 if (sheetObj.GetCellValue(i,"lvl") == '111111') {
				sheetObj.SetCellFont("FontBold", i,"to_yd_cd",1);
				sheetObj.SetCellFont("FontBold", i,"vsl_slan_cd",1);
				sheetObj.SetCellFont("FontBold", i,"vvd",1);
				sheetObj.SetCellFont("FontBold", i,"total",1);
 				 for ( var j=5; j<=20; j++ ) {
 					 sheetObj.SetCellFont("FontBold", i,j,1);
 				 }
 				 for ( var j=0; j<headCount; j++ ) {
 					 if ( j < 4 ) {
 						 sheetObj.SetCellValue(i,j,'');
 					 } else {
 						 sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j));
 					 }
 				 }
 			 } 
		}
 		sheetObj.SetCellValue(sheetObj.LastRow(),"to_yd_cd",'MTY Repo. In Total',0);
 		sheetObj.SetCellAlign(sheetObj.LastRow(),"to_yd_cd","Center");
		sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
		sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 4);
//no support[check again]CLT 		sheetObj.SetSumBackColor(sheetObj.WebColor2SysColor("#D3EBED"));
		sheetObj.SetSumFontBold(1);
		for ( var j=5; j<=20; j++ ) {
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) > 0 ) {
				sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#0000FF");
			}
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) < 0 ) {
				sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#FF0000");
			}
		} 
//no support[check again]CLT 		sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
 	 }
 //no support[implemented common]CLT 	 sheetObj.SelectHighLight=false;
 	 sheetObj.RenderSheet(1);
  }
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	if ( row == sheetObj.LastRow()) {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
      		sheetObj.SetRowBackColor(row,-1);
      	} else {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
      	}
     }	    
  /**
   * 셀을 클릭했을때 발생하는 이벤트 <br>
   * 선택시 선택행 배경색 세팅
   */
  function sheet2_OnClick(sheetObj, row, col, value) {
   	if ( row == sheetObj.LastRow()) {
       //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
   		sheetObj.SetRowBackColor(row,-1);
   	} else {
       //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
   	}
  }