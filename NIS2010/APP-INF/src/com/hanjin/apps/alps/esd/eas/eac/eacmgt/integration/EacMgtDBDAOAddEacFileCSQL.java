/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOAddEacFileCSQL.java
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

public class EacMgtDBDAOAddEacFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC 첨부파일 내역 입력
	  * </pre>
	  */
	public EacMgtDBDAOAddEacFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_cmpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOAddEacFileCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_ATCH_FILE (" ).append("\n"); 
		query.append(" EAC_NO" ).append("\n"); 
		query.append(",EAC_FILE_SEQ" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",EAC_CMPL_CD" ).append("\n"); 
		query.append(",FILE_PATH_DESC" ).append("\n"); 
		query.append(",RGST_OFC_CD" ).append("\n"); 
		query.append(",RGST_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" @[eac_no]" ).append("\n"); 
		query.append(",(	SELECT NVL(MAX(EAC_FILE_SEQ),0)+1" ).append("\n"); 
		query.append("	  FROM EAS_EXPN_AUD_CS_ATCH_FILE" ).append("\n"); 
		query.append("	 WHERE EAC_NO = @[eac_no]" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(",@[file_sav_id]" ).append("\n"); 
		query.append(",@[file_nm]" ).append("\n"); 
		query.append(",@[eac_cmpl_cd]" ).append("\n"); 
		query.append(",(SELECT X.FILE_PATH_URL FROM COM_UPLD_FILE X WHERE X.FILE_SAV_ID = @[file_sav_id])" ).append("\n"); 
		query.append(",@[rgst_ofc_cd]" ).append("\n"); 
		query.append(",GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rgst_ofc_cd])" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}