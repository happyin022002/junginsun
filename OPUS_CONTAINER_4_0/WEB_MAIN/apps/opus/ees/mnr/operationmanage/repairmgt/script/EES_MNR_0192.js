/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0192.js
*@FileTitle  : Repair Estimate Creation Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0192 : business script for EES_MNR_0192.
     */
/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var DLCSheets=new Array();
var DLCSheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//IBSAVE/IBBATCH
var saveType="";
var combo1;
//retrieve whether or not
var selCheck=false;
//for component code
var retCompArray=new Array();

//file sequence variable
var uploadFileSeq="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCHAPPEND);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
					break;
				case "btn_Request":
					doActionIBSheet(sheetObjects[1],formObject,IBCREATE);
					break;
				case "btn_RowDel":
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
					break;
				case "btn_DownExcel":
 					if(sheetObjects[1].RowCount() < 1){//no data	
 						ComShowCodeMessage("COM132501");
 					}else{	
 						sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
 					}
					break;
				case "btn_FileAdd":
					file_Insert(sheetObjects[10]);
					break;
				case "btn_FileDel":
					file_Remove(sheetObjects[10]);
					break;
			 	case "btns_calendar":
                	var cal=new ComCalendar();
                	cal.select(formObject.eq_dmg_dt, 'yyyy-MM-dd');
                	break;
				//yard popup up
				case "btns_popup":
                    ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 450, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
				//EQ_INFO DETAIL
				case "btn_detail":
					if(formObject.rqst_eq_no.value != ""){
						var paramOption = "eq_no=" + formObject.rqst_eq_no.value + "&mnr_wo_tp_cd=EST";
						ComOpenPopup("/opuscntr/EES_MNR_0191.do?" + paramOption, 901, 495, "", "1,0,1,1,1,1,1,1,1,1,1,1", true);
					}
                    break;
				case "btns_mvmt":
					openPopupMVMT();
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
     * 
     */
    function openPopupMVMT(){
    	  var formObj = document.form;
          var cnmv_dt = ComGetNowInfo("ymd"); //formObj.cnmv_dt.value;
          ComOpenPopupWithTarget("/opuscntr/EES_CTM_0408_POP.do?" +
                  "p_cntrno=" + formObj.rqst_eq_no.value.substr(0,10)+ "&" +
                  "check_digit=" + formObj.rqst_eq_no.value.substr(10,11) + "&" +
                  "ctnr_tpsz_cd=" + formObj.eq_tpsz_cd.value + "&" +
                  "p_date1=" + ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
                  "p_date2=" + ComGetDateAdd(cnmv_dt, "M", 0, "-", true), 1020, 682, "", "0,1", false);
          
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		initControl();
		//'0 ' is For the hidden data retrieval
	//	initSheet(sheetObjects[0],1);
		ComOpenWait(true);
		t1sheet1.SetWaitImageVisible(0);
		
		setTimeout( function () {
			DLCSheetCnt=0;
	        for(i=1;i < sheetObjects.length;i++){
	    			//
					ComConfigSheet (sheetObjects[i]);
					initSheet(sheetObjects[i],i + 1);
					//
					ComEndConfigSheet(sheetObjects[i]);
					if(sheetObjects[i].id.substring(0,2) == "t2" && sheetObjects[i].id != "t2_sheet8"){
						DLCSheets[DLCSheetCnt++]=sheetObjects[i];
					}
	        }
			for(k=0;k < tabObjects.length;k++){
				initTab(tabObjects[k],k + 1);
				tabObjects[k].SetSelectedIndex(0);
			}
			for(k=0;k < comboObjects.length;k++){
	            initCombo(comboObjects[k],k + 1);
	        }
			//ComConfigUpload(uploadObjects[0], "/opuscntr/MNR_INTGS.do");  // mark  check upload
			
			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
			doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);
			t1sheet1_OnLoadFinish(t1sheet1);

			t1sheet1.SetWaitImageVisible(1);
			ComOpenWait(false);

		} , 2000);

    }
	/**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}
	/**
	 * initializing Tab
	 * setting Tab items.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
				case 1:
					with (tabObj) {
						var cnt=0 ;
						InsertItem( "Repair Info." , "");
						InsertItem( "Image Info." , "");
					}
					break;
		}
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	
	var leftHeaders = [{Text:"H|T|B|G", Align:"Center"}];
	var leftHeaders2= [{Text: "L|R", Align:"Center"}];
	
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":
                with (sheetObj) {
                    //setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}
				break;
			case "t1sheet1":      // sheet1 init
			    with(sheetObj){
			      var HeadTitle1="|Sel|Seq.|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option|Cost Code|Cost Code Name|Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Verify Result|Tariff Labor|Tariff Labor|Tariff Labor|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|TPB Labor|TPB Labor|TPB Labor|TPB Material|TPB Amount";
			      var HeadTitle2="|Sel|Seq.|Location|Component|Damage|Repair|Division|Cost Code|Cost Code Name|Type|QTY|Size/Square|Hour|Rate|Cost|Material|Amount|Verify Result|Hour|Rate|Cost|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|Hour|Rate|Cost|TPB Material|TPB Amount";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_dmg_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:1,   SaveName:"cost_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"cost_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_rt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lbr_cost_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_hrs",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_rt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lbr_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lbr_mtrl_bzc_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_agmt_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"CheckBox",  Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"mnr_lr_acct_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_hrs",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_rt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_mtrl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_loc_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_cmpo_cd_chk_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_dmg_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_rpr_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cost_dtl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rpr_dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetEditableColorDiff(1);
			      SetColFontColor("Component","#FF0000");
			      SetSelectionMode(smSelectionRow);
			      InitComboNoMatchText(true);
			      SetShowButtonImage(2);
			      SetSheetHeight(260);
		      }


				break;
            case "t2_sheet1":
            case "t2_sheet2":
                with(sheetObj){
		              var HeadTitle1="";
		              if(sheetObj.id == 't2_sheet1')
		            	  HeadTitle1="|1|2|3|4";
		              else
		            	  HeadTitle1="|4|3|2|1";

		              var RowText="H|T|B|G";
		              var RowVals=RowText.split("|");
		              var widthVals=new Array(30,30,30,30);
		              var ColVals=HeadTitle1.split("|");

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
		              for(var i=0; i < 4 ; i++){
		                    //for(var j=1 ; j < 5 ; j++){
		            	  cols.push({Type:"CheckBox",  Hidden:0, Width:20,Align:"Center",  ColMerge:1,   SaveName:"DLC" });
	                    	
		              }
		              
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetEditable(0);
		              SetSelectionMode(smSelectionCol);
		              SetSheetHeight(132);
		              SetSheetWidth(110);
		              InitHeadColumn(leftHeaders,sheetObj);
		              SetFocusAfterProcess(0);
            }				
            break;
            
            case "t2_sheet3":
            case "t2_sheet4":
                with(sheetObj){
	              var HeadTitle1="";
	              if(sheetObj.id == 't2_sheet3')
	            	  HeadTitle1="|0|9|8|7|6|5|4|3|2|1";
	              else
	            	  HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="H|T|B|G";
	              var RowVals=RowText.split("|");
	              var widthVals=new Array(30,30,30,30);
	              var ColVals=HeadTitle1.split("|");
	              
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:0 } );
	          	
	          	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
	          	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          	  InitHeaders(headers, info);
	
	          	  var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
	              for(var i=0; i < 10 ; i++){	
	                  //for(var j=1 ; j < 11 ; j++){
	                	  cols.push({Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"DLC" });
	                  //}	              
	              }
	              InitColumns(cols);
	          		
	              SetEditable(0);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetCountPosition(0);
	              SetSelectionMode(smSelectionCol);
	              SetSheetHeight(132);
	              InitHeadColumn(leftHeaders,sheetObj);
	              SetFocusAfterProcess(0);
	            }
				break;
            case "t2_sheet5":
            case "t2_sheet6":
            case "t2_sheet7":
            	 with(sheetObj){
	              var HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="L|R";
	              var RowVals=RowText.split("|");
	              var ColVals=HeadTitle1.split("|");
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	      		
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
	              for(var i=0; i < 10 ; i++){
	                    //for(var j=1 ; j < 11 ; j++){
	                    	cols.push({Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"DLC" });
	                    //}
	                    
                }
	              InitColumns(cols);
	      		
	              SetEditable(0);
	              SetSheetHeight(80);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetSelectionMode(smSelectionCol);
	              SetCountPosition(0);
	              InitHeadColumn(leftHeaders2,sheetObj);
	              SetFocusAfterProcess(0);
              }
					break;
				//file upload
			    case "t2_sheet8" :
			    	  with(sheetObj){
					       var prefix="";
					       var HeadTitle1="|Photo Attachment|Photo Attachment|Photo Attachment";
					       var HeadTitle2="|Seq|File|Download";
					       var headCount=ComCountHeadTitle(HeadTitle1);
					       (8, 0, 0, true);
		
					       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
					       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					       var headers = [ { Text:HeadTitle1, Align:"Center"},
					                     { Text:HeadTitle2, Align:"Center"} ];
					       InitHeaders(headers, info);
		
					       var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
					                 {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					        
					       InitColumns(cols);
		
					       SetEditable(0);
					       SetImageList(0,"img/ico_attach.gif");
					       SetShowButtonImage(1);
					       SetSheetHeight(260);
			       }
					break;
        }
    }
	// handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBROWSEARCH:      //retrieving detail
                 if(validateForm(sheetObj,formObj,sAction)){
				 		//showing EQ detail
						setEqInfo(sheetObj,formObj.eq_knd_cd.value,formObj.rqst_eq_no.value,ComGetNowInfo("ymd"));
						//retrieving
					 	formObj.f_cmd.value=SEARCH01;
					    sParam=FormQueryString(formObj);
 					    var sXml=sheetObj.GetSaveData("EES_MNR_0192GS.do", sParam);
					    sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
 						sheetObjects[1].SetSumText(0,"eq_loc_cd","TOTAL");
						//setting form
 						ComSetObjValue(formObj.mvmt_dt, ComGetEtcData(sXml, "mvmt_dt"));
						ComSetObjValue(formObj.rpr_rqst_seq, ComGetEtcData(sXml, "rpr_rqst_seq"));
						ComSetObjValue(formObj.rpr_rqst_ver_no, ComGetEtcData(sXml, "rpr_rqst_ver_no"));
						ComSetObjValue(formObj.rpr_sts_cd, ComGetEtcData(sXml, "rpr_sts_cd"));
						ComSetObjValue(formObj.rqst_ref_no, ComGetEtcData(sXml, "rqst_ref_no"));
						ComSetObjValue(formObj.rpr_yd_cd, ComGetEtcData(sXml, "rpr_yd_cd"));
						ComSetObjValue(formObj.eq_dmg_dt, ComGetEtcData(sXml, "eq_dmg_dt"));
						ComSetObjValue(formObj.rqst_usr_nm, ComGetEtcData(sXml, "rqst_usr_nm"));
						ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml, "rqst_usr_id"));
						ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml, "rqst_dt"));
						ComSetObjValue(formObj.mnr_rpr_rmk, ComGetEtcData(sXml, "mnr_rpr_rmk"));
						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
						ComSetObjValue(formObj.cost_ofc_cd, ComGetEtcData(sXml, "cost_ofc_cd"));
						//retrieving Service Provider Name
						if(formObj.vndr_seq.value != ""){
							var sCondition=new Array (
								new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
							)
							//setting in case of existing retrieving result
							var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
							if(comboList[0] != null){
								var tempText=comboList[0][0].split("|");
								formObj.vndr_nm.value=tempText[1];
							}
						}
						rpr_wrk_tp_cd.SetSelectCode(ComGetEtcData(sXml, "rpr_wrk_tp_cd"));
						if(ComGetEtcData(sXml, "rpr_offh_flg") == 'Y'){
							formObj.rpr_offh_flg.value='Y';
							formObj.rpr_offh_flg_temp.checked=true;
						} else {
							formObj.rpr_offh_flg.value='N';
							formObj.rpr_offh_flg_temp.checked=false;
						}
						//retrieving file list
						var fileSeq=ComGetEtcData(sXml, "file_seq");
						if(fileSeq != "" && fileSeq != null){
							var fileXml=SearchFileUpload(sheetObjects[2],fileSeq);
							if(!MnrIsEmptyXml(fileXml)){
								sheetObjects[9].LoadSearchData(fileXml,{Sync:1} );
							}
						}
				  }
                break;
			 case IBCLEAR:      //initializing
			 	ComBtnDisable("btn_calc");
			 	ComBtnDisable("btn_RowAdd");
			 	ComBtnDisable("btn_RowDel");
			    //adding for notice 	(3 months 6 months)
				var recentRprTpCd=ComGetObjValue(formObj.recent_rpr_tp_cd);
				if(recentRprTpCd == '3'){
					ComSetObjValue(formObj.notice,ComGetMsg("MNR00258"));
				} else if(recentRprTpCd == '6'){
					ComSetObjValue(formObj.notice,ComGetMsg("MNR00259"));
				} else {
					ComSetObjValue(formObj.notice,"");
				}
				uploadFileSeq="";
				// initializing form
				setEqInfoClear();
				// Each
				MnrFormSetReadOnly(formObj,true,"rqst_eq_no|rqst_ref_no|rpr_yd_cd|eq_dmg_dt");
				//initializing sheet
				sheetObjects[1].RemoveAll();
 				sheetObjects[1].SetSumText(0,"eq_loc_cd","TOTAL");
				//initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				rpr_wrk_tp_cd.SetEnable(false);
				// setting values on combo data
				sCondition=new Array (
					//Multil Combo
					new Array("MnrGenCd","CD00018", "COMMON"),
					//Sheet  Combo
					new Array("MnrGenCd","CD00013", "COMMON"),	//Type
					new Array("MnrGenCd","CD00004", "COMMON")	//Error code
				)
				comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//Repair Work Type Code
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						rpr_wrk_tp_cd.InsertItem(0, tempText[1] ,tempText[0]);
					}
				}
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault=new Array();
				var comboSaveNames=new Array();
				comboSaveNames[0]="vol_tp_cd";
				comboSaveNames[1]="mnr_vrfy_tp_cd";
				for(var i=1; i < comboList.length;i++){
				 	if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j == 0){
								sheetComboDefault[i - 1]=tempText[0];
							}
						}
						sheetComboCode=MnrDelLastDelim(sheetComboCode);
				     	sheetComboText=MnrDelLastDelim(sheetComboText);
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 1], sheetComboText, sheetComboCode ,sheetComboDefault[i - 1]);
					}
				}
				break;
		}
    }
	/**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBROWSEARCH:
					if (!ComChkValid(formObj)){
						return false;
					} else {
						return true;
					}
				 	break;
			}
		}
        return true;
    }
	//************************* EVENT SECTION ************************//
    function t1sheet1_OnLoadFinish(sheetObj) {
    	var sXml=MnrWarrantyAlertInfo(sheetObj,document.form.rqst_eq_no.value);
		if(!MnrIsEmptyXml(sXml)){
			document.getElementById("Warranty").innerHTML="Y";
		} else {
			document.getElementById("Warranty").innerHTML="N";
		}
	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items.
	 */
	function tab1_OnChange(tabObj , nItem){
		if(ComGetObjValue(form.eq_knd_cd) == "U"){
			<!-- linked value between tab (S) -->
			// deleting in case of not existing values
			var tDmgLocCd="";
			for(var i=2;i < sheetObjects[1].LastRow();i++ ){
				var checkCompCd=sheetObjects[1].GetCellValue(i,"eq_loc_cd");
				tDmgLocCd += checkCompCd + "/";
			}
			tDmgLocCd=MnrDelLastDelim(tDmgLocCd);
			ComSetObjValue(form.damageLocationCode, tDmgLocCd);
			// deleting
			for(i=0;i < DLCSheets.length;i++){
				for(j=1;j <= DLCSheets[i].LastRow();j++){
					for(k=1;k <= DLCSheets[i].LastCol();k++){
						DLCSheets[i].SetCellValue(j,k,"0",0);
						var RowText = "";
						var HeadTitle = "";
						var DLCText = "";
						switch(DLCSheets[i].id){
							case "t2_sheet1":
								RowText="H|T|B|G";
								HeadTitle="|1|2|3|4";
								DLCText = "D";
					            break;
					            
							case "t2_sheet2":
								RowText="H|T|B|G";
								HeadTitle="|4|3|2|1";
								DLCText = "F";
								break;
								
							case "t2_sheet3":
								RowText = "H|T|B|G";
								HeadTitle = "|0|9|8|7|6|5|4|3|2|1";
								DLCText = "L";
								break;
								
							case "t2_sheet4":
								RowText = "H|T|B|G";
								HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
								DLCText = "R";
								break;
								
							case "t2_sheet5":
								RowText = "L|R";
								HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
								DLCText = "T";
								break;
								
							case "t2_sheet6":
								RowText = "L|R";
								HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
								DLCText = "B";
								break;
								
							case "t2_sheet7":
								RowText = "L|R";
								HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
								DLCText = "U";
								break;
								
						}
						var RowVals=RowText.split("|");
			            var ColVals = HeadTitle.split("|");
						DLCSheets[i].SetToolTipText(j,k, DLCText+ RowVals[j-1] + ColVals[k]);
					}
				}
			}
			setDLC();
			<!-- linked value between tab (E) -->
		}
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	function setDLC()
    {
		//DLCs = BL10,ABNN
    	var DLCs=ComGetObjValue(form.damageLocationCode).split("/");
    	var SheetChar="DFLRTBU";
        for(i=0;i < DLCs.length;i++){
    		if(SheetChar.indexOf(DLCs[i].charAt(0)) != -1){
				checkDLC(DLCSheets[SheetChar.indexOf(DLCs[i].charAt(0))], DLCs[i]);
			}
    	}
    }
    function checkDLC(sheetObj, DLC)
    {
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			for(var j=1 ; j <= LastCol();j++){
					if(GetToolTipText(i,j).substring(0,3) == DLC.substring(0,3)){
						if(DLC.charAt(3) == 'N'){
							SetCellValue(i,j,"1",0);
							sheetObj.SetCellBackColor(i,j,"#F7E5E1");
						} else {
							var len=Math.abs(parseInt(DLC.charAt(3)) - parseInt(DLC.charAt(2)));
							if(GetToolTipText(i,j).substring(0,1) == "L" || GetToolTipText(i,j).substring(0,1) == "F"){
								if(DLC.substring(3,4) == "0"){
									var lflen=(10 - parseInt(DLC.charAt(2)));
									for(var k=0; k <= lflen ; k++){
										SetCellValue(i,1 + k,"1",0);
										sheetObj.SetCellBackColor(i,1 + k,"#F7E5E1");
									}
								} else 	{
									for(var k=0; k <= len ; k++){
										SetCellValue(i,j - k,"1",0);
										sheetObj.SetCellBackColor(i,j - k,"#F7E5E1");
									}
								}
							} else {
								if(DLC.substring(3,4) == "0"){
									var lflen=(10 - parseInt(DLC.charAt(2)));
									for(var k=0; k <= lflen ; k++){
										SetCellValue(i,j + k,"1",0);
										sheetObj.SetCellBackColor(i,j + k,"#F7E5E1");
									}
								} else {
									for(var k=0; k <= len ; k++){
										SetCellValue(i,j + k,"1",0);
										sheetObj.SetCellBackColor(i,j + k,"#F7E5E1");
									}
								}
							}
						}
					}
    			}
    		}
    	}
    }
    function getDLC(sheetObj)
    {
    	var DLC="";
    	var startPoint=0;
    	var endPoint=0;
    	var cont=true;
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			startPoint=0;
    			for(var j=1 ; j <= LastCol();j++){
    				startPoint=0;
    				if(GetCellValue(i,j) == '1'){
    					if(GetCellValue(i,j + 1) == '1'){
							startPoint=j;
							do {
					          endPoint=j;
					          j++;
							} while (GetCellValue(i,j) == '1' && j <= LastCol());
							if(GetToolTipText(i,j - 1).substring(0,1) == "L" || GetToolTipText(i,j - 1).substring(0,1) == "F"){
								DLC += "/"+GetToolTipText(i,j - 1).substring(0,2) + GetToolTipText(i,endPoint).substring(2,3) + GetToolTipText(i,startPoint).substring(2,3);
							} else {
								DLC += "/"+GetToolTipText(i,j - 1).substring(0,2) + GetToolTipText(i,startPoint).substring(2,3) + GetToolTipText(i,endPoint).substring(2,3);
							}
						}else{
							DLC += "/"+GetToolTipText(i,j) + "N";
						}
					}
    			}
    		}
    	}
    	return DLC;
    }
    function contCheck(sheetObj, Row, Col)
    {
    	var point="";
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			var firstFlag=0;
    			for(var j=1 ; j <= LastCol();j++){
    				if(GetCellValue(i,j) == '1'){
    					if(GetCellValue(i,j + 1) == '1'){
						}else{
							point += "|"+GetToolTipText(i,j)+"N";
						}
					}
    			}
    		}
    	}
    }
	function t2_sheet1_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet2_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet3_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet4_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet5_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet6_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	function t2_sheet7_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Col     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @param {String} 	Value     	file name
     **/
	function t2_sheet8_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(saveType == "REMOVE"){
				ComShowCodeMessage("MNR00020");
			} else if(saveType == "REQUEST") {
				ComShowCodeMessage("MNR00055");
			} else {
				ComShowCodeMessage("MNR00023");
			}
		} else {
			// showing message after deleting
			if(saveType == "REMOVE"){
				ComShowCodeMessage("MNR00027",ErrMsg);
			//REQUEST
			} else if(saveType == "REQUEST") {
				ComShowCodeMessage("MNR00008",ErrMsg);
			// showing message after saving
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
	}
	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){
		for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
			var mnrVrfyTpCd=sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd");
			if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
 				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#0000FF");
			} else {
 				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#FF0000");
			}
		}
	}
	
	// showing message after varifying
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
				var mnrVrfyTpCd=sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd");
				if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
 					sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#0000FF");
				} else {
 					sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#FF0000");
				}
			}
			ComShowCodeMessage("MNR00334");
		} else {
				ComShowCodeMessage("MNR00159",ErrMsg);
		}
	}
	//************************* EVENT SECTION ************************//
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,isYardDisplay){
		var formObj=document.form;
		var sCostType="";
		if(formObj.eq_knd_cd.value == "U"){
			sCostType="MRDRRC";
		} else if(formObj.eq_knd_cd.value == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){
			
			//rpr_dt (in case of rpr_type = retArr[0][30] is equal to EST
			var tagObj=document.getElementById("Repair");
			if(MnrNullToBlank(retArr[0][30]) == 'EST'){
				tagObj.innerHTML=retArr[0][32];
			}
			//imm_ext
			tagObj=document.getElementById("ImmExit");
			tagObj.innerHTML=retArr[0][0];
			//off_hire
			tagObj=document.getElementById("OffHire");
			tagObj.innerHTML=retArr[0][12];
			//dsp_flag
			tagObj=document.getElementById("Disposal");
			tagObj.innerHTML=retArr[0][14];
			//DPP&nbsp
			tagObj=document.getElementById("DPP");
			if(retArr[0][35] != null && retArr[0][35] != ""){
				tagObj.innerHTML=ComAddCommaRun(retArr[0][35]);
			} else {
				tagObj.innerHTML=retArr[0][35];
			}
			//DvValue
			tagObj=document.getElementById("DvValue");
			if(retArr[0][10] != null && retArr[0][10] != ""){
				tagObj.innerHTML=ComAddCommaRun(retArr[0][10]);
			} else {
				tagObj.innerHTML=retArr[0][10];
			}
			//manu_dt
			tagObj=document.getElementById("ManuDt");
			tagObj.innerHTML=retArr[0][7];
			//eq_tpsz_cd
			tagObj=document.getElementById("TpSz");
			tagObj.innerHTML=retArr[0][31];
			formObj.eq_tpsz_cd.value=retArr[0][31];
			//lstm_cd
			tagObj=document.getElementById("Term");
			tagObj.innerHTML=retArr[0][19];
			//lessor_nm
			tagObj=document.getElementById("Lessor");
			tagObj.innerHTML=retArr[0][16];
			//Warranty
			tagObj=document.getElementById("Warranty");
			tagObj.innerHTML='';
			//crnt_yd_cd
			if(isYardDisplay == true){
				ComSetObjValue(formObj.rpr_yd_cd,retArr[0][18]);
			}
		} else {
			document.getElementById("Repair").innerHTML="";
			document.getElementById("ImmExit").innerHTML="";
			document.getElementById("OffHire").innerHTML="";
			document.getElementById("Disposal").innerHTML="";
			document.getElementById("DPP").innerHTML="";
			document.getElementById("DvValue").innerHTML="";
			document.getElementById("ManuDt").innerHTML="";
			document.getElementById("TpSz").innerHTML="";
			document.getElementById("Term").innerHTML="";
			document.getElementById("Lessor").innerHTML="";
			document.getElementById("Warranty").innerHTML="";
			document.getElementById("Repair").innerHTML="";
			if(isYardDisplay == true){
				ComSetObjValue(formObj.rpr_yd_cd,"");
			}
		}
	}
	function setEqInfoClear(){
			document.getElementById("Repair").innerHTML="";
			document.getElementById("ImmExit").innerHTML="";
			document.getElementById("OffHire").innerHTML="";
			document.getElementById("Disposal").innerHTML="";
			document.getElementById("DPP").innerHTML="";
			document.getElementById("DvValue").innerHTML="";
			document.getElementById("ManuDt").innerHTML="";
			document.getElementById("TpSz").innerHTML="";
			document.getElementById("Term").innerHTML="";
			document.getElementById("Lessor").innerHTML="";
			document.getElementById("Warranty").innerHTML="";
			document.getElementById("Repair").innerHTML="";
	}
	/**
	 * COM_ENS_061 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")
    	 	formObj.rpr_yd_cd.value=aryPopupData[0][3];
    }
	//setting DESC
	function t1sheet1_OnClick(sheetObj,Row, Col, Value) {
		var formObj=document.form;
formObj.mnr_desc.value=sheetObj.GetCellValue(Row ,"rpr_dtl_rmk");
	}
	function initControl() {
	    //Axon handling event1. event catch
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
	}
	//Axon handling event2. handling event
	function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	}
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	function obj_change(){
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "rqst_eq_no":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "rqst_eq_no":
					setEqInfoClear();
				   	break;
			}
		}
	}
	
	
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "int":
//				ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//				break;
//	        case "engup":
//				ComKeyOnlyAlphabet('uppernum');
//	            break;
//	    }
//	}
	/* developer job */
