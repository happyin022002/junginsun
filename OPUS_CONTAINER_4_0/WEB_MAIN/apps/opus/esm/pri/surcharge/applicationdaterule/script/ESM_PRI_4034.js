/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4034.js
*@FileTitle  : Route Location Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
	/**
	 * @extends
	 * @class ESM_PRI_4034 : ESM_PRI_4034 task script definition for screen
	 */

    // public variable
	var sheetObjects=new Array(); 
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var saveChk=0;
	
	var gv_btn_popup = "";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
     function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
 		         var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
             switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObjects[0], formObject, IBRESET);
						break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_exceldown":
						if(sheetObject.RowCount() < 1){//no data
			        		ComShowCodeMessage("COM132501");
			        	}else{
			        		 var strCol = getExcelCol(2, sheetObject.LastCol());
			        		 sheetObject.Down2Excel({ HiddenColumn:1, DownCols:strCol,CheckBoxOnValue:"Y",CheckBoxOffValue:" ", AutoSizeColumn: 0});
			        	}
						//doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
						break;
					case "btn_RowAdd":
						addRow();
						break;
					case "btn_RowDel":
						deleteRow();
						break;
					case "btn_orgpopup":	
						gv_btn_popup = 	"btn_orgpopup";
						ComOpenPopup("/opuscntr/COM_ENS_051.do", 800, 460,"setLocationCd", "1,0,1,1,1", true);
						break;	
					case "btn_convpopup":
						gv_btn_popup = 	"btn_convpopup";
						ComOpenPopup("/opuscntr/COM_ENS_051.do", 800, 460,"setLocationCd", "1,0,1,1,1", true);
						break;	
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     
     function getExcelCol(StartCol, EndCol) {
   		var retVal = "";
   		for(var i = StartCol; i <= EndCol; i++) {
   			if(i != EndCol) {
   				retVal = retVal + i + "|";
   			} else {
   				retVal = retVal + i;
   			}
   		}
   		return retVal;
   	}
     
     
     /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
     function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++]=sheet_obj;
     }
     function setComboObject(combo_obj) {  
    		comboObjects[comboCnt++]=combo_obj;  
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
          // Event needed for screen
     	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
     	//axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
     	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListenerForm('change', 'obj_change', document.form); // change
     	axon_event.addListenerForm('click', 'obj_click', document.form); // click
     	var comboObjMaxLen=comboObjects.length; 
		for(i=0; i < comboObjMaxLen; i++ ) {
			// IBCombo 초기화
			initCombo(comboObjects[i], i+1);
		}
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01); //COMBO BOX
     }
      /** 
       * combo box for retrieve scope code<br>
       */ 
      function initCombo(comboObj, comboNo) {
    	 	var formObj=document.form;
    	 	switch(comboObj.options.id) {  
    	 		case "scp_cd":
    	 			with (comboObj) {
    	 				SetMultiSelect(0);
    	 				SetUseAutoComplete(1);
    	 				SetDropHeight(190);
    	 				GetColWidth=50;
    	 				ValidChar(2);
    	 			}
    	 		break;
    	 }
      }
       /**
        * setting sheet initial values and header
        * 
        * adding case as numbers of counting sheets
        */
      function initSheet(sheetObj,sheetNo) {
          var cnt=0;
          switch(sheetNo) {
              case 1:      //sheet1 init
            	    with(sheetObj){
               
                var HeadTitle1="||Seq.|Scope|Original Location|Conversion Location|POR|POL|POD|DEL|PreRelay|PostRelay";
                var headCount=ComCountHeadTitle(HeadTitle1);
                (headCount, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check",TrueValue:"Y", FalseValue:"N"},
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Combo", Hidden:0, Width:100,  Align:"Center",    ColMerge:1,   SaveName:"svc_scp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                       {Type:"PopupEdit", Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:"org_loc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,  InputCaseSensitive:1, AcceptKeys:"E"},
                       {Type:"PopupEdit", Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:"conv_loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"por_appl_flg" ,TrueValue:"Y", FalseValue:"N"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"pol_appl_flg" ,TrueValue:"Y", FalseValue:"N"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"pod_appl_flg" ,TrueValue:"Y", FalseValue:"N"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"del_appl_flg" ,TrueValue:"Y", FalseValue:"N"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_appl_flg" ,TrueValue:"Y", FalseValue:"N"},
                       {Type:"CheckBox",  Hidden:0, Width:77,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_appl_flg" ,TrueValue:"Y", FalseValue:"N"} ];
                 
                InitColumns(cols);
                SetColProperty(0 ,"org_loc_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                SetColProperty(0 ,"conv_loc_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                resizeSheet(); 
                //SetSheetHeight(440);
                SetEditable(1);
                      }
                break;
         }
     }
      
     function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	 }

   //  handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	     	case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH; 
				var sParam=FormQueryString(formObj);
				sheetObj.DoSearch("ESM_PRI_4034GS.do",sParam );
				break;
	     	case SEARCH01:   //combo retrieve
	     		sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj);
				var xml=sheetObj.GetSearchData("ESM_PRI_4034GS.do",sParam);
				var rslt=ComGetEtcData(xml, "scpcd");
				setPortCombo(rslt);
				sheetObj.SetWaitImageVisible(1);
				break;
			case SEARCH02:	//check if there are the same data in DB
				  formObj.f_cmd.value=SEARCH02;
				  sheetObj.SetWaitImageVisible(0);
				  var sXml=sheetObj.GetSaveData("ESM_PRI_4034GS.do", FormQueryString(formObj));
				  var valResult=ComGetEtcData(sXml, "samecd_cnt");
				  if(valResult == '1'){
				  ComShowCodeMessage('PRI00302'); // Duplicate data found, please recheck.
				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "scp_cd",'',0);
				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "org_loc_cd",'',0);
				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_loc_cd",'',0);
				  saveChk++;
				  return false;
				  }
				  return true;
				break;
			case SEARCH03:	//check if org and conv code are real location
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSaveData("ESM_PRI_4034GS.do", FormQueryString(formObj));
				var valResult=ComGetEtcData(sXml, "check_loc");
				var loc_name;
				var colName = sheetObj.ColSaveName(sheetObj.GetSelectCol());
				if(valResult == 0){
					saveChk++;
					if(colName == "org_loc_cd"){
						loc_name=formObj.chk_location.value;
						ComShowCodeMessage('PRI06017', loc_name);//That Location code doesn\'t exist.
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "org_loc_cd",'',0);
						return false;
					}
					else{
						loc_name=formObj.chk_location.value;
						ComShowCodeMessage('PRI06017',loc_name);//That Location code doesn\'t exist.
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_loc_cd",'',0);
						return false;
					}
				}
				return true;
				break;  
			case SEARCH04://check if the scope include that location
				formObj.f_cmd.value=SEARCH04;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSaveData("ESM_PRI_4034GS.do", FormQueryString(formObj));
				var valResult=ComGetEtcData(sXml, "check_scp");
				var loc_name=formObj.chk_location.value;
				var scp_val=formObj.chk_scp_cd.value;
				var selrow=sheetObj.GetSelectRow();
				if(valResult != 1){
					saveChk++;
					if(sheetObj.GetCellValue(selrow,"por_appl_flg") == 1 || sheetObj.GetCellValue(selrow,"pol_appl_flg") == 1){
						if(sheetObj.GetSelectCol()=="por_appl_flg" || sheetObj.GetSelectCol=="pol_appl_flg"){
							ComShowCodeMessage('PRI06019', scp_val, loc_name);//The scope[{?msg1}] doesn\'t include [{?msg2}].\nPlease input right location for that scope.
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),'',0);
						}else{
							ComShowCodeMessage('PRI06019', scp_val, loc_name);//The scope[{?msg1}] doesn\'t include [{?msg2}].\nPlease input right location for that scope.
							if(sheetObj.GetCellValue(selrow,"pol_appl_flg") == 1 && sheetObj.GetCellValue(selrow,"por_appl_flg") == 1){
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "por_appl_flg",'',0);
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pol_appl_flg",'',0);
							}else if(sheetObj.GetCellValue(selrow,"por_appl_flg") == 1)
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "por_appl_flg",'',0);
							else if(sheetObj.GetCellValue(selrow,"pol_appl_flg") == 1)
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pol_appl_flg",'',0);
						}
					}
					else{
						if(sheetObj.GetSelectCol()=="pod_appl_flg" || sheetObj.GetSelectCol== "del_appl_flg"){
							ComShowCodeMessage('PRI06019', scp_val, loc_name);//The scope[{?msg1}] doesn\'t include [{?msg2}].\nPlease input right location for that scope.
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),'',0);
						}else{
							ComShowCodeMessage('PRI06019', scp_val, loc_name);//The scope[{?msg1}] doesn\'t include [{?msg2}].\nPlease input right location for that scope.
							if(sheetObj.GetCellValue(selrow,"pod_appl_flg") == 1 && sheetObj.GetCellValue(selrow,"del_appl_flg") == 1){
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pod_appl_flg",'',0);
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "del_appl_flg",'',0);
							}
							else if(sheetObj.GetCellValue(selrow,"pod_appl_flg") == 1)
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pod_appl_flg",'',0);
							else if(sheetObj.GetCellValue(selrow,"del_appl_flg") == 1)
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "del_appl_flg",'',0);
						}
					}
					return false;
				}
				return true;
				break; 
	     	case IBRESET: // New
	     		if (!validateForm(sheetObj, formObj, sAction)) return false;
				formObj.reset();
 				sheetObjects[0].RemoveAll();
 				loadPage();
				break;
	     	case IBSAVE: // Save
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				
				formObj.f_cmd.value=MULTI;
				var sheet2=sheetObjects[1];
				// sheet2.RemoveAll();
				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml=sheetObjects[0].GetSaveData("ESM_PRI_4034GS.do", "f_cmd=" + MULTI + "&" +sParam);
				if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key) == "S"){
					ComShowCodeMessage('PRI00101'); //Data saved successfully.
				}else{
					ComShowCodeMessage('PRI00201'); // Problem occurred while saving data.
					ComOpenWait(false, false);
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			case "btn_exceldown":
				sheetObj.Down2Excel({ HiddenColumn:1});
				break;
	     }
	 }
     /** 
      * Validation check on sheet <br>
      */ 
      function sheet1_OnChange(sheetObj, Row, Col, Value){
    	   	var formObj=document.form;
    	   	saveChk = 0;
    	   	if(sheetObj.ColSaveName(Col) == "svc_scp_cd"||sheetObj.ColSaveName(Col) == "org_loc_cd"||sheetObj.ColSaveName(Col) == "conv_loc_cd"||sheetObj.ColSaveName(Col) == "pod_appl_flg"||sheetObj.ColSaveName(Col) == "pol_appl_flg"||sheetObj.ColSaveName(Col) == "por_appl_flg"||sheetObj.ColSaveName(Col) == "del_appl_flg"){
    	   		formObj.chk_scp_cd.value=sheetObj.GetCellValue(Row, "svc_scp_cd");
    	   		formObj.chk_org_cd.value=sheetObj.GetCellValue(Row, "org_loc_cd");
    	   		formObj.chk_conv_cd.value=sheetObj.GetCellValue(Row, "conv_loc_cd");
    	   		if(sheetObj.ColSaveName(Col) == "org_loc_cd"||sheetObj.ColSaveName(Col) == "conv_loc_cd"){
    	   			formObj.chk_location.value=sheetObj.GetCellValue(Row, Col); // check if org and conv code are real location
    	   			if(formObj.chk_location.value != ""){
    	   				if(!doActionIBSheet(sheetObj, formObj, SEARCH03)){
    	   					return false;
    	   				}
    	   			}
		    		if(sheetObj.GetCellValue(Row,"org_loc_cd")!= '' && sheetObj.GetCellValue(Row,"conv_loc_cd")!= ''){
		    			if(sheetObj.GetCellValue(Row,"org_loc_cd") == sheetObj.GetCellValue(Row,"conv_loc_cd")){
		    				saveChk++;
		    				ComShowCodeMessage('PRI06018',"Origin Location","Conversion Location");
		    				if(sheetObj.ColSaveName(Col) == "org_loc_cd"){
		    					sheetObj.SetCellValue(Row, "org_loc_cd", "");
		    				}else{
		    					sheetObj.SetCellValue(Row, "conv_loc_cd", "");
		    				}
		    				return false;
		    			}
		    		}
	    		}
    	   		if(sheetObj.GetCellValue(Row,"org_loc_cd") != '' || sheetObj.GetCellValue(Row,"conv_loc_cd") != ''){
    	   			if(sheetObj.GetCellValue(Row,"por_appl_flg") != '' || sheetObj.GetCellValue(Row,"pod_appl_flg") != '' || sheetObj.GetCellValue(Row,"pol_appl_flg") != '' || sheetObj.GetCellValue(Row,"del_appl_flg") != ''){
    	   				if(sheetObj.GetCellValue(Row, "por_appl_flg") == 1 || sheetObj.GetCellValue(Row, "pol_appl_flg") == 1 ){
    	   					formObj.chk_flg.value=1;
    	   				}else{
    	   					formObj.chk_flg.value=0;
    	   				}
    	   				if(sheetObj.GetCellValue(Row,"org_loc_cd") != ''){
    	   					formObj.chk_location.value=sheetObj.GetCellValue(Row, "org_loc_cd");
    	   					if(!doActionIBSheet(sheetObj, formObj, SEARCH04)){ //check if the scope include that location
    	   						return false;
    	   					}
    	   				}if(sheetObj.GetCellValue(Row,"conv_loc_cd") != ''){
    	   					formObj.chk_location.value=sheetObj.GetCellValue(Row, "conv_loc_cd");
    	   					if(!doActionIBSheet(sheetObj, formObj, SEARCH04)){ //check if the scope include that location
    	   						return false;
    	   					}
    	   				}
	   				}
    	   		}
    	   		if(sheetObj.GetCellValue(Row,"svc_scp_cd")!= '' && sheetObj.GetCellValue(Row,"org_loc_cd")!= '' && sheetObj.GetCellValue(Row,"conv_loc_cd")!= ''){
    	   			if(sheetObj.GetCellValue(Row,"ibflag")== 'I')
						if(doActionIBSheet(sheetObj, formObj, SEARCH02)){
							return false; //check if there are the same data in DB
						}
	   			}
	   		}
	    }

     /**
     * handling process for input validation
     */
       function validateForm(sheetObj,formObj,sAction){
     	 with(formObj){
     		if (sAction == IBSAVE){
     			if(saveChk>0){
     				saveChk = 0;
     				return false;
     			}
     			var change=0;
     			var sheet1RowCount=sheetObj.RowCount();
     			var thisrow=sheetObj.GetSelectRow();
     			for(var i=1; i <= sheet1.RowCount(); i++ ){
	   				if(sheetObjects[0].GetCellValue(i, "ibflag") == 'I' || sheetObjects[0].GetCellValue(i, "ibflag") == 'U' || sheetObjects[0].GetCellValue(i, "ibflag") == 'D'){
	   					change=change + 1;
	   				}
	   				if(sheetObjects[0].GetCellValue(i, "ibflag") == 'D'){
	   					continue;
	   				}
	   				if(sheetObj.GetCellValue(i,"org_loc_cd") ==''){
		   				ComShowCodeMessage('PRI00335','Original Location');//[{?msg1}] has not been inputted.
		   				sheetObj.SelectCell(i, "org_loc_cd", true, "");
		   				return false;
	   				}
	   				if(sheetObj.GetCellValue(i,"conv_loc_cd") ==''){
		   				ComShowCodeMessage('PRI00335','Conversion Location');//[{?msg1}] has not been inputted.
		   				sheetObj.SelectCell(i, "conv_loc_cd", true, "");
		   				return false;
	   				}
	   			}
	   			if(sheetObj.GetCellValue(thisrow,"por_appl_flg") == 0 && sheetObj.GetCellValue(thisrow,"pod_appl_flg") == 0 && sheetObj.GetCellValue(thisrow,"pol_appl_flg") == 0 && sheetObj.GetCellValue(thisrow,"del_appl_flg") == 0){
	   				ComShowCodeMessage('PRI06020','POR, POL','POD, DEL');//You should check either [{?msg1}] or [{?msg2}]
	   				return false;
	   			}
	   			if((sheetObj.GetCellValue(thisrow,"por_appl_flg") == 1 || sheetObj.GetCellValue(thisrow,"pol_appl_flg") == 1) && (sheetObj.GetCellValue(thisrow,"pod_appl_flg") == 1 || sheetObj.GetCellValue(thisrow,"del_appl_flg") == 1)){
	   				sheetObj.SetCellValue(thisrow,sheetObj.GetSelectCol(),'');
	   				ComShowCodeMessage('PRI06020','POR, POL','POD, DEL');//You should check either [{?msg1}] or [{?msg2}]
	   				return false;
	   			}
	   			if(change==0){
	   				ComShowCodeMessage('PRI00301');
	   				return false;
	   			}
     		 }
     		 else if (sAction == IBRESET){
	       	     if (sheetObj.IsDataModified()){
	   					if(!ComShowConfirm(ComGetMsg("PRI06016"))){ 
	   						return false; //There is modified data.Do you want to continue?
	   					}
		    		 }
      		} 
     	 }
           return true;
       }
 	 /**
       * calling function for OnPopupClick event <br>
       * @param {ibsheet} sheetObj
       * @param {int} Row 
       * @param {int} Col 
       * @param {str} Value 
       * @return void
       */
       function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
    	    var colname=sheetObj.ColSaveName(Col);
    		var formObj=document.form;
        	switch(colname)
        	{
        		case "org_loc_cd":     	
        			ComOpenPopup("/opuscntr/COM_ENS_051.do", 800, 460,"getLocationCd","1,0,1,1,1", true);
        			break;
     	    	case "conv_loc_cd":
     	    		ComOpenPopup("/opuscntr/COM_ENS_051.do", 800, 460,"getLocationCd","1,0,1,1,1", true);
    	    		break;	
        	}
       }  
	/**
	 * add row process in sheet1
	 * add one row
	 */
	 	function addRow() {
	 	  with (sheetObjects[0]) {
	         var nowRow=GetSelectRow();
	       	 nowRow=DataInsert(-1);
	       	 sheetObjects[0].SelectCell(nowRow, "org_loc_cd", true, "");
	         return true;
	          }
	 }
	/**
	 * delete row process in sheet1
	 * delete one row
	 */  
	 function deleteRow() {
	     with (sheetObjects[0]) {
	         var sRowStr=FindCheckedRow("check");
	         if(sRowStr == null || sRowStr == "" || sRowStr == undefined){
	        	 SetRowStatus(GetSelectRow(),"D");
	        	 SetRowHidden(GetSelectRow(),"1");
	         }else{
	        	 var arr=sRowStr.split("|");
		         for (var i=0; i < arr.length; i++) {
		        	 SetRowStatus(arr[i],"D");
		             SetRowHidden(arr[i],"1");
		         }
	         }
	     }         
	 }
	  /** 
	  * setPortCombo <br>
	  * @param  rslt
	  * @return void
	  */   
	 function setPortCombo(rslt){
		 var formObject=document.form;
			if(rslt != null && rslt != undefined && rslt != ""){
				sheetObjects[0].SetColProperty("svc_scp_cd", {ComboText:rslt, ComboCode:rslt} );
				scp_cd.RemoveAll();
				var rsltArr=rslt.split("|");
				scp_cd.InsertItem(-1, "ALL", ' ');
				for (var i=0 ; i < rsltArr.length ; i++) {
					scp_cd.InsertItem(-1, rsltArr[i], rsltArr[i]);
				}
				scp_cd.SetEnable(1);
			}
		}
	 /** 
	  * setLocationCd : getting return value <br>
	  * @param  {IBSheet} aryPopupData 
	  * @return void
	  */ 
	  function setLocationCd(aryPopupData) {
	      var formObject=document.form;
	      //var srcName=ComGetEvent("name");
	      var srcName=gv_btn_popup;
	      switch(srcName) {
			case "btn_orgpopup":
				formObject.frm_org_loc_cd.value=aryPopupData[0][3];
				break;
			case "btn_convpopup":
			  formObject.frm_conv_loc_cd.value=aryPopupData[0][3];
			  break;
	      }
	  }
		 /** 
		  * getLocationCd : getting return value <br>
		  * @param  {IBSheet} aryPopupData  
		  * @return void
		  */ 
	  function getLocationCd(aryPopupData) {
		  var sel_col=sheetObjects[0].GetSelectCol();
		  if(sel_col==4)
			  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"org_loc_cd",aryPopupData[0][3]);
		  else
			  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"conv_loc_cd",aryPopupData[0][3]);
	  } 
