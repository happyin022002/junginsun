/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.07 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agreement_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tit_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_rgst_exp_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL").append("\n"); 
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
		query.append("-- EQUIPMENT MASTER TABLE INSERT" ).append("\n"); 
		query.append("INSERT INTO CGM_EQUIPMENT" ).append("\n"); 
		query.append("(EQ_NO, EQ_KND_CD, EQ_TPSZ_CD," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO," ).append("\n"); 
		query.append("VNDR_SEQ, AGMT_LSTM_CD, ACIAC_DIV_CD," ).append("\n"); 
		query.append("ONH_DT, ONH_YD_CD, CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("CHSS_ALS_NO, N2ND_CHSS_ALS_NO, CHSS_TIT_NO," ).append("\n"); 
		query.append("CRNT_LOC_CD,CRNT_YD_CD,ONH_OFC_CD," ).append("\n"); 
		query.append("CHSS_MVMT_DT,CHSS_MVMT_STS_CD,CHSS_MVMT_DEST_YD_CD," ).append("\n"); 
		query.append("EQ_STS_SEQ,GATE_IO_CD,CHSS_OWNR_CO_CD," ).append("\n"); 
		query.append("MFT_DT,CHSS_TARE_WGT,CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("CHSS_RGST_YR,CHSS_RGST_PRD_CD,CHSS_RGST_EXP_DT,CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[eq_no], @[eq_knd_cd], @[eq_tpsz_cd]," ).append("\n"); 
		query.append("SUBSTR(@[agreement_no],0,3), SUBSTR(@[agreement_no],4,12), @[agmt_ver_no]," ).append("\n"); 
		query.append("@[vndr_seq], @[agmt_lstm_cd], 'A'," ).append("\n"); 
		query.append("TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS'), @[onh_yd_cd], @[chss_veh_id_no]," ).append("\n"); 
		query.append("@[chss_als_no], @[n2nd_chss_als_no], @[chss_tit_no]," ).append("\n"); 
		query.append("SUBSTR(@[onh_yd_cd],0,5),@[onh_yd_cd],  @[onh_ofc_cd]," ).append("\n"); 
		query.append("TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS'),  'BI' ,@[onh_yd_cd]," ).append("\n"); 
		query.append("NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0), 'I'    ,'H' ," ).append("\n"); 
		query.append("TO_DATE(@[mft_dt],'YYYY-MM-DD HH24:MI:SS'),@[chss_tare_wgt],@[chss_rgst_ste_cd]," ).append("\n"); 
		query.append("@[chss_rgst_yr],@[chss_rgst_exp_div],TO_DATE(@[chss_rgst_exp_dt],'YYYY-MM-DD HH24:MI:SS'),@[chss_rgst_lic_no]," ).append("\n"); 
		query.append("@[cre_usr_id], SYSDATE, @[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}