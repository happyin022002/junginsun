/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchArbitraryRevRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.07 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchArbitraryRevRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO 구간에 대해 RFA의 Arbitrary 요율을 조회한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchArbitraryRevRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mode_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchArbitraryRevRSQLRSQL").append("\n"); 
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
		query.append("SELECT ARB.CURR_CD GLINE_CURR_CD, " ).append("\n"); 
		query.append("       ARB.FNL_FRT_RT_AMT GLINE_REV_AMT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG ARB," ).append("\n"); 
		query.append("     (SELECT RS.PROP_NO, RS.AMDT_SEQ, BK.SVC_SCP_CD, " ).append("\n"); 
		query.append("             DECODE(@[io_bnd_cd], 'O',BK.RCV_TERM_CD, 'I',BK.DE_TERM_CD) TERM_CD," ).append("\n"); 
		query.append("             BK.AGMT_ACT_CNT_CD, BK.AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BK, BKG_RATE BR, PRI_RP_HDR RH, PRI_RP_MN RM, PRI_RP_SCP_MN RS" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("        AND RH.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("        AND RM.PROP_NO = RH.PROP_NO" ).append("\n"); 
		query.append("        AND RM.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("        AND RS.PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("        AND RS.AMDT_SEQ = RM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND RS.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND BR.RT_APLY_DT BETWEEN RS.EFF_DT AND RS.EXP_DT) CON" ).append("\n"); 
		query.append("WHERE ARB.PROP_NO = CON.PROP_NO" ).append("\n"); 
		query.append("AND ARB.AMDT_SEQ = CON.AMDT_SEQ" ).append("\n"); 
		query.append("AND ARB.SVC_SCP_CD = CON.SVC_SCP_CD" ).append("\n"); 
		query.append("AND ARB.ADD_CHG_TP_CD = 'A'  " ).append("\n"); 
		query.append("AND ARB.ORG_DEST_TP_CD = DECODE(@[io_bnd_cd], 'O','O','I','D')  " ).append("\n"); 
		query.append("AND ARB.SRC_INFO_CD <> 'AD'  " ).append("\n"); 
		query.append("AND (ARB.CUST_CNT_CD IS NULL  " ).append("\n"); 
		query.append("     OR (ARB.CUST_CNT_CD = CON.AGMT_ACT_CNT_CD  AND ARB.CUST_SEQ = CON.AGMT_ACT_CUST_SEQ))" ).append("\n"); 
		query.append("AND (ARB.RAT_UT_CD IN ( 'BX', @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("    OR  (" ).append("\n"); 
		query.append("            ARB.RAT_UT_CD  IN ( '20', '40', 'HC', '45', '53' )  " ).append("\n"); 
		query.append("        AND ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = ARB.RAT_UT_CD ) = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("        )  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND NVL(ARB.PRC_CGO_TP_CD, '*') IN ('*', DECODE(@[dg_flag],'Y','DG'), DECODE(@[rf_flag],'Y','RF'), " ).append("\n"); 
		query.append("                                    DECODE(@[awk_flag],'Y','AK'),DECODE(@[dg_flag]||@[rf_flag]||@[awk_flag],'NNN','DR'))" ).append("\n"); 
		query.append("AND (ARB.PRC_TRSP_MOD_CD IS NULL  " ).append("\n"); 
		query.append("    OR @[trsp_mode_cd]   IS NULL" ).append("\n"); 
		query.append("    OR ARB.PRC_TRSP_MOD_CD = @[trsp_mode_cd]" ).append("\n"); 
		query.append("    OR (ARB.PRC_TRSP_MOD_CD IN ('R','A') AND @[trsp_mode_cd] IN ('R','A'))  " ).append("\n"); 
		query.append("    OR (ARB.PRC_TRSP_MOD_CD IN ('E','T') AND @[trsp_mode_cd] IN ('E','T'))  " ).append("\n"); 
		query.append("    OR (ARB.PRC_TRSP_MOD_CD IN ('U','T') AND @[trsp_mode_cd] IN ('U','T')))  " ).append("\n"); 
		query.append("#if (${multi_rev} != 'Y') " ).append("\n"); 
		query.append("	AND NVL(ARB.RCV_DE_TERM_CD, CON.TERM_CD) = CON.TERM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (ARB.ROUT_PNT_LOC_TP_CD, ARB.ROUT_PNT_LOC_DEF_CD) " ).append("\n"); 
		query.append("    IN (SELECT  'L', @[pnt_loc_cd]" ).append("\n"); 
		query.append("         FROM    DUAL  " ).append("\n"); 
		query.append("         UNION ALL  " ).append("\n"); 
		query.append("         SELECT  'G', G.PRC_GRP_LOC_CD  " ).append("\n"); 
		query.append("         FROM  PRI_RP_SCP_GRP_LOC G ,PRI_RP_SCP_GRP_LOC_DTL  D" ).append("\n"); 
		query.append("         WHERE D.PROP_NO = G.PROP_NO" ).append("\n"); 
		query.append("         AND D.AMDT_SEQ = G.AMDT_SEQ" ).append("\n"); 
		query.append("         AND D.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND D.GRP_LOC_SEQ = G.GRP_LOC_SEQ" ).append("\n"); 
		query.append("         AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("         AND G.PROP_NO = CON.PROP_NO" ).append("\n"); 
		query.append("         AND G.AMDT_SEQ = CON.AMDT_SEQ" ).append("\n"); 
		query.append("         AND G.SVC_SCP_CD = CON.SVC_SCP_CD " ).append("\n"); 
		query.append("         AND D.LOC_CD = @[pnt_loc_cd])" ).append("\n"); 
		query.append("AND (ARB.BSE_PORT_TP_CD, ARB.BSE_PORT_DEF_CD)  " ).append("\n"); 
		query.append("IN (SELECT  'L', @[bse_port_loc_cd]" ).append("\n"); 
		query.append("         FROM    DUAL  " ).append("\n"); 
		query.append("         UNION ALL  " ).append("\n"); 
		query.append("         SELECT  'G', G.PRC_GRP_LOC_CD  " ).append("\n"); 
		query.append("         FROM  PRI_RP_SCP_GRP_LOC G ,PRI_RP_SCP_GRP_LOC_DTL  D" ).append("\n"); 
		query.append("         WHERE D.PROP_NO = G.PROP_NO" ).append("\n"); 
		query.append("         AND D.AMDT_SEQ = G.AMDT_SEQ" ).append("\n"); 
		query.append("         AND D.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND D.GRP_LOC_SEQ = G.GRP_LOC_SEQ" ).append("\n"); 
		query.append("         AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("         AND G.PROP_NO = CON.PROP_NO" ).append("\n"); 
		query.append("         AND G.AMDT_SEQ = CON.AMDT_SEQ" ).append("\n"); 
		query.append("         AND G.SVC_SCP_CD = CON.SVC_SCP_CD " ).append("\n"); 
		query.append("         AND D.LOC_CD = @[bse_port_loc_cd])" ).append("\n"); 

	}
}