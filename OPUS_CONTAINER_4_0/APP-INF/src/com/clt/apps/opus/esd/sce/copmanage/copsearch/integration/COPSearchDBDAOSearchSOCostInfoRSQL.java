/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : COPSearchDBDAOSearchSOCostInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.08 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchSOCostInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSOCostInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchSOCostInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchSOCostInfoRSQL").append("\n"); 
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
		query.append("SELECT aa.*, aa.so_ofc||aa.so_seq so_num" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("     ( SELECT a.cop_no " ).append("\n"); 
		query.append("            , a.cost_act_grp_seq " ).append("\n"); 
		query.append("            , a.ctrl_ofc_cd " ).append("\n"); 
		query.append("			, decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_ofc_cty_cd) so_ofc " ).append("\n"); 
		query.append("            , d.cost_act_grp_nm cost_act_grp_nm " ).append("\n"); 
		query.append("            , DECODE(A.TRSP_SO_STS_CD,'I', H.VNDR_LGL_ENG_NM, C.VNDR_ABBR_NM) vndr_abbr_nm" ).append("\n"); 
		query.append("            , commcode_pkg.get_comdtl_name_fnc('CD00275', a.trsp_so_sts_cd) trsp_so_sts " ).append("\n"); 
		query.append("            , decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_seq) so_seq " ).append("\n"); 
		query.append("            , " ).append("\n"); 
		query.append("			  CASE WHEN A.TRSP_SO_STS_CD IN ('N', 'D', 'P') THEN ' - ' ELSE (" ).append("\n"); 
		query.append("			      CASE WHEN e.trsp_bnd_cd = 'O' " ).append("\n"); 
		query.append("    	               THEN e.fm_nod_cd||' - ' ||DECODE(NVL(e.dor_nod_cd, ''), '', '', e.dor_nod_cd||' - ')" ).append("\n"); 
		query.append("        	                ||DECODE(NVL(e.via_nod_cd, ''), '', '', e.via_nod_cd||' - ')||e.to_nod_cd " ).append("\n"); 
		query.append("            	       ELSE e.fm_nod_cd||' - ' ||DECODE(NVL(e.via_nod_cd, ''), '', '', e.via_nod_cd||' - ')" ).append("\n"); 
		query.append("                	        ||DECODE(NVL(e.dor_nod_cd, ''), '', '', e.dor_nod_cd||' - ')||e.to_nod_cd " ).append("\n"); 
		query.append("	              END " ).append("\n"); 
		query.append("			  ) END AS fm_to" ).append("\n"); 
		query.append("            , CASE WHEN a.trsp_so_sts_cd ='N' then to_char(a.delt_dt, 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("                   ELSE TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') " ).append("\n"); 
		query.append("              END AS so_dt" ).append("\n"); 
		query.append("            , CASE WHEN a.trsp_so_sts_cd ='N' THEN a.delt_usr_id ELSE e.cre_usr_id END user_id" ).append("\n"); 
		query.append("            , DECODE(A.TRSP_SO_STS_CD, 'I', g.intl_phn_no||'-'||g.phn_no, b.intl_phn_no||'-'||b.phn_no) sp_h_no" ).append("\n"); 
		query.append("            , e.inter_rmk so_rmk1" ).append("\n"); 
		query.append("            , e.inv_rmk so_rmk2" ).append("\n"); 
		query.append("            , e.spcl_instr_rmk so_rmk3" ).append("\n"); 
		query.append("            , e.trsp_wo_ofc_cty_cd||e.trsp_wo_seq wo_no" ).append("\n"); 
		query.append("            , to_char(f.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') wo_dt" ).append("\n"); 
		query.append("			, row_number() over (partition by a.cop_no, a.cost_act_grp_seq order by" ).append("\n"); 
		query.append("                CASE WHEN a.trsp_so_sts_cd ='N' then to_char(a.delt_dt, 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS') " ).append("\n"); 
		query.append("                END desc ) mx_knt" ).append("\n"); 
		query.append("        	, NULL RAIL_VNDR_NM" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_SNT_DT_HMS" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_RCV_RSLT_CD" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_RCV_RSLT_DT" ).append("\n"); 
		query.append("        	, NULL BIL_EDI_RCV_RSLT_DT_HMS" ).append("\n"); 
		query.append("        	, NULL CXL_RQST_RJCT_RSN" ).append("\n"); 
		query.append("        	, NULL WBL_NO" ).append("\n"); 
		query.append("			, 'N' RAIL_FLG" ).append("\n"); 
		query.append("            , A.DELT_USR_ID" ).append("\n"); 
		query.append("            , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', A.DELT_DT, A.CTRL_OFC_CD), 'YYYY-MM-DD HH24:MI:SS') AS DELT_DT" ).append("\n"); 
		query.append("        FROM  sce_pln_so_list a" ).append("\n"); 
		query.append("             ,mdm_vndr_cntc_pnt b" ).append("\n"); 
		query.append("             ,mdm_vendor c" ).append("\n"); 
		query.append("             ,prd_cost_act_grp d" ).append("\n"); 
		query.append("             ,trs_trsp_svc_ord e" ).append("\n"); 
		query.append("             ,trs_trsp_wrk_ord f" ).append("\n"); 
		query.append("             ,mdm_vndr_cntc_pnt g" ).append("\n"); 
		query.append("             ,mdm_vendor h" ).append("\n"); 
		query.append("       WHERE  a.cost_act_grp_cd = d.cost_act_grp_cd" ).append("\n"); 
		query.append("         AND  a.n1st_vndr_seq = c.vndr_seq (+)" ).append("\n"); 
		query.append("         AND  a.n1st_vndr_seq = b.vndr_seq (+)" ).append("\n"); 
		query.append("         AND  e.VNDR_SEQ = h.vndr_seq (+)" ).append("\n"); 
		query.append("         AND  e.VNDR_SEQ = g.vndr_seq (+)" ).append("\n"); 
		query.append("         AND  b.prmry_chk_flg (+) = 'Y'" ).append("\n"); 
		query.append("         AND  b.phn_no (+) IS NOT NULL" ).append("\n"); 
		query.append("         AND  a.cop_no = @[cop_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND  a.cop_no = e.cop_no(+)  " ).append("\n"); 
		query.append("         AND a.cost_act_grp_seq = e.cost_act_grp_seq (+)" ).append("\n"); 
		query.append("         AND  NVL(a.trsp_so_sts_cd, 'U') != 'U'" ).append("\n"); 
		query.append("         AND  e.trsp_wo_ofc_cty_cd = f.trsp_wo_ofc_cty_cd(+)" ).append("\n"); 
		query.append("         AND  e.trsp_wo_seq = f.trsp_wo_seq(+)" ).append("\n"); 
		query.append("         AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("         AND A.INLND_ROUT_INV_BIL_PATT_CD IS NULL" ).append("\n"); 
		query.append("       UNION" ).append("\n"); 
		query.append("		SELECT    COP_NO" ).append("\n"); 
		query.append("				, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("				, CTRL_OFC_CD" ).append("\n"); 
		query.append("				, SO_OFC" ).append("\n"); 
		query.append("				, COST_ACT_GRP_NM" ).append("\n"); 
		query.append("				, VNDR_ABBR_NM" ).append("\n"); 
		query.append("				, TRSP_SO_STS" ).append("\n"); 
		query.append("				, SO_SEQ" ).append("\n"); 
		query.append("				, FM_TO" ).append("\n"); 
		query.append("				, SO_DT" ).append("\n"); 
		query.append("				, USER_ID" ).append("\n"); 
		query.append("				, SP_H_NO" ).append("\n"); 
		query.append("				, SO_RMK1" ).append("\n"); 
		query.append("				, SO_RMK2" ).append("\n"); 
		query.append("				, SO_RMK3" ).append("\n"); 
		query.append("				, WO_NO" ).append("\n"); 
		query.append("				, WO_DT" ).append("\n"); 
		query.append("				, MX_KNT" ).append("\n"); 
		query.append("				, RAIL_VNDR_NM" ).append("\n"); 
		query.append("				, BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("				, BIL_EDI_SNT_DT_HMS" ).append("\n"); 
		query.append("				, BIL_EDI_RCV_RSLT_CD" ).append("\n"); 
		query.append("				, BIL_EDI_RCV_RSLT_DT" ).append("\n"); 
		query.append("				, BIL_EDI_RCV_RSLT_DT_HMS" ).append("\n"); 
		query.append("				, CXL_RQST_RJCT_RSN" ).append("\n"); 
		query.append("				, (CASE WHEN L.WBL_NO IS NOT NULL THEN L.WBL_NO" ).append("\n"); 
		query.append("						ELSE  (SELECT /*+ INDEX_RS_DESC(CT XPKCTM_MVMT_EDI_MSG) */ CT.WBL_NO" ).append("\n"); 
		query.append("								 FROM CTM_MVMT_EDI_MSG CT" ).append("\n"); 
		query.append("								WHERE 1 = 1" ).append("\n"); 
		query.append("								  AND CT.BKG_NO = L.BKG_NO" ).append("\n"); 
		query.append("								  AND CT.CNTR_NO = L.EQ_NO" ).append("\n"); 
		query.append("								  AND CT.EVNT_YD_CD = L.FM_NOD_CD" ).append("\n"); 
		query.append("								  AND CT.WBL_NO IS NOT NULL" ).append("\n"); 
		query.append("								  AND CT.MVMT_EDI_RSLT_CD IS NOT NULL" ).append("\n"); 
		query.append("								  AND ROWNUM = 1" ).append("\n"); 
		query.append("							  )" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				  ) WBL_NO" ).append("\n"); 
		query.append("				, 'Y' RAIL_FLG" ).append("\n"); 
		query.append("                , DELT_USR_ID" ).append("\n"); 
		query.append("                , DELT_DT" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		  SELECT a.cop_no                            " ).append("\n"); 
		query.append("				, a.cost_act_grp_seq" ).append("\n"); 
		query.append("				, a.ctrl_ofc_cd           " ).append("\n"); 
		query.append("				, decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_ofc_cty_cd) so_ofc                             " ).append("\n"); 
		query.append("				, MAX(d.cost_act_grp_nm) cost_act_grp_nm                                        " ).append("\n"); 
		query.append("				, MAX(DECODE(A.TRSP_SO_STS_CD, 'I', H.VNDR_LGL_ENG_NM, C.VNDR_ABBR_NM)) vndr_abbr_nm" ).append("\n"); 
		query.append("				, MAX(commcode_pkg.get_comdtl_name_fnc('CD00275', a.trsp_so_sts_cd)) trsp_so_sts                    " ).append("\n"); 
		query.append("				, MAX(decode(a.trsp_so_sts_cd, 'N', '', 'D', '', 'P', '', e.trsp_so_seq)) so_seq                       " ).append("\n"); 
		query.append("				, CASE WHEN MAX(A.TRSP_SO_STS_CD) IN ('N', 'D', 'P') THEN ' - ' ELSE (" ).append("\n"); 
		query.append("					MAX(decode(f.sub_rail_seq, 1, f.fm_nod_cd))|| ' - '|| MAX(DECODE(f.sub_rail_seq, 1, f.to_nod_cd))" ).append("\n"); 
		query.append("					  || MAX(decode(f.sub_rail_seq, 2, ' - '||f.to_nod_cd))|| MAX(DECODE(f.sub_rail_seq, 3, ' - '||f.to_nod_cd))    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					) END AS fm_to                     " ).append("\n"); 
		query.append("				, CASE WHEN MAX(a.trsp_so_sts_cd) ='N' THEN TO_CHAR(max(a.delt_dt), 'YYYYMMDD HH24:MI:SS') " ).append("\n"); 
		query.append("					   ELSE MAX(TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS')) END so_dt                       " ).append("\n"); 
		query.append("				, CASE WHEN MAX(a.trsp_so_sts_cd) ='N' THEN MAX(a.delt_usr_id) ELSE MAX(e.cre_usr_id) END user_id                                 " ).append("\n"); 
		query.append("				, MAX(DECODE(A.TRSP_SO_STS_CD, 'I', g.intl_phn_no||'-'||g.phn_no, b.intl_phn_no||'-'||b.phn_no)) sp_h_no" ).append("\n"); 
		query.append("				, MAX('')                           so_rmk1                   " ).append("\n"); 
		query.append("				, MAX('')                        so_rmk2                      " ).append("\n"); 
		query.append("				, MAX('')                         so_rmk3                    " ).append("\n"); 
		query.append("				, MAX('') wo_no                          " ).append("\n"); 
		query.append("				, MAX(TO_CHAR(e.wo_iss_dt, 'YYYYMMDD HH24:MI:SS')) wo_dt" ).append("\n"); 
		query.append("				, row_number() over (partition by a.cop_no, a.cost_act_grp_seq order by" ).append("\n"); 
		query.append("					CASE WHEN MAX(a.trsp_so_sts_cd) ='N' then to_char(max(a.delt_dt), 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("						 ELSE MAX(TO_CHAR(e.locl_cre_dt, 'YYYYMMDD HH24:MI:SS')) " ).append("\n"); 
		query.append("					END desc ) mx_knt                       " ).append("\n"); 
		query.append("				, MAX(J.VNDR_ABBR_NM) AS RAIL_VNDR_NM" ).append("\n"); 
		query.append("				, TO_CHAR(MAX(I.BIL_EDI_SNT_DT), 'YYYYMMDD') AS BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("				, TO_CHAR(MAX(I.BIL_EDI_SNT_DT), 'HH24MISS') AS BIL_EDI_SNT_DT_HMS" ).append("\n"); 
		query.append("				, MAX(I.BIL_EDI_RCV_RSLT_CD) AS BIL_EDI_RCV_RSLT_CD" ).append("\n"); 
		query.append("				, TO_CHAR(MAX(I.BIL_EDI_RCV_RSLT_DT), 'YYYYMMDD') AS BIL_EDI_RCV_RSLT_DT" ).append("\n"); 
		query.append("				, TO_CHAR(MAX(I.BIL_EDI_RCV_RSLT_DT), 'HH24MISS') AS BIL_EDI_RCV_RSLT_DT_HMS" ).append("\n"); 
		query.append("				, MAX(I.CXL_RQST_RJCT_RSN) AS CXL_RQST_RJCT_RSN" ).append("\n"); 
		query.append("				, MAX(I.WBL_NO) AS WBL_NO" ).append("\n"); 
		query.append("				, MAX(E.BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("				, MAX(E.EQ_NO) AS EQ_NO" ).append("\n"); 
		query.append("				, MAX(F.FM_NOD_CD) AS FM_NOD_CD" ).append("\n"); 
		query.append("                , MAX(A.DELT_USR_ID) AS DELT_USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELBB', MAX(A.DELT_DT), A.CTRL_OFC_CD), 'YYYY-MM-DD HH24:MI:SS') AS DELT_DT" ).append("\n"); 
		query.append("			 FROM sce_pln_so_list a                      " ).append("\n"); 
		query.append("				, mdm_vndr_cntc_pnt b                     " ).append("\n"); 
		query.append("				, mdm_vendor  c                           " ).append("\n"); 
		query.append("				, prd_cost_act_grp d                        " ).append("\n"); 
		query.append("				, trs_trsp_rail_bil_ord e                   " ).append("\n"); 
		query.append("				, trs_trsp_rail_bil_vndr_set f" ).append("\n"); 
		query.append("				, mdm_vndr_cntc_pnt g" ).append("\n"); 
		query.append("				, mdm_vendor  h" ).append("\n"); 
		query.append("				, (" ).append("\n"); 
		query.append("						SELECT * " ).append("\n"); 
		query.append("						  FROM (" ).append("\n"); 
		query.append("								SELECT  TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("									  , TRSP_SO_SEQ" ).append("\n"); 
		query.append("									  , BIL_ISS_KNT" ).append("\n"); 
		query.append("									  , VNDR_SEQ, BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("									  , BIL_EDI_RCV_RSLT_CD AS BIL_EDI_RCV_RSLT_CD" ).append("\n"); 
		query.append("									  , BIL_EDI_RCV_RSLT_DT AS BIL_EDI_RCV_RSLT_DT" ).append("\n"); 
		query.append("									  , CXL_RQST_RJCT_RSN" ).append("\n"); 
		query.append("									  , WBL_NO" ).append("\n"); 
		query.append("									  , FIRST_VALUE(WBL_NO) IGNORE NULLS OVER (PARTITION BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ " ).append("\n"); 
		query.append("																			   ORDER BY BIL_ISS_KNT DESC " ).append("\n"); 
		query.append("																			   ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS WBL_NO_1" ).append("\n"); 
		query.append("									  , MAX(BIL_ISS_KNT) OVER (PARTITION BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) AS BIL_ISS_KNT_1 " ).append("\n"); 
		query.append("								  FROM  TRS_TRSP_EDI_RAIL_ORD" ).append("\n"); 
		query.append("								 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("								 ORDER BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, BIL_ISS_KNT" ).append("\n"); 
		query.append("						) " ).append("\n"); 
		query.append("						WHERE BIL_ISS_KNT = CASE WHEN WBL_NO_1 IS NULL THEN BIL_ISS_KNT_1" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("														CASE WHEN WBL_NO = WBL_NO_1 THEN BIL_ISS_KNT" ).append("\n"); 
		query.append("															 ELSE -1" ).append("\n"); 
		query.append("														 END" ).append("\n"); 
		query.append("											 END" ).append("\n"); 
		query.append("				  ) I" ).append("\n"); 
		query.append("				, MDM_VENDOR J" ).append("\n"); 
		query.append("			WHERE a.cost_act_grp_cd = d.cost_act_grp_cd" ).append("\n"); 
		query.append("			  AND a.n1st_vndr_seq = c.vndr_seq (+)" ).append("\n"); 
		query.append("			  AND a.cop_no = @[cop_no]                              " ).append("\n"); 
		query.append("			  AND NVL(a.trsp_so_sts_cd, 'U') != 'U'" ).append("\n"); 
		query.append("			  AND a.n1st_vndr_seq = b.vndr_seq (+)" ).append("\n"); 
		query.append("			  AND f.vndr_seq = g.vndr_seq (+)" ).append("\n"); 
		query.append("			  AND f.vndr_seq = h.vndr_seq (+)" ).append("\n"); 
		query.append("			  AND b.prmry_chk_flg (+)               = 'Y'                            " ).append("\n"); 
		query.append("			  AND b.phn_no (+)      IS NOT NULL " ).append("\n"); 
		query.append("			  AND a.cop_no = e.cop_no(+)      " ).append("\n"); 
		query.append("			  AND a.cost_act_grp_seq = e.cost_act_grp_seq (+)                                             " ).append("\n"); 
		query.append("			  AND e.trsp_so_ofc_cty_cd =f.trsp_so_ofc_cty_cd(+)                    " ).append("\n"); 
		query.append("			  AND e.trsp_so_seq = f.trsp_so_seq(+)                        " ).append("\n"); 
		query.append("			  AND A.INLND_ROUT_INV_BIL_PATT_CD IS NOT NULL" ).append("\n"); 
		query.append("			  AND a.trsp_mod_cd ='RD'" ).append("\n"); 
		query.append("			  AND E.TRSP_SO_OFC_CTY_CD = I.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("			  AND E.TRSP_SO_SEQ = I.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("			  AND I.VNDR_SEQ = J.VNDR_SEQ(+)" ).append("\n"); 
		query.append("			  AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("			  AND NVL(E.UPLN_SO_FLG(+),'N') = 'N' 	" ).append("\n"); 
		query.append("		  GROUP BY a.cop_no, a.ctrl_ofc_cd,a.cost_act_grp_seq, a.trsp_so_sts_cd, e.trsp_so_ofc_cty_cd ) L  " ).append("\n"); 
		query.append("	) aa " ).append("\n"); 
		query.append("	WHERE mx_knt = 1                       " ).append("\n"); 
		query.append("    ORDER BY 1,2" ).append("\n"); 

	}
}