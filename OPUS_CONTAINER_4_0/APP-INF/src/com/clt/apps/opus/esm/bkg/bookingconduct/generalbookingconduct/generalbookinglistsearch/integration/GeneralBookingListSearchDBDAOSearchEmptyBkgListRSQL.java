/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2017.01.03 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty REPO BKG Inquiry
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL").append("\n"); 
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
		query.append("select DISTINCT bk.bkg_no" ).append("\n"); 
		query.append("        , bk.bl_no" ).append("\n"); 
		query.append("        , bk.MTY_BKG_STS_CD    ind" ).append("\n"); 
		query.append("        , decode(bk.MTY_BKG_STS_CD, 'S', 'Sound', 'H', 'Hanger Rack', 'D', 'Damaged') ind_desc" ).append("\n"); 
		query.append("        , nvl((select 'Y' " ).append("\n"); 
		query.append("                 from bkg_container cntr" ).append("\n"); 
		query.append("                where bk.bkg_no = cntr.bkg_no " ).append("\n"); 
		query.append("                  and MCNTR_BDL_NO is not null " ).append("\n"); 
		query.append("                  and rownum = 1), 'N') bundle" ).append("\n"); 
		query.append("        , case when (select count(1) " ).append("\n"); 
		query.append("                       from bkg_vvd vvd " ).append("\n"); 
		query.append("                      where bk.bkg_no = vvd.bkg_no) > 1 then 'Y'  " ).append("\n"); 
		query.append("               else 'N' end ts" ).append("\n"); 
		query.append("        , bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd vvd" ).append("\n"); 
		query.append("        , (select slan_cd from vsk_vsl_skd skd where skd.vsl_cd = bk.vsl_cd and skd.skd_voy_no = bk.skd_voy_no and skd_dir_cd = bk.skd_dir_cd) lane" ).append("\n"); 
		query.append("        , bk.MTY_SPLIT_AVAL_CD emt" ).append("\n"); 
		query.append("        , decode(bk.MTY_SPLIT_AVAL_CD, 'W', 'Water', 'Z', 'Single POD', 'C', 'Multi POD') emt_desc" ).append("\n"); 
		query.append("        , BK.POL_CD||SUBSTR(bk.pol_nod_cd, 6, 2) pol_cd" ).append("\n"); 
		query.append("        ,(SELECT CASE 	WHEN NVL2(T2.VSL_CD,'Y','N') = 'N' THEN 	TO_CHAR(T1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
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
		query.append("             AND ROWNUM               = 1 )   AS POD_ETA_DT" ).append("\n"); 
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
		query.append("        , BK.POD_CD||SUBSTR(bk.pod_nod_cd, 6, 2) pod_cd" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("			(select sum(decode(substr(cntr_tpsz_cd, 2, 1), '2', 1, 0)) " ).append("\n"); 
		query.append("               from bkg_container cntr" ).append("\n"); 
		query.append("              where bk.bkg_no = cntr.bkg_no)" ).append("\n"); 
		query.append("			, (select sum(decode(substr(cntr_tpsz_cd, 2, 1), '2', op_cntr_qty, 0)) " ).append("\n"); 
		query.append("               from bkg_quantity qty" ).append("\n"); 
		query.append("              where bk.bkg_no = qty.bkg_no)" ).append("\n"); 
		query.append("			) teu        " ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("			(select sum(decode(substr(cntr_tpsz_cd, 2, 1), '2', 0, 1)) " ).append("\n"); 
		query.append("               from bkg_container cntr" ).append("\n"); 
		query.append("              where bk.bkg_no = cntr.bkg_no)" ).append("\n"); 
		query.append("			, (select sum(decode(substr(cntr_tpsz_cd, 2, 1), '2', 0, op_cntr_qty)) " ).append("\n"); 
		query.append("               from bkg_quantity qty" ).append("\n"); 
		query.append("              where bk.bkg_no = qty.bkg_no)" ).append("\n"); 
		query.append("			) feu" ).append("\n"); 
		query.append("		, NVL((SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = bk.bkg_ofc_cd),'') AS rsm_ofc_cd" ).append("\n"); 
		query.append("        , bk.bkg_ofc_cd" ).append("\n"); 
		query.append("        , substr(BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||':'||SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("                                       FROM BKG_quantity qty" ).append("\n"); 
		query.append("                                      WHERE bk.bkg_no = qty.bkg_no" ).append("\n"); 
		query.append("                                      group by cntr_tpsz_cd)), 1, 200) cntr_volumn" ).append("\n"); 
		query.append("        , to_char(bk.bkg_cre_dt, 'yyyymmdd hh24:mi') booking_date" ).append("\n"); 
		query.append("        , NVL((select to_char(max(cntr.CGO_RCV_DT), 'yyyymmdd hh24:mi')" ).append("\n"); 
		query.append("	             from bkg_container cntr" ).append("\n"); 
		query.append("	            where bk.bkg_no = cntr.bkg_no)			" ).append("\n"); 
		query.append("			, (select to_char(bkg_cre_dt, 'yyyymmdd hh24:mi')" ).append("\n"); 
		query.append("				 from bkg_booking dt, bkg_container cntr" ).append("\n"); 
		query.append("				where dt.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                  and dt.bkg_no = cntr.bkg_no" ).append("\n"); 
		query.append("				  and rownum = 1)) cntr_attach_date" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'D2') D2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'D4') D4" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'D5') D5" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'D7') D7" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'R2') R2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'R4') R4" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'R5') R5" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'F2') F2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'F4') F4" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'F5') F5" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'O2') O2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'O4') O4" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'A2') A2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'A4') A4" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'S2') S2" ).append("\n"); 
		query.append("        , (select count(1) from bkg_container cntr where bk.bkg_no = cntr.bkg_no and cntr.cntr_tpsz_cd = 'S4') S4" ).append("\n"); 
		query.append("        , substr(bk.inter_rmk, 1, 300) remark" ).append("\n"); 
		query.append("  from bkg_booking bk, " ).append("\n"); 
		query.append("(select bk.bkg_no, bk.fm_bkg_no" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')  " ).append("\n"); 
		query.append("	     , bkg_vvd vvd  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_no1} != '')   " ).append("\n"); 
		query.append("	     , bkg_container cntr" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_date_tp} == 'E')" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
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
		query.append("			#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("			   and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			   and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			   and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("		   		and skd.vps_eta_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("		   		and skd.vps_eta_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		) eta" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" where bk.bkg_cgo_tp_cd = 'P'" ).append("\n"); 
		query.append("   and 'Y' = case when bk.split_flg = 'Y' and bk.bkg_sts_cd = 'X' then 'Y'--split인데 cancel된 건 -> master bkg -> 조회됨" ).append("\n"); 
		query.append("				  when bk.split_flg = 'N' and bk.bkg_sts_Cd = 'X' then 'N'--split이 아닌데 cancel된 건 -> 일반 cancel -> 조회안됨" ).append("\n"); 
		query.append("				  else 'Y' end --그외 조회됨" ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("   and bk.bkg_no LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if  (${bl_no} != '')    " ).append("\n"); 
		query.append("   and bk.bl_no LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	   and bk.bkg_no     = vvd.bkg_no   " ).append("\n"); 
		query.append("	   and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	   and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	   and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_no1} != '') " ).append("\n"); 
		query.append("	   and bk.bkg_no = cntr.bkg_no" ).append("\n"); 
		query.append("	   and cntr.cntr_no = @[cntr_no1]||@[cntr_no2]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	   and bk.pol_cd LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("	   and bk.pod_cd LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pre_rly_port_cd} != '') " ).append("\n"); 
		query.append("	   and bk.pre_rly_port_cd LIKE @[pre_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pst_rly_port_cd} != '') " ).append("\n"); 
		query.append("	   and bk.pst_rly_port_cd LIKE @[pst_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd} == '')" ).append("\n"); 
		query.append("		#if (${bkg_date_tp} != 'E')		" ).append("\n"); 
		query.append("			#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("		   		and bk.bkg_cre_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("		   		and bk.bkg_cre_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			and bk.bkg_no = eta.bkg_no" ).append("\n"); 
		query.append("			and bk.pod_cd = eta.pod_cd" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd} != '')  " ).append("\n"); 
		query.append("		   and bk.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vvd_cd_flg} == 'E')  " ).append("\n"); 
		query.append("	   and vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cntr_attach} == 'Y')  " ).append("\n"); 
		query.append("	   and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) > 0" ).append("\n"); 
		query.append("	#elseif  (${cntr_attach} == 'N')  " ).append("\n"); 
		query.append("	   and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) = 0   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") mst_bkg" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '') " ).append("\n"); 
		query.append(" where bk.bkg_no = mst_bkg.bkg_no" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" where (bk.bkg_no = mst_bkg.bkg_no or bk.fm_bkg_no = mst_bkg.bkg_no or mst_bkg.fm_bkg_no = bk.bkg_no)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--	or (length(mst_bkg.bkg_no) = 13 and bk.bkg_no = substr(mst_bkg.bkg_no, 1, 11))" ).append("\n"); 

	}
}