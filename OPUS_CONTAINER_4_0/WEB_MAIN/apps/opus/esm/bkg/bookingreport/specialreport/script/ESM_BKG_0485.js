/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0485.js
*@FileTitle  : Special Cargo Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/* developer job	*/

	//common global variables

//	var rdObjects=new Array();
	var rdCnt=0;
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	//Event handler processing by button click event
	document.onclick=processButtonClick;
	//Event handler processing by button click event */
	function processButtonClick() {
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				if (!validateForm(formObject)) return;
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH)
				break;
			case "rdo_in_out":  /*inbound,outbound*/
				var bkg_cust_tp_cd=ComGetObjValue(window.event.srcElement);
				formObject.elements["rdo_in_out"].value=bkg_cust_tp_cd;
				switch (bkg_cust_tp_cd) {
					case "IN":  /*inbound*/
						formObject.elements["vvd_pol"].className="input";
						formObject.elements["vvd_pol"].removeAttribute("required");
						formObject.elements["vvd_pod"].className="input1";
						formObject.elements["vvd_pod"].setAttribute("required","");
						break;
					case "OUT":  /*outbound*/
						formObject.elements["vvd_pol"].className="input1";
						formObject.elements["vvd_pol"].setAttribute("required","");
						formObject.elements["vvd_pod"].className="input";
						formObject.elements["vvd_pod"].removeAttribute("required");
						break;
				}
				break;
			} // end switch
		} catch (e) {
			ComShowMessage(e);
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
		
	/**
	 * initializing sheet 
	 * implementing onLoad event handler in body tag 
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		// 2014.08.26 initRdConfig 에서 오류 발생으로 주석 처리
		//initRdConfig(rdObjects[0]);
		
		for (var i=0;i<sheetObjects.length;i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
	
    /**
     * loading HTML Control event<br>
     */
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
	    axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
	}
	
	function ufRetrieveByEnterKey() {
	    if (13!=event.keyCode) return;
	    document.getElementById("btn_retrieve").fireEvent("onclick");
	}
	

    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
	        case "sheet1":
				cnt=0;
			    with(sheetObj){				        
				     //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				     var HeadTitle1="polCd|podCd|vesselName|nationality|vslRgstCntNm|lloydNo|officialNo|callSign|voyageNo|kindOfShip|polNm|podNm|delNm";
				     var headCount=ComCountHeadTitle(HeadTitle1);
	
				     SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
				     var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				     var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				     InitHeaders(headers, info);
	
				     var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pol_cd" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pod_cd" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vessel_name" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"nationality" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vsl_rgst_cnt_nm" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"lloyd_no" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"official_no" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"call_sign" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"voyage_no" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"kind_of_ship" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pol_name" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pod_name" },
				            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"del_name" }];				      
				     
				     InitColumns(cols);	
				     SetEditable(1);				      
				     SetSheetHeight(100);
			    }
	            break;
		}
	}
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
	function doActionIBSheet(sheetObj,formObject,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	    	case IBSEARCH :
	    		var form2=document.form2;
				form2.f_cmd     .value=SEARCH;
				form2.vsl_cd    .value=formObject.vvd_cd.value.substring(0,4);
				form2.skd_voy_no.value=formObject.vvd_cd.value.substring(4,8);
				form2.skd_dir_cd.value=formObject.vvd_cd.value.substring(8,9);
				form2.pol_cd    .value=formObject.vvd_pol.value;
				form2.pod_cd    .value=formObject.vvd_pod.value;
				form2.pol_yd_cd .value=formObject.pol_yd_cd.value;
				form2.pod_yd_cd .value=formObject.pod_yd_cd.value;
				form2.io_bnd_cd .value=formObject.elements["rdo_in_out"].value;
				ComOpenWait(true); 				
				var sXml=sheetObj.GetSearchData("ESM_BKG_0485GS.do", FormQueryString(form2));//*****
				ComOpenWait(false);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				rdOpen(sheetObj,formObject);
				break;
	    }
	}
	
	
	/**
	 * handling process for input validation
	 */
	function validateForm(formObj) {
    	var rdoInOut = ComGetObjValue(formObj.rdo_in_out);
    	var vvd = formObj.vvd_cd;
    	var pod = formObj.vvd_pod;
    	var pol = formObj.vvd_pol;
    	var vvdCd = ComGetObjValue(vvd);
    	var vvdPod = ComGetObjValue(pod);
    	var vvdPol = ComGetObjValue(pol);
		if(vvdCd == ""){
			ComShowCodeMessage("BKG00104","VVD");
			ComSetFocus(vvd);
			return false;
		}else if(vvdCd.length != 9){
			ComShowCodeMessage("BKG00710");
			ComSetFocus(vvd);
			return false;
		}
    	switch (rdoInOut) {
			case "IN":
				if(vvdPod == ""){
					ComShowCodeMessage("BKG00104","POD");
					ComSetFocus(pod);
					return false;
				}else if(vvdPod.length != 5){
					ComShowCodeMessage("BKG00712");
					ComSetFocus(pod);
					return false;
				}
				break;
			case "OUT":
				if(vvdPol == ""){
					ComShowCodeMessage("BKG00104","POL");
					ComSetFocus(pol);
					return false;
				}else if(vvdPol.length != 5){
					ComShowCodeMessage("BKG00711");
					ComSetFocus(pol);
					return false;
				}
				break;
    	}
//	    with(formObj){
	    	
//    		if (ComIsNull(formObj.p_vvd)) {
//					ComShowCodeMessage('BKG00227');
//					formObj.p_vvd.focus();
//					return false;
//  			}
//			if (formObj.p_vvd.value.length != 9) {
//					ComShowCodeMessage('BKG00538');
//					formObj.p_vvd.focus();
//					return false;
//  			}
//	    	for (var i=0; i<formObject.elements.length; i++) {
//	    		if ("text"==formObject.elements[i].type) {
//		    		if (null!=formObject.elements[i].getAttribute("required") && ComIsNull(formObject.elements[i])) {
//		    			alert(formObject.elements[i].value);
//		    			returnValidate("NULL", formObject.elements[i]);
//		    			return false;
//		    		}
//		    		if (!ComIsNull(formObject.elements[i].value)) {
//			    		if (null!=formObject.elements[i].getAttribute("minlength") && 1==ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("minlength"))) {
//			    			returnValidate("MIN", formObject.elements[i]);
//			    			return false;
//			    		}
//			    		if (null!=formObject.elements[i].getAttribute("maxlength") && 0==ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("maxlength"))) {
//			    			returnValidate("MAX", formObject.elements[i]);
//			    			return false;
//			    		}
//		    		}
//	    		}
//	    	}
//	    	if (!ComChkValid(formObject,false)) return false;
//	    }
	    return true;
	}
	
	
//	function returnValidate(mode, obj) {
//		switch (mode) {
//			case "NULL":
//				var msg1=msg2="";
//				alert(formObject.elements["vvd_cd"].value);
//				switch(ComGetEvent("name")) {
//					case "vvd_cd":
//						msg1="\"VVD & POL / POD\"", "\"VVD\"";
//						msg2="\"VVD\"";
//						break;
//					case "vvd_pol":
//						msg1="\"VVD & POL / POD\"", "\"VVD\"";
//						msg2="\"POL\"";
//						break;
//					case "vvd_pod":
//						msg1="\"VVD & POL / POD\"", "\"VVD\"";
//						msg2="\"POD\"";
//						break;
//				}
//				alert(msg1);
//				alert(msg2);
//				if (""!=msg1 && ""!=msg2) {
//					ComShowCodeMessage("COM12130", msg1, msg2);  //Please enter {?msg2} of {?msg1}.
//				} else {
//					ComShowCodeMessage("BKG08020");  //Invalid data (NULL)
//				}
//				break;
//			case "MAX":
//				switch(ComGetEvent("name")) {
//					case "vvd_cd":
//						ComShowCodeMessage("BKG00710");  //Length of VVD is INCORRECT!
//						break;
//					case "vvd_pol":
//						ComShowCodeMessage("BKG00711");  //Length of POL is INCORRECT!
//						break;
//					case "vvd_pod":
//						ComShowCodeMessage("BKG00712");  //Length of POD is INCORRECT!
//						break;
//					default:
//						ComShowCodeMessage("BKG00381");  //Incorrect Data Length
//				}
//				break;
//			case "MIN":
//				switch(ComGetEvent("name")) {
//					case "vvd_cd":
//						ComShowCodeMessage("BKG00710");  //Length of VVD is INCORRECT!
//						break;
//					case "vvd_pol":
//						ComShowCodeMessage("BKG00711");  //Length of POL is INCORRECT!
//						break;
//					case "vvd_pod":
//						ComShowCodeMessage("BKG00712");  //Length of POD is INCORRECT!
//						break;
//					default:
//						ComShowCodeMessage("BKG00381");  //Incorrect Data Length
//				}
//				break;
//		}
//		ComSetFocus(obj);
//	}
	
	//setting rd 
//	function initRdConfig(rdObject){
//		var Rdviewer=rdObject;
//		Rdviewer.AutoAdjust=true;
//		Rdviewer.HideToolBar();
//		Rdviewer.HideStatusBar();
//		Rdviewer.ViewShowMode(0); 
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.SetPageLineColor(128,128,128);
//	}
	
	function sheetNullReturn(obj){
		if(obj == "-1"){
			return "";
		} else {
			return obj;
		}
		
	}
	
	//open rd 
	function rdOpen(viewer, formObject) {
		var Rdviewer=viewer;
		var strPath,strTitle;
		var inOut=ComGetObjValue(formObject.elements["rdo_in_out"]);
		var localTs=ComGetObjValue(formObject.elements["rdo_local_ts"]);
	    var where=" where[]";
	    if ("IN"==inOut) {
			if ("LOCAL"==localTs) {
				where=" where[AND BKG.POD_CD=SP.VVD_POD]";
			} else if ("TS"==localTs) {
				where=" where[AND BKG.POD_CD <> SP.VVD_POD]";
			}
		} else if ("OUT"==inOut) {
			if ("LOCAL"==localTs) {
				where=" where[AND BKG.POL_CD=SP.VVD_POL]";
			} else if ("TS"==localTs) {
				where=" where[AND BKG.POL_CD <> SP.VVD_POL]";
			}
		}
		var vslCd=" vslCd["   +formObject.elements["vvd_cd"   ].value.substring(0,4)+ "]";
		var skdVoyNo=" skdVoyNo["+formObject.elements["vvd_cd"   ].value.substring(4,8)+ "]";
		var skdDirCd=" skdDirCd["+formObject.elements["vvd_cd"   ].value.substring(8,9)+ "]";
		var vvdPol=" vvdPol["  +formObject.elements["vvd_pol"  ].value+"%]";
		var vvdPod=" vvdPod["  +formObject.elements["vvd_pod"  ].value+"%]";
		var polYdCd=" polYdCd[" +formObject.elements["pol_yd_cd"].value+"%]";
		var podYdCd=" podYdCd[" +formObject.elements["pod_yd_cd"].value+"%]";
		var porCd=" porCd["   +formObject.elements["por_cd"   ].value+"%]";
		var polCd=" polCd["   +formObject.elements["pol_cd"   ].value+"%]";
		var podCd=" podCd["   +formObject.elements["pod_cd"   ].value+"%]";
		var delCd=" delCd["   +formObject.elements["del_cd"   ].value+"%]";
		var usrNm=" usrNm["+ComGetObjValue(formObject.elements["usr_nm"])+"]";
		var rpParam="";
		if (formObject.dg_flg_type1.checked && formObject.dg_flg_type2.checked){
			rpParam=" /rp [1][1]";
		}else if(!formObject.dg_flg_type1.checked && formObject.dg_flg_type2.checked){
			rpParam=" /rp [0][1]";
		}else if(formObject.dg_flg_type1.checked && !formObject.dg_flg_type2.checked){
			rpParam=" /rp [1][0]";
		}else{
			rpParam=" /rp [0][0]";
		}
		
		var txtVesselName=" txtVesselName[" +sheetNullReturn(sheetObjects[0].GetCellValue(1,"vessel_name")) +"]";
		var txtNationality=" txtNationality["+sheetNullReturn(sheetObjects[0].GetCellValue(1,"nationality")) +"]";
		var txtVslRgstCntNm=" txtVslRgstCntNm["+sheetNullReturn(sheetObjects[0].GetCellValue(1,"vsl_rgst_cnt_nm")) +"]";
		var txtLloydNo=" txtLloydNo["+sheetNullReturn(sheetObjects[0].GetCellValue(1,"lloyd_no")) +"]";
		var txtOfficialNo=" txtOfficialNo[" +sheetNullReturn(sheetObjects[0].GetCellValue(1,"official_no")) +"]";
		var txtCallSign=" txtCallSign["   +sheetNullReturn(sheetObjects[0].GetCellValue(1,"call_sign"))   +"]";
		var txtVoyageNo=" txtVoyageNo["   +sheetNullReturn(sheetObjects[0].GetCellValue(1,"voyage_no"))   +"]";
		var txtKindOfShip=" txtKindOfShip[" +sheetNullReturn(sheetObjects[0].GetCellValue(1,"kind_of_ship"))+"]";
		var txtPolName=" txtPolName["    +sheetNullReturn(sheetObjects[0].GetCellValue(1,"pol_name"))    +"]";
		var txtPodName=" txtPodName["    +sheetNullReturn(sheetObjects[0].GetCellValue(1,"pod_name"))    +"]";
		var txtDelName=" txtDelName["    +sheetNullReturn(sheetObjects[0].GetCellValue(1,"del_name"))    +"]";
		
		switch (ComGetObjValue(formObject.elements["rdo_manifest_type"])) {
			case "DG":  //Danger
				strTitle="Danger Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0891.mrd";
				break;
			case "AW":  //Awkward
				strTitle="Awkward Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0864.mrd";
				break;
			case "BB":  //Break Bulk
				strTitle="Break Bulk Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0865.mrd";
				break;
			case "RF":  //Reefer
				strTitle="Reefer Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0863.mrd";
				break;
			case "SS":  //Special Stowage
				strTitle="Special Stowage Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_5016.mrd";
				break;
			case "PC":  //Precaution
				strTitle="Precaution Cargo Manifest";
				strPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0935.mrd";
			    if ("IN"==inOut) {
					if ("LOCAL"==localTs) {
						where=" where[AND BV.POD_CD LIKE '"+formObject.elements["vvd_pod"].value+"%']";
					} else if ("TS"==localTs) {
						where=" where[AND BV.POD_CD <> '"+formObject.elements["vvd_pod"].value+"']";
					}
				} else if ("OUT"==inOut) {
					if ("LOCAL"==localTs) {
						where=" where[AND BV.POL_CD LIKE '"+formObject.elements["vvd_pol"].value+"%']";
					} else if ("TS"==localTs) {
						where=" where[AND BV.POL_CD <> '"+formObject.elements["vvd_pol"].value+"']";
					}
				}
				break;
		}
		var rvParam=" /rv"+where+vslCd+skdVoyNo+skdDirCd+vvdPol+vvdPod+polYdCd+podYdCd+porCd+polCd+podCd+delCd+usrNm;
		rvParam += txtVesselName;
		rvParam += txtNationality;
		rvParam += txtVslRgstCntNm;
		rvParam += txtLloydNo;
		rvParam += txtOfficialNo;
		rvParam += txtCallSign;
		rvParam += txtVoyageNo;
		rvParam += txtKindOfShip;
		rvParam += txtPolName;
		rvParam += txtPodName;
		rvParam += txtDelName;
		rvParam += rpParam;
		
		formObject.elements["com_mrdPath"     ].value=strPath;
		formObject.elements["com_mrdArguments"].value=rvParam;
		formObject.elements["com_mrdTitle"].value=strTitle;
		formObject.elements["com_mrdBodyTitle"].value="<span style='color:red'>"+strTitle+"</span>";
		formObject.elements["com_mrdSaveDialogFileName"].value=formObject.elements["vvd_cd"].value;
		ComOpenRDPopup("width=1024, height=660");
	}
	
	function fnMfType(obj){
		if(obj.value=="DG"){
			document.getElementById("dg_flg_type1").disabled = false;
			document.getElementById("dg_flg_type2").disabled = false;
		}else{
			document.getElementById("dg_flg_type1").disabled = true;
			document.getElementById("dg_flg_type2").disabled = true;
		}
	}
	
