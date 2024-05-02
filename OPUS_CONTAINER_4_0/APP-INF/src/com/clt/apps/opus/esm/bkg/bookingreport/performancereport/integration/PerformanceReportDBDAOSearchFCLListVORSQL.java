/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchFCLListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchFCLListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchFCLListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchFCLListVORSQL").append("\n"); 
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
		query.append("#if (${vvd_chk} =='T')" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		ROW_NUMBER() OVER (ORDER BY A.BKG_NO) SEQ," ).append("\n"); 
		query.append("		/*DENSE_RANK() OVER( ORDER BY A.BKG_NO) SEQ,*/" ).append("\n"); 
		query.append("--		ROW_NUMBER() OVER (PARTITION BY A.BKG_NO  ORDER BY A.BKG_NO )," ).append("\n"); 
		query.append("	    A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("	    A.BL_NO BL_NO," ).append("\n"); 
		query.append("	    (SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("	     FROM BKG_VVD B" ).append("\n"); 
		query.append("	     WHERE 1=1" ).append("\n"); 
		query.append("	     AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	     AND B.VSL_SEQ ='1'" ).append("\n"); 
		query.append("	     AND B.VSL_PRE_PST_CD ='S' ) AS VVD_CD," ).append("\n"); 
		query.append("	    A.PRE_RLY_PORT_CD PRE_PORT," ).append("\n"); 
		query.append("	    A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD_CD," ).append("\n"); 
		query.append("	    A.SKD_DIR_CD||A.REV_DIR_CD REV_DIR_CD ," ).append("\n"); 
		query.append("	    A.POR_CD," ).append("\n"); 
		query.append("	    A.POL_CD," ).append("\n"); 
		query.append("	    A.POD_CD," ).append("\n"); 
		query.append("	    A.DEL_CD," ).append("\n"); 
		query.append("	    A.RCV_TERM_CD ," ).append("\n"); 
		query.append("	    A.DE_TERM_CD ," ).append("\n"); 
		query.append("		E.CHG_CD CHG_TP," ).append("\n"); 
		query.append("--	    TRIM(TO_CHAR(DECODE(E.RAT_AS_QTY,1,1,DECODE(GREATEST(E.RAT_AS_QTY,1),1,0,E.RAT_AS_QTY)),'99999999.99')) RATED_AS," ).append("\n"); 
		query.append("        TRIM(TO_CHAR(E.RAT_AS_QTY,'99999990.999')) RATED_AS," ).append("\n"); 
		query.append("	    TRIM(TO_CHAR(E.CHG_UT_AMT,'999999999990.99')) RATE," ).append("\n"); 
		query.append("	    E.RAT_UT_CD PER," ).append("\n"); 
		query.append("	    E.CURR_CD CUR," ).append("\n"); 
		query.append("	    E.RAT_UT_CD," ).append("\n"); 
		query.append("	    TRIM(TO_CHAR(E.CHG_AMT,'999999999990.99')) AMOUNT, " ).append("\n"); 
		query.append("	    E.N3PTY_RCV_OFC_CD PAY_OFC," ).append("\n"); 
		query.append("		E.FRT_TERM_CD PC," ).append("\n"); 
		query.append("	    A.SC_NO," ).append("\n"); 
		query.append("	    A.RFA_NO," ).append("\n"); 
		query.append("	    E.TRF_ITM_NO TARIFF_NO," ).append("\n"); 
		query.append("	    (SELECT SUBSTR(REPLACE(B1.CUST_NM,(chr(10)), ' '),1,150) " ).append("\n"); 
		query.append("	     FROM BKG_CUSTOMER B1" ).append("\n"); 
		query.append("	     WHERE 1=1" ).append("\n"); 
		query.append("	     AND A.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("	     AND B1.BKG_CUST_TP_CD ='S' )AS SHPR_NM," ).append("\n"); 
		query.append("	     (SELECT SUBSTR(REPLACE(B2.CUST_NM,(chr(10)), ' '),1,150)" ).append("\n"); 
		query.append("	     FROM BKG_CUSTOMER B2" ).append("\n"); 
		query.append("	     WHERE 1=1 " ).append("\n"); 
		query.append("	     AND A.BKG_NO = B2.BKG_NO" ).append("\n"); 
		query.append("	     AND B2.BKG_CUST_TP_CD ='C') AS CNEE_NM," ).append("\n"); 
		query.append("	    (SELECT SUBSTR(REPLACE(G.CMDT_DESC, (chr(10)), ' '),1,150) " ).append("\n"); 
		query.append("	     FROM BKG_BL_MK_DESC G" ).append("\n"); 
		query.append("	     WHERE 1=1" ).append("\n"); 
		query.append("	     AND A.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("	     AND G.MK_SEQ ='1'   ) AS CUST_DESC," ).append("\n"); 
		query.append("		--K.CMDT_CD CMDT," ).append("\n"); 
		query.append("		(SELECT K.CMDT_CD FROM MDM_COMMODITY K WHERE K.CMDT_CD = A.CMDT_CD) AS CMDT," ).append("\n"); 
		query.append("		(SELECT SUBSTR(REPLACE(K.CMDT_NM, (chr(10)), ' '),1,150) FROM MDM_COMMODITY K WHERE K.CMDT_CD = A.CMDT_CD) AS CMDT_DESC," ).append("\n"); 
		query.append("		--SUBSTR(REPLACE(K.CMDT_NM, (chr(10)), ' '),1,150) CMDT_DESC," ).append("\n"); 
		query.append("	    H.REP_CMDT_CD," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(H.REP_CMDT_NM, (chr(10)), ' '),1,150) REP_CMDT," ).append("\n"); 
		query.append("		(SELECT TO_CHAR(K.RT_APLY_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("		 FROM BKG_RATE K " ).append("\n"); 
		query.append("		 WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		 )RT_APLY_DT," ).append("\n"); 
		query.append("		'S' SPL_FLG /* SPLIT FLG */" ).append("\n"); 
		query.append("	FROM BKG_BOOKING A, BKG_CHG_RT E, MDM_REP_CMDT  H --MDM_COMMODITY K,   " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	#if(${vvd_cd} !='')" ).append("\n"); 
		query.append("		AND A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	  AND A.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("	  AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("	  AND E.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("	  AND A.REP_CMDT_CD = H.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("	#if(${por_cd} !='')" ).append("\n"); 
		query.append("		AND A.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${pol_cd} !='')" ).append("\n"); 
		query.append("		AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${pod_cd} !='')" ).append("\n"); 
		query.append("		AND A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${del_cd} !='')" ).append("\n"); 
		query.append("		AND A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sls_ofc} !='')" ).append("\n"); 
		query.append("		AND A.OB_SLS_OFC_CD = @[sls_ofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${bkg_ofc} !='')" ).append("\n"); 
		query.append("		AND A.BKG_OFC_CD = @[bkg_ofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${trd_cd} !='')" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD||A.REV_DIR_CD =@[trd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sc_no} !='')" ).append("\n"); 
		query.append("		AND A.SC_NO =@[sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, E.DP_SEQ" ).append("\n"); 
		query.append("/* actual */" ).append("\n"); 
		query.append("#elseif (${vvd_chk} =='A')" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("  		ROW_NUMBER() OVER (ORDER BY A.BKG_NO) SEQ," ).append("\n"); 
		query.append("		/*DENSE_RANK() OVER( ORDER BY A.BKG_NO) SEQ,*/" ).append("\n"); 
		query.append("--		ROW_NUMBER() OVER (PARTITION BY A.BKG_NO  ORDER BY A.BKG_NO )," ).append("\n"); 
		query.append("		A.BKG_NO," ).append("\n"); 
		query.append("	    A.BL_NO," ).append("\n"); 
		query.append("	    B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("	    A.PRE_RLY_PORT_CD PRE_PORT," ).append("\n"); 
		query.append("	    A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD_CD," ).append("\n"); 
		query.append("	    A.SKD_DIR_CD||A.REV_DIR_CD REV_DIR_CD ," ).append("\n"); 
		query.append("	    A.POR_CD," ).append("\n"); 
		query.append("	    A.POL_CD," ).append("\n"); 
		query.append("	    A.POD_CD," ).append("\n"); 
		query.append("	    A.DEL_CD," ).append("\n"); 
		query.append("	    A.RCV_TERM_CD," ).append("\n"); 
		query.append("	    A.DE_TERM_CD," ).append("\n"); 
		query.append("	    E.CHG_CD CHG_TP," ).append("\n"); 
		query.append("--	    TRIM(TO_CHAR(DECODE(E.RAT_AS_QTY,1,1,DECODE(GREATEST(E.RAT_AS_QTY,1),1,0,E.RAT_AS_QTY)),'99999999.99')) RATED_AS," ).append("\n"); 
		query.append("        TRIM(TO_CHAR(E.RAT_AS_QTY,'99999990.999')) RATED_AS," ).append("\n"); 
		query.append("	    TRIM(TO_CHAR(E.CHG_UT_AMT,'999999999990.99')) RATE," ).append("\n"); 
		query.append("	    E.RAT_UT_CD PER," ).append("\n"); 
		query.append("	    E.CURR_CD CUR," ).append("\n"); 
		query.append("	    E.RAT_UT_CD," ).append("\n"); 
		query.append("	    TRIM(TO_CHAR(E.CHG_AMT,'999999999990.99')) AMOUNT, " ).append("\n"); 
		query.append("	    E.N3PTY_RCV_OFC_CD PAY_OFC," ).append("\n"); 
		query.append("		E.FRT_TERM_CD PC," ).append("\n"); 
		query.append("	    A.SC_NO," ).append("\n"); 
		query.append("	    A.RFA_NO," ).append("\n"); 
		query.append("	    E.TRF_ITM_NO TARIFF_NO," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(B1.CUST_NM,(chr(10)), ' '),1,150) SHPR_NM," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(B2.CUST_NM,(chr(10)), ' '),1,150) CNEE_NM," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(G.CMDT_DESC, (chr(10)), ' '),1,150) CUST_DESC," ).append("\n"); 
		query.append("	    K.CMDT_CD CMDT," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(K.CMDT_NM, (chr(10)), ' '),1,150) CMDT_DESC," ).append("\n"); 
		query.append("	    H.REP_CMDT_CD," ).append("\n"); 
		query.append("	    SUBSTR(REPLACE(H.REP_CMDT_NM, (chr(10)), ' '),1,150) REP_CMDT," ).append("\n"); 
		query.append("		(SELECT TO_CHAR(K.RT_APLY_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("		 FROM BKG_RATE K " ).append("\n"); 
		query.append("		 WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		 )RT_APLY_DT," ).append("\n"); 
		query.append("		'S' SPL_FLG /* SPLIT FLG */" ).append("\n"); 
		query.append("	FROM BKG_VVD B, BKG_BOOKING A, BKG_CHG_RT E, BKG_CUSTOMER B1," ).append("\n"); 
		query.append("	     BKG_CUSTOMER B2, BKG_BL_MK_DESC G, MDM_COMMODITY K,   MDM_REP_CMDT  H, BKG_VVD I" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	  AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("	  AND E.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("	  AND A.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("	  AND A.BKG_NO = B2.BKG_NO" ).append("\n"); 
		query.append("	  AND B1.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("	  AND B2.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("	  AND A.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("	  AND G.MK_SEQ(+) ='1'  " ).append("\n"); 
		query.append("	  AND A.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("	  AND A.CMDT_CD = K.CMDT_CD(+)" ).append("\n"); 
		query.append("	  AND A.REP_CMDT_CD = H.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("	  AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	  AND I.bkg_no(+)=a.bkg_no" ).append("\n"); 
		query.append("	  AND I.VSL_PRE_PST_CD(+) ='S'" ).append("\n"); 
		query.append("	  AND I.VSL_SEQ(+) ='1'" ).append("\n"); 
		query.append("	#if(${vvd_cd} !='')" ).append("\n"); 
		query.append("		AND B.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${por_cd} !='')" ).append("\n"); 
		query.append("		AND A.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${pol_cd} !='')" ).append("\n"); 
		query.append("		AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${pod_cd} !='')" ).append("\n"); 
		query.append("		AND A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${del_cd} !='')" ).append("\n"); 
		query.append("		AND A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sls_ofc} !='')" ).append("\n"); 
		query.append("		AND A.OB_SLS_OFC_CD = @[sls_ofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${bkg_ofc} !='')" ).append("\n"); 
		query.append("		AND A.BKG_OFC_CD = @[bkg_ofc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${trd_cd} !='')" ).append("\n"); 
		query.append("		AND A.SKD_DIR_CD||A.REV_DIR_CD =@[trd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sc_no} !='')" ).append("\n"); 
		query.append("		AND A.SC_NO =@[sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, E.DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}