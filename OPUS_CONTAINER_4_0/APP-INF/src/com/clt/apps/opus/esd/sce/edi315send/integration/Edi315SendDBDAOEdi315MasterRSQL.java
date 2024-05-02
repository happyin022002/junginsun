/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315MasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.08 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315MasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for edi315master
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315MasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315MasterRSQL").append("\n"); 
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
		query.append("''CNTR_TPSZ_CD," ).append("\n"); 
		query.append("''COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("''TRUNK_VVD," ).append("\n"); 
		query.append("''COP_STS_CD," ).append("\n"); 
		query.append("''POR_NOD_CD," ).append("\n"); 
		query.append("''POL_NOD_CD," ).append("\n"); 
		query.append("''POD_NOD_CD," ).append("\n"); 
		query.append("''DEL_NOD_CD," ).append("\n"); 
		query.append("''POR_CD," ).append("\n"); 
		query.append("''POL_CD," ).append("\n"); 
		query.append("''POD_CD," ).append("\n"); 
		query.append("''DEL_CD," ).append("\n"); 
		query.append("''SC_NO," ).append("\n"); 
		query.append("''BL_TP_CD," ).append("\n"); 
		query.append("''TO_VSL," ).append("\n"); 
		query.append("''TO_VOYAGE," ).append("\n"); 
		query.append("''TO_DIR," ).append("\n"); 
		query.append("''PRE_RLY," ).append("\n"); 
		query.append("''POST_RLY," ).append("\n"); 
		query.append("''BKG_CRE_TP_CD," ).append("\n"); 
		query.append("''ORG_CONTI," ).append("\n"); 
		query.append("''DEST_CONTI," ).append("\n"); 
		query.append("''RCV_TERM_CD," ).append("\n"); 
		query.append("''DE_TERM_CD," ).append("\n"); 
		query.append("''DCGO_FLG," ).append("\n"); 
		query.append("''vsl_nm," ).append("\n"); 
		query.append("''vsl_cnt_cd," ).append("\n"); 
		query.append("''lloyd_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}