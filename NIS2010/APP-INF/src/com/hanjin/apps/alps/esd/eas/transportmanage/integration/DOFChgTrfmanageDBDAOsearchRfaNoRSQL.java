/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchRfaNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchRfaNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 Customer 정보로 Effect date List Search
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchRfaNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchRfaNoRSQL").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    DISTINCT" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN M.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("    THEN 'Y'" ).append("\n"); 
		query.append("    ELSE 'N'" ).append("\n"); 
		query.append("    END EFF_YN" ).append("\n"); 
		query.append("FROM PRI_RP_MN M, PRI_RP_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("AND H.RFA_NO = @[rfa_no]),'N') RFA_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}