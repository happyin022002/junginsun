/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.04 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkLocation
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL").append("\n"); 
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
		query.append("ROWNUM AS DESC1," ).append("\n"); 
		query.append("A.DESC2," ).append("\n"); 
		query.append("A.DESC3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT EQ_SPEC_NO,MIN(EQ_NO),MAX(EQ_NO),  GR" ).append("\n"); 
		query.append(",MIN(EQ_NO)||'-'|| MAX(EQ_NO) AS DESC2" ).append("\n"); 
		query.append(",COUNT(*) AS DESC3" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EQ_NO ,EQ_SPEC_NO" ).append("\n"); 
		query.append(",TO_NUMBER( SUBSTR( EQ_NO , 5) ) A" ).append("\n"); 
		query.append(",TO_NUMBER( SUBSTR( EQ_NO , 5) ) -ROWNUM GR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append(",EQ_SPEC_NO" ).append("\n"); 
		query.append(",LAG(EQ_NO,1) OVER ( ORDER BY EQ_NO  ) EQ_LAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_SPEC_NO= @[eq_spec_no]" ).append("\n"); 
		query.append("AND EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("ORDER BY EQ_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("EQ_SPEC_NO,GR" ).append("\n"); 
		query.append("ORDER BY DESC2" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}