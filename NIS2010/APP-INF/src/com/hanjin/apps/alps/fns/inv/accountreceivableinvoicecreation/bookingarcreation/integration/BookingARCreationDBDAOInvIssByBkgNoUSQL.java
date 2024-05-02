/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssByBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvIssByBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssByBkgNo
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssByBkgNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_smry_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssByBkgNoUSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_MN O" ).append("\n"); 
		query.append("USING (SELECT INV_REF_NO, NEW_REF_NO" ).append("\n"); 
		query.append("               ,BKG_TEU_QTY,BKG_FEU_QTY,TEU,FEU,A.AR_IF_NO,A.REV_CNT" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("				SELECT  DECODE(A.IO_BND_CD, 'O', DECODE(@[ots_smry_cd],'INV',DECODE(A.REV_CNT,0,A.INV_REF, NVL(A.FINV_CNT,NVL(A.ESRF_CNT,A.EBRF_CNT))),A.FINV_CNT), A.INV_REF_NO) NEW_REF_NO" ).append("\n"); 
		query.append("                        ,A.AR_IF_NO" ).append("\n"); 
		query.append("                        ,A.BKG_NO" ).append("\n"); 
		query.append("                        ,A.REV_CNT" ).append("\n"); 
		query.append("                        ,(SELECT /*+ INDEX(C XPKBKG_QUANTITY) */" ).append("\n"); 
		query.append("                                  NVL(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', C.OP_CNTR_QTY)),A.BKG_TEU_QTY)" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY C" ).append("\n"); 
		query.append("                            WHERE A.BKG_NO = C.BKG_NO) TEU  " ).append("\n"); 
		query.append("                        ,(SELECT /*+ INDEX(C XPKBKG_QUANTITY) */                     " ).append("\n"); 
		query.append("                                  NVL(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', 0, C.OP_CNTR_QTY)),A.BKG_FEU_QTY)" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY C" ).append("\n"); 
		query.append("                            WHERE A.BKG_NO = C.BKG_NO) FEU " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("					SELECT                   " ).append("\n"); 
		query.append("                         A.AR_IF_NO" ).append("\n"); 
		query.append("                         ,A.BKG_NO" ).append("\n"); 
		query.append("                         ,A.INV_REF_NO" ).append("\n"); 
		query.append("                         ,A.IO_BND_CD     " ).append("\n"); 
		query.append("                         ,A.BKG_TEU_QTY      " ).append("\n"); 
		query.append("                         ,A.BKG_FEU_QTY          " ).append("\n"); 
		query.append("                         ,(SELECT SUBSTR(B.CUST_REF_NO_CTNT,1,50) FROM BKG_REFERENCE B " ).append("\n"); 
		query.append("                                                    WHERE B.BKG_NO=A.BKG_NO AND B.BKG_REF_TP_CD = 'FINV'" ).append("\n"); 
		query.append("                                                    AND B.REF_SEQ = (SELECT MAX(K.REF_SEQ) FROM BKG_REFERENCE K WHERE K.BKG_NO(+) = B.BKG_NO AND K.BKG_REF_TP_CD = 'FINV')) FINV_CNT" ).append("\n"); 
		query.append("                         ,(SELECT SUBSTR(B.CUST_REF_NO_CTNT,1,50) FROM BKG_REFERENCE B " ).append("\n"); 
		query.append("                                                    WHERE B.BKG_NO=A.BKG_NO AND B.BKG_REF_TP_CD = 'ESRF'" ).append("\n"); 
		query.append("                                                    AND B.REF_SEQ = (SELECT MAX(K.REF_SEQ) FROM BKG_REFERENCE K WHERE K.BKG_NO(+) = B.BKG_NO AND K.BKG_REF_TP_CD = 'ESRF')) ESRF_CNT" ).append("\n"); 
		query.append("                         ,(SELECT SUBSTR(B.CUST_REF_NO_CTNT,1,50) FROM BKG_REFERENCE B " ).append("\n"); 
		query.append("                                                    WHERE B.BKG_NO=A.BKG_NO AND B.BKG_REF_TP_CD = 'EBRF'" ).append("\n"); 
		query.append("                                                    AND B.REF_SEQ = (SELECT MAX(K.REF_SEQ) FROM BKG_REFERENCE K WHERE K.BKG_NO(+) = B.BKG_NO AND K.BKG_REF_TP_CD = 'EBRF')) EBRF_CNT                                                             " ).append("\n"); 
		query.append("                         ,(SELECT COUNT(A.AR_IF_NO) FROM INV_AR_MN K1, INV_AR_ISS_FTR K2 WHERE K1.AR_IF_NO=K2.AR_IF_NO AND K2.BL_SRC_NO = A.BL_SRC_NO AND K1.REV_TP_CD <> 'M') REV_CNT                      " ).append("\n"); 
		query.append("                         ,(SELECT INV_REF_NO FROM INV_AR_MN K1 WHERE K1.AR_IF_NO = (SELECT MAX(AR_IF_NO) FROM INV_AR_ISS_FTR K2 WHERE K2.BL_SRC_NO = A.BL_SRC_NO AND INV_ISS_WRK_NO = @[wrk_no])) INV_REF" ).append("\n"); 
		query.append("                    	FROM INV_AR_MN A" ).append("\n"); 
		query.append("               			WHERE AR_IF_NO IN (SELECT V1.AR_IF_NO " ).append("\n"); 
		query.append("                                    FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("                                   WHERE INV_ISS_WRK_NO = @[wrk_no] " ).append("\n"); 
		query.append("                                   GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                                       , V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                       , V1.VSL_CD" ).append("\n"); 
		query.append("                                       , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       , V1.IO_BND_CD" ).append("\n"); 
		query.append("                                       , V1.PORT_CD" ).append("\n"); 
		query.append("                                       , V1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  #if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("                                       , V1.BL_SRC_NO" ).append("\n"); 
		query.append("                                  #end" ).append("\n"); 
		query.append("                                       , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                                       , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                                       , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                                       , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                                       , V1.AR_IF_NO " ).append("\n"); 
		query.append("                                 ) " ).append("\n"); 
		query.append("				 ) A   " ).append("\n"); 
		query.append("			) A" ).append("\n"); 
		query.append("             ,INV_AR_MN B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        ) P" ).append("\n"); 
		query.append("  ON (O.AR_IF_NO = P.AR_IF_NO)       " ).append("\n"); 
		query.append(" WHEN MATCHED THEN UPDATE SET O.INV_REF_NO = P.NEW_REF_NO" ).append("\n"); 
		query.append("                             ,O.BKG_TEU_QTY = P.TEU" ).append("\n"); 
		query.append("                             ,O.BKG_FEU_QTY = P.FEU" ).append("\n"); 

	}
}