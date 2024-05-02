/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchActualCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2014.12.09 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchActualCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchActualCustomerRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchActualCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("app_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchActualCustomerRSQL").append("\n"); 
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
		query.append("#if (${bkg_upld_flg} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("SCP AS(" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT A," ).append("\n"); 
		query.append("     MDM_SVC_SCP_LMT B, " ).append("\n"); 
		query.append("     MDM_SVC_SCP C" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.SVC_SCP_IND_FLG ='Y'" ).append("\n"); 
		query.append("AND A.RGN_CD IN (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("AND B.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.SVC_SCP_IND_FLG ='Y'" ).append("\n"); 
		query.append("AND B.RGN_CD IN (SELECT RGN_CD  FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CTRT AS(" ).append("\n"); 
		query.append("SELECT DISTINCT 'R' CTRT_TP, RM.PROP_NO, RM.AMDT_SEQ, RS.SVC_SCP_CD," ).append("\n"); 
		query.append("        TO_CHAR(RS.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(RS.EXP_DT, 'YYYY-MM-DD')            AS TO_DT" ).append("\n"); 
		query.append("FROM  PRI_RP_MN RM, PRI_RP_SCP_MN RS, PRI_RP_HDR RH" ).append("\n"); 
		query.append("WHERE RH.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("AND RM.PROP_NO = RH.PROP_NO" ).append("\n"); 
		query.append("AND RM.PROP_NO = RS.PROP_NO" ).append("\n"); 
		query.append("AND RM.AMDT_SEQ = RS.AMDT_SEQ" ).append("\n"); 
		query.append("AND RM.EFF_DT <= NVL(TO_DATE(@[app_dt], 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("AND RM.EXP_DT >= NVL(TO_DATE(@[app_dt], 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("AND RM.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("AND RS.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM SCP)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'S' CTRT_TP, SM.PROP_NO, SM.AMDT_SEQ, SS.SVC_SCP_CD," ).append("\n"); 
		query.append("        TO_CHAR(SS.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("         TO_CHAR(SS.EXP_DT, 'YYYY-MM-DD')            AS TO_DT" ).append("\n"); 
		query.append("FROM PRI_SP_HDR SH, PRI_SP_MN SM, PRI_SP_SCP_MN SS" ).append("\n"); 
		query.append("WHERE SH.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("AND SM.PROP_NO = SS.PROP_NO" ).append("\n"); 
		query.append("AND SM.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND SM.PROP_STS_CD  = 'F'" ).append("\n"); 
		query.append("AND SM.EFF_DT <= NVL(TO_DATE(@[app_dt], 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("AND SM.EXP_DT >= NVL(TO_DATE(@[app_dt], 'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append("AND SS.SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM SCP)" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CUST AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- RFA" ).append("\n"); 
		query.append("SELECT CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_RP_SCP_RT_CMDT RP_CMDT, MDM_COMMODITY REP_CMDT, PRI_RP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE RP_CMDT.PRC_CMDT_DEF_CD = REP_CMDT.REP_CMDT_CD" ).append("\n"); 
		query.append("AND RP_CMDT.PRC_CMDT_TP_CD  = 'R' --REP COMMODITY" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CTRT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP            = 'R'" ).append("\n"); 
		query.append("AND REP_CMDT.CMDT_CD        = @[cmdt_cd]" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CUST.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP_CMDT.CMDT_HDR_SEQ    = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_RP_SCP_RT_CMDT RP_CMDT, PRI_RP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE RP_CMDT.PRC_CMDT_TP_CD= 'C' --COMMODITY" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CTRT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP            = 'R'" ).append("\n"); 
		query.append("AND RP_CMDT.PRC_CMDT_DEF_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("AND RP_CMDT.PRC_CMDT_TP_CD  = 'C' --COMMODITY" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CUST.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP_CMDT.CMDT_HDR_SEQ    = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_RP_SCP_RT_CMDT RP_CMDT, PRI_RP_SCP_GRP_CMDT_DTL GRP_CMDT, " ).append("\n"); 
		query.append("     MDM_COMMODITY REP_CMDT, PRI_RP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE RP_CMDT.PROP_NO       = GRP_CMDT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = GRP_CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = GRP_CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP_CMDT.PRC_CMDT_TP_CD  = 'G' --GROUP COMMODITY" ).append("\n"); 
		query.append("AND GRP_CMDT.PRC_CMDT_TP_CD = 'R' --REP COMMODITY" ).append("\n"); 
		query.append("AND GRP_CMDT.PRC_CMDT_DEF_CD= REP_CMDT.REP_CMDT_CD" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD = CTRT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP = 'R'" ).append("\n"); 
		query.append("AND REP_CMDT.CMDT_CD        = @[cmdt_cd]" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CUST.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP_CMDT.CMDT_HDR_SEQ    = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_RP_SCP_RT_CMDT RP_CMDT, PRI_RP_SCP_GRP_CMDT_DTL GRP_CMDT, PRI_RP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE RP_CMDT.PROP_NO       = GRP_CMDT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = GRP_CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = GRP_CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GRP_CMDT.PRC_CMDT_DEF_CD= @[cmdt_cd]" ).append("\n"); 
		query.append("AND RP_CMDT.PRC_CMDT_TP_CD  = 'G' --GROUP COMMODITY" ).append("\n"); 
		query.append("AND GRP_CMDT.PRC_CMDT_TP_CD = 'C' --COMMODITY" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CTRT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP = 'R'" ).append("\n"); 
		query.append("AND RP_CMDT.PROP_NO         = CUST.PROP_NO" ).append("\n"); 
		query.append("AND RP_CMDT.AMDT_SEQ        = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND RP_CMDT.SVC_SCP_CD      = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP_CMDT.CMDT_HDR_SEQ    = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- SC" ).append("\n"); 
		query.append("SELECT CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_SP_SCP_MN MN, PRI_SP_SCP_GRP_CMDT CMDT,  " ).append("\n"); 
		query.append("     PRI_SP_SCP_GRP_CMDT_DTL DTL,  PRI_SP_SCP_RT_CMDT RTCM, PRI_SP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CMDT.PROP_NO = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND CMDT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CMDT.PROP_NO = DTL.PROP_NO" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CMDT.GRP_CMDT_SEQ = DTL.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND DTL.PRC_CMDT_TP_CD = 'C'" ).append("\n"); 
		query.append("AND DTL.PRC_CMDT_DEF_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP = 'S'" ).append("\n"); 
		query.append("AND CMDT.PROP_NO = RTCM.PROP_NO" ).append("\n"); 
		query.append("AND CMDT.AMDT_SEQ = RTCM.AMDT_SEQ" ).append("\n"); 
		query.append("AND CMDT.SVC_SCP_CD = RTCM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CMDT.PRC_GRP_CMDT_CD = RTCM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND RTCM.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("AND RTCM.AMDT_SEQ = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND RTCM.SVC_SCP_CD = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RTCM.GEN_SPCL_RT_TP_CD = CUST.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND RTCM.CMDT_HDR_SEQ = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  CUST.CUST_CNT_CD, CUST.CUST_SEQ, CTRT.FROM_DT, CTRT.TO_DT" ).append("\n"); 
		query.append("FROM CTRT, PRI_SP_SCP_RT_CMDT A, PRI_SP_SCP_RT_ACT_CUST CUST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.PROP_NO = CTRT.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = CTRT.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.PRC_CMDT_TP_CD ='C'" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("AND CTRT.CTRT_TP = 'S'" ).append("\n"); 
		query.append("AND A.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = CUST.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT MDM.CUST_CNT_CD, MDM.CUST_SEQ, MDM.CUST_CNT_CD||MDM.CUST_SEQ AS CODE, MDM.CUST_LGL_ENG_NM, CUST.FROM_DT, CUST.TO_DT" ).append("\n"); 
		query.append("FROM CUST, MDM_CUSTOMER MDM " ).append("\n"); 
		query.append("WHERE CUST.CUST_CNT_CD = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = MDM.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD,CUST_SEQ,CODE,CUST_LGL_ENG_NM,FROM_DT,TO_DT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  AC.CUST_CNT_CD || AC.CUST_SEQ AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                BKG_BOOKING   BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/ " ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  NC.BKG_ACT_CUST_CNT_CD || NC.BKG_ACT_CUST_SEQ AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE RN = 1  " ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${sc_no} == '') " ).append("\n"); 
		query.append("AND 'Y' = 'N'/*SWITCH*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD,CUST_SEQ,CODE,CUST_LGL_ENG_NM,FROM_DT,TO_DT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  AC.CUST_CNT_CD || AC.CUST_SEQ AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                BKG_BOOKING   BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  NC.BKG_ACT_CUST_CNT_CD || NC.BKG_ACT_CUST_SEQ AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} == '') " ).append("\n"); 
		query.append("AND 'Y' = 'N'/*SWITCH*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}