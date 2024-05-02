/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAOSearchFACCustomerInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.11 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAOSearchFACCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * office cd로 cnt cd를 조회한다.
	  * </pre>
	  */
	public FACommAgreementDBDAOSearchFACCustomerInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration ").append("\n");
		query.append("FileName : FACommAgreementDBDAOSearchFACCustomerInfoRSQL").append("\n");
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
		query.append("	SUBSTR (LOC_CD, 1, 2) AS FF_CNT_CD" ).append("\n");
		query.append("FROM   MDM_ORGANIZATION" ).append("\n");
		query.append("WHERE  OFC_CD = @[fac_ofc_cd]" ).append("\n");

	}
}