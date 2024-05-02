/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchMGSInvoiceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.11.24 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchMGSInvoiceListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchMGSInvoiceListData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchMGSInvoiceListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_mgst_inv_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_mgst_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchMGSInvoiceListDataRSQL").append("\n"); 
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
		query.append("A.PAY_INV_SEQ," ).append("\n"); 
		query.append("A.COST_YRMON," ).append("\n"); 
		query.append("A.INV_NO," ).append("\n"); 
		query.append("A.REV_VSL_CD||A.REV_SKD_VOY_NO||A.REV_SKD_DIR_CD||A.REV_DIR_CD AS REV_VVD," ).append("\n"); 
		query.append("A.CHG_SMRY_AMT," ).append("\n"); 
		query.append("A.INV_TAX_CLT_TP_CD," ).append("\n"); 
		query.append("A.INV_TAX_RT," ).append("\n"); 
		query.append("B.CSR_NO," ).append("\n"); 
		query.append("A.INV_SMRY_AMT," ).append("\n"); 
		query.append("A.CHSS_MGST_INV_STS_CD," ).append("\n"); 
		query.append("DECODE(B.INV_STS_CD, NULL, A.CHSS_MGST_INV_STS_CD, B.INV_STS_CD) AS STATUS_CD," ).append("\n"); 
		query.append("(SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = DECODE(B.INV_STS_CD, NULL, A.CHSS_MGST_INV_STS_CD, B.INV_STS_CD)" ).append("\n"); 
		query.append(") AS STATUS," ).append("\n"); 
		query.append("A.CHG_CRE_SEQ," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO," ).append("\n"); 
		query.append("A.CHSS_MGST_INV_KND_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.INV_RGST_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_PAY_INV A," ).append("\n"); 
		query.append("AP_PAY_INV B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.INV_NO = B.INV_NO(+)" ).append("\n"); 
		query.append("AND A.INV_RGST_NO = B.INV_RGST_NO(+)" ).append("\n"); 
		query.append("AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.CHSS_MGST_INV_KND_CD = @[chss_mgst_inv_knd_cd]" ).append("\n"); 
		query.append("AND A.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.CHSS_MGST_INV_STS_CD != 'H'" ).append("\n"); 
		query.append("#if (${chss_mgst_inv_sts_cd} != 'ALL')" ).append("\n"); 
		query.append("AND DECODE(B.INV_STS_CD, NULL, A.CHSS_MGST_INV_STS_CD, B.INV_STS_CD) = @[chss_mgst_inv_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}