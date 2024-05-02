/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0066.jsp
 *@FileTitle : Organic Peroxides & Self-Reactive Substances - Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0066 : business script for vop_scg_0066
     */
    function vop_scg_0066() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    } 
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
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
		            case "btn1_Excel":
    		              var paramObj=new Object();
    		              paramObj.title="Organic Peroxides and Self-Reactive Substances";
//                          paramObj.columnwidth="2:6|3:5|4:15|5:40|6:10|7:10|8:10|9:10|10:10";
//    		              paramObj.datarowheight="0:25";
//    		              var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);  
//     		              sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(    		              sheetObjects[0]), SheetDesign:1,Merge:1 });
    		              //sheetObjects[0].SpeedDown2Excel(-1);
  						var sheetExcelObj = sheetObjects[0];
	                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
	                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
	                    paramObj.datarowheight="0:25";
	                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
	                    
	                    if(sheetExcelObj.RowCount() < 1){//no data
	                		  ComShowCodeMessage("COM132501");
	        	       	}else{
		       	       		var str = sheetExcelObj.GetSearchData(url);
		       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
		       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
	        	       	}    		              
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         sheet1_OnLoadFinish(sheetObjects[0]);
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
       function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet( sheetObj,document.form,IBSEARCH);
      }      
      function initControl() {
          var form=document.form;
//          axon_event.addListenerForm('keypress','obj_keypress',    form  );
//          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }          
      /**
      * Handling Form Object obj_keypress event
      * @param  void
      * @return void
      */     
//      function obj_keypress (){
//          var obj=event.srcElement;
//          switch(ComGetEvent("name")){
//               case 'imdg_un_no':
//                    ComKeyOnlyNumber(obj);
//                    break;
//          }
//      }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
                     // setting height
            	 
            	 (11, 0, 0, true);
            	 var HeadTitle="|No.|UN No/Seq.|UN No/Seq.|Classification|Technical Names|Concentration\n(%)|Packing\nMethod|Control\nTemp(℃)|Emergency\nTemp(℃)|Subsidiary\nRisks";

            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq" },
            	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"imdg_org_ract_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:1,   SaveName:"imdg_tec_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"imdg_conc_rt_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_mzd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"imdg_ctrl_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"imdg_emer_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	  
            	 InitColumns(cols);
            	 //SetSheetHeight(456);
            	 resizeSheet();
            	 SetEditable(0);
                }
                 break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
   // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 					case IBSEARCH:      //retrieve
                    formObj.f_cmd.value=SEARCH;
                    var param=FormQueryString(formObj);
					if(sheetObj.id == "sheet1")
 						sheetObj.DoSearch("VOP_SCG_0066GS.do",param );
 					break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
