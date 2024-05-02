/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetPrevCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetPrevCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetPrevCntrInfoRSQL(){
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
		query.append("Path : package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetPrevCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC (CTM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("CTM.CNTR_NO," ).append("\n"); 
		query.append("CTM.CNMV_YR," ).append("\n"); 
		query.append("CTM.CNMV_ID_NO," ).append("\n"); 
		query.append("CTM.CNMV_SEQ," ).append("\n"); 
		query.append("CTM.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("CTM.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CTM.MVMT_STS_CD," ).append("\n"); 
		query.append("CTM.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("CTM.CNMV_CYC_NO," ).append("\n"); 
		query.append("CTM.CNMV_LVL_NO," ).append("\n"); 
		query.append("TO_CHAR(CTM.CNMV_EVNT_DT, 'YYYYMMDDHH24MISS') CNMV_EVNT_DT," ).append("\n"); 
		query.append("CTM.DEST_YD_CD," ).append("\n"); 
		query.append("CTM.INP_YD_CD," ).append("\n"); 
		query.append("CTM.ORG_YD_CD," ).append("\n"); 
		query.append("CTM.CRNT_VSL_CD," ).append("\n"); 
		query.append("CTM.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("CTM.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("CTM.TRNK_VSL_CD," ).append("\n"); 
		query.append("CTM.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("CTM.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("CTM.CHSS_NO," ).append("\n"); 
		query.append("CTM.MGST_NO," ).append("\n"); 
		query.append("CTM.CNTR_SEAL_NO," ).append("\n"); 
		query.append("CTM.CNTR_DMG_FLG," ).append("\n"); 
		query.append("CTM.FCNTR_FLG," ).append("\n"); 
		query.append("CTM.OB_CNTR_FLG," ).append("\n"); 
		query.append("CTM.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("CTM.VNDR_SEQ," ).append("\n"); 
		query.append("CTM.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("CTM.LOC_CD," ).append("\n"); 
		query.append("CTM.CNMV_RMK," ).append("\n"); 
		query.append("CTM.USR_NM," ).append("\n"); 
		query.append("CTM.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("CTM.SUBST_RULE_CD," ).append("\n"); 
		query.append("CTM.SPCL_CGO_FLG," ).append("\n"); 
		query.append("CTM.BKG_NO," ).append("\n"); 
		query.append("CTM.BKG_KNT," ).append("\n"); 
		query.append("CTM.BL_NO," ).append("\n"); 
		query.append("CTM.CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("CTM.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("CTM.CNTR_ACT_CD," ).append("\n"); 
		query.append("CTM.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("CTM.CNTR_DISP_FLG," ).append("\n"); 
		query.append("CTM.IMDT_EXT_FLG," ).append("\n"); 
		query.append("CTM.CNTR_XCH_CD," ).append("\n"); 
		query.append("CTM.INLND_TRSP_LIC_NO," ).append("\n"); 
		query.append("CTM.CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("CTM.CTRT_SEQ," ).append("\n"); 
		query.append("CTM.MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("CTM.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("CTM.MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("CTM.MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("CTM.MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("CTM.WBL_NO," ).append("\n"); 
		query.append("CTM.PKUP_NO," ).append("\n"); 
		query.append("CTM.CNTR_STS_SEQ," ).append("\n"); 
		query.append("CTM.CALL_SGN_NO," ).append("\n"); 
		query.append("CTM.LLOYD_NO," ).append("\n"); 
		query.append("CTM.MTY_REPO_VL_RMK," ).append("\n"); 
		query.append("CTM.MVMT_INP_TP_CD," ).append("\n"); 
		query.append("CTM.CNMV_CO_CD," ).append("\n"); 
		query.append("CTM.SYS_AREA_GRP_ID AS CNTR_SVR_ID," ).append("\n"); 
		query.append("CTM.OFC_CD," ).append("\n"); 
		query.append("CTM.PRE_STS_FLG," ).append("\n"); 
		query.append("CTM.GMT_DT," ).append("\n"); 
		query.append("CTM.CRE_LOCL_DT," ).append("\n"); 
		query.append("CTM.UPD_LOCL_DT," ).append("\n"); 
		query.append("CTM.CRE_USR_ID," ).append("\n"); 
		query.append("CTM.CRE_DT," ).append("\n"); 
		query.append("CTM.UPD_USR_ID," ).append("\n"); 
		query.append("CTM.UPD_DT," ).append("\n"); 
		query.append("MST.LSTM_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CTM, MST_CONTAINER MST" ).append("\n"); 
		query.append("WHERE CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND  CTM.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM <= ${ord}" ).append("\n"); 

	}
}