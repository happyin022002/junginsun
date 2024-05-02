/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailSoManageDBDAOSearch06RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.03 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch06RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail O/B SO 대상 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch06RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unplanned",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch06RailSoManageRSQL").append("\n"); 
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
		query.append("SELECT Y.*" ).append("\n"); 
		query.append("  FROM (			" ).append("\n"); 
		query.append("select X.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,X.EQ_NO" ).append("\n"); 
		query.append("      ,X.SC_NO" ).append("\n"); 
		query.append("      ,X.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.POR_NOD_CD, 1, 5) AS POR_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.POR_NOD_CD, 6) AS POR_NOD_CD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(X.FM_NOD_CD, 1, 5) AS FM_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.FM_NOD_CD, 6) AS FM_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(X.TO_NOD_CD, 1, 5) AS TO_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.TO_NOD_CD, 6) AS TO_NOD_YARD" ).append("\n"); 
		query.append("      ,X.POR_CD AS POR_CD" ).append("\n"); 
		query.append("      ,X.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.DEL_NOD_CD, 1, 5) AS DEL_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.DEL_NOD_CD, 6) AS DEL_NOD_CD_YARD" ).append("\n"); 
		query.append("	  ,(SELECT LOC_NM FROM MDM_LOCATION  WHERE LOC_CD = SUBSTR(X.DEL_NOD_CD, 1, 5) AND NVL(DELT_FLG, 'N') <> 'Y') DEL_NOD_CD_NM" ).append("\n"); 
		query.append("      ,X.DEL_SCC_CD AS DEL_SCC_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.POL_NOD_CD, 1, 5) AS POL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.POL_NOD_CD, 6) AS POL_CD_YARD" ).append("\n"); 
		query.append("	  ,(SELECT LOC_NM FROM MDM_LOCATION  WHERE LOC_CD = SUBSTR(X.POL_NOD_CD, 1, 5) AND NVL(DELT_FLG, 'N') <> 'Y') POL_CD_NM" ).append("\n"); 
		query.append("      ,SUBSTR(X.POD_NOD_CD, 1, 5) AS POD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.POD_NOD_CD, 6) AS POD_CD_YARD" ).append("\n"); 
		query.append("      ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS') AS N1ST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      ,TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD') AS LST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS') AS LST_NOD_PLN_DT_HMS" ).append("\n"); 
		query.append("      ,X.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,X.BKG_RCVDE_TERM_CD AS BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("      ,(SELECT LISTAGG(DECODE(NVL(U.EQ_SUBST_CGO_QTY, 0), 0, U.CNTR_TPSZ_CD || ' ' || U.OP_CNTR_QTY, U.CNTR_TPSZ_CD || ' ' || U.OP_CNTR_QTY || '-SUB ' || U.EQ_SUBST_CNTR_TPSZ_CD || ' ' || U.EQ_SUBST_CGO_QTY), ', ') WITHIN GROUP(ORDER BY U.CNTR_TPSZ_CD) FROM BKG_QUANTITY U WHERE U.BKG_NO = X.BKG_NO) AS BKG_QTY" ).append("\n"); 
		query.append("      ,X.CGO_TP_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("      ,X.BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,SUBSTR(X.BKG_SPCL, 0, LENGTH(X.BKG_SPCL) - 1) AS BKG_SPE" ).append("\n"); 
		query.append("      ,CASE WHEN SUBSTR(X.BKG_CNTR_SPCL, 0, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) - 1) = 'Y' THEN 'AD'" ).append("\n"); 
		query.append("            WHEN SUBSTR(X.BKG_CNTR_SPCL, 0, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 4) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - 1) = 'Y' THEN 'RD'" ).append("\n"); 
		query.append("            WHEN SUBSTR(X.BKG_CNTR_SPCL, 0, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) = 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) - 1) != 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 4) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - 1) != 'Y' THEN 'DG'" ).append("\n"); 
		query.append("            WHEN SUBSTR(X.BKG_CNTR_SPCL, 0, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) != 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) - 1) = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("            WHEN SUBSTR(X.BKG_CNTR_SPCL, 0, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) != 'Y'" ).append("\n"); 
		query.append("             AND SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 4) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 3) - 1) = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("            WHEN SUBSTR(X.BKG_CNTR_SPCL, INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) + 1, INSTR(X.BKG_CNTR_SPCL, '^', 1, 2) - INSTR(X.BKG_CNTR_SPCL, '^', 1, 1) - 1) = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("            ELSE 'GP'" ).append("\n"); 
		query.append("       END AS SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 1) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,BKG_CNTR_QTY AS PCK_QTY" ).append("\n"); 
		query.append("      ,NVL(X.B_PCK_TP_CD, 'PC') AS PCK_TP_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.MDM_CO, INSTR(X.MDM_CO, '$', 1, 1) + 1) AS CMDT_NAME" ).append("\n"); 
		query.append("      ,X.VVD_CD AS TRUNKVVD" ).append("\n"); 
		query.append("      ,X.SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(AES_INLND_TRNS_NO) FROM BKG_XPT_IMP_LIC WHERE BKG_NO = X.BKG_NO AND IO_BND_CD = 'O' AND CNT_CD = 'US' AND ROWNUM = 1) AUTO_XPT_SYS_NO" ).append("\n"); 
		query.append("      ,'' AS REQUEST_SP" ).append("\n"); 
		query.append("      ,X.IBD_CSTMS_CLR_LOC_CD AS IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.MDM_CO, 1, INSTR(X.MDM_CO, '$', 1, 1) - 1) AS CMDT_CD" ).append("\n"); 
		query.append("      ,X.SHPR_CUST_NM AS SHPR_CUST_NM" ).append("\n"); 
		query.append("      ,X.CNEE_CUST_NM AS CNEE_CUST_NM" ).append("\n"); 
		query.append("      ,X.TRSP_SO_OFC_CTY_CD AS TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,X.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,X.UPD_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,X.RAIL_CMB_THRU_TP_CD AS RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("      ,X.COP_NO AS COP_NO" ).append("\n"); 
		query.append("      ,X.COST_ACT_GRP_SEQ AS COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      ,X.ACT_GRP_CD AS ACT_GRP_CD" ).append("\n"); 
		query.append("      ,X.ROUT_ORG_NOD_CD AS ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("      ,X.ROUT_DEST_NOD_CD AS ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("      ,X.ROUT_SEQ AS ROUT_SEQ" ).append("\n"); 
		query.append("      ,X.BKG_CGO_TP_CD AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,X.ROUT_PLN_CD AS ROUT_PLN_CD" ).append("\n"); 
		query.append("      ,X.INLND_ROUT_RMK AS INLND_ROUT_RMK" ).append("\n"); 
		query.append("      ,X.TRSP_COST_DTL_MOD_CD AS TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,X.CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("      ,X.CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("      ,DECODE(X.INTER_RMK_CHK, '', '', 'Y') AS INTER_RMK" ).append("\n"); 
		query.append("      ,0 ROUT_DTL_SEQ" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID1, 1, 5) AS INTERCHANGE1_LOC" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID1, 6) AS INTERCHANGE1_NOD" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID2, 1, 5) AS INTERCHANGE2_LOC" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID2, 6) AS INTERCHANGE2_NOD" ).append("\n"); 
		query.append("      ,X.INV_BIL_PATT_DIV_FLG AS INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append("      ,X.REF_NO" ).append("\n"); 
		query.append("      ,SUBSTR(X.FM_NOD_CD, 1, 5) AS ORG_FM_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.FM_NOD_CD, 6) AS ORG_FM_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(X.TO_NOD_CD, 1, 5) AS ORG_TO_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(X.TO_NOD_CD, 6) AS ORG_TO_NOD_YARD" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN EZ_TPSZ_FT = '20' AND CNTR_WGT1 >= DECODE(X.FIRST_VNDR, 'CN', 47901, 43000) THEN 'Y'" ).append("\n"); 
		query.append("         WHEN EZ_TPSZ_FT = '40' AND CNTR_WGT1 >= DECODE(X.FIRST_VNDR, 'CN', 60001, 45000) THEN 'Y'" ).append("\n"); 
		query.append("         WHEN EZ_TPSZ_FT = '45' AND CNTR_WGT1 >= DECODE(X.FIRST_VNDR, 'CN', 60001, 42700) THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END OVERWEIGHT" ).append("\n"); 
		query.append("      ,X.EZ_TPSZ_FT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(X.STCC_STR, '[^|]+', 1, 1) STCC_CD" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(X.STCC_STR, '[^|]+', 1, 2) STCC_DESC" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(X.STCC_STR, '[^|]+', 1, 3) STCC_POP_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN X.STCC_CGO_USE_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("            ELSE (SELECT STCC_RSTR_FLG FROM TRS_STCC_CD_RSTR WHERE STCC_CD = REGEXP_SUBSTR(X.STCC_STR, '+[^|]+', 1, 1))" ).append("\n"); 
		query.append("       END STCC_RSTR_FLG" ).append("\n"); 
		query.append("      ,X.STCC_CGO_USE_FLG" ).append("\n"); 
		query.append("      ,X.CNTR_WGT1 CNTR_WGT" ).append("\n"); 
		query.append("      ,X.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("      ,NVL2(BKG.STOP_OFF_LOC_CD, 'Y', 'N') STOP_OFF_FLG" ).append("\n"); 
		query.append("      ,BKG.STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("      ,BKG.STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,BKG.STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,BKG.STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("      ,DECODE(X.YD_CHR_CD, 'N', 'ON DOCK', 'F', 'OFF DOCK', '') YD_CHR_CD" ).append("\n"); 
		query.append("      ,X.CNMV_STS_CD" ).append("\n"); 
		query.append("      ,X.CRNT_YD_CD" ).append("\n"); 
		query.append("      ,X.CNMV_DT" ).append("\n"); 
		query.append("      ,X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN MIN(A.CRE_DT) + 15 >= SYSDATE THEN 'Y' END " ).append("\n"); 
		query.append("         FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("        WHERE ((A.EQ_NO = X.EQ_NO AND A.CGO_TP_CD = 'F' AND A.TRSP_BND_CD = 'O') OR (A.EQ_NO = X.EQ_NO AND A.CGO_TP_CD = 'M'))" ).append("\n"); 
		query.append("			AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND NOT EXISTS(SELECT ''" ).append("\n"); 
		query.append("                             FROM TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("                            WHERE A.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("		) OLD_DATA" ).append("\n"); 
		query.append("      ,X.DCGO_FLG" ).append("\n"); 
		query.append("      ,X.DCGO_SEQ" ).append("\n"); 
		query.append("	  ,X.DG_CNTR_SEQ" ).append("\n"); 
		query.append("	  ,(SELECT B.DCGO_FLG FROM BKG_BOOKING B WHERE B.BKG_NO = X.BKG_NO) BKG_DCGO_FLG" ).append("\n"); 
		query.append("      ,TRIM(X.DECL_NM) DECL_NM" ).append("\n"); 
		query.append("      ,CASE WHEN (SUBSTR(X.FM_NOD_CD, 1, 2) = 'CA' OR SUBSTR(X.TO_NOD_CD,1,2) = 'CA') " ).append("\n"); 
		query.append("        AND  (NVL(X.SHIP_CUST_NM, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.SHIP_ADDR, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.SHIP_CTY_NM, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.SHIP_STE_CD, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.SHIP_CNT_CD, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.SHIP_CUST_ZIP_ID, 'X') = 'X'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		 AND X.DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("           THEN 'N'" ).append("\n"); 
		query.append("        ELSE 'Y'     " ).append("\n"); 
		query.append("      END SHIP_VLD_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN (SUBSTR(X.FM_NOD_CD, 1, 2) = 'CA' OR SUBSTR(X.TO_NOD_CD,1,2) = 'CA') " ).append("\n"); 
		query.append("        AND  (NVL(X.CON_CUST_NM, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.CON_ADDR, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.CON_CTY_NM, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.CON_STE_CD, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.CON_CNT_CD, 'X') = 'X' " ).append("\n"); 
		query.append("           OR NVL(X.CON_CUST_ZIP_ID, 'X') = 'X'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		 AND X.DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("           THEN 'N'" ).append("\n"); 
		query.append("        ELSE 'Y'     " ).append("\n"); 
		query.append("      END CON_VLD_FLG" ).append("\n"); 
		query.append("      ,BKG.RAIL_BLK_CD" ).append("\n"); 
		query.append("	  ,CASE  (select bb.dcgo_flg from bkg_booking bb where bb.bkg_no = X.BKG_NO) " ).append("\n"); 
		query.append("			WHEN 'Y' THEN " ).append("\n"); 
		query.append("				 ( 	select count(*)" ).append("\n"); 
		query.append("					from bkg_container bc" ).append("\n"); 
		query.append("						,bkg_dg_cgo    cg" ).append("\n"); 
		query.append("					where 1 = 1" ).append("\n"); 
		query.append("					and bc.bkg_no = cg.bkg_no" ).append("\n"); 
		query.append("					and bc.cntr_no = cg.cntr_no" ).append("\n"); 
		query.append("					and bc.bkg_no = X.BKG_NO" ).append("\n"); 
		query.append("					and bc.dcgo_flg = 'Y'" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("			ELSE 0" ).append("\n"); 
		query.append("		END BKG_ATT_DG_CNT" ).append("\n"); 
		query.append("	  ,NVL(@[unplanned], 'N') UPLN_SO_FLG" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID1, 1, 5) AS ORG_INTERCHANGE1_LOC" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID1, 6) AS ORG_INTERCHANGE1_NOD" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID2, 1, 5) AS ORG_INTERCHANGE2_LOC" ).append("\n"); 
		query.append("      ,SUBSTR(X.ITCHG_LOC_ID2, 6) AS ORG_INTERCHANGE2_NOD" ).append("\n"); 
		query.append("  from (SELECT K.*" ).append("\n"); 
		query.append("              ,TRIM(REGEXP_SUBSTR(CNTR_WGT_STR, '[^|]+', 1, 1)) CNTR_WGT1" ).append("\n"); 
		query.append("              ,TRIM(REGEXP_SUBSTR(CNTR_WGT_STR, '[^|]+', 1, 2)) CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("              ,TRIM(REGEXP_SUBSTR(VNDR_STR, '[^|]+', 1, 1)) FIRST_VNDR" ).append("\n"); 
		query.append("              ,TRIM(REGEXP_SUBSTR(VNDR_STR, '[^|]+', 1, 3)) VNDR_ABBR_NM" ).append("\n"); 
		query.append("              ,TRIM(REGEXP_SUBSTR(VNDR_STR, '[^|]+', 1, 4)) REF_NO" ).append("\n"); 
		query.append("              ,(SELECT MAX(RMK.BKG_NO) FROM TRS_INTER_RMK RMK WHERE RMK.BKG_NO IN (K.BKG_NO, 'DUM000000000') AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, K.EQ_NO, 'X') AND NVL(RMK.DELT_FLG, 'X') = 'N') AS INTER_RMK_CHK" ).append("\n"); 
		query.append("          FROM (SELECT TMP.*" ).append("\n"); 
		query.append("                      ,BKG_CNTR.PCK_TP_CD AS B_PCK_TP_CD" ).append("\n"); 
		query.append("                      ,(SELECT TRS_GET_COM_SO_RAIL_WGT_FNC('RO', null, null, null, TMP.BKG_NO, TMP.EQ_NO, TMP.EQ_TPSZ_CD, 'LBS', TMP.COP_NO, DECODE(TMP.TRSP_BND_CD, 'O', 'N', 'Y')) FROM DUAL) CNTR_WGT_STR" ).append("\n"); 
		query.append("                      ,PCK_QTY AS BKG_CNTR_QTY" ).append("\n"); 
		query.append("                      ,(SELECT NVL(BKG.DCGO_FLG, ' ') || '^' || NVL(BKG.BB_CGO_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("                               NVL(BKG.AWK_CGO_FLG, ' ') || '^' || NVL(BKG.RC_FLG, ' ') || '^' ||" ).append("\n"); 
		query.append("                               NVL(BKG.RD_CGO_FLG, ' ') || '^'" ).append("\n"); 
		query.append("                          FROM BKG_CONTAINER BKG" ).append("\n"); 
		query.append("                         WHERE BKG.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("                           AND BKG.CNTR_NO = TMP.EQ_NO          " ).append("\n"); 
		query.append("                       ) BKG_CNTR_SPCL" ).append("\n"); 
		query.append("                      ,(SELECT DECODE(BKG_SPCL.DCGO_FLG, 'Y', 'DG /') || DECODE(BKG_SPCL.RC_FLG, 'Y', 'RF /') || DECODE(BKG_SPCL.AWK_CGO_FLG, 'Y', 'AK /') || DECODE(BKG_SPCL.BB_CGO_FLG, 'Y', 'BB /') || DECODE(BKG_SPCL.SPCL_HIDE_FLG, 'Y', 'HD /') || DECODE(BKG_SPCL.FD_GRD_FLG, 'Y', 'FG /') || DECODE(BKG_SPCL.RAIL_BLK_CD, '', '', 'RB /') BKG_SPE FROM BKG_BOOKING BKG_SPCL WHERE BKG_SPCL.BKG_NO = TMP.BKG_NO) BKG_SPCL" ).append("\n"); 
		query.append("                      ,(SELECT NVL(MDM_CO.CMDT_CD, ' ') || '$' || NVL(REPLACE(MDM_CO.CMDT_NM, CHR(13) || CHR(10), ' '), ' ') FROM MDM_COMMODITY MDM_CO WHERE MDM_CO.CMDT_CD = TMP.CMDT_CD) MDM_CO" ).append("\n"); 
		query.append("                      ,(SELECT CASE WHEN INSTR(CNTR_TPSZ_DESC, '20FT') > 0 THEN '20'" ).append("\n"); 
		query.append("                                 	WHEN INSTR(CNTR_TPSZ_DESC, '40FT') > 0 THEN '40'" ).append("\n"); 
		query.append("                                 	WHEN INSTR(CNTR_TPSZ_DESC, '45FT') > 0 THEN '45'" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                          FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                         WHERE CNTR_TPSZ_CD = TMP.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                           AND DELT_FLG = 'N') EZ_TPSZ_FT" ).append("\n"); 
		query.append("                      ,CASE" ).append("\n"); 
		query.append("                         WHEN BKG_CNTR.DCGO_FLG = 'Y' THEN '4950150|MIXED HAZARDOUS|N'" ).append("\n"); 
		query.append("                         WHEN TMP.CGO_TP_CD = 'M' THEN '4221130|EMPTY|N'" ).append("\n"); 
		query.append("                         WHEN NVL(CMB.STCC_CD, 'X') = 'X' THEN  '4611110|FAK|Y'" ).append("\n"); 
		query.append("                         ELSE NVL(CMB.STCC_CD, ' ') ||'|'|| NVL(CMB.TRSP_CMDT_GRP_NM, ' ') ||'|'||'Y'" ).append("\n"); 
		query.append("                       END STCC_STR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      ,CASE" ).append("\n"); 
		query.append("                         WHEN (BKG_CNTR.DCGO_FLG = 'Y' OR BKG_CNTR.RC_FLG = 'Y') THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                       END STCC_CGO_USE_FLG" ).append("\n"); 
		query.append("                      ,YD.YD_CHR_CD" ).append("\n"); 
		query.append("                      ,MST.CNMV_STS_CD AS CNMV_STS_CD" ).append("\n"); 
		query.append("                      ,MST.CRNT_YD_CD AS CRNT_YD_CD" ).append("\n"); 
		query.append("                      ,TO_CHAR(MST.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT" ).append("\n"); 
		query.append("                      ,TRS_GET_RAIL_VNDR_FNC(TMP.ROUT_ORG_NOD_CD, TMP.ROUT_DEST_NOD_CD, TMP.ROUT_SEQ, TMP.FM_NOD_CD, TMP.TO_NOD_CD) VNDR_STR" ).append("\n"); 
		query.append("					  ,BKG_CNTR.DCGO_FLG	" ).append("\n"); 
		query.append("                      ,DG.DCGO_SEQ" ).append("\n"); 
		query.append("					  ,DG.DG_CNTR_SEQ	" ).append("\n"); 
		query.append("                      ,DECL_S.CUST_NM AS SHIP_CUST_NM" ).append("\n"); 
		query.append("                      ,DECL_S.CUST_ADDR AS SHIP_ADDR" ).append("\n"); 
		query.append("                      ,DECL_S.CUST_CTY_NM AS SHIP_CTY_NM" ).append("\n"); 
		query.append("                      ,DECL_S.CUST_STE_CD AS SHIP_STE_CD" ).append("\n"); 
		query.append("                      ,DECL_S.CSTMS_DECL_CNT_CD AS SHIP_CNT_CD" ).append("\n"); 
		query.append("                      ,DECL_S.CUST_ZIP_ID AS SHIP_CUST_ZIP_ID" ).append("\n"); 
		query.append("                      ,DECL_C.CUST_NM AS CON_CUST_NM" ).append("\n"); 
		query.append("                      ,DECL_C.CUST_ADDR AS CON_ADDR" ).append("\n"); 
		query.append("                      ,DECL_C.CUST_CTY_NM AS CON_CTY_NM" ).append("\n"); 
		query.append("                      ,DECL_C.CUST_STE_CD AS CON_STE_CD" ).append("\n"); 
		query.append("                      ,DECL_C.CSTMS_DECL_CNT_CD AS CON_CNT_CD" ).append("\n"); 
		query.append("                      ,DECL_C.CUST_ZIP_ID AS CON_CUST_ZIP_ID" ).append("\n"); 
		query.append("                      ,NVL(DECL_S.DECL_NM , DECL_C.DECL_NM) DECL_NM" ).append("\n"); 
		query.append("                      ,RANK() OVER(PARTITION BY  DG.BKG_NO, DG.CNTR_NO ORDER BY DG.DCGO_SEQ) RK        " ).append("\n"); 
		query.append("                  FROM TRS_TRSP_RAIL_BIL_ORD_TMP TMP" ).append("\n"); 
		query.append("                      ,BKG_CONTAINER             BKG_CNTR" ).append("\n"); 
		query.append("                      ,BKG_DG_CGO                DG" ).append("\n"); 
		query.append("                      ,TRS_HS_CD_CMB_SET         CMB" ).append("\n"); 
		query.append("                      ,MST_CONTAINER             MST" ).append("\n"); 
		query.append("                      ,MDM_YARD                  YD" ).append("\n"); 
		query.append("                      ,BKG_DG_DECL               DECL_S" ).append("\n"); 
		query.append("                      ,BKG_DG_DECL               DECL_C" ).append("\n"); 
		query.append("					  ,BKG_BOOKING               BKG" ).append("\n"); 
		query.append("                 WHERE BKG_CNTR.BKG_NO(+) = TMP.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG_CNTR.CNTR_NO(+) = TMP.EQ_NO" ).append("\n"); 
		query.append("                   AND TMP.TRSP_RAIL_TMP_SEQ = @[trsp_rail_tmp_seq]" ).append("\n"); 
		query.append("                   AND DG.BKG_NO(+) = TMP.BKG_NO" ).append("\n"); 
		query.append("                   AND DG.CNTR_NO(+) = TMP.EQ_NO" ).append("\n"); 
		query.append("                   AND TMP.EQ_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("                  #if(${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("                   AND MST.CNMV_STS_CD = @[cnmv_sts_cd]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                   AND TMP.TO_NOD_CD = YD.YD_CD(+)" ).append("\n"); 
		query.append("                   AND DG.BKG_NO = DECL_S.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND DG.DG_CNTR_SEQ = DECL_S.DG_CNTR_SEQ(+)" ).append("\n"); 
		query.append("                   AND DECL_S.DG_DECL_SEQ(+) = 1" ).append("\n"); 
		query.append("                   AND DG.BKG_NO = DECL_C.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND DG.DG_CNTR_SEQ = DECL_C.DG_CNTR_SEQ(+)" ).append("\n"); 
		query.append("                   AND DECL_C.DG_DECL_SEQ(+) = 2" ).append("\n"); 
		query.append("                   AND TMP.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.CMDT_CD = CMB.CMDT_HS_CD(+)" ).append("\n"); 
		query.append("				) K" ).append("\n"); 
		query.append("				WHERE RK = 1" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE X.BKG_NO = BKG.BKG_NO(+)) Y" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${ovr_wgt_flg} != '')" ).append("\n"); 
		query.append("   AND Y.OVERWEIGHT = @[ovr_wgt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rest_flg} != '')" ).append("\n"); 
		query.append("   AND Y.STCC_RSTR_FLG = @[rest_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_spe} == 'G')" ).append("\n"); 
		query.append("   AND Y.BKG_SPE IS NULL" ).append("\n"); 
		query.append("#elseif (${bkg_spe} == 'O')" ).append("\n"); 
		query.append("   AND LENGTH(Y.BKG_SPE) <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}