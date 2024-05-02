/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaDBDAOCheckLocCodeIsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOCheckLocCodeIsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Code 존재 여부를 체크함.
	  * </pre>
	  */
	public SurplusAreaDBDAOCheckLocCodeIsRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration ").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOCheckLocCodeIsRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(1),'0','F','T') LOC_CHK" ).append("\n"); 
		query.append("FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'R')" ).append("\n"); 
		query.append("AND    RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("AND    LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("AND    ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("AND    SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}