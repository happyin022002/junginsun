/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonQtaAdjSmryWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonQtaAdjSmryWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonQtaAdjSmryWeekListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dat_cre_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_orz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_mst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonQtaAdjSmryWeekListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.COST_WK  AS TEXT  " ).append("\n"); 
		query.append("  , B.COST_WK   " ).append("\n"); 
		query.append("  || '|'   " ).append("\n"); 
		query.append("  || SUBSTR(B.SLS_FM_DT,1,4) || '.' || SUBSTR(B.SLS_FM_DT,5,2)  || '.' ||  SUBSTR(B.SLS_FM_DT,7,2)  " ).append("\n"); 
		query.append("  || '|'   " ).append("\n"); 
		query.append("  || SUBSTR(B.SLS_TO_DT,1,4) || '.' || SUBSTR(B.SLS_TO_DT,5,2)  || '.' ||  SUBSTR(B.SLS_TO_DT,7,2)  " ).append("\n"); 
		query.append("  AS CODE  " ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_ADJ_SMRY_HDR HDR " ).append("\n"); 
		query.append("     ,SAQ_MON_QTA_ADJ_SMRY A  " ).append("\n"); 
		query.append("     ,SAQ_MON_TGT_VVD_ADJ VVD  " ).append("\n"); 
		query.append("     ,COA_WK_PRD B  " ).append("\n"); 
		query.append("WHERE HDR.QTA_MST_VER_NO = @[qta_mst_ver_no]   " ).append("\n"); 
		query.append("AND HDR.BSE_YR = @[bse_yr]   " ).append("\n"); 
		query.append("AND HDR.BSE_QTR_CD = @[bse_qtr_cd]   " ).append("\n"); 
		query.append("AND HDR.TRD_CD = @[trd_cd] AND A.DIR_CD = @[dir_cd]   " ).append("\n"); 
		query.append("AND HDR.DAT_CRE_STEP_CD = @[dat_cre_step_cd]  " ).append("\n"); 
		query.append("AND HDR.TGT_ORZ_CD = @[tgt_orz_cd]  " ).append("\n"); 
		query.append("AND A.BSE_YR = HDR.BSE_YR " ).append("\n"); 
		query.append("AND A.BSE_QTR_CD = HDR.BSE_QTR_CD " ).append("\n"); 
		query.append("AND A.SAQ_TGT_GRP_CD = HDR.SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("AND A.GLINE_VER_NO = HDR.GLINE_VER_NO " ).append("\n"); 
		query.append("AND A.TRD_CD = HDR.TRD_CD " ).append("\n"); 
		query.append("AND A.DIR_CD = HDR.DIR_CD " ).append("\n"); 
		query.append("AND A.DAT_CRE_STEP_CD = HDR.DAT_CRE_STEP_CD " ).append("\n"); 
		query.append("AND A.BSE_YR = VVD.BSE_YR  " ).append("\n"); 
		query.append("AND A.BSE_QTR_CD = VVD.BSE_QTR_CD  " ).append("\n"); 
		query.append("AND A.GLINE_VER_NO = VVD.GLINE_VER_NO  " ).append("\n"); 
		query.append("AND A.TRD_CD = VVD.TRD_CD  " ).append("\n"); 
		query.append("AND A.RLANE_CD = VVD.RLANE_CD  " ).append("\n"); 
		query.append("AND A.DIR_CD = VVD.DIR_CD  " ).append("\n"); 
		query.append("AND A.VSL_CD = VVD.VSL_CD  " ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = VVD.SKD_VOY_NO  " ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = VVD.SKD_DIR_CD  " ).append("\n"); 
		query.append("AND B.COST_YR = VVD.BSE_YR  " ).append("\n"); 
		query.append("AND B.COST_WK = VVD.BSE_WK  " ).append("\n"); 
		query.append("ORDER BY B.COST_WK      	" ).append("\n"); 

	}
}