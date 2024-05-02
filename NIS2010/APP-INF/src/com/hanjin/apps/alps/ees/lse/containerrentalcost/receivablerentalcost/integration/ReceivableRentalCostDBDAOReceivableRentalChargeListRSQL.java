/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.29 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableRentalChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 월에 대한 Receivable Rental Charge 작업 현황목록을 조회한다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("qty_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalChargeListRSQL").append("\n"); 
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
		query.append("SELECT  A.COST_YRMON, A.QTY_YRMON, A.RCV_RNTL_SEQ," ).append("\n"); 
		query.append("		NVL2(A.INV_NO, 'I', A.LSE_CNTR_CHG_STS_CD) AS LSE_CNTR_CHG_STS_CD, " ).append("\n"); 
		query.append("		A.LSTM_CD, A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO," ).append("\n"); 
		query.append("		A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("        TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT, " ).append("\n"); 
		query.append("        TO_CHAR(A.EXP_DT,'YYYYMMDD') AS EXP_DT," ).append("\n"); 
		query.append("        A.VNDR_ABBR_NM, A.VNDR_SEQ, A.INV_NO, A.INV_CRE_USR_ID, " ).append("\n"); 
		query.append("        TO_CHAR(A.INV_CRE_DT,'YYYYMMDD') AS INV_CRE_DT," ).append("\n"); 
		query.append("		TO_CHAR(A.INV_ISS_DT,'YYYYMMDD') AS INV_ISU_DT," ).append("\n"); 
		query.append("		TO_CHAR(A.INV_DUE_DT,'YYYYMMDD') AS INV_DUE_DT," ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'N','', A.CURR_CD) AS CURR_CD, " ).append("\n"); 
		query.append("		DECODE(A.LSE_CNTR_CHG_STS_CD, 'N','', A.TTL_CHG_AMT) AS TTL_CHG_AMT," ).append("\n"); 
		query.append("		DECODE(A.LSE_CNTR_CHG_STS_CD, 'N','', A.CR_AMT) AS CR_AMT," ).append("\n"); 
		query.append("		DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.CUST_CNT_CD, 'HQ')) AS CUST_CNT_CD, " ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.CUST_SEQ, 21)) AS CUST_SEQ," ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', C.CUST_LGL_ENG_NM) AS CUST_ENG_NM, " ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_XCH_RT, 1)) AS LOCL_XCH_RT, " ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_CURR_CD, 'USD')) LOCL_CURR_CD, " ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_TAX_FLG, 'N')) AS LOCL_TAX_FLG, " ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_TAX_AMT, 0)) AS LOCL_TAX_AMT," ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_CHG_AMT, A.TTL_CHG_AMT + A.CR_AMT)) AS LOCL_CHG_AMT," ).append("\n"); 
		query.append("        DECODE(A.LSE_CNTR_CHG_STS_CD, 'I', NVL(A.LOCL_TTL_CHG_AMT, A.TTL_CHG_AMT + A.CR_AMT)) AS LOCL_TTL_CHG_AMT," ).append("\n"); 
		query.append("		A.SRC_IF_DT, A.SRC_IF_SEQ, B.GL_EFF_DT, B.DUE_DT," ).append("\n"); 
		query.append("		NVL2(A.SRC_IF_DT,'Y', A.CFM_FLG) AS CFM_FLG, A.INV_CRE_OFC_CD," ).append("\n"); 
		query.append("        NVL2(A.SRC_IF_DT, A.INV_CRE_OFC_CD, A.CFM_OFC_CD) AS CFM_OFC_CD," ).append("\n"); 
		query.append("        NVL((SELECT	INV_ERP_IF_STS_CD FROM INV_AR_AMT" ).append("\n"); 
		query.append("			 WHERE 	AR_IF_NO = B.AR_IF_NO AND  ROWNUM = 1), B.BL_INV_IF_FLG) AS INV_IF_FLG," ).append("\n"); 
		query.append("        NVL((SELECT	ERR_DESC FROM INV_AR_AMT" ).append("\n"); 
		query.append("			 WHERE 	AR_IF_NO = B.AR_IF_NO AND  ROWNUM = 1), B.IF_ERR_RSN) AS IF_ERR_RSN" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG A," ).append("\n"); 
		query.append("		INV_AR_IF_MN B," ).append("\n"); 
		query.append("		MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE   A.QTY_YRMON  = @[qty_yrmon] " ).append("\n"); 
		query.append("AND     A.SRC_IF_DT  = B.SRC_IF_DT(+)" ).append("\n"); 
		query.append("AND     A.SRC_IF_SEQ = B.SRC_IF_SEQ(+)    " ).append("\n"); 
		query.append("AND     NVL(A.CUST_CNT_CD, 'HQ') =  C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     NVL(A.CUST_SEQ, 21) = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')            " ).append("\n"); 
		query.append("AND     A.LSTM_CD = @[lstm_cd]    " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${vndr_seq} != '')            " ).append("\n"); 
		query.append("AND     A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}