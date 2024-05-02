/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcSendListByConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
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

public class HoldNoticeDBDAOsearchHldNtcSendListByConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관 EDI정보에서 Hold에 대한 Clear(Confirm) Event가 발생한 대상 정보를 조화한다.( 미주지역만 해당) (ConfirmHldNtcSendListVO 생성)
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcSendListByConfirmRSQL(){
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
		params.put("dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dt_s",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcSendListByConfirmRSQL").append("\n"); 
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
		query.append("-- ConfirmHldNtcSendListVO" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO              " ).append("\n"); 
		query.append("      ,SUBQ.NTC_SEQ             " ).append("\n"); 
		query.append("      ,SUBQ.HLD_NTC_TP_CD       " ).append("\n"); 
		query.append("      ,SUBQ.CSTMS_HLD_NTC_FOM_CD" ).append("\n"); 
		query.append("      ,SUBQ.CSTMS_HLD_LOC_CD    " ).append("\n"); 
		query.append("      ,SUBQ.CUST_CNT_CD         " ).append("\n"); 
		query.append("      ,SUBQ.CUST_SEQ            " ).append("\n"); 
		query.append("      ,SUBQ.CUST_CD             " ).append("\n"); 
		query.append("      ,SUBQ.CUST_NM             " ).append("\n"); 
		query.append("      ,SUBQ.CSTMS_PRE_HLD_CD    " ).append("\n"); 
		query.append("      ,SUBQ.PRE_HLD_DT     " ).append("\n"); 
		query.append("      ,SUBQ.CSTMS_CFM_HLD_CD" ).append("\n"); 
		query.append("      ,SUBQ.CFM_HLD_DT" ).append("\n"); 
		query.append("      ,SUBQ.N3PTY_BIL_NO_YN     " ).append("\n"); 
		query.append("      ,SUBQ.HLD_ECLZ_OBL_FLG    " ).append("\n"); 
		query.append("      ,SUBQ.HLD_DIFF_RMK        " ).append("\n"); 
		query.append("      ,SUBQ.BL_NO               " ).append("\n"); 
		query.append("      ,SUBQ.VVD                 " ).append("\n"); 
		query.append("      ,SUBQ.POD_CD              " ).append("\n"); 
		query.append("      ,SUBQ.DEL_CD              " ).append("\n"); 
		query.append("      ,SUBQ.OFC_CD              " ).append("\n"); 
		query.append("      ,SUBQ.CUST_CNTC_TP_CD     " ).append("\n"); 
		query.append("      ,SUBQ.FAX_NO              " ).append("\n"); 
		query.append("      ,SUBQ.NTC_EML             " ).append("\n"); 
		query.append("      ,SUBQ.NTC_WD_YN" ).append("\n"); 
		query.append("      ,SUBQ.HLD_FAX_SND_DT      " ).append("\n"); 
		query.append("      ,SUBQ.HLD_EML_SND_DT      " ).append("\n"); 
		query.append("      ,(CASE WHEN NVL(SUBQ.HLD_FAX_SND_DT,SUBQ.HLD_EML_SND_DT) >= NVL(SUBQ.HLD_EML_SND_DT,SUBQ.HLD_FAX_SND_DT) THEN NVL(SUBQ.HLD_FAX_SND_DT,SUBQ.HLD_EML_SND_DT)" ).append("\n"); 
		query.append("             ELSE SUBQ.HLD_EML_SND_DT END) AS HLD_SND_DT" ).append("\n"); 
		query.append("      ,BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.HLD_FAX_SND_RSLT_CD ) AS HLD_FAX_SND_RSLT_NM -- RD FAX 전송 상태" ).append("\n"); 
		query.append("      ,BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_NTC_SND_RSLT_CD ) AS HLD_EML_SND_RSLT_NM -- RD E-MAIL 전송 상태" ).append("\n"); 
		query.append("      ,DECODE(SUBQ.HLD_FAX_SND_RSLT_CD,'5','S','6','F','9','N','P') AS HLD_FAX_SND_RSLT -- 5:Blue(Success), 6:Red(Fail), 9:Black(Not Send), P:진행중 " ).append("\n"); 
		query.append("      ,DECODE(SUBQ.EML_NTC_SND_RSLT_CD,'3','S','4','F','9','N','P') AS HLD_EML_SND_RSLT -- 3:Blue(Success), 4:Red(Fail), 9:Black(Not Send), P:진행중" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT SUBM.BKG_NO                        	                 AS BKG_NO               " ).append("\n"); 
		query.append("               ,SUBM.NTC_SEQ                       	                 AS NTC_SEQ             " ).append("\n"); 
		query.append("               ,SUBM.HLD_NTC_TP_CD                  	             AS HLD_NTC_TP_CD       " ).append("\n"); 
		query.append("               ,SUBM.CSTMS_HLD_NTC_FOM_CD           	             AS CSTMS_HLD_NTC_FOM_CD" ).append("\n"); 
		query.append("               ,SUBM.CSTMS_HLD_LOC_CD               	             AS CSTMS_HLD_LOC_CD    " ).append("\n"); 
		query.append("               ,SUBM.CUST_CNT_CD                    	             AS CUST_CNT_CD         " ).append("\n"); 
		query.append("               ,SUBM.CUST_SEQ                       	             AS CUST_SEQ            " ).append("\n"); 
		query.append("               ,SUBM.CUST_CD                        	             AS CUST_CD             " ).append("\n"); 
		query.append("               ,SUBM.CUST_NM                        	             AS CUST_NM             " ).append("\n"); 
		query.append("               ,SUBM.CSTMS_PRE_HLD_CD               	             AS CSTMS_PRE_HLD_CD    " ).append("\n"); 
		query.append("               ,SUBM.PRE_HLD_DT                      	             AS PRE_HLD_DT          " ).append("\n"); 
		query.append("               ,SUBM.CSTMS_CFM_HLD_CD" ).append("\n"); 
		query.append("               ,SUBM.CFM_HLD_DT" ).append("\n"); 
		query.append("               ,SUBM.N3PTY_BIL_NO_YN" ).append("\n"); 
		query.append("               ,SUBM.HLD_ECLZ_OBL_FLG               	             AS HLD_ECLZ_OBL_FLG    " ).append("\n"); 
		query.append("               ,SUBM.HLD_DIFF_RMK           	                     AS HLD_DIFF_RMK" ).append("\n"); 
		query.append("               ,SUBM.BL_NO 				                             AS BL_NO " ).append("\n"); 
		query.append("               ,SUBM.VVD               			                     AS VVD  " ).append("\n"); 
		query.append("               ,SUBM.POD_CD              		                     AS POD_CD  " ).append("\n"); 
		query.append("               ,SUBM.DEL_CD              		                     AS DEL_CD  " ).append("\n"); 
		query.append("               ,@[usr_ofc_cd]                                        AS OFC_CD" ).append("\n"); 
		query.append("               ,HNDTL.CUST_CNTC_TP_CD                                AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("               ,HNDTL.FAX_NO              		                     AS FAX_NO  " ).append("\n"); 
		query.append("               ,HNDTL.NTC_EML              		                     AS NTC_EML  " ).append("\n"); 
		query.append("               ,NVL(HNDTL.HLD_FAX_SND_DT, FXSD.FAX_SND_LOCL_DT)      AS HLD_FAX_SND_DT " ).append("\n"); 
		query.append("               ,NVL(HNDTL.HLD_EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,EMSD.EML_DT,LOC.LOC_CD )) AS HLD_EML_SND_DT" ).append("\n"); 
		query.append("               ,NVL(HNDTL.HLD_FAX_SND_RSLT_CD, NVL(FXSD.FAX_PROC_STS_CD,'9'))                           AS HLD_FAX_SND_RSLT_CD  -- 9 : 보낸 결과 없음" ).append("\n"); 
		query.append("               ,NVL(HNDTL.HLD_EML_SND_RSLT_CD, NVL(EMSD.EML_PROC_STS_CD,'9'))                           AS EML_NTC_SND_RSLT_CD  -- 9 : 보낸 결과 없음" ).append("\n"); 
		query.append("               ,CASE WHEN  NVL(TO_CHAR( NVL(HNDTL.HLD_FAX_SND_DT,FXSD.FAX_SND_LOCL_DT), 'YYYYMMDDHH24MISS'),'00000000000000')" ).append("\n"); 
		query.append("                           > NVL(TO_CHAR( NVL(HNDTL.HLD_EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,EMSD.EML_DT,LOC.LOC_CD )), 'YYYYMMDDHH24MISS'),'00000000000000')                                                                                                            " ).append("\n"); 
		query.append("                        THEN DECODE(NVL(HNDTL.HLD_FAX_SND_RSLT_CD, NVL(FXSD.FAX_PROC_STS_CD,'9') ),'5','S','6','F','9','N','W' )" ).append("\n"); 
		query.append("                     WHEN  NVL(TO_CHAR( NVL(HNDTL.HLD_FAX_SND_DT,FXSD.FAX_SND_LOCL_DT), 'YYYYMMDDHH24MISS'),'00000000000000')" ).append("\n"); 
		query.append("                           < NVL(TO_CHAR( NVL(HNDTL.HLD_EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,EMSD.EML_DT,LOC.LOC_CD )), 'YYYYMMDDHH24MISS'),'00000000000000')                                                                                                            " ).append("\n"); 
		query.append("                        THEN DECODE(NVL(HNDTL.HLD_EML_SND_RSLT_CD, NVL(EMSD.EML_PROC_STS_CD,'9') ),'3','S','4','F','9','N','W' )" ).append("\n"); 
		query.append("                     ELSE    'N'" ).append("\n"); 
		query.append("                END                                                  AS SND_RSLT_CD   " ).append("\n"); 
		query.append("               ,NVL((SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("                     FROM   BKG_HLD_WD WD " ).append("\n"); 
		query.append("                     WHERE  WD.HLD_NTC_TP_CD = 'CF' " ).append("\n"); 
		query.append("                     AND    WD.OFC_CD        = @[usr_ofc_cd]" ).append("\n"); 
		query.append("                     AND    WD.POD_CD        IN ('*',SUBM.POD_CD)" ).append("\n"); 
		query.append("                     AND    ROWNUM = 1),'N') AS NTC_WD_YN" ).append("\n"); 
		query.append("        FROM  (" ).append("\n"); 
		query.append("               SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("                     ,HNTC.NTC_SEQ" ).append("\n"); 
		query.append("                     ,HNTC.HLD_NTC_TP_CD" ).append("\n"); 
		query.append("                     ,HNTC.CSTMS_HLD_NTC_FOM_CD" ).append("\n"); 
		query.append("                     ,HNTC.CSTMS_HLD_LOC_CD" ).append("\n"); 
		query.append("                     ,HNTC.CUST_CNT_CD" ).append("\n"); 
		query.append("                     ,HNTC.CUST_SEQ" ).append("\n"); 
		query.append("                     ,HNTC.CUST_CNT_CD||DECODE(HNTC.CUST_CNT_CD,'','',LPAD(HNTC.CUST_SEQ,6,'0')) AS CUST_CD" ).append("\n"); 
		query.append("                     ,HNTC.CUST_NM" ).append("\n"); 
		query.append("                     ,HNTC.CSTMS_PRE_HLD_CD" ).append("\n"); 
		query.append("                     ,HNTC.PRE_HLD_DT" ).append("\n"); 
		query.append("                     ,HNTC.CSTMS_CFM_HLD_CD" ).append("\n"); 
		query.append("                     ,HNTC.CFM_HLD_DT" ).append("\n"); 
		query.append("                     ,(SELECT DECODE(MAX(N3PTY_BIL_NO),NULL,'N','Y') " ).append("\n"); 
		query.append("                       FROM   BKG_HLD_N3RD_PTY_BIL_CNTR T " ).append("\n"); 
		query.append("                       WHERE  T.BKG_NO = HNTC.BKG_NO AND T.NTC_SEQ = HNTC.NTC_SEQ) AS N3PTY_BIL_NO_YN" ).append("\n"); 
		query.append("                     ,HNTC.HLD_ECLZ_OBL_FLG" ).append("\n"); 
		query.append("                     ,HNTC.HLD_DIFF_RMK" ).append("\n"); 
		query.append("                     ,BKGM.BL_NO" ).append("\n"); 
		query.append("                     ,VSKD.VSL_CD || VSKD.SKD_VOY_NO || VSKD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                     ,BKGM.POD_CD" ).append("\n"); 
		query.append("                     ,BKGM.DEL_CD" ).append("\n"); 
		query.append("               FROM  VSK_VSL_PORT_SKD   VSKD" ).append("\n"); 
		query.append("                    ,BKG_VVD            BVVD" ).append("\n"); 
		query.append("                    ,BKG_BOOKING        BKGM" ).append("\n"); 
		query.append("                    ,BKG_HLD_NTC        HNTC" ).append("\n"); 
		query.append("               WHERE  1 = 1 " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("#if (${sch_tp_cd} == 'VVD')" ).append("\n"); 
		query.append("                     AND VSKD.VSL_CD     = SUBSTR(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                     AND VSKD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                     AND VSKD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("#elseif (${sch_tp_cd} == 'ETA')" ).append("\n"); 
		query.append("                     AND VSKD.VPS_ETA_DT >= TO_DATE(@[dt_s], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                     AND VSKD.VPS_ETA_DT <  TO_DATE(@[dt_e], 'YYYY-MM-DD') +0.99999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("#elseif (${sch_tp_cd} == 'BL')" ).append("\n"); 
		query.append("                     AND BKGM.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                     AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                     AND BKGM.DEL_CD   = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("                    AND     BKGM.BKG_NO IN (SELECT T.BKG_NO" ).append("\n"); 
		query.append("                                            FROM   BKG_CONTAINER T " ).append("\n"); 
		query.append("                                            WHERE  T.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND BVVD.VSL_PRE_PST_CD    IN ('T', 'U')" ).append("\n"); 
		query.append("                     AND BVVD.VSL_CD            = VSKD.VSL_CD " ).append("\n"); 
		query.append("                     AND BVVD.SKD_VOY_NO        = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND BVVD.SKD_DIR_CD        = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND BVVD.POD_CD            = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                     AND BVVD.POD_CLPT_IND_SEQ  = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     AND BKGM.BKG_NO            = BVVD.BKG_NO" ).append("\n"); 
		query.append("                     AND BKGM.POD_CD            = BVVD.POD_CD  " ).append("\n"); 
		query.append("                     AND BKGM.BKG_NO            = HNTC.BKG_NO  " ).append("\n"); 
		query.append("                     AND HNTC.HLD_NTC_TP_CD     = 'CF'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("              ) SUBM" ).append("\n"); 
		query.append("             ,BKG_HLD_NTC_DTL HNDTL" ).append("\n"); 
		query.append("             ,COM_FAX_SND_INFO FXSD" ).append("\n"); 
		query.append("             ,COM_EML_SND_INFO EMSD" ).append("\n"); 
		query.append("             ,COM_USER         USR" ).append("\n"); 
		query.append("             ,MDM_ORGANIZATION LOC" ).append("\n"); 
		query.append("        WHERE HNDTL.BKG_NO(+)    = SUBM.BKG_NO" ).append("\n"); 
		query.append("          AND HNDTL.NTC_SEQ(+)   = SUBM.NTC_SEQ" ).append("\n"); 
		query.append("          AND FXSD.FAX_SND_NO(+) = HNDTL.HLD_FAX_SND_ID " ).append("\n"); 
		query.append("          AND EMSD.EML_SND_NO(+) = HNDTL.HLD_EML_SND_ID " ).append("\n"); 
		query.append("          AND USR.USR_ID(+)      = @[usr_id]" ).append("\n"); 
		query.append("          AND LOC.OFC_CD(+)      = @[usr_ofc_cd]" ).append("\n"); 
		query.append("          AND LOC.DELT_FLG(+)    = 'N'       " ).append("\n"); 
		query.append("     ) SUBQ" ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("#if (${snd_rslt_cd} == '')" ).append("\n"); 
		query.append("  AND SND_RSLT_CD = 'N' -- Not Send" ).append("\n"); 
		query.append("#elseif (${snd_rslt_cd} == 'S')" ).append("\n"); 
		query.append("  AND SND_RSLT_CD = 'S' -- Success" ).append("\n"); 
		query.append("#elseif (${snd_rslt_cd} == 'F')" ).append("\n"); 
		query.append("  AND SND_RSLT_CD = 'F' -- Fail" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}