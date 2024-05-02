/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0111.js
*@FileTitle : Hanger Rack/Bar History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var sheetCnt=0;
// Global variable
var pageNo=1 ;
var sheetObjects=new Array();
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}	
//Event handler processing by button name */
function processButtonClick(){
	/***** Setting variable over two sheet at tab *****/
     var sheetObject=sheetObjects[0];
     //var sheetObject1 = sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
          //if(srcName != null && !isEmpty2(srcName)) {
           //   var btnDis  = eval("formObject."+srcName+".disabled");
          //    if (btnDis) return;
          //}
        /****************************
         enterKey 처리
        *****************************/
        var srcObj=window.event.srcElement.nodeName;
        var keyObj=window.event.keyCode;
        if(srcObj =='INPUT' && keyObj ==13) {
            srcName='btn_retrieve';
//            showErrMessage(srcName+':srcName')
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
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
	    	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				}
    	        break;
    	    case "btn_add":
    	        doActionIBSheet(sheetObject,formObject,IBINSERT);
    	        break;        	        
/*
       	    case "btn_save_partner":
    	        doActionIBSheet(sheetObject,formObject, MULTI01);
    	        break;         	        
*/
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
			case "no_use_flag":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;				
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			//showErrMessage("Error Message");
		} else {
			//showErrMessage(e);
		}
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
    	//changing initializing function name
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
      //adding last function name
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    /*
	if(CRUD == "R") {
	    bntImgEnable(document.form.btn_save, false);
	    //bntImgEnable(document.form.btn_auto, false);
	    bntImgEnable(document.form.btn_downexcel, false);
	   // bntImgEnable(document.form.btn_manu, false);
	    //bntImgEnable(document.form.btn_multi, false);
	    bntImgEnable(document.form.btn_loadexcel, false);
	}
	*/
}
/* initControl() */
        function initControl() {
        	//axon_event.addListenerFormat('blur',     'obj_blur',  	 form);
        	//axon_event.addListenerFormat('focus',    'obj_focus', 	 form);
        	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	axon_event.addListenerFormat('keyup', 	 'obj_keyup', 	 form);
        }
        /**
         * handling process for input validation
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
         * handling process for input validation
         */
        function obj_keyup(){
        	var formObj=document.form;
         	obj=event.srcElement;
         	if(obj.dataformat == null) return;
         	window.defaultStatus=obj.dataformat;
         	switch(obj.dataformat) {
         	    case "engup":
         	    /*
         	        if(document.form.vsl_cd.value.length == 4 ){
         	        	//loc_cd_onchange();
        	    		formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT         	    		var sXml=sheetObjects[2].GetSearchData("VOP_OPF_0003GS.do", SceFrmQryString(formObj));
        	    		var sVslEngNm=ComGetEtcData(sXml, "vsl_eng_nm");
        	    		if(sVslEngNm=="null" || sVslEngNm==null || sVslEngNm==""){
        	    			formObj.vsl_eng_nm.value="";
        	    		}else{
        	    			formObj.vsl_eng_nm.value=sVslEngNm;
        	    		}
         	        }
         	        break;
         	        */
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
           var HeadTitle="SEQ|No \nUse|STS|POR|POL|1st T/S|2nd T/S|3rd T/S|POD|DEL|Ocean\n Flag|C.Date|C.User|No Use.\nDate|No Use.\nUser";
           var HeadTitle1="SEQ|No \nUse|STS|POR|POL|Port|Port|Port|POD|DEL|Ocean\n Flag|C.Date|C.User|No Use.\nDate|No Use.\nUser";

           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:0 } );

           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
           var headers = [ { Text:HeadTitle, Align:"Center"},
                       { Text:HeadTitle1, Align:"Center"} ];
           InitHeaders(headers, info);

           var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sSeq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                  {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sCheck",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:1 },
                  {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                  {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ocean_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"use_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnl_use_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
            
           InitColumns(cols);

           SetEditable(1);
           SetColProperty("ocean_flag", {ComboText:"Standard|Guide|Manual", ComboCode:"|S|G|M"} );
           SetColProperty("cre_dt", {Format:"####-##-## ##:##"} );
           SetColProperty("upd_dt", {Format:"####-##-## ##:##"} );
           //InitDataCombo (0, "ocean_flag", " |Standard|Guide|Manual", " |S|G|M", "Standard");
       	
                 //conversion of function[check again]CLT 				 InitDataValid(0, "por_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "pol_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "n2nd_pol_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "n3rd_pol_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "n4th_pol_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "pod_cd", vtEngUpOnly);
           //conversion of function[check again]CLT 				 InitDataValid(0, "del_cd", vtEngUpOnly);
	       SetColProperty(0 ,"por_cd" , 	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"pol_cd" , 	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"n2nd_pol_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"n3rd_pol_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"n4th_pol_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"pod_cd" , 	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
		   SetColProperty(0 ,"del_cd" , 	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
           SetRangeBackColor(1, 5, 1, 9,"#555555");
           SetHeaderRowHeight(20 );
//         SetSheetHeight(260);
           resizeSheet();
           }


             break;
     }
 }
 // setting process of the sheet
   function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
       switch(sAction) {
          case IBSEARCH:      //retrieving
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(!mandatoryChk(formObj)) break;
				if(!ComChkRequired(formObj)) return;
				formObj.f_cmd.value=SEARCH;
				//alert(SceFrmQryString(formObj));
				sheetObj.DoSearch("ESD_SCE_0121GS.do", SceFrmQryString(formObj) );
				break;
           case IBSAVE:        //saving
        	   if(!validateForm(sheetObj,formObj,sAction)) return;
               formObj.f_cmd.value=MULTI;
               //alert(SceFrmQryString(formObj));
               sheetObj.DoSave("ESD_SCE_0121GS.do", SceFrmQryString(formObj));
               formObj.f_cmd.value=SEARCH;
               sheetObj.DoSearch4Post("ESD_SCE_0121GS.do", SceFrmQryString(formObj) );
               break;
          case IBINSERT:      // input
      			sheetObj.DataInsert(-1);
				break;
          case IBDOWNEXCEL:        //download to excel
        	  sheetObj.Down2Excel({ CheckBoxOnValue:'Y',KeyFieldMark:false,AutoSizeColumn:true,Merge:true,HiddenColumn:true});
				break;
          case SEARCH01:
				document.getElementById('partner_id').value=document.getElementById('partner_id').value.toUpperCase();
                sheetObj.ShowDebugMsg(false);
              	formObj.f_cmd.value=SEARCH01; 
              	//sheetObj.DoSearch("ESD_SCE_120GS.do",SceFrmQryString(formObj));
              	var sXml=sheetObj.GetSearchData("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
        	    var partner_name=ComGetEtcData(sXml, "partner_name");
              	//var partner_name = sheetObj.EtcData("partner_name");
                document.getElementById('partner_name').value=partner_name;
                ComEtcDataToForm(formObj,sheetObj) ;            
                sheetObj.RemoveAll();
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
      		case IBSAVE:
       		   if(formObj.partner_id.value == ""){
      	           ComShowCodeMessage("COM12114" ,"TP ID",'','');
      	           return false;		   
      		   }
      		   if(formObj.partner_name.value == ""){
      	           ComShowCodeMessage("COM12114" ,"TP NAME",'','');
      	           return false;		   
      		   } 
      		   //grid의 validation check
      		   //
      		   var rowCnt=sheetObj.Rows;
      		   var startRow=2;
      		   for(var i=startRow; i<rowCnt; i++){
      			   var rowStatus=sheetObj.GetRowStatus(i);
      			   var checkRow=i - 1;  
      			   if(rowStatus == 'I'){
      				   if(sheetObj.GetCellValue(i, "n4th_pol_cd")!= '' ){
      					   if(sheetObj.GetCellValue(i, "n2nd_pol_cd")== ''){
         						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"1st T/S Port",'');
         						  sheetObj.SelectCell(i, "n2nd_pol_cd");
         						  return false;
       					  }
      					   if(sheetObj.GetCellValue(i, "n3rd_pol_cd")== ''){
         						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"2nd T/S Port",'');
         						  sheetObj.SelectCell(i, "n3rd_pol_cd");
          					  return false;
       					  }    					  
       				   }   
      				   if(sheetObj.GetCellValue(i, "n3rd_pol_cd") != '' ){
      					   if(sheetObj.GetCellValue(i, "n2nd_pol_cd")== ''){
        						  ComShowCodeMessage("COM12130" ,'['+checkRow+'] row',"1st T/S Port",'');
        						  sheetObj.SelectCell(i, "n2nd_pol_cd");
        						  return false;
      					  }
      				   }        				   
      			   }//End of if
      			  // sheetObj.CellValue(i, "por_cd")== sheetObj.CellValue(i, "por_cd").toUpperCase();
      		   }//End of for
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
		var val=frm.select1[frm.select1.selectedIndex].value;
		frm.ts_type.value=val; 
	}
	function selectType() {
	    var frm=document.form;
        var ts_type=frm.ts_type.value;
	    var param='?&ts_type='+ts_type;
       //comPopup('/opuscntr/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1");
	}
	var portInd='';
	function selectPort(frm, pt){
		portInd=pt;
		var param='';
		if(pt == 'POR') param='?loc_cd='+frm.por_port_cd.value;
		if(pt == 'POL') param='?loc_cd='+frm.pol_port_cd.value;
		if(pt == 'POD') param='?loc_cd='+frm.pod_port_cd.value;
		if(pt == 'DEL') param='?loc_cd='+frm.del_port_cd.value;
		//ComShowCodeMessage("o param : " + param);
//		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1');
		comPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	function setValFromLocPop(rArray) {
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
	function sheet1_OnChange(sheetObj,Row,Col,Value){
	    sheetObj.SetCellValue(Row,Col,Value.toUpperCase(),0);
//	    var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
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
	ComOpenPopup('/opuscntr/ESD_SCE_0109.do' + param, 800, 600, 'setValFromLocPop2', display,true) ;
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