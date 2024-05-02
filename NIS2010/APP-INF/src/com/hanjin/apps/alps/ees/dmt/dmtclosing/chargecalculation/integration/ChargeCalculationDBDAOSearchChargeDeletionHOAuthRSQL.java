/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL").append("\n"); 
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
		query.append("select  decode(count(1), 0, 'N', 'Y') as AUTH_YN" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  from  COM_USER            T1 " ).append("\n"); 
		query.append("       ,DMT_USR_ROLE_MTCH   T2" ).append("\n"); 
		query.append("       ,COM_OFC_PGM_MTCH    T3" ).append("\n"); 
		query.append("       ,MDM_ORGANIZATION    T4" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(" where  T1.USR_ID           = T2.USR_ID" ).append("\n"); 
		query.append("   and  T1.OFC_CD           = T3.OFC_CD" ).append("\n"); 
		query.append("   and  T1.OFC_CD           = T4.OFC_CD" ).append("\n"); 
		query.append("   and  T1.USR_ID           = @[usr_id]" ).append("\n"); 
		query.append("   and  T1.USE_FLG          = 'Y'" ).append("\n"); 
		query.append("   and  T2.USR_ROLE_CD      = 'DMT01'" ).append("\n"); 
		query.append("   and  T3.PGM_NO           = 'EES_DMT_3014'" ).append("\n"); 
		query.append("   and  T4.AR_HD_QTR_OFC_CD = 'SELHO'" ).append("\n"); 

	}
}