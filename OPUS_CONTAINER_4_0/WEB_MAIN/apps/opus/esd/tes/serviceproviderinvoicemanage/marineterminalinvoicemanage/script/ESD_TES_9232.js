/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9232.js
*@FileTitle  : TES 3rd Party Billing Input Popup - Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var doneDefN3ptyBilCSCD=false;
	var	comboNm;
	var	comboVal;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name
	 *  using extra sheet valuable if there are more 2 sheets
	 */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_ok":
					//try {
						var temp_amt=0;
						var iCheckRow=sheetObject.FindCheckedRow('chk');
						if (iCheckRow != null && iCheckRow != ''){
							var arrRow=iCheckRow.split("|");
							for (var idx=0; idx<arrRow.length; idx++){ 
								temp_amt += parseFloat(sheetObject.GetCellValue(arrRow[idx],'if_amt'));
							}
							//alert(temp_amt + '  /  ' + parseFloat(document.form.inv_amt.value));
							if (Math.floor(temp_amt * Math.pow(10, 2)) / Math.pow(10, 2) > parseFloat(document.form.inv_amt.value)) {
								ComShowMessage('Total amount to interface should be less than or equal to '+parseFloat(document.form.inv_amt.value));
								return false;
							}
						}
					//} catch (e){ 
					//}
    	            if (checkMandatory(sheetObject)) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						ComClosePopup(); 
         	        }
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
     * @param {ibsheet}	sheet_obj	sheet object
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
        if(document.form.lgs_cost_cd.value == '' || document.form.lgs_cost_cd.value == null){
            ComShowMessage('Select COST CODE first.\n\nThis window will be closed!');
            ComClosePopup(); 
            return false;
        }
        tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
//        var sheetObject = sheetObjects[0];
//        var formObj = document.form;
//        for(i=0;i<sheetObjects.length;i++){
//            ComConfigSheet(sheetObjects[i]);
//            initSheet(sheetObjects[i],i+1);
//            ComEndConfigSheet(sheetObjects[i]);
//        }
//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//        setTimeout("doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);",500);
    }
    /** setDefN3ptyBilCSCD
     *  set 'n3pty_bil_tp_cd' default value
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
     * @param {ibsheet}	sheet_obj	sheet object
     * @param {int}		sheetNo		sheet number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
                 
		               var HeadTitle="H_SEQ|STS|Seq||lgs_cost_cd|Container No.|TP|Billing Case|Curr.|Amount|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|Remarks|tml_if_ofc_cd|tml_if_seq|" +
		               "io_bnd|inv_no|vndr_seq|yd_cd|curr_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"page_rows",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
		                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		               
		               if(document.form.lgs_cost_cd.value == "SVXXJO") {
		            	   cols.push({Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               } else {
		            	   cols.push({Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               }
		               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               
		               if (tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)) {
		            	   cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               } else {
		            	   cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
		               }
		               cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               cols.push({Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pop_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_vndr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"if_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               //cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               cols.push({Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_lgs_cost_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_ins_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_cost_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_rvis_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		               
		               
		               if(document.form.lgs_cost_cd.value != '' && document.form.lgs_cost_cd.value == 'SVXXJO'){
		            	   InitDataCombo (0, "vndr_cust_div_cd", 'S/P', 'V',"S/P","V");
		               }else{
		            	   InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code,"Customer","C");
		               }
		          
		               InitColumns(cols);
		               SetEditable(1);
		               SetColProperty("vndr_cust_div_cd", {ComboText:'S/P', ComboCode:'V'} );
		               SetColProperty("vndr_cust_div_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
		               InitComboNoMatchText(true);
		               SetColProperty("n3pty_bil_tp_cd", {ComboText:comboNm, ComboCode:comboVal} );
		               resizeSheet();//SetSheetHeight(240);
               }
            break;
        }
    }
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
/**
* set Billing Case Code
* @return
*/
function setTpbBillcaseCode(){
//	 tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
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
* Billing Case get combo list
* @return
*/
function getList(){
	
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
    /** handling sheet process
     *  @param {ibsheet}	sheet_obj	sheet object
     *  @param {form}		formObj		form object
     *  @param {int}		sAction		form Action value
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction){
			case IBSEARCH:
                if(formObj.calc_tp_cd.value == 'A'){
                    formObj.f_cmd.value=SEARCH01;
                }else if(formObj.calc_tp_cd.value == 'M' || formObj.calc_tp_cd.value == 'S'){
                    formObj.f_cmd.value=SEARCH02;
                }
                var searchXml=sheetObj.GetSearchData("ESD_TES_9232GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
                break;
            case IBSAVE:
                formObj.f_cmd.value=MODIFY;
                var param=sheetObj.GetSaveString(false, true, 'chk');
				//alert(param);return false;
                var saveXml=sheetObj.GetSaveData("ESD_TES_9232GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveData(saveXml,true);
                break;
        }
    }
    /**  
     * 	popup click event
     * 
     * @param {ibsheet}	sheet_obj	sheet object     
     * @param {int}	Row	sheet 	셀의 row index  
     * @param {int}	Col	sheet 	셀의 col index 
     * @return
     */
    function sheet_OnPopupClick(sheetObj,Row,Col){
    	tes_get3rdParty_sheet( sheetObj.GetCellValue(Row,"vndr_cust_div_cd"), Row, Col );
    }
    /** sheet object
     * 
     * @param {ibsheet}	sheet_obj	sheet object     
     * @param {int}	Row	sheet 	row index  
     * @param {int}	Col	sheet 	col index 
     * @return
     */
	function sheet_OnChange(sheetObj,Row,Col,value){
		if (sheetObj.RowCount()> 0) {
			if (sheetObj.ColSaveName(Col) == "pop_value"){
				if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='C'){
					sheetObj.SetCellValue(Row,"cust_seq"			,sheetObj.GetCellValue(Row,"pop_value").substring(2,8));
					sheetObj.SetCellValue(Row,"cust_cnt_cd"		,sheetObj.GetCellValue(Row,"pop_value").substring(0,2));
				}else if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='S'){
					sheetObj.SetCellValue(Row,"n3pty_ofc_cd"		,sheetObj.GetCellValue(Row,"pop_value"));
				  //sheetObj.CellValue(Row,"n3pty_ofc_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
				}else if(sheetObj.GetCellValue(Row,"vndr_cust_div_cd")=='V'){
					sheetObj.SetCellValue(Row,"n3pty_vndr_seq"	,sheetObj.GetCellValue(Row,"pop_value").substring(2,8));
					sheetObj.SetCellValue(Row,"vndr_cnt_cd"		,sheetObj.GetCellValue(Row,"pop_value").substring(0,2));
				}			
			}else if(sheetObj.ColSaveName(Col) == "if_amt" && sheetObj.GetCellValue(Row,"if_amt")<=0){
				sheetObj.SetCellValue(Row,"if_amt",document.form.ctrt_rt.value);
				ComShowMessage("Minus amount is not allowed to 3rd Party.\n(I/F Amount shoule be bigger than 0)");
			}
			if (sheetObj.ColSaveName(Col)=="chk" || sheetObj.ColSaveName(Col)=="n3pty_bil_tp_cd" ||
				sheetObj.ColSaveName(Col)=="if_amt" || sheetObj.ColSaveName(Col)=="pop_value" || sheetObj.ColSaveName(Col)=="if_rmk" ||
				sheetObj.ColSaveName(Col)=="cust_seq" || sheetObj.ColSaveName(Col)=="cust_cnt_cd" || sheetObj.ColSaveName(Col)=="n3pty_ofc_cd" ||
				sheetObj.ColSaveName(Col)=="n3pty_vndr_seq" || sheetObj.ColSaveName(Col)=="vndr_cnt_cd") {
				if (sheetObj.CellSearchValue(Row,'chk')!=sheetObj.GetCellValue(Row,'chk')) {
					if (sheetObj.GetCellValue(Row,'chk')=='1'){
						if (sheetObj.GetCellValue(Row,'tml_if_ofc_cd')==null || sheetObj.GetCellValue(Row,'tml_if_ofc_cd')=='') {
//							sheetObj.CellValue(Row,'ibflag') = "I";
							sheetObj.SetRowStatus(Row,"I");
						} else {
//							sheetObj.CellValue(Row,'ibflag') = "U";
							sheetObj.SetRowStatus(Row,"U");
						}
					}
				}
			}
		}
	}
	/** 
	 * search end event
	 * @param {ibsheet} sheetObj    sheet object
	 * @return
	 */
    function sheet_OnSearchEnd(sheetObj){//alert("start sheet_OnSearchEnd");

    	var opener=window.dialogArguments;
		
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;         // 기존 가이드 부분
		
        var openerObj=opener.n3rd_hidden;
        var rvis_hidden=opener.rvis_hidden;
        var dtl_hidden=opener.document.t3sheet1;
        
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var lgs_cost_cd_row;
        var cntr_no_row;
        var cntr_tpsz_cd_row;
        var bil_tp_cd_row;

        if(formObj.lgs_cost_cd.value == 'SVXXJO' && (formObj.tml_crr_cd.value=='' || formObj.tml_crr_cd.value==null)){
            ComShowMessage('SVXXJO need Carrier Code. Select Carrier Code first.\n\nThis window will be closed!');
            ComClosePopup(); 
            return false;
        }

        if (formObj.calc_tp_cd.value == 'M' && formObj.lgs_cost_cd.value == "SVXXJO"){
			if (sheetObj.RowCount()< 1){
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,"lgs_cost_cd"          ,'SVXXJO');
				sheetObj.SetCellValue(Row,"cntr_no"              ,'SVXXJO00000');
				sheetObj.SetCellValue(Row,"cntr_tpsz_cd"         ,formObj.cntr_tpsz_cd.value);
				sheetObj.SetCellValue(Row,"curr_cd"              ,formObj.curr_cd.value);
				sheetObj.SetCellValue(Row,"vndr_seq"      	      ,formObj.vndr_seq.value);
				sheetObj.SetCellValue(Row,"yd_cd"	              ,formObj.yd_cd.value);
				sheetObj.SetCellValue(Row,"err_inv_no"	          ,formObj.err_inv_no.value);
				sheetObj.SetCellValue(Row,"if_amt"				  ,formObj.inv_amt.value);
				sheetObj.SetCellValue(Row,"n3pty_bil_tp_cd"      ,'JO');
			}
			
        } else {
        	if(sheetObj.RowCount()< 1){
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,"lgs_cost_cd"          ,formObj.lgs_cost_cd.value);
				sheetObj.SetCellValue(Row,"cntr_no"              ,formObj.lgs_cost_cd.value+'00000');
				sheetObj.SetCellValue(Row,"cntr_tpsz_cd"         ,formObj.cntr_tpsz_cd.value);
				sheetObj.SetCellValue(Row,"curr_cd"               ,formObj.curr_cd.value);
				sheetObj.SetCellValue(Row,"vndr_seq"      	      ,formObj.vndr_seq.value);
				sheetObj.SetCellValue(Row,"yd_cd"	              ,formObj.yd_cd.value);
				sheetObj.SetCellValue(Row,"err_inv_no"	          ,formObj.err_inv_no.value);
				sheetObj.SetCellValue(Row,"if_amt"				  ,formObj.inv_amt.value);
				
				sheetObj.SetCellValue(Row,"inv_no"	          ,formObj.inv_no.value);
				sheetObj.SetCellValue(Row,"rvis_lgs_cost_cd"     ,formObj.lgs_cost_cd.value); //20150526 rvis 넣어주기 위해 추가
				sheetObj.SetCellValue(Row,"rvis_ins_flg"			  ,"Y"); 
				
     	        sheetObj.SetCellValue(Row, "rvis_vsl_cd",formObj.vvd.value.substring(0,4));
     	        sheetObj.SetCellValue(Row, "rvis_skd_voy_no",formObj.vvd.value.substring(4,8));
     	        sheetObj.SetCellValue(Row, "rvis_skd_dir_cd",formObj.vvd.value.substring(8,9));
     	        sheetObj.SetCellValue(Row,"rvis_cntr_no",formObj.lgs_cost_cd.value+'00000');
     	        sheetObj.SetCellValue(Row, "rvis_cntr_tpsz_cd",formObj.cntr_tpsz_cd.value);
     	        
     	        sheetObj.SetCellValue(Row, "rvis_tml_inv_tp_cd",'TM');
     	        sheetObj.SetCellValue(Row, "rvis_calc_cost_grp_cd",'TM');
     	        sheetObj.SetCellValue(Row, "rvis_tml_rvis_tp_cd",'V');
     	        sheetObj.SetCellValue(Row, "rvis_calc_tp_cd",'M');
     	        
			}else{
				var org_sts='';
				var ctrt_rt=document.form.ctrt_rt.value!=null&&!isNaN(parseFloat(document.form.ctrt_rt.value))?parseFloat(document.form.ctrt_rt.value):0;
				var inv_xch_rt=document.form.inv_xch_rt.value!=null&&!isNaN(parseFloat(document.form.inv_xch_rt.value))?parseFloat(document.form.inv_xch_rt.value):0;
				var inv_amt=document.form.inv_amt.value!=null&&!isNaN(parseFloat(document.form.inv_amt.value))?parseFloat(document.form.inv_amt.value):0;
				var rvis_vol_qty=document.form.rvis_vol_qty.value!=null&&!isNaN(parseInt(document.form.rvis_vol_qty.value))?parseInt(document.form.rvis_vol_qty.value):0;
				var tmp_amt=(ctrt_rt*inv_xch_rt)!=0?(ctrt_rt*inv_xch_rt):(inv_amt/rvis_vol_qty);
			        if(formObj.calc_tp_cd.value == 'M' || formObj.calc_tp_cd.value == 'S'){
			        	tmp_amt=inv_amt/rvis_vol_qty;
			        }
				//alert(ctrt_rt + '\n' + inv_xch_rt+ '\n inv_amt:'+ inv_amt + '\n rvis_vol_qty : '+ rvis_vol_qty + '\n (ctrt_rt*inv_xch_rt): ' + (ctrt_rt*inv_xch_rt) + '\n (inv_amt/rvis_vol_qty):' + (inv_amt/rvis_vol_qty) + '\n temp_Amt:' + tmp_amt);
				for (var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
					if (sheetObj.GetCellValue(i,'tml_if_ofc_cd')==null || sheetObj.GetCellValue(i,'tml_if_ofc_cd')==''){
						org_sts=sheetObj.GetRowStatus(i);
						sheetObj.SetCellValue(i,'if_amt',tmp_amt);
						sheetObj.SetRowStatus(i,org_sts);
					}
				}
			}
        	
		}
    }
    /** checkMandatory
     * 
     * @param {ibsheet}	sheet_obj	sheet object     
     * @return
     */
     function checkMandatory(sheetObject){//alert("start checkMandatory");
    	 
    	 var openerObj=window.dialogArguments;
 		
 		if (!openerObj) openerObj=window.opener;  //이 코드 추가할것
 		if (!openerObj) openerObj=parent;         // 기존 가이드 부분
 		
         //var openerObj=window.dialogArguments.document;
         var formObj=document.form;
         var iCheckRow='';
         var count=0;           
         var chkCNTR=0;         
         var billCase=0;        
         var result=false;
         var   changeCnt=0;
         var   delIfSeq="";
         var   delCntrSeq="";
         for( var i=sheetObject.HeaderRows(); i < sheetObject.HeaderRows()+ sheetObject.RowCount(); i++ ) {
        	 if ( sheetObject.CellSearchValue(i, "chk") != sheetObject.GetCellValue( i , "chk" ) ) {
        		 if ( sheetObject.GetCellValue( i , "chk" ) == '0' ) {
        			 delIfSeq    += sheetObject.GetCellValue(i, "tml_if_seq" ) + "|";
                     //delCntrSeq  += sheetObject.CellValue(i, "tml_so_dtl_seq" ) + "|"; 
                 }
                 changeCnt++;         	                         	                
             }
         }
         document.getElementById("del_if_seq").value=delIfSeq;
         //document.getElementById("del_cntr_seq").value  = delCntrSeq;
         iCheckRow=sheetObject.FindCheckedRow('chk');
 		if (iCheckRow == null || iCheckRow ==''){
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
             } else {
                 if (!confirm(ComGetMsg('TES40056'))){//Save할 data가 없습니다.
                     //openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
                	 ComClosePopup(); 
                     return false;
                 }
             }
         } else {
 			///* - JJ
 			for(var i=sheetObject.HeaderRows(); i< sheetObject.HeaderRows()+sheetObject.RowCount(); i++){
 				if(sheetObject.GetCellValue(i,'chk') == "1"){
 					if(sheetObject.GetCellValue(i,'cntr_no') != null){
                         chkCNTR=chkCNTR + 1;
                     }
//alert("n3pty_bil_tp_cd==>"+sheetObject.CellValue(i,'n3pty_bil_tp_cd'));
 					if(sheetObject.GetCellValue(i,'n3pty_bil_tp_cd') != '' || document.form.lgs_cost_cd.value == 'SVXXJO'){
                         billCase=billCase + 1;
                         if(document.form.lgs_cost_cd.value == 'SVXXJO'){
                        	 sheetObject.SetCellValue(i,'n3pty_bil_tp_cd',"JO",0);
                         }
//alert("n3pty_bil_tp_cd==>"+sheetObject.CellValue(i,'n3pty_bil_tp_cd'));                         
                     }
                     count=count + 1;
                 }
             }
 			if(count>0){
 				document.getElementById("flg_yn").value="Y";
 			}else{
 				document.getElementById("flg_yn").value="";
 			}
             if (count>chkCNTR || count>billCase){
                 ComShowMessage(ComGetMsg('TES21701'));
             } else if(count == chkCNTR && count == billCase) {
                openerObj.t3sheet1.SetCellValue(formObj.opener_row.value,"n3pty_flg","Y");
                openerObj.checkTPBdataEditable(openerObj.t3sheet1);
                 result=true;
             }//*/
 			var arrRow=iCheckRow.split("|");
 			for (var idx=0; arrRow!=null && idx<arrRow.length; idx++){ 
 				if (sheetObject.GetCellValue(arrRow[idx],'cntr_no')==null || sheetObject.GetCellValue(arrRow[idx],'cntr_no')=='' ||
 						((sheetObject.GetCellValue(arrRow[idx],'n3pty_bil_tp_cd')==null || sheetObject.GetCellValue(arrRow[idx],'n3pty_bil_tp_cd')=='') && document.form.lgs_cost_cd.value != 'SVXXJO' ) ||
// 					sheetObject.CellValue(arrRow[idx],'vndr_cust_div_cd')==null || sheetObject.CellValue(arrRow[idx],'vndr_cust_div_cd')=='') 
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
// 		openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "Y";
 		//window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);	
 		openerObj.checkTPBdataEditable(openerObj.t3sheet1);
         return true;
     }
