/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OnhireBalanceDBDAOsearchRccLccCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.04.01 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
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
	  * Search rcc_cd and lcc_cd
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
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
		query.append("#if(${loc_grp_cd} == 'L')   -- LCC_CD " ).append("\n"); 
		query.append("SELECT DISTINCT LCC_CD CODE " ).append("\n"); 
		query.append("     , LCC_CD NAME " ).append("\n"); 
		query.append("#else                       -- RCC_CD " ).append("\n"); 
		query.append("SELECT DISTINCT RCC_CD CODE " ).append("\n"); 
		query.append("     , RCC_CD NAME " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'L')   -- LCC_CD " ).append("\n"); 
		query.append("  #if(${loc_cd} != '')      " ).append("\n"); 
		query.append("AND    RCC_CD = @[loc_cd]   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else                       -- RCC_CD " ).append("\n"); 
		query.append("  #if(${loc_cd} != '')      " ).append("\n"); 
		query.append("AND    LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY NAME" ).append("\n"); 

	}
}