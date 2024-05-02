/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.08
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.10.08 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rehanding Exp. - COD vs. TPB 조회
	  * </pre>
	  */
	public RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_toMonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_fmMonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL").append("\n"); 
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
		query.append("SELECT COD_OFC_CD," ).append("\n"); 
		query.append("COD_PORT_CD," ).append("\n"); 
		query.append("MAX(COD_VVD) COD_VVD," ).append("\n"); 
		query.append("MAX(COD_SLAN_CD) COD_SLAN_CD," ).append("\n"); 
		query.append("MAX(VVD) VVD," ).append("\n"); 
		query.append("MAX(COD_ETD_DT) COD_ETD_DT," ).append("\n"); 
		query.append("MAX(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("MAX(COD_CNTR_QTY) COD_CNTR_QTY," ).append("\n"); 
		query.append("SUM(COD_AMT) COD_AMT," ).append("\n"); 
		query.append("MAX(TPB_NO) TPB_NO," ).append("\n"); 
		query.append("MAX(AMT_USD) AMT_USD," ).append("\n"); 
		query.append("MAX(ROC_OFC) ROC_OFC," ).append("\n"); 
		query.append("MAX(PTY_3RD) PTY_3RD," ).append("\n"); 
		query.append("MAX(NEW_TPB_NO) NEW_TPB_NO," ).append("\n"); 
		query.append("SUM(BL_AMT) USD_AMT_BL," ).append("\n"); 
		query.append("MAX( DECODE( NVL(RMK_CTNT, '0') , '0', 'N', 'Y' ) )   AS RMK_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COD_OFC_CD," ).append("\n"); 
		query.append("COD_PORT_CD," ).append("\n"); 
		query.append("MAX(COD_VVD) COD_VVD," ).append("\n"); 
		query.append("MAX(COD_SLAN_CD) COD_SLAN_CD," ).append("\n"); 
		query.append("MAX(VVD) VVD," ).append("\n"); 
		query.append("MAX(COD_ETD_DT) COD_ETD_DT," ).append("\n"); 
		query.append("MAX(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("MAX(COD_CNTR_QTY) COD_CNTR_QTY," ).append("\n"); 
		query.append("SUM(COD_AMT) COD_AMT," ).append("\n"); 
		query.append("MAX(TPB_NO) TPB_NO," ).append("\n"); 
		query.append("MAX(AMT_USD) AMT_USD," ).append("\n"); 
		query.append("MAX(ROC_OFC) ROC_OFC," ).append("\n"); 
		query.append("MAX(PTY_3RD) PTY_3RD," ).append("\n"); 
		query.append("MAX(NEW_TPB_NO) NEW_TPB_NO," ).append("\n"); 
		query.append("BL_AMT," ).append("\n"); 
		query.append("MAX(RMK_CTNT)   AS RMK_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFFICE COD_OFC_CD" ).append("\n"); 
		query.append(",   A.COD_PORT_CD" ).append("\n"); 
		query.append(",	A.COD_VVD" ).append("\n"); 
		query.append(",	A.COD_SLAN_CD" ).append("\n"); 
		query.append(",	A.VVD" ).append("\n"); 
		query.append(",	A.COD_ETD_DT" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append(",	A.COD_CNTR_QTY" ).append("\n"); 
		query.append(",	A.COD_AMT" ).append("\n"); 
		query.append(",	MAX(C.TPB_NO)  TPB_NO" ).append("\n"); 
		query.append(",	MAX(C.AMT_USD) AMT_USD" ).append("\n"); 
		query.append(",	MAX(C.ROC_OFC) ROC_OFC" ).append("\n"); 
		query.append(",	MAX(C.PTY_3RD) PTY_3RD" ).append("\n"); 
		query.append(",	MAX(C.NEW_TPB_NO) NEW_TPB_NO" ).append("\n"); 
		query.append(",	SUM(DECODE(A.COD_CHG_CD, 'DVC', B.BL_AMT" ).append("\n"); 
		query.append(", 	'DIV', B.BL_AMT" ).append("\n"); 
		query.append(", 	'ADF', B.BL_AMT" ).append("\n"); 
		query.append(", 	'FDR', B.BL_AMT" ).append("\n"); 
		query.append(", 	'OLO', B.BL_AMT" ).append("\n"); 
		query.append(", 	'RLO', B.BL_AMT" ).append("\n"); 
		query.append(", 	'DLO', B.BL_AMT" ).append("\n"); 
		query.append(", 	'SCR', B.BL_AMT, 0)) BL_AMT" ).append("\n"); 
		query.append(",   MAX(A.RMK_CTNT)   AS RMK_CTNT" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("SELECT A.COD_OFC_CD OFFICE" ).append("\n"); 
		query.append(", A.COD_PORT_CD" ).append("\n"); 
		query.append(", A.COD_OFC_CD" ).append("\n"); 
		query.append(", A.COD_CHG_CD" ).append("\n"); 
		query.append(", A.COD_VSL_CD||COD_SKD_VOY_NO||COD_SKD_DIR_CD COD_VVD" ).append("\n"); 
		query.append(", A.COD_SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", TO_CHAR(A.COD_ETD_DT,'YYYY-MM-DD') COD_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.COD_CFM_DT,'YYYYMM') COD_CFM_DT" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", A.COD_CNTR_QTY" ).append("\n"); 
		query.append(", ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.COD_CHG_CURR_CD,A.COD_CHG_AMT, TO_CHAR(A.COD_CFM_DT,'YYYYMM')),2) COD_AMT" ).append("\n"); 
		query.append(", MAX(C.RMK_CTNT)  AS RMK_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("----VSK_COD_IF A---" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.BKG_NO                                    BKG_NO," ).append("\n"); 
		query.append("A.COD_RQST_OFC_CD                              COD_OFC_CD,        --- A.CA_OFC_CD" ).append("\n"); 
		query.append("NVL(A.COD_RHND_PORT_CD,SUBSTR(VVD1.POL_YD_CD, 1, 5))         COD_PORT_CD,       --- A.CA_REH_PORT , VVD1.CBV_POL_LOC" ).append("\n"); 
		query.append("VVD1.VSL_CD                                 COD_VSL_CD," ).append("\n"); 
		query.append("VVD1.SKD_VOY_NO                             COD_SKD_VOY_NO,   --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD1.SKD_DIR_CD                             COD_SKD_DIR_CD," ).append("\n"); 
		query.append("VVD2.VSL_CD                                 VSL_CD," ).append("\n"); 
		query.append("VVD2.SKD_VOY_NO                             SKD_VOY_NO,       --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD2.SKD_DIR_CD                             SKD_DIR_CD," ).append("\n"); 
		query.append("SKD.VSL_SLAN_CD                             COD_SLAN_CD,   --- SLN_LANE_CD" ).append("\n"); 
		query.append("VPS.INIT_ETD_DT                             COD_ETD_DT,   ---- VPS_ETD_DT" ).append("\n"); 
		query.append("COUNT(CNTR_NO)                              COD_CNTR_QTY," ).append("\n"); 
		query.append("B.CHG_CD                                     COD_CHG_CD,   --- B.CC_CHARGE" ).append("\n"); 
		query.append("B.CURR_CD                                  COD_CHG_CURR_CD,   --- B.CC_CURRENCY" ).append("\n"); 
		query.append("B.CHG_AMT                                  COD_CHG_AMT,   ---B.CC_AMOUNT" ).append("\n"); 
		query.append("TO_CHAR(D.CRE_DT  , 'YYYYMMDD')          COD_CRE_DT,      --- D.CH_ISS_DT" ).append("\n"); 
		query.append("D.CRE_DT                                 COD_CFM_DT      --- D.CH_ISS_DT" ).append("\n"); 
		query.append("FROM    BKG_COD      A,     --- COD_APPL    A," ).append("\n"); 
		query.append("BKG_COD_COST     B,     --- COD_COST    B," ).append("\n"); 
		query.append("BKG_COD_HIS      D,     --- COD_HIS     D," ).append("\n"); 
		query.append("BKG_COD_CNTR     CNTR,  --- COD_CNTR    CNTR," ).append("\n"); 
		query.append("BKG_COD_VVD      VVD1,  --- COD_BKG_VVD VVD1," ).append("\n"); 
		query.append("BKG_COD_VVD      VVD2,  --- COD_BKG_VVD VVD2," ).append("\n"); 
		query.append("VSK_VSL_SKD      SKD,   --- VSL_SKD     SKD," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS    --- VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE   A.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = B.COD_RQST_SEQ         --- COD_SEQ" ).append("\n"); 
		query.append("--    AND B.COD_USD_FLG  (+) = 'Y'                        ---- CC_USE_IND        ---- 조건 확인" ).append("\n"); 
		query.append("AND A.BKG_NO          = D.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = D.COD_RQST_SEQ       (+)     --- COD_SEQ" ).append("\n"); 
		query.append("AND D.COD_HIS_SEQ          =                           --- CH_SEQ" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(COD_HIS_SEQ)                       --- CH_SEQ" ).append("\n"); 
		query.append("FROM   BKG_COD_HIS B                                ---COD_HIS B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.COD_RQST_SEQ       = B.COD_RQST_SEQ         --- COD_SEQ" ).append("\n"); 
		query.append("--            AND    B.COD_STS_CD    = 'CFR'                                            ---- 조건 확인" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.BKG_NO          = VVD1.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = VVD1.COD_RQST_SEQ   (+)    --- VVD1.COD_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO          = CNTR.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = CNTR.COD_RQST_SEQ    (+)    --- CNTR.COD_SEQ" ).append("\n"); 
		query.append("AND 0                 = VVD1.VSL_SEQ   (+)             --- CBV_BV_SEQ" ).append("\n"); 
		query.append("AND 'T'               = VVD1.VSL_PRE_PST_CD(+)      ---CBV_BV_IND" ).append("\n"); 
		query.append("AND 'O'                 = VVD1.VVD_OP_CD   (+)       --- CBV_ON_IND" ).append("\n"); 
		query.append("AND A.BKG_NO          = VVD2.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = VVD2.COD_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND VVD2.VSL_CD IS NOT NULL                    -------------------추가사항 (2010.02.09)" ).append("\n"); 
		query.append("AND 0                 = VVD2.VSL_SEQ   (+)     --- CBV_BV_SEQ" ).append("\n"); 
		query.append("AND 'T'               = VVD2.VSL_PRE_PST_CD(+)      ---CBV_BV_IND" ).append("\n"); 
		query.append("AND 'N'                 = VVD2.VVD_OP_CD (+)     ---CBV_ON_IND" ).append("\n"); 
		query.append("AND SKD.VSL_CD        = VVD1.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VVD1.SKD_VOY_NO             ---SKD_VOYAGE_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD    = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SKD.VSL_CD        = VPS.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VPS.SKD_VOY_NO              ---SKD_VOYAGE_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD    = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD    = SUBSTR (VVD1.POL_YD_CD,1, 5)            --- VPS.VPS_LOC_CD,  VVD1.CBV_POL_LOC" ).append("\n"); 
		query.append("AND VPS.CLPT_IND_SEQ = 1                            --VPS.VPS_CALL_IND  = 1" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.BKG_NO       ," ).append("\n"); 
		query.append("A.COD_RQST_OFC_CD    ,    NVL(A.COD_RHND_PORT_CD,SUBSTR (VVD1.POL_YD_CD,1 ,5)),            --- CA_OFC_CD,CA_REH_PORT,CBV_POL_LOC" ).append("\n"); 
		query.append("VVD1.VSL_CD    ,    VVD1.SKD_VOY_NO      , VVD1.SKD_DIR_CD ,      --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD2.VSL_CD    ,    VVD2.SKD_VOY_NO      , VVD2.SKD_DIR_CD ,      ---- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VSL_SLAN_CD    ,    VPS.INIT_ETD_DT       ,   --- VPS. VPS_ETD_DT,  SLN_LANE_CD" ).append("\n"); 
		query.append("B.CHG_CD,                            ---B.CC_CHARGE    ," ).append("\n"); 
		query.append("B.CURR_CD,                            --- B.CC_CURRENCY     ," ).append("\n"); 
		query.append("B.CHG_AMT   ,                       ---- B.CC_AMOUNT      ," ).append("\n"); 
		query.append("TO_CHAR(D.CRE_DT  , 'YYYYMMDD')     ,        --- CH_ISS_DT" ).append("\n"); 
		query.append("D.CRE_DT             --- CH_ISS_DT" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append(", BKG_CHG_RT B, TRS_EXPN_AUD_RMK C" ).append("\n"); 
		query.append("WHERE   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND     A.COD_CHG_CD = B.CHG_CD(+)" ).append("\n"); 
		query.append("AND     A.BKG_NO        = C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_port}!='')" ).append("\n"); 
		query.append("AND 	A.COD_PORT_CD  = @[input_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_fmMonth}!='' && ${input_toMonth}!='' && ${input_fmMonth}!='YYYYMM' && ${input_toMonth}!='YYYYMM')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	TO_CHAR(A.COD_CFM_DT, 'YYYYMM') BETWEEN @[input_fmMonth] AND @[input_toMonth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_office}!='')" ).append("\n"); 
		query.append("AND 	A.COD_OFC_CD = @[input_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_vvd}!='')" ).append("\n"); 
		query.append("AND 	A.COD_VSL_CD||A.COD_SKD_VOY_NO||A.COD_SKD_DIR_CD = @[input_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY 	A.COD_OFC_CD" ).append("\n"); 
		query.append(", 	A.COD_PORT_CD" ).append("\n"); 
		query.append(", 	A.COD_CHG_CD" ).append("\n"); 
		query.append(",	A.COD_VSL_CD||COD_SKD_VOY_NO||COD_SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.COD_SLAN_CD" ).append("\n"); 
		query.append(",	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append(",	TO_CHAR(A.COD_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_CHAR(A.COD_CFM_DT,'YYYYMM')" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	A.COD_CNTR_QTY" ).append("\n"); 
		query.append(",	A.COD_CHG_CURR_CD" ).append("\n"); 
		query.append(",	ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.COD_CHG_CURR_CD,A.COD_CHG_AMT, TO_CHAR(A.COD_CFM_DT,'YYYYMM')),2)" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT 	B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", B.CHG_CD" ).append("\n"); 
		query.append(", ROUND(B.CHG_AMT,0) BL_AMT" ).append("\n"); 
		query.append(", TO_CHAR(A.COD_CFM_DT, 'YYYYMM') COD_CFM_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("----VSK_COD_IF A---" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.BKG_NO                                    BKG_NO," ).append("\n"); 
		query.append("A.COD_RQST_OFC_CD                              COD_OFC_CD,        --- A.CA_OFC_CD" ).append("\n"); 
		query.append("NVL(A.COD_RHND_PORT_CD,SUBSTR (VVD1.POL_YD_CD, 1, 5))         COD_PORT_CD,       --- A.CA_REH_PORT , VVD1.CBV_POL_LOC" ).append("\n"); 
		query.append("VVD1.VSL_CD                                 COD_VSL_CD," ).append("\n"); 
		query.append("VVD1.SKD_VOY_NO                             COD_SKD_VOY_NO,   --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD1.SKD_DIR_CD                             COD_SKD_DIR_CD," ).append("\n"); 
		query.append("VVD2.VSL_CD                                 VSL_CD," ).append("\n"); 
		query.append("VVD2.SKD_VOY_NO                             SKD_VOY_NO,       --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD2.SKD_DIR_CD                             SKD_DIR_CD," ).append("\n"); 
		query.append("SKD.VSL_SLAN_CD                             COD_SLAN_CD,   --- SLN_LANE_CD" ).append("\n"); 
		query.append("VPS.INIT_ETD_DT                             COD_ETD_DT,   ---- VPS_ETD_DT" ).append("\n"); 
		query.append("COUNT(CNTR_NO)                              COD_CNTR_QTY," ).append("\n"); 
		query.append("B.CHG_CD                                     COD_CHG_CD,   --- B.CC_CHARGE" ).append("\n"); 
		query.append("B.CURR_CD                                  COD_CHG_CURR_CD,   --- B.CC_CURRENCY" ).append("\n"); 
		query.append("B.CHG_AMT                                  COD_CHG_AMT,   ---B.CC_AMOUNT" ).append("\n"); 
		query.append("TO_CHAR(D.CRE_DT  , 'YYYYMMDD')          COD_CRE_DT,      --- D.CH_ISS_DT" ).append("\n"); 
		query.append("D.CRE_DT                                 COD_CFM_DT      --- D.CH_ISS_DT" ).append("\n"); 
		query.append("FROM    BKG_COD      A,     --- COD_APPL    A," ).append("\n"); 
		query.append("BKG_COD_COST     B,     --- COD_COST    B," ).append("\n"); 
		query.append("BKG_COD_HIS      D,     --- COD_HIS     D," ).append("\n"); 
		query.append("BKG_COD_CNTR     CNTR,  --- COD_CNTR    CNTR," ).append("\n"); 
		query.append("BKG_COD_VVD      VVD1,  --- COD_BKG_VVD VVD1," ).append("\n"); 
		query.append("BKG_COD_VVD      VVD2,  --- COD_BKG_VVD VVD2," ).append("\n"); 
		query.append("VSK_VSL_SKD      SKD,   --- VSL_SKD     SKD," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS    --- VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE   A.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = B.COD_RQST_SEQ         --- COD_SEQ" ).append("\n"); 
		query.append("--    AND B.COD_USD_FLG  (+) = 'Y'                        ---- CC_USE_IND" ).append("\n"); 
		query.append("AND A.BKG_NO          = D.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = D.COD_RQST_SEQ       (+)     --- COD_SEQ" ).append("\n"); 
		query.append("AND D.COD_HIS_SEQ          =                           --- CH_SEQ" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(COD_HIS_SEQ)                       --- CH_SEQ" ).append("\n"); 
		query.append("FROM   BKG_COD_HIS B                                ---COD_HIS B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.COD_RQST_SEQ       = B.COD_RQST_SEQ         --- COD_SEQ" ).append("\n"); 
		query.append("--            AND    B.COD_STS_CD    = 'CFR'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.BKG_NO          = VVD1.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = VVD1.COD_RQST_SEQ   (+)    --- VVD1.COD_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO          = CNTR.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = CNTR.COD_RQST_SEQ    (+)    --- CNTR.COD_SEQ" ).append("\n"); 
		query.append("AND 0                 = VVD1.VSL_SEQ   (+)             --- CBV_BV_SEQ" ).append("\n"); 
		query.append("AND 'T'               = VVD1.VSL_PRE_PST_CD(+)      ---CBV_BV_IND" ).append("\n"); 
		query.append("AND 'O'                 = VVD1.VVD_OP_CD   (+)       --- CBV_ON_IND" ).append("\n"); 
		query.append("AND VVD2.VSL_CD IS NOT NULL                    -------------------추가사항 (2010.02.09)" ).append("\n"); 
		query.append("AND A.BKG_NO          = VVD2.BKG_NO        (+)" ).append("\n"); 
		query.append("AND A.COD_RQST_SEQ         = VVD2.COD_RQST_SEQ  (+)" ).append("\n"); 
		query.append("AND 0                 = VVD2.VSL_SEQ   (+)     --- CBV_BV_SEQ" ).append("\n"); 
		query.append("AND 'T'               = VVD2.VSL_PRE_PST_CD(+)      ---CBV_BV_IND" ).append("\n"); 
		query.append("AND 'N'                 = VVD2.VVD_OP_CD (+)     ---CBV_ON_IND" ).append("\n"); 
		query.append("AND SKD.VSL_CD        = VVD1.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VVD1.SKD_VOY_NO             ---SKD_VOYAGE_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD    = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SKD.VSL_CD        = VPS.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VPS.SKD_VOY_NO              ---SKD_VOYAGE_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD    = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD    = SUBSTR (VVD1.POL_YD_CD, 1, 5)            --- VPS.VPS_LOC_CD,  VVD1.CBV_POL_LOC" ).append("\n"); 
		query.append("AND VPS.CLPT_IND_SEQ = 1                            --VPS.VPS_CALL_IND  = 1" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.BKG_NO       ," ).append("\n"); 
		query.append("A.COD_RQST_OFC_CD    ,    NVL(A.COD_RHND_PORT_CD, SUBSTR (VVD1.POL_YD_CD, 1, 5)),            --- CA_OFC_CD,CA_REH_PORT,CBV_POL_LOC" ).append("\n"); 
		query.append("VVD1.VSL_CD    ,    VVD1.SKD_VOY_NO      , VVD1.SKD_DIR_CD ,      --- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VVD2.VSL_CD    ,    VVD2.SKD_VOY_NO      , VVD2.SKD_DIR_CD ,      ---- SKD_VOYAGE_NO" ).append("\n"); 
		query.append("VSL_SLAN_CD    ,    VPS.INIT_ETD_DT       ,   --- VPS. VPS_ETD_DT,  SLN_LANE_CD" ).append("\n"); 
		query.append("B.CHG_CD,                            ---B.CC_CHARGE    ," ).append("\n"); 
		query.append("B.CURR_CD,                            --- B.CC_CURRENCY     ," ).append("\n"); 
		query.append("B.CHG_AMT   ,                       ---- B.CC_AMOUNT      ," ).append("\n"); 
		query.append("TO_CHAR(D.CRE_DT  , 'YYYYMMDD')     ,        --- CH_ISS_DT" ).append("\n"); 
		query.append("D.CRE_DT                                 --- CH_ISS_DT" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append(", BKG_CHG_RT B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.CHG_CD IN ('DVC', 'DIV', 'ADF', 'FDR', 'OLO', 'RLO', 'DLO', 'SCR')" ).append("\n"); 
		query.append("#if (${input_port}!='')" ).append("\n"); 
		query.append("AND 	A.COD_PORT_CD  = @[input_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_fmMonth}!='' && ${input_toMonth}!='' && ${input_fmMonth}!='YYYYMM' && ${input_toMonth}!='YYYYMM')" ).append("\n"); 
		query.append("AND 	TO_CHAR(A.COD_CFM_DT, 'YYYYMM') BETWEEN @[input_fmMonth] AND @[input_toMonth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_office}!='')" ).append("\n"); 
		query.append("AND 	A.COD_OFC_CD = @[input_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_vvd}!='')" ).append("\n"); 
		query.append("AND 	A.COD_VSL_CD||A.COD_SKD_VOY_NO||A.COD_SKD_DIR_CD = @[input_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.BKG_NO,CHG_CD, B.CHG_AMT, A.COD_CFM_DT, B.CRE_DT" ).append("\n"); 
		query.append("ORDER BY B.CHG_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append(",	MAX(NVL(FM_CLT_CNG_OFC_N3PTY_NO, N3PTY_NO)) TPB_NO" ).append("\n"); 
		query.append(",	MAX(DECODE(FM_CLT_CNG_OFC_N3PTY_NO,NULL, NULL, N3PTY_NO)) NEW_TPB_NO" ).append("\n"); 
		query.append(",	MAX(IF_OFC_CD) ROC_OFC" ).append("\n"); 
		query.append(",	MAX(DECODE(VNDR_CUST_DIV_CD, 'V',VNDR_CNT_CD||VNDR_SEQ, 'C', CUST_CNT_CD||CUST_SEQ, N3PTY_OFC_CD)) PTY_3RD" ).append("\n"); 
		query.append(", 	SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CFM_CURR_CD, CFM_AMT, TO_CHAR(CFM_DT,'YYYYMM')),2)) AMT_USD" ).append("\n"); 
		query.append("FROM    TPB_OTS_DTL" ).append("\n"); 
		query.append("WHERE  	N3PTY_BIL_TP_CD = 'RH'" ).append("\n"); 
		query.append("AND     N3PTY_EXPN_TP_CD = 'TES'" ).append("\n"); 
		query.append("AND		N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND     BKG_NO is not null" ).append("\n"); 
		query.append("--          AS-IS도 수정이 필요할 것으로 예상됨" ).append("\n"); 
		query.append("--		    AND  	N3PTY_NO = (SELECT MAX(NVL(FM_CLT_CNG_OFC_N3PTY_NO, N3PTY_NO))" ).append("\n"); 
		query.append("--		   						FROM    TPB_OTS_DTL" ).append("\n"); 
		query.append("--		           				WHERE  	N3PTY_BIL_TP_CD = 'RH'" ).append("\n"); 
		query.append("--		                		AND     N3PTY_EXPN_TP_CD = 'TES'" ).append("\n"); 
		query.append("--		                		AND     N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("--		                		AND     BKG_NO is not null)" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${input_port}!='')" ).append("\n"); 
		query.append("AND 	A.COD_PORT_CD  = @[input_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_fmMonth}!='' && ${input_toMonth}!='' && ${input_fmMonth}!='YYYYMM' && ${input_toMonth}!='YYYYMM')" ).append("\n"); 
		query.append("AND 	TO_CHAR(TO_DATE(A.COD_CFM_DT, 'YYYYMM'),'YYYYMM') BETWEEN @[input_fmMonth] AND @[input_toMonth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_office}!='')" ).append("\n"); 
		query.append("AND 	A.COD_OFC_CD = @[input_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${input_vvd}!='')" ).append("\n"); 
		query.append("AND 	A.COD_VVD =  @[input_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY 	A.COD_OFC_CD" ).append("\n"); 
		query.append(",	A.COD_PORT_CD" ).append("\n"); 
		query.append(",	A.COD_VVD" ).append("\n"); 
		query.append(",	A.COD_SLAN_CD" ).append("\n"); 
		query.append(",	A.VVD" ).append("\n"); 
		query.append(",	A.COD_ETD_DT" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append(",	A.COD_CNTR_QTY" ).append("\n"); 
		query.append(",	A.COD_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY  COD_OFC_CD" ).append("\n"); 
		query.append(", COD_PORT_CD" ).append("\n"); 
		query.append(", COD_VVD" ).append("\n"); 
		query.append(", COD_SLAN_CD" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append(", COD_ETD_DT" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", BL_AMT" ).append("\n"); 
		query.append("ORDER BY  COD_ETD_DT DESC)" ).append("\n"); 
		query.append("GROUP BY  COD_OFC_CD" ).append("\n"); 
		query.append(", COD_PORT_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append("ORDER BY  COD_ETD_DT DESC" ).append("\n"); 

	}
}