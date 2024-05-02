/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchTypeSizeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchTypeSizeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchTypeSizeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchTypeSizeListDataRSQL").append("\n"); 
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
		query.append("#if (${knd_cd} == 'U')" ).append("\n"); 
		query.append("SELECT A.CNTR_TPSZ_CD    CD_ID," ).append("\n"); 
		query.append("A.CNTR_TPSZ_DESC  CD_DESC" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("WHERE @[knd_cd] = 'U'" ).append("\n"); 
		query.append("#if (${type_size_search_ind} == 'A')" ).append("\n"); 
		query.append("AND ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${order_by_col_nm} == 'Y')" ).append("\n"); 
		query.append("ORDER BY A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.EQ_TPSZ_CD    CD_ID," ).append("\n"); 
		query.append("A.DIFF_DESC     CD_DESC" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${order_by_col_nm} == 'Y')" ).append("\n"); 
		query.append("ORDER BY A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}