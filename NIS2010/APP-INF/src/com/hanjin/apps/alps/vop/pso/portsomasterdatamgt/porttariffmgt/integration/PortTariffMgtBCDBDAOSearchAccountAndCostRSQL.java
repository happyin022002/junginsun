/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchAccountAndCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.24 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
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
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
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
		query.append("SELECT A.ACCT_CD			ACCT_CD" ).append("\n"); 
		query.append(",B.ACCT_ENG_NM 		ACCT_NM" ).append("\n"); 
		query.append(",A.LGS_COST_CD		COST_CD" ).append("\n"); 
		query.append(",A.LGS_COST_FULL_NM	COST_NM" ).append("\n"); 
		query.append("FROM   TES_LGS_COST A" ).append("\n"); 
		query.append(",MDM_ACCOUNT  B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND    A.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("ORDER BY A.ACCT_CD, A.LGS_COST_CD" ).append("\n"); 

	}
}