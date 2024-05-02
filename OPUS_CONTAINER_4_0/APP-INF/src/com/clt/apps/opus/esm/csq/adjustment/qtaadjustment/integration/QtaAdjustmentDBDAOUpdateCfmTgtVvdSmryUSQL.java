/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmTgtVvdSmryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.09.24 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateCfmTgtVvdSmryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Supply Portion 적용하여 만든 CFM QTA 를 Smry 하여 TGT VVD 에 반영
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmTgtVvdSmryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_vvd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmTgtVvdSmryUSQL").append("\n"); 
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
		query.append("MERGE INTO CSQ_CFM_TGT_VVD T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("               ,BSE_TP_CD" ).append("\n"); 
		query.append("               ,BSE_YR" ).append("\n"); 
		query.append("               ,BSE_QTR_CD" ).append("\n"); 
		query.append("               ,QTA_TGT_CD" ).append("\n"); 
		query.append("               ,TRD_CD" ).append("\n"); 
		query.append("               ,RLANE_CD" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,VSL_CD" ).append("\n"); 
		query.append("               ,SKD_VOY_NO" ).append("\n"); 
		query.append("               ,SKD_DIR_CD" ).append("\n"); 
		query.append("               ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("               ,ROUND(SUM(LOD_QTY * GRS_RPB_REV), 0) AS GRS_REV" ).append("\n"); 
		query.append("           FROM CSQ_CFM_QTA" ).append("\n"); 
		query.append("          WHERE QTA_RLSE_VER_NO = @[qta_rlse_ver_no]" ).append("\n"); 
		query.append("            AND BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD      = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("            AND OFC_VW_CD       = 'L'" ).append("\n"); 
		query.append("            AND QTA_TGT_CD      = 'D'" ).append("\n"); 
		query.append("            AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("            AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("            AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("            AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[coa_vvd]" ).append("\n"); 
		query.append("       GROUP BY QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("               ,BSE_TP_CD" ).append("\n"); 
		query.append("               ,BSE_YR" ).append("\n"); 
		query.append("               ,BSE_QTR_CD" ).append("\n"); 
		query.append("               ,QTA_TGT_CD" ).append("\n"); 
		query.append("               ,TRD_CD" ).append("\n"); 
		query.append("               ,RLANE_CD" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,VSL_CD" ).append("\n"); 
		query.append("               ,SKD_VOY_NO" ).append("\n"); 
		query.append("               ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("   ON (         T.QTA_RLSE_VER_NO = C.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            AND T.BSE_TP_CD       = C.BSE_TP_CD" ).append("\n"); 
		query.append("            AND T.BSE_YR          = C.BSE_YR" ).append("\n"); 
		query.append("            AND T.BSE_QTR_CD      = C.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND T.QTA_TGT_CD      = C.QTA_TGT_CD" ).append("\n"); 
		query.append("            AND T.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("            AND T.RLANE_CD        = C.RLANE_CD" ).append("\n"); 
		query.append("            AND T.DIR_CD          = C.DIR_CD" ).append("\n"); 
		query.append("            AND T.VSL_CD          = C.VSL_CD" ).append("\n"); 
		query.append("            AND T.SKD_VOY_NO      = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T.SKD_DIR_CD      = C.SKD_DIR_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET T.LOD_QTY    = C.LOD_QTY" ).append("\n"); 
		query.append("           ,T.GRS_REV    = C.GRS_REV" ).append("\n"); 
		query.append("           ,T.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("           ,T.UPD_DT     = SYSDATE" ).append("\n"); 

	}
}