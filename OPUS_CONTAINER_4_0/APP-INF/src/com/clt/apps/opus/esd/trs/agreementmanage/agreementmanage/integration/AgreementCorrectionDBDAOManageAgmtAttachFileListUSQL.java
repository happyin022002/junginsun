/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementCorrectionDBDAOManageAgmtAttachFileListUSQL.java
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

public class AgreementCorrectionDBDAOManageAgmtAttachFileListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_UPLD_FILE의 데이터로 TRS_AGMT_IMG_STO를 UPDATE하는 SQL
	  * </pre>
	  */
	public AgreementCorrectionDBDAOManageAgmtAttachFileListUSQL(){
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
		query.append("FileName : AgreementCorrectionDBDAOManageAgmtAttachFileListUSQL").append("\n"); 
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
		query.append("UPDATE (SELECT IMG.FILE_NM AS IMG_FILE_NM," ).append("\n"); 
		query.append("               IMG.FILE_PATH_RMK AS IMG_FILE_PATH," ).append("\n"); 
		query.append("               UPLD.FILE_UPLD_NM AS UPLD_FILE_NM," ).append("\n"); 
		query.append("               UPLD.FILE_PATH_URL AS UPLD_FILE_PATH" ).append("\n"); 
		query.append("          FROM TRS_AGMT_IMG_STO IMG," ).append("\n"); 
		query.append("               COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("         WHERE IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("           AND IMG.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("           AND IMG.TRSP_AGMT_SEQ = SUBSTR(@[agmt_no], 4))" ).append("\n"); 
		query.append("   SET IMG_FILE_NM = UPLD_FILE_NM," ).append("\n"); 
		query.append("       IMG_FILE_PATH = UPLD_FILE_PATH" ).append("\n"); 

	}
}