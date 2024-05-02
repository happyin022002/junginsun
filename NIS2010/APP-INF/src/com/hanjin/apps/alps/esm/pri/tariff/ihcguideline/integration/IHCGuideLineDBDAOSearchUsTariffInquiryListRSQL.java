/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchUsTariffInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.20 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchUsTariffInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search US Tariff Inquiry List
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchUsTariffInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchUsTariffInquiryListRSQL").append("\n"); 
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
		query.append("SELECT Y.PNT_LOC_CD," ).append("\n"); 
		query.append("       (SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD = Y.PNT_LOC_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS PNT_LOC_NM, " ).append("\n"); 
		query.append("       Y.HUB_LOC_CD," ).append("\n"); 
		query.append("       Y.BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("       Y.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("       Y.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_20FT_RAIL_FRT_RT_AMT, 'FM9,999,999,990.90') AS GLINE_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_40FT_RAIL_FRT_RT_AMT, 'FM9,999,999,990.90') AS GLINE_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_20FT_TRK_FRT_RT_AMT , 'FM9,999,999,990.90') AS GLINE_20FT_TRK_FRT_RT_AMT, " ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_40FT_TRK_FRT_RT_AMT , 'FM9,999,999,990.90') AS GLINE_40FT_TRK_FRT_RT_AMT, " ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_20FT_FRT_RT_AMT     , 'FM9,999,999,990.90') AS GLINE_20FT_FRT_RT_AMT,     " ).append("\n"); 
		query.append("       TO_CHAR(Y.GLINE_40FT_FRT_RT_AMT     , 'FM9,999,999,990.90') AS GLINE_40FT_FRT_RT_AMT,     " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_20FT_RAIL_FRT_RT_AMT , 'FM9,999,999,990.90') AS COST_20FT_RAIL_FRT_RT_AMT, " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_40FT_RAIL_FRT_RT_AMT , 'FM9,999,999,990.90') AS COST_40FT_RAIL_FRT_RT_AMT, " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_20FT_TRK_FRT_RT_AMT  , 'FM9,999,999,990.90') AS COST_20FT_TRK_FRT_RT_AMT,  " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_40FT_TRK_FRT_RT_AMT  , 'FM9,999,999,990.90') AS COST_40FT_TRK_FRT_RT_AMT,  " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_20FT_FRT_RT_AMT      , 'FM9,999,999,990.90') AS COST_20FT_FRT_RT_AMT,      " ).append("\n"); 
		query.append("       TO_CHAR(Y.COST_40FT_FRT_RT_AMT      , 'FM9,999,999,990.90') AS COST_40FT_FRT_RT_AMT, " ).append("\n"); 
		query.append("       Y.MB_20FT_RTO," ).append("\n"); 
		query.append("       Y.MB_40FT_RTO," ).append("\n"); 
		query.append("       Y.SVC_SCP_CD," ).append("\n"); 
		query.append("       Y.IHC_TRF_NO," ).append("\n"); 
		query.append("       Y.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("       '' AS ACC_DT" ).append("\n"); 
		query.append("  FROM (SELECT MN.SVC_SCP_CD," ).append("\n"); 
		query.append("               MN.IHC_TRF_NO," ).append("\n"); 
		query.append("               MN.AMDT_SEQ," ).append("\n"); 
		query.append("               T.COST_CNT_CD," ).append("\n"); 
		query.append("               MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_HDR T," ).append("\n"); 
		query.append("               PRI_TRF_IHC_MN  MN" ).append("\n"); 
		query.append("         WHERE 1=1  " ).append("\n"); 
		query.append("           AND T.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND T.IHC_TRF_NO = MN.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND T.ORG_DEST_TP_CD = MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("           AND TO_DATE(@[acc_dt],'YYYY-MM-DD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("           AND MN.FIC_PROP_STS_CD = 'C' " ).append("\n"); 
		query.append("       ) X," ).append("\n"); 
		query.append("       PRI_TRF_IHC_RT Y," ).append("\n"); 
		query.append("       PRI_TRF_IHC_HDR H" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.SVC_SCP_CD = Y.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND X.IHC_TRF_NO = Y.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND X.AMDT_SEQ = Y.AMDT_SEQ" ).append("\n"); 
		query.append("   AND X.ORG_DEST_TP_CD = Y.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND Y.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("   AND Y.SRC_INFO_CD != 'AD'" ).append("\n"); 
		query.append("   AND X.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND X.IHC_TRF_NO = H.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND X.ORG_DEST_TP_CD = H.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   AND Y.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pnt_loc_cd} != '')" ).append("\n"); 
		query.append("   AND Y.PNT_LOC_CD = @[pnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bse_port_loc_cd} != '')" ).append("\n"); 
		query.append("   AND Y.BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rcv_de_term_cd} != '')" ).append("\n"); 
		query.append("   AND Y.RCV_DE_TERM_CD = @[rcv_de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ORDER BY Y.PNT_LOC_CD" ).append("\n"); 

	}
}