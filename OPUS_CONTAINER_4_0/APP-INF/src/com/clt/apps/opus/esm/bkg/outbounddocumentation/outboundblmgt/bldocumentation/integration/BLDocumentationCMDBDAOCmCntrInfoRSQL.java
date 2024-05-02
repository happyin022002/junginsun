/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12 
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

public class BLDocumentationCMDBDAOCmCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmCntrInfoRSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOCmCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      DECODE(MF_CFM_FLG, 'N', '0', '1') MF_CFM_FLG" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      (SELECT DECODE(COUNT(CNTR_MF_SEQ), '', 'N', '0', 'N', 'Y')" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CNTR_MF_FLAG" ).append("\n"); 
		query.append(",      BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                           FROM   BKG_CNTR_SEAL_NO_HIS" ).append("\n"); 
		query.append("                           WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                           AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                           AND    CNTR_NO = A.CNTR_NO)) CNTR_SEAL_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      RCV_TERM_CD" ).append("\n"); 
		query.append(",      DE_TERM_CD" ).append("\n"); 
		query.append(",      CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      ADV_SHTG_CD" ).append("\n"); 
		query.append(",      DCGO_FLG" ).append("\n"); 
		query.append(",      BB_CGO_FLG" ).append("\n"); 
		query.append(",      AWK_CGO_FLG" ).append("\n"); 
		query.append(",      RC_FLG" ).append("\n"); 
		query.append(",      RD_CGO_FLG" ).append("\n"); 
		query.append(",      HNGR_FLG" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CNTR_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      MEAS_QTY" ).append("\n"); 
		query.append(",      MEAS_UT_CD" ).append("\n"); 
		query.append(",      (SELECT SUM(PCK_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_PCK_QTY" ).append("\n"); 
		query.append(",      (SELECT SUM(CNTR_MF_WGT)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_CNTR_WGT" ).append("\n"); 
		query.append(",      (SELECT SUM(MEAS_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_MEAS_QTY" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_CNTR_HIS A" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("ORDER BY CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      DECODE(MF_CFM_FLG, 'N', '0', '1') MF_CFM_FLG" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      (SELECT DECODE(COUNT(CNTR_MF_SEQ), '', 'N', '0', 'N', 'Y')" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CNTR_MF_FLAG" ).append("\n"); 
		query.append(",      BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                           FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                           WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                           AND    CNTR_NO = A.CNTR_NO)) CNTR_SEAL_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      RCV_TERM_CD" ).append("\n"); 
		query.append(",      DE_TERM_CD" ).append("\n"); 
		query.append(",      CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      ADV_SHTG_CD" ).append("\n"); 
		query.append(",      DCGO_FLG" ).append("\n"); 
		query.append(",      BB_CGO_FLG" ).append("\n"); 
		query.append(",      AWK_CGO_FLG" ).append("\n"); 
		query.append(",      RC_FLG" ).append("\n"); 
		query.append(",      RD_CGO_FLG" ).append("\n"); 
		query.append(",      HNGR_FLG" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CNTR_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      MEAS_QTY" ).append("\n"); 
		query.append(",      MEAS_UT_CD" ).append("\n"); 
		query.append(",      (SELECT SUM(PCK_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_PCK_QTY" ).append("\n"); 
		query.append(",      (SELECT SUM(CNTR_MF_WGT)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_CNTR_WGT" ).append("\n"); 
		query.append(",      (SELECT SUM(MEAS_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_NO = A.CNTR_NO) CM_MEAS_QTY" ).append("\n"); 
		query.append(",      CRE_USR_ID" ).append("\n"); 
		query.append(",      UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A" ).append("\n"); 
		query.append("WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}