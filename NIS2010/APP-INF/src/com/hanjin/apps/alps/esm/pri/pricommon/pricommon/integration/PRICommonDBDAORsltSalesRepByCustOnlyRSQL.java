/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORsltSalesRepByCustOnlyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSalesRepByCustOnlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 별 Sales Rep. Office Code는 조건에서 제외함
	  * </pre>
	  */
	public PRICommonDBDAORsltSalesRepByCustOnlyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSalesRepByCustOnlyRSQL").append("\n"); 
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
		query.append("SELECT A.SREP_CD AS CD" ).append("\n"); 
		query.append("     , A.SREP_NM AS NM" ).append("\n"); 
		query.append("     , A.OFC_CD AS ETC1" ).append("\n"); 
		query.append("FROM MDM_SLS_REP A" ).append("\n"); 
		query.append("   , BKG_CUST_SLS_REP B" ).append("\n"); 
		query.append("WHERE A.SREP_CD = B.SREP_CD" ).append("\n"); 
		query.append("AND   B.CUST_CNT_CD = @[etc2]" ).append("\n"); 
		query.append("AND   B.CUST_SEQ = @[etc3]" ).append("\n"); 
		query.append("AND   B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("ORDER BY A.SREP_CD" ).append("\n"); 

	}
}