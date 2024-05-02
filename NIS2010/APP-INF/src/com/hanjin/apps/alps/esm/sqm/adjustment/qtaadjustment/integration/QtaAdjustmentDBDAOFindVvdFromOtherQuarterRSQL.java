/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOFindVvdFromOtherQuarterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.02 
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

public class QtaAdjustmentDBDAOFindVvdFromOtherQuarterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.01.15 CHM-201639770 VVD Adjustment의 Update Option 추가 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOFindVvdFromOtherQuarterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOFindVvdFromOtherQuarterRSQL").append("\n"); 
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
		query.append("select QTA_RLSE_VER_NO, BSE_TP_CD, BSE_QTR_CD, TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD from sqm_cfm_tgt_vvd" ).append("\n"); 
		query.append("where BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("AND QTA_TGT_CD = 'D'" ).append("\n"); 
		query.append("AND TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("AND BSE_QTR_CD != @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select QTA_RLSE_VER_NO, BSE_TP_CD, BSE_QTR_CD, TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD from SQM_CFM_TGT_VVD_ADJ" ).append("\n"); 
		query.append("where SQM_VVD_HIS_TP_CD = 'D'" ).append("\n"); 
		query.append("and BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("AND TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("AND BSE_QTR_CD != @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 

	}
}