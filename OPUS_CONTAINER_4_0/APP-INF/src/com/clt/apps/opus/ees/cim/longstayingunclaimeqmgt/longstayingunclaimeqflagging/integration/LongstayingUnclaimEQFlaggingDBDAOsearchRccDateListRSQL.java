/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchRccDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.24 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchRccDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RCC_CD에 해당하는 RCC_DATE 구한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchRccDateListRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchRccDateListRSQL").append("\n"); 
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
		query.append("SELECT RCC_CD, TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(RCC_CD),'YYYYMMDD HH24:mi:SS') RCC_DATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT DISTINCT A.RCC_CD FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("WHERE A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("WHERE A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("WHERE A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("WHERE A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("WHERE A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("WHERE SCC_CD = (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD=SUBSTR(@[loc_cd],1,5))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RCC_CD" ).append("\n"); 

	}
}