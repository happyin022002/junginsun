/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate 수정
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_AGMT_SCG_RT A" ).append("\n"); 
		query.append("USING (SELECT A.EFF_FM_DT, A.EFF_TO_DT, A.CURR_CD, A.TRSP_ONE_WY_RT, A.TRSP_RND_RT, " ).append("\n"); 
		query.append("              A.TRSP_AGMT_EQ_TP_SZ_CD, A.AGMT_SCG_RT_DIV_CD, A.COM_SCG_APLY_FLG, A.WO_APLY_FLG, " ).append("\n"); 
		query.append("			  A.TO_WGT, A.WGT_MEAS_UT_CD, A.EQ_KND_CD, A.USR_DEF_RMK, A.UPD_USR_ID, A.UPD_DT," ).append("\n"); 
		query.append("              A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.TRSP_AGMT_RT_TP_SER_NO, A.TRSP_AGMT_SCG_NOD_SEQ, A.TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("              B.EFF_FM_DT AS EFF_FM_DT_TMP, " ).append("\n"); 
		query.append("              B.EFF_TO_DT AS EFF_TO_DT_TMP, " ).append("\n"); 
		query.append("              B.CURR_CD AS CURR_CD_TMP, " ).append("\n"); 
		query.append("              B.TRSP_ONE_WY_RT AS TRSP_ONE_WY_RT_TMP, " ).append("\n"); 
		query.append("              B.TRSP_RND_RT AS TRSP_RND_RT_TMP, " ).append("\n"); 
		query.append("              NVL(B.TRSP_AGMT_EQ_TP_CD, 'XX') || NVL(B.TRSP_AGMT_EQ_SZ_CD, '') AS TRSP_AGMT_EQ_TP_SZ_CD_TMP, " ).append("\n"); 
		query.append("              B.AGMT_SCG_RT_DIV_CD AS AGMT_SCG_RT_DIV_CD_TMP, " ).append("\n"); 
		query.append("              B.COM_SCG_APLY_FLG AS COM_SCG_APLY_FLG_TMP, " ).append("\n"); 
		query.append("              B.TO_WGT AS TO_WGT_TMP, " ).append("\n"); 
		query.append("              B.WGT_MEAS_UT_CD AS WGT_MEAS_UT_CD_TMP, " ).append("\n"); 
		query.append("              B.WO_APLY_FLG AS WO_APLY_FLG_TMP, " ).append("\n"); 
		query.append("              B.EQ_KND_CD AS EQ_KND_CD_TMP, " ).append("\n"); 
		query.append("              B.AFT_USR_DEF_RMK AS USR_DEF_RMK_TMP," ).append("\n"); 
		query.append("              B.AGMT_COST_FLG AS AGMT_COST_FLG_TMP" ).append("\n"); 
		query.append("          FROM TRS_AGMT_SCG_RT A, TRS_AGMT_TMP B" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SCG_NOD_SEQ = B.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SCG_RT_SEQ = B.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("           AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("           AND B.ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("ON (    A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("    AND A.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("    AND A.TRSP_AGMT_SCG_NOD_SEQ = C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("    AND A.TRSP_AGMT_SCG_RT_SEQ = C.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("   SET EFF_FM_DT     = EFF_FM_DT_TMP" ).append("\n"); 
		query.append("      ,EFF_TO_DT         = EFF_TO_DT_TMP" ).append("\n"); 
		query.append("      ,TO_WGT            = TO_WGT_TMP" ).append("\n"); 
		query.append("      ,WGT_MEAS_UT_CD    = WGT_MEAS_UT_CD_TMP" ).append("\n"); 
		query.append("      ,CURR_CD           = CURR_CD_TMP" ).append("\n"); 
		query.append("      ,TRSP_ONE_WY_RT    = TRSP_ONE_WY_RT_TMP" ).append("\n"); 
		query.append("      ,TRSP_RND_RT       = TRSP_RND_RT_TMP" ).append("\n"); 
		query.append("	  ,TRSP_AGMT_EQ_TP_SZ_CD = TRSP_AGMT_EQ_TP_SZ_CD_TMP" ).append("\n"); 
		query.append("      ,EQ_KND_CD         = EQ_KND_CD_TMP" ).append("\n"); 
		query.append("      ,USR_DEF_RMK       = USR_DEF_RMK_TMP" ).append("\n"); 
		query.append("      ,AGMT_SCG_RT_DIV_CD   = AGMT_SCG_RT_DIV_CD_TMP" ).append("\n"); 
		query.append("      ,COM_SCG_APLY_FLG    = COM_SCG_APLY_FLG_TMP" ).append("\n"); 
		query.append("      ,WO_APLY_FLG = WO_APLY_FLG_TMP" ).append("\n"); 
		query.append("      ,UPD_USR_ID        = @[fm_account_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("      ,AGMT_COST_FLG     = AGMT_COST_FLG_TMP" ).append("\n"); 

	}
}