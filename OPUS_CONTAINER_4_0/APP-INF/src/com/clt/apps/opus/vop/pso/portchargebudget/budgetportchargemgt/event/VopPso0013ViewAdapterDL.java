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
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
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
public class VopPso0013ViewAdapterDL extends ViewAdapter {

	private transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	//private static List<String> gubunList = Arrays.asList(new String[]{"DTL_EXCEL","TEST Gubun"});
	private static List<String> titleList = Arrays.asList(new String[]{"Monthly Detail Estimation","TEST Title"});
	
	private static List<String[]> headerList = Arrays.asList(
			new String[]{ "Seq."			,"Activity Date(ATD/ETD)"	,"Account Code"	,"Cost Code"	,"Revenue Lane",
					      "Conti."			,"Port"						,"Port Seq."	,"Revenue VVD"	,"Cur.",
					      "Estimate Cost"	,"Actual Cost"				,"Accrual Cost"	,"Update User"	,"Update Date"},
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
		GeneralEventResponse eventResponse = null;
		List<ErpDtlVO> list = null;
		int index = 0;
		List<String> headNames = null;
		OutputStream out = null;
		PrintWriter pw = null;
		
		try {
	    	eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			list = eventResponse.getRsVoList();

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
			pw.write(makeCsvData(headNames,list));
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

	private String makeCsvData(List<String> headNames, List<ErpDtlVO> list) throws Exception {
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
		
		for (ErpDtlVO vo : list) {
			 sb.append("\"").append(replaceData(++iSeq+""			  )).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getActDt			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getAcctCd		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getCostCd		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getRevLane		())).append("\"").append(delim);	//5
			 sb.append("\"").append(replaceData(vo.getContiCd		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getPort			())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getClptIndSeq	())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getRevVvd		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getLoclCurrCd	())).append("\"").append(delim);//10
			 sb.append("\"").append(replaceData(vo.getEstmAmt		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getActAmt		())).append("\"").append(delim);	
			 sb.append("\"").append(replaceData(vo.getAcclAmt		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getUpdUsrId		())).append("\"").append(delim);
			 sb.append("\"").append(replaceData(vo.getUpdDt			())).append("\"").append(delim);	//15
			 
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
