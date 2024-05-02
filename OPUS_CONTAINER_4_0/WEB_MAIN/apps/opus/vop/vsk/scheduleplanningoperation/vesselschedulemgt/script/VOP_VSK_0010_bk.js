/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0010.jsp
*@FileTitle : Long Range SKD Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class LRS Creation : LRS Creation
 */
 // public variable
var sheetObjects=new Array();
var sheetCnt=0;
var bkgVVDs=new Array();
var virVVDs=new Array();
var bkgVirVVDs=new Array();
var nonBkgVVDs=new Array();
var vvdDeleteReason="";
var dataStartCol=4;
var dataStartRow=5;
var bufferColCount=2;
var dataSetCnt=4;
var HeadCol1=""; // SKD_DIR_CD
var HeadCol2=""; // VPS_PORT_CD
var HeadCol3=""; // ETB_DY_CD/ETD_DY_CD
var HeadCol4=""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol5=""; // P/F CLPT_SEQ
var HeadCol6=""; // YARD_CD
var bakObj=null;
var skipvalue=" SKIP";
var pfSkdValidation=null;

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
var simplePIN=false;
var extendFlag=false;

var callPopRlt = false;
var rVal = false;
var vessels=new Array();
var countSimul=0;
var countCallBack=0;

document.onclick=processButtonClick;


function callBackVopVsk0202(rtnVal){
	var formObj=document.form;
	var rVal = rtnVal[0]; 
	if( rVal.length > 0 ){
		formObj.vsl_slan_cd.value =rVal[1];
		if(formObj.vsl_slan_cd.value!="" && formObj.tmp_vsl_slan_cd.value!=formObj.vsl_slan_cd.value){
			var vsl_slan_cd= formObj.vsl_slan_cd.value;
			initPage();
			formObj.tmp_vsl_slan_cd.value=vsl_slan_cd;
			formObj.vsl_slan_cd.value=vsl_slan_cd;
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}
}
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     /*******************************************************/
     var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
    		case "btns_search1":
    			var sUrl="/opuscntr/VOP_VSK_0202.do";
    			var rVal=ComOpenPopup(sUrl, 500, 490, "callBackVopVsk0202", "0,0", true);
    			

    			break;
    		case "btns_back2":
    			with(formObj){
    				// as end_year decreasing, start_year decrease at the same time
    				// end_date < start_date
    				end_year.value=parseInt(end_year.value)-1;
        			end_date.value=ComGetMaskedValue(endQuarterDay(end_year.value,selEndQuarter.value), "ymd");
    			}
    			break;
    		case "btns_next2":
    			with(formObj){
        			end_year.value=parseInt(end_year.value)+1;
        			end_date.value=ComGetMaskedValue(endQuarterDay(end_year.value,selEndQuarter.value), "ymd");
    			}
    			break;
    		case "btns_calendar2":
    			var cal=new ComCalendar();
    			cal.select(formObj.end_date, 'yyyy-MM-dd');
			break;
    		case "btn_Extend":
    			extend();
    			break;
    		case "btn_Reduce":
    			reduce();
    			break;
			case "btn_New":
				initPage();
				break;
			case "btn_Save":
				//sheetObject2 --> sheet2
				var check=valid(sheetObject1, formObj);
				/*
				if(sheetObject2.RowCount()==0){
					// not simulated SKD
					alert( "??");
					return false;
					
				}
				*/
				if(check){
					// VOP_VSK_0249 popup open. input Booking VVD delete remark
					
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
						ComOpenPopup(sUrl, 524, 342, "setPopResult", "0,0", true);
					
					}
					
					if(vvdDeleteReason!=null){
						doActionIBSheet(sheet2,document.form,IBSAVE);
					}
				}
				break;
			case "btn_Simulation":
				if(ComIsBtnEnable('btn_Simulation')){
					formObj.op_type.value="btn_Simulation";
					if(pfSkdValidation==false){
						return false;
					}
					// if P/F Duration has ".", exception
					if(formObj.svc_dur_dys.value.indexOf(".")>-1){
						ComShowCodeMessage("VSK00096", "Duration");
						return false;
					}
					bkgVVDs=new Array();
					virVVDs=new Array();
					bkgVirVVDs=new Array();
					nonBkgVVDs=new Array();
					var check=false;
					var headerRows=sheetObjects[0].HeaderRows();
					for(var i=1; i<=4; i++){
						for(var k=1; k<=formObj.vsl_cnt.value; k++){
							if(sheetObject1.GetCellValue(i, "Vsl_" + k)==''){
								check=false;
								if(i==headerRows + sheet1StartDateDataRow){
									ComShowCodeMessage('VSK00027', 'Start Date');
								}else if(i==headerRows + sheet1VslCdDataRow){
									ComShowCodeMessage('VSK00027', 'Vessel Code');
								}else if(i==headerRows + sheet1VoyNoDataRow){
									ComShowCodeMessage('VSK00027', 'Start Voy No');
								}else if(i==headerRows + sheet1PfTypeDataRow){
									ComShowCodeMessage('VSK00027', 'P/F SKD Type');
								}
								break;
							}else{
								check=true;
							}
						}
						if(!check){
							break;
						}
					}
					if(check){
						var sheetObj=sheetObjects[0];
						if(!checkPeriod(sheetObj, formObj)){
							ComShowCodeMessage("VSK00105", "2 year");
							return false;
						}
   						// Checking voyage per vessel code
						for(var i=1,k=0; i<sheetObj.LastCol(); i++){
							if(sheetObj.GetCellValue(2, i)!=""){
								var obj=new Object();
								obj.startDate=sheetObj.GetCellValue(sheet1StartDateDataRow + sheetObj.HeaderRows(), i);
								obj.vslCd=sheetObj.GetCellValue(sheet1VslCdDataRow + sheetObj.HeaderRows(), i);
								obj.skdVoyNo=sheetObj.GetCellValue(sheet1VoyNoDataRow + sheetObj.HeaderRows(), i);
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
										   + "&vsl_cnt=" + formObj.vsl_count.value
										   + "&voy_no_type=" + formObj.voy_no_type.value
										   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
										   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
										   + "&duration=" + formObj.svc_dur_dys.value;
							ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);
							countCallBack++;
						}
					}
				}
				break;
			case "btn_Delete":
				//sheetObject2 --> sheet2
				var row=sheet2.GetSelectRow();
				var col=sheet2.GetSelectCol();
				if(row<6){
					// Cannot delete header
					ComShowCodeMessage('VSK00061');
				}else{
					var vvd=sheet2.GetCellValue(row, "VVD1") + sheet2.GetCellValue(row, "VVD2") + sheet2.GetCellValue(row, "VVD3");
					if(ComShowCodeConfirm("VSK00062", vvd)){
						// Checking VVD is the last skd of Vessel
						if(isFinalVVD(sheet2, row)){
							// Deleting Last Port Schedule
							lastSkd=findLastSkd(sheet2, row);
							if(lastSkd){
								sheet2.SetCellValue(lastSkd.row, lastSkd.col,"",0);
								sheet2.SetCellValue(lastSkd.row, lastSkd.col+1,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2InitDateRowPos, lastSkd.col,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2InitDateRowPos, lastSkd.col+1,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2PfDateRowPos, lastSkd.col,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2PfDateRowPos, lastSkd.col+1,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2StatusRowPos, lastSkd.col,"",0);
								sheet2.SetCellValue(lastSkd.row+sheet2StatusRowPos, lastSkd.col+1,"",0);
							}
						}else{
							// Deleting linked SKD
							linkSkd=findPrevLinkSkd(sheet2, row, sheet2.SaveNameCol("VVD3") + 1);
							if(linkSkd){
								sheet2.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol+1,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2PfDateRowPos, linkSkd.tgtCol,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2PfDateRowPos, linkSkd.tgtCol+1,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol,"",0);
								sheet2.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1,"",0);
							}									
						}
						sheet2.RowDelete(row, false);
						sheet2.RowDelete(row, false);
						sheet2.RowDelete(row, false);
						sheet2.RowDelete(row, false);
					}
				}
				break;
			case "btn_PhaseIn":
				//sheetObject2 --> sheet2
					formObj.op_type.value="btn_PhaseIn";
					phaseIn(sheet2);
					sheet2_SetColor(sheet2);
				break;
			case "btn_PhaseInCancel":
				//sheetObject2 --> sheet2
					formObj.op_type.value="btn_PhaseInCancel";
					phaseInCancel(sheet2);
					sheet2_SetColor(sheet2);
				break;
			case "btn_PhaseOut":	
				//sheetObject2 --> sheet2
					if(sheet2.RowCount() <1 )  return;
					formObj.op_type.value="btn_PhaseOut";
					phaseOut(sheet2,"VVD1");
				break;
			case "btn_PhaseOutCancel":
				//sheetObject2 --> sheet2
					formObj.op_type.value="btn_PhaseOutCancel";
					phaseOutCancel(sheet2);
				break;
			case "btn_AddCall":
				//sheetObject2 --> sheet2
					if(sheet2.RowCount() < 1 ) {
						ComShowCodeMessage('VSK00059');
						return;
					}
					formObj.op_type.value="btn_AddCall";
					var row=sheet2.GetSelectRow();
					var col=sheet2.GetSelectCol();
					var addTargetCol=0;
					col=startColPos(sheet2, 0);
					// after getting add call information, Initializing selection data of sheet
					sheet2.SelectCell(row, 1, false);
					formObj.add_call_point.value=PortPosition(col);
					formObj.add_vvd_point.value=VvdPosition(sheet2.GetSelectRow());
	            	if(formObj.add_call_point.value==-1 || "skd_rmk"==sheet2.ColSaveName(col)){
	            		ComShowCodeMessage('VSK00059');
	            		break;
	            	}
	            	// Getting Add Call information
	            	var sUrl="";
	            	if(countAddCallPort(sheet2, row, col)>0){
	            		// in case of already add call, blocking to change port code
	            		sUrl="/opuscntr/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y&portCd=" + sheet2.GetCellValue(sheet2VpsPortCdHeaderRow, col) + "&ydCd=" +  sheet2.GetCellValue(sheet2YdCdHeaderRow, col);
	            	}else{
	            		sUrl="/opuscntr/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y";
	            	}
	            	
	            	ComOpenPopup(sUrl, 400, 369, "getVal0215", "0,0", true); 
					/*var rVal=ComOpenPopupWithTarget(sUrl, 400, 369, "", "0,0", true); 
					if(rVal){
						formObj.add_call_port_cd.value=rVal.port_cd;
						formObj.add_call_yard_cd.value=rVal.yard_cd;
						formObj.add_call_etb.value=rVal.etb;
						formObj.add_call_etd.value=rVal.etd;
						formObj.add_call_turn_ind.value=rVal.turn_ind;
						formObj.add_call_position.value=rVal.position;
		            	if(countAddCallPort(sheetObject2, row, col)>0){
		            		addTargetCol=col;
    						sheetObject2.SetCellValue(row, addTargetCol,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    						sheetObject2.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
		            	}else{
		            		var check=checkTargetPortIsAddPort(sheetObject2, row, col);
		            		if(check){
		            			if("before"==formObj.add_call_position.value){
		            				addTargetCol=col - 2;
		            			}else if("after"==formObj.add_call_position.value){
		            				addTargetCol=col + 2;
		            			}
		            			sheetObject2.SetCellValue(row, addTargetCol,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
        						sheetObject2.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
		            		}else{
    							if("after"==formObj.add_call_position.value){
        		            		addTargetCol=col + 2;
        		            	}else if("before"==formObj.add_call_position.value){
        		            		addTargetCol=col;
        		            		col=col + 2;
        		            	}
    							doActionIBSheet(sheetObject2,formObj,SEARCH05);
		            		}
		            	}
						// Add Call : VPS_ET
						// Setting INIT_ET same as VPS_ET
		            	sheetObject2.SetCellValue(row + sheet2InitDateRowPos, addTargetCol,sheetObject2.GetCellValue(row, addTargetCol),0);
		            	sheetObject2.SetCellValue(row + sheet2InitDateRowPos, addTargetCol+1,sheetObject2.GetCellValue(row, addTargetCol+1),0);
						sheetObject2.SetCellValue(row + sheet2StatusRowPos, addTargetCol,"A",0);
						sheetObject2.SetCellValue(row + sheet2StatusRowPos, addTargetCol+1,"A",0);
						sheet2_SetColor(sheetObject2);
					}*/
				break;
			case "btn_AddCallCancel":
				
					if(sheet2.RowCount() <1 ) {
						ComShowCodeMessage('VSK00059');
						return;
					}
					
					formObj.op_type.value="btn_AddCallCancel";
					var row=sheet2.GetSelectRow();
					var col=sheet2.GetSelectCol();
					col=startColPos(sheet2, 0);
					formObj.add_call_point.value=PortPosition(col);
					formObj.add_vvd_point.value=VvdPosition(sheet2.GetSelectRow());
					if(formObj.add_call_point.value==-1 || "skd_rmk"==sheet2.ColSaveName(col)){
						ComShowCodeMessage('VSK00059');
						break;
					}
					if("A"!=sheet2.GetCellValue(row+sheet2StatusRowPos, col)){
						ComShowCodeMessage('VSK00060');
						break;
					}
					if(countAdding(sheet2, col)>1){
						// Add Calling more than twice
						sheet2.SetCellValue(row, col,"",0);
						sheet2.SetCellValue(row, col+1,"",0);
						sheet2.SetCellValue(row+sheet2InitDateRowPos, col,"",0);
						sheet2.SetCellValue(row+sheet2InitDateRowPos, col+1,"",0);
						sheet2.SetCellValue(row+sheet2StatusRowPos, col,"",0);
						sheet2.SetCellValue(row+sheet2StatusRowPos, col+1,"",0);
					}else if(countAdding(sheet2, col)==1){
						// in case of first Add Call, deleting column
						doActionIBSheet(sheet2,formObj,SEARCH06);
        			}
				sheet2_SetColor(sheet2);
				break;
			case "btn_SkipCall":
				//alert( sheetObject2.RowCount() );
				//alert( sheet2.RowCount() );
					if(sheet2.RowCount() < 1 ) {
						return;
					}
					formObj.op_type.value="btn_SkipCall";
					//skipCall(sheetObject2);
					skipCall(sheet2);
				break;
			case "btn_SkipCallCancel":
				//sheetObject2 --> sheet2
					if(sheet2.RowCount() <1 ) {
						return;
					}
					formObj.op_type.value="btn_SkipCallCancel";
					skipCallCancel(sheet2);
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
var addTargetCol=0;
var addTargetRow=0;
/**
 * Callback 0215 Add Col
 * @param rVal
 */
function getVal0215(rVal){
	// var sheetObject1=sheetObjects[0];
    // var sheetObject2=sheetObjects[1];
	 var row=sheet2.GetSelectRow();
	 var col=sheet2.GetSelectCol();
     var formObj=document.form;
     addTargetRow = row;
	if(rVal != null ){
		formObj.add_call_port_cd.value=rVal.port_cd;
		formObj.add_call_yard_cd.value=rVal.yard_cd;
		formObj.add_call_etb.value=rVal.etb;
		formObj.add_call_etd.value=rVal.etd;
		formObj.add_call_turn_ind.value=rVal.turn_ind;
		formObj.add_call_position.value=rVal.position;
    	if(countAddCallPort(sheet2, row, col)>0){
    		addTargetCol=col;
    		sheet2.SetCellValue(row, addTargetCol,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    		sheet2.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    	}else{
    		var check=checkTargetPortIsAddPort(sheet2, row, col);
    		if(check){
    			if("before"==formObj.add_call_position.value){
    				addTargetCol=col - 2;
    			}else if("after"==formObj.add_call_position.value){
    				addTargetCol=col + 2;
    			}
    			sheet2.SetCellValue(row, addTargetCol,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    			sheet2.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    		}else{
				if("after"==formObj.add_call_position.value){
            		addTargetCol=col + 2;
            	}else if("before"==formObj.add_call_position.value){
            		addTargetCol=col;
            		col=col + 2;
            	}
				doActionIBSheet(sheet2,formObj,SEARCH05);
    		}
    	}
		// Add Call : VPS_ET
		// Setting INIT_ET same as VPS_ET
    	/*sheet2.SetCellValue(row + sheet2InitDateRowPos, addTargetCol,sheet2.GetCellValue(row, addTargetCol),0);
    	sheet2.SetCellValue(row + sheet2InitDateRowPos, addTargetCol+1,sheet2.GetCellValue(row, addTargetCol+1),0);
    	sheet2.SetCellValue(row + sheet2StatusRowPos, addTargetCol,"A",0);
    	sheet2.SetCellValue(row + sheet2StatusRowPos, addTargetCol+1,"A",0);
		sheet2_SetColor(sheet2);*/
	}
	
	
}

function getSimulData(rVal){
	var formObj = document.form;
	var sUrl="/opuscntr/VOP_VSK_0211_POP.do";
	
	if(vessels.length == countCallBack){
		doActionIBSheet(sheetObjects[1],formObj,SEARCH02);
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
		   + "&vsl_cnt=" + formObj.vsl_count.value
		   + "&voy_no_type=" + formObj.voy_no_type.value
		   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
		   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
		   + "&duration=" + formObj.svc_dur_dys.value;
		ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);
		countCallBack++;
	}
}

function setPopResult( rtnVal ){
	
	vvdDeleteReason = rtnVal;
	return rtnVal;
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
	var formObj=document.form;
    //for(i=0;i<sheetObjects.length;i++){
	for(i=sheetObjects.length-1; i>=0; i--){
    	ComConfigSheet (sheetObjects[i] );
    	initSheet(sheetObjects[i],i+1);
    	ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
	// Setting Current Year
	var today=new Date();
	with(formObj){
		var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		end_year.value=today.getFullYear();
		selEndQuarter.value=checkQuarter(nowDate);
		end_date.value=ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
	    vsl_slan_cd.focus();
    }
    setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
}
/** 
 * Initializing Screen
 */
function initPage() {
	var formObj=document.form;
	sheet3.RemoveAll();
	reduce();
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
	
	for(var i=1; i<=sheet1.LastCol(); i++){
		sheet1.SetColHidden(i,1);
	}
	
	simplePIN=false;
    formObj.vsl_slan_cd.value="";
	formObj.tmp_vsl_slan_cd.value="";
	formObj.brth_itval_dys.value="";
	formObj.vsl_cnt.value="";
	formObj.vsl_count.value="";
	formObj.pf_svc_tp_cd.value="";
	formObj.slan_stnd_flg.value="Y";
	// Setting Current Year
	var today=new Date();
	with (formObj) {
		var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		selEndQuarter.value=checkQuarter(nowDate);
    	end_year.value=today.getFullYear();
    	end_date.value=ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
//	setColHidden(sheet1,0);
//	setColHidden(sheetObjects[0],0);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
var leftHeaders = [{Text:"Start Date|Vessel Code|Start Voy. No.|P/F SKD Type|Out", Align:"Left"}];
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var formObj=document.form;
    switch(sheetObj.id) {
        case 'sheet1':      // Vessel Info grid
            with(sheetObj){
            tabIndex=-1;
          //style.imeMode="inactive";
        
          var HeadTitle1="||||||||||||||||||||";


          SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );

          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);
          var cols = new Array();

          cols.push( {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:"left",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } );
          
          for(var i=0 ; i <sheet1DataRows ; i++){
                for ( var j = 1; j < 20; j++) {
		          if (i == sheet1StartDateDataRow) {
		          cols.push({Type:"PopupEdit", Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		          } else if (i == sheet1VslCdDataRow) {
		        	  cols.push({Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
		          } else if (i == sheet1VoyNoDataRow) {
		        	  cols.push({Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
		          } else if (i == sheet1PfTypeDataRow) {
		        	  cols.push({Type:"PopupEdit", Hidden:0, Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
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
	      SetExtendLastCol(0);
	      SetShowButtonImage(1);
	      InitHeadColumn(leftHeaders,sheetObj);
	      SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
	      SetVisible(1);
        }
            break;
        case 'sheet2':      // SKD grid
            with(sheetObj){
        		if (HeadCol1 == undefined) HeadCol1 = "";
		        var HeadTitle1="| | | " + HeadCol1 + "|Remark(s)|";
		        var HeadTitle2="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol2+"|Remark(s)|";
		        var HeadTitle3="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol3+"|Remark(s)|";
		        var HeadTitle4="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol4+"|Remark(s)|";
		       // var HeadTitle5="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol5+"|Remark(s)|";
		        var HeadTitle6="|VSL\nCD|VOY.\nNO.|DIR"+HeadCol6+"|Remark(s)|";
		        var portNum=parseInt(ComCountHeadTitle(HeadCol1)-1)/2;
		        
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		        
	        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"},
				                { Text:HeadTitle2, Align:"Center"},
				                { Text:HeadTitle3, Align:"Center"},
				                { Text:HeadTitle4, Align:"Center"},
				               // { Text:HeadTitle5, Align:"Center"},
				                { Text:HeadTitle6, Align:"Center"}];
	        	InitHeaders(headers, info);
	        	
	        	 var etbStartIdx=4;		
			        for(var i=0; i<portNum*2; i=i+2){
			        	SetMergeCell(sheet2VpsPortCdHeaderRow, etbStartIdx+i, 1, 2); // Port Row
			        	SetMergeCell(sheet2YdCdHeaderRow, etbStartIdx+i, 1, 2); // Yard Row
		        	}	
	        	
		        for(var i=0 ; i < dataSetCnt ; i++){
		        	cnt=0;
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"VVD3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    for(var j = 0 ; j < portNum ; j++){
				        if(i == 0){
				        	cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        	cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        }else{
				        	cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        	cols.push({Type:"Text",      Hidden:0,  Width:33,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				        }				       
                    }
                    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                    
		        }
		        InitColumns(cols);		        
		        SetEditable(1);
		        SetWaitImageVisible(0);
		        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
		       
        }

            
            break;
        case 'sheet3' : 	// P/F SKD
            with(sheetObj){
            tabIndex=-1;
      
		       if (location.hostname != "")
		     
		       var HeadTitle="|vsl_slan_cd|skd_dir_cd|port_cd|yd_cd|clpt_seq|call_yd_ind_seq|port_rotn_seq|turn_port_flg|turn_port_ind_cd|eta_dy_cd|eta_dy_no|eta_tm_hrmnt|etb_dy_cd|etb_dy_no|etb_tm_hrmnt|etd_dy_cd|etd_dy_no|etd_tm_hrmnt|mnvr_in_hrs|mnvr_out_hrs|sea_buf_hrs|port_buf_hrs";
		
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
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eta_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eta_dy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eta_tm_hrmnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_dy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_tm_hrmnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_dy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etd_tm_hrmnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mnvr_in_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mnvr_out_hrs",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sea_buf_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		    // {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		        
		       InitColumns(cols);		
		       SetEditable(1);
		       SetVisible(0);
		       SetSheetHeight(200);
                      }


			break;
    }
}
  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
			if(validateForm(sheetObj,formObj,sAction)) {
				//
			}
			if ( sheetObj.id == "sheet1"){
				var sParam=FormQueryString(formObj);
				//sheetObj.DoSearch("VOP_VSK_0010GS_1.do" , sParam);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("VOP_VSK_0010GS.do" , sParam);
				ComOpenWait(false);
				if(ComGetEtcData(sXml, "vsl_slan_nm")){

					formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
					formObj.vsl_cnt.value=ComGetEtcData(sXml, "vsl_count");
					formObj.vsl_count.value=ComGetEtcData(sXml, "vsl_count");
					formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
					formObj.brth_itval_dys.value=ComGetEtcData(sXml, "brth_itval_dys");
					formObj.svc_dur_dys.value=ComGetEtcData(sXml, "svc_dur_dys");
					// in case Lane Code change, Getting stand type
					formObj.stnd_pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
					sheetObjects[2].RenderSheet(0);
					sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
					sheetObjects[2].RenderSheet(1);
					manageStartInfo();
				}else{
					sheetObjects[2].RenderSheet(0);
					sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
					sheetObjects[2].RenderSheet(1);
					initPage();
					formObj.tmp_vsl_slan_cd.value="";
					formObj.vsl_slan_cd.value="";
					formObj.vsl_slan_cd.focus();
				}
			}else if ( sheetObj.id == "sheet2"){
				var sParam=FormQueryString(formObj)+ "&" + ComGetSaveString(sheetObjects[0]);
 				var sXml=sheet2.GetSearchData("VOP_VSK_0010GS.do" , sParam);
	            HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
	            sheet2 = sheet2.RemoveAll();
                ComConfigSheet (sheet2);
                initSheet(sheet2, 2);
                ComEndConfigSheet(sheet2);
                sheet2.LoadSearchData(sXml,{Sync:1} );
			}
			break;
		case IBSAVE:        //save
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
				// Keeping SKD sheet's input state
				for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
					sheetObj.SetRowStatus(i,"I");
				}
				
				
				var sParamSheet2=ComGetSaveString(sheet2,false,true,-1);
				if(sParamSheet2 != ""){
					sParam=sParam + "&" + sParamSheet2;
					//alert(sParamSheet2 );
				}
				var sParamSheet3=ComGetSaveString(sheetObjects[2],true,true,-1);
				if(sParamSheet3 != ""){
					sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
				}
				//// Adding sheet1 info to parameter
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("VOP_VSK_0010GS.do" , sParam + param);
				ComOpenWait(false);
 				sheetObj.LoadSaveData(sXml);
				if(!VskGetErrorXml(sXml)){
					initPage();
				}
			}
			break;
		case SEARCH02: // simulation
			formObj.f_cmd.value=SEARCH02;
			//sheetObjects[2].SetCellValue(sheetObjects[2].HeaderRows(),"ibflag","U");
			var sParam=makeFormString(formObj, sheetObjects[0], null, sheetObjects[2]);
			//alert( sParam );
			sheetObj=sheetObjects[1];
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam);
			ComOpenWait(false);
			
			HeadCol1=ComGetEtcData(sXml, "HeadTitle1");          
            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");          
            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");          
            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
            sheetObj = sheetObj.Reset();
         
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);       
            ComEndConfigSheet(sheetObj);
           
            if(!sXml.search("ERROR")){
            	ComBtnEnable("btn_Save");
            }
            
            if(formObj.voy_no_type.value=="1"){
            	sheetObj.SetColWidth("VVD2",80);
            }
            
            extend();
            sheetObj.LoadSearchData(sXml,{Sync:1} );
           
			break;
		case SEARCH03: // phase in
			formObj.f_cmd.value=SEARCH03;
			var sParam=makeFormString(formObj, sheetObjects[0], sheetObjects[1], sheetObjects[2]);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
            sheetObj =sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			formObj.phasein_vsl_cd.value="";
			formObj.phasein_voy_no.value="";
			formObj.phasein_start_date.value="";
			break;
		case SEARCH05:	// addcall
			formObj.f_cmd.value=SEARCH05;
			//sheetObj.RenderSheet(0);
			var sParam=makeFormString(formObj, null, sheet2, sheet3);
			//var sParam=makeFormString(formObj, null, sheetObjects[1], sheetObjects[2]);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
            sheetObj=sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			//sheetObj.RenderSheet(1);
			//kjh UI개선 
			
			sheetObj.SetCellValue(addTargetRow + sheet2InitDateRowPos, addTargetCol,sheetObj.GetCellValue(addTargetRow, addTargetCol),0);
			sheetObj.SetCellValue(addTargetRow + sheet2InitDateRowPos, addTargetCol+1,sheetObj.GetCellValue(addTargetRow, addTargetCol+1),0);
			sheetObj.SetCellValue(addTargetRow + sheet2StatusRowPos, addTargetCol,"A",0);
			sheetObj.SetCellValue(addTargetRow + sheet2StatusRowPos, addTargetCol+1,"A",0);
			sheet2_SetColor(sheetObj);
			break;
		case SEARCH06: // add call cancel
			formObj.f_cmd.value=SEARCH06;
			var sParam=makeFormString(formObj, null, sheetObjects[1], sheetObjects[2]);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1=ComGetEtcData(sXml, "HeadTitle1");          
            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");          
            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");          
            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");          
            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
            sheetObj =sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;
		case SEARCH07:	// search vessel code
			formObj.f_cmd.value=COMMAND16;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
			var vslInfo=new Object();
			vslInfo.vslEngNm=ComGetEtcData(sXml, "vsl_eng_nm");
			return vslInfo;
			break;
		case SEARCH08:	// search P/F Type Code
			formObj.slan_stnd_flg.value="N";
			formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0054GS.do" , sParam);
			if(ComGetEtcData(sXml, "pf_svc_tp_cd")){
				formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
//				formObj.vsl_count.value = ComGetEtcData(sXml, "vsl_count");
//				formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
//				formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
//				formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
//			
//				sheetObjects[2].LoadSearchXml(sXml);
//				
//				formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
//				if(formObj.vsl_count.value.parseInt() < formObj.vsl_cnt.value.parseInt()){
//					formObj.vsl_cnt.value = formObj.vsl_count.value;
//				}
//				setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
				return true;
			}else{
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				initPage();
				return false;
			}
			break;
		case SEARCH09: // P/F type change
			formObj.f_cmd.value=SEARCH;
			if(formObj.stnd_pf_svc_tp_cd.value==formObj.pf_svc_tp_cd.value){
				formObj.slan_stnd_flg.value='Y';
			}else{
				formObj.slan_stnd_flg.value='N';
			}
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0010GS.do" , sParam);
			if(VskGetErrorXml(sXml)){
				initPage();
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				formObj.tmp_vsl_slan_cd.value="";
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
			}else{
				formObj.vsl_count.value=ComGetEtcData(sXml, "vsl_count");
				formObj.pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
				formObj.brth_itval_dys.value=ComGetEtcData(sXml, "brth_itval_dys");
				formObj.svc_dur_dys.value=ComGetEtcData(sXml, "svc_dur_dys");
				formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
				//if(formObj.vsl_count.value.parseInt() < formObj.vsl_cnt.value.parseInt()){
					formObj.vsl_cnt.value=formObj.vsl_count.value;
				//}
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				manageStartInfo();
			}
		break;
    }
}
/**
 * Returning Start Date per Quarter
 */
function startQuarterDay(year,Quarter){
    switch(Quarter){
        case "1":
        	return year + "0101";
            break;
        case "2":
        	return year + "0401";
            break;
        case "3":
        	return year + "0701";
            break;
        case "4":
        	return year + "1001";
            break;
    }
    return true;
}
/**
 * Returning Last Date per Quarter
 */
function endQuarterDay(year,Quarter){
    switch(Quarter){
        case "1":
        	return year + "0331";
            break;
        case "2":
        	return year + "0630";
            break;
        case "3":
        	return year + "0930";
            break;
        case "4":
        	return year + "1231";
            break;
    }
    return true;
}
/**
 * Setting Column Hidden as VSL No.
 */
function setColHidden(sheetObj,viewCols){
	if(!viewCols){
		viewCols=0;
	}
	//sheetObj.RenderSheet(0);
	// all false
	for(var i=1; i<=sheetObj.LastCol(); i++){
		sheetObj.SetColHidden(i,1);
	}
	// some true
	for(var i=1; i<=viewCols; i++){
		sheetObj.SetColHidden(i,0);
	}
	
	// Handling sheet weight

	
	var width=95*(viewCols)+95;
	if(viewCols<=9){
		//sheetObj.SetSheetWidth(width);
//		sheetObj.ViewRows = sheet1DataRows;
		//sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
		//sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));
		//sheetObjects[1].SetSheetHeight(322);
	}else if(viewCols==0){
		//sheetObj.SetSheetWidth(90);
//		sheetObj.ViewRows = sheet1DataRows;
		sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
		sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));
	}else{
		//sheetObj.SetSheetWidth(95*(9)+95);
//		sheetObj.ViewRows = sheet1DataRows + 1;
		sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows+1));
		sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));

	}
	//sheetObj.RenderSheet(1);
}
function sheet1_OnChange(sheetObj , Row, Col, Value){
   	if(!Value || Value==""){
		return false;
	}
	var formObj=document.form;
	var datarow=Row - sheetObj.HeaderRows(); // position of DataRow
	if(datarow==sheet1StartDateDataRow){
		adjustStartDate(sheetObj, Col, Value);
	}else if(datarow==sheet1VslCdDataRow){	// Vessel Code change
		formObj.vsl_cd.value=Value;
		// Checking already inputed vessel code
		for(var i=0; i<Col; i++){
			if(Value == sheetObj.GetCellValue(Row, i)){
				ComShowCodeMessage('VSK00085', Value);
				sheetObj.SelectCell(Row, Col);
        		sheetObj.SetCellValue(Row, Col,"",0);
        		return false;
			}
		}
		var vslInfo=doActionIBSheet(sheetObj, formObj, SEARCH07);
		if(vslInfo.vslEngNm && vslInfo.vslEngNm!=""){
			sheetObj.SetToolTipText(Row, Col,vslInfo.vslEngNm);
		}else{
			ComShowCodeMessage('VSK00021', Value);
			sheetObj.SelectCell(Row, Col);
			sheetObj.SetCellValue(Row, Col,"",0);
		}
	}else if(datarow==sheet1VoyNoDataRow){ // Voyage No Change
		sheetObj.SetCellValue(Row, Col,Value.lpad(4, "0"),0);
		if(sheetObj.GetCellValue(Row, Col)=="0000"){
			ComShowCodeMessage("VSK00101");
			sheetObj.SelectCell(Row, Col);
			sheetObj.SetCellValue(Row, Col,"",0);
			return false;
		}
	}else if(datarow==sheet1PfTypeDataRow){ // P/F Skd Type
		formObj.pf_svc_tp_cd.value=Value;
		if(doActionIBSheet(sheetObj, formObj, SEARCH08)){
			doActionIBSheet(sheetObj, formObj, SEARCH09);
			if(formObj.vsl_slan_cd.value!=""){
				for(var i=1; i<sheetObj.LastCol(); i++){
					sheetObj.SetCellValue(Row, i,Value,0);
				}
			}
			HeadCol1="";
			HeadCol2="";
			HeadCol3="";
			HeadCol4="";
			HeadCol5="";
			HeadCol6="";
			initSheet(sheetObjects[1], 2);
			formObj.vsl_slan_cd.focus();
		}else{
			formObj.vsl_slan_cd.focus();
		}
	}
}
function sheet2_OnDblClick(sheetObj , Row, Col)
{
	if(Col >= dataStartCol && Col <= sheetObj.LastCol()-bufferColCount){
		var oldval=sheetObj.GetCellValue(Row, Col);
		var port=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, Col);
    	var est=Col%2==0 ? "ETB" : "ETD";
    	if(oldval=='' || oldval==skipvalue){
    		return false;
    	}
		if(oldval.substring(0,3) != "out"){
			var sUrl="/opuscntr/VOP_VSK_0210.do?port=" + port + "&est=" + est + "&srcdate=" + oldval;
			var rVal=ComOpenPopupWithTarget(sUrl, 428, 402, "", "0,0", true);
			if(rVal){
				sheetObj.SetCellValue(Row, Col,rVal);// VPS_ET
				sheetObj.SetCellValue(Row+sheet2InitDateRowPos, Col,rVal);// INIT_ET
			}
		}
	}else if(Col==sheetObj.LastCol()-bufferColCount+1){
		if(Row<4) return;
		// Remark input popup open

		var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, Col);
		ComOpenPopup(sUrl, 342, 370, "getRmkVal", "0,0", true);
		
		/*
		if(rVal || rVal==""){
			sheetObj.SetCellValue(Row, Col,rVal);
		}
		*/
	}
}

function getRmkVal(rtnVal ){
	
	if( rtnVal != ""){
		sheet2.SetCellValue(sheet2.GetSelectRow(), "skd_rmk",rtnVal);
	}
}

function sheet2_SetColor(sheetObj){
	var Value="";
	for(var Row=sheetObj.HeaderRows(); Row < sheetObj.HeaderRows()+ sheetObj.RowCount(); Row++){
		for(var Col=0; Col <sheetObj.LastCol(); Col++){
			Value=sheetObj.GetCellValue(Row, Col);
			if(Value == " SKIP"){
				sheetObj.SetCellBackColor(Row, Col,"#C0C0C0");
				continue;
			}
			if(ComChkLen(Value, 2)==0 || ComChkLen(Value, 2)==2){
				if("I:" == Value.substring(0, 2)){
					// phase in coloring
                	for(var i=sheetObj.SaveNameCol("VVD3")+1; i<Col-1; i++){
                		sheetObj.SetCellBackColor(Row-sheet2StatusRowPos, i,"#C8C8C8");
                	}		
				}
			}
		}
	}
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg)
{
	var formObj=document.form;
	var mnvr_in_hrs;
	var mnvr_in_time;
	var etb_tm_hrmnt;
	var eta_tm_hrmnt;
	var etaDate=new Date(); 
	var etbDate=new Date();
	var dyNoGap;
    if(ErrMsg != ""){
    	return;
    }
    if(sheetObj.RowCount()> 0){
    	formObj.skdDirCd1.value=sheetObj.GetCellValue(1, "skd_dir_cd");
    	formObj.skdDirCd2.value=sheetObj.GetCellValue(sheetObj.RowCount(), "skd_dir_cd");
		// using mnvr_in_hrs of last port 
    	sheetObj.SetCellValue(sheetObj.HeaderRows(), "mnvr_in_hrs",sheetObj.GetCellValue(sheetObj.LastRow(), "mnvr_in_hrs"),0);
    	for(var i=0; i<sheetObj.RowCount(); i++){
    		mnvr_in_hrs=sheetObj.GetCellValue(i+1, "mnvr_in_hrs");
    		etb_tm_hrmnt=sheetObj.GetCellValue(i+1, "etb_tm_hrmnt");
    		etbDate.setHours(etb_tm_hrmnt.substring(0, 2), etb_tm_hrmnt.substring(2, 4), 0, 0);
    		// converting mnvr_in_hrs to milliseconds
    		mnvr_in_time=mnvr_in_hrs * 10 * 60 * 60 * 100;
    		// Calculating ETA
    		etaDate.setTime(etbDate.getTime() - mnvr_in_time);
    		// Calculating difference of ETA, ETB
    		dyNoGap=etbDate.getDay() - etaDate.getDay();
    		if(dyNoGap < 0){
    			dyNoGap=dyNoGap + 7;
    		}
    		sheetObj.SetCellValue(i+1, "eta_tm_hrmnt",ComLpad(etaDate.getHours(), 2, "0") + ComLpad(etaDate.getMinutes(), 2, "0"));
    		if(dyNoGap == 0){
    			sheetObj.SetCellValue(i+1, "eta_dy_cd",sheetObj.GetCellValue(i+1, "etb_dy_cd"));
    			sheetObj.SetCellValue(i+1, "eta_dy_no",sheetObj.GetCellValue(i+1, "etb_dy_no"));
    		}else{
    			sheetObj.SetCellValue(i+1, "eta_dy_cd",beforeDay(sheetObj.GetCellValue(i+1, "etb_dy_cd"), dyNoGap));
    			sheetObj.SetCellValue(i+1, "eta_dy_no",sheetObj.GetCellValue(i+1, "etb_dy_no") - dyNoGap);
    		}
    	}
    	if(!validatePF(sheetObj)){
    		pfSkdValidation=false;
    		initPage();
    	}else{
    		pfSkdValidation=true;
    	}
    }
}
function validatePF(sheetObj){
	var preDyNo;
	var preTmHrmnt;
	var curDyNo;
	var curTmHrmnt;
	var check=true;
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.RowCount(); Row++){
		// Checking mnvr_in_hrs is 0
		if("0"==sheetObj.GetCellValue(Row, "mnvr_in_hrs")){
			check=false;
			ComShowCodeMessage("VSK00096", "Maneuvering In Hours");
			break;
		}
		if(Row!=sheetObj.HeaderRows()){
			if(!compare(
					sheetObj.GetCellValue(Row-1, "etd_dy_no"),
					sheetObj.GetCellValue(Row-1, "etd_tm_hrmnt"),
					sheetObj.GetCellValue(Row, "eta_dy_no"),
					sheetObj.GetCellValue(Row, "eta_tm_hrmnt"),
					true)){
				check=false;
				//alert(sheetObj.GetCellValue(Row, "port_cd"));
				ComShowCodeMessage("VSK00096", "ETD, ETA");
				break;
			}
		}
		if(!compare(
				sheetObj.GetCellValue(Row, "eta_dy_no"),
				sheetObj.GetCellValue(Row, "eta_tm_hrmnt"),
				sheetObj.GetCellValue(Row, "etb_dy_no"),
				sheetObj.GetCellValue(Row, "etb_tm_hrmnt"))){
			check=false;
			ComShowCodeMessage("VSK00096", "ETA, ETB");
			break;
		}
		if(!compare(
				sheetObj.GetCellValue(Row, "etb_dy_no"),
				sheetObj.GetCellValue(Row, "etb_tm_hrmnt"),
				sheetObj.GetCellValue(Row, "etd_dy_no"),
				sheetObj.GetCellValue(Row, "etd_tm_hrmnt"))){
			check=false;
			ComShowCodeMessage("VSK00096", "ETB, ETD");
			break;
		}
	}
	return check;
}
/*
 * Checking current info and pre info
 */
function compare(preDyNo, preTmHrmnt, curDyNo, curTmHrmnt, boundEnable){
	// Checking preDyNo, preTmHrmnt, curDyNo, curTmHrmnt are null string
	if(!(ComIsNumber(preDyNo, "-") && ComIsNumber(preTmHrmnt, "-") && ComIsNumber(curDyNo, "-") && ComIsNumber(curTmHrmnt, "-"))){
		return false;
	}
	preDyNo=ComParseInt(preDyNo);
	preTmHrmnt=ComParseInt(preTmHrmnt);
	curDyNo=ComParseInt(curDyNo);
	curTmHrmnt=ComParseInt(curTmHrmnt);
	if(preDyNo > curDyNo){
		return false;
	}
	if(preDyNo == curDyNo){
		//in case boundEnable is true, permitting boundary value(preTmHrmnt == curTmHrmnt)
		if(boundEnable && (preTmHrmnt > curTmHrmnt)){
			return false;
		}else if(!boundEnable && !(preTmHrmnt < curTmHrmnt)){
			return false;
		}
	}
	return true;
}
/*
 * Finding before day
 */
function beforeDay(day, dyNoGap)
{
	var arDays=new Array("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
	var d;
	switch(day){
		case "SUN":
			d=0;
			break;
		case "MON":
			d=1;
			break;
		case "TUE":
			d=2 ;
			break;
		case "WED":
			d=3;
			break;
		case "THU":
			d=4;
			break;
		case "FRI":
			d=5;
			break;
		case "SAT":
			d=6;
			break;
	}
	d=d - dyNoGap;
	if(d<0){
		d=d + 7;
	}
	return arDays[d];
}
function PortPosition(Col)
{
	var port_idx=Number((Col - dataStartCol)/2 + 1);
	return port_idx;
}
function VvdPosition(Row)
{
	var vvd_idx=Number(Row - dataStartRow);
	return vvd_idx;
}
function startColPos(sheetObj, point)
{
    	var row=sheetObj.GetSelectRow();
    	var col=sheetObj.GetSelectCol();
		var startCol=0;
    	var colname=sheetObj.ColSaveName(col).substring(0,3);
		if(colname == 'ETB')
			return col+point;
		else if(colname == 'ETD')
			return col-1+point;
		else 	
			return false;
}
function phaseOut(sheetObj, stdCol)
{
	var formObj=document.form;
	with(sheetObj){
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
		if(""==sheetObj.GetCellValue(row, col) || skipvalue==sheetObj.GetCellValue(row, col)){
			return false;
		}
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
    	if(PortPosition(col)==-1 || "skd_rmk"==sheetObj.ColSaveName(col)){
    		ComShowCodeMessage('VSK00080');
    		return false;
    	}else{
    		ComOpenWait(true);
    		var param="";
    		param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
    		param += "&vsl_cd=" + sheetObj.GetCellValue(row, "VVD1");
    		param += "&voy_no=" + sheetObj.GetCellValue(row, "VVD2");
    		param += "&dir_cd=" + sheetObj.GetCellValue(0, col);
    		param += "&port_cd=" + sheetObj.GetCellValue(1, col);
    		param += "&phase_type=O";
    		param += "&clpt_ind_seq=" + sheetObj.GetCellValue(4, col);
    		param += "&phase_date=" + ComGetNowInfo();
    		param += "&parentUI=0010";
    		var sUrl="/opuscntr/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + "&" + param;
    		ComOpenPopup(sUrl, 650, 308, "getVal0205", "0,0", true);
    		/*var rVal=ComOpenPopupWithTarget(sUrl, 650, 308, "", "0,0", true);
    		if(rVal){
    			//RenderSheet(0);
    			var vslCd=GetCellValue(row, "VVD1");
    			for(var i=0; i < 4 ; i++){
    				if(i == 0){
    					SetCellValue(row+sheet2StatusRowPos, col,"O:" + rVal,0);
    					SetCellValue(row+sheet2StatusRowPos, col+1,"O:" + rVal,0);
	    				for(var j=col+2 ; j <= LastCol()- bufferColCount ;j++){
	    					if(GetCellValue(row, j)!=""){
	    						SetCellValue(row+sheet2StatusRowPos, j,GetCellValue(row, j),0);
	    						SetCellValue(row,j,"",0);//"out_"+GetCellValue(row+i,j);
	    					}
	    				}
    				}
    			}     
    			for(var i=row + 4 ; i <= LastRow(); i ++){
    				if(GetCellValue(i, "VVD1") == vslCd ){
    					SetRowHidden(i,1);
    					SetCellValue(i, "out",vslCd,0);
    				}
    			}
    			// phase out coloring
    			for(var i=col + 2; i<SaveNameCol("skd_rmk"); i++){
    				SetCellBackColor(row, i,"#C8C8C8");
    			}
            	//RenderSheet(1);
    		}*/
    	}
	}
	ComOpenWait(false);
}


function getVal0205(rVal){
	
	var formObj=document.form;
	
	var row=sheet2.GetSelectRow();
	var col=sheet2.GetSelectCol();
	
	if(rVal){
		//RenderSheet(0);
		var vslCd=sheet2.GetCellValue(row, "VVD1");
		for(var i=0; i < 4 ; i++){
			if(i == 0){
				sheet2.SetCellValue(row+sheet2StatusRowPos, col,"O:" + rVal,0);
				sheet2.SetCellValue(row+sheet2StatusRowPos, col+1,"O:" + rVal,0);
				for(var j=col+2 ; j <= LastCol()- bufferColCount ;j++){
					if(sheet2.GetCellValue(row, j)!=""){
						sheet2.SetCellValue(row+sheet2StatusRowPos, j,sheet2.GetCellValue(row, j),0);
						sheet2.SetCellValue(row,j,"",0);//"out_"+GetCellValue(row+i,j);
					}
				}
			}
		}     
		for(var i=row + 4 ; i <= LastRow(); i ++){
			if(sheet2.GetCellValue(i, "VVD1") == vslCd ){
				sheet2.SetRowHidden(i,1);
				sheet2.SetCellValue(i, "out",vslCd,0);
			}
		}
		// phase out coloring
		for(var i=col + 2; i<sheet2.SaveNameCol("skd_rmk"); i++){
			sheet2.SetCellBackColor(row, i,"#C8C8C8");
		}
    	//RenderSheet(1);
	}
	
	
}


function phaseOutCancel(sheetObj)
{
	if(sheetObj.RowCount() < 1){//no data
		ComShowCodeMessage('VSK00080');
		return;
	}
	with(sheetObj){
		var row=GetSelectRow();
		var col=GetSelectCol();
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
    	if(PortPosition(col)==-1 || "skd_rmk"==ColSaveName(col)){
    		ComShowCodeMessage('VSK00080');
    	}else if(GetCellValue(row+sheet2StatusRowPos, col).indexOf("O:")<0){
    		ComShowCodeMessage('VSK00063');
    	}else{
    		ComOpenWait(true);
        	//RenderSheet(0);
        	var vslCd=GetCellValue(row, "VVD1");
        	// 1. Canceling phase out of selected vvd
        	SetCellValue(row+sheet2StatusRowPos, col,"",0);
        	SetCellValue(row+sheet2StatusRowPos, col+1,"",0);
        	for(var i=col + 2; i<SaveNameCol("skd_rmk"); i++){
				SetCellBackColor(row, i,"#FFFFFF");
			}
        	for(var i=col+2 ; i <= LastCol()- bufferColCount ; i++){
        		SetCellValue(row, i,GetCellValue(row+sheet2StatusRowPos, i),0);
				SetCellValue(row+sheet2StatusRowPos, i,"",0);
			}
        	// 2. Canceling phase out of after vvd
			for(var i=row+dataSetCnt ; i <= LastRow(); i=i+dataSetCnt){
				if(vslCd == GetCellValue(i, "out")){
					SetRowHidden(i,0);
					SetCellValue(i, "out","");
				}
			}
        	//RenderSheet(1);
        	ComOpenWait(false);
    	}
	}
}
function phaseIn(sheetObj)
{
	var formObj=document.form;
	with(sheetObj){
		if(!formObj.vsl_slan_cd.value){
			ComShowCodeMessage('VSK00067');
			formObj.vsl_slan_cd.focus();
    		return false;
		}
		var row=GetSelectRow();
		var col=GetSelectCol();
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
		if(sheetObj.RowCount()==0 && sheetObjects[2].RowCount()!=0){
			simplePIN=true;
		}else{
			simplePIN=false;
		}
    	if(!simplePIN && (PortPosition(col)==-1 || "skd_rmk"==sheetObj.ColSaveName(col))){
    		ComShowCodeMessage('VSK00059');
    		return false;
    	}else{
    		ComOpenWait(true);
    		var param="";
    		if(simplePIN){
    			formObj.phasein_col.value=1;
    			formObj.phasein_row.value=0;
    			var firstDir=sheetObjects[2].GetCellValue(sheetObjects[2].HeaderRows(), "skd_dir_cd");
    			var secondDir=sheetObjects[2].GetCellValue(sheetObjects[2].LastRow(), "skd_dir_cd");
    			var skdDirCd;
    			var firstPortCds="";
    			var secondPortCds="";
    			if(firstDir==secondDir){
    				skdDirCd=firstDir;
    			}else{
    				skdDirCd=firstDir + "|" + secondDir;
    			}
    			for(var Row=sheetObjects[2].HeaderRows(); Row<=sheetObjects[2].LastRow(); Row++){
    				if(firstDir==sheetObjects[2].GetCellValue(Row, "skd_dir_cd")){
    					firstPortCds=firstPortCds ? firstPortCds + "|" : "";
    					firstPortCds=firstPortCds + sheetObjects[2].GetCellValue(Row, "port_cd") + " " + sheetObjects[2].GetCellValue(Row, "yd_cd").substring(5, 7);
    				}else if(secondDir==sheetObjects[2].GetCellValue(Row, "skd_dir_cd")){
    					secondPortCds=secondPortCds ? secondPortCds + "|" : "";
    					secondPortCds=secondPortCds + sheetObjects[2].GetCellValue(Row, "port_cd") + " " + sheetObjects[2].GetCellValue(Row, "yd_cd").substring(5, 7);
    				}
    			}
    			param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
    			param += "&vsl_cd="; // + GetCellValue(row, "VVD1");
    			param += "&voy_no="; // + GetCellValue(row, "VVD2");
	    		param += "&dir_cd=" + skdDirCd
	    		//param += "&port_cd=" + sheetObjects[2].CellValue(1, "port_cd");
	    		param += "&first_port_cd=" + firstPortCds;
	    		param += "&second_port_cd=" + secondPortCds;
	    		param += "&phase_type=I";
	    		//param += "&clpt_ind_seq=" + CellValue(4, col);
	    		param += "&src_pf_date=" + ComLpad(ComGetNowInfo("mm"), 2, "0") + "/" +  ComLpad(ComGetNowInfo("dd"), 2, "0") + ComGetNowInfo("yy") + "0000"; 
	    		param += "&parentUI=0010";
    		}else{
    			formObj.phasein_col.value=PortPosition(col);
        		formObj.phasein_row.value=VvdPosition(row) + 1;
	    		param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	    		param += "&vsl_cd="; // + GetCellValue(row, "VVD1");
	    		param += "&voy_no="; // + GetCellValue(row, "VVD2");
	    		param += "&dir_cd=" + GetCellValue(0, col);
	    		param += "&port_cd=" + GetCellValue(1, col);
	    		param += "&phase_type=I";
	    		//param += "&clpt_ind_seq=" + CellValue(4, col);
	    		param += "&src_pf_date=" + GetCellValue(row+1, col);
	    		param += "&parentUI=0010";
    		}
    		var sUrl="/opuscntr/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + "&" + param;
    		var rVal=ComOpenPopupWithTarget(sUrl, 650, 308, "", "0,0", true);
    		if(rVal){
    			formObj.phasein_vsl_cd.value=rVal.vvd.substring(0, 4);
    			formObj.phasein_voy_no.value=rVal.vvd.substring(4, 8);
    			formObj.phasein_start_date.value=rVal.date;
    			if(simplePIN){
    				formObj.phasein_col.value=rVal.phasein_col;
    				col=dataStartCol + ((rVal.phasein_col-1) * 2);
    			}
    			doActionIBSheet(sheetObj,formObj,SEARCH03);
    			if(!simplePIN){
    				// phase in start port expression
	            	SetCellValue(row+sheet2StatusRowPos+dataSetCnt, col,"I:" + rVal.rsn_cd,0);
	            	SetCellValue(row+sheet2StatusRowPos+dataSetCnt, col+1,"I:" + rVal.rsn_cd,0);
	            	// phase in coloring
	            	for(var i=SaveNameCol("VVD3")+1; i<col; i++){
	            		SetCellBackColor(row+dataSetCnt, i,"#C8C8C8");
	            	}
    			}else{
    				// phase in start port expression
//                	CellValue2(dataStartRow+sheet2StatusRowPos, dataStartCol) = "I:" + rVal.rsn_cd; 
//                	CellValue2(dataStartRow+sheet2StatusRowPos, dataStartCol+1) = "I:" + rVal.rsn_cd;
    				SetCellValue(dataStartRow+sheet2StatusRowPos, col,"I:" + rVal.rsn_cd,0);
                	SetCellValue(dataStartRow+sheet2StatusRowPos, col+1,"I:" + rVal.rsn_cd,0);
	            	// phase in coloring
	            	for(var i=SaveNameCol("VVD3")+1; i<col; i++){
	            		SetCellBackColor(row, i,"#C8C8C8");
	            	}
    			}
    		}
    		ComOpenWait(false);
    		if(simplePIN){
    			extend();
    		}
    	}
	}
}
function phaseInCancel(sheetObj){
	var formObj=document.form;
	with(sheetObj){
		var row=GetSelectRow();
		var col=GetSelectCol();
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
    	if(PortPosition(col)==-1 || "skd_rmk"==ColSaveName(col)){
    		ComShowCodeMessage('VSK00059');
    	}else if(GetCellValue(row+sheet2StatusRowPos, col).indexOf("I:")<0){
    		ComShowCodeMessage('VSK00079');
    	}else{
    		ComOpenWait(true);
        	//RenderSheet(0);
        	var targetVslCd=GetCellValue(row, "VVD1");
    		var i=row;
    		while(i<=LastRow()){
    			if(targetVslCd == GetCellValue(i, "VVD1")){
    				RowDelete(i, false);
    			}else{
    				i++;
    			}
    		}
    		//RenderSheet(1);
    		ComOpenWait(false);
    	}
	}
}
 function skipCall(sheetObj)
{
	with(sheetObj){
    	var row=sheetObj.GetSelectRow();
    	var col=sheetObj.GetSelectCol();
    	var value=sheetObj.GetCellValue(row,col);
    	var etbCol=startColPos(sheetObj,0);
    	if(value == "" || value.substring(0,3) == "out" || !etbCol || value == skipvalue){
    		//sheetObj.SelectCell(row,1);
    		return;
    	}
    	// cannot skip Add Call Port
    	if("A"==sheetObj.GetCellValue(row+sheet2StatusRowPos, etbCol)){
    		ComShowCodeMessage("VSK00086");
    		return true;
    	}
    	var linkSkd=findNextLinkSkd(sheetObj, row, etbCol);
    	if(!linkSkd){
    		linkSkd=findPrevLinkSkd(sheetObj, row, etbCol);
    	}
    	if(linkSkd){
    		sheetObj.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol,sheetObj.GetCellValue(linkSkd.tgtRow, linkSkd.tgtCol),0);
    		sheetObj.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1,sheetObj.GetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1),0);
    		sheetObj.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,skipvalue,0);
    		sheetObj.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,skipvalue,0);
    		sheetObj.SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol,"#C0C0C0");
    		sheetObj.SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1,"#C0C0C0");
        	// express skipped port
    		sheetObj.SetCellValue(linkSkd.tgtRow, "skip",1,0);
    	}
    	// Handling SKIP
    	sheetObj.SetCellValue(row+sheet2StatusRowPos, etbCol,sheetObj.GetCellValue(row, etbCol),0);
    	sheetObj.SetCellValue(row+sheet2StatusRowPos, etbCol+1,sheetObj.GetCellValue(row, etbCol+1),0);
    	sheetObj.SetCellValue(row, etbCol,skipvalue,0);
    	sheetObj.SetCellValue(row, etbCol+1,skipvalue,0);
    	sheetObj.SetCellBackColor(row, etbCol,"#C0C0C0");
    	sheetObj.SetCellBackColor(row, etbCol+1,"#C0C0C0");
    	// express skipped port
    	sheetObj.SetCellValue(row, "skip",1,0);
   	}
}
function skipCallCancel(sheetObj)
{
	with(sheetObj){
    	var row=sheetObj.GetSelectRow();
    	var col=sheetObj.GetSelectCol();
    	var value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
    	if(value==skipvalue){
    		var etbCol=startColPos(sheetObj,0);
    		var linkSkd=findPrevLinkSkd(sheetObj, row, etbCol);
    		if(!linkSkd){
    			linkSkd=findNextLinkSkd(sheetObj, row, etbCol);
    		}
        	if(linkSkd){
        		sheetObj.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,sheetObj.GetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol),0);
        		sheetObj.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,GetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1),0);
        		sheetObj.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol,"",0);
        		sheetObj.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1,"",0);
        		sheetObj.SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol,"#FFFFFF");
        		sheetObj.SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1,"#FFFFFF");
            	// express skipped port
        		sheetObj.SetCellValue(linkSkd.tgtRow, "skip",1,0);
        	}
    		// Skip Cancel
        	sheetObj.SetCellValue(row, etbCol, sheetObj.GetCellValue(row+sheet2StatusRowPos, etbCol),0);
        	sheetObj.SetCellValue(row+sheet2StatusRowPos, etbCol,"",0);
        	sheetObj.SetCellBackColor(row, etbCol,"#FFFFFF");
        	sheetObj.SetCellValue(row, etbCol+1,sheetObj.GetCellValue(row+sheet2StatusRowPos, etbCol+1),0);
        	sheetObj.SetCellValue(row+sheet2StatusRowPos, etbCol+1,"",0);
        	sheetObj.SetCellBackColor(row, etbCol+1,"#FFFFFF");
    	}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
    }
    return true;
}
function initControl() {
	var formObj=document.form;
    //axon_event.addListenerForm('blur', 'obj_blur',  formObj);
    axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
    axon_event.addListenerForm('change', 'obj_change', formObj);
    axon_event.addListenerForm('blur', 'obj_deactivate', formObj);
}
/**
 * Handling Enter Key Event
 */
function enter_keypress(){
	VskKeyEnter('btn_Simulation');
}
/**
 * Handling focus out event and Checking validation
 **/
/*function obj_blur(){
    var formObj=document.form;
    switch(event.srcElement.name){
        case "start_date":
        case "end_date":
        	ComChkObjValid(event.srcElement);
        	break;
        default:
    }
    return true;
}*/

function obj_change(){
	var formObj=document.form;
	var sheetObj=null;
    switch(event.srcElement.name){
    	case "selStartQuarter":
        	formObj.start_date.value=ComGetMaskedValue(startQuarterDay(parseInt(formObj.start_year.value),formObj.selStartQuarter.value), "ymd");
        	formObj.start_date.fireEvent("onblur");
            break;
        case "selEndQuarter":
        	formObj.end_date.value=ComGetMaskedValue(endQuarterDay(parseInt(formObj.end_year.value),formObj.selEndQuarter.value), "ymd");
        	formObj.end_date.fireEvent("onblur");
            break;
        case "vsl_cnt":
        	if(formObj.vsl_slan_cd.value==""){
        		ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.vsl_cnt.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
        	formObj.vsl_cnt.value=ComLtrim(formObj.vsl_cnt.value, "0");
        	var vsl_cnt=formObj.vsl_cnt.value;
        	var pf_vsl_cnt=formObj.vsl_count.value;
        	if(vsl_cnt.parseInt() > pf_vsl_cnt.parseInt() ){
        		ComShowCodeMessage("VSK00077", pf_vsl_cnt);
        		formObj.vsl_cnt.value=bakObj;
        		formObj.vsl_cnt.focus();
        		return false;
        	}
        	sheetObjects[0].RenderSheet(0);
        	setColHidden(sheetObjects[0], vsl_cnt);
        	sheetObjects[0].RenderSheet(1);
    	    sheetObj=sheetObjects[0];
    	   // sheetObj.RemoveAll();
    	    /*
    	    InitHeadColumn(leftHeaders,sheetObj);
    	    
    	    var nowInfo=ComGetNowInfo();
            var brth_itval_dys=formObj.brth_itval_dys.value;
            setColHidden(sheetObj, vsl_cnt);
            var headerRow=sheetObj.HeaderRows();
            for(var i=1; i <= vsl_cnt; i++){
           		sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow, "Vsl_" + i,ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys),0);
           		sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow, "Vsl_" + i,formObj.pf_svc_tp_cd.value,0);
           		sheetObj.SetCellAlign(headerRow + sheet1StartDateDataRow, "Vsl_" + i,"Center");
           		sheetObj.SetCellAlign(headerRow + sheet1VslCdDataRow, "Vsl_" + i,"Center");
           		sheetObj.SetCellAlign(headerRow + sheet1VoyNoDataRow, "Vsl_" + i,"Center");
           		sheetObj.SetCellAlign(headerRow + sheet1PfTypeDataRow, "Vsl_" + i,"Center");
            }
            */
            sheetObj=sheetObjects[1];
			//sheetObj.RemoveAll();
			if(sheetObj.LastCol()> 6){
				for(var i=dataStartCol; i<=sheetObj.LastCol()-bufferColCount; i++){
					sheetObj.SetColHidden(i,1);
				}
			}
			adjustEndDate();
        	break;
    }
}

function obj_deactivate(){
	var formObj=document.form;
	var eventValue = ComGetEvent("value");
	switch (ComGetEvent("name")) {
		case "vsl_slan_cd":
			if(eventValue=="" || ComChkLen(eventValue, 3)!=2){
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != eventValue){
				sheetObj=sheetObjects[1];
				formObj.pf_svc_tp_cd.value='';
				//sheetObj.RemoveAll();
				if(sheetObj.LastCol()> 6){
					for(var i=4; i<=sheetObj.LastCol()-3; i++){
						sheetObj.SetColHidden(i,1);
					}
				}
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
		case "end_date":
			// end_date < start_date, exception
			sheetObj=sheetObjects[0];
			if(sheetObj.RowCount() <1 ) return;
			var vslStartDate=sheetObj.GetCellValue(1, formObj.vsl_cnt.value);
			if(vslStartDate){
				if(eventValue < vslStartDate){
					ComShowCodeMessage("VSK00013");
					eventValue=ComGetMaskedValue(bakObj, "ymd");
					return false;
				}
			}
		break;
	}
}
function sheet1_OnDblClick(sheetObj, Row, Col){
	var formObj=document.form;
	var datarow=Row - sheetObj.HeaderRows();
	if(datarow == sheet1PfTypeDataRow){	// PF Skd Type Code Change
//		alert("ondblclick");
		openPfTypePopup(sheetObj, Row);
	}else if(datarow==sheet1StartDateDataRow){
		sheetObj.SelectCell(Row, Col);
	}
}
function makeFormString(formObj, sheetObj1, sheetObj2, sheetObj3){
	var sParam=FormQueryString(formObj) + "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
	var sParamSheet1="";
	var sParamSheet2="";
	var sParamSheet3="";
	if(sheetObj1!=null){ 
		sParamSheet1=ComGetSaveString(sheetObj1,true,true,-1);
		//alert(sParamSheet1 );
	}
	if(sheetObj2!=null){
		sParamSheet2=ComGetSaveString(sheetObj2);
	}
	if(sheetObj3!=null){
		
		sParamSheet3=ComGetSaveString(sheetObj3,true,true,-1);
		//alert("sParamSheet3\n\n\n" + sParamSheet3 );
		/*
		alert(sParamSheet3 );
		var str = "";
		for(var i=2 ; i< 23 ; i++ ){
			str += "&"+ sheetObj3.GetCellValue(0,i) + "=" + sheetObj3.GetCellValue(sheetObj3.HeaderRows(),i);
		}
		*/
		
	}
	if(sParamSheet1 != ""){
		sParam=sParam + "&" + sParamSheet1;
	}
	if(sParamSheet2 != ""){
		sParam=sParam + "&" + sParamSheet2;
	}
	if(sParamSheet3 != "" ){
		sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
		//sParam=sParam + "&" + ComSetPrifix(str, "sheet3_");
	}

	return sParam;
}
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj=document.form;
	var datarow=Row - sheetObj.HeaderRows();
	if(datarow==sheet1StartDateDataRow){
	    var cal=new ComCalendarGrid("myCal");
	    cal.select2(formObj.start_date, sheetObj, Row, Col, 'yyyy-MM-dd');
	}else if(datarow==sheet1PfTypeDataRow){
//		alert("onpopupclick");
		openPfTypePopup(sheetObj, Row);
	}
}

function callBackVopVsk0212(rtnVal){
	var formObj=document.form;

	if(rtnVal){
	formObj.pf_svc_tp_cd.value =rtnVal;
	
	if(formObj.pf_svc_tp_cd.value!=""){
			for(var i=1; i<sheet1.LastCol(); i++){
				sheet1.SetCellValue(callback_row, i,rtnVal,0);
			}
			doActionIBSheet(sheet1, formObj, SEARCH09);
		}
		HeadCol1="";
		HeadCol2="";
		HeadCol3="";
		HeadCol4="";
		HeadCol5="";
		HeadCol6="";
		//sheetObjects[1] = sheetObjects[1].Reset();
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
	}
}
var callback_row = "";
function openPfTypePopup(sheetObj, Row){
	callback_row = Row;
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0212_POP.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	var rValue=ComOpenPopup(sUrl, 500, 407, "callBackVopVsk0212", "0,0", true); // pf_svc_tp_cd:pf_svc_tp_cd
	
}
/**
 * handling process for input validation
 */
function valid(sheetObj, formObj) {
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
	var headerRows=sheetObjects[0].HeaderRows();
	if(!simplePIN){
		for(var i=1; i<=4; i++){
			for(var k=1; k<=formObj.vsl_cnt.value; k++){
				if(sheetObj.GetCellValue(i, "Vsl_" + k)==''){
					check=false;
					if(i==headerRows + sheet1StartDateDataRow){
						ComShowCodeMessage('VSK00027', 'Start Date');
					}else if(i==headerRows + sheet1VslCdDataRow){
						ComShowCodeMessage('VSK00027', 'Vessel Code');
					}else if(i==headerRows + sheet1VoyNoDataRow){
						ComShowCodeMessage('VSK00027', 'Start Voy No');
					}else if(i==headerRows + sheet1PfTypeDataRow){
						ComShowCodeMessage('VSK00027', 'P/F SKD Type');
					}
					break;
				}
			}
			if(!check){
				break;
			}
		}
	}
	return check;
}
/**
 * Finding count of Add Call at selected port
 * 
 * @param sheetObj
 * @param col
 * @return
 */
function countAdding(sheetObj, col){
	var count=0;
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
if("A"==sheetObj.GetCellValue(i, col)){
			count++;
		}
	}
	return count;
}
/**
 * Finding count of Add Call at selected port
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function countAddCallPort(sheetObj, row, col){
	var count=0;
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
if("A"==sheetObj.GetCellValue(i, col)){
			count++;
		}
	}
	// if selected port is Add Port, Returning 0 
if(""!=sheetObj.GetCellValue(row, col) && "A"==sheetObj.GetCellValue(row+sheet2StatusRowPos, col)){
		return 0;
	}
	return count;
}
/**
 * Finding Same SKD
 */
function findNextLinkSkd(sheetObj, Row, Col){
	var vslCd=sheetObj.GetCellValue(Row, "VVD1");
	var portCd=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, Col);
	var clptIndSeq=sheetObj.GetCellValue(sheet2ClptIndSeqHeaderRow, Col);
	var etbDt=sheetObj.GetCellValue(Row, Col);
	var etdDt=sheetObj.GetCellValue(Row, Col+1);
	var find=false;
	var skipSkd=false;
	if(etbDt==skipvalue && etdDt==skipvalue){
		skipSkd=true;
	etbDt=sheetObj.GetCellValue(Row+sheet2StatusRowPos, Col);
	etdDt=sheetObj.GetCellValue(Row+sheet2StatusRowPos, Col+1);
	}
	var tgtSkd=new Object();
	var tgtCol=0;
	var tgtRow=0;
	for(var j=dataStartCol; j<Col; j++){
	if(sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, j)==portCd &&
	sheetObj.GetCellValue(sheet2ClptIndSeqHeaderRow, j)==clptIndSeq
		){	// Finding same Port(port_cd, clpt_ind_seq)
			tgtCol=j;
			break;
		}
	}
	if(tgtCol==0){
		return false;
	}
	// Finding SKD with same Vessel Code, ETB, ETD in Target Col
	for(var i=Row+dataSetCnt; i<sheetObj.LastRow(); i=i+dataSetCnt){
		if(sheetObj.GetCellValue(i, "VVD1")==vslCd){
				if(!skipSkd){
					if(sheetObj.GetCellValue(i, tgtCol)==etbDt && sheetObj.GetCellValue(i, tgtCol+1)==etdDt){
					tgtRow=i;
					find=true;
					break;
				}
			}else{
				if(sheetObj.GetCellValue(i+sheet2StatusRowPos, tgtCol)==etbDt && sheetObj.GetCellValue(i+sheet2StatusRowPos, tgtCol+1)==etdDt){
					tgtRow=i;
					find=true;
					break;
				}
			}
		}
	}
	if(find){
		tgtSkd.tgtRow=tgtRow;
		tgtSkd.tgtCol=tgtCol;
		return tgtSkd;
	}else{
		return false;
	}
}
/**
 * Finding same SKD
 */
function findPrevLinkSkd(sheetObj, Row, Col){
	var vslCd=sheetObj.GetCellValue(Row, "VVD1");
	var portCd=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, Col);
	var clptIndSeq=sheetObj.GetCellValue(sheet2ClptIndSeqHeaderRow, Col);
	var etbDt=sheetObj.GetCellValue(Row, Col);
	var etdDt=sheetObj.GetCellValue(Row, Col+1);
	var find=false;
	var skipSkd=false;
	if(etbDt==skipvalue && etdDt==skipvalue){
		skipSkd=true;
	etbDt=sheetObj.GetCellValue(Row+sheet2StatusRowPos, Col);
	etdDt=sheetObj.GetCellValue(Row+sheet2StatusRowPos, Col+1);
	}
	var tgtSkd=new Object();
	var tgtCol=0;
	var tgtRow=0;
	for(var j=Col+2; j<sheetObj.LastCol(); j++){
		if(sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, j)==portCd &&
		sheetObj.GetCellValue(sheet2ClptIndSeqHeaderRow, j)==clptIndSeq
			){	// Finding same Port(port_cd, clpt_ind_seq)
			tgtCol=j;
			break;
		}
	}
	if(tgtCol==0){
		return false;
	}
	// Finding SKD with same Vessel Code, ETB, ETD in Target Col
	for(var i=sheetObj.HeaderRows(); i<Row; i=i+dataSetCnt){
		if(sheetObj.GetCellValue(i, "VVD1")==vslCd){
			if(!skipSkd){
				if(sheetObj.GetCellValue(i, tgtCol)==etbDt && sheetObj.GetCellValue(i, tgtCol+1)==etdDt){
					tgtRow=i;
					find=true;
					break;
				}
			}else{
				if(sheetObj.GetCellValue(i+sheet2StatusRowPos, tgtCol)==etbDt && sheetObj.GetCellValue(i+sheet2StatusRowPos, tgtCol+1)==etdDt){
					tgtRow=i;
					find=true;
					break;
				}
			}
		}
	}
	if(find){
		tgtSkd.tgtRow=tgtRow;
		tgtSkd.tgtCol=tgtCol;
		return tgtSkd;
	}else{
		return false;
	}
}
/**
 * Returning last date of quarter
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
/**
 * Returning last date of quarter
 */
function checkQuarter(date){
	var month_date=date.substring(4, 8);
	if(month_date <= "0331"){
		return "1";
	}else if(month_date <= "0630"){
		return "2";
	}else if(month_date <= "0930"){
		return "3";
	}else{
		return "4";
	}
}
function adjustEndDate(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vslCnt=formObj.vsl_cnt.value;
	var headerRows=sheetObj.HeaderRows();
	var iVslCnt=vslCnt.parseInt();
	if(iVslCnt > 0 && ComGetDaysBetween( formObj.end_date.value, sheetObj.GetCellValue(headerRows + sheet1StartDateDataRow, "Vsl_" + vslCnt))>=0){
		var quarterDate=getQuarterEndDate(sheetObj.GetCellValue(headerRows + sheet1StartDateDataRow, "Vsl_" + vslCnt));
    	formObj.end_year.value=quarterDate.substring(0, 4);
    	formObj.end_date.value=ComGetMaskedValue(quarterDate, "ymd");
    	formObj.selEndQuarter.value=checkQuarter(quarterDate);
    }
}
function mergeHeaderCell(){
	var sheetObj=sheetObjects[1];
	var formObj=document.form;
}
function checkTargetPortIsAddPort(sheetObj, Row, Col){
	var formObj=document.form;
	var orgDirCd=sheetObj.GetCellValue(sheet2DirCdHeaderRow, Col);
	var usrPortCd=formObj.add_call_port_cd.value;
	var usrYardCd=formObj.add_call_yard_cd.value;
	var usrCallPosition=formObj.add_call_position.value;
	var targetPortCd="";
	var targetYardCd="";
	var targetDirCd="";
	var targetCol=0;
	if("before"==usrCallPosition){
		targetCol=Col - 2;
	}else if("after"==usrCallPosition){
		targetCol=Col + 2;
	}
if(""!=sheetObj.GetCellValue(Row, targetCol)){
		return false;
	}else{
	targetPortCd=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, targetCol);
	targetYardCd=sheetObj.GetCellValue(sheet2YdCdHeaderRow, targetCol);
	targetDirCd=sheetObj.GetCellValue(sheet2DirCdHeaderRow, targetCol);
		if((targetPortCd==usrPortCd) && (targetDirCd==orgDirCd) && (targetYardCd==usrYardCd))
		{
			return true;
		}else{
			return false;
		}
	}
	return false;
}
/*
 * Finding Last SKD of Vessel
 */
function isFinalVVD(sheetObj, Row){
var tgtVslCd=sheetObj.GetCellValue(Row, "VVD1");
	var finalVVD=true;
	with(sheetObj){
		for(var i=Row + dataSetCnt; i < HeaderRows()+ RowCount(); i=i+dataSetCnt){
			if(tgtVslCd==GetCellValue(i, "VVD1")){
				finalVVD=false;
				break;
			}
		}
	}
	return finalVVD;
}
/*
 * Finding Last SKD before selected Row of Vessel
 */
function findLastSkd(sheetObj, Row){
	var tgtVslCd=sheetObj.GetCellValue(Row, "VVD1");
	var lastSkd=null;
	var tgtRow="";
	var tgtCol="";
	with(sheetObj){
		for(var i=HeaderRows(); i < Row; i=i+dataSetCnt){
			if(tgtVslCd==GetCellValue(i, "VVD1")){
				tgtRow=i;
			}
		}
		if(tgtRow==""){
			return null;
		}
		// Finding Last Port of P/F
		for(var i=LastCol()-2; i >3; i=i-2 ){
			// Skip Added Port
			if(""==GetCellValue(2, i) || "*"==GetCellValue(2, i)){
				continue;
			}else{
				tgtCol=i;
				break;
			}
		}
		if(tgtRow=="" && tgtCol==""){
			return null;
		}else{
			lastSkd=new Object();
			lastSkd.row=tgtRow;
			lastSkd.col=tgtCol - 1;
			return lastSkd;
		}
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
function obj_propertychange(){
	var srcName=ComGetEvent("name");		
	var formObj=document.form;
	var eventElement=event.srcElement;
	switch(srcName){
		case "start_date":
			var Col=0;
			var sheetObj=sheetObjects[0];
			for(var i=1; i <= formObj.vsl_cnt.value; i++){
				if(ComReplaceStr(eventElement.value, "-", "") == sheetObj.GetCellValue(sheetObj.HeaderRows()+ sheet1StartDateDataRow, "Vsl_" + i)){
					Col=i;
					break;
				}
			}
			if(Col > 0){
				adjustStartDate(sheetObj, Col, eventElement.value);
			}
			break;
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
    adjustEndDate();
}
function manageStartInfo(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
    var brth_itval_dys=Number(formObj.brth_itval_dys.value);
    var nowInfo=ComGetNowInfo();
    var headerRow=sheetObj.HeaderRows();
    //sheetObj.RenderSheet(0);
    setColHidden(sheetObj,parseInt(formObj.vsl_cnt.value));
    for(var i=1; i <= formObj.vsl_cnt.value; i++){
//    	alert((i-1)*brth_itval_dys);
//    	alert(ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys));
   		sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow, "Vsl_" + i,ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys),0);
   		sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow, "Vsl_" + i,formObj.pf_svc_tp_cd.value,0);
   		sheetObj.SetCellAlign(headerRow + sheet1StartDateDataRow, "Vsl_" + i,"Center");
   		sheetObj.SetCellAlign(headerRow + sheet1VslCdDataRow, "Vsl_" + i,"Center");
   		sheetObj.SetCellAlign(headerRow + sheet1VoyNoDataRow, "Vsl_" + i,"Center");
   		sheetObj.SetCellAlign(headerRow + sheet1PfTypeDataRow, "Vsl_" + i,"Center");
    }
    adjustEndDate();
    //sheetObj.RenderSheet(1);
}
function extend(){
	var objs=document.all.item("startinfo");
    if (!extendFlag) {
    	sheet1.SetVisible(0);
//    	h1=sheetObjects[0].GetSheetHeight().replace(/[^0-9]/g, "") ;
//    	h2=sheetObjects[1].GetSheetHeight().replace(/[^0-9]/g, "") ;  
    	//sheet1.RenderSheet(0);
    	//objs.style.display="none";
    	//sheet1.RenderSheet(1);
    	//sheet2.RenderSheet(0);
//    	sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 20));

//	    sheetObjects[1].SetSheetHeight(Number(h1) + Number(h2) + 1);
	    //sheet1.RenderSheet(1);
	    document.getElementById("btn_Extend").style.display="none";
	    document.getElementById("btn_Reduce").style.display="inline";
	    extendFlag=true;
	}
}
function reduce(){
	var objs=document.all.item("startinfo");
    if ( extendFlag ) {
    	sheet1.SetVisible(1);
//    	h1=sheetObjects[0].GetSheetHeight().replace(/[^0-9]/g, "") ;
//    	h2=sheetObjects[1].GetSheetHeight().replace(/[^0-9]/g, "") ;
    	//sheet2.RenderSheet(0);
    	
    	sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, sheet1DataRows));
	    //sheet2.RenderSheet(1);
	    //sheet1.RenderSheet(0);
	    //objs.style.display="inline";
	    //sheet1.RenderSheet(1);
	    document.getElementById("btn_Extend").style.display="inline";
	    document.getElementById("btn_Reduce").style.display="none";
	    extendFlag=false;
	}
}
function manageSheetSize(){
//	alert("init height=" + parentInitWinHeight);
	var curWinHeight=parent.window.document.body.clientHeight;
//	alert("current height=" + curWinHeight);
	var curMainHeight=parent.window.document.getElementById("main").GetSheetHeight().replace(/[^0-9]/g, "");
	var sheetHeight=sheetObjects[1].GetSheetHeight().replace(/[^0-9]/g, "");
	//sheetObjects[1].RenderSheet(0);
	if(curWinHeight<=parentInitWinHeight){
		parent.window.document.getElementById("main").SetSheetHeight(initMainHeight);
		sheetObjects[1].SetSheetHeight(322);
	}else if(curWinHeight>parentInitWinHeight){
		var gap=Number(curWinHeight) - Number(parentInitWinHeight);
		parent.window.document.getElementById("main").SetSheetHeight(Number(curMainHeight) + Number(gap));
		sheetObjects[1].SetSheetHeight(Number(sheetHeight) + parseInt(gap/20)*20);
	}
	//sheetObjects[1].RenderSheet(1);
	return false;
}
/*
 * Getting Vessel List in simulated SKD
 */
function getVesselList(){
	var sheetObj=sheetObjects[1];
	if(sheetObj.RowCount()>0){
		var vesselList=new Array();
		var idx=0;
		for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+sheetObj.RowCount(); Row++){
			if(!vesselList[sheetObj.GetCellValue(Row, "VVD1")]){
				vesselList[idx++]=sheetObj.GetCellValue(Row, "VVD1");
				vesselList[sheetObj.GetCellValue(Row, "VVD1")]=sheetObj.GetCellValue(Row, "VVD1");
			}
		}
		return vesselList;
	}
}

function sheet1_left_Reset( sheetObj  ){
	 sheetObj.SetRowHidden(sheet1PfDateDataRow+sheetObj.HeaderRows(),1);// Hidden PF_DATE
     for(var i=0 ; i <5 ; i++){
			for ( var j = 1; j < 20; j++) {
				if (i == sheet1VslCdDataRow+1) {
					sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N|E" , InputCaseSensitive:1});
				} else if (i == sheet1VoyNoDataRow+1) {
					sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N"});
				} else if (i == sheet1PfTypeDataRow+1) {
					sheetObj.InitCellProperty(i, j, {Type:"Popup", Format:""});
				} 
			}
		}
}
function sheet1_OnSearchEnd(sheetObj , code , msg ){
	   if( sheetObj.RowCount() < 1){
	          InitHeadColumn(leftHeaders,sheetObj);
	          
	    } else {
	     InitHeadText(leftHeaders,sheetObj);
	     sheet1_left_Reset(sheetObj);
	   }
	}