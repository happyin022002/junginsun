/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementCorrectionDBDAOSearchAgmtAttachFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.06
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.10.06 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOSearchAgmtAttachFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Attach File List를 가져오는 SQL
	  * </pre>
	  */
	public AgreementCorrectionDBDAOSearchAgmtAttachFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOSearchAgmtAttachFileListRSQL").append("\n"); 
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
		query.append("SELECT IMG.TRSP_AGMT_OFC_CTY_CD||IMG.TRSP_AGMT_SEQ AS AGMT_NO," ).append("\n"); 
		query.append("       IMG.IMG_SEQ AS IMG_SEQ," ).append("\n"); 
		query.append("       IMG.FILE_NM AS FILE_NM," ).append("\n"); 
		query.append("       UPLD.FILE_SZ_CAPA AS FILE_SIZE," ).append("\n"); 
		query.append("       IMG.FILE_PATH_RMK AS FILE_PATH_RMK," ).append("\n"); 
		query.append("       IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("  FROM TRS_AGMT_IMG_STO IMG," ).append("\n"); 
		query.append("       COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append(" WHERE IMG.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("   AND IMG.TRSP_AGMT_SEQ = SUBSTR(@[agmt_no], 4)" ).append("\n"); 
		query.append("   AND IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 

	}
}