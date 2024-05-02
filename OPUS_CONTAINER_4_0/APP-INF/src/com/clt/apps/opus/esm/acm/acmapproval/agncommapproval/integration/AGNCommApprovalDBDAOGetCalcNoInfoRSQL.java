/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetCalcNoInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.16 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetCalcNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CALC_NO 구한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetCalcNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOGetCalcNoInfoRSQL").append("\n");
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
		query.append("SELECT TO_CHAR(SYSDATE,'YYMMDD')||TO_CHAR(ACM_AGN_BKG_INFO_HIS_SEQ.NEXTVAL,'FM0000000') AS CALC_NO " ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}