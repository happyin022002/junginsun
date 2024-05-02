/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_5001.js
*@FileTitle  : BKG Term Mapping Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_5001 : business script for ESM_PRI_5001
     */
 
   	/* developer job	*/
 // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboXml=new Array();
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
        /**
         * Event handler processing by button name 
         */
        function processButtonClick(){
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                    case "btn_retrieve":                    	
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    case "btn_delete":
                	doActionIBSheet(sheetObject, formObject, IBDELETE);
   					break;
                    case "btn_rowadd":
						doActionIBSheet(sheetObject,formObject,IBINSERT);
						sheetObject.SetTotalRows();
						break;
                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                	ComShowMessage(ComGetMsg(OBJECT_ERROR));
                } else {
                	ComShowMessage(e.message);
                }
            }
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
			for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet(sheetObjects[i]);//
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);//
			}
			//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	    	//axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	    	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    	axon_event.addListenerForm('change', 'obj_change', document.form); 
	    	axon_event.addListenerForm('click', 'obj_click', document.form); 
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
  	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                         //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 var HeadTitle0="|Sel.|Del Check|Seq.|Contract Type|Service Scope|Ori./Dest Type|BKG Term Code|Contract Term Code";

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle0, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                     {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                     {Type:"Combo",     Hidden:0, Width:175,  Align:"Center",  ColMerge:1,   SaveName:"prc_ctrt_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:175,  Align:"Center",  ColMerge:1,   SaveName:"rep_svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:175,  Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:175,  Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_de_term_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:175,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_rcv_de_term_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                  
                 InitColumns(cols);
                 resizeSheet();//SetSheetHeight(585);
                 SetEditable(1);//Editkind[optional,Defaultfalse]
                 SetColHidden("del_chk",1);
                 }


                    break;
            }
        }
        function resizeSheet(){
         	ComResizeSheet(sheetObjects[0]);
         }
        /**
         * registering IBCombo Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj){
        	sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * handling process for Sheet
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
            	case IBCLEAR:          //retrieve
			        sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					fromSetIBCombo(sheetObj,repSvcScpCdComboValue,repSvcScpCdComboText,"rep_svc_scp_cd");		
					fromSetIBCombo(sheetObj,prcCtrtTpCdComboValue,prcCtrtTpCdComboText,"prc_ctrt_tp_cd");
					fromSetIBCombo(sheetObj,orgDestTpCdComboValue,orgDestTpCdComboText,"org_dest_tp_cd");
					fromSetIBCombo(sheetObj,bkgRcvDeTermCdComboValue,bkgRcvDeTermCdComboText,"bkg_rcv_de_term_cd");
					fromSetIBCombo(sheetObj,ctrtRcvDeTermCdComboValue,ctrtRcvDeTermCdComboText,"ctrt_rcv_de_term_cd");
					ComOpenWait(false);
					break;
                case IBSEARCH:      //retrieve    
                	var validChk;
                	if(formObj.f_cmd.value == MULTI) {	//save
                		validChk = true;
                	} else {
                		validChk = validateForm(sheetObj,formObj,IBSEARCH);
                	}
                		
                	if(validChk){
                		 sheetObj.SetWaitImageVisible(0);
                    	 ComOpenWait(true);
                		 formObj.f_cmd.value=SEARCH;
                		 sheetObj.DoSearch("ESM_PRI_5001GS.do", FormQueryString(formObj) );
                         ComOpenWait(false);                         
       		 		}  
                    break;
                case IBINSERT:	
					sheetObj.DataInsert(-1);
					break;
				case IBSAVE: // Save
					if(validateForm(sheetObj,formObj,IBSAVE)){
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
			     		formObj.f_cmd.value=MULTI;
		     			var sParam=sheetObjects[0].GetSaveString(false, true, "ibflag");
		     			var sXml=sheetObjects[0].GetSaveData("ESM_PRI_5001GS.do", "f_cmd=" + MULTI + "&" +sParam);
		     			var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     			if(transResultKey=="S"){
		     				ComShowCodeMessage("COM130102","Data");//Success
							doActionIBSheet(sheetObj,formObj,IBSEARCH);
							ComOpenWait(false);
		     			}else{
		     				ComShowCodeMessage("COM12151",'Data'); //Failed 
		     				ComOpenWait(false);
		     				break;
		     			}
		     		}
					break;
				case IBDELETE: // Delete
       		 		if(validateForm(sheetObj,formObj,IBDELETE)){
       		 			deleteRowCheck(sheetObj, "chk", true);
       		 		}
       		 		break;	 
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction){
            case IBSEARCH:      	
	            if(sheetObjects[0].IsDataModified()){
	            	if ( ComShowCodeConfirm("PRI00010") ) {
                		return true;
    				}	            	
		            return false;       
	            }	            
	            return true;
	            break;
			case IBSAVE:
				var SaveChk=0;
	        	for( var i=1 ; i<=sheetObj.RowCount(); i++){
	        		if(sheetObj.GetCellValue(i,"ibflag")=='I'){
		        		SaveChk=SaveChk+1;
		        		if(sheetObj.GetCellValue(i, "prc_ctrt_tp_cd")==null || sheetObj.GetCellValue(i, "prc_ctrt_tp_cd")==""){
		        			ComShowCodeMessage('COM130403', 'Contract Type');//key field missing
		        			sheetObj.SelectCell(i, "prc_ctrt_tp_cd");
							return false;
							break;
		        		}else if(sheetObj.GetCellValue(i, "rep_svc_scp_cd")==null || sheetObj.GetCellValue(i, "rep_svc_scp_cd")==""){
							ComShowCodeMessage('COM130403', 'Service Scope');//key field missing
							sheetObj.SelectCell(i, "rep_svc_scp_cd");
							return false;
							break; 
		        		}else if(sheetObj.GetCellValue(i, "org_dest_tp_cd")==null || sheetObj.GetCellValue(i, "org_dest_tp_cd")==""){
							ComShowCodeMessage('COM130403', 'Ori./Dest Type');//key field missing
							sheetObj.SelectCell(i, "org_dest_tp_cd");
							return false;
							break; 
		        		}else if(sheetObj.GetCellValue(i, "bkg_rcv_de_term_cd")==null || sheetObj.GetCellValue(i, "bkg_rcv_de_term_cd")==""){
							ComShowCodeMessage('COM130403', 'BKG Term Code');//key field missing
							sheetObj.SelectCell(i, "bkg_rcv_de_term_cd");
							return false;
							break; 
		        		}else if( sheetObj.GetCellValue(i, "ctrt_rcv_de_term_cd")==null || sheetObj.GetCellValue(i, "ctrt_rcv_de_term_cd")=="" ){
							ComShowCodeMessage('COM130403', 'Contract Term Code');//key field missing
							sheetObj.SelectCell(i, "ctrt_rcv_de_term_cd");
							return false;
							break;
						}
		        	}
	        		if(sheetObj.GetCellValue(i,"ibflag")=="D"){
	        			SaveChk=SaveChk+1;
	        		}
	        	}
	        	if(SaveChk < 1){
	        		 //var msg = ComGetMsg("PRI00301");//'There is no data to save.'
	        		 ComShowCodeMessage("PRI00301");
	        		 return false;
	        		 break;
	        	}
				var dr=sheetObj.ColValueDup("prc_ctrt_tp_cd|rep_svc_scp_cd|org_dest_tp_cd|bkg_rcv_de_term_cd|ctrt_rcv_de_term_cd");
				if(dr>0){//duplication
					sheetObj.SetSelectRow(dr);
					ComShowCodeMessage('COM12115', 'BKG Term Mapping Creation');
					ComSetFocus(sheetObj.ColValueDupRows("prc_ctrt_tp_cd"));
					return false;
					break;
				}
				return true;
				break;
			case IBDELETE:
	        	var locChk=0; var locChkAll=0;
	        	for( var i=1 ; i<=sheetObj.RowCount(); i++){
	        		locChk=sheetObj.GetCellValue(i,"chk"); // no '0' , yes '1'
	        		locChkAll=locChkAll+locChk;
	        	}
	        	if(locChkAll < 1){
//	        		 var msg = ComGetMsg("PRI04006");
	        		 ComShowCodeMessage("PRI04006");
//	        		 alert(msg);
	        		 return false;
	        	}
        		break;
	    	}
	    	return true;
        }
	    function sheet1_OnClick(sheetObj, Row, Col, Value)  {
	 		var colName=sheetObj.ColSaveName(Col);
	 		if (colName == "chk") {
	 			if (Value == "0") {
	 				sheetObj.SetCellValue(Row, "del_chk","0");
	 			}	
	 		}
	 	}
	function fromSetIBCombo(sheetObj,codeString,nameString,title,iBlank, sCol, dCode, dText, bFlag){
        var showCol=0;
        if (bFlag == undefined || bFlag == ""){
            bFlag=false;
        }
        if (sCol != undefined && sCol !=""){
            showCol=sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank=false;
        }
        if (codeString != null && nameString != null){
            var arrCode=codeString.split("|");
            var arrName=nameString.split("|");
            var conData="";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i]=arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i]=arrCode[i]+"\t"+arrName[i];
                }
                conData=conData.concat(arrName[i]);
            }
           // nameString = conData;
        }
        if(iBlank){
            if (arrData != null){
                arrData[0]=" |" + arrData[0];
                arrData[1]=" |" + arrData[1];
            }
        }
        if (codeString != null && nameString != null){
            sheetObj.SetColProperty(title, {ComboText:nameString, ComboCode:codeString});
        	 //sheetObj.SetColProperty(title, {ComboText:nameString , ComboCode:dText} );
            
        }
    }
	/* developer job end */
