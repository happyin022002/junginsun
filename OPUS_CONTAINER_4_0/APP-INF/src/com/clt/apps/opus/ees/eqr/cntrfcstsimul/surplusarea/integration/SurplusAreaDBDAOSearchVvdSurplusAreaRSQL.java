/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SurplusAreaDBDAOSearchVvdSurplusAreaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.07.10 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOSearchVvdSurplusAreaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Inventory Balance Simulation 의 VVD sheet 를 조회한다
	  * </pre>
	  */
	public SurplusAreaDBDAOSearchVvdSurplusAreaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subconti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOSearchVvdSurplusAreaRSQL").append("\n"); 
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
		query.append("--// BSA GRID 조회 V01 " ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("BSA_GRID_O1 AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("		DISTINCT" ).append("\n"); 
		query.append("		NVL(A.RHQ,DECODE(A.TRD_CD,'AES','HAMUR','TPS','NYCNA','IAS','SINWA','')) RHQ," ).append("\n"); 
		query.append("        A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD, A.COST_YRWK, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("        , B.FNL_HJS_BSA_CAPA_BSA BSA, B.FNL_HJS_BSA_CAPA_WT BSA_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT A.TRD_CD, A.SUB_TRD_CD, A.IOC_CD, A.RLANE_CD, A.COST_YRWK, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            DISTINCT O.AR_HD_QTR_OFC_CD RHQ" ).append("\n"); 
		query.append("            FROM MDM_LOCATION M, MDM_ORGANIZATION O" ).append("\n"); 
		query.append("            WHERE 1=1 " ).append("\n"); 
		query.append("			AND M.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("            AND M.LOC_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(O.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND O.AR_HD_QTR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) RHQ, A.VPS_PORT_CD" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            DISTINCT" ).append("\n"); 
		query.append("            R.REP_TRD_CD TRD_CD, D.SUB_TRD_CD, R.RLANE_CD, D.VSL_SLAN_DIR_CD, D.FM_CONTI_CD, D.IOC_CD" ).append("\n"); 
		query.append("            , P.COST_YR||P.COST_WK AS COST_YRWK, P.SLS_FM_DT, P.SLS_TO_DT" ).append("\n"); 
		query.append("            , V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.SLAN_CD, V.CLPT_SEQ, V.VPS_PORT_CD, V.YD_CD" ).append("\n"); 
		query.append("            , MAX(DECODE(V.TURN_PORT_FLG,'Y',V.VPS_ETD_DT,'')) OVER (PARTITION BY V.SLAN_CD,V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) MAX_VPS_ETD_DT" ).append("\n"); 
		query.append("        FROM MDM_REV_LANE R, MDM_DTL_REV_LANE D, MDM_LOCATION L, COA_MON_VVD C, COA_WK_PRD P, VSK_VSL_PORT_SKD V, MDM_VSL_SVC_LANE M, MDM_LOCATION T" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("            AND R.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("            AND NVL(R.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("            AND NVL(D.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("            AND D.IOC_CD = CASE WHEN SUBSTR(R.REP_TRD_CD,1,1)='I' THEN 'I' ELSE 'O' END" ).append("\n"); 
		query.append("    #if(${lane} != '')        -- Lane 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_lane})" ).append("\n"); 
		query.append("            #if($velocityCount > 1 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        D.RLANE_CD LIKE SUBSTR('$key',6,3)||'%'  -- LANE" ).append("\n"); 
		query.append("                    AND D.SUB_TRD_CD = SUBSTR('$key',4,2)        -- SUB TRADE" ).append("\n"); 
		query.append("                    AND R.REP_TRD_CD = SUBSTR('$key',1,3)        -- TRADE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif(${subtrade} != '') -- S.Trade 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_subtrade})" ).append("\n"); 
		query.append("            #if($velocityCount > 1 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        D.SUB_TRD_CD = SUBSTR('$key',4,2)    -- SUB TRADE" ).append("\n"); 
		query.append("                    AND R.REP_TRD_CD = SUBSTR('$key',1,3)    -- TRADE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif(${trade} != '')   -- Trade 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("              R.REP_TRD_CD IN (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_trade})" ).append("\n"); 
		query.append("            #if($velocityCount == 1 )" ).append("\n"); 
		query.append("                                '$key'" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                               ,'$key'" ).append("\n"); 
		query.append("            #end                " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("            AND D.FM_CONTI_CD  = L.CONTI_CD" ).append("\n"); 
		query.append("            AND NVL(L.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND R.REP_TRD_CD = C.TRD_CD" ).append("\n"); 
		query.append("            AND D.SUB_TRD_CD = C.SUB_TRD_CD" ).append("\n"); 
		query.append("            AND C.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("            AND SUBSTR(C.SLS_YRMON,1,4) = P.COST_YR" ).append("\n"); 
		query.append("            AND C.COST_WK = P.COST_WK" ).append("\n"); 
		query.append("            AND C.DIR_CD = D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            AND P.COST_YR||P.COST_WK BETWEEN @[curr_yrwk] AND @[to_yrwk]" ).append("\n"); 
		query.append("            AND V.SLAN_CD =  M.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND V.SLAN_CD = C.SLAN_CD" ).append("\n"); 
		query.append("            AND V.VSL_CD				=  C.VSL_CD" ).append("\n"); 
		query.append("            AND V.SKD_VOY_NO			=  C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND V.SKD_DIR_CD			=  C.DIR_CD" ).append("\n"); 
		query.append("            AND V.TURN_PORT_IND_CD		!= 'D'" ).append("\n"); 
		query.append("            AND V.TURN_PORT_IND_CD		!= 'V'" ).append("\n"); 
		query.append("            AND M.VSL_TP_CD			    =  'C'" ).append("\n"); 
		query.append("            AND L.LOC_CD                = V.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND V.VPS_PORT_CD           = T.LOC_CD" ).append("\n"); 
		query.append("			AND DECODE(SUBSTR(R.REP_TRD_CD,1,1),'I','X',T.CONTI_CD) <> 'A'" ).append("\n"); 
		query.append("            AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND DECODE(SUBSTR(R.REP_TRD_CD,1,1),'I',T.SCONTI_CD,'X') = DECODE(SUBSTR(R.REP_TRD_CD,1,1),'I',@[subconti],'X')" ).append("\n"); 
		query.append("		#if( ${level_cd} == '2' ) --LEVEL_CD 2 RHQ" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("            AND L.LOC_CD IN (SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                             WHERE NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                             CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                             START WITH OFC_CD = (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = [ofc_cd]))" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("			AND L.LOC_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("   				SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("   				WHERE SCC_CD IN " ).append("\n"); 
		query.append("				( " ).append("\n"); 
		query.append("   					SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("   					WHERE LCC_CD IN " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("                        -- HQ OFFICE 속한 LCC_CD 검색 (RCC 단위)" ).append("\n"); 
		query.append("            			SELECT LCC_CD" ).append("\n"); 
		query.append("            			FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("            			WHERE SCC_CD IN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("                			SELECT SCC_CD" ).append("\n"); 
		query.append("                			FROM MDM_LOCATION" ).append("\n"); 
		query.append("                			WHERE LOC_CD IN " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								 SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                 WHERE NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                 CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                 START WITH OFC_CD = (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("            			)" ).append("\n"); 
		query.append("    				)               " ).append("\n"); 
		query.append("    			)     " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#elseif( ${level_cd} == '5' ) --LEVEL_CD 5 ATLSC/PHXSC" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("            AND L.LOC_CD IN (SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                             WHERE NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                             CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                             START WITH OFC_CD = (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = [ofc_cd] AND OFC_CD IN ('ATLSC','PHXSC')))" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("			AND L.LOC_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("   				SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("   				WHERE SCC_CD IN " ).append("\n"); 
		query.append("				( " ).append("\n"); 
		query.append("   					SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("   					WHERE LCC_CD IN " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("                        -- HQ OFFICE 속한 LCC_CD 검색 (RCC 단위)" ).append("\n"); 
		query.append("            			SELECT LCC_CD" ).append("\n"); 
		query.append("            			FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("            			WHERE SCC_CD IN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("                			SELECT SCC_CD" ).append("\n"); 
		query.append("                			FROM MDM_LOCATION" ).append("\n"); 
		query.append("                			WHERE LOC_CD IN " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								 SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                 WHERE NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                 CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                 START WITH OFC_CD = (SELECT DISTINCT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] AND OFC_CD IN ('ATLSC','PHXSC'))" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("            			)" ).append("\n"); 
		query.append("    				)               " ).append("\n"); 
		query.append("    			)     " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#elseif( ${level_cd} == '6' ) --LEVEL_CD 6 Office" ).append("\n"); 
		query.append("            --AND L.LOC_CD IN (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE NVL(DELT_FLG,'N') <> 'Y' AND OFC_CD = [ofc_cd]) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND L.LOC_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("   				SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("   				WHERE SCC_CD IN " ).append("\n"); 
		query.append("				( " ).append("\n"); 
		query.append("   					SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("   					WHERE LCC_CD IN " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("                        -- OFFICE 속한 LCC_CD 검색 " ).append("\n"); 
		query.append("            			SELECT LCC_CD" ).append("\n"); 
		query.append("            			FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("            			WHERE SCC_CD IN (" ).append("\n"); 
		query.append("                							SELECT SCC_CD" ).append("\n"); 
		query.append("                							FROM MDM_LOCATION" ).append("\n"); 
		query.append("                							WHERE LOC_CD IN (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE NVL(DELT_FLG,'N') <> 'Y' AND OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("            							)" ).append("\n"); 
		query.append("    				)               " ).append("\n"); 
		query.append("    			)     " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("	    #elseif( ${level_cd} == '3' || ${level_cd} == '4' ) --LEVEL_CD 3,4 Office" ).append("\n"); 
		query.append("			AND 1=2 --조회안되야함" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            GROUP BY R.REP_TRD_CD, D.SUB_TRD_CD, R.RLANE_CD, D.VSL_SLAN_DIR_CD, D.FM_CONTI_CD, D.IOC_CD" ).append("\n"); 
		query.append("                     , P.COST_YR, P.COST_WK, P.SLS_FM_DT, P.SLS_TO_DT" ).append("\n"); 
		query.append("                     , V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.SLAN_CD, V.CLPT_SEQ, V.VPS_PORT_CD, V.YD_CD" ).append("\n"); 
		query.append("                     , DECODE(V.TURN_PORT_FLG,'Y',V.VPS_ETD_DT,'')" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		GROUP BY A.TRD_CD, A.SUB_TRD_CD, A.IOC_CD, A.RLANE_CD, A.COST_YRWK, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            SUBSTR(A.SLS_YRMON,0,4)||A.COST_WK COST_YRWK,   	" ).append("\n"); 
		query.append("            C.TRD_CD, " ).append("\n"); 
		query.append("            A.SUB_TRD_CD, " ).append("\n"); 
		query.append("            A.IOC_CD," ).append("\n"); 
		query.append("            A.SLAN_CD, " ).append("\n"); 
		query.append("            C.RLANE_CD, " ).append("\n"); 
		query.append("            DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') VSL_LANE_TP_CD, " ).append("\n"); 
		query.append("            C.VSL_CD, " ).append("\n"); 
		query.append("            C.SKD_VOY_NO,  " ).append("\n"); 
		query.append("            C.SKD_DIR_CD, " ).append("\n"); 
		query.append("            NVL(SUM(DECODE(D.CRR_CD,'HJS',DECODE(D.BSA_OP_JB_CD,'007',NVL(D.CRR_BSA_CAPA,NVL(C.N2ND_FNL_CO_BSA_CAPA,NVL(C.BSA_CAPA,0))),0))),0) FNL_HJS_BSA_CAPA_BSA," ).append("\n"); 
		query.append("            NVL(SUM(DECODE(D.CRR_CD,'HJS',DECODE(D.BSA_OP_JB_CD,'009',NVL(D.CRR_BSA_CAPA,NVL(C.N2ND_FNL_CO_BSA_CAPA,NVL(C.BSA_CAPA,0))),0))),0) FNL_HJS_BSA_CAPA_WT" ).append("\n"); 
		query.append("        FROM COA_MON_VVD A, COA_LANE_RGST B, BSA_VVD_MST C, BSA_VVD_OTR_CRR D, BSA_VVD_SWAP_INFO F " ).append("\n"); 
		query.append("        WHERE A.TRD_CD     = C.TRD_CD " ).append("\n"); 
		query.append("            AND A.RLANE_CD   = C.RLANE_CD " ).append("\n"); 
		query.append("            AND A.IOC_CD     = C.IOC_CD " ).append("\n"); 
		query.append("            AND A.VSL_CD     = C.VSL_CD " ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = C.SKD_VOY_NO " ).append("\n"); 
		query.append("            AND A.DIR_CD     = C.SKD_DIR_CD " ).append("\n"); 
		query.append("            AND A.TRD_CD     = B.TRD_CD " ).append("\n"); 
		query.append("            AND A.RLANE_CD   = B.RLANE_CD " ).append("\n"); 
		query.append("            AND A.DIR_CD     = B.DIR_CD " ).append("\n"); 
		query.append("            AND A.IOC_CD     = B.IOC_CD " ).append("\n"); 
		query.append("            AND C.TRD_CD     = D.TRD_CD(+) " ).append("\n"); 
		query.append("            AND C.RLANE_CD   = D.RLANE_CD(+) " ).append("\n"); 
		query.append("            AND C.VSL_CD     = D.VSL_CD(+) " ).append("\n"); 
		query.append("            AND C.SKD_VOY_NO = D.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("            AND C.SKD_DIR_CD = D.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("            AND D.TRD_CD     = F.TRD_CD(+) " ).append("\n"); 
		query.append("            AND D.RLANE_CD   = F.RLANE_CD(+) " ).append("\n"); 
		query.append("            AND D.VSL_CD     = F.VSL_CD(+) " ).append("\n"); 
		query.append("            AND D.SKD_VOY_NO = F.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("            AND D.SKD_DIR_CD = F.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("            AND D.BSA_OP_JB_CD= F.BSA_OP_JB_CD(+) " ).append("\n"); 
		query.append("            AND D.CRR_CD      = F.CRR_CD(+) " ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("            AND SUBSTR(A.SLS_YRMON,1,4)||A.COST_WK BETWEEN @[curr_yrwk] AND @[to_yrwk]" ).append("\n"); 
		query.append("    #if(${lane} != '')        -- Lane 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_lane})" ).append("\n"); 
		query.append("            #if($velocityCount > 1 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        D.RLANE_CD LIKE SUBSTR('$key',6,3)||'%'  -- LANE" ).append("\n"); 
		query.append("					AND A.SUB_TRD_CD = SUBSTR('$key',4,2)        -- SUB TRADE" ).append("\n"); 
		query.append("                    AND C.TRD_CD = SUBSTR('$key',1,3)        -- TRADE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif(${subtrade} != '') -- S.Trade 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_subtrade})" ).append("\n"); 
		query.append("            #if($velocityCount > 1 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("					A.SUB_TRD_CD = SUBSTR('$key',4,2)    -- SUB TRADE" ).append("\n"); 
		query.append("                    AND C.TRD_CD = SUBSTR('$key',1,3)    -- TRADE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif(${trade} != '')   -- Trade 콤보 조건 일 경우" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("              C.TRD_CD IN (" ).append("\n"); 
		query.append("        #foreach($key IN ${arr_trade})" ).append("\n"); 
		query.append("            #if($velocityCount == 1 )" ).append("\n"); 
		query.append("                                '$key'" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                               ,'$key'" ).append("\n"); 
		query.append("            #end                " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            GROUP BY A.SLS_YRMON, A.COST_WK, C.TRD_CD, A.SUB_TRD_CD, A.IOC_CD, A.SLAN_CD, C.RLANE_CD, DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC')" ).append("\n"); 
		query.append("                     , C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, NVL(C.N2ND_FNL_CO_BSA_CAPA,NVL(C.BSA_CAPA,0))" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.COST_YRWK = B.COST_YRWK" ).append("\n"); 
		query.append("        AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("        AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("        AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("        AND A.IOC_CD = B.IOC_CD" ).append("\n"); 
		query.append("        AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("BKG_DATA AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.RHQ, A.TRD_CD, A.SUB_TRD_CD," ).append("\n"); 
		query.append("        TO_NUMBER(" ).append("\n"); 
		query.append("        EQR_PORT_SIM_GET_BKG_VAL_FNC(" ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-3),1,4) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-3),5,2) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-1),1,4) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-1),5,2) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        A.RHQ," ).append("\n"); 
		query.append("        A.TRD_CD," ).append("\n"); 
		query.append("        A.SUB_TRD_CD," ).append("\n"); 
		query.append("        '',--A.RLANE_CD," ).append("\n"); 
		query.append("        '',--A.VSL_CD," ).append("\n"); 
		query.append("        '',--A.SKD_VOY_NO," ).append("\n"); 
		query.append("        '',--A.SKD_DIR_CD," ).append("\n"); 
		query.append("        '',--A.IOC_CD," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        '1'" ).append("\n"); 
		query.append("        )) BKG_QTY," ).append("\n"); 
		query.append("        TO_NUMBER(" ).append("\n"); 
		query.append("        EQR_PORT_SIM_GET_BKG_VAL_FNC(" ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-3),1,4) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-3),5,2) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-1),1,4) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        (SELECT SUBSTR(TO_CHAR(TO_NUMBER(MAX(W.PLN_YR||W.PLN_WK))-1),5,2) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)," ).append("\n"); 
		query.append("        A.RHQ," ).append("\n"); 
		query.append("        A.TRD_CD," ).append("\n"); 
		query.append("        A.SUB_TRD_CD," ).append("\n"); 
		query.append("        '',--A.RLANE_CD," ).append("\n"); 
		query.append("        '',--A.VSL_CD," ).append("\n"); 
		query.append("        '',--A.SKD_VOY_NO," ).append("\n"); 
		query.append("        '',--A.SKD_DIR_CD," ).append("\n"); 
		query.append("        '',--A.IOC_CD," ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("        '2'" ).append("\n"); 
		query.append("        )) BKG_WGT    " ).append("\n"); 
		query.append("    FROM BSA_GRID_O1 A" ).append("\n"); 
		query.append("    GROUP BY A.RHQ, A.TRD_CD, A.SUB_TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    C.SEQ" ).append("\n"); 
		query.append("    , CASE " ).append("\n"); 
		query.append("      WHEN C.SEQ=1 THEN 'BSA'" ).append("\n"); 
		query.append("      WHEN C.SEQ=2 THEN 'BKG'" ).append("\n"); 
		query.append("      WHEN C.SEQ=3 THEN 'AVAL'" ).append("\n"); 
		query.append("      WHEN C.SEQ=4 THEN 'PL'" ).append("\n"); 
		query.append("      WHEN C.SEQ=5 THEN 'TTL'" ).append("\n"); 
		query.append("      END CODE" ).append("\n"); 
		query.append("    , CASE " ).append("\n"); 
		query.append("      WHEN C.SEQ=1 THEN 'BSA'" ).append("\n"); 
		query.append("      WHEN C.SEQ=2 THEN 'Full Export'" ).append("\n"); 
		query.append("      WHEN C.SEQ=3 THEN 'Space Available for MT'" ).append("\n"); 
		query.append("      WHEN C.SEQ=4 THEN 'MT Plan'" ).append("\n"); 
		query.append("      WHEN C.SEQ=5 THEN 'TTL'" ).append("\n"); 
		query.append("      END NAME" ).append("\n"); 
		query.append("#foreach($key in ${arrweek2})" ).append("\n"); 
		query.append("    , ROUND(MAX(C.QTY_$key)) QTY_$key, CEIL(MAX(C.LF_$key)) LF_$key, ROUND(MAX(C.WGT_$key)) WGT_$key, CEIL(MAX(C.WGTLF_$key)) WGTLF_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    A.SEQ" ).append("\n"); 
		query.append("#foreach($key in ${arrweek2})" ).append("\n"); 
		query.append("    , CASE WHEN A.COST_YRWK='$key' THEN MAX(A.QTY)      ELSE TO_NUMBER('') END QTY_$key" ).append("\n"); 
		query.append("    , CASE WHEN A.COST_YRWK='$key' THEN MAX(A.LF)       ELSE TO_NUMBER('') END LF_$key" ).append("\n"); 
		query.append("    , CASE WHEN A.COST_YRWK='$key' THEN MAX(A.WGT)      ELSE TO_NUMBER('') END WGT_$key" ).append("\n"); 
		query.append("    , CASE WHEN A.COST_YRWK='$key' THEN MAX(A.WGTLF)    ELSE TO_NUMBER('') END WGTLF_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    L.SEQ, Y.COST_YRWK," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    WHEN L.SEQ = 1 THEN MAX(Y.BSA_QTY) " ).append("\n"); 
		query.append("    WHEN L.SEQ = 2 THEN MAX(Y.BKG_QTY)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 3 THEN MAX(Y.AVAL_QTY)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 4 THEN TO_NUMBER('')" ).append("\n"); 
		query.append("    WHEN L.SEQ = 5 THEN MAX(Y.TTL_QTY)" ).append("\n"); 
		query.append("    ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("    END QTY," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    WHEN L.SEQ = 1 THEN MAX(Y.BSA_LF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 2 THEN MAX(Y.BKG_LF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 3 THEN MAX(Y.AVAL_LF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 4 THEN TO_NUMBER('')" ).append("\n"); 
		query.append("    WHEN L.SEQ = 5 THEN MAX(Y.TTL_LF)" ).append("\n"); 
		query.append("    ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("    END LF," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    WHEN L.SEQ = 1 THEN MAX(Y.BSA_WGT)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 2 THEN MAX(Y.BKG_WGT)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 3 THEN MAX(Y.AVAL_WGT)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 4 THEN TO_NUMBER('')" ).append("\n"); 
		query.append("    WHEN L.SEQ = 5 THEN MAX(Y.TTL_WGT)" ).append("\n"); 
		query.append("    ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("    END WGT," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    WHEN L.SEQ = 1 THEN MAX(Y.BSA_WGTLF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 2 THEN MAX(Y.BKG_WGTLF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 3 THEN MAX(Y.AVAL_WGTLF)" ).append("\n"); 
		query.append("    WHEN L.SEQ = 4 THEN TO_NUMBER('')" ).append("\n"); 
		query.append("    WHEN L.SEQ = 5 THEN MAX(Y.TTL_WGTLF)" ).append("\n"); 
		query.append("    ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("    END WGTLF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    X.COST_YRWK" ).append("\n"); 
		query.append("    /** TEU **/" ).append("\n"); 
		query.append("    , NVL(SUM(X.BSA),0) BSA_QTY" ).append("\n"); 
		query.append("    , NVL(MAX(X.BKG_QTY),0) BKG_QTY --1107" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA),0)<>0 THEN NVL(SUM(X.BSA),0) - NVL(MAX(X.BKG_QTY),0) ELSE TO_NUMBER('') END AVAL_QTY" ).append("\n"); 
		query.append("    , NVL(SUM(X.BKG_QTY),0) TTL_QTY" ).append("\n"); 
		query.append("    /** LF **/" ).append("\n"); 
		query.append("    , TO_NUMBER('') BSA_LF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA),0)<>0 THEN ROUND(NVL(MAX(X.BKG_QTY),0)/NVL(SUM(X.BSA),0) * 100,2) ELSE TO_NUMBER('') END BKG_LF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA),0)<>0 THEN ROUND((NVL(SUM(X.BSA),0) - NVL(MAX(X.BKG_QTY),0))/NVL(SUM(X.BSA),0) * 100,2) ELSE TO_NUMBER('') END AVAL_LF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA),0)<>0 THEN ROUND(NVL(MAX(X.BKG_QTY),0)/NVL(SUM(X.BSA),0) * 100,2) ELSE TO_NUMBER('') END TTL_LF" ).append("\n"); 
		query.append("    /** WGT **/" ).append("\n"); 
		query.append("    , NVL(SUM(X.BSA_WGT),0) BSA_WGT " ).append("\n"); 
		query.append("    , NVL(MAX(X.BKG_WGT),0) BKG_WGT --1107" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA_WGT),0)<>0 THEN (NVL(SUM(X.BSA_WGT),0) - NVL(MAX(X.BKG_WGT),0)) ELSE TO_NUMBER('') END AVAL_WGT" ).append("\n"); 
		query.append("    , NVL(SUM(X.BSA_WGT),0) TTL_WGT" ).append("\n"); 
		query.append("    /** WGT LF **/" ).append("\n"); 
		query.append("    , TO_NUMBER('') BSA_WGTLF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA_WGT),0)<>0 THEN ROUND(NVL(MAX(X.BKG_WGT),0)/NVL(SUM(X.BSA_WGT),0) * 100,2) ELSE TO_NUMBER('') END BKG_WGTLF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA_WGT),0)<>0 THEN ROUND(((NVL(SUM(X.BSA_WGT),0) - NVL(MAX(X.BKG_WGT),0)))/NVL(SUM(X.BSA_WGT),0) * 100,2) ELSE TO_NUMBER('') END AVAL_WGTLF" ).append("\n"); 
		query.append("    , CASE WHEN NVL(SUM(X.BSA_WGT),0)<>0 THEN ROUND(NVL(MAX(X.BKG_WGT),0)/NVL(SUM(X.BSA_WGT),0) * 100,2) + ROUND(((NVL(SUM(X.BSA),0) - NVL(MAX(X.BKG_QTY),0)))/NVL(SUM(X.BSA_WGT),0) * 100,2) ELSE TO_NUMBER('') END TTL_WGTLF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD, A.COST_YRWK, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("        , SUM(NVL(A.BSA,0)) BSA, SUM(NVL(A.BSA_WGT,0)) BSA_WGT" ).append("\n"); 
		query.append("		, SUM(NVL(B.BKG_QTY,0)) BKG_QTY" ).append("\n"); 
		query.append("		, SUM(NVL(B.BKG_WGT,0)) BKG_WGT" ).append("\n"); 
		query.append("    FROM BSA_GRID_O1 A, BKG_DATA B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.TRD_CD = B.TRD_CD(+)" ).append("\n"); 
		query.append("        AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("        GROUP BY A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD, A.COST_YRWK, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.RHQ" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.COST_YRWK" ).append("\n"); 
		query.append(") Y, (SELECT LEVEL SEQ FROM DUAL CONNECT BY LEVEL <= 5) L" ).append("\n"); 
		query.append("GROUP BY Y.COST_YRWK, L.SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.SEQ, A.COST_YRWK" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY C.SEQ" ).append("\n"); 
		query.append("ORDER BY C.SEQ" ).append("\n"); 

	}
}