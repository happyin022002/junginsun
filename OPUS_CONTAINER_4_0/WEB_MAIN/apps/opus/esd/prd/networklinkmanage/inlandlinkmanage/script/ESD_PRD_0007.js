/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0007.js
*@FileTitle  : Link  List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var validateData="";
var retValidate=0;
document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
         var dispaly ;
         var classId ;
         var func ;
         var param ;
         var chkStr ;
    	try {
    		var srcName=ComGetEvent("name");
            /****************************
             handling enterKey
            *****************************/
            switch(srcName) {
        	    case "btn_retrieve":
            	    if(!ComChkRequired(formObject)) return;
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_save":
        	    	if(!ComChkRequired(formObject)) return;
    	            doActionIBSheet(sheetObject,formObject, IBSAVE);
        	        break;
        	    case "btng_select":
    	            ComShowMessage("btng_select Click!!");
        	        break;
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	    case "btng_rowcopy":
    	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;
        	    case "btn_ok":
        	          sendDataToGrid(sheetObject);
        	      break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	      break;
                case "btn_dest_loc":
                   dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId="COM_ENS_051";
                   func="getDestLoc";
        		   param='?classId='+classId+'&func=getDestLoc&display='+dispaly;
        		   chkStr=dispaly.substring(0,3)
                   if(chkStr == "1,0") {
                      myWin=ComOpenWindowCenter('/opuscntr/COM_ENS_051.do'+param, 'pop', 900, 500, false);
                   } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                   }
                  break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('PRD90054'));
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    function getDestLoc(rowArray) {
    	var colArray=rowArray[0];
    	document.all.i_dest_cd.value=colArray[3];
    }
    function getOrgLoc(rowArray) {
    	var colArray=rowArray[0];
    	document.all.i_org_cd.value=colArray[3];
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
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd');
		ComSetUIItem(sheetObjects[0],document.form,'PRD','ESD_PRD_0007');
		itemControl(sheetObjects[0],document.form,'');
    }
    var item_vndr='N';
    function itemControl(sheetObj,formObj,sAction) {
    	if(undefined != formObj.skip_flag_fun_itemControl && "Y" == formObj.skip_flag_fun_itemControl.value) {
    		item_vndr='Y';
    		return;
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
            case 1: 
                with (sheetObj) {
               var HeadTitle="Del.|STS|Seq.|Chk|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T\n(DD.HH)|Distance|UOM|fc " ;
               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);
               var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_loc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                         {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                         {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"vndr_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fmt_tztm_hrs",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dist_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rail_crr_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                
               	InitColumns(cols);

				SetEditable(1);
				resizeSheet();
				SetWaitImageVisible(0);
				SetColProperty("trsp_mod_cd", {ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
				SetColProperty("rail_crr_tp_cd", {ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
				SetColProperty("dist_ut_cd", {ComboText:"|M|K", ComboCode:"|M|K"} );
				SetColProperty("fmt_tztm_hrs", {AcceptKeys:"N", Format:"##.##"} );
				SetColProperty(0 ,"org_loc" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"dest_loc" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"org_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"dest_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});

               }
                break;
        }
    }

    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST;
                if(formObj.i_org_cd.value=="" && formObj.i_dest_cd.value=="" ) {
                    return false;  
                }
               sheetObj.DoSearch("ESD_PRD_0007GS.do", PrdFQString(formObj) , {Sync:2});
                ComOpenWait(false);
                break;
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction));
                formObj.f_cmd.value=MULTI;
                setNodCd(sheetObj);
                calcuTztmHrs(sheetObj);
                var SaveStr=sheetObj.GetSaveString();
                if(SaveStr == "") {
                	return;
                }
                sXml=sheetObj.GetSaveData("ESD_PRD_0007GS.do",SaveStr+"&"+PrdFQString(formObj))
                sheetObj.LoadSearchData(sXml,{Append:0 , Sync:1} );
                pseudoCdCheck(sheetObj);
                break;
           case IBINSERT:      
               if(validateForm(sheetObj,formObj,sAction))
                 sheetObj.DataInsert();
                break;
           case IBCOPYROW:        
              sheetObj.CheckAll("chk",0 );
              var idx=sheetObj.DataCopy();
              sheetObj.SetCellValue(idx,"chk",1,0);
              break;
           case IBDOWNEXCEL: 
        	   if(sheetObj.RowCount() < 1){//no data
          		 ComShowCodeMessage("COM132501");
  	       		}else{
  	       			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
  	       		}
              break;
           case SEARCH02:
              formObj.f_cmd.value=SEARCH02;
              uid="ESD_PRD_0007";
              sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml, "rowCount");
              break;    
           //node check
           case SEARCH04:
              formObj.f_cmd.value=SEARCH04;
              uid="ESD_PRD_0007";
               sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml, "rowCount");
              break;                  
           //vender check
           case SEARCH08:
              formObj.f_cmd.value=SEARCH08;
              uid="ESD_PRD_0007";
               sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
               retValidate=ComGetEtcData(sXml, "rowCount");
               comData1=ComGetEtcData(sXml, "comData1");
              break;                
        }
    }
    function  pseudoCdCheck(sheetObj){
        var pseudoCd=sheetObj.GetEtcData("pseudoCd");
        var blankCd=sheetObj.GetEtcData("blankCd");
        var invalidVendorCd=sheetObj.GetEtcData("invalidVendorCd");
        var msg="";
        if(pseudoCd.length>0){
        	msg=ComGetMsg('PRD90064',pseudoCd);
        }
        if(blankCd.length>0){
            msg=msg+ComGetMsg('PRD90065',blankCd);
        }
        if(invalidVendorCd.length>0){
            msg=msg+ComGetMsg('PRD90066',invalidVendorCd);
        }        
        if(pseudoCd.length>0 || blankCd.length>0 || invalidVendorCd.length>0){
            ComShowMessage(msg);
        } else {
        	ComShowMessage('Saved data successfully.');
        }
    }
    /*
     * making hidden key value in case of creation
     */
    function setNodCd(sheetObj) {
        for( i=1; i<= sheetObj.RowCount(); i++) {
		if(sheetObj.GetRowStatus(i)=="I") {
		sheetObj.SetCellValue(i,"lnk_org_nod_cd",sheetObj.GetCellValue(i,"org_loc")  + sheetObj.GetCellValue(i,"org_type"),0);
		sheetObj.SetCellValue(i,"lnk_dest_nod_cd",sheetObj.GetCellValue(i,"dest_loc")  + sheetObj.GetCellValue(i,"dest_type"),0);
            }
        }
    }
    /**
     * changing to time format of sheet data
     * - calling comPopupInSheet() : passing Parameters - row, col  
     */
    function calcuTztmHrs(sheetObj) {
        var fmtTime=0;
        for( i=1; i<= sheetObj.RowCount(); i++) {
			if(sheetObj.GetRowStatus(i)=="I" || sheetObj.GetRowStatus(i)=="U"){
				fmtTime=sheetObj.GetCellValue(i,"fmt_tztm_hrs");
				if (fmtTime == undefined || fmtTime == '') {
					sheetObj.SetCellValue(i,"tztm_hrs","",0);
				} else {
					sheetObj.SetCellValue(i,"tztm_hrs",(eval(fmtTime.substring(0,2)*24)+eval(fmtTime.substring(2))),0);
				}
           }
        }
    }
/**
 * calling Biz common popup from sheet
 * - calling comPopupInSheet() :  passing Parameters - row, col  
 */
    function sheet1_OnPopupClick(sheetObj, row, col){   
	 	var loc_cd_val ;
	 	var dispaly ;
	 	var classId ;
	 	var func ;
	 	var param ;
	 	var chkStr ;
        if ( sheetObj.ColSaveName(col) == "org_loc" || sheetObj.ColSaveName(col) == "dest_loc" )
        {
        	loc_cd_val=sheetObj.GetCellValue(row, col);
            display="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            classId="COM_ENS_061";
            func="getNode";
            param='?classId='+classId+'&func=getNode&display='+display+'&loc_cd='+loc_cd_val+'&row='+row+'&col='+col;
    	    chkStr=display.substring(0,3);          
            // Radio PopUp  
            if(chkStr == "1,0") {
                  myWin=ComOpenWindowCenter('/opuscntr/COM_ENS_061.do'+param, 'pop', 800, 550, false);
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
        	loc_cd_val=sheetObj.GetCellValue(row, col);
            display="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            classId="COM_ENS_0C1";
    	    param='?classId='+classId+'&func=getVender&display='+display+'&row='+row+'&col='+col;
    	    chkStr=display.substring(0,3);
            // Radio PopUp  
            if(chkStr == "1,0") {
              myWin=ComOpenWindowCenter('/opuscntr/COM_ENS_0C1.do'+param, 'pop', 700, 450, false);
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }    
     }    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        //checking time format
        if (sheetObj.ColSaveName(Col) == "fmt_tztm_hrs") {
        	var fmtTime=sheetObj.GetCellValue(Row,"fmt_tztm_hrs").replace(" ","");
            if(fmtTime.length != 4) {
                ComShowMessage(ComGetMsg("PRD90014"));
                sheetObj.SetCellValue(Row, "fmt_tztm_hrs", "", 0);
                sheetObj.SelectCell(Row, "fmt_tztm_hrs", true);
                return false;
            }  
            if(fmtTime.substring(2)>=24) {
    	        sheetObj.SetCellValue(Row,"fmt_tztm_hrs","",0);
    	        sheetObj.SelectCell(Row,"fmt_tztm_hrs");
    	        return false;
    	    }
    	}   
    	//checking sp code
    	if (sheetObj.ColSaveName(Col) == "vndr_seq")
    	{
    		if( sheetObj.GetCellValue(Row,"vndr_seq").length == 6 ) {
    			validateData=sheetObj.GetCellValue(Row,"vndr_seq");
                doActionIBSheet(sheetObjects[0],document.form, SEARCH08);
                if(retValidate < 1) {
                    sheetObj.SetCellValue(Row,"vndr_seq","",0);
                    sheetObj.SelectCell(Row,"vndr_seq");
                } else {
                    sheetObj.SetCellValue(Row,"vndr_name",comData1,0);
                }
            }   
    	} 
    	if(sheetObj.GetRowStatus(Row)=="I") {
            if(sheetObj.ColSaveName(Col) != "org_loc" && sheetObj.ColSaveName(Col) != "org_type"
               && sheetObj.ColSaveName(Col) != "dest_loc" && sheetObj.ColSaveName(Col) != "dest_type"
               && sheetObj.ColSaveName(Col) != "trsp_mod_cd") return;
            sheetObj.SetCellValue(Row,"lnk_org_nod_cd",sheetObj.GetCellValue(Row,"org_loc")  + sheetObj.GetCellValue(Row,"org_type"),0);
            sheetObj.SetCellValue(Row,"lnk_dest_nod_cd",sheetObj.GetCellValue(Row,"dest_loc")  + sheetObj.GetCellValue(Row,"dest_type"),0);
            // checking nod code 
            if(sheetObj.ColSaveName(Col)=="org_loc" || sheetObj.ColSaveName(Col)=="org_type" ) {
            	if( sheetObj.GetCellValue(Row,"lnk_org_nod_cd").length == 7 ) {
                    //validateData - nod cd 
            		validateData=sheetObj.GetCellValue(Row,"lnk_org_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    //if row count is lesser than 1
                    if(retValidate < 1) {
                        sheetObj.SetCellValue(Row,"org_loc","",0);
                        sheetObj.SetCellValue(Row,"org_type","",0);
                        sheetObj.SelectCell(Row,"org_loc");
                    } 
                }                
            }
           if(sheetObj.ColSaveName(Col)=="dest_loc" || sheetObj.ColSaveName(Col)=="dest_type" ) {
        	   if( sheetObj.GetCellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
                    //validateData - nod cd 
        		   validateData=sheetObj.GetCellValue(Row,"lnk_dest_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    //if row count is lesser than 1
                    if(retValidate < 1) {
                        sheetObj.SetCellValue(Row,"dest_loc","",0);
                        sheetObj.SetCellValue(Row,"dest_type","",0);
                        sheetObj.SelectCell(Row,"dest_loc");
                    } 
                }                
           }
           if(sheetObj.GetCellValue(Row,"lnk_org_nod_cd")==sheetObj.GetCellValue(Row,"lnk_dest_nod_cd") ){
               // Destination node must be different from orgin node.
	            ComShowMessage(ComGetMsg('PRD90067'));
                sheetObj.SetCellValue(Row,"dest_type","",0);
                sheetObj.SelectCell(Row,"dest_loc",true,"");
                return ;
           }            
           //checking the Americas
			if(sheetObj.GetCellValue(Row,"lnk_org_nod_cd").length == 7 && sheetObj.GetCellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
			var org=sheetObj.GetCellValue(Row,"lnk_org_nod_cd").substring(0,2);
			var des=sheetObj.GetCellValue(Row,"lnk_dest_nod_cd").substring(0,2);
			var trsp=sheetObj.GetCellValue(Row,"trsp_mod_cd");
               if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  ) && trsp =="RD" ) {
                   sheetObj.SetCellEditable(Row,"rail_crr_tp_cd",1);
               }
           }
            // checking SP 
           if(sheetObj.ColSaveName(Col)=="vndr_seq" ) {
        	   if( sheetObj.GetCellValue(Row,"vndr_seq").length == 6 ) {
                	//validateData - nod cd 
        		   validateData=sheetObj.GetCellValue(Row,"vndr_seq");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH08);
                  //if row count is lesser than 1 
                    if(retValidate < 1) {
                        sheetObj.SelectCell(Row,"vndr_seq");
                    } else {
                        sheetObj.SetCellValue(Row,"vndr_name",comData1,0);
                    }
                }  
           }
        } 
    }
     function getVender(rowArray, row, col) {
        var sheetObj=sheetObjects[0];
    	var colArray=rowArray[0];
    	sheetObj.SetCellValue(row, "vndr_seq",colArray[2],0);
    	sheetObj.SetCellValue(row, "vndr_name",colArray[4],0);
    }
/**
 * Location : in case of selecting radio button
 */
    function getNode(rowArray, row, col) {
        var sheetObj=sheetObjects[0];
    	var colArray=rowArray[0];
    	if (col == sheetObj.SaveNameCol("org_loc")) {
    		sheetObj.SetCellValue(row, "org_type",colArray[3].substring(5),0);
    	} else if (col == sheetObj.SaveNameCol("dest_loc")) {
    		sheetObj.SetCellValue(row, "dest_type",colArray[3].substring(5),0);
    	}
    	sheetObj.SetCellValue(row, col,colArray[3].substring(0,5),0);
    }
    // checking validation of Location code
    function validateLocation(loc, num) {
    	if (num ==1) {
        	document.form.i_org_cd.value=loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_dest_cd.value=loc.toUpperCase();
    	}        
        validateData=loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    	if(retValidate < 1) {
        	if (num ==1) {
            	document.form.i_org_cd.value="";
            	document.form.i_org_cd.focus();
        	}
        	if (num ==2) {
            	document.form.i_dest_cd.value="";
            	document.form.i_dest_cd.focus();
        	}
    	}
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	for(var i=1 ; i<=sheetObj.GetTotalRows();i++){
    		if(sheetObj.GetCellValue(i,"fc") == "T"){
    			sheetObj.SetCellEditable(i, "rail_crr_tp_cd",1);
    		}else{
    			sheetObj.SetCellEditable(i, "rail_crr_tp_cd",0);
    		}
    	}
    }
    function sendDataToGrid(sheetObject) {
          var openerSheet=opener.sheet2 ;
          if(sheetObject.CheckedRows("chk")>0) {
                var iRow=document.form.row.value;
                var iCheckRow=sheetObject.FindCheckedRow("chk");
                var arrRow=iCheckRow.split("|");
                var insertRow=parseInt(arrRow[0]);
                if(sheetObject.GetRowStatus(insertRow) == 'I') {
                   ComShowMessage( ComGetMsg('PRD90035'));
                   return;
               }
					openerSheet.SetCellValue( iRow, "lnk_org_loc"        ,sheetObject.GetCellValue( insertRow , "org_loc") ,0);
					openerSheet.SetCellValue( iRow, "lnk_org_type"        ,sheetObject.GetCellValue( insertRow , "org_type") ,0);
					openerSheet.SetCellValue( iRow, "lnk_dest_loc"        ,sheetObject.GetCellValue( insertRow , "dest_loc") ,0);
					openerSheet.SetCellValue( iRow, "lnk_dest_type"       ,sheetObject.GetCellValue( insertRow , "dest_type") ,0);
					openerSheet.SetCellValue( iRow, "trsp_mod_cd"         ,sheetObject.GetCellValue( insertRow , "trsp_mod_cd") ,0);
					openerSheet.SetCellValue( iRow, "vndr_seq"            ,sheetObject.GetCellValue( insertRow , "vndr_seq") ,0);
					openerSheet.SetCellValue( iRow, "vndr_name"           ,sheetObject.GetCellValue( insertRow , "vndr_name") ,0);
					openerSheet.SetCellValue( iRow, "tztm_hrs"            ,sheetObject.GetCellValue( insertRow , "fmt_tztm_hrs") ,0);// only being shown on openerSheet
					openerSheet.SetCellValue( iRow, "lnk_dist"            ,sheetObject.GetCellValue( insertRow , "lnk_dist") ,0);
					openerSheet.SetCellValue( iRow, "dist_ut_cd"          ,sheetObject.GetCellValue( insertRow , "dist_ut_cd") ,0);
					openerSheet.SetCellValue( iRow, "rail_crr_tp_cd"      ,sheetObject.GetCellValue( insertRow , "rail_crr_tp_cd") ,0);
					openerSheet.SetCellValue( iRow, "lnk_org_nod_cd"      ,sheetObject.GetCellValue( insertRow , "lnk_org_nod_cd") ,0);
					openerSheet.SetCellValue( iRow, "lnk_dest_nod_cd"     ,sheetObject.GetCellValue( insertRow , "lnk_dest_nod_cd") ,0);
					var org=sheetObject.GetCellValue( insertRow , "org_loc").substring(0,2);
					var dest=sheetObject.GetCellValue( insertRow , "dest_loc").substring(0,2);
					if( (org == "US" || org == "CA"  ) && (dest == "US" || dest == "CA" ) &&  sheetObject.GetCellValue( insertRow , "trsp_mod_cd") =="RD" ) {
            	    openerSheet.SetCellEditable(iRow,"agmt_no",1);
            	    openerSheet.SetCellEditable(iRow,"rail_crr_tp_cd" ,1);
            	}
           }
  ComClosePopup(); 
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
