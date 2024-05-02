/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdByEqTypeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.08.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdByEqTypeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMnrEqCmpoCdByEqTypeData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdByEqTypeDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdByEqTypeDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.EQ_CMPO_CD AS CD_ID" ).append("\n"); 
		query.append(",A.EQ_CMPO_NM AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD A" ).append("\n"); 
		query.append("WHERE A.EQ_CMPO_GRP_TP_CD = @[searchkey]" ).append("\n"); 
		query.append("#if (${searchcon} == 'U')" ).append("\n"); 
		query.append("AND   A.CNTR_CMPO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'Z')" ).append("\n"); 
		query.append("AND   A.CHSS_CMPO_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   A.MGST_CMPO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY EQ_CMPO_CD ASC" ).append("\n"); 

	}
}