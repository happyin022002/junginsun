/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_COA_0054.js
*@FileTitle     : Cost Calculation - CM
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.22
*@LastModifier  : 이연각
=========================================================*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;	
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {			    
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;	
				  case "btng_creation2":
					//168번 화면 OPEN
					  btng_creation2_OnClick();
					break;
    			case "bu_zoom_in1": //next
    			    if (sheetObject.LastRow()> 20) {
    			    	SetSheetHeight(ComGetSheetHeight(sheetObj, sheetObject.LastRow()+1));
        				set_Zoom("open");
    			    }
    			break;
    			case "bu_zoom_out1": //next
    				SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
    				set_Zoom("close");
    			break;
				  case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    			break;
				  default:
					  doActionPageMove(sheetObject, formObject, srcName);
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    //화면의 Zoom 처리
    function set_Zoom(zoomFlag) {
		if (zoomFlag == "open") {
		    div_zoom_in1.style.display="none";  
		    div_zoom_out1.style.display="inline";
		} else if (zoomFlag == "close") {                                                
		    div_zoom_in1.style.display="inline"; 
		    div_zoom_out1.style.display="none";
		}
		parent.syncHeight();
    }
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(headerCD, headerNM) {
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){         
            initCombo(comboObjects[k],comboObjects[k].id);
        } 
        //
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,headerCD, headerNM);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode=true; 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		loadingMode=false;
	}
	function initCombo(comboObj, comboId) {
  		with (comboObj) {
  			SetDropHeight(300);
  			Index=0;
  			if (comboId == "f_sim_rpt_no"){
SetColAlign(0, "center");
SetColAlign(1, "left");
SetColWidth(0, "50");
SetColWidth(1, "100");
  			}
  		}
  	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo, headerCD, headerNM) {
		var cnt=0;
		var aryNM="";
		var aryCD="";
		var aryNo="";
		var colNo="";
		var calcu="";
		switch(sheetNo) {
			case 1:      //sheet1 init
				if(headerNM == ""){
    				headerNM="|";
    				headerCD="|";
				}
				aryNM=headerNM.split("|");
				aryCD=headerCD.split("|");
				aryNo=aryCD.length;
				colNo=aryNo + 9;
			    with(sheetObj){
			      var HeadTitle="H|H|H|Vessel|Items|Items|H|sgrp_cost_cd|Total|"+headerNM+"" ;

			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"c_sim_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"c_sim_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"c_sim_rpt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"c_vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"c_kr_dp_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"c_eng_dp_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"c_dp_seq_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"c_sgrp_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"c_amt_ttl",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			            for(j=0; j<aryNo; j++){
			      cols.push({Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			      }
			 
			      InitColumns(cols);

			      SetEditable(0);//전체Edit허용여부[선택,Defaultfalse]
			      SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
			            }


				break;
		}
	}
	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=formObj.sXml.value; 
				var arrXml=sXml.split("|$$|");
				document.form.sXml.value="";
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_slan_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_dept_cd2, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], f_sim, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], f_trd_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], f_sim_rpt_no, "code", "code|name");
				with(formObj) {
					ComSetObjValue(f_sim, ComCoaGetEtcData(arrXml[0], "f_sim"));
					ComSetObjValue(f_slan_cd,ComCoaGetEtcData(arrXml[0], "f_slan_cd"));
					ComSetObjValue(f_sim_dt,ComCoaGetEtcData(arrXml[0], "f_sim_dt"));
					ComSetObjValue(f_sim_no,ComCoaGetEtcData(arrXml[0], "f_sim_no"));
					ComSetObjValue(f_sim_rmk,ComCoaGetEtcData(arrXml[0], "f_sim_rmk"));
					ComSetObjValue(f_dept_cd,ComCoaGetEtcData(arrXml[0], "f_dept_cd"));
					ComSetObjValue(f_dept_cd2,ComCoaGetEtcData(arrXml[0], "f_dept_cd2"));
					ComSetObjValue(f_usr_id,ComCoaGetEtcData(arrXml[0], "f_usr_id"));
					f_sim_rpt_no.InsertItem(0,"","");
					f_sim_rpt_no.SetSelectIndex(0);
				}
				ComOpenWait(false);
				break;  
			case IBSEARCH:      //조회
    			if(validateForm(sheetObj,formObj,sAction)) {
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
        			formObj.f_cmd.value=SEARCHLIST;
         			var rtn=sheetObj.GetSearchData("ESM_COA_0054GS.do", coaFormQueryString(formObj));
        			var etcData=getEtcData(rtn);         			                   
                    sheetObj.Reset();
                    initSheet(sheetObj, 1, etcData["header"], etcData["header"]);
        			sheetObj.LoadSearchData(rtn,{Sync:1} );
        			ComOpenWait(false);
    			}
    			break;
			case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType=selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":          
						if(sheetObj.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
							}

                         
                        break;
					case "DY":        
						if(sheetObj.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								 sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
							}

                        
                        break;
   					case "AN":
   						if(sheetObj.RowCount() < 1){//no data
   							ComShowCodeMessage("COM132501");
   							}else{
   								sheetObj.Down2Excel({ HiddenColumn:0});
   							}

                         
                        break;
					case "DN":   
						if(sheetObj.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
							}

                        
                        break;
                } 			
				//sheetObj.Down2Excel(-1, false, false, true);
				break;
		}
	}
    function getEtcData(xml, key){
    	var xmlDoc=document.createElement("XML");
    	xmlDoc.async=false;
    	xmlDoc.loadXML(xml);
    	var nodes=xmlDoc.selectNodes("SHEET/ETC-DATA/ETC");
    	var etcs=new Array();
    	for(var i=0 ; i < nodes.length ; i++){
    		var node=nodes.nextNode();
    		etcs[node.attributes[0].value]=node.text;
    	}
    	return etcs;
    }
    function doActionPageMove(sheetObj, formObj, btnName){
        formObj.f_cmd.value="";
        formObj.method="POST";
        formObj.target="";
        //MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다        
        if (btnName == "step01"){
            formObj.action("ESM_COA_0051.do?f_slan_cd="+f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step02"){                
            formObj.action("ESM_COA_0052.do?f_slan_cd="+f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step03"){            
            formObj.action("ESM_COA_0053.do?f_slan_cd="+f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step04"){
            formObj.action("ESM_COA_0054.do?f_slan_cd="+f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }
    }
	/**
	 * Retrieve시 sheet에 데이터를 넣고나서 처리되는 함수
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		//sheetObj.ColumnSort("no","ASC");  // 정렬  
		if(document.form.f_kor_eng[0].checked){
			sheetObj.SetColHidden("c_kr_dp_desc",0);
			sheetObj.SetColHidden("c_eng_dp_desc",1);
		} else{
			sheetObj.SetColHidden("c_kr_dp_desc",1);
			sheetObj.SetColHidden("c_eng_dp_desc",0);
		}
		/*
		//Vessl View인지 확인
		if(document.form.f_searchItem2.selectedIndex==1){
		    sheetObj.SetColHidden("c_vsl_cd",0);
		} else {
		    sheetObj.SetColHidden("c_vsl_cd",1);
		}*/
	}
	/**
	 * Voyage PL By individual Vessel 이 선택되었을때면 Vessel combo를 보여준다
	 */
	function chgItem2(obj){
		var frm=document.form;
		if(obj.value=="0"){
		    document.all.div_tot_avg.style.display="inline";
			document.all.div_vessel.style.display="none";
		} else if(obj.value=="1"){
		    document.all.div_tot_avg.style.display="none";
			document.all.div_vessel.style.display="inline";
			chgVessel();   // Vessel 정보를 조회한다.(콤보 다시 설정)
		} else{
		    document.all.div_tot_avg.style.display="none";
			document.all.div_vessel.style.display="none";
		}
	}
	/**
	 * check box를 클릭했을때 Item명을 한글 혹은 영문으로 보여준다
	 */
	function chgHeader(value){
		var sheetObj=sheetObjects[0];
		if (value == "0"){
			sheetObj.SetColHidden("c_kr_dp_desc",0);
			sheetObj.SetColHidden("c_eng_dp_desc",1);
		} else if(value == "1"){
			sheetObj.SetColHidden("c_kr_dp_desc",1);
			sheetObj.SetColHidden("c_eng_dp_desc",0);
		}
	}
	/**
	 * SearchItem2변경시 해당 Simulation No의 vessel정보를 조회한다.
	 */
	function chgVessel(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
		if (comboObjects[0].GetSelectText()== "") {
		    ComShowMessage(ComGetMsg("COA10002","S.Lane"));
		    comboObjects[0].focus();
		    return false;
		}
		if(formObj.f_sim_dt.value == "") {
		    ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
		    formObj.f_sim_dt.focus();
		    return false;
		}
		if(formObj.f_sim_no.value == "") {
		    ComShowMessage(ComGetMsg("COA10002","Simulation Number"));
		    formObj.f_sim_no.focus();
		    return false;
		}
		formObj.f_cmd.value=SEARCHLIST13;
  		var sXml=sheetObj.GetSearchData("ESM_COA_0054GS2.do", coaFormQueryString(formObj));
 		var arrXml=sXml.split("|$$|");
 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_vsl_cd, "code", "name");
	}
	/**
	 * Service Lane변경시 해당 Simulation No를 조회한다.
	 */
	function chgSLane(obj){
		 var formObj=document.form; 
      	 var sheetObj=sheetObjects[0];
      	if (ComGetObjValue(obj) != "") {
         	var simNo=ComGetObjValue(f_sim);
 	 		formObj.f_cmd.value=SEARCHLIST10;
  	 		var sXml=sheetObj.GetSearchData("ESM_COA_0054GS2.do", coaFormQueryString(formObj));
 	 		var arrXml=sXml.split("|$$|");
 	 		if (arrXml.length > 0)
 	 			ComXml2ComboItem(arrXml[0], f_sim, "code", "name");
 	 		ComSetObjValue(f_sim,simNo);
 	 		setSimNo(f_sim);
 	 		setSimRptNo(f_sim);
 	 		/*
 	 		if (ComTrim(simNo) != ""){
 	 			setSimNo(formObj.f_sim);
 	 		}*/ 
         }
	}
	 /**
	 * Simulation No Combo box에서 데이터 선택시 아래의 input box에 데이터를 입력한다.
	 */
	function setSimNo(Obj) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (ComGetObjValue(Obj) != "") {
			var param="f_cmd=" + SEARCH01;
			param=param + "&f_sim=" + ComGetObjValue(Obj);
			param=param + "&f_slan_cd=" + ComGetObjValue(f_slan_cd);
 			var sXml=sheetObj.GetSearchData("CommonUtilGS.do", param);
			var arrXml=sXml.split("|$$|");
			if (0 < arrXml.length && ComGetEtcData(arrXml[0], "sim_dt") != undefined) {
				ComSetObjValue(formObj.f_sim_dt, ComGetEtcData(arrXml[0], "sim_dt"));
				ComSetObjValue(formObj.f_sim_no, ComGetEtcData(arrXml[0], "sim_no"));
				ComSetObjValue(formObj.f_sim_rmk, ComGetEtcData(arrXml[0], "sim_rmk"));
				ComSetObjValue(formObj.f_usr_id, ComGetEtcData(arrXml[0], "sim_usr_id"));
				ComSetObjValue(formObj.f_dept_cd, ComGetEtcData(arrXml[0], "sim_dept_cd"));
				ComAddSeparator(formObj.f_sim_dt);
			}
		}
	}  
	function setSimRptNo(Obj) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (ComGetObjValue(Obj) != ""){
	 		formObj.f_cmd.value=SEARCHLIST12;
 	 		var sXml=sheetObj.GetSearchData("ESM_COA_0054GS2.do", coaFormQueryString(formObj));
	 		var arrXml=sXml.split("|$$|");
	 		if (arrXml.length > 0)
		 			ComXml2ComboItem(arrXml[0], f_sim_rpt_no, "code", "code|name");
	 		f_sim_rpt_no.SetSelectIndex(0);
		}else{
			f_sim_rpt_no.RemoveAll();
		}
		f_sim_rpt_no.InsertItem(0,"","");
	}   
    /**
     * 상태표시를 제거한다.
     */
    function closeStatus(){
//        zu_openRunning(false);
    }
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (ComGetObjValue(f_slan_cd) == "") {
			    ComShowMessage(ComGetMsg("COA10026","S.Lane"));
			    ComSetFocus(f_slan_cd);
			    return false;
			}
			if(ComGetObjValue(f_sim_dt) == "") {
			    ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
			    ComSetFocus(formObj.f_sim_dt);
			    return false;
			}
			if(ComGetObjValue(f_sim_no) == "") {
			    ComShowMessage(ComGetMsg("COA10026","Simulation Number"));
			    ComSetFocus(f_sim);
			    return false;
			}			
			if(ComGetObjValue(f_sim_rpt_no) == "") {
			    ComShowMessage(ComGetMsg("COA10026","Report No"));
			    ComSetFocus(f_sim_rpt_no);
			    return false;
			}
			if (ComGetObjValue(f_searchItem2) == "1") {
				if(ComGetObjValue(f_vsl_cd) == ""){
					// [COM12113] : vessel를(을) 선택하세요.
					ComShowMessage(ComGetMsg("COM12113", "vessel"));
					ComSetFocus(formObj.f_vsl_cd);
					return false;
				}
			}
		}
		return true;
	}
	/*
	 * 멀티콤보 변경시
	 */
	function f_slan_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if (loadingMode == true) return; 
     	if(ComTrim(newCode) != "" ) { // S.Lane
     		chgSLane(comboObj);
     	} 
	} 
	function f_dept_cd2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if (loadingMode == true) return; 
    	chgSLane(comboObj);
    } 
	function f_sim_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true)
			return;
		setVal_f_sim();
	} 
	function setVal_f_sim(){
		var formObj=document.form; 	 
		setSimNo(f_sim);
 		setSimRptNo(f_sim);
	}
	/*
	 * btng_creation2 클릭시 168번 화면 팝업
	 */
	function btng_creation2_OnClick(){
		 var formObj=document.form; 	 
       if(validateFormForPopup()) {
     	    var param="?f_sim_dt=" + ComGetObjValue(formObj.f_sim_dt)
    	    + "&f_sim_no=" + ComGetObjValue(formObj.f_sim_no)
    	    + "&f_dept_cd=" + ComGetObjValue(formObj.f_dept_cd)
    	    + "&f_usr_id=" +ComGetObjValue(formObj.f_usr_id);
    	    ComOpenWindow("ESM_COA_0168.do" + param, "sim_rpt_creation", "width=700,height=425");
       }
	}
	/*
	 * 팝업을 띄우기 위해 f_sim_dt, f_sim_no 체크
	 */
	function validateFormForPopup(){
		var formObj=document.form; 
	    var rtn=false;
		if(ComGetObjValue(f_slan_cd) == "") {
		    ComShowMessage(ComGetMsg("COA10002","S.Lane"));
		    ComSetFocus(f_slan_cd);
		} else if(ComGetObjValue(formObj.f_sim_dt) == "") {
		    ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
		    ComSetFocus(formObj.f_sim_dt);
		} else if(ComGetObjValue(formObj.f_sim_no) == "") {
		    ComShowMessage(ComGetMsg("COA10002","Simulation Number"));
		    ComSetFocus(formObj.f_sim_no);
		} else {
		    rtn=true;
		}
		return rtn;
	}
