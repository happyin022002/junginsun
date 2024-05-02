/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sl_status1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sl_status2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL").append("\n"); 
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
		query.append("SELECT  X.OPR_CD," ).append("\n"); 
		query.append("X.TRADE_FULL," ).append("\n"); 
		query.append("X.TRADE_MT," ).append("\n"); 
		query.append("X.TRADE_AB," ).append("\n"); 
		query.append("X.TRADE_45," ).append("\n"); 
		query.append("X.TRADE_SUB_SLOT," ).append("\n"); 
		query.append("X.TRADE_SUB_WGT," ).append("\n"); 
		query.append("X.INTER_FULL," ).append("\n"); 
		query.append("X.INTER_MT," ).append("\n"); 
		query.append("X.INTER_AB," ).append("\n"); 
		query.append("X.INTER_45," ).append("\n"); 
		query.append("X.INTER_SUB_SLOT," ).append("\n"); 
		query.append("X.INTER_SUB_WGT," ).append("\n"); 
		query.append("X.GRAND_TTL_SLOT," ).append("\n"); 
		query.append("X.GRAND_TTL_WGT," ).append("\n"); 
		query.append("Y.RATIO_TYPE," ).append("\n"); 
		query.append("Y.BSA_TYPE," ).append("\n"); 
		query.append("Y.BSA_SLOT," ).append("\n"); 
		query.append("Y.BSA_WGT," ).append("\n"); 
		query.append("Z.TEU," ).append("\n"); 
		query.append("Y.RELEASE_SLOT," ).append("\n"); 
		query.append("Y.RELEASE_WGT," ).append("\n"); 
		query.append("CASE WHEN X.GRAND_TTL_SLOT > Y.BSA_SLOT THEN X.GRAND_TTL_SLOT - Y.BSA_SLOT ELSE 0 END AS OVER_SLOT," ).append("\n"); 
		query.append("CASE WHEN X.GRAND_TTL_WGT > Y.BSA_WGT THEN X.GRAND_TTL_WGT - Y.BSA_WGT ELSE 0 END AS OVER_WGT," ).append("\n"); 
		query.append("--------------------------" ).append("\n"); 
		query.append("-- RATIO_TYPE" ).append("\n"); 
		query.append("--------------------------" ).append("\n"); 
		query.append("CASE WHEN Y.RATIO_TYPE = 'T' AND Y.BSA_TYPE = 'U' THEN" ).append("\n"); 
		query.append("CASE WHEN X.GRAND_TTL_SLOT > Y.BSA_SLOT THEN X.GRAND_TTL_SLOT - Y.BSA_SLOT ELSE 0 END" ).append("\n"); 
		query.append("WHEN Y.RATIO_TYPE = 'T' AND Y.BSA_TYPE = 'F' THEN" ).append("\n"); 
		query.append("NVL(Y.RELEASE_SLOT,0)" ).append("\n"); 
		query.append("WHEN  Y.RATIO_TYPE = 'W' AND Y.BSA_TYPE = 'U' THEN" ).append("\n"); 
		query.append("CASE WHEN TEU IS NOT NULL AND TEU > 0 THEN" ).append("\n"); 
		query.append("(CASE WHEN X.GRAND_TTL_WGT > Y.BSA_WGT THEN X.GRAND_TTL_WGT - Y.BSA_WGT ELSE 0 END) / NVL(TEU, 0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN  Y.RATIO_TYPE = 'W' AND Y.BSA_TYPE = 'F' THEN" ).append("\n"); 
		query.append("CASE WHEN TEU IS NOT NULL AND TEU > 0 THEN" ).append("\n"); 
		query.append("NVL(Y.RELEASE_WGT, 0) / NVL(TEU, 0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS OVER_SETTLE," ).append("\n"); 
		query.append("Y.BSA_TYPE  OVER_SETTLE_BY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	OPR_CD," ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("-- Trade" ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("TRADE_FULL," ).append("\n"); 
		query.append("TRADE_MT," ).append("\n"); 
		query.append("TRADE_AB," ).append("\n"); 
		query.append("TRADE_45," ).append("\n"); 
		query.append("(NVL(TRADE_FULL, 0) + NVL(TRADE_MT, 0) + NVL(TRADE_AB, 0)) AS TRADE_SUB_SLOT," ).append("\n"); 
		query.append("(NVL(TRADE_FULL_W, 0) + NVL(TRADE_MT_W, 0) + NVL(TRADE_AB_W, 0)) AS TRADE_SUB_WGT," ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("-- Inter" ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("INTER_FULL," ).append("\n"); 
		query.append("INTER_MT," ).append("\n"); 
		query.append("INTER_AB," ).append("\n"); 
		query.append("INTER_45," ).append("\n"); 
		query.append("(NVL(INTER_FULL, 0) + NVL(INTER_MT, 0) + NVL(INTER_AB, 0)) AS INTER_SUB_SLOT," ).append("\n"); 
		query.append("(NVL(INTER_FULL_W, 0) + NVL(INTER_MT_W, 0) + NVL(INTER_AB_W, 0)) AS INTER_SUB_WGT," ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("-- Grand TTL" ).append("\n"); 
		query.append("------------------" ).append("\n"); 
		query.append("(NVL(TRADE_FULL, 0) + NVL(TRADE_MT, 0) + NVL(TRADE_AB, 0))  +" ).append("\n"); 
		query.append("(NVL(INTER_FULL, 0) + NVL(INTER_MT, 0) + NVL(INTER_AB, 0) + NVL(INTER_45, 0))" ).append("\n"); 
		query.append("AS GRAND_TTL_SLOT," ).append("\n"); 
		query.append("(NVL(TRADE_FULL_W, 0) + NVL(TRADE_MT_W, 0) + NVL(TRADE_AB_W, 0))  +" ).append("\n"); 
		query.append("(NVL(INTER_FULL_W, 0) + NVL(INTER_MT_W, 0) + NVL(INTER_AB_W, 0) + NVL(INTER_45_W, 0))" ).append("\n"); 
		query.append("AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT  C.OPR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0),0))     TRADE_FULL," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0),0))     TRADE_MT," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_SIZE, 'A', C.QTY, 0),0))                                	TRADE_AB," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, 'H', C.QTY, 'L', C.QTY, 0), 0), 0))  TRADE_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0),0))  TRADE_FULL_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0),0))  TRADE_MT_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_SIZE, 'A', C.WEIGHT, 0),0))                               TRADE_AB_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, 'H', C.QTY, 'L', C.QTY, 0), 0), 0))  TRADE_45_W," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0), 0))    INTER_FULL," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0), 0))    INTER_MT," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_SIZE, 'A', C.QTY, 0),0))                                	INTER_AB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, 'H', C.QTY, 'L', C.QTY, 0)," ).append("\n"); 
		query.append("@[sl_status2], DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, 'H', C.QTY, 'L', C.QTY, 0)" ).append("\n"); 
		query.append(", 0), 0), 0)) AS INTER_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0), 0)) INTER_FULL_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0), 0)) INTER_MT_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'A', C.WEIGHT, 0),0))                               INTER_AB_W," ).append("\n"); 
		query.append("SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, 'H', C.QTY, 'L', C.QTY, 0), 0), 0))  INTER_45_W" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_UTILIZE C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND	   V.YD_CD		  = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       = C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       = C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      = C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     = C.CALL_IND" ).append("\n"); 
		query.append("AND	   C.STATUS		  IN (@[sl_status1], @[sl_status2])" ).append("\n"); 
		query.append("AND	   (  -- INTERNAL(ALPS)" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("H.UPDATE_SYS = 'N' AND C.CNTR_SIZE   IN ('9', '2', 'A')" ).append("\n"); 
		query.append("OR (C.CNTR_SIZE IN ('3', 'H', 'L') AND  CNTR_TYPE = 'A')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(   -- EXTERNAL(I-STOWGE)" ).append("\n"); 
		query.append("NVL(H.UPDATE_SYS, '-') != 'N' OR CNTR_SIZE LIKE '%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY C.OPR_CD, H.UPDATE_SYS" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  OPR_CD," ).append("\n"); 
		query.append("BSA_TYPE," ).append("\n"); 
		query.append("RATIO_TYPE," ).append("\n"); 
		query.append("SUM(NVL(RELEASE_SLOT, 0))                        AS  RELEASE_SLOT," ).append("\n"); 
		query.append("SUM(NVL(RELEASE_WGT, 0))                         AS  RELEASE_WGT," ).append("\n"); 
		query.append("SUM(NVL(C.BSA_SLOT, 0))+SUM(NVL(C.SWAP_SLOT, 0)) AS  BSA_SLOT," ).append("\n"); 
		query.append("SUM(NVL(C.BSA_WGT, 0))+SUM(NVL(C.SWAP_WGT, 0))   AS  BSA_WGT" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_ALLOCATION C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND	   V.YD_CD		  = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD		   = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO    = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD    = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD   = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ  = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO        = C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD       = C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND      = C.CALL_IND" ).append("\n"); 
		query.append("GROUP BY C.OPR_CD, BSA_TYPE, RATIO_TYPE" ).append("\n"); 
		query.append(")Y," ).append("\n"); 
		query.append("(   SELECT A.CRR_CD," ).append("\n"); 
		query.append("SUM(DECODE(A.BSA_OP_JB_CD,'008',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA))) AS TEU" ).append("\n"); 
		query.append("FROM   BSA_VVD_OTR_CRR A," ).append("\n"); 
		query.append("( SELECT B.RLANE_CD, B.DIR_CD, B.TRD_CD, B.CRR_CD, B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("SUBSTR(MAX('0'||B.BSA_SEQ||B.PORT_BSA_CAPA),3) PORT_BSA_CAPA" ).append("\n"); 
		query.append("FROM   BSA_SLT_CHTR_PORT_DWN B" ).append("\n"); 
		query.append("WHERE  PORT_CD(+) = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("AND    RLANE_CD = ( SELECT D.RLANE_CD" ).append("\n"); 
		query.append("FROM   MDM_REV_LANE R, MDM_DTL_REV_LANE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  D.RLANE_CD    = R.RLANE_CD" ).append("\n"); 
		query.append("AND    V.VSL_CD      = @[vsl_cd]   --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  = @[voy_no]   --:skd_voy_no" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  = @[dir_cd]   --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    R.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("AND    ( D.FM_CONTI_CD, D.TO_CONTI_CD ) IN (" ).append("\n"); 
		query.append("SELECT CONTI_CD, NVL(LEAD_CONTI_CD, CONTI_CD)" ).append("\n"); 
		query.append("FROM   ( SELECT V.CLPT_SEQ, V.VPS_PORT_CD, L.CONTI_CD," ).append("\n"); 
		query.append("LEAD(CONTI_CD) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE  V.VSL_CD      = @[vsl_cd]       --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  = @[voy_no]       --:skd_voy_no" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  = @[dir_cd]       --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = L.LOC_CD )" ).append("\n"); 
		query.append("WHERE  CONTI_CD = 'A'" ).append("\n"); 
		query.append("AND    CONTI_CD <> NVL(LEAD_CONTI_CD,'X') )" ).append("\n"); 
		query.append("AND    D.VSL_SLAN_DIR_CD = NVL('W',D.VSL_SLAN_DIR_CD)  --:skd_dir_cd" ).append("\n"); 
		query.append("AND    D.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM = 1 )" ).append("\n"); 
		query.append("AND    DIR_CD       = @[dir_cd]                                                  --:skd_dir_cd" ).append("\n"); 
		query.append("AND    BSA_OP_JB_CD IN ('008')" ).append("\n"); 
		query.append("GROUP BY RLANE_CD, DIR_CD, TRD_CD, CRR_CD, BSA_OP_JB_CD ) B" ).append("\n"); 
		query.append("WHERE  A.RLANE_CD     = B.RLANE_CD(+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = B.DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.TRD_CD       = B.TRD_CD(+)" ).append("\n"); 
		query.append("AND    A.CRR_CD       = B.CRR_CD(+)" ).append("\n"); 
		query.append("AND    A.BSA_OP_JB_CD = B.BSA_OP_JB_CD(+)" ).append("\n"); 
		query.append("AND    A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND    A.BSA_OP_JB_CD IN ('008')" ).append("\n"); 
		query.append("AND    ( A.CRR_BSA_CAPA > 0 OR B.PORT_BSA_CAPA > 0 )" ).append("\n"); 
		query.append("GROUP BY A.CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("WHERE   X.OPR_CD = Y.OPR_CD(+)" ).append("\n"); 
		query.append("AND     X.OPR_CD = Z.CRR_CD(+)" ).append("\n"); 
		query.append("ORDER 	BY X.OPR_CD" ).append("\n"); 

	}
}