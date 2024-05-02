/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1034.js
*@FileTitle  : Pick-up Notice Template(Manual Send)
*@author     : clt
*@version    : 1.0
*@since      : 2014/13/5
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
    var SH_STUP=0;
    var SH_EV1_FOM=1;
    var SH_EV2_FOM=2;
    var SH_EV3_FOM=3;
    var orgObj=new Object();
    var isRetrieved=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Retrieve":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_Save":
            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;
            case "btn_Delete":
            	doActionIBSheet(sheetObject1,formObject,IBDELETE);
                break;
            case "btn_PickupNotice":
            	//ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1066_POP.do?pgmNo=ESM_BKG_1066&mainPage=false', 1024, 712, "", "none", true);
            	ComOpenPopup('/opuscntr/ESM_BKG_1066_POP.do?pgmNo=ESM_BKG_1066&mainPage=false', 1024, 712, "PopupEsmBkg1034", "1,0,1,1,1,1,1", false);
                break;
            case "btn_Reset":
            	doActionIBSheet(sheetObject1,formObject,IBRESET);
            	break;
            case "btn_Close":
            	ComClosePopup();
            	break;
            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param  sheet_obj
     * @return 
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     * 
     * @return 
     */
    function loadPage() {
         for (var i=0;i<sheetObjects.length;i++) {
             ComConfigSheet (sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
        initForm();
        if (document.form.ofc_cd.value != "") {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        document.form.ofc_cd.focus();
    }
     /**
      * setting intial Form data after open the page and delete data
      * 
      * @return
      * @author 
      * @version 2009.07.09
      */
    function initForm() {   	 
        isRetrieved=false;
 		with(document.form) {
            frm_pkup_ntc_seq.value="";
            frm_pkup_ntc_snd_tp_cd.value="";
            frm_ofc_cd.value=ofc_cd.value;
            frm_del_cd.value="*";
            frm_auto_ntc_flg.value="Y"; // Auto
            frm_each_foc_ntc_flg.value="Y"; // Each Y Send(3times)
            frm_trkr_ntc_flg.value="N"; // No
            frm_eclz_obl_cpy_flg.value="N";
            frm_foc_clr_rmk_stup_flg.value="Y";
            frm_hd_tit_ctnt.value="";
            frm_t1_pkup_ntc_seq.value="";
            frm_t1_pkup_ntc_fom_cd.value="";
            frm_t1_eclz_obl_cpy_flg.value="N";
            frm_t1_btm_rmk.value="";
            frm_t2_pkup_ntc_seq.value="";
            frm_t2_pkup_ntc_fom_cd.value="";
            frm_t2_eclz_obl_cpy_flg.value="N";
            frm_t2_btm_rmk.value="";
            frm_t3_pkup_ntc_seq.value="";
            frm_t3_pkup_ntc_fom_cd.value="";
            frm_t3_eclz_obl_cpy_flg.value="N";
            frm_t3_btm_rmk.value="";
 		}
        for (var i=0;i<sheetObjects.length;i++) {
        	sheetObjects[i].RemoveAll();
        }
     }
    /**
     * register HTML tag event <br>
     * 
     * @return 
     */
    function initControl() {
         //axon_event.addListenerFormat("keypress","obj_KeyPress", form);
      	 axon_event.addListener("keydown","obj_keydown1", "ofc_cd");
      	 //axon_event.addListener("keydown","obj_keydown2", "frm_hd_tit_ctnt", "frm_t1_btm_rmk", "frm_t2_btm_rmk", "frm_t3_btm_rmk");
    }    
    /**
     * event handling Key Down<br>
     * 
     * @return
     */
    function obj_keydown1() {
         ComKeyEnter("search");
    }
//    /**
//     * event handling Key Down<br>
//     * 
//     * @return
//     */
//    function obj_keydown2() {
//         switch(ComGetEvent("name")) {
//         case "frm_hd_tit_ctnt":
//        	    if (checkMaxLine(ComGetEvent(), 2) == false) {
//        	   	    if(event.keyCode == 13) { 	  
//        	   		    event.returnValue=false;
//        	   	    }
//        	    }
//         	break;
//         case "frm_t1_btm_rmk":
//         case "frm_t2_btm_rmk":
//         case "frm_t3_btm_rmk":
//        	    if (checkMaxLine(ComGetEvent(), 18) == false) {
//           	   	    if(event.keyCode == 13) { 	  
//           	   		    event.returnValue=false;
//           	   	    }
//           	    }
//        	    break;
//         }
//    }  
    /**
     * registering IBTab Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param tab_obj
     * @return 
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab option <br>
     * setting list of tab <br>
     * 
     * @param tabObj
     * @param tabNo
     * @return 
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Event#1" , "");
                    InsertItem( "Event#2" , "");
                    InsertItem( "Event#3" , "");
                }
                break;
        }
    }
    /**
    * event handling when click a tab <br>
    * activating selected tab<br>
    * 
    * @param tabObj
    * @param nItem
    * @return 
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
     * setting sheet initial values and header<br>
     * @param sheetObj
     * @param sheetNo
     * @return 
     */
    function initSheet(sheetObj,sheetNo) {
        var sheetID=sheetObj.id;        
        var cnt=0;
        switch(sheetID) {
        // Setup Information
        case "sheet1":
            with(sheetObj){
	          var HeadTitle1="|Seq|Send Type Code|Office Code|DEL|Auto|FOC|Trucker|OBL Copy|Remart Setup|Content";
	
	          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
	
	          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_seq",          KeyField:0 },
	                 {Type:"Text",      Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_snd_tp_cd",    KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ofc_cd",                KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"del_cd",                KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"auto_ntc_flg",          KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"each_foc_ntc_flg",      KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trkr_ntc_flg",          KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eclz_obl_cpy_flg",      KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"foc_clr_rmk_stup_flg",  KeyField:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hd_tit_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3000 } ];
	           
	          InitColumns(cols);
	          sheetObj.SetVisible(false);
	        
           }
        break;
        // Word Information
        case "t1sheet1":
        case "t2sheet1":
        case "t3sheet1":
            with(sheetObj){
           
          (8, 0, 0, false);
          var HeadTitle1="||||Seq|Form Code|Enclose O_B/L Copy|Bottom Remark";

          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_snd_tp_cd",  KeyField:1 },
                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:1 },
                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",              KeyField:1 },
                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_seq",        KeyField:0 },
                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_fom_cd",     KeyField:1 },
                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eclz_obl_cpy_flg",    KeyField:1 },
                 {Type:"Text",      Hidden:0, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"btm_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3000 } ];
           
          InitColumns(cols);
          sheetObj.SetVisible(false);
          
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
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        case IBRESET:
        	resetFormData();
        	break;
        // retrieve
        case IBSEARCH:
            if (validateForm(sheetObj,formObj,sAction) == false) break; 
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_1034GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
			var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
	         	setSearchKeyword();
	        }
            sheetObjects[SH_STUP].LoadSearchData(arrXml[0],{Sync:1} );
            sheetObjects[SH_EV1_FOM].LoadSearchData(arrXml[1],{Sync:1} );
            sheetObjects[SH_EV2_FOM].LoadSearchData(arrXml[2],{Sync:1} );
            sheetObjects[SH_EV3_FOM].LoadSearchData(arrXml[3],{Sync:1} );
            if (ComGetTotalRows(arrXml[0]) == 0) {
            	resetFormData();
            }
            copyRowToForm();
            
            //#8845 Pick Up Notice Option Set-Up 화면 Canada 경우도 추가      
            var eqOfcCntCd =ComGetEtcData(arrXml[0], "eqOfcCntCd");
                   
            if("US" == eqOfcCntCd){
    			document.getElementById("us_form").style.display="inline";
    			document.getElementById("ca_form").style.display="none";
            }else{
    			document.getElementById("us_form").style.display="none";
    			document.getElementById("ca_form").style.display="inline";
            }
            
            ComOpenWait(false);
            break;
        // save
        case IBSAVE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG01072"); 
	    	    resetSearchKeyword();
	    	    break;
        	}
            copyFormToRow();
            if (ComIsModifiedSheets(sheetObjects) == false) {
            	ComShowCodeMessage("BKG00743");
            	break;
        	}
    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}
    		ComOpenWait(true);
    		setStatusFlag(sheetObjects);
            formObj.f_cmd.value=MULTI;
            var sParam=FormQueryString(formObj);
            var sParamSheet1=sheetObjects[SH_STUP].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sParamSheet2=sheetObjects[SH_EV1_FOM].GetSaveString();
            if (sParamSheet2 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
            }
            var sParamSheet3=sheetObjects[SH_EV2_FOM].GetSaveString();
            if (sParamSheet3 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet3, "sheet2_");
            }
            var sParamSheet4=sheetObjects[SH_EV3_FOM].GetSaveString();
            if (sParamSheet4 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet4, "sheet2_");
            }
            var sXml=sheetObj.GetSaveData("ESM_BKG_1034GS.do", sParam);
            sheetObjects[SH_STUP].LoadSaveData(sXml);
			sXml=ComDeleteMsg(sXml);
			sheetObjects[SH_EV1_FOM].LoadSaveData(sXml);
			sheetObjects[SH_EV2_FOM].LoadSaveData(sXml);
			sheetObjects[SH_EV3_FOM].LoadSaveData(sXml);
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgSaveCompleted();
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
            break;
        case IBDELETE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG01072"); 
	    	    resetSearchKeyword();
	    	    break;
        	}
    		if (ComShowCodeConfirm("BKG00535") == false) {
    			break;
    		}
        	ComOpenWait(true);
        	formObj.f_cmd.value=MULTI01;
        	var sParam=FormQueryString(formObj) +        	
        	"&pkup_ntc_seq=" + sheetObjects[SH_STUP].GetCellValue(1, "pkup_ntc_seq");
        	var sXml=sheetObj.GetSaveData("ESM_BKG_0411GS.do", sParam);
        	sheetObjects[SH_STUP].LoadSaveData(sXml);
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgDeleteCompleted();
				initForm();
			}
			break;
         }
    }
    /**
     * initializing Form <br>
     * 
     * @return 
     */
    function resetFormData()  {
    	with(document.form) {
    		for (var i=0; i<frm_eclz_obl_cpy_flg.length; i++) {
    		    if (frm_eclz_obl_cpy_flg[i].value == "N") {
    		        frm_eclz_obl_cpy_flg[i].checked=true;
    		        break;
    		    }
    		}
            for (var i=0; i<frm_foc_clr_rmk_stup_flg.length; i++) {
                if (frm_foc_clr_rmk_stup_flg[i].value == "Y") {
                    frm_foc_clr_rmk_stup_flg[i].checked=true;
                    break;
                }
            }
            frm_hd_tit_ctnt.value="";
    		frm_t1_btm_rmk.value="";
    		frm_t2_btm_rmk.value="";
    		frm_t3_btm_rmk.value="";
    	}
    }
    /**
     * copying from Sheet data to form<br>
     * 
     * @return 
     */
    function copyRowToForm() {
    	var formObj=document.form;
		var prefix="";
//    	with (formObj) {
//    		// Setup Information
//  			
//    	}
    	
    	prefix="frm_";
		if (sheetObjects[SH_STUP].RowCount()== 0) {
			sheetObjects[SH_STUP].DataInsert(0);
			sheetObjects[SH_STUP].SetCellValue(1,"pkup_ntc_seq","");
			sheetObjects[SH_STUP].SetCellValue(1,"pkup_ntc_snd_tp_cd","M");
			sheetObjects[SH_STUP].SetCellValue(1,"ofc_cd",formObj.ofc_cd.value);
			sheetObjects[SH_STUP].SetCellValue(1,"del_cd","*");
			sheetObjects[SH_STUP].SetCellValue(1,"auto_ntc_flg","Y");
			sheetObjects[SH_STUP].SetCellValue(1,"each_foc_ntc_flg","Y");
			sheetObjects[SH_STUP].SetCellValue(1,"trkr_ntc_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"eclz_obl_cpy_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"foc_clr_rmk_stup_flg","Y");
			sheetObjects[SH_STUP].SetCellValue(1,"hd_tit_ctnt","");
		}
		IBS_CopyRowToForm(sheetObjects[SH_STUP], formObj, 1, prefix);
		var fom_cd="";
		for (var i=1; i<=3; i++) {
  			if (i==1) {
  				prefix="frm_t1_";
  				fom_cd="EV1";
  			} else if (i==2) {
  				prefix="frm_t2_";
  				fom_cd="EV2";
  			} else if (i==3) {
  				prefix="frm_t3_";
  				fom_cd="EV3";
  			}
    		if (sheetObjects[i].RowCount()== 0) {
    			sheetObjects[i].DataInsert(0);
    			sheetObjects[i].SetCellValue(1,"pkup_ntc_snd_tp_cd","M");
    			sheetObjects[i].SetCellValue(1,"ofc_cd",formObj.ofc_cd.value);
    			sheetObjects[i].SetCellValue(1,"del_cd","*");
    			sheetObjects[i].SetCellValue(1, "pkup_ntc_seq",sheetObjects[SH_STUP].GetCellValue(1, "pkup_ntc_seq"));
    			sheetObjects[i].SetCellValue(1, "pkup_ntc_fom_cd",fom_cd);
    			sheetObjects[i].SetCellValue(1, "eclz_obl_cpy_flg","N");
    			sheetObjects[i].SetCellValue(1, "btm_rmk","");
    		}    		
        	IBS_CopyRowToForm(sheetObjects[i], formObj, 1, prefix); 
		}
    }
    /**
     * copying from form data to Sheet<br>
     * 
     * @return 
     */
    function copyFormToRow() {
    	var formObj=document.form;
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_STUP], 1, "frm_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV1_FOM], 1, "frm_t1_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV2_FOM], 1, "frm_t2_");    
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV3_FOM], 1, "frm_t3_");    
    }
    /**
     * changing from status of Sheet to U <br>
     * 
     * @param sheets
     * @return 
     */
    function setStatusFlag(sheets){
        for (var i=0;i<sheets.length;i++) {
        	for (var j=0;j<sheets[i].RowCount();j++) {
        		if(sheets[i].GetRowStatus(j+1) == "R") {
        			sheets[i].SetRowStatus(j+1,"U");
        		}
        	}
        }
    }      
    /**
     * return changed search keyword<br>
     *
     * @return boolean
     */
    function isChangedSearchKeyword() {
    	var formObj=document.form;
    	if (orgObj.ofc_cd  != formObj.ofc_cd.value) {
    		return false;
    	}
    	return true;
    }
    /**
     * save search keyword for checking<br>
     *
     * @return 
     */
    function setSearchKeyword() {
    	var formObj=document.form;
    	orgObj.ofc_cd=formObj.ofc_cd.value;
    	isRetrieved=true;
    }
    /**
     * reset Search Keyword<br>
     *
     * @return 
     */
    function resetSearchKeyword() {
    	var formObj=document.form;
    	formObj.ofc_cd.value=orgObj.ofc_cd;
    }    
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction) {
      with(formObj) {
      	switch(sAction) {
      	case IBSEARCH:
  	    	// checking Validation
  	    	var objVal=formObj.ofc_cd.value;
  	    	if (objVal.length < 5 || objVal.length > 6) {
  	    		ComShowCodeMessage("BKG00881");
  	    		return false;
  	    	}
  	    	break;
      	case IBSAVE:
  	    	if (!ComChkValid(formObj)) return false;
	    	if (checkMaxLine(formObj.frm_hd_tit_ctnt, 2) == false) {
	    		ComShowCodeMessage("BKG43056", formObj.frm_hd_tit_ctnt.getAttribute("caption"), "2");
	    		formObj.frm_hd_tit_ctnt.focus();
	    		return false;
	    	}
	    	if (checkMaxLine(formObj.frm_t1_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG43056", formObj.frm_t1_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[0].selectedIndex=0;    	  
	    		formObj.frm_t1_btm_rmk.focus();
	    		return false;
	    	}
	    	if (checkMaxLine(formObj.frm_t2_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG43056", formObj.frm_t2_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[1].selectedIndex=0;    	  
	    		formObj.frm_t2_btm_rmk.focus();
	    		return false;
	    	}
	    	if (checkMaxLine(formObj.frm_t3_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG43056", formObj.frm_t3_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[2].selectedIndex=0;    	  
	    		formObj.frm_t3_btm_rmk.focus();
	    		return false;
	    	}
	    	break;
      	}
      }
      return true;
    }
     /**
      * limit TextArea line length<br>
      * @param obj
      * @param maxLine
      * @return 
      */
     function checkMaxLine(obj, maxLine) {
        var ln=getLine(obj);
        if (event.keyCode == 13) {
            if (ln >= maxLine) {
            	return false;
            }
        } else {
            if (ln > maxLine) {
            	return false;
            }
        }
        return true;
    }   
    /**
     * return line length of object data<br>
     * use to limit max line length of object<br>
     * @param obj
     * @return line.length
     */
    function getLine(obj) {
        var str_len=obj.value;
        //line=str_len.split("\r\n");
        line=str_len.split("\n");
        return line.length;
    }
