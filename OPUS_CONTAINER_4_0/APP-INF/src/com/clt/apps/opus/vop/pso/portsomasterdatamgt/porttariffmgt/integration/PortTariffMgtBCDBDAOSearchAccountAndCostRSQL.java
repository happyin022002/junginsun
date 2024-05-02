/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchAccountAndCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchAccountAndCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모든 Account & Cost 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchAccountAndCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchAccountAndCostRSQL").append("\n"); 
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
		query.append("SELECT T2.ACCT_CD" ).append("\n"); 
		query.append("     , T3.ACCT_ENG_NM" ).append("\n"); 
		query.append("     , T2.LGS_COST_CD" ).append("\n"); 
		query.append("     , T2.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("     , T2.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("  FROM PSO_INV_OFC_COST T1" ).append("\n"); 
		query.append("     , TES_LGS_COST T2" ).append("\n"); 
		query.append("     , MDM_ACCOUNT T3" ).append("\n"); 
		query.append(" WHERE T1.LGS_COST_CD = T2.LGS_COST_CD" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("   AND T2.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("   AND T2.ACCT_CD = T3.ACCT_CD" ).append("\n"); 
		query.append("   AND T1.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(" ORDER BY T2.ACCT_CD, T2.LGS_COST_OPT_NO" ).append("\n"); 

	}
}