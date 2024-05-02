/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAORsltSrepByOfcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.13 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSrepByOfcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRICommonDBDAORsltSrepByOfcListVORSQL
	  * </pre>
	  */
	public PRICommonDBDAORsltSrepByOfcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSrepByOfcListVORSQL").append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("    OFC_CD = @[etc1]" ).append("\n"); 
		query.append("AND SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("ORDER BY SREP_CD" ).append("\n"); 

	}
}