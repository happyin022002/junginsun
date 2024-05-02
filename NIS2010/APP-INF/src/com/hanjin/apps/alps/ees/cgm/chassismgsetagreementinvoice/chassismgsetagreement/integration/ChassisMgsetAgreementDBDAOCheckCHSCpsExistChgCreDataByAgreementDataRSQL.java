/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOCheckCHSCpsExistChgCreDataByAgreementDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.17 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOCheckCHSCpsExistChgCreDataByAgreementDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당하는 NP(ZP) Agreement 가 Charge Creation 된 데이터인지 체크한다.
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOCheckCHSCpsExistChgCreDataByAgreementDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOCheckCHSCpsExistChgCreDataByAgreementDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("    CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("    AND COST_YRMON >= SUBSTR(@[agmt_eff_dt],1,6)" ).append("\n"); 
		query.append("    AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 

	}
}