/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchAcitivityByPortTimeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchAcitivityByPortTimeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Time Activity 탭페이지의 Grid에 표시할 정보를 조회 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchAcitivityByPortTimeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchAcitivityByPortTimeListRSQL").append("\n"); 
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
		query.append("SELECT  (" ).append("\n"); 
		query.append("        SELECT  S.ACT_GEN_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM    OPF_GEN_CD_DTL S" ).append("\n"); 
		query.append("        WHERE   S.ACT_GEN_CD_ID       = 'CD00004'" ).append("\n"); 
		query.append("        AND     S.ACT_GEN_CD_VAL_CTNT = T.ACT_GEN_CD_GRP_ID" ).append("\n"); 
		query.append("        )                   AS PORT_ACT_GRP_DESC" ).append("\n"); 
		query.append("      , ACT_GEN_CD_VAL_CTNT AS PORT_ACT_CTNT" ).append("\n"); 
		query.append("      , ACT_GEN_CD_VAL_DESC AS PORT_ACT_DESC" ).append("\n"); 
		query.append("FROM    OPF_GEN_CD_DTL T" ).append("\n"); 
		query.append("WHERE   ACT_GEN_CD_ID   = 'CD00001'" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}