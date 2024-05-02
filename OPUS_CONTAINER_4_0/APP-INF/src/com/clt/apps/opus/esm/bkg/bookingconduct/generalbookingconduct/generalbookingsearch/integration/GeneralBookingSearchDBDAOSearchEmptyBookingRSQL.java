/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEmptyBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2017.01.03 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEmptyBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking 정보 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEmptyBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEmptyBookingRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append("	, bk.bl_no" ).append("\n"); 
		query.append("	, bk.bl_no_tp" ).append("\n"); 
		query.append("	, bk.bl_tp_cd" ).append("\n"); 
		query.append("	, bk.vsl_cd" ).append("\n"); 
		query.append("	, bk.skd_voy_no" ).append("\n"); 
		query.append("	, bk.skd_dir_cd" ).append("\n"); 
		query.append("	, bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd bkg_trunk_vvd" ).append("\n"); 
		query.append("	, bk.sls_rhq_cd" ).append("\n"); 
		query.append("	, bk.mty_pkup_yd_cd org_yd_cd" ).append("\n"); 
		query.append("	, rt.cgo_rcv_dt" ).append("\n"); 
		query.append("	, to_char(cntr.cnmv_evnt_dt ,'yyyymmdd hh24:mi') cnmv_evnt_dt" ).append("\n"); 
		query.append("	, to_char(bk.bkg_cre_dt, 'yyyy-mm-dd') bkg_cre_dt" ).append("\n"); 
		query.append("	, bk.pol_cd bkg_pol_cd" ).append("\n"); 
		query.append("	, bk.pod_cd bkg_pod_cd" ).append("\n"); 
		query.append("	, bk.mty_bkg_sts_cd" ).append("\n"); 
		query.append("    , bk.bkg_sts_cd" ).append("\n"); 
		query.append("	, vvd.pol_cd" ).append("\n"); 
		query.append("	, vvd.pod_cd" ).append("\n"); 
		query.append("	, bk.split_flg" ).append("\n"); 
		query.append("	, trim(bk.inter_rmk) inter_rmk" ).append("\n"); 
		query.append("         ,(SELECT CASE 	WHEN NVL2(T2.VSL_CD,'Y','N') = 'N' THEN 	TO_CHAR(T1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           		ELSE 							TO_CHAR(NVL((" ).append("\n"); 
		query.append("				SELECT   H.LST_ETD_DT" ).append("\n"); 
		query.append("				FROM     VSK_ACT_PORT_SKD_HIS H" ).append("\n"); 
		query.append("				WHERE    H.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("				AND      H.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND      H.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND      H.VPS_PORT_CD  = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("				AND      H.CLPT_IND_SEQ = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				AND      H.CNG_SEQ      = (SELECT  MAX(HH.CNG_SEQ)" ).append("\n"); 
		query.append("			                                FROM    VSK_ACT_PORT_SKD_HIS  HH" ).append("\n"); 
		query.append("			                                WHERE   HH.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("			                                AND     HH.SKD_VOY_NO   = H.SKD_VOY_NO" ).append("\n"); 
		query.append("			                                AND     HH.SKD_DIR_CD   = H.SKD_DIR_CD" ).append("\n"); 
		query.append("			                                AND     HH.VPS_PORT_CD  = H.VPS_PORT_CD" ).append("\n"); 
		query.append("			                                AND     HH.CLPT_IND_SEQ = H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			                                AND     HH.HIS_CRE_RSN_CD     = 'I'" ).append("\n"); 
		query.append("			                                )" ).append("\n"); 
		query.append("			  ),VPS_ETD_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("               , BKG_VVD BV" ).append("\n"); 
		query.append("           WHERE BK.BKG_NO            = BV.BKG_NO" ).append("\n"); 
		query.append("             AND BK.POL_CD            = BV.POL_CD" ).append("\n"); 
		query.append("             AND BV.VSL_PRE_PST_CD   IN ('T')" ).append("\n"); 
		query.append("             AND BV.VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("             AND BV.SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND BV.SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND BV.POL_CD           = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND DECODE(BV.POL_CLPT_IND_SEQ, NULL, 1, 0, 1, BV.POL_CLPT_IND_SEQ) = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND T1.VSL_CD       = T2.VSL_CD(+)" ).append("\n"); 
		query.append("             AND T1.SKD_VOY_NO   = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("             AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("             AND T1.VPS_PORT_CD  = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("             AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("             AND ROWNUM               = 1 )   AS POL_ETD_DT" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR (T2.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("               , BKG_VVD BV" ).append("\n"); 
		query.append("           WHERE BK.BKG_NO            = BV.BKG_NO" ).append("\n"); 
		query.append("             AND BK.POL_CD            = BV.POL_CD" ).append("\n"); 
		query.append("             AND BV.VSL_PRE_PST_CD   IN ('T')" ).append("\n"); 
		query.append("             AND BV.VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("             AND BV.SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND BV.SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND BV.POL_CD           = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND DECODE(BV.POL_CLPT_IND_SEQ, NULL, 1, 0, 1, BV.POL_CLPT_IND_SEQ) = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND T1.VSL_CD       = T2.VSL_CD(+)" ).append("\n"); 
		query.append("             AND T1.SKD_VOY_NO   = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("             AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("             AND T1.VPS_PORT_CD  = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("             AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("             AND ROWNUM               = 1 )   AS POL_ATD_DT" ).append("\n"); 
		query.append("           ,(SELECT    	 CASE 	WHEN NVL2(T2.VSL_CD,'Y','N') = 'N' THEN 	TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           		         ELSE 							TO_CHAR(NVL((" ).append("\n"); 
		query.append("                                                                SELECT   H.LST_ETA_DT" ).append("\n"); 
		query.append("                                                                FROM     VSK_ACT_PORT_SKD_HIS H" ).append("\n"); 
		query.append("                                                                WHERE    H.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("                                                                AND      H.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND      H.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND      H.VPS_PORT_CD  = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND      H.CLPT_IND_SEQ = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND      H.CNG_SEQ      = (SELECT  MAX(HH.CNG_SEQ)" ).append("\n"); 
		query.append("                                                                                            FROM    VSK_ACT_PORT_SKD_HIS  HH" ).append("\n"); 
		query.append("                                                                                            WHERE   HH.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("                                                                                            AND     HH.SKD_VOY_NO   = H.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                            AND     HH.SKD_DIR_CD   = H.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                            AND     HH.VPS_PORT_CD  = H.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                                            AND     HH.CLPT_IND_SEQ = H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                                            AND     HH.HIS_CRE_RSN_CD     = 'I'" ).append("\n"); 
		query.append("                                                                                            )			                  " ).append("\n"); 
		query.append("                   ),VPS_ETA_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("      	        END" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("               , BKG_VVD BV" ).append("\n"); 
		query.append("           WHERE BK.BKG_NO            = BV.BKG_NO" ).append("\n"); 
		query.append("             AND BK.POD_CD            = BV.POD_CD" ).append("\n"); 
		query.append("             AND BV.VSL_PRE_PST_CD   IN ('T')" ).append("\n"); 
		query.append("             AND BV.VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("             AND BV.SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND BV.SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND BV.POD_CD           = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND DECODE(BV.POD_CLPT_IND_SEQ, NULL, 1, 0, 1, BV.POD_CLPT_IND_SEQ) = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND T1.VSL_CD       = T2.VSL_CD(+)" ).append("\n"); 
		query.append("             AND T1.SKD_VOY_NO   = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("             AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("             AND T1.VPS_PORT_CD  = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("             AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("             AND ROWNUM               = 1 )   AS POD_ETA_DT " ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR (T2.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD T2" ).append("\n"); 
		query.append("               , BKG_VVD BV" ).append("\n"); 
		query.append("           WHERE BK.BKG_NO            = BV.BKG_NO" ).append("\n"); 
		query.append("             AND BK.POD_CD            = BV.POD_CD" ).append("\n"); 
		query.append("             AND BV.VSL_PRE_PST_CD   IN ('T')" ).append("\n"); 
		query.append("             AND BV.VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("             AND BV.SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND BV.SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND BV.POD_CD           = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND DECODE(BV.POD_CLPT_IND_SEQ, NULL, 1, 0, 1, BV.POD_CLPT_IND_SEQ) = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND T1.VSL_CD       = T2.VSL_CD(+)" ).append("\n"); 
		query.append("             AND T1.SKD_VOY_NO   = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("             AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("             AND T1.VPS_PORT_CD  = T2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("             AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("             AND ROWNUM               = 1 )   AS POD_ATA_DT" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("	, bkg_vvd vvd" ).append("\n"); 
		query.append("	, bkg_rate rt" ).append("\n"); 
		query.append("	, bkg_container cntr" ).append("\n"); 
		query.append("where bk.bkg_no = rt.bkg_no(+)" ).append("\n"); 
		query.append("and   bk.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("and   bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and   vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND    bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND    bk.bl_no = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and   bk.bkg_cgo_tp_cd = 'P'" ).append("\n"); 
		query.append("and   rownum = 1" ).append("\n"); 

	}
}