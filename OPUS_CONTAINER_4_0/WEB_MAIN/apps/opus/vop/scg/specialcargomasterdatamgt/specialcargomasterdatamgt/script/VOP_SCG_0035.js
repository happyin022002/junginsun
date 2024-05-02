/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0035.jsp
 *@FileTitle : Target Lane for SPCL CGO APVL - Creation
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
     * @class vop_scg_0035 : business script for vop_scg_0035
     */
    function vop_scg_0035() {
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
 var gRow=0;  
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
 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 							break;
 							case "btn_add":						
 								sheetObject.DataInsert(-1);
 								sheetObject.SelectCell( sheetObject.LastRow(),"sheet1_vsl_slan_cd");
 							break;
 							case "btn_insert":
 								sheetObject.DataInsert();
 								sheetObject.SelectCell( sheetObject.GetSelectRow(),"sheet1_vsl_slan_cd");
 							break; 
 							case "btn_delete":
 								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 							break;	
 							case "btn_copy":
 								doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
 							break;	
 							case "btn_save":
 								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
     
      //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
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
                     // setting height
            	 
            	 (6, 0, 0, true);
            	 var HeadTitle="|Sel.|No.|Target Lane|Full Name|Service Type";
            	 var prefix="sheet1_";

            	 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            	              {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:430,  Align:"Left",    ColMerge:1,   SaveName:prefix+"svc_type_name", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	  
            	 InitColumns(cols);
            	 SetEditable(1);
            	 SetShowButtonImage(1);
            	 SetBasicImeMode(2);
            	 SetColProperty(0 ,"sheet1_vsl_slan_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	 //SetSheetHeight(460);
            	 resizeSheet();
                }
                 break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
   // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, cRow, slan_cd) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 					case IBSEARCH:      //retrieve
							formObj.f_cmd.value=SEARCH;
							var aryPrefix=new Array("sheet1_");
                            var param=FormQueryString(formObj) +"&spcl_cgo_rqst_tgt_lane_flg=Y" +"&" + ComGetPrefixParam( aryPrefix );
 							var sXml=sheetObj.GetSearchData("VOP_SCG_0035GS.do", param);
							sheetObj.RenderSheet(0);
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							sheetObj.RenderSheet(1);
 					break;
					case IBDELETE:      // delete
						if (sheetObj.id == 'sheet1') {   
							 ComRowHideDelete(sheetObj, "sheet1_del_chk");
				   	   	}
					break;
					case IBSAVE:        //save
						if(!validateForm(sheetObj,formObj,sAction)){
							return;
						}
						formObj.f_cmd.value=MULTI;	
						var sParam=ComGetSaveString(sheetObjects);
					    if (sParam == "") return;
					    sParam += "&" + FormQueryString(formObj);
						var aryPrefix=new Array("sheet1_");
 					    var sXml=sheetObj.GetSaveData("VOP_SCG_0035GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
 					    sheetObj.LoadSaveData(sXml);
	                break;
					case IBINSERT:      // insert				
					    break;
					case IBCOPYROW:	 
					    if (sheetObj.id == "sheet1") {
						    var row=sheetObj.DataCopy();
						    sheetObj.SetRowStatus(row,"I");
					    }; 
					break;	
					case IBSEARCH_ASYNC01:	 
						 formObj.f_cmd.value=SEARCH01;
						 var aryPrefix=new Array("sheet1_");
 				 		 var sXml=sheetObj.GetSearchData("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+slan_cd+"&tml_prod_rpt_flg=&" + ComGetPrefixParam( aryPrefix ) );
				     	 var VslSlanCd_info=ComGetEtcData(sXml,"VslSlanCd"); 
				     	 if( VslSlanCd_info != ""){
				     		 var aVslSlanCd_info=VslSlanCd_info.split("|");
				     		 sheetObj.SetCellValue( cRow,"sheet1_svc_type_name",aVslSlanCd_info[2],0);
				     	 }
					break;	
         }
     }
     /** 
      * Sheet vsl_slan_cd info retrieve <br>
      * @param
      * @return
      * @author
      * @version
      */  
     function sheet1_OnChange(sheetObj, row, col) {
    	 if( sheetObj.ColSaveName(col) == "sheet1_vsl_slan_cd" ){
    		 if( sheetObj.GetCellValue(row,col).length != 3 ){
    	    	 ComShowCodeMessage("SCG50006", "Lane Code", "3");	
    	    	 sheetObj.SelectCell(row, "sheet1_vsl_slan_cd");
    	    	 return;
			 }    		 
    		 getVslSlanCd(sheetObj, row, col );
    	 }
     }
     /** 
     * Sheet vsl_slan_cd info retrieve <br>
     * @param 
     * @return 
     * @author 
     * @version 
     */  
    function getVslSlanCd(sheetObj, row, col) {
    	var vsl_slan_cd=sheetObj.GetCellValue(row,"sheet1_vsl_slan_cd");
         document.form.f_cmd.value=SEARCH01;
		 var aryPrefix=new Array("sheet1_");
  		 var sXml=sheetObj.GetSearchData("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+vsl_slan_cd+"&tml_prod_rpt_flg="+"&" + ComGetPrefixParam( aryPrefix ) );
     	 var VslSlanCd_info=ComGetEtcData(sXml,"VslSlanCd");   
	     var msg=ComScgGetMessageFromXml(sXml); 	
	     if( msg != "" ){
	    	ComShowMessage(msg);
	    	sheetObj.SetCellValue( row, "sheet1_vsl_slan_cd","",0);
	    	sheetObj.SelectCell( row, "sheet1_vsl_slan_cd", 1) ;
	    	return; 
	     }     	 
     	 setVslSlanCd(row, VslSlanCd_info);
    }
     /** 
      * VslSlanCd result handling  <br>
      * @param 
      * @return 
      * @author
      * @version
      */  
 	function setVslSlanCd(cRow, VslSlanCd_info) {
   	   var sheetObject=sheetObjects[0];
   	   var aVslSlanCd_info=VslSlanCd_info.split("|");
 	   sheetObject.SetCellValue(cRow,"sheet1_vsl_slan_cd",aVslSlanCd_info[0],0);
 	   sheetObject.SetCellValue(cRow,"sheet1_vsl_slan_nm",aVslSlanCd_info[1],0);
 	   sheetObject.SetCellValue(cRow,"sheet1_svc_type_name",aVslSlanCd_info[2],0);
 	   if( aVslSlanCd_info != 0 ){
 	      // sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
 	   }
 	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
               switch (sAction) {
                   case IBSAVE : 
						var Row=sheetObj.ColValueDup("sheet1_vsl_slan_cd",false);
						if( Row != -1){
            	    		 ComShowCodeMessage("SCG50005","Data");
							 //sheetObj.SelectRow = Row;
	            	    	 sheetObj.SelectCell(Row, "sheet1_vsl_slan_cd");
							 return false;
						}
	                     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
	                         return false;   
	                     }
				   break;
               }            	    	 
         }
         return true;
     }
 		function sheet1_OnPopupClick(sheetObj, Row, Col)
 		{
 			with(sheetObj)
 			{
 				var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
 	            gRow=Row;
 	           ComOpenPopup(sUrl, 458, 470, "getSlanCdData", "0,0", true);
// 				ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 426, 475, "setVslSlanCdPopup", "0,0", true, false, Row, Col, 0);
 	 		}
 		}
 		
 		function getSlanCdData(obj){
 			if(obj){
 				var rtnDatas=obj[0];
 				
 				if(rtnDatas){
 					if(rtnDatas.length > 0){
// 						document.form.vsl_slan_cd.value= rtnDatas[1];
 						var sheetObject=sheetObjects[0];
 						sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_cd",rtnDatas[1]);
 						doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, rtnDatas[1] );
 						gRow=0;
 					}
 				}
 			}
 		}
 		
//		function getSlanCdData(obj){
//			if(obj){
//				var rtnDatas=obj;
//				
//				if(rtnDatas){
//					if(rtnDatas.length > 0){
//					   var sheetObject=sheetObjects[0];
//					   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_cd",rtnDatas);
////					   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_cd",aryPopupData[0][1],0);
////					   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_nm"    ,aryPopupData[0][2],0);
////					   sheetObject.SetCellValue(gRow,"sheet1_vsl_svc_tp_cd"  ,aryPopupData[0][3],0);
////					   sheetObject.SelectCell(gRow, "sheet1_vsl_slan_cd");
//					   doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, rtnDatas );
//					   gRow=0;
//						//document.form.vsl_slan_cd.value= rtnDatas;
//					}
//				}
//			}
//		} 		
     /** 
      * Setting value selected from VslSlanCd pop-up. <br>
      * @param  
      * @return 
      * @author 
      * @version
      */       
     function setVslSlanCdPopup(aryPopupData){
	   var sheetObject=sheetObjects[0];
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_cd",aryPopupData[0][1],0);
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_slan_nm"    ,aryPopupData[0][2],0);
	   sheetObject.SetCellValue(gRow,"sheet1_vsl_svc_tp_cd"  ,aryPopupData[0][3],0);
	   sheetObject.SelectCell(gRow, "sheet1_vsl_slan_cd");
	   doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][1] );
	   gRow=0;
     }  		
