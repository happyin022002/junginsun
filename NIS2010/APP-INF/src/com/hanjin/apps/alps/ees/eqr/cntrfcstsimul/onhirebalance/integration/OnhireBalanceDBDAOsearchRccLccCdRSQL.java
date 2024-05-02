/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceDBDAOsearchRccLccCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.14
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.14 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireBalanceDBDAOsearchRccLccCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_EQ_ORZ_CHT 에서 RCC_CD 와 LCC_CD 리스트를 조회한다
	  * </pre>
	  */
	public OnhireBalanceDBDAOsearchRccLccCdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOsearchRccLccCdRSQL").append("\n"); 
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
		query.append("#if(${loc_grp_cd} == 'L')   -- LCC_CD 조회" ).append("\n"); 
		query.append("SELECT DISTINCT LCC_CD CODE " ).append("\n"); 
		query.append("     , LCC_CD NAME " ).append("\n"); 
		query.append("#else                       -- RCC_CD 조회" ).append("\n"); 
		query.append("SELECT DISTINCT RCC_CD CODE " ).append("\n"); 
		query.append("     , RCC_CD NAME " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'L')   -- LCC_CD 조회" ).append("\n"); 
		query.append("  #if(${loc_cd} != '')      " ).append("\n"); 
		query.append("AND    RCC_CD = @[loc_cd]   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else                       -- RCC_CD 조회" ).append("\n"); 
		query.append("  #if(${loc_cd} != '')      " ).append("\n"); 
		query.append("AND    LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY NAME" ).append("\n"); 

	}
}