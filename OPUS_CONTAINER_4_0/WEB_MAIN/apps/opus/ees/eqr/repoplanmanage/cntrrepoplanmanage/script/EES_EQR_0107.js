/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0107.js
*@FileTitle : Repo Plan ID List retreive Pop-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends
     * @class EES_EQR_0107 : business script for EES_EQR_0107
     */
    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            var opener=window.dialogArguments;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
    	            setListSelCond();
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                case "btn_print":
                    if(sheetObjects[0].RowCount('') > 0){
                    	sheetObjects[0].DoPrint();
                    }
                    else{
                    	ComShowCodeMessage("EQR90095");
                    }
                    break;
                case "btn_ok":
                	var opener=window.dialogArguments; // creating parent object
                    if (!opener) opener = parent;
                    
                	var rows=sheetObject.RowCount();
                    var checkRows;
                    var planId;
                    for(var i=1; i <= rows; i++) {
                    	checkRows=sheetObject.GetCellValue(i, "radio")
                        if(checkRows == '1') {
                        	planId=sheetObject.GetCellValue(i, "repo_pln_id");
                        }
                    }
                    if(planId == '', planId == null) {
                    	ComShowCodeMessage("EQR90016", "planId");
                        return false;
                    }
                    var yyyyww=planId.substring(4,10);
                    var seq=planId.substring(11,15);
                    opener.document.form.yyyyww.value=yyyyww;
                    opener.document.form.seq.value=seq;
                    opener.goSearchRepoid();
                    ComClosePopup(); 
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "fm_rcc_btn": //calling pop-up for retrieving RCC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:fm_rcc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "fm_lcc_btn": //calling pop-up for retrieving LCC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:fm_lcc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "fm_ecc_btn": //calling pop-up for retrieving ECC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:fm_ecc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "fm_loc_btn": //calling pop-up for retrieving SCC 	            
		            var targetObjList="loc_cd:fm_loc_cd";
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 460, targetObjList, "0,1,1,1,1,1", true);
					break;  
                case "fm_yard_btn": //calling pop-up for retrieving YARD 
                	var targetObjList="yd_cd:fm_yard_cd";
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 480, targetObjList, "1,0,1,1,1,1,1", true);
					break;
                case "to_rcc_btn": //calling pop-up for retrieving RCC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:to_rcc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "to_lcc_btn": //calling pop-up for retrieving LCC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:to_lcc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "to_ecc_btn": //calling pop-up for retrieving ECC 
                    var display="0,1,1,1,1,1";
                    var targetObjList="loc_cd:to_ecc_cd";
      				var param="?depth=3&classId=COM_ENS_0O1";
      				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
  				    break;
                case "to_loc_btn": //calling pop-up for retrieving SCC	            
		            var targetObjList="loc_cd:to_loc_cd";
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 460, targetObjList, "0,1,1,1,1,1", true);
					break;  
                case "to_yard_btn": //calling pop-up for retrieving YARD
                	var targetObjList="yd_cd:to_yard_cd";
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 480, targetObjList, "1,0,1,1,1,1,1", true);
					break;
                case "s_lane_btn": //calling pop-up for retrieving Service Lane 
                    var v_display="0,1";
                    var targetObjList="lane:s_lane_cd";
                    var param="?classId=COM_ENS_0P1&depth=2&chkDepth=2";
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 400, 480, targetObjList, v_display, true);
                    break;
                case "vvd_btn": //calling pop-up for retrieving VVD
                    var param="?vvd_cd=" + formObject.vvd_cd.value ;
                    var targetObjList="vvd:vvd_cd";
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0B2.do' , 755, 450 , targetObjList , "1,0,1,1,1,1,1,1" , true );
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
            	ComShowCodeMessage("EQR90004");
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
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet(sheetObjects[i]);
        	initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
            initControl();
            setListSelCond();
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
            case 1:      //sheet1 init
                with(sheetObj){
                
              var HeadTitle="Sel.|Week|Repo. Plan ID|EP Type|Data Type|SVVD|Empty Booking #|Ref ID|SO #|Fm RCC|Fm LCC|Fm ECC|Fm Loc|Fm Yard|To RCC|To LCC|To ECC|To Loc|To Yard|Remarks|User ID|Update Date|Creation Date|D|A|M|Scenario ID" ;

              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"repo_pln_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:"ep_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:"dat_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ref_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"so_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"fm_rcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"fm_lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"to_rcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"to_lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"repo_pln_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"repo_pln_dtrb_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"auto",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"manual",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"scnr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(320);
              SetEditable(1);
              SetImageList(0,"/opuscntr/img/ico_round.gif");
                    }


                break;
        }
    }
    
    
    var beforesheet=0 ;
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function ChangSheet(nItem)
    {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforesheet].style.display="none";
        //--------------- Important --------------------------//
        objs[beforesheet].style.zIndex=objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforesheet=nItem;
    }
    
    
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH;
                selectVal=eqrFormQryStr(formObj);
                sheetObj.DoSearch("EES_EQR_0107GS.do", selectVal, {Sync:2} );
                break;
            case IBSAVE:        //saving
              if(validateForm(sheetObj,formObj,sAction))
                break;
           case IBCOPYROW:        //copying row
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:        //downloading excel
        	   if(sheetObj.RowCount() < 1){//no data
            		 ComShowCodeMessage("COM132501");
    	       		}else{
    	       			//sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
    	       			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    	       		}
              break;
           case IBLOADEXCEL:        //uploading excel
        	   sheetObj.LoadExcel();
              break;
        }
    }
    
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
	        var syear=formObj.repo_syear.value;
	        var eyear=formObj.repo_eyear.value;
	        var sweek=formObj.repo_sweek.value;
	        var eweek=formObj.repo_eweek.value;
	        //--------------- Week`s validation (S)--------------------------//
	        // Checking Week Mandatory
	        if(syear == "" || eyear == "" ||sweek == "" ||eweek == ""){
	        	ComShowCodeMessage("EQR90195");
	        }	
	    	// Week`s data digit validate check
	        if(formObj.repo_syear.value.length != 4 || formObj.repo_sweek.value.length != 2) {
	        	ComShowCodeMessage("EQR90001", "start week");
	            if(formObj.repo_syear.value.length != 4) {
		            formObj.repo_syear.focus();
		            return false;
	            }
	            if(formObj.repo_sweek.value.length != 2) {
	                formObj.repo_sweek.focus();
	                return false;
	            }
	        }
	        // Week`s data digit validate check
	        if(formObj.repo_eyear.value.length != 4 || formObj.repo_sweek.value.length != 2) {
	        	ComShowCodeMessage("EQR90001", "end week");
	        	if(formObj.repo_eyear.value.length != 4) {
	        		formObj.repo_eyear.focus();
	        		return false;
	        	}
	        	if(formObj.repo_sweek.value.length != 2) {
	        		formObj.repo_sweek.focus();
	        		return false;
	        	}
	        }
	        // Checking the Start Week & End Week
	        if(syear + sweek > eyear + eweek) {
	        	ComShowCodeMessage("EQR90215");
	        	formObj.repo_eyear.value="";
	        	formObj.repo_eweek.value="";
	        	formObj.repo_eyear.focus();
	        	return false;
	        }
	        //--------------- Week`s validation (E)--------------------------//
	        // Checking Repo. Plan ID
	        if(formObj.repo_pln.value == "" && formObj.repo_pln_seq.value != "") {
	        	ComShowCodeMessage("EQR90001", "'Repo Plan'");
	        	formObj.repo_pln.focus();
	        	return false;
	        }
        }
        return true;
    }
    
    
  	/**
	 * handling double click evetn on sheet <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnDblClick(sheetObj, Row, Col)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {Long}	Row  -  Row Index
	 * @param {Long}	Col  - Column Index
	 */
    function sheet_OnDblClick(sheetObj, row , col) {
	    if ( sheetObj.ColSaveName(col)=="usr_id") {
	    	var userId=sheetObj.GetCellValue(row,col);
	    	if ( userId != null || userId != "" ) {
	    		ComUserPopup(userId);
	    	}
	    }
    }
    
    
	function form_click(){
		srcName=ComGetEvent("name");
			if ( srcName == "cre_usr_id"){
				var userId=document.form.cre_usr_id.value;
		 	    	if ( userId != "" ){
		 	       		ComUserPopup(userId);
		 	        }
		 	}
	}
	
	
	function initControl() {
		axon_event.addListenerForm('click', 'form_click',    document.form); //- when clicked
	}
	
	
    /**
     * handling process for Show in List Columns
     */
	function setListSelCond() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		//if(ComShowConfirm(ComGetMsg("EQR70010"))){
		//    doActionIBSheet(sheetObj, formObj, IBSEARCH);
		//}
		// Location Code 
		sheetObj.SetColHidden('ep_tp_cd',!formObj.cbx_ep_tp_cd.checked);
		sheetObj.SetColHidden('dat_tp_cd',!formObj.cbx_ep_tp_cd.checked);		
		sheetObj.SetColHidden('fm_rcc_cd',!formObj.cbx_rcc_cd.checked);
		sheetObj.SetColHidden('to_rcc_cd',!formObj.cbx_rcc_cd.checked);
		sheetObj.SetColHidden('fm_lcc_cd',!formObj.cbx_lcc_cd.checked);
		sheetObj.SetColHidden('to_lcc_cd',!formObj.cbx_lcc_cd.checked);
		sheetObj.SetColHidden('fm_ecc_cd',!formObj.cbx_ecc_cd.checked);
		sheetObj.SetColHidden('to_ecc_cd',!formObj.cbx_ecc_cd.checked);
		sheetObj.SetColHidden('fm_loc_cd',!formObj.cbx_loc_cd.checked);
		sheetObj.SetColHidden('to_loc_cd',!formObj.cbx_loc_cd.checked);
		sheetObj.SetColHidden('fm_yard_cd',!formObj.cbx_yard_cd.checked);
		sheetObj.SetColHidden('to_yard_cd',!formObj.cbx_yard_cd.checked);
		// VVD, Empty Booking, So No.
		sheetObj.SetColHidden('vvd',!formObj.cbx_vvd_cd.checked);
		sheetObj.SetColHidden('bkg_no',!formObj.cbx_emt_bkg_no.checked);
		sheetObj.SetColHidden('ref_id',!formObj.cbx_ref_id.checked);
		sheetObj.SetColHidden('so_no',!formObj.cbx_so_no.checked);
	}
