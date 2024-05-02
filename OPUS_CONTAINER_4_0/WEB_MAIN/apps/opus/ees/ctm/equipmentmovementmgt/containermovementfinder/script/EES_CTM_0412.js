/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0412.js
*@FileTitle : BKG container update Irr.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 //common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 // Event handler processing by button click event  */
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
                 if (checkValidation(formObject))
                   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
              break;
              case "btn_new":
            	  formObject.reset();
            	  p_yard2.RemoveAll();
            	  sheetObject.RemoveAll();
            	  document.form.p_office.focus();
            	  //loadPage();
                 break;
              case "btn_Calendar1":
              case "btn_Calendar2":
               var cal=new ComCalendarFromTo();
                  cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                break;
                 case "btn_print":
                     alert(srcName);
                     break;
              case "btn_Combo":
                formObject.p_reson.style.display='none';
               itm=document.all.item("m_combo");
                itm.style.display='';
                 break;
             case "btn_DownExcel":
                if(sheetObject.RowCount() < 1){
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(                sheetObject), SheetDesign:1,Merge:1 });
        		}
                 
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
     * Validation 
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function checkValidation(formObject) {
        var off_cd=formObject.p_office.value;
        var st_dt=formObject.p_date1.value;
        var ed_dt=formObject.p_date2.value;
        if (off_cd.length < 1) {
            ComShowCodeMessage("CTM00000");
            return false;
        } else if (st_dt.length < 8) {
            ComShowCodeMessage("CTM00000");
            return false;
        } else if (ed_dt.length < 8) {
            ComShowCodeMessage("CTM00000");
            return false;
        }
        return true;
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
         setEventProcess();
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
         
         document.form.p_office.focus();
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
               
               var HeadTitle1="Seq.|Container No.|T/S|Irr. Type|Settled|Previous Booking|Previous Booking|Previous Booking|Previous Booking|Previous Booking|Current Booking|Current Booking|Current Booking|Current Booking|Current Booking|Remark(s)";
               var HeadTitle2="Seq.|Container No.|T/S|Irr. Type|Settled|STS|Origin Yard|Booking No.|Booking No.|Event date|STS|Origin Yard|Booking No.|Booking No.|Event date|Remark(s)";

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                      {Type:"Text",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no" },
                      {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                      {Type:"Text",     Hidden:0,  Width:58,   Align:"Center",  ColMerge:1,   SaveName:"cntr_bkg_atch_cd" },
                      {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_irr_stl_flg" },
                      {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pre_cnmv_sts_cd" },
                      {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pre_org_yd_cd" },
                      {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no2" },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_split2" },
                      {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pre_cnmv_evnt_dt", Format:"YmdHm" },
                      {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd" },
                      {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd" },
                      {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no1" },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_split1" },
                      {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt", Format:"YmdHm" },
                      {Type:"Text",     Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"Remark" } ];
                
               InitColumns(cols);

               SetEditable(0);
               SetCountPosition(0);
//               SetSheetHeight(462);
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
                if (validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                    formObj.f_cmd.value=SEARCH;
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                     sheetObj.DoSearchFx("EES_CTM_0412GS.do", FormQueryString(formObj) );
                    sheetObj.SetWaitImageVisible(1);
                    }
                }
            break;
            case IBROWSEARCH:     
                if(validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value=SEARCH11;
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                     xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
                    rtnValue=ComGetEtcData(xml, "rtnValue");
                    parseYardMultiCombo(rtnValue, comboObjects[0]);
                    ComOpenWait(false);
                    sheetObj.SetWaitImageVisible(1);
                }
                break;
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
      * registering IBCombo Object as list
      * param : combo_obj
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setComboObject(combo_obj) {
         comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
    function sheet1_OnSearchEnd(sheetObj,  ErrMsg) {
        ComOpenWait(false);
        with(sheetObj) {
        var irow=LastRow()+1;
            for (i=2;i<=irow;i++){
                // green in case Booking No column has value
            	if (GetCellValue(i, "Booking1") == "") {
                    SetCellBackColor(i,"Booking1",GetCellBackColor(i,"TS"));
                } else {
                    SetCellBackColor(i,"Booking1","#00FF00");
                    SetCellBackColor(i,"Booking2","#00FF00");
                }
                //*********************
            	if(GetCellValue(i, "Booking3") == "") {
                    SetCellBackColor(i,"Booking3",GetCellBackColor(i,"TS"));
                } else {
                    SetCellBackColor(i,"Booking3","#00FF00");
                    SetCellBackColor(i,"Booking4","#00FF00");
                }
            }
        }
    }
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
