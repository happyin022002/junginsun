/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0445.js
*@FileTitle  : Booking Info 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************
    /**
     * @extends
     * @class EES_CTM_0445 : business script for EES_CTM_0445 
     */
   	/* developer job	*/
 // common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheetSelect=false;
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
                 case "btn_retrieve":
 		        	 if (!checkFormField()) return;
 		        	 if (checkValidation(formObject))
 		        		 doActionIBSheet(sheetObject,formObject,IBSEARCH)
                     break;
                  case "btn_select":
                     Row=sheetObject.GetSelectRow();
                     if (Row == '') return;
                     if (Row == '0' || sheetSelect == false) {
                    	 ComShowCodeMessage("CTM30001");
                    	 return;
                     }
                     Sts=sheetObject.GetCellValue(Row, "mvmt_sts_cd");
                     if (Sts == "VL" || Sts == "VD" || Sts == "EN" || Sts == "TN" || Sts == "MT") {
                    	 ComShowCodeMessage("CTM20054");
                    	 return;
                     }
                     lstRow=sheetObject.LastRow();
                     if (Row != lstRow) {	//restuffing popup 창 이용한 creation logic 수정 by 2015/06/01 황미연
                    	 ComShowCodeMessage("CTM20107");
                    	 return;
                     }
                     var cntrNo = sheetObject.GetCellValue(Row, "cntr_no");
                     var cntrTpsz = sheetObject.GetCellValue(Row, "cntr_tpsz_cd");
//                     var checkDigit = sheetObject.GetCellValue(Row, "check_digit");
                     var sealNo = sheetObject.GetCellValue(Row, "cntr_seal_no");
                     var chssNo = sheetObject.GetCellValue(Row, "chss_no");
                     var mgstNo = sheetObject.GetCellValue(Row, "mgst_no");
                     var bkgNo = sheetObject.GetCellValue(Row, "bkg_no");
                     var vvdNo = sheetObject.GetCellValue(Row, "vvd_cd");
                     var yardCd = sheetObject.GetCellValue(Row, "org_yd_cd");
                     var cymvNo = sheetObject.GetCellValue(Row, "cnmv_cyc_no");
                     var cnmvCd = sheetObject.GetCellValue(Row, "cnmv_id_no");
                     var cnmvYr = sheetObject.GetCellValue(Row, "cnmv_yr");
                     var mvmtStsCd = sheetObject.GetCellValue(Row, "mvmt_sts_cd");
                     var evntDt = sheetObject.GetCellValue(Row, "cnmv_evnt_dt");	// CNMV_DT 추가 by 2015/06/25 황미연
                     var bkgCgoTpCd = sheetObject.GetCellValue(Row, "bkg_cgo_tp_cd");	// 2016/12/07
                     var yd = document.form.yd.value;
                     if (yardCd.substring(0,2) != yd.substring(0,2)) {
                       	 ComShowCodeMessage("CTM10007");
                       	 return;
                     }
                     if (bkgCgoTpCd == "") {
                       	 ComShowCodeMessage("CTM99999", "Booking Cargo Type is missing.");
                       	 return;
                     }
                 	// CNMV_DT 추가 by 2015/06/25 황미연
                     var returnValue = sealNo + "|" + chssNo + "|" + mgstNo + "|" + bkgNo + "|" + vvdNo + "|" + yardCd + "|" + cnmvCd + "|" + cnmvYr + "|" + mvmtStsCd + "|" + cntrNo + "|" + cntrTpsz + "|" + evntDt + "|" + bkgCgoTpCd;
                                          
                     document.form.unload_flag.value="returnValue";
                     //ComClosePopup();
                     ComPopUpReturnValue(returnValue);
                     break;
                 case "btn_close":
                     document.form.unload_flag.value="close";
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
      * validation
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function checkValidation(formObject) {
        return true;
    }
     /**
      * registering IBCombo Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         // OnKeyPress event
         setEventProcess();
         document.form.p_cntrno.focus();
         sheetObject=sheetObjects[0];
         formObject=document.form;
         ComBtnDisable("btn_select");
         //doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                 with (sheetObj) {
            	    var HeadTitle1="Seq.|CYC|STS|Yard|Event Date|Booking No.|VVD Code|Seal No.|Chassis No.|M.G Set|Cntr No|Tp/Sz";	// CNMV_DT 추가 by 2015/06/25 황미연

            	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	    InitHeaders(headers, info);

            	    var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
            	              {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" },
            	              {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
            	              {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd" },
            	              {Type:"Text",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt" },	// CNMV_DT 추가 by 2015/06/25 황미연
            	              {Type:"Text",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
            	              {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd" },
            	              {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no" },
            	              {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mgst_no" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
//            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"check_digit" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" },
            	              {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd" } ];
            	     
            	    InitColumns(cols);

            	    SetEditable(0);
//            	    SetSheetHeight(285);
            	    resizeSheet();
                }
                break;
         }
     }
    //handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if(validateForm(sheetObj,formObj,sAction))
                if(sheetObj.id == "sheet1") {
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    frmObj=document.form;
                    sheetObj.DoSearchFx("EES_CTM_0445GS.do", "f_cmd=" + SEARCH + "&cntr_no=" + formObj.p_cntrno.value );
                }
                break;
        }
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetSelect=false;
        if (ErrMsg == "") {
            // in case retrieving result exists
            if (sheetObj.RowCount()> 0) {
                // making btn_del button Enable
                ComBtnEnable("btn_select");
                sheetObj.SelectCell(sheetObj.LastRow(), 0);
            } else {
                // making btn_del button Enable
                ComBtnDisable("btn_select");
            }
        }
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (NewRow > 0) sheetSelect=true;
    }
    /** 
     * handling OnUnLoad event of HTML Object
     */
    function unloadPage(value) {
        if (value == "returnValue") {
            document.form.unload_flag.value="";
        } else if (value == "close") {
            window.returnValue="";
            document.form.unload_flag.value="";
        }
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}