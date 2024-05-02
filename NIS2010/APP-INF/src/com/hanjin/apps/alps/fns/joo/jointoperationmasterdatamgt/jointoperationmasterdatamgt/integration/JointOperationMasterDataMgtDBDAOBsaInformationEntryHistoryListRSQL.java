/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.30 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI, Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBsaInformationEntryHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaInformationEntryHistoryList
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBsaInformationEntryHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryHistoryListRSQL").append("\n"); 
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
		query.append("SELECT A.YRWK" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , DECODE(A.RE_DIVR_CD,'R','Rev','Exp') RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.PORT_CD" ).append("\n"); 
		query.append("     , A.PORT_SEQ" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_BSA_ADD_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_ADD_BSA_CRR_FLG" ).append("\n"); 
		query.append("	 , A.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_TON_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("	 , A.JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_20FT_OVR_RTO" ).append("\n"); 
		query.append("	 , A.JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_40FT_OVR_RTO" ).append("\n"); 
		query.append("	 , A.JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_45FT_OVR_RTO" ).append("\n"); 
		query.append("	 , A.JO_45FT_UND_RTO" ).append("\n"); 
		query.append("	 , A.JO_RND_KND_FLG" ).append("\n"); 
		query.append("	 , A.JO_RND_RULE_LVL" ).append("\n"); 
		query.append("	 , A.JO_RF_OCN_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_RF_INTER_TEU_QTY" ).append("\n"); 
		query.append("	 , A.JO_INTER_OVR_FLG" ).append("\n"); 
		query.append("	 , A.JO_RDR_PORT_CD" ).append("\n"); 
		query.append("	 , A.JO_FSH_FLG" ).append("\n"); 
		query.append("	 , A.JO_BSA_PRC" ).append("\n"); 
		query.append("	 , A.JO_OVR_OCN_PRC" ).append("\n"); 
		query.append("	 , A.JO_OVR_INTER_PRC" ).append("\n"); 
		query.append("	 , A.JO_OVR_MT_OCN_PRC" ).append("\n"); 
		query.append("	 , A.JO_OVR_MT_INTER_PRC" ).append("\n"); 
		query.append("	 , A.JO_SCTR_PRC_FLG" ).append("\n"); 
		query.append("	 , A.JO_RF_OCN_PRC" ).append("\n"); 
		query.append("	 , A.JO_RF_INTER_PRC" ).append("\n"); 
		query.append("	 , A.JO_PRC_FSH_FLG" ).append("\n"); 
		query.append("	 , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ VVD_PORT" ).append("\n"); 
		query.append("	 , A.JO_BSA_ENTR_RDR_RMK" ).append("\n"); 
		query.append("	 , A.JO_BSA_ENTR_RMK" ).append("\n"); 
		query.append("	 , TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	 , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("	 , A.UPD_USR_ID " ).append("\n"); 
		query.append("	 , U.USR_NM " ).append("\n"); 
		query.append("	 , A.DELT_FLG " ).append("\n"); 
		query.append("	 , TO_CHAR(TO_DATE(A.REV_PORT_ETD_DT,'YYYY-MM-DD'),'YYYY-MM-DD') REV_PORT_ETD_DT" ).append("\n"); 
		query.append("  FROM JOO_BSA_AGMT_HIS A, COM_USER U" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.PORT_CD||A.PORT_SEQ||A.JO_CRR_CD = @[vvd_port]" ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("ORDER BY HIS_SEQ" ).append("\n"); 

	}
}