/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0727.js
*@FileTitle  : BDR Booking No Status - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0727 : business script for ESM_BKG_0727
     */
    function ESM_BKG_0727() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
             switch(srcName) {
					case "btn_print":
						goPrint();
					break;
					case "btn_close":
  ComClosePopup(); 
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
 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      /**
       * setting sheet initial values and header
       * @param sheetObj
       * @param sheetNo
       * @return
       */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with(sheetObj){
	              var HeadTitle1="|Seq|Booking No|B/L No|POL|POD|RLY|T/VVD|Pre VVD|STS|BDR";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	                  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"t_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"p_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetSheetHeight(150);
                  }
                  break;
         }
     }
     /**
      * handling sheet process
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return void
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					 formObj.f_cmd.value=SEARCH;
					 sheetObj.DoSearch("ESM_BKG_0727GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
				}
			break;
         }
     }
     // occurring event after retrieve
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
    	var ttl_bdr=0;
     	with(sheetObj){
     		if (LastRow()== 0) return;;
     		for(var i=1; i <= LastRow(); i ++){
if (GetCellValue(i, "bdr_flg") == 'Y'){
     				ttl_bdr++;
     			}
     		}
     		ComSetObjValue(formObj.ttl_bkg,LastRow());
     		ComSetObjValue(formObj.ttl_bdr,ttl_bdr);
     		ComSetObjValue(formObj.non_bdr,LastRow()-ttl_bdr);
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
    /*
  	* RD printer function
  	* @param string
  	*/
     function goPrint(){		
   		var sheetObj=sheetObjects[0];
   		var formObj=document.form;
   		var rdPath="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_5030.mrd";
   		var where="";
   		var param=new Array("vvd_cd","pol_cd","pod_cd");
   		if (param == "" || sheetObj.RowCount()< 1) {
  			ComShowCodeMessage("BKG00495");
  			return false;
  		}
   		where=getParam(param);
   		formObj.com_mrdPath.value=rdPath;
   		formObj.com_mrdArguments.value="/rv "  + where;
   		ComSetObjValue(formObj.com_mrdTitle,"BDR STATUS");
   		ComOpenRDPopup();
   	}
    /*
  	* getting parameter as RD printer passing
  	* @param param
  	* @return rParam
  	*/
      function getParam(param){
      	var formObj=document.form;
      	var rParam="";
      	for(i=0;i<param.length;i++){
      		rParam += param[i]+"["+ComGetObjValue(eval("document.form."+param[i])) + "] ";
      	}
      	return rParam;
      }	
