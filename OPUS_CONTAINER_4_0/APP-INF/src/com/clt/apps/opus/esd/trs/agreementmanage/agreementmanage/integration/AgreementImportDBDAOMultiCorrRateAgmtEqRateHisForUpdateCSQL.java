/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForUpdateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.24 김성욱
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

public class AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForUpdateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate History Insert
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForUpdateCSQL(){
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
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForUpdateCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_EQ_RT_HIS (" ).append("\n"); 
		query.append(" TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",EFF_FM_DT" ).append("\n"); 
		query.append(",EFF_TO_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",TRSP_RND_RT" ).append("\n"); 
		query.append(",WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append(",TO_WGT" ).append("\n"); 
		query.append(",WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",USR_DEF_RMK" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",AGMT_COST_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("      ,TRS_AGMT_EQ_RT_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("      ,A.EFF_FM_DT" ).append("\n"); 
		query.append("      ,A.EFF_TO_DT" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("      ,A.TRSP_RND_RT" ).append("\n"); 
		query.append("      ,A.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("      ,A.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_BDL_QTY" ).append("\n"); 
		query.append("      ,A.TO_WGT" ).append("\n"); 
		query.append("      ,A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,A.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.USR_DEF_RMK" ).append("\n"); 
		query.append("      ,'N' DELT_FLG" ).append("\n"); 
		query.append("      ,@[fm_account_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[fm_account_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,A.AGMT_COST_FLG" ).append("\n"); 
		query.append("  FROM TRS_AGMT_EQ_RT A, TRS_AGMT_TMP B" ).append("\n"); 
		query.append(" WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_NOD_SEQ = B.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_RT_SEQ = B.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("   AND B.ROW_NO IS NOT NULL" ).append("\n"); 

	}
}