/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchPropNoByScRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchPropNoByScRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C로 PropNo를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchPropNoByScRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchPropNoByScRSQL").append("\n"); 
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
		query.append("select main.prop_no, main.amdt_seq, sp_scp.svc_scp_cd   " ).append("\n"); 
		query.append("  from " ).append("\n"); 
		query.append("    (select appl_dt" ).append("\n"); 
		query.append("         from " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("            select 1 rank, RT_APLY_DT appl_dt " ).append("\n"); 
		query.append("              from bkg_rt_his r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("			   and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("			select 2 rank, RT_APLY_DT appl_dt --rate applicable" ).append("\n"); 
		query.append("              from bkg_rate r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            SELECT 3 rank, TO_DATE(RT_APLY_DT,'YYYY-MM-DD') appl_dt" ).append("\n"); 
		query.append("              FROM (SELECT CASE WHEN MAX(A.CGO_RCV_DT) IS NULL THEN NULL" ).append("\n"); 
		query.append("                             WHEN MAX(A.CGO_RCV_DT) +180 > SYSDATE THEN TO_CHAR(MAX(A.CGO_RCV_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("                             ELSE null" ).append("\n"); 
		query.append("                             END RT_APLY_DT" ).append("\n"); 
		query.append("                 FROM BKG_CNTR_HIS A, BKG_BKG_HIS B," ).append("\n"); 
		query.append("                      (SELECT SUM(CNTR_VOL_QTY) Y1" ).append("\n"); 
		query.append("                        FROM BKG_CNTR_HIS " ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                          AND CORR_NO ='TMP0000001')," ).append("\n"); 
		query.append("                      (SELECT SUM(OP_CNTR_QTY) Y2" ).append("\n"); 
		query.append("                        FROM BKG_QTY_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND CNTR_TPSZ_CD NOT IN ('Q2','Q4') " ).append("\n"); 
		query.append("                          AND CORR_NO ='TMP0000001')" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND Y1 = Y2 " ).append("\n"); 
		query.append("                 AND A.CORR_NO ='TMP0000001' " ).append("\n"); 
		query.append("                 AND B.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("                 AND BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no], @[ca_flg]) = 'CRD')" ).append("\n"); 
		query.append("            WHERE RT_APLY_DT is not null" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            SELECT 4 rank, TO_DATE(RT_APLY_DT,'YYYY-MM-DD') appl_dt" ).append("\n"); 
		query.append("              FROM (SELECT CASE WHEN MAX(A.CGO_RCV_DT) IS NULL THEN NULL" ).append("\n"); 
		query.append("                             WHEN MAX(A.CGO_RCV_DT) +180 > SYSDATE THEN TO_CHAR(MAX(A.CGO_RCV_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("                             ELSE NULL" ).append("\n"); 
		query.append("                             END RT_APLY_DT" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER A, BKG_BOOKING B," ).append("\n"); 
		query.append("                      (SELECT SUM(CNTR_VOL_QTY) Y1" ).append("\n"); 
		query.append("                        FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no] )," ).append("\n"); 
		query.append("                      (SELECT SUM(OP_CNTR_QTY) Y2" ).append("\n"); 
		query.append("                        FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND CNTR_TPSZ_CD NOT IN ('Q2','Q4'))" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND Y1 = Y2" ).append("\n"); 
		query.append("                 AND BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no], @[ca_flg]) = 'CRD')" ).append("\n"); 
		query.append("            WHERE RT_APLY_DT is not null" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 5 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd_his vvd, vsk_vsl_port_skd skd, bkg_bkg_his bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("			   and bk.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("			   and vvd.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 6 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd vvd, vsk_vsl_port_skd skd, bkg_booking bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            select 7 rank, sysdate appl_dt" ).append("\n"); 
		query.append("              from dual)   " ).append("\n"); 
		query.append("        where rownum = 1) appl" ).append("\n"); 
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
		query.append("#end          " ).append("\n"); 
		query.append("    , pri_sp_mn main" ).append("\n"); 
		query.append("    , pri_sp_scp_mn sp_scp" ).append("\n"); 
		query.append("    , pri_sp_hdr hdr" ).append("\n"); 
		query.append("  where main.prop_no        = sp_scp.prop_no" ).append("\n"); 
		query.append("    and main.amdt_seq       = sp_scp.amdt_seq" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '')--porCd, delCd ?낅젰?쒖뿉留?" ).append("\n"); 
		query.append("    and sp_scp.svc_scp_cd   = case when scope.svc_scp_cd in ('ACE', 'MXE', 'TPE') " ).append("\n"); 
		query.append("                                        and (select count(1) " ).append("\n"); 
		query.append("                                               from pri_sp_scp_mn sc_scp_sub " ).append("\n"); 
		query.append("                                              where main.prop_no        = sc_scp_sub.prop_no" ).append("\n"); 
		query.append("                                                and main.amdt_seq       = sc_scp_sub.amdt_seq" ).append("\n"); 
		query.append("                                                and scope.svc_scp_cd    = sc_scp_sub.svc_scp_cd) = 0 then sp_scp.svc_scp_cd" ).append("\n"); 
		query.append("                              else scope.svc_scp_cd end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    and appl.appl_dt        > main.eff_dt - 0.0001" ).append("\n"); 
		query.append("    and appl.appl_dt        < main.exp_dt + 0.9999" ).append("\n"); 
		query.append("    and hdr.prop_no         = main.prop_no" ).append("\n"); 
		query.append("    and hdr.sc_no          = @[sc_no]" ).append("\n"); 
		query.append("    and main.prop_sts_cd = 'F'" ).append("\n"); 

	}
}