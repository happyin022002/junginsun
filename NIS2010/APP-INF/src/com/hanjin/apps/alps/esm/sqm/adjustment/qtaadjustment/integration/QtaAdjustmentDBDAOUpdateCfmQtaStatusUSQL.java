/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmQtaStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateCfmQtaStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Qta Edit]의 change type을 [저장] 합니다
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmQtaStatusUSQL(){
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
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sqm_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmQtaStatusUSQL").append("\n"); 
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
		query.append("UPDATE SQM_CFM_QTA " ).append("\n"); 
		query.append("   SET SQM_CNG_TP_CD = CASE @[sqm_cng_tp_cd] WHEN 'M' THEN 'M'" ).append("\n"); 
		query.append("                                             WHEN 'I' THEN 'M'" ).append("\n"); 
		query.append("                                             WHEN 'A' THEN 'A' END  " ).append("\n"); 
		query.append("      ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT        = SYSDATE " ).append("\n"); 
		query.append(" WHERE BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("   AND OFC_VW_CD                  = @[ofc_vw_cd]" ).append("\n"); 
		query.append("   AND QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("   AND TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD                     = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO                 = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD                 = @[skd_dir_cd]" ).append("\n"); 
		query.append("--   AND SQM_CNG_TP_CD              <>'A'" ).append("\n"); 
		query.append("   AND SQM_CNG_TP_CD              IN ( (CASE @[sqm_cng_tp_cd] WHEN 'M' THEN 'M' WHEN 'I' THEN 'I' WHEN 'A' THEN 'A' END), (CASE @[sqm_cng_tp_cd] WHEN 'M' THEN 'I' WHEN 'I' THEN 'M' WHEN 'A' THEN 'A' END))" ).append("\n"); 
		query.append("                                                            " ).append("\n"); 

	}
}