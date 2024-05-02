/*=========================================================
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0099.js
*@FileTitle  :  Booking Split 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13

=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0099 : business script for esm_bkg_0099
     */
    function esm_bkg_0099() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	/* developer job	*/
	// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
var strSheetTitle1=" |BKG|B/L No.|T/VVD||Weight|Weight|Package|Package|Measure|Measure|AS|";
var strSheetTitle2=" ||BKG|B/L No.|T/VVD||Weight|Weight|Package|Package|Measure|Measure|AS||P/C";
var strSheetTitle3="|TS|Q'ty ";
var strSheetTitle4="|CNTR|TS|ST|AS";
var strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
var asCodeList="";
var asTextList="";
var orgSplit=""; 
var dgSelectFlg="N";
var rfSelectFlg="N";
var akSelectFlg="N";

// sheet Json 정보 임시 저장 변수
var sheetJson_1 = "";
var sheetJson_2 = "";
var sheetJson_3 = "";
var sheetJson_4 = "";
var sheetJson_5 = "";
var sheetJson_6 = "";

// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
    function processButtonClick(){			 
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var obj = event.target || ComGetEvent();
    		   if ($(obj).prop('disabled')) {
    		 return;
    		 }

    		var srcName=ComGetEvent("name");
			 if(srcName != "btn_split_pop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}	
            switch(srcName) {
				case "btn_retrieve":										
					initData();					
					if(ComIsEmpty(formObject.bkg_no)){
						ComShowCodeMessage("BKG08019");
						return;
					}
					orgSplit="";
					sheetObjects[2] = sheetObjects[2].Reset();
					sheetObjects[3] = sheetObjects[3].Reset();
					for(i=0;i<sheetObjects.length;i++){
			            ComConfigSheet (sheetObjects[i] );
			            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
			            ComEndConfigSheet(sheetObjects[i]);
			        }
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);					
					
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_save2");
					ComSetObjValue(formObject.txtProgress, "");
					
				break;
				case "btn_split_pop":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
				break;
				case "btn_save":
					if ( validateForm (sheetObjects[0],formObject,IBSAVE)){
						
						
					    if (ComGetObjValue(formObject.bdr_flag)=="Y"){
							 comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObject.bkg_no), "C"); 
							 // CallBack 에서 IBSAVE 함
//							 if(!ComIsNull(formObject.caRsnCd.value) && formObject.caRsnCd.value!=null 
//									 && formObject.caRsnCd.value!="" && formObject.caRsnCd.value!='null'){
//								 doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
//							 }
					    } else {
					    	// If the vvd close bkg check processing changes
					    	if(formObject.bkg_close_flg.value == "Y"){
					    		var firstVvd=sheetObjects[0].GetCellValue(1, prefix1+"first_vvd");
					    		formObject.vvd_change_flg.value="N";
					    		if(firstVvd == sheetObjects[0].GetCellValue(1, prefix1+"tvvd")){
						    		for(var i=1;i<sheetObjects[1].RowCount()+ 1;i++){
						    			if(firstVvd != sheetObjects[1].GetCellValue(i, prefix2+"tvvd")){
						    				formObject.vvd_change_flg.value="Y";
						    				break;
						    			}
						    		}
					    		}
					    		if(formObject.vvd_change_flg.value == "Y"){
					    			// 취소면 중지
									if(!ComShowCodeConfirm("BKG00312",firstVvd)){
										return false;
									}
					    		}					    		
					    	}
					    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
					    	if(formObject.bkg_cbf_flg.value == "Y"){
								if(!ComShowCodeConfirm("BKG02069")){
									formObject.bkg_cbf_flg.value="N";
									break;
								}							
					    	}
					    	doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						}	
					}					
					break;
					
				case "btn_save2":
					if (validateForm(sheetObjects[0],formObject,IBSAVE)){
					    if (ComGetObjValue(formObject.bdr_flag)=="Y"){
							 comBkgCallPop0708('setCAReasonMultiCallBack', ComGetObjValue(formObject.bkg_no), "C");
					    } else {
					    	// close된 bkg이면 vvd 변경시 확인 처리
					    	if(formObject.bkg_close_flg.value == "Y"){
					    		var firstVvd = sheetObjects[0].GetCellValue(1, prefix1+"first_vvd");
					    		formObject.vvd_change_flg.value = "N";
					    		if(firstVvd == sheetObjects[0].GetCellValue(1, prefix1+"tvvd")){
						    		for(var i=1;i<sheetObjects[1].RowCount() + 1;i++){
						    			if(firstVvd != sheetObjects[1].GetCellValue(i, prefix2+"tvvd")){
						    				formObject.vvd_change_flg.value = "Y";
						    				break;
						    			}
						    		}
					    		}
					    		if(formObject.vvd_change_flg.value == "Y"){
					    			// 취소면 중지
									if(!ComShowCodeConfirm("BKG00312",firstVvd)){
										return false;
									}
					    		}					    		
					    	}
					    	
					    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
					    	if(formObject.bkg_cbf_flg.value == "Y"){
								if(!ComShowCodeConfirm("BKG02069")){
									formObject.bkg_cbf_flg.value = "N";
									break;
								}							
					    	}					    
					    	
				    		doActionIBSheet(sheetObjects[0],document.form,COMMAND05);		
						}				
					}					
				break;					
				case "btn_dg":
					if (!CheckPopValidate(sheetObjects[3],"btn_dg",formObject)) return;
					if(ComGetObjValue(formObject.dg).toUpperCase() != "N"){
						//if (formObject.dgCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						var param="?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//							param +="&splitCntrSplitNo="+ComGetObjValue(formObject.dgCntrSplitNo);
							param +="&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
							param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
							param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
							param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
							param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
							param+="&pgmNo=ESM_BKG_0709";
						ComOpenPopup("/opuscntr/ESM_BKG_0709.do"+param, 600, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					}
				break;
				case "btn_rf": 
					if (!CheckPopValidate(sheetObjects[3],"btn_rf",formObject)) return;
					if(ComGetObjValue(formObject.rf).toUpperCase() != "N"){
						//if (formObject.rfCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						var param="?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.rfCntrSplitNo);
						param +="&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
						param+="&pgmNo=ESM_BKG_0710";
//						ComOpenPopup("/opuscntr/ESM_BKG_0710.do"+param, 600, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						ComOpenPopup("/opuscntr/ESM_BKG_0710.do"+param, 700, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					}
				break;
				case "btn_ak":
					if (!CheckPopValidate(sheetObjects[3],"btn_ak",formObject)) return;
					if(ComGetObjValue(formObject.ak).toUpperCase() != "N"){
						//if (formObject.akCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						setQtyCntrVar(formObject);
						var param="?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.akCntrSplitNo);
						param +="&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
						param+="&pgmNo=ESM_BKG_0715";
						ComOpenPopup("/opuscntr/ESM_BKG_0715.do"+param, 800, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					}
				break;
				case "btn_bb":
					if (!CheckPopValidate(sheetObjects[3],"btn_bb",formObject)) return;
					if(ComGetObjValue(formObject.bb).toUpperCase() != "N"){
						//if (formObject.bbCntrSplitNo.value.length<1){
							ComSetObjValue(formObject.validateSplitNo,CntrCheck(sheetObjects[3],prefix4+"cntr_no"));  
						//}
						var param="?bkg_no="+ComGetObjValue(formObject.bkg_no)+"&splitReason="+ComGetObjValue(formObject.splitreason);
//						param +="&splitCntrSplitNo="+ComGetObjValue(formObject.bbCntrSplitNo);
						param +="&lastSplitNo="+ComGetObjValue(formObject.lastSplitNo);
						param +="&validateSplitNo="+ComGetObjValue(formObject.validateSplitNo);
						param +="&cntrExists="+ComGetObjValue(formObject.cntrExists);
						param +="&cntrPopExists="+ComGetObjValue(formObject.cntrPopExists);
						param +="&splitCnt="+(ComParseInt(formObject.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
						param+="&pgmNo=ESM_BKG_0716";
						ComOpenPopup("/opuscntr/ESM_BKG_0716.do"+param, 800, 510, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					}
				break;
				case "btn_auto":
					sheetObjects[2] = sheetObjects[2].Reset();
					sheetObjects[3] = sheetObjects[3].Reset();
					for(i=0;i<sheetObjects.length;i++){
			            ComConfigSheet (sheetObjects[i] );
			            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
			            ComEndConfigSheet(sheetObjects[i]);
			        }
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					
					if (ComIsEmpty(formObject.splitcount)) return;
					if (ComIsEmpty(sheetObject1.GetCellValue(1,prefix1+"bkg_no"))) return;
				    if (ComGetObjValue(formObject.splitreason)=="C" &&ComParseInt(formObject.splitcount)==1) return; 
				    formObject.splitcount.value = splitTotalControl(ComGetObjValue(formObject.splitreason).toUpperCase(), ComParseInt(formObject.splitcount), ComParseInt(formObject.lastSplitNo));
				    
				    if(validateForm(sheetObject1,formObject,COMMAND01)){ 
						var splitCnt=0;
						splitCnt=ComParseInt(formObject.splitcount)-1;
						sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						autoVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						btnSpecialCargo(formObject);
					}
										
				break;
				case "btn_manual":
					
					sheetObjects[2] = sheetObjects[2].Reset();
					sheetObjects[3] = sheetObjects[3].Reset();
					for(i=0;i<sheetObjects.length;i++){
			            ComConfigSheet (sheetObjects[i] );
			            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
			            ComEndConfigSheet(sheetObjects[i]);
			        }
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					
					if (ComIsEmpty(formObject.splitcount)) return;
					if (ComGetObjValue(formObject.splitreason)=="C" &&ComParseInt(formObject.splitcount)==1) return; 
					
					formObject.splitcount.value = splitTotalControl(ComGetObjValue(formObject.splitreason).toUpperCase(), ComParseInt(formObject.splitcount), ComParseInt(formObject.lastSplitNo));
					
					if(validateForm(sheetObject1,formObject,COMMAND01)){
						var splitCnt=0;
						splitCnt=ComParseInt(formObject.splitcount)-1;
						sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						manualVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(formObject.lastSplitNo),splitCnt);
						btnSpecialCargo(formObject);
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
    function loadPage(asCode,asText) {
		asCodeList=" |"+asCode;
		asTextList=" |"+asText;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//iframe 
		CofigIframe();
		sheetObjects[2].SetExtendLastCol(0);
		sheetObjects[3].SetExtendLastCol(0);
		ComBtnDisable("btn_dg");
		ComBtnDisable("btn_rf");
		ComBtnDisable("btn_ak");
		ComBtnDisable("btn_bb");

		ComGetObject("btn_save2").style.display="inline"
		ComBtnDisable("btn_save");
		ComBtnEnable("btn_save2");
		/*if (!ComIsEmpty(document.form.bkg_no)){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}*/
		//axon_event.addListenerForm('keyup', 'bkg0099_keyup', document.form);
//		axon_event.addListenerFormat('keypress','bkg0099_keypress',document.form);
		axon_event.addListenerForm('click', 'bkg0099_click', document.form); 		
	    ComSetFocus(document.form.bkg_no);
	    
		if (!ComIsEmpty(document.form.bkg_no)){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
		}	
		
		sheetObjects[3].SetSheetHeight(sheetObjects[2].GetSheetHeight());
    }
    function bkg0099_click(){
    	obj=ComGetEvent();
		formObject=document.form;
		if (obj.name!="btn_auto" && obj.name!="btn_manual" && obj.name !="splitreason") return;
		 switch(obj.value){ 
	        case "C": 
	        	 sheetObjects[0].SetColHidden(prefix1+"adv_shtg_cd",1);sheetObjects[0].FitColWidth();
			     sheetObjects[1].SetColHidden(prefix2+"adv_shtg_cd",1);sheetObjects[1].FitColWidth();
				 sheetObjects[3].SetColHidden(prefix4+"adv_shtg_cd",1);sheetObjects[3].FitColWidth();
				 ComSetObjValue(formObject.lastSplitNo,formObject.custSplitNo.value);
				 //sheetObjects[0].Enable = true;
				 ComGetObject("btn_save").style.display="none"
				 ComGetObject("btn_save2").style.display="inline"
				 ComBtnDisable("btn_save");
				 ComBtnEnable("btn_save2");
				 
	            break;	 
			 case "M": 
				 sheetObjects[0].SetColHidden(prefix1+"adv_shtg_cd",0);sheetObjects[0].FitColWidth();
			     sheetObjects[1].SetColHidden(prefix2+"adv_shtg_cd",0);sheetObjects[1].FitColWidth();
				 sheetObjects[3].SetColHidden(prefix4+"adv_shtg_cd",1);sheetObjects[3].FitColWidth();
				 ComSetObjValue(formObject.lastSplitNo,formObject.memosplitno.value);
				 //sheetObjects[0].Enable = false;
				 ComGetObject("btn_save").style.display="inline"
				 ComGetObject("btn_save2").style.display="none"
				 ComBtnEnable("btn_save");
				 ComBtnDisable("btn_save2");
	            break; 
	    } 
		//if (ComIsEmpty(formObject.splitcount) || sheetObjects[1].Rows==1) return;
		var lastSplit="";
		if(ComGetObjValue(formObject.bkg_no).length==11 || ComGetObjValue(formObject.bkg_no).length==13){ //old bkg_no
			if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
				lastSplit="91";
				orgSplit="91";
			}else{
				lastSplit="00";
				orgSplit="00";
			}
		}else if(ComGetObjValue(formObject.bkg_no).length==12){  //new bkg_no
			if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
				lastSplit=ComGetObjValue(formObject.memosplitno);
				orgSplit=ComGetObjValue(formObject.memosplitno);
			}else{
				lastSplit=ComGetObjValue(formObject.custSplitNo);
                orgSplit=ComGetObjValue(formObject.custSplitNo);
			}
		}
		if (ComIsEmpty(formObject.splitcount)) return; 
		
		ComSetObjValue(document.form.txtProgress, "0/" + ComGetObjValue(document.form.splitcount));
		
		if (obj.name !="splitreason") return;
		formObject.splitcount.value = splitTotalControl(ComGetObjValue(formObject.splitreason).toUpperCase(), ComParseInt(formObject.splitcount), ComParseInt(formObject.lastSplitNo));
		sheet_splitSet(ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		if(ComGetObjValue(formObject.splitreason).toUpperCase()=="M"){
			manualVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		}else{
			autoVolume(ComParseInt(formObject.splitcount),ComGetObjValue(formObject.splitreason),ComParseInt(lastSplit),ComParseInt(formObject.splitcount)-1);
		}
		ComSetObjValue(formObject.cntrSplitNo,"");
		ComSetObjValue(formObject.dgCntrSplitNo,"");
		ComSetObjValue(formObject.rfCntrSplitNo,"");
		ComSetObjValue(formObject.akCntrSplitNo,"");
		ComSetObjValue(formObject.bbCntrSplitNo,"");

		
		for(var iRow=1;iRow<sheetObjects[3].LastRow()+1;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-ComParseInt(formObject.splitcount);iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
				sheetObjects[3].SetCellValue(iRow,iCol,"0",0);
			}
		}
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo,asCodeList,asTextList,flag,sheetJsonFlag) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init // org booking info
			    with(sheetObj){				        
				      var HeadTitle1=strSheetTitle1;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"tvvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"first_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"act_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"adv_shtg_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Image",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				      if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
				    	  SetColHidden(prefix1+"adv_shtg_cd",1);
				      }				 
				      InitColumns(cols);
				      sheetJson_1 = cols;
		
				      SetEditable(1);
				      SetImageList(0,"/opuscntr/img/btng_pc.gif");				      
				      SetColHidden(prefix1+"pc",1);
				      SetColProperty(prefix1+"adv_shtg_cd", {ComboText:asTextList, ComboCode:asCodeList} );
				      SetSheetHeight(130);
				      SetCountPosition(0);
		      }
				break;
			case 2:      //sheet2 init //split 정보
			    with(sheetObj){
				        
				      var HeadTitle1=strSheetTitle2;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pctl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"tvvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"first_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"act_wgt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"adv_shtg_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rtn_route",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Image",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"pc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			          if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						   SetColHidden(prefix2+"adv_shtg_cd",1);
			          }
				      InitColumns(cols);
				      sheetJson_2 = cols;
				      SetEditable(1);
				      SetImageList(0,"/opuscntr/img/btng_pc.gif");

				      SetColProperty(prefix2+"adv_shtg_cd", {ComboText:asTextList, ComboCode:asCodeList} );
				      SetSheetHeight(130);
				      SetCountPosition(0);
		      }


				break;
			case 3:      //sheet3 init// qty 배분
			    with(sheetObj){
				      var HeadTitle1=strSheetTitle3;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix3+"op_cntr_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
				      if(orgSplit.length>1){
				    	  cols.push({Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix3+orgSplit,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      if(sheetJsonFlag){
				    	  InitColumns(sheetJson_3);
				      }else{
				    	  InitColumns(cols);
				    	  sheetJson_3 = cols;
				      }
				      SetEditable(1);				      
				      SetSheetHeight(170);
				      SetSheetWidth(550);
				      SetExtendLastCol(0);
//				      updateSheetSize(sheetObj);
				      SetCountPosition(0);
		            }
				break;
			case 4:      //sheet4 init// cntr 배분
			    with(sheetObj){
				        
				      var HeadTitle1=strSheetTitle4;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 5, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix4+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"adv_shtg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      if(flag &&  orgSplit.length>1){
		            	cols.push({Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix4+orgSplit,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      if(sheetJsonFlag){
				    	  InitColumns(sheetJson_4);
				      }else{
				    	  InitColumns(cols);
				    	  sheetJson_4 = cols;
				      }
				      if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
				    	  SetColHidden(prefix4+"adv_shtg_cd",1);
				      }
				      SetEditable(1);				      
				      SetColProperty(prefix4+"adv_shtg_cd", {ComboText:asTextList, ComboCode:asCodeList} );
				      SetSheetHeight(170);
				      SetSheetWidth(550);
				      SetCountPosition(0);
//				      updateSheetSize(sheetObj);
				      SetExtendLastCol(0);
		      }
				break;	
			case 5:      //sheet5 init//spcl 배분
			    with(sheetObj){				        
				      var HeadTitle1=strSheetTitle5;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 5, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix5+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix5+"dcgo_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      sheetJson_5 = cols;
				      SetCountPosition(0);
				      SetEditable(1);
				      SetVisible(0);
		            }


				break;				
			case 6:      //sheet6 init for PRD QTY
			    with(sheetObj){				        
				      var HeadTitle1="|TS|Q'ty";
				      var headCount=3;
				      (headCount, 3, 0, true);		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"c_tpsz",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"c_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];				       
				      InitColumns(cols);	
				      sheetJson_6 = cols;
				      SetEditable(1);
				      SetCountPosition(0);
				      SetVisible(0);
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
}).resize();

$(window).on('resizeEnd', function() {
	 updateSheetSize();
});


function updateSheetSize(sheetObj){
  var marginDefault = 80;
  var obj;
  if(typeof sheetObj == "undefined") {
	  obj = $("#" + sheetObjects[2].id).offset();
  }
  else {
	  obj = $("#" + sheetObj.id).offset();
  }
  var sheetTop = obj.top;
  var sheetLeft = obj.Left;

  var marginHeight = sheetTop + marginDefault;
  var height = $(window).height();
  var sheetHeight = height - marginHeight;
  sheetHeight = sheetHeight > 90?sheetHeight:90;
  
  var width = $(window).width();
  var sheetWidth = (width - marginDefault)/2;
  
  if(typeof sheetObj == "undefined") {
      sheetObjects[2].SetSheetHeight(sheetHeight);
      sheetObjects[3].SetSheetHeight(sheetHeight);
      
      sheetObjects[2].SetSheetWidth(sheetWidth);
      sheetObjects[3].SetSheetWidth(sheetWidth);
  }
  else {
	  sheetObj.SetSheetHeight(sheetHeight);
	  sheetObj.SetSheetWidth(sheetWidth);
  }
}       

var sParam = "";
var currState = "";
var currSplitBkg = "";
var startRowNum = 1;
var reCellCount = 0;

function checkSplitCount(sXml) {
	try{
		var formObj = document.form;
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if(State != "S"){
			if(reCellCount == 10){
				ComOpenWait(false);	 
				ComShowCodeMessage("BKG00110", "SPLIT");
				reCellCount = 0;
				return;
			}
			reCellCount++;
		}else{
			reCellCount = 0;
			startRowNum++;
		}
		sParam = ComGetSaveString(sheetObjects);
		sParam += "&" + FormQueryString(formObj);
		if(startRowNum == sheetObjects[1].RowCount()){
			sParam += "&lastTarget=Y";
		}
		ComSetObjValue(formObj.txtProgress, (startRowNum-1) + "/" + (sheetObjects[1].RowCount()));
		if(startRowNum <= sheetObjects[1].RowCount()){
			ComSearchAsync("ESM_BKG_0099GS.do", "currSplitBkg=" + sheetObjects[1].GetCellValue(startRowNum, prefix2 + "bkg_no") + "&" + sParam, checkSplitCount);
		}else{
			ComOpenWait(false);	
			ComShowCodeMessage("BKG00102");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_save2");
			
			if(formObj.bkg_close_flg.value != "Y" || formObj.vvd_change_flg.value != "Y"){
				if(ComGetEtcData(sXml,"split_flag") == "N"){
	    			ComShowCodeMessage("BKG02052");
	    		}
			}
			
			if(ComGetObjValue(formObj.popUpFlag)=="Y"){
	    		ComClosePopup();
			}
		}
	}catch (e) {
		ComOpenWait(false);	
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);        
	var arrPreFix=new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet2_");      	
	switch(sAction) {
	
		case COMMAND05:        //저장		
	        formObj.f_cmd.value = COMMAND05;
		 	for(i = 1; i<sheetObjects[1].Rows;i++){
		 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
		 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="90"){
		 				ComShowCodeMessage("BKG00884");
		 				return;
		 			}
		 		} else {
		 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="100"){
		 				ComShowCodeMessage("BKG00884");
		 				return;		 	
		 			}
		 		}
		 	}
			setQtyCntrVar(formObj);
			sParam = ComGetSaveString(sheetObjects);
			if (sParam == "") return;  
			sParam += "&" + FormQueryString(formObj);
			sheetObj.WaitImageVisible=false;
			if(ComGetObjValue(formObj.splitreason).toUpperCase() == "C"){
				startRowNum = parseInt(2,10);
			}else if(ComGetObjValue(formObj.splitreason).toUpperCase() == "M"){
				startRowNum = parseInt(1,10);
			}
			if(startRowNum > 0){
				if(startRowNum == sheetObjects[1].RowCount()){
					sParam += "&lastTarget=Y";
				}
				ComOpenWait(true);
				ComSetObjValue(document.form.txtProgress, (startRowNum-1) + "/" + (sheetObjects[1].RowCount()));
				reCellCount = 0;
				ComSearchAsync("ESM_BKG_0099GS.do", "currSplitBkg=" + sheetObjects[1].GetCellValue(startRowNum, prefix2 + "bkg_no") + "&" + sParam, checkSplitCount);
			}
		break;	
	
		case IBSEARCH:      //SEARCH 	
			
			if (!validateForm(sheetObjects[0],formObj,IBSEARCH)) return false;
			
			formObj.f_cmd.value=SEARCH;
		    sheetObj.WaitImageVisible=false;
			ComOpenWait(true);	
			 
			var sXml=sheetObj.GetSearchData("ESM_BKG_0099GS.do", "f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value + "&bl_no"+formObj.bl_no.value + "&"+ComGetPrefixParam(arrPreFix));
			
			var arrXml=sXml.split("|$$|");
			
			ComOpenWait(false);	
			 
			if (ComGetTotalRows(arrXml[0]) == 0){
				ComShowCodeMessage("BKG00889");
				return;
			}
				
			 orgSplit="";
				strSheetTitle3="|TS|Q'ty";
				strSheetTitle4="|CNTR|TS|ST|AS";
				strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
				for(i=0;i<sheetObjects.length;i++){
		            ComConfigSheet (sheetObjects[i] );
		            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
		            ComEndConfigSheet(sheetObjects[i]);
		        }
			
				sheetObjects[2].SetExtendLastCol(0);
				sheetObjects[3].SetExtendLastCol(0);
				
				ComBtnDisable("btn_dg");
				ComBtnDisable("btn_rf");
				ComBtnDisable("btn_ak");
				ComBtnDisable("btn_bb");
			
			//loadInitSheet(orgSplit);
			for(var i=0; i < arrXml.length; i++){ 
				if(i==0){
											 
					//sheetObjects[i].RenderSheet(0);
					if(i > 0) {
						sheetObjects[i].SetWaitImageVisible(0);
					}  
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					//sheetObjects[i].RenderSheet(1);
				}else{
					if( i< 2){
					//sheetObjects[i+1].RenderSheet(0);
					}
					if(i > 0) {
						sheetObjects[i+1].SetWaitImageVisible(0);
					} 					
					sheetObjects[i+1].LoadSearchData(arrXml[i],{Sync:1} );						
					//sheetObjects[i+1].RenderSheet(1); 
				}					 
			} 
				
			if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit="91";
				}else{
					orgSplit="00";
				}
			}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
				//orgSplit = ComGetObjValue(formObj.bkg_no).substring(10,12);
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit=sheetObj.GetEtcData("memoSplitNo");
				}else{
					orgSplit=sheetObj.GetEtcData("custSplitNo");
				}
			}
			setFormData(formObj,sheetObj);
			ComSetObjValue(formObj.troTp, sheetObj.GetEtcData("troTp"));
		break;
		case COMMAND01:      //booking split no조회 
			 formObj.f_cmd.value=COMMAND01;
//				 sheetObj.SetWaitImageVisible(0);
			 sheetObj.WaitImageVisible=false;

			 var sXml=sheetObj.GetSearchData("ESM_BKG_0099GS.do", "f_cmd="+COMMAND01+"&bkg_no="+formObj.bkg_no.value);
			 var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			 bkgSplitNoListPop(document.form.bkg_no,bkg_split_no_list); 
		break;
		case IBSAVE:        //SAVE
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			setTimeout( function () {
				formObj.f_cmd.value=MULTI; 
				for(i = 1; i<sheetObjects[1].LastRow()+1;i++){
			 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
			 			if(sheetObjects[1].GetCellValue(i, prefix2+"bkg_no").substring(10)=="90"){
			 				ComShowCodeMessage("BKG00884");
			 				ComOpenWait(false);	
			 				return;
			 			}
			 		} else {
			 			if(sheetObjects[1].GetCellValue(i, prefix2+"bkg_no").substring(10)=="100"){
			 				ComShowCodeMessage("BKG00884");
			 				ComOpenWait(false);	
			 				return;		 	
			 			}
			 		}	
				}
				setQtyCntrVar(formObj);
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") {
					ComOpenWait(false);	
					return;  
				}
				sParam += "&" + FormQueryString(formObj);
				ComSetObjValue(formObj.txtProgress, "" + 0 + "/" + (sheetObjects[1].RowCount()));

        		var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0099GS.do", sParam);
        		
				sheetObjects[0].LoadSaveData(sXml);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var splitFlg = ComGetEtcData(sXml,"split_flag");
				
				if(State == "S"){	     
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_save2");
					ComSetObjValue(formObj.txtProgress, "" + (sheetObjects[1].RowCount()) + "/" + (sheetObjects[1].RowCount()));
			    	if(formObject.bkg_close_flg.value == "Y" && formObj.vvd_change_flg.value == "Y"){
						//bkg close mail open
						//=========================================================================================
						var subject="BKG Change Notice";
						var closeBkgMsg="BKG No : " + formObj.bkg_no.value + "<BR>" +						
										  "Current VVD : " + "<BR>" +						
										  "Current Route : " + "<BR>" +						
										  "Current CNTR No : " + "<BR>" +						
										  "Changes : " + "<BR>" +
										  "<BR>" + 
										  "Above booking has been changed. Please DO NOT FORGET TO UPDATE STOWAGE PLAN ACCORDINGLY.";						//=========================================================================================
//	            		ComBkgGroupMailset(sheetObjects[0], formObj, subject, closeBkgMsg);
			    	} else {
			    		if(splitFlg=="N"){
			    			ComShowCodeMessage("BKG02052");
			    		}		
			    	}
					if(ComGetObjValue(formObj.popUpFlag)=="Y"){
						var callFunc=formObject.calllFunc.value;
						if(callFunc != ''){
							eval('opener.'+callFunc)(formObj.bkg_no.value);
						}
						ComClosePopup(); 
					}
				}
				ComOpenWait(false);	
			} , 100);
			
		break;
		case COMMAND02:      //PC  
			formObj.f_cmd.value=COMMAND02;
			setQtyCntrVar(formObj); 
			var row=sheetObj.GetSelectRow();
			if(sheetObj.GetCellValue(row,prefix2+"pc")==-1){
				return;
    		}		
			var sParam=ComGetSaveString(sheetObj);
			sheetObj.SetCellValue(row, prefix2+"pctl_no","");
			sheetObj.SetCellValue(row, prefix2+"rtn_route","");
			if (sParam == "") return;  
			sParam += "&" + FormQueryString(formObj);
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0099GS.do", sParam);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State!="S"){
				sheetObj.loadSaveXml(sXml);
				return;
			}
			var arrXml=sXml.split("|$$|");
			var isPctlNoPop="N";
			isPctlNoPop=ComGetEtcData(arrXml[0], "IsPctlNoPop")
			if(isPctlNoPop == "Y"){            	
				sheetObjects[5].LoadSearchData(arrXml[0],{Sync:1} );
				if(sheetObj.GetCellValue(row,prefix2+"bkg_no")==ComGetObjValue(formObj.bkg_no)){
					var url="ESD_PRD_0080.do?f_cmd=3&pc_mode=R";	
				} else {
					var url="ESD_PRD_0080.do?f_cmd=3&pc_mode=B";
				}
				url=url + "&bkg_no="+	sheetObj.GetCellValue(row,prefix2+"bkg_no");
				url=url + "&por="   +	ComGetEtcData(arrXml[0], "por");
				url=url + "&por_n=" +	ComGetEtcData(arrXml[0], "por_n");
				url=url + "&pol="   + ComGetEtcData(arrXml[0], "pol");
				url=url + "&pol_n=" + ComGetEtcData(arrXml[0], "pol_n");
				url=url + "&pod="   + ComGetEtcData(arrXml[0], "pod");
				url=url + "&pod_n=" + ComGetEtcData(arrXml[0], "pod_n");
				url=url + "&del="   + ComGetEtcData(arrXml[0], "del");
				url=url + "&del_n=" + ComGetEtcData(arrXml[0], "del_n");
				url=url + "&t_vvd=" + ComGetEtcData(arrXml[0], "t_vvd");
				for(i=1 ; i <= 4; i++){
					if(ComGetEtcData(arrXml[0], "pol"+i).length == 5){
						url=url + "&pol" + i + "="   + ComGetEtcData(arrXml[0], "pol"+i);
						url=url + "&pol" + i + "_n=" + ComGetEtcData(arrXml[0], "pol"+i+"_n");
						url=url + "&pod" + i + "="   + ComGetEtcData(arrXml[0], "pod"+i);
						url=url + "&pod" + i + "_n=" + ComGetEtcData(arrXml[0], "pod"+i+"_n");
					}
				}
				url=url + "&rcv_t=" + ComGetEtcData(arrXml[0], "rcv_t");
				url=url + "&del_t=" + ComGetEtcData(arrXml[0], "del_t");
				url=url + "&shpr="  + ComGetEtcData(arrXml[0], "shpr");
				url=url + "&cngn="  + ComGetEtcData(arrXml[0], "cngn");
				url=url + "&com="     + ComGetEtcData(arrXml[0], "com");
				url=url + "&rep_com=" + ComGetEtcData(arrXml[0], "rep_com");
				url=url + "&wgt="     + ComGetEtcData(arrXml[0], "wgt");
				url=url + "&wgt_un="  + ComGetEtcData(arrXml[0], "wgt_un");
				url=url + "&bkg_ofc=" + ComGetEtcData(arrXml[0], "bkg_ofc");
				url=url + "&org_sal_ofc=" + ComGetEtcData(arrXml[0], "org_sal_ofc"); 
				url=url + "&m_pu=" + ComGetEtcData(arrXml[0], "m_pu");
				url=url + "&f_rt=" + ComGetEtcData(arrXml[0], "f_rt");
				url=url + "&sc="  + ComGetEtcData(arrXml[0], "sc");
				url=url + "&rfa=" + ComGetEtcData(arrXml[0], "rfa");
				url=url + "&cgo_tp=" + ComGetEtcData(arrXml[0], "cgo_tp");
				url=url + "&dg_f=" + ComGetEtcData(arrXml[0], "dg_f");
				url=url + "&rf_f=" + ComGetEtcData(arrXml[0], "rf_f");
				url=url + "&ak_f=" + ComGetEtcData(arrXml[0], "ak_f");
				url=url + "&bb_f=" + ComGetEtcData(arrXml[0], "bb_f");
				url=url + "&rd_f=" + ComGetEtcData(arrXml[0], "rd_f");
				url=url + "&hg_f=" + ComGetEtcData(arrXml[0], "hg_f");
				url=url + "&soc_f="+ ComGetEtcData(arrXml[0], "soc_f");
				url=url + "&pm_f=" + ComGetEtcData(arrXml[0], "pm_f");
				
				for(var iRow=1;iRow<sheetObjects[5].LastRow()+1;iRow++){
					url=url + "&c_tpsz="+sheetObjects[5].GetCellValue(iRow,"c_tpsz");
					url=url + "&c_qty=" +sheetObjects[5].GetCellValue(iRow,"c_qty");
				}
    			ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080","1,0,1,1,1", true);
    			if(sheetObj.GetCellValue(row, prefix2+"pctl_no").length>=20){
    				doActionIBSheet(sheetObjects[1],formObj,COMMAND03);
    			}
			} else {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"pc",1,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"pctl_no",ComGetEtcData(arrXml[0],"pctl_no"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"rtn_route",ComGetEtcData(arrXml[0],"rtn_route"),0);
				ComShowCodeMessage("BKG02046");
    		} 
        	break;
		case COMMAND03:      //SPLIT NEW T/S ROUTE
			formObj.f_cmd.value=COMMAND03;
			sheetObj.WaitImageVisible=false;
			var sParam=ComGetSaveString(sheetObj);
			if (sParam == "") return;  
			sParam += "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0099GS.do", sParam);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State == "S"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"pc",1,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"pctl_no",ComGetEtcData(sXml,"pctl_no"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix2+"rtn_route",ComGetEtcData(sXml,"rtn_route"),0);
			}			  
			break;			
		case SEARCH01:      
			formObj.f_cmd.value=SEARCH01; 
			setQtyCntrVar(formObj);
			var sParam=ComGetSaveString(sheetObjects);
			if (sParam == "") return;  
			sParam += "&" + FormQueryString(formObj);
			sheetObj.WaitImageVisible=false;

    		ComOpenWait(true);
    		var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0099GS.do", sParam);
			ComOpenWait(false);
			formObject.bkg_cbf_flg.value=ComGetEtcData(sXml,"cbf_flag"); 
			break;
    }
}
    
	/*
	* Qty,Cntr SplitNo 
	*/
	function setQtyCntrVar(formObj){
		var arr="";
		var strNo="";
		var ichk=0;
		var tmpbkgno="";
		var splitNo=ComParseInt(formObj.splitcount); 
		for(var iRow=1;iRow<sheetObjects[2].LastRow()+1;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				strNo=sheetObjects[2].ColSaveName(iCol).split("_");
				arr+=sheetObjects[2].GetCellValue(iRow,prefix3+"cntr_tpsz_cd")+":"+sheetObjects[2].GetCellValue(iRow,iCol)+":"+strNo[1]+"~";
			}
		}
		ComSetObjValue(formObj.qtySplitNo,arr);
		arr="";
        var dgArr="";
		var rfArr="";
		var akArr="";
		var ifindRow=-1;
		var keepDgRefNo="N"; //for DG Ref No control : decide to create new No. or use existing No. Only one booking can use existing No.
		
		if (sheetObjects[3].RowCount()==0){
			ComSetObjValue(formObj.cntrExists,"N");
		}else{
			ComSetObjValue(formObj.cntrExists,"Y");
		}
		for(var iRow=1;iRow<sheetObjects[3].HeaderRows()+sheetObjects[3].RowCount();iRow++){ //Loop for container No.
			ichk=0; //the row of booking No.
			if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){ //In case Memo split, DG Ref flag is always N because origin booking keep staying
				keepDgRefNo="Y";
			}
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){ //Loop from source booking to the end of split booking
				if (ichk==0){ //The first of each containe loop
					var strTmp=strSheetTitle4.split("|");
					strNo=["",strTmp[iCol]];
				}else{
					strNo=sheetObjects[3].ColSaveName(iCol).split("_");
				}
				ichk++;
				/*if(ichk==0){		
					tmpbkgno=ComGetObjValue(formObj.bkg_no);
					ichk++;
				 }else{
                    //tmpbkgno=ComGetObjValue(formObj.bkg_no).substring(0,10)+strNo[1];
				}*/
				tmpbkgno=sheetObjects[1].GetCellValue(ichk,prefix2+"bkg_no");
				tmpCntrNo=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no");
				//get row number of treating container No. in sheet [4]
				ifindRow=sheetObjects[4].FindText(prefix5+"cntr_no", sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no"));
				if(sheetObjects[3].GetCellValue(iRow,iCol)==1){ //check is on
					arr+=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no")+":"+strNo[1]+":"+tmpbkgno+":"+sheetObjects[3].GetCellValue(iRow,prefix4+"adv_shtg_cd")+"~";

//					if (ifindRow>-1){
//						if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="DG"){
							//container No:dcgo_seq:split No(2 digits):booking No.~
//							dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
//						}else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="RF"){
//							rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
//						}else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="AK"){
//							akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all:"+strNo[1]+":"+tmpbkgno+"~";
//						}
//					}

					for(j=1;j<=sheetObjects[4].RowCount();j++){
						if((sheetObjects[4].GetCellValue(j, prefix5+"code")=="DG") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
//							dgArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";

							//container No:dcgo_seq:split No(2 digits):booking No.:DG Ref No flag~
							//DG Ref No : "Y"-> Use existing No.   "N"-> Create new No.  "X"->not related to this process
							dgArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":"+keepDgRefNo+"~";
						}else if((sheetObjects[4].GetCellValue(j,prefix5+"code")=="RF") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
//							rfArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
							rfArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":X~";
						}else if((sheetObjects[4].GetCellValue(j,prefix5+"code")=="AK") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
//							akArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
							akArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":X~";
						}
					}
					
					keepDgRefNo="N";
				
				}else { //check is off
					 arr+=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no")+"::"+tmpbkgno+":"+sheetObjects[3].GetCellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					 if (ifindRow>-1){
						 if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="DG"){
//							 dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							 dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+"~";
//							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
							 dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						 }else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="RF"){
//							 rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							 rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+"~";
//							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
							 rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						 }else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="AK"){
//							 akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+tmpbkgno+"~";
//							 akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+"~";
//							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":all::"+tmpbkgno+"~";
							 akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						}
					}
				 }
			}
		}	
			
		//if (formObj.dgCntrSplitNo.value.length<1){
		if(dgSelectFlg=="N"){ //dg using the pop-up if there is never assign
			ComSetObjValue(document.form.dgCntrSplitNo,dgArr);
		}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
		//if (formObj.rfCntrSplitNo.value.length<1){
		if(rfSelectFlg=="N"){ //rd using the pop-up if there is never assign
			ComSetObjValue(document.form.rfCntrSplitNo,rfArr);
    	}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
		//if (formObj.akCntrSplitNo.value.length<1){
		if(akSelectFlg=="N"){ //ak using the pop-up if there is never assign
			ComSetObjValue(document.form.akCntrSplitNo,akArr);
		}else{
			ComSetObjValue(document.form.cntrPopExists,"Y");
		}
		//}
		//ComDebug("dg="+document.form.dgCntrSplitNo.value); 
		ComSetObjValue(formObj.cntrSplitNo,arr);
	}
	/*
	* init var
	*/
	function initData(){
		var formObj=document.form;
		ComSetObjValue(formObj.splitcount,"");
		ComSetObjValue(formObj.cntrSplitNo,"");
		ComSetObjValue(formObj.dgCntrSplitNo,"");
		ComSetObjValue(formObj.rfCntrSplitNo,"");
		ComSetObjValue(formObj.akCntrSplitNo,"");
		ComSetObjValue(formObj.bbCntrSplitNo,"");
		ComSetObjValue(formObj.tro_flg,"");
		ComSetObjValue(formObj.pctl_no,"");
		ComSetObjValue(formObj.splitdel,"");
		ComSetObjValue(formObj.bdr_flag,"");
		ComSetObjValue(formObj.dg,"");
		ComSetObjValue(formObj.rf,"");
		ComSetObjValue(formObj.ak,"");
		ComSetObjValue(formObj.bb,"");
        ComSetObjValue(formObj.pcIdx,"0");
		btnSpecialCargo(formObj);
		formObj.stwg_cd.checked=false;
		formObj.rail_blk_cd.checked=false;
		formObj.fd_grd_flg.checked=false;
		formObj.hngr_flg.checked=false;
		formObj.hot_de_flg.checked=false;
		formObj.prct_flg.checked=false;
		formObj.stop_off_loc_cd.checked=false;
		formObj.spcl_hide_flg.checked=false;
		formObj.remark.checked=false;
		formObj.stwg_cd.disabled=false;
		formObj.rail_blk_cd.disabled=false;
		formObj.fd_grd_flg.disabled=false;
		formObj.hngr_flg.disabled=false;
		formObj.hot_de_flg.disabled=false;
		formObj.prct_flg.disabled=false;
		formObj.stop_off_loc_cd.disabled=false;
		formObj.spcl_hide_flg.disabled=false;
		formObj.remark.disabled=false;   
	}
	/*
	* CheckBox
	*/
	function setCheckValue(obj,chk){
		if (chk.toUpperCase()=="Y"){
			obj.checked=chk;
		}else{ 
			obj.disabled=true;
		}
	}
	/*
	* Setting Form Data
	*/
	function setFormData(formObj,sheetObj){
		ComSetObjValue(formObj.old_bkg_no,	sheetObj.GetEtcData("bkg_no"));
		ComSetObjValue(formObj.bl_no, 		sheetObj.GetEtcData("bl_no"));
		ComSetObjValue(formObj.tvvd,  		sheetObj.GetEtcData("tvvd"));
		ComSetObjValue(formObj.por_cd,		sheetObj.GetEtcData("por_cd"));
		ComSetObjValue(formObj.pol_cd,		sheetObj.GetEtcData("pol_cd"));
		ComSetObjValue(formObj.pod_cd,		sheetObj.GetEtcData("pod_cd"));
		ComSetObjValue(formObj.del_cd,		sheetObj.GetEtcData("del_cd"));
		ComSetObjValue(formObj.dg,			sheetObj.GetEtcData("dg"));
		ComSetObjValue(formObj.rf,			sheetObj.GetEtcData("rf"));
		ComSetObjValue(formObj.ak,			sheetObj.GetEtcData("ak"));
		ComSetObjValue(formObj.bb,			sheetObj.GetEtcData("bb"));
		setCheckValue(formObj.stwg_cd,			sheetObj.GetEtcData("stwg_cd"));
		setCheckValue(formObj.rail_blk_cd,		sheetObj.GetEtcData("rail_blk_cd"));
		setCheckValue(formObj.fd_grd_flg,		sheetObj.GetEtcData("fd_grd_flg"));
		setCheckValue(formObj.hngr_flg,			sheetObj.GetEtcData("hngr_flg"));
		setCheckValue(formObj.hot_de_flg,		sheetObj.GetEtcData("hot_de_flg"));
		setCheckValue(formObj.prct_flg,			sheetObj.GetEtcData("prct_flg"));
		setCheckValue(formObj.stop_off_loc_cd,	sheetObj.GetEtcData("stop_off_loc_cd"));
		setCheckValue(formObj.spcl_hide_flg,	sheetObj.GetEtcData("spcl_hide_flg"));
		setCheckValue(formObj.remark,			sheetObj.GetEtcData("remark"));
		if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){			
			ComSetObjValue(formObj.lastSplitNo,sheetObj.GetEtcData("memoSplitNo"));
		}else{
			ComSetObjValue(formObj.lastSplitNo,sheetObj.GetEtcData("custSplitNo"));
		}
		ComSetObjValue(formObj.custSplitNo,	sheetObj.GetEtcData("custSplitNo"));
		ComSetObjValue(formObj.memosplitno,	sheetObj.GetEtcData("memoSplitNo"));
		ComSetObjValue(formObj.bkgsplitno,	sheetObj.GetEtcData("bkgsplitno"));
		ComSetObjValue(formObj.bdr_flag,	sheetObj.GetEtcData("bdr_flag"));
		ComSetObjValue(formObj.pctl_no,		sheetObj.GetEtcData("pctl_no"));
		ComSetObjValue(formObj.tro_flg,		sheetObj.GetEtcData("tro_flg"));
		ComSetObjValue(formObj.bkgStsCd,	sheetObj.GetEtcData("bkgStsCd"));
		ComSetObjValue(formObj.bkg_close_flg,	sheetObj.GetEtcData("bkg_close_flg"));
		ComSetObjValue(formObj.obl_iss_flg,		sheetObj.GetEtcData("obl_iss_flg"));
		
		ComSetObjValue(formObj.bkg_wt_chk_flg,		sheetObj.GetEtcData("bkg_wt_chk_flg"));
		ComSetObjValue(formObj.edi_hld_flg,		sheetObj.GetEtcData("edi_hld_flg"));
		
		document.getElementById("splitFlag").style.display="none";
		document.getElementById("bdrFlag").style.display="none";
		if (ComGetObjValue(formObj.bkgStsCd).toUpperCase()=="X"){
			document.getElementById("splitFlag").innerHTML="Cancel"; 
			document.getElementById("splitFlag").style.display="block";
			document.getElementById("splitFlag").style.color="red"
		}else{
			if (sheetObj.GetEtcData("splitFlg").toUpperCase()=="Y"){
				document.getElementById("splitFlag").innerHTML="Split"; 
				document.getElementById("splitFlag").style.display="block";
				document.getElementById("splitFlag").style.color="blue"
			}
			if (sheetObj.GetEtcData("bdr_flag").toUpperCase()=="Y"){
				document.getElementById("bdrFlag").innerHTML="BDRed"; 
				document.getElementById("bdrFlag").style.display="block";
				document.getElementById("bdrFlag").style.color="red"
			}
		}
	}
	/*
	* Special Cargo btn 
	*/
	function btnSpecialCargo(formObj){
		if (ComGetObjValue(formObj.dg).toUpperCase()=="Y"){
			ComBtnEnable("btn_dg");
		}else{
			ComBtnDisable("btn_dg");
		}
		if (ComGetObjValue(formObj.rf).toUpperCase()=="Y"){
			ComBtnEnable("btn_rf");
		}else{
			ComBtnDisable("btn_rf");
		}
		if (ComGetObjValue(formObj.ak).toUpperCase()=="Y"){
			ComBtnEnable("btn_ak");
		}else{
			ComBtnDisable("btn_ak");
		}
		if (ComGetObjValue(formObj.bb).toUpperCase()=="Y"){
			ComBtnEnable("btn_bb");
		}else{
			ComBtnDisable("btn_bb");
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		 switch(sAction) {
		 	case IBSEARCH:
		 		if(formObj.bkg_no.value == ''){
		 			ComShowCodeMessage("BKG08019");
		 			return false;
		 		}
		 		break;
		 
			case COMMAND01:  //splitcount
//no support[check again]CLT 				if (sheetObj.Rows==1){
					//return false;
				if (sheetObj.RowCount()==0){
					return false;
				}
					
				if (  formObj.splitcount.value != "" &&  ComNullToZero(formObj.splitcount)==0){
					ComShowCodeMessage("BKG00647");
					return false;
				}
				if( formObj.bkgStsCd.value != ""  &&  ComGetObjValue(formObj.bkgStsCd).toUpperCase() == "X"){
					ComShowCodeMessage("BKG00005");
					return false;
				}
				if( formObj.split_rsn_cd.value != ""  &&   ComGetObjValue(formObj.split_rsn_cd).toUpperCase() == "Y"){
					ComShowCodeMessage("BKG00646");
					return false;
				}
				if( formObj.bkg_cgo_tp_cd.value != ""  &&   ComGetObjValue(formObj.bkg_cgo_tp_cd).toUpperCase() == "Y"){
					ComShowCodeMessage("BKG00649");
					return false;
				}		 
			break;
			case IBSAVE:	// sheck save
								
				if(ComIsNull(formObj.bkg_no)){
					ComShowCodeMessage("BKG08019");
					return false;
				}			
				
				if (ComIsNull(formObj.bl_no)){
					ComShowCodeMessage("BKG00273");
					return false;
				}
				
				if (ComChkLen(formObj.tvvd,9) !=2){
					ComShowCodeMessage("BKG00273");
					return false;
				}				 
				
				
				if(formObj.obl_iss_flg.value == "Y"){					
					if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						ComShowCodeMessage("BKG02055");
						return false;
					}
				}
				
//no support[check again]CLT 				for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
				for(var iRow=1;iRow<sheetObjects[1].LastRow()+1;iRow++){
					if (sheetObjects[0].GetCellValue(1,prefix1+"tvvd") != sheetObjects[1].GetCellValue(iRow,prefix2+"tvvd")
						&& ComIsEmpty(sheetObjects[1].GetCellValue(iRow,prefix2+"pctl_no"))){
						ComShowCodeMessage("BKG00658");
						return false;   
						break;
					}
					if (ComChkLen(sheetObjects[1].GetCellValue(iRow,prefix2+"tvvd"),9) !=2){
						ComShowCodeMessage("BKG00658");
						return false;
						break;
					}
					if((sheetObjects[1].GetCellValue(iRow,prefix2+"act_wgt") * 1000) == 0){
						ComShowCodeMessage("BKG00585");
						return false;
						break;
					}
				}
				
				var splitNo=ComParseInt(formObj.splitcount);
				var icnt=0;
				var icntrSplit=0;
//no support[check again]CLT 				for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
				for(var iRow=1;iRow<sheetObjects[3].LastRow()+1;iRow++){
					var icnt=0;
					for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
						if (sheetObjects[3].GetCellValue(iRow,iCol)=="0"){
						//if (sheetObjects[3].CheckedRows(iCol)==(sheetObjects[3].Rows-1)){
							icnt++;
						//	break;
						}
						/* cntrSplit Check
if (sheetObjects[3].GetCellValue(iRow,iCol+1)=="0"){
							icntrSplit++;
						}
						*/
					}
					if (icnt==splitNo){
						ComShowCodeMessage("BKG00659");
						return false;
						break;
					}
				}					
				/* cntrSplit Check
				if (icntrSplit==splitNo){
					ComShowCodeMessage("BKG00659");
					return false;
				}
				 */
				//  validation
				var fQtySum=0;
//no support[check again]CLT 				for(var iRow=1;iRow<sheetObjects[2].Rows;iRow++){
				for(var iRow=1;iRow<sheetObjects[2].LastRow()+1;iRow++){
					fQtySum=0;
					for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
						fQtySum += (sheetObjects[2].GetCellValue(iRow,iCol) * 100);
//						fQtySum +=ComTrunc(sheetObjects[2].GetCellValue(iRow,iCol),2);
					}
					
					var opCntrQty = sheetObjects[2].GetCellValue(iRow,prefix3 + "op_cntr_qty");
//					console.log(opCntrQty, fQtySum);
					if (opCntrQty - (fQtySum / 100) >= 0.01){
						ComShowCodeMessage("BKG00662");
						return false;
						break;
					}				
				}
				//validation
				for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
					fQtySum=0;
					for(var iRow=1;iRow<sheetObjects[2].LastRow()+1;iRow++){
						fQtySum +=ComTrunc(sheetObjects[2].GetCellValue(iRow,iCol),2);
					}
					if((0.0 == fQtySum || 0 == fQtySum) || 0 > fQtySum){
						ComShowCodeMessage("BKG00013");
						return false;
					}
		 		}
				var fWgtSum=0;
				var fPkgSum=0;
				var fMeaSum=0;
				for(var iRow=1; iRow<sheetObjects[1].LastRow()+1; iRow++){
					fWgtSum += sheetObjects[1].GetCellValue(iRow,prefix2+"act_wgt") * 1000;
					fPkgSum += ComTrunc(sheetObjects[1].GetCellValue(iRow,prefix2+"pck_qty"));
					var tempMea = (sheetObjects[1].GetCellValue(iRow, prefix2 + "meas_qty") * 1000);
					fMeaSum += Math.round(tempMea);
				}
				var originalMeaSum = sheetObj.GetCellValue(1, prefix1 + "meas_qty") * 1000;
				var originalActSum = sheetObj.GetCellValue(1, prefix1 + "act_wgt") * 1000;
				
				if (parseInt(Math.round(originalActSum)) != parseInt(fWgtSum)){
					ComShowCodeMessage("BKG00663");
					return false;
				}
				if (ComParseInt(sheetObj.GetCellValue(1,prefix1+"pck_qty")-fPkgSum)!=0){
					ComShowCodeMessage("BKG00664");
					return false;
				}
				
				if (parseInt(Math.round(originalMeaSum)) != parseInt(fMeaSum)){
					ComShowCodeMessage("BKG00665");
					return false;
				}
				
				if (!sheetObj.GetColHidden(prefix1+"adv_shtg_cd")){
					for(var iRow=1;iRow<sheetObjects[1].LastRow()+1;iRow++){
						if (ComIsNull(sheetObjects[1].GetCellValue(iRow,prefix2+"adv_shtg_cd"))){
							ComShowCodeMessage("BKG00666");
							return false;
						}
					}
					for(var iRow=1;iRow<sheetObjects[3].LastRow()+1;iRow++){
						if (ComIsNull(sheetObjects[3].GetCellValue(iRow,prefix4+"adv_shtg_cd"))){
							ComShowCodeMessage("BKG00666");
							return false;
						}
					}
				}
									
				if (ComGetObjValue(formObj.old_bkg_no)!=ComGetObjValue(formObj.bkg_no)){
					ComShowCodeMessage("BKG00048");
					return false;
				}
				/*
if(ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))
					&& ComGetObjValue(formObj.tro_flg).toUpperCase()=="Y"){
					var param="?bkg_no="+ComGetObjValue(formObj.bkg_no)+"&splitReason="+ComGetObjValue(formObj.splitreason);
						param +="&splitCntrSplitNo="+ComGetObjValue(formObj.dgCntrSplitNo)+"&lastSplitNo="+ComGetObjValue(formObj.lastSplitNo);
						param +="&validateSplitNo="+ComGetObjValue(formObj.validateSplitNo);
						param +="&splitCnt="+(ComParseInt(formObj.splitcount)-1)+"&orgSplit="+orgSplit+"&bkgsplitno="+ComGetObjValue(formObject.bkgsplitno);
					param+="&pgmNo=ESM_BKG_1025";
					ComOpenPopup("/opuscntr/ESM_BKG_1025.do"+param, 500, 470, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
				}
				*/
				
				//Check integrity between special cargo details and container selection
				if(dgSelectFlg=="Y"){
					var dgArr = ComGetObjValue(document.form.dgCntrSplitNo).split("~");
					for(var i=0;i<dgArr.length-1;i++){
						var dgDtlArr=dgArr[i].split(":");
						if((dgDtlArr[2].length > 0) && (dgDtlArr[0].length > 0)){
						var contRow = sheetObjects[3].FindText(prefix4+"cntr_no", dgDtlArr[0]);
							if(contRow > -1){ // not found -> No container information
								if(sheetObjects[3].GetCellValue(contRow, prefix4+dgDtlArr[2])!=1){
									ComShowCodeMessage("BKG01176","DG", dgDtlArr[0] + " / " + dgDtlArr[3]);
									return false;
								}
							}
						}
					}
				}
				
				if(rfSelectFlg=="Y"){
					var rfArr = ComGetObjValue(document.form.rfCntrSplitNo).split("~");
					for(var i=0;i<rfArr.length-1;i++){
						var rfDtlArr=rfArr[i].split(":");
						if((rfDtlArr[2].length > 0) && (rfDtlArr[0].length > 0)){
						var contRow = sheetObjects[3].FindText(prefix4+"cntr_no", rfDtlArr[0]);
							if(contRow > -1){ // not found -> No container information
								if(sheetObjects[3].GetCellValue(contRow, prefix4+rfDtlArr[2])!=1){
									ComShowCodeMessage("BKG01176","RF", rfDtlArr[0] + " / " + rfDtlArr[3]);
									return false;
								}
							}
						}
					}
				}

				if(akSelectFlg=="Y"){
					var akArr = ComGetObjValue(document.form.akCntrSplitNo).split("~");
					for(var i=0;i<akArr.length-1;i++){
						var akDtlArr=akArr[i].split(":");
						if((akDtlArr[2].length > 0) && (akDtlArr[0].length > 0)){
						var contRow = sheetObjects[3].FindText(prefix4+"cntr_no", akDtlArr[0]);
							if(contRow > -1){ // not found -> No container information
								if(sheetObjects[3].GetCellValue(contRow, prefix4+akDtlArr[2])!=1){
									ComShowCodeMessage("BKG01176","AK", akDtlArr[0] + " / " + akDtlArr[3]);
									return false;
								}
							}
						}
					}
				}

			break;
		 }
		 
        return true;
    }
	/*
	* Booking Split
	*/
	function SheetSplitCheck(sheetObj,Row,Col,Value,sheetTitle){
		for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
			if(typeof(sheetObj.GetCellValue(Row,i).length) =="undefined"){
				 if (sheetObj.ColSaveName(Col)==sheetObj.ColSaveName(i)){
					  sheetObj.SetCellValue(Row,sheetObj.ColSaveName(Col),Value,0);
				 } 
			 }
		 }
	}
	/*
	* Cntr check box
	*/
	function CntrCheck(sheetObj,prefix){
		var rtnArr="";
//no support[check again]CLT 		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
		for(var iRow=0;iRow<sheetObj.LastRow()+1;iRow++){
			for(var iCol=0;iCol<sheetObj.LastCol()+1;iCol++){
				if(typeof(sheetObj.GetCellValue(iRow,iCol).length) =="undefined"){
					if(sheetObj.GetCellValue(iRow,iCol)==1){
						 var str=sheetObj.ColSaveName(iCol).split("_");
						 rtnArr+=sheetObj.GetCellValue(iRow,prefix)+":"+iRow+":"+str[1]+"~";
					 }
				 }
			}
		}
		return rtnArr;
	}
	/*
	* Tro Split PopUp
	*/
	function getSplitTro(rArray){
		var rtnArr="";
		var delflag="";
		var icnt=0;
		for(var i=0;i<rArray.length;i++){
			var arrKey=rArray[i].split(":");
			//ComDebug(arrKey[0]+"==="+arrKey[1]+"=="+arrKey[2]+"=="+arrKey[3]);
			if (!ComIsEmpty(arrKey[2]) && arrKey[3] == ComGetObjValue(document.form.bkg_no)){
				icnt++;
			} 
			rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
		}
		//ComDebug(rtnArr);
		if(icnt==0) delflag="Y";
		ComSetObjValue(document.form.splitdel,delflag);
		ComSetObjValue(document.form.troSplitNo,rtnArr);
	}
	/*
	* POP Split 반환
	*/
    function getSplitCntr(arrData,flag) {
		var rtnArr="";
		var oldSeq="";
		var keepDgRefNo="N";
		for(var i=0;i<arrData.length;i++){
			var arrKey=arrData[i].split(":");
			currentSeq = arrKey[1]+"A";
			//ComDebug(arrKey[0]+"==="+arrKey[1]+"=="+arrKey[2]+"=="+arrKey[3]);
			if (arrKey[3].length ==2 && ComGetObjValue(document.form.cntrPopExists)=="Y"){
//				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3]);
			}else if (ComGetObjValue(document.form.cntrPopExists)=="Y"){ 
//				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+arrKey[3]+"~";
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+arrKey[3];
			}else{
//				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3])+"~";
				rtnArr+=arrKey[0]+":"+arrKey[1]+":"+arrKey[2]+":"+spcPopChk(arrKey[3]);
			}
			
			//Logic to add the flag to indicate whether it keep DG Ref No or create new DG Ref No per seq. 
			//Only one record can keep DG Ref No. "Y" use current DG Ref No.
			//"Y"-> Use existing No.   "N"-> Create new No.  "X"->not related to this process
			if(flag == "D"){
				if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
					if(arrKey[1] != oldSeq){
						keepDgRefNo="Y";
					}
				}
				
				if(arrKey[2] == ""){ //not copeid lines
					rtnArr+=":X";
				}else{
					rtnArr+=":"+keepDgRefNo;
					if(keepDgRefNo=="Y"){ 
						keepDgRefNo="N";
					}
				}
				
				oldSeq = arrKey[1];
			}else{
				rtnArr+=":X"
			}
			
			rtnArr+="~";
		}
		if (flag == "D"){
			dgSelectFlg="Y";
			ComSetObjValue(document.form.dgCntrSplitNo,rtnArr);
		}else if (flag == "R"){
			rfSelectFlg="Y";
			ComSetObjValue(document.form.rfCntrSplitNo,rtnArr);
		}else if (flag == "A"){
			akSelectFlg="Y";
			ComSetObjValue(document.form.akCntrSplitNo,rtnArr);
		}else if (flag == "B"){
			ComSetObjValue(document.form.bbCntrSplitNo,rtnArr);
		}
		//ComDebug(flag+"==getSplitCntr==>"+rtnArr);
    }
	/*
	* split Bkgno for Pop Spc Cgo
	*/
	function spcPopChk(splitNo){
		var ret="";
		with(sheetObjects[1]){
			for(var iRow=1;iRow<HeaderRows()+RowCount();iRow++){
				if (GetCellValue(iRow,prefix2+"bkg_no")==GetCellValue(iRow,prefix2+"bkg_no").substring(0,10)+splitNo){
					ret=GetCellValue(iRow,prefix2+"bkg_no");
					break;
				}
			}
		}
		return ret;
	}
	/*
	* Form, Grid 
	*/
	function iniFormSheet(){
		
		orgSplit="";
		strSheetTitle3="|TS|Q'ty";
		strSheetTitle4="|CNTR|TS|ST|AS";
		strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
            ComEndConfigSheet(sheetObjects[i]);
        }
	
		sheetObjects[2].SetExtendLastCol(0);
		sheetObjects[3].SetExtendLastCol(0);
	
		
		ComBtnDisable("btn_dg");
		ComBtnDisable("btn_rf");
		ComBtnDisable("btn_ak");
		ComBtnDisable("btn_bb");	
		
		
	}
	/*
	*Booking split
	*/
	function loadInitSheet(orgSplit,flag){  
		for(var i=1;i<sheetObjects.length;i++){
			//sheetObjects[i].RenderSheet(0);
			sheetObjects[i].RemoveAll();
			sheetObjects[i] = sheetObjects[i].Reset();
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,false);
			if (i==2){ //sheet3 head Col setting
				//if (ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
					var cols = SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty|"+orgSplit),prefix3);
					sheetJson_3 = sheetJson_3.concat(cols);
					sheetObjects[i] = sheetObjects[i].Reset();
					initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,true);
					//mds
				//}else{
				//	SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty"),prefix3);
				//}
			}
			if (flag){
				if (i==3){ //sheet4 head Col setting
					//if (ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						var cols = SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS|"+orgSplit),prefix4);
						sheetJson_4 = sheetJson_4.concat(cols);
						sheetObjects[i] = sheetObjects[i].Reset();
						initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,true);
					//}else{
					//	SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS"),prefix4);
					//}
				}
			} 
			ComEndConfigSheet(sheetObjects[i]);
			//sheetObjects[i].RenderSheet(1);
        }
		//sheetObjects[2].SetExtendLastCol(0);
		//sheetObjects[3].SetExtendLastCol(0);
	}
	/*
	* Sheet to Array
	*/
	function SheetToArrary(sheetObj){
//no support[check again]CLT 		var tmpSheet=new Array(sheetObj.Rows);
//no support[check again]CLT 		for (var iRow=0;iRow<sheetObj.Rows;iRow++){
		var tmpSheet=new Array(sheetObj.LastRow());
		for (var iRow=0;iRow<sheetObj.LastRow();iRow++){
			tmpSheet[iRow]=new Array(sheetObj.LastCol()+1);
		}
//no support[check again]CLT 		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
		for(var iRow=0;iRow<sheetObj.LastRow();iRow++){
			 for(var iCol=0;iCol<sheetObj.LastCol()+1;iCol++){
				 tmpSheet[iRow][iCol]=sheetObj.GetCellValue(iRow+1,iCol);//check again
			 }
		}
		 return tmpSheet;
	}
	/*
	* Array to sheet
	*/
	function ArrayToSheet(sheetObj,arr){
		for(var iRow=0;iRow<arr.length;iRow++){
			sheetObj.DataInsert(-1);
		}
		if(sheetObj.RowCount()>0){
			for(var iRow=0;iRow<arr.length;iRow++){
				 for(var iCol=0;iCol<arr[iRow].length;iCol++){
					 sheetObj.SetCellValue(iRow+1,iCol,arr[iRow][iCol]+"");
				 }
			}
		}
	}
    /*
	* sheet split
	*/
	function sheet_splitSet(splitreason,lastno,splitcount){
		var formObj=document.form;
		if (orgSplit.length>1 && splitreason.toUpperCase()=="C"){
			if(ComGetObjValue(formObj.bkg_no).length==12){
				strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+ComGetObjValue(formObj.bkg_no).substring(10,12));
			}else{
				strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			}
			if (!ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))){
				if(ComGetObjValue(formObj.bkg_no).length==12){
					strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+ComGetObjValue(formObj.bkg_no).substring(10,12));
				}else{
					strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
				}
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}else{
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			if (!ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))){
				strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}
		var tmpSheet3=SheetToArrary(sheetObjects[2]);
		var tmpSheet4=SheetToArrary(sheetObjects[3]); 
        var tmpSheet5=SheetToArrary(sheetObjects[4]); 
        if (!ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))){
			loadInitSheet(orgSplit,true);
			ArrayToSheet(sheetObjects[3],tmpSheet4);
		}else{
			loadInitSheet(orgSplit,false);
		}
		 ArrayToSheet(sheetObjects[2],tmpSheet3);         
		 ArrayToSheet(sheetObjects[4],tmpSheet5);		 
	}
	/*
	* sheet image setting
	*/
	function sheet_imageSet(sheetObj,Col){
		sheetObj.SetColHidden(prefix2+"pc",0);
//no support[check again]CLT 		for(var i=1;i<sheetObj.Rows;i++){
		for(var i=1;i<sheetObj.LastRow()+1;i++){
			sheetObj.SetCellValue(i,Col,0);
		}
		
	}
	/*
	* Keypress event
	*/
//	function bkg0099_keypress(){
//		obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat; 
//	    switch(obj.dataformat){ 
//	        case "num": 
//	        	ComKeyOnlyNumber(event.srcElement);
//	            break;	 
//			 case "engup": 
//				 ComKeyOnlyAlphabet('uppernum'); 
//	            break; 
//	    }
//		var btnObj=null;
//		switch(ComGetEvent("name")){  
//			case "bkg_no": 
//				if(ComIsEmpty(obj.value)) { return; }
//				if(event.keyCode == 13 && obj.value.length > 10){
//					btnObj=document.getElementById("btn_retrieve");
//					if (btnObj) { btnObj.fireEvent("onclick"); }
//				}
//		}
//	}

	/*
	* auto volume
	*/
	function autoVolume(splitNo,splitreason,lastno,splitcount){
		var colTile="";
//		var fWgt=ComTrunc(ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"act_wgt"),3)/splitNo,3);
		var fWgt = Math.floor((sheetObjects[0].GetCellValue(1,prefix1+"act_wgt") / splitNo)*1000)/1000;
		
		var fWgtLast=0;
		//var fPkg =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"pck_qty"),2)/splitNo,2);
		//2015.03.04 Decimal number is not allowed to package qty.
		//var fPkg=ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty")/splitNo);
		var splitMod=sheetObjects[0].GetCellValue(1,prefix1+"pck_qty") % splitNo;
		var fMinPkg=(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty") - splitMod)/splitNo;
		var fPkg=0;
		var fPkgLast=0;
		var fMea=ComTrunc(ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"meas_qty"),2)/splitNo,2);
		var fMeaLast=0;
		var newBkgNo=ComGetObjValue(document.form.bkgsplitno);
		if (newBkgNo.length<1){
			newBkgNo=sheetObjects[0].GetCellValue(1,prefix1+"bkg_no");
		}else{
			newBkgNo=ComGetObjValue(document.form.bkgsplitno);
		}
		var newSplitBkgNo=getSplitBkgNo(splitreason,lastno,splitcount+lastno,sheetObjects[0].GetCellValue(1,prefix1+"bkg_no"),newBkgNo);

		with(sheetObjects[1]){
			for(var i=0;i<splitNo;i++){
				fPkg=0;
				DataInsert(-1);
				SetCellValue(i+1,prefix2+"bkg_no",newSplitBkgNo[i]);

				if(document.form.bl_no.value.length == 10){
					var toyota_bl_no = document.form.bl_no.value;
					if(i > 0){
						var sXml = sheetObjects[1].GetSearchData("ESM_BKG_0079_01GS.do?f_cmd="+SEARCH03, null);
						toyota_bl_no = ComGetEtcData(sXml, "toyota_bl_no");
					}
					SetCellValue(i+1, prefix2+"bl_no", toyota_bl_no );
				}else{
					SetCellValue(i+1, prefix2+"bl_no", newSplitBkgNo[i] );
				}
				
				SetCellValue(i+1,prefix2+"tvvd",sheetObjects[0].GetCellValue(1,prefix1+"tvvd"));
				if ((splitNo-1)==i){
					var lstCalFWgt = sheetObjects[0].GetCellValue(1,prefix1+"act_wgt")-fWgtLast;
					SetCellValue(i+1,prefix2+"act_wgt",Math.round(lstCalFWgt*1000)/1000,0);
					SetCellValue(i+1,prefix2+"pck_qty",ComParseInt(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty")==""?0:sheetObjects[0].GetCellValue(1,prefix1+"pck_qty"))-ComTrunc(fPkgLast),0);
					var measQty = ((sheetObjects[0].GetCellValue(1,prefix1+"meas_qty")*100) - fMeaLast) / 100;
					SetCellValue(i+1,prefix2+"meas_qty", measQty, 0);
				}else{
					if(splitMod>=1){
						fPkg=fMinPkg+1;
						splitMod-=1;
					}else{
						fPkg=fMinPkg;
					}
					SetCellValue(i+1,prefix2+"act_wgt",fWgt,0);
					SetCellValue(i+1,prefix2+"pck_qty",fPkg,0);

					SetCellValue(i+1,prefix2+"meas_qty",fMea,0);
					fWgtLast+=fWgt;
					fPkgLast+=fPkg;
					fMeaLast+= (fMea*100);
				}
				SetCellValue(i+1,prefix2+"wgt_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"wgt_ut_cd"),0);
				SetCellValue(i+1,prefix2+"pck_tp_cd",sheetObjects[0].GetCellValue(1,prefix1+"pck_tp_cd"),0);
				SetCellValue(i+1,prefix2+"meas_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"meas_ut_cd"),0);
			}
		}
		
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);
		//Qty split no
//no support[check again]CLT 		for(var iRow=0;iRow<sheetObjects[2].Rows-1;iRow++){
		for(var iRow=0;iRow<sheetObjects[2].LastRow();iRow++){
			var fQty=ComTrunc(ComTrunc(sheetObjects[2].GetCellValue(iRow+1,prefix3+"op_cntr_qty"),2)/splitNo,2);
		    var fQtyLast=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				
				if (iCol==ComCountHeadTitle(strSheetTitle3)-1){
					var newQty = ((sheetObjects[2].GetCellValue(iRow+1,prefix3+"op_cntr_qty")*100) - fQtyLast) / 100;
					newQty = Math.round(newQty*100)/100;
					if(newQty==0 || newQty<0) newQty=0.01;
					sheetObjects[2].SetCellValue(iRow+1,iCol,newQty,0);
				}else{
					sheetObjects[2].SetCellValue(iRow+1,iCol,fQty,0);
					fQtyLast += (fQty*100);
				}
				
			}
		}
				 
	}
	/*
	* manual Volume
	*/
	function manualVolume(splitNo,splitreason,lastno,splitcount){
		var colTile="";
		var newBkgNo=ComGetObjValue(document.form.bkgsplitno);
		if (newBkgNo.length<1){
			newBkgNo=sheetObjects[0].GetCellValue(1,prefix1+"bkg_no");
		}else{
			newBkgNo=ComGetObjValue(document.form.bkgsplitno);
		}
		var newSplitBkgNo=getSplitBkgNo(splitreason,lastno,splitcount+lastno,sheetObjects[0].GetCellValue(1,prefix1+"bkg_no"),newBkgNo);
		
		with(sheetObjects[1]){
			for(var i=0;i<splitNo;i++){
				DataInsert(-1);
				SetCellValue(i+1,prefix2+"bkg_no",newSplitBkgNo[i]);
				
				if(document.form.bl_no.value.length == 10){
					var toyota_bl_no = document.form.bl_no.value;
					if(i > 0){
						var sXml = sheetObjects[1].GetSearchData("ESM_BKG_0079_01GS.do?f_cmd="+SEARCH03, null);
						toyota_bl_no = ComGetEtcData(sXml, "toyota_bl_no");
					}
					SetCellValue(i+1, prefix2+"bl_no", toyota_bl_no );
				}else{
					SetCellValue(i+1, prefix2+"bl_no", newSplitBkgNo[i] );
				}
				
				SetCellValue(i+1,prefix2+"tvvd",sheetObjects[0].GetCellValue(1,prefix1+"tvvd"));
				SetCellValue(i+1,prefix2+"wgt_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"wgt_ut_cd"));
				SetCellValue(i+1,prefix2+"pck_tp_cd",sheetObjects[0].GetCellValue(1,prefix1+"pck_tp_cd"));
				SetCellValue(i+1,prefix2+"meas_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"meas_ut_cd"));
				
				SetCellValue(i+1,prefix2+"act_wgt",0);
				SetCellValue(i+1,prefix2+"pck_qty",0);
				SetCellValue(i+1,prefix2+"meas_qty",0);
			}
		}
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);
		//Qty split no
//no support[check again]CLT 		for(var iRow=0;iRow<sheetObjects[2].Rows-1;iRow++){
		for(var iRow=0;iRow<sheetObjects[2].LastRow();iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
					sheetObjects[2].SetCellValue(iRow+1,iCol,0,0);
			}
		}		
		
	}	
	/*
	* PC process
	*/
	function pcProcess(sheetObj,Row, Col, Value, prefix){
		var formObj=document.form;
		if(sheetObj.GetCellValue(Row, prefix+"tvvd").length==0){
			ComShowCodeMessage("BKG00833");
			return;
		}
		if (Row>0 && sheetObj.ColSaveName(Col) == prefix+"pc"){
			ComSetObjValue(formObj.pcIdx,Row-1);
			doActionIBSheet(sheetObj,document.form,COMMAND02);
		}
	}
	/*
	* Sheet2 OnClick event
	*/
	function sheet2_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		if (sheetObj.ColSaveName(Col)==prefix2+"pc"){   //T.VVD
			pcProcess(sheetObj,Row, Col, Value,prefix2);
		}
	}
	/*
	* Sheet2 OnChange event
	*/
	function sheet2_OnChange(sheetObj,Row, Col,Value){
		if (sheetObj.ColSaveName(Col)==prefix2+"tvvd"){   //T.VVD
			SheetOnAfterEditSet(sheetObj,document.form,Row,Col,prefix2);
		}		
	}
	/*
	* Sheet3 OnChange event
	*/
	function sheet3_OnChange(sheetObj, Row, Col, Value){
		var formObj=document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo=ComParseInt(formObj.splitcount); 
		Value += "";
		var iflag = Value.split(".");
		if (iflag.length > 1){
			 if (ComParseInt(iflag[1])>0){ 
				 ComSetObjValue(formObj.partialflag,"Y");
			 }else{
				ComSetObjValue(formObj.partialflag,"");
			 }
		}else{
			ComSetObjValue(formObj.partialflag,"");
		}
		
//		for (var i=0; i < ComCountHeadTitle(strSheetTitle3); i++ ){
//			console.log(sheetObj.GetCellValue(Row,i))
//		}
		
//		fQtyDiv = ComCountHeadTitle(strSheetTitle3)-Col-1;
//		for (var iCol=Col+1;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
//			sheetObj.SetCellValue(Row,iCol,ComTrunc((ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-ComTrunc(sheetObj.GetCellValue(Row,Col),2))/fQtyDiv,2),0);
//		}
//		for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
//			fQtySum +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
//			if (iCol<ComCountHeadTitle(strSheetTitle3)-1){
//				fQtySub +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
//			}			
//		}
//        if (Col != sheetObj.LastCol()){
//        	sheetObj.SetCellValue(Row,sheetObj.LastCol(),ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-fQtySum,0);
//		}
//        if (ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2))>=0.05
//        		|| ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2))<=-0.05){
//				ComShowCodeMessage("BKG00642");
//				sheetObj.SetCellValue(Row,Col,0,0);
//				return false;
//		}
//        sheetObj.SetCellValue(Row,sheetObj.LastCol(),ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2),0);
	}
	
	function sheet3_OnAfterEdit(sheetObj, Row, Col){
		var formObj = document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo = ComParseInt(formObj.splitcount);
		var fQtySum = 0;
		var fQtySub = 0; 
		
		fQtySub = sheetObj.GetCellValue(Row,2) * 100;
		for (var i=3; i < ComCountHeadTitle(strSheetTitle3)-1; i++ ){
			fQtySum += sheetObj.GetCellValue(Row,i) * 100;
		}
		
		var total = (fQtySub - fQtySum) / 100;
		sheetObj.SetCellValue(Row, sheetObj.LastCol(), total, 0);
	}
	
	
	function SheetColOneRadioCheck(sheetObj,Row,Col,Value,sheetTitle){
			var flag=false;
			for (var iCol=0;iCol<ComCountHeadTitle(sheetTitle);iCol++ ){
				if(typeof(sheetObj.GetCellValue(Row,iCol).length) =="undefined"){
					if (sheetObj.GetCellValue(Row,iCol)==1){
						 flag=true;
					 } 
				 }
			 }
			if(flag){
				for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
					if(typeof(sheetObj.GetCellValue(Row,i).length) =="undefined"){
						 if (sheetObj.ColSaveName(Col)==sheetObj.ColSaveName(i)){
							  sheetObj.SetCellValue(Row,sheetObj.ColSaveName(Col),Value,0);
						 }else{
							 sheetObj.SetCellValue(Row,sheetObj.ColSaveName(i),0,0);
						 }
					 }
				 }
			}else{
				sheetObj.SetCellValue(Row,Col,1,0);
			}
		}
	function sheet4_OnChange(sheetObj,Row,Col,Value){
		ComSetObjValue(document.form.cntrPopExists,"N");
		dgSelectFlg="N";
		rfSelectFlg="N";
		akSelectFlg="N";		
	} 
	function SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix){
		if (sheetObj.ColSaveName(Col)==prefix+"tvvd"){   //T.VVD
			if(sheetObj.GetCellValue(Row,prefix+"tvvd")==null){
				sheetObj.SetColHidden(prefix+"pc",0);
				sheetObj.SetCellValue(Row,prefix+"pc",0,0);
			} else if (ComGetObjValue(formObj.tvvd).toUpperCase() != sheetObj.GetCellValue(Row,prefix+"tvvd").toUpperCase()){
				sheetObj.SetColHidden(prefix+"pc",0);
				sheetObj.SetCellValue(Row,prefix+"pc",0,0);
			}else{
				sheetObj.SetCellValue(Row,prefix+"pc",1,0);
			}
		}
		if (ComIsContainsCharsOnly(sheetObj.GetCellValue(Row,prefix+"tvvd").toUpperCase(),"COXX")
		|| ComIsContainsCharsOnly(sheetObj.GetCellValue(Row,prefix+"tvvd").toUpperCase(),"COYY")
		|| ComIsContainsCharsOnly(sheetObj.GetCellValue(Row,prefix+"tvvd").toUpperCase(),"COZZ")){
			ComSetObjValue(formObj.pseudoVvdFlag,"Y");
		}else{
			ComSetObjValue(formObj.pseudoVvdFlag,"N");
		}
	}
	/*
	* Sheet1 onAfterEdit event
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
		var formObj=document.form;
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix1);
	}
	/*
	* Sheet2 onAfterEdit event
	*/
	function sheet2_OnAfterEdit(sheetObj,Row,Col){
		var formObj=document.form;
		var fActSum=0;
		var fPckSum=0;
		var fMeasSum=0; 
		 if (sheetObj.ColSaveName(Col)==prefix2+"act_wgt"
		    || sheetObj.ColSaveName(Col)==prefix2+"pck_qty"
			|| sheetObj.ColSaveName(Col)==prefix2+"meas_qty"){

			for(var idx=1;idx<sheetObj.LastRow();idx++){
				 fActSum+=ComTrunc(sheetObj.GetCellValue(idx,prefix2+"act_wgt"),3);
				 fPckSum+=ComTrunc(sheetObj.GetCellValue(idx,prefix2+"pck_qty"));
				 fMeasSum+=ComTrunc(sheetObj.GetCellValue(idx,prefix2+"meas_qty"),3);
			}
			
			if (ComTrunc(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"act_wgt"),3)-fActSum<0){
				ComShowCodeMessage("BKG00643");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
			
			if (ComParseInt(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"pck_qty"))-fPckSum<0){
				ComShowCodeMessage("BKG00644");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
			
			if (ComTrunc(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"meas_qty"),3)-fMeasSum<0){
				ComShowCodeMessage("BKG00645");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
			var lstfAct = ComTrunc(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"act_wgt"),3)-fActSum;
			sheetObj.SetCellValue(sheetObj.LastRow(),prefix2+"act_wgt", Math.round(lstfAct*1000)/1000);
			sheetObj.SetCellValue(sheetObj.LastRow(),prefix2+"pck_qty", ComTrunc(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"pck_qty"))-fPckSum);
			
			var lstfQty = ComTrunc(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),prefix1+"meas_qty"),3) - fMeasSum;
			sheetObj.SetCellValue(sheetObj.LastRow(),prefix2+"meas_qty", Math.round(lstfQty*1000)/1000);
		 }
		
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix2);
		var arr="";
		if (sheetObj.GetCellValue(Row,prefix2+"bkg_no").length==12){
			arr=sheetObj.GetCellValue(Row,prefix2+"bkg_no").substring(10,12);
		}else{
			arr="00";
		}
		for(var iRow=1;iRow<sheetObjects[3].LastRow()+1;iRow++){
			for(var iCol=5;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){ 
                var arrCol=sheetObjects[3].ColSaveName(iCol).split("_");
                if(arrCol[1]==arr && sheetObjects[3].GetCellValue(iRow,iCol)==1){
                	sheetObjects[3].SetCellValue(iRow,prefix4+"adv_shtg_cd",sheetObj.GetCellValue(Row,prefix2+"adv_shtg_cd"),0);
				}
			 }
		}
		  
	}
	/*
	* Sheet3 onAfterEdit event
	*/
//	function sheet3_OnAfterEdit(sheetObj,Row,Col){
//		var formObj=document.form;
//		if (ComIsNull(formObj.splitcount)) return;
//		var splitNo=ComParseInt(formObj.splitcount);
//		var fQtySum=0.00;
//		var fQtySub=0; 
//		var fQtyDiv=0.00;
//		fQtyDiv=ComCountHeadTitle(strSheetTitle3)-Col-1;
//		for (var iCol=Col+1;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
//			sheetObj.SetCellValue(Row,iCol,(ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-ComTrunc(sheetObj.GetCellValue(Row,Col),2))/fQtyDiv,0);
//		}
//		for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
//			fQtySum +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
//			if (iCol<ComCountHeadTitle(strSheetTitle3)-1){
//				fQtySub +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
//			}			
//		} 
//        if (Col != sheetObj.LastCol()){
//        	sheetObj.SetCellValue(Row,sheetObj.LastCol(),ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-fQtySum,0);
//		}
//        if (ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2))>=0.05
//        		|| ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2))<=-0.05){
//				ComShowCodeMessage("BKG00642");
//				sheetObj.SetCellValue(Row,Col,0,0);
//				return false;
//		}		
//	}	
	/*
	* Sheet4 onClick event
	*/
	function sheet4_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
		var arr="";
		 arr=sheetObj.ColSaveName(Col).split("_");
//no support[check again]CLT 		 for(var i=1;i<sheetObjects[1].Rows;i++){
		 for(var i=1;i<sheetObjects[1].LastRow()+1;i++){
			 if(sheetObjects[1].GetCellValue(i,prefix2+"bkg_no").substring(10,12)==arr[1]){
				 sheetObj.SetCellValue(Row,prefix4+"adv_shtg_cd",sheetObjects[1].GetCellValue(i,prefix2+"adv_shtg_cd"),0);
			 }
		 }	  
	}
	/*
	* Special Cargo Split Check
	*/
	function CheckPopValidate(sheetObj,btnName,formObject){
		if(!ComIsBtnEnable(btnName)) return false; 		 
		return true;
	}
	/*
	* Cntr  SplitNo check
	*/
	function Check_Cntr(sheetObj,prefix){
		for(var i=1;i<sheetObj.LastRow()+1;i++){
			sheetObj.SetCellValue(i,prefix,1,0);
		}
	}
	/**
    * CA Reason : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObject=document.form;
    	//01. CA ReasonCd, Remark 
    	var strRsnCd=nullToBlank(arrPopupData[0][2]);
    	var strRemark=nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
    	formObject.caRsnCd.value=strRsnCd;
        formObject.caRemark.value=strRemark;
        if(!ComIsNull(formObject.caRsnCd.value) && formObject.caRsnCd.value!=null 
				 && formObject.caRsnCd.value!="" && formObject.caRsnCd.value!='null'){
        	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
		}
    }
	/**
     * CA Reason : CaReasonModify
     */ 
    function setCAReasonMultiCallBack(arrPopupData) {
    	var formObject=document.form;
     	//01. CA ReasonCd, Remark 
     	var strRsnCd=nullToBlank(arrPopupData[0][2]);
     	var strRemark=nullToBlank(arrPopupData[0][3]);
     	//02. modifyCaReason(e) call
     	formObject.caRsnCd.value=strRsnCd;
     	formObject.caRemark.value=strRemark;
     	if(!ComIsNull(formObject.caRsnCd.value) && formObject.caRsnCd.value!=null 
 				 && formObject.caRsnCd.value!="" && formObject.caRsnCd.value!='null'){
         	doActionIBSheet(sheetObjects[0],formObject,COMMAND05);
 		}
     }
	// ESD_PRD_018 Return value.(PCTL_NO)
	function callBackEsdPrd0080(pctlNo){
		var formObject=document.form;
		var row=sheetObjects[1].GetSelectRow();
		if(pctlNo.length<20){
			sheetObjects[1].SetCellValue(row, prefix2+"pctl_no","");
		} else {
			var arrXml=pctlNo.split("|");			
			sheetObjects[1].SetCellValue(row, prefix2+"pctl_no",arrXml[0]);
		}
	}
	
    
    function bkg0099_keydown(){
		 var keyValue=ComGetEvent("keycode");
		 var formObject=document.form;
		 if(keyValue == 13){
			 if (formObject.bkg_no.value != "") {
				try {
					initData();					
					if(ComIsEmpty(formObject.bkg_no)){
						ComShowCodeMessage("BKG08019");
						return;
					}
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);					
					
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_save2");
				} catch(err) { ComFuncErrMsg(err.message); }
			 }
		 }
	 }


    //Cotrol mamximum bkg split number.
    function splitTotalControl(splitReason, splitCount, lastSplitNo){
    	
    	var lastRow = sheetObjects[1].LastRow();
    	var modiSplitCount = splitCount; 	
    	if(splitReason == "C"){
    		//Start from lastSplitNo +1
    		if(lastSplitNo + splitCount > 90){
    			modiSplitCount = 90 - lastSplitNo;
    		}
    	} else if(splitReason == "M"){
    		//Start from  lastSplitNo
    		if(lastSplitNo + splitCount > 100){
    			modiSplitCount = 99 - lastSplitNo + 1;
    		}
    	}
    	
    	if(modiSplitCount != splitCount){
    		ComShowCodeMessage("BKG95001","check split count again.","Split count changed to limit line - Maximum 90 for Customer, Maximum 9 for Memo B/L ");
    	}
    	return modiSplitCount;
    }