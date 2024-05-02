/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.20 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unplaned S/O Candidate 선정
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmnodeyard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     CTRL_OFC_CD, COP_NO, EQ_NO, EQ_TPSZ_CD, COST_ACT_GRP_SEQ, COST_ACT_GRP_CD, VNDR_SEQ, TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("   , FM_NOD_CD, FM_NOD_YARD, TO_NOD_CD, TO_NOD_YARD, VIA_NOD_CD, VIA_NOD_YARD, DOR_NOD_CD, DOR_NOD_YARD" ).append("\n"); 
		query.append("   , TRSP_BND_CD, RAIL_CMB_THRU_TP_CD, CUST_CNT_CD, CUST_SEQ, SC_NO, RFA_NO, TRSP_SO_STS_CD, MST_LCL_CD" ).append("\n"); 
		query.append("   , FM_LOC_CONTI_CD, BKG_NO, BKG_RCVDE_TERM_CD, BL_NO, BKG_CGO_TP_CD, CGO_TP_CD" ).append("\n"); 
		query.append("   , TRUNKVVD, SLAN_CD, POR_CD, POL_CD, POD_CD, DEL_CD, CMDT_CD, TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("   , UPLN_SO_FLG, TRSP_SO_STS_NM, TRO_SEQ, TRO_SUB_SEQ" ).append("\n"); 
		query.append("   , TO_CHAR(NVL((SELECT  DECODE(AA.TRSP_COST_DTL_MOD_CD, 'CY', DECODE(NVL(ACT_STS_MAPG_CD,'XX'), 'OP', ACT_DT, ESTM_DT), ESTM_DT)" ).append("\n"); 
		query.append("                FROM   SCE_COP_DTL" ).append("\n"); 
		query.append("                WHERE  COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("                AND    ACT_CD LIKE '_'||NVL(AA.TRSP_BND_CD, 'T')||SUBSTR(SUBSTR(AA.COST_ACT_GRP_CD,3), 1, 1)||'_D_'" ).append("\n"); 
		query.append("                AND    NOD_CD = AA.N1ST_NOD_CD" ).append("\n"); 
		query.append("                AND    ROWNUM = 1), AA.N1ST_NOD_PLN_DT), 'YYYYMMDDHH24MISS') N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("   , DOR_ARR_DT" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("   SELECT   " ).append("\n"); 
		query.append("   NVL(@[ctrl_ofc_cd], B.CTRL_OFC_CD) CTRL_OFC_CD" ).append("\n"); 
		query.append(" , A.COP_NO                    " ).append("\n"); 
		query.append(" , NVL(A.CNTR_NO, ' ') EQ_NO " ).append("\n"); 
		query.append(" , A.CNTR_TPSZ_CD  AS EQ_TPSZ_CD            " ).append("\n"); 
		query.append(" , B.COST_ACT_GRP_SEQ          " ).append("\n"); 
		query.append(" , B.COST_ACT_GRP_CD " ).append("\n"); 
		query.append(" , B.N1ST_VNDR_SEQ AS VNDR_SEQ            " ).append("\n"); 
		query.append(" , 'TD' TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(" , B.N1ST_NOD_CD" ).append("\n"); 
		query.append(" , SUBSTR(B.N1ST_NOD_CD,1,5)  FM_NOD_CD " ).append("\n"); 
		query.append(" , SUBSTR(B.N1ST_NOD_CD,6)    FM_NOD_YARD " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') TO_NOD_CD    " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') TO_NOD_YARD  " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') VIA_NOD_CD   " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') VIA_NOD_YARD " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'NODE') DOR_NOD_CD   " ).append("\n"); 
		query.append(" , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, 'YARD') DOR_NOD_YARD " ).append("\n"); 
		query.append(" , B.PCTL_IO_BND_CD AS TRSP_BND_CD             " ).append("\n"); 
		query.append(" , B.INLND_ROUT_INV_BIL_PATT_CD  AS RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append(" , '' CUST_CNT_CD" ).append("\n"); 
		query.append(" , 0 CUST_SEQ" ).append("\n"); 
		query.append(" , C.SC_NO                       " ).append("\n"); 
		query.append(" , C.RFA_NO                      " ).append("\n"); 
		query.append(" , B.TRSP_SO_STS_CD " ).append("\n"); 
		query.append(" , DECODE(A.MST_COP_NO, A.COP_NO, 'P', 'X')   MST_LCL_CD" ).append("\n"); 
		query.append(" , @[ui_conti_cd] AS FM_LOC_CONTI_CD        " ).append("\n"); 
		query.append(" , A.BKG_NO                      " ).append("\n"); 
		query.append(" , B.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append(" , DECODE(B.PCTL_IO_BND_CD, 'I',C.DE_TERM_CD, 'O',C.RCV_TERM_CD, '')   BKG_RCVDE_TERM_CD " ).append("\n"); 
		query.append(" , C.BL_NO " ).append("\n"); 
		query.append(" , C.BKG_CGO_TP_CD     " ).append("\n"); 
		query.append(" , 'F' CGO_TP_CD     " ).append("\n"); 
		query.append(" , (C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD) TRUNKVVD " ).append("\n"); 
		query.append(" , C.SLAN_CD           " ).append("\n"); 
		query.append(" , C.POR_CD POR_CD     " ).append("\n"); 
		query.append(" , C.POL_CD POL_CD     " ).append("\n"); 
		query.append(" , C.POD_CD POD_CD     " ).append("\n"); 
		query.append(" , C.DEL_CD DEL_CD     " ).append("\n"); 
		query.append(" , C.CMDT_CD           " ).append("\n"); 
		query.append(" , B.DOR_ARR_DT        " ).append("\n"); 
		query.append("#if (${cydoor_div} == 'DR')" ).append("\n"); 
		query.append(" , DECODE(B.PCTL_COST_MOD_CD,'C','DR','Z','DR','DR') TRSP_COST_DTL_MOD_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" , DECODE(B.PCTL_COST_MOD_CD,'C','CY','Z','DR','') TRSP_COST_DTL_MOD_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , DECODE(B.PCTL_COST_MOD_CD, '', 'Y', '') UPLN_SO_FLG " ).append("\n"); 
		query.append(" , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00286',B.TRSP_SO_STS_CD)            TRSP_SO_STS_NM" ).append("\n"); 
		query.append("#if (${cydoor_div} == 'DR')" ).append("\n"); 
		query.append(" , SUBSTR(TRS_CYDOOR_COMM_PKG.GET_TRO_MAPG(A.COP_NO, B.PCTL_IO_BND_CD, @[ui_conti_cd]), 1, INSTR(TRS_CYDOOR_COMM_PKG.GET_TRO_MAPG(A.COP_NO, B.PCTL_IO_BND_CD, @[ui_conti_cd]), '$', 1, 1) - 1) AS TRO_SEQ" ).append("\n"); 
		query.append(" , SUBSTR(TRS_CYDOOR_COMM_PKG.GET_TRO_MAPG(A.COP_NO, B.PCTL_IO_BND_CD, @[ui_conti_cd]), INSTR(TRS_CYDOOR_COMM_PKG.GET_TRO_MAPG(A.COP_NO, B.PCTL_IO_BND_CD, @[ui_conti_cd]), '$', 1, 1) + 1) AS TRO_SUB_SEQ  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" , '' TRO_SEQ" ).append("\n"); 
		query.append(" , '' TRO_SUB_SEQ" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append(" FROM SCE_COP_HDR A " ).append("\n"); 
		query.append(", PRD_PROD_CTL_ACT_GRP_DTL B " ).append("\n"); 
		query.append(", BKG_BOOKING C " ).append("\n"); 
		query.append(" WHERE A.PCTL_NO=B.PCTL_NO" ).append("\n"); 
		query.append(" AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append(" AND B.PCTL_COST_MOD_CD = 'X' " ).append("\n"); 
		query.append("#if (${cydoor_div} != 'DR')" ).append("\n"); 
		query.append("AND A.CNTR_NO <> 'COMU0000000' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND B.COST_ACT_GRP_TP_CD  = 'N'" ).append("\n"); 
		query.append("-- From Node의 Location으로 조회" ).append("\n"); 
		query.append("#if (${frmnode} != '')" ).append("\n"); 
		query.append("    AND SUBSTR(B.N1ST_NOD_CD,1,5) = @[frmnode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- From Node의 Yard로 조회 " ).append("\n"); 
		query.append("#if (${frmnodeyard} != '')" ).append("\n"); 
		query.append("    AND SUBSTR(B.N1ST_NOD_CD,6) = @[frmnodeyard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Multi From Node로 조회" ).append("\n"); 
		query.append("#if ($arr_fmnode.size() > 0) " ).append("\n"); 
		query.append("    AND B.N1ST_NOD_CD in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_fmnode}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_fmnode.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Port로 조회 " ).append("\n"); 
		query.append("#if (${portio} == 'I')" ).append("\n"); 
		query.append("    AND C.POD_CD = @[portcd]" ).append("\n"); 
		query.append("#elseif (${portio} == 'O')" ).append("\n"); 
		query.append("    AND C.POL_CD = @[portcd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Booking no로 조회" ).append("\n"); 
		query.append("#if ($arr_bkgno.size() > 0) " ).append("\n"); 
		query.append("    AND A.BKG_NO in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_bkgno}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_bkgno.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- BL NO로 조회" ).append("\n"); 
		query.append("#if ($arr_billno.size() > 0) " ).append("\n"); 
		query.append("    AND C.BL_NO in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_billno}) " ).append("\n"); 
		query.append("      #if($velocityCount < $arr_billno.size()) " ).append("\n"); 
		query.append("        '$key', " ).append("\n"); 
		query.append("      #else " ).append("\n"); 
		query.append("        '$key' " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Container no로 조회" ).append("\n"); 
		query.append("#if ($arr_cntrno.size() > 0) " ).append("\n"); 
		query.append("    AND A.CNTR_NO in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_cntrno}) " ).append("\n"); 
		query.append("      #if($velocityCount < $arr_cntrno.size()) " ).append("\n"); 
		query.append("        '$key', " ).append("\n"); 
		query.append("      #else " ).append("\n"); 
		query.append("        '$key' " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Trunk VVD로 조회 " ).append("\n"); 
		query.append("#if ($arr_trunkvvd.size() > 0) " ).append("\n"); 
		query.append("    AND (C.VSL_CD,C.SKD_VOY_NO,C.SKD_DIR_CD) in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_trunkvvd}) " ).append("\n"); 
		query.append("      #if($velocityCount < $arr_trunkvvd.size()) " ).append("\n"); 
		query.append("        (SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))," ).append("\n"); 
		query.append("      #else " ).append("\n"); 
		query.append("        (SUBSTR('$key',1,4),SUBSTR('$key',5,4),SUBSTR('$key',9,1))" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND C.VSL_CD <> 'COXX'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Contract No로 조회 " ).append("\n"); 
		query.append("#if (${contract_no} != '' )" ).append("\n"); 
		query.append("    #if (${contract_tp_cd} == 'S' )" ).append("\n"); 
		query.append("        AND C.SC_NO IN (@[contract_no])" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND C.RFA_NO IN (@[contract_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ) AA WHERE 1=1" ).append("\n"); 
		query.append("#if (${cydoor_div} == 'DR')" ).append("\n"); 
		query.append("   	  AND ( (FM_LOC_CONTI_CD = 'M' AND TRSP_BND_CD = 'O' AND TRO_SEQ IS NOT NULL) " ).append("\n"); 
		query.append("         OR (FM_LOC_CONTI_CD = 'M' AND TRSP_BND_CD = 'I' AND EQ_NO <> 'COMU0000000')" ).append("\n"); 
		query.append("		 OR (FM_LOC_CONTI_CD = 'E' AND TRO_SEQ IS NOT NULL) " ).append("\n"); 
		query.append("		 OR (FM_LOC_CONTI_CD = 'A')" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   	  AND ( (FM_LOC_CONTI_CD = 'M' AND TRSP_BND_CD = 'O' AND TRO_SEQ IS NULL)" ).append("\n"); 
		query.append("         OR (FM_LOC_CONTI_CD = 'M' AND TRSP_BND_CD = 'I' AND EQ_NO <> 'COMU0000000')" ).append("\n"); 
		query.append("		 OR (FM_LOC_CONTI_CD = 'E' AND TRO_SEQ IS NULL) " ).append("\n"); 
		query.append("		 OR (FM_LOC_CONTI_CD = 'A')" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($arr_ecc_cd.size() > 0)" ).append("\n"); 
		query.append("      AND CASE" ).append("\n"); 
		query.append("            WHEN AA.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("            THEN (" ).append("\n"); 
		query.append("                  SELECT ECC_CD" ).append("\n"); 
		query.append("                    FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                   WHERE SCC_CD = (SELECT SCC_CD" ).append("\n"); 
		query.append("                                     FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                    WHERE LOC_CD = AA.TO_NOD_CD)" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE (" ).append("\n"); 
		query.append("                  SELECT ECC_CD" ).append("\n"); 
		query.append("                    FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                   WHERE SCC_CD = (SELECT SCC_CD" ).append("\n"); 
		query.append("                                     FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                    WHERE LOC_CD = AA.FM_NOD_CD)" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("          END IN (" ).append("\n"); 
		query.append("          #foreach($code IN ${arr_ecc_cd})" ).append("\n"); 
		query.append("              #if($velocityCount == 1)" ).append("\n"); 
		query.append("                   '$code'" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                  ,'$code'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($eq_tpsz_cd.size() > 0)" ).append("\n"); 
		query.append("AND AA.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("    #foreach($code IN ${eq_tpsz_cd})" ).append("\n"); 
		query.append("        #if($velocityCount == 1)" ).append("\n"); 
		query.append("             '$code'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            ,'$code'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}