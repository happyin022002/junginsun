/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Rates를 조회한다.
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndInquiryVORSQL").append("\n"); 
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
		query.append("SELECT  MAIN.TRF_PFX_CD" ).append("\n"); 
		query.append("       ,MAIN.TRF_NO" ).append("\n"); 
		query.append("       ,MAIN.TRF_INLND_SEQ" ).append("\n"); 
		query.append("       ,MAIN.AMDT_SEQ" ).append("\n"); 
		query.append("       ,MAIN.TRF_INLND_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(MAIN.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(MAIN.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(MAIN.PUB_DT, 'YYYYMMDD') AS PUB_DT" ).append("\n"); 
		query.append("       ,MAIN.RQST_OFC_CD" ).append("\n"); 
		query.append("       ,MAIN.APRO_OFC_CD" ).append("\n"); 
		query.append("       ,MAIN.TRF_INLND_STS_CD" ).append("\n"); 
		query.append("       ,MAIN.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(MAIN.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("       ,MAIN.ATCH_FILE_ID" ).append("\n"); 
		query.append("     , (SELECT FILE_UPLD_NM " ).append("\n"); 
		query.append("		  FROM COM_UPLD_FILE " ).append("\n"); 
		query.append("		 WHERE FILE_SAV_ID = MAIN.ATCH_FILE_ID " ).append("\n"); 
		query.append("		   AND DELT_FLG = 'N') ATCH_FILE_NM" ).append("\n"); 
		query.append("       ,MAIN.TRF_INLND_AMDT_TP_CD" ).append("\n"); 
		query.append("  FROM  PRI_TRF_INLND MAIN" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  TRF_PFX_CD" ).append("\n"); 
		query.append("               ,TRF_NO" ).append("\n"); 
		query.append("               ,TRF_INLND_SEQ" ).append("\n"); 
		query.append("               ,MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("          FROM  PRI_TRF_INLND" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("           AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("        GROUP BY TRF_PFX_CD, TRF_NO, TRF_INLND_SEQ" ).append("\n"); 
		query.append("        ) AMEND" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  MAIN.TRF_PFX_CD    = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND  MAIN.TRF_NO        = AMEND.TRF_NO" ).append("\n"); 
		query.append("   AND  MAIN.TRF_INLND_SEQ = AMEND.TRF_INLND_SEQ" ).append("\n"); 
		query.append("   AND  MAIN.AMDT_SEQ      = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("   AND  MAIN.TRF_INLND_STS_CD LIKE @[trf_inlnd_sts_cd] || '%'" ).append("\n"); 
		query.append("ORDER BY TRF_INLND_NM" ).append("\n"); 

	}
}