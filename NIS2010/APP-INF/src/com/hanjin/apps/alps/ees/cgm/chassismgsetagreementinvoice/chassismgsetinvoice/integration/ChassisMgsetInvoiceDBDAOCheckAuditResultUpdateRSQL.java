/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOCheckAuditResultUpdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
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

public class ChassisMgsetInvoiceDBDAOCheckAuditResultUpdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_LSE_INV_TMP에 Insert된 데이터를 CGM_LSE_CHG_DTL과 비교 Check한 데이터를 조회
	  * ---------------------------------------------------------------------------------------------------
	  * 2015.06.10 REAUD_RSLT 관련 Case문 분기 조건 변경 Chang-Young Kim
	  * 2015.07.28 Cntr No.를 TMP.INV_EQ_NO = DTL.INV_CUST_EQ_NO로 join ( Bug Fix )
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOCheckAuditResultUpdateRSQL(){
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
		params.put("max_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChassisMgsetInvoiceDBDAOCheckAuditResultUpdateRSQL").append("\n"); 
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
		query.append("SELECT UPDT_KEY," ).append("\n"); 
		query.append("       ROW_SEQ AS SEQ," ).append("\n"); 
		query.append("       (CASE WHEN ORI_CD <> 'C' AND FND_FLG = 'Y' AND ADT_RSLT = 0 THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("       END) AS DEL_CHK," ).append("\n"); 
		query.append("       (CASE WHEN FND_FLG = 'Y' AND NVL(ORI_CD, 'C') = 'C' THEN 'Coincidence is not updated.'" ).append("\n"); 
		query.append("             WHEN FND_FLG = 'N' THEN 'Equipment information not found.'" ).append("\n"); 
		query.append("             WHEN ADT_RSLT = 1  THEN 'Rate Sum + Tax Sum <> Total Amount.'" ).append("\n"); 
		query.append("             ELSE 'OK'" ).append("\n"); 
		query.append("        END) AS REAUD_RSLT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT" ).append("\n"); 
		query.append("           ROWIDTOCHAR(B.ROWID) UPDT_KEY," ).append("\n"); 
		query.append("           TO_NUMBER(A.INV_REF_NO) AS ROW_SEQ," ).append("\n"); 
		query.append("           DECODE(B.INV_NO,NULL,'N','Y') FND_FLG," ).append("\n"); 
		query.append("           A.INV_EQ_NO,A.EQ_NO,A.CHG_CD," ).append("\n"); 
		query.append("           (CASE WHEN NVL(A.INV_LSE_CHG_AMT,0) + NVL(A.INV_TAX_AMT,0) - ABS(NVL(A.INV_CR_AMT,0)) =  A.INV_SMRY_AMT THEN  0" ).append("\n"); 
		query.append("                 WHEN NVL(A.INV_LSE_CHG_AMT,0) + NVL(A.INV_TAX_AMT,0) - ABS(NVL(A.INV_CR_AMT,0)) <> A.INV_SMRY_AMT THEN  1" ).append("\n"); 
		query.append("            END) AS ADT_RSLT," ).append("\n"); 
		query.append("           B.LSE_CHG_AUD_STS_CD as ORI_CD" ).append("\n"); 
		query.append("    FROM  CGM_LSE_INV_TMP A , CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("    WHERE A.CHG_CRE_SEQ = @[max_seq]" ).append("\n"); 
		query.append("    AND   A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND   A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    AND   A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("    AND   A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND   A.COST_YRMON_SEQ = @[cost_yrmon_seq]" ).append("\n"); 
		query.append("    AND   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("    AND   A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("    AND   A.AGMT_VER_NO = B.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("    AND   A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("    AND   A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("    AND   A.CHG_CD = B.CHG_CD(+)" ).append("\n"); 
		query.append("    AND   A.INV_LSE_USE_DYS = B.CHG_SEQ(+) -- 임시로 INV_LSE_USE_DYS, 차후 CHG_SEQ 컬럼 생성 후 변경" ).append("\n"); 
		query.append("    AND   A.COST_YRMON_SEQ = B.COST_YRMON_SEQ(+)" ).append("\n"); 
		query.append("    AND   A.INV_NO = B.INV_NO(+)" ).append("\n"); 
		query.append("    AND   NVL(A.INV_EQ_NO,'!Z') = NVL(B.INV_CUST_EQ_NO(+),'!Z') -- DTL의 INV_CUST_EQ_NO와 join ( Bug Fix )" ).append("\n"); 
		query.append("    AND   A.INV_EQ_ONH_DT = B.INV_EQ_ONH_DT(+)" ).append("\n"); 
		query.append("    AND   NVL(A.INV_EQ_ONH_LOC_NM,'!Z') = NVL(B.INV_EQ_ONH_LOC_NM(+),'!Z')" ).append("\n"); 
		query.append("    AND   A.LSE_CHG_AUD_STS_CD=B.LSE_CHG_AUD_STS_CD(+)" ).append("\n"); 
		query.append("    AND   NVL(A.INV_EQ_OFFH_DT,TRUNC(SYSDATE)) =  DECODE(A.INV_EQ_OFFH_DT,NULL,TRUNC(SYSDATE),B.INV_EQ_OFFH_DT(+))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY ROW_SEQ" ).append("\n"); 

	}
}