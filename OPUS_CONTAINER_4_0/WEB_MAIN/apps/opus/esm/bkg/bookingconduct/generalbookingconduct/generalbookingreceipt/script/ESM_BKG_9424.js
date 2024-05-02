/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_9424.js
*@FileTitle  : Empty Repo BKG Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/

	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var oldPodCd="";
	var oldInterRmk="";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject=sheetObjects[0];
        var sheetObject3=sheetObjects[2];
        var sheetObject6=sheetObjects[5];
        /*******************************************************/
        var formObject=document.form;
  		var bkgNo=ComGetObjValue(formObject.bkg_no);
		var blNo=ComGetObjValue(formObject.bl_no);
		var bkgMvmtCd=ComGetObjValue(formObject.bkg_mvmt_cd);
     	try {
     		var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}	     	
    		
            switch(srcName) {
	         	case "btns_EventDt":
		            var cal=new ComCalendar();
		            cal.select(formObject.cnmv_evnt_dt, 'yyyy-MM-dd hh:mm');           
					break;    
                case "btn_Ts":
  		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
 		        		ComShowCodeMessage("BKG00448");
  		        	}else{
  		        		ComOpenPopup("ESM_BKG_9454.do?pgmNo=ESM_BKG_9454&bkg_no="+bkgNo, 600, 480, "","1,0,1,1,1", true);
  		        	}                	 
                    break;
                case "btn_BtmRetrive":
              		if(bkgNo != null && bkgNo.length > 0){
            			ComResetAll();
            			ComSetObjValue(formObject.bkg_no,bkgNo);
            			ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
            			doActionIBSheet(sheetObject, formObject, IBSEARCH);            			
            		}else if(blNo != null && blNo.length > 0){
            			ComResetAll();
            			ComSetObjValue(formObject.bl_no,blNo);
            			ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
            			doActionIBSheet(sheetObject, formObject, IBSEARCH);               			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObject.bkg_no);            			
            		}
                     break;
                case "btn_BtmNew":
                	ComResetAll();
     				ComBtnEnable("btn_Add");
    				ComBtnEnable("btn_Delete");
    				ComBtnEnable("btn_Move");
    				ComBtnEnable("btn_BtmSave");                	 
                    break;
 		        case "btn_BtmSave":
 		        	if(validateForm(sheetObject,formObject,IBSAVE)){
            			if(ComShowCodeConfirm("BKG00824")){
            				
            				var formObject=document.form;
                    		var sheetObj=sheetObjects[0];          //
                    		if(sheetObject.RowCount()> 0) {                    			
                    			var fmYdLoc = formObject.bkg_pol_cd.value;
                    			var toYdLoc = formObject.bkg_pod_cd.value;
                    			var volTotal = sheetObj.RowCount();
                    			var vCode = "";
                    			var vCodeNm = "";
                    			
                    			formObject.f_cmd.value=SEARCH01;
                    			var intgCdId='CD30101';
                    			var param="&intgCdId="+intgCdId;
                    			var xml=sheetObject.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObject)+param);
                    			
                    			if (xml != "") {
                    				var arrStrCode=ComGetEtcData(xml, "code_nm");
                    				var arrCode = arrStrCode.split("@");
                    				var strAllCode="";
                    				var arrAllCode="";
                    				for(var i=0;i<arrCode.length;i++) {						
                    					strAllCode = arrCode[i].split("@");
                    					for(var j=0;j<strAllCode.length;j++) {
                    						arrAllCode = strAllCode[j].split("|");
                    						strCode = arrAllCode[0];
                    						strCodeNm = arrAllCode[1];
                    						
                    						if(i == 0) {
                    							vCode =  strCode;
                    							vCodeNm =  strCodeNm; 
                    						}else{
                    							vCode = vCode + "|" + strCode; 
                    							vCodeNm = vCodeNm + "|" + strCodeNm; 
                    						}
                    					}
                    				}
                    			}
                    			
                    			var chkVolRtn = chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal);                    			
                    			if(chkVolRtn == false) {
                    				return false;
                    			}
                    		}
                    		
            				doActionIBSheet(sheetObject, formObject, IBSAVE);
            			} 		 		        		 		        		
 		        	}
                    break;
 		        case "btn_BtmCancel":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
 		        		ComShowCodeMessage("BKG00448");
 		        	}else if(sheetObjects[0].RowCount()> 0){
 		        		ComShowCodeMessage("BKG00825");
 		        	}else{
            			if(ComShowCodeConfirm("BKG00575")){
            				doActionIBSheet(sheetObject, formObject, MULTI02);
            			} 		        		 		        		
 		        	}
                    break;
 		        /** Left Group **/
 		        case "btn_ExcelFormat":
 		        	sheetObject6.RemoveAll();
 		        	sheetObject6.DataInsert(-1);
 		        	sheetObject6.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject6), SheetDesign:1,Merge:1 });
 		            break;
                case "btn_LoadExcel":
                	sheetObject.LoadExcel({ Mode:"HeaderMatch", StartRow: "1",Append:1});
                    break;
 		        case "btn_DownExcel":
					if(sheetObject.RowCount() < 1){
 		        		ComShowCodeMessage("COM132501");
 		        	}else{
 		        		sheetObject.Down2Excel({DownCols: "1|2|3|4|5|6|7|8|9|10", SheetDesign:1, Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:" " });
 		        	}
                    break;
 		        case "btn_Add":
 		        	sheetObject.DataInsert(-1);
 		        	break;
                case "btn_Delete":
                	var isDelete=true;
                	for(var i = sheetObject.HeaderRows ; i <= sheetObject.LastRow() ; i++){
						if(sheetObject.GetCellValue(i, "chk") == 1 && sheetObject.GetCellValue(i, "sts_cd") == "VL" && sheetObject.GetCellValue(i, "pre_sts_cd") == "N"){
							ComShowCodeMessage("BKG08041", sheetObject.GetCellValue(i, "cntr_no"));
                			isDelete=false;
                			break;
                		}
                	}
                	if(isDelete){
                    	ComRowHideDelete(sheetObject,"chk");
                    	setEmptyContainerQty("B");                		 
                	}

                    break;
 		        case "btn_Mty":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		var vvd=ComGetObjValue(formObject.bkg_trunk_vvd);
 		        		var ydCd=ComGetObjValue(formObject.org_yd_cd);
 		        		ComOpenPopup("ESM_BKG_9455.do?pgmNo=ESM_BKG_9455&vvd="+vvd+"&yd_cd="+ydCd, 450, 470, "callBack9455","0,1,1,1,1", true);	
		        	}else{ 		        		
		        		ComShowCodeMessage("BKG00448");
		        	}
                     break;
 		        case "btn_auto":
                    break;
 		        case "btn_Bundle":
 		        	setBundle();
                    break;
 		        case "btn_Rmk":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		ComOpenPopup("ESM_BKG_0913.do?pgmNo=ESM_BKG_0913&screen_id=9424", 500, 345, "callBack0913","0,1,1,1,1", true);	
		        	}else{ 		        		
 		        		ComShowCodeMessage("BKG00448");
 		        	}
                    break;
                /** Right Group **/
                case "btn_Move":
                	if(sheetObject3.CheckedRows("chk") < 1){
                		ComShowCodeMessage("BKG00155");
                	}else{                		 
                		ComOpenWait(true);
                		for(var i=sheetObject3.HeaderRows(); i <= sheetObject3.LastRow() ; i++){
							if(sheetObject3.GetCellValue(i, "chk") == 1){
                				// Repo Container가 없는 경우에만 새로 추가한다.
								var findRow=sheetObject.FindText("full_cntr_no",sheetObject3.GetCellValue(i, "full_cntr_no"));
                				if(findRow < 0){
                					var addRow=sheetObject.DataInsert(-1);
									sheetObject.SetCellValue(addRow, "cntr_no",sheetObject3.GetCellValue(i, "cntr_no"),0);
									sheetObject.SetCellValue(addRow, "cntr_no_pst",sheetObject3.GetCellValue(i, "cntr_no_pst"),0);
									sheetObject.SetCellValue(addRow, "tpsz_cd",sheetObject3.GetCellValue(i, "tpsz_cd"),0);
									sheetObject.SetCellValue(addRow, "sts_cd",sheetObject3.GetCellValue(i, "sts_cd"),0);
									sheetObject.SetCellValue(addRow, "full_cntr_no",sheetObject3.GetCellValue(i, "full_cntr_no"),0);
                					if("S"==ComGetObjValue(formObject.mvmt_option)){
                						sheetObject.SetCellValue(addRow, "pre_sts_flg","Y",0);
                					} else {
										sheetObject.SetCellValue(addRow, "pre_sts_flg",sheetObject3.GetCellValue(i, "pre_sts_flg"),0);
                					}
            				 	}else{
									if(sheetObject.GetRowStatus(findRow) == "D"){
            				 			sheetObject.SetRowHidden(findRow,0);
                	                    sheetObject.SetRowStatus(findRow,"R");
                					}
                				}
                			}
                		}                		
                		setEmptyContainerQty("B"); 
                		ComOpenWait(false);
                	}
                    break;
				case "btn_CheckAll":
 		        	sheetObjects[2].CheckAll("chk",2);
                    break;
 		        case "btn_Retrive":
 		        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
 		        		doActionIBSheet(sheetObjects[2], formObject, SEARCHLIST12);  
 		        	}else{
 		        		ComShowCodeMessage("BKG00448");
 		        	}
                    break;
				case "btn_splitPop":			
					doActionIBSheet(sheetObjects[4],formObject,COMMAND03);					
					break;      
				case "btn_CheckOut":				
					if(ComGetObjValue(formObject.bkg_no) == ""){
						ComShowCodeMessage("BKG00255");
 		        		return false;
 		        	}
					
					if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
						ComShowCodeMessage("BKG00448");
 		        		return false;
 		        	}
					
					if(sheetObject.RowCount() <= 0) { 
						return false;
					}					
					doActionIBSheet(sheetObject, formObject, MULTI03);					
					break;
				case "btn_CheckIn":
					if(ComGetObjValue(formObject.bkg_no) == ""){
						ComShowCodeMessage("BKG00255");
 		        		return false;
 		        	}
					
					if(ComGetObjValue(formObject.bkg_trunk_vvd) == ""){
						ComShowCodeMessage("BKG00448");
 		        		return false;
 		        	}
					
					if(sheetObject.RowCount() <= 0) { 
						return false;
					}					
					doActionIBSheet(sheetObject, formObject, MULTI04);					
					break;
     		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
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
        ComSetFocus(document.form.bkg_no);	
        
        if(document.form.login_id.value == "CLTML001") {
        	document.form.btn_CheckOut.style.display = "inline";
        	document.form.btn_CheckIn.style.display = "inline";
        }else{
        	document.form.btn_CheckOut.style.display = "none";
        	document.form.btn_CheckIn.style.display = "none";
        }
        
        if(!ComIsNull(document.form.bkg_no)){
        	var strBkgNo = "";
        	strBkgNo = document.form.bkg_no.value;
        	strBkgNoLast = strBkgNo.substring(strBkgNo.length,strBkgNo.length -2)
        	
        	if(strBkgNoLast == "00"){
        		ComSetObjValue(document.form.bkg_mvmt_cd, "VL");
        	} else {
        		ComSetObjValue(document.form.bkg_mvmt_cd, "VD");        		
        	}
//    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);       			
    	} 
        
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    
    
    
    
	function initControl() {
	   	var formObject=document.form;
	   	axon_event.addListenerFormat('keypress','bkg9424_keypress',formObject); //- 키보드 입력할때
	   	axon_event.addListenerForm('click', 'bkg9424_click',    formObject); //- 클릭시
	   	axon_event.addListenerFormat('blur', 'bkg9424_blur', formObject); // - out focus
	}      
	
	
	
	
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      //t1sheet1 init
        		with(sheetObj){
        
        		var HeadTitle="|Chk|Seq.|Container No.|TP/SZ|STS|BD & B||HRT|HBT|HBQ";
        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
				{Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"full_cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bdl_no",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bdl_btm_flg" },
				{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mnr_hngr_bar_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pre_sts_flg" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no_pst" } ];
				         
        		InitColumns(cols);

		        SetEditable(1);
		        SetCountPosition(0);
		        //SetSheetHeight(382);
		        resizeSheet();
		        SetColProperty(0 ,"full_cntr_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		        //InitDataValid(0,  "full_cntr_no",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
		        sheetObjects[0].ToolTipOption="balloon:true;width:250;backcolor:#FFFFFF;forecolor:#000000;icon:1";
		        sheetObjects[0].SetToolTipText(0,6,"Bundle & Bottom");
		        sheetObjects[0].SetToolTipText(0,7,"Bundle & Bottom");
        	}
                break;
            case 2:      //t1sheet1 init
                with(sheetObj){
            	var HeadTitle="|TP/SZ|B.QTY|R.QTY|R.QTY|hngr_r_qty";

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"b_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:67,   Align:"Center",  ColMerge:0,   SaveName:"r_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:0,   SaveName:"show_r_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:67,   Align:"Center",  ColMerge:0,   SaveName:"hngr_r_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            	InitColumns(cols);
            	//SetSheetHeight(382);
            	resizeSheet();
            	SetEditable(1);
            	SetCountPosition(0);
                    //no support[implemented common]CLT ScrollBars=2;
            }
                break;
            case 3:      //sheet3 init
                with(sheetObj){
                SetSheetHeight(382);
                var HeadTitle="|Seq.|Chk|Container No.|Container No.|TP/SZ|STS|EDI POD";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no_pst",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"full_cntr_no" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pre_sts_flg" } ];
               
                InitColumns(cols);
                SetEditable(1);
                SetCountPosition(0);
                //SetSheetHeight(382);
                resizeSheet();
                    //no support[implemented common]CLT ScrollBars=2;
            }
                break;
            case 4:      //sheet4 init
                with(sheetObj){
            	var HeadTitle="|TP/SZ|QTY";

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:47,   Align:"Center",  ColMerge:0,   SaveName:"qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            	InitColumns(cols);

            	SetEditable(1);
            	SetCountPosition(0);
            	//SetSheetHeight(382);
            	resizeSheet();
            	//sheetObj.ShowSubSum([{StdCol:1, SumCols:"qty", Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"total"}]);
                    //no support[implemented common]CLT ScrollBars=2;
              }
                break;
	        case 5:
	            with(sheetObj){
	            
	        	var HeadTitle1="|TP/SZ|VOL";
	        	var headCount=ComCountHeadTitle(HeadTitle1);

	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	           
	        	InitColumns(cols);

	        	SetEditable(1);
	        	SetVisible(false);
	        	SetCountPosition(0);//Total없음.
	        }
	        	break;  	   
	    case 6:      //sheet for excel load/down
	        with(sheetObj){
	        var HeadTitle="|Chk|Seq.|Container No.|TP/SZ|STS|BD & B||HRT|HBT|HBQ";

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"full_cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bdl_no",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:13,   Align:"Center",  ColMerge:0,   SaveName:"bdl_btm_flg" },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mnr_hngr_bar_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_no" },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pre_sts_flg" } ];
	       
	        InitColumns(cols);
			//SetSheetHeight(382);
			SetVisible(false);
			SetEditable(1);
			SetCountPosition(0);
			SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	            //conversion of function[check again]CLT                 InitDataValid(0,  "cntr_no",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
			//no support[implemented common]CLT ScrollBars=2;
	      }
            break;
            
	    case 7:
            with(sheetObj){
            
        	var HeadTitle1="|TP/SZ|VOL";
        	var headCount=ComCountHeadTitle(HeadTitle1);

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
           
        	InitColumns(cols);

        	SetEditable(1);
        	SetVisible(false);
        	SetCountPosition(0);//Total없음.
        }
        	break;  	   
        }
	}
    
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction){
            case IBSEARCH:      //조회
            	ComSetObjValue(formObj.f_cmd, SEARCH);
            	ComOpenWait(true);
            	setTimeout( function () {
        		sheetObj.SetWaitImageVisible(1);
				var sXml=sheetObj.GetSearchData("ESM_BKG_9424GS.do", FormQueryString(formObj));
    			var arrXml=sXml.split("|$$|");  
				if (arrXml.length > 0){    				
					sheetObjects[0].SetWaitImageVisible(0);
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					sheetObjects[0].SetWaitImageVisible(1);
				} 
				
				if (arrXml.length > 1){    				
					sheetObjects[2].SetWaitImageVisible(0);
					sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
					sheetObjects[2].SetWaitImageVisible(1);
				}  
				
				if (arrXml.length > 2){    				
					sheetObjects[1].SetWaitImageVisible(0);
					sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
    				sheetObjects[1].SetWaitImageVisible(1);
    				
					sheetObjects[3].SetWaitImageVisible(0);
    				sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
    				sheetObjects[3].SetWaitImageVisible(1);
				}    
				
				if (arrXml.length > 3){    				
					sheetObjects[4].SetWaitImageVisible(0);
					sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
					sheetObjects[4].SetWaitImageVisible(1);
				}    				
				
    			BkgEtcDataXmlToForm(arrXml[0], formObj);		
				var splitFlg=ComGetEtcData(arrXml[0], "split_flg");
				if(splitFlg == "Y"){
					ComSetObjValue(formObj.split,"Split");
//	    			document.getElementById("bkg_pod_cd").className  = "noinput2";
				}else{
					ComSetObjValue(formObj.split,"");
//					if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VL"){
//		    			document.getElementById("bkg_pod_cd").className  = "input";
//					} else {
//		    			document.getElementById("bkg_pod_cd").className  = "noinput2";
//					}
				}
				oldPodCd=formObj.bkg_pod_cd.value;
				oldInterRmk=formObj.inter_rmk.value;
    			if(sheetObjects[0].RowCount()> 0){
    				setEmptyContainerQty("A");	
    			}else{
    				setEmptyQty();
    			}
    			setVlContainerQty();
            	
    			var saveDisable=false;
    			if(ComGetEtcData(arrXml[0], "SuccessYn") == "Y"){
        			// 1. VL 일때 Split Booking 인 경우 입력불가    			
        			// 2. VD 일때 원본 Booking 인 경우 입력불가
        			if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VL"){
        				if(ComGetObjValue(formObj.bkg_no).length ==13 || (ComGetObjValue(formObj.bkg_no).length ==12 && ComGetObjValue(formObj.bkg_no).substring(ComGetObjValue(formObj.bkg_no).length-2,ComGetObjValue(formObj.bkg_no).length) != "00")){
        					saveDisable=true;
        				}
        			}else if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VD"){
        				if (ComGetObjValue(formObj.bkg_no).length == 11 || (ComGetObjValue(formObj.bkg_no).length ==12 && ComGetObjValue(formObj.bkg_no).substring(ComGetObjValue(formObj.bkg_no).length-2,ComGetObjValue(formObj.bkg_no).length) == "00")){
        					saveDisable=true;
        				}
        			}
        			if(saveDisable){
        				disableSaveButton();
        			}else{
        				enableSaveButton();
        			}        			
    			}else{
    				disableSaveButton();   				
    			}
    			// Cancel된 경우 Save,Cancel버튼 Disable    			
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){
    				disableSaveButton();  			
    			}
    			// Container가 존재하면 Cancel 할 수 없다.
    			if(sheetObj.RowCount()> 0){
    				ComBtnDisable("btn_BtmCancel");
    			}
    			if(ComIsNull(formObj.inter_rmk)){
    				//ComBtnColor("btn_Rmk","#737373");
    				document.getElementById("btn_Rmk").style.cssText = "background-color:#27415d !important;";
    			}else{
    				//ComBtnColor("btn_Rmk","blue");		
    				document.getElementById("btn_Rmk").style.cssText = "background-color:blue !important;";
    			}   	    			
    			sheetObjects[0].CheckAll("chk",0);
    			sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(),"tpsz_cd",'Total',0);
    			ComOpenWait(false);
			    } , 100);
            	           	
                break;
            case SEARCHLIST12:        // Stowage Plan 조회
            	// vd일 때 mty cntr, stwg cntr 조회 없음
            	if(ComGetObjValue(formObj.bkg_mvmt_cd) == "VD"){
            		break;
            	}
				ComSetObjValue(formObj.f_cmd, SEARCHLIST12);
				sheetObj.DoSearch("ESM_BKG_9424GS.do?mvmt_option="+ComGetObjValue(formObj.mvmt_option),FormQueryString(formObj) );
				setVlContainerQty();				
				break;
            case MULTI02:        // Cancel
              	ComSetObjValue(formObj.f_cmd, MULTI02);              
              	var sXml=sheetObj.GetSaveData("ESM_BKG_9424GS.do", FormQueryString(formObj));
              	sheetObj.LoadSearchData(sXml,{Sync:1} );
              	if(ComGetEtcData(sXml, "SuccessYn") == "Y"){              		
              		ComShowCodeMessage("BKG00590");
              		doActionIBSheet(sheetObj, formObj, IBSEARCH);
              	}				
				break;
            case IBSAVE:        //저장
            	ComSetObjValue(formObj.f_cmd, MULTI01);
        		
        		ComOpenWait(true);
            	// 기존 one transaction 방식

	        	var params="";	
	        	sheetObj.SetWaitImageVisible(false);
	    		var isSave=false;
            	//단건 호출  방식
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
	        		//모든 row의 색 초기화
					sheetObj.SetCellFontColor(i, "full_cntr_no","#000000");
	        	}       		
            
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
            		sheetObj.SelectCell(i,"full_cntr_no");
            		params=FormQueryString(formObj);
               		// 첫번째 호출시 pod가 바뀌어있으면 호출
            		if("R"==sheetObj.GetRowStatus(i)){
	            		//수정된 것이 없으면 skip
            			sheetObj.SetCellFontColor(i, "cntr_no","#0000FF");
            		} else {
						params=params  + "&sheet1_" + "ibflag=" 		+ sheetObj.GetRowStatus(i)
						+ "&sheet1_" + "chk=" 			+ sheetObj.GetCellValue(i, "chk")
						+ "&sheet1_" + "seq="			+ sheetObj.GetCellValue(i, "seq")
						+ "&sheet1_" + "cntr_no="		+ sheetObj.GetCellValue(i, "cntr_no")
						+ "&sheet1_" + "cntr_no_pst="	+ sheetObj.GetCellValue(i, "cntr_no_pst")
						+ "&sheet1_" + "tpsz_cd="		+ sheetObj.GetCellValue(i, "tpsz_cd")
						+ "&sheet1_" + "sts_cd="		+ sheetObj.GetCellValue(i, "sts_cd")
						+ "&sheet1_" + "bdl_no="		+ sheetObj.GetCellValue(i, "bdl_no")
						+ "&sheet1_" + "bdl_btm_flg="	+ sheetObj.GetCellValue(i, "bdl_btm_flg")
						+ "&sheet1_" + "full_cntr_no="	+ sheetObj.GetCellValue(i, "full_cntr_no")
						+ "&sheet1_" + "pre_sts_flg=" 	+ sheetObj.GetCellValue(i, "pre_sts_flg");
	//	            	params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");	
						var sXml=sheetObj.GetSaveData("ESM_BKG_9424GS.do", params);
		            	if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
	            			//error이면 바로 중지
	            			ComOpenWait(false);
	            			sheet7.LoadSearchData(sXml,{Sync:1} );
	            			return false;
		            	} else {
		            		//저장 성공된 cntr는 파란색 표시, STATUS "R"로 변경(재 저장 하지 않음)
		            		sheetObj.SetCellFontColor(i, "full_cntr_no","#0000FF");
		            		sheetObj.SetRowStatus(i,"R");
		            		isSave=true;
		            	}
            		}
            	}            	
            	//cntr는 없고 pod만 바뀐 경우
            	if(isSave == false && (oldPodCd != formObj.bkg_pod_cd.value || oldInterRmk != formObj.inter_rmk.value)){
            		params=FormQueryString(formObj);
            		var sXml=sheetObj.GetSaveData("ESM_BKG_9424GS.do", params);
	            	if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
            			//error이면 바로 중지
            			ComOpenWait(false);
            			sheet7.LoadSearchData(sXml,{Sync:1} );
            			return false;
	            	} else {
	            		//저장 성공된 cntr는 파란색 표시, STATUS "R"로 변경(재 저장 하지 않음)
	            		sheetObj.SetCellFontColor(i, "full_cntr_no","#0000FF");
	            		sheetObj.SetRowStatus(i,"R");
	            	}
            	}
            	//전부 성공시에만 재조회
            	ComOpenWait(false);
        		var extraMsg=false;
        		for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++){
					if(sheetObjects[0].GetCellValue(i, "ibflag") == "I" || sheetObjects[0].GetCellValue(i, "ibflag") == "U"){
						if(sheetObjects[0].GetCellValue(i, "sts_cd") != "VL"){
        					extraMsg=true;
        					break;
        				}
        			}
        		}
        		if(extraMsg){
	    			ComShowCodeMessage("BKG02026");
	    		}else{
	    			ComBkgSaveCompleted();
	    		}
        		doActionIBSheet(sheetObj, formObj, IBSEARCH);
               	break;
			case COMMAND03:      //booking split no조회 
				if(!ComIsNull(formObj.bkg_no)){
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
				 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
				 	bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,15,145);         						
				}
				break;  
			case MULTI03:        // Check Out
				var sheetObject=sheetObjects[0];
				ComSetObjValue(formObj.f_cmd, MULTI03);
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
               		// 첫번째 호출시 pod가 바뀌어있으면 호출
					sheetObjects[0].SetRowStatus(i,"U");
            	}       	
				var params=sheetObjects[0].GetSaveString();
              	var sparam="";	
				sparam=FormQueryString(formObj) + "&" + params;
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_9424GS.do", sparam);
              	if(ComGetEtcData(sXml, "SuccessYn") == "Y"){              		
	          		ComShowCodeMessage("BKG08069");
	          	}	
          	
				ComOpenWait(false);
				break;
			case MULTI04:        // Check In
				var sheetObject=sheetObjects[0];
				ComSetObjValue(formObj.f_cmd, MULTI04);
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
               		// 첫번째 호출시 pod가 바뀌어있으면 호출
					sheetObjects[0].SetRowStatus(i,"U");
            	}       	
				var params=sheetObjects[0].GetSaveString();
              	var sparam="";	
              	sparam=FormQueryString(formObj) + "&" + params;
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_9424GS.do", sparam);
              	if(ComGetEtcData(sXml, "SuccessYn") == "Y"){              		
	          		ComShowCodeMessage("BKG08069");
	          	}	
          	
				ComOpenWait(false);
				break;
        }        
    }
    
    
    
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:      // Save    		
				if(ComGetObjValue(formObj.bkg_trunk_vvd) == ""){		// 조회없이 저장시
					ComShowCodeMessage("BKG00448");
					return false;
				}
		  		//pod 변경시
		  		if(ComIsNull(formObj.bkg_pod_cd) || formObj.bkg_pod_cd.value.length != 5){
					ComShowCodeMessage("BKG02061");
		  			return false;		  			
		  		}		  		
		  		if(oldPodCd != formObj.bkg_pod_cd.value && formObj.bkg_pod_cd.value != "XXXXX"){
					ComShowCodeMessage("BKG02061");
			  		return false;
		  		}
		  		// Save할 대상이 없는 경우
		  		if(sheetObj.RowCount()< 1
		  				&& (oldPodCd == formObj.bkg_pod_cd.value|| oldInterRmk == formObj.inter_rmk.value)){
					ComShowCodeMessage("BKG00155");
					return false;    	  			
		  		}		  		
		  		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
		  			if(sheetObj.GetRowStatus(i) != "D"){
		  				var stsCd=sheetObj.GetCellValue(i, "sts_cd");
		    	  		// Cntr Sts가 'MT','VL','ID'가 아니면 에러.
		  				// 20091111 현업요청으로 Validation 제거
//		  				if(stsCd != "MT" && stsCd != "VL" && stsCd != "ID"){
//		  					ComShowCodeMessage("BKG00951", sheetObj.CellValue(i, "cntr_no"), stsCd);
//		  					return false;    	  					
//		  				}
		    	  		// Bundle 필수 TP/SZ 여부 확인.
		  				var cntrTpsz=sheetObj.GetCellValue(i, "tpsz_cd");
		  				if(sheetObj.GetCellValue(i, "bdl_no") == ""){
		  					if(cntrTpsz == "F2" || cntrTpsz == "F4" || cntrTpsz == "F5" || cntrTpsz == "A2" || cntrTpsz == "A4"){
		  						ComShowCodeMessage("BKG00822");
			  					return false;
			  				}
			  			}
			  		}
			  	}
		  		// 20091217 추가 - Bundle에 Bottom Indicator가 없으면 에러.
		  		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
		  			var btmFlg=true;
		  			var bdlNo=sheetObj.GetCellValue(i, "bdl_no");
		  			if(bdlNo != "" && sheetObj.GetCellValue(i, "bdl_btm_flg") == 0){
		  				for(var k=sheetObj.HeaderRows(); k <= sheetObj.LastRow() ; k++){
		  					if(sheetObj.GetCellValue(k, "bdl_no") == bdlNo && sheetObj.GetCellValue(k, "bdl_btm_flg") == 1){
		  						btmFlg=false;
		  						break;
		  					}
		  				}
			  			if(btmFlg){
	  						ComShowCodeMessage("BKG00822");
	  						return false;		  				
			  			}		  				
		  			}
		  		}
				return true;        		
				break;	 		
		}      
    }
    
    
    
    function bkg9424_keypress(){
    	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var srcName=ComGetEvent("name");
    	var srcValue=event.srcElement.getAttribute("value");
    	if(srcName == "bkg_no" || srcName == "bl_no"){
    		if(event.keyCode == 13){
    			ComKeyEnter();
    		}
    	}
    	switch(event.srcElement.dataformat) {
    		case "ymdhm":
    			ComKeyOnlyNumber(event.srcElement);
	            if (srcValue.length == 8) {
	              document.form.elements[srcName].value=srcValue.substring(0,10) + " "
	            }
	            if (srcValue.length == 11) {
	            	document.form.elements[srcName].value=srcValue.substring(0,13) + ":"
	            }
	            break;
    		default:     //영문 + 숫자
    			ComKeyOnlyAlphabet('uppernum'); break;
    	}
	}  
    
    
    
  	function bkg9424_click(){
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcValue=event.srcElement.getAttribute("value");
    	if(srcName == "bkg_mvmt_cd"){
    		var bkgMvmtCd=ComGetObjValue(formObject.bkg_mvmt_cd);
    		ComResetAll();
    		ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
    		disableSaveButton();     		
//    		if(srcValue == "VL"){
//    			if(formObject.split_flg.value == "Y"){
//    				document.getElementById("bkg_pod_cd").className  = "input";
//    			} else {
//        			document.getElementById("bkg_pod_cd").className  = "noinput2";
//    			}
//    		} else {
//    			document.getElementById("bkg_pod_cd").className  = "noinput2";
//    		}
    	}else if(srcName == "mvmt_option"){
        	if(srcValue == "V"){
        		sheetObjects[2].SetCellValue(0,"pod_cd","EDI POD");
        	}else{
        		sheetObjects[2].SetCellValue(0,"pod_cd","POD");
        	}    		
        	if(ComGetObjValue(formObject.bkg_trunk_vvd) != ""){
	        	doActionIBSheet(sheetObjects[2], formObject, SEARCHLIST12);  
	        }else{
	        	ComShowCodeMessage("BKG00448");
	        }    		
    	}
	}      
  	
  	
  	function bkg9424_blur(){  		
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var obj=event.srcElement;
    	var srcValue=event.srcElement.getAttribute("value");
    	
		var sheetObject=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
	    	if(srcName == "bkg_no"){
	    		var bkgNo=ComGetObjValue(formObject.bkg_no);
	    		var blNo=ComGetObjValue(formObject.bl_no);
	    		var bkgMvmtCd=ComGetObjValue(formObject.bkg_mvmt_cd);
	    		ComResetAll();
				ComSetObjValue(formObject.bkg_no,bkgNo);
				ComSetObjValue(formObject.bkg_mvmt_cd, bkgMvmtCd);
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
	    	}
		}
	}      
  	
  	
  	
  	// Save관련버튼 Disable
  	function disableSaveButton(){
        if(document.form.login_id.value == "CLTML001") {
    		ComBtnEnable("btn_Add");
    		ComBtnEnable("btn_Delete");
    		ComBtnEnable("btn_Move");
    		ComBtnEnable("btn_Rmk");
    		ComBtnEnable("btn_BtmSave");
    		ComBtnEnable("btn_BtmCancel");        	
        } else {
    		ComBtnDisable("btn_Add");
    		ComBtnDisable("btn_Delete");
    		ComBtnDisable("btn_Move");
    		ComBtnDisable("btn_Rmk");
    		ComBtnDisable("btn_BtmSave");    
    		ComBtnDisable("btn_BtmCancel");		
        }  
  	}
  	
  	
  	
  	// Save관련버튼 Enable
  	function enableSaveButton(){
		ComBtnEnable("btn_Add");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Move");
		ComBtnEnable("btn_Rmk");
		ComBtnEnable("btn_BtmSave");
		ComBtnEnable("btn_BtmCancel");
  	}
  	
  	
  	
	// Container번호로 Repo 정보 조회
	function searchRepoByCntr(sheetObj, formObject, Row, cntrNo){
		ComSetObjValue(formObject.f_cmd, SEARCHLIST11);
		var sXml=sheetObj.GetSearchData("ESM_BKG_9424GS.do?cntr_no="+cntrNo, FormQueryString(formObject));
		sheetObj.SetCellValue(Row, "cntr_no_pst",ComGetEtcData(sXml,"chk_digit"),0);
		sheetObj.SetCellValue(Row, "tpsz_cd",ComGetEtcData(sXml,"cntr_tpsz_cd"),0);
		sheetObj.SetCellValue(Row, "sts_cd",ComGetEtcData(sXml,"cnmv_sts_cd"),0);
		sheetObj.SetCellValue(Row, "pre_sts_flg",ComGetEtcData(sXml,"pre_sts_flg"),0);
		sheetObj.SetCellValue(Row, "cntr_no",cntrNo.substring(0, 10),0);
		var idxTpsz=sheetObjects[1].FindText("tpsz_cd", ComGetEtcData(sXml,"cntr_tpsz_cd"));
		if(idxTpsz >= 0){
			sheetObjects[1].SetCellValue(idxTpsz, "r_qty",BkgParseInt(sheetObjects[1].GetCellValue(idxTpsz, "r_qty")) + 1);
		}		
		setEmptyContainerQty("B");
	}
	
	
	
	// 조회완료 후 Empty Container Qty 계산
	function setEmptyContainerQty(type){
		var arrCntrTpSz=new Array();
		var arrCntrVol=new Array();
		var arrHngrCntrVol=new Array();
		var cntrTpSzCnt=sheetObjects[1].RowCount()+1;// - 1;
		
		for(var i=1 ; i < cntrTpSzCnt; i++){			
			arrCntrTpSz[i]=sheetObjects[1].GetCellValue(i, "tpsz_cd")
			arrCntrVol[i]=0;
			arrHngrCntrVol[i]=0;
		}				   
		var cntrTpSz="";
		var cntrHngrRckCd="";
		for(var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
			if(sheetObjects[0].GetRowStatus(i) != "D"){
				cntrTpSz=sheetObjects[0].GetCellValue(i, "tpsz_cd");
				cntrHngrRckCd=sheetObjects[0].GetCellValue(i, "cntr_hngr_rck_cd");
				if(cntrTpSz == ""){
					break;
				}
				for(var j=1 ; j < cntrTpSzCnt - 1; j++){	
					if(cntrTpSz==arrCntrTpSz[j]){
						arrCntrVol[j]++;
						if(cntrHngrRckCd != ''){
							arrHngrCntrVol[j]++;
						}
					}
				}
			}
		}	 
		for(var i=1 ; i < cntrTpSzCnt ; i++){
			if(type == "A"){
				sheetObjects[1].SetCellValue(i, "b_qty",arrCntrVol[i]);
			}
			sheetObjects[1].SetCellValue(i, "r_qty",arrCntrVol[i]);
			sheetObjects[1].SetCellValue(i, "hngr_r_qty",arrHngrCntrVol[i]);
			if(arrHngrCntrVol[i] > 0){
				sheetObjects[1].SetCellValue(i, "show_r_qty",arrCntrVol[i] + "(" + arrHngrCntrVol[i] + ")");
			} else {
				sheetObjects[1].SetCellValue(i, "show_r_qty",arrCntrVol[i]);
			}			
		}
	   
		setEmptyContainerColor();
   	}
	
	
	
	// 조회완료 후 Empty Container정보가 없을시 Booking Qty를 B.QTY에 보여준다.(20091016 추가)
   	function setEmptyQty(){
   		for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow() ; i++){
			sheetObjects[1].SetCellValue(i, "b_qty","");
		}	
   		for(var i=sheetObjects[4].HeaderRows(); i <= sheetObjects[4].LastRow() ; i++){
		var cntrTpsz=sheetObjects[4].GetCellValue(i, "cntr_tpsz_cd");
		var bQty=sheetObjects[4].GetCellValue(i, "op_cntr_qty");
			var idxTpsz=sheetObjects[1].FindText("tpsz_cd", cntrTpsz);
			if(idxTpsz >= 0){
				sheetObjects[1].SetCellValue(idxTpsz, "b_qty",bQty);
			}
		}	   
		setEmptyContainerColor();
	}   
   	
   	
   	// Empty Container Qty 계산 후 Color 재조정.
   	function setEmptyContainerColor(){	   
   		for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow() ; i++){
   			if(sheetObjects[1].GetCellValue(i, "b_qty") != sheetObjects[1].GetCellValue(i, "r_qty")){
   				sheetObjects[1].SetCellBackColor(i,"show_r_qty","#00FF00");
			}else{
				sheetObjects[1].SetCellBackColor(i,"show_r_qty",-1);
			}
		}	   
	}   
   	
   	
	// 조회완료 후 VL Container Qty 계산   
	function setVlContainerQty(){
		var arrCntrTpSz=new Array();
		var arrCntrVol=new Array();
		var cntrTpSzCnt=sheetObjects[3].LastRow();
		for(var i=1 ; i <= cntrTpSzCnt ; i++){
			arrCntrTpSz[i]=sheetObjects[3].GetCellValue(i, "tpsz_cd");
			arrCntrVol[i]=0;
		}			
		var cntrTpSz="";
		for(var i=1 ; i <= sheetObjects[2].LastRow() ; i++){			
			cntrTpSz=sheetObjects[2].GetCellValue(i, "tpsz_cd");
			if(cntrTpSz == ""){
				break;
			}
			for(var j=1 ; j <= cntrTpSzCnt ; j++){				
				if(cntrTpSz==arrCntrTpSz[j]){
					arrCntrVol[j]++;
				}
			}
		}	 
		for(var i=1 ; i < cntrTpSzCnt ; i++){	
			sheetObjects[3].SetCellValue(i, "qty",arrCntrVol[i]);
		}
  	  
	}
	
	
	
	// Bundle Click시 처리
    function setBundle(){
		var sheetObj=sheetObjects[0];
		// 1개이상 선택해야함.
		if(sheetObj.CheckedRows("chk") < 1){
			ComShowCodeMessage("BKG00624");
			return;		   
		}
		var f2a2Cnt=0;
		var f4f5a4Cnt=0;
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
			if(sheetObj.GetCellValue(i, "chk") == 1){
				if(sheetObj.GetCellValue(i, "tpsz_cd") == "F2" || sheetObj.GetCellValue(i, "tpsz_cd") == "A2"){
					f2a2Cnt++;
				}
				if(sheetObj.GetCellValue(i, "tpsz_cd") == "F4" || sheetObj.GetCellValue(i, "tpsz_cd") == "F5" || sheetObj.GetCellValue(i, "tpsz_cd") == "A4"){
					f4f5a4Cnt++;
				}
			}
		}
		// type size 별로 선택갯수가 4, 7개를 넘으면 에러.
		if(f2a2Cnt > 7 || f4f5a4Cnt > 4){
			ComShowCodeMessage("BKG00821");
			return;
		}
		// F2+A2, F4+F5+A4 Bundle 가능.
		var bundle2=false;
		var bundle4=false;
		var isExist=false;
		var isNotBundle=false;
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
			if(sheetObj.GetCellValue(i, "chk") == 1){
				if(sheetObj.GetCellValue(i, "tpsz_cd") != "F2" && sheetObj.GetCellValue(i, "tpsz_cd") != "A2" && sheetObj.GetCellValue(i, "tpsz_cd") != "F4" && sheetObj.GetCellValue(i, "tpsz_cd") != "F5" && sheetObj.GetCellValue(i, "tpsz_cd") != "A4"){
					isNotBundle=true;
				}
				if(sheetObj.GetCellValue(i, "tpsz_cd") == "F2" || sheetObj.GetCellValue(i, "tpsz_cd") == "A2"){
					bundle2=true;
				}
				if(sheetObj.GetCellValue(i, "tpsz_cd") == "F4" || sheetObj.GetCellValue(i, "tpsz_cd") == "F5" || sheetObj.GetCellValue(i, "tpsz_cd") == "A4"){
					bundle4=true;				   
				}			   
				if(sheetObj.GetCellValue(i, "bdl_no") != ""){
					isExist=true;
					break;
				}
			}
		}
		
		if(isExist){
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
				if(sheetObj.GetCellValue(i, "chk") == 1){
					sheetObj.SetCellValue(i, "bdl_no","",0);
				}
			}
		}else{
			if(isNotBundle){
				ComShowCodeMessage("BKG00822");
				sheetObj.CheckAll("chk",0);
				return;
			}
			if(bundle2 && bundle4){
				ComShowCodeMessage("BKG02023");
				sheetObj.CheckAll("chk",0);
			   	return;			   
			}
			var maxBuldle=calculateMaxBundle();
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
				if(sheetObj.GetCellValue(i, "chk") == 1){
					sheetObj.SetCellValue(i, "bdl_no",BkgParseInt(maxBuldle)+1,0);;
				}
			}		   
		}
		sheetObj.CheckAll("chk",0);
    }
    
    
    
    // Max Bundle 계산
    function calculateMaxBundle(){
    	var maxBundle=0;
    	var sheetObj=sheetObjects[0];
    	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
    		if(sheetObj.GetCellValue(i, "bdl_no") != ""){
    			if(maxBundle < BkgParseInt(sheetObj.GetCellValue(i, "bdl_no"))){
    				maxBundle=sheetObj.GetCellValue(i, "bdl_no");
    			}
    		}
    	}	   
    	return maxBundle;
    }
   
	function sheet1_OnChange(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(sheetObj.GetSelectCol()) == "full_cntr_no"){
			var formObject=document.form;
			var selTpSz=sheetObjects[1].FindText("tpsz_cd", sheetObj.GetCellValue(Row, "tpsz_cd"));
			if(selTpSz >= 0){
				sheetObjects[1].SetCellValue(selTpSz, "r_qty",BkgParseInt(sheetObjects[1].GetCellValue(selTpSz, "r_qty")) - 1);
			}
			var cntrNo=sheetObj.GetCellValue(Row, "full_cntr_no");
			if(cntrNo.length == 11){
				searchRepoByCntr(sheetObj, formObject, Row, cntrNo);
			}else{
				sheetObj.SetCellValue(Row, "cntr_no_pst","",0);
				sheetObj.SetCellValue(Row, "tpsz_cd","",0);
				sheetObj.SetCellValue(Row, "sts_cd","",0);
				sheetObj.SetCellValue(Row, "cntr_no","",0);
			}
			setEmptyContainerQty("B");
			setEmptyContainerColor();					
		}
		var colName=sheetObj.ColSaveName(Col);
		// 같은 Buldle 중에 하나만 체크되도록 한다.
		if(colName == "bdl_btm_flg"){
			if(sheetObj.GetCellValue(Row, Col) == 1){
				var bdlNo=sheetObj.GetCellValue(Row, "bdl_no");
				if(bdlNo==null||bdlNo.length<1){
					sheetObj.SetCellValue(Row, "bdl_btm_flg",0,0);
					return;
				}
				var bdlFlg=false;
				for(var i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+1 ; i++){ 
					if(i != Row){
						if(sheetObj.GetCellValue(i, "bdl_no") == bdlNo && sheetObj.GetCellValue(i, "bdl_btm_flg") == 1){
							bdlFlg=true;
							break;
						}
					}
				}
				if(bdlFlg){
					sheetObj.SetCellValue(Row, "bdl_btm_flg",0,0);
					ComShowCodeMessage("BKG02036");
				}
			}
		}				
    }
	
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.SetWaitImageVisible(0);
		initControl();
		disableSaveButton();  
		if(ComGetObjValue(document.form.bkg_no) != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 
 		//iframe 생성 
		CofigIframe();   
	 	sheetObj.SetWaitImageVisible(1);
	}    
	
	
	
  /**
   * LoadExcel 이벤트 발생시 호출되는 function <br>
   * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
   * <br><b>Example :</b>
   * <pre>
   * 
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @return 없음
   * @author 김병규
   * @version 2009.09.29
   */ 
   function sheet1_OnLoadExcel(sheetObj){
	   var formObj=document.form;
	   // 역순으로 검색해서 기존값과 중복되어 있으면 지우고 T/S,STS등을 조회한다.  		
	   for(var i=sheetObj.LastRow() ; i >= sheetObj.HeaderRows(); i--){
		   totCntrNo=sheetObj.GetCellValue(i, "full_cntr_no");
		   if(totCntrNo.length < 11){
			   sheetObj.RowDelete(i, false);
		   }else{
			   cntrNo=totCntrNo;
			   idx=sheetObj.FindText("full_cntr_no", cntrNo);
			   // 검색한 결과가 자신이 아니라면 중복데이터 존재이므로 삭제.
			   if(idx > 0 && idx != i){
				   sheetObj.RowDelete(i, false);
			   }else{
				   if(sheetObj.GetCellValue(i ,"cntr_no") == ""){
					   sheetObj.SetCellValue(i, "full_cntr_no",cntrNo);
					   searchRepoByCntr(sheetObj, formObj, i, cntrNo);  						
				   }
			   }
		   }
	   }
	   setEmptyContainerQty("B");
   }
   
   
   
   /*
	* Sheet onMouseUP 호출
	*/
    function sheet1_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
    	var sRowStr=sheetObj.GetSelectionRows("/");
    	var arr=sRowStr.split("/");
    	if (Shift==1){
    		for (var i=0; i<arr.length; i++) {
    			if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(arr[i],"chk")=="0"){
    				sheetObj.SetCellValue(arr[i],"chk","1",0);
    			}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(arr[i],"chk")=="1"){
    				sheetObj.SetCellValue(arr[i],"chk","0",0);
    			}
    		}
    	}else{
/*		    if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"chk")=="0"){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"chk")=="1"){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","0",0);
		}
*/		
    	}	  
    }
    
    
    
	/*
	* Sheet onMouseUP 호출
	*/
	function sheet3_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
		var sRowStr=sheetObj.GetSelectionRows("/");
		var arr=sRowStr.split("/");
		if (Shift==1){
			for (var i=0; i<arr.length; i++) {
				if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(arr[i],"chk")=="0"){
					sheetObj.SetCellValue(arr[i],"chk","1",0);
				}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(arr[i],"chk")=="1"){
					sheetObj.SetCellValue(arr[i],"chk","0",0);
				}
			}
		}else{
/*		    if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"chk")=="0"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"chk")=="1"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","0",0);
			}
*/		
		}
	}      
	
	
	
   	/* 개발자 작업	*/
    /**
     * Container No Inquiry 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack9455(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.09.29
     */
	function callBack9455(rArray){    	
		var formObj=document.form;
    	if(rArray != null){
    		var sheetObject=sheetObjects[0];
    		for(var i=0 ; i < rArray.length ; i++){
    			// Repo Container가 없는 경우에만 새로 추가한다.
    			var findRow=sheetObject.FindText("full_cntr_no",rArray[i][3]);
    			if(findRow < 0){
    				var addRow=sheetObject.DataInsert(-1);
    				sheetObject.SetCellValue(addRow, "cntr_no",rArray[i][5]);
    				sheetObject.SetCellValue(addRow, "cntr_no_pst",rArray[i][6]);
    				sheetObject.SetCellValue(addRow, "tpsz_cd",rArray[i][4]);
    				sheetObject.SetCellValue(addRow, "sts_cd",rArray[i][7]);
    				sheetObject.SetCellValue(addRow, "full_cntr_no",rArray[i][3]);
    			}else{
    				if(sheetObject.GetRowStatus(findRow) == "D"){
    					sheetObject.SetRowHidden(findRow,0);
	                    sheetObject.SetRowStatus(findRow,"R");
    				}
				}    			
			}
    		setEmptyContainerQty("B");
    	}
	}     
    /**
    * Remark 에서 전달받은 값 저장 <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBack0913(rArray);
    * </pre>
    * @param Popup에서 전달받은 값
    * @return 없음
    * @author 김병규
    * @version 2009.09.29
    */
	function callBack0913(rReturn){    	
	   	var formObj=document.form;
	   	ComSetObjValue(formObj.inter_rmk, rReturn);
	   	
		if(ComIsNull(formObj.inter_rmk)){
			//ComBtnColor("btn_Rmk","#737373");
			document.getElementById("btn_Rmk").style.cssText = "background-color:#27415d !important;";
		}else{
			//ComBtnColor("btn_Rmk","#010266");			
			document.getElementById("btn_Rmk").style.cssText = "background-color:blue !important;";
		}   	
    }         

	function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    	ComResizeSheet(sheetObjects[1]);
    	ComResizeSheet(sheetObjects[2]);
    	ComResizeSheet(sheetObjects[3]);
    }
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		formObj.bl_no.readOnly=true;
		formObj.split.readOnly=true;
		ComOpenWait(false);
	}
	
	
	function chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal) {
		var arrVCode = "";
		var arrVCodeNm = "";
		if(vCode != "") {
			arrVCode = vCode.split("|");
			arrVCodeNm = vCodeNm.split("|");
			for(var j=0;j<arrVCode.length;j++) {
				if (toYdLoc.substring(0,2) != fmYdLoc.substring(0,2)) {
					if(toYdLoc.substring(0,2) == arrVCode[j]) {
						if(Number(volTotal) > Number(arrVCodeNm[j])) {
							ComShowCodeMessage("BKG08337",arrVCodeNm[j],arrVCode[j]);
							return false;
						}
					}					
				}
			}
		}
	}
	/* 개발자 작업  끝 */
