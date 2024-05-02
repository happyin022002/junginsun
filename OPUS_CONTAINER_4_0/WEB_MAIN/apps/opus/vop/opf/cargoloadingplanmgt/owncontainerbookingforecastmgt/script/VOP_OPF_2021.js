/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : vop_opf_2021.jsp
*@FileTitle  : Weight Group (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class vop_opf_2021 : vop_opf_2021 business script for
     */
  
   	/* Developer performance	*/
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
	         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
      		var prefix="sheet1_";
            switch(srcName) {
            	case "slan_cd_pop":
            		var slan_cd=formObject.slan_cd.value;
            		ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 500, 480, "setSlanCd", "0,0", true);
            		break;
            	case "pol_cd_pop":
            		var port_cd=formObject.pol_cd.value;
            		ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 450, 500, "setPolCd", "0,0", true);
            		break;
				case "btn_Retrieve":
					if(!ComChkValid(formObject)) {
						return false;
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_Close":
					ComClosePopup(); 
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
    	var formObject=document.form;
    	for(var x=0; x<formObject.skd_dir_cd.length; x++){
    		if(formObject.skd_dir_cd[x].value == formObject.sel_skd_dir_cd.value){
    			formObject.skd_dir_cd[x].selected=true;
    		}
    	}    	
		for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
		//Lane Name
		slan_cd_change();
	}
    /**
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects
     **/
    function initControl(){
//    	axon_event.addListener  ('keypress', 'eng_keypress' , 'slan_cd', 'skd_dir_cd', 'pol_cd');
    	axon_event.addListener  ('change'  , 'slan_cd_change', 'slan_cd');			
    	axon_event.addListener  ('change'  , 'pol_cd_change', 'pol_cd');			
    	axon_event.addListener  ('focus'  , 'focus_event', 'slan_cd', 'pol_cd');
    	// Enter Key Search.
//       axon_event.addListener ('keydown', 'ComKeyEnter', 'slan_cd', 'skd_dir_cd', 'pol_cd');
       // axon_event.addListener    ('keydown',  'ComKeyEnter', 'form');
    }
    /**
     * input only english and number on onKeypress of HTML Control<br>
     **/
    function eng_keypress() {    	 
    	switch (event.srcElement.name) {
			case "slan_cd":
				//inputting capital
				ComKeyOnlyAlphabet('uppernum');
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("upper");
				break;
    	}
    }
    /**
	 * part of Slan Code input<br>
	 * @param {arry} aryPopupData
	 */
    function setSlanCd(aryPopupData){
		form.slan_cd.value=aryPopupData[0][1];
		form.slan_cd_desc.value=aryPopupData[0][3];
    }
    /**
	 * part of Pol Code input.<br>
	 * @param {arry} aryPopupData
	 */
    function setPolCd(aryPopupData){
//		form.pol_cd.value=aryPopupData[0][2];
    	form.pol_cd.value=aryPopupData;
    }
    /**
     * get Name appliable in case of changing Slan Code <br>
     **/
    function slan_cd_change() {
    	document.form.slan_cd_desc.value="";
    	var slanCdObj=document.form.slan_cd;
    	if(slanCdObj.value != null && slanCdObj.value !=""){
    		if(slanCdObj.value.length != slanCdObj.maxLength){
    			ComShowCodeMessage("OPF50007", "Lane", slanCdObj.maxLength);
    			slanCdObj.focus();
    			return false;
    		}
    		else if(!isTrue(doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "SlanCd"))){
    			return false;
    		}
    	}
    }
    /**
     * get Name appliable in case of changing Pol Code <br>
     **/
    function pol_cd_change() {
    	var polCdObj=document.form.pol_cd;
    	if(polCdObj.value!=null && polCdObj.value!="" ){
    		if(polCdObj.value.length != polCdObj.maxLength){
    			ComShowCodeMessage("OPF50007", "POL", polCdObj.maxLength);
    			polCdObj.focus();
    			return false;
    		}
    		else if(!isTrue(doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "PolCd"))){
    			return false;
    		}
    	}
    }
     /**
      * return whether True/False of value input 
      */
     function isTrue(strValue)
     {
     	if(strValue+""=="false"){
     		return false;
     	}
     	else{
     		return true;
     	}
     }
    function focus_event(){
    	var elementObj=event.srcElement;
    	elementObj.select();
    }
    /**
     * initialize Search condition data value<br>
     */
    function dataClear(){
    	document.form.slan_cd.value="";
    	document.form.slan_cd_desc.value="";
    	document.form.skd_dir_cd.value="E";
    	document.form.pol_cd.value="";
    	//ComBtnEnable("rpr_seq_delete");
    	ComBtnDisable("btn_RowAdd");
    	ComBtnDisable("btn_RowDelete");
    }
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":
                    with (sheetObj) {
                        // setting height
                	
                	var HeadTitle="|No.|Sel.|Weight Group Category|Weight Group Category|20'Full (ton)|20'Full (ton)|40'Full (ton)|40'Full (ton)";
                	var HeadTitle1="|No.|Sel.|Code|Category|From(equal or above)|To(less than)|From(equal or above)|To(less than)";
                	var headCount=ComCountHeadTitle(HeadTitle)+3;
                	(headCount, 0, 0, true);
                	var prefix="sheet1_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"},
                	                { Text:HeadTitle1, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                	             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt_grp_seq", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk", UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt_grp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:105,  Align:"Left",    ColMerge:1,   SaveName:prefix+"wgt_grp_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:152,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt1",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:92,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:152,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt3",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:92,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                	 
                	InitColumns(cols);
                	SetSheetHeight(350);
                	SetEditable(1);
//                	SetGetFocusAfterProcess()(0);
                	SetRangeBackColor(1, 2, 1, 9,"#777777");
					}
                    break;
            }
        }
        function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
        	sheetObj.ShowDebugMsg(false);
    	    switch(sAction) {
    	      case IBSEARCH:      //Retrieve
    	        formObj.f_cmd.value=SEARCH;
     	        sheetObj.DoSearch("VOP_OPF_3019GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
    	        ComBtnEnable("btn_RowAdd");
    	        ComBtnEnable("btn_RowDelete");
    	        break;
    	      case IBROWSEARCH:
    	    	  if(gubun=="SlanCd"){
    	    		  if(formObj.slan_cd.value==null || formObj.slan_cd.value==""){
    	    			  formObj.slan_cd_desc.value="";
    	    			  return false;
    	    		  }
    	    		  else{
    	    			  formObj.f_cmd.value=COMMAND12;
         	    		  var lanXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do?op=0202&vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
        	    		  var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
        	    		  if(strLanCdDesc != null && strLanCdDesc != "" && strLanCdDesc != "undefined"){
        	    			  //formObj.slan_cd.value = strLanCd;
        	    			  formObj.slan_cd_desc.value=strLanCdDesc;
        	    			  formObj.skd_dir_cd.focus();
        	    		  }
        	    		  else{
        	    			  //ComShowMessage("Data is not available.");
        	    			  ComShowCodeMessage("OPF50004", "Lane");
        	    			  formObj.slan_cd.value="";
      						  formObj.slan_cd_desc.value="";
      						  sheetObjects[0].RemoveAll();
      						  ComBtnDisable("btn_RowAdd");
      						  ComBtnDisable("btn_RowDelete");
      						  formObj.slan_cd.focus();
      						  return false;
        	    		  }
    	    		  }
    	    	  }
    	    	  else if(gubun=="PolCd"){
    	    		  formObj.f_cmd.value=COMMAND13;
     	    		  var polXml=sheetObj.GetSearchData("VOP_VSK_0043GS.do?op=0043&loc_cd="+formObj.pol_cd.value , FormQueryString(formObj));
    	    		  var strPolCd=ComGetEtcData(polXml, "port_name");
    	    		  if(strPolCd == null || strPolCd == "" || strPolCd == undefined){
    	    			  //ComShowMessage("Data is not available.");
    	    			  ComShowCodeMessage("OPF50004", "POL");
    	    			  formObj.pol_cd.value="";
    	    			  formObj.pol_cd.focus();
  						  return false;
    	    		  }
					  sheetObjects[0].RemoveAll();
					  ComBtnDisable("btn_RowAdd");
					  ComBtnDisable("btn_RowDelete");
    	    	  }
    	    	  break;
    	    }
    	}
        function sheet1_OnChange(sheetObj, Row, Col, Value){
        	if(sheetObj.GetCellValue(Row, "sheet1_cntr_wgt_grp_seq") == "1" ){
        		sheetObj.SetCellValue(Row, "sheet1_cntr_lmt_wgt2","");
        		sheetObj.SetCellValue(Row, "sheet1_cntr_lmt_wgt4","");
        	}
        	if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt1") || Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt3")){
        		if(Row <= sheetObj.LastRow()&& Value != ""){
        			var vAllDelCnt = sheetObj.RowCount("D");
    				var vLastRow=sheetObj.LastRow();
    				var vDelCnt=0;
					for(var i=Row+1 ; i<=vLastRow; i++){
						if( sheetObj.GetRowStatus(i)=="D" ){
							vDelCnt++;
						}else{
							vLastRow()=0;
						}
					}
					var vFastRow=sheetObj.HeaderRows();
					var vLastRow2=sheetObj.LastRow();
					for(var i=vFastRow ; i<=vLastRow2 ; i++){
						if( sheetObj.GetRowStatus(i)=="D" ){
							vFastRow++;
						}else{
							vLastRow2=0;
						}
					}
					if(vFastRow == Row){
						if( sheetObj.HeaderRows()!= Row){
							if( (Value > ComParseInt(sheetObj.GetCellValue(Row+(vDelCnt+1), Col)))  || (sheetObj.GetCellValue(Row+(vDelCnt+1), Col) == "")){
								sheetObj.SetCellValue(Row+(vDelCnt+1), Col+1,Value);
							}else{
	        					if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt1")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        					}else if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt3")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        					}							
							}
						}
        			}else{
        				if( Row < (sheetObj.LastRow()-vAllDelCnt) )
        				{
        					if( (Value < ComParseInt(sheetObj.GetCellValue(Row-1, Col))) && (Value > ComParseInt(sheetObj.GetCellValue(Row+vDelCnt+1, Col)) || sheetObj.GetCellValue(Row+vDelCnt+1, Col) == "") ){
	        					sheetObj.SetCellValue(Row+(vDelCnt+1), Col+1,Value);
	        				}else{
	        					if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt1")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        					}else if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt3")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        					}
	        				}
        				}else{
        					var vBeForeRow;
        					var vTemp=sheetObj.HeaderRows();
        					for(var x=Row; x>vTemp; x--){
        						if( sheetObj.GetRowStatus(x)!="D"){
        							vBeForeRow=x-1;
        							vTemp=x+2;
        						}
        					}
        					if( (Value < ComParseInt(sheetObj.GetCellValue(vBeForeRow, Col))) || (sheetObj.GetCellValue(vBeForeRow, Col) == "") ){
        						sheetObj.SetCellValue(Row+(vDelCnt+1), Col+1,Value);
        					}else{
	        					if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt1")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        					}else if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt3")){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        					}
        					}
        				}
        			}
        		}
        	}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            if(formObj.slan_cd.value==null || formObj.slan_cd.value==""){
            	ComShowCodeMessage("OPF50009", "Lane");
            	return false;
            }
            else if(formObj.pol_cd.value==null || formObj.pol_cd.value==""){
            	ComShowCodeMessage("OPF50009", "POL");
            	return false;
            }
            if(sheetObj.RowCount()> 0){
	    		for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++){
	    			for(var j=i+1; j<= sheetObj.LastRow(); j++){
						if( sheetObj.GetCellValue(i,"sheet1_cntr_wgt_grp_cd") != null
						&& sheetObj.GetCellValue(i,"sheet1_cntr_wgt_grp_cd") != ""
						&& (sheetObj.GetCellValue(i,"sheet1_cntr_wgt_grp_cd")==sheetObj.GetCellValue(j,"sheet1_cntr_wgt_grp_cd")) )
		    			{
		    				ComShowCodeMessage("OPF50005", "Weight Group Category Code");
		    				if(sheetObj.GetRowStatus(i)=="I"){
		    					sheetObj.SelectCell(i,"sheet1_cntr_wgt_grp_cd",true);
		    				}else{
		    					sheetObj.SelectCell(j,"sheet1_cntr_wgt_grp_cd",true);
		    				}
		    				return false;
		    			}
	    			}
	    		}
	    		if(sheetObj.RowCount == sheetObj.RowCount("D")){
	    			return true;
            	}
	    		var vLastRow=sheetObj.LastRow();
	    		var vLastCnt=0;
	    		for(var i=sheetObj.LastRow(); i <= vLastRow; i--){
	    			if(sheetObj.GetRowStatus(i)=="D"){
	    				vLastCnt=i-1;
	    			}else{
	    				vLastCnt=i;
	    				vLastRow-= vLastRow;
	    			}
	    		}
	    		//check last row "0"  - 20'Full, 40'Full From(equal or above)
	    		if( sheetObj.GetCellValue(vLastCnt, "sheet1_cntr_lmt_wgt1") != "0"){
	    			ComShowCodeMessage("OPF50011");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt1",true);
	    			return false;
	    		}
	    		if( sheetObj.GetCellValue(vLastCnt, "sheet1_cntr_lmt_wgt3") != "0"){
	    			ComShowCodeMessage("OPF50011");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt3",true);
	    			return false;
	    		}
	    		//check not allow last row "0"  - 20'Full, 40'Full To(less than)
	    		if( sheetObj.GetCellValue(vLastCnt, "sheet1_cntr_lmt_wgt2") == "0"){
	    			ComShowCodeMessage("OPF50012");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt2",true);
	    			return false;
	    		}
		if( sheetObj.GetCellValue(vLastCnt, "sheet1_cntr_lmt_wgt4") == "0"){
	    			ComShowCodeMessage("OPF50012");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt4",true);
	    			return false;
	    		}
	    	}
            return true;
        }
        function skd_dir_cd_change(form){
        	sheetObjects[0].RemoveAll();
        	ComBtnDisable("btn_RowAdd");
        	ComBtnDisable("btn_RowDelete");
        }
	/* Developer performance  end */
