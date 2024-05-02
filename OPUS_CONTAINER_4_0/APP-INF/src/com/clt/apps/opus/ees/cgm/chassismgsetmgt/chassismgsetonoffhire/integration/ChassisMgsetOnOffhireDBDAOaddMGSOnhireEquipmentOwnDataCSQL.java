/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOaddMGSOnhireEquipmentOwnDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.02.16 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

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

public class ChassisMgsetOnOffhireDBDAOaddMGSOnhireEquipmentOwnDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOaddMGSOnhireEquipmentOwnDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mgst_mchn_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mgst_vltg_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mgst_fuel_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOaddMGSOnhireEquipmentOwnDataCSQL").append("\n"); 
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
		query.append("             MFT_DT," ).append("\n"); 
		query.append("             AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("             AGMT_SEQ," ).append("\n"); 
		query.append("             AGMT_VER_NO," ).append("\n"); 
		query.append("             VNDR_SEQ," ).append("\n"); 
		query.append("             AGMT_LSTM_CD," ).append("\n"); 
		query.append("             ACIAC_DIV_CD," ).append("\n"); 
		query.append("             ONH_DT," ).append("\n"); 
		query.append("             ONH_YD_CD," ).append("\n"); 
		query.append("             CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("             EQ_SPEC_NO," ).append("\n"); 
		query.append("             MGST_MCHN_SER_NO," ).append("\n"); 
		query.append("             MGST_VLTG_CAPA," ).append("\n"); 
		query.append("             MGST_FUEL_CAPA," ).append("\n"); 
		query.append("             ONH_OFC_CD," ).append("\n"); 
		query.append("             CRNT_YD_CD," ).append("\n"); 
		query.append("             CRNT_LOC_CD," ).append("\n"); 
		query.append("             EQ_STS_SEQ," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             UPD_DT)" ).append("\n"); 
		query.append("     VALUES (@[eq_no]," ).append("\n"); 
		query.append("             @[eq_knd_cd]," ).append("\n"); 
		query.append("             @[eq_tpsz_cd]," ).append("\n"); 
		query.append("             TO_DATE(@[mft_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("             SUBSTR(@[agreement_no], 0, 3)," ).append("\n"); 
		query.append("             SUBSTR(@[agreement_no], 4, 12)," ).append("\n"); 
		query.append("             @[agmt_ver_no]," ).append("\n"); 
		query.append("             @[vndr_seq]," ).append("\n"); 
		query.append("             @[agmt_lstm_cd]," ).append("\n"); 
		query.append("             'A'," ).append("\n"); 
		query.append("             TO_DATE(@[onh_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("             @[onh_yd_cd]," ).append("\n"); 
		query.append("             @[chss_veh_id_no]," ).append("\n"); 
		query.append("             @[eq_spec_no]," ).append("\n"); 
		query.append("             @[mgst_mchn_ser_no]," ).append("\n"); 
		query.append("             @[mgst_vltg_capa]," ).append("\n"); 
		query.append("             @[mgst_fuel_capa]," ).append("\n"); 
		query.append("             @[onh_ofc_cd]," ).append("\n"); 
		query.append("             @[onh_yd_cd]," ).append("\n"); 
		query.append("             SUBSTR(@[onh_yd_cd], 0, 5)," ).append("\n"); 
		query.append("             NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]), 0)," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             @[upd_usr_id]," ).append("\n"); 
		query.append("             SYSDATE)" ).append("\n"); 

	}
}