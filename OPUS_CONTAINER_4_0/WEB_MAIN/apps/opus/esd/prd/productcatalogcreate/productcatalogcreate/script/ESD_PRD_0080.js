/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0080.js
*@FileTitle  : Product Catalog
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/ 
var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var updChk=1;
 var moreCnt = 0;
 var sheet1CheckRow = 0;
 document.onclick=processButtonClick;
     function processButtonClick(){
          var shtCnt=0;
          var sheetObject=sheetObjects[shtCnt++];
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 				switch(srcName) {
		            case "btn_select": {
		            	
		            	var formObj		= document.form;
		            	
		            	ComOpenWait(true);
		            	if(formObject.pc_mode.value == 'R'){
		            		updatePrdMap();
		            	}
		            	ComOpenWait(false);
		            	if(updChk == 1){
		            		var callFunc=formObject.calllFunc.value;
		            		var pcNo='';
		            		var copMapSeq='';
		            		var selRownum='';
		            		for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
		            			if(sheetObjects[0].GetCellValue(i, "chk") == true){
		            				selRownum=i;
		            				break;
		            			}
		            		}
		            		
		            		/////////////////////////////////////////////////////////////////////////////////
		            		/////////////////////////////////////////////////////////////////////////////////
		            		var org_bkg_no	= "";
		            		var openerObj	= window.dialogArguments;
			            	if(!openerObj) 	openerObj = parent;
			            	
			            	if(		openerObj 						!= null && openerObj 						!= undefined 
			            		&&	openerObj.document.form 		!= null && openerObj.document.form 			!= undefined
			            		&&	openerObj.document.form.bkg_no 	!= null	&& openerObj.document.form.bkg_no 	!= undefined
			            	  )
			            	{
			            		
			            		org_bkg_no	= openerObj.document.form.bkg_no.value;

				            	var full_cgo_cut_off_tm		= sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cut_off");
				            	var full_cgo_cut_off_yd_cd	= sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cut_off_yd_cd");
				            	
				            	//alert('org_bkg_no <<<'+org_bkg_no+'>>> :: full_cgo_cut_off_tm <<<'+full_cgo_cut_off_tm+'>>> :: full_cgo_cut_off_yd_cd ['+full_cgo_cut_off_yd_cd+']');
				            	
				    			var sParam			= "f_cmd="+SEARCH21+"&full_cgo_cut_off_tm="+full_cgo_cut_off_tm+"&full_cgo_cut_off_yd_cd="+full_cgo_cut_off_yd_cd; 
				    			var sXml			= sheetObjects[0].GetSearchData("ESD_PRD_COM_0001.do", sParam);
				    			
				    			var isInThePast		= ComGetEtcData(sXml, "IS_IN_THE_PAST");
				    			//alert('isInThePast <<'+isInThePast+'>>');
				    			
				    			if((org_bkg_no == null || org_bkg_no == "") && isInThePast != undefined && isInThePast == "Y"){
				    				//ComShowCodeMessage('PRD00092');		//'PRD00092' : "Full cargo cut off time is in the past";
				    				if(!ComShowCodeConfirm('PRD00092'))	return false;
				    			}
			            		
			            	}
			    			/////////////////////////////////////////////////////////////////////////////////
			    			/////////////////////////////////////////////////////////////////////////////////
			            	
			    			
		            		
		            		if(Number(sheetObjects[0].GetCellValue(selRownum,"osca_vvd_flg")) > 0 ) {
		            			var chkVvdLnkNo = sheetObjects[0].GetCellValue(selRownum,"vvd_lnk_no");
		            			if(chkVvdLnkNo == 1) {
		            				ComShowCodeMessage('PRD00086', sheetObjects[0].GetCellValue(selRownum,"n1st_vsl_slan_cd").replace(/\r\n+/g, " "));
		            				return false;
		            			} else if(chkVvdLnkNo == 2) {
		            				ComShowCodeMessage('PRD00086', sheetObjects[0].GetCellValue(selRownum,"n2nd_vsl_slan_cd").replace(/\r\n+/g, " "));
		            				return false;
		            			} else if(chkVvdLnkNo == 3) {
		            				ComShowCodeMessage('PRD00086', sheetObjects[0].GetCellValue(selRownum,"n3rd_vsl_slan_cd").replace(/\r\n+/g, " "));
		            				return false;
		            			} else if(chkVvdLnkNo == 4) {
		            				ComShowCodeMessage('PRD00086', sheetObjects[0].GetCellValue(selRownum,"n4st_vsl_slan_cd").replace(/\r\n+/g, " "));
		            				return false;
		            			}
		            		}
		            		if(callFunc != ''){
		            			if(!chkVal(selRownum)){
		            				if(formObject.valChk.value != 'Y') {
		            					var url="ESD_PRD_0083.do?f_cmd="+""+"&pctl_no="+sheetObjects[0].GetCellValue(selRownum,"pctl_no");
		            					ComOpenPopup(url, 590, 495, "callBackEsdPrd0083",	"1,0,1,1,1", true);	
		            				}
		            			} else {
		            				formObject.valChk.value="Y";
		            			}
		            			pcNo=sheetObjects[0].GetCellValue(selRownum,"pctl_no");
		            			if(formObject.valChk.value == "Y") {
		            				if($('#por').val() != $('#d_por_cd').val() || $('#del').val() != $('#d_del_cd').val()) {
			            				if(!ComShowCodeConfirm("PRD00085")) {
			            					return false;
			            				}
			            			}
		            				copMapSeq=formObject.map_seq.value;
		            				if (opener == null) {
		            					opener=parent;
		            				} else {
										opener=window.opener;
									}
		            				eval('opener.'+callFunc)(pcNo+'|'+copMapSeq);
		            				ComClosePopup(); 
		            			}
		            		}
		            	} else {
		            		ComShowMessage(ComGetMsg('PRD90114'));
		            	}
		            	break;
		            }
		         	case "btns_LddCalendar": {
			            var cal=new ComCalendar();
			            cal.setReturnFunction("funLddCalendarCallback");
			            cal.select(formObject.fm_ld_dt, 'yyyy-MM-dd');
			            break; 
		         	}
		         	case "btns_EmptyCalendar": {
			            var cal=new ComCalendar();
			            cal.select(formObject.fm_empty_dt, 'yyyy-MM-dd'); 
			            break;
		         	}
		         	case "btng_fullroute": {
		            	var selRownum='';
 			       		for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
 			       			if(sheetObjects[0].GetCellValue(i, "chk") == true){
		    					selRownum=i;
		    				}
			    		}
 			       		var url="ESD_PRD_0081.do?pctl_no="+sheetObjects[0].GetCellValue(selRownum,"pctl_no");
		         		ComOpenPopup(url, 800, 460, "",	"1,0,1,1,1", true);
		         		break;
		         	}
		         	case "btng_constraints": {
		            	var selRownum='';
 			       		for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
 			       			if(sheetObjects[0].GetCellValue(i, "chk") == true){
		    					selRownum=i;
		    				}
			    		}
 			       		var url="ESD_PRD_0082.do?f_cmd="+SEARCHLIST+"&pctl_no="+sheetObjects[0].GetCellValue(selRownum,"pctl_no");
		         		ComOpenPopup(url, 760, 460, "",	"0,0", true);
		         		break;	
		         	}
	                case "btn_close": {
	            		ComClosePopup(); 
	            		break; 
	                }
	                case "btn_more": {
	                	funcMore();
	                	break;
	                }
             }
     	}catch(e) {
     		
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     
     /**
      */
     function funLddCalendarCallback(y, m, d) {
    	 var tmp=new Date();
         var d=new Date(y,m-1,d,tmp.getHours(),tmp.getMinutes(),tmp.getSeconds());
         var sVal=formatDate(d,window.ComCalendar_dateFormat);
         $("#form #fm_ld_dt").val(formatDate(d,window.ComCalendar_dateFormat));
         $("#form #fm_ld_dt").trigger("change");
     }
     
     /**
      * 
      */
     function funcMore() {
    		moreCnt++;
    		if (moreCnt==2) {
    			ComBtnDisable("btn_more");     			
    		}
    		ComOpenWait(true);
    		setTimeout(function() {
    			var f = document.form;
    			f.f_cmd.value = SEARCHLIST02;
    			f.more_cnt.value = moreCnt;
    			var sXml = sheetObjects[0].GetSearchData("ESD_PRD_0080GS.do", PrdFQString(f));
    			createMorePcView(sXml);
    			ComOpenWait(false);
    		}, 100);
     }
     
     /**
      * 
      * @param sXml
      */
     function createMorePcView(sXml) {
    	 var sheetObject = sheetObjects[0];
         var formObj=document.form;
         var arrXml=sXml.split("|$$|");
         fncMoreErrMessage(arrXml);
         var checkRows =  sheetObject.FindCheckedRow("chk");
         var chkRowArray = checkRows.split("|");
         sheet1CheckRow = chkRowArray[0] == '' ? 0 : chkRowArray[0];
         if(ComGetSelectSingleNode(arrXml[0] , "TOTAL") > 0) {
    		sheetObject.LoadSearchData(arrXml[0], { Sync: 1, Append:1 } ); 
    		if(sheet1CheckRow == 0) {
    			sheet1_OnClick(sheetObject, sheetObject.HeaderRows(), 1);
   		 	}
    	}
         if(!ComIsEmpty(ComGetEtcData(arrXml[0],"map_seq"))) {
        	 formObj.map_seq.value=ComGetEtcData(arrXml[0],"map_seq"); 
        	 formObj.sum_bkg_qty.value=ComGetEtcData(arrXml[0],"sum_bkg_qty");
             formObj.sum_ctp_sz.value=ComGetEtcData(arrXml[0],"sum_ctp_sz");
         }
     }
     /**
      * Response Message
      * @param arrXml
      */
     function fncMoreErrMessage(arrXml) {
    	 var result=ComGetEtcData(arrXml[0], "TRANS_RESULT_KEY");
    	 if(result == "F" || result == "S"){
    		 var msgtag = ComResultMessage(arrXml[0])
    		 var orginMsgTag = "";
    		 if (msgtag.length > 0){
    			 orginMsgTag = msgtag.replace(/[<||>]/gi, "");
    			 if(orginMsgTag.indexOf('# Error Message :') > -1){
    				 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Error Message :')).replace("# Error Message :", "");
    			 }
    			 if(ComTrim(msgtag) == '') {
    				 if(orginMsgTag.indexOf('# Info Message :') > -1){
    					 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Info Message :')).replace("# Info Message :", "");
    				 }
    			 }
    			 if(ComTrim(msgtag) == '') {
    				 if(orginMsgTag.indexOf('# Warning Message :') > -1){
    					 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Warning Message :')).replace("# Warning Message :", "");
    				 }
    			 }
    			 if(ComTrim(msgtag) == '') {
    				 ComShowMessage(orginMsgTag);
    			 } else {
    			 	ComShowMessage(msgtag);
    			 }
    		 } else {
    			 if(result == "F") {
    				 ComShowMessage(ComGetMsg('PRD00081'));	
    			 }
    		 }
    		 ComOpenWait(false);
         }    	 
     }
     
     function updatePrdMap() {
    	 var formObj=document.form;
    	 formObj.f_cmd.value=MODIFY ;
		 formObj.sXml.value='' ;
     	 var selRownum='';
		 for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
			 if(sheetObjects[0].GetCellValue(i, "chk") == true){
				 selRownum=i;
			 }
		 }
		 var main_pattern_pctl_no=sheetObjects[0].GetCellValue(selRownum,"pctl_no");
 		 var sXml=sheetObjects[2].GetSearchData("ESD_PRD_0080GS.do?main_pattern_pctl_no="+main_pattern_pctl_no , PrdFQString(formObj) );
		 var arrXml=sXml.split("|$$|"); 
		 if(ComGetEtcData(arrXml[0],"MAP_UPDATE")=="FAIL"){
			 updChk=0 ;
		 }	 
     }
     /*
      * creating pc by modifying ldd
      */
     function newPcCreateByLdd() {
      	ComOpenWait(true);
      	setTimeout( function () {
	 	 	var formObj=document.form;
	 	 	formObj.ld_dt.value=formObj.fm_ld_dt.value.replace(/\-/gi, '');
	 	 	formObj.f_cmd.value=SEARCHLIST01 ;
	 	 	formObj.sXml.value='';
	 		var sXml=sheetObjects[0].GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
			var arrXml=sXml.split("|$$|"); 
		    for(var i=0; i < arrXml.length; i++){  
		    	sheetObjects[i].LoadSearchData(arrXml[i], {Sync:2} );
		    }  
			var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
			var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
			var pc_ldd=ComGetEtcData(arrXml[0],"pc_ldd");
			var ldd=ComGetEtcData(arrXml[0],"ldd");
			var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
			var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");
			 if(arrXml.length ==1) {
				 sheetObjects[0].RemoveAll();
				 sheetObjects[1].RemoveAll();
				 sheetObjects[2].RemoveAll();
				 if( arr_dt==undefined ) arr_dt='' ; 
				 if( transit_dt==undefined ) transit_dt='' ; 
				 if( pc_ldd==undefined ) pc_ldd='' ; 
				 if( ldd==undefined ) ldd='' ; 
				 if( cnst_flg==undefined ) cnst_flg='' ; 			 
				 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 			 
			 } else {
				 formObj.ttl_expn_amt.value=ComGetEtcData(arrXml[0],"ttl_expn_amt");
				 formObj.cml_tztm_day.value=ComGetEtcData(arrXml[0],"cml_tztm_day");
				 formObj.d_pod_cd.value=ComGetEtcData(arrXml[0],"pod_cd");
	    		 $('#d_por_cd').val(ComGetEtcData(arrXml[0],"por_cd"));
	    		 $('#d_del_cd').val(ComGetEtcData(arrXml[0],"del_cd"));
			 }
			formObj.fm_empty_dt.value=mt_pu_dt;
			if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
				ComAddSeparator(formObj.fm_empty_dt);
			}
			
			formObj.arr_dt.value=arr_dt;
			formObj.transit_dt.value=transit_dt;
			formObj.cnst_flg.value=cnst_flg;
			if(!ComIsNullAndUndefind(formObj.fm_ld_dt) ) {
				ComAddSeparator(formObj.fm_ld_dt);
			}
			set_color_constraint_btn(cnst_flg);
			ComOpenWait(false);
      	} , 100);
     }
     
     function set_color_constraint_btn( cnst_flg ) {
		 if(cnst_flg != ''){
			 if(cnst_flg == 'X'){
				 document.getElementById('btng_constraints').style.color='red';
            	 ComBtnDisable("btn_select"); 
        		 ComBtnEnable("btng_constraints"); 
        		 ComBtnEnable("btng_fullroute");      
			 }else {
				 document.getElementById('btng_constraints').style.color='blue';
        		 ComBtnEnable("btn_select"); 
        		 ComBtnEnable("btng_constraints"); 
        		 ComBtnEnable("btng_fullroute");  				 
			 }
			 ComShowMessage(ComGetMsg('PRD90113'));	
		 } else {
			 if(sheetObjects[0].RowCount()>0){
	    		 ComBtnEnable("btn_select"); 
	    		 ComBtnEnable("btng_constraints"); 
	    		 ComBtnEnable("btng_fullroute"); 
				 document.getElementById('btng_constraints').style.color="#737373";
			 } else {
            	 ComBtnDisable("btn_select"); 
            	 ComBtnDisable("btng_constraints"); 
            	 ComBtnDisable("btng_fullroute"); 
			 }
		 }   	 
     }
     /**
      * 
      */
     function searchEqInv() {
  	 	var formObj=document.form;
    	var selRownum='';
		for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
			if(sheetObjects[0].GetCellValue(i, "chk") == true){
				selRownum=i;
			}
		}
  	 	formObj.m_pu_dt.value=formObj.fm_empty_dt.value.replace(/\-/gi, '');
  	 	formObj.pctl_no.value=sheetObjects[0].GetCellValue(selRownum,"pctl_no");
  	 	ComOpenWait(true);
		formObj.f_cmd.value=SEARCH02 ;
		formObj.sXml.value='';
 		var sXml=sheetObjects[1].GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
		sheetObjects[1].LoadSearchData(sXml,{Sync:2} );
		ComOpenWait(false);
     }
     /**
      * 
      * @param mode
      */
     function chk_ob_trsp_mode(mode) {
    	 ComOpenWait(true);
    	 setTimeout( function () {
    	 var formObj=document.form;
		 formObj.f_cmd.value=SEARCHLIST01 ;
		 formObj.sXml.value='' ;
 		 var sXml=sheetObjects[0].GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
		 ComBtnEnable("btn_select");
		 var arrXml=sXml.split("|$$|"); 
         for(var i=0; i < arrXml.length; i++){  
        	 sheetObjects[i].LoadSearchData(arrXml[i],{Sync:2, Wait:1} );
         }  
		 if(arrXml.length == 1) { //creation fail
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
//			 setTimeout( function () {
//				 CompareRadioClickEvent("ob_trsp_mode", beforeObTrspMode);
//			 } , 100);
		 } else {
			beforeObTrspMode = mode.value; 
			if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
				ComAddSeparator(formObj.fm_empty_dt);
			}
			formObj.fm_empty_dt.value=ComGetEtcData(arrXml[0],"mt_pu_dt");
			formObj.arr_dt.value=ComGetEtcData(arrXml[0],"arr_dt");
			formObj.transit_dt.value=ComGetEtcData(arrXml[0],"transit_dt");
			formObj.return_str.value=ComGetEtcData(arrXml[0],"returnStr");
			var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
			formObj.map_seq.value=ComGetEtcData(arrXml[0],"map_seq");
			formObj.cnst_flg.value=cnst_flg;
			set_color_constraint_btn(cnst_flg);
		 }
		 ComOpenWait(false);
    	 } , 100);
     }
     
     
     /**
      * Trans Mode Change Event.
      * @param mode
      */
     function chk_ib_trsp_mode(mode) {
    	 ComOpenWait(true);
    	 setTimeout( function () {
	    	 var formObj=document.form;
			 formObj.f_cmd.value=SEARCHLIST01 ;
			 formObj.sXml.value='' ;
	  		 var sXml=sheetObjects[0].GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
			 ComBtnEnable("btn_select");
			 var arrXml=sXml.split("|$$|"); 
	         for(var i=0; i < arrXml.length; i++){  
	        	 sheetObjects[i].LoadSearchData(arrXml[i], {Sync:2, Wait:1} );
	         }
			 var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
			 var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
			 var return_str=ComGetEtcData(arrXml[0],"returnStr");
			 var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
			 formObj.map_seq.value=ComGetEtcData(arrXml[0],"map_seq");
			 var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");
			 
			 if(arrXml.length ==1) { //creation fail.
				 sheetObjects[1].RemoveAll();
				 sheetObjects[2].RemoveAll();
				 if( arr_dt==undefined ) arr_dt='' ; 
				 if( transit_dt==undefined ) transit_dt='' ; 
				 if( return_str==undefined ) return_str='' ; 
				 if( cnst_flg==undefined ) cnst_flg='' ; 			 
				 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
//				 setTimeout( function () {
//					 CompareRadioClickEvent("ib_trsp_mode", beforeIbTrspMode);
//				 } , 100);
			 } else {
				 beforeIbTrspMode = mode.value;
				 if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
					 ComAddSeparator(formObj.fm_empty_dt); 
				 }
				 formObj.arr_dt.value=arr_dt;
				 formObj.transit_dt.value=transit_dt;
				 formObj.return_str.value=return_str;
				 formObj.cnst_flg.value=cnst_flg;
				 set_color_constraint_btn(cnst_flg);
			 } 	
			 ComOpenWait(false);
    	 } , 100);
     }
     
     function CompareRadioClickEvent(objectNm, CompareValue) {
    	 var radioObjects = document.getElementsByName(objectNm);
		 for(var k = 0;  k < radioObjects.length; k++) {
			 if(radioObjects[k].value == CompareValue) {
				 radioObjects[k].click();
				 break;
			 }
		 }
     }
 
     function GetRadioValue(objectNm, SetVariable) {
    	 var radioObjects = document.getElementsByName(objectNm);
		 for(var k = 0;  k < radioObjects.length; k++) {
			 if(radioObjects[k].checked) {
				 SetVariable = radioObjects[k].value;
				 break;
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
    var beforeIbTrspMode = "";
    var beforeObTrspMode = "";
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
        }
		ComOpenWait(true);
		var f=document.form;
		f.f_cmd.value=SEARCHLIST01 ;
 		var sXml=sheetObjects[0].GetSearchData("ESD_PRD_0080GS.do",PrdFQString(f));
		createPcView(sXml);
		InitEvent();
		GetRadioValue("ib_trsp_mode", beforeIbTrspMode);
		GetRadioValue("ob_trsp_mode", beforeObTrspMode);
        ComOpenWait(false);
	 }
    
    function InitEvent() {
    	 $("#form #fm_ld_dt").change(function() {
    		 var v = $(this).val();
    		 if($.trim(v).length > 0) {
    			 newPcCreateByLdd();
    		 }
    	 });
    }
    
    /**
     * 
     * @param sXml
     */
     function createPcView(sXml) {
         var formObj=document.form;
         var arrXml=sXml.split("|$$|");
         var result=ComGetEtcData(arrXml[0], "TRANS_RESULT_KEY");
    	 if(result == "F" ){
    		 var msgtag = ComResultMessage(arrXml[0])
    		 var orginMsgTag = "";
    		 if (msgtag.length > 0){
    			 orginMsgTag = msgtag.replace(/[<||>]/gi, "");
    			 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Error Message :')).replace("# Error Message :", "");
    			 if(ComTrim(msgtag) == '') {
    				 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Info Message :')).replace("# Info Message :", "");
    			 }
    			 if(ComTrim(msgtag) == '') {
    				 msgtag = orginMsgTag.substr(orginMsgTag.indexOf('# Warning Message :')).replace("# Warning Message :", "");
    			 }
    			 if(ComTrim(msgtag) == '') {
    				ComShowMessage(orginMsgTag);
    			 } else { 
    			 	ComShowMessage(msgtag);
    			 }
    		 } else {
    			 ComShowMessage(ComGetMsg('PRD00081'));	
    		 }
    		 ComOpenWait(false);
         }
         formObj.pre_n1st_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol1_dc_flg");
         formObj.post_n1st_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol1_dc_flg");
         formObj.pre_n1st_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod1_dc_flg");
         formObj.post_n1st_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod1_dc_flg");
         formObj.pre_n2nd_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol2_dc_flg");
         formObj.post_n2nd_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol2_dc_flg");
         formObj.pre_n2nd_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod2_dc_flg");
         formObj.post_n2nd_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod2_dc_flg");
         formObj.pre_n3rd_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol3_dc_flg");
         formObj.post_n3rd_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol3_dc_flg");
         formObj.pre_n3rd_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod3_dc_flg");
         formObj.post_n3rd_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod3_dc_flg");
         formObj.pre_n4th_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol4_dc_flg");
         formObj.post_n4th_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol4_dc_flg");
         formObj.pre_n4th_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod4_dc_flg");
         formObj.post_n4th_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod4_dc_flg");
         for(var i=0; i < arrXml.length; i++){  
             sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 2} );
         }  
		var cnst_flg="";
		 if(arrXml.length ==1) {
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
		 } else{
			 formObj.return_str.value=ComGetEtcData(arrXml[0],"returnStr");
			 formObj.arr_dt.value=ComGetEtcData(arrXml[0],"arr_dt");
			 formObj.transit_dt.value=ComGetEtcData(arrXml[0],"transit_dt");
			 cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
			 formObj.cnst_flg.value=cnst_flg;
			 formObj.fm_ld_dt.value=ComGetEtcData(arrXml[0],"ldd");
			 formObj.arr_dt.value=ComGetEtcData(arrXml[0],"arr_dt");
			 formObj.d_pod_cd.value=ComGetEtcData(arrXml[0],"pod_cd");
			 $('#d_por_cd').val(ComGetEtcData(arrXml[0],"por_cd"));
			 $('#d_del_cd').val(ComGetEtcData(arrXml[0],"del_cd"));
			 formObj.ttl_expn_amt.value=ComGetEtcData(arrXml[0],"ttl_expn_amt");
			 formObj.cml_tztm_day.value=ComGetEtcData(arrXml[0],"cml_tztm_day");
			 formObj.map_seq.value=ComGetEtcData(arrXml[0],"map_seq");
			 formObj.sum_bkg_qty.value=ComGetEtcData(arrXml[0],"sum_bkg_qty");
			 formObj.sum_ctp_sz.value=ComGetEtcData(arrXml[0],"sum_ctp_sz");
			 formObj.fm_empty_dt.value=ComGetEtcData(arrXml[0],"mt_pu_dt");
			 if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
				 ComAddSeparator(formObj.fm_empty_dt);
			 }
			
			 $("#sheet3Title").html(ComGetEtcData(arrXml[0],'port_cct_msg'));
		 }
		 if(!ComIsNullAndUndefind(formObj.fm_ld_dt)) {
			 ComAddSeparator(formObj.fm_ld_dt);
		 }
		 set_color_constraint_btn(cnst_flg);
     }

   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
    	 var formObj=document.form;
         var cnt=0;
         var shtID=sheetObj.id;
         switch(shtID) {
             case "sheet1":      //sheet1 init
                 with(sheetObj){
                 
	              var HeadTitle1="no|CHK|Flag|Priority|Full Cargo Cut Off|Cut Off Yard|Cost(USD)|Transit Time|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|||||||||||||||||||||||||||||||||||osca_vvd_flg|";
	              var HeadTitle2="no|CHK|Flag|Priority|Full Cargo Cut Off|Cut Off Yard|Cost(USD)|Transit Time|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|Lane|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE||||||||||||||||||||||||||||||||||||osca_vvd_flg|";

	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no",                KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Radio",     Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_ind_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ocn_rout_prio_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"cut_off",       		  KeyField:0,   CalcLogic:"",   Format:"" },
	                  
	                  {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cut_off_yd_cd",       		  KeyField:0,   CalcLogic:"",   Format:"" },
	                  
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_expn_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tztm_hrs",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n1st_pol_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n1st_pol_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1 },
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pol_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pol",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n1st_pol_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n1st_pol_dc",       KeyField:0,   CalcLogic:"",   Format:"", 	MultiLineText:1 },
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n1st_pod_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n1st_pod_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pod_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pod",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n1st_pod_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n1st_pod_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1 },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_slan_cd",           KeyField:0,   CalcLogic:"",   Format:"", 	MultiLineText:1 },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_space",             KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1 },	                  
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n2nd_pol_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n2nd_pol_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pol_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pol",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n2nd_pol_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n2nd_pol_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n2nd_pod_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n2nd_pod_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pod_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pod",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n2nd_pod_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n2nd_pod_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_space",             KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n3rd_pol_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n3rd_pol_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pol_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pol",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n3rd_pol_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n3rd_pol_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n3rd_pod_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n3rd_pod_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pod_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pod",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n3rd_pod_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n3rd_pod_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_space",             KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n4th_pol_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n4th_pol_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pol_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pol",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n4th_pol_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n4th_pol_dc",       KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pre_n4th_pod_dc_chk",    KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_n4th_pod_dc",        KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pod_chk",           KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pod",               KeyField:0,   CalcLogic:"",   Format:"",	MultiLineText:1},
	                  {Type:"CheckBox",  Hidden:0, 	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"post_n4th_pod_dc_chk",   KeyField:0,   CalcLogic:"",   Format:"", 	TrueValue:"Y", FalseValue:"N" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"post_n4th_pod_dc",       KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_space",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_loc_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_lnk_no",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ord",                    KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lnk_knt",                KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pol_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pod_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_vvd",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_vvd",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vvd",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_vvd",               KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pol_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pod_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pol_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pod_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pol_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pod_dc_clpt_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pol_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_pod_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pol_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_pod_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pol_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_pod_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pol_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n4th_pod_n",             KeyField:0,   CalcLogic:"",   Format:"" },
	                  {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"osca_vvd_flg",           KeyField:0,   CalcLogic:"",   Format:"" }
	                  ];
	               
	              	InitColumns(cols);
	              	SetEditable(1);

	              	SetColProperty("tztm_hrs", {AcceptKeys:"N", Format:"##.##"} );
	              	SetWaitImageVisible(0);
                    SetColHidden(0,1);
                    SetSheetHeight(215);
              }
                 break;
             case "sheet2":      //sheet2 init
                 with(sheetObj){
	              var HeadTitle1=" CHK|Empty Pick Up Yard|Empty Pick Up Yard|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory";
	              var HeadTitle2=" CHK|||D2|D4|D5|R2|R4|R5";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ 
			                  {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mt_chk",  KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"nod_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r4",      KeyField:0,   CalcLogic:"",   Format:"" },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"" } 
	                  ];
	               
	              InitColumns(cols);
	              SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	              SetEditable(1);
	              SetWaitImageVisible(0);
	              SetSheetHeight(145,1);
             }
                 break;
             case "sheet3":      //sheet3 init
           	    with(sheetObj){
	               var HeadTitle1=" |CHK |Full Return Yard|Cargo Cut Off Time|Cargo Cut Off Time|Cargo Cut Off Time";
	               var HeadTitle2=" |CHK |Full Return Yard|General|RF|DG";
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	               var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ 
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"yd_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0 },
	                      {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"frt_chk",   Wrap:1 },
	                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"gen",       KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",  	 ColMerge:1,   SaveName:"rf",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"dg",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  } 
	               ];
	               InitColumns(cols);
	               SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	               SetEditable(1);
                   SetSheetHeight(145,1);
             }
           	    break;
             case "sheet4":
            	 with(sheetObj){
            	 
            	 var HeadTitle1=" |";
            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	 InitHeaders(headers, info);
            	 var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1 } ];
            	 InitColumns(cols);
            	 sheetObj.SetVisible(false);
             }
            	 break;
         }
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * Tab change event
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	beforetab=nItem;
     }
     /*
      * retrieving data with pc no which is made by ocn when ocn route is modified
      */
     function sheet1_OnChange(sheetObj, row, col, value){
    	 var formObj=document.form;
    	 if (sheetObj.ColSaveName(col) != "chk") {
	    	 var colArr="pre_n1st_pol_dc_chk post_n1st_pol_dc_chk pre_n1st_pod_dc_chk post_n1st_pod_dc_chk pre_n2nd_pol_dc_chk post_n2nd_pol_dc_chk pre_n2nd_pod_dc_chk post_n2nd_pod_dc_chk pre_n3rd_pol_dc_chk post_n3rd_pol_dc_chk pre_n3rd_pod_dc_chk post_n3rd_pod_dc_chk pre_n4th_pol_dc_chk post_n4th_pol_dc_chk pre_n4th_pod_dc_chk post_n4th_pod_dc_chk";
	    	 if (colArr.indexOf(sheetObj.ColSaveName(col),0) >= 0 ){
				 formObj.n1st_pol_dc_seq.value="";
				 formObj.n1st_pod_dc_seq.value="";
				 formObj.n2nd_pol_dc_seq.value="";
				 formObj.n2nd_pod_dc_seq.value="";
				 formObj.n3rd_pol_dc_seq.value="";
				 formObj.n3rd_pod_dc_seq.value="";
				 formObj.n4th_pol_dc_seq.value="";
				 formObj.n4th_pod_dc_seq.value="";
				 formObj.n1st_pol_clpt_ind_seq.value="";
				 formObj.n1st_pod_clpt_ind_seq.value="";
				 formObj.n2nd_pol_clpt_ind_seq.value="";
				 formObj.n2nd_pod_clpt_ind_seq.value="";
				 formObj.n3rd_pol_clpt_ind_seq.value="";
				 formObj.n3rd_pod_clpt_ind_seq.value="";
				 formObj.n4th_pol_clpt_ind_seq.value="";
				 formObj.n4th_pod_clpt_ind_seq.value="";	
				 formObj.vvd1.value="";
				 formObj.vvd2.value="";
				 formObj.vvd3.value="";
				 formObj.vvd4.value="";
				 formObj.pol1.value="";
				 formObj.pod1.value="";
				 formObj.pol2.value="";
				 formObj.pod2.value="";
				 formObj.pol3.value="";
				 formObj.pod3.value="";
				 formObj.pol4.value="";
				 formObj.pod4.value="";			 
				 formObj.n1st_pol_dc_seq.value=sheetObj.GetCellValue(row,"n1st_pol_dc_clpt_seq");
				 formObj.n1st_pod_dc_seq.value=sheetObj.GetCellValue(row,"n1st_pod_dc_clpt_seq");
				 formObj.n2nd_pol_dc_seq.value=sheetObj.GetCellValue(row,"n2nd_pol_dc_clpt_seq");
				 formObj.n2nd_pod_dc_seq.value=sheetObj.GetCellValue(row,"n2nd_pod_dc_clpt_seq");
				 formObj.n3rd_pol_dc_seq.value=sheetObj.GetCellValue(row,"n3rd_pol_dc_clpt_seq");
				 formObj.n3rd_pod_dc_seq.value=sheetObj.GetCellValue(row,"n3rd_pod_dc_clpt_seq");
				 formObj.n4th_pol_dc_seq.value=sheetObj.GetCellValue(row,"n4th_pol_dc_clpt_seq");
				 formObj.n4th_pod_dc_seq.value=sheetObj.GetCellValue(row,"n4th_pod_dc_clpt_seq");
				 formObj.vvd1.value=sheetObj.GetCellValue(row,"n1st_vvd");
				 formObj.vvd2.value=sheetObj.GetCellValue(row,"n2nd_vvd");
				 formObj.vvd3.value=sheetObj.GetCellValue(row,"n3rd_vvd");
				 formObj.vvd4.value=sheetObj.GetCellValue(row,"n4th_vvd");
				 if(sheetObj.ColSaveName(col) =="pre_n1st_pol_dc_chk"){
					 formObj.pol1.value=sheetObj.GetCellValue(row,"pre_n1st_pol_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n1st_pol_dc_chk"){
					 formObj.pol1.value=sheetObj.GetCellValue(row,"post_n1st_pol_dc").substring(0,5);
				 } else {
					 formObj.pol1.value=sheetObj.GetCellValue(row,"n1st_pol_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n1st_pod_dc_chk"){
					 formObj.pod1.value=sheetObj.GetCellValue(row,"pre_n1st_pod_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n1st_pod_dc_chk"){
					 formObj.pod1.value=sheetObj.GetCellValue(row,"post_n1st_pod_dc").substring(0,5);
				 } else {
					 formObj.pod1.value=sheetObj.GetCellValue(row,"n1st_pod_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n2nd_pol_dc_chk"){
					 formObj.pol2.value=sheetObj.GetCellValue(row,"pre_n2nd_pol_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n2nd_pol_dc_chk"){
					 formObj.pol2.value=sheetObj.GetCellValue(row,"post_n2nd_pol_dc").substring(0,5);
				 } else {
					 formObj.pol2.value=sheetObj.GetCellValue(row,"n2nd_pol_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n2nd_pod_dc_chk"){
					 formObj.pod2.value=sheetObj.GetCellValue(row,"pre_n2nd_pod_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n2nd_pod_dc_chk"){
					 formObj.pod2.value=sheetObj.GetCellValue(row,"post_n2nd_pod_dc").substring(0,5);
				 } else {
					 formObj.pod2.value=sheetObj.GetCellValue(row,"n2nd_pod_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n3rd_pol_dc_chk"){
					 formObj.pol3.value=sheetObj.GetCellValue(row,"pre_n3rd_pol_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n3rd_pol_dc_chk"){
					 formObj.pol3.value=sheetObj.GetCellValue(row,"post_n3rd_pol_dc").substring(0,5);
				 } else {
					 formObj.pol3.value=sheetObj.GetCellValue(row,"n3rd_pol_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n3rd_pod_dc_chk"){
					 formObj.pod3.value=sheetObj.GetCellValue(row,"pre_n3rd_pod_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n3rd_pod_dc_chk"){
					 formObj.pod3.value=sheetObj.GetCellValue(row,"post_n3rd_pod_dc").substring(0,5);
				 } else {
					 formObj.pod3.value=sheetObj.GetCellValue(row,"n3rd_pod_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n4th_pol_dc_chk"){
					 formObj.pol4.value=sheetObj.GetCellValue(row,"pre_n4th_pol_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n4th_pol_dc_chk"){
					 formObj.pol4.value=sheetObj.GetCellValue(row,"post_n4th_pol_dc").substring(0,5);
				 } else {
					 formObj.pol4.value=sheetObj.GetCellValue(row,"n4th_pol_n").substring(0,5);
				 }
				 if(sheetObj.ColSaveName(col) =="pre_n4th_pod_dc_chk"){
					 formObj.pod4.value=sheetObj.GetCellValue(row,"pre_n4th_pod_dc").substring(0,5);
				 } else if(sheetObj.ColSaveName(col) =="post_n4th_pod_dc_chk"){
					 formObj.pod4.value=sheetObj.GetCellValue(row,"post_n4th_pod_dc").substring(0,5);
				 } else {
					 formObj.pod4.value=sheetObj.GetCellValue(row,"n4th_pod_n").substring(0,5);
				 }
	    		 dcSearch(sheetObj);
	    	 } 
    	 }
      }
     /*
      * creating pc
      */
     function sheet2_OnChange(sheetObj, row, col, value){
    	 var formObj=document.form;
    	 if (sheetObj.ColSaveName(col) == "mt_chk" || sheetObj.ColSaveName(col) == "yd_cd" ) {
    		 if( sheetObj.GetCellValue(row,"yd_cd")=='' || sheetObj.GetCellValue(row,"yd_cd").length < 7 ){
    			 sheetObj.SetCellValue(row, col, '', 0);
    			 return;
    		 }
    		 if(sheetObj.ColSaveName(col) == "yd_cd") {
    			 formObj.f_cmd.value=SEARCH03 ;
        		 formObj.chk_yd.value=sheetObj.GetCellValue(row,"yd_cd") ;
        		 var sXml=sheetObjects[3].GetSearchData("ESD_PRD_0080GS.do", PrdFQString(formObj));
 		   		 var chkYdUseFlg=ComGetEtcData(sXml, "yd_use_flg");		
 		   		 if(chkYdUseFlg == "0") {
 		   			sheetObj.SetCellValue(row, col, '', 0);
 		   			 return;
 		   		 }
    		 }
    		 ComOpenWait(true);
    		 setTimeout( function () {
    		 formObj.f_cmd.value=SEARCHLIST01 ;
    		 formObj.m_pu.value=sheetObj.GetCellValue(row,"yd_cd") ;
    		 formObj.sXml.value='' ;
			 // saving rout_seq column value which is checked on the sheet of ocean route
			 var routeSeq;
 			 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
 				 if(sheetObjects[0].GetCellValue(i, "chk") == 1){
 					 routeSeq=sheetObjects[0].GetCellValue(i, "rout_seq");
					 break;
				 }
			 }
     		 var sXml=sheetObj.GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
    		 var arrXml=sXml.split("|$$|"); 
             for(var i=0; i < arrXml.length; i++){  
            	 sheetObjects[i].LoadSearchData(arrXml[i], {Sync:2});
             }  
			 // checking row with value of variable routeSeq when ocean route sheet is reloaded
			 var routeSeqFlag=true;
 			 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
 				 if(sheetObjects[0].GetCellValue(i, "rout_seq") == routeSeq){
					 sheetObjects[0].SetCellValue(i, "chk",1,0);
					 routeSeqFlag=false;
				 }
			 }
			 if(routeSeqFlag){
				 sheetObjects[0].SetCellValue(parseInt(sheetObj.HeaderRows()),"chk",1,0);
			 }
    		 var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
    		 var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
    		 var return_str=ComGetEtcData(arrXml[0],"returnStr");
    		 var cop_map_seq=ComGetEtcData(arrXml[0],"map_seq");
    		 var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
    		 var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 var por_cd=ComGetEtcData(arrXml[0],"por_cd");
    		 var del_cd=ComGetEtcData(arrXml[0],"del_cd");
    		 var pod_cd=ComGetEtcData(arrXml[0],"pod_cd");
    		 if(arrXml.length == 1) { //creation fail
    			 sheetObjects[1].RemoveAll();
    			 sheetObjects[2].RemoveAll();
    			 if( arr_dt==undefined ) arr_dt='' ; 
    			 if( transit_dt==undefined ) transit_dt='' ; 
    			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
    			 if( return_str==undefined ) return_str='' ; 
    			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
    			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
    			 if( por_cd==undefined ) por_cd='' ; 
    			 if( del_cd==undefined ) del_cd='' ; 
    			 if( pod_cd==undefined ) pod_cd='' ; 
    		 }     		 
   			 formObj.fm_empty_dt.value=ComGetEtcData(arrXml[0],"mt_pu_dt");
   			 if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
   				ComAddSeparator(formObj.fm_empty_dt);
   			 }
    		 formObj.arr_dt.value=arr_dt;
    		 formObj.transit_dt.value=transit_dt;
    		 formObj.return_str.value=return_str;
    		 formObj.map_seq.value=cop_map_seq;
    		 formObj.cnst_flg.value=cnst_flg;
    		 $('#d_por_cd').val(por_cd);
    		 $('#d_pod_cd').val(pod_cd);
    		 $('#d_del_cd').val(del_cd);
    		 set_color_constraint_btn(cnst_flg);
    		 ComOpenWait(false);
    		 } , 100);
    	 }
     }
     
     /**
      * Null 및 Undefind 체크 
      * @param obj
      * @returns {Boolean}
      */
     function ComIsNullAndUndefind(obj) {
    	 return ComIsNull(obj) || obj.value == 'undefined' || obj.value == 'null';
     }
     /*
      * creating pc
      */
     function sheet3_OnChange(sheetObj, row, col, value){
    	 var formObj=document.form;
    	 if (sheetObj.ColSaveName(col) == "frt_chk" || sheetObj.ColSaveName(col) == "yd_cd" ) {
    		 if( sheetObj.GetCellValue(row,"yd_cd")=='' || sheetObj.GetCellValue(row,"yd_cd").length < 7 || sheetObj.GetCellValue(row,"frt_chk") =='0' ){
    			 return;
    		 }
    		 if(sheetObj.ColSaveName(col) == "yd_cd") {
    			 formObj.f_cmd.value=SEARCH03 ;
        		 formObj.chk_yd.value=sheetObj.GetCellValue(row,"yd_cd") ;
        		 var sXml=sheetObjects[3].GetSearchData("ESD_PRD_0080GS.do", PrdFQString(formObj));
 		   		 var chkYdUseFlg=ComGetEtcData(sXml, "yd_use_flg");		
 		   		 if(chkYdUseFlg == "0") {
 		   			sheetObj.SetCellValue(row, col, '', 0);
 		   			return;
 		   		 }
    		 }    		 
    		 ComOpenWait(true);
    		 setTimeout( function () {
    		 formObj.f_cmd.value=SEARCHLIST01 ;
    		 formObj.f_rt.value=sheetObj.GetCellValue(row,"yd_cd") ;
			 formObj.sXml.value='' ;
			 // saving rout_seq column value which is checked on the sheet of ocean route
			 var routeSeq;
 			 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
			 if(sheetObjects[0].GetCellValue(i, "chk") == 1){
				 routeSeq=sheetObjects[0].GetCellValue(i, "rout_seq");
					 break;
				 }
			 }
 			 var sXml=sheetObj.GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
			 var arrXml=sXml.split("|$$|");
			 for(var i=0; i < arrXml.length; i++){
					 sheetObjects[i].LoadSearchData(arrXml[i],{Sync:2} );
			 }
			 // checking row with value of variable routeSeq when ocean route sheet is reloaded
			 var routeSeqFlag=true;
 			 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
 				 if(sheetObjects[0].GetCellValue(i, "rout_seq") == routeSeq){
					 sheetObjects[0].SetCellValue(i, "chk",1,0);
					 routeSeqFlag=false;
				 }
			 }
			 if(routeSeqFlag){
				 sheetObjects[0].SetCellValue(parseInt(sheetObj.HeaderRows()),"chk",1,0);
			 }
			 var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
			 var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
			 var return_str=ComGetEtcData(arrXml[0],"returnStr");
			 var cop_map_seq=ComGetEtcData(arrXml[0],"map_seq");
			 var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
			 var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");	
    		 var por_cd=ComGetEtcData(arrXml[0],"por_cd");
    		 var del_cd=ComGetEtcData(arrXml[0],"del_cd");
    		 var pod_cd=ComGetEtcData(arrXml[0],"pod_cd");
    		 
    		 if(arrXml.length ==1) { //creation fail
    			 sheetObjects[1].RemoveAll();
    			 sheetObjects[2].RemoveAll();
    			 if( arr_dt==undefined ) arr_dt='' ; 
    			 if( transit_dt==undefined ) transit_dt='' ; 
    			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
    			 if( return_str==undefined ) return_str='' ; 
    			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
    			 if( mt_pu_dt==undefined ) mt_pu_dt='' ;     
     			 if( por_cd==undefined ) por_cd='' ; 
    			 if( del_cd==undefined ) del_cd='' ; 
    			 if( pod_cd==undefined ) pod_cd='' ; 
    		 }     
    		 formObj.fm_empty_dt.value=ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
    			 ComAddSeparator(formObj.fm_empty_dt); 
    		 }
    		 
			 formObj.arr_dt.value=arr_dt;
			 formObj.transit_dt.value=transit_dt;
			 formObj.return_str.value=return_str;
			 formObj.map_seq.value=cop_map_seq;
			 formObj.cnst_flg.value=cnst_flg;
			 $('#d_por_cd').val(por_cd);
    		 $('#d_pod_cd').val(pod_cd);
    		 $('#d_del_cd').val(del_cd);			 
			 set_color_constraint_btn(cnst_flg);   
			 ComOpenWait(false);
    		 } , 100);
    	 }
     }
     function sheet1_OnSearchEnd(sheetObj, code , ErrMsg) {
    	 var formObj=document.form;
    	 if(formObj.f_cmd.value == SEARCHLIST01) {
    		 moreCnt = 0;
    		 ComBtnEnable("btn_more");
    	 }
    	 sheetObj.RenderSheet(0);
    	 sheetObj.SetColHidden("pre_n1st_pol_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n1st_pol_dc",0); 
    	 sheetObj.SetColHidden("post_n1st_pol_dc_chk",0);
    	 sheetObj.SetColHidden("post_n1st_pol_dc",0);
    	 sheetObj.SetColHidden("n1st_pol_chk",0);
		 sheetObj.SetColHidden("pre_n1st_pod_dc_chk",0);
		 sheetObj.SetColHidden("pre_n1st_pod_dc",0);
    	 sheetObj.SetColHidden("post_n1st_pod_dc_chk",0);
    	 sheetObj.SetColHidden("post_n1st_pod_dc",0);
    	 sheetObj.SetColHidden("n1st_pod_chk",0);
    	 sheetObj.SetColHidden("pre_n2nd_pol_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n2nd_pol_dc",0);
    	 sheetObj.SetColHidden("post_n2nd_pol_dc_chk",0);
    	 sheetObj.SetColHidden("post_n2nd_pol_dc",0);
    	 sheetObj.SetColHidden("n2nd_pol_chk",0);
    	 sheetObj.SetColHidden("pre_n3rd_pol_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n3rd_pol_dc",0);
    	 sheetObj.SetColHidden("post_n3rd_pol_dc_chk",0);
    	 sheetObj.SetColHidden("post_n3rd_pol_dc",0);
    	 sheetObj.SetColHidden("n3rd_pol_chk",0);
    	 sheetObj.SetColHidden("pre_n3rd_pod_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n3rd_pod_dc",0);
    	 sheetObj.SetColHidden("post_n3rd_pod_dc_chk",0);
    	 sheetObj.SetColHidden("post_n3rd_pod_dc",0);
    	 sheetObj.SetColHidden("n3rd_pod_chk",0);
    	 sheetObj.SetColHidden("pre_n4th_pol_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n4th_pol_dc",0);
    	 sheetObj.SetColHidden("post_n4th_pol_dc_chk",0);
    	 sheetObj.SetColHidden("post_n4th_pol_dc",0);
    	 sheetObj.SetColHidden("n4th_pol_chk",0);
    	 sheetObj.SetColHidden("pre_n4th_pod_dc_chk",0);
    	 sheetObj.SetColHidden("pre_n4th_pod_dc",0);
    	 sheetObj.SetColHidden("post_n4th_pod_dc_chk",0);
    	 sheetObj.SetColHidden("post_n4th_pod_dc",0);
    	 sheetObj.SetColHidden("n4th_pod_chk",0);
    	 if(sheetObj.RowCount() > 0){
    		 if(sheet1CheckRow > sheetObj.HeaderRows()) {
    			 sheetObj.SetCellValue(sheet1CheckRow,"chk", 1, 0); 
    		 } else {
    			 sheetObj.SetCellValue(parseInt(sheetObj.HeaderRows()),"chk", 1, 0); 
    		 }
    		
    		 if(formObj.pre_n1st_pol_dc.value!="Y"){
    			 sheetObj.SetColHidden("pre_n1st_pol_dc_chk",1);
    			 sheetObj.SetColHidden("pre_n1st_pol_dc",1);
    		 }
    		 if(formObj.post_n1st_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n1st_pol_dc_chk",1);
            	 sheetObj.SetColHidden("post_n1st_pol_dc",1);
             }
    		 if(formObj.pre_n1st_pol_dc.value!="Y" && formObj.post_n1st_pol_dc.value!="Y"){
    			 sheetObj.SetColHidden("n1st_pol_chk",1);
    		 }
    		 if(formObj.pre_n1st_pod_dc.value!="Y"){
    			 sheetObj.SetColHidden("pre_n1st_pod_dc_chk",1);
    			 sheetObj.SetColHidden("pre_n1st_pod_dc",1);
    		 }
             if(formObj.post_n1st_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n1st_pod_dc_chk",1);
            	 sheetObj.SetColHidden("post_n1st_pod_dc",1);
             }
             if(formObj.pre_n1st_pod_dc.value!="Y" && formObj.post_n1st_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("n1st_pod_chk",1);
             }
             if(formObj.pre_n2nd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n2nd_pol_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n2nd_pol_dc",1);
             }
             if(formObj.post_n2nd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n2nd_pol_dc_chk",1);
            	 sheetObj.SetColHidden("post_n2nd_pol_dc",1);
             }
             if(formObj.pre_n2nd_pol_dc.value!="Y" && formObj.post_n2nd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("n2nd_pol_chk",1);
             }
             if(formObj.pre_n2nd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n2nd_pod_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n2nd_pod_dc",1);
             }
             if(formObj.post_n2nd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n2nd_pod_dc_chk",1);
            	 sheetObj.SetColHidden("post_n2nd_pod_dc",1);
             }
             if(formObj.pre_n2nd_pod_dc.value!="Y" && formObj.post_n2nd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("n2nd_pod_chk",1);
             }
             if(formObj.pre_n3rd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n3rd_pol_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n3rd_pol_dc",1);
             }
             if(formObj.post_n3rd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n3rd_pol_dc_chk",1);
            	 sheetObj.SetColHidden("post_n3rd_pol_dc",1);
             }
             if(formObj.pre_n3rd_pol_dc.value!="Y" && formObj.post_n3rd_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("n3rd_pol_chk",1);
             }
             if(formObj.pre_n3rd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n3rd_pod_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n3rd_pod_dc",1);
             }
             if(formObj.post_n3rd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n3rd_pod_dc_chk",1);
            	 sheetObj.SetColHidden("post_n3rd_pod_dc",1);
             }
             if(formObj.pre_n3rd_pod_dc.value!="Y" && formObj.post_n3rd_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("n3rd_pod_chk",1);
             }
             if(formObj.pre_n4th_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n4th_pol_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n4th_pol_dc",1);
             }
             if(formObj.post_n4th_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n4th_pol_dc_chk",1);
            	 sheetObj.SetColHidden("post_n4th_pol_dc",1);
             }
             if(formObj.pre_n4th_pol_dc.value!="Y" && formObj.post_n4th_pol_dc.value!="Y"){
            	 sheetObj.SetColHidden("n4th_pol_chk",1);
             }
             if(formObj.pre_n4th_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("pre_n4th_pod_dc_chk",1);
            	 sheetObj.SetColHidden("pre_n4th_pod_dc",1);
             }
             if(formObj.post_n4th_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("post_n4th_pod_dc_chk",1);
            	 sheetObj.SetColHidden("post_n4th_pod_dc",1);
             }
             if(formObj.pre_n4th_pod_dc.value!="Y" && formObj.post_n4th_pod_dc.value!="Y"){
            	 sheetObj.SetColHidden("n4th_pod_chk",1);
             }
             for(var row=2; row<=sheetObj.RowCount()+1; row++){
            	 sheetObj.SetCellEditable(row,"pctl_no",0);
            	 sheetObj.SetCellEditable(row,"upd_ind_cd",0);
            	 sheetObj.SetCellEditable(row,"ocn_rout_prio_cd",0);
            	 sheetObj.SetCellEditable(row,"cut_off", 0);
            	 sheetObj.SetCellEditable(row,"ttl_expn_amt",0);
            	 sheetObj.SetCellEditable(row,"tztm_hrs",0);
            	 sheetObj.SetCellEditable(row,"n1st_vsl_slan_cd",0);
            	 sheetObj.SetCellEditable(row,"n1st_pol",0);
            	 sheetObj.SetCellEditable(row,"n1st_pod",0);
            	 sheetObj.SetCellEditable(row,"n1st_slan_cd",0);
            	 sheetObj.SetCellEditable(row,"n1st_space",0);
            	 sheetObj.SetCellEditable(row,"n2nd_vsl_slan_cd",0);
            	 sheetObj.SetCellEditable(row,"n2nd_pol",0);
            	 sheetObj.SetCellEditable(row,"n2nd_pod",0);
            	 sheetObj.SetCellEditable(row,"n2nd_space",0);
            	 sheetObj.SetCellEditable(row,"n3rd_vsl_slan_cd",0);
            	 sheetObj.SetCellEditable(row,"n3rd_pol",0);
            	 sheetObj.SetCellEditable(row,"n3rd_pod",0);
            	 sheetObj.SetCellEditable(row,"n3rd_space",0);
            	 sheetObj.SetCellEditable(row,"n4th_vsl_slan_cd",0);
            	 sheetObj.SetCellEditable(row,"n4th_pol",0);
            	 sheetObj.SetCellEditable(row,"n4th_pod",0);
            	 sheetObj.SetCellEditable(row,"n4th_space",0);
            	 sheetObj.SetCellEditable(row,"post_n1st_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n1st_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n2nd_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n2nd_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n3rd_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n3rd_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n4th_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"post_n4th_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n1st_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n1st_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n2nd_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n2nd_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n3rd_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n3rd_pod_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n4th_pol_dc",0);
            	 sheetObj.SetCellEditable(row,"pre_n4th_pod_dc",0);
            	 sheetObj.SetCellValue(row,"n1st_pol_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n1st_pod_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n2nd_pol_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n2nd_pod_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n3rd_pol_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n3rd_pod_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n4th_pol_chk","Y",0);
            	 sheetObj.SetCellValue(row,"n4th_pod_chk","Y",0);
            	 sheetObj.SetCellEditable(row,"n1st_pol_chk",0);
            	 sheetObj.SetCellEditable(row,"n1st_pod_chk",0);
            	 sheetObj.SetCellEditable(row,"n2nd_pol_chk",0);
            	 sheetObj.SetCellEditable(row,"n2nd_pod_chk",0);
            	 sheetObj.SetCellEditable(row,"n3rd_pol_chk",0);
            	 sheetObj.SetCellEditable(row,"n3rd_pod_chk",0);
            	 sheetObj.SetCellEditable(row,"n4th_pol_chk",0);
            	 sheetObj.SetCellEditable(row,"n4th_pod_chk",0);
            	 //process according to Existence of Double Calling Port
            	 if(sheetObj.GetCellValue(row,"n1st_pol_dc_clpt_seq")==""){
                	 sheetObj.SetCellEditable(row,"pre_n1st_pol_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n1st_pol_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n1st_pod_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n1st_pod_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n1st_pod_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n2nd_pol_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n2nd_pol_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n2nd_pol_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n2nd_pod_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n2nd_pod_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n2nd_pod_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n3rd_pol_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n3rd_pol_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n3rd_pol_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n3rd_pod_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n3rd_pod_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n3rd_pod_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n4th_pol_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n4th_pol_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n4th_pol_dc_chk",0);
                 }
            	 if(sheetObj.GetCellValue(row,"n4th_pod_dc_clpt_seq")==""){
            		 sheetObj.SetCellEditable(row,"pre_n4th_pod_dc_chk",0);
                	 sheetObj.SetCellEditable(row,"post_n4th_pod_dc_chk",0);
                 }
             }
             sheetObj.RenderSheet(1);
    		 ComBtnEnable("btn_select"); 
    		 ComBtnEnable("btng_constraints"); 
    		 ComBtnEnable("btng_fullroute"); 
    	 } else {
    		 ComBtnDisable("btn_select"); 
    		 ComBtnDisable("btng_constraints"); 
    		 ComBtnDisable("btng_fullroute"); 
    	 }
    	 for(i=parseInt(sheetObj.HeaderRows()) ; i<= parseInt(sheetObj.HeaderRows())+sheetObj.RowCount(); i++){
    		 var fCol=0;
    		 var tCol=0;
    		 if(sheetObj.GetCellValue(i,'vvd_lnk_no')=='1'){
				fCol=sheetObj.SaveNameCol("n1st_vsl_slan_cd");
				tCol=sheetObj.SaveNameCol("n1st_space");
				sheetObj.SetRangeBackColor(i, fCol, i, tCol,"#FFFF00");
    		 } else if(sheetObj.GetCellValue(i,'vvd_lnk_no')=='2'){
				fCol=sheetObj.SaveNameCol("n2nd_vsl_slan_cd");
				tCol=sheetObj.SaveNameCol("n2nd_space");
				sheetObj.SetRangeBackColor(i, fCol, i, tCol,"#FFFF00");
    		 } else if(sheetObj.GetCellValue(i,'vvd_lnk_no')=='3'){
				fCol=sheetObj.SaveNameCol("n3rd_vsl_slan_cd");
				tCol=sheetObj.SaveNameCol("n3rd_space");
				sheetObj.SetRangeBackColor(i, fCol, i, tCol,"#FFFF00");
    		 } else if(sheetObj.GetCellValue(i,'vvd_lnk_no')=='4'){
				fCol=sheetObj.SaveNameCol("n4th_vsl_slan_cd");
				tCol=sheetObj.SaveNameCol("n4th_space");
				sheetObj.SetRangeBackColor(i, fCol, i, tCol,"#FFFF00");
			}
		}
     }
     function sheet2_OnSearchEnd(sheetObj, code , ErrMsg) {
    	 if(sheetObj.RowCount()> 0){
    		 sheetObj.SetCellValue(parseInt(sheetObj.HeaderRows()),"mt_chk","1",0);
             for(var row=2; row<=sheetObj.RowCount(); row++){
            	 sheetObj.SetCellEditable(row,"yd_cd",0);
            	 sheetObj.SetCellEditable(row,"nod_nm",0);
            	 sheetObj.SetCellEditable(row,"d2",0);
            	 sheetObj.SetCellEditable(row,"d4",0);
            	 sheetObj.SetCellEditable(row,"d5",0);
            	 sheetObj.SetCellEditable(row,"r2",0);
            	 sheetObj.SetCellEditable(row,"r4",0);
            	 sheetObj.SetCellEditable(row,"r5",0);
             }
    	 }
     }
     function sheet3_OnSearchEnd(sheetObj, code , ErrMsg) {
    	 if(sheetObj.RowCount()> 0){
    		 sheetObj.SetCellValue(parseInt(sheetObj.HeaderRows()),"frt_chk","1",0);
             for(var row=2; row<=sheetObj.RowCount(); row++){
            	 sheetObj.SetCellEditable(row,"yd_cd1",0);
            	 sheetObj.SetCellEditable(row,"yd_cd",0);
            	 sheetObj.SetCellEditable(row,"gen",0);
            	 sheetObj.SetCellEditable(row,"rf",0);
            	 sheetObj.SetCellEditable(row,"dg",0);
             }
    	 }
     }
     /**
     * handling by selecting Double Calling Port 
     */
    function dcSearch(sheetObj){
    	 var formObj=document.form;
    	 ComOpenWait(true);
		 formObj.f_cmd.value=SEARCHLIST01 ;
		 formObj.sXml.value='' ;
		 // saving rout_seq column value which is checked on the sheet of ocean route
		 var routeSeq;
 		 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
 			 if(sheetObjects[0].GetCellValue(i, "chk") == 1){
 				 routeSeq=sheetObjects[0].GetCellValue(i, "rout_seq");
				 break;
			 }
		 }
 		 var sXml=sheetObj.GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
		 var arrXml=sXml.split("|$$|"); 
         formObj.pre_n1st_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol1_dc_flg");
         formObj.post_n1st_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol1_dc_flg");
         formObj.pre_n1st_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod1_dc_flg");
         formObj.post_n1st_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod1_dc_flg");
         formObj.pre_n2nd_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol2_dc_flg");
         formObj.post_n2nd_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol2_dc_flg");
         formObj.pre_n2nd_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod2_dc_flg");
         formObj.post_n2nd_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod2_dc_flg");
         formObj.pre_n3rd_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol3_dc_flg");
         formObj.post_n3rd_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol3_dc_flg");
         formObj.pre_n3rd_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod3_dc_flg");
         formObj.post_n3rd_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod3_dc_flg");
         formObj.pre_n4th_pol_dc.value=ComGetEtcData(arrXml[0],"pre_pol4_dc_flg");
         formObj.post_n4th_pol_dc.value=ComGetEtcData(arrXml[0],"post_pol4_dc_flg");
         formObj.pre_n4th_pod_dc.value=ComGetEtcData(arrXml[0],"pre_pod4_dc_flg");
         formObj.post_n4th_pod_dc.value=ComGetEtcData(arrXml[0],"post_pod4_dc_flg");		 
		 for(var i=0; i < arrXml.length; i++){  
                 sheetObjects[i].LoadSearchData(arrXml[i], {Sync:2} );
         }  
		 // checking row with value of variable routeSeq when ocean route sheet is reloaded
		 var routeSeqFlag=true;
		 for (i=0; i < sheetObjects[0].LastRow()+1; i++) {
			 if(sheetObjects[0].GetCellValue(i, "rout_seq") == routeSeq){
				 sheetObjects[0].SetCellValue(i, "chk",1,0);
				 routeSeqFlag=false;
			 }
		 }
		 if(routeSeqFlag){
			 sheetObjects[0].SetCellValue(parseInt(sheetObj.HeaderRows()),"chk",1,0);
		 }
		 var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
		 var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
		 var return_str=ComGetEtcData(arrXml[0],"returnStr");
		 var cop_map_seq=ComGetEtcData(arrXml[0],"map_seq");
		 var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
		 var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");
		 if(arrXml.length ==1) { //creation fail
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 if( arr_dt==undefined ) arr_dt='' ; 
			 if( transit_dt==undefined ) transit_dt='' ; 
			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
			 if( return_str==undefined ) return_str='' ; 
			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
		 }     		 
		 formObj.fm_empty_dt.value=ComGetEtcData(arrXml[0],"mt_pu_dt");
		 if(!ComIsNullAndUndefind(formObj.fm_empty_dt)) {
			 ComAddSeparator(formObj.fm_empty_dt);
		 }
		 formObj.arr_dt.value=arr_dt;
		 formObj.transit_dt.value=transit_dt;
		 formObj.return_str.value=return_str;
		 formObj.map_seq.value=cop_map_seq;
		 formObj.cnst_flg.value=cnst_flg;
		 set_color_constraint_btn(cnst_flg);
		 ComOpenWait(false);
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
	 // checking Validation
     function chkVal(selRownum) {
    	 var ord=sheetObjects[0].GetCellValue(selRownum,"ord");
    	 var lnk_knt=sheetObjects[0].GetCellValue(selRownum,"lnk_knt");
    	 var ttl_expn_amt=sheetObjects[0].GetCellValue(selRownum,"ttl_expn_amt");
    	 var ordType=0;
    	 for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
    		 if(parseFloat(sheetObjects[0].GetCellValue(i, "ord")) > parseFloat(ordType)){
    			 ordType=sheetObjects[0].GetCellValue(i, "ord");
			 }
		 }
     	 for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow()+1; i++) {
    		 if(ordType > 1){
    			 if(i!=selRownum){
    				 // when there are Guide and Standard Flag
    				 if(parseFloat(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "ord"))==1){
    					 if(parseFloat(ord)>1){
	    					 return false;
    					 }
    				 // when there are not Guide and Standard Flag(checking only Cost)
    				 } else if(parseFloat(sheetObjects[0].GetCellValue(i, "ttl_expn_amt")) < parseFloat(ttl_expn_amt)){
						 return false;
    				 }
    			 }
    		 // when there are only Guide and Standard Flag
    		 } else {
    			 if(i!=selRownum){
    				 // not checking validation in case of Direct Call
    				 if(parseFloat(lnk_knt) > 1){
    					 if(parseFloat(sheetObjects[0].GetCellValue(i, "ord")) < parseFloat(ord)){
    						 return false;
    					 } else {
    						 if(parseFloat(sheetObjects[0].GetCellValue(i, "lnk_knt")) < parseFloat(lnk_knt)){
    							 return false;
    						 } else {
    							 if(parseFloat(sheetObjects[0].GetCellValue(i, "ttl_expn_amt")) < parseFloat(ttl_expn_amt)){
    								 return false;
    							 }
    						 }
    					 }
    				 }
    			 }
    		 }
    	 }
    	 return true;
     }
     function sheet1_OnClick (sheetObj, row,col) {
    	 var formObj=document.form;
    	 if (sheetObj.ColSaveName(col) == "chk") {
    		 formObj.pctl_no.value=sheetObj.GetCellValue(row,"pctl_no");
    		 ComOpenWait(true);
    		 setTimeout( function () {
    		 formObj.f_cmd.value=SEARCH01 ;
    		 formObj.sXml.value='' ;
    		 var sXml=sheetObj.GetSearchData("ESD_PRD_0080GS.do",PrdFQString(formObj));
    		 var arrXml=sXml.split("|$$|"); 
    		 if(arrXml.length=2){
    			 sheetObjects[1].LoadSearchData(arrXml[0],{Sync:2} );
    			 sheetObjects[2].LoadSearchData(arrXml[1],{Sync:2} );
    		 }
    		 var arr_dt=ComGetEtcData(arrXml[0],"arr_dt");
    		 var transit_dt=ComGetEtcData(arrXml[0],"transit_dt");
    		 var return_str=ComGetEtcData(arrXml[0],"returnStr");
    		 var pod_cd=ComGetEtcData(arrXml[0],"pod_cd");
    		 var pc_ldd=ComGetEtcData(arrXml[0],"pc_ldd");
    		 var ldd=ComGetEtcData(arrXml[0],"ldd");
    		 var cnst_flg=ComGetEtcData(arrXml[0],"cnst_flg");
    		 var ttl_expn_amt=ComGetEtcData(arrXml[0],"ttl_expn_amt");
    		 var mt_pu_dt=ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 var cml_tztm_day=ComGetEtcData(arrXml[0],"cml_tztm_day");
    		 formObj.fm_empty_dt.value=mt_pu_dt;
    		 formObj.return_str.value=return_str;
    		 formObj.arr_dt.value=arr_dt;
    		 formObj.transit_dt.value=transit_dt;
    		 formObj.d_pod_cd.value=pod_cd;
    		 $('#d_por_cd').val(ComGetEtcData(arrXml[0],"por_cd"));
    		 $('#d_del_cd').val(ComGetEtcData(arrXml[0],"del_cd"));
    		 formObj.ttl_expn_amt.value=ttl_expn_amt;
    		 formObj.cml_tztm_day.value=cml_tztm_day;
    		 formObj.cnst_flg.value=cnst_flg;
			 document.getElementById("sheet3Title").innerHTML=ComGetEtcData(arrXml[0],'port_cct_msg');
			 set_color_constraint_btn(cnst_flg);
			 ComOpenWait(false);
    		 } , 100);
    	 } 
    	 if(sheetObj.GetCellValue(row,"n1st_pol_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n1st_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n1st_pol_dc_chk"){
        		 sheetObj.SetCellValue(row,"n1st_pol_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 } 
         }
    	 if(sheetObj.GetCellValue(row,"n1st_pod_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n1st_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n1st_pod_dc_chk"){
        		 sheetObj.SetCellValue(row,"n1st_pod_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n2nd_pol_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n2nd_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n2nd_pol_dc_chk"){
        		 sheetObj.SetCellValue(row,"n2nd_pol_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n2nd_pod_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n2nd_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n2nd_pod_dc_chk"){
        		 sheetObj.SetCellValue(row,"n2nd_pod_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n3rd_pol_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n3rd_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n3rd_pol_dc_chk"){
        		 sheetObj.SetCellValue(row,"n3rd_pol_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n3rd_pod_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n3rd_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n3rd_pod_dc_chk"){
        		 sheetObj.SetCellValue(row,"n3rd_pod_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n4th_pol_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n4th_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n4th_pol_dc_chk"){
        		 sheetObj.SetCellValue(row,"n4th_pol_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
    	 if(sheetObj.GetCellValue(row,"n4th_pod_dc_clpt_seq")!=""){
        	 if (sheetObj.ColSaveName(col) == "pre_n4th_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n4th_pod_dc_chk"){
        		 sheetObj.SetCellValue(row,"n4th_pod_chk","N",0);
        		 sheetObj.SetCellValue(row,"chk","Y",0);
        	 }
         }
     }	 
  	// after calling ESD_PRD_0083
  	function callBackEsdPrd0083(valChk){
  		var formObject=document.form;
  		if(valChk){
  			formObject.valChk.value="Y";
  		}
  	}