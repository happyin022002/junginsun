/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.01.20 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL(){
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
		query.append("FileName : EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL").append("\n"); 
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
		query.append("     , TO_CHAR(LDFH.BKG_FM_DT, 'YYYYMMDDHH24MISS') AS FROM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(LDFH.BKG_TO_DT, 'YYYYMMDDHH24MISS') AS  END_DT" ).append("\n"); 
		query.append("     , LDFH.FILE_DL_NM" ).append("\n"); 
		query.append("     --, SUBSTR(LDFH.FILE_DL_NM, 5, 4) AS FILE_SEQ" ).append("\n"); 
		query.append("	 , SUBSTR(REPLACE(LDFH.FILE_DL_NM, '.TXT', ''), -4) AS FILE_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(LDFH.LDF_DL_DT, 'YYYYMMDDHH24MISS') AS LDF_DL_DT" ).append("\n"); 
		query.append("  FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("     , BKG_LOD_FCTR_DL_LOG_HDR LDFH" ).append("\n"); 
		query.append(" WHERE BHCC.ATTR_CTNT1 = LDFH.BKG_OFC_CD" ).append("\n"); 
		query.append("   AND BHCC.HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("   AND LDFH.FILE_DL_FLG = 'R'" ).append("\n"); 

	}
}