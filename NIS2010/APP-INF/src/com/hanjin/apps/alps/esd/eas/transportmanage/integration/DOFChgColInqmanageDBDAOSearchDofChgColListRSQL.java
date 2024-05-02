/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DOFChgColInqmanageDBDAOSearchDofChgColListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgColInqmanageDBDAOSearchDofChgColListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDofChgColList SELECT LIST
	  * </pre>
	  */
	public DOFChgColInqmanageDBDAOSearchDofChgColListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromtrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("haul_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tromonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("totrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("return_cy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgColInqmanageDBDAOSearchDofChgColListRSQL").append("\n"); 
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
		query.append("--DOFChgColInqmanageDBDAOSearchDofChgColListRSQL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT D.NOD_CD" ).append("\n"); 
		query.append("FROM  SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.BKG_NO = MAIN.BKG_NO" ).append("\n"); 
		query.append("AND H.CNTR_NO = MAIN.CNTR_NO" ).append("\n"); 
		query.append("AND D.ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") COP_RTN_YD_CD," ).append("\n"); 
		query.append("CS.CUST_CNT_CD||LPAD(CS.CUST_SEQ,6,0) MER_CD, --2011-10-27 추가" ).append("\n"); 
		query.append("DECODE(CS.RVIS_CNTR_CUST_TP_CD,'B','BCO','N','Non-BCO') AS CUST_TP,  --2011-10-21 추가" ).append("\n"); 
		query.append("''                                AS SEQ," ).append("\n"); 
		query.append("MAIN.CRE_OFC_CD," ).append("\n"); 
		query.append("MAIN.BKG_NO," ).append("\n"); 
		query.append("MAIN.BL_NO," ).append("\n"); 
		query.append("CS.CUST_LGL_ENG_NM                AS CUST_CD," ).append("\n"); 
		query.append("MAIN.CNTR_NO," ).append("\n"); 
		query.append("MAIN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MAIN.POR_CD," ).append("\n"); 
		query.append("MAIN.POL_CD," ).append("\n"); 
		query.append("MAIN.POD_CD," ).append("\n"); 
		query.append("MAIN.DEL_CD," ).append("\n"); 
		query.append("TO_CHAR(MAIN.CRE_DT,'YYYY/MM/DD') AS CRE_DT," ).append("\n"); 
		query.append("MAIN.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("MAIN.ORG_YD_CD," ).append("\n"); 
		query.append("NVL(MAIN.CURR_CD,'EUR')           AS CURR_CD," ).append("\n"); 
		query.append("MAIN.HLG_TP_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN MAX(NVL(MAIN.CHRR_FRT_TAX_VAL,0)) > 1000000000" ).append("\n"); 
		query.append("THEN MAX(NVL(MAIN.CHRR_FRT_TAX_VAL,0)) / 10000000000" ).append("\n"); 
		query.append("ELSE MAX(NVL(MAIN.CHRR_FRT_TAX_VAL,0))" ).append("\n"); 
		query.append("END                                   AS TAR_AMT," ).append("\n"); 
		query.append("SUM(NVL(MAIN.TRNS_REV_AMT,0))     AS TRO_AMT," ).append("\n"); 
		query.append("MAX(NVL(MAIN.TRNS_REV_AMT,0))     AS TRO_AMT_MX," ).append("\n"); 
		query.append("SUM(NVL(MAIN.DIF_AMT,0))          AS DOD_AMT," ).append("\n"); 
		query.append("MAX(NVL(MAIN.DIF_AMT,0))          AS DOD_AMT_MX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TMP.CRE_OFC_CD," ).append("\n"); 
		query.append("TMP.BKG_NO," ).append("\n"); 
		query.append("TMP.BL_NO," ).append("\n"); 
		query.append("TMP.CUST_CNT_CD," ).append("\n"); 
		query.append("TMP.CUST_SEQ," ).append("\n"); 
		query.append("TMP.CNTR_NO," ).append("\n"); 
		query.append("TMP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TMP.POR_CD," ).append("\n"); 
		query.append("TMP.POL_CD," ).append("\n"); 
		query.append("TMP.POD_CD," ).append("\n"); 
		query.append("TMP.DEL_CD," ).append("\n"); 
		query.append("TMP.CRE_DT," ).append("\n"); 
		query.append("TMP.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("TMP.ORG_YD_CD," ).append("\n"); 
		query.append("TMP.CURR_CD," ).append("\n"); 
		query.append("TMP.HLG_TP_CD," ).append("\n"); 
		query.append("TMP.DIF_AMT," ).append("\n"); 
		query.append("TMP.TRNS_REV_AMT," ).append("\n"); 
		query.append("CASE TRF.CONTI_CD" ).append("\n"); 
		query.append("WHEN NULL" ).append("\n"); 
		query.append("THEN TRF.CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("WHEN ' '" ).append("\n"); 
		query.append("THEN TRF.CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOC.LOC_CD   = TMP.POR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN TRF.CHRR_FRT_TAX_VAL * 10000000000" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO BL_NO," ).append("\n"); 
		query.append("BCS.CUST_CNT_CD," ).append("\n"); 
		query.append("BCS.CUST_SEQ," ).append("\n"); 
		query.append("BCN.CNTR_NO," ).append("\n"); 
		query.append("BCN.CNMV_ID_NO," ).append("\n"); 
		query.append("BCN.CNMV_YR," ).append("\n"); 
		query.append("BCN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BTR.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("BTR.CRE_DT," ).append("\n"); 
		query.append("CMV.MVMT_STS_CD," ).append("\n"); 
		query.append("CMV.ORG_YD_CD," ).append("\n"); 
		query.append("BTR.CURR_CD," ).append("\n"); 
		query.append("BTR.HLG_TP_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL (BTR.TRNS_REV_AMT, 0)" ).append("\n"); 
		query.append("+ NVL (BTR.NMF_TRNS_REV_AMT,0)" ).append("\n"); 
		query.append(")                                AS TRNS_REV_AMT," ).append("\n"); 
		query.append("ARM.LOCL_CURR_CD               AS AR_CURR_CD," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (CHG_AMT * INV_XCH_RT)" ).append("\n"); 
		query.append("FROM INV_AR_CHG ARC" ).append("\n"); 
		query.append("WHERE ARC.CHG_CD   = 'DOD'" ).append("\n"); 
		query.append("AND ARC.AR_IF_NO = ARM.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")                               AS DIF_AMT" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO   BTR," ).append("\n"); 
		query.append("BKG_BOOKING   BKG," ).append("\n"); 
		query.append("BKG_CUSTOMER  BCS," ).append("\n"); 
		query.append("BKG_CONTAINER BCN," ).append("\n"); 
		query.append("CTM_MOVEMENT  CMV," ).append("\n"); 
		query.append("INV_AR_MN     ARM" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${ctrl_ofc_cd} != '' )" ).append("\n"); 
		query.append("AND    BTR.CRE_OFC_CD in (" ).append("\n"); 
		query.append("#foreach($ctrl_ofc_cd_num IN ${ctrl_ofc_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $ctrl_ofc_cd.size())" ).append("\n"); 
		query.append("'$ctrl_ofc_cd_num'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$ctrl_ofc_cd_num'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${search_choice} == 'MM' )" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMM')= @[tromonth]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') >= @[fromtrodate]" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') <= @[totrodate] + 0.999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BTR.HLG_TP_CD                    = @[haul_cd]" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD                    = 'I'" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCN.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCS.BKG_NO" ).append("\n"); 
		query.append("AND SUBSTR (BTR.CNTR_RTN_YD_CD,1,5) != BKG.POD_CD" ).append("\n"); 
		query.append("AND BTR.CNTR_NO    = BCN.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNTR_NO    = CMV.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_ID_NO = CMV.CNMV_ID_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_YR    = CMV.CNMV_YR" ).append("\n"); 
		query.append("AND BTR.BKG_NO     = ARM.BKG_NO(+)" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD  = ARM.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND BCS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("##                                     SELECT  --2011-10-21 제거" ).append("\n"); 
		query.append("##                                            MIN (BCS2.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("##                                       FROM BKG_CUSTOMER BCS2" ).append("\n"); 
		query.append("##                                      WHERE BCS2.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("##                                        AND BCS2.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("##                                         IN" ).append("\n"); 
		query.append("##                                          (" ).append("\n"); 
		query.append("##                                            'C','N'" ).append("\n"); 
		query.append("##                                          )" ).append("\n"); 
		query.append("SELECT BCS2.BKG_CUST_TP_CD  --2011-10-21 추가" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER BCS2" ).append("\n"); 
		query.append("WHERE BCS2.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND BCS2.BKG_CUST_TP_CD = DECODE(BKG.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO," ).append("\n"); 
		query.append("BCS.CUST_CNT_CD," ).append("\n"); 
		query.append("BCS.CUST_SEQ," ).append("\n"); 
		query.append("BCN.CNTR_NO," ).append("\n"); 
		query.append("BCN.CNMV_ID_NO," ).append("\n"); 
		query.append("BCN.CNMV_YR," ).append("\n"); 
		query.append("BCN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BTR.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("BTR.CRE_DT," ).append("\n"); 
		query.append("CMV.MVMT_STS_CD," ).append("\n"); 
		query.append("CMV.ORG_YD_CD," ).append("\n"); 
		query.append("BTR.CURR_CD," ).append("\n"); 
		query.append("BTR.HLG_TP_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL (BTR.TRNS_REV_AMT, 0)" ).append("\n"); 
		query.append("+ NVL (BTR.NMF_TRNS_REV_AMT,0)" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("ARM.LOCL_CURR_CD" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(") TMP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.EFF_DT," ).append("\n"); 
		query.append("X.FM_LOC_CD," ).append("\n"); 
		query.append("X.CONTI_CD," ).append("\n"); 
		query.append("X.CNT_CD," ).append("\n"); 
		query.append("X.CUST_SEQ," ).append("\n"); 
		query.append("X.CNTR_TP_CD," ).append("\n"); 
		query.append("X.CHRR_FRT_TAX_VAL," ).append("\n"); 
		query.append("X.CURR_CD" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("MAX (EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF" ).append("\n"); 
		query.append("GROUP BY FM_LOC_CD," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE  X.EFF_DT    = Y.EFF_DT" ).append("\n"); 
		query.append("AND X.FM_LOC_CD = Y.FM_LOC_CD" ).append("\n"); 
		query.append("AND X.CNT_CD    = Y.CNT_CD" ).append("\n"); 
		query.append("AND X.CUST_SEQ  = Y.CUST_SEQ" ).append("\n"); 
		query.append(") TRF" ).append("\n"); 
		query.append("WHERE SUBSTR(TMP.CNTR_RTN_YD_CD,1,5) = TRF.FM_LOC_CD(+)" ).append("\n"); 
		query.append("AND NVL(TMP.CUST_CNT_CD,'CO')      = TRF.CNT_CD(+)" ).append("\n"); 
		query.append("AND NVL(TMP.CUST_SEQ,0) = TRF.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND TMP.CNTR_TPSZ_CD = TRF.CNTR_TP_CD(+)" ).append("\n"); 
		query.append("AND TRF.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("XXX.CRE_OFC_CD," ).append("\n"); 
		query.append("XXX.BKG_NO," ).append("\n"); 
		query.append("XXX.BL_NO," ).append("\n"); 
		query.append("XXX.CUST_CNT_CD," ).append("\n"); 
		query.append("XXX.CUST_SEQ," ).append("\n"); 
		query.append("XXX.CNTR_NO," ).append("\n"); 
		query.append("XXX.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("XXX.POR_CD," ).append("\n"); 
		query.append("XXX.POL_CD," ).append("\n"); 
		query.append("XXX.POD_CD," ).append("\n"); 
		query.append("XXX.DEL_CD," ).append("\n"); 
		query.append("XXX.CRE_DT," ).append("\n"); 
		query.append("XXX.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("XXX.ORG_YD_CD," ).append("\n"); 
		query.append("XXX.CURR_CD," ).append("\n"); 
		query.append("XXX.HLG_TP_CD," ).append("\n"); 
		query.append("XXX.DIF_AMT," ).append("\n"); 
		query.append("XXX.TRNS_REV_AMT," ).append("\n"); 
		query.append("CASE YYY.CONTI_CD" ).append("\n"); 
		query.append("WHEN NULL" ).append("\n"); 
		query.append("THEN YYY.CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("WHEN ' '" ).append("\n"); 
		query.append("THEN YYY.CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND LOC.LOC_CD   = XXX.POR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN YYY.CHRR_FRT_TAX_VAL * 10000000000" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TMP.CRE_OFC_CD," ).append("\n"); 
		query.append("TMP.BKG_NO," ).append("\n"); 
		query.append("TMP.BL_NO," ).append("\n"); 
		query.append("TMP.CUST_CNT_CD," ).append("\n"); 
		query.append("TMP.CUST_SEQ," ).append("\n"); 
		query.append("TMP.CNTR_NO," ).append("\n"); 
		query.append("TMP.CNMV_ID_NO," ).append("\n"); 
		query.append("TMP.CNMV_YR," ).append("\n"); 
		query.append("TMP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TMP.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("TMP.POR_CD," ).append("\n"); 
		query.append("TMP.POL_CD," ).append("\n"); 
		query.append("TMP.POD_CD," ).append("\n"); 
		query.append("TMP.DEL_CD," ).append("\n"); 
		query.append("TMP.CRE_DT," ).append("\n"); 
		query.append("TMP.MVMT_STS_CD," ).append("\n"); 
		query.append("TMP.ORG_YD_CD," ).append("\n"); 
		query.append("TMP.CURR_CD," ).append("\n"); 
		query.append("TMP.HLG_TP_CD," ).append("\n"); 
		query.append("TMP.TRNS_REV_AMT," ).append("\n"); 
		query.append("TMP.AR_CURR_CD," ).append("\n"); 
		query.append("TMP.DIF_AMT" ).append("\n"); 
		query.append("--,TMP.ORG_SCONTI_CD --2011-09-27 추가" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO BL_NO," ).append("\n"); 
		query.append("BCS.CUST_CNT_CD," ).append("\n"); 
		query.append("BCS.CUST_SEQ," ).append("\n"); 
		query.append("BCN.CNTR_NO," ).append("\n"); 
		query.append("BCN.CNMV_ID_NO," ).append("\n"); 
		query.append("BCN.CNMV_YR," ).append("\n"); 
		query.append("BCN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BTR.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("BTR.CRE_DT," ).append("\n"); 
		query.append("CMV.MVMT_STS_CD," ).append("\n"); 
		query.append("CMV.ORG_YD_CD," ).append("\n"); 
		query.append("BTR.CURR_CD," ).append("\n"); 
		query.append("BTR.HLG_TP_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL (BTR.TRNS_REV_AMT, 0)" ).append("\n"); 
		query.append("+ NVL (BTR.NMF_TRNS_REV_AMT,0)" ).append("\n"); 
		query.append(")                                AS TRNS_REV_AMT," ).append("\n"); 
		query.append("ARM.LOCL_CURR_CD               AS AR_CURR_CD," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (CHG_AMT * INV_XCH_RT)" ).append("\n"); 
		query.append("FROM INV_AR_CHG ARC" ).append("\n"); 
		query.append("WHERE ARC.CHG_CD   = 'DOD'" ).append("\n"); 
		query.append("AND ARC.AR_IF_NO = ARM.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")                               AS DIF_AMT" ).append("\n"); 
		query.append("--, BKG.ORG_SCONTI_CD --2011-09-27 추가" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO   BTR," ).append("\n"); 
		query.append("BKG_BOOKING   BKG," ).append("\n"); 
		query.append("BKG_CUSTOMER  BCS," ).append("\n"); 
		query.append("BKG_CONTAINER BCN," ).append("\n"); 
		query.append("CTM_MOVEMENT  CMV," ).append("\n"); 
		query.append("INV_AR_MN     ARM" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${ctrl_ofc_cd} != '' )" ).append("\n"); 
		query.append("AND    BTR.CRE_OFC_CD in (" ).append("\n"); 
		query.append("#foreach($ctrl_ofc_cd_num IN ${ctrl_ofc_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $ctrl_ofc_cd.size())" ).append("\n"); 
		query.append("'$ctrl_ofc_cd_num'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$ctrl_ofc_cd_num'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${search_choice} == 'MM' )" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMM')= @[tromonth]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') >= @[fromtrodate]" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') <= @[totrodate] + 0.999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BTR.HLG_TP_CD                    = @[haul_cd]" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD                    = 'I'" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCN.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCS.BKG_NO" ).append("\n"); 
		query.append("AND SUBSTR (BTR.CNTR_RTN_YD_CD,1,5) != BKG.POD_CD" ).append("\n"); 
		query.append("AND BTR.CNTR_NO    = BCN.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNTR_NO    = CMV.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_ID_NO = CMV.CNMV_ID_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_YR    = CMV.CNMV_YR" ).append("\n"); 
		query.append("AND BTR.BKG_NO     = ARM.BKG_NO(+)" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD  = ARM.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND BCS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("##                                     SELECT--2011-10-21 제거" ).append("\n"); 
		query.append("##                                            MIN (BCS2.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("##                                       FROM BKG_CUSTOMER BCS2" ).append("\n"); 
		query.append("##                                      WHERE BCS2.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("##                                        AND BCS2.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("##                                         IN" ).append("\n"); 
		query.append("##                                          (" ).append("\n"); 
		query.append("##                                            'C','N'" ).append("\n"); 
		query.append("##                                          )" ).append("\n"); 
		query.append("SELECT BCS2.BKG_CUST_TP_CD  --2011-10-21 추가" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER BCS2" ).append("\n"); 
		query.append("WHERE BCS2.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND BCS2.BKG_CUST_TP_CD = DECODE(BKG.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO," ).append("\n"); 
		query.append("BCS.CUST_CNT_CD," ).append("\n"); 
		query.append("BCS.CUST_SEQ," ).append("\n"); 
		query.append("BCN.CNTR_NO," ).append("\n"); 
		query.append("BCN.CNMV_ID_NO," ).append("\n"); 
		query.append("BCN.CNMV_YR," ).append("\n"); 
		query.append("BCN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("BTR.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("BTR.CRE_DT," ).append("\n"); 
		query.append("CMV.MVMT_STS_CD," ).append("\n"); 
		query.append("CMV.ORG_YD_CD," ).append("\n"); 
		query.append("BTR.CURR_CD," ).append("\n"); 
		query.append("BTR.HLG_TP_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL (BTR.TRNS_REV_AMT, 0)" ).append("\n"); 
		query.append("+ NVL (BTR.NMF_TRNS_REV_AMT,0)" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("ARM.LOCL_CURR_CD" ).append("\n"); 
		query.append("--,BKG.ORG_SCONTI_CD --2011-09-27 추가" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(") TMP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.EFF_DT," ).append("\n"); 
		query.append("X.FM_LOC_CD," ).append("\n"); 
		query.append("X.CONTI_CD," ).append("\n"); 
		query.append("X.CNT_CD," ).append("\n"); 
		query.append("X.CUST_SEQ," ).append("\n"); 
		query.append("X.CNTR_TP_CD," ).append("\n"); 
		query.append("X.CHRR_FRT_TAX_VAL," ).append("\n"); 
		query.append("X.CURR_CD" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("MAX (EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF" ).append("\n"); 
		query.append("GROUP BY FM_LOC_CD, CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.EFF_DT = Y.EFF_DT" ).append("\n"); 
		query.append("AND X.FM_LOC_CD = Y.FM_LOC_CD" ).append("\n"); 
		query.append("AND X.CNT_CD = Y.CNT_CD" ).append("\n"); 
		query.append("AND X.CUST_SEQ = Y.CUST_SEQ" ).append("\n"); 
		query.append(") TRF" ).append("\n"); 
		query.append("WHERE SUBSTR (TMP.CNTR_RTN_YD_CD,1,5) = TRF.FM_LOC_CD(+)" ).append("\n"); 
		query.append("AND NVL (TMP.CUST_CNT_CD,'CO') = TRF.CNT_CD(+)" ).append("\n"); 
		query.append("AND NVL (TMP.CUST_SEQ,0) = TRF.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND TMP.CNTR_TPSZ_CD = TRF.CNTR_TP_CD(+)" ).append("\n"); 
		query.append("AND TRF.CUST_SEQ IS NULL" ).append("\n"); 
		query.append(") XXX," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("S.EFF_DT EFF_DT," ).append("\n"); 
		query.append("S.FM_LOC_CD FM_LOC_CD," ).append("\n"); 
		query.append("S.CONTI_CD CONTI_CD," ).append("\n"); 
		query.append("S.CNT_CD CNT_CD," ).append("\n"); 
		query.append("S.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("S.CNTR_TP_CD CNTR_TP_CD," ).append("\n"); 
		query.append("S.CHRR_FRT_TAX_VAL CHRR_FRT_TAX_VAL," ).append("\n"); 
		query.append("S.CURR_CD CURR_CD" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF S," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("MAX (EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF" ).append("\n"); 
		query.append("GROUP BY FM_LOC_CD, CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE S.EFF_DT = T.EFF_DT" ).append("\n"); 
		query.append("AND S.FM_LOC_CD = T.FM_LOC_CD" ).append("\n"); 
		query.append("AND S.CNT_CD = T.CNT_CD" ).append("\n"); 
		query.append("AND S.CUST_SEQ = T.CUST_SEQ" ).append("\n"); 
		query.append(") YYY" ).append("\n"); 
		query.append("WHERE SUBSTR (XXX.CNTR_RTN_YD_CD,1,5) = YYY.FM_LOC_CD(+)" ).append("\n"); 
		query.append("AND 'CO' = YYY.CNT_CD(+)" ).append("\n"); 
		query.append("AND 0 = YYY.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND XXX.CNTR_TPSZ_CD = YYY.CNTR_TP_CD(+)" ).append("\n"); 
		query.append("--AND YYY.CONTI_CD = SUBSTR(XXX.ORG_SCONTI_CD,1,1) --2011-09-27 추가" ).append("\n"); 
		query.append(") MAIN," ).append("\n"); 
		query.append("MDM_CUSTOMER CS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${return_cy} != '' )" ).append("\n"); 
		query.append("AND MAIN.CNTR_RTN_YD_CD LIKE @[return_cy]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cust_cd} != '' )" ).append("\n"); 
		query.append("AND   MAIN.CUST_CNT_CD||LPAD(MAIN.CUST_SEQ,6,0) = @[cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MAIN.CUST_CNT_CD = CS.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MAIN.CUST_SEQ = CS.CUST_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY MAIN.CRE_OFC_CD," ).append("\n"); 
		query.append("MAIN.BKG_NO," ).append("\n"); 
		query.append("MAIN.BL_NO," ).append("\n"); 
		query.append("CS.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("CS.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("MAIN.CNTR_NO," ).append("\n"); 
		query.append("MAIN.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MAIN.POR_CD," ).append("\n"); 
		query.append("MAIN.POL_CD," ).append("\n"); 
		query.append("MAIN.POD_CD," ).append("\n"); 
		query.append("MAIN.DEL_CD," ).append("\n"); 
		query.append("MAIN.CRE_DT," ).append("\n"); 
		query.append("MAIN.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("MAIN.ORG_YD_CD," ).append("\n"); 
		query.append("NVL(MAIN.CURR_CD,'EUR')," ).append("\n"); 
		query.append("MAIN.HLG_TP_CD," ).append("\n"); 
		query.append("CS.RVIS_CNTR_CUST_TP_CD,  --2011-10-21 추가" ).append("\n"); 
		query.append("CS.CUST_CNT_CD||LPAD(CS.CUST_SEQ,6,0) --2011-10-27 추가" ).append("\n"); 

	}
}