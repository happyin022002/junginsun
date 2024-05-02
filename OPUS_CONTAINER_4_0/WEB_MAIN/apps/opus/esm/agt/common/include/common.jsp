<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.StringTokenizer" %>
<%-------------------- 공통팝업페이지에 포함할 스크립트 START --------------------%>
<SCRIPT LANGUAGE="javascript"><!--

<%
	// Popup 모드 (1: function 호출형, 2: target 세팅형)
	String pop_mode = request.getParameter("pop_mode");	
	if(pop_mode == null || pop_mode.equals(""))
		pop_mode = "1";

	// 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
	String func  = request.getParameter("func");

	// 값을 세팅할 부모창의 Object목록 (pop_mode가 2(target 세팅형) 인 경우)
	String targetObjList = request.getParameter("targetObjList");
	
	// Multi Sheet인 경우, 데이터를 가져올 Sheet 정보
	String sheet = request.getParameter("sheet");	
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row = request.getParameter("row");
	String col = request.getParameter("col");	
	
	// 해당 공통 팝업 ID
	//String classId = request.getParameter("classId");	
	
	String strDisplay = request.getParameter("display");
	String strPopOpt  = null;
	String popKind	  = null;
	
	if(strDisplay != null && strDisplay.length() >= 3) {
		strPopOpt = strDisplay.substring(0,3);
	}
	
//	if(strPopOpt != null) {
//		if("0,1".equals(strPopOpt)) {
//			popKind = "check";
//		} else if("1,0".equals(strPopOpt)) {
//			popKind = "radio";
//		} else if("0,0".equals(strPopOpt)) {
//			popKind = "row";
//		} 
//	}
	
	if("none".equals(strDisplay)) {
		popKind = "none";
	} else {
		if(strDisplay != null && strDisplay.length() >= 3) {
			strPopOpt = strDisplay.substring(0,3);
		}
		
		if(strPopOpt != null) {
			if("0,1".equals(strPopOpt)) {
				popKind = "checkbox";
			} else if("1,0".equals(strPopOpt)) {
				popKind = "radio";
			} else if("0,0".equals(strPopOpt)) {
				popKind = "row";
			} 
		}
	}
%>	
	var sheet = <%= sheet %>
	
	var sheetObj = null;
	
	if(sheet == 3) {
		sheetObj = sheetObjects[2];
	}else if(sheet == 2) {
		sheetObj = sheetObjects[1];
	}else {
		sheetObj = sheetObjects[0];
	}

	function comPopupOK() {
		<%
			if(pop_mode != null && pop_mode.equals("1")) {
		%>
				callParentFunc();
		<%
			} else if(pop_mode != null && pop_mode.equals("2")) {
		%>
				setParentTarget();
		<%
			}
		%>
		
	}
	
	// 부모창의 function을 호출
	function callParentFunc() {		
		if("<%=func%>" == null || "<%=func%>" == ""){
			window.close();
			return;
		}
		
		var rArray = null; //Array having Row data

		// 단일Optional(Radio) 또는 다중Optional(CheckBox) 일 때..
		if("<%=popKind%>" == "radio" || "<%=popKind%>" == "checkbox") {
			if("<%=sheet%>" == 6){				//ESM_AGT_0037.jsp 용 추가
				rArray = getESM_AGT_037("info_no");
			}else if("<%=sheet%>" == 5){				//ESM_AGT_0006.jsp 용 추가
				rArray = getESM_AGT_006();
			}else if("<%=sheet%>" == 4){		//ESM_AGT_0005.jsp 용 추가
				rArray = getESM_AGT_005();
			}else if("<%=sheet%>" == 35){		//ESM_AGT_0035.jsp 용 추가
				rArray = getESM_AGT_035();			
			}else{
				rArray = getCheckedRows();
			}
			if(rArray == null) {
				//ComShowMessage("[<%=popKind%>] please select!");
				ComShowMessage("Please select CheckBox!");
				return;
			}
        }
        // Optional박스가 없는경우.. 단일Optional
        else {
        	rArray = getSelectedRow();
        	if(rArray == null) {
				//ComShowMessage("[<%=popKind%>] please select!");
				ComShowMessage("Please select CheckBox!");
				return;
			}
        }
        
		// 모달창인 경우는 window 객체로부터 opener를 획득
		if(!opener)
			opener = window.dialogArguments;
		
		try {			
			<%
				if(func != null && !func.equals("")) {					
					if(row != null && col != null) {
			%>
						opener.<%= func %>(rArray, <%=row%>, <%=col%>);
						window.close();
			<%
					} else {
			%>
						opener.<%= func %>(rArray);
						window.close();
			<%
					}
				}
			%>
		}
		catch(e) {
		 	ComShowMessage("부모창에 [<%= func %>" + "] 메소드가 없습니다.");
		}
	}
	
	// 부모창의 Target Object에 값 세팅
	function setParentTarget() {
		<%
			// Target 정보가 없을시 Return
			if(targetObjList == null || targetObjList.equals("")) {
		%>
				window.close();
				return;
		<%
			} else {
			
			StringTokenizer tokenTarget = new StringTokenizer(targetObjList, "|");
			while(tokenTarget.hasMoreTokens()) {
				String unit = (String)tokenTarget.nextToken();
				if(unit.indexOf(":") != -1) {
					StringTokenizer tokenUnit = new StringTokenizer(unit, ":");
					
					String popSource = (String)tokenUnit.nextToken();
					String parentTarget = (String)tokenUnit.nextToken();
		%>
					// 모달창인 경우는 window 객체로부터 opener를 획득			        
					if(!opener)
						opener = window.dialogArguments;
						
					var rArray = null; 	// Array having Row data
					var val	   = "";	// Target Object에 세팅할 값
					
					var tagName = opener.document.all["<%=parentTarget%>"].tagName;
					
					// 단일Optional(Radio) 또는 다중Optional(CheckBox) 일 때..
					if("<%=popKind%>" == "radio" || "<%=popKind%>" == "checkbox") {
						rArray = getCheckedRows("<%=popSource%>");
			        }
			        // Optional박스가 없는경우.. 단일Optional
			        else {
			        	rArray = getSelectedRow("<%=popSource%>");
			        }
					
					// Target Object에 Insert할 값을 획득
					for(var i=0; i<rArray.length; i++) {
						if(i == 0) {
							val += rArray[i];
							
							// Combo박스인 경우는 맨 처음 값으로 세팅 후 break
							if(tagName == "SELECT") {								
								break;
							}
						} else {
							// 중복체크
							if(!chkDup(val, rArray[i]))
								val += "," + rArray[i];
						}
					}
					
					// Target Object에 값 세팅
					try {
						opener.document.all["<%=parentTarget%>"].value = val;
						
						try {
							// Target Object에 OnChange 이벤트 발생시킨다.
							// => 이것은 Onchange 이벤트를 지정한 Object에만 영향을 끼친다.
							opener.document.all["<%=parentTarget%>"].fireEvent("onchange");
						} catch(e) {}
						
						window.close();
						
					}
					catch(e) {
					 	ComShowMessage("부모창에 [<%=parentTarget%>] 객체를 찾을 수 없습니다.");
					}
		<%		
				}
			}	
			}
		%>
	}
	
	function chkDup(val, ind) {
		var bDup = false;
		
		var arrVal = val.split(",");
		for(var i=0; i<arrVal.length; i++) {
			if(arrVal[i] == ind) {
				bDup = true;
				break;
			}
		}
		
		return bDup;
	}
	
	function getSelectedRow(colName) {
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		var selectRow = sheetObj.SelectRow;
        	
       	if(selectRow == 0) {
       		return null;
       	}
       	else {
       		rArray = new Array(1);
       		
       		// 특정 컬럼명이 지정된 경우
       		if(colName != null && colName != "") {
       			cArray = sheetObj.CellValue(i, colName);
       		} else {
	       		cArray = new Array(colsCnt);
	       		
	  			for(var j=0; j<cArray.length; j++) {
	               	cArray[j] = sheetObj.CellValue(selectRow, j);
	            }
	        }
            rArray[0] = cArray;
       	}
	}
	
	function getCheckedRows(colName) {
		
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		checkRows = sheetObj.CheckedRows("<%=popKind%>");
		if(checkRows == 0) {  			
  			return null;
  		}
  		else {
  			var idx = 0;
	  		rArray = new Array(checkRows);
	  		
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "<%=popKind%>") == 1) {					
		  			cArray = null;
		  			
		  			// 특정 컬럼명이 지정된 경우
		  			if(colName != null && colName != "") {
		  				cArray = sheetObj.CellValue(i, colName);
		  			} else {
		  				cArray = new Array(colsCnt);
		  				
			  			for(var j=0; j<cArray.length; j++) {
	                    	cArray[j] = sheetObj.CellValue(i, j);
	                    }
	                }
                    rArray[idx++] = cArray;
	     		}
	  		}
	  	}
	  	
	  	return rArray;
	}
	
	function getESM_AGT_005(colName) {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var checkRows;
		var checkRows1;
		var checkRows2;

		var rows1 = sheetObj1.Rows;
		var rows2 = sheetObj2.Rows;
		var shtObjValue1 = "";
		var shtObjValue2 = "";
		
		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		checkRows1 = sheetObj1.CheckedRows("checkbox");
		checkRows2 = sheetObj2.CheckedRows("checkbox");
		checkRows = checkRows1 + checkRows2;

		if(checkRows == 0) {  			
  			return null;
  		}
  		else {
  			var idx = 0;
	  		rArray = new Array(1);
	  		if(checkRows1 > 0){
	  			for(var i = 0; i < rows1; i++) {
					if(sheetObj1.CellValue(i, "checkbox") == 1) {					
			  			shtObjValue1 = shtObjValue1 + "1-" +sheetObj1.CellValue(i, "rep_chg_cd") + ",";
			  		}
			  	}
			  	shtObjValue1 = shtObjValue1.substr(0, shtObjValue1.length -1);
		  	}
		  	
		  	
		  	if(checkRows2 > 0){
	  			for(var j = 0; j < rows2; j++) {
					if(sheetObj2.CellValue(j, "checkbox") == 1) {					
			  			shtObjValue2 = shtObjValue2 + "2-" + sheetObj2.CellValue(j, "chg_cd") + ",";
			  		}
			  	}
			  	shtObjValue2 = shtObjValue2.substr(0, shtObjValue2.length -1);
		  	}
		  	
		  	
		  	if(checkRows1 > 0 && checkRows2 > 0){
		  		rArray[0] = shtObjValue1 + "," +shtObjValue2;
		  	}else if(checkRows1 == 0) {
		  		rArray[0] = shtObjValue2;		  			
	  		}else if(checkRows2 == 0){
	  			rArray[0] = shtObjValue1;
	  		}
	  	}
	  	
	  	return rArray;
	}
	
	function getESM_AGT_006() {
	var frm = document.form;
	var elems = frm.elements;

    var l = elems.length;
    var check = "";
    	for(var i = 0; i < l; i++) {
        var elem = elems[i];
        	switch(elem.type) {
            	case "radio":
                	var eRadio = document.all[elem.name];
                    var rdo = null;
                    if(eRadio.length > 1) {
                        for(var j = 0; j < eRadio.length; j++) {
                            if(eRadio[j].checked == true){
                             	check = eRadio[j].value;
                            }
                        }
                        if(check == ""){
                        	return;
                        }
                    } else {
                        return;
                    }
            	break;                    
        	} 
        }
        
        var sheetObj;
        if(check == 5){
        	var sheetObj = sheetObjects[3];
        }else if(check == 6){
        	var sheetObj = sheetObjects[4];
        }else{
        	var sheetObj = sheetObjects[check];
        }
        

		var checkRows;
		var rows = sheetObj.Rows;
		
		var shtObjValue = "";
		//var shtObjValue1 = "";
		//var shtObjValue2 = "";
		
		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		checkRows = sheetObj.CheckedRows("checkbox");

		if(checkRows == 0) {  			
  			return null;
  		}else {
  			var idx = 0;
	  		rArray = new Array(1);
	  		var setInt = ++check;
	  		if(checkRows > 0){
	  			for(var i = 0; i < rows; i++) {
					if(sheetObj.CellValue(i, "checkbox") == 1) {
						shtObjValue = shtObjValue + setInt + "-" +sheetObj.CellValue(i, sheetObj.ColSaveName(3)) + "," ;
			  		}
			  	}
		  	}
		  	check++	  	
		  	if(checkRows > 0){
		  		rArray[0] = shtObjValue.substr(0, shtObjValue.length -1);
		  	}
	  	}
	  	
	  	return rArray;		
		
	}
	
	function getESM_AGT_035() {

		var sheetObj = sheetObjects[0];
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var arrRows = rows - 1;

		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열

		if(rows == 0) {  			
  			return null;
  		}
  		else {
  			var idx = 0;
	  		rArray = new Array(arrRows);
	  		
			for(var i = 1; i < rows; i++) {
			
  				cArray = new Array(colsCnt);
  				
	  			for(var j=0; j<cArray.length; j++) {
                   	cArray[j] = sheetObj.CellValue(i, j);
                }
                
                rArray[idx++] = cArray;

	  		}
	  	}

	  	return rArray;
	}
	
	function getESM_AGT_037(colName) {
		var sheetObj = sheetObjects[0];
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var arrRows = rows - 1;
		//alert(colName);
		var rArray = null; //Array having Row data
    	var cArray = null; //열데이터를 담고 있는 배열

		if(rows == 0) {  			
  			return null;
  		}
  		else {
  			var idx = 0;
	  		rArray = new Array(arrRows);
	  		
			for(var i = 1; i < rows; i++) {
		  			
		  			// 특정 컬럼명이 지정된 경우
		  			if(colName != null && colName != "") {
		  				cArray = sheetObj.CellValue(i, colName);
		  			} else {
		  				cArray = new Array(colsCnt);
		  				
			  			for(var j=0; j<cArray.length; j++) {
	                    	cArray[j] = sheetObj.CellValue(i, j);
	                    }
	                }
                    rArray[idx++] = cArray;

	  		}
	  	}
	  	
	  	return rArray;
	}
	function window::onload() {
<%
	String[] display = null; 
	
	/* display 옵션 String의 갯수가 3이하인 경우는 Hidden 옵션이 없으므로,  
	   아래 If 조건문에 strDisplay.length() > 3 추가(2006-10-20 by Hyung Choon Roh) */
	if(strDisplay != null && !strDisplay.equals("") && strDisplay.length() > 3) {
		display = strDisplay.split(","); 
	}
	
	for (int i=0; display != null && i<display.length; i++) {
	    if (display[i].equals("0")) {
%>
		sheetObj.ColHidden(<%= i %>) = true;	// 마지막컬럼인인 특정셋팅 컬럼인지는 모르겠으나 히든설정이 안되는것도 있음(수정바람~~!)
<%
	    }
	}
%>
	}

--></SCRIPT>
<%-------------------- 공통팝업페이지에 포함할 스크립트 END --------------------%>
