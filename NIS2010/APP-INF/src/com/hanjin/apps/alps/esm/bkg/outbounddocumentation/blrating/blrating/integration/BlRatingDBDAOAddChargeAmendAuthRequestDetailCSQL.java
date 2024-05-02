/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOAddChargeAmendAuthRequestDetailCSQL.java
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

public class BlRatingDBDAOAddChargeAmendAuthRequestDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT이후 운임 승인 권한 요청을 생성한다.
	  * </pre>
	  */
	public BlRatingDBDAOAddChargeAmendAuthRequestDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amd_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddChargeAmendAuthRequestDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_AMD_AUTH_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    CHG_AMD_SEQ," ).append("\n"); 
		query.append("    CHG_RT_SEQ," ).append("\n"); 
		query.append("    CHG_CD," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    RAT_UT_CD," ).append("\n"); 
		query.append("    CRNT_CHG_AMT," ).append("\n"); 
		query.append("    AMD_CHG_AMT," ).append("\n"); 
		query.append("    DIFF_CHG_AMT," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[bkg_no]," ).append("\n"); 
		query.append("    (SELECT MAX(CHG_AMD_SEQ)" ).append("\n"); 
		query.append("     FROM BKG_CHG_AMD_AUTH" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("    (SELECT  NVL(MAX(CHG_RT_SEQ),0)+1 " ).append("\n"); 
		query.append("     FROM BKG_CHG_AMD_AUTH_DTL" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ)" ).append("\n"); 
		query.append("                        FROM BKG_CHG_AMD_AUTH" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]))," ).append("\n"); 
		query.append("    @[chg_cd]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[rat_ut_cd]," ).append("\n"); 
		query.append("    @[crnt_chg_amt]," ).append("\n"); 
		query.append("    @[amd_chg_amt]," ).append("\n"); 
		query.append("    @[diff_chg_amt]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}