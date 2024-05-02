/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeRemarkRSQL.java
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

public class GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 별로 기 등록된 Advisory Notice 텍스트 Remark 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeRemarkRSQL(){
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
		params.put("rmk_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_subj_ctnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeRemarkRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",IMPT_NTC_RMK" ).append("\n"); 
		query.append(",EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append(",RMK_USE_FLG" ).append("\n"); 
		query.append(",(SELECT FILE_UPLD_NM FROM COM_UPLD_FILE WHERE FILE_SAV_ID = A.FILE_SAV_ID) FILE_NM" ).append("\n"); 
		query.append(",FILE_PATH_RMK" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",FILE_DESC" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VSL_CD || SKD_VOY_NO VVD" ).append("\n"); 
		query.append(",IMPT_NTC_RMK" ).append("\n"); 
		query.append(",EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append(",RMK_USE_FLG" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_PATH_RMK" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",FILE_DESC" ).append("\n"); 
		query.append("FROM   BKG_CUST_AVC_NTC_RMK" ).append("\n"); 
		query.append("WHERE  VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND    OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rmk_use_flg} != '')" ).append("\n"); 
		query.append("AND	RMK_USE_FLG = @[rmk_use_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eml_subj_ctnt_seq} != '')" ).append("\n"); 
		query.append("AND EML_SUBJ_CTNT_SEQ = @[eml_subj_ctnt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}