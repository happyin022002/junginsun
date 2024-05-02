/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAOSearchMtRtnYdNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.15 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerAproDAOSearchMtRtnYdNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search MT Return Yard name
	  * </pre>
	  */
	public CustomerNominatedTruckerAproDAOSearchMtRtnYdNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerAproDAOSearchMtRtnYdNmRSQL").append("\n"); 
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
		query.append("SELECT YD_CD" ).append("\n"); 
		query.append("     , YD_NM" ).append("\n"); 
		query.append("  FROM MDM_YARD" ).append("\n"); 
		query.append(" WHERE YD_CD = ( SELECT MAX(YD_CD)" ).append("\n"); 
		query.append("                   FROM ( SELECT MTY_PKUP_YD_CD  AS YD_CD -- BOUND에 따라 Pickup 또는 Return Yard 조회" ).append("\n"); 
		query.append("                            FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                           WHERE LOC_CD = CASE WHEN LENGTH(@[rtn_yard]) = 7 THEN SUBSTR(@[rtn_yard],1,5)" ).append("\n"); 
		query.append("											   WHEN LENGTH(@[rtn_yard]) = 5 THEN @[rtn_yard]" ).append("\n"); 
		query.append("                                               ELSE ''" ).append("\n"); 
		query.append(" 										   END	" ).append("\n"); 
		query.append("                           UNION " ).append("\n"); 
		query.append("                          SELECT REP_YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_ZONE" ).append("\n"); 
		query.append("                           WHERE ZN_CD = CASE WHEN LENGTH(@[rtn_yard]) = 7 THEN @[rtn_yard]" ).append("\n"); 
		query.append("                                              WHEN LENGTH(@[rtn_yard]) = 5 THEN @[rtn_yard]" ).append("\n"); 
		query.append("                                              ELSE ''" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("			              )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT LSE_CO_YD_CD, LSE_CO_YD_NM" ).append("\n"); 
		query.append("  FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append(" WHERE LSE_CO_YD_CD = (  SELECT MAX(YD_CD)" ).append("\n"); 
		query.append("                          FROM ( SELECT MTY_PKUP_YD_CD  AS YD_CD -- BOUND에 따라 Pickup 또는 Return Yard 조회" ).append("\n"); 
		query.append("                                   FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                                  WHERE LOC_CD = CASE WHEN LENGTH(@[rtn_yard]) = 7 THEN SUBSTR(@[rtn_yard],1,5)" ).append("\n"); 
		query.append("		             							   	  WHEN LENGTH(@[rtn_yard]) = 5 THEN @[rtn_yard]" ).append("\n"); 
		query.append("		                                              ELSE ''" ).append("\n"); 
		query.append("		 										 END	" ).append("\n"); 
		query.append("                                  UNION " ).append("\n"); 
		query.append("                                 SELECT REP_YD_CD" ).append("\n"); 
		query.append("                                   FROM MDM_ZONE" ).append("\n"); 
		query.append("                                  WHERE ZN_CD = CASE WHEN LENGTH(@[rtn_yard]) = 7 THEN @[rtn_yard]" ).append("\n"); 
		query.append("                                                     WHEN LENGTH(@[rtn_yard]) = 5 THEN @[rtn_yard]" ).append("\n"); 
		query.append("                                                     ELSE ''" ).append("\n"); 
		query.append("                                                 END" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 

	}
}