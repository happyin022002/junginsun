/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.06.17 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Justin(Jonghee) HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------
	  * ChassisMgsetAgreementDB.CheckCHSExistChgCreDataByAgreementData
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430737, TITLE : ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
	  *                  MODIFIED CHECK LOGIC FOR USING AGREEMENT
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT) AS CNT" ).append("\n"); 
		query.append("  FROM (SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("          FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("         WHERE EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("            AND COST_YRMON >= SUBSTR(@[eff_dt],1,6)" ).append("\n"); 
		query.append("            AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("            AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("          FROM CGM_PAY_INV A, CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("         WHERE A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("          FROM CGM_PAY_INV A, CGM_PAY_INV_POOL_DTL B" ).append("\n"); 
		query.append("         WHERE A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND A.AGMT_SEQ = @[agmt_seq])" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}