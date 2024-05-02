/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_SPC_0070.js
 *@FileTitle : No-Show Adjustment
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
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
     * @class ESM_SPC_0070 : ESM_SPC_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive=false;
    var tab_retrives=null;
    var searchParams="";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    var init_year='';
    var init_week='';
    var init_month=''; 
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
        	//try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
        	            break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObjects)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll();
    					formObject.year.value=init_year;
    					formObject.week.value=init_week;
    		    		formObject.month.value=init_month;
    		    		SpcSearchOptionWeek("week",true,document.form.year.value);
						SpcSearchOptionTrade("trade", true, true);
        				SpcSearchOptionLane("lane"); // 0207 SHKIM    
    					break;
            	    case "btn_save":
            	    	doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
            	        break;
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
            	        break;
    			} // end switch
        	//}catch(e) {
        	//	if( e == "[object Error]") {
        	//		ComShowCodeMessage("COM12111");
        	//	} else {
        	//		ComShowMessage(e);
        	//	}
        	//}
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++]=combo_obj;
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
         * tab1_OnChange 
         * 
         */
        function tab1_OnChange(tabObj , nItem)
        {
    	    var formObj=document.form;
            var objs=document.all.item("tabLayer");
        	objs[nItem].style.display="Inline";
        	objs[beforetab].style.display="none";
        	//--------------- 여기가 중요--------------------------//
        	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab=nItem;
    		//if(!check_retrive) 
    		return;
            if(beforetab==0){
            	searchSummary(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
            }else if(beforetab==1){
            	searchByTrade(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
            }        
        }
    	/*
    	 * 입력한 Office값 체크
    	 */
    	 function office_onchange() {
    	 	var obj=ComGetEvent();
        	var value=obj.value;
        	value=value.trim();
        	if(value.length>0){
    			if(value.length<5){
    				ComShowMessage(getMsg("SPC90116", "Office"));
    				obj.focus();
    				return false;
    			}else{
    				var rtn=getCodeList("Office", "ofc_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90106", value));
    		    		obj.focus();
    		    		return false;
    		    	}	
    			}
        	}
        	return true;
        }
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionYear("year", true);
        	SpcSearchOptionMonth("month", true);
        	SpcSearchOptionWeek("week",true);
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionLane("lane");
            tab_retrives=new Array(sheetObjects.length);
            for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetResizeFull=true;
    		document_onresize();
    		for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
                tabObjects[k].SetSelectedIndex(0);
            }
            var formObject=document.form;
        	formObject.year.focus();
        	init_year=formObject.year.value;	//년 초기화용
        	init_week=formObject.week.value;	//주차 초기화용
    		init_month=formObject.month.value;	//월 초기화용
        }
        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initTab(tabObj , tabNo) {
             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt=0 ;
                        InsertItem( "Adjustment" , "");
                        InsertItem( "Download Date" , "");
                    }
                 break;
             }
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
    				initSheet1(sheetObj);
                    break;
                case 2:      //sheet1 init
    				initSheet2(sheetObj);
                    break;
            }
        }
    	/**
         * TabSheet1에서 조회후 타이틀 변경
         */
    	function initSheet1(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            //style.height = 300 ;
    	    	   
    	    	   var columnCount=28;
    	    	   (columnCount, 0 , 0, false);
    	    	   var HeadTitle1="Trade|Lane|Week|VVD|RHQ/Area|Office|POL|F'cast|F'cast|BKG|Alloc|Alloc|Diff/Shortfall|Ratio";
    	    	   var HeadTitle2="Trade|Lane|Week|VVD|RHQ/Area|Office|POL|Original|Revised|BKG|Original|Revised|Diff/Shortfall|Ratio";
    	    	   var cnt=0;

    	    	   SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

    	    	   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    	    	   var headers = [ { Text:HeadTitle1, Align:"Center"},
    	    	                   { Text:HeadTitle2, Align:"Center"} ];
    	    	   InitHeaders(headers, info);

    	    	   var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trade",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"week",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"area",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:1,   SaveName:"Fcast",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"fcast_lod_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:1,   SaveName:"BKG",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:1,   SaveName:"Alloc",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:78,   Align:"Right",   ColMerge:0,   SaveName:"aloc_lod_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	    	                {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"NoShow",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Ratio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"aloc_ddct_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ofc_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Status",    Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lvl1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lvl2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lvl3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lvl4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lvl5",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lvl",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	                {Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	    	    
    	    	   InitColumns(cols);
//    	    	   SetSheetHeight(GetRowHeight(18));
    	    	   SetSheetHeight(400);
//    	    	   SetCountPosition()(0);
    	    	   SetEditable(1);
    	    	   SetEditableColor("#FFFF80");//Default:255,255,255,흰색Edit가능데이터배경색
//    	    	   InitTreeInfo(columnCount - 2, "sLevel", "#0000FFNAN");
    	    	   var color="#555555";
    	    	   SetRangeBackColor(1, 7, 1, 8,color);
    	    	   SetRangeBackColor(1, 10, 1, 11,color);
    	    	   SetMinimumValue(0, "fcast_lod_qty",0);
    	    	   SetMinimumValue(0, "aloc_lod_qty",0);

    	       }
    	}
        /**
         * TabSheet2에서 조회후 타이틀 변경
         */
    	function initSheet2(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	    	   
    	    		   (8, 0 , 0, false);
    	    		   var HeadTitle1="Month|Date|Day|Last Exe Date";
    	    		   var cnt=0;

    	    		   SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

    	    		   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    	    		   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	    		   InitHeaders(headers, info);

    	    		   var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"month",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"ComboEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dwn_lod_dy",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	    		                {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"exe_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"sweek",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bse_yrmon",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"Status",    Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    		                {Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:1,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	    		   
    	    		   InitColumns(cols);
    	    		   if(!check_retrive){
//        	    		   SetSheetHeight(GetRowHeight(18) + 18);
    	    		   }
    	    		   SetSheetHeight(400);
//    	    		   SetGetCountPosition()(0);
    	    		   SetEditable(1);
    	    		   SetColProperty(2, {ComboText:"SUN|MON|TUE|WED|THU|FRI|SAT", ComboCode:"0|1|2|3|4|5|6"} );

    	       }
    	}
    	function t1sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "rlane_cd":
        	case "week":
        	case "area":
        	case "sls_ofc_cd":
        	case "pol_yd_cd":
        		var mark=sheetObj.GetCellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	function toggleExpand(sheetObj, row, col){
       		var mark=sheetObj.GetCellValue(row, col);
    		if(sheetObj.GetRowExpanded(row)){
    			sheetObj.SetRowExpanded(row,0);
    			cellChangeValue(sheetObj, row, col, "+");
    		}
    		else{
    			sheetObj.SetRowExpanded(row,1);
    			cellChangeValue(sheetObj, row, col, "-");
    		}
       	}
    	function cellChangeValue(sheetObj, row, col, value){
    		var status=sheetObj.GetRowStatus(row);
    		sheetObj.SetCellValue(row, col,value,0);
    		sheetObj.SetRowStatus(row,status);
    	}
    	function changePeriod(){
    		var obj=ComGetEvent();
    		if(obj.selectedIndex == 0) return;
    		switch(ComGetEvent("name")){
    		case "month":
    			obj.form.week.selectedIndex=0;
    			break;
    		case "week":
    			obj.form.month.selectedIndex=0;
    			break;
    		}
    	}
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH:      //조회
                    var sheetObj=sheetObjects[beforetab];
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  
                    if(beforetab==0){
                    	searchAdjustment(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                    }else if(beforetab==1){
                    	searchDownloadDate(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                    }
    				break;
                case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
//                    var rtn = doSaveSheet(sheetObj, "ESM_SPC_0070GS.do", "f_cmd="+(MULTI01 + beforetab)+"&"+FormQueryString(formObj));
    				  var rtn=doSaveSheet(sheetObj, "ESM_SPC_0070GS.do", "f_cmd="+(MULTI01 + beforetab));
    				break;
               case IBDOWNEXCEL:        //엑셀 다운로드              
            	   sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
            	   
                  break;
            }
        }
    	function searchAdjustment(sheetObj, formObj, command){
    		var param=SpcFormString(formObj,'type,year,month,week,rhq,office,trade,lane,vvd');
//    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+FormQueryString(formObj));
     		var rtn = sheetObj.DoSearch("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+ param  );
    	}
    	function searchDownloadDate(sheetObj, formObj, command){
    		var param=SpcFormString(formObj,'type,year,month,week,rhq,office,trade,lane,vvd');
//    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+FormQueryString(formObj));
     		var rtn = sheetObj.DoSearch("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+ param  );
    	}
    	var selectedCell_OldValue=0;
        function t1sheet1_OnSelectCell(sheetObj, orow, ocol, row, col){
        	selectedCell_OldValue=sheetObj.GetCellValue(row, col)*1;
        }
      	function t1sheet1_OnChange(sheetObj, row, col, value){
      		var rlvl=sheetObj.GetCellValue(row, "lvl") * 1;
      		var bkg=sheetObj.GetCellValue(row, "BKG") * 1;
      		var fct=sheetObj.GetCellValue(row, "fcast_lod_qty") * 1;
      		var alc=sheetObj.GetCellValue(row, "aloc_lod_qty") * 1;
      		var sf=0;
      		var rt=0;
      		if(fct < alc){
      			alc=fct;
      		}
      		if(bkg <= alc){
      			sf=alc - bkg;
      			if(fct == 0){
      				rt="000%";
      			}
      			else{
    	  			rt=Math.round(sf / fct * 10000) + "%";
    	  		}
      			var len=rt.length;
      			rt=rt.substring(0, len-3)+"."+rt.substring(len-3, len);
      			sheetObj.SetCellValue(row, "NoShow",sf,0);
      			sheetObj.SetCellValue(row, "Ratio",rt,0);
      		}
      		//if(rlvl < 6) 
      			return;
      		var dif=value * 1 - selectedCell_OldValue;
      		for(var i=1 ; i <= 5 ; i++){
      			var rrow=row - sheetObj.GetCellValue(row, "lvl"+i) * 1;
      			var rlvl=sheetObj.GetCellValue(rrow, "lvl") * 1;
    			alert(i + ":" + rlvl + ":" + rrow + ":" + dif);
      			if(rlvl == i){
      				sheetObj.SetCellValue(rrow, col,sheetObj.GetCellValue(rrow, col) * 1 + dif);
      			}
      		}
      		selectedCell_OldValue=value;
      	}
      	function t1sheet2_OnChange(sheetObj, row, col, value){
      		var sweek=sheetObj.GetCellValue(row, "sweek") * 1;
      		var d=(value * 1 + sweek - 1) % 7;
      		sheetObj.SetCellValue(row, "week",d,0);
      	}
      	/*
    	 * trade변경시
    	 */
    	function trade_OnChange(comObj,value,text ){
    	    //lane value change
    	    comObjects[1].SetSelectIndex(0,false);
    	    SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
      	} 
        /*
    	 * lane변경시
    	 */
       	function lane_OnChange(comObj,value,text ){
    	    var trade=comObj.GetText(value,0);
    	    if(value != "" ){    	
    		   	comObjects[0].SetSelectCode(trade,false);
    	    }
       	}  
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction) {
               case IBSEARCH:      //조회
    		    	if(beforetab != 0) return true;
    				var month=formObj.month.value;
    				var week=formObj.week.value;
//    				var rhq = comObjects[0].Code;
    				var rhq=formObj.rhq.value;
    				var vvd=formObj.vvd.value;
    				if(vvd == "" && month == "" && week == ""){
    					ComShowCodeMessage("COM12139", "Month", "Week");
    					formObj.month.focus();
    					return false;
    				}
    				if(rhq == ""){
    					ComShowCodeMessage("COM12113", "RHQ");
    					formObj.rhq.focus();
    					return false;
    				}
    				if(vvd != "" && vvd.length < 9){
    					ComShowCodeMessage("COM12174", "VVD", "9");
    					formObj.vvd.focus();
    					return false;
    				}
    		        return true;
    		    break;
    		}
    		return true;
        }
    	function initDataValue_trade(){
        	var sheetObj=document.getElementById("trade");
        	with(sheetObj){
        		Index2=0;
        	}
        }
        function initDataValue_rhq(){
        	var sheetObj=document.getElementById("rhq");
        	with(sheetObj){
        		Index2=0;
        	}
        }
        function initDataValue_lane(){
        	var sheetObj=document.getElementById("lane");
        	with(sheetObj){
        		Index2=0;
        	}
        }  
        /**
         * Start Week 의 year 변경시
         * Start Week 의 year 변경시 주차 변경
         */
        function checkWeek(){
        	SpcSearchOptionWeek("week",true,document.form.year.value);
        }        
	/* 개발자 작업  끝 */
