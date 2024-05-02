/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.11.11 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
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
		query.append("INSERT INTO CGM_EQUIPMENT" ).append("\n"); 
		query.append("            (EQ_NO," ).append("\n"); 
		query.append("             EQ_KND_CD," ).append("\n"); 
		query.append("             EQ_TPSZ_CD," ).append("\n"); 
		query.append("             AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("             AGMT_SEQ," ).append("\n"); 
		query.append("             AGMT_VER_NO," ).append("\n"); 
		query.append("             VNDR_SEQ," ).append("\n"); 
		query.append("             AGMT_LSTM_CD," ).append("\n"); 
		query.append("             ACIAC_DIV_CD," ).append("\n"); 
		query.append("             ONH_DT," ).append("\n"); 
		query.append("             ONH_YD_CD," ).append("\n"); 
		query.append("             CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("             CHSS_ALS_NO," ).append("\n"); 
		query.append("             N2ND_CHSS_ALS_NO," ).append("\n"); 
		query.append("             CHSS_TIT_NO," ).append("\n"); 
		query.append("             CRNT_LOC_CD," ).append("\n"); 
		query.append("             CRNT_YD_CD," ).append("\n"); 
		query.append("             ONH_OFC_CD," ).append("\n"); 
		query.append("             CHSS_MVMT_DT," ).append("\n"); 
		query.append("             CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("             EQ_STS_SEQ," ).append("\n"); 
		query.append("             GATE_IO_CD," ).append("\n"); 
		query.append("             CHSS_OWNR_CO_CD," ).append("\n"); 
		query.append("             MFT_DT," ).append("\n"); 
		query.append("             CHSS_TARE_WGT," ).append("\n"); 
		query.append("             CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("             CHSS_RGST_YR," ).append("\n"); 
		query.append("             CHSS_RGST_PRD_CD," ).append("\n"); 
		query.append("             CHSS_RGST_EXP_DT," ).append("\n"); 
		query.append("             CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             UPD_DT)" ).append("\n"); 
		query.append("     VALUES (@[eq_no]," ).append("\n"); 
		query.append("             @[eq_knd_cd]," ).append("\n"); 
		query.append("             @[eq_tpsz_cd]," ).append("\n"); 
		query.append("             SUBSTR(@[agreement_no], 0, 3)," ).append("\n"); 
		query.append("             SUBSTR(@[agreement_no], 4, 12)," ).append("\n"); 
		query.append("             @[agmt_ver_no]," ).append("\n"); 
		query.append("             @[vndr_seq]," ).append("\n"); 
		query.append("             @[agmt_lstm_cd]," ).append("\n"); 
		query.append("             'A'," ).append("\n"); 
		query.append("             TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("             @[onh_yd_cd]," ).append("\n"); 
		query.append("             @[chss_veh_id_no]," ).append("\n"); 
		query.append("             @[chss_als_no]," ).append("\n"); 
		query.append("             @[n2nd_chss_als_no]," ).append("\n"); 
		query.append("             @[chss_tit_no]," ).append("\n"); 
		query.append("             SUBSTR(@[onh_yd_cd], 0, 5)," ).append("\n"); 
		query.append("             @[onh_yd_cd]," ).append("\n"); 
		query.append("             @[onh_ofc_cd]," ).append("\n"); 
		query.append("             TO_DATE(@[onh_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("             'BI'," ).append("\n"); 
		query.append("             NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]), 0)," ).append("\n"); 
		query.append("             'I'," ).append("\n"); 
		query.append("             'H'," ).append("\n"); 
		query.append("             TO_DATE(@[mft_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("             @[chss_tare_wgt]," ).append("\n"); 
		query.append("             @[chss_rgst_ste_cd]," ).append("\n"); 
		query.append("             @[chss_rgst_yr]," ).append("\n"); 
		query.append("             @[chss_rgst_exp_div]," ).append("\n"); 
		query.append("             TO_DATE(@[chss_rgst_exp_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("             @[chss_rgst_lic_no]," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             @[upd_usr_id]," ).append("\n"); 
		query.append("             SYSDATE)" ).append("\n"); 

	}
}