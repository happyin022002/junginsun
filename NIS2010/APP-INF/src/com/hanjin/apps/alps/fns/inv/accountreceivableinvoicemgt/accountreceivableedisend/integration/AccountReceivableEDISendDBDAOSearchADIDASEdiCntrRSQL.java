/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchADIDASEdiCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchADIDASEdiCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchADIDASEdiCntr
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchADIDASEdiCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchADIDASEdiCntrRSQL").append("\n"); 
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
		query.append("WITH AR_CNTR_INFO AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT CNTR.CNTR_NO CNTR_NO, MAIN.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  CNTR.CNTR_TPSZ_CD CNTR_TYPE," ).append("\n"); 
		query.append("  (SELECT CNTR_WGT FROM BKG_CONTAINER WHERE BKG_NO = MAIN.BKG_NO AND CNTR_NO = CNTR.CNTR_NO) AS CNTR_BL_WEIGHT," ).append("\n"); 
		query.append("  (SELECT MEAS_QTY FROM BKG_CONTAINER WHERE BKG_NO = MAIN.BKG_NO AND CNTR_NO = CNTR.CNTR_NO) AS CNTR_BL_VOLUME," ).append("\n"); 
		query.append("  (SELECT BKG_TRSP_MZD_CD FROM BKG_EUR_TRO WHERE BKG_NO = MAIN.BKG_NO AND IO_BND_CD = MAIN.IO_BND_CD AND CNTR_NO = CNTR.CNTR_NO AND CXL_FLG<>'Y')  AS CNTR_ONCARRIAGE_TRANSPORT_MODE " ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("     INV_AR_CNTR CNTR," ).append("\n"); 
		query.append("     (SELECT DISTINCT BKG_NO,INV_NO,IO_BND_CD FROM INV_AR_MN " ).append("\n"); 
		query.append("     WHERE AR_IF_NO IN (SELECT  AR_IF_NO " ).append("\n"); 
		query.append("     FROM INV_AR_ISS_DTL " ).append("\n"); 
		query.append("     WHERE INV_NO = @[inv_no])) MAIN  --'HM2237446'  " ).append("\n"); 
		query.append("WHERE DTL.AR_IF_NO = CNTR.AR_IF_NO" ).append("\n"); 
		query.append("  AND DTL.INV_NO =  MAIN.INV_NO" ).append("\n"); 
		query.append("  AND DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND DTL.CHG_SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.CNTR_NO CNTR_NBR, A.CNTR_TYPE,A.CNTR_BL_WEIGHT, A.CNTR_BL_VOLUME, " ).append("\n"); 
		query.append("ROUND(1/(SELECT COUNT(*) FROM AR_CNTR_INFO),2) CNTR_RATIO," ).append("\n"); 
		query.append("'1'  AS BL_COUNT_PER_CNTR," ).append("\n"); 
		query.append(" TO_CHAR(D.FT_CMNC_DT,'YYYYMMDD')  AS CNTR_BASEDATE_DET_DEM," ).append("\n"); 
		query.append(" TO_CHAR(D.FT_END_DT,'YYYYMMDD')  AS CNTR_STARTDATE_DET_DEM," ).append("\n"); 
		query.append(" CNTR_ONCARRIAGE_TRANSPORT_MODE" ).append("\n"); 
		query.append("FROM  AR_CNTR_INFO A, " ).append("\n"); 
		query.append("        (SELECT B.FT_CMNC_DT,B.FT_END_DT, B.CNTR_NO" ).append("\n"); 
		query.append("        FROM AR_CNTR_INFO  E, DMT_CHG_CALC B, DMT_CHG_BKG_CNTR C" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND B.CNTR_CYC_NO = C.CNTR_CYC_NO " ).append("\n"); 
		query.append("        AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND E.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("        AND E.CNTR_NO  = C.CNTR_NO" ).append("\n"); 
		query.append("        AND B.DMDT_TRF_CD = 'CTIC'" ).append("\n"); 
		query.append("        AND NOT (B.DUL_TP_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("        AND SUBSTR(B.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("        AND B.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("        ) D" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 

	}
}