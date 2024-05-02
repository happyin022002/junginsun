/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOGetMovementInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOGetMovementInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 이동 정보를 얻어온다.
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOGetMovementInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOGetMovementInfoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CNMV_SEQ," ).append("\n"); 
		query.append("CNMV_SPLIT_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MVMT_STS_CD," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("CNMV_LVL_NO," ).append("\n"); 
		query.append("TO_CHAR (CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("INP_YD_CD," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("CRNT_VSL_CD," ).append("\n"); 
		query.append("CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("CHSS_NO," ).append("\n"); 
		query.append("MGST_NO," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("CNTR_DMG_FLG," ).append("\n"); 
		query.append("FCNTR_FLG," ).append("\n"); 
		query.append("OB_CNTR_FLG," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("LOC_CD," ).append("\n"); 
		query.append("CNMV_RMK," ).append("\n"); 
		query.append("USR_NM," ).append("\n"); 
		query.append("MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("SUBST_RULE_CD," ).append("\n"); 
		query.append("SPCL_CGO_FLG," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("BKG_KNT," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("CNTR_ACT_CD," ).append("\n"); 
		query.append("CNTR_RFUB_FLG," ).append("\n"); 
		query.append("CNTR_DISP_FLG," ).append("\n"); 
		query.append("IMDT_EXT_FLG," ).append("\n"); 
		query.append("CNTR_XCH_CD," ).append("\n"); 
		query.append("INLND_TRSP_LIC_NO," ).append("\n"); 
		query.append("CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("CTRT_SEQ," ).append("\n"); 
		query.append("MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("WBL_NO," ).append("\n"); 
		query.append("PKUP_NO," ).append("\n"); 
		query.append("CNTR_STS_SEQ," ).append("\n"); 
		query.append("CALL_SGN_NO," ).append("\n"); 
		query.append("LLOYD_NO," ).append("\n"); 
		query.append("MTY_REPO_VL_RMK," ).append("\n"); 
		query.append("MVMT_INP_TP_CD," ).append("\n"); 
		query.append("CNMV_CO_CD," ).append("\n"); 
		query.append("SYS_AREA_GRP_ID AS CNTR_SVR_ID," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("PRE_STS_FLG" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 

	}
}