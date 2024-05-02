/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0426.js
*@FileTitle  : RDN Issuance by Regional Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    //
    var gIsMailSend=false;
    var comboObjects=new Array();
    var comboCnt=0;
    //search xml
    var searchXml;
    //event status
    var eventStatus="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
	  * Event handler processing by button name <br>
	  * @return 
	  */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject1=sheetObjects[0];
             var sheetObject2=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
					case "btn_RowAdd":
						doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
						break;
					case "btn_Delete":
						doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
						break;
					case "btn_Retrieve":
						//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
						if(comboObjects[0].GetItemCount() == 0 || getRdnNoTxt() != formObject.rdn_no) {
							setRdnCd();
						} else {
							//removeSearch(formObject);
							doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
						}
				 		break;
					case "btn_New":
						removeAll(document.form);
						break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_Issue":
   						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
						break;
					case "btn_ReIssue":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
						break;
					case "btn_Revise":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
						break;
					case "btn_Cancel":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
						break;
					case "btn_Settle":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05);
						break;
					case "btn_Copy":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC06);
						break;	
					case "btn_Print":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC07);
						break;
					case "btn_Close":
						ComClosePopup(); 
						break;
					case "btn_mail":
					    openGroupWareMailPopup(sheetObjects[0], formObject);
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
         * registering IBSheet Object as list <br>
         * adding process for list in case of needing batch processing with other items <br>
         * defining list on the top of source <br>
         * @param sheet_obj
         * @return 
         */ 
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * registering IBMulti Combo Object as list<br>
         * adding process for list in case of needing batch processing with other items <br>
         * defining list on the top of source <br>
         * @param combo_obj
         * @return
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++]=combo_obj;
     	}
        /**
         * initializing sheet <br>
         * implementing onLoad event handler in body tag <br>
         * adding first-served functions after loading screen. <br>
         * @return 
         */
        function loadPage() {
        	var form=document.form;
       	    sheet1=sheetObjects[1]; //usd amount
       	    sheet2=sheetObjects[2]; 
    		//initializing IBMultiCombo
     	    for(var k=0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }
    		for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
     		}
//			var idx= sheet1.DataInsert();
//			sheet1.SelectCell(idx,"curr_cd");
//   	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    		
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
     	    //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);     		
     	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	         	    
   	        
     	    setSumTxt(sheetObjects[1]);
     	    toggleButtons("");
     	    initIBComboItem();
//     	    comboObjects[0].focus();
 	    	if(form.rdn_no_pop.value != ""){
    			var rdn_no=form.rdn_no_pop.value.toUpperCase();
    			var code=comboObjects[0].FindItem(rdn_no, 0);
    			if(code == "-1") {	
    				eventStatus="INIT";
    				comboObjects[0].InsertItem(0,rdn_no);
    				comboObjects[0].SetSelectText(rdn_no);
    				eventStatus="";
    			}
    			setRdnCd();    			
     	    }
     	    var rctRhqCdPopValue=form.rct_rhq_cd_pop.value;
     	    var rctOfcCdPopValue=form.rct_ofc_cd_pop.value;
 	    	rct_rhq_cd.SetSelectCode(rctRhqCdPopValue);
 	    	rct_ofc_cd.SetSelectCode(rctOfcCdPopValue);
 	    	respb_rhq_cd.SetSelectCode(rctRhqCdPopValue);
 	    	respb_ofc_cd.SetSelectCode(rctOfcCdPopValue);
     	    //form.bl_no.value = "AARE01025401";
 	    	if(form.rdn_no_pop.value != ""){
 	    		setRdnCd(); 			
     	    }
			ComOpenWait(false);
    	}
        /**
         * setting first data after retrieve combo as bl_no<br>
         * @param 
         * @return 
         */
        function setRdnCd() {
        	var formObject=document.form;
        	if (validateForm(sheetObjects[0],formObject,IBSEARCH)) {
				//formObject.rdn_no.value = comboObjects[0].Code;
	        	formObject.f_cmd.value=SEARCH01;
	        	searchXml=sheetObjects[0].GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObject));
//	        	searchXml="<SHEET>\n<ETC-DATA>\n<ETC KEY='Exception'><![CDATA[]]></ETC>\n<ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC>\n</ETC-DATA>\n<DATA COLORDER='rdn_sts_nm|bkg_corr_no|respb_ofc_cd|iss_ofc_cd|pagerows|ibflag|sc_rfa_no|cre_dt|rdn_iss_rsn_cd|bkg_no|upd_usr_id|sts_upd_dt|bl_no|rdn_rmk|rvis_seq|rct_ofc_cd|cre_usr_id|rct_rhq_cd|prog_seq|bl_no_tp|rdn_sts_cd|rev_aud_tool_cd|rdn_no|receiver_rmk|umch_tp_cd|umch_sub_tp_cd|bkg_no_split|umch_rmk|ctrt_tp_cd|respb_rhq_cd|rdn_iss_dt_wk|rdn_iss_dt|upd_dt|bl_no_chk|' COLSEPARATOR='☜☞' TOTAL='1'>\n\t<TR><![CDATA[Issued☜☞☜☞NGBBB☜☞AMERHQ☜☞☜☞☜☞BCN13A0001☜☞2014-07-09☜☞2☜☞BCN300001300☜☞CSCL8888☜☞2014-07-09☜☞BCN300001300☜☞☜☞1☜☞NGBBB☜☞CSCL8888☜☞CHNRHQ☜☞☜☞☜☞IS☜☞1☜☞RDN140003☜☞☜☞D☜☞☜☞☜☞☜☞R☜☞CHNRHQ☜☞28☜☞2014-07-09☜☞2014-07-09 15:42:03.0☜☞]]></TR>\n</DATA>\n</SHEET>\n";
		 		//page reset
				removeSearch(formObject);
		 		ComXml2ComboItem(searchXml, rdn_no_cd, "rdn_no", "rdn_no");
		 		if(comboObjects[0].GetItemCount() > 0) {
		 			comboObjects[0].SetSelectIndex("-1");
		 			comboObjects[0].SetSelectIndex("0");
					if(gIsMailSend) {
						gIsMailSend=false;
						openGroupWareMailPopup(sheetObjects[0], formObject);
						doActionIBSheet2(sheet2, document.form, IBSEARCH);
					}
		 		} else {
		 			ComShowCodeMessage("BKG95010");
		 		}
        	}
        }	
        /**
         * setting returned xml on the page after retrive as RDN No<br>
         * @param searchXml
         * @param formObj
         * @return 
         */
        function setSearchData(searchXml, formObj) {
        	var arrData=ComBkgXml2Array(searchXml,  "rdn_no|rvis_seq|iss_ofc_cd|rdn_sts_cd|rdn_iss_dt|sts_upd_dt" +
							"|rct_rhq_cd|rct_ofc_cd|respb_ofc_cd|umch_tp_cd|umch_sub_tp_cd" +
							"|rdn_iss_rsn_cd|sc_rfa_no|umch_rmk|rdn_rmk|rdn_sts_nm" + 
							"|bkg_no|bkg_no_split|bkg_corr_no|prog_seq|bl_no|respb_rhq_cd|rev_aud_tool_cd|ctrt_tp_cd|rdn_iss_dt_wk");
        	if (arrData != null && arrData.length > 0) {
        		var Data="";
        		for(var i=0;i<arrData.length;i++)
    			{
        			if(arrData[i]!= undefined)
        				{
        					Data=arrData[i];
        					break;
        				}
    			}
	        	formObj.rdn_no.value=Data[0];
	        	formObj.rvis_seq.value=Data[1];
	        	if(Data[2] != "")	formObj.iss_ofc_cd.value=Data[2];
				formObj.rdn_sts_cd.value=Data[3];
				formObj.rdn_iss_dt.value=Data[4];
				formObj.rdn_iss_dt_wk.value=Data[24];				
				formObj.sts_upd_dt.value=Data[5];
				comboObjects[1].SetSelectCode(Data[6]);
				formObj.rct_ofc_cd_hidden.value=Data[7];
				formObj.respb_ofc_cd_hidden.value=Data[8];
				comboObjects[3].SetSelectCode(Data[21]);
				comboObjects[8].SetSelectCode(Data[22]);
				formObj.ctrt_tp_cd.value=Data[23];
				comboObjects[5].SetSelectCode(Data[9]);
				formObj.umch_sub_tp_cd_hidden.value=Data[10];
				comboObjects[7].SetSelectCode(Data[11]);
				formObj.sc_rfa_no.value=Data[12];
				formObj.umch_rmk.value=Data[13];
				formObj.rdn_rmk.value=Data[14];
				formObj.rdn_sts_nm.value=Data[15];
				//BOOKING
				formObj.bkg_no.value=Data[16];
				formObj.bkg_no_split.value=Data[17];
				formObj.bkg_corr_no.value=Data[18];
				//prog_seq
				formObj.prog_seq.value=Data[19];
				//bl_no
				formObj.bl_no.value=Data[20];
				formObj.etc1.value=Data[9];
				formObj.etc2.value=Data[6];
        	}	
			return arrData;
        }
        /**
         * loading IBSHEET COMBO<br>
         */ 
        function initCombo(comboObj, comboNo) {
            switch(comboObj.options.id) {
            case "rdn_no_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                    SetMaxLength(9);
                }
                break;
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;    
            case "rct_ofc_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;
            case "respb_rhq_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;      
            case "respb_ofc_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;  
            case "umch_tp_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                }
                break;    
            case "umch_sub_tp_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                }
                break;       
            case "rdn_iss_rsn_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                }
                break;     
            case "rev_aud_tool_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                }
                break;   
            }
      	}
        /**
         * return code data of comboObjects[0]<br>
         * @return String <br>
         */ 
        function getRdnNoCd() {
      		return comboObjects[0].GetSelectCode();
      	}
        /**
         * return Text data of comboObjects[0]<br>
         * @return String <br>
         */ 
        function getRdnNoTxt() {
      		return comboObjects[0].GetSelectText();
      	}
        /**
         * return code data of comboObjects[1]<br>
         * @return String <br>
         */ 
        function getRctRhqCd() {
      		return comboObjects[1].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[2]<br>
         * @return String <br>
         */ 
        function getRctOfcCd() {
      		return comboObjects[2].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[3]<br>
         * @return String <br>
         */ 
        function getRespbRhqCd() {
      		return comboObjects[3].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[4]<br>
         * @return String <br>
         */ 
        function getRespbOfcCd() {
      		return comboObjects[4].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[5]<br>
         * @return String <br>
         */ 
        function getUmchTpCd() {
      		return comboObjects[5].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[6]<br>
         * @return String <br>
         */ 
        function getUmchSubTpCd() {
      		return comboObjects[6].GetSelectCode();
      	}
        /**
         * return code data of comboObjects[7]<br>
         * @return String <br>
         */ 
        function getRdnIssRsnCd() {
      		return comboObjects[7].GetSelectCode();
      	}
        /**
         * retrieve rct_ofc_cd combo and set hidden data in case of event<br>
         * @param 
         * @return 
         */ 
        function setOfcCd() {
        	var formObj=document.form;
        	formObj.f_cmd.value=COMMAND02;
        	var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, rct_ofc_cd, "cd", "cd");
			comboObjects[2].SetSelectCode(formObj.rct_ofc_cd_hidden.value);
        }
        /**
         * retrieve rct_ofc_cd combo and set hidden data in case of event<br>
         * @param 
         * @return 
         */ 
        function setOfcCd2() {
        	var formObj=document.form;
			formObj.f_cmd.value=COMMAND02;
			formObj.etc2.value=getRespbRhqCd();
			var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, respb_ofc_cd, "cd", "cd");
			comboObjects[4].SetSelectCode(formObj.respb_ofc_cd_hidden.value);
        }
        /**
         * retrieve umch_sub_tp_cd combo and set hidden data in case of event<br>
         * @param 
         * @return 
         */
        function setUmchSubCd() {
        	var formObj=document.form;
        	var errorKind2=umch_sub_tp_cd; 
 			formObj.f_cmd.value=COMMAND05;
 			var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
			errorKind2.RemoveAll();
			ComXml2ComboItem(sXml, errorKind2, "cd", "nm");
			errorKind2.SetSelectCode(formObj.umch_sub_tp_cd_hidden.value);
			if(errorKind2.GetSelectIndex()== "-1" && errorKind2.GetItemCount() > 0) {
				errorKind2.SetSelectIndex("0");
			}
        }
        /**
         * activating in case of changing rdn_no combo<br>
         * @param comboObj
         * @param code    
         * @param text 
         * @return    
         */ 
        function rdn_no_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        	if(eventStatus == "INIT") return;
        	
        	if(NewIdx == -1){
    			rdn_no_cd_setting(comboObj, NewTxt, NewCod);
    		}else{
	     		if(comboObjects[0].GetItemCount() > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
	     			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
	     				var formObj=document.form;
	     				formObj.rdn_no.value=NewCod;
	       		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	     			} 
	     		}
     		} 
       }
        
        function rdn_no_cd_setting(comboObj, NewIdx, NewTxt, NewCod){
    		var formObj=document.form;
    	
    		if(ComIsEmpty(comboObj.GetSelectText())) return;
    		if(comboObj.GetSelectText().length != 9) {
    			ComShowCodeMessage("BKG95018","RDN No\'s","9");
    			//comboObj.focus();
    			return;
    		}
    		
    		if(NewIdx == -1 && formObj.rdn_no.value == NewTxt){
    			return;
    		}
    		
    		//var rdn_no = comboObj.Text.substr(0,3).toUpperCase() + comboObj.Text.substr(3,6)
    		var rdn_no=comboObj.GetSelectText().toUpperCase();
    	
    		var code=comboObj.FindItem(rdn_no, 0);
    		if(code == "-1") {
    			comboObj.RemoveAll();
    			//combo item insert
    			eventStatus="INIT";
    			comboObj.InsertItem(0,rdn_no);
    			comboObj.SetSelectText(rdn_no);
    			//document.form.bl_no.focus();
    			eventStatus="";
    			
    			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
    				formObj.rdn_no.value=NewCod;
    		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    			}		
    		}
    	}        
        /**
         * rdn_no_combo text changes english upper<br>
         * @param 
         * @return   
         */ 
        function setUpperCaseRdnNo() {
        	if(ComIsEmpty(getRdnNoTxt())) return;
			var rdn_no=getRdnNoTxt().toUpperCase();
			comboObjects[0].SetSelectText(rdn_no,false);
       }
        /**
         * acting when focus out rdn_no combo<br>
         * @param comboObj 
         * @return    
         */
        function rdn_no_cd_OnBlur(comboObj) {
        	var formObj=document.form;

        	if(ComIsEmpty(getRdnNoTxt())) return;
			var rdn_no=getRdnNoTxt().toUpperCase();
			var code=comboObj.FindItem(rdn_no, 0);
			if(code == -1 && formObj.rdn_no.value == "") {
				comboObj.RemoveAll();
				//combo item insert
				eventStatus="INIT";
				comboObj.InsertItem(0,rdn_no);
				comboObj.SetSelectText(rdn_no);
				//document.form.bl_no.focus();
				eventStatus="";
			}	
       }
        
 /** 
 * Event handler processing by Keypress<br>
 * checking validation input data proper dataformat<br>
 * @param   
 * @return 
 */ 
function obj_keypress(){
	 
 	if(event.srcElement.dataformat == null) return;

 	switch(event.srcElement.dataformat){
	  	case "ymd": 
	 		ComKeyOnlyNumber(event.srcElement,"-"); 
	 		break;
	  	case "int":
	  	case "number": 	
	  		ComKeyOnlyNumber(event.srcElement);
	  		break;
	  	case "engup":
	  		ComKeyOnlyAlphabet('upper');
	  		break;
	  	case "uppernum":
	  		ComKeyOnlyAlphabet('uppernum');
	  		break;
	  	default:
	  		//ComKeyOnlyNumber(obj);
	  		break;
 	}
  	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	switch(event.srcElement.name){
	  	case "bl_no":
		 	if(ComIsEmpty(event.srcElement.value)) { 
		 		return;
	 		}
		  	if(keyValue == 13 && event.srcElement.value.length == 12){
		 		var btnObj=document.getElementById("btn_retrieve");
		 		if (btnObj) { 
		 			btnObj.fireEvent("onclick"); 
	 			}
		  	}
 		break;
 	}	 

 }         
        
 /** 
 * Event handler processing by Onbeforedeactivate<br>
 * checking validation input data proper dataformat  <br>
 * @param   
 * @return 
 */ 
 function obj_deactivate() {
 	var form = document.form;
 	var formObj = event.srcElement;
     var srcName = formObj.getAttribute("name");
     switch(srcName) {
 		case "bl_no":
         	if(ComIsEmpty(formObj.value)) return;
         	var msg = formObj.caption;
 			if(formObj.value.length != formObj.maxLength && formObj.value.length != 10) {
 				ComShowCodeMessage("BKG95018", msg, "10 or "+formObj.maxLength);
 				ComSetFocus(formObj);
 				return false;
 			} 
 			break;
 		default :
 			ComChkObjValid(formObj);
 	}
 }        
         /**
         * activating in case of change rct_rhq_cd combo<br>
         * @param comboObj
         * @param code    
         * @param text 
         * @return  
         */ 
        function rct_rhq_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
     		if(comboObjects[1].GetItemCount() > 0 && comboObjects[1].GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc2.value=NewCod;
 				if(eventStatus != "IBSEARCH") {
	 				setOfcCd();
 				}	
     		} 
       	}
        /**
         * acting when focus out rct_rhq_cd combo<br>
         * @param comboObj 
         * @return    
         */
      	function rct_rhq_cd_OnBlur(comboObj) {
    		var formObj=document.form;
    		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
    		//alert(code)
    		if (code != null && code.toString() != "") {
				if(comboObjects[3].GetItemCount() > 0 && comboObjects[3].GetSelectIndex()== "-1") {
					comboObjects[3].SetSelectText(comboObj.GetSelectText());
     			}
    		}
    	}
      	/**
         * acting when focus out rct_ofc_cd combo<br>
         * @param comboObj 
         * @return    
         */
      	function rct_ofc_cd_OnBlur(comboObj) {
    		var formObj=document.form;
    		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
    		//alert(code)
    		if (code != null && code != "") {
				if(comboObjects[4].GetItemCount() > 0 && comboObjects[4].GetSelectIndex()== "-1") {
					comboObjects[4].SetSelectText(comboObj.GetSelectText());
     			}
    		}
    	}
        /**
         * activating in case of change respb_rhq_cd combo<br>
         * @param comboObj
         * @param code    
         * @param text 
         * @return    
         */ 
        function respb_rhq_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
     		if(comboObjects[3].GetItemCount() > 0 && comboObjects[3].GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc2.value=NewCod;
				if(eventStatus != "IBSEARCH") {
 		        	formObj.f_cmd.value=COMMAND02;
 		        	var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
 		 			ComXml2ComboItem(sXml, respb_ofc_cd, "cd", "cd");
 					comboObjects[4].SetSelectCode(formObj.respb_ofc_cd_hidden.value);
 				}	
     		} 
       	}
        /**
         * activating in case of change umch_tp_cd combo<br>
         * @param comboObj
         * @param code    
         * @param text 
         * @return  
         */ 
        function umch_tp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
     		if(comboObjects[5].GetItemCount() > 0 && comboObjects[5].GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc1.value=NewCod;
 				if(eventStatus != "IBSEARCH") {
 	 				setUmchSubCd();
 				}	
			} 
       	}
        /**
         * setting bkg data after retrieve when save<br>
         * @param formObj  
         * @return    
         */ 
        function searchBlno(formObj) {
        	if(ComIsEmpty(formObj.bkg_no)) {
	        	formObj.f_cmd.value=SEARCH05;
	        	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObj));
				var arrData=ComBkgXml2Array(sXml,  "bkg_no|bkg_no_split");
    			if (arrData != null && arrData.length > 0) {
    				var Data="";
            		for(var i=0;i<arrData.length;i++)
        			{
            			if(arrData[i]!= undefined)
            				{
            					Data=arrData[i];
            					break;
            				}
        			}
					//BOOKING
					formObj.bkg_no.value=Data[0];
					formObj.bkg_no_split.value=Data[1];
    			}
        	}	
        }
		/**
		 * setting item at the IBMultiCombo<br>
		 * @return 
		 */
		function initIBComboItem() {
		    ComBkgTextCode2ComboItem(rhqComboValue,             rhqComboValue,        	  getComboObject(comboObjects, 'rct_rhq_cd'),      "|", "\t" );
		    ComBkgTextCode2ComboItem(rhqComboValue,             rhqComboValue,         	  getComboObject(comboObjects, 'respb_rhq_cd'),    "|", "\t" );
		    ComBkgTextCode2ComboItem(discrepancyKindComboValue, discrepancyKindComboText, getComboObject(comboObjects, 'umch_tp_cd'),      "|", "\t" );
		    ComBkgTextCode2ComboItem(rdnIssRsnCdComboValue, 	rdnIssRsnCdComboText,     getComboObject(comboObjects, 'rdn_iss_rsn_cd'),  "|", "\t" );
		    ComBkgTextCode2ComboItem(auditToolComboValue, 	    auditToolComboText, 	  getComboObject(comboObjects, 'rev_aud_tool_cd'), "|", "\t" );
		}
 		/**
 	 	* setting sheet initial values and header<br>
  		* @param sheetObj
  		* @param sheetNo
  		* @return 
  		*/  
    	function initSheet(sheetObj,sheetNo) {
    		 var cnt=0;
             var sheetID=sheetObj.id;
             switch(sheetID) {
             		case "sheet0":      //hidden 
	    	             with (sheetObj) {
	    	             }
	    	             break; 
             		case "sheet1":      //sheet1 init
             		    with(sheetObj){
							var HeadTitle="|Sel.|Del Check|Currency|Amount|USD Amount|rdn_no|rvis_seq";
							var headCount=ComCountHeadTitle(HeadTitle);
							SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
							
							var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
							var headers = [ { Text:HeadTitle, Align:"Center"} ];
							InitHeaders(headers, info);
							
							var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							 {Type:"DelCheck",  Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
							 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E" , InputCaseSensitive:1},
							 {Type:"Float",     Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"dr_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"usd_amount",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rdn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rvis_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
							   
							InitColumns(cols);
							SetSheetHeight(125);
							SetEditable(1);
							SetCountPosition(0);
							SetColHidden("del_chk",1);
							SetShowButtonImage(2);
//							var idx= sheetObj.DataInsert();
//							sheetObj.SelectCell(idx,"curr_cd");
             	      }
    					break;
            		case "sheet2": 
            		    with(sheet2){
							var HeadTitle1="ibflag|user_gb|group_gb|usr_id|usr_eml|pre_str|suf_str"
							var headCount = ComCountHeadTitle(HeadTitle1);
							SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
							
							var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
							var headers = [ { Text:HeadTitle1, Align:"Center"} ];
							InitHeaders(headers, info);
							
							var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"user_gb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"group_gb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
							 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"usr_eml",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pre_str",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"suf_str",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
							   
							InitColumns(cols);
							SetSheetHeight(100);
							SetEditable(1);
							SetDataAutoTrim(1);
            	            }
	          			break;    					
    		}
    	}
    	/**
         * handling sheet process <br>
         * 
         * @param sheetObj
         * @param formObj
         * @param sAction 
         * @return 
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
            	case IBSEARCH:      //retrieve
            		eventStatus="IBSEARCH";
            		if (validateForm(sheetObj,formObj,sAction)) {
            		   if ( sheetObj.id == "sheet0") {
						   formObj.f_cmd.value=SEARCH01;
						   var sXml=sheetObj.GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObj));
//						   sXml="<SHEET><ETC-DATA><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC><ETC KEY='Exception'><![CDATA[]]></ETC></ETC-DATA><DATA COLORDER='rdn_sts_nm|bkg_corr_no|respb_ofc_cd|iss_ofc_cd|pagerows|ibflag|sc_rfa_no|cre_dt|rdn_iss_rsn_cd|bkg_no|upd_usr_id|sts_upd_dt|bl_no|rdn_rmk|rvis_seq|rct_ofc_cd|cre_usr_id|rct_rhq_cd|prog_seq|bl_no_tp|rdn_sts_cd|rev_aud_tool_cd|rdn_no|receiver_rmk|umch_tp_cd|umch_sub_tp_cd|bkg_no_split|umch_rmk|ctrt_tp_cd|respb_rhq_cd|rdn_iss_dt_wk|rdn_iss_dt|upd_dt|bl_no_chk|' COLSEPARATOR='☜☞' TOTAL='1'><TR><![CDATA[Issued☜☞☜☞NGBBB☜☞AMERHQ☜☞☜☞☜☞BCN13A0001☜☞2014-07-09☜☞2☜☞BCN300001300☜☞CSCL8888☜☞2014-07-09☜☞BCN300001300☜☞☜☞1☜☞NGBBB☜☞CSCL8888☜☞CHNRHQ☜☞☜☞☜☞IS☜☞1☜☞RDN140003☜☞☜☞D☜☞☜☞☜☞☜☞R☜☞CHNRHQ☜☞28☜☞2014-07-09☜☞2014-07-09 15:42:03.0☜☞]]></TR></DATA></SHEET>"
						   //removeSearch(formObj);
						   var arrData=setSearchData(sXml, formObj);
		       			   if (arrData != null && arrData.length > 0) {
		       					if (formObj.rdn_no.value != "" && formObj.rvis_seq.value != "") {
	       				    		ComOpenWait(true);
			       					sheetObjects[1].SetWaitImageVisible(0);
		       						formObj.f_cmd.value=SEARCH03;
		       						sXml=sheetObjects[0].GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObj));
			       					if(typeof ComGetEtcData(sXml, "regional_rmk") != "undefined" && ComGetEtcData(sXml, "regional_rmk") != "") {
			       						formObj.rdn_rmk.value=ComGetEtcData(sXml, "regional_rmk"); 
			       		 			}
			       					if(typeof ComGetEtcData(sXml, "receipt_rmk") != "undefined" && ComGetEtcData(sXml, "receipt_rmk") != "") {
			       						formObj.receiver_rmk.value=ComGetEtcData(sXml, "receipt_rmk");
			       					}
			       					setOfcCd();
			       					setOfcCd2();
			       	 				setUmchSubCd();
				       		 	 	formObj.f_cmd.value=SEARCH02;
					       		 	var sXml=sheetObj.GetSearchData("ESM_BKG_0426GS.do", FormQueryString(formObj));
					       		 	if (sXml != "") sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
		       					}	
		       			   } else {
		       				   ComShowCodeMessage("BKG95010");
		       			   }
		       			   ComBtnEnable("btn_Print");
            		   } 
    	        	}    
            		eventStatus="";
                    break;
    			case IBSAVE:        
    				//bkg search
    				searchBlno(formObj);
	 				if (!validateForm(sheetObj,document.form,sAction)) {
	 					return false;
	 				}
	 				if (!ComBkgProcessYn("save")) return;
	 				formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObjects[1].GetSaveString();
					if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
						return;
					}
					sParam += "&" + sParamSheet1;
		    		ComOpenWait(true);		
		    		var sXml=sheetObj.GetSaveData("ESM_BKG_0426GS.do", sParam);
		    		sheetObjects[0].LoadSaveData(sXml);
					ComOpenWait(false);
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95033"); // "Saved."
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
	        		break;
    			case IBSEARCH_ASYNC01:        //issue
    				//bkg search
    				formObj.bkg_no.value="";
    				searchBlno(formObj);
	 				if (!validateForm(sheetObj,document.form,sAction)) {
	 					return false;
	 				}
	 				if (!ComShowCodeConfirm("BKG95003", "issue the RDN")) { return; }
    				formObj.f_cmd.value=MULTI01;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObjects[1].GetSaveString();
					if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
						return;
					}
					sParam += "&" + sParamSheet1;
		    		ComOpenWait(true);		
		    		var sXml=sheetObj.GetSaveData("ESM_BKG_0426GS.do", sParam);
		    		sheetObjects[1].LoadSaveData(sXml);
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95035"); // "Issued."
						gIsMailSend=true;
						setRdnCd();	
					}
					ComOpenWait(false);
	   				break;		
    			case IBSEARCH_ASYNC03:        //revise
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "revise the RDN")) {
	   						formObj.f_cmd.value=MULTI05;
	   						var sParam=FormQueryString(formObj);	   						
	   						var sParamSheet1=sheetObjects[1].GetSaveString(true);
	   						if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
	   							return;
	   						}
	   						sParam += "&" + sParamSheet1;
	   						ComOpenWait(true);		
	   						var sXml=sheetObj.GetSaveData("ESM_BKG_0426GS.do", sParam);
	   						sheetObjects[1].LoadSaveData(sXml);
	   						ComOpenWait(false);
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95036"); // "Revised."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}
	   					}	
	   				 }	
	   				 break;		
    			case IBSEARCH_ASYNC04:        //cancel
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "cancel the RDN")) {
	   						formObj.f_cmd.value=MULTI06;
   				    		ComOpenWait(true);		
	   						var sParam=FormQueryString(formObj);
	   						var sXml=sheetObj.GetSaveData("ESM_BKG_0426GS.do", sParam);
	   						ComOpenWait(false);
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95039"); // "Canceled."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}
	   					}	
	   				 }	
	   				 break;	
    			case IBSEARCH_ASYNC05:        //settle
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "settle the RDN")) {
	   						formObj.f_cmd.value=MULTI07;
   				    		ComOpenWait(true);		
   							var sParam=FormQueryString(formObj);
   							var sXml=sheetObj.GetSaveData("ESM_BKG_0426GS.do", sParam);
	   						ComOpenWait(false);
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95037"); // "Settled."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}
	   					}	
	   				 }	
	   				 break;
    			case IBSEARCH_ASYNC06:        //copy
    				if (!validateForm(sheetObj,document.form,sAction)) return;
    				if (!ComShowCodeConfirm("BKG95003", "copy the RDN")) { return; }
    				//rdn no, bl no clear
    				clearKey(formObj);
    				toggleButtons("COPY");
    				setGetRowStatus(sheetObjects[1]);
					ComShowCodeMessage("BKG95038"); // "Copied."	
	   				break;			 
    			case IBINSERT:      
    				var idx=sheetObj.DataInsert();
    				sheetObj.SelectCell(idx,"curr_cd");
                    break;
    			case IBDELETE: 		// Delete
    				//if (validateForm(sheetObj,document.form,sAction)) {
    				if (sheetObj.CheckedRows("chk") <= 0) {
    	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
    	        	}
    	        	deleteRowCheck(sheetObj, "chk");
    				//}	
    	       		break;	 
    			case IBSEARCH_ASYNC07:
    				var popParams="progId=ESM_BKG_0426";
    				comRASCallPop("ESM_BKG_5001", "ESM_BKG_0426", popParams, "");
	    			break;
            }
        }
		/**
		* handling sheet2 process <br>
		* 
		* @param sheetObj
		* @param formObj
		* @param sAction 
		* @return 
		*/
		function doActionIBSheet2(sheetObj, formObj, sAction) {
			var form=document.form;
			sheet2.ShowDebugMsg(false);
		    sheet2.SetWaitImageVisible(0);
			switch(sAction) {
		        case IBSEARCH: 
		        	ComOpenWait(true);
		        	try {
			        	sheet2.RemoveAll();
			        	var params="f_cmd=" + SEARCH06 + "&bl_no=" + formObj.bl_no.value;
			        	var sXml=sheet2.GetSearchData("ESM_BKG_0426GS.do?", params);
			        	sheet2.LoadSearchData(sXml,{Sync:1} );
			    	}catch(e){
			    		ComShowMessage(e.message);
			    	}
		        	ComOpenWait(false);
		        	break;
		        case IBSAVE: 
		        	ComOpenWait(true);
			    	try {
			        	form.f_cmd.value=COMMAND01;
			            var params=FormQueryString(form);
			            params += "&mail_title=[RDN Notice] " + rct_ofc_cd.GetSelectCode()+ " / " + form.rdn_iss_dt.value.replace(/-/g, "") + " / WK";
			            params += "&cont_fm=Audit Team";
			            params += "&rdn_amount=USD " + sheet1.GetSumText(0, "usd_amount");
			            params += "&error_kind=" + umch_tp_cd.GetSelectText()+ " / " + umch_sub_tp_cd.GetSelectText()+ " / " + rdn_iss_rsn_cd.GetSelectText();
			            params += "&" + sheet2.GetSaveString();
			            var sXml=sheet2.GetSaveData("ESM_BKG_0426GS.do", params);
			    	}catch(e){
			    		ComShowMessage(e.message);
			    	}
		        	ComOpenWait(false);
					break;
			}
		}
		/** 
		* checking validation for Error Kind<br>
		* @param  
		* @return 
		*/ 
		function chkErrorKind() {
			var form=document.form;
			var errorKind=umch_tp_cd;
			var errorKind2=umch_sub_tp_cd;
			var errorKind3=rdn_iss_rsn_cd;
		 	if (errorKind.GetSelectCode()== "" || ( errorKind2.GetSelectCode()== "" && errorKind2.GetItemCount() > 0 ) || errorKind3.GetSelectCode()== "") {
		 	    ComShowCodeMessage("BKG95031", "Error Kind");
		 	    if(errorKind.GetSelectCode()== ""){
//		 	    	errorKind.focus();
		 	    }else if(errorKind2.GetSelectCode()== "" && errorKind2.GetItemCount() > 0){
//		 	    	errorKind2.focus();
		 	    }else{
//		 	    	errorKind3.focus();
		 	    }
				return false;
			}
		 	return true;
		}
		/**
	 	* handling process for input validation <br>
		* @param sheetObj
		* @param formObj
		* @param sAction
		* @return boolean
		*/
        function validateForm(sheetObj,formObj,sAction){
			 var form=document.form;
			 switch (sAction) {
   	 		case IBSEARCH: // retrieve
   	 			setUpperCaseRdnNo();
   	 			if (ComIsEmpty(getRdnNoTxt()) && ComIsEmpty(formObj.bl_no)) {
//					ComBkgInputValueFailed("input","RDN No or BL No",comboObjects[0]);
					ComBkgInputValueFailed("input","RDN No or BL No", document.getElementById(comboObjects[0].options.id));
					return false;
	 			} 
	   	 		if (!ComIsEmpty(getRdnNoTxt()) && getRdnNoTxt().length != 9) {
	   	 		    ComShowCodeMessage("BKG95018","RDN No\'s","9");
//		   	 		comboObjects[0].focus();
					return false;
	 			} 
	   	 		if (!ComIsEmpty(formObj.bl_no) && formObj.bl_no.value.length != 12 && formObj.bl_no.value.length != 10) {
	   	 			ComShowCodeMessage("BKG95018","BL No\'s","10 or 12");
//	   	 			formObj.bl_no.focus();
					return false;
	 			}
		   	 	if (!ComIsEmpty(getRdnNoTxt()) && !ComIsEmpty(formObj.bl_no)) {
		   	 		formObj.bl_no.value="";
			 	}
 				formObj.rdn_no.value=getRdnNoTxt();
   				return true;
   	 			break;
   	 		case IBSAVE: 
   	 			var rdn_sts_cd=formObj.rdn_sts_cd.value;
   	 			if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV" || rdn_sts_cd == "ST" || rdn_sts_cd == "CL") {
	   	 			if (ComIsEmpty(formObj.bl_no)) {
						ComBkgInputValueFailed("input","BL No",formObj.bl_no);
						return false;
	   	 			}
		   	 		if (ComIsEmpty(formObj.bkg_no)) {
		   	 			ComShowCodeMessage("BKG95009","BL No");
//		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
			   	 	if (formObj.bl_no.value.length != 12 || formObj.bl_no.value.length != 10) {
			   	 		ComShowCodeMessage("BKG95018","BL No\'s","10 or 12");
//		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
	   	 			if (comboObjects[1].GetSelectCode()== "") {
	   	 				ComBkgInputValueFailed("select","RHQ",comboObjects[1]);
	   	 				return false;
	   	 			}
		   	 		if (comboObjects[2].GetSelectCode()== "") {
		   	 			ComBkgInputValueFailed("select","Receipt Office",comboObjects[2]);
		 				return false;
		 			}
			   	 	if (comboObjects[3].GetSelectCode()== "") {
			   	 		ComBkgInputValueFailed("select","Responsible RHQ",comboObjects[3]);
		 				return false;
		 			}
			   	 	if (comboObjects[4].GetSelectCode()== "") {
			   	 		ComBkgInputValueFailed("select","Responsible Office",comboObjects[4]);
		 				return false;
		 			}
			   	 	if(!chkErrorKind()) { return false; }
			   	 	if (comboObjects[8].GetSelectCode()== "") {
			   	 		ComBkgInputValueFailed("select","Audit Tool",comboObjects[8]);
		 				return false;
		 			}
	           		if (sheetObjects[1].IsDataModified()) {
	   					 var rowM=sheetObjects[1].ColValueDup("curr_cd",false);
	   					 if (rowM >= 0) {
	   						 ComShowCodeMessage("BKG95007");
	   					     return false;
	   				    }	    		
	   				}
	           		if (getValidRowCount(sheetObjects[1]) <= 0) {
   						 ComShowCodeMessage("BKG95034", "RDN Amount");
   					     return false;
	   				}
       	  		} else {
       	  			return false;
       	  		}	
   				return true;
   	 			break;
        	case IBSEARCH_ASYNC01: // ISSUE
        		var rdn_sts_cd=form.rdn_sts_cd.value;
        		var recRHQ=rct_rhq_cd;
        		var rspRHQ=respb_rhq_cd;
        		var recOffice=rct_ofc_cd;
        		var resOffice=respb_ofc_cd;
        		var auditTool=rev_aud_tool_cd;
	 			if(ComIsEmpty(rdn_sts_cd)){
	 				if (ComIsEmpty(formObj.bl_no)) {
						ComBkgInputValueFailed("input","BL No",formObj.bl_no);
						return false;
	   	 			}
		   	 		if (ComIsEmpty(formObj.bkg_no)) {
		   	 		    ComShowCodeMessage("BKG95009","BL No");
//		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
			   	 	if (formObj.bl_no.value.length != 12 && formObj.bl_no.value.length != 10) {
			   	 	    ComShowCodeMessage("BKG95018","BL No\'s","10 or 12");
//		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
			   	 	if (recRHQ.GetSelectCode()== "" || rspRHQ.GetSelectCode()== "") {
			   	 	    ComShowCodeMessage("BKG95031", "Receipt and Responsible RHQ");
			   	 	    if(recRHQ.GetSelectCode()== ""){
//			   	 	    	recRHQ.focus();
			   	 	    }else{
//			   	 	    	rspRHQ.focus();
			   	 	    }
	   	 				return false;
	   	 			}
			   	 	if (recOffice.GetSelectCode()== "" || resOffice.GetSelectCode()== "") {
			   	 	    ComShowCodeMessage("BKG95031", "Receipt and Responsible Office");
			   	 	    if(recOffice.GetSelectCode()== ""){
//			   	 	    	recOffice.focus();
			   	 	    }else{
//			   	 	    	resOffice.focus();
			   	 	    }
	   	 				return false;
	   	 			}
			   	 	if(!chkErrorKind()) { return false; }
			   	 	if (auditTool.GetSelectCode()== "") {
			   	 	    ComShowCodeMessage("BKG95031", "Audit Tool");
//			   	 	    auditTool.focus();
		 				return false;
		 			}
	           		if (sheetObjects[1].IsDataModified()) {
	   					 var rowM=sheetObjects[1].ColValueDup("curr_cd",false);
	   					 if (rowM >= 0) {
	   						 ComShowCodeMessage("BKG95007");
	   					     return false;
	   				    }	    		
	   				}
	           		if (getValidRowCount(sheetObjects[1]) <= 0) {
   						 ComShowCodeMessage("BKG95034", "RDN Amount");
   					     return false;
	   				}
   	  			} else {
   	  				return false;
   	  			}	
				return true;
	 			break;	
        	case IBSEARCH_ASYNC03: // REVISE
        		var tf=true;
	 			var rdn_sts_cd=formObj.rdn_sts_cd.value;
	 			if(rdn_sts_cd == "RR" || rdn_sts_cd == "CR" || rdn_sts_cd == "AC" ){
	 				tf=chkErrorKind();
   	  			} else {
   	  				tf=false;
   	  			}
	 			return tf;
	 			break;	
        	case IBSEARCH_ASYNC04: // CANCEL
	 			var rdn_sts_cd=formObj.rdn_sts_cd.value;
	 			if(rdn_sts_cd == "CR" || rdn_sts_cd == "RR" || rdn_sts_cd == "AC"){
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;
        	case IBSEARCH_ASYNC05: // SATTLE
	 			var rdn_sts_cd=formObj.rdn_sts_cd.value;
	 			if(rdn_sts_cd == "AC"){
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;	
        	case IBSEARCH_ASYNC06: // copy
	 			var rdn_sts_cd=formObj.rdn_sts_cd.value;
	 			if(!ComIsEmpty(rdn_sts_cd)){
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;		
   	 		case IBINSERT: // Row Add
   	 			return true;
   	 			break;
   	 		case IBDELETE: // Delete
   	 			return true;
   	 			break;
   	 		}
            return true;
        }
        function sheet1_OnClick(sheetObj, Row, Col, Value)  {
     		var colName=sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.SetCellValue(Row, "del_chk","0");
     			}
     		}	
     	}
        /**
         * call after retrieve at sheet1<br>
         * reset button after sum
         * @param sheetObj  
         * @param ErrMsg  
         * @return 
         */
    	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
	    	ComOpenWait(false);
    		setSumTxt(sheetObj);
    		resetButton();
    	}
    	/**
         * call after retrieve at sheet1<br>
         * setting total sum and words at last row
         * @param sheetObj  
         * @return 
         */
    	function setSumTxt(sheetObj) {
    		with(sheetObj)
    		{
    			SetSumText(0, "chk","");
    			SetSumText(0, "curr_cd","USD Total");
    			//alert(SumText(0, "curr_cd"));
    			//CellAlign(LastRow, "dr_amt") = daRight;
    			SetCellAlign(LastRow(), "usd_amount","Right");
	    		for (var i=1; i<=SearchRows(); i++) {
	    			SetCellEditable(i, "curr_cd",0);
    		    }
    		}		
    	}
    	/** 
    	* handler event after retrieve sheet2 data<br>
    	* @param  sheetObj  
    	* @param  errMsg 
    	* @return 
    	*/ 
    	function sheet2_OnSearchEnd(sheetObj, errMsg) {
        	try {
        		var form=document.form;
        		if (errMsg == "" && sheet2.RowCount()> 0) {
        		    var startRow2=sheet2.HeaderRows();
        			var endRow2=sheet2.HeaderRows()+ sheet2.RowCount();
        			var userGb, groupGb;
        			for(var i=startRow2; i < endRow2; i++) {
        				userGb=sheet2.GetCellValue(i, "user_gb");
        				groupGb=sheet2.GetCellValue(i, "group_gb");
//        				if(userGb == "TEST_USER") {	/* TEST 용도 */
//        					sheet2.SetRowStatus(i,"I");
//    					}
       					if(userGb == "REAL_USER") {
        					sheet2.SetRowStatus(i,"I");
        				}
        			}
        			doActionIBSheet2(sheetObjects[2], form, IBSAVE);
        	    }
        	}catch(e){
        		ComShowMessage(e.message);
        	}
    	}       	
		/** 
		* setting exchange rate of usd in case of changing sheet2 data<br>
		* @param  sheetObj
		* @param  Row 
		* @param  Col 
		* @param  Value 
		* @return 
		*/ 
		function sheet1_OnChange(sheetObj, Row, Col, Value)  {
			var colNm=sheetObj.ColSaveName(Col);
		  	var formObj=document.form
			switch (colNm) {
			 	case "curr_cd":
			 	case "dr_amt":
			    	var etc1=sheetObj.GetCellValue(Row,"curr_cd"); 
					var etc2=sheetObj.GetCellValue(Row,"dr_amt"); 
					var etc3=formObj.rdn_iss_dt.value.replace(/-/g, "");
					var params="f_cmd=" + COMMAND03;
					params += "&etc1=" + etc1;
					params += "&etc2=" + etc2;
					params += "&etc3=" + etc3;
					var sXml2=sheetObjects[0].GetSearchData("RASCommonGS.do", params);
					if(null == sXml2 || "" == sXml2){
						return;
					}
					var usdAmount=ComGetEtcData(sXml2, "usdAmount");
					sheetObj.SetCellValue(Row, "usd_amount",usdAmount);
			 		break;
			 }
		}
		/** 
		* handler event in case of connecting popup of sheet1<br>
		* @param  sheetObj  
		* @param  Row
		* @param  Col
		* @return  
		*/
		function sheet1_OnPopupClick(sheetObj, Row, Col) {
			var colNm=sheetObj.ColSaveName(Col);
			switch (colNm) {
				case "curr_cd" : // ESM_BKG_0079_08
				    ComOpenPopup('/opuscntr/COM_ENS_N13.do?pgmNo=COM_ENS_N13', 700, 450, 'getCOM_ENC_N13', '1,0,1,1,1', true, true, Row, "curr_cd", 1);
					break;
			}
		}
		/** 
		* acting callback fucntion in case of connecting popup of sheet1<br>
		* @param  rowArray 
		* @param  Row
		* @param  Col
		* @return  
		*/
		function getCOM_ENC_N13(rowArray, Row, Col, sheetIdx) {
			sheetObjects[sheetIdx].SetCellValue(Row, Col,rowArray[0][2]);
		}
		/**
		 * activating and deactivating according to button condition<br>
		 * @param mode    
		 * @return 
		 */
    	function toggleButtons(mode) {
    		switch (mode) {
    		case "":		
    			ComBtnEnable("btn_Retrieve");
    			ComBtnEnable("btn_New");
    			ComBtnDisable("btn_Save");
    			ComBtnEnable("btn_Issue");
    			ComBtnEnable("btn_RowAdd");
    			ComBtnEnable("btn_Delete");
    			ComBtnDisable("btn_Revise");
    			ComBtnDisable("btn_Cancel");
    			ComBtnDisable("btn_Settle");
    			ComBtnDisable("btn_Copy");
    			ComBtnDisable("btn_Print");
    			break;	
    		case "IS":		
    			ComBtnEnable("btn_Retrieve");
    			ComBtnEnable("btn_New");
    			ComBtnEnable("btn_Save");
    			ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
    			ComBtnDisable("btn_Revise");
    			ComBtnDisable("btn_Cancel");
    			ComBtnDisable("btn_Settle");
    			ComBtnEnable("btn_Copy");
    			ComBtnDisable("btn_Print");
    			break;
    		case "RV":		//REVISE
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "CL":		//CANCEL
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "ST":		//SETTLE
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "AC":		//Accepted
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Cancel");
				ComBtnEnable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "CR":		//Cancel Requested
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "RR":		//REVISE Requested
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_Delete");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;
			case "COPY":		//copy
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnEnable("btn_Issue");
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_Delete");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnDisable("btn_Copy");
				ComBtnDisable("btn_Print");
				break;	
    		}	
		}
    	/**
         * activating and deactivating button according to conditiong code after retrieve<br>
         * @param   
         * @return 
         */
    	function resetButton() {
    		var formObj=document.form;
    		var rdn_sts_cd=formObj.rdn_sts_cd.value;
    		toggleButtons(rdn_sts_cd);
    	}
    	/**
         * reset all screen<br>
         * @param formObj    
         * @return 
         */
 	 	function removeAll(formObj) {
 	 		formObj.reset();
 	 		formObj.rdn_no.value     = "";
 	 		formObj.rdn_sts_cd.value = "";
 	 		comboObjects[0].RemoveAll();
 	 		comboObjects[1].SetSelectIndex("-1");
 	 		comboObjects[2].RemoveAll();
 	 		comboObjects[3].SetSelectIndex("-1");
 	 		comboObjects[4].RemoveAll();
 	 		comboObjects[5].SetSelectIndex("-1");
 	 		comboObjects[6].RemoveAll();
 	 		comboObjects[7].SetSelectIndex("-1");
 	 		comboObjects[8].SetSelectIndex("-1");
 	 		sheetObjects[1].RemoveAll();
 	 		doActionIBSheet(sheetObjects[1], formObj, IBINSERT);
 	 		setSumTxt(sheetObjects[1]);
 	 		resetButton();
 	 		comboObjects[0].Focus();
 		}
 	 	/**
         * reset except BLNO and RDN NO<br>
         * @param formObj    
         * @return 
         */
 	 	function removeSearch(formObj) {
 	 		var rdnNo=formObj.rdn_no.value;
 	 		var blNo=formObj.bl_no.value;
 	 		formObj.reset();
 	 		comboObjects[0].RemoveAll();
 	 		comboObjects[1].SetSelectIndex("-1");
 	 		comboObjects[2].RemoveAll();
 	 		comboObjects[3].SetSelectIndex("-1");
 	 		comboObjects[4].RemoveAll();
 	 		comboObjects[5].SetSelectIndex("-1");
 	 		comboObjects[6].RemoveAll();
 	 		comboObjects[7].SetSelectIndex("-1");
 	 		sheetObjects[1].RemoveAll();
 	 		setSumTxt(sheetObjects[1]);
 	 		formObj.bl_no.value=blNo;
 		}
 	 	/**
 	     * Flag sets I in case of RVISE<br>
 	     * @param sheetObj    
 	     * @return 
 	     */
 	 	function setGetRowStatus(sheetObj)  {
 	 		for(var i=1; i<=sheetObj.RowCount(); i++) {
 	 			sheetObj.SetRowStatus(i,"I");
 	 		}
 	 	}
 	 	/**
 	     * clear in case of copy<br>
 	     * @param sheetObj    
 	     * @return 
 	     */
 	 	function clearKey(formObj)  {
 	 		comboObjects[0].RemoveAll();
 	 		formObj.bl_no.value="";
 	 		formObj.rdn_sts_cd.value="";
 	 		formObj.rdn_no.value="";
 	 		formObj.rvis_seq.value="";
 	 		formObj.prog_seq.value="";
 	 		formObj.rdn_sts_cd.value="";
 	 		formObj.rct_ofc_cd_hidden.value="";
 	 		formObj.respb_ofc_cd_hidden.value="";
 	 		formObj.umch_sub_tp_cd_hidden.value="";
 	 		formObj.bkg_no.value="";
 	 		formObj.bkg_no_split.value="";
 	 		formObj.cntBlno.value="";
 	 		formObj.rdn_no_pop.value="";
 	 		formObj.iss_ofc_cd.value=gStrUsr_office_cd;
 	 		formObj.rdn_sts_nm.value="";
 	 		formObj.rdn_iss_dt.value="";
 	 		formObj.sts_upd_dt.value="";
 	 		formObj.sc_rfa_no.value="";
 	 		formObj.bkg_corr_no.value="";
 	 	}
 	/**
     * calling GroupWare Mail Popup<br>
     * @param sheetObj
     * @param formObj
     * @return 
     */
 	function openGroupWareMailPopup(sheetObj, formObj) {
    	var rmk=formObj.rdn_rmk.value;
    	var subject="[RDN Notice] " + rct_ofc_cd.GetSelectCode()+ " / " + formObj.rdn_iss_dt.value.replace(/-/g, "") + " / WK" + " " + formObj.rdn_iss_dt_wk.value;
        var contents="reqcontents;";
     	// mail contents
     	contents += "TO: " + rct_ofc_cd.GetSelectCode()+ "<br>";
     	contents += "FM: " + "PKGSCD_Rev Audit" + "<br>";
     	contents += "<br><br>";
     	contents += "Revenue Debit Note" + "<br>";
     	contents += "<br>";
     	contents += "RDN No : " + formObj.rdn_no.value + "<br>";
     	contents += "RDN Amount : " + "USD " + sheet1.GetSumText(0, "usd_amount") + "<br>";
     	contents += "Issue Date : " + formObj.rdn_iss_dt.value + "<br>";
     	contents += "B/L No : " + formObj.bl_no.value + "<br>";
     	contents += "Contract No : " + formObj.sc_rfa_no.value + "<br>";
     	contents += "<br>";
     	contents += "Error Kind : " + umch_tp_cd.GetSelectText()+ " / " + umch_sub_tp_cd.GetSelectText()+ " / " + rdn_iss_rsn_cd.GetSelectText()+ "<br>";
     	contents += "Remarks(Auditor) :" + "<br>";
     	contents += rmk.split("\r\n").join("<br>") + "<br>";
     	contents += "<br>";
     	contents += "1. If you agree to this debit note, please issue C/A within 5 working days after receipt and the" + "<br>";
     	contents += "collection office should collect the above debited amount from party concerned. And please " + "<br>";
     	contents += "report us the occurrence reason of this error case in details and countermeasures taken/to be" + "<br>";
     	contents += "taken." + "<br>";
     	contents += "<br>";
     	contents += "2. If you disagree to this debit note, please give us your cancel request or revise request" + "<br>";
     	contents += "through \"RDN Receipt by Office\" within 5 working days after receipt." + "<br>";
     	contents += "<br><br>";
     	contents += "Best Regards" + "<br>";
     	formObj.gw_subject.value=subject;
     	formObj.gw_contents.value="";
        formObj.gw_template.value="ESM_BKG_COMM_01T.html";
        formObj.gw_args.value=contents;
//        ComOpenGroupwareMail(sheetObj,formObj);
 	}