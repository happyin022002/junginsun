/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0890.js
*@FileTitle  : Cargo Detail Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common global variable

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var cntr_tpsz_str = "";
 var eq_sub_cntr_tpsz_str = ""; 		
	
 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /* */
 		var sheetObject1=sheetObjects[0];
 		var sheetObject2=sheetObjects[1];
          /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)){
				return false;
			}
             switch(srcName) {
				case "btn_Add":
					addRow=sheetObject1.DataInsert(-1);
					sheetObjects[0].SetCellValue(addRow, "rcv_term_cd",ComGetObjValue(formObject.rcv_term_cd));
					sheetObjects[0].SetCellValue(addRow, "de_term_cd",ComGetObjValue(formObject.de_term_cd));
					if(ComGetObjValue(formObject.mixed_flg) != "Y"){
					}else{
						if(ComGetObjValue(formObject.rcv_term_cd) == "M"){
							sheetObjects[0].SetCellEditable(addRow, "rcv_term_cd",1);
						}else{
							sheetObjects[0].SetCellEditable(addRow, "rcv_term_cd",0);
						}
						if(ComGetObjValue(formObject.de_term_cd) == "M"){
							sheetObjects[0].SetCellEditable(addRow, "de_term_cd",1);
						}else{
							sheetObjects[0].SetCellEditable(addRow, "de_term_cd",0);
						}					
					}					
				break;
				case "btn_Delete":
					sheetObject1.RowDelete(sheetObject1.GetSelectRow(),false);
					setTotalVol("1");
				break;	
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;	
				case "btn_Close":
                    ComClosePopup(); 
				break;																				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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
		     ComConfigSheet (sheetObjects[i] );
		     initSheet(sheetObjects[i],i+1);
		     ComEndConfigSheet(sheetObjects[i]);
		 }
		 //sheetObjects[0].AutoSizeMode = false;
		 var formObj=document.form;
		 if(ComGetObjValue(formObj.callTp) != "B"){//other screens except bkg creation(container)
			 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 }else{
			 /* sheet3 */
			 var parentQtyDtlSheet;
			 /* sheet0 */
			 var parentQuantitySheet;
			 
			 var myParent = opener||parent;
			 
			 // Copying Qty Dtl Info. of Main
//			 var sheetIdx = 3;
//			 if(ComIsNull(formObj.callSheetIdx1)){
//				 sheetIdx = formObj.callSheetIdx1.value;
//			 }
		     if (opener && opener.sheetObjects){
		    	 parentQtyDtlSheet =opener.sheetObjects[3]; 
		     } else if (parent && parent.sheetObjects) {
		    	 parentQtyDtlSheet =parent.sheetObjects[3];    	
		     }
            
             
			 // Copying Quantity Info. of Main
//			 sheetIdx=0
//			 if(ComIsNull(formObj.callSheetIdx2)){
//				 sheetIdx=formObj.callSheetIdx2.value;
//			 }
		     if (opener && opener.sheetObjects){
		    	 parentQuantitySheet = opener.sheetObjects[0]; 
		     }else if (parent && parent.sheetObjects){
		    	 parentQuantitySheet = parent.sheetObjects[0];    	
		     }
             
             /* 정인선 추가 */
             for (var int = 1; int < parentQuantitySheet.LastRow()+1; int++) {
            	var cntr_tpsz_cd = parentQuantitySheet.GetCellValue(int, "cntr_tpsz_cd");
            	var addCheck = false;
            	for (var i = 1; i < parentQtyDtlSheet.RowCount()+1; i++) {
            		if(cntr_tpsz_cd == parentQtyDtlSheet.GetCellValue(i, "cntr_tpsz_cd")){
            			addCheck = true;
            			break;
            		}
				}
            	
            	/* DATA가 없으면 생성 */
            	if(!addCheck){
            		addQtyDtlSheet(parentQuantitySheet, parentQtyDtlSheet, myParent.document.form, int);
            	}
             }
             /* 정인선 추가 */
             
             var parentQtyDtlRow = parentQtyDtlSheet.RowCount()+1;
             var parentQuantityRow = parentQuantitySheet.LastRow()+1;	
             
             if(parentQuantitySheet.RowCount()> 0){
				 var isCntrFirst=true;
				 var isEqCntrFirst=true;
				 for (var i=1 ; i < parentQuantityRow ; i++ ){
				     var qtyRow=sheetObjects[1].DataInsert(-1);
				     for(j=0 ; j <= parentQuantitySheet.LastCol(); j++){
				    	 if ( parentQuantitySheet.ColSaveName(j) != "" ) {   // finding ones that dosen't have SaveName
				    		 for(var k=0 ; k <= sheetObjects[1].LastCol(); k ++){
				                 if ( sheetObjects[1].ColSaveName(k) == parentQuantitySheet.ColSaveName(j)){
                                    sheetObjects[1].SetCellValue( qtyRow, k,parentQuantitySheet.GetCellValue( i , j) );
				                }            			 
				    		 }
				    	 }
				     }
				}				
			 }			 
			 // Copying QtyDtl Info. of Main
			 if(parentQtyDtlSheet.RowCount()> 0){
				 for (var i=1 ; i < parentQtyDtlRow ; i++ ){
				     var qtyDtlRow=sheetObjects[0].DataInsert(-1);
				     for(var j=0 ; j <= parentQtyDtlSheet.LastCol(); j++){
				    	 if ( parentQtyDtlSheet.ColSaveName(j) != "" ) {   // finding ones that dosen't have SaveName
				    		 for(var k=0 ; k <= sheetObjects[0].LastCol(); k ++){
				                 if ( sheetObjects[0].ColSaveName(k) == parentQtyDtlSheet.ColSaveName(j)){
                                    sheetObjects[0].SetCellValue( qtyDtlRow, k,parentQtyDtlSheet.GetCellValue( i , j) );
				                }            			 
				    		 }
				    	 }
				     }
				}
				

				// if it is not AutoCheck at Main(autoCheck : whether save or not)
			    if(myParent.checkAutoCaluate(myParent.document.form)){
					   // Display basic info.
		        	// deleting from QtyDtl in case of not existing CntrTpSz 
                    for(var i=sheetObjects[0].LastRow()  ; i >= sheetObjects[0].HeaderRows(); i-- ){
                        if(sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")) < 0){
			   				sheetObjects[0].RowDelete(i,false);
				   		}
			   		}	   					   
			   		// in case of creating CntrTpSz
                    for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow() ; i++ ){
                        if(sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd")) < 0){
                            cntrQty=sheetObjects[1].GetCellValue(i, "op_cntr_qty");
						   // leaving Eq Sub out of Total Qty in case of existing EQ Sub  
						   eqSubSameQty=false;
                            if(sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty") > 0){
                                if(sheetObjects[1].GetCellValue(i, "op_cntr_qty") == sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty")){
								   eqSubSameQty=true;
								   existEqSub=false;
							   }else{
								   existEqSub=true;
							   }
						   }else{
							   existEqSub=false;
						   }
						   socSameQty=false;
                            if(sheetObjects[1].GetCellValue(i, "soc_qty") > 0){
                                if(sheetObjects[1].GetCellValue(i, "op_cntr_qty") == sheetObjects[1].GetCellValue(i, "soc_qty")){
								   socSameQty=true;
							   }
						   }
						   if(existEqSub){
                                cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
                                sheetObjects[0].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
                                sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
                                    setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, sheetObjects[1].GetCellValue(i, "rd_cgo_flg"), sheetObjects[1], "N");
							   }
						   }
						   // leaving SOC out of Total Qty in case of existing SOC  
                            if(sheetObjects[1].GetCellValue(i, "soc_qty") > 0 && sheetObjects[1].GetCellValue(i, "op_cntr_qty") != sheetObjects[1].GetCellValue(i, "soc_qty")){
							   existSocQty=true;
						   }else{
							   existSocQty=false;
						   }			   
						   if(existSocQty){
                                cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "soc_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "soc_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
							   }
						   }			   
						   // adding and calculating Row in case of existing Hanger
                            if( sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty") > 0){
                                cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg",1);
							   if(socSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
							   }								   
                                sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }
                            if( sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty") > 0){
                                cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg",1);
							   if(socSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
							   }								   
                                sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }				
                            if( sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty") > 0){
                                cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg",1);
							   if(socSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
							   }								   
							   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }			
                            if( sheetObjects[1].GetCellValue(i, "mer_hngr_qty") > 0){
                               cntrQty=cntrQty-sheetObjects[1].GetCellValue(i, "mer_hngr_qty");
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "mer_hngr_flg",1);
							   if(socSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
							   }								   
							   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "mer_hngr_qty"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }	
						   if(cntrQty > 0){					   
							   qtyDtlRow=sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",cntrQty);
							   if(eqSubSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
							   }						   
							   if(socSameQty){
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
							   }								   
							   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
							   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");	
						   }
				   		}else{
				   			// setting changed value of Quantity to QtyDtl
				   			// 01. comparing  EqSubVol and QtyDtl Vol in case of existing Quantity
				   			if(sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd") &&
				   						sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "eq_subst_cntr_tpsz_cd") ){
				   						addRow=false;
				   						// setting EqSubVol with new value in case of existing EqSub of QtyDtl
				   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty"));
				   						break;
				   					}
				   				}
				   				if(addRow){
				 				   // when Eqsub exists at Quantity and not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, sheetObjects[1].GetCellValue(i, "rd_cgo_flg"), sheetObjects[1] , "N");
								   }
				   				}
				   			}
				   			// 02. comparing SocVol of Quantity and QtyDtl Vol   			
				   			if(sheetObjects[1].GetCellValue(i, "soc_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd") &&
				   						sheetObjects[0].GetCellValue(k, "soc_flg") == 1){
				   						addRow=false;
				   						// setting SocVol with new value in case of existing SOC of QtyDtl
				   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "soc_qty"));
				   						break;
				   					}
				   				}
				   				if(addRow){
				 				   // SOC : exist at Quantity, not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
								   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "soc_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
								   }
				   				}
				   			} 
				   			// 03.	comparing Hanger of Quantity and QtyDtl Vol 	
				   			if(sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].GetCellValue(k, "crr_hngr_sgl_bar_use_flg") == 1 ||
				   						BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].GetCellValue(i, "op_cntr_qty"))){
					   						addRow=false;
					   						// setting SglVol with new value in case of existing Sql of QtyDtl
					   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty"));
					   						break;				   							
				   						}
				   					}
				   				}
				   				if(addRow){
				 				   // Sql : exist at Quantity, not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg",1);
								   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 		
				   			if(sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].GetCellValue(k, "crr_hngr_dbl_bar_use_flg") == 1 ||
				   							BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].GetCellValue(i, "op_cntr_qty"))){
					   						addRow=false;
					   						// setting SglVol with new value in case of existing Sql of QtyDtl
					   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty"));
					   						break;				   							
				   						}
				   					}
				   				}
				   				if(addRow){
				 				   // Dbl : exist at Quantity, not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg",1);
								   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			   			
				   			if(sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].GetCellValue(k, "crr_hngr_tpl_bar_use_flg") == 1 ||
				   							BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].GetCellValue(i, "op_cntr_qty"))){
					   						addRow=false;
					   						// setting SglVol with new value in case of existing Sql of QtyDtl
					   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty"));
					   						break;				   							
				   						}
				   					}				   					
				   				}
				   				if(addRow){
				 				   // Tpl : exist at Quantity, not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg",1);
								   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			   			
				   			if(sheetObjects[1].GetCellValue(i, "mer_hngr_qty") > 0){
				   				addRow=true;
				   				for(var k=sheetObjects[0].HeaderRows(); k <= sheetObjects[0].LastRow(); k++ ){
				   					if(	sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].GetCellValue(k, "mer_hngr_flg") == 1 ||
				   						BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].GetCellValue(i, "op_cntr_qty"))){
					   						addRow=false;
					   						// setting SglVol with new value in case of existing Sql of QtyDtl
					   						sheetObjects[0].SetCellValue(k, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "mer_hngr_qty"));
					   						break;				   							
				   						}
				   					}								   					
				   				}
				   				if(addRow){
				 				   // Mer : exist at Quantity, not exist at QtyDtl
				   					qtyDtlRow=sheetObjects[0].DataInsert(-1);
				   					sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "mer_hngr_flg",1);
								   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[1].GetCellValue(i, "mer_hngr_qty"));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
								   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			  
				   			// here to change total Vol(changed vol of dry of undefined type)   			
				   		}
			   		}
		   			// in case of deleting data of QtyDtl from Booking.(exist at QtyDtl, not exist at Quantity)	   		
                    for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++ ){
                    	cntrTpSz=sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
                    	qtyRow=sheetObjects[1].FindText("cntr_tpsz_cd", cntrTpSz);
                    	if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
                    		if(sheetObjects[1].GetCellValue(qtyRow,"eq_subst_cntr_tpsz_cd") == ""){
		   						// when deleting EqSub 
                    			if(sheetObjects[1].GetCellValue(qtyRow, "op_cntr_qty") == sheetObjects[0].GetCellValue(i, "op_cntr_qty")){
		   							sheetObjects[0].SetCellValue(i, "eq_subst_cntr_tpsz_cd","");
		   						}else{
		   							sheetObjects[0].RowDelete(i,false);
		   						}
		   					}	   					
		   				}
                    	if(sheetObjects[0].GetCellValue(i, "soc_flg") == 1){
                    		if(sheetObjects[1].GetCellValue(qtyRow,"soc_qty") <= 0){
		   						// when deleting Soc 
                    			if(sheetObjects[1].GetCellValue(qtyRow, "op_cntr_qty") == sheetObjects[0].GetCellValue(i, "op_cntr_qty")){
		   							sheetObjects[0].SetCellValue(i, "soc_flg",0);
		   						}else{
		   							sheetObjects[0].RowDelete(i,false);
		   						}
		   					}	   					
		   				}	   				
		   			}
					// changing RD Term with one of Main in case of RD Term is not 'M'
                    for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++ ){
						if(ComGetObjValue(formObj.rcv_term_cd) != "M"){
							sheetObjects[0].SetCellValue(i, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						}
						if(ComGetObjValue(formObj.de_term_cd) != "M"){
							sheetObjects[0].SetCellValue(i, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						}						
					}		   			
			    }
			    /* 한건일 경우 Special 자동 셋팅 해줌 */
			    if(sheetObjects[0].LastRow() == 2){
			    	if(getURLParameters("dcgo_flg") != "Y" && getURLParameters("rc_flg") != "Y" && getURLParameters("awk_cgo_flg") != "Y" && getURLParameters("bb_cgo_flg") != "Y"){
			    		sheetObjects[0].SetCellValue(i, "dry_cgo_flg", "Y");
			    	}else{
			    		sheetObjects[0].SetCellValue(i, "dry_cgo_flg", "N");
			    		sheetObjects[0].SetCellValue(i, "dcgo_flg", getURLParameters("dcgo_flg"));
				    	sheetObjects[0].SetCellValue(i, "rc_flg", getURLParameters("rc_flg"));
				    	sheetObjects[0].SetCellValue(i, "awk_cgo_flg", getURLParameters("awk_cgo_flg"));
				    	sheetObjects[0].SetCellValue(i, "bb_cgo_flg", getURLParameters("bb_cgo_flg"));
			    	}
			    }
			 }else{
				 // auto checking using Quantity Information in case of not existing saved data 	
				 if(parentQuantitySheet.RowCount()> 0){
					 for(var i=parentQuantitySheet.HeaderRows(); i <= parentQuantitySheet.LastRow() ; i++ ){
						 cntrQty=parentQuantitySheet.GetCellValue(i, "op_cntr_qty");
					   // leaving Eq Sub out of Total Qty in case of existing EQ Sub
					   eqSubSameQty=false;
					   if(parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty") > 0){
						   if(parentQuantitySheet.GetCellValue(i, "op_cntr_qty") == parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty")){
							   eqSubSameQty=true;
							   existEqSub=false;
						   }else{
							   existEqSub=true;
						   }
					   }else{
						   existEqSub=false;
					   }
					   socSameQty=false;
					   if(parentQuantitySheet.GetCellValue(i, "soc_qty") > 0){
						   if(parentQuantitySheet.GetCellValue(i, "op_cntr_qty") == parentQuantitySheet.GetCellValue(i, "soc_qty")){
							   socSameQty=true;
						   }
					   }
					   if(existEqSub){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, parentQuantitySheet.GetCellValue(i, "rd_cgo_flg"), sheetObjects[1], "N");
						   }
					   }
					   // leaving SOC out of Total Qty in case of existing SOC
					   if(parentQuantitySheet.GetCellValue(i, "soc_qty") > 0 && parentQuantitySheet.GetCellValue(i, "op_cntr_qty") != parentQuantitySheet.GetCellValue(i, "soc_qty")){
						   existSocQty=true;
					   }else{
						   existSocQty=false;
					   }			   
					   if(existSocQty){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "soc_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "soc_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
						   }
					   }			   
					   // adding and calculating Row in case of existing Hanger
					   if( parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty") > 0){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg",1);
						   if(socSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   }							   
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }
					   if( parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty") > 0){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg",1);
						   if(socSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   }							   
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }				
					   if( parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty") > 0){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg",1);
						   if(socSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   }							   
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }			
					   if( parentQuantitySheet.GetCellValue(i, "mer_hngr_qty") > 0){
						   cntrQty=cntrQty-parentQuantitySheet.GetCellValue(i, "mer_hngr_qty");
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "mer_hngr_flg",1);
						   if(socSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   }							   
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",parentQuantitySheet.GetCellValue(i, "mer_hngr_qty"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }	
					   if(cntrQty > 0){
						   qtyDtlRow=sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "op_cntr_qty",cntrQty);
						   if(eqSubSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
						   }
						   if(socSameQty){
							   sheetObjects[0].SetCellValue(qtyDtlRow, "soc_flg",1);
						   }							   
						   sheetObjects[0].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
						   sheetObjects[0].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
						   }						   
					   }
				   }
				 }				 
			 }
             
             
			 
			 // Copying Quantity Info. of Main	 
			 if(parentQuantitySheet.RowCount()> 0){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			 }
		 }
     }
     
     
     function addQtyDtlSheet(parentQuantitySheet, parentQtyDtlSheet, formObj, i){
    	 var cntrQty = parentQuantitySheet.GetCellValue(i, "op_cntr_qty");
    	 eqSubSameQty = false;
    	 socSameQty = false;
    	 if (parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty") > 0) {
    		 if (parentQuantitySheet.GetCellValue(i, "op_cntr_qty") == parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty")) {
    			 eqSubSameQty = true;
    			 existEqSub = false;
    		 } else {
    			 existEqSub = true;
    		 }
    	 } else {
    		 existEqSub = false;
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "soc_qty") > 0) {
    		 if (parentQuantitySheet.GetCellValue(i, "op_cntr_qty") == parentQuantitySheet.GetCellValue(i, "soc_qty")) {
    			 socSameQty = true;
    		 }
    	 }
    	 if (existEqSub) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "eq_subst_cgo_qty"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, parentQuantitySheet.GetCellValue(i, "rd_cgo_flg"), parentQuantitySheet, "N");
    		 }
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "soc_qty") > 0 && parentQuantitySheet.GetCellValue(i, "op_cntr_qty") != parentQuantitySheet.GetCellValue(i, "soc_qty")) {
    		 existSocQty = true;
    	 } else {
    		 existSocQty = false;
    	 }
    	 if (existSocQty) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "soc_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "soc_qty"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "N");
    		 }
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty") > 0) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg", 1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty"));
    		 if (eqSubSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 }
    		 if (socSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 }
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "Y");
    		 }
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty") > 0) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg", 1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty"));
    		 if (eqSubSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 }
    		 if (socSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 }
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "Y");
    		 }
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty") > 0) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg", 1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty"));
    		 if (eqSubSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 }
    		 if (socSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 }
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "Y");
    		 }
    	 }
    	 if (parentQuantitySheet.GetCellValue(i, "mer_hngr_qty") > 0) {
    		 cntrQty = cntrQty - parentQuantitySheet.GetCellValue(i, "mer_hngr_qty");
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet .GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "mer_hngr_flg", 1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", parentQuantitySheet.GetCellValue(i, "mer_hngr_qty"));
    		 if (eqSubSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 }
    		 if (socSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 }
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "Y");
    		 }
    	 }
    	 if (cntrQty > 0) {
    		 qtyDtlRow = parentQtyDtlSheet.DataInsert(-1);
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "cntr_tpsz_cd"));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "op_cntr_qty", cntrQty);
    		 if (eqSubSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd", parentQuantitySheet.GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
    		 }
    		 if (socSameQty) {
    			 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "soc_flg", 1);
    		 }
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
    		 parentQtyDtlSheet.SetCellValue(qtyDtlRow, "de_term_cd", ComGetObjValue(formObj.de_term_cd));
    		 if (isVolDetailAutoChk()) {
    			 setDefaultCheckCgTp(parentQtyDtlSheet, formObj, qtyDtlRow, "", parentQuantitySheet, "N");
    		 }
    	 }
     }
     
     
   /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
     var headCnt = 0;
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                with(sheetObj){
                    var HeadTitle1="|TP/SZ|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|R/D Term|R/D Term|VOL";
                    var HeadTitle2="|TP/SZ|DR|DG|RF|AK|BB|S/HGR|D/HGR|T/HGR|M/HGR|EQ SUB TP/SZ|SOC|R|D|VOL";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    headCnt = headers.length;
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"dry_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_sgl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_dbl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_tpl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"CheckBox",  Hidden:0, Width:60,    Align:"Center",  ColMerge:0,   SaveName:"mer_hngr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"CheckBox",  Hidden:0, Width:70,    Align:"Center",  ColMerge:0,   SaveName:"soc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y",falseValue:"N" },
                                 {Type:"ComboEdit", Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"ComboEdit", Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0, Width:90,   Align:"Center",   ColMerge:0,   SaveName:"op_cntr_qty",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetCountPosition(0);
                    SetMergeCell(0, 1, 2, 1);
                    SetMergeCell(0, 15, 2, 1);
                    SetSheetHeight(220);
//        			SetWaitImageVisible(0);
//                    SetVisible(0);
                }
 				break;                
 			case "sheet2":
                with(sheetObj){
                    var HeadTitle="|TP/SZ|Vol.|EQ Sub|EQ Sub|EQ Sub|S.O.C|S/HGR|D/HGR|T/HGR|HGR VOL|M/HGR";
                    
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cgo_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rd_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"soc_qty",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_sgl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_dbl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_tpl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mer_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    
                    SetEditable(1);
                }
				break; 				
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         case IBSEARCH:      //retrieve
 			ComSetObjValue(formObj.f_cmd, SEARCH);
     			var sXml=sheetObj.GetSearchData("ESM_BKG_0890GS.do", FormQueryString(formObj));
 			var arrXml=sXml.split("|$$|");  
				if (arrXml.length > 0){	// R Term
					setIBCombo(sheetObjects[0],arrXml[0],"rcv_term_cd",false,0, " ", " ", "val");
				}             		
				if (arrXml.length > 1){	// D Term
					setIBCombo(sheetObjects[0],arrXml[1],"de_term_cd",false,0, " ", " ", "val");
				}      														
				// getting data from Main if it is from Booking Creation or getting retrieved data
				if(ComGetObjValue(formObj.callTp) != "B"){
					if (arrXml.length > 2){			
						sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1});
					}								
					if (arrXml.length > 3){			
						sheetObjects[1].LoadSearchData(arrXml[3],{Sync:1});
					}					
					BkgEtcDataXmlToForm(arrXml[0], formObj);										
				}
				// setting CntrTpSz,EqSubCntrTpSz Combo List
				if(sheetObjects[1].RowCount() > 0){
					var isCntrFirst=true;
					var isEqCntrFirst=true;
 					for (var i=sheetObjects[1].HeaderRows() ; i < sheetObjects[1].HeaderRows() + sheetObjects[1].RowCount() ; i++ ){
 						if(!ComIsNull(sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"))){
 							if(cntr_tpsz_str.indexOf(sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd")) < 0){
								if(isCntrFirst){
									cntr_tpsz_str=sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd");
									isCntrFirst=false;
								}else{
									cntr_tpsz_str=cntr_tpsz_str + "|" + sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd");
								}
							}
						}
 						if(!ComIsNull(sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd"))){
							if(eq_sub_cntr_tpsz_str.indexOf(sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd")) < 0){
								if(isEqCntrFirst){
									eq_sub_cntr_tpsz_str=" |" + sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd");
									isEqCntrFirst=false;
								}else{
									eq_sub_cntr_tpsz_str=eq_sub_cntr_tpsz_str + "|" + sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd");
								}
							}						 
						}
					}
 					
					sheetObjects[0].SetColProperty("cntr_tpsz_cd", {ComboText:cntr_tpsz_str, ComboCode:cntr_tpsz_str} );
					sheetObjects[0].SetColProperty("eq_subst_cntr_tpsz_cd", {ComboText:eq_sub_cntr_tpsz_str, ComboCode:eq_sub_cntr_tpsz_str} );
				}
				// Loading after InitDataCombo
				if(ComGetObjValue(formObj.callTp) != "B"){
					if (arrXml.length > 2){			
						sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1} );
					}								
					if (arrXml.length > 3){			
						sheetObjects[1].LoadSearchData(arrXml[3],{Sync:1} );
					}
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Add");
					ComBtnDisable("btn_Delete");
				}else{					
					ComBtnEnable("btn_Add");
					ComBtnEnable("btn_Delete");
					if(ComGetObjValue(formObj.bdr_flg)=="Y"&&ComGetObjValue(formObj.ca_flg)=="N"){
						ComBtnDisable("btn_Save");
					} else {
						ComBtnEnable("btn_Save");					
					}
				}
				if(ComGetObjValue(formObj.bdr_flg)=="Y"&&ComGetObjValue(formObj.ca_flg)=="N"){
				} else {
					ComBtnEnable("btn_Save");					
				}
				setTotalVol("1");
				setBkgTotalVol();
				// Hidden Column 셋팅
				if(ComGetObjValue(formObj.dcgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "dcgo_flg", 0);
					sheetObjects[0].SetColHidden("dcgo_flg",1);
				}
				if(ComGetObjValue(formObj.rc_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "rc_flg", 0);
					sheetObjects[0].SetColHidden("rc_flg",1);
				}
				if(ComGetObjValue(formObj.awk_cgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "awk_cgo_flg", 0);
					sheetObjects[0].SetColHidden("awk_cgo_flg",1);
				}
				if(ComGetObjValue(formObj.bb_cgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "bb_cgo_flg", 0);
					sheetObjects[0].SetColHidden("bb_cgo_flg",1);
				}	
				var isSingle=true;
				var isDouble=true;
				var isTriple=true;
				var mHgr=true;
 				for(var i=1 ; i < sheetObjects[1].HeaderRows() + sheetObjects[1].RowCount(); i++ ){
					if(isSingle){						
						if(sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty") != "" && parseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty")) > 0){
							isSingle=false;
						}						
					}
					if(isDouble){
						if(sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty") != "" && parseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty")) > 0){
							isDouble=false;
						}						
					}
					if(isTriple){
						if(sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty") != "" && parseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty")) > 0){
							isTriple=false;
						}						
					}	
					if(mHgr){
						if(sheetObjects[1].GetCellValue(i, "mer_hngr_qty") != "" && parseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) > 0){
							mHgr=false;
						}						
					}						
				}
				if(isSingle){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_sgl_bar_use_flg", 0);
				}
				if(isDouble){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_dbl_bar_use_flg", 0);
				}
				if(isTriple){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_tpl_bar_use_flg", 0);
				}	
				if(mHgr){
					changeCheckAllBySaveName(sheetObjects[0], "mer_hngr_flg", 0);
				}					
				sheetObjects[0].SetColHidden("crr_hngr_sgl_bar_use_flg",isSingle);
				sheetObjects[0].SetColHidden("crr_hngr_dbl_bar_use_flg",isDouble);
				sheetObjects[0].SetColHidden("crr_hngr_tpl_bar_use_flg",isTriple);
				sheetObjects[0].SetColHidden("mer_hngr_flg",mHgr);
				if(ComGetObjValue(formObj.eq_subst_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "eq_subst_cntr_tpsz_cd", "");
					sheetObjects[0].SetColHidden("eq_subst_cntr_tpsz_cd",1);
				}			
				if(ComGetObjValue(formObj.soc_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "soc_flg", 0);
					sheetObjects[0].SetColHidden("soc_flg",1);
				}			
				if(ComGetObjValue(formObj.mixed_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
					sheetObjects[0].SetColHidden("rcv_term_cd",1);
					changeCheckAllBySaveName(sheetObjects[0], "de_term_cd", ComGetObjValue(formObj.de_term_cd));
					sheetObjects[0].SetColHidden("de_term_cd",1);
				}else{
					if(ComGetObjValue(formObj.callTp) == "B"){
						if(ComGetObjValue(formObj.rcv_term_cd) == "M"){
							changeEditableBySaveName(sheetObjects[0], "rcv_term_cd", true);
						}else{
							changeCheckAllBySaveName(sheetObjects[0], "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
							changeEditableBySaveName(sheetObjects[0], "rcv_term_cd", false);
						}
						if(ComGetObjValue(formObj.de_term_cd) == "M"){
							changeEditableBySaveName(sheetObjects[0], "de_term_cd", true);
						}else{
							changeCheckAllBySaveName(sheetObjects[0], "de_term_cd", ComGetObjValue(formObj.de_term_cd));
							changeEditableBySaveName(sheetObjects[0], "de_term_cd", false);
						}		
					}
				}
				sheetObjects[0].FitColWidth();
			break;

			case IBSAVE:        //
				if(validateForm(sheetObj,formObj,sAction)){
					if(ComGetObjValue(formObj.callTp) == "B"){
						setPopToMain(sheetObj, formObj);
					}else{
		    			ComSetObjValue(formObj.f_cmd, MULTI);					
						var params=FormQueryString(formObj);	
						params=params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");
                        var sXml=sheetObj.GetSaveData("ESM_BKG_0890GS.do", params);
						if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
							ComBkgSaveCompleted();
						}
					}
				}
			break;
         }
     }

     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 var cnt = (sheetObjects[1].RowCount() > 0)? sheetObjects[1].RowCount() : headCnt;
    	 for(var i=sheetObjects[1].HeaderRows(); i <= cnt ; i++){
			var sumSingle=0;
			var sumDouble=0;
			var sumTriple=0;
			var sumMer=0;
			var eqSubVol=0;
			var sumEqDtlVol=0;
			for(var j=sheetObjects[0].HeaderRows(); j < sheetObjects[0].RowCount() + sheetObjects[0].HeaderRows(); j++){
				if(sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd")){
					if(sheetObjects[0].GetCellValue(j, "crr_hngr_sgl_bar_use_flg") == 1){
						sumSingle=sumSingle + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
					}
					if(sheetObjects[0].GetCellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
						sumDouble=sumDouble + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
					}
					if(sheetObjects[0].GetCellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
						sumTriple=sumTriple + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
					}
					if(sheetObjects[0].GetCellValue(j, "mer_hngr_flg") == 1){
						sumMer=sumMer + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
					}				
					if(sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
						if(sheetObjects[1].GetCellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[0].GetCellValue(j, "eq_subst_cntr_tpsz_cd")){
							eqSubVol=eqSubVol + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
						}    							
					}	
					sumEqDtlVol=sumEqDtlVol + BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty"));
				}			
				if(BkgParseFloat(sheetObjects[0].GetCellValue(j, "op_cntr_qty")) <= 0){
					ComShowCodeMessage("BKG00013");
					return false;					
				}
			}    				
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_sgl_bar_qty")) != sumSingle){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_dbl_bar_qty")) != sumDouble){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "crr_hngr_tpl_bar_qty")) != sumTriple){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "mer_hngr_qty")) != sumMer){
				ComShowCodeMessage("BKG02007");
				return false;
			}    			
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "eq_subst_cgo_qty")) != eqSubVol){
				ComShowCodeMessage("BKG02008", sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
				return false;    					
			}
			if(BkgParseFloat(sheetObjects[1].GetCellValue(i, "op_cntr_qty")) != ComTrunc(sumEqDtlVol,2)){
				ComShowCodeMessage("BKG00493", sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"), sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd"));
				return false;    					
			}    				
		}		    	 
         return true;         
     }
     // setting data to Booking Creation
    function setPopToMain(sheetObj, formObj){
 		// R/D Term shouldn't be 'M'
    	for ( i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
    		if(sheetObj.GetCellValue(i, "rcv_term_cd") == "M" || sheetObj.GetCellValue(i, "de_term_cd") == "M"){
 				ComShowCodeMessage("BKG00853");				
 				return;
 			}
 		}
     	// Copying Qty Dtl Info of Main
 		 var parentQtyDtlSheet;
 		 var sheetIdx = 3;
 		 if(ComIsNull(formObj.callSheetIdx1))sheetIdx = formObj.callSheetIdx1.value;
 		 if (opener && opener.sheetObjects) parentQtyDtlSheet =opener.sheetObjects[sheetIdx]; 
         else if (parent && parent.sheetObjects) parentQtyDtlSheet =parent.sheetObjects[sheetIdx];    	
 		 parentQtyDtlSheet.RemoveAll();
 		 
          for ( i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
              var iRow=parentQtyDtlSheet.DataInsert();
              for(j=0 ; j <= sheetObj.LastCol(); j++){
             	 if ( sheetObj.ColSaveName(j) != "" ) {   // finding ones that dosen't have SaveName
             		 for(k=0 ; k <= parentQtyDtlSheet.LastCol(); k ++){
                          if ( parentQtyDtlSheet.ColSaveName(k) == sheetObj.ColSaveName(j)){
                        	  parentQtyDtlSheet.SetCellValue( iRow, k,sheetObj.GetCellValue( i , j) );
                         }                        
             		 }
             	 }
              }
 	 	}
  		var callFunc=ComGetObjValue(formObj.func);
  		var autoFlg=ComGetObjValue(formObj.auto_flg);
  		//alert("here check");
  		window.returnValue=autoFlg;
  		
		//var opener=window.dialogArguments;
		if (!opener) opener=parent; //이 코드 추가할것
		eval('opener.'+callFunc)(autoFlg);   
  		
  		ComClosePopup(); 
	
    }
    // changing check value of each SaveName
function changeCheckAllBySaveName(sheetObj, saveName, chkValue){
		if(sheetObj.RowCount()> 0){
			for ( i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
				sheetObj.SetCellValue(i, saveName,chkValue);
		 	}
		}    	
    }
    // handling editable status of Cell
    function changeEditableBySaveName(sheetObj, saveName, editable){
		if(sheetObj.RowCount()> 0){
			for ( i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
				sheetObj.SetCellEditable(i, saveName,editable);
		 	}
		}    	
    }
 	function sheet1_OnChange(sheetObj, Row, Col, Value){
		setTotalVol("1");
	}		
	function sheet1_OnAfterEdit(sheetObj, Row, Col){		
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			if(BkgParseFloat(sheetObj.GetCellValue(Row, Col)) <= 0){
				ComShowCodeMessage("BKG00013");
				sheetObj.SetCellValue(Row, Col,"",0);
			}			
		}		
		// totalVolume of each TP/SZ must be equal or lesser than booking vol
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			if(sheetObj.GetCellValue(Row,Col) != ""){
				var bkgRow=sheetObjects[1].FindText("cntr_tpsz_cd",sheetObj.GetCellValue(Row,"cntr_tpsz_cd"));
				if(bkgRow >= 0){
					var bkgVol=sheetObjects[1].GetCellValue(bkgRow, "op_cntr_qty");
					var totVol=sheetObj.GetCellValue(Row,"op_cntr_qty");
					if(totVol != null && totVol.length > 0){
						if(parseFloat(bkgVol) < parseFloat(totVol)){
							ComShowCodeMessage("BKG02005");
							sheetObj.SetCellValue(Row,"op_cntr_qty","",0);
						}
					}
				}
			}
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			setTotalVol("2");			
		}
	}		
		
    // prohibiting of duplicate check of type
	function sheet1_OnClick(sheetObj, Row, Col, Value)
	{
		var sName=sheetObj.ColSaveName(Col);
		if(sName == "dry_cgo_flg"){
			sheetObj.SetCellValue(Row, "dcgo_flg",0);
			sheetObj.SetCellValue(Row, "rc_flg",0);
			sheetObj.SetCellValue(Row, "awk_cgo_flg",0);
			sheetObj.SetCellValue(Row, "bb_cgo_flg",0);
		}else if(sName == "dcgo_flg"){
			sheetObj.SetCellValue(Row, "dry_cgo_flg",0);
		}else if(sName == "rc_flg"){
			sheetObj.SetCellValue(Row, "dry_cgo_flg",0);
		}else if(sName == "awk_cgo_flg"){
			sheetObj.SetCellValue(Row, "dry_cgo_flg",0);
		}else if(sName == "bb_cgo_flg"){
			sheetObj.SetCellValue(Row, "dry_cgo_flg",0);
		}				
	}		
 	// calculating Total Vol
 	function setTotalVol(flag){
 		var sheetObj=sheetObjects[0];
 		var cntrArray=new Array();
 		var volArray=new Array();
 		var arrCnt=0;
 		for(var i=parseInt(sheetObj.HeaderRows()); i < parseInt(sheetObj.HeaderRows()) + sheetObj.RowCount() ; i++){
 			if(cntrArray.length < 1){
 				cntrArray[arrCnt]=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
 				volArray[arrCnt]=sheetObj.GetCellValue(i, "op_cntr_qty");
 				arrCnt++;
 			}else{
				if(sheetObj.RowCount() > 0){
	 				var isExist=false;
	 	 			for(var k=0 ; k < cntrArray.length ; k++){
	 	 				if(cntrArray[k] == sheetObj.GetCellValue(i, "cntr_tpsz_cd")){
	 	 					if(ComIsNumber(volArray[k], ".") && ComIsNumber(sheetObj.GetCellValue(i, "op_cntr_qty"),".")){
	 	 						volArray[k]=ComTrunc(parseFloat(volArray[k]) + parseFloat(sheetObj.GetCellValue(i, "op_cntr_qty")),2);
	 	 					}else if(ComIsNumber(volArray[k], ".")){
	 	 						volArray[k]=volArray[k];
	 	 					}else if(ComIsNumber(sheetObj.GetCellValue(i, "op_cntr_qty"),".")){
	 	 						volArray[k]=sheetObj.GetCellValue(i, "op_cntr_qty");
	 	 					}
	 	 					isExist=true;
	 	 				}
	 	 			} 				
	 	 			if(!isExist){
	 	 				if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != -1 && sheetObj.GetCellValue(i, "op_cntr_qty") != -1) {
		 	 				cntrArray[arrCnt]=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
		 	 				volArray[arrCnt]=sheetObj.GetCellValue(i, "op_cntr_qty");
	 	 				}
	 	 				arrCnt++; 	  	 				
	 	 			}
	 			}
 			}
 		}
 		var totalVol="";
 		for(var i=0 ; i < cntrArray.length ; i++){
 			if(i > 0){
 				totalVol=totalVol + "," + cntrArray[i] + "X" + volArray[i];
 			}else{
 				totalVol=cntrArray[i] + "X" + volArray[i];
 			}
 		}
 		// in case of direct input of TP/SZ 
 		if(flag != "1"){
 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
 				if(sheetObj.GetCellValue(i,"cntr_tpsz_cd") == "" || cntr_tpsz_str.indexOf(sheetObj.GetCellValue(i,"cntr_tpsz_cd")) < 0){
 					ComShowCodeMessage("BKG02003");
 					sheetObj.SetCellValue(i,"cntr_tpsz_cd","");
 					setTotalVol("1");
 				}	
 	 		} 			
 		}
 		if(sheetObj.RowCount() <= 0){
			totalVol = "X";
		}
 		ComSetObjValue(document.form.total_vol, totalVol);		
 	}
 	// calculating BKG Vol 
 	function setBkgTotalVol(){
		var totalVol;
		for(var i=1 ; i <= sheetObjects[1].LastRow(); i++){
			// Total Volumn
			if(i > 1){
				totalVol=totalVol + "," + sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") + "X" + sheetObjects[1].GetCellValue(i, "op_cntr_qty");
			}else{
				totalVol=sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") + "X" + sheetObjects[1].GetCellValue(i, "op_cntr_qty");
			}
		}
		if(sheetObjects[1].LastRow() <= 0){
			totalVol = "There is no data to search" + "X";
		}
		// inputting Total Vol
		ComSetObjValue(document.form.bkg_vol, totalVol);			 		
 	}
 	
    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }

    function getURLParameters(paramName){
        var sURL = window.document.URL.toString();
        if (sURL.indexOf("?") > 0) {
            var arrParams = sURL.split("?");
            var arrURLParams = arrParams[1].split("&");
            var arrParamNames = new Array(arrURLParams.length);
            var arrParamValues = new Array(arrURLParams.length);

            var i = 0;
            for (i = 0; i<arrURLParams.length; i++){
                var sParam =  arrURLParams[i].split("=");
                arrParamNames[i] = sParam[0];
                if (sParam[1] != "")
                    arrParamValues[i] = unescape(sParam[1]);
                else
                    arrParamValues[i] = "No Value";
            }

            for (i=0; i<arrURLParams.length; i++){
                if (arrParamNames[i] == paramName){
                    //alert("Parameter:" + arrParamValues[i]);
                    return arrParamValues[i];
                }
            }
            return undefined;
        }
    }