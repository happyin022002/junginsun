/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyLeasedCntrMasterDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyLeasedCntrMasterDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update Leased Cntr Master Data
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyLeasedCntrMasterDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_onh_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("approval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyLeasedCntrMasterDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER SET " ).append("\n"); 
		query.append("	AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append(",	AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append(",	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(",	ONH_CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append(",	ONH_DT = TO_DATE(@[hire_date],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	ONH_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	ONH_FREE_DYS = @[free_dys]" ).append("\n"); 
		query.append(",	CNTR_MTRL_CD = @[cntr_mtrl_cd]" ).append("\n"); 
		query.append(",	CNMV_DT = TO_DATE(@[hire_date],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	PRE_STS_FLG = 'N'" ).append("\n"); 
		query.append(",	BKG_NO = NULL" ).append("\n"); 
		query.append(",	BKG_KNT = 0" ).append("\n"); 
		query.append(",	FULL_FLG = 'N'" ).append("\n"); 
		query.append(",	CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append(",	LST_STS_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	LST_STS_SEQ = @[his_seq]" ).append("\n"); 
		query.append(",	CRNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append(",	DEST_YD_CD = NULL" ).append("\n"); 
		query.append(",	VSL_CD = NULL" ).append("\n"); 
		query.append(",	SKD_VOY_NO = NULL" ).append("\n"); 
		query.append(",	SKD_DIR_CD = NULL" ).append("\n"); 
		query.append(",	CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append(",	LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append(",	MFTR_VNDR_SEQ = @[vndr_abbr_nm]" ).append("\n"); 
		query.append(",	MFT_DT = TO_DATE(@[mft_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	DMG_FLG = 'N'" ).append("\n"); 
		query.append(",	RFUB_FLG = 'N'" ).append("\n"); 
		query.append(",	DISP_FLG = 'N'" ).append("\n"); 
		query.append(",	IMDT_EXT_FLG = 'N'" ).append("\n"); 
		query.append(",	D2_PAYLD_FLG = 'N'" ).append("\n"); 
		query.append(",	TERM_CNG_SEQ = 0" ).append("\n"); 
		query.append(",	HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append(",	OWNR_CO_CD = 'H'" ).append("\n"); 
		query.append(",	CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append(",	MIN_ONH_DYS = @[min_onh_dys]" ).append("\n"); 
		query.append(",	CNTR_RMK = NULL" ).append("\n"); 
		query.append(",	CNTR_AUTH_NO = @[approval_no]" ).append("\n"); 
		query.append(",	CNTR_CURR_CD = NULL" ).append("\n"); 
		query.append(",	CNTR_AQZ_AMT = 0" ).append("\n"); 
		query.append(",	CNTR_INVST_NO = NULL" ).append("\n"); 
		query.append(",	ACCT_QTY_MZD_CD = NULL" ).append("\n"); 
		query.append(",	UCLM_LS_DIV_CD = NULL" ).append("\n"); 
		query.append(",	UCLM_DT = NULL" ).append("\n"); 
		query.append(",	UCLM_FREE_DYS = 0" ).append("\n"); 
		query.append(",	UCLM_END_DT = NULL" ).append("\n"); 
		query.append(",	UCLM_RSN = NULL" ).append("\n"); 
		query.append(",	UCLM_PLN_RMK = NULL" ).append("\n"); 
		query.append(",	UCLM_CNTC_PNT_NM = NULL" ).append("\n"); 
		query.append(",	EAI_IF_NO = NULL" ).append("\n"); 
		query.append(",	IF_TTL_ROW_KNT = 0" ).append("\n"); 
		query.append(",	IF_SEQ = 0" ).append("\n"); 
		query.append(",	FA_IF_GRP_SEQ_NO = NULL" ).append("\n"); 
		query.append(",	FA_IF_GRP_STS_CD = NULL" ).append("\n"); 
		query.append(",	FA_IF_STS_CD = NULL" ).append("\n"); 
		query.append(",	FA_IF_ERR_MSG = NULL" ).append("\n"); 
		query.append(",	FA_IF_DT = NULL" ).append("\n"); 
		query.append(",	FA_EQ_NO = NULL" ).append("\n"); 
		query.append(",	RET_APRO_NO = NULL" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",  (SCC_CD, ECC_CD, LCC_CD, RCC_CD) = (SELECT A.SCC_CD,B.ECC_CD,B.LCC_CD,B.RCC_CD " ).append("\n"); 
		query.append("                                       FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B " ).append("\n"); 
		query.append("                                       WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                                       AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   ONH_STS_SEQ = @[his_seq]" ).append("\n"); 
		query.append(",   CNTR_SPEC_NO = @[cntr_spec_no]" ).append("\n"); 
		query.append("#if (${lstm_cd} == 'LT')" ).append("\n"); 
		query.append(",   RF_TP_CD  = DECODE(SUBSTR(@[eq_tpsz_cd],1,1),'R',@[rf_tp_cd],'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}