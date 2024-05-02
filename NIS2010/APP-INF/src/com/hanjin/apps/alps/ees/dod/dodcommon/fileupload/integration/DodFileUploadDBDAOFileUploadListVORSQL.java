/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAOFileUploadListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.08 손진환
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

public class DodFileUploadDBDAOFileUploadListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DOD Charge에 각 해당하는 첨부파일 목록을 가져온다.
	  * </pre>
	  */
	public DodFileUploadDBDAOFileUploadListVORSQL(){
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
		query.append("FileName : DodFileUploadDBDAOFileUploadListVORSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(F XPKDOD_ATCH_FILE) */" ).append("\n"); 
		query.append("       F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,F.ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("      ,F.FILE_SAV_ID" ).append("\n"); 
		query.append("      ,C.FILE_PATH_URL " ).append("\n"); 
		query.append("      ,C.FILE_UPLD_NM" ).append("\n"); 
		query.append("      ,TO_CHAR (F.UPD_DT, 'YYYY-MM-DD') UPD_DT  " ).append("\n"); 
		query.append("      ,F.UPD_USR_ID" ).append("\n"); 
		query.append("	  ,'0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("  FROM DOD_DRP_OFF_CHG D, DOD_ATCH_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND D.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND D.DRP_OFF_CHG_SEQ = @[drp_off_chg_seq]" ).append("\n"); 
		query.append("   AND D.ATCH_FILE_LNK_ID = F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("   AND F.FILE_SAV_ID  = C.FILE_SAV_ID" ).append("\n"); 

	}
}