/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Save a estimated data into GL_ESTM_IF_ERP 
	  * 2016.09.30 ESTM_CURR_CD 로 수정
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP ( " ).append("\n"); 
		query.append("           EXE_YRMON" ).append("\n"); 
		query.append("         , SYS_SRC_ID" ).append("\n"); 
		query.append("         , REV_YRMON" ).append("\n"); 
		query.append("         , ACCT_CD" ).append("\n"); 
		query.append("         , ACCT_DTL_CD" ).append("\n"); 
		query.append("         , ESTM_SEQ_NO" ).append("\n"); 
		query.append("         , BIZ_UT_ID" ).append("\n"); 
		query.append("         , LOC_CD" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , REV_DIR_CD" ).append("\n"); 
		query.append("         , ESTM_VVD_TP_CD -- 'RV'" ).append("\n"); 
		query.append("         , ESTM_IOC_DIV_CD -- 'OO'" ).append("\n"); 
		query.append("         , ESTM_BC_DIV_CD -- 'C'" ).append("\n"); 
		query.append("         , ESTM_VVD_HDR_ID-- 106405" ).append("\n"); 
		query.append("         , TTL_TRF_AMT" ).append("\n"); 
		query.append("         , ESTM_AMT" ).append("\n"); 
		query.append("         , ACT_AMT" ).append("\n"); 
		query.append("         , ACCL_AMT" ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("         , LOCL_CURR_CD" ).append("\n"); 
		query.append("         , ACT_DT" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , COST_ACT_PLC_CD " ).append("\n"); 
		query.append("         , VVD_DUR_NO  /* 2016.04.26 Double Calling Add: CLPT_IND_SEQ*/" ).append("\n"); 
		query.append("		 , ACCL_FLG /*2016.09.07 minus amount N flag*/" ).append("\n"); 
		query.append("         ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT EXE_YRMON" ).append("\n"); 
		query.append("             , SYS_SRC_ID" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , ACCT_CD" ).append("\n"); 
		query.append("             , LGS_COST_CD" ).append("\n"); 
		query.append("             , (ESTM_SEQ_NO + ROWNUM) AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("             , BIZ_UT_ID" ).append("\n"); 
		query.append("             , LOC_CD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("             , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("             , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("             , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("             , ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("             , TTL_TRF_AMT" ).append("\n"); 
		query.append("             , ESTM_AMT ESTM_AMT" ).append("\n"); 
		query.append("             , ACT_AMT" ).append("\n"); 
		query.append("             --, OLD_ACT_AMT" ).append("\n"); 
		query.append("             , ACCL_AMT" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , ACT_DT" ).append("\n"); 
		query.append("             , VSL_SLAN_CD" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("             , CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , DECODE(SIGN(ACCL_AMT), -1, 'N', NULL) /*2016.09.07 minus amount N flag*/" ).append("\n"); 
		query.append("		  FROM (        " ).append("\n"); 
		query.append("            SELECT EXE_YRMON" ).append("\n"); 
		query.append("                 , 'PSO' SYS_SRC_ID" ).append("\n"); 
		query.append("                 , REV_YRMON" ).append("\n"); 
		query.append("                 , ACCT_CD" ).append("\n"); 
		query.append("                 , LGS_COST_CD" ).append("\n"); 
		query.append("                 , (SELECT NVL(MAX(G.ESTM_SEQ_NO),0) FROM GL_ESTM_IF_ERP G WHERE G.EXE_YRMON = V.EXE_YRMON AND G.SYS_SRC_ID = 'PSO') AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("                 , 'CNTR' BIZ_UT_ID" ).append("\n"); 
		query.append("                 , LOC_CD" ).append("\n"); 
		query.append("                 , VSL_CD" ).append("\n"); 
		query.append("                 , SKD_VOY_NO" ).append("\n"); 
		query.append("                 , SKD_DIR_CD" ).append("\n"); 
		query.append("                 , REV_DIR_CD" ).append("\n"); 
		query.append("                 , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                 , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                 , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                 , ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                 , TTL_TRF_AMT" ).append("\n"); 
		query.append("                 , ESTM_AMT ESTM_AMT" ).append("\n"); 
		query.append("                 , ACT_AMT ACT_AMT" ).append("\n"); 
		query.append("                 , OLD_ACT_AMT" ).append("\n"); 
		query.append("                 , (ESTM_AMT - ACT_AMT) ACCL_AMT" ).append("\n"); 
		query.append("                 , @[cre_usr_id] CRE_USR_ID /*USR_ID*/--1" ).append("\n"); 
		query.append("                 , SYSDATE CRE_DT" ).append("\n"); 
		query.append("                 , @[cre_usr_id] UPD_USR_ID /*USR_ID*/--1" ).append("\n"); 
		query.append("                 , SYSDATE UPD_DT" ).append("\n"); 
		query.append("                 , LOCL_CURR_CD" ).append("\n"); 
		query.append("                 , ACT_DT" ).append("\n"); 
		query.append("                 , VSL_SLAN_CD" ).append("\n"); 
		query.append("                 , YD_CD" ).append("\n"); 
		query.append("                 , CLPT_IND_SEQ" ).append("\n"); 
		query.append("              FROM (SELECT VVD.EXE_YRMON AS EXE_YRMON" ).append("\n"); 
		query.append("                         , VVD.REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("                         , AMT.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("                         , AMT.LGS_COST_CD" ).append("\n"); 
		query.append("                         , SUBSTR(AMT.YD_CD,1,5) AS LOC_CD" ).append("\n"); 
		query.append("                         , VVD.VSL_CD" ).append("\n"); 
		query.append("                         , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                         , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                         , VVD.REV_DIR_CD" ).append("\n"); 
		query.append("                         , VVD.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                         , VVD.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                         , VVD.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                         , VVD.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                         , SUM(NVL(AMT.TRF_AMT,0)) AS TTL_TRF_AMT" ).append("\n"); 
		query.append("                         , SUM(NVL(DECODE(AMT.EST_AMT, 0.00000000001, 0, AMT.EST_AMT),0)) AS ESTM_AMT" ).append("\n"); 
		query.append("                         , SUM(NVL(DECODE(AMT.ACT_AMT, 0.00000000001, 0, AMT.ACT_AMT),0)) AS ACT_AMT" ).append("\n"); 
		query.append("                         , SUM(NVL(DECODE(AMT.OLD_ACT_AMT, 0.00000000001, 0, AMT.OLD_ACT_AMT),0)) AS OLD_ACT_AMT" ).append("\n"); 
		query.append("                         , AMT.LOCL_CURR_CD" ).append("\n"); 
		query.append("                         , NVL(AMT.ACT_DT, VVD.VPS_ETD_DT) AS ACT_DT" ).append("\n"); 
		query.append("                         , AMT.VSL_SLAN_CD" ).append("\n"); 
		query.append("                         , AMT.YD_CD" ).append("\n"); 
		query.append("                         , AMT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            ----------------1. TARGET VVD START : Estimate 에서는 공통 항차를 빼므로 VSK_VSL_PORT_SKD과 join" ).append("\n"); 
		query.append("                            SELECT G.ESTM_IOC_DIV_CD AS ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                                 , G.EXE_YRMON" ).append("\n"); 
		query.append("                                 , G.REV_YRMON" ).append("\n"); 
		query.append("                                 , G.VSL_CD" ).append("\n"); 
		query.append("                                 , G.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 , G.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 , G.REV_DIR_CD" ).append("\n"); 
		query.append("                                 , G.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                                 , G.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                                 , G.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                                 , G.RLANE_CD" ).append("\n"); 
		query.append("                                 , VPS.YD_CD" ).append("\n"); 
		query.append("                                 , VPS.SLAN_CD" ).append("\n"); 
		query.append("                                 , TO_CHAR(VPS.VPS_ETD_DT, 'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                                 , VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              FROM GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                                 , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                             WHERE 1=1 --G.ESTM_IOC_DIV_CD    = 'OO'" ).append("\n"); 
		query.append("                               AND G.EXE_YRMON          = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("                               AND G.ESTM_BC_DIV_CD     IN ('C', 'M', 'A')" ).append("\n"); 
		query.append("                               AND G.VSL_CD             = VPS.VSL_CD" ).append("\n"); 
		query.append("                               AND G.SKD_VOY_NO         = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND G.SKD_DIR_CD         = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND VPS.VSL_CD           = @[vsl_cd] /*'HNMF'*/" ).append("\n"); 
		query.append("                               AND VPS.SKD_VOY_NO       = @[skd_voy_no] /*'0009'*/" ).append("\n"); 
		query.append("                               AND VPS.SKD_DIR_CD       = @[skd_dir_cd] /*'W'*/" ).append("\n"); 
		query.append("                               AND VPS.YD_CD            = @[yd_cd] /*'AEJEAJA'*/" ).append("\n"); 
		query.append("                               AND 'S'                  <> NVL(VPS.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                               AND 'N'                  = NVL(VPS.VT_ADD_CALL_FLG, 'N')" ).append("\n"); 
		query.append("                               AND VPS.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                               AND VPS.VPS_ETD_DT 		>= TO_DATE('20160601','YYYYMMDD') /*2016.06.27 : Accrual 시점 정의(20160601).*/" ).append("\n"); 
		query.append("                           ) VVD" ).append("\n"); 
		query.append("                           ," ).append("\n"); 
		query.append("                            ----------------1. TARGET VVD E N D" ).append("\n"); 
		query.append("                           (                             " ).append("\n"); 
		query.append("                            ----------------2. ESTIMTE AMOUNT / ACTUAL AMOUNT START" ).append("\n"); 
		query.append("                            SELECT VSL_CD" ).append("\n"); 
		query.append("                                 , SKD_VOY_NO" ).append("\n"); 
		query.append("                                 , SKD_DIR_CD" ).append("\n"); 
		query.append("                                 , REV_DIR_CD" ).append("\n"); 
		query.append("                                 , RLANE_CD" ).append("\n"); 
		query.append("                                 , YD_CD" ).append("\n"); 
		query.append("                                 , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                 , ACCT_CD" ).append("\n"); 
		query.append("                                 , LGS_COST_CD" ).append("\n"); 
		query.append("                                 , SUM(EST_USD_AMT) AS EST_AMT" ).append("\n"); 
		query.append("                                 , SUM(ACT_AMT)     AS ACT_AMT" ).append("\n"); 
		query.append("                                 , SUM(OLD_ACT_AMT) AS OLD_ACT_AMT" ).append("\n"); 
		query.append("                                 , SUM(TRF_AMT)     AS TRF_AMT" ).append("\n"); 
		query.append("                                 , LOCL_CURR_CD" ).append("\n"); 
		query.append("                                 , ACT_DT" ).append("\n"); 
		query.append("                                 , VSL_SLAN_CD" ).append("\n"); 
		query.append("                              FROM (" ).append("\n"); 
		query.append("                                    ------------2.1.ESTIMATED AMOUNT START" ).append("\n"); 
		query.append("                                    SELECT T01.VSL_CD" ).append("\n"); 
		query.append("                                         , T01.SKD_VOY_NO" ).append("\n"); 
		query.append("                                         , T01.SKD_DIR_CD" ).append("\n"); 
		query.append("                                         , T01.REV_DIR_CD" ).append("\n"); 
		query.append("                                         , T01.RLANE_CD" ).append("\n"); 
		query.append("                                         , T01.YD_CD" ).append("\n"); 
		query.append("                                         , T01.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         , T01.ACCT_CD" ).append("\n"); 
		query.append("                                         , T01.LGS_COST_CD" ).append("\n"); 
		query.append("                                         , T01.EST_USD_AMT AS EST_USD_AMT" ).append("\n"); 
		query.append("                                         , T01.EST_USD_AMT AS TRF_AMT" ).append("\n"); 
		query.append("                                         , T01.ACT_AMT" ).append("\n"); 
		query.append("                                         , T01.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                         , T01.ACT_DT" ).append("\n"); 
		query.append("                                         , T01.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                         , T01.OLD_ACT_AMT" ).append("\n"); 
		query.append("                                      FROM (SELECT VSL_CD" ).append("\n"); 
		query.append("                                                 , SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 , SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 , REV_DIR_CD" ).append("\n"); 
		query.append("                                                 , RLANE_CD" ).append("\n"); 
		query.append("                                                 , YD_CD" ).append("\n"); 
		query.append("                                                 , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                 , ACCT_CD" ).append("\n"); 
		query.append("                                                 , LGS_COST_CD" ).append("\n"); 
		query.append("                                                 , EST_USD_AMT" ).append("\n"); 
		query.append("                                                 , ACT_AMT" ).append("\n"); 
		query.append("                                                 , LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                 , ACT_DT" ).append("\n"); 
		query.append("                                                 , VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                 , OLD_ACT_AMT" ).append("\n"); 
		query.append("                                              FROM (SELECT E.VSL_CD" ).append("\n"); 
		query.append("                                                         , E.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         , E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         , E.REV_DIR_CD" ).append("\n"); 
		query.append("                                                         , E.RLANE_CD" ).append("\n"); 
		query.append("                                                         , E.YD_CD" ).append("\n"); 
		query.append("                                                         , E.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                         , CT.ACCT_CD" ).append("\n"); 
		query.append("                                                         , CT.LGS_COST_CD" ).append("\n"); 
		query.append("                                                         , SUM(E.INV_LOCL_AMT) AS EST_USD_AMT" ).append("\n"); 
		query.append("                                                         , 0 AS ACT_AMT" ).append("\n"); 
		query.append("                                                         , E.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                         , E.ACT_DT" ).append("\n"); 
		query.append("                                                         , T.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                         , 0 AS OLD_ACT_AMT" ).append("\n"); 
		query.append("                                                      FROM PSO_TGT_VVD T" ).append("\n"); 
		query.append("                                                         , PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("                                                         , TES_LGS_COST CT" ).append("\n"); 
		query.append("                                                         , (SELECT MIN(G.REV_YRMON) AS MIN_REV_YRMON" ).append("\n"); 
		query.append("                                                                 , MAX(G.REV_YRMON) AS MAX_REV_YRMON" ).append("\n"); 
		query.append("                                                              FROM GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                                                             WHERE G.ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                                                               AND G.EXE_YRMON = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("                                                               AND G.ESTM_BC_DIV_CD IN ('C', 'M', 'A')" ).append("\n"); 
		query.append("                                                            ) G" ).append("\n"); 
		query.append("                                                     WHERE T.PSO_BZTP_CD    = '2'" ).append("\n"); 
		query.append("                                                       AND T.PSO_BZTP_CD    = E.PSO_BZTP_CD" ).append("\n"); 
		query.append("                                                       AND T.VSL_CD         = E.VSL_CD" ).append("\n"); 
		query.append("                                                       AND T.SKD_VOY_NO     = E.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                       AND T.SKD_DIR_CD     = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                       AND E.VSL_CD         = @[vsl_cd] /*'HNMF'*/" ).append("\n"); 
		query.append("                                                       AND E.SKD_VOY_NO     = @[skd_voy_no] /*'0009'*/" ).append("\n"); 
		query.append("                                                       AND E.SKD_DIR_CD     = @[skd_dir_cd] /*'W'*/" ).append("\n"); 
		query.append("                                                       AND E.YD_CD          = @[yd_cd] /*'AEJEAJA'*/" ).append("\n"); 
		query.append("                                                       AND E.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                       AND E.LGS_COST_CD    = CT.LGS_COST_CD" ).append("\n"); 
		query.append("                                                       AND T.EXPN_YRMON     BETWEEN REPLACE(G.MIN_REV_YRMON, '-', '') AND REPLACE(G.MAX_REV_YRMON, '-', '') /*MIN,MAX YRMON , '201405' '201411'*/--3" ).append("\n"); 
		query.append("                                                     GROUP BY E.VSL_CD" ).append("\n"); 
		query.append("                                                            , E.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                            , E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            , E.REV_DIR_CD" ).append("\n"); 
		query.append("                                                            , E.RLANE_CD" ).append("\n"); 
		query.append("                                                            , E.YD_CD" ).append("\n"); 
		query.append("                                                            , E.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                            , CT.ACCT_CD" ).append("\n"); 
		query.append("                                                            , CT.LGS_COST_CD" ).append("\n"); 
		query.append("                                                            , E.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                            , E.ACT_DT" ).append("\n"); 
		query.append("                                                            , T.VSL_SLAN_CD " ).append("\n"); 
		query.append("                                                     ) " ).append("\n"); 
		query.append("                                          ) T01" ).append("\n"); 
		query.append("                                    ------------2.1.ESTIMATED AMOUNT E N D" ).append("\n"); 
		query.append("                                    UNION ALL" ).append("\n"); 
		query.append("                                    ------------2.2.ACTUAL AMOUNT START" ).append("\n"); 
		query.append("                                    SELECT T3.VSL_CD        AS VSL_CD" ).append("\n"); 
		query.append("                                         , T3.SKD_VOY_NO    AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                         , T3.SKD_DIR_CD    AS SKD_DIR_CD" ).append("\n"); 
		query.append("		                                 , T3.REV_DIR_CD    AS REV_DIR_CD" ).append("\n"); 
		query.append("                                         , T9.RLANE_CD      AS RLANE_CD" ).append("\n"); 
		query.append("                                         , T3.YD_CD         AS YD_CD" ).append("\n"); 
		query.append("                                         , T3.CLPT_IND_SEQ  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         , T3.ACCT_CD       AS ACCT_CD" ).append("\n"); 
		query.append("                                         , T3.LGS_COST_CD   AS LGS_COST_CD" ).append("\n"); 
		query.append("                                         , 0                AS EST_USD_AMT" ).append("\n"); 
		query.append("                                         , 0                AS TRF_AMT" ).append("\n"); 
		query.append("                                         , SUM(T3.INV_AMT)  AS ACT_AMT" ).append("\n"); 
		query.append("                                         , T3.LOCL_CURR_CD  AS LOCL_CURR_CD" ).append("\n"); 
		query.append("                                         , T3.ACT_DT        AS ACT_DT" ).append("\n"); 
		query.append("                                         , T3.VSL_SLAN_CD   AS VSL_SLAN_CD" ).append("\n"); 
		query.append("		                                 , SUM(T3.OLD_INV_AMT)  AS OLD_ACT_AMT" ).append("\n"); 
		query.append("                                      FROM (" ).append("\n"); 
		query.append("                                            SELECT T3.VSL_CD        AS VSL_CD" ).append("\n"); 
		query.append("                                                 , T3.SKD_VOY_NO    AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                                 , T3.SKD_DIR_CD    AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 , T3.REV_DIR_CD    AS REV_DIR_CD" ).append("\n"); 
		query.append("                                                 , T3.YD_CD         AS YD_CD" ).append("\n"); 
		query.append("                                                 , T3.CLPT_IND_SEQ  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                 , T3.ACCT_CD       AS ACCT_CD" ).append("\n"); 
		query.append("                                                 , T3.LGS_COST_CD   AS LGS_COST_CD" ).append("\n"); 
		query.append("                                                 , T3.INV_AMT       AS OLD_INV_AMT" ).append("\n"); 
		query.append("                                                 , CASE WHEN T3.TRFF_CURR_CD IS NOT NULL AND T3.LOCL_CURR_CD <> T3.TRFF_CURR_CD " ).append("\n"); 
		query.append("                                                        THEN PSO_CONV_CURR_CHG_FNC(T3.LOCL_CURR_CD, T3.TRFF_CURR_CD, T3.INV_AMT, T3.ACT_DT, '1')" ).append("\n"); 
		query.append("                                                        ELSE T3.INV_AMT" ).append("\n"); 
		query.append("                                                   END AS INV_AMT" ).append("\n"); 
		query.append("                                                 , T3.LOCL_CURR_CD  AS OLD_LOCL_CURR_CD                                                     " ).append("\n"); 
		query.append("                                                 , CASE WHEN T3.TRFF_CURR_CD IS NOT NULL AND T3.LOCL_CURR_CD <> T3.TRFF_CURR_CD " ).append("\n"); 
		query.append("                                                        THEN T3.TRFF_CURR_CD" ).append("\n"); 
		query.append("                                                        ELSE T3.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                   END AS LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                 , T3.ACT_DT        AS ACT_DT" ).append("\n"); 
		query.append("                                                 , T3.VSL_SLAN_CD   AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                 , T3.CSR_NO" ).append("\n"); 
		query.append("                                              FROM (" ).append("\n"); 
		query.append("                                                    SELECT DISTINCT T3.INV_RGST_NO" ).append("\n"); 
		query.append("                                                         , T3.INV_RGST_SEQ" ).append("\n"); 
		query.append("                                                         , T3.ACCT_CD" ).append("\n"); 
		query.append("                                                         , T3.LGS_COST_CD" ).append("\n"); 
		query.append("                                                         , NVL(CORR_VSL_CD      , SUBSTR(T3.ACT_VVD_CD, 1, 4))  AS VSL_CD" ).append("\n"); 
		query.append("                                                         , NVL(CORR_SKD_VOY_NO  , SUBSTR(T3.ACT_VVD_CD, 5, 4))  AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         , NVL(CORR_SKD_DIR_CD  , SUBSTR(T3.ACT_VVD_CD, 9, 1))  AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         , NVL(CORR_REV_DIR_CD  , SUBSTR(T3.ACT_VVD_CD, 10, 1)) AS REV_DIR_CD" ).append("\n"); 
		query.append("                                                         , T3.INV_AMT" ).append("\n"); 
		query.append("                                                         , T3.SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                         , T2.INV_CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("                                                         , T2.CSR_NO" ).append("\n"); 
		query.append("                                                         , T1.YD_CD" ).append("\n"); 
		query.append("                                                         --, T3.ACT_DT" ).append("\n"); 
		query.append("                                                         , (SELECT MIN(TO_CHAR(VPS.VPS_ETD_DT , 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                              FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                                             WHERE 1=1" ).append("\n"); 
		query.append("                                                               AND VPS.VSL_CD       = NVL(CORR_VSL_CD       , SUBSTR(T3.ACT_VVD_CD, 1, 4))" ).append("\n"); 
		query.append("                                                               AND VPS.SKD_VOY_NO   = NVL(CORR_SKD_VOY_NO   , SUBSTR(T3.ACT_VVD_CD, 5, 4))" ).append("\n"); 
		query.append("                                                               AND VPS.SKD_DIR_CD   = NVL(CORR_SKD_DIR_CD   , SUBSTR(T3.ACT_VVD_CD, 9, 1))" ).append("\n"); 
		query.append("                                                               AND VPS.YD_CD        = T1.YD_CD" ).append("\n"); 
		query.append("                                                               AND VPS.CLPT_IND_SEQ = CD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                           ) AS ACT_DT" ).append("\n"); 
		query.append("                                                         , CD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                         , (SELECT YC.CURR_CD" ).append("\n"); 
		query.append("                                                              FROM PSO_YD_CHG YC" ).append("\n"); 
		query.append("                                                             WHERE 1=1" ).append("\n"); 
		query.append("                                                               AND YC.YD_CHG_NO = CD.YD_CHG_NO" ).append("\n"); 
		query.append("                                                               AND YC.YD_CHG_VER_SEQ = CD.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                                                           ) AS TRFF_CURR_CD /*2016.09.23 Add*/" ).append("\n"); 
		query.append("                                                      FROM PSO_CHARGE       T1" ).append("\n"); 
		query.append("                                                         , PSO_CHG_DTL      CD" ).append("\n"); 
		query.append("                                                         , AP_PAY_INV       T2" ).append("\n"); 
		query.append("                                                         , AP_PAY_INV_DTL   T3" ).append("\n"); 
		query.append("                                                         , GL_ERR_VVD       GEV" ).append("\n"); 
		query.append("                                                         --, VSK_VSL_PORT_SKD T6" ).append("\n"); 
		query.append("                                                     WHERE 1=1" ).append("\n"); 
		query.append("                                                       AND T1.ISS_CTY_CD    = CD.ISS_CTY_CD" ).append("\n"); 
		query.append("                                                       AND T1.SO_SEQ        = CD.SO_SEQ" ).append("\n"); 
		query.append("                                                       AND T1.INV_RGST_NO   = T2.INV_RGST_NO" ).append("\n"); 
		query.append("                                                       AND T2.INV_RGST_NO   = T3.INV_RGST_NO" ).append("\n"); 
		query.append("                                                       AND T2.INV_STS_CD    IN ('P', 'D')" ).append("\n"); 
		query.append("                                                       AND T2.INV_SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                                                       AND SUBSTR(T2.GL_DT, 1, 6) <= REPLACE(@[exe_yrmon],'-') /*2016.11.24 Add 실행월 보다 큰 데이타 제외처리.*/" ).append("\n"); 
		query.append("                                                       AND CD.VSL_CD        = @[vsl_cd] /*'HNMF'*/" ).append("\n"); 
		query.append("                                                       AND CD.SKD_VOY_NO    = @[skd_voy_no] /*'0009'*/" ).append("\n"); 
		query.append("                                                       AND CD.SKD_DIR_CD    = @[skd_dir_cd] /*'W'*/" ).append("\n"); 
		query.append("                                                       AND T1.YD_CD         = @[yd_cd] /*'AEJEAJA'*/" ).append("\n"); 
		query.append("                                                       AND CD.CLPT_IND_SEQ  = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                       AND CD.ISS_CTY_CD    = T3.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                       AND CD.SO_SEQ        = T3.SO_SEQ" ).append("\n"); 
		query.append("                                                       --AND CD.VSL_CD        = T3.VSL_CD" ).append("\n"); 
		query.append("                                                       --AND CD.SKD_VOY_NO    = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                       --AND CD.SKD_DIR_CD    = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                       --AND CD.REV_DIR_CD    = T3.REV_DIR_CD" ).append("\n"); 
		query.append("                                                       /*2016.11.09 VVD - ACT_VVD_CD Modify*/" ).append("\n"); 
		query.append("                                                       AND CD.VSL_CD        = SUBSTR(T3.ACT_VVD_CD, 1, 4)" ).append("\n"); 
		query.append("                                                       AND CD.SKD_VOY_NO    = SUBSTR(T3.ACT_VVD_CD, 5, 4)" ).append("\n"); 
		query.append("                                                       AND CD.SKD_DIR_CD    = SUBSTR(T3.ACT_VVD_CD, 9, 1)" ).append("\n"); 
		query.append("                                                       AND CD.REV_DIR_CD    = SUBSTR(T3.ACT_VVD_CD, 10, 1)" ).append("\n"); 
		query.append("                                                       AND CD.LGS_COST_CD   = T3.LGS_COST_CD" ).append("\n"); 
		query.append("                                                       AND ERR_VSL_CD       (+) = SUBSTR(T3.ACT_VVD_CD, 1, 4)" ).append("\n"); 
		query.append("                                                       AND ERR_SKD_VOY_NO   (+) = SUBSTR(T3.ACT_VVD_CD, 5, 4)" ).append("\n"); 
		query.append("                                                       AND ERR_SKD_DIR_CD   (+) = SUBSTR(T3.ACT_VVD_CD, 9, 1)" ).append("\n"); 
		query.append("                                                       AND ERR_REV_DIR_CD   (+) = SUBSTR(T3.ACT_VVD_CD, 10, 1) " ).append("\n"); 
		query.append("                                                       AND AVAL_FLG         (+) = 'Y' " ).append("\n"); 
		query.append("                                                       AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                                                                      FROM GL_ESTM_REV_VVD GE" ).append("\n"); 
		query.append("                                                                     WHERE GE.EXE_YRMON     = REPLACE(@[exe_yrmon], '-', '') /*EXE_YRMON, '200906'*/ --4" ).append("\n"); 
		query.append("                                                                       AND GE.VSL_CD        = NVL(CORR_VSL_CD       , SUBSTR(T3.ACT_VVD_CD, 1, 4))" ).append("\n"); 
		query.append("                                                                       AND GE.SKD_VOY_NO    = NVL(CORR_SKD_VOY_NO   , SUBSTR(T3.ACT_VVD_CD, 5, 4))" ).append("\n"); 
		query.append("                                                                       AND GE.SKD_DIR_CD    = NVL(CORR_SKD_DIR_CD   , SUBSTR(T3.ACT_VVD_CD, 9, 1)) " ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                                    ) T3                                                           " ).append("\n"); 
		query.append("                                           ) T3" ).append("\n"); 
		query.append("                                         , AP_INV_HDR T4" ).append("\n"); 
		query.append("                                         , AR_MST_REV_VVD T9" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND T3.CSR_NO        = T4.CSR_NO" ).append("\n"); 
		query.append("                                       AND T9.VSL_CD        = T3.VSL_CD" ).append("\n"); 
		query.append("                                       AND T9.SKD_VOY_NO    = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND T9.SKD_DIR_CD    = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND T9.RLANE_DIR_CD  = T3.REV_DIR_CD" ).append("\n"); 
		query.append("                                       AND T9.DELT_FLG      = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("                                       AND T3.VSL_CD        = @[vsl_cd] /*'HNMF'*/" ).append("\n"); 
		query.append("                                       AND T3.SKD_VOY_NO    = @[skd_voy_no] /*'0009'*/" ).append("\n"); 
		query.append("                                       AND T3.SKD_DIR_CD    = @[skd_dir_cd] /*'W'*/" ).append("\n"); 
		query.append("                                       AND T3.YD_CD         = @[yd_cd] /*'AEJEAJA'*/" ).append("\n"); 
		query.append("                                       AND T3.CLPT_IND_SEQ  = @[clpt_ind_seq] /*'1'*/" ).append("\n"); 
		query.append("                                     GROUP BY T3.VSL_CD" ).append("\n"); 
		query.append("                                            , T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            , T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            , T3.REV_DIR_CD" ).append("\n"); 
		query.append("                                            , T9.RLANE_CD" ).append("\n"); 
		query.append("                                            , T3.YD_CD" ).append("\n"); 
		query.append("                                            , T3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                            , T3.ACCT_CD" ).append("\n"); 
		query.append("                                            , T3.LGS_COST_CD" ).append("\n"); 
		query.append("                                            , T3.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                            , T3.ACT_DT" ).append("\n"); 
		query.append("                                            , T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                   ------------2.2.ACTUAL AMOUNT E N D" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                             WHERE 1=1" ).append("\n"); 
		query.append("                             GROUP BY VSL_CD" ).append("\n"); 
		query.append("                                    , SKD_VOY_NO" ).append("\n"); 
		query.append("                                    , SKD_DIR_CD" ).append("\n"); 
		query.append("                                    , REV_DIR_CD" ).append("\n"); 
		query.append("                                    , RLANE_CD" ).append("\n"); 
		query.append("                                    , YD_CD" ).append("\n"); 
		query.append("                                    , CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                    , ACCT_CD" ).append("\n"); 
		query.append("                                    , LGS_COST_CD" ).append("\n"); 
		query.append("                                    , LOCL_CURR_CD" ).append("\n"); 
		query.append("                                    , ACT_DT" ).append("\n"); 
		query.append("                                    , VSL_SLAN_CD" ).append("\n"); 
		query.append("                            ) AMT" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VVD.VSL_CD       = AMT.VSL_CD" ).append("\n"); 
		query.append("                       AND VVD.SKD_VOY_NO   = AMT.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VVD.SKD_DIR_CD   = AMT.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND VVD.RLANE_CD     = AMT.RLANE_CD " ).append("\n"); 
		query.append("                       AND VVD.YD_CD        = AMT.YD_CD  " ).append("\n"); 
		query.append("                       AND VVD.CLPT_IND_SEQ = AMT.CLPT_IND_SEQ  " ).append("\n"); 
		query.append("		               AND NVL(VVD.REV_DIR_CD,'X')   = NVL(AMT.REV_DIR_CD,'X') /*2016.07.29 Add*/" ).append("\n"); 
		query.append("                     GROUP BY VVD.EXE_YRMON " ).append("\n"); 
		query.append("                            , VVD.REV_YRMON " ).append("\n"); 
		query.append("                            , AMT.ACCT_CD " ).append("\n"); 
		query.append("                            , AMT.LGS_COST_CD" ).append("\n"); 
		query.append("                            , SUBSTR(AMT.YD_CD,1,5)" ).append("\n"); 
		query.append("                            , AMT.YD_CD" ).append("\n"); 
		query.append("                            , AMT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            , VVD.VSL_CD" ).append("\n"); 
		query.append("                            , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                            , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                            , VVD.REV_DIR_CD " ).append("\n"); 
		query.append("                            , VVD.ESTM_VVD_TP_CD " ).append("\n"); 
		query.append("                            , VVD.ESTM_IOC_DIV_CD " ).append("\n"); 
		query.append("                            , VVD.ESTM_BC_DIV_CD " ).append("\n"); 
		query.append("                            , VVD.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                            , AMT.LOCL_CURR_CD" ).append("\n"); 
		query.append("                            , NVL(AMT.ACT_DT, VVD.VPS_ETD_DT)" ).append("\n"); 
		query.append("                            , AMT.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     ORDER BY LOC_CD, ACCT_CD, LGS_COST_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD " ).append("\n"); 
		query.append("                   ) V" ).append("\n"); 
		query.append("                  WHERE 1=1 " ).append("\n"); 
		query.append("               ) V" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   AND ACCT_CD NOT IN ('962111', '564611')" ).append("\n"); 
		query.append("          /*2016.04.18 Add : Accrual 대상 만 진행함.*/" ).append("\n"); 
		query.append("          AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND SACAI.SRC_MDL_CD          = 'PSO'" ).append("\n"); 
		query.append("                          AND NVL(SACAI.ENBL_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("                          AND NVL(SACAI.ACCL_FLG, 'N')  = 'Y'" ).append("\n"); 
		query.append("                          AND SACAI.ACT_COST_CD         = LGS_COST_CD)" ).append("\n"); 

	}
}