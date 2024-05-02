/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOTroEurStatusListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOTroEurStatusListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO의 Eur 구간 조회
	  * </pre>
	  */
	public PerformanceReportDBDAOTroEurStatusListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pup_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pup_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOTroEurStatusListInVORSQL").append("\n"); 
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
		query.append("SELECT TROV.RNUM ," ).append("\n"); 
		query.append("  TROV.BL_NO ," ).append("\n"); 
		query.append("  TROV.TRO_SEQ ," ).append("\n"); 
		query.append("  SUM(DECODE(GREATEST(2, SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1)), 2, BQ.OP_CNTR_QTY, 0)) TEU_A ," ).append("\n"); 
		query.append("  SUM(DECODE(GREATEST(2, SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1)), 2, 0, BQ.OP_CNTR_QTY)) TEU_B ," ).append("\n"); 
		query.append("  CFM_FLG ," ).append("\n"); 
		query.append("  TROV.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("  TRO_QTY ," ).append("\n"); 
		query.append("  TROV.CNTR_PKUP_DT ," ).append("\n"); 
		query.append("  TROV.RQST_DT ," ).append("\n"); 
		query.append("  TROV.CNTR_PKUP_YD_CD ," ).append("\n"); 
		query.append("  TROV.CNTR_RTN_YD_CD ," ).append("\n"); 
		query.append("  TROV.RCV_TERM_CD ," ).append("\n"); 
		query.append("  TROV.DE_TERM_CD ," ).append("\n"); 
		query.append("  DECODE(TROV.SO_NUMBER,'','N','Y') AS SO_FLG ," ).append("\n"); 
		query.append("  DECODE(TROV.WO_NUMBER,'','N','Y') AS WO_FLG ," ).append("\n"); 
		query.append("  TROV.ZONE_CODE ," ).append("\n"); 
		query.append("  TROV.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("  TROV.POL_CD ," ).append("\n"); 
		query.append("  TROV.POD_CD ," ).append("\n"); 
		query.append("  TROV.SO_NUMBER," ).append("\n"); 
		query.append("  TROV.WO_NUMBER," ).append("\n"); 
		query.append("  TROV.DIFF_RMK ," ).append("\n"); 
		query.append("  TROV.POR_CD ," ).append("\n"); 
		query.append("  TROV.DEL_CD ," ).append("\n"); 
		query.append("  TROV.SLAN_CD ," ).append("\n"); 
		query.append("  TROV.VVD_CD ," ).append("\n"); 
		query.append("  TROV.BKG_OFC_CD ," ).append("\n"); 
		query.append("  '' CUST_CNT_CD ," ).append("\n"); 
		query.append("  '' CUST_SEQ ," ).append("\n"); 
		query.append("  '' CUST_NM ," ).append("\n"); 
		query.append("  '' PKUP_YD_CD ," ).append("\n"); 
		query.append("  '' DOC_USR_ID, --BKG Staff" ).append("\n"); 
		query.append("  '' BKG_DT_FR ," ).append("\n"); 
		query.append("  '' BKG_DT_TO ," ).append("\n"); 
		query.append("  '' BKG_STS_CD ," ).append("\n"); 
		query.append("  '' TRO_DT_FR ," ).append("\n"); 
		query.append("  '' TRO_DT_TO ," ).append("\n"); 
		query.append("  '' PUP_DT_FR ," ).append("\n"); 
		query.append("  '' PUP_DT_TO ," ).append("\n"); 
		query.append("  '' BKG_STAFF ," ).append("\n"); 
		query.append("  '' DCGO_FLG ," ).append("\n"); 
		query.append("  '' AWK_CGO_FLG ," ).append("\n"); 
		query.append("  '' BB_CGO_FLG ," ).append("\n"); 
		query.append("  '' RD_CGO_FLG ," ).append("\n"); 
		query.append("  '' RC_FLG ," ).append("\n"); 
		query.append("  'H' H_LINE_TYPE ," ).append("\n"); 
		query.append("  'D' D_LINE_TYPE ," ).append("\n"); 
		query.append("  '' MDST ," ).append("\n"); 
		query.append("  '' IO_BND_CD ," ).append("\n"); 
		query.append("  '0' TOT_SUM ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D5', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D5 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D7', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D7 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D8', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D8 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'D9', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) D9 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'DW', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) DW ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'DX', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) DX ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'R2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) R2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'R4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) R4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'R5', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) R5 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'R9', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) R9 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'F2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) F2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'F4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) F4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'F5', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) F5 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'O2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) O2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'O4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) O4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'O5', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) O5 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'S2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) S2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'S4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) S4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'T2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) T2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'T4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) T4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'A2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) A2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'A4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) A4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'A5', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) A5 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'P2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) P2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'P4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) P4 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'Z2', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) Z2 ," ).append("\n"); 
		query.append("  SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD, 'Z4', BQ.OP_CNTR_QTY)), 0)) / COUNT(TROV.BL_NO) OVER (PARTITION BY TROV.BL_NO, TROV.CNTR_TPSZ_CD) Z4 ," ).append("\n"); 
		query.append("  TROV.SUBGROUP_TITLE " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ROWNUM RNUM ," ).append("\n"); 
		query.append("      BL_NO ," ).append("\n"); 
		query.append("      BKG_NO ," ).append("\n"); 
		query.append("      TRO_SEQ ," ).append("\n"); 
		query.append("      CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("      CFM_FLG ," ).append("\n"); 
		query.append("      TRO_QTY ," ).append("\n"); 
		query.append("      CNTR_PKUP_DT ," ).append("\n"); 
		query.append("      CNTR_PKUP_YD_CD ," ).append("\n"); 
		query.append("      CNTR_RTN_YD_CD ," ).append("\n"); 
		query.append("      RCV_TERM_CD ," ).append("\n"); 
		query.append("      DE_TERM_CD ," ).append("\n"); 
		query.append("      RQST_DT ," ).append("\n"); 
		query.append("      DIFF_RMK ," ).append("\n"); 
		query.append("      POR_CD ," ).append("\n"); 
		query.append("      POL_CD ," ).append("\n"); 
		query.append("      POD_CD ," ).append("\n"); 
		query.append("      DEL_CD ," ).append("\n"); 
		query.append("      SLAN_CD ," ).append("\n"); 
		query.append("      VVD_CD ," ).append("\n"); 
		query.append("      EQ_CTRL_OFC_CD ," ).append("\n"); 
		query.append("      BKG_OFC_CD ," ).append("\n"); 
		query.append("      SO_FLG," ).append("\n"); 
		query.append("	  WO_FLG," ).append("\n"); 
		query.append("      ZONE_CODE ," ).append("\n"); 
		query.append("      SO_NUMBER ," ).append("\n"); 
		query.append("	  WO_NUMBER ," ).append("\n"); 
		query.append("       STR || (" ).append("\n"); 
		query.append("        SELECT '	SubTotal : ' || BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                SELECT TRO2.CNTR_TPSZ_CD || '-'|| SUM(1) TRO_QTY" ).append("\n"); 
		query.append("                FROM BKG_BOOKING VB2 ," ).append("\n"); 
		query.append("                  BKG_EUR_TRO TRO2 ," ).append("\n"); 
		query.append("                  BKG_EUR_TRO_DTL TROD2" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND TRO2.BKG_NO = TROD2.BKG_NO(+)" ).append("\n"); 
		query.append("                  AND TRO2.TRO_SEQ = TROD2.TRO_SEQ(+)" ).append("\n"); 
		query.append("                  AND TRO2.IO_BND_CD = TROD2.IO_BND_CD(+)" ).append("\n"); 
		query.append("                  AND VB2.BKG_NO = TRO2.BKG_NO(+)" ).append("\n"); 
		query.append("                  AND VB2.SLAN_CD = T.SLAN_CD" ).append("\n"); 
		query.append("                  AND VB2.VSL_CD = T.VSL_CD --CMLB0039E" ).append("\n"); 
		query.append("                  AND VB2.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VB2.SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND TRO2.CNTR_PKUP_DT = TO_DATE( T.CNTR_PKUP_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                  AND NVL(TRO2.CNTR_PKUP_YD_CD, ' ') = NVL(T.CNTR_PKUP_YD_CD, ' ')" ).append("\n"); 
		query.append("                GROUP BY TRO2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ORDER BY TRO2.CNTR_TPSZ_CD ) )" ).append("\n"); 
		query.append("        FROM DUAL ) SUBGROUP_TITLE " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          VB.BL_NO ," ).append("\n"); 
		query.append("          VB.BKG_NO ," ).append("\n"); 
		query.append("          TRO.TRO_SEQ ," ).append("\n"); 
		query.append("          TRO.CFM_FLG," ).append("\n"); 
		query.append("          TRO.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          1 AS TRO_QTY," ).append("\n"); 
		query.append("          TO_CHAR(TRO.CNTR_PKUP_DT, 'YYYY-MM-DD') CNTR_PKUP_DT ," ).append("\n"); 
		query.append("          TRO.CNTR_PKUP_YD_CD ," ).append("\n"); 
		query.append("          TRO.CNTR_RTN_YD_CD ," ).append("\n"); 
		query.append("          VB.RCV_TERM_CD ," ).append("\n"); 
		query.append("          VB.DE_TERM_CD ," ).append("\n"); 
		query.append("          DECODE(TRO.SO_CTY_CD, '', 'N', 'Y') AS SO_FLG," ).append("\n"); 
		query.append("		  DECODE(SO.TRSP_WO_OFC_CTY_CD || TRIM(TO_CHAR(SO.TRSP_WO_SEQ, '00000009')), '', 'N', 'Y') AS WO_FLG," ).append("\n"); 
		query.append("          TO_CHAR(NVL(TRO.CFM_UPD_DT,TRO.CFM_DT), 'YYYY-MM-DD') RQST_DT ," ).append("\n"); 
		query.append("          Translate(NVL(TRO.SPCL_INSTR_RMK, ' '), chr(13)||chr(10), ' ') DIFF_RMK ," ).append("\n"); 
		query.append("          VB.POR_CD ," ).append("\n"); 
		query.append("          VB.POL_CD ," ).append("\n"); 
		query.append("          VB.POD_CD ," ).append("\n"); 
		query.append("          VB.DEL_CD ," ).append("\n"); 
		query.append("          VB.SLAN_CD ," ).append("\n"); 
		query.append("          VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD VVD_CD ," ).append("\n"); 
		query.append("          VB.VSL_CD ," ).append("\n"); 
		query.append("          VB.SKD_VOY_NO ," ).append("\n"); 
		query.append("          VB.SKD_DIR_CD ," ).append("\n"); 
		query.append("          VB.EQ_CTRL_OFC_CD ,--EQ OFFICE" ).append("\n"); 
		query.append("          VB.BKG_OFC_CD ," ).append("\n"); 
		query.append("          DECODE(TRO.HLG_TP_CD, 'M', TRO.SO_CTY_CD || TRIM(TO_CHAR(TRO.SO_SEQ_NO, '00000009'))" ).append("\n"); 
		query.append("                           , SO.TRSP_SO_OFC_CTY_CD || TRIM(TO_CHAR(SO.TRSP_SO_SEQ, '00000009'))) SO_NUMBER ," ).append("\n"); 
		query.append("		  SO.TRSP_WO_OFC_CTY_CD || TRIM(TO_CHAR(SO.TRSP_WO_SEQ, '00000009')) WO_NUMBER ," ).append("\n"); 
		query.append("          (SELECT ZD.ZN_CD" ).append("\n"); 
		query.append("             FROM BKG_EUR_TRO_DTL ZD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND TRO.BKG_NO = ZD.BKG_NO" ).append("\n"); 
		query.append("              AND TRO.IO_BND_CD = ZD.IO_BND_CD" ).append("\n"); 
		query.append("              AND TRO.TRO_SEQ = ZD.TRO_SEQ" ).append("\n"); 
		query.append("              AND ZD.TRO_SUB_SEQ = 1) AS ZONE_CODE , " ).append("\n"); 
		query.append("          'Lane : ' || VB.SLAN_CD || " ).append("\n"); 
		query.append("          '	Trunk VVD : ' || VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD || " ).append("\n"); 
		query.append("          '	P/UP Date : ' || TO_CHAR(TRO.CNTR_PKUP_DT, 'YYYY-MM-DD') || " ).append("\n"); 
		query.append("          '	P/UP Yard : ' || TRO.CNTR_PKUP_YD_CD STR" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("          BKG_BOOKING VB ," ).append("\n"); 
		query.append("          BKG_EUR_TRO TRO ," ).append("\n"); 
		query.append("           ( SELECT distinct BKG_NO, TRO_SEQ, IO_BND_CD" ).append("\n"); 
		query.append("               FROM BKG_EUR_TRO_DTL TROD" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("        #if (${door_dt_fr} != '') " ).append("\n"); 
		query.append("         	 AND TROD.ARR_DT > TO_DATE(@[door_dt_fr], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${door_dt_to} != '') " ).append("\n"); 
		query.append("        	 AND TROD.ARR_DT <= TO_DATE(@[door_dt_to], 'YYYY-MM-DD') + 0.99999 --Door Date" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${loc_cd} != '')" ).append("\n"); 
		query.append("         	 AND TROD.LOC_CD      = @[loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${loc_yd_cd} != '') " ).append("\n"); 
		query.append("         	 AND TROD.ZN_CD       = @[loc_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("              ) TROD ," ).append("\n"); 
		query.append("          TRS_TRSP_SVC_ORD SO " ).append("\n"); 
		query.append(" --         BKG_CUSTOMER BC" ).append("\n"); 
		query.append("        WHERE  VB.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("          AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("          AND TRO.BKG_NO = SO.BKG_NO(+)" ).append("\n"); 
		query.append("          AND TRO.IO_BND_CD = SO.TRSP_BND_CD(+)" ).append("\n"); 
		query.append("          AND TRO.TRO_SEQ = SO.TRO_SEQ(+)" ).append("\n"); 
		query.append("          AND '1' = SO.TRO_SUB_SEQ(+)" ).append("\n"); 
		query.append("          AND 'N' = SO.DELT_FLG(+)" ).append("\n"); 
		query.append("          AND SO.TRSP_COST_DTL_MOD_CD(+) ='DR'" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("	      AND TRO.IO_BND_CD =   @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND TRO.BKG_NO = TROD.BKG_NO" ).append("\n"); 
		query.append("          AND TRO.TRO_SEQ = TROD.TRO_SEQ" ).append("\n"); 
		query.append("          AND TRO.IO_BND_CD = TROD.IO_BND_CD" ).append("\n"); 
		query.append("    --IPT : POR과 DEL이 같은 Continent 일 경우  OCN : POR과 DEL이 다른 Continent 일 경우" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("                       WHERE BC.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                         AND BKG_CUST_TP_CD='S'" ).append("\n"); 
		query.append("					#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("		  				 AND BC.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if (${cust_seq} != '') 				" ).append("\n"); 
		query.append("		  				 AND BC.CUST_SEQ= @[cust_seq]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if (${cust_nm} != '') " ).append("\n"); 
		query.append("		  				 AND BC.CUST_NM like @[cust_nm] || '%'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tro_ofc_cd} != '') " ).append("\n"); 
		query.append("          AND TRO.CFM_OFC_CD = @[tro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '')" ).append("\n"); 
		query.append("          AND VB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("	      AND VB.BKG_STS_CD  IN (SELECT * FROM table(BKG_SPLIT_FNC(@[bkg_sts_cd])))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${tro_staff} != '')" ).append("\n"); 
		query.append("          AND TRO.UPD_USR_ID =@[tro_staff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("		  AND VB.VSL_CD      =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		  AND VB.SKD_VOY_NO  =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		  AND VB.SKD_DIR_CD  =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		  AND VB.POL_CD        = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("		  AND VB.POD_CD        = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pup_dt_fr} != '') " ).append("\n"); 
		query.append("		  AND TRO.CNTR_PKUP_DT >= TO_DATE(@[pup_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pup_dt_to} != '') " ).append("\n"); 
		query.append("          AND  TRO.CNTR_PKUP_DT <= TO_DATE(@[pup_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dcgo_flg} !=''||${rc_flg} !=''||${awk_cgo_flg} !=''||${bb_cgo_flg} !=''||${so_flg} !='')" ).append("\n"); 
		query.append("		  AND (1=2 " ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'DG')" ).append("\n"); 
		query.append("		  OR VB.DCGO_FLG ='Y' --Special DG   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rc_flg} == 'RF') " ).append("\n"); 
		query.append("		  OR VB.RC_FLG = 'Y'		--Special RF  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} == 'AK') " ).append("\n"); 
		query.append("		  OR VB.AWK_CGO_FLG = 'Y'	--Special AK  " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${bb_cgo_flg} == 'BB') " ).append("\n"); 
		query.append("		  OR VB.BB_CGO_FLG = 'Y'	--Special BB  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${so_flg} == 'Y') " ).append("\n"); 
		query.append("          OR DECODE(TRO.HLG_TP_CD, 'M', TRO.SO_CTY_CD, SO.TRSP_SO_OFC_CTY_CD) IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	  	  AND  VB.BKG_CRE_DT > TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	  	  AND  VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999     --BKG Date" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_loc_cd} != '') " ).append("\n"); 
		query.append("	#if (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append("		AND   	TRO.CNTR_PKUP_YD_CD  = @[pkup_loc_cd] || NVL(@[pkup_yd_cd],'') " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		AND   	TRO.CNTR_PKUP_YD_CD  LIKE @[pkup_loc_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append("	AND   	TRO.CNTR_PKUP_YD_CD   LIKE NVL(@[pkup_loc_cd],'') ||  NVL(@[pkup_yd_cd],'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("	#if (${rcv_term_yd_cd} != '') " ).append("\n"); 
		query.append("		AND   	TRO.CNTR_RTN_YD_CD  = @[rcv_term_cd] || NVL(@[rcv_term_yd_cd],'') " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		AND   	TRO.CNTR_RTN_YD_CD  LIKE @[rcv_term_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("	    AND   	TRO.CNTR_RTN_YD_CD   LIKE NVL(@[rcv_term_cd],'') ||  NVL(@[rcv_term_yd_cd],'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ORDER BY 'Lane : ' || VB.SLAN_CD || " ).append("\n"); 
		query.append("                 ' Trunk VVD : ' || VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD || " ).append("\n"); 
		query.append("                 ' P/UP Date : ' || TO_CHAR(TRO.CNTR_PKUP_DT, 'YYYY-MM-DD') || " ).append("\n"); 
		query.append("                 ' P/UP Yard : ' || TRO.CNTR_PKUP_YD_CD " ).append("\n"); 
		query.append("             , VB.BL_NO " ).append("\n"); 
		query.append("             , TRO.TRO_SEQ " ).append("\n"); 
		query.append("             , TRO.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("    ) T ) TROV" ).append("\n"); 
		query.append("   ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append(" WHERE TROV.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("   AND TROV.CNTR_TPSZ_CD = BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" GROUP BY TROV.RNUM ," ).append("\n"); 
		query.append("          TROV.BL_NO ," ).append("\n"); 
		query.append("          TROV.TRO_SEQ ," ).append("\n"); 
		query.append("          TROV.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          TROV.CFM_FLG ," ).append("\n"); 
		query.append("          TROV.TRO_QTY ," ).append("\n"); 
		query.append("          TROV.CNTR_PKUP_DT ," ).append("\n"); 
		query.append("          TROV.CNTR_PKUP_YD_CD ," ).append("\n"); 
		query.append("          TROV.CNTR_RTN_YD_CD ," ).append("\n"); 
		query.append("          TROV.RCV_TERM_CD ," ).append("\n"); 
		query.append("          TROV.DE_TERM_CD, " ).append("\n"); 
		query.append("          TROV.RQST_DT ," ).append("\n"); 
		query.append("          TROV.DIFF_RMK ," ).append("\n"); 
		query.append("          TROV.POR_CD ," ).append("\n"); 
		query.append("          TROV.POL_CD ," ).append("\n"); 
		query.append("          TROV.POD_CD ," ).append("\n"); 
		query.append("          TROV.DEL_CD ," ).append("\n"); 
		query.append("          TROV.SLAN_CD ," ).append("\n"); 
		query.append("          TROV.VVD_CD ," ).append("\n"); 
		query.append("          TROV.EQ_CTRL_OFC_CD ," ).append("\n"); 
		query.append("          TROV.BKG_OFC_CD ," ).append("\n"); 
		query.append("          TROV.SO_FLG ," ).append("\n"); 
		query.append("		  TROV.WO_FLG ," ).append("\n"); 
		query.append("          TROV.ZONE_CODE," ).append("\n"); 
		query.append("          TROV.SUBGROUP_TITLE," ).append("\n"); 
		query.append("          TROV.SO_NUMBER ," ).append("\n"); 
		query.append("		  TROV.WO_NUMBER" ).append("\n"); 
		query.append(" ORDER BY TROV.RNUM" ).append("\n"); 
		query.append("      ,TROV.BL_NO" ).append("\n"); 
		query.append("      ,TROV.TRO_SEQ" ).append("\n"); 

	}
}