/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAReportDBDAORsltPriCopiedRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltPriCopiedRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPriCopiedRFA
	  * </pre>
	  */
	public RFAReportDBDAORsltPriCopiedRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_req_rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_m_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_req_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_tp_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_tp_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltPriCopiedRFARSQL").append("\n"); 
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
		query.append("SELECT      " ).append("\n"); 
		query.append("      HDR.RFA_NO AS RFA_NO      " ).append("\n"); 
		query.append("	 ,MN.AMDT_SEQ AS AMDT_SEQ     " ).append("\n"); 
		query.append("	 ,MN.PROP_NO AS PROP_NO     " ).append("\n"); 
		query.append("	 ,LPAD(NVL(HDR.MST_RFA_NO,0),10,0) ||'_'||LPAD(MN.AMDT_SEQ,3,0) AS SOURCE" ).append("\n"); 
		query.append("     ,SCP_MN.SVC_SCP_CD AS SVC_SCP_CD    " ).append("\n"); 
		query.append("	 , MAS.OFC_N3RD_LVL_CD                  AS RHQ_CD" ).append("\n"); 
		query.append("     , MN.PROP_OFC_CD    " ).append("\n"); 
		query.append("	 , MN.PROP_SREP_CD     " ).append("\n"); 
		query.append("	 , TO_CHAR(SCP_MN.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("	 , TO_CHAR(SCP_MN.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , MN.PRC_CTRT_CUST_TP_CD AS PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD=MN.CTRT_CUST_CNT_CD AND CUST_SEQ = MN.CTRT_CUST_SEQ  ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , DMDT.DMDT_FT_TP_CD AS DMDT_FT_TP_CD" ).append("\n"); 
		query.append("     , MN.PROP_STS_CD AS PROP_STS_CD     " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("FROM  PRI_RP_HDR                HDR" ).append("\n"); 
		query.append("    , PRI_RP_MN                 MN" ).append("\n"); 
		query.append("    , PRI_RP_SCP_MN             SCP_MN" ).append("\n"); 
		query.append("    , PRI_RP_DMDT               DMDT" ).append("\n"); 
		query.append("    , MAS_OFC_LVL               MAS" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append(" AND HDR.PROP_NO    = MN.PROP_NO" ).append("\n"); 
		query.append("  AND MN.PROP_NO     = SCP_MN.PROP_NO" ).append("\n"); 
		query.append(" AND MN.AMDT_SEQ    = SCP_MN.AMDT_SEQ" ).append("\n"); 
		query.append("-----------------------------------------" ).append("\n"); 
		query.append("  AND MN.PROP_NO           = DMDT.PROP_NO" ).append("\n"); 
		query.append(" AND MN.AMDT_SEQ          = DMDT.AMDT_SEQ" ).append("\n"); 
		query.append(" ---------------------------------------" ).append("\n"); 
		query.append(" AND SCP_MN.PROP_SCP_OFC_CD = MAS.OFC_CD(+) " ).append("\n"); 
		query.append(" AND SCP_MN.EXP_DT <= TO_DATE(MAS.OFC_APLY_TO_YRMON(+),'YYYYMM')" ).append("\n"); 
		query.append(" AND SCP_MN.EFF_DT >= TO_DATE(MAS.OFC_APLY_FM_YRMON(+),'YYYYMM')" ).append("\n"); 
		query.append(" ---------------------------------------" ).append("\n"); 
		query.append(" AND SCP_MN.EFF_DT <= TO_DATE(@[f_exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(" AND SCP_MN.EXP_DT >= TO_DATE(@[f_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(" AND SCP_MN.SVC_SCP_CD = @[f_scp]" ).append("\n"); 
		query.append(" AND MST_RFA_NO IS NOT NULL" ).append("\n"); 
		query.append(" #if( ${f_rfa_no} != '' )" ).append("\n"); 
		query.append(" AND HDR.RFA_NO = @[f_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if( ${f_m_rfa_no} != '')" ).append("\n"); 
		query.append(" AND HDR.MST_RFA_NO = @[f_m_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if( ${f_sls_rep} != '')" ).append("\n"); 
		query.append(" AND MN.PROP_SREP_CD = @[f_sls_rep]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if( ${f_req_ofc} != '')" ).append("\n"); 
		query.append(" AND MN.PROP_OFC_CD = @[f_req_ofc]" ).append("\n"); 
		query.append(" #elseif( ${f_req_rhq} != '')" ).append("\n"); 
		query.append(" AND MAS.OFC_N3RD_LVL_CD = @[f_req_rhq]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" #if( ${f_rfa_tp_b} != '')" ).append("\n"); 
		query.append(" AND (MN.RFA_CTRT_TP_CD = 'B'" ).append("\n"); 
		query.append("		OR (MN.RFA_CTRT_TP_CD IN(''" ).append("\n"); 
		query.append("								,@[f_rfa_tp_c]" ).append("\n"); 
		query.append("								,@[f_rfa_tp_s]" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("			AND MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("		AND (MN.RFA_CTRT_TP_CD IN(''" ).append("\n"); 
		query.append("								,@[f_rfa_tp_c]" ).append("\n"); 
		query.append("								,@[f_rfa_tp_s]" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("			AND MN.AMDT_SEQ = 0" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}