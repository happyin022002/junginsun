/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1021.js
*@FileTitle  : Own Container Booking Forecast Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================
*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
/**
 * @extends
 * @class VOP_OPF_0021 : VOP_OPF_0021 business script for
 */
	function VOP_OPF_0021() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	/* Developer performance	*/
	// common global variables	
	var sheetObjects=new Array();
	var sheetCnt=0;
	var cgoOprList=new Array();
	var comboObjects=new Array();
	var comboCnt=0;
	var tcnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	var queryStr="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {		
		var sheetObj=sheetObjects[0]; // sheet1		
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Print":
					doActionIBSheet(sheetObj, document.form, IBSEARCH);	
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
			} 
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
		}
	}
	//handling process related Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {	
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				var podComboObj=comboObjects[0];
				var oprComboObj=comboObjects[1];
				var mlbComboObj=comboObjects[2];
				var selP="";
				for (var i=0; i < formObj.selPrint.length; i++) {
					if (formObj.selPrint[i].checked) {
						var selP=formObj.selPrint[i].value;
					}
				}
	            var rdParam="/rp " + "["    + ComTrim(podComboObj.GetSelectCode()) + "] [" + ComTrim(oprComboObj.GetSelectCode()) + "] [" + ComTrim(mlbComboObj.GetSelectCode()) + "] ";
	            rdParam=rdParam + "/rv " +
				                    "vsl_cd["      + ComGetObjValue(formObj.vsl_cd)      + "] skd_voy_no[" + ComGetObjValue(formObj.skd_voy_no) + "] skd_dir_cd[" + ComGetObjValue(formObj.skd_dir_cd) + "] " +
				                    "vsl_nm["      + ComGetObjValue(formObj.vsl_nm)      + "] yd_cd["      + ComGetObjValue(formObj.yd_cd)      + "] loc_nm["     + ComGetObjValue(formObj.loc_nm)     + "] " +
				                    "yd_nm["       + ComGetObjValue(formObj.yd_nm)       + "] slan_cd["    + ComGetObjValue(formObj.slan_cd)    + "] slan_nm["    + ComGetObjValue(formObj.slan_nm)    + "] " +
				                    "cbf_ind_flg[" + ComGetObjValue(formObj.cbf_ind_flg) + "] upd_dt["     + ComGetObjValue(formObj.upd_dt)     + "] crr_cd["     + ComGetObjValue(formObj.crr_cd)     + "] " +
				                    "pod_cd["      + ComGetObjValue(formObj.pod_cd)      + "] mlb_cd["     + ComGetObjValue(formObj.mlb_cd)     + "] rd_type["    + selP                               + "]";
				/************************************************************************************************************
				 * - 1. CBF Summary by Volume                          		: UI_OPF-1121 
				 * - 2. Special Cargo Summary by Volume                		: UI_OPF-1621
                 * - 3. CBF Summary by Volume (Mini Land Bridge)       		: UI_OPF-1221
                 * - 4. Special Cargo Summary by Volume  (Mini Land Bridge) : UI_OPF-1621
                 * 
                 * - 5. CBF Summary by Weight Group                    		: UI_OPF-1321
                 * - 6. CBF Summary by Weight Group (Mini Land Bridge) 		: UI_OPF-1421 
                 * 
                 * - 7. All Special Cargo                              		: UI_OPF-1521
                 * - 8. Dangerous Cargo                                		: UI_OPF-1521 
                 * - 9. Reefer Cargo                                   		: UI_OPF-1521 
                 * - 10.Awkward Cargo                                  		: UI_OPF-1521
                 * - 11.Break Bulk Cargo                               		: UI_OPF-1521
                 * - 12.Special Stowage                                		: UI_OPF-1521
                 * - 13.Empty Container                                		: UI_OPF-1521 
				 *************************************************************************************************************/
				var strPath="";
				//1. CBF Summary by Volume
				if (selP == "1") {
					strPath="VOP_OPF_1121.mrd";
				}
				//2. Special Cargo Summary by Volume
				else if (selP == "2") {
					strPath="VOP_OPF_1621.mrd";
				}
				//3. CBF Summary by Volume (Mini Land Bridge)
				else if (selP == "3") {
					strPath="VOP_OPF_1221.mrd";
				}
				//4. Special Cargo Summary by Volume (Mini Land Bridge)
				else if (selP == "4") {
					strPath="VOP_OPF_1621.mrd";
				}
				//5. CBF Summary by Weight Group
				else if (selP == "5") {
					strPath="VOP_OPF_1321.mrd";
				}
				//6. CBF Summary by Weight Group (Mini Land Bridge)
				else if (selP == "6") {
					strPath="VOP_OPF_1421.mrd";
				}
				//7. All Special Cargo
				else if (selP == "7") {
					strPath="VOP_OPF_1521.mrd";
				}
				//8. Dangerous Cargo
				else if (selP == "8") {
					strPath="VOP_OPF_1521.mrd";
				}
				//9. Reefer Cargo
				else if (selP == "9") {
					strPath="VOP_OPF_1521.mrd";
				}
				//10. Awkward Cargo
				else if (selP == "10") {
					strPath="VOP_OPF_1521.mrd";
				}
				//11. Break Bulk Cargo
				else if (selP == "11") {
					strPath="VOP_OPF_1521.mrd";
				}
				//12. Special Stowage
				else if (selP == "12") {
					strPath="VOP_OPF_1521.mrd";
				}
				//13. Empty Container
				else if (selP == "13") {
					strPath="VOP_OPF_1521.mrd";
				}
				
				strPath="apps/opus/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/report/" + strPath;
				var cgoOpr="";
				for ( var n=0; n < 5; n++) {
					if(n < cgoOprList.length) cgoOpr=cgoOprList[n];
					else cgoOpr="";
					if(ComTrim(oprComboObj.GetSelectText()) != "ALL") {
						if(n == 0) cgoOpr=ComTrim(oprComboObj.GetSelectText());
						else cgoOpr="";
					}
					rdParam=rdParam + " qty"+(n+1)+"[" + cgoOpr + "]";
				}				
				for(var i=1; i<=15; i++) {
					rdParam=rdParam + " st_"+i+"[" + ComGetObjValue(eval("formObj.st_"+i)) + "]";
				}
				rdParam=rdParam + " opr_st_ct[" + ComGetObjValue(formObj.opr_st_ct) + "]";
				for(var i=1; i<=5; i++) {
					for(var j=1; j<=15; j++) {
						rdParam=rdParam + " opr"+i+"_st"+j+"[" + ComGetObjValue(eval("formObj.opr"+i+"_st"+j)) + "]";
					}
				}
				for(var i=1; i<=75; i++) {
					rdParam=rdParam + " opr_stcd"+i+"[" + ComGetObjValue(eval("formObj.opr_stcd"+i)) + "]";
				}
				ComSetObjValue(formObj.com_mrdPath,                   strPath);
				ComSetObjValue(formObj.com_mrdArguments,              rdParam);
				ComSetObjValue(formObj.com_mrdSaveDialogDir,          "c:\\MyFolder\\");
				ComSetObjValue(formObj.com_mrdSaveDialogFileName,     "SaveFileName");
				ComSetObjValue(formObj.com_mrdSaveDialogFileExt,      "pdf");
				ComSetObjValue(formObj.com_mrdSaveDialogFileExtLimit, "xls@pdf@bmp@tif");
				ComSetObjValue(formObj.com_mrdTitle,                  "Report Designer Common Popup");
				ComSetObjValue(formObj.com_mrdBodyTitle,              "Print CBF Summary");
				ComSetObjValue(formObj.com_isBatch,                   "Y");
				var leftpos=(screen.width - 960) / 2;
				if (leftpos < 0) leftpos=0;
				var toppos=(screen.height - 650) / 2;
				if (toppos < 0) toppos=0;
				ComOpenRDPopupModal("dialogWidth:990px;dialogHeight:672px;status:No;dialogTop:"+toppos+"px;dialogLeft:"+leftpos+"px");
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {			
		return true;
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	//initialize RD
	function initRdConfig(rdObject) {
		var Rdviewer=rdObject;
		Rdviewer.AutoAdjust=true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetBackgroundColor(128, 128, 128);
		Rdviewer.SetPageLineColor(128, 128, 128);
		Rdviewer.SetSheetHeight(0);
	}
	/**
	 * initialize IBCOMBO. <br>
	 **/
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "pod_cd2":			
				with (comboObj) {
					SetDropHeight(230);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;	
			case "crr_cd2":
				with (comboObj) {
					SetDropHeight(230);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;
			case "mlb_cd2":
				with (comboObj) {
					SetDropHeight(230);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;
		}	
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		// initializing IBMultiCombo
		for (var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//initializing IBSheet
		for (var i=0; i < sheetObjects.length; i++) {			
			ComConfigSheet(sheetObjects[i]);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// initializing RD 
		for (var i=0; i < rdObjects.length; i++) {
			initRdConfig(rdObjects[i], i + 1);
		}
		
		
		// Call function OnLoadFinish
		//sheet1_OnLoadFinish(sheetObjects[0]);
		
		// Set Default Value
		pod_cd2.SetSelectText("ALL");
		crr_cd2.SetSelectText("ALL");
		mlb_cd2.SetSelectText("ALL");
		
		searchOprPodMlbCombo(sheetObjects[0]);	//POD, OPR, MBL
	}
	/**
     * Sheet1 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
//	function sheet1_OnLoadFinish(sheetObj) {
//    	 searchOprPodMlbCombo(sheetObj);	//POD, OPR, MBL
//	}
	
	// OPR OnChange event
	function crr_cd2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
    	var formObj=document.form;
    	var sParam="";
    	sParam += "vsl_cd="      + ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&yd_cd="      + ComGetObjValue(formObj.yd_cd);
    	if(Text == "ALL") {
    		var oprCt;
    		for(oprCt=0; oprCt<cgoOprList.length; oprCt++) {
    			sParam += "&qty"+(oprCt+1)+"=" + cgoOprList[oprCt];
    		}
    		for(var j=oprCt+1; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
    	} else {
    		sParam += "&qty1=" + Text;
    		for(var j=2; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
    	}
    	//Retrieve Stowage Code List 
    	searchStowageList(sheetObjects[0], formObj, sParam);
    }

	//POD, OPR, MLB Combo & Stowage Code List
	function searchOprPodMlbCombo(sheetObj) {
		var formObj=document.form;
		var sParam="";
		sParam += "vsl_cd="      + ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&yd_cd="      + ComGetObjValue(formObj.yd_cd);
		var podComboObj=comboObjects[0];
		var oprComboObj=comboObjects[1];
		var mlbComboObj=comboObjects[2];
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCH11;
		var sXml=sheetObj.GetSearchData("VOP_OPF_0021GS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		//1. POD
		var sPod=ComGetEtcData(sXml, "sPod");			
		if (sPod != undefined) {
			var arrPod=sPod.split("|");	
			var podCd=""; //yd_code + clpt_ind_seq
			for (var i=0; i < arrPod.length; i++) {
				podCd=arrPod[i];
				if(podCd != '') podCd=podCd.substring(0, podCd.length-1); 
				podComboObj.InsertItem(i+1, podCd, arrPod[i]);
			}
		}
		//2. OPR
		var sOpr=ComGetEtcData(sXml, "sOpr");	
		var oprCt=0;
		var sPCt=1;
		if (sOpr != undefined) {
			var arrOpr=sOpr.split("|");					
			for (var i=0; i < arrOpr.length; i++) {
				if(ComTrim(arrOpr[i]) != '') {
					oprComboObj.InsertItem(i+1, arrOpr[i], arrOpr[i]);
					cgoOprList[oprCt++]=arrOpr[i];
					sParam += "&qty"+(sPCt++)+"=" + arrOpr[i];
				}
			}
			for(var j=sPCt; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
		}		
		//3. MLB
		var sMlb=ComGetEtcData(sXml, "sMlb");	
		if (sMlb != undefined) {
			var arrMlb=sMlb.split("|");					
			for (var i=0; i < arrMlb.length; i++) {
				if(ComTrim(arrMlb[i]) != '') {
					mlbComboObj.InsertItem(i+1, arrMlb[i], arrMlb[i]);
				}
			}
		}
		//4. Stowage	
		searchStowageList(sheetObj, formObj, sParam);
	}
	
	//Stowage Code List
	function searchStowageList(sheetObj, formObj, sParam) {	
		sheetObj.SetWaitImageVisible(0);
		sParam += "&f_cmd=" + SEARCH16;
		var stwgXml=sheetObj.GetSearchData("VOP_OPF_2019GS.do", sParam);
		var stwgStr=ComGetEtcData(stwgXml, "stwgCdList");
		var stwgList=stwgStr.split("|");		
		var stParams=new Array();	//Stowage parameter list
		var stFields=new Array();	//Stowage list by OPR
		var stFiledCt=0;
		var stDup=false;
		var stCt=0;
		var colCt=0;
		var stcdCt=0;
		//construct OPR by OPR condition 
		var curCgoOprs=new Array();
		var curCgoOprTxt=comboObjects[1].GetSelectText();
		if(curCgoOprTxt == "ALL") {
			for(var oprCt=0; oprCt<cgoOprList.length; oprCt++) {
				curCgoOprs[oprCt]=cgoOprList[oprCt];
			}
		} else {
			curCgoOprs[0]=curCgoOprTxt;
		}
		if(ComTrim(stwgStr) != "") {			
			for (var cgoOprCt=0; cgoOprCt<curCgoOprs.length; cgoOprCt++) {
				cgoOprVal=curCgoOprs[cgoOprCt];
				stFields[cgoOprCt]=new Array();
				stFiledCt=0;
				for (; colCt < stwgList.length;) {
					var stwgCd=stwgList[colCt].split("+")[1];
					if(cgoOprVal == stwgList[colCt].split("+")[0]) {						
						//creating parameter
						stDup=false;
						for(var stCts=0; stCts<stParams.length; stCts++) {
							if(stwgCd == stParams[stCts]) stDup=true;
						}
						if(!stDup) stParams[stCt++]=stwgCd;
						stFields[cgoOprCt][stFiledCt++]=stwgCd;
						ComSetObjValue(eval("formObj.opr_stcd"+(++stcdCt)), cgoOprVal+"_"+stwgCd);
					} else {
						break;
					}
					colCt++;
				}
				//initialize other parameters
				for(var restCt=stcdCt+1; restCt<=75; restCt++) {
					ComSetObjValue(eval("formObj.opr_stcd"+(restCt)), "");
				}
			}
		}
		cgoOprCt=0;
		ComSetObjValue(formObj.opr_st_ct, stParams.length);
		for(stCt=0; stCt<15; stCt++) {
			if(stCt<stParams.length) {	
				ComSetObjValue(eval("formObj.st_"+(stCt+1)), stParams[stCt]);
				for(var cgoOprCt2=0; cgoOprCt2<stFields.length; cgoOprCt2++) {
					for(stFiledCt=0; stFiledCt<stFields[cgoOprCt2].length; stFiledCt++) {
						if(stParams[stCt] == stFields[cgoOprCt2][stFiledCt]) stFields[cgoOprCt2][stFiledCt]=stCt+1;
					}
				}
			} else {
				ComSetObjValue(eval("formObj.st_"+(stCt+1)), "");
			}
		}
		var tCt=1;
		if(ComTrim(stwgStr) != "") {
			//initialize parameter 
			for (var cgoOprCt=1; cgoOprCt<=5; cgoOprCt++) {
				for ( colCt=1; colCt<=15; colCt++) {
					ComSetObjValue(eval("formObj.opr"+cgoOprCt+"_st"+colCt), "0");
				}
			}
			//#step2[construct Stowage ] - setting return filter by parameter 
			for (var cgoOprCt=1; cgoOprCt<=curCgoOprs.length; cgoOprCt++) {
				for ( colCt=1; stFields[cgoOprCt-1] != null && colCt <= stFields[cgoOprCt-1].length; colCt++) {		
					var fieldIdx=stFields[cgoOprCt-1][colCt-1];
					ComSetObjValue(eval("formObj.opr"+cgoOprCt+"_st"+fieldIdx), tCt++);	
				}
			}
		}
		sheetObj.SetWaitImageVisible(1);
	}