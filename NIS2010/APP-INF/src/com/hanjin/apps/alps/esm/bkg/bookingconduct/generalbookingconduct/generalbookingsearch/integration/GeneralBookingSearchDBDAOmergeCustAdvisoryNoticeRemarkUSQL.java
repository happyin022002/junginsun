/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOmergeCustAdvisoryNoticeRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOmergeCustAdvisoryNoticeRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 별 Customer Advisory Remark 정보를 저장한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOmergeCustAdvisoryNoticeRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("impt_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmk_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_subj_ctnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOmergeCustAdvisoryNoticeRemarkUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CUST_AVC_NTC_RMK A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT  SUBSTR(@[vvd], 1,4) AS VSL_CD" ).append("\n"); 
		query.append(", SUBSTR(@[vvd], 5,4) AS SKD_VOY_NO" ).append("\n"); 
		query.append(", SUBSTR(@[vvd], 9,1) AS SKD_DIR_CD" ).append("\n"); 
		query.append(", @[ofc_cd]           AS OFC_CD" ).append("\n"); 
		query.append(", @[impt_ntc_rmk]     AS IMPT_NTC_RMK" ).append("\n"); 
		query.append(", 'N'                 AS DELT_FLG" ).append("\n"); 
		query.append(", @[cre_usr_id]       AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]       AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append(", @[eml_subj_ctnt]    AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append(", 'E'				 AS SRC_DAT_TP_CD" ).append("\n"); 
		query.append(", @[eml_subj_ctnt_seq]	AS EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append(", @[rmk_use_flg]			AS RMK_USE_FLG" ).append("\n"); 
		query.append(", NULL				 AS FILE_NM" ).append("\n"); 
		query.append(", @[file_path_rmk] 	 AS FILE_PATH_RMK" ).append("\n"); 
		query.append(", NULL				 AS FILE_SAV_ID" ).append("\n"); 
		query.append(", NULL				 AS FILE_DESC" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.SRC_DAT_TP_CD = B.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.EML_SUBJ_CTNT_SEQ = B.EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("#if (${btn_type} != 'select')" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    IMPT_NTC_RMK  = B.IMPT_NTC_RMK" ).append("\n"); 
		query.append(",EML_SUBJ_CTNT = B.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",RMK_USE_FLG = NVL(B.RMK_USE_FLG, 'N')" ).append("\n"); 
		query.append(",FILE_PATH_RMK	= B.FILE_PATH_RMK" ).append("\n"); 
		query.append(",UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    RMK_USE_FLG = NVL(B.RMK_USE_FLG, 'N')" ).append("\n"); 
		query.append(",UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT VALUES(   B.VSL_CD" ).append("\n"); 
		query.append(", B.SKD_VOY_NO" ).append("\n"); 
		query.append(", B.SKD_DIR_CD" ).append("\n"); 
		query.append(", B.OFC_CD" ).append("\n"); 
		query.append(", B.IMPT_NTC_RMK" ).append("\n"); 
		query.append(", B.DELT_FLG" ).append("\n"); 
		query.append(", B.CRE_USR_ID" ).append("\n"); 
		query.append(", B.CRE_DT" ).append("\n"); 
		query.append(", B.UPD_USR_ID" ).append("\n"); 
		query.append(", B.UPD_DT" ).append("\n"); 
		query.append(", B.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(", B.SRC_DAT_TP_CD" ).append("\n"); 
		query.append(", B.EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append(", NVL(B.RMK_USE_FLG, 'N')" ).append("\n"); 
		query.append(", B.FILE_NM" ).append("\n"); 
		query.append(", B.FILE_PATH_RMK" ).append("\n"); 
		query.append(", B.FILE_SAV_ID" ).append("\n"); 
		query.append(", B.FILE_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}