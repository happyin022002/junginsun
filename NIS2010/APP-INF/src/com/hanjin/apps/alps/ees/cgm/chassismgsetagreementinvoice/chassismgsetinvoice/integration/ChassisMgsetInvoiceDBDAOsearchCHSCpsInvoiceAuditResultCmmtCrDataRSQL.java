/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSCpsInvoiceAuditResultCmmtCrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
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

public class ChassisMgsetInvoiceDBDAOsearchCHSCpsInvoiceAuditResultCmmtCrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CGM_1205] Charge Audit Result & Payable Amount Confirm UI에서
	  * Min Commitment / MH Credit Tab의 조회
	  * COM_INTG_CD_DTL {code ID = CD03322}와
	  * CGM_LSE_CHG_HDR를 기반으로
	  * CGM_LSE_CHG_CMMT_CR_DTL의 데이터가 없더라도 select한다
	  * [CHM-201431710] 2014-09-12 Chnag Young Kim
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSCpsInvoiceAuditResultCmmtCrDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSCpsInvoiceAuditResultCmmtCrDataRSQL").append("\n"); 
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
		query.append("SELECT CH.INTG_CD_VAL_CTNT AS CMMT_CR_CD" ).append("\n"); 
		query.append("	 , CH.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("	 , CH.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	 , NVL(D.CMMT_20FT_AMT, decode(CH.INTG_CD_VAL_DP_DESC, 'A', to_char(last_day(to_date(CH.COST_YRMON, 'yyyymm')), 'dd'), 0)) AS CMMT_20FT_AMT" ).append("\n"); 
		query.append("	 , NVL(D.CMMT_40FT_AMT, decode(CH.INTG_CD_VAL_DP_DESC, 'A', to_char(last_day(to_date(CH.COST_YRMON, 'yyyymm')), 'dd'), 0)) AS CMMT_40FT_AMT" ).append("\n"); 
		query.append("	 , NVL(D.CMMT_45FT_AMT, decode(CH.INTG_CD_VAL_DP_DESC, 'A', to_char(last_day(to_date(CH.COST_YRMON, 'yyyymm')), 'dd'), 0)) AS CMMT_45FT_AMT" ).append("\n"); 
		query.append("	 , CH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	 , CH.AGMT_SEQ" ).append("\n"); 
		query.append("	 , CH.AGMT_VER_NO" ).append("\n"); 
		query.append("	 , CH.COST_YRMON" ).append("\n"); 
		query.append("	 , CH.COST_YRMON_SEQ" ).append("\n"); 
		query.append("  FROM CGM_LSE_CHG_CMMT_CR_DTL D" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("             , C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             , C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("             , H.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			 , H.AGMT_SEQ" ).append("\n"); 
		query.append("			 , H.AGMT_VER_NO" ).append("\n"); 
		query.append("			 , H.COST_YRMON" ).append("\n"); 
		query.append("			 , H.COST_YRMON_SEQ" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL C, CGM_LSE_CHG_HDR H" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C.INTG_CD_ID = 'CD03322'" ).append("\n"); 
		query.append("           AND H.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND H.AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("		   AND H.AGMT_VER_NO     = @[agmt_ver_no]" ).append("\n"); 
		query.append("		   AND H.COST_YRMON      = @[cost_yrmon]" ).append("\n"); 
		query.append("		   AND H.COST_YRMON_SEQ  = @[cost_yrmon_seq]" ).append("\n"); 
		query.append("        ORDER BY INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       ) CH" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CH.AGMT_OFC_CTY_CD = D.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND CH.AGMT_SEQ        = D.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   AND CH.AGMT_VER_NO     = D.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("   AND CH.COST_YRMON      = D.COST_YRMON(+)" ).append("\n"); 
		query.append("   AND CH.COST_YRMON_SEQ  = D.COST_YRMON_SEQ(+)" ).append("\n"); 
		query.append("   AND CH.INTG_CD_VAL_CTNT = D.CMMT_CR_CD(+)" ).append("\n"); 

	}
}