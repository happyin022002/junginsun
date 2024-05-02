/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqInterchangeDBDAOAvailableOnewayListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOAvailableOnewayListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Available Oneway Inventory 조회
	  * </pre>
	  */
	public EqInterchangeDBDAOAvailableOnewayListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOAvailableOnewayListRSQL").append("\n"); 
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
		query.append("WITH ONH_APRO_QTY AS" ).append("\n"); 
		query.append("(SELECT AGMT_SEQ" ).append("\n"); 
		query.append("       ,CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,ONH_QTY" ).append("\n"); 
		query.append("  FROM LSE_ONH_APRO_QTY" ).append("\n"); 
		query.append(" WHERE CRE_DT > TO_DATE('20150731', 'YYYYMMDD')" ).append("\n"); 
		query.append(" GROUP BY AGMT_SEQ, CNTR_ONH_AUTH_NO, CNTR_TPSZ_CD, ONH_QTY" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_ALL_YARD AS" ).append("\n"); 
		query.append("(SELECT C.RCC_CD" ).append("\n"); 
		query.append("       ,C.LCC_CD" ).append("\n"); 
		query.append("       ,C.ECC_CD" ).append("\n"); 
		query.append("       ,C.SCC_CD" ).append("\n"); 
		query.append("       ,B.LOC_CD" ).append("\n"); 
		query.append("       ,A.YD_CD" ).append("\n"); 
		query.append("  FROM MDM_YARD A, MDM_LOCATION B, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append(" WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("   AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("   AND C.DELT_FLG ='N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_ALL_LOC AS" ).append("\n"); 
		query.append("(SELECT B.RCC_CD" ).append("\n"); 
		query.append("       ,B.LCC_CD" ).append("\n"); 
		query.append("       ,B.ECC_CD" ).append("\n"); 
		query.append("       ,B.SCC_CD" ).append("\n"); 
		query.append("       ,A.LOC_CD" ).append("\n"); 
		query.append("       ,A.CONTI_CD" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append(" WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MDM_SCC AS" ).append("\n"); 
		query.append("(SELECT SCC_CD, CONTI_CD  FROM " ).append("\n"); 
		query.append("  (SELECT SCC_CD, CONTI_CD, row_number() over(partition by SCC_CD order by CONTI_CD desc) rn" ).append("\n"); 
		query.append("    FROM MDM_LOCATION " ).append("\n"); 
		query.append("   WHERE SCC_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND CONTI_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 
		query.append("GROUP BY SCC_CD, CONTI_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ALL_APRO AS " ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("        B.CNTR_NO" ).append("\n"); 
		query.append("       ,B.CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,C.RCC_CD -- MT의 경우 MVMT YARD 기준이다." ).append("\n"); 
		query.append("       ,C.LCC_CD" ).append("\n"); 
		query.append("       ,C.ECC_CD" ).append("\n"); 
		query.append("       ,C.SCC_CD" ).append("\n"); 
		query.append("       ,B.DISP_FLG" ).append("\n"); 
		query.append("       ,B.LSTM_CD" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,C.LOC_CD LOC_CD_C" ).append("\n"); 
		query.append("       ,A.LOC_CD LOC_CD_A" ).append("\n"); 
		query.append("       ,B.CNMV_STS_CD" ).append("\n"); 
		query.append("       ,B.CNMV_DT" ).append("\n"); 
		query.append("       ,B.CRNT_YD_CD" ).append("\n"); 
		query.append("       ,B.ONH_DT" ).append("\n"); 
		query.append("       ,A.FREE_DYS" ).append("\n"); 
		query.append("       ,A.LSEE_VNDR_SEQ" ).append("\n"); 
		query.append("       ,B.VNDR_SEQ" ).append("\n"); 
		query.append("       ,A.AGMT_SEQ" ).append("\n"); 
		query.append("       ,A.CRE_DT" ).append("\n"); 
		query.append("       ,B.ACIAC_DIV_CD" ).append("\n"); 
		query.append("  FROM  LSE_ONH_APRO A" ).append("\n"); 
		query.append("       ,MST_CONTAINER B" ).append("\n"); 
		query.append("       ,MDM_ALL_YARD C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("   AND B.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.CRNT_YD_CD = C.YD_CD(+)" ).append("\n"); 
		query.append("   AND B.CNTR_AUTH_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND A.CRE_DT > TO_DATE('20150731', 'YYYYMMDD')" ).append("\n"); 
		query.append("   AND A.CNTR_ONH_AUTH_NO = B.CNTR_AUTH_NO)," ).append("\n"); 
		query.append("MT_APRO AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'M' STS " ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,RCC_CD -- MT의 경우 MVMT YARD 기준이다." ).append("\n"); 
		query.append("       ,LCC_CD" ).append("\n"); 
		query.append("       ,ECC_CD" ).append("\n"); 
		query.append("       ,SCC_CD" ).append("\n"); 
		query.append("       ,DISP_FLG" ).append("\n"); 
		query.append("       ,LSTM_CD" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,LOC_CD_C CONTI_FROM" ).append("\n"); 
		query.append("       ,LOC_CD_A OFF_HIRE_LOC" ).append("\n"); 
		query.append("       ,LOC_CD_A TARGET_DOL" ).append("\n"); 
		query.append("       ,CNMV_STS_CD" ).append("\n"); 
		query.append("       ,CNMV_DT" ).append("\n"); 
		query.append("       ,CRNT_YD_CD" ).append("\n"); 
		query.append("       ,ONH_DT" ).append("\n"); 
		query.append("       ,FREE_DYS" ).append("\n"); 
		query.append("       ,TRUNC(SYSDATE) - (TRUNC(ONH_DT)+1) USING_DAYS" ).append("\n"); 
		query.append("       ,DECODE(LSEE_VNDR_SEQ,NULL,VNDR_SEQ,LSEE_VNDR_SEQ) LESSOR" ).append("\n"); 
		query.append("       ,AGMT_SEQ" ).append("\n"); 
		query.append("       ,CRE_DT APP_DT" ).append("\n"); 
		query.append("       ,TRUNC(SYSDATE) - (TRUNC(CRE_DT)+1) S_DAYS" ).append("\n"); 
		query.append("  FROM  ALL_APRO" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append("   AND ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ALL_APRO_GROUP AS" ).append("\n"); 
		query.append("(SELECT CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,RCC_CD" ).append("\n"); 
		query.append("       ,LCC_CD" ).append("\n"); 
		query.append("       ,ECC_CD" ).append("\n"); 
		query.append("       ,SCC_CD" ).append("\n"); 
		query.append("       ,AGMT_SEQ" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,SUM(DECODE(CNTR_NO, NULL, 0, 1)) AS QTY" ).append("\n"); 
		query.append("  FROM ALL_APRO" ).append("\n"); 
		query.append("  GROUP BY CNTR_AUTH_NO" ).append("\n"); 
		query.append("          ,RCC_CD" ).append("\n"); 
		query.append("          ,LCC_CD" ).append("\n"); 
		query.append("          ,ECC_CD" ).append("\n"); 
		query.append("          ,SCC_CD" ).append("\n"); 
		query.append("          ,AGMT_SEQ" ).append("\n"); 
		query.append("          ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ALL_APRO_AGMT AS" ).append("\n"); 
		query.append("(SELECT AGMT_SEQ" ).append("\n"); 
		query.append("  FROM ALL_APRO" ).append("\n"); 
		query.append("  GROUP BY AGMT_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("OFF_AGMT AS" ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("       B.AGMT_SEQ" ).append("\n"); 
		query.append("  FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("       LSE_AGREEMENT B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("   AND SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("   AND LSTM_CD = 'OF'" ).append("\n"); 
		query.append("   AND A.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("   AND B.AGMT_SEQ IN (SELECT AGMT_SEQ FROM ALL_APRO_AGMT)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ IN (SELECT AGMT_SEQ FROM ALL_APRO_AGMT)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("   AND A.CNTR_STS_EVNT_DT > TO_DATE('20150731', 'YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY B.AGMT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT * FROM" ).append("\n"); 
		query.append("(SELECT AAA.*" ).append("\n"); 
		query.append("       ,DECODE(CONTI_FROM,NULL,'COM','A',DECODE(CONTI_TO,NULL,'TBN','E','AES','F','AFS','M','TPS','A','IES','TBN')" ).append("\n"); 
		query.append("                                    ,'E',DECODE(CONTI_TO,NULL,'TBN','F','EFS','E','IES','M','TAS','TBN')" ).append("\n"); 
		query.append("                                    ,'F',DECODE(CONTI_TO,NULL,'TBN','F','IFS','TBN')" ).append("\n"); 
		query.append("                                    ,'M',DECODE(CONTI_TO,NULL,'TBN','M','IMS','F','MFS','TBN')" ).append("\n"); 
		query.append("                                    ,'TBN'" ).append("\n"); 
		query.append("               ) TRD" ).append("\n"); 
		query.append("       ,DECODE(AAA.ONH_SCC,NULL,NULL,AAA.MVMT_SCC,'Y','N') MVNT_DOL      " ).append("\n"); 
		query.append(" FROM                                        " ).append("\n"); 
		query.append("(SELECT  AA.*" ).append("\n"); 
		query.append("       ,BB.CONTI_CD CONTI_TO " ).append("\n"); 
		query.append("       ,BB.RCC_CD OFF_RCC_CD" ).append("\n"); 
		query.append("       ,BB.LCC_CD OFF_LCC_CD" ).append("\n"); 
		query.append("       ,BB.ECC_CD OFF_ECC_CD" ).append("\n"); 
		query.append("       ,BB.SCC_CD OFF_SCC_CD" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT STS" ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,A.RCC_CD -- A의 경우 AUTH에 입력한 SCC 기준이다.(ECC_CD 컬럼에 실질적으로는 SCC가 들어간다)" ).append("\n"); 
		query.append("       ,A.LCC_CD" ).append("\n"); 
		query.append("       ,A.ECC_CD" ).append("\n"); 
		query.append("       ,A.SCC_CD" ).append("\n"); 
		query.append("       ,DISP_FLG" ).append("\n"); 
		query.append("       ,LSTM_CD" ).append("\n"); 
		query.append("       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,A.ONH_QTY - NVL(QTY,0) ONH_QTY" ).append("\n"); 
		query.append("       ,CONTI_FROM" ).append("\n"); 
		query.append("       ,OFF_HIRE_LOC" ).append("\n"); 
		query.append("       ,TARGET_DOL" ).append("\n"); 
		query.append("       ,CNMV_STS_CD" ).append("\n"); 
		query.append("       ,CNMV_DT" ).append("\n"); 
		query.append("       ,CRNT_YD_CD" ).append("\n"); 
		query.append("       ,ONH_DT" ).append("\n"); 
		query.append("       ,FREE_DYS" ).append("\n"); 
		query.append("       ,USING_DAYS" ).append("\n"); 
		query.append("       ,LESSOR" ).append("\n"); 
		query.append("       ,A.AGMT_SEQ" ).append("\n"); 
		query.append("       ,APP_DT" ).append("\n"); 
		query.append("       ,S_DAYS" ).append("\n"); 
		query.append("       ,MVMT_SCC" ).append("\n"); 
		query.append("       ,ONH_SCC" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("       (SELECT 'A' STS" ).append("\n"); 
		query.append("       ,'' CNTR_NO" ).append("\n"); 
		query.append("       ,A.CNTR_ONH_AUTH_NO CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,B.RCC_CD -- A의 경우 AUTH에 입력한 SCC 기준이다.(ECC_CD 컬럼에 실질적으로는 SCC가 들어간다)" ).append("\n"); 
		query.append("       ,B.LCC_CD" ).append("\n"); 
		query.append("       ,B.ECC_CD" ).append("\n"); 
		query.append("       ,B.SCC_CD" ).append("\n"); 
		query.append("       ,'' DISP_FLG" ).append("\n"); 
		query.append("       ,A.LSTM_CD" ).append("\n"); 
		query.append("       ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,SUM(C.ONH_QTY) ONH_QTY" ).append("\n"); 
		query.append("       ,D.CONTI_CD CONTI_FROM" ).append("\n"); 
		query.append("       ,A.LOC_CD OFF_HIRE_LOC" ).append("\n"); 
		query.append("       ,A.LOC_CD TARGET_DOL" ).append("\n"); 
		query.append("       ,'' CNMV_STS_CD" ).append("\n"); 
		query.append("       ,NULL CNMV_DT" ).append("\n"); 
		query.append("       ,'' CRNT_YD_CD" ).append("\n"); 
		query.append("       ,NULL ONH_DT" ).append("\n"); 
		query.append("       ,A.FREE_DYS" ).append("\n"); 
		query.append("       ,NULL  USING_DAYS" ).append("\n"); 
		query.append("       ,A.LSEE_VNDR_SEQ LESSOR" ).append("\n"); 
		query.append("       ,A.AGMT_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR (A.CRE_DT, 'YYYY-MM-DD') APP_DT" ).append("\n"); 
		query.append("       ,TRUNC(SYSDATE) - (TRUNC(A.CRE_DT)+1) S_DAYS" ).append("\n"); 
		query.append("       ,NULL MVMT_SCC" ).append("\n"); 
		query.append("       ,NULL ONH_SCC" ).append("\n"); 
		query.append("  FROM LSE_ONH_APRO A, MDM_EQ_ORZ_CHT B, ONH_APRO_QTY C, MDM_SCC D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.ECC_CD = B.SCC_CD(+)" ).append("\n"); 
		query.append("   AND A.ECC_CD = D.SCC_CD(+)" ).append("\n"); 
		query.append("   AND A.CNTR_ONH_AUTH_NO = C.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("   AND A.CRE_DT > TO_DATE('20150731', 'YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY  " ).append("\n"); 
		query.append("        A.CNTR_ONH_AUTH_NO---------------" ).append("\n"); 
		query.append("       ,B.RCC_CD -- A의 경우 AUTH에 입력한 SCC 기준이다.(ECC_CD 컬럼에 실질적으로는 SCC가 들어간다)" ).append("\n"); 
		query.append("       ,B.LCC_CD" ).append("\n"); 
		query.append("       ,B.ECC_CD" ).append("\n"); 
		query.append("       ,B.SCC_CD" ).append("\n"); 
		query.append("       ,A.LSTM_CD" ).append("\n"); 
		query.append("       ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     --  ,SUM(C.ONH_QTY) ONH_QTY" ).append("\n"); 
		query.append("       ,D.CONTI_CD" ).append("\n"); 
		query.append("       ,A.LOC_CD" ).append("\n"); 
		query.append("       ,A.LOC_CD" ).append("\n"); 
		query.append("       ,A.FREE_DYS" ).append("\n"); 
		query.append("       ,A.LSEE_VNDR_SEQ" ).append("\n"); 
		query.append("       ,A.AGMT_SEQ" ).append("\n"); 
		query.append("       ,A.CRE_DT) A, ALL_APRO_GROUP B" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ NOT IN (SELECT AGMT_SEQ FROM OFF_AGMT)" ).append("\n"); 
		query.append("   AND A.CNTR_AUTH_NO = B.CNTR_AUTH_NO(+)" ).append("\n"); 
		query.append("   AND A.RCC_CD = B.RCC_CD(+)" ).append("\n"); 
		query.append("   AND A.LCC_CD = B.LCC_CD(+)" ).append("\n"); 
		query.append("   AND A.ECC_CD = B.ECC_CD(+)" ).append("\n"); 
		query.append("   AND A.SCC_CD = B.SCC_CD(+)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT STS " ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,CNTR_AUTH_NO" ).append("\n"); 
		query.append("       ,RCC_CD" ).append("\n"); 
		query.append("       ,LCC_CD" ).append("\n"); 
		query.append("       ,ECC_CD" ).append("\n"); 
		query.append("       ,A.SCC_CD" ).append("\n"); 
		query.append("       ,DISP_FLG" ).append("\n"); 
		query.append("       ,LSTM_CD" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,NULL ONH_QTY" ).append("\n"); 
		query.append("       ,B.CONTI_CD CONTI_FROM" ).append("\n"); 
		query.append("       ,OFF_HIRE_LOC" ).append("\n"); 
		query.append("       ,TARGET_DOL" ).append("\n"); 
		query.append("       ,CNMV_STS_CD" ).append("\n"); 
		query.append("       ,TO_CHAR (CNMV_DT, 'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("       ,CRNT_YD_CD" ).append("\n"); 
		query.append("       ,TO_CHAR (ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("       ,FREE_DYS" ).append("\n"); 
		query.append("       ,USING_DAYS" ).append("\n"); 
		query.append("       ,LESSOR" ).append("\n"); 
		query.append("       ,AGMT_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR (APP_DT, 'YYYY-MM-DD') APP_DT" ).append("\n"); 
		query.append("       ,S_DAYS" ).append("\n"); 
		query.append("       ,MST_LOC_FNC(SUBSTR(A.CRNT_YD_CD, 1, 5), 'SCC') MVMT_SCC" ).append("\n"); 
		query.append("       ,MST_LOC_FNC(SUBSTR(A.OFF_HIRE_LOC, 1, 5), 'SCC') ONH_SCC        " ).append("\n"); 
		query.append("  FROM MT_APRO A, MDM_LOCATION B" ).append("\n"); 
		query.append(" WHERE A.CONTI_FROM = B.LOC_CD(+)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND LESSOR = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ) AA," ).append("\n"); 
		query.append("       MDM_ALL_LOC BB" ).append("\n"); 
		query.append("WHERE AA.OFF_HIRE_LOC = BB.LOC_CD(+)) AAA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_seq} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_fm_tp} == 'RCC')" ).append("\n"); 
		query.append("  AND RCC_CD = @[loc_fm]" ).append("\n"); 
		query.append("#elseif (${loc_fm_tp} == 'LCC')" ).append("\n"); 
		query.append("  AND LCC_CD = @[loc_fm]" ).append("\n"); 
		query.append("#elseif (${loc_fm_tp} == 'ECC')" ).append("\n"); 
		query.append("  AND ECC_CD = @[loc_fm]" ).append("\n"); 
		query.append("#elseif (${loc_fm_tp} == 'SCC')" ).append("\n"); 
		query.append("  AND SCC_CD = @[loc_fm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("  AND OFF_RCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("  AND OFF_LCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'ECC')" ).append("\n"); 
		query.append("  AND OFF_ECC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("  AND OFF_SCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stay} == 'A')" ).append("\n"); 
		query.append("  AND S_DAYS >= @[dys]" ).append("\n"); 
		query.append("#elseif (${stay} == 'O')" ).append("\n"); 
		query.append("  AND USING_DAYS >= @[dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dpsl} != '')" ).append("\n"); 
		query.append("  AND DISP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sts} == 'A')" ).append("\n"); 
		query.append("  AND STS = 'A'" ).append("\n"); 
		query.append("#elseif (${sts} == 'M')" ).append("\n"); 
		query.append("  AND STS = 'M'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("  AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY APP_DT DESC)" ).append("\n"); 
		query.append("#if (${trd} != '')" ).append("\n"); 
		query.append("WHERE TRD = @[trd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}