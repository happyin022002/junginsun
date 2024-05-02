/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0156.js
*@FileTitle  : COD Application at BKG Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var prefix1="sheet1_";
	var prefix2="sheet2_";
	var prefix3="sheet3_";
	var prefix4="sheet4_";
	var prefix5="sheet5_";
	var prefix6="sheet6_";
	var prefix7="sheet7_";
	var prefix9="sheet9_";
	var iTop=0;
	var ifTop=0;
	var tmpCaMode = "";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
		 var sheetObject2=sheetObjects[2];
		 var sheetObject3=sheetObjects[3];
		 var sheetObject4=sheetObjects[4];		 
         /*******************************************************/
         var formObj=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) { 
				case "btn_remark":
			        if($(codRemarkView).css("visibility") == "visible"){
			            $(codRemarkView).css({
			                  visibility:"hidden",
			                  zIndex:-1               
			            });
			        }else{
			            $(codRemarkView).css({
			                  visibility:"visible",
			                  zIndex:200              
			            });
			        }			        
					//document.frames("codRemarkIfrm").document.forms[0].diff_rmk.value=ComGetObjValue(formObj.codRemark);
			        $('iframe[name=codRemarkIfrm]').contents().find('#diff_rmk').val(ComGetObjValue(formObj.codRemark));
					
				break; 
				case "btn_pc":
					var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
					if (sRow.length<1){
						ComShowCodeMessage("BKG00239");
						return false;
					}
					if(sheetObjects[1].GetCellValue(2,prefix2+"pod_cd") == "" || sheetObjects[1].GetCellValue(2,prefix2+"del_cd") == "" || sheetObjects[1].GetCellValue(2,prefix2+"tvvd") == ""){
					ComShowCodeMessage("BKG00982");
					return false;
					}
					formObj.pc_flg.value ="Y";
					doActionIBSheet(sheetObjects[8],document.form,COMMAND08);
					if (formObj.pctl_no.value==null||formObj.pctl_no.value==""||formObj.pctl_no.value.length<20){
						ComShowCodeMessage("BKG00309");
						return false;
					} else {
						if(formObj.cod_mnl_flg.value!="Y"){
							ComShowCodeMessage("BKG02046");
						}
					}
				break;
				case "btn_calculation":
					if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
						 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
						ComShowCodeMessage("BKG00048");
						return false;
					}
					if (ComChkLen(ComGetObjValue(formObj.cod_rhnd_port_cd),7)!=2){
						ComShowCodeMessage("BKG00740");
						return false;
					}
					doActionIBSheet(sheetObjects[2],document.form,COMMAND05);						
				break;
				case "btn_Inquiry":
					var sUrl="/opuscntr/VOP_OPF_0207.do?isPop=R";
					ComOpenPopup(sUrl, 500, 360, "", "0,0", true);
				break;
				case "btn_history":
					if(ComIsEmpty(formObj.bkg_no)||ComIsEmpty(formObj.cod_rqst_seq)){
						return;
				    }
					var param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
				    	param+="&cod_rqst_seq="+ComGetObjValue(formObj.cod_rqst_seq);
						param+="&pgmNo=ESM_BKG_0981";
					ComOpenPopup("/opuscntr/ESM_BKG_0981.do"+param, 800, 300, '', '1,0,1,1,1', true);
				break;
				case "btn_reject":
					 if($(codRemarkView1).css("visibility") == "visible"){
				            $(codRemarkView1).css({
				                  visibility:"hidden",
				                  zIndex:-1               
				            });
				        }else{
				            $(codRemarkView1).css({
				                  visibility:"visible",
				                  zIndex:200              
				            });
				        }
	                //document.frames("codRemarkIfrm1").document.forms[0].diff_rmk.value=ComGetObjValue(formObj.codRjctRsnRmk);
					 $('iframe[name=codRemarkIfrm1]').contents().find('#diff_rmk').val(ComGetObjValue(formObj.codRjctRsnRmk));
	                
				break;
				case "btn_retrieve":
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					groupMailClear();
					if(ComIsEmpty(formObj.cod_rqst_seq)||
						ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)){
						doActionIBSheet(sheetObjects[0],formObj,COMMAND01); 
					}
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				break;
				case "btn_new":
					 initVal(formObj,"N");
				break;
				case "btn_save":
					if (validateForm(sheetObjects[1],formObj,IBSAVE)){
						doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
					}
				break;
				case "btn_add":
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					for(var i=0;i<sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
					groupMailClear();
					var iseq=formObj.cod_rqst_seq[formObj.cod_rqst_seq.length-1].value;
					ComAddComboItem(formObj.cod_rqst_seq, (ComParseInt(iseq)+1),(ComParseInt(iseq)+1));
	                ComSetObjValue(formObj.cod_rqst_seq,(ComParseInt(iseq)+1));
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComSetObjValue(formObj.saveModeCd,"C");
					formObj.rgn_cd.index="";
					formObj.cod_rqst_rsn_cd.index="";
					setCodReason_Combo();
					btnEnable(formObj);				 
				break;
				case "btn_del":
					if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="Y"
				        || ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
						|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"
						|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){
						ComShowCodeMessage("BKG00751");
						return;
					}
					if(ComIsEmpty(formObj.codStsCd) && ComGetObjValue(formObj.saveModeCd)=="C"
					   && ComParseInt(ComGetObjValue(formObj.cod_rqst_seq))>1){ 
						formObj.cod_rqst_seq.selectedIndex=formObj.cod_rqst_seq.selectedIndex-1;
						formObj.cod_rqst_seq.options[formObj.cod_rqst_seq.selectedIndex+1]=null;
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}else if(ComGetObjValue(formObj.saveModeCd)=="U"){
						doActionIBSheet(sheetObjects[0],document.form,REMOVE);
					}
				break;
				case "btn_request":	
					if (validateForm(sheetObjects[1],formObj,COMMAND02)){
						if (validateForm(sheetObjects[1],formObj,IBSAVE)){
							//p/c를 다시 실행함
							doActionIBSheet(sheetObjects[8],formObj,COMMAND08);
							if (ComIsNull(formObj.pctl_no)){
								ComShowCodeMessage("BKG00309");
								return false;
							}
							if (ComGetObjValue(formObj.cod_mnl_flg)=="Y"){
								doActionIBSheet(sheetObjects[8],document.form,COMMAND11);							
							} else {
								doActionIBSheet(sheetObjects[8],document.form,COMMAND02);
							}
						}
					}
				break;        
	    		case "btn_approve":
					if(ComGetObjValue(formObj.cod_mnl_flg)==null||ComGetObjValue(formObj.cod_mnl_flg)!="Y"){
						ComShowCodeMessage("BKG02041");
						return false;
					}						
					doActionIBSheet(sheetObjects[8],document.form,COMMAND12);
	    		break;
				case "btn_cancel":
					if (validateForm(sheetObjects[1],formObj,COMMAND03)){						
						if (ComGetObjValue(formObj.cod_mnl_flg)=="Y"){
							doActionIBSheet(sheetObjects[8],document.form,COMMAND13);							
						} else {
							doActionIBSheet(sheetObjects[8],document.form,COMMAND03);
						}
					}
				break;
				case "btn_bkg_main": 
					 if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
						ComShowCodeMessage("BKG00384");
						return;
					 }
				     if (ComGetObjValue(formObj.codStsCd).toUpperCase()!="Y"){
						ComShowCodeMessage("BKG00748");
						return;
					 } 
					 if(ComIsEmpty(formObj.bkg_no)){
					 	return;
				     }
				     ComSetObjValue(formObj.ca_rsn_cd, "");					        		
				     ComSetObjValue(formObj.ca_remark, "");		
				     tmpCaMode = "S";
					 comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "S");
//					 if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
//						 doActionIBSheet(sheetObjects[0],formObj,COMMAND10);
//					 }
				break;
				case "btn_confirm":					
					if (validateForm(sheetObjects[1],formObj,COMMAND07)){			
						var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
						var arrRow=sRow.split("|");				 
						if ((arrRow.length) ==(sheetObjects[0].RowCount())){ //If all checked Cntr checkbox
						//execute p/c again							
							doActionIBSheet(sheetObjects[8],formObj,COMMAND08);
						    if (formObj.bdr_flag.checked){ 
						    	//bdr 지났을 경우 c/a issue handling
							    ComSetObjValue(formObj.ca_rsn_cd, "");					        		
							    ComSetObjValue(formObj.ca_remark, "");
							    tmpCaMode = "C";
						    	comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C"); 
//								if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
//						    		doActionIBSheet(sheetObjects[8],formObj,COMMAND07);
//						    	}
						    } else {
						    	//go on without pop-up, if it is before bdr
						  		doActionIBSheet(sheetObjects[8],formObj,COMMAND07);
						    }
						}else{				
							var param=""; 			
							// go on cod split
							param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
							param+="&cod_rqst_seq="+ComGetObjValue(formObj.cod_rqst_seq);
							param+="&cod_rqst_rsn_cd="+ComGetObjValue(formObj.cod_rqst_rsn_cd);
							param+="&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
							param+="&pgmNo=ESM_BKG_0997";
							param+=setCntrSpc();
							ComOpenPopup("/opuscntr/ESM_BKG_0997.do"+param, 690, 480, '', '1,0,1,1,1', true);
						} 
					}
				break;
				case "btn_close":
					ComClosePopup(); 
				break;
				case "btn_Mail":
					formObj.edt_eml_btn_flg.value ="Y";
					doActionIBSheet(sheetObjects[8],formObj,"btn_Mail");
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
    		} else {
    			//ComShowMessage(e);
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
     * registering IBCombo Object as list
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
		setCodReason_Combo(); // combo setting
		cod_rjct_cd.SetBackColor("#eeeeee");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_request");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_bkg_main");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_approve");
		if (ComGetObjValue(document.form.popFlg)=="S" && ComGetObjValue(document.form.bkg_no) != ""){
			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 
		axon_event.addListenerFormat('keypress','bkg0156_keypress',document.form);   
		axon_event.addListenerForm('blur', 'bkg0156_blur', document.form);
		axon_event.addListenerForm('change','bkg0156_change',document.form);	
		ComSetFocus(document.form.bkg_no);
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch(sheetId) {
			case "sheet1":      //sheet1 init CNTR LIST
			    with(sheetObj){		       
		      
		      var HeadTitle1=" ||Seq.|Sel.|CNTR No.|Type|Weight|Weight|ST|DG|BB|AK|RF|SOC|Stowage|||";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"reserved_cntr_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"seq" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1, TrueValue:"Y", FalseValue:"N" },
		             {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"cntr_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bb_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"rc_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"soc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue:"Y", FalseValue:"N" },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_stwg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"dg_eml_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"rf_eml_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_tpsz_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }];
		      InitColumns(cols);
		      SetSheetHeight(130);
		      SetEditable(1);
		      
		            }
				break;
			case "sheet2":      //sheet2 init OLD&NEW ROUTE
			    with(sheetObj){
		       
		      var HeadTitle1="|BKG Route|POR|POR|POL|POL|POD|POD|DEL|DEL|D|PRE|PRE|POST|POST|T/VVD|Details";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"bkgroute",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"por_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"por_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"de_term_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pre_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pre_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pst_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pst_nod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"tvvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Image",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		        
		      
			      InitColumns(cols);
			      SetSheetHeight(130);
			      SetEditable(1);
			      SetImageList(0,"img/btng_ts_route.gif");
			      
			      SetColProperty(0,prefix2+"pod_cd",	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
				  SetColProperty(0,prefix2+"pod_nod_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
				  SetColProperty(0,prefix2+"del_cd",	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
				  SetColProperty(0,prefix2+"del_nod_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
				  SetColProperty(0,prefix2+"tvvd",		 {AcceptKeys:"E|N" , InputCaseSensitive:1});
		        }
				break;
			case "sheet3":      //sheet3 init CHARGE
			    with(sheetObj){
		        
		      var HeadTitle1="|Seq.|Re-Handling Port|CHG|Currency|Rate|Rated as|Per|Amount|Term|CGO|Type||";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cost_cd_rqst_seq", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     	Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"cod_rhnd_port_yd_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"chg_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"curr_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix3+"chg_ut_amt",       		KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"rat_as_qty",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"rat_ut_cd",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix3+"chg_amt",          		KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"frt_term_cd",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cgo_cate_cd",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cntr_cgo_tp_cd",   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"bkg_no",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"cod_rqst_seq",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(130);
		      SetEditable(1);
		      SetShowButtonImage(2);
		      SetConfig({UseNoDataRow:1});
		      }
				break;
			case "sheet4":      //sheet4 init
			    with(sheetObj){
		       
		      var HeadTitle1="|Total|Total";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"curr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix4+"sumamt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		       
				      InitColumns(cols);
				      SetSheetHeight(130);
				      SetEditable(1);
				      SetConfig({UseNoDataRow:0});
		            }
			    
				break;
			case "sheet5":      //sheet5 init
			    with(sheetObj){
		       
		     
		      var HeadTitle1="|Status|Date|By|Office|Now Read|Previous";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix5+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"cod_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"update_date", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"update_by",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"update_ofc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:280,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"now_read",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:280,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"previous",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(70,1);
//		      updateSheetSize(sheetObj);
		      SetEditable(1);
		      SetCountPosition(0);
		      SetColProperty(prefix5+"update_date", {Format:"####-##-##"} );
		      }
			   break;
			case "sheet6":      //old route
			    with(sheetObj){
		        
		      var HeadTitle="|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"bkg_no" },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"cod_rqst_seq" },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"vvd_op_cd" } ];
		       
			      InitColumns(cols);
			      SetEditable(1);
			      SetConfig({UseNoDataRow:0});
			      SetVisible(0);
		            }
                break;
			case "sheet7":		// new route
			      with(sheetObj){
	            
	         var HeadTitle="|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";
	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	         InitHeaders(headers, info);
	         var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"ibflag" },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix7+"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"bkg_no" },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"cod_rqst_seq" },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"vvd_op_cd" } ];	          
	         InitColumns(cols);
	         SetEditable(1);
	         SetConfig({UseNoDataRow:0});
	         SetVisible(0);
	         }
			      break;
			case "sheet8"://t/s route
			    with(sheetObj){
		       
		      var HeadTitle="|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vsl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pod_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetConfig({UseNoDataRow:0});
		      SetVisible(0);
		            }
                break; 
			case "sheet9":
			    with(sheetObj){		       
		      var HeadTitle="TP/SZ|Vol.";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix9+"c_tpsz", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                   {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix9+"c_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetConfig({UseNoDataRow:0});
		      SetVisible(0);
		            }
				break;     
        }
    }
    

	/*
	* sheet image setting
	*/
	function sheet_imageSet(sheetObj,Col){
		sheetObj.SetColHidden(prefix2+"detail",0);
		for(var i=1;i<sheetObj.HeaderRows()+sheetObj.RowCount();i++){
			sheetObj.SetCellValue(i,Col,0);
		}
	}
	
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var arrPreFix=new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet6_","sheet7_");
    	
    	switch(sAction) {        	
    	case IBSEARCH:      //Retrieve
            //no support[check again]CLT 		sheetObjects[5].Rows=1;
  //no support[check again]CLT 			   	sheetObjects[6].Rows=1;
  //no support[check again]CLT 			   	sheetObjects[7].Rows=1;
    			sheetObjects[5].RemoveAll();
    			sheetObjects[6].RemoveAll();
    			sheetObjects[7].RemoveAll();
    			sheetObjects[5].DataInsert(-1);
    			sheetObjects[6].DataInsert(-1);
    			sheetObjects[7].DataInsert(-1);
    		
    		
  			   	formObj.f_cmd.value=SEARCH;
  				sheetObj.SetWaitImageVisible(0);
  				ComOpenWait(true);
  				var param="f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&bl_no="+formObj.bl_no.value+"&cod_rqst_seq="+formObj.cod_rqst_seq.value+ "&"+ComGetPrefixParam(arrPreFix);
   				var sXml=sheetObj.GetSearchData("ESM_BKG_0156GS.do", param);
  				ComOpenWait(false);
  				var arrXml=sXml.split("|$$|");
  				for(var i=0; i < arrXml.length; i++){ 
  					if(i==0){
  						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
  					}else{  
  						sheetObjects[i+1].LoadSearchData(arrXml[i],{Sync:1} );
  					} 
  				} 
   	   			for(var iRow=0;iRow<sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();iRow++){
   	   				if (sheetObjects[0].GetCellValue(iRow,prefix1+"reserved_cntr_flg")=="1"){
  	   					sheetObjects[0].SetCellEditable(iRow,prefix1+"chk",0);
  	   					sheetObjects[0].SetCellBackColor(iRow,prefix1+"reserved_cntr_flg",sheetObjects[0].GetCellBackColor(iRow,prefix1+"cntr_no"));
  	   				}
  		   		}
   				if(sheetObjects[1].RowCount() < 1){
  					sheetObjects[1].DataInsert();
  					sheetObjects[1].DataInsert();
  				}
  				sheetObjects[1].SetCellEditable(1,prefix2+"pod_cd",0);
  				sheetObjects[1].SetCellEditable(1,prefix2+"pod_nod_cd",0);
  				sheetObjects[1].SetCellEditable(1,prefix2+"del_cd",0);
  				sheetObjects[1].SetCellEditable(1,prefix2+"del_nod_cd",0);
  				sheetObjects[1].SetCellEditable(1,prefix2+"de_term_cd",0);
  				sheetObjects[1].SetCellEditable(1,prefix2+"tvvd",0);
  				//sheetObjects[1].CellEditable(1,prefix2+"detail")=true;
  				//sheetObjects[1].CellEditable(2,prefix2+"detail")=true;
  				sheetObjects[1].SetCellValue(1,prefix2+"bkgroute","OLD",0);
  				sheetObjects[1].SetCellValue(2,prefix2+"bkgroute","NEW",0);
  				sheetObjects[1].SetCellValue(1,prefix2+"detail",0,0);
  				sheetObjects[1].SetCellValue(2,prefix2+"detail",0,0);
  				//sheetObjects[1].CellBackColor(1,prefix2+"detail") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
  				//sheetObjects[1].CellBackColor(2,prefix2+"detail") = sheetObjects[1].CellBackColor(2,prefix2+"bkgroute");
  				sheetObjects[1].SetCellBackColor(2,prefix2+"por_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(2,prefix2+"pol_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(2,prefix2+"pre_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(2,prefix2+"pst_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pod_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pol_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pol_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"del_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"del_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pre_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pre_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pst_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"pst_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				sheetObjects[1].SetCellBackColor(1,prefix2+"tvvd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
  				setFormData(formObj,sheetObj);
//  				if (ComIsNull(formObj.oldCodRqstSeq)){
//  					ComSetObjValue(formObj.saveModeCd,"C");
//                  }else{
//  					ComSetObjValue(formObj.saveModeCd,"U");
//  				}
  				formObj.cod_cnt.value = ComGetEtcData(arrXml[0],"cod_cnt");
  				if (ComGetObjValue(formObj.cod_cnt) < ComGetObjValue(formObj.cod_rqst_seq)){
  					ComSetObjValue(formObj.saveModeCd,"C");
  				}else{
  					ComSetObjValue(formObj.saveModeCd,"U");
  				}
  				if (ComGetObjValue(document.form.popFlg)!="S"){ 
  					btnEnable(formObj);
  				}
  				if(!ComIsNull(formObj.codRjctRsnRmk)){
  					ComBtnColor("btn_reject","blue");	
  				} else {
  					ComBtnColor("btn_reject","#737373");					
  				}
  				//Old Route
  				if (sheetObjects[5].GetTotalRows()==0){
  //no support[check again]CLT 					sheetObjects[5].Rows=1;  
  					sheetObjects[5].RemoveAll();
  	    			sheetObjects[5].DataInsert(-1);
  				}else{ 
  					for(var iRow=0;iRow<sheetObjects[5].HeaderRows()+sheetObjects[5].RowCount();iRow++){
  						sheetObjects[5].SetCellValue(iRow, prefix6+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
  						sheetObjects[5].SetCellValue(iRow, prefix6+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
  						sheetObjects[5].SetCellValue(iRow, prefix6+"vvd_op_cd","O",0);
  					}
  				}
  				//New Route
  				if (sheetObjects[6].GetTotalRows()==0 && sheetObjects[5].GetTotalRows!=0){
  					sheetObjects[6].RemoveAll();
                    //sheetObjects[5].Copy2SheetCol(sheetObjects[6],"","",-1,-1,-1,1,false,false);
  					for(iRow=sheetObjects[5].HeaderRows();iRow<sheetObjects[5].HeaderRows()+sheetObjects[5].RowCount();iRow++){
  						sheetObjects[6].DataInsert(-1);
  						for(iCol=0;iCol<sheetObjects[5].LastCol()+1;iCol++){
  							sheetObjects[6].SetCellValue(iRow,iCol,sheetObjects[5].GetCellValue(iRow,iCol));
  						}
  					}
   					for(var iRow=1;iRow<sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount();iRow++){
  						sheetObjects[6].SetCellValue(iRow, prefix7+"vvd_op_cd","N",0);
  					}
  				}else if (sheetObjects[6].GetTotalRows()==0){
  //no support[check again]CLT 					sheetObjects[6].Rows=1;
  					sheetObjects[6].RemoveAll();
  	    			sheetObjects[6].DataInsert(-1);
  				}else{ 
  					for(var iRow=0;iRow<sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount();iRow++){
  						sheetObjects[6].SetCellValue(iRow, prefix7+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
  						sheetObjects[6].SetCellValue(iRow, prefix7+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
  						sheetObjects[6].SetCellValue(iRow, prefix7+"vvd_op_cd","N",0);
  					}
  				}
  				if (!ComIsEmpty(formObj.codRemark)){  
  					ComBtnColor("btn_remark","blue");
  				} else {
  					ComBtnColor("btn_remark","#737373");					
  				}	 	
  				
  				break;

          	case IBSAVE:        //Save
		        if (ComGetObjValue(formObj.saveModeCd).toUpperCase()=="C"){
					formObj.f_cmd.value=ADD; 
		        }else if (ComGetObjValue(formObj.saveModeCd).toUpperCase()=="U"){
					formObj.f_cmd.value=MODIFY; 
				}
				RouteData();
				var params=FormQueryString(formObj);
            	params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
                if(State == "S"){
					ComSetObjValue(formObj.saveModeCd,"U");
					if (!ComIsEmpty(formObj.codRemark)){  
						ComBtnColor("btn_remark","blue");
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}				 
            break;
          	case REMOVE:
          		formObj.f_cmd.value=REMOVE; 
				var params="f_cmd="+REMOVE + "&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value
											   +"&popFlg="+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&rgn_cd="+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&codStsCd="+formObj.codStsCd.value
											   +"&cod_mnl_flg="+formObj.cod_mnl_flg.value;
//          		var params = FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				sheetObj.LoadSearchData(sXml,{Sync:1} );
	            if(State == "S"){
					var iseq=formObj.cod_rqst_seq[formObj.cod_rqst_seq.selectedIndex].value;
					if (iseq !=1){
						formObj.cod_rqst_seq.options[formObj.cod_rqst_seq.selectedIndex]=null;
						ComSetObjValue(formObj.cod_rqst_seq,formObj.cod_rqst_seq.selectedIndex-1);
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			break;
          	case COMMAND01:			//Sequence Combo
				formObj.f_cmd.value=COMMAND01; 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var params="f_cmd="+COMMAND01+"&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value;
//          		params = FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var arrVal=ComXml2ComboString(sXml, "val", "name");  
				ComboList(arrVal);
				break;
          	case COMMAND02:		//Request Click	   
				RouteData();
          		if (validateForm(sheetObjects[1],formObj,IBSAVE)==false){
          			return false;
          		}
          		formObj.f_cmd.value=MODIFY; // Save
				var params=FormQueryString(formObj);
		    	params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State == "S"){						
			        formObj.f_cmd.value=COMMAND02;
	          		params=FormQueryString(formObj);
	          		sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
					ComOpenWait(false);
					State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		            if(State == "S"){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						setEmlCtnt(sXml);
						groupMailset("R");
						doActionIBSheet(sheetObjects[8],formObj,"snd_mail");
					} else {
						sheetObj.LoadSaveData(sXml);
					}
				} else {
					sheetObj.LoadSaveData(sXml);
				}
				break;
          	case COMMAND03:		//Cancel Click	
          		formObj.f_cmd.value=COMMAND03; 
				var params="f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value
											   +"&popFlg="+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="	+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&rgn_cd="+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&codStsCd="+formObj.codStsCd.value
											   +"&cod_mnl_flg="+formObj.cod_mnl_flg.value;
//          		params = FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				sheetObj.LoadSearchData(sXml,{Sync:1} );
	            if(State == "S"){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("C");
					doActionIBSheet(sheetObjects[8],formObj,"snd_mail");
				}
				break;
          	case COMMAND05:		//Calculation Click	
          		formObj.f_cmd.value=COMMAND05; 
          		RouteData();
          		var params=FormQueryString(formObj);
          		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
          		params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));
          		params=params + "&" + ComGetPrefixParam(new Array("sheet3_"));
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0156GS.do", params);
          		ComOpenWait(false);
          		var arrXml=sXml.split("|$$|");
          		sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
          		
          		if(sheetObj.RowCount()>0){
          			var idx=0;
	          		var currCd="XXX";
	          		var arrCurrCd=new Array();
	          		var arrCurrAmt=new Array();
	          		for(i=1;i<sheetObj.HeaderRows()+sheetObj.RowCount();i++){
						if(currCd != sheetObj.GetCellValue(i, prefix3+"curr_cd")){
							currCd=sheetObj.GetCellValue(i, prefix3+"curr_cd");
	          				idx++;
	          				arrCurrCd[idx]=sheetObj.GetCellValue(i, prefix3+"curr_cd");
	          				arrCurrAmt[idx]=0;
	          			}
						arrCurrAmt[idx]=arrCurrAmt[idx]+ComParseInt(sheetObj.GetCellValue(i, prefix3+"chg_amt"));
						sheetObj.SetCellValue(i, prefix3+"cod_rhnd_port_yd_cd",formObj.cod_rhnd_port_cd.value,0);
	          		}
	          		sheetObjects[3].RemoveAll();
	          		for(i=1;i<idx+1;i++){
	          			sheetObjects[3].DataInsert(-1);
	          			sheetObjects[3].SetCellValue(i, prefix4+"curr_cd",arrCurrCd[i],0);
	          			sheetObjects[3].SetCellValue(i, prefix4+"sumamt",arrCurrAmt[i],0);
	          		}
          		}
          		break;
          	case COMMAND06:		//Complete COD CA	
				formObj.f_cmd.value=COMMAND06; 			
				var params=FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);       
				sheetObj.LoadSearchData(sXml,{Sync:1} );
	            if(State == "S"){     	 
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("F");
	            }
				break;
          	case COMMAND07:		//Confirm Click	
				formObj.f_cmd.value=COMMAND07; 
          		RouteData();
          		var params=FormQueryString(formObj);
          		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
          		params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
          		params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	            if(State == "S"){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("F");	
					doActionIBSheet(sheetObjects[8],formObj,"snd_mail");
				} else {
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
          	case COMMAND08:		//PC Click	
				formObj.f_cmd.value=COMMAND08;
				var arrPreFix=new Array("sheet6_","sheet7_","sheet9_");
				RouteData();
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
				params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
	    		pcBtnColor("RED");
			    formObj.pctl_no.value=null;
			    var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params+ "&" + ComGetPrefixParam(arrPreFix));
	    		ComOpenWait(false);
	    		var arrXml=sXml.split("|$$|");
			    var isPctlNoPop="N";
				isPctlNoPop=ComGetEtcData(arrXml[0], "IsPctlNoPop")
	            if(isPctlNoPop == "Y"){            	
	    			sheetObjects[8].LoadSearchData(arrXml[2],{Sync:1} );
					// ESD_PRD_0080 화면 호출
					var url="ESD_PRD_0080.do?f_cmd=3&pc_mode=R";
					url=url + "&bkg_no="+	ComGetObjValue(formObj.bkg_no);
					url=url + "&por="   +	ComGetEtcData(arrXml[0], "por");
					url=url + "&por_n=" +	ComGetEtcData(arrXml[0], "por_n");
					url=url + "&pol="   + ComGetEtcData(arrXml[0], "pol");
					url=url + "&pol_n=" + ComGetEtcData(arrXml[0], "pol_n");
					url=url + "&pod="   + sheetObjects[1].GetCellValue(2,prefix2+"pod_cd");
					url=url + "&pod_n=" + sheetObjects[1].GetCellValue(2,prefix2+"pod_cd")+sheetObjects[1].GetCellValue(2,prefix2+"pod_nod_cd");
					url=url + "&del="   + sheetObjects[1].GetCellValue(2,prefix2+"del_cd");
					url=url + "&del_n=" + sheetObjects[1].GetCellValue(2,prefix2+"del_cd")+sheetObjects[1].GetCellValue(2,prefix2+"del_nod_cd");
					url=url + "&t_vvd=" + sheetObjects[1].GetCellValue(2,prefix2+"tvvd");	
					
					for(i = 1 ; i < sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount(); i++){		
						url=url + "&pol" + i + "="   + sheetObjects[6].GetCellValue(i, prefix7+"pol_yd_cd").substring(0,5);
						url=url + "&pol" + i + "_n=" + sheetObjects[6].GetCellValue(i, prefix7+"pol_yd_cd");
						url=url + "&pod" + i + "_c=" + sheetObjects[6].GetCellValue(i, prefix7+"pol_clpt_ind_seq");
						url=url + "&pod" + i + "="   + sheetObjects[6].GetCellValue(i, prefix7+"pod_yd_cd").substring(0,5);
						url=url + "&pod" + i + "_n=" + sheetObjects[6].GetCellValue(i, prefix7+"pod_yd_cd");
						url=url + "&pod" + i + "_c=" + sheetObjects[6].GetCellValue(i, prefix7+"pod_clpt_ind_seq");
						url=url + "&vvd" + i + "="   + sheetObjects[6].GetCellValue(i, prefix7+"vsl_cd") + sheetObjects[6].GetCellValue(i, prefix7+"skd_voy_no") + sheetObjects[6].GetCellValue(i, prefix7+"skd_dir_cd");
					}
					
					url=url + "&rcv_t=" + ComGetEtcData(arrXml[0], "rcv_t");
					url=url + "&del_t=" + sheetObjects[1].GetCellValue(2,prefix2+"de_term_cd");
					url=url + "&shpr="  + ComGetEtcData(arrXml[0], "shpr");
					url=url + "&cngn="  + ComGetEtcData(arrXml[0], "cngn");
					url=url + "&com="     + ComGetEtcData(arrXml[0], "com");
					url=url + "&rep_com=" + ComGetEtcData(arrXml[0], "rep_com");
					url=url + "&wgt="     + ComGetEtcData(arrXml[0], "wgt");
					url=url + "&wgt_un="  + ComGetEtcData(arrXml[0], "wgt_un");
					url=url + "&bkg_ofc=" + ComGetEtcData(arrXml[0], "bkg_ofc");
					url=url + "&org_sal_ofc=" + ComGetEtcData(arrXml[0], "org_sal_ofc"); 
					url=url + "&m_pu=" + ComGetEtcData(arrXml[0], "m_pu");
					url=url + "&f_rt=" + ComGetEtcData(arrXml[0], "f_rt");
					url=url + "&sc="  + ComGetEtcData(arrXml[0], "sc");
					url=url + "&rfa=" + ComGetEtcData(arrXml[0], "rfa");
					url=url + "&cgo_tp=" + ComGetEtcData(arrXml[0], "cgo_tp");
					url=url + "&dg_f=" + ComGetEtcData(arrXml[0], "dg_f");
					url=url + "&rf_f=" + ComGetEtcData(arrXml[0], "rf_f");
					url=url + "&ak_f=" + ComGetEtcData(arrXml[0], "ak_f");
					url=url + "&bb_f=" + ComGetEtcData(arrXml[0], "bb_f");
					url=url + "&rd_f=" + ComGetEtcData(arrXml[0], "rd_f");
					url=url + "&hg_f=" + ComGetEtcData(arrXml[0], "hg_f");
					url=url + "&soc_f="+ ComGetEtcData(arrXml[0], "soc_f");
					url=url + "&pm_f=" + ComGetEtcData(arrXml[0], "pm_f");
					
					for(i = 1 ; i < sheetObjects[8].HeaderRows()+sheetObjects[8].RowCount() ; i++){
						url=url + "&c_tpsz="+sheetObjects[8].GetCellValue(i, prefix9+"c_tpsz");
						url=url + "&c_qty=" +sheetObjects[8].GetCellValue(i, prefix9+"c_qty");
					}
//	    			alert(url);
	    			ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080","1,0,1,1,1", true);
//	    			if(ComGetObjValue(formObj.pctl_no).length>=20){
//	    				doActionIBSheet(sheetObjects[0],formObj,COMMAND09);
//	    			} else {
//	            		pcBtnColor("RED");
//	    			}
	            } else {
					var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key);
		            if(State == "S"){         	
		        		setNewRouteFromPrd(sXml, formObj);
		        		btnEnable(formObj);
		            } else {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
	    		} 
	        	break;
		   case COMMAND09:		//searchRehandlingPort(0080화면에서 call back 후)
				formObj.f_cmd.value=COMMAND09; 
				var arrPreFix=new Array("sheet6_","sheet7_");
				var params=FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params+ "&" + ComGetPrefixParam(arrPreFix));
				ComOpenWait(false);
	    		var arrXml=sXml.split("|$$|");			    
			    var State=ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
	            if(State == "S"){
	        		setNewRouteFromPrd(sXml, formObj);
	    		} else {
					sheetObj.LoadSearchData(sXml,{Sync:1} );
//	    			ComShowCodeMessage("BKG00740");
	        		pcBtnColor("RED");
	    		}
	            btnEnable(formObj);
	    		break;
		   	case COMMAND10:		//Start COD C/a (booking creation)	   	
				formObj.f_cmd.value=COMMAND10; 
				var params=FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
	            if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S"){
		        	var sUrl="/opuscntr/ESM_BKG_0079_P.do";
		        	sUrl += "?pgmNo=ESM_BKG_0079&mainPage=false&isPop=Y";
		        	sUrl += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
		        	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 700, true, 'yes'); 	
//		       		 var param="?bkg_no="+ComGetObjValue(formObj.bkg_no)+"&mainPage=true";
//		       		 param+="&isPop=Y";
//		       		 param+="&pgmNo=ESM_BKG_0079";
////		       		 ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, "yes")
//		       		 ComOpenWindowCenter("/opuscntr/ESM_BKG_0079_P.do"+param, "ESM_BKG_0079", 1024, 700, true, "yes");
	            }
		   		break;
		   	case COMMAND11:		//manual request
		   	case COMMAND12:		//manual Approve
		   	case COMMAND13:		//manual cancel
		   		if(sAction==COMMAND11){
					RouteData();
	          		if (validateForm(sheetObjects[1],formObj,IBSAVE)==false){
	          			return false;
	          		}
	          		formObj.f_cmd.value=MODIFY; // Save
					var params=FormQueryString(formObj);
			    	params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
					params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
					params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
					params=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
					params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
					params=params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if(State != "S"){
						sheetObj.LoadSaveData(sXml);
						return false;
					}
		   		}
	   			formObj.f_cmd.value=sAction;
				var params="f_cmd="+sAction+"&bkg_no="			+formObj.bkg_no.value
											   +"&bl_no="			+formObj.bl_no.value
											   +"&cod_rqst_seq="	+formObj.cod_rqst_seq.value
											   +"&popFlg="			+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="	+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="		+formObj.bdr_flag.value
											   +"&rgn_cd="			+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="		+formObj.bdr_flag.value
											   +"&codStsCd="		+formObj.codStsCd.value
											   +"&cod_mnl_flg="		+formObj.cod_mnl_flg.value;
//				var params = FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	            if(State == "S"){
					ComShowMessage(ComResultMessage(sXml));
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					if(sAction == COMMAND11){
						setEmlCtnt(sXml);
						groupMailset("R");
			        }else if(sAction == COMMAND13){
						setEmlCtnt(sXml);
						groupMailset("C");
					}
				} else {
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
		   		break;
		   	case "btn_Mail":
		   		// If there is no status of COD, cannot use mail funciton.
		   		if(sheetObjects[4].RowCount() == 0){
		   			ComShowMessage(msgs['BKG08254']);
		   			return false;
		   		}
		   		formObj.f_cmd.value=COMMAND14;
				var param = FormQueryString(formObj);
				param += "?bkg_no="+formObj.bkg_no.value
									+"&vvd="+sheetObjects[6].GetCellValue(1,prefix7+"vsl_cd")+sheetObjects[6].GetCellValue(1,prefix7+"skd_voy_no")+sheetObjects[6].GetCellValue(1,prefix7+"skd_dir_cd")
									+"&old_pol_cd="+sheetObjects[1].GetCellValue(1,prefix2+"pol_cd")
									+"&old_pod_cd="+sheetObjects[1].GetCellValue(1,prefix2+"pod_cd")
									+"&new_pod_cd="+sheetObjects[1].GetCellValue(2,prefix2+"pod_cd")
									+"&rso="+formObj.rgn_cd.value
									+"&slan_cd="+sheetObjects[6].GetCellValue(1,prefix7+"slan_cd");
				var sXml = sheetObj.GetSearchData("ESM_BKG_0156GS.do", param);
				var ntc_knd_cd = "CD";
				formObj.vsl_eng_nm.value = ComGetEtcData(sXml, "vslEngNm");	//content_6
				//TO
				formObj.com_recipient.value = ComZeroToNull(ComGetEtcData(sXml, "picEml"));
				//To find COD CNTR
				formObj.cod_sts_cd.value = sheetObjects[4].GetCellValue(1, "sheet5_cod_sts_cd");
				//Contents
				formObj.ob_cssm_voy_nm.value = ComGetEtcData(sXml, "obCssmVoyNm");	//content_7
				formObj.old_pol.value = sheetObjects[1].GetCellValue(1,prefix2+"pol_cd") + "(" + ComGetEtcData(sXml, "oldPolFullNm") + ")";	
				formObj.old_pod.value = sheetObjects[1].GetCellValue(1,prefix2+"pod_cd") + "(" + ComGetEtcData(sXml, "oldPodFullNm") + ")";	
				formObj.new_pod.value = sheetObjects[1].GetCellValue(2,prefix2+"pod_cd") + "(" + ComGetEtcData(sXml, "newPodFullNm") + ")";
				//Subject
				var codSts = sheetObjects[4].GetCellValue(1,prefix5+"now_read").substr(2);;
				formObj.com_subject.value = "[" + sheetObjects[6].GetCellValue(1,prefix7+"slan_cd") 
											+ "] COD Application " + formObj.vsl_eng_nm.value +" " 
											+ formObj.ob_cssm_voy_nm.value
											+ "(" + formObj.bkg_no.value + ")";
				if("" != codSts ){
					formObj.com_subject.value += " - "+codSts;
				}
//				var com_content = [formObj.eml_dt.value, formObj.carrier_cd.value,formObj.company_cd.value, codSts, formObj.codRemark.value, formObj.bkg_no.value, formObj.vsl_eng_nm.value, formObj.ob_cssm_voy_nm.value];
				//button click
				if("Y"==formObj.edt_eml_btn_flg.value){
					ComOpenWindowCenter("ESM_BKG_1096.do?ui_id=ESM_BKG_0156&ntc_knd_cd="+ntc_knd_cd
																						+"&bkg_no_list="+formObj.bkg_no.value
																						+"&edt_to_eml="+formObj.com_recipient.value
																						+"&com_subject="+formObj.com_subject.value
//																						+"&com_content="+com_content
//																						+"&cod_sts_cd="+formObj.cod_sts_cd.value
																						+"&cod_rqst_seq="+formObj.cod_rqst_seq.value
//																						+"&oldPol="+formObj.old_pol.value
//																						+"&oldPod="+formObj.old_pod.value
//																						+"&newPod="+formObj.new_pod.value
																						, "ESM_BKG_1096", 770, 560, false);
//					formObj.com_content.value = com_content;
//					formObj.action = "ESM_BKG_1096.do";
//					formObj.method = "POST";
//					formObj.target = "ESM_BKG_1096";
//					formObj.submit();
				}
				break;
		   	case "snd_mail":
		   		var params = "";
		   		if("N"==formObj.edt_eml_btn_flg.value){
		   			formObj.f_cmd.value=COMMAND16;
		   			params = FormQueryString(formObj);
		   			params += "&rso="+formObj.rgn_cd.value
		   						+"&slan_cd="+sheetObjects[6].GetCellValue(1,prefix7+"slan_cd");
		   			var sXml = sheetObj.GetSearchData("ESM_BKG_0156GS.do", params);
		   			var picEml = ComGetEtcData(sXml, "picEml");
		   			if(""==picEml || undefined == picEml){
		   				ComShowMessage(msgs['BKG08252']);
						formObj.edt_eml_btn_flg.value = "Y";
						doActionIBSheet(sheetObj, formObj, "btn_Mail");
						return false;
		   			}
		   		}
		   		formObj.f_cmd.value=COMMAND15;
		   		formObj.edt_ntc_knd_cd.value = "CD";
		   		params = FormQueryString(formObj);
		   		sXml = sheetObj.GetSaveData("ESM_BKG_0156GS.do", params);
		   		if (ComGetEtcData(sXml, "SuccessYn") == "Y"){
					if("Y"!=formObj.edt_eml_btn_flg.value){
						ComShowMessage(msgs['BKG00497']);
					}
		   		}
		   		formObj.edt_eml_btn_flg.value = "N";
		   		break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
       switch(sAction) {
			case IBSAVE:
				 if (ComIsEmpty(formObj.saveModeCd.value)){
				    return false;
				 }	  
				 if (sheetObjects[0].FindCheckedRow(prefix1+"chk").length<1){
					 ComShowCodeMessage("BKG00239");
					 return false;
				 }
				 if (ComChkLen(sheetObj.GetCellValue(2,prefix2+"por_cd"),5)!=2){
					ComShowCodeMessage("BKG00006");
					return false;
				 }
				 if (ComChkLen(sheetObj.GetCellValue(2,prefix2+"pol_cd"),5)!=2){
					ComShowCodeMessage("BKG00288");
					return false;
				 }
				 if (ComChkLen(sheetObj.GetCellValue(2,prefix2+"pod_cd"),5)!=2){
					ComShowCodeMessage("BKG00289");
					return false;
				 }
				 if (ComChkLen(sheetObj.GetCellValue(2,prefix2+"del_cd"),5)!=2){
					ComShowCodeMessage("BKG00290");
					return false;
				 }
				 if (ComChkLen(ComGetObjValue(formObj.cod_rqst_rsn_cd),2)!=2){
					ComShowCodeMessage("BKG00742");
					return false;
				 }
				 if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
					 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
					ComShowCodeMessage("BKG00048");
					return false;
				 }
				 var iCheckRow=sheetObjects[0].FindCheckedRow(prefix1+"bb_cgo_flg");
				 var arrRow=iCheckRow.split("|");
				 var cntrVar="";
				 var iLine=0;
				 if (!ComIsEmpty(iCheckRow)){ 
					 for(var i=0;i<arrRow.length;i++){
						 if (ComParseInt(i)%3==0){
							 cntrVar+=sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no");
						 }else{
							 cntrVar+=","+sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no");
						 }
						 iLine++;
						 if (ComParseInt(iLine)%3==0){
							 iLine=0;
							 cntrVar+="\n";
						 } 						 
					 }					 
					 ComShowCodeMessage("BKG02020",cntrVar);
					 return false;
				 }
				 iCheckRow=sheetObjects[0].FindCheckedRow(prefix1+"awk_cgo_flg");
				 arrRow=iCheckRow.split("|");
				 if (!ComIsEmpty(iCheckRow)){ 
					 for(var i=0;i<arrRow.length;i++){ 
						 if (i==0 && (ComIsEmpty(cntrVar) || (ComParseInt(iLine)%3==0))){
							if (cntrVar.indexOf(sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no"))<0){
							cntrVar+=sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no");
							}
						 }else{
							if (cntrVar.indexOf(sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no"))<0){
							cntrVar+=","+sheetObjects[0].GetCellValue(arrRow[i],prefix1+"cntr_no");
							}
						 }						 
						 iLine++;
						 if (ComParseInt(iLine)%3==0){
							 iLine=0;
							 cntrVar+="\n";
						 } 						 
					 }
					 ComShowCodeMessage("BKG02020",cntrVar);
					 return false;
				 }
//		  		 if(ComIsNull(ComGetObjValue(formObj.pctl_no))){
//		  		 	 ComShowCodeMessage("BKG00309");
//		  			 break;
//		  	 	 }
				 if (ComChkLen(ComGetObjValue(formObj.cod_rhnd_port_cd),7)!=2){
					ComShowCodeMessage("BKG00740");
					return false;
				 }
				 if (ComChkLen(ComGetObjValue(formObj.rgn_cd),3)!=2){
					ComShowCodeMessage("BKG00741");
					return false;
				 }
				 if (ComIsEmpty(formObj.cod_rqst_seq)){
					ComAddComboItem(formObj.cod_rqst_seq,"1","1");
				 }
			break;
		case COMMAND02://request	
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
				|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){
				ComShowCodeMessage("BKG00749");
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){
				ComShowCodeMessage("BKG00750");
				return;
			}
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			} 
            var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
			if (sRow.length<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break
		case COMMAND03://cancel
			if (!ComShowCodeConfirm("BKG00670", "")) {
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
				|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){
				ComShowCodeMessage("BKG00747");
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
				ComShowCodeMessage("BKG00384");
				return;
			}
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			} 
			var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
			if (sRow.length<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break
		case COMMAND07: //confirm
			if (!ComShowCodeConfirm("BKG00614", "")) {
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()!="Y"){
				ComShowCodeMessage("BKG00748"); 
				return;
			} 
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
				ComShowCodeMessage("BKG00384");
				return;
			}
			if (ComGetObjValue(formObj.confirmFlg)=="1"){
				ComShowCodeMessage("BKG02011");
				return;
			}
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			}
			var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
			var arrRow=sRow.split("|");
			if ((arrRow.length)<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break;
        }
        return true;
    }
	/*
	* Change Event handling
	*/
	function bkg0156_change(){
		var formObj=document.form;
		objName=ComGetEvent("name");
		if (objName=="cod_rqst_seq"){
			if(!ComIsEmpty(formObj.cod_rqst_seq)){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		} else if (objName=="bkg_no"){
			formObj.bl_no.value="";
		} else if(objName=="bl_no"){
			formObj.bkg_no.value="";
		}
	}
	/*
	 * KeyPress Event handling
	 */
    function bkg0156_keypress(){
    	objName=ComGetEvent("name");
	    var formObj=document.form;

		var btnObj=null;
		switch(objName){  
			case "bkg_no": 
			case "bl_no": 	
				if(event.keyCode == 13 && (formObj.bkg_no.value.length > 10 || formObj.bl_no.value.length == 12 )){
					btnObj=document.getElementById("btn_retrieve");
					if (btnObj) { 
						btnObj.fireEvent("onclick"); 
					}
				}
				break;
//			 case "bl_no": 	
//				if(ComIsEmpty(obj.value)) { 
//					return; 
//				}
//				if(event.keyCode == 13 && obj.value.length > 10){
//					btnObj = document.getElementById("btn_retrieve");
//					if (btnObj) { 
//						btnObj.fireEvent("onclick");
//					}
//				}
//				break;
		}
	}
    
    function ComClearObject(obj) {
        try {
            switch( obj.type ) {
                case "select-one" :
                     obj.selectedIndex='0';
                case "radio" :
                case "checkbox" :
                     obj.checked=false;
                     break;
                case "text" :
                case "hidden" :
                case "password" :
                     obj.value="";
                     break;
                default:
            } // end switch
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    
	/*
	* Change Eventhandling
	*/
	function bkg0156_blur(){
		objName=ComGetEvent("name");
		var formObj=document.form; 
	    switch(objName){ 
			case "bkg_no": 
				if (!ComIsEmpty(formObj.oldBkgNo)&&!ComIsEmpty(formObj.bkg_no) 
				    &&ComGetObjValue(formObj.oldBkgNo)!=ComGetObjValue(formObj.bkg_no)){
				    ComClearObject(formObj.bl_no);
					initVal(formObj,""); 
				}				
				break;
	        case "bl_no": 	 
				if (!ComIsEmpty(formObj.oldBlNo)&&!ComIsEmpty(formObj.bl_no)
				    &&ComGetObjValue(formObj.oldBlNo)!=ComGetObjValue(formObj.bl_no)){
				    ComClearObject(formObj.bkg_no);
					initVal(formObj,""); 
			    }
	            break;
	    }
	}
	/*
	* create combobox using Sequence Retrieve data 콤
	*/
    function ComboList(arrVal){  
		 if(typeof(arrVal)=="undefined" && ComIsEmpty(document.form.bkg_no) && ComIsEmpty(document.form.bl_no)){
			 return;
		 }else if (typeof(arrVal)=="undefined" &&(!ComIsEmpty(document.form.bkg_no) || !ComIsEmpty(document.form.bl_no))){
			 var objCbo=document.getElementById("cod_rqst_seq");
			 ComClearCombo(objCbo);		
			 
			 opt=document.createElement("option"); 
			 opt.setAttribute("value", "1");  
			 opt.innerHTML="1";  
			 objCbo.appendChild(opt);
			 
			 /*selectValues = { "1": "1"};
			 $.each(selectValues, function(key, value) {   
			     $('#cod_rqst_seq')
			          .append($('<option>', { value : key })
			          .text(value)); 
			});
			 
			 $("select[id=cod_rqst_seq] option").eq(0).prop('selected', 'selected'); 
			alert($("select[id=cod_rqst_seq] option").eq(0).text());*/
			 return;
		 }
		  var objCbo=document.getElementById("cod_rqst_seq");
		 ComClearCombo(objCbo);		 
		 var arr_value=arrVal[0].split("|"); 
		 if (arr_value.length >0){
			 var opt=document.createElement("option"); 
			 var arr_text="";   
			// opt.setAttribute("value", "");  
			// opt.innerHTML=arr_text;  
			// objCbo.appendChild(opt);
			 for(var i=0; i < arr_value.length; i++) {
				opt=document.createElement("option"); 
				arr_text=arr_value[i];   
				opt.setAttribute("value", arr_text);  
				opt.innerHTML=arr_text;  
				objCbo.appendChild(opt);
			 }
		 } 
	}
	/* get combo about COD Reason,Staus  */
	function setCodReason_Combo(){
	    var formObj=document.form;
	    var sRhqXml="";
		if (ComGetObjValue(document.form.popFlg)=="S"){
			// pop-up때 code 다시 Retrieve
			formObj.f_cmd.value=""; 
			sRhqXml=sheetObj.GetSearchData("ESM_BKG_0156GS.do", FormQueryString(formObj));
		} else {
			sRhqXml=ComGetObjValue(formObj.sXml);
		}
		var arrXml=sRhqXml.split("|$$|"); 
		ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name|desc");
		ComXml2ComboItem(arrXml[1], comboObjects[1], "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
		ComXml2ComboItem(arrXml[2], comboObjects[2], "cod_rjct_cd", "cod_rjct_cd|cod_rjct_desc");
		if (arrXml[3] !=null && arrXml[3].length > 0) {
			var arrCombo=ComXml2ComboString(arrXml[3], "val", "name");
			sheetObjects[1].SetColProperty(prefix2+"de_term_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[0]} );
		}
	}
	/*
	* variables initialization
	*/
	function initVal(formObj,flag){
		for(var i=0;i<sheetObjects.length;i++){
			sheetObjects[i].RemoveAll();
		 }
		 ComSetObjValue(formObj.saveModeCd,"");
		 formObj.rgn_cd.index="";
		 formObj.cod_rqst_rsn_cd.index=""; 
		 formObj.codRjctCd.value="-1"; 
		 formObj.cod_rjct_cd.index="";		 
         formObj.bdr_flag.checked=false;
		 ComClearObject(formObj.pctl_no);
		 ComClearObject(formObj.map_seq);
		 ComClearObject(formObj.oldBkgNo);
		 ComClearObject(formObj.oldBlNo);
         if (flag=="N"){
        	 ComClearObject(formObj.bkg_no);
		     ComClearObject(formObj.bl_no);
			 ComClearObject(formObj.bkgStsCd);
         }		 
		 ComClearCombo(formObj.cod_rqst_seq);
		 ComClearObject(formObj.oldCodRqstSeq);
		 ComClearObject(formObj.cod_auth_flg);
		 ComClearObject(formObj.codRemark);
		 ComClearObject(formObj.cod_rhnd_port_cd);
		 ComClearObject(formObj.codStsCd);
		 ComClearObject(formObj.codRjctRsnRmk); 
		 ComClearObject(formObj.confirmFlg); 
		 ComClearObject(formObj.cod_mnl_flg);		 
		 ComBtnColor("btn_remark","#c0c0c0");
		 ComBtnDisable("btn_request");
		 ComBtnDisable("btn_approve");
		 ComBtnDisable("btn_del");
		 ComBtnDisable("btn_cancel");
		 ComBtnDisable("btn_bkg_main");
		 ComBtnDisable("btn_confirm");
		 pcBtnColor("BLACK");
		 groupMailClear();
	}
	/*
	* input BKG Route
	*/
    function RouteData(){
		var formObj=document.form;
		if (!ComIsEmpty(sheetObjects[1].GetCellValue(1,prefix2+"tvvd"))){
		ComSetObjValue(formObj.oldVslCd,sheetObjects[1].GetCellValue(1,prefix2+"tvvd").substring(0,4));
		ComSetObjValue(formObj.oldSkdVoyNo,sheetObjects[1].GetCellValue(1,prefix2+"tvvd").substring(4,8));
		ComSetObjValue(formObj.oldSkdDirCd,sheetObjects[1].GetCellValue(1,prefix2+"tvvd").substring(8));
		}
		ComSetObjValue(formObj.oldPorYdCd,sheetObjects[1].GetCellValue(1,prefix2+"por_cd")+sheetObjects[1].GetCellValue(1,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.oldPolYdCd,sheetObjects[1].GetCellValue(1,prefix2+"pol_cd")+sheetObjects[1].GetCellValue(1,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.oldPodYdCd,sheetObjects[1].GetCellValue(1,prefix2+"pod_cd")+sheetObjects[1].GetCellValue(1,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.oldDelYdCd,sheetObjects[1].GetCellValue(1,prefix2+"del_cd")+sheetObjects[1].GetCellValue(1,prefix2+"del_nod_cd"));
		if (!ComIsEmpty(sheetObjects[1].GetCellValue(2,prefix2+"tvvd"))){
		ComSetObjValue(formObj.newVslCd,sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(0,4));
		ComSetObjValue(formObj.newSkdVoyNo,sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(4,8));
		ComSetObjValue(formObj.newSkdDirCd,sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(8));
		}
		ComSetObjValue(formObj.newPorYdCd, sheetObjects[1].GetCellValue(2,prefix2+"por_cd")+sheetObjects[1].GetCellValue(2,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.newPolYdCd, sheetObjects[1].GetCellValue(2,prefix2+"pol_cd")+sheetObjects[1].GetCellValue(2,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.newPodYdCd, sheetObjects[1].GetCellValue(2,prefix2+"pod_cd")+sheetObjects[1].GetCellValue(2,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.newDelYdCd, sheetObjects[1].GetCellValue(2,prefix2+"del_cd")+sheetObjects[1].GetCellValue(2,prefix2+"del_nod_cd"));
		ComSetObjValue(formObj.newDeTermCd,sheetObjects[1].GetCellValue(2,prefix2+"de_term_cd"));
	}
	/*
	* input Data to  Form
	*/
	function setFormData(formObj,sheetObj){
		
		ComSetObjValue(formObj.oldBkgNo,sheetObj.GetEtcData("bkg_no") || formObj.oldBkgNo.value);
		ComSetObjValue(formObj.bkg_no,sheetObj.GetEtcData("bkg_no") || formObj.bkg_no.value);
		ComSetObjValue(formObj.oldBlNo,sheetObj.GetEtcData("bl_no") || formObj.oldBlNo.value);
		ComSetObjValue(formObj.bl_no,sheetObj.GetEtcData("bl_no") || formObj.bl_no.value);
		ComSetObjValue(formObj.oldCodRqstSeq,sheetObj.GetEtcData("cod_rqst_seq") || formObj.oldCodRqstSeq.value);
		
		if (sheetObj.GetEtcData("bdr_flag")=="Y"){
			formObj.bdr_flag.checked=true;
		}else{
			formObj.bdr_flag.checked=false;
		}
		ComSetObjValue(formObj.max_seq,	        sheetObj.GetEtcData("max_seq"));
		ComSetObjValue(formObj.cod_rqst_seq,	sheetObj.GetEtcData("cod_rqst_seq"));
		ComSetObjValue(formObj.cod_auth_flg,	sheetObj.GetEtcData("cod_auth_flg"));
		BkgSetObjValue(formObj.rgn_cd,			sheetObj.GetEtcData("rgn_cd"));
		BkgSetObjValue(formObj.cod_rqst_rsn_cd,	sheetObj.GetEtcData("cod_rqst_rsn_cd"));
		ComSetObjValue(formObj.codRemark,		sheetObj.GetEtcData("codRemark"));
		ComSetObjValue(formObj.cod_rhnd_port_cd,sheetObj.GetEtcData("cod_rhnd_port_cd"));
		ComSetObjValue(formObj.codStsCd,		sheetObj.GetEtcData("codStsCd"));
		BkgSetObjValue(formObj.cod_rjct_cd,		sheetObj.GetEtcData("cod_rjct_cd"));
		ComSetObjValue(formObj.confirmFlg,		sheetObj.GetEtcData("confirmFlg"));
		ComSetObjValue(formObj.cod_mnl_flg,		sheetObj.GetEtcData("cod_mnl_flg"));
		changeObjectColor(ComGetObjValue(formObj.cod_mnl_flg), "Y", "cod_mnl_flg", "red", "black"); 
		if (ComIsEmpty(sheetObj.GetEtcData("cod_rjct_cd"))){
			ComSetObjValue(formObj.codRjctCd,"-1");
		}else{			 
			ComSetObjValue(formObj.codRjctCd,	sheetObj.GetEtcData("cod_rjct_cd"));
			ComSetObjValue(formObj.cod_rjct_cd,	sheetObj.GetEtcData("cod_rjct_cd"));
		}
		ComSetObjValue(formObj.codRjctRsnRmk,	sheetObj.GetEtcData("codRjctRsnRmk"));
		ComSetObjValue(formObj.bkgStsCd,		sheetObj.GetEtcData("bkgStsCd"));
		with(sheetObjects[1]){
			SetCellValue(1,prefix2+"por_cd",sheetObj.GetEtcData("oldPorCd"),0);
			SetCellValue(1,prefix2+"por_nod_cd",sheetObj.GetEtcData("oldPorNodCd"),0);
			SetCellValue(1,prefix2+"pol_cd",sheetObj.GetEtcData("oldPolCd"),0);
			SetCellValue(1,prefix2+"pol_nod_cd",sheetObj.GetEtcData("oldPolNodCd"),0);
			SetCellValue(1,prefix2+"pod_cd",sheetObj.GetEtcData("oldPodCd"),0);
			SetCellValue(1,prefix2+"pod_nod_cd",sheetObj.GetEtcData("oldPodNodCd"),0);
			SetCellValue(1,prefix2+"del_cd",sheetObj.GetEtcData("oldDelCd"),0);
			SetCellValue(1,prefix2+"del_nod_cd",sheetObj.GetEtcData("oldDelNodCd"),0);
			SetCellValue(1,prefix2+"de_term_cd",sheetObj.GetEtcData("oldDeTermCd"),0);
            SetCellValue(1,prefix2+"pre_cd",sheetObj.GetEtcData("oldPreCd"),0);
			SetCellValue(1,prefix2+"pre_nod_cd",sheetObj.GetEtcData("oldPreNodCd"),0);
			SetCellValue(1,prefix2+"pst_cd",sheetObj.GetEtcData("oldPstCd"),0);
			SetCellValue(1,prefix2+"pst_nod_cd",sheetObj.GetEtcData("oldPstNodCd"),0);
			SetCellValue(1,prefix2+"tvvd",sheetObj.GetEtcData("oldTvvd"),0);
			
			if (sheetObjects[6].RowCount() ==0){
				SetCellValue(2,prefix2+"por_cd",sheetObj.GetEtcData("oldPorCd"),0);
				SetCellValue(2,prefix2+"por_nod_cd",sheetObj.GetEtcData("oldPorNodCd"),0);
				SetCellValue(2,prefix2+"pol_cd",sheetObj.GetEtcData("oldPolCd"),0);
				SetCellValue(2,prefix2+"pol_nod_cd",sheetObj.GetEtcData("oldPolNodCd"),0);
				SetCellValue(2,prefix2+"pod_cd",sheetObj.GetEtcData("oldPodCd"),0);
				SetCellValue(2,prefix2+"pod_nod_cd",sheetObj.GetEtcData("oldPodNodCd"),0);
				SetCellValue(2,prefix2+"del_cd",sheetObj.GetEtcData("oldDelCd"),0);
				SetCellValue(2,prefix2+"del_nod_cd",sheetObj.GetEtcData("oldDelNodCd"),0);
				SetCellValue(2,prefix2+"de_term_cd",sheetObj.GetEtcData("oldDeTermCd"),0);
				pcBtnColor("RED");
			}else{
				SetCellValue(2,prefix2+"por_cd",sheetObj.GetEtcData("newPorCd"),0);
				SetCellValue(2,prefix2+"por_nod_cd",sheetObj.GetEtcData("newPorNodCd"),0);
				SetCellValue(2,prefix2+"pol_cd",sheetObj.GetEtcData("newPolCd"),0);
				SetCellValue(2,prefix2+"pol_nod_cd",sheetObj.GetEtcData("newPolNodCd"),0);
				SetCellValue(2,prefix2+"pod_cd",sheetObj.GetEtcData("newPodCd"),0);
				SetCellValue(2,prefix2+"pod_nod_cd",sheetObj.GetEtcData("newPodNodCd"),0);
				SetCellValue(2,prefix2+"del_cd",sheetObj.GetEtcData("newDelCd"),0);
				SetCellValue(2,prefix2+"del_nod_cd",sheetObj.GetEtcData("newDelNodCd"),0);
				SetCellValue(2,prefix2+"de_term_cd",sheetObj.GetEtcData("newDeTermCd"),0);
				if(ComIsEmpty(sheetObj.GetEtcData("pctl_no"))){
						pcBtnColor("RED");
						ComSetObjValue(formObj.pctl_no,"");
						ComSetObjValue(formObj.map_seq,"");
				} else {
					pcBtnColor("BLACK");
					ComSetObjValue(formObj.pctl_no,sheetObj.GetEtcData("pctl_no"));
					ComSetObjValue(formObj.map_seq,sheetObj.GetEtcData("map_seq"));
				}
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPorCd"))){
				SetCellValue(2,prefix2+"por_cd",sheetObj.GetEtcData("oldPorCd"),0);
			}else{
				SetCellValue(2,prefix2+"por_cd",sheetObj.GetEtcData("newPorCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPorCd"))){
				SetCellValue(2,prefix2+"por_nod_cd",sheetObj.GetEtcData("oldPorNodCd"),0);
			}else{
				SetCellValue(2,prefix2+"por_nod_cd",sheetObj.GetEtcData("newPorNodCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPolCd"))){
				SetCellValue(2,prefix2+"pol_cd",sheetObj.GetEtcData("oldPolCd"),0);
			}else{
				SetCellValue(2,prefix2+"pol_cd",sheetObj.GetEtcData("newPolCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPolCd"))){
				SetCellValue(2,prefix2+"pol_nod_cd",sheetObj.GetEtcData("oldPolNodCd"),0);
			}else{
				SetCellValue(2,prefix2+"pol_nod_cd",sheetObj.GetEtcData("newPolNodCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPodCd"))){
				SetCellValue(2,prefix2+"pod_cd",sheetObj.GetEtcData("oldPodCd"),0);
			}else{
				SetCellValue(2,prefix2+"pod_cd",sheetObj.GetEtcData("newPodCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newPodCd"))){
				SetCellValue(2,prefix2+"pod_nod_cd",sheetObj.GetEtcData("oldPodNodCd"),0);
			}else{
				SetCellValue(2,prefix2+"pod_nod_cd",sheetObj.GetEtcData("newPodNodCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newDelCd"))){
				SetCellValue(2,prefix2+"del_cd",sheetObj.GetEtcData("oldDelCd"),0);
			}else{
				SetCellValue(2,prefix2+"del_cd",sheetObj.GetEtcData("newDelCd"),0);
			}
			if (ComIsEmpty(sheetObj.GetEtcData("newDelCd"))){
				SetCellValue(2,prefix2+"del_nod_cd",sheetObj.GetEtcData("oldDelNodCd"),0);
			}else{
				SetCellValue(2,prefix2+"del_nod_cd",sheetObj.GetEtcData("newDelNodCd"),0);
			}			
			if (ComIsEmpty(sheetObj.GetEtcData("newDeTermCd"))){
				SetCellValue(2,prefix2+"de_term_cd",sheetObj.GetEtcData("oldDeTermCd"),0);
			}else{
				SetCellValue(2,prefix2+"de_term_cd",sheetObj.GetEtcData("newDeTermCd"),0);
			}			
            SetCellValue(2,prefix2+"pre_cd",sheetObj.GetEtcData("newPreCd"),0);
			SetCellValue(2,prefix2+"pre_nod_cd",sheetObj.GetEtcData("newPreNodCd"),0);
			SetCellValue(2,prefix2+"pst_cd",sheetObj.GetEtcData("newPstCd"),0);
			SetCellValue(2,prefix2+"pst_nod_cd",sheetObj.GetEtcData("newPstNodCd"),0);
			if (ComIsEmpty(sheetObj.GetEtcData("newTvvd"))){
				SetCellValue(2,prefix2+"tvvd",sheetObj.GetEtcData("oldTvvd"),0);
			}else{
				SetCellValue(2,prefix2+"tvvd",sheetObj.GetEtcData("newTvvd"),0);
			}			
		 }
	}
	function setNewRouteFromPrd(sXml, formObj){	
		var arrXml=sXml.split("|$$|");
		var State=ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
		if(State != "S"){
			ComSetObjValue(formObj.pctl_no, "");
			ComSetObjValue(formObj.map_seq, "");
			ComSetObjValue(formObj.cod_mnl_flg, "");  
			pcBtnColor("RED");
			return;
		} else {
			pcBtnColor("BLACK");
		}
		// only change pctl_no after request
		if (!ComIsNull(formObj.codStsCd)&&"R"==ComGetObjValue(formObj.codStsCd)){
			ComSetObjValue(formObj.pctl_no, ComGetEtcData(arrXml[0], "pctl_no"));
			ComSetObjValue(formObj.map_seq, ComGetEtcData(arrXml[0], "map_seq"));			
			return;
		}
		for(var i=0; i < arrXml.length; i++){
			//sheetObjects[i + 5].RenderSheet(0);
			sheetObjects[i + 5].LoadSearchData(arrXml[i],{Sync:1} );
			//sheetObjects[i + 5].RenderSheet(true);
		}
		ComSetObjValue(formObj.cod_rhnd_port_cd, sheetObjects[5].GetEtcData("cod_rhnd_port_cd"));
		ComSetObjValue(formObj.pctl_no,          sheetObjects[5].GetEtcData("pctl_no"));
		ComSetObjValue(formObj.map_seq,          sheetObjects[5].GetEtcData("map_seq"));
		ComSetObjValue(formObj.cod_mnl_flg,      sheetObjects[5].GetEtcData("cod_mnl_flg"));
		if(sheetObjects[5].GetEtcData("rgn_cd")!=null){
			if(sheetObjects[5].GetEtcData("rgn_cd").length==3 && formObj.pc_flg.value == "Y"){
				ComSetObjValue(formObj.rgn_cd,			 sheetObjects[5].GetEtcData("rgn_cd"));
				BkgSetObjValue(formObj.rgn_cd, formObj.rgn_cd.value);
				formObj.pc_flg.value = "N";
			}
		}
		changeObjectColor(ComGetObjValue(formObj.cod_mnl_flg), "Y", "cod_mnl_flg", "red", "black"); 
		
		for(iRow=1;iRow<sheetObjects[0].HeaderRows()+sheetObjects[0].RowCount();iRow++){
			if(sheetObjects[0].GetCellValue(iRow, prefix1+"chk")==1){
				if(sheetObjects[5].GetEtcData(sheetObjects[0].GetCellValue(iRow,prefix1+"cntr_no"))!="undefined"){
					sheetObjects[0].SetCellValue(iRow,prefix1+"cntr_stwg_no",sheetObjects[5].GetEtcData(sheetObjects[0].GetCellValue(iRow,prefix1+"cntr_no")),0);
				}
			}
		}
		for(var iRow=1;iRow<sheetObjects[5].HeaderRows()+sheetObjects[5].RowCount();iRow++){
			sheetObjects[5].SetCellValue(iRow, prefix6+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
			sheetObjects[5].SetCellValue(iRow, prefix6+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
			sheetObjects[5].SetCellValue(iRow, prefix6+"vvd_op_cd","O",0);
		}	
		for(var iRow=1;iRow<sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount();iRow++){
			sheetObjects[6].SetCellValue(iRow, prefix7+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
			sheetObjects[6].SetCellValue(iRow, prefix7+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
			sheetObjects[6].SetCellValue(iRow, prefix7+"vvd_op_cd","N",0);
		}
		with(sheetObjects[1]){
			SetCellValue(2,prefix2+"tvvd",sheetObjects[5].GetEtcData("newTvvd"),0);
			SetCellValue(2,prefix2+"pod_cd",sheetObjects[5].GetEtcData("newPodCd"),0);
			SetCellValue(2,prefix2+"pod_nod_cd",sheetObjects[5].GetEtcData("newPodNodCd"),0);
			SetCellValue(2,prefix2+"del_cd",sheetObjects[5].GetEtcData("newDelCd"),0);
			SetCellValue(2,prefix2+"del_nod_cd",sheetObjects[5].GetEtcData("newDelNodCd"),0);
			SetCellValue(2,prefix2+"pre_cd",sheetObjects[5].GetEtcData("newPreCd"),0);
			SetCellValue(2,prefix2+"pre_nod_cd",sheetObjects[5].GetEtcData("newPreNodCd"),0);
			SetCellValue(2,prefix2+"pst_cd",sheetObjects[5].GetEtcData("newPstCd"),0);
			SetCellValue(2,prefix2+"pst_nod_cd",sheetObjects[5].GetEtcData("newPstNodCd"),0);
		}
		return true;
	}
	/*
	* eml setting
	*/
	function setEmlCtnt(sXml){
		var formObj=document.form;
		formObj.eml_header.value=ComGetEtcData(sXml, "eml_header");
		formObj.rhnd_vvd.value=ComGetEtcData(sXml, "rhnd_vvd");
		formObj.rhnd_vvd_nm.value=ComGetEtcData(sXml, "vsl_nm");
		formObj.rhnd_vvd_voyage.value=ComGetEtcData(sXml, "voyage_no");
		formObj.rhnd_port_cd.value=ComGetEtcData(sXml, "new_pod");
		formObj.rhnd_vvd_old_pol.value=ComGetEtcData(sXml, "old_pol");
		formObj.rhnd_vvd_old_pol_nm.value=ComGetEtcData(sXml, "old_pol_nm");
		formObj.rhnd_vvd_old_pod.value=ComGetEtcData(sXml, "old_pod");
		formObj.rhnd_vvd_old_pod_nm.value=ComGetEtcData(sXml, "old_pod_nm");
		formObj.rhnd_vvd_new_pod.value=ComGetEtcData(sXml, "new_pod");
		formObj.rhnd_vvd_new_pod_nm.value=ComGetEtcData(sXml, "new_pod_nm");
	}
	/*
	* in case of calling T/S Route, input Sheet
	*/
	function RouteToSheet(sheetObj,prefix){
		if (ComIsEmpty(sheetObj.GetCellValue(1,prefix+"vsl_pre_pst_cd"))){
			return;
		}
		sheetObjects[7].RemoveAll();
//		sheetObjects[7].LastRow(sheetObj.LastRow());
		for(var iRow=1; iRow < sheetObj.LastRow()+1; iRow++){
			with(sheetObjects[7]){		
				DataInsert(-1);
				SetCellValue(iRow,"vsl_pre_pst_cd",sheetObj.GetCellValue(iRow,prefix+"vsl_pre_pst_cd"),0);
				SetCellValue(iRow,"vsl_seq",sheetObj.GetCellValue(iRow,prefix+"vsl_seq"),0);
				SetCellValue(iRow,"pol_cd",sheetObj.GetCellValue(iRow,prefix+"pol_yd_cd").substring(0,5),0);
				if (!ComIsEmpty(sheetObj.GetCellValue(iRow,prefix+"pol_yd_cd"))){
					SetCellValue(iRow,"pol_yd_cd",sheetObj.GetCellValue(iRow,prefix+"pol_yd_cd").substring(5,8),0);
				}
				SetCellValue(iRow,"pod_cd",sheetObj.GetCellValue(iRow,prefix+"pod_yd_cd").substring(0,5),0);
				if (!ComIsEmpty(sheetObj.GetCellValue(iRow,prefix+"pod_yd_cd"))){
					SetCellValue(iRow,"pod_yd_cd",sheetObj.GetCellValue(iRow,prefix+"pod_yd_cd").substring(5,8),0);
				}
				SetCellValue(iRow,"bkg_vvd_cd",sheetObj.GetCellValue(iRow,prefix+"vsl_cd")+sheetObj.GetCellValue(iRow,prefix+"skd_voy_no")+sheetObj.GetCellValue(iRow,prefix+"skd_dir_cd"),0);
				SetCellValue(iRow,"pol_clpt_ind_seq",sheetObj.GetCellValue(iRow,prefix+"pol_clpt_ind_seq"),0);
				SetCellValue(iRow,"pod_clpt_ind_seq",sheetObj.GetCellValue(iRow,prefix+"pod_clpt_ind_seq"),0);
			}
		}
	}
	
	function sheet2_OnClick(sheetObj,row, col, Value, CellX, CellY, CellW, CellH){
		var col_name=sheetObj.ColSaveName(col);
		var formObj=document.form; 
		ComSetObjValue(formObj.bkg_por_cd,   sheetObj.GetCellValue(row,prefix2+"por_cd"));
		ComSetObjValue(formObj.bkg_por_yd_cd,sheetObj.GetCellValue(row,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.bkg_pol_cd,   sheetObj.GetCellValue(row,prefix2+"pol_cd"));
		ComSetObjValue(formObj.bkg_pol_yd_cd,sheetObj.GetCellValue(row,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.bkg_pod_cd,   sheetObj.GetCellValue(row,prefix2+"pod_cd"));
		ComSetObjValue(formObj.bkg_pod_yd_cd,sheetObj.GetCellValue(row,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.bkg_del_cd,   sheetObj.GetCellValue(row,prefix2+"del_cd"));
		ComSetObjValue(formObj.bkg_del_yd_cd,sheetObj.GetCellValue(row,prefix2+"del_nod_cd"));
		var param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
		param+="&bkgTrunkVvd="+sheetObjects[1].GetCellValue(2,prefix2+"tvvd");
			param+="&ca_flg=";
			param+="&pgmNo=ESM_BKG_0092";
		if(row==1){
			param+="&displayOnly=Y";
			RouteToSheet(sheetObjects[5],prefix6);
		}else{
			if(!ComIsNull(formObj.codStsCd)){
				param+="&displayOnly=Y";				
			}
			RouteToSheet(sheetObjects[6],prefix7);
			formObj.routeRow.value=sheetObjects[6].LastRow();
		}
		param+="&callSheetIdx=7";
		switch(col_name) {		
			case prefix2+"detail":
				ComOpenPopup("/opuscntr/ESM_BKG_0092.do"+param, 700, 490, 'callBack0092','0,1', true);
			break;
		}  
	}
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		with(sheetObj){
			pcBtnColor("RED");
			if (ColSaveName(Col)==prefix2+"pod_cd"){
				sheetObjects[1].SetCellValue(2,prefix2+"pod_nod_cd","",0);
			}
			if (ColSaveName(Col)==prefix2+"del_cd"){
				sheetObjects[1].SetCellValue(2,prefix2+"del_nod_cd","",0);
			}
			if (ColSaveName(Col)==prefix2+"pod_cd" ||ColSaveName(Col)==prefix2+"pod_nod_cd"){
				sheetObjects[6].SetCellValue(sheetObjects[6].LastRow(),prefix7+"pod_yd_cd",ComRpad(GetCellValue(Row,prefix2+"pod_cd"),5," ")+GetCellValue(Row,prefix2+"pod_nod_cd"));
			}
			if (ColSaveName(Col)==prefix2+"tvvd"){
				if(Value==null||Value.length==0){
					for(var i=0;i<sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount();i++){
						if(sheetObjects[6].GetCellValue(i, prefix7+"vsl_pre_pst_cd")=="T"){
							sheetObjects[6].SetCellValue(i, prefix7+"vsl_cd","");
							sheetObjects[6].SetCellValue(i, prefix7+"skd_voy_no","");
							sheetObjects[6].SetCellValue(i, prefix7+"skd_dir_cd","");
							sheetObjects[6].SetCellValue(i, prefix7+"slan_cd","");
						}						
					}
				} else {
					for(var i=0;i<sheetObjects[6].HeaderRows()+sheetObjects[6].RowCount();i++){
						if(sheetObjects[6].GetCellValue(i, prefix7+"vsl_pre_pst_cd")=="T"){
							sheetObjects[6].SetCellValue(i, prefix7+"vsl_cd",Value.substring(0,4));
							sheetObjects[6].SetCellValue(i, prefix7+"skd_voy_no",Value.substring(4,8));
							sheetObjects[6].SetCellValue(i, prefix7+"skd_dir_cd",Value.substring(8,9));
							sheetObjects[6].SetCellValue(i, prefix7+"slan_cd","");
						}						
					}
				}
			}
		}
	}	
	
	/*
	* calling ESM_BKG_0975 popup
	*/
	function sheet3_OnPopupClick(sheetObj, row, col){
		var col_name=sheetObj.ColSaveName(col);
		var formObj=document.form; 
		switch(col_name) {
			case prefix3+"chg_cd":
				var url="ESM_BKG_0975.do?isPop=Y&pgmNo=ESM_BKG_0975";
				url+="&chg_cd="+sheetObj.GetCellValue(row, prefix3+"chg_cd");
				ComOpenWindowCenter(url, "ESM_BKG_0975", 650, 630, false);
			break;
		} 		
	}
	/*
	* Reject Reason Combo Change
	*/
	function cod_rjct_cd_OnChange(comboObj, code, text){
		var formObj=document.form; 
		comboObj.SetSelectCode(ComGetObjValue(formObj.codRjctCd),false);
	}
	/*
	* groupware mail variables initialization
   	*/
	function groupMailClear(){
		var formObj=document.form;
		ComClearObject(formObj.gw_subject);
		ComClearObject(formObj.gw_contents); 
		var args=document.getElementsByName("gw_args");
		for(var i=0;i<args.length;i++){
			args[i].value="";
		}
	}
	/*
	 * groupware mail variables input
	 */
	function groupMailset(status){
		var formObj=document.form;
		var emlSubject="";
		var emlHeader="";
		var emlContent1="";
		var emlContent2="";
		var cntrNoList="";
		var emlSpclContent=""; 
		var emlBody="";
		if(status=="R"){
			emlSubject="COD Application";
			emlHeader="Please be advised that COD application has been received as followings:<BR>\n";
		} else if(status=="F"){
			emlSubject="COD Confirm Notice";
			emlHeader="Please be advised that below COD has been confirmed by Booking Office:<BR>\n";
		} else if(status=="C"){
			emlSubject="COD Cancel Notice";
			emlHeader="Please be advised that below COD application has been withdrawn:<BR>\n";
		}
		emlSubject=formObj.eml_header.value; 
		emlContent1="* Vessel : " + formObj.rhnd_vvd_nm.value + "<BR>\n" +
					 "* Voyage : " + formObj.rhnd_vvd_voyage.value + "<BR>\n" +
					 "* BKG No : " + formObj.bkg_no.value + "<BR>\n" +
					 "* Container No. :\n"
        var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
		var checkRow=sRow.split("|");
		cntrNoList="<table border=1><tr align=center>" + 
					 "<td width=120>Container No.</td>" +
					 "<td width=60>TPSZ</TD>" +
					 "<td width=100>Weight</TD>" +
					 "<td width=40>DG</TD>" +
					 "<td width=40>RF</TD>" +
					 "<td width=40>AK</TD>" +
					 "<td width=40>BB</TD>" +
					 "<td width=40>SOC</TD></TR>\n";
		for(var i=0;i<checkRow.length;i++){
			cntrNoList=cntrNoList + 
					"<tr align=center>" +
					"<td>"+  sheetObjects[0].GetCellValue(checkRow[i],prefix1+"cntr_no")     +"</td>" +
					"<td>"+  sheetObjects[0].GetCellValue(checkRow[i],prefix1+"cntr_tpsz_cd")+"</td>" +
					"<td>"+  sheetObjects[0].GetCellValue(checkRow[i],prefix1+"cntr_wgt")    +"</td>" +
					"<td>"+((sheetObjects[0].GetCellValue(checkRow[i],prefix1+"dcgo_flg")==0)?"N":"Y")+"</td>" +
					"<td>"+((sheetObjects[0].GetCellValue(checkRow[i],prefix1+"rc_flg")  ==0)?"N":"Y")+"</td>" +
					"<td>"+"N"+"</td>" +
					"<td>"+"N"+"</td>" +
					"<td>"+((sheetObjects[0].GetCellValue(checkRow[i],prefix1+"soc_flg") ==0)?"N":"Y")+"</td>" +
					"</tr>\n";
		}
		cntrNoList=cntrNoList + "</table>\n";
		emlContent2="* Port of Loading on VVD : " + formObj.rhnd_vvd_old_pol.value.substring(0,5) + "(" + formObj.rhnd_vvd_old_pol_nm.value + ")" + "<BR>\n" + 
					  "* OLD Port of Discharging on VVD : " + formObj.rhnd_vvd_old_pod.value.substring(0,5) + "(" + formObj.rhnd_vvd_old_pod_nm.value + ")" + "<BR>\n" +
					  "* NEW Port of Discharging on VVD : " + formObj.rhnd_vvd_new_pod.value.substring(0,5) + "(" + formObj.rhnd_vvd_new_pod_nm.value + ")" + "<BR>\n";
		var dgEmlCtnt="";
		var rfEmlCtnt="";
		for(var i=0;i<checkRow.length-1;i++){
			if(sheetObjects[0].GetCellValue(checkRow[i], prefix1+"dcgo_flg")=="1"){
			dgEmlCtnt=dgEmlCtnt + sheetObjects[0].GetCellValue(checkRow[i], prefix1+"dg_eml_ctnt");
			}
			if(sheetObjects[0].GetCellValue(checkRow[i], prefix1+"rc_flg")=="1"){
			rfEmlCtnt=rfEmlCtnt + sheetObjects[0].GetCellValue(checkRow[i], prefix1+"rf_eml_ctnt");
			}
		}
		if(dgEmlCtnt!=null && dgEmlCtnt.length>10){
			emlSpclContent=emlSpclContent + 
					   "----------------------------------------------------------------------------------------------" +"\n"+ 
					   "<BR>" +"\n"+
					   "[ Dangerous Cargo ]<BR>" + dgEmlCtnt + "<BR>\n";
		}
		if(rfEmlCtnt!=null && rfEmlCtnt.length>10){
			emlSpclContent=emlSpclContent + 
					   "----------------------------------------------------------------------------------------------" +"\n"+ 
					   "<BR>" +"\n"+
					   "[ Reefer Cargo ]<BR>" +
					   "<table width=765 border=1>" +
					   "<TR><td width=120>Container No</TD><td width=400>Commodity</TD><td width=120>Temperature</TD><TD width=120>Ventilation</TD><TR>" + 
					   rfEmlCtnt + "\n"
					   "</table><BR>\n";
		}
		emlBody=emlHeader + "<BR>" + 
					emlContent1 + "<BR>" + 
					cntrNoList + "<BR>" + 
					emlContent2 + "<BR>";
		if(emlSpclContent.length>0){
			emlBody=emlBody + "<BR>" + 
					"[ Special Cargo Information ]" + "<BR>\n" +
					emlSpclContent + "<BR>";
		}
//		alert(emlSubject+"\n\n"+emlBody);
//  		ComBkgGroupMailset(sheetObjects[0], formObj, emlSubject, emlBody);
   }
   /*
   * CntroNo,SpcCarGo parameter creating function
   */
   function setCntrSpc(){
	   var sCntr="";
	   var sDg="";
	   var sBb="";
	   var sAk="";
	   var sRf="";
	   var rtn="";
	   with(sheetObjects[0]){
		   for(var i=1;i<HeaderRows()+RowCount();i++){
				if (GetCellValue(i,prefix1+"chk")==1){
					sCntr+=GetCellValue(i,prefix1+"cntr_no")+"~";
					if (GetCellValue(i,prefix1+"dcgo_flg")==1){
						sDg+=GetCellValue(i,prefix1+"cntr_no")+"~";
					}
					if (GetCellValue(i,prefix1+"bb_cgo_flg")==1){
						sBb+=GetCellValue(i,prefix1+"cntr_no")+"~";
					}
					if (GetCellValue(i,prefix1+"awk_cgo_flg")==1){
						sAk+=GetCellValue(i,prefix1+"cntr_no")+"~";
					} 
					if (GetCellValue(i,prefix1+"rc_flg")==1){
						sRf+=GetCellValue(i,prefix1+"cntr_no")+"~";
					}  
			    }
		   }
	   }
	   rtn="&codCntrNo="+sCntr+"&codDg="+sDg+"&codBb="+sBb+"&codAk="+sAk+"&codRF="+sRf;
	   return rtn;
   }
//   	function btnColor(){ 
//	   if (!ComIsEmpty(document.form.codRemark)){
//		   ComBtnColor("btn_remark","blue");
//	   }else{
//		   ComBtnColor("btn_remark","#737373");	
//	   }
//	   
//   	}
	function pcBtnColor(color){
		var formObj=document.form;
		if(color=="RED"){
			ComBtnColor("btn_pc","red");
			ComSetObjValue(formObj.pctl_no,"");
			ComSetObjValue(formObj.map_seq,"");			
		} else {
			ComBtnColor("btn_pc","#737373");
		}
	}
	/*
	* Conditions enable the button
	*/
    function btnEnable(formObj){
		//disable
		// cod remark, retrieve, new, history, add
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_request");
		ComBtnDisable("btn_approve");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_pc");
		ComBtnDisable("btn_main");
		ComBtnDisable("btn_bkg_main");	
		ComBtnDisable("btn_calculation");
		if (ComGetObjValue(formObj.saveModeCd) =="U"){
			ComBtnEnable("btn_calculation");
		}
		if (ComIsNull(formObj.codStsCd)){
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_del");		
			ComBtnEnable("btn_pc");
			if (ComGetObjValue(formObj.saveModeCd) =="U"){
				ComBtnEnable("btn_request");
			}
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="M"){//Manual
			if(ComGetObjValue(formObj.cod_mnl_flg).toUpperCase()=="Y"){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_approve");
				ComBtnEnable("btn_cancel");
				ComBtnEnable("btn_pc");
			}
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){//REQUEST
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_cancel");			
			ComBtnEnable("btn_pc");
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="Y"){//APPROVE
			ComBtnEnable("btn_cancel");
			ComBtnEnable("btn_confirm");
			//Have all been selected cntr, bdr bkg main disabled only when
        	var sRow=sheetObjects[0].FindCheckedRow(prefix1+"chk");
        	var checkRow=sRow.split("|");
        	if((checkRow.length)==(sheetObjects[0].RowCount())){
				if (formObj.bdr_flag.checked){ 
					ComBtnEnable("btn_bkg_main");	
				}
			}
		}
		else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="W"){//WAIT
			ComBtnEnable("btn_cancel");			
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){//CANCEL
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"){//REJECT
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){//FIRM
		}
		if(ComIsNull(ComTrim(ComGetObjValue(formObj.codStsCd)))){
			sheetObjects[1].SetEditable(1);
		} else {
			sheetObjects[1].SetEditable(0);
		}
	}	 
    /**
    * CA Reason  handling : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj=document.form;
   		//var srcName=ComGetEvent("name");
    	//01. get CA ReasonCd, Remark ,
    	var strRsnCd=nullToBlank(arrPopupData[0][2]);
    	var strRemark=nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value=strRsnCd;
        formObj.ca_remark.value=strRemark;		
        
        if(tmpCaMode=="S"){
        	if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
				doActionIBSheet(sheetObjects[0],formObj,COMMAND10);
			}
        }else if(tmpCaMode=="C"){
        	if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
	    		doActionIBSheet(sheetObjects[8],formObj,COMMAND07);
	    	}
        }
    }
	// After calling ESD_PRD_018 , Return value.(PCTL_NO)
	function callBackEsdPrd0080(pctlNo){
		var formObj=document.form;
		if(pctlNo.length<20){
			ComSetObjValue(formObj.pctl_no,"");
			ComSetObjValue(formObj.map_seq,"");
			pcBtnColor("RED");
		} else {
			var arrXml=pctlNo.split("|");
			ComSetObjValue(formObj.pctl_no,arrXml[0]);
			if(arrXml.length>1) ComSetObjValue(formObj.map_seq, arrXml[1]);// check again
			pcBtnColor("BLACK");
		}
		
		if(ComGetObjValue(formObj.pctl_no).length>=20){
			doActionIBSheet(sheetObjects[0],formObj,COMMAND09);
		}
	}    	
	/**
     * After Route Detail handling  <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0092();
     * </pre>
     * @param 
     */
    function callBack0092(){    
    	var formObj=document.form;
		var sheetObj=sheetObjects[7];
		if(sheetObj.RowCount()==0){
			sheetObjects[1].SetCellValue(2,prefix2+"pre_cd","",0);
    		sheetObjects[1].SetCellValue(2,prefix2+"pre_nod_cd","",0);
    		sheetObjects[1].SetCellValue(2,prefix2+"pst_cd","",0);
    		sheetObjects[1].SetCellValue(2,prefix2+"pst_nod_cd","",0);
			sheetObjects[6].RemoveAll();
    		sheetObjects[6].DataInsert(0);
    		sheetObjects[6].SetCellValue(1,prefix7+"vsl_pre_pst_cd","T",0);
    		sheetObjects[6].SetCellValue(1,prefix7+"vsl_seq","1",0);
			sheetObjects[6].SetCellValue(1,prefix7+"pol_yd_cd",sheetObjects[1].GetCellValue(2,prefix2+"pol_cd") + sheetObjects[1].GetCellValue(2,prefix2+"pol_nod_cd"),0);
			sheetObjects[6].SetCellValue(1,prefix7+"pod_yd_cd",sheetObjects[1].GetCellValue(2,prefix2+"pod_cd") + sheetObjects[1].GetCellValue(2,prefix2+"pod_nod_cd"),0);
			sheetObjects[6].SetCellValue(1,prefix7+"vsl_cd",sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(0,4),0);
			sheetObjects[6].SetCellValue(1,prefix7+"skd_voy_no",sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(4,8),0);
			sheetObjects[6].SetCellValue(1,prefix7+"skd_dir_cd",sheetObjects[1].GetCellValue(2,prefix2+"tvvd").substring(8),0);
			return;
		}
		for(var iRow=1;iRow<sheetObj.HeaderRows()+sheetObj.RowCount();iRow++){ 
			if(ComTrim(sheetObj.GetCellValue(iRow,"pol_cd")).length!=5||ComTrim(sheetObj.GetCellValue(iRow,"pod_cd")).length!=5){
				sheetObj.RowDelete(iRow,false);
			}
		}
		// 01. PrePostCd = 'T' :input Vvd to Main
		sheetObjects[1].SetCellValue(2,prefix2+"tvvd",sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd"),0);
		// 01-01. PRE RELAY input
		if(sheetObj.RowCount()>0){
	    	if(sheetObj.FindText("vsl_pre_pst_cd","T") > 1){
			sheetObjects[1].SetCellValue(2,prefix2+"pre_cd",sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_cd"),0);
			sheetObjects[1].SetCellValue(2,prefix2+"pre_nod_cd",sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_yd_cd"),0);
	    	}
		}
		
		// 01-02. POST REPAY input
		if(sheetObj.FindText("vsl_pre_pst_cd","T")>0){
			if(sheetObj.FindText("vsl_pre_pst_cd","T") < sheetObj.LastRow()){
				sheetObjects[1].SetCellValue(2,prefix2+"pst_cd",sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd"),0);
				sheetObjects[1].SetCellValue(2,prefix2+"pst_nod_cd",sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd"),0);
			} else {	
				sheetObjects[1].SetCellValue(2,prefix2+"pst_cd","",0);
				sheetObjects[1].SetCellValue(2,prefix2+"pst_nod_cd","",0);
			}
    	} else {
			sheetObjects[1].SetCellValue(2,prefix2+"pst_cd","",0);
			sheetObjects[1].SetCellValue(2,prefix2+"pst_nod_cd","",0);
    	}
		if (ComGetObjValue(formObj.bkg_pod_cd)!=sheetObj.GetCellValue(sheetObj.RowCount(),"pod_cd")
			|| ComGetObjValue(formObj.bkg_pod_yd_cd)!=sheetObj.GetCellValue(sheetObj.RowCount(),"pod_yd_cd")
			|| ComParseInt(formObj.routeRow.value)!=sheetObj.LastRow()){
		} 
    	// 02. input last data's POD
		sheetObjects[1].SetCellValue(2,prefix2+"pod_cd",sheetObj.GetCellValue(sheetObj.RowCount(),"pod_cd"),0);
		sheetObjects[1].SetCellValue(2,prefix2+"pod_nod_cd",sheetObj.GetCellValue(sheetObj.RowCount(),"pod_yd_cd"),0);
		//sheetObjects[6].LastRow(sheetObj.LastRow());
		sheetObjects[6].RemoveAll();
		for(var iRow=1;iRow<sheetObj.HeaderRows()+sheetObj.RowCount();iRow++){
			sheetObjects[6].DataInsert(-1);
			sheetObjects[6].SetCellValue(iRow,prefix7+"vsl_pre_pst_cd",sheetObj.GetCellValue(iRow,"vsl_pre_pst_cd"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"vsl_seq",sheetObj.GetCellValue(iRow,"vsl_seq"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"pol_yd_cd",sheetObj.GetCellValue(iRow,"pol_cd")+sheetObj.GetCellValue(iRow,"pol_yd_cd"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"pod_yd_cd",sheetObj.GetCellValue(iRow,"pod_cd")+sheetObj.GetCellValue(iRow,"pod_yd_cd"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"pol_clpt_ind_seq",sheetObj.GetCellValue(iRow,"pol_clpt_ind_seq"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"pod_clpt_ind_seq",sheetObj.GetCellValue(iRow,"pod_clpt_ind_seq"),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"vsl_cd",sheetObj.GetCellValue(iRow,"bkg_vvd_cd").substring(0,4),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"skd_voy_no",sheetObj.GetCellValue(iRow,"bkg_vvd_cd").substring(4,8),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"skd_dir_cd",sheetObj.GetCellValue(iRow,"bkg_vvd_cd").substring(8),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"bkg_no",ComGetObjValue(formObj.oldBkgNo),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
			sheetObjects[6].SetCellValue(iRow,prefix7+"vvd_op_cd","N",0);
		}
				 
    }       
    
	function callBackCaCancel(){
		//message handling
	}
	function callBackCaConfirm(){
		doActionIBSheet(sheetObjects[8],document.form,COMMAND06);	
	}
   	function callSearch(){    	 
		doActionIBSheet(sheetObjects[8],document.form,COMMAND06);	
   	}
   	
//   	function sheet1_OnSearchEnd(sheetObj, errMsg) {
//   		var formObj = document.form;
//   		if(sheetObjects[1].HeaderRows()+sheetObjects[1].RowCount()<2){
//			sheetObjects[1].DataInsert();
//			sheetObjects[1].DataInsert();
//		}
//		
//		sheetObjects[1].SetCellEditable(1,prefix2+"pod_cd",0);
//		sheetObjects[1].SetCellEditable(1,prefix2+"pod_nod_cd",0);
//		sheetObjects[1].SetCellEditable(1,prefix2+"del_cd",0);
//		sheetObjects[1].SetCellEditable(1,prefix2+"del_nod_cd",0);
//		sheetObjects[1].SetCellEditable(1,prefix2+"de_term_cd",0);
//		sheetObjects[1].SetCellEditable(1,prefix2+"tvvd",0);
//		//sheetObjects[1].CellEditable(1,prefix2+"detail")=true;
//		//sheetObjects[1].CellEditable(2,prefix2+"detail")=true;
//		sheetObjects[1].SetCellValue(1,prefix2+"bkgroute","OLD",0);
//		sheetObjects[1].SetCellValue(2,prefix2+"bkgroute","NEW",0);
//		sheetObjects[1].SetCellValue(1,prefix2+"detail",0,0);
//		sheetObjects[1].SetCellValue(2,prefix2+"detail",0,0);
//		//sheetObjects[1].CellBackColor(1,prefix2+"detail") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
//		//sheetObjects[1].CellBackColor(2,prefix2+"detail") = sheetObjects[1].CellBackColor(2,prefix2+"bkgroute");
//		sheetObjects[1].SetCellBackColor(2,prefix2+"por_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(2,prefix2+"pol_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(2,prefix2+"pre_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(2,prefix2+"pst_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pod_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pol_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pol_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"del_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"del_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pre_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pre_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pst_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"pst_nod_cd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		sheetObjects[1].SetCellBackColor(1,prefix2+"tvvd",sheetObjects[1].GetCellBackColor(1,prefix2+"bkgroute"));
//		setFormData(formObj,sheetObj);
//		if (ComIsNull(formObj.oldCodRqstSeq)){
//			ComSetObjValue(formObj.saveModeCd,"C");
//        }else{
//			ComSetObjValue(formObj.saveModeCd,"U");
//		}
//		if (ComGetObjValue(document.form.popFlg)!="S"){ 
//			btnEnable(formObj);
//		}
//		if(!ComIsNull(formObj.codRjctRsnRmk)){
//			ComBtnColor("btn_reject","blue");	
//		} else {
//			ComBtnColor("btn_reject","#737373");					
//		}
//		//Old Route
//		if (sheetObjects[5].GetTotalRows()==0){
//			//sheetObjects[5].LastRow(1);
//			sheetObjects[5].RemoveAll();
//			sheetObjects[5].DataInsert(-1);
//		}else{ 
//			for(var iRow=1;iRow<sheetObjects[5].RowCount();iRow++){
//				sheetObjects[5].SetCellValue(iRow, prefix6+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
//				sheetObjects[5].SetCellValue(iRow, prefix6+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
//				sheetObjects[5].SetCellValue(iRow, prefix6+"vvd_op_cd","O",0);
//			}
//		}
//		//New Route
//		if (sheetObjects[6].GetTotalRows()==0 && sheetObjects[5].GetTotalRows()!=0){
//			sheetObjects[6].RemoveAll();
//            //sheetObjects[5].Copy2SheetCol(sheetObjects[6],"","",-1,-1,-1,1,false,false); // check again 사라진건가
//			for(iRow=sheetObjects[5].HeaderRows();iRow<sheetObjects[5].HeaderRows()+sheetObjects[5].RowCount();iRow++){
//				sheetObjects[6].DataInsert(-1);
//				for(iCol=0;iCol<sheetObjects[5].LastCol()+1;iCol++){
//					sheetObjects[6].SetCellValue(iRow,iCol,sheetObjects[5].GetCellValue(iRow,iCol));
//				}
//			}
//            for(var iRow=1;iRow<sheetObjects[6].RowCount();iRow++){
//				sheetObjects[6].SetCellValue(iRow, prefix7+"vvd_op_cd","N",0);
//			}
//		}
//		else if (sheetObjects[6].GetTotalRows()==0){
//			//sheetObjects[6].LastRow(1);
//			sheetObjects[6].RemoveAll();
//			sheetObjects[6].DataInsert(-1);
//		}else{ 
//			for(var iRow=1;iRow<sheetObjects[6].RowCount();iRow++){
//				sheetObjects[6].SetCellValue(iRow, prefix7+"bkg_no",ComGetObjValue(formObj.bkg_no),0);
//				sheetObjects[6].SetCellValue(iRow, prefix7+"cod_rqst_seq",ComGetObjValue(formObj.cod_rqst_seq),0);
//				sheetObjects[6].SetCellValue(iRow, prefix7+"vvd_op_cd","N",0);
//			}
//		}
//		if (!ComIsEmpty(formObj.codRemark)){  
//			ComBtnColor("btn_remark","blue");
//		} else {
//			ComBtnColor("btn_remark","#737373");					
//		}
//   	}