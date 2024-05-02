/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltConvVslSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.10.13 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltConvVslSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SKD for Conversation
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltConvVslSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltConvVslSkdRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.VSL_SLAN_CD	SLAN_CD" ).append("\n"); 
		query.append(",B.VPS_PORT_CD" ).append("\n"); 
		query.append(",B.CLPT_SEQ" ).append("\n"); 
		query.append(",B.VPS_ETA_DT" ).append("\n"); 
		query.append(",B.VPS_ETB_DT" ).append("\n"); 
		query.append(",B.VPS_ETD_DT" ).append("\n"); 
		query.append(",B.PF_ETA_DT" ).append("\n"); 
		query.append(",B.PF_ETB_DT" ).append("\n"); 
		query.append(",B.PF_ETD_DT" ).append("\n"); 
		query.append(",B.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",B.INIT_ETA_DT" ).append("\n"); 
		query.append(",B.INIT_ETB_DT" ).append("\n"); 
		query.append(",B.INIT_ETD_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_SKD A" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    B.TURN_PORT_IND_CD NOT IN ('V', 'D')" ).append("\n"); 
		query.append("AND    A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY B.CLPT_SEQ" ).append("\n"); 

	}
}