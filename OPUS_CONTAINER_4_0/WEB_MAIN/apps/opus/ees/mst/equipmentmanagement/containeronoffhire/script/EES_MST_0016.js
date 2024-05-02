/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0016.js
*@FileTitle  : Own Container Creation (New Van) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0016 :  business script for ees_mst_0016
     */

	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var comboObjects=new Array();
	 var IBSEARCH02=30;
	 var comboCnt=0;
	//Retrieve, New 시 변경된 데이터에 대해서 저장 여부를 묻지 위한 Flag로 사용 
	 var arr_de_yrmon=new Array();	
	 var arr_fctry_spec_no=new Array();
	 var arr_certi_no=new Array();
	 var arr_apro_csc_no=new Array();
	 var arr_apro_tir_no=new Array();
	 var arr_apro_uic_no=new Array();
	 var arr_apro_tct_no=new Array();
	 var arr_unit_type=new Array();
	 var arr_plst_flr_flg=new Array();
	 var arr_cntr_hngr_rck_cd=new Array(); 
	 var arr_rf_mkr_seq=new Array();
	 var arr_rf_mdl_nm=new Array();
	 var arr_rf_rfr_no=new Array();
	 var arr_min_temp=new Array();
	 var arr_max_temp=new Array();
	 var arr_diff_rmk=new Array();
	 
	 var now_date = "";
	 var now_day = "";
	 var now_time = "";
	 // Event handler processing by button click event 
	 document.onclick=processButtonClick;
	 // Event handler processing by button name 
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];    	 
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
             	 case "btns_calendar1": 
					var cal=new ComCalendar();
					cal.select(formObject.mft_dt, 'yyyy-MM-dd');  
             	 	break;
             	 case "btns_calendar2": 
					var cal=new ComCalendar();
					cal.select(formObject.de_dt0, 'yyyy-MM-dd');  
          	 	break;             	 	
    			case "ComOpenPopupWithTarget1":
   					ComOpenPopupWithTarget('/opuscntr/EES_MST_0038.do', 600, 580, "lot_no:lot_no", "0,0", true);
   					break;             	 
    			case "ComOpenPopupWithTarget2":
    				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0091.do', 820, 480, "agmt_no:agmt_no|eff_dt:eff_dt|exp_dt:exp_dt|vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm|lstm_cd:lstm_cd", "0,0,1", true);    				
   					break;   
    			case "ComOpenPopupWithTarget3":
					if(!checkAgmtNo(formObject)) return;
					ComOpenPopupWithTarget('/opuscntr/EES_MST_0022_POP.do?active_flag=1&own_cntr_flg=O&cntr_tpsz_cd='+formObject.cntr_tpsz_cd.value+'&agmt_no='+formObject.agmt_no.value+'&lot_no='+formObject.lot_no.value, 1250, 660, "cntr_spec_no:cntr_spec_no|cntr_mtrl_cd:cntr_mtrl_cd|hid_vndr_seq:mft_vndr_seq|vndr_abbr_nm:vndr_abbr_nm|cntr_tpsz_cd:cntr_tpsz_cd", "0,0", true);
					/*doActionIBSheet(sheetObject1, formObject, SEARCH09);
					unit_type_enableYn();*/
   					break;
    			case "btn_new": 
    				//if ( f_change_data_checking(formObject)  == true)  return;
    				
				   enabledYn('I');
    			   objectClear();
				   ComResetAll();
				   sheetObjects[0].SetEtcData("lot_no","");
				   comboObjects[2].SetSelectIndex("-1",false);
				   comboObjects[2].SetEnable(0);
				   comboObjects[1].SetSelectIndex("-1",false);
				   comboObjects[1].SetEnable(0);
				   comboObjects[3].SetSelectIndex("-1",false);
				   comboObjects[3].SetEnable(0);
				   formObject.rf_mdl_nm.value="";
				   formObject.rf_rfr_no.value="";
				   formObject.min_temp.value="";
				   formObject.max_temp.value="";
				   formObject.p_time.value="00:00";
				   formObject.rf_cmpr_ctnt.value="";
				   formObject.rf_mdl_nm.readOnly=true;
				   formObject.rf_rfr_no.readOnly=true;
				   formObject.min_temp.readOnly=true;
				   formObject.max_temp.readOnly=true;
				   formObject.rf_cmpr_ctnt.readOnly=true;
				   document.getElementById("rf_mdl_nm").className="input2";
				   document.getElementById("rf_rfr_no").className="input2";
				   document.getElementById("min_temp").className="input2";
				   document.getElementById("max_temp").className="input2";
				   document.getElementById("rf_cmpr_ctnt").className="input2";		
				   
				   formObject.lot_cntr_pfx_cd.readOnly=false;
				   formObject.cntr_spec_no.readOnly=false;
				   formObject.mft_yd_cd.readOnly=false;
				   formObject.btns_search2.readOnly=false;
				   formObject.mft_dt.readOnly=false;
				   formObject.de_dt0.readOnly=false;
				   formObject.p_time.readOnly=false;
				   formObject.fm_ser_no.readOnly=false;
				   formObject.to_ser_no.readOnly=false;
				   ComBtnEnable("btns_search2");
				   ComBtnEnable("btns_calendar1");
				   
				   document.getElementById("lot_cntr_pfx_cd").className="input1";
				   document.getElementById("cntr_spec_no").className="input1";
				   document.getElementById("mft_yd_cd").className="input1";
				   document.getElementById("mft_dt").className="input1";
				   document.getElementById("de_dt0").className="input1";
				   document.getElementById("p_time").className="input1";
				   document.getElementById("fm_ser_no").className="input1";
				   document.getElementById("to_ser_no").className="input1";		
                   break;
                case "btn_save":         	
                 	// mandatory Check  
					if(!checkItem(formObject)) return;
               		doActionIBSheet(sheetObject1, formObject, IBSAVE); 
					lot_no_change();
                 	break;
                case "btns_search2":	//retrieving for Location.
                	ComOpenPopup("/opuscntr/COM_ENS_061.do",805, 500, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
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
     
     
     /**
      * handling process for DeliveryLoc(Yard) Pop-up Return Value<br>
      * @param Return value array
      * @param Row index
      * @param Col index
      * @param Sheet Array index
      */
     function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj=sheetObjects[SheetIdx];
     	var formObj=document.form;
     	var strYdCd = "";
     	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.mft_yd_cd, aryPopupData[0][3]);
			strYdCd = aryPopupData[0][3].substring(0,5);
			formObj.lot_loc_cd.value = strYdCd;  
     	}
     }
     
     
 	/**
	  * checkAgmtNo - input avilable after agreement no. optional
	  */
	function checkAgmtNo(formObj){
		if (formObj.agmt_no.value.trim().length == 0) {
			ComShowCodeMessage("MST01018");
			return false;
		} 
		return true;
	}
 	/**
	  * mandatory check
	  */
	function checkItem(formObj){	
		var sheetObj=sheetObjects[0];
		var strDeYRMon = formObj.de_dt0.value; //년월
		var strMftDt = formObj.mft_dt.value; //년월일 M/Facture		
		
		formObj.f_cmd.value=SEARCH23;
		sheetObj.SetWaitImageVisible(0);
		var str_agmt_seq = formObj.agmt_no.value;
		str_agmt_seq = str_agmt_seq.substring(3,10);
		
		var chk_date = now_day;
		
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
		sheetObj.SetWaitImageVisible(1);

		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
				if(ComGetEtcData(sXml, "check_date_yn") == "N") {
					ComShowCodeMessage("MST02046");
					return false;
				}
			} 
		}
		
		formObj.f_cmd.value=SEARCH23;
		sheetObj.SetWaitImageVisible(0);
		var str_agmt_seq = formObj.agmt_no.value;
		str_agmt_seq = str_agmt_seq.substring(3,10);
		var chk_date = formObj.de_dt0.value;
		
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
		sheetObj.SetWaitImageVisible(1);

		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
				if(ComGetEtcData(sXml, "check_date_yn") == "N") {
					ComShowCodeMessage("MST02047");
					return false;
				}
			} 
		}
		
		strDeYRMon =  ComReplaceStr(strDeYRMon,"-","")
		strMftDt = ComReplaceStr(strMftDt,"-","").substring(0,6);
		
		if( strDeYRMon < strMftDt) {
			ComShowCodeMessage("MST02048");
			return false;
		}
		
		
		var changeYn='N';
		if(ComGetObjValue(formObj.org_plst_flr_flg) == 'N' && formObj.plst_flr_flg.checked == false){ 
				changeYn='Y';
		}
		if(ComGetObjValue(formObj.org_plst_flr_flg) == 'Y' && ComGetObjValue(formObj.plst_flr_flg) == 'Y'){
			changeYn='Y';
		}
		if(ComGetObjValue(formObj.org_agmt_no)						==	ComGetObjValue(formObj.agmt_no)                 &&				
				ComGetObjValue(formObj.org_mft_dt)          		==	ComGetObjValue(formObj.mft_dt)				&&
				ComGetObjValue(formObj.org_cntr_hngr_rck_cd)	==	ComGetObjValue(formObj.cntr_hngr_rck_cd)	&&
				ComGetObjValue(formObj.org_fctry_spec_no)		==	ComGetObjValue(formObj.fctry_spec_no)		&&
				ComGetObjValue(formObj.org_de_yrmon)	  			==	ComGetObjValue(formObj.de_yrmon)			&&
				ComGetObjValue(formObj.org_de_dt)	  			==	ComGetObjValue(formObj.de_dt0)			&&
				ComGetObjValue(formObj.org_certi_no)	       		==	ComGetObjValue(formObj.certi_no)	    	&&				    
				ComGetObjValue(formObj.org_diff_rmk)		    		==	ComGetObjValue(formObj.diff_rmk)			&&
				ComGetObjValue(formObj.org_mft_vndr_seq)			==	ComGetObjValue(formObj.mft_vndr_seq)		&&
				ComGetObjValue(formObj.org_apro_csc_no)			==	ComGetObjValue(formObj.apro_csc_no)		&&
				ComGetObjValue(formObj.org_apro_tir_no)			==	ComGetObjValue(formObj.apro_tir_no)		&&
				ComGetObjValue(formObj.org_apro_uic_no)			==	ComGetObjValue(formObj.apro_uic_no)		&&
				ComGetObjValue(formObj.org_apro_tct_no)			==	ComGetObjValue(formObj.apro_tct_no)     &&
				ComGetObjValue(formObj.org_unit_type)				==	ComGetObjValue(formObj.unit_type)  		&&	
				ComGetObjValue(formObj.org_rf_mkr_seq)				==	ComGetObjValue(formObj.rf_mkr_seq)      &&
				ComGetObjValue(formObj.org_rf_mdl_nm)				==	ComGetObjValue(formObj.rf_mdl_nm)       &&
				ComGetObjValue(formObj.org_rf_rfr_no)				==	ComGetObjValue(formObj.rf_rfr_no)       &&
				ComGetObjValue(formObj.org_min_temp)				==	ComGetObjValue(formObj.min_temp)        &&
				ComGetObjValue(formObj.org_max_temp)				==	ComGetObjValue(formObj.max_temp)		&&
				ComGetObjValue(formObj.org_rf_humid_ctrl_val_cd)==	ComGetObjValue(formObj.rf_humid_ctrl_val_cd)		&&
				ComGetObjValue(formObj.org_mft_yd_cd)==	ComGetObjValue(formObj.mft_yd_cd)		&&
				ComGetObjValue(formObj.org_rf_cmpr_ctnt)			==	ComGetObjValue(formObj.rf_cmpr_ctnt)) 
		{
			if(changeYn == 'Y'){
				ComShowCodeMessage("MST00012");		// There is no updated data to save.
				return false;
			}
		}
		if (formObj.cntr_spec_no.value.trim().length == 0) {
			ComShowCodeMessage("MST00001", "Spec. No");
			formObj.cntr_spec_no.focus();
			return false;
		} 
		if(formObj.mft_yd_cd.value.trim().length== ''){
			ComShowCodeMessage("MST00001", "M/facturer Yard");
			return false;
		}
		if (formObj.mft_dt.value.trim().length == 0) {
			ComShowCodeMessage("MST00001", "M/Facture Date");
			formObj.mft_dt.focus();
			return false;
		} 
		if(ComGetDaysBetween(ComGetNowInfo(), formObj.mft_dt) > 0){			
			ComShowCodeMessage("MST01006", "M/Facture Date");			
			formObj.mft_dt.value="";
			return false;
		}	
		if(ComGetDaysBetween(ComGetNowInfo(), formObj.de_dt0) > 0){			
			ComShowCodeMessage("MST01006", "Delivery Date");			
			formObj.de_dt0.value="";
			return false;
		}			
		/*if(comboObjects[1].GetSelectText()== ''){
			ComShowCodeMessage("MST00001", "S/N Range");
			return false;
		}*/
		if(formObj.lot_cntr_pfx_cd.value.trim().length == 0){
			ComShowCodeMessage("MST00001", "S/N Range");
			return false;
		}
		if (formObj.fm_ser_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "S/N Range");
			formObj.fm_ser_no.focus();
			return false;
		} 
		if (formObj.lot_cntr_pfx_cd.value.trim().length != 4 ) {
			ComShowCodeMessage("MST02049");
			formObj.lot_cntr_pfx_cd.focus();
			return false;
		} 
		if (formObj.to_ser_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "S/N Range");
			formObj.to_ser_no.focus();
			return false;
		} 
		if (formObj.de_dt0.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "Delivery Date");
			formObj.de_dt0.focus();
			return false;
		} 
		if (formObj.agmt_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "AGMT No.");
			formObj.agmt_no.focus();
			return false;
		} 
		if (formObj.certi_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "CERTI No.");
			formObj.certi_no.focus();
			return false;
		}
		if (formObj.apro_csc_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "CSC No.");
			formObj.apro_csc_no.focus();
			return false;
		}	    
		if (formObj.apro_tir_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "TIR No.");
			formObj.apro_tir_no.focus();
			return false;
		}
		if(eval(formObj.range_count.value) < 1){
			ComShowCodeMessage("MST01022");
			return false;
		}
		if (formObj.rf_mdl_nm.readOnly == false){
			var vstr=ComGetObjValue(formObj.rf_mkr_seq);
			if (vstr.length == 0 ){
				ComShowCodeMessage("MST00001", "Marker");
				formObj.rf_mkr_seq.focus();
				return false;
			}
			if (formObj.rf_mdl_nm.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Model No.");
				formObj.rf_mdl_nm.focus();
				return false;
			}
			if (formObj.rf_rfr_no.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Refrigerant");
				formObj.rf_rfr_no.focus();
				return false;
			}
			if (formObj.min_temp.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Max Setting Temp(Min)");
				formObj.min_temp.focus();
				return false;
			}
			if (formObj.max_temp.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Max Setting Temp(Max)");
				formObj.max_temp.focus();
				return false;
			}
		}
		if (formObj.diff_rmk.value.trim().length > 1000 ){
			ComShowCodeMessage("MST02029", "Remark(s)");
			formObj.diff_rmk.focus();
			return false;
		}
		return true;
	}
 	/**
	 * doActionIBSheet
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {  
         switch(sAction) {
			case IBSEARCH:      //retrieve
			    sheetObj.SetWaitImageVisible(0);
			    ComOpenWait(true);			
				formObj.f_cmd.value=SEARCH;			
 				var xml="";
 				xml=sheetObj.GetSearchData("EES_MST_0016GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
            	var chk=xml.indexOf("ERROR"); 				
            	if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
            		sheetObj.LoadSearchData(xml,{Sync:1} );
            		formObj.lot_no.value = formObj.org_lot_no.value;
            		return;
            	} else {
            		sheetObj.LoadSearchData(xml,{Sync:1} );
            	}				
				setSearchValue(sheetObj, formObj);
				unit_type_enableYn();
				enabledYn('U');
				f_change_data_setting(formObj, true);
				break;
			case SEARCH09:      //retrieve
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);			
				formObj.f_cmd.value = SEARCH09;			
 				var xml = "";
 				xml = sheetObj.GetSearchData("EES_MST_0016GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
            	var chk = xml.indexOf("ERROR"); 				
            	if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
            		sheetObj.LoadSearchData(xml,{Sync:1});
            		return;
            	} else {
            		sheetObj.LoadSearchData(xml,{Sync:1});
            	}				
            	if(sheetObj.GetCellValue(1,'message_err') =="F"){
            		ComShowCodeMessage("MST02030");
            		formObj.cntr_spec_no.value ="";
            		formObj.cntr_tpsz_cd.value ="";
             		formObj.vndr_abbr_nm.value ="";
             	}
//				setSearchValue(sheetObj, formObj);
//				unit_type_enableYn();
//				enabledYn('U');
//				
//				f_change_data_setting(formObj, true);
				
				break;				
 			case IBSAVE:        //save
 			    // mft date Setting
				formObj.de_dt.value = formObj.de_dt0.value.substr(0, 10)+" "+formObj.p_time.value;
				formObj.de_yrmon.value = formObj.de_dt0.value.substr(0, 7);
				if(ComGetObjValue(formObj.lot_no) == '' || ComGetObjValue(formObj.lot_no) == null){	
					formObj.f_cmd.value=MULTI01;		// creating
				}else{
					formObj.f_cmd.value=MULTI02;		// modifying
				}
				
	 			sheetObj.SetWaitImageVisible(1);
				var sXml=sheetObj.GetSearchData("EES_MST_0016GS.do", FormQueryString(formObj), '', true);
			    var lot_no=ComGetEtcData(sXml,"lot_no")
			    
				if(typeof lot_no == "undefined" || lot_no == ""){					
					ComShowMessage(ComGetSelectSingleNode(sXml,"MESSAGE"));
				}else{
//					formObj.lot_no.value=sheetObj.GetEtcData("lot_no");
					formObj.lot_no.value=lot_no;
					enabledYn('U');	
				}
				ComShowObject(formObj.ComOpenPopupWithTarget2, false);
			    ComShowObject(formObj.ComOpenPopupWithTarget3, false);
				sheetObj.SetWaitImageVisible(0);
				break;
				
 			case SEARCH08:      //Unit Type retrieve
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);			
 				formObj.f_cmd.value=SEARCH08;			
				var xml="";
				xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(xml, "unit_type").split("|");
				if(comboItems != ""){
					addComboItem(unit_type,comboItems);
				}
				ComOpenWait(false);
				break;
 			case SEARCH11:      //Unit Type retrieve
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);			
 				formObj.f_cmd.value=SEARCH11;			
				var xml="";
				xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(xml, "rf_humid_ctrl_val_cd").split("|");
				if(comboItems != ""){
					addComboItem(rf_humid_ctrl_val_cd,comboItems);
				}
				ComOpenWait(false);
			break;
 			case IBSEARCH02 :
				if (formObj.mft_yd_cd.value != ""){
					formObj.f_cmd.value=SEARCH06;
					var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.mft_yd_cd.value+"&yd_chk_flg=Y");
					var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:1} );
					   return;
					}
	            	var codestr=ComXmlString(sXml, "code_nm");
	            	if (codestr == ""){
	            		ComShowCodeMessage("MST01019", formObj.mft_yd_cd.value);
	            		formObj.mft_yd_cd.value="";
	            		ComSetFocus(formObj.mft_yd_cd);
	            		return;
	            	} else {
	            		strYdCd = formObj.mft_yd_cd.value.substring(0,5);
	        			formObj.lot_loc_cd.value = strYdCd;  
	            	}
				} 
            break;            
         }                
     }
    
    
	 function setSearchValue(sheetObj, formObj){
		ComSetObjValue(formObj.agmt_no, 	sheetObj.GetCellValue(1,'agmt_no'));
		ComSetObjValue(formObj.lstm_cd,		sheetObj.GetCellValue(1,'lstm_cd'));
		ComSetObjValue(formObj.eff_dt, 		sheetObj.GetCellValue(1,'eff_dt'));
		ComSetObjValue(formObj.exp_dt, 		sheetObj.GetCellValue(1,'exp_dt'));
		ComSetObjValue(formObj.vndr_seq, 	sheetObj.GetCellValue(1,'vndr_seq'));
		ComSetObjValue(formObj.vndr_lgl_eng_nm, 	sheetObj.GetCellValue(1,'vndr_lgl_eng_nm'));
		ComSetObjValue(formObj.cntr_spec_no, 		sheetObj.GetCellValue(1,'cntr_spec_no'));
		ComSetObjValue(formObj.cntr_tpsz_cd, 		sheetObj.GetCellValue(1,'cntr_tpsz_cd'));
		ComSetObjValue(formObj.fctry_spec_no,		sheetObj.GetCellValue(1,'fctry_spec_no'));
		ComSetObjValue(formObj.lot_loc_cd,			sheetObj.GetCellValue(1,'lot_loc_cd'));
		ComSetObjValue(formObj.mft_vndr_seq,		sheetObj.GetCellValue(1,'mft_vndr_seq'));
		ComSetObjValue(formObj.org_mft_vndr_seq,	sheetObj.GetCellValue(1,'mft_vndr_seq'));
		ComSetObjValue(formObj.vndr_abbr_nm,		sheetObj.GetCellValue(1,'vndr_abbr_nm'));
		ComSetObjValue(formObj.mft_dt,				sheetObj.GetCellValue(1,'mft_dt'));
		ComSetObjValue(formObj.de_dt,				sheetObj.GetCellValue(1,'de_dt'));
		ComSetObjValue(formObj.de_dt0,				sheetObj.GetCellValue(1,'de_dt'));
		ComSetObjValue(formObj.p_time,				sheetObj.GetCellValue(1,'p_time'));
		if(sheetObj.GetCellValue(1,'lot_cntr_pfx_cd') == 'COMU'){
			ComSetObjValue(formObj.lot_cntr_pfx_cd,	sheetObj.GetCellValue(1,'lot_cntr_pfx_cd'));
		} else{			
			if( sheetObj.GetCellValue(1,'lot_cntr_pfx_cd') != ""){
//				formObj.lot_cntr_pfx_cd.InsertItem(3, sheetObj.GetCellValue(1,'lot_cntr_pfx_cd'), sheetObj.GetCellValue(1,'lot_cntr_pfx_cd'));
				ComSetObjValue(formObj.lot_cntr_pfx_cd,	sheetObj.GetCellValue(1,'lot_cntr_pfx_cd'));
			}else{
				ComSetObjValue(formObj.lot_cntr_pfx_cd,	"");
			}
		}       
		ComSetObjValue(formObj.fm_ser_no,	sheetObj.GetCellValue(1,'fm_ser_no'));
		ComSetObjValue(formObj.to_ser_no,	sheetObj.GetCellValue(1,'to_ser_no'));
		ComSetObjValue(formObj.de_yrmon,	sheetObj.GetCellValue(1,'de_yrmon'));
		ComSetObjValue(formObj.plst_flr_flg,		sheetObj.GetCellValue(1,'plst_flr_flg'));
		if(sheetObj.GetCellValue(1,'plst_flr_flg') == 'N'){
			formObj.plst_flr_flg.checked=false;
		}		
		ComSetObjValue(formObj.cntr_hngr_rck_cd,	sheetObj.GetCellValue(1,'cntr_hngr_rck_cd'));
		ComSetObjValue(formObj.fa_if_grp_sts_cd,	sheetObj.GetCellValue(1,'fa_if_grp_sts_cd'));
		ComSetObjValue(formObj.certi_no,			sheetObj.GetCellValue(1,'certi_no'));
		ComSetObjValue(formObj.apro_csc_no,			sheetObj.GetCellValue(1,'apro_csc_no'));
		ComSetObjValue(formObj.apro_tir_no,			sheetObj.GetCellValue(1,'apro_tir_no'));
		ComSetObjValue(formObj.apro_uic_no,			sheetObj.GetCellValue(1,'apro_uic_no'));
		ComSetObjValue(formObj.apro_tct_no,			sheetObj.GetCellValue(1,'apro_tct_no'));
		ComSetObjValue(formObj.org_apro_csc_no,	sheetObj.GetCellValue(1,'apro_csc_no'));
		ComSetObjValue(formObj.org_apro_tir_no,	sheetObj.GetCellValue(1,'apro_tir_no'));
		ComSetObjValue(formObj.org_apro_uic_no,	sheetObj.GetCellValue(1,'apro_uic_no'));
		ComSetObjValue(formObj.org_apro_tct_no,	sheetObj.GetCellValue(1,'apro_tct_no'));
		ComSetObjValue(formObj.cntr_mtrl_cd,	sheetObj.GetCellValue(1,'cntr_mtrl_cd'));
		ComSetObjValue(formObj.range_count,	sheetObj.GetCellValue(1,'range_count'));
		ComSetObjValue(formObj.org_agmt_no,	sheetObj.GetCellValue(1,'agmt_no'));
		ComSetObjValue(formObj.org_diff_rmk,sheetObj.GetCellValue(1,'diff_rmk'));
		ComSetObjValue(formObj.diff_rmk,	sheetObj.GetCellValue(1,'diff_rmk'));
		ComSetObjValue(formObj.org_mft_dt,	sheetObj.GetCellValue(1,'org_mft_dt'));
		ComSetObjValue(formObj.org_de_dt,	sheetObj.GetCellValue(1,'org_de_dt'));
		ComSetObjValue(formObj.org_cntr_hngr_rck_cd,	sheetObj.GetCellValue(1,'org_cntr_hngr_rck_cd'));
		ComSetObjValue(formObj.org_plst_flr_flg,	sheetObj.GetCellValue(1,'org_plst_flr_flg'));
		ComSetObjValue(formObj.org_fctry_spec_no,	sheetObj.GetCellValue(1,'org_fctry_spec_no'));
		ComSetObjValue(formObj.org_de_yrmon,	sheetObj.GetCellValue(1,'org_de_yrmon'));
		ComSetObjValue(formObj.org_certi_no,	sheetObj.GetCellValue(1,'org_certi_no'));
		ComSetObjValue(formObj.org_unit_type,	sheetObj.GetCellValue(1,'unit_type'));
		comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1,'unit_type'));
		//ComSetObjValue(formObj.unit_type,	sheetObj.GetCellValue(1,'unit_type'));
		comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1,'rf_mkr_seq'));
		//ComSetObjValue(formObj.rf_mkr_seq,			sheetObj.GetCellValue(1,'rf_mkr_seq'));
		ComSetObjValue(formObj.rf_mdl_nm,			sheetObj.GetCellValue(1,'rf_mdl_nm'));
		ComSetObjValue(formObj.rf_rfr_no,			sheetObj.GetCellValue(1,'rf_rfr_no'));
		ComSetObjValue(formObj.min_temp,			sheetObj.GetCellValue(1,'min_temp'));
		ComSetObjValue(formObj.max_temp,			sheetObj.GetCellValue(1,'max_temp'));
		ComSetObjValue(rf_humid_ctrl_val_cd,			sheetObj.GetCellValue(1,'rf_humid_ctrl_val_cd'));
		ComSetObjValue(formObj.rf_cmpr_ctnt,			sheetObj.GetCellValue(1,'rf_cmpr_ctnt'));
		
		ComSetObjValue(formObj.org_rf_mkr_seq,			sheetObj.GetCellValue(1,'org_rf_mkr_seq'));
		ComSetObjValue(formObj.org_rf_mdl_nm,			sheetObj.GetCellValue(1,'org_rf_mdl_nm'));
		ComSetObjValue(formObj.org_rf_rfr_no,			sheetObj.GetCellValue(1,'org_rf_rfr_no'));
		ComSetObjValue(formObj.org_min_temp,			sheetObj.GetCellValue(1,'org_min_temp'));
		ComSetObjValue(formObj.org_max_temp,			sheetObj.GetCellValue(1,'org_max_temp'));
		ComSetObjValue(formObj.org_rf_humid_ctrl_val_cd,			sheetObj.GetCellValue(1,'rf_humid_ctrl_val_cd'));
		ComSetObjValue(formObj.org_rf_cmpr_ctnt,			sheetObj.GetCellValue(1,'rf_cmpr_ctnt'));
		ComSetObjValue(formObj.mft_yd_cd,			sheetObj.GetCellValue(1,'mft_yd_cd'));
		ComSetObjValue(formObj.org_mft_yd_cd,			sheetObj.GetCellValue(1,'mft_yd_cd'));
		
		ComSetObjValue(formObj.org_lot_no,			formObj.lot_no.value);
		
		formObj.cntr_spec_no.readOnly=true;
		formObj.mft_yd_cd.readOnly=true;
		formObj.btns_search2.readOnly=true;
		formObj.mft_dt.readOnly=true;
		formObj.de_dt0.readOnly=true;
		formObj.p_time.readOnly=true;
		formObj.fm_ser_no.readOnly=true;
		formObj.to_ser_no.readOnly=true;
		formObj.lot_cntr_pfx_cd.readOnly=true;
		ComBtnDisable("btns_search2");
		ComBtnDisable("btns_calendar1");			
		
		document.getElementById("cntr_spec_no").className="input2";
		document.getElementById("mft_yd_cd").className="input2";
		document.getElementById("mft_dt").className="input2";
		document.getElementById("de_dt0").className="input2";
		document.getElementById("p_time").className="input2";
		document.getElementById("fm_ser_no").className="input2";
		document.getElementById("to_ser_no").className="input2";
		document.getElementById("lot_cntr_pfx_cd").className="input2";
		if(formObj.cntr_tpsz_cd.value == "") {
			formObj.lot_no.value = "";
			formObj.org_lot_no.value = "";
		}
	 }
     /**
     * registering IBsheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }     
     /**
      * registering IBMultiCombo Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {     	
    	var sheetObj=sheetObjects[0];
  		for(i=0;i<sheetObjects.length;i++){ 
            ComConfigSheet(sheetObjects[i] );  			
			initSheet(sheetObjects[i],i+1);
		}
  		comboObjects[1].SetEnable(0);
		// IBMultiCombo initailizing
	    for(var k=0;k<comboObjects.length;k++){  	    	
	        initCombo(comboObjects[k],k+1);
	    } 	
	    //comboObjects[0].SetUseAutoComplete(1);
	    comboObjects[2].SetEnable(0);
	    comboObjects[3].SetEnable(0);
		//htmlcontrol event initailizing
		initControl();
		document.form.p_time.value="00:00";
		// initializing date. setting current time as event time
	    var strTime=new Date(); 
	    var y=strTime.getFullYear();
	    var m=strTime.getMonth() + 1;
	    var d=strTime.getDate();
	    if (m < 10) m="0" + m;
	    if (d < 10) d="0" + d;
	    now_day=""+y+""+m+""+d;   
	    
		doActionIBSheet(sheetObj, document.form, SEARCH08);
		doActionIBSheet(sheetObj, document.form, SEARCH11);
     }
     
  	 function initControl() {
	    axon_event.addListenerForm  ('blur', 'obj_deactivate', form);        	      	   
		// axon_event.addListenerFormat('keypress','obj_keypress',	form);				//- when key down
		axon_event.addListener("change", "lot_no_change","lot_no");
		axon_event.addListener("change", "lstm_cd_change","lstm_cd");
		axon_event.addListener("change", "cntr_tpsz_cd_change","cntr_tpsz_cd");
		axon_event.addListener("change", "vndr_abbr_nm_change","vndr_abbr_nm");
		axon_event.addListener("change", "range_change1","fm_ser_no");
		axon_event.addListener("change", "range_change2","to_ser_no");
		axon_event.addListener("change", "agmt_no_change","agmt_no");	
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- when key down
	 }
     /**
     * obj_keyup
     */   
  	function obj_keyup() {
 		var obj=ComGetEvent();
 		var vKeyCode=event.keyCode;
 		var formObj=document.form;
 		switch(ComGetEvent("name")) {
			case "mft_yd_cd":
				if (formObj.mft_yd_cd.value.length == 7) {
	        		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);			
				}
			break;
 		}
 	}
     /**
      * obj_keypress
      */   
// 	 function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//         	case "int":                  		
//         		if(obj.name=="fm_ser_no") ComKeyOnlyNumber('int');
//         		if(obj.name=="to_ser_no") ComKeyOnlyNumber('int');         		
//    	        break;
//            case "ymd":
//                if(obj.name=="mft_dt") ComKeyOnlyNumber(this, "-");
//                break;
//        	case "float":
//        		ComKeyOnlyNumber(obj, "-.");
//        		break;                
//	    }        
//	 }
     /**
      * agmt_no_change
     */ 
	 function agmt_no_change(){
		var formObj=document.form;
		if(formObj.agmt_no.value.trim() != formObj.org_agmt_no.value.trim()){
			formObj.cntr_spec_no.value='';
			formObj.apro_csc_no.value='';
			formObj.apro_tir_no.value='';
			formObj.apro_uic_no.value='';
			formObj.apro_tct_no.value='';
			// in case of creating, TY/SZ initailizing
			// in case of modifying, TY/SZ not initailizing
			if(formObj.lot_no.value.trim().length == 0){
				formObj.cntr_tpsz_cd.value='';
			}
		}
	 }
     /**
      * lot_no_change
      */   	
	 function lot_no_change() {
		var sheetObject1=sheetObjects[0];
		var formObj=document.form;
		if(formObj.lot_no.value.trim().length > 0){
			enabledYn('U');
			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
		}
	 } 
	 
	 
	 function enabledYn(sw){
		var formObj=document.form;
		if( sw == 'U'){  // modifying
			ComShowObject(formObj.ComOpenPopupWithTarget2, false);
		    ComShowObject(formObj.ComOpenPopupWithTarget3, false);
			if(formObj.fa_if_grp_sts_cd.value.trim().length > 0){
				// only before ERP I/F 
				// MFT_DT, DE_YRMON, AGMT_CTY_CD, AGMT_SEQ
				ComShowObject(formObj.btns_calendar1, false);
				ComShowObject(formObj.btns_calendar2, false);
			}else{
				ComShowObject(formObj.btns_calendar1, true);
				ComShowObject(formObj.btns_calendar2, true);
			}
			//comboObjects[0].SetEnable(0);
			//comboObjects[1].SetEnable(0);
			formObj.fm_ser_no.readOnly=true;
			formObj.to_ser_no.readOnly=true;
			formObj.lot_cntr_pfx_cd.readOnly=true;
			
			
			
			/*document.getElementById("agmt_no").className="input2";
			document.getElementById("cntr_spec_no").className="input2";
			document.getElementById("certi_no").className="input2";
			document.getElementById("apro_csc_no").className="input2";
			document.getElementById("mft_dt").className="input2";
			document.getElementById("apro_tir_no").className="input2";
			document.getElementById("fm_ser_no").className="input2";
			document.getElementById("to_ser_no").className="input2";
			document.getElementById("de_yrmon").className="input2";
			
			document.getElementById("fctry_spec_no").className="input2";
			document.getElementById("apro_uic_no").className="input2";
			document.getElementById("apro_tct_no").className="input2";
			
			document.getElementById("agmt_no").readOnly=true;
			document.getElementById("cntr_spec_no").readOnly=true;
			document.getElementById("certi_no").readOnly=true;
			document.getElementById("apro_csc_no").readOnly=true;
			document.getElementById("mft_dt").readOnly=true;
			document.getElementById("apro_tir_no").readOnly=true;
			document.getElementById("fm_ser_no").readOnly=true;
			document.getElementById("to_ser_no").readOnly=true;
			document.getElementById("de_yrmon").readOnly=true;
			
			document.getElementById("fctry_spec_no").readOnly=true;
			document.getElementById("apro_uic_no").readOnly=true;
			document.getElementById("apro_tct_no").readOnly=true;
			document.getElementById("plst_flr_flg").disabled=true;
			document.getElementById("cntr_hngr_rck_cd").disabled=true;*/
		}else{		// inserting시
			ComShowObject(formObj.btns_calendar1, true);
			ComShowObject(formObj.btns_calendar2, true);
			ComShowObject(formObj.ComOpenPopupWithTarget2, true);
			ComShowObject(formObj.ComOpenPopupWithTarget3, true);
			//comboObjects[0].SetEnable(1);
			comboObjects[1].SetEnable(1);
			formObj.fm_ser_no.readOnly=false;
			formObj.to_ser_no.readOnly=false;
			formObj.lot_cntr_pfx_cd.readOnly=false;
		}
	 }
     /**
      * range_change
     */  
	 function range_change1(){
		var formObj=document.form;
		var fm_ser_no=formObj.fm_ser_no.value.trim();
		formObj.range_count.value='';
		if(formObj.fm_ser_no.value.trim().length > 0){
			if(formObj.fm_ser_no.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}
			if(!ComIsNumber(fm_ser_no)){
				ComShowCodeMessage("MST01019", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}
		}
		getRangeCount();
	 }
	 
	 function range_change2(){
		var formObj=document.form;
		formObj.range_count.value='';
		if(formObj.to_ser_no.value.trim().length > 0){
			if(formObj.to_ser_no.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}
		if(formObj.to_ser_no.value.trim().length > 0){
			if(!ComIsNumber(formObj.to_ser_no)){
				ComShowCodeMessage("MST01019", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}
		getRangeCount();
	 }
	 
	 function getRangeCount(){
		var formObj=document.form;
		var fm_no=formObj.fm_ser_no.value.trim();
		var to_no=formObj.to_ser_no.value.trim();
		if(formObj.fm_ser_no.value.trim().length != 6) return;
		if(formObj.to_ser_no.value.trim().length != 6) return;
		var change_count=String(to_no - fm_no + 1);
		formObj.range_count.value=change_count;
		if(eval(formObj.range_count.value) < 1 || eval(formObj.range_count.value) > 9999){
			ComShowCodeMessage("MST01022");
			formObj.to_ser_no.value="";
			formObj.range_count.value="";
			ComSetFocus(formObj.to_ser_no);
			return;
		}
	 }
     /**
      * lstm_cd_change
     */   	
	 function lstm_cd_change(){
		var formObj=document.form;
		var lstm_cd=ComGetObjValue(formObj.lstm_cd);
		if(  lstm_cd == 'OW' || lstm_cd == 'OL' || lstm_cd == 'LP' ){
		}else{
			ComClearObject(formObj.agmt_no);
			ComClearObject(formObj.lstm_cd);
			ComClearObject(formObj.eff_dt);
			ComClearObject(formObj.exp_dt);
			ComClearObject(formObj.vndr_seq);
			ComClearObject(formObj.vndr_lgl_eng_nm);			
			ComShowCodeMessage("MST01003");
		}
	 }
	 
     function cntr_tpsz_cd_change(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
		var cntr_tpsz_cd=ComGetObjValue(formObj.cntr_tpsz_cd);
		
		// Checking the AGMT`s TP/SZ`s 
		doActionIBSheet(sheetObject1, formObj, SEARCH09);
		
		if (cntr_tpsz_cd == "TP/SZ"){
			ComClearObject(formObj.cntr_tpsz_cd);
			ComClearObject(formObj.cntr_spec_no);
			ComClearObject(formObj.vndr_abbr_nm);
		}else unit_type_enableYn();
     }
     
     function vndr_abbr_nm_change(){
		var formObj=document.form;
		var Manfac=ComGetObjValue(formObj.vndr_abbr_nm);
		if (Manfac == "Manufacturer"){
			ComClearObject(formObj.vndr_abbr_nm);			
		}
     }

     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {  	   
    	var cnt=0;
      	switch (sheetObj.id) {
	      	case 'sheet1': 
	      		with(sheetObj){
		      		var HeadTitle="|agmt_no|agmt_cty_cd|agmt_seq|lstm_cd|eff_dt|exp_dt|vndr_seq|vndr_lgl_eng_nm|cntr_spec_no|cntr_tpsz_cd|fctry_spec_no|lot_loc_cd|mft_dt|de_dt|p_time|fm_ser_no|to_ser_no|de_yrmon|plst_flr_flg|cntr_hngr_rck_cd|fa_if_grp_sts_cd|certi_no|apro_csc_no|apro_tir_no|apro_uic_no|apro_tct_no|cntr_mtrl_cd|mft_vndr_seq|lot_cntr_pfx_cd|range_count|diff_rmk|org_agmt_no|org_mft_dt|org_cntr_hngr_rck_cd|org_plst_flr_flg|org_fctry_spec_no|org_de_yrmon|org_certi_no|vndr_abbr_nm|unit_type|rf_mkr_seq|rf_mdl_nm|rf_rfr_no|min_temp|max_temp|org_rf_mkr_seq|org_rf_mdl_nm|org_rf_rfr_no|org_min_temp|org_max_temp|org_rf_humid_ctrl_val_cd|org_rf_cmpr_ctnt|rf_humid_ctrl_val_cd|rf_cmpr_ctnt|mft_yd_cd";
		      		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      		var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      		InitHeaders(headers, info);
		      		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_spec_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fctry_spec_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lot_loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mft_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"de_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_time",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_ser_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_ser_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"de_yrmon",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"plst_flr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fa_if_grp_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_csc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_tir_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_uic_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_tct_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mtrl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mft_vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lot_cntr_pfx_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"range_count",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_mft_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_de_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_cntr_hngr_rck_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_plst_flr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_fctry_spec_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_de_yrmon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_certi_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"unit_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf_mkr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf_mdl_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf_rfr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"min_temp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"max_temp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_rf_mkr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_rf_mdl_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_rf_rfr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_min_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_max_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_rf_humid_ctrl_val_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_rf_cmpr_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf_humid_ctrl_val_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf_cmpr_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"message_err",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		      		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mft_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		      		InitColumns(cols);
		      		SetEditable(1);
		      		//SetSheetHeight(120);
		      		sheetObj.SetVisible(0);
	      		}
	          break;
         }
      }
      /**
       * Combo initializing
       * param : comboObj ==> combo object, comboNo ==> combo object combo object no.
       */ 
      function initCombo(comboObj, comboNo) {
    	    var formObject=document.form;   
    	    var cnt=0 ;
			switch(comboNo) {       
			  case 1: 
				   with (comboObj) { 
						SetColAlign(0, "center");
						SetColAlign(1, "left");
						SetColWidth(0, "100");
						SetColWidth(1, "200");
					    SetDropHeight(160);
				   }   
				   break;   
			  /*case 2: 
				   with (comboObj) { 
						SetColAlign(0, "center");
						SetColWidth(0, "80");
					    SetDropHeight(160);
				   }   
				   break; */
			  case 2: 
				  with (comboObj) { 
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "100");
					SetColWidth(1, "200");
					SetDropHeight(160);
			  		}
				   break; 
	   	      case 3://"vndr_abbr_nm":
				    with (comboObj) { 
						SetColAlign(0, "left");
						SetColWidth(0, "170");
					    SetDropHeight(160);
				   }   
	   	          break;
	   	      case 4://"Humidity Control":
			    with (comboObj) { 
					SetColAlign(0, "left");
					SetColWidth(0, "170");
				    SetDropHeight(160);
			   }   
  	          break;	
			 } 
    	    switch(comboNo) {  
    	          case 1:       	        	  
    				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObj);
    				break; 
				  /*case 2:  					  
		    	      comboObj.SetDropHeight(300);
	           	      var menuname2=sangeText.split('|');
	                  var menucode2=sangeCode.split('|');
	                  comboObj.SetMultiSelect(0);
	                  comboObj.SetMaxSelect(menuname2.length);
	                  comboObj.SetMultiSeparator(",");
	                  //lot_cntr_pfx_cd.InsertItem(cnt++, "", "");
	                  for(i=0; i<menuname2.length; i++) {
	             	     //lot_cntr_pfx_cd.InsertItem(cnt ++, menuname2[i], menucode2[i]);
	             	  }
					break;*/
				  case 3:
					  doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
					  break;
				  case 4:
					  doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC03,comboObj);
					  break;
    	     }     	    
      }     
      
      function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
         sheetObj.ShowDebugMsg(false);
		 sheetObj.SetWaitImageVisible(0);
         switch(sAction) {            					
	        case IBSEARCH_ASYNC02:    
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
				}		    	    
				var sStr=ComGetEtcData(sXml, "comboList");    					
				var arrStr=sStr.split("@");    					
				//MakeComboObject(lot_loc_cd, arrStr, 1, 0); 		    	   
	    	    break;	    
	    	    
            case IBSEARCH_ASYNC01://sheet Combo data
	   	 		formObj.f_cmd.value=SEARCH01;
	   	 		var xmlStr=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
	   		    var chk=xmlStr.indexOf("ERROR");
	   			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
	   			   sheetObj.LoadSearchData(xmlStr,{Sync:1} );
	   			   return;
	   		    }  		
	   			var sStr=ComGetEtcData(xmlStr, "comboList");
	   			var arrStr=sStr.split("@");
	   			MakeComboObject(rf_mkr_seq, arrStr, 1, 0);
	   			break;
         }
		 sheetObj.SetWaitImageVisible(1);
      }
      /**
       * creating combo object(Spec No * Type/Size)
       */
      function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
  		 cmbObj.RemoveAll();
  		 cmbObj.InsertItem(0, "", "");
  		 for (var i=0; i<arrStr.length; i++) {
  		    var arrCode=arrStr[i].split("|");
  			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
  		 }
  		 cmbObj.SetSelectIndex("" ,false);
      }
	  /**
	  * object initailizing 
	  */
	  function objectClear(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// data initailizing
		sheetObj.RemoveAll();
		// screen initailizing
		formObj.reset();
	  }
	  function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	     var sheetObj=sheetObjects[0];
         if (ErrMsg == "") {
        	 //ComShowCodeMessage("MST01025");
         } else {
             sheetObj.SetEtcData("lot_no","");
         }
	  }
	  //handling event activate
	  //handling event deactivate
	  function obj_deactivate() {
		 var formObj=document.form;
		 var obj=ComGetEvent();
	     if (ComGetEvent("name") == "mft_dt"){
	    	 ComAddSeparator(formObj.mft_dt);
	    	 if (ComGetNowInfo("ymd") < formObj.mft_dt.value){
	    		ComAlertFocus(formObj.mft_dt0,ComGetMsg("MST01006", "", "", ""));	    		
	    		formObj.mft_dt.value='';	    		
	    	 } else {
	    		ComAddSeparator(formObj.mft_dt, "ymd");
	    	 }
	     }  else if (ComGetEvent("name") == "max_temp" || ComGetEvent("name") == "min_temp"){
	    	 ComChkObjValid(event.srcElement);
	     } else if(ComGetEvent("name") == "mft_yd_cd"){
			    if (formObj.mft_yd_cd.value == ""){
			    	formObj.mft_yd_cd.value="";
	 		    }
	        	if (formObj.mft_yd_cd.value.length > 0 && formObj.mft_yd_cd.value.length != 7){
	        		ComShowCodeMessage("MST01019", formObj.mft_yd_cd.value);
	        		formObj.mft_yd_cd.value="";
	        		ComSetFocus(formObj.mft_yd_cd);
	        		return;
	        	}
		    }
	     
	  }	
	 // in case of TP/SZ = R, Unit Type disable	
	 function unit_type_enableYn(){
		var formObj=document.form;	

		if(formObj.cntr_tpsz_cd.value.trim().length > 0){
			if(formObj.cntr_tpsz_cd.value.substr(0,1) == 'R'){
				comboObjects[2].SetEnable(1);
				comboObjects[1].SetEnable(1);
				comboObjects[3].SetEnable(1);
				//document.getElementById("lot_cntr_pfx_cd").className="input1";
				document.getElementById("rf_mdl_nm").className="input1";
				document.getElementById("rf_rfr_no").className="input1";
				document.getElementById("min_temp").className="input1";
				document.getElementById("max_temp").className="input1";
				document.getElementById("rf_cmpr_ctnt").className="input";
				//formObj.lot_cntr_pfx_cd.readOnly=false;
				formObj.rf_cmpr_ctnt.readOnly=false;
				formObj.rf_mdl_nm.readOnly=false;
				formObj.rf_rfr_no.readOnly=false;
				formObj.min_temp.readOnly=false;
				formObj.max_temp.readOnly=false;				
			} else{
				comboObjects[2].SetSelectIndex("-1",false);
				comboObjects[2].SetEnable(0);
				comboObjects[1].SetSelectIndex("-1",false);
				comboObjects[1].SetEnable(0);
				comboObjects[3].SetSelectIndex("-1",false);
				comboObjects[3].SetEnable(0);
				formObj.rf_mdl_nm.value="";
				formObj.rf_rfr_no.value="";
				formObj.min_temp.value="";
				formObj.max_temp.value="";
				formObj.rf_mdl_nm.readOnly=true;
				formObj.rf_rfr_no.readOnly=true;
				formObj.min_temp.readOnly=true;
				formObj.max_temp.readOnly=true;		
				formObj.rf_cmpr_ctnt.readOnly=true;
				//formObj.lot_cntr_pfx_cd.readOnly=true;
				//document.getElementById("lot_cntr_pfx_cd").className="input2";
				document.getElementById("rf_cmpr_ctnt").className="input2";
				document.getElementById("rf_mdl_nm").className="input2";
				document.getElementById("rf_rfr_no").className="input2";
				document.getElementById("min_temp").className="input2";
				document.getElementById("max_temp").className="input2";				
			}
		}
	 }
	 /**
	  * adding field to combo item
	  */
	 function addComboItem(comboObj, comboItems) {
		  for ( var i=0; i < comboItems.length; i++) {
	 		var comboItem=comboItems[i].split(",");
	 		 comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	 		   
	 	}
		   comboObj.InsertItem(0,"","");
	 }
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터를 셋팅한다.
	  */
	 function f_change_data_setting(formObj, inputFlg) {
		 if (inputFlg == true) {
			 arr_de_yrmon           [0]=formObj.de_yrmon.value;
			 arr_de_yrmon           [1]=formObj.de_yrmon.value;  
			 arr_fctry_spec_no      [0]=formObj.fctry_spec_no.value;
			 arr_fctry_spec_no      [1]=formObj.fctry_spec_no.value;  
			 arr_certi_no           [0]=formObj.certi_no.value;  
			 arr_certi_no           [1]=formObj.certi_no.value;
			 arr_apro_csc_no        [0]=formObj.apro_csc_no.value;  
			 arr_apro_csc_no        [1]=formObj.apro_csc_no.value;
			 arr_apro_tir_no        [0]=formObj.apro_tir_no.value;  
			 arr_apro_tir_no        [1]=formObj.apro_tir_no.value;
			 arr_apro_uic_no        [0]=formObj.apro_uic_no.value;  
			 arr_apro_uic_no        [1]=formObj.apro_uic_no.value;
			 arr_apro_tct_no        [0]=formObj.apro_tct_no.value;  
			 arr_apro_tct_no        [1]=formObj.apro_tct_no.value;
			 arr_unit_type          [0]=formObj.unit_type.text;  
			 arr_unit_type          [1]=formObj.unit_type.text;
			 arr_plst_flr_flg   [0]=formObj.plst_flr_flg.value;  
			 arr_plst_flr_flg   [1]=formObj.plst_flr_flg.value; 
			 arr_cntr_hngr_rck_cd   [0]=formObj.cntr_hngr_rck_cd.value;  
			 arr_cntr_hngr_rck_cd   [1]=formObj.cntr_hngr_rck_cd.value;
			 arr_rf_mkr_seq         [0]=formObj.rf_mkr_seq.text;  
			 arr_rf_mkr_seq         [1]=formObj.rf_mkr_seq.text;
			 arr_rf_mdl_nm          [0]=formObj.rf_mdl_nm.value;  
			 arr_rf_mdl_nm          [1]=formObj.rf_mdl_nm.value;
			 arr_rf_rfr_no          [0]=formObj.rf_rfr_no.value;  
			 arr_rf_rfr_no          [1]=formObj.rf_rfr_no.value;
			 arr_min_temp           [0]=formObj.min_temp.value;  
			 arr_min_temp           [1]=formObj.min_temp.value;
			 arr_max_temp           [0]=formObj.max_temp.value;  
			 arr_max_temp           [1]=formObj.max_temp.value;
			 arr_diff_rmk           [0]=formObj.diff_rmk.value;  
			 arr_diff_rmk           [1]=formObj.diff_rmk.value;
		 } else {
			 arr_de_yrmon           [0]="";  arr_de_yrmon           [1]="";
			 arr_fctry_spec_no      [0]="";  arr_fctry_spec_no      [1]="";
			 arr_certi_no           [0]="";  arr_certi_no           [1]="";
			 arr_apro_csc_no        [0]="";  arr_apro_csc_no        [1]="";
			 arr_apro_tir_no        [0]="";  arr_apro_tir_no        [1]="";
			 arr_apro_uic_no        [0]="";  arr_apro_uic_no        [1]="";
			 arr_apro_tct_no        [0]="";  arr_apro_tct_no        [1]="";
			 arr_unit_type          [0]="";  arr_unit_type          [1]="";
			 arr_plst_flr_flg   [0]="";  arr_plst_flr_flg   [1]="";
			 arr_cntr_hngr_rck_cd   [0]="";  arr_cntr_hngr_rck_cd   [1]="";
			 arr_rf_mkr_seq         [0]="";  arr_rf_mkr_seq         [1]="";
			 arr_rf_mdl_nm          [0]="";  arr_rf_mdl_nm          [1]="";
			 arr_rf_rfr_no          [0]="";  arr_rf_rfr_no          [1]="";
			 arr_min_temp           [0]="";  arr_min_temp           [1]="";
			 arr_max_temp           [0]="";  arr_max_temp           [1]="";
			 arr_diff_rmk           [0]="";  arr_diff_rmk           [1]="";
		 }
	 }
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터 변경 여부를 리턴한다.
	  * return Value
	  * true : 변경 됨
	  * false : 유지 됨
	  */
	 function f_change_data_checking(formObj) {
		 arr_de_yrmon           [1]=formObj.de_yrmon.value;  
		 arr_fctry_spec_no      [1]=formObj.fctry_spec_no.value;  
		 arr_certi_no           [1]=formObj.certi_no.value;
		 arr_apro_csc_no        [1]=formObj.apro_csc_no.value;
		 arr_apro_tir_no        [1]=formObj.apro_tir_no.value;
		 arr_apro_uic_no        [1]=formObj.apro_uic_no.value;
		 arr_apro_tct_no        [1]=formObj.apro_tct_no.value;
		 arr_unit_type          [1]=formObj.unit_type.text;
		 arr_plst_flr_flg       [1]=formObj.plst_flr_flg.value; 
		 arr_cntr_hngr_rck_cd   [1]=formObj.cntr_hngr_rck_cd.value;
		 arr_rf_mkr_seq         [1]=formObj.rf_mkr_seq.text;
		 arr_rf_mdl_nm          [1]=formObj.rf_mdl_nm.value;
		 arr_rf_rfr_no          [1]=formObj.rf_rfr_no.value;
		 arr_min_temp           [1]=formObj.min_temp.value;
		 arr_max_temp           [1]=formObj.max_temp.value;
		 arr_diff_rmk           [1]=formObj.diff_rmk.value;
		 if ( 
				 (arr_de_yrmon           [0] != arr_de_yrmon         [1] )||
				 (arr_fctry_spec_no      [0] != arr_fctry_spec_no    [1] )||
				 (arr_certi_no           [0] != arr_certi_no         [1] )||
				 (arr_apro_csc_no        [0] != arr_apro_csc_no      [1] )||
				 (arr_apro_tir_no        [0] != arr_apro_tir_no      [1] )||
				 (arr_apro_uic_no        [0] != arr_apro_uic_no      [1] )||
				 (arr_apro_tct_no        [0] != arr_apro_tct_no      [1] )||
				 (arr_unit_type          [0] != arr_unit_type        [1] )||                     
				// (arr_fa_if_grp_sts_cd   [0] != arr_fa_if_grp_sts_cd [1] )||                     
				 (arr_rf_mkr_seq         [0] != arr_rf_mkr_seq       [1] )||                     
				 (arr_rf_mdl_nm          [0] != arr_rf_mdl_nm        [1] )||                     
				 (arr_rf_rfr_no          [0] != arr_rf_rfr_no        [1] )||                     
				 (arr_min_temp           [0] != arr_min_temp         [1] )||                     
				 (arr_max_temp           [0] != arr_max_temp         [1] )||                     
				 (arr_diff_rmk           [0] != arr_diff_rmk         [1] )
			) {
			return  ComShowCodeConfirm("COM130504")  ;
		 } else {
			 return false;
		 }
	 }
