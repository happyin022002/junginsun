/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOCheckTRIRateDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOCheckTRIRateDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRI Rate 중복된 데이터가 있는지 점검한다.
	  * </pre>
	  */
	public TRIProposalDBDAOCheckTRIRateDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_dest_rout_pnt_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_dest_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_org_rout_pnt_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_action",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_org_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOCheckTRIRateDupRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[srch_action], '906', SUBSTR(A.TRI_NO, 1, 6) || '-' || SUBSTR(A.TRI_NO, 7, 4) || '-' || SUBSTR(A.TRI_NO, 11, 3), A.TRI_PROP_NO) AS TRI_PROP_NO" ).append("\n"); 
		query.append("  FROM PRI_TRI_MN A" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD || RCV_DE_TERM_CD || PRC_TRSP_MOD_CD, '|')) AS ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO, MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, '|')) AS ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO, MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, '|')) AS ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD || RCV_DE_TERM_CD || PRC_TRSP_MOD_CD, '|')) AS ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("      ,(SELECT T.TRI_PROP_NO, T.AMDT_SEQ, T.EFF_DT, T.EXP_DT, T.RAT_UT_CD, T.PRC_CGO_TP_CD, T.CURR_CD, T.PROP_STS_CD" ).append("\n"); 
		query.append("          FROM PRI_TRI_RT T) F" ).append("\n"); 
		query.append(" WHERE A.TRI_PROP_NO = B.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = C.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = D.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = E.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = F.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND A.TRF_PFX_CD = @[srch_trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO = @[srch_trf_no]" ).append("\n"); 
		query.append("   AND (@[srch_tri_prop_no] IS NULL OR A.TRI_PROP_NO <> @[srch_tri_prop_no])" ).append("\n"); 
		query.append("   AND A.CMDT_CD = @[srch_cmdt_cd]" ).append("\n"); 
		query.append("   AND B.ROUT_PNT_LOC_CD = @[srch_org_rout_pnt_loc_nm]" ).append("\n"); 
		query.append("   AND ((@[srch_org_rout_via_port_nm] IS NULL AND C.ROUT_VIA_PORT_CD IS NULL) OR C.ROUT_VIA_PORT_CD = @[srch_org_rout_via_port_nm])" ).append("\n"); 
		query.append("   AND ((@[srch_dest_rout_via_port_nm] IS NULL AND D.ROUT_VIA_PORT_CD IS NULL) OR D.ROUT_VIA_PORT_CD = @[srch_dest_rout_via_port_nm])" ).append("\n"); 
		query.append("   AND E.ROUT_PNT_LOC_CD = @[srch_dest_rout_pnt_loc_nm]" ).append("\n"); 
		query.append("   AND F.RAT_UT_CD = @[srch_rat_ut_cd]" ).append("\n"); 
		query.append("   AND F.PRC_CGO_TP_CD = @[srch_prc_cgo_tp_cd]" ).append("\n"); 
		query.append("   AND (F.EFF_DT BETWEEN TO_DATE(@[srch_eff_dt], 'YYYY-MM-DD') AND TO_DATE(@[srch_exp_dt], 'YYYY-MM-DD') OR" ).append("\n"); 
		query.append("       F.EXP_DT BETWEEN TO_DATE(@[srch_eff_dt], 'YYYY-MM-DD') AND TO_DATE(@[srch_exp_dt], 'YYYY-MM-DD') OR" ).append("\n"); 
		query.append("       (F.EFF_DT <= TO_DATE(@[srch_eff_dt], 'YYYY-MM-DD') AND F.EXP_DT >= TO_DATE(@[srch_exp_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("   AND ((@[srch_action] = '2' AND F.PROP_STS_CD = 'F') OR (@[srch_action] = '904' AND F.PROP_STS_CD <> 'I') OR (@[srch_action] = '906' AND F.PRC_CGO_TP_CD <> 'AK' AND F.PRC_CGO_TP_CD <> 'BB' AND A.TRI_NO IS NOT NULL))" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}