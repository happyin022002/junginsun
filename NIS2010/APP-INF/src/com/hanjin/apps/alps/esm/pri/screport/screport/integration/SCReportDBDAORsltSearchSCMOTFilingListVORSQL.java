/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCMOTFilingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCMOTFilingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCMOTFilingListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCMOTFilingListVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("RT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	RT.PROP_NO				," ).append("\n"); 
		query.append("        RT.AMDT_SEQ				," ).append("\n"); 
		query.append("        RT.SVC_SCP_CD			," ).append("\n"); 
		query.append("        RT.GEN_SPCL_RT_TP_CD	," ).append("\n"); 
		query.append("        RT.CMDT_HDR_SEQ			," ).append("\n"); 
		query.append("        RT.ROUT_SEQ				," ).append("\n"); 
		query.append("        RT.RT_SEQ				," ).append("\n"); 
		query.append("        SH.SC_NO				," ).append("\n"); 
		query.append("        SS.EFF_DT				," ).append("\n"); 
		query.append("        DECODE(OP.ROUT_PNT_LOC_TP_CD, 'L', OP.ROUT_PNT_LOC_DEF_CD, 'G', OD.LOC_CD)	POL_CD," ).append("\n"); 
		query.append("        DECODE(DP.ROUT_PNT_LOC_TP_CD, 'L', DP.ROUT_PNT_LOC_DEF_CD, 'G', DD.LOC_CD)	POD_CD," ).append("\n"); 
		query.append("        RT.RAT_UT_CD			," ).append("\n"); 
		query.append("        UT2.RAT_UT_CD CNTR_SZ_CD," ).append("\n"); 
		query.append("        RT.PRC_CGO_TP_CD		," ).append("\n"); 
		query.append("        RT.CURR_CD				," ).append("\n"); 
		query.append("        RT.FNL_FRT_RT_AMT		," ).append("\n"); 
		query.append("        SD.CTRT_EFF_DT			," ).append("\n"); 
		query.append("        SD.CTRT_EXP_DT			," ).append("\n"); 
		query.append("        SQ.CNTR_LOD_UT_CD		," ).append("\n"); 
		query.append("        SQ.FNL_MQC_QTY			," ).append("\n"); 
		query.append("        CP.CTRT_PTY_NM" ).append("\n"); 
		query.append("FROM	PRI_SP_HDR				SH," ).append("\n"); 
		query.append("        PRI_SP_MN				SM," ).append("\n"); 
		query.append("        PRI_SP_CTRT_PTY			CP," ).append("\n"); 
		query.append("        PRI_SP_SCP_MN			SS," ).append("\n"); 
		query.append("        PRI_SP_SCP_DUR			SD," ).append("\n"); 
		query.append("        PRI_SP_SCP_MQC			SQ," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT_CMDT_HDR  CH," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT_CMDT_ROUT CR," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT_ROUT_PNT	OP," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT_ROUT_PNT	DP," ).append("\n"); 
		query.append("        PRI_SP_SCP_GRP_LOC		OG," ).append("\n"); 
		query.append("        PRI_SP_SCP_GRP_LOC_DTL	OD," ).append("\n"); 
		query.append("        PRI_SP_SCP_GRP_LOC		DG," ).append("\n"); 
		query.append("        PRI_SP_SCP_GRP_LOC_DTL	DD," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT           RT," ).append("\n"); 
		query.append("        PRI_RAT_UT              UT1," ).append("\n"); 
		query.append("        PRI_RAT_UT              UT2" ).append("\n"); 
		query.append("WHERE	SM.PROP_NO				= SH.PROP_NO" ).append("\n"); 
		query.append("AND		CP.PROP_NO				= SM.PROP_NO" ).append("\n"); 
		query.append("AND		CP.AMDT_SEQ				= SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CP.PRC_CTRT_PTY_TP_CD   = 'C'" ).append("\n"); 
		query.append("AND		SS.PROP_NO				= SM.PROP_NO" ).append("\n"); 
		query.append("AND		SS.AMDT_SEQ				= SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SD.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("AND		SD.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SD.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		SD.SRC_INFO_CD     		<> 'AD'" ).append("\n"); 
		query.append("AND		SQ.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("AND		SQ.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SQ.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		SQ.SRC_INFO_CD     		<> 'AD'" ).append("\n"); 
		query.append("AND		CH.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("AND		CH.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CH.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		CR.PROP_NO				= CH.PROP_NO" ).append("\n"); 
		query.append("AND		CR.AMDT_SEQ				= CH.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CR.SVC_SCP_CD			= CH.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		CR.GEN_SPCL_RT_TP_CD	= CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		CR.CMDT_HDR_SEQ			= CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		OP.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("AND		OP.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND		OP.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		OP.GEN_SPCL_RT_TP_CD	= CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		OP.CMDT_HDR_SEQ 		= CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		OP.ROUT_SEQ				= CR.ROUT_SEQ" ).append("\n"); 
		query.append("AND		OP.ORG_DEST_TP_CD		= 'O'" ).append("\n"); 
		query.append("AND     OP.SRC_INFO_CD     		<> 'AD'" ).append("\n"); 
		query.append("AND		DP.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("AND		DP.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND		DP.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		DP.GEN_SPCL_RT_TP_CD	= CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		DP.CMDT_HDR_SEQ 		= CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		DP.ROUT_SEQ				= CR.ROUT_SEQ" ).append("\n"); 
		query.append("AND		DP.ORG_DEST_TP_CD		= 'D'" ).append("\n"); 
		query.append("AND     DP.SRC_INFO_CD     		<> 'AD'" ).append("\n"); 
		query.append("AND		OG.PROP_NO(+)			= OP.PROP_NO" ).append("\n"); 
		query.append("AND		OG.AMDT_SEQ(+)			= OP.AMDT_SEQ" ).append("\n"); 
		query.append("AND		OG.SVC_SCP_CD(+)		= OP.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		OG.PRC_GRP_LOC_CD(+)	= OP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND		OD.PROP_NO(+)			= OG.PROP_NO" ).append("\n"); 
		query.append("AND		OD.AMDT_SEQ(+)			= OG.AMDT_SEQ" ).append("\n"); 
		query.append("AND		OD.SVC_SCP_CD(+)		= OG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		OD.GRP_LOC_SEQ(+)		= OG.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND     OD.SRC_INFO_CD(+)		<> 'AD'" ).append("\n"); 
		query.append("AND		DG.PROP_NO(+)			= DP.PROP_NO" ).append("\n"); 
		query.append("AND		DG.AMDT_SEQ(+)			= DP.AMDT_SEQ" ).append("\n"); 
		query.append("AND		DG.SVC_SCP_CD(+)		= DP.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		DG.PRC_GRP_LOC_CD(+)	= DP.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND		DD.PROP_NO(+)			= DG.PROP_NO" ).append("\n"); 
		query.append("AND		DD.AMDT_SEQ(+)			= DG.AMDT_SEQ" ).append("\n"); 
		query.append("AND		DD.SVC_SCP_CD(+)		= DG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		DD.GRP_LOC_SEQ(+)		= DG.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND     DD.SRC_INFO_CD(+)		<> 'AD'" ).append("\n"); 
		query.append("AND		RT.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("AND		RT.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("AND		RT.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		RT.GEN_SPCL_RT_TP_CD	= CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		RT.CMDT_HDR_SEQ			= CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		RT.ROUT_SEQ				= CR.ROUT_SEQ" ).append("\n"); 
		query.append("AND		SM.PROP_STS_CD			=	'F'" ).append("\n"); 
		query.append("AND		SS.EFF_DT               >= TO_DATE(@[from_file_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND		SS.EFF_DT               <= TO_DATE(@[to_file_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     RT.RAT_UT_CD            = UT1.RAT_UT_CD" ).append("\n"); 
		query.append("AND     UT1.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND     UT1.CNTR_SZ_CD          = UT2.CNTR_SZ_CD" ).append("\n"); 
		query.append("AND     UT2.RAT_UT_CD           IN ('20', '40', '45', '53')" ).append("\n"); 
		query.append("AND     UT2.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("	ORIGIN 에 COUNTRY CODE 로 CN 이 있는 계약만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		EXISTS	(" ).append("\n"); 
		query.append("				SELECT	'X'" ).append("\n"); 
		query.append("				FROM	PRI_SP_SCP_ROUT_PNT	RP" ).append("\n"); 
		query.append("				WHERE	RP.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("				AND		RP.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		RP.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		RP.ORG_DEST_TP_CD       = 'O'" ).append("\n"); 
		query.append("				AND		RP.ROUT_PNT_LOC_TP_CD	= 'C'" ).append("\n"); 
		query.append("				AND		RP.ROUT_PNT_LOC_DEF_CD	= 'CN'	-- 업무적 결정" ).append("\n"); 
		query.append("				AND     RP.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("	DESTINATION 에 COUNTRY CODE 로 UN 이 있는 계약만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		EXISTS	(" ).append("\n"); 
		query.append("				SELECT	'X'" ).append("\n"); 
		query.append("				FROM	PRI_SP_SCP_ROUT_PNT	RP" ).append("\n"); 
		query.append("				WHERE	RP.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("				AND		RP.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		RP.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		RP.ORG_DEST_TP_CD	    = 'D'" ).append("\n"); 
		query.append("				AND		RP.ROUT_PNT_LOC_TP_CD	= 'C'" ).append("\n"); 
		query.append("				AND		RP.ROUT_PNT_LOC_DEF_CD	= 'US'	-- 업무적 결정" ).append("\n"); 
		query.append("				AND     RP.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("	ROUTE 의 ORIGIN 이 특정한 대상 LOCATION 인 운임을 SELECT 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		DECODE(OP.ROUT_PNT_LOC_TP_CD, 'L', OP.ROUT_PNT_LOC_DEF_CD, 'G', OD.LOC_CD)" ).append("\n"); 
		query.append("					IN ( 'CNDLC', 'CNXGG', 'CNTAO', 'CNLYG', 'CNNKG', 'CNSHA', 'CNNBO', 'CNXMN', 'CNSZP', 'CNCAN' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("	ROUTE 의 DESTINATION 이 특정한 대상 LOCATION 인 운임을 SELECT 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		DECODE(DP.ROUT_PNT_LOC_TP_CD, 'L', DP.ROUT_PNT_LOC_DEF_CD, 'G', DD.LOC_CD)" ).append("\n"); 
		query.append("					IN ( 'USLGB', 'USLAX', 'USOAK', 'USSFO', 'USSEA', 'USTIW', 'USBAL', 'USBOS', 'USMIA', 'USNYC' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("	AMEND 가 존재하는 것만을 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		(" ).append("\n"); 
		query.append("		/*	COMODITY 에 수정이 있는 운임을 대상으로 한다.	*/" ).append("\n"); 
		query.append("		EXISTS	(" ).append("\n"); 
		query.append("				SELECT	'X'" ).append("\n"); 
		query.append("				FROM		PRI_SP_SCP_RT_CMDT	CM" ).append("\n"); 
		query.append("				WHERE		CM.PROP_NO				= CH.PROP_NO" ).append("\n"); 
		query.append("				AND			CM.AMDT_SEQ				= CH.AMDT_SEQ" ).append("\n"); 
		query.append("				AND			CM.SVC_SCP_CD			= CH.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND			CM.GEN_SPCL_RT_TP_CD	= CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("				AND			CM.CMDT_HDR_SEQ 		= CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				AND			CM.N1ST_CMNC_AMDT_SEQ	= CM.AMDT_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		OR	EXISTS	(" ).append("\n"); 
		query.append("                    SELECT	'X'" ).append("\n"); 
		query.append("                    FROM		PRI_SP_SCP_RT_CMDT			CM	," ).append("\n"); 
		query.append("                                PRI_SP_SCP_GRP_CMDT			CG	," ).append("\n"); 
		query.append("                                PRI_SP_SCP_GRP_CMDT_DTL	CD" ).append("\n"); 
		query.append("                    WHERE		CM.PROP_NO				= CH.PROP_NO" ).append("\n"); 
		query.append("                    AND			CM.AMDT_SEQ				= CH.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND			CM.SVC_SCP_CD			= CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND			CM.GEN_SPCL_RT_TP_CD	= CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND			CM.CMDT_HDR_SEQ 		= CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND			CM.PRC_CMDT_TP_CD		= 'G'" ).append("\n"); 
		query.append("                    AND			CG.PROP_NO				= CM.PROP_NO" ).append("\n"); 
		query.append("                    AND			CG.AMDT_SEQ				= CM.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND			CG.SVC_SCP_CD			= CM.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND			CG.PRC_GRP_CMDT_CD		= CM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    AND			CD.PROP_NO				= CG.PROP_NO" ).append("\n"); 
		query.append("                    AND			CD.AMDT_SEQ				= CG.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND			CD.SVC_SCP_CD			= CG.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND			CD.GRP_CMDT_SEQ    		= CG.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                    AND			CD.N1ST_CMNC_AMDT_SEQ	= CM.AMDT_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/*	ORG, DEST 에 수정이 있는 운임을 대상으로 한다.	*/" ).append("\n"); 
		query.append("		OR	OP.N1ST_CMNC_AMDT_SEQ	=	OP.AMDT_SEQ" ).append("\n"); 
		query.append("		OR	OD.N1ST_CMNC_AMDT_SEQ	=	OD.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				/*	DEST 에 수정이 있는 운임을 대상으로 한다.	*/" ).append("\n"); 
		query.append("		OR	DP.N1ST_CMNC_AMDT_SEQ	=	DP.AMDT_SEQ" ).append("\n"); 
		query.append("		OR	DD.N1ST_CMNC_AMDT_SEQ	=	DD.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				/*	운임에 수정이 있는 것을 대상으로 한다.	*/" ).append("\n"); 
		query.append("		OR	EXISTS	(" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM		PRI_SP_SCP_RT	A" ).append("\n"); 
		query.append("					WHERE		A.PROP_NO				= CR.PROP_NO" ).append("\n"); 
		query.append("					AND			A.AMDT_SEQ				= CR.AMDT_SEQ" ).append("\n"); 
		query.append("					AND			A.SVC_SCP_CD			= CR.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND			A.GEN_SPCL_RT_TP_CD		= CR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("					AND			A.CMDT_HDR_SEQ 			= CR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("					AND			A.ROUT_SEQ				= CR.ROUT_SEQ" ).append("\n"); 
		query.append("					AND			A.N1ST_CMNC_AMDT_SEQ	= CR.AMDT_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	SC_NO				," ).append("\n"); 
		query.append("        POL_CD				," ).append("\n"); 
		query.append("        POD_CD				," ).append("\n"); 
		query.append("        CHG_CD				," ).append("\n"); 
		query.append("        CURR_CD				," ).append("\n"); 
		query.append("        CHG_UT_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("        SELECT  BK.SC_NO," ).append("\n"); 
		query.append("                BK.POL_CD," ).append("\n"); 
		query.append("                BK.POD_CD," ).append("\n"); 
		query.append("                CR.CHG_CD," ).append("\n"); 
		query.append("                CR.CURR_CD," ).append("\n"); 
		query.append("                CR.CHG_UT_AMT," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER ( PARTITION BY BK.SC_NO, BK.POL_CD, BK.POD_CD, CR.CHG_CD ORDER BY BK.BKG_CRE_DT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  DISTINCT" ).append("\n"); 
		query.append("                		SC_NO				," ).append("\n"); 
		query.append("                		POL_CD				," ).append("\n"); 
		query.append("                		POD_CD" ).append("\n"); 
		query.append("                FROM    RT" ).append("\n"); 
		query.append("                ) A ," ).append("\n"); 
		query.append("                BKG_BOOKING			BK," ).append("\n"); 
		query.append("				BKG_CHG_RT			CR" ).append("\n"); 
		query.append("        WHERE   BK.SC_NO	    	= A.SC_NO" ).append("\n"); 
		query.append("		AND		BK.POL_CD			= A.POL_CD" ).append("\n"); 
		query.append("		AND		BK.POD_CD			= A.POD_CD" ).append("\n"); 
		query.append("		AND		BK.BKG_CRE_DT		>= TO_DATE(@[from_file_dt], 'YYYY-MM-DD') - 30" ).append("\n"); 
		query.append("		AND		BK.BKG_STS_CD		IN ( 'F', 'W' )" ).append("\n"); 
		query.append("		AND		BK.BKG_CGO_TP_CD	<> 'P'" ).append("\n"); 
		query.append("		AND		CR.BKG_NO			= BK.BKG_NO" ).append("\n"); 
		query.append("		AND		CR.CHG_CD			IN ( 'BUC', 'PCC', 'DHF', 'OTH', 'CMS', 'CSR', 'TSC' )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE	ROW_NUMBER	= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	/*+ NO_QUERY_TRANSFORMATION  */" ).append("\n"); 
		query.append("        'SML' AS CARRIER," ).append("\n"); 
		query.append("        RT.SC_NO," ).append("\n"); 
		query.append("        RT.CTRT_PTY_NM," ).append("\n"); 
		query.append("        DECODE(RT.POD_CD, 'USLGB', '09', 'USLAX', '09', 'USOAK', '09', 'USSFO', '09', 'USSEA', '09', 'USTIW', '09', 'USBAL', '10', 'USBOS', '10', 'USMIA', '10', 'USNYC', '10', '' ) AS LANE," ).append("\n"); 
		query.append("        DECODE(RT.POL_CD, 'CNNBO', 'CNNGB', 'CNSZP', 'CNSZX', RT.POL_CD) POL_CD," ).append("\n"); 
		query.append("        RT.POD_CD," ).append("\n"); 
		query.append("        DECODE(RT.RAT_UT_CD, 'D5', 'HQ', 'F5', 'HQ', 'R5', 'HQ', 'D7', 'HQ', " ).append("\n"); 
		query.append("                             'SW', 'HT', 'SW', 'HT', 'SF', 'HT', 'SF', 'HT'," ).append("\n"); 
		query.append("                             'SH', 'HT', 'SH', 'HT', 'SV', 'HT', 'SV', 'HT', " ).append("\n"); 
		query.append("                             DECODE ( SUBSTR(RT.RAT_UT_CD, 1, 1 ), 'D','DV','F','FR','O','OT','R','RH','T','TK','Q','XX',RT.PRC_CGO_TP_CD)" ).append("\n"); 
		query.append("                             ) AS CNTR_TP," ).append("\n"); 
		query.append("        'GC' AS CMDT_TP," ).append("\n"); 
		query.append("        RT.CNTR_SZ_CD AS CNTR_SZ," ).append("\n"); 
		query.append("        RT.FNL_MQC_QTY      AS MQC_1," ).append("\n"); 
		query.append("        RT.FNL_FRT_RT_AMT   AS OFT_RT," ).append("\n"); 
		query.append("        (SELECT SUM(CHG_UT_AMT) FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD IN ('BUC', 'PCC', 'CMS', 'CSR', 'TSC')) AS SUR_RT," ).append("\n"); 
		query.append("        TO_CHAR(RT.CTRT_EFF_DT, 'YYYYMMDD')				AS EFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(RT.CTRT_EXP_DT, 'YYYYMMDD')				AS EXP_DT," ).append("\n"); 
		query.append("        '1) Surcharge Details : OTH(RMB):'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'OTH')||" ).append("\n"); 
		query.append("        '/BUC:'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'BUC')||" ).append("\n"); 
		query.append("        '/CMS:'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'CMS')||" ).append("\n"); 
		query.append("        '/CSR:'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'CSR')||" ).append("\n"); 
		query.append("        '/TSC:'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'TSC')||" ).append("\n"); 
		query.append("        '/PCC:'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'PCC')||" ).append("\n"); 
		query.append("        '/DHF(RMB):'||(SELECT CHG_UT_AMT FROM CR WHERE CR.SC_NO = RT.SC_NO AND CR.POL_CD = RT.POL_CD AND CR.POD_CD = RT.POD_CD AND CR.CHG_CD = 'DHF')||" ).append("\n"); 
		query.append("        '    ;2) Commodity Details : GC IN GROUP '||chr(34)||': '||CM.REP_CMDT_CD||" ).append("\n"); 
		query.append("        '   3) Rate Notes : '||RN.NOTE_CTNT  AS REMARK," ).append("\n"); 
		query.append("        '' FROM_FILE_DT," ).append("\n"); 
		query.append("        '' TO_FILE_DT" ).append("\n"); 
		query.append("FROM	RT," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                AMDT_SEQ          ," ).append("\n"); 
		query.append("                SVC_SCP_CD        ," ).append("\n"); 
		query.append("                GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                REPLACE(LTRIM(SYS_CONNECT_BY_PATH(REP_CMDT_CD,'^|^'),'^|^'), '^|^', ', ') REP_CMDT_CD" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  CM.PROP_NO            ," ).append("\n"); 
		query.append("                        CM.AMDT_SEQ           ," ).append("\n"); 
		query.append("                        CM.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                        CM.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                        CM.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD, CM.GEN_SPCL_RT_TP_CD, CM.CMDT_HDR_SEQ ORDER BY MC.REP_CMDT_CD ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER ( PARTITION BY CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD, CM.GEN_SPCL_RT_TP_CD, CM.CMDT_HDR_SEQ ) CNT ," ).append("\n"); 
		query.append("                        MC.REP_CMDT_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  DISTINCT" ).append("\n"); 
		query.append("                                PROP_NO					," ).append("\n"); 
		query.append("                                AMDT_SEQ				," ).append("\n"); 
		query.append("                                SVC_SCP_CD				," ).append("\n"); 
		query.append("                                GEN_SPCL_RT_TP_CD		," ).append("\n"); 
		query.append("                                CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        FROM    RT" ).append("\n"); 
		query.append("                        ) A ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_RT_CMDT			CM	," ).append("\n"); 
		query.append("						PRI_SP_SCP_GRP_CMDT			CG	," ).append("\n"); 
		query.append("						PRI_SP_SCP_GRP_CMDT_DTL	CD	," ).append("\n"); 
		query.append("						MDM_COMMODITY				MC" ).append("\n"); 
		query.append("                WHERE   CM.PROP_NO              = A.PROP_NO" ).append("\n"); 
		query.append("                AND     CM.AMDT_SEQ             = A.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CM.SVC_SCP_CD           = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     CM.GEN_SPCL_RT_TP_CD    = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     CM.CMDT_HDR_SEQ         = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     CM.SRC_INFO_CD          <> 'AD'" ).append("\n"); 
		query.append("				AND		CG.PROP_NO(+)           = CM.PROP_NO" ).append("\n"); 
		query.append("				AND		CG.AMDT_SEQ(+)			= CM.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		CG.SVC_SCP_CD(+)		= CM.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		CG.PRC_GRP_CMDT_CD(+)	= CM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("				AND		CD.PROP_NO(+)			= CG.PROP_NO" ).append("\n"); 
		query.append("				AND		CD.AMDT_SEQ(+)			= CG.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		CD.SVC_SCP_CD(+)		= CG.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		CD.GRP_CMDT_SEQ(+)      = CG.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("				AND		MC.CMDT_CD				= DECODE(CM.PRC_CMDT_TP_CD, 'G', CD.PRC_CMDT_DEF_CD, CM.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL   = CNT" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        ) CM	," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  PROP_NO           ," ).append("\n"); 
		query.append("                AMDT_SEQ          ," ).append("\n"); 
		query.append("                SVC_SCP_CD        ," ).append("\n"); 
		query.append("                GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                CMDT_HDR_SEQ      ," ).append("\n"); 
		query.append("                ROUT_SEQ          ," ).append("\n"); 
		query.append("                REPLACE(LTRIM(SYS_CONNECT_BY_PATH(NOTE_CTNT,'^|^'),'^|^'), '^|^', CHR(13)||CHR(10)||CHR(13)||CHR(10)) NOTE_CTNT" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  RN.PROP_NO            ," ).append("\n"); 
		query.append("                        RN.AMDT_SEQ           ," ).append("\n"); 
		query.append("                        RN.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                        RN.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                        RN.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                        RN.ROUT_SEQ           ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY RN.PROP_NO, RN.AMDT_SEQ, RN.SVC_SCP_CD, RN.GEN_SPCL_RT_TP_CD, RN.CMDT_HDR_SEQ, RN.ROUT_SEQ ORDER BY RN.ROUT_NOTE_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER ( PARTITION BY RN.PROP_NO, RN.AMDT_SEQ, RN.SVC_SCP_CD, RN.GEN_SPCL_RT_TP_CD, RN.CMDT_HDR_SEQ, RN.ROUT_SEQ ) CNT ," ).append("\n"); 
		query.append("                        RN.ROUT_NOTE_SEQ ||'. '||RN.NOTE_CTNT NOTE_CTNT" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  DISTINCT" ).append("\n"); 
		query.append("                        		PROP_NO					," ).append("\n"); 
		query.append("                        		AMDT_SEQ				," ).append("\n"); 
		query.append("                        		SVC_SCP_CD				," ).append("\n"); 
		query.append("                                GEN_SPCL_RT_TP_CD		," ).append("\n"); 
		query.append("                                CMDT_HDR_SEQ			," ).append("\n"); 
		query.append("                                ROUT_SEQ" ).append("\n"); 
		query.append("                        FROM    RT" ).append("\n"); 
		query.append("                        ) A ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_RT_CMDT_RNOTE RN" ).append("\n"); 
		query.append("                WHERE   RN.PROP_NO            = A.PROP_NO" ).append("\n"); 
		query.append("                AND     RN.AMDT_SEQ           = A.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     RN.SVC_SCP_CD         = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     RN.GEN_SPCL_RT_TP_CD  = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     RN.CMDT_HDR_SEQ       = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     RN.ROUT_SEQ           = A.ROUT_SEQ" ).append("\n"); 
		query.append("                AND     RN.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL   = CNT" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     ROUT_SEQ          = PRIOR ROUT_SEQ" ).append("\n"); 
		query.append("        AND     ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        ) RN" ).append("\n"); 
		query.append("WHERE	CM.PROP_NO				= RT.PROP_NO" ).append("\n"); 
		query.append("AND		CM.AMDT_SEQ				= RT.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CM.SVC_SCP_CD			= RT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		CM.GEN_SPCL_RT_TP_CD	= RT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		CM.CMDT_HDR_SEQ			= RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		RN.PROP_NO(+)			= RT.PROP_NO" ).append("\n"); 
		query.append("AND		RN.AMDT_SEQ(+)			= RT.AMDT_SEQ" ).append("\n"); 
		query.append("AND		RN.SVC_SCP_CD(+)		= RT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		RN.GEN_SPCL_RT_TP_CD(+) = RT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		RN.CMDT_HDR_SEQ(+)		= RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		RN.ROUT_SEQ(+)			= RT.ROUT_SEQ" ).append("\n"); 

	}
}