/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0064.js
*@FileTitle : General Cargo Manifest Print Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.11.18 김보배 [CHM-201327122] [RFS Lane] Double calling logic 적용 요청 (1) Print by VVD /Port
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
     * @extends 
     * @class esm_bkg_0066  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0064() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
var rdObjects = new Array();
var rdCnt = 0;
/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	
	
/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
 	    initComboEditable(comboObj)
 	}
 	 
 	 function initComboEditable(combo){
	 	 	with (combo) {
	 	 		MultiSelect = false;
		 	  UseEdit = false;
		 	  DropHeight = 200;
		 	   
	 	 	}
 	 }
 	
 /*********************** EDTITABLE MULIT COMBO END********************/   
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
     	for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }
		  
		   //MultiCombo초기화 
 	    for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
 	      
		  for(i=0;i<rdObjects.length;i++){
				initRdConfig(rdObjects[i],i+1);
			}
		    initPrintList();	
		 		initPrintRD();
		 		doActionIBSheet(sheetObjects[0],form,IBSEARCH);
		 		
		 		
   }
   
	var bkgnoForUSRD = new Array();
	var bkgnoForGeneralRD="";
	function initPrintRD(){
		var arrBkgNo = form.arr_bkg_no.value.split('|');

		if(form.arr_bkg_no.value ==""){
			ComShowCodeMessage("BKG95009");
			return; 
		}

		var polPodStr = "";//print Form이 US/US Charge 일경우 경우 Outbound는 조회 결과의 POD별, Inbound일경우 POL별로 나누어 출력한다. 
		var tempBkgno="";
		var tempPolPod="";
		var bkgNoPolPod;
		
		for(var index=0; index<arrBkgNo.length; index++) {
			bkgNoPolPod = arrBkgNo[index].split('@');
				
			if(bkgNoPolPod.length < 2 ) {
				bkgnoForGeneralRD += bkgNoPolPod[0]+",";
				continue;
			}
			
			if( index > 0 && tempPolPod != bkgNoPolPod[1]){ // pol/pod 별로 US 일경우 프린트 한다.
				bkgnoForUSRD[tempPolPod] = tempBkgno.substring(0,tempBkgno.length-1);  
				tempBkgno ="";
			}
			
			bkgnoForGeneralRD += bkgNoPolPod[0]+",";
			tempBkgno         += "'"+bkgNoPolPod[0]+"',";
			
			tempPolPod = bkgNoPolPod[1];
			
		}
		
		bkgnoForUSRD[tempPolPod] = tempBkgno.substring(0,tempBkgno.length-1);
		bkgnoForGeneralRD = bkgnoForGeneralRD.substring(0,bkgnoForGeneralRD.length-1);
	
	}
	
	
function initRdConfig(rdObject){
		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);

		Rdviewer.style.height = 0;
	}
	
	 	
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 
  var strPrintList ="";
  var defaultPrint ="";
  function initPrintList(){
  	strPrintList = Rdviewer.GetLocalInfo("PrnNames", "");
	  defaultPrint = Rdviewer.GetLocalInfo("DefaultPrnName", "");
  	//alert(strPrintList);
  	if(strPrintList == undefined || strPrintList == null || strPrintList == "") return;
  	
		var arrPrintList = strPrintList.split("|");
		
  	printListXml  = " <SHEET> \n";
		printListXml += " <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='"+(arrPrintList.length-1)+"'> \n";
		
		for(var i = 0; i < arrPrintList.length-1; i++) {
			printListXml += " 	<TR><![CDATA["+arrPrintList[i]+"]]></TR> \n";
		}		
		printListXml += " </DATA> \n";
		printListXml += " </SHEET> ";
		//alert(printListXml);
		ComXml2ComboItem(printListXml, form.bl_prn_dvc_nm, "val", "val");
  } 
 
 
   /**
   * 프린트 목록과 저장된 프린트 목록을 확인한다. (확인하여 없으면 기본프린터로 설정하기 위함) 
   * */
  function checkPrintList(val){
		var arrPrintList = strPrintList.split("|");

		for(var i = 0; i < arrPrintList.length-1; i++) {
			if(val == arrPrintList[i]) return true;
		}
		
		return false;
  }


	function rdOpen(){
		
		var printForm = form.print_form.options[form.print_form.selectedIndex].value;
		rdParam = "/rv mode_type[" + form.mode_type.value + "] print_form["+ printForm +"]"; // bkg_no
		rdParam += "vvd_cd[" + form.vvd_cd.value  + "] "; 
		
		if(form.mode_type.value == "I"){
			rdParam += " pol_pod_cd[" + form.pod_cd.value + "] "; 
		}else{
			rdParam += "pol_pod_cd[" + form.pol_cd.value + "] "; 
		}
		
		
		 
		Rdviewer.SetMessageboxShow(1); //에러메시지만 출력함
		Rdviewer.SetPrintInfo (form.bl_prn_dvc_nm.Text, 1, 1, 4);
		Rdviewer.SetPrint2(getRadioValue2(form.paper_type),1,0,100);
		
		if(printForm == "NZ"){
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			rdParam += "pol_cd[] "; // General 에서 안쓰임
			rdParam += "pod_cd[] "; // General 에서 안쓰임
			
			if(printForm == "VN") {
				rdParam += " vietnam_flg[Y] ";
			}	else {
				rdParam += " vietnam_flg[N] ";
			}
			
			if(getRadioValue2(form.paper_type) == '10'){
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829_01.mrd", RDServer + rdParam);
			}else if(getRadioValue2(form.paper_type) == '4'){
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829_02.mrd", RDServer + rdParam);
			}else{
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829.mrd", RDServer + rdParam);
			}
			
			Rdviewer.CMPrint();
			
		}
		else if (printForm == "GEN" || printForm == "NG" || printForm == "VN") {
			//alert(ComGetLenByByte(bkgnoForGeneralRD));
			//return;
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			rdParam += "pol_cd[] pol_yd_cd[" + form.pol_yd_cd.value + "] "; // General 에서 안쓰임
			rdParam += "pod_cd[] pod_yd_cd[" + form.pod_yd_cd.value + "] "; // General 에서 안쓰임

			if(printForm == "VN") {
				rdParam += " vietnam_flg[Y] ";
			}	else {
				rdParam += " vietnam_flg[N] ";
			}
			
			if(getRadioValue2(form.paper_type) == '10'){
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747_01.mrd", RDServer + rdParam);
			}else if(getRadioValue2(form.paper_type) == '4'){
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747_02.mrd", RDServer + rdParam);
			}else{
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747.mrd", RDServer + rdParam);
			}
			
			Rdviewer.CMPrint();
		}else if(printForm == "PH"){
			//TEST****************
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				//alert(getStringToClobString(ComReplaceStr(bkgnoForGeneralRD,"'",""), 200));
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
				//debug.innerHTML = rdParam;
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			//alert(printForm);
				Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_5032.mrd", RDServer + rdParam);
				Rdviewer.CMPrint();
		}else {
			var rdParam2 = "";
			for (var key in bkgnoForUSRD){ 
				if(form.mode_type.value == "O"){
					rdParam2 = "pol_cd[" + form.pol_cd.value + "] ";
					rdParam2 += "pod_cd[" + key + "] ";
				}else{
					rdParam2 =  "pol_cd[" + key + "] ";
					rdParam2 += "pod_cd[" + form.pod_cd.value  + "] "; 
				}
				rdParam2 += "bkg_nos[" + bkgnoForUSRD[key] + "] ";
				  
				//alert(rdParam+rdParam2);
				if(getRadioValue2(form.paper_type) == '10'){
					Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826_01.mrd", RDServer + rdParam+rdParam2);
				}else {
					Rdviewer.FileOpen(RD_path+"apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826.mrd", RDServer + rdParam+rdParam2);
				}
				
				Rdviewer.CMPrint();
			}
		}
	}
	
	
  function goPrintPop()	{		
  	var formObj = document.form;
  	var rdPath  = "";
  	var printForm = form.print_form.options[form.print_form.selectedIndex].value;
    rdParam = "/rv mode_type[" + formObj.mode_type.value + "] print_form["+ printForm +"]"; // bkg_no
		rdParam += "vvd_cd[" + formObj.vvd_cd.value  + "] "; 
		
		if(formObj.mode_type.value == "I"){
			rdParam += "pol_pod_cd[" + formObj.pod_cd.value + "] "; 
		}else{
			rdParam += "pol_pod_cd[" + formObj.pol_cd.value + "] "; 
		}
		
		if(printForm == "NZ"){
			
			//alert(ComGetLenByByte(bkgnoForGeneralRD));
			//return;
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				//alert(getStringToClobString(ComReplaceStr(bkgnoForGeneralRD,"'",""), 200));
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
				//debug.innerHTML = rdParam;
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			//debug.innerHTML = rdParam;
			rdParam += "pol_cd[] "; // General 에서 안쓰임
			rdParam += "pod_cd[] "; // General 에서 안쓰임
			
			if(printForm == "VN") {
				rdParam += " vietnam_flg[Y] ";
			}	else {
				rdParam += " vietnam_flg[N] ";
			}
			
			//alert(printForm);
			if(getRadioValue2(formObj.paper_type) == '10'){
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829_01.mrd";
			}else if(getRadioValue2(formObj.paper_type) == '4') {
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829_02.mrd";
			}else{
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0829.mrd";
			}

		}
		else if (printForm == "GEN" || printForm == "NG" || printForm == "VN") {
			
			//alert(ComGetLenByByte(bkgnoForGeneralRD));
			//return;
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				//alert(getStringToClobString(ComReplaceStr(bkgnoForGeneralRD,"'",""), 200));
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
				//debug.innerHTML = rdParam;
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			//debug.innerHTML = rdParam;
			rdParam += "pol_cd[] pol_yd_cd[" + form.pol_yd_cd.value + "] "; // General 에서 안쓰임
			rdParam += "pod_cd[] pod_yd_cd[" + form.pod_yd_cd.value + "] "; // General 에서 안쓰임

			if(printForm == "VN") {
				rdParam += " vietnam_flg[Y] ";
			}	else {
				rdParam += " vietnam_flg[N] ";
			}
			
			//alert(printForm);
			if(getRadioValue2(formObj.paper_type) == '10'){
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747_01.mrd";
			}else if(getRadioValue2(formObj.paper_type) == '4') {
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747_02.mrd";
			}else{
				rdPath ="apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747.mrd";
			}

		}else if(printForm == "PH"){
			//TEST****************
			if(ComGetLenByByte(bkgnoForGeneralRD) > 4000){
				//alert(getStringToClobString(ComReplaceStr(bkgnoForGeneralRD,"'",""), 200));
				rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
				//debug.innerHTML = rdParam;
			} else{
				rdParam += " bkg_nos['" + bkgnoForGeneralRD + "'] "; // form_type
			}
			//alert(printForm);
				rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_5032.mrd";

		}else {
			var rdParam2 = "";
			for (var key in bkgnoForUSRD){ 
				if(formObj.mode_type.value == "O"){
					rdParam2 = "pol_cd[" + formObj.pol_cd.value + "] ";
					rdParam2 += "pod_cd[" + key + "] ";
				}else{
					rdParam2 =  "pol_cd[" + key + "] ";
					rdParam2 += "pod_cd[" + formObj.pod_cd.value  + "] "; 
				}
				rdParam2 += "bkg_nos[" + bkgnoForUSRD[key] + "] ";
				
				rdParam += rdParam2;  

				if(getRadioValue2(formObj.paper_type) == '10'){
					rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826_01.mrd";
				}else{
					rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826.mrd";
				}

			}
		}
		  	
 		formObj.com_mrdPath.value 		= rdPath;
 		
 		formObj.com_mrdArguments.value 	= rdParam + " /riprnmargin /rwait";

//		Rdviewer.SetPrint2(getRadioValue2(form.paper_type),1,0,100);
 		formObj.com_mrdTitle.value = "General Cargo Manifest";
 		formObj.com_mrdDisableToolbar.value = "";
		formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>General Cargo Manifest</span>";
		
		ComOpenRDPopup();
 	}
 		
    
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  function processButtonClick(){
     			var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

   	try {
     		
     		var srcName = window.event.srcElement.getAttribute("name");
     		
 			switch(srcName) {
 				case "btn_Print":
	 					var arrBkgNo = form.arr_bkg_no.value.split('|');
	 					if(form.arr_bkg_no.value ==""){
	 						ComShowCodeMessage("BKG95009");
	 						return; 
	 					}
						rdOpen();
	 					break;
				case "btn_preview":
						goPrintPop();
		 				//doActionIBSheet(sheetObject1,formObject,MODIFY01);
		 				break;	 					
        case "btn_Close":
		 					self.close();
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
    
    


   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0064GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							
							if(ComGetEtcData(sXml, "bl_prn_dvc_nm") == undefined){
								form.bl_prn_dvc_nm.Code = defaultPrint;
							}else{
								if(!checkPrintList(ComGetEtcData(sXml, "bl_prn_dvc_nm"))){
									form.bl_prn_dvc_nm.Code = defaultPrint;
								}else{
									form.bl_prn_dvc_nm.Code	= ComGetEtcData(sXml, "bl_prn_dvc_nm");
								}
							}
							
							formObj.bl_face_prn_dvc_nm.value	= ComGetEtcData(sXml, "bl_face_prn_dvc_nm");
							formObj.bl_ridr_prn_dvc_nm.value	= ComGetEtcData(sXml, "bl_ridr_prn_dvc_nm");
							
							initPrintList();
							
							break;
						case MODIFY01:        //저장
				 				formObj.f_cmd.value = MODIFY01;
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				var sParam = "&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0743GS.do" , sParam);
								 if (ComGetEtcData(sXml, "success_yn") =="Y"){
								 			ComShowCodeMessage('COM130102','Data');
								 }else{
								 	ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
			    }
     }    


     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
    		case MODIFY01:
			  	if(formObj.bl_prn_dvc_nm.value == "" ){
							ComShowCodeMessage('BKG00626','Print Setup');
							return false;
					}
	  			break;
    	 	}
            return true;
     }     
     
 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // 높이 설정
                 style.height = 150;
                 
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, 10);

								var HeadTitle1 = "Sel|Group|User ID|User Name";

                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

								
						}
 				
 					break;
         
         }
     }     

	/* 개발자 작업  끝 */    
										
		