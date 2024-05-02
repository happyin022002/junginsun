/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsChargeCreationListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSCpsChargeCreationListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015-02 [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
	  * 2015.05.14 Chang-Young Kim join 조건 추가
	  * 2015 조직코드개편 Chang-Young Kim
	  * CHM-201640236 COPS INVOICE 생성시 INVOICE 표기 로직 변경 - Version이 변경되더라도 해당 Cost Month에 입력된 Agreement는 출력으로 SQL 전면수정 보완
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCpsChargeCreationListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_pool",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsChargeCreationListDataRSQL").append("\n"); 
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
		query.append("WITH INV_LIST AS (" ).append("\n"); 
		query.append("    SELECT AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("         , AGMT_SEQ" ).append("\n"); 
		query.append("         , AGMT_VER_NO" ).append("\n"); 
		query.append("         , COST_YRMON" ).append("\n"); 
		query.append("         , MAX(EQ_KND_CD) EQ_KND_CD" ).append("\n"); 
		query.append("         , COUNT(1) INV_CNT" ).append("\n"); 
		query.append("      FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("     WHERE EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("       AND COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("       AND AGMT_SEQ BETWEEN 50000 AND 90000" ).append("\n"); 
		query.append("     GROUP BY AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            , AGMT_SEQ" ).append("\n"); 
		query.append("            , AGMT_VER_NO" ).append("\n"); 
		query.append("            , COST_YRMON" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT_NO" ).append("\n"); 
		query.append("     , A.AGMT_VER_NO" ).append("\n"); 
		query.append("     , A.AGMT_EFF_DT" ).append("\n"); 
		query.append("     , A.AGMT_EXP_DT" ).append("\n"); 
		query.append("     , A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.EQ_RNTL_TP_CD" ).append("\n"); 
		query.append("     , B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.CHSS_POOL_CD" ).append("\n"); 
		query.append("     , A.AGMT_REF_NO" ).append("\n"); 
		query.append("     , NVL(C.INV_CNT, 0) INV_CNT" ).append("\n"); 
		query.append("     , A.LST_VER_FLG" ).append("\n"); 
		query.append("  FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("     , MDM_VENDOR B" ).append("\n"); 
		query.append("     , INV_LIST C" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.AGMT_VER_NO = C.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("   AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.AGMT_LSTM_CD = 'ZP'" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if(${combo_pool} != '')" ).append("\n"); 
		query.append("   AND A.CHSS_POOL_CD = @[combo_pool]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_ofc_cd} != 'SELCON' && ${cre_ofc_cd} != 'NYCRA')" ).append("\n"); 
		query.append("   AND A.AGMT_ISS_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND TO_DATE(@[cost_yrmon] || '01', 'YYYYMMDD') BETWEEN AGMT_EFF_DT AND AGMT_EXP_DT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT_NO" ).append("\n"); 
		query.append("     , A.AGMT_VER_NO" ).append("\n"); 
		query.append("     , A.AGMT_EFF_DT" ).append("\n"); 
		query.append("     , A.AGMT_EXP_DT" ).append("\n"); 
		query.append("     , A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.EQ_RNTL_TP_CD" ).append("\n"); 
		query.append("     , B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.CHSS_POOL_CD" ).append("\n"); 
		query.append("     , A.AGMT_REF_NO" ).append("\n"); 
		query.append("     , NVL(C.INV_CNT, 0) INV_CNT" ).append("\n"); 
		query.append("     , A.LST_VER_FLG" ).append("\n"); 
		query.append("  FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("     , MDM_VENDOR B" ).append("\n"); 
		query.append("     , INV_LIST C" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.AGMT_VER_NO = C.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("   AND A.LST_VER_FLG != 'Y'" ).append("\n"); 
		query.append("   AND A.AGMT_LSTM_CD = 'ZP'" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if(${combo_pool} != '')" ).append("\n"); 
		query.append("   AND A.CHSS_POOL_CD = @[combo_pool]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_ofc_cd} != 'SELCON' && ${cre_ofc_cd} != 'NYCRA')" ).append("\n"); 
		query.append("   AND A.AGMT_ISS_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND TO_DATE(@[cost_yrmon] || '01', 'YYYYMMDD') BETWEEN A.AGMT_EFF_DT AND A.AGMT_EXP_DT" ).append("\n"); 
		query.append(" ORDER BY LST_VER_FLG DESC, VNDR_SEQ, AGMT_NO, AGMT_VER_NO" ).append("\n"); 

	}
}