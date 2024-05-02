/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEqTypeNTpSzByEqNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2012.06.27 신혜정
* 1.0 Creation
--------------------------------------------------------
* History
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가    
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEqTypeNTpSzByEqNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEqTypeNTpSzByEqNoData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEqTypeNTpSzByEqNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEqTypeNTpSzByEqNoDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.EQ_TYPE AS EQ_KND_CD" ).append("\n"); 
		query.append("	, A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM MNR_EQ_STS_V A " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 

	}
}