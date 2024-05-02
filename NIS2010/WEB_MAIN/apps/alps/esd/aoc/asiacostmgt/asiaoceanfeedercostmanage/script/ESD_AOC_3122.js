/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3122.js
*@FileTitle : Ocean Feeder Cost Management(SHA)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
*
* History
* 2013.01.14 CHM-201322300 이혜민 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
* 2013.02.28 이재위 [CHM-201323053] [AOC] OCN FDR DG cargo Tab  상에서의 Scale up & down 설정변경
* 2013.03.19 이재위 [CHM-201323286] [AOC] OCN FDR management 화면 Delete function 관련 기능보완
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
     * @class ESD_AOC_3122 : esd_aoc_3122 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3122() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_click              = obj_click;
    }

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var tabNowCnt = 0;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0]; //sheet1
         var sheetObject2 = sheetObjects[1]; //sheet2
         var sheetObject3 = sheetObjects[2]; //sheet3
         var sheetObject4 = sheetObjects[3]; //sheet3
		 
         /*******************************************************/
         var formObject = document.form;
 		 var objs = document.all.item("tabLayer");
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, true);
						break;
						
					case "btn_confirm":
						ComSetObjValue(formObject.in_btn_sts, "C");
						if( sheetObject1.RowCount < 1 ){
							ComShowCodeMessage("AOC90016");
						}else{
							ComOpenWait(true);
							
							if(ComShowConfirm(ComGetMsg("AOC90011"))){
								getBtnSave();
								doActionIBSheet(sheetObject1, formObject, MULTI03, false);
							}
							ComOpenWait(false);
						}
						break;
					
					case "btn_confirm_cancel":
						if( sheetObject1.RowCount < 1 ){
							ComShowCodeMessage("AOC90016");
						}else{
							if(ComShowConfirm(ComGetMsg("AOC90025"))){
								doActionIBSheet(sheetObject1, formObject, MULTI04, false);
							}
						}
						break;

					case "btn_from":
						openHireYardPopup('getFrom_nod_cd');
						break;

					case "btn_to":
						openHireYardPopup('getTo_nod_cd');
						break;

					case "btn_apply1":
			            ComOpenWait(true, true);
			            setTimeout("getDryRfCostAdjustmentCal();ComOpenWait(false);", 100);
						break;
						
					case "btn_apply2":
			            ComOpenWait(true, true);
			            setTimeout("getDgCostAdjustmentCal();ComOpenWait(false);", 100);
						break;

					case "btn_reset1":
						initForm("btn_reset1");
						break;
						
					case "btn_reset2":
						initForm("btn_reset2");
						break;

					case "btn_save":
						ComSetObjValue(document.form.in_btn_sts, "S");
						setTimeout("getBtnSave();ComOpenWait(false);", 100);
						break;
						
					case "btn_delete":
						if( formObject.all.item("tabLayer")[0].style.display == "inline" ){
							formObject.cgo_tp_cd.value = "";
							doActionIBSheet(sheetObjects[0], formObject, MULTI06, true);   		//tab1
						} else if( document.all.item("tabLayer")[1].style.display == "inline" ){
							formObject.cgo_tp_cd.value = "DG";
							doActionIBSheet(sheetObjects[1], formObject, MULTI06, true);   		//tab2
						} else if( document.all.item("tabLayer")[2].style.display == "inline" ){
							formObject.cgo_tp_cd.value = "RF";
							doActionIBSheet(sheetObjects[2], formObject, MULTI06, true);   		//tab3
						}
						break;
						
					case "btn_cost_detail":
						if( objs[0].style.display == "inline" ){
							var sheetObj = sheetObjects[0];
							var acct_tbl_div = "AOC_CHN_FDR_TRF_ACCT";
						} else if( objs[2].style.display == "inline" ){
							var sheetObj = sheetObjects[2];
							var acct_tbl_div = "AOC_CHN_FDR_RF_TRF_ACCT";
						}
						
						if( sheetObj.RowCount > 0 ){
							var param = "";
							param = param + '?cost_trf_no=' 		+ sheetObj.CellValue(sheetObj.SelectRow,"cost_trf_no");
							param = param + '&cost_trf_rout_seq=' 	+ sheetObj.CellValue(sheetObj.SelectRow,"cost_trf_rout_seq");
							param = param + '&fm_nod_cd=' 			+ sheetObj.CellValue(sheetObj.SelectRow,"fm_nod_cd");
							param = param + '&to_nod_cd='			+ sheetObj.CellValue(sheetObj.SelectRow,"to_nod_cd");
							param = param + '&io_bnd_nm='			+ sheetObj.CellValue(sheetObj.SelectRow,"pctl_io_bnd_nm");
//							param = param + '&curr_cd='				+ formObject.curr_cd.value;
							param = param + '&ttlAmt20='			+ sheetObj.CellValue(sheetObj.SelectRow,"fdr_20ft_ttl_amt");
							param = param + '&ttlAmt40='			+ sheetObj.CellValue(sheetObj.SelectRow,"fdr_40ft_ttl_amt");
							param = param + '&acct_tbl_div=' 		+ acct_tbl_div;
							
							ComOpenPopup('/hanjin/ESD_AOC_3123.do' + param, 1024,620,'', '1,0,1,1,1,1,1,1');
						}
						break;
						
					case "btn_agmt_inq":
						if( objs[0].style.display == "inline" ){
							var sheetObj = sheetObjects[0];
						} else if( objs[1].style.display == "inline" ){
							var sheetObj = sheetObjects[1];
						} else if( objs[2].style.display == "inline" ){
							var sheetObj = sheetObjects[2];
						}
						
						//그리드 데이터 없을 경우
						if( sheetObj.RowCount <= 0 ){
							ComShowCodeMessage("COM130401");
							return;
						}
						
						
						var sUrl = "/hanjin/ESD_TRS_0231.do";
						var param = '?from=' + sheetObj.CellValue(sheetObj.SelectRow,"fm_nod_cd").substr(0,5);
						param = param + '&to=' + sheetObj.CellValue(sheetObj.SelectRow,"to_nod_cd").substr(0,5);
						param = param + '&vndr_seq=' + sheetObj.CellValue(sheetObj.SelectRow,"vndr_seq");
						param = param + '&vndr_nm=' + sheetObj.CellValue(sheetObj.SelectRow,"vndr_nm");
						var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
						window.open(sUrl + param, "ESD_TRS_0231", myOption);
						break;
						
					case "btn_down_excel":
						if( objs[0].style.display == "inline" ){
							sheetObject1.SpeedDown2Excel(1);
						} else if( objs[1].style.display == "inline" ){
							sheetObject2.SpeedDown2Excel(1);
						} else if( objs[2].style.display == "inline" ){
							sheetObject3.SpeedDown2Excel(1);
						}
						break;

					case "btn_load_excel":
						if( objs[0].style.display == "inline" ){
							if( sheetObjects[0].RowCount < 1 ){
								ComShowCodeMessage("AOC90003");
								return;
							}
							var sheetObjOrg = sheetObjects[0];
							var sheetObjExl	= sheetObjects[3];
						} else if( objs[1].style.display == "inline" ){
							if( sheetObjects[1].RowCount < 1 ){
								ComShowCodeMessage("AOC90003");
								return;
							}
							var sheetObjOrg = sheetObjects[1];
							var sheetObjExl	= sheetObjects[4];
						} else if( objs[2].style.display == "inline" ){
							if( sheetObjects[2].RowCount < 1 ){
								ComShowCodeMessage("AOC90003");
								return;
							}
							var sheetObjOrg = sheetObjects[2];
							var sheetObjExl	= sheetObjects[5];
						}
						
						ComOpenWait(true);
						sheetObjExl.RemoveAll();

						var vLoadFlg = sheetObjExl.LoadExcel(-1, 1, "", 1, -1, "", true, false);
						if(vLoadFlg){
							sheetCopy(sheetObjOrg, sheetObjExl);
						}else{
							ComOpenWait(false);
						}
						break;

				} // end switch
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }

		initControl();
        axon_event.addListenerForm('click', 'obj_click', form);	 

		
		var formObj = document.form;
		//Cost Tariff No MultiCombo 생성
		formObj.f_cmd.value = SEARCH02;
		var sParam = AocFrmQryString(formObj);
		var sXml = sheetObjects[3].GetSearchXml("ESD_AOC_3122GS.do", sParam);
		ComXml2ComboItem(sXml, comboObjects[0], "cost_trf_no", "cost_trf_no");
		
		if(!ComIsEmpty(formObj.trf_no.value))
		{
			comboObjects[0].Code = ComGetObjValue(formObj.trf_no);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);
		}
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
		
		//가져온 행을 배열로 반든다.
		var arrRow2Code = f_sys_src_cdCode.split("|");
		var arrRow2Text = f_sys_src_cdText.split("|");
		
   	    switch(comboObj.id) {
	   	 	case "co_trans20":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "co_trans40":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "co_tmnl20":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "co_tmnl40":  
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "co_mty20":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					InsertItem(i++, "-SYS AMT", "S");
					comboObj.Code = "R";
				}
				break;
				
			case "co_mty40":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					InsertItem(i++, "-SYS AMT", "S");
					comboObj.Code = "R";
				}
				break;
				
			case "co_tran_mode":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow.length; j++){
						InsertItem(i++,  arrRow[j],  arrRow[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_trans20_src":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_mty20_src":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_tmnl20_src":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_trans40_src":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_mty40_src":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_tmnl40_src":			
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "class1_combo":
				with(comboObj) {
					MultiSelect = true;
					DropHeight = 200;
					MultiSelect = true;
					MultiSeparator= ",";
					UseEdit = false;
					
					InsertItem(i++, "Class1", "Class1-1");
					InsertItem(i++, "Class2", "Class2-1");
					InsertItem(i++, "Class3", "Class3-1");
					InsertItem(i++, "Class4", "Class4-1");
					InsertItem(i++, "Class5", "Class5-1");
					InsertItem(i++, "Class6", "Class6-1");
					InsertItem(i++, "Class7", "Class7-1");
					InsertItem(i++, "Class8", "Class8-1");
					InsertItem(i++, "Class9", "Class9-1");
				}
				break;
				
			case "class2_combo":
				with(comboObj) {
					MultiSelect = true;
					DropHeight = 200;
					MultiSelect = true;
					MultiSeparator= ",";
					UseEdit = false;
					
					InsertItem(i++, "Class1", "Class1-2");
					InsertItem(i++, "Class2", "Class2-2");
					InsertItem(i++, "Class3", "Class3-2");
					InsertItem(i++, "Class4", "Class4-2");
					InsertItem(i++, "Class5", "Class5-2");
					InsertItem(i++, "Class6", "Class6-2");
					InsertItem(i++, "Class7", "Class7-2");
					InsertItem(i++, "Class8", "Class8-2");
					InsertItem(i++, "Class9", "Class9-2");
				}
				break;
				
			case "class3_combo":
				with(comboObj) {
					MultiSelect = true;
					DropHeight = 200;
					MultiSelect = true;
					MultiSeparator= ",";
					UseEdit = false;
					
					InsertItem(i++, "Class1", "Class1-3");
					InsertItem(i++, "Class2", "Class2-3");
					InsertItem(i++, "Class3", "Class3-3");
					InsertItem(i++, "Class4", "Class4-3");
					InsertItem(i++, "Class5", "Class5-3");
					InsertItem(i++, "Class6", "Class6-3");
					InsertItem(i++, "Class7", "Class7-3");
					InsertItem(i++, "Class8", "Class8-3");
					InsertItem(i++, "Class9", "Class9-3");
				}
				break;
				
			case "class1_svc":
				with(comboObj) {
					InsertItem(i++, "Y", "Y");					
					InsertItem(i++, "N", "N");
					comboObj.Code = "Y";
				}
				break;
				
			case "class2_svc":
				with(comboObj) {
					InsertItem(i++, "Y", "Y");					
					InsertItem(i++, "N", "N");
					comboObj.Code = "Y";
				}
				break;
				
			case "class3_svc":
				with(comboObj) {
					InsertItem(i++, "Y", "Y");					
					InsertItem(i++, "N", "N");
					comboObj.Code = "Y";
				}
				break;

			case "class1_ind":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "class2_ind":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "class3_ind":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "class1_cntr":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					
					InsertItem(i++, "All",  "^");
					InsertItem(i++, "20'", "D2");
					InsertItem(i++, "40'", "D4");
					comboObj.Code = "^";
				}
				break;
				
			case "class2_cntr":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					
					InsertItem(i++, "All",  "^");
					InsertItem(i++, "20'", "D2");
					InsertItem(i++, "40'", "D4");
					comboObj.Code = "^";
				}
				break;
				
			case "class3_cntr":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					
					InsertItem(i++, "All",  "^");
					InsertItem(i++, "20'", "D2");
					InsertItem(i++, "40'", "D4");
					comboObj.Code = "^";
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
        	case "sheet1":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 310;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|Feeder Term|Feeder Term|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Load Excel\nValidation";

					var HeadTitle2 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|RCV|DEL|20'|40'|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS2|Weight\n(AGMT)|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS4|Weight\n(AGMT)|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Load Excel\nValidation";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_20ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_20ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_40ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_40ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_20ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_40ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		false);
				}
				break;

            case "sheet2":
                with (sheetObj) {
					// 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "||cost_trf_no|cost_trf_rout_seq|From|To|BND|BND|DIR|Feeder Term|Feeder Term";
					HeadTitle1 += "|Service Provider|Service Provider|OLD AGMT|Dry Cost|Dry Cost";
					HeadTitle1 += "|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1";
					HeadTitle1 += "|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2";
					HeadTitle1 += "|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3";
					HeadTitle1 += "|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4";
					HeadTitle1 += "|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5";
					HeadTitle1 += "|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6";
					HeadTitle1 += "|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7";
					HeadTitle1 += "|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8";
					HeadTitle1 += "|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9";
					HeadTitle1 += "|Load Excel\nValidation";

					var HeadTitle2 = "||cost_trf_no|cost_trf_rout_seq|From|To|BND|BND|DIR|RCV|DEL";
					HeadTitle2 += "|Code|Name|OLD AGMT|20'|40'";
					HeadTitle2 += "|SVC_1|20' SCHG_1|40' SCHG_1|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_2|20' SCHG_2|40' SCHG_2|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_3|20' SCHG_3|40' SCHG_3|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_4|20' SCHG_4|40' SCHG_4|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_5|20' SCHG_5|40' SCHG_5|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_6|20' SCHG_6|40' SCHG_6|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_7|20' SCHG_7|40' SCHG_7|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_8|20' SCHG_8|40' SCHG_8|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_9|20' SCHG_9|40' SCHG_9|20' TTL|40' TTL";
					HeadTitle2 += "|Load Excel\nValidation";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
	                InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
	                InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		false);
	                InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"pctl_io_bnd_cd",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n1st_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n1st_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n1st_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n2nd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n2nd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n2nd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n3rd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n3rd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n3rd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n4th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n4th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n4th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n5th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n5th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n5th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n6th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n6th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n6th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n7th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n7th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n7th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n8th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n8th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n8th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n9th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n9th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n9th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					
					InitDataCombo(0, "imdg_n1st_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n2nd_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n3rd_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n4th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n5th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n6th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n7th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n8th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n9th_clss_svc_flg",  "Y|N",  "Y|N");
				}
				break;
				
            case "sheet3":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 310;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|Feeder Term|Feeder Term|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Load Excel\nValidation";

					var HeadTitle2 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|RCV|DEL|20'|40'|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Load Excel\nValidation";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_20ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_40ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_20ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_40ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		true);
				}
				break;
				
            case "sheet4":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 310;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|Feeder Term|Feeder Term|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Load Excel\nValidation";

					var HeadTitle2 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|RCV|DEL|20'|40'|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Load Excel\nValidation";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_20ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_40ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_20ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_40ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		true);
				}
				break;

        	case "sheet5":
                with (sheetObj) {
					// 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "||cost_trf_no|cost_trf_rout_seq|From|To|BND|BND|DIR|Feeder Term|Feeder Term";
					HeadTitle1 += "|Service Provider|Service Provider|OLD AGMT|Dry Cost|Dry Cost";
					HeadTitle1 += "|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1";
					HeadTitle1 += "|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2";
					HeadTitle1 += "|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3";
					HeadTitle1 += "|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4";
					HeadTitle1 += "|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5";
					HeadTitle1 += "|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6";
					HeadTitle1 += "|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7";
					HeadTitle1 += "|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8";
					HeadTitle1 += "|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9";
					HeadTitle1 += "|Load Excel\nValidation";

					var HeadTitle2 = "||cost_trf_no|cost_trf_rout_seq|From|To|BND|BND|DIR|RCV|DEL";
					HeadTitle2 += "|Code|Name|OLD AGMT|20'|40'";
					HeadTitle2 += "|SVC_1|20' SCHG_1|40' SCHG_1|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_2|20' SCHG_2|40' SCHG_2|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_3|20' SCHG_3|40' SCHG_3|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_4|20' SCHG_4|40' SCHG_4|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_5|20' SCHG_5|40' SCHG_5|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_6|20' SCHG_6|40' SCHG_6|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_7|20' SCHG_7|40' SCHG_7|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_8|20' SCHG_8|40' SCHG_8|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_9|20' SCHG_9|40' SCHG_9|20' TTL|40' TTL";
					HeadTitle2 += "|Load Excel\nValidation";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
	                InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
	                InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		false);
	                InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"pctl_io_bnd_cd",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n1st_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n1st_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n1st_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n2nd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n2nd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n2nd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n3rd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n3rd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n3rd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n4th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n4th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n4th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n5th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n5th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n5th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n6th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n6th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n6th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n7th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n7th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n7th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n8th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n8th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n8th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n9th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n9th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"imdg_n9th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					
					InitDataCombo(0, "imdg_n1st_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n2nd_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n3rd_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n4th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n5th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n6th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n7th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n8th_clss_svc_flg",  "Y|N",  "Y|N");
					InitDataCombo(0, "imdg_n9th_clss_svc_flg",  "Y|N",  "Y|N");
				}
				break;
				
        	case "sheet6":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 310;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|Feeder Term|Feeder Term|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Load Excel\nValidation";

					var HeadTitle2 = "Flag||cost_trf_no|cost_trf_rout_seq|From|To|BND|DIR|RCV|DEL|20'|40'|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TRS4|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Load Excel\nValidation";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtCheckBox, 		30, daCenter, 	true,		"chk",							false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no",					false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_20ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"trsp_40ft_cost_sys_src_cd", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_cd",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_20ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"tml_40ft_cost_sys_src_cd",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		true);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"load_excel", 					false, 		"", 		dfNone, 	0, 			false, 		true);
				}
				break;
        }
    }
     
    function initForm(param){
    	if( param == "btn_reset1" ){
	    	comboObjects[1].Code = "^";
			comboObjects[2].Code = "R";
			comboObjects[3].Code = "^";
			comboObjects[4].Code = "R";
			comboObjects[5].Code = "^";
			comboObjects[6].Code = "R";
			comboObjects[7].Code = "^";
			comboObjects[8].Code = "R";
			comboObjects[9].Code = "^";
			comboObjects[10].Code = "R";
			comboObjects[11].Code = "^";
			comboObjects[12].Code = "R";
	
			ComSetObjValue(document.form.in_trans20, "");
			ComSetObjValue(document.form.in_trans40, "");
			ComSetObjValue(document.form.in_mty20, "");
			ComSetObjValue(document.form.in_mty40, "");
			ComSetObjValue(document.form.in_tmnl20, "");
			ComSetObjValue(document.form.in_tmnl40, "");
    	} else if( param == "btn_reset2" ){
    		comboObjects[13].Text = "";
			comboObjects[14].Code = "Y";
			comboObjects[15].Code = "R";
			comboObjects[16].Code = "^";
			comboObjects[17].Text = "";
			comboObjects[18].Code = "Y";
			comboObjects[19].Code = "R";
			comboObjects[20].Code = "^";
			comboObjects[21].Text = "";
			comboObjects[22].Code = "Y";
			comboObjects[23].Code = "R";
			comboObjects[24].Code = "^";
						
			ComSetObjValue(document.form.in_class1, "");
			ComSetObjValue(document.form.in_class2, "");
			ComSetObjValue(document.form.in_class3, "");
    	}
    }

	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if ( sName == "trsp_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "trsp_20ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		} else if( sName == "trsp_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "trsp_40ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))			
		} else if( sName == "mty_trsp_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "mty_trsp_20ft_ttl_cost_amt") 	= parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))			
		} else if( sName == "mty_trsp_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "mty_trsp_40ft_ttl_cost_amt") 	= parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))			
		} else if( sName == "tml_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "tml_20ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "tml_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		} else if( sName == "tml_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "tml_40ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "tml_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))
		}
	}
	
	function sheet2_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if ( sName == "imdg_n1st_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n1st_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n1st_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n1st_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n1st_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n1st_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n2nd_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n2nd_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n2nd_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n2nd_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n2nd_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n2nd_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n3rd_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n3rd_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n3rd_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n3rd_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n3rd_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n3rd_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n4th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n4th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n4th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n4th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n4th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n4th_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n5th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n5th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n5th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n5th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n5th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n5th_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n6th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n6th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n6th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n6th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n6th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n6th_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n7th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n7th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n7th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n7th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n7th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n7th_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n8th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n8th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n8th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n8th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n8th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n8th_clss_40ft_scg_amt"));
		} else if( sName == "imdg_n9th_clss_20ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n9th_clss_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_20ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n9th_clss_20ft_scg_amt"));
		} else if( sName == "imdg_n9th_clss_40ft_scg_amt" ) {
			sheetObj.CellValue2(Row, "imdg_n9th_clss_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "fdr_40ft_ttl_amt")) + parseFloat(sheetObj.CellValue(Row, "imdg_n9th_clss_40ft_scg_amt"));
		}
	}
	
	function sheet3_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if ( sName == "trsp_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "trsp_20ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		} else if( sName == "trsp_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "trsp_40ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))			
		} else if( sName == "mty_trsp_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "mty_trsp_20ft_ttl_cost_amt") 	= parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))			
		} else if( sName == "mty_trsp_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "mty_trsp_40ft_ttl_cost_amt") 	= parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))			
		} else if( sName == "tml_20ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "tml_20ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "tml_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_20ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		} else if( sName == "tml_40ft_adj_cost_amt" ) {
			sheetObj.CellValue2(Row, "tml_40ft_ttl_cost_amt") 		= parseFloat(sheetObj.CellValue(Row, "tml_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_adj_cost_amt"));
			sheetObj.CellValue2(Row, "fdr_40ft_ttl_amt") 			= parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))
		}
	}


	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,msgFlg) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
			
				formObj.f_cmd.value = SEARCH;
	        	var sParam = AocFrmQryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_AOC_3122GS.do", sParam);
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				break;

			case MULTI01: //Dry Save
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
			
				formObj.f_cmd.value = MULTI01;
				var sParam =  ComGetSaveString(sheetObj, false, false);
				if( sParam == "" ) return;
				
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj) + "&" + sParam, true);
				sheetObj.LoadSaveXml(sXml);

    			var vCnt = ComGetEtcData(sXml, "cnt");
				if(msgFlg){
					if(vCnt > 0){
						ComShowCodeMessage("AOC90008");
					}else{
						//Cost Tariff No Info 생성
						setCostTariffNoInfo();					
					}
				}
				break;

			case MULTI02: //Reefer Save
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
			
				formObj.f_cmd.value = MULTI02;
				var sParam =  ComGetSaveString(sheetObj, false, false);
				if( sParam == "" ) return;
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj) + "&" + sParam, true);
				sheetObj.LoadSaveXml(sXml);
					        			
    			var vCnt = ComGetEtcData(sXml, "cnt");
				if(msgFlg){
					if(vCnt > 0){
						ComShowCodeMessage("AOC90008");
					}
				}
				break;

			case MULTI03:	//Confirm
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
				
				formObj.f_cmd.value = MULTI03;
				var sParam = ComGetSaveString(sheetObjects[0], false, false) + ComGetSaveString(sheetObjects[1], false, false) + ComGetSaveString(sheetObjects[2], false, false);
				
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj) + "&" + sParam, true);
    			var vCnt = ComGetEtcData(sXml, "cnt");
				if(vCnt > 0){
					ComShowCodeMessage("AOC90008");
				}else{
					sheetObj.LoadSaveXml(sXml);
					
					//Cost Tariff No Info 생성
					setCostTariffNoInfo();
				}
				break;				
		
			case MULTI04:
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
				
				formObj.f_cmd.value = MULTI04;
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj), true);
				sheetObj.LoadSaveXml(sXml);

				//Cost Tariff No Info 생성
				setCostTariffNoInfo();
				break;
				
			case MULTI05: //Dangerous Save
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
			
				formObj.f_cmd.value = MULTI05;
				var sParam =  ComGetSaveString(sheetObj, false, false);
				if( sParam == "" ) return;
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj) + "&" + sParam, true);
				sheetObj.LoadSaveXml(sXml);
					        			
				var vCnt = ComGetEtcData(sXml, "cnt");
				if(msgFlg){
					if(vCnt > 0){
						ComShowCodeMessage("AOC90008");
					}
				}
				break;
				
			case MULTI06: //Delete
				if( !validateForm(sheetObj,formObj,sAction,msgFlg) ) return;
			
				formObj.f_cmd.value = MULTI06;
				var sParam =  ComGetSaveString(sheetObj, false, false, "chk");
				if( sParam == "" ) return;
				var sXml = sheetObj.GetSaveXml("ESD_AOC_3122GS.do", AocFrmQryString(formObj) + "&" + sParam, true);
				sheetObj.LoadSaveXml(sXml);
				
				var vCnt = ComGetEtcData(sXml, "cnt");
				if( msgFlg ){
					if( vCnt > 0 ){
						ComShowCodeMessage("AOC90008");
					} else{
						//재조회
						formObj.f_cmd.value = SEARCH;
			        	var sParam = AocFrmQryString(formObj);
						var sXml = sheetObj.GetSearchXml("ESD_AOC_3122GS.do", sParam);
						var arrXml = sXml.split("|$$|");
						sheetObjects[0].LoadSearchXml(arrXml[0]);
						sheetObjects[1].LoadSearchXml(arrXml[1]);
						sheetObjects[2].LoadSearchXml(arrXml[2]);
					}
				}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, msgFlg){
		switch (sAction) {
			case IBSEARCH:
        		if(comboObjects[0].Code == ""){
        			ComShowCodeMessage("COM12113", "Cost Tariff No");
        			ComAlertFocus(formObj.in_cost_trf_no, "");
        			return false;
				}
        		
        		if( beforetab == 0 ){
        			var stsCnt = sheetObjects[0].RowCount("I") + sheetObjects[0].RowCount("U") + sheetObjects[0].RowCount("D");
        		} else if( beforetab == 1 ){
        			var stsCnt = sheetObjects[1].RowCount("I") + sheetObjects[1].RowCount("U") + sheetObjects[1].RowCount("D");
        		} else if( beforetab == 2 ){
        			var stsCnt = sheetObjects[2].RowCount("I") + sheetObjects[2].RowCount("U") + sheetObjects[2].RowCount("D");
        		}
        		
        		if( stsCnt > 0 ){
	        		if( !ComShowCodeConfirm("AOC90033", "Adjusted data will not be saved if you click “OK”") ){
		    			return false;
		    		}
        		}
				break;

			case MULTI01:
				if(msgFlg){
					if( sheetObj.RowCount < 1 ){
						ComShowCodeMessage("COM130503");
						return false;
					}
				}	
				break;
				
			case MULTI02:
				if(msgFlg){
					if( sheetObj.RowCount < 1 ){
						ComShowCodeMessage("COM130503");
						return false;
					}
				}	
				break;
				
			case MULTI05:
				if(msgFlg){
					if( sheetObj.RowCount < 1 ){
						ComShowCodeMessage("COM130503");
						return false;
					}
				}	
				break;
				
			case MULTI06:
				if( sheetObj.RowCount < 1 ){
					return false;
				}
				
				if( sheetObj.CheckedRows("chk") < 1 ){
					ComShowCodeMessage("COM12189");
					return false;
				}
				
				if( !ComShowCodeConfirm("COM12165", "") ){
	    			return false;
	    		}
				break;
				

		}
        return true;
    }
	
    function in_cost_trf_no_OnChange(comObj, index, text)
    {
		//Cost Tariff No Info 생성
		setCostTariffNoInfo();

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
    }
	
	function in_cost_trf_no_OnKeyDown(combo, keycode, shift){
		var formObj = document.form;
		if(keycode == 13){
			if(comboObjects[0].Code != "" ){
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);   //tab1
			}
		}
	}	
	
	//Cost Tariff No Info 생성
    function setCostTariffNoInfo(){
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH03;
		var sParam = AocFrmQryString(formObj);
		var sXml = sheetObjects[3].GetSearchXml("ESD_AOC_3122GS.do", sParam);
		ComSetObjValue(formObj.cost_trf_sts_cd, ComGetEtcData(sXml, "cost_trf_sts_cd"));
		ComSetObjValue(formObj.cost_trf_sts_nm, ComGetEtcData(sXml, "cost_trf_sts_nm"));
		ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
		ComSetObjValue(formObj.eff_fm_dt, ComGetEtcData(sXml, "eff_fm_dt"));
		ComSetObjValue(formObj.upd_dt, ComGetEtcData(sXml, "upd_dt"));
		ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(sXml, "upd_usr_id"));
		ComSetObjValue(formObj.in_rhq_cd, ComGetEtcData(sXml, "rhq_cd"));
		ComSetObjValue(formObj.cntr_20ft_crte_wgt, ComGetEtcData(sXml, "cntr_20ft_crte_wgt"));
		ComSetObjValue(formObj.cntr_40ft_crte_wgt, ComGetEtcData(sXml, "cntr_40ft_crte_wgt"));

		if(ComGetEtcData(sXml, "next_trf_flg") == "Y"){
			ComBtnDisable("btn_confirm_cancel");
		}else{
			ComBtnEnable("btn_confirm_cancel");
		}

		if(ComGetEtcData(sXml, "cost_trf_sts_cd") == "C"){
			formDeact();
		}else{
			formAct();
		}
    }
	
    /* initControl() */
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);
    }
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, "-.");
            	break;
        	case "engupcomma": //영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
	        	break;
			case "uppernumcomma": //영문대문자+숫자+Comma
				ComKeyOnlyAlphabet('uppernum', '44');
	        	break;
     	}
    }    
    
    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
     	var elementObj = event.srcElement;
		var formObj = document.form;

        //입력Validation 확인 및 마스킹 처리
        //ComChkObjValid(event.srcElement);
    	switch(elementObj.name){ 	    	
    		case "in_full_20":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_full_20, "");
					}
    			}
    			break;
				
    		case "in_full_40":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_full_40, "");
					}
    			}
    			break;
				
    		case "in_terminal_20":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_terminal_20, "");
					}
    			}
    			break;
				
    		case "in_terminal_40":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_terminal_40, "");
					}
    			}
    			break;				
    	}	
    }	
	
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Dry" , -1 );
                    InsertTab( cnt++ , "Dangerous" , -1 );
                    InsertTab( cnt++ , "Reefer" , -1 );
                }
           		break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택 전 탭의 변경사항 저장 유무 확인 한다.
     */
    function sheet_Save_Click(tabObj)
    {
        var formObject = document.form;
    	if( tabNowCnt > 0 ){
   			var beforCnt = tabNowCnt-1
    		var statsCnt = sheetObjects[beforCnt].RowCount("I") + sheetObjects[beforCnt].RowCount("U") + sheetObjects[beforCnt].RowCount("D");
			
    		if( statsCnt > 0 ){
    			if( ComShowCodeConfirm("COM12152", "("+tabObj.TabText(tabNowCnt-1)+")" ) ){
					if( beforCnt == 0 ){
						doActionIBSheet(sheetObjects[0], formObject, MULTI01, true);   //tab1
					} else if( beforCnt == 1 ){
						doActionIBSheet(sheetObjects[1], formObject, MULTI05, true);   //tab2
					} else if( beforCnt == 2 ){
						doActionIBSheet(sheetObjects[2], formObject, MULTI02, true);   //tab3
					}
    			} else{
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH, true);
    			}
    		}	
    	}	
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");
        var formObject = document.form;

	    objs[nItem].style.display = "inline";
	    objs[beforetab].style.display = "none";

	    //--------------- 요기가 중요 --------------------------//
	    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    //------------------------------------------------------//
	    beforetab= nItem;
	    
        switch(nItem) {
    		case 0:
				sheet_Save_Click(tabObj);
				tabNowCnt = 1;
				document.all.item("dryLayer").style.display = "inline";
				document.all.item("dgLayer").style.display = "none";
				ComBtnEnable("btn_cost_detail");
		    	ComBtnEnable("btn_agmt_inq");
    			break;
    		case 1:
				sheet_Save_Click(tabObj);			
				tabNowCnt = 2;
				document.all.item("dryLayer").style.display = "none";
				document.all.item("dgLayer").style.display = "inline";
				ComBtnDisable("btn_cost_detail");
				ComBtnDisable("btn_agmt_inq");
				break;
				
    		case 2:
				sheet_Save_Click(tabObj);
				tabNowCnt = 3;
				document.all.item("dryLayer").style.display = "inline";
				document.all.item("dgLayer").style.display = "none";
				ComBtnEnable("btn_cost_detail");
		    	ComBtnEnable("btn_agmt_inq");
				break;
        }
    }

    /**
     * Load Excel용 hidden sheetObject를 sheetObject에 복사
     */
	function sheetCopy(sheetObjOrg, sheetObjExl){
		var findRow = -1;
       	for( var idx = 0 + parseInt(sheetObjOrg.HeaderRows); idx <= sheetObjOrg.LastRow; idx++ ){
       		sheetObjOrg.CellValue(idx, "load_excel") = "";
       		findRow = sheetObjExl.FindText("cost_trf_rout_seq", sheetObjOrg.CellValue(idx, "cost_trf_rout_seq"))
			if( findRow > -1 )
			{
				if( document.all.item("tabLayer")[0].style.display == "inline" || document.all.item("tabLayer")[2].style.display == "inline" ){
					sheetObjOrg.CellValue(idx, "trsp_20ft_adj_cost_amt")		= sheetObjExl.CellValue(findRow, "trsp_20ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "trsp_40ft_adj_cost_amt") 		= sheetObjExl.CellValue(findRow, "trsp_40ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "mty_trsp_20ft_adj_cost_amt") 	= sheetObjExl.CellValue(findRow, "mty_trsp_20ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "mty_trsp_40ft_adj_cost_amt") 	= sheetObjExl.CellValue(findRow, "mty_trsp_40ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "tml_20ft_adj_cost_amt") 		= sheetObjExl.CellValue(findRow, "tml_20ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "tml_40ft_adj_cost_amt") 		= sheetObjExl.CellValue(findRow, "tml_40ft_adj_cost_amt");
					sheetObjOrg.CellValue(idx, "load_excel") 					= "OK";
				} else if ( document.all.item("tabLayer")[1].style.display == "inline" ){
					sheetObjOrg.CellValue(idx, "imdg_n1st_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n1st_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n1st_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n1st_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n1st_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n1st_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n2nd_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n2nd_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n2nd_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n2nd_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n2nd_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n2nd_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n3rd_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n3rd_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n3rd_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n3rd_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n3rd_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n3rd_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n4th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n4th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n4th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n4th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n4th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n4th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n5th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n5th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n5th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n5th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n5th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n5th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n6th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n6th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n6th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n6th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n6th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n6th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n7th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n7th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n7th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n7th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n7th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n7th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n8th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n8th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n8th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n8th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n8th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n8th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n9th_clss_svc_flg")		= sheetObjExl.CellValue(findRow, "imdg_n9th_clss_svc_flg");
					sheetObjOrg.CellValue(idx, "imdg_n9th_clss_20ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n9th_clss_20ft_scg_amt");
					sheetObjOrg.CellValue(idx, "imdg_n9th_clss_40ft_scg_amt") 		= sheetObjExl.CellValue(findRow, "imdg_n9th_clss_40ft_scg_amt");
					sheetObjOrg.CellValue(idx, "load_excel") 					= "OK";
				}
    		}
		}
		ComOpenWait(false);

		if( sheetObjOrg.FindText("load_excel", "OK") == -1 ){
			ComShowCodeMessage("AOC90014");
		}
	}

	function getBtnSave(){
		var formObj = document.form;
		if( document.all.item("tabLayer")[0].style.display == "inline" ){
			doActionIBSheet(sheetObjects[0], formObj, MULTI01, true);   		//tab1
		} else if( document.all.item("tabLayer")[1].style.display == "inline" ){
			doActionIBSheet(sheetObjects[1], formObj, MULTI05, true);   		//tab2
		} else if( document.all.item("tabLayer")[2].style.display == "inline" ){
			doActionIBSheet(sheetObjects[2], formObj, MULTI02, true);   		//tab3
		}
	}

    /**
     * Dry & Reefer Cost Adjustment 계산 적용
     */
	function getDryRfCostAdjustmentCal(){
    	var formObj  = document.form;
    	if( document.all.item("tabLayer")[0].style.display == "inline" ){
    		var sheetObj = sheetObjects[0]; 										//sheet1
 		} else if( document.all.item("tabLayer")[2].style.display == "inline" ){
 			var sheetObj = sheetObjects[2]; 										//sheet3
 		}
    	
		var tran20_err_flg = false;
		var tran40_err_flg = false;
		var mty20_err_flg = false;
		var mty40_err_flg = false;
		var tmnl20_err_flg = false;
		var tmnl20_err_flg = false;
		
    	if( formObj.in_trans20.value == "" )								tran20_err_flg = true;
    	if( formObj.in_trans40.value == "" )								tran40_err_flg = true;
    	if( comboObjects[4].Code != "S" && formObj.in_mty20.value == "" ) 	mty20_err_flg = true;
    	if( comboObjects[10].Code != "S" && formObj.in_mty40.value == "" ) 	mty40_err_flg = true;
    	if( formObj.in_tmnl20.value == "" ) 								tmnl20_err_flg = true;
    	if( formObj.in_tmnl40.value == "" ) 								tmnl40_err_flg = true;
    	
    	//Cost Adjustment Trans 입력 체크
		if( tran20_err_flg && tran40_err_flg && mty20_err_flg && mty40_err_flg && tmnl20_err_flg && tmnl40_err_flg ){
			ComShowCodeMessage("COM130201", "Cost Adjustment");
			return false;
		}
		
		//CheckBox Check 여부
		var iCheckRow = sheetObj.CheckedRows("chk");
		if( iCheckRow <= 0 ){
			ComShowCodeMessage("AOC90007", "Cost Adjustment");
			return false;
		}

		//SaveName이 "chk"인 행에서만 체크된 행의 번호를 읽어온다.
		var iCheckRows = sheetObj.FindCheckedRow("chk");
		
		//가져온 행을 배열로 반든다.
		var arrRow = iCheckRows.split("|");
		
		for( idx = 0; idx < arrRow.length - 1; idx++ ){
			//Trans20' Adjustment Amount 적용
			if( formObj.in_trans20.value != "" ){
				if( comboObjects[1].Code.indexOf("^") > -1 || comboObjects[1].Code.indexOf(sheetObj.CellValue(arrRow[idx], "trsp_20ft_cost_sys_src_cd")) > -1 ){
					var trans20_val = formObj.in_trans20.value;
					if(comboObjects[2].Code == "R"){
						sheetObj.CellValue(arrRow[idx], "trsp_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "trsp_20ft_cost_amt")) * (trans20_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "trsp_20ft_adj_cost_amt") = trans20_val;
					}
				}
			}
			
			//Trans40' Adjustment Amount 적용
			if( formObj.in_trans40.value != "" ){
				if( comboObjects[7].Code.indexOf("^") > -1 || comboObjects[7].Code.indexOf(sheetObj.CellValue(arrRow[idx], "trsp_40ft_cost_sys_src_cd")) > -1 ){
					var trans40_val = formObj.in_trans40.value;
					if( comboObjects[8].Code == "R" ){
						sheetObj.CellValue(arrRow[idx], "trsp_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "trsp_40ft_cost_amt")) * (trans40_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "trsp_40ft_adj_cost_amt") = trans40_val;
					}
				}
			}
			
			//Mty20' Adjustment Amount 적용
			if( formObj.in_mty20.value != "" || comboObjects[4].Code == "S" ){
				if( comboObjects[3].Code.indexOf("^") > -1 || comboObjects[3].Code.indexOf(sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_cost_sys_src_cd")) > -1 ){
					var mty20_val = formObj.in_mty20.value;
					if( comboObjects[4].Code == "S" ){
						sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_adj_cost_amt") = parseFloat(sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_cost_amt")) * -1;
					} else if( comboObjects[4].Code == "R" ){
						sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_cost_amt")) * (mty20_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "mty_trsp_20ft_adj_cost_amt") = mty20_val;
					}
				}
			}
			
			//Mty40' Adjustment Amount 적용
			if( formObj.in_mty40.value != "" || comboObjects[10].Code == "S" ){
				if( comboObjects[9].Code.indexOf("^") > -1 || comboObjects[9].Code.indexOf(sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_cost_sys_src_cd")) > -1 ){
					var mty40_val = formObj.in_mty40.value;
					if( comboObjects[10].Code == "S" ){
						sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_adj_cost_amt") = parseFloat(sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_cost_amt")) * -1;
					} else if( comboObjects[10].Code == "R" ){
						sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_cost_amt")) * (mty40_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "mty_trsp_40ft_adj_cost_amt") = mty40_val;
					}
				}
			}
			
			//Tmnl20' Adjustment Amount 적용
			if( formObj.in_tmnl20.value != "" ){
				if( comboObjects[5].Code.indexOf("^") > -1 || comboObjects[5].Code.indexOf(sheetObj.CellValue(arrRow[idx], "tml_20ft_cost_sys_src_cd")) > -1 ){
					var tmnl20_val = formObj.in_tmnl20.value;
					if( comboObjects[6].Code == "R" ){
						sheetObj.CellValue(arrRow[idx], "tml_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "tml_20ft_cost_amt")) * (tmnl20_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "tml_20ft_adj_cost_amt") = tmnl20_val;
					}
				}
			}
			
			//Tmnl40' Adjustment Amount 적용
			if( formObj.in_tmnl40.value != "" ){
				if( comboObjects[11].Code.indexOf("^") > -1 || comboObjects[11].Code.indexOf(sheetObj.CellValue(arrRow[idx], "tml_40ft_cost_sys_src_cd")) > -1 ){
					var tmnl40_val = formObj.in_tmnl40.value;
					if( comboObjects[12].Code == "R" ){
						sheetObj.CellValue(arrRow[idx], "tml_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "tml_40ft_cost_amt")) * (tmnl40_val/100), 2);
					} else{
						sheetObj.CellValue(arrRow[idx], "tml_40ft_adj_cost_amt") = tmnl40_val;
					}
				}
			}
		}
    }
     
    /**
     * Dangerous Cost Adjustment 계산 적용
     */
 	function getDgCostAdjustmentCal(){
    	var formObj  = document.form;
		var sheetObj = sheetObjects[1];
		var idx = 0;
		var jdx = 0;
    	
		if( comboObjects[13].Text == "" && comboObjects[17].Text == "" && comboObjects[21].Text == "" ){
			ComShowCodeMessage("COM130201", "Cost Adjustment");
			return false;
		}
		
    	//CheckBox Check 여부
		var iCheckRow = sheetObj.CheckedRows("chk");
		if( iCheckRow <= 0 ){
			ComShowCodeMessage("AOC90007", "Cost Adjustment");
			return false;
		}
		
		//Class 중복 체크
		var arrClss1 = comboObjects[13].Code.split(",")
		var arrClss2 = comboObjects[17].Code.split(",")
		var arrClss3 = comboObjects[21].Code.split(",")
		var clss_err_flg = false;
		
		if( comboObjects[13].Text != "" ){
			for( idx = 0; idx < arrClss1.length; idx++ ){
				for( jdx = 0; jdx < arrClss2.length; jdx++ ){
					if( arrClss1[idx].substr(0,6) == arrClss2[jdx].substr(0,6) ){
						clss_err_flg = true;
					}
				}
				
				for( jdx = 0; jdx < arrClss3.length; jdx++ ){
					if( arrClss1[idx].substr(0,6) == arrClss3[jdx].substr(0,6) ){
						clss_err_flg = true;
					}
				}
			}
		}
		
		if( comboObjects[17].Text != "" ){
			for( idx = 0; idx < arrClss2.length; idx++ ){
				for( jdx = 0; jdx < arrClss3.length; jdx++ ){
					if( arrClss2[idx].substr(0,6) == arrClss3[jdx].substr(0,6) ){
						clss_err_flg = true;
					}
				}
			}
		}
		
		if( clss_err_flg == true ){
			ComShowCodeMessage("AOC90031");
			return false;
		}

		
		//SaveName이 "chk"인 행에서만 체크된 행의 번호를 읽어온다.
		var iCheckRows = sheetObj.FindCheckedRow("chk");
		
		//가져온 행을 배열로 반든다.
		var arrRow = iCheckRows.split("|");
		var clssStr = comboObjects[13].Code + "," + comboObjects[17].Code + "," + comboObjects[21].Code;
		var svc_flg = "N";
		var schg_amt_20ft = 0;
		var schg_amt_40ft = 0;
		for( idx = 0; idx < arrRow.length - 1; idx++ ){
			//Class1
			if( clssStr.indexOf("Class1") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class1")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}	
				} else if( clssStr.substr(clssStr.indexOf("Class1")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}	
				} else if( clssStr.substr(clssStr.indexOf("Class1")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}	
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n1st_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n1st_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n1st_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class2
			if( clssStr.indexOf("Class2") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class2")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class2")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class2")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n2nd_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n2nd_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n2nd_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class3
			if( clssStr.indexOf("Class3") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class3")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class3")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class3")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n3rd_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n3rd_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n3rd_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class4
			if( clssStr.indexOf("Class4") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class4")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class4")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
						if( comboObjects[16].Code == "^" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class4")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n4th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n4th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n4th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class5
			if( clssStr.indexOf("Class5") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class5")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class5")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class5")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n5th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n5th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n5th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class6
			if( clssStr.indexOf("Class6") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class6")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class6")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class6")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n6th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n6th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n6th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class7
			if( clssStr.indexOf("Class7") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class7")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class7")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class7")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n7th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n7th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n7th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class8
			if( clssStr.indexOf("Class8") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class8")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class8")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class8")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n8th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n8th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n8th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
			//Class9
			if( clssStr.indexOf("Class9") > -1 ){
				if( clssStr.substr(clssStr.indexOf("Class9")+7,1) == "1" ){
					svc_flg		= comboObjects[14].Code;
					if( comboObjects[15].Code == "R" ){
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class1.value/100), 2);
						}	
					} else {
						if( comboObjects[16].Code == "^" || comboObjects[16].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class1.value;
							schg_amt_40ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class1.value;
						} else if(comboObjects[16].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class1.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class9")+7,1) == "2" ){
					svc_flg		= comboObjects[18].Code;
					if( comboObjects[19].Code == "R" ){
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class2.value/100), 2);
						}
					} else {
						if( comboObjects[20].Code == "^" || comboObjects[20].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class2.value;
							schg_amt_40ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class2.value;
						} else if(comboObjects[20].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class2.value;
						}	
					}
				} else if( clssStr.substr(clssStr.indexOf("Class9")+7,1) == "3" ){
					svc_flg		= comboObjects[22].Code;
					if( comboObjects[23].Code == "R" ){
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_20ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= ComTrunc(parseFloat(sheetObj.CellValue(arrRow[idx], "fdr_40ft_ttl_amt")) * (formObj.in_class3.value/100), 2);
						}
					} else {
						if( comboObjects[24].Code == "^" || comboObjects[24].Code == "D2,D4" ){
							schg_amt_20ft 	= formObj.in_class3.value;
							schg_amt_40ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D2"){
							schg_amt_20ft 	= formObj.in_class3.value;
						} else if(comboObjects[24].Code == "D4"){
							schg_amt_40ft 	= formObj.in_class3.value;
						}	
					}
				}
				
				if(sheetObj.CellValue(arrRow[idx], "imdg_n9th_clss_svc_flg") == svc_flg) {
					sheetObj.CellValue(arrRow[idx], "imdg_n9th_clss_20ft_scg_amt") = schg_amt_20ft;
					sheetObj.CellValue(arrRow[idx], "imdg_n9th_clss_40ft_scg_amt") = schg_amt_40ft;
				}	
			}
			
		}
    }

    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    
    function formDeact(){
    	ComBtnDisable("btn_confirm");
    	//ComBtnEnable("btn_confirm_cancel");
    	ComBtnDisable("btn_apply1");
    	ComBtnDisable("btn_reset1");
    	ComBtnDisable("btn_apply2");
    	ComBtnDisable("btn_reset2");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_load_excel");

		//데이터속성[						ROW,COL,														DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",   		false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);

		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n1st_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n1st_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n1st_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n2nd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n2nd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n2nd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n3rd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n3rd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n3rd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n4th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n4th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n4th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n5th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n5th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n5th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n6th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n6th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n6th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n7th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n7th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n7th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n8th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n8th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n8th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n9th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n9th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n9th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
		
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("trsp_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("trsp_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("tml_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",   		false, 		"", 		dfFloat, 	2, 			false, 		false);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("tml_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
    }
    
    
    function formAct(){
		var objs = document.all.item("tabLayer");
		
    	ComBtnEnable("btn_confirm");
    	ComBtnEnable("btn_apply1");
    	ComBtnEnable("btn_reset1");
    	ComBtnEnable("btn_apply2");
    	ComBtnEnable("btn_reset2");
    	ComBtnEnable("btn_save");
    	ComBtnEnable("btn_delete");
    	ComBtnEnable("btn_load_excel");
		ComBtnDisable("btn_confirm_cancel");

		//데이터속성[						ROW,COL,														DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",   		false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);

		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n1st_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n1st_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n1st_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n1st_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n2nd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n2nd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n2nd_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n2nd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n3rd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n3rd_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n3rd_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n3rd_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n4th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n4th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n4th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n4th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n5th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n5th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n5th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n5th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n6th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n6th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n6th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n6th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n7th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n7th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n7th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n7th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n8th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n8th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n8th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n8th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_svc_flg"), 		dtCombo,			50, daCenter, 	true,		"imdg_n9th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_20ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n9th_clss_20ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("imdg_n9th_clss_40ft_scg_amt"), dtData,				70, daRight, 	true,		"imdg_n9th_clss_40ft_scg_amt",  false, 		"", 		dfFloat, 	2, 			true, 		true);
		
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("trsp_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("trsp_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("tml_20ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",   		false, 		"", 		dfFloat, 	2, 			true, 		true);
		sheetObjects[2].InitDataProperty(0, sheetObjects[2].SaveNameCol("tml_40ft_adj_cost_amt"), 		dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			true, 		true);
    }
    
    function getFrom_nod_cd(rowArray) {
		var colArray = rowArray[0];
		document.form.in_from_nod_cd.value = colArray[3];
		document.form.in_from_nod_cd.focus();
	}
	
	function getTo_nod_cd(rowArray) {
		var colArray = rowArray[0];
		document.form.in_to_nod_cd.value = colArray[3];
		document.form.in_to_nod_cd.focus();
	}
	
	/**
	 * 공통 Node popup
	 */
	function openHireYardPopup(objName) {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId = objName;
		var xx1 = ""; //CONTI
		var xx2 = ""; //SUB CONTI
		var xx3 = ""; //COUNTRY
		var xx4 = ""; //STATE
		var xx5 = ""; //CONTROL OFFIC
		var xx6 = ""; //LOC CODE
		var xx7 = ""; //LOC NAME
		var xx8 = "";
		var xx9 = "";
		v6 = "yard";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	
    function co_mty20_OnChange(comObj, index, text)
    {
		var formObj = document.form;
		if(text == "-SYS AMT"){
			formObj.in_mty20.value = "";
			formObj.in_mty20.className = "input2";
			formObj.in_mty20.readOnly = true;
		}else{
			formObj.in_mty20.value = "";
			formObj.in_mty20.className = "input";
			formObj.in_mty20.readOnly = false;
		}
    }
	
    function co_mty40_OnChange(comObj, index, text)
    {
		var formObj = document.form;
		if(text == "-SYS AMT"){
			formObj.in_mty40.value = "";
			formObj.in_mty40.className = "input2";
			formObj.in_mty40.readOnly = true;
		}else{
			formObj.in_mty40.value = "";
			formObj.in_mty40.className = "input";
			formObj.in_mty40.readOnly = false;
		}
    }
    
    function co_trans20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_mty20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	function co_tmnl20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_trans40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_mty40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_tmnl40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function class1_cntr_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function class2_cntr_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function class3_cntr_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	    /**
     * Object 의 Onclick 이벤트핸들러 <br>
     */
    function obj_click(){
    	
        var formObj = document.form;
        var obj = event.srcElement;	
        switch(obj.name){
            case "rdoRhqCd":
                if( formObj.in_ofc_cd.value == obj.value ) return;	 		
                formObj.in_ofc_cd.value = obj.value; 
                
                formObj.f_cmd.value = SEARCH02;
        		var sParam = AocFrmQryString(formObj);
        		var sXml = sheetObjects[3].GetSearchXml("ESD_AOC_3122GS.do", sParam);
        		ComXml2ComboItem(sXml, comboObjects[0], "cost_trf_no", "cost_trf_no");
        		
        		if(!ComIsEmpty(formObj.trf_no.value))
        		{
        			comboObjects[0].Code = ComGetObjValue(formObj.trf_no);
        			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);
        		}
                
                break;
        }
        //if(obj.dataformat == null) return;
    }
	/* 개발자 작업  끝 */