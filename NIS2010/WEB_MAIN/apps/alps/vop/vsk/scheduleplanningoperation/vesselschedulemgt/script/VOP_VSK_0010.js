/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0010.js
 *@FileTitle : Long Range SKD Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.14
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.05.25 유혁
 * 1.0 Creation
 * 
 * History
 * 2010.09.09 유혁 CHM-201005742-01 Non-Weekly P/F SKD 생성과 관련한 LRS 생성
 * 2010.09.16 유혁 CHM-201005617-01 Phase in Pop-Up 시 Direction Code와 Port Code가 미지정된 상태이면
 *									유저에게 선택 가능한 Direction Code/Port Code Combo를 제공한다.
 * 2012.05.14 진마리아 CHM-201217742-01 PF 사용하여 SKD 생성시 DELETE YARD 제어 로직 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class LRS Creation : LRS Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0010() {
	this.processButtonClick	= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.setTabObject 		= setTabObject;
	this.validateForm 		= validateForm;
}

/* 개발자 작업	*/

 // 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var bkgVVDs = new Array();
var virVVDs = new Array();
var bkgVirVVDs = new Array();
var nonBkgVVDs = new Array();
var vvdDeleteReason = "";

var dataStartCol = 4;
var dataStartRow = 6;
var bufferColCount = 2;
var dataSetCnt = 4;

var HeadCol1 = ""; // SKD_DIR_CD
var HeadCol2 = ""; // VPS_PORT_CD
var HeadCol3 = ""; // ETB_DY_CD/ETD_DY_CD
var HeadCol4 = ""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol5 = ""; // P/F CLPT_SEQ
var HeadCol6 = ""; // YARD_CD

var bakObj = null;
var skipvalue = " SKIP";
var pfSkdValidation = null;

var sheet1DataRows = 5; // sheet1의 모든 Row 갯수
var sheet1ViewDataRows = 4; // sheet1의 보이는 Row 갯수
var sheet1StartDateDataRow = 0;
var sheet1VslCdDataRow = 1;
var sheet1VoyNoDataRow = 2;
var sheet1PfTypeDataRow = 3;
var sheet1PfDateDataRow = 4;

var sheet2DirCdHeaderRow = 0;
var sheet2VpsPortCdHeaderRow = 1;
var sheet2DyCdHeaderRow = 2;
var sheet2TmHrmntHeaderRow = 3;
var sheet2ClptIndSeqHeaderRow = 4;
var sheet2YdCdHeaderRow = 5;

var sheet2InitDateRowPos = 1;
var sheet2PfDateRowPos = 2;
var sheet2StatusRowPos = 3;

var simplePIN = false; // P/IN으로 초기 스케쥴을 생성하는 경우의 상태 플래그
var extendFlag = false; // 초기상태

//var parentInitWinHeight = 0;
//var initMainHeight = 0;
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//window.onresize = function(){
//	// 창 높이에 맞게 sheet의 높이를 조절한다.
//	manageSheetSize();
//}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     
     var sheetObject1 = sheetObjects[0];
     var sheetObject2 = sheetObjects[1];
            
     /*******************************************************/
     var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

    		case "btns_search1":
    			var sUrl = "/hanjin/VOP_VSK_0202.do";
    			var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
				
    			if(!rVal){
    				break;
    			}
    			
    			// 팝업에서 선택한 값이 기존에 있던 값과 다른경우 재조회해야함.
    			if(formObj.vsl_slan_cd.value!="" &&
    					formObj.tmp_vsl_slan_cd.value!=formObj.vsl_slan_cd.value){
    				
    				var vsl_slan_cd = formObj.vsl_slan_cd.value;
    				initPage();
    				formObj.tmp_vsl_slan_cd.value = vsl_slan_cd;
    				formObj.vsl_slan_cd.value = vsl_slan_cd;
    				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
    			}
    			
    			break;
			
    		case "btns_back2":
    			with(formObj){
    				// end_year가 감소될때, start_year가 같이 감소되어야 하는 경우
    				// end_date가 start_date보다 과거의 경우
    				end_year.value = parseInt(end_year.value)-1;
        			end_date.value = ComGetMaskedValue(endQuarterDay(end_year.value,selEndQuarter.value), "ymd");
    			}
    			break;

    		case "btns_next2":
    			with(formObj){
        			end_year.value = parseInt(end_year.value)+1;
        			end_date.value = ComGetMaskedValue(endQuarterDay(end_year.value,selEndQuarter.value), "ymd");
    			}
    			break;
    			
    		case "btns_calendar2":
    			var cal = new ComCalendar();
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
				var check = valid(sheetObject1, formObj);
				if(sheetObject2.RowCount==0){
					// Save할 스케줄이 Simulation 되지 않았음.
					return false;
				}
				if(check){
					// VOP_VSK_0249 화면을 호출. Booking VVD 삭제 사유를 등록한다.
					if(bkgVVDs.length + virVVDs.length + bkgVirVVDs.length > 0){
						var sUrl = "/hanjin/VOP_VSK_0249.do?tp=1";
						
						for(var i=0; i<bkgVVDs.length; i++){
							sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVVDs[i].vslCd + bkgVVDs[i].skdVoyNo + bkgVVDs[i].skdDirCd;
						}
						for(var i=0; i<virVVDs.length; i++){
							sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + virVVDs[i].vslSlanCd + "&bkg_vvd=" + virVVDs[i].vslCd + virVVDs[i].skdVoyNo + virVVDs[i].skdDirCd;
						}
						for(var i=0; i<bkgVirVVDs.length; i++){
							sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVirVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVirVVDs[i].vslCd + bkgVirVVDs[i].skdVoyNo + bkgVirVVDs[i].skdDirCd;
						}
						
						var rVal = ComOpenPopupWithTarget(sUrl, 524, 342, "", "0,0", true);
						
						if(rVal){
							vvdDeleteReason = rVal;
						}else{
							// VOP_VSK_0249 화면을 그냥 Close 한 경우
							vvdDeleteReason = null;
						}
					}
					if(vvdDeleteReason!=null){
						doActionIBSheet(sheetObject2,document.form,IBSAVE);
					}
				}
				break;
				
			case "btn_Simulation":
				if(ComIsBtnEnable('btn_Simulation')){
					formObj.op_type.value = "btn_Simulation";
					
					if(pfSkdValidation==false){
						return false;
					}
					
					// P/F Duration이 소숫점으로 되어 있으면 오류
					if(formObj.svc_dur_dys.value.indexOf(".")>-1){
						ComShowCodeMessage("VSK00096", "Duration");
						return false;
					}
					
					bkgVVDs = new Array();
					virVVDs = new Array();
					bkgVirVVDs = new Array();
					nonBkgVVDs = new Array();
					
					var check = false;
					var headerRows = sheetObjects[0].HeaderRows;
					
					for(var i=1; i<=4; i++){
						for(var k=1; k<=formObj.vsl_cnt.value; k++){
							if(sheetObject1.CellValue(i, "Vsl_" + k)==''){
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
								check = true;
							}
						}
						if(!check){
							break;
						}
					}
					
					if(check){
						
						var vessels = new Array();
						var sheetObj = sheetObjects[0];
						
						if(!checkPeriod(sheetObj, formObj)){
							ComShowCodeMessage("VSK00105", "2 year");
							return false;
						}
						
   						// vessel code 별로 voyage 를 체크한다.
						for(var i=1,k=0; i<sheetObj.LastCol; i++){
							if(sheetObj.CellValue(2, i)!=""){
								var obj = new Object();
								obj.startDate = sheetObj.CellValue(sheet1StartDateDataRow + sheetObj.HeaderRows, i);
								obj.vslCd = sheetObj.CellValue(sheet1VslCdDataRow + sheetObj.HeaderRows, i);
								obj.skdVoyNo = sheetObj.CellValue(sheet1VoyNoDataRow + sheetObj.HeaderRows, i);
								
								obj.voyNo = "";
								obj.skdDirCd1 = "";
								obj.skdDirCd2 = "";
								obj.duration = "";
								
								vessels[k++] = obj;
							}
						}
						
						for(var i=0; i<vessels.length; i++){
							
							var sUrl = "/hanjin/VOP_VSK_0211.do";
							sUrl = sUrl + "?vsl_cd=" + vessels[i].vslCd 
										   + "&skd_voy_no=" + vessels[i].skdVoyNo 
										   + "&start_date=" + vessels[i].startDate
										   + "&end_date=" + formObj.end_date.value
										   + "&vsl_cnt=" + formObj.vsl_count.value
										   + "&voy_no_type=" + formObj.voy_no_type.value
										   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
										   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
										   + "&duration=" + formObj.svc_dur_dys.value;
							
							var rVal = ComOpenPopupWithTarget(sUrl, 506, 527, "", "0,0", true);
							
							if(rVal){
								bkgVVDs = bkgVVDs.concat(rVal.bkgVVDs);
								virVVDs = virVVDs.concat(rVal.virVVDs);
								bkgVirVVDs = bkgVirVVDs.concat(rVal.bkgVirVVDs);
								nonBkgVVDs = nonBkgVVDs.concat(rVal.nonBkgVVDs);
								continue;
							}else{
								return false;
							}
							
						}
						
						var xml = doActionIBSheet(sheetObject2,formObj,SEARCH10);
//						doActionIBSheet(sheetObject2,formObj,SEARCH02);

					}
					
				}
				break;

			case "btn_Delete":
				var row = sheetObject2.SelectRow;
				var col = sheetObject2.SelectCol;
				
				if(row<6){
					// 헤더인 경우 delete 안됨
					ComShowCodeMessage('VSK00061');
				}else{
					var vvd = sheetObject2.CellValue(row, "VVD1") + sheetObject2.CellValue(row, "VVD2") + sheetObject2.CellValue(row, "VVD3");
					
					if(ComShowCodeConfirm("VSK00062", vvd)){
						
						// 삭제할려는 VVD가 화면상에서 해당 Vessel의 마지막 항차인지 검사한다.
						if(isFinalVVD(sheetObject2, row)){

							// 삭제할려는 항차의 첫번째 Port Schedule이 연결되는 이전 항차의 마지막 Port Schedule과 동일한 경우
							// 마지막 Port Schedule을 삭제해준다.
							lastSkd = findLastSkd(sheetObject2, row);
							if(lastSkd){
								sheetObject2.CellValue2(lastSkd.row, lastSkd.col) = "";
								sheetObject2.CellValue2(lastSkd.row, lastSkd.col+1) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2InitDateRowPos, lastSkd.col) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2InitDateRowPos, lastSkd.col+1) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2PfDateRowPos, lastSkd.col) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2PfDateRowPos, lastSkd.col+1) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2StatusRowPos, lastSkd.col) = "";
								sheetObject2.CellValue2(lastSkd.row+sheet2StatusRowPos, lastSkd.col+1) = "";
							}
							
						}else{
							
							// 마지막 VVD가 아닌 중간 VVD에서 삭제하는 경우
							// 만약 연결되어 있는 스케쥴을 삭제한다.
							linkSkd = findPrevLinkSkd(sheetObject2, row, sheetObject2.SaveNameCol("VVD3") + 1);
							if(linkSkd){
								sheetObject2.CellValue2(linkSkd.tgtRow, linkSkd.tgtCol) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow, linkSkd.tgtCol+1) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2InitDateRowPos, linkSkd.tgtCol+1) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2PfDateRowPos, linkSkd.tgtCol) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2PfDateRowPos, linkSkd.tgtCol+1) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol) = "";
								sheetObject2.CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1) = "";
							}									
						}
						
						sheetObject2.RowDelete(row, false);
						sheetObject2.RowDelete(row, false);
						sheetObject2.RowDelete(row, false);
						sheetObject2.RowDelete(row, false);
						
						// TODO
						// VOP_VSK_0211 화면에 의해 삭제 대상인 VVD 목록에서
						// Row Delete 하고자 하는 VVD가 포함되어 있으면 삭제해준다.
						// 즉, 생성하는 VVD가 아니므로 기존 VVD를 삭제하지 않아야 한다.
						
					}
				}
				
				break;
				
			case "btn_PhaseIn":
					formObj.op_type.value = "btn_PhaseIn";
					phaseIn(sheetObject2);
					sheet2_SetColor(sheetObject2);
				break;
				
			case "btn_PhaseInCancel":
					formObj.op_type.value = "btn_PhaseInCancel";
					phaseInCancel(sheetObject2);
					sheet2_SetColor(sheetObject2);
				break;
			
			case "btn_PhaseOut":	
					formObj.op_type.value = "btn_PhaseOut";
					phaseOut(sheetObject2,"VVD1");
				break;
			
			case "btn_PhaseOutCancel":
					formObj.op_type.value = "btn_PhaseOutCancel";
					phaseOutCancel(sheetObject2);
				break;
				
			case "btn_AddCall":
					formObj.op_type.value = "btn_AddCall";
					var row = sheetObject2.SelectRow;
					var col = sheetObject2.SelectCol; // 사용자가 클릭한 포트의 컬럼 위치
					var addTargetCol = 0; // Add 되어 들어갈 포트 컬럼 위치
					
					col = startColPos(sheetObject2, 0);
					
					// add call 정보 획득후, 다른 기능의 동작을 위해 sheet의 selection 정보 초기화
					sheetObject2.SelectCell(row, 1, false);
					
					formObj.add_call_point.value = PortPosition(col);
					formObj.add_vvd_point.value = VvdPosition(sheetObject2.SelectRow);
					
	            	if(formObj.add_call_point.value==-1 || "skd_rmk"==sheetObject2.ColSaveName(col)){
	            		ComShowCodeMessage('VSK00059');
	            		break;
	            	}
	            	
	            	// Add Call 정보획득
	            	var sUrl = "";
	            	if(countAddCallPort(sheetObject2, row, col)>0){
	            		// 다른 VVD에 의해 이미 add call 된 경우이므로, port cd를 변경하지 못하도록 고정시킨다.
	            		sUrl = "/hanjin/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y&portCd=" + sheetObject2.CellValue(sheet2VpsPortCdHeaderRow, col) + "&ydCd=" +  sheetObject2.CellValue(sheet2YdCdHeaderRow, col);
	            	}else{
	            		sUrl = "/hanjin/VOP_VSK_0215.do?hiddenTurn=Y&hiddenEta=Y&showYard=Y";
	            	}
					var rVal = ComOpenPopupWithTarget(sUrl, 400, 369, "", "0,0", true);
					if(rVal){
						formObj.add_call_port_cd.value = rVal.port_cd;
						formObj.add_call_yard_cd.value = rVal.yard_cd;
						formObj.add_call_etb.value = rVal.etb;
						formObj.add_call_etd.value = rVal.etd;
						formObj.add_call_turn_ind.value = rVal.turn_ind;
						formObj.add_call_position.value = rVal.position;
						
		            	// 선택한 포트(사용자가 클릭하여 지정한 포트)가 Add 상태인  포트의 경우
		            	if(countAddCallPort(sheetObject2, row, col)>0){
		            		
		            		addTargetCol = col;

    						sheetObject2.CellValue2(row, addTargetCol) = formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm");
    						sheetObject2.CellValue2(row, addTargetCol+1) = formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm");
    					
		            	}else{
		            		
		            		// 선택한 포트가 Add 상태 포트가 아닌 경우
		            		// 1. before/after 대상의 컬럼이 Add 할려는 포트인 경우
		            		// 2. 1의 경우가 아닌 경우(새롭게 컬럼이 생겨야 하는 경우)
		            		
		            		var check = checkTargetPortIsAddPort(sheetObject2, row, col);
		            		if(check){
		            			
		            			if("before"==formObj.add_call_position.value){
		            				addTargetCol = col - 2;
		            			}else if("after"==formObj.add_call_position.value){
		            				addTargetCol = col + 2;
		            			}
		            			
		            			sheetObject2.CellValue2(row, addTargetCol) = formatDate(new Date(getDateFromFormat(rVal.etb, "yyyyMMddHHmm")), "MM/ddyyyyHHmm");
        						sheetObject2.CellValue2(row, addTargetCol+1) = formatDate(new Date(getDateFromFormat(rVal.etd, "yyyyMMddHHmm")), "MM/ddyyyyHHmm");
        						
		            		}else{
		            		
        		            	// Add를 하면 컬럼이 하나 더 생긴다.
        		            	// col 값은 Add 하기 이전 사용자가 클릭한 포트의 column 값인데
        		            	// before 상태로 Add 하면, col 값을 따라가면 Add한 포트의 column 위치가 된다.
    							// 그러므로, Add 상태(before/after) 상태에 따라서 
    							// Add를 시도한 포트의 컬럼값(col), Add된 포트의 컬럼값(addTargetCol)을 조정해준다.

    							if("after"==formObj.add_call_position.value){
        		            		addTargetCol = col + 2;
        		            	}else if("before"==formObj.add_call_position.value){
        		            		addTargetCol = col;
        		            		col = col + 2;
        		            	}

    							doActionIBSheet(sheetObject2,formObj,SEARCH05);
		            		}
		            		
		            	}
		            	
						// Add Call에 들어가는 시간은 VPS_ET이며,
						// INIT_ET 에도 같은 시간을 넣어준다.
						sheetObject2.CellValue2(row + sheet2InitDateRowPos, addTargetCol) = sheetObject2.CellValue(row, addTargetCol);
						sheetObject2.CellValue2(row + sheet2InitDateRowPos, addTargetCol+1) = sheetObject2.CellValue(row, addTargetCol+1);
						
						sheetObject2.CellValue2(row + sheet2StatusRowPos, addTargetCol) = "A";
						sheetObject2.CellValue2(row + sheet2StatusRowPos, addTargetCol+1) = "A";
						sheet2_SetColor(sheetObject2);
						
					}
				break;
				
			case "btn_AddCallCancel":
					formObj.op_type.value = "btn_AddCallCancel";
					
					var row = sheetObject2.SelectRow;
					var col = sheetObject2.SelectCol;
					
					col = startColPos(sheetObject2, 0);
					
					formObj.add_call_point.value = PortPosition(col);
					formObj.add_vvd_point.value = VvdPosition(sheetObject2.SelectRow);
					
					if(formObj.add_call_point.value==-1 || "skd_rmk"==sheetObject2.ColSaveName(col)){
						ComShowCodeMessage('VSK00059');
						break;
					}
					
					if("A"!=sheetObject2.CellValue(row+sheet2StatusRowPos, col)){
						ComShowCodeMessage('VSK00060');
						break;
					}
					
					if(countAdding(sheetObject2, col)>1){
						// 현재 Port에 2번 이상 Add Call이 된 경우
						sheetObject2.CellValue2(row, col) = "";
						sheetObject2.CellValue2(row, col+1) = "";
						sheetObject2.CellValue2(row+sheet2InitDateRowPos, col) = "";
						sheetObject2.CellValue2(row+sheet2InitDateRowPos, col+1) = "";
						sheetObject2.CellValue2(row+sheet2StatusRowPos, col) = "";
						sheetObject2.CellValue2(row+sheet2StatusRowPos, col+1) = "";
					}else if(countAdding(sheetObject2, col)==1){
						// 1회 Add Call 된 경우는 그리드에서 해당 컬럼을 삭제한다.
						doActionIBSheet(sheetObject2,formObj,SEARCH06);
        			}
				sheet2_SetColor(sheetObject2);
				
				break;
				
			case "btn_SkipCall":
					formObj.op_type.value = "btn_SkipCall";
					skipCall(sheetObject2);
				break;
			
			case "btn_SkipCallCancel":
					formObj.op_type.value = "btn_SkipCallCancel";
					skipCallCancel(sheetObject2);
    					break;
    				
 

                } // end switch
        
        // 엔터키 계속 누르면 같은 이벤트 차단
        
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var formObj = document.form;
	
    //for(i=0;i<sheetObjects.length;i++){
	for(i=sheetObjects.length-1; i>=0; i--){
    	
    	//khlee-시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjects[i] );

    	initSheet(sheetObjects[i],i+1);
    	//khlee-마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjects[i]);
    }

    initControl();

	// 현재년도설정
	var today = new Date();
	with(formObj){
		var nowDate = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		end_year.value = today.getFullYear();
		selEndQuarter.value = checkQuarter(nowDate);
		end_date.value = ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
	    vsl_slan_cd.focus();
    }
    setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
    
//    parentInitWinHeight = parent.window.document.body.clientHeight; // 초기창의 높이
//    initMainHeight = parent.window.document.getElementById("main").style.height; // 초기 main 영역의 높이
}

/** 
 * 페이지를 초기화한다.
 */
function initPage() {
	var formObj = document.form;
//	sheetObjects[2].RemoveAll();
	
	reduce();

    HeadCol1 = "";
    HeadCol2 = "";
    HeadCol3 = "";
    HeadCol4 = "";
    HeadCol5 = "";
    HeadCol6 = "";

	sheetObjects[0].Redraw = false;
	sheetObjects[0].RemoveAll();
	sheetObjects[0].Redraw = true;
	
	sheetObjects[1].Redraw = false;
	sheetObjects[1].Reset();
	ComConfigSheet (sheetObjects[1]);
	initSheet(sheetObjects[1],2);
	ComEndConfigSheet(sheetObjects[1]);
	sheetObjects[1].Redraw = true;
    
	simplePIN = false;
    formObj.vsl_slan_cd.value = "";
	formObj.tmp_vsl_slan_cd.value = "";
	formObj.brth_itval_dys.value = "";
	formObj.vsl_cnt.value = "";
	formObj.vsl_count.value = "";
	formObj.pf_svc_tp_cd.value = "";
	formObj.slan_stnd_flg.value = "Y";

	// 현재년도설정
	var today = new Date();
	with (formObj) {
		var nowDate = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		selEndQuarter.value = checkQuarter(nowDate);
    	end_year.value = today.getFullYear();
    	end_date.value = ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
	setColHidden(sheetObjects[0],0);
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
    var formObj = document.form;
    
    switch(sheetObj.id) {
        case 'sheet1':      // Vessel 정보 그리드
			with (sheetObj) {
				
				tabIndex = -1;
				
				// 영문입력모드
				style.imeMode = "inactive";
				
				var headCount = parseInt(formObj.vsl_cnt.value);
				// 높이 설정
				//style.height = 90;
				
				// 전체 너비 설정
//				SheetWidth = 700;
				
				ScrollBar = 0;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, sheet1DataRows, sheet1DataRows, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(21, 0, 1, false);
				
				// 해더기능([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, false, false, false, false);
				
				var HeadTitle1 = "||||||||||||||||||||";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, false, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				ImageList(0) = "/hanjin/img/btns_calendar.gif";
				ImageList(1) = "/hanjin/img/btns_search.gif";
				
				for(var i = 0 ; i <sheet1DataRows ; i++){
					InitDataProperty(i, 0 , dtData,      90, daCenter,  false,   "left",	false,	"",		dfNone,				0,			false,		false);
					
					for ( var j = 1; j < 20; j++) {
						if (i == sheet1StartDateDataRow) {
							InitDataProperty(i, j, dtPopupEditFormat, 95, daCenter, false, "Vsl_" + j, false, "", dfDateYmd, 0, true, true); // Start Date
							//PopupImage  =  "/hanjin/img/btns_calendar.gif";
							PopupButtonImage(i, j) = 0; 
						} else if (i == sheet1VslCdDataRow) {
							InitDataProperty(i, j, dtData, 95, daLeft, false, "Vsl_" + j, false, "", dfNone, 0, true, true, 4); // Vessel Code
							InitDataValid(i, j, vtEngUpOther, "0123456789");
						} else if (i == sheet1VoyNoDataRow) {
							InitDataProperty(i, j, dtData, 95, daLeft, false, "Vsl_" + j, false, "", dfNone, 0, true, true, 4); // Voy No
							InitDataValid(i, j, vtNumericOnly);
						} else if (i == sheet1PfTypeDataRow) {
							InitDataProperty(i, j, dtPopupEdit, 95, daLeft, false, "Vsl_" + j, false, "", dfNone, 0, true, true, 4); // P/F SKD Type
							InitDataValid(i, j, vtEngUpOther, "0123456789");
							PopupButtonImage(i, j) = 1;
						} 
					}
					
					InitDataProperty(i, j , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
				
				}
				
	            ShowButtonImage = 2;
				
				//dfDateYmd
				
				CountPosition = 0;
				//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
				InitHeadColumn("left", "Start Date|Vessel Code|Start Voy. No.|P/F SKED Type|", daLeft);
				
				RowHidden(sheet1PfDateDataRow+sheetObj.HeaderRows) = true; // PF_DATE 항목은 숨긴다.
				WaitImageVisible = false;
			}            
			
            break;
            
        case 'sheet2':      // 스케쥴 그리드
            with (sheetObj) {
            	
                // 높이 설정
                style.height = 322;

                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                UnEditableColor = RgbColor(255, 255, 255);

                //행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                // dataSetCnt = 1 일때, VPS_ET 또는 SKIP
                // dataSetCnt = 2 일때, INIT_ET
                // dataSetCnt = 3 일때, PF_ET
                // dataSetCnt = 4 일때, SKIP에 해당하는 VPS_ET 백업 또는 각종 상태코드(A 등)
                //InitRowInfo(dataStartRow, dataSetCnt, 4, 100);
                InitRowInfo(dataStartRow, dataSetCnt, 10);

              
				var HeadTitle1 = "| | | "+HeadCol1+"|Remark(s)|";
				var HeadTitle2 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol2+"|Remark(s)|";
				var HeadTitle3 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol3+"|Remark(s)|";
				var HeadTitle4 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol4+"|Remark(s)|";
				var HeadTitle5 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol5+"|Remark(s)|";
				var HeadTitle6 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol6+"|Remark(s)|";
				var headCount = ComCountHeadTitle(HeadTitle1);  

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                SetMergeCell 쓰는버전
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, false);
                InitHeadRow(2, HeadTitle3, false);
                InitHeadRow(3, HeadTitle4, false);
                InitHeadRow(4, HeadTitle5, false, true);
                InitHeadRow(5, HeadTitle6, false);
                
//                SetMergeCell 안쓰는버전
//                InitHeadRow(0, HeadTitle1, true);
//                InitHeadRow(1, HeadTitle2, true);
//                InitHeadRow(2, HeadTitle3, false);
//                InitHeadRow(3, HeadTitle4, false);
//                InitHeadRow(4, HeadTitle5, false, true);
//                InitHeadRow(5, HeadTitle6, true);
                
                var portNum = parseInt(ComCountHeadTitle(HeadCol1)-1)/2;
                
				for(var i = 0 ; i < dataSetCnt ; i++){
                	cnt = 0;
					
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(i, cnt++ , dtHiddenStatus,	30,	daCenter,	true,			"ibflag");
					InitDataProperty(i, cnt++ , dtData,     	40,	daCenter,	true,			"VVD1",					false,	"",		dfNone,				0,			false, 	false);
					InitDataProperty(i, cnt++ , dtData,		80,	daCenter,	true,			"VVD2",					false,	"",		dfNone,				0,			false, 	false);
					InitDataProperty(i, cnt++ , dtData,		40,	daCenter,	true,			"VVD3",					false,	"",		dfNone,				0,			false, 	false);
		    		
		    		for(var j = 0 ; j < portNum ; j++){
						if(i==0){
							InitDataProperty(i, cnt++ , dtData,		33,	daLeft,	false,		"ETB"+j,  			false,	"",		dfNone,				0,			false,	false);
							InitDataProperty(i, cnt++ , dtData,		33,	daLeft,	false,		"ETD"+j,  			false,	"",		dfNone,				0,			false,	false);
						}else{
							InitDataProperty(i, cnt++ , dtData,		33,	daLeft,	false,		"ETB"+j,  			false,	"",		dfNone,				0,			false,	false);
							InitDataProperty(i, cnt++ , dtData,		33,	daLeft,	false,		"ETD"+j,  			false,	"",		dfNone,				0,			false,	false);
						}
					}
					InitDataProperty(i, cnt++ , dtData,		200,	daLeft,	true,		"skd_rmk",					false,	"",		dfNone,				0,			false,		false);
					InitDataProperty(i, cnt++ , dtHidden,		30,	daCenter,	true,			"out",		false,	"",		dfNone,						0,			true,		true);
				}
				
				
				CountPosition = 0;
				
				RowHeight(1) = 20;
				RowHeight(2) = 20;
				RowHeight(3) = 20;
				RowHeight(4) = 20;
				RowHeight(5) = 20;
//				HeadRowHeight = 20;
				
				// 헤더의 Port와 Yard 컬럼을 2개씩 merge 한다.
				var etbStartIdx = 4;
				for(var i=0; i<portNum*2; i=i+2){
					SetMergeCell(sheet2VpsPortCdHeaderRow, etbStartIdx+i, 1, 2); // Port Row
					SetMergeCell(sheet2YdCdHeaderRow, etbStartIdx+i, 1, 2); // Yard Row
				}
				
				MultiSelection = false;
				WaitImageVisible = false;
		   }
            break;
            
        case 'sheet3' : 	// P/F SKD 정보
			with(sheetObj) {
				
				tabIndex = -1;
				
				// 높이 설정
				style.height = 0;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				UnEditableColor = RgbColor(255, 255, 255);

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				var HeadTitle = "|vsl_slan_cd|skd_dir_cd|port_cd|yd_cd|clpt_seq|call_yd_ind_seq|port_rotn_seq|turn_port_flg|turn_port_ind_cd|eta_dy_cd|eta_dy_no|eta_tm_hrmnt|etb_dy_cd|etb_dy_no|etb_tm_hrmnt|etd_dy_cd|etd_dy_no|etd_tm_hrmnt|mnvr_in_hrs|mnvr_out_hrs|sea_buf_hrs|port_buf_hrs";
				var headCount = ComCountHeadTitle(HeadTitle);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, false, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(i, cnt++, dtData, 30, daCenter, true, "ibflag");
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "vsl_slan_cd"			,false,"", dfNone, 0, true, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "skd_dir_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "port_cd"				,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "yd_cd"					,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "clpt_seq"				,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "call_yd_ind_seq"	,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "port_rotn_seq"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "turn_port_flg"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "turn_port_ind_cd"	,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "eta_dy_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "eta_dy_no"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "eta_tm_hrmnt"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_dy_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_dy_no"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_tm_hrmnt"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_dy_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_dy_no"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_tm_hrmnt"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "mnvr_in_hrs"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "mnvr_out_hrs"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "sea_buf_hrs"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "port_buf_hrs"		,false,"", dfNone, 0, false, false);
			}
			break;
    }
}

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

       case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			if(validateForm(sheetObj,formObj,sAction)) {
				//
			}
			

			if ( sheetObj.id == "sheet1"){
				var sParam = FormQueryString(formObj);
				//sheetObj.DoSearch("VOP_VSK_0010GS_1.do" , sParam);
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0010GS.do" , sParam);
				ComOpenWait(false);
				
				if(ComGetEtcData(sXml, "vsl_slan_nm")){
					sheetObj.ScrollBar = 1;
					
					formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
					formObj.vsl_cnt.value = ComGetEtcData(sXml, "vsl_count");
					formObj.vsl_count.value = ComGetEtcData(sXml, "vsl_count");
					formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
					formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
					formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
					
					// Lane Code를 변경했을때 가져오는 정보는 Stand Type이다.
					formObj.stnd_pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
					
					sheetObjects[2].LoadSearchXml(sXml);
					manageStartInfo();
					
				}else{
					sheetObjects[2].LoadSearchXml(sXml);
					initPage();
					formObj.tmp_vsl_slan_cd.value = "";
					formObj.vsl_slan_cd.value = "";
					formObj.vsl_slan_cd.focus();
				}
				
			}else if ( sheetObj.id == "sheet2"){
			
				var sParam = FormQueryString(formObj)+ "&" + ComGetSaveString(sheetObjects[0]);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0010GS.do" , sParam);
	            HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");
	            HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");
	            HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");
	            HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");
	            HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
	            HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");

	            sheetObj.Reset();
                ComConfigSheet (sheetObj);
                initSheet(sheetObj,2);
                ComEndConfigSheet(sheetObj);
				sheetObj.LoadSearchXml(sXml);
			}
			
			break;

		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
			
			if (validateForm(sheetObj, formObj, sAction)){
				var sParam = FormQueryString(formObj)+ "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
				sParam = sParam + vvdDeleteReason;
				var param = "";
				
				for(var i=0; i<bkgVVDs.length; i++){
					param = param + "&bkg_ibflag=I";
					param = param + "&bkg_vsl_slan_cd=" + bkgVVDs[i].vslSlanCd;
					param = param + "&bkg_vsl_cd=" + bkgVVDs[i].vslCd;
					param = param + "&bkg_skd_voy_no=" + bkgVVDs[i].skdVoyNo;
					param = param + "&bkg_skd_dir_cd=" + bkgVVDs[i].skdDirCd;
					param = param + "&bkg_turn_skd_voy_no=" + bkgVVDs[i].turnSkdVoyNo;
					param = param + "&bkg_turn_skd_dir_cd=" + bkgVVDs[i].turnSkdDirCd;
				}
				
				for(var i=0; i<virVVDs.length; i++){
					param = param + "&vir_ibflag=I";
					param = param + "&vir_vsl_slan_cd=" + virVVDs[i].vslSlanCd;
					param = param + "&vir_vsl_cd=" + virVVDs[i].vslCd;
					param = param + "&vir_skd_voy_no=" + virVVDs[i].skdVoyNo;
					param = param + "&vir_skd_dir_cd=" + virVVDs[i].skdDirCd;
					param = param + "&vir_turn_skd_voy_no=" + virVVDs[i].turnSkdVoyNo;
					param = param + "&vir_turn_skd_dir_cd=" + virVVDs[i].turnSkdDirCd;
				}
				
				for(var i=0; i<bkgVirVVDs.length; i++){
					param = param + "&bkg_vir_ibflag=I";
					param = param + "&bkg_vir_vsl_slan_cd=" + bkgVirVVDs[i].vslSlanCd;
					param = param + "&bkg_vir_vsl_cd=" + bkgVirVVDs[i].vslCd;
					param = param + "&bkg_vir_skd_voy_no=" + bkgVirVVDs[i].skdVoyNo;
					param = param + "&bkg_vir_skd_dir_cd=" + bkgVirVVDs[i].skdDirCd;
					param = param + "&bkg_vir_turn_skd_voy_no=" + bkgVirVVDs[i].turnSkdVoyNo;
					param = param + "&bkg_vir_turn_skd_dir_cd=" + bkgVirVVDs[i].turnSkdDirCd;
				}
				
				for(var i=0; i<nonBkgVVDs.length; i++){
					param = param + "&non_bkg_ibflag=I";
					param = param + "&non_bkg_vsl_slan_cd=" + nonBkgVVDs[i].vslSlanCd;
					param = param + "&non_bkg_vsl_cd=" + nonBkgVVDs[i].vslCd;
					param = param + "&non_bkg_skd_voy_no=" + nonBkgVVDs[i].skdVoyNo;
					param = param + "&non_bkg_skd_dir_cd=" + nonBkgVVDs[i].skdDirCd;
					param = param + "&non_bkg_turn_skd_voy_no=" + nonBkgVVDs[i].turnSkdVoyNo;
					param = param + "&non_bkg_turn_skd_dir_cd=" + nonBkgVVDs[i].turnSkdDirCd;
				}
				
				// 스케쥴 sheet는 항상 입력상태로 유지해준다.
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
					sheetObj.RowStatus(i) = "I";
				}
				
				var sParamSheet2 = ComGetSaveString(sheetObjects[1]);
				if(sParamSheet2 != ""){
					sParam = sParam + "&" + sParamSheet2;
				}
				
				var sParamSheet3 = ComGetSaveString(sheetObjects[2]);
				if(sParamSheet3 != ""){
					sParam = sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
				}
				
				//// sheet1의 정보를 파라미터에 추가
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0010GS.do" , sParam + param);
				ComOpenWait(false);
				sheetObj.LoadSaveXml(sXml);
				
				if(!VskGetErrorXml(sXml)){
					// 스케쥴이 정상적으로 생성 되었으면 작업했던 스케쥴을 모두 삭제
					initPage();
				}
				
			}
			break;

		case SEARCH02: // simulation
			formObj.f_cmd.value = SEARCH02;
			
			var sParam = makeFormString(formObj, sheetObjects[0], null, sheetObjects[2]);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010_1GS.do" , sParam);
			ComOpenWait(false);
			HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");          
            HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");          
            HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");          
            HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");

            sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
            if(!VskGetErrorXml(sXml)){
            	ComBtnEnable("btn_Save");
            }
            if(formObj.voy_no_type.value=="1"){
            	sheetObj.ColWidth("VVD2") = 80;
            }
            extend();
			sheetObj.LoadSearchXml(sXml);
			
			break;
			
		case SEARCH03: // phase in
			formObj.f_cmd.value = SEARCH03;
			var sParam = makeFormString(formObj, sheetObjects[0], sheetObjects[1], sheetObjects[2]);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");
            HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");
            HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");
            HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");

            sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			
			sheetObj.LoadSearchXml(sXml);
			
			formObj.phasein_vsl_cd.value = "";
			formObj.phasein_voy_no.value = "";
			formObj.phasein_start_date.value = "";
			
			break;
			
		case SEARCH05:	// addcall
			formObj.f_cmd.value = SEARCH05;
			sheetObj.Redraw = false;
			
			var sParam = makeFormString(formObj, null, sheetObjects[1], sheetObjects[2]);
			
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");
            HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");
            HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");
            HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");
            HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");

            sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			break;
		
		case SEARCH06: // add call cancel

			formObj.f_cmd.value = SEARCH06;
			
			var sParam = makeFormString(formObj, null, sheetObjects[1], sheetObjects[2]);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010_1GS.do" , sParam);
            HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");          
            HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");          
            HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");          
            HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");          
            HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
            HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");

            sheetObj.Reset();
            ComConfigSheet (sheetObj);
            initSheet(sheetObj,2);
            ComEndConfigSheet(sheetObj);
			
			sheetObj.LoadSearchXml(sXml);
			break;
			
			
		case SEARCH07:	// search vessel code
			formObj.f_cmd.value = COMMAND16;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
			var vslInfo = new Object();
			vslInfo.vslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
			return vslInfo;
			break;
			
		case SEARCH08:	// search P/F Type Code
			formObj.slan_stnd_flg.value = "N";
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0054GS.do" , sParam);
			
			if(ComGetEtcData(sXml, "pf_svc_tp_cd")){
				
				formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
				
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
				sheetObjects[2].LoadSearchXml(sXml);
				initPage();
				return false;
			}
			
			break;
			
		case SEARCH09: // P/F 타입 변경시
			
			formObj.f_cmd.value = SEARCH;
			if(formObj.stnd_pf_svc_tp_cd.value==formObj.pf_svc_tp_cd.value){
				formObj.slan_stnd_flg.value = 'Y';
			}else{
				formObj.slan_stnd_flg.value = 'N';
			}

			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010GS.do" , sParam);
			
			if(VskGetErrorXml(sXml)){
				initPage();
				sheetObj.LoadSearchXml(sXml);
				formObj.tmp_vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
			}else{
				formObj.vsl_count.value = ComGetEtcData(sXml, "vsl_count");
				formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
				formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
				formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
			
				formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
				//if(formObj.vsl_count.value.parseInt() < formObj.vsl_cnt.value.parseInt()){
					formObj.vsl_cnt.value = formObj.vsl_count.value;
				//}
				
				sheetObjects[2].LoadSearchXml(sXml);
				manageStartInfo();
			}
		break;
		
		case SEARCH10: // PF가 delt yard를 포함하고 있는지 check
		
			formObj.f_cmd.value = SEARCH10;
			
			var sParam = makeFormString(formObj, sheetObjects[0], null, sheetObjects[2]);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0010GS.do" , sParam);
			
			var deltYd = ComGetEtcData(sXml, "yd_list");
			if(deltYd != undefined){
				if(deltYd != ""){
					ComShowMessage("Deleted Yard ["+ deltYd +"] Exist. Please Use Other PF.");
				}else{
					doActionIBSheet(sheetObjects[1],formObj,SEARCH02);
				}
			}
			
		break;
			
    }
}

/**
 * 시작 분기별 마지막 날짜 반환
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
 * 종료 분기별 마지막 날짜 반환
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
 * VSL No. 에 따른 컬럼 히든처리를 위한 함수
 */
function setColHidden(sheetObj,viewCols){
	
	if(!viewCols){
		viewCols = 0;
	}
	
	sheetObj.Redraw = false;
	
	// 전체 false
	for(var i=1; i<=sheetObj.LastCol; i++){
		sheetObj.ColHidden(i) = true;
	}
	
	// 필요한부분만 true
	for(var i=1; i<=viewCols; i++){
		sheetObj.ColHidden(i) = false;
	}
	
	// 시트 넓이 조정
	sheetObj.ViewRows = sheet1DataRows;
	var width = 95*(viewCols)+95;
	if(viewCols<=9){
		sheetObj.SheetWidth = width;
//		sheetObj.ViewRows = sheet1DataRows;
		sheetObj.style.height = sheet1ViewDataRows * 20 + 2;
		sheetObjects[1].style.height = 322;
	}else if(viewCols==0){
		sheetObj.SheetWidth = 90;
//		sheetObj.ViewRows = sheet1DataRows;
		sheetObj.style.height = sheet1ViewDataRows * 20 + 2;
		sheetObjects[1].style.height = 322;
	}else{
		sheetObj.SheetWidth = 95*(9)+95;
//		sheetObj.ViewRows = sheet1DataRows + 1;
		sheetObj.style.height = ( sheet1ViewDataRows + 1 )* 20 + 2;
		sheetObjects[1].style.height = 302;
		//sheetObjects[1].style.height = parseInt(sheetObjects[1].style.height) - 20; 
	}
	
	sheetObj.Redraw = true;
	
}
    
function sheet1_OnChange(sheetObj , Row, Col, Value){
	
   	if(!Value || Value==""){
		return false;
	}
	var formObj = document.form;
	var datarow = Row - sheetObj.HeaderRows; // row는 DataRow 상의 위치
	
	if(datarow==sheet1StartDateDataRow){

		adjustStartDate(sheetObj, Col, Value);
		
	}else if(datarow==sheet1VslCdDataRow){	// Vessel Code 수정한 경우
		formObj.vsl_cd.value = Value;
		
		// 이미 입력한 vessel code인지 확인
		for(var i=0; i<Col; i++){
			if(Value == sheetObj.CellValue(Row, i)){
				ComShowCodeMessage('VSK00085', Value);
				sheetObj.SelectCell(Row, Col);
        		sheetObj.CellValue2(Row, Col) = "";
        		return false;
			}
		}
		
		var vslInfo = doActionIBSheet(sheetObj, formObj, SEARCH07);
		if(vslInfo.vslEngNm && vslInfo.vslEngNm!=""){
			sheetObj.ToolTipText(Row, Col) = vslInfo.vslEngNm;
		}else{
			ComShowCodeMessage('VSK00021', Value);
			sheetObj.SelectCell(Row, Col);
			sheetObj.CellValue2(Row, Col) = "";
		}
		
	}else if(datarow==sheet1VoyNoDataRow){ // Voyage No 수정한 경우
		sheetObj.CellValue2(Row, Col) = Value.lpad(4, "0");
		if(sheetObj.CellValue(Row, Col)=="0000"){
			ComShowCodeMessage("VSK00101");
			sheetObj.SelectCell(Row, Col);
			sheetObj.CellValue2(Row, Col) = "";
			return false;
		}
		//Direction + seq 생성.. 2014.08.05
		var vslno = Number(formObj.vsl_cnt.value ) + 1;
		if( formObj.voy_no_type.value == 3 && Col == 1 )
		{
			
			var vno = Number( sheetObj.CellValue(Row, Col) );
			
			for( var i=2 ; i< vslno ; i++ ){
				
				sheetObj.CellValue2(3, i) = vno+(2*(i-1));
			}
			
			
		}
		
	}else if(datarow==sheet1PfTypeDataRow){ // P/F Skd Type
		formObj.pf_svc_tp_cd.value = Value;
		if(doActionIBSheet(sheetObj, formObj, SEARCH08)){
			doActionIBSheet(sheetObj, formObj, SEARCH09);
			if(formObj.vsl_slan_cd.value!=""){
				for(var i=1; i<sheetObj.LastCol; i++){
					sheetObj.CellValue2(Row, i) = Value;	
				}
			}
			HeadCol1 = "";
			HeadCol2 = "";
			HeadCol3 = "";
			HeadCol4 = "";
			HeadCol5 = "";
			HeadCol6 = "";
			initSheet(sheetObjects[1], 2);
			formObj.vsl_slan_cd.focus();
		}else{
			formObj.vsl_slan_cd.focus();
		}
	}
	
}

function sheet2_OnDblClick(sheetObj , Row, Col)
{
	
	if(Col >= dataStartCol && Col <= sheetObj.LastCol-bufferColCount){
		
		var oldval = sheetObj.CellValue(Row, Col);
    	var port = sheetObj.CellValue(sheet2VpsPortCdHeaderRow, Col);
    	var est = Col%2==0 ? "ETB" : "ETD";
    	
    	if(oldval=='' || oldval==skipvalue){
    		return false;
    	}
    	
		if(oldval.substring(0,3) != "out"){
			var sUrl = "/hanjin/VOP_VSK_0210.do?port=" + port + "&est=" + est + "&srcdate=" + oldval;
			var rVal = ComOpenPopupWithTarget(sUrl, 428, 402, "", "0,0", true);
			if(rVal){
				sheetObj.CellValue(Row, Col) = rVal; // VPS_ET
				sheetObj.CellValue(Row+sheet2InitDateRowPos, Col) = rVal; // INIT_ET
			}
		}
	}else if(Col==sheetObj.LastCol-bufferColCount+1){
		if(Row<4) return;
		// Remark 입력을 위한 창을 띄운다.
		var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + sheetObj.CellValue(Row, Col);
		var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		if(rVal || rVal==""){
			sheetObj.CellValue(Row, Col) = rVal;
		}
	}
}

function sheet2_SetColor(sheetObj){
	
	var Value = "";
	
	for(var Row = sheetObj.HeaderRows; Row < sheetObj.HeaderRows + sheetObj.RowCount; Row++){
		for(var Col = 0; Col <sheetObj.LastCol; Col++){
			
			Value = sheetObj.CellValue(Row, Col);
			
			if(Value == " SKIP"){
				
				sheetObj.CellBackColor(Row, Col) = sheetObj.RgbColor(192, 192, 192);
				continue;
            	
			}
			
			if(ComChkLen(Value, 2)==0 || ComChkLen(Value, 2)==2){
				
				if("I:" == Value.substring(0, 2)){
					// phase in 앞부분을 회색칠해줌
                	for(var i=sheetObj.SaveNameCol("VVD3")+1; i<Col-1; i++){
                		sheetObj.CellBackColor(Row-sheet2StatusRowPos, i) = sheetObj.RgbColor(200, 200, 200);
                	}		
				}
				
				//	TODO
				//if("O:" == Value.substring(0, 2)){
				//
				//	var vslCd = sheetObj.CellValue(Row, "VVD1");
				//
				//	// phase out 부분을 회색으로 표시해줌.
				//	for(var i = Col + 2; i<sheetObj.SaveNameCol("skd_rmk"); i++){
				//		sheetObj.CellBackColor(Row-3, i) = sheetObj.RgbColor(200, 200, 200);
				//	}
				//
				//	for(var i = Row + 1 ; i <= sheetObj.LastRow ; i++){
				//		if(sheetObj.CellValue(i, "VVD1") == vslCd ){
				//			sheetObj.RowHidden(i) = true;
				//		}
				//	}
				//}
				
			}
		}
	}
}
        
//function sheet1_OnSearchEnd(sheetObj,ErrMsg)
//{
//    var formObj = document.form;
//    var brth_itval_dys = formObj.brth_itval_dys.value;
//    var nowInfo = ComGetNowInfo();
//    var headerRow = sheetObj.HeaderRows;
//    
//    for(var i=1; i <= formObj.vsl_cnt.value; i++){
//    	
//    	alert((i-1)*brth_itval_dys);
//    	alert(ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys));
//    	
//   		sheetObj.CellValue2(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys);
//   		sheetObj.CellValue2(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = formObj.pf_svc_tp_cd.value;
//   		
//   		sheetObj.CellAlign(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = daCenter;
//   		sheetObj.CellAlign(headerRow + sheet1VslCdDataRow, "Vsl_" + i) = daCenter;
//   		sheetObj.CellAlign(headerRow + sheet1VoyNoDataRow, "Vsl_" + i) = daCenter;
//   		sheetObj.CellAlign(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = daCenter;
//   		
//    }
//    
//    if(ErrMsg != ""){
//    	formObj.vsl_slan_cd.value = "";
//    	formObj.tmp_vsl_slan_cd.value = "";
//    	formObj.vsl_slan_cd.select();
//    }
//    
//    adjustEndDate();
//}

function sheet3_OnSearchEnd(sheetObj,ErrMsg)
{
	var formObj = document.form;
	var mnvr_in_hrs;
	var mnvr_in_time;
	var etb_tm_hrmnt;
	var eta_tm_hrmnt;
	
	var etaDate = new Date(); 
	var etbDate = new Date();
	
	var dyNoGap;
	
    if(ErrMsg != ""){
    	return;
    }
    
    if(sheetObj.RowCount > 0){
    	
    	formObj.skdDirCd1.value = sheetObj.CellValue(1, "skd_dir_cd");
    	formObj.skdDirCd2.value = sheetObj.CellValue(sheetObj.RowCount, "skd_dir_cd");
    	
		// 첫번째 포트의 mnvr_in_hrs가 0인 경우가 있으므로, 마지막 포트의 mnvr_in_hrs를 이용한다. 
		sheetObj.CellValue2(sheetObj.HeaderRows, "mnvr_in_hrs") = sheetObj.CellValue(sheetObj.LastRow, "mnvr_in_hrs");
    	
    	for(var i=0; i<sheetObj.RowCount; i++){
    		mnvr_in_hrs = sheetObj.CellValue(i+1, "mnvr_in_hrs");
    		etb_tm_hrmnt = sheetObj.CellValue(i+1, "etb_tm_hrmnt");
    		
    		etbDate.setHours(etb_tm_hrmnt.substring(0, 2), etb_tm_hrmnt.substring(2, 4), 0, 0);
    		
    		// mnvr_in_hrs 를 milliseconds로 환산
    		mnvr_in_time = mnvr_in_hrs * 10 * 60 * 60 * 100;
    		
    		// ETA 측정
    		etaDate.setTime(etbDate.getTime() - mnvr_in_time);
    		
    		// ETA, ETB간 일차 계산
    		dyNoGap = etbDate.getDay() - etaDate.getDay();
    		if(dyNoGap < 0){
    			dyNoGap = dyNoGap + 7;
    		}
    		
    		sheetObj.CellValue(i+1, "eta_tm_hrmnt") = ComLpad(etaDate.getHours(), 2, "0") + ComLpad(etaDate.getMinutes(), 2, "0");
    		
    		// 일차가 0이면 eta_dy_cd, eta_dy_no 를 ETB와 동일하게 함
    		// 다르면 차이만큼 계산
    		if(dyNoGap == 0){
    			sheetObj.CellValue(i+1, "eta_dy_cd") = sheetObj.CellValue(i+1, "etb_dy_cd");
    			sheetObj.CellValue(i+1, "eta_dy_no") = sheetObj.CellValue(i+1, "etb_dy_no");
    		}else{
    			sheetObj.CellValue(i+1, "eta_dy_cd") = beforeDay(sheetObj.CellValue(i+1, "etb_dy_cd"), dyNoGap);
    			sheetObj.CellValue(i+1, "eta_dy_no") = sheetObj.CellValue(i+1, "etb_dy_no") - dyNoGap;
    		}
    		
    	}
    	
    	if(!validatePF(sheetObj)){
    		pfSkdValidation = false;
    		initPage();
    	}else{
    		pfSkdValidation = true;
    	}
    }
}

function validatePF(sheetObj){
	
	var preDyNo;
	var preTmHrmnt;
	var curDyNo;
	var curTmHrmnt;
	var check = true;
	
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.RowCount; Row++){
		
		// mnvr_in_hrs가 0인 것을 체크
		if("0"==sheetObj.CellValue(Row, "mnvr_in_hrs")){
			check = false;
			ComShowCodeMessage("VSK00096", "Maneuvering In Hours");
			break;
		}
		
		if(Row!=sheetObj.HeaderRows){
			if(!compare(
					sheetObj.CellValue(Row-1, "etd_dy_no"),
					sheetObj.CellValue(Row-1, "etd_tm_hrmnt"),
					sheetObj.CellValue(Row, "eta_dy_no"),
					sheetObj.CellValue(Row, "eta_tm_hrmnt"),
					true)){
				check = false;
//				alert(sheetObj.CellValue(Row, "port_cd"));
				ComShowCodeMessage("VSK00096", "ETD, ETA");
				break;
			}
		}
		
		if(!compare(
				sheetObj.CellValue(Row, "eta_dy_no"),
				sheetObj.CellValue(Row, "eta_tm_hrmnt"),
				sheetObj.CellValue(Row, "etb_dy_no"),
				sheetObj.CellValue(Row, "etb_tm_hrmnt"))){
			check = false;
			ComShowCodeMessage("VSK00096", "ETA, ETB");
			break;
		}
		
		if(!compare(
				sheetObj.CellValue(Row, "etb_dy_no"),
				sheetObj.CellValue(Row, "etb_tm_hrmnt"),
				sheetObj.CellValue(Row, "etd_dy_no"),
				sheetObj.CellValue(Row, "etd_tm_hrmnt"))){
			check = false;
			ComShowCodeMessage("VSK00096", "ETB, ETD");
			break;
		}
	}
	return check;
}

/*
 * 현재일자정보(curDyNo, curTmHrmnt)가 이전일자정보(preDyNo, preTmHrmnt)보다 후행 일자인지 확인한다.
 */
function compare(preDyNo, preTmHrmnt, curDyNo, curTmHrmnt, boundEnable){
	
	// preDyNo, preTmHrmnt, curDyNo, curTmHrmnt 가 모두 빈 문자열이 아닌지 확인한다.
	if(!(ComIsNumber(preDyNo, "-") && ComIsNumber(preTmHrmnt, "-") && ComIsNumber(curDyNo, "-") && ComIsNumber(curTmHrmnt, "-"))){
		return false;
	}
	
	preDyNo = ComParseInt(preDyNo);
	preTmHrmnt = ComParseInt(preTmHrmnt);
	curDyNo = ComParseInt(curDyNo);
	curTmHrmnt = ComParseInt(curTmHrmnt);
	
	if(preDyNo > curDyNo){
		return false;
	}
	if(preDyNo == curDyNo){
		//boundEnable 이 true 이면 경계값(preTmHrmnt == curTmHrmnt)은 허용한다.
		if(boundEnable && (preTmHrmnt > curTmHrmnt)){
			return false;
		}else if(!boundEnable && !(preTmHrmnt < curTmHrmnt)){
			return false;
		}
	}
	return true;
}

/*
 * 지정된 요일에서 지정된 날만큼의 이전 요일을 구하는 함수
 */
function beforeDay(day, dyNoGap)
{
	var arDays = new Array("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
	var d;
	switch(day){
		case "SUN":
			d = 0;
			break;
		case "MON":
			d = 1;
			break;
		case "TUE":
			d =2 ;
			break;
		case "WED":
			d = 3;
			break;
		case "THU":
			d = 4;
			break;
		case "FRI":
			d = 5;
			break;
		case "SAT":
			d = 6;
			break;
	}
	
	d = d - dyNoGap;
	if(d<0){
		d = d + 7;
	}
	return arDays[d];

}

function PortPosition(Col)
{
	var port_idx = parseInt((Col - dataStartCol)/2 + 1);
	return port_idx;
}

function VvdPosition(Row)
{
	var vvd_idx = parseInt(Row - dataStartRow);
	return vvd_idx;
}

function startColPos(sheetObj, point)
{
	with(sheetObj){
    	var row = SelectRow;
    	var col = SelectCol;
		var startCol = 0;
    	var colname = ColSaveName(col).substring(0,3);
		if(colname == 'ETB')
			return col+point;
		else if(colname == 'ETD')
			return col-1+point;
		else 	
			return false;
	}
}

function phaseOut(sheetObj, stdCol)
{
	var formObj = document.form;
	with(sheetObj){

		var row = SelectRow;
		var col = SelectCol;
		
		// 선택한 컬럼의 값이 없는 경우, Skip인 경우  PhaseOut 시행하지 않는다.
		if(""==sheetObj.CellValue(row, col) || skipvalue==sheetObj.CellValue(row, col)){
			return false;
		}
		
		col = startColPos(sheetObj, 0);
		
		// phase out 정보 획득후, 다른 기능의 동작을 위해 sheet의 selection 정보 초기화
		sheetObj.SelectCell(row, 1, false);
		
    	if(PortPosition(col)==-1 || "skd_rmk"==sheetObj.ColSaveName(col)){
    		ComShowCodeMessage('VSK00080');
    		return false;
    	}else{
    		ComOpenWait(true);
    		var param = "";
    		param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
    		param += "&vsl_cd=" + CellValue(row, "VVD1");
    		param += "&voy_no=" + CellValue(row, "VVD2");
    		param += "&dir_cd=" + CellValue(0, col);
    		param += "&port_cd=" + CellValue(1, col);
    		param += "&phase_type=O";
    		param += "&clpt_ind_seq=" + CellValue(4, col);
    		param += "&phase_date=" + ComGetNowInfo();
    		param += "&parentUI=0010";
    		var sUrl = "/hanjin/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + "&" + param;
    		var rVal = ComOpenPopupWithTarget(sUrl, 650, 250, "", "0,0", true);
    		if(rVal){
    			//lyj
    			Redraw = false;
    			var vslCd = CellValue(row, "VVD1");
    			
    			for(var i = 0; i < 4 ; i++){
    				if(i == 0){
    					CellValue2(row+sheet2StatusRowPos, col) = "O:" + rVal;

    					CellValue2(row+sheet2StatusRowPos, col+1) = "O:" + rVal;

	    				for(var j = col+2 ; j <= LastCol - bufferColCount ;j++){
	    					if(CellValue(row, j)!=""){
	        					
	    						CellValue2(row+sheet2StatusRowPos, j) = CellValue(row, j);
	    						CellValue2(row,j) = "";//"out_"+CellValue(row+i,j);
	    					}
	    				}
    				}
    			}     
    			for(var i = row + 4 ; i <= LastRow ; i ++){
    				if(CellValue(i, "VVD1") == vslCd ){
    					RowHidden(i) = true;
    					CellValue2(i, "out") = vslCd;
    				}
    			}
    			
    			// phase out 부분을 회색으로 표시해줌.
    			for(var i = col + 2; i<SaveNameCol("skd_rmk"); i++){
    				CellBackColor(row, i) = RgbColor(200, 200, 200);
    			}
    			
            	Redraw = true;
    			
    		}
    	}
	}
	ComOpenWait(false);
}

function phaseOutCancel(sheetObj)
{
	with(sheetObj){
		
		var row = SelectRow;
		var col = SelectCol;
		col = startColPos(sheetObj, 0);
		
		// phase out cancel 정보 획득후, 다른 기능의 동작을 위해 sheet의 selection 정보 초기화
		sheetObj.SelectCell(row, 1, false);
		
    	if(PortPosition(col)==-1 || "skd_rmk"==ColSaveName(col)){
    		ComShowCodeMessage('VSK00080');
    	}else if(CellValue(row+sheet2StatusRowPos, col).indexOf("O:")<0){
    		ComShowCodeMessage('VSK00063');
    	}else{
    		ComOpenWait(true);
        	Redraw = false;
        	
        	var vslCd = CellValue(row, "VVD1");
        	
        	// 1. 선택한 포트가 속해있는 VVD에서 phase out 된 포트를 취소한다.
        	CellValue2(row+sheet2StatusRowPos, col) = "";
        	CellValue2(row+sheet2StatusRowPos, col+1) = "";
        	
        	for(var i = col + 2; i<SaveNameCol("skd_rmk"); i++){
				CellBackColor(row, i) = RgbColor(255, 255, 255);
			}
        	
        	for(var i = col+2 ; i <= LastCol - bufferColCount ; i++){
        		CellValue2(row, i) = CellValue(row+sheet2StatusRowPos, i);
				CellValue2(row+sheet2StatusRowPos, i) = "";
			}
        	
        	// 2. 이하 VVD에서 해당 Vessel에 대하 phase out되어 있는 VVD를 취소한다.
			for(var i = row+dataSetCnt ; i <= LastRow ; i=i+dataSetCnt){
				
				if(vslCd == CellValue(i, "out")){
					RowHidden(i) = false;
					CellValue(i, "out") = "";
				}
			}
        	Redraw = true;
        	ComOpenWait(false);
    	}
	}
}
        
/*
 * CHM-201005617-01 Phase in Pop-Up 시 Direction Code와 Port Code가 미지정된 상태이면 유저에게 선택 가능한 Direction Code/Port Code Combo를 제공한다.
 */
function phaseIn(sheetObj)
{
	var formObj = document.form;
	with(sheetObj){
		
		if(!formObj.vsl_slan_cd.value){
			ComShowCodeMessage('VSK00067');
			formObj.vsl_slan_cd.focus();
    		return false;
		}

		var row = SelectRow;
		var col = SelectCol;
		
		col = startColPos(sheetObj, 0);
		
		// phase in 정보 획득후, 다른 기능의 동작을 위해 sheet의 selection 정보 초기화
		sheetObj.SelectCell(row, 1, false);
		
		// Lane 정보는 로딩 && simulation 하지 않은 상태에서 P/IN 기능을 동작시킨다.
		if(sheetObj.RowCount==0 && sheetObjects[2].RowCount!=0){
			simplePIN = true;
		}else{
			simplePIN = false;
		}
		
    	if(!simplePIN && (PortPosition(col)==-1 || "skd_rmk"==sheetObj.ColSaveName(col))){
    		ComShowCodeMessage('VSK00059');
    		return false;
    	}else{
    		ComOpenWait(true);
    		var param = "";
    		
    		if(simplePIN){
    			formObj.phasein_col.value  = 1;
    			formObj.phasein_row.value = 0;
    			
    			var firstDir = sheetObjects[2].CellValue(sheetObjects[2].HeaderRows, "skd_dir_cd");
    			var secondDir = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "skd_dir_cd");
    			var skdDirCd;
    			
    			var firstPortCds = "";
    			var secondPortCds = "";
    			
    			if(firstDir==secondDir){
    				skdDirCd = firstDir;
    			}else{
    				skdDirCd = firstDir + "|" + secondDir;
    			}
    			
    			for(var Row=sheetObjects[2].HeaderRows; Row<=sheetObjects[2].LastRow; Row++){
    				if(firstDir==sheetObjects[2].CellValue(Row, "skd_dir_cd")){
    					firstPortCds = firstPortCds ? firstPortCds + "|" : "";
    					firstPortCds = firstPortCds + sheetObjects[2].CellValue(Row, "port_cd") + " " + sheetObjects[2].CellValue(Row, "yd_cd").substring(5, 7);
    				}else if(secondDir==sheetObjects[2].CellValue(Row, "skd_dir_cd")){
    					secondPortCds = secondPortCds ? secondPortCds + "|" : "";
    					secondPortCds = secondPortCds + sheetObjects[2].CellValue(Row, "port_cd") + " " + sheetObjects[2].CellValue(Row, "yd_cd").substring(5, 7);
    				}
    			}
    			
    			param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	    		param += "&vsl_cd="; // + CellValue(row, "VVD1");
	    		param += "&voy_no="; // + CellValue(row, "VVD2");
	    		param += "&dir_cd=" + skdDirCd
	    		//param += "&port_cd=" + sheetObjects[2].CellValue(1, "port_cd");
	    		param += "&first_port_cd=" + firstPortCds;
	    		param += "&second_port_cd=" + secondPortCds;
	    		param += "&phase_type=I";
	    		//param += "&clpt_ind_seq=" + CellValue(4, col);
	    		param += "&src_pf_date=" + ComLpad(ComGetNowInfo("mm"), 2, "0") + "/" +  ComLpad(ComGetNowInfo("dd"), 2, "0") + ComGetNowInfo("yy") + "0000"; 
	    		param += "&parentUI=0010";
    		}else{
    			formObj.phasein_col.value  = PortPosition(col);
        		formObj.phasein_row.value = VvdPosition(row) + 1;
        		
	    		param += "vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	    		param += "&vsl_cd="; // + CellValue(row, "VVD1");
	    		param += "&voy_no="; // + CellValue(row, "VVD2");
	    		param += "&dir_cd=" + CellValue(0, col);
	    		param += "&port_cd=" + CellValue(1, col);
	    		param += "&phase_type=I";
	    		//param += "&clpt_ind_seq=" + CellValue(4, col);
	    		param += "&src_pf_date=" + CellValue(row+1, col);
	    		param += "&parentUI=0010";
    		}
			
    		var sUrl = "/hanjin/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + "&" + param;
    		var rVal = ComOpenPopupWithTarget(sUrl, 650, 250, "", "0,0", true);
    		
    		if(rVal){
    			formObj.phasein_vsl_cd.value = rVal.vvd.substring(0, 4);
    			formObj.phasein_voy_no.value = rVal.vvd.substring(4, 8);
    			formObj.phasein_start_date.value = rVal.date;
    			
    			if(simplePIN){
    				formObj.phasein_col.value  = rVal.phasein_col;
    				col = dataStartCol + ((rVal.phasein_col-1) * 2);
    			}
    			
    			doActionIBSheet(sheetObj,formObj,SEARCH03);
    		
    			if(!simplePIN){
    				// phase in 시작한 포트 표시
	            	CellValue2(row+sheet2StatusRowPos+dataSetCnt, col) = "I:" + rVal.rsn_cd + ":"+ rVal.port_skp_tp_cd; 
	            	CellValue2(row+sheet2StatusRowPos+dataSetCnt, col+1) = "I:" + rVal.rsn_cd;
	            	
	            	// phase in 앞부분을 회색칠해줌
	            	for(var i=SaveNameCol("VVD3")+1; i<col; i++){
	            		CellBackColor(row+dataSetCnt, i) = RgbColor(200, 200, 200);
	            	}
    			}else{
    				// phase in 시작한 포트 표시
//                	CellValue2(dataStartRow+sheet2StatusRowPos, dataStartCol) = "I:" + rVal.rsn_cd; 
//                	CellValue2(dataStartRow+sheet2StatusRowPos, dataStartCol+1) = "I:" + rVal.rsn_cd;
    				CellValue2(dataStartRow+sheet2StatusRowPos, col) = "I:" + rVal.rsn_cd + ":"+ rVal.port_skp_tp_cd; 
                	CellValue2(dataStartRow+sheet2StatusRowPos, col+1) = "I:" + rVal.rsn_cd;
                	
	            	// phase in 앞부분을 회색칠해줌
	            	for(var i=SaveNameCol("VVD3")+1; i<col; i++){
	            		CellBackColor(row, i) = RgbColor(200, 200, 200);
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
	var formObj = document.form;
	with(sheetObj){
		
		var row = SelectRow;
		var col = SelectCol;
		
		col = startColPos(sheetObj, 0);
		
		// phase in 정보 획득후, 다른 기능의 동작을 위해 sheet의 selection 정보 초기화
		sheetObj.SelectCell(row, 1, false);
		
    	if(PortPosition(col)==-1 || "skd_rmk"==ColSaveName(col)){
    		ComShowCodeMessage('VSK00059');
    	}else if(CellValue(row+sheet2StatusRowPos, col).indexOf("I:")<0){
    		ComShowCodeMessage('VSK00079');
    	}else{
    		ComOpenWait(true);
        	Redraw = false;
		
    		var targetVslCd = CellValue(row, "VVD1");
    		var i = row;
    		
    		while(i<=LastRow){
    			if(targetVslCd == CellValue(i, "VVD1")){
    				RowDelete(i, false);
    			}else{
    				i++;
    			}
    		}
    		
    		Redraw = true;
    		ComOpenWait(false);
    	}
	}
}
        
 function skipCall(sheetObj)
{
	with(sheetObj){
    	var row = SelectRow;
    	var col = SelectCol;
    	var value = CellValue(row,col);
    	var etbCol = startColPos(sheetObj,0);
    	if(value == "" || value.substring(0,3) == "out" || !etbCol || value == skipvalue){
    		//sheetObj.SelectCell(row,1);
    		return;
    	}
    	
    	// Add Call된 Port는 Skip 할수없다.
    	if("A"==CellValue(row+sheet2StatusRowPos, etbCol)){
    		ComShowCodeMessage("VSK00086");
    		return true;
    	}
    	
    	// P/F상 마지막 Port(Turning 값이 F) 또는 첫번째 Port에서 SKIP 한 경우,
    	// 연결되는 다음/이전 항차의 첫번째/마지막 Calling Port 스케줄이 동일하므로 마친가지로 SKIP 해야함.
    	var linkSkd = findNextLinkSkd(sheetObj, row, etbCol);
    	if(!linkSkd){
    		linkSkd = findPrevLinkSkd(sheetObj, row, etbCol);
    	}
    	
    	if(linkSkd){
    		CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol) = CellValue(linkSkd.tgtRow, linkSkd.tgtCol);
        	CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1) = CellValue(linkSkd.tgtRow, linkSkd.tgtCol+1);
        	
        	CellValue2(linkSkd.tgtRow, linkSkd.tgtCol) = skipvalue;
        	CellValue2(linkSkd.tgtRow, linkSkd.tgtCol+1) = skipvalue;
        	
        	CellBackColor(linkSkd.tgtRow, linkSkd.tgtCol) = RgbColor(192, 192, 192);
        	CellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1) = RgbColor(192, 192, 192);
        	
        	// 스킵된 라인 표시
        	CellValue2(linkSkd.tgtRow, "skip") = 1;
    	}
    	
    	// 지정한 위치 SKIP 처리
    	CellValue2(row+sheet2StatusRowPos, etbCol) = CellValue(row, etbCol);
    	CellValue2(row+sheet2StatusRowPos, etbCol+1) = CellValue(row, etbCol+1);
    	
    	CellValue2(row, etbCol) = skipvalue;
    	CellValue2(row, etbCol+1) = skipvalue;
    	
    	CellBackColor(row, etbCol) = RgbColor(192, 192, 192);
    	CellBackColor(row, etbCol+1) = RgbColor(192, 192, 192);
    	
    	// 스킵된 라인 표시
    	CellValue2(row, "skip") = 1;
   	}
}

function skipCallCancel(sheetObj)
{
	with(sheetObj){
    	var row = sheetObj.SelectRow;
    	var col = sheetObj.SelectCol;
    	
    	var value = CellValue(sheetObj.SelectRow, sheetObj.SelectCol);
    	if(value==skipvalue){
    		
    		var etbCol = startColPos(sheetObj,0);

        	// P/F상 마지막 Port(Turning 값이 F) 또는 첫번째 Port에서 SKIP Cancel 한 경우,
        	// 연결되는 다음/이전 항차의 첫번째/마지막 Calling Port 스케줄이 동일하므로 마친가지로 SKIP Cancel 해야함.
    		var linkSkd = findPrevLinkSkd(sheetObj, row, etbCol);
    		if(!linkSkd){
    			linkSkd = findNextLinkSkd(sheetObj, row, etbCol);
    		}
    		
        	if(linkSkd){
        		CellValue2(linkSkd.tgtRow, linkSkd.tgtCol) = CellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol);
        		CellValue2(linkSkd.tgtRow, linkSkd.tgtCol+1) = CellValue(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1);
            	
        		CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol) = "";
        		CellValue2(linkSkd.tgtRow+sheet2StatusRowPos, linkSkd.tgtCol+1) = "";
            	
            	CellBackColor(linkSkd.tgtRow, linkSkd.tgtCol) = RgbColor(255, 255, 255);
            	CellBackColor(linkSkd.tgtRow, linkSkd.tgtCol+1) = RgbColor(255, 255, 255);
            	
            	// 스킵된 라인 표시
            	CellValue2(linkSkd.tgtRow, "skip") = 1;
        	}
    		
    		// 해당 포트의 Skip Cancel
    		CellValue2(row, etbCol) = CellValue(row+sheet2StatusRowPos, etbCol);
			CellValue2(row+sheet2StatusRowPos, etbCol) = "";
			CellBackColor(row, etbCol) = RgbColor(255, 255, 255);
			
			CellValue2(row, etbCol+1) = CellValue(row+sheet2StatusRowPos, etbCol+1);
			CellValue2(row+sheet2StatusRowPos, etbCol+1) = "";
			CellBackColor(row, etbCol+1) = RgbColor(255, 255, 255);
			
    	}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm('blur', 'obj_blur',  formObj); //- 포커스 나갈때
    axon_event.addListenerForm('focus', 'obj_focus',    formObj); //- 포커스 들어갈때
    axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
    axon_event.addListenerForm('change', 'obj_change', formObj);	//- 변경데이타 처리
    axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);	//- 변경데이타 처리
    axon_event.addListener ('keypress', 'num_keypress' , 'form');	//- 숫자 입력하기
    axon_event.addListener('keypress', 'eng_keypress', 'form');	//- 영문자 입력하기
    axon_event.addListener ('keypress', 'enter_keypress', 'form');	//- Enter 키 처리
    axon_event.addListener('keyup', "VskKeyFocus", 'form');		//- 자동포커스 처리
}

function eng_keypress(){
	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
		case "vsl_slan_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter('btn_Simulation');
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_blur(){
	
    var formObj = document.form;
    switch(event.srcElement.name){
        case "start_date":
        case "end_date":
        	ComChkObjValid(event.srcElement);
        	break;
        
        default:
            //Validation 전체 체크(길이,format,최대,최소 등등)
    }
    return true;
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 **/
function obj_focus(){
	
    //마스크구분자 없애기
	switch(event.srcElement.name){
		case "start_date":
		case "end_date":
			ComClearSeparator(event.srcElement);
    	    bakObj = event.srcElement.value;
			break;
		case "vsl_cnt":
			bakObj = event.srcElement.value;
		default:
	}
	
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}

}

function obj_change(){
	
	var formObj = document.form;
	var sheetObj = null;
    switch(event.srcElement.name){
    		
    	case "selStartQuarter":
        	formObj.start_date.value = ComGetMaskedValue(startQuarterDay(parseInt(formObj.start_year.value),formObj.selStartQuarter.value), "ymd");
        	formObj.start_date.fireEvent("onblur");
            break;

        case "selEndQuarter":
        	formObj.end_date.value = ComGetMaskedValue(endQuarterDay(parseInt(formObj.end_year.value),formObj.selEndQuarter.value), "ymd");
        	formObj.end_date.fireEvent("onblur");
            break;
            
        case "vsl_cnt":
        	if(formObj.vsl_slan_cd.value==""){
        		ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.vsl_cnt.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
        	
        	formObj.vsl_cnt.value = ComLtrim(formObj.vsl_cnt.value, "0");
        	var vsl_cnt = formObj.vsl_cnt.value;
        	var pf_vsl_cnt = formObj.vsl_count.value;
        	
        	if(vsl_cnt.parseInt() > pf_vsl_cnt.parseInt() ){
        		ComShowCodeMessage("VSK00077", pf_vsl_cnt);
        		formObj.vsl_cnt.value=bakObj;
        		formObj.vsl_cnt.focus();
        		return false;
        	}
        	
    	    sheetObj = sheetObjects[0];
    	    
    	    // 변경전 Vessel Code 리스트를 백업
    	    // TODO
    	    sheetObj.RemoveAll();

    	    var nowInfo = ComGetNowInfo();
            var brth_itval_dys = formObj.brth_itval_dys.value;
            
            setColHidden(sheetObj, vsl_cnt);
            
            var headerRow = sheetObj.HeaderRows;
            
            for(var i=1; i <= vsl_cnt; i++){
           		sheetObj.CellValue2(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys);
           		sheetObj.CellValue2(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = formObj.pf_svc_tp_cd.value;
           		
           		sheetObj.CellAlign(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = daCenter;
           		sheetObj.CellAlign(headerRow + sheet1VslCdDataRow, "Vsl_" + i) = daCenter;
           		sheetObj.CellAlign(headerRow + sheet1VoyNoDataRow, "Vsl_" + i) = daCenter;
           		sheetObj.CellAlign(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = daCenter;
           		
            }
            
            sheetObj = sheetObjects[1];
			sheetObj.RemoveAll();
			
			if(sheetObj.LastCol > 6){
				for(var i=dataStartCol; i<=sheetObj.LastCol-bufferColCount; i++){
					sheetObj.ColHidden(i) = true;
				}
			}
			
			adjustEndDate();
			
        	break;
        	
    }

}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력 처리한다. <br>
 **/
function num_keypress(){
	switch(event.srcElement.name){
		case "end_date":
		case "vsl_cnt":
			ComKeyOnlyNumber(event.srcElement);
			break;
	}
}

function obj_deactivate(){
	
	var formObj = document.form;
	var obj = event.srcElement;
	var sheetObj = null;
	
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			
			if(obj.value=="" || ComChkLen(obj.value, 3)!=2){
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj = sheetObjects[1];
				formObj.pf_svc_tp_cd.value='';
				sheetObj.RemoveAll();
				
				if(sheetObj.LastCol > 6){
					for(var i=4; i<=sheetObj.LastCol-3; i++){
						sheetObj.ColHidden(i) = true;
					}
				}
				formObj.slan_stnd_flg.value = "Y";
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
		
		case "end_date":
			// end_date를 변경한 경우, Vessel 정보의 Start Date보다 이전 날짜이면 오류이다.
			sheetObj = sheetObjects[0];

			var vslStartDate = sheetObj.CellValue(1, formObj.vsl_cnt.value);
			if(vslStartDate){
				
				if(obj.value < vslStartDate){
					ComShowCodeMessage("VSK00013");
					obj.value = ComGetMaskedValue(bakObj, "ymd");
					return false;
				}
			}
		break;

	}
	
}
    
function sheet1_OnDblClick(sheetObj, Row, Col){
	var formObj = document.form;
	var datarow = Row - sheetObj.HeaderRows;
	if(datarow == sheet1PfTypeDataRow){	// PF Skd Type Code 수정 
//		alert("ondblclick");
		openPfTypePopup(sheetObj, Row);
	}else if(datarow==sheet1StartDateDataRow){
		sheetObj.SelectCell(Row, Col);
	}
}

function makeFormString(formObj, sheetObj1, sheetObj2, sheetObj3){
	
	var sParam = FormQueryString(formObj) + "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
	var sParamSheet1 = "";
	var sParamSheet2 = "";
	var sParamSheet3 = "";
	
	if(sheetObj1!=null){
		sParamSheet1 = ComGetSaveString(sheetObj1);
	}
	
	if(sheetObj2!=null){
		sParamSheet2 = ComGetSaveString(sheetObj2);
	}
	
	if(sheetObj3!=null){
		sParamSheet3 = ComGetSaveString(sheetObj3);
	}
	
	if(sParamSheet1 != ""){
		sParam = sParam + "&" + sParamSheet1;
	}
	
	if(sParamSheet2 != ""){
		sParam = sParam + "&" + sParamSheet2;
	}
	
	if(sParamSheet3 != ""){
		sParam = sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
	}
	
	return sParam;
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	
	var formObj = document.form;
	var datarow = Row - sheetObj.HeaderRows;
	
	if(datarow==sheet1StartDateDataRow){
	    var cal = new ComCalendarGrid("myCal");
	    cal.select2(formObj.start_date, sheetObj, Row, Col, 'yyyy-MM-dd');
	}else if(datarow==sheet1PfTypeDataRow){
//		alert("onpopupclick");
		openPfTypePopup(sheetObj, Row);
	}
}

function openPfTypePopup(sheetObj, Row){
	var formObj = document.form;
	var sUrl = "/hanjin/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	var rValue = ComOpenPopupWithTarget(sUrl, 306, 407, "sheet1_pf_svc_tp_cd:pf_svc_tp_cd", "0,0", true);
	
	if(rValue){
		if(formObj.pf_svc_tp_cd.value!=""){
			for(var i=1; i<sheetObj.LastCol; i++){
				sheetObj.CellValue2(Row, i) = formObj.pf_svc_tp_cd.value; 
			}
			// 바뀐 P/F type 으로 P/F 다시 조회해야함
			doActionIBSheet(sheetObj, formObj, SEARCH09);
		}
		HeadCol1 = "";
		HeadCol2 = "";
		HeadCol3 = "";
		HeadCol4 = "";
		HeadCol5 = "";
		HeadCol6 = "";
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
	
	var check = true;
	var headerRows = sheetObjects[0].HeaderRows;
	
	if(!simplePIN){
		for(var i=1; i<=4; i++){
			for(var k=1; k<=formObj.vsl_cnt.value; k++){
				if(sheetObj.CellValue(i, "Vsl_" + k)==''){
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
 * 선택한 포트에 Add Call이 몇번 되었는지 확인한다.
 * 
 * @param sheetObj
 * @param col
 * @return
 */
function countAdding(sheetObj, col){
	var count = 0;
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		if("A"==sheetObj.CellValue(i, col)){
			count++;
		}
	}
	
	return count;
}

/**
 * 선택한 포트에 Add Call된 포트가 몇개 있는지 확인한다.
 * 다른 VVD에 의해 Add Call 된 포트인지 확인하기 위해 사용한다.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function countAddCallPort(sheetObj, row, col){
	var count = 0;
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		if("A"==sheetObj.CellValue(i, col)){
			count++;
		}
	}
	
	// 선택한 포트가 Add 포트인 경우, 0을 반환하여 새로운 포트 컬럼이 생성되도록 유도한다. 
	if(""!=sheetObj.CellValue(row, col) && "A"==sheetObj.CellValue(row+sheet2StatusRowPos, col)){
		return 0;
	}
	
	return count;
}

/**
 * Sheet내 특정 스케쥴과 동일한 스케쥴을 찾는다. 시간 증가 방향.
 */
function findNextLinkSkd(sheetObj, Row, Col){

	var vslCd = sheetObj.CellValue(Row, "VVD1");
	var portCd = sheetObj.CellValue(sheet2VpsPortCdHeaderRow, Col);
	var clptIndSeq = sheetObj.CellValue(sheet2ClptIndSeqHeaderRow, Col);
	
	var etbDt = sheetObj.CellValue(Row, Col);
	var etdDt = sheetObj.CellValue(Row, Col+1);
	var find = false;
	var skipSkd = false;
	
	if(etbDt==skipvalue && etdDt==skipvalue){
		skipSkd = true;
		etbDt = sheetObj.CellValue(Row+sheet2StatusRowPos, Col);
		etdDt = sheetObj.CellValue(Row+sheet2StatusRowPos, Col+1);
	}
	
	var tgtSkd = new Object();
	var tgtCol = 0;
	var tgtRow = 0;
	
	for(var j=dataStartCol; j<Col; j++){
		if(sheetObj.CellValue(sheet2VpsPortCdHeaderRow, j)==portCd && 
				sheetObj.CellValue(sheet2ClptIndSeqHeaderRow, j)==clptIndSeq
		){	// 동일한 Port(port_cd, clpt_ind_seq 동일)를 찾는다.
			tgtCol = j;
			break;
		}
	}
	
	if(tgtCol==0){
		// 연결되는 동일한 Port를 찾지 못함.
		return false;
	}
	
	// Target Col 내에서 Vessel Code와 ETB, ETD가 동일한 스케쥴을 찾는다.
	for(var i=Row+dataSetCnt; i<sheetObj.LastRow; i=i+dataSetCnt){
		
		if(sheetObj.CellValue(i, "VVD1")==vslCd){
			if(!skipSkd){
				if(sheetObj.CellValue(i, tgtCol)==etbDt && sheetObj.CellValue(i, tgtCol+1)==etdDt){
					tgtRow = i;
					find = true;
					break;
				}
			}else{
				if(sheetObj.CellValue(i+sheet2StatusRowPos, tgtCol)==etbDt && sheetObj.CellValue(i+sheet2StatusRowPos, tgtCol+1)==etdDt){
					tgtRow = i;
					find = true;
					break;
				}
			}
		}
	}
	
	if(find){
		tgtSkd.tgtRow = tgtRow;
		tgtSkd.tgtCol = tgtCol;
		return tgtSkd;
	}else{
		return false;
	}
	
}

/**
 * Sheet내 특정 스케쥴과 동일한 스케쥴을 찾는다. 시간 감소 방향.
 */
function findPrevLinkSkd(sheetObj, Row, Col){
	
	var vslCd = sheetObj.CellValue(Row, "VVD1");
	var portCd = sheetObj.CellValue(sheet2VpsPortCdHeaderRow, Col);
	var clptIndSeq = sheetObj.CellValue(sheet2ClptIndSeqHeaderRow, Col);
	
	var etbDt = sheetObj.CellValue(Row, Col);
	var etdDt = sheetObj.CellValue(Row, Col+1);
	var find = false;
	var skipSkd = false;
	
	if(etbDt==skipvalue && etdDt==skipvalue){
		skipSkd = true;
		etbDt = sheetObj.CellValue(Row+sheet2StatusRowPos, Col);
		etdDt = sheetObj.CellValue(Row+sheet2StatusRowPos, Col+1);
	}
	
	var tgtSkd = new Object();
	var tgtCol = 0;
	var tgtRow = 0;
	
	for(var j=Col+2; j<sheetObj.LastCol; j++){
		if(sheetObj.CellValue(sheet2VpsPortCdHeaderRow, j)==portCd && 
				sheetObj.CellValue(sheet2ClptIndSeqHeaderRow, j)==clptIndSeq
			){	// 동일한 Port(port_cd, clpt_ind_seq 동일)를 찾는다.
			tgtCol = j;
			break;
		}
	}
	
	if(tgtCol==0){
		// 연결되는 동일한 Port를 찾지 못함.
		return false;
	}
	
	// Target Col 내에서 Vessel Code와 ETB, ETD가 동일한 스케쥴을 찾는다.
	for(var i=sheetObj.HeaderRows; i<Row; i=i+dataSetCnt){
		if(sheetObj.CellValue(i, "VVD1")==vslCd){
			if(!skipSkd){
				if(sheetObj.CellValue(i, tgtCol)==etbDt && sheetObj.CellValue(i, tgtCol+1)==etdDt){
					tgtRow = i;
					find = true;
					break;
				}
			}else{
				if(sheetObj.CellValue(i+sheet2StatusRowPos, tgtCol)==etbDt && sheetObj.CellValue(i+sheet2StatusRowPos, tgtCol+1)==etdDt){
					tgtRow = i;
					find = true;
					break;
				}
			}
		}
	}
	
	if(find){
		tgtSkd.tgtRow = tgtRow;
		tgtSkd.tgtCol = tgtCol;
		return tgtSkd;
	}else{
		return false;
	}
	
}

/**
 * 주어진 날짜의 분기말 일자를 반환한다.
 * 1분기 : 년도 + "0331" 반환
 * 2분기 : 년도 + "0631" 반환
 * 3분기 : 년도 + "0930" 반환
 * 4분기 : 년도 + "1231" 반환
 */
function getQuarterEndDate(date){
	
	var year = date.substring(0, 4);
	var month_date = date.substring(4, 8);
	
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
 * 주어진 날짜가 몇분기에 속하는지 체크한다.
 * 1분기 : "1" 반화
 * 2분기 : "2" 반환
 * 3분기 : "3" 반환
 * 4분기 : "4" 반환
 */
function checkQuarter(date){
	
	var month_date = date.substring(4, 8);
	
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
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var vslCnt = formObj.vsl_cnt.value;
	var headerRows = sheetObj.HeaderRows;
	var iVslCnt = vslCnt.parseInt();
	
    // 가장 마지막 Start Date 값이 End Date보다 이후인 경우
    // End Date를 이 Start Date 값보다 크게 조절해준다.
    if(iVslCnt > 0 && ComGetDaysBetween( formObj.end_date.value, sheetObj.CellValue(headerRows + sheet1StartDateDataRow, "Vsl_" + vslCnt))>=0){
    	
    	var quarterDate = getQuarterEndDate(sheetObj.CellValue(headerRows + sheet1StartDateDataRow, "Vsl_" + vslCnt));
    	formObj.end_year.value = quarterDate.substring(0, 4);
    	formObj.end_date.value = ComGetMaskedValue(quarterDate, "ymd");
    	
    	formObj.selEndQuarter.value = checkQuarter(quarterDate);
    }
	
}

function mergeHeaderCell(){
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	
}

function checkTargetPortIsAddPort(sheetObj, Row, Col){
	
	var formObj = document.form;
	var orgDirCd = sheetObj.CellValue(sheet2DirCdHeaderRow, Col); // 사용자가 선택한 포트의 Direction Code

	var usrPortCd = formObj.add_call_port_cd.value; 	// 사용자가 Add Port 팝업에서 입력한 Port
	var usrYardCd = formObj.add_call_yard_cd.value; 	// 사용자가 Add Port 팝업에서 입력한 Yard
	var usrCallPosition = formObj.add_call_position.value; 	// 사용자가 Add Port 팝업에서 before/after
	
	var targetPortCd = "";
	var targetYardCd = "";
	var targetDirCd = "";
	var targetCol = 0;
	
	if("before"==usrCallPosition){
		targetCol = Col - 2;
	}else if("after"==usrCallPosition){
		targetCol = Col + 2;
	}
	
	// 이미 데이터가 있는 경우는 false 리턴(즉, 타켓포트가 Add된 포트가 아님)
	if(""!=sheetObj.CellValue(Row, targetCol)){
		return false;
	}else{
		
		targetPortCd = sheetObj.CellValue(sheet2VpsPortCdHeaderRow, targetCol);
		targetYardCd = sheetObj.CellValue(sheet2YdCdHeaderRow, targetCol);
		targetDirCd = sheetObj.CellValue(sheet2DirCdHeaderRow, targetCol);
		
		if((targetPortCd==usrPortCd) && (targetDirCd==orgDirCd) && (targetYardCd==usrYardCd))
		{
			// 같은 Direction 내의 PortCd와 YardCd가 같은 경우
			return true;
		}else{
			return false;
		}
	}
	
	return false;
}

/*
 * 해당 Vessel에 대해 마지막 스케쥴을 찾는다.
 */
function isFinalVVD(sheetObj, Row){
	
	var tgtVslCd = sheetObj.CellValue(Row, "VVD1");
	
	var finalVVD = true;
	
	with(sheetObj){
		
		// 해당 Vessel 코드를 가지는 가장 마지막 Row를 찾는다. 
		for(var i = Row + dataSetCnt; i < HeaderRows + RowCount ; i = i+dataSetCnt){
			if(tgtVslCd==CellValue(i, "VVD1")){
				// 이후 VVD가 있다
				finalVVD = false;
				break;
			}
		}
	}
	
	return finalVVD;
}

/*
 * 해당 Vessel에 대해 특정 Row 이전 VVD중 마지막 스케쥴을 찾는다.
 */
function findLastSkd(sheetObj, Row){
	
	var tgtVslCd = sheetObj.CellValue(Row, "VVD1");
	var lastSkd = null;
	var tgtRow = "";
	var tgtCol = "";
	
	with(sheetObj){
		
		// 해당 Vessel 코드를 가지는 가장 마지막 Row를 찾는다. 
		for(var i = HeaderRows; i < Row; i = i+dataSetCnt){
			if(tgtVslCd==CellValue(i, "VVD1")){
				tgtRow = i;
			}
		}
		
		if(tgtRow==""){
			return null;
		}
		
		// P/F 상의 가장 마지막 포트("F"로 예상되는 포트)를 찾는다.
		for(var i = LastCol-2; i >3; i = i-2 ){
			
			// Add된 Port는 스킵한다.
			if(""==CellValue(2, i) || "*"==CellValue(2, i)){
				continue;
			}else{
				tgtCol = i;
				break;
			}
		}
		
		if(tgtRow=="" && tgtCol==""){
			return null;
		}else{
			lastSkd = new Object();
			lastSkd.row = tgtRow;
			lastSkd.col = tgtCol - 1;
			return lastSkd;
		}
		
	}
	
}

function checkPeriod(sheetObj, formObj){
	var startDate = ComReplaceStr(sheetObj.CellValue(1, "Vsl_1"), "-", "");
	var endDate = ComReplaceStr(formObj.end_date.value, "-", "");
	var tmpDate = ComGetDateAdd(startDate, "Y", 2);// 2년 이내의 기간만 허용 
	if(ComChkPeriod(endDate, tmpDate)==1){
		return true;
	}else{
		return false;
	}
}

function obj_propertychange(){
	var srcName = event.srcElement.name;
	var formObj = document.form;
	var eventElement = event.srcElement;
	
	switch(eventElement.name){
		
		case "start_date":
			var Col = 0;
			var sheetObj = sheetObjects[0];
			for(var i=1; i <= formObj.vsl_cnt.value; i++){
				
				if(ComReplaceStr(eventElement.value, "-", "") == sheetObj.CellValue(sheetObj.HeaderRows + sheet1StartDateDataRow, "Vsl_" + i)){
					Col = i;
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
	
	var formObj = document.form;
	var brth_itval_dys = formObj.brth_itval_dys.value;
    var dateInfo = Value; //"YYYY-MM-DD" 형식
    var check = 0;
    var otherDate = "";
    
    for(var i=1; i<Col; i++){
    	otherDate = sheetObj.CellValue(sheetObj.HeaderRows + sheet1StartDateDataRow, "Vsl_" + i);
    	otherDate = ComGetDateAdd(otherDate, "D", 0);
    	
    	if(ComGetDaysBetween(otherDate, Value) < 1){
    		check = i;
    		break;
    	}
    }
    
    if(check > 0){
    	ComShowCodeMessage("VSK00025", "Start date", otherDate);
    	sheetObj.SelectCell(sheetObj.HeaderRows + sheet1StartDateDataRow, "Vsl_" + Col, true, "");
    	return false;
    }
    
    for(var i=Col, k=0; i <= formObj.vsl_cnt.value; i++, k++){
   		sheetObj.CellValue2(sheetObj.HeaderRows + sheet1StartDateDataRow, "Vsl_" + i) = ComGetDateAdd(dateInfo, "D", k*brth_itval_dys);
    }
    
    adjustEndDate();
    
	// 결정된 start date에 가장 근접한 P/F date를 설정한다.
    //setPfDate();
}

/*
 * CHM-201005742-01 Frequency가 자연수가 아닌 실수일 때, 근접한 자연수로 전환하여 Start Date를 구하고
 * 추후 시간단위까지 조정하여 소수점 값을 반영한다.
 */
function manageStartInfo(){
	
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
    var brth_itval_dys = Number(formObj.brth_itval_dys.value);
    var nowInfo = ComGetNowInfo();
    var headerRow = sheetObj.HeaderRows;
    
    sheetObj.Redraw = false;
    for(var i=1; i <= formObj.vsl_cnt.value; i++){
    	
//    	alert((i-1)*brth_itval_dys);
//    	alert(ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys));
    	
   		sheetObj.CellValue2(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = ComGetDateAdd(nowInfo, "D", (i-1)*brth_itval_dys);
   		sheetObj.CellValue2(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = formObj.pf_svc_tp_cd.value;
   		
   		sheetObj.CellAlign(headerRow + sheet1StartDateDataRow, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(headerRow + sheet1VslCdDataRow, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(headerRow + sheet1VoyNoDataRow, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(headerRow + sheet1PfTypeDataRow, "Vsl_" + i) = daCenter;
   		
    }
    
    adjustEndDate();
    setColHidden(sheetObj,parseInt(formObj.vsl_cnt.value));
    sheetObj.Redraw = true;
}

function extend(){
	var objs = document.all.item("startinfo");

    if (!extendFlag) {
    	h1 = sheetObjects[0].style.height.replace(/[^0-9]/g, "") ;
    	h2 = sheetObjects[1].style.height.replace(/[^0-9]/g, "") ;
    	
    	sheetObjects[0].Redraw = false;
    	objs.style.display = "none";
    	sheetObjects[0].Redraw = true;
    	
    	sheetObjects[1].Redraw = false;
	    sheetObjects[1].style.height = Number(h1) + Number(h2) + 1;
	    sheetObjects[1].Redraw = true;
	    
	    document.getElementById("extend").style.display = "none";
	    document.getElementById("reduce").style.display = "block";
	    
	    extendFlag = true;
	}
}

function reduce(){
	var objs = document.all.item("startinfo");

    if ( extendFlag ) {
    	h1 = sheetObjects[0].style.height.replace(/[^0-9]/g, "") ;
    	h2 = sheetObjects[1].style.height.replace(/[^0-9]/g, "") ;
    	sheetObjects[1].Redraw = false;
	    sheetObjects[1].style.height = 322;
	    sheetObjects[1].Redraw = true;
	    
	    sheetObjects[0].Redraw = false;
	    objs.style.display = "inline";
	    sheetObjects[0].Redraw = true;
	    
	    document.getElementById("extend").style.display = "block";
	    document.getElementById("reduce").style.display = "none";
	    
	    extendFlag = false;
	}
}

function manageSheetSize(){
	
	// 초기창의 높이
	alert("init height=" + parentInitWinHeight);
	
	// 현재창의 높이
	var curWinHeight = parent.window.document.body.clientHeight;
	alert("current height=" + curWinHeight);
	
	var curMainHeight = parent.window.document.getElementById("main").style.height.replace(/[^0-9]/g, ""); // 현재 main 영역(iframe)의 높이
	var sheetHeight = sheetObjects[1].style.height.replace(/[^0-9]/g, "");
	
	sheetObjects[1].Redraw = false;
	if(curWinHeight<=parentInitWinHeight){
		// 초기값보다 작을때에는 sheet의 높이를 초기값으로 셋팅
		parent.window.document.getElementById("main").style.height = initMainHeight;
		sheetObjects[1].style.height = 322;
	}else if(curWinHeight>parentInitWinHeight){
		// 초기값보다 큰 경우 sheet의 높이를 행단위로 늘려줌.
		var gap = Number(curWinHeight) - Number(parentInitWinHeight);
		parent.window.document.getElementById("main").style.height = Number(curMainHeight) + Number(gap);
		sheetObjects[1].style.height = Number(sheetHeight) + parseInt(gap/20)*20;
	}
	sheetObjects[1].Redraw = true;
	return false;
	
}

/*
 * simulation 된 SKD에 포함된 Vessel List를 구한다.
 */
function getVesselList(){
	var sheetObj = sheetObjects[1]; 
	if(sheetObj.RowCount>0){
		var vesselList = new Array();
		var idx=0;
		for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+sheetObj.RowCount; Row++){
			if(!vesselList[sheetObj.CellValue(Row, "VVD1")]){
				vesselList[idx++] = sheetObj.CellValue(Row, "VVD1");
				vesselList[sheetObj.CellValue(Row, "VVD1")] = sheetObj.CellValue(Row, "VVD1");
			}
		}
		return vesselList; 
	}
}

/* 개발자 작업  끝 */