/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOAddModelRevLaneCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddModelRevLaneCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 버전 생성시 최신버전의 REV_LANE 정보를 그대로 insert합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOAddModelRevLaneCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddModelRevLaneCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("       TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , VER_SEQ" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , DTL_SEQ" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CUST_CTRL_CD" ).append("\n"); 
		query.append("     , SLS_RHQ_CD" ).append("\n"); 
		query.append("     , SLS_AQ_CD" ).append("\n"); 
		query.append("     , CTRT_OFC_CD" ).append("\n"); 
		query.append("     , CUST_BKG_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_BKG_QTY" ).append("\n"); 
		query.append("     , RLANE_BKG_QTY" ).append("\n"); 
		query.append("     , CUST_ADJ_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("     , RLANE_ADJ_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_CMPB_AMT" ).append("\n"); 
		query.append("     , RLANE_CMPB_AMT" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_CD" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , RHQ_UPD_USR_ID" ).append("\n"); 
		query.append("     , RHQ_UPD_DT" ).append("\n"); 
		query.append("     , OFC_UPD_USR_ID" ).append("\n"); 
		query.append("     , OFC_UPD_DT" ).append("\n"); 
		query.append("     , LANE_UPD_USR_ID" ).append("\n"); 
		query.append("     , LANE_UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , @[ver_seq]" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , DTL_SEQ" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CUST_CTRL_CD" ).append("\n"); 
		query.append("     , SLS_RHQ_CD" ).append("\n"); 
		query.append("     , SLS_AQ_CD" ).append("\n"); 
		query.append("     , CTRT_OFC_CD" ).append("\n"); 
		query.append("     , CUST_BKG_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_BKG_QTY" ).append("\n"); 
		query.append("     , RLANE_BKG_QTY" ).append("\n"); 
		query.append("     , CUST_ADJ_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("     , RLANE_ADJ_QTY" ).append("\n"); 
		query.append("     , SUB_TRD_CMPB_AMT" ).append("\n"); 
		query.append("     , RLANE_CMPB_AMT" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_CD" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , RHQ_UPD_USR_ID" ).append("\n"); 
		query.append("     , RHQ_UPD_DT" ).append("\n"); 
		query.append("     , OFC_UPD_USR_ID" ).append("\n"); 
		query.append("     , OFC_UPD_DT" ).append("\n"); 
		query.append("     , LANE_UPD_USR_ID" ).append("\n"); 
		query.append("     , LANE_UPD_DT" ).append("\n"); 
		query.append("FROM SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("WHERE TRD_CD = @[trade]" ).append("\n"); 
		query.append("  AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("  AND VER_SEQ = TO_NUMBER(@[ver_seq])-1" ).append("\n"); 

	}
}