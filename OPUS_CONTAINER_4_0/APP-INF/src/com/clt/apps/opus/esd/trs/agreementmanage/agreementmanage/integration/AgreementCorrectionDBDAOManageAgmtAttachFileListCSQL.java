/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementCorrectionDBDAOManageAgmtAttachFileListCSQL.java
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

public class AgreementCorrectionDBDAOManageAgmtAttachFileListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_AGMT_IMG_STO에 신규 ROW를 INSERT하는 SQL
	  * </pre>
	  */
	public AgreementCorrectionDBDAOManageAgmtAttachFileListCSQL(){
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
		params.put("file_path_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOManageAgmtAttachFileListCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_IMG_STO (" ).append("\n"); 
		query.append("    TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("    IMG_SEQ," ).append("\n"); 
		query.append("    FILE_NM," ).append("\n"); 
		query.append("    FILE_PATH_RMK," ).append("\n"); 
		query.append("    FILE_SAV_ID," ).append("\n"); 
		query.append("    RGST_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("    SUBSTR(@[agmt_no], 1, 3)," ).append("\n"); 
		query.append("    SUBSTR(@[agmt_no], 4)," ).append("\n"); 
		query.append("    (SELECT NVL(MAX(IMG_SEQ), 0) + 1" ).append("\n"); 
		query.append("       FROM TRS_AGMT_IMG_STO" ).append("\n"); 
		query.append("      WHERE TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[agmt_no], 1, 3)" ).append("\n"); 
		query.append("        AND TRSP_AGMT_SEQ = SUBSTR(@[agmt_no], 4))," ).append("\n"); 
		query.append("    @[file_nm]," ).append("\n"); 
		query.append("    @[file_path_rmk]," ).append("\n"); 
		query.append("    @[file_sav_id]," ).append("\n"); 
		query.append("    @[rgst_ofc_cd]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    sysdate," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}