/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0205.js
*@FileTitle  : Phase In/Out Information (pop-up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0205 : business script for VOP_VSK_0205
     */
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
    		var cal=new ComCalendar();
            switch(srcName) {
				case "btn_OK":
					if(!validateForm(formObj, "btn_OK")){
						return false;
					}
					if(formObj.parentUI.value=="0010"){
			        	with(formObj){
			        		if(phaseType.value=="O"){
			        			var rsn_cd = formObj.phase_rsn_code.options[formObj.phase_rsn_code.selectedIndex].text;
			        			//var tmp = formObj.phase_rsn_code.value;
			        			ComPopUpReturnValue(rsn_cd );
			        			//ComPopUpReturnValue(phase_rsn_code.options[phase_rsn_code.selectedIndex].text);
			        			//window.returnValue=phase_rsn_code.options[phase_rsn_code.selectedIndex].text;
			        		}else if(phaseType.value=="I"){
			        			var obj=new Object();
			        			obj.vvd=formObj.src_vsl_cd.value + formObj.src_skd_voy_no.value + formObj.src_skd_dir_cd.value;
			        			// SKD Start date(yyyyMMdd) + time of P/F(HHmm)
			        			////:top:////obj.date=formObj.src_phase_date.value.replace(/\/|\-/g, "") + formObj.src_pf_date.value.replace(/\/|\-|\ |\:/g,"").substring(8);
			        			obj.rsn_cd=formObj.phase_rsn_code.options[phase_rsn_code.selectedIndex].text;
			        			if(formObj.src_skd_dir_cd.selectedIndex=="0"){
			        				obj.phasein_col=formObj.src_port_cd.selectedIndex+1;
			        			}else{
			        				obj.phasein_col=formObj.firstPortCds.value.split("|").length + formObj.src_port_cd.selectedIndex+1;
			        			}
			        			//window.returnValue=obj;
			        			ComPopUpReturnValue(obj);
			        		}
			        	}
					}else if(formObj.parentUI.value == "0015"){
						//if(formObj.phaseType.value == "O"){
							var obj=new Object();
							var rsn_cd = formObj.phase_rsn_code.options[formObj.phase_rsn_code.selectedIndex].text;
							obj.phs_io_rsn_cd=rsn_cd;//formObj.phase_rsn_code.options[formObj.phase_rsn_code.selectedIndex].text;
							obj.phs_io_rmk=formObj.phase_rsn_name.value;
							//window.returnValue=obj;
							ComPopUpReturnValue(obj);
						//}
					}
					comPopupOK();
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				case "btns_search1":
					if(!formObj.src_vsl_cd.disabled){
						if(formObj.src_vsl_cd.value==''){
							openVslCdHelp();
						}else if(formObj.src_skd_voy_no.value==''){
							openVoyNoHelp();
						}
					}
					break;
				////:top:////case "btns_cal1":
				////:top:////	cal.select(formObj.src_phase_date, 'yyyy-MM-dd');
				////:top:////	break;
				case "btns_cal11":
					//cal.select(formObj.src_phase_date, 'yyyy-MM-dd');
					cal.select(formObj.src_pf_date, 'yyyy-MM-dd');
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
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        formObj.phase_rsn_name.value=formObj.phase_rsn_code.value;
        ////:top:////formObj.src_phase_date.value=ComGetMaskedValue(formObj.src_phase_date.value, "ymd");
        initControl();
        if(formObj.parentUI.value=="0010" || formObj.parentUI.value=="0015"){
        	with(formObj){
        		if(phaseType.value=="O"){
        			src_vsl_cd.readOnly=true;
        			src_skd_voy_no.readOnly=true;
        			src_skd_dir_cd.readOnly=true;
       	        	clpt_ind_seq_1.value=src_clpt_ind_seq.value;
       	        	// in case pick clpt_ind_seq and phase in, fix clpt_ind_seq. And transmit formObj.clptIndSeq.value to server
       	        	clpt_ind_seq_1.disabled=true;
	        		//src_phase_date.className = "input2";
       	        	////:top:////src_phase_date.readOnly=true;
       	        	////:top:////src_phase_date.disabled=true;
	        		btns_cal1.name="no_btns_cal1";
	        		phase_rsn_code.focus();
        		}else if(phaseType.value=="I"){
        			clpt_ind_seq_1.value=src_clpt_ind_seq.value;
       	        	// in case pick clpt_ind_seq and phase in, fix clpt_ind_seq. And transmit formObj.clptIndSeq.value to server
       	        	clpt_ind_seq_1.disabled=true;
	        		//src_phase_date.className = "input2";
//	        		src_phase_date.readOnly = true;
//	        		src_phase_date.disabled = true;
       	        	var srcdate=src_pf_date.value;
	        		var dDate=new Date(getDateFromFormat(srcdate, 'MM/ddyyyyHHmm'));
	        		srcdate=srcdate.replace(/\/|\ /g, ""); // Remove date separator, space
	        		src_pf_date.value=srcdate.substr(4, 4) + "-" + srcdate.substr(0, 2) + "-" + srcdate.substr(2, 2); // + " " + srcdate.substr(8, 2) + ":" + srcdate.substr(10, 2);
	        		src_pf_date.value=ComGetDateAdd(src_pf_date.value, "D", 7)
       	        	src_pf_date.readOnly=true;
	        		////:top:////src_phase_date.value=srcdate.substr(4, 4) + "-" + srcdate.substr(0, 2) + "-" + srcdate.substr(2, 2);
	        		////:top:////src_phase_date.value=ComGetDateAdd(src_phase_date.value, "D", 7)
	        		phase_rsn_code.focus();
        		}
        	}
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":      // sheet1 init
                with(sheetObj){
		                tabIndex=-1;
		              var HeadTitle1="|";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetVisible(false);
                    }
                break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
           case SEARCH01:
        	   if(validateForm(formObj, SEARCH01)){
					formObj.f_cmd.value=COMMAND16;
					var sParam=FormQueryString(formObj) + "&vsl_cd=" + formObj.src_vsl_cd.value;
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0205GS.do", sParam);
					var vslEngNm=ComGetEtcData(sXml, "vsl_eng_nm");
					if(vslEngNm){
						return true;
					}else{
						sheetObj.LoadSearchData(sXml,{Sync:1} );
			    		formObj.src_vsl_cd.value="";
			    		return false;
			    	}
				}
				break;
           case SEARCH02:
      			if(formObj.src_vsl_cd.value!='' &&
      					formObj.src_skd_voy_no.value!='' &&
      					formObj.src_skd_dir_cd.value!=''){
      				formObj.f_cmd.value=SEARCH02;
      				var sParam=FormQueryString(formObj) + "&vsl_cd=" + formObj.src_vsl_cd.value + "&skd_voy_no=" + formObj.src_skd_voy_no.value + "&skd_dir_cd=" + formObj.src_skd_dir_cd.value;
       				var rXml=sheetObj.GetSearchData("VOP_VSK_0249GS.do" , sParam);
      				var vvd=ComGetEtcData(rXml, "vvd");
      				if(vvd==null){
      					ComShowCodeMessage('VSK00028', formObj.src_vsl_cd.value + formObj.src_skd_voy_no.value + formObj.src_skd_dir_cd.value );
      					formObj.src_vsl_cd.value='';
          				formObj.src_skd_voy_no.value='';
          				formObj.src_skd_dir_cd.value='';
          				formObj.src_vsl_cd.focus();
      				}
      				break;
      			}
      			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(formObj,sAction){
    	switch(sAction){
	    	case "btn_OK":
	    		if(!formObj.src_vsl_cd.value || ComChkLen(formObj.src_vsl_cd.value, 4)!=2){
	    			ComShowCodeMessage('VSK00027', 'Vessel Code');
	    			formObj.src_vsl_cd.value="";
	    			formObj.src_vsl_cd.focus();
	    			return false;
	    		}
	    		if(!formObj.src_skd_voy_no.value || ComChkLen(formObj.src_skd_voy_no.value, 4)!=2){
	    			ComShowCodeMessage('VSK00027', 'Voyage No');
	    			formObj.src_skd_voy_no.value="";
	    			formObj.src_skd_voy_no.focus();
	    			return false;
	    		}
	    		if(!formObj.src_vsl_cd.value || !formObj.src_skd_voy_no.value || !formObj.src_skd_dir_cd.value){
	    			ComShowCodeMessage('VSK00027', 'VVD');
	    			return false;
	    		}
	    		break;
	    	case SEARCH01:
	    		if(!formObj.src_vsl_cd.value || ComChkLen(formObj.src_vsl_cd.value, 4)!=2){
	    			ComShowCodeMessage('VSK00027', 'Vessel Code');
	    			formObj.src_vsl_cd.value="";
	    			return false;
	    		}
	    		// cannot use vessel code which use in parent screen(VOP_VSK_0010)
	    		var vesselList=dialogArguments.getVesselList();
	    		if(vesselList[formObj.src_vsl_cd.value]){
	    			ComShowCodeMessage('VSK00085');
	    			formObj.src_vsl_cd.value="";
	    			return false;
	    		}
	    		break;
    	}
        return true;
    }
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm('change', 'obj_change', formObj);
//    	axon_event.addListenerForm('focus', 'obj_focus', formObj);
    	axon_event.addListenerForm('blur', 'obj_blur', formObj);
//    	axon_event.addListenerForm('keypress', 'eng_keypress' , formObj);
    	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj);
    	//axon_event.addListener('change', 'obj_change' , 'src_phase_date');
    	//axon_event.addListener('change', 'obj_change' , 'dest_phase_date');
	}
//    function obj_focus() {
//    	// remove separator
//    	switch(event.srcElement.name){
//    		case "src_phase_date":
////    		case "dst_phase_date":
//    			ComClearSeparator(event.srcElement);
//    			break;
//    	}
//    	if(event.srcElement.options){
//    		event.srcElement.focus();
//    	}else{
//    		event.srcElement.select();
//    	}
//    }
    
    
    ////:top:////function obj_blur() {
    	//Validation and Masking
    	////:top:////switch(event.srcElement.name){
    		////:top:////case "src_phase_date":
//			case "dst_phase_date":
    		////:top:////	ComChkObjValid(event.srcElement);
    		////:top:////	break;
    	////:top:////}
    ////:top:////}
    
    function obj_change(){
		var formObj=document.form;
		var obj=event.srcElement;
		switch(event.srcElement.name){
			case "src_vsl_cd":
				if(doActionIBSheet(sheetObj, formObj, SEARCH01)){
					formObj.src_skd_voy_no.focus();
            	}else{
            		formObj.src_vsl_cd.focus();
            		return false;
            	}
            	break;
			case "phase_rsn_code":
				formObj.phase_rsn_name.value=formObj.phase_rsn_code.value;
				break;
			////:top:////case "src_phase_date":
//			case "dst_phase_date":
			////:top:////	if(!ComIsDate(obj.value, "ymd")){
			////:top:////		ComShowCodeMessage('VSK00003');
			////:top:////		obj.value='';
			////:top:////		event.returnValue=false;
			////:top:////	}else{
			////:top:////		formObj.oldday.value=obj.value;
			////:top:////	}
			////:top:////	break;
		}
	}
    /**
     * Handling English of onkeypress <br>
     **/
//    function eng_keypress() {
//    	var name=event.srcElement.name;
//    	switch(name){
//    		case "src_vsl_cd":
//    			ComKeyOnlyAlphabet('uppernum');
//    			break;
//    		case "src_skd_dir_cd":
//    			ComKeyOnlyAlphabet('upper');
//    			break;
//    		case "src_skd_voy_no":
//    		case "src_phase_date":
//    			ComKeyOnlyNumber(event.srcElement); 
//    			break;
//    		default:
//    	}
//    }
    /**
     * Open Vessel Code Help
     */
    function openVslCdHelp(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	//var sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
    	var sUrl="/opuscntr/VOP_VSK_0219.do";
		var rVal=ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
		if(rVal){
			formObj.src_vsl_cd.value=rVal;
		}
    }
    /**
     * Open Voyage No Help
     */
    function openVoyNoHelp(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd=" + formObj.src_vsl_cd.value;
		ComOpenPopupWithTarget(sUrl, 340, 420, "skd_voy_no:src_skd_voy_no|skd_dir_cd:src_skd_dir_cd", "0,0", true);
    }
    function changePortList(){
    	var formObj=document.form;
    	var vpsPortCd;
    	// Remove before Port List
    	for(i=0, m=formObj.src_port_cd.options.length; i<m; i++){
    		formObj.src_port_cd.options.remove(0);
    	}
    	if(formObj.src_skd_dir_cd.selectedIndex=="0"){
    		// 1st Direction Port List
    		vpsPortCd=formObj.firstPortCds.value.split("|");
    	}else{
    		// 2nd Direction Port List
    		vpsPortCd=formObj.secondPortCds.value.split("|");
    	}
    	for(i=0; i<vpsPortCd.length; i++){
			formObj.src_port_cd.options[formObj.src_port_cd.options.length]=new Option(vpsPortCd[i], vpsPortCd[i]);
		}
    }
