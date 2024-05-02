/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrEtcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
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

public class BLDocumentationCMDBDAOCntrEtcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrEtcInfoRSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOCntrEtcInfoRSQL").append("\n"); 
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
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(C.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.POR_CD||SUBSTR(A.POR_NOD_CD,6,2) POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD||SUBSTR(A.POL_NOD_CD,6,2) POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD||SUBSTR(A.POD_NOD_CD,6,2) POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD||SUBSTR(A.DEL_NOD_CD,6,2) DEL_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', B.EVNT_USR_ID, '') EVNT_USR_ID" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', TO_CHAR(B.EVNT_DT, 'YYYY-MM-DD'), '') EVNT_DT" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', 'Y', 'N') FNL_CFM_FLG" ).append("\n"); 
		query.append(",      '' MODIFY_FNL_CFM_FLG" ).append("\n"); 
		query.append(",      (SELECT WGT_UT_CD FROM BKG_CNTR_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO = 'TMP0000001' AND ROWNUM=1) BKG_WGT_UT_CD" ).append("\n"); 
		query.append(",      (SELECT MEAS_UT_CD FROM BKG_CNTR_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO = 'TMP0000001' AND ROWNUM=1) BKG_MEAS_UT_CD" ).append("\n"); 
		query.append(",      (SELECT TO_CHAR(MAX(CGO_RCV_DT), 'YYYY-MM-DD') FROM BKG_CNTR_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO = 'TMP0000001') CGO_RCV_DT" ).append("\n"); 
		query.append(",      (SELECT NVL2(CORR_NO, 'Y', 'N') FROM BKG_BL_DOC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO = 'TMP0000001') CORR_FLG" ).append("\n"); 
		query.append(",      (SELECT BDR_FLG FROM BKG_BL_DOC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO = 'TMP0000001') BDR_FLG" ).append("\n"); 
		query.append(",      'N' NOT_UPDATED_FLG" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND (POL_CD LIKE 'CN%' OR POD_CD LIKE 'CN%') AND ROWNUM=1) CN_FLG" ).append("\n"); 
		query.append(",      A.FLEX_HGT_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A" ).append("\n"); 
		query.append(",      (SELECT *" ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("        ,            BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("        ,            DOC_PROC_SEQ" ).append("\n"); 
		query.append("        ,            EVNT_USR_ID" ).append("\n"); 
		query.append("        ,            EVNT_DT" ).append("\n"); 
		query.append("        ,            UPD_DT" ).append("\n"); 
		query.append("        ,            row_number() over(partition by BKG_NO order by upd_dt desc, rownum desc, rowid desc) row_no" ).append("\n"); 
		query.append("              FROM   BKG_DOC_PROC_SKD_HIS" ).append("\n"); 
		query.append("              WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("              AND    BKG_DOC_PROC_TP_CD IN('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("              AND    DOC_PERF_DELT_FLG = 'N') " ).append("\n"); 
		query.append("        WHERE  row_no = 1) B" ).append("\n"); 
		query.append(",      BKG_BL_ISS_HIS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.CORR_NO = C.CORR_NO(+)" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(C.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.POR_CD||SUBSTR(A.POR_NOD_CD,6,2) POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD||SUBSTR(A.POL_NOD_CD,6,2) POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD||SUBSTR(A.POD_NOD_CD,6,2) POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD||SUBSTR(A.DEL_NOD_CD,6,2) DEL_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', B.EVNT_USR_ID, '') EVNT_USR_ID" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', TO_CHAR(B.EVNT_DT, 'YYYY-MM-DD'), '') EVNT_DT" ).append("\n"); 
		query.append(",      DECODE(B.BKG_DOC_PROC_TP_CD, 'CNTCFM', 'Y', 'N') FNL_CFM_FLG" ).append("\n"); 
		query.append(",      '' MODIFY_FNL_CFM_FLG" ).append("\n"); 
		query.append(",      (SELECT WGT_UT_CD FROM BKG_CONTAINER WHERE BKG_NO=A.BKG_NO AND ROWNUM=1) BKG_WGT_UT_CD" ).append("\n"); 
		query.append(",      (SELECT MEAS_UT_CD FROM BKG_CONTAINER WHERE BKG_NO=A.BKG_NO AND ROWNUM=1) BKG_MEAS_UT_CD" ).append("\n"); 
		query.append(",      (SELECT TO_CHAR(MAX(CGO_RCV_DT), 'YYYY-MM-DD') FROM BKG_CONTAINER WHERE BKG_NO=A.BKG_NO) CGO_RCV_DT" ).append("\n"); 
		query.append(",      (SELECT NVL2(CORR_NO, 'Y', 'N') FROM BKG_BL_DOC WHERE BKG_NO=A.BKG_NO) CORR_FLG" ).append("\n"); 
		query.append(",      (SELECT BDR_FLG FROM BKG_BL_DOC WHERE BKG_NO=A.BKG_NO) BDR_FLG" ).append("\n"); 
		query.append(",      'N' NOT_UPDATED_FLG" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD WHERE BKG_NO=A.BKG_NO AND (POL_CD LIKE 'CN%' OR POD_CD LIKE 'CN%') AND ROWNUM=1) CN_FLG" ).append("\n"); 
		query.append(",      A.FLEX_HGT_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append(",      (SELECT *" ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO" ).append("\n"); 
		query.append(",              BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append(",              DOC_PROC_SEQ" ).append("\n"); 
		query.append(",              EVNT_USR_ID" ).append("\n"); 
		query.append(",              EVNT_DT" ).append("\n"); 
		query.append(",              UPD_DT" ).append("\n"); 
		query.append(",              row_number() over(partition by BKG_NO order by upd_dt desc, rownum desc, rowid desc) row_no" ).append("\n"); 
		query.append("        FROM   BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    BKG_DOC_PROC_TP_CD IN('CNTCFM', 'CNTRLS')" ).append("\n"); 
		query.append("        AND    DOC_PERF_DELT_FLG = 'N') " ).append("\n"); 
		query.append("        WHERE  row_no = 1) B" ).append("\n"); 
		query.append(",      BKG_BL_ISS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}