/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastInquiryDBDAOSpcFcastBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.14 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastInquiryDBDAOSpcFcastBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
	  * </pre>
	  */
	public DailyForecastInquiryDBDAOSpcFcastBkgListRSQL(){
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
		params.put("ts_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration").append("\n"); 
		query.append("FileName : DailyForecastInquiryDBDAOSpcFcastBkgListRSQL").append("\n"); 
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
		query.append("#if (${type} == 'T')" ).append("\n"); 
		query.append("SELECT B.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,B.SC_NO  AS SC_NO" ).append("\n"); 
		query.append("      ,DECODE(UPPER(SUBSTR(B.RFA_NO,1,3)), 'DUM', '', B.RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("      ,NVL(M.CUST_LGL_ENG_NM, '') AS CTRT_NM," ).append("\n"); 
		query.append("      BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("                            FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                           WHERE QTY.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      )) AS TPSZ" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, " ).append("\n"); 
		query.append("     BKG_VVD PRE," ).append("\n"); 
		query.append("     BKG_VVD POST," ).append("\n"); 
		query.append("     MDM_CUSTOMER M," ).append("\n"); 
		query.append("     SPC_OFC_LVL O" ).append("\n"); 
		query.append("WHERE B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND B.BKG_STS_CD    IN('W','F')" ).append("\n"); 
		query.append("  AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("  AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("  AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("  AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("  AND B.BKG_NO = PRE.BKG_NO" ).append("\n"); 
		query.append("  AND PRE.POD_CD = @[ts_port]" ).append("\n"); 
		query.append("  AND PRE.VSL_CD||PRE.SKD_VOY_NO||PRE.SKD_DIR_CD = @[pre_vvd]" ).append("\n"); 
		query.append("  AND B.BKG_NO = POST.BKG_NO" ).append("\n"); 
		query.append("  AND POST.POL_CD = @[ts_port]" ).append("\n"); 
		query.append("  AND @[week] BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("  AND B.OB_SLS_OFC_CD = O.OFC_CD " ).append("\n"); 
		query.append("  AND O.N4TH_PRNT_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#if (${post_vvd} == '-')" ).append("\n"); 
		query.append("  AND POST.VSL_CD||POST.SKD_VOY_NO||POST.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND POST.VSL_CD||POST.SKD_VOY_NO||POST.SKD_DIR_CD = @[post_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND B.CTRT_CUST_CNT_CD = M.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND B.CTRT_CUST_SEQ = M.CUST_SEQ (+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,B.SC_NO  AS SC_NO" ).append("\n"); 
		query.append("      ,DECODE(UPPER(SUBSTR(B.RFA_NO,1,3)), 'DUM', '', B.RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("      ,NVL(M.CUST_LGL_ENG_NM, '') AS CTRT_NM," ).append("\n"); 
		query.append("      BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("                            FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                           WHERE QTY.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      )) AS TPSZ" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, " ).append("\n"); 
		query.append("#if (${pre_vvd} != '*')" ).append("\n"); 
		query.append("     BKG_VVD PRE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${post_vvd} != '*')" ).append("\n"); 
		query.append("     BKG_VVD POST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${post_vvd1} != '*')" ).append("\n"); 
		query.append("     BKG_VVD POST1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${post_vvd2} != '*')" ).append("\n"); 
		query.append("     BKG_VVD POST2," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     MDM_CUSTOMER M," ).append("\n"); 
		query.append("     SPC_OFC_LVL O" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND B.BKG_STS_CD    IN('W','F')" ).append("\n"); 
		query.append("  AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("  AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("  AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("  AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#if (${pre_vvd} != '*')" ).append("\n"); 
		query.append("  AND B.BKG_NO = PRE.BKG_NO" ).append("\n"); 
		query.append("  AND PRE.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("  AND PRE.VSL_CD||PRE.SKD_VOY_NO||PRE.SKD_DIR_CD = @[pre_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND @[week] BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("  AND O.N4TH_PRNT_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("  AND B.OB_SLS_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("  AND B.CTRT_CUST_CNT_CD = M.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND B.CTRT_CUST_SEQ = M.CUST_SEQ (+)" ).append("\n"); 
		query.append("#if (${post_vvd} != '*')" ).append("\n"); 
		query.append("  AND B.BKG_NO = POST.BKG_NO " ).append("\n"); 
		query.append("  AND POST.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("  AND POST.VSL_CD||POST.SKD_VOY_NO||POST.SKD_DIR_CD = @[post_vvd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${post_vvd1} != '*')" ).append("\n"); 
		query.append("  AND B.BKG_NO = POST1.BKG_NO " ).append("\n"); 
		query.append("  AND POST1.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("  AND POST1.VSL_CD||POST1.SKD_VOY_NO||POST1.SKD_DIR_CD = @[post_vvd1]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${post_vvd2} != '*')" ).append("\n"); 
		query.append("  AND B.BKG_NO = POST2.BKG_NO " ).append("\n"); 
		query.append("  AND POST2.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("  AND POST2.VSL_CD||POST2.SKD_VOY_NO||POST2.SKD_DIR_CD = @[post_vvd2]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}