/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchUSIORListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchUSIORListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.12.23 이윤정 [CHM-201007730-01] US Inland Operation Report 상의 특수문자 인식 재처리 로직 추가. CHR(29) 처리 로직추가
	  * 2012.02.22 채창호 [CHM-201115166-01]:Split 01-US Inland Operation Report 내, 324 EDI 기능 추가
	  * </pre>
	  */
	public VesselReportDBDAOSearchUSIORListRSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_p_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pup_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchUSIORListRSQL").append("\n"); 
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
		query.append("  BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", UNMATCH_FLG" ).append("\n"); 
		query.append(", BKG_POD_CD" ).append("\n"); 
		query.append(", BKG_DEL_CD" ).append("\n"); 
		query.append(", DEL_LOC_NM" ).append("\n"); 
		query.append(", POD_CD COP_POD_CD" ).append("\n"); 
		query.append(", DEL_CD COP_DEL_CD" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append(", SUBSTR(MVMT_INFO, INSTR(MVMT_INFO,'$',1,1)+1,INSTR(MVMT_INFO,'$',1,2)-INSTR(MVMT_INFO,'$',1,1)-1) AS MVMT_STS" ).append("\n"); 
		query.append(", SUBSTR(MVMT_INFO, INSTR(MVMT_INFO,'$',1,2)+1,INSTR(MVMT_INFO,'$',1,3)-INSTR(MVMT_INFO,'$',1,2)-1) AS MVMT_YD" ).append("\n"); 
		query.append(", SUBSTR(MVMT_INFO, INSTR(MVMT_INFO,'$',1,3)+1,INSTR(MVMT_INFO,'$',1,4)-INSTR(MVMT_INFO,'$',1,3)-1) AS MVMT_DT" ).append("\n"); 
		query.append(", DUP_FLG" ).append("\n"); 
		query.append(", VVD_CD VVD" ).append("\n"); 
		query.append(", SLAN_CD LANE" ).append("\n"); 
		query.append(", VPS_ETA_DT ETA" ).append("\n"); 
		query.append(", SPCL_CGO_CNTR_RF_FLG SPE" ).append("\n"); 
		query.append(", SUBSTR(RD_INFO, INSTR(RD_INFO,'$',1,8)+1,INSTR(RD_INFO,'$',1,9)-INSTR(RD_INFO,'$',1,8)-1) AS RAIL_DEST" ).append("\n"); 
		query.append(", SUBSTR(CSTMS_LOC_INFO, INSTR(CSTMS_LOC_INFO,'$',1,1)+1,INSTR(CSTMS_LOC_INFO,'$',1,2)-INSTR(CSTMS_LOC_INFO,'$',1,1)-1) AS CSTMS_LOC_CD" ).append("\n"); 
		query.append(", SUBSTR(CSTMS_LOC_INFO, INSTR(CSTMS_LOC_INFO,'$',1,2)+1,INSTR(CSTMS_LOC_INFO,'$',1,3)-INSTR(CSTMS_LOC_INFO,'$',1,2)-1) AS CSTMS_LOC_NM" ).append("\n"); 
		query.append(", EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(", BKG_DE_TERM_CD AS TERM" ).append("\n"); 
		query.append(", SUBSTR(RD_INFO, INSTR(RD_INFO,'$',1,9)+1,INSTR(RD_INFO,'$',1,10)-INSTR(RD_INFO,'$',1,9)-1) AS ADD_TRSP" ).append("\n"); 
		query.append(", SUBSTR(RD_INFO, INSTR(RD_INFO,'$',1,1)+1,INSTR(RD_INFO,'$',1,2)-INSTR(RD_INFO,'$',1,1)-1) AS RL_SO_PLN_FLG" ).append("\n"); 
		query.append(", SUBSTR(RD_INFO, INSTR(RD_INFO,'$',1,2)+1,INSTR(RD_INFO,'$',1,3)-INSTR(RD_INFO,'$',1,2)-1) AS RL_SO_FLG" ).append("\n"); 
		query.append(", SUBSTR(RD_INFO, INSTR(RD_INFO,'$',1,3)+1,INSTR(RD_INFO,'$',1,4)-INSTR(RD_INFO,'$',1,3)-1) AS RL_WO_FLG" ).append("\n"); 
		query.append(", SUBSTR(TS_INFO, INSTR(TS_INFO,'$',1,1)+1,INSTR(TS_INFO,'$',1,2)-INSTR(TS_INFO,'$',1,1)-1) AS TS_SO_PLN_FLG" ).append("\n"); 
		query.append(", SUBSTR(TS_INFO, INSTR(TS_INFO,'$',1,2)+1,INSTR(TS_INFO,'$',1,3)-INSTR(TS_INFO,'$',1,2)-1) AS TS_SO_FLG" ).append("\n"); 
		query.append(", SUBSTR(TS_INFO, INSTR(TS_INFO,'$',1,3)+1,INSTR(TS_INFO,'$',1,4)-INSTR(TS_INFO,'$',1,3)-1) AS TS_WO_FLG" ).append("\n"); 
		query.append(", SUBSTR(TC_INFO, INSTR(TC_INFO,'$',1,1)+1,INSTR(TC_INFO,'$',1,2)-INSTR(TC_INFO,'$',1,1)-1) AS TC_SO_PLN_FLG" ).append("\n"); 
		query.append(", SUBSTR(TC_INFO, INSTR(TC_INFO,'$',1,2)+1,INSTR(TC_INFO,'$',1,3)-INSTR(TC_INFO,'$',1,2)-1) AS TC_SO_FLG" ).append("\n"); 
		query.append(", SUBSTR(TC_INFO, INSTR(TC_INFO,'$',1,3)+1,INSTR(TC_INFO,'$',1,4)-INSTR(TC_INFO,'$',1,3)-1) AS TC_WO_FLG" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO, INSTR(DR_INFO,'$',1,1)+1,INSTR(DR_INFO,'$',1,2)-INSTR(DR_INFO,'$',1,1)-1) AS DR_SO_PLN_FLG" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO, INSTR(DR_INFO,'$',1,2)+1,INSTR(DR_INFO,'$',1,3)-INSTR(DR_INFO,'$',1,2)-1) AS DR_SO_FLG" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO, INSTR(DR_INFO,'$',1,3)+1,INSTR(DR_INFO,'$',1,4)-INSTR(DR_INFO,'$',1,3)-1) AS DR_WO_FLG" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO_MST, INSTR(DR_INFO_MST,'$',1,6)+1,INSTR(DR_INFO_MST,'$',1,7)-INSTR(DR_INFO_MST,'$',1,6)-1) AS DR_WO_DT" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO_MST, INSTR(DR_INFO_MST,'$',1,4)+1,INSTR(DR_INFO_MST,'$',1,5)-INSTR(DR_INFO_MST,'$',1,4)-1) AS DR_FM" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO_MST, INSTR(DR_INFO_MST,'$',1,5)+1,INSTR(DR_INFO_MST,'$',1,6)-INSTR(DR_INFO_MST,'$',1,5)-1) AS DR_TO" ).append("\n"); 
		query.append(", SUBSTR(DR_INFO_MST, INSTR(DR_INFO_MST,'$',1,7)+1,INSTR(DR_INFO_MST,'$',1,8)-INSTR(DR_INFO_MST,'$',1,7)-1) AS DR_SP" ).append("\n"); 
		query.append(", (SELECT M.VNDR_LGL_ENG_NM FROM MDM_VENDOR M WHERE M.VNDR_SEQ=" ).append("\n"); 
		query.append("  SUBSTR(DR_INFO_MST, INSTR(DR_INFO_MST,'$',1,7)+1,INSTR(DR_INFO_MST,'$',1,8)-INSTR(DR_INFO_MST,'$',1,7)-1)) AS DR_SP_NM" ).append("\n"); 
		query.append(", COP_STS_CD" ).append("\n"); 
		query.append(", FRM" ).append("\n"); 
		query.append(", DECODE(BKG_DE_TERM_CD,'D',DECODE(SUBSTR(DR_INFO, INSTR(DR_INFO,'$',1,3)+1,INSTR(DR_INFO,'$',1,4)-INSTR(DR_INFO,'$',1,3)-1),'N','Door'),'End') GUIDE" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,1)+1,INSTR(PKUP_INFO,'$',1,2)-INSTR(PKUP_INFO,'$',1,1)-1) AS PKUP_YD_CD" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,2)+1,INSTR(PKUP_INFO,'$',1,3)-INSTR(PKUP_INFO,'$',1,2)-1) AS PKUP_AVAL_DT" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,3)+1,INSTR(PKUP_INFO,'$',1,4)-INSTR(PKUP_INFO,'$',1,3)-1) AS PKUP_FREE_DT" ).append("\n"); 
		query.append(", SUBSTR(FOC_INFO, INSTR(FOC_INFO,'$',1,1)+1,INSTR(FOC_INFO,'$',1,2)-INSTR(FOC_INFO,'$',1,1)-1) AS F" ).append("\n"); 
		query.append(", SUBSTR(FOC_INFO, INSTR(FOC_INFO,'$',1,2)+1,INSTR(FOC_INFO,'$',1,3)-INSTR(FOC_INFO,'$',1,2)-1) AS O" ).append("\n"); 
		query.append(", SUBSTR(FOC_INFO, INSTR(FOC_INFO,'$',1,3)+1,INSTR(FOC_INFO,'$',1,4)-INSTR(FOC_INFO,'$',1,3)-1) AS C" ).append("\n"); 
		query.append(", DSPO_CD" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,4)+1,INSTR(PKUP_INFO,'$',1,5)-INSTR(PKUP_INFO,'$',1,4)-1) AS PKUP_NO" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,5)+1,INSTR(PKUP_INFO,'$',1,6)-INSTR(PKUP_INFO,'$',1,5)-1) AS PKUP_OFC_CD" ).append("\n"); 
		query.append(", SUBSTR(PKUP_INFO, INSTR(PKUP_INFO,'$',1,6)+1,INSTR(PKUP_INFO,'$',1,7)-INSTR(PKUP_INFO,'$',1,6)-1) AS PKUP_END" ).append("\n"); 
		query.append(", SC_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("  SELECT BKG_SPCLCHAR_CONV_FNC(CUST_LGL_ENG_NM, 'M')" ).append("\n"); 
		query.append("    FROM PRI_SP_HDR A1, PRI_SP_MN A2, PRI_SP_CTRT_PTY A3, MDM_CUSTOMER X" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND A1.SC_NO = Z.SC_NO" ).append("\n"); 
		query.append("      AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("      AND A2.AMDT_SEQ = (" ).append("\n"); 
		query.append("                        SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                          FROM PRI_SP_MN" ).append("\n"); 
		query.append("                         WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                           AND PROP_STS_CD = 'F')" ).append("\n"); 
		query.append("      AND A2.PROP_NO  = A3.PROP_NO" ).append("\n"); 
		query.append("      AND A2.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("      AND A3.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("      AND X.CUST_CNT_CD = A3.CUST_CNT_CD " ).append("\n"); 
		query.append("      AND X.CUST_SEQ = A3.CUST_SEQ" ).append("\n"); 
		query.append("      AND ROWNUM=1" ).append("\n"); 
		query.append("  ) AS SC_CUST_NM" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,1)+1,INSTR(CUST_INFO,'$',1,2)-INSTR(CUST_INFO,'$',1,1)-1) AS CNEE_CD" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,2)+1,INSTR(CUST_INFO,'$',1,3)-INSTR(CUST_INFO,'$',1,2)-1) AS CNEE_NM" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,3)+1,INSTR(CUST_INFO,'$',1,4)-INSTR(CUST_INFO,'$',1,3)-1) AS CNEE_ADDR" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,4)+1,INSTR(CUST_INFO,'$',1,5)-INSTR(CUST_INFO,'$',1,4)-1) AS SHPR_CD" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,5)+1,INSTR(CUST_INFO,'$',1,6)-INSTR(CUST_INFO,'$',1,5)-1) AS SHPR_NM" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,6)+1,INSTR(CUST_INFO,'$',1,7)-INSTR(CUST_INFO,'$',1,6)-1) AS SHPR_ADDR" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,7)+1,INSTR(CUST_INFO,'$',1,8)-INSTR(CUST_INFO,'$',1,7)-1) AS NTFY_CD" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,8)+1,INSTR(CUST_INFO,'$',1,9)-INSTR(CUST_INFO,'$',1,8)-1) AS NTFY_NM" ).append("\n"); 
		query.append(", SUBSTR(CUST_INFO, INSTR(CUST_INFO,'$',1,9)+1,INSTR(CUST_INFO,'$',1,10)-INSTR(CUST_INFO,'$',1,9)-1) AS NTFY_ADDR" ).append("\n"); 
		query.append(", FILER" ).append("\n"); 
		query.append(", SUBSTR(IBD_INFO, INSTR(IBD_INFO,'$',1,1)+1,INSTR(IBD_INFO,'$',1,2)-INSTR(IBD_INFO,'$',1,1)-1) AS IT_NO" ).append("\n"); 
		query.append(", SUBSTR(IBD_INFO, INSTR(IBD_INFO,'$',1,2)+1,INSTR(IBD_INFO,'$',1,3)-INSTR(IBD_INFO,'$',1,2)-1) AS IT_DATE" ).append("\n"); 
		query.append(", PO_NO" ).append("\n"); 
		query.append(", SEAL_NO" ).append("\n"); 
		query.append(", CNTR_WGT" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,1)+1,INSTR(CLM_INFO,'$',1,2)-INSTR(CLM_INFO,'$',1,1)-1) AS CLM_CRNT_STS" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,2)+1,INSTR(CLM_INFO,'$',1,3)-INSTR(CLM_INFO,'$',1,2)-1) AS CLM_LOC" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,3)+1,INSTR(CLM_INFO,'$',1,4)-INSTR(CLM_INFO,'$',1,3)-1) AS CLM_STATE" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,4)+1,INSTR(CLM_INFO,'$',1,5)-INSTR(CLM_INFO,'$',1,4)-1) AS CLM_DT" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,5)+1,INSTR(CLM_INFO,'$',1,6)-INSTR(CLM_INFO,'$',1,5)-1) AS TRN_NO" ).append("\n"); 
		query.append(", SUBSTR(CLM_INFO, INSTR(CLM_INFO,'$',1,6)+1,INSTR(CLM_INFO,'$',1,7)-INSTR(CLM_INFO,'$',1,6)-1) AS FCAR_NO" ).append("\n"); 
		query.append(", BKG_CNTR_RMK" ).append("\n"); 
		query.append(", SUBSTR(EDI_324_INFO, INSTR(EDI_324_INFO,'$',1,1)+1,INSTR(EDI_324_INFO,'$',1,2)-INSTR(EDI_324_INFO,'$',1,1)-1) AS EDI_SND_DT" ).append("\n"); 
		query.append(", NVL(SUBSTR(EDI_324_INFO, INSTR(EDI_324_INFO,'$',1,2)+1,INSTR(EDI_324_INFO,'$',1,3)-INSTR(EDI_324_INFO,'$',1,2)-1),'N') AS EDI_SND_TP_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ=Z.VNDR_SEQ ) VNDR_NAME" ).append("\n"); 
		query.append(", ESTM_DT RAIL_ETA " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("      B.BKG_NO" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("    , B.DEL_CD AS BKG_DEL_CD" ).append("\n"); 
		query.append("    , B.DE_TERM_CD AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    , B.SC_NO" ).append("\n"); 
		query.append("    , DECODE(SUBSTR(B.POD_CD,1,2),'US',B.USA_CSTMS_FILE_CD,'CA',B.CND_CSTMS_FILE_CD ) AS FILER" ).append("\n"); 
		query.append("    , L.LOC_NM AS DEL_LOC_NM" ).append("\n"); 
		query.append("    , L.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("    , SUBSTR(H.POD_NOD_CD, 1, 5) AS POD_CD" ).append("\n"); 
		query.append("    , SUBSTR(H.DEL_NOD_CD, 1, 5) AS DEL_CD" ).append("\n"); 
		query.append("    , (CASE WHEN B.POD_CD = SUBSTR(H.POD_NOD_CD, 1, 5) AND B.DEL_CD = SUBSTR(H.DEL_NOD_CD, 1, 5) THEN 'N' ELSE 'Y' END) AS UNMATCH_FLG" ).append("\n"); 
		query.append("    , H.COP_NO" ).append("\n"); 
		query.append("    , (CASE WHEN H.COP_NO = H.MST_COP_NO THEN 'Y' ELSE 'N' END) AS DUP_FLG" ).append("\n"); 
		query.append("    , C.CNTR_NO" ).append("\n"); 
		query.append("    , C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , C.CNMV_CYC_NO" ).append("\n"); 
		query.append("    , TRUNC(DECODE(C.WGT_UT_CD, 'KGS', NVL(C.CNTR_WGT, 0) * 2.2, NVL(C.CNTR_WGT, 0))) AS CNTR_WGT" ).append("\n"); 
		query.append("    , BKG_SPCLCHAR_CONV_FNC(C.DIFF_RMK,'M') BKG_CNTR_RMK" ).append("\n"); 
		query.append("    , V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("    , V.SLAN_CD" ).append("\n"); 
		query.append("    , TO_CHAR(V.VPS_ETA_DT,'YYYY/MM/DD HH24:MI:SS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("    , CASE WHEN C.RC_FLG        = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("           WHEN C.RD_CGO_FLG    = 'Y' THEN 'RD'" ).append("\n"); 
		query.append("           WHEN C.DCGO_FLG      = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("           WHEN C.BB_CGO_FLG    = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("           WHEN C.AWK_CGO_FLG   = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("      END AS SPCL_CGO_CNTR_RF_FLG" ).append("\n"); 
		query.append("    , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00134', H.COP_STS_CD) AS COP_STS_CD" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX_DESC(R XPKBKG_CSTMS_ADV_RSLT) */ R.DSPO_CD FROM BKG_CSTMS_ADV_RSLT R WHERE R.CNT_CD=SUBSTR(B.POD_CD,1,2) AND R.BL_NO = B.BL_NO AND ROWNUM=1) AS DSPO_CD" ).append("\n"); 
		query.append("    , (SELECT CUST_REF_NO_CTNT FROM BKG_REFERENCE R WHERE C.BKG_NO=R.BKG_NO AND C.CNTR_NO=R.CNTR_NO AND R.BKG_REF_TP_CD='CTPO' AND ROWNUM=1) AS PO_NO" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX_ASC(S XPKBKG_CNTR_SEAL_NO) */ S.CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO S WHERE C.BKG_NO = S.BKG_NO AND C.CNTR_NO = S.CNTR_NO AND ROWNUM=1) AS SEAL_NO" ).append("\n"); 
		query.append("    , NVL((SELECT /*+ INDEX_DESC(P XAK5SCE_PLN_SO_LIST) */ " ).append("\n"); 
		query.append("                  '$'||NVL((CASE WHEN P.TRSP_SO_STS_CD='P' THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL((CASE WHEN P.TRSP_SO_STS_CD IN ('C','R','I','E','F','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL((CASE WHEN P.TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||C.CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                ||'$'||R.ARR_LOC_NM" ).append("\n"); 
		query.append("                ||'$'||R.ARR_STE_CD" ).append("\n"); 
		query.append("                ||'$'||TO_CHAR(R.ARR_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("                ||'$'||COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD)" ).append("\n"); 
		query.append("                ||'$'||" ).append("\n"); 
		query.append("                    DECODE((CASE WHEN P.TRSP_MOD_CD ='RD' AND P.TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'Y'," ).append("\n"); 
		query.append("                    --CASE OF Rail Issued" ).append("\n"); 
		query.append("                        DECODE(B.DE_TERM_CD,'Y'," ).append("\n"); 
		query.append("                        DECODE(DECODE(CSTMS_LOC_CD,B.POD_CD,'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD,SUBSTR(NVL((CASE WHEN P.TRSP_MOD_CD = 'RD' THEN COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD) END)," ).append("\n"); 
		query.append("                                                           DECODE(B.POD_CD, A.HUB_LOC_CD, A.HUB_LOC_CD)),1,5),'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD,B.DEL_CD,'0','1')   " ).append("\n"); 
		query.append("                        ||DECODE(SIGN(INSTR((CASE WHEN P.TRSP_MOD_CD='RD' THEN P.N4TH_NOD_CD||P.N3RD_NOD_CD||P.N2ND_NOD_CD END)||(CASE WHEN P.TRSP_MOD_CD = 'RD' THEN P.N4TH_NOD_CD||P.N3RD_NOD_CD||P.N2ND_NOD_CD END)" ).append("\n"); 
		query.append("                              ,CSTMS_LOC_CD)),1,0,1)" ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||SUBSTR(NVL((CASE WHEN P.TRSP_MOD_CD = 'RD' THEN COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD) END)," ).append("\n"); 
		query.append("                                                           DECODE(B.POD_CD, A.HUB_LOC_CD, A.HUB_LOC_CD)),1,5), 'USMKCUSKCK', '0','USKCKUSMKC','0', '1' )  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||B.DEL_CD, 'USMKCUSKCK', '0','USKCKUSMKC','0', '1' )," ).append("\n"); 
		query.append("                        '111111','Y','N'),  " ).append("\n"); 
		query.append("                        DECODE(DECODE(CSTMS_LOC_CD,B.POD_CD,'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD,SUBSTR(NVL((CASE WHEN P.TRSP_MOD_CD = 'RD' THEN COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD) END), " ).append("\n"); 
		query.append("                                                           DECODE(B.POD_CD, A.HUB_LOC_CD, A.HUB_LOC_CD)),1,5),'0','1') " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||SUBSTR(NVL((CASE WHEN P.TRSP_MOD_CD = 'RD' THEN COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD) END)," ).append("\n"); 
		query.append("                                                           DECODE(B.POD_CD, A.HUB_LOC_CD, A.HUB_LOC_CD)),1,5), 'USMKCUSKCK', '0','USKCKUSMKC','0', '1' )  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||B.DEL_CD, 'USMKCUSKCK','0','USKCKUSMKC','0','1')," ).append("\n"); 
		query.append("                        '1111','Y','N'))," ).append("\n"); 
		query.append("                --CASE OF Rail NOT Issued" ).append("\n"); 
		query.append("                    DECODE(" ).append("\n"); 
		query.append("                        DECODE(CSTMS_LOC_CD,B.POD_CD,'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD,SUBSTR(A.HUB_LOC_CD,1,5),'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD,B.DEL_CD,'0','1')  " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||SUBSTR(A.HUB_LOC_CD,1,5), 'USMKCUSKCK', '0','USKCKUSMKC','0', '1' ) " ).append("\n"); 
		query.append("                        ||DECODE(CSTMS_LOC_CD||B.DEL_CD, 'USMKCUSKCK', '0','USKCKUSMKC','0', '1' )," ).append("\n"); 
		query.append("                        '11111','Y','N'))" ).append("\n"); 
		query.append("                ||'$'" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P, TRS_TRSP_RAIL_BIL_ORD R, SCE_CLM_SGHT C, BKG_CSTMS_ADV_BL A, BKG_BOOKING BKG WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='RD' " ).append("\n"); 
		query.append("         AND P.COP_NO=R.COP_NO(+) AND P.COST_ACT_GRP_SEQ=R.COST_ACT_GRP_SEQ(+) AND R.DELT_FLG(+)='N' AND R.CLM_SGHT_CD=C.CLM_SGHT_CD(+) " ).append("\n"); 
		query.append("         AND B.BL_NO = BKG.BL_NO AND BKG.BL_NO=A.BL_NO(+) AND SUBSTR(BKG.POD_CD, 1, 2)=A.CNT_CD(+) AND ROWNUM=1),'$N$N$N$$$$$$N$') AS RD_INFO" ).append("\n"); 
		query.append("    , NVL((SELECT /*+ INDEX_ASC(P XAK5SCE_PLN_SO_LIST) */ " ).append("\n"); 
		query.append("                  '$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD='P' THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('C','R','I','E','F','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD <> 'IDTD' AND ROWNUM=1),'$N$N$N$') AS TS_INFO" ).append("\n"); 
		query.append("    , NVL2((SELECT COP_NO" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD <> 'IDTD' GROUP BY COP_NO HAVING COUNT(*)>1)" ).append("\n"); 
		query.append("         , (SELECT /*+ INDEX_DESC(P XAK5SCE_PLN_SO_LIST) */ " ).append("\n"); 
		query.append("                  '$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD='P' THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('C','R','I','E','F','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD <> 'IDTD' AND ROWNUM=1),'$N$N$N$') AS TC_INFO" ).append("\n"); 
		query.append("    , (SELECT '$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD='P' THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('C','R','I','E','F','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||MAX(P.N1ST_NOD_CD)" ).append("\n"); 
		query.append("                ||'$'||MAX(COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD))" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX((SELECT (TO_CHAR(W.CRE_DT,'YYYY/MM/DD HH24:MI:SS'))" ).append("\n"); 
		query.append("                            ||'$'||(NVL(V.VNDR_SEQ,P.N1ST_VNDR_SEQ))" ).append("\n"); 
		query.append("                            ||'$'" ).append("\n"); 
		query.append("                              FROM TRS_TRSP_SVC_ORD V, TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("                              WHERE P.COP_NO=V.COP_NO(+) AND P.COST_ACT_GRP_SEQ=V.COST_ACT_GRP_SEQ(+) AND V.DELT_FLG(+)='N' AND V.TRSP_SO_TP_CD(+)='Y'" ).append("\n"); 
		query.append("                                AND V.TRSP_WO_OFC_CTY_CD=W.TRSP_WO_OFC_CTY_CD(+) AND V.TRSP_WO_SEQ=W.TRSP_WO_SEQ(+))),'$'||MAX(P.N1ST_VNDR_SEQ)||'$')" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.COST_ACT_GRP_CD='IDTD') AS DR_INFO" ).append("\n"); 
		query.append("    , (SELECT '$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD='P' THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('C','R','I','E','F','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX(CASE WHEN TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N')" ).append("\n"); 
		query.append("                ||'$'||MAX(P.N1ST_NOD_CD)" ).append("\n"); 
		query.append("                ||'$'||MAX(COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD))" ).append("\n"); 
		query.append("                ||'$'||NVL(MAX((SELECT (TO_CHAR(W.CRE_DT,'YYYY/MM/DD HH24:MI:SS'))" ).append("\n"); 
		query.append("                            ||'$'||(NVL(V.VNDR_SEQ,P.N1ST_VNDR_SEQ))" ).append("\n"); 
		query.append("                            ||'$'" ).append("\n"); 
		query.append("                              FROM TRS_TRSP_SVC_ORD V, TRS_TRSP_WRK_ORD W" ).append("\n"); 
		query.append("                              WHERE P.COP_NO=V.COP_NO(+) AND P.COST_ACT_GRP_SEQ=V.COST_ACT_GRP_SEQ(+) AND V.DELT_FLG(+)='N' AND V.TRSP_SO_TP_CD(+)='Y'" ).append("\n"); 
		query.append("                                AND V.TRSP_WO_OFC_CTY_CD=W.TRSP_WO_OFC_CTY_CD(+) AND V.TRSP_WO_SEQ=W.TRSP_WO_SEQ(+))),'$'||MAX(P.N1ST_VNDR_SEQ)||'$')" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P, SCE_COP_HDR H2 WHERE H2.MST_COP_NO = H.MST_COP_NO AND H.MST_COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.COST_ACT_GRP_CD='IDTD') AS DR_INFO_MST" ).append("\n"); 
		query.append("    , (SELECT   '$'||N.PKUP_YD_CD" ).append("\n"); 
		query.append("              ||'$'||TO_CHAR(N.PKUP_AVAL_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("              ||'$'||TO_CHAR(N.LST_FREE_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("              ||'$'||N.PKUP_NO" ).append("\n"); 
		query.append("              ||'$'||N.OFC_CD" ).append("\n"); 
		query.append("              ||'$'||DECODE(N.PKUP_NTC_IND_CD,'S','Y','E','Y','N')" ).append("\n"); 
		query.append("              ||'$' FROM SCE_COP_HDR H2, BKG_PKUP_NTC_PKUP_NO N " ).append("\n"); 
		query.append("        WHERE H.MST_COP_NO=H2.MST_COP_NO AND H2.BKG_NO=N.BKG_NO AND H2.CNTR_NO=N.CNTR_NO AND ROWNUM=1) AS PKUP_INFO" ).append("\n"); 
		query.append("    , (SELECT '$'||I.IBD_TRSP_NO||'$'||TO_CHAR(I.IBD_TRSP_ISS_DT,'YYYY/MM/DD HH24:MI:SS')||'$' FROM BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append("        WHERE B.BL_NO=I.BL_NO AND SUBSTR(B.POD_CD, 1, 2)=I.CNT_CD) AS IBD_INFO" ).append("\n"); 
		query.append("    , (SELECT MIN(TO_CHAR(D.ESTM_DT,'YYYY/MM/DD HH24:MI:SS')) KEEP (DENSE_RANK FIRST ORDER BY D.COP_DTL_SEQ DESC)" ).append("\n"); 
		query.append("         FROM SCE_COP_DTL D WHERE H.COP_NO=D.COP_NO AND ACT_CD='FIRRAD') AS ESTM_DT" ).append("\n"); 
		query.append("    , (SELECT '$'||NVL(C.FRT_CLT_FLG,'N')||'$'||NVL(C.OBL_RDEM_FLG,'N')||'$'||NVL(C.CSTMS_CLR_CD,'N')||'$' FROM BKG_CGO_RLSE C WHERE B.BL_NO=C.BL_NO) AS FOC_INFO" ).append("\n"); 
		query.append("    , (SELECT   '$'||MAX(DECODE(BKG_CUST_TP_CD,'C',LPAD(CUST_CNT_CD,2,' ')||LPAD(CUST_SEQ,6,'0')))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'C',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_NM, 'M'), 1, 50)))  " ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'C',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_ADDR, 'M'), 1, 50)))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'S',LPAD(CUST_CNT_CD,2,' ')||LPAD(CUST_SEQ,6,'0')))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'S',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_NM, 'M'), 1, 50)))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'S',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_ADDR, 'M'), 1, 50)))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'N',LPAD(CUST_CNT_CD,2,' ')||LPAD(CUST_SEQ,6,'0')))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'N',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_NM, 'M'), 1, 50)))" ).append("\n"); 
		query.append("              ||'$'||MAX(DECODE(BKG_CUST_TP_CD,'N',SUBSTRB(BKG_SPCLCHAR_CONV_FNC(C.CUST_ADDR, 'M'), 1, 50)))" ).append("\n"); 
		query.append("              ||'$' FROM BKG_CUSTOMER C WHERE B.BKG_NO=C.BKG_NO) AS CUST_INFO" ).append("\n"); 
		query.append("    , (SELECT CASE WHEN MAX(CASE WHEN P.TRSP_MOD_CD = 'TD' THEN P.COST_ACT_GRP_SEQ END) > MAX(CASE WHEN P.TRSP_MOD_CD = 'RD' THEN P.COST_ACT_GRP_SEQ END)" ).append("\n"); 
		query.append("                   THEN SUBSTR(MAX(CASE WHEN P.TRSP_MOD_CD = 'TD' THEN P.COST_ACT_GRP_SEQ||P.N1ST_NOD_CD END),4) END" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.TRSP_MOD_CD IN ('TD','RD')) AS FRM" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX_DESC(M XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                '$'||M.MVMT_STS_CD" ).append("\n"); 
		query.append("              ||'$'||M.ORG_YD_CD" ).append("\n"); 
		query.append("              ||'$'||TO_CHAR(M.CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("              ||'$' FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("       WHERE M.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("       AND M.CNMV_CYC_NO =C.CNMV_CYC_NO" ).append("\n"); 
		query.append("       AND ROWNUM=1) AS MVMT_INFO" ).append("\n"); 
		query.append("    , (SELECT   '$'||MIN(TO_CHAR(R.EDI_SND_DT,'YYYY-MM-DD HH24:MI:SS')) KEEP (DENSE_RANK FIRST ORDER BY R.CRE_DT DESC)" ).append("\n"); 
		query.append("              ||'$'||MIN(EDI_SND_TP_CD) KEEP (DENSE_RANK FIRST ORDER BY R.CRE_DT DESC)" ).append("\n"); 
		query.append("              ||'$'  FROM SCE_EDI_324_SND_RSLT R WHERE H.BKG_NO=R.BKG_NO AND H.CNTR_NO=R.CNTR_NO) AS EDI_324_INFO" ).append("\n"); 
		query.append("    , (SELECT MAX(NVL((SELECT G.VNDR_SEQ FROM EDI_324_GRP G WHERE G.VNDR_SEQ=P.N1ST_VNDR_SEQ),P.N1ST_VNDR_SEQ))" ).append("\n"); 
		query.append("         FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='RD') AS VNDR_SEQ" ).append("\n"); 
		query.append("    , (SELECT   '$'||NVL(A.CSTMS_LOC_CD,A.HUB_LOC_CD)||'$'||ML.LOC_NM||'$'  FROM BKG_CSTMS_ADV_BL A, MDM_LOCATION ML " ).append("\n"); 
		query.append("                     WHERE B.BL_NO=A.BL_NO AND SUBSTR(B.POD_CD, 1, 2)=A.CNT_CD" ).append("\n"); 
		query.append("                     AND NVL(A.CSTMS_LOC_CD,A.HUB_LOC_CD) = ML.LOC_CD AND ROWNUM = 1) AS CSTMS_LOC_INFO" ).append("\n"); 
		query.append("    , (SELECT /*+ INDEX_DESC(P XAK5SCE_PLN_SO_LIST) */ " ).append("\n"); 
		query.append("                '$'||C.CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                ||'$'||R.ARR_LOC_NM" ).append("\n"); 
		query.append("                ||'$'||R.ARR_STE_CD" ).append("\n"); 
		query.append("                ||'$'||TO_CHAR(R.ARR_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("				||'$'||R.TRN_NO" ).append("\n"); 
		query.append("                ||'$'||R.FCAR_NO" ).append("\n"); 
		query.append("                ||'$'" ).append("\n"); 
		query.append("         FROM SCE_COP_HDR H2, TRS_TRSP_RAIL_BIL_ORD R, SCE_CLM_SGHT C " ).append("\n"); 
		query.append("         WHERE H2.MST_COP_NO = H.MST_COP_NO AND H2.COP_NO = R.COP_NO" ).append("\n"); 
		query.append("         AND R.TRSP_BND_CD = 'I' AND R.DELT_FLG='N' AND R.CLM_SGHT_CD=C.CLM_SGHT_CD " ).append("\n"); 
		query.append("         AND ROWNUM=1) AS CLM_INFO" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("      BKG_BOOKING       B" ).append("\n"); 
		query.append("    , BKG_CONTAINER     C" ).append("\n"); 
		query.append("    , VSK_VSL_PORT_SKD  V" ).append("\n"); 
		query.append("    , SCE_COP_HDR       H" ).append("\n"); 
		query.append("    , MDM_LOCATION      L" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND B.VSL_CD        = V.VSL_CD" ).append("\n"); 
		query.append("    AND B.SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND B.SKD_DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND B.POD_CD        = V.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND B.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("    AND B.BKG_STS_CD    IN ('F','W')" ).append("\n"); 
		query.append("#if(${s_c_loc} != '')" ).append("\n"); 
		query.append("#if(${s_c_loc} == 'L')" ).append("\n"); 
		query.append("    AND ( B.DEST_TRNS_SVC_MOD_CD IN ('CLO', 'ELO','LOC','NLO') OR B.DEST_TRNS_SVC_MOD_CD IS NULL )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND B.DEST_TRNS_SVC_MOD_CD IN ('CIP', 'IPI','MLB','NIP')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND B.BKG_NO        = C.BKG_NO" ).append("\n"); 
		query.append("--    AND B.BKG_NO        IN ('NKKB43295500','SEL4A4280602')" ).append("\n"); 
		query.append("    AND C.BKG_NO        = H.BKG_NO" ).append("\n"); 
		query.append("    AND C.CNTR_NO       = H.CNTR_NO" ).append("\n"); 
		query.append("    AND B.DEL_CD        = L.LOC_CD" ).append("\n"); 
		query.append("--    AND V.VPS_ETA_DT BETWEEN TO_DATE('2014-09-01'||' 00:00:00','YYYY/MM/DD HH24:MI:SS') AND TO_DATE('2014-09-02'||' 23:59:59','YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#if(${dateselect} == 'E')" ).append("\n"); 
		query.append("AND V.VPS_ETA_DT BETWEEN to_date(@[fm_dt]||' 00:00:00','YYYY/MM/DD HH24:MI:SS') AND to_date(@[to_dt]||' 23:59:59','YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif(${dateselect} == 'R')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_DTL D WHERE H.COP_NO=D.COP_NO AND ACT_CD='FIRRAD'" ).append("\n"); 
		query.append("               AND D.ESTM_DT BETWEEN to_date(@[fm_dt]||' 00:00:00','YYYY/MM/DD HH24:MI:SS') AND to_date(@[to_dt]||' 23:59:59','YYYY/MM/DD HH24:MI:SS'))" ).append("\n"); 
		query.append("#elseif(${dateselect} == 'S')" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P, SCE_EDI_324_SND_RSLT R " ).append("\n"); 
		query.append("                 WHERE H.COP_NO=P.COP_NO" ).append("\n"); 
		query.append("                   AND P.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("                   AND P.N1ST_VNDR_SEQ=R.VNDR_SEQ" ).append("\n"); 
		query.append("                   AND H.BKG_NO=R.BKG_NO" ).append("\n"); 
		query.append("                   AND H.CNTR_NO=R.CNTR_NO" ).append("\n"); 
		query.append("                   AND R.EDI_SND_DT BETWEEN to_date(@[fm_dt]||' 00:00:00','YYYY/MM/DD HH24:MI:SS') AND to_date(@[to_dt]||' 23:59:59','YYYY/MM/DD HH24:MI:SS'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_bkg_no} != '')  " ).append("\n"); 
		query.append("AND (B.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( $ele in ${s_bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_cntr_no} != '')" ).append("\n"); 
		query.append("AND (H.CNTR_NO IN (" ).append("\n"); 
		query.append("#foreach( $ele in ${s_cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mst_bkg_sts} != '')" ).append("\n"); 
		query.append("#if(${mst_bkg_sts} == 'Y')" ).append("\n"); 
		query.append("AND H.MST_COP_NO = H.COP_NO" ).append("\n"); 
		query.append("#elseif(${mst_bkg_sts} == 'N')" ).append("\n"); 
		query.append("AND H.MST_COP_NO != H.COP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* POL_POD */" ).append("\n"); 
		query.append("#if(${s_pol_pod} != '')" ).append("\n"); 
		query.append("AND   V.VPS_PORT_CD IN   (" ).append("\n"); 
		query.append("#if( ${s_pol_pod} == 'ALL')" ).append("\n"); 
		query.append("#foreach($ele in ${port_cd}) " ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach($ele in ${s_pol_pod})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Lane */" ).append("\n"); 
		query.append("#if(${s_lane} != '')" ).append("\n"); 
		query.append("AND V.SLAN_CD  =  @[s_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD */     " ).append("\n"); 
		query.append("#if(${s_vvd} != '')" ).append("\n"); 
		query.append("AND V.VSL_CD     = substr(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = substr(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = substr(@[s_vvd],9,1)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("/* DEL */" ).append("\n"); 
		query.append("#if(${s_del} != '')" ).append("\n"); 
		query.append("AND B.DEL_CD = @[s_del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* SC_NO */" ).append("\n"); 
		query.append("#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("AND B.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* P_NO */" ).append("\n"); 
		query.append("#if(${t_p_no} != '')" ).append("\n"); 
		query.append("AND C.PO_NO = @[t_p_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* So_Office */" ).append("\n"); 
		query.append("#if(${s_eq_office} != '') " ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO" ).append("\n"); 
		query.append("               AND P.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach($ele in ${s_eq_offic})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* PKUP_Office */" ).append("\n"); 
		query.append("#if(${s_pup_office} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_HDR H2, BKG_PKUP_NTC_PKUP_NO N " ).append("\n"); 
		query.append("             WHERE H.MST_COP_NO=H2.MST_COP_NO AND H2.BKG_NO=N.BKG_NO AND H2.CNTR_NO=N.CNTR_NO AND ROWNUM=1" ).append("\n"); 
		query.append("               AND  N.OFC_CD =  @[s_pup_office])" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("/* PKUP_Status */" ).append("\n"); 
		query.append("#if(${t_pup_sts} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_COP_HDR H2, BKG_PKUP_NTC_PKUP_NO N " ).append("\n"); 
		query.append("             WHERE H.MST_COP_NO=H2.MST_COP_NO AND H2.BKG_NO=N.BKG_NO AND H2.CNTR_NO=N.CNTR_NO AND ROWNUM=1" ).append("\n"); 
		query.append("#if(${t_pup_sts} == 'I')" ).append("\n"); 
		query.append("               AND    N.PKUP_NTC_IND_CD  IS NOT NULL" ).append("\n"); 
		query.append("#elseif(${t_pup_sts} == 'N')" ).append("\n"); 
		query.append("               AND    N.PKUP_NTC_IND_CD  IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* EQ CONTROL OFFICE 조절 */" ).append("\n"); 
		query.append("#if(${s_neweq_office} != '')" ).append("\n"); 
		query.append("AND L.EQ_CTRL_OFC_CD IN ( #if( ${s_neweq_office} == 'ALL')" ).append("\n"); 
		query.append("#foreach($ele in ${eqmt_ofc})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach($ele in ${s_neweq_office})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_seq} != '' && ${vndr_seq} != 'All')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.N1ST_VNDR_SEQ = @[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_rail_dest} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO" ).append("\n"); 
		query.append("AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND (COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD) IN  (                                    " ).append("\n"); 
		query.append("#foreach( $ele in ${s_rail_dest}) " ).append("\n"); 
		query.append("#if($velocityCount == 1) " ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") OR SUBSTR(COALESCE(P.N4TH_NOD_CD,P.N3RD_NOD_CD,P.N2ND_NOD_CD),1,5) IN (                                        " ).append("\n"); 
		query.append("#foreach( $ele in ${s_rail_dest}) " ).append("\n"); 
		query.append("#if($velocityCount == 1) " ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Rail_Billing_Status */" ).append("\n"); 
		query.append("#if(${t_rail_billing_sts} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("#if(${t_rail_billing_sts} == 'Y')" ).append("\n"); 
		query.append("AND NVL((CASE WHEN P.TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N') ='Y'" ).append("\n"); 
		query.append("#elseif(${t_rail_billing_sts} == 'N')" ).append("\n"); 
		query.append("AND NVL((CASE WHEN P.TRSP_SO_STS_CD IN ('I','E','X') THEN 'Y' ELSE 'N' END),'N') ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Truck_Status : Truck Issued 상태코드 (I/E/X) */" ).append("\n"); 
		query.append("#if(${t_truck_sts} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD='TD'" ).append("\n"); 
		query.append("#if(${t_truck_sts} == 'Y')" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD IN ('I','E','X')" ).append("\n"); 
		query.append("#elseif(${t_truck_sts} == 'N')" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD NOT IN ('I','E','X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* End_Status  '%EXECUTED%' */" ).append("\n"); 
		query.append("#if(${t_end_sts} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND P.TRSP_MOD_CD<>'WD'" ).append("\n"); 
		query.append("#if(${t_end_sts} == 'Y')" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD IN ('I','E','X')" ).append("\n"); 
		query.append("#elseif(${t_end_sts} == 'N')" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD NOT IN ('I','E','X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Cost_Mode  : 'R' Rail 'D'>Door 'S'>Shuttle 'A'>Additional(CY) 'W'>WATER */" ).append("\n"); 
		query.append("#if(${t_cost_mode} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST P WHERE H.COP_NO=P.COP_NO AND P.COST_ACT_GRP_SEQ>'599' AND TRSP_SO_STS_CD IN ('P','C','R','I','E','F','X')" ).append("\n"); 
		query.append("#if(${t_cost_mode} == 'R')" ).append("\n"); 
		query.append("AND P.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("#elseif(${t_cost_mode} == 'D')" ).append("\n"); 
		query.append("AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD='IDTD'" ).append("\n"); 
		query.append("#elseif(${t_cost_mode} == 'S')" ).append("\n"); 
		query.append("AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD<>'IDTD'" ).append("\n"); 
		query.append("#elseif(${t_cost_mode} == 'A')" ).append("\n"); 
		query.append("AND P.TRSP_MOD_CD='TD' AND P.COST_ACT_GRP_CD<>'IDTD'" ).append("\n"); 
		query.append("GROUP BY COP_NO HAVING COUNT(*)>1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${edi_status} != 'ALL')" ).append("\n"); 
		query.append("AND (SELECT MIN(EDI_SND_TP_CD) KEEP (DENSE_RANK FIRST ORDER BY R.CRE_DT DESC) FROM SCE_EDI_324_SND_RSLT R" ).append("\n"); 
		query.append("    WHERE H.BKG_NO=R.BKG_NO AND H.CNTR_NO=R.CNTR_NO) = @[edi_status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_mvmt_cd} != '' || ${s_mvmt_cd} == 'All')" ).append("\n"); 
		query.append("AND SUBSTR(MVMT_INFO, INSTR(MVMT_INFO,'$',1,1)+1,INSTR(MVMT_INFO,'$',1,2)-INSTR(MVMT_INFO,'$',1,1)-1) IN (" ).append("\n"); 
		query.append("#foreach( $ele in ${s_mvmt_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1) '$ele'" ).append("\n"); 
		query.append("#else ,'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}