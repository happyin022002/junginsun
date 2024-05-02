/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonDBDAOSearchLocationPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.28 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchLocationPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port 코드조회
	  * </pre>
	  */
	public LseCommonDBDAOSearchLocationPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchLocationPortRSQL").append("\n"); 
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
		query.append("SELECT  T1.LOC_CD, T1.SCC_CD, T1.LOC_NM, T1.VOP_PORT_FLG" ).append("\n"); 
		query.append("FROM    MDM_LOCATION T1," ).append("\n"); 
		query.append("MDM_COUNTRY T2" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     T1.CNT_CD=T2.CNT_CD" ).append("\n"); 
		query.append("AND     T1.CALL_PORT_FLG='Y'" ).append("\n"); 
		query.append("AND     T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     T1.LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}