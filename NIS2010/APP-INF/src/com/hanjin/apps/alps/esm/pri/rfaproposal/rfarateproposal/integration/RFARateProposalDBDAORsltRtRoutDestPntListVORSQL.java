/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtRoutDestPntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.29 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRtRoutDestPntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route Detail에서 DESTINATION에 해당함. 
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtRoutDestPntListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtRoutDestPntListVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , ROUT_SEQ" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_SEQ" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("     , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , PRC_PROG_STS_NM" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , SRC_INFO_NM" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , ACPT_USR_ID" ).append("\n"); 
		query.append("     , ACPT_OFC_CD" ).append("\n"); 
		query.append("     , ACPT_USR_NM" ).append("\n"); 
		query.append("     , ACPT_DT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , N1ST_ORD_REF" ).append("\n"); 
		query.append("     , N2ND_ORD_REF" ).append("\n"); 
		query.append("     , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , BASE_PORT_LIST" ).append("\n"); 
		query.append("	 , DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 1) FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 2) FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 3) OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 4) GROUP_NO" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 5) DR_20FT_AMT" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 6) RF_20FT_AMT" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 7) DG_20FT_AMT" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 8) DR_40FT_AMT" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 9) RF_40FT_AMT" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(DATA, '[^|]+', 1, 10) DG_40FT_AMT" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("      ,AMDT_SEQ" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,ROUT_SEQ" ).append("\n"); 
		query.append("      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      ,ROUT_PNT_SEQ" ).append("\n"); 
		query.append("      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("             ,'G'" ).append("\n"); 
		query.append("             ,(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("               WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                 AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ,'L'" ).append("\n"); 
		query.append("             ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                 AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("      ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = PRC_PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PRC_PROG_STS_NM" ).append("\n"); 
		query.append("      ,SRC_INFO_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02198'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SRC_INFO_NM" ).append("\n"); 
		query.append("      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("         WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = A.SVC_SCP_CD) AS EFF_DT" ).append("\n"); 
		query.append("      ,(SELECT CASE" ).append("\n"); 
		query.append("                 WHEN M.AMDT_SEQ = A.AMDT_SEQ THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 WHEN M.EFF_DT <= N.EXP_DT THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  TO_CHAR(N.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_MN M, PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("         WHERE M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND N.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE(@[amdt_seq], A.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = A.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append("      ,ACPT_USR_ID" ).append("\n"); 
		query.append("      ,ACPT_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID AND ROWNUM = 1) || ' / ' || A.ACPT_OFC_CD AS ACPT_USR_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ACPT_DT, 'YYYYMMDD') AS ACPT_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,FIRST_VALUE(DECODE(ROUT_PNT_LOC_TP_CD, 'G', 1, 'L', 2, 99)) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, ROUT_PNT_SEQ ORDER BY AMDT_SEQ) AS N1ST_ORD_REF" ).append("\n"); 
		query.append("      ,FIRST_VALUE(ROUT_PNT_LOC_DEF_CD) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, ROUT_PNT_SEQ ORDER BY AMDT_SEQ) AS N2ND_ORD_REF" ).append("\n"); 
		query.append("      ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("      ,BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("	  ,CY_DOR_RT_TP_CD DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("#if (${add_on_flag} == 'Y' )" ).append("\n"); 
		query.append("	, CASE WHEN CY_DOR_RT_TP_CD = 'D' THEN" ).append("\n"); 
		query.append("      PRI_ADDON_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC((SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("                                                           WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                                           AND SVC_SCP_CD = A.SVC_SCP_CD), SVC_SCP_CD, 'D', ROUT_PNT_LOC_DEF_CD, RCV_DE_TERM_CD, NULL, 'N')" ).append("\n"); 
		query.append("		ELSE '' END BASE_PORT_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, CASE WHEN CY_DOR_RT_TP_CD = 'D' THEN" ).append("\n"); 
		query.append("      PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRouteGroup_FNC((SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("                                                           WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                                           AND SVC_SCP_CD = A.SVC_SCP_CD), SVC_SCP_CD,'D', ROUT_PNT_LOC_DEF_CD, BSE_PORT_LOC_CD, RCV_DE_TERM_CD, PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("		ELSE '||||||||||' END DATA" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,PRI_FIC_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC((SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("                                                           WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                                           AND SVC_SCP_CD = A.SVC_SCP_CD), SVC_SCP_CD, ROUT_PNT_LOC_DEF_CD, RCV_DE_TERM_CD, NULL, 'N') AS BASE_PORT_LIST" ).append("\n"); 
		query.append("      ,PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICRouteGroup_FNC((SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("                                                           WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                                           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                                           AND SVC_SCP_CD = A.SVC_SCP_CD), SVC_SCP_CD, ROUT_PNT_LOC_DEF_CD, BSE_PORT_LOC_CD, RCV_DE_TERM_CD, PRC_TRSP_MOD_CD) AS DATA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("              ,ROUT_PNT_SEQ" ).append("\n"); 
		query.append("              ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("              ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("              ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("              ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("              ,SRC_INFO_CD" ).append("\n"); 
		query.append("              ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, ROUT_PNT_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("              ,ACPT_USR_ID" ).append("\n"); 
		query.append("              ,ACPT_OFC_CD" ).append("\n"); 
		query.append("              ,ACPT_DT" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("              ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("              ,BSE_PORT_LOC_CD AS BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("			  ,(SELECT T.DEST_CY_DOR_RT_TP_CD FROM  PRI_RP_SCP_RT_CMDT_ROUT T WHERE  T.PROP_NO =  PNT.PROP_NO AND T.AMDT_SEQ = PNT.AMDT_SEQ AND T.SVC_SCP_CD = PNT.SVC_SCP_CD AND T.CMDT_HDR_SEQ = PNT.CMDT_HDR_SEQ AND T.ROUT_SEQ = PNT.ROUT_SEQ) CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_PNT PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("               (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("               SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = 'D') A" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append(" ORDER BY N1ST_ORD_REF, N2ND_ORD_REF, ROUT_PNT_SEQ, AMDT_SEQ" ).append("\n"); 

	}
}