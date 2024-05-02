/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceMgtDBDAOinsertThumbnailInformationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.10.12 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOinsertThumbnailInformationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R 모듈에서 이미지 첨부파일 등록시, Thumbnail에 대한 정보를 저장한다.
	  * </pre>
	  */
	public InterfaceMgtDBDAOinsertThumbnailInformationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_path_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thm_file_path_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOinsertThumbnailInformationCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO MNR_FILE_ATCH_EXTR (" ).append("\n"); 
		query.append("    FILE_SEQ, " ).append("\n"); 
		query.append("    FILE_DTL_SEQ, " ).append("\n"); 
		query.append("    FILE_DTL_EXTR_SEQ, " ).append("\n"); 
		query.append("    FILE_PATH_NM, " ).append("\n"); 
		query.append("    THM_FILE_PATH_NM, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    @[file_seq]," ).append("\n"); 
		query.append("    @[file_dtl_seq]," ).append("\n"); 
		query.append("    (SELECT NVL(MAX(FILE_DTL_EXTR_SEQ), 0) + 1 FROM MNR_FILE_ATCH_EXTR WHERE FILE_SEQ = @[file_seq] AND FILE_DTL_SEQ = @[file_dtl_seq])," ).append("\n"); 
		query.append("    @[file_path_nm]," ).append("\n"); 
		query.append("    @[thm_file_path_nm]," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate, " ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}