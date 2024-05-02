/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptVolListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecExptVolListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecExptVolListRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptVolListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(RNUM, 1, '20', 2, '40', 3, '45') SIZE_ID," ).append("\n"); 
		query.append("DECODE(RNUM, 1, HYO_SUNG_20_QTY, 2, HYO_SUNG_40_QTY, 3, HYO_SUNG_45_QTY) AS HYO_SUNG_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, DAE_WOO_20_QTY, 2, DAE_WOO_40_QTY, 3, DAE_WOO_45_QTY) AS DAE_WOO_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, DONG_BU_20_QTY, 2, DONG_BU_40_QTY, 3, DONG_BU_45_QTY) AS DONG_BU_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, HYUN_DAI_20_QTY, 2, HYUN_DAI_40_QTY, 3, HYUN_DAI_45_QTY) AS HYUN_DAI_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, DONG_KUK_20_QTY, 2, DONG_KUK_40_QTY, 3, DONG_KUK_45_QTY) AS DONG_KUK_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, THRU_TS_20_QTY, 2, THRU_TS_40_QTY, 3, THRU_TS_45_QTY) AS THRU_TS_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, CUST_TS_20_QTY, 2, CUST_TS_40_QTY, 3, CUST_TS_45_QTY) AS CUST_TS_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, REV_MT_20_QTY, 2, REV_MT_40_QTY, 3, REV_MT_45_QTY) AS REV_MT_QTY," ).append("\n"); 
		query.append("DECODE(RNUM, 1, OTR_20_QTY, 2, OTR_40_QTY, 3, OTR_45_QTY) AS OTR_QTY" ).append("\n"); 
		query.append("FROM (SELECT -- 20FT --" ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '105-81-59519' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYO_SUNG_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO IN ('401-85-04303', '401-85-08615') THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DAE_WOO_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '137-85-00522' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_BU_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '416-85-06244' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYUN_DAI_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '506-85-03346' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_KUK_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'Y' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY + CC.BLK_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS THRU_TS_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'N' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY + CC.BLK_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS CUST_TS_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN BB.WHF_BL_CGO_TP_CD = 'R' THEN CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY + CC.BLK_TEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS REV_MT_20_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN NVL(CC.KR_WHF_EXPT_CD, 'Z') IN ('Z', 'D', 'B', 'X', 'N', 'S') THEN 0" ).append("\n"); 
		query.append("ELSE CC.TAX_TEU_QTY + CC.EXPT_TEU_QTY + CC.BLK_TEU_QTY" ).append("\n"); 
		query.append("END) OTR_20_QTY," ).append("\n"); 
		query.append("-- 40FT --" ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '105-81-59519' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYO_SUNG_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO IN ('401-85-04303', '401-85-08615') THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DAE_WOO_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '137-85-00522' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_BU_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '416-85-06244' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYUN_DAI_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '506-85-03346' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_KUK_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'Y' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY + CC.BLK_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS THRU_TS_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'N' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY + CC.BLK_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS CUST_TS_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN BB.WHF_BL_CGO_TP_CD = 'R' THEN CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY + CC.BLK_FEU_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS REV_MT_40_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN NVL(CC.KR_WHF_EXPT_CD, 'Z') IN ('Z', 'D', 'B', 'X', 'N', 'S') THEN 0" ).append("\n"); 
		query.append("ELSE CC.TAX_FEU_QTY + CC.EXPT_FEU_QTY + CC.BLK_FEU_QTY" ).append("\n"); 
		query.append("END) OTR_40_QTY," ).append("\n"); 
		query.append("-- 45FT --" ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '105-81-59519' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYO_SUNG_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO IN ('401-85-04303', '401-85-08615') THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DAE_WOO_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '137-85-00522' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_BU_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '416-85-06244' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS HYUN_DAI_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0 -- OT, IT등 T/S 화물은 0" ).append("\n"); 
		query.append("WHEN BB.WFG_EXPT_CD = 'S' AND BB.CUST_RGST_NO = '506-85-03346' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS DONG_KUK_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'Y' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY + CC.BLK_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS THRU_TS_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' AND BB.WHF_BL_THRU_TS_FLG = 'N' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY + CC.BLK_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS CUST_TS_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN BB.WHF_BL_CGO_TP_CD = 'R' THEN CC.TAX_45FT_QTY + CC.EXPT_45FT_QTY + CC.BLK_45FT_QTY" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) AS REV_MT_45_QTY," ).append("\n"); 
		query.append("SUM(CASE WHEN SUBSTR(BB.WHF_BND_CD, 2, 1) = 'T' THEN 0" ).append("\n"); 
		query.append("WHEN NVL(CC.KR_WHF_EXPT_CD, 'Z') IN ('Z', 'D', 'B', 'X', 'N', 'S') THEN 0" ).append("\n"); 
		query.append("ELSE CC.TAX_FEU_QTY + CC.EXPT_45FT_QTY + CC.BLK_45FT_QTY" ).append("\n"); 
		query.append("END) OTR_45_QTY" ).append("\n"); 
		query.append("FROM (SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO, MAX(B.CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B, NISADM.BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', A.WHF_POL_CD, A.WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND A.WHF_BL_STS_CD != 'D'" ).append("\n"); 
		query.append("AND A.WHF_BND_CD = DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd])" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("AND C.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("AND C.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO) AA," ).append("\n"); 
		query.append("BKG_KR_WHF_BL BB," ).append("\n"); 
		query.append("BKG_KR_WHF_RT CC" ).append("\n"); 
		query.append("WHERE BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BB.WHF_BND_CD = AA.WHF_BND_CD" ).append("\n"); 
		query.append("AND BB.BL_NO = AA.BL_NO" ).append("\n"); 
		query.append("AND CC.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND CC.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND CC.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CC.WHF_BND_CD = AA.WHF_BND_CD" ).append("\n"); 
		query.append("AND CC.BL_NO = AA.BL_NO" ).append("\n"); 
		query.append("AND CC.CHG_RT_SEQ = AA.CHG_RT_SEQ)," ).append("\n"); 
		query.append("(SELECT 1 AS RNUM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 2 FROM DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT 3 FROM DUAL)" ).append("\n"); 

	}
}