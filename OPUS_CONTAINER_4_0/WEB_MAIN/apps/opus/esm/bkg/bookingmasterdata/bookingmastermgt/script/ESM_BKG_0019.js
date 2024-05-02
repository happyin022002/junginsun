/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0019.js
*@FileTitle : Vessel SKD & Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     */
    /**
     * @extends 
     * @class esm_bkg_0019 : esm_bkg_0019 business script.
     */

   	/* Developer Work	*/
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
 		         var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "btn_select":
					comPopupOK();
					break;	
				case "btn_0B2pop":
					openWindowVvd(formObject);
					break;
				case "btn_vsl":
					openWindowVsl(formObject);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);	
				break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
     function openWindowVvd(formObj) {
    	var formObj=document.form;
  		var param="";
  	    param += "vvd_cd="+ComGetObjValue(formObj.vsl_cd);
  	    param += "&lane_cd="+ComGetObjValue(slan_cd);
  	    param += "&loc_cd="+ComGetObjValue(formObj.vps_port_pol);
  		ComOpenPopup('/opuscntr/COM_ENS_0B2.do?'+param , 780, 490, 'getCOM_ENS_0B2', '1,0,1,1,1,1,1,1', true);
 	}

     function openWindowVsl(formObj) {
     	var param="";
   	    param += "vsl_nm="+ComGetObjValue(formObj.vsl_eng_nm);
   		ComOpenPopup('/opuscntr/VOP_VSK_0219.do?'+param , 460, 500, 'returnVslNmHelp', '0,0', true);
  	}
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     function setComboObject(combo_obj){
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
        // IBMultiComboInitialization
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		initControl();
		/*if (formObj.vsl_cd.value != "" 
		 	&& formObj.vps_port_pol.value !="" 
		 		&& formObj.vps_port_pod.value !=""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}*/
		
		sheet1_OnLoadFinish(sheet1);
     }
      function sheet1_OnLoadFinish(sheetObj) {
    	 var formObj=document.form;
    	 if (formObj.vsl_cd.value != "" 
 		 	&& formObj.vps_port_pol.value !="" 
 		 		&& formObj.vps_port_pod.value !=""){
    		 doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	 }	 
     }
	/**
	 * HTML Control event load. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects array seq
	 */
	function initControl() {
		//** Date Separator **/
    	DATE_SEPARATOR="-";
		var formObject=document.form;
	    axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- When typing the keyboard
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	    axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject);
	}
	/**
     * Combo initial value
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.SetDropHeight(150);
     	comboObj.SetMultiSelect(1);
     	comboObj.SetMultiSeparator(",");  // add 
     }  
	/**
     * onblur event Validation check. <br>
     **/
    function obj_activate(){
    	//input Validation check
    	switch(event.srcElement.name){
    		default:
    			break;
    			//return;
    			//ComAddSeparator(event.srcElement);
    			//ComChkObjValid(event.srcElement);
    	}
    }
	/**
     * onblur event Validation check. <br>
     **/
    function obj_deactivate(){
    	var formObject=document.form;
    	//if (event.srcElement.getAttribute("required") != null) return;
        //input Validation check
    	switch(event.srcElement.name){
	    	case "vsl_cd":
	    		if(formObject.vsl_cd.value != ""){
	    			formObject.vsl_cd.className="input1";
	    			formObject.vps_port_pol.className="input1";
	    			formObject.vps_port_pod.className="input1";
	    			if(formObject.vps_port_pol.value == ""){
	    				formObject.vps_port_pol.className="input";
	    			}
	    			if(formObject.vps_port_pod.value == ""){
	    				formObject.vps_port_pod.className="input";
	    			}	    			
	    		}else{
	    			if(formObject.vps_port_pol.value == "" && formObject.vps_port_pod.value == ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input1";
		    			formObject.vps_port_pod.className="input1";
	    			} else if(formObject.vps_port_pol.value == "" && formObject.vps_port_pod.value != ""){
	    				formObject.vsl_cd.className="input";
	    				formObject.vps_port_pol.className="input";
	    				formObject.vps_port_pod.className="input1";
	    			} else if(formObject.vps_port_pol.value != "" && formObject.vps_port_pod.value == ""){
	    				formObject.vsl_cd.className="input";
	    				formObject.vps_port_pol.className="input1";
	    				formObject.vps_port_pod.className="input";
	    			} else if(formObject.vps_port_pol.value != "" && formObject.vps_port_pod.value != ""){
	    				formObject.vsl_cd.className="input";
	    				formObject.vps_port_pol.className="input1";
	    				formObject.vps_port_pod.className="input1";
	    			}	    			
	    		}
	    		break;
	    	case "vps_port_pol":
	    		if(formObject.vps_port_pol.value != ""){
	    			formObject.vps_port_pol.className="input1";
	    			formObject.vps_port_pol.className="input1";
	    			formObject.vps_port_pod.className="input1";
	    			if(formObject.vsl_cd.value == ""){
	    				formObject.vsl_cd.className="input";
	    			}
	    			if(formObject.vps_port_pod.value == ""){
	    				formObject.vps_port_pod.className="input";
	    			}	    			
	    		}else{
	    			if(formObject.vsl_cd.value == "" && formObject.vps_port_pod.value == ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input1";
		    			formObject.vps_port_pod.className="input1";
	    			} else if(formObject.vsl_cd.value == "" && formObject.vps_port_pod.value != ""){
	    				formObject.vsl_cd.className="input";
	    				formObject.vps_port_pol.className="input";
	    				formObject.vps_port_pod.className="input1";
	    			} else if(formObject.vsl_cd.value != "" && formObject.vps_port_pod.value == ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input";	    				
	    				formObject.vps_port_pod.className="input";
	    			} else if(formObject.vsl_cd.value != "" && formObject.vps_port_pod.value != ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input";
	    				formObject.vps_port_pod.className="input1";
	    			}	    			
	    		}
	    		break;
	    	case "vps_port_pod":
	    		if(formObject.vps_port_pod.value != ""){
	    			formObject.vps_port_pol.className="input1";
	    			formObject.vps_port_pol.className="input1";
	    			formObject.vps_port_pod.className="input1";
	    			if(formObject.vsl_cd.value == ""){
	    				formObject.vsl_cd.className="input";
	    			}
	    			if(formObject.vps_port_pol.value == ""){
	    				formObject.vps_port_pol.className="input";
	    			}	    			
	    		}else{
	    			if(formObject.vsl_cd.value == "" && formObject.vps_port_pol.value == ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input1";
		    			formObject.vps_port_pod.className="input1";
	    			} else if(formObject.vsl_cd.value == "" && formObject.vps_port_pol.value != ""){
	    				formObject.vsl_cd.className="input";
	    				formObject.vps_port_pol.className="input1";
	    				formObject.vps_port_pod.className="input";
	    			} else if(formObject.vsl_cd.value != "" && formObject.vps_port_pol.value == ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input";	    				
	    				formObject.vps_port_pod.className="input";
	    			} else if(formObject.vsl_cd.value != "" && formObject.vps_port_pol.value != ""){
	    				formObject.vsl_cd.className="input1";
	    				formObject.vps_port_pol.className="input1";
	    				formObject.vps_port_pod.className="input";
	    			}	    			
	    		}
	    		break;
    		default:
    			break;
    			//ComAddSeparator(event.srcElement);
    			//ComChkObjValid(event.srcElement);
    	}
    }
	 /**
	 * check input value in Lane Combo.
	 **/
	 function checkKeyInSlanCd(obj){
		 var formObject=document.form;
		 if (obj.text != ''){
 			 if (obj.FindItem(obj.text,0) == -1){
				 ComShowMessage('no matched lane!');
				 obj.text="";
				 obj.focus();
			 }
		 }
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
             case "sheet1":      //sheet1 init
             with(sheetObj){
				
			  var HeadTitle1="Sel.||Lane|VVD|POL|Terminal|CCT|CCT|ETB|ETB|ETD|ETD|POD|Terminal|ETB|ETB|Consortium Voyage|Consortium Voyage|Last CY Avail|Remark|Update Time|Update Time|clpt_ind_seq|clpt_seq|pod_clpt_ind_seq|pod_clpt_seq";
			  var HeadTitle2="Sel.||Lane|VVD|POL|Terminal|CCT|CCT|ETB|ETB|ETD|ETD|POD|Terminal|ETB|ETB|Arr Ext Voy Ref|Dep Ext Voy Ref|Last CY Avail|Remark|Update Time|Update Time|clpt_ind_seq|clpt_seq|pod_clpt_ind_seq|pod_clpt_seq";
			  var headCount=ComCountHeadTitle(HeadTitle1);

			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"check",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"terminal",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cct_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cct_tm",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"etb_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"etb_tm",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"etd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"etd_tm",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"terminal2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"etb2_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"etb2_tm",           KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ib_cssm_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",          	PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ob_cssm_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"last_cy_avail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"vps_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"upd_tm",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clpt_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"clpt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			   
					InitColumns(cols);
					SetShowButtonImage(1);
					resizeSheet();
					//SetSheetHeight(480);
			  }
         break;
         }
     }


     function resizeSheet(){
    	 ComResizeSheet(sheetObjects[0]);
     }
  
  
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0019GS.do", FormQueryString(formObj)	+ "&" + ComGetPrefixParam("") );
				}	
				break;
			case IBCLEAR:      //Retrieve
				formObj.f_cmd.value=SEARCH01;
			 	slan_cd.SetUseEdit(1);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0019GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem(sXml, slan_cd, "vsl_slan_cd", "vsl_slan_nm");
				break;	
			case IBSEARCHAPPEND:  // pasing retrieve
                formObj.f_cmd.value=SEARCH;              
				sheetObj.DoSearch("ESM_BKG_0019GS.do", FormQueryString(formObj)+"&"+ "iPage=" + PageNo,{Append:true} );
                break;	
			case "btn_confirm":
				callPopupOK(sheetObject);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_0B2pop":
				ComClosePopup(); 
				break;	
			case "btns_calendar1":
	   	         var cal=new calendarPopup();
	       		 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
	   	        break;
	   	    case "btns_calendar2":
	   	         var cal=new calendarPopup();
	       		 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
	   	        break;
	   	    case IBDOWNEXCEL:
	   	    	if(sheetObj.RowCount() < 1){
	   	    		ComShowCodeMessage("COM132501");
		   	 	}else{
		   	 		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		   	 	}
				break;	    
         }
     }
  	/**
     * ETD,ETB call canlendar
     */
  	function callDatePop(val){
  		var cal=new ComCalendarFromTo();
  		if (val == 'ETD'){
  			cal.select(form.pf_etd_from_dt,  form.pf_etd_to_dt,  'yyyy-MM-dd');
  		}else{
  			cal.select(form.pf_etb_from_dt,  form.pf_etb_to_dt,  'yyyy-MM-dd');
  		}
  	}
	function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
     } 
  	/**
  	 * Vessel SKD & Code Inquiry.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function getCOM_ENS_0B2(aryPopupData) {
  		var formObject=document.form;
  		formObject.vsl_cd.value=aryPopupData[0][7];
  	} 
	/**
	 * Handling data from VSL Name Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslNmHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_eng_nm.value=rtnDatas[2];
				}
			}
    	}
    }
  	
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
 		var fmDtValue=formObj.pf_etd_from_dt.value.replace(/-/g, "");
 		var toDtValue=formObj.pf_etd_to_dt.value.replace(/-/g, "");
         with(formObj){
        	 if (!ComChkValid(formObj)) return false;
        	 if (formObj.vsl_cd.value == "" 
        		 	&& formObj.vps_port_pol.value=="" 
        		 		&& formObj.vps_port_pod.value ==""){
        		 if (sAction == IBSEARCH){
        			 ComShowCodeMessage('BKG00626', 'POL or POD or VVD');
        			 formObj.vps_port_pol.focus();
        			 //ComShowMessage(msgs['BKG00829']);
        		 }
        		 return false;
        	 }
 			if( ("" != fmDtValue && "" != toDtValue) && parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
				 ComShowCodeMessage("COM12133", "From Date", "To Date", "earlier");
				 ComSetFocus(formObj.pf_etb_from_dt);
				 return false;
	 		}
         }
         return true;
     }
	/* Developer Work End */
 