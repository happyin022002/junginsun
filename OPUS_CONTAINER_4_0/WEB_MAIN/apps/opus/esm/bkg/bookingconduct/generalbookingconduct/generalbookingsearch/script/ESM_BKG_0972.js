/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0972.js
*@FileTitle  : Service Mode And Route
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /* Global Variables */
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler defined process to button click event */
    document.onclick = processButtonClick;

    /* Event handler is branch processing by name of button */
    function processButtonClick(){
    	 /***** Assignment sheet in case of over 2 by tab****/
         /*******************************************************/
        var sheetObject1=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {    
            	case "btn_Save":
            		doActionIBSheet(sheetObject1, formObject, IBSAVE);
            		break;
	          case "btn_Close":
                ComClosePopup(); 
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
    /**
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;    			
    }
    /**
     * Initializing sheet
     * To implement onLoad event of body tag
     * Add functionality to after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);                 
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
    }        
    function initSheet(sheetObj,sheetNo) {
    	
    	var sheetID=sheetObj.id;
		switch(sheetID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                    var HeadTitle="|22";
                    var headCount=ComCountHeadTitle(HeadTitle);
                    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"detailChk" } ];
                     
                    InitColumns(cols);
                    SetWaitImageVisible(0);
                    SetVisible(0);
                }
                break;
        }
    }        
    /* Processing Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
          case IBSEARCH:      //retrieve
        	  formObj.f_cmd.value=SEARCH;		
              var sXml= sheetObj.GetSearchData("ESM_BKG_0972GS.do", FormQueryString(formObj));
              formObj.orgScontiCd.value=ComGetEtcData(sXml, "org_sconti_cd");
              formObj.destScontiCd.value=ComGetEtcData(sXml, "dest_sconti_cd");
              formObj.orgTrnsSvcModCd.value=ComGetEtcData(sXml, "org_trns_svc_mod_cd");      
              formObj.destTrnsSvcModCd.value=ComGetEtcData(sXml, "dest_trns_svc_mod_cd");
              formObj.org_trns_svc_mod_nm.value=ComGetEtcData(sXml, "org_trns_svc_mod_nm");      
              formObj.dest_trns_svc_mod_nm.value=ComGetEtcData(sXml, "dest_trns_svc_mod_nm");
              formObj.blckStwgCd.value=ComGetEtcData(sXml, "blck_stwg_cd");              
              formObj.old_blck_stwg_cd.value=ComGetEtcData(sXml, "blck_stwg_cd");              
              formObj.ca_flg.value=ComGetEtcData(sXml, "ca_flg");
              if(formObj.ca_flg.value=="Y"){
            	  ComBtnDisable("btn_Save");
            	  ComGetObject("blckStwgCd").className="noinput";
            	  formObj.blckStwgCd.readOnly=true;
              }
              
              break;
          case IBSAVE:      //retrieve
        	  var sXml = "";
        	  if(formObj.old_blck_stwg_cd.value == formObj.blckStwgCd.value)	return false;
        	  
        	  if(formObj.blckStwgCd.value != ""){
        		  var blck_stwg_flg=ComGetEtcData(sXml, "blck_stwg_flg");
            	  if(blck_stwg_flg == "N"){
            		  ComShowCodeMessage("BKG00651","Block Stowage");
           			  return false;
            	  }  
        	  }
        	  
        	  sXml=sheetObj.GetSearchData("ESM_BKG_0972GS.do?f_cmd="+SEARCH02, FormQueryString(formObj));
        	  
        	  formObj.f_cmd.value=MULTI;
        	  sXml = sheetObj.GetSaveData("ESM_BKG_0972GS.do", FormQueryString(formObj));
        	  var success_yn = ComGetEtcData(sXml, "SuccessYn");
        	  if(success_yn == "Y"){
        		  ComShowCodeMessage("BKG06022");
        		  
        		  doActionIBSheet(sheetObj,formObj,IBSEARCH);   
        	  }else{
        		  ComShowCodeMessage("BKG06087");
        	  }
              break;
        }
    }  
    
	function msgmove(type){
		var stop="150px";
		var sleft="0px";
		if(type == "org"){
			sleft="400px";
		} else {
			sleft="550px";
		}
		msg.style.left=sleft;
		msg.style.top=stop;
	}
	function msgset(strmsg){
		text='<table  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; width:150px;"><tr><td>' + strmsg + '</td></tr></table>';
		msg.innerHTML=text;
	}
	function msghide(){
		msg.innerHTML='';
	}	
