/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0218.js
*@FileTitle  :  Draft B/L &amp; Waybill (Fax / E-Mail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21 
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class business script for ESM_BKG_0218
     */
/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var rdParam;
var rdPath;
var rdPdf;
var appendReport = [];
var appendMrdPath = [];
var appendMrdParam = [];

// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        var rdObject=viewer;
    	try {
    		var srcName=ComGetEvent("name");
    	    if(ComGetBtnDisable(srcName)) return false;
        	//Outbound 
    		if (0==beforetab) {
        		switch(srcName) {
		            //Retrieve
			        case "btn_retrieve":
			        	if (!validateForm(sheetObject1,formObject,IBSEARCH)) return false;
		                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		                break;
		            //New
			        case "btn_new":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
		                break;
		            //Down Excel
		            case "btn_down_excel":
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		                break;
	                //TAB1(Outbound) begin
		            case "t1_rdo_bl_tp_cd":
		            	if ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])) {
		                	ComBtnEnable("btn_remark_t1sht1");
		            	} else {
		                	ComBtnDisable("btn_remark_t1sht1");
		            	}
		            	break;
		            case "t1_rdo_bkg_bl":
		            	var rdo_bkg_bl=ComGetObjValue(formObject.elements["t1_rdo_bkg_bl"]);
		            	if ("BKG"==rdo_bkg_bl) {
		            		formObject.elements["t1_txt_bl_no"].value="";
		            		formObject.elements["t1_txt_bl_no"].style.display="none";
		            		formObject.elements["t1_txt_bkg_no"].style.display="inline";
		            	} else if ("BL"==rdo_bkg_bl) {
		            		formObject.elements["t1_txt_bkg_no"].value="";
		            		formObject.elements["t1_txt_bkg_no"].style.display="none";
		            		formObject.elements["t1_txt_bl_no"].style.display="inline";
		            	}
		            	break;
					//Calendar(On Board, B/L Issue)
		            case "t1_btn_calendar":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.elements["t1_txt_date_from"], formObject.elements["t1_txt_date_to"],'yyyy-MM-dd');
						break;
		            //Preview
	                case "btn_preview_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_preview_t1sht1")) return false;
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length) {
//							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							ufSetRdParamMulti(formObject,arrRow);
							
							formObject.com_mrdBodyTitle.value="Draft B/L Copies";
							formObject.com_mrdTitle.value="Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"bkg_no");
							ComBkgOpenRDPopup("resizable=yes, width=900, height=800");
						}
						break;
					case "btn_faxemail_t1sht1":
	    				if(!validateForm(sheetObject1,formObject,"btn_faxemail_t1sht1")) return false;
			        	//open popup 0221
			        	var width=400;
						var height=190;
						var left=(screen.width-width)/2;
						var top=(screen.height-height)/2;
						
						var url="ESM_BKG_0221.do";
						var url="ESM_BKG_0221.do?func=getCOM_Fax_Email_POPUP&send_hidden=Y";
						ComOpenWindowCenter(url, "ESM_BKG_0221", 400, 190, true);
						
//						ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
//						
//						//send popup
//						var formObject3=document.form3;
//						formObject3.elements["pop_mode"   ].value="1";
//						formObject3.elements["display"    ].value="1,0,1,1,1,1,1";
//						formObject3.elements["func"       ].value="getCOM_Fax_Email_POPUP";
//						formObject3.elements["row"        ].value="0";
//						formObject3.elements["col"        ].value="0";
//						formObject3.elements["sheetIdx"   ].value="0";
//						formObject3.elements["bkg_no"     ].value="";
//						formObject3.elements["send_hidden"].value="Y";
//						formObject3.action="/opuscntr/ESM_BKG_0221.do";
//						formObject3.target="ESM_BKG_0221";
//						formObject3.submit();
	                    break;
	                //Fax
			        case "btn_fax_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_fax_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_fax_t1sht1");
	                    break;
			        //E-mail
			        case "btn_email_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_email_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_email_t1sht1");
	                    break;
	                //Group E-mail
			        case "btn_groupemail_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_groupemail_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_groupemail_t1sht1");
	                    break;
	                //Manifest(US)
			        case "btn_manifest_t1sht1":
			        	if(!validateForm(sheetObject1,formObject,"btn_manifest_t1sht1")) return false;
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length && 50>=arrRow.length) {
							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							rdParam=rdParam.replace(/(form_type\[\d\])/g,"form_type[2]");  //setting form_type
							rdParam=rdParam.replace(/(form_level\[\(\d\)\])/g,"form_level[(6)]");  //setting form_level
							rdParam=rdParam.replace(/(form_manifest\[\w\])/g,"form_manifest[X]");  //setting form_manifest
							formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
							if (0==sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"por_cd").indexOf("US")) {
								formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
							}
							formObject.com_mrdArguments.value=rdParam + " /rwait";
							formObject.com_mrdBodyTitle.value="Draft B/L Copies";
							formObject.com_mrdTitle.value="Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"bkg_no");
							ComOpenRDPopup("resizable=yes, width=900, height=800");
						}
	                    break;
	                //Remark(s)
			        case "btn_remark_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_remark_t1sht1")) return false;
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						var rmk="";
						if (arrRow && 0<arrRow.length) {
							var remark="";
							if(sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk").length==0 && sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark").length==0){
								remark = "";
							}else if(sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark").length==0){
								remark = sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk");
							}else if(sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk").length==0){
								remark = sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark");
							}else{
								remark = sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark") +"\n" +sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk");
							}
							remark = replaceRemark(remark);		//last character '\n' 
							
//							rmk=1==arrRow.length ? sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark") : "";
							rmk=1==arrRow.length ? remark : "";
								
						}
						formObject.elements["inter_rmk"].value=rmk;
//						ComOpenWindow("ESM_BKG_0913.do?screen_id=0218","ESM_BKG_0913","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=yes,alwaysRaised,dependent,titlebar=no,width=500,height=250",true);
						var url="ESM_BKG_0913.do?screen_id=0218";
						ComOpenWindowCenter(url, "ESM_BKG_0913", 650, 400, true);
						break;
			        case "btn_assign_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_assign_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_assign_t1sht1");
			        	break;
	                //Print
			        case "btn_print_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_print_t1sht1")) return false;
						rdOpen(rdObject, formObject, "print");
	                    break;
					case "btn_EmailEdit_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_EmailEdit_t1sht1")) return false;
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						var ntc_knd_cd="W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "BL"  : ("C"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])?"CW":"NN"));
						var bkg_no_list="";
						var edt_to_eml="";
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) {
								bkg_no_list += sheetObject1.GetCellValue(arrRow[i],sheetObject1.id+"bkg_no")+'|';
							}
							if (0<bkg_no_list.indexOf("|")) bkg_no_list=bkg_no_list.substring(0,bkg_no_list.length-1);
							edt_to_eml=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"eml");
							var sgn_cpy_snd_flg = sheetObject1.GetCellValue(arrRow[i],sheetObject1.id+"sgn_cpy_snd_flg");
							ComOpenWindowCenter("/opuscntr/ESM_BKG_1096.do?ui_id=ESM_BKG_0218_01&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml+"&sgn_cpy_snd_flg"+sgn_cpy_snd_flg, "ESM_BKG_1096", 700, 670, true);
						}
						break;
	                //TAB1(Outbound) end
        		}
            //Inbound
        	} else if (1==beforetab) {
        		switch(srcName) {
		            //Retrieve
			        case "btn_retrieve":
			        	if (!validateForm(sheetObject2,formObject,IBSEARCH)) return false;
		                doActionIBSheet(sheetObject2,formObject,IBSEARCH);
		                break;
		            //New
			        case "btn_new":
						doActionIBSheet(sheetObject2,formObject,IBCLEAR);
		                break;
		            //Down Excel
		            case "btn_down_excel":
						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
		                break;
		            //TAB2(Inbound) begin
		            case "t2_rdo_bl_tp_cd":
		            	if ("D"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"])) {
		                	ComBtnEnable("btn_remark_t2sht1");
		            	} else {
		                	ComBtnDisable("btn_remark_t2sht1");
		            	}
		            	break;
		            //Calendar(ETA Date)
		            case "t2_btn_calendar":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.elements["t2_txt_date_from"], formObject.elements["t2_txt_date_to"],'yyyy-MM-dd');
						break;
		            //Calendar(On Board, B/L Issue)
		            case "t2_btn_calendar2":
						var cal=new ComCalendarFromTo();
						cal.select(formObject.elements["t2_txt_date_from2"], formObject.elements["t2_txt_date_to2"],'yyyy-MM-dd');
						break;
	                //Preview
			        case "btn_preview_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_preview_t2sht1")) return false;
						var arrRow=ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);

						if (arrRow && 0<arrRow.length) {
//							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							ufSetRdParamMulti(formObject,arrRow);
							formObject.com_mrdBodyTitle.value="Draft B/L Copies";
							formObject.com_mrdTitle.value="Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value=sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"bkg_no");
//							ComOpenRDPopup("resizable=yes, width=900, height=800");
							ComBkgOpenRDPopup("resizable=yes, width=900, height=800");
						}
			        	break;
	                //Edit Fax/E-mail
	                case "btn_faxemail_t2sht1":
	    				if(!validateForm(sheetObject2,formObject,"btn_faxemail_t2sht1")) return false;
			        	//open popup 0221
			        	var width=400;
						var height=190;
						var left=(screen.width-width)/2;
						var top=(screen.height-height)/2;
						var url="ESM_BKG_0221.do";
						var url="ESM_BKG_0221.do?func=getCOM_Fax_Email_POPUP&send_hidden=Y";
						ComOpenWindowCenter(url, "ESM_BKG_0221", 400, 190, true);
//						ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
//						//send popup
//						var formObject3=document.form3;
//						formObject3.elements["pop_mode"   ].value="1";
//						formObject3.elements["display"    ].value="1,0,1,1,1,1,1";
//						formObject3.elements["func"       ].value="getCOM_Fax_Email_POPUP";
//						formObject3.elements["row"        ].value="0";
//						formObject3.elements["col"        ].value="0";
//						formObject3.elements["sheetIdx"   ].value="0";
//						formObject3.elements["bkg_no"     ].value="";
//						formObject3.elements["send_hidden"].value="Y";
//						formObject3.action="/opuscntr/ESM_BKG_0221.do";
//						formObject3.target="ESM_BKG_0221";
//						formObject3.submit();
	                    break;
	                //Fax
			        case "btn_fax_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_fax_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_fax_t2sht1");
	                    break;
	                //E-mail
			        case "btn_email_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_email_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_email_t2sht1");
	                    break;
	                //Group E-mail
			        case "btn_groupemail_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_groupemail_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_groupemail_t2sht1");
	                    break;
	                //Remark(s)
			        case "btn_remark_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_remark_t2sht1")) return false;
						var arrRow=ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);
						var rmk="";
						if (arrRow && 0<arrRow.length) {
							var remark="";
							if(sheetObject2.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk").length==0 && sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"remark").length==0){
								remark = "";
							}else if(sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark").length==0){
								remark = sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk");
							}else if(sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"diff_rmk").length==0){
								remark = sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"remark");
							}else{
								remark = sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"remark") +"\n" +sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"diff_rmk");
							}
							remark = replaceRemark(remark);		//last character '\n' 
							
//							rmk=1==arrRow.length ? sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"remark") : "";
							rmk=1==arrRow.length ? remark : "";
						}
						
//						formObject.elements["inter_rmk"].value=ComReplaceStr(ComReplaceStr(rmk,"\r","\\r"),"\n","\\n");
						formObject.elements["inter_rmk"].value=rmk;
						var url="ESM_BKG_0913.do?screen_id=0218";
						ComOpenWindowCenter(url, "ESM_BKG_0913", 650, 400, true);
						
						break;
	                //Print
			        case "btn_print_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_print_t2sht1")) return false;
						rdOpen(rdObject, formObject, "print");
	                    break;
					case "btn_EmailEdit_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_EmailEdit_t2sht1")) return false;
						var arrRow=ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);
						var ntc_knd_cd="W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
						var bkg_no_list="";
						var edt_to_eml="";
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) {
								bkg_no_list += sheetObject2.GetCellValue(arrRow[i],sheetObject2.id+"bkg_no")+'|';
							}
							if (0<bkg_no_list.indexOf("|")) bkg_no_list=bkg_no_list.substring(0,bkg_no_list.length-1);
							edt_to_eml=sheetObject2.GetCellValue(arrRow[0],sheetObject2.id+"eml");
							ComOpenWindowCenter("/opuscntr/ESM_BKG_1096.do?ui_id=ESM_BKG_0218_02&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 670, true);
						}
						break;
	                //TAB2(Inbound) end
        		}  // end switch
            }  // end TAB
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		for(k=sheetObjects.length-1;0<=k;k--){
			doActionIBSheet(sheetObjects[k],document.form,IBCLEAR);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        var formObject=document.form;
        if (0<=location.href.indexOf("_02_POP.") || 0<=location.href.indexOf("_02.")) {  //inbound
        	beforetab=1;
			tabObjects[0].SetSelectedIndex(1);
			var objs=document.all.item("tabLayer");
	    	objs[1].style.display="Inline";
	    	objs[0].style.display="none";
	    	objs[0].style.zIndex=objs[1].style.zIndex -1 ;
	    	
	    	if (getParameter("bl_no")) {  //bl_no 
				formObject.elements["t2_txt_bl_no"].value=getParameter("bl_no");
	        	if (!validateForm(sheetObjects[1],formObject,IBSEARCH)) return false;
	            doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
			}
    	} else {  //outbound
        	beforetab=0;
    	}
        
        if(formObject.bl_prn_chg_tp_cd.value=="1"){
        	formObject.t1_chk_opt1.checked=true;
        	formObject.t1_chk_opt2.checked=false;
        	formObject.t1_chk_opt3.checked=false;
        	formObject.t1_chk_opt4.checked=false;
        	formObject.t1_chk_opt5.checked=false;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }else if(formObject.bl_prn_chg_tp_cd.value=="5"){
        	formObject.t1_chk_opt1.checked=false;
        	formObject.t1_chk_opt2.checked=true;
        	formObject.t1_chk_opt3.checked=false;
        	formObject.t1_chk_opt4.checked=false;
        	formObject.t1_chk_opt5.checked=false;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }else if(formObject.bl_prn_chg_tp_cd.value=="4"){
        	formObject.t1_chk_opt1.checked=false;
        	formObject.t1_chk_opt2.checked=false;
        	formObject.t1_chk_opt3.checked=true;
        	formObject.t1_chk_opt4.checked=false;
        	formObject.t1_chk_opt5.checked=false;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }else if(formObject.bl_prn_chg_tp_cd.value=="6"){
        	formObject.t1_chk_opt1.checked=false;
        	formObject.t1_chk_opt2.checked=false;
        	formObject.t1_chk_opt3.checked=false;
        	formObject.t1_chk_opt4.checked=true;
        	formObject.t1_chk_opt5.checked=false;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }else if(formObject.bl_prn_chg_tp_cd.value=="3"){
        	formObject.t1_chk_opt1.checked=true;
        	formObject.t1_chk_opt2.checked=false;
        	formObject.t1_chk_opt3.checked=false;
        	formObject.t1_chk_opt4.checked=false;
        	formObject.t1_chk_opt5.checked=true;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }else{
        	formObject.t1_chk_opt1.checked=true;
        	formObject.t1_chk_opt2.checked=false;
        	formObject.t1_chk_opt3.checked=false;
        	formObject.t1_chk_opt4.checked=false;
        	formObject.t1_chk_opt5.checked=false;
        	formObject.t2_chk_opt1.checked=true;
        	formObject.t2_chk_opt2.checked=false;
        	formObject.t2_chk_opt3.checked=false;
        	formObject.t2_chk_opt4.checked=false;
        	formObject.t2_chk_opt5.checked=false;
        }
//		formObject.form_level.value=formObject.bl_prn_chg_tp_cd.value == "" ? "1" : formObject.bl_prn_chg_tp_cd.value;        
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObject,sheetNo) {
        var cnt=0;
		var prefix="";
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObject){
		                prefix=sheetObject.id;
		             
		//             (46, 5, 0, true);
		             var HeadTitle="|Sel.|Sel.|Booking No.|S|B/L No.|Shipper Code|Shipper Name||FF Code|T.VVD|POL|POD";
		             HeadTitle      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC|Sign";
		             HeadTitle      +=  "|Fax Sent|Fax Sent|Fax Sent|Fax Sent|E-mail Sent|E-mail Sent|E-mail Sent|E-mail Sent||";
		             var HeadTitle1="|Sel.|Sel.|Booking No.|S|B/L No.|Shipper Code|Shipper Name||FF Code|T.VVD|POL|POD";
		             HeadTitle1      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC|Sign";
		             HeadTitle1      +=  "|Result|Result|Fax Date||Result|Result|Date|||";
		             SetMergeCell(0,1,2,2);
		             SetMergeCell(0,13,2,2);
		             SetMergeCell(0,15,2,2);
		
		             SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"},
		                       { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",        Wrap:1 },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slct_flg",      Wrap:1 },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",           Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:20,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:95,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shpr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:150, Align:"Left",    ColMerge:1,   SaveName:prefix+"short_shpr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"shpr_nm",       Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ff_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fax_btn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eml_btn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:85,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cntc_pson_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"CheckBox",      Hidden:1, Width:50,   Align:"Center",    ColMerge:0,   SaveName:prefix+"sgn_cpy_snd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_result",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fax_his_btn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_date",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_reason",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_result",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eml_his_btn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_date",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"eml_reason",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_all_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_clt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_ppd_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_chg_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_arr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"hidd_opt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"new_flg",       Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"syscd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplmrd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"title",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplparam",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rcvinfo",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rcveml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"contents",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplmrdpdf",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"itr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"grp_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetImageList(0,"img/btns_plus.gif");
	                 SetImageList(1,"img/btns_minus.gif");
	                 SetImageList(2,"img/btns_multisearch.gif");
	                 
	                 SetDataLinkMouse(prefix+"fax_btn", 1);
	                 SetDataLinkMouse(prefix+"eml_btn", 1);
	                 SetDataLinkMouse(prefix+"fax_his_btn", 1);
	                 SetDataLinkMouse(prefix+"eml_his_btn", 1);
		             
		             SetColProperty(prefix+"fax_date", {Format:"####-##-####:##"} );
		             SetColProperty(prefix+"eml_date", {Format:"####-##-####:##"} );
		             SetShowButtonImage(1);
//		             SetSheetHeight(220);
		             updateSheetSize(sheetObject);
             }


                break;
            case 2:      //t2sheet1 init
                with(sheetObject){
		                prefix=sheetObject.id;
		              
//		              (46, 5, 0, true);
		              var HeadTitle="|Sel.|Sel.|Booking No.|S|B/L No.|CNEE/NTFY Code|CNEE/NTFY Name||FF Code|T.VVD|POL|POD";
		              HeadTitle      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
		              HeadTitle      +=  "|Fax Sent|Fax Sent|Fax Sent|Fax Sent|E-mail Sent|E-mail Sent|E-mail Sent|E-mail Sent||";
		              var HeadTitle1="|Sel.|Sel.|Booking No.|S|B/L No.|CNEE/NTFY Code|CNEE/NTFY Name||FF Code|T.VVD|POL|POD";
		              HeadTitle1      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
		              HeadTitle1      +=  "|Result|Result|Fax Date||Result|Result|Date|||";
		              SetMergeCell(0,1,2,2);
		              SetMergeCell(0,13,2,2);
		              SetMergeCell(0,15,2,2);
		
		              SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"},
		                          { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",        Wrap:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slct_flg",      Wrap:1 },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",           Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:1,   SaveName:prefix+"shpr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"short_shpr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"shpr_nm",       Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ff_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fax_btn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eml_btn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cntc_pson_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_result",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fax_his_btn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_date",      KeyField:0,   CalcLogic:"",   Format:"YmdHms",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"fax_reason",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_result",    KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eml_his_btn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
		                     {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_date",      KeyField:0,   CalcLogic:"",   Format:"YmdHms",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"eml_reason",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_all_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_clt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_ppd_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_chg_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"frt_arr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"hidd_opt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"new_flg",       Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"syscd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplmrd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"title",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplparam",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rcvinfo",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rcveml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"contents",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tmplmrdpdf",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"itr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"ntc_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"grp_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0,     Wrap:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetImageList(0,"img/btns_plus.gif");
		              SetImageList(1,"img/btns_minus.gif");
		              SetImageList(2,"img/btns_multisearch.gif");
		                 
		              SetDataLinkMouse(prefix+"fax_btn", 1);
		              SetDataLinkMouse(prefix+"eml_btn", 1);
		              SetDataLinkMouse(prefix+"fax_his_btn", 1);
		              SetDataLinkMouse(prefix+"eml_his_btn", 1);
		                 
//		              SetColProperty(prefix+"fax_date", {Format:"####-##-####:##"} );
//		              SetColProperty(prefix+"eml_date", {Format:"####-##-####:##"} );
		              SetShowButtonImage(1);
//		              SetSheetHeight(239);
		              updateSheetSize(sheetObject);
              }
                break;
        }
    }
    
$(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
});

$(window).on('resizeEnd', function() {
	 updateSheetSize();
});

function updateSheetSize(sheetObj){
  if(typeof sheetObj == "undefined") {
	for(var i = 0; i < sheetObjects.length; i++) {
		if($("#"+sheetObjects[i].id).offset().top != 0) {
			sheetObj = sheetObjects[i];
			break;
		}
	}
  }
  var obj = $("#" + sheetObj.id).offset();
  var marginDefault = 100;
  var sheetTop = obj.top;
  if(obj.top == 0) {
	  sheetTop = $("#t1sheet1").offset().top - 30;
  }
  var marginHeight = sheetTop + marginDefault;
  var height = $(window).height();

  with(sheetObj){
     SetSheetHeight(height - marginHeight);
  }
}    
    
 	function initControl() {
		var formObject=document.form;
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
//		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
//        axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
		//axon_event.addListenerForm('beforedeactivate', 'bkg0218_obj_deactivate', formObject); //- 포커스 나갈때
		//axon_event.addListenerFormat('beforeactivate',   'bkg0218_activate', formObject); //- 포커스 들어갈때
		//axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}
 	function ufRetrieveByEnterKey() {
        if (13!=event.keyCode) return;
        document.getElementById("btn_retrieve").fireEvent("onclick");
 	}
 // handling of Sheet process
    function doActionIBSheet(sheetObject,formObject,sAction) {
    	sheetObject.ShowDebugMsg(false);
        switch(sAction) {
			case IBCLEAR:      //init
		    	ComClearObject(formObject.elements["f_cmd"          ]);
		    	ComClearObject(formObject.elements["bl_tp_cd"       ]);
		    	ComClearObject(formObject.elements["vsl_cd"         ]);
		    	ComClearObject(formObject.elements["skd_voy_no"     ]);
		    	ComClearObject(formObject.elements["skd_dir_cd"     ]);
		    	ComClearObject(formObject.elements["pol_cd"         ]);
		    	ComClearObject(formObject.elements["pod_cd"         ]);
		    	ComClearObject(formObject.elements["bkg_ofc_cd"     ]);
		    	ComClearObject(formObject.elements["doc_usr_id"     ]);
		    	ComClearObject(formObject.elements["bkg_sts_cd"     ]);
		    	ComClearObject(formObject.elements["bkg_cust_tp_cd" ]);
		    	ComClearObject(formObject.elements["cust_cnt_cd"    ]);
		    	ComClearObject(formObject.elements["cust_seq"       ]);
		    	ComClearObject(formObject.elements["cust_nm"        ]);
		    	ComClearObject(formObject.elements["obl_iss_ofc_cd" ]);
		    	ComClearObject(formObject.elements["obl_iss_usr_id" ]);
		    	ComClearObject(formObject.elements["ob_sls_ofc_cd"  ]);
		    	ComClearObject(formObject.elements["ob_srep_cd"     ]);
		    	ComClearObject(formObject.elements["bkg_no"         ]);
		    	ComClearObject(formObject.elements["bl_no"          ]);
		    	ComClearObject(formObject.elements["bl_obrd_dt_from"]);
		    	ComClearObject(formObject.elements["bl_obrd_dt_to"  ]);
		    	ComClearObject(formObject.elements["obl_iss_dt_from"]);
		    	ComClearObject(formObject.elements["obl_iss_dt_to"  ]);
		    	ComClearObject(formObject.elements["fax_proc_sts_cd"]);
		    	ComClearObject(formObject.elements["eml_proc_sts_cd"]);
		    	if ("t1sheet1"==sheetObject.id) {
			    	ComClearObject(formObject.elements["t1_txt_vvd"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pol"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pod"            ]);
			    	ComClearObject(formObject.elements["t1_txt_bkg_ofc"        ]);
			    	ComClearObject(formObject.elements["t1_txt_doc_usr_id"     ]);
			    	ComClearObject(formObject.elements["t1_slt_bkg_sts_cd"     ]);
			    	ComClearObject(formObject.elements["t1_slt_bkg_cust_tp_cd" ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_seq1"      ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_seq2"      ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_nm"        ]);
			    	ComClearObject(formObject.elements["t1_txt_obl_iss_ofc_cd" ]);
			    	ComClearObject(formObject.elements["t1_txt_obl_iss_usr_id" ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_sls_ofc_cd"  ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_srep_cd"     ]);
			    	ComClearObject(formObject.elements["t1_txt_bkg_no"         ]);
			    	ComClearObject(formObject.elements["t1_txt_bl_no"          ]);
			    	ComClearObject(formObject.elements["t1_rdo_date_flg"       ]);
			    	ComClearObject(formObject.elements["t1_slt_fax_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t1_slt_eml_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t1_txt_date_from"      ]);
			    	ComClearObject(formObject.elements["t1_txt_date_to"        ]);
			    	ComClearObject(formObject.elements["faxBlTotal1"           ]);
			    	ComClearObject(formObject.elements["faxTotal1"             ]);
			    	ComClearObject(formObject.elements["faxSuccess1"           ]);
			    	ComClearObject(formObject.elements["faxSending1"           ]);
			    	ComClearObject(formObject.elements["faxUnSent1"            ]);
			    	ComClearObject(formObject.elements["emlBlTotal1"           ]);
			    	ComClearObject(formObject.elements["emlTotal1"             ]);
			    	ComClearObject(formObject.elements["emlSuccess1"           ]);
			    	ComClearObject(formObject.elements["emlSending1"           ]);
			    	ComClearObject(formObject.elements["emlUnSent1"            ]);
			    } else if ("t2sheet1"==sheetObject.id) {
					ComClearObject(formObject.elements["sc_no"                 ]);
    		    	ComClearObject(formObject.elements["eta_dt_from"           ]);
    		    	ComClearObject(formObject.elements["eta_dt_to"             ]);
			    	ComClearObject(formObject.elements["t2_txt_vvd"            ]); 
			    	ComClearObject(formObject.elements["t2_txt_pod"            ]);
			    	ComClearObject(formObject.elements["t2_txt_pol"            ]);
			    	ComClearObject(formObject.elements["t2_txt_sc_no"          ]);
			    	ComClearObject(formObject.elements["t2_slt_bkg_cust_tp_cd" ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_seq1"      ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_seq2"      ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_nm"        ]);
			    	ComClearObject(formObject.elements["t2_txt_bl_no"          ]);
			    	ComClearObject(formObject.elements["t2_rdo_date_flg"       ]);
			    	ComClearObject(formObject.elements["t2_slt_fax_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t2_slt_eml_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t2_txt_date_from"      ]);
			    	ComClearObject(formObject.elements["t2_txt_date_to"        ]);
			    	ComClearObject(formObject.elements["t2_txt_date_from2"     ]);
			    	ComClearObject(formObject.elements["t2_txt_date_to2"       ]);
			    	ComClearObject(formObject.elements["faxBlTotal2"           ]);
			    	ComClearObject(formObject.elements["faxTotal2"             ]);
			    	ComClearObject(formObject.elements["faxSuccess2"           ]);
			    	ComClearObject(formObject.elements["faxSending2"           ]);
			    	ComClearObject(formObject.elements["faxUnSent2"            ]);
			    	ComClearObject(formObject.elements["emlBlTotal2"           ]);
			    	ComClearObject(formObject.elements["emlTotal2"             ]);
			    	ComClearObject(formObject.elements["emlSuccess2"           ]);
			    	ComClearObject(formObject.elements["emlSending2"           ]);
			    	ComClearObject(formObject.elements["emlUnSent2"            ]);
        		}
				sheetObject.RemoveAll();
				break;
            case IBSEARCH:      //retrieve
			    if ("t1sheet1"==sheetObject.id) {
			    	var vvd=ComGetObjValue(formObject.elements["t1_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value=SEARCH01;
			    	formObject.elements["bl_tp_cd"       ].value=ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]);
			    	formObject.elements["vsl_cd"         ].value=vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value=vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value=vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value=ComGetObjValue(formObject.elements["t1_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value=ComGetObjValue(formObject.elements["t1_txt_pod"]);
					formObject.elements["bkg_ofc_cd"     ].value=ComGetObjValue(formObject.elements["t1_txt_bkg_ofc"]);
					formObject.elements["doc_usr_id"     ].value=ComGetObjValue(formObject.elements["t1_txt_doc_usr_id"]);
					formObject.elements["bkg_sts_cd"     ].value=ComGetObjValue(formObject.elements["t1_slt_bkg_sts_cd"]);
					formObject.elements["bkg_cust_tp_cd" ].value=ComGetObjValue(formObject.elements["t1_slt_bkg_cust_tp_cd"]);
					formObject.elements["cust_cnt_cd"    ].value=ComGetObjValue(formObject.elements["t1_txt_cust_seq1"]);
					formObject.elements["cust_seq"       ].value=ComGetObjValue(formObject.elements["t1_txt_cust_seq2"]);
					formObject.elements["cust_nm"        ].value=ComGetObjValue(formObject.elements["t1_txt_cust_nm"]);
					formObject.elements["obl_iss_ofc_cd" ].value=ComGetObjValue(formObject.elements["t1_txt_obl_iss_ofc_cd"]);
					formObject.elements["obl_iss_usr_id" ].value=ComGetObjValue(formObject.elements["t1_txt_obl_iss_usr_id"]);
					formObject.elements["ob_sls_ofc_cd"  ].value=ComGetObjValue(formObject.elements["t1_txt_ob_sls_ofc_cd"]);
					formObject.elements["ob_srep_cd"     ].value=ComGetObjValue(formObject.elements["t1_txt_ob_srep_cd"]);
					formObject.elements["bkg_no"         ].value=ComGetObjValue(formObject.elements["t1_txt_bkg_no"]);
					formObject.elements["bl_no"          ].value=ComGetObjValue(formObject.elements["t1_txt_bl_no"]);
  					if ("OnBoard"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value=ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["bl_obrd_dt_to"  ].value=ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["bl_obrd_dt_from"],"","-");
						ComClearSeparator(formObject.elements["bl_obrd_dt_to"],"","-");
						formObject.elements["obl_iss_dt_from"].value="";
						formObject.elements["obl_iss_dt_to"  ].value="";
  					} else if ("Issue"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value="";
						formObject.elements["bl_obrd_dt_to"  ].value="";
						formObject.elements["obl_iss_dt_from"].value=ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["obl_iss_dt_to"  ].value=ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["obl_iss_dt_from"],"","-");
						ComClearSeparator(formObject.elements["obl_iss_dt_to"],"","-");
  					}
  					formObject.elements["fax_proc_sts_cd"].value=ComGetObjValue(formObject.elements["t1_slt_fax_proc_sts_cd"]);
  					formObject.elements["eml_proc_sts_cd"].value=ComGetObjValue(formObject.elements["t1_slt_eml_proc_sts_cd"]);
        		} else if ("t2sheet1"==sheetObject.id) {
			    	var vvd=ComGetObjValue(formObject.elements["t2_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value=SEARCH02;
			    	formObject.elements["bl_tp_cd"       ].value=ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]);
					formObject.elements["eta_dt_from"    ].value=ComGetObjValue(formObject.elements["t2_txt_date_from"]);
					formObject.elements["eta_dt_to"      ].value=ComGetObjValue(formObject.elements["t2_txt_date_to"]);
					ComClearSeparator(formObject.elements["eta_dt_from"],"","-");
					ComClearSeparator(formObject.elements["eta_dt_to"],"","-");
			    	formObject.elements["vsl_cd"         ].value=vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value=vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value=vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value=ComGetObjValue(formObject.elements["t2_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value=ComGetObjValue(formObject.elements["t2_txt_pod"]);
			    	formObject.elements["sc_no"          ].value=ComGetObjValue(formObject.elements["t2_txt_sc_no"]);
					formObject.elements["bkg_cust_tp_cd" ].value=ComGetObjValue(formObject.elements["t2_slt_bkg_cust_tp_cd"]);
					formObject.elements["cust_cnt_cd"    ].value=ComGetObjValue(formObject.elements["t2_txt_cust_seq1"]);
					formObject.elements["cust_seq"       ].value=ComGetObjValue(formObject.elements["t2_txt_cust_seq2"]);
					formObject.elements["cust_nm"        ].value=ComGetObjValue(formObject.elements["t2_txt_cust_nm"]);
					formObject.elements["bl_no"          ].value=ComGetObjValue(formObject.elements["t2_txt_bl_no"]);
  					if ("OnBoard"==ComGetObjValue(formObject.elements["t2_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value=ComGetObjValue(formObject.elements["t2_txt_date_from2"]);
						formObject.elements["bl_obrd_dt_to"  ].value=ComGetObjValue(formObject.elements["t2_txt_date_to2"]);
						ComClearSeparator(formObject.elements["bl_obrd_dt_from"],"","-");
						ComClearSeparator(formObject.elements["bl_obrd_dt_to"],"","-");
						formObject.elements["obl_iss_dt_from"].value="";
						formObject.elements["obl_iss_dt_to"  ].value="";
  					} else if ("Issue"==ComGetObjValue(formObject.elements["t2_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value="";
						formObject.elements["bl_obrd_dt_to"  ].value="";
						formObject.elements["obl_iss_dt_from"].value=ComGetObjValue(formObject.elements["t2_txt_date_from2"]);
						formObject.elements["obl_iss_dt_to"  ].value=ComGetObjValue(formObject.elements["t2_txt_date_to2"]);
						ComClearSeparator(formObject.elements["obl_iss_dt_from"],"","-");
						ComClearSeparator(formObject.elements["obl_iss_dt_to"],"","-");
  					}
  					formObject.elements["fax_proc_sts_cd"].value=ComGetObjValue(formObject.elements["t2_slt_fax_proc_sts_cd"]);
  					formObject.elements["eml_proc_sts_cd"].value=ComGetObjValue(formObject.elements["t2_slt_eml_proc_sts_cd"]);
        		}
			    var sXml=sheetObject.GetSearchData("ESM_BKG_0218GS.do", FormQueryString(formObject)+"&"+ComGetPrefixParam(sheetObject.id));
			    ufRenderSheetSheet(sheetObject,sXml);
				ComEtcDataXmlToForm(sXml, formObject);
                break;
    		case IBDOWNEXCEL:
    			if (0<sheetObject.RowCount()) {
//    				sheetObject.SpeedDown2Excel(-1);
    				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(    				sheetObject), SheetDesign:1,Merge:1 });
    			} else {
    				ComShowCodeMessage("BKG00155");
    			}
    			break;
    		case "btn_fax_t1sht1":
		    	formObject.elements["f_cmd"].value=MULTI01;
				var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"rcvinfo",sheetObject.GetCellValue(arrRow[i], prefix+"fax_no"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t1_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t1_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t1_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t1_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t1_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : ("D"== ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "BL" : ("C"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])?"CW" :  "NN")),0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Fax");  //5336
				}
            	break;
            case "btn_fax_t2sht1":
		    	formObject.elements["f_cmd"].value=MULTI11;
		    	var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"rcvinfo",sheetObject.GetCellValue(arrRow[i], prefix+"fax_no"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t2_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t2_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t2_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t2_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t2_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN",0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Fax");  //5336
				}
            	break;
            case "btn_email_t1sht1":
		    	formObject.elements["f_cmd"].value=MULTI02;
				var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.SetCellValue(arrRow[i], prefix+"rcveml",sheetObject.GetCellValue(arrRow[i], prefix+"eml"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrdpdf",rdPdf,0);// 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t1_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t1_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t1_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t1_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t1_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "BL"  : ("C"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])?"CW":"NN")),0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;
            case "btn_email_t2sht1":
		    	formObject.elements["f_cmd"].value=MULTI12;
				var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.SetCellValue(arrRow[i], prefix+"rcveml",sheetObject.GetCellValue(arrRow[i], prefix+"eml"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrdpdf",rdPdf,0);// 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t2_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t2_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t2_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t2_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t2_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN",0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;
            case "btn_groupemail_t1sht1":
            	formObject.elements["f_cmd"].value=MULTI03;
				var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
//						ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.SetCellValue(arrRow[i], prefix+"rcveml",sheetObject.GetCellValue(arrRow[i], prefix+"eml"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrdpdf",rdPdf,0);// 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t1_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t1_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t1_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t1_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t1_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "BL" : ("C"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])?"CW" : "NN")),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"grp_flag","Y",0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;
            case "btn_groupemail_t2sht1":
		    	formObject.elements["f_cmd"].value=MULTI13;
		    	var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
//						ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.SetCellValue(arrRow[i], prefix+"syscd","BKG",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrd",rdPath,0);
						sheetObject.SetCellValue(arrRow[i], prefix+"batchflg","N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplparam",rdParam,0);
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.SetCellValue(arrRow[i], prefix+"rcveml",sheetObject.GetCellValue(arrRow[i], prefix+"eml"),0);
						sheetObject.SetCellValue(arrRow[i], prefix+"tmplmrdpdf",rdPdf,0);// 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.SetCellValue(arrRow[i], prefix+"itr","|$$|",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_all_flg",formObject.elements["t2_chk_opt1"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_clt_flg",formObject.elements["t2_chk_opt2"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_ppd_flg",formObject.elements["t2_chk_opt3"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_chg_flg",formObject.elements["t2_chk_opt4"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"frt_arr_flg",formObject.elements["t2_chk_opt5"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"hidd_opt",formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"ntc_knd_cd","W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN",0);
						sheetObject.SetCellValue(arrRow[i], prefix+"grp_flag","Y",0);
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
        		break;
            case "btn_assign_t1sht1":
				var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
				var bkg_no="";
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						bkg_no += sheetObject.GetCellValue(arrRow[i],sheetObject.id+"bkg_no")+'|';
					}
					if (0<bkg_no.indexOf("|")) bkg_no=bkg_no.substring(0,bkg_no.length-1);
				}
				var formObject4=document.form4;
				formObject4.elements["f_cmd" ].value=SEARCH03;
				formObject4.elements["bkg_no"].value=bkg_no;
				var sXml=sheetObject.GetSearchData("ESM_BKG_0218GS.do", FormQueryString(formObject4));
//				var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//	            xmlDoc.async="false";
//	            xmlDoc.loadXML(sXml);
	            var xmlDoc = ComGetXmlDoc(sXml);
	            if (xmlDoc == null) return;
	            var xmlRoot = xmlDoc.documentElement;
	            
                var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
        		var sep=dataNode.getAttribute("COLSEPARATOR");
	            var dataChildNodes=dataNode.childNodes;
		        var succFlg=false;
                if (0<dataChildNodes.length) {
                	var agentEmail,agentBkgNo;
					for (var i=0; i<dataChildNodes.length; i++) {
				          if (dataChildNodes[i].nodeType != 1) {
				              continue;
				            }
					    agentEmail=dataChildNodes[i].firstChild.nodeValue.split(sep)[1];
					    agentBkgNo=dataChildNodes[i].firstChild.nodeValue.split(sep)[2];
					    if (""!=agentEmail) {
							if (arrRow && 0<arrRow.length) {
								for (var j=0; j<arrRow.length; j++) {
									if (agentBkgNo==sheetObject.GetCellValue(arrRow[j],sheetObject.id+"bkg_no")) {
										sheetObject.SetCellValue(arrRow[j],sheetObject.id+"eml",agentEmail,0);
										break;
									}
								}
							}
							succFlg=true;
					    }
					}
					if (succFlg) {
						ComShowCodeMessage("COM130405","BKG Agent E-mail");  //{?msg1} was retrieved successfully.
					}
                }
    	        if (!succFlg) {
    	        	ComShowCodeMessage("COM130402","BKG Agent E-mail");  //{?msg1} doesn\'t exist
    	        }
		    	break;
        }
    }
    /**
    * register Tab Object to tabObjects array
    */
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab basic setting
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Outbound" , "");
                    InsertItem( "Inbound" , "");
                }
             break;
         }
    }
    /**
     * Tab click event
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
     /**
     * handling process for input validation
     */
    function validateForm(sheetObject,formObject,sAction) {
        with (formObject) {
            switch(sAction) {
    			case IBSEARCH:
    				var requiredFlag=false;
    				if(ComChkPeriod(formObject.t1_txt_date_from, formObject.t1_txt_date_to) <=	 0){
    					ComShowMessage("BKG Start Date must be later than BKG End Date.");
    					return false;
    				}
    				if (0==beforetab) {
    					var vvd=formObject.elements["t1_txt_vvd"];
    			    	var pol=formObject.elements["t1_txt_pol"];
    			    	var dt1=formObject.elements["t1_txt_date_from"];
    			    	var dt2=formObject.elements["t1_txt_date_to"];
    			    	var bkg=formObject.elements["t1_txt_bkg_no"];
    			    	var bl=formObject.elements["t1_txt_bl_no"];
    			    	if ((!ComIsEmpty(vvd) && !ComIsEmpty(pol)) ||
    			    		(!ComIsEmpty(dt1) && !ComIsEmpty(dt2) && !ComIsEmpty(pol)) ||
    			    		!ComIsEmpty(bkg) || !ComIsEmpty(bl)) {
    			    		requiredFlag=true;
        	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
        	                    ComShowCodeMessage("BKG00756","Duration","31Days")
        	                    dt1.focus();
        	                    return false;
        	                }
    			    	} else {
    			    		alert("※ mandatory item\n\n"
    			    			+"＊ VVD and POL  OR\n"
    			    			+"＊ (On Board or B/L Issue Date) and POL  OR        \n"
    			    			+"＊ Booking No.  OR\n"
    			    			+"＊ B/L No.");
        			    	requiredFlag=false;
    			    	}
    				} else if (1==beforetab) {
    					var eta1=formObject.elements["t2_txt_date_from"];
    					var eta2=formObject.elements["t2_txt_date_to"];
    					var dt1=formObject.elements["t2_txt_date_from2"];
    					var dt2=formObject.elements["t2_txt_date_to2"];
    					var pod=formObject.elements["t2_txt_pod"];
    					var vvd=formObject.elements["t2_txt_vvd"];
    					var bl=formObject.elements["t2_txt_bl_no"];
    			    	if ((((!ComIsEmpty(eta1) && !ComIsEmpty(eta2)) || (!ComIsEmpty(dt1) && !ComIsEmpty(dt2))) && !ComIsEmpty(pod)) ||
				    		(!ComIsEmpty(vvd) && !ComIsEmpty(pod)) ||
				    		!ComIsEmpty(bl)) {
				    		requiredFlag=true;
	    	                if (ComGetDaysBetween(eta1.value,eta2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    eta1.focus();
	    	                    return false;
	    	                }
	    	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    dt1.focus();
	    	                    return false;
	    	                }
				    	} else {
				    		alert("※ mandatory item\n\n"
    			    			+"＊ (ETA Date or (On Board or B/L Issue Date)) and POD  OR        \n"
    			    			+"＊ VVD and POD  OR\n"
    			    			+"＊ B/L No.");
        			    	requiredFlag=false;
    			    	}
    				}
    				if(!requiredFlag || !ComChkValid(formObject)) return false;
    				break;
    			case "btn_preview_t1sht1":
    			case "btn_preview_t2sht1":
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (50<sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
    					return false;
    				}
					break;
    			case "btn_manifest_t1sht1":
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (50<sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
    					return false;
    				}
    				break;
    			case "btn_groupemail_t1sht1":
    			case "btn_groupemail_t2sht1":
    			case "btn_EmailEdit_t1sht1":
    			case "btn_EmailEdit_t2sht1":
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var returnFlg=true;
    				var messageCd="";
    				var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						var shpr_cd=sheetObject.GetCellValue(arrRow[0],sheetObject.id+"shpr_cd");
						var email=sheetObject.GetCellValue(arrRow[0],sheetObject.id+"eml");
						var loop_shpr_cd;
						var loop_email;
						
						if(!BkgIsEmailAddr(email)){
			            	ComShowCodeMessage("BKG00366");
			            	sheetObject.SelectCell(arrRow[0], sheetObject.id+"eml");
			                return false;
			                break;
			            }
						
						for (var i=0; i<arrRow.length; i++) {
							loop_shpr_cd=sheetObject.GetCellValue(arrRow[i],sheetObject.id+"shpr_cd");
							loop_email=sheetObject.GetCellValue(arrRow[i],sheetObject.id+"eml");
							if(""==loop_email){
								messageCd="BKG00857"; 
								returnFlg=false;
								break;
							}
							if (""==loop_email || shpr_cd != loop_shpr_cd || email != loop_email) {
								
								if("t2sheet1"==sheetObject.id){
									messageCd="BKG02121"; // 동일한 cnee, ntfy 또는 e-mail이 아닙니다.
								}else if("t1sheet1"==sheetObject.id){
									messageCd="BKG00357";//동일한 shipper code 또는 e-mail이 아닙니다.
								}
								returnFlg=false;
								break;
							} 

						}
						if (!returnFlg && "t1sheet1"==sheetObject.id) { //Outbound 일 경우만 FF code 체크
							var ff_cd=sheetObject.GetCellValue(arrRow[0],sheetObject.id+"ff_cd");
							var loop_ff_cd;
							var loop_email;
							for (var i=0; i<arrRow.length; i++) {
								loop_ff_cd=sheetObject.GetCellValue(arrRow[i],sheetObject.id+"ff_cd")
								loop_email=sheetObject.GetCellValue(arrRow[i],sheetObject.id+"eml");
								if (''!=loop_ff_cd && ff_cd == loop_ff_cd && email == loop_email) {
									returnFlg=true;
								} else {
									returnFlg=false;
									break;
								}
							}
						}
						if (!returnFlg && ""!=messageCd) {
							ComShowCodeMessage(messageCd);
						}
						return returnFlg;
					}
					break;
    			case "btn_fax_t1sht1":
    			case "btn_fax_t2sht1":
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							if (ComIsNull(sheetObject.GetCellValue(arrRow[i],sheetObject.id+"fax_no"))) {
								ComShowCodeMessage("BKG00404","Fax","Fax Number");  //"{?msg1} is mandatory. Please enter {?msg2}."
								sheetObject.SelectCell(arrRow[i],sheetObject.id+"fax_no");
								return false;
							}
						}
					}
    				break;
    			case "btn_email_t1sht1":
    				var arrRow=ComFindText(sheetObjects[0], sheetObject.id+"slct_flg", 1);
    				if (arrRow && 0<arrRow.length) {
    					for (var i=0; i<arrRow.length; i++) {
    						if(!BkgIsEmailAddr(sheetObjects[0].GetCellValue(arrRow[i], sheetObject.id+"eml"))){
    			            	ComShowCodeMessage("BKG00366");
    			            	sheetObjects[0].SelectCell(arrRow[i], sheetObject.id+"eml");
    			                return false;
    			                break;
    			            }
    					}
    				}
    			case "btn_email_t2sht1":
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							if(!BkgIsEmailAddr(sheetObject.GetCellValue(arrRow[i], sheetObject.id+"eml"))){
//							if (ComIsNull(sheetObject.GetCellValue(arrRow[i],sheetObject.id+"eml"))) {
//								ComShowCodeMessage("BKG00404","E-mail Address","E-mail Address");  //"{?msg1} is mandatory. Please enter {?msg2}."
								ComShowCodeMessage("BKG00366");
								sheetObject.SelectCell(arrRow[i],sheetObject.id+"eml");
								return false;
							}
						}
					}
    				break;
    			default:
    				if (0==sheetObject.RowCount()) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
            }
        }
        return true;
    }
	function rdOpen(rdObject, formObject, viewType) {
		switch(viewType) {
			case "print":
		    	var sheetObject=sheetObjects[beforetab];
		    	var prefix=sheetObject.id;
				var arrRow=ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
//					ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
					ufSetRdParamMulti(formObject,arrRow);

// CM Print 작업용.by kimtk. 2016.10.25.					
	        		var appendReport = [];
//	        		var mrdPath = RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath;
//	        		var mrdParam = RDServer + rdParam;
	        		for(var i=0; i<appendMrdParam.length; i++){
		        		appendReport.push({mrdPath:appendMrdPath[i],mrdParam:appendMrdParam[i]});
	        		}
//	        		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
	        		directReportDownload(appendReport);
					
//					viewer.openFile(RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath, RDServer + rdParam, {timeout:3000});
//					viewer.print({isServerSide:true});//CMPrint();
					
				}
				break;
		}
	}
	/**
	 * mouse over
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function t1sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
		ufDisplayTooltip(sheetObject);
	}
	function t2sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
		ufDisplayTooltip(sheetObject);
	}
	function ufDisplayTooltip(sheetObject) {
		var m_row=sheetObject.MouseRow();
		var m_colNm=sheetObject.ColSaveName(sheetObject.MouseCol());
		if (0<m_row) {
			with (sheetObject) {
				if (m_colNm==id+"short_shpr_nm") {
				} else if (m_colNm==id+"fax_result" && "Failed"==GetCellValue(m_row,id+"fax_result")) {
//no support[check again]CLT MouseToolTipText=ComIsNull(GetCellValue(m_row,id+"fax_reason")) ? "no message":GetCellValue(m_row,id+"fax_reason");
				} else if (m_colNm==id+"eml_result" && "Failed"==GetCellValue(m_row,id+"eml_result")) {
//no support[check again]CLT MouseToolTipText=ComIsNull(GetCellValue(m_row,id+"eml_reason")) ? "no message":GetCellValue(m_row,id+"eml_reason");
				} else {
//no support[check again]CLT 					MouseToolTipText="";
				}
			}
		}
	}
	
	function t1sheet1_OnClick(sheetObject, Row, Col, Value, CellX, CellY, CellW, CellH) {
		if (sheetObject.GetCellProperty(Row, Col, "Type")!="Image") return;
		
		if (sheetObject.id+"fax_btn"==sheetObject.ColSaveName(Col) || sheetObject.id+"eml_btn"==sheetObject.ColSaveName(Col)) {
		 	sheetFaxEmlBtnClick(sheetObject, Row, Col);
		} else if (sheetObject.id+"fax_his_btn"==sheetObject.ColSaveName(Col) && ""!=sheetObject.GetCellValue(Row,sheetObject.id+"fax_result")) {
	 		sheetMultiBtnClick(sheetObject, Row, Col);
		} else if (sheetObject.id+"eml_his_btn"==sheetObject.ColSaveName(Col) && ""!=sheetObject.GetCellValue(Row,sheetObject.id+"eml_result")) {
	 		sheetMultiBtnClick(sheetObject, Row, Col);
		}
	}
	
    function t1sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with (sheetObject) {
        	SetColFontUnderline(sheetObject.id+"bkg_no",1);
            SetColFontColor(sheetObject.id+"bkg_no","#0000FF");
            
            // Image Setting 
            for(i=2 ; i<=LastRow(); i++) {
            	SetCellImage(i, sheetObject.id+"fax_btn", 0);
            	SetCellImage(i, sheetObject.id+"eml_btn", 0);
            	SetCellImage(i, sheetObject.id+"fax_his_btn", 2);
            	SetCellImage(i, sheetObject.id+"eml_his_btn", 2);
            }
            
            for(i=2 ; i<=LastRow(); i++) {
            	if ("Failed"==GetCellValue(i,id+"fax_result")) {
            		SetCellFontUnderline(i,id+"fax_result",1);
            	} else if ("Failed"==GetCellValue(i,id+"eml_result")) {
            		SetCellFontUnderline(i,id+"eml_result",1);
                }
            	
//            	if (""!=GetCellValue(i,id+"fax_result")) {
//            		PopupButtonImage(i, id+"fax_his_btn")=2;
//                } else {
//                    SetMergeCell(i,18,1,2);
//                }
//            	if (""!=GetCellValue(i,id+"eml_result")) {
//            		PopupButtonImage(i, id+"eml_his_btn")=2;
//                } else {
//                    SetMergeCell(i,22,1,2);
//                }
            }
    		if(document.form.t1_rdo_bl_tp_cd[0].checked){
    			sheetObject.SetColHidden(sheetObjects[0].id+"sgn_cpy_snd_flg",1);
    		}else if(document.form.t1_rdo_bl_tp_cd[1].checked){
    			sheetObject.SetColHidden(sheetObjects[0].id+"sgn_cpy_snd_flg",1);
    		}else if(document.form.t1_rdo_bl_tp_cd[2].checked){
    			sheetObject.SetColHidden(sheetObjects[0].id+"sgn_cpy_snd_flg",0);
    		}
        }
    }
    function t2sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with(sheetObject) {
            SetColFontUnderline(sheetObject.id+"bkg_no",1);
            SetColFontColor(sheetObject.id+"bkg_no","#0000FF");
            
            // Image Setting 
            for(i=2 ; i<=LastRow(); i++) {
            	SetCellImage(i, sheetObject.id+"fax_btn", 0);
            	SetCellImage(i, sheetObject.id+"eml_btn", 0);
            	SetCellImage(i, sheetObject.id+"fax_his_btn", 2);
            	SetCellImage(i, sheetObject.id+"eml_his_btn", 2);
            }
            
            for(i=2 ; i<=LastRow(); i++) {
            	if ("Failed"==GetCellValue(i,id+"fax_result")) {
            		SetCellFontUnderline(i,id+"fax_result",1);
            	} else if ("Failed"==GetCellValue(i,id+"eml_result")) {
            		SetCellFontUnderline(i,id+"eml_result",1);
                }
            	
//            	if (""!=GetCellValue(i,id+"fax_result")) {
//            		PopupButtonImage(i, id+"fax_his_btn")=2;
//                } else {
//                    SetMergeCell(i,18,1,2);  //fax result cell
//                }
//            	if (""!=GetCellValue(i,id+"eml_result")) {
//            		PopupButtonImage(i, id+"eml_his_btn")=2;
//                } else {
//                    SetMergeCell(i,22,1,2);  //email result cell
//                }
            }
        }
    }
	
    function t2sheet1_OnClick(sheetObject, Row, Col, Value, CellX, CellY, CellW, CellH) {
		if (sheetObject.GetCellProperty(Row, Col, "Type")!="Image") return;
		
		if (sheetObject.id+"fax_btn"==sheetObject.ColSaveName(Col) || sheetObject.id+"eml_btn"==sheetObject.ColSaveName(Col)) {
	 		sheetFaxEmlBtnClick(sheetObject, Row, Col);
		} else if (sheetObject.id+"fax_his_btn"==sheetObject.ColSaveName(Col) && ""!=sheetObject.GetCellValue(Row,sheetObject.id+"fax_result")) {
	 		sheetMultiBtnClick(sheetObject, Row, Col);
		} else if (sheetObject.id+"eml_his_btn"==sheetObject.ColSaveName(Col) && ""!=sheetObject.GetCellValue(Row,sheetObject.id+"eml_result")) {
	 		sheetMultiBtnClick(sheetObject, Row, Col);
		}
	}
    
    //BKG main popup
	function t1sheet1_OnDblClick(sheetObject, row, col) {
		openBkgMainPopup(sheetObject, row, col);
	}
	function t2sheet1_OnDblClick(sheetObject, row, col) {
		openBkgMainPopup(sheetObject, row, col);
	}
	function openBkgMainPopup(sheetObject, row, col) {
		if (sheetObject.id+"bkg_no"==sheetObject.ColSaveName(col)) {
			var bkg_no=sheetObject.GetCellValue(row, sheetObject.id+"bkg_no");
			if (""==bkg_no) {
				ComShowCodeMessage("BKG08017");  //BKG No. not exists
				return;
			}
			//freezing
//			ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+bkg_no+"&mainPage=false", "ESM_BKG_0079", 1024, 768, false);
			comBkgCallPopBkgDetail(bkg_no);   
		}
	}
	function sheetFaxEmlBtnClick(sheetObject, Row, Col) {
 		var prefix=sheetObject.id;
		var formObject=document.form;
		var param="";
		if ("Y"==sheetObject.GetCellValue(Row, prefix+"new_flg")) {
			sheetObject.SetCellValue(Row, prefix+"slct_flg","0",0);
			sheetObject.SetRowHidden(Row,1);
			sheetObject.SetRowStatus(Row,"D");
		} else {
			var Row=sheetObject.DataCopy();
			sheetObject.SetRowStatus(Row,"R");
			sheetObject.SetCellValue(Row, prefix+"fax_no","",0);
			sheetObject.SetCellValue(Row, prefix+"fax_btn","",0);
			sheetObject.SetCellValue(Row, prefix+"eml","",0);
			sheetObject.SetCellValue(Row, prefix+"eml_btn","",0);
			sheetObject.SetCellValue(Row, prefix+"fax_result","",0);
			sheetObject.SetCellValue(Row, prefix+"fax_date","",0);
			sheetObject.SetCellValue(Row, prefix+"eml_result","",0);
			sheetObject.SetCellValue(Row, prefix+"eml_date","",0);
			sheetObject.SetCellValue(Row, prefix+"frt_all_flg","",0);
			sheetObject.SetCellValue(Row, prefix+"frt_clt_flg","",0);
			sheetObject.SetCellValue(Row, prefix+"frt_ppd_flg","",0);
			sheetObject.SetCellValue(Row, prefix+"frt_chg_flg","",0);
			sheetObject.SetCellValue(Row, prefix+"frt_arr_flg","",0);
			sheetObject.SetCellValue(Row, prefix+"new_flg","Y",0);
			
			sheetObject.SetCellImage(Row, sheetObject.id+"fax_btn", 1);
			sheetObject.SetCellImage(Row, sheetObject.id+"eml_btn", 1);
			sheetObject.SetCellImage(Row, sheetObject.id+"fax_his_btn", 2);
			sheetObject.SetCellImage(Row, sheetObject.id+"eml_his_btn", 2);
		}
 	}
 	function sheetMultiBtnClick(sheetObject, Row, Col) {
 		var prefix=sheetObject.id;
		var formObject=document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo=sheetObject.GetCellValue(Row,prefix+"bkg_no");
 		if (0==beforetab) {
 			ntcKndCd="W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "BL" : ("C"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])?"CW" : "NN"));
 		} else if (1==beforetab) {
 			ntcKndCd="W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
 		}
 		if (prefix+"fax_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd="F";
 		} else if (prefix+"eml_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd="M";
 		}
		ComOpenWindowCenter("ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, "ESM_BKG_1071", 715, 500, false);
 	}
    //remark popup(0913)
//    function setRemark(remark) {
//    	var sheetObject=sheetObjects[beforetab];
//    	var prefix=sheetObject.id;
//		var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
//		if (arrRow && 0<arrRow.length) {
//			for (var i=0; i<arrRow.length; i++) {
//				sheetObject.SetCellValue(arrRow[i],prefix+"remark",remark,0);
//			}
//		}
//    }
    function ufRenderSheetSheet(sheetObject,sXml) {
       	var arrXml=sXml.split("|$$|");
   		sheetObject.RenderSheet(0);
   		sheetObject.LoadSearchData(arrXml[0],{Sync:0} );
   		sheetObject.RenderSheet(1);
    }
    //rd param setting
    function ufSetRdParam(formObject, rowIdx) {
    	var sheetObject=sheetObjects[beforetab];
    	var bkg_no="'"+sheetObject.GetCellValue(rowIdx,sheetObject.id+"bkg_no")+"'";
	    ufSetRdParamCommon(formObject, rowIdx, bkg_no);
    }
    //rd privew setting.
    function ufSetRdParamMulti(formObject, arrRow) {
    	var sheetObject=sheetObjects[beforetab];
    	var mBkgNo = "";
		var pdf_file_name="";
		var strFacePath = "";
		appendMrdPath = [];
		appendMrdParam = [];
    	if (arrRow && 0<arrRow.length) {
    		for (var i=0; i<arrRow.length; i++) {
    			var bl_tp_cd = ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]);
    			var form_type="D"==bl_tp_cd ? (1==beforetab ? "2" : "7") : ("W"==bl_tp_cd ? "5" : "2");
    			var form_dataOnly="N";
    			var form_manifest="N";
    			var form_usrId=formObject.elements["strUsr_id"].value;
    			var form_hiddeData=formObject.elements["t"+(beforetab+1)+"_chk_opt_hidden"].checked ? "Y":"N";
    			var form_level="";
    			var form_remark="";
    			var bkg_no=sheetObject.GetCellValue(arrRow[i],sheetObject.id+"bkg_no");
    			if(i==0)	mBkgNo = bkg_no;
    			if (formObject.elements["t"+(beforetab+1)+"_chk_opt1"].checked) form_level += "1,";
    			if (formObject.elements["t"+(beforetab+1)+"_chk_opt2"].checked) form_level += "5,";
    			if (formObject.elements["t"+(beforetab+1)+"_chk_opt3"].checked) form_level += "4,";
    			if (formObject.elements["t"+(beforetab+1)+"_chk_opt4"].checked) form_level += "6,";
    			if (formObject.elements["t"+(beforetab+1)+"_chk_opt5"].checked) form_level += "3,";
    			if (0<form_level.indexOf(",")) form_level=form_level.substring(0,form_level.length-1);
    			form_level=0<form_level.length ? form_level : "1";
    			form_remark=encodeRemark(sheetObject.GetCellValue(arrRow[i],sheetObject.id+"remark"));
    			rdParam="/rv";
    			rdParam += " form_bkgNo[('"+bkg_no+"')]";
    			rdParam += " form_type["+form_type+"]";
    			rdParam += " form_dataOnly["+form_dataOnly+"]";
    			rdParam += " form_manifest["+form_manifest+"]";
    			rdParam += " form_usrId["+form_usrId+"]";
    			rdParam += " form_hiddeData["+form_hiddeData+"]";
    			rdParam += " form_level[("+form_level+")]";
    			rdParam += " form_remark["+form_remark+"]";
    			rdParam += " form_Cntr[1]";
    			rdParam += " form_mainOnly[N]";
    			rdParam += " form_CorrNo[]"; // form_CorrNo
    			rdParam += " form_his_cntr[BKG_CONTAINER]"; // form_his_cntr
    			rdParam += " form_his_bkg[BKG_BOOKING]"; // form_his_bkg
    			rdParam += " form_his_mkd[BKG_BL_MK_DESC]"; // form_his_mkd
    			rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]"; // form_his_xpt
    			rdParam += " form_his_bl[BKG_BL_DOC]"; // form_his_bl
    			rdParam += " isEncode[Y]";
    			rdParam += " form_rqst_via_cd[]"; //form_rqst_via_cd
    			rdParam += " form_his_bl_mkd[BKG_BL_ISS]"; //form_his_bl_mkd
    			rdParam += " form_path[" + getFileDownPath() + "] "; //form_path
    			rdParam += " form_esig[] "; //form_esig
    			var formCpyEsig =  sheetObject.GetCellValue(arrRow[i],sheetObject.id+"sgn_cpy_snd_flg");
    			if(formCpyEsig == 1){
    				rdParam += " form_cpy_esig[Y] "; //form_cpy_esig			
    			}else{
    				rdParam += " form_cpy_esig[N] "; //form_cpy_esig
    			}
    			rdParam += " form_knt_flg[] "; //form_knt_flg
    			rdParam += " form_count[] "; //form_count
    			rdParam += " /rp []";
    			rdParam += " /riprnmargin ";// /rwait /rmatchprndrv[3]";
    			rdPath = "ESM_BKG_0109_OBL_A4.mrd";
    			if ("ESM_BKG_0109_OBL_A4.mrd"==rdPath && -1 != sheetObject.GetCellValue(arrRow[i],sheetObject.id+"por_cd") && 0==sheetObject.GetCellValue(arrRow[i],sheetObject.id+"por_cd").indexOf("US")) {
    				rdPath="ESM_BKG_0109_OBL_LETTER.mrd";
    			}
    			
        		var mrdPath = RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath;
        		var mrdParam = RDServer + rdParam;
    			appendMrdPath.push(mrdPath);
    			appendMrdParam.push(mrdParam);
    		}
    		var bkg_mrd_path = document.getElementById("bkg_mrd_path");
    		bkg_mrd_path.innerHTML ="";
    		for(var i=0; i< appendMrdPath.length; i++){
    			bkg_mrd_path.innerHTML += "<input type=\"hidden\" name=\"bkg_mrdPath\" value=\""+appendMrdPath[i]+"\" >";
    		}
    		var bkg_mrd_param = document.getElementById("bkg_mrd_param");
    		bkg_mrd_param.innerHTML ="";
    		for(var i=0; i< appendMrdParam.length; i++){
    			bkg_mrd_param.innerHTML += "<input type=\"hidden\" name=\"bkg_mrd_param\" value=\""+appendMrdParam[i]+"\" >";
    		}
    	}
    	pdf_file_name = getPdfFileName(formObject, bkg_no);
		rdPdf="D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "Draft_"+pdf_file_name+".pdf":("C"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "Copy Seaway Bill_"+pdf_file_name+".pdf" : "WayBill_"+pdf_file_name+".pdf");

    }
    function getPdfFileName(formObject, bkg_no){
    	var reValue = bkg_no.replace(/'/g,"");
    	return reValue;
    }
    
    //rd param setting(grp Email)
    function ufSetRdParamByBkgNos(formObject, rowIdx, arrRow) {
    	var sheetObject=sheetObjects[beforetab];
		var bkg_no="";
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				bkg_no += "'"+sheetObject.GetCellValue(arrRow[i],sheetObject.id+"bkg_no")+"',";
			}
			if (0<bkg_no.lastIndexOf(",")) bkg_no=bkg_no.substring(0,bkg_no.length-1);
		    ufSetRdParamCommon(formObject, rowIdx, bkg_no);
		}
    }
    //rd param setting
    function ufSetRdParamCommon(formObject, rowIdx, bkg_no) {
    	var sheetObject=sheetObjects[beforetab];
//	    var form_type="D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) ? (1==beforetab ? "2" : "7"):"5";
    	var bl_tp_cd = ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]);
    	var form_type="D"==bl_tp_cd ? (1==beforetab ? "2" : "7") : ("W"==bl_tp_cd ? "5" : "2");
		var form_dataOnly="N";
		var form_manifest="N";
		var form_usrId=formObject.elements["strUsr_id"].value;
		var form_hiddeData=formObject.elements["t"+(beforetab+1)+"_chk_opt_hidden"].checked ? "Y":"N";
		var form_level="";
		var form_remark="";
		var pdf_file_name="";
		if (1<bkg_no.split(",").length) {
			pdf_file_name=bkg_no.replace(/'/g,"").substring(0,bkg_no.indexOf(",")-2)+"_"+bkg_no.split(",").length;
		} else {
			pdf_file_name=bkg_no.replace(/'/g,"");
		}
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt1"].checked) form_level += "1,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt2"].checked) form_level += "5,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt3"].checked) form_level += "4,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt4"].checked) form_level += "6,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt5"].checked) form_level += "3,";
		if (0<form_level.indexOf(",")) form_level=form_level.substring(0,form_level.length-1);
		form_level=0<form_level.length ? form_level : "1";
		form_remark=encodeRemark(sheetObject.GetCellValue(rowIdx,sheetObject.id+"remark"));
		rdParam="/rv";
		rdParam += " form_bkgNo[("+bkg_no+")]";
		rdParam += " form_type["+form_type+"]";
		rdParam += " form_dataOnly["+form_dataOnly+"]";
		rdParam += " form_manifest["+form_manifest+"]";
		rdParam += " form_usrId["+form_usrId+"]";
		rdParam += " form_hiddeData["+form_hiddeData+"]";
		rdParam += " form_level[("+form_level+")]";
		rdParam += " form_remark["+form_remark+"]";
		rdParam += " form_Cntr[1]";
		rdParam += " form_mainOnly[N]";
		rdParam += " form_CorrNo[]"; // form_CorrNo
		rdParam += " form_his_cntr[BKG_CONTAINER]"; // form_his_cntr
		rdParam += " form_his_bkg[BKG_BOOKING]"; // form_his_bkg
		rdParam += " form_his_mkd[BKG_BL_MK_DESC]"; // form_his_mkd
		rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]"; // form_his_xpt
		rdParam += " form_his_bl[BKG_BL_DOC]"; // form_his_bl
		rdParam += " isEncode[Y]";
		rdParam += " form_rqst_via_cd[]"; //form_rqst_via_cd
		rdParam += " form_his_bl_mkd[BKG_BL_ISS]"; //form_his_bl_mkd
		rdParam += " form_path[" + getFileDownPath() + "] "; //form_path
		rdParam += " form_esig[] "; //form_esig
		var formCpyEsig =  sheetObject.GetCellValue(rowIdx,sheetObject.id+"sgn_cpy_snd_flg");
		if(formCpyEsig == 1){
			rdParam += " form_cpy_esig[Y] "; //form_cpy_esig			
		}else{
			rdParam += " form_cpy_esig[N] "; //form_cpy_esig
		}
		rdParam += " form_knt_flg[] "; //form_knt_flg
		rdParam += " form_count[] "; //form_count
		rdParam += " /rp []";
		rdParam += " /riprnmargin";// /rwait /rmatchprndrv[3]";
		rdPath = "ESM_BKG_0109_OBL_A4.mrd";
		if ("ESM_BKG_0109_OBL_A4.mrd"==rdPath && -1 != sheetObject.GetCellValue(rowIdx,sheetObject.id+"por_cd") && 0==sheetObject.GetCellValue(rowIdx,sheetObject.id+"por_cd").indexOf("US")) {
			rdPath="ESM_BKG_0109_OBL_LETTER.mrd";
		}
		formObject.com_mrdPath.value=rdPath;
		rdPdf="D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "Draft_"+pdf_file_name+".pdf":("C"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "Copy Seaway Bill_"+pdf_file_name+".pdf" : "WayBill_"+pdf_file_name+".pdf");
		
    }
    // fax, email setting
    function ufFaxEmailSend(sheetObject, formObject, strGubun) {
		//ComOpenWait(true);
    	var param = FormQueryString(formObject) + "&" + sheetObject.GetSaveString(false,true,1);
    	var sXml=sheetObject.GetSaveData("ESM_BKG_0218GS.do", FormQueryString(formObject) + "&" + sheetObject.GetSaveString(false,true,1));
		//ComOpenWait(false);
		if ("ERROR"==sXml.substring(1,6)){
			//alert(ComResultMessage(sXml).split('<||>').join('\n'));
			ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
		} else {
			ComSetObjValue(formObject.elements["edt_ntc_knd_cd" ],"");
			ComSetObjValue(formObject.elements["edt_bkg_no_list"],"");
			ComSetObjValue(formObject.elements["edt_to_eml"     ],"");
			ComSetObjValue(formObject.elements["edt_cc_eml"     ],"");
			ComSetObjValue(formObject.elements["edt_from_eml"   ],"");
			ComSetObjValue(formObject.elements["edt_subject"    ],"");
			ComSetObjValue(formObject.elements["edt_contents"   ],"");
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if ("S"==State) {
				ComShowCodeMessage("BKG06082");
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				return;
			}
		}
	}
   
    
    
    
    
    function getParameter(p) {	
	  if (p) r=location.search.match(new RegExp("[&?]"+p+"=(.*?)(&|$)"));
	  return r&&r[1]?r[1]:null;
	  
	}
    //edit fax/email popup
    function getCOM_Fax_Email_POPUP(rowArray) {
    	if (rowArray && 0<rowArray.length) {
	    	var faxno=rowArray[0].fax;
	        var email=rowArray[0].email;
	    	var sheetObject=sheetObjects[beforetab];
	    	var prefix=sheetObject.id;
			var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
 					sheetObject.SetCellValue(arrRow[i],prefix+"fax_no",faxno,0);
 					sheetObject.SetCellValue(arrRow[i],prefix+"eml",email,0);
				}
			}
    	}
    }
    //remark encoding
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
	
	function inb_change_radio() {
		if (!validateForm2(sheetObjects[1],document.form,IBSEARCH)) return false;
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}

	function out_change_radio() {
//		if(document.form.t1_rdo_bl_tp_cd[0].checked){
//			document.form.c_sign.checked = false;
//			document.form.c_sign.disabled = true;
//		}else if(document.form.t1_rdo_bl_tp_cd[1].checked){
//			document.form.c_sign.disabled = false;
//			document.form.c_sign.checked = true;
//		}else if(document.form.t1_rdo_bl_tp_cd[2].checked){
//			document.form.c_sign.disabled = false;
//			document.form.c_sign.checked = true;
//		}
//		setSignChk();
		if (!validateForm2(sheetObjects[0],document.form,IBSEARCH)) return false;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
//	function setSignChk(){
//		var formObj = document.form;
//		if(formObj.c_sign.checked){
//			sheetObjects[0].SetColHidden(sheetObjects[0].id+"esig_flg",0);
//		}else if(!formObj.c_sign.checked){
//			sheetObjects[0].SetColHidden(sheetObjects[0].id+"esig_flg",1);
//		}
//	}
	
	function validateForm2(sheetObject,formObject,sAction) {
        with (formObject) {
            switch(sAction) {
    			case IBSEARCH:
    				var requiredFlag=false;
    				if(ComChkPeriod(formObject.t1_txt_date_from, formObject.t1_txt_date_to) <=	 0){
    					ComShowMessage("BKG Start Date must be later than BKG End Date.");
    					return false;
    				}
    				if (0==beforetab) {
    					var vvd=formObject.elements["t1_txt_vvd"];
    			    	var pol=formObject.elements["t1_txt_pol"];
    			    	var dt1=formObject.elements["t1_txt_date_from"];
    			    	var dt2=formObject.elements["t1_txt_date_to"];
    			    	var bkg=formObject.elements["t1_txt_bkg_no"];
    			    	var bl=formObject.elements["t1_txt_bl_no"];
    			    	if ((!ComIsEmpty(vvd) && !ComIsEmpty(pol)) ||
    			    		(!ComIsEmpty(dt1) && !ComIsEmpty(dt2) && !ComIsEmpty(pol)) ||
    			    		!ComIsEmpty(bkg) || !ComIsEmpty(bl)) {
    			    		requiredFlag=true;
        	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
        	                    ComShowCodeMessage("BKG00756","Duration","31Days")
        	                    dt1.focus();
        	                    return false;
        	                }
    			    	} else {
//    			    		alert("※ mandatory item\n\n"
//    			    			+"＊ VVD and POL  OR\n"
//    			    			+"＊ (On Board or B/L Issue Date) and POL  OR        \n"
//    			    			+"＊ Booking No.  OR\n"
//    			    			+"＊ B/L No.");
        			    	requiredFlag=false;
    			    	}
    				} else if (1==beforetab) {
    					var eta1=formObject.elements["t2_txt_date_from"];
    					var eta2=formObject.elements["t2_txt_date_to"];
    					var dt1=formObject.elements["t2_txt_date_from2"];
    					var dt2=formObject.elements["t2_txt_date_to2"];
    					var pod=formObject.elements["t2_txt_pod"];
    					var vvd=formObject.elements["t2_txt_vvd"];
    					var bl=formObject.elements["t2_txt_bl_no"];
    			    	if ((((!ComIsEmpty(eta1) && !ComIsEmpty(eta2)) || (!ComIsEmpty(dt1) && !ComIsEmpty(dt2))) && !ComIsEmpty(pod)) ||
				    		(!ComIsEmpty(vvd) && !ComIsEmpty(pod)) ||
				    		!ComIsEmpty(bl)) {
				    		requiredFlag=true;
	    	                if (ComGetDaysBetween(eta1.value,eta2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    eta1.focus();
	    	                    return false;
	    	                }
	    	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    dt1.focus();
	    	                    return false;
	    	                }
				    	} else {
//				    		alert("※ mandatory item\n\n"
//    			    			+"＊ (ETA Date or (On Board or B/L Issue Date)) and POD  OR        \n"
//    			    			+"＊ VVD and POD  OR\n"
//    			    			+"＊ B/L No.");
        			    	requiredFlag=false;
    			    	}
    				}
    				if(!requiredFlag || !ComChkValid(formObject)) return false;
    				break;
            }
        }
        return true;
    }
	
	//remark 
	function replaceRemark(str){
		var re_str = str.replace(/(\r\n|\n|\r)/g,'\n');
		
		if(re_str.indexOf("\n", re_str.length - "\n".length) != -1){	//last character '\n'
			re_str = re_str.substring(0,re_str.length - "\n".length); 
		}
		return re_str;
	}
    function onCheck(obj)
    {
    	if(obj.name=="t1_chk_opt1"){
    		document.form.t1_chk_opt2.checked = false;
    		document.form.t1_chk_opt3.checked = false;
    		document.form.t1_chk_opt4.checked = false;
    		document.form.t1_chk_opt5.checked = false;
    		document.form.t1_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t1_chk_opt2"){
    		document.form.t1_chk_opt1.checked = false;
    		document.form.t1_chk_opt3.checked = false;
    		document.form.t1_chk_opt4.checked = false;
    		document.form.t1_chk_opt5.checked = false;
    		document.form.t1_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t1_chk_opt3"){
    		document.form.t1_chk_opt1.checked = false;
    		document.form.t1_chk_opt2.checked = false;
    		document.form.t1_chk_opt4.checked = false;
    		document.form.t1_chk_opt5.checked = false;
    		document.form.t1_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t1_chk_opt4"){
    		document.form.t1_chk_opt1.checked = false;
    		document.form.t1_chk_opt2.checked = false;
    		document.form.t1_chk_opt3.checked = false;
    		document.form.t1_chk_opt5.checked = false;
    		document.form.t1_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t1_chk_opt5"){
    		document.form.t1_chk_opt1.checked = false;
    		document.form.t1_chk_opt2.checked = false;
    		document.form.t1_chk_opt3.checked = false;
    		document.form.t1_chk_opt4.checked = false;
    		document.form.t1_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t1_chk_opt_hidden"){
    		document.form.t1_chk_opt1.checked = false;
    		document.form.t1_chk_opt2.checked = false;
    		document.form.t1_chk_opt3.checked = false;
    		document.form.t1_chk_opt4.checked = false;
    		document.form.t1_chk_opt5.checked = false;
    	}else if(obj.name=="t2_chk_opt1"){
    		document.form.t2_chk_opt2.checked = false;
    		document.form.t2_chk_opt3.checked = false;
    		document.form.t2_chk_opt4.checked = false;
    		document.form.t2_chk_opt5.checked = false;
    		document.form.t2_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t2_chk_opt2"){
    		document.form.t2_chk_opt1.checked = false;
    		document.form.t2_chk_opt3.checked = false;
    		document.form.t2_chk_opt4.checked = false;
    		document.form.t2_chk_opt5.checked = false;
    		document.form.t2_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t2_chk_opt3"){
    		document.form.t2_chk_opt1.checked = false;
    		document.form.t2_chk_opt2.checked = false;
    		document.form.t2_chk_opt4.checked = false;
    		document.form.t2_chk_opt5.checked = false;
    		document.form.t2_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t2_chk_opt4"){
    		document.form.t2_chk_opt1.checked = false;
    		document.form.t2_chk_opt2.checked = false;
    		document.form.t2_chk_opt3.checked = false;
    		document.form.t2_chk_opt5.checked = false;
    		document.form.t2_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t2_chk_opt5"){
    		document.form.t2_chk_opt1.checked = false;
    		document.form.t2_chk_opt2.checked = false;
    		document.form.t2_chk_opt3.checked = false;
    		document.form.t2_chk_opt4.checked = false;
    		document.form.t2_chk_opt_hidden.checked = false;
    	}else if(obj.name=="t2_chk_opt_hidden"){
    		document.form.t2_chk_opt1.checked = false;
    		document.form.t2_chk_opt2.checked = false;
    		document.form.t2_chk_opt3.checked = false;
    		document.form.t2_chk_opt4.checked = false;
    		document.form.t2_chk_opt5.checked = false;
    	}
    }