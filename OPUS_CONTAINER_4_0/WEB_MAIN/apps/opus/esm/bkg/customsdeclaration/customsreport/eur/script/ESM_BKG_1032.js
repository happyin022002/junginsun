/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1032.js
*@FileTitle  : CTA : Transmit History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/24
=========================================================*/

/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
                    [Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
     * @author 
     */

    // Common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    
    //Event Handler definition for Button Click event */
    document.onclick=processButtonClick;
    
    //Event Handler for branch processing by judging button name */
    function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {
        	case "btn_retrieve":
        		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        		break;
        	case "btn_calendar":
        		var cal=new ComCalendarFromTo();
        		cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
        		break;
        	case "btn_exceldown":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                    return;
                }
        		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
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
     * Registering IBSheet Object in to Array
     * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
     * The array is defined at upper part of source
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet basic setting & initializing
     * onLoad Event HandlerImplementation of body tag
     * After loading screen in the browser, add function in pre-processing
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('click', 'obj_click', document.form); // click
        initPage();
    }
    /**
     * Definition for sheet initial setting value, header
     * param : sheetObj ==> sheet object, 
     * sheetNo ==> If the serial number ID tag attached to the sheet are many,
     * adding 'Case' clause as a number of sheets, configures initial module.
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
                 
                    var HeadTitle1 = "|Seq.|Message Type|Message Update|Acknowledge Type|Acknowledge Result|Acknowledge Date|Approve Date|B/L No.|Container No.|Partial|VVD|Reject Reason|Accept Reference No.|Declaration No.";
                    var headCount=ComCountHeadTitle(HeadTitle1);
        
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                              {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                              {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"org_msg_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"msg_func_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"ack_knd_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ack_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"apro_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_prt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cstms_err_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"msg_acpt_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"msg_rcv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                        
                    InitColumns(cols);
        
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    //SetAutoRowHeight(0);
                    //SetDataRowHeight(22);
                   
                    SetSheetHeight(480);
                }	
             break;
         }
     }
     /**
      * first init
      * @return
      */
     function initPage() {
        document.form.s_vps_eta_dt.value=ComGetDateAdd(null, 'd', -7, '-');
        document.form.e_vps_eta_dt.value=ComGetNowInfo('ymd','-');
        document.form.vvd_for_fr.readOnly = true;
		document.form.vvd_for_fr.style.backgroundColor= "#E8E7EC";
     }
    /**
     * Sheet handling process
     * @param sheetObj Sheet
     * @param formObj form Object
     * @param sAction Work-handling code
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:
            	//if(!validateForm(sheetObj,formObj,sAction)) return;
            	if(!validateForm(sheetObj,formObj,sAction)) return false;
            	
            	if(formObj.fr_ack.checked){
            		formObj.fr_ack.value ="Y";
				}else{
					formObj.fr_ack.value ="N";
				}
                    
            	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
            	var sParam=FormQueryString(formObj);
            	//ComShowMessage("sParam : " + sParam);
            	sheetObj.DoSearch("ESM_BKG_1032GS.do",sParam ); 
            	ComOpenWait(false); //sheet1_OnSearchEnd(); //ComOpenWait(false);
            	break;
         }
    }
    /**
     * Handling validity verification process about screen form input value.
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH: { // search
                //Checking basic format
                if (!ComChkValid(formObj)) return false;
                var etaDt=formObj.s_vps_eta_dt.value + formObj.e_vps_eta_dt.value;
                var blNo=formObj.bl_no.value;
                var cntrNo=formObj.cntr_no.value;
                
                if(etaDt == "" && blNo == "" && cntrNo == "") {
                    ComShowCodeMessage("BKG06091");
                    ComSetFocus(formObj.s_vps_eta_dt);
                    return false;
                }
                break;
            }
        } // end switch()
         return true;
    }
    /**
     * Handling when inputting inquiry conditions
     */
    function obj_KeyUp() {
        var formObject=document.form;
        var srcName=ComGetEvent("name");
        var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
        var srcValue=window.event.srcElement.getAttribute("value");
        if (srcName=="bl_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
            ComSetNextFocus();
        }
    }
    /**
     * Handling when clicking sheet
     */
    function sheet1_OnClick(sheetObj, row, col) {
        var rowCnt=sheetObj.RowCount();
        var colSaveName=sheetObj.ColSaveName(col);
        /* Changing default value Row focus color,chracter*/
	     //지원안함[공통처리] :     sheetObj.SelectFontBold=false;
	     //지원안함[공통처리] :     sheetObj.SelectBackColor="16186087";
        switch(colSaveName) {
            /* MemoPad processing long chracter set */
            case "cstms_err_id" :
                if(sheetObj.GetCellValue(row,col) == "") return false;
                ComShowMemoPad(sheetObj, null, null, true, 420, 150);
                break;
        } // end switch
    }
     
    function obj_click() {
      	var formObject = document.form;
      	var srcName = window.event.srcElement.getAttribute("name");
      	var srcValue = window.event.srcElement.getAttribute("value");
      	if (srcName == "fr_ack") {
      		if (formObject.fr_ack.checked == true){
      			formObject.vvd_for_fr.readOnly = false;
     			formObject.vvd_for_fr.style.backgroundColor= "";		
      		}else { 
      			formObject.vvd_for_fr.readOnly = true;
      			formObject.vvd_for_fr.style.backgroundColor= "#E8E7EC";
      			formObject.vvd_for_fr.value = "";
      		
      		}
      	}
    }