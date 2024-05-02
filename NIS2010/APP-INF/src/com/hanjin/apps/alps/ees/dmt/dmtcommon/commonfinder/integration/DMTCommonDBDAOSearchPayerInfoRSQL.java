/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAOSearchPayerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.04.27 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchPayerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payer 정보가 DMT_PAYR_INFO 테이블에 존재하는지 확인한다.(Y/N)
	  * </pre>
	  */
	public DMTCommonDBDAOSearchPayerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchPayerInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(CUST_SEQ), 0, 'N', 'Y') PAYR_FLG" ).append("\n"); 
		query.append("FROM   DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("WHERE  SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND    CUST_CNT_CD = CASE" ).append("\n"); 
		query.append("         WHEN LENGTH(@[payr_cd]) = 6 THEN '00'" ).append("\n"); 
		query.append("         ELSE SUBSTR(@[payr_cd], 0, 2)" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("AND    CUST_SEQ = CASE" ).append("\n"); 
		query.append("         WHEN LENGTH(@[payr_cd]) = 6 THEN TO_NUMBER(@[payr_cd])" ).append("\n"); 
		query.append("         ELSE TO_NUMBER(SUBSTR(@[payr_cd], 3))" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("AND    PAYR_CNTC_PNT_EML IS NOT NULL" ).append("\n"); 

	}
}