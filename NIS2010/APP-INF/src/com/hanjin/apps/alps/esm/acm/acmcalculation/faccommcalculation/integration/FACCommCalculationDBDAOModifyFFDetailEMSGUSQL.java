/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOModifyFFDetailEMSGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOModifyFFDetailEMSGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOModifyFFDetailEMSGUSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOModifyFFDetailEMSGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOModifyFFDetailEMSGUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_FAC_COMM_DTL A " ).append("\n"); 
		query.append("   USING (SELECT   B.BKG_NO BKG_NO " ).append("\n"); 
		query.append("                 , B.SLS_OFC_CD SLS_OFC_CD " ).append("\n"); 
		query.append("                 , B.FAC_SEQ FAC_SEQ " ).append("\n"); 
		query.append("                 , D.CNTR_TPSZ_CD CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                 , SUM (E.OP_CNTR_QTY) BKG_VOL_QTY " ).append("\n"); 
		query.append("                 , SUM (E.OP_CNTR_QTY * D.COMM_UT_AMT) IF_DTRB_AMT " ).append("\n"); 
		query.append("                 , 'USD' CURR_CD " ).append("\n"); 
		query.append("                 , SUM (E.OP_CNTR_QTY * D.COMM_UT_AMT) PAY_IF_DTRB_AMT " ).append("\n"); 
		query.append("                 , 'COMMISSION' UPD_USR_ID " ).append("\n"); 
		query.append("                 , SYSDATE UPD_DT " ).append("\n"); 
		query.append("                 , 'COMMISSION' CRE_USR_ID " ).append("\n"); 
		query.append("                 , SYSDATE CRE_DT " ).append("\n"); 
		query.append("              FROM ACM_FAC_COMM B, ACM_COMM_UT_COST D, " ).append("\n"); 
		query.append("                 ( " ).append("\n"); 
		query.append("                       SELECT " ).append("\n"); 
		query.append("                              BKG.BKG_NO, " ).append("\n"); 
		query.append("                              QTY.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY " ).append("\n"); 
		query.append("                         FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("                              BKG_BL_DOC   DOC, " ).append("\n"); 
		query.append("                              BKG_BOOKING  BKG, " ).append("\n"); 
		query.append("                              BKG_BOOKING  BK2 " ).append("\n"); 
		query.append("                        WHERE QTY.BKG_NO                  = DOC.BKG_NO " ).append("\n"); 
		query.append("                          AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                          AND " ).append("\n"); 
		query.append("                            ( " ).append("\n"); 
		query.append("                              BKG.BKG_NO                  = DOC.BKG_NO " ).append("\n"); 
		query.append("                           OR " ).append("\n"); 
		query.append("                              BKG.BL_NO                   = DOC.MST_CVRD_BL_NO " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                          AND BK2.BKG_NO                  = DOC.BKG_NO " ).append("\n"); 
		query.append("                          AND BK2.BL_NO_TP              <>  '9' " ).append("\n"); 
		query.append("                          AND BK2.BKG_STS_CD            <>  'X' " ).append("\n"); 
		query.append("                          AND BKG.BKG_NO                  = @[bkg_no]" ).append("\n"); 
		query.append("                     GROUP BY BKG.BKG_NO, " ).append("\n"); 
		query.append("                              QTY.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                 ) E " ).append("\n"); 
		query.append("             WHERE B.BKG_NO = E.BKG_NO " ).append("\n"); 
		query.append("               AND B.FAC_SEQ = @[fac_seq]" ).append("\n"); 
		query.append("               AND D.COMM_YRMON = (SELECT MAX (COMM_YRMON) " ).append("\n"); 
		query.append("                                     FROM ACM_COMM_UT_COST " ).append("\n"); 
		query.append("                                    WHERE ROWNUM < 2) " ).append("\n"); 
		query.append("               AND B.AR_OFC_CD = D.OFC_CD " ).append("\n"); 
		query.append("               AND D.IO_BND_CD = 'O' " ).append("\n"); 
		query.append("               AND D.AC_TP_CD = 'F' " ).append("\n"); 
		query.append("               AND B.BKG_NO = E.BKG_NO " ).append("\n"); 
		query.append("               AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          GROUP BY B.BKG_NO " ).append("\n"); 
		query.append("                 , B.SLS_OFC_CD" ).append("\n"); 
		query.append("                 , B.FAC_SEQ " ).append("\n"); 
		query.append("                 , D.CNTR_TPSZ_CD) B " ).append("\n"); 
		query.append("   ON (    A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("       AND A.FAC_SEQ = B.FAC_SEQ " ).append("\n"); 
		query.append("       AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD) " ).append("\n"); 
		query.append("   WHEN MATCHED THEN " ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET A.BKG_VOL_QTY = B.BKG_VOL_QTY " ).append("\n"); 
		query.append("           , A.CURR_CD = B.CURR_CD " ).append("\n"); 
		query.append("           , A.IF_DTRB_AMT = B.IF_DTRB_AMT " ).append("\n"); 
		query.append("           , A.PAY_IF_DTRB_AMT = B.PAY_IF_DTRB_AMT " ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (A.BKG_NO, A.SLS_OFC_CD , A.FAC_SEQ " ).append("\n"); 
		query.append("            , A.CNTR_TPSZ_CD, A.BKG_VOL_QTY, A.IF_DTRB_AMT, A.CURR_CD " ).append("\n"); 
		query.append("            , A.PAY_IF_DTRB_AMT, A.UPD_USR_ID, A.UPD_DT, A.CRE_USR_ID, A.CRE_DT) " ).append("\n"); 
		query.append("      VALUES (B.BKG_NO, B.SLS_OFC_CD, B.FAC_SEQ " ).append("\n"); 
		query.append("            , B.CNTR_TPSZ_CD, B.BKG_VOL_QTY, B.IF_DTRB_AMT, B.CURR_CD " ).append("\n"); 
		query.append("            , B.PAY_IF_DTRB_AMT, B.UPD_USR_ID, B.UPD_DT, B.CRE_USR_ID, B.CRE_DT)" ).append("\n"); 

	}
}