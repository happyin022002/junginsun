/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchCheckTrsCostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.19 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchCheckTrsCostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRANSPORTATION COST CODE VALIDATION CHECK
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchCheckTrsCostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration ").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchCheckTrsCostCodeRSQL").append("\n"); 
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
		query.append("SELECT A.LGS_COST_CD" ).append("\n"); 
		query.append("  FROM TES_LGS_COST A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("   AND A.LGS_COST_SUBJ_CD IN ('TR','SC','SM')" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 

	}
}