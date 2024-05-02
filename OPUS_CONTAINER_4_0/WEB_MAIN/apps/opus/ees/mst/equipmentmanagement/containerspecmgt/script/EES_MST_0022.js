/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0022.js
*@FileTitle  : Container Specification Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
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
 * @class ees_mst_0022 : business script for ees_mst_0022
 */

    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingValue = "N";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() 
    {
		  var sheetObject1=sheetObjects[0];
	      var formObject=document.form;
	      try 
	      	{
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) 
				{
				case "btn_close": 
					ComClosePopup();  
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_ok":
					comPopupOK();
					break;
					
				case "btn_spec":	// calling pop-up 
		         	// selected row.
		        	var selrow=sheetObjects[0].GetSelectRow();
					if ( selrow > 0 )
					{
						document.form.cntr_spec_no.value=sheetObjects[0].GetCellValue(selrow,"cntr_spec_no");
		    			openPopupSpec();
					}
					break;
					
				case "btn_Popup":  // AGMT NO. popup button 
					ComOpenPopupWithTarget('/opuscntr/EES_LSE_0091.do', 850, 480, "agmt_no:agmt_no", "0,0,1", true);
					break;
					
				case "btn_new":
					sheetObject1.RemoveAll();
					comboObjects[0].SetSelectText("ALL");
					comboObjects[1].SetSelectText("ALL");
					formObject.from_spec_yr.value="";
					formObject.to_spec_yr.value="";
					formObject.agmt_no.value="";
					
					
					if(formObject.own_cntr_flg.value = "O"){						
						document.getElementById("th_lessor").style.display = "none";
				    	document.getElementById("td_lessor").style.display = "none";
				    	sheetObjects[0].SetCellValue(0,"vndr_seq","Lessor Code");
				    	sheetObjects[0].SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
//						sheetObject1.SetColHidden('own_vndr_abbr_nm',0);
//						sheetObject1.SetColHidden('lse_vndr_abbr_nm',1);
					}else{
						document.getElementById("th_lessor").style.display = "";
				    	document.getElementById("td_lessor").style.display = "";
				    	sheetObjects[0].SetCellValue(0,"vndr_seq","Lessor Code");
				    	sheetObjects[0].SetCellValue(0,"vndr_lgl_eng_nm","Lessor");		
//						sheetObject1.SetColHidden('own_vndr_abbr_nm',1);
//	                    sheetObject1.SetColHidden('lse_vndr_abbr_nm',0);
					}
					
					formObject.vndr_seq.value="";
					formObject.vndr_nm.value="";
					MstComBtnControl(false, "btn_cntrlist");
				break;
					

				case "btn_cntrlist":
					var formObj = document.form;
					var lotNo ="";
					var hid_type ="";
					formObj.f_cmd.value = "";
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var selrow=sheetObjects[0].GetSelectRow();
						
						if(sheetObjects[0].GetCellValue(selrow,"cntr_spec_type_cd") =="Own") {
							hid_type = "2";
						} else {
							hid_type = "3";
						}
						lotNo = sheetObjects[0].GetCellValue(selrow,"lot_no");

						if(sheetObjects[0].GetCellValue(selrow,"ttl_act_qty") > 0) ComOpenWindowCenter("/opuscntr/EES_MST_0055.do?hid_type="+hid_type+"&lot_no="+lotNo, "EES_MST_0055", 885, 455);
		                						
					}
		    	break;
		    	
				case "btns_search2":		// Lessor(Service Provider) Pop-up
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 500, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_downexcel":

					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
					break;
			} // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
     		} else {
     			ComShowCodeMessage("MST00011",e);
     		}
     	}
     }
    
    /**
	 * Lessor(Service Provider) Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	
     /**
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj)
     {
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 	/**
 	 * registering IBMultiCombo Object as list
 	 * adding process for list in case of needing batch processing with other items 
 	 * defining list on the top of source
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage()      
     {
    	 document.form.own_cntr_flg.value = document.form.rcv_own_cntr_flg.value;
    	  
    	 if(document.form.active_flag.value=="" || document.form.active_flag.value=="4")	// in case of called as main, OWN is default
         {
        	document.form.own_cntr_flg.value="O";
         }
    	 if(document.form.active_flag.value=="5")	// in case of called as main, Lease is default
         {
        	document.form.own_cntr_flg.value == "L";
         }
    	 
         for(i=0;i<sheetObjects.length;i++)
         {
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
 	   //Axon handling event1. event catch
         
       if(document.form.own_cntr_flg.value =="O") {
    	   document.getElementById("th_lessor").style.display = "none";
    	   document.getElementById("td_lessor").style.display = "none";
    	   sheetObjects[0].SetCellValue(0,"vndr_seq","Lessor Code");
    	   sheetObjects[0].SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
       }else{
    	   document.getElementById("th_lessor").style.display = "";
    	   document.getElementById("td_lessor").style.display = "";
    	   sheetObjects[0].SetCellValue(0,"vndr_seq","Lessor Code");
    	   sheetObjects[0].SetCellValue(0,"vndr_lgl_eng_nm","Lessor");	
       }
       
       if(document.form.vndr_seq.value != "") {
    	   loadingValue = "Y";
    	   document.form.vndr_seq.readOnly = true;
    	   document.form.vndr_nm.readOnly = true;
    	   ComEnableObject(document.form.btns_search2, false);
       }
       
  	   axon_event.addListenerForm('blur',    'obj_deactivate', form); //- handling on blur event
  	   axon_event.addListenerFormat('focus', 'obj_activate',   form); //- handling on focus event
  	   //axon_event.addListenerFormat('keypress',    'obj_keypress',   form); //- handling on key press event
  	   axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
  	   axon_event.addListener("change", "obj_own_cntr_flg_change", "own_cntr_flg");
  	   sheet1_OnLoadFinish(sheet1);
     }
     function sheet1_OnLoadFinish(sheetObj){
        sheetObj.SetWaitImageVisible(0);
        MstComBtnControl(false, "btn_cntrlist");
  		for ( k=0 ; k < comboObjects.length ; k++ ) {
  	        initCombo(comboObjects[k], k+1);
  	    }
  		
  		if(document.form.active_flag.value =="") {
  			$("select[name='own_cntr_flg'] option").remove();   		
  			$('#own_cntr_flg').append('<option value="A">All</option>');
  			$('#own_cntr_flg').append('<option value="O">Own</option>');
	   		$('#own_cntr_flg').append('<option value="L">Lease</option>');
	   		$('#own_cntr_flg').append('<option value="S">Standard</option>');
	   		
	   		sheetObj.SetColHidden("cntr_spec_type_cd",0);
	  		sheetObjects[0].SetColHidden("lot_no",1);
  		}else if(document.form.active_flag.value=="1")			// in case of called from EES_MST_0016.do
     	{
     		document.form.own_cntr_flg.disabled=true;
         	if(document.form.lot_no.value!="")	
         	{
         		comboObjects[0].SetEnable(0);
         	}
         	else
         	{
         		document.form.agmt_no.value="";
         	}         	
         	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	}
     	else if(document.form.active_flag.value=="2")	// in case of called from EES_MST_0021.do
  		{
     		if(document.form.own_cntr_flg.value == "") {
     			document.form.own_cntr_flg.value = "O";
     		}
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}
     	else if(document.form.active_flag.value=="3")	// in case of called from EES_LSE_0001.do
  		{
     		if(document.form.rcv_own_cntr_flg.value == "T") {
   	   		 	$("select[name='own_cntr_flg'] option").remove();   		 
   	   		 	$('#own_cntr_flg').append('<option value="L">Lease</option>');
   	   		 	$('#own_cntr_flg').append('<option value="S">Standard</option>');
   	   		 
   	   		 	document.form.own_cntr_flg.disabled=false;
   	   		 	comboObjects[0].SetEnable(0);
   	   		 	comboObjects[1].SetEnable(0);
     	    }else{
     	    	document.form.own_cntr_flg.disabled=true;
     	    	comboObjects[0].SetEnable(0);
     	    	comboObjects[1].SetEnable(0);
     	    }
     		if(document.form.own_cntr_flg.value =="O") {
     			sheetObjects[0].SetColHidden("lot_no",0);
     		}else{
     			sheetObjects[0].SetColHidden("lot_no",1);
     		}     		
     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}else if(document.form.active_flag.value=="4")	{
  			document.form.own_cntr_flg.disabled=true;
     		comboObjects[0].SetEnable(0);
     		comboObjects[1].SetEnable(0);
     		if(document.form.own_cntr_flg.value =="O") {
     			sheetObjects[0].SetColHidden("lot_no",0);
     		}else{
     			sheetObjects[0].SetColHidden("lot_no",1);
     		}
     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}else if(document.form.active_flag.value=="5")	{
  			document.form.own_cntr_flg.disabled=true;
     		comboObjects[0].SetEnable(0);
     		comboObjects[1].SetEnable(0);
     		if(document.form.own_cntr_flg.value =="O") {
     			sheetObjects[0].SetColHidden("lot_no",0);
     		}else{
     			sheetObjects[0].SetColHidden("lot_no",1);
     		}
  		}
         sheetObj.SetWaitImageVisible(1);
	}
     
     
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	with(sheetObj) {
     		var formObj = document.form;
     		if(sheetObjects[0].RowCount() < 1 ){
     			MstComBtnControl(false, "btn_cntrlist");
     		}
     		else {
     			MstComBtnControl(true, "btn_cntrlist");
     			
     			if(formObj.own_cntr_flg.value == "O") {
     				var strLotYear = "";
         			for(var i=1;i<sheetObjects[0].RowCount()+1;i++) {
         				strLotYear = sheetObj.GetCellValue(i,"cntr_spec_no");
         				if(strLotYear != "") {
         					sheetObj.SetCellValue(i,"yr_build",strLotYear.substring(0,4),0);
         				}
         			}
         		}
     		}
//     		formObj.term_cng_seq.value = "";
     	}
     }
     
     
   	//handling event deactivate
   	function obj_deactivate(){
   	    ComChkObjValid(ComGetEvent());
   	}
   	function obj_activate(){
   	    ComClearSeparator(ComGetEvent());
   	}
//   	function obj_keypress(){
//   	    obj=ComGetEvent();
//   	    if(obj.dataformat == null) return;
//   	    window.defaultStatus=obj.dataformat;
//   	    switch(obj.dataformat) {
//   	        case "ymd":
//   	        case "ym":
//   	        case "hms":
//   	        case "hm":
//   	        case "jumin":
//   	        case "saupja":
//   	            ComKeyOnlyNumber(obj);
//   	            break;
//   	        case "int":
//   	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
//   	            else ComKeyOnlyNumber(obj);
//   	            break;
//   	        case "float":
//   	            ComKeyOnlyNumber(obj, "-.");
//   	            break;
//   	        case "eng":
//   	            ComKeyOnlyAlphabet(); break;
//   	        case "engup":
//   	            if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum')
//   	            else if(obj.name=="from_spec_yr" || obj.name=="to_spec_yr") ComKeyOnlyNumber(obj)
//   	            else ComKeyOnlyAlphabet('upper');
//   	            break;
//   	        case "engdn":
//   	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//   	            else ComKeyOnlyAlphabet('lower');
//   	            break;
//   	    }
//   	}
   /**
   * setting sheet initial values and header
   * param : sheetObj, sheetNo
   * adding case as numbers of counting sheets
   */
   function initSheet(sheetObj,sheetNo) 
     {
    	 var formObject=document.form;    	  
         var cnt=0;
		 var sheetID=sheetObj.id;
         switch(sheetID) 
         	{
             case "sheet1":
            	    with(sheetObj){
                 		var HeadTitle="";
                 		HeadTitle="|Seq.|SPEC No.|SPEC Classification|F. SPEC No.|AGMT No.|Term|Lessor Code|Lessor|Year Build|Lot No.|TP/SZ||Manufacturer||Material|Serial Range|Qty|Active Qty|Unit Type|Humidity Control|Compressor|Hanger Rack|P.Floor|Maker|Model No.|Refrigerant|Max Setting Temp(℃)|Bed Thick|Collapsible|Roof Opening|Rear Head Opening|Interior Height|Capacity(CBM)|Gross Weight(KG)|Tare Weight(KG)|Pay Load(KG)|External Length(mm)|External Width(mm)|External Height(mm)|Internal Length(mm)|Internal Width(mm)|Internal Height(mm)|Open Door Width(mm)|Open Door Height(mm)|Reefer Cargo Loadable Capacity(CBM)|Reefer Cargo Loadable Height(mm)|Tank Capacity(CBM)";

                 		SetConfig( { SearchMode:2} );
                 		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 		var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 		InitHeaders(headers, info);
                 var cols = [ 
                        {Type:"Status",    Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_type_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fctry_spec_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"yr_build",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"lot_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hid_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",        	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mtrl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mtrl_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ser_range",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_lot_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_act_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rf_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rf_humid_ctrl_val_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //Humidity Control
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rf_cmpr_ctnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //Compressor
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"plst_flr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rf_mkr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rf_mdl_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rf_rfr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"max_temp",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"frack_bed_tik_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //Bed Thick
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"frack_clps_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"opntp_roof_opn_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"opntp_rear_hdr_opn_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"opntp_intr_hgt_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"lod_capa",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"cntr_grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"tare_wgt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"pay_load",                KeyField:0,   CalcLogic:"|cntr_grs_wgt|-|tare_wgt|",Format:"",      PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"xter_len",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"xter_wdt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"xter_hgt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"inter_len",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"inter_wdt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"inter_hgt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"opn_dor_wdt",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"opn_dor_hgt",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:240,  Align:"Right",   ColMerge:0,   SaveName:"rc_ldb_capa",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Int",       Hidden:0,  Width:240,  Align:"Right",   ColMerge:0,   SaveName:"rc_ldb_hgt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"tnk_capa",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 		InitColumns(cols);
                 		SetEditable(0);
                 		//SetSheetHeight(420);
                 		resizeSheet();
                     }
                 break;
         }
    }
  	/**
  	 * setting combo initial values and header
  	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
  	 * 
  	 */
  	function initCombo(comboObj, comboNo) {
  	    switch(comboObj.options.id) {
  	        case "combo1":
  	        	with(comboObj) {
  	            	SetDropHeight(200);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetMultiSeparator(",");
  	            	// default is null
  	            	comboObj.InsertItem(0, 'ALL', 'ALL');
  	            	Style=0;
  	            	SetUseAutoComplete(1);
// 	            	SetMaxLength(2);// 2 character available
  	            }
  	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
  	        	break;
  	      case "combo2":
	        	with(comboObj) {
	            	SetDropHeight(250);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	comboObj.InsertItem(0, 'ALL', '');
	            	Style=0;
  	            	SetUseAutoComplete(1);
	            }
	        	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	        	break;
  	    }
  	}
  	
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) 
    {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) 
         {
			case IBCREATE:
	      		formObj.f_cmd.value=SEARCH02;
	         	sheetObj.SetWaitImageVisible(0);
	         	var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
		        sheetObj.SetWaitImageVisible(1);
			    var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
			    }
	            if ( sXml != "" ) {
		            var sCntrTpSzCd=ComGetEtcData(sXml,"cntr_tpsz_cd");
		            var arrCntrTpSzCd=sCntrTpSzCd.split("|");
		            MstMakeComboObject(comboObjects[0], arrCntrTpSzCd, arrCntrTpSzCd);
		            // setting default value
		            if(formObj.cntr_tpsz_cd.value!="")
		            {
		            	comboObjects[0].SetSelectIndex(comboObjects[0].FindItem(formObj.cntr_tpsz_cd.value,0));
		            }
		            else
		            {
		            	comboObjects[0].SetSelectIndex(0);
		            	formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObjects[0]);
		            }
		            comboObjects[0].SetSelectText(formObj.cntr_tpsz_cd.value);
	            }
	            
	            
	            break;
			case IBSEARCH_ASYNC01:
	            formObj.f_cmd.value=SEARCH01;
	            sheetObj.SetWaitImageVisible(0);
 	         	var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
 	         	sheetObj.SetWaitImageVisible(1);
			    var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
			    }
	            if ( sXml != "" ) {
	            	// "ALL" Item Insert
		            var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
		            var arrLeaseTermCd=sLeaseTermCd.split("|");
		            MstMakeComboObject(comboObjects[1], arrLeaseTermCd, arrLeaseTermCd);
		            if(formObj.lstm_cd.value!="")
		            {
		            	comboObjects[1].SetSelectIndex(comboObjects[1].FindItem(formObj.lstm_cd.value,0));
		            }
		            else
		            {
		            	comboObjects[1].SetSelectIndex(0);
		            	formObj.lstm_cd.value=ComGetObjValue(comboObjects[1]);
		            }
		            
		            if(formObj.lstm_cd.value == "") {
		            	comboObjects[1].SetSelectText("ALL");
		            }else{
		            	comboObjects[1].SetSelectText(formObj.lstm_cd.value);
		            }
		            
	            }
	            break;
			case IBSEARCH:      //retrieve
		 			if(sheetObj.id == "sheet1") 
		 				MstComBtnControl(true, "btn_cntrlist");
		 			{
		 				sheetObj.SetWaitImageVisible(0);		 	           
		 				if(validateForm(sheetObj,formObj,sAction)){
		 					 ComOpenWait(true);
		 				    setTimeout( function () {
				 				formObj.f_cmd.value=SEARCH;
				 				var xml="";
				 				xml=sheetObj.GetSearchData("EES_MST_0022GS.do", FormQueryString(formObj));
				 				sheetObj.LoadSearchData(xml,{Sync:1} );
				 				ComOpenWait(false);
		 					}, 100);
		 				}
		 				
		 				sheetObj.SetWaitImageVisible(1);
		 			}
			break;
         }
    }
    
	
	
    /**
     * handling double click event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnDblClick(SheetObj, Row, Col, Value){
	}
    /**
    * Pop-up Open 부분<br>
    */
    function openPopupSpec() 
    {
 		var formObj=document.form;
 		var sUrl='/opuscntr/EES_MST_0021_POP.do';
 		var iWidth=1010;
 		var iHeight=610;
 		var sTargetObjList="cntr_spec_no:cntr_spec_no";
 		var sDisplay="0,1";
 		var param="?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";
 		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
    } 	
  	/**
  	 * combo1_OnChange
  	 */
  	function combo1_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
  		var formObj=document.form;
  		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
  	}
  	
  	/**
	 * combo1_OnChange
	 */
	function combo2_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
		var formObj=document.form;
		formObj.lstm_cd.value=comboObj.GetSelectCode();
	}
	
  	/**
  	 * combo1_OnKeyDown
  	 */
  	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
  		with(comboObj) {
  			if ( KeyCode == 8 || KeyCode == 46 ) {
  				for ( i=0 ; i < GetItemCount() ; i++ ) {
  					if ( CheckIndex(i) ) {
  						CheckIndex(i)=false;
  					}
  				}
  			}
  		}
  	}
  	 /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
   	  with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
    		 	 		var dt1=ComReplaceStr(from_spec_yr.value,"-","");
	         			var dt2=ComReplaceStr(to_spec_yr.value,"-","");
						if(dt1 != '' && dt2 != ''){
	     	    			if(dt2 < dt1){
	     	    				ComShowCodeMessage('COM12133','To year','From year','greater');
	     	    				from_spec_yr.value='';
	     	    				from_spec_yr.focus();
	     	    				return false;
	     	    			}else{
	     	    				
	     	    			}
	     	    		}
           		   break;
			 }
		  }
   	return true;
	 }
    
    //SHEET SIZE 자동 조절 함수 
	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}

	//SHEET SIZE 자동 조절 함수
	function obj_own_cntr_flg_change(){
		var sheetObject1=sheetObjects[0];
	    var formObject=document.form;
		var HeadTitle='';
		sheetObject1.RemoveAll();	
		if(loadingValue == "N") {
			formObject.vndr_seq.value = "";
			formObject.vndr_nm.value = "";
		}
		switch (formObject.own_cntr_flg.value) {
		case "A":
			document.getElementById("th_lessor").style.display = "none";
	    	document.getElementById("td_lessor").style.display = "none";
	    	sheetObject1.SetCellValue(0,"vndr_seq","Lessor Code");
	    	sheetObject1.SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
//			sheetObject1.SetColHidden('own_vndr_abbr_nm',0);
//			sheetObject1.SetColHidden('lse_vndr_abbr_nm',1);
	    	
	    	sheetObject1.SetColHidden("lot_no",1);
	    	sheetObject1.SetColHidden("ser_range",0);
			break;
		case "O":
			document.getElementById("th_lessor").style.display = "none";
	    	document.getElementById("td_lessor").style.display = "none";
	    	sheetObject1.SetCellValue(0,"vndr_seq","Lessor Code");
	    	sheetObject1.SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
//			sheetObject1.SetColHidden('own_vndr_abbr_nm',0);
//			sheetObject1.SetColHidden('lse_vndr_abbr_nm',1);
	    	
	    	sheetObject1.SetColHidden("lot_no",0);
	    	sheetObject1.SetColHidden("ser_range",0);
			break;
		case "L":
			document.getElementById("th_lessor").style.display = "";
	    	document.getElementById("td_lessor").style.display = "";
	    	sheetObject1.SetCellValue(0,"vndr_seq","Lessor Code");
	    	sheetObject1.SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
//			sheetObject1.SetColHidden('own_vndr_abbr_nm',1);
//            sheetObject1.SetColHidden('lse_vndr_abbr_nm',0);
	    	sheetObject1.SetColHidden("lot_no",1);
	    	sheetObject1.SetColHidden("ser_range",0);
	    	
	    	if(formObject.h_lessor.value !="") {
		    	formObject.vndr_seq.value=formObject.h_lessor.value;
				formObject.vndr_nm.value=formObject.h_lessor_nm.value;	    		
	    	}
	    	
			break;
		case "S":
			document.getElementById("th_lessor").style.display = "";
	    	document.getElementById("td_lessor").style.display = "";
	    	sheetObject1.SetCellValue(0,"vndr_seq","Lessor Code");
	    	sheetObject1.SetCellValue(0,"vndr_lgl_eng_nm","Lessor");
//			sheetObject1.SetColHidden('own_vndr_abbr_nm',1);
//            sheetObject1.SetColHidden('lse_vndr_abbr_nm',0);
	    	sheetObject1.SetColHidden("lot_no",1);
	    	sheetObject1.SetColHidden("ser_range",0);
	    	if(formObject.h_lessor.value !="") {
		    	formObject.vndr_seq.value="";
				formObject.vndr_nm.value="";	    		
	    	}
			break;
		} // end switch		
				
	}	
	