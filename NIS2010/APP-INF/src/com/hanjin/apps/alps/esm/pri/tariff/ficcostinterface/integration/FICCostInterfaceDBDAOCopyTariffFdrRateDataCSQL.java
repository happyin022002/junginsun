/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FICCostInterfaceDBDAOCopyTariffFdrRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.08
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.08 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOCopyTariffFdrRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyTariffFdrRateData
	  * </pre>
	  */
	public FICCostInterfaceDBDAOCopyTariffFdrRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ori_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOCopyTariffFdrRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_RT (" ).append("\n"); 
		query.append("            SVC_SCP_CD" ).append("\n"); 
		query.append("          , ORG_DEST_TP_CD  " ).append("\n"); 
		query.append("          , FDR_TRF_NO" ).append("\n"); 
		query.append("          , AMDT_SEQ" ).append("\n"); 
		query.append("          , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("          , RT_SEQ" ).append("\n"); 
		query.append("          , PNT_LOC_CD" ).append("\n"); 
		query.append("          , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("          , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("          , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("          , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("          , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("          , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("          , MB_20FT_RTO" ).append("\n"); 
		query.append("          , MB_40FT_RTO" ).append("\n"); 
		query.append("          , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("          , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("          , RHQ_CD" ).append("\n"); 
		query.append("          , SRC_INFO_CD" ).append("\n"); 
		query.append("          , FDR_RT_RMK" ).append("\n"); 
		query.append("          , RC_SVC_FLG" ).append("\n"); 
		query.append("          , GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_RF_20FT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_RF_40FT_RT_AMT" ).append("\n"); 
		query.append("          , TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("          , MTY_TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("          , MTY_TRSP_RF_40FT_COST_AMT     " ).append("\n"); 
		query.append("          , TML_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TML_RF_40FT_COST_AMT   " ).append("\n"); 
		query.append("          , MB_RF_20FT_RTO" ).append("\n"); 
		query.append("          , MB_RF_40FT_RTO " ).append("\n"); 
		query.append("          , LOCL_CURR_CD" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT          " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    SELECT @[svc_scp_cd]" ).append("\n"); 
		query.append("         , @[org_dest_tp_cd]" ).append("\n"); 
		query.append("         , @[fdr_trf_no]" ).append("\n"); 
		query.append("         , '0'" ).append("\n"); 
		query.append("         , '0' AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , ROWNUM RT_SEQ" ).append("\n"); 
		query.append("         , PNT_LOC_CD" ).append("\n"); 
		query.append("         , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("         , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("         , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("         , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("         , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("         , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("         , MB_20FT_RTO" ).append("\n"); 
		query.append("         , MB_40FT_RTO" ).append("\n"); 
		query.append("         , WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         , WTR_DE_TERM_CD" ).append("\n"); 
		query.append("         , RHQ_CD" ).append("\n"); 
		query.append("         , SRC_INFO_CD" ).append("\n"); 
		query.append("         , FDR_RT_RMK" ).append("\n"); 
		query.append("         , RC_SVC_FLG" ).append("\n"); 
		query.append("         , GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_RF_20FT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_RF_40FT_RT_AMT" ).append("\n"); 
		query.append("         , TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TRSP_RF_40FT_COST_AMT" ).append("\n"); 
		query.append("         , MTY_TRSP_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("         , MTY_TRSP_RF_40FT_COST_AMT     " ).append("\n"); 
		query.append("         , TML_RF_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TML_RF_40FT_COST_AMT   " ).append("\n"); 
		query.append("         , MB_RF_20FT_RTO" ).append("\n"); 
		query.append("         , MB_RF_40FT_RTO     " ).append("\n"); 
		query.append("         , LOCL_CURR_CD" ).append("\n"); 
		query.append("         , @[cre_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("         , @[upd_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE         " ).append("\n"); 
		query.append("      FROM PRI_TRF_FDR_RT  " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND SVC_SCP_CD       = @[ori_svc_scp_cd] " ).append("\n"); 
		query.append("       AND ORG_DEST_TP_CD   = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("       AND FDR_TRF_NO       = @[ori_fdr_trf_no]" ).append("\n"); 
		query.append("       AND AMDT_SEQ         = @[ori_amdt_seq]" ).append("\n"); 
		query.append("       AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}