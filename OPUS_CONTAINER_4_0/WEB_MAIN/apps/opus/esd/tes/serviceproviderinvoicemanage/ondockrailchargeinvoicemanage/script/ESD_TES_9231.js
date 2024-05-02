/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9231.js
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var doneDefN3ptyBilCSCD=false;
var on_sheet_obj;
var opener_obj;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        /*******************************************************/
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btng_interfaceto3rd":
         	        if(checkMandatory(sheetObject)==true){
         	            doActionIBSheet(sheetObject,formObject,IBSAVE);
         	            ComClosePopup(); 
         	        }
        	        break;
         	    case "btn_ok":
         	    	ComClosePopup(); 
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param {ibsheet} sheet_obj 
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
        //tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
//        for(i=0;i<sheetObjects.length;i++){
//            ComConfigSheet(sheetObjects[i]);
//            initSheet(sheetObjects[i],i+1);
//            ComEndConfigSheet(sheetObjects[i]);
//        }
        tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
        opener_obj=window.dialogArguments;
        if (!opener_obj) opener_obj=window.opener;
        if (!opener_obj) opener_obj = parent;
		on_sheet_obj=eval('opener_obj.document.t'+document.form.sheet_idx.value+'sheet1');
//        doActionIBSheet(sheetObject,formObject,IBSEARCH);
}
    /** Mandatory check
     * 
     * @param {ibsheet} sheetObject
     * @return
     */ 
    function checkMandatory(sheetObject){
        var openerObj = window.dialogArguments;
        if (!openerObj) openerObj=window.opener;
        if (!openerObj) openerObj = parent;
        var formObj=document.form;
        var iCheckRow='';
        var count=0;           
        var chkCNTR=0;         // CNTR
        var billCase=0;        // Billing Case
        var result=false;
////        iCheckRow = sheetObject.FindCheckedRow('chk');
////        if(iCheckRow == null || iCheckRow ==''){
////            if(!confirm(ComGetMsg('TES40023'))){
////                openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
////                result = true;
////            }
////        }else{
//            for(var i = sheetObject.HeaderRows; i< sheetObject.HeaderRows+sheetObject.RowCount; i++){
//                if(sheetObject.CellValue(i,'chk') == "1"){
//                    if(sheetObject.CellValue(i,'cntr_no') != null){
//                        chkCNTR = chkCNTR + 1;
//                    }
//                    if(sheetObject.CellValue(i,'n3pty_bil_tp_cd') != ''){
//                        billCase = billCase + 1;
//                    }
//                    count = count + 1;
//                }
//            }
//
//            if(count>chkCNTR || count>billCase){
//                ComShowMessage(ComGetMsg('TES21701')); 
//            }else if(count == chkCNTR && count == billCase){
//                openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "Y";
//                result = true;
//            }
////        }
     var   changeCnt=0;
     var   delIfSeq="";
     for( var i=sheetObject.HeaderRows(); i < sheetObject.HeaderRows()+ sheetObject.RowCount(); i++ ) {
    	 if ( sheetObject.CellSearchValue(i, "chk") != sheetObject.GetCellValue( i , "chk" ) ) {
    		 if ( sheetObject.GetCellValue( i , "chk" ) == '0' ) {
    			 delIfSeq    += sheetObject.GetCellValue(i, "tml_if_seq" ) + "|";
             }
             changeCnt++;         	                         	                
         }
     }
     document.form.del_if_seq.value=delIfSeq;
     iCheckRow=sheetObject.FindCheckedRow('chk');
		if (iCheckRow == null || iCheckRow ==''){
			// TPB IF FLG 방지 추가 ( 2009-06-05 )
         if ( changeCnt > 0 ) {
             if ( !confirm('Do you want to delete 3rd party?')) {  
					return false;
             }
             for(var i=sheetObject.HeaderRows(); i< sheetObject.HeaderRows()+sheetObject.RowCount(); i++){
            	 if(sheetObject.GetCellValue(i,'chk') == "1"){
                	count=count + 1;
                }
            }   
     		if(count<1){
    			openerObj.t3sheet1.SetCellValue(formObj.opener_row.value,"n3pty_flg","");
    		}  
     		result=true; 
         } else {
             if (!confirm(ComGetMsg('TES40056'))){
                 //openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
            	 ComClosePopup(); 
                 return false;
             }
         }
     } else {
			for(var i=sheetObject.HeaderRows(); i< sheetObject.HeaderRows()+sheetObject.RowCount(); i++){
				if(sheetObject.GetCellValue(i,'chk') == "1"){
					if(sheetObject.GetCellValue(i,'cntr_no') != null){
                     chkCNTR=chkCNTR + 1;
                 }
					if(sheetObject.GetCellValue(i,'n3pty_bil_tp_cd') != ''){
                     billCase=billCase + 1;
                 }
                 count=count + 1;
             }
         }
			if(count>0){
				document.form.flg_yn.value="Y";
			}else{
				document.form.flg_yn.value="";
			}
         if (count>chkCNTR || count>billCase){
             ComShowMessage(ComGetMsg('TES21701'));
         } else if(count == chkCNTR && count == billCase) {
            openerObj.t3sheet1.SetCellValue(formObj.opener_row.value,"n3pty_flg","Y");
				//window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);
             result=true;
         }
			var arrRow=iCheckRow.split("|");
			for (var idx=0; arrRow!=null && idx<arrRow.length-1; idx++){ 
				if (sheetObject.GetCellValue(arrRow[idx],'cntr_no')==null || sheetObject.GetCellValue(arrRow[idx],'cntr_no')=='' ||
						sheetObject.GetCellValue(arrRow[idx],'n3pty_bil_tp_cd')==null || sheetObject.GetCellValue(arrRow[idx],'n3pty_bil_tp_cd')=='' ||
						sheetObject.GetCellValue(arrRow[idx],'curr_cd')==null || sheetObject.GetCellValue(arrRow[idx],'curr_cd')=='') 				{
					ComShowMessage(ComGetMsg('TES21701'));
					return false;
				}
			}
         if ( delIfSeq != "" ) {
             if ( !confirm('Do you want to delete 3rd party?')) { 
                 return false;
             }
         }		
     }
		//window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);
        return result;
    }
   /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj 
     * @param {int}     sheetNo 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
            	 with(sheetObj){
            	 	var HeadTitle="Seq|chk||lgs_cost_cd|Container No.|Billing Case|Curr.|Amount|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|Remarks|curr_cd|click_yn";
            	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 	InitHeaders(headers, info);

            	 	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                      {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     if(tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)){
                    	 cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     }else{
                    	 cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                     }
                     cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pop_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"if_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"click_yn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
          
                     InitColumns(cols);

                     SetEditable(1);
                     SetColProperty("vndr_cust_div_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
                     InitComboNoMatchText(true);
                     SetColProperty("n3pty_bil_tp_cd", {ComboText:comboNm, ComboCode:comboVal} );
                     resizeSheet();
               	}
                break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }
     /**
     * getThirdPartyBillingCaseHorizontally
     * @return
     */
     function setTpbBillcaseCode(){
//      tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
		comboNm=tes_tpbBillcaseCodeNm(document.getElementById('n3pty_bil_tp_cd_tmp').value);
		comboVal=tes_tpbBillcaseCodeVal(document.getElementById('n3pty_bil_tp_cd_tmp').value);
		for(i=0;i<sheetObjects.length;i++){
		    ComConfigSheet(sheetObjects[i]);
		    initSheet(sheetObjects[i],i+1);
		    ComEndConfigSheet(sheetObjects[i]);
		}
		getList();
     }
     /**
     * Billing Case Getting List
     * @return
     */
     function getList(){
     	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
/** handling sheet process
 *  @param {ibsheet} 	sheetObj		
 *  @param {form} 		formObj			
 *  @param {String}		sAction			
 */     
     function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:
//                if(formObj.calc_tp_cd.value == "A"){ //Auto Calcurated Cost
                    formObj.f_cmd.value=SEARCH;
                    //ComShowMessage(FormQueryString(formObj));
                    var searchXml=sheetObj.GetSearchData("ESD_TES_9231GS.do",  tesFrmQryStr(formObj));
                    sheetObj.RemoveAll();
                    //ComShowMessage(searchXml);
                    if (searchXml != "") sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
//                }
                break;
           case IBSAVE: 
				var total_amt=0;
				if (sheetObj.RowCount()> 0 && sheetObj.IsDataModified()){
				    for (var j=sheetObj.HeaderRows(); j<(sheetObj.HeaderRows()+ sheetObj.RowCount()); j++){
				    	if (sheetObj.GetCellValue(j,'chk')=='1'){
				    		total_amt=total_amt + Number(sheetObj.GetCellValue(j,'if_amt'));
				        } 
				    }
				    if(Number(document.form.inv_amt.value) < total_amt){
				        ComShowMessage('Amount should be less than Total Amount.');
				        return false;
				    }
					for (i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
						if (sheetObj.GetCellValue(i,'chk')=='1' && sheetObj.GetCellValue(i,'ibflag')!='R') {
							if (document.form.tml_so_ofc_cty_cd.value==undefined || document.form.tml_so_seq.value==undefined || document.form.tml_so_dtl_seq.value==undefined){
								ComShowMessage(ComGetMsg('TES23048'));  
								return false;
							}
							if(sheetObj.GetCellValue(i,'tml_if_seq')==null || sheetObj.GetCellValue(i,'tml_if_seq')==""){
//						         sheetObj.CellValue(i,'ibflag')='I' ;
						         sheetObj.SetRowStatus(i,"I");
						     }else{
//						         sheetObj.CellValue(i,'ibflag')='U' ;
						         sheetObj.SetRowStatus(i,"U");
						     }
							if (isNaN(sheetObj.GetCellValue(i,'if_amt')) || sheetObj.GetCellValue(i,'if_amt')<=0) {
							    ComShowMessage('Amount should be greater than 0.'); 
							    return false;
						     }	
						}else{
//						    sheetObj.CellValue(i,'ibflag')='R' ;
						    sheetObj.SetRowStatus(i,"R");
						}
					}
					formObj.f_cmd.value=MULTI;
					        var param=sheetObj.GetSaveString(false,false,'chk');
//					        if(param == ""){
//					            return false;
//					        }
					        var savexml=sheetObj.GetSaveData("ESD_TES_9231GS.do", param+'&'+tesFrmQryStr(formObj));
					        sheetObj.LoadSaveData(savexml,true);
				} else {
					ComShowMessage(ComGetMsg('TES40056'));  
					return false;
				}
                break;
          }
}
/**
 * 
 * @param {ibsheet} sheetObj	
 * @param {String}	Row			
 * @param {String}	Col			
 * @return
 */
     function sheet_OnPopupClick(sheetObj,Row,Col){
    	 tes_get3rdParty_sheet(sheetObj.GetCellValue(Row,"vndr_cust_div_cd"), Row, Col );
     }
   /** on change event
    * 
    * @param {ibsheet} 	sheetObj	
    * @param {String} 	Row			
    * @param {String} 	Col			
    * @return
    */
	function sheet_OnChange(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) == "pop_value"){
			if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='C'){
				sheetObj.SetCellValue(Row,"cust_seq"				,sheetObj.GetCellValue(Row,"pop_value").substring(2,8));
				sheetObj.SetCellValue(Row,"cust_cnt_cd"		,sheetObj.GetCellValue(Row,"pop_value").substring(0,2));
			}else if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='S'){
				sheetObj.SetCellValue(Row,"n3pty_ofc_cd"		,sheetObj.GetCellValue(Row,"pop_value").substring(2,8));
			}else if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='V'){
				sheetObj.SetCellValue(Row,"n3pty_vndr_seq"	,sheetObj.GetCellValue(Row,"pop_value").substring(2,8));
				sheetObj.SetCellValue(Row,"vndr_cnt_cd"		,sheetObj.GetCellValue(Row,"pop_value").substring(0,2));
			}
		}else if(sheetObj.ColSaveName(Col) == "if_amt" && sheetObj.GetCellValue(Row,"if_amt")<0){
		    sheetObj.SetCellValue(Row,"if_amt","");
		    ComShowMessage("Minus amout is not allowed to 3rd Party.");
		}
	}
	/** sheet search end event
	 * 
	 * @param {ibsheet}	sheetObj
	 * @return
	 */
	function sheet_OnSearchEnd(sheetObj){
	    var formObj=document.form;
		if (sheetObj.RowCount()> 0){
			if (document.form.calc_tp_cd.value=='A'){
				// for (var i=1; i<=sheetObj.RowCount; i++){
				for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
				    sheetObj.SetCellValue(i,'curr_cd',document.form.curr_cd.value);
				    if ((sheetObj.GetCellValue(i,'tml_if_ofc_cd')==null || sheetObj.GetCellValue(i,'tml_if_ofc_cd').trim()=='') ||
				    		(sheetObj.GetCellValue(i,'tml_if_seq')==null || sheetObj.GetCellValue(i,'tml_if_seq').trim()=='')) {
//						sheetObj.CellValue(i,'ibflag')='I';
						sheetObj.SetRowStatus(i,"I");
						if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
						    sheetObj.SetCellValue(i,'if_amt',Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value));
						}else{
						    sheetObj.SetCellValue(i,'if_amt',Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value));
						}
		            }
				    if (sheetObj.GetCellValue(i,"tml_so_dtl_seq")==null || sheetObj.GetCellValue(i,"tml_so_dtl_seq").trim()==''){
						sheetObj.SetCellValue(i,"tml_so_dtl_seq",formObj.tml_so_dtl_seq.value,0);
					}
				    if (sheetObj.GetCellValue(i,"lgs_cost_cd")==null || sheetObj.GetCellValue(i,"lgs_cost_cd").trim()==''){
						sheetObj.SetCellValue(i,"lgs_cost_cd",formObj.lgs_cost_cd.value,0);
					}
				}
			}
		}else{
			if (document.form.calc_tp_cd.value=='M'){
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,"tml_so_ofc_cty_cd",formObj.tml_so_ofc_cty_cd.value,0);
				sheetObj.SetCellValue(Row,"tml_so_seq",formObj.tml_so_seq.value,0);
				sheetObj.SetCellValue(Row,"vndr_cust_div_cd","C",0);
				sheetObj.SetCellValue(Row,"lgs_cost_cd",formObj.lgs_cost_cd.value,0);
				sheetObj.SetCellValue(Row,"calc_cost_grp_cd","ON",0);
				sheetObj.SetCellValue(Row,"n3pty_bil_tp_cd",'',0);
				sheetObj.SetCellValue(Row,"cntr_no",formObj.lgs_cost_cd.value+'00000',0);
				sheetObj.SetCellValue(Row,"if_amt",	formObj.inv_amt.value);
				
				sheetObj.SetCellValue(Row,"tml_so_dtl_seq",formObj.tml_so_dtl_seq.value,0);
				sheetObj.SetCellValue(Row,"curr_cd",formObj.curr_cd.value,0);
				sheetObj.SetCellValue(Row,"calc_tp_cd",formObj.calc_tp_cd.value,0);			
			}
		}
	}		
/**
 * 
 * @param {ibsheet}	sheet		sheet object
 * @param {String}	Row
 * @param {String}	Col
 * @param {String}	Value
 * @return
 */
function sheet_OnSaveEnd(sheet, Row, Col, Value) {
	if (sheet.RowCount()> 0){
        opener_obj=window.dialogArguments;
        if (!opener_obj) opener_obj=window.opener;
        if (!opener_obj) opener_obj = parent;
        
			opener_obj.t3sheet1.SetCellValue(document.form.opener_row.value,'n3pty_flg','Y',0);
			//opener_obj.disableTPBrow(document.form.sheet_idx.value, off_sheet_obj, sheet_curr_row);
			for (var i=sheet.HeaderRows(); i<(sheet.HeaderRows()+ sheet.RowCount()); i++){
				if(sheet.GetCellValue(i,'chk') == '0'){
			        if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
						    sheetObj.SetCellValue(i,'if_amt',Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value));
						}else{
						    sheetObj.SetCellValue(i,'if_amt',Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value));
						}
			    }
			}
	}
}
/** 
 * 
 * @param {ibsheet}	sheet		sheet object
 * @param {String}  row			
 * @param {String}	col			
 * @return
 */
function sheet_OnClick(sheet, row, col){
	if (sheet.ColSaveName(col) == "chk"){
		if(sheet.SetCellValue(row,"click_yn") == "Y")  sheet.GetCellValue(row,"click_yn","N");
		else sheet.SetCellValue(row,"click_yn","Y");
	} 
}
/** 
 * 
 * @return
 */
function setDefN3ptyBilCSCD(){
     if (doneDefN3ptyBilCSCD){
			return;
	}
	var retval=false;
	var formObj=document.form;
	if (sheetObjects[0].RowCount()> 0 && formObj.n3pty_bil_cs_cd!=undefined && formObj.n3pty_bil_cs_cd.value!=null && formObj.n3pty_bil_cs_cd.value.trim()!=''){
		for (var i=sheetObjects[0].HeaderRows(); i<(sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount()); i++){
			if (sheetObjects[0].GetCellValue(i,'n3pty_bil_tp_cd')==null || sheetObjects[0].GetCellValue(i,'n3pty_bil_tp_cd').trim()==''){
				sheetObjects[0].SetCellValue(i,'n3pty_bil_tp_cd',formObj.n3pty_bil_cs_cd.value,0);
				retval=true;
			}
		}
	}
	// TPB BillingCase Code TES
	tes_getInputValueInvoice('n3pty_bil_tp_cd_tmp', SEARCH07, '', 'setTpbBillcaseCode');
	return retval;
}
