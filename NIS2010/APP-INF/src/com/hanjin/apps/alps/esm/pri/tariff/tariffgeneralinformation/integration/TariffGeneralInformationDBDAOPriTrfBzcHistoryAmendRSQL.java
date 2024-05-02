/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcHistoryAmendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.19
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.11.19 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcHistoryAmendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택한 Tariff Code의 Amend별 정보를 조회
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcHistoryAmendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("access_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcHistoryAmendRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    B.AMDT_SEQ" ).append("\n"); 
		query.append("   ,TO_CHAR(B.CRE_DT,'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(B.EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(B.EXP_DT,'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(B.PUB_DT,'YYYYMMDD') AS PUB_DT" ).append("\n"); 
		query.append("   ,C.INTG_CD_VAL_DP_DESC AS TRF_BZC_STS_CD_NM" ).append("\n"); 
		query.append("   ,B.RQST_OFC_CD" ).append("\n"); 
		query.append("   ,B.CRE_USR_ID" ).append("\n"); 
		query.append("   ,B.APRO_OFC_CD" ).append("\n"); 
		query.append("   ,B.TRF_BZC_TP_CD" ).append("\n"); 
		query.append("   ,TRIM(TO_CHAR(B.TRF_BZC_WGT,9999999999.999)) AS TRF_BZC_WGT" ).append("\n"); 
		query.append("   ,B.TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("   ,TRIM(TO_CHAR(B.TRF_BZC_VOL_QTY,9999999999.999)) AS TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("   ,B.TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("   ,B.TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("   ,B.CURR_CD" ).append("\n"); 
		query.append("   ,B.PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("   ,B.PUB_OFC_ADDR" ).append("\n"); 
		query.append("   ,B.PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("   ,B.PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("   ,B.PUB_OFC_STE_CD" ).append("\n"); 
		query.append("   ,B.PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("   ,B.PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("   ,B.PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("   ,B.TRF_NO" ).append("\n"); 
		query.append("   ,B.TRF_PFX_CD" ).append("\n"); 
		query.append("   ,T.TRF_NM" ).append("\n"); 
		query.append("   ,T.TRF_INLND_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_TRF_BZC B" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  INTG_CD_ID = 'CD02395'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("     ,(" ).append("\n"); 
		query.append("        SELECT  TRF_NM, TRF_INLND_FLG" ).append("\n"); 
		query.append("          FROM  PRI_TARIFF " ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("           AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("        ) T  " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND B.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND B.TRF_BZC_STS_CD = C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.TRF_BZC_STS_CD = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${access_dt}!= '')" ).append("\n"); 
		query.append("   AND B.EFF_DT <= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND NVL(B.EXP_DT, TO_DATE('9999-12-31','YYYY-MM-DD')) >= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY B.AMDT_SEQ DESC" ).append("\n"); 

	}
}