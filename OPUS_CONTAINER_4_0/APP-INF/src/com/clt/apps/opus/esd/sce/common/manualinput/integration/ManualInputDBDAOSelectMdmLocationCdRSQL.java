/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSelectMdmLocationCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.05.02 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSelectMdmLocationCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualInputDBDAOSelectMdmLocationCd
	  * </pre>
	  */
	public ManualInputDBDAOSelectMdmLocationCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSelectMdmLocationCdRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD, SCC_CD, LOC_NM, RGN_CD, CNT_CD, STE_CD, CONTI_CD, PORT_INLND_FLG, LOC_CHR_CD, " ).append("\n"); 
		query.append("       BLK_PORT_FLG, HUB_LOC_CD, SLS_OFC_CD, LOC_GRD_NO, GMT_HRS, BKG_BL_PFX_CD, CALL_PORT_FLG, " ).append("\n"); 
		query.append("       LOC_AMS_PORT_CD, FINC_CTRL_OFC_CD, EQ_CTRL_OFC_CD, MTY_PKUP_YD_CD, EQ_RTN_YD_CD, UN_LOC_IND_CD, " ).append("\n"); 
		query.append("       UN_LOC_CD, CML_ZN_FLG, CSTMS_CD, LOC_TP_CD, BFR_FINC_CTRL_OFC_CD, BFR_EQ_CTRL_OFC_CD, BFR_SLS_OFC_CD, " ).append("\n"); 
		query.append("       BFR_OFC_CNG_DT, REP_ZN_CD, ZIP_CD, SCONTI_CD, EXPT_LGS_OFC_CD, EXPT_CUST_SVC_OFC_CD, VOP_PORT_RHQ_CD, " ).append("\n"); 
		query.append("       VOP_PORT_CTRL_OFC_CD, VOP_PORT_MNTR_FLG, VOP_LOC_URL, VOP_PORT_FLG, VOP_BNK_PORT_FLG, LOC_LOCL_LANG_NM, " ).append("\n"); 
		query.append("       LOC_LON, LON_UT_CD, EAI_IF_ID, UTC_GAP_HR_CTNT, " ).append("\n"); 
		query.append("       EAI_EVNT_DT, VSKD_PORT_RHQ_CD, LOC_LAT, LAT_UT_CD, DELT_FLG, " ).append("\n"); 
		query.append("       CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(" FROM MDM_LOCATION " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${frm_loc_cd} != '') " ).append("\n"); 
		query.append("  AND  LOC_CD = @[frm_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}