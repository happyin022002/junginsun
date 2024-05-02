/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration ").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(1), 0, 'N', 'Y') AS AUTH_YN" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  FROM  COM_USER            T1 " ).append("\n"); 
		query.append("       ,DMT_USR_ROLE_MTCH   T2" ).append("\n"); 
		query.append("       ,COM_OFC_PGM_MTCH    T3" ).append("\n"); 
		query.append("       ,MDM_ORGANIZATION    T4" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(" WHERE  T1.USR_ID           = T2.USR_ID" ).append("\n"); 
		query.append("   AND  T1.OFC_CD           = T3.OFC_CD" ).append("\n"); 
		query.append("   AND  T1.OFC_CD           = T4.OFC_CD" ).append("\n"); 
		query.append("   AND  T1.USR_ID           = @[usr_id]" ).append("\n"); 
		query.append("   AND  T1.USE_FLG          = 'Y'" ).append("\n"); 
		query.append("   AND  T2.USR_ROLE_CD      = 'DMT08'" ).append("\n"); 
		query.append("   AND  T3.PGM_NO           = 'EES_DMT_3014'" ).append("\n"); 

	}
}