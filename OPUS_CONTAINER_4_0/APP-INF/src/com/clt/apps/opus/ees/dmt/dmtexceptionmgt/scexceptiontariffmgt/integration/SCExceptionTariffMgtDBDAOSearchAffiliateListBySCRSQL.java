/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchAffiliateListBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchAffiliateListBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Affiliate Customer 를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchAffiliateListBySCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchAffiliateListBySCRSQL").append("\n"); 
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
		query.append("SELECT	A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append(",	B.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	DISTINCT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_AFIL SP_AFIL" ).append("\n"); 
		query.append("WHERE	SP_AFIL.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_CTRT_PTY	SP_PTY" ).append("\n"); 
		query.append("WHERE	SP_PTY.PROP_NO	= @[prop_no]" ).append("\n"); 
		query.append("AND SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */ AMDT_SEQ" ).append("\n"); 
		query.append("FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND ROWNUM 	= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", 	MDM_CUSTOMER B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND	A.CUST_SEQ		= B.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CUST_CD" ).append("\n"); 

	}
}