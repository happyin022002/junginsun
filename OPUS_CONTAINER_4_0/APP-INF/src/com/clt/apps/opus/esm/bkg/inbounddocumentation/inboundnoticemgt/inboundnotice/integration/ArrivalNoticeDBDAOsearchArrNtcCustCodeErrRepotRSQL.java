/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRepotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRepotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Code Error Report
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRepotRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRepotRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("      , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      , BL_NO" ).append("\n"); 
		query.append("      , CUST_TP_CD" ).append("\n"); 
		query.append("      , CUST_TP_CD_NM" ).append("\n"); 
		query.append("      , ERR_CD" ).append("\n"); 
		query.append("      , CRT_CD" ).append("\n"); 
		query.append("      , CD_CRE_DT" ).append("\n"); 
		query.append("      , EVL_RST_CD" ).append("\n"); 
		query.append("      , EVL_RST_NM" ).append("\n"); 
		query.append("      , CD_INPUT_OFC_CD" ).append("\n"); 
		query.append("      , CD_INPUT_USR_ID" ).append("\n"); 
		query.append("      , CD_INPUT_DT" ).append("\n"); 
		query.append("      , BKG_OFC_CD" ).append("\n"); 
		query.append("      , EVL_OFC_CD" ).append("\n"); 
		query.append("      , EVL_USR_ID" ).append("\n"); 
		query.append("      , EVL_DT" ).append("\n"); 
		query.append("      , OB_EV_CD" ).append("\n"); 
		query.append("      , IB_EV_CD" ).append("\n"); 
		query.append("      , HQ_EV_CD" ).append("\n"); 
		query.append("      , ROW_COUNT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  BKGM.BKG_NO" ).append("\n"); 
		query.append("              , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("              , BKGM.BL_NO -- 1" ).append("\n"); 
		query.append("              , BCST.BKG_CUST_TP_CD CUST_TP_CD -- 2" ).append("\n"); 
		query.append("              , CDTL.INTG_CD_VAL_DP_DESC CUST_TP_CD_NM" ).append("\n"); 
		query.append("              , BCST.ORG_CUST_CNT_CD || DECODE(BCST.ORG_CUST_SEQ, 0, NULL, LPAD(BCST.ORG_CUST_SEQ, 6, '0')) ERR_CD -- 3" ).append("\n"); 
		query.append("              , BCST.CUST_CNT_CD || DECODE(BCST.CUST_SEQ, 0, NULL, LPAD(BCST.CUST_SEQ, 6, '0')) CRT_CD -- 4" ).append("\n"); 
		query.append("              , TO_CHAR(MCST.EAI_EVNT_DT, 'YYYYMMDD') CD_CRE_DT -- 5" ).append("\n"); 
		query.append("              , BCST.VAL_CD EVL_RST_CD -- 6" ).append("\n"); 
		query.append("              , DECODE(BCST.MTCH_FLG, 'Y', 'AUTO', VACD.INTG_CD_VAL_DP_DESC) AS EVL_RST_NM -- 7" ).append("\n"); 
		query.append("              , NVL((SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                      WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = BCST.HIS_CUST_CD_MAX)," ).append("\n"); 
		query.append("                    (SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                      WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = BCST.HIS_CUST_NM_MAX)) CD_INPUT_OFC_CD" ).append("\n"); 
		query.append("              , NVL((SELECT CRE_USR_ID FROM BKG_HIS_DTL WHERE BKG_NO = BKGM.BKG_NO AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = BCST.HIS_CUST_CD_MAX)," ).append("\n"); 
		query.append("                    (SELECT CRE_USR_ID FROM BKG_HIS_DTL WHERE BKG_NO = BKGM.BKG_NO AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = BCST.HIS_CUST_NM_MAX)) CD_INPUT_USR_ID" ).append("\n"); 
		query.append("              , TO_CHAR(BCST.CUST_CD_UPD_DT, 'YYYYMMDD') CD_INPUT_DT -- 9" ).append("\n"); 
		query.append("              , BKGM.BKG_OFC_CD" ).append("\n"); 
		query.append("              , BCST.VAL_OFC_CD EVL_OFC_CD -- 10" ).append("\n"); 
		query.append("              , BCST.VAL_USR_ID EVL_USR_ID -- 11" ).append("\n"); 
		query.append("              , TO_CHAR(BCST.VAL_DT, 'YYYYMMDD') EVL_DT -- 12" ).append("\n"); 
		query.append("              , DECODE(BCST.OB_EV_CD, 'C' , 1, 0) OB_EV_CD" ).append("\n"); 
		query.append("              , DECODE(BCST.IB_EV_CD, 'C' , 1, 0) IB_EV_CD" ).append("\n"); 
		query.append("              , DECODE(BCST.HQ_EV_CD, 'C' , 1, 0) HQ_EV_CD" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER (ORDER BY BKGM.BKG_CRE_DT DESC, BCST.BKG_CUST_TP_CD ) ROW_NUM" ).append("\n"); 
		query.append("              , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("          FROM  (" ).append("\n"); 
		query.append("                   SELECT /*+ INDEX(BMST XPKBKG_HIS_MST) */" ).append("\n"); 
		query.append("                          DISTINCT BKGM.ROWID RID," ).append("\n"); 
		query.append("                          BCST.CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("                          BCST.VAL_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.MTCH_FLG," ).append("\n"); 
		query.append("                          BCST.VAL_OFC_CD," ).append("\n"); 
		query.append("                          BCST.VAL_USR_ID," ).append("\n"); 
		query.append("                          BCST.VAL_DT," ).append("\n"); 
		query.append("                          BCST.OB_EV_CD," ).append("\n"); 
		query.append("                          BCST.IB_EV_CD," ).append("\n"); 
		query.append("                          BCST.HQ_EV_CD," ).append("\n"); 
		query.append("                          BCST.CUST_CD_UPD_DT," ).append("\n"); 
		query.append("                          (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_05'" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE CD%', 'N', 'NTFY CD%', 'S', 'SHPR CD%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_CD_MAX," ).append("\n"); 
		query.append("                          (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_05'" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE NM%', 'N', 'NTFY NM%', 'S', 'SHPR NM%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_NM_MAX" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                          BKG_HIS_MST BMST," ).append("\n"); 
		query.append("                          BKG_HIS_DTL BHIS," ).append("\n"); 
		query.append("                          BKG_CUSTOMER BCST," ).append("\n"); 
		query.append("                          COM_USER" ).append("\n"); 
		query.append("                    WHERE BKGM.BKG_NO = BMST.BKG_NO" ).append("\n"); 
		query.append("                      AND BMST.BKG_NO = BHIS.BKG_NO" ).append("\n"); 
		query.append("                      AND BMST.HIS_SEQ = BHIS.HIS_SEQ" ).append("\n"); 
		query.append("                      AND BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                      AND COM_USER.USR_ID = BHIS.CRE_USR_ID" ).append("\n"); 
		query.append("#if ( ${bkg_cre_dt_s} != '' && ${bkg_cre_dt_e} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT >= TO_DATE(@[bkg_cre_dt_s], 'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT <  TO_DATE(@[bkg_cre_dt_e], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND BMST.BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_05'" ).append("\n"); 
		query.append("                      AND (HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE CD%', 'N', 'NTFY CD%', 'S', 'SHPR CD%') OR HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE NM%', 'N', 'NTFY NM%', 'S', 'SHPR NM%'))" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD IN ('C','N')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_STS_CD NOT IN( 'X', 'S')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("                      AND (" ).append("\n"); 
		query.append("                            (BKGM.SAM_CNEE_NTFY_FLG = 'N'" ).append("\n"); 
		query.append("                             AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if ( ${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_OFC_CD  = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${code_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND COM_USER.OFC_CD = @[code_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                      AND BCST.MTCH_FLG = @[mtch_flg]" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("#if ( ${mtch_flg} == 'N')" ).append("\n"); 
		query.append("                      AND NVL(BCST.VAL_CD,' ') NOT IN ('C','X' ) -- C, X는 제외됨 X(Auto-Cancel)은 이미 제외되므로 변경사항 없음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${mtch_flg} == 'N' && ${val_cd} != '') " ).append("\n"); 
		query.append("                      AND BCST.VAL_CD = @[val_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${mtch_flg} == 'N' && ${ob_ev_cd} != '') " ).append("\n"); 
		query.append("                      AND BCST.OB_EV_CD = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${mtch_flg} == 'N' && ${ib_ev_cd} != '') " ).append("\n"); 
		query.append("                      AND BCST.IB_EV_CD = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${mtch_flg} == 'N' && ${hq_ev_cd} != '') " ).append("\n"); 
		query.append("                      AND BCST.HQ_EV_CD = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${doc_usr_id} != '')" ).append("\n"); 
		query.append("                      AND BKGM.DOC_USR_ID LIKE @[doc_usr_id] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cust_tp_cd} != '')" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${val_dt_s} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_DT BETWEEN TO_DATE (@[val_dt_s], 'YYYYMMDD') AND (TO_DATE(@[val_dt_e], 'YYYYMMDD') + 1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${val_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_OFC_CD = @[val_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cust_cd} != '')" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_CNT_CD = SUBSTR(@[cust_cd], 1,2)" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_SEQ    = TO_NUMBER(SUBSTR(@[cust_cd], 3,6))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${val_usr_id} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_USR_ID LIKE @[val_usr_id] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${bl_no} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) BCST," ).append("\n"); 
		query.append("                BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                MDM_CUSTOMER MCST," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL CDTL," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL VACD" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  BCST.RID = BKGM.ROWID" ).append("\n"); 
		query.append("           AND  MCST.CUST_CNT_CD (+) = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND  MCST.CUST_SEQ (+) = BCST.CUST_SEQ" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_ID = 'CD00880'" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_VAL_CTNT = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_ID (+) = 'CD01655'" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_VAL_CTNT (+) = BCST.VAL_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append(" WHERE  ROW_NUM > (TO_NUMBER(@[page_no]) -1) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("   AND  ROW_NUM <= TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}