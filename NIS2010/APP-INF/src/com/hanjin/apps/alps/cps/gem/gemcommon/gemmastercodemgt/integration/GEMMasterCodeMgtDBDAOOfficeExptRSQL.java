/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOOfficeExptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.05 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOOfficeExptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_Office_Expt에서 조회되는 VO를 생성
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOOfficeExptRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' SND_OFC_CD" ).append("\n"); 
		query.append(",'' RCV_OFC_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_CD_GRP" ).append("\n"); 
		query.append(",'' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_NM" ).append("\n"); 
		query.append(",'' DELT_FLG" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append("FROM   dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration ").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOOfficeExptRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}