/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsJoo0084ViewAdapterDL.java
 *@FileTitle : View Adapter Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.18
 *@LastModifier : XXXXX
 *@LastVersion : 1.0
 * 2014.12.18 진마리아
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * FNS_JOO_0084 에 대한 ViewAdapter<br>
 * - FNS_JOO_0084HTMLAction에서 작성<br>
 *
 * @author -
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class FnsJoo0084ViewAdapterDL extends ViewAdapter {

	private transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	private static List<String> gubunList = Arrays.asList(new String[]{JooConstants.EXCEL_TP_CD_CNTRVVD,"TEST Gubun"});
	private static List<String> titleList = Arrays.asList(new String[]{"Container List For Settlement Backup","TEST Title"});
	private static List<String[]> headerList = Arrays.asList(
			new String[]{"Seq.","Lane","VSL","Voy.","Act Dep. Date","Leg","Load Call","Disch Call","POL","POD","Line","Container No.","Original Position","TP/SZ","Wt Tons","STS","TEUs","Warning","IMO","Tmp(C)","O/R(cm)","O/L(cm)","O/H(cm)","COD Port","Disch ATD"},
			new String[]{"Test1","Test1"}//Other Add..
	);

	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 *
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
//log.debug("\nXLS STT TIME\t"+new Date(System.currentTimeMillis()));
		GeneralEventResponse eventResponse = null;
		CntrSettlementBackupReportVO param = null;
		List<CntrSettlementBackupReportVO> list = null;
		int index = 0;
		List<String> headNames = null;
		OutputStream out = null;
		PrintWriter pw = null;
		try {
	    	eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	    	param = (CntrSettlementBackupReportVO)eventResponse.getCustomData("param");
			list = eventResponse.getRsVoList();
			
			log.debug("\n #### gubunList.size()["+gubunList.size()+"]["+param.getGubun()+"]");

			for (int i=0; i<gubunList.size(); i++) {
				if (gubunList.get(i).equalsIgnoreCase(param.getGubun())) {
					index = i;
					break;
				}
			}
			log.debug("\n  #### headerList.get(index)) :["+headerList.get(index)+"]");
			headNames = Arrays.asList(headerList.get(index));
			
			//////////////////////////////////////////////////////////////////////////////////////////
			response.setContentType("application/csv;charset=UTF-8");
			response.setHeader("Content-Disposition", (-1==request.getHeader("User-Agent").indexOf("MSIE 5.5") ? "attachment;":"")+"filename=" + new String(titleList.get(index).getBytes("euc-kr"), "8859_1")+".csv" + ";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			out = response.getOutputStream();
			//csv 인코딩 문제로 추가 ( UTF-8 => EF(239) BB(187) BF(191) ) - http://en.wikipedia.org/wiki/Byte_order_mark#UTF-8
			out.write(239);
			out.write(187);
			out.write(191);
			pw = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
			pw.write(makeCsvData(param, headNames,list));
			pw.flush();
			//////////////////////////////////////////////////////////////////////////////////////////
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
		} finally {
			if (null!=out) {
				try {
					out.close();
					out = null;
				} catch(Exception ex) {
		            log.error(ex.getMessage(), ex);
		            throw new RuntimeException(ex.getMessage());
				}
			}
		}
//log.debug("\nXLS END TIME\t"+new Date(System.currentTimeMillis()));
    	return "flush";
    }

	private String makeCsvData(CntrSettlementBackupReportVO param, List<String> headNames, List<CntrSettlementBackupReportVO> list) throws Exception {
		StringBuilder sb = new StringBuilder();
		String delim = ",";
		String delim2 = "\r\n";
		for (int i=0; i<headNames.size(); i++) {
			sb.append("\"").append(headNames.get(i)).append("\"");
			if (i<headNames.size()-1) {
				sb.append(delim);
			}
		}
		sb.append(delim2);
		int iSeq = 0;
		for (CntrSettlementBackupReportVO vo : list) {
			 sb.append("\"").append(replaceData(++iSeq+""			  )).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getSlanCd		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getVslCd			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getVoyNo			())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getActDepAtdDt	())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getDirCd			())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getLoadCall		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getDischCall		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getPol			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getPod			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getOprCd			())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getId			())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getOriPosition	())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getSztp			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getWeight		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getFe			())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getTeus			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getWarning		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getImo			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getTemp			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getOvs			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getOvp			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getOvh			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getCod			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getDischAtdDt	())).append("\"").append(delim);
			 
			 sb.append(delim2);
		}
		return sb.toString();
	}

	private String replaceData(String data) throws Exception {
		return StringUtil.replace(data, "\"", "``");
	}
	/*
	 * (non-Javadoc)
	 * @see com.clt.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
	 */
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.clt.framework.core.controller.ViewAdapter#makeDataTag(com.clt.framework.component.rowset.DBRowSet, java.lang.String)
	 */
	@Override
	protected String makeDataTag(DBRowSet rs, String prefix) {
		return null;
	}

}
