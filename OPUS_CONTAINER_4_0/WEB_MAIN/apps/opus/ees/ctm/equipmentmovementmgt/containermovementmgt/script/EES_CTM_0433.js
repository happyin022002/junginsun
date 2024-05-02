/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_ctm_04.jsp
*@FileTitle  : MVMT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/

 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 		        case "btn_ok":
                     setCntrNo();
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
            	    with(sheetObj){               
		               var HeadTitle="|Seq.||Container No.|TP/SZ|Event Date|STS|RCV_TERM";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"Sta" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
		               SetSheetHeight(182);
                     }

                 break;
         }
     }
   //handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
          switch(sAction)
         {
            case IBSEARCH:     
	          	  sheetObj.RemoveAll();
				  ComOpenWait(true);
				  sheetObj.SetWaitImageVisible(0);
	          	  formObj.f_cmd.value=SEARCH01;
	          	  xml = sheetObj.DoSearch("EES_CTM_0433GS.do", FormQueryString(formObj) );
				  ComOpenWait(false);
				  sheetObj.SetWaitImageVisible(1);
                break;
         }
     }
     function sheet_OnSearchEnd(sheetObj, ErrMsg) {
    	 var opener=window.dialogArguments;
    	 var pSheet=opener.document.form.sheet;
    	 var data1=pSheet.GetRangeText(pSheet.HeaderRows(), 3, pSheet.LastRow(), 3);
   		 for(var i=0; i <= sheetObj.LastRow(); i++){
   			 if(data1.indexOf(sheetObj.GetCellValue(i, "cntr_no")) != -1){
//   	   			 alert (i + ":::" + arrData0[i] + ":" + data1.indexOf(arrData0[i].substring(0,10)))
   				 sheetObj.SetCellValue(i, "del_chk","1");
   				 sheetObj.SetRowEditable(i,0);
   				 sheetObj.SetRowBackColor(i,"#C0C0C0");
   			 }
   		 }
     }
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                 }
              break;
          }
     }
     /**
      * event when clicking Tab
      * activating selected tab items
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//--------------- important --------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab=nItem;
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
 function sheet_OnPopupClick(sheetObj, Row,Col)
 {
     alert("Popup [" + Row + ", " + Col + "]");
 }
 function setCntrNo() {
	 var sRowStr=sheetObjects[0].FindCheckedRow("del_chk");
	 var opener = window.dialogArguments;
	 if (!opener) opener = parent;
	 var arr=sRowStr.split("|");
	 var pSheet=opener.sheet1;
	 var evntDt=opener.document.form.p_date0.value;
	 var sheetObj=sheetObjects[0];
	 var addRow=1;
	 var iRow=iRow;
	 
	 // Container No. CheckBox Validation by 2015/06/01 황미연
	 if (sheetObjects[0].CheckedRows("del_chk") < 1) {
         ComShowCodeMessage("CTM30014");
         return;
     }
	 
	 for (i=0; i<arr.length; i++) {
		 if (sheetObj.GetRowEditable(arr[i]) ==  false) {
			 if (i == 0 && pSheet.GetCellValue(pSheet.GetSelectRow(), "cntr_no") == '') {
				 iRow=pSheet.GetSelectRow();
				 pSheet.RowDelete(pSheet.GetSelectRow(), false);
				 pSheet.SetSelectRow(iRow - 1);
			 }
			 continue;
		 }
		 if (i != 0)
			 addRow=pSheet.DataInsert();
		 cntrNo=sheetObj.GetCellValue(arr[i], "cntr_no");
		 pSheet.SetCellValue(addRow, "cntr_no",cntrNo,0);
//		 pSheet.SetCellValue(addRow, "check_digit",cntrNo.substring(cntrNo.length -1, cntrNo.length),0);
		 pSheet.SetCellValue(addRow, "cntr_tpsz_cd",sheetObj.GetCellValue(arr[i], "cntr_tpsz_cd"),0);
		 pSheet.SetCellValue(addRow, "prev_sts_cd",sheetObj.GetCellValue(arr[i], "mvmt_sts_cd"),0);
		 pSheet.SetCellValue(addRow, "bkg_no",document.form.bkg_no.value,0);
		 pSheet.SetCellValue(addRow, "rcv_term_cd",sheetObj.GetCellValue(arr[i], "rcv_term_cd"),0);
		 pSheet.SetCellValue(addRow, "cnmv_evnt_dt",evntDt,0);
		 pSheet.SetCellValue(addRow, "org_yd_cd",opener.document.form.p_yard1.value + opener.p_yard2.GetSelectCode());
		 pSheet.SetCellValue(addRow, "mvmt_sts_cd",opener.document.form.p_status.value,0);
		 pSheet.SetCellValue(addRow, "cnmv_yr",evntDt.substring(0,4),0);
	 }
	 //	 opener.ComBtnDisable("btn_select");
	 ComClosePopup(); 
 }
