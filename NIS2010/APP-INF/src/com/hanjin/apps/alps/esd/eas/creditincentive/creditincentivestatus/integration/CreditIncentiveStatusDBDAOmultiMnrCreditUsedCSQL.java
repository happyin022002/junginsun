/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL.java
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

public class CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Credit Used Save
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_usd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_usd_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_usd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_usd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_MNR_CR_USD A USING DUAL" ).append("\n"); 
		query.append("   ON( A.CR_ISS_NO = @[cr_iss_no]" ).append("\n"); 
		query.append("       AND A.CR_USD_SEQ = @[cr_usd_seq]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET CR_USD_OFC_CD = @[cr_usd_ofc_cd]" ).append("\n"); 
		query.append("           ,CR_USD_DT = TO_DATE(@[cr_usd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("           ,CR_USD_AMT = @[cr_usd_amt]" ).append("\n"); 
		query.append("           ,ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("           ,CR_USD_RSN = @[cr_usd_rsn]" ).append("\n"); 
		query.append("           ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("           ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT( CR_ISS_NO		" ).append("\n"); 
		query.append("           ,CR_USD_SEQ" ).append("\n"); 
		query.append("           ,CR_USD_OFC_CD" ).append("\n"); 
		query.append("           ,CR_USD_DT" ).append("\n"); 
		query.append("           ,CR_USD_AMT" ).append("\n"); 
		query.append("           ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("           ,CR_USD_RSN" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("	     )VALUES(" ).append("\n"); 
		query.append("           @[cr_iss_no]" ).append("\n"); 
		query.append("          ,@[cr_usd_seq]" ).append("\n"); 
		query.append("          ,@[cr_usd_ofc_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[cr_usd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[cr_usd_amt]" ).append("\n"); 
		query.append("          ,@[atch_file_lnk_id]" ).append("\n"); 
		query.append("          ,@[cr_usd_rsn]" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}