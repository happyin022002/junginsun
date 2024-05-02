/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff General Information List를 조회한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcInquiryVORSQL").append("\n"); 
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
		query.append("SELECT  BZC.TRF_PFX_CD || '-' || BZC.TRF_NO AS TRF_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_PFX_CD" ).append("\n"); 
		query.append("       ,BZC.TRF_NO" ).append("\n"); 
		query.append("       ,AMEND.TRF_NM" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_TP_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BZC.PUB_DT, 'YYYYMMDD') AS PUB_DT" ).append("\n"); 
		query.append("       ,BZC.TRF_BZC_STS_CD" ).append("\n"); 
		query.append("       ,AMEND.TRF_INLND_FLG" ).append("\n"); 
		query.append("       ,BZC.AMDT_SEQ" ).append("\n"); 
		query.append("  FROM  PRI_TRF_BZC BZC" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  CODE.TRF_PFX_CD" ).append("\n"); 
		query.append("               ,CODE.TRF_NO" ).append("\n"); 
		query.append("               ,MAX(CODE.TRF_NM)   AS TRF_NM" ).append("\n"); 
		query.append("               ,MAX(AMDT_SEQ)      AS AMDT_SEQ" ).append("\n"); 
		query.append("               ,MAX(TRF_INLND_FLG) AS TRF_INLND_FLG" ).append("\n"); 
		query.append("          FROM  PRI_TARIFF  CODE" ).append("\n"); 
		query.append("               ,PRI_TRF_BZC BZC" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  CODE.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("           AND  CODE.TRF_PFX_CD = BZC.TRF_PFX_CD" ).append("\n"); 
		query.append("           AND  CODE.TRF_NO     = BZC.TRF_NO" ).append("\n"); 
		query.append("           AND  CODE.TRF_PFX_CD LIKE @[trf_pfx_cd] || '%'" ).append("\n"); 
		query.append("           AND  CODE.TRF_NO     LIKE @[trf_no] || '%'" ).append("\n"); 
		query.append("        GROUP BY CODE.TRF_PFX_CD" ).append("\n"); 
		query.append("               ,CODE.TRF_NO" ).append("\n"); 
		query.append("        ) AMEND" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  BZC.TRF_PFX_CD     = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND  BZC.TRF_NO         = AMEND.TRF_NO" ).append("\n"); 
		query.append("   AND  BZC.AMDT_SEQ       = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("   AND  BZC.TRF_BZC_STS_CD LIKE @[trf_bzc_sts_cd] || '%'" ).append("\n"); 
		query.append("ORDER BY BZC.TRF_PFX_CD, BZC.TRF_NO" ).append("\n"); 

	}
}