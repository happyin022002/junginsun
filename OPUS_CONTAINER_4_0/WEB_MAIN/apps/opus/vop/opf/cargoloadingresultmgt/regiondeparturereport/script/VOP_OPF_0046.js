/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046.js
*@FileTitle  : RDR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7 
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var selFrameId;
var iframeMap = new HashMap();
var iframeAddHeight = 0;

//PopUpEdit Check 
var mCheckValue=false;
var mPopUpEditSheet=null;
var mPopUpEditRow=-1;
var mPopUpEditCol=-1;

/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0046 : VOP_OPF_0046 business script for
     */
    function VOP_OPF_0046() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* Developer performance	*/
    // common global variables
       var sheetObjects=new Array();
       var sheetCnt=0;
       var comboObjects=new Array();
       var comboCnt=0;
       var tabObjects=new Array();
       var tabCnt=0 ;
       var beforetab=1;
       var bRetrive=false;    // ReTrieve YN
       var bChangedData=false; //Iframe Chang YN
       var bTabChangeGo=false; 
       var sSheetObjIdx=0;
       var iSelectCell=0;
       var iSetSelectRow=0;
/***************************************************************************
 * manage same index such as Tab Title, Tab IFrame Id, Tab Iframe src Url
 * 
 * aTabTitle     : Tab Title 
 * aTabIframe    : Tab Iframe Name
 * aTabIframeSrc : Tab Iframe Src
 ***************************************************************************/       
       /* Tab Title  */
       var aTabTitle=new Array(   
               "VSL Mvmt",
               "Slot/WGT Util",
               "HC/45'",
               "RF",
               "VSL Alloc.",
               "Remark(s)"
           );
       /*Iframe id by Tab Title */
       var aTabIframeId=new Array(   
               "ifrVslMvmt",
               "ifrSlotWgtUtil",
               "ifrHc45",
               "ifrRf",
               "ifrVslAlloc",
               "ifrRemark"
           );
       /* Iframe src by Tab Title */
       var aTabIframeSrc=new Array(   
               "VOP_OPF_0046_01.do",   
               "VOP_OPF_0046_02.do",
               "VOP_OPF_0046_03.do",
               "VOP_OPF_0046_04.do",
               "VOP_OPF_0046_05.do",
               "VOP_OPF_0046_06.do"
           );
/***************************************************************************/ 
       // Event handler processing by button click event */
       document.onclick=processButtonClick;
       // Event handler processing by button name */
       function processButtonClick(){
          　
                var sheetObject1=sheetObjects[0];
            /*******************************************************/
            var formObject=document.form;
         //  try {
               var srcName=ComGetEvent("name");
               if(ComGetBtnDisable(srcName)) return false;
               var className=ComGetEvent("class");
               if( className == "btn1_1"){
                   return;
               }
               switch(srcName) {
                   case "btns_searchVvd":
                       var vslcd=formObject.vsl_cd.value;
                       var sUrl="";
                       if(vslcd == ""){
                           sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
                           ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                       }else{
                           sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
                           ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                       }
                       break;
                   case "btn_New":
                       doActionIBSheet(sheetObjects[0], document.form, IBRESET );
                       break;
                   case "btn_Retrieve":
                         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH );
                         formObject.flagRetrieveYn.value="Y";
                         break;
                   case "btn_Save":                	   
                	   	 if(beforetab == 0){
	                	   	 var subFrameObj=eval( aTabIframeId[0] ); //extract Iframe                	   	 
	                	   	 if(subFrameObj.chkDate()){                	   	 
	                	   		 doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
	                	   	 }
                	   	 }else{
                	   		 doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
                	   	 }
                         break;
                   case "btn_Delete":
                         doActionIBSheet(sheetObjects[0], document.form, IBDELETE );
                         break;
                   case "btn_Print":
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
                                       + " ["+(formObject.port_cd.value)+"]"    // 3.Direction
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
                                       + " ["+nullParam(addSlotHeader[8])+"]";            // 28.AddSlot Header 9
                       formObject.com_mrdArguments.value=rdParam;
                       ComOpenRDPopup('resizable=yes');
                       break;
               } // end switch
//           }catch(e) {
//               if( e == "[object Error]") {
//                   ComShowMessage(OBJECT_ERROR);
//               } else {
//                   ComShowMessage(e);
//               }
//           }
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
        * Setting Combo 
        * Set item of Combo
        */
       function initCombo(comboObj) {
           with(comboObj) {
               switch(comboObj.options.id) {
                   case "region":
                       //SetTitle("Code|Description");
                       SetColWidth			(0, "45");
                       SetColWidth			(1, "120");

                       //:2016-06-27:by TOP://SetEnable(0);
                       SetEnable			(1);
                       ///////////////////////////////////
                       
                       SetDropHeight		(230);
                       SetMultiSelect		(0);
                       SetMaxSelect			(1);
                       SetUseAutoComplete	(1);
                       break;
                   case "port_cd":
                       //SetTitle("name|call_ind|call_ind");
                	   SetColWidth(0, "70");
                	   SetColWidth(1, "230");
                	   SetColWidth(2, "0");
                       SetDropHeight(250);
                       SetMultiSelect(0);
                       SetMaxSelect(1);
                       SetUseAutoComplete(1);
                       break;
               }
           }
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
                       for(; cnt < aTabTitle.length; cnt++){
                	   		InsertItem( aTabTitle[cnt], "");
                       }
                   }
                break;
            }
       }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
            var formObj=document.form;
           
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
           doActionIBSheet( sheetObjects[0], formObj, IBCLEAR);
           tab1_OnClick( tabObjects[0] , 0);
           formObj.vsl_cd.focus();
       }
        /**
         * Loading event of HTML Control in page dynamically <br>
         * initializing IBSheet by calling {@link #loadPage}Method <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {int}     sheetNo     sheetObjects 
         **/
        function initControl(){
            var form=document.form;
            axon_event.addListenerForm  ('keyup'   	, 'obj_keyup'  		, form);
        	axon_event.addListener		('change'	, 'vsl_cd_onchange'	, 'vsl_cd', '');				//Vsl_cd변경시.
        	axon_event.addListener		('change'	, 'voy_no_onchange'	, 'voy_no', '');				//Vsl_cd변경시.
            //axon_event.addListenerForm  ('keypress', 'obj_keypress',     form); 
        }
      /**
       * handling in case of form Object Keydown event
       * @param  void
       * @return void
       */     
        /*
       function obj_keyup(){
            var obj=ComGetEvent();
            var formObj=document.form;
            switch(ComGetEvent("name")){
            
               case 'vsl_cd':
                     var objMaxLength=obj.getAttribute("maxLength");
                     if (ComChkLen(obj.value, objMaxLength) == 2) {
                         ComSetNextFocus(obj);
                     }
                     ComClearObject(formObj.voy_no);
                     ComClearObject(formObj.dir_cd);
                     fnClearSearchOption();
                     break;
               case 'voy_no':
                     var objMaxLength=obj.getAttribute("maxLength");
                     if (ComChkLen(obj.value, objMaxLength) == 2) {
                         ComSetNextFocus(obj);
                     }
                     ComClearObject(formObj.dir_cd);
                     fnClearSearchOption();
                     break;
               case 'dir_cd':
                     fnClearSearchOption();
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC03 );//Check VVD 
                     break;
            }
       }
        */
    	function vsl_cd_onchange(){
    		var formObj=document.form;
    		ComClearObject(formObj.voy_no);
            ComClearObject(formObj.dir_cd);
            fnClearSearchOption();
    	}
    	function voy_no_onchange(){
    		var formObj=document.form;
    		ComClearObject(formObj.dir_cd);
            fnClearSearchOption();
    	}
       function obj_keyup() {
    	   var formObj=document.form;
    		switch(ComGetEvent("name")){ 
    		
//		          case 'vsl_cd':
//		                var objMaxLength = obj.getAttribute("maxLength");
//		
//		                if (ComChkLen(obj.value, objMaxLength) == 2) {
//		                    ComSetNextFocus(obj);
//		                }
//		                ComClearObject(formObj.voy_no);
//		                ComClearObject(formObj.dir_cd);
//		                fnClearSearchOption();
//		                break;
//		                
//		          case 'voy_no':
//		                var objMaxLength = obj.getAttribute("maxLength");
//		                if (ComChkLen(obj.value, objMaxLength) == 2) {
//		                    ComSetNextFocus(obj);
//		                }
//		                ComClearObject(formObj.dir_cd);
//		                fnClearSearchOption();
//		                break;
    		
                case 'dir_cd':
                    fnClearSearchOption();
                    doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC03 );//Check VVD 
                    break;
    			default:
    				//obj_nextfocus(event.srcElement);
    				ComKeyEnter('LengthNextFocus');
    				break;     
    		}
    	} 
       
   	function getObjValue(name) {
		return ComGetObjValue(eval("document.form."+name));
	}
   	
   	function searchVVDInfo() {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH06;
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		//VVD 정보 관련 항목 셋팅
		setVVDInfo(formObj, sXml);
	}
   	
       /**
        * Call BAck Start in case of clicking PopUp
        */
      function setCallBackVSL(rtnObjs) {
          var formObj	= document.form;
          
          //alert('setCallBackVSL.rtnObjs >> '+rtnObjs);
          
          if(jQuery.type(rtnObjs) === "string") {
              formObj.vsl_cd.value	= rtnObjs;
              formObj.voy_no.focus();
          }else{
              if(rtnObjs){
                  var rtnDatas=rtnObjs[0];
                  if(rtnDatas){
                      if(rtnDatas.length > 0){
                          formObj.vsl_cd.value	= rtnDatas[1];
                          formObj.voy_no.focus();
                          setClearPortRegion();
                      }
                  }
              }
          }
      } 
      
      function setCallBackVVD(obj) {
          var formObj	= document.form;
          
          //alert('setCallBackVVD.obj >> '+obj);
          
          if(obj){
              var rtnDatas=obj[0];
              if(rtnDatas){
                  if(rtnDatas.length > 0){
                      formObj.voy_no.value	= rtnDatas[2];
                      formObj.dir_cd.value	= rtnDatas[3];
                      setClearPortRegion();
                  }
              }
          }
          doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01 ); 
      } 
      
      function setClearPortRegion(){
    	  var formObj	= document.form;
    	  
    	  region.SetSelectCode	("",false);
    	  port_cd.SetSelectCode	("",false);
          //ComClearObject		( formObj.port_cd 	);
          ComClearObject		( formObj.port_cd_nm);
          //ComClearObject		( formObj.region 	);
      }
      
      function setControlRegion(sRdrExistYn, sRdrRegionCd){
    	  
    	  if(sRdrExistYn == "Y"){
    		  region.SetSelectCode(sRdrRegionCd,false);
    		  region.SetEnable(0);
    	  }else{
    		  //region.SetSelectCode("",false);
    		  region.SetEnable(1);
    	  }
      }
      
       /**
        * 
        * <pre>
        * retrieve option Clear , Region, Port Cd, port nm, sys_create_desc
        * </pre>
        *
        *
        */
       function fnClearSearchOption(){
           var formObj=document.form;
           region.SetSelectCode("",false);
           port_cd.SetSelectCode("",false);
           ComClearObject(formObj.port_cd_nm);
           fnClear();
       }
        /**
         * input only english and number on onKeypress of HTML Control<br>
         **/
       /*
        function obj_keypress() {
            var obj=ComGetEvent();
            var formObj=document.form;
            switch(ComGetEvent("name")){
                case 'vsl_cd':
                      ComKeyOnlyAlphabet('uppernum');
                      break;
                case 'voy_no':
                      ComKeyOnlyNumber(ComGetEvent());
                      break;
                case 'dir_cd':
                      ComKeyOnlyAlphabet('upper');
                      break; 
            } 
        }
        */
       
       /**
        * setting block on onfocus event of HTML Control <br>
        **/
       function focus_event(){
           //ComSetFocus(event.srcElement);
    	   var evt=ComGetEvent();
           evt.select();
       }
       
       /**
        * setting sheet initial values and header
        * param : sheetObj, sheetNo
        * adding case as numbers of counting sheets
        */
       function initSheet(sheetObj,sheetNo ) {
                var sheetID=sheetObj.id;
                var cnt=0;
                switch(sheetID) {
                    case "sheet1":
                        with(sheetObj){
							var HeadTitle="|VSL_CD|VOY_NO|DIR_CD|REGION|PORT_CD|RDR_DATE|RDR_USER|REMARK|UPDATE_USER|UPDATE_TIME|NEXT_PORT|ETA|NEXT_CANAL|ETA_CANAL";
							var headCount=ComCountHeadTitle(HeadTitle);
							var prefix=sheetObj.id+"_";
							
							SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
							
							var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
							var headers = [ { Text:HeadTitle, Align:"Center"} ];
							InitHeaders(headers, info);
							
							var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"region",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rdr_date",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rdr_user",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"update_user", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"update_time", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"next_port",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eta",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"next_canal",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_canal",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
							InitColumns(cols);
							SetSheetHeight(120);
							SetEditable(1);
                        }
                        break;
                }
       }
       
        function doActionIBSheet(sheetObj,formObj,sAction ) {
            switch(sAction) {
                case    IBCLEAR:      // Region Combo Setting
//                  formObj.f_cmd.value=SEARCH01;
//                  var param=FormQueryString(formObj)+"&comboCd=CD02169"; //Region cod 
//                  var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param );
//                  ComXml2ComboItem( sXml, region, "val","val|desc" );
                	formObj.f_cmd.value=SEARCH14;
                	var param=FormQueryString(formObj); //Region cod 
                	var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param );
                	ComXml2ComboItem( sXml, region, "rdr_rgn_cd","rdr_rgn_cd|rdr_rgn_nm" );
                        break;
                case    IBSEARCH_ASYNC01:      //Port(Port Code) Combo Setting 
//                        formObj.f_cmd.value=SEARCH11;
                		formObj.f_cmd.value=SEARCHLIST02;   
                        var param=FormQueryString(formObj);
//                        var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param);
                        var sXml=sheetObj.GetSearchData("VOP_OPF_0046GS.do", param);
                        ComXml2ComboItem( sXml, port_cd, "val","val|name|region" );
                        formObj.region.focus();
                        break;
                        
                case    IBSEARCH_ASYNC02:   //get Header info
                        formObj.f_cmd.value	= SEARCHLIST01;            
                        var prefix			= sheetObj.id+"_";
                        var param			= FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                        
                        //:2016-06-30://sheetObj.DoSearch("VOP_OPF_0046GS.do", param);///////////
                        var sXml			= sheetObj.GetSearchData("VOP_OPF_0046GS.do", param);
                        var sRdrExistYn		= ComGetEtcData			(sXml, "RDR_EXIST_YN");
                        var sRdrRegionCd	= ComGetEtcData			(sXml, "RDR_REGION_CD");
                        
                        setControlRegion(sRdrExistYn, sRdrRegionCd);
                        /////////////////////////////////////////////////////////////////////////
                        
                        break;
                        
                case    IBSEARCH_ASYNC03:   //VVD Check
                        formObj.f_cmd.value	= SEARCH06;
                        var param			= FormQueryString(formObj)+"&skd_voy_no="+formObj.voy_no.value+"&skd_dir_cd="+formObj.dir_cd.value;
                        var sXml			= sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param );
                        
                        if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                            if( ComGetTotalRows(sXml) == "0"  ){
                                ComShowCodeMessage("OPF50004", "VVD Code");
                                ComClearObject( formObj.vsl_cd );
                                ComClearObject( formObj.voy_no );
                                ComClearObject( formObj.dir_cd );
                                ComSetFocus   ( formObj.vsl_cd );
                                
                                return;
                            }else{//all is ok, retrieve Port List 
                                doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                            }
                        }
                        break;
                        
                case    IBSEARCH:      //Retrieve
                        if( !validateForm( sheetObj,formObj,sAction ) ){ return;} 
                        fnGetHeader();
                        var subFrameObj=eval( aTabIframeId[beforetab] ); //extract Iframe 
                        
                        fnSetFramSearchOption(subFrameObj);
                        
                        if (typeof subFrameObj.sheetObjects == "undefined") return;
                        /***************************************************************************/
                        subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
                        fnSetBtnAuth();
                        break;
                        
                case    IBSAVE:        //save
                        if(!validateForm( sheetObj,formObj,sAction )){ return;}
                        if(!checkMax(aTabTitle[beforetab])) { return false;}
                        var subFrameObj=eval( aTabIframeId[beforetab] ); //extract Iframe 
                        fnSetFramSearchOption(subFrameObj);
                        /***************************************************************************/
                        subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
                        break;
                        
                case    IBDELETE:      //delete.
                        if(!validateForm( sheetObj,formObj,sAction )){ return;}
    //                    var subFrameObj  =  eval( aTabIframeId[beforetab] ); //extract Iframe
    //                    
    //                    subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
                        formObj.f_cmd.value=REMOVELIST;
                        var sParam=FormQueryString(formObj);
                        var sXml=sheetObj.GetSearchData("VOP_OPF_0046GS.do" ,   sParam  );
                        sheetObj.LoadSearchData(sXml,{Sync:1} );
                        if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                            fnAllGridInit();
                        }
                        break;
                        
                case    IBRESET: //Btn_New
                        formObj.vsl_cd.value="";
                        formObj.voy_no.value="";
                        formObj.dir_cd.value="";
                        region.SetSelectCode(-1,false);
                        fnClear();
                        formObj.vsl_cd.focus();
                        break; 
            }
        }
        
       //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj){
       //}
       function fnGetHeader(){
           var formObj	= document.form;
           doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
       }
       
       function fnClear(){
           var formObj=document.form;
           ComOpfSetBtnEnable("c", false);                        
           port_cd.SetSelectCode("",false);
           formObj.port_cd_nm.value="";
           port_cd.RemoveAll();
           fnGridClear();
       }
       function fnGridClear(){
           var formObj=document.form;
           formObj.flagRetrieveYn.value="N";
           for(var i=0;i<sheetObjects.length;i++){
               sheetObjects[i].RemoveAll();
           }
           for(var i=0;i<aTabIframeId.length;i++){
               var frame=eval( "document.getElementById('"+aTabIframeId[i]+"')" ); //extract Iframe
               if( frame.src != ""){
                   var subFrameObj=eval( aTabIframeId[i] ); //extract Iframe Content Object 
//                   if(subFrameObj.sheetObjects != "undefined") {
                   if(jQuery.type(subFrameObj.sheetObjects) != "undefined") {
                	   subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, IBRESET);    
                   }
               }
           }
       }
       /**
        * In case of clicking Tab event relation
        * activate element of Tab chosen
        */
       function tab1_OnClick(tabObj , nItem)
       {
//             if(nItem == beforetab){
//                return;
//             }
             if ( fnSetChangeData() ){//in case of changing data
                  doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
                  if( !bTabChangeGo ){
                       tabObj.SetSelectedIndex(beforetab);
                       var subSheets=eval( aTabIframeId[beforetab]+".sheetObjects["+sSheetObjIdx+"]" );
                       subSheets.SelectCell( subSheets.GetSelectRow(),  iSelectCell);
                       return;
                  }
             }
             bChangedData=false;
//             var objs=document.all.item("tabLayer");
//             objs[nItem].style.display="Inline";
//             if( beforetab != -1 ){
//                 objs[beforetab].style.display="none";
//             }
//            beforetab=nItem;
//            var objs=document.all.item("tabLayer");
//         	objs[nItem].style.display="Inline";
//         	for(var i = 0; i<objs.length; i++){
//         		if(i != nItem){
//         			objs[i].style.display="none";
//         			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//         		}
//         	}
//         	beforetab=nItem;
            var objs=document.all.item("tabLayer");
            objs[nItem].style.display="Inline";
            var frame=eval( "document.getElementById('"+aTabIframeId[nItem]+"')" ); //extract Iframe
            var frameSrc=aTabIframeSrc[nItem];
            if(frame.src == ""){
                frame.src=frameSrc;
            }else{
                /* in case Iframe exists src value  */
                var  formObj=document.form;
                if(  formObj.flagRetrieveYn.value  == "Y" ){
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH);
                }
            }
       }
       function tab1_OnChange(tabObj , nItem)
       {
    	   if(nItem == beforetab){
               return;
            }
            if ( fnSetChangeData() ){//in case of changing data
                 doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
                 if( !bTabChangeGo ){
                      tabObj.SetSelectedIndex(beforetab);
                      var subSheets=eval( aTabIframeId[beforetab]+".sheetObjects["+sSheetObjIdx+"]" );
                      subSheets.SelectCell( subSheets.GetSelectRow(),  iSelectCell);
                      return;
                 }
            }
            bChangedData=false;
//            var objs=document.all.item("tabLayer");
//            objs[nItem].style.display="Inline";
//            if( beforetab != 1 ){
//                objs[beforetab].style.display="none";
//            }
//           beforetab=nItem;
    	   var objs=document.all.item("tabLayer");
    	   objs[nItem].style.display="Inline";
    	   for(var i = 0; i<objs.length; i++){
	    	   if(i != nItem){
	    		   objs[i].style.display="none";
	    		   objs[i].style.zIndex=objs[nItem].style.zIndex - 1 ;
	    	   }
    	   }
    	   beforetab=nItem;
           var frame=eval( "document.getElementById('"+aTabIframeId[nItem]+"')" ); //extract Iframe
           selFrameId = frame.id;
           var frameSrc=aTabIframeSrc[nItem];
           if(frame.src.indexOf('VOP_OPF_0046_') < 0){
               frame.src=frameSrc;
           }else{
               /* in case Iframe exists src value  */
               var  formObj=document.form;
               if(  formObj.flagRetrieveYn.value  == "Y" ){
                    doActionIBSheet( sheetObjects[0], formObj, IBSEARCH);
               }
           }
//		   	var objs=document.all.item("tabLayer");
//		   	objs[nItem].style.display="Inline";
//		   	for(var i = 0; i<objs.length; i++){
//		   		if(i != nItem){
//		   			objs[i].style.display="none";
//		   			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//		   		}
//		   	}
//		   	beforetab=nItem;
//    	   var objs=document.all.item("tabLayer");
//    	   objs[nItem].style.display="inline";
//    	   for(var i = 0; i<objs.length; i++){
//	    	   if(i != nItem){
//	    		   objs[i].style.display="none";
//	    		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//	    	   }
//    	   }
//    	   beforetab=nItem;
//    	   
//    	   if ( fnSetChangeData() ){//in case of changing data
//               doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
//               if( !bTabChangeGo ){
//                    tabObj.SetSelectedIndex(beforetab);
//                    var subSheets=eval( aTabIframeId[beforetab]+".sheetObjects["+sSheetObjIdx+"]" );
//                    subSheets.SelectCell( subSheets.GetSelectRow(),  iSelectCell);
//                    return;
//               }
//          }
//          bChangedData=false;
//          var frame=eval( "document.getElementById('"+aTabIframeId[nItem]+"')" ); //extract Iframe
//          var frameSrc=aTabIframeSrc[nItem];
//          if(frame.src == ""){
//              frame.src=frameSrc;
//          }else{
//              /* in case Iframe exists src value  */
//              var  formObj=document.form;
//              if(  formObj.flagRetrieveYn.value  == "Y" ){
//                   doActionIBSheet( sheetObjects[0], formObj, IBSEARCH);
//              }
//          }
           iframeResize(false);
       }
        /**
         * 
               *
         * @param   
         * @return {true(in case of changing), false}
         * @author 
         */
       function fnSetChangeData(){
           var subFrameObj=eval( aTabIframeId[beforetab] ); //extract Iframe
           if(beforetab == 1){
               return false;
           }
           var subSheets=subFrameObj.sheetObjects;
           if(subSheets == undefined||subSheets == null){return;}
           var rowCnt=0;
           for(var i=0;i< subSheets.length ;i++){
               rowCnt += subSheets[i].RowCount("I")+subSheets[i].RowCount("U")+subSheets[i].RowCount("D");
           }
           if( rowCnt > 0){
               bChangedData=true;
               return true;
           }
           return false;
       }
        /**
         * 
         * <pre>
         *    Region Combo OnChange event
         * </pre>
         *
         * 
         */
       function region_OnChange( comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
//           var formObj=document.form;
//           port_cd.SetSelectCode("",false);
//           ComClearObject(formObj.port_cd_nm);
    	   
           var formObj 				= document.form;
           formObj.port_cd.Code2 	= "";
           
           //:2016-06-27:by TOP://ComClearObject(formObj.port_cd_nm);
           ComClearObject			(formObj.sys_create_desc);
           //////////////////////////////////////////////////////////
       }
       
     /**
      * 
      * <pre>
      *    Port Code Combo OnChange event implement.
      * </pre>
      *
      * 
      */
       function port_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
    	   
           var formObj	= document.form;
           
//           var aText=NewTxt.split("|");
//           formObj.port_cd_nm.value=comboObj.GetText(NewCod, 1);
//           formObj.region.Code2 = comboObj.GetIndexText(NewIdx, 2);
//           formObj.region.Code2 = comboObjects[1].GetIndexText(NewIdx, 1);
//           region.SetSelectCode(comboObjects[1].GetIndexText(NewIdx+1, 1),false);
           
           var idx 		= parseInt(NewIdx);
           
           //:2016-06-27:Commented by TOP:Allow to multiple region by port://
           for(var i=0;i<region.GetItemCount();i++) {
           	   if(region.GetText(i, 0) == comboObj.GetText(idx, 2)) {
           		   region.SetSelectIndex(i);
           		   //region.SetSelectCode(comboObj.GetText(idx, 2), false);
           		   break;
           	   }
           }
           /////////////////////////////////////////////////////////////////
           
           formObj.port_cd_nm.value			= comboObj.GetText(idx, 1);
           formObj.sys_create_desc.value 	= "";
           fnGridClear();
           
           //:2016-06-30:by TOP://////////////////////////////////////
           doActionIBSheet(sheetObjects[0], document.form, IBSEARCH );
           formObj.flagRetrieveYn.value="Y";
           ///////////////////////////////////////////////////////////
           
       }
       
       /**
        * handling process for input validation
        */
       function validateForm(sheetObj,formObj,sAction){
           if(!ComChkValid(formObj))
           {
             return false;
           }
           if( region.GetSelectCode()== "" ){
               ComShowCodeMessage("COM130201", "Region");
               region.focus();
               return false;
           }
           if( port_cd.GetSelectCode()== "" ){
               ComShowCodeMessage("COM130201", "Port");
               port_cd.focus();
               return false;
           }
           switch( sAction ){
                   case IBSEARCH: 
                        break;
                   case IBSAVE: 
                         if( port_cd.GetSelectCode()== "" ){
                            ComShowCodeMessage("COM130201", "Port");
                            port_cd.focus();
                            return false;
                         }
                       break;
                   case IBDELETE: 
                       if( !ComShowCodeConfirm("OPF50002", "RDR Data" ) ){                            
                           return false;
                       }   
                       break;           
           }
           return true;
       }
     /**
      *  setting retrieve option of Main Frame to Hidden Element of SubFrame 
      *  Submit() in Sub Frame  <br>
      *  
      * @param subFrameObj : Sub Frame Object
      * @return void
      * 
      *
      */
       function fnSetFramSearchOption(subFrameObj){
           var mForm=document.form;
           var sForm=subFrameObj.form;
           if(sForm == undefined||sForm ==null){return;}
           sForm.vsl_cd.value=mForm.vsl_cd.value;
           sForm.voy_no.value=mForm.voy_no.value;
           sForm.dir_cd.value=mForm.dir_cd.value;
           sForm.region.value=region.GetSelectCode();
           sForm.port_cd.value=port_cd.GetSelectCode();
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
      function fnSetBtnAuth(){
          var formObj=document.form;
      }
      function fnAllGridInit(){
          for(var k=0;k<aTabIframeId.length ;k++ ){
              var subFrameObj=eval( aTabIframeId[k] ); //extract Iframe
              var subSheets=subFrameObj.sheetObjects;
              if(subSheets == undefined||subSheets == null){continue;}
              for(var i=0;i< subSheets.length ;i++){
                  subSheets[i].RemoveAll();
              } 
              var subForm_ifrVslMvmt=eval( aTabIframeId[k] );
              if( aTabIframeId[k] == "ifrVslMvmt"){
                  ComClearObject( subForm_ifrVslMvmt.form.next_port    );
                  ComClearObject( subForm_ifrVslMvmt.form.eta          );
                  ComClearObject( subForm_ifrVslMvmt.form.next_canal   );
                  ComClearObject( subForm_ifrVslMvmt.form.eta_canal    ); 
              }
              if( aTabIframeId[k] == "ifrRemark"){
                  subForm_ifrVslMvmt.form.remark.value="";
              }
          }
          var formObj=document.form;
          ComClearObject(formObj.vsl_cd);
          ComClearObject(formObj.voy_no);
          ComClearObject(formObj.dir_cd);
          region.SetSelectCode("",false);
          port_cd.RemoveAll();
          ComClearObject(formObj.port_cd_nm);
          formObj.flagRetrieveYn.value="";
          formObj.vsl_cd.focus();
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
      	  
      	  // 탭에서 Sheet Resizing을 원하는 것만 골라서 변경(ex. Tab 1,2,5,6)
      	  // 단, 해당 탭(Iframe에 해당하는 파일)에 updateSheetSize 라는 함수(공통)가 정의되어 있어야 합니다.
      	  if(beforetab == 0 || beforetab == 1 || beforetab == 2 || beforetab == 3 || beforetab == 4 || beforetab == 5) {
      	      $(ifrId).height(height - ifrOffset.top - iframeAddHeight);      	   
      	      if(onloadYnIframe == "Y") {
      	          $(ifrId)[0].contentWindow.updateSheetSize();
      	      }
      	  }
      }
  	function getCallBack(sheetObj, prefix, colNm, Row, Col){
		popupSheet=sheetObj;
		popupPrefix=prefix;
		popupColNm=colNm;
		if(colNm == "port_cd" || colNm == "pol" || colNm == "pod") {
			ComOpenPopup("VOP_VSK_0043.do?port_cd="+sheetObj.GetCellValue(Row, Col), 422, 520, "setCallBack", "0,0", true, false, Row, Col, 0);
		} else {
			ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.GetCellValue(Row, Col), 530, 530, "setCallBackOprCd", "0,0,1,1,1,1", true, false, Row, Col, 0);
		}
	}
	function setCallBack(rtnObjs){
		if(rtnObjs){
			popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + popupColNm, rtnObjs,0);
		}
		mCheckValue=false;
	} 
	function setCallBackOprCd(rtnObjs){
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + popupColNm,rtnDatas[3]);
				}
			}
		}
		mCheckValue=false;
	}
	
    function checkMax(tab) {
    	if(tab == "Slot/WGT Util") {
    		var subFrameObj=eval(aTabIframeId[beforetab]);
        	var sheet = subFrameObj.sheetObjects[0];
			// Slot/WGT Util
			for(var i=3;i<sheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "sheet1_";
				if(sheet.GetCellValue(i, prefix+'total_wgt') > 999999.9) {
					checkItem = prefix+"total_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '999,999.9' );
					sheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
    	}
    	if(tab == "HC/45'") {
    		var subFrameObj=eval(aTabIframeId[beforetab]);
        	var sheet = subFrameObj.sheetObjects[0];
        	var msg = "";
			// HC/45'
			for(var i=3;i<sheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "sheet1_";
				if(sheet.GetCellValue(i, prefix+'hc20_rate') > 99.999) {
					checkItem = prefix+"hc20_rate";
					msg = "20 High Cubic Over ";
				}
				if(sheet.GetCellValue(i, prefix+'hc40_rat') > 99.999) {
					checkItem = prefix+"hc40_rat";
					msg = "40 High Cubic Over ";
				}
				if(sheet.GetCellValue(i, prefix+'un_rat_45') > 99.999) {
					checkItem = prefix+"un_rat_45";
					msg = "45' Under ";
				}
				if(sheet.GetCellValue(i, prefix+'ov_rat_45') > 99.999) {
					checkItem = prefix+"ov_rat_45";
					msg = "45' Over ";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', msg+'Ratio[T]' , '99.999' );
					sheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
    	}
    	return true;
    }
      /* Developer performance  end */