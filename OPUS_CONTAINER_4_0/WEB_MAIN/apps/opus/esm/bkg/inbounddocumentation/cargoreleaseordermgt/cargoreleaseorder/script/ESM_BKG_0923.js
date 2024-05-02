/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0923.jsp
*@FileTitle  : Inbound Cargo Release for POD Office_Popup History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//public variable
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick; 
/**
 * Event handler processing by button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Close":
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
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
        document.form.bl_no.value=parBlNo;
    }
    doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
}
/**
 * setting sheet initial values and header<br>
 * <br>
 * adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 
 * @param {int} sheetNo 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
            with(sheetObj){
		         var HeadTitle=" |B/L|Last Update|F|O|C|CR|Team|Service Name|User Name";
		         var headCount=ComCountHeadTitle(HeadTitle);
		
		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		         var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		
		         var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"frt_clt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"obl_rdem_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mrn_tml_edi_snd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cgor_team_cd_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cgor_evnt_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
		          
		         InitColumns(cols);
		         SetEditable(1);
		         SetWaitImageVisible(0);
		         SetSheetHeight(300);
         }
         break;
    }
}
/**
 * handling sheet process<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj
 * @param {Object} formObj 
 * @param {int} sAction 
 * @return void
 * @author
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      //retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return;
               formObj.f_cmd.value=SEARCH;
			   ComOpenWait(true);
               sheetObj.DoSearch("ESM_BKG_0923GS.do",FormQueryString(formObj));
            break;
    }
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if("CA" == document.form.cnt_cd.value){
		sheetObjects[0].SetColHidden("cstms_clr_cd", 1);
	}else{
		sheetObjects[0].SetColHidden("cstms_clr_cd", 0);
	}	
	ComOpenWait(false);
}
/**
 * handling process for input validation<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj
 * @param {Object} formObj 
 * @param {int} sAction 
 * @return boolean 
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
    return true;
}
