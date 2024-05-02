/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeOnlyStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.04 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSChargeOnlyStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSChargeOnlyStatusData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSChargeOnlyStatusDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSChargeOnlyStatusDataRSQL").append("\n"); 
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
		query.append("B.EQ_NO," ).append("\n"); 
		query.append("B.AGMT_OFC_CTY_CD || LPAD(B.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("C.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("B.LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("B.CHG_CD," ).append("\n"); 
		query.append("B.CHG_SEQ," ).append("\n"); 
		query.append("B.EQ_ONH_LOC_CD," ).append("\n"); 
		query.append("TO_CHAR(B.EQ_ONH_DT,'YYYY-MM-DD') AS EQ_ONH_DT," ).append("\n"); 
		query.append("B.EQ_OFFH_LOC_CD," ).append("\n"); 
		query.append("TO_CHAR(B.EQ_OFFH_DT,'YYYY-MM-DD') AS EQ_OFFH_DT," ).append("\n"); 
		query.append("B.LSE_USE_DYS," ).append("\n"); 
		query.append("B.LSE_RT_AMT," ).append("\n"); 
		query.append("B.LSE_CHG_AMT," ).append("\n"); 
		query.append("D.EQ_ASET_STS_CD," ).append("\n"); 
		query.append("TO_CHAR(D.STS_EVNT_DT,'YYYY-MM-DD') AS STS_EVNT_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B, CGM_EQUIPMENT C, CGM_EQ_STS_HIS D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("AND B.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND C.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("AND B.PAY_LSE_CHG_STS_CD = 'H'" ).append("\n"); 
		query.append("AND C.EQ_NO = D.EQ_NO" ).append("\n"); 
		query.append("AND D.ROWID = (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(H XPKCGM_EQ_STS_HIS)  */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM   CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("WHERE  EQ_NO = D.EQ_NO" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 

	}
}