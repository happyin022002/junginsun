/*=========================================================
 * Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1702.js
 *@FileTitle : Booking Status Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/01/14
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/			 
	/* global variable */
	var selectedGridCols;	
	var sheetObjects=new Array();
	var sheetCnt=0;
	var IBSEARCH01=29;
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	/*********************** EDTITABLE MULIT COMBO END ********************/
	/*********************** TAB START ********************/
//	var tabObjects=new Array();			//::: tab 주석
//	var tabCnt=0 ;						//::: tab 주석
	/*********************** TAB START ********************/
	var arrMultiCombo;// variable to set multi combo 
	var orderby=""; 
 
	/* init */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setComboObject(combo_obj){
		 comboObjects[comboCnt++]=combo_obj;
	}	
    function loadPage() {		
		loadingMode=true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for (i=0; i < sheetObjects.length; i++) {			
		    ComConfigSheet(sheetObjects[i]);
		    initSheet(sheetObjects[i], i + 1);
		    ComEndConfigSheet(sheetObjects[i]);
		}		
// 	    for(k=0;k<tabObjects.length;k++){				//::: tab 주석
// 	    	initTab(tabObjects[k],k+1);
// 	    	tabObjects[k].SetSelectedIndex(0);
// 	    }		
		loadingMode=false;
		
		initControl();
    }
    function initCombo(comboObj, comboId) {
		with(comboObj) {
	    	switch(comboObj.options.id) {
	        	case "r_term":
	        	case "d_term":	
//	        	case "cust_tp_cd":
        			SetMultiSelect(1);
        			SetMultiSeparator(",");
	        		break;
	        	case "internet_bl":
	        		RemoveAll();
	        		InsertItem(0, "", "");
	        		InsertItem(1, "Y", "Y");
	        		InsertItem(2, "N", "N");
	        		break;
	        	case "report_type":	        		
	        		SetSelectIndex(0);
	        		break;	        		
	    	}			
            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고				
		}
	} 	 
	
	/* tab */	//::: tab 주석
//    function setTabObject(tab_obj){
//        tabObjects[tabCnt++]=tab_obj;
//    }
//    function initTab(tabObj , tabNo) {
//         switch(tabNo) {
//             case 1:
//                with (tabObj) {
//                    var cnt=0 ;
//					InsertItem("Search");
//					InsertItem("Result");
//                }
//             break;
//         }
//    }    
//    function tab1_OnChange(tabObj , nItem)
//    {
//    	var beforetab=1;
//        var objs=document.all.item("tabLayer");
//	    	objs[nItem].style.display="Inline";	    	
//    	//--------------- important --------------------------//	    	
//    	for(var i = 0; i<objs.length; i++){
//    		  if(i != nItem){
//    		   objs[i].style.display="none";
//    		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//    		  }
//    		}	    
//    	//------------------------------------------------------//    	
//    	beforetab=nItem;
//    }    
/*********************** KEY EVENT START ********************/
    function initControl() {
    	axon_event.addListenerForm('keydown','bkg_keydown',document.form); 	//20150317.MOD
        
        chgMandatory();
    }
    
    /** 20150317.ADD */
    function bkg_keydown() {
        var obj=event.srcElement;
        var vKeyCode=event.keyCode;
        if ( vKeyCode == 13 ) {        	
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
        }
    }    
/*********************** KEY EVENT END ********************/
	
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;		
 	// Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
		  var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	    	try {
	     		var srcName=ComGetEvent("name");
	     		 if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {
						case "btn_Retrieve":
		 					options.innerHTML=" * Search Options ["+getSearchOptions()+"]";
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;		
		 				case "btn_Direct_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH01);
		 					break;				 					
		 				case "btn_Sort":
			 				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=CD30019", "OrderBy", 420,250,false,"scrollbars=no,resizable=yes");
		 				  break; 		 					
		 				case "btn_New":
		 					initAll(formObject);
		 					for(k=0;k<comboObjects.length;k++){
		 						initCombo(comboObjects[k],comboObjects[k].id);
		 					}
		 					chgMandatory();
		 					break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
							break;		 					
		 				case "btn_ReportTemplate": 		
	 						var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd='+formObject.p_bkg_rpt_knd_cd.value, 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
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
						//-------------------- Date Button Start
						case "btn_sail_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.sail_from_dt, formObject.sail_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_arr_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.arr_from_dt, formObject.arr_to_dt,'yyyy-MM-dd');
							break;
						case "btn_bl_prn_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bl_prn_from_dt, formObject.bl_prn_to_dt,'yyyy-MM-dd');
							break;
						case "btn_bl_srnd_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bl_srnd_from_dt, formObject.bl_srnd_to_dt,'yyyy-MM-dd');
							break;
							//-------------------- Date Button End
						//SJH.20150128.ADD
		 				case "btn_cust_grp_pop":
			 				ComOpenPopup('/opuscntr/COM_COM_0006.do', 770, 430, 'setCustGrp', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;				
						case "pol_local":
							if(formObject.pol_local.checked){
								formObject.pol_ts.checked=false;
							}
							break; 		
						case "pol_ts":
							if(formObject.pol_ts.checked){
								formObject.pol_local.checked=false;
							}
							break; 										
						case "pod_local":
							if(formObject.pod_local.checked){
								formObject.pod_ts.checked=false;
							}
							break; 		
						case "pod_ts":
							if(formObject.pod_ts.checked){
								formObject.pod_local.checked=false;
							}
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

	/***
	 * creating option of searching
	 * 점점산으로 가는.. 굳이 나눌필요가...쩝..
	 */
	function  getSearchOptions(){
		var options="";			
		var arrtitle = document.getElementsByName("arr_title");
		var arrdetail = document.getElementsByName("arr_detail");
		for (var i = 0; i < arrtitle.length; i++) {
			var objinput = arrdetail[i].getElementsByTagName("input");
			for (var u = 0; u < objinput.length; u++) {
				//CUSTOMER
				if(arrtitle[i].innerHTML == "Customer") {						
					if(objinput[u].type == "checkbox") {
						if(objinput[u].name=="cust_tp_cd_s" && objinput[u].checked) options += "Shipper"+ "  |  ";
						if(objinput[u].name=="cust_tp_cd_c" && objinput[u].checked) options += "CNT"+ "  |  ";
						if(objinput[u].name=="cust_tp_cd_n" && objinput[u].checked) options += "Notify"+ "  |  ";
						if(objinput[u].name=="cust_tp_cd_f" && objinput[u].checked) options += "Forwarder"+ "  |  ";
						if(objinput[u].name=="cust_tp_cd_a" && objinput[u].checked) options += "Also Notify"+ "  |  ";						
					} else {
						if(options.indexOf("CUSTOMER-") < 0     && objinput[u].value != "") options += "CUSTOMER-";
						if(objinput[u].name=="cust_cnt_cd"      && objinput[u].value != "") options += objinput[u].value;
					    else if(objinput[u].name=="cust_seq"    && objinput[u].value != "") options += " SEQ:"+objinput[u].value;
						else if(objinput[u].name=="cust_nm"     && objinput[u].value != "") options += " Name:"+objinput[u].value;
						else if(objinput[u].name=="cust_grp_id" && objinput[u].value != "") options += " Group:"+objinput[u].value;
						if(u==(objinput.length-1) && options.indexOf("CUSTOMER-") > -1) options +="  |  ";
					}
				//CUSTOMER외
				} else {
					if(objinput[u].value != "") {
						//DATE는 pair
						if(arrtitle[i].innerHTML.indexOf("Date") > -1) {
							if(u==0)
								options += arrtitle[i].innerHTML.substring(0,arrtitle[i].innerHTML.indexOf("Date")-1)+" From Date-"+objinput[u].value + "  |  ";
							else
								options += arrtitle[i].innerHTML.substring(0,arrtitle[i].innerHTML.indexOf("Date")-1)+" To Date-"+objinput[u].value + "  |  ";
						} else {
							//combo인 아이..
							if(objinput[u].name.indexOf("_text") > -1) options += "";
							else if(objinput[u].name.indexOf("_term") > -1) options += objinput[u].name.substring(0,1).toUpperCase()+".term-"+objinput[u].value + "  |  ";
							else if(objinput[u].name.indexOf("_yard_cd") > -1) options += "YD-"+objinput[u].value + "  |  ";
							else if(objinput[u].name=="del_cd") options += "DEL-"+objinput[u].value + "  |  ";
							else options += arrtitle[i].innerHTML+"-"+objinput[u].value + "  |  ";
						}				
					}					
				}
			}
		}
		return options.substring(0,options.length-5);
	}
	// handling of Sheet 
     
    function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        
		case IBCLEAR:			
			formObj.f_cmd.value=INIT;			
			var sXml=sheetObj.GetSearchData("ESM_BKG_1702GS.do", FormQueryString(formObj));
			arrMultiCombo=sXml.split("|$$|");	
			initAll(formObj);
			break;        
			
		case IBSEARCH:      
 				if(!validateForm(sheetObj,formObj,sAction)) {
 					options.innerHTML = "";
 					return;
 				}
//				tab1.SetSelectedIndex(1);//  changing result tab			//::: tab 주석
 				formObj.f_cmd.value=SEARCH01;
				formObj.orderby.value=orderby;
				sheetObjects[1].RemoveAll();
				
				var sXml=sheetObj.GetSearchData("ESM_BKG_1702GS.do", FormQueryString(formObj));
				var arrSXml=sXml.split("|$$|");				
				sheetObjects[0].SetWaitImageVisible(1);
				sheet1.LoadSearchData(arrSXml[0],{Sync:0} );
				sheetObjects[0].SetWaitImageVisible(0);
				
				if(ComGetEtcData(arrSXml[0], "cnt_bkg") == undefined) return;
				formObj.cnt_bkg.value			= ComGetEtcData(arrSXml[0], "cnt_bkg");				
				formObj.sum_wgt_ton.value		= ComGetEtcData(arrSXml[0], "sum_wgt_ton");
				formObj.sum_grs_mea_cbm.value	= ComGetEtcData(arrSXml[0], "sum_grs_mea_cbm");
				formObj.cnt_bl.value			= ComGetEtcData(arrSXml[0], "cnt_bl");			
				formObj.sum_cct_amt.value		= ComGetEtcData(arrSXml[0], "sum_cct_amt");     
				formObj.sum_grs_wgt_kgs.value	= ComGetEtcData(arrSXml[0], "sum_grs_wgt_kgs");
				formObj.cnt_cntr.value			= ComGetEtcData(arrSXml[0], "cnt_cntr");		
				formObj.sum_ppd_amt.value		= ComGetEtcData(arrSXml[0], "sum_ppd_amt");
				formObj.sum_net_wgt_kgs.value	= ComGetEtcData(arrSXml[0], "sum_net_wgt_kgs");
				formObj.sum_net_mea_cbm.value	= ComGetEtcData(arrSXml[0], "sum_net_mea_cbm");
				formObj.cnt_pck.value			= ComGetEtcData(arrSXml[0], "cnt_pck");		 
				formObj.sum_wgt_lbs.value		= ComGetEtcData(arrSXml[0], "sum_wgt_lbs");
			break;	
			
		case IBSEARCH01:
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH02;
			if(orderby==""){
				formObj.orderby.value="BKG_NO";		//@@@ 기본ORDER BY
			}else{
				formObj.orderby.value=orderby;
			}	
			formObj.target="_top";
            formObj.action="ESM_BKG_1702DL.do?"+FormQueryString(formObj);
            formObj.submit();
            sheetObj.RemoveEtcData(); // Delete ETC data
            break;			
			
		case IBDOWNEXCEL:	// Excell download
           	if(sheetObj.RowCount() < 1){//no data	
           		ComShowCodeMessage("COM132501");
           	}
           	sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, HiddenColumn:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;			
	    }
     }
			
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    		case IBSEARCH01:
    			if (!ComIsNull(formObj.vvd_cd)) {
    				return true;
    			}else if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.sail_from_dt) ||  ComIsNull(formObj.sail_to_dt)) 
					  && (ComIsNull(formObj.arr_from_dt) ||  ComIsNull(formObj.arr_to_dt)) ) {
 					ComShowCodeMessage('BKG00626','VVD or Sail Date or Arrival Date');
 					formObj.vvd_cd.focus();
 					return false;    
    			}else if ((formObj.rdo_in_out[0].checked && (ComIsNull(formObj.sail_from_dt) ||  ComIsNull(formObj.sail_to_dt))) 
  					   || (formObj.rdo_in_out[1].checked && (ComIsNull(formObj.arr_from_dt) ||  ComIsNull(formObj.arr_to_dt))) ) {
    				var chkMsg = "";
    				if(formObj.rdo2_1.checked) chkMsg = 'If you select Outbound You must enter Sail date and POL.';
    				else chkMsg = 'If you select Inbound You must enter Arrival date and POD.';
   					ComShowCodeMessage('BKG00627',chkMsg);
   					if(formObj.rdo2_1.checked) formObj.sail_from_dt.focus();
   					else formObj.arr_from_dt.focus();
   					return false;     					
	    		}else if (((!ComIsNull(formObj.sail_from_dt) && !ComIsNull(formObj.sail_to_dt)) || 
        			    (!ComIsNull(formObj.arr_from_dt) && !ComIsNull(formObj.arr_to_dt))) &&
                        ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd )) {
	    			if(formObj.rdo2_1.checked) {
	    				ComShowCodeMessage('BKG00104','POL');
	    				formObj.pol_cd.focus();
	    			} else {
	    				ComShowCodeMessage('BKG00104','POD');
	    				formObj.pod_cd.focus();
	    			}
	    			return false;
			  	}
    			// maximum 1 month
                if(ComIsNull(formObj.vvd_cd) && (!ComIsNull(formObj.sail_from_dt) && !ComIsNull(formObj.sail_to_dt)) && 
                  !ComBkgMonthsBetweenCheck(formObj.sail_from_dt.value,formObj.sail_to_dt.value, "1")){
                    ComShowCodeMessage('COM132001','Sail Date','1Month');
                    ComSetFocus(formObj.sail_to_dt);
                    return false;
                }
    			// maximum 1 month
                if(ComIsNull(formObj.vvd_cd) && (!ComIsNull(formObj.arr_from_dt) && !ComIsNull(formObj.arr_to_dt)) && 
                  !ComBkgMonthsBetweenCheck(formObj.arr_from_dt.value,formObj.arr_to_dt.value, "1")){
                    ComShowCodeMessage('COM132001','Arrival Date','1Month');
                    ComSetFocus(formObj.arr_to_dt);
                    return false;
                } 
//	    		if( ComIsNull(formObj.vvd_cd) && ComGetDaysBetween(formObj.sail_from_dt.value,formObj.sail_to_dt.value) +1 > 7){
//	    			ComShowCodeMessage('COM132001','Sail Date','7Days');
//	    			formObj.sail_to_dt.focus();
//	    			return false;
//	    		}
//	    		if( ComIsNull(formObj.vvd_cd) &&  ComGetDaysBetween(formObj.arr_from_dt.value,formObj.arr_to_dt.value) +1 > 7){
//	    			ComShowCodeMessage('COM132001','Arrival Date','7Days');
//	    			formObj.arr_to_dt.focus();
//	    			return false;
//	    		}	
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
/*############################# combo onchage start ########################*/
     /**
 	 *  2015.03.02.MOD
 	 */
 	function report_type_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
 		if(rptIdArr != null){
 			document.form.rpt_id.value = rptIdArr[newindex];
 		}
 	}   	 
/*############################# combo onchage end ########################*/		
	/*
	 *  initializing all condition
	 * */
 	var rptIdArr;
	function initAll(formObject){
		//Tab1, Tab2
		formObject.reset();
		ComXml2ComboItem(arrMultiCombo[0], report_type, 	"sql_ctnt_col_nm", "rpt_nm");
		var arr=ComBkgXml2Array(arrMultiCombo[0], "rpt_nm");
		if(arr == undefined) return;		
		var rptIdStr = ComXml2ComboString(arrMultiCombo[0], "rpt_id", "rpt_id")[0];
		rptIdArr = rptIdStr.split("|");
		
		ComXml2ComboItem(arrMultiCombo[1], dir_cd,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[2], r_term,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[3], d_term,      	"val", "val");
		ComXml2ComboItem(arrMultiCombo[4], cgo_rlse_sts_cd, "val", "name");
		ComXml2ComboItem(arrMultiCombo[5], crr_cd,    		"crr_cd", "crr_cd");
		ComXml2ComboItem(arrMultiCombo[6], bl_sts_cd,     	"val", "name");
		ComXml2ComboItem(arrMultiCombo[7], bl_tp_cd,  		"val", "name");
//		ComXml2ComboItem(arrMultiCombo[8], cust_tp_cd,  	"val", "val");
		//Tab2
		for (var i=0; i < sheetObjects.length; i++) {			
		    sheetObjects[i].RemoveAll();
		}
	}    
	/*
	 * method which is setting the result of Customer
	 * */
	function setCustomer(val){
		var c_cd=val[0][3];
		var c_name=val[0][4];
		form.cust_cnt_cd.value=c_cd.substring(0,2);
		form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
		form.cust_nm.value=c_name;
	} 
	/*
	 * SJH.20150128.ADD
	 * */
	function setCustGrp(val){
		form.cust_grp_id.value=val[0][2];
	}		
	/**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo,ColList) {
    	    sheetObj.UseUtf8=true;
    	    var cnt=0;
    	    switch(sheetObj.id) {
    	    	case "sheet1":
    	        	initSheetDynamic(sheetObjects[0],"");	
    	            break;
    			case "search_options":
			        with(sheetObj){			
						  var HeadTitle1="Search Options";
						  var headCount=ComCountHeadTitle(HeadTitle1);
						
						  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						  InitHeaders(headers, info);
						
						  var cols = [ {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"search_options" } ];
						   
						  InitColumns(cols);						
						  SetEditable(0);
						  SetCountPosition(0);//[1/3]page
						  SetSheetHeight(100);
			
	                    }
					break;    	            
    	    }
     }     
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets				//나중 다시 추가되면 변경가능성 @@@
      */
     function initSheetDynamic(sheetObj, ColList) { 
     	var sheetNo = parseInt(sheetObj.id.charAt(sheetObj.id.length-1))-1;
    	sheetObjects[sheetNo] = sheetObjects[sheetNo].Reset();
    	sheetObj = sheetObjects[sheetNo];
     	  
        if(report_type.GetSelectText()== "General" || ColList ==""){
		      with(sheetObj){	
		    	  var HeadTitle1="BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|BKG & B/L Info|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Cargo & Commodity|Charge|Charge|Charge|Charge|Charge|Charge|Container|Container|Container|Container|Container|Customer|Customer|Customer|Customer|Customer|Customer|Customer|Customer|Customer|Customer|Customer|Inbound Info|Inbound Info|Inbound Info|Inbound Info|Rate & Invoice|Reference No|Reference No|Reference No|Reference No|Reference No|Reference No|Reference No|Reference No|Reference No|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|Route & Schedule|TEMP";
		    	  var HeadTitle2="B/L Controller|B/L No.|B/L Print Date|B/L Status|B/L Surrender Date|B/L Type|B/L Type (KOR)|BKG No.|Capturing OFC|Cargo Received Date|Cargo Release Status|Carrier|Cleared By|Date Final B/L released to internet|Date of Issue|House B/L No.|House B/L SCAC Code|On Board Date|Original B/L Release Status|Partial Shipment|Release OFC (From B/L)|Release OFC (From BKG)|Sales OFC|Sales Region|Sales Rep|SCAC Code|SI Received Date/Time|Surrender OFC|Cargo Desc|Cargo Nature|Cargo WGT|GRS MEA Unit|GRS WGT|GRS WGT Unit|HS Code|HS Desc|Net MEA|Net MEA Unit|Net WGT|Net WGT Unit|No. of PKG|PKG Type|Short Desc|Tare WGT|Total Cargo WGT|CCT FRT CURR|CCT FRT Total|IB Exchange Rate Date|OB Exchange Rate Date |PPD FRT CURR|PPD FRT Total|CNTR No.|CNTR Size|CNTR Status|CNTR Type|Seal No.|1st NTFY Party|2nd NTFY Party|3rd NTFY Party|Consignee|FWDR|FWDR Contact Name|FWDR Contact No.|Internet B/L Flag|SHPR|SHPR Contact Name|SHPR Contact No.|Cargo Release Status|IB Control Office |IB Door Delivery Setup|IB Freighting Setup|Tariff Code|Customs Declaration Type|Customs IT/TE/IE #|Customs Ref. No.|Customs Required|Customs System Ready|Customs User Ready|Export License #|MRN No. |Status Remarks / I.T. #|1st POD ETA|1st POD ETD|1st POL ETA|1st POL ETD|1st VVD|2nd VVD|3rd VVD|4th VVD|ATA (LAST)|ATA (TRUNK)|ATD (FIRST)|ATD (TRUNK)|B/L Direction|B/L Service|B/L Vessel|B/L Voyage|B/L VVD|Berth at First POL|Berth at Last POD|Block Stowage|DEL ATA|DEL Code|DEL Country|DEL ETA|DEL Name|Dest Service Mode|Discharging at T/S Port|Final Destination Name|Final POD ETA|Final POD ETD|Final POL ETA|Final POL ETD|IB Voyage Control|Lane|Last Discharge VVD|OB Voyage Control|OB-IB Haulage Type|Origin Service Mode|POD (BKG)|POD (LAST)|POD (Vessel)|POD ATAIC Date|POD Code|POD ETA|POD ETB|POD Name|POL (BKG)|POL (Vessel)|POL Code|POL Cut-Off Date|POL ETD|POL Name|POR Code|POR Country|POR Name|Post 1.VVD|Post 2.VVD|Post 3.VVD|Post 4.VVD|Post Relay Port|Post Vessel|Post VVD|Pre 1. POD|Pre 1. POL|Pre 1.VVD|Pre 2. POD|Pre 2. POL|Pre 2.VVD|Pre 3. POD|Pre 3. POL|Pre 3.VVD|Pre 4. POD|Pre 4. POL|Pre 4.VVD|Pre Relay Port|Pre Vessel|Pre VVD|R/D Term|T/S Port 1|T/S Port 2|T/S Port 3|T/VVD|Trade |Traffic Mode|Trunk Lane|Trunk POD|Trunk POD ETA|Trunk POD ETD|Trunk POL|Trunk POL ETA|Trunk Vessel|Trunk VVD|Vessel Name|TEMP";			    	  
		    	  
		    	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
				  var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				  InitHeaders(headers, info);            
	              
				      var cols=[ {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"doc_usr_id",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",               	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_prt_dt",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"srd_dt",              	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"kr_cstms_cust_tp_cd", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"capt_ofc",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"crd",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cgo_rlse_sts",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"scac_nm",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"clr_by",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"obl_inet_prn_dt",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_dt",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"hbl_no",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nvocc_co_scac_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_dt",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"obl_rlse_flg",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"split_flg",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_ofc_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_iss_ofc_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_ofc_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_rgn_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"scac_cd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"si_dt",               	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"srd_ofc",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_nm",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cgo_nature",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"act_wgt",             	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",             	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt_ut_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_hs_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"hamo_cd_desc",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nt_meas_qty",         	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nt_meas_ut_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nt_wgt_qty",          	KeyField:0,   CalcLogic:"",   Format:"",      		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nt_wgt_ut_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",             	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"st_cmdt_nm",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"tare_wgt",            	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"act_tot_wgt",          KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"col_curr_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cct_ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ib_xch_rt_dt",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ob_xch_rt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cpt_ttl_amt",         	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sz",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"nf_cust_nm",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"an_cust_nm",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_ntfy_pty",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cn_cust_nm",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ff_cust_nm",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ff_cntc_pson_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"fw_cntc_num",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"obl_inet_flg",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"sh_cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"sh_cntc_pson_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"sh_cntc_num",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rlse_sts_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ib_ctrl_ofc",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"troi",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ib_frh_flg",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trf_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ibd_trsp_tp_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"crn",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cstms_req",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cstms_sys_rdy",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cstms_usr_rdy",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"xpt_lic_no",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_ref_no",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ibd_trsp_no",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_eta",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_etd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pol_eta",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pol_etd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd_1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd_2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd_3",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd_4",               	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_pod_ata",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pod_ata",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_atd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pol_ata",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_slan_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_vvd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pol_etb",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_pod_etb",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"del_ata",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"del_cnt_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"del_eta",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"del_nm",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"dest_trns_svc_mod_cd",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"final_dest_nm",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"final_pod_eta",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"final_pod_etd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"final_pol_eta",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"final_pol_etd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_vvd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"dis_last_vvd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ob_vvd_1",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"hlg_tp",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"org_trns_svc_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_pod",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_vsl",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pod_ata_ic_dt",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"last_pod_eta",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pod_etb",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pod_nm",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"first_vsl",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"first_pol_cutoff_dt", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pol_nm",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"por_cnt_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"por_nm",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post1_vvd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post2_vvd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post3_vvd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post4_vvd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post_vsl",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"post_vvd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre1_pod_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre1_pol_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				            
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre1_vvd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre2_pod_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre2_pol_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre2_vvd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre3_pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre3_pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre3_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre4_pod_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre4_pol_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre4_vvd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre_vsl",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pre_vvd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rd_term",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ts_port1",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ts_port2",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ts_port3",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"tvvd",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"traf_mod",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_slan_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pod_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pod_eta",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pod_etd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pol_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_pol_eta",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_vsl",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_vvd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },				             
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trunk_vsl_nm",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ex_mvmt_ref_no",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				          
	              InitColumns(cols);
	  		      SetEditable(0);	//Editkind[optional,Defaultfalse]
	  		      SetWaitImageVisible(0);
	  		      SetSheetHeight(380);
		      }
        }else{         	
        	selectedGridCols=new Array();//initializing
            with(sheetObj){
            	var HeadTitle1="";
            	var arrColList=ColList.split("|");
            	var tempName="";
            	var tempCnt=0;
            	for(var index=0; index < arrColList.length; index++) {
            	  tempName=arrColList[index].split(">")[1].toLowerCase();
            	if(arrGridColsTitle[tempName] == undefined) {
            	  continue;
            	}
            	HeadTitle1 += "|"+ arrGridColsTitle[tempName]; //creating selected column header
            	selectedGridCols[tempName]="Y";//selected grid column- except when other header and attribute are defined
            	  tempCnt++;
            	}
            	for (var key in arrGridColsTitle){ //creating header of other column
            	if(selectedGridCols[key] != undefined) {
            	  continue;
            	}
            	HeadTitle1 += "|"+ arrGridColsTitle[key];
            	}

            	SetConfig( { SearchMode:2,  MergeSheet:0, FrozenCol:0, DataRowMerge:0 } );

            	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);		

            	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"no" }];
            	//var count = 0;	
            	for (var key in selectedGridCols){					  
            	  if(arrGridColsProp[key] == undefined) {
            		  continue;
            	  }
            	  eval(arrGridColsProp[key]);
            	  SetColHidden(prefix + key,1);
            	}

            	InitColumns(cols);
            	for (var key in arrGridColsProp){ 
            	    if(selectedGridCols[key] != undefined) {
            	  	  continue;
            	    }				 
            	    eval(arrGridColsProp[key]);
            	    SetColHidden(prefix + key,1);
            	}				  
            }            
        }
     }
     
     /* 조건에 따른 필수값 세팅 */
     function chgMandatory() {
    	 var formObject = document.form;    
    	 if(formObject.rdo2_1.checked) {    		 
			 formObject.arr_from_dt.value = "";
			 formObject.arr_to_dt.value = "";
			 formObject.pod_cd.value = "";
			 formObject.pod_yard_cd.value = "";		 
			 document.getElementById("sail_from_dt").className="input1";
			 document.getElementById("sail_to_dt").className="input1";
			 document.getElementById("pol_cd").className="input1";
			 document.getElementById("arr_from_dt").className="input";
			 document.getElementById("arr_to_dt").className="input";
			 document.getElementById("pod_cd").className="input";
			 formObject.sail_from_dt.focus();			 
		 } else if(formObject.rdo2_2.checked) {
			 formObject.sail_from_dt.value = "";
			 formObject.sail_to_dt.value = "";
			 formObject.pol_cd.value = "";
			 formObject.pol_yard_cd.value = "";			 
			 document.getElementById("sail_from_dt").className="input";
			 document.getElementById("sail_to_dt").className="input";
			 document.getElementById("pol_cd").className="input";			 
			 document.getElementById("arr_from_dt").className="input1";
			 document.getElementById("arr_to_dt").className="input1";
			 document.getElementById("pod_cd").className="input1";
			 formObject.arr_from_dt.focus();
		 } else {
			 formObject.sail_from_dt.value = "";
			 formObject.sail_to_dt.value = "";
			 formObject.pol_cd.value = "";
			 formObject.pol_yard_cd.value = "";				 
			 formObject.arr_from_dt.value = "";
			 formObject.arr_to_dt.value = "";
			 formObject.pod_cd.value = "";
			 formObject.pod_yard_cd.value = "";			 
			 document.getElementById("sail_from_dt").className="input";
			 document.getElementById("sail_to_dt").className="input";
			 document.getElementById("pol_cd").className="input";			 
			 document.getElementById("arr_from_dt").className="input";
			 document.getElementById("arr_to_dt").className="input";
			 document.getElementById("pod_cd").className="input";	
			 formObject.sail_from_dt.focus();
		 }
     }
     
     /* setting Sort in POP-UP   * */
     function setOrderBy(val){    	 
    	 orderby = val;    	 
     }
     
     //대문자로 입력 변환
	 function onlyText(obj){
		val=obj.value;
		re=/[^a-zA-Z]/gi;
		obj.value=val.replace(re,"");
	}
     
	/* the end of developer's work */    
