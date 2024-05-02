/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmBkgInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmBkgInfoRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(E.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD " ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CORR_FLG" ).append("\n"); 
		query.append(",      'N' HTS_FLG" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append(",      C.CUST_CNT_CD SHPR_CNT_CD" ).append("\n"); 
		query.append(",      C.CUST_SEQ SHPR_SEQ" ).append("\n"); 
		query.append(",      C.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(",      D.CUST_CNT_CD CNEE_CNT_CD" ).append("\n"); 
		query.append(",      D.CUST_SEQ CNEE_SEQ" ).append("\n"); 
		query.append(",      D.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO = A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC_HIS WHERE BKG_NO = A.BKG_NO AND CORR_NO='TMP0000001') BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND VSL_PRE_PST_CD||VSL_SEQ<>'S1' AND POL_CD='MYPKG') MYPKG_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",	   DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD),'E','Y','N') EUR_FLG" ).append("\n"); 
		query.append(",      TO_CHAR(BKG_HS_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no],'Y'),'YYYY-MM-DD') AS HS_APLY_DT" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A, BKG_BL_DOC_HIS B, BKG_CUST_HIS C, BKG_CUST_HIS D, BKG_BL_ISS_HIS E" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    D.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    D.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("AND    E.CORR_NO(+) = A.CORR_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(E.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD " ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CORR_FLG" ).append("\n"); 
		query.append(",      'N' HTS_FLG" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append(",      C.CUST_CNT_CD SHPR_CNT_CD" ).append("\n"); 
		query.append(",      C.CUST_SEQ SHPR_SEQ" ).append("\n"); 
		query.append(",      C.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(",      D.CUST_CNT_CD CNEE_CNT_CD" ).append("\n"); 
		query.append(",      D.CUST_SEQ CNEE_SEQ" ).append("\n"); 
		query.append(",      D.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO = A.BKG_NO AND MK_SEQ = 1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = A.BKG_NO) BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD WHERE BKG_NO=A.BKG_NO AND VSL_PRE_PST_CD||VSL_SEQ<>'S1' AND POL_CD='MYPKG') MYPKG_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",	   DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD),'E','Y','N') EUR_FLG" ).append("\n"); 
		query.append(",      TO_CHAR(BKG_HS_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no],'N'),'YYYY-MM-DD') AS HS_APLY_DT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_CUSTOMER C, BKG_CUSTOMER D, BKG_BL_ISS E" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    D.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}