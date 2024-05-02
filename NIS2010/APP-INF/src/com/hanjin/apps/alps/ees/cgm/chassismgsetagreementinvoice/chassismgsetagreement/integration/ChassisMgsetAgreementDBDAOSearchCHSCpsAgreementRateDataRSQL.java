/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementRateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.29 이영헌
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

public class ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementRateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS Agreement 에 해당하는 Rate 정보를 CGM_AGMT_CPS_RT 에서 조회한다.
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementRateDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementRateDataRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD," ).append("\n"); 
		query.append("       AMT_AUD_FLG," ).append("\n"); 
		query.append("       CHSS_POOL_RT_AMT," ).append("\n"); 
		query.append("       CHSS_POOL_TAX_RT," ).append("\n"); 
		query.append("       AGMT_RMK" ).append("\n"); 
		query.append("FROM CGM_AGMT_CPS_RT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#if (${agmt_ver_no} != '')" ).append("\n"); 
		query.append("	  AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AGMT_VER_NO" ).append("\n"); 

	}
}