/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOSegregationSimulationInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.10.28 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOSegregationSimulationInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOSegregationSimulationInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOSegregationSimulationInputVORSQL").append("\n"); 
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
		query.append("'' SEL_CHK" ).append("\n"); 
		query.append(", '' LQ_CHK" ).append("\n"); 
		query.append(", '' EQ_CHK" ).append("\n"); 
		query.append(", '' IMDG_UN_NO" ).append("\n"); 
		query.append(", '' IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(", '' IMDG_CLSS_CD" ).append("\n"); 
		query.append(", '' IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(", '' IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append(", '' PRP_SHP_NM" ).append("\n"); 
		query.append(", '' IMDG_TEC_NM" ).append("\n"); 
		query.append(", '' IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(", '' IMDG_LMT_QTY" ).append("\n"); 
		query.append(", '' IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}