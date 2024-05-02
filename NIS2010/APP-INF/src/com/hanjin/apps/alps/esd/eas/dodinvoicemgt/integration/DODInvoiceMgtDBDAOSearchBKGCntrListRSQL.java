/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchBKGCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchBKGCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBKGCntrList
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchBKGCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_session_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchBKGCntrListRSQL").append("\n"); 
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
		query.append("WITH BL_CNTR AS ( " ).append("\n"); 
		query.append("   SELECT BKG_NO,CNTR_NO " ).append("\n"); 
		query.append("   FROM(" ).append("\n"); 
		query.append("       SELECT C2.BKG_NO BKG_NO, C2.CNTR_NO, V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD1, " ).append("\n"); 
		query.append("              B1.BKG_NO BKG2, V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD AS VVD2 " ).append("\n"); 
		query.append("         FROM BKG_BOOKING B1," ).append("\n"); 
		query.append("              BKG_CONTAINER C1," ).append("\n"); 
		query.append("              BKG_CONTAINER C2," ).append("\n"); 
		query.append("              BKG_VVD  V," ).append("\n"); 
		query.append("              VSK_VSL_PORT_SKD ACT," ).append("\n"); 
		query.append("              BKG_VVD  V2," ).append("\n"); 
		query.append("              VSK_VSL_PORT_SKD ACT2" ).append("\n"); 
		query.append("         WHERE B1.BL_NO   = @[in_bl_no]   " ).append("\n"); 
		query.append("           AND B1.BKG_NO  = C1.BKG_NO" ).append("\n"); 
		query.append("           AND C1.CNTR_NO = C2.CNTR_NO" ).append("\n"); 
		query.append("           AND C2.BKG_NO  = V.BKG_NO" ).append("\n"); 
		query.append("           AND V.VSL_CD   = ACT.VSL_CD " ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND V.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("           AND V.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("           AND ACT.VPS_ETD_DT = (SELECT MAX(VPS_ETD_DT)" ).append("\n"); 
		query.append("                                 FROM  BKG_VVD BV" ).append("\n"); 
		query.append("                                      ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("                                 WHERE  BV.VSL_CD  = ACT.VSL_CD " ).append("\n"); 
		query.append("                                 AND BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("                                 AND BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("                                 AND BV.POL_CD     = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("                                 AND BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                 AND BV.BKG_NO =  C2.BKG_NO) " ).append("\n"); 
		query.append("          AND B1.BKG_NO = V2.BKG_NO" ).append("\n"); 
		query.append("          AND V2.VSL_CD = ACT2.VSL_CD " ).append("\n"); 
		query.append("          AND V2.SKD_VOY_NO = ACT2.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND V2.SKD_DIR_CD = ACT2.SKD_DIR_CD " ).append("\n"); 
		query.append("          AND V2.POL_CD = ACT2.VPS_PORT_CD " ).append("\n"); 
		query.append("          AND V2.POL_CLPT_IND_SEQ = ACT2.CLPT_IND_SEQ " ).append("\n"); 
		query.append("          AND ACT2.VPS_ETD_DT = (SELECT MAX(ACT2.VPS_ETD_DT)" ).append("\n"); 
		query.append("                                 FROM  BKG_VVD  BV2" ).append("\n"); 
		query.append("                                      ,VSK_VSL_PORT_SKD ACT2" ).append("\n"); 
		query.append("                                 WHERE  BV2.VSL_CD = ACT2.VSL_CD " ).append("\n"); 
		query.append("                                 AND BV2.SKD_VOY_NO = ACT2.SKD_VOY_NO " ).append("\n"); 
		query.append("                                 AND BV2.SKD_DIR_CD = ACT2.SKD_DIR_CD " ).append("\n"); 
		query.append("                                 AND BV2.POL_CD = ACT2.VPS_PORT_CD " ).append("\n"); 
		query.append("                                 AND BV2.POL_CLPT_IND_SEQ = ACT2.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                 AND BV2.BKG_NO =  B1.BKG_NO) " ).append("\n"); 
		query.append("        ) WHERE VVD1 = VVD2                     " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  X.CNTR_NO" ).append("\n"); 
		query.append("      , X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , DECODE(NVL(Y.DOD_LOC_CD,'X'),'X',DECODE(SUBSTR(@[in_session_ofc_cd],1,3),'KAN','KRKAN','INC','KREIW'),Y.DOD_LOC_CD) AS DOD_LOC_CD" ).append("\n"); 
		query.append("      , 'KRW' AS BIL_CURR_CD" ).append("\n"); 
		query.append("      , Y.BIL_AMT" ).append("\n"); 
		query.append("      , NVL(Y.ADD_AMT,0) AS ADD_AMT" ).append("\n"); 
		query.append("      , (Y.BIL_AMT + NVL(Y.ADD_AMT,0)) AS TOT_BIL_AMT" ).append("\n"); 
		query.append("      , Y.TAX_AMT" ).append("\n"); 
		query.append("      , Y.INV_AMT" ).append("\n"); 
		query.append("      , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("      , X.POL_CD" ).append("\n"); 
		query.append("      , X.POL_CONTI_CD" ).append("\n"); 
		query.append("      , X.POL_CONTI_NM" ).append("\n"); 
		query.append("      , X.POD_CD" ).append("\n"); 
		query.append("      , X.DEL_CD" ).append("\n"); 
		query.append("      , X.DE_TERM_CD  " ).append("\n"); 
		query.append("      , X.CNEE" ).append("\n"); 
		query.append("      , X.NFTY " ).append("\n"); 
		query.append("      , X.SHPR --ADD 2014.1.16" ).append("\n"); 
		query.append("      , X.DOD_INV_NO" ).append("\n"); 
		query.append("      , X.BKG_NO" ).append("\n"); 
		query.append("      , X.BL_NO" ).append("\n"); 
		query.append("      , X.LSTM_CD" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("        SELECT C.CNTR_NO" ).append("\n"); 
		query.append("             , C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , B.POL_CD" ).append("\n"); 
		query.append("             , (SELECT L.CONTI_CD FROM MDM_LOCATION L WHERE L.LOC_CD = B.POL_CD ) POL_CONTI_CD" ).append("\n"); 
		query.append("             , (SELECT CT.CONTI_NM" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION L, MDM_CONTINENT CT " ).append("\n"); 
		query.append("                 WHERE L.LOC_CD = B.POL_CD " ).append("\n"); 
		query.append("                   AND L.CONTI_CD = CT.CONTI_CD ) POL_CONTI_NM" ).append("\n"); 
		query.append("             , B.POD_CD" ).append("\n"); 
		query.append("             , B.DEL_CD" ).append("\n"); 
		query.append("             , B.DE_TERM_CD  " ).append("\n"); 
		query.append("             , ( SELECT K.CUST_NM" ).append("\n"); 
		query.append("                   FROM BKG_CUSTOMER K " ).append("\n"); 
		query.append("                  WHERE K.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND K.BKG_CUST_TP_CD ='C' ) AS CNEE" ).append("\n"); 
		query.append("             , ( SELECT K.CUST_NM" ).append("\n"); 
		query.append("                   FROM BKG_CUSTOMER K " ).append("\n"); 
		query.append("                  WHERE K.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND K.BKG_CUST_TP_CD ='N' ) AS NFTY " ).append("\n"); 
		query.append("             , ( SELECT K.CUST_NM" ).append("\n"); 
		query.append("                   FROM BKG_CUSTOMER K " ).append("\n"); 
		query.append("                  WHERE K.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND K.BKG_CUST_TP_CD ='S' ) AS SHPR " ).append("\n"); 
		query.append("             , (  SELECT  DT.DOD_INV_NO" ).append("\n"); 
		query.append("                    FROM EAS_DOD_INV_DTL DT " ).append("\n"); 
		query.append("                    WHERE  DOD_INV_NO IN ( SELECT M.DOD_INV_NO " ).append("\n"); 
		query.append("                                           FROM EAS_DOD_INV_MN M," ).append("\n"); 
		query.append("                                                EAS_DOD_INV_DTL D," ).append("\n"); 
		query.append("                                                BL_CNTR CV " ).append("\n"); 
		query.append("                                           WHERE  CV.BKG_NO =  M.BKG_NO" ).append("\n"); 
		query.append("                                           AND CV.CNTR_NO =  D.CNTR_NO" ).append("\n"); 
		query.append("                                           AND M.DOD_INV_STS_CD = 'I' )" ).append("\n"); 
		query.append("                    AND DT.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                    AND ROWNUM = 1  " ).append("\n"); 
		query.append("                   ) AS DOD_INV_NO" ).append("\n"); 
		query.append("              , B.BKG_NO" ).append("\n"); 
		query.append("              , B.BL_NO" ).append("\n"); 
		query.append("              , M.LSTM_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING B," ).append("\n"); 
		query.append("             BKG_CONTAINER C," ).append("\n"); 
		query.append("             MST_CONTAINER M" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND B.BL_NO = @[in_bl_no]" ).append("\n"); 
		query.append("        AND B.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("        AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("        AND C.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("    , EAS_DOD_INV_DTL Y" ).append("\n"); 
		query.append("WHERE X.CNTR_NO = Y.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND X.DOD_INV_NO = Y.DOD_INV_NO(+)" ).append("\n"); 
		query.append("ORDER BY NVL(X.DOD_INV_NO,1), X.CNTR_NO ASC" ).append("\n"); 

	}
}