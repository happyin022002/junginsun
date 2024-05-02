/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchInvSrcNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.12.02 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchInvSrcNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    DOD_DRP_OFF_CHG테이블의 INV_SRC_NO채번
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchInvSrcNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchInvSrcNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[ofc_cd], 1, 3)||'D'||TO_CHAR(SYSDATE, 'YYMMDD')||SUBSTR('00000'|| A.INV_SEQ, LENGTH('00000'|| A.INV_SEQ)-4) AS INV_SRC_NO" ).append("\n"); 
		query.append("  FROM (SELECT MAX(INV_SEQ) INV_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT DECODE(NVL(SUBSTR(MAX(INV_SRC_NO), 11), 0), NULL, 0, NVL(SUBSTR(MAX(INV_SRC_NO), 11), 0)) + 1 INV_SEQ" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG" ).append("\n"); 
		query.append("                 WHERE SUBSTR(INV_SRC_NO, 0, 10) = SUBSTR(@[ofc_cd], 1, 3)||'D'||TO_CHAR(SYSDATE, 'YYMMDD') ) ) A" ).append("\n"); 

	}
}