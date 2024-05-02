/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0242.js
*@FileTitle  : Integrated Customer Data Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


// public variable
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
    function processButtonClick(){
        try{
            /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
            var shtCnt=0;
            var t1sheet1Obj=sheetObjects[shtCnt++];
            var t2sheet1Obj=sheetObjects[shtCnt++];
            var t3sheet1Obj=sheetObjects[shtCnt++];
            /*******************************************************/
            var formObject=document.form;
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_master":
                    if(formObject.cust_cnt_cd[beforetab].value != "" && formObject.cust_seq[beforetab].value != ""){
                        var goUrl="";
                        var param="";
                        goUrl="ESM_BKG_0240.do?";
                        param += "1=1";
                        param += "&cust_cnt_cd="+formObject.cust_cnt_cd[beforetab].value;
                        param += "&cust_seq="+formObject.cust_seq[beforetab].value;
                        param += "&pgmNo=ESM_BKG_0240";
                        opener.location.href=goUrl + param;
                    }else{
                        ComShowMessage("Data가 존재하지 않습니다");
                    }
                    break;
                case "btn_close":
                    ComClosePopup(); 
                    break;
            } // end switch
        } catch(e){
            ComShowMessage(e.message);
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
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
		if (document.form.tab_idx.value != "null" && document.form.tab_idx.value != '') {
			tabObjects[0].SetSelectedIndex(document.form.tab_idx.value);
		} else {
			tabObjects[0].SetSelectedIndex(0);
		}
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        //3개의 IBSheet 모양이 모두 동일함
        with(sheetObj){
            var HeadTitle="|bkg_no|bkg_cust_tp_cd|cust_cnt_cd|cust_seq|mdm_name|bl_name|address|rep_cmdt|Fax No|E-Mail";
            
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mdm_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_name",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"address",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"email",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            
            InitColumns(cols);
            
            SetEditable(0);
            SetCountPosition(0);
            SetVisible(0);
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
           case IBSEARCH:      //retrieve
        	   formObj.f_cmd.value=SEARCH01;
						if ( sheetObj.id == "t1sheet1"){
                 			formObj.bkg_cust_tp_cd.value="C";
						}else if ( sheetObj.id == "t2sheet1"){
							formObj.bkg_cust_tp_cd.value="N";
						}else if ( sheetObj.id == "t3sheet1"){
							formObj.bkg_cust_tp_cd.value="A";
						}
 						sheetObj.DoSearch("ESM_BKG_0242GS.do",FormQueryString(formObj) );
 						
                break;
			 case IBSAVE:        //save
              if(validateForm(sheetObj,formObj,sAction))
                  alert (" Save .. ");
                break;
			case "SettingFormValue":
			   // if(sheetObj.LastRow()<=1) break;
				var formObj=document.form;
			    var idx = (parseInt((sheetObj.id).substring(1,3))-1);
		    	formObj.cust_cnt_cd[idx].value=sheetObj.GetCellText(1,"cust_cnt_cd");
		    	formObj.cust_seq[idx].value=sheetObj.GetCellText(1,"cust_seq");
				fncCustSeqBlur(formObj.cust_seq[idx]);
		    	formObj.mdm_name[idx].value=sheetObj.GetCellText(1,"mdm_name");
		    	formObj.bl_name[idx].value=sheetObj.GetCellText(1,"bl_name");
		    	formObj.address[idx].value=sheetObj.GetCellText(1,"address");
		    	formObj.rep_cmdt[idx].value=sheetObj.GetCellText(1,"rep_cmdt");
				formObj.fax_no[idx].value=sheetObj.GetCellText(1,"fax_no");
				formObj.email[idx].value=sheetObj.GetCellText(1,"email");

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
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Consignee" , "");
                    InsertItem( "Notify" , "");
                    InsertItem( "Also Notify" , "");
                }
             break;
         }
    }
    /**
     * Event when clicking Tab
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
	    	if(nItem != 1){
	    		ComBtnDisable("btn_master");
	    	}else{
	    		ComBtnEnable("btn_master");
	    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    function t1sheet1_OnSearchEnd(sheetObj, Code, ErrMsg, StCode, StMsg) { 

		ComOpenWait(false);
    	if (ErrMsg == "") {
		    doActionIBSheet(sheetObj,document.form,"SettingFormValue");
    	}else {
            ComShowMessage(ErrMsg);
        }
    }
    function t2sheet1_OnSearchEnd(sheetObj, Code, ErrMsg, StCode, StMsg) { 

		ComOpenWait(false);
    	if (ErrMsg == "") {
		    doActionIBSheet(sheetObj,document.form,"SettingFormValue");
    	}else {
            ComShowMessage(ErrMsg);
        }
    }
    function t3sheet1_OnSearchEnd(sheetObj, Code, ErrMsg, StCode, StMsg) { 

		ComOpenWait(false);
    	if (ErrMsg == "") {
		    doActionIBSheet(sheetObj,document.form,"SettingFormValue");
    	}else {
            ComShowMessage(ErrMsg);
        }
    }
		/**
		 * 
		 * Put a zero before the number automatically make a six-digit
		 * @param obj
		 * @return
		 */
		function fncCustSeqBlur(obj){
			var orgV=obj.value;
			if(orgV != "" ){
				obj.value=fncSeqTo6(orgV);
			}else{
				obj.value="";
			}
		}
		/**
		 *Put a zero before the number automatically make a six-digit
		 * @param str
		 * @return
		 */
		function fncSeqTo6(str){
			var currentObjLen=str.length;
			var retStr="";
			for(var i=0;i<6-currentObjLen;i++){
				retStr += "0";
			}
			return retStr + str;
		}
