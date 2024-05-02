/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0001.js
*@FileTitle : P/F SKD Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.09 서창열
* 1.0 Creation
* 
* History
* 2010.09.10 유혁 CHM-201005742-01 Non-Weekly P/F SKD 생성
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
     * @class VOP_VSK_0001 : VOP_VSK_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var portDataFlgs = new Array();		//그리드의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
    var ydCdsArr = new Array();
    
    var submitFlg = "N";
    var ydCdChgFlg = new Array();
    
    var bakObjForEdit; // Edit 전후 백업 데이타 보관용
    var editMode = false;
    
    //P/F Type 체크  글로벌 변수
    var g_pfTypeData = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];

		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			case "btn_RowAdd":
    			var rowIdx = getRowCount(sheetObject2)+ sheetObject2.HeaderRows;
    			var rowIdx2 = 0;
    			if(rowIdx == sheetObject2.HeaderRows){

					if(sheetObject1.RowCount == 0){
						rowIdx2 = sheetObject1.DataInsert(-1);
					}
					rowIdx2 = sheetObject2.DataInsert(-1);
					resetRowSeq(sheetObject2);
					
					sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_dy_no") = 0;
					sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_dy_cd") = "MON";
					sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_tm_hrmnt") = "00:00";
					sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_etd_dy_no") = false;
					sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_etd_dy_cd") = false;
					sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_etd_tm_hrmnt") = false;
					sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_cgo_qty") = false;
					sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_tml_prod_qty") = true;
					
					sheetObject2.SelectCell(rowIdx2, sheetObject2.id+"_port_cd", true);
					
				
					//if(sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_ibflag") == "I"){
					if(sheetObject2.RowStatus(rowIdx2) == "I"){
						sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_tztm_hrs") = false;
						sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_sea_buf_spd") = false;
						sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_tml_prod_qty") = true;
						sheetObject2.CellEditable(rowIdx2, sheetObject2.id+"_crn_knt") = false;
					}
				

				}else{
					
					if(sheetObject1.RowCount == 0){
						sheetObject1.DataInsert(-1);
					}
					sheetObject2.DataInsert(-1);

					resetRowSeq(sheetObject2);
					var lastRow = searchLastRow(sheetObject2);

					//2009 09 29 임창빈 수석 요청 전 포트의 skd_dir_cd를  add Row한 현재 포트에 셋팅한다
					sheetObject2.CellValue(lastRow-1,"sheet2_skd_dir_cd") =  sheetObject2.CellValue(lastRow-2,"sheet2_skd_dir_cd");
					
					sheetObject2.CellEditable(lastRow-1, "sheet2_etb_dy_no") = false;
					sheetObject2.CellEditable(lastRow-1, "sheet2_etb_dy_cd") = false;
					sheetObject2.CellEditable(lastRow-1, "sheet2_etb_tm_hrmnt") = false;
					sheetObject2.CellEditable(lastRow-1, "sheet2_etd_dy_no") = false;
					sheetObject2.CellEditable(lastRow-1, "sheet2_etd_dy_cd") = false;
					sheetObject2.CellEditable(lastRow-1, "sheet2_etd_tm_hrmnt") = false;
					
					sheetObject2.SelectCell(lastRow-1, sheetObject2.id+"_port_cd", true);
					
					//if(sheetObject2.CellValue(lastRow-1,sheetObject2.id+"_ibflag") == "I"){
					if(sheetObject2.RowStatus(lastRow-1) == "I"){
						sheetObject2.CellEditable(lastRow-1, "sheet2_tztm_hrs") = false;
						sheetObject2.CellEditable(lastRow-1, "sheet2_sea_buf_spd") = false;
						sheetObject2.CellEditable(lastRow-1, "sheet2_tml_prod_qty") = true;
						sheetObject2.CellEditable(lastRow-1, "sheet2_crn_knt") = false;
						
					}
					setlastLowViewUndo(sheetObject2,lastRow-1);
					setlastLowView(sheetObject2,lastRow);

				}
//    			sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount + sheetObject2.HeaderRows+2);

    			sheet2_OnSearchEnd();

				break;
				
        		case "btn_RowInsert":
        			var rowIdx = sheetObject2.SelectRow + sheetObject2.HeaderRows - 1;
				
        			if(rowIdx){
        				if(rowIdx > sheetObject2.HeaderRows){
							sheetObject2.DataInsert(sheetObject2.SelectRow);
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etb_dy_no") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etb_dy_cd") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etb_tm_hrmnt") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etd_dy_no") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etd_dy_cd") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_etd_tm_hrmnt") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_tztm_hrs") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_sea_buf_spd") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_tml_prod_qty") = true;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_crn_knt") = false;
							//sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_lnk_dist") = true;
							
							resetRowSeq(sheetObject2);
							sheetObject2.CellValue(sheetObject2.SelectRow,"sheet2_skd_dir_cd") = sheetObject2.CellValue(sheetObject2.SelectRow-1,"sheet2_skd_dir_cd");
							//2009 09 29 임창빈 수석 요청 전 포트의 skd_dir_cd를  add Row한 현재 포트에 셋팅한다
							//insert Row에서 추가를 하면 전체 dir_cd가 바뀐다
							//sheetObject2.CellValue(rowIdx-1,"sheet2_skd_dir_cd") =  sheetObject2.CellValue(rowIdx-2,"sheet2_skd_dir_cd");
							sheetObject2.SelectCell(rowIdx-1, sheetObject2.id+"_port_cd", true);
							
							var lastRow = searchLastRow(sheetObject2);
							
							setlastLowViewUndo(sheetObject2,lastRow-1);
							setlastLowView(sheetObject2,lastRow);
						
        				}
        			}
        			sheet2_OnSearchEnd();
        			break;
				
        		case "btn_RowDelete":
        			
        			if(!ComShowCodeConfirm('VSK00005')){return;}

        			var rowIdx = sheetObject2.SelectRow + sheetObject2.HeaderRows - 1;

        			if(rowIdx){
        				if(rowIdx > sheetObject2.HeaderRows - 1){
							
							
							var result = ComRowHideDelete(sheetObject2,"sheet2_Sel");
							if(result  > 0){
//								doActionIBSheet(sheetObject1,formObject,REMOVE);
							}
	        				sheet2_OnSearchEnd();

        				}
        			}
        			
        			break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject2, formObject, IBSAVE,"Save");
					break;
					
				case "btn_MCalculation":
					doActionIBSheet(sheetObject2,formObject,COMMAND01);
					break;
					
				case "btn_EOTP":
					openEOTPCreation(sheetObject1,sheetObject2,formObject);
					break;
					
				case "btn_Settlement":
					doActionIBSheet(sheetObject2, formObject, IBSAVE,"Settle");
					break;
					
				case "btn_BerthWindow":
					open_BerthWindow(sheetObject1,sheetObject2,formObject);
					break;
				
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;
					
				case "btn_New":
					setEditMode(false);
					clearAllData(sheetObject1,sheetObject2,formObject);
					break;	
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
					break;
				case "btns_search03":
					openSimNoCdHelp(sheetObject2);
					break;	
				case "btn_DownExcel":
					
					var startRow		= sheetObject2.HeaderRows;
					var endRow			= sheetObject2.RowCount + sheetObject2.HeaderRows;
					//alert('file download   startRow =['+startRow+'],  endRow = ['+endRow+']');
					
					var prefix_sheet1	= "sheet1_";
					var prefix_sheet2	= "sheet2_";
					var prefix_sheet3	= "sheet3_";
					sheetObjects[2].InitDataCombo(0, "sheet3_skd_dir_cd", "", "");
					//alert(' startRow ['+startRow+'], endRow ['+endRow+'] :: port_cd ['+sheetObject2.CellValue(4,	prefix_sheet2+"port_cd"		)+']');
					//alert(sheetObject3.CellValue(3,	prefix_sheet3+"port_cd"		));

					sheetObject3.Editable 	= true;
					sheetObject3.RemoveAll	();
					
					var	j	= 0;
					var k	= 0;
					
					var firstPortFlg	= true;
					var lastPortFlg		= false;
					var firstPort		= "";				
					
					//하위  Sub, Total Sum을 위한 변수
					var tmpSubHCalc = 0;
					var tmpSubLnkDist = 0;
					var tmpSubTztmHrs = 0;
					var tmpSubMnvrInHrs = 0;
					var tmpSubMnvrOutHrs = 0;
					var tmpSubZd = 0;
					var tmpSubActWrkHrs = 0;
					var tmpSubSeaBufHrs = 0;
					
					var tmpSubHCalc2 = 0;
					var tmpSubLnkDist2 = 0;
					var tmpSubTztmHrs2 = 0;
					var tmpSubMnvrInHrs2 = 0;
					var tmpSubMnvrOutHrs2 = 0;
					var tmpSubZd2 = 0;
					var tmpSubActWrkHrs2 = 0;
					var tmpSubSeaBufHrs2 = 0;
					
					for(var i=startRow; i<endRow; i++){
						k		= j*2 + startRow;
						var j	= j+1;
						
						//var k	= i==startRow-1?i:(i-headerRows-1)*2+headerRows;
						//alert('i >>> ['+i+']   k >>> ['+k+']');
						//alert('port >>> '+sheetObject2.CellValue(i,	prefix_sheet2+"port_cd"			));
						//alert('firstPortFlg >>> '+firstPortFlg+' firstPort >>> '+firstPort+' lastPortFlg >>> '+lastPortFlg);
						
						if(firstPortFlg){
							firstPort		= sheetObject2.CellValue(i,prefix_sheet2+"port_cd")+sheetObject2.CellValue(i,prefix_sheet2+"yd_cd");
						}else if(i==endRow-1 && firstPort == sheetObject2.CellValue(i,prefix_sheet2+"port_cd")+sheetObject2.CellValue(i,prefix_sheet2+"yd_cd")){
							lastPortFlg		= true;
						}
						
						sheetObject3.DataInsert(-1);
						sheetObject3.CellValue2(k,	prefix_sheet3+"skd_dir_cd"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd"			);
						sheetObject3.CellValue2(k,	prefix_sheet3+"port_cd"			)	= sheetObject2.CellValue(i,	prefix_sheet2+"port_cd"			);
//						sheetObject3.CellValue2(k,	prefix_sheet3+"yd_cd"			)	= sheetObject2.CellValue(i,	prefix_sheet2+"yd_cd"			);
						
						
						if(lastPortFlg){
							sheetObject3.CellValue2(k,	prefix_sheet3+"mnvr_out_hrs"	)	= "";
							//cargo volume = ipc.in+out + ocean.in+out
							sheetObject3.CellValue2(k,	prefix_sheet3+"cgo_vol"			)	= "";
							sheetObject3.CellValue2(k,	prefix_sheet3+"tml_prod_qty"	)	= "";
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_no"		)	= "";
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_cd"		)	= "";
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_tm_hrmnt"	)	= "";
						}else{
							sheetObject3.CellValue2(k,	prefix_sheet3+"mnvr_out_hrs"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_out_hrs"	);	
							//cargo volume = ipc.in+out + ocean.in+out
							sheetObject3.CellValue2(k,	prefix_sheet3+"cgo_vol"			)	= parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"ib_ipcgo_qty"))
																								+
																							  parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"ob_ipcgo_qty"))
																								+
																							  parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"ib_ocn_cgo_qty"))
																								+
																							  parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"ob_ocn_cgo_qty"));
							sheetObject3.CellValue2(k,	prefix_sheet3+"tml_prod_qty"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"tml_prod_qty"	);
							sheetObject3.CellValue2(k,	prefix_sheet3+"cgo_vol"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"ib_ipcgo_qty"	);
//							sheetObject3.CellValue2(k,	prefix_sheet3+"tml_prod_qty"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"temp2"	);
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_no"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_dy_no"		);
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_cd"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_dy_cd"		);
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_tm_hrmnt"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_tm_hrmnt"	).substring(0,2);;
							
//							sheetObject3.CellValue2(k,	prefix_sheet3+"zd"				)	= parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))
//																								-
//																							  parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		));

						}
						
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_dy_no"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_dy_no"		);
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_dy_cd"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_dy_cd"		);
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_tm_hrmnt"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_tm_hrmnt"	).substring(0,2);
						sheetObject3.CellValue2(k,	prefix_sheet3+"act_wrk_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"		);
						
						sheetObject3.DataInsert(-1);
						sheetObject3.CellValue2(k+1 ,prefix_sheet3+"lnk_dist"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"		);
						sheetObject3.CellValue2(k+1 ,prefix_sheet3+"lnk_spd"			)	= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"			);
						sheetObject3.CellValue2(k+1 ,prefix_sheet3+"tztm_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"		);
						
//						sheetObject3.CellValue2(k+1,prefix_sheet3+"zd"				)	= sheetObject3.CellValue(k,	prefix_sheet3+"zd"				);
//						sheetObject3.CellValue2(k,prefix_sheet3+"zd"				)	= "";
						
						if(firstPortFlg){
							sheetObject3.CellValue2(k+1,prefix_sheet3+"mnvr_in_hrs"		)	= "";
						}else{
							sheetObject3.CellValue2(k-1,prefix_sheet3+"mnvr_in_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_in_hrs"		);	
						}
						
						sheetObject3.CellValue2(k+1,prefix_sheet3+"sea_buf_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"sea_buf_hrs"	);
						
						firstPortFlg	= false;
						
						sheetObject3.CellFont("FontColor", k, 14) = sheetObject3.RgbColor(255,0,0);
						sheetObject3.CellFont("FontColor", k, 17) = sheetObject3.RgbColor(255,0,0);
					}
					
					/////////////////////////////////////////////////////////////////////
					for(var i=startRow; i<endRow-1; i++){
						if(i==startRow){
							var tmpDir = sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd");
						}
						
						if(tmpDir == sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd")){
							
						tmpSubLnkDist 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"));
						tmpSubHCalc 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist")*sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"	));
						tmpSubTztmHrs 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"));
						tmpSubMnvrInHrs += parseFloat(sheetObject2.CellValue(i+1,	prefix_sheet2+"mnvr_in_hrs"));
						tmpSubMnvrOutHrs += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_out_hrs"));
//						tmpSubZd	 	 += (parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))-parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		)));
						tmpSubActWrkHrs  += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"));
						tmpSubSeaBufHrs  += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"sea_buf_hrs"));
						
						}else if(tmpDir != sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd")){
							
							var tmpOthDir = sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd");
							
							tmpSubLnkDist2 		+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"));
							tmpSubHCalc2 		+= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist")*sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"	);
							tmpSubTztmHrs2 		+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"));
							tmpSubMnvrInHrs2  	+= parseFloat(sheetObject2.CellValue(i+1,	prefix_sheet2+"mnvr_in_hrs"));
							tmpSubMnvrOutHrs2 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_out_hrs"));
							tmpSubZd2     	  	+= (parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))-parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		)));
							tmpSubActWrkHrs2  	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"));
							tmpSubSeaBufHrs2  	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"sea_buf_hrs"));
						}
						
						
					
					}
					
					
					var endRow			= sheetObject3.RowCount + sheetObject3.HeaderRows;
					sheetObject3.RowDelete(endRow-1, false);
					
					var Row1 = sheetObject3.DataInsert();
					/////////////////////////////////////////////////////////////////////
					sheetObject3.CellValue2(Row1, prefix_sheet3+"skd_dir_cd") = tmpDir;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"lnk_dist") = tmpSubLnkDist;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"lnk_spd") = tmpSubHCalc/tmpSubLnkDist;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"tztm_hrs") = tmpSubTztmHrs;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"mnvr_out_hrs") = tmpSubMnvrOutHrs;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"mnvr_in_hrs") = tmpSubMnvrInHrs;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"zd") = tmpSubZd;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"act_wrk_hrs") = tmpSubActWrkHrs;
					sheetObject3.CellValue2(Row1, prefix_sheet3+"sea_buf_hrs") = tmpSubSeaBufHrs;
					for(var i=0; i<21; i++){
						sheetObject3.CellBackColor(Row1, i) = sheetObject3.RgbColor(242, 221, 220);
					}
					
					var Row2 = sheetObject3.DataInsert();
					
					/////////////////////////////////////////////////////////////////////
					sheetObject3.CellValue2(Row2, prefix_sheet3+"skd_dir_cd") = tmpOthDir;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"lnk_dist") = tmpSubLnkDist2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"lnk_spd") = parseFloat(tmpSubHCalc2/tmpSubLnkDist2);
					sheetObject3.CellValue2(Row2, prefix_sheet3+"tztm_hrs") = tmpSubTztmHrs2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"mnvr_out_hrs") = tmpSubMnvrOutHrs2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"mnvr_in_hrs") = tmpSubMnvrInHrs2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"zd") = tmpSubZd2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"act_wrk_hrs") = tmpSubActWrkHrs2;
					sheetObject3.CellValue2(Row2, prefix_sheet3+"sea_buf_hrs") = tmpSubSeaBufHrs2;
					for(var i=0; i<21; i++){
						sheetObject3.CellBackColor(Row2, i) = sheetObject3.RgbColor(242, 221, 220);
					}
					
					var Row3 = sheetObject3.DataInsert();
					/////////////////////////////////////////////////////////////////////
					sheetObject3.CellValue2(Row3, prefix_sheet3+"skd_dir_cd") = "TTL";
					sheetObject3.CellValue2(Row3, prefix_sheet3+"lnk_dist") = tmpSubLnkDist + tmpSubLnkDist2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"lnk_spd") = (tmpSubHCalc + tmpSubHCalc2)/(tmpSubLnkDist + tmpSubLnkDist2);
					sheetObject3.CellValue2(Row3, prefix_sheet3+"tztm_hrs") = tmpSubTztmHrs + tmpSubTztmHrs2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"mnvr_out_hrs") = tmpSubMnvrOutHrs + tmpSubMnvrOutHrs2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"mnvr_in_hrs") = tmpSubMnvrInHrs + tmpSubMnvrInHrs2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"zd") = tmpSubZd + tmpSubZd2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"act_wrk_hrs") = tmpSubActWrkHrs + tmpSubActWrkHrs2;
					sheetObject3.CellValue2(Row3, prefix_sheet3+"sea_buf_hrs") = tmpSubSeaBufHrs + tmpSubSeaBufHrs2;
					for(var i=0; i<21; i++){
						sheetObject3.CellBackColor(Row3, i) = sheetObject3.RgbColor(242, 221, 220);
					}
					
//					sheetObject3.CellFont("FontColor",0,8) = sheetObject3.RgbColor(255,0,0);
					
		
					//::(
					//		[Mode]				, [UseOpenFile]		, [NewSheet]		, [Merge]			, [SaveAsName]
					//	,	[ReportPageUrl]		, [HideExcelMsg]	, [WriteTreeLevel]	, [WorkSheetName]	, [FocusFirstSheet]
                    //  ,	[ColumnSkipList]	, [RowSkipList]		, [bProtect]		, [bFormula]		, [IncludeImageType]
					//	) 
					//var sReportPageUrl	= "apps/alps/vop/vsk/scheduleplanningoperation/proformaschedulemgt/jsp/VOP_VSK_0003ExcelDown.xml";
					//var sReportPageUrl	= "apps/alps/vop/vsk/scheduleplanningoperation/proformaschedulemgt/script/VOP_VSK_0003ExcelDown2.xml";
					var sReportPageUrl	= "apps/alps/vop/vsk/scheduleplanningoperation/proformaschedulemgt/jsp/VOP_VSK_0001ExcelDown.jsp";
					
					var pf_vsl_cd	= sheetObject1.CellValue(1, "sheet1_vsl_slan_cd");
					var pf_duration	= sheetObject1.CellValue(1, "sheet1_svc_dur_dys");
					//::n1st_vsl_clss_cd*n1st_vsl_clss_knt, n2nd_vsl_clss_cd*n2nd_vsl_clss_knt, n3rd_vsl_clss_cd*n3rd_vsl_clss_knt:://
					var pf_vsl_clss	= sheetObject1.CellValue(1, "sheet1_n1st_vsl_clss_cd") + ' X ' + sheetObject1.CellValue(1, "sheet1_n1st_vsl_clss_knt")
					if(sheetObject1.CellValue(1, "sheet1_n2nd_vsl_clss_cd") != ""){
						pf_vsl_clss	= pf_vsl_clss + ", " + sheetObject1.CellValue(1, "sheet1_n2nd_vsl_clss_cd") + ' X ' + sheetObject1.CellValue(1, "sheet1_n2nd_vsl_clss_knt")
					}
					if(sheetObject1.CellValue(1, "sheet1_n3rd_vsl_clss_cd") != ""){
						pf_vsl_clss	= pf_vsl_clss + ", " + sheetObject1.CellValue(1, "sheet1_n3rd_vsl_clss_cd") + ' X ' + sheetObject1.CellValue(1, "sheet1_n3rd_vsl_clss_knt")
					}		
					
					var pf_skd_tp	= sheetObject1.CellValue(1, "sheet1_pf_svc_tp_cd");
					//var pf_upd_dt	= sheetObject1.CellValue(1, "sheet1_upd_dt").substring(0,10);
					
					//alert(pf_vsl_cd);
					//alert(pf_duration);
					//alert(pf_vsl_clss);
					//alert(pf_skd_tp);
					//alert(pf_upd_dt);
					
					var param	= "?pf_vsl_cd="+pf_vsl_cd;
						param	= param + "&pf_duration="+pf_duration;
						param	= param + "&pf_vsl_clss="+pf_vsl_clss;
						param	= param + "&pf_skd_tp="+pf_skd_tp;
						//param	= param + "&pf_upd_dt="+pf_upd_dt;
					
					//sheetObject3.showDebugMsg	= true;
					sheetObject3.Down2Excel(-1, false, false, true, "", sReportPageUrl+param);
					//sheetObject3.showDebugMsg	= false;
                
					break;	
					
				case "btn_UploadExcel":
					//if(!validateForm(sheetObject2,formObject,COMMAND03))	return;
//					if(!validateForm(sheetObject1,document.form,"FileUpload"))		return;
					sheetObjects[2].InitDataCombo(0, "sheet3_skd_dir_cd", "W|E", "W|E");
					var prefix_sheet2	= "sheet2_";
					var prefix_sheet3	= "sheet3_";					
					
					//sheetObjects[2].InitDataCombo(0, "sheet2_skd_dir_cd", "W|E", "W|E");
					sheetObject3.Editable = true;
					sheetObject3.RemoveAll();
					sheetObject3.LoadExcel();
					clearAllDataForSheet(sheetObject1,sheetObject2);
					/////////////////////// sheetObject3 >> sheetObject2 COPY ////////////////////////
					var startRow		= sheetObject3.HeaderRows;
					var endRow			= sheetObject3.RowCount + sheetObject3.HeaderRows;					
					//alert(sheetObject3.RowCount +("|||||")+sheetObject3.HeaderRows)
					//alert('file upload   startRow =['+startRow+'],  endRow = ['+endRow+']');
					//return;
					
					var k	= 0;
					var j	= 0;
					
					var lastRowPortCd		= "";
					var lastRowTmlCd		= "";
					var lastRowZdCd			= "";
					var lastRowEtbDyNo		= "";
					var lastRowEtbDyCd		= "";
					var lastRowEtbTmHrmnt	= "";
					
					for(var i=startRow; i<endRow-1; i++){
						if(i == startRow){
							k	= i;
							j	= i;
						}else{
							k++;
							j	= j+2;
						}
						
						//alert('i  = ['+i+']');
						
						sheetObject2.DataInsert(-1);
						
						sheetObject2.CellValue2(k,	prefix_sheet2+"skd_dir_cd"			)	= sheetObject3.CellValue(j,	prefix_sheet3+"skd_dir_cd"			);
						sheetObject2.CellValue2(k,	prefix_sheet2+"port_cd"			)	= sheetObject3.CellValue(j,	prefix_sheet3+"port_cd"			);
//						sheetObject2.CellValue2(k,	prefix_sheet2+"yd_cd"			)	= sheetObject3.CellValue(j,	prefix_sheet3+"yd_cd"			);
						sheetObject2.CellValue2(k,	prefix_sheet2+"mnvr_out_hrs"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"mnvr_out_hrs"	);
//						sheetObject2.CellValue2(k,	prefix_sheet2+"zd"				)	= sheetObject3.CellValue(j,	prefix_sheet3+"zd"				);
						sheetObject2.CellValue2(k,	prefix_sheet2+"ib_ipcgo_qty"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"ib_ipcgo_qty"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"tml_prod_qty"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"tml_prod_qty"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etb_dy_no"		)	= sheetObject3.CellValue(j,	prefix_sheet3+"etb_dy_no"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etb_dy_cd"		)	= sheetObject3.CellValue(j,	prefix_sheet3+"etb_dy_cd"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etb_tm_hrmnt"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"etb_tm_hrmnt"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etd_dy_no"		)	= sheetObject3.CellValue(j,	prefix_sheet3+"etd_dy_no"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etd_dy_cd"		)	= sheetObject3.CellValue(j,	prefix_sheet3+"etd_dy_cd"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"etd_tm_hrmnt"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"etd_tm_hrmnt"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"act_wrk_hrs"		)	= sheetObject3.CellValue(j,	prefix_sheet3+"act_wrk_hrs"		);							
						
						//row changing//
						sheetObject2.CellValue2(k,	prefix_sheet2+"lnk_dist"		)	= sheetObject3.CellValue(j+1,prefix_sheet3+"lnk_dist"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"lnk_spd"			)	= sheetObject3.CellValue(j+1,prefix_sheet3+"lnk_spd"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"tztm_hrs"		)	= sheetObject3.CellValue(j+1,prefix_sheet3+"tztm_hrs"		);
						sheetObject2.CellValue2(k,	prefix_sheet2+"mnvr_in_hrs"		)	= sheetObject3.CellValue(j-1,prefix_sheet3+"mnvr_in_hrs"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"sea_buf_hrs"		)	= sheetObject3.CellValue(j+1,prefix_sheet3+"sea_buf_hrs"	);					
						
					}
					//////////////////////////////////////////////////////////////////////////////////
					var startRow		= sheetObject2.HeaderRows;
					var endRow			= sheetObject2.RowCount + sheetObject2.HeaderRows;
					
					for(var i=endRow-1; i>=startRow; i--){
						//alert(sheetObject2.CellValue(i,prefix_sheet2+"port_cd") );
						if( 	sheetObject2.CellValue(i,prefix_sheet2+"port_cd") == "" 
							||	sheetObject2.CellValue(i,prefix_sheet2+"port_cd") == null 
							||	sheetObject2.CellValue(i,prefix_sheet2+"port_cd") == undefined )
						{
							//alert('BFR...['+i+']'+sheetObject2.CellValue(i,prefix_sheet2+"port_cd")+'['+sheetObject2.CellValue(i,prefix_sheet2+"port_cd") == undefined+']' );
							sheetObject2.RowDelete(i, false);
							//alert('AFT...['+i+']'+sheetObject2.CellValue(i,prefix_sheet2+"port_cd") );
						}
					}					
					//////////////////////////////////////////////////////////////////////////////////
					var startRow		= sheetObject2.HeaderRows;
					var endRow			= sheetObject2.RowCount + sheetObject2.HeaderRows;
					
					sheetObject2.CellValue2(startRow,	prefix_sheet2+"mnvr_in_hrs"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"mnvr_out_hrs"	)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"tml_prod_qty"	)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"etd_dy_no"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"etd_dy_cd"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"etd_tm_hrmnt"	)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"act_wrk_hrs"		)	= "";			
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"lnk_dist"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"lnk_spd"			)	= "";
					//sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"tztm_hrs"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"sea_buf_hrs"		)	= "";
					
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount + sheetObject2.HeaderRows+2);
					resizeTo( 1000, document.body.scrollHeight 	);
			        window.scrollTo(0,0);
					
					break;	
					
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
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
	
		for(i=0; i<sheetObjects.length; i++){
	
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
	
			ComEndConfigSheet(sheetObjects[i]);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		initControl();
		
		document.form.sim_dt.focus();
		
		if(sheetObjects[0].RowCount == 0){
			sheetObjects[0].DataInsert(-1);
		}
	}

	/**
	 * 이벤트 컨드롤 정의
	 */
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm('focus', 'obj_focus', formObj);
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm('keyup', 'obj_keyup' , form);
		axon_event.addListenerForm('change', 'obj_change' , form);
	}
	
	function obj_focus() {
		if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
	}
	
	/**
	 * KEY PRESS 이벤트
	 */
	function obj_keypress() {
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break; 
	        case "lowernum":
	            //영문 쏘문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('lowernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break;    
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

	/**
	 * 필드 데이타가 CHANGE될 경우 이벤트
	 */
	function obj_keyup(){
		
		var formObject = document.form;
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObject1 = sheetObjects[0];
	    /*******************************************************/
	
	    if(sheetObjects[0].RowCount == 0){
			sheetObjects[0].DataInsert(-1);
		}
	    
		try {
			var srcName = window.event.srcElement.getAttribute("name"); 
	        switch(srcName) {
	            case "sim_dt":
					if(formObject.sim_dt.value.length == 8){
						sheetObject1.CellValue(1,"sheet1_sim_dt") = formObject.sim_dt.value;
						formObject.sim_no.focus();
					}
	            	break;
	            	
	            case "sim_no":
	            	sheetObject1.CellValue(1,"sheet1_sim_no") = formObject.sim_no.value;
	            	break;
					
	            case "pf_svc_tp_cd":
					var cnt = formObject.pf_svc_tp_cd.value.length;
					
					if(cnt == 4){
						//2009 11 27 PF_TYPE_CD CHECK LIM 요청
	//					var sXml = doActionIBSheet(sheetObjects[0], formObject, SEARCH06);
						//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
	//					var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
						
	//					g_pfTypeData = pfTypeData;
	//					if(pfTypeData[0] == "Y"){
	//						ComShowCodeMessage("VSK00091");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else if(pfTypeData[1] == "Y"){
	//						ComShowCodeMessage("VSK00092");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else{
						sheetObject1.CellValue(1,"sheet1_pf_svc_tp_cd") = formObject.pf_svc_tp_cd.value;
						formObject.pf_skd_rmk.focus();
	//					}
					}
					
	            	
	            case "slan_stnd_flg":
					sheetObject1.CellValue(1,"sheet1_slan_stnd_flg") = formObject.slan_stnd_flg.value;
	            	break;	
	            	
	            case "pf_skd_rmk":
					sheetObject1.CellValue(1,"sheet1_pf_skd_rmk") = formObject.pf_skd_rmk.value;
	            	break;
	            	
	            case "n1st_vsl_clss_cd":
					sheetObject1.CellValue(1,"sheet1_n1st_vsl_clss_cd") = formObject.n1st_vsl_clss_cd.value;
	            	break;
	            	
	            case "n1st_vsl_clss_knt":
					sheetObject1.CellValue(1,"sheet1_n1st_vsl_clss_knt") = formObject.n1st_vsl_clss_knt.value;
	            	break;
	            	
	            case "n2nd_vsl_clss_cd":
					sheetObject1.CellValue(1,"sheet1_n2nd_vsl_clss_cd") = formObject.n2nd_vsl_clss_cd.value;
	            	break;
	            	
	            case "n2nd_vsl_clss_knt":
					sheetObject1.CellValue(1,"sheet1_n2nd_vsl_clss_knt") = formObject.n2nd_vsl_clss_knt.value;
	            	break;
	            	
	            case "n3rd_vsl_clss_cd":
					sheetObject1.CellValue(1,"sheet1_n3rd_vsl_clss_cd") = formObject.n3rd_vsl_clss_cd.value;
	            	break;
	            	
	            case "n3rd_vsl_clss_knt":
					sheetObject1.CellValue(1,"sheet1_n3rd_vsl_clss_knt") = formObject.n3rd_vsl_clss_knt.value;
	            	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}

	function obj_change(){
		var formObj = document.form;
	    var sheetObj = sheetObjects[0];
	    
	    if(sheetObj.RowCount == 0){
	    	sheetObj.DataInsert(-1);
		}
	    
		try {
			var srcName = window.event.srcElement.getAttribute("name"); 
	        switch(srcName) {
		        case "sim_dt":
		        	clearDescData(sheetObjects, formObj);
		        	break;
	            	
	            case "sim_no":
	            	clearDescData(sheetObjects, formObj);
	            	break;
	
//	            case "vsl_slan_cd":
//	            	var cnt = formObj.vsl_slan_cd.value.length;
//					if(cnt == 3){
//						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
//						
//						var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
//			  		  	var dirCds = ComGetEtcData(sXml, "checkDirCd");
//					  	sheetObjects[1].InitDataCombo(0, "sheet2_skd_dir_cd", dirCds,dirCds);
//	
//						if(vslSlanNm == ""){
//							ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
//							formObj.vsl_slan_cd.value = "";	
//						}else{
//							formObj.pf_svc_tp_cd.focus();
//						}
//						
//						sheetObj.CellValue(1,"sheet1_vsl_slan_cd") = formObj.vsl_slan_cd.value;
//					}
//					
//	            	break;
					
	            case "pf_svc_tp_cd":
					var cnt = formObj.pf_svc_tp_cd.value.length;
					if(cnt == 4){
						//2009 11 27 PF_TYPE_CD CHECK LIM 요청
						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH06);
						//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
						var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
						
						g_pfTypeData = pfTypeData;
	//					if(pfTypeData[0] == "Y"){
	//						ComShowCodeMessage("VSK00091");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else if(pfTypeData[1] == "Y"){
	//						ComShowCodeMessage("VSK00092");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else{
						sheetObj.CellValue(1,"sheet1_pf_svc_tp_cd") = formObj.pf_svc_tp_cd.value;
						formObj.pf_skd_rmk.focus();
						
	//					}
					}
	            	break;
	                
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}

  /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
	var sheetID = sheetObj.id;
			
    switch(sheetID) {
    	case "sheet1":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
            //전체 너비 설정
            SheetWidth = 0;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 3, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            var HeadTitle = "STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|";
            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            
            var prefix = "sheet1_";
            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 	false, 		prefix+"ibflag");
            InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"slan_stnd_flg",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"svc_dur_dys",    		false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"stnd_svc_spd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"brth_itval_dys",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"mml_usd_flg",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_dt",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_no",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_knt",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n2nd_vsl_clss_cd",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n2nd_vsl_clss_knt",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n3rd_vsl_clss_knt",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"clpt_knt",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"ttl_dist",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"max_spd",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"avg_spd",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"delt_flg",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"pf_skd_rmk",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++,  dtCheckBox,       0,    daCenter,  	true,   	prefix+"hiddencheck");
            
            
            //CountPosition = 0;
            //SelectionMode = smSelectionList; //추가
            WaitImageVisible = false;
       }
        
        break;
        
        case "sheet2":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 312;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
//                var HeadTitle1 = "|Sel.|No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|Manv.|Manv.|Cargo\nVolume|TMNL\nPROD|Port\nTime|ETB|ETB|ETB|ETD|ETD|ETD|BUFF\nTime|Port\nBUF|TMNL\nCode|ZD|Sea\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
//                var HeadTitle2 = "|Sel.|No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|In|Out|Cargo\nVolume|TMNL\nPROD|Port\nTime|No.|Day|Time|No.|Day|Time|BUFF\nTime|Port\nBUFT|MNL\nCode|ZD|Sea\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
//                var HeadTitle3 = "||No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|In|Out|Cargo\nVolume|TMNL\nPROD|Port\nTime|No.|Day|Time|No.|Day|Time|BUFF\nTime|Port\nBUF|TMNL\nCode|ZD|Sea\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
//				var headCount = ComCountHeadTitle(HeadTitle1);

                var HeadTitle1 = "|Sel.|No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|Manv.|Manv.|Cargo\nVolume|TMNL\nPROD|Port\nTime|ETB|ETB|ETB|ETD|ETD|ETD|BUFF\nTime|Port\nBUF|TMNL\nCode|ZD|Sea\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
                var HeadTitle2 = "|Sel.|No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|In|Out|Cargo\nVolume|TMNL\nPROD|Port\nTime|No.|Day|Time|No.|Day|Time|BUFF\nTime|Port\nBUFT|MNL\nCode|ZD|Sea\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
                var HeadTitle3 = "||No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|In|Out|Cargo\nVolume|TMNL\nPROD|Port\nTime|No.|Day|Time|No.|Day|Time|BUFF\nTime|Port\nBUF|TMNL\nCode|ZD|Sea\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(3, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);		
                InitHeadRow(1, HeadTitle2, true);		
                InitHeadRow(2, HeadTitle3, true);		
                
                var prefix = "sheet2_";
                //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30, 	daCenter, 	false, 	prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		27,		daCenter,	true,	prefix+"Sel");
				InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,	prefix+"row_seq",           false,	"",			dfInteger,		0,		false,		false,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",		dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    35,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"ib_ipcgo_qty",				false,	"",			dfFloat,		0);
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfFloat,		0);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
	
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfInteger,		0);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
	
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,			25,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);                                                                              	
				//InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"temp1",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);                                                                                            	
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			25,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
				InitDataProperty(0, cnt++ , dtHidden,			40,		daRight,	true,	prefix+"temp2",		false,	"",			dfFloat,		0);
				
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++,  dtHidden,     0,    	daCenter,  	true,   prefix+"hiddencheck");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"check_wk_tm");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"crane_wk_tm");
				
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"clpt_seq");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"port_rotn_seq");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"mdm_skd_dir_cd");
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                         
				//InitDataCombo(0, prefix+"skd_dir_cd", "", "");
				InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
//				InitDataCombo(0, prefix+"yd_cd", "", "");
				InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
//				InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N");
				InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");
				
				
				CountPosition = 0;
				SetSortDialog(false);		
				//SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = 10;
				RowHeight(1) = 10;
				RowHeight(2) = 10;
				ColHidden(32) = true;
				ToolTipOption="balloon:true;width:320";

				SelectHighLight = false;
				WaitImageVisible = false;
				EditEnterBehavior = "edit";
				FocusAfterProcess = false;
               }
                break;
                
        case "sheet3":      //sheet3 init
            with (sheetObj) {

                // 높이 설정
                style.height = 0;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                var HeadTitle1 = "DIR|PORT|DIST|SPD|SEA\n\nTime|MAN.|MAN.|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|ETB|ETB|ETB|ETD|ETD|ETD|BUFF\n\nTime|Port\nBUF";
                var HeadTitle2 = "DIR|PORT|DIST|SPD|SEA\n\nTime|IN|OUT|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|Day|Date|Hrs|Day|Date|Hrs|BUFF\n\nTime|Port\nBUF";
                var HeadTitle3 = "DIR|PORT|DIST|SPD|SEA\n\nTime|IN|OUT|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|Day|Date|Hrs|Day|Date|Hrs|BUFF\n\nTime|Port\nBUF";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(3, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);		
                InitHeadRow(1, HeadTitle2, true);		
                InitHeadRow(2, HeadTitle3, true);		
                
                var prefix = "sheet3_";
                //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
/*				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfNone,			0, 		true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    55,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"cgo_vol",			false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfFloat,		0);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);

				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfInteger,		0, 		true,		true,		1,			false,		false );
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				
				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                 */          
                
                InitDataProperty(0, cnt++ , dtCombo,		25,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",			dfNone,			0);     
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfNone,			0, 		true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfNullInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    30,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfNullFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"zd",				false,	"",			dfNullInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"ib_ipcgo_qty",			false,	"",			dfNone,		0,      true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNullInteger,		0, 		true,		true,		1,			false,		false );
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNullInteger,			0);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				
				//InitDataCombo(0, prefix+"skd_dir_cd", "", "");
				//InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
				//jsk//InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
				//jsk//InitDataCombo(0, prefix+"yd_cd", "", "");
				//jsk//InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				//jsk//InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				//jsk//InitDataCombo(0, prefix+"turn_port_flg", "N|Y", "N|Y");
				
				//InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");

				//CountPosition = 0;
				//SetSortDialog(false);		
				//SheetOutLineColor = RgbColor(0,0,0);
				//RowHeight(0) = 10;
				//RowHeight(1) = 10;
				//RowHeight(2) = 10;
				//ToolTipOption="balloon:true;width:320";
				
				//SelectHighLight = false;
				//WaitImageVisible = false;
           }
            break; 
            
        case "sheet4":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 78;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                
//                var HeadTitle1 = "|Sel.|No.|DIR|Port\nCode|Dist|Sea\nSPD|Sea\nTime|In|Out|Cargo\nVolume|TMNL\nPROD|Port\nTime|No.|Day|Time|No.|Day|Time|BUFF\nTime|Port\nBUF|TMNL\nCode|ZD|Sea\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD|Sea\nBUF\nSPD";
                var HeadTitle1 = "|||||||||||||||||||||||||||||||||||||";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(0, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, false, true);		
                
                var prefix = "sheet4_";
                //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30, 	daCenter, 	false, 	prefix+"ibflag");
//				InitDataProperty(0, cnt++ , dtData,			27,		daCenter,	true,	prefix+"Sel");
//				InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,	prefix+"row_seq",           false,	"",			dfInteger,		0,		false,		false,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",		dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    35,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"cgo_qty",			false,	"",			dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"tml_prod_qty",			false,	"",			dfNone,		0);

				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,			25,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);                                                                              	
				//InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ib_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);                                                                                            	
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			25,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
				InitDataProperty(0, cnt++ , dtHidden,			40,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfFloat,		0);
				
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++,  dtHidden,     0,    	daCenter,  	true,   prefix+"hiddencheck");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"check_wk_tm");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"crane_wk_tm");
				
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"clpt_seq");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"port_rotn_seq");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"mdm_skd_dir_cd");
				InitDataProperty(0, cnt++ , dtHidden,			35,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                         
				//InitDataCombo(0, prefix+"skd_dir_cd", "", "");
//				InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
//				InitDataCombo(0, prefix+"yd_cd", "", "");
//				InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
//				InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
//				InitDataCombo(0, prefix+"turn_port_flg", "Y|N", "Y|N");
				InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");
                HeadBackColor = RgbColor(0, 0, 0);

				
				
				CountPosition = 0;
				SetSortDialog(false);		
				//SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = 10;
				RowHeight(1) = 10;
				RowHeight(2) = 10;
				ColHidden(0) = true;
				ToolTipOption="balloon:true;width:320";

				SelectHighLight = false;
				WaitImageVisible = false;
				EditEnterBehavior = "edit";
				FocusAfterProcess = false;
               }
                break;   
        }
    }

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, sFlag) {
    sheetObj.ShowDebugMsg = false;
//alert(sAction);
    switch(sAction) {
    
		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
	  		    
				formObj.f_cmd.value = SEARCH;
				var	sParm = "f_cmd=" +formObj.f_cmd.value+
						"&sim_dt=" +formObj.sim_dt.value+
						"&sim_no=" +formObj.sim_no.value;
				
		        var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParm + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				
				submitFlg = "Y";
				for(var inx=0; inx<arrXml.length; inx++){
					searchShowSheetData(sheetObjects[inx],formObj,arrXml[inx],"N");
				}
				var rowPos = sheetObjects[1].HeaderRows + sheetObjects[1].RowCount;
				setlastLowView(sheetObjects[1],rowPos);
				ComOpenWait(false);
				setEditMode(false);
//				resizeTo( 1000, document.body.scrollHeight 	);
//		        window.scrollTo(0,0);

			}
		break;
		/*
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			var loc_cd = formObj.port_cd.value;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			
			return sXml;

		break;
		*/	
		
		case SEARCH02:

			var prefix = "sheet2_";
			// port_cd가 Change될때  해당 port_cd에  대한  check Port, Yd_cd를 조회한다
			//추가 임창빈 수석 20090915
			// FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.
			var headCnt = sheetObj.HeaderRows;
			var rowCnt = sheetObj.RowCount;
			var totalCnt = headCnt+rowCnt;
			var currRow = sheetObj.SelectRow;
			var idx = 0;
			//현재 change된 port의 로우
			var currPos = (sheetObj.SelectRow - headCnt)+1;
			//현재 포트 의 전  포트가 존재 하지 않을시 : 1 (add Row로 첫번째 로우의 생성시, 조회 후  첫번째 로우의 포트를  수정시 )
			//현재 포트의 전 포트가 존재 할시   : 1 (add Row로 로우 생성시 )
			//현재 포트의 후 포트가 존재 할 시 : 2 add Row로 로우 추가시, 조회 후 insert Row로 새 포트 추가시
			var portInfoCnt = "";
			//현재 포트의 전 포트가 존재 하는지  여부를 저장
			//response 시 ETC Data로 자신의 포트에 데이타를 출력한지 아님 전 포트에 데이타를 출력할지 여부 
			var data_pos = "";
			
			//현재 포트가 첫번째이면서 전체 로우가 하나일때
			if(currPos == 1 && currPos == rowCnt){
				portInfoCnt = 1;
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value = "";
				//현재 로우가 To Port
				formObj.second_port_cd.value = sheetObj.CellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가 없다
				formObj.third_port_cd.value = "";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value = portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value = currRow;
				//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
				formObj.data_pos.value = "S";
			//현재 포트가 첫번째 이하이면서 전체 로우가 하나이상일때	
			}else if(currPos > 1 && currPos <= rowCnt-1){
				portInfoCnt = 2;
				//전 port가 FROM PORT된다
				/*
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currRow-1,"sheet2_port_cd");
					return false;
				}else if(sheetObj.CellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos+1,"sheet2_port_cd");
					return;
				}
				*/
				//전 port가 FROM PORT된다
				formObj.first_port_cd.value = sheetObj.CellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value = sheetObj.CellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가 third_port_cd가 된다
				formObj.third_port_cd.value = sheetObj.CellValue(currRow+1,prefix+"port_cd");
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value = portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value = sheetObj.SelectRow;
				//현재 포트와 전 포트 , 그리고 다음 포트까지 존해 하므로 A = ALL
				formObj.data_pos.value = "A";
			//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
			}else if(currPos == 1 && currPos <= rowCnt-1){
				portInfoCnt = 1;
				/*
				if(sheetObj.CellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value = "";
				//현재 로우가 To Port
				formObj.second_port_cd.value = sheetObj.CellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value = sheetObj.CellValue(currRow+1,prefix+"port_cd");
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value = portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value = sheetObj.SelectRow;
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다 T = TO
				formObj.data_pos.value = "T";
			//현재 포트가 두번째 로우 이고 전체 로우가 두개일때
			}else if(currPos == 2){
				portInfoCnt = 1;
				/*
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value = sheetObj.CellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value = sheetObj.CellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value = "";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value = portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value = sheetObj.SelectRow;
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다 F = FROM
				formObj.data_pos.value = "F";
			//현재 포트가 마지  막 로우일때	
			}else if(currPos == rowCnt){
				portInfoCnt = 1;
				/*
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value = sheetObj.CellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value = sheetObj.CellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value = "";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value = portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value = sheetObj.SelectRow;
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다E = END
				formObj.data_pos.value = "E";
			}

  		    ComOpenWait(true);
  		    
			formObj.f_cmd.value = SEARCH02;
			var loc_cd = formObj.port_cd.value;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			ComOpenWait(false);
			return sXml;
			
		break;
		
		case SEARCH03:	// Lane Code Check
			
			formObj.f_cmd.value = SEARCH03;
			
			var sParam = "f_cmd=" + formObj.f_cmd.value + 
						"&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", sParam);
			
//			var sParam = FormQueryString(formObj);
//			var vslSlanCd  = formObj.vsl_slan_cd.value;
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);

  		  	return sXml;

		break;
		
		case SEARCH04:	//Yard Code 변경시...
  		    ComOpenWait(true);
  		    
			formObj.f_cmd.value = SEARCH03;
			var sParam = "f_cmd=" + formObj.f_cmd.value + 
						"&yd_cd=" + formObj.yd_cd.value;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParam);
			
//            var sParam = FormQueryString(formObj);
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParam);
			
			ComOpenWait(false);
			
			return sXml;
		break;
		
		case SEARCH05: // Location에 따른 Yard List 조회.
  		    ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH04;
			
			var sParam = "f_cmd=" + formObj.f_cmd.value + 
						"&loc_cd=" + formObj.port_cd.value;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParam);
			
//			var loc_cd = formObj.port_cd.value;
//            var sParam = FormQueryString(formObj);
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			
			ComOpenWait(false);
			
			return sXml;
		break;
		
		case SEARCH06: // P/F Type Check
  		    ComOpenWait(true);
  		    
			formObj.f_cmd.value = SEARCH05;
			var sParam = "f_cmd=" + formObj.f_cmd.value + 
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
						"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
			
//            var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParam);
			
			ComOpenWait(false);
			
			return sXml;
			
		break;
		
		case IBSAVE:        //저장
			if(sFlag == "Settle"){
				//sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I"; 
				sheetObjects[0].RowStatus(1) = "I";
				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
				   //sheetObjects[1].CellValue(i,"sheet2_ibflag") = "I";
					sheetObjects[1].RowStatus(i) = "I";
				}
			   if(validateForm(sheetObj,formObj,"Settle")){
				   
				   var firstRow = getSearchFirstRow(sheetObjects[1]);
				   var lastRow = searchLastRow(sheetObjects[1]) - 1;

				   var firstPortDirCd = sheetObjects[1].CellValue(firstRow,"sheet2_skd_dir_cd");
				   var otherDirCdPos = 0;
				   var otherDorCdCnt = 0;
					
				   //2009 12 15 임수석 수정요청
				   //Direction이 바뀌더라도 Turning Port Indicator를 Y로 수정하지 않더라도 무방함	
				   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
					   //처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
					   if(sheetObjects[1].CellValue(i,"sheet2_skd_dir_cd") != firstPortDirCd){
						   if(sheetObjects[1].CellValue(i,"sheet2_turn_port_flg") == "Y"){
							   if(i != lastRow){
								   otherDirCdPos++;
							   }
						   }
						   otherDorCdCnt++;
					   }
				   }

					//Direction이  바뀐경우 : 양방향일때
				   if(otherDorCdCnt > 0){
					   if(otherDirCdPos < 1){
						   ComShowCodeMessage('VSK00008');
						   return;
					   }
				   //단방향일때	   
				   }

//				   if(otherDirCdPos < 1){
//					   ComShowCodeMessage('VSK00009'); 
//					   return;
//				   }
				   var prefix = "sheet1_"
				   sheetObjects[0].CellValue(1,prefix+"sim_dt") = formObj.sim_dt.value;
				   sheetObjects[0].CellValue(1,prefix+"sim_no") = formObj.sim_no.value;
				   sheetObjects[0].CellValue(1,prefix+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
				   sheetObjects[0].CellValue(1,prefix+"pf_svc_tp_cd") = formObj.pf_svc_tp_cd.value;
				   sheetObjects[0].CellValue(1,prefix+"slan_stnd_flg") = formObj.slan_stnd_flg.value;
				   sheetObjects[0].CellValue(1,prefix+"pf_skd_rmk") = formObj.pf_skd_rmk.value;
				   
				   sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd") = formObj.n1st_vsl_clss_cd.value;
				   sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
				   sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd") = formObj.n2nd_vsl_clss_cd.value;
				   sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
				   sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd") = formObj.n3rd_vsl_clss_cd.value;
				   sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;

				   if(formObj.brth_itval_dys.value == ""){
					   sheetObjects[0].CellValue(1,prefix+"brth_itval_dys") = "0";
				   }else{
					   sheetObjects[0].CellValue(1,prefix+"brth_itval_dys") = formObj.brth_itval_dys.value;
				   }

				   if(formObj.svc_dur_dys.value == ""){
					   sheetObjects[0].CellValue(1,prefix+"svc_dur_dys") = "0";
				   }else{
					   sheetObjects[0].CellValue(1,prefix+"svc_dur_dys") = formObj.svc_dur_dys.value;
				   }
				   
				   ComOpenWait(true);	
				   formObj.f_cmd.value = MULTI;
		     	   var SaveStr = ComGetSaveString(sheetObjects);
		     	   var aryPrefix = new Array("sheet1_", "sheet2_");
		     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		     	   ComOpenWait(false);
		     	   if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
		     	   
		     	   sheetObjects[1].CheckAll("sheet2_Sel") = 0;

			   }
			}else{
//				sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I"; 
//				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					if(sheetObjects[1].CellValue(i,"sheet2_ibflag") != "D"){
//						sheetObjects[1].CellValue(i,"sheet2_ibflag") = "I";
//					}
//				}
				
				sheetObjects[0].RowStatus(1) = "I"; 
				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
					if(sheetObjects[1].RowStatus(i) != "D"){
						sheetObjects[1].RowStatus(i) = "I";
					}
				}
				
				 if(validateForm(sheetObj,formObj,"Save")){
					 
					    var confirmFlg = ComShowCodeConfirm("VSK00089");
						var newSimData = "";
						if(confirmFlg == true){
							newSimData = "I";
						}else{
							newSimData = "U";
						}
					   
					   var prefix = "sheet1_"

					   sheetObjects[0].CellValue(1,prefix+"sim_dt") = formObj.sim_dt.value;
					   sheetObjects[0].CellValue(1,prefix+"sim_no") = formObj.sim_no.value;
					   sheetObjects[0].CellValue(1,prefix+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
					   sheetObjects[0].CellValue(1,prefix+"pf_svc_tp_cd") = formObj.pf_svc_tp_cd.value;
					   sheetObjects[0].CellValue(1,prefix+"slan_stnd_flg") = formObj.slan_stnd_flg.value;
					   sheetObjects[0].CellValue(1,prefix+"pf_skd_rmk") = formObj.pf_skd_rmk.value;
					   sheetObjects[0].CellValue(1,prefix+"svc_dur_dys") = formObj.svc_dur_dys.value;
					   sheetObjects[0].CellValue(1,prefix+"brth_itval_dys") = formObj.brth_itval_dys.value;

					   sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd") = formObj.n1st_vsl_clss_cd.value;
					   sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
					   sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd") = formObj.n2nd_vsl_clss_cd.value;
					   sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
					   sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd") = formObj.n3rd_vsl_clss_cd.value;
					   sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;
					   

					    
					   ComOpenWait(true);
					   formObj.f_cmd.value = MULTI02;

					   formObj.new_sim_data.value = newSimData;
			     	   var SaveStr = ComGetSaveString(sheetObjects);
			     	   var aryPrefix = new Array("sheet1_", "sheet2_");
			     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

			     	   ComOpenWait(false);

			     	  
			     	   if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
			     	   
			     	   if(ComGetEtcData(sXml, "simDt") == undefined){
			     	   }else{ 
			     		   var simDt = ComGetEtcData(sXml, "simDt");
				     	   var simNo = ComGetEtcData(sXml, "simNo");
				     	   formObj.sim_dt.value = simDt;
					       formObj.sim_no.value = simNo;
			     	   }
			     	   


			     	   sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				   }
			}
		break;
		case COMMAND01:
			if(validateForm(sheetObj,formObj,"simul")){
			   //sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U"; 
				sheetObjects[0].RowStatus(1) = "U";
			   var currPos = 0;
			   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
				   //if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "I" || sheetObjects[1].CellValue(i,"sheet2_ibflag") == "U"){
				   if(sheetObjects[1].RowStatus(i) == "I" || sheetObjects[1].RowStatus(i) == "U"){
					   currPos = i;
				   }
			   }
			   
			   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//				   if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//					   sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//				   }
				   if(sheetObjects[1].RowStatus(i) == "R"){
					   sheetObjects[1].RowStatus(i) = "U";
				   }
			   }

			   formObj.currPos.value = currPos-1;
			   
	  		   ComOpenWait(true);
	  		   
			   formObj.f_cmd.value = COMMAND01;
	     	   var SaveStr = ComGetSaveString(sheetObjects);
	     	   var aryPrefix = new Array("sheet1_", "sheet2_");

	     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   var checkArrXml = sXml.split("|$$|");
	     	   var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	     	   xmlDoc.loadXML(checkArrXml[0]);
			   var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

			   if(dataNode){
					var totValue = dataNode.value;

					if(totValue > 0){
						 var arrXml = sXml.split("|$$|");
				     	   submitFlg = "Y";
				     	   for(var inx=0; inx<arrXml.length; inx++){
								simulShowSheetData(sheetObjects[inx],formObj,arrXml[inx],"Y");
							}
							//viewDetailData(sheetObjects[1],formObj);
							gridEndJob(sheetObjects[1],formObj);
							var rowPos = sheetObjects[1].HeaderRows + sheetObjects[1].RowCount;
							setlastLowView(sheetObjects[1],rowPos);

							// 정상적으로 수행되었으므로 Save, Settlement 버튼을 풀어준다.
							setEditMode(false);
					}
			   }else{
				   if(sXml.length>0) sheetObj.LoadSearchXml(sXml);						
				}
			   ComOpenWait(false);
			}
		break;
		
		case REMOVE:
			if(validateForm(sheetObj,formObj,"Remove")){
			   
			    //sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U"; 
				sheetObjects[0].RowStatus(1) = "U";
				
			    for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//				    if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//					    sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//				    }
			    	if(sheetObjects[1].RowStatus(i) == "R"){
					    sheetObjects[1].RowStatus(i) = "U";
				    }
			    } 
			  
			    formObj.f_cmd.value = REMOVE;
	     	    var SaveStr = ComGetSaveString(sheetObjects);
	     	    var aryPrefix = new Array("sheet1_", "sheet2_");
	     	    var sXml = sheetObj.GetSaveXml("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   
	     	    var arrXml = sXml.split("|$$|");
	     	    
	     	    if(arrXml.length > 1){
		     	    for(var inx=0; inx<arrXml.length; inx++){
					 	rowDelshowSheetData(sheetObjects[inx],formObj,arrXml[inx]);
				    }
		     	   	
		     	    var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
				    setlastLowView(sheetObjects[1],lastPos);
	     	    }
	     	   	
	     	    sheetObjects[1].CheckAll("sheet2_Sel") = 0;
	     	    
	     	    setEditMode(true);

			}
			break;
			
		
    }
}

/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function searchShowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);

			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;
				
				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					if(Pos != "Y"){
						formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					}
					formObj.slan_stnd_flg.value = sheetObj.CellValue(1,prefix+"slan_stnd_flg");
					
					var n1stKnt = parseInt(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt"));
					var n2ndKnt = parseInt(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt"));
					var n3rdKnt = parseInt(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt"));
					
					if(Pos != "Y"){
						var tempPfCd = "";
						tempMaxVslClsCnt = Math.max(n1stKnt,n2ndKnt,n3rdKnt);
	
						//2008 08 07
						//임창빈 수석 Vsl Class의 최대 갯수의  클래스를 PF_TYPE_CD에 셋팅한다
						if(tempMaxVslClsCnt == n1stKnt){
							tempPfCd = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
						}else if(tempMaxVslClsCnt == n2ndKnt){
							tempPfCd = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
						}else{
							tempPfCd = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
						}
						formObj.pf_svc_tp_cd.value = tempPfCd;
					}
					
					formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					
					formObj.svc_dur_dys.value = sheetObj.CellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value = sheetObj.CellValue(1,prefix+"brth_itval_dys");
					formObj.pf_skd_rmk.value = sheetObj.CellValue(1,prefix+"pf_skd_rmk");
					
					// MDM에서 조회한 Direction으로 콤보를 초기화한다.
					// 쿼리에 의해 MDM에 존재하지 않는 Lane일 경우 W,E,N,S 네 방향이 모두 나온다.
					var mdmSkdDirCd = ComGetEtcData(sXml, "mdm_skd_dir_cd");
					sheetObjects[1].InitDataCombo(0, "sheet2_skd_dir_cd", mdmSkdDirCd, mdmSkdDirCd);
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					
					//[25|21.8|18.4|2.5|3.1|0|99.2|92.1|22]
					var etcdts = ComGetEtcData(sXml, "etcdt").split("|");
					formObj.max_spd.value = etcdts[0]+" Kts";
					//formObj.avg_spd.value = etcdts[1]+" Kts";
					//formObj.buf_spd.value = etcdts[2]+" Kts";
					
					formObj.tot_buf_rat.value = etcdts[3]+" %";
					formObj.sea_buf_rat.value = etcdts[4]+" %";
					formObj.port_buf_rat.value = etcdts[5]+" %";
					formObj.pf_spd_rat.value = etcdts[6]+" %";
					formObj.buf_spd_rat.value = etcdts[7]+" %";
					formObj.min_max_spd.value = etcdts[8];
					
					var coadt = ComGetEtcData(sXml, "coadt").split("|");
					formObj.lf.value = coadt[0];
					formObj.rpb.value = coadt[1];
					formObj.rev.value = coadt[2];
					formObj.op.value = coadt[3];
					
					
					if(Pos == "Y"){
						formObj.currPos.value = ComGetEtcData(sXml, "currPos");
					}
					
					//2009 11 27 PF_TYPE_CD CHECK LIM 요청
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
					var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
					g_pfTypeData = pfTypeData;
					/*if(pfTypeData[0] == "Y"){
						ComShowCodeMessage("VSK00091");
						formObj.pf_svc_tp_cd.select();
						return;
					}else if(pfTypeData[1] == "Y"){
						ComShowCodeMessage("VSK00092");
						formObj.pf_svc_tp_cd.select();
						return;
					}*/
					
				}else{
					clearAllData(sheetObjects[0],sheetObjects[1],formObj)
					formObj.sim_dt.focus();
				}
			}

		break;
		
		case "sheet2":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			initPortDataFlg(sheetObj);
			
			if(sheetObj.RowCount > 0){
				
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				
				//viewDetailData(sheetObjects[1],formObj);
				
				var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
				var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
				sheetObj.CellEditable(3, "sheet2_mnvr_in_hrs") = false;
				sheetObj.CellFontColor(3,prefix+"mnvr_in_hrs") = grayColor;
				
				sheetObj.CellEditable(sheetObj.RowCount+2, "sheet2_mnvr_in_hrs") = true;
				sheetObj.CellBackColor(sheetObj.RowCount+2, "sheet2_mnvr_in_hrs") = withrColor;

	
//				for(var k=4; k<=sheetObj.RowCount+2; k++){
//					sheetObj.CellEditable(k, "sheet2_etb_dy_no") = false;
//					sheetObj.CellEditable(k, "sheet2_etb_dy_cd") = false;
//					sheetObj.CellEditable(k, "sheet2_etb_tm_hrmnt") = false;
//	       	 	}
	
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					sheetObj.CellEditable(k, "sheet2_etd_dy_no") = false;
					sheetObj.CellEditable(k, "sheet2_etd_dy_cd") = false;
					sheetObj.CellEditable(k, "sheet2_etd_tm_hrmnt") = false;
					sheetObj.CellEditable(k, "sheet2_tztm_hrs") = false;	
					sheetObj.CellEditable(k, "sheet2_sea_buf_spd") = false;
					sheetObj.CellEditable(k, "sheet2_port_cd") = true;	
					sheetObj.CellEditable(k, "sheet2_tml_prod_qty") = true;
					sheetObj.CellEditable(k, "sheet2_crn_knt") = false;
	       	 	}
				
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					if(sheetObj.CellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.CellValue(k, "sheet2_crane_wk_tm") != ""){
						var redColor = sheetObj.RgbColor(eval("255"),eval("128"),eval("0"));
						sheetObj.CellBackColor(k,"sheet2_port_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_no") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_tm_hrmnt") = redColor;
					}
	       	 	}
				
				
//				for(var i=0; i<sheetObj.RowCount; i++){
//					sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
//					sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
////		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
//					sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
//				}
				
				sheetObj.Redraw = true;
				if(Pos == "Y"){
					var posTemp = Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
			}
			
		break;
		
	}

}

/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function simulShowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix = sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);

			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;
				
				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					if(Pos != "Y"){
						formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					}
					formObj.slan_stnd_flg.value = sheetObj.CellValue(1,prefix+"slan_stnd_flg");
					
					var n1stKnt = parseInt(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt"));
					var n2ndKnt = parseInt(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt"));
					var n3rdKnt = parseInt(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt"));
					
					if(Pos != "Y"){
						var tempPfCd = "";
						tempMaxVslClsCnt = Math.max(n1stKnt,n2ndKnt,n3rdKnt);
	
						//2008 08 07
						//임창빈 수석 Vsl Class의 최대 갯수의  클래스를 PF_TYPE_CD에 셋팅한다
						if(tempMaxVslClsCnt == n1stKnt){
							tempPfCd = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
						}else if(tempMaxVslClsCnt == n2ndKnt){
							tempPfCd = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
						}else{
							tempPfCd = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
						}
						formObj.pf_svc_tp_cd.value = tempPfCd;
					}
					
					formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					
					formObj.svc_dur_dys.value = sheetObj.CellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value = sheetObj.CellValue(1,prefix+"brth_itval_dys");
					formObj.pf_skd_rmk.value = sheetObj.CellValue(1,prefix+"pf_skd_rmk");
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					
					//[25|21.8|18.4|2.5|3.1|0|99.2|92.1|22]
					var etcdts = ComGetEtcData(sXml, "etcdt").split("|");
					formObj.max_spd.value = etcdts[0]+" Kts";
					//formObj.avg_spd.value = etcdts[1]+" Kts";
					//formObj.buf_spd.value = etcdts[2]+" Kts";
					
					formObj.tot_buf_rat.value = etcdts[3]+" %";
					formObj.sea_buf_rat.value = etcdts[4]+" %";
					formObj.port_buf_rat.value = etcdts[5]+" %";
					formObj.pf_spd_rat.value = etcdts[6]+" %";
					formObj.buf_spd_rat.value = etcdts[7]+" %";
					formObj.min_max_spd.value = etcdts[8];
					
					
					if(Pos == "Y"){
						formObj.currPos.value = ComGetEtcData(sXml, "currPos");
					}
					
					//2009 11 27 PF_TYPE_CD CHECK LIM 요청
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
					var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
					g_pfTypeData = pfTypeData;
					/*if(pfTypeData[0] == "Y"){
						ComShowCodeMessage("VSK00091");
						formObj.pf_svc_tp_cd.select();
						return;
					}else if(pfTypeData[1] == "Y"){
						ComShowCodeMessage("VSK00092");
						formObj.pf_svc_tp_cd.select();
						return;
					}*/
					
				}else{
					clearAllData(sheetObjects[0],sheetObjects[1],formObj)
					formObj.sim_dt.focus();
				}
			}

		break;
		
		case "sheet2":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			initPortDataFlg(sheetObj);
			
			if(sheetObj.RowCount > 0){
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				
				//viewDetailData(sheetObjects[1],formObj);
				
				var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
				var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
				sheetObj.CellEditable(3, "sheet2_mnvr_in_hrs") = false;
				sheetObj.CellFontColor(3,prefix+"mnvr_in_hrs") = grayColor;
				
				sheetObj.CellEditable(sheetObj.RowCount+2, "sheet2_mnvr_in_hrs") = true;
				sheetObj.CellBackColor(sheetObj.RowCount+2, "sheet2_mnvr_in_hrs") = withrColor;

	
				for(var k=4; k<=sheetObj.RowCount+2; k++){
					sheetObj.CellEditable(k, "sheet2_etb_dy_no") = false;
					sheetObj.CellEditable(k, "sheet2_etb_dy_cd") = false;
					sheetObj.CellEditable(k, "sheet2_etb_tm_hrmnt") = false;
	       	 	}
	
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					sheetObj.CellEditable(k, "sheet2_etd_dy_no") = false;
					sheetObj.CellEditable(k, "sheet2_etd_dy_cd") = false;
					sheetObj.CellEditable(k, "sheet2_etd_tm_hrmnt") = false;
					sheetObj.CellEditable(k, "sheet2_tztm_hrs") = false;	
					sheetObj.CellEditable(k, "sheet2_sea_buf_spd") = false;
					sheetObj.CellEditable(k, "sheet2_port_cd") = true;	
					sheetObj.CellEditable(k, "sheet2_tml_prod_qty") = true;
					sheetObj.CellEditable(k, "sheet2_crn_knt") = false;
	       	 	}
				
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					if(sheetObj.CellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.CellValue(k, "sheet2_crane_wk_tm") != ""){
						var redColor = sheetObj.RgbColor(eval("255"),eval("128"),eval("0"));
						sheetObj.CellBackColor(k,"sheet2_port_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_no") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_tm_hrmnt") = redColor;
					}
	       	 	}
				
				
				for(var i=0; i<sheetObj.RowCount; i++){
					//sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
					sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
					sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
				}
				
				sheetObj.Redraw = true;
				if(Pos == "Y"){
					var posTemp = Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
			}
			
		break;
	}

}


/**
 * Row Delete 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function rowDelshowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet1":
			var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
			if(ydCds != null && ydCds != undefined && ydCds != ""){
				for(var i=0 ; i < ydCds.length ; i++ ){
					ydCdsArr[i] = ydCds[i];
				}
			}
		break;
		
		case "sheet2":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);

			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

			if(dataNode){
				var totValue = dataNode.value;

				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					initPortDataFlg(sheetObj);
					if(sheetObj.RowCount > 0){

						var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows - 1;
						var whiteColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
						var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
						sheetObj.CellEditable(3, prefix+"mnvr_in_hrs") = false;
						sheetObj.CellFontColor(3,prefix+"mnvr_in_hrs") = grayColor;
						
						sheetObj.CellEditable(lastPos, prefix+"mnvr_in_hrs") = true;
						sheetObj.CellBackColor(lastPos, prefix+"mnvr_in_hrs") = whiteColor;
						
						for(var k=4; k<=sheetObj.RowCount+2; k++){
							sheetObj.CellEditable(k, "sheet2_etb_dy_no") = false;
							sheetObj.CellEditable(k, "sheet2_etb_dy_cd") = false;
							sheetObj.CellEditable(k, "sheet2_etb_tm_hrmnt") = false;
			       	 	}
			
						for(var k=3; k<=sheetObj.RowCount+2; k++){
							sheetObj.CellEditable(k, "sheet2_etd_dy_no") = false;
							sheetObj.CellEditable(k, "sheet2_etd_dy_cd") = false;
							sheetObj.CellEditable(k, "sheet2_etd_tm_hrmnt") = false;
							sheetObj.CellEditable(k, "sheet2_tztm_hrs") = false;
							sheetObj.CellEditable(k, "sheet2_sea_buf_spd") = false;
							sheetObj.CellEditable(k, "sheet2_port_cd") = true;	
							sheetObj.CellEditable(k, "sheet2_tml_prod_qty") = true;
							sheetObj.CellEditable(k, "sheet2_crn_knt") = false;	
			       	 	}
						
						for(var k=3; k<=sheetObj.RowCount+2; k++){
							if(sheetObj.CellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.CellValue(k, "sheet2_crane_wk_tm") != ""){
								var redColor = sheetObj.RgbColor(eval("255"),eval("128"),eval("0"));
								sheetObj.CellBackColor(k,"sheet2_port_cd") = redColor;
								sheetObj.CellBackColor(k,"sheet2_etb_dy_no") = redColor;
								sheetObj.CellBackColor(k,"sheet2_etb_dy_cd") = redColor;
								sheetObj.CellBackColor(k,"sheet2_etb_tm_hrmnt") = redColor;
							}
			       	 	}
						
						resetRowSeq(sheetObj);
						
						for(var i=0; i<sheetObj.RowCount; i++){
							sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") = ydCdsArr[i];
							sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//				    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
							sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
						}
						
						sheetObj.Redraw = true;
					}
				}
			}

			
			
		break;
	}
}

/**
 * P/F Type 설정위한 초기 데이타 셋팅.
 * @param sheetObj
 * @return
 */
function initPortDataFlg(sheetObj){ 
	var rows = sheetObj.Rows;

	for(var i=3; i<rows; i++){
		portDataFlgs[i-3] = "N";
	}
}

/**
 * SHEET2 그리드를 Click 이벤트
 */

function sheet2_OnClick(sheetObject, Row, Col) {
	var formObj = document.form;
	var sXml = null;
	var prefix = sheetObject.id + "_";
	var colSaveName = sheetObject.ColSaveName(Col);
	
	if(Row > 1 && Col > 0){
		
		switch(colSaveName){
			case prefix + "yd_cd":
				formObj.port_cd.value = sheetObject.CellValue(Row, prefix + "port_cd");	
				var tempPortCd = formObj.port_cd.value;

				if(tempPortCd.length == 5){
					
					// 이미 combo가 조회되어 yd_cd가 2개 이상이면 재조회 하지 않는다.
					var ydCdArr = sheetObject.GetComboInfo(Row, prefix + "yd_cd", "Code");
					if(ydCdArr.split("|").length == 1){
						sXml = doActionIBSheet(sheetObject, formObj, SEARCH05);
						if(sXml != null && sXml != undefined && sXml != ""){
							setSheetComboSinc(sXml, sheetObject, Row, Col);
						}
					}
				}
				break;
			
			case prefix + "port_cd":
				sheetObject.SelectCell(Row, Col);
				break;
		}
	}
}


function sheet2_OnComboChange(sheetObj,Row, Col, Code, Text){
	var formObj = document.form;
	var prefix = "sheet2_";
//	var tempYdCd = sheetObj.CellValue(Row,Col);
	var portCd = sheetObj.CellValue(Row,Col-1);
	var ydCd = "";
	
	if(portCd != ""){
		if(Col == 5){
//			formObj.yd_cd.value = portCd+tempYdCd;	
			var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
			var mnvrInHrs = ComGetEtcData(sXml, "mnvr_in_hrs");
			var mnvrOutHrs = ComGetEtcData(sXml, "mnvr_out_hrs");
			
			sheetObj.CellValue(Row,prefix+"mnvr_in_hrs") = mnvrInHrs;
			sheetObj.CellValue(Row,prefix+"mnvr_out_hrs") = mnvrOutHrs;
		}
	}
}
/**
 * SHEET2 그리드 데이타 change 이벤트
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var prefix = sheetObj.id + "_";
	var cnt = sheetObj.RowCount + sheetObj.HeaderRows;
	var formObj = document.form;
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	
	//7월10일 cargo/tmnl 칼럼값 변경시 계산 
	if(Col=="10" || Col =="11"){
		var temp1 = parseInt(sheetObj.CellValue(Row,10));
		var temp2 = parseInt(sheetObj.CellValue(Row,11));
		var temp3 = temp1/temp2;
		if(temp3=="Infinity"){
			sheetObj.CellValue(Row,12)=0;
		}else{
			sheetObj.CellValue(Row,12)=temp3;
		}
		
	}

	
	
	if(Row > 2){
		if(Col == 3){
			for(var i=Row; i<cnt; i++){
				sheetObj.CellValue2(i,prefix+"skd_dir_cd") = Value;
				
			}
		}else if(Col == 4){
			var headCnt = sheetObj.HeaderRows;
			var rowCnt = sheetObj.RowCount;
			var totalCnt = headCnt+rowCnt;
			var currPos = (sheetObj.SelectRow - headCnt)+1;
			var currRow = sheetObj.SelectRow;
			
			var tempVal = sheetObj.EditValue;
			
			if(currPos == 1 && currPos == rowCnt){
				if(tempVal.length == 0){
					return;
				}
			}/*
			else if(currPos > 1 && currPos <= rowCnt-1){
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}else if(sheetObj.CellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00071");
					sheetObj.SelectCell(currRow+1,Col);
					return;
				}
			}else if(currPos == 1 && currPos <= rowCnt-1){
				if(sheetObj.CellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00071");
					sheetObj.SelectCell(currRow+1,Col);
					return;
				}
			}else if(currPos == 2){
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}
			}else if(currPos == rowCnt){
				if(sheetObj.CellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}
			}
			*/

			if(tempVal.length == 5){
				formObj.port_cd.value = tempVal;		
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
			
				var chkPort = ComGetEtcData(sXml, "check_port");
				
				if(chkPort == "X"){
					if(sXml != null && sXml != undefined && sXml != ""){
						var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
						xmlDoc.loadXML(sXml);
	
						var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue = dataNode.value;
	
//							if(totValue > 0){
//								setSheetComboSinc(sXml, sheetObj, Row, Col);
//							}else{
//								setSheetClearCombo(sheetObj, Row, Col);
//								sheetObj.CellValue2(Row, sheetObj.id+"_yd_cd") = "";
//							}
						}
					}
					
					var portInfoCnt = Number(ComGetEtcData(sXml, "portInfoCnt"));
					var currPos = Number(ComGetEtcData(sXml, "currPos"));
					var dataPos = ComGetEtcData(sXml, "dataPos");
					var oneDataPos = 0;
					var twoFromDataPos = 0;
					var twoToDataPos = 0;
					
					//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
					if(dataPos == "S"){
						oneDataPos = currPos;
					//전 포트가 존재 하기때문에 자기 자신의 전 포트에 데이타를 출력한다 F = FROM
					}else if(dataPos == "F"){
						oneDataPos = currPos - 1;
					//현재 포트와 전 포트 , 그리고 다음 포트까지 존해 하므로 A = ALL	
					}else if(dataPos == "A"){
						twoFromDataPos = currPos -1;
						twoToDataPos = currPos + 1;
					//현재포트와 다음 포트 존재 T = TO	
					}else if(dataPos == "T"){
						oneDataPos = currPos;
					//현재 포트가 마지막 로우일때 E = END	
					}else if(dataPos == "E"){
						oneDataPos = currPos-1;
					}
					
					//현재 포트나  현재포트와 전포트, 현재포트와 후 포트를 조회시
					if(portInfoCnt == 1){
						
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						//전 포트의 LNK_DIST,FM_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY 값을 채운다
						//현재 포트의 TO_ZD를 채운다
						var dataVal = ComGetEtcData(sXml, "one_row");
						var dataValArr = dataVal.split("|");
						
						//현재 포트가 첫번째이면서 전체 로우가 하나일때
						if(dataPos == "S"){
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") = dataValArr[0];
//							sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[2];
//							sheetObj.CellValue(oneDataPos,prefix+"port_buf_hrs") = dataValArr[3];
//							alert(sheetObj.CellValue('1--'+currPos,prefix+"port_buf_hrs"));

							//sheetObj.CellValue(oneDataPos,prefix+"crn_knt") = dataValArr[4];
							//sheetObj.CellValue(oneDataPos,prefix+"tml_prod_qty") = dataValArr[5];
						//현재 포트가 두번째 로우 이고 전체 로우가 두개일때	
						}else if(dataPos == "F"){
							//현재 포트의 전 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") = dataValArr[0];
							//sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[1];
							
							//현재 포트
							//sheetObj.CellValue(oneDataPos+1,prefix+"port_buf_hrs") = dataValArr[3];
							//sheetObj.CellValue(oneDataPos+1,prefix+"crn_knt") = dataValArr[4];
							//sheetObj.CellValue(oneDataPos+1,prefix+"tml_prod_qty") = dataValArr[5];
							//sheetObj.CellValue(oneDataPos+1,prefix+"zd") = dataValArr[2];
						//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
						}else if(dataPos == "T"){
							//현재 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") = dataValArr[0];
//							sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[1];
//							sheetObj.CellValue(oneDataPos,prefix+"port_buf_hrs") = dataValArr[3];
//							sheetObj.CellValue(oneDataPos,prefix+"crn_knt") = dataValArr[4];
							//sheetObj.CellValue(oneDataPos,prefix+"tml_prod_qty") = dataValArr[5];
							//다음 포트
//							sheetObj.CellValue(oneDataPos+1,prefix+"zd") = dataValArr[2];
						//현재 포트가 마지  막 로우일때		
						}else if(dataPos == "E"){
							//전 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") = dataValArr[0];
//							sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[1];
							//현재 포트
//							sheetObj.CellValue(oneDataPos+1,prefix+"port_buf_hrs") = dataValArr[3];
//							sheetObj.CellValue(oneDataPos+1,prefix+"crn_knt") = dataValArr[4];
							//sheetObj.CellValue(oneDataPos+1,prefix+"tml_prod_qty") = dataValArr[5];
//							sheetObj.CellValue(oneDataPos+1,prefix+"zd") = dataValArr[2];
						}
						
					//현재 포트와 전,후 포트 모두 조회시
					}else{
						var oneDataVal = ComGetEtcData(sXml, "one_row");
						var twoDataVal = ComGetEtcData(sXml, "two_row");
						var oneDataValArr = oneDataVal.split("|");
						var twoDataValArr = twoDataVal.split("|");
						
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						sheetObj.CellValue(twoFromDataPos,prefix+"lnk_dist") = oneDataValArr[0];
//						sheetObj.CellValue(twoFromDataPos,prefix+"zd") = oneDataValArr[1];
						
//						sheetObj.CellValue(currPos,prefix+"port_buf_hrs") = oneDataValArr[3];
//						alert(sheetObj.CellValue('1--'+currPos,prefix+"port_buf_hrs"));
//						sheetObj.CellValue(currPos,prefix+"crn_knt") = oneDataValArr[4];
//						sheetObj.CellValue(currPos,prefix+"tml_prod_qty") = oneDataValArr[5];
						sheetObj.CellValue(currPos,prefix+"lnk_dist") = twoDataValArr[0];
//						sheetObj.CellValue(currPos,prefix+"zd") = oneDataValArr[2];
						
						//sheetObj.CellValue(twoToDataPos,prefix+"port_buf_hrs") = twoDataValArr[3];
//						sheetObj.CellValue(twoToDataPos,prefix+"crn_knt") = twoDataValArr[4];
						//sheetObj.CellValue(twoToDataPos,prefix+"tml_prod_qty") = twoDataValArr[5];
//						sheetObj.CellValue(twoToDataPos,prefix+"zd") = twoDataValArr[2];
						
					}
				}else{
					ComShowCodeMessage('VSK00029', Value);
					//sheetObj.CellValue(Row,"sheet2_port_cd") = "";
					//sheetObj.CellValue(Row,"sheet2_yd_cd") = "";
					sheetObj.CellValue2(Row, prefix+"yd_cd") = "";
					sheetObj.CellValue2(Row, prefix+"zd") = "";
					sheetObj.CellValue2(Row, prefix+"port_cd") = "";
					sheetObj.SelectCell(Row, Col, true);
					
					sheetObj.CellBackColor(Row, prefix+"port_cd") = sheetObj.RgbColor(0, 0, 0);
					sheetObj.CellBackColor(Row, prefix+"etb_dy_no") = sheetObj.RgbColor(0, 0, 0);
					sheetObj.CellBackColor(Row, prefix+"etb_dy_cd") = sheetObj.RgbColor(0, 0, 0);
					sheetObj.CellBackColor(Row, prefix+"etb_tm_hrmnt") = sheetObj.RgbColor(0, 0, 0);
				}
				
			}else{ // port_cd가 5자리가 아닌 경우
				
				if(tempVal.length!=""){ // port_cd의 값이 1자리이상 5자리 미만인 경우
					ComShowCodeMessage('VSK00029', tempVal);
				}
				
				sheetObj.CellValue2(Row, prefix+"yd_cd") ="";
				sheetObj.CellValue2(Row,"sheet2_zd") = "";
				sheetObj.CellValue2(Row,"sheet2_etb_dy_no") = "";
				sheetObj.CellValue2(Row,"sheet2_etb_dy_cd") = "";
				sheetObj.CellValue2(Row,"sheet2_etb_tm_hrmnt") = "";
				
				sheetObj.CellBackColor(Row, prefix+"port_cd") = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellBackColor(Row, prefix+"etb_dy_no") = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellBackColor(Row, prefix+"etb_dy_cd") = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellBackColor(Row, prefix+"etb_tm_hrmnt") = sheetObj.RgbColor(0, 0, 0);
				sheetObj.SelectCell(Row, prefix+"port_cd", true);
				
			}
		}/*
		else if(Col == 5){
			
			var tempYdCd = sheetObj.CellValue(Row,Col);
			var portCd = sheetObj.CellValue(Row,Col-1);
			var ydCd = "";

			if(submitFlg != "Y"){
				if(tempYdCd != "" && portCd != ""){
					formObj.yd_cd.value = portCd+tempYdCd;					
					var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
					var mnvrInHrs = ComGetEtcData(sXml, "mnvr_in_hrs");
					var mnvrOutHrs = ComGetEtcData(sXml, "mnvr_out_hrs");
					
					sheetObj.CellValue(Row,prefix+"mnvr_in_hrs") = mnvrInHrs;
					sheetObj.CellValue(Row,prefix+"mnvr_out_hrs") = mnvrOutHrs;
					
				}
			}
		}*/
		else if(Col == 13){
			var tempEtbDyNo = parseInt(sheetObj.CellValue(Row, Col));

			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				ComShowCodeMessage('VSK00041');
				sheetObj.CellValue(Row, Col) = 0;
				sheetObj.SelectCell(Row, Col, true);
			}
		}else if(Col == 15){
			var tempEtbTmHrmnt = parseInt(sheetObj.CellValue(Row, Col));
			
			if(tempEtbTmHrmnt != 0){
				sheetObj.SelectCell(Row, 16, true);
			}
		}
//		}else if(Col == 28){
//			var tempPortFlg = sheetObj.CellValue(Row, Col);
//			sheetObj.CellValue(Row, Col+1) = tempPortFlg;
//		}
	}
}
/*
function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
	var prefix = sheetObj.id + "_";
	var cnt = sheetObj.RowCount + sheetObj.HeaderRows;
	var formObj = document.form;
	
	if(Row > 2){
		if(Col == 4){
			var tempVal = sheetObj.EditValue;
			
			if(tempVal.length == 5){

				formObj.port_cd.value = tempVal;
				doActionIBSheet(sheetObj, formObj, SEARCH04);
				
				portDataFlgs[Row] = "N";
				sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");	//Terminal Combo 초기화.

				if(formObj.port_name.value == "" || formObj.port_name.value == "undefined"){
					ComShowCodeMessage('VSK00029', formObj.port_cd.value);
					sheetObj.CellValue(Row, Col) = "";
					sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
					sheetObj.SelectCell(Row, Col, true);
				}else{
					sheetObj.SelectCell(Row, Col+1, true);
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);

					if(sXml != null && sXml != undefined && sXml != ""){

						var xmlEtcData = ComGetEtcData(sXml, "yd_kind");

						if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
							sheetObj.CellComboItem(Row, sheetObj.id+"_yd_cd", xmlEtcData, xmlEtcData);
							sheetObj.CellValue(Row,sheetObj.id+"_zd") = formObj.zd.value;
						}
					}
				}
				portDataFlgs[Row] = "Y";
				
			}
		}
	}
}
*/

/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObj, Row, Col){
	var ydKindCode = ComGetEtcData(xmlStr, "yd_kind");
	var ydNm = ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt = "";
	
	
	if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
		var ydKindCodeArr = ydKindCode.split("|");
		var ydNmArr = ydNm.split("|");
		var ydCnt = ydKindCodeArr.length;
		
		ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		sheetObj.CellComboItem(Row, sheetObj.id+"_yd_cd", ydTxt, ydKindCode);
	}
}

/**
 * Sheet의 Terminal Combo Data Clear...
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function setSheetClearCombo(sheetObj, Row, Col){
	sheetObj.CellComboItem(Row, sheetObj.id+"_yd_cd", "", "");
}

/**
 * Calling Port ,Distance (P/S ~ P/S) 데이타 출력
 */
/* 
function viewDetailData(sheetObj,formObj){
	var cnt = sheetObj.RowCount;
	var prefix = "sheet2_";
	//Calling Port
	var callingPortCnt = cnt-1;
	
	formObj.clpt_knt.value = callingPortCnt+" ports";
	
	//Distance
	var disSum = 0;
	//var spdArr = new Array();
	for(var i=3; i<=cnt+2; i++){
		disSum += parseInt(sheetObj.CellValue(i,prefix+"lnk_dist"));
	}
	disSum = ComGetMaskedValue(disSum+"","int","");
	formObj.ttl_dist.value = disSum+" Miles";	
}
*/
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

	case IBSEARCH:      //조회
		
		if(ComIsNull(formObj.sim_dt.value)){
			ComShowCodeMessage('VSK00027', "Simulation date");
			formObj.sim_dt.focus();
			return false;
		}
		
		if(ComIsNull(formObj.sim_no.value)){
			ComShowCodeMessage('VSK00027', "Simulation No.");
			formObj.sim_no.focus();
			return false;
		}
		
		if(formObj.sim_dt.value.length < 8){
			ComShowCodeMessage("VSK01018", "Simulation No.");
			formObj.sim_dt.focus();
			return false;
		}
		break;

	case "Settle":     
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		
		if(ComIsNull(formObj.sim_dt.value)){
			ComShowCodeMessage('VSK00027', "Simulation date");
			formObj.sim_dt.focus();
			return false;
		}
		
		if(ComIsNull(formObj.sim_no.value)){
			ComShowCodeMessage('VSK00027', "Simulation No.");
			formObj.sim_no.focus();
			return false;
		}
		
		if(formObj.sim_dt.value.length < 8){
			ComShowCodeMessage("VSK01018", "Simulation No.");
			formObj.sim_dt.focus();
			return false;
		}

		if(ComIsNull(formObj.vsl_slan_cd.value)){
			ComShowCodeMessage('VSK00027', "Lane Code");
			formObj.vsl_slan_cd.focus();
			return false;
		} 
		
		if (ComIsNull(formObj.pf_svc_tp_cd.value)) {
			ComShowCodeMessage("VSK00027", "P/F SKD Type");
			formObj.pf_svc_tp_cd.focus();
			return false;
		} 
		if(sheetObjects[1].RowCount < 2){
			ComShowCodeMessage("VSK00043");
			formObj.vsl_slan_cd.focus();
			return false;
		}
		
		
		
		
		
		var n1stVslClssCd = formObj.n1st_vsl_clss_cd;
		var n2stVslClssCd = formObj.n2nd_vsl_clss_cd;
		var n3stVslClssCd = formObj.n3rd_vsl_clss_cd;
		var n1stVslClssKnt = formObj.n1st_vsl_clss_knt;
		var n2stVslClssKnt = formObj.n2nd_vsl_clss_knt;
		var n3stVslClssKnt = formObj.n3rd_vsl_clss_knt;
//		var	comVslClss = 0;
		
		if(VskIsNull(n1stVslClssCd.value) || VskIsNull(n1stVslClssKnt.value)){
			n1stVslClssCd.focus();
			ComShowCodeMessage('VSK00027', "Vessel Class - 1");
			return false;
		}
		
		if(ComIsNull(n2stVslClssCd.value) && (n2stVslClssKnt.value > 0)) {
			n2stVslClssCd.focus();
			ComShowCodeMessage('VSK00027', "Vessel Class - 2");
			return false;
		}
		
		if (VskIsNotNull(n2stVslClssCd.value) && VskIsNullZero(n2stVslClssKnt.value)) {
			n2stVslClssKnt.focus();
			ComShowCodeMessage('VSK00027', "Vessel Count - 2");
			return false;
		}
		
		if(ComIsNull(n3stVslClssCd.value) && (n3stVslClssKnt.value > 0)) {
			n3stVslClssCd.focus();
			ComShowCodeMessage('VSK00027', "Vessel Class - 3");
			return false;
		}
		
		if(VskIsNotNull(n3stVslClssCd.value) && VskIsNullZero(n3stVslClssKnt.value)) {
			n3stVslClssKnt.focus();
			ComShowCodeMessage('VSK00027', "Vessel Count - 3");
			return false;
		}
		
		if(VskIsNotNull(n1stVslClssCd.value) && VskIsNotNull(n2stVslClssCd.value)){
			if (n1stVslClssCd.value == n2stVslClssCd.value) {
				n2stVslClssCd.focus();
				ComShowCodeMessage('VSK00099', n2stVslClssCd.value);
				return false;
			};
		}

		if(VskIsNotNull(n1stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)){
			if (n1stVslClssCd.value == n3stVslClssCd.value) {
				n3stVslClssCd.focus();
				ComShowCodeMessage('VSK00099', n3stVslClssCd.value);
				return false;
			}
		}
		
		if(VskIsNotNull(n2stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)){
			if (n2stVslClssCd.value == n3stVslClssCd.value) {
				n3stVslClssCd.focus();
				ComShowCodeMessage('VSK00099', n3stVslClssCd.value);
				return false;
			}
		}
		
		if (VskIsNull(n2stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)) {
			n2stVslClssCd.value = n3stVslClssCd.value;
			n2stVslClssKnt.value	= n3stVslClssKnt.value;
			n3stVslClssCd.value = "";
			n3stVslClssKnt.value ="";
		}
		
		if(VskIsNullZero(formObj.svc_dur_dys.value)) {
			formObj.svc_dur_dys.focus();
			ComShowCodeMessage('VSK01017', "Duration");	//'({?msg1}) field is missing. Please check again!'
			return false;
		}			
		
		if(VskIsNullZero(formObj.brth_itval_dys.value)) {
			formObj.brth_itval_dys.focus();
			ComShowCodeMessage('VSK01017', "Frequency");	//'({?msg1}) field is missing. Please check again!'
			return false;
		}

		if(totCnt > headCnt){
			for(var i=headCnt; i<=totCnt; i++){
				
				if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
					ComShowCodeMessage("VSK01018", "Port Code");
					sheetObj.SelectCell(i,"sheet2_port_cd");
					return false;
				}

				if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
					ComShowCodeMessage("VSK01018", "Terminal Code");
					sheetObj.SelectCell(i,"sheet2_yd_cd");
					return false;
				}
				
				if(sheetObj.CellValue(i, prefix+"turn_port_flg").length < 1){
					ComShowCodeMessage("VSK01018", "T/Port IND(N/Y)");
					sheetObj.SelectCell(i,"sheet2_turn_port_flg");
					return false;
				}
				
				var portCd		= sheetObj.CellValue(i, prefix+"port_cd");
				var etbDyNo 	= sheetObj.CellValue(i, prefix+"etb_dy_no");
				var etbTmHrmnt 	= sheetObj.CellValue(i, prefix+"etb_tm_hrmnt");
				var etdDyNo 	= sheetObj.CellValue(i, prefix+"etd_dy_no");
				var etdTmHrmnt 	= sheetObj.CellValue(i, prefix+"etd_tm_hrmnt");
				
				// ETB, ETD가 순차적으로 입력되였는지 확인한다.
				if ((i < totCnt) && (etbDyNo+etbTmHrmnt)*1 >= (etdDyNo+etdTmHrmnt)*1) {
					ComShowCodeMessage("VSK01018", "Seq : "+(i-headCnt+1)+" (" +portCd+ ")ETB >= ETD");
					sheetObj.SelectCell(i,"sheet2_etb_dy_no");
					return false;
				}
				
				// Pre ETD, ETB가 순적적으로 입력되였는지 확인한다.
				if (i > headCnt) {
					var PrePortCd		= sheetObj.CellValue(i-1, prefix+"port_cd");
					var preEtdDyNo 		= sheetObj.CellValue(i-1, prefix+"etd_dy_no");
					var preEtdTmHrmnt 	= sheetObj.CellValue(i-1, prefix+"etd_tm_hrmnt");
					
					if ((preEtdDyNo+preEtdTmHrmnt)*1 >= (etbDyNo+etbTmHrmnt)*1) {
						ComShowCodeMessage("VSK01018", "Seq : "+(i-headCnt+1)+"( " +PrePortCd+ ") Previous ETD >= (" +portCd+ ") Current ETB");
						sheetObj.SelectCell(i,"sheet2_etb_dy_no");
						return false;
					}
				}
			}
		}
					
		//2008 10 29 임창빈 수석이 Feeder 나 Trunker 상관없이 사용자가 입력한 
		//Manual에 따라 양방향, 단방향을 따진다
		var firstRow = getSearchFirstRow(sheetObjects[1]);
		var lastRow = searchLastRow(sheetObjects[1]);
		
		var firstDirCd = sheetObjects[1].CellValue(firstRow,"sheet2_skd_dir_cd");
		var otherDirCd = 0;
		
		//첫번째 포트의 Dir Cd와 다른 Dir Cd를 찾는다
		//사용자가 입력한 Dir Cd가 단 방향인지 (예 : 모든 Dir Cd가 W 아님 E )일 경우는 첫번째 포트의 Port Cd와 Yd Cd가 마지막 포트의 Port Cd, Yd Cd가  다르더라도 무방
		//사용자가 입력한 Dir Cd가 양 방향인지 (예 : Dir Cdrk W -> E, 아님 N -> S)일 경우는 첫번째 포트와 마지막 포트의 Port Cd와 Yd Cd가 같아야 한다
		for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
			//처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
			if(sheetObjects[1].CellValue(i,"sheet2_skd_dir_cd") != firstDirCd){
				otherDirCd = i;
				break;
			}
		}
		
		// 첫번째 포트의 Dir Cd와 다른 Dir Cd가 있을 경우  => 양 방향일경우
		// CHM-201005742-01 Non-Weekly P/F SKD 생성을 위해 DY_NO 동일 체크는 제거한다.
		if(otherDirCd > 0){
			if(sheetObjects[1].CellValue(firstRow,"sheet2_port_cd") == sheetObjects[1].CellValue(lastRow-1,"sheet2_port_cd")
				  && sheetObjects[1].CellValue(firstRow,"sheet2_yd_cd") == sheetObjects[1].CellValue(lastRow-1,"sheet2_yd_cd")
				  //&& sheetObjects[1].CellValue(firstRow,"sheet2_etb_dy_cd") == sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_dy_cd")
				  && sheetObjects[1].CellValue(firstRow,"sheet2_etb_tm_hrmnt") == sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_tm_hrmnt")
				  ){
					// 첫번째, 마지막 Row에 Port, Yard, ETB, ETB Hour이 동일할 경우 마지막 Row에 ETD에 Day, Hour를 첫번째 Row와 동일 하게 생성한다.
					// Long Range SKD 생성시 필요함.
					//sheetObjects[1].CellValue(lastRow-1,"sheet2_etd_dy_cd") =  sheetObjects[1].CellValue(firstRow,"sheet2_etd_dy_cd");
					sheetObjects[1].CellValue(lastRow-1,"sheet2_etd_tm_hrmnt") = sheetObjects[1].CellValue(firstRow,"sheet2_etd_tm_hrmnt");
			}else{
				ComShowCodeMessage("VSK00084");
				if(sheetObjects[1].CellValue(firstRow,"sheet2_port_cd") != sheetObjects[1].CellValue(lastRow-1,"sheet2_port_cd")){
					sheetObjects[1].SelectCell(firstRow, "sheet2_port_cd", true);
				}else if(sheetObjects[1].CellValue(firstRow,"sheet2_yd_cd") != sheetObjects[1].CellValue(lastRow-1,"sheet2_yd_cd")){
					sheetObjects[1].SelectCell(firstRow, "sheet2_yd_cd", true);
				//}else if(sheetObjects[1].CellValue(firstRow,"sheet2_etb_dy_cd") != sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_dy_cd")){
				//	sheetObjects[1].SelectCell(firstRow, "sheet2_etb_dy_cd", true);
				}else if(sheetObjects[1].CellValue(firstRow,"sheet2_etb_tm_hrmnt") != sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_tm_hrmnt")){
					sheetObjects[1].SelectCell(firstRow, "sheet2_etb_tm_hrmnt", true);
				}
				return false;
			}
		}
		
		var pfTypeData = g_pfTypeData.split(":");

		if(pfTypeData[0] == "Y"){
			ComShowCodeMessage("VSK00091");
			formObj.pf_svc_tp_cd.value = "";
			formObj.pf_svc_tp_cd.focus();
			return false;
		}else if(pfTypeData[1] == "Y"){
			ComShowCodeMessage("VSK00092");
			formObj.pf_svc_tp_cd.value = "";
			formObj.pf_svc_tp_cd.focus();
			return false;
		}
		
		/*
		 * CHM-201005742-01 Non-Weekly P/F SKD 생성을 위한 검증 로직 추가
		 */
		// 입력한 Duration 값과 일정상의 Duration 값을 비교하고 다를 시에는 사용자에게 알린다.
		var dur1 = Number(formObj.svc_dur_dys.value);
		var dur2 = Number(sheetObj.CellValue(totCnt, prefix+"etb_dy_no")) - Number(sheetObj.CellValue(headCnt, prefix+"etb_dy_no"));
		if(dur1!=dur2){
			ComShowCodeMessage("VSK00096", "Duration or ETB No");
			return false;
		}
		
		// Duration을 Vessel의 척수로 나눈 값은 Frequence와 동일해야 한다.
		var vslCnt = Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
		var frequency = Number(formObj.brth_itval_dys.value);
		if((dur1/vslCnt)!=frequency){
			ComShowCodeMessage("VSK00096", "Frequency or Vessel Class Count");
			return false;
		}
		
		break;
		
	case "simul":  
		var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
		var prefix = sheetObj.id + "_";

			if(sheetObjects[1].RowCount < 1){
				ComShowCodeMessage("VSK00043");
				formObj.sim_dt.focus();
				return false;
			}
			
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount+2; i++){
					
					if(i == 3){
						if(sheetObj.CellValue(i, prefix+"etb_dy_cd") == ""){
							ComShowCodeMessage("VSK01018", "ETB Day");
							sheetObj.SelectCell(i,"sheet2_etb_dy_cd");
							return false;
						}
						
						if(sheetObj.CellValue(i, prefix+"etb_tm_hrmnt") == ""){
							ComShowCodeMessage("VSK01018", "ETB Time");
							sheetObj.SelectCell(i,"sheet2_etb_tm_hrmnt");
							return false;
						}
					}
					
					if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
				}
			}

		break;
	case "vsl_slan_cd_change":      	//vsl_slan_cd onChange Event
		if(!ComIsNull(formObj.vsl_slan_cd.value)){
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value = "";
				return false;
			}
		} 
		
		break;

	case "Save":         //저장
		
		/*
		 * <필수 여부 검사>
		 * 1. Lane Code 3자리 확인.
		 * 3. Service Lane Type Code가 Feeder('O')가 아닌 경우 반드시 Proforma Type Code를 입력토록 한다.
		 * 4. Grid내에 Calling Port가 2개 이상 있어야 한다.
		 * 5. Calling Port Indicator를 설정한다.
		 * 6. Calling Sequence를 설정
		 * 7. Turn IND = 'Y' 일 경우 Turning Port 입력 여부 확인.
		 * 9. Port Code 5자리 확인
		 * 10. Yard Code 7자리 확인
		 * <EXCEPTION>
		 * 3.[VSK02005] 메시지 출력 후 리턴 Service Lane Type Code에 Focus On
		 * 4.[VSK02006] 메시지 출력 후 리턴
		 * 7.[VSK02007] 메시지 출력 후 리턴 해당 줄에 Focus On
		 * 8.[VSK02008] 메시지 출력 후 리턴 해당 줄에 Focus On
		 * 9.[VSK02009] 메시지 출력 후 리턴 해당 줄에 Port Code 항목에 Focus On
		 * 10.[VSK02010] 메시지 출력 후 리턴 해당 줄에 Yard Code 항목에 Focus On
		 */
		var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
		var prefix = sheetObj.id + "_";
		
//		if(formObj.sim_dt.value.length < 8){
//			ComShowCodeMessage("VSK01018", "Simulation No.");
//			formObj.sim_dt.focus();
//			return false;
//		}
//		
//		if(ComIsNull(formObj.sim_no.value)){
//			ComShowCodeMessage('VSK00027', "Simulation date");
//			formObj.sim_no.focus();
//			return false;
//		}
		
		if(formObj.vsl_slan_cd.value.length < 3){
			ComShowCodeMessage("VSK01018", "Lane Code");
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.focus();
			
			return false;
		}
//		if(formObj.pf_svc_tp_cd.value.length < 4){
//			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
//				//VSK02005
//				ComShowCodeMessage("VSK01018", "P/F SKD Type");
//				formObj.pf_svc_tp_cd.focus();
//				
//				return false;
//			}
//		}
		if(sheetObj.RowCount < 2){
			//VSK02006
			ComShowCodeMessage("VSK00043");
			return false;
		}
		if(rowCnt > 2){
			for(var i=3; i<=sheetObj.RowCount+2; i++){
				
				if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
					ComShowCodeMessage("VSK01018", "Port Code");
					sheetObj.SelectCell(i,"sheet2_port_cd");
					return false;
				}

//				if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
//					ComShowCodeMessage("VSK01018", "Terminal Code");
//					sheetObj.SelectCell(i,"sheet2_yd_cd");
//					return false;
//				}
				
			}
		}
		
		break;
	case "FileUpload": 
		var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
		var prefix = sheetObj.id + "_";
//		if(ComIsNull(formObj.vsl_slan_cd.value)){
//			ComShowCodeMessage('VSK00027', "Lane Code");
//			formObj.vsl_slan_cd.focus();
//			return false;
//		}
//		
//		if(ComIsNull(formObj.pf_svc_tp_cd.value)){
//			ComShowCodeMessage('VSK00027', "P/F SKD Type");
//			formObj.pf_svc_tp_cd.focus();
//			return false;
//		}
		
//		if(formObj.vsl_slan_cd.value.length < 3){
//			ComShowCodeMessage("VSK01018", "Lane Code");
//			formObj.vsl_slan_cd.value = "";
//			formObj.vsl_slan_cd.focus();
//			
//			return false;
//		}
		
		if(ComIsNull(comboObjects[0].Code)){
			ComShowCodeMessage('VSK00027', "1st Vessel Class");
			comboObjects[0].focus();
			return false;
		}
		
		if(ComIsNull(formObj.n1st_vsl_clss_knt.value)){
			ComShowCodeMessage('VSK00027', "1st Vessel Count");
			formObj.n1st_vsl_clss_knt.focus();
			return false;
		}
		
		break;	
			
	}

    return true;
}

/**
 * Lane Code Help 파일을 오픈한다
 */
function openLandCdHelp(sheetObj){
   var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
   var v_display = "0,0";
   var laneCd = document.form.vsl_slan_cd.value;

   ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);

}

/**
 * P/F Lane Type Code Help 파일을 오픈한다  
 */
function openPfLandTypeCdHelp(sheetObj){
	var formObj = document.form;
	var laneCd = formObj.vsl_slan_cd.value;
	var sUrl = "/hanjin/VOP_VSK_0241.do?vsl_slan_cd="+laneCd;
	
	ComOpenPopup(sUrl, 620, 490, "getPfTpyeCd", "0,0", true);
}

function getPfTpyeCd(obj){
	var formObj = document.form;
	
	if(obj){
		var rtnDatas = obj[0];

		if(rtnDatas.length > 0){
			document.form.pf_svc_tp_cd.value = rtnDatas[3];
			
			var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
			//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
			var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
			
			g_pfTypeData  = pfTypeData;
//			if(pfTypeData[0] == "Y"){
//				ComShowCodeMessage("VSK00091");
//			 	formObj.pf_svc_tp_cd.value = "";
//			 	formObj.pf_svc_tp_cd.focus();
//			 }else if(pfTypeData[1] == "Y"){
//				ComShowCodeMessage("VSK00092");
//				formObj.pf_svc_tp_cd.value = "";
//				formObj.pf_svc_tp_cd.focus();
//			 }
		}
	}
}

	/**
	 *Simulation NO Code Help 파일을 오픈한다  
	 */
	function openSimNoCdHelp(sheetObj){
		var laneCd = document.form.vsl_slan_cd.value;
		var sUrl = "/hanjin/VOP_VSK_0201.do?uiFlg=A&vsl_slan_cd="+laneCd;
		ComOpenPopup(sUrl, 800, 470, "getSimData", "0,0", true);
	}

function getSimData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				var vslSlanCdTemp = rtnDatas[2];
				document.form.vsl_slan_cd.value = vslSlanCdTemp;
				
				var simTemp = rtnDatas[4];
				simTemp = ComReplaceStr(simTemp,"-","");
				document.form.sim_dt.value = simTemp.substring(0,8);
				document.form.sim_no.value = Number(simTemp.substring(8,11));
			}
		}
	}
}

function open_BerthWindow(sheetObj1,sheetObj2,formObj){
	var masterCnt = sheetObj1.RowCount;
	var dtlCnt = sheetObj2.RowCount;
	var prefix = sheetObj2.id + "_";

	if(masterCnt < 1 || dtlCnt < 1){
		ComShowCodeMessage("VSK00043");
		formObj.sim_dt.focus();
		return;
	}
	
	for(var i=3; i<=sheetObj2.RowCount+2; i++){
		if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
			ComShowCodeMessage("VSK01018", "Port Code");
			sheetObj.SelectCell(i,"sheet2_port_cd");
			return false;
		}

		if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
			ComShowCodeMessage("VSK01018", "Terminal Code");
			sheetObj.SelectCell(i,"sheet2_yd_cd");
			return false;
		}
	}
	
	sheetObj1.CellValue(1, "sheet1_hiddencheck") = "Y";
	
	for(var i=3; i<=sheetObj2.RowCount+2; i++){
		sheetObj2.CellValue(i, "sheet2_hiddencheck") = "Y";
	}
	
	
	var vslSlanCd = formObj.vsl_slan_cd.value;
	var pfSvcTpCd = formObj.pf_svc_tp_cd.value;
	var seq = formObj.brth_itval_dys.value;
	var dur = formObj.svc_dur_dys.value;
	//sUrl = "/hanjin/VOP_VSK_0238.do?op_=0238&vsl_slan_cd="+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd+"&seq="+seq+"&dur="+dur;
	sUrl = "/hanjin/VOP_VSK_0238.do?vsl_slan_cd="+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd+"&seq="+seq+"&dur="+dur;
	ComOpenPopup(sUrl, 900, 620, "", "0,0", true);
	
}


function openEOTPCreation(sheetObj1,sheetObj2,formObj){

	var cnt = sheetObj1.RowCount;
	var cnt2 = sheetObj2.RowCount;
	
	//기존에 화면에서 조회를 하지않고 add Row로 데이타를 입력 후 EOTP를 오픈하는 것을
	//막았는데 그것을 풀고 pf_skd 데이타만 입력하지 않은면 막는 것으로 수정
	//if(cnt  < 1 ||  sheetObj1.CellValue(1,"sheet1_ibflag") == "I"){

	if(cnt2  < 1){
		ComShowCodeMessage("VSK00043");
		formObj.sim_dt.focus();
		return;
	}  
	sheetObj1.CellValue(1, "sheet1_hiddencheck") = "Y";
	
	for(var i=3; i<=sheetObj2.RowCount+2; i++){
		sheetObj2.CellValue(i, "sheet2_hiddencheck") = "Y";
	}
	
	sUrl = "/hanjin/VOP_VSK_0243.do";
	ComOpenPopup(sUrl, 1020, 630, "returnEOTP", "none", true);
}

/**
 * EOTP (Pop-Up)에서 받은 데이타 처리.
 * [EOTP] Button Click 후 Pop-up에서 호출.
 * @param rtnObjs
 * @return
 */
function returnEOTP(rtnObjs){
	var formObj = document.form;
	var sheetObj = null;

	if(rtnObjs.length > 0){
		var rtnDatas = rtnObjs[idx];
		if(rtnDatas.length > 0){
			//sheetObj.CellValue2(currRow, prefix+"ts_port_cd") = rtnDatas[2];

		
		}
	}
	
}

/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1,sheetObj2,formObj){
	formObj.sim_dt.value = "";
	formObj.sim_no.value = "";
	formObj.vsl_slan_cd.value = "";
	formObj.slan_stnd_flg.value = "N";
	formObj.pf_svc_tp_cd.value = "";
	formObj.n1st_vsl_clss_cd.value = "";
	formObj.n1st_vsl_clss_knt.value = "";
	formObj.n2nd_vsl_clss_cd.value = "";
	formObj.n2nd_vsl_clss_knt.value = "";
	formObj.n3rd_vsl_clss_cd.value = "";
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";
	formObj.brth_itval_dys.value = "";	
	formObj.pf_skd_rmk.value = "";

	//formObj.clpt_knt.value = "";
	formObj.tot_buf_rat.value = "";
	//formObj.ttl_dist.value = "";
	formObj.sea_buf_rat.value = "";
	formObj.max_spd.value = "";
	formObj.port_buf_rat.value = "";
	//formObj.avg_spd.value = "";
	formObj.pf_spd_rat.value = "";
	//formObj.buf_spd.value = "";
	formObj.buf_spd_rat.value = "";
	formObj.eotp1.value = "";
	formObj.eotp2.value = "";

	formObj.lf.value = "";
	formObj.rpb.value = "";
	formObj.rev.value = "";
	formObj.op.value = "";
	

	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	
	formObj.sim_dt.focus();
	
	//All Check 초기화
	sheetObj2.CheckAll(sheetObj2.id+"_Sel") = 0;
}
/**
 * Enter키 이벤트
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){

	var formObject = document.form;

	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}

/**
 * grid 출력 후 Duration,Frequency 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function gridEndJob(sheetObj,formObj){

	formObj.slan_stnd_flg.value = "N";
	
	var lastEtbDyNo = parseInt(sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount -1,"sheet2_etb_dy_no"));
	var lastEtbTmHrmnt = sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount -1,"sheet2_etb_tm_hrmnt");
	
	var firstEtbDyNo = parseInt(sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_dy_no"));
	var firstEtbTmHrmnt = sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_tm_hrmnt");
	
	var tempLastEtbTmHrmnt = lastEtbTmHrmnt.length;
	var tempFirstEtbTmHrmnt = firstEtbTmHrmnt.length;

	var lastEtbTmHrmntVal = 0;
	var firstEtbTmHrmntVal = 0;
	
	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
	}
	
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
	}

	var lastTot = parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
	var firstTot = parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);

	var tempDur = parseInt(lastTot - firstTot);

	var durVal1 = parseInt(tempDur/24);
	
	var resultDurVal = isNaN(durVal1);
	
	if(resultDurVal == true){
		durVal1 = 0;
	}
	

	formObj.svc_dur_dys.value = parseInt(durVal1);
	
	var vslClssKnt1 = formObj.n1st_vsl_clss_knt.value;
	var vslClssKnt2 = formObj.n2nd_vsl_clss_knt.value;
	if(vslClssKnt2 == "") vslClssKnt2 = 0;
	var vslClssKnt3 = formObj.n3rd_vsl_clss_knt.value;
	if(vslClssKnt3 == "") vslClssKnt3 = 0;
	
	var totClssKnt = parseInt(vslClssKnt1)+parseInt(vslClssKnt2)+parseInt(vslClssKnt3);
	var svcDurDysVal = parseInt(formObj.svc_dur_dys.value);
	var freVal = svcDurDysVal/totClssKnt;
	var resultFreVal = isNaN(freVal);
	
	if(resultFreVal == true){
		freVal = 0;
	}
	formObj.brth_itval_dys.value = parseInt(freVal);
	
	
	
//	
//	// Frequency
//	var vslCnt = Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
//	var frequency = durVal1/vslCnt;
//	frequency = Math.round(parseInt(frequency * 10))/10;
//	formObj.brth_itval_dys.value = frequency;	
}

/**
 * grid 출력 후 last 로우 Color 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowView(sheetObj,rowPos){
	var rdInx = rowPos - 1;		
	var prefix = "sheet2_";
	var rtnRowCnt = getRowCount(sheetObj);
	
	if(rtnRowCnt > 0){
		//회색
		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
		//흰색
		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
		
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_dist") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"tztm_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_out_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"act_wrk_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"port_buf_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ipcgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ipcgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"tml_prod_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"crn_knt") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"turn_port_flg") = false;
		
		sheetObjects[1].CellEditable(rdInx, prefix+"temp1") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"temp2") = false;
		
		
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_no") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_cd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_dist") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_spd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tztm_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_spd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_out_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"act_wrk_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"port_buf_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tml_prod_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"crn_knt") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"turn_port_flg") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"temp1") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"temp2") = grayColor;
		
		sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
		
		
	}
}

/**
 * grid 출력 후 last 로우 Color 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowViewUndo(sheetObj,rowPos){
	
	var rdInx = rowPos - 1;					
	var prefix = "sheet2_";
	var rtnRowCnt = getRowCount(sheetObj);
	
	if(rtnRowCnt > 0){
		//회색
		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
		//흰색
		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
		//검은색
		var blackColor = sheetObj.RgbColor(eval("0"),eval("0"),eval("0"));
		
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_dist") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_spd") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"tztm_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_out_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"act_wrk_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"port_buf_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ipcgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ipcgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"tml_prod_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"crn_knt") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"turn_port_flg") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"temp1") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"temp2") = true;
		
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_no") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_cd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_dist") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_spd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tztm_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_spd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_in_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_out_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"act_wrk_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"port_buf_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tml_prod_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"crn_knt") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"turn_port_flg") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"temp1") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"temp2") = blackColor;
		
		//sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
		
	}
}

/**
 * Row_SEQ 순차적으로 다시 생성
 * @param sheetObj
 * @return
 */

function resetRowSeq(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var prefix = sheetObj.id + "_";
	var idx = 0;
	var vIbFlag = "";
	
//	for(var i=0; i<rowCnt; i++){
//		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//			vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//			idx++;
//			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
//			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
//		}
//	}
	
	for(var i=0; i<rowCnt; i++){
		if(sheetObj.RowStatus(i+headCnt) != "D"){
			vIbFlag = sheetObj.RowStatus(i+headCnt);
			idx++;
			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
			sheetObj.RowStatus(i+headCnt) = vIbFlag;
		}
	}
	
}

/**
 * Delete된 Row를 제외한 마지막 로우를 찾늗다
 * @param sheetObj
 * @return
 */

function searchLastRow(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var totalCnt = headCnt+rowCnt;
	var idx = 0;

	for(var i=totalCnt-1; i>headCnt-1; i--){
		
		if(sheetObj.CellValue(i, 0) != "D"){
		
			idx = i;
			
			break;
		}
	}
	return idx+1;
}


/**
 * 첫번재 로우의 Manu In은 항상 가려져야 한다
 * 만약 첫번째 로우를 Delete하면 하위 로우중 Delete Flag가 아닌 로우의 Manu In을 가져준다
 * @param sheetObj
 * @return
 */
function searchFirstRow(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var totalCnt = headCnt+rowCnt;
	var idx = 0;
	var rtnIdx = 0;
	var prefix = "sheet2_";
	var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
	var rtlRowCnt = getRowCount(sheetObj);
	
	if(rtlRowCnt > 0){
		for(var i=headCnt; i<totalCnt; i++){
			if(sheetObj.CellValue(i, 0) != "D"){
				idx = i;
				break;
			}
		}
		
		sheetObj.CellEditable(idx, "sheet2_etb_dy_no") = true;
		sheetObj.CellEditable(idx, "sheet2_etb_dy_cd") = true;
		sheetObj.CellEditable(idx, "sheet2_etb_tm_hrmnt") = true;
		
		sheetObj.CellEditable(idx, prefix+"mnvr_in_hrs") = false;
		sheetObj.CellFontColor(idx,prefix+"mnvr_in_hrs") = grayColor;
	}
}

/**
 * Delete된 Row를 제외한 첫번째 로우를 찾늗다
 * @param sheetObj
 * @return
 */
function getSearchFirstRow(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var totalCnt = headCnt+rowCnt;
	var idx = 0;
	var rtnIdx = 0;
	var prefix = "sheet2_";
	
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.CellValue(i, 0) != "D"){
			idx = i;
			break;
		}
	}
	
	return idx;
}

/**
 *  조회 조건이 아닌 모든 데이타 초기화.
 *  
 * @param sheetObj1
 * @param sheetObj2
 * @param formObj
 * @return
 */
function clearDescData(sheetObjects, formObj){
	formObj.vsl_slan_cd.value = "";
	formObj.slan_stnd_flg.value = "N";
	formObj.pf_svc_tp_cd.value = "";
	formObj.n1st_vsl_clss_cd.value = "";
	formObj.n1st_vsl_clss_knt.value = "";
	formObj.n2nd_vsl_clss_cd.value = "";
	formObj.n2nd_vsl_clss_knt.value = "";
	formObj.n3rd_vsl_clss_cd.value = "";
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";
	formObj.brth_itval_dys.value = "";	
	formObj.pf_skd_rmk.value = "";
	
	formObj.tot_buf_rat.value = "";
	formObj.sea_buf_rat.value = "";
	formObj.max_spd.value = "";
	formObj.port_buf_rat.value = "";
	formObj.pf_spd_rat.value = "";
	formObj.buf_spd_rat.value = "";
	formObj.lf.value = "";
	formObj.rev.value = "";
	formObj.eotp1.value = "";
	formObj.rpb.value = "";
	formObj.op.value = "";
	formObj.eotp2.value = "";
	
	if(sheetObjects.length > 0){
		for(var i=0; i<sheetObjects.length; i++){
			sheetObjects[i].RemoveAll();
			if(i == 1){
				//All Check 초기화
				sheetObjects[i].CheckAll(sheetObjects[i].id+"_Sel") = 0;
			}
		}
	}
	
	formObj.sim_dt.focus();
}

/**
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */

function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
	
    if(sheetObj.RowCount > 0){
    	//마우스 위치를 행과 컬럼과 값 가져오기
        var Row = sheetObj.MouseRow;
        var Col = sheetObj.MouseCol;
        var prefix = sheetObj.id+"_";
        
        if(Row > 0 && Col == 4 || Col == 7 || Col == 8 || Col == 9){
        	var checkWkTm = sheetObj.CellValue(Row, "sheet2_check_wk_tm");
        	if(checkWkTm == "Y"){
	        	var sText = sheetObj.CellText(Row,"sheet2_crane_wk_tm");
	        	if(sText != ""){
	        		sheetObj.MouseToolTipText = sText;
	        		sheetObj.MousePointer = "Hand";
	        	}else{
	        		sheetObj.MouseToolTipText = "";
	                sheetObj.MousePointer = "Default";	
	        	}
        	}else{
        		sheetObj.MouseToolTipText = "";
            	sheetObj.MousePointer = "Default";	
            }
        }
    } 
}

function getRowCount(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var totalCnt = headCnt+rowCnt;
	var idx = 0;
	var rtnIdx = 0;
	var prefix = "sheet2_";
	
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.CellValue(i, 0) != "D"){
			idx++;
			
		}
	}
	
	return idx;
}



function sheet2_OnBeforeEdit(sheetObj, Row, Col){
	bakObjForEdit = sheetObj.CellValue(Row, Col);
	//alert("Row == " + Row + " : Col == " + sheetObj.ColSaveName(Col) + " : " + sheetObj.CellValue(Row, Col));
}

function sheet2_OnAfterEdit(sheetObj, Row, Col){
	if(bakObjForEdit != sheetObj.CellValue(Row, Col)){
		//alert("Row == " + Row + " : Col == " + sheetObj.ColSaveName(Col) + " : Before == " + bakObjForEdit + " :  After == " + sheetObj.CellValue(Row, Col));
		setEditMode(true);
	}
}

function setEditMode(mode){
	if(mode){
		editMode = true;
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Settlement");
	}else{
		editMode = false;
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Settlement");
	}
}
/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllDataForSheet(sheetObj1,sheetObj2){

	sheetObj2.Editable 	= true;
	sheetObj1.RemoveAll	();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll	();
//	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	
	ComBtnEnable("btn_RowAdd");
	ComBtnEnable("btn_RowInsert");
	ComBtnEnable("btn_RowDelete");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_MSimulation");
	ComBtnEnable("btn_ASimulation");
	
} 

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	
	var startRow		= sheetObject2.HeaderRows;
	var endRow			= sheetObject2.RowCount + sheetObject2.HeaderRows;
	
	var prefix_sheet2	= "sheet2_";
	var prefix_sheet4	= "sheet4_";

	 
	//alert(' startRow ['+startRow+'], endRow ['+endRow+'] :: port_cd ['+sheetObject2.CellValue(4,	prefix_sheet2+"port_cd"		)+']');
	//alert(sheetObject3.CellValue(3,	prefix_sheet3+"port_cd"		));
	
	sheetObject4.Editable 	= true;
	sheetObject4.RemoveAll	();
	
	var	j	= 0;
	var k	= 0;
	
	var firstPortFlg	= true;
	var lastPortFlg		= false;
	var firstPort		= "";				
	
	//하위  Sub, Total Sum을 위한 변수
	var tmpSubHCalc = 0;
	var tmpSubLnkDist = 0;
	var tmpSubTztmHrs = 0;
	var tmpSubMnvrInHrs = 0;
	var tmpSubMnvrOutHrs = 0;
	var tmpSubZd = 0;
	var tmpSubActWrkHrs = 0;
	var tmpSubSeaBufHrs = 0;
	
	var tmpSubHCalc2 = 0;
	var tmpSubLnkDist2 = 0;
	var tmpSubTztmHrs2 = 0;
	var tmpSubMnvrInHrs2 = 0;
	var tmpSubMnvrOutHrs2 = 0;
	var tmpSubZd2 = 0;
	var tmpSubActWrkHrs2 = 0;
	var tmpSubSeaBufHrs2 = 0;
	
	
	var sheetObject2 = sheetObjects[1];
	var sheetObject4 = sheetObjects[3];

//	sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount + sheetObject2.HeaderRows+1.5);

	
	for(var i=startRow; i<endRow-1; i++){
		if(i==startRow){
			var tmpDir = sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd");
		}
		
		if(tmpDir == sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd")){
			
		tmpSubLnkDist 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"));
		tmpSubHCalc 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist")*sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"	));
		tmpSubTztmHrs 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"));
		tmpSubMnvrInHrs += parseFloat(sheetObject2.CellValue(i+1,	prefix_sheet2+"mnvr_in_hrs"));
		tmpSubMnvrOutHrs += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_out_hrs"));
//		tmpSubZd	 	 += (parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))-parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		)));
		tmpSubActWrkHrs  += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"));
		tmpSubSeaBufHrs  += parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"sea_buf_hrs"));
		
		}else if(tmpDir != sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd")){
			
			var tmpOthDir = sheetObject2.CellValue(i,	prefix_sheet2+"skd_dir_cd");
			
			tmpSubLnkDist2 		+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"));
			tmpSubHCalc2 		+= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist")*sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"	);
			tmpSubTztmHrs2 		+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"));
			tmpSubMnvrInHrs2  	+= parseFloat(sheetObject2.CellValue(i+1,	prefix_sheet2+"mnvr_in_hrs"));
			tmpSubMnvrOutHrs2 	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"mnvr_out_hrs"));
//			tmpSubZd2     	  	+= (parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))-parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		)));
			tmpSubActWrkHrs2  	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"));
			tmpSubSeaBufHrs2  	+= parseFloat(sheetObject2.CellValue(i,	prefix_sheet2+"sea_buf_hrs"));
		}
	
	}
	
	
	var endRow			= sheetObject4.RowCount + sheetObject4.HeaderRows;
	sheetObject4.RowDelete(endRow-1, false);
	
	var Row1 = sheetObject4.DataInsert();
	/////////////////////////////////////////////////////////////////////
	sheetObject4.CellValue2(Row1, prefix_sheet4+"skd_dir_cd") = tmpDir;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"lnk_dist") = tmpSubLnkDist;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"lnk_spd") = tmpSubHCalc/tmpSubLnkDist;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"tztm_hrs") = tmpSubTztmHrs;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"mnvr_out_hrs") = tmpSubMnvrOutHrs;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"mnvr_in_hrs") = tmpSubMnvrInHrs;
//	sheetObject4.CellValue2(Row1, prefix_sheet4+"zd") = tmpSubZd;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"act_wrk_hrs") = tmpSubActWrkHrs;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"sea_buf_hrs") = tmpSubSeaBufHrs;
	sheetObject4.CellValue2(Row1, prefix_sheet4+"etb_dy_no") = "";
	sheetObject4.CellValue2(Row1, prefix_sheet4+"etb_dy_cd") = "";
	sheetObject4.CellValue2(Row1, prefix_sheet4+"etd_dy_cd") = "";
	for(var i=0; i<20; i++){
		sheetObject4.CellBackColor(Row1, i) = sheetObject4.RgbColor(242, 221, 220);
	}
	
	if(tmpOthDir != tmpDir){
		var Row2 = sheetObject4.DataInsert();
		/////////////////////////////////////////////////////////////////////
		sheetObject4.CellValue2(Row2, prefix_sheet4+"skd_dir_cd") = tmpOthDir;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"lnk_dist") = tmpSubLnkDist2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"lnk_spd") = parseFloat(tmpSubHCalc2/tmpSubLnkDist2);
		sheetObject4.CellValue2(Row2, prefix_sheet4+"tztm_hrs") = tmpSubTztmHrs2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"mnvr_out_hrs") = tmpSubMnvrOutHrs2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"mnvr_in_hrs") = tmpSubMnvrInHrs2;
	//		sheetObject4.CellValue2(Row2, prefix_sheet4+"zd") = tmpSubZd2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"act_wrk_hrs") = tmpSubActWrkHrs2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"sea_buf_hrs") = tmpSubSeaBufHrs2;
		sheetObject4.CellValue2(Row2, prefix_sheet4+"etb_dy_no") = "";
		sheetObject4.CellValue2(Row2, prefix_sheet4+"etb_dy_cd") = "";
		sheetObject4.CellValue2(Row2, prefix_sheet4+"etd_dy_cd") = "";
		for(var i=0; i<20; i++){
			sheetObject4.CellBackColor(Row2, i) = sheetObject4.RgbColor(242, 221, 220);
		}
	}
	
	var Row3 = sheetObject4.DataInsert();
	/////////////////////////////////////////////////////////////////////
	sheetObject4.CellValue2(Row3, prefix_sheet4+"skd_dir_cd") = "TTL";
	sheetObject4.CellValue2(Row3, prefix_sheet4+"lnk_dist") = tmpSubLnkDist + tmpSubLnkDist2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"lnk_spd") = (tmpSubHCalc + tmpSubHCalc2)/(tmpSubLnkDist + tmpSubLnkDist2);
	sheetObject4.CellValue2(Row3, prefix_sheet4+"tztm_hrs") = tmpSubTztmHrs + tmpSubTztmHrs2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"mnvr_out_hrs") = tmpSubMnvrOutHrs + tmpSubMnvrOutHrs2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"mnvr_in_hrs") = tmpSubMnvrInHrs + tmpSubMnvrInHrs2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"zd") = tmpSubZd + tmpSubZd2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"act_wrk_hrs") = tmpSubActWrkHrs + tmpSubActWrkHrs2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"sea_buf_hrs") = tmpSubSeaBufHrs + tmpSubSeaBufHrs2;
	sheetObject4.CellValue2(Row3, prefix_sheet4+"etb_dy_no") = "";
	sheetObject4.CellValue2(Row3, prefix_sheet4+"etb_dy_cd") = "";
	sheetObject4.CellValue2(Row3, prefix_sheet4+"etd_dy_cd") = "";
	for(var i=0; i<20; i++){
		sheetObject4.CellBackColor(Row3, i) = sheetObject4.RgbColor(242, 221, 220);
	}
	
//	sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount + sheetObject2.HeaderRows+2);
	
//	resizeTo( 1000, document.body.scrollHeight 	);
//    window.scrollTo(0,0);

	
}



	/* 개발자 작업  끝 */