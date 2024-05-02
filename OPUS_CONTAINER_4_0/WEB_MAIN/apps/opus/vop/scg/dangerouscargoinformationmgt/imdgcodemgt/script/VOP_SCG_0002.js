/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0002.js
*@FileTitle  : UN Number (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0002 : business script for vop_scg_0002
     */
    
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/          
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
    	/*******************************************************/
     	try { 
     		var srcName=window.event.srcElement.getAttribute("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_New":
 					clearAll();
					break;
 				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
 					break;
 				case "btn_OK":
					comPopupOK();
					break;
 				case "btn_Close":
					//window.close();
 					ComClosePopup(); 
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage(preCond) {
    	 for(i=0;i<sheetObjects.length;i++){
    		 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
    	 
    	 sheet1_OnLoadFinish(sheet1);
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         //Initializing html control event
         initControl();
     }

     function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);	//Amdt No
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
         //pop-up and pre retrieve
         if(preConds.pop_yn == 'Y') {
        	 //pre condition setting
	         if(preConds.imdg_un_no != '' || preConds.imdg_tec_nm != '') {	         	
	         	if(preConds.imdg_un_no != '') ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
	         	if(preConds.imdg_tec_nm != '') ComSetObjValue(document.form.imdg_tec_nm, preConds.imdg_tec_nm);
	         	//retrieve
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	         }
         } else {
        	 sheetObjects[0].SetColHidden(1,true);//Check box activate
         }
     }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
         	case 1:      // sheet1 init
                with(sheetObj){
	            
	            var HeadTitle = "||UN No. Seq|UN No. Seq|Class|Class|Proper Shipping Name|Variation Remarks|Technical Name|Sub\nRisks|Packing\nGroup|Special\nProvisions|Limited\nQuantities|EmS|Stowage and\nSegregation|Own\nRestrictions|||||||||||||";
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"CheckBox",  Hidden:0, TrueValue:"Y", FalseValue:"N"  , Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox", UpdateEdit:1,   InsertEdit:1  },
	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:390,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             //2016-01-26 PSN Variation Remark 추가 
	             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm_var_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"imdg_tec_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"imdg_spcl_provi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_emer_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:390,  Align:"Left",    ColMerge:0,   SaveName:"segr_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"imdg_crr_rstr_expt_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_cd" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_rmk" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"psa_no" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_flg" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_pck_rstr_desc" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_intmd_bc_rstr_desc" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_tnk_rstr_desc" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_ctrl_temp" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"emer_rspn_gid_no" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"emer_rspn_gid_chr_no" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_emer_temp" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_meas_ut_cd" },
	             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_mrn_polut_cd" }  ];
	             
	            InitColumns(cols);
	
	            //SetSheetHeight(428);
	            resizeSheet();
	            SetEditable(true);
	            SetEditableColorDiff(false);
	            SetColHidden("checkbox" , false) ;
				SetWaitImageVisible(0);
            }


         		break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	      	case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
	        		formObj.f_cmd.value=SEARCH;
	        		ComOpenWait(true);
	        		sheetObj.DoSearch("VOP_SCG_0002GS.do",FormQueryString(formObj) );
	        		
	        		var sXml=sheetObj.GetSearchData("VOP_SCG_0002GS.do", FormQueryString(formObj));
	        		var arrXml=sXml.split("|$$|");
	        		
	        		var aa= 1;
	        		//ComOpenWait(false);
				}
				break;
	      	case IBDOWNEXCEL:
	      		if(sheetObj.RowCount() < 1){//no data
              	  ComShowCodeMessage("COM132501");
              	  return;
              	}
                var paramObj=new Object();
                paramObj.title="UN Number";
//                paramObj.cols="12";
//                paramObj.columnwidth="1:5|2:5|3:5|4:5|5:70|6:10|7:10|8:10|9:10|10:10|11:40|12:10";
                paramObj.columnwidth=ComScgGetExcelDown(sheetObj);
                paramObj.cols=ComScgGetExcelDownCols(sheetObj);
                paramObj.datarowheight="0:25";
                var url=ComScgGetPgmTitle(sheetObj, paramObj); 

                //@@sheetObj.Down2Excel({ HiddenColumn:-1,URL:url ,TreeLevel:false});
                //sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
                if(sheetObj.RowCount() < 1){//no data
          		  ComShowCodeMessage("COM132501");
	  	       	}else{
	  	       		//var pathArr = url.split("?");
	     	       	var str = sheetObjects[0].GetSearchData(url);
	     	       	str = str.replace(/(^\s*)|(\s*$)/gi, "");
	     	       sheetObj.Down2Excel( {FileName:"Excel.xls", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,ReportXML:str});
	  	       	}                
//                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	      		break;
			case IBSEARCH_ASYNC10:   //Amdt No 조회
				formObj.f_cmd.value=SEARCH07;
	      		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do" , FormQueryString(formObj));
	     		var arrData=ComScgXml2Array(sXml, "imdg_amdt_no");
	     		formObj.crte_imdg_un_no.value = arrData[0][0];
	     		
	     		formObj.f_cmd.value=SEARCH08;
				var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml,imdg_amdt_no, "imdg_amdt_no", "imdg_amdt_no");
				comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
	     		
				break;	      		
			case IBSEARCH_ASYNC01: // Class retrieve
         		//sheetObj.SetWaitImageVisible(false);
                formObj.f_cmd.value=SEARCH02;
 				var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
				//Class
				ComXml2ComboItem(sXml, imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd", "Y");
				break;
			case IBSEARCH_ASYNC11: // Class1 retrieve
         		//sheetObj.SetWaitImageVisible(false);
				formObj.f_cmd.value=SEARCH;
	    		comboObjects[2].SetSelectCode("" , false);
 				var sXml=sheetObj.GetSearchData("VOP_SCG_0047GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, imdg_comp_grp_cd, "imdg_comp_grp_cd", "imdg_comp_grp_cd", "Y");
				break;
         }
  		//sheetObj.SetWaitImageVisible(true);
     }
     //business javascript OnKeyPress event Catch
     function initControl() {
    	 axon_event.addListener('keydown',		'ComKeyEnter',	'form');
    	 axon_event.addListener('change',		'clss_OnChange','imdg_clss_cd');
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);      
    	 //axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
    	 //axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
     }
     function initCombo(comboObj, comboNo) {
 	    switch(comboObj.options.id) {
 	        case "imdg_clss_cd":
 	            with(comboObj) {
 	        		SetDropHeight(260);
 	        		SetMultiSelect(false);
 	        		SetMaxSelect(1);
 	        		SetUseAutoComplete(true);
 	            }
 	            break;
 	        case "imdg_comp_grp_cd":
 	            with(comboObj) {
	        		SetDropHeight(260);
 	        		SetMultiSelect(false);
 	        		SetMaxSelect(1);
 	        		SetUseAutoComplete(false);
 	        		SetEnable(false);
 	            }
 	            break;
 	    }
     }     
     function obj_blur(){
    	 var formObj=document.form;
    	 switch(event.srcElement.name){
    	 case "imdg_un_no":
    		 break;
    	 }
    	 ComChkObjValid(event.srcElement);
     }
     /**
     * HTML Control onkeypress event - input only number. <br>
     **/
     function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //only number
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //number+"."
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
    	}
    	switch(event.srcElement.name){
			case "imdg_un_no":
				//only number
				ComKeyOnlyNumber(event.srcElement);
				break;
    	}
     }
     function obj_keyup(){
    	 ComKeyEnter('LengthNextFocus');
//    	 switch(event.srcElement.name){
//    	 	case "imdg_un_no":
//				if ( ComTrim(event.srcElement.value) != "" ) {
//					ComKeyEnter('LengthNextFocus');
//				}
//				break;
//    	}
     }
   

     
     function clss_OnChange(comboObj, oldindex, oldtext , oldcode, newindex , text , code) {
    	var formObj=document.form;
		if (code == "1" || code == "1.1" || code == "1.2" || code == "1.3" || code == "1.4" || code == "1.5" || code == "1.6" ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC11);
  			comboObjects[2].SetEnable(true);
    		comboObjects[2].SetSelectCode("" , true);
  		}else{
    		comboObjects[2].SetSelectCode("" , true);
  			comboObjects[2].SetEnable(false);
  		}
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
		 switch(sAction){
 			case IBSEARCH:
 				if (!ComChkObjValid(formObj.imdg_un_no)) return;
		 }
         return true;
     }
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		ComOpenWait(false);

    	 for(var i=0; i<sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 1) {
			    			 sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","I");
			}else if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 2) {
			    			 sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","II");
			}else if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 3) {
			    			 sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","III");
    		}
    	 }

     }
  	function clearAll() {
 		var formObj=document.form;
 		formObj.reset();
		sheetObjects[0].RemoveAll();
        for(var k=0; k<comboObjects.length; k++){
        	comboObjects[k].RemoveAll();
        	initCombo(comboObjects[k], k + 1);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);	//Amdt No
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 	}
