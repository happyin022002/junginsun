/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.12 
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

public class ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchMGSChargeCreationListData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	DECODE(@[chg_cre_seq],null,'',DECODE(B.CHG_CRE_SEQ,@[chg_cre_seq],'U','')) AS IBFLAG," ).append("\n"); 
		query.append("	DECODE(@[chg_cre_seq],null,'0',DECODE(B.CHG_CRE_SEQ,@[chg_cre_seq],'1','0')) AS DEL_CHK," ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    A.AGMT_SEQ," ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("    A.AGMT_EFF_DT," ).append("\n"); 
		query.append("    A.AGMT_EXP_DT," ).append("\n"); 
		query.append("    A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("    A.VNDR_SEQ," ).append("\n"); 
		query.append("	A.EQ_RNTL_TP_CD," ).append("\n"); 
		query.append("    C.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("    B.LSE_CHG_STS_CD," ).append("\n"); 
		query.append("	(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("     FROM 	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("	 WHERE 	INTG_CD_ID = 'CD01944'" ).append("\n"); 
		query.append("		   	AND INTG_CD_VAL_CTNT = B.LSE_CHG_STS_CD) AS LSE_CHG_STS_DESC," ).append("\n"); 
		query.append("	B.CHG_CRE_SEQ," ).append("\n"); 
		query.append("	B.COST_YRMON_SEQ  -- add by shin yongchan, 2014-05-12" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CGM_AGREEMENT A," ).append("\n"); 
		query.append("    CGM_LSE_CHG_HDR B," ).append("\n"); 
		query.append("    MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("    AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("    AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND B.COST_YRMON(+) = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("		 (A.AGMT_EFF_DT >= TO_DATE(@[cost_yrmon]||'01' ,'YYYYMMDD') " ).append("\n"); 
		query.append("          AND A.AGMT_EFF_DT < ADD_MONTHS(TO_DATE(@[cost_yrmon],'YYYYMM'),1))" ).append("\n"); 
		query.append("      OR (A.AGMT_EXP_DT >= TO_DATE(@[cost_yrmon]||'01' ,'YYYYMMDD') " ).append("\n"); 
		query.append("          AND A.AGMT_EXP_DT < ADD_MONTHS(TO_DATE(@[cost_yrmon],'YYYYMM'),1))" ).append("\n"); 
		query.append("      OR (A.AGMT_EFF_DT <= TO_DATE(@[cost_yrmon]||'01' ,'YYYYMMDD')" ).append("\n"); 
		query.append("    	  AND A.AGMT_EXP_DT >= ADD_MONTHS(TO_DATE(@[cost_yrmon],'YYYYMM'),1)-1)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD IN ('LT','ST')" ).append("\n"); 
		query.append("	AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ" ).append("\n"); 

	}
}