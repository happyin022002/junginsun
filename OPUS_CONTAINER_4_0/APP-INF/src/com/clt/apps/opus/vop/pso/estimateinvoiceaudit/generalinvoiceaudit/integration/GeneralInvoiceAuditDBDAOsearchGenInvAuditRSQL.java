/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchGenInvAudit
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("     , NVL(A.TMP_CLPT_IND_SEQS, A.CLPT_IND_SEQ) AS CLPT_IND_SEQS" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , (SELECT LISTAGG(VP.CLPT_IND_SEQ,'|') WITHIN GROUP (ORDER BY ROWNUM) " ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VP.VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("                   AND VP.SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VP.SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VP.YD_CD         = A.YD_CD" ).append("\n"); 
		query.append("                   AND 'S'              <> NVL(VP.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                   AND 'N'              = NVL(VP.VT_ADD_CALL_FLG, 'N')" ).append("\n"); 
		query.append("                   AND VP.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                ) TMP_CLPT_IND_SEQS /* 2016.04.26 Double Calling Add*/" ).append("\n"); 
		query.append("              , TO_CHAR(A.TMP_CLPT_IND_SEQ) AS CLPT_IND_SEQ /* 2016.06.28 VVD는 버츄얼일때  실제 사용되는 VVD로 변환된 데이타 , 저장된  CLPT_IND_SEQ는 실제 사용되는 VVD의 CLPTIND_SEQ이므로 DB 데이타를 그대로 넘긴다. */" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.ISS_CTY_CD" ).append("\n"); 
		query.append("                     , A.SO_SEQ" ).append("\n"); 
		query.append("                     , A.COST_OFC_CD" ).append("\n"); 
		query.append("                     , A.SO_DTL_SEQ" ).append("\n"); 
		query.append("                     , A.PSO_CHG_STS_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS CHK_VVD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     /*Old Data 처리 : Outbound Port VVD [IN] 데이타일때 입력된 데이타 그대로 나오게 처리. Inbound Port VVD [IN] 일때는 Turn_skd_voy_no 처리.*/" ).append("\n"); 
		query.append("                     , DECODE(A.VT_VVD_FLG,'Y',SUBSTR(A.TURN_VVD_CD,5,4), A.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     /*Old Data 처리 : Outbound Port VVD [IN] 데이타일때 입력된 데이타 그대로 나오게 처리. Inbound Port VVD [IN] 일때는 TURN_SKD_DIR_CD 처리.*/" ).append("\n"); 
		query.append("                     , DECODE(A.VT_VVD_FLG,'Y',SUBSTR(A.TURN_VVD_CD,9,1), A.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.COST_CD" ).append("\n"); 
		query.append("                     , A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.IO" ).append("\n"); 
		query.append("                     , A.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                     , A.TARIFF_COST" ).append("\n"); 
		query.append("                     , A.ADJCOST" ).append("\n"); 
		query.append("                     , A.AMOUNT" ).append("\n"); 
		query.append("                     , A.FOML1" ).append("\n"); 
		query.append("                     , A.FOML2" ).append("\n"); 
		query.append("                     , A.COND1" ).append("\n"); 
		query.append("                     , A.COND2" ).append("\n"); 
		query.append("                     , A.REMARK" ).append("\n"); 
		query.append("                     , A.VNDR_SEQ" ).append("\n"); 
		query.append("                     , A.YD_CD" ).append("\n"); 
		query.append("                     , A.YD_CHG_NO" ).append("\n"); 
		query.append("                     , A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     , A.ATD" ).append("\n"); 
		query.append("                     , A.DFT_IO_DATA" ).append("\n"); 
		query.append("                     , A.TTL_LOCL_AMT" ).append("\n"); 
		query.append("                     , A.INV_LOCL_AMT" ).append("\n"); 
		query.append("                     , A.LOCL_TAX_AMT" ).append("\n"); 
		query.append("                     , A.LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("                     , A.CURR_CD" ).append("\n"); 
		query.append("                     , A.EFF_DT" ).append("\n"); 
		query.append("                     , A.NIGHT" ).append("\n"); 
		query.append("                     , A.HOLIDAY" ).append("\n"); 
		query.append("                     , A.BOAT" ).append("\n"); 
		query.append("                     , A.TUGROPE" ).append("\n"); 
		query.append("                     , A.BUOY" ).append("\n"); 
		query.append("                     , A.SANITATION" ).append("\n"); 
		query.append("                     , A.BARGE" ).append("\n"); 
		query.append("                     , A.INSPECTION" ).append("\n"); 
		query.append("                     , A.ARRTP" ).append("\n"); 
		query.append("                     , A.DEPTP" ).append("\n"); 
		query.append("                     , A.ARRNT" ).append("\n"); 
		query.append("                     , A.DEPNT" ).append("\n"); 
		query.append("                     , A.ARRTUH" ).append("\n"); 
		query.append("                     , A.DEPTUH" ).append("\n"); 
		query.append("                     , A.ARRLH" ).append("\n"); 
		query.append("                     , A.DEPLH" ).append("\n"); 
		query.append("                     , A.USDHRS" ).append("\n"); 
		query.append("                     , A.NEWSERVICE" ).append("\n"); 
		query.append("                     , A.COPILOT" ).append("\n"); 
		query.append("                     , A.SDR" ).append("\n"); 
		query.append("                     , A.TIER" ).append("\n"); 
		query.append("                     , A.LIMIT_TIME" ).append("\n"); 
		query.append("                     , A.OTHERS" ).append("\n"); 
		query.append("                     , A.OTHER_VALUE" ).append("\n"); 
		query.append("                     , A.PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("                     , A.ISS_DT" ).append("\n"); 
		query.append("                     , A.ACPT_DT" ).append("\n"); 
		query.append("                     , A.VT_VVD_FLG" ).append("\n"); 
		query.append("                     , A.CLPT_IND_SEQ AS TMP_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT T1.ISS_CTY_CD" ).append("\n"); 
		query.append("                             , T1.SO_SEQ" ).append("\n"); 
		query.append("                             , MAX(T1.COST_OFC_CD) COST_OFC_CD" ).append("\n"); 
		query.append("                             , MIN(T2.SO_DTL_SEQ) SO_DTL_SEQ" ).append("\n"); 
		query.append("                             , MAX(T1.PSO_CHG_STS_CD) PSO_CHG_STS_CD" ).append("\n"); 
		query.append("                             , MAX(T2.VSL_CD) VSL_CD" ).append("\n"); 
		query.append("                             , MAX(DECODE(SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_VOY_NO,'')) SKD_VOY_NO" ).append("\n"); 
		query.append("                             , MAX(DECODE(SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_DIR_CD,'')) SKD_DIR_CD" ).append("\n"); 
		query.append("                             , MAX(T2.VT_VVD_FLG) VT_VVD_FLG" ).append("\n"); 
		query.append("                             , MAX(T2.TURN_VVD_CD) TURN_VVD_CD" ).append("\n"); 
		query.append("                             , MAX(T2.LGS_COST_CD) COST_CD" ).append("\n"); 
		query.append("                             , MAX( (SELECT MAX(X.ACCT_CD)" ).append("\n"); 
		query.append("                                       FROM TES_LGS_COST X" ).append("\n"); 
		query.append("                                      WHERE X.LGS_COST_CD = T2.LGS_COST_CD )) ACCT_CD" ).append("\n"); 
		query.append("                             , MAX(DECODE(DP_IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'INOUT')) IO" ).append("\n"); 
		query.append("                             , MAX( (SELECT MAX(X.LGS_COST_FULL_NM)" ).append("\n"); 
		query.append("                                       FROM TES_LGS_COST X" ).append("\n"); 
		query.append("                                      WHERE X.LGS_COST_CD = T2.LGS_COST_CD )) LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                             , SUM(T2.CALC_AMT) TARIFF_COST" ).append("\n"); 
		query.append("                             , SUM(DECODE(T2.CALC_AMT ,NULL,DECODE(T2.ADJ_AMT,NULL,T2.LOCL_AMT,T2.ADJ_AMT), T2.ADJ_AMT) ) ADJCOST" ).append("\n"); 
		query.append("                             , SUM(T2.LOCL_AMT) AMOUNT" ).append("\n"); 
		query.append("                             , MAX(T2.FOML_DESC) FOML1" ).append("\n"); 
		query.append("                             , MAX(T2.XPR_DESC) FOML2" ).append("\n"); 
		query.append("                             , MAX(T2.XPR_DESC) COND1" ).append("\n"); 
		query.append("                             , MAX(T2.FOML_DESC) COND2" ).append("\n"); 
		query.append("                             , MAX(T2.DIFF_RMK) REMARK" ).append("\n"); 
		query.append("                             , MAX(T1.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("                             , MAX(T1.YD_CD) YD_CD" ).append("\n"); 
		query.append("                             , MAX(T2.YD_CHG_NO) YD_CHG_NO" ).append("\n"); 
		query.append("                             , MAX(T2.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                             , MAX( (SELECT TO_CHAR(MIN(X.VPS_ETD_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("                                      WHERE X.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("                                        AND X.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND X.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND X.YD_CD         = T1.YD_CD" ).append("\n"); 
		query.append("                                        AND X.CLPT_IND_SEQ  = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        AND NVL(X.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                                        AND NVL(X.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ )) ATD" ).append("\n"); 
		query.append("                             , '' AS DFT_IO_DATA" ).append("\n"); 
		query.append("                             , MAX(T1.TTL_LOCL_AMT) TTL_LOCL_AMT" ).append("\n"); 
		query.append("                             , MAX(T1.INV_LOCL_AMT) INV_LOCL_AMT" ).append("\n"); 
		query.append("                             , --INVOICE LOCAL AMOUNT" ).append("\n"); 
		query.append("                               MAX(T1.LOCL_TAX_AMT) LOCL_TAX_AMT" ).append("\n"); 
		query.append("                             , MAX(T1.LOCL_WHLD_TAX_AMT) LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("                             , MAX(T1.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("                             , MAX(TO_CHAR(T1.EFF_DT, 'YYYY-MM-DD')) EFF_DT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o86') NIGHT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o75') HOLIDAY" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o17') BOAT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o110') TUGROPE" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o57') BUOY" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o97') SANITATION" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o52') BARGE" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o78') INSPECTION" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o8') ARRTP" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o9') DEPTP" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o6') ARRNT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o7') DEPNT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o10') ARRTUH" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o11') DEPTUH" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o50') ARRLH" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o60') DEPLH" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o111') USDHRS" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o119') NEWSERVICE" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o125') COPILOT" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o114') SDR" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o115') TIER" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o116') LIMIT_TIME" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o170') OTHERS" ).append("\n"); 
		query.append("                             , EXTRACTVALUE(XMLTYPE(NVL(MAX(T2.INV_COND_DESC),'<o></o>')), '//o171') OTHER_VALUE" ).append("\n"); 
		query.append("                             , MAX(T1.PSO_TRNS_SLP_CTNT) PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(T1.ISS_DT), 'YYYYMMDD') ISS_DT" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(T1.ACPT_DT), 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("                             , MAX(T2.VSL_CD) || MAX(DECODE(SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_VOY_NO,'')) || MAX(DECODE(SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.SKD_DIR_CD,'')) VVD" ).append("\n"); 
		query.append("                             --, MAX(T2.CLPT_IND_SEQ) AS CLPT_IND_SEQ /* 2016.04.26 Double Calling Add*/" ).append("\n"); 
		query.append("                             , MIN(DECODE(SO_DTL_SEQ, ORG_SO_DTL_SEQ, T2.CLPT_IND_SEQ, NULL)) AS CLPT_IND_SEQ /*  2016.11.30 MAX to MIN Modify Double Calling Add*/" ).append("\n"); 
		query.append("                          FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("                             , PSO_CHG_DTL T2" ).append("\n"); 
		query.append("                         WHERE T1.ISS_CTY_CD    = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                           AND T1.SO_SEQ        = T2.SO_SEQ" ).append("\n"); 
		query.append("                           AND T1.VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("                           AND T1.INV_NO        = @[inv_no]" ).append("\n"); 
		query.append("                         GROUP BY T1.ISS_CTY_CD, T1.SO_SEQ, T2.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 

	}
}