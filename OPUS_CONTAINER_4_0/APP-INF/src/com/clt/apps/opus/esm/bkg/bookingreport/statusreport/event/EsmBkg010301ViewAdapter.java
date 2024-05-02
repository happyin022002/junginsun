/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0103_01ViewAdapter.java
*@FileTitle : Booking Status Report AWKWARD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg010301ViewAdapter extends ViewAdapter {

    private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse)
    {
        StringBuilder sb = new StringBuilder();
        if(isFirstSheet)
        {
            if(isSave)
            {
                sb.append("<RESULT>\n");
                sb.append("<TR-ALL>OK</TR-ALL>\n");
            } else
            {
                sb.append("<SHEET>\n");
            }
            sb.append(getETCData(eventResponse));
            sb.append(getUserMessageXML(eventResponse));
        } else
        {
            sb.append("|$$|<SHEET>\n");
        }
        return sb.toString();
    }
    private String getEndTag(StringBuilder sb)
    {
        String endTag = "";
        String tmp = sb.toString();
        int sheetLoc = tmp.lastIndexOf("<SHEET>");
        int resultLoc = tmp.lastIndexOf("<RESULT>");
        if(sheetLoc > resultLoc)
            endTag = "</SHEET>\n";
        else
            endTag = "</RESULT>\n";
        return endTag;
    }	
	   @SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse)
	    {
	        Event event = (Event)request.getAttribute("Event");
	        boolean isSave = isSaveCommand(event);
	        StringBuilder sb = new StringBuilder();
	        List rsVoList = eventResponse.getRsVoList();
	        //int cnt = rsVoList.size();
	        //String preVOName = "";
	        boolean isFirstSheet = true;
	        //List voList = new ArrayList();
	        String prefixs[] = getPrefixFromHttp(request);
	        List dataCntList = eventResponse.getDataCntList();
	        if(isUpload)
	            sb.append("<pre>\n");
	        int setExeCnt = dataCntList.size();
	        Iterator it = rsVoList.iterator();
	        int curLoc = 0;
	        for(int i = 0; i < setExeCnt; i++)
	        {
	            int voCnt = ((Integer)dataCntList.get(i)).intValue();
	            if(voCnt == 0)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append("\t<DATA  TOTAL='0'>\n");
	                sb.append("\t</DATA>\n");
	                sb.append(getEndTag(sb));
	                isFirstSheet = false;
	            } else
	            if(rsVoList.get(curLoc) instanceof DBRowSet)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag((DBRowSet)it.next(), prefixs[i]));
	                sb.append(getEndTag(sb));
	                curLoc++;
	                isFirstSheet = false;
	            } else
	            {
	                List tmpList = new ArrayList();
	                for(int j = 0; j < voCnt; j++)
	                {
	                    Object obj = it.next();
	                    tmpList.add(obj);
	                    curLoc++;
	                }

	               // sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag(tmpList, prefixs[i]));
	                //sb.append(getEndTag(sb));
	                removeListAllElements(tmpList);
	                isFirstSheet = false;
	            }
	        }

	        if(isUpload)
	            sb.append("</pre>\n");
	        return sb.toString();
	    }
	   
	/**
	 * makeXML
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 */	
	 public String makeXML(HttpServletRequest request, HttpServletResponse response)
	    {
	        Event event = null;
	        GeneralEventResponse eventResponse = null;
	        Exception serverException = null;
	        String strXML = "";
	        boolean isupload = isUploadFile(request);
	        try
	        {
	            serverException = (Exception)request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT");
	            if(serverException != null)
	            {
	                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
	            } else
	            {
	                boolean isUpload = isUploadFile(request);
	                event = (Event)request.getAttribute("Event");
	                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	                //List rsVoList = null;
	                /* R4J 결함 복구 isSave 는 사용 하지 않아 주석 처리함 */
	                isSaveCommand(event);
//	                boolean isSave = isSaveCommand(event);
	                if(eventResponse != null)
	                {
	                    //rsVoList = eventResponse.getRsVoList();
	                    if(eventResponse.getRsVoList().size() == 0){
	                        //strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
	                        strXML = "<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>|$$|<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>";
	                    }else{
	                        strXML = makeSuccessXML(isUpload, request, eventResponse);
	                    }
	                }
	            }
	        }
	        catch(Exception ex)
	        {
	            log.error(ex.getMessage(), ex);
	            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
	        }
	        if(log.isDebugEnabled())
	            log.debug((new StringBuilder("\n")).append(strXML).toString());
	        return strXML;
	    }
	 
	 	private boolean isUploadFile(HttpServletRequest request)
	    {
	        boolean isUpload = false;
	        String contentType = request.getContentType();
	        if(contentType != null && contentType.startsWith("multipart/form-data"))
	            isUpload = true;
	        return isUpload;
	    }	 
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		//log.debug("*************************************** prefix"+prefix);
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		

		Map<String, String> colValues = new HashMap<String, String>();
		String orderByTemp = "";
		String rowSeqTemp = ""; // BKG_NO에 따라 같으면 한번만 보여준다.
		String totalBkg ="";
		String totalBl  ="";
		String totalTeu ="";
		String totalFeu ="";
		String totalWgt ="";
		String totalMea ="";
		
		if(realCnt>0){
			colValues = vos.get(0).getColumnValues();
			totalBkg = colValues.get("total_bkg");
			totalBl  = colValues.get("total_bl");
			totalTeu = colValues.get("total_teu");
			totalFeu = colValues.get("total_feu");
			totalWgt = colValues.get("total_wgt");
			totalMea = colValues.get("total_mea");
		}
		
		String orderByTitle = colValues.get("last_orderby") == null ? "" :colValues.get("last_orderby");
		
		sbufXML.append("<SHEET>\n");
		//토탈 개수 조정 - 페이징 처리에 필요하였으나 현재는 페이징 없이 가져오므로 필요 없음
		sbufXML.append("\n<DATA>\n");
		
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			
			orderByTemp =colValues.get("orderby_title");
			rowSeqTemp = colValues.get("row_seq");
			//log.debug(orderByTemp.toString());
			
			//이전 OrderBy Title과 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if(!orderByTitle.equals(orderByTemp)){
				
				//OrderBy XML생성
				sbufXML.append(" <TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD FontBold='TRUE' Align='Left'><![CDATA[").append(orderByTemp).append("]]></TD>\n");
				for (int j = 0; j < 23; j++) {
					sbufXML.append("		<TD FontBold='TRUE' Align='Left'><![CDATA[").append(orderByTemp).append("]]></TD>\n");
				}
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				//log.debug("sbufXML title>>>>>>>>>>>>>>>>>>>>>>"+sbufXML.toString());
				orderByTitle = orderByTemp;
				//orderbyCnt++;
			}
			
			sbufXML.append("	<TR>\n");
			
			sbufXML.append("		<TD><![CDATA[BKG]]></TD>\n");
			
			if(rowSeqTemp.equals("1")){
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("no")).append("]]></TD>\n");          // No                     
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("bst_flg")).append("]]></TD>\n");     // Bst                     
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("bkg_no")).append("]]></TD>\n");      //Booking No
			}else{
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n");      
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n");      
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n");       
			}
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_no")).append(" ]]></TD>\n"); 			// CNTR No                 
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_tpsz_cd")).append("]]></TD>\n"); 	// T/S                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("akrep_cmdt")).append(" ]]></TD>\n"); 		// CMDT                    
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("grs_wgt")).append("]]></TD>\n"); 			// WGT(KGS)                
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pkg")).append("]]></TD>\n"); 				// PKG                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pkg")).append("]]></TD>\n"); 				// PKG                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_fwrd_len")).append("]]></TD>\n"); 	// Over Length(CM)         
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("ovr_bkwd_len")).append(" ]]></TD>\n"); 	// Over Length(CM)         
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_hgt")).append("]]></TD>\n"); 			// Over Length(CM)         
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("ovr_lf_len")).append(" ]]></TD>\n"); 		// Over Width(CM)          
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_rt_len")).append("]]></TD>\n"); 		// Over Width(CM)          
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_void_slt_qty")).append("]]></TD>\n"); // Void (FEU)              
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("hot_de_flg")).append("]]></TD>\n"); 		// HT                      
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("rd_cgo_flg")).append(" ]]></TD>\n"); 		// RF                      
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("bkg_ofc_cd")).append("]]></TD>\n"); 		// BKG OFC                 
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("bkg_stf")).append(" ]]></TD>\n"); 			// BKG STF                 
//			sbufXML.append("		<TD><![CDATA[").append(colValues.get("spcl_cgo_auth_knt")).append("]]></TD>\n");// RQ         
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("spcl_cgo_apro_cd")).append("]]></TD>\n"); // AT
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("remark")).append(" ]]></TD>\n"); 			// RMK                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("remark_detail")).append("]]></TD>\n"); 	// REMARK_DETAIL 
			
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			sbufXML.append("	<TR >\n");
			
			sbufXML.append("		<TD><![CDATA[BL]]></TD>\n");
			
			if(rowSeqTemp.equals("1")){
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("no")).append("]]></TD>\n");          // No
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("bdr_flg")).append("]]></TD>\n"); 		// Bdr                     
				sbufXML.append("		<TD><![CDATA[").append(colValues.get("bl_no")).append("]]></TD>\n"); 		// B/L No                  
			}else{
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n");      
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n");      
				sbufXML.append("		<TD BGCOLOR='235,235,235'><![CDATA[]]></TD>\n"); 
			}			
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_no")).append(" ]]></TD>\n"); 		// CNTR No                 
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("cntr_tpsz_cd")).append("]]></TD>\n"); // T/S                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("akrep_cmdt")).append(" ]]></TD>\n"); 	// CMDT                    
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("grs_wgt")).append("]]></TD>\n"); 		// WGT(KGS)                
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("rcv_term_cd")).append(" ]]></TD>\n"); 	// R                       
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("de_term_cd")).append("]]></TD>\n"); 	// D                       
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_fwrd_len")).append("]]></TD>\n"); // FWD                     
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("ovr_bkwd_len")).append(" ]]></TD>\n"); // AFT                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_hgt")).append("]]></TD>\n"); 		// HGT                     
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("ovr_lf_len")).append(" ]]></TD>\n"); 	// PORT                    
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_rt_len")).append("]]></TD>\n"); 	// STAR                    
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ovr_void_slt_qty")).append("]]></TD>\n"); // Void (FEU)              
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("dcgo_flg")).append("]]></TD>\n"); 		// DG                      
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("bb_cgo_flg")).append(" ]]></TD>\n"); 		// BB                      
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ob_sls_ofc_cd")).append("]]></TD>\n"); 	// S/OFC                   
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("ob_srep_cd")).append(" ]]></TD>\n"); 		// S/REP                   
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("spcl_cgo_apro_cd")).append("]]></TD>\n"); // AT                      
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("remark")).append(" ]]></TD>\n"); 			// RMK                     
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("remark_detail")).append("]]></TD>\n"); 	// REMARK_DETAIL  

			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			sbufXML.append("	<TR HIDDEN='true'></TR>\n");
			sbufXML.append("	<TR HIDDEN='true'></TR>\n");
							
		}
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>");
		sbufXML.append("<ETC KEY='real_total_cnt'><![CDATA[").append(totCnt).append("]]></ETC>");
		sbufXML.append("<ETC KEY='last_orderby'><![CDATA[").append(orderByTemp).append("]]></ETC>");
		sbufXML.append("<ETC KEY='total_bkg'><![CDATA[").append(totalBkg).append("]]></ETC>");
		sbufXML.append("<ETC KEY='total_bl'> <![CDATA[").append(totalBl ).append("]]></ETC>");
		sbufXML.append("<ETC KEY='total_teu'><![CDATA[").append(totalTeu).append("]]></ETC>");
		sbufXML.append("<ETC KEY='total_feu'><![CDATA[").append(totalFeu).append("]]></ETC>");
		sbufXML.append("<ETC KEY='total_wgt'><![CDATA[").append(totalWgt).append("]]></ETC>");		
		sbufXML.append("<ETC KEY='total_mea'><![CDATA[").append(totalMea).append("]]></ETC>");		
		sbufXML.append("</ETC-DATA>");		
		sbufXML.append("</SHEET>\n");
		sbufXML.append("|$$|<SHEET>\n");
		sbufXML.append(makeDataTagDefault(vos, prefix));
		sbufXML.append("</SHEET>\n");
		
		//log.debug("########################## >> "+sbufXML);
		return sbufXML.toString();
	}
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTagDefault(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}	

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
	 protected String getETCData(EventResponse eventResponse)
	    {
	        if(eventResponse == null)
	            return "";
	        StringBuilder sb = new StringBuilder();
	        Map<String,String> etc_data = eventResponse.getETCData();
	        sb.append("<ETC-DATA>\n");
	        if(etc_data != null && etc_data.size() > 0)
	        {
	            String key;
	            String val;
	            for(Iterator<String> it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
	            {
	                key = (String)it.next();
	                val = (new StringBuilder()).append((String)etc_data.get(key)).toString();
	            }

	        }
	        sb.append(getPivotETCData(eventResponse));
	        sb.append("</ETC-DATA>\n");
	        return sb.toString();
	    }

}
