/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchEqTpSzDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchEqTpSzDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Type size 정보를 조회한다.
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchEqTpSzDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchEqTpSzDataRSQL").append("\n"); 
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
		query.append("SELECT CD_ID, CD_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(	SELECT" ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD AS CD_ID" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_DESC AS CD_DESC" ).append("\n"); 
		query.append(",A.RPT_DP_SEQ AS DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   'U'  = @[searchkey]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EQ_TPSZ_CD AS CD_ID" ).append("\n"); 
		query.append(", A.DIFF_DESC  AS CD_DESC" ).append("\n"); 
		query.append(", A.DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[searchkey]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}