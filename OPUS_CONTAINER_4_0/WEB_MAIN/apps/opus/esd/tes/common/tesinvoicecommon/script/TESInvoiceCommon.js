/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : TESInvoiceCommon.jsp
*@FileTitle  : TESInvoiceCommon
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
	/**
	 * TES make Common combo 
	 * 
	 * @param {string}		combo_val  	combo value
	 * @param {int,string}	idx  		idx
	 * @param {string}		def_val  	def value
	 **/
	function tes_makeCombo(combo_val, idx, def_val){
		var parentObj=eval("parent.comboObjects["+(idx-1)+"]");
		if (parentObj!=null){
			parentObj.RemoveAll();
			parent.initCombo(parentObj, parseInt(idx,10), combo_val, def_val);
		}
	}
	/**
	 * TES Common Input Value
	 * 
	 * @param {string}	ret_val  	return value
	 **/
	function tes_setInputValue(ret_val){
		var formObj=document.form;
		var parentObj=eval("parent.document.all."+formObj.coid.value);
		if (parentObj!=undefined && parentObj!=null){
			parentObj.value=ret_val;
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESInvoiceCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}
	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * 
     * @param {ibsheet}		sheet_obj  	Sheet Object
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * setting sheet initial values and header
     * adding case as numbers of counting sheets
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {int,string}	sheetNo  	Sheet Object 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:   //t1sheet1 init
                with(sheetObj){

		             var HeadTitle="";
		             var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers=[ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols=[ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 } ];
		             InitColumns(cols);
		             
		
		             SetConfig( { SearchMode:2, DataRowMerge:0 } );
		
		             var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		             var headers = [ ];
		             InitHeaders(headers, info);
		
		             var cols = [  ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
            }
		             break;
		}
	}
	/**
     * Sheet Action 
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {Object}		formObj  	Form Object
     * @param {string}		sAction  	Action Command
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
 				var sXml=sheetObj.GetSearchData("TESInvoiceCommonGS.do", tesFrmQryStr(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:2} );
				var sxml0=ComGetEtcData(sXml,formObj.coid.value.trim());
				var formObj=document.form;
				var ret_val=ComGetEtcData(sXml,formObj.coid.value);
				if( ret_val == undefined ) ret_val="";
				if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='COMBO'){
					var def_val=formObj.def.value;
					var idx=formObj.idx.value;
					if (ret_val!=null){
						tmp=ret_val.split('--');
					}
					if ((tmp[0]!=undefined && tmp[0]!=null && tmp[0].trim()!='') && (def_val==undefined || def_val==null || def_val.trim()=='')){
						def_val=tmp[0];
					}
					if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
						ret_val=tmp[1];
					}
					tes_makeCombo(ret_val, idx, def_val);
				} else if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='INPUT'){
					tes_setInputValue(ret_val);
				} else {
				}
				
				sXml=null; sxml0=null; 
				break;
        }
    }
	/**
	 * Sheet search end event
	 * 
	 * @param {ibsheet}		sheet 			sheet Objcet
	 * @param {string}		ErrMsg  		Error Message
	 **/
	function sheet_OnSearchEnd(sheet, ErrMsg){
		var formObj=document.form;
		var ret_val=sheet.GetEtcData(formObj.coid.value);
		if( ret_val == undefined ) ret_val="";
		if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='COMBO'){
			var def_val=formObj.def.value;
			var idx=formObj.idx.value;
			if (ret_val!=null){
				tmp=ret_val.split('--');
			}
			if ((tmp[0]!=undefined && tmp[0]!=null && tmp[0].trim()!='') && (def_val==undefined || def_val==null || def_val.trim()=='')){
				def_val=tmp[0];
			}
			if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
				ret_val=tmp[1];
			}
			tes_makeCombo(ret_val, idx, def_val);
		} else if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='INPUT'){
			tes_setInputValue(ret_val);
		} else {
		}
	}
