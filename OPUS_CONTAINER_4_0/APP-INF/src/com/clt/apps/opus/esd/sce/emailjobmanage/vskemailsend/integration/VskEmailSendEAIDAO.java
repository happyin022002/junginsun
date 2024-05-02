/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendEAIDAO.java
*@FileTitle : VskEmailSend
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.26 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.basic.VskEmailSendBCImpl;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.SceEmlSndRsltSubscVO;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * VskEmailSendEAIDAO <br>
 * - EmailJobManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Jun Yong
 * @see VskEmailSendBCImpl 참조
 * @since J2EE 1.6
 */
public class VskEmailSendEAIDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * @param sceEmlSndRsltSubscVO
	 * @return String
	 * @throws EAIException
	 */
	public String sendVslSkd(SceEmlSndRsltSubscVO sceEmlSndRsltSubscVO)throws EAIException{
		try {		    
			TemplateMail template 		= new TemplateMail();
			StringBuffer sbContents 	= new StringBuffer(10000);
			
			ArrayList<String> stGrp = null;
			ArrayList<String> st = null;
			ArrayList<String> stVvd = null;
			ArrayList<String> stVslNm = null;
			ArrayList<String> stPol = null;
			ArrayList<String> stLane = null;
			ArrayList<String> stVpsEtbDt = null;
			ArrayList<String> stVpsetdDt = null;
			ArrayList<String> stPfEtbDt = null;
			ArrayList<String> stPfEtdDt = null;
			ArrayList<String> stDelayBerth = null;
			ArrayList<String> stDelayDep = null;
					    
		    template.setFrom("noreply@nykline.com");
		    template.setRecipient(sceEmlSndRsltSubscVO.getSubscEml());
			template.setRdSubSysCd("SCE");
			template.setBatFlg("Y");
			template.setSubject("Vessel Schedule Mailing Service"); 

			sbContents.append("<html>\n");
			sbContents.append("<head>\n");
			sbContents.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n");
			sbContents.append("<title>SCE Applicaton</title>\n");
			sbContents.append("<style type='text/css'>\n");
			sbContents.append("</style>\n");
			sbContents.append("</head>\n");
			
			sbContents.append("<body> \n");
			
			sbContents.append("<br/>\n");
			sbContents.append("<span class='subject'>Vessel Schedule Mailing Service</span><br/>\n");
			sbContents.append("<br/>\n");
			
			sbContents.append("<table>\n"); 
			sbContents.append("<tr class='h23'>\n"); 
			sbContents.append("<td width=''><input type='text' style='width:85;' class='input2' value=" + sceEmlSndRsltSubscVO.getSysDt() + ">\n");
			sbContents.append("</td>\n");
			sbContents.append("</table>\n");
			sbContents.append("\n");
			sbContents.append("<br/>\n");
			
			stGrp = seperationParameter(sceEmlSndRsltSubscVO.getEmlCtnt(), "##");
			
			for( int j=0; j < stGrp.size(); j++ ){
				st = seperationParameter((String)stGrp.get(j), "||");
				
				sbContents.append("<table width='979' border='1' cellpadding='0' cellspacing='0' class='base'>\n");
				sbContents.append("  <tr>\n");
				sbContents.append("	   <td width='80' align='center' rowspan='2' class='basetd'><B>VVD</B></td>\n");
				sbContents.append("    <td width='100' align='center'  rowspan='2' class='basetd'><B>Vesse Name</B></td>\n");
				sbContents.append("    <td width='55' align='center'  rowspan='2' class='basetd'><B>POL</B></td>\n");
				sbContents.append("    <td width='45' align='center'  rowspan='2' class='basetd'><B>Lane</B></td>\n");
				sbContents.append("    <td width='280' align='center' colspan='2' class='basetd'><B>Costal SKD</B></td>\n");
				sbContents.append("    <td width='280' align='center' colspan='2' class='basetd'><B>P/F SKD</B></td>\n");
				sbContents.append("    <td width='100' align='center' colspan='2' class='basetd'><B>Delay</B></td>\n");
				sbContents.append("  </tr>\n");
				sbContents.append("  <tr>\n");
				sbContents.append("    <td width='140' align='center' class='basetd'><B>ETB</B></td>\n");
				sbContents.append("    <td width='140' align='center' class='basetd'><B>ETD</B></td>\n");
				sbContents.append("    <td width='140' align='center' class='basetd'><B>ETB</B></td>\n");
				sbContents.append("    <td width='140' align='center' class='basetd'><B>ETD</B></td>\n");
				sbContents.append("    <td width='50' align='center' class='basetd'><B>BERTH</B></td>\n");
				sbContents.append("    <td width='50' align='center' class='basetd'><B>DEP.</B></td>\n");
				sbContents.append("  </tr>\n");
				
				stVvd = seperationParameter((String)st.get(0), ",");
				stVslNm = seperationParameter((String)st.get(1), ",");
				stPol = seperationParameter((String)st.get(2), ",");
				stLane = seperationParameter((String)st.get(3), ",");
				stVpsEtbDt = seperationParameter((String)st.get(4), ",");
				stVpsetdDt = seperationParameter((String)st.get(5), ",");
				stPfEtbDt = seperationParameter((String)st.get(6), ",");
				stPfEtdDt = seperationParameter((String)st.get(7), ",");
				stDelayBerth = seperationParameter((String)st.get(8), ",");
				stDelayDep = seperationParameter((String)st.get(9), ",");
				
				for( int i=0; i < stVvd.size(); i++ ){
					sbContents.append("<tr>\n");
					sbContents.append("<td align='center'>" + stVvd.get(i) + "</td>\n");					
					sbContents.append("<td align='center'>" + stVslNm.get(i) + "</td>\n");
					sbContents.append("<td align='center'>" + stPol.get(i) + "</td>\n");
					sbContents.append("<td align='center'>" + stLane.get(i) + "</td>\n");
					if( "SKIP".equals(stVpsEtbDt.get(i))){
						sbContents.append("<td align='center' colspan='6'><font color='red'>SKIP</font></td>\n");				
					}else{
						sbContents.append("<td align='center'>" + stVpsEtbDt.get(i) + "</td>\n");
						sbContents.append("<td align='center'>" + stVpsetdDt.get(i) + "</td>\n");
						sbContents.append("<td align='center'>" + stPfEtbDt.get(i) + "</td>\n");
						sbContents.append("<td align='center'>" + stPfEtdDt.get(i) + "</td>\n");
						if( (new BigDecimal((String)stDelayBerth.get(i))).compareTo(BigDecimal.ZERO) > 0){
							sbContents.append("<td align='center' bgcolor='red'>" + stDelayBerth.get(i) + "</td>\n");
						}else{
							sbContents.append("<td align='center'>" + stDelayBerth.get(i) + "</td>\n");
						}
						
						if( (new BigDecimal((String)stDelayDep.get(i))).compareTo(BigDecimal.ZERO) > 0){
							sbContents.append("<td align='center' bgcolor='red'>" + stDelayDep.get(i) + "</td>\n");
						}else{
							sbContents.append("<td align='center'>" + stDelayDep.get(i) + "</td>\n");
						}								
					}										
					sbContents.append("</tr>\n");				
				}
				sbContents.append("</table>\n");
				sbContents.append("<br/>\n");
				sbContents.append("<br/>\n");
				
			}		
			sbContents.append(" <br/>\n");
			sbContents.append("<br/>\n");
			sbContents.append("<br/>\n");
			sbContents.append(" Best Regards\n");
			sbContents.append("</body>\n");
			sbContents.append("</html>\n");

			template.setArg("sce_reqcontents",sbContents.toString()); 
			template.setHtmlTemplate("ESD_SCE_B021_01T.html"); 
			
			log.debug(sbContents.toString());
			return template.send();
			 
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EAIException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return ArrayList
	 */
	private ArrayList<String> seperationParameter(String sparameter, String sSeperate) {
		ArrayList<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if(sparameter != null && !sparameter.equals("")) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
}