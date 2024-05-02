/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaOfcAdd0167USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.11
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.06.11 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaOfcAdd0167USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup 관련 Data 처리
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaOfcAdd0167USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("add_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaOfcAdd0167USQL").append("\n"); 
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
		query.append("UPDATE  SAQ_MON_CFM_QTA_OFC_ADD" ).append("\n"); 
		query.append("   SET  DELT_FLG   = @[delt_flg]," ).append("\n"); 
		query.append("        UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("  WHERE MQTA_RLSE_VER_NO = @[mqta_rlse_ver_no]" ).append("\n"); 
		query.append("    AND BSE_YR           = @[bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD       = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND QTA_TGT_CD       = @[qta_tgt_cd]" ).append("\n"); 
		query.append("    AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("    AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("    AND VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("    AND SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD         = @[new_rlane_cd]" ).append("\n"); 
		query.append("    AND RHQ_CD           = @[rhq_cd]" ).append("\n"); 
		query.append("#if (${aq_cd} != '') " ).append("\n"); 
		query.append("    AND AQ_CD            = @[aq_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    AND AQ_CD IS NULL" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("    AND RGN_OFC_CD       = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    AND ADD_TP_CD        = @[add_tp_cd]" ).append("\n"); 

	}
}