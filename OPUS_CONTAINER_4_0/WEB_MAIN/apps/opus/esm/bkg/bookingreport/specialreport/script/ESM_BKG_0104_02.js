/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0104_02.js
*@FileTitle  : Report Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/*
 * variable for handling  the initial value
 * */
var arrFormElementMap={ in_out_cd:'radio',   vps_eta_dt:'input',  vps_etd_dt:'input', vvd_cd:'input',      por_cd:'input',
													pol_cd:'input',      pol_yard_cd:'input', pod_cd:'input',     pod_yard_cd:'input', del_cd:'input',   
													eq_ofc_cd:'input',   sc_no:'input',       cust_tp_cd:'combo', cust_cnt_cd:'input', cust_seq:'input', 
													cust_nm:'input',     edi_id:'input',      edi_gr_cd:'input',  gdi_gr_nm:'input'  , gcust:'input',
													sp_cargo_rf:'check', sp_cargo_dg:'check', sp_cargo_ak:'check',sp_cargo_bb:'check', credit:'input'
                        }
 // Common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="";//IBSheet Delimiter
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt=0;
 var comboObjects=new Array();
 var b_staff_idMultiComboDataAdded=false;
 var l_rep_idMultiComboDataAdded=false;
   /*********************** EDTITABLE MULIT COMBO END ********************/
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
      * ComComboObject called from the constructor method
	 	 	* param : comboObj ==> Combo Object
	 	 	* 
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
		      //MultiCombo initialization
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    //setItemOptionHidden();//Item Option Hidden 
		    initControl();
		     if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
            	ComBtnDisable("btn_New");
		     }
		    //for multi combo gives 0.1 seconds for the delay
		    setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH03); },100);
     }
	/**
	 	 * The default setting Combo
	 	 * param : comboObj ==> Combo Object, comboNo ==> Combo Object Id + serial number
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject=document.form
 				initComboEditable(comboObj, comboId)
	 	}
 	 //Multi Select Combo initial setup
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
		 	 		SetMultiSelect(0);
		 	 		SetUseAutoComplete(1);
			 	  SetUseEdit(0);
			 	  if(comboId == "cust_tp_cd" ){
//no support[check again]CLT 				 	  ColCnt=2;
				 	  SetColBackColor(1,"255,255,255");
			 	  }
	 	 	}
 	 }
    function initControl() {
    	var formObject=document.form;
       // axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- When typing the keyboard
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out  focus 
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- in  focus 
       // axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
/*********************** KEY EVENT START ********************/ 	 
//	function bkg_keypress(){
//	    switch(ComGetEvent().dataformat){
//	    	case "ymd":
//	        //number
//	        ComKeyOnlyNumber(ComGetEvent(), "-");
//	        break;
//	    	case "engup":
//	        //English uppercase characters
//    			ComKeyOnlyAlphabet('upper');
//	        break;
//	      case "engupnum":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('uppernum');
//	        break;
//	      case "num":
//	        //Numeric input
//	        ComKeyOnlyNumber(ComGetEvent());
//	        break;	       
//	      case "gcust": 
//	      ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
//	      break;	             
//	      default:
//	    }
//	}  
	  /**
     * HTML Control  onBlur Event.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "vps_eta_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "vps_etd_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * The onFocus event in HTML Control Validation Check. <br>
	 **/
	function bkg_focus(){
		//Input Validation to check
		switch(ComGetEvent().name){	
	    	case "vps_eta_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
			default:
					break;
		}
	}  
/*********************** KEY EVENT END ********************/
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;
		var tempSqlCon="";
		var nullMultiComboStr="<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
 	// Event handler processing by button name */
     function processButtonClick(){
          /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_Save":
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 				case "btn_OK":
		 					if (!opener) opener=window.dialogArguments;
		 				    if(!opener) opener=parent;
		 				    
		 					opener.setSearchOption(getValidCondition(FormQueryString(formObject)));
		 					ComClosePopup(); 
		 					break;
		 				case "btn_Set":
		 					setCondition(tempSqlCon);
		 					break;
		 				case "btn_New":
		 					initAll(formObject);
		 					//sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_Close":
		 					ComClosePopup(); 
		 					break;
		 				case "btn_commodity_pop": 		
							comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
							break;		 								
		 				case "btn_ctr_fra_pop": 		
							var param="?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
	 						ComOpenPopup('/opuscntr/COM_ENS_021.do'+param, 780, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;		 								
		 				case "btn_customer_pop":
		 				  var param="" ;
		 				  param="?cust_cd="+formObject.cust_cnt_cd.value;
		 				  if(formObject.cust_seq.value != ""){
		 				  	param += eval(formObject.cust_seq.value);
		 				  }
		 				  param += "&cust_nm="+formObject.cust_nm.value;	
	 						ComOpenPopup('/opuscntr/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;
						case "btn_Edi_Id":
		 				  var param="?grp_id="+formObject.edi_id.value;
		 				  param += "&edi_id="+formObject.edi_gr_cd.value;
		 				  param += "&grp_nm="+formObject.edi_gr_nm.value;
	 						ComOpenPopup('/opuscntr/ESM_BKG_1073.do'+param, 800, 380, 'setEdiId', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"Edi_pop");
							break;		
						case "in_out_cd":
		 					if(formObject.in_out_cd[0].checked){
		 							eta_id.innerHTML="ETA";
		 					}else{
		 							eta_id.innerHTML="ETD";
		 					}
						 	break;			
						case "btn_eta_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.vps_eta_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
						 	break;
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e.message);
		    		}
	     	}
    }
   // Sheet handling process
     var arrMultiCombo;//Multi-combo setting variable
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case SEARCH03:      //Retrieve
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH03;
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
							arrMultiCombo=sXml.split("|$$|");	
							console.log(sXml);
							initAll(formObj);
							console.log(report_type.GetSelectIndex());
							initReportType();
							console.log(report_type.GetSelectIndex());
						  setCondition(report_type.GetSelectCode());
						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
							break;
			 			case SEARCH02:      //Staff List retrieve
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH02;
							var p_ofc_cd="";
							if(subGubun =="b_ofc_cd"){
								p_ofc_cd=formObj.b_ofc_cd.value;
							}else if(subGubun =="l_ofc_cd"){
								p_ofc_cd=formObj.l_ofc_cd.value;
							}
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd);
							if(subGubun =="b_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.b_staff_id, "usr_id", "usr_id");
							}else if(subGubun =="l_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.l_rep_id, "usr_id", "usr_id");
							}
							break;
 						case IBSEARCHAPPEND:  // Retrieve paging
						case IBINSERT:      // Insert					
							sheetObj.DataInsert(-1);
							break;
			    }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	return true;
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.p_pod_cd)) {
	     					ComShowCodeMessage('BKG00626','POD Code');
	     					return false;
			  	}
	    		if (formObj.p_pod_cd.value.length !=5) {
	     					ComShowCodeMessage('BKG95018','POD Code','5');
	     					return false;
			  	}
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
	 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
   function initSheet(sheetObj,sheetNo) {}
/*############################# combo onchage start ########################*/
/**
	 * Check if the value entered in MultiCombo int added
	 * After changes to the English uppercase input value re-input
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		initAll(document.form);
		setCondition(newCode);
	}
/*############################# combo onchage end ########################*/		
	var paramReportName="";
	var paramReportIndex="";
	
	/*
	 * Values ​​of conditions all initialization 
	 * */
	function initAll(formObject){
		form.reset();
		ComXml2ComboItem(arrMultiCombo[0], cust_tp_cd, "val", "val|name");
	}
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[1], report_type, "bzc_cond_sql_ctnt", "rpt_nm");
//	  var arr=ComBkgXml2Array(arrMultiCombo[1], "rpt_nm");
//	  var chkRptTypeFlg=false;
//	  for(var index=0; index < report_type.GetItemCount(); index++) {
//	  	if(report_type.GetText(i,1) == paramReportName){
//	  		chkRptTypeFlg=true;
//	  		report_type.SetSelectIndex(index);
//	  	}
//	  }
//	  if(!chkRptTypeFlg){
//	  	report_type.SetSelectText(0,false);
//	  }
		
		//alert("js==>"+paramReportIndex);
		report_type.SetSelectIndex(Number(paramReportIndex));
		
	}
    /**
     * condition setting
     */ 
  function setCondition(sqlCtnt){
	  if(ComIsNull(sqlCtnt)){
		  return;
	  }
  	var arrSqlCtnt=sqlCtnt.URLDecode().split("|");
   	var formNameValue ; 
  	var field;
  	try{
	   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
	   		
	   			formNameValue=arrSqlCtnt[i].split("=");
	   			if(formNameValue[1] =="") continue;
	   			if(arrFormElementMap[formNameValue[0]] == "check"){
						eval("form."+formNameValue[0]).checked=true;
					}else if(arrFormElementMap[formNameValue[0]] == "radio"){
						field=eval("form."+formNameValue[0]);
							for(var j=0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].checked=true;
									break;
								}
							}
					}else if(arrFormElementMap[formNameValue[0]] == "select"){
						field=eval("form."+formNameValue[0]);
							for(var j=0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].selected=true;
									break;
								}
							}
					}else if(arrFormElementMap[formNameValue[0]] == "combo"){
						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else if(arrFormElementMap[formNameValue[0]] == "multi"){
						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else{
						field=eval("form."+formNameValue[0]);
					  field.value=formNameValue[1];
	   			}
	   	}//end for
  	}catch(e){}
  		if(form.in_out_cd[0].checked){
		 			eta_id.innerHTML="ETA";
			}else{
					eta_id.innerHTML="ETD";
			}
  }
		/*
		 * setting Customer search results
		 * */
		function setCustomer(val){
				var c_cd=val[0][3];
				var c_name=val[0][4];
				form.cust_cnt_cd.value=c_cd.substring(0,2);
				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
				form.cust_nm.value=c_name;
		} 
			/*
		 * setting  EDI ID search results 
		 * */
		function setEdiId(val){
				form.edi_id.value=val[0][3];
				form.edi_gr_cd.value=val[0][4];
				form.edi_gr_nm.value=val[0][5];
		}
		 /**
		 * Search  Code for Input in Commodity Code   .<br>
		 * @param {arry} aryPopupData
		 */
		function setCallBack0653(aryPopupData) {
			var formObject=document.form;
			formObject.cmdt_cd.value=aryPopupData[0][3];
			//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
			formObject.cmdt_nm.value=aryPopupData[0][4];
		}
	/**
  * Removal of the conditions  without value. 
  */ 
  function getValidCondition(sql){
  	var arrSqlCtnt=sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql=""; 
   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue=arrSqlCtnt[i].split("=");
   			if(formNameValue[1] == undefined || formNameValue[1] == "") continue;
   			returnSql += formNameValue[0]+"="+formNameValue[1].URLEncode()+"|";
   	}//end for
   	return returnSql;
  }
