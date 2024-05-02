/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExpenseMgtDBDAOcheckTraderContainerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOcheckTraderContainerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ExpenseMgtDBDAOcheckTraderContainerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOcheckTraderContainerDataRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (SELECT A.AGMT_CTY_CD, A.AGMT_SEQ, MAX(A.AGMT_LST_VER_SEQ) AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("                 FROM LSE_AGREEMENT A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("                WHERE A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                  AND B.EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("               GROUP BY A.AGMT_CTY_CD, A.AGMT_SEQ)" ).append("\n"); 
		query.append("SELECT 'X' AS VALID_CHK" ).append("\n"); 
		query.append("  FROM LSE_AGREEMENT A, PARAM P                       " ).append("\n"); 
		query.append(" WHERE A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.AGMT_LST_VER_SEQ = P.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("   AND A.SLB_FLG = 'Y'" ).append("\n"); 

	}
}