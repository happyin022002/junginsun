/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9070.js
*@FileTitle  : Agreement Rate List Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
	/** Event handler processing by button name */
function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		/*******************************************************/
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_yard": 
					var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId="COM_ENS_061";
					var param='?classId='+classId;
					var chkStr=dispaly.substring(0,3)
                   // radio PopUp  
					if(chkStr == "1,0") {
						ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 450, 'getYard', dispaly, false);
					} else {
						ComShowCodeMessage('TES10001');
						return;
					}
					break;  
				case "btn_vndr":        	    		 	   	    
					var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId="COM_ENS_0C1";
					var param='?classId='+classId;
					var chkStr=dispaly.substring(0,3)
                       // radio PopUp  
					if(chkStr == "1,0") {
						ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 460, 'getVender', dispaly, false);
					} else {
						ComShowCodeMessage('TES10001');
						return;
					}
					break; 
				case "btng_select": 
 		   	    	formObject.no_ofc_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd");
 		   	    	formObject.no_yd_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "yd_cd"); 		   	    	
 		   	    	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goSelect');
 		   	    	
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list.<br>
     * adding process for list in case of needing batch processing with other items.<br>
     * defining list on the top of source.<br>
     * @param{ibsheet}	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * initializing sheet.<br>
	 * implementing onLoad event handler in body tag.<br>
	 * adding first-served functions after loading screen..<br>
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		document.form.yd_cd.value=opener.document.form.yd_cd.value;
	}
	/**
	 * setting sheet initial values and header.<br>
	 * param : sheetObj ==> , sheetNo ==>  .<br>
	 * adding case as numbers of counting sheets.<br>
	 * @param{ibsheet}		sheetObj	IBSheet Object
	 * @param{int,String}	sheetNo		Sheet No
	 */
	function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                 with(sheetObj){
		              var HeadTitle1="Agreement\nNo.|Agreement\nVersion|Yard Code|Vendor Code|Effective Date|Effective Date|Creation Office";
		              var HeadTitle2="Agreement\nNo.|Agreement\nVersion|Yard Code|Vendor Code|From|To|Creation Office";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                  {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetCellBackColor(1,4,"#555555");//
		              SetCellBackColor(1,5,"#555555");//
		              resizeSheet();//SetSheetHeight(240);
                    }
                break;
        }
    }
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
 	/**
 	 * handling sheet process. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {Object}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
 	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TES_9070GS.do", tesFrmQryStr(formObj) );
				break;
		}
	}
    /**
     * Set Yard info ( Code, Name) <br>
     * 
     * @param{Array}	rowArray	Yard 정보 Array Object
     */
	function getYard(rowArray) {  
		var colArray=rowArray[0];
		document.all.yd_cd.value=colArray[3];
	} 
	/**
	 * Set Vendor info( Code, Name) <br>
	 * 
	 * @param{Array}	rowArray	Vendor 정보 Array Object
	 */
	function getVender(rowArray) {  
		var colArray=rowArray[0];
		document.all.vndr_seq.value=colArray[2];
	}
	/**
	 * Yard Code  Validate Check. <br>
	 **/
	function validateYardCode() {			
		var formObj=document.form;	
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == '')	
		{				
			formObj.yd_cd_hidden.value='';
			formObj.is_valid_yd_cd.value='';
			return false;
		}
		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value='';
			formObj.is_valid_yd_cd.value='';
			tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
		}			
	}
	/**
	 * Yard Code  Validate Check. <br>
	 **/
	function checkValidYardCode(){	
		var formObj=document.form;
		var tmp='';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp=formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value=(tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){					
					formObj.yd_cd_hidden.value=formObj.yd_cd.value; 					
				} else {
					formObj.yd_cd.value='';
					formObj.is_valid_yd_cd.value='';
					formObj.yd_cd_hidden.value='';					
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.yd_cd.value='';
				formObj.is_valid_yd_cd.value='';
				formObj.yd_cd_hidden.value='';				
				ComShowCodeMessage('TES10066');
			}
		} else { 
			formObj.yd_cd.value='';
			formObj.is_valid_yd_cd.value='';
			formObj.yd_cd_hidden.value='';			
			ComShowCodeMessage('TES10066');
		}	
	}
	/**
     * Vendor Code  Validate. <br>
     **/
	function validateVendorCode() {			
		var formObj=document.form;	
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == '')	
		{				
			formObj.vndr_seq_hidden.value='';
			formObj.is_valid_vndr_seq.value='';
			return false;
		}
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value='';
			formObj.is_valid_vndr_seq.value='';
		}			
	}
	/**
     * Vendor Code  Validate Check. <br>
     **/
	function checkValidVendorCode(){		
		var formObj=document.form;
		var tmp='';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp=formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value=(tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){					
					formObj.vndr_seq_hidden.value=formObj.vndr_seq.value;					
				} else {
					formObj.vndr_seq.value='';
					formObj.is_valid_vndr_seq.value='';
					formObj.vndr_seq_hidden.value='';					
					ComShowCodeMessage('TES10067');
				}
			} else {
				formObj.vndr_seq.value='';
				formObj.is_valid_vndr_seq.value='';
				formObj.vndr_seq_hidden.value='';
				ComShowCodeMessage('TES10067');
			}
		} else {
			formObj.vndr_seq.value='';
			formObj.is_valid_vndr_seq.value='';
			formObj.vndr_seq_hidden.value='';			
			ComShowCodeMessage('TES10067');
		}	
	}     
	/**
	 * Input Value Check. <br>
     * @param {Object}	obj    Text Object
	 **/
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value='';//substring(obj.value,0,obj.maxLength);
			obj.focus();
			return false;
		}
	}	
	/**
     * @param {Object}	obj    Text Object
     **/
	function isNum(obj){
		if (!ComIsNumber(obj)){
			obj.value='';
		}
	}
	/**
     * @param {Object}	obj    Text Object
     **/
	function isNum1(obj){
		if (!ComIsNumber(obj,'-')){
			obj.value='';
		}
	}		
	/**
     * only English and numbers permitted <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum(obj){
		if (!ComIsAlphabet(obj,'u')){
			obj.value='';
		}
	}
	/**
     * only English and numbers permitted <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum1(obj){
		if (!ComIsAlphabet(obj,'n')){
			obj.value='';
		}
	} 
	/**
     * only English and numbers permitted <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum2(obj){
		if (!ComIsAlphabet(obj,'n')){
			obj.value='';
		}	
		obj.value=obj.value.toUpperCase();		
	} 			
	
	function goSelect(){
		if(document.form.auth_ofc_cd.value!="Y"){
			ComShowMessage(ComGetMsg('TES50204'));
			return;
		}
		
		var opener_obj=window.dialogArguments;
		if(!opener_obj) opener_obj=parent;
		if( sheetObjects[0].GetSelectRow()== 1 || sheetObjects[0].GetSelectRow()== 0 ) {
			ComShowCodeMessage('TES10084');
			return false;	
		}
		if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_ofc_cty_cd"	) == "" ||
		sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_ver_no"		) == "" ||
		sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "yd_cd"				) == "" ||
		sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "vndr_seq"				) == "" ) {
			ComShowCodeMessage('TES10081');
			return false;
		}
		if( opener_obj.document.form.tml_agmt_ofc_cty_cd.value	== "" || 
			opener_obj.document.form.tml_agmt_ver_no.value		== " " ) {
			ComShowCodeMessage('TES10085');
			return false;         	     			
		}
		
		opener_obj.document.form.tml_agmt_ofc_cty_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_ofc_cty_cd");
		opener_obj.document.form.tml_agmt_ver_no.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_ver_no");
		opener_obj.document.form.copy_tml_agmt_ofc_cty_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_ofc_cty_cd");
		opener_obj.AgreementCopy();
		ComClosePopup(); 
		
	}
	
	/**
     * @param {String}	src    Text String
     **/
	function getStrLen(src) {
		src=new String(src);
		var byteLength=0;
		for (var inx=0; inx < src.length; inx++) {
			var oneChar=escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}	
