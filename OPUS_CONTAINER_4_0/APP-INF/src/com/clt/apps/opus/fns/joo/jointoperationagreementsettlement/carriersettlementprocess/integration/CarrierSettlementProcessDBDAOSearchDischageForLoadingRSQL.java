/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchDischageForLoadingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchDischageForLoadingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter
	  * 2010.12.06 남궁진호 [CHM-201007281-01]  FL -->  AK, Accumulative Total 반영, Q(Dead Space) 반영..
	  * 2011.06.30 이준범[CHM-201111620-01]
	  * 제목 : R9 TP/SZ 코드 도입에 따른 변경 요청
	  * 내용 : Booking Data Inquiry 화면의  Type Size R9를 H/C에 포함하여 Count하도록 수정
	  * 2012.05.29 김상근[CHM-201218112-01] : [JOO] ALPS-JOO Booking data Inquriy 화면 Reefer수량 산출로직 변경(원복)
	  * 2012.06.11 김상근[CHM-201218352] : [ALPS JOO] Booking Data Inquiry : RF Counting을 Booking Container table로 query 수정.
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchDischageForLoadingRSQL(){
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
		params.put("ratehc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate45",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchDischageForLoadingRSQL").append("\n"); 
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
		query.append("SELECT       --FORM.POL_CD POL " ).append("\n"); 
		query.append("             FORM.SKD_DIR_CD " ).append("\n"); 
		query.append("            ,FORM.MIN_VPS_ETD_DT" ).append("\n"); 
		query.append("            ,@[ratehc]RATEHC" ).append("\n"); 
		query.append("            ,@[rate45]RATE45" ).append("\n"); 
		query.append("            ,GROUPING(FORM.SKD_DIR_CD )" ).append("\n"); 
		query.append("            ,GROUPING(FORM.TYPE )" ).append("\n"); 
		query.append("            ,GROUPING(FORM.POL_CD )" ).append("\n"); 
		query.append("            ,DECODE( GROUPING(FORM.POL_CD ), 0,  SUBSTR(FORM.POL_CD, 0, INSTR(FORM.POL_CD,'/')-3 )" ).append("\n"); 
		query.append("                                           , 1,  DECODE( GROUPING(FORM.TYPE ) ,1, 'TEU', FORM.SKD_DIR_CD||'TOTAL'   )" ).append("\n"); 
		query.append("             )POL_CD" ).append("\n"); 
		query.append("            ,FORM.TYPE" ).append("\n"); 
		query.append("            ,SUM(  DECODE(S1.CNMV_STS_CD, 'MT', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', 1 )    )  ) MT_20_CNT" ).append("\n"); 
		query.append("            ,SUM(  DECODE(S1.CNMV_STS_CD, 'MT', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', 1 )    )  ) MT_40_CNT" ).append("\n"); 
		query.append("            ,SUM(  DECODE(S1.CNMV_STS_CD, 'MT', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', 1, '9', 1 )    )  ) MT_HC_CNT" ).append("\n"); 
		query.append("            ,SUM(  DECODE(S1.CNMV_STS_CD, 'MT', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', 1 )    )  ) MT_45_CNT " ).append("\n"); 
		query.append("            ${header_sql} " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("         (SELECT DECODE( C.RC_FLG, 'Y', 'R/F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 1, 1), 'D', 'D', 'R', 'D', 'AK' ) )AS TYPE ," ).append("\n"); 
		query.append("               SKD.YD_CD||'/'||SKD.SKD_DIR_CD||'/'||SKD.CLPT_IND_SEQ POL_CD," ).append("\n"); 
		query.append("               B1.POL_YD_CD," ).append("\n"); 
		query.append("               SKD.CLPT_SEQ ," ).append("\n"); 
		query.append("               SKD.SKD_DIR_CD ," ).append("\n"); 
		query.append("               POD_SKD.YD_CD||'/'||B1.SKD_DIR_CD||'/'||B1.POD_CLPT_IND_SEQ POD_CD," ).append("\n"); 
		query.append("               C.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("               C.CNTR_VOL_QTY," ).append("\n"); 
		query.append("               C.CNMV_STS_CD," ).append("\n"); 
		query.append("               K.RC_FLG" ).append("\n"); 
		query.append("        FROM   BKG_VVD B1," ).append("\n"); 
		query.append("               BKG_CONTAINER C," ).append("\n"); 
		query.append("               BKG_BOOKING K," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD POD_SKD" ).append("\n"); 
		query.append("        WHERE  B1.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND    B1.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("        AND    K.BKG_STS_CD = 'F' /* F = CONFIRM인 경우 */" ).append("\n"); 
		query.append("        AND    B1.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    B1.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    SKD.CLPT_IND_SEQ = NVL(B1.POL_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND    B1.VSL_CD     = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    B1.SKD_DIR_CD = POD_SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    B1.POD_CD     = POD_SKD.VPS_PORT_CD " ).append("\n"); 
		query.append("        AND    POD_SKD.CLPT_IND_SEQ = NVL(B1.POD_CLPT_IND_SEQ, 1)        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND    B1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = SUBSTR(@[vvd], 5)" ).append("\n"); 
		query.append("        AND    NVL(K.BKG_STS_CD, 'N') NOT IN ('X','A')" ).append("\n"); 
		query.append("        AND    B1.POL_CD = SKD.VPS_PORT_CD " ).append("\n"); 
		query.append("        union all        " ).append("\n"); 
		query.append("        SELECT substr(C.CNTR_TPSZ_CD,1,1) AS TYPE ," ).append("\n"); 
		query.append("        SKD.YD_CD||'/'||SKD.SKD_DIR_CD||'/'||SKD.CLPT_IND_SEQ POL_CD," ).append("\n"); 
		query.append("        B1.POL_YD_CD," ).append("\n"); 
		query.append("        SKD.CLPT_SEQ ," ).append("\n"); 
		query.append("        SKD.SKD_DIR_CD ," ).append("\n"); 
		query.append("        POD_SKD.YD_CD||'/'||B1.SKD_DIR_CD||'/'||B1.POD_CLPT_IND_SEQ POD_CD," ).append("\n"); 
		query.append("        C.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("        C.OP_CNTR_QTY AS CNTR_VOL_QTY," ).append("\n"); 
		query.append("        'XX'," ).append("\n"); 
		query.append("        K.RC_FLG" ).append("\n"); 
		query.append("        FROM   BKG_VVD B1," ).append("\n"); 
		query.append("        BKG_QUANTITY C," ).append("\n"); 
		query.append("        BKG_BOOKING K," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD POD_SKD        " ).append("\n"); 
		query.append("        WHERE  B1.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND    B1.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("        AND    K.BKG_STS_CD = 'F' /* F = CONFIRM인 경우 */" ).append("\n"); 
		query.append("        AND    B1.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    B1.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    SKD.CLPT_IND_SEQ = NVL(B1.POL_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("        AND    B1.VSL_CD     = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    B1.SKD_DIR_CD = POD_SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    B1.POD_CD     = POD_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND    POD_SKD.CLPT_IND_SEQ = NVL(B1.POD_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("        AND    B1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("        AND    B1.SKD_VOY_NO = SUBSTR(@[vvd], 5)" ).append("\n"); 
		query.append("        AND    NVL(K.BKG_STS_CD, 'N') NOT IN ('X','A')" ).append("\n"); 
		query.append("        AND    B1.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND    substr(C.CNTR_TPSZ_CD,1,1)  = 'Q'" ).append("\n"); 
		query.append("        ) S1," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("             SELECT  HED.POL_CD, HED.SKD_DIR_CD, S_FORM.TYPE,HED.CLPT_SEQ, S_FORM.FORM_ORD" ).append("\n"); 
		query.append("                   , HED.MIN_VPS_ETD_DT, HED.POL_CD_CNT" ).append("\n"); 
		query.append("             FROM " ).append("\n"); 
		query.append("                 (/*POL과 POD 조합으로 X축과 Y축구한다.*/  " ).append("\n"); 
		query.append("                  SELECT SKD.YD_CD||'/'||SKD.SKD_DIR_CD||'/'||SKD.CLPT_IND_SEQ POL_CD" ).append("\n"); 
		query.append("                  ,      SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,      SKD.CLPT_SEQ   " ).append("\n"); 
		query.append("                  ,      MIN(SKD.VPS_ETD_DT) OVER (PARTITION BY  SKD.SKD_DIR_CD) MIN_VPS_ETD_DT" ).append("\n"); 
		query.append("                  , COUNT(SKD.VPS_PORT_CD) OVER (PARTITION BY SKD.VPS_PORT_CD) POL_CD_CNT" ).append("\n"); 
		query.append("                  FROM   VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                  WHERE  SKD.VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                  AND    SKD.SKD_VOY_NO   = SUBSTR(@[vvd], 5)" ).append("\n"); 
		query.append("                 -- AND    SKD.TURN_PORT_IND_CD NOT IN ('D','F','V')" ).append("\n"); 
		query.append("                --  AND    SKD.TURN_PORT_IND_CD NOT IN ('D','V')" ).append("\n"); 
		query.append("			     -- AND    NVL(SKD.SKD_CNG_STS_CD, 'A') <> 'S'" ).append("\n"); 
		query.append("                   --AND NVL(SKD.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND  ((    NVL(SKD.SKD_CNG_STS_CD, 'A') =  'S'" ).append("\n"); 
		query.append("                          AND  1 = 1" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                      OR " ).append("\n"); 
		query.append("                        (      NVL(SKD.SKD_CNG_STS_CD, 'A') <>  'S'" ).append("\n"); 
		query.append("                          AND  SKD.TURN_PORT_IND_CD NOT IN ('F','V')" ).append("\n"); 
		query.append("                        ))" ).append("\n"); 
		query.append("                 )HED, " ).append("\n"); 
		query.append("                 ( SELECT 'D'    TYPE, 1 FORM_ORD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                   SELECT 'R/F'  TYPE, 2 FORM_ORD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("				   SELECT 'Q'  	 TYPE, 4 FORM_ORD FROM DUAL UNION ALL	" ).append("\n"); 
		query.append("                   SELECT 'AK'   TYPE, 3 FORM_ORD FROM DUAL" ).append("\n"); 
		query.append("                 ) S_FORM " ).append("\n"); 
		query.append("            ) FORM   " ).append("\n"); 
		query.append("    WHERE " ).append("\n"); 
		query.append("            FORM.POL_CD       = S1.POL_CD    (+)" ).append("\n"); 
		query.append("     AND    FORM.TYPE         = S1.TYPE      (+)" ).append("\n"); 
		query.append("     AND    FORM.SKD_DIR_CD   = S1.SKD_DIR_CD(+)	 " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("GROUP BY FORM.MIN_VPS_ETD_DT, ROLLUP(  (FORM.SKD_DIR_CD),(FORM.SKD_DIR_CD,FORM.TYPE), (FORM.CLPT_SEQ,FORM.POL_CD,FORM.FORM_ORD) ) " ).append("\n"); 
		query.append("HAVING GROUPING(FORM.POL_CD )||GROUPING(FORM.TYPE )||GROUPING(FORM.SKD_DIR_CD ) <> '111'" ).append("\n"); 
		query.append("ORDER BY  FORM.MIN_VPS_ETD_DT,  FORM.CLPT_SEQ, " ).append("\n"); 
		query.append("        DECODE( GROUPING(FORM.POL_CD), 1,  DECODE( GROUPING(FORM.TYPE), 0, DECODE(FORM.TYPE,'D',1,'R/F',2,'AK',3,'Q',4 )),FORM.FORM_ORD)" ).append("\n"); 

	}
}