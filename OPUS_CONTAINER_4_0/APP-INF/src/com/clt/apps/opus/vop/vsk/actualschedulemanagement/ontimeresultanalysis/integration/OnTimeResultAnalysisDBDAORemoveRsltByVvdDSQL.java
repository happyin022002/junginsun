/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.10.13 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Result 정보를 삭제합니다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAORemoveRsltByVvdDSQL").append("\n"); 
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
		query.append("DELETE FROM VSK_VSL_SKD_RSLT" ).append("\n"); 
		query.append("WHERE VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO=@[voy_no]" ).append("\n"); 
		query.append("AND SUB_TRD_DIR_CD=@[dir_cd]" ).append("\n"); 

	}
}