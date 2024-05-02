/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOAddChargeAmendAuthRequestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2015.01.22 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOAddChargeAmendAuthRequestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT이후 운임 승인 권한 요청을 생성한다.
	  * </pre>
	  */
	public BlRatingDBDAOAddChargeAmendAuthRequestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amd_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddChargeAmendAuthRequestCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_AMD_AUTH" ).append("\n"); 
		query.append("(   BKG_NO," ).append("\n"); 
		query.append("    CHG_AMD_SEQ," ).append("\n"); 
		query.append("    CHG_AMD_RSN_CD," ).append("\n"); 
		query.append("    CHG_AMD_RQST_STS_CD," ).append("\n"); 
		query.append("    RQST_OFC_CD," ).append("\n"); 
		query.append("    RQST_USR_ID," ).append("\n"); 
		query.append("    RQST_DT," ).append("\n"); 
		query.append("    APRO_OFC_CD," ).append("\n"); 
		query.append("    APRO_USR_ID," ).append("\n"); 
		query.append("    AUTH_USE_FLG," ).append("\n"); 
		query.append("    CHG_AMD_RMK," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(   @[bkg_no]," ).append("\n"); 
		query.append("    (SELECT  NVL(MAX(CHG_AMD_SEQ),0)+1 " ).append("\n"); 
		query.append("     FROM BKG_CHG_AMD_AUTH " ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]),    " ).append("\n"); 
		query.append("    @[chg_amd_rsn_cd]," ).append("\n"); 
		query.append("    'Q'," ).append("\n"); 
		query.append("    @[rqst_ofc_cd]," ).append("\n"); 
		query.append("    @[rqst_usr_id]," ).append("\n"); 
		query.append("    GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd]),  " ).append("\n"); 
		query.append("    @[apro_ofc_cd]," ).append("\n"); 
		query.append("    @[apro_usr_id]," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    @[chg_amd_rmk]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}