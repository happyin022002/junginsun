/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0120.js
*@FileTitle  : EDI Route Master 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isSearch=false;
var selRow=0;
var isFirst1=0;
var isFirst2=0; 
var grp_cust;
var firstSel=-1;
// Common global variable
var pageNo=1 ;

//Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/* Event handler processing by button name */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        /****************************
         enterKey
        *****************************/
        var srcObj= ComGetEvent("nodeName");
        var keyObj= ComGetEvent("keyCode");
        if(srcObj =='INPUT' && keyObj ==13) {
            srcName='btn_retrieve';
        }
        /****************************/
        switch(srcName) {
    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;
    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
    	    case "btn_save":
	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;
    	    case "btn_downexcel":
    	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	        break;
    	    case "btn_add":
    	        doActionIBSheet(sheetObject,formObject,IBINSERT);
    	        break;        	        
       	    case "btn_save_partner":
    	        doActionIBSheet(sheetObject,formObject, MULTI01);
    	        break;         	        
			case "btn_por_port_cd":
				selectPort(formObject, 'POR');
    	        break;
			case "btn_pol_port_cd":
	            selectPort(formObject, 'POL');
    	        break;
			case "btn_pod_port_cd":
	            selectPort(formObject, 'POD');
    	        break;
			case "btn_del_port_cd":
				selectPort(formObject, 'DEL');
    	        break;
			case "ts_type":
	            selectType();
    	        break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			//showErrMessage("NO ");
		} else {
			//showErrMessage(e);
		}
	}
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
}

/* initControl() */
function initControl() {
	//axon_event.addListenerFormat('blur',     'obj_blur',  	 form);
	//axon_event.addListenerFormat('focus',    'obj_focus', 	 form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('keyup', 	 'obj_keyup', 	 form);
}

		/** 
         * Depending on the object's dataformat check the validity of input  <br>
         * @param  
         * @return 
         * @author 
         * @version 
         */ 
        function obj_keypress(){
         	obj=event.srcElement;
         	if(obj.dataformat == null) return;
         	window.defaultStatus=obj.dataformat;
         	switch(obj.dataformat) {
         	    case "engup":
         	        ComKeyOnlyAlphabet('upper');
         	        break;
         	}
        }
        
/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
    switch(sheetNo) {
    	case 1:      //IBSheet1 init
    		with(sheetObj){
        		var HeadTitle="SEQ|Del.|STS|POR|POL|POD|DEL|C.Date|C.User";

        	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:0 } );

        	 	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	 	InitHeaders(headers, info);

        	 	var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sSeq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
        	 	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:1,TrueValue:"Y" },
        	 	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
        	 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	 	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
        	 	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
        	 	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
        	 	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
        	 	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"use_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
        	 	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
            
        	 	InitColumns(cols);

        	 	SetEditable(1);
        	 	SetColProperty("cre_dt", {Format:"####-##-##:##:##"} );
        	 	SetHeaderRowHeight(20);
//        	 	SetSheetHeight(350);
        	 	resizeSheet();
        	 	SetColProperty(0 ,"por_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	 	SetColProperty(0 ,"pol_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	 	SetColProperty(0 ,"pod_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	 	SetColProperty(0 ,"del_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
    		}
            break;
    }
}

 	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
        	case IBSEARCH:      
        		if(!validateForm(sheetObj,formObj,sAction)) return;
				if(!mandatoryChk(formObj)) break;
				if(!ComChkRequired(formObj)) return;
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_SCE_0120GS.do", FormQueryString(formObj) );
				break;
        	case IBSAVE:        
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		formObj.f_cmd.value=MULTI;
        		sheetObj.DoSave("ESD_SCE_0120GS.do", FormQueryString(formObj));
        		formObj.f_cmd.value=SEARCH;
        		break;
        	case IBINSERT:      
      			sheetObj.DataInsert(-1);
				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({ CheckBoxOnValue:'Y',KeyFieldMark:false,AutoSizeColumn:true,Merge:true,HiddenColumn:true});
				}
				break;
			case SEARCH01:
				document.getElementById('partner_id').value=document.getElementById('partner_id').value.toUpperCase();
                sheetObj.ShowDebugMsg(false);
              	formObj.f_cmd.value=SEARCH01;
              	var sXml=sheetObj.GetSearchData("ESD_SCE_0120GS.do", FormQueryString(formObj));
        	    var partner_name=ComGetEtcData(sXml, "partner_name");
                document.getElementById('partner_name').value=partner_name;
                ComEtcDataToForm(formObj,sheetObj) ;            
                sheetObj.RemoveAll();
                break; 
			case MULTI01:
				if(!validateForm(sheetObj,formObj,sAction)) return;        	  
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoSearch("ESD_SCE_0120GS.do", FormQueryString(formObj) );
				break;
		}
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		switch(sAction) {
			case MULTI01:
				if( ComIsEmpty(formObj.partner_id) ){
					ComShowCodeMessage("COM12114" ,"TP ID",'','');
      	           	return false;		   
      		   	}
      		   	if( ComIsEmpty(formObj.partner_name) ){
      		   		ComShowCodeMessage("COM12114" ,"TP NAME",'','');
      		   		return false;		   
      		   	} 
      		   	break;
      		case IBSAVE:
      			if(formObj.partner_id.value == ""){
      				ComShowCodeMessage("COM12114" ,"TP ID",'','');
      				return false;		   
      			}
      			if(formObj.partner_name.value == ""){
      				ComShowCodeMessage("COM12114" ,"TP NAME",'','');
      				return false;		   
      			} 
      			break;
		}
		return true;
	}
	
	function mandatoryChk(formObj) {
		if(formObj.partner_id.value == "" || formObj.partner_name.value == ""){
			ComShowCodeMessage("COM12114" ,"TP ID",'','');
			return false;		   
		}
		return true;
	}
	
	function getPartnerName(){
		var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        /*******************************************************/
        var formObj=document.form;
        if(formObj.partner_id.value == "" ){
        	ComShowCodeMessage("COM12114" ,"TP ID",'','');
        	return false;		   
        }
		doActionIBSheet(sheetObject,formObj,SEARCH01);
	}
	
	function changeSelect(gubun) {
		var frm=document.form;
	}
	
	function selectType() {
		var frm=document.form;
        var ts_type=frm.ts_type.value;
	    var param='?&ts_type='+ts_type;
	}
	
	var portInd='';
	function selectPort(frm, pt){
		portInd=pt;
		var param='';
		if(pt == 'POR') param='?loc_cd='+frm.por_port_cd.value;
		if(pt == 'POL') param='?loc_cd='+frm.pol_port_cd.value;
		if(pt == 'POD') param='?loc_cd='+frm.pod_port_cd.value;
		if(pt == 'DEL') param='?loc_cd='+frm.del_port_cd.value;
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 770,500, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1',true );
	}
	
	function getCOM_ENS_051(rArray) {
		var cArray=rArray [0];
		var frm=document.form;
		if(portInd == 'POR'){
			frm.por_port_cd.value=cArray[3];
		}		
		if(portInd == 'POL'){
			frm.pol_port_cd.value=cArray[3];
		}
		if(portInd == 'POD'){
			frm.pod_port_cd.value=cArray[3];
		}
		if(portInd == 'DEL'){
			frm.del_port_cd.value=cArray[3];
		}		
	}
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
//		if (errMsg == "" || errMsg == undefined) {
//			ComShowCodeMessage("COM132601");
//		}
	}
	function openLocPopUp2(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
            locState, locEqOfc, locPortInd, sysCode){
		portInd=locCd;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "conti_cd",     contiCd) ;
	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
	param += getURLParam(multi, "cnt_cd",       cntCd) ;
	param += getURLParam(multi, "loc_state",    locState) ;
	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
	param += getURLParam(multi, "loc_cd",       locCd) ;
	param += getURLParam(multi, "loc_desc",     locDesc) ;
	param += getURLParam(multi, "loc_port_ind", locPortInd) ;
	
	ComOpenPopup('/opuscntr/ESD_SCE_0109.do' + param, 800, 600, 'setValFromLocPop', display,true) ;
	contiCdFld    = contiCd ;
	scontiCdFld   = scontiCd ;
	cntCdFld      = cntCd ;
	locStateFld   = locState ;
	locEqOfcFld   = locEqOfc ;
	locCdFld      = locCd ;
	locDescFld    = locDesc ;
	locPortIndFld = locPortInd ;
	sysCodeFld    = sysCode ;
	multiChkYN    = multi
	}
	
	function addLocCdNo(locCd){
		var frm = document.form;
		if(portInd == 'por_port_cd') frm.por_port_cd.value = locCd;
		if(portInd == 'pol_port_cd') frm.pol_port_cd.value = locCd;
		if(portInd == 'pod_port_cd') frm.pod_port_cd.value = locCd;
		if(portInd == 'del_port_cd') frm.del_port_cd.value = locCd;
	}
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	} 