/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAOSearchAGNCommAuditConfirmListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.11 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOSearchAGNCommAuditConfirmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchAGNCommAuditConfirmList
	  * </pre>
	  */
	public AGNCommAuditDBDAOSearchAGNCommAuditConfirmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ").append("\n");
		query.append("FileName : AGNCommAuditDBDAOSearchAGNCommAuditConfirmListRSQL").append("\n");
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
		query.append("    A.BKG_NO          AS BKG_NO, 	" ).append("\n");
		query.append("    B.BL_NO           AS BL_NO,		" ).append("\n");
		query.append("    A.AGN_CD          AS AGN_CD, 		" ).append("\n");
		query.append("    A.IO_BND_CD       AS IO_BND_CD,		" ).append("\n");
		query.append("    A.AC_SEQ          AS AC_SEQ, 	" ).append("\n");
		query.append("    SUM(A.IF_AMT)     AS IF_AMT,	" ).append("\n");
		query.append("    SUM(A.PAY_IF_AMT) AS PAY_IF_AMT,		" ).append("\n");
		query.append("    A.AR_OFC_CD       AS AR_OFC_CD	" ).append("\n");
		query.append("FROM ACM_AGN_COMM A, ACM_AGN_BKG_INFO B		" ).append("\n");
		query.append("WHERE  1=1		" ).append("\n");
		query.append("AND A.BKG_NO = B.BKG_NO			" ).append("\n");
		query.append("AND (A.BKG_NO||A.AGN_CD||A.IO_BND_CD||A.AC_SEQ) IN (${arr_val})			" ).append("\n");
		query.append("AND A.AC_STS_CD IN ('RS') 		" ).append("\n");
		query.append("AND A.CRE_USR_ID != 'COST'		" ).append("\n");
		query.append("--and rownum < 10" ).append("\n");
		query.append("AND A.RQST_DT BETWEEN TO_DATE(@[date_fm],'YYYYMMDD') AND TO_DATE(@[date_to],'YYYYMMDD')+0.99999		" ).append("\n");
		query.append("GROUP BY A.BKG_NO, A.AC_SEQ, A.AGN_CD, A.IO_BND_CD, B.BL_NO, A.AR_OFC_CD" ).append("\n");

	}
}