/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Release Order E-DO inquery Main
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_pty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_rqst_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_rct_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_bl_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_rqst_dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edo_ack_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoRqstListRSQL").append("\n"); 
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
		query.append("SELECT  RSLT.EDO_RQST_NO      " ).append("\n"); 
		query.append("       ,RSLT.EDO_RQST_NO RQST_NO         " ).append("\n"); 
		query.append("       ,RSLT.EDO_RQST_SEQ_5JN   " ).append("\n"); 
		query.append("       ,RSLT.EDO_RQST_SEQ_5JM   " ).append("\n"); 
		query.append("       ,RSLT.EDO_RQST_SEQ_5JK   " ).append("\n"); 
		query.append("       ,RSLT.BL_NO              " ).append("\n"); 
		query.append("       ,RSLT.PTY_NM      " ).append("\n"); 
		query.append("       ,DECODE(PTY_FLG,'N','N','Y')   AS PTY_FLG" ).append("\n"); 
		query.append("       ,RSLT.POD_CD             " ).append("\n"); 
		query.append("       ,RSLT.DEL_CD" ).append("\n"); 
		query.append("	   ,RSLT.DE_TERM_CD          " ).append("\n"); 
		query.append("       ,DECODE( NVL(WH_CD,'N'),'N','',WH_CD||'('||WH_NM ||')' ) AS WH_NM          " ).append("\n"); 
		query.append("       ,RSLT.EDO_FUNC_CD        " ).append("\n"); 
		query.append("       ,RSLT.DO_EDO_ACK_CD      " ).append("\n"); 
		query.append("       ,RSLT.DO_EDO_RCT_DT  " ).append("\n"); 
		query.append("       ,RSLT.DO_EDO_RCT_LOC_CD  " ).append("\n"); 
		query.append("       ,RSLT.RQST_EDO_ISS_DT " ).append("\n"); 
		query.append("       ,RSLT.HNDL_OFC_CD  " ).append("\n"); 
		query.append("       ,RSLT.SELT_EDO_ACK_CD  " ).append("\n"); 
		query.append("       ,RSLT.SELT_EDO_RCT_DT" ).append("\n"); 
		query.append("	   ,RSLT.SELT_EDO_APR_DT    " ).append("\n"); 
		query.append("	   ,RSLT.SELT_EDO_APR_USR_ID" ).append("\n"); 
		query.append("       ,COM.USR_NM AS SELT_EDO_APR_USR_NM   " ).append("\n"); 
		query.append("       ,RSLT.IBDT_EDO_ACK_CD" ).append("\n"); 
		query.append("       ,RSLT.IBDT_EDO_RCT_DT    " ).append("\n"); 
		query.append("       ,RSLT.VSL_ARR_DT         " ).append("\n"); 
		query.append("       ,RSLT.DELT_USR_ID        " ).append("\n"); 
		query.append("       ,RSLT.EDO_TP_CD          " ).append("\n"); 
		query.append("       ,RSLT.BKG_NO     " ).append("\n"); 
		query.append("       ,NVL(RSLT.EDO_RVW_FLG, 'N')	AS EDO_RVW_FLG" ).append("\n"); 
		query.append("       ,RSLT.EDO_RVW_USR_ID" ).append("\n"); 
		query.append("       ,RSLT.EDO_VSL_NM AS VVD" ).append("\n"); 
		query.append("       ,( SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("           FROM BKG_DO_DTL DTL" ).append("\n"); 
		query.append("          WHERE DTL.RLSE_STS_CD='R'" ).append("\n"); 
		query.append("          AND   DTL.BKG_NO = RSLT.BKG_NO " ).append("\n"); 
		query.append("          AND   ROWNUM =1 ) AS RLSE_FLG " ).append("\n"); 
		query.append("       , DECODE(RSLT.RC_FLG, 'Y','Reefer','N','Other') AS CNTR_TP_CD" ).append("\n"); 
		query.append("       ,RSLT.BL_TP_CD AS BL_TP_CD " ).append("\n"); 
		query.append("      ,(  SELECT  DTL.EVNT_USR_ID" ).append("\n"); 
		query.append("            FROM BKG_DO BDO" ).append("\n"); 
		query.append("               , BKG_DO_DTL DTL" ).append("\n"); 
		query.append("           WHERE BDO.BKG_NO    = RSLT.BL_NO" ).append("\n"); 
		query.append("             AND DTL.BKG_NO    = BDO.BKG_NO    " ).append("\n"); 
		query.append("             AND DTL.RLSE_SEQ  = BDO.RLSE_SEQ" ).append("\n"); 
		query.append("             AND DTL.RLSE_STS_SEQ  = (SELECT MAX(RLSE_STS_SEQ) FROM BKG_DO_DTL SUBDTL WHERE SUBDTL.BKG_NO = DTL.BKG_NO)" ).append("\n"); 
		query.append("             AND DTL.RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("        )DO_RLSE_USR_ID /* 한국 DO는 BL별로 발행 되기 때문에 RLSE_SEQ가 1만 존재하며 최종 상태가 Release인 유저 ID를 조회 한다.*/" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT /*+  USE_NL(IMST M5JN) */ " ).append("\n"); 
		query.append("            IMST.EDO_RQST_NO                           								   	   AS EDO_RQST_NO" ).append("\n"); 
		query.append("          , IMST.EDO_RQST_SEQ_5JN                         								   AS EDO_RQST_SEQ_5JN" ).append("\n"); 
		query.append("          , IMST.EDO_RQST_SEQ_5JM                         								   AS EDO_RQST_SEQ_5JM" ).append("\n"); 
		query.append("          , IMST.EDO_RQST_SEQ_5JK                         								   AS EDO_RQST_SEQ_5JK" ).append("\n"); 
		query.append("          , M5JN.BL_NO                         									           AS BL_NO" ).append("\n"); 
		query.append("          , EPTY.PTY_NM1 || EPTY.PTY_NM2                          						   AS PTY_NM" ).append("\n"); 
		query.append("          , NVL(EPTY.PHN_NO,'N')                   						                   AS PTY_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          , M5JN.POD_CD                         									       AS POD_CD" ).append("\n"); 
		query.append("          , BKGM.DEL_CD                         									       AS DEL_CD" ).append("\n"); 
		query.append("          , BKGM.DE_TERM_CD 															   AS DE_TERM_CD" ).append("\n"); 
		query.append("          ,( SELECT MAX(SEQ.CFM_DT)                                                                                     " ).append("\n"); 
		query.append("             FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ                                                                            " ).append("\n"); 
		query.append("             WHERE SEQ.BKG_NO       = BKGM.BKG_NO                                                                       " ).append("\n"); 
		query.append("             AND   SEQ.MF_CFM_FLG   = @[mf_cfm_flg]                                                                               " ).append("\n"); 
		query.append("             AND   SEQ.MRN_BL_TS_CD = @[mrn_bl_ts_cd]  ) 			    				   AS CFM_DT " ).append("\n"); 
		query.append("          , M5JN.EDO_FUNC_CD                        									   AS EDO_FUNC_CD" ).append("\n"); 
		query.append("          , M5JN.EDO_ACK_CD                    									           AS DO_EDO_ACK_CD" ).append("\n"); 
		query.append("          , DECODE('Y',@[delt_flg],DECODE(M5JN.EDO_TP_CD||M5JN.DELT_FLG,'5JNY',M5JN.EDO_RCT_DT, NULL),M5JN.EDO_RCT_DT)     AS DO_EDO_RCT_DT  ----- DO신청" ).append("\n"); 
		query.append("          , M5JN.EDO_RCT_LOC_CD  				 							   AS DO_EDO_RCT_LOC_CD" ).append("\n"); 
		query.append("          , EDDO.EDO_TRSM_DT      					 						   AS RQST_EDO_ISS_DT  -- DO 발급" ).append("\n"); 
		query.append("          , EDDO.HNDL_OFC_CD	 											   AS HNDL_OFC_CD  -- DO 발급" ).append("\n"); 
		query.append("          , M5JM.EDO_ACK_CD      				 							   AS SELT_EDO_ACK_CD  ----- 자가운송" ).append("\n"); 
		query.append("          , DECODE('Y',@[delt_flg],DECODE(M5JM.EDO_TP_CD||M5JM.DELT_FLG,'5JMY',M5JM.EDO_RCT_DT,NULL),M5JM.EDO_RCT_DT)      AS SELT_EDO_RCT_DT" ).append("\n"); 
		query.append("		  , M5JM.EDO_ACK_DT 													AS SELT_EDO_APR_DT" ).append("\n"); 
		query.append("		  , M5JM.EDO_ACK_USR_ID													AS SELT_EDO_APR_USR_ID" ).append("\n"); 
		query.append("          , M5JK.EDO_ACK_CD       										           AS IBDT_EDO_ACK_CD ----- 보세운송" ).append("\n"); 
		query.append("          , DECODE('Y',@[delt_flg],DECODE(M5JK.EDO_TP_CD||M5JK.DELT_FLG,'5JKY',M5JK.EDO_RCT_DT,NULL),M5JK.EDO_RCT_DT)      AS IBDT_EDO_RCT_DT" ).append("\n"); 
		query.append("          , M5JN.EDO_VSL_NM ||M5JN.EDO_SKD_VOY_NO || M5JN.EDO_SKD_DIR_CD  AS VVD  -- ARRIVAL VESSEL" ).append("\n"); 
		query.append("          , M5JN.VSL_ARR_DT 												   AS VSL_ARR_DT" ).append("\n"); 
		query.append("          , M5JN.DELT_USR_ID  				 							           AS DELT_USR_ID" ).append("\n"); 
		query.append("          , @[edo_tp_cd]           											   AS EDO_TP_CD" ).append("\n"); 
		query.append("          , M5JN.BKG_NO            											   AS BKG_NO" ).append("\n"); 
		query.append("          , M5JN.EDO_RVW_FLG													AS EDO_RVW_FLG" ).append("\n"); 
		query.append("          , M5JN.EDO_RVW_USR_ID													AS EDO_RVW_USR_ID" ).append("\n"); 
		query.append("          , M5JN.EDO_VSL_NM                                                     AS EDO_VSL_NM" ).append("\n"); 
		query.append("          , ( SELECT A.VSL_ENG_NM FROM MDM_VSL_CNTR A WHERE VSL_CD = @[vsl_cd] AND DELT_FLG='N' ) AS MDM_VSL_NM" ).append("\n"); 
		query.append("          , BKGM.RC_FLG" ).append("\n"); 
		query.append("          ,NVL(BKGM.BL_TP_CD,'O') AS BL_TP_CD" ).append("\n"); 
		query.append("       FROM (SELECT /*+ USE_NL(IMST_MAX IMST) */" ).append("\n"); 
		query.append("                    IMST.EDO_RQST_NO" ).append("\n"); 
		query.append("                  , MAX(CASE WHEN IMST.EDO_TP_CD = @[edo_tp_cd] THEN IMST.EDO_RQST_SEQ END) EDO_RQST_SEQ" ).append("\n"); 
		query.append("                  , MAX(CASE WHEN IMST.EDO_TP_CD = '5JN' THEN IMST.EDO_RQST_SEQ END) EDO_RQST_SEQ_5JN" ).append("\n"); 
		query.append("                  , MAX(CASE WHEN IMST.EDO_TP_CD = '5JM' THEN IMST.EDO_RQST_SEQ END) EDO_RQST_SEQ_5JM" ).append("\n"); 
		query.append("                  , MAX(CASE WHEN IMST.EDO_TP_CD = '5JK' THEN IMST.EDO_RQST_SEQ END) EDO_RQST_SEQ_5JK " ).append("\n"); 
		query.append("               FROM BKG_EDO_MST IMST" ).append("\n"); 
		query.append("                  , (SELECT DISTINCT EDO_RQST_NO" ).append("\n"); 
		query.append("                       FROM BKG_EDO_MST" ).append("\n"); 
		query.append("                      WHERE EDO_RCT_DT BETWEEN  TO_DATE(@[edo_rqst_dt_s], 'YYYYMMDD') AND TO_DATE(@[edo_rqst_dt_e], 'YYYYMMDD') + 1 " ).append("\n"); 
		query.append("                    ) IMST_MAX " ).append("\n"); 
		query.append("              WHERE IMST.EDO_RQST_NO  = IMST_MAX.EDO_RQST_NO" ).append("\n"); 
		query.append("                AND IMST.DELT_FLG = @[delt_flg]  " ).append("\n"); 
		query.append("              GROUP BY IMST.EDO_RQST_NO " ).append("\n"); 
		query.append("             )IMST," ).append("\n"); 
		query.append("            BKG_EDO_MST      M5JN,  -- DO 신청" ).append("\n"); 
		query.append("            BKG_EDO_DO       EDDO,  -- DO 발급" ).append("\n"); 
		query.append("            BKG_EDO_MST      M5JM,  -- 자가운송" ).append("\n"); 
		query.append("            BKG_EDO_MST      M5JK,  -- 보세운송" ).append("\n"); 
		query.append("            BKG_EDO_PTY_TRSP EPTY,  -- Consignee " ).append("\n"); 
		query.append("            BKG_BOOKING      BKGM" ).append("\n"); 
		query.append("      WHERE IMST.EDO_RQST_NO      = M5JN.EDO_RQST_NO" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ     = M5JN.EDO_RQST_SEQ" ).append("\n"); 
		query.append("        AND M5JN.EDO_RCT_DT BETWEEN  TO_DATE(@[edo_rqst_dt_s], 'YYYYMMDD') AND TO_DATE(@[edo_rqst_dt_e], 'YYYYMMDD') + 1 " ).append("\n"); 
		query.append("        AND M5JN.BL_NO      = BKGM.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${del_cd} != '')" ).append("\n"); 
		query.append("        AND BKGM.DEL_CD      = @[del_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if(${edo_tp_cd} == '5JN' )" ).append("\n"); 
		query.append("        AND M5JN.EDO_FUNC_CD     <> '1'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_NO      = EDDO.EDO_RQST_NO  (+)" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ_5JN = EDDO.EDO_RQST_SEQ (+)" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_NO      = M5JM.EDO_RQST_NO  (+)" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ_5JM = M5JM.EDO_RQST_SEQ (+)" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_NO      = M5JK.EDO_RQST_NO  (+)" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ_5JK = M5JK.EDO_RQST_SEQ (+) " ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_NO      = EPTY.EDO_RQST_NO  (+)" ).append("\n"); 
		query.append("        AND EPTY.EDO_PTY_CD       = @[edo_pty_cd]" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ     = EPTY.EDO_RQST_SEQ(+)" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if(${edo_tp_cd} == '5JM' )" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ_5JM IS NOT NULL" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if(${edo_tp_cd} == '5JK' )" ).append("\n"); 
		query.append("        AND IMST.EDO_RQST_SEQ_5JK IS NOT NULL" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${hndl_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND EDDO.HNDL_OFC_CD    = @[hndl_ofc_cd]  ---  2.HANDLING OFFICE CODE" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${edo_rct_loc_cd} != '')" ).append("\n"); 
		query.append("        AND M5JN.EDO_RCT_LOC_CD = @[edo_rct_loc_cd]  -- 3. 접수지" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("          AND M5JN.POD_CD     = @[pod_cd]  -- 4. POD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND M5JN.BL_NO      = @[bl_no] -- 6. BL_NO" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${vsl_nm} != '')" ).append("\n"); 
		query.append("        AND M5JN.EDO_VSL_NM LIKE '%' || UPPER( @[vsl_nm] ) || '%' -- 7. VESSEL" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${edo_ack_cd}!= '' && ${edo_ack_cd}!= 'Z')" ).append("\n"); 
		query.append("        AND NVL(M5JN.EDO_ACK_CD,'Q') = @[edo_ack_cd] -- 9.HANDLING STATUS CODE" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${cn_nm} != '')" ).append("\n"); 
		query.append("        AND EPTY.PTY_NM1 || EPTY.PTY_NM2  LIKE '%' || UPPER( @[cn_nm]) || '%'  -- 10. CONSIGNEE NAME" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${do_no} != '')" ).append("\n"); 
		query.append("        AND M5JN.BKG_NO = ( SELECT BKG_NO" ).append("\n"); 
		query.append("                              FROM BKG_DO" ).append("\n"); 
		query.append("                             WHERE DO_NO       =  @[do_no]" ).append("\n"); 
		query.append("                               AND DO_NO_SPLIT =  @[do_no_split]" ).append("\n"); 
		query.append("                               AND ROWNUM = 1 )  -- 11.DO NO" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${cntr_tp_cd} == 'R') " ).append("\n"); 
		query.append("        AND RC_FLG ='Y'" ).append("\n"); 
		query.append("     #elseif (${cntr_tp_cd} == 'O') " ).append("\n"); 
		query.append("        AND RC_FLG ='N'" ).append("\n"); 
		query.append("     #else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(")  RSLT" ).append("\n"); 
		query.append("  ,BKG_CSTMS_KR_MF_SEQ_NO  MSN" ).append("\n"); 
		query.append("  ,BKG_WAREHOUSE           WH" ).append("\n"); 
		query.append("  ,COM_USER				   COM" ).append("\n"); 
		query.append("WHERE  MSN.BKG_NO(+)       =  RSLT.BKG_NO" ).append("\n"); 
		query.append("AND    MSN.MF_CFM_FLG(+)   = @[mf_cfm_flg]" ).append("\n"); 
		query.append("AND    MSN.MRN_BL_TS_CD(+) = @[mrn_bl_ts_cd]" ).append("\n"); 
		query.append("AND    MSN.CFM_DT(+)       = RSLT.CFM_DT " ).append("\n"); 
		query.append("AND    WH.CSTMS_CD(+)      = MSN.CSTMS_CLR_WH_CD  " ).append("\n"); 
		query.append("AND    WH.CNT_CD(+)        = @[cnt_cd]" ).append("\n"); 
		query.append("AND    COM.USR_ID(+)	   = RSLT.SELT_EDO_APR_USR_ID" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    RSLT.MDM_VSL_NM     = RSLT.EDO_VSL_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY DO_EDO_RCT_DT" ).append("\n"); 

	}
}