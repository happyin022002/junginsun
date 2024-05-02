/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOsearchVgmCrossCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOsearchVgmCrossCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VGM Closing Status Report
	  * </pre>
	  */
	public StatusReportDBDAOsearchVgmCrossCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_atd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_etd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOsearchVgmCrossCheckListRSQL").append("\n"); 
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
		query.append("#if (${p_dt_type} == 'ETD' && ${p_atd} != '' && ${p_etd} != '')" ).append("\n"); 
		query.append("WITH SKD_V AS (" ).append("\n"); 
		query.append("    SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD,CLPT_IND_SEQ,VPS_PORT_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("    WHERE VPS_ETD_DT      >=  TO_DATE(@[p_atd],'yyyy-mm-dd')" ).append("\n"); 
		query.append("    AND   VPS_ETD_DT      <=  TO_DATE(@[p_etd],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${p_dt_type} == 'VGM' && ${p_atd} != '' && ${p_etd} != '')" ).append("\n"); 
		query.append("WITH VGM_V AS (" ).append("\n"); 
		query.append("    SELECT  BKG_NO" ).append("\n"); 
		query.append("    FROM BKG_CLZ_TM TM       " ).append("\n"); 
		query.append("    WHERE TM.CLZ_TP_CD = 'V' -- VGM " ).append("\n"); 
		query.append("    AND NVL(TM.MNL_SET_DT,TM.SYS_SET_DT) >=  TO_DATE(@[p_atd],'yyyy-mm-dd')" ).append("\n"); 
		query.append("    AND NVL(TM.MNL_SET_DT,TM.SYS_SET_DT) <=  TO_DATE(@[p_etd],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("    AND NVL(TM.MNL_SET_DT,TM.SYS_SET_DT) IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    SELECT Y.* , SUM(VGM_CNT_TARGET) OVER() TOTAL_VGM_CNT, TO_NUMBER(CNTR_CNT_TARGET) TOTAL_CNTR_CNT" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                  SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                  WHERE VPS.VSL_CD      =  Y.VSL_CD" ).append("\n"); 
		query.append("                  AND VPS.SKD_VOY_NO    =  Y.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VPS.SKD_DIR_CD    =  Y.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VPS.CLPT_IND_SEQ  =  Y.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND VPS.VPS_PORT_CD   =  Y.POL_CD" ).append("\n"); 
		query.append("                  AND Y.VSL_PRE_PST_CD||Y.VSL_SEQ = (SELECT MIN(Z.VSL_PRE_PST_CD||Z.VSL_SEQ) FROM BKG_VVD Z WHERE Z.BKG_NO = Y.BKG_NO)" ).append("\n"); 
		query.append("                ) VPS_ETD_DT" ).append("\n"); 
		query.append("               , 0 TOTAL_NO_VGM_CNT " ).append("\n"); 
		query.append("               , NVL((SELECT CUST_REF_NO_CTNT FROM BKG_REFERENCE Z WHERE Y.BKG_NO = Z.BKG_NO AND Z.BKG_REF_TP_CD = 'EBRF' ),'') REF_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("                DENSE_RANK() OVER( ORDER BY BKG.BKG_NO) DENSE_RANK," ).append("\n"); 
		query.append("                BKG.BKG_NO," ).append("\n"); 
		query.append("                BKG.BL_NO," ).append("\n"); 
		query.append("                BKG.BKG_OFC_CD, /*BKG OFC*/" ).append("\n"); 
		query.append("                BKG.OB_SLS_OFC_CD,/*Sales Office*/" ).append("\n"); 
		query.append("                BKG.CTRT_OFC_CD, /*Ctrt Office Code */" ).append("\n"); 
		query.append("                BKG.BKG_STS_CD,/*status1*/                                                 " ).append("\n"); 
		query.append("                BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'99990.99'))" ).append("\n"); 
		query.append("                                     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                     ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                ) QTY_BKG,/*QTY-BKG*/" ).append("\n"); 
		query.append("                BKG_JOIN_FNC( CURSOR(SELECT  CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(CNTR_VOL_QTY), 0),'99990.99'))" ).append("\n"); 
		query.append("                                     FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("                                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                     GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                ) QTY_CNTR,/*QTY-CNTR*/" ).append("\n"); 
		query.append("                B.CNTR_NO CNTR_NO,/*NO.*/" ).append("\n"); 
		query.append("                B.CNTR_TPSZ_CD SZ, /*SZ*/" ).append("\n"); 
		query.append("                B.CNTR_WGT, /*Weight*/        " ).append("\n"); 
		query.append("                B.WGT_UT_CD,                  " ).append("\n"); 
		query.append("                VGM_WGT," ).append("\n"); 
		query.append("                VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("                VGM_MZD_TP_CD," ).append("\n"); 
		query.append("                NVL(B.CNTR_VOL_QTY,0) VOL, /*Vol*/" ).append("\n"); 
		query.append("                BKG.DEL_CD," ).append("\n"); 
		query.append("                BKG.POR_CD," ).append("\n"); 
		query.append("                VVD.POL_CD," ).append("\n"); 
		query.append("                VVD.POD_CD," ).append("\n"); 
		query.append("                VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD  AS VVD_CD," ).append("\n"); 
		query.append("                VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POL_CLPT_IND_SEQ,VVD.VSL_PRE_PST_CD,VVD.VSL_SEQ," ).append("\n"); 
		query.append("                (CASE WHEN NVL(VGM_WGT,0) > 0 AND NVL(VGM_WGT_UT_CD,'X') != 'X' AND NVL(VGM_VRFY_SIG_CTNT,'X') != 'X' " ).append("\n"); 
		query.append("                       THEN NVL(B.CNTR_VOL_QTY,0)" ).append("\n"); 
		query.append("                       ELSE 0 " ).append("\n"); 
		query.append("                END) VGM_CNT_TARGET,  " ).append("\n"); 
		query.append("                COUNT(DISTINCT BKG.BKG_NO) OVER() TOTAL_BKG," ).append("\n"); 
		query.append("                BKG_JOIN_FNC( CURSOR(SELECT  NVL(SUM(OP_CNTR_QTY), 0)" ).append("\n"); 
		query.append("                                     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                     AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                     AND CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                ) CNTR_CNT_TARGET," ).append("\n"); 
		query.append("                VVD.POL_YD_CD," ).append("\n"); 
		query.append("                VVD.SLAN_CD," ).append("\n"); 
		query.append("                S.CUST_NM SHPR_NAME," ).append("\n"); 
		query.append("                S.CUST_CNT_CD||S.CUST_SEQ SHIPPER," ).append("\n"); 
		query.append("                TO_CHAR(NVL(TM.MNL_SET_DT,TM.SYS_SET_DT),'YYYY-MM-DD HH24:MI') VGM_SET_DT" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING BKG," ).append("\n"); 
		query.append("                BKG_CONTAINER B," ).append("\n"); 
		query.append("                BKG_VVD VVD," ).append("\n"); 
		query.append("                BKG_CUSTOMER S," ).append("\n"); 
		query.append("                BKG_CLZ_TM TM" ).append("\n"); 
		query.append("        WHERE  BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("               AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("               AND S.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = TM.BKG_NO(+)" ).append("\n"); 
		query.append("               AND TM.CLZ_TP_CD(+) = 'V' -- VGM " ).append("\n"); 
		query.append("        #if(${vvd_arr} != '')" ).append("\n"); 
		query.append("               AND (VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD ) IN (" ).append("\n"); 
		query.append("          #foreach($vvd_str IN ${vvd_arr})" ).append("\n"); 
		query.append("            #if($velocityCount < $vvd_arr.size())" ).append("\n"); 
		query.append("                    (SUBSTR('$vvd_str',1,4),SUBSTR('$vvd_str',5,4),SUBSTR('$vvd_str',9,1))," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                    (SUBSTR('$vvd_str',1,4),SUBSTR('$vvd_str',5,4),SUBSTR('$vvd_str',9,1))" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_pol_cd} != '')" ).append("\n"); 
		query.append("               AND VVD.POL_CD LIKE '%'||@[p_pol_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_pol_lt} == 'LC') " ).append("\n"); 
		query.append("            AND BKG.POL_CD  = VVD.POL_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_pol_lt} == 'TS') " ).append("\n"); 
		query.append("            AND BKG.POL_CD  != VVD.POL_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("          #if (${p_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND BKG.BKG_OFC_CD IN " ).append("\n"); 
		query.append("                     ( SELECT OFC_CD " ).append("\n"); 
		query.append("                         FROM MDM_ORGANIZATION A " ).append("\n"); 
		query.append("                        START WITH A.OFC_CD LIKE '%'||@[p_bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("                      CONNECT BY PRIOR  A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("          #else  " ).append("\n"); 
		query.append("             AND BKG.BKG_OFC_CD LIKE '%'||@[p_bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_rhq_cd} != '')" ).append("\n"); 
		query.append("               AND EXISTS (" ).append("\n"); 
		query.append("                     SELECT  'Y' " ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                       SELECT A.OFC_CD" ).append("\n"); 
		query.append("                       FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                       START WITH A.OFC_CD = @[p_rhq_cd]" ).append("\n"); 
		query.append("                       CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("                       ) X" ).append("\n"); 
		query.append("                     WHERE  X.OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("        #if (${p_dt_type} == 'ETD' && ${p_atd} != '' && ${p_etd} != '')" ).append("\n"); 
		query.append("               AND EXISTS (" ).append("\n"); 
		query.append("                     SELECT  'Y' " ).append("\n"); 
		query.append("                     FROM SKD_V VPS " ).append("\n"); 
		query.append("                     WHERE VPS.VSL_CD       =  VVD.VSL_CD" ).append("\n"); 
		query.append("                      AND VPS.SKD_VOY_NO    =  VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND VPS.SKD_DIR_CD    =  VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND VPS.CLPT_IND_SEQ  =  VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                      AND VPS.VPS_PORT_CD   =  VVD.POL_CD" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("        #elseif (${p_dt_type} == 'VGM' && ${p_atd} != '' && ${p_etd} != '')" ).append("\n"); 
		query.append("               AND EXISTS (" ).append("\n"); 
		query.append("                     SELECT  'Y' " ).append("\n"); 
		query.append("                     FROM VGM_V X" ).append("\n"); 
		query.append("                     WHERE X.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${p_vgm_flg} =='Y')" ).append("\n"); 
		query.append("               AND NVL(B.VGM_WGT,0) > 0" ).append("\n"); 
		query.append("               AND NVL(B.VGM_WGT_UT_CD,'X') != 'X'" ).append("\n"); 
		query.append("               AND NVL(B.VGM_VRFY_SIG_CTNT,'X') != 'X'" ).append("\n"); 
		query.append("        #elseif(${p_vgm_flg} =='I')" ).append("\n"); 
		query.append("               AND NVL(B.VGM_WGT,0) > 0 " ).append("\n"); 
		query.append("               AND NVL(B.VGM_VRFY_SIG_CTNT,'X') = 'X'" ).append("\n"); 
		query.append("        #elseif(${p_vgm_flg} =='N')" ).append("\n"); 
		query.append("               AND NVL(B.VGM_WGT,0) = 0 " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ORDER BY BKG.BKG_NO, B.CNTR_NO" ).append("\n"); 
		query.append("    ) Y" ).append("\n"); 

	}
}