/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAOGetMaxSlctItmFomSeqInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.10.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOGetMaxSlctItmFomSeqInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMReportDBDAOGetMaxSlctItmFomSeqInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmreport.acmreport.integration").append("\n");
		query.append("FileName : ACMReportDBDAOGetMaxSlctItmFomSeqInfoRSQL").append("\n");
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
		query.append("SELECT NVL(MAX(SLCT_ITM_FOM_SEQ), 0) + 1 AS SLCT_ITM_FOM_SEQ" ).append("\n");
		query.append("  FROM AGT_RPT_ITM_INFO_MST" ).append("\n");
		query.append(" WHERE CRE_USR_ID = @[usr_id]" ).append("\n");

	}
}