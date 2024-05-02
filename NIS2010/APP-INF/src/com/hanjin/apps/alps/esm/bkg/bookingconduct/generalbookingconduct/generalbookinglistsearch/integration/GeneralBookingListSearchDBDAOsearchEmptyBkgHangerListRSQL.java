/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchEmptyBkgHangerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchEmptyBkgHangerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking의 Hanger 정보를 조회한다
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchEmptyBkgHangerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchEmptyBkgHangerListRSQL").append("\n"); 
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
		query.append("SELECT POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POD_ETA" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("              WHERE INTG_CD_ID = 'CD02012' " ).append("\n"); 
		query.append("                AND INTG_CD_VAL_CTNT = HRT) HRT" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("              WHERE INTG_CD_ID = 'CD02011' " ).append("\n"); 
		query.append("                AND INTG_CD_VAL_CTNT = HBT) HBT" ).append("\n"); 
		query.append("     , HBQ" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("--     , (SELECT PRE_BKG_NO FROM BKG_BOOKING BK WHERE BK.BKG_NO = A.PRE_BKG_NO AND BK.HNGR_FLG = 'Y') PRE_BKG_NO" ).append("\n"); 
		query.append("     , pre_bkg_no" ).append("\n"); 
		query.append("     , (SELECT DECODE(HBT, 'S', DECODE(CNTR_TPSZ_CD, 'D2', 11, 'D4', 22, 'D5', 22, 'D7', 24), " ).append("\n"); 
		query.append("                           'D', DECODE(CNTR_TPSZ_CD, 'D2', 22, 'D4', 44, 'D5', 44, 'D7', 48))" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK " ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = A.PRE_BKG_NO" ).append("\n"); 
		query.append("           AND BK.HNGR_FLG = 'Y') S_BAR_QTY    " ).append("\n"); 
		query.append("  FROM (SELECT BK.POL_CD||SUBSTR(BK.POL_NOD_CD, 6, 2) POL_CD" ).append("\n"); 
		query.append("                , BK.POD_CD||SUBSTR(BK.POD_NOD_CD, 6, 2) POD_CD" ).append("\n"); 
		query.append("                , (SELECT MIN(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("                     FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                    WHERE SKD.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                      AND SKD.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND SKD.SKD_DIR_CD = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND SKD.VPS_PORT_CD = BK.POD_CD) AS POD_ETA" ).append("\n"); 
		query.append("                , CNTR.CNTR_NO" ).append("\n"); 
		query.append("                , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    , MST.CNTR_HNGR_RCK_CD       HRT" ).append("\n"); 
		query.append("                    , MST.MNR_HNGR_BAR_TP_CD     HBT" ).append("\n"); 
		query.append("                    , MST.CNTR_HNGR_BAR_ATCH_KNT HBQ" ).append("\n"); 
		query.append("                , BK.BKG_NO" ).append("\n"); 
		query.append("                    , (SELECT /*+ INDEX_DESC(CTM XAK11CTM_MOVEMENT) */ CTM.BKG_NO" ).append("\n"); 
		query.append("                         FROM CTM_MOVEMENT CTM, BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("                        WHERE CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                          AND CNTR2.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                          AND CNTR2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND CTM.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                          AND CTM.BKG_NO <> BK.BKG_NO" ).append("\n"); 
		query.append("                          AND CTM.CNMV_CYC_NO <= CNTR2.CNMV_CYC_NO" ).append("\n"); 
		query.append("                          AND CTM.CNMV_YR     <= CNTR2.CNMV_YR" ).append("\n"); 
		query.append("                          AND ROWNUM = 1" ).append("\n"); 
		query.append("                      ) PRE_BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK, " ).append("\n"); 
		query.append("               BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("               MST_CONTAINER MST," ).append("\n"); 
		query.append("                (SELECT BK.BKG_NO, BK.FM_BKG_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("       #if (${vvd_cd} != '')  " ).append("\n"); 
		query.append("            , bkg_vvd vvd  " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	   #if (${cntr_no1} != '' || (${cntrTpsz} != '' && ${tpsztype} != '')) " ).append("\n"); 
		query.append("			, bkg_container cntr" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("       #if (${bkg_date_tp} == 'E')" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("            select skd.vps_eta_dt, bk.bkg_no, vvd.pod_cd" ).append("\n"); 
		query.append("              from bkg_booking bk, bkg_vvd vvd, vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("             where bk.bkg_no            = vvd.bkg_no" ).append("\n"); 
		query.append("               and bk.pod_cd            = vvd.pod_cd" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd   in ('T','U')" ).append("\n"); 
		query.append("               and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pod_cd           = skd.VPS_PORT_CD" ).append("\n"); 
		query.append("               and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq" ).append("\n"); 
		query.append("                    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                       and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                       and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                       and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("                          and skd.vps_eta_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("                          and skd.vps_eta_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("             ) eta" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 WHERE BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                   AND 'Y' = CASE WHEN BK.SPLIT_FLG = 'Y' AND BK.BKG_STS_CD = 'X' THEN 'Y'--SPLIT인데 CANCEL된 건 -> MASTER BKG -> 조회됨" ).append("\n"); 
		query.append("                                          WHEN BK.SPLIT_FLG = 'N' AND BK.BKG_STS_CD = 'X' THEN 'N'--SPLIT이 아닌데 CANCEL된 건 -> 일반 CANCEL -> 조회안됨" ).append("\n"); 
		query.append("                                          ELSE 'Y' END --그외 조회됨                " ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("   and bk.bkg_no LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if  (${bl_no} != '')    " ).append("\n"); 
		query.append("   and bk.bl_no LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')  " ).append("\n"); 
		query.append("   and bk.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("       #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("          and bk.bkg_no     = vvd.bkg_no   " ).append("\n"); 
		query.append("          and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	   #if (${cntr_no1} != '' || (${cntrTpsz} != '' && ${tpsztype} != '')) " ).append("\n"); 
		query.append("	       AND bk.BKG_NO = cntr.BKG_NO" ).append("\n"); 
		query.append("          #if (${cntr_no1} != '') " ).append("\n"); 
		query.append("	       AND cntr.CNTR_NO = @[cntr_no1]||@[cntr_no2]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${cntrTpsz} != '' && ${tpsztype} != '') " ).append("\n"); 
		query.append("	       AND cntr.CNTR_TPSZ_CD IN ( ${tpszTypeText} )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("       #if (${pol_cd} != '') " ).append("\n"); 
		query.append("          and bk.pol_cd LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${pod_cd} != '') " ).append("\n"); 
		query.append("          and bk.pod_cd LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${pre_rly_port_cd} != '') " ).append("\n"); 
		query.append("          and bk.pre_rly_port_cd LIKE @[pre_rly_port_cd]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${pst_rly_port_cd} != '') " ).append("\n"); 
		query.append("          and bk.pst_rly_port_cd LIKE @[pst_rly_port_cd]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${vvd_cd} == '')" ).append("\n"); 
		query.append("             #if (${bkg_date_tp} != 'E')             " ).append("\n"); 
		query.append("                    #if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("                          and bk.bkg_cre_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("                          and bk.bkg_cre_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("                    and bk.bkg_no = eta.bkg_no" ).append("\n"); 
		query.append("                    and bk.pod_cd = eta.pod_cd" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${vvd_cd_flg} == 'E')  " ).append("\n"); 
		query.append("          and vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       #if (${cntr_attach} == 'Y')  " ).append("\n"); 
		query.append("          and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) > 0" ).append("\n"); 
		query.append("       #elseif  (${cntr_attach} == 'N')  " ).append("\n"); 
		query.append("          and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) = 0   " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_status} == 'D')  -- VD" ).append("\n"); 
		query.append("        AND NVL(bk.BKG_CRE_TP_CD, 'X') = 'S' -- S:SPLIT" ).append("\n"); 
		query.append("    #elseif  (${bkg_status} == 'L') -- VL" ).append("\n"); 
		query.append("        AND NVL(bk.BKG_CRE_TP_CD, 'X') = 'X' -- L : VL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) MST_BKG" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '') " ).append("\n"); 
		query.append(" where bk.bkg_no = mst_bkg.bkg_no" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" where (bk.bkg_no = mst_bkg.bkg_no or bk.fm_bkg_no = mst_bkg.bkg_no or mst_bkg.fm_bkg_no = bk.bkg_no)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_TPSZ_CD IN ('D2','D4','D5','D7')" ).append("\n"); 
		query.append("           AND MST.CNTR_HNGR_RCK_CD IS NOT NULL" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 

	}
}