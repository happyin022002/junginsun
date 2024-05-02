/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGInternalFinderDBDAOCheckUNNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.03.12 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOCheckUNNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkUNNumber 및 조회한다.
	  * </pre>
	  */
	public SCGInternalFinderDBDAOCheckUNNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOCheckUNNumberRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	IMDG_UN_NO " ).append("\n"); 
		query.append(",	MAX(IMDG_UN_NO_SEQ)+1 AS IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append(",	MAX(IMDG_UN_NO_SEQ) AS IMDG_UN_NO_SEQ_MAX " ).append("\n"); 
		query.append(",	MIN(IMDG_UN_NO_SEQ) AS IMDG_UN_NO_SEQ_MIN " ).append("\n"); 
		query.append(",	COUNT(IMDG_UN_NO_SEQ) AS IMDG_UN_NO_SEQ_CNT" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT') AS UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("GROUP BY IMDG_UN_NO" ).append("\n"); 

	}
}