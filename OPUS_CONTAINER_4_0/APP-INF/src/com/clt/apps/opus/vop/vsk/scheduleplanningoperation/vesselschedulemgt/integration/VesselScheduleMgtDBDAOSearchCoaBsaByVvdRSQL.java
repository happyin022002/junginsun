/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCoaBsaByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCoaBsaByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCoaBsaByVvdRSQL(){
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
		params.put("cargo_weight",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("post_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCoaBsaByVvdRSQL").append("\n"); 
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
		query.append("SELECT LEFT_TITLE, COL01, COL02, COL03, COL04, COL05, COL06, " ).append("\n"); 
		query.append("       DECODE(LEFT_TITLE, null, 'TOTAL', " ).append("\n"); 
		query.append("       TO_CHAR(TO_NUMBER(COL01, '999,990.9') + TO_NUMBER(COL02, '999,990.9')" ).append("\n"); 
		query.append("             + TO_NUMBER(COL03, '999,990.9') + TO_NUMBER(COL04, '999,990.9')" ).append("\n"); 
		query.append("             + TO_NUMBER(COL05, '999,990.9') + TO_NUMBER(COL06, '999,990.9'),'999,990.9')) AS COL07" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  CASE WHEN (SEQ = 1) THEN NULL WHEN (SEQ = 2) THEN 'BSA' WHEN (SEQ = 3) THEN 'Loadable Cargo Weight'" ).append("\n"); 
		query.append("             WHEN (SEQ = 4) THEN 'Loaded Cargo Weight' ELSE 'Actual Loadable Weight' END LEFT_TITLE," ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =1 AND SEQ = 1) THEN CAR ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =1 AND SEQ = 2) THEN C01 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =1 AND SEQ = 3) THEN C02 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =1 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =1 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL01," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =2 AND SEQ = 1) THEN DECODE(CAR, 'ZZZZ', 'TTL', CAR) ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =2 AND SEQ = 2) THEN C01 ELSE NULL END " ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =2 AND SEQ = 3) THEN C02 ELSE NULL END " ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =2 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =2 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL02," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =3 AND SEQ = 1) THEN DECODE(CAR, 'ZZZZ', 'TTL', CAR) ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =3 AND SEQ = 2) THEN C01 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =3 AND SEQ = 3) THEN C02 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =3 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =3 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL03," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =4 AND SEQ = 1) THEN DECODE(CAR, 'ZZZZ', 'TTL', CAR) ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =4 AND SEQ = 2) THEN C01 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =4 AND SEQ = 3) THEN C02 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =4 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =4 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL04," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =5 AND SEQ = 1) THEN DECODE(CAR, 'ZZZZ', 'TTL', CAR) ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =5 AND SEQ = 2) THEN C01 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =5 AND SEQ = 3) THEN C02 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =5 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =5 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL05," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        MAX(CASE WHEN (NUM =6 AND SEQ = 1) THEN DECODE(CAR, 'ZZZZ', 'TTL', CAR) ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =6 AND SEQ = 2) THEN C01 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =6 AND SEQ = 3) THEN C02 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =6 AND SEQ = 4) THEN C03 ELSE NULL END" ).append("\n"); 
		query.append("        ||  CASE WHEN (NUM =6 AND SEQ = 5) THEN C04 ELSE NULL END) AS COL06" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("		SELECT  NUM, CAR, C01, C02, C03, C04 " ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT  NUM" ).append("\n"); 
		query.append("						, CAR" ).append("\n"); 
		query.append("						, LTRIM(TO_CHAR(C01, '999,990.9')) AS C01" ).append("\n"); 
		query.append("						, LTRIM(TO_CHAR(@[cargo_weight] * ( ROUND(C01 / MAX(C01) OVER (), 5)), '999,990.9')) AS C02" ).append("\n"); 
		query.append("						, LTRIM(TO_CHAR(C03, '999,990.9')) AS C03" ).append("\n"); 
		query.append("						, LTRIM(TO_CHAR((@[cargo_weight] * ( ROUND(C01 / MAX(C01) OVER (), 5))) - C03, '999,990.9')) AS C04" ).append("\n"); 
		query.append("				FROM    (" ).append("\n"); 
		query.append("							SELECT  ROW_NUMBER() OVER (ORDER BY GBSA.CRR) AS NUM" ).append("\n"); 
		query.append("									,GROUPING(GBSA.CRR)" ).append("\n"); 
		query.append("									,DECODE(GROUPING(GBSA.CRR), 1, 'ZZZZ',  GBSA.CRR)  AS CAR" ).append("\n"); 
		query.append("									,SUM(NVL(PCAPA, GCAPA))                 AS C01" ).append("\n"); 
		query.append("									,SUM(LCW.WGT)                           AS C03" ).append("\n"); 
		query.append("							FROM    (" ).append("\n"); 
		query.append("										SELECT  TRD_CD, A.CRR_CD CRR, A.PORT_BSA_CAPA PCAPA" ).append("\n"); 
		query.append("										FROM    VSK_VSL_SKD V, BSA_VVD_PORT_DWN A" ).append("\n"); 
		query.append("										WHERE   1 = 1" ).append("\n"); 
		query.append("										AND		V.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("										AND     V.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("										AND     V.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("										AND     BSA_OP_JB_CD    = '007'" ).append("\n"); 
		query.append("										AND     V.VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("										AND     V.SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("										AND     V.SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("										AND     A.PORT_CD       = 'CNSHA'" ).append("\n"); 
		query.append("										AND     PORT_BSA_CAPA   > 0" ).append("\n"); 
		query.append("										AND     EXISTS  (" ).append("\n"); 
		query.append("															SELECT 'X' FROM COA_MON_VVD M" ).append("\n"); 
		query.append("															WHERE   A.VSL_CD        = M.VSL_CD" ).append("\n"); 
		query.append("															AND     A.SKD_VOY_NO    = M.SKD_VOY_NO" ).append("\n"); 
		query.append("															AND     A.SKD_DIR_CD    = M.DIR_CD" ).append("\n"); 
		query.append("															AND     A.TRD_CD        = M.TRD_CD" ).append("\n"); 
		query.append("															AND     M.DELT_FLG      = 'N' " ).append("\n"); 
		query.append("															AND     A.RLANE_CD      = M.RLANE_CD" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("										AND A.RLANE_CD = NVL((    " ).append("\n"); 
		query.append("															SELECT  NVL(RLANE_CD, A.RLANE_CD)" ).append("\n"); 
		query.append("															FROM    VSK_VSL_SKD V, AR_FINC_DIR_CONV B" ).append("\n"); 
		query.append("															WHERE   V.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("															AND     V.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("															AND     V.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("															AND     V.VSL_SLAN_CD   = B.SLAN_CD(+)" ).append("\n"); 
		query.append("															AND     V.SKD_DIR_CD    = B.SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("															AND     B.SCONTI_CD     (+)  = 'AE'" ).append("\n"); 
		query.append("														), A.RLANE_CD) " ).append("\n"); 
		query.append("									) PBSA," ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  TRD_CD, A.CRR_CD CRR, A.CRR_BSA_CAPA GCAPA" ).append("\n"); 
		query.append("										FROM    VSK_VSL_SKD V, BSA_VVD_OTR_CRR A" ).append("\n"); 
		query.append("										WHERE   1 = 1" ).append("\n"); 
		query.append("										AND		V.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("										AND     V.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("										AND     V.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("										AND     BSA_OP_JB_CD    = '007'" ).append("\n"); 
		query.append("										AND     V.VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("										AND     V.SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("										AND     V.SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("										AND     CRR_BSA_CAPA    > 0" ).append("\n"); 
		query.append("										AND     A.RLANE_CD      =	NVL((    " ).append("\n"); 
		query.append("																		SELECT  NVL(RLANE_CD, A.RLANE_CD)" ).append("\n"); 
		query.append("																		FROM    VSK_VSL_SKD V, AR_FINC_DIR_CONV B" ).append("\n"); 
		query.append("																		WHERE   1 = 1" ).append("\n"); 
		query.append("																		AND		V.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("																		AND     V.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("																		AND     V.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("																		AND     V.VSL_SLAN_CD   = B.SLAN_CD(+)" ).append("\n"); 
		query.append("																		AND     V.SKD_DIR_CD    = B.SLAN_DIR_CD(+)" ).append("\n"); 
		query.append("																		AND     B.SCONTI_CD(+)  = 'AE'" ).append("\n"); 
		query.append("																	), A.RLANE_CD)" ).append("\n"); 
		query.append("										AND EXISTS (SELECT 'X' FROM COA_MON_VVD M" ).append("\n"); 
		query.append("													WHERE   A.VSL_CD        = M.VSL_CD" ).append("\n"); 
		query.append("													AND     A.SKD_VOY_NO    = M.SKD_VOY_NO" ).append("\n"); 
		query.append("													AND     A.SKD_DIR_CD    = M.DIR_CD" ).append("\n"); 
		query.append("													AND     A.TRD_CD        = M.TRD_CD" ).append("\n"); 
		query.append("													AND     M.DELT_FLG      = 'N' " ).append("\n"); 
		query.append("													AND     A.RLANE_CD      = M.RLANE_CD)" ).append("\n"); 
		query.append("									) GBSA," ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  OPR_CD" ).append("\n"); 
		query.append("												,SUM(CASE WHEN @[post_type] = 'DEPARTURE' AND POD = @[port_cd] THEN 0 ELSE TO_NUMBER(WEIGHT) END) AS WGT" ).append("\n"); 
		query.append("										FROM    BAY_PLAN T11" ).append("\n"); 
		query.append("										WHERE   1 = 1" ).append("\n"); 
		query.append("										AND     VSL_CD  	= @[vsl_cd]" ).append("\n"); 
		query.append("										AND     VOY_NO  	= @[skd_voy_no]" ).append("\n"); 
		query.append("										AND     DIR_CD  	= @[skd_dir_cd]" ).append("\n"); 
		query.append("										AND     PORT_CD 	= @[wgt_port_cd]" ).append("\n"); 
		query.append("										AND     CALL_IND 	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("										AND     POD     IN" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															SELECT  T12.VPS_PORT_CD" ).append("\n"); 
		query.append("															FROM    VSK_VSL_PORT_SKD T12" ).append("\n"); 
		query.append("															WHERE   1 = 1" ).append("\n"); 
		query.append("															AND     T12.VSL_CD      = T11.VSL_CD" ).append("\n"); 
		query.append("															AND     T12.SKD_VOY_NO  = T11.VOY_NO" ).append("\n"); 
		query.append("															AND     T12.SKD_DIR_CD  = T11.DIR_CD" ).append("\n"); 
		query.append("#if (${post_type} != 'DEPARTURE') " ).append("\n"); 
		query.append("															AND     T12.CLPT_SEQ    >=   (" ).append("\n"); 
		query.append("																		SELECT  T13.CLPT_SEQ" ).append("\n"); 
		query.append("																		FROM    VSK_VSL_PORT_SKD T13" ).append("\n"); 
		query.append("																		WHERE   1 = 1" ).append("\n"); 
		query.append("																		AND     T13.VSL_CD      = T12.VSL_CD" ).append("\n"); 
		query.append("																		AND     T13.SKD_VOY_NO  = T12.SKD_VOY_NO" ).append("\n"); 
		query.append("																		AND     T13.SKD_DIR_CD  = T12.SKD_DIR_CD" ).append("\n"); 
		query.append("																		AND     T13.VPS_PORT_CD = 'CNSHA'" ).append("\n"); 
		query.append("																	)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("															AND     T12.CLPT_SEQ    >   (" ).append("\n"); 
		query.append("																		SELECT  T13.CLPT_SEQ" ).append("\n"); 
		query.append("																		FROM    VSK_VSL_PORT_SKD T13" ).append("\n"); 
		query.append("																		WHERE   1 = 1" ).append("\n"); 
		query.append("																		AND     T13.VSL_CD      = T12.VSL_CD" ).append("\n"); 
		query.append("																		AND     T13.SKD_VOY_NO  = T12.SKD_VOY_NO" ).append("\n"); 
		query.append("																		AND     T13.SKD_DIR_CD  = T12.SKD_DIR_CD" ).append("\n"); 
		query.append("																		AND     T13.VPS_PORT_CD = 'CNSHA'" ).append("\n"); 
		query.append("																	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("										GROUP BY OPR_CD" ).append("\n"); 
		query.append("									) LCW" ).append("\n"); 
		query.append("							WHERE   GBSA.CRR    = PBSA.CRR      (+)" ).append("\n"); 
		query.append("							AND     GBSA.TRD_CD = PBSA.TRD_CD   (+)" ).append("\n"); 
		query.append("							AND     GBSA.CRR    = LCW.OPR_CD    (+)" ).append("\n"); 
		query.append("							GROUP BY ROLLUP (GBSA.CRR)" ).append("\n"); 
		query.append("							ORDER BY GBSA.CRR" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) T1, (" ).append("\n"); 
		query.append("		SELECT  LEVEL  SEQ FROM DUAL CONNECT BY LEVEL <= 5" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append("GROUP BY SEQ" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}