/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * ChassisMgsetAgreementDB.CheckCHSExistChgCreDataByAgreementData
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
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
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
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        COUNT(*) AS CNT" ).append("\n"); 
		query.append("    FROM  " ).append("\n"); 
		query.append("        CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND COST_YRMON >= SUBSTR(@[agmt_eff_dt],1,6)" ).append("\n"); 
		query.append("        AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("        AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("        AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#if(${action_flag} == 'V')" ).append("\n"); 
		query.append("        AND LSE_CHG_STS_CD <> 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        COUNT(*) AS CNT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        CGM_PAY_INV" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND COST_YRMON >= SUBSTR(@[agmt_eff_dt],1,6)" ).append("\n"); 
		query.append("        AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("        AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("        AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#if(${action_flag} == 'V')" ).append("\n"); 
		query.append("        AND CHSS_MGST_INV_STS_CD <> 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}