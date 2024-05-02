/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchBisMonitorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.27 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchBisMonitorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLInformationMgtDBDAOSearchBisMonitorList
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchBisMonitorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchBisMonitorListRSQL").append("\n"); 
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
		query.append("#if(${type} == 'VO')" ).append("\n"); 
		query.append("/* BisMonitorList */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	'' KEY_DATE," ).append("\n"); 
		query.append("	'' NIS_BKG_CNT," ).append("\n"); 
		query.append("	'' NIS_CORR_CNT," ).append("\n"); 
		query.append("	'' CK_FLG," ).append("\n"); 
		query.append("	'' BIS_BKG_CNT," ).append("\n"); 
		query.append("	'' BIS_CORR_CNT," ).append("\n"); 
		query.append("	'' CRE_DT," ).append("\n"); 
		query.append("	'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    BKG_BIS_IF_DT AS KEY_DATE," ).append("\n"); 
		query.append("    NEW_BKG_CRE_KNT AS NIS_BKG_CNT," ).append("\n"); 
		query.append("    NEW_CORR_KNT AS NIS_CORR_CNT," ).append("\n"); 
		query.append("    BKG_BIS_IF_FLG AS CK_FLG," ).append("\n"); 
		query.append("    BIS_BKG_CRE_KNT AS BIS_BKG_CNT," ).append("\n"); 
		query.append("    BIS_CORR_CRE_KNT AS BIS_CORR_CNT," ).append("\n"); 
		query.append("    CRE_DT AS CRE_DT," ).append("\n"); 
		query.append("    UPD_DT AS UPD_DT" ).append("\n"); 
		query.append("FROM BIS_IF_MNTR " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_BIS_IF_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}