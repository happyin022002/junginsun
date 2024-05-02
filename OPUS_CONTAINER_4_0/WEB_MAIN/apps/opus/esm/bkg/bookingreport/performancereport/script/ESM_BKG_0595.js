/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0595.js
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업 */
 // 공통전역변수
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;  
			case "btn_New":
				sheetObject1.RemoveAll();
				ComResetAll();
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
			case "btn_CommodityPop":
				// formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value
				comBkgCallPop0653('setCommodityCd',formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value);
				break;	
			case "btn_ComEns041Pop":
				openWindowCustomer(formObject);
				break;	
			case "btn_DownExcel":
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				}
				break;
			case "btn_Sort":
				// sheetObjects[0].ShowSortDialog();
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
		 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수
		 * 있다 배열은 소스 상단에 정의
		 */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
		 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야
		 * 하는 기능을 추가한다
		 */
     function loadPage() {
         for(var i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
 		 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     }
     /**
		 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
		 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
		 * 
		 * @param {ibsheet}
		 *            sheetObj IBSheet Object
		 * @param {int}
		 *            sheetNo sheetObjects 배열에서 순번
		 */
     function initControl() {
     	// ** Date 구분자 **/
     	DATE_SEPARATOR="-";
     	var formObject=document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); // -
																							// 포커스
																							// 나갈때
  	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); // -
																							// 포커스
																							// 들어갈때
//     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); // -
																				// 키보드
																				// 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }
   /**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
	 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
	            with(sheetObj){
		          var HeadTitle="||Per|Charge Code|Amount|Charge Description|sorting_priority|";
		          var headCount=ComCountHeadTitle(HeadTitle);
		
		          SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
						     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"frt_chg_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"per",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"brate_prepaid",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"Text",      Hidden:0,  Width:550,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sorting_priority",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"per_group",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		           
			          InitColumns(cols);
			
			          SetEditable(0);
			          SetCountPosition(0);
			          ShowSubSum([{StdCol:"frt_chg_tp_cd", SumCols:"brate_prepaid", Sort:false, ShowCumulate:false, CaptionCol:0, OtherColText:"per=S/Total"}]);
			          SetSheetHeight(360);
                  }
			break;
 			}
 	}
     
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value=COMMAND01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0595GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 2) 
					ComBkgXml2ComboItem(arrXml[2], chg_rev_tp_cd, "val", "name");
				if (arrXml.length > 1) 
					ComBkgXml2ComboItem(arrXml[1], frt_chg_tp_cd, "val", "name");
				if (arrXml.length > 0) 
					ComBkgXml2ComboItem(arrXml[0], cntr_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_desc");
				cntr_tpsz_cd.SetDropHeight(200);
				cntr_tpsz_cd.SetUseAutoComplete(1);
				frt_chg_tp_cd.SetDropHeight(170);
				frt_chg_tp_cd.SetUseAutoComplete(1);
				cntr_tpsz_cd.InsertItem(0, '', '');
				frt_chg_tp_cd.InsertItem(0, '', '');
				chg_rev_tp_cd.InsertItem(0, '', '');
				break;
           case IBSEARCH:      // 조회
 	          if(validateForm(sheetObj,formObj,sAction)){
 	        	 formObj.f_cmd.value=SEARCH;
 	        	 // sheetObj.Visible = false;
 	        	 sheetObj.DoSearch("ESM_BKG_0595GS.do",FormQueryString(formObj ) + "&" + ComGetPrefixParam(""));
 	          }
              break;
           case IBDOWNEXCEL:      // 입력
        	   if(sheetObj.RowCount() < 1){
        			ComShowCodeMessage("COM132501");
        		}else{
        			//sheetObj.Down2Excel({ HiddenColumn:-1});
        			//sheetObj.Down2Excel({ HiddenColumn:0, TreeLevel:false, DownCols:'2|3|4|5'});
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        		}
   				break;	
         }
     }
     /**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
         	switch(sAction) {
					case IBSEARCH: // 조회시 확인
		         		if (!ComChkValid(formObj)) return false;
		         		break;
         	}	
         }
         return true;
     }
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg)
	{
		var formObject=document.form;
		var sorting_priority=ComGetObjText(formObject.sorting_priority);
		with(sheetObj)
		{
			// ComOpenWait(true); //대기이미지 표시
			for (var i=1; i <= sheetObj.LastRow(); i ++)
			{
				if ("" == GetCellValue(i, "chg_nm")){
					SetCellAlign(i, "chg_cd","Left");
					SetCellAlign(i, "chg_nm","Left");
					SetCellAlign(i, "per","Left");
				}
			}	
			var colInxArray="";
			var lastLow = sheetObj.LastRow();
			var insertRow=0;
			if (lastLow==1) return;
			for (var j=0; j <= sheetObj.LastRow(); j ++)
			{
				if (j < lastLow+insertRow-1){
					if (j==0 || (GetCellValue(j,"chg_cd") =="")){
						if (j ==0){
							colInxArray=j+1;
							DataInsert(j);
						}else{
							colInxArray=colInxArray + ',' + (j+1);
							DataInsert(j+1);
						}
						insertRow++;
						SetCellValue(j+1,"frt_chg_tp_cd",sheetObj.GetCellValue(j+2,"frt_chg_tp_cd"),0);
						SetCellValue(j+1,"per",sheetObj.GetCellValue(j+2,"per_group"),0);
						SetCellValue(j+1,"chg_cd",sheetObj.GetCellValue(j+2,"per_group"),0);; // sheetObj.GetCellValue(j+2,"frt_chg_tp_cd");
						if (sorting_priority != ''){
							SetCellValue(j+1,"chg_nm",sorting_priority +" : "+sheetObj.GetCellValue(j+2,"sorting_priority"),0);
						}
						SetCellAlign(j+1, "chg_cd","Left");
						SetCellAlign(j+1, "per","Left");
						SetRowBackColor(j+1,"#FFFFC0");
					}
				}else{
					break;
				}
			}
			var arrRow=[];
			if((colInxArray+"").indexOf(",")=="-1"){
				arrRow[0] = colInxArray; 
			}else{
				arrRow=colInxArray.split(",");	//, 없이 한 값만 오는 경우 split 하면서 에러남
			}
			for(var i=0 ; i<arrRow.length ; i++){
				SetMergeCell(parseInt(arrRow[i]), 2, 1, 2);
			}
			SetSumText(0, "per","G/Total");
			// sheetObj.SelectRow = 1;
			sheetObj.SelectCell(1,3);
			// Visible = true;
		}
	}
	function openWindowCustomer(formObj){
		var param=FormQueryString(formObj);	
		ComOpenPopup('COM_ENS_041.do?'+param, 780, 470, 'getCOM_ENS_041', '1,0,1,1,1,1,1,1,1,1', true);
	}	
	function getCOM_ENS_041(aryPopupData) {
  		var formObject=document.form;
  		var customer=aryPopupData[0][3];
  		ComSetObjValue(formObject.cust_cnt_cd,customer.substr(0,2));
  		ComSetObjValue(formObject.cust_seq,customer.substr(2));
  		// formObject.vsl_cd.value = aryPopupData[0][7];
  		/*
		 * ComSetObjValue(formObject.cust_cnt_cd,"");
		 * ComSetObjValue(formObject.cust_seq,"");
		 */
  		// formObject.vsl_cd.value = aryPopupData[0][7];
  	} 
	function setCommodityCd(aryPopupData) {
  		var formObject=document.form;
  		formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value
  		formObject.rep_cmdt_cd.value=aryPopupData[0][5];
  		formObject.cmdt_cd.value=aryPopupData[0][3];;
  	} 
	/* 개발자 작업 끝 */