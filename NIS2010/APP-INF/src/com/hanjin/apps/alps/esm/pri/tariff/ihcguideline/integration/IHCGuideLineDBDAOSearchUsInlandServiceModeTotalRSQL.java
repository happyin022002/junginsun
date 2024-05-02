/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchUsInlandServiceModeTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.21 CHLOE MIJIN SEO
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

public class IHCGuideLineDBDAOSearchUsInlandServiceModeTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search US Inland Service Mode Total
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchUsInlandServiceModeTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchUsInlandServiceModeTotalRSQL").append("\n"); 
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
		query.append("#if(${cost_cnt_cd} == 'US')" ).append("\n"); 
		query.append("    SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CD_DTL WHERE CD_DTL.INTG_CD_ID = 'CD03121' AND INTG_CD_VAL_CTNT = RT.USA_COST_TRF_SVC_MOD_CD) USA_COST_TRF_SVC_MOD_NM" ).append("\n"); 
		query.append("         , RT.USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("         , COUNT(RT.USA_COST_TRF_SVC_MOD_CD) TOTAL_COUNT" ).append("\n"); 
		query.append("         , TO_CHAR(MAX(RT.UPD_DT),'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("         , MAX(RT.UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("     FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("      AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("      AND RT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("      AND RT.IHC_CGO_TP_CD  = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("      AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("    GROUP BY USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("    ORDER BY USA_COST_TRF_SVC_MOD_CD DESC    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cost_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("    SELECT 'Canada Inland' USA_COST_TRF_SVC_MOD_NM" ).append("\n"); 
		query.append("         , COUNT(RT.IHC_TRF_NO) TOTAL_COUNT" ).append("\n"); 
		query.append("         , TO_CHAR(MAX(RT.UPD_DT),'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("         , MAX(RT.UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("     FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("      AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("      AND RT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("      AND RT.IHC_CGO_TP_CD  = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("      AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}