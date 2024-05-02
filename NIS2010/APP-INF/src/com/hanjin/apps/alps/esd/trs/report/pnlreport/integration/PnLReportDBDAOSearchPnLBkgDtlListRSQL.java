/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLReportDBDAOSearchPnLBkgDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.pnlreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PnLReportDBDAOSearchPnLBkgDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.20 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 신규 개발
	  * </pre>
	  */
	public PnLReportDBDAOSearchPnLBkgDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.pnlreport.integration").append("\n"); 
		query.append("FileName : PnLReportDBDAOSearchPnLBkgDtlListRSQL").append("\n"); 
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
		query.append("SELECT  D.BKG_NO" ).append("\n"); 
		query.append(", D.TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ WO_NO" ).append("\n"); 
		query.append(", D.TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ SO_NO" ).append("\n"); 
		query.append(", D.COP_NO" ).append("\n"); 
		query.append(", D.EQ_NO" ).append("\n"); 
		query.append(", D.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", D.WO_OFC_CD" ).append("\n"); 
		query.append(", ( SELECT DECODE(IO_BND_CD,'I','IN','OUT') FROM TRS_EUR_INLND_PFIT_LSS WHERE BKG_NO = D.BKG_NO ) IO_BND_NM" ).append("\n"); 
		query.append(", TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(", FM_NOD_CD" ).append("\n"); 
		query.append(", VIA_NOD_CD" ).append("\n"); 
		query.append(", TO_NOD_CD" ).append("\n"); 
		query.append(", DOR_NOD_CD" ).append("\n"); 
		query.append(", TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", NVL(GLINE_FRT_RT_AMT,0) GLINE_FRT_RT_AMT" ).append("\n"); 
		query.append(", NVL(INLND_COST_USD_AMT,0) INLND_COST_USD_AMT" ).append("\n"); 
		query.append(", NVL(INLND_COST_TRSP_USD_AMT,0) INLND_COST_TRSP_USD_AMT" ).append("\n"); 
		query.append(", NVL(WO_USD_AMT,0) WO_USD_AMT" ).append("\n"); 
		query.append(", ( SELECT POR_CD FROM TRS_EUR_INLND_PFIT_LSS WHERE BKG_NO = D.BKG_NO ) POR_CD" ).append("\n"); 
		query.append(", ( SELECT POL_CD FROM TRS_EUR_INLND_PFIT_LSS WHERE BKG_NO = D.BKG_NO ) POL_CD" ).append("\n"); 
		query.append(", ( SELECT POD_CD FROM TRS_EUR_INLND_PFIT_LSS WHERE BKG_NO = D.BKG_NO ) POD_CD" ).append("\n"); 
		query.append(", ( SELECT DEL_CD FROM TRS_EUR_INLND_PFIT_LSS WHERE BKG_NO = D.BKG_NO ) DEL_CD" ).append("\n"); 
		query.append(", TRO_SEQ" ).append("\n"); 
		query.append("FROM    TRS_EUR_INLND_PFIT_LSS_DTL D" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_bkg_arr} != '')" ).append("\n"); 
		query.append("AND     BKG_NO IN (${s_bkg_arr})" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}