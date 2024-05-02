/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2018_03.js
*@FileTitle : RFA Guideline Inquiry - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_2018_03 : Business Script for ESM_PRI_2018_03
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var enableFlag=true;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function loadPage() {
    	 $(".util_bar").remove();
    	 $(".gnb_wrap").remove();
        for(i=0;i<sheetObjects.length;i++){
        	//Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
		toggleButtons("CLEAR");
		pageOnLoadFinish();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		             var HeadTitle="Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton <=)|Weight\n(<Ton )|Base Port|Per|Cargo Type|Cur.|Rate||||||";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             (headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",   Sort:0 },
		                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0 },
		                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0 },
		                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"arb_seq" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" } ];
		              
		             InitColumns(cols);
		
		             SetEditable(0);
		             SetWaitImageVisible(0);
		             SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
		             SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		             SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		             SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		             //SetAutoRowHeight(0);
		             resizeSheet(); //SetSheetHeight(380);
            }
			break;
        }
    }
    
    function resizeSheet() {
	    ComResizeSheet(sheetObjects[0]);
	}
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
    /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
              	}
	        	formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("ESM_PRI_2018_03GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
           		break;
        	case IBSEARCH_ASYNC01: // radio button select
	 			//var firstCheck = false;
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_2018_03GS.do" , FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "typecd|typecount");
				var obj=document.form;
				if (parseInt(arrData[0][1]) > 0) {
					formObj.org_dest_tp_cd[0].checked=true;
				} else if(parseInt(arrData[1][1]) > 0) {
					formObj.org_dest_tp_cd[1].checked=true;
				}
				break;
        	case IBSEARCH_ASYNC02: // Font Style
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_2018_03GS.do" , FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "typecd|typecount");
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
				} else {
					document.getElementById("org_dest_tp_cd1").style.fontWeight="";
				}
				if(parseInt(arrData[1][1]) > 0) {
					document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
				} else {
					document.getElementById("org_dest_tp_cd2").style.fontWeight="";
				}
				break;		
        	case IBSEARCH_ASYNC03: //
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
        	case IBDOWNEXCEL:      //download excel
				//sheetObj.Down2Excel(-1);
        		if(sheetObj.RowCount() < 1){//no data	
        			ComShowCodeMessage("COM132501");
        		}else{	
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,AutoSizeColumn:0 });
        		}	
         		
				break;
        }
    }
    /**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.10.12
	 */
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="-";
 		// Process Axon Event No.1, Event Catch 
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.12
     */
    function obj_click(){
		var formObject=document.form;
		if (event.srcElement.name == "org_dest_tp_cd") {
     		doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	}
	/**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.10.12
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
  			var formObj=document.form;
  			var orgDestTpCd=getOrgDestTpCd();
  			var rCnt=sheetObj.RowCount();
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
 	/**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
  	function pageOnLoadFinish() {
    	initControl();
     	parent.loadTabPage();
    }
    /**
     * Getting org_dest_tp_cd's value<br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.10.12
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.12
     */ 		 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.10.12
     */ 	 
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}
	/**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sGlineSeq Mandatory gline_seq
     * @return void
     * @author 
     * @version 2009.10.12
     */ 		    	
	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory  
     * @return void
     * @author 
     * @version 2009.10.12
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	  		case IBSEARCH: // retrieving			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;
	        case IBDOWNEXCEL: // 
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	            break;				
    	}
    	return true;
    }    	     
    /**
     * Function to control button<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {string} mode setting value
     * @return void
     * @author 
     * @version 2009.05.22
     */	
  	function toggleButtons(mode) {
 		switch (mode) {
 		case "CLEAR":
 			document.form.org_dest_tp_cd[0].disabled=true;
 			document.form.org_dest_tp_cd[1].disabled=true;
 			disableButton("btn_downexcel");
 			break;
 		case "INIT":
 			document.form.org_dest_tp_cd[0].disabled=false;
 			document.form.org_dest_tp_cd[1].disabled=false;
 			enableButton("btn_downexcel");
 			break;
 		case "READONLY":
 			document.form.org_dest_tp_cd[0].disabled=false;
 			document.form.org_dest_tp_cd[1].disabled=false;
 			disableButton("btn_downexcel");
 			break;
 		}
 	}     	
