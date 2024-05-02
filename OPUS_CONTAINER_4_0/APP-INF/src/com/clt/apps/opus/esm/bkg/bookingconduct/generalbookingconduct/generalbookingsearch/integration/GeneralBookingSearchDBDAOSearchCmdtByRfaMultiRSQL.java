/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCmdtByRfaMultiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCmdtByRfaMultiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rfa 계약 상의 Commodity를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCmdtByRfaMultiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_due_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCmdtByRfaMultiRSQL").append("\n"); 
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
		query.append("WITH REF_CMDT AS (" ).append("\n"); 
		query.append("select prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd, rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,'' GRP_DESC" ).append("\n"); 
		query.append("       ,'' rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prc_cmdt_def_cd = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'R' --Rep commodity" ).append("\n"); 
		query.append("   AND rp_cmdt.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_nm    like '%'|| @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,'' GRP_DESC" ).append("\n"); 
		query.append("       ,'' rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, mdm_commodity cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prc_cmdt_def_cd = cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'C' --commodity" ).append("\n"); 
		query.append("   and cmdt.rep_cmdt_cd			   = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("   AND rp_cmdt.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_cd            like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '') " ).append("\n"); 
		query.append("   and cmdt.cmdt_nm            like '%'|| @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,GRP_DESC.PRC_GRP_CMDT_DESC AS grp_desc" ).append("\n"); 
		query.append("       ,rp_cmdt.prc_cmdt_def_cd AS rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(",PRI_RP_SCP_GRP_CMDT GRP_DESC" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'R' --Rep commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("	AND rp_cmdt.prop_no         = GRP_DESC.prop_no" ).append("\n"); 
		query.append("	and rp_cmdt.amdt_Seq        = GRP_DESC.amdt_seq" ).append("\n"); 
		query.append("	and rp_cmdt.svc_scp_cd      = GRP_DESC.svc_scp_cd" ).append("\n"); 
		query.append("	AND RP_CMDT.prc_cmdt_def_cd = GRP_DESC.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("	AND GRP_DESC.GRP_CMDT_SEQ = GRP_CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    AND grp_cmdt.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like '%'|| @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and (UPPER(rep_cmdt.rep_cmdt_nm)    like '%'|| @[cmdt_nm]||'%' OR UPPER(GRP_DESC.PRC_GRP_CMDT_DESC) like '%'|| @[cmdt_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,GRP_DESC.PRC_GRP_CMDT_DESC AS grp_desc" ).append("\n"); 
		query.append("       ,rp_cmdt.prc_cmdt_def_cd AS rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_commodity cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(",PRI_RP_SCP_GRP_CMDT GRP_DESC" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and cmdt.rep_cmdt_cd	       = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'C' --commodity" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("	AND rp_cmdt.prop_no         = GRP_DESC.prop_no" ).append("\n"); 
		query.append("	and rp_cmdt.amdt_Seq        = GRP_DESC.amdt_seq" ).append("\n"); 
		query.append("	and rp_cmdt.svc_scp_cd      = GRP_DESC.svc_scp_cd" ).append("\n"); 
		query.append("	AND RP_CMDT.prc_cmdt_def_cd = GRP_DESC.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("	AND GRP_DESC.GRP_CMDT_SEQ = GRP_CMDT.GRP_CMDT_SEQ " ).append("\n"); 
		query.append("    AND grp_cmdt.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_cd            like '%'|| @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and (UPPER(cmdt.cmdt_nm)            like '%'|| @[cmdt_nm]||'%' OR UPPER(GRP_DESC.PRC_GRP_CMDT_DESC) like '%'|| @[cmdt_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("SELECT * FROM REF_CMDT" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  and svc_scp_cd in (" ).append("\n"); 
		query.append("select rp_scp.svc_scp_cd   " ).append("\n"); 
		query.append("  from (" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("            SELECT RT_APLY_DT " ).append("\n"); 
		query.append("              FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       NVL((" ).append("\n"); 
		query.append("            SELECT RT_APLY_DT" ).append("\n"); 
		query.append("              FROM BKG_RATE R" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       NVL((" ).append("\n"); 
		query.append("            SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("              FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("               AND BK.CORR_NO         = 'TMP0000001'" ).append("\n"); 
		query.append("               AND VVD.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			   AND ROWNUM = 1" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       NVL((" ).append("\n"); 
		query.append("            SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("              FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("               AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			   AND ROWNUM = 1" ).append("\n"); 
		query.append("           ),SYSDATE)" ).append("\n"); 
		query.append("       ))) AS APPL_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#elseif (${lodg_due_dt} != '')" ).append("\n"); 
		query.append("    SELECT TO_DATE(@[lodg_due_dt],'YYYY-MM-DD') AS APPL_DT FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT SYSDATE AS APPL_DT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) appl" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '')         " ).append("\n"); 
		query.append("    , (SELECT DISTINCT LOC_SCOPE.SVC_SCP_CD" ).append("\n"); 
		query.append("		 FROM (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, COUNT(1) CNT" ).append("\n"); 
		query.append("        		 FROM MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("		            , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("			    WHERE ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("        		  AND ORG.SVC_SCP_CD = DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("		        GROUP BY ORG.SVC_SCP_CD) LOC_SCOPE," ).append("\n"); 
		query.append("			  (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, 1 CNT" ).append("\n"); 
		query.append("			     FROM MDM_SVC_SCP_LANE LANE " ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("			        , VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("			    WHERE ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_CD   		= DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("			      AND LANE.VSL_SLAN_CD 		= SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("			      AND SKD.VSL_CD    		= SUBSTR(@[bkg_vvd], 1, 4)" ).append("\n"); 
		query.append("			      AND SKD.SKD_VOY_NO 		= SUBSTR(@[bkg_vvd], 5, 4)" ).append("\n"); 
		query.append("			      AND SKD.SKD_DIR_CD 		= SUBSTR(@[bkg_vvd], 9, 1)" ).append("\n"); 
		query.append("			    GROUP BY ORG.SVC_SCP_CD" ).append("\n"); 
		query.append("			    UNION " ).append("\n"); 
		query.append("			    SELECT '   ' SVC_SCP_CD , 1 CNT FROM DUAL) VSL_SCOPE" ).append("\n"); 
		query.append("		WHERE ((LOC_SCOPE.CNT = 1 AND LOC_SCOPE.CNT = VSL_SCOPE.CNT)" ).append("\n"); 
		query.append("		       OR " ).append("\n"); 
		query.append("		       (LOC_SCOPE.CNT > 1 AND LOC_SCOPE.SVC_SCP_CD = VSL_SCOPE.SVC_SCP_CD)" ).append("\n"); 
		query.append("		      )" ).append("\n"); 
		query.append("         ) scope" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("    , pri_rp_mn main" ).append("\n"); 
		query.append("    , pri_rp_scp_mn rp_scp" ).append("\n"); 
		query.append("    , pri_rp_hdr hdr" ).append("\n"); 
		query.append("  where main.prop_no        = rp_scp.prop_no" ).append("\n"); 
		query.append("    and main.amdt_seq       = rp_scp.amdt_seq" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '')--porCd, delCd 입력시에만" ).append("\n"); 
		query.append("    and rp_scp.svc_scp_cd   = scope.SVC_SCP_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    and appl.appl_dt        > main.eff_dt - 0.0001" ).append("\n"); 
		query.append("    and appl.appl_dt        < main.exp_dt + 0.9999" ).append("\n"); 
		query.append("    and hdr.prop_no         = main.prop_no" ).append("\n"); 
		query.append("    and hdr.rfa_no          = @[rfa_no]" ).append("\n"); 
		query.append("    and main.prop_sts_cd    = 'A'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}