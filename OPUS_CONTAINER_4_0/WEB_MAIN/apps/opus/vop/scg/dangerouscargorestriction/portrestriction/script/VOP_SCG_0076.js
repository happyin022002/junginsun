/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0076.js
 *@FileTitle : DG Prohibition Summary by Port - Inquiry
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
     * @class VOP_SCG_0076 : business javascript for VOP_SCG_0076 
     */
 // common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0; 
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
                 case "btn_Excel":
                     doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                 break;                                                  
                 case "btn_new":
                     doActionIBSheet(sheetObjects[0],document.form,IBINSERT);   
                 break;
                 case "srch_port_cd":
                 	var port_cd=document.form.port_cd.value; 
                	//@@417->517, 520->530
//                	ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd=' + port_cd, 517, 530, "setPortCd", "0,0", true);
    				var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+port_cd;
            		ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
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
         sheet1_OnLoadFinish(sheet1)
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
      }   
     function initControl() {
         //Axon event handling1. event catch
       var formObj=document.form;
       imdg_clss_cd.SetDropHeight(200);
       axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
       axon_event.addListenerForm('keyup',    'obj_keyup',       form );   
       axon_event.addListenerForm('keyup',    'obj_blur',         form );
       axon_event.addListenerForm ('click',   'obj_click',       form );     
//       axon_event.addListener    ('click',   'img_click',    "srch_port_cd");         
       axon_event.addListener    ('click',   'img_click',    "btn_retrieve");          
       axon_event.addListener    ('click',   'img_click',     "srch_imdg_un_no");
       // Initializing IBMultiCombo
       for(var k=0; k<comboObjects.length; k++){
          initCombo(comboObjects[k], k + 1);
       }
       ComEnableObject( formObj.imdg_un_no, false);
       ComEnableObject( document.all.srch_imdg_un_no, false);
  }
     /**
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
     }      
     /**
      * Initializing Combo
      * Setting Combo items.
      */
     function initCombo(comboObj, comboNo) {
       switch(comboObj.options.id) {
           case "imdg_clss_cd":
               with(comboObj) {
                   SetTitle("Class|Definition");
                   SetColWidth(0, "50");
                   SetColWidth(1, "700");
                   SetDropHeight(190);
                   SetMultiSelect(0);
                   SetMaxSelect(1);
                   SetUseAutoComplete(1);
               }
               break;  
       }
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
	            	 var HeadTitle="Port|Class|AMDT No.|UN No./Seq|UN No./Seq|Registered\non Restriction|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|";
	            	 var HeadTitle1="Port|Class|AMDT No.|UN No./Seq|UN No./Seq|Registered\non Restriction|Load|Discharge|T/S|Pass|Day Time\nOperation|Day Time\nIn-Land Transit|In-port\nOperation|Night Time\nOperation|";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:100} );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"},
	            	                 { Text:HeadTitle1, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"port_cd" },
	            	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"restric_regyn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:79,   Align:"Center",  ColMerge:0,   SaveName:"prohi_lod_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:79,   Align:"Center",  ColMerge:0,   SaveName:"prohi_dchg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:79,   Align:"Center",  ColMerge:0,   SaveName:"prohi_ts_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:79,   Align:"Center",  ColMerge:0,   SaveName:"prohi_pass_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:96,   Align:"Center",  ColMerge:0,   SaveName:"prohi_dy_tm_op_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:96,   Align:"Center",  ColMerge:0,   SaveName:"prohi_dy_tm_inlnd_tz_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:96,   Align:"Center",  ColMerge:0,   SaveName:"prohi_port_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:59,   Align:"Center",  ColMerge:0,   SaveName:"prohi_ngt_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:1, Width:96,   Align:"Center",  ColMerge:0,   SaveName:"unno_exist_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	  
	            	 InitColumns(cols);
	            	 //SetSheetHeight(415);
	            	 resizeSheet();
	            	 SetEditable(0);
	            	 SetRowMerge(1,1);
	            	 SetMergeCell(0, 3, 2, 2);
	            	 SetMergeCell(0, 5, 2, 1);
	            	 SetCellFont("FontBold", 0,1, 0, 4,1);
	            	 SetColHidden("imdg_amdt_no",1)
	            	 SetColHidden("imdg_un_no",1);
	            	 SetColHidden("imdg_un_no_seq",1);
                }
                 break;
         }
     }
     
     function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
   	 }

     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
         	case   IBCLEAR:      //initializing 1. Retrieving Class Combo
         		formObj.f_cmd.value=SEARCH02;      //SEARCH02      searchUNClass       
         		var param=FormQueryString(formObj);
          		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
         		ComXml2ComboItem( sXml, imdg_clss_cd, "imdg_clss_cd","imdg_clss_cd|imdg_clss_cd_desc" );
         		formObj.port_cd.focus();
         		break;
         	case  IBSEARCH:      //retrieve
         		if(!validateForm(sheetObj,formObj,sAction)){return;}
         		formObj.f_cmd.value=SEARCH01;                     
         		var param=FormQueryString(formObj);
          		sheetObj.DoSearch("VOP_SCG_0076GS.do",  param  );
//         		fnSetFont(sheetObj);
         		//UNNO_EXIST_YN
         		break;
         	case    IBSEARCH_ASYNC01:      //Retrieving PORT_NM
         		formObj.f_cmd.value=SEARCH09;
         		var aryPrefix=new Array("sheet1_");
         		var param=FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
          		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
         		var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm
         		var msg=ComScgGetMessageFromXml(sXml);
         		if( msg != "" ){
         			ComShowMessage( msg);
         			formObj.port_cd.value="";
         			formObj.port_cd_nm.value=""; 
         			formObj.port_cd.focus();                               
         		}else{
         			document.form.port_cd_nm.value=port_cd_nm;
         		}
         		break;
         	case IBSEARCH_ASYNC02:  //CheckUnNumber
         		formObj.f_cmd.value=SEARCH01;
         		var param=FormQueryString(formObj) ;
          		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
         		var sTotal=ComScgGetTotalValue(sXml);
         		if( sTotal == "0"){
         			ComShowCodeMessage("SCG50010", 'Data');
         			formObj.imdg_un_no.value="";
         			formObj.imdg_un_no.focus();
         		}
         		break;  
         	case IBDOWNEXCEL:      // delete
         		var paramObj=new Object();
         		paramObj.title="DG Prohibition Summary by Port";
         		if (formObj.optclass[0].checked == true) {
         			paramObj.cols="11";
         			paramObj.columnwidth="1:10|2:10|3:10|4:10|5:10|6:10|7:10|8:12|9:12|10:12|11:12";
         		}else{
         			paramObj.cols="13";
         			paramObj.columnwidth="1:10|2:7|3:7|4:5|5:10|6:10|7:10|8:10|9:10|10:10|11:10|12:10|13:10";
         		}
     			paramObj.datarowheight="1:25";
         		var url=ComScgGetPgmTitle(sheetObj, paramObj);
         		if(sheetObj.RowCount() < 1){//no data
         			ComShowCodeMessage("COM132501");
         		}else{
     				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
     			}
         		break;
         	case IBINSERT:      // insert
         		fnNewGrid();
         		formObj.port_cd.value="";
         		formObj.port_cd_nm.value="";
//         		imdg_clss_cd.SetSelectCode("",false);
         		imdg_clss_cd.SetSelectIndex(-1);
         		formObj.port_cd.focus();       
         		formObj.imdg_un_no.value="";
         		break;
         }
     }
     
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 fnSetFont(sheetObj);
     }
     
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
             switch ( sAction ){
                 case IBSEARCH:
                       if( !ComChkValid(formObj) ){
                           return false;
                       }
            }
            return true;
     }
     function img_click(){
         var obj=ComGetEvent();
         var formObj=document.form;
         /*if(obj.name == "srch_port_cd"){
                 var port_cd=document.form.port_cd.value; 
                  ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setPortNm", "0,0", true);   
         }*/
         if(obj.name == "srch_imdg_un_no"){
             if( obj.className == ""){
                  return;
             }              
             var imdg_un_no=formObj.imdg_un_no.value; 
             ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no,960, 500, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
        }
     }    
     
   	/*
   	 * =====================================================================
   	 * Pop Up Data
   	 * =====================================================================
   	 */
   	/**
   	 * Handling data from Port Code Help (Pop-Up)
   	 * @param rtnObjs
   	 * @return
   	 */
   	function returnPortHelp(rtnObjs){
   		var formObj=document.form;
   		var sheetObj=null;
   		if(rtnObjs){
   			var rtnDatas=rtnObjs;
   			if(rtnDatas){
   				if(rtnDatas.length > 0){
   					formObj.port_cd.value=rtnDatas;
   					doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);
   				}
   			}
   		}
   	}       
     /**
      * Retrieving Unno, seq, ClassCd by Unno Help Popup.
      * @param  {Array} aryPopupData  compulsory   Array Object
      * @param  {Int} row             optional selected Row
      * @param  {Int} col             optional selected Column
      * @param  {Int} sheetIdx        optional Sheet Index
      * @return none
      */  
      function setUnnoAndClassCd(aryPopupData){
          with(document.form){
              imdg_un_no.value=aryPopupData[0][2];              
          }
      }
      
      function setPortCd(aryPopupData){
          with(document.form){
              port_cd.value=aryPopupData[0][2];
              doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);               
          }
      }       
     /**
      * @param  {Array} aryPopupData compulsory   Array Object
      * @return none
      */   
     function setPortNm(aryPopupData){
          var formObject=document.form;
          formObject.port_cd.value=aryPopupData[0][2];
          formObject.port_cd_nm.value=aryPopupData[0][3];            
     }
      /**
       * Handling Object Onkeyup event in form.
       * 
       * @return void
       */     
    function obj_keyup(){
       obj=ComGetEvent();
       var formObj=document.form;
       switch(obj.name ) {
          case "port_cd"://Retrieving prp_shp_nm by inputting Un No or Seq 
               if( formObj.port_cd.value.length  == 5){ 
                   formObj.port_cd_nm.value="";
                   doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);                           
               }else{
                   formObj.port_cd_nm.value="";
                   formObj.imdg_clss_cd.SetSelectCode("",false);
                   fnNewGrid();
               }
               break;
               
          case "imdg_un_no":
              if( formObj.imdg_un_no.value.length == 4){   
            	  //fnNewGrid();
                  doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
              }else{
            	  formObj.imdg_un_no.SetSelectCode("",false);
              }
              break;
       } // end switch
   }   
    
    
   /**
    * Handling Form Object  OnChange event
    * @param  void
    * @return void
    */     
    function obj_click(){
       obj=ComGetEvent();
       var formObj=document.form;
       var doc=document.all;
       switch(obj.name ) {
          case "optclass":
              if(obj.value == "class"){
            	  imdg_clss_cd.SetEnable(1);
                  ComEnableObject( formObj.imdg_un_no, false);
                  ComEnableObject( document.all.srch_imdg_un_no, false);
                  sheetObjects[0].SetColHidden("imdg_amdt_no",1);
                  sheetObjects[0].SetColHidden("imdg_un_no",1);
                  sheetObjects[0].SetColHidden("imdg_un_no_seq",1);
                  fnNewGrid();
              }
              if(obj.value == "unno"){
                  imdg_clss_cd.SetEnable(0);
                  ComEnableObject( formObj.imdg_un_no, true);
                  ComEnableObject( document.all.srch_imdg_un_no, true);
                  formObj.imdg_un_no.focus();
                  sheetObjects[0].SetColHidden("imdg_amdt_no",0);
                  sheetObjects[0].SetColHidden("imdg_un_no",0);
                  sheetObjects[0].SetColHidden("imdg_un_no_seq",0);
                  fnNewGrid()
              }
              imdg_clss_cd.SetSelectCode("",false);
              break;
       } // end switch
    }

    function fnNewGrid(){
       var cnt=sheetObjects[0].RowCount();
       var formObj=document.form;
       for(var j=1;j<= cnt;j++ ){
           sheetObjects[0].RowDelete(2, false);
       } 
   }  

    function fnSetFont(sheetObj){
        for(var i=0;i<sheetObj.RowCount();i++){
        	if( sheetObj.GetCellValue(i+sheetObj.HeaderRows(),"unno_exist_yn") == "Y" ){
                sheetObj.SetCellFontColor( i+sheetObj.HeaderRows(), "imdg_clss_cd","#FF0000");
              //alert( "#FF0000";
                sheetObj.SetCellFont("FontBold", i+sheetObj.HeaderRows(), "imdg_clss_cd",1);	
            }
        } 
   }
