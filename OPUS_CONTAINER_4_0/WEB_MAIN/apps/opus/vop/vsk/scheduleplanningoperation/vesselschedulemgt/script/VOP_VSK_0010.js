/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0010.js
 *@FileTitle : Long Range SKD Creation
 *Open Issues :
 *Change history : 
 *@LastModifyDate : 
 *@LastModifier :   
 *@LastVersion : 1.0
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
var dataStartRow=6;
var bufferColCount=2;
var dataSetCnt=4;
var HeadCol1=""; // SKD_DIR_CD
var HeadCol2=""; // VPS_PORT_CD
var HeadCol3=""; // ETB_DY_CD/ETD_DY_CD
var HeadCol4=""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol5=""; // P/F CLPT_SEQ
var HeadCol6=""; // YARD_CD
var HeadCol21=""; // SKD_DIR_CD
var HeadCol22=""; // VPS_PORT_CD
var HeadCol23=""; // ETB_DY_CD/ETD_DY_CD
var HeadCol24=""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol25=""; // P/F CLPT_SEQ
var HeadCol26=""; // YARD_CD
var HeadCol31=""; // SKD_DIR_CD
var HeadCol32=""; // VPS_PORT_CD
var HeadCol33=""; // ETB_DY_CD/ETD_DY_CD
var HeadCol34=""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol35=""; // P/F CLPT_SEQ
var HeadCol36=""; // YARD_CD
var bakObj=null;
var skipvalue=" SKIP";
var pfSkdValidation=null;
var sheet1DataRows=5; // count of rows in sheet1
var sheet1ViewDataRows=4; // count of shown rows in sheet1
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
var sheet4DirCdHeaderRow=0;
var sheet4VpsPortCdHeaderRow=1;
var sheet4DyCdHeaderRow=2;
var sheet4TmHrmntHeaderRow=3;
var sheet4ClptIndSeqHeaderRow=4;
var sheet4YdCdHeaderRow=5;
var sheet4InitDateRowPos=1;
var sheet4PfDateRowPos=2;
var sheet4StatusRowPos=3;
var sheet5DirCdHeaderRow=0;
var sheet5VpsPortCdHeaderRow=1;
var sheet5DyCdHeaderRow=2;
var sheet5TmHrmntHeaderRow=3;
var sheet5ClptIndSeqHeaderRow=4;
var sheet5YdCdHeaderRow=5;
var sheet5InitDateRowPos=1;
var sheet5PfDateRowPos=2;
var sheet5StatusRowPos=3;
var simplePIN=false;
var extendFlag=false;
var pf_svc_tp_cd="";
var HeadCnt="1"
var uSheet="sheet1";
var uRow="0";
var uCol="0";
var vessels=null;
var countCallBack=0;
var sheetMaxCol = 20;
//var parentInitWinHeight = 0;
//var initMainHeight = 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     var sheetObject4=sheetObjects[3];
     var sheetObject5=sheetObjects[4];
     /*******************************************************/
     var formObj=document.form;
     try {
    	 var srcName=ComGetEvent("name");
         if (!ComIsBtnEnable(srcName)) return;  
    	 switch(srcName) {
    		case "btns_search1":    			
    			var v_display="0,0";
    			var laneCd = formObj.vsl_slan_cd.value;
    			ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "callBackVopVsk0202", v_display, true);
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
				var check=valid(sheetObject1, formObj);
				if(sheet2.RowCount()==0){
					// not simulated SKD
					return false;
				}
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
						doActionIBSheet(sheetObject2,document.form,IBSAVE);
					}
				}
				break;
			case "btn_Simulation":
				if(ComIsBtnEnable('btn_Simulation')){
					formObj.op_type.value="btn_SimulationMultiple";
					if(pfSkdValidation==false){
						return false;
					}
					// if P/F Duration has ".", exception
//					if(formObj.svc_dur_dys.value.indexOf(".")>-1){
//						ComShowCodeMessage("VSK00096", "Duration");
//						return false;
//					}
					//Voyage No : Diration(Add One) 이고 "0"인 경우
					if(document.getElementById("voy_no_type").value == "1" 
						&& (document.getElementById("voy_type_cnt").value == "0" || document.getElementById("voy_type_cnt").value == "")){
						ComShowCodeMessage("COM12133","Inputted interval Number","0","large");
						return false;
					}
					bkgVVDs=new Array();
					virVVDs=new Array();
					bkgVirVVDs=new Array();
					nonBkgVVDs=new Array();
					var check=false;
					var headerRows=sheetObjects[0].HeaderRows();
					for(var k=1; k<=formObj.vsl_cnt.value; k++){
						for(var i=1; i<=4; i++){
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
						if(k>2 && sheetObject1.GetCellValue(2,"Vsl_"+(k-2))+sheetObject1.GetCellValue(3,"Vsl_"+(k-2))==sheetObject1.GetCellValue(2,"Vsl_"+k)+sheetObject1.GetCellValue(3,"Vsl_"+k)){
							ComShowCodeMessage('VSK00085');
							sheetObject1.SetCellValue(3,"Vsl_"+k,"");
							check=false;
							break
						} 
						if(k>1 && sheetObject1.GetCellValue(2,"Vsl_"+(k-1))+sheetObject1.GetCellValue(3,"Vsl_"+(k-1))==sheetObject1.GetCellValue(2,"Vsl_"+k)+sheetObject1.GetCellValue(3,"Vsl_"+k)){
							ComShowCodeMessage('VSK00085');
							sheetObject1.SetCellValue(3,"Vsl_"+k,"");
							check=false;
							break
						}
					}
					if(check){
						vessels = new Array();
						var pfSvcTpCdDup = [];
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
   						// Checking voyage per vessel code
						for(var i=1,j=0,k=0; i<sheetObj.LastCol(); i++){
							if(sheetObj.GetCellValue(2, i)!="" && sheetObj.GetCellValue(2, i).length == 4 && formObj.vsl_cnt.value >= i){
								var obj=new Object();
								obj.startDate=sheetObj.GetCellValue(sheet1StartDateDataRow + sheetObj.HeaderRows(), i);
								obj.vslCd=sheetObj.GetCellValue(sheet1VslCdDataRow + sheetObj.HeaderRows(), i);
								obj.skdVoyNo=sheetObj.GetCellValue(sheet1VoyNoDataRow + sheetObj.HeaderRows(), i);
								obj.pfSvcTpCd=sheetObj.GetCellValue(sheet1PfTypeDataRow + sheetObj.HeaderRows(), i);
								obj.voyNo="";
								obj.skdDirCd1="";
								obj.skdDirCd2="";
								obj.duration="";
								vessels[k++]=obj;
								pfSvcTpCdDup[j++] = obj.pfSvcTpCd;
							}
						}
						//skd type 3
						pfSvcTpCdDup =  getArrayRemoveDupVal(pfSvcTpCdDup);
						if(pfSvcTpCdDup.length > 3){
							ComShowCodeMessage('VSK55009');
							return false;
						}
						countCallBack = 0;
						if(vessels.length > 0){
							var sUrl="/opuscntr/VOP_VSK_0211_POP.do";
							sUrl=sUrl + "?vsl_cd=" + vessels[0].vslCd 
										   + "&skd_voy_no=" + vessels[countCallBack].skdVoyNo 
										   + "&start_date=" + vessels[countCallBack].startDate
										   + "&end_date=" + formObj.end_date.value
										   + "&vsl_cnt=" + formObj.vsl_cnt.value
										   + "&voy_no_type=" + formObj.voy_no_type.value
										   + "&voy_type_cnt=" + formObj.voy_type_cnt.value
										   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
										   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
										   + "&duration=" + formObj.svc_dur_dys.value;
							ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);
							countCallBack++;
						}
						
//						for(var i=0; i<vessels.length; i++){
//							var sUrl="/opuscntr/VOP_VSK_0211.do"; 
//							sUrl=sUrl + "?vsl_cd=" + vessels[i].vslCd 
//										   + "&skd_voy_no=" + vessels[i].skdVoyNo 
//										   + "&start_date=" + vessels[i].startDate
//										   + "&end_date=" + formObj.end_date.value
//										   + "&vsl_cnt=" + formObj.vsl_count.value
//										   + "&voy_no_type=" + formObj.voy_no_type.value
//										   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
//										   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
//										   + "&voy_type_cnt=" + formObj.voy_type_cnt.value
//										   + "&duration=" + getSvcDurDys(vessels[i].pfSvcTpCd);
//							var rVal = ComOpenPopupWithTarget(sUrl, 800, 600, "", "0,0", true);
//							if (rVal) {
//								bkgVVDs=bkgVVDs.concat(rVal.bkgVVDs);
//								virVVDs=virVVDs.concat(rVal.virVVDs);
//								bkgVirVVDs=bkgVirVVDs.concat(rVal.bkgVirVVDs);
//								nonBkgVVDs=nonBkgVVDs.concat(rVal.nonBkgVVDs);
//								continue;
//							}else{
//								return false;
//							}
//						}
//						doActionIBSheet(sheetObject2,formObj,SEARCH02);
					}
				}
				break;
			case "btn_Delete":
//				var row = sheetObject2.SelectRow;
//				var col = sheetObject2.SelectCol;
				var row=uRow;
				var col=uCol;
				if(row<6){
					// Cannot delete header
					ComShowCodeMessage('VSK00061');
				}else{
					var vvd=uSheet.GetCellValue(row, "VVD1") + uSheet.GetCellValue(row, "VVD2") + uSheet.GetCellValue(row, "VVD3");
					
					if (ComShowCodeConfirm("VSK00062", vvd)) {
						// Checking VVD is the last skd of Vessel
						if(isFinalVVD(uSheet, row)){
							// Deleting Last Port Schedule
							lastSkd=findLastSkd(uSheet, row);
							if(lastSkd){
								uSheet.SetCellValue(lastSkd.row, lastSkd.col,"",0);
								uSheet.SetCellValue(lastSkd.row, lastSkd.col+1,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2InitDateRowPos, lastSkd.col,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2InitDateRowPos, lastSkd.col+1,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2PfDateRowPos, lastSkd.col,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2PfDateRowPos, lastSkd.col+1,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2StatusRowPos, lastSkd.col,"",0);
								uSheet.SetCellValue(lastSkd.row+sheet2StatusRowPos, lastSkd.col+1,"",0);
							}
						}else{
							// Deleting linked SKD
							linkSkd=findPrevLinkSkd(uSheet, row, uSheet.SaveNameCol("VVD3") + 1);
							if(linkSkd){
								uSheet.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol   ,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol+1 ,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2PfDateRowPos  , linkSkd.tgtCol   ,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2PfDateRowPos  , linkSkd.tgtCol+1 ,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos  , linkSkd.tgtCol   ,"",0);
								uSheet.SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos,   linkSkd.tgtCol+1 ,"",0);
							}									
						}
						uSheet.RowDelete(row, false);
						uSheet.RowDelete(row, false);
						uSheet.RowDelete(row, false);
						uSheet.RowDelete(row, false);
					}
				}
				break;
			case "btn_PhaseIn":
					formObj.op_type.value="btn_PhaseIn";
					phaseIn(sheetObject2);
					sheet2_SetColor(sheetObject2);
				break;
			case "btn_PhaseInCancel":
					formObj.op_type.value="btn_PhaseInCancel";
					phaseInCancel(sheetObject2);
					sheet2_SetColor(sheetObject2);
				break;
			case "btn_PhaseOut":	
				if (typeof(uSheet) == "object") {
					formObj.op_type.value="btn_PhaseOut";
					phaseOut(uSheet,"VVD1");
				}					
				break;
			case "btn_PhaseOutCancel":
				if (typeof(uSheet) == "object") {
					formObj.op_type.value="btn_PhaseOutCancel";
					phaseOutCancel(uSheet);
				}
				break;
			case "btn_AddCall":
					formObj.op_type.value="btn_AddCall";
					var row=uSheet.GetSelectRow();
					var col=uSheet.GetSelectCol();
					var addTargetCol=0;
					col=startColPos(uSheet, 0);
					// after getting add call information, Initializing selection data of sheet
					uSheet.SelectCell(row, 1, false);
					formObj.add_call_point.value=PortPosition(col);
					formObj.add_vvd_point.value=VvdPosition(uSheet.GetSelectRow());
					if(formObj.add_call_point.value==-1 || "skd_rmk"==uSheet.ColSaveName(col)){
	            		ComShowCodeMessage('VSK00059');
	            		break;
	            	}
	            	// Getting Add Call information
	            	var sUrl="";
//	            	if(countAddCallPort(sheetObject2, row, col)>0){
	            	if(countAddCallPort(uSheet, row, col)>0){
	            		// in case of already add call, blocking to change port code
//	            		sUrl = "/opuscntr/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y&portCd=" + sheetObject2.CellValue(sheet2VpsPortCdHeaderRow, col) + "&ydCd=" +  sheetObject2.CellValue(sheet2YdCdHeaderRow, col);
	            		sUrl="/opuscntr/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y&portCd=" + uSheet.GetCellValue(sheet2VpsPortCdHeaderRow, col) + "&ydCd=" +  uSheet.GetCellValue(sheet2YdCdHeaderRow, col);
	            	}else{
	            		sUrl="/opuscntr/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y";
	            	}
	            	
	            	ComOpenPopup(sUrl, 510, 320, "getVal0215", "0,0", true); 
					
				break;
			case "btn_AddCallCancel":
					formObj.op_type.value="btn_AddCallCancel";
//					var row = sheetObject2.SelectRow;
//					var col = sheetObject2.SelectCol;
					var row=uSheet.GetSelectRow();
					var col=uSheet.GetSelectCol();
//					col = startColPos(sheetObject2, 0);
					col=startColPos(uSheet, 0);
					formObj.add_call_point.value=PortPosition(col);
//					formObj.add_vvd_point.value = VvdPosition(sheetObject2.SelectRow);
					formObj.add_vvd_point.value=VvdPosition(uSheet.GetSelectRow());
//					if(formObj.add_call_point.value==-1 || "skd_rmk"==sheetObject2.ColSaveName(col)){
					if(formObj.add_call_point.value==-1 || "skd_rmk"==uSheet.ColSaveName(col)){
						ComShowCodeMessage('VSK00059');
						break;
					}
//					if("A"!=sheetObject2.CellValue(row+sheet2StatusRowPos, col)){
					if("A"!=uSheet.GetCellValue(row+sheet2StatusRowPos, col)){
						ComShowCodeMessage('VSK00060');
						break;
					}
//					if(countAdding(sheetObject2, col)>1){
//						// Add Calling more than twice
//						sheetObject2.CellValue2(row, col) = "";
//						sheetObject2.CellValue2(row, col+1) = "";
//						sheetObject2.CellValue2(row+sheet2InitDateRowPos, col) = "";
//						sheetObject2.CellValue2(row+sheet2InitDateRowPos, col+1) = "";
//						sheetObject2.CellValue2(row+sheet2StatusRowPos, col) = "";
//						sheetObject2.CellValue2(row+sheet2StatusRowPos, col+1) = "";
//					}else if(countAdding(sheetObject2, col)==1){
//						// in case of first Add Call, deleting column
//						doActionIBSheet(sheetObject2,formObj,SEARCH06);
//        			}
					if(countAdding(uSheet, col)>1){
						// Add Calling more than twice
						uSheet.SetCellValue(row, col,"",0);
						uSheet.SetCellValue(row, col+1,"",0);
						uSheet.SetCellValue(row+sheet2InitDateRowPos, col,"",0);
						uSheet.SetCellValue(row+sheet2InitDateRowPos, col+1,"",0);
						uSheet.SetCellValue(row+sheet2StatusRowPos, col,"",0);
						uSheet.SetCellValue(row+sheet2StatusRowPos, col+1,"",0);
					}else if(countAdding(uSheet, col)==1){
						// in case of first Add Call, deleting column
						doActionIBSheet(uSheet,formObj,SEARCH06);
        			}
//				sheet2_SetColor(sheetObject2);
				sheet2_SetColor(uSheet);
				break;
			case "btn_SkipCall":
				if (typeof(uSheet) == "object") {
					formObj.op_type.value="btn_SkipCall";
					skipCall(uSheet);
				}
				break;
			case "btn_SkipCallCancel":
				if (typeof(uSheet) == "object") {
					formObj.op_type.value="btn_SkipCallCancel";
					skipCallCancel(uSheet);
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
	
	if(formObj.vsl_cnt.value != "0" && formObj.vsl_cnt.value != "") {
		setGetColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
	}
	btnEnabled(true);
	initVoyType();	
}
/** 
 * Initializing Screen
 */
function initPage() {
	
	var formObj=document.form;
	
	reduce();
    
	HeadCol1  = "";
    HeadCol2  = "";
    HeadCol3  = "";
    HeadCol4  = "";
    HeadCol5  = "";
    HeadCol6  = "";
    HeadCol21 = "";
    HeadCol22 = "";
    HeadCol23 = "";
    HeadCol24 = "";
    HeadCol25 = "";
    HeadCol26 = "";
    HeadCol31 = "";
    HeadCol32 = "";
    HeadCol33 = "";
    HeadCol34 = "";
    HeadCol35 = "";
    HeadCol36 = "";
    
    countCallBack = 0;
    
    btnEnabled(true);
    
	ComBtnEnable("btn_Extend");
	ComBtnEnable("btn_Save");
	ComBtnEnable("btn_Simulation");
    
    sheet2 = sheet2.Reset();
	ComConfigSheet (sheet2);
	initSheet(sheet2,2);
	ComEndConfigSheet(sheet2);
	
	sheet3.RemoveAll();
	
	sheet4 = sheet4.Reset();
	ComConfigSheet (sheet4);
	initSheet(sheet4,2);
	ComEndConfigSheet(sheet4);
	
	sheet5 = sheet5.Reset();
	ComConfigSheet (sheet5);
	initSheet(sheet5,2);
	ComEndConfigSheet(sheet5);
    
	simplePIN=false;
	
    formObj.vsl_slan_cd.value     = "";
	formObj.tmp_vsl_slan_cd.value = "";
	formObj.brth_itval_dys.value  = "";
	formObj.vsl_cnt.value         = "";
	formObj.vsl_count.value       = "";
	formObj.pf_svc_tp_cd.value    = "";
	formObj.slan_stnd_flg.value   = "Y";
	// Setting Current Year
	var today=new Date();
	with (formObj) {
		var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		selEndQuarter.value=checkQuarter(nowDate);
    	end_year.value=today.getFullYear();
    	end_date.value=ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
	
	sheet1.RenderSheet(0);
	setGetColHidden(sheet1,0);
	sheet1.RenderSheet(1);
	
	var headerRow = sheet1.HeaderRows();
	for (var i = 1; i < sheetMaxCol; i++) {
		sheet1.SetCellValue(headerRow + sheet1VslCdDataRow , "Vsl_" + i,"");
		sheet1.SetCellValue(headerRow + sheet1VoyNoDataRow , "Vsl_" + i,"");
    }
}

function initControl() {
	var formObj=document.form;
    axon_event.addListenerForm('blur', 'obj_blur',  formObj);
	axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
    axon_event.addListenerForm('change', 'obj_change', formObj);
    axon_event.addListenerForm('blur', 'obj_deactivate', formObj); 
}

function btnEnabled(isBool) {
	if (isBool) {
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_PhaseOut");
		ComBtnDisable("btn_PhaseOutCancel");
		ComBtnDisable("btn_SkipCall");
		ComBtnDisable("btn_SkipCallCancel");
	} else {
		ComBtnEnable("btn_Delete");
	    ComBtnEnable("btn_PhaseOut");
		ComBtnEnable("btn_PhaseOutCancel");
		ComBtnEnable("btn_SkipCall");
		ComBtnEnable("btn_SkipCallCancel");	
	}
	
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */

var leftHeaders = [{Text:"Start Date|Vessel Code|Start Voy. No.|P/F SKD Type|Out", Align:"Left"}];
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
    var formObj = document.form;
    
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
	            
	            for (var i=0 ; i <sheet1DataRows ; i++) {
	            	for ( var j = 1; j < sheetMaxCol; j++) {
	  		          	if (i == sheet1StartDateDataRow) {
	  		          		cols.push({Type:"PopupEdit", Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	  		          	} else if (i == sheet1VslCdDataRow) {
	  		          		cols.push({Type:"Text",      Hidden:1,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	  		          	} else if (i == sheet1VoyNoDataRow) {
	  		          		cols.push({Type:"Text",      Hidden:1,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	  		          	} else if (i == sheet1PfTypeDataRow) {
	  		          		cols.push({Type:"PopupEdit", Hidden:1, Width:95,   Align:"Left",    ColMerge:0,   SaveName:"Vsl_"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	  		          	}
	            	}
	            }
	            cols.push({Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag"});
	            
	            InitColumns(cols);
	  		 
	            SetImageList(0,"/opuscntr/img/btns_calendar.gif");
	  		    SetImageList(1,"/opuscntr/img/btns_search.gif");
	  			
		  	    SetEditable(1);
		  	    SetCountPosition(0);
		  	    SetWaitImageVisible(0);
		  	    SetExtendLastCol(0);
		  	    SetShowButtonImage(1);
		  	    InitHeadColumn(leftHeaders,sheetObj);
		  	    SetRowHidden(0, 1);
		  	    //SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
		  	    SetSheetHeight(ComGetSheetHeight(sheetObj, 5.3));	 
		  	    SetVisible(1);
			}		
      	break;
            
        case 'sheet2':      // SKD grid
           
        	with(sheetObj) {
    		if (HeadCol1 == undefined) HeadCol1 = "";
	      
	        var HeadTitle1 = "| | | |"+HeadCol1+"|Remark(s)|";
			var HeadTitle2 = "|VSL\nCD|VOY\nNO|DIR|"+HeadCol2+"|Remark(s)|";
			var HeadTitle3 = "|VSL\nCD|VOY\nNO|DIR|"+HeadCol3+"|Remark(s)|";
			var HeadTitle4 = "|VSL\nCD|VOY\nNO|DIR|"+HeadCol4+"|Remark(s)|";
			//var HeadTitle5 = "|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol5+"|Remark(s)|";
			var HeadTitle6 = "|VSL\nCD|VOY\nNO|DIR|"+HeadCol6+"|Remark(s)|";
	        
	        var portNum=parseInt(ComCountHeadTitle(HeadCol1)-1)/2;
	        
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	        
        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
        	var headers = [ { Text:HeadTitle1, Align:"Center"},
			                { Text:HeadTitle2, Align:"Center", RowMerge:0},
			                { Text:HeadTitle3, Align:"Center", RowMerge:0},
			                { Text:HeadTitle4, Align:"Center", RowMerge:0},
			  //              { Text:HeadTitle5, Align:"Center"},
			                { Text:HeadTitle6, Align:"Center", RowMerge:0}];
        	InitHeaders(headers, info);
        	
	        for (var i=0 ; i < dataSetCnt ; i++) {
	        	cnt=0;
		        var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",    			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",    			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:1,   SaveName:"VVD3",     			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"pf_svc_tp_cd_s",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		        for (var j = 0 ; j < portNum ; j++) {
			        if (i == 0) {
			        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        } else {                                           
			        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        	cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			        }				       
                }
                cols.push({Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		        cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                
	        }
	        InitColumns(cols);
	       	       
	    	var etbStartIdx = 5;
	    	for (var ydRow = 0; ydRow < portNum*2; ydRow = ydRow +2) {
	    		SetMergeCell(1, etbStartIdx+ydRow, 1, 2); // PORT Row
				SetMergeCell(4, etbStartIdx+ydRow, 1, 2); // Yard Row
			}
	        SetEditable(1);
	        SetWaitImageVisible(0);
	        SetCountPosition(0);
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));	        
        }
        break;
            
        case 'sheet3' : 	// P/F SKD
        	  with(sheetObj){
            	tabIndex=-1;
            	//SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
            	if (location.hostname != "")
            		
            	var HeadTitle="|vsl_slan_cd|skd_dir_cd|port_cd|yd_cd|clpt_seq|call_yd_ind_seq|port_rotn_seq|turn_port_flg|turn_port_ind_cd|eta_dy_cd|eta_dy_no|eta_tm_hrmnt|etb_dy_cd|etb_dy_no|etb_tm_hrmnt|etd_dy_cd|etd_dy_no|etd_tm_hrmnt|mnvr_in_hrs|mnvr_out_hrs|sea_buf_hrs|port_buf_hrs|pf_svc_tp_cd|svc_dur_dys";
            	var headCount=ComCountHeadTitle(HeadTitle);

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
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
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            
            	InitColumns(cols);	
 		        SetEditable(1);
 		        SetVisible(0);
 		        SetSheetHeight(200);
        	}
		break;
			
        case 'sheet4':      // SKD grid
            with(sheetObj){
            	//SetSheetHeight(322);
            	
            	var HeadTitle21="| | | |"+HeadCol21+"|Remark(s)|";
            	var HeadTitle22="|VSL\nCD|VOY\nNO|DIR|"+HeadCol22+"|Remark(s)|";
            	var HeadTitle23="|VSL\nCD|VOY\nNO|DIR|"+HeadCol23+"|Remark(s)|";
            	var HeadTitle24="|VSL\nCD|VOY\nNO|DIR|"+HeadCol24+"|Remark(s)|";
            	//var HeadTitle25="|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol25+"|Remark(s)|";
            	var HeadTitle26="|VSL\nCD|VOY\nNO|DIR|"+HeadCol26+"|Remark(s)|";
            	
            	var headCount=ComCountHeadTitle(HeadTitle21);
            	
            	var portNum=parseInt(ComCountHeadTitle(HeadCol21)-1)/2;
            	
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
            	
            	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
        		var headers = [ { Text:HeadTitle21, Align:"Center"},
        		                { Text:HeadTitle22, Align:"Center", RowMerge:0},
        		                { Text:HeadTitle23, Align:"Center", RowMerge:0},
        		                { Text:HeadTitle24, Align:"Center", RowMerge:0},
        		                //{ Text:HeadTitle25, Align:"Center"},
        		                { Text:HeadTitle26, Align:"Center", RowMerge:0},];
        		InitHeaders(headers, info);
        		
            	for (var i=0 ; i < dataSetCnt ; i++) {
            		cnt=0;          		

            		var cols = [ {Type:"Status",    Hidden:1,	 Width:30,	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0, 	 Width:47, 	Align:"Center",  ColMerge:1,   SaveName:"VVD1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, 	 Width:60, 	Align:"Center",  ColMerge:1,   SaveName:"VVD2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, 	 Width:37, 	Align:"Center",  ColMerge:1,   SaveName:"VVD3",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1,	 Width:40,  Align:"Center",  ColMerge:1,   SaveName:"pf_svc_tp_cd_s",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            		for (var j = 0 ; j < portNum ; j++) {
            			if (i == 0) {
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            			}else{
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            			}
            		}
            		cols.push({Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
        			cols.push({Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
            	}
            	
            	InitColumns(cols);
            	
            	var etbStartIdx = 5;
    	    	for (var ydRow = 0; ydRow < portNum*2; ydRow = ydRow +2) {
    	    		SetMergeCell(1, etbStartIdx+ydRow, 1, 2); // PORT Row
    				SetMergeCell(4, etbStartIdx+ydRow, 1, 2); // Yard Row
    			}
    	        SetEditable(1);
    	        SetWaitImageVisible(0);
    	        SetCountPosition(0);
    	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
    	        
            	SetVisible(0);  
          	}
        break;
            
        case 'sheet5':      // SKD grid
            with(sheetObj) {
            	//SetSheetHeight(322);            	
            	var HeadTitle31="| | | |"+HeadCol31+"|Remark(s)|";
            	var HeadTitle32="|VSL\nCD|VOY\nNO|DIR|"+HeadCol32+"|Remark(s)|";
            	var HeadTitle33="|VSL\nCD|VOY\nNO|DIR|"+HeadCol33+"|Remark(s)|";
            	var HeadTitle34="|VSL\nCD|VOY\nNO|DIR|"+HeadCol34+"|Remark(s)|";
            	//var HeadTitle35="|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol35+"|Remark(s)|";
            	var HeadTitle36="|VSL\nCD|VOY\nNO|DIR|"+HeadCol36+"|Remark(s)|";
            	var headCount=ComCountHeadTitle(HeadTitle31);
            	
            	var portNum=parseInt(ComCountHeadTitle(HeadCol31)-1)/2;
            	
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
            	
            	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
        		var headers = [ { Text:HeadTitle31, Align:"Center"},
        		                { Text:HeadTitle32, Align:"Center", RowMerge:0},
        		                { Text:HeadTitle33, Align:"Center", RowMerge:0},
        		                { Text:HeadTitle34, Align:"Center", RowMerge:0},
        		               // { Text:HeadTitle35, Align:"Center"},
        		                { Text:HeadTitle36, Align:"Center", RowMerge:0},];
        		InitHeaders(headers, info);
        		
            	for (var i=0 ; i < dataSetCnt ; i++) {
            		cnt=0;

            		var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:1,   SaveName:"VVD3",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pf_svc_tp_cd_s",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            		
            		for (var j = 0 ; j < portNum ; j++) {
            			if (i==0) {
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            			} else {
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETB"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            				cols.push({Type:"Text",      Hidden:0,  Width:34,   Align:"Left",    ColMerge:0,   SaveName:"ETD"+j,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            			}            			
            		}
            		cols.push({Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"skd_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
        			cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"out",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
        			
            	}
            	InitColumns(cols);
            	
            	var etbStartIdx = 5;
    	    	for (var ydRow = 0; ydRow < portNum*2; ydRow = ydRow +2) {
    	    		SetMergeCell(1, etbStartIdx+ydRow, 1, 2); // PORT Row
    				SetMergeCell(4, etbStartIdx+ydRow, 1, 2); // Yard Row
    			}
    	        SetEditable(1);
    	        SetWaitImageVisible(0);
    	        SetCountPosition(0);
    	        SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
            	
            	SetVisible(0);        	
        	}
        break;            
   	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
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
				if(ComGetEtcData(sXml, "vsl_slan_nm")) {					
					formObj.tmp_vsl_slan_cd.value= formObj.vsl_slan_cd.value;
					formObj.vsl_cnt.value        = ComGetEtcData(sXml, "vsl_count");
					formObj.vsl_count.value      = ComGetEtcData(sXml, "vsl_count");
					formObj.pf_svc_tp_cd.value   = ComGetEtcData(sXml, "pf_svc_tp_cd");
					formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
					formObj.svc_dur_dys.value    = ComGetEtcData(sXml, "svc_dur_dys");
					// in case Lane Code change, Getting stand type
					formObj.stnd_pf_svc_tp_cd.value=ComGetEtcData(sXml, "pf_svc_tp_cd");
					
					var sheetObj3 = sheetObjects[2];
					
					sheetObj3.RenderSheet(0);
					sheetObj3.LoadSearchData(sXml,{Sync:1} );
					sheetObj3.RenderSheet(1);
					manageStartInfo();
				}else{
					sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
					initPage();
					formObj.tmp_vsl_slan_cd.value="";
					formObj.vsl_slan_cd.value="";
					formObj.vsl_slan_cd.focus();
				}
			}
			break;
		case IBSAVE:        //save
			formObj.f_cmd.value=MULTI;
			if (validateForm(sheetObj, formObj, sAction)){
				var sParam=FormQueryString(formObj);
				sParam=sParam + "&HeadTitle1=" + HeadCol1 +"@"+ HeadCol21 +"#"+ HeadCol31;
				sParam=sParam + "&HeadTitle2=" + HeadCol2 +"@"+ HeadCol22 +"#"+ HeadCol32;
				sParam=sParam + "&HeadTitle3=" + HeadCol3 +"@"+ HeadCol23 +"#"+ HeadCol33;
				sParam=sParam + "&HeadTitle4=" + HeadCol4 +"@"+ HeadCol24 +"#"+ HeadCol34;
				sParam=sParam + "&HeadTitle5=" + HeadCol5 +"@"+ HeadCol25 +"#"+ HeadCol35;
				sParam=sParam + "&HeadTitle6=" + HeadCol6 +"@"+ HeadCol26 +"#"+ HeadCol36;
				sParam=sParam + vvdDeleteReason;
				var param="";
				for (var i=0; i<bkgVVDs.length; i++) {
					param=param + "&bkg_ibflag=I";
					param=param + "&bkg_vsl_slan_cd="     + bkgVVDs[i].vslSlanCd;
					param=param + "&bkg_vsl_cd="          + bkgVVDs[i].vslCd;
					param=param + "&bkg_skd_voy_no="      + bkgVVDs[i].skdVoyNo;
					param=param + "&bkg_skd_dir_cd="      + bkgVVDs[i].skdDirCd;
					param=param + "&bkg_turn_skd_voy_no=" + bkgVVDs[i].turnSkdVoyNo;
					param=param + "&bkg_turn_skd_dir_cd=" + bkgVVDs[i].turnSkdDirCd;
				}
				for (var i=0; i<virVVDs.length; i++) {
					param=param + "&vir_ibflag=I";
					param=param + "&vir_vsl_slan_cd="     + virVVDs[i].vslSlanCd;
					param=param + "&vir_vsl_cd="          + virVVDs[i].vslCd;
					param=param + "&vir_skd_voy_no="      + virVVDs[i].skdVoyNo;
					param=param + "&vir_skd_dir_cd="      + virVVDs[i].skdDirCd;
					param=param + "&vir_turn_skd_voy_no=" + virVVDs[i].turnSkdVoyNo;
					param=param + "&vir_turn_skd_dir_cd=" + virVVDs[i].turnSkdDirCd;
				}
				for (var i=0; i<bkgVirVVDs.length; i++) {
					param=param + "&bkg_vir_ibflag=I";
					param=param + "&bkg_vir_vsl_slan_cd="     + bkgVirVVDs[i].vslSlanCd;
					param=param + "&bkg_vir_vsl_cd="          + bkgVirVVDs[i].vslCd;
					param=param + "&bkg_vir_skd_voy_no="      + bkgVirVVDs[i].skdVoyNo;
					param=param + "&bkg_vir_skd_dir_cd="      + bkgVirVVDs[i].skdDirCd;
					param=param + "&bkg_vir_turn_skd_voy_no=" + bkgVirVVDs[i].turnSkdVoyNo;
					param=param + "&bkg_vir_turn_skd_dir_cd=" + bkgVirVVDs[i].turnSkdDirCd;
				}
				for(var i=0; i<nonBkgVVDs.length; i++){
					param=param + "&non_bkg_ibflag=I";
					param=param + "&non_bkg_vsl_slan_cd="     + nonBkgVVDs[i].vslSlanCd;
					param=param + "&non_bkg_vsl_cd="          + nonBkgVVDs[i].vslCd;
					param=param + "&non_bkg_skd_voy_no="      + nonBkgVVDs[i].skdVoyNo;
					param=param + "&non_bkg_skd_dir_cd="      + nonBkgVVDs[i].skdDirCd;
					param=param + "&non_bkg_turn_skd_voy_no=" + nonBkgVVDs[i].turnSkdVoyNo;
					param=param + "&non_bkg_turn_skd_dir_cd=" + nonBkgVVDs[i].turnSkdDirCd;
				}
				// Keeping SKD sheet's input state
				for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
					sheetObj.SetRowStatus(i,"I");
				}
				var sParamSheet1=ComGetSaveString(sheet1);
				if(sParamSheet1 != ""){
					sParam=sParam + "&" + sParamSheet1;
				}
				var sParamSheet2=ComGetSaveString(sheet2,false,true,-1);
				if(sParamSheet2 != ""){
					sParam=sParam + "&" + sParamSheet2;
				}
				var sParamSheet4=ComGetSaveString(sheet4,false,true,-1);
				if(sParamSheet4 != ""){
					sParam=sParam + "&" + sParamSheet4;
				}
				var sParamSheet5=ComGetSaveString(sheet5,false,true,-1);
				if(sParamSheet5 != ""){
					sParam=sParam + "&" + sParamSheet5;
				}
				var sParamSheet3=ComGetSaveString(sheet3,true,true,-1);
				if(sParamSheet3 != ""){
					sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
				}
				//prompt("",sParam);
				//Adding sheet1 info to parameter
				ComOpenWait(true);
				setTimeout(function(){
					var sXml=sheetObj.GetSaveData("VOP_VSK_0010GS.do" , sParam + param);
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml);
					
					if(!VskGetErrorXml(sXml)){
						ComBtnDisable("btn_Delete");
						ComBtnDisable("btn_PhaseOut");
						ComBtnDisable("btn_PhaseOutCancel");
						ComBtnDisable("btn_SkipCall");
						ComBtnDisable("btn_SkipCallCancel");					
						ComBtnDisable("btn_Extend");
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Simulation");
						//initPage();
					}
					
		        },300);    

			}
			break;
		case SEARCH02: // simulation
			formObj.f_cmd.value=SEARCH12;
			var sParam = makeFormString(formObj, sheetObjects[0], null, sheetObjects[2]);
			sheetObj1  = sheetObjects[1];
			ComOpenWait(true);
			var sXml = sheetObj1.GetSearchData("VOP_VSK_0010_2GS.do" , sParam);
			ComOpenWait(false);
			
			var sXmlArr = sXml.split("##");
            sXml = sXmlArr[0];
            
			HeadCol1  = ComGetEtcData(sXml, "HeadTitle1");          
            HeadCol2  = ComGetEtcData(sXml, "HeadTitle2");          
            HeadCol3  = ComGetEtcData(sXml, "HeadTitle3");          
            HeadCol4  = ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5  = ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6  = ComGetEtcData(sXml, "HeadTitle6");
            HeadCol21 = ComGetEtcData(sXml, "HeadTitle21");          
            HeadCol22 = ComGetEtcData(sXml, "HeadTitle22");          
            HeadCol23 = ComGetEtcData(sXml, "HeadTitle23");          
            HeadCol24 = ComGetEtcData(sXml, "HeadTitle24");
            HeadCol25 = ComGetEtcData(sXml, "HeadTitle25");
            HeadCol26 = ComGetEtcData(sXml, "HeadTitle26");
            HeadCol31 = ComGetEtcData(sXml, "HeadTitle31");          
            HeadCol32 = ComGetEtcData(sXml, "HeadTitle32");          
            HeadCol33 = ComGetEtcData(sXml, "HeadTitle33");          
            HeadCol34 = ComGetEtcData(sXml, "HeadTitle34");
            HeadCol35 = ComGetEtcData(sXml, "HeadTitle35");
            HeadCol36 = ComGetEtcData(sXml, "HeadTitle36");
            HeadCnt   = ComGetEtcData(sXml, "HeadTitleCnt");
            
			HeadPfSvcTp1 = ComGetEtcData(sXml, "HeadPfSvcTp1");
			HeadPfSvcTp2 = ComGetEtcData(sXml, "HeadPfSvcTp2");
			HeadPfSvcTp3 = ComGetEtcData(sXml, "HeadPfSvcTp3");
			
            sheetObj = sheet2.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);       
            ComEndConfigSheet(sheetObj);
            
            sheetObj3 = sheet4.Reset();
            ComConfigSheet (sheetObj3);
            initSheet(sheetObj3,2);       
            ComEndConfigSheet(sheetObj3);
            
            sheetObj4 = sheet5.Reset();
            ComConfigSheet (sheetObj4);
            initSheet(sheetObj4,2);       
            ComEndConfigSheet(sheetObj4);
            
            if(!VskGetErrorXml(sXml)){
            	ComBtnEnable("btn_Save");
            	btnEnabled(false);
            }
            if (formObj.voy_no_type.value=="1") {
            	sheetObj.SetColWidth("VVD2",80);
            	sheetObj3.SetColWidth("VVD2",80);
            	sheetObj4.SetColWidth("VVD2",80);
            }
        	uSheet=sheetObj;
        	
            extend();
        	
        	if (HeadCnt == "1") { 
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        		
        		sheetObj.SetSelectRow(0);
        		//sheetObj.SetSelectCol(0);
            	
            	ComGetSheetHeight(sheetObj, 14);   
            	
            	sheetObj.SetCellValue(0, "VVD1", HeadPfSvcTp1, 0);
            	
            	//sheetObj.RenderSheet(1);
        	} else if(HeadCnt == "2") {
    			sheetObj.LoadSearchData(sXml,{Sync:1} );
    			sheetObj3.LoadSearchData(sXmlArr[1],{Sync:1} );
    			
    			sheetObj.SetSelectRow(0);
    			//sheetObj.SetSelectCol(0);
            	
            	sheetObj3.SetVisible(true);
            	
            	sheetObj.SetCellValue(0, "VVD1", HeadPfSvcTp1, 0);
            	sheetObj3.SetCellValue(0, "VVD1", HeadPfSvcTp2, 0);
            	
            	//sheetObj.RenderSheet(1);
            	//sheetObj3.RenderSheet(1);
            } else if(HeadCnt == "3") {
    			sheetObj.LoadSearchData(sXml,{Sync:1} );
    			sheetObj3.LoadSearchData(sXmlArr[1],{Sync:1} );
    			sheetObj4.LoadSearchData(sXmlArr[2],{Sync:1} );
    			
    			sheetObj.SetSelectRow(0);
    			//sheetObj.SetSelectCol(0);
            	
    			sheetObj3.SetVisible(true);
    			sheetObj4.SetVisible(true);
    			
            	sheetObj.SetCellValue(0, "VVD1", HeadPfSvcTp1, 0);
            	sheetObj3.SetCellValue(0, "VVD1", HeadPfSvcTp2, 0);
            	sheetObj4.SetCellValue(0, "VVD1", HeadPfSvcTp3, 0);
    			
            	//sheetObj.RenderSheet(1);
            	//sheetObj3.RenderSheet(1);
            	//sheetObj4.RenderSheet(1);            	
            }           
			break;
			
		case SEARCH03: // phase in
			formObj.f_cmd.value=SEARCH03;
			var sParam=makeFormString(formObj, sheetObjects[0], sheetObjects[1], sheetObjects[2]);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_3GS.do" , sParam);
            HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
            HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
            HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
            HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
            
	         //::2015-05-12:by TOP:://sheetObj.Reset(); 
			/* 2015-04-15
			 * sheetObjects 배열에 담겨져 있는 sheet 객체를 reset 할 경우 다시 sheetObjects 배열에 
			 * 담아주지 않으면 객체를 잃어버릴 수 있기 때문에 수정
			 */  
            sheetObj 		= sheetObj.Reset();
            sheetObjects[0] = sheetObj;
            
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
			sheetObj.RenderSheet(0);
			var sParam=makeFormString(formObj, null, uSheet, sheetObjects[2]);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_3GS.do" , sParam);
			if(sheetObj.id == "sheet4"){
	            HeadCol21=ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol22=ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol23=ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol24=ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol25=ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol26=ComGetEtcData(sXml, "HeadTitle6");
			}else if(sheetObj.id == "sheet5"){
	            HeadCol31=ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol32=ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol33=ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol34=ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol35=ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol36=ComGetEtcData(sXml, "HeadTitle6");
			}else{
				HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
		        HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
		        HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
		        HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
		        HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
		        HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
			}
			
			//::2015-05-12:by TOP:://sheetObj.Reset(); 
			/* 2015-04-15
			 * sheetObjects 배열에 담겨져 있는 sheet 객체를 reset 할 경우 다시 sheetObjects 배열에 
			 * 담아주지 않으면 객체를 잃어버릴 수 있기 때문에 수정
			 */  
            sheetObj 		= sheetObj.Reset();
            sheetObjects[0] = sheetObj;
	        
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.RenderSheet(1);
            extend();
        	sheetObjects[1].SetSelectRow(0);
        	sheetObjects[1].SetSelectCol(0);
        	sheetObjects[3].SetSelectRow(0);
        	sheetObjects[3].SetSelectCol(0);
        	sheetObjects[4].SetSelectRow(0);
        	sheetObjects[4].SetSelectCol(0);
            if(HeadCnt == "2"){
            	document.all.item("mainTable2").style.display="inline";
            	document.all.item("mainTable3").style.display="none";
            	sheetObjects[1].SetSheetHeight(220);
            	sheetObjects[3].SetSheetHeight(220);
            	sheetObjects[1].RenderSheet(1);
            	sheetObjects[3].RenderSheet(1);
            }else if(HeadCnt == "3"){
            	document.all.item("mainTable2").style.display="inline";
            	document.all.item("mainTable3").style.display="inline";
            	sheetObjects[1].SetSheetHeight(220);
            	sheetObjects[3].SetSheetHeight(220);
            	sheetObjects[4].SetSheetHeight(220);
        	    sheetObjects[1].RenderSheet(1);
            	sheetObjects[3].RenderSheet(1);
            	sheetObjects[4].RenderSheet(1);
            }
			break;
		case SEARCH06: // add call cancel
			formObj.f_cmd.value=SEARCH06;
			var sParam=makeFormString(formObj, null, uSheet, sheetObjects[2]);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0010_3GS.do" , sParam);
			if(sheetObj.id == "sheet4"){
	            HeadCol21=ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol22=ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol23=ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol24=ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol25=ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol26=ComGetEtcData(sXml, "HeadTitle6");
			}else if(sheetObj.id == "sheet5"){
	            HeadCol31=ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol32=ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol33=ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol34=ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol35=ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol36=ComGetEtcData(sXml, "HeadTitle6");
			}else{
				HeadCol1=ComGetEtcData(sXml, "HeadTitle1");
		        HeadCol2=ComGetEtcData(sXml, "HeadTitle2");
		        HeadCol3=ComGetEtcData(sXml, "HeadTitle3");
		        HeadCol4=ComGetEtcData(sXml, "HeadTitle4");
		        HeadCol5=ComGetEtcData(sXml, "HeadTitle5");
		        HeadCol6=ComGetEtcData(sXml, "HeadTitle6");
			}
			
			//::2015-05-12:by TOP:://sheetObj.Reset(); 
			/* 2015-04-15
			 * sheetObjects 배열에 담겨져 있는 sheet 객체를 reset 할 경우 다시 sheetObjects 배열에 
			 * 담아주지 않으면 객체를 잃어버릴 수 있기 때문에 수정
			 */  
            sheetObj 		= sheetObj.Reset();
            sheetObjects[0] = sheetObj;
	        
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.RenderSheet(1);
            extend();
        	sheetObjects[1].SetSelectRow(0);
        	sheetObjects[1].SetSelectCol(0);
        	sheetObjects[3].SetSelectRow(0);
        	sheetObjects[3].SetSelectCol(0);
        	sheetObjects[4].SetSelectRow(0);
        	sheetObjects[4].SetSelectCol(0);
            if(HeadCnt == "2"){
            	document.all.item("mainTable2").style.display="inline";
            	document.all.item("mainTable3").style.display="none";
            	sheetObjects[1].SetSheetHeight(220);
            	sheetObjects[3].SetSheetHeight(220);
            	sheetObjects[1].RenderSheet(1);
            	sheetObjects[3].RenderSheet(1);
            }else if(HeadCnt == "3"){
            	document.all.item("mainTable2").style.display="inline";
            	document.all.item("mainTable3").style.display="inline";
            	sheetObjects[1].SetSheetHeight(220);
            	sheetObjects[3].SetSheetHeight(220);
            	sheetObjects[4].SetSheetHeight(220);
        	    sheetObjects[1].RenderSheet(1);
            	sheetObjects[3].RenderSheet(1);
            	sheetObjects[4].RenderSheet(1);
            }
			break;
		case SEARCH07:	// search vessel code
			formObj.f_cmd.value=COMMAND16;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
			var vslInfo = new Object();
			vslInfo.vslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
			return vslInfo;
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
		case SEARCH09: // P/F type change
			formObj.f_cmd.value=SEARCH;
			// P/F SKED Type 값을 전달
			var vlsCnt = formObj.vsl_cnt.value;
			for (var i=1; i <= vlsCnt; i++) {
				if (i==1) {
					pf_svc_tp_cd = sheetObjects[0].GetCellValue(4, i);
				} else if (sheetObjects[0].GetCellValue(4, i) != "") {
					pf_svc_tp_cd = pf_svc_tp_cd+","+sheetObjects[0].GetCellValue(4, i);
				}
			}
			formObj.pf_svc_tp_cd.value=pf_svc_tp_cd;
			if (formObj.stnd_pf_svc_tp_cd.value == formObj.pf_svc_tp_cd.value) {
				formObj.slan_stnd_flg.value='Y';
			} else {
				formObj.slan_stnd_flg.value='N';
			}
			// 초기 화면 처럼 숨김
			// sheet4, sheet5
			document.all.item("sheet4").style.display="none";
			document.all.item("sheet5").style.display="none";
			sheetObjects[3].RenderSheet(1);
			sheetObjects[4].RenderSheet(1);
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0010GS.do" , sParam);
			
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
				formObj.vsl_count.value=ComGetEtcData(sXml, "vsl_count");
								
				formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
				if (formObj.vsl_count.value.parseInt() < formObj.vsl_cnt.value.parseInt()) {
					formObj.vsl_cnt.value=formObj.vsl_count.value;
				}
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
			}
		    break;		
    }
}

function getSimulData(rVal) {
	var formObj = document.form;
	var sUrl="/opuscntr/VOP_VSK_0211_POP.do";
	
	if (vessels.length == countCallBack) {
		ComOpenWait(true);
		setTimeout(function(){
			doActionIBSheet(sheetObjects[1],formObj,SEARCH02);
        },300);     
	}
	
	if (rVal) {
		bkgVVDs    = bkgVVDs.concat(rVal.bkgVVDs);
		virVVDs    = virVVDs.concat(rVal.virVVDs);
		bkgVirVVDs = bkgVirVVDs.concat(rVal.bkgVirVVDs);
		nonBkgVVDs = nonBkgVVDs.concat(rVal.nonBkgVVDs);
	}
	
	if(vessels.length != countCallBack){
		sUrl=sUrl + "?vsl_cd=" + vessels[countCallBack].vslCd 
		   + "&skd_voy_no="    + vessels[countCallBack].skdVoyNo 
		   + "&start_date="    + vessels[countCallBack].startDate
		   + "&end_date="      + formObj.end_date.value
		   + "&vsl_cnt="       + formObj.vsl_cnt.value
		   + "&voy_no_type="   + formObj.voy_no_type.value
		   + "&voy_type_cnt="  + formObj.voy_type_cnt.value
		   + "&skd_dir_cd_1="  + formObj.skdDirCd1.value
		   + "&skd_dir_cd_2="  + formObj.skdDirCd2.value
		   + "&voy_type_cnt="  + formObj.voy_type_cnt.value
		   + "&duration="      + formObj.svc_dur_dys.value;
		ComOpenPopup(sUrl, 506, 527, "getSimulData", "0,0", true);
		countCallBack++;		
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
function setGetColHidden(sheetObj,viewCols){
	if(!viewCols){
		viewCols=0;
	}
//	sheetObj.RenderSheet(0);
	// all false
	for(var i=1; i<=sheetObj.LastCol(); i++){
		sheetObj.SetColHidden(i,1);
	}
	
	// some true
	for(var i=1; i<=viewCols; i++){
		sheetObj.SetColHidden(i,0);
	}
//	sheetObj.RenderSheet(1);
	// Handling sheet weight

	
	//var width=95*(viewCols)+95;
	if(viewCols<=9){
		//sheetObj.SetSheetWidth(width);
//		sheetObj.ViewRows = sheet1DataRows;
		//sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
		//sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));
		//sheetObjects[1].SetSheetHeight(322);
	} else if(viewCols==0) {
		//sheetObj.SetSheetWidth(90);
//		sheetObj.ViewRows = sheet1DataRows;
		//sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows));
		//sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));
	} else {
		//sheetObj.SetSheetWidth(95*(9)+95);
//		sheetObj.ViewRows = sheet1DataRows + 1;
		//sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1DataRows+1));
		//sheetObjects[1].SetSheetHeight(ComGetSheetHeight(sheetObjects[1], 14));
	}
}

function sheet1_OnSelectCell(OldRow, OldCol, NewRow, NewCol,isDelete) {
	
   if (OldCol != NewCol && 0 == sheet1.GetSelectCol()) {
	   sheet1.SelectCell(sheet1.GetSelectRow(), 1);
   }
}


function sheet1_OnChange(sheetObj , Row, Col, Value) {
   	if(!Value || Value==""){
		return false;
	}
	var formObj=document.form;
	var datarow=Row - sheetObj.HeaderRows(); // position of DataRow
	var boolSamVsl="N";
	if(datarow==sheet1StartDateDataRow){
		adjustStartDate(sheetObj, Col, Value);
	}else if(datarow==sheet1VslCdDataRow){	// Vessel Code change
		
		if(Value.length < 4){
			ComShowCodeMessage('VSK00021', Value);
			sheetObj.SelectCell(Row, Col);
			sheetObj.SetCellValue(Row, Col,"",0);
			return false;
		}
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
		}else if(formObj.voy_no_type.value == "2"){
			voyageTypeSequence(formObj);
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
			HeadCol21="";
			HeadCol22="";
			HeadCol23="";
			HeadCol24="";
			HeadCol25="";
			HeadCol26="";
			HeadCol31="";
			HeadCol32="";
			HeadCol33="";
			HeadCol34="";
			HeadCol35="";
			HeadCol36="";
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
    	var est=Col%2==1 ? "ETB" : "ETD";
    	if(oldval=='' || oldval==skipvalue){
    		return false;
    	}
		if(oldval.substring(0,3) != "out"){
			var sUrl="/opuscntr/VOP_VSK_0210.do?port=" + port + "&est=" + est + "&srcdate=" + oldval;
			ComOpenPopup(sUrl, 428, 402, "getOutValSheet2", "0,0", true);
		}
	}else if(Col==sheetObj.LastCol()-bufferColCount+1){
		if(Row<4) return;
		// Remark input popup open
		var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, Col);
		
		ComOpenPopup(sUrl, 342, 370, "getRmkVal", "0,0", true);
	}
}

function getRmkVal(rtnVal) {
	if( rtnVal != "") {
		sheet2.SetCellValue(sheet2.GetSelectRow(), "skd_rmk",rtnVal);
	}
}

function getOutValSheet2(rtnVal) {
	if( rtnVal != ""){
		sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(), rtnVal);// VPS_ET
		sheet2.SetCellValue(sheet2.GetSelectRow()+sheet2InitDateRowPos, sheet2.GetSelectCol(),rtnVal);// INIT_ET
	}
}

function getOutValSheet4(rtnVal) {
	if( rtnVal != ""){
		sheet4.SetCellValue(sheet4.GetSelectRow(), sheet4.GetSelectCol(), rtnVal);// VPS_ET
		sheet4.SetCellValue(sheet4.GetSelectRow()+sheet2InitDateRowPos, sheet4.GetSelectCol(),rtnVal);// INIT_ET
	}
}

function getOutValSheet5(rtnVal) {
	if( rtnVal != ""){
		sheet5.SetCellValue(sheet5.GetSelectRow(), sheet5.GetSelectCol(), rtnVal);// VPS_ET
		sheet5.SetCellValue(sheet5.GetSelectRow()+sheet2InitDateRowPos, sheet5.GetSelectCol(),rtnVal);// INIT_ET
	}
}

function getVal0215(rVal){

	var row = uSheet.GetSelectRow();
	var col = uSheet.GetSelectCol();
	
	var formObj = document.form;
	var addTargetCol = "";
    
	if (rVal) {
    	formObj.add_call_port_cd.value  = rVal.port_cd;
    	formObj.add_call_yard_cd.value  = rVal.yard_cd;
    	formObj.add_call_etb.value      = rVal.etb;
    	formObj.add_call_etd.value      = rVal.etd;
    	formObj.add_call_turn_ind.value = rVal.turn_ind;
    	formObj.add_call_position.value = rVal.position;
    	 
    	if (countAddCallPort(uSheet, row, col) > 0) {
    		addTargetCol = col;
    		uSheet.SetCellValue(row, addTargetCol  ,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
    		uSheet.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
     	} else {
     		var check=checkTargetPortIsAddPort(uSheet, row, col);
     		if (check) {
     			if ("before"== formObj.add_call_position.value) {
     				addTargetCol=col - 2;
     			} else if ("after"==formObj.add_call_position.value) {
     				addTargetCol=col + 2;
     			}
     			uSheet.SetCellValue(row, addTargetCol,formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
				uSheet.SetCellValue(row, addTargetCol+1,formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm"),0);
     		} else {
				if ("after"==formObj.add_call_position.value) {
					addTargetCol=col + 2;
	            } else if ("before"==formObj.add_call_position.value) {
	            	addTargetCol=col;
	            	col=col + 2;
	            }
				doActionIBSheet(uSheet,formObj,SEARCH05);
     		}
     	}
		// Add Call : VPS_ET
		// Setting INIT_ET same as VPS_ET
		uSheet.SetCellValue(row + sheet2InitDateRowPos, addTargetCol  , uSheet.GetCellValue(row, addTargetCol)  ,0);
		uSheet.SetCellValue(row + sheet2InitDateRowPos, addTargetCol+1, uSheet.GetCellValue(row, addTargetCol+1),0);
		uSheet.SetCellValue(row + sheet2StatusRowPos  , addTargetCol  , "A",0);
		uSheet.SetCellValue(row + sheet2StatusRowPos  , addTargetCol+1, "A",0);
		sheet2_SetColor(uSheet);
	}
}

function sheet4_OnDblClick(sheetObj , Row, Col)
{
	if(Col >= dataStartCol && Col <= sheetObj.LastCol()-bufferColCount){
		var oldval=sheetObj.GetCellValue(Row, Col);
		var port=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, Col);
    	var est=Col%2==1 ? "ETB" : "ETD";
    	if(oldval=='' || oldval==skipvalue){
    		return false;
    	}
		if(oldval.substring(0,3) != "out"){
			var sUrl="/opuscntr/VOP_VSK_0210.do?port=" + port + "&est=" + est + "&srcdate=" + oldval;
			ComOpenPopup(sUrl, 428, 402, "getOutValSheet4", "0,0", true);
		}
	}else if(Col==sheetObj.LastCol()-bufferColCount+1){
		if(Row<4) return;
		// Remark input popup open
		var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, Col);
		var rVal=ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		if(rVal || rVal==""){
			sheetObj.SetCellValue(Row, Col,rVal);
		}
	}
}
function sheet5_OnDblClick(sheetObj , Row, Col)
{
	if(Col >= dataStartCol && Col <= sheetObj.LastCol()-bufferColCount){
		var oldval=sheetObj.GetCellValue(Row, Col);
		var port=sheetObj.GetCellValue(sheet2VpsPortCdHeaderRow, Col);
    	var est=Col%2==1 ? "ETB" : "ETD";
    	if(oldval=='' || oldval==skipvalue){
    		return false;
    	}
		if(oldval.substring(0,3) != "out"){
			var sUrl="/opuscntr/VOP_VSK_0210.do?port=" + port + "&est=" + est + "&srcdate=" + oldval;
			ComOpenPopup(sUrl, 428, 402, "getOutValSheet5", "0,0", true);
		}
	}else if(Col==sheetObj.LastCol()-bufferColCount+1){
		if(Row<4) return;
		// Remark input popup open
		var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, Col);
		var rVal=ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		if(rVal || rVal==""){
			sheetObj.SetCellValue(Row, Col,rVal);
		}
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

function sheet2_OnClick(sheetObj , Row, Col){
	sheetObjects[3].SetSelectRow(0);
	sheetObjects[3].SetSelectCol(0);
	sheetObjects[4].SetSelectRow(0);
	sheetObjects[4].SetSelectCol(0);

	uSheet=sheetObj;
	uRow=Row;
	uCol=Col;
}
function sheet4_OnClick(sheetObj , Row, Col){
	sheetObjects[1].SetSelectRow(0);
	sheetObjects[1].SetSelectCol(0);
	sheetObjects[4].SetSelectRow(0);
	sheetObjects[4].SetSelectCol(0);

	uSheet=sheetObj;
	uRow=Row;
	uCol=Col;
}
function sheet5_OnClick(sheetObj , Row, Col){
	sheetObjects[1].SetSelectRow(0);
	sheetObjects[1].SetSelectCol(0);
	sheetObjects[3].SetSelectRow(0);
	sheetObjects[3].SetSelectCol(0);

	uSheet=sheetObj;
	uRow=Row;
	uCol=Col;
}
function validatePF(sheetObj){
	var preDyNo;
	var preTmHrmnt;
	var curDyNo;
	var curTmHrmnt;
	var check=true;
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.RowCount(); Row++){
		// Checking mnvr_in_hrs is 0
		/*
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
			alert(sheetObj.GetCellValue(Row, "port_cd"));
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
		*/
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
	var port_idx=parseInt((Col - dataStartCol)/2 + 1);
	return port_idx;
}
function VvdPosition(Row)
{
	var vvd_idx=parseInt(Row - dataStartRow);
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
		if ("" == sheetObj.GetCellValue(row, col) || skipvalue==sheetObj.GetCellValue(row, col)) {
			return false;
		}
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		//sheetObj.SelectCell(row, 1, false);
    	if(PortPosition(col)==-1 || "skd_rmk"==sheetObj.ColSaveName(col)){
    		ComShowCodeMessage('VSK00080');
    		return false;
    	}else{
    		ComOpenWait(true);
    		var param="";
    		param += "vsl_slan_cd="   + formObj.vsl_slan_cd.value;
    		param += "&vsl_cd="       + sheetObj.GetCellValue(row, "VVD1");
    		param += "&voy_no="       + sheetObj.GetCellValue(row, "VVD2");
    		param += "&dir_cd="       + sheetObj.GetCellValue(0, col);
    		param += "&port_cd="      + sheetObj.GetCellValue(1, col);
    		param += "&phase_type=O";
    		param += "&clpt_ind_seq=" + getClptIndSeq(sheetObj, col);
    		param += "&phase_date="   + ComGetNowInfo();
    		param += "&parentUI=0010";
    		var sUrl="/opuscntr/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + "&" + param;
    		ComOpenPopup(sUrl, 650, 217, "getVal0205", "0,0", true);    		
    	}
	}
	ComOpenWait(false);
}

function getClptIndSeq(sheetObj, col) {
	
	if (sheetObj.id == "sheet2") {
		var HeadTitle5 = "|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol5+"|Remark(s)|";		
		return HeadTitle5.split("|")[col];
	} else if (sheetObj.id == "sheet4") {
		var HeadTitle25="|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol25+"|Remark(s)|";
		return HeadCol25.split("|")[col];
	} else if (sheetObj.id == "sheet5") {
		var HeadTitle35="|VSL\nCD|VOY.\nNO.|DIR|"+HeadCol35+"|Remark(s)|";
		return HeadCol35.split("|")[col];
	}
}

function getVal0205(rVal) {
	
	var formObj=document.form;
	
	var row = uSheet.GetSelectRow();
	var col = uSheet.GetSelectCol();
	
	col = startColPos(uSheet, 0);
	
	if(rVal){
		//uSheet.RenderSheet(0);
		var vslCd=uSheet.GetCellValue(row, "VVD1");
		for(var i=0; i < 4 ; i++){
			if(i == 0){
				uSheet.SetCellValue(row+sheet2StatusRowPos, col,"O:" + rVal,0);
				uSheet.SetCellValue(row+sheet2StatusRowPos, col+1,"O:" + rVal,0);
				for(var j=col+2 ; j <= uSheet.LastCol()- bufferColCount ;j++){
					if(uSheet.GetCellValue(row, j)!=""){
						uSheet.SetCellValue(row+sheet2StatusRowPos, j,uSheet.GetCellValue(row, j),0);
						uSheet.SetCellValue(row,j,"",0);//"out_"+GetCellValue(row+i,j);
					}
				}
			}
		}     
		for(var i=row + 4 ; i <= uSheet.LastRow(); i ++){
			if(uSheet.GetCellValue(i, "VVD1") == vslCd ){
				uSheet.SetRowHidden(i,1);
				uSheet.SetCellValue(i, "out",vslCd,0);
			}
		}
		// phase out coloring
		for(var i=col + 2; i<uSheet.SaveNameCol("skd_rmk"); i++){
			uSheet.SetCellBackColor(row, i,"#C8C8C8");
		}
		//uSheet.RenderSheet(1);
	}
	
	uSheet.SelectCell(row, 1, false);
}

function phaseOutCancel(sheetObj)
{
	if(sheetObj.RowCount() < 1){//no data
		ComShowCodeMessage('VSK00080');
		return;
	}
	with(sheetObj){
		var row = sheetObj.GetSelectRow();
		var col = sheetObj.GetSelectCol();
		    col = startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
    	if (PortPosition(col)==-1 || "skd_rmk" == sheetObj.ColSaveName(col)) {
    		ComShowCodeMessage('VSK00080');
    	} else if (sheetObj.GetCellValue(row+sheet2StatusRowPos, col).indexOf("O:")<0) {
    		ComShowCodeMessage('VSK00063');
    	} else {
    		ComOpenWait(true);
        	//RenderSheet(0);
        	var vslCd=sheetObj.GetCellValue(row, "VVD1");
        	// 1. Canceling phase out of selected vvd
        	sheetObj.SetCellValue(row+sheet2StatusRowPos, col,"",0);
        	sheetObj.SetCellValue(row+sheet2StatusRowPos, col+1,"",0);
        	for(var i=col + 2; i<SaveNameCol("skd_rmk"); i++){
				SetCellBackColor(row, i,"#FFFFFF");
			}
        	for(var i=col+2 ; i <= sheetObj.LastCol()- bufferColCount ; i++){
        		sheetObj.SetCellValue(row, i,GetCellValue(row+sheet2StatusRowPos, i),0);
        		sheetObj.SetCellValue(row+sheet2StatusRowPos, i,"",0);
			}
        	// 2. Canceling phase out of after vvd
			for(var i=row+dataSetCnt ; i <= LastRow(); i=i+dataSetCnt){
				if(vslCd == sheetObj.GetCellValue(i, "out")){
					SetRowHidden(i,0);
					sheetObj.SetCellValue(i, "out","");
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
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
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
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
		col=startColPos(sheetObj, 0);
		// Getting phase out information, Initializing selection info of sheet
		sheetObj.SelectCell(row, 1, false);
    	if(PortPosition(col)==-1 || "skd_rmk" == sheetObj.ColSaveName(col)){
    		ComShowCodeMessage('VSK00059');
    	}else if(GetCellValue(row+sheet2StatusRowPos, col).indexOf("I:")<0){
    		ComShowCodeMessage('VSK00079');
    	}else{
    		ComOpenWait(true);
        	RenderSheet(0);
        	var targetVslCd = sheetObj.GetCellValue(row, "VVD1");
    		var i=row;
    		while(i<=LastRow()){
    			if(targetVslCd == sheetObj.GetCellValue(i, "VVD1")){
    				RowDelete(i, false);
    			}else{
    				i++;
    			}
    		}
    		RenderSheet(1);
    		ComOpenWait(false);
    	}
	}
}
 function skipCall(sheetObj)
{
	with(sheetObj){
    	var row=GetSelectRow();
    	var col=GetSelectCol();
    	var value=GetCellValue(row,col);
    	var etbCol=startColPos(sheetObj,0);
    	if(value == "" || value.substring(0,3) == "out" || !etbCol || value == skipvalue){
    		//sheetObj.SelectCell(row,1);
    		return;
    	}
    	// cannot skip Add Call Port
    	if("A"==GetCellValue(row+sheet2StatusRowPos, etbCol)){
    		ComShowCodeMessage("VSK00086");
    		return true;
    	}
    	var linkSkd=findNextLinkSkd(sheetObj, row, etbCol);
    	if(!linkSkd){
    		linkSkd=findPrevLinkSkd(sheetObj, row, etbCol);
    	}
    	if(linkSkd){
    		SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol,GetCellValue(linkSkd.tgtRow, linkSkd.tgtCol),0);
    		SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1,GetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1),0);
        	SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,skipvalue,0);
        	SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,skipvalue,0);
        	SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol,"#C0C0C0");
        	SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1,"#C0C0C0");
        	// express skipped port
        	SetCellValue(linkSkd.tgtRow, "skip",1,0);
    	}
    	// Handling SKIP
    	SetCellValue(row+sheet2StatusRowPos, etbCol,GetCellValue(row, etbCol),0);
    	SetCellValue(row+sheet2StatusRowPos, etbCol+1,GetCellValue(row, etbCol+1),0);
    	SetCellValue(row, etbCol,skipvalue,0);
    	SetCellValue(row, etbCol+1,skipvalue,0);
    	SetCellBackColor(row, etbCol,"#C0C0C0");
    	SetCellBackColor(row, etbCol+1,"#C0C0C0");
    	// express skipped port
    	SetCellValue(row, "skip",1,0);
   	}
}
function skipCallCancel(sheetObj)
{
	with(sheetObj){
    	var row=sheetObj.GetSelectRow();
    	var col=sheetObj.GetSelectCol();
    	var value=GetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
    	if(value==skipvalue){
    		var etbCol=startColPos(sheetObj,0);
    		var linkSkd=findPrevLinkSkd(sheetObj, row, etbCol);
    		if(!linkSkd){
    			linkSkd=findNextLinkSkd(sheetObj, row, etbCol);
    		}
        	if(linkSkd){
        		SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol,GetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol),0);
        		SetCellValue(linkSkd.tgtRow, linkSkd.tgtCol+1,GetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1),0);
        		SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol,"",0);
        		SetCellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1,"",0);
            	SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol,"#FFFFFF");
            	SetCellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1,"#FFFFFF");
            	// express skipped port
            	SetCellValue(linkSkd.tgtRow, "skip",1,0);
        	}
    		// Skip Cancel
        	SetCellValue(row, etbCol,GetCellValue(row+sheet2StatusRowPos, etbCol),0);
			SetCellValue(row+sheet2StatusRowPos, etbCol,"",0);
			SetCellBackColor(row, etbCol,"#FFFFFF");
			SetCellValue(row, etbCol+1,GetCellValue(row+sheet2StatusRowPos, etbCol+1),0);
			SetCellValue(row+sheet2StatusRowPos, etbCol+1,"",0);
			SetCellBackColor(row, etbCol+1,"#FFFFFF");
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


/**
 * Handling Enter Key Event
 */
function enter_keypress(){
	VskKeyEnter('btn_Simulation');
}

/**
 * Handling focus out event and Checking validation
 **/
function obj_blur(){
    var formObj=document.form;
    switch(event.srcElement.name){
        case "start_date":
        case "end_date":
        	ComChkObjValid(event.srcElement);
        	break;
        default:
    }
    return true;
}

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
        	
        	reduce();
           sheetObj=sheetObjects[0];
            var nowInfo   = ComGetNowInfo();
            var brth_itval_dys = formObj.brth_itval_dys.value;
            
            sheetObjects[0].RenderSheet(0);
            setGetColHidden(sheetObjects[0], vsl_cnt);
            sheetObjects[0].RenderSheet(1);
    	    var headerRow = sheetObj.HeaderRows();
    	    
    	    for (var i = 1; i < sheetMaxCol; i++) {
    	    	if (formObj.vsl_cnt.value >= i) {
    		   		sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow , "Vsl_" + i,ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys),0);
    		   		//sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow    , "Vsl_" + i,formObj.pf_svc_tp_cd.value,0);    		   		
    		    } else {
    		    	sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow , "Vsl_" + i,"");
    		   		//sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow    , "Vsl_" + i,"");
    		    }
    	    }
    	    
            sheetObj=sheetObjects[1];
			//sheetObj.RemoveAll();
			if(sheetObj.LastCol()> 6){
				for(var i=dataStartCol; i<=sheetObj.LastCol()-bufferColCount; i++){
					sheetObj.SetColHidden(i,1);
				}
			}
			adjustEndDate();
        	break;
        case "voy_no_type":
        	if(document.getElementById("voy_no_type").value == "1"){
        		document.getElementById("voy_type_cnt").readOnly=false;
        		document.getElementById("voy_type_cnt").className="Input";
        		document.getElementById("voy_type_cnt").value="1";
        		document.getElementById("voy_type_cnt").focus();
    		}else if(document.getElementById("voy_no_type").value == "0")  {
           		document.getElementById("voy_type_cnt").readOnly=false;
        		document.getElementById("voy_type_cnt").className="Input";
        		document.getElementById("voy_type_cnt").value="1";
        		document.getElementById("voy_type_cnt").focus();
    		}else if(document.getElementById("voy_no_type").value == "2")  {
           		document.getElementById("voy_type_cnt").readOnly=false;
        		document.getElementById("voy_type_cnt").className="Input";
        		document.getElementById("voy_type_cnt").value="1";
        		document.getElementById("voy_type_cnt").focus();
        		voyageTypeSequence(formObj);
    		} else {
    			document.getElementById("voy_type_cnt").readOnly=true;
    			document.getElementById("voy_type_cnt").className="Input2";
    			document.getElementById("voy_type_cnt").value="";
    		}
        	break;
        case "voy_type_cnt":
        	voyageTypeSequence(formObj);
        	break;
        /*case "vsl_slan_cd":
        	var	vslSlanCd=formObj.vsl_slan_cd.value;
        	if(VskIsNull(vslSlanCd)) {return;}    		
        	var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
        	var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
  		  	if(vslSlanNm == ""){
  		  		formObj.vsl_slan_cd.value="";
  		  		formObj.vsl_slan_cd.focus();
				ComShowCodeMessage('VSK00021', vslSlanCd);
			}
        	break;*/
    }
}

function obj_deactivate(){
	var formObj=document.form;
	var eventValue = ComGetEvent("value");
	var sheetObj=null;
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
				//reduce();
				sheetObj=sheetObjects[0];
				//sheetObj.RemoveAll();
				//initVoyType();	// VoyType init
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
		case "end_date":
			// end_date < start_date, exception
			sheetObj=sheetObjects[0];
			var vslStartDate=sheetObj.GetCellValue(1, formObj.vsl_cnt.value);
			eventValue = ComReplaceStr(eventValue, "-", "");
			
			if(vslStartDate){
				if(eventValue < vslStartDate){
					ComShowCodeMessage("VSK00013");
					eventValue = ComGetMaskedValue(bakObj, "ymd");
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
		openPfTypePopup(sheetObj, Row, Col);
	}else if(datarow==sheet1StartDateDataRow){
		sheetObj.SelectCell(Row, Col);
	}
}

function makeFormString(formObj, sheetObj1, sheetObj2, sheetObj3){
	//var sParam = FormQueryString(formObj) + "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
	var sParam=FormQueryString(formObj);
	var sParamSheet1="";
	var sParamSheet2="";
	var sParamSheet3="";
	if(sheetObj2!=null && sheetObj2.id == "sheet4"){
		sParam=sParam + "&HeadTitle1=" + HeadCol21 + "&HeadTitle2=" + HeadCol22 + "&HeadTitle3=" + HeadCol23 + "&HeadTitle4=" + HeadCol24 + "&HeadTitle5=" + HeadCol25 + "&HeadTitle6=" + HeadCol26;
	}else if(sheetObj2!=null && sheetObj2.id == "sheet5"){
		sParam=sParam + "&HeadTitle1=" + HeadCol31 + "&HeadTitle2=" + HeadCol32 + "&HeadTitle3=" + HeadCol33 + "&HeadTitle4=" + HeadCol34 + "&HeadTitle5=" + HeadCol35 + "&HeadTitle6=" + HeadCol36;
	}else{
		sParam=sParam + "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
	}
	if(sheetObj1!=null){
		sParamSheet1=ComGetSaveString(sheetObj1,true,true,-1);
	}
	if(sheetObj2!=null){
		sParamSheet2=ComGetSaveString(sheetObj2);
	}
	if(sheetObj3!=null){
		sParamSheet3=ComGetSaveString(sheetObj3,true,true,-1);
	}
	if(sParamSheet1 != ""){
		sParam=sParam + "&" + sParamSheet1;
	}
	if(sParamSheet2 != ""){
		sParam=sParam + "&" + sParamSheet2;
	}
	if(sParamSheet3 != ""){
		sParam=sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
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
//		openPfTypePopup(sheetObj, Row);
		openPfTypePopup(sheetObj, Row, Col);
	}
}
function openPfTypePopup(sheetObj, Row, Col){
	
	callback_row = Row + ":" + Col;
	
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0212_POP.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	var rValue=ComOpenPopup(sUrl, 500, 407, "callBackVopVsk0212", "0,0", true); // pf_svc_tp_cd:pf_svc_tp_cd	
}

function callBackVopVsk0212(rtnVal) {
	
	var formObj=document.form;
	
	var arrTemp = callback_row.split(":");
	var arrRow = arrTemp[0];
	var arrCol = arrTemp[1];
	
	if(rtnVal) {
		formObj.pf_svc_tp_cd.value =rtnVal;
	
		if (formObj.pf_svc_tp_cd.value!="") {	
			sheet1.SetCellValue(arrRow, arrCol,rtnVal,0);			
			doActionIBSheet(sheet1, formObj, SEARCH09);
		}
		
		HeadCol1="";
		HeadCol2="";
		HeadCol3="";
		HeadCol4="";
		HeadCol5="";
		HeadCol6="";
		HeadCol21="";
		HeadCol22="";
		HeadCol23="";
		HeadCol24="";
		HeadCol25="";
		HeadCol26="";
		HeadCol31="";
		HeadCol32="";
		HeadCol33="";
		HeadCol34="";
		HeadCol35="";
		HeadCol36="";

		sheet2 = sheet2.Reset();
		ComConfigSheet (sheet2);
		initSheet(sheet2,2);
		ComEndConfigSheet(sheet2);
		
		sheet4 = sheet4.Reset();
		ComConfigSheet (sheet4);
		initSheet(sheet4,2);
		ComEndConfigSheet(sheet4);
		
		sheet5 = sheet5.Reset();
		ComConfigSheet (sheet5);
		initSheet(sheet5,2);
		ComEndConfigSheet(sheet5);
		
		formObj.vsl_slan_cd.focus();
	}
}

function callBackVopVsk0202(rtnVal){
	var formObj=document.form;	
	var rVal = rtnVal[0];
	
	if (rVal.length > 0) {
		formObj.vsl_slan_cd.value = rVal[1];
	}
	
	if(formObj.vsl_slan_cd.value!="" && formObj.tmp_vsl_slan_cd.value!=formObj.vsl_slan_cd.value){
		var vsl_slan_cd= formObj.vsl_slan_cd.value;
		initPage();
		formObj.tmp_vsl_slan_cd.value=vsl_slan_cd;
		formObj.vsl_slan_cd.value=vsl_slan_cd;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
}
/**
 * openPfTypePopup(sheetObj, Row, Col) 생성 2013-10-22
function openPfTypePopup(sheetObj, Row){
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	var rValue=ComOpenPopupWithTarget(sUrl, 306, 407, "sheet1_pf_svc_tp_cd:pf_svc_tp_cd", "0,0", true);
	if(rValue){
		if(formObj.pf_svc_tp_cd.value!=""){
			for(var i=1; i<sheetObj.LastCol(); i++){
				sheetObj.SetCellValue(Row, i,formObj.pf_svc_tp_cd.value,0);
			}
			doActionIBSheet(sheetObj, formObj, SEARCH09);
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
*/
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
function adjustEndDate() {
	var formObj    = document.form;
	var sheetObj   = sheetObjects[0];
	var vslCnt     = formObj.vsl_cnt.value;
	var headerRows = sheetObj.HeaderRows();
	var iVslCnt    = vslCnt.parseInt();
	
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
			if(tgtVslCd==sheetObj.GetCellValue(i, "VVD1")){
				tgtRow=i;
			}
		}
		if(tgtRow==""){
			return null;
		}
		// Finding Last Port of P/F
		for(var i=sheetObj.LastCol()-2; i >3; i=i-2 ){
			// Skip Added Port
			if(""==sheetObj.GetCellValue(2, i) || "*"==sheetObj.GetCellValue(2, i)){
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
	var srcName=event.srcElement.name;
	var formObj=document.form;
	var eventElement=event.srcElement;
	switch(eventElement.name){
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
function manageStartInfo() {
	var sheetObj       = sheetObjects[0];
	var formObj        = document.form;    
    var nowInfo        = ComGetNowInfo();
    var headerRow      = sheetObj.HeaderRows();
    var brth_itval_dys = Number(formObj.brth_itval_dys.value);
    
    sheetObj.RenderSheet(0);
    setGetColHidden(sheetObj,parseInt(formObj.vsl_cnt.value));
    for (var i = 1; i < sheetMaxCol; i++) {
    	if (formObj.vsl_cnt.value >= i) {
	   		sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow , "Vsl_" + i,ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys),0);
	   		sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow    , "Vsl_" + i,formObj.pf_svc_tp_cd.value,0);	   		
	    } else {
	    	sheetObj.SetCellValue(headerRow + sheet1StartDateDataRow , "Vsl_" + i,"");
	   		sheetObj.SetCellValue(headerRow + sheet1PfTypeDataRow    , "Vsl_" + i,"");
	    }
    }
    sheetObj.RenderSheet(1);
    
    adjustEndDate();
}

function extend() {
	
	var objs=document.all.item("startinfo");
    if (!extendFlag) {
    	sheet1.SetVisible(0);
	    document.getElementById("btn_Extend").style.display="none";
	    document.getElementById("btn_Reduce").style.display="inline";
	    extendFlag=true;
	}
    
    /*
	var objs=document.all.item("startinfo");
    
	if (!extendFlag) {
    	h1=sheetObjects[0].GetSheetHeight().replace(/[^0-9]/g, "") ;
    	h2=sheetObjects[1].GetSheetHeight().replace(/[^0-9]/g, "") ;
    	document.getElementById("scrollBox").SetSheetHeight(405);
    	sheetObjects[0].RenderSheet(0);
    	objs.style.display="none";
    	sheetObjects[0].RenderSheet(1);
//    	sheetObjects[1].Redraw = false;
//	    sheetObjects[1].style.height = Number(h1) + Number(h2) + 1;
//	    sheetObjects[1].Redraw = true;
    	if(HeadCnt == "1"){
    		sheetObjects[1].RenderSheet(0);
    	    sheetObjects[1].SetSheetHeight(Number(h1) + Number(h2)-1);
    	    sheetObjects[1].RenderSheet(1);
    	}else if(HeadCnt == "2"){
    		sheetObjects[1].RenderSheet(0);
    		sheetObjects[3].RenderSheet(0);
//    		sheetObjects[1].style.height = Number(h1)/2 + Number(h2);
//    	    sheetObjects[3].style.height = Number(h1)/2 + Number(h2);
//    		sheetObjects[1].style.height = 200;
//    	    sheetObjects[3].style.height = 200;
    		sheetObjects[1].SetSheetHeight(220);
        	sheetObjects[3].SetSheetHeight(220);
        	sheetObjects[1].RenderSheet(1);
    	    sheetObjects[3].RenderSheet(1);
    	}else if(HeadCnt == "3"){
    		sheetObjects[1].RenderSheet(0);
    		sheetObjects[3].RenderSheet(0);
    		sheetObjects[4].RenderSheet(0);
//    		sheetObjects[1].style.height = Number(h1)/3 + Number(h2);
//    	    sheetObjects[3].style.height = Number(h1)/3 + Number(h2);
//    	    sheetObjects[4].style.height = Number(h1)/3 + Number(h2);
//    		sheetObjects[1].style.height = 180;
//    	    sheetObjects[3].style.height = 180;
//    	    sheetObjects[4].style.height = 180;
    	    sheetObjects[1].SetSheetHeight(220);
        	sheetObjects[3].SetSheetHeight(220);
        	sheetObjects[4].SetSheetHeight(220);
    	    sheetObjects[1].RenderSheet(1);
    	    sheetObjects[3].RenderSheet(1);
    	    sheetObjects[4].RenderSheet(1);
    	}
	    document.getElementById("extend").style.display="none";
	    document.getElementById("reduce").style.display="block";
	    extendFlag=true;
	}
	*/
}

function getArrayRemoveDupVal(array) {
	var result = [];
	$.each(array, function(index, element) {
		if ($.inArray(element, result) == -1) {
			result.push(element);
		}
	});
	return result;
}

function reduce(){
	var objs=document.all.item("startinfo");
    if ( extendFlag ) {
    	sheet1.SetVisible(1);
//    	h1=sheetObjects[0].GetSheetHeight().replace(/[^0-9]/g, "") ;
//    	h2=sheetObjects[1].GetSheetHeight().replace(/[^0-9]/g, "") ;
    	//sheet2.RenderSheet(0);
    	
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
	sheetObjects[1].RenderSheet(0);
	if(curWinHeight<=parentInitWinHeight){
		parent.window.document.getElementById("main").SetSheetHeight(initMainHeight);
		sheetObjects[1].SetSheetHeight(322);
	}else if(curWinHeight>parentInitWinHeight){
		var gap=Number(curWinHeight) - Number(parentInitWinHeight);
		parent.window.document.getElementById("main").SetSheetHeight(Number(curMainHeight) + Number(gap));
		sheetObjects[1].SetSheetHeight(Number(sheetHeight) + parseInt(gap/20)*20);
	}
	sheetObjects[1].RenderSheet(1);
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
function getSvcDurDys(pfSvcTpCd){
	var sheetObj=sheetObjects[2];
	var svcDurDys="0";
	if(sheetObj.RowCount()>0){
		for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+sheetObj.RowCount(); Row++){
			if(sheetObj.GetCellValue(Row, "pf_svc_tp_cd")==pfSvcTpCd){
				svcDurDys=Math.ceil(sheetObj.GetCellValue(Row, "svc_dur_dys"));
				break;
			}
		}
		return svcDurDys;
	}
}
function initVoyType() {
	document.getElementById("voy_no_type").disabled=false;	
	document.getElementById("voy_no_type").value="0";
	document.getElementById("voy_type_cnt").readOnly=false;
	document.getElementById("voy_type_cnt").className="Input";
	document.getElementById("voy_type_cnt").value="1";	
}

function setPopResult( rtnVal ){
	vvdDeleteReason = rtnVal;
	return rtnVal;
}

function voyageTypeSequence(formObj) {
	sheetObj=sheetObjects[0];
	if(document.getElementById("voy_type_cnt").value == "0"){
		ComShowCodeMessage("COM12133","Inputted interval Number","0","large");
		document.getElementById("voy_type_cnt").value="1";
	}
	if ((document.getElementById("voy_no_type").value == "2") 
		 && (sheetObj.GetCellValue(3,1) != "")
	     && (document.getElementById("voy_type_cnt").value != "")) {
		var initValue=sheetObj.GetCellValue(3,1);
		var calValue=0;
		var jmpValue=document.getElementById("voy_type_cnt").value; 
        var  k=2;
		for (var i=1; i < formObj.vsl_cnt.value; i++) {
			initValue=sheetObj.GetCellValue(3,i);
			calValue=parseInt(initValue,10) + parseInt(jmpValue,10);
			sheetObj.SetCellValue(3, k,(""+calValue).lpad(4, "0"),0);
			k++;
		}
	}
}

function sheet1_OnSearchEnd(sheetObj , code , msg ) {
   if( sheetObj.RowCount() < 1){
	   InitHeadColumn(leftHeaders,sheetObj);
          
   } else {
	   InitHeadText(leftHeaders,sheetObj);
	   sheet1_left_Reset(sheetObj);
   }
}

function sheet1_left_Reset(sheetObj) {
	
	sheetObj.SetRowHidden(sheet1PfDateDataRow+sheetObj.HeaderRows(),1);// Hidden PF_DATE
	var formObj=document.form;
	
	for (var i=0 ; i <sheet1DataRows ; i++) {
		for ( var j = 1; j < sheetMaxCol; j++) {
			if (i == sheet1VslCdDataRow+1) {
				sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N|E" , InputCaseSensitive:1, EditLen:4});
			} else if (i == sheet1VoyNoDataRow+1) {
				sheetObj.InitCellProperty(i, j, { Type:"Text", Format:"" , AcceptKeys:"N", EditLen:4});
			} else if (i == sheet1PfTypeDataRow+1) {
				sheetObj.InitCellProperty(i, j, {Type:"Popup", Format:""});
			} 
		}
	}	
}
