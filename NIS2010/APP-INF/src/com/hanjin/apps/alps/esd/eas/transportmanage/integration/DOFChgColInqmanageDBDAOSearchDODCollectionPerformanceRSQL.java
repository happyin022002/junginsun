/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.11 
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

public class DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DOD Performance 조회
	  * </pre>
	  */
	public DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt_rtn_prd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_mt_rtn_prd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fromtrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("return_cy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mt_rtn_mth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' SEQ," ).append("\n"); 
		query.append("TMP.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("NVL(TMP.D2_QTY,0) D2_QTY," ).append("\n"); 
		query.append("NVL(TMP.D4_QTY,0) D4_QTY," ).append("\n"); 
		query.append("NVL(TMP.D5_QTY,0) D5_QTY," ).append("\n"); 
		query.append("NVL(TMP.R2_QTY,0) R2_QTY," ).append("\n"); 
		query.append("NVL(TMP.R5_QTY,0) R5_QTY," ).append("\n"); 
		query.append("NVL(TMP.R9_QTY,0) R9_QTY," ).append("\n"); 
		query.append("NVL((TMP.D2_QTY + TMP.D4_QTY + TMP.D5_QTY + TMP.R2_QTY + TMP.R5_QTY + TMP.R9_QTY),0) CNTR_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_D2_QTY,0) TRF_D2_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_D4_QTY,0) TRF_D4_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_D5_QTY,0) TRF_D5_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_R2_QTY,0) TRF_R2_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_R5_QTY,0) TRF_R5_QTY," ).append("\n"); 
		query.append("NVL(TRF.TRF_R9_QTY,0) TRF_R9_QTY," ).append("\n"); 
		query.append("NVL((TMP.D2_QTY*TRF.TRF_D2_QTY) + (TMP.D4_QTY*TRF.TRF_D4_QTY) + (TMP.D5_QTY*TRF.TRF_D5_QTY) +" ).append("\n"); 
		query.append("(TMP.R2_QTY*TRF.TRF_R2_QTY) + (TMP.R5_QTY*TRF.TRF_R5_QTY) + (TMP.R9_QTY*TRF.TRF_R9_QTY),0) TRF_AMT," ).append("\n"); 
		query.append("NVL(TRO_AMT,0) TRO_AMT," ).append("\n"); 
		query.append("NVL(DOD_AMT,0) DOD_AMT," ).append("\n"); 
		query.append("TMP.HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUBSTR(CNTR_RTN_YD_CD, 1, 5) CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("SUM(D2_QTY) D2_QTY," ).append("\n"); 
		query.append("SUM(D4_QTY) D4_QTY," ).append("\n"); 
		query.append("SUM(D5_QTY) D5_QTY," ).append("\n"); 
		query.append("SUM(R2_QTY) R2_QTY," ).append("\n"); 
		query.append("SUM(R5_QTY) R5_QTY," ).append("\n"); 
		query.append("SUM(R9_QTY) R9_QTY," ).append("\n"); 
		query.append("SUM(TRO_AMT) TRO_AMT," ).append("\n"); 
		query.append("SUM(DOD_AMT) DOD_AMT," ).append("\n"); 
		query.append("HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAIN.MT_ORG_YD CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'D2', 1, 0) D2_QTY," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'D4', 1, 0) D4_QTY," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'D5', 1, 0) D5_QTY," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'R2', 1, 0) R2_QTY," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'R5', 1, 0) R5_QTY," ).append("\n"); 
		query.append("DECODE(MAIN.CNTR_TPSZ_CD, 'R9', 1, 0) R9_QTY," ).append("\n"); 
		query.append("MAIN.TRNS_REV_AMT TRO_AMT," ).append("\n"); 
		query.append("MAIN.DIF_AMT DOD_AMT," ).append("\n"); 
		query.append("MAIN.HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("M.ORG_YD_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.CNTR_NO = TMP.CNTR_NO" ).append("\n"); 
		query.append("AND M.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("AND M.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("#if (${return_cy} != '')" ).append("\n"); 
		query.append("AND M.ORG_YD_CD LIKE @[return_cy]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} != '1')" ).append("\n"); 
		query.append("## mt return month" ).append("\n"); 
		query.append("#if (${mt_rtn_mth} != '')" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN TO_DATE(@[mt_rtn_mth]||'01','YYYYMMDD') AND LAST_DAY(TO_DATE(@[mt_rtn_mth],'YYYYMM')) + 0.999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("## mt return period" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN TO_DATE(@[fm_mt_rtn_prd],'YYYYMMDD') AND TO_DATE(@[to_mt_rtn_prd],'YYYYMMDD') + 0.999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND M.CNMV_SEQ = (  SELECT" ).append("\n"); 
		query.append("MIN(M2.CNMV_SEQ)" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M2.CNTR_NO = TMP.CNTR_NO" ).append("\n"); 
		query.append("AND M2.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("AND M2.MVMT_STS_CD = 'MT'  ) ) MT_ORG_YD," ).append("\n"); 
		query.append("TMP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TMP.HLG_TP_CD," ).append("\n"); 
		query.append("TMP.DIF_AMT," ).append("\n"); 
		query.append("TMP.TRNS_REV_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.DE_TERM_CD," ).append("\n"); 
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
		query.append("DECODE(TRIM(BKG.RFA_NO),NULL,(DECODE(TRIM(BKG.SC_NO),NULL,TRIM(BKG.TAA_NO),'',TRIM(BKG.TAA_NO),TRIM(BKG.SC_NO))),'',(DECODE(TRIM(BKG.SC_NO),NULL,TRIM(BKG.TAA_NO),'',TRIM(BKG.TAA_NO),TRIM(BKG.SC_NO))),TRIM(BKG.RFA_NO)) SC_RFA_TAA," ).append("\n"); 
		query.append("BTR.CRE_DT," ).append("\n"); 
		query.append("CMV.MVMT_STS_CD," ).append("\n"); 
		query.append("CMV.ORG_YD_CD," ).append("\n"); 
		query.append("BTR.CURR_CD," ).append("\n"); 
		query.append("BTR.HLG_TP_CD," ).append("\n"); 
		query.append("(NVL (BTR.TRNS_REV_AMT, 0) + NVL (BTR.NMF_TRNS_REV_AMT,0)) AS TRNS_REV_AMT," ).append("\n"); 
		query.append("ARM.LOCL_CURR_CD AS AR_CURR_CD," ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("SUM (CHG_AMT * INV_XCH_RT)" ).append("\n"); 
		query.append("FROM INV_AR_CHG ARC" ).append("\n"); 
		query.append("WHERE ARC.CHG_CD   = 'DOD'" ).append("\n"); 
		query.append("AND ARC.AR_IF_NO = ARM.AR_IF_NO)" ).append("\n"); 
		query.append(") AS DIF_AMT" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO   BTR," ).append("\n"); 
		query.append("BKG_BOOKING   BKG," ).append("\n"); 
		query.append("BKG_CUSTOMER  BCS," ).append("\n"); 
		query.append("BKG_CONTAINER BCN," ).append("\n"); 
		query.append("CTM_MOVEMENT  CMV," ).append("\n"); 
		query.append("INV_AR_MN     ARM" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- TRO OFC. 기준" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} == '1' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${ctrl_ofc_cd} != '' )" ).append("\n"); 
		query.append("AND    BTR.CRE_OFC_CD IN (${ctrl_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'A')" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'X')" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD = @[haul_cd]  --> M이면 M만... C이면 C만 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD IS NULL --> Null로 했을 경우 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tromonth} != '')" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMM')= @[tromonth] --> TRO Month조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') >= @[fromtrodate] --> TRO Period조건" ).append("\n"); 
		query.append("AND    TO_CHAR(BTR.CRE_DT,'YYYYMMDD') <= @[totrodate] + 0.999 --> TRO Period조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- RFA 기준" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} == '2' )" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'A')" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'X')" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD = @[haul_cd]  --> M이면 M만... C이면 C만 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD IS NULL --> Null로 했을 경우 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    ARM.RFA_NO    = @[rfa_no]  --BAH11A0106 TYO11A0160 FRA10A0008" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MERCHANT 기준" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} == '3' )" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'A')" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'X')" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD = @[haul_cd]  --> M이면 M만... C이면 C만 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD IS NULL --> Null로 했을 경우 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    BCS.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)  --  DE000441  + DEBERY1" ).append("\n"); 
		query.append("AND    BCS.CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MT RETURN YD 기준" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} == '4' )" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'A')" ).append("\n"); 
		query.append("#if ( ${haul_cd} != 'X')" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD = @[haul_cd]  --> M이면 M만... C이면 C만 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BTR.HLG_TP_CD IS NULL --> Null로 했을 경우 + ALL이면 조건 자체를 아예 뺀다" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MT RETURN YD나 MT RETURN DT가 조회 기준으로 잡힐 경우만" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${return_cy} != '')" ).append("\n"); 
		query.append("AND M.ORG_YD_CD LIKE @[return_cy]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND M.CNTR_NO = BCN.CNTR_NO" ).append("\n"); 
		query.append("AND M.BKG_NO = BCN.BKG_NO" ).append("\n"); 
		query.append("AND M.CNTR_NO = BTR.CNTR_NO" ).append("\n"); 
		query.append("AND M.BKG_NO = BTR.BKG_NO" ).append("\n"); 
		query.append("AND M.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("## mt return month" ).append("\n"); 
		query.append("#if ( ${sel_tp_cd} != '1')" ).append("\n"); 
		query.append("#if (${mt_rtn_mth} != '')" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN TO_DATE(@[mt_rtn_mth]||'01','YYYYMMDD') AND LAST_DAY(TO_DATE(@[mt_rtn_mth],'YYYYMM')) + 0.999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("## mt return period" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN TO_DATE(@[fm_mt_rtn_prd],'YYYYMMDD') AND TO_DATE(@[to_mt_rtn_prd],'YYYYMMDD') + 0.999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD                    = 'I'" ).append("\n"); 
		query.append("AND BTR.TRO_SEQ > 0" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCN.BKG_NO" ).append("\n"); 
		query.append("AND BTR.BKG_NO                       = BCS.BKG_NO" ).append("\n"); 
		query.append("AND SUBSTR (BTR.CNTR_RTN_YD_CD,1,5) != BKG.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BCN.CNMV_CYC_NO > 0" ).append("\n"); 
		query.append("AND BCN.CRE_DT >= TO_DATE('19990101','YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BTR.CNTR_NO    = BCN.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNTR_NO    = CMV.CNTR_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_ID_NO = CMV.CNMV_ID_NO" ).append("\n"); 
		query.append("AND BCN.CNMV_YR    = CMV.CNMV_YR" ).append("\n"); 
		query.append("AND BTR.BKG_NO     = ARM.BKG_NO(+)" ).append("\n"); 
		query.append("AND BTR.IO_BND_CD  = ARM.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND BCS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BCS2.BKG_CUST_TP_CD  --2011-10-21 추가" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER BCS2" ).append("\n"); 
		query.append("WHERE BCS2.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND BCS2.BKG_CUST_TP_CD = DECODE(BKG.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BTR.CRE_OFC_CD," ).append("\n"); 
		query.append("BTR.BKG_NO," ).append("\n"); 
		query.append("BKG.DE_TERM_CD," ).append("\n"); 
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
		query.append("ARM.LOCL_CURR_CD," ).append("\n"); 
		query.append("DECODE(TRIM(BKG.RFA_NO),NULL,(DECODE(TRIM(BKG.SC_NO),NULL,TRIM(BKG.TAA_NO),'',TRIM(BKG.TAA_NO),TRIM(BKG.SC_NO))),'',(DECODE(TRIM(BKG.SC_NO),NULL,TRIM(BKG.TAA_NO),'',TRIM(BKG.TAA_NO),TRIM(BKG.SC_NO))),TRIM(BKG.RFA_NO))" ).append("\n"); 
		query.append(") TMP" ).append("\n"); 
		query.append(") MAIN" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY SUBSTR(CNTR_RTN_YD_CD, 1, 5), HLG_TP_CD" ).append("\n"); 
		query.append(") TMP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.FM_LOC_CD," ).append("\n"); 
		query.append("MAX(X.TRF_D2_QTY) TRF_D2_QTY," ).append("\n"); 
		query.append("MAX(X.TRF_D4_QTY) TRF_D4_QTY," ).append("\n"); 
		query.append("MAX(X.TRF_D5_QTY) TRF_D5_QTY," ).append("\n"); 
		query.append("MAX(X.TRF_R2_QTY) TRF_R2_QTY," ).append("\n"); 
		query.append("MAX(X.TRF_R5_QTY) TRF_R5_QTY," ).append("\n"); 
		query.append("MAX(X.TRF_R9_QTY) TRF_R9_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.SCC_CD FM_LOC_CD," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'D2',T.CHRR_FRT_TAX_VAL,0) TRF_D2_QTY," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'D4',T.CHRR_FRT_TAX_VAL,0) TRF_D4_QTY," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'D5',T.CHRR_FRT_TAX_VAL,0) TRF_D5_QTY," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'R2',T.CHRR_FRT_TAX_VAL,0) TRF_R2_QTY," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'R5',T.CHRR_FRT_TAX_VAL,0) TRF_R5_QTY," ).append("\n"); 
		query.append("DECODE(T.CNTR_TPSZ_CD,'R9',T.CHRR_FRT_TAX_VAL,0) TRF_R9_QTY" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H, EAS_DRFF_CHG_TRF_DTL D, EAS_DRFF_CHG_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND (H.DRFF_CHG_TRF_SEQ, H.DRFF_CHG_TRF_VER_NO) IN (" ).append("\n"); 
		query.append("SELECT DRFF_CHG_TRF_SEQ, MAX(DRFF_CHG_TRF_VER_NO) DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("GROUP BY DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_SEQ = T.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_VER_NO = T.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_DTL_SEQ = T.DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.FM_LOC_CD" ).append("\n"); 
		query.append(") TRF" ).append("\n"); 
		query.append("WHERE TMP.CNTR_RTN_YD_CD = TRF.FM_LOC_CD (+)" ).append("\n"); 
		query.append("ORDER BY TMP.CNTR_RTN_YD_CD, TMP.HLG_TP_CD" ).append("\n"); 

	}
}