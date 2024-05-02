/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0036_6.js
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
* History --------------------------------------------------
* No. Date       Modifier  CSR No.        Content
* 1   2010.06.08 K.H.U                    Accout, Party 입력자리수 변경, (3,3)-->(6,12)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */
    /**
     * @extends 
     * @class vop_opf_0036 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
var sheetObjects	= new Array();
var sheetCnt		= 0;
var beforeLoadVolTab= 0;
var parentTabIdx	= 5;
var enableButton	= new Array(
								"btn_t6Import", 
								"btn_t6RowAdd",
								"btn_t6RowInsert",
								"btn_t6RowCopy",
								"btn_t6Delete",
								"btn_t6DownTemplete"
							);
var mBtnDis			= "N";

var mPartyCombo		= "";
var mPartyCode;
var mPartyName;


	document.onclick=processButtonClick;
   	/* 개발자 작업	*/
    function processButtonClick(){
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_t6Import":
						var sheetObj=t6sheet1;
						sheetObj.RemoveAll();
						sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"2"});
						break;
				case "btn_t6RowAdd":
						var sheetObj=t6sheet1;
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;
				case "btn_t6RowInsert":
						var sheetObj=t6sheet1;
						var Row=sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;
				case "btn_t6RowCopy":
						var sheetObj=t6sheet1;
						var Row=sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;
				case "btn_t6Delete":
						var sheetObj=t6sheet1;
						var prefixDel="t6sheet1_del_chk";
						ComRowHideDelete(sheetObj, prefixDel);
						break;
				case "btn_t6DownTemplete":
						var sheetObj=t6sheet1;
						var prefix="t6sheet1_";
						var arrMustCol="cntr_no|opr_cd|precell|position|shift_rsn|account|party".split("|");
//						sheetObj.RenderSheet(0);
//						for(var idx=0; idx < arrMustCol.length; idx++){
//							sheetObj.SetCellValue(0, prefix + arrMustCol[idx],"* " + sheetObj.GetCellValue(0, prefix + arrMustCol[idx]));
//						}
						var params = {SheetDesign:1,DownCols:'3|4|5|6|7|8|9|10|11|12',ReportXMLURL:"/opuscntr/apps/opus/vop/opf/cargoloadingresultmgt/terminaldeparturereport/jsp/VOP_OPF_0036.xml" };
						sheetObj.Down2Excel(params);
// 						sheetObj.DirectDown2Excel({ URL:"apps/opus/vop/opf/cargoloadingresultmgt/terminaldeparturereport/jsp/VOP_OPF_0036.xml"});					    
//						for(var idx=0; idx < arrMustCol.length; idx++){
//							sheetObj.SetCellValue(0, prefix + arrMustCol[idx],sheetObj.GetCellValue(0, prefix + arrMustCol[idx]).substring(2));
//						}
//						sheetObj.RenderSheet(1);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(btnDis) {
    	
		mBtnDis=btnDis;
		
		//Disable Button;
		// IBMultiCombo초기화
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		if(parent.bRetrive){
			parent.doActionIBSheet(parentTabIdx, parent.document.form, IBSEARCH);
			parent.setTabEditSheet();
		}
		initControl();
		parent.frameButtonSheet(parent.document.t6frame, parent.readonlStatus());
		parent.topSync();
		parent.iframeResize(true);
		
		var sXml	= sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH15 );
		
		mPartyCombo	= ComXml2ComboString(sXml, "inter_cd_ctnt", "inter_cd_ctnt");
		mPartyCode	= ComOpfXml2Array(sXml, "inter_cd_ctnt");
		mPartyName	= ComOpfXml2Array(sXml, "xter_cd_ctnt");
    }
	function initControl(){
		axon_event.addListener('blur', 't6sheet1_onblur', 't6sheet1', '');	
	}
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var mustInput=(mBtnDis == "Y" ? true : false); 
		with (sheetObj) {
            var HeadTitle1="";
            if(mBtnDis == "Y"){
            	HeadTitle1="|Seq.|Sel.|Container No.|Type/Size|POL|POD|Operator|From Position|To Position|Reason|Account|Responsible Party|check_row";
            }else{
            	HeadTitle1="|Seq.|Container No.|Type/Size|POL|POD|Operator|From Position|To Position|Reason|Account|Responsible Party|check_row";
            }
            var headCount=ComCountHeadTitle(HeadTitle1);
            var prefix="t6sheet1_";

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                         {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" } ];
        	if(mBtnDis == "Y"){
        		cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
        	}
            cols.push({Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            cols.push({Type:"Combo", 	 Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sztp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, InputCaseSensitive:1 });
            cols.push({Type:"Combo", 	 Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 });
            cols.push({Type:"Combo", 	 Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 });
            cols.push({Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
            
            //:2016-11-22://cols.push({Type:"Int",       Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"precell",   KeyField:1,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
            //:2016-11-22://cols.push({Type:"Int",       Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"position",  KeyField:1,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
            
            cols.push({Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"precell",   KeyField:1,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" });
            cols.push({Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"position",  KeyField:1,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" });
            
            cols.push({Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"shift_rsn", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
            cols.push({Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"account",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1});
            cols.push({Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"party",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, InputCaseSensitive:1 });
            cols.push({Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"check_row", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });

            InitColumns(cols);
            SetEditable((mBtnDis=="Y"?1:0));
            SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});   
            SetColProperty(0 ,prefix+"shift_rsn", {AcceptKeys:"E", InputCaseSensitive:1}); 
            //SetColProperty(0 ,prefix+"party", {AcceptKeys:"E", InputCaseSensitive:1});
//            SetColProperty(prefix+"sztp", {ComboText:parent.mSztpName, ComboCode:parent.mSztpCode} );
//            podComboInit();
            //ComboEdit 적용시 화살표안나옴
            /*SetColProperty(prefix+"sztp", {ComboText:parent.mSztpName, ComboCode:parent.mSztpCode} );
            SetColProperty(prefix+"pol", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );*/
            
            InitComboNoMatchText(1,"",1);
            
            SetSheetHeight(400);
		}
		podComboInit();
	}
	
	function podComboInit(){
		var prefix="t6sheet1_";
		parent.document.t6frame.t6sheet1.SetColProperty(prefix+"pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
	}
	
    function t6sheet1_OnClick(sheetObj, Row, Col, Val)
    {
//   	 with(sheetObj)
//   	 {
   		 var colname = sheetObj.ColSaveName(Col);
   		 switch(colname)
   		 {
   		 	case "t6sheet1_sztp":
   		 		if("ComboEdit" == sheetObj.GetCellProperty(Row, Col, "Type")){
   		 			return;
   	            }
   		 		sheetObj.InitCellProperty(Row, Col,{ Type:"ComboEdit",Align:"Center", ComboText:parent.mSztpName, ComboCode:parent.mSztpCode} );
    		break;
   		 	case "t6sheet1_pol":
   		 		if("ComboEdit" == sheetObj.GetCellProperty(Row, Col, "Type")){
   		 			return;
   	            }
   		 		sheetObj.InitCellProperty(Row, Col,{ Type:"ComboEdit",Align:"Center", ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
    		break; 
   		 	case "t6sheet1_party":
   		 		if("ComboEdit" == sheetObj.GetCellProperty(Row, Col, "Type")){
   		 			return;
   	            }
   		 		sheetObj.InitCellProperty(Row, Col,{ Type:"ComboEdit",Align:"Center", ComboText:mPartyCombo[0]+"|U|T", ComboCode:mPartyCombo[0]+"|U|T", InputCaseSensitive:1, AcceptKeys:"E"} );
    		break;    
    		
   		 	case "t6sheet1_account":
   		 		if("ComboEdit" == sheetObj.GetCellProperty(Row, "t6sheet1_party", "Type")){
   		 			return;
   	            }
   		 		sheetObj.InitCellProperty(Row, "t6sheet1_party",{ Type:"ComboEdit",Align:"Center", ComboText:mPartyCombo[0]+"|U|T", ComboCode:mPartyCombo[0]+"|U|T", InputCaseSensitive:1, AcceptKeys:"E"} );
    		break;     		
   		 }
//   	 }
    }
	
	function t6sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t6sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
		if(sheetObj.ColSaveName(Col) == "t6sheet1_account"){
			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "account", Row, Col);
			parent.mCheckValue=false;
		}
		if(sheetObj.ColSaveName(Col) == "t6sheet1_party"){
			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "party", Row, Col);
			parent.mCheckValue=false;
		}
		if(Col == sheetObj.SaveNameCol("t6sheet1_shift_rsn")){
//			ComOpenPopup('/opuscntr/VOP_OPF_0040POP.do?shift_rsn=' + sheetObj.GetCellValue(Row, "t6sheet1_shift_rsn"), 700, 530, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true, false);
//			var shift_rsn = sheetObj.GetCellValue(Row, "t6sheet1_shift_rsn");
//			parent.getCallBackRsn(sheetObj, Row, Col);
			parent.getCallBackRsn(sheetObj, "t6sheet1_shift_rsn", Row, Col);
//			ComOpenPopupWithTarget('/opuscntr/VOP_OPF_0040POP.do?shift_rsn=' + sheetObj.GetCellValue(Row, "t6sheet1_shift_rsn"), 700, 530, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
		}
	}
	
	function t6sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_opr_cd" && sheetObj.GetCellValue(OldRow, "t6sheet1_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_account" && sheetObj.GetCellValue(OldRow, "t6sheet1_account") != "" && parent.mCheckValue){
			//parent.checkOprCd(sheetObj, OldRow, OldCol);	//수정[1]
		}
		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_party" && sheetObj.GetCellValue(OldRow, "t6sheet1_party") != "" && parent.mCheckValue){
			//parent.checkOprCd(sheetObj, OldRow, OldCol);	//수정[1]
		}
		if(sheetObj.GetCellValue(OldRow, OldCol) != "" && sheetObj.ColSaveName(OldCol) == "t6sheet1_shift_rsn" && parent.mCheckValue){
			parent.checkShiftReason(sheetObj, OldRow, OldCol, sheetObj.GetCellValue(OldRow, OldCol));
		}
	}
	
	function t6sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t6sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "shift_rsn"){
			//|| sheetObj.ColSaveName(Col) == prefix + "account" || sheetObj.ColSaveName(Col) == prefix + "party"){	//수정[1]
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t6sheet1;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	
	function t6sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t6sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "account"){
			if( sheetObj.GetEditText().length == 3){
				var param = "";
				param += "f_cmd=" + SEARCH;
				param += "&crr_cd=" + sheetObj.GetEditText().toUpperCase();
				var sXml=sheetObj.GetSearchData("COM_ENS_0N1GS.do", param );
				var cnt = ComGetTotalRows(sXml);
				if(cnt == 0){
					ComShowCodeMessage("COM132201", "Data");
					sheetObj.SetCellValue(Row, prefix + "account", "", 0);
					sheetObj.SetCellValue(Row, prefix + "party", "", 0);
				}else{
					var param = "";
					param += "f_cmd=" + SEARCH15;
					param += "&crr_cd=" + sheetObj.GetEditText().toUpperCase();
			 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", param);
			 		var value=ComGetEtcData(sXml, "value");
			 		
			 		if(value == ''){
			 			value	= "Z";
			 		}
			 		sheetObj.SetCellValue(Row, prefix + "party", value, 0);
			 		
			 		var shift_rsn = sheetObj.GetCellValue(Row, prefix + "shift_rsn");
			 		if(shift_rsn.substring(0, 2) != ""){
			 			sheetObj.SetCellValue(Row, prefix + "shift_rsn", shift_rsn.substring(0, 2) + value, 0);	
			 		}
			 		
				}
			}			
		}

	}	
	
	function t6sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t6sheet1_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, prefix + "cntr_no");	//imdg_segr_grp_no Value Duplication Check
			parent.checkCntrNo(sheetObj, Row, Col)
		}
		
		if(sheetObj.ColSaveName(Col) == prefix + "pol" || sheetObj.ColSaveName(Col) == prefix + "pre_pod" || sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
		
		if(sheetObj.ColSaveName(Col) == prefix + "sztp"){
			parent.chkSzTpCombo(sheetObj, Row, Col, Value);
		}
		
		if(sheetObj.ColSaveName(Col) == prefix + "account"){
			
			if( Value.length != 3){
				if(Value.length != 0){
					ComShowCodeMessage("COM132201", "Data");	
				}
				sheetObj.SetCellValue(Row, prefix + "account", "", 0);
				sheetObj.SetCellValue(Row, prefix + "party", "", 0);
				sheetObj.SetCellValue(Row, prefix + "shift_rsn", sheetObj.GetCellValue(Row, prefix + "shift_rsn").substring(0, 2), 0);	
			}else{
				
				var param = "";
				param += "f_cmd=" + SEARCH15;
				param += "&crr_cd=" + Value;
				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", param);
				var party	= ComGetEtcData(sXml, "value");
	           
				if(party == ''){
	        	   party  = "Z";
				}
		           
		       sheetObj.SetCellValue(Row, prefix + "party", party, 0);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == prefix + "party"){
			
			if(Value == "Z"){
				//COM132201	: {?msg1} is invalid.
				ComShowCodeMessage("COM132201", sheetObj.GetCellText(0, prefix + "party"));
				sheetObj.SetCellValue(Row, prefix + "account", "", 0);
				sheetObj.SetCellValue(Row, prefix + "party", "", 0);
				var shift_rsn = sheetObj.GetCellValue(Row, prefix + "shift_rsn");
	 			sheetObj.SetCellValue(Row, prefix + "shift_rsn", sheetObj.GetCellValue(Row, prefix + "shift_rsn").substring(0, 2), 0);
				return false;
			}else if(Value == "T" || Value == "U"){
				sheetObj.SetCellValue(Row, prefix + "account", "", 0);
		 		var shift_rsn = sheetObj.GetCellValue(Row, prefix + "shift_rsn");
	 			sheetObj.SetCellValue(Row, prefix + "shift_rsn", sheetObj.GetCellValue(Row, prefix + "shift_rsn").substring(0, 2) + Value, 0);	
			}else{
				var idx = -1;
				for(var i in mPartyCode){
					if(checkExistArrayIndex(mPartyCode[i], Value) != -1){
						idx = i;
						break;
					}
				}
				if(idx == -1){
					ComShowCodeMessage("COM132201", sheetObj.GetCellText(0, prefix + "party"));
					sheetObj.SetCellValue(Row, prefix + "party", "", 0);
					return false;
				}else{
					var account = mPartyName[idx].toString();
					sheetObj.SetCellValue(Row, prefix + "account", account, 0);
					if(sheetObj.GetCellValue(Row, prefix + "shift_rsn").substring(0, 2) != ""){
						sheetObj.SetCellValue(Row, prefix + "shift_rsn", sheetObj.GetCellValue(Row, prefix + "shift_rsn").substring(0, 2) + Value, 0);	
					}
				}				
			}
		}
		
	}
	
	function t6sheet1_OnLoadExcel(sheetObj){
		var prefix="t6sheet1_";
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			sheetObj.SetCellValue(idxRow, prefix + "check_row","N");
			sheetObj.SetCellValue(idxRow, prefix + "cntr_no",sheetObj.GetCellValue(idxRow,  prefix + "cntr_no").toUpperCase(),0);
			sheetObj.SetCellValue(idxRow, prefix + "opr_cd",sheetObj.GetCellValue(idxRow,  prefix + "opr_cd").toUpperCase(),0);
			sheetObj.SetCellValue(idxRow, prefix + "shift_rsn",sheetObj.GetCellValue(idxRow,  prefix + "shift_rsn").toUpperCase(),0);
			sheetObj.SetCellValue(idxRow, prefix + "account",sheetObj.GetCellValue(idxRow,  prefix + "account").toUpperCase(),0);
			sheetObj.SetCellValue(idxRow, prefix + "party",sheetObj.GetCellValue(idxRow,  prefix + "party").toUpperCase(),0);
		}
	}
	
	function t6sheet1_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
	
	function updateSheetSize(sheetObj){
  	  if(typeof sheetObj == "undefined") {
  		  sheetObj = sheetObjects[0];
  	  }    	  
  	  var obj = $("#" + sheetObj.id).offset();
  	  var marginDefault = 160;
  	  var marginHeight = obj.top + marginDefault;
  	  var winHeight = $(parent.window).height();
  	  var sheetHeight = winHeight - marginHeight;

  	  with(sheetObj){
  		  ComResizeSheet(sheetObjects[0]);
  		//SetSheetHeight(sheetHeight > 90?sheetHeight-80:90);
  	  }    
    } 
	
	
    function checkExistArrayIndex(arr, val) {
    	for(var i in arr){
    		if(arr[i] == val){
    			return i
    		}
    	}
    	return -1;
    }
