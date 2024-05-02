/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchActualCarrierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchActualCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_CARRIER의 Carrier, Vnder, Customer 를 조회 한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchActualCarrierListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchActualCarrierListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CR.JO_CRR_CD" ).append("\n"); 
		query.append("     , CR.VNDR_SEQ" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , CR.CUST_CNT_CD" ).append("\n"); 
		query.append("     , CR.CUST_SEQ" ).append("\n"); 
		query.append("     , CR.CUST_CNT_CD||CR.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append("     , MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM JOO_CARRIER  CR" ).append("\n"); 
		query.append("     , MDM_VENDOR   MV" ).append("\n"); 
		query.append("     , MDM_CUSTOMER MC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CR.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("   AND MV.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("   AND CR.VNDR_SEQ      = MV.VNDR_SEQ   (+)" ).append("\n"); 
		query.append("   AND MC.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("   AND CR.CUST_CNT_CD   = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND CR.CUST_SEQ      = MC.CUST_SEQ   (+)" ).append("\n"); 
		query.append(" ORDER BY CR.JO_CRR_CD" ).append("\n"); 
		query.append("     , CR.CUST_CNT_CD||CR.CUST_SEQ" ).append("\n"); 
		query.append("     , CR.VNDR_SEQ" ).append("\n"); 

	}
}