/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLimitTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
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

public class GeneralInvoiceAuditDBDAOgetLimitTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD의 해당 YARD의 SURCHARGE 계산을 위한 LIMIT TIME 을 조회
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLimitTimeRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLimitTimeRSQL").append("\n"); 
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
		query.append("SELECT	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("FROM	VSK_PORT_CNL_PASS_COND S, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                DECODE(T3.SVC_SCP_BND_CD, 'N', 'North Bound', 'S', 'South Bound') BOUND" ).append("\n"); 
		query.append("                , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                , T2.VSL_CD" ).append("\n"); 
		query.append("                , T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , T2.CLPT_SEQ" ).append("\n"); 
		query.append("                , T2.YD_CD" ).append("\n"); 
		query.append("                , T2.VPS_ETA_DT" ).append("\n"); 
		query.append("                , T2.VPS_ETB_DT " ).append("\n"); 
		query.append("                , T2.VPS_ETD_DT" ).append("\n"); 
		query.append("                , T2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                , DECODE(T3.SVC_SCP_BND_CD, 'W', 'N', 'E', 'S') AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("                , LAG(T2.VPS_PORT_CD) OVER (PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY T2.CLPT_SEQ) AS PRE_PORT" ).append("\n"); 
		query.append("                , LAG(T2.VPS_ETD_DT ) OVER (PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY T2.CLPT_SEQ) AS PRE_PORT_ETD_DT" ).append("\n"); 
		query.append("            FROM	(	SELECT	T2.*" ).append("\n"); 
		query.append("						FROM 	VSK_VSL_SKD			T1" ).append("\n"); 
		query.append("								, VSK_VSL_PORT_SKD	T2" ).append("\n"); 
		query.append("								, MDM_VSL_CNTR		T3" ).append("\n"); 
		query.append("								, MDM_VSL_SVC_LANE	T4" ).append("\n"); 
		query.append("								, MDM_VENDOR		T5" ).append("\n"); 
		query.append("						WHERE	1=1" ).append("\n"); 
		query.append("						AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("						AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND     T1.VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("						AND     T1.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("						AND     T1.SKD_DIR_CD   = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("						AND		T2.VPS_PORT_CD  = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                        AND     NVL(T2.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("						AND		T2.VSL_CD		= T3.VSL_CD" ).append("\n"); 
		query.append("						AND		T3.CRR_CD		= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("						AND		T1.VSL_SLAN_CD	= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("						AND		T5.CNL_AGN_FLG	= 'Y'" ).append("\n"); 
		query.append("                        AND     T4.VSL_TP_CD    = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("						AND		T4.CNL_AGN_VNDR_SEQ = T5.VNDR_SEQ" ).append("\n"); 
		query.append("						) T0" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("		            , VSK_VSL_SKD		T1" ).append("\n"); 
		query.append("		            , VSK_VSL_PORT_SKD	T2" ).append("\n"); 
		query.append("		            , MDM_VSL_SVC_LANE_DIR T3" ).append("\n"); 
		query.append("            WHERE	1=1" ).append("\n"); 
		query.append("            AND		T0.VSL_CD		= T1.VSL_CD" ).append("\n"); 
		query.append("            AND		T0.SKD_VOY_NO	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND		T0.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("            AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND		T1.VSL_SLAN_CD	= T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND		T1.SKD_DIR_CD	= T3.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            AND		T3.SVC_SCP_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND		NVL(T2.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("            AND     NVL(T2.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("        ) T2" ).append("\n"); 
		query.append("WHERE	S.SVC_SCP_BND_CD	= T2.SVC_SCP_BND_CD" ).append("\n"); 
		query.append("AND		S.LOC_CD			= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND		S.CNL_TZ_SEQ_CD	=" ).append("\n"); 
		query.append("( /* 해당 선박으로 INVOICE가 청구된 EGSCA CANAL NET TON를 조회한다. */" ).append("\n"); 
		query.append("    SELECT CASE WHEN TO_NUMBER(NVL(SUBSTR(MAX(TO_CHAR(S1.RQST_DT, 'YYYYMMDDHH24MI') || S1.SUZ_NET_TONG_WGT ), 13), '0')) >= 70000 THEN" ).append("\n"); 
		query.append("        '1'  /* EGSCA CANAL NET TON 이 70000  보다 클 경우 : FIRST COMBO를 이용함 */" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        '2' /* EGSCA CANAL NET TON 이 70000  보다 작을 경우 : SECOND COMBO를 이용함 */" ).append("\n"); 
		query.append("    END IF" ).append("\n"); 
		query.append("    FROM	PSO_CNL_TZ_FEE S1" ).append("\n"); 
		query.append("    WHERE	S1.PSO_BZTP_CD		= '5' /* Canal Transit Business    */" ).append("\n"); 
		query.append("    AND		S1.CNL_TZ_BZTP_CD	= 'I' /* Inputted invoice at Canal Agency */" ).append("\n"); 
		query.append("    AND		S1.VSL_CD			= T2.VSL_CD" ).append("\n"); 
		query.append("    AND		S1.SKD_DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND		S1.YD_CD			= T2.YD_CD)" ).append("\n"); 
		query.append("AND TO_CHAR(T2.VPS_ETA_DT, 'HH24MI')	BETWEEN SCG_FM_LMT_HRMNT" ).append("\n"); 
		query.append("										AND SCG_TO_LMT_HRMNT" ).append("\n"); 

	}
}