/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : GuaranteeCommon.js
*@FileTitle  : GuaranteeCommon 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/



	var sheetObjects=new Array();
	var sheetCnt=0;
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
//	/**
//	 * Make Common combo 
//	 * 
//	 * @param {string}		combo_val  	ComboBox Value
//	 * @param {int,string}	idx  		index
//	 * @param {string}		def_val  	Def Value
//	 **/
//	function tes_makeCombo(combo_val, idx, def_val){
//		var parentObj = eval("parent.comboObjects["+(idx-1)+"]");
//		if (parentObj!=null){
//			parentObj.RemoveAll(); 
//			parent.initCombo(parentObj, parseInt(idx,10), combo_val, def_val);
//		}
//	}
	/**
	 * TES Common Input Value
	 * 
	 * @param {ret_val}  	return value
	 **/
	function tes_setInputValueGurantee(ret_val){
		var formObj=document.form;
		var parentObj=eval("parent.document.all."+formObj.oid.value);
		if (parentObj != undefined && parentObj != null){
			parentObj.value=ret_val;
			if (formObj.functionName.value != undefined && formObj.functionName.value != null && formObj.functionName.value.trim() != ''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESGuaranteeCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}
	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * 
     * @param {sheet_obj}  	Sheet Object
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * setting sheet initial values and header
     * adding case as numbers of counting sheets
     * 
     * @param {sheetObj}  	Sheet Object
     * @param {sheetNo}  	Sheet Object 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:   //t1sheet1 init
                with(sheetObj){
	              var HeadTitle="";

	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };

	              var headers = [ { Text:HeadTitle, Align:"Center"} ];

	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	              InitColumns(cols);
	
	              SetEditable(1);
	              SetSheetHeight(100);

	              }
                break;
		}
	}
	/**
     * Sheet Action 
     * 
     * @param {sheetObj}  	Sheet Object
     * @param {formObj}  	Form Object
     * @param {sAction}  	Action Command
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {   	
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
        	    var sXml=sheetObj.GetSearchData("GuaranteeCommonGS.do", tesFrmQryStr(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );	
				var ret_val = ComGetEtcData(sXml, formObj.oid.value.trim());
				var tmp = '';
				if (formObj.tes_mode.value!=undefined && formObj.tes_mode.value.toUpperCase()=='COMBO'){
					var def_val=formObj.def.value;
					var idx=formObj.idx.value;
					var sheetObj=formObj.sheetObj.value;
					if (ret_val!=null){		
						tmp=ret_val.split('--');
					
						if ((tmp[0]!=undefined && tmp[0]!=null && tmp[0].trim()!='') && (def_val==undefined || def_val==null || def_val.trim()=='')){
							def_val=tmp[0];
						}
						if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
							ret_val=tmp[1];
						}
					}
					if ( formObj.f_cmd.value == SEARCH05 ) {
						tes_makeComboCntrBkg(ret_val, idx, def_val, sheetObj);
					}
					else {
						tes_makeComboGuarantee(ret_val, idx, def_val);
					}
				} else if (formObj.tes_mode.value!=undefined && formObj.tes_mode.value.toUpperCase()=='INPUT'){
					tes_setInputValueGurantee(ret_val);
				} else {
				}
				
				sXml=null;
				break;
        }
    }
	/**
	 * Sheet search end event
	 * 
	 * @param {sheet}  			sheet Objcet
	 * @param {ErrMsg}  		Error Message
	 **/
	function sheet_OnSearchEnd(sheet, ErrMsg){
		/*
		var formObj=document.form;
		var ret_val=sheet.GetEtcData(formObj.oid.value);
		var tmp = '';
		if (formObj.tes_mode.value!=undefined && formObj.tes_mode.value.toUpperCase()=='COMBO'){
			var def_val=formObj.def.value;
			var idx=formObj.idx.value;
			var sheetObj=formObj.sheetObj.value;
			if (ret_val!=null){			
				tmp=ret_val.split('--');
			
				if ((tmp[0]!=undefined && tmp[0]!=null && tmp[0].trim()!='') && (def_val==undefined || def_val==null || def_val.trim()=='')){
					def_val=tmp[0];
				}
				if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
					ret_val=tmp[1];
				}
			}
			if ( formObj.f_cmd.value == SEARCH05 ) {
				tes_makeComboCntrBkg(ret_val, idx, def_val, sheetObj);
			}
			else {
				tes_makeComboGuarantee(ret_val, idx, def_val);
			}
		} else if (formObj.tes_mode.value!=undefined && formObj.tes_mode.value.toUpperCase()=='INPUT'){
			tes_setInputValueGurantee(ret_val);
		} else {
		}*/
	}
	/**
	 * TES mabke Common combo 
	 * 
	 * @param {combo_val}  	combo value
	 * @param {idx}  		idx
	 * @param {def_val}  	def value
	 **/
	function tes_makeComboGuarantee(combo_val, idx, def_val){
		var formObj=document.form;
		var parentObj=eval("parent.comboObjects["+(idx-1)+"]");
		if (parentObj!=null){
			parentObj.RemoveAll();
			parent.initCombo(parentObj, parseInt(idx,10), combo_val, def_val);
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESGuaranteeCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}
	/**
	 * TES Container Booking No. make combo
	 * 
	 * @param {combo_val}  	combo value
	 * @param {idx}  		idx
	 * @param {def_val}  	def value
	 **/
	function tes_makeComboCntrBkg(combo_val, idx, def_val, sheetObj) {
		var formObj=document.form;
		var parentObj=eval("parent.sheetObjects[0]");
		
		var tmp=combo_val.split("|");
		
		if (parentObj!=null){
			parent.sheetObjects[0].CellComboItem(idx,"bkg_no", { ComboCode:combo_val, ComboText:combo_val });
			parent.sheetObjects[0].SetCellValue(idx, "bkg_no",  tmp[0], 0);
			parent.sheetObjects[0].SetCellValue(idx, "bkg_no_list_ctnt", combo_val,0);			
			
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESGuaranteeCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}
	/**
	 * TES make Common combo 
	 * 
	 * @param {combo_val}  	combo value
	 * @param {idx}  		idx
	 * @param {def_val}  	def value
	 **/
	function tes_makeCombo2Guarantee(idx, org_val){
		var formObj=document.form;
		var parentObj=eval("parent.comboObjects["+(idx-1)+"]");
		if (parentObj!=null){
			parentObj.RemoveAll();
			var tmp=null;
			if (org_val!=null){
				tmp=org_val.split('--');
			}
			var tmp2=null;
			var keyArr=new Array();
			var valueArr=new Array();
			for( var i=0; i< tmp.length; i++ ){
				tmp2=tmp[i].split('|');
				if( tmp2[0]!=undefined && tmp2[0]!=null ) keyArr[i]=tmp2[0];
				else  keyArr[i]='';
				if( tmp2[1]!=undefined && tmp2[1]!=null ) valueArr[i]=tmp2[1];
				else  valueArr[i]=tmp2[1];
			}
			parent.initCombo(parentObj, parseInt(idx,10), keyArr, valueArr);
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESGuaranteeCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}	 
