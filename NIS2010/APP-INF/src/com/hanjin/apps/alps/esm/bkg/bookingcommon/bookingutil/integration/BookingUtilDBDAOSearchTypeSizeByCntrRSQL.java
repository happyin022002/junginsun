/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchTypeSizeByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.01 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchTypeSizeByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container별 TypeSize조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchTypeSizeByCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchTypeSizeByCntrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISP_FLG" ).append("\n"); 
		query.append(",	IMDT_EXT_FLG" ).append("\n"); 
		query.append(",	D2_PAYLD_FLG" ).append("\n"); 
		query.append(",	TERM_CNG_SEQ" ).append("\n"); 
		query.append(",	PLST_FLR_FLG" ).append("\n"); 
		query.append(",	HJS_CRE_FLG" ).append("\n"); 
		query.append(",	OWNR_CO_CD" ).append("\n"); 
		query.append(",	CNTR_USE_CO_CD" ).append("\n"); 
		query.append(",	RF_TP_CD" ).append("\n"); 
		query.append(",	MIN_ONH_DYS" ).append("\n"); 
		query.append(",	CNTR_RMK" ).append("\n"); 
		query.append(",	CNTR_AUTH_NO" ).append("\n"); 
		query.append(",	CNTR_CURR_CD" ).append("\n"); 
		query.append(",	CNTR_AQZ_AMT" ).append("\n"); 
		query.append(",	CNTR_INVST_NO" ).append("\n"); 
		query.append(",	ACCT_QTY_MZD_CD" ).append("\n"); 
		query.append(",	UCLM_LS_DIV_CD" ).append("\n"); 
		query.append(",	UCLM_DT" ).append("\n"); 
		query.append(",	UCLM_FREE_DYS" ).append("\n"); 
		query.append(",	UCLM_END_DT" ).append("\n"); 
		query.append(",	UCLM_RSN" ).append("\n"); 
		query.append(",	UCLM_PLN_RMK" ).append("\n"); 
		query.append(",	UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append(",	EAI_IF_NO" ).append("\n"); 
		query.append(",	IF_TTL_ROW_KNT" ).append("\n"); 
		query.append(",	IF_SEQ" ).append("\n"); 
		query.append(",	FA_IF_GRP_SEQ_NO" ).append("\n"); 
		query.append(",	FA_IF_GRP_STS_CD" ).append("\n"); 
		query.append(",	FA_IF_TP_CD" ).append("\n"); 
		query.append(",	FA_IF_STS_CD" ).append("\n"); 
		query.append(",	FA_IF_ERR_MSG" ).append("\n"); 
		query.append(",	FA_IF_DT" ).append("\n"); 
		query.append(",	FA_EQ_NO" ).append("\n"); 
		query.append(",	RET_APRO_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append(",	AGMT_CTY_CD" ).append("\n"); 
		query.append(",	AGMT_SEQ" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	ONH_CNTR_STS_CD" ).append("\n"); 
		query.append(",	ONH_DT" ).append("\n"); 
		query.append(",	ONH_YD_CD" ).append("\n"); 
		query.append(",	ONH_FREE_DYS" ).append("\n"); 
		query.append(",	CNTR_MTRL_CD" ).append("\n"); 
		query.append(",	CNMV_YR" ).append("\n"); 
		query.append(",	CNMV_ID_NO" ).append("\n"); 
		query.append(",	CNMV_SEQ" ).append("\n"); 
		query.append(",	CNMV_SPLIT_NO" ).append("\n"); 
		query.append(",	CNMV_CYC_NO" ).append("\n"); 
		query.append(",	CNMV_DT" ).append("\n"); 
		query.append("--,	CNMV_GMT_DT" ).append("\n"); 
		query.append(",	PRE_STS_FLG" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BKG_KNT" ).append("\n"); 
		query.append(",	FULL_FLG" ).append("\n"); 
		query.append(",	CNTR_STS_CD" ).append("\n"); 
		query.append(",	LST_STS_YD_CD" ).append("\n"); 
		query.append(",	LST_STS_SEQ" ).append("\n"); 
		query.append(",	CRNT_YD_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	SCC_CD" ).append("\n"); 
		query.append(",	LCC_CD" ).append("\n"); 
		query.append(",	ECC_CD" ).append("\n"); 
		query.append(",	RCC_CD" ).append("\n"); 
		query.append(",	DEST_YD_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	CNMV_STS_CD" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	LSTM_CD" ).append("\n"); 
		query.append(",	MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(",	MFT_DT" ).append("\n"); 
		query.append(",	CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",	CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",	DMG_FLG" ).append("\n"); 
		query.append(",	RFUB_FLG" ).append("\n"); 
		query.append(",	RFUB_DT" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("#if(${length}=='10')" ).append("\n"); 
		query.append("WHERE	CNTR_NO like @[cntr_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}