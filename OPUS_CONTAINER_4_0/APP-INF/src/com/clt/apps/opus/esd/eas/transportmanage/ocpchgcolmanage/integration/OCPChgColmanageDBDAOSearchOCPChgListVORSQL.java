/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OCPChgColmanageDBDAOSearchOCPChgListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.28
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2010.12.28 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OCPChgColmanageDBDAOSearchOCPChgListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOCPChgListVO 생성
	  * </pre>
	  */
	public OCPChgColmanageDBDAOSearchOCPChgListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_mt_rtn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnee_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.integration").append("\n"); 
		query.append("FileName : OCPChgColmanageDBDAOSearchOCPChgListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      LOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("                WHERE LOC.LOC_CD = SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("         )                                          AS CTRL_OFC_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS BKG_STS_CD," ).append("\n"); 
		query.append("           MVM.BKG_NO," ).append("\n"); 
		query.append("           MVM.CNTR_NO," ).append("\n"); 
		query.append("           MVM.CNTR_TPSZ_CD                         AS TS_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS RCV_TM," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.DE_TERM_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS DEL_TM,           " ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      SHR.CUST_CNT_CD" ).append("\n"); 
		query.append("                   || LTRIM (TO_CHAR (NVL (SHR.CUST_SEQ, 0), '000000'))" ).append("\n"); 
		query.append("                 FROM BKG_CUSTOMER     SHR" ).append("\n"); 
		query.append("                WHERE SHR.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                  AND SHR.BKG_NO         = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS SHPR_NO," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      CNE.CUST_CNT_CD" ).append("\n"); 
		query.append("                   || LTRIM (TO_CHAR (NVL (CNE.CUST_SEQ, 0), '000000'))" ).append("\n"); 
		query.append("                 FROM BKG_CUSTOMER     CNE" ).append("\n"); 
		query.append("                WHERE CNE.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                  AND CNE.BKG_NO         = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS CNEE_NO," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.POR_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS POR_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.POL_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS POL_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.POD_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS POD_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BKG.DEL_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS DEL_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      NVL (BKG.SC_NO, BKG.RFA_NO)" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS SC_RFA_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      MV2.ORG_YD_CD" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("         )                                          AS IB_RLSE_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      TO_CHAR (MV2.CNMV_EVNT_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("         )                                          AS IB_RLSE_DT," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      COUNT (1)" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_CYC_NO = MV2.CNMV_CYC_NO" ).append("\n"); 
		query.append("                  AND MV2.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("         )                                          AS IB_RLSE_CNT," ).append("\n"); 
		query.append("           MVM.ORG_YD_CD                            AS MT_RTN_CD," ).append("\n"); 
		query.append("           TO_CHAR (MVM.CNMV_EVNT_DT, 'YYYYMMDD')   AS MT_RTN_DT," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BCR.CURR_CD" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT           BCR," ).append("\n"); 
		query.append("                      AGT_CNTR_PERTP_MPG_V MPG" ).append("\n"); 
		query.append("                WHERE BCR.CHG_CD = 'OCP'" ).append("\n"); 
		query.append("                  AND MVM.CNTR_TPSZ_CD     = MPG.CNTR_TP" ).append("\n"); 
		query.append("                  AND BCR.RAT_UT_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      'BX', 'BL', 'UN', 'PC', 'HC', MPG.REP_TP, MVM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  AND BCR.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("         )                                          AS BKG_OCP_TP," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      BCR.CHG_AMT / RAT_AS_QTY" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT           BCR," ).append("\n"); 
		query.append("                      AGT_CNTR_PERTP_MPG_V MPG" ).append("\n"); 
		query.append("                WHERE BCR.CHG_CD = 'OCP'" ).append("\n"); 
		query.append("                  AND MVM.CNTR_TPSZ_CD     = MPG.CNTR_TP" ).append("\n"); 
		query.append("                  AND BCR.RAT_UT_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      'BX', 'BL', 'UN', 'PC', 'HC', MPG.REP_TP, MVM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  AND BCR.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("         )                                          AS BKG_OCP_AMT," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      SUBSTR" ).append("\n"); 
		query.append("                    ( XMLAGG" ).append("\n"); 
		query.append("                    ( XMLELEMENT" ).append("\n"); 
		query.append("                    ( A,',' || OTS.N3PTY_NO" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    ).EXTRACT('//text()') --'//text()'는 반드시 소문자이어야 합니다." ).append("\n"); 
		query.append("                    , 2" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                 FROM TPB_OTS_DTL OTS" ).append("\n"); 
		query.append("                WHERE OTS.BKG_NO    = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND OTS.CRE_DT" ).append("\n"); 
		query.append("                    =" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                          SELECT" ).append("\n"); 
		query.append("                                 MIN (OTD.CRE_DT)" ).append("\n"); 
		query.append("                            FROM TPB_OTS_DTL OTD" ).append("\n"); 
		query.append("                           WHERE OTD.BKG_NO = OTS.BKG_NO" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  AND OTS.IF_RHQ_CD       ='NYCNA'" ).append("\n"); 
		query.append("                  AND OTS.N3PTY_BIL_TP_CD ='TR'" ).append("\n"); 
		query.append("             GROUP BY OTS.BKG_NO" ).append("\n"); 
		query.append("         )                                          AS TPB_CD," ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("         WHEN EXISTS (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                        1" ).append("\n"); 
		query.append("                FROM TRS_EXPN_AUD_RMK RMK" ).append("\n"); 
		query.append("                WHERE RMK.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("				  AND EAS_EXPN_TP_CD = 'CO' " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("         END                                        AS RMK_CTNT" ).append("\n"); 
		query.append("      FROM CTM_MOVEMENT MVM" ).append("\n"); 
		query.append("     WHERE MVM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("       AND SUBSTR (MVM.ORG_YD_CD, 1, 2)" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("             DISTINCT LOC.CNT_CD" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("                WHERE LOC.CONTI_CD       = 'M'" ).append("\n"); 
		query.append("                  AND LOC.DELT_FLG     <>  'Y'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       AND" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                 WHEN MVM.BKG_NO IS NULL" ).append("\n"); 
		query.append("                 THEN 'XXXXXX'" ).append("\n"); 
		query.append("                 ELSE SUBSTR (MV2.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.CNTR_NO    = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_YR    = MVM.CNMV_YR" ).append("\n"); 
		query.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO" ).append("\n"); 
		query.append("         ) = SUBSTR (MVM.ORG_YD_CD, 1, 5) " ).append("\n"); 
		query.append("       AND" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      SUBSTR (MV2.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.CNTR_NO    = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_YR    = MVM.CNMV_YR" ).append("\n"); 
		query.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    NOT IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USLGB'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USLAX'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USKCK'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USMKC'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSEA'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USTIW'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USCHS'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USSAV'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("--                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USTLL'" ).append("\n"); 
		query.append("--                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USDAL'" ).append("\n"); 
		query.append("--                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("--                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USBOS'" ).append("\n"); 
		query.append("--                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USNYC'" ).append("\n"); 
		query.append("--                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("--                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USILM'" ).append("\n"); 
		query.append("--                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USSAV'" ).append("\n"); 
		query.append("--                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USLAX'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USLGB'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USMKC'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USKCK'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USTIW'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USSEA'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSAV'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USCHS'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USDAL'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USTLL'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USNYC'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USBOS'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSAV'" ).append("\n"); 
		query.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USILM'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 WHEN SUBSTR (MV2.ORG_YD_CD, 1, 2) <> 'US'" ).append("\n"); 
		query.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                 ELSE SUBSTR (MV2.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT MV2" ).append("\n"); 
		query.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO" ).append("\n"); 
		query.append("                  AND MV2.CNMV_CYC_NO = MV2.CNMV_CYC_NO" ).append("\n"); 
		query.append("                  AND MV2.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       AND EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      1" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG" ).append("\n"); 
		query.append("                WHERE BKG.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                  AND BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND NVL (BKG.OCP_CD,'X') <>  SUBSTR (MVM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("----+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("----++ BOOKING NUMBER Condition +++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("----+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("#if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("       AND MVM.BKG_NO = @[s_bkg_no] --:BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--++ MT Return Period Condition +++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("#if (${fm_dt} != '')" ).append("\n"); 
		query.append("       AND MVM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE (@[fm_dt], 'YYYYMMDD')           --:FR_DT" ).append("\n"); 
		query.append("       AND TO_DATE (@[to_dt], 'YYYYMMDD') + 0.99999 --:TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--++ Control Office Condition +++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("#if (${s_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      1" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING  BKG," ).append("\n"); 
		query.append("                      MDM_LOCATION LOC" ).append("\n"); 
		query.append("                WHERE BKG.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                  AND BKG.DEL_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("                  AND BKG.BKG_NO = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND LOC.EQ_CTRL_OFC_CD = @[s_ctrl_ofc_cd] --:EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--++ MT Return Loc/Yard Condition +++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("#if (${s_mt_rtn_cd} != '')" ).append("\n"); 
		query.append("      AND MVM.ORG_YD_CD LIKE @[s_mt_rtn_cd]  --:ORG_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--++ Consignee Condition ++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++--" ).append("\n"); 
		query.append("#if (${s_cnee_no} != '')" ).append("\n"); 
		query.append("       AND EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      1" ).append("\n"); 
		query.append("                 FROM BKG_CUSTOMER     CNE" ).append("\n"); 
		query.append("                WHERE CNE.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                  AND CNE.BKG_NO         = MVM.BKG_NO" ).append("\n"); 
		query.append("                  AND CNE.CUST_CNT_CD    = SUBSTR (@[s_cnee_no], 1, 2)                   --:CNEE_CD" ).append("\n"); 
		query.append("                  AND CNE.CUST_SEQ       = TO_NUMBER (NVL (SUBSTR (@[s_cnee_no], 3), 0)) --:CNEE_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--PK CNTR_NO+CNMV_YR+CNMV_ID_NO" ).append("\n"); 
		query.append("--13 BKG_NO+CNTR_NO+CNMV_CYC_NO+MVMT_STS_CD+CNMV_EVNT_DT" ).append("\n"); 
		query.append("--06 MVMT_STS_CD+ORG_YD_CD+CNMV_EVNT_DT" ).append("\n"); 
		query.append("--" ).append("\n"); 

	}
}