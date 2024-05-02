/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOCheckCHSAgreementPoolMatchDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.04 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOCheckCHSAgreementPoolMatchDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.CheckCHSAgreementPoolMatchData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOCheckCHSAgreementPoolMatchDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOCheckCHSAgreementPoolMatchDataRSQL").append("\n"); 
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
		query.append("SELECT AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("WHERE (AGMT_OFC_CTY_CD != @[agmt_ofc_cty_cd] OR AGMT_SEQ != @[agmt_seq])" ).append("\n"); 
		query.append("	  AND AGMT_LSTM_CD != 'ZP'" ).append("\n"); 
		query.append("      AND CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("      AND DELT_FLG = 'N'" ).append("\n"); 

	}
}