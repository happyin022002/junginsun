/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingUtilDBDAOMdmCustVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOMdmCustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOMdmCustVO
	  * </pre>
	  */
	public BookingUtilDBDAOMdmCustVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOMdmCustVORSQL").append("\n"); 
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
		query.append("SELECT FINC_STS_LVL_CD BLOCK_FLAG," ).append("\n"); 
		query.append("       INDIV_CORP_DIV_CD CUST_TP_CD," ).append("\n"); 
		query.append("       UPPER(CUST_LGL_ENG_NM) NAME," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT  UPPER(BZET_ADDR)" ).append("\n"); 
		query.append("            FROM    MDM_CUST_ADDR" ).append("\n"); 
		query.append("            WHERE   CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND     CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("            AND     PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("            AND     ROWNUM = 1" ).append("\n"); 
		query.append("        ) ADDRESS," ).append("\n"); 
		query.append("		CASE WHEN SLS_DELT_EFF_DT IS NOT NULL THEN 'Y' " ).append("\n"); 
		query.append("			 ELSE 'N' END NO_USE_FLG," ).append("\n"); 
		query.append("		CUST.DELT_FLG, " ).append("\n"); 
		query.append("        CUST.CUST_CNT_CD," ).append("\n"); 
		query.append("        CUST.CUST_SEQ," ).append("\n"); 
		query.append("        FRT_FWRD_FMC_NO," ).append("\n"); 
		query.append("        RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("        NVL(NMD_CUST_FLG, 'N') NMD_CUST_FLG," ).append("\n"); 
		query.append("        (SELECT CHR(10) || '- NO USE REASON : ' || D.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM MDM_SLS_REP C" ).append("\n"); 
		query.append("              , COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("          WHERE CUST.SREP_CD = C.SREP_CD(+)" ).append("\n"); 
		query.append("            AND CUST.SLS_DELT_EFF_RSN_CD = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("            AND D.INTG_CD_ID(+) = 'CD03011') NO_USE_RSN," ).append("\n"); 
		query.append("        DECODE(CR.CUST_RLSE_CTRL_FLG,'N','NO','Y','YES',NULL,'NO',CR.CUST_RLSE_CTRL_FLG) BKLST_FLG," ).append("\n"); 
		query.append("        CUST_RLSE_CTRL_RMK RLSE_CTRL_RSN," ).append("\n"); 
		query.append("         NVL(CR.CR_CLT_OFC_CD, CUST.OFC_CD) AR_OFC," ).append("\n"); 
		query.append("         (SELECT SREP_NM FROM MDM_SLS_REP SREP WHERE SREP.SREP_CD = CUST.SREP_CD) SREP_NM," ).append("\n"); 
		query.append("        DECODE(CUST.SLS_DELT_EFF_RSN_CD,'07','Y','N') EXCD_CR_FLG," ).append("\n"); 
		query.append("        CUST.IDA_GST_RGST_NO," ).append("\n"); 
		query.append("		CUST.CO_CHN_NO" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER CUST, MDM_CR_CUST CR" ).append("\n"); 
		query.append(" WHERE CUST.CUST_CNT_CD     = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ        = @[cust_seq]" ).append("\n"); 
		query.append("   AND CUST.CNTR_DIV_FLG    = 'Y'" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD     = CR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ        = CR.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND 'N'                  = CR.DELT_FLG(+)" ).append("\n"); 

	}
}