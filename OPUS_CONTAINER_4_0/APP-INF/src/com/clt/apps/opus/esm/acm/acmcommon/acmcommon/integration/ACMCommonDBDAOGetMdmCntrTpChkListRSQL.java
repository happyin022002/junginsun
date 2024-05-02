/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetMdmCntrTpChkListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.21 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetMdmCntrTpChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MDM_CNTR_TP에서 코드로 조회
	  * </pre>
	  */
	public ACMCommonDBDAOGetMdmCntrTpChkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n");
		query.append("FileName : ACMCommonDBDAOGetMdmCntrTpChkListRSQL").append("\n");
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
		query.append("SELECT COUNT(*) AS VALUE1" ).append("\n");
		query.append("FROM MDM_CNTR_TP" ).append("\n");
		query.append("WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("AND CNTR_TP_CD IN (${value0})" ).append("\n");

	}
}