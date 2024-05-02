/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSOnhireEquipmentDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.17 최민회
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

public class ChassisMgsetOnOffhireDBDAOmodifyCHSOnhireEquipmentDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyCHSOnhireEquipmentDataUSQL(){
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
		params.put("chss_rgst_exp_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSOnhireEquipmentDataUSQL").append("\n"); 
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
		query.append("-- EQUIPMENT TABLE UPDATE" ).append("\n"); 
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append("SET ONH_OFC_CD       = @[onh_ofc_cd]," ).append("\n"); 
		query.append("ONH_DT           = TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("CHSS_MVMT_DT     = TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("ONH_YD_CD        = @[onh_yd_cd]," ).append("\n"); 
		query.append("CRNT_YD_CD       = @[onh_yd_cd]," ).append("\n"); 
		query.append("CHSS_VEH_ID_NO   = @[chss_veh_id_no]," ).append("\n"); 
		query.append("CHSS_ALS_NO      = @[chss_als_no]," ).append("\n"); 
		query.append("N2ND_CHSS_ALS_NO = @[n2nd_chss_als_no]," ).append("\n"); 
		query.append("CHSS_TIT_NO      = @[chss_tit_no]," ).append("\n"); 
		query.append("EQ_STS_SEQ       = NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0)," ).append("\n"); 
		query.append("CRNT_LOC_CD      = SUBSTR(@[onh_yd_cd],0,5)," ).append("\n"); 
		query.append("ACIAC_DIV_CD     = 'A'," ).append("\n"); 
		query.append("VNDR_SEQ         = @[vndr_seq]," ).append("\n"); 
		query.append("AGMT_LSTM_CD     = @[agmt_lstm_cd]," ).append("\n"); 
		query.append("CHSS_MVMT_DEST_YD_CD = @[onh_yd_cd]," ).append("\n"); 
		query.append("CHSS_MVMT_STS_CD = DECODE(@[eq_knd_cd],'Z','BI',NULL)," ).append("\n"); 
		query.append("GATE_IO_CD       = DECODE(@[eq_knd_cd],'Z','I',NULL)," ).append("\n"); 
		query.append("CHSS_OWNR_CO_CD  = DECODE(@[eq_knd_cd],'Z','H',NULL)," ).append("\n"); 
		query.append("MFT_DT           = TO_DATE(@[mft_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("CHSS_TARE_WGT    = @[chss_tare_wgt]," ).append("\n"); 
		query.append("CHSS_RGST_STE_CD = @[chss_rgst_ste_cd]," ).append("\n"); 
		query.append("CHSS_RGST_YR     = @[chss_rgst_yr]," ).append("\n"); 
		query.append("CHSS_RGST_PRD_CD = @[chss_rgst_exp_div]," ).append("\n"); 
		query.append("CHSS_RGST_EXP_DT = TO_DATE(@[chss_rgst_exp_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("CHSS_RGST_LIC_NO = @[chss_rgst_lic_no]," ).append("\n"); 
		query.append("EQ_KND_CD        = @[eq_knd_cd]," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD  = SUBSTR(@[agreement_no],0,3)," ).append("\n"); 
		query.append("AGMT_SEQ         = SUBSTR(@[agreement_no],4,12)," ).append("\n"); 
		query.append("AGMT_VER_NO      = @[agmt_ver_no]," ).append("\n"); 
		query.append("EQ_TPSZ_CD       = @[eq_tpsz_cd]," ).append("\n"); 
		query.append("UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE EQ_NO =@[eq_no]" ).append("\n"); 

	}
}