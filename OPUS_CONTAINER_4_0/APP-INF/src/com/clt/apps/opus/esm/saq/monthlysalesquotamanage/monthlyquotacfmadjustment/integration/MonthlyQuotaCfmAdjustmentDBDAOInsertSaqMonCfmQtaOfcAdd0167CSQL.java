/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQtaOfcAdd0167CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.11 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQtaOfcAdd0167CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup 관련 Data 처리
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQtaOfcAdd0167CSQL(){
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
		params.put("temp_qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("temp_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQtaOfcAdd0167CSQL").append("\n"); 
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
		query.append("INSERT INTO  SAQ_MON_CFM_QTA_OFC_ADD" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            MQTA_RLSE_VER_NO, " ).append("\n"); 
		query.append("            BSE_YR    , " ).append("\n"); 
		query.append("            BSE_QTR_CD, " ).append("\n"); 
		query.append("            QTA_TGT_CD," ).append("\n"); 
		query.append("            TRD_CD    , " ).append("\n"); 
		query.append("            DIR_CD    , " ).append("\n"); 
		query.append("            VSL_CD    , " ).append("\n"); 
		query.append("            SKD_VOY_NO," ).append("\n"); 
		query.append("            SKD_DIR_CD , " ).append("\n"); 
		query.append("            SUB_TRD_CD, " ).append("\n"); 
		query.append("            RLANE_CD  , " ).append("\n"); 
		query.append("            RHQ_CD    ," ).append("\n"); 
		query.append("            AQ_CD     , " ).append("\n"); 
		query.append("            RGN_OFC_CD, " ).append("\n"); 
		query.append("            ADD_TP_CD , " ).append("\n"); 
		query.append("            DELT_FLG  ," ).append("\n"); 
		query.append("            CRE_USR_ID, " ).append("\n"); 
		query.append("            CRE_DT    , " ).append("\n"); 
		query.append("            UPD_USR_ID, " ).append("\n"); 
		query.append("            UPD_DT      " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("        @[mqta_rlse_ver_no], " ).append("\n"); 
		query.append("        @[bse_yr], " ).append("\n"); 
		query.append("        @[bse_qtr_cd], " ).append("\n"); 
		query.append("        @[temp_qta_tgt_cd]," ).append("\n"); 
		query.append("        @[trd_cd], " ).append("\n"); 
		query.append("        @[dir_cd], " ).append("\n"); 
		query.append("        @[vsl_cd], " ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd], " ).append("\n"); 
		query.append("        @[sub_trd_cd], " ).append("\n"); 
		query.append("        @[temp_rlane_cd], " ).append("\n"); 
		query.append("        @[rhq_cd]," ).append("\n"); 
		query.append("        @[aq_cd], " ).append("\n"); 
		query.append("        @[rgn_ofc_cd], " ).append("\n"); 
		query.append("        @[add_tp_cd], " ).append("\n"); 
		query.append("        @[delt_flg]," ).append("\n"); 
		query.append("        @[cre_usr_id], " ).append("\n"); 
		query.append("        SYSDATE, " ).append("\n"); 
		query.append("        @[upd_usr_id], " ).append("\n"); 
		query.append("        SYSDATE " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}