/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsCommonDBDAOFileAttachAutoAttachFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOFileAttachAutoAttachFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FileAttachAutoAttachFile
	  * </pre>
	  */
	public TrsCommonDBDAOFileAttachAutoAttachFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration ").append("\n"); 
		query.append("FileName : TrsCommonDBDAOFileAttachAutoAttachFileRSQL").append("\n"); 
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
		query.append("SELECT UPLD.FILE_UPLD_NM FILE_NM" ).append("\n"); 
		query.append("      ,CASE WHEN ROUND(ROUND(FILE_SZ_CAPA / 1024) / 1024) > 1 THEN ROUND(ROUND(FILE_SZ_CAPA / 1024) / 1024, 2) || ' MB'" ).append("\n"); 
		query.append("            WHEN ROUND(FILE_SZ_CAPA / 1024) > 0 THEN ROUND(FILE_SZ_CAPA / 1024, 2) || ' KB'" ).append("\n"); 
		query.append("            ELSE FILE_SZ_CAPA || ''" ).append("\n"); 
		query.append("       END || ' Bytes' AS FILE_SIZE" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(FLE.CRE_OFC_CD), 'YYYY-MM-DD HH24:MI:SS') RGST_DT" ).append("\n"); 
		query.append("      ,FLE.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,FLE.ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("      ,FLE.FILE_SAV_ID" ).append("\n"); 
		query.append("      ,UPLD.FILE_PATH_URL" ).append("\n"); 
		query.append("  FROM TRS_ATCH_FILE FLE" ).append("\n"); 
		query.append("     , COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append(" WHERE FLE.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND FLE.ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 

	}
}