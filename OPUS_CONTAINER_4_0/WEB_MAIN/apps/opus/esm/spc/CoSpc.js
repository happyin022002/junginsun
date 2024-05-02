/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSpc.js
*@FileTitle  : SPC common js
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08 
=========================================================*/
	if(msgs == undefined){
		msgs = new Array();
	}
	

//document.onkeyup=spcKeyAction;   
// 조정에서 사용되는 remark text style
﻿document.write("<style>.remark01 {color:#005374; text-align:left; font-weight:bold; line-height:15px; padding-top: 2px; padding-bottom: 3px;}</style> ");
var checkTargetSheet=new Array();
var sheetObjects=new Array();
var sheetResizeFull=false;
var sheetResizeCount=1;
var resizeTargetObject=new Array();
/*
 * ESM_SPC_0103.js(Sales Rep&Account Input )에서 사용함
 * loadPage()마지막에서 호출
 */
function document_onresize(){ 
	if(!sheetResizeFull) return;
	var mainObj=document.body.children.tags("TABLE");
	if(mainObj.length == 0){
		mainObj=document.body.children.tags("FORM")[0].children.tags("TABLE")[0];
	}
	var subObj=mainObj.rows(0).cells(0).children.tags("TABLE")[0];
	var subObjs=subObj.rows(0).cells(0).children;
	var height=0;
	for(var j=0 ; j < subObjs.length ; j++){
		if("!LINK".indexOf(subObjs[j].tagName) >= 0) continue;
		height=height + subObjs[j].offsetHeight;
	}
	height=height + mainObj.rows(1).offsetHeight;
	var cHeight=document.body.clientHeight;
	var dHeight=cHeight - height;
	for(var i=0 ; i < sheetObjects.length ; i++){
		var h=sheetObjects[i].GetSheetHeight();
		var pos=h.indexOf("px");
		if(pos >= 0){
			h=h.substring(0, pos)*1;
		}
		var minHeight=13 + sheetObjects[i].GetDataRowHeight()* 2 + ((sheetObjects[i].GetCountPosition()==0)?0:(sheetObjects[i].GetSheetFontSize*2));
		var rowHeight=0;
		for(var r=0 ; r < sheetObjects[i].HeaderRows(); r++){
			sheetObjects[i].SetCellText(r, 0 ,sheetObjects[i].GetCellText(r, 0));
			rowHeight=rowHeight + sheetObjects[i].GetRowHeight(r);
		}
		minHeight=minHeight + rowHeight;
		if(h + (dHeight / sheetResizeCount) < minHeight){
			sheetObjects[i].SetSheetHeight(minHeight);
		}
		else{
			sheetObjects[i].SetSheetHeight(h + dHeight / sheetResizeCount - 20);
		}
	}
	for(var k=0 ; k < resizeTargetObject.length ; k++){
		var obj=document.getElementById(resizeTargetObject[k]);
		var h=obj.GetSheetHeight();
		var pos=h.indexOf("px");
		if(pos >= 0){
			h=h.substring(0, pos)*1;
		}
		var minHeight=10;
		if(h + (dHeight / sheetResizeCount) - 20 < minHeight){
			obj.SetSheetHeight(minHeight);
		}
		else{
			obj.SetSheetHeight(h + dHeight / sheetResizeCount - 20);
		}
	}
}
/*
 * 페이지를 벗어날때 변경된 값이 있으면 경고 메시지
 * There is modified data.\n\n Do you want to process?
 */
function document_onbeforeunload(){
	if(sheetObjects == undefined){
		return;
	}
	var cnt=sheetObjects.length;
	var idx=0;
	for(var i=0 ; i < cnt ; i++){
		if(sheetObjects[i].GetEditable()){
			checkTargetSheet[idx]=sheetObjects[i];
			idx=idx + 1;
		}
	}
	if(checkModifiedSheet(checkTargetSheet)){
		event.returnValue=getMsg("SPC90001");
		return false;
	}
	return;
}
// Sheet의 Edit Mode를 공통으로 설정할 수 있는 변수
// Sheet의 Edit Mode를 Edit상태로 할 경우 true로 변경
var default_edit_mode=false;
var isDevMode=false;
var hostname=location.hostname;
var ip=hostname.split(".");
/*
if(hostname == "localhost" || hostname == "127.0.0.1" || hostname.indexOf("203.246.152.") >= 0){
	isDevMode=true;
}*/
/*
 * 개발자 모드 설정, 개발자 모드는 로그/기본값 세팅등이 되어 있다.
 */
if(hostname == "127.0.0.1"){
	isDevMode=true;
}
/*
 * ip가 Number가 아닌지 확인해서 개발자 모드 세팅 변경
 */
//if(ip.length >= 2 && isNaN(ip[ip.length-1])){
////	isDevMode = false;
//}
/**
 * function 추가
 * IBMulticombo생성시 CustomTag쪽 코드에서 사용했음
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

/*
 * 
 */
function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }

    var sTag="";
    var id="codeSheet";
    
    var divElement=document.createElement("DIV");
    divElement.id = "CODE_HIDDEN_SHEET";
    divElement.style.display="none";
    divElement.innerHTML=sTag;
    document.body.appendChild(divElement);
    ComGetSheetDivObjectTag(CODE_HIDDEN_SHEET,id);
    ComConfigSheet(codeSheet);

    with(codeSheet){

		var HeadTitle="Status|Seq.|Code|Name";
		var cnt=0;

		SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:0, DataRowMerge:0 } );

		var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
		var headers = [ { Text:HeadTitle, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		 
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
    //createCodeSheetObject();
    	codeSheet.RemoveAll();
    	codeSheet.SetFocusAfterProcess(0);    	
    	codeSheet.ShowDebugMsg(1);
		var sXml = codeSheet.GetSearchData("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param );
		codeSheet.LoadSearchData(sXml, {Sync:1});
    	//codeSheet.DoSearch("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param , {Sync:1});
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
 * @see ESM_SPC_0129 참조
 **/
var getSelectCodeList_oldParam="";
function getSelectCodeList(obj, cmd, param, reload, addOption){
	if(reload == undefined){
		reload=true;
	}
	// select tag options remove
	var opts=obj.options;
	for (i=(opts == null ? -1 : (opts.length - 1)); i >= 0; i--) {
		opts.remove(i);
	}
	// code search 
    //createCodeSheetObject();
    	codeSheet.RemoveAll();
    	codeSheet.ShowDebugMsg(false);
        var newParam="f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param;
        if(reload || getSelectCodeList_oldParam != newParam){
    		var sXml = codeSheet.GetSearchData("ESM_SPC_CODGS.do", newParam );
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
        for(var j=1 ; j <= RowCount(); j++){
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
function getFunctionName(){
	if(getFunctionName.caller == null){
		return "top";
	}
	else{
		var f=getFunctionName.caller;
		f=f + "";
		var pos=f.indexOf("(");
		var fname=f.substring(8, pos);
		pos=0;
		while(fname.charAt(pos) == ' ' || fname.charAt(pos) == '	'){
			pos++;
		}
		return fname.substring(pos);
	}
}

//============================================
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
        var iYr1=parseInt(yr1);
        var iWk1=parseInt(wk1);
        var iYr2=parseInt(yr2, 10);
        var iWk2=parseInt(wk2, 10);
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
function doSaveSheet(sheetObj, url, subParam, col, sAlert, f_callback){
	if(sAlert == undefined){sAlert=true;}
	if( col != undefined && col != null && col.length != 0){
		var oRows=sheetObj.FindCheckedRow(col);
		if( oRows.length == 0 ){			
			ComShowMessage("There is no data to save");
			return "NODATA";
		}
    }else if(sheetObj.IsDataModified()==0){
        ComShowMessage("There is no data to save");
        return "NODATA";
    }
    if(sAlert && ComShowConfirm (getMsg("SPC90010")) != 1){
         return "CANCEL";
    }
    if(f_callback != undefined && f_callback != null){
	    var funcExist=true;
	    var func;
		try{
			func=eval(f_callback);
		}catch(e){
			funcExist=false;
		}
		if(funcExist){
			func(sheetObj);
		}
    }    
    if(col == undefined) col=-1;     
//    OnSaveEnd(sheetObj, errMsg)
//    if(sheetObj.id == "t1sheet2"|| url=='ESM_SPC_0102GS.do') //t1sheet2_OnSaveEnd(sheetObj, "Err");
//    	sheetObj.DoSave(url, {Param:subParam ,Quest:"false",UrlEncode:"true", Sync:2} );
    sheetObj.DoSave(url, {Param:subParam ,Quest:"false",UrlEncode:"true", Sync:1} );
}

/*
 * 두개 이상의 Sheet에서 하나라도 수정된 Sheet가 존재하는지 체크
 */
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
/*
 * sheet안에서 name에 해당하는 combo에 value값이 있는지 체크
 */
function containsSheetCombo(name, value){
    var data=null;
    eval("data=getSheetCombo_"+name+"()");
    if(data == null) return false;
    var data="|"+data[0]+"|";
    return (data.indexOf("|"+value+"|") >= 0);
}
/**
 * func수행을 1ms waiting
 */
var objectState=new Array();
function wait(func, bOpenLayer){
	ComOpenWait(true, bOpenLayer);
	setTimeout(func+";ComOpenWait(false);", 1);
}
/*
 * 팝업창 띄우기
 */
var popupList=new Array();
popupList["SalesOffice"]=new Array("/opuscntr/COM_ENS_071.do", 770, 452);
popupList["ContractOffice"]=new Array("/opuscntr/COM_ENS_071.do", 770, 452);
popupList["Customer"]=new Array("/opuscntr/COM_ENS_041.do", 770, 475);
popupList["CustomerGroup"]=new Array("/opuscntr/COM_ENS_051.do", 770, 475);
popupList["POL"]=new Array("/opuscntr/COM_ENS_051.do", 900, 475);
popupList["POD"]=new Array("/opuscntr/COM_ENS_051.do", 900, 475);
popupList["Port"]=new Array("/opuscntr/COM_ENS_051.do", 900, 475);
popupList["UserID"]=new Array("/opuscntr/COM_ENS_091.do", 770, 577);
popupList["VVD"]=new Array("/opuscntr/COM_ENS_0B2.do", 770, 455);
popupList["Yard"]=new Array("/opuscntr/COM_ENS_061.do", 770, 475);
function spcPopup(module, param, width, height, callback, option, row, col){
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
     sheetObj.ReDraw=false;
     // clear
     var sRow=sheetObj.FindCheckedRow("hiddencheck") ;
     var arrRow=sRow.split("|");
     for (var idx=0; idx<arrRow.length-1; idx++){ 
         sheetObj.SetRowHidden(arrRow[idx],1);
         preStatus=sheetObj.GetRowStatus(arrRow[idx]);
         sheetObj.SetCellValue(arrRow[idx],"hiddencheck","0",0);
         //지원안함[확인요망]HANJIN: if(isRowSumable != true )
           //지원안함[확인요망]HANJIN: sheetObj.RowSumable(arrRow[idx])=false; 
//         sheetObj.SetRowStatus(arrRow[idx],preStatus);
         sheetObj.SetCellValue(arrRow[idx], "Status", preStatus, 0);
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
                  //지원안함[확인요망]HANJIN: if(isRowSumable != true)                  
                       //지원안함[확인요망]HANJIN: sheetObj.RowSumable(i)=true;
//                  sheetObj.SetRowStatus(i,preStatus);
                  sheetObj.SetCellValue(i, "Status", preStatus, 0);
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
                     //지원안함[확인요망]HANJIN: if(isRowSumable != true)  
                        //지원안함[확인요망]HANJIN: sheetObj.RowSumable(i)=true;
//                     sheetObj.SetRowStatus(i,preStatus);
                     sheetObj.SetCellValue(i, "Status", preStatus, 0);
                 }else{//sort되어 있기 때문에 더이상 loop를 돌필요 없다.
                     break;
                 }
             }      
         }           
    }
     sheetObj.ReDraw=true; 
     return filterCnt;
}
/*
 * 대소문자 전환
 */
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

/*
 * 초기화
 */
function resetAll(){
	ComResetAll();

    optionSetting();
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
/*
 * ComIsDate:입력값을 일자 Format 인지 확인
 * 날짜데이터 확인 후 Focus를 준다.
 */
function checkDate(){
	var obj = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()


	var value=obj.value;
	if(value.length == 0){
		return;
	}
	else if(!ComIsDate(obj)){//
		ComShowCodeMessage("COM12179");
		obj.select();
		obj.focus();
		ComJsEventStop(); //event.returnValue=false-->ComJsEventStop();
		return false;
	}
}
/*
 * 키값이 0-9사이 즉 숫자인지 확인
 */
function checkDateFormat(){
	
	var key =  ComGetEvent("keycode")? ComGetEvent("keycode") : event.charCode;//event.keyCode->ComGetEvent("keycode")

	if((key >= KEY_0 && key <= KEY_9)){
		return true;//event.returnValue=true-->return true
	}
	else{
		ComJsEventStop();//event.returnValue=false-->ComJsEventStop();
	}
}
/*
 * 날짜를 'YYYYmmDD' 포맷으로 변경해서 값을 세팅한다.
 */
function initDate(){
	var obj = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()
	
	var valueo=obj.value;
	var valuen=valueo.replace(/\/|\-|\./g,"");//정규식
	if(valueo != valuen)
	{
		obj.value=valuen;
		obj.focus();
		obj.select();
	}
}
/*
 * 날짜를 'YYYY-mm-DD'형식으로 변경한다.
 */
function convertDateFnc(){
	var obj = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()
	var value=obj.value;
	if(value.length == 8){
		value=value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6);
		obj.value=value;
	}
}
/*
 * Sheet 확대/축소시 사이즈 변경
 */
function toggleSheetSize(hideA1 , hideA2 , hideA3 , hideA4 , hideA5){
	var obj = ComGetEvent();
	var area = obj;
	var status="N";
	var zoomA1 = "";
	var zoomA2 = "";
	var zoomA3 = "";
	var zoomA4 = "";
	var zoomA5 = "";
	if(obj.maxStatus == undefined || obj.maxStatus == "N"){
		status="M";
	}
	var sheetId=obj.getAttributeNode("sheetId").value;

	if(sheetId == undefined ) return;
	var sheetObj=eval(sheetId);
	var isSheet=(( sheetObj) || ( sheetObj.IBSheetVersion)) ;
	var curRow=0;
	if(isSheet){
		curRow=sheetObj.GetSelectRow();
	}
	
	var posTop=0;
	if (hideA1 == undefined || hideA1 == null)	hideA1 = "zoomarea";
	if (hideA2 == undefined || hideA2 == null)	hideA2= "";
	if (hideA3 == undefined || hideA3 == null)	hideA3= "";
	if (hideA4 == undefined || hideA4 == null)	hideA4= "";
	if (hideA5 == undefined || hideA5 == null)	hideA5= "";
	
	zoomA1 = document.getElementById(hideA1)
	if (hideA2 != "") zoomA2 = document.getElementById(hideA2)
	if (hideA3 != "") zoomA3 = document.getElementById(hideA3)
	if (hideA4 != "") zoomA4 = document.getElementById(hideA4)
	if (hideA5 != "") zoomA5 = document.getElementById(hideA5)
	
	posTop=posTop + zoomA1.offsetHeight;
	
	if(status == "M"){
		var etcHeight=zoomA1.offsetHeight ;
		var sizeHeight = document.body.clientHeight ;
		
		zoomA1.style.display = "none";
		if(zoomA2 != "" ) zoomA2.style.display = "none";
		if(zoomA3 != "" ) zoomA3.style.display = "none";
		if(zoomA4 != "" ) zoomA4.style.display = "none";
		if(zoomA5 != "" ) zoomA5.style.display = "none";
		
		area.sheetHeight=sheetObj.GetSheetHeight();
		sheetObj.SetSheetHeight(sizeHeight -20);
		obj.maxStatus="M";
		obj.className="btn_toggle_show";
	}
	else{
		sheetObj.SetSheetHeight(area.sheetHeight);
		
		zoomA1.style.display = "";
		if(zoomA2 != "" ) zoomA2.style.display = "";
		if(zoomA3 != "" ) zoomA3.style.display = "";
		if(zoomA4 != "" ) zoomA4.style.display = "";
		if(zoomA5 != "" ) zoomA5.style.display = "";
		
		obj.maxStatus="N";
		obj.className="btn_toggle_hide";
	}	currSheet=sheetObj;
	if(isSheet){
		setTimeout("scrollToCurRow()", 1);
	}
}
/*
 * 최상단 데이터 행 Setting
 */
var currSheet=null;
function scrollToCurRow(){
	if(currSheet != null){
		if(currSheet.SetSelectRow()!= -1) currSheet.GetTopRow(currSheet.GetSelectRow()* 1);
		currSheet=null;
	}
}


/*
 * RGB값 
 */

var colors = new Array(
		"#e1f4e2", "#edffa8", "#ebf0ff"
	);
function getColors(i){
	if(i == undefined){
		return colors;
	}
	var size=colors.length;
	var arrs=new Array();
	for(var c=0 ; c < i ; c++){
		arrs[c]=colors[c % size];
	}
	return arrs;
}
function getColor(i){
	var size=colors.length;
	var arrs=new Array();
	if(i < 0){
		i=0;
	}
	return colors[i % size];
}

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
function selectDownExcelMethod(sheetObj){
    var rowCnt=sheetObj.RowCount();
	if(rowCnt == 0){
		ComShowCodeMessage("BKG00109");
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
/*	var sFeature="";
	sFeature=sFeature + "dialogHeight:230px;"
	sFeature=sFeature + "dialogWidth:300px;"
	sFeature=sFeature + "center:yes;"
	sFeature=sFeature + "resizable:no;"
	sFeature=sFeature + "scroll:no;"
	sFeature=sFeature + "status:no;"
*/	ComOpenPopup("ESM_SPC_XLS.do?sysCommUiTitle=Excel Download&sysCommUiNavigation=Excel Download", 250, 300, "callBackReturnString", "1,0", true);

}

function callBackReturnString(rtn){
	return rtn;
} 

/*
 * @param msg 보여질 메시지
 * @param 0 : 단순 alert창 (default),
 *        1 : return 값을 요하는 confirm
 * @param width : msg창의 width (default 400 )
 * @param height : msg창의 height  (default 300 )
 * @return value : String( windowType이 1 일경우에만 값이 유효함 )
    0 - CANCEL
	1 - YES 버튼을 눌렀음.
*/
function showMsgWindow(msg,windowType,width,height){
	var sFeature="";
	if(width == undefined ){
	    width="400"; 
	}
	if(height == undefined ){
	    height="300"; 
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
	var msgArr=new Array();
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
	ComOpenPopup("ESM_SPC_MSG.do?windowType="+windowType, width, height, "callBackReturnString", "1,0", true);

	//var rtn=window.showModalDialog("/opuscntr/ESM_SPC_MSG.do?windowType="+windowType, msgArr, sFeature);
	//return rtn;
}
function getStringToArray(msg,size){
	var len=msg.length;
	var msgArr=new Array();
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



function getEtcData(xml, key){
	
	var xmlDoc = ComGetXmlDoc(xml);
	if (xmlDoc == null) return;
	var xmlRoot = xmlDoc.documentElement;

	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null) return;

	var etcNodes = etcDataNode.childNodes;
	if (etcDataNode == null) return;

	var etcs=new Array();
	
	for ( var i = 0; i < etcNodes.length; i++) {
		if (etcNodes[i].nodeType != 1)
			continue;

		var  strText = "";
		if (etcNodes[i].firstChild != null) {
			strText = etcNodes[i].firstChild.nodeValue;
		}
		
		etcs[etcNodes[i].attributes[0].nodeValue]=strText;
		
	}
	return etcs;
}


///*======================== 단축키 설정으로 인해 추가된 FUNCTION ========================*/
///*function spcKeyAction(uiname , e){*/
//function spcKeyAction(){    
//	
//	var evt = (window.event)?window.event:arguments[0];
//	
//	//var evt = event.srcElement || arguments[0].target;
//
//	var keycode =  ComGetEvent("keycode");
//
//    //Short Cut을 적용할 UI, 화면별로 적용할 shortKey를 설정한다.
//	if(document.form.uiname != undefined){
//		uiname = document.form.uiname.value;
//		//Enter:13 일반적인 Enter는 onShortKeyEnter()에서 처리하지만 IBMultiCombo의 Enter는 각 화면단 .js에서 Object별로 따로 처리한다.
//	    if(keycode==13) {onShortKeyEnter();} 
//	    //Tab처리
//	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028') if(keycode==9) {search_OnKeyDownTab();} 
//	    //Sheet간 이동 1:49 - 7:55
//	    if(evt.altKey && keycode==49) onShortKeyAlt1();
//	    if(uiname !='ESM_SPC_0102' || uiname !='ESM_SPC_0056') if(evt.altKey && keycode==50) onShortKeyAlt2();
//	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028' || uiname=='ESM_SPC_0024'){
//	        if(evt.altKey && keycode==51) onShortKeyAlt3();
//	        if(evt.altKey && keycode==52) onShortKeyAlt4();
//	    }
//	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0024') if(evt.altKey && keycode==53) onShortKeyAlt5();    
//	    //if(evt.altKey && keycode==54) onShortKeyAlt6();
//	    //if(evt.altKey && keycode==55) onShortKeyAlt7();
//	    //조건간 이동 ,(<):188, .(>):190
//	    if(evt.altKey && keycode==188) onShortKeyAltComma();
//	    if(uiname !='ESM_SPC_0070') if(evt.altKey && keycode==190) onShortKeyAltPeriod();
//	    //화면 확대/축소 38:방향키 위(sheet1 toggle), 40:방향키 아래(sheet2 toggle)
//	    if(uiname != 'ESM_SPC_0045' || uiname !='ESM_SPC_0056' || uiname !='ESM_SPC_0024' || uiname !='ESM_SPC_0070') {
//	        //bottleneck화면, Inquiry by T/S Port, NoShow화면 Toggle없음
//	       if(evt.altKey && keycode==38) onShortKeyAltUp(); //sheet1 toggle
//	       if(evt.altKey && keycode==40) onShortKeyAltDown(); //sheet2 toggle
//	    }
//	    //o:79 (Confirm), r:82(Retrieve), n:78(New), s:83(Save, control option save)
//	    //i:73(Edit), x:88(control option cancel)
//	    //b:66(Bottle neck), k:75(SKD Inquiry), m:77(BSA Management)
//	    if(evt.altKey && keycode==82) onShortKeyAltR(); //Retrieve
//	    if(evt.altKey && keycode==78) onShortKeyAltN(); //New
//	    if(uiname == 'ESM_SPC_0042' ||uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047' 
//	      || uiname == 'ESM_SPC_0070' || uiname == 'ESM_SPC_0102') {
//	        if(evt.altKey && keycode==83) onShortKeyAltS(); //Save, control option save
//	    }
//	    if(uiname == 'ESM_SPC_0042' ||uiname == 'ESM_SPC_0047'){ //Allocation화면에만 적용
//	        if(evt.altKey && keycode==73) onShortKeyAltI(); //Edit
//	        if(evt.altKey && keycode==66) onShortKeyAltB(); //Bottle neck
//	        if(evt.altKey && keycode==77) onShortKeyAltM(); //BSA Management
//	        if(evt.altKey && keycode==88) onShortKeyAltX(); //control option cancel           
//	    }
//	    if(uiname == 'ESM_SPC_0102'){//Forecast화면에만 적용
//	        if(evt.altKey && keycode==79) onShortKeyAltO(); //Confirm
//	    }
//	    if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047') {
//	        if(evt.altKey && keycode==75) onShortKeyAltK();//SKD Inquiry
//	    }
//	    //+plus:187
//	}
//}
////---------------------------------------------------------------------------------------------
////Enter처리:MultiCombo내에서 혹은 검색조건에서 Enter키를 누른 경우
////trade선택 부분에서 Enter를 누른경우
//function trade_OnKeyDown_t(comObj, KeyCode, Shift){ 
//    if(KeyCode == 13) { //Enter키의 경우
//        alarmMessage("trade_OnKeyDown_t Enter");
//        comboEnterKeyAction(comObj);
//    }
//}
////subtrade선택 부분에서 Enter를 누른경우
//function subtrade_OnKeyDown_t(comObj, KeyCode, Shift){
//    if(KeyCode == 13) { //Enter키의 경우
//        alarmMessage("subtrade_OnKeyDown_t Enter");
//        comboEnterKeyAction(comObj, KeyCode, Shift);
//    }
//}
////lane선택 부분에서 Enter를 누른경우
//function lane_OnKeyDown_t(comObj, KeyCode, Shift){
//    if(KeyCode == 13) { //Enter키의 경우
//        alarmMessage("lane_OnKeyDown_t Enter");
//        comboEnterKeyAction(comObj, KeyCode, Shift);
//    }
//}
////salesOffice선택 부분에서 Enter를 누른경우
//function salesOffice_OnKeyDown(comObj, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 13) { //Enter키의 경우
//	        alarmMessage("salesOffice_OnKeyDown Enter");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
//	    }
//	}
//}
////subOffice선택 부분에서 Enter를 누른경우
//function subOffice_OnKeyDown(comObj, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 13) { //Enter키의 경우
//	        alarmMessage("subOffice_OnKeyDown Enter");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
//	    }
//	}
//}
////salesRep선택 부분에서 Enter를 누른경우
//function salesRep_OnKeyDown(comObj, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 13) { //Enter키의 경우
//	        alarmMessage("salesRep_OnKeyDown Enter");
//	        var uiname=document.form.uiname.value;   
//	        if(uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
//	    }
//	}
//}
////RHQ선택 부분에서 Enter를 누른경우
//function rhq_txt_OnKeyDown_t(comObj, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 13) { //Enter키의 경우
//	        alarmMessage("rhq_txt_OnKeyDown_t Enter");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0022') comboEnterKeyAction(comObj, KeyCode, Shift);
//	    }
//	}
//}
////RHQ선택 부분에서 Enter를 누른경우2
//function rhq_OnKeyDown_t(comObj, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 13) { //Enter키의 경우
//	        alarmMessage("rhq_onKeyDown_t Enter");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') comboEnterKeyAction(comObj, KeyCode, Shift);
//	    }
//	}
//}
////IBMultiCombo를 사용한 Combobox에서 Enter키를 Retrieve로 사용
//function comboEnterKeyAction(comObj, KeyCode, Shift){
//    alarmMessage("press comboEnterKeyAction");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        var obj=uiname=='ESM_SPC_0102'?sheetObjects[1]:sheetObjects[0];
//        //102번은 첫번째 Sheet를 사용하지 않게 되어 있음
//        //////////////////////////////////////////////////////////////////////////////////////////
//        if(onShortKeyAltR() == false){
//            //onShortKeyAltR의 return값이 false이거나 undifined라서 이리처리함. 
//            //validation검사후 Focus를 자동으로 갖는다.
//        } else if(obj.LastCol() >= obj.HeaderRows()) {
//            //조회가 완료된경우 데이터가 있으면 sheet에, 조회된 데이터가 없으면 해당 Object에 Focus를 준다.
//            if(obj.RowCount()>0) {
//                if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows(), "qta");
//                else if(uiname == 'ESM_SPC_0102') obj.SelectCell(obj.HeaderRows()+ 2, "fcast_ttl_qty");
//                else obj.SelectCell(obj.HeaderRows(), "VVD");//첫번째 데이터 행을 Select함
//            }
//            else comObj.focus();
//        }
//        //////////////////////////////////////////////////////////////////////////////////////////
//    }
//}
///*
// * 단축키 기능 Enter:sheet조회
// */
//function onShortKeyEnter(){
//    alarmMessage("press onShortKeyEnter");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//    	var eventSrc = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()
//    	var srcName = eventSrc.id || eventSrc.name;
//        var obj=uiname == 'ESM_SPC_0102'?sheetObjects[1]:sheetObjects[0]; 
//        //102번은 첫번째 Sheet를 사용하지 않게 되어 있음
//        //////////////////////////////////////////////////////////////////////////////////////////
//        //상단 검색 조건에 Focus가 있는 경우 sheet1 데이터 조회
//        if(srcName == 'vvd' || srcName == 'year' || srcName=='month' || srcName == 'week' || srcName == 'duration' 
//              || srcName == 'fcast' || srcName == 'bound' || srcName == 'office' || srcName == 'year1' 
//              || srcName == 'week1' || srcName == 'year2' || srcName == 'week2' || srcName == 'rhq_txt' 
//              || srcName == 'only_vvd' || srcName == 'onc_ipc' || srcName == 'sales_office' 
//              || srcName == 'sDate' || srcName == 'eDate' || srcName == 'port' || srcName == 'org'
//              || srcName == 'type') {
//            if(onShortKeyAltR() == false) {
//               //onShortKeyAltR의 return값이 false이거나 undifined라서 이리처리함. 
//               //validation검사후 Focus를 자동으로 갖는다.
//              } else if(obj.RowCount()<1 && obj.LastCol() >= obj.HeaderRows()) {
//                //조회는 완료되었으나 데이터가 없는 경우 이벤트가 발생한 곳으로 다시 Focus를 준다.
//                eventSrc.focus();
//            }         
//        }
//        ////////////////////////////////////////////////////////////////////////////////////////// 
//        //나머지의 경우는 상단 Sheet에 조회된 데이터가 있는 경우 하단 Sheet조회
//        else if(obj.RowCount()>0 &&
//            (uiname=='ESM_SPC_0042' || uiname=='ESM_SPC_0044' || uiname=='ESM_SPC_0047' 
//                || uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028')){
//            //sheet1에 조회된 데이터가 있는 경우 sheet2의 데이터 조회
//            sheet1_OnDblClick(obj, obj.GetSelectRow(), obj.GetSelectCol());
//            obj=sheetObjects[1];
//            obj.SelectCell(obj.HeaderRows(), "asgn_ttl_qty");
//        }  
//        //////////////////////////////////////////////////////////////////////////////////////////
//    }
//}
////---------------------------------------------------------------------------------------------
////---------------------------------------------------------------------------------------------
////Tab처리
////sheet1에서 Tab을 누르면 하단 검색조건으로 이동한다.
//function sheet1_OnKeyDown(sheetObj, Row,Col, KeyCode, Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("sheet1_OnKeyDown Tab");
//	        var uiname=null;
//	        uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0045') document.form.year1.focus();
//	        else if(uiname == 'ESM_SPC_0022') {
//	            var selIndex=tabObjects[0].GetSelectedIndex();
//	            if(selIndex == 0) document.form.rhq_gso1[0].focus();
//	            else if(selIndex == 1) document.form.rhq_gso2[0].focus();
//	            else if(selIndex == 2) document.form.rhq_gso3[0].focus();
//	            else if(selIndex == 3) document.form.rhq_gso4[0].focus();
//	            else if(selIndex == 4) document.form.rhq_gso5[0].focus();
//	        } else if(uiname == 'ESM_SPC_0028'){
//	            var selIndex=tabObjects[0].GetSelectedIndex();
//	            if(selIndex == 0) document.form.chkPol.focus();
//	            else if(selIndex == 1) document.form.chkPolPodS[0].focus();
//	            else if(selIndex == 2) document.form.chkPolPodC[0].focus();
//	        }        
//	        else if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
//	        else document.form.chkOfc.focus();
//	    }
//	}
//}
////sheet2에서 Tab을 누르면 상단 검색조건으로 이동한다.
//function sheet2_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("sheet2_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') document.form.type.focus();
//	        if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0045') document.form.year1.focus();
//	        else document.form.year.focus();
//	    }/* else if(KeyCode == 187){ //+
//	        alarmMessage("sheet2_OnKeyDown +");    
//	        sheet2_OnClick(sheetObj, Row, Col);
//	    }*/
//	}
//}
//function search_OnKeyDownTab(){
//	if(document.form.uiname != undefined){
//		var uiname=document.form.uiname.value;
//
//    	var eventSrc = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()
//    	var srcName = eventSrc.id || eventSrc.name;
//	    if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0056'){
//	        if(srcName == 'type1'||srcName == 'type2'||srcName == 'type3'||srcName == 'type4'){
//	            alarmMessage("search_OnKeyDownTab");
//	            var selIndex=tabObjects[0].GetSelectedIndex();//선택된 Tab
//	            if(selIndex == 0 && srcName == 'type1') sheetObjects[0].SelectCell(sheetObjects[0].HeaderRows(), "qta");
//	            else if(selIndex == 1 && srcName == 'type2') sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows(), "qta");
//	            else if(selIndex == 2 && srcName == 'type3') sheetObjects[2].SelectCell(sheetObjects[2].HeaderRows(), "qta");
//	            else if(selIndex == 3 && srcName == 'type4') sheetObjects[3].SelectCell(sheetObjects[3].HeaderRows(), "qta");
//	        }
//	    } else if(uiname == 'ESM_SPC_0024'){
//	        if(srcName == 'ofcCheck'){
//	            alarmMessage("search_OnKeyDownTab");
//	            var selIndex=tabObjects[0].GetSelectedIndex();//선택된 Tab
//	            if(selIndex == 1) sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows(), "Fcast");
//	        }
//	        //
//	    }	
//	}
//}
////ESM_SPC_0022, ESM_SPC_0028번화면의 하단Tab의 1번째 sheet에서 Tab키 누른 경우
////ESM_SPC_0024, ESM_SPC_0070번화면의 1번째 sheet에서 Tab키 누른 경우
//function t1sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t1sheet1_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') document.form.year.focus();
//	        else document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0022번화면의 하단Tab의 2번째 sheet에서 Tab키 누른 경우
//function t2sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t2sheet1_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0022번화면의 하단Tab의 3번째 sheet에서 Tab키 누른 경우
//function t3sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t3sheet1_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0022번화면의 하단Tab의 4번째 sheet에서 Tab키 누른 경우
//function t4sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t4sheet1_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0102, ESM_SPC_0028화면 sheet에서 Tab키 누르면 상단 검색조건으로 이동한다.
////ESM_SPC_0024, ESM_SPC_0070번화면의 2번째 sheet에서 Tab키 누른 경우
//function t1sheet2_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		var uiname=document.form.uiname.value;
//	    if(KeyCode == 9) {
//	        alarmMessage("t1sheet2_OnKeyDown Tab");
//	        if(uiname == 'ESM_SPC_0102' || uiname == 'ESM_SPC_0024'|| uiname == 'ESM_SPC_0070') document.form.year.focus();
//	        else if(uiname == 'ESM_SPC_0028') document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0028번화면의 하단Tab의 2번째 sheet에서 Tab키 누른 경우
////ESM_SPC_0024번화면의 3번째 sheet에서 Tab키 누른 경우
//function t1sheet3_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t1sheet3_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0024') document.form.year.focus();
//	        else document.form.year1.focus();
//	    }
//	}
//}
////ESM_SPC_0024번화면의 4번째 sheet에서 Tab키 누른 경우
//function t1sheet4_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t1sheet4_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        if(uiname == 'ESM_SPC_0024') document.form.year.focus();
//	    }
//	}
//}
////ESM_SPC_0024번화면의 5번째 sheet에서 Tab키 누른 경우
//function t1sheet5_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
//	if(document.form.uiname != undefined){
//		if(KeyCode == 9) {
//	        alarmMessage("t1sheet5_OnKeyDown Tab");
//	        var uiname=document.form.uiname.value;
//	        document.form.year.focus();
//	    }
//	}
//}
////---------------------------------------------------------------------------------------------
////---------------------------------------------------------------------------------------------
////sheet간 이동 1, 2, 3, 4, 5
///*
// * Sheet1
// */
//function onShortKeyAlt1(){
//    alarmMessage("press onShortKeyAlt1");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        var obj=sheetObjects[0];
//        if(uiname == 'ESM_SPC_0024'){
//            tabObjects[0].SetSelectedIndex(0);//Tab 1번째 Sheet활성화
//            obj.SelectCell(obj.HeaderRows(), "Fcast");
//        } else if(uiname == 'ESM_SPC_0070'){
//            tabObjects[0].SetSelectedIndex(0);//Tab 1번째 Sheet활성화
//            obj.SelectCell(obj.HeaderRows(), "vvd");
//        } else if(uiname == 'ESM_SPC_0045') {
//            if(obj.RowCount()>0) {
//                tabObjects[0].SetSelectedIndex(0);//첫번째 Tab 활성화
//                var viewFirstRow=0;
//                for(var k=1; k<obj.RowCount(); k++) {
//                    if(!obj.GetRowHidden(k)) {
//                      viewFirstRow=k;
//                      break;
//                    }
//                }
//                obj.focus();
//                obj.SelectCell(viewFirstRow, "lod_cur_teu_qty"); //첫행에 Focus
//            }
//        } else if(uiname == 'ESM_SPC_0102') {
//            obj=sheetObjects[1];//두번째 Sheet(102번은 이렇게 되어 있음)
//            obj.SelectCell(obj.HeaderRows(), "fcast_ttl_qty");//sheet의 첫번째 row의 fcast물량에 Focus를 둔다
//        } else {
//            if(obj.RowCount()>0){//조회된 데이터가 있는 경우
//               obj.SelectCell(obj.HeaderRows(), "VVD");//sheet의 첫번째 row의 vvd에 focus
//            } //else {ComShowMessage(getMsg('COA10005', 'First Sheet'));}
//        }
//    }
//}
///*
// * Sheet2
// */
//function onShortKeyAlt2(){
//    alarmMessage("onShortKeyAlt2");
//    if(document.form.uiname != undefined){
//    	var obj=sheetObjects[1];
//        var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'|| uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') {
//            //if(obj.RowCount>0){
//                var selIdx=(uiname=='ESM_SPC_0024'||uiname=='ESM_SPC_0070')?1:0;
//                tabObjects[0].SetSelectedIndex(selIdx);//Sheet활성화
//                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows(), "qta");
//                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows(), "proj_teu");
//                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows(), "Fcast");
//                else if(uiname == 'ESM_SPC_0070') obj.SelectCell(obj.HeaderRows(), "month");
//            //}
//        } else if(uiname == 'ESM_SPC_0045') {
//            //setTimeout("dummy_fuction()", 100);
//            //if(obj.RowCount>0) {
//                tabObjects[0].SetSelectedIndex(1);//첫번째 Tab 활성화
//                var viewFirstRow=0;
//                for(var k=1; k<obj.RowCount(); k++) {
//                    if(!obj.GetRowHidden(k)) {
//                      viewFirstRow=k;
//                      break;
//                    }
//                }
//                obj.focus();          
//                obj.SelectCell(viewFirstRow, "lod_cur_teu_qty"); //첫행에 Focus
//            //}
//        } else {
//            if(sheetCnt>1) {
//                if(obj.RowCount()>0){ //조회된 데이터가 있는 경우
//                    obj.SelectCell(obj.HeaderRows(), "asgn_ttl_qty");//sheet의 첫번째 row의 aloc에 focus
//                }
//            }
//        }
//    }
//}
////ESM_SPC_0022,ESM_SPC_0028,ESM_SPC_0024
//function onShortKeyAlt3(){
//    alarmMessage("onShortKeyAlt3");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'||uiname == 'ESM_SPC_0024') {
//            var obj=sheetObjects[2];
//            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
//                var selIdx=uiname == 'ESM_SPC_0024'?2:1;
//                tabObjects[0].SetSelectedIndex(selIdx);//Sheet활성화
//                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows(), "qta");
//                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows(), "proj_teu");
//                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows(), "Fcast");
//            //}
//        }
//    } 
//}
////ESM_SPC_0022,ESM_SPC_0028,ESM_SPC_0024
//function onShortKeyAlt4(){
//    alarmMessage("onShortKeyAlt4");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'||uiname == 'ESM_SPC_0024') {
//            var obj=sheetObjects[3];
//            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
//                var selIdx=uiname == 'ESM_SPC_0024'?3:2;
//                tabObjects[0].SetSelectedIndex(selIdx);//Tab 3번째 Sheet활성화
//                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows(), "qta");
//                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows(), "proj_teu");
//                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows(), "Fcast");
//            //}
//        }
//    } 
//}
////ESM_SPC_0022,ESM_SPC_0024
//function onShortKeyAlt5(){
//    alarmMessage("onShortKeyAlt5");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0024') {
//            var obj=sheetObjects[4];
//            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
//                var selIdx=uiname == 'ESM_SPC_0024'?4:3;
//                tabObjects[0].SetSelectedIndex(selIdx);//Tab 4번째 Sheet활성화
//                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows(), "qta");
//                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows(), "Fcast");
//            //}
//        }
//    }
//}
////---------------------------------------------------------------------------------------------
////---------------------------------------------------------------------------------------------
////,(<) .(>)키로 상단 하단 간 검색 조건 이동
///*
// * 단축키 기능 Alt+,: 첫번째 검색 조건 영역으로 이동
// */
//function onShortKeyAltComma(){
//    alarmMessage("press onShortKeyAltComma");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
//        else if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0045') {
//            document.form.year1.focus();
//        }
//        else document.form.year.focus();
//    }
//}
///*
// * 단축키 기능 Alt+.: 두번째 검색 조건 영역으로 이동
// */
//function onShortKeyAltPeriod(){
//    alarmMessage("press onShortKeyAltPeriod");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        if(uiname == 'ESM_SPC_0045') {      
//            if(tabObjects[0].GetSelectedIndex()== 0) document.form.dataSelect[0].focus();
//            else document.form.dataSelect1[0].focus();
//        }
//        else if(uiname == 'ESM_SPC_0056') document.form.chkTYP.focus();
//        else if(uiname == 'ESM_SPC_0102') document.form.chkDs2LaneInfo.focus();
//        else if(uiname == 'ESM_SPC_0022') {
//            var selIndex=tabObjects[0].GetSelectedIndex();
//            if(selIndex == 0) document.form.rhq_gso1[0].focus();
//            else if(selIndex == 1) document.form.rhq_gso2[0].focus();
//            else if(selIndex == 2) document.form.rhq_gso3[0].focus();
//            else if(selIndex == 3) document.form.rhq_gso4[0].focus();
//            else if(selIndex == 4) document.form.rhq_gso5[0].focus();
//        } else if(uiname == 'ESM_SPC_0028') {
//            var selIndex=tabObjects[0].GetSelectedIndex();
//            if(selIndex == 0) document.form.chkPol.focus();
//            else if(selIndex == 1) document.form.chkPolPodS[0].focus();
//            else if(selIndex == 2) document.form.chkPolPodC[0].focus();
//        } else if(uiname == 'ESM_SPC_0024') {
//            var selIndex=tabObjects[0].GetSelectedIndex();
//            if(selIndex == 1) document.form.ofcCheck.focus();
//        } else document.form.chkOfc.focus();
//    }
//}
////---------------------------------------------------------------------------------------------
////---------------------------------------------------------------------------------------------
////방향키 위, 아래로 상단 하단 Toggle기능 구현
///*
// * 단축키 기능 Alt+방향키↑: Sheet1확대/축소
// */
//function onShortKeyAltUp(){
//    alarmMessage("onShortKeyAltUp");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        var obj=uiname=='ESM_SPC_0102'?sheetObjects[1]:sheetObjects[0];
//        if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047'
//           || uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028'|| uiname == 'ESM_SPC_0056'){
//            //sheet1에 조회된 데이터가 존재하고, sheet1이 활성화 되어 있을때
//            if(document.form.maxi[1].maxStatus != 'M') {//sheet2가 Toggle되지 않은 상태
//                //처음에 포커스가 있었던 곳으로 Focus이동
//                obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//                document.form.maxi[0].focus();
//                //click이벤트 발생
//                document.form.maxi[0].click();
//                //처음에 포커스가 있었던 곳으로 Focus이동
//                obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//            }
//        } else {//ESM_SPC_0102의 경우 sheet가 하나임
//            //처음에 포커스가 있었던 곳으로 Focus이동
//            obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//            document.form.maxi.focus();
//            //click이벤트 발생
//            document.form.maxi.click();
//            //처음에 포커스가 있었던 곳으로 Focus이동
//            obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//        }
//    }
//}
///*
// * 단축키 기능 창축소:Alt+방향키↓: Sheet2확대/축소
// */
//function onShortKeyAltDown(){
//    alarmMessage("onShortKeyAltDown");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        var obj=sheetObjects[1];
//        var selIndex=0; 
//        //sheet2에 조회된 데이터가 존재하고, sheet2가 활성화 되어 있을때
//        if(document.form.maxi[0].maxStatus != 'M') { //sheet1이 Toggle되지 않은 상태
//            if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028'){
//                selIndex=tabObjects[0].GetSelectedIndex();
//                if(selIndex == 0) obj=sheetObjects[1];
//                else if(selIndex == 1) obj=sheetObjects[2];
//                else if(selIndex == 2) obj=sheetObjects[3];
//                else if(selIndex == 3) obj=sheetObjects[4];
//                else if(selIndex == 4) obj=sheetObjects[5];
//            }
//            //sheet2 포커스 이동
//            obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//            document.form.maxi[selIndex+1].focus();
//            //click이벤트 발생
//            document.form.maxi[selIndex+1].click();
//            //처음에 포커스가 있었던 곳으로 Focus이동
//            obj.SelectCell(obj.GetSelectRow(), obj.GetSelectCol());
//        }
//    }
//}
////---------------------------------------------------------------------------------------------
////---------------------------------------------------------------------------------------------
////버튼에 대한 단축키
///*
// * 단축키 기능 Alt+R :상단 sheet조회
// */
//function onShortKeyAltR(){
//    alarmMessage("press onShortKeyAltR");  
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        var obj=uiname == 'ESM_SPC_0102'?sheetObjects[1]:sheetObjects[0];
//        var rtn=null;
//    	if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0047') {
//    	    cancelControlOption(obj);
//            enableButtons(false);
//    	} else if(uiname == 'ESM_SPC_0044'){
//    		enableButtons(false);
//    	}
//    	rtn=doActionIBSheet(obj, document.form, IBSEARCH);
//        if(obj.RowCount()>0) {
//            if(uiname == 'ESM_SPC_0102') obj.SelectCell(obj.HeaderRows()+ 2, "fcast_ttl_qty");
//            else obj.SelectCell(obj.HeaderRows(), "VVD");//첫번째 데이터 행을 Select함
//        }
//        return rtn;
//    }
//}
///*
// * 단축키 기능 Alt+N :검색조건 초기화
// */
//function onShortKeyAltN(){
//    alarmMessage("press onShortKeyAltN");
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//        document.form.btn_new.click();
//        if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0045') document.form.year1.focus();
//        else if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
//        else {
//        	//기존 New버튼기능에 focus추가함
//        	document.form.year.focus();
//        }
//    }
//}
///*
// * 단축키 기능 Alt+S: Save --Edit의 Save일경우와 일반 Save를 구분한다.
// */
//function onShortKeyAltS(){
//    alarmMessage("press onShortKeyAltS"); 
//    if(document.form.uiname != undefined){
//    	var uiname=document.form.uiname.value;
//    	var eventSrc = event.target || ComGetEvent();//event.srcElement -->ComGetEvent()
//    	var srcName = eventSrc.id || eventSrc.name;
//        //control option 저장
//        if((uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047') &&
//            (srcName == 'chkPort' || srcName == 'chkHC' || srcName == 'chk45' || srcName == 'chk53' || srcName == 'chkRFR' || srcName == 'chkWGT')){
//                document.form.btng_controlSave.click();
//        } else {
//            //document.form.btn_save.click();
//            var sobj=null; 
//            if(sheetCnt>1) sobj=sheetObjects[1];
//            else if(sheetCnt == 1) sobj=sheetObjects[0];
//            if(sobj != null) {
//                //SelectCell을하면 OnSelectCell()을 호출하므로 강제 발생시켜준다.
//                sobj.SelectCell(sobj.GetSelectRow(), sobj.GetSelectCol());
//                //buttonAction("btn_save");
//                document.form.btn_save.click();
//            }
//        }
//    }
//}
///*
// * 단축키 기능 Alt+O: Confirm단축키.
// */
//function onShortKeyAltO(){
//    alarmMessage("press onShortKeyAltO"); 
//    document.form.btn_confirm.click();
//}
///*
// * 단축키 기능 Alt+I: Control Option이 활성화 되고 Combobox에 Focus
// */
//function onShortKeyAltI(){
//    alarmMessage("press onShortKeyAltI"); 
//   //buttonAction("btng_controlEdit");
//   document.form.btng_controlEdit.click();
//   document.form.chkPort.focus();
//}
//function onShortKeyAltX(){
//    alarmMessage("press onShortKeyAltX");
//    //cancelControlOption(sheetObjects[0]);
//    document.form.btng_controlCancel.click();
//}
///*
// * 단축키 기능 Alt+B: Bottle Neck화면 팝업
// */
//function onShortKeyAltB(){
//    alarmMessage("press onShortKeyAltB"); 
//    document.form.btng_bottleneck.click();
//}
///*
// * 단축키 기능 Alt+K: VSL SKD 화면 팝업
// */
//function onShortKeyAltK(){
//    alarmMessage("press onShortKeyAltK"); 
//    document.form.btng_skd.click();
//}
///*
// * 단축키 기능 Alt+M: BSA Management 화면 팝업
// */
//function onShortKeyAltM(){
//    alarmMessage("press onShortKeyAltM"); 
//    document.form.btng_bsa.click();
//}
////---------------------------------------------------------------------------------------------
/*
 * 디코딩용 메시지
 */
function alarmMessage(msg){
    //ComShowMessage(msg);    
}
/*======================== 단축키 설정으로 인해 추가된 FUNCTION ========================*/
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
	// SPC - Transaction
	msgs['SPC90001']='There is modified data.\n\n Do you want to process?';  
	msgs['SPC90010']='Do you want to save?';    
	msgs['SPC90020']='Do you want to delete?';    
	msgs['SPC90030']='Existing data will be deleted and saved.\n\n Do you want to save?';    
	msgs['SPC90040']='Existing data will be deleted and re-created.\n\n Do you want to process?';    
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
	msgs['SPC90201']="It's not appropriate Number format."; 
	
	if (msgs[msgNo.toUpperCase()])
		return msgs[msgNo.toUpperCase()];
	return "";
}
var txtTypeSize=new Array("|TEU", "|HC", "|45'", "|53'", "|Reefer", "|WT\n(M/T)");
var HeadTypeSize1=new Array(0, 1, 2, 3, 4, 5);
var HeadTypeSize2=new Array(0, 1, 2, 3, 4, 5);
var sizeColNameT="";
if(sizeColName == undefined){
	sizeColNameT=new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt");
}
else{
	sizeColNameT=sizeColName;
}
var sizeColName=sizeColNameT;
var txtHeadVolume="Volume";
var txtDelem="|";


var defaultWidth=60;
var wideWidth=90;
//시트의 해당 셀에 값을 기존 셀의 값에 더하여 설정한다.
function addGetCellValue(sheetObj, row, col, value, forceTrigger){
	if(forceTrigger == undefined){
		forceTrigger=true;
	}
//	log("addGetCellValue: " + row + " - " + col + " - " + sheetObj.GetCellValue(row, col));
	var curValue=sheetObj.GetCellValue(row, col)*1;
	var newValue=curValue + value;
	if(newValue < 0){
		newValue=0;
	}
//	log("addGetCellValue: " + row + " - " + curValue + " - " + value + " - " + newValue + " - " + forceTrigger);
	if(forceTrigger){
		selectedCell_OldValue=curValue;
		sheetObj.SetCellValue(row, col,newValue);
	}
	else{
		sheetObj.SetCellValue(row, col,newValue,0);
	}
}
function setInitValue(sheetObj, rows, cols, val){
	if(rows.constructor == String){
		rows=toArray(rows);
	}
	if(cols.constructor == String){
		cols=toArray(cols);
	}
	for(var r=0 ; r < rows.length ; r++){
		for(var c=0 ; c < cols.length ;c++){
			sheetObj.SetCellValue(rows[r], cols[c],val,0);
		}
	}
}
function toArray(str){
	var arr=new Array();
	if(str.indexOf("..") >= 0){
		str=str.split("..");
		var s=str[0]*1;
		var e=str[1]*1;
		for(var i=s ; i <= e ; i++){
			arr[i - s]=i;
		}
	}
	else{
		arr=str.split("|");
	}
	return arr;
}
function copyData(sheetObj, sRow, eRow, frCols, toCols, trigger){
	var fCols=frCols.split("|");
	var tCols=toCols.split("|");
	var cols=(fCols.length > tCols.length)?tCols.length:fCols.length;
	if(trigger){
    	for(var r=sRow ; r <= eRow ; r++){
    		for(var c=0 ; c < cols ; c++){
    			sheetObj.SetCellValue(r, tCols[c],sheetObj.GetCellValue(r, fCols[c]));
    		}
    	}
    }
    else{
    	for(var r=sRow ; r <= eRow ; r++){
    		for(var c=0 ; c < cols ; c++){
    			sheetObj.SetCellValue(r, tCols[c],sheetObj.GetCellValue(r, fCols[c]),0);
    		}
    	}
    }
}
function allocate(rowData, value, baseValue, isAdd){
	if(isAdd == undefined) isAdd=false;
	var size=rowData.length;
	var total=value;
	var unitValue=total / baseValue;
	for(var i=0 ; i < size ; i++){
		var rVal=Math.round((unitValue * rowData[i][2]));
		if(total < rVal){
			rVal=total;
		}
		total=total - rVal;
		rowData[i][1]=(isAdd?rowData[i][1]:0) + rVal;
	}
	if(total > 0){
		if(total <= size){
			unitValue=total / baseValue;
			for(var j=0 ; j < size ; j++){
				var rVal=Math.ceil((unitValue * rowData[j][2]));
				rowData[j][1]=rowData[j][1] + rVal;
				total=total - rVal;
				if(total <= 0){
					return;
				}
			}
		}
		else{
			allocate(rowData, total, baseValue, true);
		}
	}
}
function compareRowInfo(o1, o2){
	return o2[2] - o1[2];
}
var targetCellOrgValue=0;
function setCellValues(sheetObj, rowData, col, trigger){
	var size=rowData.length;
	if(trigger){
		for(var i=0 ; i < size ; i++){
			selectedCell_OldValue=rowData[i][3];
			sheetObj.SetCellValue(rowData[i][0], col,rowData[i][1]);
		}
	}
	else{
		for(var i=0 ; i < size ; i++){
			sheetObj.SetCellValue(rowData[i][0], col,rowData[i][1],0);
		}
	}
}
function filterTree(sheetObj, col, value, flag, childCntCol){
	var row=0;
	var childCnt=0;
	row=sheetObj.FindText(col, value, row + 1);
	while(row > 0){
		sheetObj.SetRowHidden(row,flag);
		if(sheetObj.GetRowExpanded(row)){
			childCnt=0;
		}
		else{
			childCnt=sheetObj.GetCellValue(row, childCntCol)*1;
		}
		row=sheetObj.FindText(col, value, row + 1 + childCnt);
	}
}
function controlRowFilter(sheetObj){
	sheetObj.RenderSheet(0);
	var formObj=document.form;
	var tstatus=formObj.chkOCN.checked || formObj.chkIPC.checked || formObj.chkTS.checked || formObj.chkEQ.checked;
	if(!tstatus) return false;
	controlTree(sheetObj);
	controlIOC(sheetObj);
    sheetObj.RenderSheet(1);
	return true;
}
/**
 * 화면의 Office/POL/POD 선택 체크박스에 따라 데이터의 Visiable을 control한다. (0042, 0044에서 사용)
 */
function controlTree(sheetObj){
	var formObj=document.form;
	var sts1=formObj.chkOfc.checked;
	if(!sts1) formObj.chkPol.checked = false;
	var sts2=formObj.chkPol.checked;
	if(!sts2) formObj.chkPod.checked = false;
	var sts3=formObj.chkPod.checked;
	var rowCnt = sheetObj.RowCount() + 3;
	var uiname=document.form.uiname.value;				//20160119.ADD
	
	if (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1 &&		// 속도 저하가 생길수 있는 로직이라 IE11에서만 수행 되도록 함.
	    uiname != "ESM_SPC_0042" && uiname != "ESM_SPC_0044") { 								//20160119.ADD
  		sheetObj.SetDataMerge();
   	}
	
	
	if(sts1){
//		ChangeValue(sheetObj, "lvl", "1", "pol_cd", "1", " >= 0");
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 1) {
				sheetObj.SetRowHidden(i, 0);
			}
		}
	}else{
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 1) {
				sheetObj.SetRowHidden(i, 1);
			}
		}
		
	}
	
	if(sts2){
		if(document.form.uiname != undefined && (uiname == "ESM_SPC_0042" || uiname == "ESM_SPC_0044")){		//20160119.ADD		
			ChangeValue(sheetObj, "lvl", "1", "d_pol_cd", "-", " >= 0");
		} else {
			ChangeValue(sheetObj, "lvl", "1", "pol_cd", "-", " >= 0");
		}
		
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 2) {
				sheetObj.SetRowHidden(i, 0);
			}
		}
	}else{
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 2) {
				sheetObj.SetRowHidden(i, 1);
			}
		}
		
	}

	if(sts3){
		if(document.form.uiname != undefined && (uiname == "ESM_SPC_0042" || uiname == "ESM_SPC_0044")){		//20160119.ADD	
			ChangeValue(sheetObj, "lvl", "2", "d_pod_cd", "-", " >= 0");
		} else {
			ChangeValue(sheetObj, "lvl", "2", "pod_cd", "-", " >= 0");
		}
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 3) {
				sheetObj.SetRowHidden(i, 0);
			}
		}
	}else{
		for(var i=0 ; i < rowCnt ; i++){
			var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
			if (lvl == 3) {
				sheetObj.SetRowHidden(i, 1);
			}
		}		
	}
// tree 기능 사용 안함
//	if(sts3==true){
//		sheetObj.ShowTreeLevel(2);
//	} else if(sts2==true){
//		sheetObj.ShowTreeLevel(1);
//	} else if(sts1==true){
//		sheetObj.ShowTreeLevel(0);
//	}
	
	if(document.form.uiname != undefined && (uiname == "ESM_SPC_0042" || uiname == "ESM_SPC_0044")){			//20160119.ADD
		sheetObj.SetColHidden("d_sls_ofc_cd",!sts1?1:0);
		sheetObj.SetColHidden("d_pod_cd",!sts3?1:0);
		sheetObj.SetColHidden("d_pol_cd",!sts2&&!sts3?1:0);
	} else {
		sheetObj.SetColHidden("sls_ofc_cd",!sts1?1:0);
		sheetObj.SetColHidden("pod_cd",!sts3?1:0);
		sheetObj.SetColHidden("pol_cd",!sts2&&!sts3?1:0);
	}
	return true;
}
function controlIOC(sheetObj){
	var formObj=document.form;
	var stsOCN=formObj.chkOCN.checked;
	var stsIPC=formObj.chkIPC.checked;
	var stsTS=formObj.chkTS.checked;
	var stsMT=formObj.chkEQ.checked;
	if(!stsOCN){
		filterTree(sheetObj, "ioc_cd", "OCN", !stsOCN, "child_cnt");
	}
	else{
		sheetObj.SetRowHidden(totalRows["OCN"],0);
	}
	if(!stsIPC){
		filterTree(sheetObj, "ioc_cd", "IPC", !stsIPC, "child_cnt");
	}
	else{
		sheetObj.SetRowHidden(totalRows["IPC"],0);
	}
	if(!stsTS){
		filterTree(sheetObj, "ioc_cd", "T/S", !stsTS, "child_cnt");
	}
	else{
		sheetObj.SetRowHidden(totalRows["T/S"],0);
	}
	if(!stsMT){
		filterTree(sheetObj, "ioc_cd", "EQ", !stsMT, "child_cnt");
	}
	else{
		sheetObj.SetRowHidden(totalRows["EQ"],0);
	}
	return true;
}
/**
 * col 컬럼의 값이 val과 일치한 행을 보이도록 한다.
 */
function ShowRow(sheetObj, col, val){
	with(sheetObj){
		var frow=-1;
		while((frow=FindText(col, val, frow + 1)) >= 0){
			SetRowHidden(frow,0);
		}
	}
}
/**
 * col 컬럼의 값이 val과 일치한 행을 Hidden 시킨다.
 */
function HideRow(sheetObj, col, val){
	with(sheetObj){
		var frow=-1;
		while((frow=FindText(col, val, frow + 1)) >= 0){
			SetRowHidden(frow,1);
		}
	}
}
/**
 * col 컬럼의 값이 val과 일치한 행의 sCol컬럼의 값을 sVal로 변경한다.
 * sCol컬럼의 값이 cond 조건을 만족하는 경우에만 값을 변경
 * Display Selection에서 POL선택시 하단이 POD 접힌 것들 모두 풀어줌
 */
function ChangeValue(sheetObj, col, val, sCol, sVal, cond){
		var frow=-1;
		while((frow=sheetObj.FindText(col, val, frow + 1)) >= 0){
			if(sheetObj.GetCellValue(frow, sCol) == "+" || sheetObj.GetCellValue(frow, sCol) == "-" ){
				var status=sheetObj.GetRowStatus(frow);
				sheetObj.SetCellValue(frow, sCol, sVal, 0);
				// 2014.10.21 버그 수정
				sheetObj.SetCellValue(frow, "ibflag", status, 0);
			}
		}
}
function changeSelection(){
	if(editingControlOption){
		ComShowMessage(getMsg("SPC90126"));
		return false;
	}

	var eventSrc =ComGetEvent() ;
	var srcName = ComGetEvent("name") ;
	
	return changeSelectionEx(srcName);
}
function changeSelectionEx(obj_name){
	var sheetObj=sheetObjects[1];
	//sheetObj.RenderSheet(0);
	switch(obj_name){
		case "chkOfc":
		case "chkPol":
		case "chkPod":
		case "chkTS":
		case "chkEQ":
			if(!controlRowFilter(sheetObj)) return false;
			break;
		case "chkOCN":
		case "chkIPC":
			if(!controlRowFilter(sheetObj)) return false;
		case "chkWT":
			hiddenMasterCols(sheetObjects[0], document.form);
		case "chkTYP":
		case "chkUSG":
		case "chkMDL":
		case "chkBKGF":
		case "chkCUS":
			hiddenSelectionField(sheetObj);
			break;
	}
	//sheetObj.RenderSheet(1);
	return true;
}
var warnColorTEU="#FFFFFF";
function setWarnColorTEU(sheetObj, row, colName){
	var basePre=preColName[alocIdx];
	var tgtPre=preColName[guarIdx];
//	log("setWarnColorTEU : " + basePre + " - " + tgtPre + " - " + colName + " - " + sheetObj.GetCellValue(row, basePre+colName)*1 + " - " + sheetObj.GetCellValue(row, tgtPre+colName)*1)
	if(sheetObj.GetCellValue(row, basePre+colName)*1 < sheetObj.GetCellValue(row, tgtPre+colName)*1){
 		sheetObj.SetCellFont("FontColor", row, basePre+colName, row, basePre+colName,warnColorTEU );
	}
	else{
		sheetObj.SetCellFont("FontColor", row, basePre+colName, row, basePre+colName,sheetObj.GetDataFontColor());
	}
}
function allocateByOffice(sheetObj, row, pre, sizeName, base, value, orgValue){
	with(sheetObj){
		//RowStatus(row) = "I";
		var rowsData=new Array();
		if(value == 0){
			var size=GetCellValue(row, "pol_cnt")*1;
			var r=row + 1;
    		for(var i=0 ; i < size ; i++){
    			selectedCell_OldValue=GetCellValue(r, pre + sizeName);
    			SetCellValue(r, pre + sizeName,0);
    			var c=GetCellValue(r, "child_cnt")*1;
    			r=r + c + 1;
    		}
		}
		else{
			var r=row + 1;
			var baseValue=0;
			var size=GetCellValue(row, "pol_cnt")*1;
    		if(orgValue == 0){
	    		for(var i=0 ; i < size ; i++){
	    			var c=GetCellValue(r, "child_cnt")*1;
	    			var v=GetCellValue(r, pre + sizeName)*100;
	    			rowsData[i]=new Array(r, 0, c, v);
	    			r=r + c + 1;
	    		}
	    		var leaf=GetCellValue(row, "leaf_cnt")*1;
	    		baseValue=leaf;
    		}
    		else{
	    		for(var i=0 ; i < size ; i++){
	    			var c=GetCellValue(r, "child_cnt")*1;
	    			var t=GetCellValue(r, base + sizeName)*10;
	    			var v=GetCellValue(r, pre + sizeName)*100;
	    			rowsData[i]=new Array(r, 0, t, v);
	    			r=r + c + 1;
	    		}
	    		baseValue=orgValue* 10;
    		}
			rowsData.sort(compareRowInfo);
			allocate(rowsData, value, baseValue);
    		for(var i=0 ; i < rowsData.length ; i++){
    			rowsData[i][3]=rowsData[i][3] / 100;
    		}
    		setCellValues(sheetObj, rowsData, pre + sizeName, true);
		}
	}
}
function allocateByPol(sheetObj, row, pre, sizeName, base, value, orgValue){
	with(sheetObj){
		var childs=GetCellValue(row, "child_cnt")*1;
		var rowsData=new Array();
		if(value == 0){
			for(var r=1 ; r <= childs ; r++){
				selectedCell_OldValue=GetCellValue(row + r, pre + sizeName);
				SetCellValue(row + r, pre + sizeName,0);
			}
		}
		else{
			var r=row + 1;
			var baseValue=0;
    		if(orgValue == 0){
	    		for(var i=0 ; i < childs ; i++){
	    			var v=GetCellValue(r + i, pre + sizeName)*100;
	    			rowsData[i]=new Array(r + i, 0, 1, v);
	    		}
	    		baseValue=childs;
    		}
    		else{
	    		for(var i=0 ; i < childs ; i++){
	    			var t=GetCellValue(r + i, base + sizeName)*10;
	    			var v=GetCellValue(r + i, pre + sizeName)*100;
	    			rowsData[i]=new Array(r + i, 0, t, v);
	    		}
	    		baseValue=orgValue*10;
    		}
			rowsData.sort(compareRowInfo);
			allocate(rowsData, value, baseValue);
    		for(var i=0 ; i < rowsData.length ; i++){
    			rowsData[i][3]=rowsData[i][3] / 100;
    		}
    		setCellValues(sheetObj, rowsData, pre + sizeName,  true);
		}
	}
}
function checkControlOption(){
	var formObj=document.form;
	getControlOption();
	formObj.chkWT.checked=formObj.chkWGT.checked;
	formObj.chkTYP.checked=formObj.chkHC.checked || formObj.chk45.checked || formObj.chk53.checked || formObj.chkRFR.checked;
	formObj.chkOfc.checked=true;
	formObj.chkPol.checked=formObj.chkPort.value == "L" || formObj.chkPort.value == "D";
	formObj.chkPod.checked=formObj.chkPort.value == "D";
//	if(!isDevMode){
//	} 
}
var totalRows=new Array();
var totalIOC=new Array();
var iocCnt=0;
var Flags=new Array("OCN", "IPC", "T/S", "T-OCN", "T-IPC", "T-T/S");
// IOC구분별 Total 행을 지정하고
// Data Selection의 IOC 구분별 check box를 선택 체크 하고
// 검색되지 않은 항목에 대한 체크박스를 보이지 않게 한다
function checkSelectionOption(sheetObj){
	totalIOC=new Array();
	iocCnt=0;
	totalRows=new Array();
	var formObj=document.form;
	var checkedCount
	var frow=-1;
	var row=sheetObj.FindText("ioc_cd", "OCN");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["OCN"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="OCN";
			iocCnt=iocCnt + 10;
		}
	}
	divChkOCN.style.display=(row >= 0)?"":"none";
	row=sheetObj.FindText("ioc_cd", "IPC");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["IPC"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="IPC";
			iocCnt=iocCnt + 1;
		}
	}
	divChkIPC.style.display=(row >= 0)?"":"none";
	row=sheetObj.FindText("ioc_cd", "T/S");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["T/S"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="T/S";
		}
	}
	divChkTS.style.display=(row >= 0)?"":"none";
	row=sheetObj.FindText("ioc_cd", "EQ");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row);
		if(frow > 0){
			totalRows["EQ"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="EQ";
		}
	}
	divChkMT.style.display=(row >= 0)?"":"none";
	row=sheetObj.FindText("ioc_cd", "T-OCN");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["T-OCN"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="T-OCN";
			iocCnt=iocCnt + 10;
		}
	}
	divChkOCN.style.display=(row >= 0 || divChkOCN.style.display=="")?"":"none";
	row=sheetObj.FindText("ioc_cd", "T-IPC");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["T-IPC"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="T-IPC";
			iocCnt=iocCnt + 1;
		}
	}
	divChkIPC.style.display=(row >= 0 || divChkIPC.style.display=="")?"":"none";
	row=sheetObj.FindText("ioc_cd", "T-T/S");
	if(row >= 0){
		frow=sheetObj.FindText("lvl", "0", row + 1);
		if(frow > 0){
			totalRows["T-T/S"]=frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length]="T-T/S";
		}
	}
	divChkTS.style.display=(row >= 0 || divChkTS.style.display=="")?"":"none";
	var checkedCount=0;
	checkedCount += (divChkOCN.style.display=="")?1:0;
	checkedCount += (divChkIPC.style.display=="")?1:0;
	checkedCount += (divChkTS.style.display=="")?1:0;
	checkedCount += (divChkMT.style.display=="")?1:0;
	formObj.chkOCN.checked=divChkOCN.style.display=="";
	formObj.chkIPC.checked=divChkIPC.style.display=="";
	formObj.chkTS.checked=divChkTS.style.display=="";
	formObj.chkEQ.checked=divChkMT.style.display=="";
	if(checkedCount == 1){
		divChkOCN.style.display="none";
		divChkIPC.style.display="none";
		divChkTS.style.display="none";
		divChkMT.style.display="none";
	}
}
var totalRowColor=getColor(0);
function setTotalRowColor(sheetObj, row){
	sheetObj.SetRowBackColor(row,totalRowColor);
}
// control option에 따라 syncTarget에 대한 항목의 Type/Size별 컬럼 display 설정 
function hiddenSelectionField(sheetObj){
	sheetObj.RenderSheet(0);
	var formObj=document.form;
	var chCOItemHC=formObj.chkHC.checked;
	var chCOItem45=formObj.chk45.checked;
	var chCOItem53=formObj.chk53.checked;
	var chCOItemRFR=formObj.chkRFR.checked;
	var chCOItemWGT=formObj.chkWGT.checked;
	var chDSItemWT=formObj.chkWT.checked;
	var chDSItemTYP=formObj.chkTYP.checked;
	for(var c=0 ; c < controlCols.length ; c++){
		if(controlCols[c]){
			var pre=preColName[c];
			var colNames=sizeColName[colSizeIdx[c]];
			var checked=false;
			switch(dataSelectionItemName[c]) {
			    case "chkUSG":
			    	checked=formObj.chkUSG.checked;
			    	break;
			    case "chkMDL":
			    	checked=formObj.chkMDL.checked;
			    	break;
			    case "chkBKGF":
			    	checked=formObj.chkBKGF.checked;
			    	break;
			    case "chkCUS":
			    	checked=formObj.chkCUS.checked;
			    	break;
			    default:
			    	checked=false;
			}
			var itemChecked=(dataSelectionItemName[c]=="")?true:checked;
			//control option sync 대상이면
			if(syncTarget[c]){
				switch(colSizeIdx[c]){
					case 0:
						sheetObj.SetColHidden(pre + colNames[0],!itemChecked);
						sheetObj.SetColHidden(pre + colNames[1],!(chCOItemHC  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[2],!(chCOItem45  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[3],!(chCOItem53  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[4],!(chCOItemRFR && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[5],!(chCOItemWGT && chDSItemWT  && itemChecked));
						break;
					case 1:
						sheetObj.SetColHidden(pre + colNames[0],!itemChecked);
						sheetObj.SetColHidden(pre + colNames[1],!((chCOItemHC || chCOItem45 || chCOItem53) && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[2],!((chCOItemHC || chCOItem45 || chCOItem53) && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[3],!(chCOItemHC  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[4],!(chCOItem45  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[5],!(chCOItem53  && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[6],!(chCOItemRFR && chDSItemTYP && itemChecked));
						sheetObj.SetColHidden(pre + colNames[7],!(chCOItemWGT && chDSItemWT  && itemChecked));
						break;
				}
				if(itemChecked){
					// Tp/Sz가 보이지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
					var w=(!chDSItemTYP || !(chCOItemHC || chCOItem45 || chCOItem53 || chCOItemRFR))?wideWidth:defaultWidth;
					sheetObj.SetColWidth(pre+ colNames[0],w);
					sheetObj.SetColWidth(pre+ colNames[colNames.length - 1],w);
				}
			}
			//control option sync 대상이 아니면
			else{
				sheetObj.SetColHidden(pre + colNames[0],!itemChecked);
				for(var i=1 ; i < colNames.length - 1 ; i++){
					sheetObj.SetColHidden(pre + colNames[i],!(chDSItemTYP && itemChecked));
				}
				sheetObj.SetColHidden(pre + colNames[colNames.length - 1],!(chDSItemWT && itemChecked));
				if(itemChecked){
					// DataSelection에 View by Tp/Sz가 선택되지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
					var w=chDSItemTYP?defaultWidth:wideWidth;
					sheetObj.SetColWidth(pre+ colNames[0],w);
					sheetObj.SetColWidth(pre+ colNames[colNames.length - 1],w);
				}
			}
		}
	}
    //Total TEU추가에 따른 TUE컬럼 처리
	if(chDSItemTYP) sheetObj.SetColHidden(MasterCnt+1,0);
	else sheetObj.SetColHidden(MasterCnt+1,1);
	//Total TEU 컬럼크기 조절
	sheetObj.SetColWidth(MasterCnt,chDSItemTYP?defaultWidth:wideWidth);
	sheetObj.RenderSheet(1);
}
function getPrefixIndex(prefix){
	for(var i=0 ; i < preColName.length ; i++){
		if(preColName[i] == prefix) return i;
	}
}
function getPolPodList(sheetObj, div_grp, ofc, prefix){
	var arr=new Array();
	var arrKey=new Array();
	var frow=-1;
	var idx=-1;
	var prefixIdx=getPrefixIndex(prefix);
	var colNames=sizeColName[colSizeIdx[prefixIdx]];
	while((frow=sheetObj.FindText("lvl", "3", frow + 1)) >= 0){
		var oi=sheetObj.GetCellValue(frow, "ioc_cd");
		if(div_grp.indexOf(":"+oi+":") < 0){
			break;
		}
		var pol=sheetObj.GetCellValue(frow, "pol_cd");
		var pod=sheetObj.GetCellValue(frow, "pod_cd");
		var vofc=sheetObj.GetCellValue(frow, "sls_ofc_cd");
		var key=oi+"-"+pol+"-"+pod;
		if(arrKey[key] == undefined){
			idx=idx + 1;
			arrKey[key]=idx;
			if(ofc == vofc){
				arr[idx]=new Array(
										new Array(oi, pol, pod, frow),
										new Array(	sheetObj.GetCellValue(frow, prefix+colNames[0])*1,
												sheetObj.GetCellValue(frow, prefix+colNames[1])*1,
												sheetObj.GetCellValue(frow, prefix+colNames[2])*1,
												sheetObj.GetCellValue(frow, prefix+colNames[3])*1,
												sheetObj.GetCellValue(frow, prefix+colNames[4])*1
												)
									);
			}
			else{
				arr[idx]=new Array(new Array(oi, pol, pod, -1), new Array(0, 0, 0, 0, 0));
			}
		}
	}
	return arr;
}
//수정된 행의 상위 레벨의 값에 주어진 값(value - oldValue)을 더한다.
function changeSuperiorValue(sheetObj, row, col, pre, value, oldValue){
	var difValue=value - oldValue;
	var rows=new Array();
	var frow=row - sheetObj.GetCellValue(row, "lvl2")*1;
	if(frow < row){
		addGetCellValue(sheetObj, frow, col, difValue, false);
		//setSumValue(sheetObj, frow, pre);
		//sheetObj.RowStatus(frow) = "R";
		rows[0]=frow;
	}
	frow=row - sheetObj.GetCellValue(row, "lvl1")*1;
	if(frow < row){
		addGetCellValue(sheetObj, frow, col, difValue, false);
		//setSumValue(sheetObj, frow, pre);		
		//sheetObj.RowStatus(frow) = "R";
		rows[rows.length]=frow;
	}
	return rows;
}
//IOC Type별 Total 행의 값을 변경 한다.
function changeTotalValue(sheetObj, ioc_cd, col, pre, value, oldValue){
	var row=totalRows[ioc_cd];
	addGetCellValue(sheetObj, row, col, value - oldValue);
	//setSumValue(sheetObj, row, pre);
// 기존 SetRowStatus로 인해 Editable 상태변하므로 사용하지 않음
//	sheetObj.SetRowStatus(row,"R");
	sheetObj.SetCellValue(row, "ibflag", "R", 0);
	return row;
}
var sheet1_SelectedRow=-1;
function setSelectetRow(sheetObj, row){
	var frow=sheetObj.FindText("dataSeq", String(sheet1_SelectedRow));
	setColorSelectedRow(sheetObj, frow, false);
	setColorSelectedRow(sheetObj, row, true);
	sheet1_SelectedRow=sheetObj.GetCellValue(row, "dataSeq");
}
function setColorSelectedRow(sheetObj, row, select){
	if(row > 0){
//		sheetObj.SetRowBackColor(row, select?"#FFE6E6":sheetObj.GetDataBackColor());
		sheetObj.SetRowBackColor(row, select?"#FFE6E6":"#F4F4F4");
	}
}
function checkPolPodSum(sheetObj, vol, wgt, prefix){
	var list=getPolPodSum(sheetObj, ":OCN:IPC:T/S:T-OCN:T-IPC:T-T/S:", prefix);
	var volList=new Array();
	var wgtList=new Array();
	var cnt=list.length;
	var volCol=0;
	var prefixIdx=getPrefixIndex(prefix);
	var colNames=sizeColName[colSizeIdx[prefixIdx]];
	var wgtCol=colNames.length-1;
	for(var i=0 ; i < cnt ; i++){
		var tArr=list[i];
		if(tArr[1][volCol] > (vol+10)){
			volList[volList.length]=tArr[0][0] + "-" + tArr[0][1];
		}
		if(tArr[1][wgtCol] > (wgt+10)){
			wgtList[wgtList.length]=tArr[0][0] + "-" + tArr[0][1];
		}
	}
	if((volList.length + wgtList.length) == 0){
		return true;
	}
	var msg="다음의 Port 목록이 Loadable을 초과하였습니다.\n";
	if(volList.length > 0){
		msg += "\nSpace : "+volList;
	}
	if(wgtList.length > 0){
		msg += "\nWeight : "+wgtList;
	}
	ComShowMessage(msg);
	return false;
}
function checkOcnSum(sheetObj, vol, wgt, prefix){
	var list=getPolPodSum(sheetObj, ":OCN:T-OCN:", prefix);
	var volSum=0;
	var wgtSum=0;
	var cnt=list.length;
	var errorRange=10;
	var volCol=0;
	vol=vol + errorRange;
	wgt=wgt + errorRange;
	var prefixIdx=getPrefixIndex(prefix);
	var colNames=sizeColName[colSizeIdx[prefixIdx]];
	var wgtCol=colNames.length-1;
	for(var i=0 ; i < cnt ; i++){
		var tArr=list[i];
		volSum += tArr[1][volCol];
		wgtSum += tArr[1][wgtCol];
	}
	if(volSum <= vol &&  wgtSum <= wgt){
		return true;
	}
	var msg="";
	if(volSum > vol){
//		msg += "Space" + (isDevMode?"("+volSum+"-"+(vol-errorRange)+")":"");
		msg += "Space";
	}
	if(wgtSum > wgt){
		if(msg != ""){
			msg += "와 ";
		}
		msg += "Weight";
//		msg += "Weight" + (isDevMode?"("+wgtSum+"-"+(wgt-errorRange)+")":"");
	}
	msg += "가 Loadable을 초과하였습니다.";
	ComShowMessage(msg);
	return false;
}
function getSum(sheetObj, div_grp, prefix){
    var arrs=getPolPodSum(sheetObj, div_grp, prefix);
    var sumArr=new Array();
	var prefixIdx=getPrefixIndex(prefix);
	var colNames=sizeColName[colSizeIdx[prefixIdx]];
	var cnt=colNames.length;
    for(var c=0 ; c < cnt ; c++){
    	sumArr[c]=0;
    }
    for(var i=0 ; i < arrs.length ; i++){
	    for(var c=0 ; c < cnt ; c++){
	    	sumArr[c] += arrs[i][1][c];
	    }
    }
	return sumArr;
}
function getPolPodSum(sheetObj, div_grp, prefix, level){
	if(level == undefined){
		level="3";
	}
	var arr=new Array();
	var arrKey=new Array();
	var frow=-1;
	var idx=-1;
	var prefixIdx=getPrefixIndex(prefix);
	var colNames=sizeColName[colSizeIdx[prefixIdx]];
	var cnt=colNames.length;
	while((frow = sheetObj.FindText("lvl", level, frow + 1)) >= 0){
		var oi=sheetObj.GetCellValue(frow, "ioc_cd");
		if(div_grp.indexOf(":"+oi+":") < 0){
			continue;
		}
		var pol=sheetObj.GetCellValue(frow, "pol_cd");
		var pod=sheetObj.GetCellValue(frow, "pod_cd");
		var key=pol+"-"+pod;
		if(arrKey[key] == undefined){
			idx=idx + 1;
			arrKey[key]=idx;
			var cArr=new Array();
			for(var t=0 ; t < cnt ; t++){
				cArr[t]=sheetObj.GetCellValue(frow, prefix+colNames[t])*1;
			}
			arr[idx]=new Array(new Array(pol, pod), cArr);
		}
		else{
			var cIdx=arrKey[key];
			var cArr=arr[cIdx][1];
			for(var t=0 ; t < cnt ; t++){
				cArr[t] += sheetObj.GetCellValue(frow, prefix+colNames[t])*1;
			}
			arr[cIdx][1]=cArr;
		}
	}
	return arr;
}
var editingControlOption=false;
function editControlOption(sheetObj){
	changeControlOptionButtonStatus(true);
	changeControlOptionStatus(true);
}
function saveControlOption(sheetObj){
	var frow=sheetObj.FindText("dataSeq", String(sheet1_SelectedRow));
	setControlOption(sheetObj);
	changeControlOptionButtonStatus(false);
	changeControlOptionStatus(false);
	if(sheetObj.GetCellValue(frow, "flag") == "I"){
//		sheetObj.SetRowStatus(frow,"I");
		sheetObj.SetCellValue(frow, "ibflag", "I", 0);
	}
	var SaveStr = sheetObj.GetSaveString();
	var sXml = sheetObj.GetSaveData("ESM_SPC_0042GS.do", "f_cmd="+MULTI01+"&"+SaveStr);
	var rtn = ComGetSelectSingleNode(sXml, "TR-ALL");
//	var rtn = sheetObj.DoSave("ESM_SPC_0042GS.do", "f_cmd="+MULTI01, -1, false);
	if(rtn || rtn == "OK"){
		sheetObj.SetCellValue(frow, "flag", "R");
//		sheetObj.SetRowStatus(frow, "R");
//		sheetObj.SetCellValue(frow, "ibflag", "R", 0);
		rtn = "OK";
	}
	return rtn;	
//	var SaveStr = sheetObj.GetSaveString();
//	if (sheetObj.IsDataModified() && SaveStr == "") return;
//	var sXml = sheetObj.GetSaveData("ESM_SPC_0042GS.do", "f_cmd="+MULTI01+"&"+SaveStr);
//	sheetObj.LoadSaveData(sXml);
//	return ComGetSelectSingleNode(sXml, "TR-ALL");
	
}
function cancelControlOption(){
	getControlOption();
	changeControlOptionButtonStatus(false);
	changeControlOptionStatus(false);
}
function getControlOption(){
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	var frow=sheetObj.FindText("dataSeq", String(sheet1_SelectedRow));
	if(frow < 0) return;
	var formObj=document.form;
	formObj.chkVolume.checked=sheetObj1.GetEtcData("volume") == "Y";
	formObj.chkPort.value=sheetObj1.GetEtcData("pol_pod");
	formObj.chkHC.checked=sheetObj1.GetEtcData("hc40") == "Y";
	formObj.chk45.checked=sheetObj1.GetEtcData("hc45") == "Y";
	formObj.chk53.checked=sheetObj1.GetEtcData("53ft") == "Y";
	formObj.chkRFR.checked=sheetObj1.GetEtcData("reefer") == "Y";
	formObj.chkWGT.checked=sheetObj1.GetEtcData("weight") == "Y";
}
function setControlOption(sheetObj){
	var frow=sheetObj.FindText("dataSeq", String(sheet1_SelectedRow));
	var formObj=document.form;
	sheetObj.SetCellValue(frow, "ctrl_spc_flg",formObj.chkVolume.checked?"Y":"N");
	sheetObj.SetCellValue(frow, "ctrl_lvl_cd",formObj.chkPort.value);
	sheetObj.SetCellValue(frow, "ctrl_40ft_hc_flg",formObj.chkHC.checked?"Y":"N");
	sheetObj.SetCellValue(frow, "ctrl_45ft_hc_flg",formObj.chk45.checked?"Y":"N");
	sheetObj.SetCellValue(frow, "ctrl_53ft_flg",formObj.chk53.checked?"Y":"N");
	sheetObj.SetCellValue(frow, "ctrl_rf_flg",formObj.chkRFR.checked?"Y":"N");
	sheetObj.SetCellValue(frow, "ctrl_wgt_flg",formObj.chkWGT.checked?"Y":"N");
}
function changeControlOptionButtonStatus(edit){
	editingControlOption=edit;
	if(controlOptionButton1.display == undefined || controlOptionButton1.display != "none"){
		controlOptionButton1.style.display=edit?"none":"block";
	}
	controlOptionButton2.style.display=edit?"block":"none";
}
function changeControlOptionStatus(edit){
	var formObj=document.form;
	formObj.chkVolume.disabled=!edit;
	formObj.chkPort.disabled=!edit;
	formObj.chkHC.disabled=!edit;
	formObj.chk45.disabled=!edit;
	formObj.chk53.disabled=!edit;
	formObj.chkRFR.disabled=!edit;
	formObj.chkWGT.disabled=!edit;
}
function makeDetailParam(sheetObj, row){
	var formObj=document.form;
	var param="";
	param=param + "f_cmd="+SEARCHLIST02;
	param=param + "&lane="+sheetObj.GetCellValue(row, "rlane_cd")+"&bound="+sheetObj.GetCellValue(row, "dir_cd");
	param=param + "&vvd="+sheetObj.GetCellValue(row, "VVD");
	param=param + "&trade="+sheetObj.GetCellValue(row, "TRADE");
	param=param + "&subtrade="+sheetObj.GetCellValue(row, "STRADE");
	param=param + "&year="+sheetObj.GetCellValue(row, "WEEK").substring(0, 4);
	param=param + "&week="+sheetObj.GetCellValue(row, "WEEK").substring(4);
	return param;
}
function validAllocation(sheetObj, formObj, group, onlyTpSz){
	if(onlyTpSz == undefined){
		onlyTpSz=false;
	}
	var colNames=new Array("TEU", "HC", "45", "53'", "Reefer", "Weight");
	var level= String(formObj.chkPort.selectedIndex);
	if(onlyTpSz){
		level="0";
	}
	var allocs=getPolPodSum(sheetObj, group, preColName[alocIdx], level);
	var models=getPolPodSum(sheetObj, group, preColName[modelIdx], level);
	var cols=new Array();
	var idx=0;
	if(!onlyTpSz){
		cols[idx++]=0;
	}
	if(formObj.chkHC.checked){
		cols[idx++]=1;
	}
	if(formObj.chk45.checked){
		cols[idx++]=2;
	}
	if(formObj.chk53.checked){
		cols[idx++]=3;
	}
	if(formObj.chkRFR.checked){
		cols[idx++]=4;
	}
	if(!onlyTpSz && formObj.chkWT.checked){
		cols[idx++]=5;
	}
	for(var i=0 ; i < allocs.length ; i++){
		for(var c=0 ; c < cols.length ; c++){
			if(allocs[i][1][cols[c]] > models[i][1][cols[c]]){
				var msg="";
				if(level > 0){
					msg=allocs[i][0][0] + "-" + allocs[i][0][1];
				}
				switch(cols[c]){
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					msg=getMsg("SPC90131") + "[" + msg + (msg==""?"":"/") + colNames[cols[c]] + "]";
					break;
				case 5:
					msg=getMsg("SPC90132") + "[" + msg + "]";
					break;
				}
				ComShowMessage(msg);
				return cols[c];
			}
		}
	}
	return -1;
}
function validAllocationLoadable(sheetObj, formObj, group, models, onlyTpSz){
	if(onlyTpSz == undefined){
		onlyTpSz=false;
	}
	var columnNames=new Array("TEU", "HC", "45", "53'", "Reefer", "Weight");
	var level="0";
	var allocs=getPolPodSum(sheetObj, group, preColName[alocIdx], level);
	var cols=new Array();
	var idx=0;
	if(!onlyTpSz){
		cols[idx++]=0;
	}
	if(formObj.chkHC.checked && models[1] > 0){
		cols[idx++]=1;
	}
	if(formObj.chk45.checked && models[2] > 0){
		cols[idx++]=2;
	}
	if(formObj.chk53.checked && models[3] > 0){
		cols[idx++]=3;
	}
	if(formObj.chkRFR.checked && models[4] > 0){
		cols[idx++]=4;
	}
	if(!onlyTpSz && formObj.chkWT.checked){
		cols[idx++]=5;
	}
	for(var i=0 ; i < allocs.length ; i++){
		for(var c=0 ; c < cols.length ; c++){
			if(allocs[i][1][cols[c]] > models[cols[c]]){
				var msg="";
				switch(cols[c]){
				case 0:
					msg=getMsg("SPC90128");
					break;
				case 1:
				case 2:
				case 3:
				case 4:
					msg=getMsg("SPC90129") + "[" + columnNames[cols[c]] + "]";
					break;
				case 5:
					msg=getMsg("SPC90130");
					break;
				}
				ComShowMessage(msg);
				return cols[c];
			}
		}
	}
	return -1;
}
//ALO 내용 끝
/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
 * @param{form} str  Form 객체  
 * @param{chkElmNms} str   chkElmNms값들만 form elemente name으로 구성한다. ALL 일경우 모든 elemente 로 구성.
 */  
function SpcFormString(form, chkElmNms) {
	var checkRequired;
	 if (typeof form != "object" ) {
			showMsg("");
			return "";
	    }


	    if (checkRequired == null) checkRequired = false;

	    var name = new Array(form.elements.length);
	    var value = new Array(form.elements.length);
	    var j = 0;
	    var plain_text = "";

	    //사용가능한 컨트롤을 배열로 생성한다.
	    len = form.elements.length;
	    for (i = 0; i < len; i++) {
	    	
	        var prev_j = j;
	        switch (form.elements[i].type) {
	            case "button":
	            case "reset":
	            case "submit":
	                break;
	            case "radio":
	            case "checkbox":
	                if (form.elements[i].checked == true) {
	                    name[j] = IBS_getName(form.elements[i]);
	                    value[j] = form.elements[i].value;
	                    j++;
	                }
	                break;
	            case "select-one":
	                name[j] = IBS_getName(form.elements[i]);
	                var ind = form.elements[i].selectedIndex;
	                if (ind >= 0) {

	                    value[j] = form.elements[i].options[ind].value;

	                } else {
	                    value[j] = "";
	                }
	                j++;
	                break;
	            case "select-multiple":
	                name[j] = IBS_getName(form.elements[i]);
	                var llen = form.elements[i].length;
	                var increased = 0;
	                for (k = 0; k < llen; k++) {
	                    if (form.elements[i].options[k].selected) {
	                        name[j] = IBS_getName(form.elements[i]);

	                        value[j] = form.elements[i].options[k].value;

	                        j++;
	                        increased++;
	                    }
	                }
	                if (increased > 0) {
	                    j--;
	                } else {
	                    value[j] = "";
	                }
	                j++;
	                break;
	            default:
	            	if(form.elements[i].value.length >0 ) {
						if(chkElmNms!=null && chkElmNms!='' && chkElmNms!=undefined){
							if(checkExcludeElements(form.elements[i].name, chkElmNms)) {
								name[j]  = form.elements[i].name;
								value[j] = form.elements[i].value;
								j++;
							}
						} else {
							name[j]  = form.elements[i].name;
							value[j] = form.elements[i].value;
							j++;
						}
					}
	        }

	    }

	    //QueryString을 조합한다.
	    for (i = 0; i < j; i++) {
	        if (name[i] != '') plain_text += name[i] + "=" + encodeURIComponent(value[i]) + "&";
	    }

	    //마지막에 &를 없애기 위함
	    if (plain_text != "") plain_text = plain_text.substr(0, plain_text.length - 1);

	    return plain_text;
	    
	
}
function checkExcludeElements(elmNm, chkElmNms) {
	var arr_chkElmNms='';
	var rstTF=false;
	try {
		if(chkElmNms != null && chkElmNms != '' && chkElmNms != undefined) {
			arr_chkElmNms=chkElmNms.split(',');
			for(var i=0; i < arr_chkElmNms.length; i++) {
				if(arr_chkElmNms[i] != "") {
					if(elmNm==null || elmNm=='' || elmNm==undefined) {
						rstTF=true;
						break;
					} else if(elmNm == arr_chkElmNms[i]) {
						rstTF=true;
						break;
					}
				}
			}
		}
	} catch(e) {
		rstTF=true;
	}
	if(chkElmNms == 'ALL')
		rstTF=true;
	return rstTF;
}
function getCodeXmlList(cmd, param){
	var rtn=new Array();
    rtn[0]="";
    rtn[1]="";
    //createCodeSheetObject();
    with(codeSheet){
    	RemoveAll();
        ShowDebugMsg(false);
        var sXml=GetSearchData("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
        var xml=sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
    }
    return xml;
}
/**
 * 조회 조건의 Year 설정.
 * 
 * @param{elemName} str  필수, Object Name
 * @param{isLoad} boolean option, Loading시 호출되는지의 여부
 */  
function SpcSearchOptionYear(elemName, isLoad) {
	var obj=document.getElementsByName(elemName)[0];

	initOption(obj);
	var today=new	Date();
	var year=today.getFullYear();
	var pre=1;
	var post=5;
	for (var i=year + pre; i > year - pre - post; i--) {
		$("select#"+elemName).append( $("<option>")
			    .val(i)
			    .html(i)
		);
		/*
		newOpt=document.createElement("OPTION");
		newOpt.text=i;
		newOpt.value=i;
		obj.add(newOpt , null);*/
	}
	// default 값 현재 년도 settingal
	obj.value=year;
	
	
	
	

}
/**
 * 조회 조건의 Week 설정.
 * 
 * @param{elemName} str		필수, Object Name
 * @param{isAll}	Boolean	선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionWeek(elemName, isAll) {
	if(isAll == undefined || isAll == null){
		isAll=false;
	}
	var today=new	Date();
	var year=today.getFullYear();
	var mon=today.getMonth() + 1;
	var day=today.getDate();
	
	mon=(mon < 10 ? "0" : "") + mon;
	day = (day < 10 ? "0" : "") + day;

	var rtn=getCodeList("WeekCombo", "year=" + year);

	var code=rtn[0].split("|");
	var text=rtn[1].split("|");
	var obj=document.getElementsByName(elemName)[0];
	initOption(obj);

	if(isAll) {
		newOpt=document.createElement("OPTION");
		newOpt.text="ALL";
		newOpt.value="";
		obj.add(newOpt);
	}

	for (var i=0; i < code.length - 1; i++) {
		newOpt=document.createElement("OPTION");
		newOpt.text=text[i];
		newOpt.value=code[i];
		obj.add(newOpt);
	}
	
	if(!isAll) {
		var rtn2=getCodeList("CurrWeek", "date=" + year + mon + day);
		var code2=rtn2[0].split("|");
		// default 값 현재 주차 setting
		obj.value=code2[0];
	}
}
/**
 * 조회 조건의 Duration 설정.
 * 
 * @param{elemName} str  필수, Object Name
 * @param{dur}		int  선택, Duration 주차의 길이 설정, Default = 5 
 * @param{def}		int  선택, Duration 의 초기값 설정, Default = 1
 */
function SpcSearchOptionDuration(elemName, dur, def) {
	if(dur == undefined || dur == null){
		dur=5;
	}
	if(def == undefined || def == null){
		def=1;
	}
	var obj=document.getElementsByName(elemName)[0];
	initOption(obj);
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
function SpcSearchOptionTrade(elemName, isAll, isRepTrade, del) {
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
	
	obj.RemoveAll();
	var rtn=getCodeXmlList("TradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del);
	obj.SetTitleVisible(1);
	obj.SetTitle("Trade|Description");
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "200");
	obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	obj.SetMaxLength(3);
	ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");
	if(isAll)
		obj.InsertItem(0, "|ALL","");
}
/**
 * 조회 조건의 Sub Trade 설정.
 * 
 * @param{elemName}		str		필수, Object Name
 * @param{isAll}		Boolean	선택, 모든 Sub Trade 조건 추가 여부, default = true.
 * @param{isRepTrade}	Boolean	선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} 			str		선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionSubTrade(elemName, isAll, isRepTrade, del, trdCd) {
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
	obj.RemoveAll();
	
	var rtn = "";
	
	if(trdCd == null || trdCd == ""){
		rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll);
	}else{
		rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&trdCd=" + trdCd);
	}
	obj.SetTitleVisible(1);
	obj.SetTitle("Trade|SubTrade|Description");
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "60");
	obj.SetColWidth(2, "200");
	obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	obj.SetMaxLength(2);
//지원안함[확인요망]HANJIN: 	obj.ShowCol(1);
	ComXml2ComboItem(rtn, obj, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
	if(isAll)
		obj.InsertItem(0, "||ALL","");
}
/**
 * 조회 조건의 RHQ 설정.
 * 
 * @param{elemName}	str  필수, Object Name
 * @param{del} 		str  선택, 삭제 플레그 조건 추가 여부
 * @param{code}		str  선택, Option 의 Code 값을 직접 설정, 구분자 "|", ComComboObject 사용 안할시만 가능
 * @param{text}		str  선택, Option 의 Text 값을 직접 설정, 구분자 "|", ComComboObject 사용 안할시만 가능
 * @param{useOffice}		
 */  
function SpcSearchOptionRhq(elemName, del, code, text, useOffice, isAll) {
	if(del == undefined || del == null){
		del='';
	}
	if(code == undefined || code == null){
		code='';
	}
	if(text == undefined || text == null){
		text='';
	}
	
	if(useOffice == undefined || useOffice == null){
		useOffice = false;
	}
	
	var selMethodName = "RHQCombo";
	if(useOffice==true){
		selMethodName = "RHQ2Combo";
	}
	
	var obj=window[elemName];
	obj.RemoveAll();
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
		var rtn=getCodeXmlList(selMethodName, "del=" + del);
		obj.SetTitleVisible(1);
		obj.SetTitle("RHQ|Description");
		obj.SetColWidth(0, "70");
		obj.SetColWidth(1, "220");
		obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
		obj.SetMaxLength(6);
		ComXml2ComboItem(rtn, obj, "ofc_cd", "ofc_cd|ofc_eng_nm");
	}
	
	if(isAll)
		obj.InsertItem(0, "ALL|ALL", "ALL");
}
/**
 * 조회 조건의 Bound 설정.
 * 
 * @param{elemName} str  필수, Object Name
 */
function SpcSearchOptionBound(elemName) {
	var obj=document.getElementsByName(elemName)[0];
	initOption(obj);
	var bound="|E|W|S|N";
	var arrCode=bound.split("|");
	var arrText=bound.split("|");
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
 * @param{elemName} str		필수, Object Name
 * @param{isAll}	Boolean	선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionMonth(elemName, isAll) {
	if(isAll == undefined || isAll == null){
		isAll=false;
	}
	var mon="01|02|03|04|05|06|07|08|09|10|11|12";
	var code=mon.split("|");
	var text=mon.split("|");
	var obj=document.getElementsByName(elemName)[0];
	initOption(obj);
	if(isAll) {
		newOpt=document.createElement("OPTION");
		newOpt.text="ALL";
		newOpt.value="";
		obj.add(newOpt);
	}
	for (var i=0; i < code.length; i++) {
		newOpt=document.createElement("OPTION");
		newOpt.text=text[i];
		newOpt.value=code[i];
		obj.add(newOpt);
	}
	var today=new	Date();
	var mon=today.getMonth() + 1;
	mon=(mon < 10 ? "0" : "") + mon;
	// default 값 현재 월 setting
	obj.value=mon;
}
/**
 * 조회 조건의 Lane 설정.
 * 
 * @param{elemName}	str		필수, Object Name
 * @param{isAll}	Boolean	선택, Option 에 ALL 입력 여부, Default = true
 * @param{ipc}		Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건 제외. Default = false.
 * @param{del} 		str  	선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionLane(elemName, isAll, ipc, del, locTrdCd, locSubTrdCd, reCdValue) {
	if(isAll == undefined || isAll == null){
		isAll=true;
	}
	if(ipc == undefined || ipc == null){
		ipc=false;
	}
	if(del == undefined || del == null){
		del='';
	}
	var obj=window[elemName];
	obj.RemoveAll();
	var rtn="";
	
	if(reCdValue == null || reCdValue == ''){
		rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc);
	}else{
		rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc+ "&locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd+ "&reCdValue="+reCdValue);
	}
	
	obj.SetTitleVisible(1);
	obj.SetTitle("Trade|SubTrade|Rev.Lane|Description");
	obj.SetColWidth(0, "50");
	obj.SetColWidth(1, "60");
	obj.SetColWidth(2, "60");
	obj.SetColWidth(3, "250");
	obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	obj.SetMaxLength(5);
	ComXml2ComboItem(rtn, obj, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
	if(isAll)
		obj.InsertItem(0, "|||ALL","");
}
/**
 * 조회 조건의 IOC 설정.
 * 
 * @param{elemName} str  필수, Object Name
 */
function SpcSearchOptionIoc(elemName) {
	var obj=document.getElementsByName(elemName)[0];
	initOption(obj);
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
 * @param{elemName} str	필수, Object Name
 * @param{codeNo}	str	필수, 조회해올 CodeNo
 */
function SpcSearchOptionComCode(elemName, codeNo) {
	var rtn=getCodeList("CommonCode", "codeNo=" + codeNo);
	var code=rtn[0].split("|");
	var text=rtn[1].split("|");
	var obj=document.getElementsByName(elemName)[0];
	newOpt=document.createElement("OPTION");
	newOpt.text="";
	newOpt.value="";
	obj.add(newOpt);
	for (var i=0; i < code.length - 1; i++) {
		newOpt=document.createElement("OPTION");
		newOpt.text=text[i];
		newOpt.value=code[i];
		obj.add(newOpt);
	}
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
function initOption(obj) {

	var length=obj.length;
	for(var i=length-1; i>=0; i-- ){
		obj.options.remove(i);
	}
	
}
/**
 * 조회 조건의 Month 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionOcnipc(elemName, isAll) {
	if(isAll == undefined || isAll == null){
		isAll=false;
	}
	var ocnIpc="OCN|IPC|T/S";
	var code=ocnIpc.split("|");
	var text=ocnIpc.split("|");
	var obj=document.getElementsByName(elemName)[0];
	if(isAll) {
		newOpt=document.createElement("OPTION");
		newOpt.text="ALL";
		newOpt.value="";
		obj.add(newOpt);
	}
	for (var i=0; i < code.length; i++) {
		newOpt=document.createElement("OPTION");
		newOpt.text=text[i];
		newOpt.value=code[i];
		obj.add(newOpt);
	}
}
/**
 * ContiCd Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
 * @date 2011-04-11 
 * @param comboObj - Combo object
 * @param param - 코드 조회시 필요한 조건 parameter string
 **/	
function SpcSearchOptionContiCd(elemName, isAll, isRepTrade, del) {
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
	var rtn=getCodeXmlList("ContiCdCombo", "isRepTrade=" + isRepTrade + "&del=" + del);
	obj.SetTitleVisible(1);
	obj.SetTitle("conti_cd|conti_nm");
	obj.SetColWidth(0, "65");
	obj.SetColWidth(1, "100");
	obj.SetMaxLength(1);
	ComXml2ComboItem(rtn, obj, "conti_cd", "conti_cd|conti_nm");
	if(isAll)
		obj.InsertItem(0, "|ALL","");
	
} 
