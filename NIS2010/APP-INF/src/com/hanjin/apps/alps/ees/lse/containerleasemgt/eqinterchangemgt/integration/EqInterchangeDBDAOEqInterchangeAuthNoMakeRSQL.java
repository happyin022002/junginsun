/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOEqInterchangeAuthNoMakeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOEqInterchangeAuthNoMakeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EqInterchangeDBDAOEqInterchangeAuthNoMakeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOEqInterchangeAuthNoMakeRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[loc_cd],3,3) || @[lstm_cd] ||" ).append("\n"); 
		query.append(" TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || SUBSTR(TO_CHAR(( COUNT(*) + 1 ), '000'),2,3) AUTH_NO" ).append("\n"); 
		query.append("FROM LSE_EQ_ITCHG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TO_CHAR(CRE_DT,'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}