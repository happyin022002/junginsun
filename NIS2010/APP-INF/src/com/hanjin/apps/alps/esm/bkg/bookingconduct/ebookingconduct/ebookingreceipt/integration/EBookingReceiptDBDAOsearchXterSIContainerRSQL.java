/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.06.21 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterSIContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIContainerRSQL").append("\n"); 
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
		query.append("WITH BKG1 AS(" ).append("\n"); 
		query.append("			 SELECT * " ).append("\n"); 
		query.append("			 		FROM(" ).append("\n"); 
		query.append("							 SELECT A.BKG_NO," ).append("\n"); 
		query.append("									A. VPS_ETD_DT," ).append("\n"); 
		query.append("							 		ROW_NUMBER() OVER (PARTITION BY CTM.CNTR_NO ORDER BY CTM.CNMV_CYC_NO DESC , CTM.CNMV_EVNT_DT) RNUM," ).append("\n"); 
		query.append("				                    CNTR.CNTR_NO," ).append("\n"); 
		query.append("				                    CTM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("			                 FROM (                    " ).append("\n"); 
		query.append("				 					SELECT ETD.BKG_NO" ).append("\n"); 
		query.append("					   					  ,ETD.VPS_ETD_DT" ).append("\n"); 
		query.append("					   					  ,ETD.POL_CD" ).append("\n"); 
		query.append("					   					  ,ETD.POR_CD" ).append("\n"); 
		query.append("				 					FROM (" ).append("\n"); 
		query.append("											SELECT VSK.VPS_ETD_DT, BK.BKG_NO, BK.POR_CD, BK.POL_CD" ).append("\n"); 
		query.append("											FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("											WHERE 1=1" ).append("\n"); 
		query.append("											AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("											AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                      						AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("					                      	AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("					                      	AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("					                      	AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("					                      	AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					                      	AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("					                     	ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ  " ).append("\n"); 
		query.append("			      						 ) ETD" ).append("\n"); 
		query.append("		  							WHERE ROWNUM = 1 ) A, CTM_MOVEMENT CTM, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("			 				WHERE A.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("			       			AND CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("			   				AND (CTM.ORG_YD_CD LIKE A.POR_CD||'%' OR CTM.ORG_YD_CD LIKE A.POL_CD||'%')" ).append("\n"); 
		query.append("						    AND CTM.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("						    AND CTM.CNMV_EVNT_DT >= A.VPS_ETD_DT - 45" ).append("\n"); 
		query.append("			       			AND CTM.CNMV_EVNT_DT <= A.VPS_ETD_DT  + 30" ).append("\n"); 
		query.append("							AND (SELECT /*+ INDEX_DESC(CTM, XUK1CTM_MOVEMENT) */ MVMT_STS_CD FROM CTM_MOVEMENT CTM WHERE CNTR_NO = CNTR.CNTR_NO  AND ROWNUM =1 ) NOT IN ('OP','MT')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				  AND RNUM = 1" ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("SELECT X.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append(",      X.CNTR_NO" ).append("\n"); 
		query.append(",	   DECODE(NVL(A.CNTR_NO,'N'),'N','I','U') IBFLAG" ).append("\n"); 
		query.append(",      X.CNTR_NO CNTR_NO_OLD" ).append("\n"); 
		query.append(",      NVL(X.CNTR_TPSZ_CD, A.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      '' CNTR_SEAL_NO" ).append("\n"); 
		query.append(",      ROW_NUMBER() OVER (ORDER BY X.CNTR_SEQ, X.CNTR_NO) CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      NVL(X.PCK_QTY, A.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      NVL(X.PCK_TP_CD, A.PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append(",      NVL(X.CNTR_WGT, A.CNTR_WGT) CNTR_WGT" ).append("\n"); 
		query.append(",      NVL(X.WGT_UT_CD, A.WGT_UT_CD) WGT_UT_CD" ).append("\n"); 
		query.append(",      NVL(X.MEAS_QTY, A.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(X.MEAS_UT_CD, A.MEAS_UT_CD) MEAS_UT_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD" ).append("\n"); 
		query.append(",      A.CNTR_PRT_FLG" ).append("\n"); 
		query.append(",      A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",      A.ADV_SHTG_CD" ).append("\n"); 
		query.append(",      (SELECT B.CNMV_STS_CD FROM MST_CONTAINER B" ).append("\n"); 
		query.append("        WHERE B.CNTR_NO = A.CNTR_NO) CNMV_STS_CD" ).append("\n"); 
		query.append(",      A.HNGR_FLG" ).append("\n"); 
		query.append(",      A.DCGO_FLG" ).append("\n"); 
		query.append(",      A.BB_CGO_FLG" ).append("\n"); 
		query.append(",      A.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      A.RC_FLG" ).append("\n"); 
		query.append(",      DECODE(SUBSTR(NVL(X.CNTR_TPSZ_CD, A.CNTR_TPSZ_CD), 1, 1), 'R', DECODE(A.RC_FLG, 'Y', 'N', 'Y'), NVL(A.RC_FLG, 'Y')) RD_CGO_FLG" ).append("\n"); 
		query.append(",      NVL(X.SOC_FLG, A.SOC_FLG) SOC_FLG" ).append("\n"); 
		query.append(",      A.ORG_YD_CD" ).append("\n"); 
		query.append(",      (SELECT TO_CHAR(B.CNMV_DT, 'YYYYMMDDHH24MI') FROM MST_CONTAINER B" ).append("\n"); 
		query.append("        WHERE B.CNTR_NO = A.CNTR_NO) CNMV_EVNT_DT" ).append("\n"); 
		query.append(",      NVL2(A.CGO_RCV_DT, 'Y', 'N') AS CGO_RCV_DT_FLG" ).append("\n"); 
		query.append(",      DECODE(CGO_RCV_DT, NULL,TO_CHAR(BKG1.CNMV_EVNT_DT,'YYYYMMDDHH24MI'),TO_CHAR(CGO_RCV_DT, 'YYYYMMDDHH24MI')) CGO_RCV_DT" ).append("\n"); 
		query.append(",      NVL(X.PO_NO, A.PO_NO) PO_NO" ).append("\n"); 
		query.append(",      DIFF_RMK" ).append("\n"); 
		query.append(",      CNTR_CFM_FLG" ).append("\n"); 
		query.append(",      DO_NO" ).append("\n"); 
		query.append(",      (SELECT DECODE(COUNT(CNTR_MF_SEQ), '0', 'N', 'Y')" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_FLG" ).append("\n"); 
		query.append(",      (SELECT COUNT(SA.IMG_SEQ)" ).append("\n"); 
		query.append("        FROM   BKG_IMG_STO SA, BKG_DG_CGO SB" ).append("\n"); 
		query.append("        WHERE  SB.BKG_NO = SA.BKG_NO" ).append("\n"); 
		query.append("        AND    SB.DCGO_SEQ = SA.DCGO_SEQ" ).append("\n"); 
		query.append("        AND    SB.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    SB.CNTR_NO = A.CNTR_NO) DCGO_CNT" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",	   BK.POL_CD" ).append("\n"); 
		query.append(",      x.VGM_WGT" ).append("\n"); 
		query.append(",      x.VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",x.VGM_DTMN_DT" ).append("\n"); 
		query.append(",x.VGM_MZD_TP_CD" ).append("\n"); 
		query.append(",x.VGM_VRFY_DT" ).append("\n"); 
		query.append(",x.VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_BOOKING BK, BKG1, " ).append("\n"); 
		query.append("       (SELECT M.BKG_NO" ).append("\n"); 
		query.append("            , M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            , M.XTER_RQST_NO" ).append("\n"); 
		query.append("            , M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            , CNTR.CNTR_NO" ).append("\n"); 
		query.append("            , CNTR.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            , CNTR.CNTR_SEQ" ).append("\n"); 
		query.append("            , CNTR.PCK_QTY" ).append("\n"); 
		query.append("            , CNTR.PCK_TP_CD" ).append("\n"); 
		query.append("            , CNTR.CNTR_WGT" ).append("\n"); 
		query.append("            , CNTR.WGT_UT_CD" ).append("\n"); 
		query.append("            , CNTR.MEAS_QTY" ).append("\n"); 
		query.append("            , CNTR.MEAS_UT_CD" ).append("\n"); 
		query.append("            , CNTR.PO_NO" ).append("\n"); 
		query.append("            , CNTR.PRT_FLG" ).append("\n"); 
		query.append("            , CNTR.SOC_FLG" ).append("\n"); 
		query.append(",      VGM_WGT" ).append("\n"); 
		query.append(",      VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",VGM_DTMN_DT" ).append("\n"); 
		query.append(",VGM_MZD_TP_CD" ).append("\n"); 
		query.append(",VGM_VRFY_DT" ).append("\n"); 
		query.append(",VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("      FROM BKG_XTER_CNTR CNTR, BKG_XTER_RQST_MST M" ).append("\n"); 
		query.append("     WHERE CNTR.XTER_SNDR_ID =  M.XTER_SNDR_ID" ).append("\n"); 
		query.append("       AND CNTR.XTER_RQST_NO =  M.XTER_RQST_NO" ).append("\n"); 
		query.append("       AND CNTR.XTER_RQST_SEQ=  M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("       AND CNTR.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("       AND CNTR.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("       AND CNTR.XTER_RQST_SEQ= @[xter_rqst_seq]) X" ).append("\n"); 
		query.append("WHERE  X.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("  AND  X.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("  AND  X.CNTR_NO = A.CNTR_NO(+) " ).append("\n"); 
		query.append("  AND  A.BKG_NO = BKG1.BKG_NO(+)" ).append("\n"); 
		query.append("  AND  A.CNTR_NO = BKG1.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY X.CNTR_SEQ, X.CNTR_NO" ).append("\n"); 

	}
}