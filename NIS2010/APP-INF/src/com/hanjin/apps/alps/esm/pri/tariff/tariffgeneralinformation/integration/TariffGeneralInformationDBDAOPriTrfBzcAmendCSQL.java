/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcAmendCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcAmendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code의 General Information을 Amend한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcAmendCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcAmendCSQL").append("\n"); 
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
		query.append("INSERT  INTO PRI_TRF_BZC" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    TRF_PFX_CD" ).append("\n"); 
		query.append("   ,TRF_NO" ).append("\n"); 
		query.append("   ,AMDT_SEQ" ).append("\n"); 
		query.append("   ,EFF_DT" ).append("\n"); 
		query.append("   ,EXP_DT" ).append("\n"); 
		query.append("   ,TRF_BZC_TP_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_WGT" ).append("\n"); 
		query.append("   ,TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("   ,TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("   ,CURR_CD" ).append("\n"); 
		query.append("   ,PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_ADDR" ).append("\n"); 
		query.append("   ,PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_STE_CD" ).append("\n"); 
		query.append("   ,PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("   ,PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("   ,PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("   ,RQST_OFC_CD" ).append("\n"); 
		query.append("   ,APRO_OFC_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_STS_CD" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT  TRF_PFX_CD" ).append("\n"); 
		query.append("       ,TRF_NO" ).append("\n"); 
		query.append("       ,@[amdt_seq]+1" ).append("\n"); 
		query.append("       ,TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("       ,EXP_DT" ).append("\n"); 
		query.append("       ,TRF_BZC_TP_CD" ).append("\n"); 
		query.append("       ,TRF_BZC_WGT" ).append("\n"); 
		query.append("       ,TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("       ,TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("       ,TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("       ,CURR_CD" ).append("\n"); 
		query.append("       ,PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("       ,PUB_OFC_ADDR" ).append("\n"); 
		query.append("       ,PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("       ,PUB_OFC_STE_CD" ).append("\n"); 
		query.append("       ,PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("       ,PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("       ,PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("       ,PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("       ,@[rqst_ofc_cd]" ).append("\n"); 
		query.append("       ,APRO_OFC_CD" ).append("\n"); 
		query.append("       ,'I' AS TRF_BZC_STS_CD" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("  FROM  PRI_TRF_BZC" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 

	}
}