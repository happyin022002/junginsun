/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0997.js
*@FileTitle  : COD Comfirm Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0997 : business script for ESM_BKG_0997
     */
    function ESM_BKG_0997() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
var prefix6="sheet6_";
var sheetObjects=new Array();
var sheetCnt=0;
var orgSplit="";
var asCodeList="";
var asTextList="";
var strSheetTitle2=" |Move|Booking No.|B/L No.|T/VVD|Weight|Weight|Package|Package|Measure|Measure|AS||";
var strSheetTitle3="|TS|Q'ty ";
var strSheetTitle4="|CNTR|TS|ST|AS";
var strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
//sheet Json 정보 임시 저장 변수
var sheetJson_3 = "";
var sheetJson_4 = "";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
	function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        /*******************************************************/
        var formObj=document.form;
		var param="";
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_ok":
					if (ComGetObjText(formObj.bdr_flag)=="Y"){
						comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C");
//						if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
//							doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
//            			}
					} else {
						doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
					}					     
				break; 
				case "btn_close":
					ComClosePopup(); 
				break;                                
            } // end switch
    	} catch(e) {
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
    function loadPage(asCode,asText) {
        asCodeList=" |"+asCode;
		asTextList=" |"+asText;
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true,false);
			ComEndConfigSheet(sheetObjects[i]);
        }
		 axon_event.addListenerForm('click', 'bkg0997_click', document.form); 
		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 setTimeout("doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);", 100);
    }
  /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo,asCodeList,asTextList,flag,sheetJsonFlag) {
        var cnt=0;
        switch(sheetNo) {
        case 1:      //sheet1 init // org booking info
        with(sheetObj){
        	
                var HeadTitle="|BKG|B/L No.|T/VVD|Weight|Weight|Package|Package|Measure|Measure|AS|";

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"tvvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"act_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"adv_shtg_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetColProperty(prefix1+"adv_shtg_cd", {ComboText:asTextList, ComboCode:asCodeList} );
                SetEditable(1);
                SetImageList(0,"img/btng_pc.gif");
                SetColHidden(prefix1+"pc",1);
                SetVisible(0);

                }
                break;
        		
        	case 2:      //sheet2 init//split info
        			with(sheetObj){
	             
	         
	           var HeadTitle1=strSheetTitle2;
	           var headCount=ComCountHeadTitle(HeadTitle1);
	
	           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	           var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	           InitHeaders(headers, info);
	
	           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
						 {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"move",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"tvvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
						 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"act_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"adv_shtg_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rtn_route",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"pc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            
	           InitColumns(cols);
	
	           SetEditable(1);
	           SetCountPosition(0);
	           SetSheetHeight(120);
	          }
	           break;
        		case 3:      //sheet3 init
                   with(sheetObj){

           var HeadTitle1=strSheetTitle3;
           var headCount=ComCountHeadTitle(HeadTitle1);

           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

           var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
           InitHeaders(headers, info);

           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ibflag" },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix3+"op_cntr_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
					                                   if(orgSplit.length>1){
           cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix3+orgSplit,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
           }
			if(sheetJsonFlag){
				InitColumns(sheetJson_3);
			}else{
				InitColumns(cols);
				sheetJson_3 = cols;
			}		                                   

           SetEditable(1);
           SetCountPosition(0);
           SetSheetHeight(120);
                   }
           break;
        		case 4:      //sheet4 init
        			with(sheetObj){
	  
                       var HeadTitle1=strSheetTitle4;
                       var headCount=ComCountHeadTitle(HeadTitle1);

                       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

                       var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
                       var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                       InitHeaders(headers, info);

                       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"ibflag" },
            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix4+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"adv_shtg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                               if(flag &&  orgSplit.length>1){
                       cols.push({Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix4+orgSplit,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                       }
                       if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
                       SetColHidden(prefix4+"adv_shtg_cd",1);
                       }

                       if(sheetJsonFlag){
 				    	  InitColumns(sheetJson_4);
 				       }else{
 				    	  InitColumns(cols);
 				    	  sheetJson_4 = cols;
 				       }
                       SetColProperty(prefix4+"adv_shtg_cd", {ComboText:asTextList, ComboCode:asCodeList} );
                       SetEditable(1);
                       SetCountPosition(0);
                       SetVisible(0);

        		}
        		break;
        		case 5:      //sheet5 init
               with(sheetObj){
                          
                  
                   var HeadTitle1=strSheetTitle5;
                   var headCount=ComCountHeadTitle(HeadTitle1);

                   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

                   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
                   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                   InitHeaders(headers, info);

                   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix5+"ibflag" },
					        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix5+"dcgo_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                   InitColumns(cols);

                   SetEditable(1);
                   SetCountPosition(0);
                   SetVisible(0);

                   	}
                   break;
        		case 6:  //sheet6 init
                   with(sheetObj){
                              
               var HeadTitle="|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"ibflag" },
					    {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix6+"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					    {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"bkg_no" },
					    {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"cod_rqst_seq" },
					    {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix6+"vvd_op_cd" } ];
					                
               InitColumns(cols);

               SetEditable(1);
               SetCountPosition(0);
               SetVisible(0);
               }
               break;

        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet6_","sheet2_");
        switch(sAction) {
          case IBSEARCH:      //retrieve
	         formObj.f_cmd.value=SEARCH; 
			 var codParam=ComGetObjValue(formObj.paramVvd);
			 sheetObj.SetWaitImageVisible(0);
			 ComOpenWait(true);			   
			 var sXml=sheetObj.GetSearchData("ESM_BKG_0997GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix)+ codParam);
			 ComOpenWait(false);
			 var arrXml=sXml.split("|$$|");
			 if (ComGetTotalRows(arrXml[0]) == 0) ComShowCodeMessage("BKG00889");
			 iniFormSheet(); 
			 for(var i=0; i < arrXml.length; i++){ 
				if(i==0){
					if(i > 0) {
						sheetObjects[i].SetWaitImageVisible(0);
					}  
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}else{
					if(i > 0) {
						sheetObjects[i+1].SetWaitImageVisible(0);
					}
					sheetObjects[i+1].LoadSearchData(arrXml[i],{Sync:1} );
				}
			} 
			if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit="91";
				}else{
					orgSplit="00";
				}
			}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit=sheetObj.GetEtcData("memoSplitNo");
				}else{
//					orgSplit=sheetObj.GetEtcData("custSplitNo");
					orgSplit=ComGetObjValue(formObj.bkg_no).substring(10,12);
				}
			}
			ComSetObjValue(formObj.rtn_route, sheetObj.GetEtcData("rtn_route"));
			setFormData(formObj,sheetObj);
			var splitCnt=0; 
			splitCnt=ComParseInt(formObj.splitcount)-1;
			sheet_splitSet(ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			autoVolume(ComParseInt(formObj.splitcount),ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].GetCellValue(2,prefix2+"bkg_no").substring(10));
			sheetObjects[1].SetCellValue(2,prefix2+"move",1,0);
			break;
		 case IBSAVE:        //Save
			formObj.f_cmd.value=MULTI;
 		 	for(i=1; i<sheetObjects[1].HeaderRows()+sheetObjects[1].RowCount();i++){
		 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
		 			if(sheetObjects[1].GetCellValue(i, prefix2+"bkg_no").substring(10)=="90"){
		 				ComShowCodeMessage("BKG00884");
		 				return;
		 			}
		 		} else {
		 			if(sheetObjects[1].GetCellValue(i, prefix2+"bkg_no").substring(10)=="100"){
		 				ComShowCodeMessage("BKG00884");
		 				return;		 	
		 			}
		 		}
		 	}
			setQtyCntrCgoVar(formObj);
			var rtnRoute=ComGetObjValue(formObj.rtn_route);
			if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
				sheetObjects[1].SetCellValue(2, prefix2+"rtn_route",rtnRoute,0);
			}else{
				sheetObjects[1].SetCellValue(2, prefix2+"rtn_route",rtnRoute,0);
			}
			var params=FormQueryString(formObj);
            params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
			params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
			params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
			params=params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
			params=params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
 			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0997GS.do", params);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			sheetObjects[1].LoadSaveData(sXml);
			if(State == "S"){
				var opener = window.dialogArguments;
				if (!opener) opener = parent;
				opener.callSearch();
				ComClosePopup(); 
			}
		break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
	/*
	* initializing Form, Grid
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
	}
	/*
	* Click event handling
	*/
	function bkg0997_click(){
		obj=event.srcElement;
		formObj=document.form;
		var lastSplitNo = "";
	    if (obj.name=="splitreason"){
			var splitCnt=0;
			if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit="91";
				}else{
					orgSplit="00";
				}
				lastSplitNo = orgSplit;
			}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit=ComGetObjValue(formObj.memoSplitNo); 
					lastSplitNo = orgSplit;
				}else{
//					orgSplit=ComGetObjValue(formObj.custSplitNo); 
					orgSplit=ComGetObjValue(formObj.bkg_no).substring(10,12);
					lastSplitNo = ComGetObjValue(formObj.custSplitNo);
				}
			}
//			ComSetObjValue(formObj.lastSplitNo,orgSplit); 
			ComSetObjValue(formObj.lastSplitNo,lastSplitNo); 
			splitCnt=ComParseInt(formObj.splitcount)-1;
			sheet_splitSet(ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			autoVolume(ComParseInt(formObj.splitcount),ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
				Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].GetCellValue(3,prefix2+"bkg_no").substring(10));
				sheetObjects[1].SetCellValue(1, prefix2+"act_wgt",sheetObjects[0].GetCellValue(1, prefix1+"act_wgt"),0);
				sheetObjects[1].SetCellValue(1, prefix2+"wgt_ut_cd",sheetObjects[0].GetCellValue(1, prefix1+"wgt_ut_cd"),0);
				sheetObjects[1].SetCellValue(1, prefix2+"pck_qty",sheetObjects[0].GetCellValue(1, prefix1+"pck_qty"),0);
				sheetObjects[1].SetCellValue(1, prefix2+"pck_tp_cd",sheetObjects[0].GetCellValue(1, prefix1+"pck_tp_cd"),0);
				sheetObjects[1].SetCellValue(1, prefix2+"meas_qty",sheetObjects[0].GetCellValue(1, prefix1+"meas_qty"),0);
				sheetObjects[1].SetCellValue(1, prefix2+"meas_ut_cd",sheetObjects	[0].GetCellValue(1, prefix1+"meas_ut_cd"),0);
				sheetObjects[1].SetRowEditable(1,0);
			}else{
				Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].GetCellValue(2,prefix2+"bkg_no").substring(10));
			}
			sheetObjects[1].SetCellValue(2,prefix2+"move",1,0);
	    } 
	}
//	 function getSplitBkgNo1(splitreason,lastno,splitcount,orgBkgNo,bkgNo){
//		var imeno=0;
//		var newSplitBkgNo=new Array();
//		var idx=0;
//        
//		for (var i=lastno;i<=splitcount;i++ ){
//			 if(splitreason.toUpperCase() =="C"){
//				if(idx==0){
//					newSplitBkgNo[idx]=orgBkgNo;
//				}else{
//					newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"0");
//				}
//				if(i=="90"){
//					ComShowCodeMessage("BKG00884");
//					return null;
//				}
//			 }else{
//				newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"9");
//				if(i=="100"){
//					ComShowCodeMessage("BKG00884");
//					return null;
//				}
//			 }
//			 idx++;
//		}
//		return newSplitBkgNo;
//	}
	/*
	* automatically Volume divide
	*/
	function autoVolume(splitNo,splitreason,lastno,splitcount){
		var colTile="";
		var fWgt=ComTrunc(ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"act_wgt"),3)/splitNo,3);
		var fWgtLast=0;
		var fPkg=ComParseInt(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty")/splitNo);
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
				if (splitreason.toUpperCase()=="M"){
					if (i==0){
						DataInsert(-1);
						SetCellValue(i+1,prefix2+"bkg_no",sheetObjects[0].GetCellValue(1,prefix1+"bkg_no"));
						SetCellValue(i+1,prefix2+"bl_no",sheetObjects[0].GetCellValue(1,prefix1+"bl_no"));
					}
					DataInsert(-1);
					SetCellValue(i+2,prefix2+"bkg_no",newSplitBkgNo[i]);
					SetCellValue(i+2,prefix2+"bl_no",newSplitBkgNo[i]);
					SetCellValue(i+2,prefix2+"tvvd",sheetObjects[0].GetCellValue(1,prefix1+"tvvd"));
					if ((splitNo-1)==i){
						SetCellValue(i+2,prefix2+"act_wgt",ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtLast,3),0);
						SetCellValue(i+2,prefix2+"pck_qty",ComParseInt(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty"))-fPkgLast,0);
						SetCellValue(i+2,prefix2+"meas_qty",ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"meas_qty"),2)-ComTrunc(fMeaLast,2),0);
					}else{
						SetCellValue(i+2,prefix2+"act_wgt",fWgt,0);
						SetCellValue(i+2,prefix2+"pck_qty",fPkg,0);
						SetCellValue(i+2,prefix2+"meas_qty",fMea,0);
						fWgtLast+=fWgt; 
						fPkgLast+=fPkg;
						fMeaLast+=fMea;
					}
					SetCellValue(i+2,prefix2+"wgt_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"wgt_ut_cd"),0);
					SetCellValue(i+2,prefix2+"pck_tp_cd",sheetObjects[0].GetCellValue(1,prefix1+"pck_tp_cd"),0);
					SetCellValue(i+2,prefix2+"meas_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"meas_ut_cd"),0);
				}else{
					DataInsert(-1);
					SetCellValue(i+1,prefix2+"bkg_no",newSplitBkgNo[i]);
					//colTile=ComLpad(i,2,"0");
					//CellValue(i+1,prefix2+"bkg_no_split") = colTile;
					SetCellValue(i+1,prefix2+"bl_no",newSplitBkgNo[i]);
					SetCellValue(i+1,prefix2+"tvvd",sheetObjects[0].GetCellValue(1,prefix1+"tvvd"));
					if ((splitNo-1)==i){
						SetCellValue(i+1,prefix2+"act_wgt",ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtLast,3),0);
						SetCellValue(i+1,prefix2+"pck_qty",ComParseInt(sheetObjects[0].GetCellValue(1,prefix1+"pck_qty"))-fPkgLast,0);
						SetCellValue(i+1,prefix2+"meas_qty",ComTrunc(sheetObjects[0].GetCellValue(1,prefix1+"meas_qty"),2)-ComTrunc(fMeaLast,2),0);
					}else{
						SetCellValue(i+1,prefix2+"act_wgt",fWgt,0);
						SetCellValue(i+1,prefix2+"pck_qty",fPkg,0);
						SetCellValue(i+1,prefix2+"meas_qty",fMea,0);
						fWgtLast+=fWgt; 
						fPkgLast+=fPkg;
						fMeaLast+=fMea;
					}
					SetCellValue(i+1,prefix2+"wgt_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"wgt_ut_cd"),0);
					SetCellValue(i+1,prefix2+"pck_tp_cd",sheetObjects[0].GetCellValue(1,prefix1+"pck_tp_cd"),0);
					SetCellValue(i+1,prefix2+"meas_ut_cd",sheetObjects[0].GetCellValue(1,prefix1+"meas_ut_cd"),0);
				}
			}
		}
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);

		//Qty split no
 		for(var iRow=0;iRow<sheetObjects[2].LastRow();iRow++){
 			var fQty=ComTrunc(ComTrunc(sheetObjects[2].GetCellValue(iRow+1,prefix3+"op_cntr_qty"),2)/splitNo,2);
		    var fQtyLast=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				if (iCol==ComCountHeadTitle(strSheetTitle3)-1){
					sheetObjects[2].SetCellValue(iRow+1,iCol,ComTrunc(sheetObjects[2].GetCellValue(iRow+1,prefix3+"op_cntr_qty"),2)-ComTrunc(fQtyLast,2),0);
				}else{
					sheetObjects[2].SetCellValue(iRow+1,iCol,fQty,0);
					fQtyLast+=fQty;
				}
			}
		}
	}
	/*
	* Qty,Cntr,Spc CGO SplitNo variable process
	*/
	function setQtyCntrCgoVar(formObj){
		var arr="";
		var dgArr="";
		var rfArr="";
		var akArr="";
		var bbArr="";
		var strNo="";
		var ichk=0;
		var tmpbkgno="";
		var tmpCntrNo="";
		var splitNo=ComParseInt(formObj.splitcount); 
 		for(var iRow=1;iRow<sheetObjects[2].HeaderRows()+sheetObjects[2].RowCount();iRow++){
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
		var keepDgRefNo = "N";
		if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
			keepDgRefNo = "Y";
		}
		
 		for(var iRow=1;iRow<sheetObjects[3].HeaderRows()+sheetObjects[3].RowCount();iRow++){
			ichk=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
				if (ichk==0){
					var strTmp=strSheetTitle4.split("|");
					strNo=["",strTmp[iCol]];
				}else{
					strNo=sheetObjects[3].ColSaveName(iCol).split("_");
				}
//				strNo = sheetObjects[3].ColSaveName(iCol).split("_");
				ichk++;
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					tmpbkgno=sheetObjects[1].GetCellValue(ichk+1,prefix2+"bkg_no");
				} else {
					tmpbkgno=sheetObjects[1].GetCellValue(ichk,prefix2+"bkg_no");
				}

				tmpCntrNo=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no");
				
				ifindRow=sheetObjects[4].FindText(prefix5+"cntr_no", sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no"));
				if(sheetObjects[3].GetCellValue(iRow,iCol)==1){
					arr+=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no")+":"+strNo[1]+":"+tmpbkgno+":"+sheetObjects[3].GetCellValue(iRow,prefix4+"adv_shtg_cd")+"~";
//					if (ifindRow>-1){
//						if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="DG"){
//							dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//						}else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="RF"){
//							rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//						}else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="AK"){
//							akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
//						}
//					}
					
					for(j=1;j<=sheetObjects[4].RowCount();j++){
						if((sheetObjects[4].GetCellValue(j, prefix5+"code")=="DG") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
							dgArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":"+keepDgRefNo+"~";						
						}else if((sheetObjects[4].GetCellValue(j, prefix5+"code")=="RF") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
							rfArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":X~";						
						}else if((sheetObjects[4].GetCellValue(j, prefix5+"code")=="AK") && (sheetObjects[4].GetCellValue(j, prefix5+"cntr_no")==tmpCntrNo)){
							akArr+=sheetObjects[4].GetCellValue(j,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(j,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+":X~";						
						}
					}
				 }else{
					 arr+=sheetObjects[3].GetCellValue(iRow,prefix4+"cntr_no")+"::"+tmpbkgno+":"+sheetObjects[3].GetCellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					 if (ifindRow>-1){
						 if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="DG"){
//							 dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
							 dgArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						 }else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="RF"){
//							 rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
							 rfArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						 }else if (sheetObjects[4].GetCellValue(ifindRow,prefix5+"code")=="AK"){
//							 akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].GetCellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
							 akArr+=sheetObjects[4].GetCellValue(ifindRow,prefix5+"cntr_no")+":::"+tmpbkgno+":X~";
						}
					}
				}
			}
		} 
		ComSetObjValue(formObj.cntrSplitNo,arr);
		ComSetObjValue(formObj.dgCntrSplitNo,dgArr);
		ComSetObjValue(formObj.rfCntrSplitNo,rfArr);
		ComSetObjValue(formObj.akCntrSplitNo,akArr);
	}
	 /*
	* sheet split process
	*/
	function sheet_splitSet(splitreason,lastno,splitcount){
		if (orgSplit.length>1 && splitreason.toUpperCase()=="C"){
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			if (!ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))){
				strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}else{
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
		}
		var tmpSheet3=SheetToArrary(sheetObjects[2]);
		var tmpSheet4=SheetToArrary(sheetObjects[3]); 
		var tmpSheet5=SheetToArrary(sheetObjects[4]); 
		if (!ComIsEmpty(sheetObjects[3].GetCellValue(1,prefix4+"cntr_no"))){
			loadInitSheet(orgSplit,true);
		}else{
			loadInitSheet(orgSplit,false);
		}
		 ArrayToSheet(sheetObjects[2],tmpSheet3);
         ArrayToSheet(sheetObjects[3],tmpSheet4);
		 ArrayToSheet(sheetObjects[4],tmpSheet5);
	}
	/*
	* Sheet data saves array data
	*/
	function SheetToArrary(sheetObj){
		var tmpSheet=new Array(sheetObj.LastRow());
		for (var iRow=0;iRow<sheetObj.LastRow();iRow++){
			tmpSheet[iRow]=new Array(sheetObj.LastCol()+1);
		}
		for(var iRow=0;iRow<sheetObj.LastRow();iRow++){
			 for(var iCol=0;iCol<sheetObj.LastCol()+1;iCol++){
				 tmpSheet[iRow][iCol]=sheetObj.GetCellValue(iRow+1,iCol);
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
	*Grid Setting for Booking split
	*/
	function loadInitSheet(orgSplit,flag){  
		for(var i=1;i<sheetObjects.length-1;i++){
//			sheetObjects[i].RenderSheet(0);
			sheetObjects[i].RemoveAll();
			sheetObjects[i]=sheetObjects[i].Reset();
            ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,false);
			if (i==2){ //sheet3 head Col setting
				var cols = SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty|"+orgSplit),prefix3);
				sheetJson_3 = sheetJson_3.concat(cols);
				sheetObjects[i] = sheetObjects[i].Reset();
				initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,true);
				//mds
			}
			if (flag){
				if (i==3){ //sheet4 head Col setting
					var cols = SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS|"+orgSplit),prefix4);
					sheetJson_4 = sheetJson_4.concat(cols);
					sheetObjects[i] = sheetObjects[i].Reset();
					initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag,true);
				}
			}
			ComEndConfigSheet(sheetObjects[i]);
//			sheetObjects[i].RenderSheet(1);
        }
		sheetObjects[2].SetExtendLastCol(0);
		sheetObjects[3].SetExtendLastCol(0);
	}
	/*
	* checking SplitNo when initializing Cntr
	*/
	function Check_Cntr(sheetObj,prefix,splitNo){
		var formObj=document.form;
		var sCntr=ComGetObjValue(formObj.codCntrNo);
		sheetObj.CheckAll(splitNo,0);
		sheetObj.CheckAll(prefix,0);
 		for(var i=1;i<sheetObj.HeaderRows()+sheetObj.RowCount();i++){
            if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
            	if (sCntr.indexOf(sheetObj.GetCellValue(i,prefix4+"cntr_no"))>-1){
					sheetObj.SetCellValue(i,prefix,1,0);
				}else{
					sheetObj.SetCellValue(i,splitNo,1,0);
				}
			}else{
				if (sCntr.indexOf(sheetObj.GetCellValue(i,prefix4+"cntr_no"))>-1){
					sheetObj.SetCellValue(i,splitNo,1,0);
				}else{
					sheetObj.SetCellValue(i,prefix,1,0);
				}
			}
		}
	}
	/*
	* substitute from Data to Form
	*/
	function setFormData(formObj,sheetObj){
		ComSetObjValue(formObj.bl_no,sheetObj.GetEtcData("bl_no"));
		ComSetObjValue(formObj.tvvd,sheetObj.GetEtcData("tvvd"));
		ComSetObjValue(formObj.por_cd,sheetObj.GetEtcData("por_cd"));
		ComSetObjValue(formObj.pol_cd,sheetObj.GetEtcData("pol_cd"));
		ComSetObjValue(formObj.pod_cd,sheetObj.GetEtcData("pod_cd"));
		ComSetObjValue(formObj.del_cd,sheetObj.GetEtcData("del_cd"));
		ComSetObjValue(formObj.stwg_cd,sheetObj.GetEtcData("stwg_cd"));
		ComSetObjValue(formObj.rail_blk_cd,sheetObj.GetEtcData("rail_blk_cd"));
		ComSetObjValue(formObj.fd_grd_flg,sheetObj.GetEtcData("fd_grd_flg"));
		ComSetObjValue(formObj.hngr_flg,sheetObj.GetEtcData("hngr_flg"));
		ComSetObjValue(formObj.hot_de_flg,sheetObj.GetEtcData("hot_de_flg"));
		ComSetObjValue(formObj.prct_flg,sheetObj.GetEtcData("prct_flg"));
		ComSetObjValue(formObj.stop_off_loc_cd,sheetObj.GetEtcData("stop_off_loc_cd"));
		ComSetObjValue(formObj.spcl_hide_flg,sheetObj.GetEtcData("spcl_hide_flg"));
		ComSetObjValue(formObj.remark,sheetObj.GetEtcData("remark"));
		ComSetObjValue(formObj.dg,sheetObj.GetEtcData("dg"));
		ComSetObjValue(formObj.rf,sheetObj.GetEtcData("rf"));
		ComSetObjValue(formObj.ak,sheetObj.GetEtcData("ak"));
		ComSetObjValue(formObj.bb,sheetObj.GetEtcData("bb"));
		if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){ 
			ComSetObjValue(formObj.lastSplitNo,sheetObj.GetEtcData("memoSplitNo"));
		}else{
			ComSetObjValue(formObj.lastSplitNo,sheetObj.GetEtcData("custSplitNo"));
		}
		ComSetObjValue(formObj.custSplitNo,sheetObj.GetEtcData("custSplitNo"));
		ComSetObjValue(formObj.memoSplitNo,sheetObj.GetEtcData("memoSplitNo"));
		ComSetObjValue(formObj.bkgsplitno,sheetObj.GetEtcData("bkgsplitno"));
		ComSetObjValue(formObj.bdr_flag,sheetObj.GetEtcData("bdr_flag"));
		ComSetObjValue(formObj.pctl_no,sheetObj.GetEtcData("pctl_no"));
		ComSetObjValue(formObj.tro_flg,sheetObj.GetEtcData("tro_flg"));
		ComSetObjValue(formObj.bkgStsCd,sheetObj.GetEtcData("bkgStsCd"));
	}
    /**
    * CA Reason process : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj=document.form;
    	//01. as receiving CA ReasonCd and Remark info
    	var strRsnCd=nullToBlank(arrPopupData[0][2]);
    	var strRemark=nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value=strRsnCd;
        formObj.ca_remark.value=strRemark;
        
        if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
			doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
		}
    }
	/*
	* Sheet2 onAfterEdit event handling
	*/
	function sheet2_OnAfterEdit(sheetObj,Row,Col){
		var formObj=document.form;
		var fActSum=0;
		var fPckSum=0;
		var fMeasSum=0; 
		var startRow=0;
		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
			startRow=2;			
		} else {
			startRow=1;
		}
		 if (sheetObj.ColSaveName(Col)==prefix2+"act_wgt"
		    || sheetObj.ColSaveName(Col)==prefix2+"pck_qty"
			|| sheetObj.ColSaveName(Col)==prefix2+"meas_qty"){
 			for(var idx=startRow;idx<sheetObj.LastRow();idx++){
 				fActSum+=ComTrunc(sheetObj.GetCellValue(idx,prefix2+"act_wgt"),3);
 				fPckSum+=ComParseInt(sheetObj.GetCellValue(idx,prefix2+"pck_qty"));
 				fMeasSum+=ComTrunc(sheetObj.GetCellValue(idx,prefix2+"meas_qty"),2);
			}
 			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"act_wgt"),3)-fActSum<0){
				ComShowCodeMessage("BKG00643");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
 			if (ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"pck_qty"))-fPckSum<0){
				ComShowCodeMessage("BKG00644");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"meas_qty"),2)-fMeasSum<0){
				ComShowCodeMessage("BKG00645");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
			}
 			sheetObj.CellValue2(sheetObj.LastRow(),prefix2+"act_wgt")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"act_wgt"),3)-fActSum;
 			sheetObj.CellValue2(sheetObj.LastRow(),prefix2+"pck_qty")=ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"pck_qty"))-fPckSum;
			sheetObj.CellValue2(sheetObj.LastRow(),prefix2+"meas_qty")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].LastRow(),prefix1+"meas_qty"),2)-fMeasSum;
		}
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix2);
		var arr="";
		if (sheetObj.GetCellValue(Row,prefix2+"bkg_no").length==12){
			arr=sheetObj.GetCellValue(Row,prefix2+"bkg_no").substring(10,12);
		}else{
			arr="00";
		}
		for(var iRow=1;iRow<sheetObjects[3].HeaderRows()+sheetObjects[3].RowCount();iRow++){
			for(var iCol=5;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){ 
                var arrCol=sheetObjects[3].ColSaveName(iCol).split("_");
                if(arrCol[1]==arr && sheetObjects[3].GetCellValue(iRow,iCol)==1){
                	sheetObjects[3].SetCellValue(iRow,prefix4+"adv_shtg_cd",sheetObj.GetCellValue(Row,prefix2+"adv_shtg_cd"),0);
				}
			 }
		 } 
	}
	/*
	* Sheet3 onAfterEdit event handling
	*/
	function sheet3_OnAfterEdit(sheetObj,Row,Col){
		var formObj=document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo=ComParseInt(formObj.splitcount);
		var fQtySum=0.00;
		var fQtySub=0; 
		var fQtyDiv=0.00;
		fQtyDiv=ComCountHeadTitle(strSheetTitle3)-Col-1;
		for (var iCol=Col+1;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			sheetObj.SetCellValue(Row,iCol,(ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-ComTrunc(sheetObj.GetCellValue(Row,Col),2))/fQtyDiv,0);
		}
		for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			fQtySum +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
			if (iCol<ComCountHeadTitle(strSheetTitle3)-1){
				fQtySub +=ComTrunc(sheetObj.GetCellValue(Row,iCol),2);
			}			
		} 
        if (Col != sheetObj.LastCol()){
        	sheetObj.SetCellValue(Row,sheetObj.LastCol(),ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-fQtySum,0);
		}
        if (ComTrunc(sheetObj.GetCellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.GetCellValue(Row,sheetObj.LastCol()),2))!=0){
				ComShowCodeMessage("BKG00642");
				sheetObj.SetCellValue(Row,Col,0,0);
				return false;
		}		
	}	
	/*
	* split process in case of Sheet onAfterEdit event
	*/
	function SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix){
//		if (sheetObj.ColSaveName(Col)==prefix+"tvvd"){   //T.VVD 
//			if(sheetObj.CellValue(Row,prefix+"tvvd")==null){
//				sheetObj.ColHidden(prefix+"pc")=false;
//				sheetObj.CellValue2(Row,prefix+"pc")=0;
//			} else if (ComGetObjValue(formObj.tvvd).toUpperCase() != sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase()){ 
//				sheetObj.ColHidden(prefix+"pc")=false;	
//				sheetObj.CellValue2(Row,prefix+"pc")=0;
//			}else{
//				sheetObj.CellValue2(Row,prefix+"pc")=1;
//			}
//		}
//		 
//		if (ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"COXX")
//			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJYY")
//			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJZZ")){
//			ComSetObjValue(formObj.pseudoVvdFlag,"Y");
//		}else{
//			ComSetObjValue(formObj.pseudoVvdFlag,"N");
//		}
	}
