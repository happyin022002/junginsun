/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoDBDAOSearchFACExSettingListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.08 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCustomerInfoDBDAOSearchFACExSettingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMCustomerInfoDBDAOSearchFACExSettingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.integration").append("\n");
		query.append("FileName : ACMCustomerInfoDBDAOSearchFACExSettingListRSQL").append("\n");
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
		query.append("SELECT A.FF_CNT_CD||TO_CHAR(A.FF_SEQ,'FM000000') AS FF_CNT_SEQ," ).append("\n");
		query.append("       (SELECT MAX(NVL(LTRIM(C.CUST_LGL_ENG_NM), ' '))" ).append("\n");
		query.append("          FROM MDM_CUSTOMER C" ).append("\n");
		query.append("         WHERE C.CUST_CNT_CD(+) = A.FF_CNT_CD" ).append("\n");
		query.append("           AND C.CUST_SEQ(+) = A.FF_SEQ" ).append("\n");
		query.append("           AND C.CNTR_DIV_FLG(+) = 'Y') AS CUST_LGL_ENG_NM," ).append("\n");
		query.append("       SHPR_CNT_CD||LTRIM (TO_CHAR (SHPR_SEQ, '000000')) AS SHPR_CNT_SEQ," ).append("\n");
		query.append("       (SELECT MAX(NVL(LTRIM(C.CUST_LGL_ENG_NM), ' '))" ).append("\n");
		query.append("          FROM MDM_CUSTOMER C" ).append("\n");
		query.append("         WHERE C.CUST_CNT_CD(+) = A.SHPR_CNT_CD" ).append("\n");
		query.append("           AND C.CUST_SEQ(+) = A.SHPR_SEQ" ).append("\n");
		query.append("           AND C.CNTR_DIV_FLG(+) = 'Y') AS SHPR_LGL_ENG_NM," ).append("\n");
		query.append("       A.FAC_OFC_CD," ).append("\n");
		query.append("       A.FF_CNT_CD," ).append("\n");
		query.append("       A.FF_SEQ AS ORG_FF_SEQ," ).append("\n");
		query.append("       A.SHPR_CNT_CD AS ORG_SHPR_CNT_CD," ).append("\n");
		query.append("       A.SHPR_SEQ AS ORG_SHPR_SEQ" ).append("\n");
		query.append("  FROM ACM_FAC_EXCLU_SET A" ).append("\n");
		query.append(" WHERE FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n");
		query.append(" ORDER BY A.FF_CNT_CD||TO_CHAR(A.FF_SEQ,'FM000000')," ).append("\n");
		query.append("          A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ,'FM000000')" ).append("\n");

	}
}