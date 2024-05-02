/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MotFilingLocationPropertyDBDAOPriMotFileLocPptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MotFilingLocationPropertyDBDAOPriMotFileLocPptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MotFilingLocationPropertyDBDAOPriMotFileLocPptVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.integration").append("\n"); 
		query.append("FileName : MotFilingLocationPropertyDBDAOPriMotFileLocPptVORSQL").append("\n"); 
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
		query.append("SELECT  A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    ,   A.LOC_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_LOC_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_LOC_NM" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("    ,   DECODE(A.DELT_FLG, 'N', '0', 'Y', '1') AS DELT_FLG" ).append("\n"); 
		query.append("    ,   A.CRE_USR_ID" ).append("\n"); 
		query.append("    ,   TO_CHAR ( A.CRE_DT, 'YYYY-MM-DD' ) AS CRE_DT" ).append("\n"); 
		query.append("    ,   A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,   TO_CHAR ( A.UPD_DT, 'YYYY-MM-DD' ) AS UPD_DT           " ).append("\n"); 
		query.append("FROM    PRI_MOT_FILE_LOC_PPT A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${delt_flg} == '')" ).append("\n"); 
		query.append("-- AND     A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER   BY A.ORG_DEST_TP_CD DESC, A.LOC_CD ASC" ).append("\n"); 

	}
}