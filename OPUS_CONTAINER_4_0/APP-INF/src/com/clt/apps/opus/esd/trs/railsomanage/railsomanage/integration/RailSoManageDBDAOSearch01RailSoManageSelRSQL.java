/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailSoManageDBDAOSearch01RailSoManageSelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch01RailSoManageSelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail I/B SO 대상 추가 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch01RailSoManageSelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stoLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unplanned",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdelNode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanToDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanFromDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfromLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podNode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvisIndFlg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch01RailSoManageSelRSQL").append("\n"); 
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
		query.append("SELECT 'I' TRSP_BND_CD" ).append("\n"); 
		query.append("      ,A.CNTR_NO EQ_NO" ).append("\n"); 
		query.append("      ,C.SC_NO" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.POD_NOD_CD POD_NOD_CD" ).append("\n"); 
		query.append("      ,A.POL_NOD_CD POL_NOD_CD" ).append("\n"); 
		query.append("      ,A.POR_NOD_CD POR_NOD_CD" ).append("\n"); 
		query.append("      ,B.N1ST_NOD_CD FM_NOD_CD" ).append("\n"); 
		query.append("      ,DECODE(TRIM(NVL(B.N3RD_NOD_CD, '')), '', B.N2ND_NOD_CD, DECODE(TRIM(NVL(B.N4TH_NOD_CD, '')), '', B.N3RD_NOD_CD, B.N4TH_NOD_CD)) TO_NOD_CD" ).append("\n"); 
		query.append("      ,'' IBD_IPI_LOCL_IND_CD" ).append("\n"); 
		query.append("      ,CSTMS_BL.CSTMS_LOC_CD IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("      ,(SELECT LOC.SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = SUBSTR(A.DEL_NOD_CD, 1, 5) AND LOC.CONTI_CD = 'M') DEL_SCC_CD" ).append("\n"); 
		query.append("      ,A.DEL_NOD_CD DEL_NOD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(B.N1ST_NOD_PLN_DT, 'YYYYMMDD HH24:MI:SS') N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(B.LST_NOD_PLN_DT, 'YYYYMMDD HH24:MI:SS') LST_NOD_PLN_DT" ).append("\n"); 
		query.append("      ,C.BKG_NO" ).append("\n"); 
		query.append("      ,C.BL_NO" ).append("\n"); 
		query.append("      ,DECODE(B.PCTL_IO_BND_CD, 'I', C.DE_TERM_CD, 'O', C.RCV_TERM_CD, '') BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("      ,C.BKG_CGO_TP_CD CGO_TP_CD" ).append("\n"); 
		query.append("      ,'' BKG_SPE" ).append("\n"); 
		query.append("      ,'' SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,C.USA_CSTMS_FILE_CD NVOCC_FILE_NO" ).append("\n"); 
		query.append("      ,'' IBD_NO" ).append("\n"); 
		query.append("      ,'' CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,'' CNTR_WGT" ).append("\n"); 
		query.append("      ,'' CMDT_NAME" ).append("\n"); 
		query.append("      ,(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD) TRUNKVVD" ).append("\n"); 
		query.append("      ,C.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("      ,C.CMDT_CD" ).append("\n"); 
		query.append("      ,'' TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,'' CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.INLND_ROUT_INV_BIL_PATT_CD RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("      ,A.COP_NO" ).append("\n"); 
		query.append("      ,B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      ,B.COST_ACT_GRP_CD ACT_GRP_CD" ).append("\n"); 
		query.append("      ,D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("      ,D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("      ,D.ROUT_SEQ" ).append("\n"); 
		query.append("      ,C.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,MST.ROUT_PLN_CD" ).append("\n"); 
		query.append("      ,MST.INLND_ROUT_RMK" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(B.COST_ACT_GRP_CD, 2, 1), 'Y', 'CY', 'T', 'CY', 'D', 'DR', '') TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,'' CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' CUST_SEQ" ).append("\n"); 
		query.append("      ,'' ROUT_DTL_SEQ" ).append("\n"); 
		query.append("      ,'' SHPR_CUST_NM" ).append("\n"); 
		query.append("      ,'' CNEE_CUST_NM" ).append("\n"); 
		query.append("      ,'' NTFY_CUST_NM" ).append("\n"); 
		query.append("      ,'' EXPT" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(B.INLND_ROUT_INV_BIL_PATT_CD, 2, 1), '2', CT.LNK_ORG_NOD_CD_2, '3', CT.LNK_ORG_NOD_CD_2) INTERCHANGE1_LOC" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(B.INLND_ROUT_INV_BIL_PATT_CD, 2, 1), '3', CT.LNK_ORG_NOD_CD_3) INTERCHANGE2_LOC" ).append("\n"); 
		query.append("      ,C.POR_CD" ).append("\n"); 
		query.append("      ,C.DEL_CD" ).append("\n"); 
		query.append("      ,B.INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append("	  ,(SELECT TO_CHAR(MAX(DTL.ACT_DT), 'YYYYMMDD HH24:MI:SS') FROM SCE_COP_DTL DTL WHERE DTL.COP_NO = A.COP_NO AND DTL.ACT_CD IN ('FUVMUD', 'FUWMUD')) VD_DT" ).append("\n"); 
		query.append("      ,A.POD_NOD_CD TML_NOD_CD" ).append("\n"); 
		query.append("      ,'' HIGH_VAL_CGO_TP_CD" ).append("\n"); 
		query.append("      ,C.BLCK_STWG_CD" ).append("\n"); 
		query.append("      ,'' REF_NO" ).append("\n"); 
		query.append("      ,'' RTR_DIV_CNT" ).append("\n"); 
		query.append("      ,'' LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("      ,'' LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("      ,'' TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,'' TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,'' VNDR_SEQ" ).append("\n"); 
		query.append("  FROM SCE_COP_HDR              A" ).append("\n"); 
		query.append("      ,SCE_PLN_SO_LIST          B" ).append("\n"); 
		query.append("      ,BKG_BOOKING              C" ).append("\n"); 
		query.append("      ,PRD_PROD_CTL_ACT_GRP_DTL D" ).append("\n"); 
		query.append("      ,PRD_INLND_ROUT_MST       MST" ).append("\n"); 
		query.append("      ,(SELECT ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("              ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,MAX(LNK_ORG_NOD_CD_1) LNK_ORG_NOD_CD_1" ).append("\n"); 
		query.append("              ,MAX(LNK_DEST_NOD_CD_1) LNK_DEST_NOD_CD_1" ).append("\n"); 
		query.append("              ,MAX(LNK_ORG_NOD_CD_2) LNK_ORG_NOD_CD_2" ).append("\n"); 
		query.append("              ,MAX(LNK_DEST_NOD_CD_2) LNK_DEST_NOD_CD_2" ).append("\n"); 
		query.append("              ,MAX(LNK_ORG_NOD_CD_3) LNK_ORG_NOD_CD_3" ).append("\n"); 
		query.append("              ,MAX(LNK_DEST_NOD_CD_3) LNK_DEST_NOD_CD_3" ).append("\n"); 
		query.append("          FROM (SELECT ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                      ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 1, LNK_ORG_NOD_CD) LNK_ORG_NOD_CD_1" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 1, LNK_DEST_NOD_CD) LNK_DEST_NOD_CD_1" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 2, LNK_ORG_NOD_CD) LNK_ORG_NOD_CD_2" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 2, LNK_DEST_NOD_CD) LNK_DEST_NOD_CD_2" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 3, LNK_ORG_NOD_CD) LNK_ORG_NOD_CD_3" ).append("\n"); 
		query.append("                      ,DECODE(ROUT_DTL_SEQ, 3, LNK_DEST_NOD_CD) LNK_DEST_NOD_CD_3" ).append("\n"); 
		query.append("                  FROM (SELECT O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                              ,O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                              ,O.ROUT_SEQ" ).append("\n"); 
		query.append("                              ,O.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("                              ,O.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("                              ,RANK() OVER(PARTITION BY O.ROUT_ORG_NOD_CD, O.ROUT_DEST_NOD_CD, O.ROUT_SEQ ORDER BY O.ROUT_DTL_SEQ) ROUT_DTL_SEQ" ).append("\n"); 
		query.append("                          FROM PRD_INLND_ROUT_DTL O, PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("                         WHERE O.ROUT_ORG_NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                         AND O.ROUT_DEST_NOD_CD = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                         AND O.ROUT_SEQ = M.ROUT_SEQ" ).append("\n"); 
		query.append("                         AND O.TRSP_MOD_CD = 'RD' )) G" ).append("\n"); 
		query.append("         GROUP BY ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                 ,ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                 ,ROUT_SEQ) CT" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL CSTMS_BL" ).append("\n"); 
		query.append(" WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("   AND B.COST_ACT_GRP_SEQ = D.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("   AND D.ROUT_ORG_NOD_CD = MST.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("   AND D.ROUT_DEST_NOD_CD = MST.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND MST.ROUT_ORG_NOD_CD = CT.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("   AND MST.ROUT_DEST_NOD_CD = CT.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("   AND MST.ROUT_SEQ = CT.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND D.ROUT_SEQ = MST.ROUT_SEQ" ).append("\n"); 
		query.append("   AND C.BL_NO = CSTMS_BL.BL_NO(+)" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(C.DEL_CD, 1, 2), 'US', 'US', 'CA', 'CA', 'US') = CSTMS_BL.CNT_CD(+)" ).append("\n"); 
		query.append("   AND NVL(MST.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND A.COP_STS_CD || '' IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("   AND DECODE(A.MST_COP_NO, A.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("   AND B.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("   AND B.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("   AND B.TRSP_SO_STS_CD = DECODE(NVL(@[unplanned], 'N'), 'Y', 'F', 'P')" ).append("\n"); 
		query.append("   AND B.CTRL_OFC_CD    = DECODE(NVL(@[unplanned], 'N'), 'Y', B.CTRL_OFC_CD, @[sctrlOfcCd])" ).append("\n"); 
		query.append("   AND B.PCTL_COST_MOD_CD = 'C'" ).append("\n"); 
		query.append("   AND NVL(MST.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND B.INLND_ROUT_INV_BIL_PATT_CD IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($vvd.size() > 0)" ).append("\n"); 
		query.append("	AND ((C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${vvd})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			, ( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkg.size() > 0)" ).append("\n"); 
		query.append("	AND C.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${bkg})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bl.size() > 0)" ).append("\n"); 
		query.append("	AND C.BL_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${bl})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($cntr.size() > 0)" ).append("\n"); 
		query.append("	AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($scNo.size() > 0)" ).append("\n"); 
		query.append("	AND C.SC_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${scNo})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND   A.CNTR_NO <> 'COMU0000000' " ).append("\n"); 
		query.append("#if(${selCustoms} == 'LOC')" ).append("\n"); 
		query.append("	AND C.POD_CD = CSTMS_BL.CSTMS_LOC_CD" ).append("\n"); 
		query.append("#elseif(${selCustoms} == 'WIT')" ).append("\n"); 
		query.append("	AND C.POD_CD <> NVL(CSTMS_BL.CSTMS_LOC_CD, '0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${splanFromDate} != '' && ${splanToDate} != '')" ).append("\n"); 
		query.append("	AND B.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[splanFromDate], 'YYYYMMDD') AND TO_DATE(@[splanToDate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sfromLocationCd} != '')" ).append("\n"); 
		query.append("	AND B.N1ST_NOD_CD LIKE @[sfromLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${stoLocationCd} != '')" ).append("\n"); 
		query.append("	AND DECODE(TRIM(NVL(B.N3RD_NOD_CD, '')), '', B.N2ND_NOD_CD, DECODE(TRIM(NVL(B.N4TH_NOD_CD,'')), '', B.N3RD_NOD_CD, B.N4TH_NOD_CD)) LIKE @[stoLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sdelNode} != '')" ).append("\n"); 
		query.append("	AND A.DEL_NOD_CD LIKE @[sdelNode]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${podNode} != '')" ).append("\n"); 
		query.append("	AND A.POD_NOD_CD LIKE @[podNode]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                AND ORG_COST_ACT_GRP_SEQ = B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                AND NVL(UPLN_SO_FLG,'N') = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	AND C.VSL_CD <> 'COXX'" ).append("\n"); 
		query.append("	AND NVL(B.RVIS_IND_FLG, 'N') = NVL(@[rvisIndFlg], 'N')" ).append("\n"); 

	}
}