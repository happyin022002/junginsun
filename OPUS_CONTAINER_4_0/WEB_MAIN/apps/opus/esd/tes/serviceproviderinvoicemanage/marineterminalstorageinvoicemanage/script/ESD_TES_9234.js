/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9234.js
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/

/**
 * @extends Tes
 * @class ESD_TES_9234 : business script for  Marine Terminal Storage Invoice Creation & Correction -- 3rd Party Billing Input
 */
function ESD_TES_9234() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.setComboObject=setComboObject;
	this.setTabObject=setTabObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.initTab=initTab;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var trd_if_hidden_idx='';
	var opener_obj;
	var off_sheet_obj;
	var sheet_curr_row;
	var doneDefN3ptyBilCSCD=false;
	var	comboNm;
	var	comboVal;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 * @return
	 */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObj=sheetObjects[0];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObj,formObject,IBINSERT);
        	        break;
                case "btng_rowdel":

	    				var sheet1DelCount=0;
	    				var changeCnt=0;
	         	        var del_if_seq="";
	         	        var del_cntr_seq="";
	         	        var k=0;
	         	        
	    				for(var i=0;i<sheetObj.RowCount();i++){
	    					if(sheetObj.GetCellValue(i+1, 0)==1){
	    						sheet1DelCount++;
	    					}
	    				}
	    				
	    				if(sheet1DelCount>0){
	    					for(var i=0;i<sheetObj.RowCount();i++){
	    						if(sheetObj.GetCellValue(i+1,"ibflag") == "I" && sheetObj.GetCellValue(i+1,0) == 1) {
	    							sheetObj.RowDelete(i+1, false);
	    							k++;
	    							i=i-k;
	    						}
	    					}
	    				}						
	    					
	         	        for( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++ ) {
	     	        		if ( sheetObj.GetCellValue( i , "chk" ) == '1' ) {
	     	        			del_if_seq    += sheetObj.GetCellValue(i, "tml_if_seq" ) + "|";
	     	        			del_cntr_seq  += sheetObj.GetCellValue(i, "tml_so_cntr_list_seq" ) + "|";
	     	        			changeCnt++;
	     	                }
	         	        }
	         	        
	         	        document.getElementById("del_if_seq").value=del_if_seq;
	         	        document.getElementById("del_cntr_seq").value=del_cntr_seq;
	         	        
	     	            if ( changeCnt > 0 ) {
	     	                if (confirm(ComGetMsg('TES60103'))) {    // 'Do you want to delete 3rd party?'
	        					formObject.f_cmd.value=MULTI;
	        					var param=sheetObj.GetSaveString(true,false);
	        					if(param == ""){
	        					     return false;
	        					}
	        					
	        	     	        for( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++ ) {
	        	 	        		if ( sheetObj.GetCellValue( i , "chk" ) == '1' ) {
	        	 	        			sheetObj.RowDelete(i, false);
	        	 	        			i=i-1;
	        	 	                }
	        	     	        }
	        	     	        
	        					var savexml=sheetObj.GetSaveData("ESD_TES_9233Popup.do", param+'&'+tesFrmQryStr(formObject));
	        					sheetObj.LoadSaveData(savexml,true);
	        					
	                        }
	     	            } else if(k==0){
	     	                if (!confirm(ComGetMsg('TES40056'))){    
	                    		//window.close();
	                            return false;
	                        }
	     	            }
                	
                	
                    break;
         	    case "btng_interfaceto3rd":
         	        // TPB I/F 저장 확인 - ( 2009-06-02 )
         	        var   changeCnt=0;
         	        var   del_if_seq="";
         	        var   del_cntr_seq="";
//         	        for( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++ ) {
//         	        		if ( sheetObj.CellSearchValue(i, "chk") != sheetObj.GetCellValue( i , "chk" ) ) {
//         	        			if ( sheetObj.GetCellValue( i , "chk" ) == '0' ) {
//         	        				del_if_seq    += sheetObj.GetCellValue(i, "tml_if_seq" ) + "|";
//         	        				del_cntr_seq  += sheetObj.GetCellValue(i, "tml_so_cntr_list_seq" ) + "|";
//         	                }
//         	                changeCnt++;         	                         	                
//         	            }
//         	        }
//         	        document.getElementById("del_if_seq").value=del_if_seq;
//         	        document.getElementById("del_cntr_seq").value=del_cntr_seq;
           	        iCheckRow=sheetObj.FindCheckedRow('chk');
         	        if ( iCheckRow == null || iCheckRow =='' ) {
         	            if ( changeCnt > 0 ) {
         	                if ( confirm('Do you want to delete 3rd party?')) {
             					doActionIBSheet(sheetObj,formObject,IBSAVE);
                            }
         	            } else {
         	                if (!confirm(ComGetMsg('TES40056'))){
                        		//window.close();
                                return false;
                            }
         	            }
                        return false;
         	        } else {
         	            if ( del_if_seq != "" ) {
         	                if ( confirm('Do you want to delete 3rd party?')) {
             					doActionIBSheet(sheetObj,formObject,IBSAVE);
                            }
         	            } else {
         	               doActionIBSheet(sheetObj,formObject,IBSAVE);
         	            }
         	        }
        	        //window.close();
        	        break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
	 /**
	  * registering IBSheet Object as list
	  * adding process for list in case of needing batch processing with other items
	  * defining list on the top of source
	  * @param {ibsheet} 	sheet_obj 	IBSheet Object
	  * @return     
	  */ 
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
 	/**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
 	 * @return
 	 */
    function loadPage() {
    	// TPB BillingCaseCode Default
		tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'param_lgs_cost_cd', 'setDefN3ptyBilCSCD');
	}
    /**
     * N3pty_Bil_CS_CD set default value
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
		tes_getInputValueInvoice('n3pty_bil_tp_cd_tmp', SEARCH07, '', 'setTpbBillcaseCode');
		return retval;
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj ==> , sheetNo ==>  
	 * adding case as numbers of counting sheets
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		 case 1:      //sheet1 init
			 with(sheetObj){      
			       
			       var HeadTitle="||Container No.|Billing Case|Curr.|Amount|3rd Party|3rd Party|Remark";

			       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1, ComboMaxHeight:170 } );

			       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			       var headers = [ { Text:HeadTitle, Align:"Center"} ];
			       InitHeaders(headers, info);

			       var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			              {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"n3pty_bil_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			             if(tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)){
			       cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			       }else{
			       cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			       }
			       cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			       cols.push({Type:"Popup",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trd_party_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			       cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"if_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"vndr_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_if_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_if_seq",            KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tmp_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tmp_tpb_seq",           KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"" });
			       cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"" });
			  
			       InitColumns(cols);
			       SetColProperty("vndr_cust_div_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
			       SetColProperty("n3pty_bil_tp_cd", {ComboText:comboNm, ComboCode:comboVal} );
					 
			       SetEditable(1);
			       SetSheetHeight(240);
			       InitComboNoMatchText(true);
			       
			       }


			break;
		}
	}
     /**
     * @return
     */
    function setTpbBillcaseCode(){
 		comboNm=tes_tpbBillcaseCodeNm(document.getElementById('n3pty_bil_tp_cd_tmp').value);
		comboVal=tes_tpbBillcaseCodeVal(document.getElementById('n3pty_bil_tp_cd_tmp').value);
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj=document.form;
		if (formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
			ComShowMessage(ComGetMsg('TES24046'));
			return false;
		}
		if (formObj.calc_tp_cd.value==null || formObj.calc_tp_cd.value.trim()==''){
			ComShowMessage(ComGetMsg('TES40055'));
			return false;
		}
		if (formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
			ComShowMessage(ComGetMsg('TES24046'));
		} else {
			if (formObj.calc_cost_grp_cd.value.trim()=='SP'){
				trd_if_hidden_idx='_2';
			}
		}
		// initializing global variable
		opener_obj=window.dialogArguments;
		if (!opener_obj)  opener_obj=window.opener;  //이 코드 추가할것
		if (!opener_obj) opener_obj=parent; //이 코드 추가할것
		off_sheet_obj=eval('opener_obj.t'+document.form.sheet_idx.value+'sheet1');
		sheet_curr_row=document.form.sheet_curr_row.value;
 		if (formObj.sheet_idx.value!=undefined && formObj.sheet_idx.value=='3'){ 
			//FD CALC
			if (formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='A'){
				document.all.item("enableRowButton").style.display="none";
				document.all.item("disableRowButton").style.display="inline";
			} else if (formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
				document.all.item("enableRowButton").style.display="inline";
				document.all.item("disableRowButton").style.display="none";
			}
		} else if (formObj.sheet_idx.value!=undefined && formObj.sheet_idx.value=='4'){ 
			//FP CALC
			document.all.item("enableRowButton").style.display="inline";
			document.all.item("disableRowButton").style.display="none";
		}
 		getList();
//   	 	tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
    }
    /**
     * Billing Case get List
     * @return
     */
    function getList(){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }	 
 	/**
 	 * handling sheet process
 	 * @param {ibsheet} sheetObj 	IBSheet Object
 	 * @param {form} 	formObj		Form Object
 	 * @param {int}		sAction		
 	 * @return
 	 */     
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		   case IBSEARCH:
//                if (!validateForm(sheetObj,formObj,sAction)){
//			        return false;
//			    }
				if (formObj.calc_cost_grp_cd.value==undefined || formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
					ComShowMessage(ComGetMsg('TES21035')); //ComShowMessage('[ERR] calc_cost_grp_cd');
					return false;
				}
				if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SP'){
					formObj.f_cmd.value=SEARCHLIST01;
				} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SD'){
					formObj.f_cmd.value=SEARCHLIST02;
				} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='EQ'){
					formObj.f_cmd.value=SEARCHLIST02;
				}			
				sheetObj.DoSearch("ESD_TES_9234Popup.do", tesFrmQryStr(formObj) );
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
				    	ComShowMessage(ComGetMsg('TES60101'));	//Amount should be less than Total Amount.
				        return false;
				    }
				    for (i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
				    	if (sheetObj.GetCellValue(i,'chk')=='1') {
				    		if (sheetObj.GetCellValue(i,'tml_so_ofc_cty_cd')==undefined || sheetObj.GetCellValue(i,'tml_so_seq')==undefined || sheetObj.GetCellValue(i,'tml_so_dtl_seq')==undefined){
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
				    		if(sheetObj.GetCellValue(i, "n3pty_bil_tp_cd")=="") {
				        		ComShowMessage( ComGetMsg('TES60107', i, 'Billing Case') ); //'{?msg1} Row [{?msg2}]is mandantory item.'
				        		return false;
				        	}
				    		if (isNaN(sheetObj.GetCellValue(i,'if_amt')) || sheetObj.GetCellValue(i,'if_amt')<=0) {
								 ComShowMessage(ComGetMsg('TES60102')); 	//Amount should be greater than 0.
								return false;
							}								
						}else{
//						    sheetObj.CellValue(i,'ibflag')='R' ;
						    sheetObj.SetRowStatus(i,"R");
						}
						sheetObj.SetCellValue(i,'vndr_seq',formObj.vndr_seq.value );
					}
					formObj.f_cmd.value=MULTI;
					var param=sheetObj.GetSaveString(true,false);
					if(param == ""){
					     return false;
					}					
					var savexml=sheetObj.GetSaveData("ESD_TES_9234Popup.do", param+'&'+tesFrmQryStr(formObj));		    
					sheetObj.LoadSaveData(savexml,true);
				} else {
					ComShowMessage(ComGetMsg('TES40056')); 
					return false;
				}
                break;
            case IBINSERT:
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,"tml_so_ofc_cty_cd", formObj.tml_so_ofc_cty_cd.value,0);
				sheetObj.SetCellValue(Row,"tml_so_seq", formObj.tml_so_seq.value,0);
				sheetObj.SetCellValue(Row,"vndr_cust_div_cd","C", 0);
				sheetObj.SetCellValue(Row,"lgs_cost_cd", formObj.param_lgs_cost_cd.value,0);
				sheetObj.SetCellValue(Row,"calc_cost_grp_cd", formObj.calc_cost_grp_cd.value,0);
				sheetObj.SetCellValue(Row,"n3pty_bil_tp_cd",'',0);
				if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value=='SP'){
					sheetObj.SetCellEditable(Row,'cntr_no',1);
				} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SD'){
					if (formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
						sheetObj.SetCellEditable(Row,'cntr_no',1);
					}				
				}
				sheetObj.SetCellValue(Row,"tml_so_dtl_seq",formObj.tml_so_dtl_seq.value,0);
				sheetObj.SetCellValue(Row,"curr_cd",formObj.curr_cd.value,0);
				sheetObj.SetCellValue(Row,"calc_tp_cd",formObj.calc_tp_cd.value,0);
				break;
			case IBDELETE:
				if (sheetObj.RowCount()> 0){
					var Row=sheetObj.GetSelectRow();
					sheetObj.RowDelete(Row, false);
				}
				break;
		}
    }
	/**
	 * handling process for input validation
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		
	 * @return
	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
  	 /**
  	  * search end event
  	  * @param {sheet}	sheetObj		ibsheet
  	  * @param {string}	ErrMsg			error message
  	  * @return
  	  */                
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		if (sheetObj.RowCount()> 0){
			if (document.form.calc_tp_cd.value=='A'){
				for (var i=1; i<=sheetObj.RowCount(); i++){
				    sheetObj.SetCellValue(i,'curr_cd',document.form.curr_cd.value);
				    if ((sheetObj.GetCellValue(i,'tml_if_ofc_cd')==null || sheetObj.GetCellValue(i,'tml_if_ofc_cd')=='') ||
				    		(sheetObj.GetCellValue(i,'tml_if_seq')==null || sheetObj.GetCellValue(i,'tml_if_seq')=='')) {
//						sheetObj.CellValue(i,'ibflag')='I';
						sheetObj.SetRowStatus(i,"I");
						  //sheetObj.CellValue(i,'if_amt')=document.form.inv_amt.value;
						  sheetObj.SetCellValue(i,'if_amt',Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value)*Number(document.form.ovr_dys.value));
					}
				    if (sheetObj.GetCellValue(i,"lgs_cost_cd")==null || sheetObj.GetCellValue(i,"lgs_cost_cd").trim()==''){
						sheetObj.SetCellValue(i,"lgs_cost_cd",formObj.param_lgs_cost_cd.value,0);
					}
				}
			}
		}
		
		if(sheetObj.RowCount()< 1){
			var Row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(Row,"tml_so_ofc_cty_cd", formObj.tml_so_ofc_cty_cd.value,0);
			sheetObj.SetCellValue(Row,"tml_so_seq", 	formObj.tml_so_seq.value,0);
			sheetObj.SetCellValue(Row,"vndr_cust_div_cd","C", 0);
			sheetObj.SetCellValue(Row,"lgs_cost_cd", 	formObj.param_lgs_cost_cd.value,0);
			sheetObj.SetCellValue(Row,"cntr_no",			formObj.param_lgs_cost_cd.value+'00000');
			sheetObj.SetCellValue(Row,"calc_cost_grp_cd", formObj.calc_cost_grp_cd.value,0);
			sheetObj.SetCellValue(Row,"n3pty_bil_tp_cd",'',0);
			sheetObj.SetCellValue(Row,"if_amt",			formObj.inv_amt.value);
			
			if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value=='SP'){
				sheetObj.SetCellEditable(Row,'cntr_no',1);
			} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SD'){
				if (formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
					sheetObj.SetCellEditable(Row,'cntr_no',1);
				}				
			}
			sheetObj.SetCellValue(Row,"tml_so_dtl_seq",formObj.tml_so_dtl_seq.value,0);
			sheetObj.SetCellValue(Row,"curr_cd",formObj.curr_cd.value,0);
			sheetObj.SetCellValue(Row,"calc_tp_cd",formObj.calc_tp_cd.value,0);			
		}
		
	}
	/**
	 * save end event
	 * @param {sheet}	sheet			ibsheet
	 * @param {int}		Row				sheet row index
	 * @param {int}		Col				sheet column index
	 * @param {int}		Value			
	 * @return
	 */		
	function sheet1_OnSaveEnd(sheet, Row, Col, Value) {
	    iCheckRow=sheet.FindCheckedRow('chk');
     	if ( iCheckRow == null || iCheckRow == '' ) {
          off_sheet_obj.SetCellValue(sheet_curr_row,'n3pty_flg','',0);
     	} else {
     	    off_sheet_obj.SetCellValue(sheet_curr_row,'n3pty_flg','Y',0);
     	}
		if (sheet.RowCount()> 0){
//			off_sheet_obj.CellValue2(sheet_curr_row,'n3pty_flg') = 'Y';
			opener_obj.disableTPBrow(document.form.sheet_idx.value, off_sheet_obj, sheet_curr_row);
		}
		ComClosePopup(); 
	}
	/**
	 * sheet click event
	 * @param {sheet}	sheetObj		ibsheet
	 * @param {int}		Row				sheet row index
	 * @param {int}		Col				sheet column index
	 * @return
	 */			
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		tes_get3rdParty_sheet(sheetObj.GetCellValue(Row,"vndr_cust_div_cd"), Row, Col, false);
	}
	
	/**
     * CoTes.js 에서 팝업 모드변경이 안되서
     */
    /*function tes_get3rdParty_sheet(val, Row, Col, bModal){
    	var strTrd_party=val;
    	if(strTrd_party=='C'){
//    		ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 480, 'tes_getCustomer_sheet', '1,0,1,1,1,1,1,1'	, Row, Col, true);
    		ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 480, 'tes_getCustomer_sheet', '1,0,1,1,1,1,1,1', bModal, false, Row, Col, 0);
    	}else if(strTrd_party=='S'){
//    		ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 580, 'tes_getStaff_sheet', '1,0,1,1,1,1,1,1', Row, Col, true, true);
    		ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 560, 'tes_getStaff_sheet', '1,0,1,1,1,1,1,1', bModal, false, Row, Col, 0);
    	}else if(strTrd_party=='V'){
//    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 620, 480, 'tes_getVendor_sheet', '1,0,1,1,1,1,1,1', Row, Col, true);
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 706, 460, 'tes_getVendor_sheet', '1,0,1,1,1,1,1,1', bModal, false, Row, Col, 0);
    	}else{
    	    ComShowMessage(ComGetMsg('TPB90015') );
    	}
    }*/
