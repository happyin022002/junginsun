/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.09.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_invt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lost_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_bar_atch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_otr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_dmg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_flg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_EQ_STS" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		EQ_NO," ).append("\n"); 
		query.append("		EQ_KND_CD," ).append("\n"); 
		query.append("		EQ_TPSZ_CD," ).append("\n"); 
		query.append("		MNR_HNGR_FLG_YD_CD," ).append("\n"); 
		query.append("        MNR_HNGR_FLG," ).append("\n"); 
		query.append("		MNR_HNGR_RCK_CD," ).append("\n"); 
		query.append("		HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("		MNR_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("		MNR_HNGR_FLG_DT," ).append("\n"); 
		query.append("		MNR_STS_RMK," ).append("\n"); 
		query.append("		MNR_HNGR_TRF_CD," ).append("\n"); 
		query.append("		MNR_HNGR_TRF_OTR_DESC, " ).append("\n"); 
		query.append("		MNR_HNGR_DMG_QTY, " ).append("\n"); 
		query.append("		ACT_INVT_QTY, " ).append("\n"); 
		query.append("		MNR_LOST_HNGR_QTY, " ).append("\n"); 
		query.append("		MNR_DISP_HNGR_QTY," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append("	)VALUES( " ).append("\n"); 
		query.append("    	@[eq_no],        " ).append("\n"); 
		query.append("		'U',                  " ).append("\n"); 
		query.append("		@[eq_tpsz_cd],        " ).append("\n"); 
		query.append("		@[mnr_hngr_flg_yd_cd]," ).append("\n"); 
		query.append("        @[mnr_hngr_flg]," ).append("\n"); 
		query.append("		@[mnr_hngr_rck_cd],   " ).append("\n"); 
		query.append("		NVL(@[hngr_bar_atch_knt],0), " ).append("\n"); 
		query.append("		@[mnr_hngr_bar_tp_cd]," ).append("\n"); 
		query.append("		TO_DATE(@[mnr_hngr_flg_dt],'YYYY-MM-DD'),  " ).append("\n"); 
		query.append("		@[mnr_sts_rmk], " ).append("\n"); 
		query.append("		@[mnr_hngr_trf_cd]," ).append("\n"); 
		query.append("		@[mnr_hngr_trf_otr_desc], " ).append("\n"); 
		query.append("		@[mnr_hngr_dmg_qty], " ).append("\n"); 
		query.append("		@[act_invt_qty], " ).append("\n"); 
		query.append("		@[mnr_lost_hngr_qty], " ).append("\n"); 
		query.append("		@[mnr_disp_hngr_qty],      " ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}