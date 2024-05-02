/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.06.21 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewSelectRSQL").append("\n"); 
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
		query.append("A.AGMT_OFC_CD AS AGMT_OFC_CD_VALUE," ).append("\n"); 
		query.append("A.VNDR_CNT_CD AS VNDR_CNT_CD_VALUE," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ_VALUE," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(AGN_AGMT_SEQ) + 1, 1) AS AGN_AGMT_SEQ" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT_MST" ).append("\n"); 
		query.append(")                                          AS AGN_AGMT_SEQ," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(AGN_AGMT_VER_SEQ), 1) AS AGN_AGMT_VER_SEQ" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CD     = A.AGMT_OFC_CD" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD = A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND AGN_AGMT_SEQ    = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("AND VNDR_CNT_CD     = A.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND VNDR_SEQ        = A.VNDR_SEQ" ).append("\n"); 
		query.append(")                                          AS AGN_AGMT_VER_SEQ_VALUE," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD 						AS AGMT_OFC_CTY_CD_VALUE," ).append("\n"); 
		query.append("A.AGN_AGMT_SEQ                           AS AGN_AGMT_SEQ_VALUE," ).append("\n"); 
		query.append("@[cre_usr_id]                            AS CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id]                            AS UPD_USR_ID," ).append("\n"); 
		query.append("A.DELT_FLG" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT_MST A" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd_value]" ).append("\n"); 
		query.append("AND A.AGN_AGMT_SEQ    = @[agn_agmt_seq_value]" ).append("\n"); 
		query.append("AND A.DELT_FLG        = 'N'" ).append("\n"); 

	}
}