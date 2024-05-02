/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOSearchBkgAbcstp0156ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.21 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchBkgAbcstp0156ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by BKG (ABC/STP)
	  * </pre>
	  */
	public SalesRPTDBDAOSearchBkgAbcstp0156ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchBkgAbcstp0156ListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A1.COND_OFC_CD,'EMU',A5.CTRT_OFC_CD,'SMU',A5.CTRT_OFC_CD, A1.COND_OFC_CD) GUBUN" ).append("\n"); 
		query.append(",A5.CTRT_OFC_CD" ).append("\n"); 
		query.append(",A1.COND_OFC_CD" ).append("\n"); 
		query.append(",DECODE(A1.RA_ACCT_CD, '91401011', DECODE('${f_stp_flg}','I', 'STP REVENUE', 'O', 'STP COST'), A3.MAS_COST_SRC_CD_NM) MAS_COST_SRC_CD_NM" ).append("\n"); 
		query.append(",REPLACE(A4.OFC_CLSS_NM,'&',' ') OFC_CLSS_NM" ).append("\n"); 
		query.append(",REPLACE(A2.SLS_ACT_DESC,'&',' ') SLS_ACT_CD_NM" ).append("\n"); 
		query.append(",DECODE(A1.DIV_MEAS_CD,'TEUQ','TEU','BKGQ','BKG','BKRV','REV','CNTQ','CNTR') DIV_MEAS_CD" ).append("\n"); 
		query.append(",SUM(A1.SVC_TRNS_PRC_AMT) * NVL(A1.BKG_SPLIT_RTO, 1) SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append(",SUM(DECODE(A1.RA_ACCT_CD, '91401011', A1.SVC_TRNS_PRC_AMT)) * NVL(A1.BKG_SPLIT_RTO, 1) STP_REV" ).append("\n"); 
		query.append(",SUM(DECODE(A1.RA_ACCT_CD, '65901021', A1.SVC_TRNS_PRC_AMT)) * NVL(A1.BKG_SPLIT_RTO, 1) OTH_COST" ).append("\n"); 
		query.append("FROM MAS_BKG_SVC_TRNS_PRC A1" ).append("\n"); 
		query.append(",MAS_OFC_ROUT_MAPG A2" ).append("\n"); 
		query.append(",MAS_COST_SRC_ACCT A3" ).append("\n"); 
		query.append(",( SELECT INTG_CD_VAL_DP_SEQ OFC_CLSS_SEQ" ).append("\n"); 
		query.append(",INTG_CD_VAL_CTNT OFC_CLSS_CD" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_DESC OFC_CLSS_NM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00920'" ).append("\n"); 
		query.append(") A4" ).append("\n"); 
		query.append(",MAS_RGST_BKG A5" ).append("\n"); 
		query.append(",MAS_MON_VVD  A6" ).append("\n"); 
		query.append("WHERE A1.SLS_ACT_CD   = A2.SLS_ACT_CD" ).append("\n"); 
		query.append("AND A1.OFC_CLSS_CD  = A2.OFC_CLSS_CD" ).append("\n"); 
		query.append("AND A1.RA_ACCT_CD   = A3.MAS_COST_SRC_CD" ).append("\n"); 
		query.append("AND A1.OFC_CLSS_CD  = A4.OFC_CLSS_CD" ).append("\n"); 
		query.append("AND A1.BKG_NO       = A5.BKG_NO" ).append("\n"); 
		query.append("AND A5.TRD_CD       = A6.TRD_CD" ).append("\n"); 
		query.append("AND A5.RLANE_CD     = A6.RLANE_CD" ).append("\n"); 
		query.append("AND A5.IOC_CD       = A6.IOC_CD" ).append("\n"); 
		query.append("AND A5.VSL_CD       = A6.VSL_CD" ).append("\n"); 
		query.append("AND A5.SKD_VOY_NO   = A6.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A5.DIR_CD       = A6.DIR_CD" ).append("\n"); 
		query.append("AND A6.COST_YRMON   = A2.COST_YRMON" ).append("\n"); 
		query.append("AND A1.BKG_NO       = @[f_bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_pro_vw} =='P')  /* Trade Profit */" ).append("\n"); 
		query.append("AND A1.RA_ACCT_CD   IN ('65901011','65901021')" ).append("\n"); 
		query.append("#else  /* Office Profit */" ).append("\n"); 
		query.append("#if(${f_stp_flg} =='O')" ).append("\n"); 
		query.append("AND A1.RA_ACCT_CD   IN ('65901011','91401011') /* Office Profit : STP Cost */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A1.RA_ACCT_CD   IN ('65901021','91401011') /* Office Profit : STP Income */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A5.CTRT_OFC_CD" ).append("\n"); 
		query.append(",A1.COND_OFC_CD" ).append("\n"); 
		query.append(",A1.RA_ACCT_CD" ).append("\n"); 
		query.append(",DECODE(A1.RA_ACCT_CD, '91401011', DECODE('${f_stp_flg}','I', 'STP REVENUE', 'O', 'STP COST'), A3.MAS_COST_SRC_CD_NM)" ).append("\n"); 
		query.append(",A4.OFC_CLSS_SEQ" ).append("\n"); 
		query.append(",A1.OFC_CLSS_CD" ).append("\n"); 
		query.append(",REPLACE(A4.OFC_CLSS_NM,'&',' ')" ).append("\n"); 
		query.append(",A1.SLS_ACT_CD" ).append("\n"); 
		query.append(",REPLACE(A2.SLS_ACT_DESC,'&',' ')" ).append("\n"); 
		query.append(",DECODE(A1.DIV_MEAS_CD,'TEUQ','TEU','BKGQ','BKG','BKRV','REV','CNTQ','CNTR')" ).append("\n"); 
		query.append(",A1.BKG_SPLIT_RTO" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if(${f_pro_vw} =='R' && ${f_stp_flg} =='I' )" ).append("\n"); 
		query.append("A1.COND_OFC_CD" ).append("\n"); 
		query.append(",A4.OFC_CLSS_SEQ ASC" ).append("\n"); 
		query.append(",A1.RA_ACCT_CD DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A4.OFC_CLSS_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}