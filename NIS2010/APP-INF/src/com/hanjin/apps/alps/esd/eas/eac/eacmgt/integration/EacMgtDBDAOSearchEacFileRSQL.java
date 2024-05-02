/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacFileRSQL.java
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

public class EacMgtDBDAOSearchEacFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC 첨부파일 리스트 조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacFileRSQL").append("\n"); 
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
		query.append("SELECT FLE.EAC_CMPL_CD" ).append("\n"); 
		query.append("      ,FLE.FILE_NM" ).append("\n"); 
		query.append("      ,CASE WHEN ROUND(ROUND(FILE_SZ_CAPA / 1024) / 1024) > 0 THEN ROUND(ROUND(FILE_SZ_CAPA / 1024) / 1024, 2) || ' MB'" ).append("\n"); 
		query.append("            WHEN ROUND(FILE_SZ_CAPA / 1024) > 0 THEN ROUND(FILE_SZ_CAPA / 1024, 2) || ' KB'" ).append("\n"); 
		query.append("            ELSE FILE_SZ_CAPA || ''" ).append("\n"); 
		query.append("       END || ' Bytes' AS FILE_SIZE" ).append("\n"); 
		query.append("      ,TO_CHAR(FLE.RGST_DT, 'YYYY-MM-DD HH24:MI:SS') RGST_DT" ).append("\n"); 
		query.append("      ,FLE.EAC_NO" ).append("\n"); 
		query.append("      ,FLE.EAC_FILE_SEQ" ).append("\n"); 
		query.append("      ,FLE.FILE_SAV_ID" ).append("\n"); 
		query.append("      ,FLE.FILE_PATH_DESC" ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_ATCH_FILE FLE" ).append("\n"); 
		query.append("     , COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append(" WHERE FLE.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND FLE.EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}