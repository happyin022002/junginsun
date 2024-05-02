/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0003.js
*@FileTitle : P/F SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.06
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.06.22 서창열
* 1.0 Creation
* History
* 2010.09.10 유혁 CHM-201005742-01 Non-Weekly P/F SKD 생성
* 2010.11.02 유혁 CHM-201006736-01 양방향 제한 조건 해제
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.11.07 진마리아 CHM-201114315-01 [VOP_VSK] P/F Creation Class 관련 로직 수정
* 2013.05.06 정상기    CHM-201221593 Proforma Schedule Excel Import 개발
* 2014.06.08 임예지 [CHM-201429996] P/F SKED Excel Down Format 변경 요청  
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
     * @class VOP_VSK_0003 : VOP_VSK_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0003() {
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var portDataFlgs = new Array();		//그리드의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
    var ydCdsArr = new Array();
    
    //M/Simulation 와 A/Simulation 상태관리
    //var statusFlag = "";
    var submitFlg = "N";
    
    //Vsl Cls 중복 호출  체크
    var vslClsCheck = "N";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
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
						
						//var rowIdx2 = sheetObject2.RowCount + sheetObject2.HeaderRows - 1;
						//sheetObject2.CellValue(rowIdx2,"sheet2_row_seq") = sheetObject2.RowCount;
						sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_dy_no") = 0;
						sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_dy_cd") = "MON";
						sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_etb_tm_hrmnt") = "00:00";
						sheetObject2.CellEditable(rowIdx2, "sheet2_etd_dy_no") = false;
						sheetObject2.CellEditable(rowIdx2, "sheet2_etd_dy_cd") = false;
						sheetObject2.CellEditable(rowIdx2, "sheet2_etd_tm_hrmnt") = false;
						sheetObject2.SelectCell(rowIdx2, sheetObject2.id+"_port_cd", true);
						
//						if(sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.RowStatus(rowIdx2) == "I"){
							sheetObject2.CellEditable(rowIdx2, "sheet2_tztm_hrs") = false;
							sheetObject2.CellEditable(rowIdx2, "sheet2_sea_buf_spd") = false;
							sheetObject2.CellEditable(rowIdx2, "sheet2_tml_prod_qty") = false;
							sheetObject2.CellEditable(rowIdx2, "sheet2_crn_knt") = false;
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
						
//						if(sheetObject2.CellValue(lastRow-1,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.RowStatus(lastRow-1) == "I"){
							sheetObject2.CellEditable(lastRow-1, "sheet2_tztm_hrs") = false;
							sheetObject2.CellEditable(lastRow-1, "sheet2_sea_buf_spd") = false;
							sheetObject2.CellEditable(lastRow-1, "sheet2_tml_prod_qty") = false;
							sheetObject2.CellEditable(lastRow-1, "sheet2_crn_knt") = false;
						}
						setlastLowViewUndo(sheetObject2,lastRow-1);
						setlastLowView(sheetObject2,lastRow);
					}
					
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
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_tml_prod_qty") = false;
							sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_crn_knt") = false;
							
							resetRowSeq(sheetObject2);
							sheetObject2.CellValue(sheetObject2.SelectRow,"sheet2_skd_dir_cd") = sheetObject2.CellValue(sheetObject2.SelectRow-1,"sheet2_skd_dir_cd");
							sheetObject2.SelectCell(rowIdx-1, sheetObject2.id+"_port_cd", true);
							
							var lastRow = searchLastRow(sheetObject2);
							setlastLowViewUndo(sheetObject2,lastRow-1);
							setlastLowView(sheetObject2,lastRow);
						}
					}
					
					
					break;
					
				case "btn_RowDelete":
					var prefix	 	= "sheet2_";
					var dataRows 	= sheetObject2.HeaderRows;
					var lastRows 	= sheetObject2.LastRow;
					var	checkFlag	= true;

					for (var i=dataRows; i<=lastRows; i++){
						if(sheetObject2.CellValue(i, prefix+"Sel")== 1){
							checkFlag = false;
							break;
						}
					}

					if (checkFlag){return;}
					
					var rowIdx = sheetObject2.SelectRow + sheetObject2.HeaderRows - 1;
					
					if(rowIdx){
						if(rowIdx > sheetObject2.HeaderRows){
							ComShowCodeMessage('VSK00005');
							
							if(ComIsNull(formObject.vsl_slan_cd.value)){
								ComShowCodeMessage('VSK00027', "Lane Code");
								formObject.vsl_slan_cd.focus()
								return;
							}
							
							if(ComIsNull(formObject.pf_svc_tp_cd.value)){
								ComShowCodeMessage('VSK00027', "P/F SKD Type");
								formObject.pf_svc_tp_cd.focus()
								return;
							}
							
							if(ComIsNull(comboObjects[0].Text)){
								ComShowCodeMessage('VSK00027', "1st Vessel Class");
								//comboObjects[0].focus();
								return;
							}
							
							if(ComIsNull(formObject.n1st_vsl_clss_knt.value)){
								ComShowCodeMessage('VSK00027', "1st Vessel Count");
								formObject.n1st_vsl_clss_knt.focus();
								return;
							}
							
							var result = ComRowHideDelete(sheetObject2,"sheet2_Sel");
							if(result  > 0){
								doActionIBSheet(sheetObject1,formObject,REMOVE02);
							}

						}
					}
					break
				
				case "btn_UploadExcel":
					//if(!validateForm(sheetObject2,formObject,COMMAND03))	return;
					if(!validateForm(sheetObject1,document.form,"FileUpload"))		return;

					var prefix_sheet2	= "sheet2_";
					var prefix_sheet3	= "sheet3_";					

					sheetObject3.Editable 	= true;
					sheetObject3.RemoveAll	();
					sheetObject3.LoadExcel();
					
					clearAllDataForSheet(sheetObject1,sheetObject2);
					
					/////////////////////// sheetObject3 >> sheetObject2 COPY ////////////////////////
					var startRow		= sheetObject3.HeaderRows;
					var endRow			= sheetObject3.RowCount + sheetObject3.HeaderRows;					
					
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
						sheetObject2.CellValue2(k,	prefix_sheet2+"port_cd"			)	= sheetObject3.CellValue(j,	prefix_sheet3+"port_cd"			);
						sheetObject2.CellValue2(k,	prefix_sheet2+"yd_cd"			)	= sheetObject3.CellValue(j,	prefix_sheet3+"yd_cd"			);
						sheetObject2.CellValue2(k,	prefix_sheet2+"mnvr_out_hrs"	)	= sheetObject3.CellValue(j,	prefix_sheet3+"mnvr_out_hrs"	);
						sheetObject2.CellValue2(k,	prefix_sheet2+"zd"				)	= sheetObject3.CellValue(j,	prefix_sheet3+"zd"				);
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
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"tztm_hrs"		)	= "";
					sheetObject2.CellValue2(endRow-1,	prefix_sheet2+"sea_buf_hrs"		)	= "";
					
					break;						
					
				case "btn_DownExcel":
					
					var startRow		= sheetObject2.HeaderRows;
					var endRow			= sheetObject2.RowCount + sheetObject2.HeaderRows;
					
					//alert('file download   startRow =['+startRow+'],  endRow = ['+endRow+']');
					
					var prefix_sheet1	= "sheet1_";
					var prefix_sheet2	= "sheet2_";
					var prefix_sheet3	= "sheet3_";
					 
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
						sheetObject3.CellValue2(k,	prefix_sheet3+"yd_cd"			)	= sheetObject2.CellValue(i,	prefix_sheet2+"yd_cd"			);
						
						
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
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_no"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_dy_no"		);
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_dy_cd"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_dy_cd"		);
							sheetObject3.CellValue2(k,	prefix_sheet3+"etd_tm_hrmnt"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"etd_tm_hrmnt"	).substring(0,2);;
							
							sheetObject3.CellValue2(k,	prefix_sheet3+"zd"				)	= parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))
																								-
																							  parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		));

						}
						
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_dy_no"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_dy_no"		);
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_dy_cd"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_dy_cd"		);
						sheetObject3.CellValue2(k,	prefix_sheet3+"etb_tm_hrmnt"	)	= sheetObject2.CellValue(i,	prefix_sheet2+"etb_tm_hrmnt"	).substring(0,2);
						sheetObject3.CellValue2(k,	prefix_sheet3+"act_wrk_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"act_wrk_hrs"		);
						
						sheetObject3.DataInsert(-1);
						sheetObject3.CellValue2(k+1,prefix_sheet3+"lnk_dist"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_dist"		);
						sheetObject3.CellValue2(k+1,prefix_sheet3+"lnk_spd"			)	= sheetObject2.CellValue(i,	prefix_sheet2+"lnk_spd"			);
						sheetObject3.CellValue2(k+1,prefix_sheet3+"tztm_hrs"		)	= sheetObject2.CellValue(i,	prefix_sheet2+"tztm_hrs"		);
						
						sheetObject3.CellValue2(k+1,prefix_sheet3+"zd"				)	= sheetObject3.CellValue(k,	prefix_sheet3+"zd"				);
						sheetObject3.CellValue2(k,prefix_sheet3+"zd"				)	= "";
						
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
						tmpSubZd	 	 += (parseInt(sheetObject2.CellValue(i+1,	prefix_sheet2+"zd"		))-parseInt(sheetObject2.CellValue(i,	prefix_sheet2+"zd"		)));
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
					var sReportPageUrl	= "apps/alps/vop/vsk/scheduleplanningoperation/proformaschedulemgt/jsp/VOP_VSK_0003ExcelDown.jsp";
					
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
					var pf_upd_dt	= sheetObject1.CellValue(1, "sheet1_upd_dt").substring(0,10);
					
					//alert(pf_vsl_cd);
					//alert(pf_duration);
					//alert(pf_vsl_clss);
					//alert(pf_skd_tp);
					//alert(pf_upd_dt);
					
					var param	= "?pf_vsl_cd="+pf_vsl_cd;
						param	= param + "&pf_duration="+pf_duration;
						param	= param + "&pf_vsl_clss="+pf_vsl_clss;
						param	= param + "&pf_skd_tp="+pf_skd_tp;
						param	= param + "&pf_upd_dt="+pf_upd_dt;
					
					//sheetObject3.showDebugMsg	= true;
					sheetObject3.Down2Excel(-1, false, false, true, "", sReportPageUrl+param);
					//sheetObject3.showDebugMsg	= false;
					
					break;					

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_New":
					clearAllData(sheetObject1,sheetObject2,formObject);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject2, formObject, IBSAVE);
					break;
					
				case "btn_MSimulation":
					doActionIBSheet(sheetObject2,formObject,COMMAND01);
					break;
					
				case "btn_ASimulation":
					doActionIBSheet(sheetObject2,formObject,COMMAND02);
					break;
					
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;	
					
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
					break;	
				
				case "btns_search03":
					openPfSkdHistoryHelp(sheetObject2);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE);
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
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObject = document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
    	
    	doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObjects[0],SEARCH01);
    	
    	initControl();
    	
    	if(sheetObjects[0].RowCount == 0){
    		sheetObjects[0].DataInsert(-1);
    	}
    	
    	document.form.vsl_slan_cd.focus();
    }

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObject = document.form
    switch(comboNo) {  
          case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				BackColor = "#CCFFFD";
				FontColor = "#000000";
				ColBackColor(0) = "#CCFFFD";
				ColFontColor(0) = "#000000";
 				DropHeight = 160;
 		    	}

 			break;
          case 2: 
              with (comboObj) { 
   				MultiSelect = false; 
   				UseAutoComplete = true;	
   				SetColAlign("left");        
   				SetColWidth("50");
   				BackColor = "#FFFFFF";
   				FontColor = "#000000";
   				ColBackColor(0) = "#FFFFFF";
   				ColFontColor(0) = "#000000";
				DropHeight = 160;
		    	}

    		break;
    	
          case 3: 
              with (comboObj) { 
   				MultiSelect = false; 
   				UseAutoComplete = true;	
   				SetColAlign("left");        
   				SetColWidth("50");
   				BackColor = "#FFFFFF";
   				FontColor = "#000000";
   				ColBackColor(0) = "#FFFFFF";
   				ColFontColor(0) = "#000000";
				DropHeight = 160;
		    	}

    		break;
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
//            style.height = 100;
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

            var HeadTitle = "STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|CRE_DT|UPD_DT";
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
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"cre_dt",     	false,          "",      dfTimeHm);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"upd_dt",     	false,          "",      dfTimeHm);
            
            WaitImageVisible = false;
            //CountPosition = 0;
            //SelectionMode = smSelectionList; //추가
       }
        
        break;
        
        case "sheet2":      //sheet2 init
            with (sheetObj) {

                // 높이 설정
                style.height = 352;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                var HeadTitle1 = "|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
                var HeadTitle2 = "|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
                var HeadTitle3 = "||No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
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
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"skd_dir_cd",		false,		"",		dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		false,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfInteger,		0, 		true,		true,		1,			false,		false );
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    30,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ib_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfFloat,		0);
				InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);
				
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"check_wk_tm");
				InitDataProperty(0, cnt++,  dtHidden,       0,    	daCenter,  	true,   prefix+"crane_wk_tm");
                                         
				InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
				InitDataCombo(0, prefix+"yd_cd", "", "");
				InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				InitDataCombo(0, prefix+"turn_port_flg", "N|Y", "N|Y");
				
				InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");

				CountPosition = 0;
				SetSortDialog(false);		
				//SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = 10;
				RowHeight(1) = 10;
				RowHeight(2) = 10;
				ToolTipOption="balloon:true;width:320";
				
				SelectHighLight = false;
				WaitImageVisible = false;
										
               }
                break;
                
//        	case "sheet3":      //sheet3 init
//            with (sheetObj) {
//
//                // 높이 설정
//                style.height = 0;
//                // 전체 너비 설정
//                SheetWidth = mainTable.clientWidth;
//
//                //Host정보 설정[필수][HostIp, Port, PagePath]
//                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                //전체Merge 종류 [선택, Default msNone]
//                MergeSheet = msHeaderOnly;
//
//               //전체Edit 허용 여부 [선택, Default false]
//                Editable = true;
//                
//                var HeadTitle1 = "PORT|TML\n\nCode|DIST|SPD|SEA\n\nTIME|MAN.|MAN.|ZD|CGO\n\nVOLM|TMNL\n\nPROD|Port\n\nTIME|ETB|ETB|ETB|ETD|ETD|ETD|BUFF.\n\nTIME";
//                var HeadTitle2 = "PORT|TML\n\nCode|DIST|SPD|SEA\n\nTIME|TIME|TIME|ZD|CGO\n\nVOLM|TMNL\n\nPROD|Port\n\nTIME| |d|h| |d|h|BUFF.\n\nTIME";
//                var HeadTitle3 = "PORT|TML\n\nCode|DIST|SPD|SEA\n\nTIME|IN|OUT|ZD|CGO\n\nVOLM|TMNL\n\nPROD|Port\n\nTIME| |d|h| |d|h|BUFF.\n\nTIME";
//				var headCount = ComCountHeadTitle(HeadTitle1);
//
//                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                InitRowInfo(3, 1, 10, 100);
//
//                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                InitColumnInfo(headCount, 0, 0, true);
//
//                // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                InitHeadMode(false, false, true, true, false, false);
//
//                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                InitHeadRow(0, HeadTitle1, true);		
//                InitHeadRow(1, HeadTitle2, true);		
//                InitHeadRow(2, HeadTitle3, true);		
//                
//                var prefix = "sheet3_";
//                //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
///*				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfNone,			0, 		true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,		    55,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"cgo_vol",			false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfFloat,		0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
//
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfInteger,		0, 		true,		true,		1,			false,		false );
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
//				
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
//                 */          
//                
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfNone,			0, 		true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfNone,		0,		true,		true,		6,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,		    55,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfNone,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfNone,		1,      true,		true,		4,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfNone,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfNone,		1,      true,		true,		3,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"zd",				false,	"",			dfNone,		0,      true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"cgo_vol",			false,	"",			dfNone,		0,      true,		true,		5,			false,		false);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfNone,		0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfNone,		1,      true,		true,		3,			false,		false);
//
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNone,		0, 		true,		true,		1,			false,		false );
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
//				
//				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfNone,		1,      true,		true,		3,			false,		false);
//
//				
//				//jsk//InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
//				//jsk//InitDataCombo(0, prefix+"yd_cd", "", "");
//				//jsk//InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
//				//jsk//InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
//				//jsk//InitDataCombo(0, prefix+"turn_port_flg", "N|Y", "N|Y");
//				
//				//InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");
//
//				//CountPosition = 0;
//				//SetSortDialog(false);		
//				//SheetOutLineColor = RgbColor(0,0,0);
//				//RowHeight(0) = 10;
//				//RowHeight(1) = 10;
//				//RowHeight(2) = 10;
//				//ToolTipOption="balloon:true;width:320";
//				
//				//SelectHighLight = false;
//				//WaitImageVisible = false;
//           }
//            break;  
            
            // 2014.05.23 New P/F Excel Down Format 
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
                    
                    var HeadTitle1 = "DIR|PORT|TML|DIST|SPD|SEA\n\nTime|MAN.|MAN.|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|ETB|ETB|ETB|ETD|ETD|ETD|BUFF\n\nTime";
                    var HeadTitle2 = "DIR|PORT|TML|DIST|SPD|SEA\n\nTime|IN|OUT|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|Day|Date|Hrs|Day|Date|Hrs|BUFF\n\nTime";
                    var HeadTitle3 = "DIR|PORT|TML|DIST|SPD|SEA\n\nTime|IN|OUT|Time\n\nDiff|CGO\n\nVOL|TML\n\nPROD|Port\n\nTIME|Day|Date|Hrs|Day|Date|Hrs|BUFF\n\nTime";
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
    				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfNullInteger,		0,		true,		true,		6,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,		    30,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfNullFloat,		1,      true,		true,		4,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"zd",				false,	"",			dfNullInteger,		0,      true,		true,		5,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"cgo_vol",			false,	"",			dfNullInteger,		0,      true,		true,		5,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfNullFloat,		0);
    				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);

    				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNullInteger,		0, 		true,		true,		1,			false,		false );
    				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
    				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNullInteger,			0);
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
    				
    				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);

    				
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
        }
    }

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction) {

    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

       case IBSEARCH:      // 조회

			if (sheetObj.id == "sheet1") {				
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH01;
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", FormQueryString(formObj));
				
				var param = "f_cmd=" + SEARCH01;
				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", param);
//				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				var comboItems = ComGetEtcData(sXml, "vslCls").split("|");
				
				addComboItem(comboObjects[0],comboItems);
				addComboItem(comboObjects[1],comboItems);	
				addComboItem(comboObjects[2],comboItems);	
				
				comboObjects[1].InsertItem(0, '', '');
				comboObjects[2].InsertItem(0, '', ''); 

			};
														
            break;
    }
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(",");
		comboObj.InsertItem(i, comboItem,comboItem);
	}   		
}

function combo2_OnChange(comboObj, comboText, comboValue){
	var formObject = document.form

	if(comboValue == ""){
		formObject.n2nd_vsl_clss_knt.value = "";
	} else{
		formObject.n2nd_vsl_clss_knt.value = "0";
	}
}

function combo3_OnChange(comboObj, comboText, comboValue){
	var formObject = document.form

	if(comboValue == ""){
		formObject.n3rd_vsl_clss_knt.value = "";
	} else {
		formObject.n3rd_vsl_clss_knt.value = "0";	
	} 
}
 
function combo1_OnBlur(comboObj){
	var val = comboObjects[0].Text;
	var cnt = comboObjects[0].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[0].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[0].Text = "";
	}
}

function combo2_OnBlur(comboObj){
	var val = comboObjects[1].Text;
	var cnt = comboObjects[1].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[1].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[1].Text = "";
	}
}

function combo3_OnBlur(comboObj){
	var val = comboObjects[2].Text;
	var cnt = comboObjects[2].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[2].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[2].Text = "";
	}
}

/**
 * 이벤트 컨드롤 정의
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm	('focus', 		'obj_focus', 	formObj);
	axon_event.addListenerFormat('keypress', 	'obj_keypress', form);
	axon_event.addListenerForm	('keyup', 		'obj_keyup' , 	form);
	axon_event.addListenerForm	('change', 		'obj_change' , 	form);	
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
    var prefix1 = "sheet1_";
    /*******************************************************/
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    
	try {
		var eleObj = window.event.srcElement;
		var srcName = eleObj.getAttribute("name");

		switch(srcName) {
        	case "vsl_slan_cd":
				if(eleObj.value.length == 3){
					formObject.pf_svc_tp_cd.focus();					
				}
				break;
        	
        	case "pf_svc_tp_cd":
				if(eleObj.value.length == 4){
					if(comboObjects[0].disabled == false){
						comboObjects[0].focus();
					}
					sheetObjects[0].CellValue(1,prefix1+"pf_svc_tp_cd") = eleObj.value;
				}
				break;
        	
//        	case "brth_itval_dys":
//        		if(eleObj.value.length == 4){
//        			comboObjects[0].focus();
//        		}
//        		sheetObject1.CellValue(1,prefix1+"brth_itval_dys") = formObject.brth_itval_dys.value;
//        		break;
        	
        	case "mml_usd_flg":
        		sheetObject1.CellValue(1,prefix1+"mml_usd_flg") = formObject.mml_usd_flg.value;
        		break;
        	
        	case "n1st_vsl_clss_cd":
        		var cnt = formObject.n1st_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObject.n1st_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n1st_vsl_clss_cd") = comboObjects[0].Code;
        		break;
        	
        	case "n1st_vsl_clss_knt":
        		var cnt = formObject.n1st_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			comboObjects[1].focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n1st_vsl_clss_knt") = formObject.n1st_vsl_clss_knt.value;
        		break;
        	
        	case "n2nd_vsl_clss_cd":
        		var cnt = formObject.n2nd_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObject.n2nd_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n2nd_vsl_clss_cd") = comboObjects[1].Code;
        		break;
        	
        	case "n2nd_vsl_clss_knt":
        		var cnt = formObject.n2nd_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			comboObjects[2].focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n2nd_vsl_clss_knt") = formObject.n2nd_vsl_clss_knt.value;
        		break;
        	
        	case "n3rd_vsl_clss_cd":
        		var cnt = formObject.n3rd_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObject.n3rd_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n3rd_vsl_clss_cd") = comboObjects[2].Code;
        		break;
        	
        	case "n3rd_vsl_clss_knt":
        		var cnt = formObject.n3rd_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			formObject.svc_dur_dys.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n3rd_vsl_clss_knt") = formObject.n3rd_vsl_clss_knt.value;
        		break;
        	
        	case "svc_dur_dys":
        		var cnt = formObject.svc_dur_dys.value.length;
        		
        		if(cnt == 4){
        			formObject.pf_skd_rmk.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"svc_dur_dys") = formObject.svc_dur_dys.value;
        		break;
        	
        	case "slan_stnd_flg":
        		sheetObject1.CellValue(1,prefix1+"slan_stnd_flg") = formObject.slan_stnd_flg.value;
        		break;
        	
            case "pf_skd_rmk":
				sheetObject1.CellValue(1,prefix1+"pf_skd_rmk") = formObject.pf_skd_rmk.value;
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
	var formObject = document.form;
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    var prefix1 = "sheet1_";
    /*******************************************************/
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    
	try {
		var eleObj = window.event.srcElement;
		var srcName = eleObj.getAttribute("name");

		switch(srcName) {
        	case "vsl_slan_cd":
        		clearDescData(sheetObjects[0],sheetObjects[1],formObject);
        		
				if(eleObj.value.length == 3){
					var sXml = doActionIBSheet(sheetObjects[0], formObject, SEARCH06);
					
					var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
		  		  	var dirCds = ComGetEtcData(sXml, "checkDirCd");
		  		  	sheetObjects[1].InitDataCombo(0, "sheet2_skd_dir_cd", dirCds,dirCds);

					if(vslSlanNm == ""){
						ComShowCodeMessage('VSK00021', formObject.vsl_slan_cd.value);
						formObject.vsl_slan_cd.focus();
						formObject.vsl_slan_cd.value = "";
						formObject.pf_svc_tp_cd.value = "";
					}else{
						formObject.pf_svc_tp_cd.focus();
						formObject.pf_svc_tp_cd.value = "";
					}
					sheetObjects[0].CellValue2(1,prefix1+"vsl_slan_cd") = formObject.vsl_slan_cd.value;
				}
				break;
        	
        	case "pf_svc_tp_cd":
//        		clearDescData(sheetObjects[0],sheetObjects[1],formObject);
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

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        //alert(sAction);
        
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					
					formObj.check_vsl_skd.value = "N" ;	// P/F SKD를 Vessel SKD에서 사용 여부를 "N"으로 초기화 한다.
			
					formObj.f_cmd.value = SEARCH;
					var	parm = "f_cmd=" +formObj.f_cmd.value+
							"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
							"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
					
			        var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
//					var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			        var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", parm + "&" + ComGetPrefixParam(aryPrefix));
			        ComOpenWait(false);
			        var arrXml = sXml.split("|$$|");

					submitFlg = "Y";
					for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx], "N");
					}

					var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
					setlastLowView(sheetObjects[1],lastPos);
					
					

					// Trunk Vessel Schedule에서 해당 Proforma Schedule 사용시 메세지를 표시한다.
					if((formObj.vsl_svc_tp_cd.value != "O") && (formObj.check_vsl_skd.value == "Y")) {
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowInsert");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Delete");
						ComBtnDisable("btn_MSimulation");
						ComBtnDisable("btn_ASimulation");
						
						ComShowCodeMessage("VSK00083");
						
					}else{
						ComBtnEnable("btn_RowAdd");
						ComBtnEnable("btn_RowInsert");
						ComBtnEnable("btn_RowDelete");
						ComBtnEnable("btn_Delete");
						ComBtnEnable("btn_MSimulation");
						ComBtnEnable("btn_ASimulation");
					}
				}
				
			break;
			
			case SEARCH02: //Port Code 변경 시.
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
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do?loc_cd="+loc_cd, sParam);
				ComOpenWait(false);
				
				return sXml;
			break;

			case SEARCH04: //Yard Code 변경시...
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH03;
				var sParam = "f_cmd=" + formObj.f_cmd.value + 
							"&yd_cd=" + formObj.yd_cd.value;
				
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", sParam);
				
//	            var sParam = FormQueryString(formObj);	            
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", sParam);
				
				ComOpenWait(false);
				
				return sXml;

			break;
			
			case SEARCH05:	// Location에 따른 Yard List 조회.
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH04;
				var sParam = "f_cmd=" + formObj.f_cmd.value + 
							"&loc_cd=" + formObj.port_cd.value;
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", sParam);
				
//				var loc_cd = formObj.port_cd.value				
//				formObj.f_cmd.value = SEARCH04;
//	            var sParam = FormQueryString(formObj);
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do?loc_cd="+loc_cd, sParam);
				ComOpenWait(false);
				
				return sXml;
			break;
			
			case SEARCH06:	// Lane Code Check
				ComOpenWait(true);

				formObj.f_cmd.value = SEARCH03;
				var sParam = "f_cmd=" + formObj.f_cmd.value + 
							"&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
			    var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", sParam);
				
//				var vslSlanCd  = formObj.vsl_slan_cd.value;
//				var sParam = FormQueryString(formObj); 
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);
				ComOpenWait(false);
				
				return sXml;
				
			break;
			
			case IBSAVE:        //저장
				var prefix = sheetObj.id + "_";
				var headCnt = sheetObj.HeaderRows;
				var totCnt = sheetObj.LastRow;
				
				if(validateForm(sheetObj,formObj,sAction)){										
					var prefix = "sheet1_"
						
					sheetObjects[0].CellValue(1,prefix+"vsl_slan_cd") 		= formObj.vsl_slan_cd.value;
					sheetObjects[0].CellValue(1,prefix+"pf_svc_tp_cd") 		= formObj.pf_svc_tp_cd.value;
					sheetObjects[0].CellValue(1,prefix+"brth_itval_dys") 	= formObj.brth_itval_dys.value;
					sheetObjects[0].CellValue(1,prefix+"mml_usd_flg") 		= formObj.mml_usd_flg.value;
					sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd") 	= comboObjects[0].Code;
					sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
					sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd") 	= comboObjects[1].Code;
					sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
					sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd") 	= comboObjects[2].Code;
					sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;
					sheetObjects[0].CellValue(1,prefix+"svc_dur_dys") 		= formObj.svc_dur_dys.value;
					sheetObjects[0].CellValue(1,prefix+"slan_stnd_flg") 	= formObj.slan_stnd_flg.value;
					sheetObjects[0].CellValue(1,prefix+"upd_dt") 			= formObj.upd_dt.value;
					sheetObjects[0].CellValue(1,prefix+"pf_skd_rmk") 		= formObj.pf_skd_rmk.value;
					
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
		     	   	var SaveStr = ComGetSaveString(sheetObjects);
		     	   	var aryPrefix = new Array("sheet1_", "sheet2_");
		     	   	var sXml = sheetObj.GetSaveXml("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   	ComOpenWait(false);
					
		     	   	if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
		     	   	
		     	   /*2014.10.28 P/F SKED Type 변경에 따른 Save Rule 변경 */
				   if(!VskGetErrorXml(sXml)){
					   doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				   }else{
					   sheetObjects[1].Editable = true;
					   sheetObjects[1].CheckAll("sheet2_Sel") = 0;
					
						ComBtnEnable("btn_RowAdd");
						ComBtnEnable("btn_RowInsert");
						ComBtnEnable("btn_RowDelete");
						ComBtnEnable("btn_Delete");
						ComBtnEnable("btn_MSimulation");
						ComBtnEnable("btn_ASimulation");
				   }
	
				   sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				}
			
			break;
			
			case COMMAND01:	// Manual Simulation
				if(validateForm(sheetObj,formObj,"Msimul")){
//				   sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U";
					sheetObjects[0].RowStatus(1) = "U";
				   
				   var currPos = 0;
				   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					   if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "I" || sheetObjects[1].CellValue(i,"sheet2_ibflag") == "U"){
					   if(sheetObjects[1].RowStatus(i) == "I" || sheetObjects[1].RowStatus(i) == "U"){
						   currPos = i;
					   }
				   }
				   
				   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					   if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//						   sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//					   }
					   if(sheetObjects[1].RowStatus(i) == "R"){
						   sheetObjects[1].RowStatus(i) = "U";
					   }
				   }

				   var prefix = "sheet1_"
				   sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd") = comboObjects[0].Code;
				   sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd") = comboObjects[1].Code;
				   sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd") = comboObjects[2].Code;
				   
				   formObj.currPos.value = currPos-1;
				   
				   ComOpenWait(true);
				   formObj.f_cmd.value = COMMAND01;
		     	   var SaveStr = ComGetSaveString(sheetObjects);
		     	   var aryPrefix = new Array("sheet1_", "sheet2_");
		     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   
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
					     		showSheetData(sheetObjects[inx],formObj,arrXml[inx],"Y");
							}

					     	gridEndJob(sheetObjects[1],formObj);
								
					     	var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
					     	setlastLowView(sheetObjects[1],lastPos);
						}
				   }else{
						sheetObj.LoadSearchXml(sXml);
					}
				   
				   ComOpenWait(false);
				}
				
			break;
			
			case COMMAND02: // Auto Simulation
				var prefix1 = "sheet1_";
				var prefix2 = "sheet2_";
				var headCnt = sheetObjects[1].HeaderRows;
				var cnt = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows-1;
				
				if(validateForm(sheetObj,formObj,"Asimul")){
					
//				   sheetObjects[0].CellValue(1,prefix1+"ibflag") = "I";
					sheetObjects[0].RowStatus(1) = "I";
				   sheetObjects[0].CellValue(1,prefix1+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
				   sheetObjects[0].CellValue(1,prefix1+"pf_svc_tp_cd") = formObj.pf_svc_tp_cd.value;
				   sheetObjects[0].CellValue(1,prefix1+"n1st_vsl_clss_cd") = comboObjects[0].Code;
				   sheetObjects[0].CellValue(1,prefix1+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
 
				   for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].RowCount+sheetObjects[1].HeaderRows-1; i++){
					   
					   //Add Row는 했지만 데이타를 입력하지 않은 경우
					   //서버로 해당 로우를 날리지 않게 위해 ibflag를 R로 셋팅
					   if(sheetObjects[1].CellValue(i,prefix2+"port_cd") == "" && sheetObjects[1].CellValue(i,prefix2+"yd_cd") == ""){
//						  sheetObjects[1].CellValue(i,prefix2+"ibflag") = "R";
						   sheetObjects[1].RowStatus(i) = "R";
					   }else{
//						   sheetObjects[1].CellValue(i,prefix2+"ibflag") = "I";
						   sheetObjects[1].RowStatus(i) = "I";
					   }

				   }
				   
				   ComOpenWait(true);
				   formObj.f_cmd.value = COMMAND02;
		     	   var SaveStr = ComGetSaveString(sheetObjects);
		     	   var aryPrefix = new Array("sheet1_", "sheet2_");
		     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		     	   var arrXml = sXml.split("|$$|");
		     	   submitFlg = "Y";
		     	   
		     	   for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx],"N");
					}
		     	  
					gridEndJob(sheetObjects[1],formObj);
					
					var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
					setlastLowView(sheetObjects[1],lastPos);

					sheetObjects[1].CheckAll("sheet2_Sel") = 0;
					ComOpenWait(false);
				}

			break;
			
			case REMOVE:
				if(validateForm(sheetObj,formObj,"Remove")){
					
//				   sheetObjects[0].CellValue(1,"sheet1_ibflag") = "D"; 
					sheetObjects[0].RowStatus(1) = "D";
				   
				   ComOpenWait(true);
				   formObj.f_cmd.value = REMOVE;
		     	   var SaveStr = ComGetSaveString(sheetObjects);
		     	   var aryPrefix = new Array("sheet1_");
		     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   	
		     	   if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
		     	   	
		     	   sheetObjects[1].CheckAll("sheet2_Sel") = 0;
		     	   ComOpenWait(false);
		     	   
				}
				break;
				
			case REMOVE02:
				if(validateForm(sheetObj,formObj,"Remove02")){
				   
//				   sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U";
					sheetObjects[0].RowStatus(1) = "U";
					
				   for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					   if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//						   sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//					   }
					   if(sheetObjects[1].RowStatus(i) == "R"){
						   sheetObjects[1].RowStatus(i) = "U";
					   }
				   } 
				  
				   ComOpenWait(true);
				   formObj.f_cmd.value = REMOVE02;
		     	   var SaveStr = ComGetSaveString(sheetObjects);
		     	   var aryPrefix = new Array("sheet1_", "sheet2_");
		     	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	  
		     	   var arrXml = sXml.split("|$$|");
		     	   
		     	   if(arrXml.length > 1){
			     	   for(var inx=0; inx<arrXml.length; inx++){
							rowDelshowSheetData(sheetObjects[inx],formObj,arrXml[inx]);
					   }
			     	   
			     	   var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
					   setlastLowView(sheetObjects[1],lastPos);
		     	   }
		     	   	
		     	   sheetObjects[1].CheckAll("sheet2_Sel") = 0;
		     	   ComOpenWait(false);

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
function showSheetData(sheetObj, formObj, sXml,Pos){
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
						formObj.pf_svc_tp_cd.value = sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
					}
					formObj.slan_stnd_flg.value = sheetObj.CellValue(1,prefix+"slan_stnd_flg");
					//formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					setValCls(comboObjects[0],sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd"));
					
					
					//formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					setValCls(comboObjects[1],sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd"));
					
					//formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					setValCls(comboObjects[2],sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd"));
					
					//alert(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt"));
					/**************************************************
					 * Vessel Class Count 컨트롤 :: 2013-04-29
					 * -----------------------------------------------
					 * 해당 함수를 조회, M/Calculation등에서 사용하므로
					 * Sheet에 해당값이 존재하면 replace 처리
					 * 존재하지 않으면 유지하는것으로 변경함
					 */
					if(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt") != "" && parseInt(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt"))>0){
						formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					}

					if(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt") != "" && parseInt(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt"))>0){
						formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					}
					
					if(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt") != "" && parseInt(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt"))>0){
						formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					}
					
					formObj.svc_dur_dys.value = sheetObj.CellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value = sheetObj.CellValue(1,prefix+"brth_itval_dys");
					formObj.mml_usd_flg.value = sheetObj.CellValue(1,prefix+"mml_usd_flg");
					
					var tempUpdDt = sheetObj.CellValue(1,prefix+"upd_dt");
					formObj.upd_dt.value = tempUpdDt.substring(0,13)+":"+tempUpdDt.substring(13,15);
					formObj.pf_skd_rmk.value = sheetObj.CellValue(1,prefix+"pf_skd_rmk");
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					
					if (formObj.n2nd_vsl_clss_knt.value == "0"){formObj.n2nd_vsl_clss_knt.value = ""};
					if (formObj.n3rd_vsl_clss_knt.value == "0"){formObj.n3rd_vsl_clss_knt.value = ""};
					
					//![CDATA[23.4|22.7|17.7|2.9|3.6|0|2266.4|1946.5|1]]
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
					//조회한 Lane Cd와 P/F TYPE CD가 Feeder 인지 Trunker인지
					formObj.vsl_svc_tp_cd.value = etcdts[9];
					//조회한 Lane Cd와 P/F TYPE CD가 VSL SKD에 등록이 되어 있는지 
					formObj.check_vsl_skd.value = etcdts[10];
					
					if(Pos == "Y"){
						formObj.currPos.value = ComGetEtcData(sXml, "currPos");
					}					
				}else{
					clearAllData(sheetObjects[0],sheetObjects[1],formObj)
					formObj.vsl_slan_cd.focus();
				}
			}
		break;
		
		case "sheet2":

			sheetObj.Redraw = false;
			sheetObj.Editable = true;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			
			if(sheetObj.RowCount > 0){
				
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				
				//VSL SKD에 등록이 되어 있는 Profoma Schedule일 경우
				if(formObj.check_vsl_skd.value == "Y"){
					//해당 Lane Cd가 Feeder 일 경우는 Editable 가능
					if(formObj.vsl_svc_tp_cd.value == "O"){
						sheetObj.Editable = true;
						
						formObj.brth_itval_dys.disabled 	= false;
						comboObjects[0].Enable = true;
						formObj.n1st_vsl_clss_knt.disabled 	= false;
						comboObjects[1].Enable = true;
						formObj.n2nd_vsl_clss_knt.disabled 	= false;
						comboObjects[2].Enable = true;
						formObj.n3rd_vsl_clss_knt.disabled 	= false;
						formObj.svc_dur_dys.disabled 		= false;
						
					//해당 Lane Cd가 Trunk 일 경우는 Editable 불가능
					}else{
						sheetObj.Editable 					= false;						
						formObj.brth_itval_dys.disabled 	= true;
						comboObjects[0].Enable 				= false;
						formObj.n1st_vsl_clss_knt.disabled 	= true;
						comboObjects[1].Enable 				= false;
						formObj.n2nd_vsl_clss_knt.disabled 	= true;
						comboObjects[2].Enable 				= false;
						formObj.n3rd_vsl_clss_knt.disabled 	= true;
						formObj.svc_dur_dys.disabled 		= true;
						
					}
				//VSL SKD에 등록이 되어 있는 Profoma Schedule이 아닌 경우 Editable 가능
				}else{
					sheetObj.Editable = true;
					
					formObj.brth_itval_dys.disabled 	= false;
					comboObjects[0].Enable 				= true;
					formObj.n1st_vsl_clss_knt.disabled 	= false;
					comboObjects[1].Enable 				= true;
					formObj.n2nd_vsl_clss_knt.disabled 	= false;
					comboObjects[2].Enable 				= true;
					formObj.n3rd_vsl_clss_knt.disabled 	= false;
					formObj.svc_dur_dys.disabled 		= false;
				}
				
				
				var lastPos 	= sheetObjects[1].RowCount+sheetObjects[1].HeaderRows - 1;
				var whiteColor	= sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
				var grayColor	= sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
				
				sheetObj.CellEditable(3, prefix+"mnvr_in_hrs") 			= false;
				sheetObj.CellFontColor(3,prefix+"mnvr_in_hrs") 			= grayColor;
				
				sheetObj.CellEditable(lastPos, prefix+"mnvr_in_hrs") 	= true;
				sheetObj.CellBackColor(lastPos, prefix+"mnvr_in_hrs") 	= whiteColor;
				
				for(var k=4; k<=sheetObj.RowCount+2; k++){
					sheetObj.CellEditable(k, "sheet2_etb_dy_no") 	= false;
					sheetObj.CellEditable(k, "sheet2_etb_dy_cd") 	= false;
					sheetObj.CellEditable(k, "sheet2_etb_tm_hrmnt") = false;
	       	 	}
	
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					sheetObj.CellEditable(k, "sheet2_etd_dy_no") 	= false;
					sheetObj.CellEditable(k, "sheet2_etd_dy_cd") 	= false;
					sheetObj.CellEditable(k, "sheet2_etd_tm_hrmnt") = false;
					sheetObj.CellEditable(k, "sheet2_tztm_hrs") 	= false;
					sheetObj.CellEditable(k, "sheet2_sea_buf_spd") 	= false;
					sheetObj.CellEditable(k, "sheet2_port_cd") 		= true;	
					sheetObj.CellEditable(k, "sheet2_tml_prod_qty") = false;
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
					sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
					sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
					sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
				}
				
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
							sheetObj.CellEditable(k, "sheet2_tml_prod_qty") = false;
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
							sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
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
	 
	//alert('sheet2_OnClick');
	 
	var formObj 	= document.form;
	var sXml 		= null;
	var prefix 		= sheetObject.id + "_";

	if(Row > 1 && Col > 0){
		if(sheetObject.ColSaveName(Col) == prefix+"yd_cd"){
			
			formObj.port_cd.value 	= sheetObject.CellValue(Row, prefix + "port_cd");	
			var tempPortCd 			= formObj.port_cd.value;

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
		}
	}
}

function sheet2_OnComboChange(sheetObj,Row, Col, Code, Text){
	
	//alert('sheet2_OnComboChange');
	
	var formObj 	= document.form;
	var prefix 		= "sheet2_";
	var tempYdCd 	= sheetObj.CellValue(Row,Col);
	var portCd 		= sheetObj.CellValue(Row,Col-1);
	var ydCd 		= "";

	if(tempYdCd != "" && portCd != ""){
		if(Col == 5){
			formObj.yd_cd.value = portCd+tempYdCd;	
			var sXml 		= doActionIBSheet	(sheetObj, formObj, SEARCH04);
			var mnvrInHrs 	= ComGetEtcData		(sXml, "mnvr_in_hrs");
			var mnvrOutHrs 	= ComGetEtcData		(sXml, "mnvr_out_hrs");
			
			sheetObj.CellValue(Row,prefix+"mnvr_in_hrs") 	= mnvrInHrs;
			sheetObj.CellValue(Row,prefix+"mnvr_out_hrs") 	= mnvrOutHrs;
		}
		
	}
	
}
/**
 * SHEET2 그리드 데이타 change 이벤트
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	 
	//alert('sheet2_OnChange');

	var prefix 		= sheetObj.id + "_";
	var cnt 		= sheetObj.RowCount + sheetObj.HeaderRows;
	var formObj 	= document.form;
	
	//::jskjskjsk::2013-04-29::///////////////////////////////////////////////
	
	//alert('Row '+Row+',  Col '+Col);
	//alert('ColSaveName ['+sheetObj.ColSaveName(Col)+']');
	
	if(Row > 1 && Col > 0){
		if(sheetObj.ColSaveName(Col) == prefix+"port_cd"){
			
			
			
			formObj.port_cd.value 	= sheetObj.CellValue(Row, prefix + "port_cd");	
			var tempPortCd 			= formObj.port_cd.value;

			if(tempPortCd.length == 5){
				
				// 이미 combo가 조회되어 yd_cd가 2개 이상이면 재조회 하지 않는다.
				var ydCdArr = sheetObj.GetComboInfo(Row, prefix + "yd_cd", "Code");
				
				//alert('ydCdArr ['+ydCdArr.split("|").length+']');
				
				////if(ydCdArr.split("|").length == 1){
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH05);
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetComboSinc(sXml, sheetObj, Row, Col);
					}
				////}
			}
		}
	}	
	
	//////////////////////////////////////////////////////////////////////////	

	if(Row > 2){
		if(Col == 3){
			for(var i=Row; i<=cnt+Row; i++){
				sheetObj.CellValue2(i,prefix+"skd_dir_cd") = Value;
			}
		}else if(Col == 4){

//초기에 sheet2_OnKeyUp 이벤트에서 5자리로  이벤트를 잡았는데
//후에 port_cd의 validtion 체트 (3자를 넣어도 체크를 할 수 있도록 요청)때문에
//sheet2_OnChange로 이벤트를 바꿈 
//그래서  sheet2_OnChange에서는 port_cd 사이즈로는 이벤트를 자동으로 발생시킬 수가 없음
			
			var headCnt 	= sheetObj.HeaderRows;
			var rowCnt 		= sheetObj.RowCount;
			var totalCnt 	= headCnt+rowCnt;
			var currPos 	= (sheetObj.SelectRow - headCnt)+1;
			var currRow 	= sheetObj.SelectRow;
			
			var tempVal = sheetObj.EditValue;
			
			if(currPos == 1 && rowCnt == 1){ // Retrieve 하지 않고 Row Add 버튼을 눌러 하나의 Row를 생성한 경우
				if(Value.length == 0){ // 기존 Port Code 값을 지운 경우
					return;
				}
			}
			
			if(Value.length == 5){
				formObj.port_cd.value = Value;		
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
				
				var chkPort = ComGetEtcData(sXml, "check_port");
				
				if(chkPort == "X"){ // 존재하는 Port Code 인 경우
					if(sXml != null && sXml != undefined && sXml != ""){
						var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
						xmlDoc.loadXML(sXml);
	
//						// Terminal Code 리스트가 있으면 콤보에 반영한다.
//						var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
//						if(dataNode){
//							var totValue = dataNode.value;
//	
//							if(totValue > 0){
//								setSheetComboSinc(sXml, sheetObj, Row, Col);
//							}else{
//								setSheetClearCombo(sheetObj, Row, Col);
//								sheetObj.CellValue2(Row, sheetObj.id+"_yd_cd") = "";
//							}
//						}
					}
					
					var portInfoCnt 	= Number(ComGetEtcData(sXml, "portInfoCnt"));
					var currPos 		= Number(ComGetEtcData(sXml, "currPos"));
					var dataPos 		= ComGetEtcData(sXml, "dataPos");
					var oneDataPos 		= 0;
					var twoFromDataPos 	= 0;
					var twoToDataPos 	= 0;
					
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
							sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[2];
							sheetObj.CellValue(oneDataPos,prefix+"port_buf_hrs") = dataValArr[3];
							sheetObj.CellValue(oneDataPos,prefix+"crn_knt") = dataValArr[4];
							sheetObj.CellValue(oneDataPos,prefix+"tml_prod_qty") = dataValArr[5];
						//현재 포트가 두번째 로우 이고 전체 로우가 두개일때	
						}else if(dataPos == "F"){
							//현재 포트의 전 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") = dataValArr[0];
							sheetObj.CellValue(oneDataPos,prefix+"zd") = dataValArr[1];
							
							//현재 포트
							sheetObj.CellValue(oneDataPos+1,prefix+"port_buf_hrs") = dataValArr[3];
							sheetObj.CellValue(oneDataPos+1,prefix+"crn_knt") = dataValArr[4];
							sheetObj.CellValue(oneDataPos+1,prefix+"tml_prod_qty") = dataValArr[5];
							sheetObj.CellValue(oneDataPos+1,prefix+"zd") = dataValArr[2];
						//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
						}else if(dataPos == "T"){
							//현재 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") 		= dataValArr[0];
							sheetObj.CellValue(oneDataPos,prefix+"zd") 				= dataValArr[1];
							sheetObj.CellValue(oneDataPos,prefix+"port_buf_hrs") 	= dataValArr[3];
							sheetObj.CellValue(oneDataPos,prefix+"crn_knt") 		= dataValArr[4];
							sheetObj.CellValue(oneDataPos,prefix+"tml_prod_qty") 	= dataValArr[5];
							//다음 포트
							sheetObj.CellValue(oneDataPos+1,prefix+"zd") 			= dataValArr[2];
						//현재 포트가 마지  막 로우일때		
						}else if(dataPos == "E"){
							//전 포트
							sheetObj.CellValue(oneDataPos,prefix+"lnk_dist") 		= dataValArr[0];
							sheetObj.CellValue(oneDataPos,prefix+"zd") 				= dataValArr[1];
							//현재 포트
							sheetObj.CellValue(oneDataPos+1,prefix+"port_buf_hrs") 	= dataValArr[3];
							sheetObj.CellValue(oneDataPos+1,prefix+"crn_knt") 		= dataValArr[4];
							sheetObj.CellValue(oneDataPos+1,prefix+"tml_prod_qty") 	= dataValArr[5];
							sheetObj.CellValue(oneDataPos+1,prefix+"zd") 			= dataValArr[2];
						}
						
					//현재 포트와 전,후 포트 모두 조회시
					}else{
						var oneDataVal = ComGetEtcData(sXml, "one_row");
						var twoDataVal = ComGetEtcData(sXml, "two_row");
						var oneDataValArr = oneDataVal.split("|");
						var twoDataValArr = twoDataVal.split("|");
						
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						sheetObj.CellValue(twoFromDataPos,prefix+"lnk_dist") = oneDataValArr[0];
						sheetObj.CellValue(twoFromDataPos,prefix+"zd")		 = oneDataValArr[1];
						
						sheetObj.CellValue(currPos,prefix+"port_buf_hrs") 	= oneDataValArr[3];
						sheetObj.CellValue(currPos,prefix+"crn_knt") 		= oneDataValArr[4];
						sheetObj.CellValue(currPos,prefix+"tml_prod_qty") 	= oneDataValArr[5];
						sheetObj.CellValue(currPos,prefix+"lnk_dist") 		= twoDataValArr[0];
						sheetObj.CellValue(currPos,prefix+"zd") 			= oneDataValArr[2];
						
						sheetObj.CellValue(twoToDataPos,prefix+"zd") 		= twoDataValArr[2];
						
					}
					
					sheetObj.SelectCell(Row, Col, true);
				
				}else{	// 존재하지 않는 Port Code를 입력한 경우
					ComShowCodeMessage('VSK00029', Value);
					sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
					sheetObj.CellValue(Row,"sheet2_zd") = "";
					sheetObj.SelectCell(Row, Col-1, true);
				}
			}else{
				ComShowCodeMessage('VSK00029', tempVal);
				sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
				sheetObj.CellValue(Row,"sheet2_zd") = "";
				sheetObj.SelectCell(Row, Col-1, true);
			}
		}else if(Col == 7){
			var tempEtbDyNo = parseInt(sheetObj.CellValue(Row, Col));

			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				ComShowCodeMessage('VSK00041');
				sheetObj.CellValue(Row, Col) = 0;
				sheetObj.SelectCell(Row, Col, true);
			}
		}else if(Col == 9){
			var tempEtbTmHrmnt = parseInt(sheetObj.CellValue(Row, Col));
			
			if(tempEtbTmHrmnt != 0){
				sheetObj.SelectCell(Row, 16, true);
			}
		}else if(Col == 28){
			var tempPortFlg = sheetObj.CellValue(Row, Col);
			sheetObj.CellValue(Row, Col+1) = tempPortFlg;
		}
	}
}

/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
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
		
		sheetObject.CellComboItem(Row, sheetObject.id+"_yd_cd", ydTxt, ydKindCode);

	}
}

/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1,sheetObj2,formObj){
	formObj.vsl_slan_cd.value = "";
	formObj.pf_svc_tp_cd.value = "";
	formObj.brth_itval_dys.value = "";
	formObj.slan_stnd_flg.value = "N";
	//formObj.n1st_vsl_clss_cd.value = "";
	comboObjects[0].Index2 = -1;
	formObj.n1st_vsl_clss_knt.value = "";
	//formObj.n2nd_vsl_clss_cd.value = "";
	comboObjects[1].Index2 = -1;
	formObj.n2nd_vsl_clss_knt.value = "";
	//formObj.n3rd_vsl_clss_cd.value = "";
	comboObjects[2].Index2 = -1;
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";
	formObj.mml_usd_flg.value = "N";
	formObj.upd_dt.value = "";
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
	
	formObj.brth_itval_dys.disabled 	= false;
	
	//formObj.n1st_vsl_clss_cd.disabled = false;
	comboObjects[0].Enable 				= true;
	formObj.n1st_vsl_clss_knt.disabled = false;
	//formObj.n2nd_vsl_clss_cd.disabled = false;
	comboObjects[1].Enable 				= true;
	formObj.n2nd_vsl_clss_knt.disabled 	= false;
	//formObj.n3rd_vsl_clss_cd.disabled = false;
	comboObjects[2].Enable 				= true;
	formObj.n3rd_vsl_clss_knt.disabled 	= false;
	formObj.svc_dur_dys.disabled 		= false;

	sheetObj2.Editable = true;
	
	sheetObj1.RemoveAll();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll();
	
	ComBtnEnable("btn_RowAdd");
	ComBtnEnable("btn_RowInsert");
	ComBtnEnable("btn_RowDelete");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_MSimulation");
	ComBtnEnable("btn_ASimulation");
	
	formObj.vsl_slan_cd.focus();
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
 	
 	ComBtnEnable("btn_RowAdd");
 	ComBtnEnable("btn_RowInsert");
 	ComBtnEnable("btn_RowDelete");
 	ComBtnEnable("btn_Delete");
 	ComBtnEnable("btn_MSimulation");
 	ComBtnEnable("btn_ASimulation");
 	
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
	 var targetObjList = "sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display = "0,0";
	 var laneCd = document.form.vsl_slan_cd.value;
	 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 490, targetObjList, v_display, true);
}

/**
 * P/F Skd History 파일을 오픈한다  
 */
function openPfSkdHistoryHelp(sheetObj){
	var formObj = document.form;
	
	 var vslSlanCd = formObj.vsl_slan_cd.value;
	 var pfSvcTpCd = formObj.pf_svc_tp_cd.value;
	 
	 if(vslSlanCd == "" || vslSlanCd.length == 0){
		 ComShowCodeMessage('VSK00027', "Lane Code");
		 formObj.vsl_slan_cd.focus();
		 return;
	 }
	 
	 if(pfSvcTpCd == "" || pfSvcTpCd.length == 0){
		 ComShowCodeMessage('VSK00027', "P/F SKD Type");
		 formObj.pf_svc_tp_cd.focus();
		 return;
	 }
	 var targetObjList = "sheet1_upd_dt:upd_dt";
	 var v_display = "0,0";
	 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0248.do?vsl_slan_cd='+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd, 700, 508, targetObjList, v_display, true);
	 
	 //var tempUpdDt = formObj.upd_dt.value;
	 //var tempVal = tempUpdDt.substring(0,4)+"-"+tempUpdDt.substring(4,6)+"-"+tempUpdDt.substring(6,8)+" "+tempUpdDt.substring(8,10)+":"+tempUpdDt.substring(10,12);
	 //formObj.upd_dt.value = tempVal;
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	
		case COMMAND03:      //::2013-04-18::EXCEL UPLOAD 유효성체크:://
		
		if(ComIsNull(formObj.vsl_slan_cd.value)){
			ComShowCodeMessage('VSK00027', "Lane Code");
			formObj.vsl_slan_cd.focus();
			return false;
		}
		
		if(ComIsNull(formObj.pf_svc_tp_cd.value)){
			ComShowCodeMessage('VSK00027', "P/F SKD Type");
			formObj.pf_svc_tp_cd.focus()
			return false;
		}
		
		if(formObj.vsl_slan_cd.value.length < 3){
			ComShowCodeMessage("VSK01018", "Lane Code");
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.focus();
			
			return false;
		}
		break;
		
		case IBSEARCH:      //조회
			
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			break;
			
		case "Msimul": 
			var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
			var prefix = sheetObj.id + "_";
			
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
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
			
			if(sheetObjects[1].RowCount < 1){
				ComShowCodeMessage("VSK00012");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount+2; i++){
					
					if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
					/*
					if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
						ComShowCodeMessage("VSK01018", "[Terminal Code]");
						sheetObj.SelectCell(i,"sheet2_yd_cd");
						return false;
					}
					*/
				}
			}
			break;		

		case "Asimul":      //저장
			var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
			var prefix = sheetObj.id + "_";
			/*
			 * <필수 여부 검사>
			 * 1. Lane Code 3자리 확인.
			 * 4. Grid내에 Calling Port가 2개 이상 있어야 한다.
			 * 5. Calling Port Indicator를 설정한다.
			 * 6. Calling Sequence를 설정
			 * 7. Turn IND = 'Y' 일 경우 Turning Port 입력 여부 확인.
			 * 8. 첫번째 Port에 ETA ~마지막 Port에 ETD까지 날짜 확인.
			 *    항상 ETA < ETB < ETD < Next ETA 순서를 유지.
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

			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
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
			
			if(sheetObjects[1].RowCount < 2){
				ComShowCodeMessage("VSK00036");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount+2; i++){
					
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
			}

			break;
			
		case IBSAVE:      //저장
			var prefix 	= sheetObj.id + "_";
			var headCnt = sheetObj.HeaderRows;
			var totCnt 	= sheetObj.LastRow;

			//###########################################################
			// Proforma Schedule Master 정보에 대해서 Validation
			//###########################################################
			
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				formObj.vsl_slan_cd.focus()
				ComShowCodeMessage('VSK00027', "Lane Code");
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				formObj.pf_svc_tp_cd.focus()
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				ComShowCodeMessage('VSK00027', "Lane Code");
				return false;
			}
			
			if(ComIsNull(comboObjects[0].Code)){
				comboObjects[0].focus();
				ComShowCodeMessage('VSK00027', "1st Vessel Class");
				return false;
			}
			
			if(ComIsNull(formObj.n1st_vsl_clss_knt.value) || formObj.n1st_vsl_clss_knt.value == "0"){
				formObj.n1st_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK00027', "1st Vessel Count");
				return false;
			}

			var vslClssCd1 = comboObjects[0].Text;
			var vslClssCd2 = comboObjects[1].Text;
			var vslClssCd3 = comboObjects[2].Text;
			var	comVslClss = 0;
			
			if(VskIsNull(vslClssCd1)){
				comboObjects[0].focus();
				ComShowCodeMessage('VSK00099', vslClssCd1);
				return false;
			}
			
			if(ComIsNull(vslClssCd2) && (formObj.n2nd_vsl_clss_knt.value > 0)) {
				comboObjects[1].focus();
				ComShowCodeMessage('VSK01017', "2nd Vessel Class");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			
			if (!ComIsNull(vslClssCd2) && ((formObj.n2nd_vsl_clss_knt.value == 0) || (formObj.n2nd_vsl_clss_knt.value == ""))) {
				formObj.n2nd_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK01017', "2nd Vessel Count");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			
			if(ComIsNull(vslClssCd3) && (formObj.n3rd_vsl_clss_knt.value > 0)) {
				comboObjects[2].focus();
				ComShowCodeMessage('VSK01017', "3th Vessel Class");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			
			if(!ComIsNull(vslClssCd3) && ((formObj.n3rd_vsl_clss_knt.value == 0) || (formObj.n3rd_vsl_clss_knt.value == ""))) {
				formObj.n3rd_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK01017', "3th Vessel Count");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			
			if(VskIsNotNull(vslClssCd1) && VskIsNotNull(vslClssCd2)){
				if (vslClssCd1 == vslClssCd2) {
					comboObjects[1].focus();
					ComShowCodeMessage('VSK00099', vslClssCd2);
					return false;
				};
			}

			if(VskIsNotNull(vslClssCd1) && VskIsNotNull(vslClssCd3)){
				if (vslClssCd1 == vslClssCd3) {
					comboObjects[2].focus();
					ComShowCodeMessage('VSK00099', vslClssCd3);
					return false;
				}
			}
			
			if(VskIsNotNull(vslClssCd2) && VskIsNotNull(vslClssCd3)){
				if (vslClssCd2 == vslClssCd3) {
					comboObjects[2].focus();
					ComShowCodeMessage('VSK00099', vslClssCd3);
					return false;
				}
			}
			
			if (ComIsNull(vslClssCd2) && !ComIsNull(vslClssCd3)) {
				comboObjects[1].Text = vslClssCd3;
				formObj.n2nd_vsl_clss_knt.value	= formObj.n3rd_vsl_clss_knt.value;
				comboObjects[2].Text = "";
				formObj.n3rd_vsl_clss_knt.value ="";
			}
			
			if(ComIsNull(formObj.svc_dur_dys.value) || (formObj.svc_dur_dys.value == 0)) {
				formObj.svc_dur_dys.focus();
				ComShowCodeMessage('VSK01017', "Duration");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}			
			
			if(ComIsNull(formObj.brth_itval_dys.value) || (formObj.brth_itval_dys.value == 0)) {
				formObj.brth_itval_dys.focus();
				ComShowCodeMessage('VSK01017', "Frequency");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			
			if(sheetObj.RowCount < 2){
				ComShowCodeMessage("VSK00036");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			//###########################################################
			// Proforma Schedule Detail 정보에 대해서 Validation
			//###########################################################
			
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
			
//			// Duration을 Vessel의 척수로 나눈 값은 Frequence와 동일해야 한다.
//			var vslCnt = Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
//			var frequency = Number(formObj.brth_itval_dys.value);
//			if((dur1/vslCnt)!=frequency){
//				ComShowCodeMessage("VSK00096", "Frequency or Vessel Class Count");
//				return false;
//			}
			
			if(totCnt > headCnt){
				for(var i=headCnt; i<=totCnt; i++){
					if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
						sheetObj.SelectCell(i,prefix+"port_cd");
						ComShowCodeMessage("VSK01018", "Port Code");
						return false;
					}

					if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
						sheetObj.SelectCell(i,prefix+"yd_cd");
						ComShowCodeMessage("VSK01018", "Terminal Code");
						return false;
					}
				}
			}
						
			//2008 10 29 임창빈 수석이 Feeder 나 Trunker 상관없이 사용자가 입력한 
			//Manual에 따라 양방향, 단방향을 따진다

			var firstDirCd	= sheetObj.CellValue(headCnt,prefix+"skd_dir_cd");
			var otherDirCd	= 0;
		
			//첫번째 포트의 Dir Cd와 다른 Dir Cd를 찾는다
			//사용자가 입력한 Dir Cd가 단 방향인지 (예 : 모든 Dir Cd가 W 아님 E )일 경우는 첫번째 포트의 Port Cd와 Yd Cd가 마지막 포트의 Port Cd, Yd Cd가  다르더라도 무방
			//사용자가 입력한 Dir Cd가 양 방향인지 (예 : Dir Cdrk W -> E, 아님 N -> S)일 경우는 첫번째 포트와 마지막 포트의 Port Cd와 Yd Cd가 같아야 한다
			for(var i=headCnt; i<=totCnt; i++){
				//처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
				if(sheetObj.CellValue(i,prefix+"skd_dir_cd") != firstDirCd){
					otherDirCd = i;
					break;
				}
			}
	
			// 첫번째 포트의 Dir Cd와 다른 Dir Cd가 있을 경우  => 양 방향일경우
			if(otherDirCd > 0){
				if(sheetObj.CellValue(headCnt,prefix+"port_cd") == sheetObj.CellValue(totCnt,prefix+"port_cd")
					&& sheetObj.CellValue(headCnt,prefix+"yd_cd") == sheetObj.CellValue(totCnt,prefix+"yd_cd")
					//&& sheetObj.CellValue(headCnt,prefix+"etb_dy_cd") == sheetObj.CellValue(totCnt,prefix+"etb_dy_cd")
					&& sheetObj.CellValue(headCnt,prefix+"etb_tm_hrmnt") == sheetObj.CellValue(totCnt,prefix+"etb_tm_hrmnt")
					){
						// 첫번째, 마지막 Row에 Port, Yard, ETB, ETB Hour이 동일할 경우 마지막 Row에 ETD에 Day, Hour를 첫번째 Row와 동일 하게 생성한다.
						// Long Range SKD 생성시 필요함.
						sheetObj.CellValue(totCnt,prefix+"etd_dy_cd") 	= sheetObj.CellValue(headCnt,prefix+"etd_dy_cd");
						sheetObj.CellValue(totCnt,prefix+"etd_tm_hrmnt") = sheetObj.CellValue(headCnt,prefix+"etd_tm_hrmnt");
				}else{
					ComShowCodeMessage("VSK00084");
					if(sheetObj.CellValue(headCnt,prefix+"port_cd") != sheetObj.CellValue(totCnt,prefix+"port_cd")){
						sheetObj.SelectCell(headCnt,prefix+"port_cd", true);
					}else if(sheetObj.CellValue(headCnt,prefix+"yd_cd") != sheetObj.CellValue(totCnt,prefix+"yd_cd")){
						sheetObj.SelectCell(headCnt,prefix+"yd_cd", true);
					//}else if(sheetObj.CellValue(headCnt,prefix+"etb_dy_cd") != sheetObj.CellValue(totCnt,prefix+"etb_dy_cd")){
					//	sheetObj.SelectCell(headCnt,prefix+"etb_dy_cd", true);
					}else if(sheetObj.CellValue(headCnt,prefix+"etb_tm_hrmnt") != sheetObj.CellValue(totCnt,prefix+"etb_tm_hrmnt")){
						sheetObj.SelectCell(headCnt,prefix+"etb_tm_hrmnt", true);
					}
					return false;
				}
			}
			
			/**************************************************************
			 * Hidden Grid을 Server에 올리기 위해 Flag 조작 
			 **************************************************************/
//			sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I";
			sheetObjects[0].RowStatus(1) = "I";

		    //2009 12 15 임수석 수정요청
			//Direction이 바뀌더라도 Turning Port Indicator를 Y로 수정하지 않더라도 무방함
			
			var otherDirTurnCnt = 0;
			for(var i=headCnt; i<=totCnt; i++){
			    //처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
			    if(sheetObj.CellValue(i,prefix+"skd_dir_cd") != firstDirCd){
				    if(sheetObj.CellValue(i,prefix+"turn_port_flg") == "Y"){
				  	    if(i != totCnt){				  	    	
				  	    	otherDirTurnCnt++;
					    }
				    }
			    }			    
			    //Hidden Grid, Detail Grid 전체을 Server에 올리기 위해 Flag 조작
//			    sheetObj.CellValue(i,prefix+"ibflag") = "I"; 
			    sheetObj.RowStatus(i) = "I";
		    }
			
			// CHM-201006736-01 아래 제한 조건 해제. Trunk인 경우에도 단방향 서비스 가능
//			//Direction이  바뀐경우 : 양방향일때
//			if(otherDirCd > 0){
//				if(otherDirTurnCnt < 1){
//					// 양방향인데 Turn Flag Count가 0인 경우
//					// 즉 두번째 Direction에 Turning Port가 하나도 없을 경우 메세지 발생.
//					ComShowCodeMessage('VSK00008');
//					return false;
//				}
//			}

		   for(var i=headCnt; i<=totCnt; i++){
			   if(sheetObj.CellValue(i, prefix+"turn_port_flg").length < 1){
					ComShowCodeMessage("VSK01018", "T/Port IND(N/Y)");
					sheetObj.SelectCell(i,prefix+"turn_port_flg");
					return false;
				}
				
				var portCd		= sheetObj.CellValue(i, prefix+"port_cd");
				var etbDyNo 	= sheetObj.CellValue(i, prefix+"etb_dy_no");
				var etbTmHrmnt 	= sheetObj.CellValue(i, prefix+"etb_tm_hrmnt");
				var etdDyNo 	= sheetObj.CellValue(i, prefix+"etd_dy_no");
				var etdTmHrmnt 	= sheetObj.CellValue(i, prefix+"etd_tm_hrmnt");
				
				// ETB, ETD가 순차적으로 입력되였는지 확인한다.
				if ( (i < totCnt) && (etbDyNo+etbTmHrmnt)*1 >= (etdDyNo+etdTmHrmnt)*1 ) {
					sheetObj.SelectCell(i,prefix+"etb_dy_no");
					ComShowCodeMessage("VSK01018", "Seq : " +(i-headCnt+1)+ " (" +portCd+ ")ETB >= ETD");
					return false;
				}
				
				// Pre ETD, ETB가 순적적으로 입력되였는지 확인한다.
				if (i > headCnt) {
					var PrePortCd		= sheetObj.CellValue(i-1, prefix+"port_cd");
					var preEtdDyNo 		= sheetObj.CellValue(i-1, prefix+"etd_dy_no");
					var preEtdTmHrmnt 	= sheetObj.CellValue(i-1, prefix+"etd_tm_hrmnt");
					
					if ((preEtdDyNo+preEtdTmHrmnt)*1 >= (etbDyNo+etbTmHrmnt)*1) {
						sheetObj.SelectCell(i,prefix+"etb_dy_no");
						ComShowCodeMessage("VSK01018", "Seq : " +(i-headCnt+1)+ " ( " +PrePortCd+ ") Previous ETD >= (" +portCd+ ") Current ETB");
						return false;
					}
				}
		   	}
			
			break;
			
		case "Remove":      //삭제
			var rowCnt = sheetObj.RowCount;
			var prefix = sheetObj.id + "_";

			if(rowCnt < 0){
				ComShowCodeMessage("VSK00043");
				return false;
			}

//			if(sheetObj.CellValue(1,"sheet1_ibflag") == "I"){
			if(sheetObj.RowStatus(1) == "I"){
				ComShowCodeMessage("VSK00043");
				return false;
			}

			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
		break;
		
		case "Remove02":      //Row Delete삭제
			var rowCnt = sheetObj.RowCount;
			var prefix = sheetObj.id + "_";
			
		break;	
		
		case "FileUpload": 
			var rowCnt = sheetObj.RowCount + sheetObj.HeaderRows;
			var prefix = sheetObj.id + "_";
			
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
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
	formObj.mml_usd_flg.value 	= "N";
	formObj.slan_stnd_flg.value = "N";

	var lastEtbDyNo 		= parseInt(sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount - 1,"sheet2_etb_dy_no"));
	var lastEtbTmHrmnt		= sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount - 1,"sheet2_etb_tm_hrmnt");
	
	var firstEtbDyNo 		= parseInt(sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_dy_no"));
	var firstEtbTmHrmnt 	= sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_tm_hrmnt");
	
	var tempLastEtbTmHrmnt 	= lastEtbTmHrmnt.length;
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

	// Duration, Frequency는 소수점 첫째짜리까지만 사용. 그 이하는 모두 버림
	var durVal1 = tempDur/24;
	durVal1 = parseInt(durVal1 * 10); // 소수점 첫제짜리이하 숫자 삭제
	durVal1 = parseFloat(durVal1/10);
	
	var resultDurVal = isNaN(durVal1);
	
	if(resultDurVal == true){
		durVal1 = 0;
	}
	
	formObj.svc_dur_dys.value = durVal1;
	
	
	// Frequency
	var vslCnt = Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
	var frequency = durVal1/vslCnt;
	frequency = Math.round(parseInt(frequency * 10))/10;
	formObj.brth_itval_dys.value = frequency;	
	
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
	
	if(sheetObj.RowCount  > 0){
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

	if(sheetObj.RowCount > 0){
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
		sheetObjects[1].CellEditable(rdInx, prefix+"tml_prod_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"crn_knt") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"turn_port_flg") = true;
		
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
		//sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
	}
}

/**
 * CLPT_SEQ 순차적으로 다시 생성
 * @param sheetObj
 * @return
 */

function resetRowSeq(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var prefix = sheetObj.id + "_";
	var idx = 0;
	var vIbFlag = "";
	
	for(var i=0; i<rowCnt; i++){
//		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//			vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//			idx++;
//			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
//			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
//		}
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
	var rtnIdx = 0;
	//그리드 내의 delete한 로우 갯수를 담는다
	var delCnt = 0
	
	for(var i=totalCnt-1; i>headCnt-1; i--){
		if(sheetObj.CellValue(i, 0) != "D"){
			idx = i;
			rtnIdx = idx+1;
				
			break;
		}
	}

	return rtnIdx;
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
 * 조회 조건이 아닌 모든 데이타 초기화.
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearDescData(sheetObj1, sheetObj2, formObj){

	formObj.brth_itval_dys.value = "";
	formObj.slan_stnd_flg.value = "N";
	//formObj.n1st_vsl_clss_cd.value = "";
	comboObjects[0].Index2 = -1;
	formObj.n1st_vsl_clss_knt.value = "";
	//formObj.n2nd_vsl_clss_cd.value = "";
	comboObjects[1].Index2 = -1;
	formObj.n2nd_vsl_clss_knt.value = "";
	//formObj.n3rd_vsl_clss_cd.value = "";
	comboObjects[2].Index2 = -1;
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";
	formObj.mml_usd_flg.value = "N";
	formObj.upd_dt.value = "";
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

	sheetObj1.RemoveAll();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll();
	
	//All Check 초기화
	sheetObj2.CheckAll(sheetObj2.id+"_Sel") = 0;
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

function setValCls(comboObj,val){
	var cnt = comboObj.GetCount;
	var comboPos = -1;
	
	for(var i=0; i<cnt; i++){
		if(comboObj.GetIndexText(i,0) == val){
			comboPos = i;
			break;
		}
	}
	
	if(comboPos >= 0){
		comboObj.Index2 =  comboPos;
	}else{
		comboObj.Index2 =  -1;
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

function sheet2_OnAfterEdit(sheetObj, Row,Col){
	var formObj = document.form;
	
	// 시트에 변경 사항이 발생하면
	// 시트 하단의 정보를 모드 클리어 한다.
	formObj.max_spd.value = "";
	formObj.sea_buf_rat.value = "";
	formObj.pf_spd_rat.value = "";
	formObj.tot_buf_rat.value = "";
	formObj.port_buf_rat.value = "";
	formObj.buf_spd_rat.value = "";
	
}

/* 개발자 작업  끝 */