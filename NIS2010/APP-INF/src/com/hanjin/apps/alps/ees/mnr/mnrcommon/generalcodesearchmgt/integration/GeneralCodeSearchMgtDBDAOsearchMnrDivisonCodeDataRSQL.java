/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrDivisonCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrDivisonCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Division Code를 조회하는 Operation
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrDivisonCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rlt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrDivisonCodeDataRSQL").append("\n"); 
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
		query.append("SELECT   CD_ID" ).append("\n"); 
		query.append("       , CD_DESC" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   A.TO_RLT_CD AS CD_ID" ).append("\n"); 
		query.append("                  , A.MNR_RLT_CD_DESC AS CD_DESC" ).append("\n"); 
		query.append("           FROM     MNR_CD_RLT A" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.EQ_CEDEX_RLT_TP_CD = 'CTV'	  " ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON')" ).append("\n"); 
		query.append("           AND      A.FM_RLT_CD = @[fm_rlt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND      A.COST_GRP_CD LIKE @[cost_grp_cd] || '%' " ).append("\n"); 
		query.append("           AND      A.FM_RLT_CD = @[fm_rlt_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("           SELECT   ' ' AS CD_ID" ).append("\n"); 
		query.append("                  , ' ' AS CD_DESC" ).append("\n"); 
		query.append("           FROM     DUAL" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("ORDER BY CD_ID" ).append("\n"); 

	}
}