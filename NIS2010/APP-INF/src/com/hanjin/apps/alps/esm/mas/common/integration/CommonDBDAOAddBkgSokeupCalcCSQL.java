/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOAddBkgSokeupCalcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOAddBkgSokeupCalcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddBkgSokeupCalc
	  * </pre>
	  */
	public CommonDBDAOAddBkgSokeupCalcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOAddBkgSokeupCalcCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_BKG_COST_CALC K USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO, MAS_BAT_RMK, CRE_USR_ID " ).append("\n"); 
		query.append("FROM MAS_BKG_RTRO_HIS " ).append("\n"); 
		query.append("WHERE BKG_NO IN (" ).append("\n"); 
		query.append("#if($expVal.size() != 0)" ).append("\n"); 
		query.append("	#foreach(${key} in ${expVal})" ).append("\n"); 
		query.append("		#if($velocityCount < $expVal.size())" ).append("\n"); 
		query.append("                            '${key}'," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            '${key}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND MAS_BAT_SEQ = @[max_seq]" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("ON( K.BKG_NO = B2.BKG_NO)              " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT" ).append("\n"); 
		query.append("                (                " ).append("\n"); 
		query.append("                        K.BKG_NO" ).append("\n"); 
		query.append("                      , K.MAS_BAT_CD" ).append("\n"); 
		query.append("                      , K.MAS_BAT_SEQ" ).append("\n"); 
		query.append("                      , K.MAS_BAT_DT" ).append("\n"); 
		query.append("                      , K.MAS_BAT_RMK" ).append("\n"); 
		query.append("                      , K.MAS_MNL_BAT_SEQ" ).append("\n"); 
		query.append("                      , K.CRE_USR_ID" ).append("\n"); 
		query.append("                      , K.CRE_DT" ).append("\n"); 
		query.append("                      , K.UPD_USR_ID" ).append("\n"); 
		query.append("                      , K.UPD_DT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                VALUES" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        B2.BKG_NO" ).append("\n"); 
		query.append("                      , 'E' -- HARD CODING" ).append("\n"); 
		query.append("                      , '2' -- HARD CODING" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , B2.MAS_BAT_RMK" ).append("\n"); 
		query.append("                      , '0' -- HARD CODING" ).append("\n"); 
		query.append("                      , B2.CRE_USR_ID" ).append("\n"); 
		query.append("                      , SYSDATE" ).append("\n"); 
		query.append("                      , B2.CRE_USR_ID" ).append("\n"); 
		query.append("                      , SYSDATE            " ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}