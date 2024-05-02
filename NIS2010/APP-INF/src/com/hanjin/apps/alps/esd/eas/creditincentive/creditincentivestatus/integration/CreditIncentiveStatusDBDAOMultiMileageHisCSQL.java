/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOMultiMileageHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.16 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOMultiMileageHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mileage History Save
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOMultiMileageHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csh_bak_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csh_bak_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlg_pnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlg_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlg_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_n2nd_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csh_bak_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOMultiMileageHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_BNF_MLG_HIS(" ).append("\n"); 
		query.append("	   BSE_YR" ).append("\n"); 
		query.append("      ,INCNT_NO" ).append("\n"); 
		query.append("      ,INCNT_HIS_SEQ" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,TEAM_NM" ).append("\n"); 
		query.append("      ,BANK_NM" ).append("\n"); 
		query.append("      ,MLG_FM_DT" ).append("\n"); 
		query.append("      ,MLG_TO_DT" ).append("\n"); 
		query.append("      ,PAY_AMT" ).append("\n"); 
		query.append("      ,MLG_ISS_DT" ).append("\n"); 
		query.append("      ,MLG_PNT_AMT" ).append("\n"); 
		query.append("      ,CSH_BAK_DT" ).append("\n"); 
		query.append("      ,CSH_BAK_AMT" ).append("\n"); 
		query.append("      ,CSH_BAK_BAL_AMT" ).append("\n"); 
		query.append("      ,INCNT_RMK" ).append("\n"); 
		query.append("      ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(" 	)VALUES(" ).append("\n"); 
		query.append("	   @[bse_yr]" ).append("\n"); 
		query.append("      ,@[incnt_no]" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN MAX(X.INCNT_HIS_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("                    ELSE MAX(X.INCNT_HIS_SEQ)+1" ).append("\n"); 
		query.append("                END " ).append("\n"); 
		query.append("           FROM EAS_BNF_MLG_HIS X" ).append("\n"); 
		query.append("          WHERE X.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("            AND X.INCNT_NO = @[incnt_no])" ).append("\n"); 
		query.append("      ,@[rhq_cd]" ).append("\n"); 
		query.append("      ,@[team_nm]" ).append("\n"); 
		query.append("      ,@[bank_nm]" ).append("\n"); 
		query.append("      ,TO_DATE(@[mlg_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      ,TO_DATE(@[mlg_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      ,@[pay_amt]" ).append("\n"); 
		query.append("      ,TO_DATE(@[mlg_iss_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      ,@[mlg_pnt_amt]" ).append("\n"); 
		query.append("      ,TO_DATE(@[csh_bak_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      ,@[csh_bak_amt]" ).append("\n"); 
		query.append("      ,@[csh_bak_bal_amt]" ).append("\n"); 
		query.append("      ,@[incnt_rmk]" ).append("\n"); 
		query.append("      ,@[atch_file_lnk_id]" ).append("\n"); 
		query.append("      ,@[atch_n2nd_file_lnk_id]" ).append("\n"); 
		query.append("      ,@[delt_flg]" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}