/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0133.js
*@FileTitle : retrieving for Link info(Link Information)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common static variable
var sheetObjects=new Array();
var sheetCnt=0;
// static variable for checking ECC
var checkRow=0;
var checkCol=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
        	    	document.form.fromLocation.disabled=true;
        	    	document.form.toLocation.disabled=true;
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;
        	    case "btn_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;
        	    case "btn_print":
                	if(sheetObjects[0].RowCount('') > 0) {
                     	sheetObjects[0].DoPrint();
                	}else{
                  		ComShowCodeMessage("EQR90095");
                	}
              		break;
        	    case "btn_eqorg":
                    // calling EQR Organization Chart as pop-up
					//var modal =  ComOpenWindow('EES_EQR_0139.do',  self,  "dialogLeft:0px; dialogTop:0px; dialogWidth:500px; dialogHeight:574px; status:no" , true);
					var modal =  ComOpenWindowCenter('EES_EQR_0139.do',  self,  '500', '574' , true);
        	        break;
              	case "frloc_btn":
                	var display="0,1,1,1,1,1";
                	var targetObjList="loc_dpth_cd:fromStatus|loc_cd:fromLocation";
  				    var param="?depth=3&classId=COM_ENS_0O1";
  				    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
  				    
  				    break;
              	case "toloc_btn":
                	var display="0,1,1,1,1,1";
                	var targetObjList="loc_dpth_cd:toStatus|loc_cd:toLocation";
  				    var param="?depth=3&classId=COM_ENS_0O1";
  				    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
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
        }
        initControl();
        document.form.fromLocation.disabled=true;
        document.form.toLocation.disabled=true;
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){

            	      var HeadTitle="Fm ECC|To ECC|Mode|Transit \nDays|Cost(USD)|Cost(USD)|Cost(USD)|Max \nCapa|Box|Times/\nWeek|Exceptional|Exceptional|Exceptional|Exceptional|Creation Date" ;
            	      var HeadTitle1="Fm ECC|To ECC|Mode|Transit \nDays|20'|40'|45'|Max \nCapa|Box|Times/\nWeek|From Week|To Week|Max Capa|Box|Creation Date" ;

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"},
            	                  { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_ecc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_ecc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"tz_dys",             KeyField:0,   CalcLogic:"",   Format:"",       PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
            	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tz_20ft_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
            	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tz_40ft_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
            	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tz_45ft_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
            	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_max_capa_qty",  KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"trsp_freq_knt",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"expt_fm_yrwk",       KeyField:0,   CalcLogic:"",   Format:"Ym",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"expt_to_yrwk",       KeyField:0,   CalcLogic:"",   Format:"Ym",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"expt_max_capa_qty",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"expt_vol_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 } ];
            	       
            	      InitColumns(cols);

            	      SetEditable(1);
            	      SetColProperty(0 ,"fm_ecc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	      SetColProperty(0 ,"to_ecc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	      SetColProperty("trsp_mod_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
                  	  SetColProperty("cntr_vol_ut_cd", {ComboText:combo02Text, ComboCode:combo02Code} );
                  	  SetColProperty("expt_vol_ut_cd", {ComboText:combo03Text, ComboCode:combo03Code} );
            	      SetRangeBackColor(1, 5, 1, 8,"#666666");
            	      SetRangeBackColor(1, 12, 1, 15,"#666666");
            	      SetHeaderRowHeight(10 );
            	      SetColHidden("expt_vol_ut_cd",1);
//            	      sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 21));
            	      resizeSheet();
            	      }
                break;
        }
    }
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
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
             	sheetObj.DoSearch("EES_EQR_0133GS.do", eqrFormQryStr(formObj) );
                break;
//            case IBSAVE:        //saving
//              	//if(validateForm(sheetObj,formObj,sAction))
//				if(validateWeekData(sheetObj)) { // checking from week, fo week are full filled
//             		formObj.f_cmd.value = MODIFY;
//             		sheetObj.DoSave("EES_EQR_116GS.do", eqrFormQryStr(formObj));
//                }
//
//                break;
//
//           case IBINSERT:      // inserting
//                var Row = sheetObj.DataInsert(0);            // always inserting row at first row
//                sheetObj.CellValue(Row,"trsp_mod_cd") = "";  // removing data for not merging
//                break;
           case IBCOPYROW:        //copying row
              	sheetObj.DataCopy();
              	break;
           case IBDOWNEXCEL:        //downloading excel
        	    if(sheetObj.RowCount() < 1){
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(             	 sheetObj), SheetDesign:1,Merge:1 });
        		}                
              	break;
           case IBLOADEXCEL:        //uploading excel
               	sheetObj.LoadExcel();
              	break;
        }
    }
    function doActionIBSheet3(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		switch(sAction) {
           	case IBSEARCH:      //retrieve
           		var eccCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
//                formObj.target = "iframe";
//                formObj.f_cmd.value = SEARCHLIST02;
//                formObj.action ='EES_ECCCDCHECK.do?eccCd=' + eccCd;
//                formObj.submit();
                var f_cmd=SEARCHLIST02
                    //sheetObj.DoRowSearch( ROW,eccCd=eccCd&Row=sheetObj.SelectRow&Col=sheetObj.SelectCol&f_cmd=f_cmd );
                	sheetObj.DoRowSearch("EES_ECCCDCHECK.do" ,"eccCd=" + eccCd + "&Row=" + sheetObj.SelectRow + "&Col=" +sheetObj.SelectCol+ "&f_cmd=" + f_cmd);
                if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol()) == ""){
                       ComShowCodeMessage("EQR90098");
                     }
                break;
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==0) {  // IBSEARCH
			    if(!checkLocItem(formObj, 'fromStatus', 'fromLocation')) {
                    return false;
                }
                if(!checkLocItem(formObj, 'toStatus', 'toLocation')) {
                    return false;
                }
			}
        }
        return true;
    }
	// setting location
  	function frLocChange(key) {
    	var gubun=key;
      	if(gubun =="") {
      		document.form.fromLocation.value="";
      		document.form.fromLocation.disabled=true;
      	}else {
      		document.form.fromLocation.value="" ;
      		document.form.fromLocation.disabled=false;
      	}
    }
	// setting location
  	function toLocChange(key) {
    	var gubun=key;
      	if(gubun =="") {
      		document.form.toLocation.value="";
      		document.form.toLocation.disabled=true;
      	}else {
      		document.form.toLocation.value="" ;
      		document.form.toLocation.disabled=false;
      	}
    }
	/*
	 - in case of SHEET1 ONCHAGE, checking modified FROM WEEK, FROM TO value
	  1) checking from is week
	  2) FROM WEEK <= TO WEEK
	  3) FROM WEEK, TO WEEK should be full filled
	*/
	function sheet1_OnChange(sheetObj, row, col, value) {
		var expt_fm_dt="";
		var expt_to_dt="";
		var weekInput="";
		var colName=sheetObj.ColSaveName(col);
		// checking FROM WEEK, TO WEEK data
		if(colName == "expt_fm_yrwk" || colName == "expt_to_yrwk") {  // expt_fm_dt, expt_to_dt
			weekInput=sheetObj.GetCellValue(row, col); // input data week
			expt_fm_dt=sheetObj.GetCellValue(row, "expt_fm_yrwk");
			expt_to_dt=sheetObj.GetCellValue(row, "expt_to_yrwk");
	  		//1) checking from is week
			if(weekInput.length < 6) {
				//ComShowCodeMessage("please input week data format ! ");
    			ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(row, col,"",0);
				return false;
			}else {
				if(weekInput.substring(4,6) < 01 || weekInput.substring(4,6) > 53) {
					//ComShowCodeMessage("please input week data format ! ");
    				ComShowCodeMessage("EQR90056");
					sheetObj.SetCellValue(row, col,"",0);
					return false;
				}
			}
			// 2) FROM WEEK <= TO WEEK
			if(expt_fm_dt != "" && expt_to_dt != "") {
				if(expt_fm_dt > expt_to_dt) {
					//ComShowCodeMessage("To Week must larger than From Week ! ");
    				ComShowCodeMessage("EQR90033");
					sheetObj.SetCellValue(row, col,"",0);
					return false;
				}
			}
		}
		//in case of inserting ECC CODE, checking ecc code
        if(col == sheetObj.SaveNameCol("fm_ecc_cd") || col == sheetObj.SaveNameCol("to_ecc_cd") ) {
            if(value != "") {
                // checking which inserted ECC exists on DB
                checkRow=row;
                checkCol=col;
                doActionIBSheet3(sheetObj,document.form,IBSEARCH);
                //in case of from ecc is same to to ecc, inserting disable
                if(sheetObj.GetCellValue(row, 'fm_ecc_cd') != '' && sheetObj.GetCellValue(row, 'to_ecc_cd') != '') {
                	if(sheetObj.GetCellValue(row, 'fm_ecc_cd')==sheetObj.GetCellValue(row, 'to_ecc_cd')) {
                        //ComShowCodeMessage('You can not input the same ECC Link information');
                        ComShowCodeMessage("EQR90170");
                        sheetObj.SetCellValue(row, col,'',0);
                        sheetObj.SelectCell(row, col);
                    }
                }
            }
        }
        //checking duplicated key
		if(sheetObj.GetRowStatus(row) == 'I') {
		if(sheetObj.GetCellValue(row, 'fm_ecc_cd') != ''
		&& sheetObj.GetCellValue(row, 'to_ecc_cd') != ''
		&& sheetObj.GetCellValue(row, 'trsp_mod_cd') != '' ) {
                var index=sheetObj.ColValueDup('fm_ecc_cd|to_ecc_cd|trsp_mod_cd');
                if(index != -1) {
                  	//ComShowCodeMessage('Data Duplicate');
    				ComShowCodeMessage("EQR90009");
                	sheetObj.SetCellValue(row, 'trsp_mod_cd','',0);
                	sheetObj.SelectCell(row, 'trsp_mod_cd');
                }
             }
    	}
    }
    /*
     - in case of filled only one of from week, to week after save button
       alert to user
    */
    function validateWeekData(sheetObj) {
		var expt_fm_dt="";
		var expt_to_dt="";
  		var sRow=sheetObj.FindStatusRow("U|I");
  		var arrRow=sRow.split(';');
  		var result=true;
  		for(idx=0; idx<arrRow.length-1; idx++) {
  			expt_fm_dt=sheetObj.GetCellValue(arrRow[idx], "expt_fm_yrwk");
  			expt_to_dt=sheetObj.GetCellValue(arrRow[idx], "expt_to_yrwk");
			if(expt_fm_dt == "" && expt_to_dt != "") { // in case of only filled expt_to_dt 
				//ComShowCodeMessage("Please input data 'From week' at line "+(arrRow[idx]-1)+"  ! ");
				ComShowMessage(ComGetMsg("EQR90034", arrRow[idx]-1));
				result=false;
			}
			if(expt_fm_dt != "" && expt_to_dt == "") { // in case of only filled expt_fm_dt 
				//ComShowCodeMessage("Please input data 'To Week' at line "+(arrRow[idx]-1)+"  ! ");
				ComShowMessage(ComGetMsg("EQR90035", arrRow[idx]-1));
				result=false;
			}
  		}
  		return result;
    }
	/*
	   for showing max update, max userid data
	*/
  	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		ComEtcDataToForm(document.form, sheetObj);
  	}
  	/*
  		in case of inserting ECC CODE, checking ecc code
  	*/
	function checkEccCode(check) {
	    if(check == "false") {
	        //showErrMessage("error");
	        ComShowCodeMessage("EQR90098");
	        sheetObjects[0].SetCellValue(checkRow, checkCol,'');
	        sheetObjects[0].SelectCell(checkRow, checkCol);
	    }
	    document.form.target="";
	    checkRow='';
	    checkCol='';
	}
    // messageing after saving
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
        if(errMsg=='') {
    		ComShowCodeMessage("EQR90106");
		}
    }
	function form_click(){
		srcName=ComGetEvent("name");
			if ( srcName == "userid"){
				var userId=document.form.userid.value;
		 	    	if ( userId != "" ){
		 	       		ComUserPopup(userId);
		 	        }
		 	}
	 }
	function initControl() {
		axon_event.addListenerForm('click', 'form_click',    document.form); //- when clicked
	}
