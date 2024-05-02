/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.17 김성욱
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

public class AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Correction시 체크박스 해제시 Rate를 삭제
	  * </pre>
	  */
	public AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_AGMT_SCG_RT A" ).append("\n"); 
		query.append("WHERE (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ, A.TRSP_AGMT_RT_TP_SER_NO, A.TRSP_AGMT_SCG_NOD_SEQ, A.TRSP_AGMT_SCG_RT_SEQ)" ).append("\n"); 
		query.append("     IN (SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, TRSP_AGMT_NOD_SEQ, TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("         FROM TRS_AGMT_TMP" ).append("\n"); 
		query.append("        WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("          AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}