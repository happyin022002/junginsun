/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchMnrCreditUsedListRSQL.java
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

public class CreditIncentiveStatusDBDAOSearchMnrCreditUsedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Credit uesd Search
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchMnrCreditUsedListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchMnrCreditUsedListRSQL").append("\n"); 
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
		query.append("SELECT A.CR_ISS_NO" ).append("\n"); 
		query.append("      ,A.CR_USD_SEQ" ).append("\n"); 
		query.append("      ,A.CR_USD_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CR_USD_DT,'YYYYMMDD') CR_USD_DT" ).append("\n"); 
		query.append("      ,A.CR_USD_AMT" ).append("\n"); 
		query.append("      ,SUM(SUM(A.CR_USD_AMT)) OVER(ORDER BY A.CR_USD_SEQ) CR_SUM_USD_AMT" ).append("\n"); 
		query.append("      ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y') ATCH_FLG" ).append("\n"); 
		query.append("      ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,A.CR_USD_RSN" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM EAS_MNR_CR_USD A" ).append("\n"); 
		query.append(" WHERE A.CR_ISS_NO = @[cr_iss_no]" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" GROUP BY A.CR_ISS_NO" ).append("\n"); 
		query.append("         ,A.CR_USD_SEQ" ).append("\n"); 
		query.append("         ,A.CR_USD_OFC_CD" ).append("\n"); 
		query.append("         ,TO_CHAR(A.CR_USD_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("         ,A.CR_USD_AMT" ).append("\n"); 
		query.append("         ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y')" ).append("\n"); 
		query.append("         ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("         ,A.CR_USD_RSN" ).append("\n"); 
		query.append("         ,A.DELT_FLG" ).append("\n"); 
		query.append("         ,A.CRE_USR_ID" ).append("\n"); 
		query.append("         ,A.CRE_DT" ).append("\n"); 
		query.append("         ,A.UPD_USR_ID" ).append("\n"); 
		query.append("         ,A.UPD_DT" ).append("\n"); 
		query.append(" ORDER BY A.CR_ISS_NO" ).append("\n"); 
		query.append("         ,A.CR_USD_SEQ" ).append("\n"); 

	}
}