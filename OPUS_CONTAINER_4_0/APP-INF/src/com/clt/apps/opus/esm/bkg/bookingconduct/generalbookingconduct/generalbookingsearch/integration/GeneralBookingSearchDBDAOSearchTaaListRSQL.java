/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchTaaListRSQL.java
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

public class GeneralBookingSearchDBDAOSearchTaaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taa 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchTaaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_pty_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("include_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchTaaListRSQL").append("\n"); 
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
		query.append("select distinct cust.cust_cnt_cd" ).append("\n"); 
		query.append("        , cust.cust_seq" ).append("\n"); 
		query.append("        , cust.cust_lgl_eng_nm" ).append("\n"); 
		query.append("        , (select hdr.taa_no from pri_taa_hdr hdr where hdr.taa_prop_no = main.taa_prop_no) taa_no" ).append("\n"); 
		query.append("        , respb_sls_ofc_cd  sales_ofc" ).append("\n"); 
		query.append("        , main.svc_scp_cd" ).append("\n"); 
		query.append("		, (select svc_scp_nm from mdm_svc_scp scope where scope.svc_scp_cd = main.svc_scp_cd) svc_scp_nm" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
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
		query.append("#else" ).append("\n"); 
		query.append("	SELECT SYSDATE AS APPL_DT FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ) appl" ).append("\n"); 
		query.append("    , (select cust_cnt_cd, cust_seq, cust_lgl_eng_nm" ).append("\n"); 
		query.append("         from mdm_customer" ).append("\n"); 
		query.append("        where cust_cnt_cd     = nvl(@[s_cust_cnt_cd], 'xx')" ).append("\n"); 
		query.append("#if (${s_cust_seq} == '' && ${s_cust_nm} == '') " ).append("\n"); 
		query.append("		  and cust_seq = 0 --seq, name이 둘다 없는 경우 조회에서 제외" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${s_cust_seq} != '')" ).append("\n"); 
		query.append("		  and cust_seq 		  = @[s_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_nm} != '') " ).append("\n"); 
		query.append("		  and cust_lgl_eng_nm like decode(@[include_flag], 'Y', '%', '')||@[s_cust_nm]||'%'" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("          and delt_flg        = 'N'" ).append("\n"); 
		query.append("       union " ).append("\n"); 
		query.append("       select cust_cnt_cd, cust_seq, cust_lgl_eng_nm" ).append("\n"); 
		query.append("         from mdm_customer" ).append("\n"); 
		query.append("        where cust_cnt_cd     = nvl(@[c_cust_cnt_cd], 'xx')" ).append("\n"); 
		query.append("#if (${c_cust_seq} == '' && ${c_cust_nm} == '') " ).append("\n"); 
		query.append("		  and cust_seq = 0 --seq, name이 둘다 없는 경우 조회에서 제외" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${c_cust_seq} != '')" ).append("\n"); 
		query.append("		  and cust_seq 		  = @[c_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${c_cust_nm} != '') " ).append("\n"); 
		query.append("		  and cust_lgl_eng_nm like decode(@[include_flag], 'Y', '%', '')||@[c_cust_nm]||'%'" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("          and delt_flg        = 'N'" ).append("\n"); 
		query.append("       union" ).append("\n"); 
		query.append("       select cust_cnt_cd, cust_seq, cust_lgl_eng_nm" ).append("\n"); 
		query.append("         from mdm_customer" ).append("\n"); 
		query.append("        where cust_cnt_cd     = nvl(@[bkg_ctrl_pty_cust_cnt_cd], 'xx')" ).append("\n"); 
		query.append("#if (${bkg_ctrl_pty_cust_seq} == '' && ${bkg_ctrl_pty_cust_nm} == '') " ).append("\n"); 
		query.append("		  and cust_seq = 0 --seq, name이 둘다 없는 경우 조회에서 제외" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${bkg_ctrl_pty_cust_seq} != '')" ).append("\n"); 
		query.append("		  and cust_seq 		  = @[bkg_ctrl_pty_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrl_pty_cust_nm} != '') " ).append("\n"); 
		query.append("          and cust_lgl_eng_nm like decode(@[include_flag], 'Y', '%', '')||@[bkg_ctrl_pty_cust_nm]||'%'" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("          and delt_flg        = 'N'" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	   union " ).append("\n"); 
		query.append("       select cust.cust_cnt_cd, cust.cust_seq, cust.cust_nm" ).append("\n"); 
		query.append("         from bkg_customer cust, bkg_booking bk" ).append("\n"); 
		query.append("        where bk.bkg_no          = @[bkg_no]   " ).append("\n"); 
		query.append("          and bk.bkg_no          = cust.bkg_no" ).append("\n"); 
		query.append("          and bk.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("          and cust.bkg_cust_tp_Cd    = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ) cust" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '') " ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("    , pri_taa_mn main" ).append("\n"); 
		query.append("  where cust_cnt_cd         = ctrt_cust_cnt_cd " ).append("\n"); 
		query.append("    and cust_seq            = ctrt_cust_Seq" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '') " ).append("\n"); 
		query.append("    and main.svc_scp_cd    =  scope.SVC_SCP_CD" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("    and MAIN.eff_dt - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("    AND MAIN.exp_dt + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("    and main.cfm_flg = 'Y'" ).append("\n"); 

	}
}