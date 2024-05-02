/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0054.js
*@FileTitle  : LRS SKD Creation(CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var dataStartRow=6;
var dataSetCnt=4;
var bkgVVDs=new Array();
var virVVDs=new Array();
var bkgVirVVDs=new Array();
var nonBkgVVDs=new Array();
var vvdDeleteReason="";
var HeadCol1=""; // SKD_DIR_CD
var HeadCol2=""; // VPS_PORT_CD
var HeadCol3=""; // ETB_DY_CD/ETD_DY_CD
var HeadCol4=""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol5=""; // P/F CLPT_SEQ
var HeadCol6=""; // YARD_CD
var backObj=null;

var sheet1DataRows = 5; // count of rows in sheet1
var sheet1ViewDataRows = 4; // count of shown rows in sheet1\

var sheet1StartDateDataRow=0;
var sheet1VslCdDataRow=1;
var sheet1VoyNoDataRow=2;
var sheet1PfTypeDataRow=3;
var sheet1PfDateDataRow=4; 
var sheet2DirCdHeaderRow=0;
var sheet2VpsPortCdHeaderRow=1;
var sheet2DyCdHeaderRow=2;
var sheet2TmHrmntHeaderRow=3;
var sheet2ClptIndSeqHeaderRow=4;
var sheet2YdCdHeaderRow=5;
var sheet2InitDateRowPos=1;
var sheet2PfDateRowPos=2;
var sheet2StatusRowPos=3;
var sheet1DataRows = 5; // count of rows in sheet1

var vessels=new Array();
var countCallBack=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;


// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btns_search1":
			var sUrl="/opuscntr/VOP_VSK_0202.do";
			ComOpenPopup(sUrl, 500, 470, "getLaneCodeData", "0,0", true);
			 
			break;
		case "btns_calendar1":
			var cal=new ComCalendar();
			cal.select(formObj.end_date, 'yyyy-MM-dd');
			break;
		case "btn_New":
			initPage();
			break;
		case "btn_Save":
			var check=valid(sheetObject1, formObj, "SAVE");
			//alert( " s");
			if(check){
				// VOP_VSK_0249 open. input Booking VVD delete remark
				if(bkgVVDs.length + virVVDs.length + bkgVirVVDs.length > 0){
					var sUrl="/opuscntr/VOP_VSK_0249.do?tp=1";
					for(var i=0; i<bkgVVDs.length; i++){
						sUrl=sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVVDs[i].vslCd + bkgVVDs[i].skdVoyNo + bkgVVDs[i].skdDirCd;
					}
					for(var i=0; i<virVVDs.length; i++){
						sUrl=sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + virVVDs[i].vslSlanCd + "&bkg_vvd=" + virVVDs[i].vslCd + virVVDs[i].skdVoyNo + virVVDs[i].skdDirCd;
					}
					for(var i=0; i<bkgVirVVDs.length; i++){
						sUrl=sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVirVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVirVVDs[i].vslCd + bkgVirVVDs[i].skdVoyNo + bkgVirVVDs[i].skdDirCd;
					}
					var rVal=ComOpenPopupWithTarget(sUrl, 524, 342, "", "0,0", true);
					if(rVal){
						vvdDeleteReason=rVal;
					}else{
						// VOP_VSK_0249 Close
						vvdDeleteReason=null;
					}
				}
				if(vvdDeleteReason!=null){
					
					//alert( " s");
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
				}
			}
			break;
		case "btn_Simulation":
			formObj.op_type.value="btn_Simulation";
			var check=valid(sheetObject1, formObj, "SIMULATION");
			bkgVVDs=new Array();
			virVVDs=new Array();
			bkgVirVVDs=new Array();
			nonBkgVVDs=new Array();
			if(check){
				//var vessels=new Array();
				var sheetObj=sheetObjects[0];
				
				var startDate=ComReplaceStr(sheetObj.GetCellValue(1, "Vsl_1"), "-", "");
				var endDate=ComReplaceStr(formObj.end_date.value, "-", "");
				if(ComChkPeriod(startDate, endDate) < 1){
					ComShowCodeMessage('COM132002');
					return false;
				}
				
				if(!checkPeriod(sheetObj, formObj)){
					ComShowCodeMessage("VSK00105", "2 year");
					return false;
				}
				// Checking voyage per each vessel code0
				var vslCnt = Number(formObj.vsl_cnt.value)+1;
				for(var i=1,k=0; i<vslCnt; i++){
					if(sheetObj.GetCellValue(2, i)!=""){
						var obj=new Object();
						obj.startDate=sheetObj.GetCellValue(1, i);
						obj.vslCd=sheetObj.GetCellValue(2, i);
						obj.skdVoyNo=sheetObj.GetCellValue(3, i);
						obj.voyNo="";
						obj.skdDirCd1="";
						obj.skdDirCd2="";
						obj.duration="";
						vessels[k++]=obj;
					}
				}
				
				countCallBack = 0;
				if(vessels.length > 0){
					var sUrl="/opuscntr/VOP_VSK_0211_POP.do";                                 
					sUrl=sUrl + "?vsl_cd=" + vessels[0].vslCd                                 
								   + "&skd_voy_no=" + vessels[countCallBack].skdVoyNo         
								   + "&start_date=" + vessels[countCallBack].startDate        
								   + "&end_date=" + formObj.end_date.value        
								   + "&vsl_cnt=" + formObj.initVslCnt.value       
								   + "&voy_no_type=0" // NORMAL                   
								   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value   
								   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value   
								   + "&duration=" + formObj.svc_dur_dys.value;    
//					ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);       
					ComOpenPopup(sUrl, 510, 527, "getSimulData", "0,0", true);
					countCallBack++;
				}
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Handling Simulater Pop-up
 * @param rtnObjs
 * @return
 */
function getSimulData(rVal ){
	var formObj = document.form;
	var sUrl="/opuscntr/VOP_VSK_0211_POP.do";
	
	if(vessels.length == countCallBack){
		ComOpenWait(true);
		setTimeout(function(){
			doActionIBSheet(sheet2,formObj,SEARCH02);
        },300);  
	}
	
	if(rVal){
		bkgVVDs = bkgVVDs.concat(rVal.bkgVVDs);
		virVVDs = virVVDs.concat(rVal.virVVDs);
		bkgVirVVDs = bkgVirVVDs.concat(rVal.bkgVirVVDs);
		nonBkgVVDs = nonBkgVVDs.concat(rVal.nonBkgVVDs);
	}
	
	if(vessels.length != countCallBack){
		sUrl=sUrl + "?vsl_cd=" + vessels[countCallBack].vslCd                                 
		   + "&skd_voy_no=" + vessels[countCallBack].skdVoyNo         
		   + "&start_date=" + vessels[countCallBack].startDate        
		   + "&end_date=" + formObj.end_date.value        
		   + "&vsl_cnt=" + formObj.initVslCnt.value       
		   + "&voy_no_type=0" // NORMAL                   
		   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value   
		   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value   
		   + "&duration=" + formObj.svc_dur_dys.value;  
		ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);
		countCallBack++;
	}
}

/**
 * Handling Slan Code Pop-up
 * @param rtnObjs
 * @return
 */
function getLaneCodeData(rtnObjs){
	var formObj=document.form;
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.vsl_slan_cd.value=rtnObjs[0][1];
			}
		}
	}
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	// Setting current year
	var today=new Date();
	var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
	with (formObj) {
		end_date.value=ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
	
	if(formObj.vsl_cnt.value != "0" && formObj.vsl_cnt.value != "") {
		setColHidden(sheetObjects[0], parseInt(formObj.vsl_cnt.value));
	}
}
/** 
 * Initializing screen
 */
function initPage() {
	var formObj=document.form;
	sheetObjects[2].RemoveAll();
    HeadCol1="";
    HeadCol2="";
    HeadCol3="";
    HeadCol4="";
    HeadCol5="";
    HeadCol6="";
    sheetObjects[0] = sheetObjects[0].Reset();
	ComConfigSheet (sheetObjects[0]);
	initSheet(sheetObjects[0],1);
	ComEndConfigSheet(sheetObjects[0]);
	sheetObjects[1] = sheetObjects[1].Reset();
	ComConfigSheet (sheetObjects[1]);
	initSheet(sheetObjects[1],2);
	ComEndConfigSheet(sheetObjects[1]);
	setColHidden(sheetObjects[0],0);
	sheetObjects[0].ViewRows=4;
    formObj.vsl_slan_cd.value="";
	formObj.tmp_vsl_slan_cd.value="";
	formObj.brth_itval_dys.value="";
	formObj.vsl_cnt.value="";
	formObj.initVslCnt.value="";
	formObj.pf_svc_tp_cd.value="";
	formObj.slan_stnd_flg.value="Y";
	
	ComBtnEnable("btn_Simulation");
	ComBtnEnable("btn_Save");
	var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
	with (formObj) {
		end_date.value=ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */

var leftHeaders = [{Text:"Start Date|Vessel Code|Start Voy. No.|P/F SKD Type|Out", Align:"Left"}];
	

function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	var formObj=document.form;
	switch (sheetId) {
	case 'sheet1': // sheet1 init
	    with(sheetObj){
			
		  tabIndex=-1;
	      var HeadTitle1="||||||||||||||||||||";

	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	      var cols = new Array();
	      
	      cols.push( {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0, Focus:0,  SaveName:"left",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } );
          
          for(var i=0 ; i <sheet1DataRows ; i++){
                for ( var j = 1; j < 20; j++) {
		          if (i == sheet1StartDateDataRow) {
		          cols.push({Type:"Date", Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		          } else if (i == sheet1VslCdDataRow) {
		        	  cols.push({Type:"Text",      Hidden:1,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
		          } else if (i == sheet1VoyNoDataRow) {
		        	  cols.push({Type:"Text",      Hidden:1,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
		          } else if (i == sheet1PfTypeDataRow) {
		        	  cols.push({Type:"PopupEdit", Hidden:1, Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
		          }
                }
		  }
          cols.push({Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" });
		   InitColumns(cols);
          
          SetImageList(0,"/opuscntr/img/btns_calendar.gif");
		  SetImageList(1,"/opuscntr/img/btns_search.gif");
			
		  SetEditable(1);
	      SetCountPosition(0);
	      SetWaitImageVisible(0);
	      SetRowHidden(0, 1);
	      //SetShowButtonImage(2);
	      
	  	  SetExtendLastCol(0);
	      //SetColWidth(0 ,150);

	      InitHeadColumn(leftHeaders,sheetObj);
	      SetSheetHeight(ComGetSheetHeight(sheetObj, 5.3));	
	      //SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
	      //SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
      }
		break;
	case 'sheet2': // sheet2 init
	    with(sheetObj){
		      var HeadTitle1="| | | " + HeadCol1 + "|Remark(s)";
		      var HeadTitle2="|VSL\nCD|VOY\nNO|DIR"+HeadCol2+"|Remark(s)";
		      var HeadTitle3="|VSL\nCD|VOY\nNO|DIR"+HeadCol3+"|Remark(s)";
		      var HeadTitle4="|VSL\nCD|VOY\nNO|DIR"+HeadCol4+"|Remark(s)";
		     // var HeadTitle5="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol5+"|Remark(s)";
		      var HeadTitle6="|VSL\nCD|VOY\nNO|DIR"+HeadCol6+"|Remark(s)";

		      var portNum=parseInt(ComCountHeadTitle(HeadCol1) - 1) / 2;
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center", RowMerge:0},
		                  { Text:HeadTitle3, Align:"Center", RowMerge:0},
		                  { Text:HeadTitle4, Align:"Center", RowMerge:0},
		                  //{ Text:HeadTitle5, Align:"Center"},
		                  { Text:HeadTitle6, Align:"Center", RowMerge:0}];
		      InitHeaders(headers, info);
		      
		        for(var i=0 ; i < dataSetCnt ; i++){
		        	cnt=0;
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    for(var j = 0 ; j < portNum ; j++){
				        if(i == 0){
				        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        }else{
				        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        }				       
                    }
                    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    
		        }
		        InitColumns(cols);	
		        
		        var etbStartIdx = 4;
		    	for (var ydRow = 0; ydRow < portNum*2; ydRow = ydRow +2) {
		    		SetMergeCell(1, etbStartIdx+ydRow, 1, 2); // PORT Row
					SetMergeCell(4, etbStartIdx+ydRow, 1, 2); // Yard Row
					
					//SetMergeCell(2, etbStartIdx+ydRow, 1, 2); // Day  Row
					//SetMergeCell(3, etbStartIdx+ydRow, 1, 2); // Time Row
				}	
		        
		        SetEditable(1);
		        SetWaitImageVisible(0);
		        resizeSheet();
		        /*
		      var cols = [];
			  for ( var i = 0; i < dataSetCnt; i++) {
	            	cols.push({Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } );
	            	cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            for ( var j = 0; j < portNum; j++) {
		            	if (i == 0) {
		            		cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            		cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            	} else {
		            		cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            		cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            	}
		            }
	            	cols.push({Type:"Text", Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text", Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    
			  }

		      InitColumns(cols);
		
		      SetEditable(1);
		      //SetCountPosition(0);
		      //SetSheetHeight(345);
		      
		      SetWaitImageVisible(0);
		      SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
		      */
		}

	    break;
		case 'sheet3' : 	// P/F SKD info
			  with(sheetObj){
				   var HeadTitle="|vsl_slan_cd|skd_dir_cd|port_cd|yd_cd|clpt_seq|call_yd_ind_seq|port_rotn_seq|turn_port_flg|turn_port_ind_cd|etb_dy_cd|etb_dy_no|etb_tm_hrmnt|etd_dy_cd|etd_dy_no|etd_tm_hrmnt|mnvr_in_hrs|mnvr_out_hrs"
				   var headCount=ComCountHeadTitle(HeadTitle);
		
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
				   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				   var headers = [ { Text:HeadTitle, Align:"Center"} ];
				   InitHeaders(headers, info);
		
				   var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"clpt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"call_yd_ind_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_rotn_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"turn_port_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"turn_port_ind_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_dy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_tm_hrmnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_dy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_tm_hrmnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mnvr_in_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mnvr_out_hrs",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				    
				   InitColumns(cols);
		
				   SetEditable(1);
				   SetVisible(0);
				   SetSheetHeight(400);
		      }
			break;
	} // end of switch
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg(false);
	
	switch (sAction) {
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value=SEARCH;
		if ( sheetObj.id == "sheet1"){
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0054GS.do" , sParam);
			if(ComGetEtcData(sXml, "vsl_slan_nm")){
				var vsl_cnt = ComGetEtcData(sXml, "vsl_count");
				var brth_itval_dys = ComGetEtcData(sXml, "brth_itval_dys");
				
				formObj.vsl_cnt.value=vsl_cnt;
				formObj.initVslCnt.value=ComGetEtcData(sXml, "vsl_count");
				formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
				formObj.brth_itval_dys.value=brth_itval_dys;
				formObj.svc_dur_dys.value=ComGetEtcData(sXml, "svc_dur_dys");
				formObj.stnd_pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
				
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				
				formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
				setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
				
				var start_date=ComGetNowInfo();
				for(var i=1; i <= vsl_cnt; i++){
					sheetObjects[0].SetCellValue(1,"Vsl_" + i,ComGetDateAdd(start_date, "D", (i-1)*brth_itval_dys),0);
					sheetObjects[0].SetCellValue(4,"Vsl_" + i,formObj.pf_svc_tp_cd.value,0);
				}
				
				formObj.end_date.focus();
			}else{				
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				initPage();
				formObj.tmp_vsl_slan_cd.value="";
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
			}
		}
		
		break;
		
	case IBSAVE: // save
		formObj.f_cmd.value=MULTI;
		if (validateForm(sheetObj, formObj, sAction)){
			var sParam=FormQueryString(formObj)+ "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
			sParam=sParam + vvdDeleteReason;
			var param="";
			for(var i=0; i<bkgVVDs.length; i++){
				param=param + "&bkg_ibflag=I";
				param=param + "&bkg_vsl_slan_cd=" + bkgVVDs[i].vslSlanCd;
				param=param + "&bkg_vsl_cd=" + bkgVVDs[i].vslCd;
				param=param + "&bkg_skd_voy_no=" + bkgVVDs[i].skdVoyNo;
				param=param + "&bkg_skd_dir_cd=" + bkgVVDs[i].skdDirCd;
				param=param + "&bkg_turn_skd_voy_no=" + bkgVVDs[i].turnSkdVoyNo;
				param=param + "&bkg_turn_skd_dir_cd=" + bkgVVDs[i].turnSkdDirCd;
			}
			for(var i=0; i<virVVDs.length; i++){
				param=param + "&vir_ibflag=I";
				param=param + "&vir_vsl_slan_cd=" + virVVDs[i].vslSlanCd;
				param=param + "&vir_vsl_cd=" + virVVDs[i].vslCd;
				param=param + "&vir_skd_voy_no=" + virVVDs[i].skdVoyNo;
				param=param + "&vir_skd_dir_cd=" + virVVDs[i].skdDirCd;
				param=param + "&vir_turn_skd_voy_no=" + virVVDs[i].turnSkdVoyNo;
				param=param + "&vir_turn_skd_dir_cd=" + virVVDs[i].turnSkdDirCd;
			}
			for(var i=0; i<bkgVirVVDs.length; i++){
				param=param + "&bkg_vir_ibflag=I";
				param=param + "&bkg_vir_vsl_slan_cd=" + bkgVirVVDs[i].vslSlanCd;
				param=param + "&bkg_vir_vsl_cd=" + bkgVirVVDs[i].vslCd;
				param=param + "&bkg_vir_skd_voy_no=" + bkgVirVVDs[i].skdVoyNo;
				param=param + "&bkg_vir_skd_dir_cd=" + bkgVirVVDs[i].skdDirCd;
				param=param + "&bkg_vir_turn_skd_voy_no=" + bkgVirVVDs[i].turnSkdVoyNo;
				param=param + "&bkg_vir_turn_skd_dir_cd=" + bkgVirVVDs[i].turnSkdDirCd;
			}
			for(var i=0; i<nonBkgVVDs.length; i++){
				param=param + "&non_bkg_ibflag=I";
				param=param + "&non_bkg_vsl_slan_cd=" + nonBkgVVDs[i].vslSlanCd;
				param=param + "&non_bkg_vsl_cd=" + nonBkgVVDs[i].vslCd;
				param=param + "&non_bkg_skd_voy_no=" + nonBkgVVDs[i].skdVoyNo;
				param=param + "&non_bkg_skd_dir_cd=" + nonBkgVVDs[i].skdDirCd;
				param=param + "&non_bkg_turn_skd_voy_no=" + nonBkgVVDs[i].turnSkdVoyNo;
				param=param + "&non_bkg_turn_skd_dir_cd=" + nonBkgVVDs[i].turnSkdDirCd;
			}
			// Setting always input status of SKD sheet
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
//				sheetObj.CellValue2(i, "ibflag") = "I";
				sheetObj.SetRowStatus(i,"I");
			}
			var sParamSheet2=ComGetSaveString(sheet2,false,true,-1);
			if(sParamSheet2 != ""){
				sParam=sParam + "&" + sParamSheet2;
			}
			var sParamSheet3=ComGetSaveString(sheetObjects[2],true,true,-1);
			if(sParamSheet3 != ""){
				sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
			}
			//alert (sParam);
			ComOpenWait(true);
			setTimeout(function(){
	 			var sXml=sheetObj.GetSaveData("VOP_VSK_0054GS.do" , sParam + param);
	 			ComOpenWait(false);
	 			sheetObj.LoadSaveData(sXml);
				if(!VskGetErrorXml(sXml)){
					//initPage();
					ComBtnDisable("btn_Simulation");
					ComBtnDisable("btn_Save");
				}				
	        },300);     
		}
		break;
	case SEARCH02: // simulation
		formObj.f_cmd.value=SEARCH02;
		var sParam=FormQueryString(formObj)+ "&" + ComGetSaveString(sheet1);
		
		var sParamSheet3=ComGetSaveString(sheet3,true,true,-1);
		if(sParamSheet3 != ""){
			sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
		}
		
		//alert( sParam );
		sheetObj=sheetObjects[1];
//		var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam, "", true);
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam);
		ComOpenWait(false);
		
		HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
        HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
        HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
        HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
        HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
        HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
        
        HeadPfSvcTp = ComGetEtcData(sXml, "HeadPfSvcTp");
        
        if(!HeadCol1){
        	HeadCol1="";
        	HeadCol2="";
        	HeadCol3="";
        	HeadCol4="";
        	HeadCol5="";
        	HeadCol6="";
        }
        
        //::2015-05-12:by TOP:://
        sheetObjects[1]   	= sheetObjects[1].Reset();
        ComConfigSheet 		(sheetObjects[1]);
        initSheet			(sheetObjects[1],2);       
        ComEndConfigSheet	(sheetObjects[1]);
        
        sheetObj			= sheetObjects[1];
        sheetObj.LoadSearchData(sXml,{Sync:1} );
        sheetObj.SetCellValue(0, "VVD1", HeadPfSvcTp);
        
		break;
		
	case SEARCH07:	// search vessel code
		formObj.f_cmd.value=COMMAND16;
		var sParam=FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
		var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		return vsl_eng_nm;
		break;
	case SEARCH08:	// search P/F Type Code
		formObj.slan_stnd_flg.value="N";
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0054GS.do" , sParam);
		if(ComGetEtcData(sXml, "pf_svc_tp_cd")){
			formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
			return true;
		}else{
			sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
			initPage();
			return false;
		}
		break;
	case SEARCH09: // P/F Type change
		formObj.f_cmd.value=SEARCH;
		if(formObj.stnd_pf_svc_tp_cd.value==formObj.pf_svc_tp_cd.value){
			formObj.slan_stnd_flg.value='Y';
		}else{
			formObj.slan_stnd_flg.value='N';
		}
		var sParam=FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0054GS.do" , sParam);
				
		if(VskGetErrorXml(sXml)){
			initPage();
			sheetObj.LoadSearchData(sXml,{Sync:1});
			formObj.tmp_vsl_slan_cd.value="";
			formObj.vsl_slan_cd.value="";
			formObj.vsl_slan_cd.focus();
		}else{
			formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
			formObj.brth_itval_dys.value=ComGetEtcData(sXml, "brth_itval_dys");
			formObj.svc_dur_dys.value=ComGetEtcData(sXml, "svc_dur_dys");							
			formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
			sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		/*
		if (sheetObj.RowCount()< 1) {
		  ComShowCodeMessage("VSK00012");	
		   return false;
		 }
		 */
	}
	return true;
}
/**
 * handling process for input validation
 */
function valid(sheetObj, formObj, action) {
	switch(action){
		case "SIMULATION":
			// if P/F Duration has ".", exception
			//if(formObj.svc_dur_dys.value.indexOf(".")>-1){
			//	ComShowCodeMessage("VSK00096", "Duration");
			//	return false;
			//}
			break;
	}
	if(formObj.vsl_slan_cd.value==""){
		ComShowCodeMessage('VSK00027', 'Lane CD');
		formObj.vsl_slan_cd.focus();
		return false;
	}else if(formObj.vsl_cnt.value=="" || formObj.vsl_cnt.value=="0"){
		ComShowCodeMessage('VSK00027', 'Vessel No');
		formObj.vsl_cnt.focus();
		return false;
	}
	var check=true;
	for(var i=1; i<=4; i++){
		for(var k=1; k<=formObj.vsl_cnt.value; k++){
			if(sheetObj.GetCellValue(i, "Vsl_" + k)==''){
				check=false;
				if(i==1){
					ComShowCodeMessage('VSK00027', 'Start Date');
				}else if(i==2){
					ComShowCodeMessage('VSK00027', 'Vessel Code');
				}else if(i==3){
					ComShowCodeMessage('VSK00027', 'Start Voy No');
				}else if(i==4){
					ComShowCodeMessage('VSK00027', 'P/F SKD Type');
				}
				sheetObj.SelectCell(i, "Vsl_" + k);
				break;
			}
		}
		if(!check){
			break;
		}
	}
	return check;
}
/**
 * Handling column hidden as VSL No.
 */
function setColHidden(sheetObj, viewCols) {

	if (!viewCols) {
		viewCols=0;
	} else {
		//viewCols=viewCols+1;
	}
	
	sheetObj.RenderSheet(0);
	// all false
	for ( var i=1; i <= sheetObj.LastCol(); i++) {
		sheetObj.SetColHidden(i,1);
	}
	// some column true
	for ( var i=1; i <= viewCols; i++) {
		sheetObj.SetColHidden(i,0);
	}
	sheetObj.RenderSheet(1);

}
//registering initial event 
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('keypress', 'enter_keypress', formObj);
	axon_event.addListenerForm('blur', "obj_deactivate", formObj);
	axon_event.addListenerForm('focus', "obj_activate", formObj);
//	axon_event.addListenerForm('change', 'obj_change', formObj);
}

function obj_activate() {
	switch (ComGetEvent("name")) {
		case "vsl_cnt":
		case "brth_itval_dys":
			backObj = ComGetEvent("value");
			break;
	}
}
/**
 * Handling focus out event
 */
function obj_deactivate() {
	
	var formObj    = document.form;
	var obj        = ComGetEvent();
	var eventValue = ComGetEvent("value");
	
	switch (ComGetEvent("name")) {
		case "vsl_slan_cd":
			if(eventValue =="" || ( ComChkLen(eventValue, 3)!=2 && ComChkLen(eventValue, 4)!=2 ) ){
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != eventValue){
				sheetObj=sheetObjects[1];
				formObj.pf_svc_tp_cd.value='';				
				//sheetObj.RemoveAll();
				if(sheetObj.LastCol()> 6){
					for(var i=4; i<=sheetObj.LastCol()-2; i++){
						sheetObj.SetColHidden(i,1);
					}
				}
				
				sheetObj=sheetObjects[0];
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
		case "vsl_cnt":

			if(backObj==null || backObj==ComGetEvent("value")){
				return;
			}
			var vsl_cnt=formObj.vsl_cnt.value;
			var brth_itval_dys=formObj.brth_itval_dys.value;
			if(formObj.vsl_slan_cd.value==""){
        		ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.vsl_cnt.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
			if(vsl_cnt>=20){
				ComShowCodeMessage('VSK00077');
				formObj.vsl_cnt.value=backObj;
				formObj.vsl_cnt.focus();
				return false;
			}
//			if(vsl_cnt!="1" && !checkFrequency()){
//				formObj.vsl_cnt.value=backObj;
//				formObj.vsl_cnt.focus();
//				return false;
//			}
			changeVessel("vsl_cnt");
			formObj.initVslCnt.value=vsl_cnt;
		break;
		case "brth_itval_dys":
			if(backObj==null || backObj==ComGetEvent("value")){
				return;
			}
			var vsl_cnt=formObj.vsl_cnt.value;
			var brth_itval_dys=formObj.brth_itval_dys.value;
			if(formObj.vsl_slan_cd.value==""){
				ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.brth_itval_dys.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
			if(vsl_cnt!="1" && !checkFrequency()){
				formObj.brth_itval_dys.value=backObj;
				formObj.brth_itval_dys.focus();
				return false;
			}
			changeVessel("brth_itval_dys");
		break;
	}
}

function enter_keypress(){
	VskKeyEnter();
}

function changeVessel(srcElement){
	var formObj=document.form;
	var sheetObj;
	var vsl_cnt=formObj.vsl_cnt.value;
	var brth_itval_dys=formObj.brth_itval_dys.value;
	HeadCol1="";
	HeadCol2="";
	HeadCol3="";
	HeadCol4="";
	HeadCol5="";
	HeadCol6="";
	sheetObjects[1] = sheetObjects[1].Reset();
    ComConfigSheet (sheetObjects[1]);
    initSheet(sheetObjects[1],2);
    ComEndConfigSheet(sheetObjects[1]);
    sheetObj=sheetObjects[0];
    switch(srcElement){
		case "vsl_cnt":
//			sheetObj.RemoveAll();
//			InitHeadColumn(leftHeaders,sheetObj);
		break;
		case "brth_itval_dys":
		break;
	}
    
	//var start_date = formObj.start_date.value;
	var start_date=ComGetNowInfo();
    setColHidden(sheetObj, vsl_cnt);

    for ( var i=1; i <= sheetObj.LastCol(); i++) {
		if (i <= vsl_cnt) {
			sheetObj.SetCellValue(1, "Vsl_" + i,ComGetDateAdd(start_date, "D", (i-1)*brth_itval_dys),0);
	   		sheetObj.SetCellValue(4, "Vsl_" + i,formObj.pf_svc_tp_cd.value,0);
	   		sheetObj.SetCellAlign(1, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(2, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(3, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(4, "Vsl_" + i,"Center");
		} else {
			sheetObj.SetCellValue(1, "Vsl_" + i,"",0);
			sheetObj.SetCellValue(2, "Vsl_" + i,"",0);
			sheetObj.SetCellValue(3, "Vsl_" + i,"",0);
	   		sheetObj.SetCellValue(4, "Vsl_" + i,"",0);
		}
	}
}
var callback_row = "";
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj=document.form;
	if(Row==1){
	    var cal=new ComCalendarGrid("myCal");
	    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}else if(Row==3){
	}else if(Row==4){
		callback_row = Row;
		var sUrl="/opuscntr/VOP_VSK_0212_POP.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
		ComOpenPopup(sUrl, 500, 407, "callBackVopVsk0212", "0,0", true); // pf_svc_tp_cd:pf_svc_tp_cd
	}
}
function sheet2_OnDblClick(sheetObj, Row, Col){
	if(Row<4) return;
	// for Remark input
	if(Col==sheetObj.LastCol()){
		var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, Col);
		ComOpenPopup(sUrl, 342, 370, "callBackVopVsk0218", "0,0", true);
		
	}
}

function callBackVopVsk0218( rVal ){
	if(rVal || rVal==''){
		sheet2.SetCellValue(sheet2.GetSelectRow(), "skd_rmk",rVal);
	}
}

function sheet1_left_Reset( sheetObj  ){
	 sheetObj.SetRowHidden(sheet1PfDateDataRow+sheetObj.HeaderRows(),1);// Hidden PF_DATE
    for(var i=0 ; i <5 ; i++){
			for ( var j = 1; j < 20; j++) {
				if (i == sheet1VslCdDataRow+1) {
					sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N|E" , InputCaseSensitive:1, EditLen:4 });
				} else if (i == sheet1VoyNoDataRow+1) {
					sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N", EditLen:4 });
				} else if (i == sheet1PfTypeDataRow+1) {
					sheetObj.InitCellProperty(i, j, {Type:"Popup", Format:"", EditLen:4 });
				} 
			}
		}
}

function sheet1_OnSearchEnd(sheetObj, code , ErrMsg)
{
	if( sheetObj.RowCount() < 1){
		InitHeadColumn(leftHeaders,sheetObj);
	} else {
		InitHeadText(leftHeaders,sheetObj);
		 sheet1_left_Reset(sheetObj);
	  /*  var formObj=document.form;
	    //var start_date = formObj.start_date.value;
	    var start_date=ComGetNowInfo();
	    var brth_itval_dys=formObj.brth_itval_dys.value;
	    for(var i=1; i <= formObj.vsl_cnt.value; i++){
	   		sheetObj.SetCellValue(1,"Vsl_" + i,ComGetDateAdd(start_date, "D", (i-1)*brth_itval_dys),0);
	   		sheetObj.SetCellValue(4,"Vsl_" + i,formObj.pf_svc_tp_cd.value,0);
	   		sheetObj.SetCellAlign(1, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(2, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(3, "Vsl_" + i,"Center");
	   		sheetObj.SetCellAlign(4, "Vsl_" + i,"Center");
	    }
	    if(ErrMsg != ""){
	    	formObj.vsl_slan_cd.value='';
	    	formObj.vsl_slan_cd.select();
	    }	*/
	}
	
	/*var vsl_counnt = 0 ;
	if(formObj.vsl_cnt.value != "" ){
		vsl_counnt = parseInt(formObj.vsl_cnt.value) ;

	}
	
	if( vsl_counnt<=9){
		sheetObj.SetRowHidden(5 , 1);		
		sheetObj.SetSheetHeight(sheetObj.GetHeaderRowHeight() * (sheetObj.RowCount() - 1) + 2 );
		//sheetObj.SheetWidth=width;
//no support[check again]CLT 		sheetObj.ViewRows=4;
	}else{
		sheetObj.SetRowHidden(5 , 0);
		sheetObj.SetSheetHeight(sheetObj.GetHeaderRowHeight() * sheetObj.RowCount() + 2);
		//sheetObj.SheetWidth=95*(9)+95;
//no support[check again]CLT 		sheetObj.ViewRows=5;
	}*/
	
}

function sheet1_OnChange(sheetObj , Row, Col, Value){
	if(!Value || Value==""){
		return false;
	}
	var formObj=document.form;
	if(Row==1){	// Start Date change
		adjustStartDate(sheetObj, Col, Value);
	}else if(Row==2){	// Vessel Code change
		if(Value.length < 4){
			ComShowCodeMessage('VSK00021', Value);
			sheetObj.SelectCell(Row, Col);
			sheetObj.SetCellValue(Row, Col,"",0);
			return false;
		}
		formObj.vsl_cd.value=Value;
    	var vsl_eng_nm=doActionIBSheet(sheetObj, formObj, SEARCH07);
    	if(!vsl_eng_nm){ // undefined
    		ComShowCodeMessage('VSK00021', Value);
    		sheetObj.SelectCell(Row, Col);
    		sheetObj.SetCellValue(Row, Col,"",0);
    	}else{
    		sheetObj.SetToolTipText(Row, Col,vsl_eng_nm);
    	}	
	}else if(Row==3){ // Voyage No change
		if(parseInt(Value)==0){
			Value="1";
		}
		sheetObj.SetCellValue(Row, Col,Value.lpad(4, "0"),0);
	}else if(Row==4){ // P/F Skd Type
		formObj.pf_svc_tp_cd.value=Value;
		if(doActionIBSheet(sheetObj, formObj, SEARCH08)){
			for(var i=1; i<sheetObj.LastCol(); i++){
				sheetObj.SetCellValue(4, i,Value,0);
			}
		}else{
//			for(var i=1; i<sheetObj.LastCol; i++){
//				sheetObj.CellValue2(4, i) = "";
//			}
			initPage();
		}
		HeadCol1="";
		HeadCol2="";
		HeadCol3="";
		HeadCol4="";
		HeadCol5="";
		HeadCol6="";
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
	}
}

function sheet1_OnDblClick(sheetObj, Row, Col){
	var formObj=document.form;
	if(Row==4){	// Changing PF Skd Type Code		
		 var sUrl="/opuscntr/VOP_VSK_0212_POP.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
		ComOpenPopup(sUrl, 500, 407, "callBackVopVsk0212", "0,0", true); // pf_svc_tp_cd:pf_svc_tp_cd		
	}else if(Row==1){
		sheetObj.SelectCell(Row, Col);
	}
}

function callBackVopVsk0212( rtnVal ){
	
	var formObj=document.form;
	if(rtnVal) {
		formObj.pf_svc_tp_cd.value =rtnVal;
		var vslCnt = formObj.vsl_cnt.value;
		
		if(formObj.pf_svc_tp_cd.value!=""){
			 for (var i = 1; i <= vslCnt; i++) {
				 sheet1.SetCellValue(4, i,rtnVal,0);
			}
			 doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
		}
		HeadCol1="";
		HeadCol2="";
		HeadCol3="";
		HeadCol4="";
		HeadCol5="";
		HeadCol6="";

		sheet2 = sheet2.Reset();
		ComConfigSheet (sheet2);
		initSheet(sheet2,2);
		ComEndConfigSheet(sheet2);
		
		formObj.vsl_slan_cd.focus();
	}
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
}
/**
 * Returning last date of quarter
 * 
 * @param date
 * @return
 */
function getQuarterEndDate(date){
	var year=date.substring(0, 4);
	var month_date=date.substring(4, 8);
	if(month_date <= "0331"){
		return year + "0331";
	}else if(month_date <= "0630"){
		return year + "0630";
	}else if(month_date <= "0930"){
		return year + "0930";
	}else{
		return year + "1231";
	}
}
function checkFrequency(){
	var formObj=document.form;
	if(formObj.brth_itval_dys.value=="" || formObj.brth_itval_dys.value=="0"){
		ComShowCodeMessage('VSK00017');
		return false;
	}
	return true;
}
function sheet3_OnSearchEnd(sheetObj, code ,ErrMsg)
{
	var formObj=document.form;
    if(ErrMsg != ""){
    	return;
    }
    if(sheetObj.RowCount()> 0){
    	formObj.skdDirCd1.value=sheetObj.GetCellValue(1, "skd_dir_cd");
    	formObj.skdDirCd2.value=sheetObj.GetCellValue(sheetObj.RowCount(), "skd_dir_cd");
    }
}
function checkPeriod(sheetObj, formObj){
var startDate=ComReplaceStr(sheetObj.GetCellValue(1, "Vsl_1"), "-", "");
	var endDate=ComReplaceStr(formObj.end_date.value, "-", "");
	var tmpDate=ComGetDateAdd(startDate, "Y", 2);// in 2 years
	if(ComChkPeriod(endDate, tmpDate)==1){
		return true;
	}else{
		return false;
	}
}

function adjustStartDate(sheetObj, Col, Value){
	var formObj=document.form;
	var brth_itval_dys=formObj.brth_itval_dys.value;
    var dateInfo=Value; //"YYYY-MM-DD"
    var check=0;
    var otherDate="";
    for(var i=1; i<Col; i++){
    	otherDate=sheetObj.GetCellValue(sheetObj.HeaderRows()+ sheet1StartDateDataRow, "Vsl_" + i);
    	otherDate=ComGetDateAdd(otherDate, "D", 0);
    	if(ComGetDaysBetween(otherDate, Value) < 1){
    		check=i;
    		break;
    	}
    }
    if(check > 0){
    	ComShowCodeMessage("VSK00025", "Start date", otherDate);
    	sheetObj.SelectCell(sheetObj.HeaderRows()+ sheet1StartDateDataRow, "Vsl_" + Col, true, "");
    	return false;
    }
    for(var i=Col, k=0; i <= formObj.vsl_cnt.value; i++, k++){
   		sheetObj.SetCellValue(sheetObj.HeaderRows()+ sheet1StartDateDataRow, "Vsl_" + i,ComGetDateAdd(dateInfo, "D", k*brth_itval_dys),0);
    }    
}


function resizeSheet(){
    ComResizeSheet(sheetObjects[1]);
}
