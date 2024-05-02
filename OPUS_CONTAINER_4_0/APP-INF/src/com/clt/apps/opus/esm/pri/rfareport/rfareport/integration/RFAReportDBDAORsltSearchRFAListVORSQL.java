/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RFAReportDBDAORsltSearchRFAListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltSearchRFAListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Retrieve
	  * </pre>
	  */
	public RFAReportDBDAORsltSearchRFAListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_scp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltSearchRFAListVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("RA  AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  RS.SVC_SCP_CD           ," ).append("\n"); 
		query.append("        RH.RFA_NO               ," ).append("\n"); 
		query.append("        RM.AMDT_SEQ             ," ).append("\n"); 
		query.append("        RM.PRC_CTRT_CUST_TP_CD  ," ).append("\n"); 
		query.append("        RM.CTRT_CUST_CNT_CD     ," ).append("\n"); 
		query.append("        RM.CTRT_CUST_SEQ        ," ).append("\n"); 
		query.append("        ( SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = RM.CTRT_CUST_CNT_CD AND A.CUST_SEQ = RM.CTRT_CUST_SEQ ) CUST_NM ," ).append("\n"); 
		query.append("        RS.PROP_SCP_OFC_CD      ," ).append("\n"); 
		query.append("        RS.PROP_SCP_SREP_CD     ," ).append("\n"); 
		query.append("        RD.CTRT_EFF_DT          ," ).append("\n"); 
		query.append("        RD.CTRT_EXP_DT          " ).append("\n"); 
		query.append("FROM    PRI_RP_HDR     RH  ," ).append("\n"); 
		query.append("        PRI_RP_MN      RM  ," ).append("\n"); 
		query.append("        PRI_RP_SCP_MN  RS  ," ).append("\n"); 
		query.append("        PRI_RP_SCP_DUR RD" ).append("\n"); 
		query.append("WHERE   RM.PROP_NO       = RH.PROP_NO" ).append("\n"); 
		query.append("AND     RM.PROP_STS_CD   = 'A'" ).append("\n"); 
		query.append("AND     RS.PROP_NO       = RM.PROP_NO" ).append("\n"); 
		query.append("AND     RS.AMDT_SEQ      = RM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     RD.PROP_NO       = RS.PROP_NO" ).append("\n"); 
		query.append("AND     RD.AMDT_SEQ      = RS.AMDT_SEQ" ).append("\n"); 
		query.append("AND     RD.SVC_SCP_CD    = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("AND     RH.RFA_NO             LIKE @[rfa_no] || '%' -- RFA No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_ctrt_cust_tp_cd} != '') " ).append("\n"); 
		query.append("AND    RM.PRC_CTRT_CUST_TP_CD = @[prc_ctrt_cust_tp_cd] -- Customer Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_scp_srep_cd} != '') " ).append("\n"); 
		query.append("AND    RS.PROP_SCP_SREP_CD    = @[prop_scp_srep_cd] -- S.Rep : RESPB_SREP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_scp_ofc_cd} != '') " ).append("\n"); 
		query.append("AND    RS.PROP_SCP_OFC_CD     = @[prop_scp_ofc_cd] -- Contract Office : RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND    RS.SVC_SCP_CD          = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    RS.EFF_DT              <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') -- Effective Date(To) or Access Date" ).append("\n"); 
		query.append("AND    RS.EXP_DT              >= TO_DATE(@[eff_dt], 'YYYY-MM-DD') -- Effective Date(From) or Access Date" ).append("\n"); 
		query.append("#if (${customer_code} == 'C' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') -- Customer" ).append("\n"); 
		query.append("AND    RM.CTRT_CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Customer" ).append("\n"); 
		query.append("AND    RM.CTRT_CUST_SEQ    = @[ctrt_cust_seq] -- Customer" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${customer_code} == 'A' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '') -- Actual Customer" ).append("\n"); 
		query.append("AND    EXISTS  (" ).append("\n"); 
		query.append("                SELECT  'X'" ).append("\n"); 
		query.append("                FROM    PRI_RP_SCP_RT_ACT_CUST  AC" ).append("\n"); 
		query.append("                WHERE   AC.PROP_NO     = RS.PROP_NO" ).append("\n"); 
		query.append("                AND     AC.AMDT_SEQ    = RS.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     AC.SVC_SCP_CD  = RS.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     AC.CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Actual Customer" ).append("\n"); 
		query.append("                AND     AC.CUST_SEQ    = @[ctrt_cust_seq] -- Actual Customer" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${customer_code} == 'F' && ${ctrt_cust_cnt_cd} != '' && ${ctrt_cust_seq} != '')  -- Affiliate" ).append("\n"); 
		query.append("AND    EXISTS  (" ).append("\n"); 
		query.append("                SELECT  'X'" ).append("\n"); 
		query.append("                FROM    PRI_RP_AFIL AF" ).append("\n"); 
		query.append("                WHERE   AF.PROP_NO     = RM.PROP_NO" ).append("\n"); 
		query.append("                AND     AF.AMDT_SEQ    = RM.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     AF.CUST_CNT_CD = @[ctrt_cust_cnt_cd] -- Affiliate" ).append("\n"); 
		query.append("                AND     AF.CUST_SEQ    = @[ctrt_cust_seq] -- Affiliate" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD          ," ).append("\n"); 
		query.append("        RFA_NO              ," ).append("\n"); 
		query.append("        AMDT_SEQ AS AMDT_SEQ ," ).append("\n"); 
		query.append("        PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("		(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00779' AND INTG_CD_VAL_CTNT = A.PRC_CTRT_CUST_TP_CD) AS PRC_CTRT_CUST_TP_NM ," ).append("\n"); 
		query.append("        CTRT_CUST_CNT_CD    ," ).append("\n"); 
		query.append("        CTRT_CUST_SEQ       ," ).append("\n"); 
		query.append("	    CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ,6,0) AS CODE ," ).append("\n"); 
		query.append("        CUST_NM             ," ).append("\n"); 
		query.append("        PROP_SCP_OFC_CD     ," ).append("\n"); 
		query.append("        PROP_SCP_SREP_CD    ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EFF_DT,'YYYY-MM-DD') AS CTRT_EFF_DT ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EXP_DT,'YYYY-MM-DD') AS CTRT_EXP_DT ," ).append("\n"); 
		query.append("        '' AS EFF_DT        , -- param" ).append("\n"); 
		query.append("        '' AS EXP_DT        , -- param" ).append("\n"); 
		query.append("        '' AS CUSTOMER_CODE   -- param" ).append("\n"); 
		query.append("FROM    RA  A" ).append("\n"); 
		query.append("WHERE   NOT EXISTS (" ).append("\n"); 
		query.append("                     SELECT  'X'" ).append("\n"); 
		query.append("                     FROM   RA B" ).append("\n"); 
		query.append("                     WHERE  B.RFA_NO     = A.RFA_NO" ).append("\n"); 
		query.append("                     AND    B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND    B.AMDT_SEQ   > A.AMDT_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("          SVC_SCP_CD  ," ).append("\n"); 
		query.append("          RFA_NO" ).append("\n"); 

	}
}