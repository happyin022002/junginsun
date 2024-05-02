/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAORsltSrepByMultiOfcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSrepByMultiOfcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 복수 ofc_cd의 Sales Rep. 조회
	  * </pre>
	  */
	public PRICommonDBDAORsltSrepByMultiOfcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSrepByMultiOfcListVORSQL").append("\n"); 
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
		query.append("    SREP_CD CD," ).append("\n"); 
		query.append("    SREP_NM NM," ).append("\n"); 
		query.append("	SREP_EML ETC2" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_SLS_REP" ).append("\n"); 
		query.append("WHERE SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("#if (${etc1} != '')" ).append("\n"); 
		query.append("    AND OFC_CD IN (${etc1})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SREP_CD" ).append("\n"); 

	}
}