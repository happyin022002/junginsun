/**
 * TESCommonJSP.js 
 */
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
	 * TES Common ComboBox
	 * 
	 * @param {String}		combo_val  	combo value
	 * @param {int,string}	idx  		idx
	 * @param {string}		def_val  	def value
	 **/
	function tes_makeCombo(combo_val, idx, def_val){
		var formObj=document.form;
		var parentObj=eval("parent.comboObjects["+(idx-1)+"]");
		if (parentObj!=null){
			parentObj.RemoveAll();
			parent.initCombo(parentObj, parseInt(idx,10), combo_val, def_val);
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}
	/**
	 * TES Common ComboBox
	 * 
	 * @param {string}		combo_val  	ComboBox value
	 * @param {string}		org_val  	original value
	 **/
	function tes_makeCombo2(idx, org_val){
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
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}	 
	/**
	 * TES Common Input Value
	 * 
	 * @param {string}		ret_val  	return value
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
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}
	
	function tes_setInputValue2(ret_val){
		var formObj=document.form;
		var parentObj=eval("parent.document.all."+formObj.coid.value);
		if (parentObj!=undefined && parentObj!=null){
			parentObj.value=ret_val;
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"("+formObj.row.value+")");
			}
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}	
	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * 
     * @param {ibsheet}		sheet_obj  	sheet object
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * setting sheet initial values and header
     * adding case as numbers of counting sheets.
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {int,string}	sheetNo  	Sheet Object 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:   //t1sheet1 init
            	 with(sheetObj){
		             var HeadTitle="TEST";
		             SetConfig( { SearchMode:2 } );
		             var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers=[ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols=[ {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 } ];
		             InitColumns(cols);
		             SetEditable(1);
		           //  SetSheetHeight(ComGetSheetHeight(sheetObj, 10)); 
	           }
                break;
		}
	}
	/**
     * Sheet Action 
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {Object}		formObj}  	Form Object
     * @param {String}		sAction  	Action Command
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //Retrieve
        		var sXml=sheetObj.GetSearchData("TESCommonGS.do", tesFrmQryStr(formObj));
        		//sheetObj.LoadSearchData(sXml,{Sync:1} );
        		var formObj=document.form;
        		var org_val=ComGetEtcData(sXml , formObj.coid.value);
        		//var org_val=sheet.GetEtcData(formObj.coid.value);
        		var ret_val=org_val;
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
        			//[ESD_TES_0027]GET MDM Account
        			if ( document.form.f_cmd.value == 35 || document.form.f_cmd.value == SEARCHLIST06  || document.form.f_cmd.value == SEARCHLIST10) tes_makeCombo2(idx, org_val);
        			else tes_makeCombo(ret_val, idx, def_val);
        		} else if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='INPUT'){
        			if(formObj.f_cmd.value == SEARCH23){
        				tes_setInputValue2(ret_val);
        			}else{
        				tes_setInputValue(ret_val);
        			}
        			
        		} else {
        		}
        		var sxml0=sheetObj.GetEtcData(formObj.coid.value.trim());
        		sXml=null; sxml0=null;
        		break;
        }
    }
