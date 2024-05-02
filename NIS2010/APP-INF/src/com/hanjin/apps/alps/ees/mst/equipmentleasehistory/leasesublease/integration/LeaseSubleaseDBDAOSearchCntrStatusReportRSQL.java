/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeaseSubleaseDBDAOSearchCntrStatusReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseSubleaseDBDAOSearchCntrStatusReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrStatusReport
	  * </pre>
	  */
	public LeaseSubleaseDBDAOSearchCntrStatusReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("evnt_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration ").append("\n"); 
		query.append("FileName : LeaseSubleaseDBDAOSearchCntrStatusReportRSQL").append("\n"); 
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
		query.append("     HIS.CNTR_NO                    AS CNTR_NO" ).append("\n"); 
		query.append("    ,MST.CNTR_TPSZ_CD               AS TP_SZ" ).append("\n"); 
		query.append("    ,LSE.LSTM_CD                    AS TERM " ).append("\n"); 
		query.append("    ,MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(HIS.AGMT_CTY_CD,HIS.AGMT_SEQ)  AS AGMT_NO    " ).append("\n"); 
		query.append("    ,LSE.REF_NO                     AS CONTAINER_NO" ).append("\n"); 
		query.append("    ,MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(LSE.VNDR_SEQ) AS LESSOR" ).append("\n"); 
		query.append("    ,MDM.VNDR_LGL_ENG_NM AS LESSOR_NAME          " ).append("\n"); 
		query.append("    ,HIS.CNTR_FULL_FLG  AS F_M          " ).append("\n"); 
		query.append("    ,HIS.CNMV_STS_CD    AS PRE_MOVEMERT" ).append("\n"); 
		query.append("    ,TO_CHAR(HIS.EVNT_DT1,'YYYY-MM-DD') AS LST_DT" ).append("\n"); 
		query.append("    ,HIS.YD_CD1        AS LST_YD" ).append("\n"); 
		query.append("    ,TO_CHAR(HIS.EVNT_DT2,'YYYY-MM-DD') AS FND_DT" ).append("\n"); 
		query.append("    ,HIS.YD_CD2        AS FND_YD" ).append("\n"); 
		query.append("    ,TRUNC(HIS.DAYS) + 1 AS DAYS" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.CNTR_NO," ).append("\n"); 
		query.append("	       B.AGMT_SEQ," ).append("\n"); 
		query.append("	       B.AGMT_CTY_CD," ).append("\n"); 
		query.append("	       B.CNTR_STS_SEQ," ).append("\n"); 
		query.append("	       DECODE(B.CNTR_FULL_FLG,'Y','F','M') AS CNTR_FULL_FLG, " ).append("\n"); 
		query.append("	       B.CNMV_STS_CD,              " ).append("\n"); 
		query.append("	       B.YD_CD AS YD_CD1," ).append("\n"); 
		query.append("	       B.CNTR_STS_EVNT_DT AS EVNT_DT1," ).append("\n"); 
		query.append("	       C.YD_CD AS YD_CD2," ).append("\n"); 
		query.append("	       C.CNTR_STS_EVNT_DT AS EVNT_DT2,       " ).append("\n"); 
		query.append("		   NVL(C.CNTR_STS_EVNT_DT,TRUNC(SYSDATE))- B.CNTR_STS_EVNT_DT  AS DAYS     " ).append("\n"); 
		query.append("	FROM  " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT A.CNTR_NO,A.CNTR_STS_SEQ STS_SEQ1," ).append("\n"); 
		query.append("		      (SELECT /*+ INDEX(H XPKMST_CNTR_STS_HIS) */ H.CNTR_STS_SEQ" ).append("\n"); 
		query.append("		      FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("		      WHERE A.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("		      AND   H.CNTR_STS_CD = 'FND'" ).append("\n"); 
		query.append("		      AND   A.CNTR_STS_SEQ < H.CNTR_STS_SEQ" ).append("\n"); 
		query.append("		      AND   ROWNUM = 1" ).append("\n"); 
		query.append("		      ) STS_SEQ2" ).append("\n"); 
		query.append("		FROM  MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("		WHERE A.CNTR_STS_CD = 'LST'" ).append("\n"); 
		query.append("		#if (${loc_tp_cd} == 'R') " ).append("\n"); 
		query.append("		AND A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp_cd} == 'L')" ).append("\n"); 
		query.append("		AND A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if(${ls_flg} == 'Y')" ).append("\n"); 
		query.append("        AND A.CNTR_NO IN (SELECT A.CNTR_NO" ).append("\n"); 
		query.append("                          FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                          WHERE  A.CNTR_STS_CD = 'LST' )" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("		AND A.CNTR_STS_EVNT_DT >= TO_DATE(@[evnt_dt1],'YYYYMM') AND " ).append("\n"); 
		query.append("		    A.CNTR_STS_EVNT_DT < ADD_MONTHS(TO_DATE(@[evnt_dt2],'YYYYMM'),1)  " ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT A.CNTR_NO," ).append("\n"); 
		query.append("		      (SELECT /*+ INDEX_DESC(H XPKMST_CNTR_STS_HIS) */ H.CNTR_STS_SEQ" ).append("\n"); 
		query.append("		      FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("		      WHERE A.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("		      AND   H.CNTR_STS_CD = 'LST'" ).append("\n"); 
		query.append("		      AND   A.CNTR_STS_SEQ > H.CNTR_STS_SEQ" ).append("\n"); 
		query.append("		      AND   ROWNUM = 1" ).append("\n"); 
		query.append("		      ) STS_SEQ1," ).append("\n"); 
		query.append("		      A.CNTR_STS_SEQ STS_SEQ2" ).append("\n"); 
		query.append("		FROM  MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("		WHERE A.CNTR_STS_CD = 'FND'" ).append("\n"); 
		query.append("		#if (${loc_tp_cd} == 'R') " ).append("\n"); 
		query.append("		AND A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp_cd} == 'L')" ).append("\n"); 
		query.append("		AND A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if(${ls_flg} == 'Y')" ).append("\n"); 
		query.append("        AND A.CNTR_NO IN (SELECT A.CNTR_NO" ).append("\n"); 
		query.append("                          FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                          WHERE  A.CNTR_STS_CD = 'LST' )" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("		AND A.CNTR_STS_EVNT_DT >= TO_DATE(@[evnt_dt1],'YYYYMM') AND " ).append("\n"); 
		query.append("		    A.CNTR_STS_EVNT_DT < ADD_MONTHS(TO_DATE(@[evnt_dt2],'YYYYMM'),1)" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("	) A, MST_CNTR_STS_HIS B,MST_CNTR_STS_HIS C" ).append("\n"); 
		query.append("	WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND   A.STS_SEQ1 = B.CNTR_STS_SEQ(+)" ).append("\n"); 
		query.append("	AND   A.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND   A.STS_SEQ2 = C.CNTR_STS_SEQ(+)" ).append("\n"); 
		query.append(") HIS, MST_CONTAINER MST, LSE_AGREEMENT LSE, MDM_VENDOR MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND HIS.CNTR_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("AND HIS.AGMT_CTY_CD = LSE.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND HIS.AGMT_SEQ = LSE.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND LSE.VNDR_SEQ = MDM.VNDR_SEQ(+)" ).append("\n"); 

	}
}