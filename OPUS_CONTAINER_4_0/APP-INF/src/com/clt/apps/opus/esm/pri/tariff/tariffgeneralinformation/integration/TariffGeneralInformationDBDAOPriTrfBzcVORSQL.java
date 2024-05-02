/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.25 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code의 Gerneral Information을 조회한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcVORSQL(){
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
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcVORSQL").append("\n"); 
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
		query.append("SELECT  '' TRF_CD" ).append("\n"); 
		query.append("       ,MAIN.TRF_PFX_CD" ).append("\n"); 
		query.append("       ,MAIN.TRF_NO" ).append("\n"); 
		query.append("       ,MAIN.TRF_NM" ).append("\n"); 
		query.append("       ,MAIN.TRF_ORZ_NM" ).append("\n"); 
		query.append("       ,MAIN.TRF_ORZ_TP_NM" ).append("\n"); 
		query.append("       ,BZC.AMDT_SEQ" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_STS_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_STS_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.PUB_DT, 'YYYYMMDD') AS PUB_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.UPD_DT, 'YYYYMMDD-HH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("       ,BZC.RQST_OFC_CD" ).append("\n"); 
		query.append("       ,BZC.CRE_USR_ID" ).append("\n"); 
		query.append("       ,BZC.APRO_OFC_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_TP_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_WGT" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("       ,BZC.CURR_CD" ).append("\n"); 
		query.append("       ,BZC.PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_ADDR" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_STE_CD" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("       ,BZC.PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("       ,BZC.PRE_PUB_DT" ).append("\n"); 
		query.append("       ,MAIN.TRF_INLND_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(NVL(BZC.ROUT_UPD_DT, SYSDATE), 'YYYYMMDD-HH24MISS') AS ROUT_UPD_DT" ).append("\n"); 
		query.append("       ,DECODE(USR.USR_CNT, 0, 'N', 'Y') APRO_USR_FLG" ).append("\n"); 
		query.append("  FROM  PRI_TARIFF  MAIN" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  BZC.TRF_PFX_CD" ).append("\n"); 
		query.append("               ,BZC.TRF_NO" ).append("\n"); 
		query.append("               ,BZC.AMDT_SEQ" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_STS_CD" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND  INTG_CD_ID = 'CD02395'" ).append("\n"); 
		query.append("                   AND  INTG_CD_VAL_CTNT = BZC.TRF_BZC_STS_CD" ).append("\n"); 
		query.append("                ) AS TRF_BZC_STS_NM" ).append("\n"); 
		query.append("               ,BZC.EFF_DT" ).append("\n"); 
		query.append("               ,BZC.EXP_DT" ).append("\n"); 
		query.append("               ,BZC.PUB_DT" ).append("\n"); 
		query.append("               ,BZC.CRE_DT" ).append("\n"); 
		query.append("               ,BZC.UPD_DT" ).append("\n"); 
		query.append("               ,BZC.RQST_OFC_CD" ).append("\n"); 
		query.append("               ,BZC.CRE_USR_ID" ).append("\n"); 
		query.append("               ,BZC.APRO_OFC_CD" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_TP_CD" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_WGT" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("               ,BZC.TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("               ,BZC.CURR_CD" ).append("\n"); 
		query.append("               ,BZC.PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_ADDR" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_STE_CD" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("               ,BZC.PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  TO_CHAR(PUB_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                  FROM  PRI_TRF_BZC" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND  TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("                   AND  TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("                   AND  AMDT_SEQ   = AMEND.AMDT_SEQ-1" ).append("\n"); 
		query.append("                ) AS PRE_PUB_DT" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  MAX(SUB.UPD_DT) " ).append("\n"); 
		query.append("                  FROM  PRI_TRF_BZC_ROUT_PNT SUB" ).append("\n"); 
		query.append("                 WHERE  SUB.TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("                   AND  SUB.TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("                   AND  SUB.AMDT_SEQ   = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("                 GROUP BY TRF_PFX_CD, TRF_NO, AMDT_SEQ" ).append("\n"); 
		query.append("                ) AS ROUT_UPD_DT" ).append("\n"); 
		query.append("          FROM  PRI_TRF_BZC BZC" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  TRF_PFX_CD, TRF_NO" ).append("\n"); 
		query.append("                       ,MAX(AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM  PRI_TRF_BZC" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("                   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("                GROUP BY TRF_PFX_CD,TRF_NO" ).append("\n"); 
		query.append("                ) AMEND" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  BZC.TRF_PFX_CD     = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("           AND  BZC.TRF_NO         = AMEND.TRF_NO" ).append("\n"); 
		query.append("           AND  BZC.AMDT_SEQ       = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("        ) BZC" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  COUNT(*) USR_CNT" ).append("\n"); 
		query.append("          FROM  DUAL" ).append("\n"); 
		query.append("         WHERE  " ).append("\n"); 
		query.append(" -- RHQ 로직 삭제" ).append("\n"); 
		query.append("	    @[ofc_cd] IN (" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        SELECT  APRO_OFC_CD" ).append("\n"); 
		query.append("          FROM  PRI_TRF_BZC BZC" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  TRF_PFX_CD, TRF_NO" ).append("\n"); 
		query.append("                       ,MAX(AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("                  FROM  PRI_TRF_BZC" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("                   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("                GROUP BY TRF_PFX_CD,TRF_NO" ).append("\n"); 
		query.append("                ) AMEND" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  BZC.TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("           AND  BZC.TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("           AND  BZC.AMDT_SEQ   = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("        )              " ).append("\n"); 
		query.append("	    )USR " ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  MAIN.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  MAIN.TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("   AND  MAIN.TRF_PFX_CD = BZC.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("   AND  MAIN.TRF_NO     = BZC.TRF_NO(+)" ).append("\n"); 
		query.append("   AND  MAIN.DELT_FLG   = 'N'" ).append("\n"); 

	}
}