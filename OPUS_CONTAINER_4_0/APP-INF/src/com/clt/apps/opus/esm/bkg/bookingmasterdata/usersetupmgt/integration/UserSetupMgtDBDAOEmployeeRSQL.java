/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOEmployeeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOEmployeeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Employee 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public UserSetupMgtDBDAOEmployeeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOEmployeeRSQL").append("\n"); 
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
		query.append("SELECT 	BL_ESIG_SEQ AS EMP_CD" ).append("\n"); 
		query.append("       ,ESIG_LST_NM || ',' || ESIG_N1ST_NM AS EMP_NM" ).append("\n"); 
		query.append("FROM	BKG_BL_ESIG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("  AND CNT_CD = @[cnt_cd]		--SJH.20141125.ADD : PARAM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNT_CD ASC " ).append("\n"); 

	}
}