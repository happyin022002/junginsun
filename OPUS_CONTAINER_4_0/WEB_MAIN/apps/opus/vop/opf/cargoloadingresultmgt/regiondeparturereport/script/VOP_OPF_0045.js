/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0045.js
*@FileTitle  : RDR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16  
=========================================================*/
var selFrameId;
var iframeMap = new HashMap();
var iframeAddHeight = 0;



/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0045 : VOP_OPF_0045 business script for
     */
   	/* Developer performance	*/
 // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=0;
    var gHeadLength=0;
    var firstFlag=true;
	var arrPreCond=new Array("", "", "", "");
	var enableButton=new Array("btn_Mail", "btn_Print");
	var bRetrive=false;    
	var marrTabTitle=new Array(	"VSL Mvmt","Add Slot","Slot/WGT Util","A K","B/B", "HC/45'","RF","DG","VSL Alloc.","Slot Rel.","Slot Swap", "Load", "IPC Over Used","Remark(s)");
    var marrTabTitleKey=new Array("VSL_Mvmt","Add_Slot","SlotWGT_Util","AK","BB", "HC45","RF","DG","VSL_Alloc","Slot_Rel","Slot_Swap", "Load", "IPC_Over_Used","Remark");
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         //var prefix = "sheet1_";
    	//try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_New":
					formObject.vsl_cd.value="";
					formObject.voy_no.value="";
					formObject.dir_cd.value="";
					region.SetSelectCode(-1,false);
					formObject.next_port.value="";
					formObject.next_date.value="";
                    formObject.port_cd.value="";
                    formObject.port_cd_nm.value="";
					opr_cd.RemoveAll();
					opr_cd.InsertItem(0, "All", "All");
					opr_cd.SetSelectCode("All");
					bRetrive=false;
                    fnSheetClear();
					formObject.vsl_cd.focus();
					break;
	            case "vsl_cd_pop":
            		var sUrl="";
                	var vsl_cd=formObject.vsl_cd.value;
                	if(isNull(vsl_cd)){
                		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                	}
	            	break;
	            case "btn_Retrieve":
					if(!validateForm(formObject)){
						return false;
					}
					switch(marrTabTitle[beforetab]){
					  case "VSL Mvmt":
						  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
						  break;
					  case "Add Slot":
						  doActionIBSheet(t2frame.t2sheet1, document.form, IBSEARCH, "search02");
						  break;
					  case "Slot/WGT Util":
						  doActionIBSheet(t3frame.t3sheet1, document.form, IBSEARCH, "search03");
						  break;
					  case "A K":
						  doActionIBSheet(t4frame.t4sheet1, document.form, IBSEARCH, "search04");
						  break;
					  case "B/B":
						  doActionIBSheet(t5frame.t5sheet1, document.form, IBSEARCH, "search05");
						  break;
					  case "HC/45'":
						  doActionIBSheet(t6frame.t6sheet1, document.form, IBSEARCH, "search06");
						  break;
					  case "RF":
						  doActionIBSheet(t7frame.t7sheet1, document.form, IBSEARCH, "search07");
						  break;
					  case "DG":
						  doActionIBSheet(t8frame.t8sheet1, document.form, IBSEARCH, "search08");
						  break;
					  case "VSL Alloc.":
						  doActionIBSheet(t9frame.t9sheet1, document.form, IBSEARCH, "search09");
						  break;
					  case "Slot Rel.":
						  doActionIBSheet(t10frame.t10sheet1, document.form, IBSEARCH, "search10");
						  break;
					  case "Slot Swap":
						  doActionIBSheet(t11frame.t11sheet1, document.form, IBSEARCH, "search11");
						  break;
					  case "Load":
						  doActionIBSheet(t12frame.t12sheet1, document.form, IBSEARCH, "search12");
						  break;
					  case "IPC Over Used":
						  doActionIBSheet(t13frame.t13sheet1, document.form, IBSEARCH, "search13");
						  break;
					  case "Remark(s)":
						  doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, "search14");
						  break;
					}
					break;
				case "btn_Mail":
					if(ComGetBtnDisable("btn_Mail")){
						return false;
					}
					// add Slot Header
					formObject.f_cmd.value=SEARCH;
					var addHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
					var addSlotHeaderList=ComGetEtcData(addHeaderXml, "operatorList");
					var addSlotHeader=addSlotHeaderList.split("|");
					for(var idx=0; idx < addSlotHeader.length; idx++){
						addSlotHeader[idx]=addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
					}
					// Load Header
	    		    formObject.f_cmd.value=SEARCH19;
	    		    var loadHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
    	    		var loadHeaderList=ComGetEtcData(loadHeaderXml, "operatorList");
    	    		var loadHeader=loadHeaderList.split("|");
    	    		var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
				                    + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
				                    + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
				                    + " ["+(comboObjects[0].GetSelectCode())+"]"       // 4.Region Code
				                    + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
				                    + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
				                    + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
				                    + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
				                    + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
				                    + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
				                    + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
				                    + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
				                    + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
				                    + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
				                    + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
				                    + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
				                    + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
				                    + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
				                    + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
				                    + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
				                    + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
				                    + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
				                    + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
				                    + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
				                    + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
				                    + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
				                    + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
				                    + " ["+nullParam(addSlotHeader[8])+"]"            // 28.AddSlot Header 9
                                    + " ["+formObject.port_cd.value+"]";            // 5.Port Code
					formObject.com_templateMrdArguments.value=rdParam +";"+rdParam;
                    searchVvdMailInfo();
					//ComSendMail();
                    searchReceiveInfo();
					ComSendMailModal();
					break;
				case "btn_Print":
//					if(ComGetBtnDisable("btn_Print")){
//						return false;
//					}
//					// add Slot Header
//					formObject.f_cmd.value=SEARCH;
//					var addHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
//					var addSlotHeaderList=ComGetEtcData(addHeaderXml, "operatorList");
//					var addSlotHeader=addSlotHeaderList.split("|");
//					for(var idx=0; idx < addSlotHeader.length; idx++){
//						addSlotHeader[idx]=addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
//					}
//					// Load Header
//	    		    formObject.f_cmd.value=SEARCH19;
//	    		    var loadHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
//    	    		var loadHeaderList=ComGetEtcData(loadHeaderXml, "operatorList");
//    	    		var loadHeader=loadHeaderList.split("|");
//					var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
//				                    + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
//				                    + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
//				                    + " ["+(comboObjects[0].GetSelectCode())+"]"       // 4.Region Code
//				                    + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
//				                    + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
//				                    + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
//				                    + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
//				                    + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
//				                    + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
//				                    + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
//				                    + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
//				                    + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
//				                    + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
//				                    + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
//				                    + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
//				                    + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
//				                    + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
//				                    + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
//				                    + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
//				                    + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
//				                    + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
//				                    + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
//				                    + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
//				                    + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
//				                    + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
//				                    + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
//				                    + " ["+nullParam(addSlotHeader[8])+"]"            // 28.AddSlot Header 9
//                                    + " ["+(formObject.port_cd.value)+"]";            // 5.Port Code
//					formObject.com_mrdArguments.value=rdParam;
//					///ComOpenRDPopup();
//	                ComOpenRDPopupModal();
                    formObject.f_cmd.value=SEARCH;
                    var addHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
                    var addSlotHeaderList=ComGetEtcData(addHeaderXml, "operatorList");
                    var addSlotHeader=addSlotHeaderList.split("|");
                    for(var idx=0; idx < addSlotHeader.length; idx++){
                        addSlotHeader[idx]=addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
                    }
                    // Load Header
                    formObject.f_cmd.value=SEARCH19;
                    var loadHeaderXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObject));
                    var loadHeaderList=ComGetEtcData(loadHeaderXml, "operatorList");
                    var loadHeader=loadHeaderList.split("|");
					var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
			                    + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
			                    + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
			                    + " ["+(comboObjects[0].GetSelectCode())+"]"       // 4.Region Code
			                    + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
			                    + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
			                    + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
			                    + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
			                    + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
			                    + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
			                    + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
			                    + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
			                    + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
			                    + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
			                    + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
			                    + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
			                    + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
			                    + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
			                    + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
			                    + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
			                    + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
			                    + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
			                    + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
			                    + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
			                    + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
			                    + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
			                    + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
			                    + " ["+nullParam(addSlotHeader[8])+"]"            // 28.AddSlot Header 9
			                    + " ["+(formObject.port_cd.value)+"]";            // 29.Port Code
					
                    formObject.com_mrdArguments.value=rdParam;
                    ComOpenRDPopup('resizable=yes');
                    break;					
				case "btn_Close":
					ComClosePopup(); 
					break;
            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
     * registering IBMultiCombo Object as list <br>
     * defining list on the top of source and this  method called automatically by creating IBMultiCombo object by {@link CoObject#ComComobject} <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * setting Combo
     * set item of Combo
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(comboObj.options.id) {
	    		case "region":
	            	SetTitle("Code|Description");
					SetColWidth(0, "45");
					SetColWidth(1, "120");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	//MaxLength = 5;
		            break;
                case "port_cd":
					SetColWidth(0, "50");
					SetColWidth(1, "230");
					SetColWidth(2, "0");
					SetDropHeight(250);
					SetMultiSelect(0);
             		SetMaxSelect(1);
             		SetUseAutoComplete(1);
             		break;
		        case "opr_cd":
	            	SetTitle("Operator");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		    }
    	}
	}
     /**
      * get Operation Code in case of selecting region Code  <br>
      **/
     function region_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        opr_cd.RemoveAll();
        opr_cd.InsertItem(0, "All", "All");
       // opr_cd.SetSelectIndex(0);
        fnSheetClear();
        fnGoPortCode();
     }
      function fnGoPortCode(){
          var formObj=document.form;
          formObj.port_cd.value="";
          formObj.port_cd_nm.value="";
          doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "port_cd");
          doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");
      }
      /**
       *  setting name in case of changing Port Code 
       **/
      function port_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
          var formObj=document.form;
          opr_cd.RemoveAll();
          opr_cd.InsertItem(0, "All", "All");
          opr_cd.SetSelectIndex(0);
          var aText=NewTxt.split("|");
          formObj.port_cd_nm.value=comboObj.GetText( comboObj.GetSelectIndex(), 1  );
          if(text == ""){return;}
          doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");
      }
       function opr_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
           fnSheetClear();
       }
    /**
     * Setting Tab
     * Set item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt], "");
					}
                }
             break;
         }
    }
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i<objs.length; i++){
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		}
    	}
    	//---------------important --------------------------//
    	
    	//------------------------------------------------------//
    	beforetab=nItem;
    	switch(marrTabTitle[beforetab]){
			  case "VSL Mvmt":
    				  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
    				  break;
			  case "Add Slot":
    				var frame=document.getElementById("t2frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t2frame.t2sheet1, document.form, IBSEARCH, "search02");
    				}
    				break;
			  case "Slot/WGT Util":
    				var frame=document.getElementById("t3frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t3frame.t3sheet1, document.form, IBSEARCH, "search03");
    				}
			  case "A K":
    				var frame=document.getElementById("t4frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive){
    						doActionIBSheet(t4frame.t4sheet1, document.form, IBSEARCH, "search04");
    					}else{
    					    goDetail(frame, beforetab);
    					}
    				}
    				break;
			  case "B/B":
    				var frame=document.getElementById("t5frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t5frame.t5sheet1, document.form, IBSEARCH, "search05");
    				}
    				break;
			  case "HC/45'":
    				var frame=document.getElementById("t6frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t6frame.t6sheet1, document.form, IBSEARCH, "search06");
    				}
    				break;
			  case "RF":
    				var frame=document.getElementById("t7frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goRefer(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t7frame.t7sheet1, document.form, IBSEARCH, "search07");
    				}
    				break;
			  case "DG":
    				var frame=document.getElementById("t8frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t8frame.t8sheet1, document.form, IBSEARCH, "search08");
    				}
    				break;
			  case "VSL Alloc.":
    				var frame=document.getElementById("t9frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t9frame.t9sheet1, document.form, IBSEARCH, "search09");
    				}
    				break;
			  case "Slot Rel.":
    				var frame=document.getElementById("t10frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t10frame.t10sheet1, document.form, IBSEARCH, "search10");
    				}
    				break;
			  case "Slot Swap":
    				var frame=document.getElementById("t11frame");
    				selFrameId = frame.id;
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t11frame.t11sheet1, document.form, IBSEARCH, "search11");
    				}
    				break;
			  case "Load":
				var frame=document.getElementById("t12frame");
				selFrameId = frame.id;
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t12frame.t12sheet1, document.form, IBSEARCH, "search12");
				}
				break;
			  case "IPC Over Used":
				var frame=document.getElementById("t13frame");
				selFrameId = frame.id;
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t13frame.t13sheet1, document.form, IBSEARCH, "search13");
				}
				break;
			  case "Remark(s)":
				  doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, "search14");
				  break;
		  }
    	iframeResize(false);
    }
     /**
      * In case of clicking Tab event relation
      * activate element of Tab chosen
      */
     function tab1_OnClick(tabObj , nItem)
     {
		  if(nItem == beforetab){
			  return;
		  }
		 // var objs=document.all.item("tabLayer");
		  //objs[beforetab].style.display="none";
		  //objs[nItem].style.display="Inline";
		  //--------------- important --------------------------//
		  //objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		  //------------------------------------------------------//
		  beforetab=nItem;
		  switch(marrTabTitle[beforetab]){
			  case "VSL Mvmt":
    				  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
    				  break;
			  case "Add Slot":
    				var frame=document.getElementById("t2frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t2frame.t2sheet1, document.form, IBSEARCH, "search02");
    				}
    				break;
			  case "Slot/WGT Util":
    				var frame=document.getElementById("t3frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t3frame.t3sheet1, document.form, IBSEARCH, "search03");
    				}
			  case "A K":
    				var frame=document.getElementById("t4frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive){
    						doActionIBSheet(t4frame.t4sheet1, document.form, IBSEARCH, "search04");
    					}else{
    					    goDetail(frame, beforetab);
    					}
    				}
    				break;
			  case "B/B":
    				var frame=document.getElementById("t5frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t5frame.t5sheet1, document.form, IBSEARCH, "search05");
    				}
    				break;
			  case "HC/45'":
    				var frame=document.getElementById("t6frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t6frame.t6sheet1, document.form, IBSEARCH, "search06");
    				}
    				break;
			  case "RF":
    				var frame=document.getElementById("t7frame");
    			    if(frame.src == ""){
    					goRefer(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t7frame.t7sheet1, document.form, IBSEARCH, "search07");
    				}
    				break;
			  case "DG":
    				var frame=document.getElementById("t8frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t8frame.t8sheet1, document.form, IBSEARCH, "search08");
    				}
    				break;
			  case "VSL Alloc.":
    				var frame=document.getElementById("t9frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t9frame.t9sheet1, document.form, IBSEARCH, "search09");
    				}
    				break;
			  case "Slot Rel.":
    				var frame=document.getElementById("t10frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t10frame.t10sheet1, document.form, IBSEARCH, "search10");
    				}
    				break;
			  case "Slot Swap":
    				var frame=document.getElementById("t11frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t11frame.t11sheet1, document.form, IBSEARCH, "search11");
    				}
    				break;
			  case "Load":
				var frame=document.getElementById("t12frame");
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t12frame.t12sheet1, document.form, IBSEARCH, "search12");
				}
				break;
			  case "IPC Over Used":
				var frame=document.getElementById("t13frame");
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t13frame.t13sheet1, document.form, IBSEARCH, "search13");
				}
				break;
			  case "Remark(s)":
				  doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, "search14");
				  break;
		  }
		  //top.syncHeight();
     }
	 function goDetail(objFrame, nItem){
		 objFrame.src="VOP_OPF_0045_Dtl.do?nItem=" + nItem;
	 }
	 function goRefer(objFrame, nItem){
		 objFrame.src="VOP_OPF_0045_07.do?nItem=" + nItem;
	 }
    /**
   	 * Setting data received from VSL Code Help (Pop-Up)<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackVSL(aryPopupData) {
 		document.form.vsl_cd.value=aryPopupData[0][1];
 		//ComSetFocus(document.form.voy_no);
 		document.form.voy_no.focus();
   	} 
    /**
   	 * setting data received from VVD Code Hepl(Pop-Up)<br>
   	 * @param {arry} obj
   	 */
   	function setCallBackVVD(aryPopupData) {
 		document.form.voy_no.value=aryPopupData[0][2];
 		document.form.dir_cd.value=aryPopupData[0][3];
 		//ComSetFocus(document.form.region);
 		document.form.region.focus();
   	}
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	 
 		for(i=0;i<sheetObjects.length;i++){
 			//change start configuration method name 
 			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
 			//add last configuration method 
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		
 		for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
        }
 		//initialize Combo 
     	for(var m=0; m<comboObjects.length; m++){
         	initCombo(comboObjects[m]);
        }
 		initControl();
 		//retrieve Default Combo Data
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "Combo");
 		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
 	 		
// 		document.form.vsl_cd.focus();
 		document.form.port_cd.focus();
        opr_cd.InsertItem(0, "All", "All");
        opr_cd.SetSelectCode("All");
		for( var k=0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
		var formObj=document.form;
		/************************************/
		if (formObj.popYn.value == "Y" ){
		    formObj.vsl_cd.value=preConds.vsl_cd;
            formObj.voy_no.value=preConds.voy_no;
            formObj.dir_cd.value=preConds.dir_cd;
            region.SetSelectCode(preConds.region);
            if(  preConds.joo_init_tab != ""  ){
                goTabMoveByJoo(preConds.joo_init_tab);
            }
		}
		
 	}
    function goTabMoveByJoo(pageName){
        for(var i=0;i<marrTabTitleKey.length;i++){
            if( marrTabTitleKey[i] == pageName ){
                tab1_OnClick( tabObjects[0] , i);
                tabObjects[0].SetSelectedIndex(i);
                return;
            }
        }
    }
     /**
      * Loading event of HTML Control in page dynamically <br>
      * initializing IBSheet by calling {@link #loadPage}Method <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects
      **/
     function initControl(){
     	//axon_event.addListener  ('keypress', 'obj_keypress', 'vsl_cd'
     														//, 'voy_no'
     														//, 'dir_cd');
     	//axon_event.addListener  ('keyup', 'obj_keyup', 'vsl_cd'
													 //, 'voy_no'
													 //, 'dir_cd');
     	//axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListener  ('change' , 'change_event', 'vsl_cd'
				 										   , 'voy_no');
     	axon_event.addListener  ('blur'  , 'blur_event', 'dir_cd');
     	axon_event.addListener  ('focus' , 'focus_event', 'vsl_cd'
														 , 'voy_no'
														 , 'dir_cd');
     }
     /**
      * input only english and number on onKeypress of HTML Control<br>
      **/
//     function obj_keypress() {
//         if(ComGetEvent("name")=="vsl_cd")
//         {
//        	//input only letter/number
//        	 ComKeyOnlyAlphabet('uppernum');
//         }else if(ComGetEvent("name")=="voy_no")
//         {
//        	//input only number
//          	ComKeyOnlyNumber(ComGetEvent());
//         }
//         else{
//        	//input only capital
//          	ComKeyOnlyAlphabet('upper');
//         }
//         ComKeyEnter();
//     }
     /**
      * handling in case of form Object Keydown event
      * @param  void
      * @return void
      */     
//      function obj_keyup(){
//           var obj=ComGetEvent();
//           var formObj=document.form;
//           switch(ComGetEvent("name")){
//              case 'vsl_cd':
//                    var objMaxLength=obj.getAttribute("maxLength");
//                    if (ComChkLen(obj.value, objMaxLength) == 2) {
//                        ComSetNextFocus(obj);
//                    }
//                    ComClearObject(formObj.voy_no);
//                    ComClearObject(formObj.dir_cd);
//                    region.SetSelectCode("",false);
//                    formObj.port_cd.value="";
//                    formObj.port_cd_nm.value="";
//                    fnSheetClear();
//                    break;
//              case 'voy_no':
//                    var objMaxLength=obj.getAttribute("maxLength");
//                    if (ComChkLen(obj.value, objMaxLength) == 2) {
//                        ComSetNextFocus(obj);
//                    }
//                    ComClearObject(formObj.dir_cd);
//                    region.SetSelectCode("",false);
//                    formObj.port_cd.value="";
//                    formObj.port_cd_nm.value="";
//                    fnSheetClear();
//                    break;
//              case 'dir_cd':
//                    region.SetSelectCode("",false);
//                    formObj.port_cd.value="";
//                    formObj.port_cd_nm.value="";
//                    fnSheetClear();
//                    break;
//           }
//           // Focus change..
//           ComKeyEnter('LengthNextFocus');
//      }
    /**
     * setting block on onfocus event of HTML Control <br>
     **/
    function focus_event(){
    	var evt = ComGetEvent();
    	evt.select();
        //event.srcElement.select();
    }
    /**
     * setting certain form reset in change event of HTML Control  <br>
     **/
    function change_event(){
    	var elementObj=ComGetEvent();
    	var formObj=document.form;
    	if(elementObj.name=="vsl_cd"){
    		formObj.voy_no.value="";
    		formObj.dir_cd.value="";
    	}
    	else if(elementObj.name=="voy_no")
        {
    		formObj.dir_cd.value="";
        }
    }
    /**
     * checking certain form validation on blur event of HTML Control <br>
     **/
    function blur_event(){
    	var elementObj=ComGetEvent();
    	var formObj=document.form;
    	if(elementObj.name=="dir_cd" 
    		&& !isNull(formObj.vsl_cd.value)
    		&& !isNull(formObj.voy_no.value)
    		&& !isNull(formObj.dir_cd.value))
    	{
			formObj.f_cmd.value=SEARCH06;
			formObj.skd_voy_no.value=formObj.voy_no.value;
			formObj.skd_dir_cd.value=formObj.dir_cd.value;
			var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
			var vvdData=ComOpfXml2Array(sXml, "vsl_cd|skd_voy_no|skd_dir_cd");
			
			if(vvdData == null) {
				ComShowCodeMessage("COM132201", "Data");
				formObj.vsl_cd.value="";
        		formObj.voy_no.value="";
        		formObj.dir_cd.value="";
                region.SetSelectCode("",false);
        		formObj.port_cd.value="";
        		formObj.port_cd_nm.value="";
        		formObj.vsl_cd.focus();
        		return false;
			}else{
				if(vvdData.length > 1) {
	    			ComShowCodeMessage("COM132201", "Data");
					formObj.vsl_cd.value="";
					formObj.voy_no.value="";
					formObj.dir_cd.value="";
                    region.SetSelectCode("",false);
	                formObj.port_cd.value="";
	                formObj.port_cd_nm.value="";
					formObj.vsl_cd.focus();
					return false;
				} else {
				    if( region.GetSelectCode()!= "" ){
					   doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");
				    }
					return true;
				}
			}
    	}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo, headTitleList) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":      //vop_opf_0045.js, vop_opf_0045_07.js, vop_opf_0045_Dtl.js 
                with(sheetObj){
					var HeadTitle="|Port|Arrival Time|Berthing Time|Unberthing Time|Departure Time";
					var headCount=ComCountHeadTitle(HeadTitle);
					var prefix="t1sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"berth_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unberth_time", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t2sheet1":
                with(sheetObj){
					var HeadTitle="|POL|POD";
					if(!isNull(headTitleList)){
						for(var hh=0; hh < headTitleList.length; hh++){
							HeadTitle=HeadTitle+"|"+headTitleList[hh];
						}
					}
					HeadTitle=HeadTitle+"|Total";
					var headCount=ComCountHeadTitle(HeadTitle);
					var prefix="t2sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					if(!isNull(headTitleList)){
						for(var hh=0; hh < headTitleList.length; hh++){
							var col_fix=(hh + 1 < 10 ? "0" + (hh + 1) : hh + 1);
							cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"opr_qty_"+col_fix,KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
						}
					}
						cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"total",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
					
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(430);
            	}
                break;
                
            case "t12sheet1":
                with(sheetObj){
					var HeadTitle1="|Operator|POD|FE/Size|FE/Size";
					if(!isNull(headTitleList)){
						for(var a=0; a < headTitleList.length; a++){
							HeadTitle1=HeadTitle1+"|POL"
						}
					}
					HeadTitle1=HeadTitle1+"|TOTAL|TOTAL";
					var HeadTitle2="|Operator|POD|FE/Size|FE/Size";
					if(!isNull(headTitleList)){
						for(var b=0; b < headTitleList.length; b++){
							HeadTitle2=HeadTitle2+"|"+headTitleList[b];
						}
					}
					HeadTitle2=HeadTitle2+"|Volumn|Weight";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t12sheet1_";
					
					SetConfig( { SearchMode:0, MergeSheet:1, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_type", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_size", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					if(!isNull(headTitleList)){
						gHeadLength=headTitleList.length;
						for(var c=0; c < headTitleList.length; c++){
							var colNm=prefix + "pol_qty_" + ( c + 1 < 10  ? "0" + (c + 1) : c + 1);
							cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:colNm,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						}
						cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"total_vol", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"total_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 });
					}
					SetMergeCell(0,1,2,1);
					SetMergeCell(0,2,2,1);
					SetMergeCell(0,3,2,2);
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
            	}
                break;
            
            case "t14sheet1":
                with(sheetObj){
					var HeadTitle1="|Remark";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t14sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
                    }
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
    //	sheetObj.ShowDebugMsg = false;
        if(sheetObj == null){
            return;
        }
	    switch(sAction) {
	        case    IBCLEAR:      // Region Combo Setting
//	            formObj.f_cmd.value=SEARCH01;            
//	            var param=FormQueryString(formObj)+"&comboCd=CD02169"; //Region cod 
//	            var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param );
//	            ComXml2ComboItem( sXml, region, "val","val|desc" );
            	formObj.f_cmd.value=SEARCH14;
            	var param=FormQueryString(formObj); //Region cod 
            	var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param );
            	ComXml2ComboItem( sXml, region, "rdr_rgn_cd","rdr_rgn_cd|rdr_rgn_nm" );
	            break;	    
	      case IBSEARCH:
	    	  var sheetID=sheetObj.id;
			  var changeCond=false;
              formObj.f_cmd.value=SEARCH14;
              sheetObjects[1].DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_") );
//@@              if(sheetObjects[1].RowCount()> 0){
              //onsearchend 로 해결?
//              if(sheetObjects[0].RowCount()> 0){
//                  for( var k=0; k < enableButton.length; k++){
//                	  console.log("enableButton start!!"+k);
//                      ComBtnEnable(enableButton[k]);
//                      console.log("enableButton end!!"+k);
//                  }
//              }else{
//                  for( var k=0; k < enableButton.length; k++){
//                      ComBtnDisable(enableButton[k]);
//                  }
//              }
              
			  if(strFlag != "Combo" && strFlag !="oprCd"){
				  if(arrPreCond[0] == document.form.vsl_cd.value)
					  changeCond=true;
				  if(arrPreCond[1] == document.form.voy_no.value)
					  changeCond=true;
				  if(arrPreCond[2] == document.form.dir_cd.value)
					  changeCond=true;
				  if(arrPreCond[3] == region.GetSelectCode())
					  changeCond=true;
			  }
	    	  if(strFlag=="Combo"){
    	  	        formObj.f_cmd.value=SEARCH;
    	  	        var comboXml=sheetObj.GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObj));
    	  	        // 1. Region Combo Data Set..
    		    	var regionList=ComGetEtcData(comboXml, "regionList");
    		    	if(regionList==null || regionList.length<1){
    		    		comboObjects[0].RemoveAll();
    		    		return false;
    		    	}else{
    		    		setComboItem2(comboObjects[0], regionList);
    		    	}
	    	  } else if(strFlag=="oprCd"){
	    		   formObj.f_cmd.value=SEARCH;
	    		   var comboXml=sheetObj.GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObj));
    	    		// 2. Operator Combo Data Set..
    		    	var operatorList=ComGetEtcData(comboXml, "operatorList");
    		    	if(operatorList==null || operatorList.length<1){
    	    			//ComShowCodeMessage("OPF07001", "Operator");
    		    		opr_cd.RemoveAll();
    		    		opr_cd.InsertItem(0, "All", "All");
    		    		opr_cd.SetSelectIndex(0);
    		    		//return false;
    		    	}else{
    		    		setComboItem(opr_cd, operatorList);
    		    		opr_cd.InsertItem(0, "All", "All");
    		    		opr_cd.SetSelectIndex(0);
    		    	}
	    	  }else if(strFlag=="search01"){
	    		  formObj.f_cmd.value=SEARCH01;
	    		  var sXml=sheetObj.GetSearchData("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"));
				  sheetObj.RenderSheet(0);
				  sheetObj.SetWaitImageVisible(0);
				  sheetObj.LoadSearchData(sXml,{Sync:0} );
				  sheetObj.RenderSheet(1);
				  
				  if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" && ComGetEtcData(sXml, "NEXT_PORT") != null && ComGetEtcData(sXml, "NEXT_PORT") != "undefined"){
					  document.form.next_port.value=ComGetEtcData(sXml, "NEXT_PORT"); 	    
					  document.form.next_date.value=ComGetEtcData(sXml, "ETA"); 	    
					  document.form.next_canal.value=ComGetEtcData(sXml, "NEXT_CANAL"); 	    
					  document.form.eta_canal.value=ComGetEtcData(sXml, "ETA_CANAL"); 	 
				  }else{
					  document.form.next_port.value=""; 	    
					  document.form.next_date.value=""; 	    
					  document.form.next_canal.value=""; 	    
					  document.form.eta_canal.value=""; 	  
				  }
	    	  }
	    	  else if(strFlag=="search02"){
	    		  formObj.f_cmd.value=SEARCH20;
	    		  var headerXml=sheetObjects[0].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObj));
	    		  var dataList=ComGetEtcData(headerXml, "operatorList");
	    			  var headerList=dataList.split("|");
	    			  // 1.initialize sheet 
	    			  sheetObj = sheetObj.Reset();
	    			  //sheetObjects[0] = sheetObj;
	    			  t2frame.t2sheet1 = sheetObj;
	    		  	  ComConfigSheet (sheetObj);
	    			  initSheet(sheetObj,2, headerList);
	    		  	  ComEndConfigSheet(sheetObj);
	    			  // 2. param data set..
	    		  	  var paramQty="&qty1="+ConstantMgr.getCompanyCode();
	    			  for(var n=0; n < headerList.length; n++){
	    				  paramQty=paramQty +"&"+"qty"+(n+2)+"="+ headerList[n];
	    			  }
	    			  // 3.*** retrieve date
			  	      formObj.f_cmd.value=SEARCH02;
			  	      var par=FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_") + paramQty;
			  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", par  );
	    		  //}
	    	  }
	    	  else if(strFlag=="search03"){
	    		  formObj.f_cmd.value=SEARCH03;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_") );
	    	  }
	    	  else if(strFlag=="search04"){
	    		  formObj.f_cmd.value=SEARCH04;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_") );
	    	  }
	    	  else if(strFlag=="search05"){
	    		  formObj.f_cmd.value=SEARCH05;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t5sheet1_") );
	    	  }
	    	  else if(strFlag=="search06"){
	    		  formObj.f_cmd.value=SEARCH06;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t6sheet1_") );
	    	  }
	    	  else if(strFlag=="search07"){
	    		  formObj.f_cmd.value=SEARCH07;
	    		  var aryPrefix=new Array("t7sheet1_","t7sheet2_");
	    		  var sXml=sheetObj.GetSearchData("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	  	    	  var arrXml=sXml.split("|$$|");
	              if (arrXml.length > 0) t7frame.t7sheet1.LoadSearchData(arrXml[0],{Sync:0} );
	              if (arrXml.length > 1) t7frame.t7sheet2.LoadSearchData(arrXml[1],{Sync:0} );
	    	  }
	    	  else if(strFlag=="search08"){
	    		  formObj.f_cmd.value=SEARCH08;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t8sheet1_") );
	    	  }
	    	  else if(strFlag=="search09"){
	    		  formObj.f_cmd.value=SEARCH09;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t9sheet1_") );
	    	  }
	    	  else if(strFlag=="search10"){
	    		  formObj.f_cmd.value=SEARCH10;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t10sheet1_") );
	    	  }
	    	  else if(strFlag=="search11"){
	    		  formObj.f_cmd.value=SEARCH11;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t11sheet1_") );
	    	  }
	    	  else if(strFlag=="search12"){
	    		  formObj.f_cmd.value=SEARCH19;
	    		  var headerXml=sheetObjects[0].GetSearchData("VOP_OPF_0045GS.do" , FormQueryString(formObj));
	    		  var dataList=ComGetEtcData(headerXml, "operatorList");
    			  var headerList=dataList.split("|");
    			  // 1. initialize sheet 
    			  sheetObj = sheetObj.Reset();
    			  sheetObjects[0] = sheetObj;
    		  	  ComConfigSheet (sheetObj);
    			  initSheet(sheetObj, 12, headerList);
    		  	  ComEndConfigSheet(sheetObj);
    			  // 2. param data set..
    		  	  var paramQty="";
    			  for(var n=0; n < headerList.length; n++){
    				  paramQty=paramQty +"&"+"qty"+(n+1)+"="+ headerList[n];
    			  }
				  if(dataList == ""){
					sheetObj.LoadSearchData(headerXml,{Sync:0} );
				  }else{
					  // 3.*** retrieve data
					  formObj.f_cmd.value=SEARCH12;
					  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t12sheet1_")+paramQty );
					  fnLoadMerge(sheetObj);
				  }
	    	  }
	    	  else if(strFlag=="search13"){
	    		  formObj.f_cmd.value=SEARCH13;
	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t13sheet1_") );
	    	  }
	    	  else if(strFlag=="search14"){
	    		  formObj.f_cmd.value=SEARCH14;
	    		  
      			  var sXml=sheetObj.GetSearchData("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_") );
	    		  var arrXml=sXml.split("|$$|");
//	    		  sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
	    		  
	    		  var strRemark = "";
	    		  if(  ComGetTotalRows(sXml) > 0 ){
	    			  strRemark = ComGetEtcData(arrXml[0], "remark").split("|");
	    		  }
	    		  formObj.remark.value=strRemark;
//	    		  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_") );
//				  var strRemark="";
//				  if(sheetObj.RowCount()> 0){
//					  strRemark=sheetObj.GetCellValue(sheetObj.HeaderRows(), "t14sheet1_remark");
//				  }
	    	  }
	    	  else if(strFlag=="port_cd"){
              /********************Get Port Code Combo List Start  ********************/
                  formObj.f_cmd.value=SEARCH14;
                  var sXml=sheetObjects[1].GetSearchData("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_"));
                  formObj.port_cd.value="";
                  formObj.port_cd_nm.value="";
                  if(  ComGetTotalRows(sXml) > 0 ){
                      formObj.port_cd.value=ComGetEtcData(sXml, "port_cd");
                      formObj.port_cd_nm.value=ComGetEtcData(sXml, "port_cd_nm");
                  } 
              /********************Get Port Code Combo List End ********************/
	          }
			  arrPreCond[0]=document.form.vsl_cd.value;
			  arrPreCond[1]=document.form.voy_no.value;
			  arrPreCond[2]=document.form.dir_cd.value;
			  arrPreCond[3]=region.GetSelectCode();
			  
			  if(strFlag != "Combo" && strFlag !="oprCd")
				bRetrive=true;
			  break;
	    }
	}
    
	/**
	 * Handling after retrieving t1sheet1 
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		with (sheetObj) {
			if (RowCount()> 0) {
	      if(sheetObjects[0].RowCount()> 0){
	          for( var k=0; k < enableButton.length; k++){
	        	  console.log("enableButton start!!"+k);
	              ComBtnEnable(enableButton[k]);
	              console.log("enableButton end!!"+k);
	          }
	      }else{
	          for( var k=0; k < enableButton.length; k++){
	              ComBtnDisable(enableButton[k]);
	          }
	      }
			}
		}
	}
    
    function fnLoadMerge(sheetObj){
        var prefix=sheetObj.id+"_";
        for(var i=0;i<= sheetObj.LastRow(); i++){
        	if(  sheetObj.GetCellValue(i,  prefix+"cntr_type") ==  sheetObj.GetCellValue(i,  prefix+"cntr_size")
        			&&   sheetObj.GetCellValue(i,  prefix+"cntr_type") == "WEIGHT"
               ){
                sheetObj.SetMergeCell(i, sheetObj.SaveNameCol( prefix+"cntr_type" ), 1, 2 );
            }
        }        
    }
	
    /**
     * adding data on combo field
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0], comboItem[0]);
    	}
    }
    /**
     * adding data on combo field
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(formObj){
    	if(isNull(formObj.vsl_cd.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		//formObj.vsl_cd.focus();
        	return false;
    	}
    	else if(isNull(formObj.voy_no.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		//formObj.voy_no.focus();
        	return false;
    	}
    	else if(isNull(formObj.dir_cd.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		//formObj.dir_cd.focus();
        	return false;
    	}
        else if(isNull(comboObjects[0].GetSelectCode())){
        	//ComShowMessage("\'Region\' is mandatory item.");
			ComShowCodeMessage("COM130201", "Region");
        	//ComSetFocus(formObj.region);
			//region.focus();
        	return false;
        }
        else if(isNull(opr_cd.GetSelectCode())){
        	//ComShowMessage("\'Operator\' is mandatory item.");
			ComShowCodeMessage("COM130201", "Operator");
        	//ComSetFocus(formObj.opr_cd);
        	//opr_cd.focus();
        	return false;
        }
        else if(isNull(formObj.port_cd)){
            ComShowCodeMessage("COM130201", "Port Code");
           // formObj.port_cd.focus();
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * checking Null in window form input value
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
     /**
      * checking Null in window form input value
      */
     function nullParam(itemValue){
         if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	 return "";
         }
         else{
        	 return itemValue;
         }
     }
      function searchVvdMailInfo(){
          var formObj=document.form;
          formObj.f_cmd.value=SEARCH06;
          var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do?st_port_cd=" + formObj.port_cd.value, FormQueryString(formObj));
          var dataColNm="vsl_slan_cd|vsl_eng_nm|ob_cssm_voy_no";
          var vvdInfoData=ComOpfXml2Array(sXml, dataColNm);
          var aVvdInfoData=vvdInfoData[0];
          //var s="["+aVvdInfoData[0]+" RDR====] M/V "+aVvdInfoData[1]+" "+aVvdInfoData[2]+aVvdInfoData[3]+", "+region.GetSelectText();
          var s= aVvdInfoData[0]+" "+aVvdInfoData[1]+" "+aVvdInfoData[2]+", RDR ex "+ formObj.port_cd.value.substring(2);
          formObj.com_subject.value=s;
      }
      function fnSheetClear() {
          var formObj=document.form;
          for(var idxSht=0; idxSht < sheetObjects.length; idxSht++){
              sheetObjects[idxSht].RemoveAll();
          }
          //t2frame
          for(var idxSht=2; idxSht <= 13; idxSht++){
              var subFrameObj=document.getElementById(  't'+idxSht+'frame'  );
              var subFrameObjCon=$('#'+'t'+idxSht+'frame' ) //eval( 't'+idxSht+'frame'  );
              if( subFrameObj.src == ""   ){
                  continue;
              }
              if( subFrameObjCon.sheetObjects == undefined  ){
                  continue;
              }  
              for(var i=0;i< subFrameObjCon.sheetObjects.length ;i++){
                  subFrameObjCon.sheetObjects[i].RemoveAll();
              } 
          }       
          formObj.remark.value="";
          for( var k=0; k < enableButton.length; k++){
              ComBtnDisable(enableButton[k]);
          }
      }
      
      $(window).resize(function() {
   		if(this.resizeTO) {
   			clearTimeout(this.resizeTO);
   		}
   		this.resizeTO = setTimeout(function() {
   			$(this).trigger('resizeEnd');
   		}, 300);
      });
       
      $(window).on('resizeEnd', function() {
     	  iframeResize(true);
      });

      function iframeResize(onloadYn){     
      	/*if(beforetab == 1){
       		//  resizeSheet();
      		ComResizeSheet(sheetObjects[1]);
          }*/
     	  // 선택된 tab의 index를 통해서 iframe 이름을 구합니다.
     	  // beforetab은 tabIndex(현재 선택된 tab)이며 전역변수로 설정되어 있어서 booking의 경우 beforetab를 사용
     	  // 다른 화면도 유사한 코딩으로 되어있을 것으로 판단되며 그렇지 않은 경우는 지원요망.
     	  var ifrId = $('#'+selFrameId);      	  
     	  var height = $(window).height();
     	  var ifrOffset = $(ifrId).offset();
     	  var onloadYnIframe = false;
     	  if(onloadYn) {
     	   iframeMap.put(selFrameId, "Y");
     	  }
     	   
     	  onloadYnIframe = iframeMap.get(selFrameId);   	  
     	  //alert(beforetab);
     	  // 탭에서 Sheet Resizing을 원하는 것만 골라서 변경(ex. Tab 1,2,5,6)
     	  // 단, 해당 탭(Iframe에 해당하는 파일)에 updateSheetSize 라는 함수(공통)가 정의되어 있어야 합니다.
     	  if(beforetab == 2 || beforetab == 3 || beforetab == 4 || beforetab == 5 || beforetab == 6 ||
//     		 beforetab == 7 || beforetab == 8 || beforetab == 9 || beforetab == 10 || beforetab == 11 ||
     	     beforetab == 7 || beforetab == 8 || beforetab == 9 || beforetab == 10 ||
     		 beforetab == 12 || beforetab == 13 && ifrId.length > 0) {
  	   	   	$(ifrId).height(height - ifrOffset.top - iframeAddHeight);      	   
  	   	   if(onloadYnIframe == "Y") {	   		   
  	   		   $(ifrId)[0].contentWindow.updateSheetSize();	   		  	   		   
  	   	   }
     	  }
      }
      
      /**
       * 2014.11.13 added function mai receiver delivery
       */
      function searchReceiveInfo(){
      	var formObj=document.form;
      	
      	formObj.f_cmd.value=SEARCH15;
  		
  		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0045GS.do", FormQueryString(formObj));
  		var tmp = ComGetEtcData(sXml, "CNTC_PSON_EML_CTNT");
  		//com_recipient
  		formObj.com_recipient.value = tmp;
      }
  	/* Developer performance  end */