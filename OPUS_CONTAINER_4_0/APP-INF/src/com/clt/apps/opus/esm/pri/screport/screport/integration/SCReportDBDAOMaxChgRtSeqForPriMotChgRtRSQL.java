/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOMaxChgRtSeqForPriMotChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOMaxChgRtSeqForPriMotChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrive max charge rate seq
	  * </pre>
	  */
	public SCReportDBDAOMaxChgRtSeqForPriMotChgRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOMaxChgRtSeqForPriMotChgRtRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CHG_RT_SEQ),0) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("  FROM PRI_MOT_CHG_RT" ).append("\n"); 
		query.append(" WHERE CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND POL_CD = @[pol_cd]" ).append("\n"); 

	}
}