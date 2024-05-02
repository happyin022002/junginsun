/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.18 김성욱
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

public class AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Type Update
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_account_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_AGMT_RT_TP A" ).append("\n"); 
		query.append("USING ( SELECT A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("#if(${rt_gbn} == 'BZC')" ).append("\n"); 
		query.append("          FROM TRS_AGMT_EQ_RT A, TRS_AGMT_TMP B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM TRS_AGMT_SCG_RT A, TRS_AGMT_TMP B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_TP_SER_NO = B.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("#if(${rt_gbn} == 'BZC')" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_NOD_SEQ = B.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_RT_SEQ = B.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND B.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("           AND B.ROW_NO IS NOT NULL" ).append("\n"); 
		query.append("         GROUP BY A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("ON (     A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("     AND A.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("   SET UPD_USR_ID = @[fm_account_usr_id]" ).append("\n"); 
		query.append("     , UPD_OFC_CD = @[fm_account_ofc_cd]" ).append("\n"); 
		query.append("     , UPD_DT     = SYSDATE" ).append("\n"); 

	}
}