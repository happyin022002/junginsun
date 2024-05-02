/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_EAS_0364
	  * Multiple Repair CNTR by Area Detail
	  * 동일 지역/업체/장비의 중복 견적/수리에 대한 집중심사의 cntrNo, LocCd의 목록정보
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_param_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaDetailRSQL").append("\n"); 
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
		query.append("SELECT A.COST_OFC_CD OFC_CD" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.COST_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("     , B.EQ_NO" ).append("\n"); 
		query.append("     , B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , E.RQST_REF_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.MNR_INP_DT, 'YYYY-MM-DD') MNR_INP_DT" ).append("\n"); 
		query.append("     , A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ WO_NO" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID AND ROWNUM = 1) WO_USER" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER(ORDER BY A.MNR_ORD_SEQ)  RNUM" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , NVL(F.MNR_WRK_AMT, B.COST_AMT) WO_AMT" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(A.MNR_INP_DT, 'YYYYMM'), NVL(E.CURR_CD,A.CURR_CD), 'USD', NVL(F.MNR_WRK_AMT, B.COST_AMT)) CHG_COST_AMT" ).append("\n"); 
		query.append("     , B.YD_CD" ).append("\n"); 
		query.append("     , F.EQ_LOC_CD" ).append("\n"); 
		query.append("     , (SELECT EQ_LOC_NM FROM MNR_EQ_LOC_CD L WHERE L.EQ_LOC_CD = F.EQ_LOC_CD) EQ_LOC_NM" ).append("\n"); 
		query.append("     , F.EQ_CMPO_CD" ).append("\n"); 
		query.append("     , (SELECT EQ_CMPO_NM FROM MNR_EQ_CMPO_CD CM WHERE CM.EQ_CMPO_CD = F.EQ_CMPO_CD AND ROWNUM = 1) EQ_CMPO_NM" ).append("\n"); 
		query.append("     , F.EQ_DMG_CD" ).append("\n"); 
		query.append("     , (SELECT EQ_CEDEX_OTR_CD_NM FROM MNR_CEDEX_OTR_CD DMG WHERE DMG.EQ_CEDEX_OTR_TP_CD = 'DMG' AND DMG.EQ_CEDEX_OTR_CD = F.EQ_DMG_CD) EQ_DMG_NM" ).append("\n"); 
		query.append("     , F.EQ_RPR_CD" ).append("\n"); 
		query.append("     , (SELECT EQ_CEDEX_OTR_CD_NM FROM MNR_CEDEX_OTR_CD RPR WHERE RPR.EQ_CEDEX_OTR_TP_CD = 'RPR' AND RPR.EQ_CEDEX_OTR_CD = F.EQ_RPR_CD) EQ_RPR_NM" ).append("\n"); 
		query.append("     , (SELECT Q.MNR_CD_DP_DESC FROM MNR_GEN_CD Q WHERE PRNT_CD_ID = 'CD00004' AND Q.MNR_CD_ID = NVL(F.MNR_VRFY_TP_CD, B.MNR_VRFY_TP_CD)) MNR_VRFY_TP_NM" ).append("\n"); 
		query.append("     , TO_CHAR(G.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CAL_DV_FNC('U', B.EQ_NO, TO_CHAR(G.ONH_DT, 'YYYYMMDD')) DV_VALUE" ).append("\n"); 
		query.append("     , CASE WHEN H.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN TRUNC(H.CNTR_STS_EVNT_DT) - TRUNC(G.ONH_DT)" ).append("\n"); 
		query.append("            ELSE TRUNC(SYSDATE) - TRUNC(G.ONH_DT) + 1 END USING_DAYS" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER(ORDER BY A.VNDR_SEQ) VNDR_CNT" ).append("\n"); 
		query.append("  FROM MNR_ORD_HDR A" ).append("\n"); 
		query.append("     , MNR_ORD_DTL B" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append("     , MDM_YARD D" ).append("\n"); 
		query.append("     , MNR_RPR_RQST_HDR E" ).append("\n"); 
		query.append("     , MNR_RPR_RQST_DTL F" ).append("\n"); 
		query.append("     , MST_CONTAINER G" ).append("\n"); 
		query.append("     , MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append(" WHERE A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ " ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("   AND B.EQ_NO = G.CNTR_NO" ).append("\n"); 
		query.append("   AND G.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("   AND G.LST_STS_SEQ = H.CNTR_STS_SEQ" ).append("\n"); 
		query.append("   AND B.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("   AND A.MNR_ORD_OFC_CTY_CD  = E.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.MNR_ORD_SEQ = E.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("   AND E.RQST_EQ_NO = F.RQST_EQ_NO(+)" ).append("\n"); 
		query.append("   AND E.RPR_RQST_SEQ = F.RPR_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND E.RPR_RQST_VER_NO = F.RPR_RQST_VER_NO(+)" ).append("\n"); 
		query.append("   AND F.RPR_RQST_LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND A.MNR_INP_DT BETWEEN TO_DATE(@[s_start_dt] || '000000', 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[s_end_dt] || '235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("   AND A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("   AND A.MNR_WO_TP_CD IN ('EST', 'SPL')" ).append("\n"); 
		query.append("   AND B.COST_CD != 'MRDRCL'" ).append("\n"); 
		query.append("   AND B.EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("   AND D.LOC_CD = @[s_param_loc_cd]" ).append("\n"); 
		query.append("   #if(${s_vndr_seq} != '')" ).append("\n"); 
		query.append("       AND A.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_yd_cd} != '')" ).append("\n"); 
		query.append("       AND D.YD_CD = @[s_loc_cd] || @[s_yd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${s_cnt_cd} != '')" ).append("\n"); 
		query.append("       AND D.LOC_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY A.MNR_ORD_SEQ ASC" ).append("\n"); 

	}
}