/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0004.jsp
 *@FileTitle : Segregation Table - Inquiry
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
     * @class vop_scg_0004 : business script for vop_scg_0004 
     */
    function vop_scg_0004() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    } 
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0; 
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var formObject=document.form;          
    	/*******************************************************/
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
     			case "btn_Retrieve":
     				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
 				case "btn_DownExcel":
 					switch(tabIndex) {
 					case 0:
 		                var paramObj=new Object();
 		                paramObj.title="Between Various Classes";
// 	                    paramObj.columnwidth="1:10|2:5|3:5|4:5|5:5|6:5|7:5|8:5|9:5|10:5|11:5|12:5|13:5|14:5|15:5|16:5|17:5|18:5|19:5|20:5|21:5";
 		                paramObj.columnwidth=ComScgGetExcelDown(sheetObject1);
 		                paramObj.cols=ComScgGetExcelDownCols(sheetObject1); 		                
 		                var url=ComScgGetPgmTitle(sheetObject1, paramObj); 
  		                //@@sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
 		                //sheetObject1.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
// 		               sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 		               
 	                    if(sheetObject1.RowCount() < 1){//no data
 	                		  ComShowCodeMessage("COM132501");
 	        	       	}else{
 	        	       		//var pathArr = url.split("?");
 		       	       		var str = sheetObjects[0].GetSearchData(url);
 		       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
 		       	       		sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1,ReportXML:str});
 	        	       	} 		               
 		               
// 	 					sheetObjects[0].Down2Excel();
 						break;
 					case 1:
 		                var paramObj=new Object();
 		                paramObj.title="Within Class 1";
// 	                    paramObj.columnwidth="1:10|2:8|3:8|4:8|5:8|6:8|7:8|8:8|9:8|10:8|11:8|12:8|13:8|14:8";
 	                    paramObj.datarowheight="0:25";
 		                paramObj.columnwidth=ComScgGetExcelDown(sheetObject2);
 		                paramObj.cols=ComScgGetExcelDownCols(sheetObject2); 	                    
 		                var url=ComScgGetPgmTitle(sheetObject2, paramObj); 
  		                //@@sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
// 		               sheetObject2.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
 	                    if(sheetObject2.RowCount() < 1){//no data
 	                		  ComShowCodeMessage("COM132501");
 	        	       	}else{
 	        	       		//var pathArr = url.split("?");
 		       	       		var str = sheetObject2.GetSearchData(url);
 		       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
 		       	       		sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1,ReportXML:str});
 	        	       	}
// 	 					sheetObjects[1].Down2Excel();
 						break;
 					}
 					break;
				case "btns_Numbers&Symbols":
					ComOpenWindowCenter("VOP_SCG_1003_01.do", "VOP_SCG_1003_01", 800, 400, true);
					break;
				case "btns_PermittedMixedStowageOfClass1":
					ComOpenWindowCenter("VOP_SCG_1003_02.do", "VOP_SCG_1003_02", 705, 390, true);
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
    		 //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //
             ComEndConfigSheet(sheetObjects[i]);
         }
    	 resizeSheet();
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);

         }
     
     //no support[check again]CLT function t1sheet1_OnLoadFinish(sheetObj) {
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
         	case 1:      //t1sheet1 init
         		with (sheetObj) {
                
	                var HeadTitle="|Class|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"row_imdg_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_11",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_12",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_15",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_13",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_16",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_14",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_21",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_22",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_23",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_41",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_42",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_43",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:46,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_51",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_52",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_61",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_62",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 } ];
	                 
	                InitColumns(cols);
	                SetSheetHeight(440);
	                SetEditable(0);
	                //SetExtendLastCol(0);
	               
                }
                 break;
         	case 2:      //t2sheet1 init
         		with (sheetObj) {
                
//                (15, 0, 0, true);
                var HeadTitle="|Compatibility\ngrorp|A|B|C|D|E|F|G|H|J|K|L|N|S";

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                       {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"row_imdg_comp_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_a",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_b",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_c",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_d",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_e",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_f",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_g",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_h",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_j",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_k",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_l",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_n",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                       {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_s",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 } ];
                 
                InitColumns(cols);
                SetSheetHeight(410);
                SetEditable(0);
                //SetExtendLastCol(0);
         		}
         		break;
         }
     }
     function resizeSheet(){
	     for (i=0; i<sheetObjects.length; i++){
	         ComResizeSheet(sheetObjects[i]);
	     }
     }

     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      //retrieve
 				formObj.f_cmd.value=SEARCH;
     			var sXml=sheetObj.GetSearchData("VOP_SCG_0004GS.do", FormQueryString(formObj));
    			var arrXml=sXml.split("|$$|");
    			for(var inx=0; inx<arrXml.length; inx++){
    				sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
    			}
    			break;
         }
     }
     /**
      * IBTab Object를 배열로 등록
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
                     InsertItem( "Between Various Classes" , "");
                     InsertItem( "Within Class 1" , "");
                 }
              break;
          }
     }
     /*
     function t1sheet1_OnResize(sheetObj , Width, Height) {
    	//변경된 정보에 따라 컬럼들의 너비를 재조정한다.
    	 sheetObj.SetExtendLastCol(0);
    	 sheetObj.FitColWidth();
    	 sheetObj.SetExtendLastCol(1);
    	}
     function t2sheet1_OnResize(sheetObj , Width, Height) {
     	//변경된 정보에 따라 컬럼들의 너비를 재조정한다.
     	 sheetObj.SetExtendLastCol(0);
     	 sheetObj.FitColWidth();
     	 sheetObj.SetExtendLastCol(1);
     	}
      
     
     function t1sheet1_OnSearchEnd(sheetObj , code , msg){
    	 sheetObj.SetExtendLastCol(0);
    	 sheetObj.FitColWidth();
    	 sheetObj.SetExtendLastCol(1);
     }
     
     function t2sheet1_OnSearchEnd(sheetObj , code , msg){
    	 sheetObj.SetExtendLastCol(0);
    	 sheetObj.FitColWidth();
    	 sheetObj.SetExtendLastCol(1);
     }*/
     /**
      * Related event when clicking Tab
      * selected tab element activates.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
         objs[nItem].style.display="Inline";
         objs[beforetab].style.display="none";
         //--------------- important point --------------------------//
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab=nItem;
         tabIndex=nItem;
         resizeSheet();
         
/*         sheetObjects[nItem].SetExtendLastCol(0);
         sheetObjects[nItem].FitColWidth();
         sheetObjects[nItem].SetExtendLastCol(1);*/
         
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
