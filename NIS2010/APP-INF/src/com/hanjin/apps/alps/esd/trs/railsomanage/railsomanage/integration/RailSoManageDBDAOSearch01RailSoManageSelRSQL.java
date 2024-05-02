/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailSoManageDBDAOSearch01RailSoManageSelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("sdelNode",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	'I' TRSP_BND_CD," ).append("\n"); 
		query.append("    A.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("    C.SC_NO," ).append("\n"); 
		query.append("    A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("    A.POD_NOD_CD POD_NOD_CD," ).append("\n"); 
		query.append("    A.POL_NOD_CD POL_NOD_CD," ).append("\n"); 
		query.append("    A.POR_NOD_CD POR_NOD_CD," ).append("\n"); 
		query.append("    B.N1ST_NOD_CD FM_NOD_CD," ).append("\n"); 
		query.append("    DECODE(TRIM(NVL(B.N3RD_NOD_CD, '')), '', B.N2ND_NOD_CD, DECODE(TRIM(NVL(B.N4TH_NOD_CD,'')), '', B.N3RD_NOD_CD, B.N4TH_NOD_CD)) TO_NOD_CD, " ).append("\n"); 
		query.append("    '' IBD_IPI_LOCL_IND_CD," ).append("\n"); 
		query.append("    CSTMS_BL.CSTMS_LOC_CD IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT LOC.SCC_CD" ).append("\n"); 
		query.append("	  	FROM MDM_LOCATION	LOC" ).append("\n"); 
		query.append("	  	WHERE  SUBSTR(B.N1ST_NOD_CD, 1, 5) = LOC.LOC_CD" ).append("\n"); 
		query.append("	  	AND    LOC.CONTI_CD                = 'M'" ).append("\n"); 
		query.append("	) DEL_SCC_CD," ).append("\n"); 
		query.append("    A.DEL_NOD_CD DEL_NOD_CD," ).append("\n"); 
		query.append("	TO_CHAR( B.N1ST_NOD_PLN_DT, 'YYYYMMDD HH24:MI:SS') N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("	TO_CHAR( B.LST_NOD_PLN_DT, 'YYYYMMDD HH24:MI:SS') LST_NOD_PLN_DT," ).append("\n"); 
		query.append("    C.BKG_NO," ).append("\n"); 
		query.append("    C.BL_NO," ).append("\n"); 
		query.append("    DECODE(B.PCTL_IO_BND_CD, 'I', C.DE_TERM_CD, 'O', C.RCV_TERM_CD, '') BKG_RCVDE_TERM_CD,   " ).append("\n"); 
		query.append("    C.BKG_CGO_TP_CD CGO_TP_CD," ).append("\n"); 
		query.append("    '' BKG_SPE," ).append("\n"); 
		query.append("    '' SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("    C.USA_CSTMS_FILE_CD NVOCC_FILE_NO," ).append("\n"); 
		query.append("    '' IBD_NO," ).append("\n"); 
		query.append("    '' CNTR_SEAL_NO," ).append("\n"); 
		query.append("    '' CNTR_WGT," ).append("\n"); 
		query.append("    '' CMDT_NAME," ).append("\n"); 
		query.append("    (C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD) TRUNKVVD," ).append("\n"); 
		query.append("    C.SLAN_CD SLAN_CD," ).append("\n"); 
		query.append("    C.CMDT_CD," ).append("\n"); 
		query.append("    '' TRSP_SO_OFC_CTY_CD,   " ).append("\n"); 
		query.append("    '' CRE_USR_ID,           " ).append("\n"); 
		query.append("    '' UPD_USR_ID," ).append("\n"); 
		query.append("    B.INLND_ROUT_INV_BIL_PATT_CD RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("    A.COP_NO," ).append("\n"); 
		query.append("    B.COST_ACT_GRP_SEQ, " ).append("\n"); 
		query.append("    B.COST_ACT_GRP_CD ACT_GRP_CD," ).append("\n"); 
		query.append("    D.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("    D.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("    D.ROUT_SEQ," ).append("\n"); 
		query.append("    C.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    MST.ROUT_PLN_CD," ).append("\n"); 
		query.append("    MST.INLND_ROUT_RMK," ).append("\n"); 
		query.append("    DECODE(SUBSTR(B.COST_ACT_GRP_CD, 2, 1), 'Y', 'CY', 'T', 'CY', 'D', 'DR', '') TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    '' CUST_CNT_CD," ).append("\n"); 
		query.append("    '' CUST_SEQ," ).append("\n"); 
		query.append("	DENSE_RANK() OVER (PARTITION BY A.CNTR_NO, C.BKG_NO ORDER BY CT.ROUT_DTL_SEQ) ROUT_DTL_SEQ," ).append("\n"); 
		query.append("    '' SHPR_CUST_NM," ).append("\n"); 
		query.append("    '' CNEE_CUST_NM," ).append("\n"); 
		query.append("    '' NTFY_CUST_NM," ).append("\n"); 
		query.append("    '' EXPT," ).append("\n"); 
		query.append("    '' INTERCHANGE1_LOC," ).append("\n"); 
		query.append("    '' INTERCHANGE2_LOC," ).append("\n"); 
		query.append("    C.POR_CD," ).append("\n"); 
		query.append("    C.DEL_CD," ).append("\n"); 
		query.append("    B.INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("    '' RTR_DIV_CNT," ).append("\n"); 
		query.append("	TO_CHAR( DTL.ACT_DT, 'YYYYMMDD HH24:MI:SS') VD_DT," ).append("\n"); 
		query.append("    A.POD_NOD_CD TML_NOD_CD," ).append("\n"); 
		query.append("    '' HIGH_VAL_CGO_TP_CD," ).append("\n"); 
		query.append("    C.BLCK_STWG_CD," ).append("\n"); 
		query.append("    '' REF_NO," ).append("\n"); 
		query.append("    CT.LNK_ORG_NOD_CD," ).append("\n"); 
		query.append("    CT.LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("    CT.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    CT.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	SCE_COP_HDR				A," ).append("\n"); 
		query.append("    SCE_PLN_SO_LIST  		B," ).append("\n"); 
		query.append("    BKG_BOOKING				C," ).append("\n"); 
		query.append("    PRD_PROD_CTL_ACT_GRP_DTL D," ).append("\n"); 
		query.append("    PRD_INLND_ROUT_MST MST," ).append("\n"); 
		query.append("    PRD_INLND_ROUT_DTL CT," ).append("\n"); 
		query.append("    BKG_CSTMS_ADV_BL CSTMS_BL," ).append("\n"); 
		query.append("	SCE_COP_DTL DTL" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND   A.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("AND   DTL.ACT_CD IN ('FUVMUD', 'FUWMUD')" ).append("\n"); 
		query.append("AND   A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND   A.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND   B.COST_ACT_GRP_SEQ = D.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("AND   D.ROUT_ORG_NOD_CD = MST.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("AND   D.ROUT_DEST_NOD_CD = MST.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   D.ROUT_SEQ = MST.ROUT_SEQ" ).append("\n"); 
		query.append("AND   D.ROUT_ORG_NOD_CD  = CT.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   D.ROUT_DEST_NOD_CD = CT.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   D.ROUT_SEQ         = CT.ROUT_SEQ    " ).append("\n"); 
		query.append("AND   'RD'               = CT.TRSP_MOD_CD" ).append("\n"); 
		query.append("AND   C.BL_NO = CSTMS_BL.BL_NO (+)" ).append("\n"); 
		query.append("AND   DECODE(SUBSTR(C.DEL_CD,1,2), 'US', 'US', 'CA', 'CA', 'US') = CSTMS_BL.CNT_CD (+)" ).append("\n"); 
		query.append("AND   NVL(MST.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   A.COP_STS_CD||'' IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("AND   DECODE (A.MST_COP_NO, A.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("AND   B.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND   B.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND   B.CTRL_OFC_CD = 'PHXSA'" ).append("\n"); 
		query.append("AND   B.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   B.PCTL_COST_MOD_CD = 'C'" ).append("\n"); 
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
		query.append("	AND   A.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("" ).append("\n"); 
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

	}
}