/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOMissingTDRVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOMissingTDRVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.26 박희동 최초작성
	  * Missing TDR Inquiry 화면 조회 Query   
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOMissingTDRVORSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOMissingTDRVORSQL").append("\n"); 
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
		query.append("SELECT XX.RHQ_OFC_CD, XX.CRR_CD, XX.PORT_CD, XX.YD_CD, XX.YD_NM, XX.SLAN_CD, XX.SVC_TP_CD, XX.VVD, XX.AR_DT, XX.DP_DT, XX.MV_CNT, XX.BAY_PLN_FLG, XX.TDR_FLG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT ----CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN" ).append("\n"); 
		query.append("              ----         ''" ).append("\n"); 
		query.append("              ----     ELSE" ).append("\n"); 
		query.append("              ----         ML.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("              ----END AS RHQ_OFC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  --(SELECT	CASE 	WHEN 	DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("              --    						THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'VSK'))) -- EUROPE REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("              --					WHEN 	CONTI_CD  = 'M' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("              --    						THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002', 'VSK'))) -- AMERICA REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("              --					WHEN 	CONTI_CD  = 'A' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y' --AND SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("              --    						THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000003', 'VSK'))) -- ASIA REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("        	  --			END	" ).append("\n"); 
		query.append("			  --	FROM	MDM_LOCATION	ML" ).append("\n"); 
		query.append("			  --	WHERE	ML.LOC_CD		= PS.VPS_PORT_CD" ).append("\n"); 
		query.append("			  --)	AS		RHQ_OFC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			(	SELECT		MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))	AS NAME    " ).append("\n"); 
		query.append("				FROM		MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("				CONNECT BY 	NOCYCLE PRIOR MO.PRNT_OFC_CD	= MO.OFC_CD" ).append("\n"); 
		query.append("				START WITH 	MO.OFC_CD 						= (SELECT ML.SLS_OFC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = PS.VPS_PORT_CD)" ).append("\n"); 
		query.append("			)	AS RHQ_OFC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              VS.ACT_CRR_CD AS CRR_CD," ).append("\n"); 
		query.append("              PS.VPS_PORT_CD AS PORT_CD," ).append("\n"); 
		query.append("              PS.YD_CD," ).append("\n"); 
		query.append("              MY.YD_NM," ).append("\n"); 
		query.append("              PS.SLAN_CD," ).append("\n"); 
		query.append("              SL.VSL_SVC_TP_CD AS SVC_TP_CD," ).append("\n"); 
		query.append("              PS.VSL_CD||PS.SKD_VOY_NO||PS.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("              TO_CHAR(AA.ACT_ARR_DT,'YYYYMMDDHH24MI') AS AR_DT," ).append("\n"); 
		query.append("              TO_CHAR(AA.ACT_DEP_DT,'YYYYMMDDHH24MI') AS DP_DT," ).append("\n"); 
		query.append("              NVL(TH.MVS,0) AS MV_CNT," ).append("\n"); 
		query.append("              DECODE(NVL((" ).append("\n"); 
		query.append("                SELECT 1" ).append("\n"); 
		query.append("                FROM   BAY_PLAN BP" ).append("\n"); 
		query.append("                WHERE  BP.VSL_CD    = PS.VSL_CD" ).append("\n"); 
		query.append("                AND    BP.VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    BP.DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    BP.PORT_CD   = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                AND    BP.CALL_IND  = PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND    BP.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                AND    ROWNUM       = 1" ).append("\n"); 
		query.append("                ),0),0,'N','Y')  AS BAY_PLN_FLG," ).append("\n"); 
		query.append("              NVL2(TH.VSL_CD, 'Y', 'N') AS TDR_FLG" ).append("\n"); 
		query.append("       FROM   TDR_HEADER       TH," ).append("\n"); 
		query.append("              VSK_VSL_PORT_SKD PS," ).append("\n"); 
		query.append("              VSK_VSL_SKD      VS," ).append("\n"); 
		query.append("              VSK_ACT_PORT_SKD AA," ).append("\n"); 
		query.append("              MDM_LOCATION     ML," ).append("\n"); 
		query.append("              MDM_YARD         MY," ).append("\n"); 
		query.append("              MDM_VSL_SVC_LANE SL" ).append("\n"); 
		query.append("       WHERE  PS.VSL_CD       = TH.VSL_CD   (+)" ).append("\n"); 
		query.append("       AND    PS.SKD_VOY_NO   = TH.VOY_NO   (+)" ).append("\n"); 
		query.append("       AND    PS.SKD_DIR_CD   = TH.DIR_CD   (+)" ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD  = TH.PORT_CD  (+)" ).append("\n"); 
		query.append("       AND    PS.CLPT_IND_SEQ = TH.CALL_IND (+)" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND    PS.VSL_CD       = VS.VSL_CD" ).append("\n"); 
		query.append("       AND    PS.SKD_VOY_NO   = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    PS.SKD_DIR_CD   = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND    PS.VSL_CD       = AA.VSL_CD" ).append("\n"); 
		query.append("       AND    PS.SKD_VOY_NO   = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    PS.SKD_DIR_CD   = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD  = AA.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND    PS.CLPT_IND_SEQ = AA.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD  = ML.LOC_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND    PS.YD_CD        = MY.YD_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND    PS.SLAN_CD      = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD  NOT IN ('EGSCA','PAPCA')" ).append("\n"); 
		query.append("       AND    PS.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("#if (${ex_tpr_flg} == 'Y')" ).append("\n"); 
		query.append("       AND    EXISTS (" ).append("\n"); 
		query.append("                SELECT 1" ).append("\n"); 
		query.append("                  FROM OPF_TML_DEP_RPT_DTL X" ).append("\n"); 
		query.append("                 WHERE X.VSL_CD       = PS.VSL_CD" ).append("\n"); 
		query.append("                   AND X.SKD_VOY_NO   = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND X.SKD_DIR_CD   = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND X.CLPT_CD      = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND X.CLPT_IND_SEQ = PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end           " ).append("\n"); 
		query.append("       /* cf. TURN_PORT_FLG" ).append("\n"); 
		query.append("       - D : Direction Change" ).append("\n"); 
		query.append("       - F : Final Port" ).append("\n"); 
		query.append("       - N : First Call/Normal Port" ).append("\n"); 
		query.append("       - V : Voyage Change" ).append("\n"); 
		query.append("       - Y : Turning Port" ).append("\n"); 
		query.append("       */                                         " ).append("\n"); 
		query.append("       AND    NVL(PS.SKD_CNG_STS_CD,'N') <> 'S' -- S:Skip,I:Phase-In,O:Phase-Out,A:Adding" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("       AND    AA.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("       #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("       AND    AA.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("       AND    AA.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND    AA.ACT_DEP_DT  BETWEEN TO_DATE(REPLACE(@[fr_dt],'-','')||'000000','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("                             AND     TO_DATE(REPLACE(@[to_dt],'-','')||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("       AND    PS.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    VS.ACT_CRR_CD IN  ( CASE WHEN @[crr_cd] = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() THEN" ).append("\n"); 
		query.append("                                 COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                 SELECT VS.ACT_CRR_CD" ).append("\n"); 
		query.append("                                 FROM   VSK_VSL_SKD S" ).append("\n"); 
		query.append("                                 WHERE  VS.VSL_CD       = S.VSL_CD" ).append("\n"); 
		query.append("                                 AND    VS.SKD_VOY_NO   = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND    VS.SKD_DIR_CD   = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND    VS.ACT_CRR_CD   != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_tp_cd} != 'All' && ${svc_tp_cd} != '')" ).append("\n"); 
		query.append("#if (${svc_tp_cd} == 'TRK')" ).append("\n"); 
		query.append("       AND    SL.VSL_SVC_TP_CD IN ('I', 'J', 'S') --TRUNK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND    NVL(SL.VSL_SVC_TP_CD,'*') NOT IN ('I', 'J', 'S')  -- FEEDER" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) XX" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tdr_flg} == 'MSS')" ).append("\n"); 
		query.append("AND     (1 = 1" ).append("\n"); 
		query.append("		 ----AND	XX.CRR_CD  = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                  " ).append("\n"); 
		query.append("		 ----AND    XX.SVC_TP_CD IN ('I', 'J', 'S')      " ).append("\n"); 
		query.append("		 AND    XX.MV_CNT  = 0                       " ).append("\n"); 
		query.append("		 AND    ((XX.BAY_PLN_FLG = 'Y' AND XX.TDR_FLG = 'N') OR XX.BAY_PLN_FLG = 'N')" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#elseif(${tdr_flg} == 'EXT')" ).append("\n"); 
		query.append("AND NOT (1 = 1" ).append("\n"); 
		query.append("		 ----AND	XX.CRR_CD  = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                  " ).append("\n"); 
		query.append("		 ----AND    XX.SVC_TP_CD IN ('I', 'J', 'S')      " ).append("\n"); 
		query.append("		 AND    XX.MV_CNT  = 0                       " ).append("\n"); 
		query.append("		 AND    ((XX.BAY_PLN_FLG = 'Y' AND XX.TDR_FLG = 'N') OR XX.BAY_PLN_FLG = 'N')" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("AND		XX.RHQ_OFC_CD	= @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER  BY 1,2,3,4,6,7,8,9" ).append("\n"); 

	}
}