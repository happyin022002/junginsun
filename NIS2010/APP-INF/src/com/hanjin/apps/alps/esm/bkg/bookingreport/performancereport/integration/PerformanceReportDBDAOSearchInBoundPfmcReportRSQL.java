/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchInBoundPfmcReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.18 
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

public class PerformanceReportDBDAOSearchInBoundPfmcReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchInBoundPfmcReportRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchInBoundPfmcReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchInBoundPfmcReportRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  SUM(IB_BL) OVER() TOTAL_SUM_IB_BL" ).append("\n"); 
		query.append(", SUM(D2) OVER() TOTAL_SUM_D2" ).append("\n"); 
		query.append(", SUM(D4) OVER() TOTAL_SUM_D4" ).append("\n"); 
		query.append(", SUM(D5) OVER() TOTAL_SUM_D5" ).append("\n"); 
		query.append(", SUM(D7) OVER() TOTAL_SUM_D7" ).append("\n"); 
		query.append(", SUM(R2) OVER() TOTAL_SUM_R2" ).append("\n"); 
		query.append(", SUM(R45) OVER() TOTAL_SUM_R45" ).append("\n"); 
		query.append(", SUM(O2) OVER() TOTAL_SUM_O2" ).append("\n"); 
		query.append(", SUM(O4) OVER() TOTAL_SUM_O4" ).append("\n"); 
		query.append(", SUM(O5) OVER() TOTAL_SUM_O5" ).append("\n"); 
		query.append(", SUM(F2) OVER() TOTAL_SUM_F2" ).append("\n"); 
		query.append(", SUM(F4) OVER() TOTAL_SUM_F4" ).append("\n"); 
		query.append(", SUM(T2) OVER() TOTAL_SUM_T2" ).append("\n"); 
		query.append(", SUM(T4) OVER() TOTAL_SUM_T4" ).append("\n"); 
		query.append(", SUM(TTL40) OVER() TOTAL_SUM_TTL40" ).append("\n"); 
		query.append(", SUM(TTL20) OVER() TOTAL_SUM_TTL20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,3)) OVER() TOTAL_SUM_TS_BL" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,2)) OVER() TOTAL_SUM_TS40" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,1)) OVER() TOTAL_SUM_TS20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(IB_BL) OVER(PARTITION BY YYYY,WEEKS) SUM_IB_BL" ).append("\n"); 
		query.append(", SUM(D2) OVER(PARTITION BY YYYY,WEEKS) SUM_D2" ).append("\n"); 
		query.append(", SUM(D4) OVER(PARTITION BY YYYY,WEEKS) SUM_D4" ).append("\n"); 
		query.append(", SUM(D5) OVER(PARTITION BY YYYY,WEEKS) SUM_D5" ).append("\n"); 
		query.append(", SUM(D7) OVER(PARTITION BY YYYY,WEEKS) SUM_D7" ).append("\n"); 
		query.append(", SUM(R2) OVER(PARTITION BY YYYY,WEEKS) SUM_R2" ).append("\n"); 
		query.append(", SUM(R45) OVER(PARTITION BY YYYY,WEEKS) SUM_R45" ).append("\n"); 
		query.append(", SUM(O2) OVER(PARTITION BY YYYY,WEEKS) SUM_O2" ).append("\n"); 
		query.append(", SUM(O4) OVER(PARTITION BY YYYY,WEEKS) SUM_O4" ).append("\n"); 
		query.append(", SUM(O5) OVER(PARTITION BY YYYY,WEEKS) SUM_O5" ).append("\n"); 
		query.append(", SUM(F2) OVER(PARTITION BY YYYY,WEEKS) SUM_F2" ).append("\n"); 
		query.append(", SUM(F4) OVER(PARTITION BY YYYY,WEEKS) SUM_F4" ).append("\n"); 
		query.append(", SUM(T2) OVER(PARTITION BY YYYY,WEEKS) SUM_T2" ).append("\n"); 
		query.append(", SUM(T4) OVER(PARTITION BY YYYY,WEEKS) SUM_T4" ).append("\n"); 
		query.append(", SUM(TTL40) OVER(PARTITION BY YYYY,WEEKS) SUM_TTL40" ).append("\n"); 
		query.append(", SUM(TTL20) OVER(PARTITION BY YYYY,WEEKS) SUM_TTL20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,3)) OVER(PARTITION BY YYYY,WEEKS,LANE_CD) TS_BL" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,2)) OVER(PARTITION BY YYYY,WEEKS,LANE_CD) TS40" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,1)) OVER(PARTITION BY YYYY,WEEKS,LANE_CD) TS20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,3)) OVER(PARTITION BY YYYY,WEEKS) SUM_TS_BL" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,2)) OVER(PARTITION BY YYYY,WEEKS) SUM_TS40" ).append("\n"); 
		query.append(", SUM(BKG_GET_TOKEN_FNC(TS_20_40_TSBL,1)) OVER(PARTITION BY YYYY,WEEKS) SUM_TS20" ).append("\n"); 
		query.append("#if(${dura_cd} != '')" ).append("\n"); 
		query.append("	,@[dura_cd] DURA_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", X.*" ).append("\n"); 
		query.append("FROM (  SELECT YYYY,   WEEKS,   " ).append("\n"); 
		query.append("               LANE AS LANE_CD, POD AS POD_CD,       YD AS POD_YARD_CD,  DEL AS DEL_CD,     STF_ID AS STAFF_ID, STF_NM AS STAFF_NM,  " ).append("\n"); 
		query.append("               VSL AS VVD_CD1,  VOY||DIR AS VVD_CD2, ATA_MM AS ATA_CD1,  ATA_DD AS ATA_CD2, " ).append("\n"); 
		query.append("               SUM(IB_BL) AS IB_BL," ).append("\n"); 
		query.append("               SUM(D2) AS D2,   SUM(D4) AS D4,  SUM(D5) AS D5, SUM(D7) AS D7,  " ).append("\n"); 
		query.append("               SUM(R2) AS R2,   SUM(RF) AS R45, " ).append("\n"); 
		query.append("               SUM(O2) AS O2,   SUM(O4) AS O4,  SUM(O5) AS O5,     " ).append("\n"); 
		query.append("               SUM(F2) AS F2,   SUM(F4) AS F4,  SUM(T2) AS T2,  SUM(T4) AS T4," ).append("\n"); 
		query.append("               SUM(FEU) AS TTL40,  SUM(TEU) AS TTL20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                MAX(NVL((SELECT SUM(DECODE(TS_BKG.POD_CD, TS_VVD.POD_CD, 0, DECODE(SUBSTR(TS_CNTR.CNTR_TPSZ_CD, -1), '2', TS_CNTR.CNTR_VOL_QTY, 0)))||','||" ).append("\n"); 
		query.append("                            SUM(DECODE(TS_BKG.POD_CD, TS_VVD.POD_CD, 0, DECODE(SUBSTR(TS_CNTR.CNTR_TPSZ_CD, -1), '2', 0, TS_CNTR.CNTR_VOL_QTY))) ||','||" ).append("\n"); 
		query.append("                            COUNT(DISTINCT Decode(TS_BKG.POD_CD, TS_VVD.POD_CD, NULL, TS_BKG.BL_NO)) " ).append("\n"); 
		query.append("                  FROM BKG_VVD TS_VVD" ).append("\n"); 
		query.append("                  ,BKG_BOOKING TS_BKG" ).append("\n"); 
		query.append("                  ,BKG_CONTAINER TS_CNTR  " ).append("\n"); 
		query.append("                  WHERE TS_VVD.VSL_CD     = BKG.VSL" ).append("\n"); 
		query.append("                  AND   TS_VVD.SKD_VOY_NO = BKG.VOY" ).append("\n"); 
		query.append("                  AND   TS_VVD.SKD_DIR_CD = BKG.DIR" ).append("\n"); 
		query.append("                  AND   TS_VVD.SLAN_CD    = BKG.SLAN_CD" ).append("\n"); 
		query.append("                  AND   TS_VVD.POD_CD     = BKG.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND   TS_VVD.BKG_NO     = TS_BKG.BKG_NO" ).append("\n"); 
		query.append("                  AND   TS_BKG.BKG_NO     = TS_CNTR.BKG_NO" ).append("\n"); 
		query.append("                  AND   TS_BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("                 /*DEL*/   " ).append("\n"); 
		query.append("                 #if(${del_cd} != '')" ).append("\n"); 
		query.append("                  AND     TS_BKG.DEL_CD  = @[del_cd]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("               ),'0,0')) AS TS_20_40_TSBL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM   (SELECT YYYY," ).append("\n"); 
		query.append("                       WEEKS," ).append("\n"); 
		query.append("                       BV.SLAN_CD||'/'||BV.SKD_DIR_CD LANE," ).append("\n"); 
		query.append("                       BV.POD_CD POD," ).append("\n"); 
		query.append("                       VSL.SLAN_CD ,VSL.VPS_PORT_CD," ).append("\n"); 
		query.append("                       SUBSTR(BB.POD_NOD_CD, 6, 2) YD," ).append("\n"); 
		query.append("                       BB.DEL_CD DEL," ).append("\n"); 
		query.append("                       DECODE(CC.AN_SND_FLG, 'Y', CC.VAL_USR_ID, NN.VAL_USR_ID) STF_ID," ).append("\n"); 
		query.append("                       DECODE(CC.AN_SND_FLG, 'Y', COMC.USR_NM, COMN.USR_NM) STF_NM," ).append("\n"); 
		query.append("                       BV.VSL_CD VSL," ).append("\n"); 
		query.append("                       BV.SKD_VOY_NO VOY," ).append("\n"); 
		query.append("                       BV.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("                       TO_CHAR(VSL.ACT_ARR_DT, 'Mon','NLS_DATE_LANGUAGE=AMERICAN') ATA_MM," ).append("\n"); 
		query.append("                       TO_CHAR(VSL.ACT_ARR_DT, 'DD') ATA_DD," ).append("\n"); 
		query.append("                       BB.BKG_NO," ).append("\n"); 
		query.append("                       BV.POD_CD BV_POD," ).append("\n"); 
		query.append("                       COUNT(DISTINCT BB.BL_NO) IB_BL," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'D2', BC.CNTR_VOL_QTY, 'C2', BC.CNTR_VOL_QTY, 0)) D2," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'D4', BC.CNTR_VOL_QTY, 'C4', BC.CNTR_VOL_QTY, 0)) D4," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'D5', BC.CNTR_VOL_QTY, 0)) D5," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'D7', BC.CNTR_VOL_QTY, 0)) D7," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'R2', BC.CNTR_VOL_QTY, 0)) R2," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'R4', BC.CNTR_VOL_QTY, 'R5', BC.CNTR_VOL_QTY, 0)) RF," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'O2', BC.CNTR_VOL_QTY, 0)) O2," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'O4', BC.CNTR_VOL_QTY, 0)) O4," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'O5', BC.CNTR_VOL_QTY, 0)) O5," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'F2', BC.CNTR_VOL_QTY, 0)) F2," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'F4', BC.CNTR_VOL_QTY, 0)) F4," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'T2', BC.CNTR_VOL_QTY, 0)) T2," ).append("\n"); 
		query.append("                       SUM(DECODE(BC.CNTR_TPSZ_CD, 'T4', BC.CNTR_VOL_QTY, 0)) T4," ).append("\n"); 
		query.append("                       SUM(DECODE(SUBSTR(BC.CNTR_TPSZ_CD, -1), '2', BC.CNTR_VOL_QTY, 0)) TEU," ).append("\n"); 
		query.append("                       SUM(DECODE(SUBSTR(BC.CNTR_TPSZ_CD, -1), '2', 0, BC.CNTR_VOL_QTY)) FEU," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       (SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM   BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append("                        WHERE  BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                        AND    ROWNUM =1) KR" ).append("\n"); 
		query.append("                FROM   (SELECT VSL.VSL_CD," ).append("\n"); 
		query.append("                               VSl.SKD_VOY_NO," ).append("\n"); 
		query.append("                               VSL.SKD_DIR_CD," ).append("\n"); 
		query.append("                               VSL.SLAN_CD," ).append("\n"); 
		query.append("                               VSL.VPS_PORT_CD," ).append("\n"); 
		query.append("                               VSL.CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               VPS_ETA_DT AS ACT_ARR_DT," ).append("\n"); 
		query.append("                               TO_CHAR(VPS_ETA_DT,'YYYY') YYYY," ).append("\n"); 
		query.append("                               TO_CHAR(VPS_ETA_DT, 'fmww') AS WEEKS" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PORT_SKD VSL ," ).append("\n"); 
		query.append("                               VSK_VSL_SKD V" ).append("\n"); 
		query.append("                        WHERE  VSL.VPS_ETA_DT >= TO_DATE(@[eta_from_dt]|| '00:00:00','YYYY-MM-DD HH24:MI:SS') /* Duration */" ).append("\n"); 
		query.append("                        AND    VSL.VPS_ETA_DT <= TO_DATE(@[eta_to_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        /* Country */" ).append("\n"); 
		query.append("						AND    VSL.VPS_PORT_CD like @[cntr_cd]||'%'  " ).append("\n"); 
		query.append("                       #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                        AND    VSL.VSL_CD||VSL.SKD_VOY_NO||VSL.SKD_DIR_CD LIKE '%'||@[vvd_cd]||'%'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        /*LANE*/" ).append("\n"); 
		query.append("		        		#if(${lane_cd} != '')" ).append("\n"); 
		query.append("                        AND     VSL.SLAN_CD = @[lane_cd] " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        /*POD */" ).append("\n"); 
		query.append("                        #if(${pod_cd} != '')" ).append("\n"); 
		query.append("                        AND     VSL.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND    VSL.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                        AND    VSL.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    VSL.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND    VSL.SLAN_CD = V.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND    NVL(VSL.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                        AND    V.SKD_STS_CD <> 'CLO'" ).append("\n"); 
		query.append("                        AND    EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                WHERE  BV.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                                AND    BV.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND    BV.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND    BV.POD_CLPT_IND_SEQ = VSL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                AND    BV.POD_CD = VSL.VPS_PORT_CD )" ).append("\n"); 
		query.append("                       ) VSL," ).append("\n"); 
		query.append("                       BKG_VVD BV," ).append("\n"); 
		query.append("                       BKG_BOOKING BB," ).append("\n"); 
		query.append("                       BKG_CUSTOMER CC ," ).append("\n"); 
		query.append("                       BKG_CUSTOMER NN ," ).append("\n"); 
		query.append("                       COM_USER COMC," ).append("\n"); 
		query.append("                       COM_USER COMN," ).append("\n"); 
		query.append("                       BKG_CONTAINER BC" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("                AND    BV.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                AND    BV.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    BV.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    BV.POD_CLPT_IND_SEQ = VSL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND    BV.POD_CD = VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("                AND    BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                AND    BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                AND    BB.BKG_CGO_TP_CD ='F'" ).append("\n"); 
		query.append("                AND    BB.BKG_NO =CC.BKG_NO" ).append("\n"); 
		query.append("                AND    CC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                AND    BB.BKG_NO =NN.BKG_NO" ).append("\n"); 
		query.append("                AND    NN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                AND    (CC.AN_SND_FLG = 'Y'" ).append("\n"); 
		query.append("                        OR     NN.AN_SND_FLG ='Y')" ).append("\n"); 
		query.append("                AND    CC.VAL_USR_ID = COMC.USR_ID(+)" ).append("\n"); 
		query.append("                AND    NN.VAL_USR_ID = COMN.USR_ID(+)" ).append("\n"); 
		query.append("                AND    BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("                /* Office */" ).append("\n"); 
		query.append("				AND    (CC.VAL_OFC_CD = @[ofc_cd] OR    NN.VAL_OFC_CD = @[ofc_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* Staff ID */  " ).append("\n"); 
		query.append("				#if(${staff_id} != '')" ).append("\n"); 
		query.append("                AND     DECODE(CC.AN_SND_FLG,'Y',CC.VAL_USR_ID,NN.VAL_USR_ID)  = @[staff_id]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /*DEL*/   " ).append("\n"); 
		query.append("                #if(${del_cd} != '')" ).append("\n"); 
		query.append("                AND     BB.DEL_CD  = @[del_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                GROUP BY YYYY,WEEKS, BV.SLAN_CD||'/'||BV.SKD_DIR_CD, BB.POD_CD, SUBSTR(BB.POD_NOD_CD, 6, 2), BB.DEL_CD, DECODE(CC.AN_SND_FLG, 'Y', CC.VAL_USR_ID, NN.VAL_USR_ID), DECODE(CC.AN_SND_FLG, 'Y', COMC.USR_NM, COMN.USR_NM), BV.VSL_CD, BV.SKD_VOY_NO, BV.SKD_DIR_CD, VSL.SLAN_CD ,VSL.VPS_PORT_CD, TO_CHAR(VSL.ACT_ARR_DT, 'Mon','NLS_DATE_LANGUAGE=AMERICAN'), TO_CHAR(VSL.ACT_ARR_DT, 'DD'), BB.BKG_NO, BV.POD_CD" ).append("\n"); 
		query.append("              )BKG" ).append("\n"); 
		query.append("        GROUP BY YYYY,WEEKS, LANE, POD, YD, DEL, STF_ID, STF_NM, VSL, VOY, DIR, ATA_MM, ATA_DD, IB_BL " ).append("\n"); 
		query.append("    ) X" ).append("\n"); 

	}
}