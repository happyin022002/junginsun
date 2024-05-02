/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.10.16 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC Allocation HO 화면에서 aloc 물량 변경 시 Standby bkg 물량 가져오기
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL").append("\n"); 
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
		query.append("PARAMS AS (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		 @[asgn_ttl_qty] AS ASGN_TTL_QTY" ).append("\n"); 
		query.append("		,@[usd_bkg_ttl_qty] AS USD_BKG_TTL_QTY" ).append("\n"); 
		query.append("		,@[bs_teu] AS BS_TEU" ).append("\n"); 
		query.append("		,@[asgn_ttl_wgt] AS ASGN_TTL_WGT" ).append("\n"); 
		query.append("		,@[usd_bkg_ttl_wgt] AS USD_BKG_TTL_WGT" ).append("\n"); 
		query.append("		,@[bs_wgt] AS BS_WGT" ).append("\n"); 
		query.append("	FROM DUAL	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",BKG_LIST AS (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("        AA.BKG_NO" ).append("\n"); 
		query.append("        ,AA.ALOC_STS_CD" ).append("\n"); 
		query.append("        ,AA.FEU*2 + AA.TEU TEU" ).append("\n"); 
		query.append("		 ,AA.WGT" ).append("\n"); 
		query.append("        ,AA.CRE_DT" ).append("\n"); 
		query.append("        ,CUST_CTRL_CD" ).append("\n"); 
		query.append("    FROM (       " ).append("\n"); 
		query.append("			 SELECT  " ).append("\n"); 
		query.append("					  A.BKG_NO" ).append("\n"); 
		query.append("					 ,A.BKG_STS_CD" ).append("\n"); 
		query.append("					 ,A.ALOC_SVC_CD" ).append("\n"); 
		query.append("					 ,A.ALOC_STS_CD" ).append("\n"); 
		query.append("					 ,A.CFM_RQST_FLG" ).append("\n"); 
		query.append("					 ,A.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("					 ,A.CFM_USR_ID" ).append("\n"); 
		query.append("					 ,A.CFM_DT" ).append("\n"); 
		query.append("					 ,A.FEU" ).append("\n"); 
		query.append("					 ,A.TEU" ).append("\n"); 
		query.append("					 ,A.WGT" ).append("\n"); 
		query.append("					 ,A.SEASON" ).append("\n"); 
		query.append("--					 ,AGMT_CNT_CD" ).append("\n"); 
		query.append("--					 ,AGMT_CUST_SEQ" ).append("\n"); 
		query.append("					 ,A.SC_NO" ).append("\n"); 
		query.append("					 ,A.RFA_NO" ).append("\n"); 
		query.append("                     ,A.CRE_DT" ).append("\n"); 
		query.append("                     ,MCC.CUST_CTRL_CD" ).append("\n"); 
		query.append("			 FROM (" ).append("\n"); 
		query.append("				SELECT  " ).append("\n"); 
		query.append("					  A.BKG_NO" ).append("\n"); 
		query.append("					 ,A.BKG_STS_CD" ).append("\n"); 
		query.append("					 ,A.ALOC_SVC_CD" ).append("\n"); 
		query.append("					 ,A.ALOC_STS_CD" ).append("\n"); 
		query.append("					 ,A.CFM_RQST_FLG" ).append("\n"); 
		query.append("					 ,A.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("					 ,A.CFM_USR_ID" ).append("\n"); 
		query.append("					 ,A.CFM_DT" ).append("\n"); 
		query.append("					 ,A.FEU" ).append("\n"); 
		query.append("					 ,A.TEU" ).append("\n"); 
		query.append("					 ,A.WGT" ).append("\n"); 
		query.append("					 ,A.SEASON" ).append("\n"); 
		query.append("					 ,A.SC_NO" ).append("\n"); 
		query.append("					 ,A.RFA_NO" ).append("\n"); 
		query.append("                     ,A.CRE_DT" ).append("\n"); 
		query.append("                     ,A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                     ,A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                     ,A.TRD_CD" ).append("\n"); 
		query.append("				FROM(" ).append("\n"); 
		query.append("				  SELECT" ).append("\n"); 
		query.append("						BK.BKG_NO" ).append("\n"); 
		query.append("						, BK.BKG_STS_CD" ).append("\n"); 
		query.append("						, SSB.CFM_USR_ID" ).append("\n"); 
		query.append("						, SSB.CFM_DT" ).append("\n"); 
		query.append("						, BK.ALOC_SVC_CD" ).append("\n"); 
		query.append("						, BK.ALOC_STS_CD" ).append("\n"); 
		query.append("						, BK.BL_NO" ).append("\n"); 
		query.append("--						, BK.SLS_RHQ_CD" ).append("\n"); 
		query.append("						, BK.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("						, COA.TRD_CD" ).append("\n"); 
		query.append("--						, COA.SUB_TRD_CD" ).append("\n"); 
		query.append("						, (" ).append("\n"); 
		query.append("								SELECT /*+INDEX_DESC (MST XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("										 DECODE( DECODE( HH.TRD_CD, NULL, 'N','Y'), 'Y', COST_YRWK||'-'||VER_SEQ, '200001-1')" ).append("\n"); 
		query.append("								  FROM SPC_MDL_VER_MST MST" ).append("\n"); 
		query.append("								 WHERE SUBSTR(COA.COST_YRMON,1,4)||COA.COST_WK BETWEEN MST.VER_ST_YRWK AND MST.VER_END_YRWK" ).append("\n"); 
		query.append("									AND MST.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("									AND MST.TRD_CD  = COA.TRD_CD" ).append("\n"); 
		query.append("									AND ROWNUM    = 1" ).append("\n"); 
		query.append("						) AS SEASON" ).append("\n"); 
		query.append("						, BK.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("						, BK.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("--						, BK.SLAN_CD               TRNK_SLAN_CD" ).append("\n"); 
		query.append("--						, BK.SKD_DIR_CD            TRNK_DIR_CD" ).append("\n"); 
		query.append("--						, BK.POL_CD                TRNK_POL" ).append("\n"); 
		query.append("--						, BK.POD_CD                TRNK_POD" ).append("\n"); 
		query.append("--						, BK.POR_CD                POR_LOC_CD" ).append("\n"); 
		query.append("--						, BK.POR_NOD_CD            POR_NOD_CD" ).append("\n"); 
		query.append("--						, (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD" ).append("\n"); 
		query.append("--						, BK.POL_CD                POL_LOC_CD" ).append("\n"); 
		query.append("--						, BK.POL_NOD_CD            POL_NOD_CD" ).append("\n"); 
		query.append("--						, NVL((SELECT VSL_SLAN_CD FROM VSK_VSL_SKD SKD WHERE SKD.VSL_CD = VVD.VSL_CD AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD), 'X') TS_SLAN_CD" ).append("\n"); 
		query.append("--						, NVL(VVD.SKD_DIR_CD, 'X') TS_DIR_CD" ).append("\n"); 
		query.append("--						, NVL(VVD.POL_CD,     'X') TS_POL_CD" ).append("\n"); 
		query.append("--						, NVL(VVD.POD_CD,     'X') TS_POD_CD" ).append("\n"); 
		query.append("--						, BK.POD_CD                POD_LOC_CD" ).append("\n"); 
		query.append("--						, BK.POD_NOD_CD            POD_NOD_CD" ).append("\n"); 
		query.append("--						, BK.DEL_CD                DEL_LOC_CD" ).append("\n"); 
		query.append("--						, BK.DEL_NOD_CD            DEL_NOD_CD" ).append("\n"); 
		query.append("--						, (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD" ).append("\n"); 
		query.append("--						, BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("--						, BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("						,DECODE(COA.IOC_CD, 'T', DECODE(OFC.N2ND_PRNT_OFC_CD, 'SINRS', OFC.N4TH_PRNT_OFC_CD, BK.SLS_RHQ_CD, OFC.N4TH_PRNT_OFC_CD, " ).append("\n"); 
		query.append("                            DECODE(COA.RLANE_CD, 'WAFIE', OFC.N4TH_PRNT_OFC_CD, OFC.N2ND_PRNT_OFC_CD)), OFC.N4TH_PRNT_OFC_CD) OB_SLS_OFC_CD" ).append("\n"); 
		query.append("						, DECODE(BK.DCGO_FLG,'Y','DG', DECODE(BK.RD_CGO_FLG, 'Y', 'RD',''), '') DGRD" ).append("\n"); 
		query.append("						, BK.SC_NO" ).append("\n"); 
		query.append("						, BK.RFA_NO" ).append("\n"); 
		query.append("--						, BK.CTRT_CUST_CNT_CD || NVL(LPAD(BK.CTRT_CUST_SEQ,6,'0'),'')     C_CUST" ).append("\n"); 
		query.append("--						, BK.AGMT_ACT_CNT_CD  || NVL(LPAD(BK.AGMT_ACT_CUST_SEQ,6,'0'),'') A_CUST" ).append("\n"); 
		query.append("--						, SHPR.CUST_CNT_CD    || NVL(LPAD(SHPR.CUST_SEQ,6,'0'),'')        SHRP" ).append("\n"); 
		query.append("--						, CNEE.CUST_CNT_CD    || NVL(LPAD(CNEE.CUST_SEQ,6,'0'),'')        CNEE" ).append("\n"); 
		query.append("--						, FWDR.CUST_CNT_CD    || NVL(LPAD(FWDR.CUST_SEQ,6,'0'),'')        FWDR" ).append("\n"); 
		query.append("--						, BK.CMDT_CD" ).append("\n"); 
		query.append("--						,(SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE BK.CMDT_CD = CMDT.CMDT_CD) CMDT_DESC" ).append("\n"); 
		query.append("--						, QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("						,( SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0) ) FROM BKG_QUANTITY" ).append("\n"); 
		query.append("							 WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("						)AS TEU" ).append("\n"); 
		query.append("						, (" ).append("\n"); 
		query.append("							 SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY) ) FROM BKG_QUANTITY" ).append("\n"); 
		query.append("							 WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("						 ) AS FEU" ).append("\n"); 
		query.append("                 , ( SELECT (BD.ACT_WGT * DECODE(BD.WGT_UT_CD, 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                              + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                      FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                      WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001" ).append("\n"); 
		query.append("                      FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                      WHERE BK.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                        AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                  ) AS WGT" ).append("\n"); 
		query.append("		--          , ROUND(DECODE(BL.WGT_UT_CD, 'KGS', BL.ACT_WGT, BL.ACT_WGT * 0.45) / 1000) TON --아래 BL 관련 주석 같이 풀어야함" ).append("\n"); 
		query.append("						, SSB.CFM_RQST_FLG" ).append("\n"); 
		query.append("						, SSB.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("						,@[sls_ofc_cd] as ofc" ).append("\n"); 
		query.append("						,@[ctrl_lvl_cd]      as lvl" ).append("\n"); 
		query.append("		-- 20150502 김성욱, CONTRACT 관련" ).append("\n"); 
		query.append("--						, D.AGMT_CNT_CD" ).append("\n"); 
		query.append("--						, D.AGMT_CUST_SEQ" ).append("\n"); 
		query.append("						,BK.CRE_DT" ).append("\n"); 
		query.append("				  FROM MAS_MON_VVD COA" ).append("\n"); 
		query.append("						, BKG_BOOKING BK" ).append("\n"); 
		query.append("						, BKG_BL_DOC BD" ).append("\n"); 
		query.append("						, BKG_VVD VVD" ).append("\n"); 
		query.append("						, BKG_QUANTITY QTY" ).append("\n"); 
		query.append("						, BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("						, BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("						, BKG_CUSTOMER FWDR" ).append("\n"); 
		query.append("				  --  , BKG_BL_DOC BL --BL관련 주석" ).append("\n"); 
		query.append("						, SPC_SB_BKG SSB" ).append("\n"); 
		query.append("                        , SPC_SB_BKG_DTL DTL" ).append("\n"); 
		query.append("						,(" ).append("\n"); 
		query.append("						  SELECT L.CONTI_CD AS OFC_CONTI" ).append("\n"); 
		query.append("							 FROM MDM_LOCATION     L" ).append("\n"); 
		query.append("								  ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("							WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("								AND O.OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("						  ) CONTI" ).append("\n"); 
		query.append("						 ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("						 ,SPC_OFC_LVL OFC" ).append("\n"); 
		query.append("						 , SPC_HD_HUL_MST HH" ).append("\n"); 
		query.append("		-- 20150502 김성욱, CONTRACT 관련" ).append("\n"); 
		query.append("--						 ,MAS_BKG_EXPN_DTL_WK D" ).append("\n"); 
		query.append("						 ,MDM_COMMODITY    K" ).append("\n"); 
		query.append("						 , (SELECT REP_CMDT_CD AS REP_CMDT_CD" ).append("\n"); 
		query.append("														, REP_CMDT_NM AS REP_CMDT_DESC" ).append("\n"); 
		query.append("													FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("												  WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("												) F" ).append("\n"); 
		query.append("				  WHERE 1=1" ).append("\n"); 
		query.append("						AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("                        AND IOC_CD = 'O' --Trunk만 보는거라 O 만 검색, 아래 두줄을 이용해서 처리." ).append("\n"); 
		query.append("                        AND COA.TRD_CD     = SPC_GET_REP_TRD_FNC(COA.RLANE_CD)" ).append("\n"); 
		query.append("                        AND COA.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(COA.RLANE_CD)" ).append("\n"); 
		query.append("		-- 20150502 김성욱, CONTRACT 관련" ).append("\n"); 
		query.append("--						AND D.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("--						AND SPC_SCR_OFC_CONV_FNC(D.SLS_OFC_CD) = OFC.OFC_CD" ).append("\n"); 
		query.append("--						AND D.CMDT_CD              = K.CMDT_CD(+)" ).append("\n"); 
		query.append("--						AND D.REP_CMDT_CD          = F.REP_CMDT_CD" ).append("\n"); 
		query.append("--						AND NVL(D.DELT_FLG,'N')    = 'N'" ).append("\n"); 
		query.append("--						AND D.BL_NO_TP             IN ('M','0')" ).append("\n"); 
		query.append("--						AND D.BKG_STS_CD           IN ('F','S','W')" ).append("\n"); 
		query.append("--						AND NVL(D.BKG_CGO_TP_CD,'*') <> 'P'" ).append("\n"); 
		query.append("--						AND @ [rlane_cd] IN (D.RLANE_CD, D.N1ST_RLANE_CD, D.N2ND_RLANE_CD, N3RD_RLANE_CD, N4TH_RLANE_CD)" ).append("\n"); 
		query.append("						AND COA.VSL_CD     = BK.VSL_CD" ).append("\n"); 
		query.append("						AND COA.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND COA.DIR_CD     = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND BK.BKG_NO      = VVD.BKG_NO" ).append("\n"); 
		query.append("						AND BK.BKG_NO      = QTY.BKG_NO" ).append("\n"); 
		query.append("						AND BK.BKG_NO      = CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("						AND BK.BKG_NO      = SHPR.BKG_NO" ).append("\n"); 
		query.append("						AND 'S'            = SHPR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("						AND 'C'            = CNEE.BKG_CUST_TP_CD(+) -- S: SHIPPER[물품을 보내는자(송하인)], C:CONSIGNEE[물건을 받는자(수하인)], F:FORWARDER[운송취급인.운송주선인 이라고 하며, 화물을 인수하여 수하인에게 인도할 때까지 일체의 업무를 주선하는 사람]" ).append("\n"); 
		query.append("						AND BK.BKG_NO      = FWDR.BKG_NO(+)" ).append("\n"); 
		query.append("						AND 'F'            = FWDR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("						AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("				  --  AND BK.BKG_NO      = BL.BKG_NO --BL관련 주석" ).append("\n"); 
		query.append("						AND BK.BKG_STS_CD  IN ('F','W') --Default 로 W 값만 가져오게 되어 있음." ).append("\n"); 
		query.append("						AND SSB.BKG_NO(+)  = BK.BKG_NO" ).append("\n"); 
		query.append("						AND COA.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                        AND DTL.LST_SB_RSN_TP_CD  = 'A'" ).append("\n"); 
		query.append("                        AND DTL.BKG_CTRL_TP_CD    = 'S'" ).append("\n"); 
		query.append("                        AND NVL(DTL.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND OFC.OFC_CD      = (SELECT SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("						AND OFC.OFC_TP_CD   IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} == ${org_ofc})" ).append("\n"); 
		query.append("#if (${sls_ofc_cd}!='null'&&${sls_ofc_cd}!='')" ).append("\n"); 
		query.append("            AND OFC.OFC_CD      = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND SUBSTR(COA.SLS_YRMON,1,4)||COA.COST_WK BETWEEN OFC.OFC_APLY_FM_YRWK AND OFC.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("						AND BK.POL_CD      = LOC.LOC_CD" ).append("\n"); 
		query.append("						AND HH.TRD_CD(+) = COA.TRD_CD" ).append("\n"); 
		query.append("						AND HH.RLANE_CD(+) = COA.RLANE_CD" ).append("\n"); 
		query.append("						AND HH.DIR_CD(+) = COA.DIR_CD" ).append("\n"); 
		query.append("#if ( ${sls_ofc_cd} == 'SINRS' || ${sls_ofc_cd} == 'SHARC' || ${sls_ofc_cd} == '' || ${sls_ofc_cd} == 'null')" ).append("\n"); 
		query.append("            -- HO BASE_RHQ_CD(SINRS,SHARC)" ).append("\n"); 
		query.append("            AND (    CONTI.OFC_CONTI = (SELECT SPC_CONTI_CONV_FNC(LOC.CONTI_CD, COA.RLANE_CD, COA.DIR_CD) FROM DUAL)" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = DECODE(@[sls_ofc_cd],'SHARC','SHARC','SINRS','SINRS', 'SHARC') " ).append("\n"); 
		query.append("#if (${sls_ofc_cd} == '' || ${sls_ofc_cd} == 'null')" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  OR (OFC.N2ND_PRNT_OFC_CD = 'SINRS' AND COA.RLANE_CD = 'WAXIA'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  OR COA.RLANE_CD         = 'WAFIE' )   " ).append("\n"); 
		query.append("#elseif ( ${sls_ofc_cd} == 'NYCRA' || ${sls_ofc_cd} == 'HAMRU')" ).append("\n"); 
		query.append("            --RHQ BASE_RHQ_CD(NYCRA,HAMRU)" ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("            AND (    CONTI.OFC_CONTI = (SELECT SPC_CONTI_CONV_FNC(LOC.CONTI_CD, COA.RLANE_CD, COA.DIR_CD) FROM DUAL)" ).append("\n"); 
		query.append("                  OR OFC.N2ND_PRNT_OFC_CD = DECODE(@[sls_ofc_cd], 'NYCRA', 'NYCRA', 'HAMRU', 'HAMRU', '')  --RHQ BASE_RHQ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND (OFC.N4TH_PRNT_OFC_CD = NVL(@[sls_ofc_cd],@[sls_ofc_cd]) OR OFC.N5TH_PRNT_OFC_CD = NVL(@[sls_ofc_cd],@[sls_ofc_cd]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						AND COA.VSL_CD     = @[vsl_cd] --SUBSTR(@ [vsl_cd],1,4)--'COGN0009W'" ).append("\n"); 
		query.append("						AND COA.SKD_VOY_NO = @[skd_voy_no] --SUBSTR(@ [f_vvd_cd],5,4)" ).append("\n"); 
		query.append("						AND COA.DIR_CD     = @[skd_dir_cd] --SUBSTR(@ [f_vvd_cd],-1)" ).append("\n"); 
		query.append("						AND BK.ALOC_STS_CD   IN ( 'S' , 'A' )" ).append("\n"); 
		query.append("						AND COA.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("						AND COA.SUB_TRD_CD   = @[sub_trd_cd]" ).append("\n"); 
		query.append("						AND COA.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("						AND COA.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("		#if (${pol_cd} != '' && ${pol_cd} != '1' && ${pol_cd} != '0000000')" ).append("\n"); 
		query.append("						AND VVD.POL_YD_CD     = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd} != '' && ${pod_cd} != '1' && ${pod_cd} != '0000000')" ).append("\n"); 
		query.append("						AND VVD.POD_YD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("--		# if ($ {us_mod} != '' && $ {us_mod} != '1' && $ {us_mod} != 'OTHERS' && $ {us_mod} != '0' && $ {us_mod} != '00000' )" ).append("\n"); 
		query.append("--					AND CASE WHEN (SUBSTR(D.BKg_POL_CD,1,2) IN ('US','CA') OR SUBSTR(D.BKg_POD_CD,1,2) IN ('US','CA')) THEN" ).append("\n"); 
		query.append("--								  NVL(SPC_USA_MODE_FNC(D.bkg_RCV_TERM_CD, D.bkg_DE_TERM_CD, D.BKg_POL_CD, D.BKg_POL_CD, D.BKg_POD_CD, D.BKG_DEL_CD),'OTHERS') " ).append("\n"); 
		query.append("--								  ELSE" ).append("\n"); 
		query.append("--								  'OTHERS'" ).append("\n"); 
		query.append("--							 END =  @ [us_mod]" ).append("\n"); 
		query.append("--		# end" ).append("\n"); 
		query.append("--# if ($ {sls_ofc_cd} != '' && $ {sls_ofc_cd} != 'null')" ).append("\n"); 
		query.append("--			AND SPC_SCR_OFC_CONV_FNC( OB_SLS_OFC_CD ) = @ [sls_ofc_cd]" ).append("\n"); 
		query.append("--# end" ).append("\n"); 
		query.append("             )A" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO ,A.BKG_STS_CD ,A.ALOC_SVC_CD ,A.ALOC_STS_CD ,A.CFM_RQST_FLG ,A.CNDDT_CFM_FLG ,A.CFM_USR_ID ,A.CFM_DT ,A.FEU ,A.TEU ,A.WGT ,A.SEASON " ).append("\n"); 
		query.append("         ,A.SC_NO ,A.RFA_NO ,A.CRE_DT ,A.CTRT_CUST_SEQ,A.CTRT_CUST_CNT_CD ,A.TRD_CD" ).append("\n"); 
		query.append("  	    )A, SPC_MDL_CUST_CTRL MCC" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("                        AND MCC.TRD_CD(+) = A.TRD_CD" ).append("\n"); 
		query.append("    --                  AND MCC.SUB_TRD_CD(+) = A.SUB_TRD_CD" ).append("\n"); 
		query.append("                        AND MCC.COST_YRWK(+) = SUBSTR(A.SEASON,1,6)" ).append("\n"); 
		query.append("                        AND MCC.VER_SEQ(+) = SUBSTR(A.SEASON,8)" ).append("\n"); 
		query.append("                        AND MCC.CUST_CNT_CD(+) = A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                        AND MCC.CUST_SEQ(+) = A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("#if (${cust_ctrl_cd} != '' && ${cust_ctrl_cd} != 'C' && ${cust_ctrl_cd} != '1')" ).append("\n"); 
		query.append("            AND MCC.CUST_CTRL_CD = @[cust_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_ctrl_cd} != '' && ${cust_ctrl_cd} != 'C' && ${cust_ctrl_cd} != '1')" ).append("\n"); 
		query.append("						AND 1=1" ).append("\n"); 
		query.append("--						AND (A.AGMT_CNT_CD, A.AGMT_CUST_SEQ, NVL(A.SC_NO, 'X'), DECODE(SUBSTR(A.RFA_NO,1,1),'1',NVL(SUBSTR(A.RFA_NO,2), 'X'),NVL(A.RFA_NO, 'X'))) IN" ).append("\n"); 
		query.append("--																			  (SELECT DECODE(SUBSTR(A.RFA_NO,1,1),'1',A.AGMT_CNT_CD, C.CUST_CNT_CD)," ).append("\n"); 
		query.append("--																						 DECODE(SUBSTR(A.RFA_NO,1,1),'1',A.AGMT_CUST_SEQ ,C.CUST_SEQ)," ).append("\n"); 
		query.append("--																						 NVL(A.SC_NO, 'X')," ).append("\n"); 
		query.append("--																						 NVL(A.RFA_NO, 'X')" ).append("\n"); 
		query.append("--																				  FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("--																				 WHERE C.COST_YRWK = SUBSTR(A.SEASON,1,6)" ).append("\n"); 
		query.append("--																					AND C.VER_SEQ   = SUBSTR(A.SEASON,8)" ).append("\n"); 
		query.append("--																					AND C.CUST_CTRL_CD = @ [cust_ctrl_cd]" ).append("\n"); 
		query.append("--																					AND C.TRD_CD       = @ [trd_cd]" ).append("\n"); 
		query.append("--																				)" ).append("\n"); 
		query.append("#elseif (${cust_ctrl_cd} == 'C' )" ).append("\n"); 
		query.append("			AND NVL(A.SC_NO, NVL(A.RFA_NO, 'X')) = NVL(MCC.SC_NO(+), NVL(MCC.RFA_NO(+), 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--20150606 " ).append("\n"); 
		query.append("#if (${org_ofc} != '' && ${org_ofc} != 'null')" ).append("\n"); 
		query.append("			AND SPC_SCR_OFC_CONV_FNC( OB_SLS_OFC_CD ) = @[org_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		ORDER BY BKG_NO" ).append("\n"); 
		query.append("		) AA" ).append("\n"); 
		query.append("#if (${cust_ctrl_cd} == 'C')" ).append("\n"); 
		query.append("           WHERE NVL(CUST_CTRL_CD,'C') = @[cust_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMPB_BKG AS (" ).append("\n"); 
		query.append("    SELECT BKG_NO " ).append("\n"); 
		query.append("        , BKG_TEU_QTY" ).append("\n"); 
		query.append("		  , WGT" ).append("\n"); 
		query.append("        , SUM(SUM(BKG_TEU_QTY)) OVER(ORDER BY RN ASC ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) CUML" ).append("\n"); 
		query.append("		  , SUM(SUM(WGT)) OVER(ORDER BY RN ASC ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) CUML_WGT" ).append("\n"); 
		query.append("        , RN" ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("        SELECT B.BKG_NO, REV.BKG_TEU_QTY, B.WGT, REV.CMPB_AMT , B.CRE_DT, RANK() OVER( ORDER BY TO_NUMBER(CMPB_AMT) DESC , B.CRE_DT ) RN" ).append("\n"); 
		query.append("        FROM BKG_LIST B, BKG_REV_COST REV" ).append("\n"); 
		query.append("        WHERE REV.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("          AND REV.REV_COST_SEQ = NVL( (SELECT MAX(REV_COST_SEQ) FROM BKG_REV_COST WHERE BKG_NO(+) = B.BKG_NO) , 1)" ).append("\n"); 
		query.append("        ORDER BY REV.CMPB_AMT DESC" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BKG_NO, BKG_TEU_QTY, WGT, RN" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO, BKG_TEU_QTY, WGT, CUML,CUML_WGT, RN" ).append("\n"); 
		query.append("FROM CMPB_BKG" ).append("\n"); 
		query.append("WHERE RN <= (" ).append("\n"); 
		query.append("    SELECT MAX(RN)" ).append("\n"); 
		query.append("    FROM CMPB_BKG, PARAMS P" ).append("\n"); 
		query.append("    WHERE CAST( CUML AS INT ) <= (TO_NUMBER(P.ASGN_TTL_QTY) - ( TO_NUMBER(P.USD_BKG_TTL_QTY) - TO_NUMBER(P.BS_TEU) ))" ).append("\n"); 
		query.append("#if ( ${ctrl_wt} == 'Y' )" ).append("\n"); 
		query.append("		AND CAST( CUML_WGT AS INT ) <= (TO_NUMBER(P.ASGN_TTL_WGT) - ( TO_NUMBER(P.USD_BKG_TTL_WGT) - TO_NUMBER(P.BS_WGT) ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}