/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementImportDBDAODummyAgmtRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.20
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.09.20 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAODummyAgmtRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT Rate Insert/Verify를 위한 VO생성용 DUMMY SQL
	  * </pre>
	  */
	public AgreementImportDBDAODummyAgmtRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAODummyAgmtRateRSQL").append("\n"); 
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
		query.append("'' CHK" ).append("\n"); 
		query.append(",'' RLT" ).append("\n"); 
		query.append(",'' TRSP_COST_MOD_CD" ).append("\n"); 
		query.append(",'' AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append(",'' CGO_TP_CD" ).append("\n"); 
		query.append(",'' CUST_CD" ).append("\n"); 
		query.append(",'' CMDT_GRP_CD" ).append("\n"); 
		query.append(",'' RAIL_SVC_TP_CD" ).append("\n"); 
		query.append(",'' FM_NOD_CD" ).append("\n"); 
		query.append(",'' FM_NOD_YD" ).append("\n"); 
		query.append(",'' VIA_NOD_CD" ).append("\n"); 
		query.append(",'' VIA_NOD_YD" ).append("\n"); 
		query.append(",'' DOR_NOD_CD" ).append("\n"); 
		query.append(",'' DOR_NOD_YD" ).append("\n"); 
		query.append(",'' TO_NOD_CD" ).append("\n"); 
		query.append(",'' TO_NOD_YD" ).append("\n"); 
		query.append(",'' TRSP_DIST_TP_CD" ).append("\n"); 
		query.append(",'' TRSP_AGMT_DIST" ).append("\n"); 
		query.append(",'' DIST_MEAS_UT_CD" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' EQ_D2" ).append("\n"); 
		query.append(",'' EQ_D3" ).append("\n"); 
		query.append(",'' EQ_D4" ).append("\n"); 
		query.append(",'' EQ_D5" ).append("\n"); 
		query.append(",'' EQ_D7" ).append("\n"); 
		query.append(",'' EQ_D8" ).append("\n"); 
		query.append(",'' EQ_D9" ).append("\n"); 
		query.append(",'' EQ_DW" ).append("\n"); 
		query.append(",'' EQ_DX" ).append("\n"); 
		query.append(",'' EQ_R2" ).append("\n"); 
		query.append(",'' EQ_R4" ).append("\n"); 
		query.append(",'' EQ_R5" ).append("\n"); 
		query.append(",'' EQ_R7" ).append("\n"); 
		query.append(",'' EQ_R9" ).append("\n"); 
		query.append(",'' EQ_A2" ).append("\n"); 
		query.append(",'' EQ_A4" ).append("\n"); 
		query.append(",'' EQ_F2" ).append("\n"); 
		query.append(",'' EQ_F4" ).append("\n"); 
		query.append(",'' EQ_F5" ).append("\n"); 
		query.append(",'' EQ_T2" ).append("\n"); 
		query.append(",'' EQ_T4" ).append("\n"); 
		query.append(",'' EQ_S2" ).append("\n"); 
		query.append(",'' EQ_S4" ).append("\n"); 
		query.append(",'' EQ_O2" ).append("\n"); 
		query.append(",'' EQ_O4" ).append("\n"); 
		query.append(",'' EQ_P2" ).append("\n"); 
		query.append(",'' EQ_P4" ).append("\n"); 
		query.append(",'' EQ_SF2" ).append("\n"); 
		query.append(",'' EQ_SF4" ).append("\n"); 
		query.append(",'' EQ_SL2" ).append("\n"); 
		query.append(",'' EQ_TA2" ).append("\n"); 
		query.append(",'' EQ_GN4" ).append("\n"); 
		query.append(",'' EQ_GN5" ).append("\n"); 
		query.append(",'' EQ_EG5" ).append("\n"); 
		query.append(",'' EQ_EG8" ).append("\n"); 
		query.append(",'' EQ_ZT4" ).append("\n"); 
		query.append(",'' EQ_CB4" ).append("\n"); 
		query.append(",'' EQ_CG" ).append("\n"); 
		query.append(",'' EQ_UG" ).append("\n"); 
		query.append(",'' EQ_ALAL" ).append("\n"); 
		query.append(",'' EQ_DAL" ).append("\n"); 
		query.append(",'' EQ_RAL" ).append("\n"); 
		query.append(",'' EQ_AAL" ).append("\n"); 
		query.append(",'' EQ_FAL" ).append("\n"); 
		query.append(",'' EQ_TAL" ).append("\n"); 
		query.append(",'' EQ_SAL" ).append("\n"); 
		query.append(",'' EQ_OAL" ).append("\n"); 
		query.append(",'' EQ_PAL" ).append("\n"); 
		query.append(",'' EQ_AL2" ).append("\n"); 
		query.append(",'' EQ_AL4" ).append("\n"); 
		query.append(",'' EQ_AL5" ).append("\n"); 
		query.append(",'' EQ_AL7" ).append("\n"); 
		query.append(",'' EQ_AL8" ).append("\n"); 
		query.append(",'' EQ_AL9" ).append("\n"); 
		query.append(",'' EQ_SFAL" ).append("\n"); 
		query.append(",'' EQ_SLAL" ).append("\n"); 
		query.append(",'' EQ_TAAL" ).append("\n"); 
		query.append(",'' EQ_GNAL" ).append("\n"); 
		query.append(",'' EQ_EGAL" ).append("\n"); 
		query.append(",'' TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",'' TRSP_RND_RT" ).append("\n"); 
		query.append(",'' WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",'' WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",'' TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append(",'' TO_WGT" ).append("\n"); 
		query.append(",'' WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",'' TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append(",'' TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",'' TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",'' TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(",'' EFF_FM_DT" ).append("\n"); 
		query.append(",'' EFF_TO_DT" ).append("\n"); 
		query.append(",'' CK_VF" ).append("\n"); 
		query.append(",'' EQ_KND_CD" ).append("\n"); 
		query.append(",'' TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append(",'' TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append(",'' ROWNO" ).append("\n"); 
		query.append(",'' CHK_ROWNO" ).append("\n"); 
		query.append(",'' TRSP_SCG_CD" ).append("\n"); 
		query.append(",'' AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append(",'' DELT_FLG" ).append("\n"); 
		query.append(",'' ORG_EQTYPE" ).append("\n"); 
		query.append(",'' ORG_TRSP_AGMT_EQ_TP_CD" ).append("\n"); 
		query.append(",'' ORG_TRSP_AGMT_EQ_SZ_CD" ).append("\n"); 
		query.append(",'' UI_SEQNO" ).append("\n"); 
		query.append(",'' AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}