/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0037.js
*@FileTitle  : Transportion invoice CSR Creation - Statements
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var Radiocount=0;
var comboObjects=new Array();
var comboCnt=0 ; 
var opener_obj=window.dialogArguments;
if (!opener_obj)  opener_obj=window.opener;
if (!opener_obj) opener_obj=parent;
var opener_sheet_obj=opener_obj.sheet1;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
    function processButtonClick(){
         /***** Adding additional sheet variables to use more than one sheet per a tab *****/
			 var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btng_ok_k":		
					if(formObject.electronic.checked == false && formObject.paper.checked == false){
	                    errMsg=ComGetMsg("TRS90401" );
	                    ComShowMessage(errMsg);
	                    formObject.electronic.focus();
	                    return false;
	                }
					if(formObject.tax_no1.value == "" || formObject.tax_no1.value.length != 6){
                        errMsg=ComGetMsg("TRS90013" );
                        errMsg="Enter the tax number.";
                        ComShowMessage(errMsg);
                        formObject.tax_no1.focus();
						return false;
					}
					formObject.tax_no2.value=comboObjects[0].GetSelectCode();
					if(formObject.tax_no2.value == "" || formObject.tax_no2.value == null){
					    errMsg="Select the office.";
					    ComShowMessage(errMsg);
					    return false;
					}									
					var saupjano=formObject.comp_no1+formObject.comp_no2 + formObject.comp_no3;
					var saupjano1=formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;						
					/**
					if(!ComIsSaupjaNo(saupjano)){
                    errMsg=ComGetMsg("TRS90018" );
                    ComShowMessage(errMsg);		
							return false;			
					}
					**/
					if(formObject.comp_no1.value == "" || formObject.comp_no2.value == "" || formObject.comp_no3.value == ""){
					    errMsg="Input the company number";
					    if(formObject.comp_no1.value == "")        formObject.comp_no1.focus();
					    else if(formObject.comp_no2.value == "")   formObject.comp_no2.focus(); 
					    else if(formObject.comp_no3.value == "")   formObject.comp_no3.focus(); 
					    ComShowMessage(errMsg);
					    return false;
					}				
					if(formObject.total_amt_hdr.value != formObject.total_amt.value){
                            errMsg=ComGetMsg("TRS90013" );
                            ComShowMessage(errMsg);
							return false;
					}
					if(ComIsNull(ComGetObjValue(formObject.finance_flg))){
                            errMsg=ComGetMsg("TRS90016" );
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
											break;
											return false;
									}
							}
					}
                    if(formObject.tax_no3.value == null || formObject.tax_no3.value == "")    searchTaxNo3(comboObjects[0]);					
					setOpenerInsertData();
                    errMsg=ComGetMsg("TRS90028" );
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
					formObject.comp_no1.value="";
					formObject.comp_no2.value="";
					formObject.comp_no3.value="";
					formObject.inv_dt.value="";			
					sheetObjects[0].RemoveAll();
					break;
				case "btng_add_k":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btng_delete_k":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;
				case "btn_close":
					ComClosePopup(); 
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
    function searchTaxNo3(comObj)
    {
       document.form.tax_no2.value=comObj.GetSelectCode();
       if(comObj.GetSelectCode()!= "" || tax_no2_onchageFlg != "Y"){
	       document.form.f_cmd.value=MULTI01; 
	       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH); 
       }
    } 
    /**
 * Register IBSheet Object with array
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, '');
        }				
				ComEnableObject(document.form.vndr_seq_hdr, false);				
				ComEnableObject(document.form.total_amt_hdr, false);
				ComEnableObject(document.form.page, false);
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
				ComEnableObject(document.form.total_amt, false);			
				insertValue();
    }
  /**
     * Define the initial values and headers of sheets
     * 
     * 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
                //no support[check again]CLT style.height=GetSheetHeight(8);
		             var HeadTitle1=" |STS|seq|name|cost" ;
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
		             SetEditable(1);
                 }
            break;
            case 2:      //sheet1 init
                with(sheetObj){
                //no support[check again]CLT style.height=GetSheetHeight(8);
		             var HeadTitle1="seq" ;
		
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
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
               	formObj.f_cmd.value=SEARCHLIST;                  
                sheetObj.DoSearch("ESD_TRS_0034GS.do", TrsFrmQryString(formObj), {Sync:2});
                break; 
           case IBINSERT:      // Insert 
           			if(sheetObj.RowCount()== 4){
                       return ;
           			}else{
                		sheetObj.DataInsert();
                     }
                break;
           case IBCOPYROW:        
              sheetObj.DataCopy();
              break;
           case IBDELETE:
              var chkRows=sheetObj.FindCheckedRow("sel") ;
              var arrRow=chkRows.split("|");
              for (idx=arrRow.length-2; idx >= 0; idx--){ 
                sheetObj.RowDelete(arrRow[idx] , false);
              }
     		var net_amt=0;     		
     		var total_amt=0;
			for(var i=0;i<sheetObjects[0].RowCount();i++){
				net_amt=parseFloat(sheetObjects[0].GetCellValue(i+1,4)*100)+parseFloat(net_amt);
			}
            document.form.net_amt.value=net_amt/100;        
            document.form.total_amt.value=net_amt/100;    
           break;
        }
    }
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
               	formObj.f_cmd.value=MULTI01;                  
                sheetObj.DoSearch("ESD_TRS_0034_037GS.do", TrsFrmQryString(formObj) );
                break;
        }
    }    
   /**
    * Validating inputted values of form
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
   if (!ComIsNumber(iPage)) {
//
       return false;
   }
        }
        return true;
    }
	function insertValue(){
			document.form.vndr_seq.value=opener_obj.document.form.vndr_seq.value;
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
			for(k=0;k<checkRowArray.length;k++){ 					  						
				total_amt=total_amt+parseFloat(opener_sheet_obj.GetCellValue(checkRowArray[k], "inv_ttl_amt"));
			}				
			document.form.total_amt_hdr.value=total_amt;
			if(total_amt>0){
					document.form.finance_flg[0].checked=true;
					document.form.finance_flg[1].disabled=true;
			}else if(total_amt<=0){					
					document.form.finance_flg[0].disabled=true;
					document.form.finance_flg[1].checked=true;					
			}		
	}
	function insertValueEvi(){
			var k=0;			
			if(opener_obj.document.form.eviInputFlg.value=="Y"){								
					tax_no2_onchageFlg="Y";
					document.form.tax_no1.value=opener_obj.document.form.evi_tax_no.value.substring(0 , 6 );
					comboObjects[0].SetSelectCode(opener_obj.document.form.evi_tax_no.value.substring(6 , 11),false);
					document.form.tax_no3.value=opener_obj.document.form.evi_tax_no.value.substring(11, 15);									
					if(opener_obj.document.form.finance_flg.value == "Y"){
							document.form.finance_flg[0].checked=true;
							document.form.finance_flg[1].checked=false;
					}else if(opener_obj.document.form.finance_flg.value == "N"){
							document.form.finance_flg[1].checked=true;
							document.form.finance_flg[0].checked=false;
					}						
					document.form.comp_no1.value=opener_obj.document.form.evi_comp_no.value.substring(0,3);
					document.form.comp_no2.value=opener_obj.document.form.evi_comp_no.value.substring(3,5);
					document.form.comp_no3.value=opener_obj.document.form.evi_comp_no.value.substring(5,10);
					document.form.inv_dt.value=opener_obj.document.form.evi_inv_dt.value;						
					document.form.net_amt.value=opener_obj.document.form.evi_total_net_amt.value;						
					//document.form.vat_amt.value = opener_obj.document.form.evi_total_tax_amt.value;	
					for(var i=0;i<4;i++){ 
							if(eval("opener_obj.document.form.evi_ctnt"+(k+1)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+2)).value != "" ){
									sheetObjects[0].DataInsert(-1);
									k++;
									sheetObjects[0].SetCellValue(i+1,3,eval("opener_obj.document.form.evi_ctnt"+k).value);
									k++;
									sheetObjects[0].SetCellValue(i+1,4,eval("opener_obj.document.form.evi_ctnt"+k).value);
									k++;
							}
					}			
			}
	}				
    function sheet1_OnChange(Row,Col,Value){
     		var net_amt=0;     		
     		var total_amt=0;
     		//if(Col == 4 || Col == 5){ 
 				for(var i=0;i<sheetObjects[0].RowCount();i++){
 					net_amt=parseFloat(sheetObjects[0].GetCellValue(i+1,4)*100)+parseFloat(net_amt);
 				}
     		//} 
        document.form.net_amt.value=net_amt/100;        
        document.form.total_amt.value=net_amt/100;                
    }		
    function sheet2_OnSearchEnd(sheetObj, code, errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        var tax_no3=sheetObj.GetEtcData("tax_no3");
        document.form.tax_no3.value=tax_no3;
    }          
    function sheet1_OnSearchEnd(sheetObj,code, errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        var wkplc_nmstring=sheetObj.GetEtcData("wkplc_nmstring");
		 		var vndr_nm=sheetObj.GetEtcData("vndr_nm");
		 		var bzct_nm=sheetObj.GetEtcData("bzct_nm");
		 		var bztp_nm=sheetObj.GetEtcData("bztp_nm");
		 		var vndr_addr=sheetObj.GetEtcData("vndr_addr");
		 		var ceo_nm=sheetObj.GetEtcData("ceo_nm");
        document.form.vndr_nm.value=vndr_nm;
        document.form.bzct_nm.value=bzct_nm;
        document.form.bztp_nm.value=bztp_nm; 
        document.form.vndr_addr.value=vndr_addr; 
        document.form.ceo_nm.value=ceo_nm;        
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, wkplc_nmstring);
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
    //function tax_no2_OnChange(comObj,index,text)
    //{
    //  document.form.tax_no2.value = comObj.Code;
    //   if(comObj.Code != "" || tax_no2_onchageFlg != "Y"){
//	document.form.f_cmd.value=MULTI01; 
//	doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH); 
    //   }
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
	function isNum(obj){
		//Only number
		if (!ComIsNumber(obj)){
			obj.value='';
		}
	}
	function isNum1(obj){
		//Only number
		if (!isNumDash(obj)){
			obj.value='';
		}
	}		
	function isDate1(obj){
		//Only number
		if (!ComIsDate(obj)){
			obj.value='';
			}
	}
function setOpenerInsertData(){
    var k=0;
    opener_obj.document.form.evi_inv_dt.value=document.form.inv_dt.value;
    opener_obj.document.form.evi_comp_no.value=document.form.comp_no1.value+ document.form.comp_no2.value+ document.form.comp_no3.value; 
    opener_obj.document.form.evi_total_net_amt.value=document.form.net_amt.value;
    opener_obj.document.form.evi_tax_no2.value=comboObjects[0].GetSelectCode();
    if( document.form.electronic.checked == true )
    	opener_obj.document.form.type.value='ELECTRONIC';
    else if (document.form.paper.checked == true )
    	opener_obj.document.form.type.value='PAPER';
    for(var i=0;i<sheetObjects[0].RowCount();i++){
            k++;
            eval("opener_obj.document.form.evi_ctnt"+ k).value=sheetObjects[0].GetCellValue(i+1,3);
            k++;
            eval("opener_obj.document.form.evi_ctnt"+ k).value=sheetObjects[0].GetCellValue(i+1,4);
            k++;
            eval("opener_obj.document.form.evi_ctnt"+ k).value="";
    }
    opener_obj.document.form.evi_tax_no.value=document.form.tax_no1.value+comboObjects[0].GetSelectCode()+document.form.tax_no3.value;
    opener_obj.document.form.evi_tax_code.value="Indent note";
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
/* Check type setting */
function checkType(){
	if (document.form.electronic.checked == true && document.form.paper.checked == true){
		errMsg=ComGetMsg("TRS90402");
		ComShowMessage(errMsg);
		document.form.electronic.checked=false;
		document.form.paper.checked=false;
	}
}
