/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchMstContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchMstContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container 별 mst_container 의 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchMstContainerRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchMstContainerRSQL").append("\n"); 
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
		query.append("SELECT 	ONH_STS_SEQ, " ).append("\n"); 
		query.append("	MNR_HNGR_BAR_TP_CD, " ).append("\n"); 
		query.append("	CNTR_SPEC_NO, " ).append("\n"); 
		query.append("	CNTR_NO, " ).append("\n"); 
		query.append("	SYS_AREA_GRP_ID, " ).append("\n"); 
		query.append("	AGMT_CTY_CD, " ).append("\n"); 
		query.append("	AGMT_SEQ, " ).append("\n"); 
		query.append("	VNDR_SEQ, " ).append("\n"); 
		query.append("	ONH_CNTR_STS_CD, " ).append("\n"); 
		query.append("	TO_CHAR(ONH_DT, 'YYYYMMDDHH24MISS') AS ONH_DT, " ).append("\n"); 
		query.append("	ONH_YD_CD, " ).append("\n"); 
		query.append("	ONH_FREE_DYS, " ).append("\n"); 
		query.append("	CNTR_MTRL_CD, " ).append("\n"); 
		query.append("	CNMV_YR, " ).append("\n"); 
		query.append("	CNMV_ID_NO, " ).append("\n"); 
		query.append("	CNMV_SEQ, " ).append("\n"); 
		query.append("	CNMV_SPLIT_NO, " ).append("\n"); 
		query.append("	CNMV_CYC_NO, " ).append("\n"); 
		query.append("	TO_CHAR(CNMV_DT, 'YYYYMMDDHH24MISS') AS CNMV_DT, " ).append("\n"); 
		query.append("	TO_CHAR(CNMV_GDT, 'YYYYMMDDHH24MISS') AS CNMV_GDT, " ).append("\n"); 
		query.append("	PRE_STS_FLG, " ).append("\n"); 
		query.append("	BKG_NO, " ).append("\n"); 
		query.append("	BKG_KNT, " ).append("\n"); 
		query.append("	FULL_FLG, " ).append("\n"); 
		query.append("	CNTR_STS_CD, " ).append("\n"); 
		query.append("	LST_STS_YD_CD, " ).append("\n"); 
		query.append("	LST_STS_SEQ, " ).append("\n"); 
		query.append("	CRNT_YD_CD, " ).append("\n"); 
		query.append("	LOC_CD, " ).append("\n"); 
		query.append("	SCC_CD, " ).append("\n"); 
		query.append("	LCC_CD, " ).append("\n"); 
		query.append("	ECC_CD, " ).append("\n"); 
		query.append("	RCC_CD, " ).append("\n"); 
		query.append("	DEST_YD_CD, " ).append("\n"); 
		query.append("	VSL_CD, " ).append("\n"); 
		query.append("	SKD_VOY_NO, " ).append("\n"); 
		query.append("	SKD_DIR_CD, " ).append("\n"); 
		query.append("	CNMV_STS_CD, " ).append("\n"); 
		query.append("	ACIAC_DIV_CD, " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	LSTM_CD, " ).append("\n"); 
		query.append("	MFTR_VNDR_SEQ, " ).append("\n"); 
		query.append("	TO_CHAR(MFT_DT, 'YYYYMMDDHH24MISS') AS MFT_DT, " ).append("\n"); 
		query.append("	CNTR_HNGR_BAR_ATCH_KNT, " ).append("\n"); 
		query.append("	CNTR_HNGR_RCK_CD, " ).append("\n"); 
		query.append("	DMG_FLG, " ).append("\n"); 
		query.append("	RFUB_FLG, " ).append("\n"); 
		query.append("	TO_CHAR(RFUB_DT, 'YYYYMMDDHH24MISS') AS RFUB_DT, " ).append("\n"); 
		query.append("	DISP_FLG, " ).append("\n"); 
		query.append("	IMDT_EXT_FLG, " ).append("\n"); 
		query.append("	D2_PAYLD_FLG, " ).append("\n"); 
		query.append("	TERM_CNG_SEQ, " ).append("\n"); 
		query.append("	PLST_FLR_FLG, " ).append("\n"); 
		query.append("	CO_CRE_FLG, " ).append("\n"); 
		query.append("	OWNR_CO_CD, " ).append("\n"); 
		query.append("	CNTR_USE_CO_CD, " ).append("\n"); 
		query.append("	RF_TP_CD, " ).append("\n"); 
		query.append("	MIN_ONH_DYS, " ).append("\n"); 
		query.append("	CNTR_RMK, " ).append("\n"); 
		query.append("	CNTR_AUTH_NO, " ).append("\n"); 
		query.append("	CNTR_CURR_CD, " ).append("\n"); 
		query.append("	CNTR_AQZ_AMT, " ).append("\n"); 
		query.append("	CNTR_INVST_NO, " ).append("\n"); 
		query.append("	ACCT_QTY_MZD_CD, " ).append("\n"); 
		query.append("	UCLM_LS_DIV_CD, " ).append("\n"); 
		query.append("	TO_CHAR(UCLM_DT, 'YYYYMMDDHH24MISS') AS UCLM_DT, " ).append("\n"); 
		query.append("	UCLM_FREE_DYS, " ).append("\n"); 
		query.append("	TO_CHAR(UCLM_END_DT, 'YYYYMMDDHH24MISS') AS UCLM_END_DT, " ).append("\n"); 
		query.append("	UCLM_RSN, " ).append("\n"); 
		query.append("	UCLM_PLN_RMK, " ).append("\n"); 
		query.append("	UCLM_CNTC_PNT_NM, " ).append("\n"); 
		query.append("	EAI_IF_NO, " ).append("\n"); 
		query.append("	IF_TTL_ROW_KNT, " ).append("\n"); 
		query.append("	IF_SEQ, " ).append("\n"); 
		query.append("	FA_IF_GRP_SEQ_NO, " ).append("\n"); 
		query.append("	FA_IF_GRP_STS_CD, " ).append("\n"); 
		query.append("	FA_IF_TP_CD, " ).append("\n"); 
		query.append("	FA_IF_STS_CD, " ).append("\n"); 
		query.append("	FA_IF_ERR_MSG, " ).append("\n"); 
		query.append("	TO_CHAR(FA_IF_DT, 'YYYYMMDDHH24MISS') AS FA_IF_DT, " ).append("\n"); 
		query.append("	FA_EQ_NO, " ).append("\n"); 
		query.append("	RET_APRO_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	MST_CONTAINER" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}