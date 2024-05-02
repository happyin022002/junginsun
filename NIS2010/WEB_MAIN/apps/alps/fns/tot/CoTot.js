/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoTot.js
 *@FileTitle : Common JavaScript for Joint Operation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.17
 *@LastModifier : 장창수
 *@LastVersion : 1.0
 * 2009.07.17 장창수
 * 1.0 Creation 
* ------------------------------------------------------------------------
* 2010.11.25 이병훈 [CHM-201007005-01] 톤세 신고관련 국토해양부 제출자료용 프로그램 개발
=========================================================*/

	msgs['TOT00001'] = "Please input year."                                                 
	msgs['TOT00002'] = "You can't use it."                                                  
	msgs['TOT00003'] = "Please input Year/Month."                                           
	msgs['TOT00004'] = "Are you sure to save the changes ?"                                 
	msgs['TOT00005'] = "Please input lane."                                                 
	msgs['TOT00006'] = "Please input trade."                                                
	msgs['TOT00007'] = "Please input the start date."                                       
	msgs['TOT00008'] = "Please input the end date."                                         
	msgs['TOT00009'] = "Please select vessel code."                                         
	msgs['TOT00010'] = "Please select vessel name."                                         
	msgs['TOT00011'] = "There is no the changed data."                                     
	msgs['TOT00012'] = "This vessel name doesn't exist."                                    
	msgs['TOT00013'] = "Please input 'TOT Delivery Date'."                                  
	msgs['TOT00014'] = "Input a TOT Re-Delivery Date."                                       
	msgs['TOT00015'] = "'TOT Delivery Date' must be less than a 'TOT Re-Delivery Date'."    
	msgs['TOT00016'] = "'TOT Re-Delivery Date' must be less than 'TOT Delivery Date'."      
	msgs['TOT00017'] = "Please input 'Excepted Date(FM)'."                                  
	msgs['TOT00018'] = "Please input 'Excepted Date(TO)'."                                  
	msgs['TOT00019'] = "'Excepted Date(FM)' must be less than 'Excepted Date(TO)'."         
	msgs['TOT00020'] = "This lane doesn't exist."                                           
	msgs['TOT00021'] = "Please select lane."                                                
	msgs['TOT00022'] = "Trade1 must not be same as Trade2."                                 
	msgs['TOT00023'] = "Trade1 must not be same as Trade3."                                 
	msgs['TOT00024'] = "Trade2 must not be same as Trade3."                                 
	msgs['TOT00025'] = "Are you sure to delete all data?"                                  
	msgs['TOT00026'] = "You must delete all data at first before you save the I/F data."    
	msgs['TOT00027'] = "Are you sure to save the I/F data ?"                                
	msgs['TOT00028'] = "There is no the deleted data."                                      
	msgs['TOT00029'] = "Please input direction."                                            
	msgs['TOT00030'] = "You can't select blank in 'Start Port'."                            
	msgs['TOT00031'] = "You can't select blank in 'End Port'."                              
	msgs['TOT00032'] = "'Start Port'[{?msg1}] must not be same as' End Port'[{?msg2}]."     
	msgs['TOT00033'] = "The start date and the end date must be in same year."              
	msgs['TOT00034'] = "The end date must be more than the start date."                     
	msgs['TOT00035'] = "There is no the selected data."                                     
	msgs['TOT00036'] = "There is no the batched data."                                      
	msgs['TOT00037'] = "Are you sure to calculate it by modified date ?"                    
	msgs['TOT00038'] = "There are more days than being expected in this month."             
	msgs['TOT00039'] = "'From Date' must be less than 'To Date'."                           
	msgs['TOT00040'] = "'To Date' must be more than 'From Date'."                           
	msgs['TOT00041'] = "'From Date's YEAR' must be same as 'To Date'sYear'."                
	msgs['TOT00042'] = "The start date and the end date must be in same year."              
	msgs['TOT00043'] = "The start date must be less than the end date."                     
	msgs['TOT00044'] = "The end date must be more than the start date."                     
	msgs['TOT00045'] = "The lane code is invalid !"                                         
	msgs['TOT00046'] = "Please input owner ship."                                           
	msgs['TOT00047'] = "You must retrieve at first before adding row."                      
	                   
	msgs['TOT00048'] ="'Excepted Date(TO)' must be more than 'Excepted Date(FM)'."          
	msgs['TOT00049'] ="[{?msg1}] 'Excepted Date' of vessel is duplicated."                  
	msgs['TOT00050'] ="The period must be in a year."                                       
	msgs['TOT00051'] ="There is no data to save."                                           
	msgs['TOT00052'] ="Are you sure to calculate it by modified date ?"                     
	msgs['TOT00053'] ="There are more days than being expected in this month."              
	msgs['TOT00054'] ="Please input vessel code."                                           
	msgs['TOT00055'] ="Please input data type."                                             
	msgs['TOT00056'] ="Please input 'VVD POL DATE'."                                        
	msgs['TOT00057'] ="Please input 'VVD POD DATE'."                                        
	msgs['TOT00058'] ="'VVD POL Date' must be less than 'VVD POD Date'."                    
	msgs['TOT00059'] ="'VVD POD Date' must be more than 'VVD POL Date'."                    
	msgs['TOT00060'] ="Are you sure to close this year ?"                                   
	msgs['TOT00061'] ="Are you sure to batch this year/month ?"                             
	msgs['TOT00062'] ="Pleas input parameters."                                             
	msgs['TOT00063'] ="Please input  'Run the job'."                                        
	msgs['TOT00064'] ="Please input  'Starting Date'."                                      
	msgs['TOT00065'] ="Please input 'Starting Date(Hour)'."                                 
	msgs['TOT00066'] ="Please input 'Starting Date(Minute)'."                               
	msgs['TOT00067'] ="Are you sure to cancel the batch for this year/month ?"               
	msgs['TOT00068'] ="There is no the changed data to recalculate."                        
	msgs['TOT00069'] ="Are you sure to recalculate it ?"                                    
	msgs['TOT00070'] ="You must excute the batch at first before you recalculate the data." 
	msgs['TOT00071'] ="Are you sure to excute ERP/IF ?"                         
	msgs['TOT00072'] = "You should select the trade to save. ";	
	msgs['TOT00073'] = "Feeder Data was not saved. ";	
	msgs['TOT00074'] = "Plese select item.";		
	msgs['TOT00075'] = "Starting Date must be more than Current Date.";
	msgs['TOT00076'] = "Batch Period must be less than Current Date.";	
	msgs['TOT00077'] = "One of batch is already scheduled in this period.";	
	msgs['TOT00078'] = "One of batch is running right now.";	
	msgs['TOT00079'] = "Are you sure to cancel them?";	
	msgs['TOT00080'] = "The data to create is not found.";		
	msgs['TOT00081'] = "[{?msg1}] 'Added lane' is duplicated."       
	msgs['TOT00082'] = "Are you sure to copy the data of the previous month ?"   		
	msgs['TOT00083'] = "Declared CAPA or Tot BSA of checked Data is Zero."   		
	msgs['TOT00084'] = "Please input {?msg1}."
	msgs['TOT00085'] = "Are you sure to create data of the input month ?"  
    msgs['TOT00086'] ="Are you sure to calculate it by modified Load CAPA ?"    	
	/**
	 * radio 의 값을 return한다.
	 * @param radioObj
	 * @return
	 */
	function getRadioValue(radioObj){
		var val = "";
		for(var i=0; i<radioObj.length; i++){
			if (radioObj[i].checked){
				val = radioObj[i].value;
				break;
			}
		}
		return val;
	}	
	
	/**
	 * del_chk 를 check 하고 Row Delete를 한 것이 있으면 true
	 * @param sheetObj
	 * @param prefix
	 * @return
	 */
	function existsUnDelRows(sheetObj, prefix){
		var rtnVal = false;
		var checkedRows = (sheetObj.FindCheckedRow(prefix+"del_chk")).split("|");
		
		if (checkedRows == "") 
			return rtnVal;
		
		for(var inx=0; inx<checkedRows.length; inx++){
			status = sheetObj.RowStatus(checkedRows[inx]);
			
			if (status=="I" || status=="U"){
				rtnVal = true;
				break;
			}
		}
		
		return rtnVal;
	}
	
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj, comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(",");
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}   		
	}	
	
    /*
     * 숫자만 입력.
     * onKeyPress="return onlyNumberInput(event)"
     */
  	function onlyYearInput( e)
    {
    	var obj = event.srcElement;
    	
		//백스페이스 및 방향키등등..일경우.. 리턴처리
		if (window.event.keyCode==8 || window.event.keyCode==9 || 
			window.event.keyCode==16 || window.event.keyCode==35 || 
            window.event.keyCode==36 || window.event.keyCode==37 ||  
            window.event.keyCode==39 || window.event.keyCode==46){
			return;
		}
		
		// 입력된 4자리의 값이 연도형식이 안닌경우 리턴처리
		if (obj.value.length==4 && !ComChkObjValid(obj)) {
			obj.value = "";
			return;
		}
		
		var ret = /[^0-9]/g;
		var val = obj.value.replace(ret,'');
		obj.value = val;
    } 
	