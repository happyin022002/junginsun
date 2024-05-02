/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalPreparationListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.26 장준우
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

public class ReceivableRentalCostDBDAOReceivableRentalPreparationListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 월에 대한 Receivable Rental Preparation 작업을 일괄 수행한다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalPreparationListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalPreparationListCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_RCV_RNTL_CHG (" ).append("\n"); 
		query.append("    COST_YRMON, RCV_RNTL_SEQ, QTY_YRMON, VNDR_SEQ, " ).append("\n"); 
		query.append("    VNDR_ABBR_NM, AGMT_CTY_CD, AGMT_SEQ, LSTM_CD, " ).append("\n"); 
		query.append("    CURR_CD, LSE_CNTR_CHG_STS_CD, EFF_DT, " ).append("\n"); 
		query.append("    EXP_DT, REF_NO, RGST_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("    RCV_AMT_BAL_CD, CXL_FLG, AUTO_INP_FLG, LOCL_TAX_FLG" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(A B C D) */" ).append("\n"); 
		query.append("		TO_CHAR(ADD_MONTHS(TO_DATE(@[qty_yrmon],'RRRRMM'), 1), 'RRRRMM'), " ).append("\n"); 
		query.append("		ROWNUM, @[qty_yrmon], B.VNDR_SEQ, D.VNDR_ABBR_NM, " ).append("\n"); 
		query.append("		A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD,  " ).append("\n"); 
		query.append("		'USD', 'N', C.EFF_DT, B.LST_EXP_DT AS EXP_DT, B.REF_NO, @[ofc_cd]," ).append("\n"); 
		query.append("		@[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE," ).append("\n"); 
		query.append("		'N','N','Y','N'" ).append("\n"); 
		query.append("FROM   (SELECT  /*+ USE_NL(A E) */ " ).append("\n"); 
		query.append("				A.AGMT_CTY_CD, A.AGMT_SEQ," ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'SBO','SO','SBI','SO','MO') AS LSTM_CD" ).append("\n"); 
		query.append("        FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_SEQ = E.PRNR_STS_SEQ(+)   " ).append("\n"); 
		query.append("        AND     A.CNTR_STS_EVNT_DT < TO_DATE(@[qty_yrmon],'RRRRMM')" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN ('SBO','MUO')" ).append("\n"); 
		query.append("		AND     A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("		AND     NVL(E.CNTR_STS_EVNT_DT, SYSDATE) > TO_DATE(@[qty_yrmon],'RRRRMM')" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ," ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'SBO','SO','SBI','SO','MO') AS LSTM_CD" ).append("\n"); 
		query.append("        FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("        WHERE   A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN ('SBO','SBI','MUO','MUI')" ).append("\n"); 
		query.append("		AND     A.CNTR_STS_EVNT_DT >= TO_DATE(@[qty_yrmon], 'YYYYMM')" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_EVNT_DT < ADD_MONTHS(TO_DATE(@[qty_yrmon], 'YYYYMM'),1)" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("		LSE_AGREEMENT B, " ).append("\n"); 
		query.append("        LSE_AGMT_VER C, " ).append("\n"); 
		query.append("        MDM_VENDOR D                   " ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND     B.ITCHG_FEE_FLG <> 'Y' " ).append("\n"); 
		query.append("AND     C.AGMT_VER_SEQ = 1" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 

	}
}