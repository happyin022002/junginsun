/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_BSA_0030 : business script for ESM_BSA_0030
     */
  
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet_height=21; 
    var first_load0=true;  //adjusting height of sheet1 in case of initial loading - TEU
    var first_load1=true;  //adjusting height of sheet2 in case of initial loading - Slot Price
    var first_load2=true;  //adjusting height of sheet3 in case of initial loading - TEU & Slot Price
    var first_load3=true;  //adjusting height of sheet4 in case of initial loading - Basic Slottage
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	var joint_operation="";
	var joint_operation_op="";			//20150520.ADD
	var sub_charter_out="";
	var sub_charter_out_op="";			//20150520.ADD
	var sub_charter_in="";
	var sub_charter_in_op="";			//20150520.ADD
	var cross_charter_out="";
	var cross_charter_out_op="";		//20150520.ADD
	var cross_charter_in="";
	var cross_charter_in_op="";			//20150520.ADD
	var sub_charter_out_bsa="";
	var sub_charter_in_bsa="";
	var cross_charter_out_bsa="";
	var cross_charter_in_bsa="";
	var final_co_bsa="";
    var cht_out="";
    var co_rto="";
    var cht_rto="";
	/* Event handler processing by button click event */
    document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 */
	function processButtonClick(){
		var sheetObject0=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var sheetObject2=sheetObjects[2];
		var sheetObject3=sheetObjects[3];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
				    if(formObject.rdoPerf[1].checked){ 
					    doActionIBSheet1(sheetObject1,formObject,IBSEARCH); // Slot Price
				    } else if (formObject.rdoPerf[2].checked){
					    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);   // TEU & Slot Price
				    } else if (formObject.rdoPerf[3].checked){
					    doActionIBSheet3(sheetObject3,formObject,IBSEARCH);   // Basic Slottage
				    } else {
					    doActionIBSheet0(sheetObject0,formObject,IBSEARCH);  // TEU
				    }
					break;
				case "btn_save":
//    				    if(formObject.rdoPerf[3].checked){ 
//    					    doActionIBSheet3(sheetObject1,formObject,IBSAVE);
//    				    }else{
//    					    doActionIBSheet0(sheetObject0,formObject,IBSAVE);
//    				    }
//    					break;
				case "btng_creation":
					formObject.flag.value="search";
					doActionIBSheet0(sheetObject0,formObject,IBCREATE);
					break;
				case "btn_skdinquiry0":
				case "btn_skdinquiry1":
				case "btn_skdinquiry2":
				case "btn_skdinquiry3":
                    var vsl_cd="";
                    var classId="COM_ENS_0B1";
                    var param="";
                    if(formObject.rdoPerf[0].checked) {
                        if(sheet0.GetSelectRow()> 1){
							vsl_cd=ComTrim(sheet0.GetCellValue(sheet0.GetSelectRow(), "vsl_cd"))
							+ ComTrim(sheet0.GetCellValue(sheet0.GetSelectRow(), "skd_voy_no"))
							+ ComTrim(sheet0.GetCellValue(sheet0.GetSelectRow(), "skd_dir_cd"));
                        }else{
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                    } else if(formObject.rdoPerf[1].checked) {
                        if(sheet1.GetSelectRow()> 1){
							vsl_cd=ComTrim(sheet1.GetCellValue(sheet1.GetSelectRow(), "vsl_cd"))
							+ ComTrim(sheet1.GetCellValue(sheet1.GetSelectRow(), "skd_voy_no"))
							+ ComTrim(sheet1.GetCellValue(sheet1.GetSelectRow(), "skd_dir_cd"));
                        }else{
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                    } else if(formObject.rdoPerf[2].checked) {
                        if(sheet2.GetSelectRow()> 2){
							vsl_cd=ComTrim(sheet2.GetCellValue(sheet2.GetSelectRow(), "vsl_cd"))
							+ ComTrim(sheet2.GetCellValue(sheet2.GetSelectRow(), "skd_voy_no"))
							+ ComTrim(sheet2.GetCellValue(sheet2.GetSelectRow(), "skd_dir_cd"));
                        }else{
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                    } else {
                        if(sheet3.GetSelectRow()> 1){
							vsl_cd=ComTrim(sheet3.GetCellValue(sheet3.GetSelectRow(), "vsl_cd"))
							+ ComTrim(sheet3.GetCellValue(sheet3.GetSelectRow(), "skd_voy_no"))
							+ ComTrim(sheet3.GetCellValue(sheet3.GetSelectRow(), "skd_dir_cd"));
                        }else{
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                    }
                    param='?vvd_cd='+vsl_cd+'&classId='+classId;
                    ComOpenPopup("/opuscntr/COM_ENS_0B1.do"+param, 620, 450, "", "0,0,1,1,1,1,1,1,1,1", false);
					break;
                case "btng_reset0":
                    formObject.reset_flag.value="BSA";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;
                case "btng_reset1":
                    formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;
                case "btng_reset2":
//                        formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break; 
                case "btng_reset3":
//                        formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;    
				case "btn_downexcel":
					if(document.all.RadioLayer0.style.display != "none"){
						doActionIBSheet0(sheet0,formObject,IBDOWNEXCEL);
					} else if(document.all.RadioLayer1.style.display != "none"){
						doActionIBSheet0(sheet1,formObject,IBDOWNEXCEL);
					} else if(document.all.RadioLayer2.style.display != "none"){
						doActionIBSheet0(sheet2,formObject,IBDOWNEXCEL);
					} else {
						doActionIBSheet0(sheet3,formObject,IBDOWNEXCEL);
					}
					break;
    			case "bu_zoom_in":
    				sheet_height=getSheetHeightCnt(sheet0,"MAX",1);
    				
    				resizeSheet();
    				
//  		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("div_zoom_in").style.display="none";
    	            document.getElementById("div_zoom_out").style.display="inline";
//    				div_zoom_in.style.display="none";
//    				div_zoom_out.style.display="inline";
    				break;
    			case "bu_zoom_out":
    				sheet_height=getSheetHeightCnt(sheet0,"MIN",0);
    				
//    				2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
    				if(formObject.rdoPerf[0].checked){ 
    					var rowcount = sheet0.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet0.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}			
						if(totalrowheight+150 > 430){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet0.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
				    } else if (formObject.rdoPerf[1].checked){
				    	var rowcount = sheet1.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 430){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
				    } else if (formObject.rdoPerf[2].checked){
				    	var rowcount = sheet2.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet2.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 430){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
				    } else {
				    	var rowcount = sheet3.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet3.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 430){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet3.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
				    }
    				
//		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("div_zoom_in").style.display="inline";
    	            document.getElementById("div_zoom_out").style.display="none";
//    				div_zoom_in.style.display="inline";
//    				div_zoom_out.style.display="none";
    				//parent.syncHeight();
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
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
 	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage() {
		loadCombo();
		
//		2014.11.20 김용습 - Enter키 조회 메소드(initControl()) 작성 및 호출
//		initControl();		
		
//      2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
        document.getElementById("RadioLayer1").style.display="none";
        document.getElementById("RadioLayer2").style.display="none";
        document.getElementById("RadioLayer3").style.display="none";        
//		RadioLayer1.style.display="none";       // Basic Slottage
//		RadioLayer2.style.display="none";       // Slot Price
//		RadioLayer3.style.display="none";       // TEU & Slot Price
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode=true;
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode=false;
		resizeSheet();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var formObj=document.form;
		var cnt=0;
		var saveNM="";
		var crr_cnt="";
		var colNo=0;                   
        var subColNo=0;                
	    var num=0;
	    var comHeaderTitle="STS|BSA\nFlag|bsa_flg|YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane" 	+ "|Type|type_flg|Vessel|Voy.|Dir.|OPR|Carrier|vop_flg"  	+ "|V.Capa.|vsl_capa|Loadable\nCapacity|Company\nFinal|CHT\nout|Company\n(%)"	+ "|CHT\n(%)|Company\nInclude Sub" ;
	    var comHeaderTitle0="";
	    var comHeaderTitle1="";
		joint_operation="";
		sub_charter_out="";
		sub_charter_in="";
		cross_charter_out="";
		cross_charter_in="";
		//20150520.ADD
		joint_operation_op="";
		sub_charter_out_op="";
		sub_charter_in_op="";
		cross_charter_out_op="";
		cross_charter_in_op="";
		
		sub_charter_out_bsa="";
		sub_charter_in_bsa="";
		cross_charter_out_bsa="";
		cross_charter_in_bsa="";
		final_co_bsa="";
	    cht_out="";
	    co_rto="";
	    cht_rto="";
        saveNM=formObj.saveNM.value.split("|");
        crr_cnt=formObj.crr_cnt.value.split("|");
	    aryCrr=formObj.crr_cd.value.split("|");
	    if(formObj.saveNM.value != "") subColNo=saveNM.length;
        if(formObj.crr_cnt.value != ""){
            var p=0;
            num=0;            
            for(j=0; j<crr_cnt.length; j++){
                if(saveNM[num].substring(3,6) == "000") {                	
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
                        p++;
                        //20150513.ADD,MOD
                        if (sheetNo==2){
                            comHeaderTitle0 += "|Initial Slots|Initial Slots|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Expense)|Initial Slots(Expense)|Initial Slots(Expense)";
                        }else if (sheetNo==1 || sheetNo==3){
                            comHeaderTitle0 += "|Initial Slots|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Expense)|Initial Slots(Expense)";                            
                        }else{
                        	comHeaderTitle0 += "|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Expense)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "001") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        joint_operation += "|" + saveNM[p] + "|";								//20150520.MOD : p++ -> p로..
            	        if(sheetNo==3)	joint_operation_op += "|" + "OP_"+saveNM[p] + "|";		//20150520.ADD
            	        p++;																	//20150520.ADD
            	        if(k != parseInt(crr_cnt[j])-1) joint_operation += "+";            	        
            	        if(sheetNo==3){
            	        	if(k != parseInt(crr_cnt[j])-1) joint_operation_op += "+";			//20150520.ADD
            	        }
            	        //20150513.ADD,MOD
            	        if (sheetNo==2){
                	        comHeaderTitle0 += "|Initial Slots|Initial Slots|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Income)|Initial Slots(Income)|Initial Slots(Income)";
            	        }else if (sheetNo==1 || sheetNo==3){
                	        comHeaderTitle0 += "|Initial Slots|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Income)|Initial Slots(Income)";
            	        }else{
                        	comHeaderTitle0 += "|Initial Slots"; 
                            comHeaderTitle1 += "|Initial Slots(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "002") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        sub_charter_out     += "|" + saveNM[p] + "|";
            	        sub_charter_out_bsa += "|" + saveNM[p] + "|";
            	        if(sheetNo==3)	sub_charter_out_op  += "|" + "OP_"+saveNM[p] + "|";		//20150520.ADD
            	        p++;
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_out     += "+";
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_out_bsa += "-";
            	        if(sheetNo==3){
            	        	if(k != parseInt(crr_cnt[j])-1) sub_charter_out_op += "+";			//20150520.ADD
            	        }
            	        //20150513.ADD,MOD
            	        if (sheetNo==2){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Leased(Income)|Basic Leased(Income)|Basic Leased(Income)";
            	        }else if (sheetNo==1 || sheetNo==3){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Leased(Income)|Basic Leased(Income)";            	        	
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Leased(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "003") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
                    	sub_charter_in     += "|" + saveNM[p] + "|";
            	        sub_charter_in_bsa += "|" + saveNM[p] + "|";
            	        if(sheetNo==3)	sub_charter_in_op  += "|" + "OP_"+saveNM[p] + "|";		//20150520.ADD
            	        p++;
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_in     += "+";
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_in_bsa += "+";
            	        if(sheetNo==3){
            	        	if(k != parseInt(crr_cnt[j])-1) sub_charter_in_op += "+";			//20150520.ADD
            	        }
            	        //20150513.ADD,MOD
            	        if (sheetNo==2){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Chartered(Expense)|Basic Chartered(Expense)|Basic Chartered(Expense)";
            	        }else if (sheetNo==1 || sheetNo==3){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Chartered(Expense)|Basic Chartered(Expense)";            	        	
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Chartered(Expense)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "004") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        cross_charter_out     += "|" + saveNM[p] + "|";
            	        cross_charter_out_bsa += "|" + saveNM[p] + "|";
            	        if(sheetNo==3)	cross_charter_out_op  += "|" + "OP_"+saveNM[p] + "|";	//20150520.ADD
            	        p++;
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_out     += "+";
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_out_bsa += "-";
            	        if(sheetNo==3){
            	        	if(k != parseInt(crr_cnt[j])-1) cross_charter_out_op += "+";		//20150520.ADD
            	        }
            	        //20150513.ADD,MOD
            	        if (sheetNo==2){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Leased(Income)|Additional Leased(Income)|Additional Leased(Income)";
            	        }else if (sheetNo==1 || sheetNo==3){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Leased(Income)|Additional Leased(Income)";            	        	
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Leased(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "005") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        cross_charter_in     += "|" + saveNM[p] + "|";
            	        cross_charter_in_bsa += "|" + saveNM[p] + "|";
            	        if(sheetNo==3)	cross_charter_in_op  += "|" + "OP_"+saveNM[p] + "|";	//20150520.ADD
            	        p++;
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_in     += "+";
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_in_bsa += "+";
            	        if(sheetNo==3){
            	        	if(k != parseInt(crr_cnt[j])-1) cross_charter_in_op += "+";			//20150520.ADD
            	        }
            	        //20150513.ADD,MOD
            	        if (sheetNo==2){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Chartered(Expense)|Additional Chartered(Expense)|Additional Chartered(Expense)";
            	        }else if (sheetNo==1 || sheetNo==3){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Chartered(Expense)|Additional Chartered(Expense)";            	        	
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Chartered(Expense)";
                        }
                    }
                }
                num=ComParseInt(num) + ComParseInt(crr_cnt[j]);  
            }
        }
		switch(sheetNo) {
			case 0:      //sheet1 init
			    colNo=32 + subColNo;
				with (sheetObj) {
		               first_load0=false;
		               var HeadTitle0=comHeaderTitle+comHeaderTitle0;
		               var HeadTitle1=comHeaderTitle+comHeaderTitle1;
		               var HeadTitle2=comHeaderTitle;
		               SetMergeCell(0,24+num,1,2)
		               HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
		               HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
		               
//		               2014.11.07 김용습 - 헤더에 동일 carrier가 연속으로 나와도 merge되지 않도록 조치
		               var arrayHeadsheet1=formObj.crr_cd.value.split("|");
						
		               var sheet1crrheader = "";
						
						for(j=0; j < arrayHeadsheet1.length; j++) {
								if(j%5 == 0 && j != arrayHeadsheet1.length - 1){
									arrayHeadsheet1[j] = arrayHeadsheet1[j] + "|" ;
								}else if(j%5 == 1 && j != arrayHeadsheet1.length - 1){ 
									arrayHeadsheet1[j] = " " + arrayHeadsheet1[j] + " |" ;
								}else if(j%5 == 2 && j != arrayHeadsheet1.length - 1){ 
									arrayHeadsheet1[j] = " " + " " + arrayHeadsheet1[j] + " " + " |" ;
								}else if(j%5 == 3 && j != arrayHeadsheet1.length - 1){ 
									arrayHeadsheet1[j] = " " + " " + " " + arrayHeadsheet1[j] + " " + " " + " |" ;
								}else if(j%5 == 4 && j != arrayHeadsheet1.length - 1){ 
									arrayHeadsheet1[j] = " " + " " + " " + " " + arrayHeadsheet1[j] + " " + " " + " " + " |" ;
								}else if(j == arrayHeadsheet1.length - 1){ // 마지막 번째일때
									arrayHeadsheet1[j] = " "+ " "+ " "+ " "+ " " + arrayHeadsheet1[j] + " "+ " "+ " "+ " " + " " ;
									sheet1crrheader = sheet1crrheader + arrayHeadsheet1[j];
									break;
								}
								
								sheet1crrheader = sheet1crrheader + arrayHeadsheet1[j];
							
						}      
		               
		               if(sheet1crrheader != "")
		               HeadTitle2 += "|" + sheet1crrheader;
		               HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:17 } );
		               var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1};
		               var headers = [ 
//		                               { Text:HeadTitle0, Align:"Center"},   
		                               { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               KeyField:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type_flg",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_flg",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",      KeyField:0,   CalcLogic:"final_co_bsa_m(|type_flg|, |co_bsa_bfr_sub_capa|-"+sub_charter_out_bsa+"+"+sub_charter_in_bsa+"-"+ cross_charter_out_bsa+"+"+ cross_charter_in_bsa+" , |final_co_bsa2|)", Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",          KeyField:0,   CalcLogic:"cht_out_m(|type_flg|, |vop_flg|, "+joint_operation+" , "+sub_charter_out+", "+cross_charter_out+")" ,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",           KeyField:0, CalcLogic:"co_rto_m(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|)" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"chtr_bas_rto",         KeyField:0, CalcLogic:"cht_rto_m(|bsa_flg|, co_rto_m(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|))" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_bfr_sub_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               if(formObj.saveNM.value != ""){
			               for(j=0; j<saveNM.length; j++){
				               if(saveNM[j].substring(3,6) == "000"){
				            	   cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
				               }else{
				            	   cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
				               }
			               }
			           }
					   cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rev_port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rev_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"nlst_port_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ioc_rule_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"final_co_bsa2",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"temp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });				     
		               InitColumns(cols);
		               SetEditable(1);
		               SetHeaderRowHeight(10);
		               SetWaitImageVisible(0);
//		               SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
		               SetSheetHeight(430);
		               var cnt1=24;
		               var cnt2=23;
		               for(j=0; j<crr_cnt.length; j++){
	            	   cnt2=cnt2 + parseInt(crr_cnt[j]);
		               cnt1=cnt1 + parseInt(crr_cnt[j]);
	                  }
		               
//						2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
						for(z=0; z<=cols.length; z++){
							
							//초기 로딩 속도 향상을 위해 첫번째 줄 헤더의 툴팁을 주석처리합니다
//							if(GetCellValue(0,z) == "Basic Slots"){
//								SetToolTipText(0, z, "Basic Slots");
//							}else if(GetCellValue(0,z) == "Chartered Slots"){
//								SetToolTipText(0, z, "Chartered Slots");
//							}
							
							if(GetCellValue(0,z) == "Initial Slots(Expense)"){
								SetCellBackColor(0, z, "#99004C");
								SetToolTipText(0, z, "Initial Slots(Expense)");
							}else if(GetCellValue(0,z) == "Initial Slots(Income)"){
								SetCellBackColor(0, z, "#22741C");
								SetToolTipText(0, z, "Initial Slots(Income)");
							}else if(GetCellValue(0,z) == "Basic Leased(Income)"){
								SetCellBackColor(0, z, "#050099");
								SetToolTipText(0, z, "Basic Leased(Income)");
							}else if(GetCellValue(0,z) == "Basic Chartered(Expense)"){
								SetCellBackColor(0, z, "#8041D9");
								SetToolTipText(0, z, "Basic Chartered(Expense)");
							}else if(GetCellValue(0,z) == "Additional Leased(Income)"){
								SetCellBackColor(0, z, "#670000");
								SetToolTipText(0, z, "Additional Leased(Income)");
							}else if(GetCellValue(0,z) == "Additional Chartered(Expense)"){
								SetCellBackColor(0, z, "#8C8C8C");
								SetToolTipText(0, z, "Additional Chartered(Expense)");
							}		
						}
						
						SetEditArrowBehavior(3); 
				}
				break;
			case 1:      //Slot Price sheet init
			    colNo=32 + subColNo*2;										//20150513.MOD
				with (sheetObj) {
                    first_load2=false;
                    var HeadTitle0=comHeaderTitle+comHeaderTitle0;
                    var HeadTitle1=comHeaderTitle+comHeaderTitle1;
                    var HeadTitle2=comHeaderTitle;
                    var HeadTitle3=comHeaderTitle;							//20150513.MOD
//                    SetMergeCell(0,24+num,1,2)							//20150513.MOD
                    HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                    HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                    
//		               2014.11.07 김용습 - 헤더에 동일 carrier가 연속으로 나와도 merge되지 않도록 조치
		               var arrayHeadsheet2=formObj.crr_cd.value.split("|");
						
		               var sheet2crrheader = "";
						
						for(j=0; j < arrayHeadsheet2.length; j++) {
								if(j%4 == 0 && j != arrayHeadsheet2.length - 1){
									arrayHeadsheet2[j] = arrayHeadsheet2[j] + "|" ;
								}else if(j%4 == 1 && j != arrayHeadsheet2.length - 1){ 
									arrayHeadsheet2[j] = " " + arrayHeadsheet2[j] + " |" ;
								}else if(j%4 == 2 && j != arrayHeadsheet2.length - 1){ 
									arrayHeadsheet2[j] = " " + " " + arrayHeadsheet2[j] + " " + " |" ;
								}else if(j%4 == 3 && j != arrayHeadsheet2.length - 1){ 
									arrayHeadsheet2[j] = " " + " " + " " + arrayHeadsheet2[j] + " " + " " + " |" ;
								}else if(j == arrayHeadsheet2.length - 1){ // 마지막 번째일때
									arrayHeadsheet2[j] = " "+ " "+ " "+ " " + arrayHeadsheet2[j] + " "+ " "+ " "+ " " ;
									sheet2crrheader = sheet2crrheader + arrayHeadsheet2[j];
									break;
								}
								
								sheet2crrheader = sheet2crrheader + arrayHeadsheet2[j];
							
						}							
					
					//20150513.MOD, 20150611.MOD : 일련번호로 바꿈
                    if(sheet2crrheader != "") {
//                    	HeadTitle2 += "|" + sheet2crrheader;
//                    	HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
	                    for(var k=0; k < aryCrr.length; k++) {
	                    	HeadTitle2 += "|" + aryCrr[k] + "|" + aryCrr[k];
	                    	HeadTitle3 += "| Slot Price "+k+"|  OP Price "+k;
//							if(k%4 == 0){
//						  		HeadTitle3 += "|Slot Price|OP Price";
//							}else if(k%4 == 1){
//								HeadTitle3 += "|Slot Price|OP Price";
//							}else if(k%4 == 2){
//								HeadTitle3 += "|Slot Price|OP Price";
//							}else if(k%4 == 3){
//								HeadTitle3 += "|Slot Price|OP Price";
//						  	}	                    	
	                    }
	                    HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
	                    HeadTitle3 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                    }
                    //20150513.MOD
                    SetMergeCell(0,24+(num*2),1,2)
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:17 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                    var headers = [ 
//                                    { Text:HeadTitle0, Align:"Center"}, 
                                    { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"},  { Text:HeadTitle3, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               KeyField:0 },
					            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type_flg",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_flg",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",      KeyField:0,   CalcLogic:"", Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",          KeyField:0,   CalcLogic:"", Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",           KeyField:0,   CalcLogic:"" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"chtr_bas_rto",         KeyField:0,   CalcLogic:"" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_bfr_sub_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  if(formObj.saveNM.value != ""){
	                    for(j=0; j<saveNM.length; j++){
	                    if(saveNM[j].substring(3,6) == "000"){
	                    	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
	                    	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
	                    }else{
	                    	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
	                    	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
	                    }
	                    }}
	                    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rev_port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rev_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"nlst_port_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ioc_rule_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"final_co_bsa2",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"temp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                     
                  	InitColumns(cols);
	                SetWaitImageVisible(0);
//	                SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
	                SetSheetHeight(430);
                    SetHeaderRowHeight(10);
                    var cnt1=24;
                    var cnt2=23;
                    for(j=0; j<crr_cnt.length; j++){
	                    cnt2=cnt2 + parseInt(crr_cnt[j]);
	                    cnt1=cnt1 + parseInt(crr_cnt[j]);		                   
                    }
                    
//					2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
					for(z=0; z<=cols.length; z++){
						
						//초기 로딩 속도 향상을 위해 첫번째 줄 헤더의 툴팁을 주석처리합니다
//						if(GetCellValue(0,z) == "Basic Slots"){
//							SetToolTipText(0, z, "Basic Slots");
//						}else if(GetCellValue(0,z) == "Chartered Slots"){
//							SetToolTipText(0, z, "Chartered Slots");
//						}
						
						if(GetCellValue(0,z) == "Initial Slots(Expense)"){
							SetCellBackColor(0, z, "#99004C");
							SetToolTipText(0, z, "Initial Slots(Expense)");
						}else if(GetCellValue(0,z) == "Initial Slots(Income)"){
							SetCellBackColor(0, z, "#22741C");
							SetToolTipText(0, z, "Initial Slots(Income)");
						}else if(GetCellValue(0,z) == "Basic Leased(Income)"){
							SetCellBackColor(0, z, "#050099");
							SetToolTipText(0, z, "Basic Leased(Income)");
						}else if(GetCellValue(0,z) == "Basic Chartered(Expense)"){
							SetCellBackColor(0, z, "#8041D9");
							SetToolTipText(0, z, "Basic Chartered(Expense)");
						}else if(GetCellValue(0,z) == "Additional Leased(Income)"){
							SetCellBackColor(0, z, "#670000");
							SetToolTipText(0, z, "Additional Leased(Income)");
						}else if(GetCellValue(0,z) == "Additional Chartered(Expense)"){
							SetCellBackColor(0, z, "#8C8C8C");
							SetToolTipText(0, z, "Additional Chartered(Expense)");
						}		
					}
					SetEditArrowBehavior(3); 
				}
				break;				
			case 2:      //TEU & Slot Price sheet init
			    colNo=32 + subColNo*3;					//20150513.MOD
				with (sheetObj) {
//    			                                        //no support[check again]CLT 	   style.height=GetSheetHeight(sheet_height) ;
	               first_load3=false;
	               var HeadTitle0=comHeaderTitle+comHeaderTitle0;
	               var HeadTitle1=comHeaderTitle+comHeaderTitle1;
	               var HeadTitle2=comHeaderTitle;
	               var HeadTitle3=comHeaderTitle;
	               HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
	               HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                                        
//		           2014.11.07 김용습 - 헤더에 동일 carrier가 연속으로 나와도 merge되지 않도록 조치
	               var arrayHeadsheet3=formObj.crr_cd.value.split("|");
					
	               var sheet3crrheader = "";
					
					for(j=0; j < arrayHeadsheet3.length; j++) {
						if(j%4 == 0 && j != arrayHeadsheet3.length - 1){
							arrayHeadsheet3[j] = arrayHeadsheet3[j] + "|" ;
						}else if(j%4 == 1 && j != arrayHeadsheet3.length - 1){ 
							arrayHeadsheet3[j] = " " + arrayHeadsheet3[j] + " |" ;
						}else if(j%4 == 2 && j != arrayHeadsheet3.length - 1){ 
							arrayHeadsheet3[j] = " " + " " + arrayHeadsheet3[j] + " " + " |" ;
						}else if(j%4 == 3 && j != arrayHeadsheet3.length - 1){ 
							arrayHeadsheet3[j] = " " + " " + " " + arrayHeadsheet3[j] + " " + " " + " |" ;
						}else if(j == arrayHeadsheet3.length - 1){ // 마지막 번째일때
							arrayHeadsheet3[j] = " "+ " "+ " "+ " " + arrayHeadsheet3[j] + " "+ " "+ " "+ " " ;
							sheet3crrheader = sheet3crrheader + arrayHeadsheet3[j];
							break;
						}
						sheet3crrheader = sheet3crrheader + arrayHeadsheet3[j];
					}
                 
                    if(sheet3crrheader != "")
                    for(var k=0; k < aryCrr.length; k++) {
                    	HeadTitle2 += "|" + aryCrr[k] + "|" + aryCrr[k] + "|" + aryCrr[k];				//20150513.MOD
                    }
                    HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                    if(sheet3crrheader != "")
//                    for(var k=0; k < aryCrr.length; k++) {
//                    		HeadTitle3 += "|TEU|Slot Price";                  	
//                    }    
                    for(var k=0; k < aryCrr.length; k++) {
                    	//20150513.MOD, 20150611.MOD : 일련번호로 바꿈
//                    	2014.11.10 김용습 - Carriers with BSA only 체크시 merge되어서는 안되는 부분이 merge되는 현상을 막기 위해 수정
                    	HeadTitle3 += "| "+" "+" "+ " "+ " "+ " "+"TEU "+" "+" "+ " "+ " "+ " "+k+"| Slot Price "+k+"|  OP Price "+k;
//                    	if(k%4 == 0){
//                    		HeadTitle3 += "|TEU|Slot Price|OP Price";
//                    	}else if(k%4 == 1){
//                    		HeadTitle3 += "|TEU|Slot Price|OP Price";
//                    	}else if(k%4 == 2){
//                    		HeadTitle3 += "|TEU|Slot Price|OP Price";
//                    	}else if(k%4 == 3){
//                    		HeadTitle3 += "|TEU|Slot Price|OP Price";
//                    	}                  	
                    }                    
                    
                    HeadTitle3 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_co_bsa2";
                    SetMergeCell(0,24+(num*3),1,2)
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:17 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                    var headers = [ 
//                                    { Text:HeadTitle0, Align:"Center"},
                                    { Text:HeadTitle1, Align:"Center"},    { Text:HeadTitle2, Align:"Center"},  { Text:HeadTitle3, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               KeyField:0 },
								   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type_flg",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_flg",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",      KeyField:0,   CalcLogic:"final_co_bsa_m(|type_flg|, |co_bsa_bfr_sub_capa|-"+sub_charter_out_bsa+"+"+sub_charter_in_bsa+"-"+ cross_charter_out_bsa+"+"+ cross_charter_in_bsa+" , |final_co_bsa2|)", Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",          KeyField:0,   CalcLogic:"cht_out_m(|type_flg|, |vop_flg|, "+joint_operation+", "+sub_charter_out+", "+cross_charter_out+")", Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",           KeyField:0,   CalcLogic:"co_rto_m(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|)" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"chtr_bas_rto",         KeyField:0,   CalcLogic:"cht_rto_m(|bsa_flg|, co_rto_m(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|))" ,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
								   {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_bfr_sub_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  if(formObj.saveNM.value != ""){
	                    for(j=0; j<saveNM.length; j++){
	                    	//20150513.ADD
		                    if(saveNM[j].substring(3,6) == "000"){
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ApproximateType:1});
		                    }else{
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
		                    cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:saveNM[j],              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ApproximateType:1});
		                    }}}
		                    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rev_port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rev_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"nlst_port_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ioc_rule_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"final_co_bsa2",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"temp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                    
                  InitColumns(cols);
                  SetWaitImageVisible(0);
//                  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
                  SetSheetHeight(430);
                  SetHeaderRowHeight(10);
                  var cnt1=24;
                  var cnt2=23;
                  for(j=0; j<crr_cnt.length; j++){
                  cnt2=cnt2 + parseInt(crr_cnt[j])*3;
                  cnt1=cnt1 + parseInt(crr_cnt[j])*3;                          
                  }
                  
//					2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
					for(z=0; z<=cols.length; z++){
						
						//초기 로딩 속도 향상을 위해 첫번째 줄 헤더의 툴팁을 주석처리합니다
//						if(GetCellValue(0,z) == "Basic Slots"){
//							SetToolTipText(0, z, "Basic Slots");
//						}else if(GetCellValue(0,z) == "Chartered Slots"){
//							SetToolTipText(0, z, "Chartered Slots");
//						}
						
						if(GetCellValue(0,z) == "Initial Slots(Expense)"){
							SetCellBackColor(0, z, "#99004C");
							SetToolTipText(0, z, "Initial Slots(Expense)");
						}else if(GetCellValue(0,z) == "Initial Slots(Income)"){
							SetCellBackColor(0, z, "#22741C");
							SetToolTipText(0, z, "Initial Slots(Income)");
						}else if(GetCellValue(0,z) == "Basic Leased(Income)"){
							SetCellBackColor(0, z, "#050099");
							SetToolTipText(0, z, "Basic Leased(Income)");
						}else if(GetCellValue(0,z) == "Basic Chartered(Expense)"){
							SetCellBackColor(0, z, "#8041D9");
							SetToolTipText(0, z, "Basic Chartered(Expense)");
						}else if(GetCellValue(0,z) == "Additional Leased(Income)"){
							SetCellBackColor(0, z, "#670000");
							SetToolTipText(0, z, "Additional Leased(Income)");
						}else if(GetCellValue(0,z) == "Additional Chartered(Expense)"){
							SetCellBackColor(0, z, "#8C8C8C");
							SetToolTipText(0, z, "Additional Chartered(Expense)");
						}		
					}
					SetEditArrowBehavior(3); 
				}
				break;		
			case 3:      //Basic Slottage sheet init
				with (sheetObj) {
//    			                                            //no support[check again]CLT 	    style.height=GetSheetHeight(sheet_height) ;
                first_load1=false;
                colNo=32 + subColNo*2;						//20150513.MOD
                num=0;
                var HeadTitle3=comHeaderTitle;				//20150513.ADD
                
                var HeadTitle0="STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nCompany BSA|CHT out|Company\n(%)|CHT\n(%)"
                			  +"|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary|Summary"		//20150513.MOD
                if(formObj.crr_cnt.value != ""){
	                for(j=0; j<crr_cnt.length; j++){
	                	//20150513.MOD
		                if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail|Detail";
		                num=parseInt(num) + parseInt(crr_cnt[j]);
	                }
                }
                HeadTitle0 += "|ioc_cd|bsa_op_cd";

                num=0;	
                //20150513.MOD
                var HeadTitle1="STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nCompany BSA|CHT out|Company\n(%)|CHT\n(%)"
                + "|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)"
                + "|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)|Chartered out(Income)";
                
                if(formObj.crr_cnt.value != ""){
	                for(j=0; j<crr_cnt.length; j++){
	                	//20150513.MOD
		                if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Initial Slots(Expense)|Initial Slots(Expense)";
		                if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Initial Slots(Income)|Initial Slots(Income)";
		                if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Basic Leased(Income)|Basic Leased(Income)";
		                if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Basic Chartered(Expense)|Basic Chartered(Expense)";
		                if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Additional Leased(Income)|Additional Leased(Income)";
		                if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle1 += "|Additional Chartered(Expense)|Additional Chartered(Expense)";
		                num=parseInt(num) + parseInt(crr_cnt[j]);
	                }
                }
                HeadTitle1 += "|ioc_cd|bsa_op_cd";
                //20150513.MOD
                var HeadTitle2="STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nCompany BSA|CHT out|Company\n(%)|CHT\n(%)"
                + "|Initial Slots|Initial Slots|Basic Chartered|Basic Chartered|Additional Chartered|Additional Chartered|Total|Total"
                + "|Initial Slots|Initial Slots|Basic Leased|Basic Leased|Additional Leased|Additional Leased|Total|Total"
                
                //20150513.ADD, 20150611.MOD : 일련번호로..
                var HeadTitle3="STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nCompany BSA|CHT out|Company\n(%)|CHT\n(%)"
               	+ "|    Slot Price    1|     OP Price     1|    Slot Price    2|     OP Price     2|    Slot Price    3|     OP Price     3|    Slot Price    4|     OP Price     5"
                + "|    Slot Price    1|     OP Price     1|    Slot Price    2|     OP Price     2|    Slot Price    3|     OP Price     3|    Slot Price    4|     OP Price     5"                
                
//	               2014.11.07 김용습 - 헤더에 동일 carrier가 연속으로 나와도 merge되지 않도록 조치
	               var arrayHeadsheet4=formObj.crr_cd.value.split("|");
					
	               var sheet4crrheader = "";
					
					for(j=0; j < arrayHeadsheet4.length; j++) {
							if(j%4 == 0 && j != arrayHeadsheet4.length - 1){
								arrayHeadsheet4[j] = arrayHeadsheet4[j] + "|" ;
							}else if(j%4 == 1 && j != arrayHeadsheet4.length - 1){ 
								arrayHeadsheet4[j] = " " + arrayHeadsheet4[j] + " |" ;
							}else if(j%4 == 2 && j != arrayHeadsheet4.length - 1){ 
								arrayHeadsheet4[j] = " " + " " + arrayHeadsheet4[j] + " " + " |" ;
							}else if(j%4 == 3 && j != arrayHeadsheet4.length - 1){ 
								arrayHeadsheet4[j] = " " + " " + " " + arrayHeadsheet4[j] + " " + " " + " |" ;
							}else if(j == arrayHeadsheet4.length - 1){ // 마지막 번째일때
								arrayHeadsheet4[j] = " "+ " "+ " "+ " " + arrayHeadsheet4[j] + " "+ " "+ " "+ " " ;
								sheet4crrheader = sheet4crrheader + arrayHeadsheet4[j];
								break;
							}
							
							sheet4crrheader = sheet4crrheader + arrayHeadsheet4[j];
						
					}					
				
				//20150513.ADD, 20150611.MOD : 일련번호로..
                if(sheet4crrheader != "") {
//                	HeadTitle2 += "|" + sheet4crrheader;
                    for(var k=0; k < aryCrr.length; k++) {
                    	HeadTitle2 += "|" + aryCrr[k] + "|" + aryCrr[k];
                    	HeadTitle3 += "| Slot Price "+k+"|  OP Price "+k;
//                    	if(k%4 == 0){
//                    		HeadTitle3 += "|Slot Price|OP Price";
//                    	}else if(k%4 == 1){
//                    		HeadTitle3 += "|Slot Price|OP Price";
//                    	}else if(k%4 == 2){
//                    		HeadTitle3 += "|Slot Price|OP Price";
//                    	}else if(k%4 == 3){
//                    		HeadTitle3 += "|Slot Price|OP Price";
//                    	}                     	
                    }
                    HeadTitle2 += "|ioc_cd|bsa_op_cd";
                    HeadTitle3 += "|ioc_cd|bsa_op_cd";
                }	
                
                var expn_tot="|expn_bzc_chtr_amt|+|expn_sub_chtr_amt|+|expn_crs_chtr_amt|";
                var expn_op_tot="|expn_bzc_chtr_op_amt|+|expn_sub_chtr_op_amt|+|expn_crs_chtr_op_amt|";			//20150513.ADD
                var incm_tot="|incm_bzc_chtr_amt|+|incm_sub_chtr_amt|+|incm_crs_chtr_amt|";
                var incm_op_tot="|incm_bzc_chtr_op_amt|+|incm_sub_chtr_op_amt|+|incm_crs_chtr_op_amt|";			//20150513.ADD
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:17 } );
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} , { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"}];		//20150513.ADD
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",         KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vop_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"crr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vop_flg",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"chtr_bsa_rto",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					//20150513.ADD, 20150611.MOD
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_bzc_chtr_amt",  	KeyField:0,   CalcLogic:"",   					Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_bzc_chtr_op_amt",KeyField:0,   CalcLogic:"",   					Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_sub_chtr_amt",   KeyField:0,   CalcLogic:sub_charter_in,			Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_sub_chtr_op_amt",KeyField:0,   CalcLogic:sub_charter_in_op,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_crs_chtr_amt",   KeyField:0,   CalcLogic:cross_charter_in,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_crs_chtr_op_amt",KeyField:0,   CalcLogic:cross_charter_in_op,	Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_tot",           	KeyField:0,   CalcLogic:expn_tot,				Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_op_tot",         KeyField:0,   CalcLogic:expn_op_tot,			Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_bzc_chtr_amt",  	KeyField:0,   CalcLogic:joint_operation,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_bzc_chtr_op_amt",KeyField:0,   CalcLogic:joint_operation_op,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_sub_chtr_amt",  	KeyField:0,   CalcLogic:sub_charter_out,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_sub_chtr_op_amt",KeyField:0,   CalcLogic:sub_charter_out_op,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_crs_chtr_amt",  	KeyField:0,   CalcLogic:cross_charter_out,		Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_crs_chtr_op_amt",KeyField:0,   CalcLogic:cross_charter_out_op,	Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_tot",           	KeyField:0,   CalcLogic:incm_tot,				Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incm_op_tot",         KeyField:0,   CalcLogic:incm_op_tot,			Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              if(formObj.saveNM.value != ""){
                for(j=0; j<saveNM.length; j++){
                	//20150513.ADD, 20150520.MOD
	                if(saveNM[j].substring(3,6) == "000"){
	                	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:saveNM[j],            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"OP_"+saveNM[j],      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                }else{
	                	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:saveNM[j],            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"OP_"+saveNM[j],      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                }
                }}
	                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	               
              SetHeaderRowHeight(10);
              InitColumns(cols);
              SetWaitImageVisible(0);
//              SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
              SetSheetHeight(430);
              var cnt1=29;
              var cnt2=28;
              //20150513.MOD
              for(j=0; j<crr_cnt.length; j++){
            	  cnt2=cnt2 + parseInt(crr_cnt[j])*2;
            	  cnt1=cnt1 + parseInt(crr_cnt[j])*2;
              }
              
//				2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
				for(z=0; z<=cols.length; z++){
					
					if(GetCellValue(1,z) == "Initial Slots(Expense)"){
						SetCellBackColor(1, z, "#99004C");
						SetToolTipText(1, z, "Initial Slots(Expense)");
					}else if(GetCellValue(1,z) == "Initial Slots(Income)"){
						SetCellBackColor(1, z, "#22741C");
						SetToolTipText(1, z, "Initial Slots(Income)");
					}else if(GetCellValue(1,z) == "Basic Leased(Income)"){ 
						SetCellBackColor(1, z, "#050099");
						SetToolTipText(1, z, "Basic Leased(Income)"); 
					}else if(GetCellValue(1,z) == "Basic Chartered(Expense)"){
						SetCellBackColor(1, z, "#8041D9");
						SetToolTipText(1, z, "Basic Chartered(Expense)");
					}else if(GetCellValue(1,z) == "Additional Leased(Income)"){
						SetCellBackColor(1, z, "#670000");
						SetToolTipText(1, z, "Additional Leased(Income)");
					}else if(GetCellValue(1,z) == "Additional Chartered(Expense)"){
						SetCellBackColor(1, z, "#8C8C8C");
						SetToolTipText(1, z, "Additional Chartered(Expense)");
					}		
				}
				SetEditArrowBehavior(3); 
			}
			break;
		}
	}
	/**
	 * Handling the process realated with Sheet
	 */
	function doActionIBSheet0(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH:     
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value=fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value=fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value=fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value=fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value=SEARCHLIST;
				var sXml=sheetObj.GetSearchData("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value=GetEtcDataForExceptional(sXml,"crr_cnt");
				formObj.crr_cd.value=GetEtcDataForExceptional(sXml,"crr_cd");
				formObj.saveNM.value=GetEtcDataForExceptional(sXml,"saveNM");
//				sheet0.Reset();
				sheetObjects[0] = sheet0.Reset();					//SJH.20150512.공통변경에 따른 수정
                ComConfigSheet(sheet0);
                initSheet(sheet0, 0);
                ComEndConfigSheet(sheet0);
                sheet0.LoadSearchData(sXml,{Sync:0} );
                sheet0.RemoveEtcData();
				break;
			case IBSAVE:        
//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
//    				formObj.f_cmd.value = MULTI01;
//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
//    				break;
			case IBCREATE: 
				formObj.f_cmd.value = MULTI01;
				var sXml = "";
				if (formObj.flag.value == "search") {
					if (!chkValidCreate())
						return false;
					if (ComShowCodeConfirm("BSA10020") == false)
						return false;
				} else {
					if (ComShowCodeConfirm("BSA10019") == false)
						return false;
				}

				ComOpenWait(true);
				setTimeout(function() {
					if (formObj.flag.value == "search") {
						sXml = sheetObj.GetSearchData("ESM_BSA_0030GS2.do",bsaFormString(formObj) + "&" + getParam2(curPgmNo));
					} else {
						sXml = sheetObj.GetSearchData("ESM_BSA_0030GS2.do",bsaFormString(formObj) + "&" + getParam2(curPgmNo));
					}
					var err_cd = ComGetEtcData(sXml, "err_cd");
					var err_msg = ComGetEtcData(sXml, "err_msg");
					sheetObj.RemoveEtcData();
		
					if (err_cd == "00000") {
						ComShowCodeMessage("BSA10006");
					} else {
						ComShowMessage(err_msg);
					}
					ComOpenWait(false);
				}, 100);
				break;
			case IBRESET:     
                if (chkValidCreate()) {
                    if (ComShowCodeConfirm('BSA10021') == true) { 
                        formObj.f_cmd.value=MULTI03;
                        //sheetObj.DoSearch("ESM_BSA_0030GS2.do", bsaFormString(formObj)+"&"+getParam2(curPgmNo) );
                        
//                        2014.11.04 김용습 - reset 동안 로딩화면 뜨게 함
                        ComOpenWait(true);
        				setTimeout( function(){
	                        var sXml=sheetObj.GetSearchData("ESM_BSA_0030GS2.do", bsaFormString(formObj)+"&"+getParam2(curPgmNo));                        
	                        var err_cd=ComGetEtcData(sXml,"err_cd");
	                        var err_msg=ComGetEtcData(sXml,"err_msg");
	                        sheetObj.RemoveEtcData();
	                        
	//                        2014.09.05 김용습 - AS-IS에 아래 소스가 존재하지 않아 주석처리 합니다
	//                        sheet0.LoadSearchData(sXml,{Sync:0} );
	                        
	                        if (err_cd == "00000") {
	                        	ComShowCodeMessage('BSA10018','RESET'); 
	        				} else {
	        				    ComShowMessage(err_msg);
	        				}
                        
                        ComOpenWait(false);
        				}, 100);
                    }
                }
                break;
			case IBDOWNEXCEL:       
				//sheetObj.SpeedDown2Excel(-1);
                var excelType=selectDownExcelMethod(sheetObj);
//                switch (excelType) {
//                    case "AY":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
//                    		}
//
//                    	
//                        break;
//                    case "DY":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    		}
//
//                    	
//                        break;
//                    case "AN":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel({ HiddenColumn:0});
//                    		}
//
//                    	
//                        break;
//                    case "DN":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
//                    		}
//
//                    	
//                        break;
//                }               
				break;
		}
	}
	
	
	function callBackExcelMethod(excelType){
		if(document.all.RadioLayer0.style.display != "none"){
			sheetObj = sheet0;
		} else if(document.all.RadioLayer1.style.display != "none"){
			sheetObj = sheet1;
		} else if(document.all.RadioLayer2.style.display != "none"){
			sheetObj = sheet2;
		} else {
			sheetObj = sheet3;
		}
		
		var xlOption;
		if(sheetObj.RowCount() < 1){//no data
      		ComShowCodeMessage("COM132501");
		}
		else {
			switch (excelType) {
			case "AY":
		           xlOption = { HiddenColumn:0, SheetDesign:1, Merge:1};
		           break;
		        case "DN":
					xlOption = { HiddenColumn:0, SheetDesign:0, Merge:0};
					break;
				case "DY":
					xlOption = {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 };
					break;
				case "DN":
					xlOption = {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 };
					break;
			}
			
			if(sheetObj.LastCol() > 256) {
			    xlOption.FileName = "excel.xlsx";
			    xlOption.SheetDesign = 0;
			} 
			sheetObj.Down2Excel(xlOption); 
		}
		/*
	      switch (excelType) {
	      case "AY":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
//	      			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
	      			sheetObj.Down2Excel({ HiddenColumn:0, Merge:1, SheetDesign:1});
	      		}
	
	      	
	          break;
	      case "DY":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
//	      			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
	      			sheetObj.Down2Excel({ HiddenColumn:1, Merge:1, SheetDesign:1});
	      		}
	
	      	
	          break;
	      case "AN":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
//	      			sheetObj.Down2Excel({ HiddenColumn:0});
	      			sheetObj.Down2Excel({ HiddenColumn:0, Merge:1, SheetDesign:1});
	      		}
	
	      	
	          break;
	      case "DN":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
//	      			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	      			sheetObj.Down2Excel( {HiddenColumn:1, Merge:1, SheetDesign:1} );
	      		}
	
	      	
	          break;
	  	}   
	  	*/      
      
	}
	
	
	
	
	/**
	 * Setting combo item
	 */
 	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			SetDropHeight(300);
			InsertItem(0, 'All' ,''); 
			Index=0;
			cobIOC.SetSelectIndex(0);
			cobDir.SetSelectIndex(0);
			cobLane.SetSelectIndex(0);
			cobTrade.SetSelectIndex(0);
			ValidChar(2,1);
		}
 	}
    /**
     * Handling the process realated with Slot Price sheet
     */
    function doActionIBSheet1(sheetObj, formObj, sAction){
		switch(sAction) {
			case IBSEARCH:      
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value=fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value=fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value=fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value=fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value=SEARCHLIST01;
				var xml=sheetObj.GetSearchData("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value=GetEtcDataForExceptional(xml,"crr_cnt");
				formObj.crr_cd.value=GetEtcDataForExceptional(xml,"crr_cd");
				formObj.saveNM.value=GetEtcDataForExceptional(xml,"saveNM");
				// Initializing sheet to changing Header Info.
                //--------------------------------------------------
                // resetting sheet after initializing.
//				sheet1.Reset();
				sheet1 = sheet1.Reset();					//SJH.20150512.공통변경에 따른 수정
				sheetObjects[1] = sheet1;					//SJH.20150512.공통변경에 따른 수정
                initSheet(sheet1, 1);
                //--------------------------------------------------
                sheet1.LoadSearchData(xml,{Sync:0} );
                sheet1.RemoveEtcData();
				break;
			case IBSAVE:        
//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
//    				formObj.f_cmd.value = MULTI02;
//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
//    				break;
		}
    }
	/**
	 * Handling the process realated with TEU & Slot Price Sheet
	 */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value=fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value=fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value=fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value=fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value=SEARCHLIST02;
				var xml=sheetObj.GetSearchData("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value=GetEtcDataForExceptional(xml,"crr_cnt");
				formObj.crr_cd.value=GetEtcDataForExceptional(xml,"crr_cd");
				formObj.saveNM.value=GetEtcDataForExceptional(xml,"saveNM");
				// Initializing sheet to changing Header Info.
                //--------------------------------------------------
                // resetting sheet after initializing.
//				sheet2.Reset();
				sheet2 = sheet2.Reset();					//SJH.20150512.공통변경에 따른 수정
				sheetObjects[2] = sheet2;					//SJH.20150512.공통변경에 따른 수정
                ComConfigSheet(sheet2);
                initSheet(sheet2, 2);
                ComEndConfigSheet(sheet2);
                //--------------------------------------------------
                sheet2.LoadSearchData(xml,{Sync:0} );
                sheet2.RemoveEtcData();
				break;
			case IBSAVE:       
//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
//    				formObj.f_cmd.value = MULTI01;
//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
//    				break;
		}
	}
	/**
	 * Handling the process realated with Basic Slottage Sheet
	 */	
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH:      
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value=fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value=fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value=fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value=fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value=SEARCHLIST03;
				var xml=sheetObj.GetSearchData("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value=GetEtcDataForExceptional(xml,"crr_cnt");
				formObj.crr_cd.value=GetEtcDataForExceptional(xml,"crr_cd");
				formObj.saveNM.value=GetEtcDataForExceptional(xml,"saveNM");
				// Initializing sheet to changing Header Info.
                //--------------------------------------------------
                // resetting sheet after initializing.
//				sheet3.Reset();
				sheet3 = sheet3.Reset();					//SJH.20150512.공통변경에 따른 수정
				sheetObjects[3] = sheet3;					//SJH.20150512.공통변경에 따른 수정
                ComConfigSheet(sheet3);
                initSheet(sheet3, 3);
                ComEndConfigSheet(sheet3);
                //--------------------------------------------------
                sheet3.LoadSearchData(xml,{Sync:0} );
                sheet3.RemoveEtcData();
				break;
			case IBSAVE:        
//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
//    				formObj.f_cmd.value = MULTI01;
//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
//    				break;
		}
	}
    /**
     * creating selected row in case of double-clicking sheet
     */
    function sheet0_OnDblClick(sheetObj, row, col){
        var formObj=document.form;
        formObj.flag.value="sheet";
        doActionIBSheet0(sheetObj,formObj,IBCREATE);
    }
    function sheet0_OnSearchEnd(sheetObj, code, errMsg){
       ComOpenWait(false);
       var insStatus=sheetObj.FindStatusRow("I");
       var arrRows=insStatus.split(";");
       for(k=0; k<arrRows.length-1; k++){
           sheetObj.SetRowEditable(arrRows[k],0);
       }
     //Making the column hidden in case isExcludZero is checked and total value is zero.
       sheetObj.RenderSheet(0);
       sheetObj.SetSumText(0, "TOTAL");
       if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol()-8; k++) {
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	             sheetObj.SetColHidden(k,1);
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol()-8; k++){
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
                  sheetObj.SetColHidden(k,0);
	      }	      
	  }
       sheetObj.RenderSheet(1);
       resizeSheet();
    }
    function sheet1_OnSearchEnd(sheetObj, code, errMsg){
       ComOpenWait(false);
       var insStatus=sheetObj.FindStatusRow("I");
       var arrRows=insStatus.split(";");
       for(k=0; k<arrRows.length-1; k++){
           sheetObj.SetRowEditable(arrRows[k],0);
       }
       //Making the column hidden in case isExcludZero is checked and total value is zero.
       sheetObj.RenderSheet(0);
       sheetObj.SetSumText(0, "TOTAL");
       if(document.form.isExcludZero.checked) {
          for(var k=0; k<=sheetObj.LastCol()-8; k++) {
        	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
                 sheetObj.SetColHidden(k,1);
          }
       } else {
          for(var k=0; k<=sheetObj.LastCol()-8; k++){
        	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
                  sheetObj.SetColHidden(k,0);
          }	      
       }
       sheetObj.RenderSheet(1);
       resizeSheet();
    }
    function sheet2_OnSearchEnd(sheetObj, code, errMsg){
    	ComOpenWait(false);
       var insStatus=sheetObj.FindStatusRow("I");
       var arrRows=insStatus.split(";");
       for(k=0; k<arrRows.length-1; k++){
           sheetObj.SetRowEditable(arrRows[k],0);
       }
       //Making the column hidden in case isExcludZero is checked and total value is zero.
       sheetObj.RenderSheet(0);
       sheetObj.SetSumText(0, "TOTAL");
       if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol()-8; k++) {
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	             sheetObj.SetColHidden(k,1);
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol()-8; k++){
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
                  sheetObj.SetColHidden(k,0);
	      }	      
	  }
       sheetObj.RenderSheet(1);
       resizeSheet();
    }
    function sheet3_OnSearchEnd(sheetObj, code, errMsg){
    	ComOpenWait(false);
       var insStatus=sheetObj.FindStatusRow("I");
       var arrRows=insStatus.split(";");
       for(k=0; k<arrRows.length-1; k++){
           sheetObj.SetRowEditable(arrRows[k],0);
       }
       //Making the column hidden in case isExcludZero is checked and total value is zero.
       sheetObj.RenderSheet(0);
       sheetObj.SetSumText(0, "TOTAL");
       if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol(); k++) {
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	             sheetObj.SetColHidden(k,1);
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol(); k++){
	    	  if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
                  sheetObj.SetColHidden(k,0);
	      }	      
	  }
       sheetObj.RenderSheet(1);
       resizeSheet();
    }
	/**
	 * display it in case of clicking radio button
	 * changing title and sheet 
	 */
	function InvOnChange( kind ){
	    var formObj=document.form;
		if ( kind == "0" ){// TEU : Grid to the supply Info
			document.getElementById("RadioLayer0").style.display="block";
			document.getElementById("RadioLayer1").style.display="none";
			document.getElementById("RadioLayer2").style.display="none";
			document.getElementById("RadioLayer3").style.display="none";
			document.form.rdoPerf[0].checked=true;
//    			if(formObj.txtYear.value != "") doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			
//			2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="none";
	        document.getElementById("div_zoom_out").style.display="inline";
//			div_zoom_in.style.display="none";
//			div_zoom_out.style.display="inline";
			
		} else if ( kind == "1") { // Basic Slottage : Grid to revenue/expense Info
			document.getElementById("RadioLayer0").style.display="none";
			document.getElementById("RadioLayer1").style.display="block";
			document.getElementById("RadioLayer2").style.display="none";
			document.getElementById("RadioLayer3").style.display="none";
			document.form.rdoPerf[1].checked=true;
//    			if(formObj.txtYear.value != "")doActionIBSheet2(sheetObjects[1],formObj,IBSEARCH);
//			2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="none";
	        document.getElementById("div_zoom_out").style.display="inline";
//			div_zoom_in.style.display="none";
//			div_zoom_out.style.display="inline";
		} else if ( kind == "2") { // Slot Price
			document.getElementById("RadioLayer0").style.display="none";
			document.getElementById("RadioLayer1").style.display="none";
			document.getElementById("RadioLayer2").style.display="block";
			document.getElementById("RadioLayer3").style.display="none";
			document.form.rdoPerf[2].checked=true;
//			2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="none";
	        document.getElementById("div_zoom_out").style.display="inline";
//			div_zoom_in.style.display="none";
//			div_zoom_out.style.display="inline";
		} else if ( kind == "3") { // TEU & Slot Price
			document.getElementById("RadioLayer0").style.display="none";
			document.getElementById("RadioLayer1").style.display="none";
			document.getElementById("RadioLayer2").style.display="none";
			document.getElementById("RadioLayer3").style.display="block";
			document.form.rdoPerf[3].checked=true;
//			2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="none";
	        document.getElementById("div_zoom_out").style.display="inline";
//			div_zoom_in.style.display="none";
//			div_zoom_out.style.display="inline";
		}		
		resizeSheet();
	}
	 /**
	  * showing R.Lane with using ifram
	  */
	 function cobTrade_OnChange(obj) {
		if (loadingMode == true) return;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		sheetObj.SetWaitImageVisible(0);
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
		sheetObj.SetWaitImageVisible(1);
	 }
    /**
     * modifying period in case of modifying month and week
     */
	
	 function fillSpace(obj, spaceNum, spaceStr, flag){
        var i=0;
        var val=obj.value;
        var fillString="";
        if(val.length>0){
            for(i=0;i<(spaceNum - val.length); i++){
                fillString=fillString + spaceStr;
            }
        }
        if(flag == "left"){
            obj.value=fillString + val;
        } else if(flag == "right"){
            obj.value=val + fillString;
        }
    }
	
    function setPeriod(obj){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var param="";
        var gubun="";
        var fm_mon="";
        var to_mon="";
        var fm_wk="";
        var to_wk="";
        if(obj.value == ""){// Clearing from-data in case to-data is empty.
            if(obj.name == "txtToMonth" ){
                formObj.txtFmMonth.value="";
            } else if (obj.name == "txtToWeek"){
                formObj.txtFmWeek.value="";
            }
            return false;
        } 
        if(chkValidSearch()){
            if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != ""){
            	gubun="5";
            } else if(formObj.txtFmMonth.value == "" && formObj.txtFmWeek.value != "") {
            	gubun="4";
            } else if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value == "") {
            	gubun="3";
            }
            formObj.param2.value=formObj.txtYear.value;
            if(formObj.chkPrd[0].checked){
                formObj.param5.value="";
                formObj.param6.value="";
                formObj.param7.value=formObj.txtFmWeek.value;
                formObj.param8.value=formObj.txtToWeek.value;
                fm_wk=formObj.txtFmWeek.value;
                to_wk=formObj.txtToWeek.value;
            } else {
                formObj.param5.value=formObj.txtFmMonth.value;
                formObj.param6.value=formObj.txtToMonth.value;
                formObj.param7.value="";
                formObj.param8.value="";
                fm_mon=formObj.txtFmMonth.value;
                to_mon=formObj.txtToMonth.value;
            }
            param=param+"f_cmd="+SEARCHLIST02;
			param=param+"&gubun="+gubun;
			param=param+"&fm_mon="+fm_mon;
			param=param+"&to_mon="+to_mon;
			param=param+"&fm_wk="+fm_wk;
			param=param+"&to_wk="+to_wk;
			param=param+"&year="+eval(formObj.txtYear.value);
			param=param+"&code=period";
			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var period=GetEtcDataForExceptional(sXml, "period", "0");
			document.getElementById("div_period").innerHTML="<div id=\"div_period\">("+ period +")</div>";
			
			btnEnable();			//SJH.20150130.ADD
        }
    }
    /**
     * Checking mandatory input in case of search
     */
    function chkValidSearch(){
        var formObj=document.form;
		with(formObj){
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			    //txtYear.focus();
				return false;
			}
			if (txtFmMonth.value != "" && txtToMonth.value == "") {
				ComShowCodeMessage("COM12114", "month", "");
			   // txtToMonth.focus();
			    return false;
			}
			if (txtFmMonth.value == "" && txtToMonth.value != "") {
				ComShowCodeMessage("COM12114", "month", "");
			   // txtFmMonth.focus();
			    return false;
			}
			if (txtFmWeek.value != "" && txtToWeek.value == ""){
				ComShowCodeMessage("COM12114", "week", "");
			    //txtToWeek.focus();
			    return false;
			}
			if (txtFmWeek.value == "" && txtToWeek.value != ""){
				ComShowCodeMessage("COM12114", "week", "");
			    //txtFmWeek.focus();
			    return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
//    			    ComShowCodeMessage("COM12138", "month", "week");
			    return false;
			}
		    if(!isValidYear(txtYear,false,true)) return false;
			if(!isValidMonth(txtFmMonth,false,true)) return false;
			if(!isValidMonth(txtToMonth,false,true)) return false;
			if(!isValidWeek(txtFmWeek,false,true)) return false;
			if(!isValidWeek(txtToWeek,false,true)) return false;
		}
		return true;
    }
    /**
     * Checking mandatory item in case of creation
     */
    function chkValidCreate(){
        var formObj=document.form;
        with(formObj){
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			   // txtYear.focus();
				return false;
			}
			if(chkPrd.value == "M"){
			    if(txtFmMonth.value == "") {
    			    ComShowCodeMessage("COM12114", "Month");
    			    return false;
			    }
    			if (txtFmMonth.value != "" && txtToMonth.value == ""){
    				ComShowCodeMessage("COM12114", "To Month", "");
    			  //  txtToMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value == "" && txtToMonth.value != ""){
    				ComShowCodeMessage("COM12114", "FM Month", "");
    			  //  txtFmMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value != "" && txtToMonth.value != "") {
    			    if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
    			        ComShowCodeMessage("COM12133","from Month"," to Month","작은값");
    			       // txtToWeek.focus();
    			        return false;
    			    }
    			    if(ComParseInt(txtToMonth.value)-ComParseInt(txtFmMonth.value)>0){
    			        ComShowCodeMessage("BSA10008","1");
    			       // txtToMonth.focus();
    			        return false;
    			    }
    			}
			} else {
    			if(txtFmWeek.value == ""){
    			    ComShowCodeMessage("COM12114", "week");
    			    return false;
    			}
    			if (txtFmWeek.value != "" && txtToWeek.value == ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			  //  txtToWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value == "" && txtToWeek.value != ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    //txtFmWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value != "" && txtToWeek.value != "") {
    			    if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
    			        // [COM12133] : from Week must be smaller than to Week.
    			        ComShowCodeMessage("COM12133","from Week"," to Week","smaller");
    			        //txtToWeek.focus();
    			        return false;
    			    }
    			    if(cobTrade.value != "" && cobLane.value != ""){
        			    if(ComParseInt(txtToWeek.value)-ComParseInt(txtFmWeek.value)>22){
        			        // [BSA10008] : Can not exceed 22weeks
        			        ComShowCodeMessage("BSA10008","22weeks");
        			        //txtToWeek.focus();
        			        return false;
        			    }
    			    }else{
        			    if(ComParseInt(txtToWeek.value)-ComParseInt(txtFmWeek.value)>55){
        			        //[BSA10024] : It can not be exceeded by 5 weeks. Please select Trade, Lane data.
        			    	ComShowCodeMessage("BSA10024","5", "Trade, Lane");
        			       // txtToWeek.focus();
        			        return false;
        			    }
    			    }
    			}
			}
        }
        return true;
    }
    /**
     * Showing Pop up to check whether it's hidden or not
     */
    function viewPopUp(){
        var formObj=document.form;
        var count=0;
        var hValue="";
        var tmp="";
        var crr_cnt=formObj.crr_cnt.value.split("|");
        for(j=0; j<crr_cnt.length; j++) count=parseInt(count) + parseInt(crr_cnt[j]);
        if(formObj.rdoPerf[0].checked){
            var sheetObj=sheetObjects[0];
            for(k=21; k<count+21; k++){
                if(sheetObj.GetColHidden(k))tmp="0";     // Hidden
                else tmp="1";                         // Show
                hValue=hValue + tmp;
                if(k!=count+20) {
                    hValue=hValue + "|";
                }
            }
        } else {
            var sheetObj=sheetObjects[1];
            for(k=28; k<count+28; k++){
                if(sheetObj.GetColHidden(k))tmp="0";     // Hidden
                else tmp="1";                         // Show
                hValue=hValue + tmp;
                if(k!=count+27) hValue=hValue + "|";
            }
        }
        var param="?hValue="+hValue+"&txtYear="+formObj.txtYear.value+"&txtFmMonth="+formObj.txtFmMonth.value+"&txtToMonth="+formObj.txtToMonth.value+"&txtFmWeek="+formObj.txtFmWeek.value+"&txtToWeek="+formObj.txtToWeek.value
        noRtnPopup('ESM_BSA_126.do'+param , 'width=870,height=460,menubar=0,status=1,scrollbars=0,resizable=0');
    }
    /**
     * Making the coulmn hidden
     */
    function chgView(){
        var formObj=document.form;
        var j=0;
        var hValue=formObj.hValue.value.split("|");
        if(formObj.rdoPerf[0].checked){
            var sheetObj=sheetObjects[0];
            for(k=21; k<hValue.length+21; k++){
                if(hValue[j] == "1") sheetObj.SetColHidden(k,0);
                else sheetObj.SetColHidden(k,1);
                j++;
            }
        } else {
            var sheetObj=sheetObjects[1];
            for(k=28; k<hValue.length+28; k++){
                if(hValue[j] == "1") sheetObj.SetColHidden(k,0);
                else sheetObj.SetColHidden(k,1);
                j++;
            }
        }
    }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//    		    if(!chkValidSearch()) return false;
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			   // txtYear.focus();
				return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
				ComShowCodeMessage("COM12138", "month", "week");
			    return false;
			}
			if((chkPrd[1].checked && txtFmMonth.value == "" && txtToMonth.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Month", "VVD");
			    return false;
			}
			if((chkPrd[0].checked && txtFmWeek.value == ""  && txtToWeek.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Week", "VVD");
			    return false;
			}	
			if (chkPrd[1].checked && txtFmMonth.value != "" && txtToMonth.value != "") {
	    		if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
	    			ComAlertFocus(txtToMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
	        		return false;
	    		}
			}
			if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
	    		if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
	    			ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
	        		return false;
	    		}
			}
		}
		return true;
	}
    /**
     * validation check to VVD code
     */
    function chkVVD() {
        var formObj=document.form;
    }
    function loadCombo() {
    	var formObj=document.form;
 		var sXml=formObj.sXml.value;
 		var arrXml=sXml.split("|$$|");
 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
 		if (arrXml.length > 3)
 			ComXml2ComboItem(arrXml[3], cobIOC, "code", "code");
 		var rtnArr=null;
 		var divStr="";
 		var codeArr=null;
 		var nameArr=null;
 		var checked="";
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
				divStr += "<input type=\"radio\" value=\""+codeArr[i]+"\" class=\"trans\" name=\"rdoPerf\" id=\""+codeArr[i]+"\" onClick=\"InvOnChange("+i+");\""+checked+"><label for=\""+codeArr[i]+"\">"+nameArr[i]+"</label></input>";
				if(i < codeArr.length)
					divStr += "&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_gubun").innerHTML="<div id=\"div_gubun\">"+ divStr +"</div>";
		}
 		document.form.sXml.value="";
     }
    //CalcLogic:"final_co_bsa(|type_flg|, |co_bsa_bfr_sub_capa|, |final_co_bsa2|, "+sub_charter_out_bsa+", "+sub_charter_in_bsa+", "+cross_charter_out_bsa+", "+cross_charter_in_bsa+")"
    //final_co_bsa="IF(|type_flg|==0, |co_bsa_bfr_sub_capa|-" + sub_charter_out_bsa + "+" + sub_charter_in_bsa + "-" + cross_charter_out_bsa + "+" + cross_charter_in_bsa + ", |final_co_bsa2|)";
    function final_co_bsa_m(type_flg, total, final_co_bsa2){
    	if(type_flg == 0){
    	   return total;
    	}
    	else {
    	   return final_co_bsa2;
    	}
    }
    //CalcLogic:"co_rto(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|)"
    //co_rto="IF(|bsa_flg|==1, 100 , IF(|fnl_co_bsa_capa|==0, 0,(|fnl_co_bsa_capa|/(|fnl_co_bsa_capa|+|co_bsa_capa|))*100))";
    function co_rto_m(bsa_flg, fnl_co_bsa_capa, co_bsa_capa){
    	if(bsa_flg == 1)return 100;
    	if(fnl_co_bsa_capa == 0){
    		return 0;
    	}else{
    		return (fnl_co_bsa_capa / (fnl_co_bsa_capa + co_bsa_capa))*100;
    	}
    }
    //CalcLogic:"cht_rto(|bsa_flg|, co_rto(|bsa_flg|, |fnl_co_bsa_capa|, |co_bsa_capa|))"
    //cht_rto="IF(|bsa_flg|==1, 0,(1-co_rto/100)*100)";
    function cht_rto_m(bsa_flg, co_rto){
    	if(bsa_flg ==1){
    		return 0;
    	}else{
    		return (1-co_rto/100)*100;
    	}
    }
    //CalcLogic:"cht_out(|type_flg|, |vop_flg|, "+joint_operation+", "+sub_charter_out+", "+cross_charter_out+")"
    //cht_out="IF(|type_flg|==0, IF(|vop_flg|==0, " + joint_operation + sub_charter_out + cross_charter_out + ", " + sub_charter_out + "+" + cross_charter_out + "), "IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + ", " + sub_charter_out + "))";
    function cht_out_m(type_flg, vop_flg, joint_operation, sub_charter_out, cross_charter_out){
    	if(type_flg == 0){
    		if(vop_flg == 0){
    			return joint_operation + sub_charter_out + cross_charter_out;
    		}else{
    			return sub_charter_out + cross_charter_out;
    		}
    	}else{
    		if(vop_flg == 0){
    			return joint_operation + sub_charter_out;
    		}else{
    			return sub_charter_out;
    		}
    	}
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i], 50);
        }
    }

//    2014.11.20 김용습 - Enter키 조회 기능 추가
    function initControl() {
		  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    } 
    
    //SJH.20150130.ADD : WEEK선택시만 활성화.
    function btnEnable(){
        if(document.form.chkPrd[0].checked){
            ComBtnEnable("btng_creation");
            ComBtnEnable("btng_reset0");     
            ComBtnEnable("btng_reset1");  		//20150713.ADD
            ComBtnEnable("btng_reset2");  
            ComBtnEnable("btng_reset3");
        } else {
            ComBtnDisable("btng_creation");
            ComBtnDisable("btng_reset0");    
            ComBtnDisable("btng_reset1");  		//20150713.ADD
            ComBtnDisable("btng_reset2");  
            ComBtnDisable("btng_reset3");            
        }
    }
    
    
    