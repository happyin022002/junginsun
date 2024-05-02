/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1051.js
*@FileTitle : Inventory Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    var sheetObjects=new Array();
    var sheetCnt=0;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             var sheetObject=sheetObjects[0];       
             var formObject=document.form;
            try {
                var srcName=ComGetEvent("name");
//                if(formObject.view.value=="true" ) {
//                    return;
//                }
                switch(srcName) {
                    case "btn_retrieve":
                        //main화면에서 ref_id가 넘어와서 Table에 저장된 List가 있을 경우, 'retrieve'버튼은 disable 한다.
                        //main화면에서 이미 선택했던 Cntr_list가 있을 경우, 'retrieve'버튼은 disable 한다.
                        var formObject=document.form;
                        if( sheetObject.rowcount==0 ){
                            doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        }
                        break;
              	    case "btn_downexcel":
              	    	if(sheetObject.RowCount()> 0) doActionIBSheet(sheetObject, formObject,IBDOWNEXCEL);
              	    	else                         ComShowCodeMessage("EQR90039");
            	        break;                        
                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                    ComShowCodeMessage("EQR90004");
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
                ComConfigSheet(sheetObjects[i]); //khlee-시작 환경 설정 함수 이름 변경
                initSheet(sheetObjects[i],i+1);            
                ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
            }
            var sheetObject=sheetObjects[0];               
            var formObject=document.form;  
            // 조회쿼리 가동
            doActionIBSheet(sheetObject,document.form,IBSEARCH);
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
                    with(sheetObj){
                    
                  var HeadTitle0="CNTR No.|T/S|Term|MVMNT|LSR|Curr|DM|HR|HB|RB|DP|PF|IM|MA|HM" ;

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle0, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Text",      Hidden:0,  Width:92,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_use_co_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rfub_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"disp_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"plst_flr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rf_tp_cd_c",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rf_tp_cd_h",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                   
                  InitColumns(cols);

                  SetEditable(0);
                  SetCellBackColor(1,7,"#DEFBF8");//ENIS
                  SetCellBackColor(1,8,GetCellBackColor(1,7));
                  SetCellBackColor(1,9,GetCellBackColor(1,7));
                  SetCellBackColor(1,10,GetCellBackColor(1,7));
                  SetSheetHeight(360);
                        }

                    break;
            }
        }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH:      //조회
           				sheetObj.SetWaitImageVisible(1 );
                        formObj.f_cmd.value=SEARCHLIST;
                        sheetObj.DoSearch("EES_EQR_1051GS.do", eqrFormQryStr(formObj) );
                     	sheetObj.SetVisible(1);
                     	sheetObj.SetExtendLastCol(0);
                    break;
               case IBDOWNEXCEL:
            	   if(sheetObj.RowCount() < 1){
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(                   sheetObj), SheetDesign:1,Merge:1 });
            		}                   
                   break;                    
            }
        }  	
    	/* 현재창 닫기
    	*/
    	function closeWindow() {
    		ComClosePopup(); 
    	}    	   	
