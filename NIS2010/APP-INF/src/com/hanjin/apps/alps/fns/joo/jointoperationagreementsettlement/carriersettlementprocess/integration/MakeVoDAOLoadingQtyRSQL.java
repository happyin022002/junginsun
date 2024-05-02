/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOLoadingQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.02.05 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOLoadingQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOLoadingQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOLoadingQtyRSQL").append("\n"); 
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
		query.append("SELECT  '' VVD" ).append("\n"); 
		query.append(",       '' OFC_CD" ).append("\n"); 
		query.append(",       ''POL_CD" ).append("\n"); 
		query.append(",       ''SKD_DIR_CD" ).append("\n"); 
		query.append(",       ''CLPT_SEQ" ).append("\n"); 
		query.append(",       ''POL_CD_CNT" ).append("\n"); 
		query.append(",       ''HEADER_SQL" ).append("\n"); 
		query.append(",       ''RATEHC" ).append("\n"); 
		query.append(",       ''RATE45" ).append("\n"); 
		query.append(",       ''MT_CNT" ).append("\n"); 
		query.append(",       ''MT_20_CNT" ).append("\n"); 
		query.append(",       ''MT_40_CNT" ).append("\n"); 
		query.append(",       ''MT_HC_CNT" ).append("\n"); 
		query.append(",       ''MT_45_CNT" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}