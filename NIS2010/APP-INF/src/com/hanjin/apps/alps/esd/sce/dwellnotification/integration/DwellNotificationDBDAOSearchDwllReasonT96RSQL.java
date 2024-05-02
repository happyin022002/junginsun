/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllReasonT96RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllReasonT96RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * T96 reson 데이터 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllReasonT96RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_rsn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_tm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllReasonT96RSQL").append("\n"); 
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
		query.append("CASE WHEN DWLL_RSN_TP_CD='A' THEN 'Available for Pick up'||CHR(10)" ).append("\n"); 
		query.append("ELSE (" ).append("\n"); 
		query.append("( CASE WHEN ((DWL.CA_FLG='Y' AND SUBSTR(DWL.FOC_CD,1,2)='YY') OR (DWL.CA_FLG='N' AND DWL.FOC_CD='YYY')) AND DWL.RAIL_MODE = 'N' THEN NVL2(DWL.INSTR_RMK, 'Cntr Delay Reason:'||DECODE(DWL.DWLL_RSN_TP_CD,'D','Demurrage Pending, ')||DWL.INSTR_RMK||CHR(10), NVL2(DWL.INTER_RMK, 'Cntr Delay Reason:'||DECODE(DWL.DWLL_RSN_TP_CD,'D','Demurrage Pending, ')||DWL.INTER_RMK||CHR(10), ''))" ).append("\n"); 
		query.append("WHEN ((DWL.CA_FLG='Y' AND SUBSTR(DWL.FOC_CD,1,2)='YY') OR (DWL.CA_FLG='N' AND DWL.FOC_CD='YYY')) AND DWL.RAIL_MODE = 'Y' THEN" ).append("\n"); 
		query.append("(SELECT NVL2(RPT.CRNT_DWLL_RMK, 'Cntr Delay Reason:'||DECODE(DWL.DWLL_RSN_TP_CD,'D','Demurrage Pending, ')||RPT.CRNT_DWLL_RMK||CHR(10), DECODE(DWL.DWLL_RSN_TP_CD,'D','Cntr Delay Reason:Demurrage Pending, ')) FROM SCE_RAIL_TZ_RPT RPT WHERE RPT.TRSP_SO_OFC_CTY_CD = SUBSTR(RAIL_FM_TO_NOD_CD, 15, 3) AND RPT.TRSP_SO_SEQ = SUBSTR(RAIL_FM_TO_NOD_CD, 18))" ).append("\n"); 
		query.append("ELSE 'Cntr Delay Reason:'||" ).append("\n"); 
		query.append("(CASE WHEN DWL.RAIL_MODE = 'Y' AND SUBSTR(DWL.FOC_CD,1,2) <> 'YY' THEN (SELECT R.CRNT_DWLL_RMK||',' FROM SCE_RAIL_TZ_RPT R WHERE R.TRSP_SO_OFC_CTY_CD = SUBSTR(RAIL_FM_TO_NOD_CD, 15, 3) AND R.TRSP_SO_SEQ = SUBSTR(RAIL_FM_TO_NOD_CD, 18)) ELSE '' END" ).append("\n"); 
		query.append("|| CASE WHEN DWL.RAIL_MODE = 'N' AND SUBSTR(DWL.FOC_CD,1,1) <> 'Y' THEN 'Ocean freight is not paid,' ELSE '' END" ).append("\n"); 
		query.append("|| CASE WHEN DWL.RAIL_MODE = 'N' AND SUBSTR(DWL.FOC_CD,2,1) <> 'Y' THEN ' Original B/L is not collected,' ELSE '' END" ).append("\n"); 
		query.append("|| CASE WHEN DWL.CA_FLG='N' AND SUBSTR(DWL.FOC_CD,3,1) = 'H' THEN ' Customs Hold,' ELSE '' END" ).append("\n"); 
		query.append("|| DECODE(DWL.DWLL_RSN_TP_CD,'D',' Demurrage Pending'))||CHR(10)" ).append("\n"); 
		query.append("END )) END" ).append("\n"); 
		query.append("|| (CASE WHEN DWL.RAIL_MODE='N' AND TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE+2, 'USNYC'),'YYYYMMDD') >= TO_CHAR(TO_DATE(DWL.FT_END_DT, 'YYYYMMDD'),'YYYYMMDD') THEN" ).append("\n"); 
		query.append("NVL2(DWL.FT_END_DT, 'Note : Last Free Day at the port is '||SUBSTR(DWL.FT_END_DT,1,4)||'-'||SUBSTR(DWL.FT_END_DT,5,2)||'-'||SUBSTR(DWL.FT_END_DT,7,2), '') END)" ).append("\n"); 
		query.append("|| NVL2(DWL.DWL_VVD_RSN, 'VVD Delay Reason:'||DWL.DWL_VVD_RSN, '') DWLL_RSN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(H.POD_CD, 1, 2) = 'CA' AND SUBSTR(H.DEL_CD, 1, 2) = 'CA' THEN 'Y' ELSE 'N' END CA_FLG" ).append("\n"); 
		query.append(", (SELECT INTER_RMK FROM BKG_DO_REF B WHERE H.BKG_NO = B.BKG_NO) INTER_RMK" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(INS XPKBKG_USA_CUST_SVC_INSTR) */ INSTR_RMK FROM BKG_USA_CUST_SVC_INSTR I WHERE H.BKG_NO = I.BKG_NO AND I.DELT_FLG = 'N' AND INSTR_RMK_TP_CD='96T' AND ROWNUM=1) INSTR_RMK" ).append("\n"); 
		query.append(", (SELECT DWLL_RSN FROM SCE_DWLL_RSN R WHERE R.VSL_CD=H.VSL_CD AND R.SKD_VOY_NO=H.SKD_VOY_NO AND R.SKD_DIR_CD=H.SKD_DIR_CD) DWL_VVD_RSN" ).append("\n"); 
		query.append(", NVL(FRT_CLT_FLG,'N')||NVL(OBL_RDEM_FLG,'N')||NVL(CSTMS_CLR_CD,'N') FOC_CD" ).append("\n"); 
		query.append(", RAIL_SO_FLG RAIL_MODE" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(MIN(C.FT_END_DT),'YYYYMMDD') FT_END_DT FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (SELECT D.SYS_AREA_GRP_ID ,D.CNTR_NO ,D.CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR D WHERE D.BKG_NO IN (" ).append("\n"); 
		query.append("SELECT BKG_NO FROM SCE_COP_HDR IN_A WHERE IN_A.MST_COP_NO = A.MST_COP_NO))" ).append("\n"); 
		query.append("AND C.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'POD'" ).append("\n"); 
		query.append("AND SUBSTR(C.FM_MVMT_YD_CD,1,5) = H.POD_CD" ).append("\n"); 
		query.append("GROUP BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD) FT_END_DT" ).append("\n"); 
		query.append(", (SELECT RPAD(O.FM_NOD_CD, 7, ' ') || RPAD(O.TO_NOD_CD, 7, ' ') || TRSP_SO_OFC_CTY_CD|| TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD O" ).append("\n"); 
		query.append("WHERE O.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND NVL(O.TRSP_FRST_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND O.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("AND SUBSTR(O.POD_NOD_CD,1,5) = SUBSTR(O.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND O.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND ROWNUM = 1) RAIL_FM_TO_NOD_CD" ).append("\n"); 
		query.append(",@[dwll_rsn_tp_cd] DWLL_RSN_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_DWLL_NTFC_CNDDT H" ).append("\n"); 
		query.append(", SCE_COP_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.EML_SND_DT= @[eml_snd_dt]" ).append("\n"); 
		query.append("AND H.DWLL_TM_TP_CD= @[dwll_tm_tp_cd]" ).append("\n"); 
		query.append("AND H.CNTR_NO= @[cntr_no]" ).append("\n"); 
		query.append("AND H.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("AND H.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND H.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append(") DWL" ).append("\n"); 

	}
}