﻿/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script
프로그램개요  :
작   성   자  :
작   성   일  :
===============================================================================
수정자/수정일 :
수정사유/내역 :
===============================================================================
*
* 2008.02.15 Lee Ho Ik  : Tree별 조회 후 Tree접기
* 2008.02.18 Lee Ho Ik  : common_tree_DblClick 수정 (CSR No. R200802155167)
* 2008.02.27 Lee Ho Ik  : selectDownExcelMethod 확장 data, format 옵션 셜정 가능
* 2008.04.16 Lee Ho Ik  : Excel Export/Import 관련 함수 추가
* 2008.06.19 Y.S.CHOI   : chkValidation 파라메터 추가
* 2008.10.31 Y.S.CHOI   : CSR NO. N200811030001 - rowHidden 함수 추가.
* 2009.02.01 Kim Min Ah : PRJ - S2S-08U-007. 프로젝트 관련(171-Reefer, 172-GAMer, 173-S.Rep ) 공통함수 추가
* 2009.11.03 Kim Jong-Ho : 바뀐 F/W에 의해 구분자를 ,로 변경
* 2010.04.30 Ju Sun young : CHM-201003660  Disable Lane Seletion 및 노선 선택 기능 보완
* 2010.05.15 Lee Sang-Yong : 아키텍쳐위배사항 수정 COMMAND01 -> SEARCHLIST 변경
* 2010.10.13 Lee Sang-Yong [CHM-201006207-01] display_Money -값 정상 작동 하도록 수정
* 2010.11.26 최윤성 : [CHM-201007466-01] Split 01-연간 판매목표 기능 추가 - CM Hidden 로직 제거.
*/
// 조정에서 사용되는 remark text style
document.write("<style>.remark01 {color:#005374; text-align:left; font-weight:bold; line-height:15px; padding-top: 2px; padding-bottom: 3px;}</style> ");
// IMAGE ICON 들
var ICO_CHECK = "/opuscntr/img/opus/ico_chk.gif";
var ICO_UNCHECK = "/opuscntr/img/opus/ico_unchk.gif";
var ICO_FILTER = "/opuscntr/img/opus/ico_filter.gif";
var ICO_ARROWS = "/opuscntr/img/opus/ico_arrows.gif";
//
var checkTargetSheet=new Array();
var sheetObjects=new Array();
var sheetResizeFull=false;
var sheetResizeCount=1;
var resizeTargetObject=new Array();
var popupCodeInfoClosed=true;
var msgArr=new Array();
// Sheet의 Edit Mode를 공통으로 설정할 수 있는 변수
// Sheet의 Edit Mode를 Edit상태로 할 경우 true로 변경
var default_edit_mode=false;
var isDevMode=false;
var hostname=location.hostname;
var ip=hostname.split(".");
if(hostname == "localhost" || hostname == "127.0.0.1" || hostname.indexOf("203.246.152.") >= 0){
	isDevMode=true;
}
if(ip.length >= 2 && isNaN(ip[ip.length-1])){
//	isDevMode = false;
}
/**
 *
 * 작성자 : 김원섭
 * 작성일 : 2006.10.16
 */
function funcAdd(func1, func2){
var func="";
var t1="";
var t2="";
try{t1=eval(func1);}catch(e){t1="";}
try{t2=eval(func2);}catch(e){t2="";}
    func=function(arg1, arg2, arg3, arg4, arg5, arg6){
               try{
                   t1(arg1, arg2, arg3, arg4, arg5, arg6);
	    	    }catch(e){}
                try{
                    t2(arg1, arg2, arg3, arg4, arg5, arg6);
	    	    }catch(e){}
	        };
	return func;
}
var codeSheet=null;
$(document).ready(function(){
	createCodeSheetObject();
});

function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }
    var baseCode="";
    var objs =$("[id^='DIV_']");
    for(var i = 0 ; i < objs.length ; i++){
    	baseCode="";
        break;
    }


    var sTag="";
    var id="codeSheet";

    var divElement=document.createElement("DIV");
    divElement.id = "MAKE_HIDDEN_SHEET";
    divElement.style.display="none";
    divElement.innerHTML=sTag;
    document.body.appendChild(divElement);
    ComGetSheetDivObjectTag(MAKE_HIDDEN_SHEET,id);
    ComConfigSheet(codeSheet);

    with(codeSheet){
       var HeadTitle="Status|Seq.|Code|Name";

       SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:1, DataRowMerge:0 } );

       var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
       var headers = [ { Text:HeadTitle, Align:"Center"} ];
       InitHeaders(headers, info);

       var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

       InitColumns(cols);

		SetSheetWidth(300);
		SetSheetHeight(150 );
		SetEditable(1);
		SetVisible(0);
   }

    ComEndConfigSheet(codeSheet);
}
function getCodeList(cmd, param){
    var rtn=new Array();
    rtn[0]="";
    rtn[1]="";

   	codeSheet.RemoveAll();
	var sXml = codeSheet.GetSearchData("ESM_SAQ_CODGS.do", "f_cmd="+SEARCHLIST+"&mcode="+cmd+"&"+param );
	codeSheet.LoadSearchData(sXml, {Sync:1});

	var rowCnt=codeSheet.RowCount();
    for(var i=1 ; i <= rowCnt ; i++){
        rtn[0] += codeSheet.GetCellText(i, "CODE") + "|";
        txt=codeSheet.GetCellText(i, "TEXT").split("|");
        for(var t=0 ; t < txt.length ; t++){
        	if(rtn[t+1] == undefined){
        		rtn[t+1]="";
        	}
            rtn[t+1] += txt[t] + "|";
		}
    }

    return rtn;
}
/**
 * <select> 에 <option> 이 동적으로 변경되는 경우에 사용한다.
 * getCodeList()를 수정하여 추가함.
 *
 * @date 2006-12-26 byyoo
 * @param obj - select tab object
 * @param cmd - 조회할 코드명 ( DAO에 method name으로 사용됨)
 * @param param - 코드 조회시 필요한 조건 parameter string
 * @param reload - 코드정보 재조회 여부. default=true (2007.03.06 추가)
 * @param addOption - Option object 추가  (2007.04.03 추가)
 * @see ESM_SAQ_129 참조
 **/
var getSelectCodeList_oldParam="";
function getSelectCodeList(obj, cmd, param, reload, addOption){
	if(reload == undefined){
		reload=true;
	}
	// select tag options remove
	var opts=obj.options;
	for (i=(opts == null ? 0 : opts.length); i >= 0; i--) {
		opts.remove(i);
	}
	// code search
    //createCodeSheetObject();
	codeSheet.ShowDebugMsg(false);
    var newParam="f_cmd="+SEARCHLIST+"&mcode="+cmd+"&"+param;
    if(reload || getSelectCodeList_oldParam != newParam){
    	codeSheet.RemoveAll();
		var sXml = codeSheet.GetSearchData("ESM_SAQ_CODGS.do", newParam );
		codeSheet.LoadSearchData(sXml, {Sync:1});
	   	//DoSearch("ESM_SPC_CODGS.do", newParam ,{Sync:1} );
    }
    getSelectCodeList_oldParam=newParam;
    var idx=0; // option index
    // addOption 추가
    if (addOption != undefined && addOption.nodeName == "OPTION") {
    	obj.options[idx++]=addOption;
    }
	// select tag options add
    for(var j=1 ; j <= codeSheet.RowCount(); j++){
    	obj.options[idx++]=new Option(codeSheet.GetCellText(j, "TEXT"), codeSheet.GetCellText(j, "CODE"));
    }

}
function getSheetComboText(){
    var sheetObj, row, col, idx, name, value;
    sheetObj=arguments[0];
    row=arguments[1];
    col=arguments[2];
    if(arguments.length < 4){
        idx=-1;
    }
    else{
    	idx=arguments[3];
    }
    var selectedIndex=sheetObj.GetComboInfo(row, col, "SelectedIndex") * 1;
    var texts=sheetObj.GetComboInfo(row, col, "Text").split("|");
    if(idx < 0){
    	return texts[selectedIndex].split("\t");
    }
    return texts[selectedIndex].split("\t")[idx];
}

/*
 * Period의 기간의 주차를 계산한다.
 * @param yr1 시작년도
 * @param wk1 시작주차
 * @param yr1 끝년도
 * @param wk1 끝주차
 * @return -1 : 잘못된 데이터, 계산된 주차
 * @author 송민석
 */
function calcPeriod(yr1,wk1,yr2,wk2){
    var weeks=-1;
    var sign=1;
    try{
        var iYr1=ComParseInt(yr1);
        var iWk1=ComParseInt(wk1);
        var iYr2=ComParseInt(yr2);
        var iWk2=ComParseInt(wk2);
        var currWk=0;
        if( iYr1 > iYr2 ){
            sign=-1;
            var tmp=iYr1;
            iYr1=iYr2;
            iYr2=tmp;
        }else if( iYr1 == iYr2 && iWk1 > iWk2 ){
            sign=-1;
            var tmp=iWk1;
            iWk1=iWk2;
            iWk2=tmp;
        }
        var calWeeks=0;
        if(iYr1 == iYr2 ){
            calWeeks += iWk2 - iWk1 + 1 ;
        }else{
	        // TODO: 차후에는 년도별로 차수가 다르게 계산해서 차수를 구해야함
	        // 그래서 loop를 돌렸음
	        for(var i=0  ; iYr1+i <= iYr2 ; i++){
	            //TODO: 해당년도의 주차를 구해야함.
	            currWk=54;
	            //시작년도
	            if( i == 0 ){
    	            calWeeks += currWk - iWk1 + 1;
    	        //종료년도
	            }else if(iYr1+i == iYr2 ){
	                calWeeks +=  iWk2;
	            }else{
	                calWeeks += currWk;
	            }
	        }
        }
        weeks=calWeeks*sign;
    }catch(e){
    }
    return weeks
}
function doSaveSheet(sheetObj, url, subParam, col, sAlert){
	if(sAlert == undefined){sAlert=true;}
	if( col != undefined && col != null && col.length != 0){
		var oRows=sheetObj.FindCheckedRow(col);
		if( oRows.length == 0 ){
			ComShowMessage("There is no data to save");
			return "NODATA";
		}
    }else if(sheetObj.IsDataModified()== false){
        ComShowMessage("There is no data to save");
        return "NODATA";
    }

	if(sAlert && ComShowConfirm (getMsg("SAQ90010")) != 1){
         return "CANCEL";
    }
    if(col == undefined) col=-1;
    if(sheetObj.DoSave(url, subParam, col, false)){
        return(sheetObj.GetEtcData("status"));
    }
    else{
    	return "ERR";
    }
}
function checkModifiedSheet(sheetObjs){
    var modified=false;
    if(sheetObjs.constructor == Array){
       for(var i=0 ; i < sheetObjs.length ; i++){
           modified=modified || sheetObjs[i].IsDataModified();
       }
    }
    else{
        modified=sheetObjs.IsDataModified();
    }
    return modified;
}

var objectState=new Array();
function wait(func, bOpenLayer){
	ComOpenWait(true, bOpenLayer);
	setTimeout(func+";ComOpenWait(false);", 1);
}
var popupList=new Array();
popupList["SalesOffice"]=new Array("/opuscntr/COM_ENS_071.do", 800, 500);
popupList["ContractOffice"]=new Array("/opuscntr/COM_ENS_071.do", 800, 500);
popupList["Customer"]=new Array("/opuscntr/COM_ENS_041.do", 770, 475);
popupList["CustomerGroup"]=new Array("/opuscntr/COM_ENS_051.do", 770, 475);
popupList["POL"]=new Array("/opuscntr/COM_ENS_051.do", 770, 475);
popupList["POD"]=new Array("/opuscntr/COM_ENS_051.do", 770, 475);
popupList["Port"]=new Array("/opuscntr/COM_ENS_051.do", 770, 475);
popupList["UserID"]=new Array("/opuscntr/COM_ENS_091.do", 770, 577);
popupList["VVD"]=new Array("/opuscntr/COM_ENS_0B1.do", 620, 455);
function spcPopup(module, param, width, height, callback, option, row, col){
	saqPopup(module, param, width, height, callback, option, row, col);
}
function saqPopup(module, param, width, height, callback, option, row, col){
    if(row != undefined && col != undefined){
        return ComOpenPopup(popupList[module][0]+"?"+param, popupList[module][1], popupList[module][2], callback, option, true, false, row, col);
    }
    else{
        return ComOpenPopup(popupList[module][0]+"?"+param, popupList[module][1], popupList[module][2], callback, option, true);
    }
}
/*
 * sheet의 필터링 -  sheetObj의 cols 컬럼의 값과 oriValues의 값과 일치 하는 row만 display한다.
 * **주의** sheetObj에는 hiddencheck 라는 컬럼이 존재해야만 한다.
 *
 * @param sheetObj 필터링 하고자 하는 sheet
 * @param oriValues 찾고자 하는 값(Array)
 * @param cols sheetObj에서 찾고자 하는 컬럼
 * @param isOrder 현재 sheetObj가 cols의 값 순서대로 정렬 되어 있는지 여부( true :정렬되어 있음, false:정렬되어 있지 않음)
 * @param isRowSumable hidden되는 AutoSum 컬럼의 row를  합계에 포함시킬지 여부(default=false)
 *                    ( true :hidden row도 포함시킴, false:hidden row를 포함시키지 않음)
 * @return  display된 row의 갯수
 * @author 송민석
 */
function processFilterSheet(sheetObj, oriValues , cols, isOrder, isRowSumable ){
     var filterCnt=0;
     var preStatus;
     sheetObj.RenderSheet(0);

     // clear
     var sRow=sheetObj.FindCheckedRow("hiddencheck") ;
     var arrRow=sRow.split("|");
     for (var idx=0; idx<arrRow.length-1; idx++){
         sheetObj.SetRowHidden(arrRow[idx],1);
         preStatus=sheetObj.GetRowStatus(arrRow[idx]);
         sheetObj.SetCellValue(arrRow[idx],"hiddencheck","0",0);
         //if(isRowSumable != true )
           //no support[check again]CLT sheetObj.RowSumable(arrRow[idx])=false;
         sheetObj.SetRowStatus(arrRow[idx],preStatus);
     }
     if( oriValues == undefined || oriValues.length == 0){
         return;
     }else if( !(oriValues instanceof Array)){
         var arr=Array(1);
         arr[0]=oriValues;
         oriValues=arr;
     }
     if( !(cols instanceof Array)){
         var arr=Array(1);
         arr[0]=cols;
         cols=arr;
     }
     if( !isOrder ){//정렬 안되어 있을때
         for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
             var flg=false;
             for(var j=0 ; j < cols.length ; j++ ){
            	 var subValue=sheetObj.GetCellValue(i,cols[(j)]);
                 if(oriValues[j] != subValue  ){
                     flg=true;
                     break;
                 }
             }
             if(flg == false  ){
                  filterCnt++;
                  sheetObj.SetRowHidden(i,flg);
                  preStatus=sheetObj.GetRowStatus(i);
                  sheetObj.SetCellValue(i,"hiddencheck","1",0);
                  //if(isRowSumable != true)
                       //no support[check again]CLT sheetObj.RowSumable(i)=true;
                  sheetObj.SetRowStatus(i,preStatus);
             }
         }
     }else{//데이터가 정렬되어 있을때
         var selRow=0;
         for(var j=0 ; j < cols.length ; j++ ){
             selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
             if( selRow < 0 ){//찾는 값이 없다..
                 break;
             }
         }
         if( selRow >= 0 ){
             for(var i=selRow ; i <= sheetObj.LastRow(); i++){
                 var flg=false;
                 for(var j=0 ; j < cols.length ; j++ ){
                	 var subValue=sheetObj.GetCellValue(i,cols[(j)]);
                     if(oriValues[j] != subValue  ){
                         flg=true;
                         break;
                     }
                 }
                 if(flg == false  ){
                     filterCnt++;
                     sheetObj.SetRowHidden(i,flg);
                     preStatus=sheetObj.GetRowStatus(i);
                     	sheetObj.SetCellValue(i,"hiddencheck","1",0);
                     //if(isRowSumable != true)
                        //no support[check again]CLT sheetObj.RowSumable(i)=true;
                     sheetObj.SetRowStatus(i,preStatus);
                 }else{//sort되어 있기 때문에 더이상 loop를 돌필요 없다.
                     break;
                 }
             }
         }
    }
     sheetObj.RenderSheet(1);
     return filterCnt;
}
var UPPER_CASE=1;
var LOWER_CASE=-1;
function eventKeyChangeChar(flag){
    var key=ComGetEvent("keycode");
    var obj = ComGetEvent();
    if(key >= (81 + (flag * 16)) && key <= (106 + (flag * 16))){
    	obj.keyCode =key - (flag * 32) ;
    	obj.which =key - (flag * 32)
    	obj.charCode =key - (flag * 32)
    }
}


var KEY_0=48;
var KEY_9=57;
var KEY_A=65;
var KEY_Z=90;
var KEY_a=97;
var KEY_z=122;
var KEY_CONTROL=31;
var KEY_SPACE=32;
var KEY_MINUL=45;
var KEY_PLUS=43;


function toggleSheetSize(){
	var obj=ComGetEvent();
	var status="N";
	if(obj.maxStatus == undefined || obj.maxStatus == "N"){
		status="M";
	}
	var sheetId=obj.getAttributeNode("sheetId").value;
	var type=obj.type;
	if(sheetId == undefined || type == undefined) return;
	var sheetObj=eval(sheetId);
	var isSheet=(( sheetObj) || ( sheetObj.IBSheetVersion)) ;
	var curRow=0;
	if(isSheet){
		if(sheetObj.GetSelectRow()== -1){
			curRow=sheetObj.HeaderRows()-1;
		}else{
			curRow=sheetObj.GetSelectRow();
		}
	}
	var area=obj;
	while((area.tagName != "TABLE" || area.className != "search") && area != document){
		area=area.parentElement;
	}
	if(area.parentElement.tagName == "DIV"){
		area=area.parentElement;
	}
	var main=area.parentElement;
	var tables=main.children;
	var titleArea=tables[1];
	var posTop=0;//titleArea.offsetTop + titleArea.offsetHeight;
	for(var i=0 ; i < tables.length ; i++){
		if(tables[i].className == "title" || tables[i].className == "button"){
			posTop=posTop + tables[i].offsetHeight;
			continue;
		}
		if(tables[i] == area){
			continue;
		}
		if(status == "M"){
			tables[i].orgDisplay=tables[i].style.display;
			tables[i].style.display="none";
		}
		else{
			tables[i].style.display=tables[i].orgDisplay;
		}
	}
	if(status == "M"){
		var etcHeight=area.offsetHeight - sheetObj.offsetHeight;
		var copyArea=main.parentElement.parentElement.parentElement;//***
		var sizeHeight=document.body.clientHeight - posTop - etcHeight - copyArea.rows[0].offsetHeight - 20;
		area.sheetHeight=sheetObj.GetSheetHeight();
		sheetObj.SetSheetHeight(sizeHeight);
		obj.maxStatus="M";
		obj.src="/opuscntr/img/bu_prev01.gif";
	}
	else{
		sheetObj.SetSheetHeight(area.sheetHeight);
		obj.maxStatus="N";
		obj.src="/opuscntr/img/bu_next01.gif";
	}	currSheet=sheetObj;
	if(isSheet){
		setTimeout("scrollToCurRow()", 1);
	}
}
var currSheet=null;
function scrollToCurRow(){
	if(currSheet != null){
		//currSheet.TopRow = currSheet.SelectRow * 1;
		//2009.07.27 Sheet에 데이터가 존재하지 않는 경우 SelectRow가 18버전:'1' 248버전:'-1'로 셋팅
		//따라서 데이터가 존재하지 않는 경우(조회 전)처리를 위한 분기 추가함
		if(currSheet.GetSelectRow()== -1){
			currSheet.SetTopRow(currSheet.GetSelectRow());
		}else{
			currSheet.SetTopRow(currSheet.GetSelectRow()* 1 );
		}
		currSheet=null;
	}
}
function getZeroToNullString(vl) {
	return vl == 0 ? "" : vl;
}


var colors = new Array(
		"#e1f4e2", "#edffa8", "#ebf0ff"
	);


/*
return value : String
	NODATA - 처리할 데이터가 없는 경우
	AY - 전체 데이터를 Format 적용해서 down 받는 경우
	DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
	AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
	DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
	CANCEL - Close버튼이나 창을 바로 닫은 경우
예
	var rtn=selectDownExcelMethod(sheetObj);
*/
//function selectDownExcelMethod(sheetObj){
//    var rowCnt=sheetObj.RowCount();
//	if(rowCnt == 0){
//		ComShowCodeMessage("COM132501");
//		return "NODATA";
//	}
//	var flg ;
//	with(sheetObj){
//	    rowCnt=LastRow();
//    	for(var i=HeaderRows(); i <=  rowCnt; i++ ){
//            flg=IsHaveChild(i, true) 	;
//            if( flg == true){
//                break;
//            }
//    	}
//	}
//
//	ComOpenPopup("ESM_SAQ_XLS.do?sysCommUiTitle=Excel Download&sysCommUiNavigation=Excel Download", 300, 140, "callBackReturnString", "1,0", true);
//}
/**
 * Excel Dowload시 사용
 * 사용 : var rtn = selectDownExcelMethod(sheetObj);
 *
 * @param sheetObj : sheet
 * @return null
 *         NODATA = Not Found Data
 *         AY = Down2Excel(0, false, false, true);
 *         DY = Down2Excel(-1, false, false, true);
 *         AN = SpeedDown2Excel(0, false, false);
 *         DN = SpeedDown2Excel(-1, false, false);
 *         CANCEL = Cancel + Window Close
 */
function selectDownExcelMethod(sheetObj){
	if(sheetObj.RowCount()== 0){
		ComShowCodeMessage("COM132501");
		return "NODATA";
	}
	var sFeature="";
	sFeature=sFeature + "dialogHeight:230px;"
	sFeature=sFeature + "dialogWidth:352px;"
	sFeature=sFeature + "center:yes;"
	sFeature=sFeature + "resizable:no;"
	sFeature=sFeature + "scroll:no;"
	sFeature=sFeature + "status:no;"
	
	setTimeout( function () {
		ComOpenPopupScroll("ESM_SAQ_XLS.do", 310, 170, "callBackExcelDown","0,0", true);
	 } , 100);
}

function callBackExcelDown(execType){
//	if(execType == "DN"){
//		$(document).find(".opus_design_grid").addClass("excelCellColor");
//	}
	callBackExcelMethod(execType);
//	if(execType == "DN"){
//		setTimeout(function(){
//		       $(document).find(".opus_design_grid").removeClass("excelCellColor");
//		},10);
//	}
}
function DownExcel(sheetObj, excelType){
	switch (excelType) {
		case "AY":
			sheetObj.Down2Excel({HiddenColumn:0, SheetDesign:1, Merge:1});
			break;
		case "AN":
			sheetObj.Down2Excel({HiddenColumn:0, SheetDesign:0, Merge:0});
			break;
		case "DY":
			sheetObj.Down2Excel({DownCols: makeHiddenSkipColSaq(sheetObj), SheetDesign:1, Merge:1 });
			break;
		case "DN":
			sheetObj.Down2Excel({DownCols: makeHiddenSkipColSaq(sheetObj), SheetDesign:0, Merge:0 });
			break;
	}
}

function makeHiddenSkipColSaq(sobj){
    var lc = sobj.LastCol();
    var rtnStr = "";
    for(var i=0;i<=lc;i++){
    	if( ! ( 1==sobj.GetColHidden(i) || sobj.GetCellProperty(0,i,"Type") == "CheckBox"
    		|| sobj.GetCellProperty(0,i,"Type") == "Radio"||  sobj.GetCellProperty(0,i,"Type") == "Status" 
    		||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" )){
    		rtnStr += "|"+ i;
    	}
    }
    return rtnStr.substring(1);
}

/*
* 2008.02.27 Lee Ho Ik : selectDownExcelMethod 확장 data, format 옵션 셜정 가능
*/
function selectDownExcelMethod2(sheetObj, data, format){
    var rowCnt=sheetObj.RowCount();
	if(rowCnt == 0){
		ComShowCodeMessage("COM132501");
		return "NODATA";
	}
	var flg ;
	with(sheetObj){
	    rowCnt=LastRow();
    	for(var i=HeaderRows(); i <=  rowCnt; i++ ){
            flg=IsHaveChild(i, true) 	;
            if( flg == true){
                break;
            }
    	}
	}

	ComOpenPopupScroll("ESM_SAQ_XLS.do?sysCommUiTitle=Excel Download&sysCommUiNavigation=Excel Download&data="+data+"&format="+format, 250, 300, "callBackDownExcelMethod", "1,0", true);
}

/*
 * @param msg 보여질 메시지
 * @param 0 : 단순 alert창 (default),
 *        1 : return 값을 요하는 confirm
 * @param width : msg창의 width (default 400 )
 * @param height : msg창의 height  (default 300 )
 * @param btnFlg : msg창의 OK버튼 활성화 여부 false : 비활성화, true : 활성화,  (default true )
 * @return value : String( windowType이 1 일경우에만 값이 유효함 )
    0 - CANCEL
	1 - YES 버튼을 눌렀음.
*/
function showMsgWindow(msg,windowType,width,height,fontColor,fontWeight,btnFlg){
	var sFeature="";
	if( fontColor == undefined){
	    fontColor="";
	}
	if( fontWeight == undefined){
	    fontWeight="";
	}
	if(width == undefined || width == ""){
	    width="500"; // 메시지 창크기 변경에 따라 사이즈 수정함 modify By ChungEunHo
	}
	if(height == undefined || height == ""){
	    height="360";
	}
	if(btnFlg == undefined || btnFlg != "false"){
	    btnFlg=1;
	}
	sFeature=sFeature + "dialogHeight:"+height+"px;"
	sFeature=sFeature + "dialogWidth:"+width+"px;"
	sFeature=sFeature + "center:yes;"
	sFeature=sFeature + "resizable:no;"
	sFeature=sFeature + "scroll:no;"
	sFeature=sFeature + "status:no;"
	if( windowType == undefined ){
	    windowType="0";
	}
	msgArr=new Array();
	var tmpArr="";
	var idx=0;
	if(msg.constructor == String){
		msgArr=getStringToArray(msg,1024);
	}
	else{
   		idx=0;
	    for(var msgIdx=0 ; msgIdx < msg.length ; msgIdx++){
    		tmpArr=getStringToArray(msg[msgIdx],1024);
    		for(var i=0 ; i < tmpArr.length ; i++){
    		    msgArr[idx]=tmpArr[i];
    		    idx++;
    		}
    		msgArr[idx]="\r\n\r\n";
    		idx++;
	    }
	}
	//var rtn =  ComOpenWindow("ESM_SAQ_MSG.do?windowType="+windowType+"&fontColor="+fontColor+"&fontWeight="+fontWeight+"&btnFlg="+btnFlg,  msgArr,  sFeature , true);
	ComOpenPopupScroll("ESM_SAQ_MSG.do?windowType="+windowType+"&fontColor="+fontColor+"&fontWeight="+fontWeight+"&btnFlg="+btnFlg, height, height, "callBackReturnStringSaq", "1,0", true);
}

function callBackReturnStringSaq(rtnVal){
	return rtnVal;
}

function getStringToArray(msg,size){
	var len=msg.length;
	msgArr=new Array();
	if(len > size ){
		for(var i=0 ; i < len / size + 1 ; i++){
			msgArr[i]=msg.substring(i*size, (i+1)*size);
		}
	}
	else{
	    msgArr[0]=msg;
	}
	return msgArr;
}


function monthlyTgtOrzCdCombo(objName){
	ComComboObject(objName, 3, 235, false, 0 , 1);
	var comboObj= tgtOrzCd;
	comboObj.SetTitleVisible(true);
	comboObj.SetTitle("Stage|Status|Created Date");
	comboObj.SetColWidth(0, "100");
	comboObj.SetColWidth(1, "240");
	comboObj.SetColWidth(2, "120");
//no support[check again]CLT 	comboObj.ShowCol=1;
}
function getComboCodeList(comboObj,cmd, param) {
	comboObj.RemoveAll();
	// code search
   // createCodeSheetObject();
	codeSheet.RemoveAll();
	 var newParam="f_cmd="+SEARCHLIST+"&mcode="+cmd+"&"+param;
	var sXml = codeSheet.GetSearchData("ESM_SAQ_CODGS.do", newParam );
	codeSheet.LoadSearchData(sXml, {Sync:1});
    for(var i=1 ; i <= codeSheet.RowCount(); i++){
    	comboObj.InsertItem(-1, codeSheet.GetCellText(i, "TEXT"), codeSheet.GetCellText(i, "CODE"));
    }
    comboObj.SetDropHeight(comboObj.GetItemCount() * comboObj.GetItemHeight());

}
/**
 * 전체 Child 를 조회하기 위해 사용
 * @date 2007-04-05 mslee
 * @param sheetObj - Sheet object
 *
 * 2008.02.15 Lee Ho Ik : Tree별 조회 후 Tree접기
 **/
function retrieveAllChilren(sheetObj) {
	if (haveChildLevels[currentTabIndex] == 0) {
		return;
	}
	var sheetId=sheetObj.id;
	var rowCnt=sheetObj.RowCount();
	var rowLevel;
	var retrieveCnt=0;
	var i=rowCnt;
	while (i >= 0) {
		i--;
		rowLevel=sheetObj.GetRowLevel(i);
		var childKey="";
		for (var j=0; j<rowLevel-1; j++) {
			childKey += sheetObj.GetCellValue(i, j);
		}
		var retrievedChild=false;
		for (key in retrievedChildKeysObj[sheetObj.id]) {
			if (key == childKey) {
				retrievedChild=true;
				break;
			}
		}
		if (retrievedChild == false) { //이미 조회된 Child가 아닐 경우
        	// 화면 redraw를 막음
            sheetObj.redraw=false ;
			if (rowLevel == haveChildLevels[currentTabIndex]) {
				var cellValue=sheetObj.GetCellValue(i, rowLevel-1);
				var endRow;
				if (cellValue.indexOf( "TOTAL" ) == 0) {
					var prevGetCellValue=sheetObj.GetCellValue(i, rowLevel-2); //이전 컬럼 값
					cellValue=prevGetCellValue+ cellValue;
					endRow=i;
					var currentGetCellValue;
					do {
						endRow--;
						currentGetCellValue=sheetObj.GetCellValue(endRow, rowLevel-1);
						var currentPrevGetCellValue=sheetObj.GetCellValue(endRow, rowLevel-2); //이전 컬럼 값
						currentGetCellValue=currentPrevGetCellValue+ currentGetCellValue;
					}
					while (cellValue == currentGetCellValue)
					eval(sheetId+"_OnTreeChild(sheetObj,  i)");
					retrieveCnt++;
					i=endRow+1;
				}
			}
	        // Tree 접기
            sheetObj.SetRowExpanded(endRow,0);
        	// 화면 redraw를 실행
            sheetObj.RenderSheet(1);
		}
	}
}
/**
 * 전체 Child 를 조회하기 위해 사용
 * @date 2007-07-30 Min-Seok Song
 * @param sheetObj - Sheet object
 **/
function retrieveAllChilrenV2(sheetObj) {
	if (haveChildLevels[currentTabIndex] == 0) {
		return;
	}
	var sheetId=sheetObj.id;
	var rowCnt=sheetObj.LastRow();
	var rowLevel;
	var retrieveCnt=0;
	var i=rowCnt;
	var dataCol="";

	if( haveChildColumn == undefined ){
	    dataCol=rowLevel-2;
	}else{
        if(  !ComIsNumber(haveChildColumn[currentTabIndex]) ){
            dataCol=sheetObj.SaveNameCol(haveChildColumn[currentTabIndex])-1;
        }
	}
	while (i >= 0) {
		rowLevel=sheetObj.GetRowLevel(i);
		if (rowLevel == haveChildLevels[currentTabIndex] && sheetObj.IsHaveChild(i-1) == true) {
		    //이미 조회가 되었는지 검사한다.
			if( sheetObj.GetCellValue(i-1, dataCol) != sheetObj.GetCellValue(i+1, dataCol)){
 		        eval(sheetId+"_OnTreeChild(sheetObj,  i-1)");
		    }
		}
		i--;
	}
}
/**
 * 전체 Child 를 조회하기 위해 사용 : 조회된 Child의 key를 기록한다.
 * @date 2007-04-05 mslee
 * @param sheetObj - Sheet object
 * @param Row - 기록할 row index
 **/
function recordChildKey(sheetObj, Row) {
	var childKey="";
	for (var i=0; i<haveChildLevels[currentTabIndex]-1; i++) {
		childKey += sheetObj.GetCellValue(Row, i);
	}
	retrievedChildKeysObj[sheetObj.id][childKey]=childKey;
}
function convertAqCd(aqCd) {
	if (aqCd == "  ") {
		aqCd="000000";
	}
	return aqCd;
}
function common_tree_DblClick(sheetObj, Row, Col) {
	with(sheetObj) {
		//클릭 한 위치에 텍스트를 가져온다.
		var text=GetCellValue(Row,Col);
		if (text.indexOf('TOTAL') == -1) return;
		var end_row=Row;
		//var end_row = FindText(Col, text, Row, false);
		var end_text="";
		// 루프 돌면서 아래쪽으로 내려가면서 자기와 다른 텍스트가 나올때까지 검사한다.
		 while (!IsHaveChild(end_row)){
		     end_row++;
		 }

		//다른 텍스트 한칸 위가 트리의 자식 노드를 갖는 노드이다.
		//펼치거나 접기에 앞서서 그 노드가 보여지고 있는 노드인가 점검한다.
		if(!(GetRowHidden(end_row))){
			//보여지고 있는 노드라면 접어져 있으면 펼치고, 펼쳐져 있으면 접는다.
			SetRowExpanded(end_row,!(GetRowExpanded(end_row)));
		}
	}
}


function getQuarterToMonth(qtr,isFormat){
    if( qtr == undefined || qtr.length != 2){
        return "";
    }
	qtr=qtr.substring(0,1);
	var  month=((qtr-1) * 3 )+1;
	if(isFormat != undefined && isFormat == true){
	    month=month < 10 ? "0"+month : ""+month;
	}
    return month;
}
/**
 * 월간 화면 조회조건의 Year Quarter 값을 확정 quota가 존재하는 Quarter + 1로 setting
 **/
function setYearMonthObject(yearObj, quarterObj) {
	var rtn=getCodeList("SaqMonthlyQuotaCurrentReleaseYearMonth", "");
	var year=rtn[1].substring(0,4);
	var quarter=rtn[1].substring(4,6);
	yearObj.value=year;
	quarterObj.value=quarter;
}
/**
 * 조회조건의 Year Quarter 값을 확정 quota가 존재하는 Quarter로 setting
 **/
function setRlseYearMonthObject(yearObj, quarterObj) {
	var rtn=getCodeList("SaqMonthlyQuotaCurrentReleaseQuarter", "");
	var year=rtn[1].substring(0,4);
	var quarter=rtn[1].substring(4,6);
	yearObj.value=year;
	quarterObj.value=quarter;
}
/**
 * 월간 확정 화면 조회조건의 Year Month 값 Release 월로 setting
 **/
function setYearMonthObjectByRelease(yearObj, monthObj) {
	// Release Year Month
	var rtn=getCodeList("SaqMonthlyQuotaReleaseYearMonth", "");
	yearObj.value=rtn[0].substring(0,4);
	monthObj.value=rtn[0].substring(4,6);
}


/*
 *  MultiCombo를 이용해서 item multi select시 ALL과 기타 Item이 같이 체크 되지 않게 함
 *  시작
 */
var itemMultiComboCode=new Array();
function itemMultiComboOnFocus(obj){
    itemMultiComboCode[obj.options.id]=obj.GetSelectCode();
}
function itemMultiComboOnChange(obj,code,text,allCode){

    if(allCode == undefined){
        allCode="";
    }
    if( code == "" && text == ""){
        obj.SetSelectIndex("0",false);
    }else {
//      var codes = code.split("|");
  	//2009.11.03 김종호 : 바뀐 F/W에 의해 구분자를 ,로 변경
  	var codes=code.split(",");
      if( codes.length > 1 ){
   	    //var init_codes=itemMultiComboCode[obj.options.id].split("|");
          if( codes[0] == allCode ){ // ALL이 원래 있었음. ALL을 선택 해제
        	  obj.SetItemCheck(allCode, false);
          }else if(codes[codes.length-1] == allCode ){ //ALL만 선택 되도록함
        	  for( var idx=0 ; idx < codes.length-1 ; idx++){
            	  obj.SetItemCheck(codes[idx], false);
        	  }
            }
        }
    }
    //itemMultiComboCode[obj.options.id]=obj.GetSelectCode();
}
/**
 * 지정한 컬럼 Blue 색 지정
 */
function setRowColor(sheetObj, lod_col, rpb_col, cmpb_col){
	sheetObj.SetRangeBackColor(0, lod_col, sheetObj.LastRow(), lod_col, "#FFCC33");// Orange
	sheetObj.SetRangeBackColor(0, rpb_col, sheetObj.LastRow(), rpb_col, "#FFCC33");// Orange
	sheetObj.SetRangeBackColor(0, cmpb_col, sheetObj.LastRow(), cmpb_col, "#FFCC33");// Orange
}
/**
 * 엑셀 업로드 후 후속으로 Validation 수행
 * @param otherChkFlag : 다른 체크 Function call여부 (Y/N)
 */
function chkValidation(sheetObj1, sheetObj2, formObj, lod_col, grs_rpb_col, rpb_col, rmrk_col, pol_col, pod_col, inclPortFlag, otherChkFlag, cmpb_col, cm_col) {
	var row=0;
	var rowNum1, rowNum2 ;
    var chk_rslt=true;
    var lod_qty_chk_cnt=0;
    var grs_rpb_rev_chk_cnt=0;
    var lod_qty_minus_chk_cnt=0;
    var grs_rpb_rev_minus_chk_cnt=0;
    var upd_cnt=0;
    var chk_cnt=0;
    var rpb_chk_cnt=0;
    ComOpenWait(true);
//    lastRow1 = sheetObj1.lastRow;
    var row=1;
    // 공백 삭제
    while(row <= sheetObj1.LastRow() && ComTrim(sheetObj1.GetCellValue(row, "rn")) == ""){
    	sheetObj1.RowDelete(row, false);
    }
    // 정상적인 Seq.
    while(row <= sheetObj1.LastRow() && !isNaN(sheetObj1.GetCellValue(row, "rn"))){
        row=row + 1;
       //sheetObj1.rowDelete(row);
    }
    lastRow1=sheetObj1.LastRow();
    lastRow2=sheetObj2.LastRow();
    //01. 전체 건수 체크
    if (lastRow1 != lastRow2) {
        formObj.msg.value="Upload Failed:\n"+
                          "Columns and/or rows were added on the template.\n"+
                          "Please remove columns and/or rows you have added before upload.\n"+
                          "====================================================================================\n" ;
        ComOpenWait(false);
        return;
    }
    //02. 필드 Validation 체크
    for ( row=1; row <= lastRow1; row++ ) {
        for ( col=1; col <= cmpb_col; col++) {
            if (col == grs_rpb_col) continue; //G. Rev
            if(inclPortFlag == "N"){          //POL/POD를 하지 않을 경우 POL, POD 체크 제외
                if(col == pol_col || col == pod_col) continue;
            }
            chkItem1=sheetObj1.GetCellValue(row, col);
            chkItem2=sheetObj2.GetCellValue(row, col);
            if ( chkItem1 != chkItem2 ) {
                // Load, RPB 체크
                if (col == lod_col || col == rpb_col || col == cmpb_col){  //Load Qty, GRPB
                	sheetObj1.SetRangeBackColor(row, col, row, col,"#FFC864");
                    upd_cnt ++;
                    // Round Off
                    editable=sheetObj1.GetCellValue(row, "editable");
                    unit=sheetObj1.GetCellValue(row, "unit");
                    lod_qty=sheetObj1.GetCellValue(row, "lod_qty");
                    grs_rpb_rev=sheetObj1.GetCellValue(row, "grs_rpb_rev");
                    // lod_qty가 음수
                    if ( lod_qty < 0 ) {
                        lod_qty_minus_chk_cnt ++ ;
                        sheetObj1.SetCellValue(row, rmrk_col,"Volume cannot be below Zero (0).",0);
                        sheetObj1.SetRangeBackColor(row, col, row, col,"#6496C8");
                    }
                    // grs_rpb_rev가 음수
                    if ( grs_rpb_rev < 0 ) {
                        grs_rpb_rev_minus_chk_cnt ++ ;
                        sheetObj1.SetCellValue(row, rmrk_col,"G.RPB cannot be below Zero (0).",0);
                        sheetObj1.SetRangeBackColor(row, col, row, col,"#64C8C8");
                    }
                    // lod_qty > 0 and rpb = 0 일 경우 Validation
                    if ( lod_qty > 0 && grs_rpb_rev == 0 ) {
                        rpb_chk_cnt ++;
                        sheetObj1.SetCellValue(row, rmrk_col,"G.RPB cannot be Zero (0) when there exists Volume.",0);
                        sheetObj1.SetRangeBackColor(row, col, row, col,"#64C864");
                    }
                    // Round 처리
                    if ( editable == "Y" ) {
                        if ( unit == "TEU" ) {
                            lod_qty=Math.round(lod_qty);
                        } else if ( unit == "FEU" ) {
                            lod_qty=Math.round(lod_qty * 2) / 2;
                        }
                        sheetObj1.SetCellValue(row, lod_col,lod_qty ,0);// Load Qty
                    }
                    // Update해야 할 건 -- Validation이 전체 통과할 경우 의미 있음
                    sheetObj1.SetCellValue(row,0,"U",0);
                }else{
                    if(col != cm_col){
                    	sheetObj1.SetCellValue(row, rmrk_col,"Items other than Volume and G.RPB were changed.",0);
	                	sheetObj1.SetRangeBackColor(row, col, row, col,"#FFC8C8");// Orange
	                    chk_cnt ++;
                    }
                    
                }
            }
        }
    }
    // Key Value Checking Message
    if( chk_cnt > 0 ){
        formObj.msg.value=formObj.msg.value +
                          "Upload Failed:\n" +
                          "Items other than Volume and G.RPB were changed.\n" +
                          "Please correct items other than Volume and G.RPB as they were downloaded.\n"+
                          "====================================================================================\n" ;
        chk_rslt=false;
    }
    // Load Qty 음수
    if( lod_qty_minus_chk_cnt > 0 ){
        formObj.msg.value=formObj.msg.value +
                          "Upload Failed:\n" +
                          "Volume cannot be below Zero (0).\n" +
                          "Please check the Cell(s) with Negative Volume and put Positive Number(s).\n" +
                          "====================================================================================\n" ;
        chk_rslt=false;
    }
    // GRS RPB REV 음수
    if( grs_rpb_rev_minus_chk_cnt > 0 ){
        formObj.msg.value=formObj.msg.value +
                          "Upload Failed:\n" +
                          "G.RPB cannot be below Zero (0).\n" +
                          "Please check the Cell(s) with Negative G.RPB and put Positive Number(s).\n" +
                          "====================================================================================\n" ;
        chk_rslt=false;
    }
    // Load > 0 and RPB = 0 Checking Message
    if( rpb_chk_cnt > 0 ){
        formObj.msg.value=formObj.msg.value +
                          "Upload Failed:\n" +
                          "G.RPB cannot be Zero (0) when there exists Volume.\n" +
                          "Please check the Cell(s) with Zero (0) G.RPB and put proper number(s).\n"+
                          "====================================================================================\n" ;
        chk_rslt=false;
    }
    // 기본 적인 validation chack 외에 다른 추가 적인 로직이 존재할경우
    if( otherChkFlag == "Y" ){
        var chk_rtn=chkValidation2(sheetObj1, sheetObj2);
        if(chk_rtn == true){                     // Update 내역이 존재할경우
            upd_cnt++;
        } else if(chk_rtn != false) {            // Check 자체가 필요없는 경우 false
            formObj.msg.value=formObj.msg.value + chk_rtn;
            chk_rslt=false;
        }
    }
    // 업데이트 할 건수가 없으면 Save 버튼 비활성 유지
    if ( upd_cnt == 0 ) {
        formObj.msg.value=formObj.msg.value +
                          "There are no contents to update!\n"+
                          "====================================================================================\n" ;
        chk_rslt=false;
    }
    // Validation Checking Result
    if ( chk_rslt == false ){
         ComOpenWait(false);
         return;
    }
    // Validation 완료 후 활성화
    formObj.msg.value="All items were validated successfully!\n"+
                      "If you want to save data, click 'Save' button now!\n"+
                      "====================================================================================\n" ;
	//btnImgEnable(formObj.btn_save, true);
    ComOpenWait(false);
    ComBtnEnable("btn_save");
}

/**  by mrseok 2009/7/28 added  기존파일에 존재하고 현재도 사용하여 추가함.
* @param     : str => String
* sample	: <input type ="text" name ="money" onblur="display_Money(this.value);" onfocus="delete_Char(this,',')"
* @return 	:
* 설명		: 금액 3자리 마다 콤마(,)를 찍어주는 함수 ex) 1000 => 1,000
**/
function display_Money(str)
{
	var minus="";
	if(str.charAt(0) == "-")
	{
	   minus=str.charAt(0);
	   //str = delete_Char(str,'-');
	   str=str.replace(/(^-*)|(-*$)/g, "");
	}
	var div=str.length % 3;
	var s_str="";
	if (div == 0 ) {
		count=(str.length/3)-1;
	}else{
		count=(str.length-div) /3;
	}
	for (i=1;i<=count;i++){
		s_str=str.substr(str.length-3,3)+s_str;
		str=str.substr(0,str.length-3);
		if (str.length>0){
		s_str=","+s_str;
		}
	}
	s_str=str + s_str;
	return minus+s_str;
}
/*
 *  MultiCombo를 이용해서 item multi select시 ALL과 기타 Item이 같이 체크 되지 않게 함
 *  끝
 */
/**
* 오류 메세지 가져오기
*
* @param msgNo 오류 번호
* @param msg1 출력 변수1
* @param msg2 출력 변수2
* @param msg3 출력 변수3
* @return 오류메세지
*/
function  getMsg(msgNo,msg1,msg2,msg3)
{
	var msgs=new Array();
	// SAQ - Transaction
	msgs['SAQ90001']='There are modified data.\n\n Do you want to continue?';
	msgs['SAQ90010']='Do you want to save?';
	msgs['SAQ90020']='Do you want to delete?';
	// SAQ - Validation
	msgs['SAQ90100']='Trade(' + msg1 + ') code is invalid.';
	msgs['SAQ90101']='Rep.Trade(' + msg1 + ') code is invalid.';
	msgs['SAQ90102']='SubTrade(' + msg1 + ') code is invalid.';
	msgs['SAQ90103']='Rev.Lane(' + msg1 + ') code is invalid.';
	msgs['SAQ90104']='Service Lane(' + msg1 + ') code is invalid.';
	msgs['SAQ90105']='Bound(' + msg1 + ') code is invalid.';
	msgs['SAQ90106']='Sales Office(' + msg1 + ') code is invalid.';
	msgs['SAQ90107']='Contract Office(' + msg1 + ') code is invalid.';
	msgs['SAQ90108']='Port(' + msg1 + ') code is invalid.';
	msgs['SAQ90109']=msg1 + ' Port (' + msg2 + ') code is invalid.';
	msgs['SAQ90110']='POL (' + msg1 + ') code is invalid.';
	msgs['SAQ90111']='POD (' + msg1 + ') code is invalid.';
	msgs['SAQ90112']='Retrieving period must be under ' + msg1 + ' weeks.';
	msgs['SAQ90113']=msg1 + ' must be combination of under ' + msg2 + ' English characters and ' + msg3 + ' numbers.';
	msgs['SAQ90114']=msg1 + ' is mandatory item to retrieve.';
	msgs['SAQ90115']=msg1 + ' end condition must be later than start condition';
	msgs['SAQ90121']='Please selete among ' + msg1 + ', ' + msg2 + ' and ' + msg3 + '.';
	msgs['SAQ90116']='Entered characters of ' + msg1 +' is short.';
	msgs['SAQ90117']='Please enter ' + msg1 + '.';
	msgs['SAQ90118']='Please enter numbers between 0 and 100.';
	msgs['SAQ90119']=msg1 + ' must be greater than 0.';
	msgs['SAQ90120']=msg1 + ' must be equal to or greater than '+ msg2 +'.';
	msgs['SAQ90123']=msg1 + ' must be equal to or less than ' + msg2 + '.';
	msgs['SAQ90122']='Engine is running.\n\n Do you want to process?';
	msgs['SAQ90124']='You can add row after retrieve.';
	msgs['SAQ90125']='Current status is ' + msg1 + '.\n\n ' + msg2 + ' could not be processed.';
	msgs['SAQ90126']=msg1 + ' is mandatory item.';
	msgs['SAQ90127']=msg1 + ' has been changed from input value [' + msg2 + '] to MQC [' + msg3 + '].';
	msgs['SAQ90128']='It has been processed already.';
	msgs['SAQ90129']='There are modified data.\n\n Do you want to close?';
	msgs['SAQ90130']='There are modified data.\n\n Please execute after save.';
	msgs['SAQ90131']='L/F on following Lane/Month exceeds 100%.\n Do you want to save?\n' + msg1;
	msgs['SAQ90132']='There is no registered VVD Group.\n\n VVD Info data will be registered on VVD Group.';
	msgs['SAQ90133']='Updated VVD Info is available.\n\n Please review and update VVD Group.';
	msgs['SAQ90134']='VVD Group will be reset.\n\n Please re-asign VVD Group';
	msgs['SAQ90135']='The Group had been assigned to other BSA.';
	msgs['SAQ90136']='Same Group has been assigned to same BSA.';
	msgs['SAQ90137']='Edit Mode Status.\n\n Please save after Apply or Cancel.';
	msgs['SAQ90138']='Please check [BY POL POD] in order to edit by POL/POD.';
	msgs['SAQ90139']='Do you want to ' + msg1 + '?';
	msgs['SAQ90140']='Do you want to ' + msg1 + ' the Version No. ' + msg2 + '?';
	msgs['SAQ90141']='Do you want to ' + msg1 + ' Version No. ' + msg2 + ' and set as ' + msg3 + '?';
	msgs['SAQ90142']='There is decimal in Volume.\n\n Please Round Off before confirm.';
	msgs['SAQ90143']='There are modified data.\n\n Please save before confirm.';
	msgs['SAQ90144']='Total Volume cannot be equal, or lower than 0.';
	msgs['SAQ90145']='There is no sales quota processed.';
	msgs['SAQ90146']='G.REV/G.RPB can not be equal to, or below 0(zero) when there exist Volume :\n\n'+msg1;
	msgs['SAQ90147']='Minus(-) '+msg1+' exist(s) on following Lane/Regional Group/Month :\n\n'+msg2;
	msgs['SAQ90148']='Can not input numbers in Total Column when there exists no data in every month.\n\nPlease input in each month.';
	msgs['SAQ90149']='There exist(s) 0 (Zero) Volume in Total on the following Lane(s): \n\n'+msg1;
	msgs['SAQ90150']='Please "Set Final" and in each months('+msg1+', '+msg2+', '+msg3+ ') and save before running "Monthly Adj." function.';
	msgs['SAQ90151']='There exist no content at all in '+msg1+' in "Final" Column.\nDo you want to proceed with no content on the month(s)?\n\n';
	msgs['SAQ90152']='Office(s) has(have) been added successfully:\n' + msg1;
	msgs['SAQ90153']='There is no data to ' + msg1;
	msgs['SAQ90154']='Retrieve first';
	msgs['SAQ90155']=msg1 + ' code is already exists';
	msgs['SAQ90199']=msg1 + ' code is invalid.';
	msgs['SAQ99999']=msg1;
	// SPC - Transaction
	msgs['SPC90001']='There is modified data.\n\n Do you want to process?';
	msgs['SPC90010']='Do you want to save?';
	msgs['SPC90020']='Do you want to delete?';
	msgs['SPC90030']='Existing data will be deleted and saved.\n\n Do you want to save?';
	// SPC - Validation
	msgs['SPC90100']='Trade (' + msg1 + ') code is invalid.';
	msgs['SPC90101']='Rep. Trade (' + msg1 + ') code is invalid.';
	msgs['SPC90102']='Sub Trade (' + msg1 + ') code is invalid.';
	msgs['SPC90103']='Rev. Lane (' + msg1 + ') code is invalid.';
	msgs['SPC90104']='Service Lane (' + msg1 + ') code is invalid.';
	msgs['SPC90105']='Bound (' + msg1 + ') code is invalid.';
	msgs['SPC90106']='Sales Office (' + msg1 + ') code is invalid.';
	msgs['SPC90107']='Contract Office (' + msg1 + ') code is invalid.';
	msgs['SPC90108']='Port (' + msg1 + ') code is invalid.';
	msgs['SPC90109']=msg1 + ' Port (' + msg2 + ') code is invalid.';
	msgs['SPC90110']='POL (' + msg1 + ') code is invalid.';
	msgs['SPC90111']='POD (' + msg1 + ') code is invalid.';
	msgs['SPC90112']='Retrieving period should be under ' + msg1 + ' weeks.';
	msgs['SPC90113']=msg1 + ' long must be combination of English characters under ' + msg2 + ' digits and numbers ' + msg3 + 'digits.';
	msgs['SPC90114']=msg1 + ' is mandatory item to retrieve.';
	msgs['SPC90115']=msg1 + ' end condition must be later than start condition';
	msgs['SPC90121']='Please select or enter one item among ' + msg1 + ', ' + msg2 + ' and ' + msg3 + '.';
	msgs['SPC90116']='Entered characters long of ' + msg1 + ' is short.';
	msgs['SPC90117']='Please enter ' + msg1 + '.';
	msgs['SPC90118']='Please enter numbers between 0 and 100.';
	msgs['SPC90119']=msg1 + ' must be greater than 0.';
	msgs['SPC90120']=msg1 + ' must be equal to or greater than ' + msg2 + '.';
	msgs['SPC90122']='Engine is running.\n\n Do you want to process?';
	msgs['SPC90123']='If there is no data retrieved, can not add row.';
	msgs['SPC90124']='Can add row after retrieve.';
	msgs['SPC90199']=msg1 + ' code is invalid.';
	msgs['SPC90125']='Retrieving period must be under 1 year.';
	msgs['SPC90126']='Modifying Control Option.\n\n It will be processed after complete the work.';
	msgs['SPC90127']='Engine(Ver. No - ' + msg1 + ') execution has been completed ' + ((msg2=="S")?"successfully":"unsuccessfully") + '.';
	msgs['SPC90128']='Allocation exceeds loadable space.';
	msgs['SPC90129']='Allocation exceeds sub allocation.';
	msgs['SPC90130']='Allocation exceeds loadable weight.';
	msgs['SPC90131']='Allocation exceeds allocated volume.';
	msgs['SPC90132']='Allocation exceeds allocated weight.';
	if (msgs[msgNo.toUpperCase()])
		return msgs[msgNo.toUpperCase()];
	return "";
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//DynamicPopup 소스  Start
	var oPopup=null;
	var SHEET_COUNT_HEIGHT=17;
//	function initCheckListDragPopupCompound(dataL,dataR,objName,inputObjNameL,title1L,title2L,title3L,inputObjNameR,title1R,title2R,isAllCheck){
	function initCheckListDragPopupCompound(data,objName,inputObjName,title,ratio,colSize,isAllCheck){
		if(data[0] == "" && data[1] == "" ){
			return;
		}
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
	    var dataL = data[0];
	    var dataR = data[1];
//		var arr1=dataL.split("&");
		var arr1=dataL.split("|");
		var objs=new Array();
		if( data != "" && arr1.length > 0){
		    for(var i=0 ; i < arr1.length-1 ; i++){
		        var arr2=arr1[i].split(";");
		        var arr3=arr2[1].split("|");
		        objs[i]=new Object();
		        objs[i].parent_data=arr2[0];
		        objs[i].child_data_arr=arr3;
		        objs[i].child_cnt=arr3.length;
		    }
		}

		makeCheckListDragHtmlCompound(objs,dataR.split("|"),objName,inputObjName,title,ratio.split(":"),colSize,isAllCheck);

	}

	function initCheckListDragPopupSingle(data,objName,inputObjName,title,ratio,colSize,isAllCheck){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
	    var dataL = data[0];
//		var arr1=dataL.split("&");
		var arr1=dataL.split("|");
		var objs=new Array();
		if( data != "" && arr1.length > 0){
		    for(var i=0 ; i < arr1.length-1 ; i++){
		        var arr2=arr1[i].split(";");
		        var arr3=arr2[1].split("|");
		        objs[i]=new Object();
		        objs[i].parent_data=arr2[0];
		        objs[i].child_data_arr=arr3;
		        objs[i].child_cnt=arr3.length;
		    }
		}
		makeCheckListDragHtmlSingle(objs,objName,inputObjName,title,ratio.split(":"),colSize,isAllCheck);

	}

	function initCheckListDragPopup2(data,objName,inputObjName,title1,title2,title3,option,isAllCheck){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
		var arr1=data.split("&");
		var objs=new Array();
		if( data != "" && arr1.length > 0){
		    for(var i=0 ; i < arr1.length ; i++){
		        var arr2=arr1[i].split(";");
		        var arr3=arr2[1].split("|");
		        objs[i]=new Object();
		        objs[i].parent_data=arr2[0];
		        objs[i].child_data_arr=arr3;
		        objs[i].child_cnt=arr3.length-1;
		    }
		}
	    makeCheckListDragHtml2(objs,objName,inputObjName,title1,title2,title3,option,isAllCheck);
	}
	function initCheckListDragPopup3(data,objName,inputObjName,title1,title2,title3,val_3,option,isAllCheck){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
		var arr1=data.split("&");
		var objs=new Array();
		if( data != "" && arr1.length > 0){
		    for(var i=0 ; i < arr1.length ; i++){
		        var arr2=arr1[i].split(";");
		        var arr3=arr2[1].split("|");
		        objs[i]=new Object();
		        objs[i].parent_data=arr2[0];
		        objs[i].child_data_arr=arr3;
		        objs[i].child_cnt=arr3.length-1;
		    }
		}
	    makeCheckListDragHtml3(objs,objName,inputObjName,title1,title2,title3,val_3,option,isAllCheck);
	}
	function initCheckListDragPopup(data,objName,inputObjName,title1,title2,option,isAllCheck){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
	     makeCheckListDragHtml(data.split("|"),objName,inputObjName,title1,title2,option,isAllCheck);
	}


	function openDynamicDragPopup(divO,x,y,popupWidth,popupHeight,parentObj,leftRight){
	    if( divO == undefined || divO == ""){
	        return;
	    }
	    if( leftRight == undefined ){
	        leftRight="RIGHT";
	    }
	    if(this.divObj != null ){
	        if(this.divObj.style.display == "inline"){
	            this.divObj.style.display="none"
	        }
	    }
	    this.divObj=divO;
	    if( this.oPopup == null){
	         this.oPopup=document.createElement("iframe");
	         document.body.appendChild(this.oPopup);
	         this.oPopup.style.position="absolute";
	         this.oPopup.style.zIndex=90;
	    }
	    if(divObj.isResize == undefined || divObj.isResize == false || divObj.isResize == "false"){
	        this.oPopup.style.height = popupHeight+"px";
	        this.oPopup.style.width = popupWidth+"px";
	        this.divObj.style.height = popupHeight+"px";
	        this.divObj.style.width = popupWidth+"px";
	        this.divObj.oldWidth=popupWidth+"px";
	        this.divObj.oldHeight=popupHeight+"px";
	    }else{
	        this.oPopup.style.height =this.divObj.style.height+"px";
	        this.oPopup.style.width = this.divObj.style.width+"px";
	    }
	    var offSetTopVl=0;
	    var offSetLeftVl=0;
	    var divCnt=0;
	    if( parentObj != undefined ){
	        var pE=parentObj.parentElement;
	        while( pE != undefined ){
	            if( pE.tagName == "DIV" && divCnt == 0){
	                pE=pE.parentElement;
	                divCnt=1;
	                continue;
	            }
	          offSetTopVl=offSetTopVl + parseInt(pE.offsetTop);
	          offSetLeftVl=offSetLeftVl + parseInt(pE.offsetLeft);
	          pE=pE.parentElement;
	        }
	    }
	    y=offSetTopVl+y;
	    x=offSetLeftVl+x;
	    this.divObj.style.left=(leftRight.toUpperCase() == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   )+"px" ;
	    this.divObj.style.top=y+"px";
	    this.oPopup.style.left=(leftRight.toUpperCase()  == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   )+"px" ;
	    this.oPopup.style.top=y+"px";
	    if( divObj.style.position != "absolute"){
	        divObj.style.position="absolute";
	    }
	    if( divObj.style.zIndex != 100){
	        divObj.style.zIndex=100;
	    }
	    this.oPopup.style.display="inline";
	    this.divObj.style.display="inline";
	}
	// 아래 쉬트 팝업용
	function openDynamicDragPopup2(divO,x,y,popupWidth,popupHeight,parentObj,leftRight){
	    if( divO == undefined || divO == ""){
	        return;
	    }
	    if( leftRight == undefined ){
	        leftRight="RIGHT";
	    }
	    if(this.divObj != null ){
	        if(this.divObj.style.display == "inline"){
	            this.divObj.style.display="none"
	        }
	    }
	    this.divObj=divO;
	    if( this.oPopup == null){
	         this.oPopup=document.createElement("iframe");
	         document.body.appendChild(this.oPopup);
	         this.oPopup.style.position="absolute";
	         this.oPopup.style.zIndex=90;
	    }
	    if(divObj.isResize == undefined || divObj.isResize == false || divObj.isResize == "false"){
	        this.oPopup.style.height = popupHeight+"px";
	        this.oPopup.style.width = popupWidth+"px";
	        this.divObj.style.height = popupHeight+"px";
	        this.divObj.style.width = popupWidth+"px";
	        this.divObj.oldWidth=popupWidth+"px";
	        this.divObj.oldHeight=popupHeight+"px";
	    }else{
	        this.oPopup.style.height =this.divObj.style.height+"px";
	        this.oPopup.style.width = this.divObj.style.width+"px";
	    }
	    var offSetTopVl=0;
	    var offSetLeftVl=0;
	    var divCnt=0;
	    if( parentObj != undefined ){
	        var pE=parentObj.parentElement;
	    	if (parentObj && parentObj.IBSheetVersion) pE = eval("DIV_"+parentObj.id);
	        //var pE=eval("DIV_" + parentObj.id).parentElement;
	        while( pE != undefined ){
	            if( pE.tagName == "DIV" && divCnt == 0){
	                pE=pE.parentElement;
	                divCnt=1;
	                continue;
	            }
	          offSetTopVl=offSetTopVl + parseInt(pE.offsetTop);
	          offSetLeftVl=offSetLeftVl + parseInt(pE.offsetLeft);
	          pE=pE.parentElement;
	          divCnt=0;
	        }
	    }
	    y=offSetTopVl-20; //+y;
	    x=offSetLeftVl+x;
	    this.divObj.style.left=(leftRight.toUpperCase() == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   )+"px" ;
	    this.divObj.style.top=y+"px";
	    this.oPopup.style.left=(leftRight.toUpperCase()  == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   )+"px" ;
	    this.oPopup.style.top=y+"px";
	    if( divObj.style.position != "absolute"){
	        divObj.style.position="absolute";
	    }
	    if( divObj.style.zIndex != 100){
	        divObj.style.zIndex=100;
	    }
	    this.oPopup.style.display="inline";
	    this.divObj.style.display="inline";
	}
	function dynamicPopupAllCheck(obj,inputObjName){
	     var inputObj=null;
	     if( inputObjName.constructor == String ){
	         inputObj=document.getElementsByName(inputObjName);
	     }else{
	         inputObj=inputObjName;
	     }
	     var check=obj.checked ;
	     if( inputObj.length != undefined ){
	        for(var i=0 ; i < inputObj.length ; i++){
	           inputObj[i].checked=check ;
	        }
	    }else{
	        inputObj.checked=check ;
	    }
	}
	function dynamicPopupChangeCheckBox(obj,inputObjName){
	     var allCheckObj=null;
	     if( inputObjName.constructor == String ){
	         allCheckObj=document.getElementById(inputObjName);
	     }else{
	         allCheckObj=inputObjName;
	     }
	     if( obj.checked == false ){
	        allCheckObj.checked=false;
	    }
	}
	var dragapproved=0;
	var x=0;
	var y=0;
	var offsetx=0;
	var offsety=0;
	var targetobj ;
	var divObj=null ;
	function dynamicPopupDragStart(){
		var evtobj=window.event? window.event : e
		this.targetobj=window.event? event.srcElement : e.target
		this.targetobj.style.cursor="move"
		this.dragapproved=1
		if (isNaN(parseInt(this.divObj.style.left))){this.divObj.style.left=0}
		if (isNaN(parseInt(this.divObj.style.top))){this.divObj.style.top=0}
		if (isNaN(parseInt(this.oPopup.style.left))){this.oPopup.style.left=0}
		if (isNaN(parseInt(this.oPopup.style.top))){this.oPopup.style.top=0}
		this.offsetx=parseInt(this.divObj.style.left)
		this.offsety=parseInt(this.divObj.style.top)
		this.x=evtobj.clientX
		this.y=evtobj.clientY
		if (evtobj.preventDefault)
			evtobj.preventDefault()
	}
	function dynamicPopupDrag(){
			var evtobj=window.event? window.event : e
	    	this.targetobj.style.cursor="move"
			if (this.dragapproved==1){
				this.divObj.style.left=this.offsetx+evtobj.clientX- this.x+"px"
				this.divObj.style.top=this.offsety+evtobj.clientY- this.y+"px"
				this.oPopup.style.left=this.offsetx+evtobj.clientX- this.x+"px"
				this.oPopup.style.top=this.offsety+evtobj.clientY- this.y+"px"
				//return false
			}
		}
	function dynamicPopupDragEnd(){
	    this.dragapproved=0;
	    this.targetobj.style.cursor="hand"
	}
	function dynamicPopupClose(){
	    if(this.divObj != null ){
	        if(this.divObj.style.display == "inline"){
	            this.divObj.style.display="none"
	        }
	    }
	    if( this.oPopup != null){
	         this.oPopup.style.display="none" ;
	    }
	}
	function changeHeaderFilterColor(objName,inputObjName){
	    var ICO_UNCHECK_IDX=0;
	    var ICO_CHECK_IDX=1;
	    var chk_Rslt=ICO_CHECK_IDX;
	    var sheetObj=eval(inputObjName);
	    var divObj=eval(objName);
	    var adjSheetObj=document.getElementById(divObj.sheetName);
	    var colName=divObj.colName;
	    var hHeader=divObj.hHeader;
	    if(hHeader == undefined){
	    	hHeader="Y";
	    }
	    if( sheetObj.RowCount()== 0 ){
	        return;
	    }
	    if( hHeader == "Y"){
		    // 팝업 sheet
		    with(sheetObj){
		       for(var i=HeaderRows(); i <= LastRow(); i++){      // Header 제외
		          if( GetCellImage(i, "chk_value") == ICO_UNCHECK_IDX ){
		             chk_Rslt=ICO_UNCHECK_IDX ;
 		             SetCellImage(HeaderRows()-1, "chk_value",ICO_UNCHECK_IDX);//Uncheck 존재시 Header 부분 처리
		             break;
		          }
		       }
		    }
		    //Head 색 표시
		    with(adjSheetObj){
		       if ( chk_Rslt == ICO_UNCHECK_IDX ){ // 필터적용
		           SetRangeBackColor(0, SaveNameCol(colName), 1, SaveNameCol(colName),"#E1F4E2");
		       } else {                           // 필터미적용
		           SetRangeBackColor(0, SaveNameCol(colName), 1, SaveNameCol(colName),"#C0EBA3");
		       }
		    }
	    }
	}
	var resizeTop=0;
	var resizeLeft=0;
	var oPopupOldWidth=0;
	var divObjOldWidth=0;
	var oPopupOldHeight=0;
	var divObjOldHeight=0;
	function dynamicPopupResizeStart(type){
	    var evtobj=window.event? window.event : e
	    this.resizeTop=parseInt(evtobj.clientY);
	    this.resizeLeft=parseInt(evtobj.clientX);
	    this.oPopupOldWidth=parseInt(this.oPopup.style.width);
	    this.divObjOldWidth=parseInt(this.divObj.style.width);
	    this.oPopupOldHeight=parseInt(this.oPopup.GetSheetHeight());
	    this.divObjOldHeight=parseInt(this.divObj.GetSheetHeight());
	}
	function dynamicPopupResizeDrag(type){
	    var evtobj=window.event? window.event : e
	    if( type == 0 ){
	        var pw=oPopupOldWidth+(parseInt(evtobj.clientX)-this.resizeLeft);
	        var dw=divObjOldWidth+(parseInt(evtobj.clientX)-this.resizeLeft);
	        if(  dw > parseInt(this.divObj.oldWidth )){
	            this.oPopup.style.width=pw+"px";
	            this.divObj.style.width=dw+"px";
	        }
	    }else if( type == 1 ){
	        var ph=oPopupOldHeight+(parseInt(evtobj.clientY)-this.resizeTop);
	        var dh=divObjOldHeight+(parseInt(evtobj.clientY)-this.resizeTop);
	        if(  dh > parseInt(this.divObj.oldHeight )){
	            this.oPopup.style.height = ph+"px";
	            this.divObj.style.height = dh+"px";
	        }
	    }
	}
	function dynamicPopupResizeDragEnd(type){
	    this.divObj.isResize=true;
	}
	function makeCheckListDragHtml(data,objName,inputObjName,title1,title2,option,isAllCheck){
	    if( option == undefined)
	        option="";
	    var allCheckText="";
	    var callAllCheckText="";
	    if( isAllCheck == true){
	        allCheckText="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjName+"');\" checked>";
	        callAllCheckText="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjName+"');\"";
	    }
	    
	    var html = ""
	            + "<DIV id='"+objName+"' "+option+" class='wrap_search'>"
	            + "    <table class='grid_2'>"
	            + "        <tr>"
	            + "            <th width='60%' class='align_center'>"+title1+"</th>"
	            + "            <th width='40%' class='align_center'>"+title2+"&nbsp "+allCheckText+"</th>"
	            + "        </tr>";
		for(var i=0 ; i < (data.length)-1 ; i++){	     
			html = html + ""
	            + "        <tr>"
	            + "            <td class='align_center'>"+data[i]+"</td>"
	            + "            <td class='align_center'><input type='checkbox' value='"+data[i]+"'  name='"+inputObjName+"'   id='"+inputObjName+"' "+callAllCheckText+" oldValue='true' checked></td>"
	            + "        </tr>";
		}
		html = html + ""
	            + "    </table>"
	            + "    <table class='grid_2'>"
	            + "        <tr>"
	            + "        <td>"
	            +"     <div class='opus_design_btn'>"
	            +"     <button type='button' class='btn_normal' name='btn_ok' id='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button><!--"
	            +"     --><button type='button' class='btn_normal' name='btn_close' id='btn_close' onClick='dynamicPopupClose()'>Close</button><!--"
	            +"     --></div>"
	            + "        </td>"
	            + "        </tr>"
	            + "    </table>"
	            + "</DIV>";
	    
//	    var html="\n"
//	        +"<DIV id='"+objName+"' "+option+"   >"
//	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
//	        +" 		<tr > \n"
//	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
//	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        +" 		</tr> \n"
//	        +"       	<tr><td style='WIDTH: 100%; ' >  \n"
////v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	        +" 						<td width='70%' style='border:1px solid #A3A4C7;'>"+title1+"</td>  \n"
//	        +" 						<td width='30%' style='border:1px solid #A3A4C7;'>"+title2+"&nbsp "+allCheckText+"</td>  \n"
//	        +" 		</tr> \n";
//	    for(var i=0 ; i < (data.length)-1 ; i++){
//	        html +="				<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	            +"					<td width='70%' style='border:1px solid #A3A4C7;'>"+data[i]+"</td>  \n"
//	            +"					<td width='30%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+data[i]+"\"  name="+inputObjName+"   id="+inputObjName+" "+callAllCheckText+" oldValue=true checked></td>  \n"
//	            +"				</tr>          \n"
//	    }
//	    html +="				</table>  \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"			</table>  \n"
////v	        +"</DIV> "
//	        +"       	</td> "
//	        /* 화면 크기 조정  */
//	        +" 			<td rowspan=4  style='padding:0px;  width:2px; border:0px' >  \n"
//	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        /* 화면 크기 조정 끝  */
//	        +" </tr  >  \n"
//	        +"       	<tr><td  style='WIDTH: 100%; HEIGHT: 26'>  \n"
//	        +" 	<table style='width:100% ;height:1px'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='height:1px'></td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +" 	<table style='width:100% ;height:25'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
//	        +" 				<table   style='width:100%; height:25'> \n"
//	        +" 					<tr> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td> \n"
//	        +" 					</tr> \n"
//	        +" 				</table> \n"
//	        +" 			</td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        /* 화면 크기 조정  */
//	        /* 화면 크기 조정 끝  */
//	        +"			</table>  \n"
//	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	function makeCheckListDragHtml2(data,objName,inputObjName,title1,title2,title3,option,isAllCheck){
	    if( option == undefined)
	        option="";
	    var allCheckText="";
	    var callAllCheckText="";
	    if( isAllCheck == true){
	        allCheckText="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjName+"');\" checked>";
	        callAllCheckText="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjName+"');\"";
	    }
	    
	    var html = ""
	            + "<DIV id='"+objName+"' "+option+" class='wrap_search'>\n"
	            + "    <table class='grid_2'>\n"
	            + "        <tr>\n"
	            + "            <th width='35%' class='align_center'>"+title1+"</th>\n"
	            + "            <th width='35%' class='align_center'>"+title2+"</th>\n"
	            + "            <th width='30%' class='align_center'>"+title3+"&nbsp "+allCheckText+"</th>\n"
	            + "        </tr>\n";
	    for(var i=0 ; i < data.length ; i++){
	        for(var j=0 ; j < data[i].child_cnt ; j++){
     
			html = html + ""
	            + "        <tr>\n";
			if( j == 0 ){
				html = html + ""
				+ "            <td class='align_center' rowspan='"+data[i].child_cnt+"'>"+data[i].parent_data+"</td>\n";
			}
			html = html + ""
	            + "            <td class='align_center' >"+data[i].child_data_arr[j]+"</td>\n"
	            + "            <td class='align_center'><input type='checkbox' value='"+data[i].child_data_arr[j]+"' name='"+inputObjName+"'   id='"+inputObjName+"' "+callAllCheckText+" oldValue='true' checked></td>\n"
	            + "        </tr>\n";
	        }
	    }
		html = html + ""
	            + "    </table>\n"
	            + "    <table class='grid_2'>\n"
	            + "        <tr>\n"
	            + "        <td>\n"
	            +"     <div class='opus_design_btn'>\n"
	            +"     <button type='button' class='btn_normal' name='btn_ok' id='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button><!--\n"
	            +"     --><button type='button' class='btn_normal' name='btn_close' id='btn_close' onClick='dynamicPopupClose()'>Close</button><!--\n"
	            +"     --></div>\n"
	            + "        </td>\n"
	            + "        </tr>\n"
	            + "    </table>\n"
	            + "</DIV>\n";
	
//	    var html="\n"
//	        +"<DIV id='"+objName+"' "+option+"   >"
//	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
//	        +" 		<tr > \n"
//	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
//	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        +" 		</tr> \n"
//	        +"       	<tr><td style='WIDTH: 100%; ' >  \n"
////v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	        +" 						<td width='35%' style='border:1px solid #A3A4C7;'>"+title1+"</td>  \n"
//	        +" 						<td width='35%' style='border:1px solid #A3A4C7;'>"+title2+"</td>  \n"
//	        +" 						<td width='30%' style='border:1px solid #A3A4C7;'>"+title3+"&nbsp "+allCheckText+"</td>  \n"
//	        +" 		</tr> \n";
//	    for(var i=0 ; i < data.length ; i++){
//	        for(var j=0 ; j < data[i].child_cnt ; j++){
//	            html +="	<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	            if( j == 0 ){
//	                html +="					<td width='35%' style='border:1px solid #A3A4C7;' rowspan='"+data[i].child_cnt+"'>"+data[i].parent_data+"</td>  \n";
//	            }
//	            html +="					<td width='35%' style='border:1px solid #A3A4C7;'>"+data[i].child_data_arr[j]+"</td>  \n"
//	                     +"					<td width='30%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+data[i].child_data_arr[j]+"\"  name="+inputObjName+"   id="+inputObjName+" "+callAllCheckText+" oldValue=true checked></td>  \n";
//	            html +="				</tr>          \n";
//	        }
//	    }
//	    html +="				</table>  \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"			</table>  \n"
////v	        +"</DIV> "
//	        +"       	</td> "
//	        /* 화면 크기 조정  */
//	        +" 			<td rowspan=4  style='padding:0px;  width:2px; border:0px' >  \n"
//	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        /* 화면 크기 조정 끝  */
//	        +" </tr  >  \n"
//	        +"       	<tr><td  style='WIDTH: 100%; HEIGHT: 26'>  \n"
//	        +" 	<table style='width:100% ;height:1px'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='height:1px'></td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +" 	<table style='width:100% ;height:25'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
//	        +" 				<table   style='width:100%; height:25'> \n"
//	        +" 					<tr> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td> \n"
//	        +" 					</tr> \n"
//	        +" 				</table> \n"
//	        +" 			</td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        /* 화면 크기 조정  */
//	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	function makeCheckListDragHtml3(data,objName,inputObjName,title1,title2,title3,val_3,option,isAllCheck){
	    if( option == undefined)
	        option="";
	    var allCheckText="";
	    var callAllCheckText="";
	    if( isAllCheck == true){
	        allCheckText="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjName+"');\" >";
	        callAllCheckText="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjName+"');\"";
	    }
	    var html = ""
            + "<DIV id='"+objName+"' "+option+" class='wrap_search'>\n"
            + "    <table class='grid_2'>\n"
            + "        <tr>\n"
            + "            <th width='25%' class='align_center'>"+title1+"</th>\n"
            + "            <th width='30%' class='align_center'>"+title2+"</th>\n"
            + "            <th width='20%' class='align_center'>Bound</th>\n"
            + "            <th width='25%' class='align_center'>"+title3+"&nbsp "+allCheckText+"</th>\n"
            + "        </tr>\n";
	    for(var i=0 ; i < data.length ; i++){
	        for(var j=0 ; j < data[i].child_cnt ; j++){
	 
			html = html + ""
	            + "        <tr>\n";
			if( j == 0 ){
				html = html + ""
				+ "            <td class='align_center' rowspan='"+data[i].child_cnt+"'>"+data[i].parent_data+"</td>\n";
			}
			html = html + ""
	            + "            <td class='align_center' >"+data[i].child_data_arr[j]+"</td>\n"
	            + "            <td class='align_center' >"+val_3+"</td>\n"
	            + "            <td class='align_center'><input type='checkbox' value='"+data[i].child_data_arr[j]+"' name='"+inputObjName+"'   id='"+inputObjName+"' "+callAllCheckText+" oldValue='true' ></td>\n"
	            + "        </tr>\n";
	        }
	    }
		html = html + ""
	            + "    </table>\n"
	            + "    <table class='grid_2'>\n"
	            + "        <tr>\n"
	            + "        <td>\n"
	            +"     <div class='opus_design_btn'>\n"
	            +"     <button type='button' class='btn_normal' name='btn_ok' id='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button><!--\n"
	            +"     --><button type='button' class='btn_normal' name='btn_close' id='btn_close' onClick='dynamicPopupClose()'>Close</button><!--\n"
	            +"     --></div>\n"
	            + "        </td>\n"
	            + "        </tr>\n"
	            + "    </table>\n"
	            + "</DIV>\n";
	    
//	    var html="\n"
//	        +"<DIV id='"+objName+"' "+option+"   >"
//	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
//	        +" 		<tr > \n"
//	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
//	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        +" 		</tr> \n"
//	        +"       	<tr><td style='WIDTH: 100%; ' >  \n"
////v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	        +" 						<td width='25%' style='border:1px solid #A3A4C7;'>"+title1+"</td>  \n"
//	        +" 						<td width='30%' style='border:1px solid #A3A4C7;'>"+title2+"</td>  \n"
//	        +" 						<td width='25%' style='border:1px solid #A3A4C7;'>Bound</td>  \n"
//	        +" 						<td width='20%' style='border:1px solid #A3A4C7;'>"+title3+"&nbsp "+allCheckText+"</td>  \n"
//	        +" 		       </tr> \n";
//	    for(var i=0 ; i < data.length ; i++){
//	        for(var j=0 ; j < data[i].child_cnt ; j++){
//	            html +="	<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	            if( j == 0 ){
//	                html +="		<td width='25%' style='border:1px solid #A3A4C7;' rowspan='"+data[i].child_cnt+"'>"+data[i].parent_data+"</td>  \n";
//	            }
//	            html +="			<td width='30%' style='border:1px solid #A3A4C7;'>"+data[i].child_data_arr[j]+"</td>  \n"
//	            html +="			<td width='25%' style='border:1px solid #A3A4C7;'>"+val_3+"</td>  \n"
//	                 +"				<td width='20%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+data[i].child_data_arr[j]+"\"  name="+inputObjName+"   id="+inputObjName+" "+callAllCheckText+" oldValue=true ></td>  \n";
//	            html +="	</tr>          \n";
//	        }
//	    }
//	    html +="			</table>  \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"			</table>  \n"
////v	        +"</DIV> "
//	        +"       	</td> "
//	        /* 화면 크기 조정  */
//	        +" 			<td rowspan=4  style='padding:0px;  width:2px; border:0px' >  \n"
//	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        /* 화면 크기 조정 끝  */
//	        +" </tr  >  \n"
//	        +"       	<tr><td  style='WIDTH: 100%; HEIGHT: 26'>  \n"
//	        +" 	<table style='width:100% ;height:1px'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='height:1px'></td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +" 	<table style='width:100% ;height:25'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
//	        +" 				<table   style='width:100%; height:25'> \n"
//	        +" 					<tr> \n"
////	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
////	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='dynamicPopupClose()'></td> \n"
////v			+"						<td align=center><table width='55' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
////v			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</td><td class='btn1_right'></td></tr></table></td> \n"
////v			+"						<td align=center><table width='65' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
////v			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</td><td class='btn1_right'></td></tr></table></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td> \n"
//	        +" 					</tr> \n"
//	        +" 				</table> \n"
//	        +" 			</td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        /* 화면 크기 조정  */
////v	        +" 		<tr> \n"
////v	        +" 			<td colspan=2 style='padding:0px;  height:2px; border:0px solid #A3A4C7;' >  \n"
////v	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:2px' > \n"
////v	                    +" 		<tr> \n"
////v	                    +" 			<td style='padding:0px;background-color:#000000' >"
////v	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:row-resize' width='100%' height='2' border='0'  onDragStart=\"dynamicPopupResizeStart(1)\"   onDrag=\"dynamicPopupResizeDrag(1)\" onDragEnd=\"dynamicPopupResizeDragEnd(1)\">"
////v	                    +"</td></tr> \n"
////v	                    +" 	</table> \n"
////v	        +" 		 </td> \n"
////v	        +" 		</tr> \n"
//	        /* 화면 크기 조정 끝  */
////v	        +"			</table>  \n"
//	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
//	function makeCheckListDragHtmlCompound(dataL,dataR,objName,inputObjNameL,title1L,title2L,title3L,inputObjNameR,title1R,title2R,isAllCheck){
	function makeCheckListDragHtmlCompound(dataL,dataR,objName,inputObjName,title,ratio,colSize,isAllCheck){
		var inputObjNameL = inputObjName[0];
		var inputObjNameR = inputObjName[1];
		var title1L = title[0][0];
		var title2L = title[0][1];
		var title3L = title[0][2];
		var title1R = title[1][0];
		var title2R = title[1][1];
		var isAllCheckL = isAllCheck[0];
		var isAllCheckR = isAllCheck[1];
		var colSizeL = colSize[0].split(":");
		var colSizeR = colSize[1].split(":");


	    var allCheckTextL="";
	    var callAllCheckTextL="";
	    var allCheckTextR="";
	    var callAllCheckTextR="";

	    if( isAllCheckL == true){
	        allCheckTextL="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjNameL+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjNameL+"');\" checked>";
	        callAllCheckTextL="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjNameL+"');\"";
	    }
	    if( isAllCheckR == true){
	        allCheckTextR="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjNameR+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjNameR+"');\" checked>";
	        callAllCheckTextR="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjNameR+"');\"";
	    }
	    
	    var html = ""
	            + "<DIV id='"+objName+"'  class='wrap_search'>"
	            + "    <table>"            
	            + "        <tr>"
	            + "            <td style='width: " + ratio[0] +"%; vertical-align:top'>"
	            + "                <table class='grid_2'>"
	            + "                    <tr>"
	            + "                        <th width='"+colSizeL[0]+"%' class='align_center'>"+title1L+"</th>"
	            + "                        <th width='"+colSizeL[1]+"%' class='align_center'>"+title2L+"</th>"
	            + "                        <th width='"+colSizeL[2]+"%' class='align_center'>"+title3L+"&nbsp "+allCheckTextL+"</th>"
	            + "                    </tr>";
	    for(var i=0 ; i < dataL.length ; i++){
	        for(var j=0 ; j < dataL[i].child_cnt ; j++){
			html = html + ""
	            + "                    <tr>";
			if( j == 0 ){
				html = html + ""
				+ "                        <td class='align_center' rowspan='"+dataL[i].child_cnt+"'>"+dataL[i].parent_data+"</td>";
			}                              
			html = html + ""               
	            + "                        <td class='align_center' >"+dataL[i].child_data_arr[j]+"</td>"
	            + "                        <td class='align_center'><input type='checkbox' value='"+dataL[i].child_data_arr[j]+"'  name='"+inputObjNameL+"'   id='"+inputObjNameL+"' "+callAllCheckTextL+" oldValue='true' checked></td>"
	            + "                    </tr>";
	        }
	    }
		html = html + ""
	            + "                </table>"
	            + "            </td>"
	            + "            <td style='width: " + ratio[1] +"%; vertical-align:top'>"
	            + "                <table class='grid_2'>"
	            + "                    <tr>"
	            + "                        <th width='"+colSizeR[0]+"%' class='align_center'>"+title1R+"</th>"
	            + "                        <th width='"+colSizeL[1]+"%' class='align_center'>"+title2R+"&nbsp "+allCheckTextR+"</th>"
	            + "                    </tr>";
		 for(var i=0 ; i < (dataR.length)-1 ; i++){
			html = html + ""
	            + "                    <tr>"
	            + "                        <td class='align_center' >"+dataR[i]+"</td>"
	            + "                        <td class='align_center'><input type='checkbox' value='"+dataR[i]+"'  name='"+inputObjNameR+"'   id='"+inputObjNameR+"' "+callAllCheckTextR+" oldValue='true' checked></td>"
	            + "                    </tr>";
	    }
		html = html + ""
	            + "                </table>"
	            + "            </td>"
	            + "        </tr>"
	            + "    </table>"
	            + "    <table class='grid_2'>"
	            + "        <tr>"
	            + "            <td>"
	            +"             <div class='opus_design_btn'>"
	            +"             <button type='button' class='btn_normal' name='btn_ok' id='btn_ok' onClick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button><!--"
	            +"         --><button type='button' class='btn_normal' name='btn_close' id='btn_close' onClick='dynamicPopupClose()'>Close</button><!--"
	            +"         --></div>"
	            + "            </td>"
	            + "        </tr>"
	            + "    </table>"
	            + "</DIV>";  
	    
//	    var html="\n"
//	        +"<DIV id='"+objName+"' >"
//	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
//	        +" 		<tr > \n"
//	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
//	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        +" 		</tr> \n"
//	        +"       	<tr><td style='WIDTH: " + ratio[0] +"%; vertical-align:top' >  \n"
////v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	        +" 						<td width='"+colSizeL[0]+"%' style='border:1px solid #A3A4C7;'>"+title1L+"</td>  \n"
//	        +" 						<td width='"+colSizeL[1]+"%' style='border:1px solid #A3A4C7;'>"+title2L+"</td>  \n"
//	        +" 						<td width='"+colSizeL[2]+"%' style='border:1px solid #A3A4C7;'>"+title3L+"&nbsp "+allCheckTextL+"</td>  \n"
//	        +" 		</tr> \n";
//	    for(var i=0 ; i < dataL.length ; i++){
//	        for(var j=0 ; j < dataL[i].child_cnt ; j++){
//	            html +="	<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	            if( j == 0 ){
//	                html +="					<td width='"+colSizeL[0]+"%' style='border:1px solid #A3A4C7;' rowspan='"+dataL[i].child_cnt+"'>"+dataL[i].parent_data+"</td>  \n";
//	            }
//	            html +="					<td width='"+colSizeL[1]+"%' style='border:1px solid #A3A4C7;'>"+dataL[i].child_data_arr[j]+"</td>  \n"
//	                 +"					<td width='"+colSizeL[2]+"%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+dataL[i].child_data_arr[j]+"\"  name="+inputObjNameL+"   id="+inputObjNameL+" "+callAllCheckTextL+" oldValue=true checked></td>  \n";
//	            html +="				</tr>          \n";
//	        }
//	    }
//	    html +="				</table>  \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"			</table>  \n"
////v	        +"</DIV> "
//	        +"       	</td> "
//	        +"       	<td style='WIDTH: " + ratio[1] +"%; vertical-align:top' >  \n"
//	      //v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	      	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	      	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	      	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	      	        +" 						<td width='"+colSizeR[0]+"%' style='border:1px solid #A3A4C7;'>"+title1R+"</td>  \n"
//	      	        +" 						<td width='"+colSizeR[1]+"%' style='border:1px solid #A3A4C7;'>"+title2R+"&nbsp "+allCheckTextR+"</td>  \n"
//	      	        +" 		</tr> \n";
//	      	    for(var i=0 ; i < (dataR.length)-1 ; i++){
//	      	        html +="				<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	      	            +"					<td width='"+colSizeR[0]+"%' style='border:1px solid #A3A4C7;'>"+dataR[i]+"</td>  \n"
//	      	            +"					<td width='"+colSizeR[1]+"%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+dataR[i]+"\"  name="+inputObjNameR+"   id="+inputObjNameR+" "+callAllCheckTextR+" oldValue=true checked></td>  \n"
//	      	            +"				</tr>          \n"
//	      	    }
//	      	    html +="				</table>  \n"
//	      	        +"			</td>  \n"
//	      	        +"			</tr>	  \n"
//	      	        +"			</table>  \n"
//	      //v	        +"</DIV> "
//	      	        +"       	</td> "
//	        /* 화면 크기 조정  */
//	        +" 			<td rowspan=6  style='padding:0px;  width:2px; border:0px' >  \n"
//	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        /* 화면 크기 조정 끝  */
//	        +" </tr  >  \n"
//	        +" <tr><td  colspan=2 style='WIDTH: 100%; HEIGHT: 26'>  \n"
//	        +" 	<table style='width:100% ;height:1px'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='height:1px'></td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +" 	<table style='width:100% ;height:25'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
//	        +" 				<table   style='width:100%; height:25'> \n"
//	        +" 					<tr> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\");'>Ok</button></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td> \n"
//	        +" 					</tr> \n"
//	        +" 				</table> \n"
//	        +" 			</td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	function makeCheckListDragHtmlSingle(dataL,objName,inputObjName,title,ratio,colSize,isAllCheck){
		var inputObjNameL = inputObjName[0];
		var title1L = title[0][0];
		var title2L = title[0][1];
		var title3L = title[0][2];
		var isAllCheckL = isAllCheck[0];
		var colSizeL = colSize[0].split(":");
	    var allCheckTextL="";
	    var callAllCheckTextL="";

	    if( isAllCheckL == true){
	        allCheckTextL="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjNameL+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjNameL+"');\" checked>";
	        callAllCheckTextL="onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjNameL+"');\"";
	    }

	    var html = ""
	            + "<DIV id='"+objName+"'  class='wrap_search'>"
	            + "    <table>"            
	            + "        <tr>"
	            + "            <td style='width: " + ratio[0] +"%; vertical-align:top'>"
	            + "                <table class='grid_2'>"
	            + "                    <tr>"
	            + "                        <th width='"+colSizeL[0]+"%' class='align_center'>"+title1L+"</th>"
	            + "                        <th width='"+colSizeL[1]+"%' class='align_center'>"+title2L+"</th>"
	            + "                        <th width='"+colSizeL[2]+"%' class='align_center'>"+title3L+"&nbsp "+allCheckTextL+"</th>"
	            + "                    </tr>";
	    for(var i=0 ; i < dataL.length ; i++){
	        for(var j=0 ; j < dataL[i].child_cnt ; j++){
			html = html + ""
	            + "                    <tr>";
			if( j == 0 ){
				html = html + ""
				+ "                        <td class='align_center' rowspan='"+dataL[i].child_cnt+"'>"+dataL[i].parent_data+"</td>";
			}                              
			html = html + ""               
	            + "                        <td class='align_center' >"+dataL[i].child_data_arr[j]+"</td>"
	            + "                        <td class='align_center'><input type='checkbox' value='"+dataL[i].child_data_arr[j]+"'  name='"+inputObjNameL+"'   id='"+inputObjNameL+"' "+callAllCheckTextL+" oldValue='true' checked></td>"
	            + "                    </tr>";
	        }
	    }
		html = html + ""
	            + "                </table>"
	            + "            </td>"
	            + "        </tr>"
	            + "    </table>"
	            + "    <table class='grid_2'>"
	            + "        <tr>"
	            + "            <td>"
	            +"             <div class='opus_design_btn'>"
	            +"             <button type='button' class='btn_normal' name='btn_ok' id='btn_ok' onClick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</button><!--"
	            +"         --><button type='button' class='btn_normal' name='btn_close' id='btn_close' onClick='dynamicPopupClose()'>Close</button><!--"
	            +"         --></div>"
	            + "            </td>"
	            + "        </tr>"
	            + "    </table>"
	            + "</DIV>";  
		
//	    var html="\n"
//	        +"<DIV id='"+objName+"' >"
//	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
//	        +" 		<tr > \n"
//	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
//	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        +" 		</tr> \n"
//	        +"       	<tr><td style='WIDTH: " + ratio[0] +"%; vertical-align:top' >  \n"
////v	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
//	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
//	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
//	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
//	        +" 						<td width='"+colSizeL[0]+"%' style='border:1px solid #A3A4C7;'>"+title1L+"</td>  \n"
//	        +" 						<td width='"+colSizeL[1]+"%' style='border:1px solid #A3A4C7;'>"+title2L+"</td>  \n"
//	        +" 						<td width='"+colSizeL[2]+"%' style='border:1px solid #A3A4C7;'>"+title3L+"&nbsp "+allCheckTextL+"</td>  \n"
//	        +" 		</tr> \n";
//	    for(var i=0 ; i < dataL.length ; i++){
//	        for(var j=0 ; j < dataL[i].child_cnt ; j++){
//	            html +="	<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
//	            if( j == 0 ){
//	                html +="					<td width='"+colSizeL[0]+"%' style='border:1px solid #A3A4C7;' rowspan='"+dataL[i].child_cnt+"'>"+dataL[i].parent_data+"</td>  \n";
//	            }
//	            html +="					<td width='"+colSizeL[1]+"%' style='border:1px solid #A3A4C7;'>"+dataL[i].child_data_arr[j]+"</td>  \n"
//	                 +"					<td width='"+colSizeL[2]+"%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+dataL[i].child_data_arr[j]+"\"  name="+inputObjNameL+"   id="+inputObjNameL+" "+callAllCheckTextL+" oldValue=true checked></td>  \n";
//	            html +="				</tr>          \n";
//	        }
//	    }
//	    html +="				</table>  \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"			</table>  \n"
////v	        +"</DIV> "
//	        +"       	</td> "
//	        /* 화면 크기 조정  */
//	        +" 			<td rowspan=6  style='padding:0px;  width:2px; border:0px' >  \n"
//	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
//	                    +" 		<tr> \n"
//	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
//	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
//	                    +" 		</tr> \n"
//	                    +" 	</table> \n"
//	        +" 		 </td> \n"
//	        /* 화면 크기 조정 끝  */
//	        +" </tr  >  \n"
//	        +" <tr><td  colspan=2 style='WIDTH: 100%; HEIGHT: 26'>  \n"
//	        +" 	<table style='width:100% ;height:1px'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='height:1px'></td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +" 	<table style='width:100% ;height:25'> \n"
//	        +" 		<tr> \n"
//	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
//	        +" 				<table   style='width:100%; height:25'> \n"
//	        +" 					<tr> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\");'>Ok</button></td> \n"
//			+"						<td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td> \n"
//	        +" 					</tr> \n"
//	        +" 				</table> \n"
//	        +" 			</td> \n"
//	        +" 		</tr> \n"
//	        +" 	</table> \n"
//	        +"			</td>  \n"
//	        +"			</tr>	  \n"
//	        +"</DIV>";
	    
	    
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	 /****************************************************************************/
	 /*     drag안되는 팝업 */
	 /****************************************************************************/
	 function initCheckListPopup(data,objName,inputObjName,title1,title2,option,isAllCheck){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	    makeCheckListHtml(data.split("|"),objName,inputObjName,title1,title2,option,isAllCheck);
	}
	 function openDynamicPopup(x,y,width,height,html,parentObj){
	    if( oPopup == null){
	        oPopup=window.createPopup();
	    }
	    oPopup.document.body.innerHTML=html;
	    oPopup.show(x,y,width,height,parentObj);
	    return oPopup;
	}
	 function makeCheckListHtml(data,objName,inputObjName,title1,title2,option,isAllCheck){
	    if( option == undefined)
	        option="";
	    var allCheckText="";
	    var callAllCheckText="";
	    if( isAllCheck == true){
	        allCheckText="<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"parent.dynamicPopupAllCheck(this,document.getElementsByName('"+inputObjName+"'));\" checked>";
	        callAllCheckText="onClick=\"parent.dynamicPopupChangeCheckBox(this,document.getElementById('dynamicpopup_allcheck_"+inputObjName+"'));\"";
	    }
	    var html="\n"
	        +"<DIV id='"+objName+"' "+option+">"
	        +"	<table style='border-collapse: collapse; width:100%; height:100%;'>  \n"
	        +"       	<tr><td style='padding:6px; background-color:#FFFFFF; border:3px solid #A3A4C7;'>  \n"
	        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 70%' >"
	        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
	        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
	        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
	        +" 						<td width='70%' style='border:1px solid #A3A4C7;'>"+title1+"</td>  \n"
	        +" 						<td width='30%' style='border:1px solid #A3A4C7;'>"+title2+"&nbsp "+allCheckText+"</td>  \n"
	        +" 		</tr> \n";
	    for(var i=0 ; i < (data.length)-1 ; i++){
	        html +="				<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
	            +"					<td width='70%' style='border:1px solid #A3A4C7;'>"+data[i]+"</td>  \n"
	            +"					<td width='30%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+data[i]+"\"  name="+inputObjName+"   id="+inputObjName+" "+callAllCheckText+" oldValue=true checked></td>  \n"
	            +"				</tr>          \n"
	    }
	    html +="				</table>  \n"
	        +"			</td>  \n"
	        +"			</tr>	  \n"
	        +"			</table>  \n"
	        +"</DIV> "
	        +" 	<table style='width:100% ;height:1px'> \n"
	        +" 		<tr> \n"
	        +" 			<td style='height:1px'></td> \n"
	        +" 		</tr> \n"
	        +" 	</table> \n"
	        +" 	<table style='width:100% ;height:25'> \n"
	        +" 		<tr> \n"
	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
	        +" 				<table   style='width:100%; height:25'> \n"
	        +" 					<tr> \n"
//	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='parent.oPopup.hide();parent.processPopupOK(\""+objName+"\",\""+inputObjName+"\",document.body.outerHTML);'></td> \n"
//	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='parent.oPopup.hide()'></td> \n"
			+"						<td align=center><table width='55' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_ok' name='btn_ok' onClick='parent.oPopup.hide();parent.processPopupOK(\""+objName+"\",\""+inputObjName+"\",document.body.outerHTML);'>Ok</td><td class='btn1_right'></td></tr></table></td> \n"
			+"						<td align=center><table width='65' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_close' name='btn_close' onClick='parent.oPopup.hide()'>Close</td><td class='btn1_right'></td></tr></table></td> \n"
	        +" 					</tr> \n"
	        +" 				</table> \n"
	        +" 			</td> \n"
	        +" 		</tr> \n"
	        +" 	</table> \n"
	        +"			</td>  \n"
	        +"			</tr>	  \n"
	        +"			</table>  \n"
	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	/*********************************************************************************************
	 *  sheet를 올려서 drag popup을 만든 버젼임
	 *
	 ********************************************************************************************/
	function dynamicInitSheet(inputObjName,arrTitle,cellWidth,isAllCheck){
	    var dynamicSheet=document.getElementById(inputObjName);
	    var sheetTitle="";
	    for(var i=0 ; i < arrTitle.length ; i++){
	        if( i > 0 ){
	            sheetTitle += "|";
	        }
	        sheetTitle += arrTitle[i];
	    }
	    var colCnt=arrTitle.length;
	    ComConfigSheet (dynamicSheet);
	      with(dynamicSheet){
	         SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

	         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:sheetTitle, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [];
	         for(var i=0 ; i < colCnt ; i++){
	        	 if( i == colCnt-1 ){
	        		 cols.push({Type:"Text",      Hidden:0, Width:cellWidth[i],Align:"Center",  ColMerge:1,   SaveName:"chk_value",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		        	 cols.push({Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		        	 cols.push({Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"old_chk_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                  }else{
                	  cols.push({Type:"Text",      Hidden:0,  Width:cellWidth[i],Align:"Center",  ColMerge:1,   SaveName:"data"+i,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                  }
	         }
	         InitColumns(cols);

		     if(isAllCheck == true || isAllCheck == "true"){
		         /* 이미지 적용 시작 */
		         SetImageList(0, ICO_UNCHECK);
		         SetImageList(1, ICO_CHECK);
		         //no support[check again]CLT 	                InitDataImage(0, "chk_value", daCenter);
		         SetCellImage(0, "chk_value",1);
		         //no support[check again]CLT 	                HeaderImageAlign(0,"chk_value") = daLeft;
		         /* 이미지 적용 끝 */
		     }
	         SetSheetHeight("100%");
	      }
	    ComEndConfigSheet(dynamicSheet);
	}
	function dynamicInitSheetData(inputObjName,data,logObj){
	    var dynamicSheet=eval(inputObjName);
	    var arrData=parseDynamicArrData(data);
	    var rowCnt=arrData.length;
	    var AllCheck=1;
	    //Filter 적용후 조건 변경해서 조회시 없던 Lane등에 대해 Header 값과 동일하게 하기위한 로직
	    for(var row=0 ; row < rowCnt -1;row++ ){
	        var colCnt=arrData[row].length;
	        for(var col=0 ; col < colCnt ; col++){
	            if( col == colCnt-1 ){
	                var arrValue=arrData[row][col];
	            	if(logObj != undefined && logObj != null && logObj[arrValue] != null && logObj[arrValue] != undefined && logObj != "false" && logObj[arrValue] != 1){
	            	    AllCheck=0;
	            	    break;
	            	}
	            }
	        }
	        if(AllCheck == 0) break;
	    }
	    for(var row=0 ; row < rowCnt -1;row++ ){
	        var insertRow=dynamicSheet.DataInsert();
	        var colCnt=arrData[row].length;
	        for(var col=0 ; col < colCnt ; col++){
	            dynamicSheet.SetCellValue(insertRow,"data"+col,arrData[row][col],0);
	            if( col == colCnt-1 ){
	                dynamicSheet.SetCellValue(insertRow,"value",arrData[row][col],0);
	                if(logObj == undefined || logObj == null || logObj[dynamicSheet.GetCellValue(insertRow, "value")]==null || logObj == "false"){
	            	    if(AllCheck != 0){
 	            	        dynamicSheet.SetCellImage(insertRow, "chk_value",1);
	            	        dynamicSheet.SetCellValue(insertRow, "old_chk_value",1,0);
	            	    }else{
	            	        //Filter 적용후 조건 변경해서 조회시 없던 Lane등에 대해 Header 값과 동일하게 하기위한 로직
	            	        dynamicSheet.SetCellImage(insertRow, "chk_value",0);
	            	        dynamicSheet.SetCellValue(insertRow, "old_chk_value",1,0);
	            	    }
	            	}else{
	            		dynamicSheet.SetCellImage(insertRow, "chk_value",logObj[dynamicSheet.GetCellValue(insertRow, "value")]);
	            		dynamicSheet.SetCellValue(insertRow, "old_chk_value",(logObj[dynamicSheet.GetCellValue(insertRow, "value")] == 1 ? 0 : 1),0);
	            	}
	            }
	        }
	    }
	    dynamicSheet.SelectCell(1, 1, false);
	}
	function parseDynamicArrData(data){
	    var arrData=data.split(";");
	    for(var i=0 ; i < arrData.length-1 ; i++){
	        arrData[i]=arrData[i].split("|");
	    }
	    return arrData;
	}
	 function initCheckListDragPopupSheet(data,objName,inputObjName,arrTitle,cellWidth,option,isAllCheck, logObj){
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	     if( this.oPopup != null){
	         this.oPopup.style.display="none"
	     }
	     if( this.divObj != null){
	         this.divObj.style.display="none"
	     }
	    cellWidth=cellWidth.split(":");
	    if(logObj==null || logObj==undefined){
	    	logObj="";
	    }else{
		    logObj=logObj[objName];
	    }
	    makeCheckListDragHtmlSheet(objName,inputObjName,option,isAllCheck);
	    dynamicInitSheet(inputObjName,arrTitle,cellWidth,isAllCheck);
	    dynamicInitSheetData(inputObjName,data,logObj);
//	    changeHeaderFilterColor(objName,inputObjName);
	    logObjValue(objName,inputObjName,logObj);
	}
	function logObjValue(objName,inputObjName,logObj){
	    var sheetObj=eval(inputObjName);
	    if(logObj[objName]){
 	    	for(i=1;i<sheetObj.Rows;i++){
 	    		logObj[objName][sheetObj.GetCellValue(i,"value")]=sheetObj.GetCellImage(i,"chk_value");
	    	}
	    }
	}
	function dynamicSheet_OnClick(sheetObj,row,col,value){
	    var ICO_UNCHECK_IDX=0;
	    var ICO_CHECK_IDX=1;
	    with(sheetObj){
	        var colName=ColSaveName(col)
	        if( colName == "chk_value"){
 	            var v=GetCellImage(row, "chk_value") ;
	            if(v == ICO_UNCHECK_IDX ){
	                SetCellImage(row, "chk_value",ICO_CHECK_IDX);
	            }else{
 	                SetCellImage(row, "chk_value",ICO_UNCHECK_IDX);
 	                SetCellImage(HeaderRows()-1, colName,ICO_UNCHECK_IDX);
	            }
	        }
	    }
	}
	function dynamicSheet_OnMouseDown(sheetObj,button,shift,x,y){
	    with(sheetObj){
	        var row=MouseRow();
	        var col=MouseCol();
	        var popupWidth=200;
	        var popupHeight=200;
	        if( row < HeaderRows()&& row > -1 ){
	            var colName=ColSaveName(col);
	            if( colName == "chk_value"){
	                changeDynamicSheet_AllCheck(sheetObj,"chk_value");
	            }
	        }
	    } // end with
	}
	function changeDynamicSheet_AllCheck(sheetObj,colName){
	    if( sheetObj.RowCount()== 0 ){
	        return;
	    }
	    var ICO_UNCHECK_IDX=0;
	    var ICO_CHECK_IDX=1;
	    var check_cd="0";
	    with(sheetObj){
 	       var head=GetCellImage(HeaderRows()-1, colName);
	       if( head == ICO_CHECK_IDX ){
	           check_cd="0";
 	           SetCellImage(HeaderRows()-1, colName,ICO_UNCHECK_IDX);
	       }else if( head == ICO_UNCHECK_IDX ){
	           check_cd="1";
 	           SetCellImage(HeaderRows()-1, colName,ICO_CHECK_IDX);
	       }
	       for(var i=HeaderRows(); i <= LastRow(); i++){
	           SetCellImage(i , colName,GetCellImage(HeaderRows()-1, colName));
	       }
	    }
	}
	/*
	 * 팝업에서 변경된 내용에 따라 필터링 Biz Logic 수행 (ESM_SAQ_042 와 동일함)
	 */
	function processDynamicPopupHideRow(divObj,chkSheetObj,inputObjects){
	    for(var row=chkSheetObj.HeaderRows(); row <= chkSheetObj.LastRow(); row++){
 	        var objChkValue=chkSheetObj.GetCellImage(row,"chk_value");
 	        var objOldChkValue=chkSheetObj.GetCellValue(row,"old_chk_value");
 	        var objValue=chkSheetObj.GetCellValue(row,"value");
	        if( objChkValue !=  objOldChkValue ){
	            var sheetObj=document.getElementById(divObj.sheetName);
	            var colName=divObj.colName;
	            var cols=new Array();
	            var values=new Array();
	            //보여준다.
	            if( objChkValue == 1 ){
	                    cols[0]=colName;
	                    values[0]=objValue;
	                var filterCnt=processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,true);
	                if( colName == "item" && objValue == "Load"){
	                    values[0]="L/F";
	                    processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,true);
	                }
	            //숨긴다.
	            }else if( objChkValue == 0 ){
	                cols[0]=colName;
	                values[0]=objValue;
	                var filterCnt=processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects ,false);
	                if(colName == "item" && objValue == "Load"){
	                    values[0]="L/F";
	                    processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,false);
	                }
	            }
	            chkSheetObj.SetCellValue(row,"old_chk_value",objChkValue,0);
	        }
	    }
	    changeHeaderFilterColor(divObj,chkSheetObj);
	}
	/*
	 * ESM_SAQ_085 프로그램 전용 필터링 (ESM_SAQ_042 와 동일함)
	 */
	function processDynamicPopupFilterSheet(sheetObj,cols, oriValues,inputObjects, isDisplay ){
	     var filterCnt=0;
	     var selRow=0;
	     var flg ;
	     for(var i=0 ; i <= sheetObj.LastRow(); i++){
	         flg=false;
	         //해당 컬럼 모두 일치하는 row를 찾는다.
	         for(var j=0 ; j < cols.length ; j++ ){
	             selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
	             if( selRow < 0 ){//찾는 값이 없다..
	                 break;
	             }
	         }
	         if( selRow >= 0  ){
	             i=selRow;
	             selRow++;
	             // 찾은 row의 모든 값이 일치하는지 검사한다.
	             for(var j=0 ; j < cols.length ; j++ ){
	            	 if(oriValues[j] != sheetObj.GetCellValue(i,cols[(j)])  ){
	                     flg=true;
	                     break;
	                 }
	             }
	             if(flg == false  ){
	                 if( isDisplay == true){
	                     if( filterValidation(sheetObj,i,cols,inputObjects) ){
	                         sheetObj.SetRowHidden(i,!isDisplay);
	                     }
	                 }else{
	                    sheetObj.SetRowHidden(i,!isDisplay);
	                 }
	             }
	         }else{
	             break;
	         }
	     }
	    return filterCnt;
	}
	/*
	 * checkBox의 내용을 indexOf 사용을 위해 하나의 string으로 조합해준다. (ESM_SAQ_042 와 동일함)
	 */
	function parseSheetCheckBoxStr(sheetObj, isAll,option){
	    var str="";
	    if( isAll == undefined){
	        isAll=true;
	    }
	    if(option == undefined){
	        option="";
	    }
	    var ICO_UNCHECK_IDX=0;
	    var ICO_CHECK_IDX=1;
	    var check_cd="0";
	    with(sheetObj){
	       for(var i=HeaderRows(); i <= LastRow(); i++){
	            if( isAll == false ){
 	                if(  GetCellImage(i , "chk_value")  == ICO_CHECK_IDX ){
 	                	str += GetCellValue(i,"value" )+":true|";
	                }
	            }else{
 	                if(  GetCellImage(i , "chk_value")  == ICO_CHECK_IDX ){
 	                	str += GetCellValue(i,"value" )+":true|";
	                }else{
	                	str += GetCellValue(i,"value" )+":false|";
	                }
	            }
	       }
	    }
	    str += option;
	    return str;
	}
	function makeCheckListDragHtmlSheet(objName,inputObjName,option,isAllCheck){
	    if( option == undefined)
	        option="";
	    var html="\n"
	        +"<DIV id='"+objName+"' "+option+"   >"
	        +"	<table style='border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;'>  \n"
	        +" 		<tr > \n"
	        +" 			<td colspan=2 style='padding:0px;  height:20px; border:2px solid #A3A4C7;' >  \n"
	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
	                    +" 		<tr> \n"
	                    +" 			<td style='width:100% ; font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
	                    +"<img src='/opuscntr/img/opus/space.gif'  style='width:100%;height:20px'  border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
	                    +" 		</tr> \n"
	                    +" 	</table> \n"
	        +" 		 </td> \n"
	        +" 		</tr> \n"
	        +"       	<tr><td style='WIDTH: 100%; ' >  \n"
	        +"<DIV style='OVERFLOW-Y: auto; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' id=div_"+inputObjName+">"
	        + ComGetSheetObjectTag(inputObjName)
	        + '<script language="javascript" for="'+inputObjName+'" event="OnClick(arg1,arg2, arg3)">dynamicSheet_OnClick(this,arg1,arg2,arg3);</script>'
	        + '<script language="javascript" for="'+inputObjName+'" event="OnMouseDown(arg1,arg2,arg3,arg4)">dynamicSheet_OnMouseDown(this,arg1,arg2,arg3,arg4);</script>'
	        +"</DIV> "
	        +"       	</td> "
	        /* 화면 크기 조정  */
	        +" 			<td rowspan=4  style='padding:0px;  width:2px; border:0px' >  \n"
	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
	                    +" 		<tr> \n"
	                    +" 			<td style='padding:0px; border:0px;background-color:#000000' >"
	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
	                    +" 		</tr> \n"
	                    +" 	</table> \n"
	        +" 		 </td> \n"
	        /* 화면 크기 조정 끝  */
	        +" </tr  >  \n"
	        +"       	<tr><td  style='WIDTH: 100%; HEIGHT: 26'>  \n"
	        +" 	<table style='width:100% ;height:1px'> \n"
	        +" 		<tr> \n"
	        +" 			<td style='height:1px'></td> \n"
	        +" 		</tr> \n"
	        +" 	</table> \n"
	        +" 	<table style='width:100% ;height:25'> \n"
	        +" 		<tr> \n"
	        +" 			<td style='padding:6px; background-color:#FFFFFF; border:1px solid #A3A4C7;'>  \n"
	        +" 				<table   style='width:100%; height:25'> \n"
	        +" 					<tr> \n"
//	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();changeHeaderFilterColor(\""+objName+"\",\""+inputObjName+"\");processSheetPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
//	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();processSheetPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
//	        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='dynamicPopupClose()'></td> \n"
			+"						<td align=center><table width='55' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_ok' name='btn_ok' onClick='dynamicPopupClose();processSheetPopupOK(\""+objName+"\",\""+inputObjName+"\");'>Ok</td><td class='btn1_right'></td></tr></table></td> \n"
			+"						<td align=center><table width='65' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"							<tr><td class='btn1_left'></td><td class='btn1' id='btn_close' name='btn_close' onclick='dynamicPopupClose();'>Close</td><td class='btn1_right'></td></tr></table></td> \n"
	        +" 					</tr> \n"
	        +" 				</table> \n"
	        +" 			</td> \n"
	        +" 		</tr> \n"
	        +" 	</table> \n"
	        +"			</td>  \n"
	        +"			</tr>	  \n"
	        /* 화면 크기 조정  */
	        +" 		<tr> \n"
	        +" 			<td colspan=2 style='padding:0px;  height:2px; border:0px solid #A3A4C7;' >  \n"
	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:2px' > \n"
	                    +" 		<tr> \n"
	                    +" 			<td style='padding:0px;background-color:#000000' >"
	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:row-resize' width='100%' height='2' border='0'  onDragStart=\"dynamicPopupResizeStart(1)\"   onDrag=\"dynamicPopupResizeDrag(1)\" onDragEnd=\"dynamicPopupResizeDragEnd(1)\">"
	                    +"</td></tr> \n"
	                    +" 	</table> \n"
	        +" 		 </td> \n"
	        +" 		</tr> \n"
	        /* 화면 크기 조정 끝  */
	        +"			</table>  \n"
	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.style.position="absolute";
	        obj.style.zIndex=100;
	        obj.isResize=false;
	        obj.oldWidth=0;
	        obj.oldHeight=0;
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	/*
	 * @param data 보여질 data의 array (data format ex: column이 2개일때 aa|AAA;bb|BBB;  1개일때 AAA;BBB;
	 * @param objName div 창의 object name으로 String
	 * @param inputObjName 각 grid의 이름으로 Array type
	 * @param arrTitle grid에 보여질 title Array Type
	 * @param isAllCheck all check 표시 여부 Array Type
	 * @param sheetRatio 그리드가 2개 이상일때 그리드의 비율(option, default(1/n) )
	 * @param cellWidth 각 그리드, 각 컬럼의 비율(option, default(1/n) )
	 */
	function initCalcCheckListDragPopupSheet(data,objName,inputObjName,arrTitle,sheetRatio,cellWidth,isAllCheck){
	    //var  objName =  "CALCULATION";
	    var inputCnt=inputObjName.length;
	    if( isAllCheck == undefined){
	        isAllCheck=false;
	    }
	    sheetRatio=getDefaultValueSheetRatio(inputCnt,sheetRatio)
	    cellWidth=getDefaultValueCellWidth(inputCnt,arrTitle,cellWidth)
	   makeCalcCheckListDragHtmlSheet(objName,inputObjName,sheetRatio,isAllCheck);
	   for(var i=0 ; i < inputCnt ; i++){
	       //v dynamicInitSheet(inputObjName[i],arrTitle[i],cellWidth[i],isAllCheck[i]);
	       dynamicInitSheetData(inputObjName[i],data[i]);
	   }
	}
	function getDefaultValueSheetRatio(inputCnt,sheetRatio){
	    if( sheetRatio == undefined ){
	        sheetRatio=new Array();
	        for(var i=0 ; i < inputCnt ; i++){
	           sheetRatio[i]=100/inputCnt;
	        }
	    }else{
	        sheetRatio=sheetRatio.split(":");
	    }
	    return sheetRatio;
	}
	function getDefaultValueCellWidth(inputCnt,arrTitle,cellWidth){
	    if( cellWidth == undefined ){
	        cellWidth=new Array();
	        for(var i=0 ; i < inputCnt ; i++){
	            cellWidth[i]=new Array();
	            for(var j=0 ; j < arrTitle[i].length ; j++){
	               cellWidth[i][j]=100/arrTitle[i].length;
	            }
	        }
	    }else{
	        for(var i=0 ; i < inputCnt ; i++){
	           cellWidth[i]=cellWidth[i].split(":");
	        }
	    }
	    return cellWidth;
	}
	// Apply 버튼 Popup창을 그린다.
	// 그리드가 2개짜리
	function makeCalcCheckListDragHtmlSheet(objName,inputObjName,sheetRatio,isAllCheck){
	    var html="\n"
	        +"<DIV id='"+objName+"'> \n"
	        +" <TABLE style=\"WIDTH: 100%; BORDER-COLLAPSE: collapse; HEIGHT: 100%\"> \n"
	        +" 	<TR> \n"
	        +" 		<TD style='padding:0px;  height:9px; border:2px solid #A3A4C7;' >  \n"
	        // drag를 위한 추가 시작
	                +" <TABLE style=\"WIDTH: 100%; BORDER-COLLAPSE: collapse; HEIGHT: 100%\"> \n"
	                +" 		<tr> \n"
	                +" 			<td >  \n"
	                            +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
	                            +" 		<tr> \n"
	                            +" 			<td style=' font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
	                            +"<img src='/opuscntr/img/opus/space.gif' width='100%' height='20' border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
	                            +" 		</tr> \n"
	                            +" 	</table> \n"
	                +" 		 </td> \n"
	                +" 		</tr> \n"
	                +"  </TABLE> \n"
	        // drag를 위한 추가 끝.
	        /* 세로 화면 크기 조정  */
	        +" 		<td rowspan=4  style='padding:0px;  width:2px; border:0px' >  \n"
	                    +" 	<table style='padding:0px;width:2px;  border:0px;height:100%;' > \n"
	                    +" 		<tr> \n"
	                    +" 			<td style='padding:0px; border:0px;background-color:#000000;' >"
	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:col-resize' width='2' height='100%' border='0'  onDragStart=\"dynamicPopupResizeStart(0)\"  onDrag=\"dynamicPopupResizeDrag(0)\" onDragEnd=\"dynamicPopupResizeDragEnd(0)\"></td> \n"
	                    +" 		</tr> \n"
	                    +" 	</table> \n"
	        +" 		</td> \n"
	        /* 세로 화면 크기 조정 끝  */
	        +" 	</TR> \n"
	        +" 	<TR> \n"
	        +" 		<TD style='padding:0px; border:2px solid #A3A4C7;' >  \n"
	        +" 			<table border=1 width=100% height=100%> \n"
	        +" 				<tr> \n";
	        for(var i=0 ; i < inputObjName.length ; i++ ){
	            html += " 					<td width="+sheetRatio[i]+"% > \n"
	            +" 						<DIV style=\"OVERFLOW-Y: auto; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%\" id=div_"+inputObjName[i]+"> \n"
//v	            +" 						<DIV style=\"WIDTH: 100%; HEIGHT: 100%\" id=div_"+inputObjName[i]+"> \n"
	            + ComGetSheetObjectTag(inputObjName[i])
//v	            + '<script language="javascript" for="'+inputObjName[i]+'" event="OnClick(arg1,arg2, arg3)">dynamicSheet_OnClick(this,arg1,arg2,arg3);</script>'
//v	            + '<script language="javascript" for="'+inputObjName[i]+'" event="OnMouseDown(arg1,arg2,arg3,arg4)">dynamicSheet_OnMouseDown(this,arg1,arg2,arg3,arg4);</script>'
	            +" 						</DIV> \n"
	            +" 					</td> \n";
	        }
	        html +=" 				</tr> \n"
	        +" 			</table> \n"
	        +" 	    </TD> \n"
	        +" 	</TR> \n"
	        +" 	<TR> \n"
	        +" 		<TD style='padding:0px;  height:26px; border:2px solid #A3A4C7;' >  \n"
	        +" 			<TABLE style=\"WIDTH: 100%; HEIGHT: 26px\"> \n"
	        +" 				<TR> \n"
	        +" 					<TD style='padding:3px; background-color:#FFFFFF; border:1px solid #A3A4C7;'> \n"
	        +" 						<TABLE style=\"WIDTH: 100%; HEIGHT: 20px\"> \n"
	        +" 							<TR> \n"
	        +" 								<TD align=middle> \n"
			+"									<table width='55' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"									<tr><td class='btn1_left'></td><td align=center><button type='button' class='btn_normal' id='btn_ok' name='btn_ok' onclick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\");'>Ok</button></td></tr></table>\n"
	        +" 								</TD> \n"
	        +" 								<TD align=middle> \n"
			+"									<table width='65' border='0' cellpadding='0' cellspacing='0' class='button'>\n"
			+"									<tr><td class='btn1_left'></td><td align=center><button type='button' class='btn_normal' id='btn_close' name='btn_close' onClick='dynamicPopupClose()'>Close</button></td><td class='btn1_right'></td></tr></table>\n"
	        +" 								</TD> \n"
	        +" 							</TR> \n"
	        +" 						</TABLE> \n"
	        +" 					</TD> \n"
	        +" 				</TR> \n"
	        +" 			</TABLE> \n"
	        +" 		</TD> \n"
	        +" 	</TR> \n"
	        /* 가로 화면 크기 조정  */
	        +" 		<tr> \n"
	        +" 			<td colspan=2 style='padding:0px;  height:2px; border:0px solid #A3A4C7;' >  \n"
	                    +" 	<table style='padding:0px; width:100% ;border:0px;height:2px' > \n"
	                    +" 		<tr> \n"
	                    +" 			<td style='padding:0px;background-color:#000000;' >"
	                    +"<img src='/opuscntr/img/opus/space.gif' style='cursor:row-resize' width='100%' height='2' border='0'  onDragStart=\"dynamicPopupResizeStart(1)\"   onDrag=\"dynamicPopupResizeDrag(1)\" onDragEnd=\"dynamicPopupResizeDragEnd(1)\">"
	                    +"</td></tr> \n"
	                    +" 	</table> \n"
	        +" 		 </td> \n"
	        +" 		</tr> \n"
	        /* 화면 크기 조정 끝  */
	        +" </TABLE> \n"
	        +"</DIV>";
	    if(document.getElementById("DIV__"+objName+"__DIV") == null ){
	        var obj=document.createElement("DIV");
	        obj.id="DIV__"+objName+"__DIV";
	        obj.style.display="none";
	        obj.innerHTML=html;
	        document.body.appendChild(obj);
	    }else{
	        var obj=document.getElementById("DIV__"+objName+"__DIV");
	        obj.style.display="none";
	        obj.innerHTML=html;
	    }
	}
	/////////////////// Test 용
	function popupHelpInfo(){
		var html="";
		html=html
				+ "<div style='border: 1px solid #DFDFDF;padding: 8px;background-color: #F3F3F3;'>"
				+ "<h3>Status Code Information</h3>"
				
				+ "<table class='grid_2' bordercolor='gray'>"
				+ "<colgroup>"
				+ "<col width='30'/>"
				+ "<col width='70'/>"
				+ "</colgroup>"
				+ "<tbody>"
				+ "	<tr class='h23' bgcolor='DDDDDD' align=center style='border:1px solid #000000'>"
				+ "		<th class='bg_a'>Status</th>"
				+ "		<th class='bg_a'>Description</th>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td></td>"
				+ "		<td align=left>&nbsp;&nbsp;Initial Draft</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>DC</td>"
				+ "		<td align=left>&nbsp;&nbsp;Draft Confirmed</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>DN</td>"
				+ "		<td align=left>&nbsp;&nbsp;Draft Notified</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>DR</td>"
				+ "		<td align=left>&nbsp;&nbsp;Draft Received</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>FR</td>"
				+ "		<td align=left>&nbsp;&nbsp;Final Received</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>FC</td>"
				+ "		<td align=left>&nbsp;&nbsp;Final Confirmed</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>FN</td>"
				+ "		<td align=left>&nbsp;&nbsp;Final Notified</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>QN</td>"
				+ "		<td align=left>&nbsp;&nbsp;Quota Notified</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>QF</td>"
				+ "		<td align=left>&nbsp;&nbsp;Quota Finalized</td>"
				+ "	</tr>"
				+ "	<tr align=center>"
				+ "		<td>XX</td>"
				+ "		<td align=left>&nbsp;&nbsp;Cancelled</td>"
				+ "	</tr>"
				+ "</tbody>"
				+ "</table>"
				+ "<div class='align_right'><button type='button' class='btn_etc' name='btn_close' id='btn_close' onclick='dynamicPopupClose();' >Close</button></div>"
				+ "</div>";
		
		
	    var obj=document.createElement("DIV");
	    obj.id="popupCode";
	    obj.style.display="none";
	    obj.style.position="relative";
	    obj.style.zIndex=100;
	    obj.style.left=0;//popup_marginLeft;
	    obj.style.top=0;//popup_marginTop;
	    obj.isResize=false;
	    obj.oldWidth=0;
	    obj.oldHeight=0;
	    obj.innerHTML=html;
	    document.body.appendChild(obj);
		var helpObj=document.getElementById("popupCode");
		var pObj=document.getElementsByName("help")[0];
		var evtobj=window.event? window.event : e
		if(helpObj.style.display=="none"){
//			openDynamicDragPopup(helpObj,15,25,270,310,pObj,"LEFT");
			openDynamicDragPopup(helpObj,evtobj.offsetX+370,evtobj.offsetY-120,200,310,pObj,"LEFT");
		}else{
			dynamicPopupClose();
		}
	}

	var popupCodeInfoClosed=false;
//DynamicPopup 소스  End
//--->>
	  function saqFormString(form, exElmNms) {
		 return FormQueryString(form, exElmNms);

	  }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	  	function getCodeXmlList(cmd, param){
			var rtn=new Array();
		    rtn[0]="";
		    rtn[1]="";
		    with(codeSheet){
		    	RemoveAll();
		        var sXml=GetSearchData("ESM_SAQ_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
		        var xml=sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
		    }
		    return xml;
		}
		/**
		 * 조회 조건의 Year 설정.
		 *
		 * @param{elemName} str  필수, Object Name
		 */
		function SaqSearchOptionYear(elemName) {
			var objs=document.getElementsByName(elemName);
			var today=new	Date();
			var year=today.getFullYear();
			var pre=1;
			var post=5;
			for (var j=0; j < objs.length; j++) {
				var obj=objs.item(j);
				for (var i=year + pre; i > year - pre - post; i--) {
					newOpt=document.createElement("OPTION");
					newOpt.text=i;
					newOpt.value=i;
					obj.add(newOpt);
				}
			}
			// default 값 현재 년도 setting
			if (objs.length == 1) obj.value=year;
		}
		/**
		 * 조회 조건의 Quarter 설정.
		 *
		 * @param{elemName} str	필수, Object Name
		 */
		function SaqSearchOptionQuarter(elemName) {
			var obj=document.getElementById(elemName);
			for (var i=1 ; i < 5; i++) {
				newOpt=document.createElement("OPTION");
				newOpt.text=i + "Q";
				newOpt.value=i + "Q";
				obj.add(newOpt);
			}
		}
		/**
		 * 조회 조건의 Duration 설정.
		 *
		 * @param{elemName} str  필수, Object Name
		 * @param{dur}		int  선택, Duration 주차의 길이 설정, Default = 5
		 * @param{def}		int  선택, Duration 의 초기값 설정, Default = 1
		 */
		function SaqSearchOptionDuration(elemName, dur, def) {
			if(dur == undefined || dur == null){
				dur=5;
			}
			if(def == undefined || def == null){
				def=1;
			}
			var obj=document.getElementById(elemName);
			for (var i=1; i < dur + 1; i++) {
				newOpt=document.createElement("OPTION");
				newOpt.text=i;
				newOpt.value=i;
				obj.add(newOpt);
			}
			obj.value=def;
		}
		/**
		 * 조회 조건의 Trade 설정.
		 *
		 * @param{elemName}		str  	필수, Object Name
		 * @param{isAll}		Boolean	선택, 모든 Trade 조건 추가 여부, default = true.
		 * @param{isRepTrade}	Boolean 선택, Rep Trade 조건 추가 여부, default = false.
		 * @param{del} 			str  	선택, 삭제 플레그 조건 추가 여부
		 */
		function SaqSearchOptionTrade(elemName, isAll, isRepTrade, del) {
			if(isAll == undefined || isAll == null){
				isAll=true;
			}
			if(isRepTrade == undefined || isRepTrade == null){
				isRepTrade=false;
			}
			if(del == undefined || del == null){
				del='';
			}
			var obj=window[elemName];
			var rtn=getCodeXmlList("TradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del);
			obj.SetTitleVisible(true);
			obj.SetTitle("Trade|Description");
			obj.SetColWidth(0, "50");
			obj.SetColWidth(1, "200");
			ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");
			if(isAll)
				obj.InsertItem(0, "|ALL", "");

			obj.SetDropHeight(obj.GetItemCount() * obj.GetItemHeight());
		}
		/**
		 * 조회 조건의 Sub Trade 설정.
		 *
		 * @param{elemName}		str		필수, Object Name
		 * @param{isAll}		Boolean	선택, 모든 Sub Trade 조건 추가 여부, default = true.
		 * @param{isRepTrade}	Boolean	선택, Rep Trade 조건 추가 여부, default = false.
		 * @param{del} 			str		선택, 삭제 플레그 조건 추가 여부
		 */
		function SaqSearchOptionSubTrade(elemName, isAll, isRepTrade, del, trdCd) {
			if(isAll == undefined || isAll == null){
				isAll=true;
			}
			if(isRepTrade == undefined || isRepTrade == null){
				isRepTrade=false;
			}
			if(del == undefined || del == null){
				del='';
			}
			var obj=window[elemName];
			if(trdCd == null || trdCd == ""){
			    var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll);
			} else {
				var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll + "&trdCd=" + trdCd);
			}
			obj.SetTitleVisible(true);
			obj.SetTitle("Trade|SubTrade|Description");
			obj.SetColWidth(0, "50");
			obj.SetColWidth(1, "60");
			obj.SetColWidth(2, "200");
  			//obj.ShowCol(1);
			ComXml2ComboItem(rtn, obj, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
			if(isAll)
				obj.InsertItem(0, "||ALL", "");

			obj.SetDropHeight(obj.GetItemCount() * obj.GetItemHeight());
		}
		/**
		 * 조회 조건의 RHQ 설정.
		 *
		 * @param{elemName}	str  필수, Object Name
		 * @param{del} 		str  선택, 삭제 플레그 조건 추가 여부
		 * @param{code}		str  선택, Option 의 Code 값을 직접 설정, 구분자 "|", ComComboObject 사용 안할시만 가능
		 * @param{text}		str  선택, Option 의 Text 값을 직접 설정, 구분자 "|", ComComboObject 사용 안할시만 가능
		 */
		function SaqSearchOptionRhq(elemName, del, code, text) {
			if(del == undefined || del == null){
				del='';
			}
			if(code == undefined || code == null){
				code='';
			}
			if(text == undefined || text == null){
				text='';
			}
			var obj=eval(elemName);
			if(code != '' && text != '') {
				var arrCode=code.split("|");
				var arrText=text.split("|");
				if(arrCode.length == arrText.length) {
					for (var i=0; i < arrCode.length; i++) {
						newOpt=document.createElement("OPTION");
						newOpt.text=arrText[i];
						newOpt.value=arrCode[i];
						obj.add(newOpt);
					}
				}
			} else {
				var rtn=getCodeXmlList("RHQCombo", "del=" + del);
				obj.SetTitleVisible(true);
				obj.SetTitle("RHQ|Description");
				obj.SetColWidth(0, "70");
				obj.SetColWidth(1, "220");
				ComXml2ComboItem(rtn, obj, "ofc_cd", "ofc_cd|ofc_eng_nm");
			}
		}
		/**
		 * 조회 조건의 Bound 설정.
		 *
		 * @param{elemName} str  	필수, Object Name
		 * @param{isAll}	Boolean	선택, 첫 번째 Option에 ALL 추가 여부. default = true.
		 */
		function SaqSearchOptionBound(elemName, isAll) {
			if(isAll == undefined || isAll == null){
				isAll=true;
			}
			var obj=document.getElementById(elemName);
			var bound="E|W|S|N";
			var arrCode=bound.split("|");
			var arrText=bound.split("|");
			if(isAll) {
				newOpt=document.createElement("OPTION");
				newOpt.text="ALL";
				newOpt.value="";
				obj.add(newOpt);
			}
			for (var i=0; arrCode.length > i; i++) {
				newOpt=document.createElement("OPTION");
				newOpt.text=arrText[i];
				newOpt.value=arrCode[i];
				obj.add(newOpt);
			}
		}
		/**
		 * 조회 조건의 Month 설정.
		 *
		 * @param{elemName} str	필수, Object Name
		 */
		function SaqSearchOptionMonth(elemName) {
			var objs=document.getElementsByName(elemName);
			var mon="01|02|03|04|05|06|07|08|09|10|11|12";
			var code=mon.split("|");
			var text=mon.split("|");
			for (var j=0; j < objs.length; j++) {
				var obj=objs.item(j);
				for (var i=0; i < code.length; i++) {
					newOpt=document.createElement("OPTION");
					newOpt.text=text[i];
					newOpt.value=code[i];
					obj.add(newOpt);
				}
			}
			var today=new	Date();
			var mon=today.getMonth() + 1;
			mon=(mon < 10 ? "0" : "") + mon;
			// default 값 현재 월 setting
			if (objs.length == 1) obj.value=mon;
		}
		/**
		 * 조회 조건의 Lane 설정.
		 *
		 * @param{elemName}	str		필수, Object Name
		 * @param{isAll}	Boolean	선택, Option 에 ALL 입력 여부, Default = true
		 * @param{ipc}		Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건 제외. Default = false.
		 * @param{del} 		str  	선택, 삭제 플레그 조건 추가 여부
		 */
		function SaqSearchOptionLane(elemName, isAll, ipc, del, trade) {
			if(isAll == undefined || isAll == null){
				isAll=true;
			}
			if(ipc == undefined || ipc == null){
				ipc=false;
			}
			if(del == undefined || del == null){
				del='';
			}
			if(trade == undefined || trade == null){
				trade='';
			}
			var obj=window[elemName];
			var rtn=getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc + "&trade=" + trade);
			obj.SetTitleVisible(true);
			obj.SetTitle("Trade|SubTrade|Rev.Lane|Description");
			obj.SetColWidth(0, "50");
			obj.SetColWidth(1, "60");
			obj.SetColWidth(2, "60");
			obj.SetColWidth(3, "250");
//no support[check again]CLT 			obj.ShowCol(2);
			ComXml2ComboItem(rtn, obj, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
			if(isAll)
				obj.InsertItem(0, "|||ALL", "");

//			obj.SetDropHeight(obj.GetItemCount() * obj.GetItemHeight());
			obj.SetDropHeight(250);
		}
		/**
		 * 조회 조건의 IOC 설정.
		 *
		 * @param{elemName} str  필수, Object Name
		 */
		function SaqSearchOptionIoc(elemName) {
			var obj=document.getElementById(elemName);
			var iocCode="|O|I|T";
			var iocText="|OCN|IPC|T/S";
			var arrCode=iocCode.split("|");
			var arrText=iocText.split("|");
			for (var i=0; arrCode.length > i; i++) {
				newOpt=document.createElement("OPTION");
				newOpt.text=arrText[i];
				newOpt.value=arrCode[i];
				obj.add(newOpt);
			}
		}
		/**
		 * 조회 조건의 Common Code 설정.
		 *
		 * @param{elemName} str		필수, Object Name
		 * @param{codeNo}	str		필수, 조회할 CodeNo
		 * @param{isAll}	Boolean	선택, 첫 번째 Option 추가 여부. default = true.
		 * @param{optStr}	str		선택, 첫 번째 Option 추가 할 "code|text". default = " |ALL".
		 */
		function SaqSearchOptionComCode(elemName, codeNo, isOpt, optStr) {
			if(isOpt == undefined || isOpt == null){
				isOpt=true;
			}
			if(optStr == undefined || optStr == null){
				optStr=" |ALL";
			}
			var rtn=getCodeList("CommonCode", "codeNo=" + codeNo);
			var code=rtn[0].split("|");
			var text=rtn[1].split("|");
			var obj=document.getElementById(elemName);
			if(isOpt) {
				var opt=optStr.split("|");
				newOpt=document.createElement("OPTION");
				newOpt.text=opt[1];
				newOpt.value=opt[0];
				obj.add(newOpt);
			}
			for (var i=0; i < code.length - 1; i++) {
				newOpt=document.createElement("OPTION");
				newOpt.text=text[i];
				newOpt.value=code[i];
				obj.add(newOpt);
			}
		}
		/**
		 * 조회 조건의 Common Code 설정.
		 *
		 * Multi Combo List.
		 *
		 * @param{elemName} str		필수, Object Name
		 * @param{codeNo}	str		필수, 조회할 CodeNo
		 * @param{isAll}	Boolean	선택, 첫 번째 Option에 ALL 추가 여부. default = true.
		 * @param{multi}	Boolean	선택, 다중 체크 가능 여부. default = false.
		 * @param{maxCnt}	int		선택, 다중 체크 최대 갯수. default = 1.
		 * @param{maxCnt}	str		선택, Sheet 표현방식. type1 = ColWidth("50|150"), type2 = ColWidth("0|100"). default = type1.
		 */
		function SaqSearchOptionComCodeMulti(elemName, codeNo, isAll, multi, maxCnt, type) {
			if(isAll == undefined || isAll == null){
				isAll=true;
			}
			if(multi == undefined || multi == null){
				multi=false;
			}
			if(maxCnt == undefined || maxCnt == null){
				maxCnt=1;
			}
			if(type == undefined || type == null){
				type="type1";
			}
			var obj=window[elemName];
			var rtn=getCodeXmlList("CommonCode", "codeNo=" + codeNo);
			obj.SetTitleVisible(true);
			obj.SetTitle("Code|Desc");
			if(type == "type1")	obj.SetColWidth(0, "50");
			else				obj.SetColWidth(1, "100");
			obj.SetMultiSelect(multi);
			if(multi ==1) obj.SetMultiSeparator(",");  // add

			obj.SetMaxSelect(maxCnt);
			//obj.SetDropHeight(190);
//no support[check again]CLT 			obj.ShowCol(1);
			ComXml2ComboItem(rtn, obj, "code", "code|text");
			if(isAll)
				obj.InsertItem(0, "|ALL","");

			obj.SetDropHeight(obj.GetItemCount() * obj.GetItemHeight());
		}
		/**
		 * 조회 조건의 Trade 설정.
		 *
		 * @param{elemName}	str		필수, Object Name
		 * @param{ofc}		str		선택, 조회할 Office Code.
		 * @param{enable}	Boolean	선택, combo control 여부. Default = true
		 * @param{isAll}	Boolean	선택, 첫 번째 Option에 ALL 추가 여부. default = false.
		 * @param{del} 		str		선택, 삭제 플레그 조건 추가 여부.
		 */
		function SaqSearchOptionTargetGroup(elemName, ofc, enable, isAll, del) {
			if(ofc == undefined || ofc == null){
				ofc='';
			}
			if(enable == undefined || enable == null){
				enable=true;
			}
			if(isAll == undefined || isAll == null){
				isAll=false;
			}
			if(del == undefined || del == null){
				del='';
			}
			var obj=window[elemName];
			var rtn=getCodeXmlList("TargetGroupCombo", "ofc=" + ofc + "&del=" + del);
			obj.SetTitleVisible(true);
			obj.SetTitle("GroupCode|Description");
			obj.SetColWidth(0, "80");
			obj.SetColWidth(1, "320");
			obj.SetEnable(enable);
			ComXml2ComboItem(rtn, obj, "grp_cd", "grp_cd|grp_desc");
			if(isAll)
				obj.InsertItem(0, "|ALL","");

			var count =obj.GetItemCount();
			obj.SetDropHeight(count * obj.GetItemHeight());

		}
		/**
		 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
		 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.<br>
		 *
		 * CoObject 참조.
		 *
		 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
		 * @param {string} codeCol 필수, Combo의 Code컬럼명.
		 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
		 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
		 */
		function SaqXml2ComboItem(xmlStr, codeCol, textCol) {
			var rtnArr=Array();
			var rtnArr1;
			var rtnArr2;
			if (xmlStr == null || xmlStr == "") {
				return;
			}
			if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
				return;
			}
			try {
				var xmlDoc = ComGetXmlDoc(xmlStr);
				if (xmlDoc == null) return;
				var xmlRoot = xmlDoc.documentElement;

				var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
				if (dataNode == null || dataNode.attributes.length < 3) {
					return;
				}
				var col=dataNode.getAttribute("COLORDER");
				var colArr=col.split("|");
				var sep=dataNode.getAttribute("COLSEPARATOR");
				var total=dataNode.getAttribute("TOTAL");
				var dataChildNodes=dataNode.childNodes;
				if (dataChildNodes == null) {
					return;
				}
				var colListIdx=Array();
				var arrText=textCol.split("|");
				for (var i=0; i < colArr.length; i++) {
					if (colArr[i] == codeCol) {
						colListIdx[0]=i;
					}
					for (var j=0; j < arrText.length; j++) {
						if (colArr[i] == arrText[j]) {
							colListIdx[j+1]=i;
						}
					}
				}

				var dataCount=0;
				for (var i=0; i < dataChildNodes.length; i++) {
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
					var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
					var item="";
					for (var j=1; j < colListIdx.length; j++) {
						item += arrData[colListIdx[j]];
						if (j < colListIdx.length - 1) {
							item += "\t";
						}
					}
					if (dataCount == 0 ) {
						rtnArr1=arrData[colListIdx[0]];
						rtnArr2=item;
						dataCount++;
					} else {
						rtnArr1=rtnArr1 + "|" + arrData[colListIdx[0]];
						rtnArr2=rtnArr2 + "|" + item;
						dataCount++;
					}
				}
				rtnArr.push(rtnArr1);
				rtnArr.push(rtnArr2);
			} catch (err) {
				ComFuncErrMsg(err.message);
			}
			return rtnArr;
		}

		/**
		 * IBSheet의 GetEtcData함수를 통해 가져온 데이터를 <br>
		 * dynamicPopup 용 자료로 반환한다.<br>
		 *
		 *
		 * @param {string} inputStr 필수, IBSheet를 통해 받아온 xml 문자열.
		 * @return string  변환 문자열.
		 */
		function getConvertForPopup(inputStr) {
			return inputStr.replace(/\;/gi,'^').replace(/\|/gi,';').replace(/\^/gi,'|');
		}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.<br>
 * 
 * CoObject 참조.
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} codeCol 필수, Combo의 Code컬럼명.
 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
 */
function SpcXml2ComboItem(xmlStr, codeCol, textCol) {
	var rtnArr=Array();
	var rtnArr1;
	var rtnArr2;
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		var arrText=textCol.split("|");
		for (var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			for (var j=0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j+1]=i;
				}
			}
		}
		for (var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			var item="";
			for (var j=1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "\t";
				}
			}
			if ( i == 1 ) {
				rtnArr1=arrData[colListIdx[0]];
				rtnArr2=item;
			} else {
				rtnArr1=rtnArr1 + "|" + arrData[colListIdx[0]];
				rtnArr2=rtnArr2 + "|" + item;
			}
		}
		rtnArr.push(rtnArr1);
		rtnArr.push(rtnArr2);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}

/**
 * 멀티콤보 클릭 이벤트 <br>
 * <b>Example :</b>
 * 
 * @param comboObj
 *            멀티콤보 오브젝트
 * @param index
 *            멀티콤보 index
 */
function SaqAllChkMultiCombo(comboObj, index) {
var idx = parseInt(index);
    
    //All인경우
    if(index == 0) {
    	var count = parseInt(comboObj.GetItemCount())-1;
        if(comboObj.GetItemCheck(idx)) {           
            for(var i=count ; i > 0 ; i--) {    
                comboObj.SetItemCheck(i,true, null, null, false);
            }
        } else {
            for(var i=count ; i > 0 ; i--) {
                comboObj.SetItemCheck(i,false, null, null, false);
            }
        }
    } else {
   //All 아닌경우
        var checkCnt=0;
        var count = parseInt(comboObj.GetItemCount())
        for(var i = 1 ; i <  count; i++) {
            if(comboObj.GetItemCheck(i)) {
                checkCnt++;
            }
        }
        if(checkCnt == count-1) {
            comboObj.SetItemCheck(0,true, null, null, false);
        }else{
            comboObj.SetItemCheck(0,false, null, null, false);
        }
    }
}
