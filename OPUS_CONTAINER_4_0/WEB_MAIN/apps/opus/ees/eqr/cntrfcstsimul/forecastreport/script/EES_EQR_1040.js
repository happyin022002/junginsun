/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1040.js
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
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
    // 공통전역변수
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
            		sheetObjects[0].DataInsert(0);
            		sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow(), 1, 1, 5);
            		sheetObjects[0].InitCellProperty(1, "etb",{ Type:"Combo"} );
            		sheetObjects[0].CellComboItem(1,"etb", {ComboText:"|"+to_etb_dt, ComboCode:"|"+to_etb_dt} );
	            	sheetObjects[0].SetCellValue(1,"sts","M",0);
					sheetObjects[0].SetCellValue(1,"vsl_cd","XXXX",0);
					sheetObjects[0].SetCellValue(1,"skd_voy_no","0000",0);
					sheetObjects[0].SetCellValue(1,"skd_dir_cd","X",0);
					sheetObjects[0].SetCellValue(1,"lane","XXX",0);
					sheetObjects[0].SetCellValue(1,"week",formObject.fcast_yrwk.value,0);
					sheetObjects[0].SetCellValue(1,"show_week",formObject.fcast_yrwk.value.substr(4,2),0);
					sheetObjects[0].SetCellValue(1,"loc_cd",formObject.loc_cd.value,0);
            		for ( var j=6; j<headCount2-1; j++ ) {
            			if(sheetObjects[0].ColSaveName(j).substring(3) == "qty"){
            				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), j,0,0);
            			}
            		}            		            
            		break;
                case "btn_Delete":
                	if(sheetObjects[0].FindCheckedRow("check") != ""){
    					ComRowHideDelete(sheetObjects[0],"check"); 
    					sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow(), 1, 1, 5);
    				}
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    break;
                case "btn_Close":
                	omClosePopup(); 
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
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);    	
        for(i=0;i<sheetObjects.length;i++){        
            ComConfigSheet (sheetObjects[i] );  //khlee-시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);        
            ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
        }
        var level_cd=document.form.level_cd.value;
        // level_cd = 1 (SELCDO 만 수정가능, 나머지는 수정 불가)
        if(level_cd != "1") {
        	ComBtnDisable("btn_save");    // SAVE 버튼 잠금
        	ComBtnDisable("btn_RowAdd");  // ROW ADD 버튼 잠금
        	ComBtnDisable("btn_Delete");  // ROW DELETE 버튼 잠금
        	sheetObjects[0].SetEditable(0);// 시트 잠금
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
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
            with (sheetObj) {
                var HeadTitle="Del.|WK|STS|Lane|VVD|Yard|ETB|DAY|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|BSA|EQ L/F(%)|vsl_cd|skd_voy_no|skd_dir_no|week|lane|loc_cd|"
                + "d2_f|d4_f|d5_f|d7_f|r2_f|r5_f|r9_f|o2_f|s2_f|o4_f|s4_f|f2_f|a2_f|f4_f|a4_f|f5_f|d2_ef|d4_ef|d5_ef|d7_ef|r2_ef|r5_ef|r9_ef|o2_ef|s2_ef|o4_ef|s4_ef|f2_ef|a2_ef|f4_ef|a4_ef|f5_ef|ibflag";
                headCount2=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:0, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check" },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"show_week",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"show_lane",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"show_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yard",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etb",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"etb_day",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"d2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"d4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"d5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"d7_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"r2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"r5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"r9_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"o2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"s2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"o4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"s4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"f2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"a2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"f4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"a4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"f5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bsa",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eqlf",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d4_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d5_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d7_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r5_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r9_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"o2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"s2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"o4_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"s4_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"a2_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f4_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"a4_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f5_f",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d4_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d5_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"d7_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r5_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"r9_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"o2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"s2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"o4_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"s4_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"a2_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f4_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"a4_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"f5_ef",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	                 
                InitColumns(cols);

                SetEditable(1);
                SetColProperty("etb", {ComboText:"|"+to_etb_dt, ComboCode:"|"+to_etb_dt} );
                InitDataValid(0, "yard", vtEngUpOther, "1234567890");
                sheetObj.FrozenCols=8;
                SetSheetHeight(522);
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
                var sXml=sheetObj.GetSearchData("EES_EQR_1040GS.do",FormQueryString(formObj));
                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false); 
                break;
    		case IBSEARCH02:      // 공통조회 (ETB)
    			form.f_cmd.value=SEARCH02;
    			var sXml=sheetObj.GetSearchData("EES_EQR_1040GS.do" , FormQueryString(form));
    			to_etb_dt=ComGetEtcData(sXml,"to_etb_dt");
    			break;
            case IBDOWNEXCEL:      // 입력
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
        		}
            	break;
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){            		           	            		
		        	sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true); 
		            formObj.f_cmd.value=MULTI;
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
       if(sheetObj.RowCount()==1) {
    	 sheetObj.RowDelete(sheetObj.LastRow()-1, false);
       }else if(sheetObj.RowCount()> 1) {
    	 sheetObj.RowDelete(sheetObj.LastRow()-1, false);
  	  	 // 색상변경
  	  	 for ( var j=8; j<24; j++ ) {
  	  		 if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) > 0 ) {
  	  			 sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#0000FF");
  	  		 }else if ( sheetObj.GetCellValue(sheetObj.LastRow(),j) < 0 ) {
  	  			 sheetObj.SetCellFontColor(sheetObj.LastRow(),j,"#FF0000");
 	  		}
  	  	 } 
  //no support[check again]CLT 	  	 sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
		 var level_cd=document.form.level_cd.value;
  	  	 for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
  	  		 if(sheetObj.GetCellValue(i,"sts") != "M"){
				sheetObj.SetCellEditable(i,"check",0);
			}
//			if (level_cd == '1') { // SELCDO 수정 가능
				for ( var j=8; j<24; j++ ) {  // QTY 만 대상
					if(sheetObj.GetCellValue(i,sheetObj.ColSaveName(j).substr(0,2)+"_f")=="Y"){
						sheetObj.SetCellFontColor(i,j,"#FF0000");// red
				    }
					if(sheetObj.GetCellValue(i,"sts")=="M" && sheetObj.GetCellValue(i,j)>0){
						sheetObj.SetCellFontColor(i,j,"#FF0000");// red
					}
				}
//			}
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
    	 var level_cd=document.form.level_cd.value;
		 if(  level_cd == '1' // level_cd=1 (SELCDO 만 수정가능, 나머지는 수정 불가)
			  && sheetObj.ColSaveName(col).substr(3) == "qty"
				  && sheetObj.GetCellValue(row,"sts") != "M"
					  && sheetObj.GetCellValue(row, sheetObj.ColSaveName(col).substr(0,2)+"_f") == "Y" ){
              show_del_btn(sheetObj, row, col);
         }
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
     function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 var formObj=document.form;
    	 with(sheetObj){
    		 switch (ColSaveName(Col)) {
     			case "yard":
     				// validation
					form.f_cmd.value=SEARCH04;
					var sXml=sheetObj.GetSearchData("EES_EQR_1040GS.do" , FormQueryString(form)+"&yard="+Value);
                    if(ComGetEtcData(sXml,"yard_chk") != "T"){
						ComShowCodeMessage("COM132201", "Yard Code");
						SetCellValue(Row,Col,"",0);
						SelectCell(Row,Col);
					}
        			break;  	
    		 }
			 if(ColSaveName(Col).substr(3) == "qty"){
			 	if(Value == "Return"){
	                SetCellValue(Row, ColSaveName(Col).substr(0,2)+"_f","N",0);
	                SetCellFont("FontBold", Row, Col, Row, Col,0);
	                SetCellFontColor(Row, Col,"#000000");
	                click_del_btn(sheetObj, Row, Col);
					SetCellValue(Row,ColSaveName(Col).substr(0,2)+"_ef","D");
					SetCellFontColor(Row,Col,"#000000");// black
	            }else{
				 	SetCellValue(Row,ColSaveName(Col).substr(0,2)+"_ef","U",0);
					SetCellValue(Row,ColSaveName(Col).substr(0,2)+"_f","Y",0);
					SetCellFontColor(Row,Col,"#FF0000");// red
                }
			 }
    	 }
     }
     /**
      * 저장 완료시 처리
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
  		save_flag=true;
  		if ( ErrMsg == "" ) {
  			if ( save_flag ) { 
  		    	var opener_obj=window.opener;
  		    	var week_seq=formObj.dp_seq.value;
  		    	var sheet_row=formObj.row.value;
  		    	for ( var j=6; j<=21; j++ ) { // QTY 만 선택
  		    		if ( sheetObjects[0].RowCount()> 0 ) {
  		    			opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0,2), sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), sheetObjects[0].ColSaveName(j)));
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
             var formObj=document.form;
               formObj.f_cmd.value=SEARCH03;
             var param=FormQueryString(formObj)
             + "&week="        + GetCellValue(Row, "week")
             + "&sts="         + GetCellValue(Row, "sts")
             + "&lane="        + GetCellValue(Row, "lane")
             + "&vsl_cd="      + GetCellValue(Row, "vsl_cd")
             + "&skd_voy_no="  + GetCellValue(Row, "skd_voy_no")
             + "&skd_dir_cd="  + GetCellValue(Row, "skd_dir_cd")
             + "&yard="        + GetCellValue(Row, "yard")
             + "&etb="         + GetCellValue(Row, "etb")
             + "&tpsz="        + ColSaveName(Col).substr(0,2).toUpperCase();;
             var sXml=GetSearchData("EES_EQR_1040GS.do", param);
             if(ComGetEtcData(sXml, "cntr_qty") != null && ComGetEtcData(sXml, "cntr_qty") != "" && ComGetEtcData(sXml, "cntr_qty") != "0"){
                 SetCellValue(Row, Col,ComGetEtcData(sXml, "cntr_qty"),0);
				 SetCellText(Row, Col ,ComGetEtcData(sXml, "cntr_qty"));
             }else{
                 SetCellValue(Row, Col,0);
				 SetCellText(Row, Col ,0);
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
				for(var i=HeaderRows(); i < LastRow(); i++){
					if(GetRowStatus(i) == "I"  ) {
						if(GetCellValue(i, "yard") == "" || GetCellValue(i, "yard") == null) {
							ComShowCodeMessage("COM130403", "Yard");
							SelectCell(i, "yard");
							return false;							
						}	
						if(GetCellValue(i, "etb") == "" || GetCellValue(i, "etb") == null) {
                            ComShowCodeMessage("COM130403", "ETB");
                            SelectCell(i, "vvd");
                            return false;
                        }
					}
					var qty_vol=0;
					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i,"sts") == "M" ) {
						for ( var j=8; j<=24; j++ ) { // QTY 만 선택
							qty_vol += GetCellValue(i,j)*1;
						}
						if(qty_vol==0) {
							ComShowCodeMessage("COM130403", "QTY Volume");
							return false;	
						}
					}
					// 삭제표시
					if(GetCellValue(i, "check") != "") {
						sheetObj.SetRowStatus(i,"D");
					}
				}
                // 중복체크
				var dupRow=ColValueDup("vsl_cd|skd_voy_no|skd_dir_cd|sts|yard|etb");
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
            var arr_tpsz=tpszStr.split(",");
            var consTpszArr="D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,F2,A2,F4,A4,F5".split(",");//전체의 Container Type/Size
            for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size     
                for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                    if(consTpszArr[i] == arr_tpsz[j]){
                        sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",0);
                        break;
                    }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                        sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",1);
                    }
                }
            }
        }
    }	
