/**
===============================================================================
프로그램  명  : DIV를 이용한 팝업
프로그램개요  :
작   성   자  : 송민석
작   성   일  : 2007-04-12
===============================================================================
수정자/수정일 :
수정사유/내역 :
===============================================================================
*/
var oPopup  = null;
var SHEET_COUNT_HEIGHT = 17;

function initCheckListDragPopup2(data,objName,inputObjName,title1,title2,title3,option,isAllCheck){

    if( isAllCheck == undefined){
        isAllCheck = false;
    }
     if( this.oPopup != null){
         this.oPopup.style.display ="none"
     }
     if( this.divObj != null){
         this.divObj.style.display ="none"
     }     
	var arr1 = data.split("&");     
	var objs = new Array();
	if( data != "" && arr1.length > 0){
	    for(var i =0 ; i < arr1.length ; i++){
	        var arr2 = arr1[i].split(";");
	        var arr3 = arr2[1].split("|");
	        objs[i] = new Object();
	        objs[i].parent_data = arr2[0];
	        objs[i].child_data_arr = arr3;
	        objs[i].child_cnt = arr3.length-1;
	    }
	}     
    makeCheckListDragHtml2(objs,objName,inputObjName,title1,title2,title3,option,isAllCheck);
}


function initCheckListDragPopup(data,objName,inputObjName,title1,title2,option,isAllCheck){
    if( isAllCheck == undefined){
        isAllCheck = false;
    }
     if( this.oPopup != null){
         this.oPopup.style.display ="none"
     }
     if( this.divObj != null){
         this.divObj.style.display ="none"
     }
     
     makeCheckListDragHtml(data.split("|"),objName,inputObjName,title1,title2,option,isAllCheck);
}

function getSheetCoordinates(sheetObj,col){
    if( !isNumber2(col)){
        col = sheetObj.SaveNameCol(col);
    }
    var x = getLeftOffset(sheetObj,col);
    var y = getTopOffset(sheetObj,sheetObj.HeaderRows);
    var value = new Array();
    value[0] = x;
    value[1] = y;
    return value;
}
function getLeftOffset(sheetObj,col){
    var iOffset = 0;
	for(var i = 0 ; i < col ; i++){
	   if( sheetObj.ColHidden(i) == false)
		  iOffset = iOffset + sheetObj.ColWidth(i);
	}    
    return iOffset;
}
function getTopOffset(sheetObj,row){
    var iOffset = 0;
	 
	for(var i = 0 ; i < row ; i++){
        iOffset = iOffset + sheetObj.RowHeight(i);
	}    
	if( sheetObj.CountPosition == 1 || sheetObj.CountPosition == 2 ){
	    iOffset += SHEET_COUNT_HEIGHT;
	}
    return iOffset;
}

function openDynamicDragPopup(divO,x,y,popupWidth,popupHeight,parentObj,leftRight){
    if( divO == undefined || divO == ""){
        return;
    }
    if( leftRight == undefined ){
        leftRight = "RIGHT";
    }
    if(this.divObj != null ){
        if(this.divObj.style.display == "inline"){
            this.divObj.style.display ="none"
        }
    }    
    this.divObj = divO;

    if( this.oPopup == null){
         this.oPopup = document.createElement("iframe");
         document.body.appendChild(this.oPopup);
         this.oPopup.style.position = "absolute";
         this.oPopup.style.zIndex=90;
    }

    if(divObj.isResize == undefined || divObj.isResize == false || divObj.isResize == "false"){
        this.oPopup.style.height = popupHeight;
        this.oPopup.style.width = popupWidth;       
        this.divObj.style.height = popupHeight;
        this.divObj.style.width = popupWidth;   
        this.divObj.oldWidth=popupWidth;
        this.divObj.oldHeight=popupHeight;        
    }else{
        this.oPopup.style.height =this.divObj.style.height;
        this.oPopup.style.width = this.divObj.style.width;
    }
    var offSetTopVl = 0;
    var offSetLeftVl = 0;
    var divCnt = 0;
    
    if( parentObj != undefined ){
        var pE = parentObj.parentElement;
    
        while( pE != undefined ){
            if( pE.tagName == "DIV" && divCnt == 0){
                pE = pE.parentElement;
                divCnt = 1;
                continue;
            }
          offSetTopVl = offSetTopVl + parseInt(pE.offsetTop);  
          offSetLeftVl = offSetLeftVl + parseInt(pE.offsetLeft);  
//          log("tagName="+pE.tagName+"top="+parseInt(pE.offsetTop));
          pE = pE.parentElement;
        }
    }
    y = offSetTopVl+y;
    x = offSetLeftVl+x;

             
    this.divObj.style.left = (leftRight.toUpperCase() == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   ) ;
    this.divObj.style.top = y;
    this.oPopup.style.left=(leftRight.toUpperCase()  == "LEFT" ? x-parseInt(this.oPopup.style.width) : x   ) ;
    this.oPopup.style.top=y    


    if( divObj.style.position != "absolute"){
        divObj.style.position = "absolute";
    }  
    if( divObj.style.zIndex != 100){
        divObj.style.zIndex = 100;
    }
	
    this.oPopup.style.display = "inline";
    this.divObj.style.display = "inline"; 
} 
function dynamicPopupAllCheck(obj,inputObjName){
     var inputObj = null;
     if( inputObjName.constructor == String ){
         inputObj = document.getElementsByName(inputObjName); 
     }else{
         inputObj = inputObjName;
     }   
     var check =  obj.checked ;
     if( inputObj.length != undefined ){     
        for(var i = 0 ; i < inputObj.length ; i++){
           inputObj[i].checked  =    check ;
        }        
    }else{   
        inputObj.checked  =    check ;
    }          
}
function dynamicPopupChangeCheckBox(obj,inputObjName){
     var allCheckObj = null;
     if( inputObjName.constructor == String ){
         allCheckObj = document.getElementById(inputObjName); 
     }else{
         allCheckObj = inputObjName;
     }     
     if( obj.checked == false ){     
        allCheckObj.checked = false;        
    }   
}
 
var dragapproved = 0;  
var x=0; 
var y= 0;
var offsetx = 0;
var offsety = 0;
var targetobj ;
var divObj = null ;
function dynamicPopupDragStart(){
	var evtobj=window.event? window.event : e
	this.targetobj=window.event? event.srcElement : e.target
	this.targetobj.style.cursor = "move"
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
    	this.targetobj.style.cursor = "move"		
		if (this.dragapproved==1){
			this.divObj.style.left= this.offsetx+evtobj.clientX- this.x+"px"
			this.divObj.style.top= this.offsety+evtobj.clientY- this.y+"px"
			this.oPopup.style.left= this.offsetx+evtobj.clientX- this.x+"px"
			this.oPopup.style.top= this.offsety+evtobj.clientY- this.y+"px"			
			//return false
		}
	}
	
function dynamicPopupDragEnd(){
    this.dragapproved = 0;
    this.targetobj.style.cursor = "hand"
}
function dynamicPopupClose(){
    if(this.divObj != null ){
        if(this.divObj.style.display == "inline"){
            this.divObj.style.display ="none"
        }
    }    
    if( this.oPopup != null){
         this.oPopup.style.display ="none" ;
    }      
}
function changeHeaderFilterColor(objName,inputObjName){

    var ICO_UNCHECK_IDX = 0;    
    var ICO_CHECK_IDX = 1;    
    var chk_Rslt = ICO_CHECK_IDX;    
    var sheetObj = eval(inputObjName);  
    var divObj = eval(objName);
    var adjSheetObj = document.getElementById(divObj.sheetName);      
    var colName = divObj.colName;  
    var hHeader = divObj.hHeader;

    if(hHeader == undefined){
    	hHeader = "Y"; 
    }     
    if( sheetObj.RowCount == 0 ){
        return;
    }    
    
    if( hHeader == "Y"){
	    // 팝업 sheet
	    with(sheetObj){          
	       for(var i= HeaderRows ; i <= LastRow ; i++){      // Header 제외
	          if( CellImage(i, "chk_value") == ICO_UNCHECK_IDX ){
	             chk_Rslt = ICO_UNCHECK_IDX ;
	             CellImage(HeaderRows-1, "chk_value") = ICO_UNCHECK_IDX;   //Uncheck 존재시 Header 부분 처리
	             break;
	          }
	       }
	    }   
	
	 
	    //Head 색 표시                
	    with(adjSheetObj){            
	       if ( chk_Rslt == ICO_UNCHECK_IDX ){ // 필터적용 
	           RangeBackColor(0, SaveNameCol(colName), 1, SaveNameCol(colName)) = RgbColor(225,244,226);              
	       } else {                           // 필터미적용
	           RangeBackColor(0, SaveNameCol(colName), 1, SaveNameCol(colName)) = RgbColor(192,235,163);    
	       }
	    }    
    }  
       
}


var resizeTop=0;
var resizeLeft=0;
var oPopupOldWidth = 0;
var divObjOldWidth = 0;
var oPopupOldHeight = 0;
var divObjOldHeight = 0;
function dynamicPopupResizeStart(type){
    var evtobj=window.event? window.event : e
    this.resizeTop = parseInt(evtobj.clientY);
    this.resizeLeft = parseInt(evtobj.clientX);
    this.oPopupOldWidth = parseInt(this.oPopup.style.width);
    this.divObjOldWidth = parseInt(this.divObj.style.width);    
    this.oPopupOldHeight = parseInt(this.oPopup.style.height);
    this.divObjOldHeight = parseInt(this.divObj.style.height);     
}
function dynamicPopupResizeDrag(type){
     log("dynamicPopupResizeStart:type="+type)
    var evtobj=window.event? window.event : e
        
 
    if( type == 0 ){
        var pw = oPopupOldWidth+(parseInt(evtobj.clientX)-this.resizeLeft);       
        var dw = divObjOldWidth+(parseInt(evtobj.clientX)-this.resizeLeft);  
        if(  dw > parseInt(this.divObj.oldWidth )){          
            this.oPopup.style.width = pw;
            this.divObj.style.width = dw;
        }
    }else if( type == 1 ){
        var ph = oPopupOldHeight+(parseInt(evtobj.clientY)-this.resizeTop);
        var dh = divObjOldHeight+(parseInt(evtobj.clientY)-this.resizeTop);         
        if(  dh > parseInt(this.divObj.oldHeight )){ 
            this.oPopup.style.height = ph;
            this.divObj.style.height = dh; 
        }
    }
}
function dynamicPopupResizeDragEnd(type){
    this.divObj.isResize = true;
}


function makeCheckListDragHtml(data,objName,inputObjName,title1,title2,option,isAllCheck){
    if( option == undefined)
        option = "";
    var allCheckText = "";
    var callAllCheckText = "";
    if( isAllCheck == true){
        allCheckText = "<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjName+"');\" checked>";
        callAllCheckText = "onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjName+"');\"";
    }
    var html = "\n"
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
    
        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
                
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
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='dynamicPopupClose()'></td> \n"
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
        var obj = document.createElement("DIV");
        obj.id = "DIV__"+objName+"__DIV";
        obj.style.display = "none";
        obj.style.position = "absolute";
        obj.style.zIndex=100;
        obj.isResize=false;
        obj.oldWidth=0;
        obj.oldHeight=0;
        
    
        obj.innerHTML = html;
        document.body.appendChild(obj);
    }else{
        var obj = document.getElementById("DIV__"+objName+"__DIV");
        obj.style.display = "none";
        obj.innerHTML = html;        
    }
}
 
 
 
function makeCheckListDragHtml2(data,objName,inputObjName,title1,title2,title3,option,isAllCheck){
    if( option == undefined)
        option = "";
    var allCheckText = "";
    var callAllCheckText = "";
    if( isAllCheck == true){
        allCheckText = "<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"dynamicPopupAllCheck(this,'"+inputObjName+"');\" checked>";
        callAllCheckText = "onClick=\"dynamicPopupChangeCheckBox(this,'dynamicpopup_allcheck_"+inputObjName+"');\"";
    }
    var html = "\n"
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
    
        +"<DIV style='OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT: 100%' >"
                
        +"			<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;background-color:#C0EBA3;' border='1'  ><tr><td>  \n"
        +"				<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
        +"				<tr style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>  \n"
        +" 						<td width='35%' style='border:1px solid #A3A4C7;'>"+title1+"</td>  \n"				       
        +" 						<td width='35%' style='border:1px solid #A3A4C7;'>"+title2+"</td>  \n"
        +" 						<td width='30%' style='border:1px solid #A3A4C7;'>"+title3+"&nbsp "+allCheckText+"</td>  \n"
        +" 		</tr> \n";        
    for(var i=0 ; i < data.length ; i++){   
        for(var j=0 ; j < data[i].child_cnt ; j++){   
            html +="	<tr style='height:23;font-family: Arial;  font-size: 10px;text-align:center; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7; '>  \n"
            if( j == 0 ){
                html +="					<td width='35%' style='border:1px solid #A3A4C7;' rowspan='"+data[i].child_cnt+"'>"+data[i].parent_data+"</td>  \n";
            }
            html +="					<td width='35%' style='border:1px solid #A3A4C7;'>"+data[i].child_data_arr[j]+"</td>  \n"
                 +"					<td width='30%' style='border:1px solid #A3A4C7;'><input type=checkbox value=\""+data[i].child_data_arr[j]+"\"  name="+inputObjName+"   id="+inputObjName+" "+callAllCheckText+" oldValue=true checked></td>  \n";
            html +="				</tr>          \n";
        }
    }
    html +="				</table>  \n"
        +"			</td>  \n"
        +"			</tr>	  \n"			
        +"			</table>  \n"
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
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();processPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='dynamicPopupClose()'></td> \n"
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
        var obj = document.createElement("DIV");
        obj.id = "DIV__"+objName+"__DIV";
        obj.style.display = "none";
        obj.style.position = "absolute";
        obj.style.zIndex=100;
        obj.isResize=false;
        obj.oldWidth=0;
        obj.oldHeight=0;
        
    
        obj.innerHTML = html;
        document.body.appendChild(obj);
    }else{
        var obj = document.getElementById("DIV__"+objName+"__DIV");
        obj.style.display = "none";
        obj.innerHTML = html;        
    }
}
 
 /****************************************************************************/
 /*     drag안되는 팝업 */
 /****************************************************************************/
 function initCheckListPopup(data,objName,inputObjName,title1,title2,option,isAllCheck){
    if( isAllCheck == undefined){
        isAllCheck = false;
    }
    makeCheckListHtml(data.split("|"),objName,inputObjName,title1,title2,option,isAllCheck);
}

 function openDynamicPopup(x,y,width,height,html,parentObj){
    if( oPopup == null){
        oPopup = window.createPopup(); 
    }
    oPopup.document.body.innerHTML =html;
    oPopup.show(x,y,width,height,parentObj);
    return oPopup;

} 
 
 function makeCheckListHtml(data,objName,inputObjName,title1,title2,option,isAllCheck){
    if( option == undefined)
        option = "";
    var allCheckText = "";
    var callAllCheckText = "";
    if( isAllCheck == true){
        allCheckText = "<input type=checkbox id=dynamicpopup_allcheck_"+inputObjName+"  onClick=\"parent.dynamicPopupAllCheck(this,document.getElementsByName('"+inputObjName+"'));\" checked>";
        callAllCheckText = "onClick=\"parent.dynamicPopupChangeCheckBox(this,document.getElementById('dynamicpopup_allcheck_"+inputObjName+"'));\"";
    }
    var html = "\n"
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
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='parent.oPopup.hide();parent.processPopupOK(\""+objName+"\",\""+inputObjName+"\",document.body.outerHTML);'></td> \n"
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='parent.oPopup.hide()'></td> \n"
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
        var obj = document.createElement("DIV");
        obj.id = "DIV__"+objName+"__DIV";
        obj.style.display = "none";
        obj.innerHTML = html;
        document.body.appendChild(obj);
    }else{
        var obj = document.getElementById("DIV__"+objName+"__DIV");
        obj.style.display = "none";
        obj.innerHTML = html;        
    }
}

/*********************************************************************************************
 *  sheet를 올려서 drag popup을 만든 버젼임
 * 
 ********************************************************************************************/
 



function dynamicInitSheet(inputObjName,arrTitle,cellWidth,isAllCheck){
    var dynamicSheet = document.getElementById(inputObjName);
    
    var sheetTitle = "";
    for(var i = 0 ; i < arrTitle.length ; i++){
        if( i > 0 ){
            sheetTitle += "|";
        }
        sheetTitle += arrTitle[i];
    }

    var colCnt = arrTitle.length;
    comConfigSheet (dynamicSheet , SYSTEM_ENIS);
    with (dynamicSheet) {

            CountPosition = 0;
            HeadBackColor         = RgbColor(233,249,251);
			style.height = "100%";
			//전체 너비 설정
			SheetWidth = eval("div_"+inputObjName).clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

		   //전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(colCnt+2, 0 , 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(false, false, false, true, false, false) ;
	        InitHeadRow(0, sheetTitle , true);			
			//changeHeadTitle(sheetObj);
            var cnt=0
		   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		    for(var i=0 ; i < colCnt ; i++){
		        if( i == colCnt-1 ){
    	       		InitDataProperty(0, i , dtImageText,      cellWidth[i],    daCenter,   true,    "chk_value",     false,          "",       dfNone,          0,     true,       true);
    	       		InitDataProperty(0, i+1 , dtHidden,       20,    daCenter,   true,    "value",     false,          "",       dfNone,          0,     true,       true);		            
                    InitDataProperty(0, i+2 , dtHidden,       20,    daCenter,   true,    "old_chk_value",     false,          "",       dfNone,          0,     true,       true);		                	       		
		        }else{
        			InitDataProperty(0, i , dtData,       cellWidth[i],    daCenter,   true,    "data"+i,     false,          "",       dfNone,          0,     false,       false);	            
		        }
		    }

		    if(isAllCheck == true || isAllCheck == "true"){
				/* 이미지 적용 시작 */
                ImageList(0) = ICO_UNCHECK;
                ImageList(1) = ICO_CHECK;

                InitDataImage(0, "chk_value", daCenter); 
                
                CellImage(0, "chk_value") = 1;			
                HeaderImageAlign(0,"chk_value") = daLeft;
                /* 이미지 적용 끝 */						
		        
		    }
		    
    }
    comEndConfigSheet(dynamicSheet);   


}
function dynamicInitSheetData(inputObjName,data,logObj){
    var dynamicSheet = document.getElementById(inputObjName);
    var arrData = parseDynamicArrData(data);
    var rowCnt = arrData.length;
    var AllCheck = 1;
    
    //Filter 적용후 조건 변경해서 조회시 없던 Lane등에 대해 Header 값과 동일하게 하기위한 로직
    for(var row = 0 ; row < rowCnt -1;row++ ){
        var colCnt = arrData[row].length;
        for(var col = 0 ; col < colCnt ; col++){
            if( col == colCnt-1 ){
                var arrValue = arrData[row][col];
            	if(logObj != undefined && logObj != null && logObj[arrValue] != null && logObj[arrValue] != undefined && logObj != "false" && logObj[arrValue] != 1){
            	    AllCheck = 0;
            	    break;
            	}
            }
        }
        if(AllCheck == 0) break;
    }
    
    for(var row = 0 ; row < rowCnt -1;row++ ){
        var insertRow = dynamicSheet.DataInsert();
        var colCnt = arrData[row].length;
        for(var col = 0 ; col < colCnt ; col++){
            dynamicSheet.CellValue2(insertRow,"data"+col) = arrData[row][col];
            if( col == colCnt-1 ){
                dynamicSheet.CellValue2(insertRow,"value") = arrData[row][col];
            	if(logObj == undefined || logObj == null || logObj[dynamicSheet.CellValue(insertRow, "value")]==null || logObj == "false"){
            	    if(AllCheck != 0){
            	        dynamicSheet.CellImage(insertRow, "chk_value") = 1;
            	        dynamicSheet.CellValue2(insertRow, "old_chk_value") = 1;
            	    }else{
            	        //Filter 적용후 조건 변경해서 조회시 없던 Lane등에 대해 Header 값과 동일하게 하기위한 로직
            	        dynamicSheet.CellImage(insertRow, "chk_value") = 0;
            	        dynamicSheet.CellValue2(insertRow, "old_chk_value") = 1;
            	    }
            	}else{
	                dynamicSheet.CellImage(insertRow, "chk_value") = logObj[dynamicSheet.CellValue(insertRow, "value")];
	                dynamicSheet.CellValue2(insertRow, "old_chk_value") = (logObj[dynamicSheet.CellValue(insertRow, "value")] == 1 ? 0 : 1);
            	}
            }
        }
    }
    dynamicSheet.SelectCell(1, 1, false);
}

function parseDynamicArrData(data){

    var arrData = data.split(";");
    for(var i = 0 ; i < arrData.length-1 ; i++){
        arrData[i] = arrData[i].split("|");
    }    
    return arrData;
}
 function initCheckListDragPopupSheet(data,objName,inputObjName,arrTitle,cellWidth,option,isAllCheck, logObj){
    if( isAllCheck == undefined){
        isAllCheck = false;
    }
     if( this.oPopup != null){
         this.oPopup.style.display ="none"
     }
     if( this.divObj != null){
         this.divObj.style.display ="none"
     }     
    cellWidth = cellWidth.split(":");
    
    if(logObj==null || logObj==undefined){
    	logObj = "";
    }else{
	    logObj = logObj[objName];
    }
    
    makeCheckListDragHtmlSheet(objName,inputObjName,option,isAllCheck);
    dynamicInitSheet(inputObjName,arrTitle,cellWidth,isAllCheck);
    dynamicInitSheetData(inputObjName,data,logObj);
//    changeHeaderFilterColor(objName,inputObjName);
    logObjValue(objName,inputObjName,logObj);
}

function logObjValue(objName,inputObjName,logObj){
    var sheetObj = eval(inputObjName);
    
    if(logObj[objName]){
    	for(i=1;i<sheetObj.Rows;i++){
    		logObj[objName][sheetObj.CellValue(i,"value")] = sheetObj.CellImage(i,"chk_value");
    	}
    }
}

function dynamicSheet_OnClick(sheetObj,row,col,value){
        
    var ICO_UNCHECK_IDX = 0;    
    var ICO_CHECK_IDX = 1;    
    with(sheetObj){
        var colName = ColSaveName(col)
        if( colName == "chk_value"){
            var v = CellImage(row, "chk_value") ;
            if(v == ICO_UNCHECK_IDX ){
                CellImage(row, "chk_value") = ICO_CHECK_IDX;               
            }else{
                CellImage(row, "chk_value") = ICO_UNCHECK_IDX;
                CellImage(HeaderRows-1, colName) = ICO_UNCHECK_IDX;                            
            }
        }
    }     
}
function dynamicSheet_OnMouseDown(sheetObj,button,shift,x,y){
    with(sheetObj){
        var row = MouseRow;
        var col = MouseCol;
        var popupWidth = 200;
        var popupHeight = 200;

        if( row < HeaderRows && row > -1 ){
            var colName = ColSaveName(col);
            if( colName == "chk_value"){
                changeDynamicSheet_AllCheck(sheetObj,"chk_value");
            }

        } 	        
    } // end with
}
function changeDynamicSheet_AllCheck(sheetObj,colName){
    if( sheetObj.RowCount == 0 ){
        return;
    }    
    var ICO_UNCHECK_IDX = 0;    
    var ICO_CHECK_IDX = 1;

    var check_cd = "0";
    with(sheetObj){
       var head = CellImage(HeaderRows-1, colName);
       if( head == ICO_CHECK_IDX ){
           check_cd = "0";
           CellImage(HeaderRows-1, colName) = ICO_UNCHECK_IDX;
       }else if( head == ICO_UNCHECK_IDX ){
           check_cd = "1"; 
           CellImage(HeaderRows-1, colName) = ICO_CHECK_IDX;
       }
       
       for(var i= HeaderRows  ; i <= LastRow ; i++){
           CellImage(i , colName) = CellImage(HeaderRows-1, colName);
       }
    }

}




/*
 * 팝업에서 변경된 내용에 따라 필터링 Biz Logic 수행 (ESM_SAQ_042 와 동일함)
 */
function processDynamicPopupHideRow(divObj,chkSheetObj,inputObjects){
    log("processHideRow call : divObj=" + divObj + " objValue= " + objValue + " inputObjects.length=" + inputObjects.length);

    for(var row = chkSheetObj.HeaderRows ; row <= chkSheetObj.LastRow ; row++){    
        var objChkValue = chkSheetObj.CellImage(row,"chk_value");
        var objOldChkValue = chkSheetObj.CellValue(row,"old_chk_value");
        var objValue = chkSheetObj.CellValue(row,"value");
        if( objChkValue !=  objOldChkValue ){
            var sheetObj = document.getElementById(divObj.sheetName);     
            var colName = divObj.colName;
            var cols = new Array();
            var values = new Array();
            //보여준다.
            if( objChkValue == 1 ){
                    cols[0] = colName;
                    values[0]= objValue;                  
                var filterCnt = processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,true);  
                if( colName == "item" && objValue == "Load"){
                    values[0] = "L/F";
                    processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,true);  
                }            
            //숨긴다.
            }else if( objChkValue == 0 ){
                
                cols[0] = colName;
                values[0]= objValue;   
                
                var filterCnt = processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects ,false);  
                if(colName == "item" && objValue == "Load"){
                    values[0] = "L/F";
                    processDynamicPopupFilterSheet(sheetObj,cols,values,inputObjects,false);  
                }              
            }
            chkSheetObj.CellValue2(row,"old_chk_value") = objChkValue;
        }
    }
    changeHeaderFilterColor(divObj,chkSheetObj);
}

/*
 * ESM_SAQ_085 프로그램 전용 필터링 (ESM_SAQ_042 와 동일함)
 */
function processDynamicPopupFilterSheet(sheetObj,cols, oriValues,inputObjects, isDisplay ){
     log("processDynamicPopupFilterSheet : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
     log("processDynamicPopupFilterSheet : cols.length=" + cols.length);
     
     var filterCnt= 0;

     var selRow = 0;
     var flg ;
     for(var i=0 ; i <= sheetObj.LastRow ; i++){
         flg = false;
         //해당 컬럼 모두 일치하는 row를 찾는다.
         for(var j = 0 ; j < cols.length ; j++ ){
             selRow = sheetObj.FindText(cols[j],oriValues[j],selRow);
             //log("processFilterSheet : sheetObj.FindText("+cols[j]+","+oriValues[j]+","+selRow+") =" + selRow);
             if( selRow < 0 ){//찾는 값이 없다..
                 break;
             }
         }  
         if( selRow >= 0  ){
             i = selRow; 
             selRow++;  
             // 찾은 row의 모든 값이 일치하는지 검사한다.
             for(var j = 0 ; j < cols.length ; j++ ){
                 if(oriValues[j] != sheetObj.CellValue(i,cols[(j)])  ){
                     flg = true;
                     break;
                 }
             }   
             if(flg == false  ){
                 if( isDisplay == true){
                     if( filterValidation(sheetObj,i,cols,inputObjects) ){
                         sheetObj.RowHidden(i) = !isDisplay;
                     }
                 }else{                 
                    sheetObj.RowHidden(i) = !isDisplay;
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
    var str = "";
    if( isAll == undefined){
        isAll = true;
    }
    if(option == undefined){
        option  = "";
    }
    
    
    
    var ICO_UNCHECK_IDX = 0;    
    var ICO_CHECK_IDX = 1;

    var check_cd = "0";
    with(sheetObj){
       for(var i= HeaderRows  ; i <= LastRow ; i++){
            if( isAll == false ){
                if(  CellImage(i , "chk_value")  == ICO_CHECK_IDX ){
                    str += CellValue(i,"value" )+":true|";
                }
            }else{
                if(  CellImage(i , "chk_value")  == ICO_CHECK_IDX ){
                    str += CellValue(i,"value" )+":true|";
                }else{
                    str += CellValue(i,"value" )+":false|";
                }                
            }
       }
    }
    str += option;    
    return str;   
}

function makeCheckListDragHtmlSheet(objName,inputObjName,option,isAllCheck){
    if( option == undefined)
        option = "";

    var html = "\n"
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
        + SheetObjectTag(inputObjName)
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
//        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();changeHeaderFilterColor(\""+objName+"\",\""+inputObjName+"\");processSheetPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_ok.gif' width='66' height='20' border='0' name='btn_ok' onClick='dynamicPopupClose();processSheetPopupOK(\""+objName+"\",\""+inputObjName+"\");'></td> \n"
        +" 						<td align=center><img class='cursor' src='/opuscntr/img/opus/button/btn_close.gif' width='66' height='20' border='0' name='btn_close' onClick='dynamicPopupClose()'></td> \n"
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
        var obj = document.createElement("DIV");
        obj.id = "DIV__"+objName+"__DIV";
        obj.style.display = "none";
        obj.style.position = "absolute";
        obj.style.zIndex=100;
        obj.isResize=false;
        obj.oldWidth=0;
        obj.oldHeight=0;
        obj.innerHTML = html;
        document.body.appendChild(obj);
    }else{
        var obj = document.getElementById("DIV__"+objName+"__DIV");
        obj.style.display = "none";
        obj.innerHTML = html;        
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
    var inputCnt = inputObjName.length;
   
    if( isAllCheck == undefined){
        isAllCheck = false;
    }
    sheetRatio = getDefaultValueSheetRatio(inputCnt,sheetRatio)
    cellWidth = getDefaultValueCellWidth(inputCnt,arrTitle,cellWidth)

 
   makeCalcCheckListDragHtmlSheet(objName,inputObjName,sheetRatio,isAllCheck);

   for(var i = 0 ; i < inputCnt ; i++){    
       dynamicInitSheet(inputObjName[i],arrTitle[i],cellWidth[i],isAllCheck[i]);
       dynamicInitSheetData(inputObjName[i],data[i]);
   }
    
} 
function getDefaultValueSheetRatio(inputCnt,sheetRatio){

    if( sheetRatio == undefined ){
        sheetRatio = new Array();
        for(var i = 0 ; i < inputCnt ; i++){    
           sheetRatio[i] = 100/inputCnt;
        }
    }else{
        sheetRatio = sheetRatio.split(":");
    }    
    return sheetRatio;
}
function getDefaultValueCellWidth(inputCnt,arrTitle,cellWidth){
    if( cellWidth == undefined ){
        cellWidth = new Array();
        for(var i = 0 ; i < inputCnt ; i++){   
            cellWidth[i] = new Array();
            for(var j = 0 ; j < arrTitle[i].length ; j++){ 
               cellWidth[i][j] = 100/arrTitle[i].length;
            }
        }
    }else{
        for(var i = 0 ; i < inputCnt ; i++){   
           cellWidth[i] = cellWidth[i].split(":");
        }
    }  
    return cellWidth;  
}

// Apply 버튼 Popup창을 그린다.
// 그리드가 2개짜리
function makeCalcCheckListDragHtmlSheet(objName,inputObjName,sheetRatio,isAllCheck){
 
    var html = "\n"
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
            + SheetObjectTag(inputObjName[i])
            + '<script language="javascript" for="'+inputObjName[i]+'" event="OnClick(arg1,arg2, arg3)">dynamicSheet_OnClick(this,arg1,arg2,arg3);</script>'
            + '<script language="javascript" for="'+inputObjName[i]+'" event="OnMouseDown(arg1,arg2,arg3,arg4)">dynamicSheet_OnMouseDown(this,arg1,arg2,arg3,arg4);</script>'
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
        +" 									<IMG style='cursor:hand' onclick='dynamicPopupClose();processCalcPopupOK(\""+objName+"\");' height=20 src=\"/opuscntr/img/opus/button/btn_ok.gif\" width=66 border=0 name=btn_ok> \n"
        +" 								</TD> \n"
        +" 								<TD align=middle> \n"
        +" 									<IMG style='cursor:hand' onclick=dynamicPopupClose() height=20 src=\"/opuscntr/img/opus/button/btn_close.gif\" width=66 border=0 name=btn_close> \n"
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
        var obj = document.createElement("DIV");
        obj.id = "DIV__"+objName+"__DIV";
        obj.style.display = "none";
        obj.innerHTML = html;
        document.body.appendChild(obj);
    }else{
        var obj = document.getElementById("DIV__"+objName+"__DIV");
        obj.style.display = "none";
        obj.innerHTML = html;    

    }  
} 
 
/////////////////// Test 용 
 
 
function popupHelpInfo(){
	var html = "";

	html = html 
			+ '	<link href="/opuscntr/css/opus_contents.css" rel="stylesheet" type="text/css">'
			+ '<table class="search" bordercolor="gray" border="1" style="border-collapse: collapse; width:100%; height:100%;padding:6px; background-color:#FFFFFF; border:2px solid #A3A4C7;">'
 			
			+ ' <tr><td>'
			+ ' <div onDragStart="dynamicPopupDragStart()"  onDragEnd="dynamicPopupDragEnd()" onDrag="dynamicPopupDrag()">' 
			+ ' <table onselectstart="return false" class="search" bordercolor="gray" border="1" style="width:100%; height:20px;cursor:hand;">' 
			+ '	<tr class="h23" bgcolor="#1083CF" align=center>'
			+ '		<td  colspan=2 ><font color="DDDDDD">Status Code Information</font></td>'
			+ '	</tr>'
			+ ' </table></div>'
			+ '<table class="search" bordercolor="gray" border="1" style="width:100%;height:260px ">'
			+ '	<tr class="h23" bgcolor="DDDDDD" align=center style="border:1px solid #000000">'
			+ '		<td  width="60" class="bg_a">Status</td>'
			+ '		<td  width="110" class="bg_a">Description</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" ></td>'
			+ '		<td width="130" >Initial Draft</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >DC</td>'
			+ '		<td width="130" >Draft Confirmed</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >DN</td>'
			+ '		<td width="130" >Draft Notified</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >DR</td>'
			+ '		<td width="130" >Draft Received</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >FR</td>'
			+ '		<td width="130" >Final Received</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >FC</td>'
			+ '		<td width="130" >Final Confirmed</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >FN</td>'
			+ '		<td width="130" >Final Notified</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >QN</td>'
			+ '		<td width="130" >Quota Notified</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >QF</td>'
			+ '		<td width="130" >Quota Finalized</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td width="60" >XX</td>'
			+ '		<td width="130" >Cancelled</td>'
			+ '	</tr>'
			+ '	<tr align=center>'
			+ '		<td colspan="2" align="right" valign="bottom">'
			+ '		<img class="cursor"src="/opuscntr/img/opus/button/btn_close.gif" onclick="dynamicPopupClose();">'
			+ '		</td>'
			+ '	</tr>'
			+ '</table>'			
			+ '</td><td rowspan=2 style="width:2px;padding:0px; border:0px;background-color:#000000"></td></tr>'
			+ '<tr style="height:10px;padding:0px; border:0px;background-color:#000000">'
			+ '</tr>'
			+ '	</table>';
	
    var obj = document.createElement("DIV");
    obj.id = "popupCode";
    obj.style.display = "none";
    obj.style.position = "relative";
    obj.style.zIndex=100;
    obj.style.left = 0;//popup_marginLeft;
    obj.style.top = 0;//popup_marginTop;
    obj.isResize=false;
    obj.oldWidth=0;
    obj.oldHeight=0;
    obj.innerHTML = html;
    document.body.appendChild(obj);

	var helpObj = document.getElementById("popupCode");

	var pObj = document.getElementsByName("help")[0];
	var evtobj=window.event? window.event : e
	if(helpObj.style.display=="none"){		
		openDynamicDragPopup(helpObj,15,0,190,290,pObj,"LEFT");		
	}else{
		dynamicPopupClose();
	}
} 

var popupCodeInfoClosed=false;
 