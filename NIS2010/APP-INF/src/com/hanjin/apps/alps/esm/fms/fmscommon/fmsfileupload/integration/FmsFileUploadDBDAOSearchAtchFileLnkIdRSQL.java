/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOSearchAtchFileLnkIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FmsFileUploadDBDAOSearchAtchFileLnkIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일 ID 조회
	  * </pre>
	  */
	public FmsFileUploadDBDAOSearchAtchFileLnkIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration").append("\n"); 
		query.append("FileName : FmsFileUploadDBDAOSearchAtchFileLnkIdRSQL").append("\n"); 
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
		query.append("#if(${vnor_itm_seq} != '')" ).append("\n"); 
		query.append("    SELECT CASE WHEN (" ).append("\n"); 
		query.append("                        SELECT COUNT(D2.ATCH_FILE_FLET_LNK_ID) " ).append("\n"); 
		query.append("                        FROM FMS_VNOR_ITM D2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND D2.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND D2.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("                        AND D2.VNOR_ITM_SEQ = @[vnor_itm_seq]" ).append("\n"); 
		query.append("                     ) > 0 AND F.ATCH_FILE_LNK_ID IS NOT NULL THEN F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("                ELSE (" ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("                           '0090_'|| NVL((SELECT LPAD(MAX(SUBSTR(ATCH_FILE_LNK_ID, 6)) + 1, 5, 0) " ).append("\n"); 
		query.append("                                       FROM FMS_ATCH_FILE " ).append("\n"); 
		query.append("                                      WHERE ATCH_FILE_LNK_ID LIKE '0090%'" ).append("\n"); 
		query.append("                                     ), '00001')  " ).append("\n"); 
		query.append("                        FROM DUAL  " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                END ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("    FROM FMS_VNOR_ITM D, FMS_ATCH_FILE F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND D.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("    AND D.VNOR_ITM_SEQ = @[vnor_itm_seq]" ).append("\n"); 
		query.append("    AND D.ATCH_FILE_FLET_LNK_ID = F.ATCH_FILE_LNK_ID(+)" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT CASE WHEN (" ).append("\n"); 
		query.append("                        SELECT COUNT(D2.ATCH_FILE_FLET_LNK_ID) " ).append("\n"); 
		query.append("                        FROM FMS_BUNKER D2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND D2.FLET_CTRT_NO = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND D2.BNK_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("                     ) > 0 AND F.ATCH_FILE_LNK_ID IS NOT NULL THEN F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("                ELSE (" ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("                           '0050_'|| NVL((SELECT LPAD(MAX(SUBSTR(ATCH_FILE_LNK_ID, 6)) + 1, 5, 0) " ).append("\n"); 
		query.append("                                       FROM FMS_ATCH_FILE " ).append("\n"); 
		query.append("                                      WHERE ATCH_FILE_LNK_ID LIKE '0050%'" ).append("\n"); 
		query.append("                                     ), '00001')  " ).append("\n"); 
		query.append("                        FROM DUAL   " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                END ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("    FROM FMS_BUNKER D, FMS_ATCH_FILE F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND D.FLET_CTRT_NO = @[vsl_cd]" ).append("\n"); 
		query.append("    AND D.BNK_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("    AND D.ATCH_FILE_FLET_LNK_ID = F.ATCH_FILE_LNK_ID(+)" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}