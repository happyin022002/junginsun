/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.23 
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

public class GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateCustAdvisoryNoticeRemark
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_subj_ctnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmk_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_path_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUST_AVC_NTC_RMK A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${btn_type} != 'select')" ).append("\n"); 
		query.append("  SET    IMPT_NTC_RMK  =  @[impt_ntc_rmk]" ).append("\n"); 
		query.append("	    ,EML_SUBJ_CTNT = @[eml_subj_ctnt] " ).append("\n"); 
		query.append("        ,RMK_USE_FLG = NVL(@[rmk_use_flg], 'N')" ).append("\n"); 
		query.append("		,FILE_PATH_RMK	= @[file_path_rmk]" ).append("\n"); 
		query.append("        ,UPD_USR_ID = @[upd_usr_id] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  SET    RMK_USE_FLG = NVL(@[rmk_use_flg], 'N')" ).append("\n"); 
		query.append("        ,UPD_USR_ID = @[upd_usr_id] " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	,FILE_DESC = NVL(@[file_desc], 'N')" ).append("\n"); 
		query.append("    WHERE A.SRC_DAT_TP_CD = 'E'" ).append("\n"); 
		query.append("	AND A.VSL_CD =  SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO =  SUBSTR(@[vvd], 5,4) " ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD =  SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("	AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    AND A.EML_SUBJ_CTNT_SEQ = @[eml_subj_ctnt_seq]" ).append("\n"); 

	}
}