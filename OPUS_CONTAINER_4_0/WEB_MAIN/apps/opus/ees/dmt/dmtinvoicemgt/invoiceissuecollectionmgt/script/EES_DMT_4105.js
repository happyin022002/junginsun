/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4105.js
*@FileTitle  : Remark(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
    * @extends 
    * @class ui_dmt_4105 : business script for ui_dmt_4105
    */
    
    // Common Global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_new":
                    var formObject=document.form;
                    formObject.remark01.value="";
                    formObject.remark02.value="";
                break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
        ComConfigSheet (sheetObjects[0] );
        initSheet(sheetObjects[0],1);
        ComEndConfigSheet(sheetObjects[0]);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        dmt4105.innerText="Payer";
//        axon_event.addListener  ( 'keyup' , 'obj_keyup' , 'remark01' );
//        axon_event.addListener  ( 'keyup' , 'obj_keyup' , 'remark02' );
//        axon_event.addListener  ( 'keypress' , 'obj_keypress' , 'remark01' , 'remark02' );
    }
    function obj_keyup() {
        ComChkObjValid(ComGetEvent(),false);
    }
//    SetAppendReport
//------------------------------------------------------------------ 
//Function : obj_keydown1() 
//Description : check kength
//Argument : Object Name( Control) 
//Return : 
//------------------------------------------------------------------ 
function obj_keyup1() { 
    var ls_str=document.form.remark01.value; 
    var li_str_len=ls_str.length; 
    // initializing 
    var li_max=85; 
    var i=0; // 
    var li_byte=0; 
    var li_len=0; 
    var ls_one_char=""; 
    var ls_str2=""; 
    for ( i4=0 ; i4 < li_str_len ; i4++ ) {
        ls_one_char=ls_str.charAt(i4); 
        if ( escape( ls_one_char ).length > 4 ) { 
            li_byte += 2; 
        } else {  
            li_byte++; 
        } 
        if ( li_byte <= li_max ) { 
            li_len=i4 + 1; 
        }
    } 
    if ( li_byte > li_max ) { 
        ls_str2=ls_str.substr(0, li_len); 
        document.form.remark01.value=ls_str2; 
    } 
    document.form.remark01.focus();
} 
//
//------------------------------------------------------------------ 
//Function : obj_keypress() 
//Description : Enter key disabled 
//Argument : 
//Return : 
//------------------------------------------------------------------ 
function obj_keypress () { 
    if(event.keyCode == 13) 
    event.returnValue=false; 
}
// 
function cal_length( val ) { 
    var temp_estr=escape(val); 
    var s_index=0; 
    var e_index=0; 
    var temp_str=""; 
    var cnt=0; 
    while ( ( e_index=temp_estr.indexOf( "%u" , s_index ) ) >= 0 ) { 
        temp_str += temp_estr.substring(s_index, e_index); 
        s_index=e_index + 6; 
        cnt ++; 
    } 
    temp_str += temp_estr.substring(s_index); 
    temp_str=unescape(temp_str); 
    return ( ( cnt * 2 ) + temp_str.length ) + ""; 
} 
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo) {
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    SetVisible(0);
               }
            break;            
        }
    }     
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     // Search
                if ( document.form.tjspno.value == "4012" ) {
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.Reset();
                    initSheet(sheetObjects[0], 0);
                     var sXml=sheetObj.GetSearchData("EES_DMT_4105GS.do",FormQueryString(formObj));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '' ) {
                        var paryInfoArr=rtnRemark.split("\n");
                        if ( !ComIsEmpty(paryInfoArr[0]) ) {
                            document.form.remark01.value=paryInfoArr[0];
                        } else {
                            document.form.remark01.value="";
                        }
                        if ( !ComIsEmpty(paryInfoArr[1]) ) {
                            document.form.remark02.value=paryInfoArr[1];
                        } else {
                            document.form.remark02.value="";
                        }                        
                    }
                }else{
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.Reset();
                    initSheet(sheetObjects[0], 0);
                     var sXml=sheetObj.GetSearchData("EES_DMT_4105GS.do",FormQueryString(formObj));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '' ) {
                        var paryInfoArr=rtnRemark.split("\n");
                        if ( !ComIsEmpty(paryInfoArr[0]) ) {
                            document.form.remark01.value=paryInfoArr[0];
                        } else {
                            document.form.remark01.value="";
                        }
                        if ( !ComIsEmpty(paryInfoArr[1]) ) {
                            document.form.remark02.value=paryInfoArr[1];
                        } else {
                            document.form.remark02.value="";
                        } 
                    }                   
                }
            break;
            case IBSAVE:        // save
                document.form.rmrk.value=document.form.remark01.value + "\n" + document.form.remark02.value;
                if ( document.form.tjspno.value == "4012" ) {
                    formObj.f_cmd.value=MULTI01;
                     var sXml=sheetObj.GetSaveData("EES_DMT_4105GS.do", FormQueryString(formObj));
                    alert(dmtGetMsgText(sXml));
//                    sheetObjects[0].LoadSaveXml(sXml);
                } else {
                    formObj.f_cmd.value=MULTI;
                     var sXml=sheetObj.GetSaveData("EES_DMT_4105GS.do", FormQueryString(formObj));
                    alert(dmtGetMsgText(sXml));
//                    sheetObjects[0].LoadSaveXml(sXml);
                }
                ComClosePopup(); 
            break;
        }
    }
function dmtGetMsgText(xmlStr){
    try {
//        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
    	var xmlDoc = ComGetXmlDoc(xmlStr);
    	if (xmlDoc == null) return;
//        xmlDoc.loadXML(xmlStr);
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;
        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
}    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
