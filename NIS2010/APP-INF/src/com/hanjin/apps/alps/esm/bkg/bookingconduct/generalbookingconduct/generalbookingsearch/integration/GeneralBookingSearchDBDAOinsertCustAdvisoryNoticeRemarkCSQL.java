/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL.java
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

public class GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 별 Customer Advisory Remark 정보를 저장한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_AVC_NTC_RMK (" ).append("\n"); 
		query.append("                   VSL_CD" ).append("\n"); 
		query.append("                 , SKD_VOY_NO" ).append("\n"); 
		query.append("                 , SKD_DIR_CD" ).append("\n"); 
		query.append("                 , OFC_CD" ).append("\n"); 
		query.append("                 , IMPT_NTC_RMK" ).append("\n"); 
		query.append("                 , DELT_FLG" ).append("\n"); 
		query.append("                 , CRE_USR_ID    " ).append("\n"); 
		query.append("                 , CRE_DT" ).append("\n"); 
		query.append("                 , UPD_USR_ID" ).append("\n"); 
		query.append("                 , UPD_DT" ).append("\n"); 
		query.append("                 , EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                 , SRC_DAT_TP_CD" ).append("\n"); 
		query.append("                 , EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append("                 , RMK_USE_FLG" ).append("\n"); 
		query.append("                 , FILE_NM" ).append("\n"); 
		query.append("                 , FILE_PATH_RMK" ).append("\n"); 
		query.append("                 , FILE_SAV_ID" ).append("\n"); 
		query.append("                 , FILE_DESC)           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES( " ).append("\n"); 
		query.append("                SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("               , SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("               , SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("               , @[ofc_cd]          " ).append("\n"); 
		query.append("               , @[impt_ntc_rmk]    " ).append("\n"); 
		query.append("               , 'N'                " ).append("\n"); 
		query.append("               , @[cre_usr_id]      " ).append("\n"); 
		query.append("               , SYSDATE            " ).append("\n"); 
		query.append("               , @[upd_usr_id]      " ).append("\n"); 
		query.append("               , SYSDATE            " ).append("\n"); 
		query.append("               , @[eml_subj_ctnt]   " ).append("\n"); 
		query.append("               , 'E'                                   " ).append("\n"); 
		query.append("               , @[eml_subj_ctnt_seq]" ).append("\n"); 
		query.append("               , NVL(@[rmk_use_flg],'N')               " ).append("\n"); 
		query.append("               , NULL                                          " ).append("\n"); 
		query.append("               , @[file_path_rmk]      " ).append("\n"); 
		query.append("               , NULL                                          " ).append("\n"); 
		query.append("               , NVL(@[file_desc], 'N')                                          " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}