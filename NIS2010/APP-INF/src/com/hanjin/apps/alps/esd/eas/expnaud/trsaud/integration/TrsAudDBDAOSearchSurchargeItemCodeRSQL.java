/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TrsAudDBDAOSearchSurchargeItemCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchSurchargeItemCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Item Code 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchSurchargeItemCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchSurchargeItemCodeRSQL").append("\n"); 
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
		query.append("SELECT   X.SCG_CD code_cd" ).append("\n"); 
		query.append("        ,X.SCG_NM code_nm" ).append("\n"); 
		query.append("FROM    ( SELECT   SCG_CD" ).append("\n"); 
		query.append("                 , SCG_NM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT LGS_COST_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN SUBSTR(LGS_COST_CD, 3,4) IN ('OTAL', 'OTAX') THEN SUBSTR(LGS_COST_CD, 3,4)" ).append("\n"); 
		query.append("                            ELSE SUBSTR(LGS_COST_CD, 3,2)" ).append("\n"); 
		query.append("                       END SCG_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN LGS_COST_FULL_NM LIKE 'Fuel Surcharge%' THEN 'Fuel Surcharge'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'Barge Low water surcharge' THEN 'Seasonal Surcharge'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'Multistop Delivery' THEN 'Multiple Delivery'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'Over Size' THEN 'Over Size(OOG)'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'Sunday Running' THEN 'Weekend / Holiday'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'ENSF- FDR%' THEN 'ENSF'" ).append("\n"); 
		query.append("                            WHEN LGS_COST_FULL_NM LIKE 'Non-Refundable Tax%' THEN 'Non-Refundable Tax'" ).append("\n"); 
		query.append("                            ELSE LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                       END SCG_NM" ).append("\n"); 
		query.append("                  FROM TES_LGS_COST" ).append("\n"); 
		query.append("                 WHERE LGS_COST_SUBJ_CD IN ('SC', 'SM')" ).append("\n"); 
		query.append("                   AND LGS_COST_DTL_CD IS NOT NULL" ).append("\n"); 
		query.append("                   AND SUBSTR(LGS_COST_CD, 3,4) NOT IN ('CHAL')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         GROUP BY SCG_CD, SCG_NM" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("         SELECT 'NE' SCG" ).append("\n"); 
		query.append("               ,'Nego' SCG_NM" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("         ORDER BY SCG_NM ) X" ).append("\n"); 
		query.append("	WHERE X.SCG_CD <> 'HL'" ).append("\n"); 

	}
}