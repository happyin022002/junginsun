/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOsearchFtpInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.08.03 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOsearchFtpInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFtpInfo
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOsearchFtpInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOsearchFtpInfoRSQL").append("\n"); 
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
		query.append("SELECT BHCC.ATTR_CTNT1 AS OFC_CD" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT2 AS FTP_ADDR" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT3 AS USER_ID" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT4 AS USER_PW" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT5 AS FILE_TYPE" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT6 AS FTP_PATH" ).append("\n"); 
		query.append("     , NVL(BHCC.ATTR_CTNT7, 'N') AS ZIP_YN" ).append("\n"); 
		query.append("     , TO_CHAR(CASE WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 0 AND 15" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('1501','MISS') - TO_DATE('3000','MISS') )" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 16 AND 30" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('0001','MISS') - TO_DATE('0000','MISS') )" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 31 AND 45" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('1501','MISS') - TO_DATE('0000','MISS') )" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 46 AND 59" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('3001','MISS') - TO_DATE('0000','MISS') )                 " ).append("\n"); 
		query.append("                END, 'YYYYMMDDHH24MISS') AS FROM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(CASE WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 0 AND 15" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24')" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 16 AND 30" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('1500','MISS') - TO_DATE('0000','MISS') )" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 31 AND 45" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('3000','MISS') - TO_DATE('0000','MISS') )" ).append("\n"); 
		query.append("                    WHEN TO_NUMBER(TO_CHAR(SYSDATE,'MI')) BETWEEN 46 AND 59" ).append("\n"); 
		query.append("                        THEN TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD HH24'),'YYYYMMDD HH24') + (TO_DATE('4500','MISS') - TO_DATE('0000','MISS') )                 " ).append("\n"); 
		query.append("                END, 'YYYYMMDDHH24MISS') AS  END_DT" ).append("\n"); 
		query.append("  FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append(" WHERE BHCC.HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 

	}
}