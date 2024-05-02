/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchActualCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2015.01.08 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchActualCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
	  * * 2014.12.12 신자영 [CHM-201433097] Actual Account 조회 시 SC/RFA상의 contractor조회 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchActualCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchActualCustomerRSQL").append("\n"); 
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
		query.append("#if (${type} == 'B')" ).append("\n"); 
		query.append("SELECT DISTINCT CODE," ).append("\n"); 
		query.append("                CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("	   			SC_NO," ).append("\n"); 
		query.append("	   			RFA_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  HD.SC_NO AS SC_NO," ).append("\n"); 
		query.append("                '*' AS RFA_NO," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD || LPAD(AC.CUST_SEQ, 6, 0) AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')          AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')          AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                --,RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_RT_ACT_CUST  AC  " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/ " ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        --AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${app_dt} != '')     " ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  HD.SC_NO AS SC_NO," ).append("\n"); 
		query.append("                '*' AS RFA_NO," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD || LPAD(NC.BKG_ACT_CUST_SEQ, 6, 0) AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                --,RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("       -- AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${app_dt} != '')     " ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("--WHERE RN = 1  " ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${sc_no} == '') " ).append("\n"); 
		query.append("AND 'Y' = 'N'/*SWITCH*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT CODE," ).append("\n"); 
		query.append("                CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("	   			SC_NO," ).append("\n"); 
		query.append("	   			RFA_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  '*' AS SC_NO," ).append("\n"); 
		query.append("                HD.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("				AC.CUST_CNT_CD || LPAD(AC.CUST_SEQ, 6, 0) AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_RT_ACT_CUST  AC  " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        --AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${app_dt} != '')     " ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  '*' AS SC_NO," ).append("\n"); 
		query.append("                HD.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("				NC.BKG_ACT_CUST_CNT_CD || LPAD(NC.BKG_ACT_CUST_SEQ, 6, 0) AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("       -- AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${app_dt} != '')     " ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("	AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
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
		query.append("#elseif (${type} == 'C')" ).append("\n"); 
		query.append("SELECT A.CMDT_CD AS CODE, " ).append("\n"); 
		query.append("       A.CMDT_NM AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("	   B.SC_NO," ).append("\n"); 
		query.append("	   B.RFA_NO" ).append("\n"); 
		query.append("FROM MDM_COMMODITY A, " ).append("\n"); 
		query.append("    (SELECT DISTINCT CMDT.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("			H.SC_NO AS SC_NO," ).append("\n"); 
		query.append("            '*' AS RFA_NO" ).append("\n"); 
		query.append("       FROM PRI_SP_HDR H" ).append("\n"); 
		query.append("            ,PRI_SP_MN  M" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_MN SCP_M" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_RT_CMDT_HDR C_HDR" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_RT_CMDT  CMDT" ).append("\n"); 
		query.append("      WHERE H.SC_NO             =  @[sc_no]" ).append("\n"); 
		query.append("        AND H.PROP_NO           = M.PROP_NO" ).append("\n"); 
		query.append("#if (${app_dt} != '')   " ).append("\n"); 
		query.append("        AND M.EFF_DT            <=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        AND M.EXP_DT            >=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND M.PROP_STS_CD       = 'F'" ).append("\n"); 
		query.append("        AND M.PROP_NO           = SCP_M.PROP_NO" ).append("\n"); 
		query.append("        AND M.AMDT_SEQ          = SCP_M.AMDT_SEQ" ).append("\n"); 
		query.append("--AND     SCP_M.SVC_SCP_CD      = 'TPE'" ).append("\n"); 
		query.append("        AND SCP_M.PROP_NO       = C_HDR.PROP_NO" ).append("\n"); 
		query.append("        AND SCP_M.AMDT_SEQ      = C_HDR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SCP_M.SVC_SCP_CD    = C_HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND C_HDR.CMDT_HDR_SEQ  = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_TP_CD = 'C' -- Commodity" ).append("\n"); 
		query.append("        AND CMDT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT DISTINCT DTL.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("			H.SC_NO AS SC_NO," ).append("\n"); 
		query.append("            '*' AS RFA_NO" ).append("\n"); 
		query.append("       FROM PRI_SP_HDR H" ).append("\n"); 
		query.append("            ,PRI_SP_MN  M" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_MN SCP_M" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_RT_CMDT_HDR C_HDR" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_RT_CMDT  CMDT" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_GRP_CMDT GRP" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("      WHERE H.SC_NO             =  @[sc_no]" ).append("\n"); 
		query.append("        AND H.PROP_NO           = M.PROP_NO" ).append("\n"); 
		query.append("#if (${app_dt} != '')  " ).append("\n"); 
		query.append("        AND M.EFF_DT            <=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        AND M.EXP_DT            >=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND M.PROP_STS_CD       = 'F'" ).append("\n"); 
		query.append("        AND M.PROP_NO           = SCP_M.PROP_NO" ).append("\n"); 
		query.append("        AND M.AMDT_SEQ          = SCP_M.AMDT_SEQ" ).append("\n"); 
		query.append("--        AND SCP_M.SVC_SCP_CD    = 'TPE'" ).append("\n"); 
		query.append("        AND SCP_M.PROP_NO       = C_HDR.PROP_NO" ).append("\n"); 
		query.append("        AND SCP_M.AMDT_SEQ      = C_HDR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SCP_M.SVC_SCP_CD    = C_HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND C_HDR.CMDT_HDR_SEQ  = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_TP_CD = 'G' -- Group Commodity" ).append("\n"); 
		query.append("        AND CMDT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = GRP.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = GRP.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = GRP.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_DEF_CD  = GRP.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("        AND GRP.PROP_NO         = DTL.PROP_NO" ).append("\n"); 
		query.append("        AND GRP.AMDT_SEQ        = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("        AND GRP.SVC_SCP_CD      = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND GRP.GRP_CMDT_SEQ    = DTL.GRP_CMDT_SEQ) B" ).append("\n"); 
		query.append("WHERE   A.CMDT_CD = B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("  AND UPPER(CMDT_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT A.CMDT_CD, " ).append("\n"); 
		query.append("       A.CMDT_NM," ).append("\n"); 
		query.append("	   B.SC_NO," ).append("\n"); 
		query.append("	   B.RFA_NO" ).append("\n"); 
		query.append("FROM MDM_COMMODITY A, " ).append("\n"); 
		query.append("    (SELECT DISTINCT CMDT.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("			'*' AS SC_NO," ).append("\n"); 
		query.append("            H.RFA_NO AS RFA_NO" ).append("\n"); 
		query.append("--   H.RFA_NO" ).append("\n"); 
		query.append("--  ,M.PROP_NO" ).append("\n"); 
		query.append("--  ,M.AMDT_SEQ" ).append("\n"); 
		query.append("--  ,SCP_M.SVC_SCP_CD" ).append("\n"); 
		query.append("----  ,C_HDR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("--  ,CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("--  ,CMDT.CMDT_SEQ" ).append("\n"); 
		query.append("--  ,CMDT.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("--  ,CMDT.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("       FROM PRI_RP_HDR H" ).append("\n"); 
		query.append("            ,PRI_RP_MN  M" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_MN SCP_M" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_RT_CMDT_HDR C_HDR" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_RT_CMDT  CMDT" ).append("\n"); 
		query.append("-- where   H.RFA_NO     = 'AAR7A100153'" ).append("\n"); 
		query.append("      WHERE H.RFA_NO            = @[rfa_no]" ).append("\n"); 
		query.append("        AND H.PROP_NO           = M.PROP_NO" ).append("\n"); 
		query.append("#if (${app_dt} != '')  " ).append("\n"); 
		query.append("        AND M.EFF_DT            <=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        AND M.EXP_DT            >=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND M.PROP_STS_CD       = 'A'" ).append("\n"); 
		query.append("        AND M.PROP_NO           = SCP_M.PROP_NO" ).append("\n"); 
		query.append("        AND M.AMDT_SEQ          = SCP_M.AMDT_SEQ" ).append("\n"); 
		query.append("--and     SCP_M.SVC_SCP_CD  = 'TPE'" ).append("\n"); 
		query.append("        AND SCP_M.PROP_NO       = C_HDR.PROP_NO" ).append("\n"); 
		query.append("        AND SCP_M.AMDT_SEQ      = C_HDR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SCP_M.SVC_SCP_CD    = C_HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.CMDT_HDR_SEQ  = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_TP_CD = 'C' " ).append("\n"); 
		query.append("        AND CMDT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT DISTINCT DTL.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("			'*' AS SC_NO," ).append("\n"); 
		query.append("            H.RFA_NO AS RFA_NO" ).append("\n"); 
		query.append("       FROM PRI_RP_HDR H" ).append("\n"); 
		query.append("            ,PRI_RP_MN  M" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_MN SCP_M" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_RT_CMDT_HDR C_HDR" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_RT_CMDT  CMDT" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_GRP_CMDT GRP" ).append("\n"); 
		query.append("            ,PRI_RP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("      WHERE H.RFA_NO            = @[rfa_no]" ).append("\n"); 
		query.append("        AND H.PROP_NO           = M.PROP_NO" ).append("\n"); 
		query.append("#if (${app_dt} != '')  " ).append("\n"); 
		query.append("        AND M.EFF_DT            <=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        AND M.EXP_DT            >=  TO_DATE(@[app_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND M.PROP_STS_CD       = 'A'" ).append("\n"); 
		query.append("        AND M.PROP_NO           = SCP_M.PROP_NO" ).append("\n"); 
		query.append("        AND M.AMDT_SEQ          = SCP_M.AMDT_SEQ" ).append("\n"); 
		query.append("--        AND SCP_M.SVC_SCP_CD    = 'TPE'" ).append("\n"); 
		query.append("        AND SCP_M.PROP_NO       = C_HDR.PROP_NO" ).append("\n"); 
		query.append("        AND SCP_M.AMDT_SEQ      = C_HDR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SCP_M.SVC_SCP_CD    = C_HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = CMDT.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("--        AND C_HDR.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND C_HDR.CMDT_HDR_SEQ  = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_TP_CD = 'G' -- Group Commodity" ).append("\n"); 
		query.append("        AND CMDT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 
		query.append("        AND C_HDR.PROP_NO       = GRP.PROP_NO" ).append("\n"); 
		query.append("        AND C_HDR.AMDT_SEQ      = GRP.AMDT_SEQ" ).append("\n"); 
		query.append("        AND C_HDR.SVC_SCP_CD    = GRP.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND CMDT.PRC_CMDT_DEF_CD  = GRP.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("        AND GRP.PROP_NO         = DTL.PROP_NO" ).append("\n"); 
		query.append("        AND GRP.AMDT_SEQ        = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("        AND GRP.SVC_SCP_CD      = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND GRP.GRP_CMDT_SEQ    = DTL.GRP_CMDT_SEQ) B" ).append("\n"); 
		query.append("WHERE A.CMDT_CD = B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CMDT_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${type} == 'A')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT CODE," ).append("\n"); 
		query.append("                CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("	   			SC_NO," ).append("\n"); 
		query.append("	   			RFA_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT  HD.SC_NO AS SC_NO," ).append("\n"); 
		query.append("                '*' AS RFA_NO," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD || LPAD(AC.CUST_SEQ, 6, 0) AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')          AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')          AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                --,RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_SP_CTRT_PTY  AC  " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/ " ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        --AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("--        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     AC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		SELECT  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             '*' AS SC_NO," ).append("\n"); 
		query.append("                HD.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("				MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, 0) AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                MN.CTRT_CUST_CNT_CD  ," ).append("\n"); 
		query.append("                MN.CTRT_CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = MN.CTRT_CUST_CNT_CD AND A.CUST_SEQ = MN.CTRT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN SM   " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CMDT_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}