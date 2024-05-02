/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetZeroSumObjListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.22
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.22 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetZeroSumObjListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_AGN_COMM에서 bkgNo로 데이터를 구한다.
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetZeroSumObjListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n");
		query.append("FileName : AGNCommRequestDBDAOGetZeroSumObjListRSQL").append("\n");
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
		query.append("SELECT BKG_NO," ).append("\n");
		query.append("       AGN_CD," ).append("\n");
		query.append("       IO_BND_CD," ).append("\n");
		query.append("       AC_TP_CD," ).append("\n");
		query.append("       @[usr_id] AS USR_ID" ).append("\n");
		query.append("  FROM ACM_AGN_COMM" ).append("\n");
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append(" GROUP BY BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD" ).append("\n");

	}
}