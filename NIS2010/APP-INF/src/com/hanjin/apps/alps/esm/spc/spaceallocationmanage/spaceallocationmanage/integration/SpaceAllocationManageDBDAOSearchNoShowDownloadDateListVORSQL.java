/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL").append("\n"); 
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
		query.append("SELECT T.BSE_YRMON," ).append("\n"); 
		query.append("       SUBSTR(T.BSE_YRMON, 5) AS BSE_MON," ).append("\n"); 
		query.append("       T.DWN_LOD_DY, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(T.BSE_YRMON, 'YYYYMM'), 'D') - 1 AS SWEEK," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(T.BSE_YRMON||T.DWN_LOD_DY, 'YYYYMMDD'), 'D') - 1 AS WEEK," ).append("\n"); 
		query.append("       31 - TO_CHAR(LAST_DAY(TO_DATE(T.BSE_YRMON, 'YYYYMM')), 'DD')     AS DAYS," ).append("\n"); 
		query.append("       TO_CHAR(T.EXE_DT, 'YYYY/MM/DD HH24:MI') AS EXE_DT" ).append("\n"); 
		query.append("  FROM SPC_FCAST_DWN_LOD_SKD t" ).append("\n"); 
		query.append(" WHERE T.BSE_YRMON LIKE @[year]||'%'" ).append("\n"); 

	}
}