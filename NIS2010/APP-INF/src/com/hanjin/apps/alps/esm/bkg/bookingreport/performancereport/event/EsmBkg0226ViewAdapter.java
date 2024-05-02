/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0226ViewAdapter.java
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.13 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiUploadStsReportInVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Ki Jong
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0226ViewAdapter extends ViewAdapter {

	
	protected String makeSum(String a, String b){
		int sum =0;
		
		sum = Integer.parseInt(JSPUtil.getNull(a,"0")) + Integer.parseInt(JSPUtil.getNull(b,"0"));
		return String.valueOf(sum);
	}
	
	protected double stringToDouble(String input){
        if(input == null)
            input = "0.0";
        if(input.equals(""))
            input = "0.0";
        if(input.indexOf(".") < 0)
            input = input + ".0";
        double dBmQty = Double.parseDouble(input);
        return dBmQty;
    }
	
	protected  BigDecimal getRound(double dataDouble, int seat){

        BigDecimal bd = new BigDecimal(dataDouble);
        bd = bd.setScale(seat, BigDecimal.ROUND_HALF_UP);

        return bd;

    }
	
	protected String makeSvc(String type, EBkgSiUploadStsReportInVO vo){
		Double sum = 0.0;
		
		if (type.equals("BKG")){
			//TO_CHAR(100 - TRUNC(B_P/DECODE(B_TTL,0,1,B_TTL),4)*100) B_PF
			if (!vo.getBTtl().equals("0")){
				sum = 100 - (stringToDouble(vo.getBP()) / stringToDouble(vo.getBTtl())*100);
			}
		}else if (type.equals("SI")){
			//TO_CHAR(100 - TRUNC(S_P/DECODE(S_TTL,0,1,S_TTL),4)*100) S_PF
			if (!vo.getSTtl().equals("0")){
				sum = 100 - (stringToDouble(vo.getSP()) / stringToDouble(vo.getSTtl())*100);
			}
		}
		
		return String.valueOf(getRound(sum,1));
	}
	protected EBkgSiUploadStsReportInVO makeVo(EBkgSiUploadStsReportInVO vo, Map<String, String> colValues){

		vo.setBTtl(makeSum(vo.getBTtl(),JSPUtil.getNull(colValues.get("b_ttl"))));
		vo.setBX(makeSum(vo.getBX(),JSPUtil.getNull(colValues.get("b_x"))));
		vo.setBF(makeSum(vo.getBF(),JSPUtil.getNull(colValues.get("b_f"))));
		vo.setBR(makeSum(vo.getBR(),JSPUtil.getNull(colValues.get("b_r"))));
		vo.setBD(makeSum(vo.getBD(),JSPUtil.getNull(colValues.get("b_d"))));
		vo.setBP(makeSum(vo.getBP(),JSPUtil.getNull(colValues.get("b_p"))));
		vo.setBPf(makeSvc("BKG", vo));
		
		vo.setSTtl(makeSum(vo.getSTtl(),JSPUtil.getNull(colValues.get("s_ttl"))));
		vo.setSX(makeSum(vo.getSX(),JSPUtil.getNull(colValues.get("s_x"))));
		vo.setSF(makeSum(vo.getSF(),JSPUtil.getNull(colValues.get("s_f"))));
		vo.setSR(makeSum(vo.getSR(),JSPUtil.getNull(colValues.get("s_r"))));
		vo.setSD(makeSum(vo.getSD(),JSPUtil.getNull(colValues.get("s_d"))));
		vo.setSP(makeSum(vo.getSP(),JSPUtil.getNull(colValues.get("s_p"))));
		vo.setSPf(makeSvc("SI", vo));
		return vo;
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
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);

		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		} 
		
		Map<String, String> colValues = null;
		Map<String, String> colValues2 = null;
		String tempSubTotalRegion = "";
		String tempSubTotalGso = "";
		
		EBkgSiUploadStsReportInVO regionVo = new EBkgSiUploadStsReportInVO();
		EBkgSiUploadStsReportInVO gsoVo = new EBkgSiUploadStsReportInVO();
		EBkgSiUploadStsReportInVO totVo = new EBkgSiUploadStsReportInVO();
		
		sbufXML.append("<SHEET>\n");
		//토탈 개수 조정
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			if ( i < realCnt-1){
				colValues2 = vos.get(i+1).getColumnValues();
				tempSubTotalRegion =colValues2.get("region_cd");
				tempSubTotalGso =colValues2.get("gso");
			}else{
				if (i ==0){
					tempSubTotalRegion = colValues.get("region_cd");
					tempSubTotalGso = colValues.get("gso");
				}else{
					tempSubTotalRegion = "";
					tempSubTotalGso = "";
				}
			}
			regionVo = makeVo(regionVo,colValues);
			gsoVo = makeVo(gsoVo,colValues);
			totVo = makeVo(totVo,colValues);
			
			sbufXML.append("	<TR >\n");
			sbufXML.append("		<TD><![CDATA[").append("R").append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("bkg_ofc"))).append("]]></TD>\n"); 
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("mon"))).append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_ttl"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_x"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_f"))).append("]]></TD>\n");    
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_r"))).append("]]></TD>\n");     
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_d"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_p"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("b_pf"))).append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_ttl"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_x"))).append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_f"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_r"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_d"))).append("]]></TD>\n");   
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_p"))).append("]]></TD>\n");  
			sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_pf"))).append("]]></TD>\n");
			
			
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			
			/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
			sbufXML.append("	</TR>\n");*/
			
			if(!JSPUtil.getNull(colValues.get("gso")).equals(tempSubTotalGso)){
				/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");*/
				
				sbufXML.append(" <TR BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("R").append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("SubTotal").append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("(GSO)").append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBX()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBF()).append("]]></TD>\n");    
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBR()).append("]]></TD>\n");     
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBD()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBP()).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getBPf()).append("]]></TD>\n"); 
				
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSX()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSF()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSR()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSD()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSP()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(gsoVo.getSPf()).append("]]></TD>\n");   
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				
				
				/*sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");*/
				
				gsoVo = new EBkgSiUploadStsReportInVO(); 
			}
			if(!JSPUtil.getNull(colValues.get("region_cd")).equals(tempSubTotalRegion)){
				/*sbufXML.append(" <TR >\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");*/
				
				sbufXML.append(" <TR BOLD=\"TRUE\" BGCOLOR=\"255,192,192\">\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("R").append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("region_cd"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(colValues.get("gso"))).append("]]></TD>\n");
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("SubTotal").append("]]></TD>\n"); 
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append("(Region)").append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBX()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBF()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBR()).append("]]></TD>\n");    
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBD()).append("]]></TD>\n");     
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBP()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getBPf()).append("]]></TD>\n");
				
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSTtl()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSX()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSF()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSR()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSD()).append("]]></TD>\n");   
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSP()).append("]]></TD>\n");  
				sbufXML.append("		<TD BOLD=\"TRUE\"><![CDATA[").append(regionVo.getSPf()).append("]]></TD>\n"); 
				
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				
				
				sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'>\n");
				sbufXML.append("	</TR>\n");
				sbufXML.append("	\n");
				regionVo = new EBkgSiUploadStsReportInVO(); 
			}
			
		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>");
		sbufXML.append("		<ETC KEY='b_ttl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBTtl())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='b_x'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBX())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='b_f'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBF())).append("]]></ETC>\n");    
		sbufXML.append("		<ETC KEY='b_r'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBR())).append("]]></ETC>\n");     
		sbufXML.append("		<ETC KEY='b_d'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBD())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='b_pp'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getBP())).append("]]></ETC>\n");
		sbufXML.append("		<ETC KEY='b_pf'><![CDATA[").append(totVo.getBPf()).append("]]></ETC>\n"); 

		sbufXML.append("		<ETC KEY='s_ttl'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSTtl())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='s_x'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSX())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='s_f'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSF())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='s_r'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSR())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='s_d'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSD())).append("]]></ETC>\n");   
		sbufXML.append("		<ETC KEY='s_p'><![CDATA[").append(JSPUtil.formatCurrency(totVo.getSP())).append("]]></ETC>\n");  
		sbufXML.append("		<ETC KEY='s_pf'><![CDATA[").append(totVo.getSPf()).append("]]></ETC>\n");   
		
		sbufXML.append("</ETC-DATA>");
		
		sbufXML.append("</SHEET>\n");
		/*sbufXML.append("|$$|<SHEET>\n");
		sbufXML.append(makeDataTagDefault(vos, prefix));
		sbufXML.append("</SHEET>\n");*/
		return sbufXML.toString();
	}

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
	 * @return String <Data>태그 부분의 XML문자열
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
	            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
	            if(serverException != null)
	            {
	                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
	            } else
	            {
	                boolean isUpload = isUploadFile(request);
	                event = (Event)request.getAttribute("Event");
	                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	                //List rsVoList = null;
	                boolean isSave = isSaveCommand(event);
	                if(eventResponse != null)
	                {
	                    //rsVoList = eventResponse.getRsVoList();
	                    if(eventResponse.getDataCntList().size() == 0)
	                        strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
	                    else
	                        strXML = makeSuccessXML(isUpload, request, eventResponse);
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
