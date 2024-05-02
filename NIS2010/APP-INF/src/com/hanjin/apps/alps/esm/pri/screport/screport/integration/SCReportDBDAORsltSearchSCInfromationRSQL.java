/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCInfromationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.21 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCInfromationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc 기본내용
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCInfromationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCInfromationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT	CP.CUST_CNT_CD			," ).append("\n"); 
		query.append("CP.CUST_SEQ				," ).append("\n"); 
		query.append("CP.CTRT_PTY_NM			," ).append("\n"); 
		query.append("CT.PRC_CTRT_CUST_TP_CD	," ).append("\n"); 
		query.append("CP.CTRT_CUST_SLS_OFC_CD ," ).append("\n"); 
		query.append("CP.CTRT_CUST_SREP_CD	," ).append("\n"); 
		query.append("( SELECT A.SREP_NM FROM MDM_SLS_REP A WHERE A.SREP_CD = CP.CTRT_CUST_SREP_CD ) SREP_NM ," ).append("\n"); 
		query.append("TO_CHAR(DU.CTRT_EFF_DT,'YYYY-MM-DD') AS CTRT_EFF_DT ," ).append("\n"); 
		query.append("TO_CHAR(DU.CTRT_EXP_DT,'YYYY-MM-DD') AS CTRT_EXP_DT ," ).append("\n"); 
		query.append("SH.SC_NO -- PARAM" ).append("\n"); 
		query.append("FROM	PRI_SP_HDR		    SH	," ).append("\n"); 
		query.append("PRI_SP_MN		    SM	," ).append("\n"); 
		query.append("PRI_SP_CTRT_PTY	    CP	," ).append("\n"); 
		query.append("PRI_SP_CTRT_CUST_TP	CT	," ).append("\n"); 
		query.append("PRI_SP_DUR			DU" ).append("\n"); 
		query.append("WHERE	SM.PROP_NO	= SH.PROP_NO" ).append("\n"); 
		query.append("AND		SM.AMDT_SEQ	= (" ).append("\n"); 
		query.append("SELECT	MAX(A.AMDT_SEQ)" ).append("\n"); 
		query.append("FROM	PRI_SP_MN A" ).append("\n"); 
		query.append("WHERE	A.PROP_NO	  = SH.PROP_NO" ).append("\n"); 
		query.append("AND		A.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		CP.PROP_NO			  = SM.PROP_NO" ).append("\n"); 
		query.append("AND		CP.AMDT_SEQ			  = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND		CT.PROP_NO			  = CP.PROP_NO" ).append("\n"); 
		query.append("AND		CT.AMDT_SEQ			  = CP.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("AND		DU.PROP_NO			  = SM.PROP_NO" ).append("\n"); 
		query.append("AND		DU.AMDT_SEQ			  = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SH.SC_NO		      = @[sc_no] -- S/C No" ).append("\n"); 

	}
}