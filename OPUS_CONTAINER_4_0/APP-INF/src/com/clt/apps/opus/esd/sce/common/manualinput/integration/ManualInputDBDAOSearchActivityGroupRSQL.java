/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSearchActivityGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSearchActivityGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActivityGroup
	  * </pre>
	  */
	public ManualInputDBDAOSearchActivityGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSearchActivityGroupRSQL").append("\n"); 
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
		query.append("SELECT NOD_TP_CD" ).append("\n"); 
		query.append("     , BKG_TERM_CD" ).append("\n"); 
		query.append("     , BFR_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , AFT_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , TRSP_BND_CD" ).append("\n"); 
		query.append("     , SPCL_NOD_TP_CD" ).append("\n"); 
		query.append("     , COP_DTL_GRP_CD" ).append("\n"); 
		query.append("     , (REPLACE(NOD_TP_CD,'*','A')||(REPLACE(BKG_TERM_CD,'*','A'))||(SUBSTR(BFR_TRSP_MOD_CD,1,1))||(SUBSTR(AFT_TRSP_MOD_CD,1,1))||TRSP_BND_CD||(REPLACE((SUBSTR(SPCL_NOD_TP_CD,1,1)),'P','D'))) AS COP_DTL_GRP_CD_COMBO" ).append("\n"); 
		query.append("	 , '' AS COMBO_DUMMY_COL" ).append("\n"); 
		query.append("FROM SCE_ACT_GRP" ).append("\n"); 
		query.append("ORDER BY NOD_TP_CD, BKG_TERM_CD, BFR_TRSP_MOD_CD" ).append("\n"); 

	}
}