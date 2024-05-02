/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAOSearchAtchFileLnkIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.13 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodFileUploadDBDAOSearchAtchFileLnkIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일 ID 조회
	  * </pre>
	  */
	public DodFileUploadDBDAOSearchAtchFileLnkIdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration").append("\n"); 
		query.append("FileName : DodFileUploadDBDAOSearchAtchFileLnkIdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN (" ).append("\n"); 
		query.append("                SELECT COUNT(D2.ATCH_FILE_LNK_ID) " ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG D2" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND D2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND D2.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND D2.DRP_OFF_CHG_SEQ = @[drp_off_chg_seq]" ).append("\n"); 
		query.append("                ) > 0 " ).append("\n"); 
		query.append("            THEN " ).append("\n"); 
		query.append("                F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("            ELSE (" ).append("\n"); 
		query.append("                SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')|| (SELECT LPAD(COUNT(1)+1,5,0) FROM (SELECT DISTINCT ATCH_FILE_LNK_ID FROM DOD_ATCH_FILE WHERE SUBSTR(ATCH_FILE_LNK_ID, 0, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD')) A) " ).append("\n"); 
		query.append("                  FROM DUAL  " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        END ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("   FROM DOD_DRP_OFF_CHG D, DOD_ATCH_FILE F" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("	AND D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND D.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    AND D.DRP_OFF_CHG_SEQ = @[drp_off_chg_seq]" ).append("\n"); 
		query.append("    AND D.ATCH_FILE_LNK_ID = F.ATCH_FILE_LNK_ID(+)" ).append("\n"); 

	}
}