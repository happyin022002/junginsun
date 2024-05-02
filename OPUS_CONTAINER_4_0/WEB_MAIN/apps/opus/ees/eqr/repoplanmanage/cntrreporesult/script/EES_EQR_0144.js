/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0144.js
*@FileTitle : Empty Repo Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheet1.RemoveAll();
    	            formObject.reset();
    	            comboObjects[0].SetSelectCode("ALL");
    	            document.form.transmode.value="ALL";
    	            comboObjects[1].SetSelectCode(consTpsz);
        	        break;
                case "btn_downexcel":
                	
            			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);    
			        break;        	        
      			case "fmloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:fmloc|loc_dpth_cd:fmType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
        		     break;
        		case "toloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:toloc|loc_dpth_cd:toType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
        		     break;
        		case "atloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:atEccCd|loc_dpth_cd:atType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
        		     break;        		       
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("EQR90004");
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
     * registering IBSheet Combo Object as list
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
        var tpsz=null;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,tpsz);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo(comboObjects[p],p+1);
        }
        document.form.tpszall.value=consTpsz;
        document.form.fmdate.maxLength="8";
        tpszChange("ALL");
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo,tpsz) {
        var cnt=0;
        var TotalCount='';
        var TitleCount;
        var TitleKey=consTpsz;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
	              if ((tpsz =='' || tpsz == null)){
		              title=tpszallText+'|';
		              num=TitleKey.split(',');
		              TotalCount=num.length + 9;
		          }else {
		              TitleCount=""+ tpsz +"";
		              title=TitleMake(TitleCount);
		              num=TitleCount.split(',');
		              TotalCount=num.length + 9;
		          }
	
		          var TotSum="";
		          var HeadVol="";
		          if ((tpsz !='' || tpsz != null)){
		              for(var i=0; i<num.length ; i++) {
		            	  TotSum += "|"+num[i]+"cntr_qty|+"
		            	  HeadVol += "|Vol"
		              }
		          }
	              TotSum=TotSum.substring(0,TotSum.length-1);
	              var HeadTitle1="Del.|STS|Seq.|FM LOC|TO LOC|SO Sent Period|Mode|Vol" + HeadVol ;
	              var HeadTitle="Del.|STS|Seq.|FM LOC|TO LOC|SO Sent Period|Mode|TTL|" + title ;
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del" },
	                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_loc",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"period",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"transmode",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",                         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
	                    if ((tpsz =='' || tpsz == null)){
	                    	for(var i=0; i<num.length ; i++) {
	                    		cols.push({Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:num[i].toLowerCase()+"cntr_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	                    	}
	                    } else {
	                    	for(var i=0; i<num.length ; i++) {
	                    		cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:num[i].toLowerCase()+"cntr_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	                    	}
	                    	cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hidden" });
	         
	                    	
	                    }
	                    InitColumns(cols);	                	
                    	SetEditable(1);
                    	subSum(sheetObj);
//	                    SetSheetHeight(ComGetSheetHeight(sheetObj, 19));
	                    CountFormat = "[SELECTDATAROW / TOTALROWS]";
	                    resizeSheet( sheetObj );
	                    
	              }
                document.form.tpcnt.value=num.length;
                break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
	{
		//subSum(sheetObj);
	  /*if(document.form.weekMonth[1].checked == true){
	    sheetObj.SetCellValue(0,"week","Month");
	  }else{
	    sheetObj.SetCellValue(0,"week","Week");
	  }*/
	  //data1 && data2 조회 또는 data1 = P 조회.
	  /* if(document.form.orgDst[0].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',0);
	     sheetObj.SetColHidden('to_ecc_cd',1);
	   }*/
	  /* if(document.form.orgDst[1].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',1);
	     sheetObj.SetColHidden('to_ecc_cd',0);
	   }
	   if(document.form.orgDst[2].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',0);
	     sheetObj.SetColHidden('to_ecc_cd',0);
	   }*/
	  //data1 만 조회시(P가 아닌 경우)
	 /* if(document.form.dataSelect1.value != 'P' && document.form.dataSelect2.value == '' ){
	      sheetObj.SetColHidden('fm_ecc_cd',0);
	      sheetObj.SetColHidden('to_ecc_cd',1);
	  }*/
	}
   /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initCombo (comboObj, comboNo) {
        var cnt=0 ;
        switch(comboNo) {
		// Item
        case 1:
           	with (comboObj) {
           		SetDropHeight(8 * 20);//8 * 20
				var menuname=itemText.split('|');
				var menucode=itemCode.split('|');
           		SetMultiSelect(1);
           		SetMaxSelect(menuname.length);
           		SetMultiSeparator(",");
           		InsertItem(cnt ++, "ALL", "ALL");
    			for(i=0; i<menuname.length; i++) {
    				if (menucode[i] == "R") {
    					InsertItem(cnt++, menuname[i], "RD");
    				}
    				if (menucode[i] == "T") {
    					InsertItem(cnt++, menuname[i], "TD");
    				}
    				if (menucode[i] == "W") {
    					InsertItem(cnt++, menuname[i], "WD");
    				}
  				}
    			comboObj.SetSelectCode("ALL");// Default 값 셋팅
	    	}
           break;
           // Type Size
            case 2:
               with (comboObj) {
               	SetDropHeight(12 * 18);//12 * 18
                var menuname2=tpszallText.split('|');
                var menucode2=tpszallCode.split('|');
               	SetMultiSelect(1);
               	SetMaxSelect(menuname2.length );
               	SetMultiSeparator(",");
       	        for(i=0; i<menuname2.length; i++) {
                    InsertItem(cnt ++, menuname2[i], menucode2[i]);                      		
                } 
    	    }
               break;
         }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var perfix=new Array(comboObjects[1].GetSelectText());
        switch(sAction) {
           case IBSEARCH:      //조회
      			    //OrgDest : org 면 to값을 All 로 바꿈., dest먄 fm 입력값을 All 로 바꿈.
//      			    if(formObj.orgDst[0].checked == true){
//      			      formObj.toType.value = "";
//      			      formObj.toloc.value = "";
//      			    }
//      			    if(formObj.orgDst[1].checked == true){
//      			      formObj.fmType.value = "";
//      			      formObj.fmloc.value = "";
//      			      
//      			    }
//      			    
//      			    if((document.form.dataSelect1.value == 'P' && document.form.dataSelect2.value == '') ||
//                   (document.form.dataSelect1.value != '' && document.form.dataSelect2.value != '')){
//      			        if(document.form.orgDst[0].checked == true){//ORG
//      			           formObj.toFmPlnYr.value = "";
//          			       formObj.toFmPlnWk.value = "";
//          			       formObj.toToPlnYr.value = "";
//          			       formObj.toToPlnWk.value = "";
//      			        }
//      			        if(document.form.orgDst[1].checked == true){//DST
//      			           formObj.fmFmPlnYr.value = "";
//          			       formObj.fmFmPlnWk.value = "";
//          			       formObj.fmToPlnYr.value = "";
//          			       formObj.fmToPlnWk.value = "";
//      			        }
//      			    }
//      			    
//      			    
//      			    if(formObj.fmToAt[0].checked == true){
//                      formObj.fmToAtOld.value = "0";
//                    }else{
//                      formObj.fmToAtOld.value = "1";
//                    }
//                
//                formObj.fmTypeByOld.value = formObj.fmTypeBy.value;
//                formObj.toTypeByOld.value = formObj.toTypeBy.value;
//                formObj.atTypeByOld.value = formObj.atTypeBy.value;
                //동적으로 보여주기 위해서 IBSHEET 레이아웃 초기화 하고 다시 보여준다. 
                if(!validateForm(sheetObj,formObj,sAction)){
                	return false;
   			    }
                //sheetObj.SetVisible(0);
                //sheetObj.RemoveAll();
               	sheetObj = sheetObj.Reset();
               	sheetObjects[0] = sheetObj;
                initSheet(sheetObjects[0], 1, perfix);
                //sheetObjects[0].SetVisible(1);
                //sheetObjects[0].SetExtendLastCol(0);
                //end
   			    formObj.f_cmd.value=SEARCHLIST;
   			 
   			    subSum(sheetObjects[0]);
   			    sheetObj.DoSearch("EES_EQR_0144GS.do", eqrFormQryStr(formObj) );
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value=MULTI;
                break;
           case IBINSERT:      // 입력
                sheetObj.DataInsert();
                break;
           case IBCOPYROW:        //행 복사
        	   	sheetObj.DataCopy();
        	   	break;
           case IBDOWNEXCEL:        //엑셀 다운로드
           		if(sheet1.RowCount() < 1){
           			ComShowCodeMessage("COM132501");
           		}else{
           			sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
           		}
           		break;
           case IBLOADEXCEL:        //엑셀 업로드
               sheetObj.LoadExcel();
               break;
        }
    }
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//        	if(formObj.fmloc.value == '' && formObj.toloc.value == '') {
//        		ComShowCodeMessage("EQR90001", "LOC data");//Please input LOC data	
//        		eval("formObj.fmloc").focus();
//        		return false;
//        	}
        	var pd=formObj.period.value;
        	var fm=formObj.fmdate.value;
        	var to=formObj.todate.value;
        	if(pd == 'Day'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From date");//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To date");//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}        			
        	}else if(pd == 'Week' || pd == 'Month'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From "+pd);//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To "+pd);//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        	}
        	if(fm > to){
        		ComShowCodeMessage("EQR90215") // End date must be greater than start date.
        		eval("formObj.todate").focus();
        		return false;
        	}
        	if (formObj.transmode.value == "") {
        		ComShowCodeMessage("EQR90016", "Mode");//Please select Mode.
        		return false;
        	}
        	if (formObj.fmType.value != "ALL") {
				if(!checkLocItem(formObj, 'fmType', 'fmloc')) {
					return false;
				}
        	}
        	if (formObj.toType.value != "ALL") {
				if(!checkLocItem(formObj, 'toType', 'toloc')) {
					return false;
				}
        	}
        }
        return true;
    }
   function tpszChange(key){
        switch (key)
        {
            case "ALL":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpsz);
            	break;
            case "D":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszDry);
            	break;
            case "S":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszSpc);
            	break;
            case "R":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszZrb);
            	break;
            /*case "R":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszRfr);
            	break;
            case "O":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszOt);
            	break;
            case "F":
            	comboObjects[1].SetSelectCode(-1);
                comboObjects[1].SetSelectCode(consTpszFr);
            	break;*/
        }
    }	   
    function subSum(sheetObj){
		//
		var TotalCount='';
		var num=document.form.tpcnt.value;
		var TotSum='7';
	  for(var i=0, j=8 ; i<num ; i++, j++) {
		     TotSum += "|"+j
		 }     
	  sheetObj.ShowSubSum([{StdCol:"ibflag", SumCols:TotSum, Sort:false, ShowCumulate:false, CaptionCol:"fm_loc", CaptionText:"TTL"}]);
    }
    function TitleMake(TitleCount){
      var strCheckList='';
          num=TitleCount.split(',');
      for(var i=0; i < num.length ; i++)  {
           strCheckList=strCheckList + num[i] + "|";
       }
      return strCheckList;
    } 
    // 유효 입력 date 조건
    function isValidDate(date, period){
    	if(period == 'Day'){
    		if(date.length != 8){
    			return false;
    		}
    		if(isValidYear(date) && isValidMonth(date)){
    			if(isValidDay(date)){
    				return true;	
    			}else{
        			return false;
    			}
    		} else {
    			return false;
    		}
    	} else if(period == 'Month'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidMonth(date)){
    			return true;
    		} else {
    			return false;
    		}
    	} else if(period == 'Week'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidWeek(date)){
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
    // 유효 연차 체크
    function isValidYear(yyyyww) {
    	var year=yyyyww.substring(0,4);
    	if (parseInt( year ) >= 1900) {
    		return true;
    	} else {
    		return false;
    	}
    }    
    // 유효 월차 체크
    function isValidMonth(yyyymm) {
    	var month=yyyymm.substring(4,6);
       	var intmonth=parseInt( month , 10 )
       	if( intmonth >= 1  && intmonth <= 12 ) {
       		return true;
       	} else {
       		return false;
       	}
    } 
    // 유효 주차 체크
    function isValidWeek(yyyyww) {
    	var week=yyyyww.substring(4,6);
    	if (parseInt( week , 10) >= 1 &&  parseInt(week , 10) <= 53) {
    		return true;
    	} else {
    		return false;
    	}
    }
    // 유효 날짜 체크
    function isValidDay( date ) {
    	var year=date.substring(0,4);
    	var month=date.substring(4,6);
    	var day=date.substring(6,8);
    	var monthDD=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    	var im=parseInt(month) - 1;
    	if( ( (year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ) {
    		monthDD[1]=29;
    	}
    	if( parseInt( day , 10 ) <= 0 || parseInt( day , 10 ) > monthDD[im] ) {
    		return false;
    	} else {
    		return true;
    	}
    } 
    // 선택된 Period Type에 따라서 fmdate MaxLength 변경
    function changeFmDateMaxLength(arg) {
    	var checkType=arg.value;
    	document.form.fmdate.value="";
    	document.form.todate.value="";
    	if (checkType == "Day") {
    		document.form.fmdate.maxLength="8";
    		document.form.todate.maxLength="8";
    	} else if (checkType == "Week" || checkType == "Month") {
    		document.form.fmdate.maxLength="6";
    		document.form.todate.maxLength="6";
    	}
    }
    
    
    // Mode 값이 변경되었을때 처리
    function item_code_OnChange(comboObj , oldindex , oldtext , oldcode , idx ,txt , newcode){
    	var selectMode="";
    	var preSelectMode=document.form.transmode.value;
    	// ALL 이 선택된 상태에서는 다른 Mode가 선택이 되지 않도록 막는다.
//    	if(txt.search("ALL") != -1){
//    		comboObjects[0].Code = "ALL";
//    		selectMode = "ALL";
//    	} else {
//    		selectMode = txt;
//    	}    
       	if (preSelectMode == "ALL" && txt.search("ALL") != -1) {       		
       		document.form.item.value = "";
       		comboObj.SetItemCheck("ALL",false);
    		comboObjects[0].Code = txt.substring(4, txt.length);
    		selectMode = newcode.substring(4, newcode.length); //txt.substring(4, newcode.length);    		
    		newcode = newcode.substring(4, newcode.length);
    	} else {    		
    		if (preSelectMode.search("ALL") == -1 && txt.search("ALL") != -1) {
    			comboObjects[0].SetItemCheck("RD",false,false)
    			comboObjects[0].SetItemCheck("TD",false,false)
    			comboObjects[0].SetItemCheck("WD",false,false)
    			comboObj.SetSelectCode(-1,false);    		
    			comboObj.SetSelectCode("ALL",false);
    			newcode = "ALL";
    			comboObjects[0].Code = "ALL";
    			selectMode = "ALL";
    		} else {
    			//selectMode = txt;
    			selectMode = newcode;
    		}
    	}
			
    	document.form.transmode.value = selectMode;   	
    	document.form.item.value = newcode;
/*       	if (preSelectMode == "ALL" && txt.search("ALL") != -1) {
       		alert(txt.substring(4, txt.length));
       		comboObj.SetSelectText(txt.substring(4, txt.length) );
    		selectMode=txt.substring(4, txt.length);
    	} else {
    		if (preSelectMode.search("ALL") == -1 && txt.search("ALL") != -1) {
    			document.form.item.value = "ALL";
    			comboObj.SetSelectText("ALL");
    			selectMode="ALL";
    		} else {
    			selectMode=txt;
    		}
    	}
    	document.form.transmode.value=selectMode;
    	document.form.item.value = newcode;*/
    }
