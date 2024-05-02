/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchVerifyBkgNORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchVerifyBkgNORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking No 가 존재하는지 확인한다
	  * </pre>
	  */
	public EacMgtDBDAOSearchVerifyBkgNORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchVerifyBkgNORSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNT=0 THEN '0' " ).append("\n"); 
		query.append("            ELSE (SELECT BL_NO " ).append("\n"); 
		query.append("                  FROM   BKG_BOOKING B " ).append("\n"); 
		query.append("                  WHERE  BKG_NO = @[bkg_no]) " ).append("\n"); 
		query.append("       END AS BL_NO" ).append("\n"); 
		query.append("FROM  (SELECT COUNT(BL_NO) CNT" ).append("\n"); 
		query.append("       FROM   BKG_BOOKING B " ).append("\n"); 
		query.append("       WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}