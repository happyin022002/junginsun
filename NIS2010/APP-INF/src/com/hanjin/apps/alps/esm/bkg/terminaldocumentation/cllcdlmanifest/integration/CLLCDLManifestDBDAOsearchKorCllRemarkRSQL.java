/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.14 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchKorCllRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKorCllRemark
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllRemarkRSQL").append("\n"); 
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
		query.append("SELECT A.DIFF_RMK TO_DIFF_RMK, B.DIFF_RMK FM_DIFF_RMK, C.DIFF_RMK REMARK_DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_TML_KR_CLL_RMK" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND KR_TML_RMK_TP_ID = 'TO'" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_TML_KR_CLL_RMK" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND KR_TML_RMK_TP_ID = 'FM'" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DIFF_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_TML_KR_CLL_RMK" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[in_vsl_cd]||SUBSTR(@[in_skd_voy_no],2,3)||@[in_skd_dir_cd]||SUBSTR(@[in_pol_cd],3,3)" ).append("\n"); 
		query.append("AND KR_TML_RMK_TP_ID = 'RMK'" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}