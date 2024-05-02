/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAOCustomerNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOCustomerNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Name select
	  * </pre>
	  */
	public PRICommonDBDAOCustomerNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOCustomerNmRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${etc5} != '') " ).append("\n"); 
		query.append("		DECODE(CNTR_CUST_TP_CD,'N','N','B','B','M') AS CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		DECODE(CNTR_CUST_TP_CD,'N','N','I') AS CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",		CUST_LGL_ENG_NM AS NM" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD = @[etc1]" ).append("\n"); 
		query.append("   AND CUST_SEQ = @[etc2]" ).append("\n"); 
		query.append("   AND DELT_FLG ='N'" ).append("\n"); 
		query.append("   AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("   AND (SLS_DELT_EFF_DT IS NULL OR SLS_DELT_EFF_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("#if (${etc3} == 'N')" ).append("\n"); 
		query.append("   AND (NMD_CUST_FLG IS NULL OR NMD_CUST_FLG <> 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}