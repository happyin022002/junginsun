/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionDetailRSQL
	  * 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
	  * 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
	  * 2015.01.22 신자영 [CHM-201533823] Control Option 데이터 보여주는 방식 변경 요청
	  * 2015.01.30 신자영 [CHM-201533908] Control Option 보완
	  * 2015.02.16 박은주 쿼리튜닝(17->0.4)
	  * 2015.02.17 Arie Im [CHM-201534437]Control Option Registration 기능 보완 - del all check, 상단 검색조건 추가
	  * 2015.03.18 김성욱  [CHM-201533908] Control Option 보완
	  * 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
	  * 2015.06.24 이혜민 [CHM-201535810] Fixed Rate 계약 정보의 SPC 적용 개발 요청
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionDetailRSQL").append("\n"); 
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
		query.append("SELECT DTL.TRD_CD" ).append("\n"); 
		query.append("      ,DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,DTL.RLANE_CD" ).append("\n"); 
		query.append("      ,DTL.DIR_CD" ).append("\n"); 
		query.append("      ,DTL.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,DTL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("      ,DECODE(DTL.ALOC_CTRL_TP_CD, 'F', '', NVL(DTL.ALOC_CTRL_DTL_CD, '*'))  AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("      ,NVL(DTL.SC_NO, '*') AS SC_NO" ).append("\n"); 
		query.append("      ,NVL(DTL.RFA_NO, '*') AS RFA_NO" ).append("\n"); 
		query.append("      ,NVL(" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_SP_HDR    HD" ).append("\n"); 
		query.append("                  ,PRI_SP_MN     MN" ).append("\n"); 
		query.append("                  ,PRI_SP_CTRT_PTY AC" ).append("\n"); 
		query.append("                  ,MDM_CUSTOMER A" ).append("\n"); 
		query.append("            WHERE HD.SC_NO        = DTL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              AND MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("              AND MN.PROP_STS_CD  = 'F'    -- Filed만 B/L적용 가능" ).append("\n"); 
		query.append("              AND MN.AMDT_SEQ     = (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                       FROM PRI_SP_MN N_MN" ).append("\n"); 
		query.append("                                      WHERE N_MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("                                        AND N_MN.PROP_STS_CD  = 'F'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("              AND AC.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("              AND AC.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("              AND AC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("              AND A.CUST_CNT_CD   = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND A.CUST_SEQ      = AC.CUST_SEQ" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_RP_HDR    HD" ).append("\n"); 
		query.append("                  ,PRI_RP_MN     MN" ).append("\n"); 
		query.append("                  ,MDM_CUSTOMER  A" ).append("\n"); 
		query.append("            WHERE HD.RFA_NO        = DTL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              AND MN.PROP_NO       = HD.PROP_NO" ).append("\n"); 
		query.append("              AND MN.PROP_STS_CD   = 'A'        /*상수*/" ).append("\n"); 
		query.append("              AND MN.AMDT_SEQ      = (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                        FROM PRI_RP_MN N_MN" ).append("\n"); 
		query.append("                                       WHERE N_MN.PROP_NO = HD.PROP_NO" ).append("\n"); 
		query.append("                                         AND N_MN.PROP_STS_CD   = 'A'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("              AND A.CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              AND A.CUST_SEQ    = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM       <= 1" ).append("\n"); 
		query.append("            ), '') AS CTRT_NM" ).append("\n"); 
		query.append("        -- name 부분 SC_NO 대신 ALOC_CTRL_DTL_CD로 변경 필요" ).append("\n"); 
		query.append("      ,CASE WHEN ALOC_CTRL_TP_CD = 'C' " ).append("\n"); 
		query.append("            THEN (SELECT CMDT_NM" ).append("\n"); 
		query.append("                    FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                   WHERE CMDT_CD = ALOC_CTRL_DTL_CD)" ).append("\n"); 
		query.append("            WHEN ALOC_CTRL_TP_CD IN ('A','B') " ).append("\n"); 
		query.append("            THEN NVL((SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                        FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                       WHERE CUST_CNT_CD = SUBSTR(ALOC_CTRL_DTL_CD, 1, 2)" ).append("\n"); 
		query.append("--                      PK를 가공하고 있어서 속도가 느림 따라서 아래와 같이 변경" ).append("\n"); 
		query.append("--                         AND LPAD(CUST_SEQ, 6, '0') = SUBSTR(ALOC_CTRL_DTL_CD, 3, 6)" ).append("\n"); 
		query.append("                         AND CUST_SEQ    = TO_NUMBER(SUBSTR(ALOC_CTRL_DTL_CD, 3, 6))" ).append("\n"); 
		query.append("                      ), '')" ).append("\n"); 
		query.append("       ELSE ''" ).append("\n"); 
		query.append("       END AS ACCT_NM" ).append("\n"); 
		query.append("	   ,OFC.OFC_CD" ).append("\n"); 
		query.append("       ,DECODE(DTL.CTRL_FX_RT_FLG, 'Y', 1, 0) CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("  FROM SPC_ALOC_LANE_CTRL_OPT_DTL DTL" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT ALOC_CTRL_TP_CD ACTC, CTRL_LOC_ACCT_CD, substr(xmlagg(xmlelement(a,',' || ofc_cd) order by ofc_cd).extract('//text()'), 2) OFC_CD" ).append("\n"); 
		query.append("			FROM SPC_ALOC_LANE_CTRL_OFC" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			#if (${trade} != '')" ).append("\n"); 
		query.append("				AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${subtrade} != '')" ).append("\n"); 
		query.append("				AND SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${lane} != '')" ).append("\n"); 
		query.append("				AND RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${bound} != '')" ).append("\n"); 
		query.append("				AND DIR_CD     = @[bound]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			GROUP BY ALOC_CTRL_TP_CD, CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("		) OFC" ).append("\n"); 
		query.append(" WHERE DTL.ALOC_CTRL_TP_CD IN ('A', 'B', 'C', 'E', 'G', 'F') -- A:Account, B: Actual Account, C:Commodity, E:Ecc, G:LOC Group, F:Fixed(Actual Account or Commodity)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("   AND DTL.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("   AND DTL.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("   AND DTL.RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("   AND DTL.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DTL.ALOC_CTRL_TP_CD = OFC.ACTC(+) --DECODE(OFC.ACTC, '', DTL.ALOC_CTRL_TP_CD, OFC.ACTC) --OFC.ACTC(+)" ).append("\n"); 
		query.append("AND DTL.CTRL_LOC_ACCT_CD = OFC.CTRL_LOC_ACCT_CD(+) --DECODE(OFC.CTRL_LOC_ACCT_CD, '', DTL.CTRL_LOC_ACCT_CD, OFC.CTRL_LOC_ACCT_CD) --OFC.CTRL_LOC_ACCT_CD(+)" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,CTRL_LOC_ACCT_CD" ).append("\n"); 

	}
}