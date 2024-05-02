/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InitialSpaceAllocationRatioDBDAOSearchBKGListForCompFirmBySPCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.05.12 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InitialSpaceAllocationRatioDBDAOSearchBKGListForCompFirmBySPCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.02.11 Kim Soung Wook.
	  * Compulsory Firm COPY , 0116화면 조회 QUERY
	  * </pre>
	  */
	public InitialSpaceAllocationRatioDBDAOSearchBKGListForCompFirmBySPCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_level",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_sb_rsn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aloc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : InitialSpaceAllocationRatioDBDAOSearchBKGListForCompFirmBySPCRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("      ,BKG_STS_CD" ).append("\n"); 
		query.append("      ,STANDBY_TYPE" ).append("\n"); 
		query.append("      ,STANDBY_REASON" ).append("\n"); 
		query.append("      ,ALOC_SVC_CD" ).append("\n"); 
		query.append("      ,ALOC_STS_CD" ).append("\n"); 
		query.append("	  ,CFM_RQST_FLG" ).append("\n"); 
		query.append("	  ,CNDDT_CFM_FLG" ).append("\n"); 
		query.append("	  ,CFM_USR_ID" ).append("\n"); 
		query.append("	  ,CFM_DT" ).append("\n"); 
		query.append("#if($c_name.size() != 0)" ).append("\n"); 
		query.append("#foreach(${list} in ${c_name})" ).append("\n"); 
		query.append("      , ${list}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,FEU" ).append("\n"); 
		query.append("      ,TEU" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            BK.BKG_NO" ).append("\n"); 
		query.append("            , BK.BKG_STS_CD" ).append("\n"); 
		query.append("--            , SBDTL.LST_SB_RSN_TP_CD AS STANDBY_TYPE   -- HISTORY TABLE" ).append("\n"); 
		query.append("--            , SBDTL.LST_SB_RSN       AS STANDBY_REASON -- HISTORY TABLE" ).append("\n"); 
		query.append("			, SSB.CFM_USR_ID" ).append("\n"); 
		query.append("			, SSB.CFM_DT" ).append("\n"); 
		query.append("            , BK.ALOC_SVC_CD" ).append("\n"); 
		query.append("            , BK.ALOC_STS_CD" ).append("\n"); 
		query.append("            , BK.BL_NO" ).append("\n"); 
		query.append("            , BK.SLS_RHQ_CD" ).append("\n"); 
		query.append("            , BK.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("            , COA.SUB_TRD_CD" ).append("\n"); 
		query.append("            , BK.SLAN_CD               TRNK_SLAN_CD" ).append("\n"); 
		query.append("            , BK.SKD_DIR_CD            TRNK_DIR_CD" ).append("\n"); 
		query.append("            , BK.POL_CD                TRNK_POL" ).append("\n"); 
		query.append("            , BK.POD_CD                TRNK_POD" ).append("\n"); 
		query.append("            , BK.POR_CD                POR_LOC_CD" ).append("\n"); 
		query.append("            , BK.POR_NOD_CD            POR_NOD_CD" ).append("\n"); 
		query.append("            , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD" ).append("\n"); 
		query.append("            , BK.POL_CD                POL_LOC_CD" ).append("\n"); 
		query.append("            , BK.POL_NOD_CD            POL_NOD_CD" ).append("\n"); 
		query.append("            , NVL((SELECT VSL_SLAN_CD FROM VSK_VSL_SKD SKD WHERE SKD.VSL_CD = VVD.VSL_CD AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD), 'X') TS_SLAN_CD" ).append("\n"); 
		query.append("            , NVL(VVD.SKD_DIR_CD, 'X') TS_DIR_CD" ).append("\n"); 
		query.append("            , NVL(VVD.POL_CD,     'X') TS_POL_CD" ).append("\n"); 
		query.append("            , NVL(VVD.POD_CD,     'X') TS_POD_CD" ).append("\n"); 
		query.append("            , BK.POD_CD                POD_LOC_CD" ).append("\n"); 
		query.append("            , BK.POD_NOD_CD            POD_NOD_CD" ).append("\n"); 
		query.append("            , BK.DEL_CD                DEL_LOC_CD" ).append("\n"); 
		query.append("            , BK.DEL_NOD_CD            DEL_NOD_CD" ).append("\n"); 
		query.append("            , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD" ).append("\n"); 
		query.append("            , BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("            , BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("            , DECODE(BK.DCGO_FLG,'Y','DG', DECODE(BK.RD_CGO_FLG, 'Y', 'RD',''), '') DGRD" ).append("\n"); 
		query.append("            , BK.SC_NO" ).append("\n"); 
		query.append("            , BK.RFA_NO" ).append("\n"); 
		query.append("            , BK.CTRT_CUST_CNT_CD || NVL(LPAD(BK.CTRT_CUST_SEQ,6,'0'),'')     C_CUST" ).append("\n"); 
		query.append("            , BK.AGMT_ACT_CNT_CD  || NVL(LPAD(BK.AGMT_ACT_CUST_SEQ,6,'0'),'') A_CUST" ).append("\n"); 
		query.append("            , SHPR.CUST_CNT_CD    || NVL(LPAD(SHPR.CUST_SEQ,6,'0'),'')        SHRP" ).append("\n"); 
		query.append("            , CNEE.CUST_CNT_CD    || NVL(LPAD(CNEE.CUST_SEQ,6,'0'),'')        CNEE" ).append("\n"); 
		query.append("            , FWDR.CUST_CNT_CD    || NVL(LPAD(FWDR.CUST_SEQ,6,'0'),'')        FWDR" ).append("\n"); 
		query.append("            , BK.CMDT_CD" ).append("\n"); 
		query.append("            ,(SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE BK.CMDT_CD = CMDT.CMDT_CD) CMDT_DESC" ).append("\n"); 
		query.append("            , QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--            ,(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, 0)) FEU" ).append("\n"); 
		query.append("--            ,(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, QTY.OP_CNTR_QTY)) TEU" ).append("\n"); 
		query.append("			,( SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0) ) FROM BKG_QUANTITY " ).append("\n"); 
		query.append("				WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("#if (${tp_sz} == '1')" ).append("\n"); 
		query.append("                AND CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			)AS TEU" ).append("\n"); 
		query.append("			, (" ).append("\n"); 
		query.append("                SELECT SUM( DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY) ) FROM BKG_QUANTITY " ).append("\n"); 
		query.append("				WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#if (${tp_sz} == '1')" ).append("\n"); 
		query.append("                AND CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             ) AS FEU" ).append("\n"); 
		query.append("--                AND CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--          , ROUND(DECODE(BL.WGT_UT_CD, 'KGS', BL.ACT_WGT, BL.ACT_WGT * 0.45) / 1000) TON --아래 BL 관련 주석 같이 풀어야함" ).append("\n"); 
		query.append("			, SSB.CFM_RQST_FLG" ).append("\n"); 
		query.append("			, SSB.CNDDT_CFM_FLG" ).append("\n"); 
		query.append("            , (SELECT WM_CONCAT(LST_SB_RSN_TP_CD)    " ).append("\n"); 
		query.append("                 FROM SPC_SB_BKG_DTL " ).append("\n"); 
		query.append("                WHERE BKG_NO = SSB.BKG_NO" ).append("\n"); 
		query.append("#if (${lst_sb_rsn_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND LST_SB_RSN_TP_CD = @[lst_sb_rsn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) AS STANDBY_TYPE" ).append("\n"); 
		query.append("            , (SELECT WM_CONCAT(LST_SB_RSN || '||')  " ).append("\n"); 
		query.append("                 FROM SPC_SB_BKG_DTL " ).append("\n"); 
		query.append("                WHERE BKG_NO = SSB.BKG_NO" ).append("\n"); 
		query.append("#if (${lst_sb_rsn_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND LST_SB_RSN_TP_CD = @[lst_sb_rsn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) AS STANDBY_REASON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM COA_MON_VVD COA" ).append("\n"); 
		query.append("            , BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("            , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("            , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("            , BKG_CUSTOMER FWDR" ).append("\n"); 
		query.append("        --  , BKG_BL_DOC BL --BL관련 주석" ).append("\n"); 
		query.append("            , SPC_SB_BKG SSB" ).append("\n"); 
		query.append("--			, SPC_SB_BKG_DTL SBDTL" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("            AND COA.VSL_CD     = BK.VSL_CD" ).append("\n"); 
		query.append("            AND COA.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND COA.DIR_CD     = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = QTY.BKG_NO" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = SHPR.BKG_NO" ).append("\n"); 
		query.append("            AND 'S'            = SHPR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            AND 'C'            = CNEE.BKG_CUST_TP_CD(+) -- S: SHIPPER[물품을 보내는자(송하인)], C:CONSIGNEE[물건을 받는자(수하인)], F:FORWARDER[운송취급인.운송주선인 이라고 하며, 화물을 인수하여 수하인에게 인도할 때까지 일체의 업무를 주선하는 사람]" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = FWDR.BKG_NO(+)" ).append("\n"); 
		query.append("            AND 'F'            = FWDR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("            AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("        --  AND BK.BKG_STS_CD  = 'W' --Default 로 W 값만 가져오게 되어 있음." ).append("\n"); 
		query.append("        --  AND BK.BKG_NO       = BL.BKG_NO --BL관련 주석" ).append("\n"); 
		query.append("            AND BK.BKG_STS_CD IN ('F','W') --Default 로 W 값만 가져오게 되어 있음." ).append("\n"); 
		query.append("            AND SSB.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("--			AND SSB.BKG_NO = SBDTL.BKG_NO" ).append("\n"); 
		query.append("            AND COA.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("#if (${bkg_vvd_cd} != '')" ).append("\n"); 
		query.append("            AND COA.VSL_CD     = SUBSTR(@[bkg_vvd_cd],1,4)--'COGN0009W'" ).append("\n"); 
		query.append("            AND COA.SKD_VOY_NO = SUBSTR(@[bkg_vvd_cd],5,4)" ).append("\n"); 
		query.append("            AND COA.DIR_CD     = SUBSTR(@[bkg_vvd_cd],-1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_level} != '1')" ).append("\n"); 
		query.append("            AND SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD) IN (  SELECT OFC_CD " ).append("\n"); 
		query.append("                                                               FROM SPC_OFC_LVL " ).append("\n"); 
		query.append("                                                              WHERE DECODE(@[f_level], '2', n2nd_prnt_ofc_cd, '3', n4th_prnt_ofc_cd) = @[usr_ofc_cd]" ).append("\n"); 
		query.append("                                                           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aloc_sts_cd} != '')" ).append("\n"); 
		query.append("	#if (${aloc_sts_cd} == 'S')" ).append("\n"); 
		query.append("			AND BK.ALOC_STS_CD IN ( 'S' , 'A' )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD = @[aloc_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND BK.ALOC_STS_CD IN ( 'S' , 'A' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("            AND COA.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("            AND COA.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("            AND COA.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("            AND COA.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND BK.OB_SLS_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("                                       FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                       WHERE SUBSTR(COA.SLS_YRMON,1,4)||COA.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                         AND N4TH_PRNT_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_vvd_cd} == '' && ${yr_mon_wk} != '')" ).append("\n"); 
		query.append("--            AND SUBSTR(COA.SLS_YRMON,1,4)||COA.COST_WK IN" ).append("\n"); 
		query.append("--                (" ).append("\n"); 
		query.append("--                SELECT /*+ INDEX(D COST_YR, COST_WK)*/ D.COST_YR||D.COST_WK" ).append("\n"); 
		query.append("--                FROM COA_WK_PRD D" ).append("\n"); 
		query.append("--                WHERE D.COST_YR||D.COST_WK >= @ [yr_mon_wk] --'201501'" ).append("\n"); 
		query.append("--                    AND ROWNUM <= TO_NUMBER(@ [duration]) --('5')" ).append("\n"); 
		query.append("--                )" ).append("\n"); 
		query.append("			AND 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#if (${lst_sb_rsn_tp_cd} != '')" ).append("\n"); 
		query.append(" WHERE NVL(STANDBY_TYPE,' ') = @[lst_sb_rsn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--GROUP BY BKG_NO" ).append("\n"); 
		query.append("--      ,BKG_STS_CD" ).append("\n"); 
		query.append("--      ,STANDBY_TYPE" ).append("\n"); 
		query.append("--      ,STANDBY_REASON" ).append("\n"); 
		query.append("--      ,ALOC_SVC_CD" ).append("\n"); 
		query.append("--      ,ALOC_STS_CD" ).append("\n"); 
		query.append("--	  ,CFM_RQST_FLG" ).append("\n"); 
		query.append("--	  ,CNDDT_CFM_FLG" ).append("\n"); 
		query.append("--	  ,CFM_USR_ID" ).append("\n"); 
		query.append("--	  ,CFM_DT" ).append("\n"); 
		query.append("#if($c_name.size() != 0)" ).append("\n"); 
		query.append("#foreach(${list} in ${c_name})" ).append("\n"); 
		query.append("      ,${list}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}