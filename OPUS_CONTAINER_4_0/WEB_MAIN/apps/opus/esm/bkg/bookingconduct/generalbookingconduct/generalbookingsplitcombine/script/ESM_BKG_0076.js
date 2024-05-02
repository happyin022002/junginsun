/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0076.js
*@FileTitle  : Booking Combine
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0076 : business script for ESM_BKG_0076 
     */
    function ESM_BKG_0076() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    }
    // Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /* */
		var sheetObject=sheetObjects[0];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_rowadd":
					if (!$('#btn_rowadd').prop("disabled")) {
						var Row=sheetObjects[0].DataInsert(-1);
						sheetObjects[0].SetCellEditable(Row, 0,1);
						sheetObjects[0].SetCellEditable(Row, 1,1);
						sheetObjects[0].SetCellEditable(Row, 2,1);
						sheetObjects[0].SetCellEditable(Row, 3,1);
						for (var i=4;i<15;i++) {
							sheetObjects[0].SetCellEditable(Row,i,0);
						}
					}
					break;
				case "btn_rowdelete":
					if (!$('#btn_rowdelete').prop("disabled")) {
						var delRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
						var delRow=delRowArr.split("|");
						if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
							for (var idx=delRow.length-1; idx>=0; idx--){
								sheetObjects[0].RowDelete(delRow[idx], false);
							}
						}
					}
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_combine":
					if(!validateForm(sheetObjects[0],document.form,"btn_combine")) {
						return false;
					}
					comBkgCallPop0974('callBack0974');
					break;
				case "btn_container":
					doActionIBSheet(sheetObjects[0],document.form,"btn_container");
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObjects[0],document.form,"btn_cancel");
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
		initControl();
		ComBtnDisable("btn_rowadd");
		ComBtnDisable("btn_rowdelete");
    }
 	function initControl() {
 		var formObject=document.form;
		// 		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); 
		// 		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
		// 		axon_event.addListenerForm('blur', 'form1_blur', formObject);
 	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
	             (21, 0, 0, true);
	             var HeadTitle=" ||Booking Number|B/L No.|Status|Shipper|POR|POR|POL|POL|POD|POD|DEL|DEL|CNTR Vol|irr_bl_no_flg||||";

	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             	var headers = [ { Text:HeadTitle, Align:"Center"} ];
             	InitHeaders(headers, info);

             	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slct_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"por_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pol_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pod_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"del_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cntr_vol",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"irr_bl_no_flg" } ,
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cust_cd" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bdr_flg" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vvd" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"master_flg" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_ofc_cd" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"broker" }
                     ];
               
	              InitColumns(cols);
	              SetEditable(1);
//	              SetSheetHeight(442);
	              updateSheetSize(sheetObj);
              }
               break;
        }
    }
    
    $(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
 });
 
 $(window).on('resizeEnd', function() {
	 updateSheetSize(sheetObjects[0]);
 });
 
 function updateSheetSize(sheetObj){
	 var obj = $("#" + sheetObj.id).offset();
	 var marginDefault = 20;
	 var marginHeight = obj.top + marginDefault;
    var height = $(window).height();

    with(sheetObj){
        SetSheetHeight(height - marginHeight);
    }
 }    
    
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	        	formObj.f_cmd.value=SEARCH;
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
				var sXml=sheetObj.GetSearchData("ESM_BKG_0076GS.do", params);
         		sheetObjects[0].RenderSheet(0);
         		sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
         		sheetObjects[0].RenderSheet(1);
				if ( formObj.search_gbn[0].checked ) {
					for (var i=1;i<=sheetObjects[0].GetTotalRows();i++) {
						sheetObjects[0].SetCellEditable(i, 0,1);
						sheetObjects[0].SetCellEditable(i, 1,1);
						sheetObjects[0].SetCellEditable(i, 2,1);
						sheetObjects[0].SetCellEditable(i, 3,1);
					}
				}
				break;
			case "run_combine":        //handling Combine process
				formObj.f_cmd.value=MODIFY01;
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0076GS.do", params);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComShowCodeMessage("BKG00166");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					if("Y" == ComGetEtcData(sXml, "pre_checking")){
						comBkgCallPop0200(formObj.mst_bkg_no.value, "N");
					}
				} else {
	         		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				}
				break;
			case "btn_container":        //retrieving container list
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var param="";
				var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
				var chkRow=chkRowArr.split("|");
				param="?bkg_no="+sheetObj.GetCellValue(chkRow[0], "bkg_no");
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0732.do" + param, "PopupEsmBkg0076", 700, 500, false);
				break;
			case "btn_cancel":        //canceling Booking
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var sMsg=ComGetMsg("BKG00670");
				if(ComShowConfirm(sMsg)){
					comBkgCallPop0620('cancelFuncion');
				}
				break;
        }
    }
    
    function cancelFuncion(message){
    	var formObj = document.form;
    	formObj.f_cmd.value = MODIFY02;
		var params = FormQueryString(formObj) + "&sheet1_message=" + message;
		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
		var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0076GS.do", params);
		if(ComGetEtcData(sXml, "isSuccess") == "Y"){
			ComShowCodeMessage("BKG00590");
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}else if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F'){
			ComGetErrorMessage(sXml);
		}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    		case IBSEARCH:
    			if ( formObj.search_gbn[0].checked ) {
    				if ( sheetObj.RowCount()< 1 ) {
    					ComShowCodeMessage('BKG00104');
    					return false;
    				}
    			} else {
    				// by route
    				if( formObj.vvd.value == "" ){
    					ComShowCodeMessage('BKG00104','VVD');
    					formObj.vvd.focus();
    					return false;
    				} else if ( formObj.vvd.value.length < 9 ) {
    					ComShowCodeMessage('BKG00007');
    					formObj.vvd.focus();
    					return false;
    				}
    				if( formObj.hitchment_yn.checked == false && formObj.pol_cd.value == "" ){
    					ComShowCodeMessage('BKG00104','POL');
    					formObj.pol_cd.focus();
    					return false;
    				}
    				if( formObj.pod_cd.value == "" ){
    					ComShowCodeMessage('BKG00104','POD');
    					formObj.pod_cd.focus();
    					return false;
    				}
    			}
    			break;
    		case "btn_combine":
    			
    			var param="";
    			var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
    			var chkRow=chkRowArr.split("|");
    			var bdrBkgList="";
    			if ( sheetObj.CheckedRows("slct_flg") > 1 ) {
					var bkgNo=sheetObj.GetCellValue(chkRow[0], "bkg_no").substring(0, 3);
					var shCd=sheetObj.GetCellValue(chkRow[0], "cust_cd");
					var vvdCd=sheetObj.GetCellValue(chkRow[0], "vvd");
					var porCd=sheetObj.GetCellValue(chkRow[0], "por_cd");
					var polCd=sheetObj.GetCellValue(chkRow[0], "pol_cd");
					var podCd=sheetObj.GetCellValue(chkRow[0], "pod_cd");
					var delCd=sheetObj.GetCellValue(chkRow[0], "del_cd");
					var porNodCd=sheetObj.GetCellValue(chkRow[0], "por_nod_cd");
					var delNodCd=sheetObj.GetCellValue(chkRow[0], "del_nod_cd");
					var porCntCd=sheetObj.GetCellValue(chkRow[0], "por_cd").substring(0, 2);
					var polCntCd=sheetObj.GetCellValue(chkRow[0], "pol_cd").substring(0, 2);
					var broker=sheetObj.GetCellValue(chkRow[0], "broker");
					var bkgOfcCd=sheetObj.GetCellValue(chkRow[0], "bkg_ofc_no");
					if(ComIsNull(vvdCd)){
						ComShowMessage(msgs['BKG00882']);
						return false;
					}
					
					var irrBlNoflg = sheetObj.GetCellValue(chkRow[0], "irr_bl_no_flg");
					
    				for (var idx=1; idx < chkRow.length; idx++) {
    					if(irrBlNoflg != sheetObj.GetCellValue(chkRow[idx], "irr_bl_no_flg")){
    						ComShowMessage('It is not able to combine For 10-digit BL No and General B/L together. ');
    						return false;
    					}
    					if (bkgOfcCd != sheetObj.GetCellValue(chkRow[idx], "bkg_ofc_no")) {
    						ComShowMessage(msgs['BKG00160']);
    						return false;
    					}
    					if (shCd != sheetObj.GetCellValue(chkRow[idx], "cust_cd")) {
    						ComShowMessage(msgs['BKG00157']);
    						return false;
    					}
    					if (vvdCd != sheetObj.GetCellValue(chkRow[idx], "vvd")) {
    						ComShowMessage(msgs['BKG00998']);
    						return false;
    					}
    					if (porCd != sheetObj.GetCellValue(chkRow[idx], "por_cd")
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG00158']);
    						return false;
    					}
    					if (polCd != sheetObj.GetCellValue(chkRow[idx], "pol_cd")
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG00997']);
    						return false;
    					}
    					if (podCd != sheetObj.GetCellValue(chkRow[idx], "pod_cd")) {
    						ComShowMessage(msgs['BKG03159']);
    						return false;
    					}
    					if (delCd != sheetObj.GetCellValue(chkRow[idx], "del_cd")) {
    						ComShowMessage(msgs['BKG00159']);
    						return false;
    					}
    					if (porNodCd != sheetObj.GetCellValue(chkRow[idx], "por_nod_cd")
    						&& formObj.hitchment_yn.checked == false) {
    						ComShowMessage(msgs['BKG02014']);
    					}
    					if (delNodCd != sheetObj.GetCellValue(chkRow[idx], "del_nod_cd")) {
    						ComShowMessage(msgs['BKG02015']);
    					}
    					if(formObj.hitchment_yn.checked == true){
    						if (porCntCd != sheetObj.GetCellValue(chkRow[idx], "por_cd").substring(0, 2)) {
    							ComShowMessage(msgs['BKG02017']);
    							return false;
    						}
    						if (polCntCd != sheetObj.GetCellValue(chkRow[idx], "pol_cd").substring(0, 2)) {
    							ComShowMessage(msgs['BKG02044']);
    							return false;
    						}
    					}
    					if (broker != sheetObj.GetCellValue(chkRow[idx], "broker")) {
    						ComShowMessage(msgs['BKG02015']);
    						return false;
    					}
    					if(sheetObj.GetCellValue(chkRow[idx],"bdr_flg")=="Y"){
    						if(bdrBkgList ==""){
    							bdrBkgList=sheetObj.GetCellValue(chkRow[idx], "bkg_no");
    						} else {
    							bdrBkgList=bdrBkgList + ", " + sheetObj.GetCellValue(chkRow[idx], "bkg_no");
    						}
    					}
    				}
    				if(bdrBkgList !=""){
    					if (!ComShowCodeConfirm("BKG02038", bdrBkgList)) {
            	    		return false;
    					} 
    				}
    			}
    			break;
    		case "btn_container":
    			if (sheetObj.CheckedRows("slct_flg") == 0) {
    				ComShowMessage(msgs['BKG00155']);
    				return false;
    			}
    			if (sheetObj.CheckedRows("slct_flg") > 1) {
    				ComShowMessage(msgs['BKG00362']);
    				return false;
    			}
    			break;
    		case "btn_cancel":
    			if (sheetObj.CheckedRows("slct_flg") == 0) {
    				ComShowMessage(msgs['BKG00155']);
    				return false;
    			}
    			for (var i=1;i<=sheetObj.RowCount();i++) {
    				if ( ComIsNull(sheetObj.GetCellValue(i, "bkg_sts_cd")) ) {
    					ComShowCodeMessage("BKG00048");
    					return false;
    				}
    			}
    			break;
    		}
    	}
    	return true;
    }
    function changeSearchGbn(){
		var formObj=document.form;
		if ( formObj.search_gbn[0].checked ) {
			changeRouteEnable("N");
			ComBtnEnable("btn_rowadd");
			ComBtnEnable("btn_rowdelete");
			formObj.hitchment_yn.disabled=false;
		} else {
			changeRouteEnable("Y");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			formObj.hitchment_yn.disabled=false;
		}
		sheetObjects[0].RemoveAll();
		ComClearObject(formObj.vvd);
		ComClearObject(formObj.pol_cd);
		ComClearObject(formObj.pol_nod_cd);
		ComClearObject(formObj.pod_cd);
		ComClearObject(formObj.pod_nod_cd);
		ComClearObject(formObj.del_cd);
		ComClearObject(formObj.del_nod_cd);
		ComClearObject(formObj.cust_cnt_cd);
		ComClearObject(formObj.cust_seq);
		ComClearObject(formObj.cust_nm);
		formObj.hitchment_yn.checked=false;
    }
	function changeRouteEnable(enableYn) {
		var formObj=document.form;
		var bg_color1=(enableYn == "Y")?"#CCFFFD":"#E8E7EC";
		var bg_color2=(enableYn == "Y")?"#FFFFFF":"#E8E7EC";
		var ro_yn=(enableYn == "Y")?false:true;
		formObj.vvd.style.background=bg_color1;
		formObj.pol_cd.style.background=bg_color1;
		formObj.pol_nod_cd.style.background=bg_color2;
		formObj.pod_cd.style.background=bg_color1;
		formObj.pod_nod_cd.style.background=bg_color2;
		formObj.del_cd.style.background=bg_color2;
		formObj.del_nod_cd.style.background=bg_color2;
		formObj.vvd.readOnly=ro_yn;
		formObj.pol_cd.readOnly=ro_yn;
		formObj.pol_nod_cd.readOnly=ro_yn;
		formObj.pod_cd.readOnly=ro_yn;
		formObj.pod_nod_cd.readOnly=ro_yn;
		formObj.del_cd.readOnly=ro_yn;
		formObj.del_nod_cd.readOnly=ro_yn;
	}
    function changeHitchGbn(){
		var formObj=document.form;
		if ( formObj.hitchment_yn.checked ) {
			if ( formObj.search_gbn[0].checked ){
				formObj.pol_cd.style.background="#E8E7EC";
			} else {
				formObj.pol_cd.style.background="#FFFFFF";
			}
		} else {
			if ( formObj.search_gbn[0].checked ){
				formObj.pol_cd.style.background="#E8E7EC";
			} else {
				formObj.pol_cd.style.background="#CCFFFD";
			}
		}
    }
//	function form1_blur(){
//		ComChkObjValid(event.srcElement);
//	}
/*   	function obj_keydown() {
   		var obj=event.srcElement;
   		var vKeyCode=event.keyCode;
   		var formObj=document.form;
   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}
	function obj_keypress(){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){
	    	case "int":
		        //number
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //number+"."
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //English+number -> ComKeyOnlyAlphabet('num');
		        if(keyValue >= 97 && keyValue <= 122) {//
	                event.keyCode=keyValue + 65 - 97;
	            }
//	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //lower case English+number -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //upper case English+number -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //upper case English+number-> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //number
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}*/
    function comBkgCallPop0974(callback_func){
		if (sheetObjects[0].CheckedRows("slct_flg") > 1) {
			var param="";
			var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow=chkRowArr.split("|");
			if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
				for(var idx=0;idx<chkRow.length;idx++) {
					if(idx == 0){
						param="ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], "bkg_no")
							+"&bdr_flg=" + sheetObjects[0].GetCellValue(chkRow[idx], "bdr_flg");
					} else {
						param=param +"&ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], "bkg_no")
							+"&bdr_flg=" + sheetObjects[0].GetCellValue(chkRow[idx], "bdr_flg");
					}
				}
			}
			ComOpenPopup("/opuscntr/ESM_BKG_0974.do?"+param, 800, 550, callback_func, "0,1", true);
		}
    }
    
    function setMessage(msg){
    	document.form.message.value = msg;
    }
    
    function callBack0974(rArray){
    	var formObj=document.form;
    	formObj.mst_bkg_no.value=rArray[0];
		var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow=chkRowArr.split("|");
		var bdrFlg="N";
		if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
			for(var idx=0;idx<chkRow.length-1;idx++) {
				if(sheetObjects[0].GetCellValue(chkRow[idx], "bdr_flg") == "Y"){
					bdrFlg="Y";
					break;
		    	}
			}
			if(bdrFlg=="Y"){
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.mst_bkg_no), "C");
		 		doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			} else {
				doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			}
		}
    }         
	/**
    * callback method from CA Reason process : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj=document.form;
    	//01. getting CA ReasonCd, Remark input values
    	var strRsnCd=nullToBlank(arrPopupData[0][2]);
    	var strRemark=nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value=strRsnCd;
        formObj.ca_remark.value=strRemark;
    }
