/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0034.js
*@FileTitle  : Transportion invoice CSR Creation - tax bill
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var Radiocount=0;
var comboObjects=new Array();
var comboCnt=0 ;
var tax_no2_onchageFlg=""; 
var opener_obj=window.dialogArguments;
if (!opener_obj)  opener_obj=window.opener;
if (!opener_obj) opener_obj=parent;
var opener_sheet_obj=opener_obj.sheet1;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
function processButtonClick(){
    /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
         var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btng_ok_k":			
               /** Validation Check Order 
                * 1. TAX NO
                * 2. Business Registration Number
                * 3. Item
                * 4. Price
                * */
            	if(formObject.electronic.checked == false && formObject.paper.checked == false){
                    errMsg=ComGetMsg("TRS90401" );
                    ComShowMessage(errMsg);
                    formObject.electronic.focus();
                    return false;
                }
                if(formObject.tax_no1.value == "" || formObject.tax_no1.value.length != 6){
                    errMsg=ComGetMsg("TRS90013" );
                    errMsg="Enter the tax invoice number.";
                    ComShowMessage(errMsg);
                    formObject.tax_no1.focus();
                    return false;
                }
                formObject.tax_no2.value=comboObjects[0].GetSelectCode();
                if(formObject.tax_no2.value == "" || formObject.tax_no2.value == null){
                    errMsg="Please select the Office.";
                    ComShowMessage(errMsg);
                    return false;
                }
                if(formObject.inv_dt.value == ""){
                    errMsg="Enter the date of issuance.";
                    ComShowMessage(errMsg);
                    return false;
                }
                var saupjano=formObject.comp_no1+formObject.comp_no2 + formObject.comp_no3;
                var saupjano1=formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;						
                if(formObject.comp_no1.value == "" || formObject.comp_no2.value == "" || formObject.comp_no3.value == ""){
                    errMsg="Enter Company Registration Number.";
                    if(formObject.comp_no1.value == "")        formObject.comp_no1.focus();
                    else if(formObject.comp_no2.value == "")   formObject.comp_no2.focus(); 
                    else if(formObject.comp_no3.value == "")   formObject.comp_no3.focus(); 
                    ComShowMessage(errMsg);
                    return false;
                }
                if(!check_busino(saupjano1)){
                        errMsg=ComGetMsg("TRS90018" );
                        ComShowMessage(errMsg);	
                        return false;			
                }
                if(formObject.vat_amt_hdr.value != formObject.vat_amt.value){
                    errMsg=ComGetMsg("TRS90013" );
                    ComShowMessage(errMsg);
                    return false;
                } 
                if(formObject.total_amt_hdr.value != formObject.total_amt.value){
                    errMsg=ComGetMsg("TRS90014" );
                    ComShowMessage(errMsg);
                    return false;
                }
                if(ComIsNull(ComGetObjValue(formObject.finance_flg))){
                        errMsg=ComGetMsg("TRS90016" );
                        ComShowMessage(errMsg);
                        return false;			
                }
                if(ComIsNull(ComGetObjValue(formObject.tax_type))){
                        errMsg=ComGetMsg("TRS90017" );
                        ComShowMessage(errMsg);	
                        return false;			
                }										
                if(sheetObjects[0].RowCount()<1){
                        errMsg=ComGetMsg("TRS90019" );
                        ComShowMessage(errMsg);
                        return false;
                }
                if(sheetObjects[0].RowCount()>0){
                        for(var i=0;i<sheetObjects[0].RowCount();i++){
if(sheetObjects[0].GetCellValue(i+1,3)==""){
                                    errMsg=ComGetMsg("TRS90020" );
                                    ComShowMessage(errMsg);
                                    return false;
                                }
                        }							
                }
                /* TAX CODE Creation */
                document.form.f_cmd.value=MULTI02; 
                doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH);
                if(document.form.tax_code.value == "" || document.form.tax_code.value == "undefined")
                {
                    errMsg=ComGetMsg("TRS90047" );
                    ComShowMessage(errMsg);
                    return false;
                }
                //Generating the serial number of the tax bill
                if(formObject.tax_no3.value == null || formObject.tax_no3.value == "")    searchTaxNo3(comboObjects[0]);
                setOpenerInsertData();
                errMsg=ComGetMsg("TRS90021" );
                ComShowMessage(errMsg);
                ComClosePopup(); 
                break;
            case "btng_cancel_k":					
            	ComClosePopup(); 
                break;
            case "btng_new_k":					
                comboObjects[0].SetSelectCode("");
                formObject.tax_no3.value="";
                formObject.finance_flg[0].checked=false;
                formObject.finance_flg[1].checked=false;
                formObject.tax_type[0].checked=false; 
                formObject.tax_type[1].checked=false;
                formObject.comp_no1.value="";
                formObject.comp_no2.value="";
                formObject.comp_no3.value="";
                formObject.inv_dt.value="";			
                sheetObjects[0].RemoveAll();
                break;
            case "btng_add_k":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;
            case "btng_delete_k":
                doActionIBSheet(sheetObject, formObject, IBDELETE);
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            errMsg=ComGetMsg("TRS90392" );
            ComShowMessage(errMsg);
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
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(p=0;p< comboObjects.length;p++){
        initCombo (comboObjects[p], p+1, '');
    }   			
    ComEnableObject(document.form.vndr_seq_hdr, false);
    ComEnableObject(document.form.vat_amt_hdr, false); 
    ComEnableObject(document.form.total_amt_hdr, false);
    ComEnableObject(document.form.page, false);
    // ComEnableObject(document.form.tax_no1, false); 
    ComEnableObject(document.form.tax_no3, false);
    ComEnableObject(document.form.volume, false);
    ComEnableObject(document.form.ho, false); 
    ComEnableObject(document.form.vndr_nm, false);
    ComEnableObject(document.form.bzct_nm, false);	
    ComEnableObject(document.form.vndr_addr, false);
    ComEnableObject(document.form.bzct_nm, false);	
    ComEnableObject(document.form.bztp_nm, false);	
    ComEnableObject(document.form.ceo_nm, false);
    ComEnableObject(document.form.vndr_seq, false);
    ComEnableObject(document.form.net_amt, false);
    ComEnableObject(document.form.vat_amt, false); 
    ComEnableObject(document.form.total_amt, false);	
    insertValue();					
    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			         
  //html controls initialization event
	initControl();
}
/**
 * Control of the event is dynamically loaded. <br>
 * {@link #loadPage}Control of the event is dynamically loaded. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo    SheetObjects sequence number in the array
 **/
function initControl() {
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //If you change BKG Creation tab manual
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //Booking No BKG Creation tab, if the changes
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- onblur event code handling
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- onfocus event code handling
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- onkeypress event code handling 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');  
    */
}
//Axon event  --- start
/**
 * HTML Control in onkeypress event of the English/numbers to the input processing.<br>
 **/
function engnum_keypress() {
//            ComKeyOnlyAlphabet('uppernum');
}
/**
 * BKG Creation tab Booking No function when processing a change. <br>
 **/
function manual_click() {
    //manual is checked to only be editable Bkg_no.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}
/**
 * BKG Creation tab Booking No function when processing a change. <br>
 **/
function bkgno_keyup() {
    //bkg_no by modifying the stored value and if different bl_no clear, bl_no rescue this case.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value="";
    else
	form.boo_bl_no.value=form.hdn_boo_bl_no.value;
	*/
}
/**
 * Validation of HTML Control will check in onblur event <br>
 **/
function obj_blur(){
    //Input Validation to check
//            return ComChkObjValid(event.srcElement);
}
/**
 * HTML Control's onfocus event in a separator to remove the mask. <br>
 **/
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}
/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
//            ComKeyOnlyNumber(event.srcElement);
}
//Axon event handling --- end
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
            //no support[check again]CLT style.height=GetSheetHeight(8);
//		         Merge kind [optional, Default false]
//		         Setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//		         Setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		         var HeadTitle1=" |STS|Seq|Item|Price|Tax|Total" ;
		
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
		
		         var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		         InitHeaders(headers, info);
		
		         var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"|4|+|5|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          
		         InitColumns(cols);
		         SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
		         SetEditable(1);
                  }
         break;

        case 2:      //sheet1 init
            with(sheetObj){
//				Merge kind [optional, Default false]
//				Setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//				Setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				var HeadTitle1="Seq" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
				SetEditable(1);
			}
			break;
    }
}
// Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
       case IBSEARCH:      //retrieve
            formObj.f_cmd.value=SEARCHLIST;                  
            sheetObj.DoRowSearch("ESD_TRS_0034GS.do",TrsFrmQryString(formObj) );
//			sheetObj.GetSearchXml("ESD_TRS_0031GS.do", TrsFrmQryString(formObj));	//opus ETCDATA use
            break; 
       case IBINSERT:      // Inpit
                if(sheetObj.RowCount()== 4){
                    return;
                }else{
                    sheetObj.DataInsert();
            }
            ////JSK controlSheetColumnTax();
            break;
       case IBCOPYROW:        //row copy
          sheetObj.DataCopy();
          break;
       case IBDELETE:
          var chkRows=sheetObj.FindCheckedRow("sel") ;
          var arrRow=chkRows.split("|");
          for (idx=arrRow.length-2; idx >= 0; idx--){ 
            sheetObj.RowDelete(arrRow[idx] , false);
          }
        var net_amt=0;
        var vat_amt=0;
        var total_amt=0;
        for(var i=0;i<sheetObjects[0].RowCount();i++){
        	net_amt=parseFloat(sheetObjects[0].GetCellValue(i+1,4)*100)+parseFloat(net_amt);
        	vat_amt=parseFloat(sheetObjects[0].GetCellValue(i+1,5)*100)+parseFloat(vat_amt);
        	total_amt=parseFloat(sheetObjects[0].GetCellValue(i+1,6)*100)+parseFloat(total_amt);
        }
        document.form.net_amt.value=net_amt/100;
        document.form.vat_amt.value=vat_amt/100;
        document.form.total_amt.value=total_amt/100;                
       break;
    }
}
// Sheet processing-related processes
function doActionIBSheet1(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      //retrieve               	                 
            sheetObj.DoSearch("ESD_TRS_0034_037GS.do", TrsFrmQryString(formObj) );
            break;
    }
}     
function insertValue(){
    document.form.vndr_seq.value=opener_obj.document.form.wo_vndr_seq.value;
    document.form.wo_vndr_seq.value=opener_obj.document.form.wo_vndr_seq.value;
    document.form.vndr_seq_hdr.value=opener_obj.document.form.vndr_seq.value;
    if( opener_obj.document.form.type.value == "ELECTRONIC" ){
    	document.form.electronic.checked=true;
    }else if (opener_obj.document.form.type.value == "PAPER" ){
    	document.form.paper.checked=true;
    }
    var k=0;
    var vat_amt=0; 
    var total_amt=0;
    var checkRow=opener_sheet_obj.FindCheckedRow(1);
    var checkRowArray=checkRow.split("|");
    for(k=0;k<checkRowArray.length-1;k++){ 					  
    	vat_amt=vat_amt+parseFloat(opener_sheet_obj.GetCellValue(checkRowArray[k], "inv_vat_amt"));
    	total_amt=total_amt+parseFloat(opener_sheet_obj.GetCellValue(checkRowArray[k], "inv_ttl_amt"));
    }
    document.form.vat_amt_hdr.value=vat_amt;
    document.form.total_amt_hdr.value=total_amt;			
    if(total_amt-vat_amt>0){
            document.form.finance_flg[0].checked=true;						
            document.form.finance_flg[1].disabled=true;						
    }else if(total_amt -vat_amt <=0){
            document.form.finance_flg[0].disabled=true;		
            document.form.finance_flg[1].checked=true;					
    }
    if(vat_amt==0){
            document.form.tax_type[0].checked=true;						
            document.form.tax_type[1].disabled=true;	
    }else if(total_amt>0){											
            document.form.tax_type[1].checked=true;					
            document.form.tax_type[0].disabled=true;						
    }
}
function insertValueEvi(){
    var k=0;			
    if(opener_obj.document.form.eviInputFlg.value=="Y"){								
        tax_no2_onchageFlg="Y";
        document.form.tax_no1.value=opener_obj.document.form.evi_tax_no.value.substring(0 , 6 );
        comboObjects[0].SetSelectCode(opener_obj.document.form.evi_tax_no.value.substring(6 , 11));
        document.form.tax_no3.value=opener_obj.document.form.evi_tax_no.value.substring(11, 15);
        if(opener_obj.document.form.tax_naid_flg.value == "Y"){
            document.form.tax_naid_flg[0].checked=true;
            document.form.tax_naid_flg[1].checked=false;
        }else if(opener_obj.document.form.tax_naid_flg.value == "N"){
            document.form.tax_naid_flg[1].checked=true;
            document.form.tax_naid_flg[0].checked=false;
        }
        if(opener_obj.document.form.finance_flg.value == "Y"){
            document.form.finance_flg[0].checked=true;
            document.form.finance_flg[1].checked=false;
        }else if(opener_obj.document.form.finance_flg.value == "N"){
            document.form.finance_flg[1].checked=true;
            document.form.finance_flg[0].checked=false;
        }
        if(opener_obj.document.form.fa_flg.value == "Y"){
            document.form.fa_flg[0].checked=true;
            document.form.fa_flg[1].checked=false;
        }else if(opener_obj.document.form.fa_flg.value == "N"){
            document.form.fa_flg[1].checked=true;
            document.form.fa_flg[0].checked=false;
        }
        if(opener_obj.document.form.tax_type.value == "0"){
            document.form.tax_type[0].checked=true;
            document.form.tax_type[1].checked=false;
        }else if(opener_obj.document.form.tax_type.value == "10"){
            document.form.tax_type[1].checked=true;
            document.form.tax_type[0].checked=false;
        }
        if(opener_obj.document.form.tax_nsl_flg.value == "Y"){
            document.form.tax_nsl_flg[0].checked=true;
            document.form.tax_nsl_flg[1].checked=false;
        }else if(opener_obj.document.form.tax_nsl_flg.value == "N"){
            document.form.tax_nsl_flg[1].checked=true;
            document.form.tax_nsl_flg[0].checked=false;
        }
        document.form.comp_no1.value=opener_obj.document.form.evi_comp_no.value.substring(0,3);
        document.form.comp_no2.value=opener_obj.document.form.evi_comp_no.value.substring(3,5);
        document.form.comp_no3.value=opener_obj.document.form.evi_comp_no.value.substring(5,10);
        document.form.inv_dt.value=opener_obj.document.form.evi_inv_dt.value;						
        document.form.net_amt.value=opener_obj.document.form.evi_total_net_amt.value;						
        document.form.vat_amt.value=opener_obj.document.form.evi_total_tax_amt.value;	
        for(var i=0;i<4;i++){ 
            if(eval("opener_obj.document.form.evi_ctnt"+(k+1)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+2)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+3)).value != ""){
                sheetObjects[0].DataInsert(-1);
                k++;
                sheetObjects[0].SetCellValue(i+1,3,eval("opener_obj.document.form.evi_ctnt"+k).value);
                k++;
                sheetObjects[0].SetCellValue(i+1,4,eval("opener_obj.document.form.evi_ctnt"+k).value);
                k++;
                sheetObjects[0].SetCellValue(i+1,5,eval("opener_obj.document.form.evi_ctnt"+k).value);
            }
        }			
    }
}
function sheet1_OnChange(sheetObj , Row, Col, Value){
    var net_amt=0;
    var vat_amt=0;
    var total_amt=0;
    var netArr=new Array();
    var vatArr=new Array();
    var minVatArr=new Array();
    var maxVatArr=new Array();
    var taxType=document.form[0]
    if(Col == 4){
        /*** TAX TYPE : 'Taxation' an automatic calculation processing only 10% VAT ***/
if(!checkTaxRadioValue())    sheetObj.SetCellValue(Row, 5,Math.round((parseFloat(sheetObj.GetCellValue(Row,4)*100)/10)/100),0);
    }	
    if(Col == 5){
        for(var i=0;i<sheetObj.RowCount();i++){
netArr[i]=sheetObj.GetCellValue(i+1, 4);
vatArr[i]=Math.round((parseFloat(sheetObj.GetCellValue(i+1,4)*100)/10)/100);
maxVatArr[i]=Math.round((parseFloat(sheetObj.GetCellValue(i+1,4)*100)/10)/100)+10;
minVatArr[i]=Math.round((parseFloat(sheetObj.GetCellValue(i+1,4)*100)/10)/100)-10;
        }								
if(maxVatArr[Row-1]<sheetObj.GetCellValue(Row, 5) || minVatArr[Row-1]>sheetObj.GetCellValue(Row, 5)){
            errMsg=ComGetMsg("TRS90198" );
            ComShowMessage(errMsg); 			
sheetObj.SetCellValue(Row, 5,Math.round((parseFloat(sheetObj.GetCellValue(Row,4)*100)/10)/100),0);
        }
    }				
    for(var i=0;i<sheetObj.RowCount();i++){
net_amt=parseFloat(sheetObj.GetCellValue(i+1,4)*100)+parseFloat(net_amt);
vat_amt=parseFloat(sheetObj.GetCellValue(i+1,5)*100)+parseFloat(vat_amt);
total_amt=parseFloat(sheetObj.GetCellValue(i+1,6)*100)+parseFloat(total_amt);
    }
    document.form.net_amt.value=net_amt/100;
    document.form.vat_amt.value=vat_amt/100;
    document.form.total_amt.value=total_amt/100; 
}		
function sheet1_OnSearchEnd(sheetObj,errMsg){
    if(errMsg!=null){
        ComShowMessage(errMsg);
    }
    var wkplc_nmstring=sheetObj.GetEtcData("wkplc_nmstring");
    var vndr_nm=sheetObj.GetEtcData("vndr_nm");
    var bzct_nm=sheetObj.GetEtcData("bzct_nm");
    var bztp_nm=sheetObj.GetEtcData("bztp_nm");
    var vndr_addr=sheetObj.GetEtcData("vndr_addr");
    var ceo_nm=sheetObj.GetEtcData("ceo_nm");
    var rgst_no=sheetObj.GetEtcData("rgst_no");
    document.form.vndr_nm.value=vndr_nm;
    document.form.bzct_nm.value=bzct_nm;
    document.form.bztp_nm.value=bztp_nm; 
    document.form.vndr_addr.value=vndr_addr; 
    document.form.ceo_nm.value=ceo_nm;    
    document.form.comp_no1.value=rgst_no.substring(0,3); 
    document.form.comp_no2.value=rgst_no.substring(3,5); 
    document.form.comp_no3.value=rgst_no.substring(5,10); 
    for(p=0;p< comboObjects.length;p++){
        initCombo (comboObjects[p],p+1, wkplc_nmstring);
    } 
       controlSheetColumnTax();
}
function sheet2_OnSearchEnd(sheetObj,errMsg){
    if(errMsg!=null){
        ComShowMessage(errMsg);
    }
    var gsFlg=sheetObj.GetEtcData("gsFlg");
    if(gsFlg=="MULTI01"){		
        var tax_no3=sheetObj.GetEtcData("tax_no3");
        document.form.tax_no3.value=tax_no3;
    }else if(gsFlg=="MULTI02"){
        var tax_code=sheetObj.GetEtcData("tax_code");
        document.form.tax_code.value=tax_code;	 	           	
    }
}     
function initCombo (comboObj, comboNo, wkplc_nmstring){
    var cnt=0 ;
    var wkplcNmArray=wkplc_nmstring.split("|");	
     switch(comboNo){
        case 1:             
            comboObj.RemoveAll();
           with (comboObj){                	
SetColAlign(0, "left");
SetColWidth(0, "60");
                       for(i=0 ;i<wkplcNmArray.length;i++){             
                       InsertItem(cnt++, wkplcNmArray[i], wkplcNmArray[i]);
                     } 	
                    }
           break;                                                  
        }
}
function searchTaxNo3(comObj)
{
   document.form.tax_no2.value=comObj.GetSelectCode();
   if(comObj.GetSelectCode()!= "" || tax_no2_onchageFlg != "Y"){
       document.form.f_cmd.value=MULTI01; 
       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH); 
   }
}          
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
function getElementValue(formObject, eleTp, eleNm) {
    var element;
    var numOfEle=formObject.elements.length;
    for (var i=0; i < numOfEle; i++){
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
            if (formObject.elements[i].checked == true){ 
                var ele_value=formObject.elements[i].value;
                break;
            }			
        }
    }
    return ele_value;
}     
function isNum(obj){
    //Only Number
    if (!ComIsNumber(obj)){
        obj.value='';
    }
}
function isNum1(obj){
    //Only Number
    if (!isNumDash(obj)){
        obj.value='';
    }
}		
function isDate1(obj){
    //Only Number
    if (!ComIsDate(obj)){
        obj.value='';
    }
}		     	 
function setOpenerInsertData(){
    var k=0;				
    opener_obj.document.form.tax_naid_flg.value=getElementValue(document.form, 'radio', 'tax_naid_flg');
    opener_obj.document.form.finance_flg.value=getElementValue(document.form, 'radio', 'finance_flg');
    opener_obj.document.form.fa_flg.value=getElementValue(document.form, 'radio', 'fa_flg');
    opener_obj.document.form.tax_type.value=getElementValue(document.form, 'radio', 'tax_type');
    opener_obj.document.form.tax_nsl_flg.value=getElementValue(document.form, 'radio', 'tax_nsl_flg');
    if( document.form.electronic.checked == true )
    	opener_obj.document.form.type.value='ELECTRONIC';
    else if (document.form.paper.checked == true )
    	opener_obj.document.form.type.value='PAPER';
    opener_obj.document.form.evi_inv_dt.value=document.form.inv_dt.value;
    opener_obj.document.form.evi_comp_no.value=document.form.comp_no1.value+ document.form.comp_no2.value+ document.form.comp_no3.value;
    opener_obj.document.form.evi_total_net_amt.value=document.form.net_amt.value;
    //--jsk opener_obj.document.form.evi_tax_no2.value = document.form.tax_no2.value;
    opener_obj.document.form.evi_tax_no2.value=comboObjects[0].GetSelectCode();
    opener_obj.document.form.evi_total_tax_amt.value=document.form.vat_amt.value;
    for(var i=0;i<sheetObjects[0].RowCount();i++){
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value=sheetObjects[0].GetCellValue(i+1,3);
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value=sheetObjects[0].GetCellValue(i+1,4);
        k++;
        eval("opener_obj.document.form.evi_ctnt"+ k).value=sheetObjects[0].GetCellValue(i+1,5);
    }
    opener_obj.document.form.evi_tax_no.value=document.form.tax_no1.value+comboObjects[0].GetSelectCode()+document.form.tax_no3.value;
    opener_obj.document.form.evi_tax_code.value=document.form.tax_code.value;
    opener_obj.document.form.eviInputFlg.value="Y";
    resetTaxFlag(opener_obj);
    var checkList=opener_obj.sheetObjects[0].FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    for(var i=0; i<checkArray.length-1; i++){
        opener_obj.sheetObjects[0].SetCellValue(checkArray[i], 'taxcheck',1,0);
    }
}
function resetTaxFlag(opener_obj){
    var checkList=opener_obj.sheetObjects[0].FindCheckedRow('taxcheck');
    var checkArray=checkList.split('|');
    for(var i=0; i<checkArray.length-1; i++){
        opener_obj.sheetObjects[0].SetCellValue(checkArray[i], 'taxcheck','0',0);
    }
}
function check_busino(vencod) {
    var sum=0;
    var getlist=new Array(10);
    var chkvalue=new Array("1","3","7","1","3","7","1","3","5");
    for(var i=0; i<10; i++) { getlist[i]=vencod.substring(i, i+1); }
    for(var i=0; i<9; i++) { sum += getlist[i]*chkvalue[i]; }
    sum=sum + parseInt((getlist[8]*5)/10);
    sidliy=sum % 10;
    sidchk=0;
    if(sidliy != 0) { sidchk=10 - sidliy; }
    else { sidchk=0; }
    if(sidchk != getlist[9]) { return false; }
    return true;
}		
function controlSheetColumnTax(){
    /*** TAX TYPE : 'Zero Tax' --> sheetObject.Tax Column disabled handling ***/
    if( checkTaxRadioValue() ){
        //for(var i=0; i<sheetObjects[0].RowCount+1; i++){
            //sheetObjects[1].InitCellProperty(i, 5, dtInteger, daRight);
        sheetObjects[0].InitDataProperty(0, 5, dtData, 150, daRight,	true, "", false, "", dfInteger, 0, false, false);
        //}
    }
}
function checkTaxRadioValue(){
     var taxType="";
     if (document.form.tax_type[0].checked == true)
         taxType=true;
     else
         taxType=false;
     return  taxType;
}
function BlurDate(obj){
   if (obj.value == "")
   {
	   return;
   }
   if ( !ComIsDate(obj) ){
		errMsg=ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	}
}
/* Check the bill type setting*/
function checkType(){
	if (document.form.electronic.checked == true && document.form.paper.checked == true){
		errMsg=ComGetMsg("TRS90402");
		ComShowMessage(errMsg);
		document.form.electronic.checked=false;
		document.form.paper.checked=false;
	}
}
