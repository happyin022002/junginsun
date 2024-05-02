/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0154.jsp
*@FileTitle  : Target VVD/Supply Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_SAQ_0154 : business script for ESM_SAQ_0154.
     */
    function ESM_SAQ_0154() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 var sheetObjects=new Array();
 var comObjects=new Array();
 var sheetCnt=0;
 var comboCnt=0;
 var tabObjects=new Array();
 var tabCnt=0 ;
 var currentTabIndex=1;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject=sheetObjects[0];
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 			if(window.event.srcElement.tagName == "IMG" && document.getElementsByName(srcName)[0].GetEnable()!= undefined && !document.getElementsByName(srcName)[0].GetEnable()){
 				return;
 			}
             switch(srcName) {
         	    case "btn_retrieve":
    	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
         	        break;
         	    case "btn_new":
         	    	sheetObject.RemoveAll();
         	    	formObject.reset();
         	    	setYearMonthObject(formObject.year, formObject.bse_qtr_cd);
 					break;
                 case "btn_downexcel":
                	 if(sheetObject.RowCount() < 1){//no data
                			ComShowCodeMessage("COM132501");
                		}else{
                			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                		}
                     break;
     			case "btng_skd":
     				var classId="COM_ENS_0B1";
     				var vvd_cd=sheetObject.GetCellValue(sheetObject.GetSelectRow(), "vvd");
     				var param="?vvd_cd=" + vvd_cd + "&classId=" + classId;
     				ComOpenPopup("/opuscntr/"+classId+".do"+param, 620, 450, "", "0,0,1,1,1,1,1,1,1,1", false);
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setComboObject(combo_obj){
 		comObjects[comboCnt++]=combo_obj;
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function loadPage() {
    	optionSetting();
 		var sheetResizeFull=true;
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
    	
	    //initializing the combobox
		for (var k = 0; k < comObjects.length; k++) {			    
		    comObjects[k].ValidChar(2,1); //영어대문자,숫자포함 도움말 ValidChar 참고;
		}
         
        var formObj=document.form;
        setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
        document.form.year.focus();
        
        trade.ValidChar(2,1); //영어대문자,숫자포함 도움말 ValidChar 참고
     }
     
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:
                 with(sheetObj){
		              var HeadTitle="Trade|Bound|SubTrade|Lane|Group|Year|Month|Week|VVD|BSA|Remarks";
		              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",        KeyField:0,   CalcLogic:"",   Format:"",         PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"group",           KeyField:0,   CalcLogic:"",   Format:"",         PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",         KeyField:0,   CalcLogic:"",   Format:"",         PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"v_fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",  PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_rmk",         KeyField:0,   CalcLogic:"",   Format:"",         PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];

		              InitColumns(cols);
		              SetEditable(0);
//		              SetSheetHeight(510);
		              resizeSheet();
		              SetFocusEditMode(default_edit_mode);
                       }
                 break;
         }
     }
          
 	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
 	
     var searchCond="";
     // handling sheet1 process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
             case IBSEARCH:
 				formObj.f_cmd.value=SEARCHLIST02;
                 searchCond=saqFormString(formObj);
                 searchCond=searchCond +"&lane=" +comObjects[1].GetSelectCode();
                 var rtn = sheetObjects[0].DoSearch("ESM_SAQ_0154GS.do", searchCond );
                 break;
             case IBDOWNEXCEL:
                   selectDownExcelMethod(sheetObj);
                 break;
         }
     }


     /**
      * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
      *
      * excelType
 	 * AY - 전체 데이터를 Format 적용해서 down 받는 경우
 	 * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
 	 * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
 	 * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
      */
    	function callBackExcelMethod(excelType){
 		var sheetObj = sheetObjects[0];
 		DownExcel(sheetObj, excelType);
 	}

    function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	comObjects[1].SetSelectIndex(0,false);
    }
     function search_lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
        var repTrade=comObj.GetText(oldIndex,0);
        if(value != "" ){
        	comObjects[0].SetSelectCode(repTrade,false);
        }
    }
     function lane_OnBlur(comObj){
    	 var finded=comObj.FindItem(comObj.GetSelectText() , 2);
         comObj.SetSelectCode(finded);
    }
 	/**
 	 * handling process for input validation
 	 */
 	function validateForm(sheetObj,formObj,sAction){
 		switch(sAction){
 			case IBSEARCH:
 				if(comObjects[0].GetSelectCode()== ""){
 					ComShowMessage(getMsg("SAQ90126", "Trade"));
 					trade.focus();
 					return false;
 				}
 				if(bound.value == ""){
 					ComShowMessage(getMsg("SAQ90126", "Bound"));
 					formObj.bound.focus();
 					return false;
 				}
 				break;
 		}
 		return true;
 	}
 	function optionSetting() {
		SaqSearchOptionYear("year");
		SaqSearchOptionQuarter("bse_qtr_cd");
		SaqSearchOptionTrade("trade");
		SaqSearchOptionBound("bound");
		SaqSearchOptionLane("search_lane");
		SaqSearchOptionComCode("unit", "CD00897", false);
    }
