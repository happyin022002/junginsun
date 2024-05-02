/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_021.js
*@FileTitle  : Inquire/Edit BSA Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/*------------------Following code is added code to make JSDoc ------------------*/
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet_selno=""; 
	var JOINT_OPERATING="";
	var SPACE_CHARTERING="";
//	var splitPos1=new Array(0, 3, 6, 9, 12, 15);
	var splitPos1=new Array(0, 18, 31, 45, 55, 64);
	var splitPos2=new Array(0, 3, 6, 9, 12, 15);
	var fixCnt1=20; //Sheet1 - fixed length 
	var fixCnt2=17; //Sheet2 - fixed length  
	var LOGIC_fnl_capa="";
	var LOGIC_sub_capa="";
	var selRow=0;
	var selValue="";
	var sheet_height1=21; //  height of sheet1
	var sheet_height2=21; //  height of sheet2
	var zoomFlag1="close"; // Zoom Flag #1
	var zoomFlag2="close"; // Zoom Flag #2
	var first_load1=true;  //adjusting height of sheet1 in case of initial loading
	var first_load2=true;  //adjusting height of sheet2 in case of initial loading
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	var ZOOM_IN = "Zoom in(+)";
	var ZOOM_OUT = "Zoom out(-)";
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage(headText1,headText2,headText3,headText4) {
		var head1="";
		var head2="";
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			if (i==0) {
				head1=headText1;
				head2=headText2;
			} else {
				head1=headText3;
				head2=headText4;
			}
			initSheet(sheetObjects[i],i+1,head1,head2);
			ComEndConfigSheet(sheetObjects[i]);
		}		
		loadingMode=true;
		loadXml();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode=false;
		JOINT_OPERATING=document.form.rdoOp_cd[0].value;
		SPACE_CHARTERING=document.form.rdoOp_cd[1].value;
		document.getElementById("tabLayer2").style.display="none";
		//tabLayer2.style.display = "none";
		//Setting UI control		
		ComSetUIItem(sheetObjects[0],document.form,"BSA","ESM_BSA_0021");
		sheet_selno=JOINT_OPERATING; 
		set_Zoom();
		resizeSheet();
	}
	function loadXml() {
    	var formObj=document.form;
 		var sXml=formObj.sXml.value;
 		var arrXml=sXml.split("|$$|");
 		var rtnArr=null;
 		var divStr="";
 		var codeArr=null;
 		var nameArr=null;
 		var checked="";
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
		// JO/SC CheckBox Setting
		if (arrXml.length > 3){
			rtnArr=ComXml2ComboString(arrXml[3], "code", "name");
			codeArr=rtnArr[0].split("|");
			nameArr=rtnArr[1].split("|");
			for(var i=0; i<codeArr.length; i++){
				if (i == 0)
					checked="checked";
				else
					checked="";
				divStr += "\n";
				divStr += "<input type=\"radio\" name=\"rdoOp_cd\" id=\"rdoOp_cd\" value=\""+codeArr[i]+"\" class=\"trans\""+checked+">"+nameArr[i]+"</input>";
				if(i < codeArr.length)
					divStr += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_bsaKind").innerHTML="<div id=\"div_bsaKind\">"+ divStr +"</div>";
		}
		if (arrXml.length > 4){
			rtnArr=ComXml2ComboString(arrXml[4], "code", "name");
			codeArr=null;
			nameArr=null;
			codeArr=rtnArr[0].split("|");
			nameArr=rtnArr[1].split("|");
			divStr="";
			for(var i=0; i<codeArr.length; i++){
				if (i == 0)
					checked="checked";
				else
					checked="";
				divStr += "\n";
				divStr += "<input type=\"radio\" name=\"rdoType\" id=\"rdoType\" value=\""+codeArr[i]+"\" class=\"trans\""+checked+" />&nbsp;" + nameArr[i];
				if(i < codeArr.length)
					divStr += "&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_ui_jo").innerHTML = divStr;
		}
 		document.form.sXml.value="";
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
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	* Setting data of combo coulmn in sheet <br>
	*/
	function setIBMultiCombo(sheetObj, sXml ,objName){
		if (sXml == undefined || sXml == ""){
			return;
		}
		var arrData=ComCoaXml2SheetMultiComboString(sXml, "code", "code");
		sheetObj.SetColProperty(objName, {ComboText:arrData[1], ComboCode:arrData[0]} );
	}
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {		
				case "btn_retrieve":
					if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBSEARCH);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBSEARCH);
					}
					break;
				case "btn_save":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBSAVE);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBSAVE);
					}
					break;
				case "btn_downexcel":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBDOWNEXCEL);
					}
					break;
				case "btns_calendar1":
					var cal=new ComCalendar();
					cal.select(formObject.txtSDate, 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal=new ComCalendar();
					cal.select(formObject.txtEDate, 'yyyy-MM-dd');
					break;
				case "rdoOp_cd":
					if (formObject.rdoOp_cd[0].checked) { 
						document.getElementById("tabLayer1").style.display="inline";
						document.getElementById("tabLayer2").style.display="none";
						sheet_selno=formObject.rdoOp_cd[0].value; 
						//doActionIBSheet(sheet1,formObject,IBSEARCH);
						
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
						if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
							sheet_height1 = ComGetSheetViewRows(sheet1,"MIN", 0);
//							sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 21));
							sheet1.SetSheetHeight(445);
							zoomFlag1="close";
						} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
							sheet_height2 = ComGetSheetViewRows(sheet2,"MIN", 0);
//							sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 21));
							sheet2.SetSheetHeight(445);
							zoomFlag2="close";
						}						
					} else if (formObject.rdoOp_cd[1].checked) { 
						document.getElementById("tabLayer1").style.display="none";
						document.getElementById("tabLayer2").style.display="inline";
						sheet_selno=formObject.rdoOp_cd[1].value; 
						//doActionIBSheet2(sheet2,formObject,IBSEARCH);
						
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
						if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
							sheet_height1 = ComGetSheetViewRows(sheet1,"MIN", 0);
//							sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 21));
							sheet1.SetSheetHeight(445);
							zoomFlag1="close";
						} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
							sheet_height2 = ComGetSheetViewRows(sheet2,"MIN", 0);
//							sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 21));
							sheet2.SetSheetHeight(445);
							zoomFlag2="close";
						}
					}					
					set_Zoom();
					resizeSheet();
					break;
				case "rdoType":
					var checkedIdx=-1;
					var obj=formObject.rdoType;
					for(var i=0; i<obj.length; i++) {
						if (obj[i].checked) {
							checkedIdx=i;
							break;
						}
					}
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//						sheet1.SetHighLeftCol((fixCnt1-1) + splitPos1[checkedIdx]);
						sheet1.SetLeftCol((fixCnt1-1) + splitPos1[checkedIdx]);
//						sheet1.SetLeftCol(37);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						sheet2.SetLeftCol((fixCnt2-1) + splitPos2[checkedIdx]);
					}
					break;
				case "btn_zoom_in":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//						sheet_height1 = ComGetSheetViewRows(sheet1,"MAX",1);											
						
//						2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
						var rowcount = sheet1.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화
												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}
						
						if(totalrowheight+150 > 445){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
													
						
						zoomFlag1="open";
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//						sheet_height2 = ComGetSheetViewRows(sheet2,"MAX",1);
						
						var rowcount = sheet2.RowCount();
						var totalrowheight = 0;
												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet2.GetRowHeight(y);
						}
						
						if(totalrowheight+150 > 445){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}	
						
						zoomFlag2="open";
					}
					set_Zoom();
					break;
				case "btn_zoom_out":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						sheet_height1 = ComGetSheetViewRows(sheet1,"MIN", 0);
//						sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 21));
						sheet1.SetSheetHeight(445);
						zoomFlag1="close";
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						sheet_height2 = ComGetSheetViewRows(sheet2,"MIN", 0);
//						sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 21));
						sheet2.SetSheetHeight(445);
						zoomFlag2="close";
					}
					set_Zoom();
					resizeSheet();
					break;
				case "btng_rowadd":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBINSERT);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBINSERT);
					}
					break;
				case "btng_rowdel":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBDELETE);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBDELETE);
					}
					break;
				case "btng_creation":
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						doActionIBSheet(sheet1,formObject,IBCREATE);
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						doActionIBSheet2(sheet2,formObject,IBCREATE);
					}
					break;
				case "btng_crrinfo":
					 ComOpenWindow("ESM_BSA_0120.do",  "Carrier's Register",  "dialogWidth:406px;dialogHeight:400px" , true);
					//ComOpenWindow("ESM_BSA_0120.do", "Carrier's Register", "width=426,height=375",true);
					break;
				case "btng_addcrrrgst":
					var param="?bsa_op_cd=" + sheet_selno;
					var option="dialogWidth:600px;"
								+ "dialogHeight:380px;"
								+ "status:no;"
								+ "help:no;"
								+ "resizable:no;"
								+ "scroll:no;";
//					ComOpenWindow("ESM_BSA_0023.do"+ param, "Add Carrier", "width=600,height=380",false);
					ComOpenPopup("ESM_BSA_0023.do" + param, 600, 420, null, "0,1,1,1,1,1,1,1,1,1,1,1,1,1", true);
					//window.showModalDialog("ESM_BSA_0023.do" + param, "win_addcrrrgst", option);
					break;
				case "btng_stepupdownbyport":
//					formObject.f_cmd.value="";
//					formObject.method="POST";
//					formObject.action="/opuscntr/ESM_BSA_0026.do?flag=Y&pgmNo=ESM_BSA_0026";
//					formObject.submit();
					
					var winObj=window.open("/opuscntr/ESM_BSA_0026.do?pid=ESM_BSA_M002&MENU=Y&pgmNo=ESM_BSA_0026&parentPgmNo=ESM_BSA_M001&main_page=true&mainMenuLinkFlag=true&menuflag=true&mainPage=true");  
					
					break;
				case "btng_skdinquiry":
					var classId="COM_ENS_0B1";
					var vvd_cd="";  
					if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
						if (sheet1.GetSelectRow()> 0 && sheet1.RowCount()> 0) {
							var vvd_cd=sheet1.GetCellValue(sheet1.GetSelectRow(), 'M_vvd_cd');
						}
					} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
						if (sheet2.GetSelectRow()> 0 && sheet2.RowCount()> 0) {
							var vvd_cd=sheet2.GetCellValue(sheet2.GetSelectRow(), 'M_vvd_cd');
						}
					}
					//if (vvd_cd == "") { vvd_cd = "ABCD1234E"; }
					var param="?vvd_cd=" + vvd_cd + "&classId=" + classId;
					ComOpenPopup("/opuscntr/"+classId+".do"+param, 608, 450, "", "0,0,1,1,1,1,1,1,1,1", false);
					break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	    * setting sheet initial values and header
	    * param : sheetObj, sheetNo
	    * adding case as numbers of counting sheets
	    */
	function initSheet(sheetObj,sheetNo,head1,head2) {
		var formObj=document.form;
		var head0="";
		var arrHead1="";
		var arrHead2="";
		var varCnt=0;
		var cnt=0;
		var HeadTitle0="";
		var HeadTitle1="";
		var HeadTitle2="";
		var n=0;
		var bsaOpJbCd1=formObj.bsa_op_jb_cd.value.replace(/(^\s*)/g, '').split("|");
		var bsaOpJbCd2=formObj.bsa_op_jb_cd2.value.replace(/(^\s*)/g, '').split("|");
		switch(sheetNo) {
			case 1:      //sheet1 init
				if (head1 == "" && head2 == "") {
					head1 = "|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA"
						+ "|Lease|Lease|Lease"
						+ "|Charter in|Charter in|Charter in"
						+ "|Additional Lease|Additional Lease|Additional Lease"
						+ "|Additional Charter in|Additional Charter in|Additional Charter in";
						head2 = "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3";
				}
				
//				2014.09.18 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성 (2014.11.07 보완)
				var arrayHead2=head2.split("|");
				
				head2 = "";
				
				for(j=0; j < arrayHead2.length; j++) {
						if(j%5 == 0 && j != arrayHead2.length - 1){
							arrayHead2[j] = arrayHead2[j] + "|" ;
						}else if(j%5 == 1 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + arrayHead2[j] + " |" ;
						}else if(j%5 == 2 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + arrayHead2[j] + " " + " |" ;
						}else if(j%5 == 3 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + " " + arrayHead2[j] + " " + " " + " |" ;
						}else if(j%5 == 4 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + " " + " " + arrayHead2[j] + " " + " " + " " + " |" ;
						}else if(j == arrayHead2.length - 1){ // 마지막 번째일때
							arrayHead2[j] = " "+ " "+ " "+ " "+ " " + arrayHead2[j] + " "+ " "+ " "+ " " + " " ;
							head2 = head2 + arrayHead2[j];
							break;
						}
						
						head2 = head2 + arrayHead2[j];
					
				}
		
				arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
				arrHead2 = head2.replace(/(^\s*)/g, '').split("|");
				
				varCnt = arrHead2.length - 1;
				
			    with(sheetObj){
				      for (j=1; j<=varCnt; j++) {
					      if(bsaOpJbCd1[j]== "001"){
						      head0 += "|Initial Slots";
						      n++;
					      }else{
					    	  head0 += "|Chartered Slots";
					      }
				      }
				      HeadTitle0="STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|Company\nFinal|Company\nInclude Sub|☆|ownr_vsl_wgt|★" + head0 + "|DESC";
				      HeadTitle1="STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|Company\nFinal|Company\nInclude Sub|☆|ownr_vsl_wgt|★" + head1 + "|DESC";
				      HeadTitle2="STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|Company\nFinal|Company\nInclude Sub|☆|ownr_vsl_wgt|★" + head2 + "|DESC";

				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:16, DataRowMerge:0 } );
				      SetMergeCell(0, 19, 2, n);

				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ 
//				                      { Text:HeadTitle0, Align:"Center"},
				                  { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_group",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, InputCaseSensitive:1, AcceptKeys:"N|E" },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_sub_trd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_vop_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"M_vsl_capa",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"M_bsa_capa",             KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"M_fnl_co_bsa_capa",      KeyField:0,   CalcLogic:LOGIC_fnl_capa,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"M_co_bsa_bfr_sub_capa",  KeyField:0,   CalcLogic:LOGIC_sub_capa,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_spc_otr_swap_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_ownr_vsl_wgt",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      
				      cnt = cols.length;
				      for (n=0; n < varCnt; n++) {
				    	  cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"D_crr_bsa_capa" + n,       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      cols.push({Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"M_jo_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 });
				      //conversion of function[check again]CLT 					InitDataValid(0, "M_dir_cd",  1, "NEWS");       //vtCharOnly=1
				      SetColProperty(0 ,"M_dir_cd" , {AcceptKeys:"NEWS"});
				      SetColProperty(0 ,"M_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      InitColumns(cols);

				      SetEditable(1);
				      //SetMergeCell(0, 19, 2, n);
				      SetHeaderRowHeight(10);
				      if (first_load1 == true) {
//				    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
				    	  SetSheetHeight(440);
				      }
				      first_load1=false;
				      for (n=0; n < varCnt; n++) {
				    	  if (arrHead1[n+1] == "Basic Leased" || arrHead1[n+1] == "Additional Leased") {
//				    		  SetCellBackColor(2, cnt, "#C4D2FF");
				    	  } else {
//				    		  SetCellBackColor(2, cnt, "#D3DBFF");
				    	  }
				    	  cnt++;
				      }
				SetUnicodeByte(3); 
				
	//				2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
					for(z=0; z<=cnt; z++){
						if(GetCellValue(0,z) == "Initial Slots"){
							SetCellBackColor(0, z, "#454545");
							SetToolTipText(0, z, "Initial Slots");
						}else if(GetCellValue(0,z) == "Basic Leased"){
							SetCellBackColor(0, z, "#050099");
							SetToolTipText(0, z, "Basic Leased");
						}else if(GetCellValue(0,z) == "Basic Chartered"){
							SetCellBackColor(0, z, "#8041D9");
							SetToolTipText(0, z, "Basic Chartered");
						}else if(GetCellValue(0,z) == "Additional Leased"){
							SetCellBackColor(0, z, "#99004C");
							SetToolTipText(0, z, "Additional Leased");
						}else if(GetCellValue(0,z) == "Additional Chartered"){
							SetCellBackColor(0, z, "#22741C");
							SetToolTipText(0, z, "Additional Chartered");
						}										
					}
					SetEditArrowBehavior(3); 
			    }
			    break;
			case 2:
				if (head1 == "" && head2 == "") {
					head1="|Initial Slots|Initial Slots|Initial Slots"
						+ "|Basic Lease|Basic Lease|Basic Lease"
						+ "|Basic Chartered|Sub Chartered|Sub Chartered"
						+ "|Additional Lease|Additional Lease|Additional Lease"
						+ "|Additional Chartered|Additional Chartered|Additional Chartered";
					head2="|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3";
				}
				
//				2014.09.18 김용습 - Carrier가 연달아 나올때 merge되는 현상을 피하기 위해 작성 (2014.11.07 보완)
				var arrayHead2=head2.split("|");
				
				head2 = "";
				
				for(j=0; j < arrayHead2.length; j++) {
						if(j%5 == 0 && j != arrayHead2.length - 1){
							arrayHead2[j] = arrayHead2[j] + "|" ;
						}else if(j%5 == 1 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + arrayHead2[j] + " |" ;
						}else if(j%5 == 2 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + arrayHead2[j] + " " + " |" ;
						}else if(j%5 == 3 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + " " + arrayHead2[j] + " " + " " + " |" ;
						}else if(j%5 == 4 && j != arrayHead2.length - 1){ 
							arrayHead2[j] = " " + " " + " " + " " + arrayHead2[j] + " " + " " + " " + " |" ;
						}else if(j == arrayHead2.length - 1){ // 마지막 번째일때
							arrayHead2[j] = " "+ " "+ " "+ " "+ " " + arrayHead2[j] + " "+ " "+ " "+ " " + " " ;
							head2 = head2 + arrayHead2[j];
							break;
						}
						
						head2 = head2 + arrayHead2[j];
					
				}				
								
				arrHead1=head1.replace(/(^\s*)/g, '').split("|");
				arrHead2=head2.replace(/(^\s*)/g, '').split("|");
				varCnt=arrHead2.length - 1;
				
			    with(sheetObj){
				      HeadTitle0="STS|GRP|SEQ|VVD|From|To|Trade|R.Lane|Dir.|VSL\nChk|Seq|VSL\nCode|Final\nCompany BSA|Company BSA\nBefore Sub|☆|★" + head1 + "|DESC";
				      HeadTitle1="STS|GRP|SEQ|VVD|From|To|Trade|R.Lane|Dir.|VSL\nChk|Seq|VSL\nCode|Final\nCompany BSA|Company BSA\nBefore Sub|☆|★" + head2 + "|DESC";
				      
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:14, DataRowMerge:0 } );
				      
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle0, Align:"Center"},  
				                      { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_group",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11, InputCaseSensitive:1, AcceptKeys:"N|E" },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1, InputCaseSensitive:1 },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_vsl_bsa_chk_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
				             {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_vsl_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4, InputCaseSensitive:1 },
				             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"M_co_fnl_bsa_capa",      KeyField:0,   CalcLogic:LOGIC_fnl_capa,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"M_co_bsa_bfr_sub_capa",  KeyField:0,   CalcLogic:LOGIC_sub_capa,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_vsl_mlt_inp_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      cnt = cols.length;
				      for (n=0; n<varCnt; n++) {
				    	  cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"D_crr_bsa_capa"+n,       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      
				      cols.push({Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"M_scht_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 });
				      //conversion of function[check again]CLT 					InitDataValid(0, "M_dir_cd",    1, "NEWS");       //vtCharOnly=1
				      SetColProperty(0 ,"M_dir_cd" , {AcceptKeys:"NEWS"});
				      SetColProperty(0 ,"M_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0 ,"M_vsl_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				      InitColumns(cols);

				      SetEditable(1);
//				      SetCellBackColor(1,cnt,"#C4D2FF");
//				      SetCellBackColor(1,cnt,"#D3DBFF");
				      SetHeaderRowHeight(10);
				      if (first_load2 == true) { 
//				    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height2)); 
				    	  SetSheetHeight(440);
			    	  }
				      first_load2=false;
				      for (n=0; n<varCnt; n++) {
				    	  if (arrHead1[n+1] == "Sub Lease" || arrHead1[n+1] == "Additional Lease") {
//				    		  SetCellBackColor(1, cnt, "#C4D2FF");
				    	  } else {
//				    		  SetCellBackColor(1, cnt, "#D3DBFF");
				    	  }
				    	  cnt++;
				      }
				SetUnicodeByte(3);
				
	//				2014.10.31 김용습 - 헤더 색갈 및 툴팁 적용
					for(z=0; z<=cnt; z++){
						if(GetCellValue(0,z) == "Initial Slots"){
							SetCellBackColor(0, z, "#454545");
							SetToolTipText(0, z, "Initial Slots");
						}else if(GetCellValue(0,z) == "Basic Leased"){
							SetCellBackColor(0, z, "#050099");
							SetToolTipText(0, z, "Basic Leased");
						}else if(GetCellValue(0,z) == "Basic Chartered"){ 
							SetCellBackColor(0, z, "#8041D9");
							SetToolTipText(0, z, "Basic Chartered");
						}else if(GetCellValue(0,z) == "Additional Leased"){
							SetCellBackColor(0, z, "#99004C");
							SetToolTipText(0, z, "Additional Leased");
						}else if(GetCellValue(0,z) == "Additional Chartered"){	
							SetCellBackColor(0, z, "#22741C");
							SetToolTipText(0, z, "Additional Chartered");
						}										
					}
					SetEditArrowBehavior(3); 
			    }
			break;
		}
	}
	/**
	* Setting combo item
	*/
	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			SetDropHeight(300);
			InsertItem(0, 'All' ,''); 
//			Index=0;
			SetSelectIndex(0);
			ValidChar(2,1);
		}
	}
	// Handling the process realated with sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheet1.ShowDebugMsg(false);
		switch(sAction) {		
			case IBSEARCH:     
				//sheet1.SetWaitImageVisible(1);
				if (!validateCond(formObj, sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST01;
				ComOpenWait(true);
				setTimeout( function(){
					var sXml = sheet1.GetSearchData("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo)));
					//var gXml = xml.split("|$$|");
					var head1=GetEtcDataForExceptional(sXml, "head1");
					var head2=GetEtcDataForExceptional(sXml, "head2");
					var head3=GetEtcDataForExceptional(sXml, "head3");
					LOGIC_fnl_capa=GetEtcDataForExceptional(sXml, "logic1");
					LOGIC_sub_capa=GetEtcDataForExceptional(sXml, "logic2");
					if (head1 != "" && head2 != "") {
						formObj.bsa_op_jb_nm1.value=head1;
						formObj.jHeader.value=head2;
						formObj.bsa_op_jb_cd.value=head3;
						sheet1.RenderSheet(0);
						sheet1.SetVisible(0);
	//					sheet1.RemoveAll();
						sheet1 = sheet1.Reset();
						ComConfigSheet(sheet1);
						initSheet(sheet1, 1, head1, head2);
						sheet1.SetVisible(1);
						sheet1.RenderSheet(1);
						sheet1.LoadSearchData(sXml,{Sync:1} );
						sheet1.RemoveEtcData();
					}
	//				sheetObj.InitHeadMode(true, true, false, true, false, false); 
					setOffsetPos(head1);
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:     
				if (!validateForm(sheet1)) {
					return false;
				}
				formObj.f_cmd.value=MULTI01;
				sheet1.DoSave("ESM_BSA_0021GS.do", bsaFormString(formObj, getParam(curPgmNo,'S')), -1, true);
				
//				2015.06.06 김용습 - 저장 완료 메시지 추가
//				ComShowCodeMessage("BSA10047");
				//sheetObj.EtcData("comment");
				break;
			case IBDOWNEXCEL:  
				//sheetObj.SpeedDown2Excel(-1);
				selectDownExcelMethod(sheet1);
				
//				switch (excelType) {
//				case "AY":
//					if(sheet1.RowCount() < 1){//no data
//						ComShowCodeMessage("COM132501");
//					}else{
//						sheet1.Down2Excel({ HiddenColumn:0,Merge:true});
//					}
//				break;
//				case "DY":
//					if(sheet1.RowCount() < 1){//no data
//						ComShowCodeMessage("COM132501");
//					}else{
//						sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
//					}
//				break;
//				case "AN":
//					if(sheet1.RowCount() < 1){//no data
//						ComShowCodeMessage("COM132501");
//					}else{
//						sheet1.Down2Excel({ HiddenColumn:0});
//					}
//				break;
//				case "DN":
//					if(sheet1.RowCount() < 1){//no data
//						ComShowCodeMessage("COM132501");
//					}else{
//						sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
//					}
//				break;
//				}               
				break;
			case IBINSERT:      
				with(sheet1) {
					if (RowCount()> 0) {
						SetSelectRow(getMaxRow(sheet1));
						var Row=DataCopy(false);
						if (Row > HeaderRows()) {
							//InitHeadMode(false, true, false, true, false, false);
							SetCellValue(Row,"M_bsa_seq",parseInt(GetCellValue(Row,"M_bsa_seq")) + 1,0);
							//not modifying bsa_to_dt in previous row in case previous row exist.
							//20160317.MOD : 수정최소화하기위해 새로..
							var grpRow=getFindRows(sheet1,Row);
							if (grpRow != "") {
								var arrRow=grpRow.split(",");
								for(i=0; i < arrRow.length; i++) {
									if(parseInt(GetCellValue(arrRow[i],"M_bsa_seq")) < parseInt(GetCellValue(Row,"M_bsa_seq"))){									
										SetCellEditable(arrRow[i],"M_bsa_fm_dt",0);		//20160119.ADD
										SetCellEditable(arrRow[i],"M_bsa_to_dt",0);	
										SetCellEditable(Row,"M_bsa_fm_dt",1);
										SetCellEditable(Row,"M_bsa_to_dt",1);										
									}
								}
							}
						}
					} //end of if
				}
				break;
			case IBDELETE:     
				with(sheet1) {
					if (GetSelectRow()> 0 && RowCount()> 0) {
						var currRow=GetSelectRow();
						var stat=GetRowStatus(currRow);
						if (getMaxRow(sheet1) != currRow) { //permitting deletion in case of max row  
							ComShowMessage(ComGetMsg('BSA10029')); //You can delete maximum number in the same group.
						} else {
							var grpRow=getFindRow(sheet1,currRow,-1);
							SetRowStatus(currRow,"D");
							if (stat != "I") { 
								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { //Do you want to delete the selected data?
									if (grpRow != -1) {
										//permitting modification of bsa_to_dt in previous row
										SetCellEditable(grpRow,"M_bsa_to_dt",1);
										//Copying bsa_to_dt in current row to bsa_to_dt in previous row
										SetCellValue(grpRow,"M_bsa_to_dt",GetCellValue(currRow,"M_bsa_to_dt"),0);
									} 
									formObj.f_cmd.value=REMOVE01;
									DoSave("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
									//RowDelete(currRow,false);
								} else {
									SetRowStatus(currRow,stat);//restore sth to its original data
								}
							} else { 
								if (grpRow != -1) {
									//permitting modification of bsa_to_dt in previous row
									SetCellEditable(grpRow,"M_bsa_to_dt",1);
									SetCellEditable(grpRow,"M_bsa_to_dt",1);
								}
							}
						}
					}
				}
				break;
			case IBCREATE:      
				if (!validateCond(formObj, sAction)) {
					return false;
				}
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { 
					formObj.f_cmd.value=MULTI03;
					sheet1.DoSearch("ESM_BSA_0021GS.do", bsaFormString(formObj, getParam(curPgmNo)));
					var err_cd=sheet1.GetEtcData("err_cd");
					var err_msg=sheet1.GetEtcData("err_msg");
					formObj.f_cmd.value=SEARCHLIST01;
					
//					2014.11.04 김용습 - creation 과정 중 로딩화면 뜨게 함
					setTimeout( function(){
						var sXml=sheet1.GetSearchData("ESM_BSA_0021GS.do", bsaFormString(formObj, getParam(curPgmNo)));
						var head1=GetEtcDataForExceptional(sXml, "head1");
						var head2=GetEtcDataForExceptional(sXml, "head2");
						var head3=GetEtcDataForExceptional(sXml, "head3");
						LOGIC_fnl_capa=GetEtcDataForExceptional(sXml, "logic1");
						LOGIC_sub_capa=GetEtcDataForExceptional(sXml, "logic2");
						if (head1 != "" && head2 != "") {
							formObj.bsa_op_jb_nm1.value=head1;
							formObj.jHeader.value=head2;
							formObj.bsa_op_jb_cd.value=head3;
							sheet1.RenderSheet(0);
							sheet1.SetVisible(0);
	//						sheet1.RemoveAll();
							sheet1 = sheet1.Reset();
							ComConfigSheet(sheet1);
							initSheet(sheet1, 1, head1, head2);
							sheet1.SetVisible(1);
							sheet1.RenderSheet(1);
							sheet1.LoadSearchData(sXml,{Sync:1} );
							sheet1.RemoveEtcData();
						}
	//					sheet1.InitHeadMode(true, true, false, true, false, false); 
						setOffsetPos(head1);
						if (err_cd == "00000" || err_cd == undefined || err_cd == "") {
							ComShowMessage(ComGetMsg('BSA10018','CREATION')); //CREATION process has been completed normally.
						}
					}, 100);
				}
				break;
		}
	}
	function callBackExcelMethod(excelType) {
		
		if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
			var sheetObj = sheet1;
		} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
			var sheetObj = sheet2;
		}
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
			return;
		}
		switch (excelType) {
		case "AY":
			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
			break;
		case "AN":
			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
			break;
		case "DY":
			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
			break;
		case "DN":
			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
			break;
		 }
	}
	//  Handling the process realated with Sheet
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheet2.ShowDebugMsg(false);
		var grpRow=0;
		switch(sAction) {
			case IBSEARCH:     
				if (!validateCond(formObj, sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST02;
				ComOpenWait(true);
				setTimeout( function(){
					var sXml=sheet2.GetSearchData("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
					var head1=GetEtcDataForExceptional(sXml, "head1");
					var head2=GetEtcDataForExceptional(sXml, "head2");
					var head3=GetEtcDataForExceptional(sXml, "head3");
					LOGIC_fnl_capa=GetEtcDataForExceptional(sXml, "logic1");
					LOGIC_sub_capa=GetEtcDataForExceptional(sXml, "logic2");
					if (head1 != "" && head2 != "") {
						formObj.bsa_op_jb_nm2.value=head1;
						formObj.sHeader.value=head2;
						formObj.bsa_op_jb_cd2.value=head3;
						sheet2.RenderSheet(0);
						sheet2.SetVisible(0);
	//					sheet2.RemoveAll();
						sheet2 = sheet2.Reset();
						ComConfigSheet(sheet2);
						initSheet(sheet2, 2, head1, head2);
						sheet2.SetVisible(1);
						sheet2.RenderSheet(1);
						sheet2.LoadSearchData(sXml,{Sync:1} );
						sheet2.RemoveEtcData();
					}
	//				sheetObj.InitHeadMode(true, true, false, true, false, false); 
					setOffsetPos(head1);
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:   
				if (!validateForm(sheet2)) {
					return false;
				}
				formObj.f_cmd.value=MULTI02;        
				sheet2.DoSave("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
				
//				2015.06.06 김용습 - 저장 완료 메시지 추가
//				ComShowCodeMessage("BSA10047");
				break;
			case IBDOWNEXCEL:   
				//sheetObj.SpeedDown2Excel(-1);
				var excelType=selectDownExcelMethod(sheet2);
				switch (excelType) {
					case "AY":
						if(sheet2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheet2.Down2Excel({ HiddenColumn:0,Merge:true});
						}
						break;
					case "DY":
						if(sheet2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheet2.Down2Excel({ HiddenColumn:-1,Merge:true});
						}
						break;
					case "AN":
						if(sheet2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheet2.Down2Excel({ HiddenColumn:0});
						}
						break;
					case "DN":
						if(sheet2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheet2.Down2Excel( {DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1,Merge:1 });
						}
						break;
				}               
				break;
			case IBINSERT:     
				with(sheetObj) {
					if (RowCount()> 0) {
						SetSelectRow(getMaxRow(sheet2));
						var Row=DataCopy(false);
						if (Row > HeaderRows()) {
							//InitHeadMode(false, true, false, true, false, false); 
							SetCellValue(Row,"M_bsa_seq",parseInt(GetCellValue(Row,"M_bsa_seq")) + 1,0);
							SetCellValue(Row,"M_vsl_seq",1,0);
							//not modifying bsa_to_dt in previous row in case previous row exist.
							//20160317.MOD : 수정최소화하기위해 새로..
							var grpRow=getFindRows(sheet2,Row);
							if (grpRow != "") {
								var arrRow=grpRow.split(",");
								for(i=0; i < arrRow.length; i++) {
									if(parseInt(GetCellValue(arrRow[i],"M_bsa_seq")) < parseInt(GetCellValue(Row,"M_bsa_seq"))){									
										SetCellEditable(arrRow[i],"M_bsa_fm_dt",0);		//20160119.ADD
										SetCellEditable(arrRow[i],"M_bsa_to_dt",0);	
										SetCellEditable(Row,"M_bsa_fm_dt",1);
										SetCellEditable(Row,"M_bsa_to_dt",1);										
									}
								}
							}
							//Setting CellEditable of vsl_cd checkbox
							if (GetCellValue(Row,"M_vsl_bsa_chk_flg") == "1") {
								SetCellEditable(Row,"M_vsl_cd",1);
							} else if (GetCellValue(Row,"M_vsl_bsa_chk_flg") == "0") {
								SetCellEditable(Row,"M_vsl_cd",0);
							}
						}
					} //end of if
				}
				break;
			case IBDELETE:      
				with(sheetObj) {
					if (GetSelectRow()> 0 && RowCount()> 0) {
						var currRow=GetSelectRow();
						var stat=GetRowStatus(GetSelectRow());
						if (getMaxRow(sheet2) != currRow) { //permitting deletion in case of max row 
							ComShowMessage(ComGetMsg('BSA10029'));  //You can delete maximum number in the same group.
						} else {
							var grpRow=getFindRow(sheet2,currRow,-1);
							SetRowStatus(currRow,"D");
							if (stat != "I") { 
								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { 
									if (grpRow != -1) {
										//permitting modification of bsa_to_dt in previous row
										SetCellEditable(grpRow,"M_bsa_to_dt",1);
										//Copying bsa_to_dt in current row to bsa_to_dt in previous row
										SetCellValue(grpRow,"M_bsa_to_dt",GetCellValue(currRow,"M_bsa_to_dt"),0);
									}
									formObj.f_cmd.value=REMOVE02;
									DoSave("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
									//RowDelete(currRow,false);
								} else {
									SetRowStatus(currRow,stat);//restore sth to its original data
								}
							} else { 
								if (grpRow != -1) {
									///permitting modification of bsa_to_dt in previous row
									SetCellEditable(grpRow,"M_bsa_to_dt",1);
								}
							}
						}
					}
				}
				break;
			case IBCREATE:      
				if (!validateCond(formObj, sAction)) {
					return false;
				}
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { 
					formObj.f_cmd.value=MULTI04;
					sheet2.DoSearch("ESM_BSA_0021GS2.do", bsaFormString(formObj, getParam(curPgmNo)));
					var err_cd=sheet2.GetEtcData("err_cd");
					var err_msg=sheet2.GetEtcData("err_msg");
					formObj.f_cmd.value=SEARCHLIST02;
					var sXml=sheet2.GetSearchData("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
					var head1=GetEtcDataForExceptional(sXml, "head1");
					var head2=GetEtcDataForExceptional(sXml, "head2");
					var head3=GetEtcDataForExceptional(sXml, "head3");
					LOGIC_fnl_capa=GetEtcDataForExceptional(sXml, "logic1");
					LOGIC_sub_capa=GetEtcDataForExceptional(sXml, "logic2");
					if (head1 != "" && head2 != "") {
						formObj.bsa_op_jb_nm2.value=head1;
						formObj.sHeader.value=head2;
						formObj.bsa_op_jb_cd2.value=head3;
						sheet2.RenderSheet(0);
						sheet2.SetVisible(0);
//						sheet2.RemoveAll();
						sheet2 = sheet2.Reset();
						ComConfigSheet(sheet2);
						initSheet(sheet2, 2, head1, head2);
						sheet2.SetVisible(1);
						sheet2.RenderSheet(1);
						sheet2.LoadSearchData(sXml,{Sync:1} );
						sheet2.RemoveEtcData();
					}
//					sheet2.InitHeadMode(true, true, false, true, false, false); 
					setOffsetPos(head1);
					if (err_cd == "00000" || err_cd == undefined || err_cd == "") {
						ComShowMessage(ComGetMsg('BSA10018','CREATION')); //CREATION process has been completed normally.'
					}
				}
				break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			SetSumText(0,0,"" );
			SetSumText(0,"M_vvd_cd","TOTAL" );
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.
		//sheetObj.RenderSheet(0);
		
		if(document.form.isExcludZero.checked) {
			//sheetObj.SetFrozenCol(1);
      	    sheetObj.RenderSheet(0);      	    
			
			for(var k=16; k<=sheetObj.LastCol(); k++) {
				//if(sheetObj.GetCellBackColor(1, k) != sheetObj.GetCellBackColor(2, k) && parseFloat(sheetObj.GetSumValue(0, k)) == 0.00)
				if(parseFloat(sheetObj.GetSumValue(0, k)) == 0.00){
					sheetObj.SetColHidden(k, 1);
					sheetObj.SetColWidth(k,0);
				}
			}
			sheetObj.RenderSheet(1);
		} else {
			sheetObj.RenderSheet(0);
//			2014.11.17 김용습 - DESC 컬럼의 넓이가 강제로 60으로 설정되지 않도록 하기 위해, for문이 마지막 컬럼전까지만 실행되게 함('k<=sheetObj.LastCol()'를 'k<=(sheetObj.LastCol()-1)'으로 변경)
			for(var k=16; k<=(sheetObj.LastCol()-1); k++){
				//if(sheetObj.GetCellBackColor(1, k) != sheetObj.GetCellBackColor(2, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
				if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
					sheetObj.SetColHidden(k, 0);
				}
				sheetObj.SetColWidth(k,60);  
			}
			sheetObj.RenderSheet(1);
		}
		
		//sheetObj.RenderSheet(1);
		//ComOpenWait(false);
	}
	
	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		//ComOpenWait(false);
		with(sheetObj){
			SetSumText(0,0,"" );
			SetSumText(0,"M_vvd_cd","TOTAL" );
		}
		//Making the column hidden in case isExcludZero is checked and total value is zero.
		
		if(document.form.isExcludZero.checked) {
			sheetObj.RenderSheet(0);
//			2014.11.26 김용습 - DESC 컬럼의 넓이가 강제로 60으로 설정되지 않도록 하기 위해, for문이 마지막 컬럼전까지만 실행되게 함('k<=sheetObj.LastCol()'를 'k<=(sheetObj.LastCol()-1)'으로 변경)
//							(그렇지 않으면 Carriers with BSA only를 체크하고 조회시 시트 넓이가 줄어들어져서 보입니다)
			for(var k=16; k<=(sheetObj.LastCol()-1); k++) {
				//if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
				if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
					sheetObj.SetColHidden(k, 1);
					sheetObj.SetColWidth(k,0);
				}
				sheetObj.SetColWidth(k,60);  
			}
			sheetObj.RenderSheet(1);
		} else {
			sheetObj.RenderSheet(0);
//			2014.11.17 김용습 - DESC 컬럼의 넓이가 강제로 60으로 설정되지 않도록 하기 위해, for문이 마지막 컬럼전까지만 실행되게 함('k<=sheetObj.LastCol()'를 'k<=(sheetObj.LastCol()-1)'으로 변경)
			for(var k=16; k<=(sheetObj.LastCol()-1); k++){
				//if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
				if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
					sheetObj.SetColHidden(k, 0);
				}
				sheetObj.SetColWidth(k,60);  
			}	      
			sheetObj.RenderSheet(1);
		}	
	}
	
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		var grpRow=-1;
		var param="";
		with(sheetObj) {
			if (ColSaveName(Col) == "M_bsa_fm_dt") {
				grpRow=getFindRow(sheetObj,Row,-1);
				if (grpRow != -1) {
					SetCellValue(grpRow,"M_bsa_to_dt",getOffsetDate(Value,-1),0);
				}
			}
			if (ColSaveName(Col) == "M_vvd_cd") {
				selRow=Row;
				selValue=Value;
				//SJH.20150209.ADD
				if(GetCellValue(selRow,"M_dir_cd") != "" && selValue != "" ) {
					if(GetCellValue(selRow,"M_dir_cd") != selValue.substring(selValue.length-1)) {
						alert("VVD's Last Element is not the same as Dir.");
						SetCellValue(selRow,"M_vvd_cd","",0);
						return false;						
					}
				}				
				param=param+"f_cmd="+SEARCHLIST02;
				param=param+"&vvd_cd="+sheetObj.GetCellValue(Row,Col);
				param=param+"&code=etdDt";
				var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
				var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
				getEdtDate(etdDt);
			}			
    		//SJH.20150211.ADD : TO > FROM 이어야함.
    		if (ColSaveName(Col) == "M_bsa_fm_dt" || ColSaveName(Col) == "M_bsa_to_dt") {        			
    			selRow=Row;
				if(GetCellValue(selRow,"M_bsa_fm_dt") != "" && GetCellValue(selRow,"M_bsa_to_dt") != "" ) {
					if ( parseInt(GetCellValue(selRow, "M_bsa_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_to_dt")) ) {
			  	 		alert("From Date is greater than To Date.");
			  	 		SetCellValue(selRow,"M_bsa_to_dt","",0);
						ComOpenWait(false);
						return false;
					}
				} 
    		}
		}
	}
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var grpRow=-1;
		var param="";
		with(sheetObj){
			if (ColSaveName(Col) == "M_bsa_fm_dt") {
				grpRow=getFindRow(sheetObj,Row,-1);
				if (grpRow != -1) {
					if (sheetObj.GetCellValue(Row, "M_vsl_bsa_chk_flg") == sheetObj.GetCellValue(grpRow, "M_vsl_bsa_chk_flg") &&
						sheetObj.GetCellValue(Row, "M_vsl_cd") == sheetObj.GetCellValue(grpRow, "M_vsl_cd")) {
							SetCellValue(grpRow,"M_bsa_to_dt",getOffsetDate(Value,-1),0);
						}
				}
			}
			if (ColSaveName(Col) == "M_vsl_bsa_chk_flg") {
				if (GetCellValue(Row,"M_vsl_bsa_chk_flg") == "1") {
					SetCellEditable(Row,"M_vsl_cd",1);
				} else if (GetCellValue(Row,"M_vsl_bsa_chk_flg") == "0") {
					SetCellEditable(Row,"M_vsl_cd",0);
				}
			}
			if (ColSaveName(Col) == "M_vvd_cd") {
				selRow=Row;
				selValue=Value;
				//SJH.20150209.ADD
				if(GetCellValue(selRow,"M_dir_cd") != "" && selValue != "" ) {
					if(GetCellValue(selRow,"M_dir_cd") != selValue.substring(selValue.length-1)) {
						alert("VVD's Last Element is not the same as Dir.");
						SetCellValue(selRow,"M_vvd_cd","",0);
						return false;						
					}
				}					
				param=param+"f_cmd="+SEARCHLIST02;
				param=param+"&vvd_cd="+sheetObj.GetCellValue(Row, Col);
				param=param+"&code=etdDt";
				var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
				var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
				getEdtDate(etdDt);
			}
    		//SJH.20150211.ADD : TO > FROM 이어야함.
    		if (ColSaveName(Col) == "M_bsa_fm_dt" || ColSaveName(Col) == "M_bsa_to_dt") {        			
    			selRow=Row;
				if(GetCellValue(selRow,"M_bsa_fm_dt") != "" && GetCellValue(selRow,"M_bsa_to_dt") != "" ) {
					if ( parseInt(GetCellValue(selRow, "M_bsa_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_to_dt")) ) {
			  	 		alert("From Date is greater than To Date.");
			  	 		SetCellValue(selRow,"M_bsa_to_dt","",0);
						ComOpenWait(false);
						return false;
					}
				} 
    		}			
		}
	}
	/**
	*  handling process for input validation
	*/
	function validateForm(sheetObj) {
		with(sheetObj){
			// in case From date > To date 
//			var cnt = sheetObj.RowCount + 3;
//			for(i = 3; i < cnt; i++){
			for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i, "M_bsa_fm_dt") > sheetObj.GetCellValue(i, "M_bsa_to_dt")) {
					ComShowCodeMessage('BSA10045');
					return false;
				}
				if(sheetObj.GetCellValue(i, "M_bsa_fm_dt") =="" || sheetObj.GetCellValue(i, "M_bsa_to_dt")=="") {
					ComShowCodeMessage('BSA10002', "date");
					return false;
				}
				//SJH.20150209.ADD
				if(GetCellValue(i, "ibflag") == "I" || GetCellValue(i, "ibflag") == "U"){
					for ( var z = HeaderRows(); z <= LastRow(); z++) {						
						if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
							if (z != i &&
								GetCellValue(z,"M_trd_cd") == GetCellValue(i,"M_trd_cd") && 
								GetCellValue(z,"M_sub_trd_cd") == GetCellValue(i,"M_sub_trd_cd") && 
								GetCellValue(z,"M_rlane_cd") == GetCellValue(i,"M_rlane_cd") &&
								GetCellValue(z,"M_dir_cd") == GetCellValue(i,"M_dir_cd") &&
								GetCellValue(z,"M_vop_cd") == GetCellValue(i,"M_vop_cd") &&
								GetCellValue(z,"M_bsa_capa") == GetCellValue(i,"M_bsa_capa")) {
								if (GetCellValue(i, "M_bsa_fm_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
							  	 		 return false; 
									}
								}
								//SJH.20150211.ADD
								if (GetCellValue(i, "M_bsa_to_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {
									 	 alert("Effective Date can not be Duplicate. ( "+(i-HeaderRows()+1)+" Row )");							  	 		 
							  	 		 return false; 
									}
								}								
							}							
						} else if (sheet_selno == SPACE_CHARTERING) {//in case of 2nd sheet
							if (z != i &&
								GetCellValue(z,"M_trd_cd") == GetCellValue(i,"M_trd_cd") && 
								GetCellValue(z,"M_rlane_cd") == GetCellValue(i,"M_rlane_cd") &&
								GetCellValue(z,"M_dir_cd") == GetCellValue(i,"M_dir_cd") &&
								GetCellValue(z,"M_vsl_cd") == GetCellValue(i,"M_vsl_cd")) {
								if (GetCellValue(i, "M_bsa_fm_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
							  	 		 return false; 
									}
								}
								//SJH.20150211.ADD
								if (GetCellValue(i, "M_bsa_to_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {
										alert("Effective Date can not be Duplicate. ( "+(i-HeaderRows()+1)+" Row )");		
							  	 		 return false; 
									}
								}								
							}							
						}
					}  	
				} 				
			}			
			// in case of duplicating From/To date of same Trade/Lane/Direction/Operator/Vessel Capa
//			var dup="";
//			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//				dup = sheetObj.ColValueDupRows("M_trd_cd|M_rlane_cd|M_dir_cd|M_vop_cd|M_vsl_capa", true, true);
//			} else if (sheet_selno == SPACE_CHARTERING) {//in case of 2nd sheet
//				dup = sheetObj.ColValueDupRows("M_trd_cd|M_rlane_cd|M_dir_cd|M_co_fnl_bsa_capa", true, true);
//			}
//			if(dup != "") {
//				var arrRow1=dup.split("|");
//				var arrRow2=arrRow1[0].split(",");	// Array to starndard row
//				var arrRow3=arrRow1[1].split(",");	// Array to duplicated row
//				// duplication check in duplicated row
//				for(i=0; i < arrRow2.length; i++) {
//					for(j=0; j < arrRow3.length; j++) {
//						// except duplicated row that is smaller than starndard row
//						if(arrRow2[i] < arrRow3[j]) {
//							// Searching the row which is same as starndard row in duplicated row's array
//							if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
//								if(    sheetObj.GetCellValue(arrRow2[i], "M_trd_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_trd_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_rlane_cd") == sheetObj.GetCellValue(arrRow3[j], "M_rlane_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_dir_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_dir_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_vop_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_vop_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_vsl_capa") == sheetObj.GetCellValue(arrRow3[j], "M_vsl_capa") ) {
//									if(sheetObj.GetCellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.GetCellValue(arrRow2[i], "M_bsa_to_dt")) {
//										ComShowCodeMessage('BSA10045');
//										return false;
//									}
//								}	
//							} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//								if(    sheetObj.GetCellValue(arrRow2[i], "M_trd_cd")           == sheetObj.GetCellValue(arrRow3[j], "M_trd_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_rlane_cd")         == sheetObj.GetCellValue(arrRow3[j], "M_rlane_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_dir_cd")           == sheetObj.GetCellValue(arrRow3[j], "M_dir_cd")
//										&& sheetObj.GetCellValue(arrRow2[i], "M_co_fnl_bsa_capa") == sheetObj.GetCellValue(arrRow3[j], "M_co_fnl_bsa_capa") ) {
//									if(sheetObj.GetCellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.GetCellValue(arrRow2[i], "M_bsa_to_dt")) {
//										ComShowCodeMessage('BSA10045');
//										return false;
//									}
//								}
//							}	
//						}
//					}
//				}
//				// duplication check in duplicated row 
//				for(i=0; i < arrRow3.length; i++) {
//					for(j=i+1; j < arrRow3.length; j++) {
//						// except duplicated row that is smaller than starndard row
//						if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//							if(    sheetObj.GetCellValue(arrRow3[i], "M_trd_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_trd_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_rlane_cd") == sheetObj.GetCellValue(arrRow3[j], "M_rlane_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_dir_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_dir_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_vop_cd")   == sheetObj.GetCellValue(arrRow3[j], "M_vop_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_vsl_capa") == sheetObj.GetCellValue(arrRow3[j], "M_vsl_capa") ) {
//								if(sheetObj.GetCellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.GetCellValue(arrRow3[i], "M_bsa_to_dt")) {
//									ComShowCodeMessage('BSA10045');
//									return false;
//								}
//							}
//						} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//							if(    sheetObj.GetCellValue(arrRow3[i], "M_trd_cd")           == sheetObj.GetCellValue(arrRow3[j], "M_trd_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_rlane_cd")         == sheetObj.GetCellValue(arrRow3[j], "M_rlane_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_dir_cd")           == sheetObj.GetCellValue(arrRow3[j], "M_dir_cd")
//									&& sheetObj.GetCellValue(arrRow3[i], "M_co_fnl_bsa_capa") == sheetObj.GetCellValue(arrRow3[j], "M_co_fnl_bsa_capa") ) {
//								if(sheetObj.GetCellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.GetCellValue(arrRow3[i], "M_bsa_to_dt")) {
//									ComShowCodeMessage('BSA10045');
//									return false;
//								}
//							}
//						}	
//					}
//				}
//			}
		}
		return true;
	}
	/**
	* handling process for search validation
	*/
	function validateCond(formObj, sAction) {
		with(formObj){	
			if (ComTrim(txtSDate.value) == "") {
				//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
				//formObj.txtSDate.focus();
				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
				return false;
			}
			if (sAction == IBCREATE) { } //check it in case of creation
			if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
				if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
					//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
					//txtEDate.focus();
					ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
					return false;
				}
			}
		}
		return true;
	}
	//Handling Enter-Key 
	function keyEnter_loc(){
		var sheet1=sheetObjects[0];
		var sheet2=sheetObjects[1];
		var formObject=document.form;
		if (event.keyCode == 13) {
			if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
				doActionIBSheet(sheet1,formObject,IBSEARCH);
			} else if (sheet_selno == SPACE_CHARTERING) { // in case of 2nd sheet
				doActionIBSheet2(sheet2,formObject,IBSEARCH);
			}
		}
	}
	//moving from location according to each rdoType
	function setOffsetPos(head) {
		var shead=head.split("|");
		var idx=0;
		var cnt=0;
		var old=shead[0];
		for(var i=1; i<shead.length; i++) {
			if (old != shead[i]) {
				if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
					splitPos1[idx]=cnt;
				} else if (sheet_selno == SPACE_CHARTERING) { // in case of 2nd sheet
					splitPos2[idx]=cnt;
				}
				idx=idx + 1;
			}
			cnt=cnt + 1;
			old=shead[i];
		}
		if (sheet_selno == JOINT_OPERATING) { // in case of 1st sheet
			splitPos1[idx]=cnt;
		} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
			splitPos2[idx]=cnt;
		}
	}
	//Returning high row/ low row of selected row in sheet
	function getFindRow(sheetObj, Row, offset) {
		var rtnRow=-1;
		var bsa_group="";
		var bsa_seq=-1;
		var col1=0;
		var col2=0;
		var tmp=0;
		with(sheetObj) {
			bsa_group=GetCellValue(Row,"M_bsa_group");
			bsa_seq=parseInt(GetCellValue(Row,"M_bsa_seq")) + offset;
			for (var i=HeaderRows(); i<LastRow(); i++) {
				col1=FindText("M_bsa_group", bsa_group, tmp);
				if (col1 == -1) { break; } //Not Found
				col2=FindText("M_bsa_seq", String(bsa_seq), col1);
				if (col1 == col2) { //Found
					rtnRow=col2;
					break;
				}
				tmp=col1 + 1;
			}
		}
		return rtnRow;
	}
	//20160317.ADD : 기준 앞에만 비활성화.
	function getFindRows(sheetObj, Row) {
		var rtnRow="";	
		var col1=0;
		var tmp=0;
		with(sheetObj) {
			for (var i=HeaderRows(); i<LastRow(); i++) {				
				col1=FindText("M_bsa_group", GetCellValue(Row,"M_bsa_group"), tmp);
				if (col1 == -1) { 
					rtnRow = rtnRow.substring(0, rtnRow.length-1);
					break; 
				} //Not Found
				SetCellEditable(col1,"M_bsa_fm_dt",1);
				SetCellEditable(col1,"M_bsa_to_dt",1);
				rtnRow=rtnRow+col1+",";
				tmp=col1 + 1;
			}
		}
		return rtnRow;
	}		
	//VVD --> edt-date
	function getEdtDate(result) {
		var tmpRow=0;
		if(result == null || result == "" || result == "null"){
			ComShowMessage(ComGetMsg('BSA10027',selValue));  //msg1 + 'is invalid VVD or has no ETD'
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
				sheet1.SelectCell(selRow,"M_vvd_cd",true);
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
				sheet2.SelectCell(selRow,"M_vvd_cd",true);
			}
		} else {
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
				sheet1.SetCellValue(selRow,"M_bsa_fm_dt",result);
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
				sheet2.SetCellValue(selRow,"M_bsa_fm_dt",result);
			}
		}
	}
	//extract max row by Grouping
	function getMaxRow(sheetObj) {
		var bsa_group="";
		var bsa_seq=0;
		var tmpSeq=0;
		var tmpRow=0;
		var maxRow=0;
		var tmp=0;
		with(sheetObj) {
			if (GetSelectRow()> 0) {
				maxRow=GetSelectRow();
				bsa_group=GetCellValue(GetSelectRow(),"M_bsa_group");
				for (var i=HeaderRows(); i<LastRow(); i++) {
					tmpRow=FindText("M_bsa_group", bsa_group, tmp);
					if (tmpRow == -1) {
						break;
					} else {
						tmpSeq=parseInt(GetCellValue(tmpRow,"M_bsa_seq"));
						if (bsa_seq <= tmpSeq) {
							bsa_seq=tmpSeq;  //max value
							maxRow=tmpRow;  //row including max value
						}
					}
					tmp=tmpRow + 1;
				} //end of for
			}
		} //end of with
		return maxRow;
	}
	//Handling Zoom on the screeen
	function set_Zoom() {
//		if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//			if (zoomFlag1 == "open") {
//				div_zoom_in1.style.display="none";  
//				div_zoom_out1.style.display="inline";
//			} else if (zoomFlag1 == "close") {
//				div_zoom_in1.style.display="inline"; 
//				div_zoom_out1.style.display="none";
//			}
//			div_zoom_in2.style.display="none";
//			div_zoom_out2.style.display="none";
//		} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//			div_zoom_in1.style.display="none";
//			div_zoom_out1.style.display="none";
//			if (zoomFlag2 == "open") {
//				div_zoom_in2.style.display="none";  
//				div_zoom_out2.style.display="inline";
//			} else if (zoomFlag2 == "close") {
//				div_zoom_in2.style.display="inline"; 
//				div_zoom_out2.style.display="none";
//			}		
//		}
		switch (sheet_selno) {
			case JOINT_OPERATING:
				setBtnZoom(zoomFlag1 == "open" ? ZOOM_IN : ZOOM_OUT);
				break;
			case SPACE_CHARTERING:
				setBtnZoom(zoomFlag2 == "open" ? ZOOM_IN : ZOOM_OUT);
				break;
		}
	}
	/**
	* Returning KEY value in ETC-DATA after parsing xml string gotten by GetsearchXml function of IBSheet or GetSaveXml funtion
	* <br><b>Example :</b>
	* <pre>
	*     xmlStr = mySheet.GetSearchXml("list.jsp");
	*     sValue = ComGetEtcData(xmlStr, "UserId");
	*     for example, sValue is "ibs006" in case of handling xmlStr by the script below 
	*     xmlStr ======================================================
	*       &lt;?xml version='1.0' ?&gt;
	*       &lt;SHEET&gt;
	*         &lt;ETC-DATA&gt;
	*              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
	*              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
	*         &lt;/ETC-DATA&gt;
	*       &lt;/SHEET&gt;
	*     xmlStr ======================================================
	* </pre>
	* @param   {string} xmlStr     mandatory item,xml string gotten from IBSheet
	* @param   {string} etcName    mandatory item, key name extracted from xml string
	* @return  string, KEY value setting into ETC-DATA
	* @version 3.4.0.50
	*/
	function GetEtcDataForExceptional0021(xmlStr,etcName){
		if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;
		try {
			var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
			xmlDoc.loadXML(xmlStr);
			var xmlRoot=xmlDoc.documentElement;
			if(xmlRoot == null) return;
			var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
			if(etcDataNode == null) return;
			var etcNodes=etcDataNode.childNodes;
			if(etcDataNode == null) return;
			for(var i=0;i<etcNodes.length;i++){
				if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;
				if(etcNodes[i].attributes(0).text==etcName) {
					if (etcNodes[i].firstChild==null) {
						return "";
					} else {
						return etcNodes[i].firstChild.nodeValue;
					}
				}
			}
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	function ComAddSeparator_Local(obj, sFormat) {
		try {
			//obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	/**
	* refreshing rLane list in case of modifying trade code.
	*/
	function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		//sheetObj.SetWaitImageVisible(0);
		if(obj.GetSelectText()!= ""){
			trd_cd=obj.GetSelectCode();
			param="f_cmd="+SEARCHLIST01;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=rLane";
			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], cobLane, "code", "code");
			cobLane.SetSelectIndex(0);
		}
		//sheetObj.SetWaitImageVisible(1);
	}
	
	function setBtnZoom(type) {		
		if (type == undefined)
			return;
		switch (type) {
			case ZOOM_IN:
				$('#btn_zoom_in').removeClass('btn_down').addClass('btn_up').prop('id', 'btn_zoom_out').prop('name', 'btn_zoom_out').prop('title', ZOOM_OUT);
				break;
			case ZOOM_OUT:
				$('#btn_zoom_out').removeClass('btn_up').addClass('btn_down').prop('id', 'btn_zoom_in').prop('name', 'btn_zoom_in').prop('title', ZOOM_IN);
				break;
		}		
	}
	
	function resizeSheet(){
		for (i=0; i<sheetObjects.length; i++){
			var sheetObj = sheetObjects[i].id;
	        ComResizeSheet(sheetObj);
	    }
	}
	
//	function mySheet_OnMouseMove(button, shift, 1, 1) {
//		var value = "마우스 좌표 = " + 1 + "," + 1;
//		sheet1.SetMouseToolTipText(value);
//	} 

