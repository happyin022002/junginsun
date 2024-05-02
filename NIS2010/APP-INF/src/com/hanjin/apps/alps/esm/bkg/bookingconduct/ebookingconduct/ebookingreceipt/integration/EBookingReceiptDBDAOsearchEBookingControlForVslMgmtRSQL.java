/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchEBookingControlForVslMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchEBookingControlForVslMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEBookingControlForVslMgmt
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchEBookingControlForVslMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchEBookingControlForVslMgmtRSQL").append("\n"); 
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
		query.append("SELECT SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN TEU ELSE 0 END) OVER() AS SUM_TEU," ).append("\n"); 
		query.append("       SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN FEU ELSE 0 END) OVER() AS SUM_FEU," ).append("\n"); 
		query.append("       SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN TEU ELSE 0 END + 2 *" ).append("\n"); 
		query.append("           CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN FEU ELSE 0 END) OVER() AS SUM_TTL," ).append("\n"); 
		query.append("       SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN EST_WGT ELSE 0 END) OVER() AS SUM_WGT," ).append("\n"); 
		query.append("       SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ AND 'F'=BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("           THEN CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN TEU ELSE 0 END + 2 *" ).append("\n"); 
		query.append("                CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN FEU ELSE 0 END" ).append("\n"); 
		query.append("           ELSE 0 END) OVER() AS SUM_ULD," ).append("\n"); 
		query.append("       SUM(CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ AND 'F'!=BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("           THEN CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN TEU ELSE 0 END + 2 *" ).append("\n"); 
		query.append("                CASE WHEN BKG_NO||XTER_RQST_SEQ=BKG_NO||MAX_SEQ THEN FEU ELSE 0 END" ).append("\n"); 
		query.append("           ELSE 0 END) OVER() AS SUM_UNU," ).append("\n"); 
		query.append("       T.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("--------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT MAX(XTER_RQST_SEQ) OVER(PARTITION BY BKG_NO) AS MAX_SEQ," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER(ORDER BY MST.MDFY_XTER_RQST_NO) AS ROW_NUM," ).append("\n"); 
		query.append("       MST.XTER_RQST_ACPT_CD," ).append("\n"); 
		query.append("       TO_CHAR(MST.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT," ).append("\n"); 
		query.append("       MST.BKG_UPLD_STS_CD," ).append("\n"); 
		query.append("       MST.MDFY_XTER_RQST_NO," ).append("\n"); 
		query.append("       MST.XTER_RQST_NO," ).append("\n"); 
		query.append("       MST.XTER_RQST_SEQ," ).append("\n"); 
		query.append("       MST.XTER_BKG_RQST_STS_CD," ).append("\n"); 
		query.append("       MST.SH_NM," ).append("\n"); 
		query.append("       MST.VVD," ).append("\n"); 
		query.append("       POR_CD AS XTER_POR_CD," ).append("\n"); 
		query.append("       DEL_CD AS XTER_DEL_CD," ).append("\n"); 
		query.append("       MST.DEL_CN AS DELIVERY," ).append("\n"); 
		query.append("       MST.FRT_TERM," ).append("\n"); 
		query.append("       NVL((SELECT SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("              FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("               AND SUBSTRB(CNTR_TPSZ_CD,-1) = '2')," ).append("\n"); 
		query.append("           NVL((SELECT SUM(CNTR_QTY)" ).append("\n"); 
		query.append("                  FROM BKG_XTER_QTY" ).append("\n"); 
		query.append("                 WHERE XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                   AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                   AND SUBSTRB(CNTR_TPSZ_CD,-1) = '2'),0)) AS TEU," ).append("\n"); 
		query.append("       NVL((SELECT SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("              FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("               AND SUBSTRB(CNTR_TPSZ_CD,-1) != '2')," ).append("\n"); 
		query.append("           NVL((SELECT SUM(CNTR_QTY)" ).append("\n"); 
		query.append("                  FROM BKG_XTER_QTY" ).append("\n"); 
		query.append("                 WHERE XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                   AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                   AND SUBSTRB(CNTR_TPSZ_CD,-1) != '2'),0)) AS FEU," ).append("\n"); 
		query.append("       MST.EST_WGT," ).append("\n"); 
		query.append("       MST.BKG_NO," ).append("\n"); 
		query.append("       MST.CN_NM," ).append("\n"); 
		query.append("       MST.VSL_ENG_NM," ).append("\n"); 
		query.append("       MST.HNDL_OFC_CD," ).append("\n"); 
		query.append("       MST.DOC_TP_CD," ).append("\n"); 
		query.append("       MST.XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("       MST.POL_CD AS XTER_POL_CD," ).append("\n"); 
		query.append("       MST.POD_CD AS XTER_POD_CD," ).append("\n"); 
		query.append("       TO_CHAR(MST.RQST_DEP_DT, 'YYYY-MM-DD') AS RQST_DEP_DT," ).append("\n"); 
		query.append("       LPAD(MST.SKD_VOY_NO, 4, '0') || MST.SKD_DIR_CD AS SKD_VOY_NO," ).append("\n"); 
		query.append("       MST.PO_NO," ).append("\n"); 
		query.append("       MST.CNTC_EML," ).append("\n"); 
		query.append("       MST.OFC_CD," ).append("\n"); 
		query.append("       MST.UPLD_USR_ID," ).append("\n"); 
		query.append("       MST.UPLD_USR_NM," ).append("\n"); 
		query.append("       TO_CHAR(MST.UPLD_DT, 'YYYY-MM-DD') AS UPLD_DT," ).append("\n"); 
		query.append("       MST.XTER_SNDR_ID," ).append("\n"); 
		query.append("       MST.VSL_CD," ).append("\n"); 
		query.append("       MST.BKG_STS_CD," ).append("\n"); 
		query.append("       MST.SNACCS_SPLIT_NO," ).append("\n"); 
		query.append("       MST.SC_NO," ).append("\n"); 
		query.append("       MST.RFA_NO," ).append("\n"); 
		query.append("       MST.TS_PORT_CD AS POD_CD," ).append("\n"); 
		query.append("       MST.BKG_POD_CD," ).append("\n"); 
		query.append("		MST.SPC_CTRLR_RMK" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT" ).append("\n"); 
		query.append("               NVL(XBK.XTER_RQST_ACPT_CD,'N') AS XTER_RQST_ACPT_CD," ).append("\n"); 
		query.append("               XBK.DOC_TP_CD," ).append("\n"); 
		query.append("               XBK.RQST_DT," ).append("\n"); 
		query.append("               CASE WHEN 1=INSTRB(XBK.XTER_RQST_NO,'B') THEN SUBSTRB(XBK.XTER_RQST_NO,2,LENGTHB(XBK.XTER_RQST_NO)) ELSE XBK.XTER_RQST_NO END AS MDFY_XTER_RQST_NO," ).append("\n"); 
		query.append("               XBK.XTER_RQST_NO," ).append("\n"); 
		query.append("               XBK.XTER_RQST_SEQ," ).append("\n"); 
		query.append("               XBK.XTER_BKG_RQST_STS_CD," ).append("\n"); 
		query.append("               XBK.XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("               XBK.BKG_NO," ).append("\n"); 
		query.append("               XBK.BKG_UPLD_STS_CD," ).append("\n"); 
		query.append("               NVL(SH.CUST_CNT_CD, XSH.CNT_CD) AS SH_CNT," ).append("\n"); 
		query.append("               NVL(SH.CUST_SEQ, XSH.CUST_SEQ) AS SH_SEQ," ).append("\n"); 
		query.append("               NVL(CN.CUST_CNT_CD, XCN.CNT_CD) AS CN_CNT," ).append("\n"); 
		query.append("               NVL(CN.CUST_SEQ, XCN.CUST_SEQ) AS CN_SEQ," ).append("\n"); 
		query.append("               REPLACE(REPLACE(NVL(SH.CUST_NM, XSH.CUST_NM), CHR(13) || CHR(10), ' '), CHR(9), ' ') AS SH_NM," ).append("\n"); 
		query.append("               REPLACE(REPLACE(NVL(CN.CUST_NM, XCN.CUST_NM), CHR(13) || CHR(10), ' '), CHR(9), ' ') AS CN_NM," ).append("\n"); 
		query.append("               XBK.HNDL_OFC_CD," ).append("\n"); 
		query.append("               NVL(BK.POR_CD, XBK.POR_CD) AS POR_CD," ).append("\n"); 
		query.append("               NVL(BK.POL_CD, XBK.POL_CD) AS POL_CD," ).append("\n"); 
		query.append("               NVL(BK.POD_CD, XBK.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("               NVL(BK.DEL_CD, XBK.DEL_CD) AS DEL_CD," ).append("\n"); 
		query.append("               XBK.POR_NM AS XTER_POR_NM," ).append("\n"); 
		query.append("               XBK.POL_NM AS XTER_POL_NM," ).append("\n"); 
		query.append("               XBK.POD_NM AS XTER_POD_NM," ).append("\n"); 
		query.append("               XBK.DEL_NM AS XTER_DEL_NM," ).append("\n"); 
		query.append("               XBK.RQST_DEP_DT," ).append("\n"); 
		query.append("               XBK.VSL_CD||XBK.SKD_VOY_NO||XBK.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               NVL((SELECT VSL_ENG_NM FROM MDM_VSL_CNTR VSL WHERE XBK.VSL_CD = VSL.VSL_CD), XBK.VSL_NM) AS VSL_ENG_NM," ).append("\n"); 
		query.append("               XBK.SKD_VOY_NO," ).append("\n"); 
		query.append("               XBK.SKD_DIR_CD," ).append("\n"); 
		query.append("               XBK.PO_NO," ).append("\n"); 
		query.append("               XBK.CNTC_EML," ).append("\n"); 
		query.append("               (SELECT OFC_CD FROM COM_USER USR WHERE XBK.UPLD_USR_ID = USR.USR_ID) AS OFC_CD," ).append("\n"); 
		query.append("               XBK.UPLD_USR_ID," ).append("\n"); 
		query.append("               (SELECT USR_NM FROM COM_USER USR WHERE XBK.UPLD_USR_ID = USR.USR_ID) AS UPLD_USR_NM," ).append("\n"); 
		query.append("               XBK.UPLD_DT," ).append("\n"); 
		query.append("               XBK.XTER_SNDR_ID," ).append("\n"); 
		query.append("               XBK.RQST_DELT_FLG," ).append("\n"); 
		query.append("               NVL(BK.OB_SREP_CD, XBK.SREP_CD) AS SREP_CD," ).append("\n"); 
		query.append("               RATE.FRT_TERM_CD AS FRT_TERM," ).append("\n"); 
		query.append("               DOC.ACT_WGT AS EST_WGT," ).append("\n"); 
		query.append("               BK.CHN_AGN_CD," ).append("\n"); 
		query.append("               BK.BKG_STS_CD," ).append("\n"); 
		query.append("               XBK.VSL_CD," ).append("\n"); 
		query.append("               XBK.SNACCS_SPLIT_NO," ).append("\n"); 
		query.append("               (SELECT CONTI_CD FROM MDM_LOCATION WHERE CNT_CD LIKE SUBSTR(NVL(NVL(BK.DEL_CD, XBK.DEL_CD), NVL(BK.POD_CD, XBK.POD_CD)), 1, 2) || '%' AND ROWNUM = 1) AS DEL_CN," ).append("\n"); 
		query.append("               BK.SC_NO," ).append("\n"); 
		query.append("               BK.RFA_NO," ).append("\n"); 
		query.append("               NVL(BK.PRE_RLY_PORT_CD,BK.PST_RLY_PORT_CD) AS TS_PORT_CD," ).append("\n"); 
		query.append("               BK.POD_CD AS BKG_POD_CD," ).append("\n"); 
		query.append("				XBK.SPC_CTRLR_RMK" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_CUSTOMER SH," ).append("\n"); 
		query.append("               BKG_CUSTOMER CN," ).append("\n"); 
		query.append("               BKG_CUSTOMER FF," ).append("\n"); 
		query.append("               BKG_XTER_RQST_MST XBK," ).append("\n"); 
		query.append("               BKG_XTER_CUST XSH," ).append("\n"); 
		query.append("               BKG_XTER_CUST XCN," ).append("\n"); 
		query.append("               BKG_XTER_CUST XFF," ).append("\n"); 
		query.append("               BKG_RATE RATE," ).append("\n"); 
		query.append("               BKG_BL_DOC DOC" ).append("\n"); 
		query.append("         WHERE XBK.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND XBK.BKG_NO       = SH.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'S'              = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND XBK.BKG_NO       = CN.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'C'              = CN.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND XBK.BKG_NO       = FF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F'              = FF.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_SNDR_ID = XSH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_NO = XSH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_SEQ= XSH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("           AND 'S'              = XSH.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_SNDR_ID = XCN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_NO = XCN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_SEQ= XCN.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("           AND 'C'              = XCN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_SNDR_ID = XFF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_NO = XFF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("           AND XBK.XTER_RQST_SEQ= XFF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("           AND 'F'              = XFF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND (NVL(XBK.XTER_BKG_RQST_STS_CD,' ') < 'T' OR NVL(XBK.XTER_BKG_RQST_STS_CD,' ') > 'T')" ).append("\n"); 
		query.append("           AND (NVL(XBK.XTER_BL_TP_CD, ' ') < 'H' OR NVL(XBK.XTER_BL_TP_CD, ' ') > 'H')" ).append("\n"); 
		query.append("           AND DECODE(XBK.XTER_SNDR_ID, 'SEANACCS', XBK.SNACCS_MSG_TP_CD, ' ') NOT IN ( 'SAT050', 'SAT054', 'SAT141', 'SAT142', 'SAT146', 'SAT147' )" ).append("\n"); 
		query.append("           AND XBK.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("           AND XBK.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("#if (''!=${bkg_upld_sts_cd})" ).append("\n"); 
		query.append("           AND XBK.BKG_UPLD_STS_CD IN (${bkg_upld_sts_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${hndl_ofc_cd})" ).append("\n"); 
		query.append("           AND @[hndl_ofc_cd] = NVL(XBK.HNDL_OFC_CD, @[hndl_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${vvd})" ).append("\n"); 
		query.append("           AND SUBSTRB(@[vvd],1,4) = XBK.VSL_CD" ).append("\n"); 
		query.append("           AND SUBSTRB(@[vvd],5,4) = XBK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SUBSTRB(@[vvd],9,1) = XBK.SKD_DIR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (''!=${rqst_from_dt})" ).append("\n"); 
		query.append("           AND XBK.RQST_DT > TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (''!=${rqst_to_dt})" ).append("\n"); 
		query.append("           AND XBK.RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${pod_cd})" ).append("\n"); 
		query.append("           AND NVL(BK.PRE_RLY_PORT_CD,BK.PST_RLY_PORT_CD) LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('All'!=${doc_tp_cd} && ''!=${doc_tp_cd})" ).append("\n"); 
		query.append("           AND XBK.DOC_TP_CD IN (${doc_tp_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('All'!=${xter_bkg_rqst_sts_cd} && ''!=${xter_bkg_rqst_sts_cd})" ).append("\n"); 
		query.append("           AND XBK.XTER_BKG_RQST_STS_CD IN (${xter_bkg_rqst_sts_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) MST" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (''!=${chn_agn_cd})" ).append("\n"); 
		query.append("   AND (@[chn_agn_cd] = SUBSTRB(MST.BKG_NO,5,2) OR @[chn_agn_cd] = SUBSTRB(MST.BKG_NO,3,2))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${pol_cd})" ).append("\n"); 
		query.append("   AND MST.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${bkg_pod_cd})" ).append("\n"); 
		query.append("   AND MST.POD_CD LIKE @[bkg_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('All'!=${delivery} && ''!=${delivery})" ).append("\n"); 
		query.append("   AND MST.DEL_CN IN (${delivery})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY MST.MDFY_XTER_RQST_NO" ).append("\n"); 
		query.append("--------------------------------------------------------------------" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}