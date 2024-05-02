/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchAccountAndCostByConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchAccountAndCostByConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountAndCostByCondition
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchAccountAndCostByConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchAccountAndCostByConditionRSQL").append("\n"); 
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
		query.append(",PSO_YD_CHG C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND    A.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("AND    C.LGS_COST_CD = A.LGS_COST_CD" ).append("\n"); 
		query.append("#if( ${port_cd}!='')           " ).append("\n"); 
		query.append("AND SUBSTR (C.YD_CD, 1, 5) = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${yd_cd}!='')" ).append("\n"); 
		query.append("AND SUBSTR (C.YD_CD, 6) IN (#foreach( $key IN ${arr_yd_cd}) " ).append("\n"); 
		query.append("                                 #if($velocityCount < $arr_yd_cd.size())" ).append("\n"); 
		query.append("                                      '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                      '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                              #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${year} != '' )" ).append("\n"); 
		query.append("AND C.EFF_DT <= TO_DATE(@[year]||'1231', 'YYYYMMDD')" ).append("\n"); 
		query.append("AND C.EXP_DT >= TO_DATE(@[year]||'0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.ACCT_CD, A.LGS_COST_CD, ACCT_ENG_NM, A.LGS_COST_CD, A.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("ORDER BY A.ACCT_CD, A.LGS_COST_CD" ).append("\n"); 

	}
}