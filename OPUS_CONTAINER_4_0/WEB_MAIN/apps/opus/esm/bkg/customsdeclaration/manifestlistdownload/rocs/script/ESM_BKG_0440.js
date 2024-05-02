/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : esm_bkg_0440.js
*@FileTitle : ESM_BKG-0440
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
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
       		var sUrl="";
       		var sId="";
       		switch(srcName) {
       		case "btn_new":
					initForm(formObject);
					break;
       		case "btn_search":
    			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    			break;
       		case "btn_1":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
    			break;
       		case "btn_2":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
    			break;
       		case "btn_3":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
    			break;
       		case "btn_4":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
    			break;
       		case "btn_5_1":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND05); 
       			break;
       		case "btn_6_1":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND06);
    			break;
       		case "btn_7":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND07);
    			break;
       		case "btn_8":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
    			break;
       		case "btn_9":
    			doActionIBSheet(sheetObjects[0], formObject, COMMAND09);
    			break;
       		case "btn_10":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND10);
    			break;
       		case "btn_11":
       			doActionIBSheet(sheetObjects[0], formObject, COMMAND11);
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
     function initForm(formObj){    	 
    	 formObj.frm_crn_number.value="";
    	 formObj.frm_vvd_number.value="";
    	 formObj.frm_vvd_eta_dt.value="";
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
		doActionIBSheet(sheetObjects[0],document.form, INIT);
		//event
		var formObject=document.form;
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- inputting by keyboard
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
              var HeadTitle1="|crn_number|vsl_cd|skd_voy_no|skd_dir_cd|vvd_eta_dt|vvd_nm|vvd_number";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crn_number",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd_number",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetSheetHeight(100);
              SetVisible(0);
                    }


                break;
            }
        }
    // handling of Sheet 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case SEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true); 
					formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
					formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
					formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
					sheetObj.DoSearch("ESM_BKG_0440GS.do", FormQueryString(formObj),{Sync:2} );
					if(sheetObj.RowCount()> 0){
						//alert("test1");
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");						 
					}
					ComOpenWait(false); 
				}
			break;
			case COMMAND01:
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0443.do&pgmNo=ESM_BKG_0443";
				//ComOpenWindowCenter("ESM_BKG_0443.do", "ESM_BKG_0443", 1024, 700, false);
				
				window.open("ESM_BKG_0443.do?parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value, "common01_pop");
				
				break;	
			case COMMAND02:
				window.open("ESM_BKG_0444.do?mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value, "common02_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0444.do&mainPage=true&pgmNo=ESM_BKG_0444&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
				//ComOpenWindowCenter("ESM_BKG_0444.do", "ESM_BKG_0444", 1024, 700, false);
				break;
			case COMMAND03:
				window.open("ESM_BKG_0061.do?mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value, "common03_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0061.do&mainPage=true&&pgmNo=ESM_BKG_0061&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
				//ComOpenWindowCenter("ESM_BKG_0061.do", "ESM_BKG_0061", 1024, 720, false);
				break;
			case COMMAND04:
				window.open("ESM_BKG_0442.do?mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value, "common04_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0442.do&mainPage=true&&pgmNo=ESM_BKG_0442&crn_no="+formObj.frm_crn_number.value;
				//ComOpenWindowCenter("ESM_BKG_0442.do", "ESM_BKG_0442", 1024, 760, false);
				break;	
			case COMMAND05:
				window.open("ESM_BKG_0450.do?parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common05_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0450.do&pgmNo=ESM_BKG_0450&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				//ComOpenWindowCenter("ESM_BKG_0450.do", "ESM_BKG_0450", 1024, 750, false);	
				break;
			case COMMAND06:
				window.open("ESM_BKG_0448.do?parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common06_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0448.do&pgmNo=ESM_BKG_0448&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				//ComOpenWindowCenter("ESM_BKG_0448.do", "ESM_BKG_0448", 1024, 750, false);	
				break;
			case COMMAND07:                  
				window.open("ESM_BKG_0381.do?mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common07_pop");
				//var sUrl="/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0351.do&pgmNo=ESM_BKG_0351&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
				//ComOpenWindowCenter("ESM_BKG_0061.do", "ESM_BKG_0061", 1024, 750, false);		
				break;
			case COMMAND08:
				window.open("ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common08_pop");
//           				sUrl="ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&mainPage=true&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;

				break;
				
			case COMMAND09:
				 
//				var sUrl = "/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0351.do&pgmNo=ESM_BKG_0351&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value;
//				ComOpenWindowCenter(sUrl, "ESM_BKG_0061", 1024, 750, true);
				window.open("ESM_BKG_0351.do?mainPage=true&parentPgmNo=ESM_BKG_M001&crn_no="+formObj.frm_crn_number.value+"&vvd_no="+formObj.frm_vvd_number.value, "common09_pop");
						
				break;
				
				
			case COMMAND10:
				//window.open("ESM_BKG_0728.do?crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common10_pop");
				
				var sUrl ="ESM_BKG_0728.do?crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0728", 1024, 600, false);
							
				break;
				
				
			case COMMAND11:
				 
//				var sUrl = "/opuscntr/opusMain.screen?mainPage=true&parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0001.do&pgmNo=ESM_BKG_0001&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM";
//				ComOpenWindowCenter(sUrl, "ESM_BKG_0001", 1024, 750, true);	
				window.open("ESM_BKG_0001.do?mainPage=true&crn_no="+formObj.frm_crn_number.value+"&from_vvd_number="+formObj.frm_vvd_number.value+"&from_pod_cd=NLRTM", "common11_pop");
							
				break;				
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
//           if (!isNumber(formObj.iPage)) {
//               return false;
//           }
       }
       return true;
    }    
   /**
    * 
    * @return
    */ 
   function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");		
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	if (srcName == "frm_crn_number" && ComIsKorean(formObject.frm_crn_number.value)) 
    	{				    			
    			formObject.frm_crn_number.focus();			 
    	}
    }
    /**
    *  controlling keyboard at onkeypress event of HTML Control.
    **/
    function obj_keypress() {
    	 	switch(event.srcElement.dataformat){
    	 	case "uppernum":
             //only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
             ComKeyOnlyAlphabet('uppernum');
             break;
    	 	default:
             //only number (inteager, date, time)
             ComKeyOnlyNumber(event.srcElement);
    	 	}
    	    	var formObject=document.form;
    	    	var srcName=ComGetEvent("name");
    	    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	    	var srcValue=window.event.srcElement.getAttribute("value");
    	    	var crn_number=formObject.frm_crn_number.value;
    	    	var vvd_cd=formObject.frm_vvd_number.value; 
    	    	if(window.event.keyCode == 13)
    	    	{
    	    		if (srcName == "frm_crn_number" && crn_number.length > 0 && crn_number.length != 13 ) 
        	      	{
        	      		ComShowCodeMessage('BKG00537');
        	      		formObject.frm_crn_number.focus(); 			 
        	      	}
    	          	if (srcName == "frm_vvd_number" && vvd_cd.length > 0 && vvd_cd.length < 9 ) 
    	          	{
    	          		ComShowCodeMessage('BKG00538');
    	          		formObject.frm_vvd_number.focus(); 			 
    	          	}
    	          	if (ComChkLen(srcValue, srcMaxLength) == "2") {
        	    		ComSetNextFocus();        	    		
        	    	}
    	        	if (srcName == "frm_vvd_number" && vvd_cd.length == 9){
    	        		doActionIBSheet(sheetObjects[0],document.form,SEARCH);    	        		 
    	        	} else if (srcName == "frm_vvd_number" || srcName == "frm_crn_number"){
    	          		//alert("here2");
    	          		if ( (crn_number.length > 0 && crn_number.length == 13) || (vvd_cd.length > 0 && vvd_cd.length == 9))
    	          		{
    	          			doActionIBSheet(sheetObjects[0],document.form,SEARCH);    	          			 
    	          		}
    	          	}        	    	
    	    	}
     }
	/* the end of developer's work */
