/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1048.js
*@FileTitle  : MTY Repo In 상세내역 조회 및 Discharging List 수기수정
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
    var headCount=0;
    var headCount2=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var to_yd_cd=""; // yard cd 조회
    var to_yd_nm="";
    var to_etb_dt="";  
    var IBSEARCH02=30;    
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
            	case "btn_RowAdd":
            		sheetObjects[1].DataInsert(0);
            		//sheetObjects[1].CellEditable(0, "to_etb_day")= false;
            		sheetObjects[1].SetMergeCell(sheetObjects[1].LastRow(), 1, 1, 5);
            		sheetObjects[1].InitCellProperty(1, "to_yd_cd",{ Type:"Combo"} );
            		sheetObjects[1].InitCellProperty(1, "to_etb_dt",{ Type:"Combo"} );
            		sheetObjects[1].CellComboItem(1,"to_yd_cd", {ComboText:"|"+to_yd_cd, ComboCode:"|"+to_yd_cd} );
            		sheetObjects[1].CellComboItem(1,"to_etb_dt", {ComboText:"|"+to_etb_dt, ComboCode:"|"+to_etb_dt} );
//	                InitDataCombo(0, "to_yd_cd", to_yd_cd, to_yd_cd, " ","");
//	                InitDataCombo(0, "to_etb_dt", " |"+to_etb_dt, " |"+to_etb_dt, " ","");	            	
            		for ( var j=6; j<headCount2-1; j++ ) {
            			if(sheetObjects[1].ColSaveName(j).substring(3) == "fcast_qty"){
            				//alert(j + " : " +sheetObjects[1].ColSaveName(j));
            				sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), j,0,0);
            			}
            		}            		            
            		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cre_seq",1,0);
            		break;
                case "btn_Delete":
                	if(sheetObjects[1].FindCheckedRow("check") != ""){
    					ComRowHideDelete(sheetObjects[1],"check"); 
    					sheetObjects[1].SetMergeCell(sheetObjects[1].LastRow(), 1, 1, 5);
    				}
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
                    break;
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
    	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);    	
        for(i=0;i<sheetObjects.length;i++){        
            ComConfigSheet (sheetObjects[i] );  //khlee-시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);        
            ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
        }
        if(document.form.curr_flag.value == "T"){
        	document.all.dis_vol.style.display="Inline";
        }
        var level_cd=document.form.level_cd.value;
        // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
        if(level_cd != "1") {
        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
        	ComBtnDisable("btn_RowAdd");  // ROW ADD 버튼 잠금
        	ComBtnDisable("btn_Delete");  // ROW DELETE 버튼 잠금
        	sheetObjects[1].SetEditable(0);// 2번째 쉬트 잠금
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
                    var HeadTitle="Del.|Yard|Lane|VVD|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark||||||";
                    headCount2=ComCountHeadTitle(HeadTitle);
                    sheetObj.FrozenCols=6;
                    SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:0, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                        {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
                        {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                        {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_dt",      KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Date",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_day",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"r9_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                        {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:1,   SaveName:"remark",         KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"div",            KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"lvl",            KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_seq",        KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_seq",        KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_dt_org",  KeyField:0,   CalcLogic:"",   Format:"" },
                        {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                    InitColumns(cols);
                    SetEditable(1);
                    SetColProperty("to_etb_dt", {ComboText:"|"+to_etb_dt, ComboCode:"|"+to_etb_dt} );
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
                var sXml=sheetObj.GetSearchData("EES_EQR_1048GS.do",FormQueryString(formObj));
                if(formObj.curr_flag.value == "T"){
                	var arrXml=sXml.split("|$$|");
                	sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
                	sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
                }else{
                	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
                }
                ComOpenWait(false); 
                break;
    		case IBSEARCH02:      //공통조회
    			form.f_cmd.value=SEARCH02;
    			var sXml=sheetObj.GetSearchData("EES_EQR_1048GS.do" , FormQueryString(form));
    			to_yd_cd=ComGetEtcData(sXml,"to_yd_cd");
    			to_yd_nm=ComGetEtcData(sXml,"to_yd_nm");
    			to_etb_dt=ComGetEtcData(sXml,"to_etb_dt");
    			break;
            case IBDOWNEXCEL:      // 입력
            	if(formObj.curr_flag.value == "T"){	
            		sheetObjects[0].Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
            		sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
            	}else{
            		sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
            	}
            	break;
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){            		           	            		
		        	sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true); 
		            formObj.f_cmd.value=MULTI;
		            sheetObj.DoSave("EES_EQR_1048GS.do",FormQueryString(formObj), "ibflag");
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
       if(sheetObj.RowCount()==1) {
    	   sheetObj.RowDelete(sheetObj.LastRow()-1, false);
       }else if(sheetObj.RowCount()> 1) {
    	 sheetObj.RowDelete(sheetObj.LastRow()-1, false);
  	  	 // 색상변경
  	  	 for ( var j=6; j<=21; j++ ) {
  	  		 if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) > 0 ) {
  	  			 sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#0000FF");
 	  		}
  	  		 if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) < 0 ) {
  	  			 sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#FF0000");
 	  		}
  	  	 } 
  //no support[check again]CLT 	  	 sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
  	  	 for(var i=0; i<=sheetObj.LastRow(); i++){
  	  		 // cre_seq = 'N' 은 라인전체 수정 불가, Remark 만 수정 가능 			
  	  		 if(sheetObj.GetCellValue(i,"cre_seq") == '0') {
  	  			 //sheetObj.RowEditable(i) = false;
  	  			 for ( var j=0; j<=sheetObj.LastCol(); j++ ) {
  	  				sheetObj.SetCellEditable(i, j,0);
  	  			 }
  	  			 sheetObj.SetCellEditable(i, "remark",1);// remark 만 수정으로 변경
  	  		 }else if(sheetObj.GetCellValue(i,"cre_seq") == '1') { // 1은 적색으로 표시(수정 가능)
  	  			for ( var j=6; j<=21; j++ ) {  // QTY 만 대상
  	  				if(sheetObj.GetCellValue(i,j) != 0) { // 0 이 아니면 대상
  	  					sheetObj.SetCellFontColor(i,j,"#FF0000");// red
  	  				}
  	  			} 
  	  		 }	  			
  	  	 }
  	  	 sheetObj.SetMergeCell(sheetObj.LastRow(), 1, 1, 5);
  //no support[check again]CLT 	  	 sheetObj.SetSumBackColor(sheetObj.WebColor2SysColor("#D3EBED"));
  	  	 sheetObj.SetSumFontBold(1);
  	   }
       //no support[implemented common]CLT sheetObj.SelectHighLight=false;
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
    //no support[implemented common]CLT 		 sheetObj.SelectHighLight=false;
   			sheetObj.SetRowBackColor(row,-1);
    	 } else {
    //no support[implemented common]CLT 		 sheetObj.SelectHighLight=true;
    	 }
     } 	
     /**
      * 셀에 키입력 했을때 발생하는 이벤트 <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {ibsheet} row     	sheetObj의 선택된 Row
      * @param {ibsheet} col     	sheetObj의 선택된 Col
      **/
     function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	 var formObj=document.form;
    	 with(sheetObj){
    		 switch (ColSaveName(Col)) {
    		 	 case "vvd":    		 	
    		 		if(Value.length != 9){
	     				ComShowCodeMessage("EQR90078","9");
	     				SetCellValue(Row, Col,"",0);
	     				SelectCell(Row, Col);
	     			}else{	//VVD로 lane 조회 및 from, to yard combo list 만들기
		      			SetWaitImageVisible(0);
		                ComOpenWait(true); 
		                formObj.f_cmd.value=SEARCH01;
		                var sXml=GetSearchData("EES_EQR_1048GS.do",FormQueryString(formObj)+"&vvd="+Value);
		                var arrXml=sXml.split("|$$|");
		                var slnaCd=ComGetEtcData(arrXml[0], "slan_cd");
		                if(slnaCd != ""){
		                	SetCellValue(Row, "vsl_lane_cd",slnaCd,0);
//				            var toYdCdArr = ComXml2ComboString(arrXml[0], "to_yd_cd", "to_etb_dt");
//
//				            if(ComGetTotalRows(arrXml[0]) > 0){
//				            	sheetObj.InitCellProperty(Row, "to_yd_cd", dtCombo); // CELL TYPE을 DTDATA으로 변경
//				            	sheetObj.CellComboItem(Row, "to_yd_cd", "|"+toYdCdArr[0], "|"+toYdCdArr[1]);
//								CellValue2(Row, "to_yd_cd") = "";
//								CellValue2(Row, "to_etb_dt") = "";
//								CellValue2(Row, "to_etb_day") = "";
//							}
			                ComOpenWait(false);
		                }else{
		                    ComOpenWait(false);
		                    ComShowCodeMessage("EQR90001","accurate vvd code");
		                    SetCellValue(Row, "vvd","",0);
		                    SelectCell(Row, Col);
		                }
	     			}
    		 		break;    
     			case "to_yd_cd":
     				// location code 검색
     				// YD CD 를 선택하면 ETB, DAY 를 셋팅한다.
//     				if(Value.length > 7){
//     					var toYdDt = Value.split("%%");
//     					CellValue2(Row, "to_etb_dt") = toYdDt[0]; // date
//     					CellValue2(Row, "to_yd_cd")  = toYdDt[1]; 
//     					CellValue2(Row, "to_etb_day")= toYdDt[2]; // 요일표시
//    	     			
//     				}
        			break;  	
    		 }
    	 }
     }
     /**
      * 저장 완료시 처리
      */
     function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
  		save_flag=true;
  		if ( ErrMsg == "" ) {
  			if ( save_flag ) { 
  		    	var opener_obj=window.opener;
  		    	var week_seq=formObj.dp_seq.value;
  		    	var sheet_row=formObj.row.value;
//	    		alert("sheet_num : "+sheet_num);
//		    	alert("sheet_row : "+sheet_row);  		    	
  		    	for ( var j=6; j<=21; j++ ) { // QTY 만 선택
  		    		if ( sheetObjects[1].RowCount()> 0 ) {
  		    			//alert(sheetObjects[1].CellValue(sheetObjects[1].LastRow, sheetObjects[1].ColSaveName(j)));
  		    			// sheet, row, save name, value
  		    			//alert("savename : "+sheetObjects[1].ColSaveName(j).substr(0,2)+"_q" + ", value : "+sheetObjects[1].CellValue(sheetObjects[1].LastRow, sheetObjects[1].ColSaveName(j)) );  
  		    			opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[1].ColSaveName(j).substr(0,2), sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), sheetObjects[1].ColSaveName(j)));
  		    		} else { //sheet_num
  		    			// 0 으로 셋팅합니다.(모두 삭제한 경우)
  		    			opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[1].ColSaveName(j).substr(0,2), 0);
  		    		}
  		    	}
  			}
  			ComShowCodeMessage("EQR70002");
  		}
     }     
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj){
			switch (sAction) {
			case IBSAVE:
				for(var i=1; i <= LastRow(); i++){
					if(GetRowStatus(i) == "I"  ) {
//					    if(CellValue(i, "vvd") == "" || CellValue(i, "vvd") == null) {
//							ComShowCodeMessage("COM130403", "VVD");
//							SelectCell(i, "vvd");
//							return false;
//						}else 
						if(GetCellValue(i, "to_yd_cd") == "" || GetCellValue(i, "to_yd_cd") == null) {
							ComShowCodeMessage("COM130403", "Yard");
							SelectCell(i, "to_yd_cd");
							return false;							
						}	
					}
					var qty_vol=0;
					if(GetRowStatus(i) == "I" || GetRowStatus(i) == "U"  ) {
						for ( var j=6; j<=21; j++ ) { // QTY 만 선택
							qty_vol += sheetObjects[1].GetCellValue(i, sheetObjects[1].ColSaveName(j));
						}
						if(qty_vol==0) {
							ComShowCodeMessage("COM130403", "QTY Volume");
							return false;	
						}
					}
					// 삭제표시
					if(GetCellValue(i, "check") != "") {
						sheetObj.SetRowStatus(i,"D"
					}
				}
				// 중복체크
//				var index = sheetObj.ColValueDup('vvd|to_yd_cd|to_etb_dt|to_etb_day');
//                if(index != -1) {                				
//                	//ComShowMessage('Data Duplicate');
//			        ComShowCodeMessage("EQR90009");
//			        SelectCell(index, 'to_yd_cd');               
//			                    	
//			        return false;
//              	
//                }   
				break;
			}
	    }
	    return true;
	}