/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcheckMdmLocCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.14 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcheckMdmLocCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkMdmLocCodeData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcheckMdmLocCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcheckMdmLocCodeDataRSQL").append("\n"); 
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
		query.append("A.LOC_CD AS CD_ID," ).append("\n"); 
		query.append("A.LOC_NM AS CD_DESC" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_COUNTRY B, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE 1 = 1 AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND A.LOC_CD = @[check_value]" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}