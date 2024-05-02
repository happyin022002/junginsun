/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchTransCrossChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchTransCrossChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 2011.01.19 이수진 
	  *    : Transit Cross-Check 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchTransCrossChkRSQL(){
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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rad_trans_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rad_lane_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchTransCrossChkRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD, VVD, PORT_CD, ETDA_DT" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, TYPE_A)) TYPE_A" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, PIC_A)) PIC_A" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, TYPE_B)) TYPE_B" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, PIC_B)) PIC_B" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, TYPE_C)) TYPE_C" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, PIC_C)) PIC_C" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, TYPE_D)) TYPE_D" ).append("\n"); 
		query.append(", MAX(DECODE(CUST_OPR_QTY,0,NULL, PIC_D)) PIC_D" ).append("\n"); 
		query.append(", MAX(DECODE(SEND_DIV,'SEND', DECODE(CUST_OPR_QTY,0, DECODE(TYPE_X, NULL, NULL, 'SEND'), NULL)" ).append("\n"); 
		query.append("                     ,'UNSEND',  DECODE(CUST_OPR_QTY,0, ( CASE WHEN TYPE_A = 'A' OR TYPE_A = 'N' OR TYPE_B  = 'B' OR TYPE_C = 'C' THEN NULL" ).append("\n"); 
		query.append("                                                          ELSE 'UNSEND'" ).append("\n"); 
		query.append("                                                          END ), NULL)))TYPE_OTH" ).append("\n"); 
		query.append(", CRR_CD" ).append("\n"); 
		query.append(", DECODE(CRR_CD, 'SML', CUST_OPR_CD,NULL) CUST_OPR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CUST_OPR_QTY, PORT_DIV" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SEND_DIV, SLAN_CD, VVD, PORT_CD, TO_CHAR(ETDA_DT,'YYYY-MM-DD HH24:MI:SS') ETDA_DT, TYPE_A, PIC_A, TYPE_B, PIC_B, TYPE_C, PIC_C, TYPE_D, PIC_D, CRR_CD --TYPE_OTH, PIC_OTH, CRR_CD" ).append("\n"); 
		query.append(", (SELECT RTRIM (XMLAGG (XMLELEMENT (X, OPR_CD || ',') ORDER BY MIN (OPR_CD)).EXTRACT ('//text()').GETSTRINGVAL (), ',')" ).append("\n"); 
		query.append("FROM BAY_PLAN Y" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND Y.VSL_CD = SUBSTR(X.VVD, 1, 4) " ).append("\n"); 
		query.append("AND Y.VOY_NO = SUBSTR(X.VVD, 5, 4) " ).append("\n"); 
		query.append("AND Y.DIR_CD = SUBSTR(X.VVD, 9, 1) " ).append("\n"); 
		query.append("#if (${pol} != '' ) " ).append("\n"); 
		query.append("AND Y.POL = @[pol] " ).append("\n"); 
		query.append("AND Y.PORT_CD = @[pol]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND Y.POD = @[pod] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("GROUP BY OPR_CD" ).append("\n"); 
		query.append(") CUST_OPR_CD" ).append("\n"); 
		query.append(", (SELECT NVL(SUM(DECODE(NVL(OPR_CD,'SML'), 'SML','1','0')),'1')" ).append("\n"); 
		query.append("FROM BAY_PLAN Y" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND Y.VSL_CD = SUBSTR(X.VVD, 1, 4) " ).append("\n"); 
		query.append("AND Y.VOY_NO = SUBSTR(X.VVD, 5, 4) " ).append("\n"); 
		query.append("AND Y.DIR_CD = SUBSTR(X.VVD, 9, 1) " ).append("\n"); 
		query.append("#if (${pol} != '' ) " ).append("\n"); 
		query.append("AND Y.POL = @[pol] " ).append("\n"); 
		query.append("AND Y.PORT_CD = @[pol] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND Y.POD = @[pod] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(") CUST_OPR_QTY" ).append("\n"); 
		query.append(",  TYPE_X, PIC_X" ).append("\n"); 
		query.append(", PORT_DIV" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SEND_DIV, SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VVD, PORT_CD, ETDA_DT" ).append("\n"); 
		query.append("    , MAX(TYPE_A) TYPE_A, MAX(PIC_A) PIC_A, MAX(TYPE_B) TYPE_B, MAX(PIC_B) PIC_B, MAX(TYPE_C) TYPE_C, MAX(PIC_C) PIC_C, MAX(TYPE_D) TYPE_D, MAX(PIC_D) PIC_D" ).append("\n"); 
		query.append("   -- , MIN(TYPE_OTH) TYPE_OTH, MAX(PIC_OTH) PIC_OTH, CRR_CD, PORT_DIV" ).append("\n"); 
		query.append("   , CRR_CD, PORT_DIV, MAX(TYPE_X) TYPE_X, MAX(PIC_X)PIC_X" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT SEND_DIV, SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, PORT_CD, ETDA_DT, CRR_CD" ).append("\n"); 
		query.append("             , TYPE_A, PIC_A, TYPE_B, PIC_B, TYPE_C, PIC_C, TYPE_D, PIC_D, PORT_DIV -- TYPE_OTH, PIC_OTH, PORT_DIV" ).append("\n"); 
		query.append("             ,  TYPE_X, PIC_X" ).append("\n"); 
		query.append("          FROM (      " ).append("\n"); 
		query.append("            SELECT 'SEND' SEND_DIV, SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, PORT_CD, ETDA_DT, CRR_CD, L_TYPE" ).append("\n"); 
		query.append("                   #if (${pol} != '')" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'A', 'A')) TYPE_A, MAX(DECODE(SEL_TYPE, 'A', TRSM_USR_ID)) PIC_A" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'B', 'B')) TYPE_B, MAX(DECODE(SEL_TYPE, 'B', TRSM_USR_ID)) PIC_B" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'C', 'C')) TYPE_C, MAX(DECODE(SEL_TYPE, 'C', TRSM_USR_ID)) PIC_C" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'D', 'D')) TYPE_D, MAX(DECODE(SEL_TYPE, 'D', TRSM_USR_ID)) PIC_D" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'X','X')) TYPE_X, MAX(DECODE(SEL_TYPE, 'X', TRSM_USR_ID)) PIC_X" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'N',TRSM_USR_ID))TYPE_A, '' PIC_A, '' TYPE_B, '' PIC_B, '' TYPE_C, '' PIC_C, '' TYPE_D, '' PIC_D" ).append("\n"); 
		query.append("                 --, '' TYPE_OTH " ).append("\n"); 
		query.append("                 --, MAX(DECODE(CRR_CD,'OTHERS',DECODE(SEL_TYPE, 'D',TRSM_USR_ID)))PIC_OTH " ).append("\n"); 
		query.append("                 , '' TYPE_X, '' PIC_X" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                 , PORT_DIV" ).append("\n"); 
		query.append("                  FROM (    " ).append("\n"); 
		query.append("                    SELECT DISTINCT M.L_TYPE, M.SLAN_CD, M.VSL_CD, M.SKD_VOY_NO, M.SKD_DIR_CD, M.VPS_PORT_CD" ).append("\n"); 
		query.append("                         , M.PORT_CD, M.ETDA_DT, M.TRSM_USR_ID, M.SEL_TYPE, M.CRR_CD, PORT_DIV" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                        SELECT (SELECT DECODE(VSL_SVC_TP_CD, 'J', 'TRUNK','I', 'TRUNK', 'S', 'TRUNK', 'O', 'OFFLINE') FROM MDM_VSL_SVC_LANE WHERE  VSL_SLAN_CD = Z.SLAN_CD AND DELT_FLG  = 'N') L_TYPE" ).append("\n"); 
		query.append("                        , Z.SLAN_CD, Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.VPS_PORT_CD, Z.PORT_CD, Z.ETDA_DT" ).append("\n"); 
		query.append("                        , Z.CRR_CD, K.SND_DT, K.KR_CSTMS_DECL_CD SEL_TYPE, K.TRSM_USR_ID, PORT_DIV" ).append("\n"); 
		query.append("                          FROM (    " ).append("\n"); 
		query.append("                            SELECT DISTINCT V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD" ).append("\n"); 
		query.append("                                 #if (${pol} != '') " ).append("\n"); 
		query.append("                                 , DECODE(D.POL_CD, NULL, DECODE(B.POL,NULL,V.VPS_PORT_CD,B.POL), D.POL_CD) PORT_CD, V.VPS_ETD_DT ETDA_DT, D.POL_CD, B.POL" ).append("\n"); 
		query.append("                                 , DECODE(D.POL_CD, NULL, DECODE(B.POL, NULL, 'X'))PORT_DIV" ).append("\n"); 
		query.append("                                 #else " ).append("\n"); 
		query.append("                                 , DECODE(D.POD_CD, NULL, DECODE(B.POD,NULL,V.VPS_PORT_CD,B.POD), D.POD_CD) PORT_CD, V.VPS_ETA_DT ETDA_DT, D.POD_CD, B.POD" ).append("\n"); 
		query.append("                                 , DECODE(D.POD_CD, NULL, DECODE(B.POD, NULL, 'X'))PORT_DIV" ).append("\n"); 
		query.append("                                 #end  " ).append("\n"); 
		query.append("                                 , C.CRR_CD, V.CLPT_SEQ                                   " ).append("\n"); 
		query.append("                              FROM VSK_VSL_PORT_SKD V, MDM_VSL_CNTR C, BKG_VVD D, BKG_BOOKING K" ).append("\n"); 
		query.append("                             ,  (SELECT B.VSL_CD, B.VOY_NO, B.DIR_CD, #if (${pol} != '') " ).append("\n"); 
		query.append("                                                                      B.POL" ).append("\n"); 
		query.append("                                                                      #else " ).append("\n"); 
		query.append("                                                                      B.POD" ).append("\n"); 
		query.append("                                                                      #end" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD V, BAY_PLAN B" ).append("\n"); 
		query.append("                                 WHERE V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                                   #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                                       #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                                   AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = B.POL" ).append("\n"); 
		query.append("                                   AND B.PORT_CD = @[pol]" ).append("\n"); 
		query.append("                                       #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                                   AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("				                       #if (${rad_vvd} != ''  &&  ${pol} != '' ) " ).append("\n"); 
		query.append("				                   AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                       AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				                   AND V.VPS_PORT_CD = B.POL" ).append("\n"); 
		query.append("                                   AND B.PORT_CD = @[pol]" ).append("\n"); 
		query.append("				                       #elseif (${rad_vvd} != '' &&  ${pod} != '' ) " ).append("\n"); 
		query.append("				                   AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				                   AND V.VPS_PORT_CD = B.POD" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("				                   #end" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = DECODE(@[pol], null, @[pod], @[pol]) " ).append("\n"); 
		query.append("                                   AND V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                   AND V.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD = B.DIR_CD                                   " ).append("\n"); 
		query.append("                                 GROUP BY B.VSL_CD, B.VOY_NO, B.DIR_CD, #if (${pol} != '') " ).append("\n"); 
		query.append("                                                                        B.POL" ).append("\n"); 
		query.append("                                                                        #else " ).append("\n"); 
		query.append("                                                                        B.POD" ).append("\n"); 
		query.append("                                                                        #end)B                                   " ).append("\n"); 
		query.append("                         WHERE V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                           AND  V.VPS_PORT_CD = DECODE(@[pol], null, @[pod], @[pol])  " ).append("\n"); 
		query.append("                           #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                               #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POL_CD(+) = @[pol] " ).append("\n"); 
		query.append("                           AND B.POL(+) = @[pol] " ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = B.POL(+)" ).append("\n"); 
		query.append("                               #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POD_CD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND B.POD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD =@[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = B.POD(+)" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("				               #if (${rad_vvd} != ''  &&  ${pol} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = B.POL(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("				               #elseif (${rad_vvd} != '' &&  ${pod} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = B.POD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                           AND V.SLAN_CD = D.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = D.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = B.VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = B.DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                           AND C.CRR_CD = 'SML'" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND D.BKG_NO = K.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND K.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DISTINCT V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD" ).append("\n"); 
		query.append("                               #if (${pol} != '') " ).append("\n"); 
		query.append("                             , NVL(D.POL_CD,V.VPS_PORT_CD) PORT_CD, V.VPS_ETD_DT ETDA_DT, D.POL_CD, ''" ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD,NULL,'X') PORT_DIV" ).append("\n"); 
		query.append("                               #else " ).append("\n"); 
		query.append("                             , D.POD_CD PORT_CD, V.VPS_ETA_DT ETDA_DT, D.POD_CD, ''" ).append("\n"); 
		query.append("                             , DECODE(D.POD_CD,NULL,'X') PORT_DIV " ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                             , 'OTHERS' CRR_CD, V.CLPT_SEQ" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V, MDM_VSL_CNTR C, BKG_VVD D, BKG_BOOKING K" ).append("\n"); 
		query.append("                         WHERE V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                           AND  V.VPS_PORT_CD = DECODE(@[pol], null, @[pod], @[pol])  " ).append("\n"); 
		query.append("                           #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                               #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POL_CD(+) = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POD_CD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("				               #if (${rad_vvd} != ''  &&  ${pol} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("				               #elseif (${rad_vvd} != '' &&  ${pod} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           AND V.SLAN_CD = D.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = D.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                           AND C.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND D.BKG_NO = K.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND K.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                               )Z, BKG_CSTMS_KR_SND_LOG K" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND Z.CRR_CD LIKE @[opr_type]||'%'" ).append("\n"); 
		query.append("                           AND Z.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("                           AND Z.SKD_VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND Z.SKD_DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND K.KR_CSTMS_DECL_CD  LIKE null||'%'" ).append("\n"); 
		query.append("                           #if (${pol} != '') " ).append("\n"); 
		query.append("                           AND K.MSG_LOG_TP_ID = '5CD'" ).append("\n"); 
		query.append("                           AND Z.PORT_CD = K.POL_CD" ).append("\n"); 
		query.append("                               #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                           AND K.SND_DT  BETWEEN Z.ETDA_DT -6 AND (Z.ETDA_DT  +4)" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                           AND Z.CLPT_SEQ NOT IN (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD VV WHERE VV.VSL_CD = Z.VSL_CD AND VV.SKD_VOY_NO = Z.SKD_VOY_NO AND VV.SKD_DIR_CD = Z.SKD_DIR_CD)       " ).append("\n"); 
		query.append("                           #else " ).append("\n"); 
		query.append("                           AND K.MSG_LOG_TP_ID = '5IB' " ).append("\n"); 
		query.append("                           AND Z.PORT_CD = K.POD_CD" ).append("\n"); 
		query.append("                               #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                           AND K.SND_DT  BETWEEN Z.ETDA_DT -5 AND (Z.ETDA_DT) " ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           AND Z.CLPT_SEQ <> '1' " ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                           )M" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       #if (${pol} != '') " ).append("\n"); 
		query.append("                       AND (M.SND_DT, M.SEL_TYPE) IN (SELECT MAX(G.SND_DT), KR_CSTMS_DECL_CD FROM BKG_CSTMS_KR_SND_LOG G" ).append("\n"); 
		query.append("                                                       WHERE G.VSL_CD = M.VSL_CD AND G.SKD_VOY_NO = M.SKD_VOY_NO AND G.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND G.POL_CD =M.PORT_CD" ).append("\n"); 
		query.append("                                                         AND G.MSG_LOG_TP_ID = '5CD'" ).append("\n"); 
		query.append("                                                         #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                                                             #if (${dep_type} == 'ETD')" ).append("\n"); 
		query.append("                                                         AND G.SND_DT  BETWEEN M.ETDA_DT -6 AND (M.ETDA_DT  +4)" ).append("\n"); 
		query.append("                                                             #end" ).append("\n"); 
		query.append("                                                         #end" ).append("\n"); 
		query.append("                                                       GROUP BY KR_CSTMS_DECL_CD)" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                       AND (M.SND_DT, M.SEL_TYPE) IN (SELECT MAX(G.SND_DT), KR_CSTMS_DECL_CD FROM BKG_CSTMS_KR_SND_LOG G " ).append("\n"); 
		query.append("                                                       WHERE G.VSL_CD = M.VSL_CD AND G.SKD_VOY_NO = M.SKD_VOY_NO AND G.SKD_DIR_CD = M.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                         AND G.POD_CD = M.PORT_CD " ).append("\n"); 
		query.append("                                                         AND G.MSG_LOG_TP_ID = '5IB' " ).append("\n"); 
		query.append("                                                         #if (${rad_dep_type} != '')" ).append("\n"); 
		query.append("                                                             #if (${dep_type} == 'ETA') " ).append("\n"); 
		query.append("                                                         AND G.SND_DT  BETWEEN M.ETDA_DT -5 AND (M.ETDA_DT ) " ).append("\n"); 
		query.append("                                                             #end" ).append("\n"); 
		query.append("                                                         #end " ).append("\n"); 
		query.append("                                                       GROUP BY KR_CSTMS_DECL_CD) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       AND L_TYPE LIKE @[rad_lane_type]||'%'" ).append("\n"); 
		query.append("                       )     " ).append("\n"); 
		query.append("                WHERE SEL_TYPE LIKE @[sel_type]||'%'" ).append("\n"); 
		query.append("                GROUP BY  SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD, PORT_CD, ETDA_DT, CRR_CD, L_TYPE, PORT_DIV" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE @[rad_trans_type] = 'SEND' OR  @[rad_trans_type] = 'ALL'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT 'UNSEND' SEND_DIV, SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, PORT_CD, ETDA_DT, CRR_CD" ).append("\n"); 
		query.append("             , TYPE_A, PIC_A, TYPE_B, PIC_B, TYPE_C, PIC_C, TYPE_D, PIC_D, PORT_DIV --TYPE_OTH, PIC_OTH, PORT_DIV" ).append("\n"); 
		query.append("             , TYPE_X, PIC_X" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("            SELECT SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, PORT_CD, ETDA_DT, CRR_CD" ).append("\n"); 
		query.append("                   #if (${pol} != '')" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'A', 'UNSEND')) TYPE_A, '' PIC_A" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'B', 'UNSEND')) TYPE_B, '' PIC_B" ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE, 'C', 'UNSEND')) TYPE_C, '' PIC_C" ).append("\n"); 
		query.append("                 , '' TYPE_D, '' PIC_D" ).append("\n"); 
		query.append("               --  , MAX(DECODE(CRR_CD,'OTHERS',DECODE(SEL_TYPE,NULL,'','UNSEND'))) TYPE_OTH, '' PIC_OTH" ).append("\n"); 
		query.append("                , PORT_DIV" ).append("\n"); 
		query.append("                   #else " ).append("\n"); 
		query.append("                 , MAX(DECODE(SEL_TYPE,'N','UNSEND')) TYPE_A, '' PIC_A " ).append("\n"); 
		query.append("                 , '' TYPE_B, '' PIC_B, '' TYPE_C, '' PIC_C, '' TYPE_D, '' PIC_D " ).append("\n"); 
		query.append("                -- , '' TYPE_OTH, MAX(DECODE(CRR_CD, 'OTHERS', DECODE(SEL_TYPE,NULL,'','UNSEND'))) PIC_OTH " ).append("\n"); 
		query.append("                 , PORT_DIV" ).append("\n"); 
		query.append("                   #end " ).append("\n"); 
		query.append("                 , '' TYPE_X, '' PIC_X" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT M.L_TYPE, M.SLAN_CD, M.VSL_CD, M.SKD_VOY_NO, M.SKD_DIR_CD" ).append("\n"); 
		query.append("                , M.PORT_CD, M.ETDA_DT" ).append("\n"); 
		query.append("                , M.SEL_TYPE" ).append("\n"); 
		query.append("                , M.CRR_CD" ).append("\n"); 
		query.append("                , PORT_DIV" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT (SELECT DECODE(VSL_SVC_TP_CD, 'J', 'TRUNK','I', 'TRUNK', 'S', 'TRUNK', 'O', 'OFFLINE') FROM MDM_VSL_SVC_LANE WHERE  VSL_SLAN_CD = Z.SLAN_CD AND DELT_FLG  = 'N') L_TYPE" ).append("\n"); 
		query.append("                         , Z.SLAN_CD, Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.PORT_CD, Z.ETDA_DT" ).append("\n"); 
		query.append("                         , SEL_TYPE, Z.CRR_CD, PORT_DIV" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                        SELECT DISTINCT V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD" ).append("\n"); 
		query.append("                               #if (${pol} != '') " ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD, NULL, DECODE(B.POL,NULL,V.VPS_PORT_CD,B.POL), D.POL_CD) PORT_CD, V.VPS_ETD_DT ETDA_DT, D.POL_CD, B.POL" ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD, NULL, DECODE(B.POL, NULL, 'X'))PORT_DIV" ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD, NULL, NULL, K.POL_CD, DECODE(SUBSTR(K.POD_CD,1,2), 'US', 'A', 'CA','A','MX','A','GT','A','B'), 'C') SEL_TYPE" ).append("\n"); 
		query.append("                               #else " ).append("\n"); 
		query.append("                             , DECODE(D.POD_CD, NULL, DECODE(B.POD,NULL,V.VPS_PORT_CD,B.POD), D.POD_CD) PORT_CD, V.VPS_ETA_DT ETDA_DT, D.POD_CD, B.POD" ).append("\n"); 
		query.append("                             , DECODE(D.POD_CD, NULL, DECODE(B.POD, NULL, 'X'))PORT_DIV" ).append("\n"); 
		query.append("                             , 'N' SEL_TYPE" ).append("\n"); 
		query.append("                               #end   " ).append("\n"); 
		query.append("                             , C.CRR_CD, V.CLPT_SEQ " ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V, MDM_VSL_CNTR C, BKG_VVD D, BKG_BOOKING K" ).append("\n"); 
		query.append("                             ,  (SELECT B.VSL_CD, B.VOY_NO, B.DIR_CD, #if (${pol} != '') " ).append("\n"); 
		query.append("                                                                      B.POL" ).append("\n"); 
		query.append("                                                                      #else " ).append("\n"); 
		query.append("                                                                      B.POD" ).append("\n"); 
		query.append("                                                                      #end" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD V, BAY_PLAN B" ).append("\n"); 
		query.append("                                 WHERE V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                                   #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                                       #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                                   AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = B.POL" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = @[pol] " ).append("\n"); 
		query.append("                                   AND B.PORT_CD = @[pol]" ).append("\n"); 
		query.append("                                       #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                                   AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("				                       #if (${rad_vvd} != ''  &&  ${pol} != '' ) " ).append("\n"); 
		query.append("				                   AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                       AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				                   AND V.VPS_PORT_CD = B.POL" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("                                  AND B.PORT_CD = @[pol]" ).append("\n"); 
		query.append("				                       #elseif (${rad_vvd} != '' &&  ${pod} != '' ) " ).append("\n"); 
		query.append("				                   AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("				                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				                   AND V.VPS_PORT_CD = B.POD" ).append("\n"); 
		query.append("                                   AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("				                   #end" ).append("\n"); 
		query.append("                                   AND V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                   AND V.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                                   AND V.SKD_DIR_CD = B.DIR_CD                                   " ).append("\n"); 
		query.append("                                 GROUP BY B.VSL_CD, B.VOY_NO, B.DIR_CD, #if (${pol} != '') " ).append("\n"); 
		query.append("                                                                        B.POL" ).append("\n"); 
		query.append("                                                                        #else " ).append("\n"); 
		query.append("                                                                        B.POD" ).append("\n"); 
		query.append("                                                                        #end)B                                   " ).append("\n"); 
		query.append("                         WHERE V.CLPT_IND_SEQ = '1'  " ).append("\n"); 
		query.append("                           AND  V.VPS_PORT_CD = DECODE(@[pol], null, @[pod], @[pol])                 " ).append("\n"); 
		query.append("                           #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                               #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POL_CD(+) = @[pol]" ).append("\n"); 
		query.append("                           AND B.POL(+) = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = B.POL(+)" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                               #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POD_CD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND B.POD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = B.POD(+)" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("				               #if (${rad_vvd} != ''  &&  ${pol} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = B.POL(+)" ).append("\n"); 
		query.append("				               #elseif (${rad_vvd} != '' &&  ${pod} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = B.POD(+)" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                           AND V.SLAN_CD = D.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = D.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = B.VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = B.DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                           AND C.CRR_CD = 'SML'" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND D.BKG_NO = K.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND K.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT DISTINCT V.SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD" ).append("\n"); 
		query.append("                               #if (${pol} != '') " ).append("\n"); 
		query.append("                             , NVL(D.POL_CD,V.VPS_PORT_CD) PORT_CD, V.VPS_ETD_DT ETDA_DT, D.POL_CD, ''" ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD,NULL,'X') PORT_DIV" ).append("\n"); 
		query.append("                             , DECODE(D.POL_CD, NULL, NULL, K.POL_CD, DECODE(SUBSTR(K.POD_CD,1,2), 'US', 'A', 'CA','A','MX','A','GT','A','B'), 'C') SEL_TYPE" ).append("\n"); 
		query.append("                               #else" ).append("\n"); 
		query.append("                             , NVL(D.POD_CD,V.VPS_PORT_CD) PORT_CD, V.VPS_ETA_DT ETDA_DT, D.POD_CD, ''" ).append("\n"); 
		query.append("                             , DECODE(D.POD_CD,NULL,'X') PORT_DIV" ).append("\n"); 
		query.append("                             , 'N' SEL_TYPE" ).append("\n"); 
		query.append("                               #end                             " ).append("\n"); 
		query.append("                             , 'OTHERS' CRR_CD, V.CLPT_SEQ" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V, MDM_VSL_CNTR C, BKG_VVD D, BKG_BOOKING K" ).append("\n"); 
		query.append("                         WHERE V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                           AND  V.VPS_PORT_CD = DECODE(@[pol], null, @[pod], @[pol])  " ).append("\n"); 
		query.append("                           #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                               #if (${dep_type} == 'ETD'  &&  ${pol} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETD_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POL_CD(+) = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               #elseif (${dep_type} == 'ETA' &&  ${pod} != '' )" ).append("\n"); 
		query.append("                           AND V.VPS_ETA_DT BETWEEN TO_DATE(@[start_dt],'YYYY-MM-DD') AND TO_DATE(@[end_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                           AND D.POD_CD(+) = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                           AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #else" ).append("\n"); 
		query.append("				               #if (${rad_vvd} != ''  &&  ${pol} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POL_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("				               #elseif (${rad_vvd} != '' &&  ${pod} != '' )" ).append("\n"); 
		query.append("				               AND V.VSL_CD = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("				               AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("			                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("				               AND V.VPS_PORT_CD = D.POD_CD(+)" ).append("\n"); 
		query.append("                               AND V.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                           AND V.SLAN_CD = D.SLAN_CD(+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = D.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                           AND C.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND D.BKG_NO = K.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND K.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                        )Z" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND Z.CRR_CD LIKE @[opr_type]||'%'" ).append("\n"); 
		query.append("                       #if (${pol} != '') " ).append("\n"); 
		query.append("                       AND Z.CLPT_SEQ NOT IN (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD VV WHERE VV.VSL_CD = Z.VSL_CD AND VV.SKD_VOY_NO = Z.SKD_VOY_NO AND VV.SKD_DIR_CD = Z.SKD_DIR_CD)" ).append("\n"); 
		query.append("                       AND (Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.PORT_CD, Z.SEL_TYPE) NOT IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, DECODE(KR_CSTMS_DECL_CD,'D', Z.SEL_TYPE, KR_CSTMS_DECL_CD)" ).append("\n"); 
		query.append("                                                                                                  FROM BKG_CSTMS_KR_SND_LOG G" ).append("\n"); 
		query.append("                                                                                                 WHERE G.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("                                                                                                   AND G.SKD_VOY_NO = Z.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                   AND G.SKD_DIR_CD = Z.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                   AND G.POL_CD = Z.PORT_CD" ).append("\n"); 
		query.append("                                                                                                   AND G.MSG_LOG_TP_ID = '5CD'" ).append("\n"); 
		query.append("                                                                                                   #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                                                                                                   AND G.SND_DT BETWEEN Z.ETDA_DT -6 AND (Z.ETDA_DT +4)" ).append("\n"); 
		query.append("                                                                                                   #end   )   " ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                       AND Z.CLPT_SEQ <> '1' " ).append("\n"); 
		query.append("                       AND (Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.PORT_CD, Z.SEL_TYPE) NOT IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POD_CD, DECODE(KR_CSTMS_DECL_CD,'D', Z.SEL_TYPE, KR_CSTMS_DECL_CD) " ).append("\n"); 
		query.append("                                                                                                  FROM BKG_CSTMS_KR_SND_LOG G " ).append("\n"); 
		query.append("                                                                                                 WHERE G.VSL_CD = Z.VSL_CD " ).append("\n"); 
		query.append("                                                                                                   AND G.SKD_VOY_NO = Z.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                                                                   AND G.SKD_DIR_CD = Z.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                                                   AND G.POD_CD = Z.PORT_CD " ).append("\n"); 
		query.append("                                                                                                   AND G.MSG_LOG_TP_ID = '5IB' " ).append("\n"); 
		query.append("                                                                                                   #if (${rad_dep_type} != '') " ).append("\n"); 
		query.append("                                                                                                   AND G.SND_DT BETWEEN Z.ETDA_DT -5 AND (Z.ETDA_DT ) " ).append("\n"); 
		query.append("                                                                                                   #end ) " ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       )M" ).append("\n"); 
		query.append("                 WHERE L_TYPE LIKE @[rad_lane_type]||'%'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${sel_type} != '') " ).append("\n"); 
		query.append("                   AND SEL_TYPE LIKE @[sel_type]||'%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("             GROUP BY SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD, PORT_CD, ETDA_DT, CRR_CD, PORT_DIV" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE @[rad_trans_type] = 'UNSEND' OR   @[rad_trans_type] = 'ALL'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    GROUP BY SEND_DIV, SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VVD, PORT_CD, ETDA_DT, CRR_CD, PORT_DIV" ).append("\n"); 
		query.append("       )X" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ( NVL(PORT_DIV,' ') <> 'X' or ( CUST_OPR_QTY = 0  and crr_cd = 'SML'))" ).append("\n"); 
		query.append("GROUP BY SLAN_CD, VVD, PORT_CD, ETDA_DT,CRR_CD, CUST_OPR_CD, CUST_OPR_QTY, PORT_DIV" ).append("\n"); 
		query.append("ORDER BY ETDA_DT" ).append("\n"); 

	}
}