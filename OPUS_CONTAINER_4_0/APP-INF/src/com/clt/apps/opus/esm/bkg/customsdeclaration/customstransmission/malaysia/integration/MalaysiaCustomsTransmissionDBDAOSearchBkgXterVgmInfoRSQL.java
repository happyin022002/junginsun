/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchBkgXterVgmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.12.21 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchBkgXterVgmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchBkgXterVgmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchBkgXterVgmInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(DOC_ID, '') AS DOC_ID," ).append("\n"); 
		query.append("       'V' AS MEAS_TP," ).append("\n"); 
		query.append("       NVL(VGM_HNDL_DT, '') AS VGM_HNDL_DT," ).append("\n"); 
		query.append("       NVL(XTER_VGM_WGT, '') AS XTER_VGM_WGT," ).append("\n"); 
		query.append("       NVL(VGM_DOC_TP, '') AS VGM_DOC_TP," ).append("\n"); 
		query.append("       CUST_CNTC_TP," ).append("\n"); 
		query.append("       CUST_CNTC_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT BKG_NO," ).append("\n"); 
		query.append("               CNTR_NO," ).append("\n"); 
		query.append("               DOC_ID," ).append("\n"); 
		query.append("               VGM_DOC_TP," ).append("\n"); 
		query.append("               VGM_DT_TP_CD," ).append("\n"); 
		query.append("               VGM_HNDL_DT," ).append("\n"); 
		query.append("               XTER_VGM_WGT," ).append("\n"); 
		query.append("               CUST_CNTC_TP," ).append("\n"); 
		query.append("               CUST_CNTC_NM," ).append("\n"); 
		query.append("               CUST_FAX," ).append("\n"); 
		query.append("               CUST_EML," ).append("\n"); 
		query.append("               VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("               VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY BKG_NO, CNTR_NO ORDER BY VGM_HNDL_DT DESC) AS RNUM" ).append("\n"); 
		query.append("          FROM (SELECT REF_ID AS DOC_ID," ).append("\n"); 
		query.append("                       --'SM1' AS VGM_DOC_TP," ).append("\n"); 
		query.append("                       DECODE(XTER_VGM.USR_ID, 'COD', 'SM1'," ).append("\n"); 
		query.append("                                               '322', 'SM1'," ).append("\n"); 
		query.append("                                               '304', NVL(XTER_VGM.VGM_DOC_TP_CD, 'SM2')," ).append("\n"); 
		query.append("                                               DECODE(XTER_VGM.WGT_TP_CD, 'V', 'SM1', 'C', 'SM2')) AS VGM_DOC_TP," ).append("\n"); 
		query.append("                       'WAT' AS VGM_DT_TP_CD," ).append("\n"); 
		query.append("                       TO_CHAR(XTER_VGM.VGM_CRE_LOCL_DT, 'YYYYMMDDHHMM') AS VGM_HNDL_DT," ).append("\n"); 
		query.append("                       DECODE(ESIG_CO_NM, NULL, '', 'RP') AS CUST_CNTC_TP," ).append("\n"); 
		query.append("                       DECODE(ESIG_CO_NM, NULL, '', ESIG_CO_NM) AS CUST_CNTC_NM," ).append("\n"); 
		query.append("                       NULL AS CUST_FAX," ).append("\n"); 
		query.append("                       XTER_VGM.CUST_EML," ).append("\n"); 
		query.append("                       NULL AS VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("                       NULL AS VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("                       BC.BKG_NO," ).append("\n"); 
		query.append("                       BC.CNTR_NO," ).append("\n"); 
		query.append("                       XTER_VGM.XTER_VGM_RQST_CD AS VGM_VIA," ).append("\n"); 
		query.append("                       BC.VGM_WGT AS XTER_VGM_WGT," ).append("\n"); 
		query.append("                       'K' AS XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                       XTER_VGM.USR_ID AS IN_USR," ).append("\n"); 
		query.append("                       DECODE(XTER_VGM.ESIG_CO_NM, NULL, 'N', 'Y') AS ESIG," ).append("\n"); 
		query.append("                       XTER_VGM.VGM_SEQ AS VGM_SEQ," ).append("\n"); 
		query.append("                       XTER_VGM.ESIG_CO_NM" ).append("\n"); 
		query.append("                  FROM BKG_XTER_VGM XTER_VGM," ).append("\n"); 
		query.append("                       BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE XTER_VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                                 FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                                WHERE BKG_NO = XTER_VGM.BKG_NO" ).append("\n"); 
		query.append("                                                  AND CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("                                                  AND VGM_SEQ = XTER_VGM.VGM_SEQ" ).append("\n"); 
		query.append("                                                  AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("                   AND XTER_VGM.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                   AND XTER_VGM.BKG_NO = BC.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                   AND XTER_VGM.VGM_SEQ = BC.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                   AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND XTER_VGM.USR_ID = BC.XTER_VGM_USR_ID" ).append("\n"); 
		query.append("                   AND BC.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT BXVC.VGM_DOC_ID," ).append("\n"); 
		query.append("                       NVL((SELECT VGM_DOC_TP_CD" ).append("\n"); 
		query.append("                              FROM BKG_XTER_VGM_CUST" ).append("\n"); 
		query.append("                             WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                               AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                               AND BXVR.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                               AND BXVR.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("                               AND VGM_DOC_TP_CD IN ('SM1', 'SM2')" ).append("\n"); 
		query.append("                               AND ROWNUM = 1), 'SM1') VGM_DOC_TP," ).append("\n"); 
		query.append("                       BXVC.VGM_DT_TP_CD," ).append("\n"); 
		query.append("                       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', BXVR.UPD_DT, (SELECT POL_CD" ).append("\n"); 
		query.append("                                                                                     FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                                                                    WHERE BKG_NO = REFNO.REF_NO)), 'YYYYMMDDHHMM') VGM_HNDL_DT," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_CNTC_TP_CD AS CUST_CNTC_TP," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_CNTC_NM AS CUST_CNTC_NM," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_FAX_NO," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_EML," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_PST_ADDR," ).append("\n"); 
		query.append("                       BC.BKG_NO BKG_NO," ).append("\n"); 
		query.append("                       BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                       'EDI' VGM_VIA," ).append("\n"); 
		query.append("                       BC.VGM_WGT XTER_VGM_WGT," ).append("\n"); 
		query.append("                      'K' XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                       BXVR.XTER_SNDR_ID IN_USR," ).append("\n"); 
		query.append("                       DECODE(BXVC.VGM_CUST_CNTC_NM, NULL, 'N', 'Y') ESIG," ).append("\n"); 
		query.append("                       BXVR.XTER_VGM_RQST_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                       BXVC.VGM_CUST_CNTC_NM ESIG_CO_NM" ).append("\n"); 
		query.append("                  FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("                       BKG_XTER_VGM_CUST BXVC," ).append("\n"); 
		query.append("                       BKG_XTER_VGM_REF_NO REFNO," ).append("\n"); 
		query.append("                       BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                   AND BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID(+)" ).append("\n"); 
		query.append("                   AND BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ(+)" ).append("\n"); 
		query.append("                   AND BXVR.CNTR_NO = BXVC.CNTR_NO(+)" ).append("\n"); 
		query.append("                   AND BXVC.VGM_CUST_CNTC_TP_CD(+) = 'RP'" ).append("\n"); 
		query.append("                   AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                   AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                   AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("                   AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                           FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                          WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                            AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                            AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                            AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("                                                            AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("                                                            AND XTER_REF_TP_CD IN ('BN', 'BM')), 0)" ).append("\n"); 
		query.append("                   AND BC.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND BC.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                   AND BC.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("				   AND NVL(BC.XTER_SNDR_ID,'') <> 'WEB'" ).append("\n"); 
		query.append("                   AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   ))" ).append("\n"); 
		query.append("WHERE RNUM = 1" ).append("\n"); 

	}
}