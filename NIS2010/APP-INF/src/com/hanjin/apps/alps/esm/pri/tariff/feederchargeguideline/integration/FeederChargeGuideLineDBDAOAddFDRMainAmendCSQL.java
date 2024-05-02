/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOAddFDRMainAmendCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.05 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOAddFDRMainAmendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add FDR Main Amend
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOAddFDRMainAmendCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_eff",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOAddFDRMainAmendCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_MN (" ).append("\n"); 
		query.append("            SVC_SCP_CD" ).append("\n"); 
		query.append("          , ORG_DEST_TP_CD  " ).append("\n"); 
		query.append("          , FDR_TRF_NO" ).append("\n"); 
		query.append("          , AMDT_SEQ" ).append("\n"); 
		query.append("          , EFF_DT" ).append("\n"); 
		query.append("          , EXP_DT" ).append("\n"); 
		query.append("          , FIC_PROP_STS_CD" ).append("\n"); 
		query.append("          , TRF_CURR_CD" ).append("\n"); 
		query.append("          , LOCL_CURR_CD          " ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT" ).append("\n"); 
		query.append("          , CRE_OFC_CD)" ).append("\n"); 
		query.append("     SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          , FDR_TRF_NO" ).append("\n"); 
		query.append("          , @[amdt_seq]+1" ).append("\n"); 
		query.append("          , TO_DATE(@[amdt_eff], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          , TO_DATE('99991231', 'YYYYMMDD')" ).append("\n"); 
		query.append("          , 'I' AS FIC_PROP_STS_CD" ).append("\n"); 
		query.append("          , TRF_CURR_CD" ).append("\n"); 
		query.append("          , LOCL_CURR_CD          " ).append("\n"); 
		query.append("          , @[cre_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , CRE_OFC_CD" ).append("\n"); 
		query.append("       FROM PRI_TRF_FDR_MN   " ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("        AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("        AND FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 

	}
}