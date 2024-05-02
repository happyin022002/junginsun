/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsReportDBDAOsearchBkgCCAMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsReportDBDAOsearchBkgCCAMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCCAM
	  * </pre>
	  */
	public ChinaCustomsReportDBDAOsearchBkgCCAMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsReportDBDAOsearchBkgCCAMRSQL").append("\n"); 
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
		query.append("SELECT	VVD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("OLA.REGION AS RHQ," ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("BKG_OFC_CD," ).append("\n"); 
		query.append("#elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("MDM_LOC.EQ_CTRL_OFC_CD AS BKG_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT," ).append("\n"); 
		query.append("TO_CHAR(SND_DT,'YYYY-MM-DD HH24:MI') SND_DT," ).append("\n"); 
		query.append("ROUND((GLOBALDATE_PKG.TIME_CONV_FNC(POL_CD, VPS_ETB_DT, 'CNSHA') - SND_DT) * 24,2) GAP," ).append("\n"); 
		query.append("BL_CNT," ).append("\n"); 
		query.append("SND_CNT," ).append("\n"); 
		query.append("ACPT_CNT," ).append("\n"); 
		query.append("RJCT_CNT," ).append("\n"); 
		query.append("WAIT_CNT," ).append("\n"); 
		query.append("AMEND_CNT," ).append("\n"); 
		query.append("SND_CNT - (ACPT_CNT + RJCT_CNT + WAIT_CNT) N_RCV_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("SKD.SLAN_CD," ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("VVD.POL_CD," ).append("\n"); 
		query.append("SKD.VPS_ETB_DT," ).append("\n"); 
		query.append("MAX(( SELECT    MAX(MST.MF_SND_DT)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O')) SND_DT," ).append("\n"); 
		query.append("COUNT(*) BL_CNT," ).append("\n"); 
		query.append("COUNT(( SELECT  DISTINCT DTL.BL_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O')) SND_CNT," ).append("\n"); 
		query.append("COUNT(( SELECT  1" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'" ).append("\n"); 
		query.append("AND     DTL.CHN_CSTMS_AGN_ACK_TP_CD = '01'" ).append("\n"); 
		query.append("AND     DTL.AGN_ACK_UPD_DT = (  SELECT  MAX(AGN_ACK_UPD_DT)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'))) ACPT_CNT," ).append("\n"); 
		query.append("COUNT(( SELECT  1" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'" ).append("\n"); 
		query.append("AND     DTL.CHN_CSTMS_AGN_ACK_TP_CD = '03'" ).append("\n"); 
		query.append("AND     DTL.AGN_ACK_UPD_DT = (  SELECT  MAX(AGN_ACK_UPD_DT)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'))) RJCT_CNT," ).append("\n"); 
		query.append("COUNT(( SELECT  1" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'" ).append("\n"); 
		query.append("AND     DTL.CHN_CSTMS_AGN_ACK_TP_CD = '02'" ).append("\n"); 
		query.append("AND     DTL.AGN_ACK_UPD_DT = (  SELECT  MAX(AGN_ACK_UPD_DT)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'))) WAIT_CNT," ).append("\n"); 
		query.append("COUNT(( SELECT  DISTINCT DTL.BL_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG MST," ).append("\n"); 
		query.append("BKG_CSTMS_CHN_SND_LOG_BL DTL" ).append("\n"); 
		query.append("WHERE   MST.EDI_REF_ID = DTL.EDI_REF_ID" ).append("\n"); 
		query.append("AND     MST.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     MST.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     MST.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     MST.BKG_POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     DTL.BL_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     MST.CHN_MF_SND_IND_CD = 'O'" ).append("\n"); 
		query.append("AND     MST.TRSM_MSG_TP_ID = '5')) AMEND_CNT" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG," ).append("\n"); 
		query.append("BKG_VVD VVD," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE   VVD.VSL_CD      = SKD.VSL_CD" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO  = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD  = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     VVD.POL_CD      = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND		VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     VVD.BKG_NO      = BKG.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     SKD.VPS_ETB_DT  >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("AND     SKD.VPS_ETB_DT  <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("#if(${p_vvd} != '')" ).append("\n"); 
		query.append("AND		VVD.VSL_CD = SUBSTR(@[p_vvd],1,4)" ).append("\n"); 
		query.append("AND		VVD.SKD_VOY_NO = SUBSTR(@[p_vvd],5,4)" ).append("\n"); 
		query.append("AND		VVD.SKD_DIR_CD = SUBSTR(@[p_vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${p_pol} != '')" ).append("\n"); 
		query.append("AND		VVD.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${p_pod} != '')" ).append("\n"); 
		query.append("AND		VVD.POD_CD = @[p_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${p_lane} != '')" ).append("\n"); 
		query.append("AND		SKD.SLAN_CD = @[p_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     VVD.POD_CD LIKE 'CN%'" ).append("\n"); 
		query.append("AND     VVD.POL_CD NOT LIKE 'CN%'" ).append("\n"); 
		query.append("AND     BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("GROUP BY VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("SKD.SLAN_CD," ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("VVD.POL_CD," ).append("\n"); 
		query.append("SKD.VPS_ETB_DT ) TBL1," ).append("\n"); 
		query.append("MDM_LOCATION MDM_LOC," ).append("\n"); 
		query.append("( SELECT OFC_N3RD_LVL_CD REGION , OFC_N8TH_LVL_CD OFC_CD" ).append("\n"); 
		query.append("FROM ( SELECT OFC_KIND OFC_KND_CD , A.DEL , A.OFC_CD OFC_N8TH_LVL_CD , L1 OFC_LVL , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, A.OFC_CD, 8, B.OFC_CD) OFC_N7TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, A.OFC_CD, 7, B.OFC_CD, 8, C.OFC_CD) OFC_N6TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, A.OFC_CD, 6, B.OFC_CD, 7, C.OFC_CD, 8, D.OFC_CD) OFC_N5TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD, 5, B.OFC_CD, 6, C.OFC_CD, 7, D.OFC_CD, 8, E.OFC_CD) OFC_N4TH_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD, 5, C.OFC_CD, 6, D.OFC_CD, 7, E.OFC_CD, 8, F.OFC_CD) OFC_N3RD_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD, 5, D.OFC_CD, 6, E.OFC_CD, 7, F.OFC_CD, 8, G.OFC_CD) OFC_N2ND_LVL_CD , DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD, 5, E.OFC_CD, 6, F.OFC_CD, 7, G.OFC_CD, 8, H.OFC_CD) OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("FROM ( SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A , MDM_ORGANIZATION B , MDM_ORGANIZATION C , MDM_ORGANIZATION D , MDM_ORGANIZATION E , MDM_ORGANIZATION F , MDM_ORGANIZATION G , MDM_ORGANIZATION H" ).append("\n"); 
		query.append("WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("AND C.PRNT_OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("AND D.PRNT_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("AND E.PRNT_OFC_CD = F.OFC_CD(+)" ).append("\n"); 
		query.append("AND F.PRNT_OFC_CD = G.OFC_CD(+)" ).append("\n"); 
		query.append("AND G.PRNT_OFC_CD = H.OFC_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("AND OFC_N3RD_LVL_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("FROM ( SELECT OFC_CD , LOC_CD , PRNT_OFC_CD , DELT_FLG DEL , A.OFC_KND_CD OFC_KIND , LEVEL L1" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A START WITH A.OFC_CD = 'SELHO' CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("WHERE L1 = 3" ).append("\n"); 
		query.append("AND OFC_KIND = '2' )" ).append("\n"); 
		query.append("AND OFC_N6TH_LVL_CD IS NOT NULL ) OLA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     TBL1.POL_CD      = MDM_LOC.LOC_CD" ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("AND 	TBL1.BKG_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("#elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("AND 	MDM_LOC.EQ_CTRL_OFC_CD = OLA.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_rhq_gb} == 'BO')" ).append("\n"); 
		query.append("#if (${p_b_ofc_cd} != '')" ).append("\n"); 
		query.append("AND TBL1.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${p_rhq_gb} == 'PO')" ).append("\n"); 
		query.append("#if (${p_b_ofc_cd} != '')" ).append("\n"); 
		query.append("AND MDM_LOC.EQ_CTRL_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rhq} != '')" ).append("\n"); 
		query.append("AND	OLA.REGION = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}