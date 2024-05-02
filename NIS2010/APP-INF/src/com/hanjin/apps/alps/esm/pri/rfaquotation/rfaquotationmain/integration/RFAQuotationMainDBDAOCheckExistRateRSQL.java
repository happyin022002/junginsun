/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAQuotationMainDBDAOCheckExistRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.02.23 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOCheckExistRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rate 가 존재하는 지 체크
	  * </pre>
	  */
	public RFAQuotationMainDBDAOCheckExistRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOCheckExistRateRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT_NON_RATE" ).append("\n"); 
		query.append("FROM    PRI_RQ_RT_CMDT_HDR A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND     A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND NOT EXISTS  (" ).append("\n"); 
		query.append("                SELECT 'X' " ).append("\n"); 
		query.append("                FROM PRI_RQ_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("                WHERE A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("                AND   A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("                AND   A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}