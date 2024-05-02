/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.06.27 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cargo closing time을 계산하여 넣는다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL").append("\n"); 
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
		query.append("update bkg_clz_tm" ).append("\n"); 
		query.append("   set CLZ_YD_CD = case when clz_tp_cd = 'F' then (SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("													 from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("												        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("												        , sce_cop_hdr cop " ).append("\n"); 
		query.append("													where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("													  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("													  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("													  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("													  and cop.bkg_no         = @[bkg_no]" ).append("\n"); 
		query.append("													  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("													  and dtl.pctl_seq = (select min(fst.pctl_seq)" ).append("\n"); 
		query.append("													                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("													                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("													                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("													                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  													  and rownum = 1)" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'O' THEN (SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("													 from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("												        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("												        , sce_cop_hdr cop " ).append("\n"); 
		query.append("													where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("													  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("													  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("													  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("													  and cop.bkg_no         = @[bkg_no]  " ).append("\n"); 
		query.append("													  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("													  and dtl.pctl_seq = (select min(fst.pctl_seq)" ).append("\n"); 
		query.append("													                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("													                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("													                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("													                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  													  and rownum = 1)" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'R' THEN (SELECT FULL_RTN_YD_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'T' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'D' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                        WHEN CLZ_TP_CD = 'V' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'E' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'M' THEN (SELECT mty_pkup_yd_cd FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'L' THEN (SELECT pol_cd         FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						ELSE '' END" ).append("\n"); 
		query.append("     , sys_set_dt = case " ).append("\n"); 
		query.append("#if (${from_dt} != 'N') " ).append("\n"); 
		query.append("                        when clz_tp_cd = 'F' then to_date(@[from_dt], 'yyyymmddhh24mi')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						when clz_tp_cd = 'F' then sys_set_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != 'N')" ).append("\n"); 
		query.append("                        when clz_tp_cd = 'O' then to_date(@[to_dt]  , 'yyyymmddhh24mi')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						when clz_tp_cd = 'O' then sys_set_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        when clz_tp_cd = 'M' then (SELECT mty_pkup_dt FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                        when clz_tp_cd = 'T' then (SELECT CASE WHEN 'KR' = (SELECT SUBSTR(POL_CD,1,2) FROM BKG_BOOKING WHERE BKG_NO =  @[bkg_no] ) THEN ETB -0.41667 " ).append("\n"); 
		query.append("													 ELSE CCT" ).append("\n"); 
		query.append("													 END CCT" ).append("\n"); 
		query.append("													 FROM (select PRD_GET_CCT_FNC(skd.pol_nod_cd, SKD.SLAN_CD, SKD.SLAN_DIR_CD, SKD.CGO_TP_CD, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT, SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD) CCT, SKD.VPS_ETB_DT ETB" ).append("\n"); 
		query.append("                                                     from (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('HJXX','HJYY','HJZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = @[bkg_no]) skd))" ).append("\n"); 
		query.append("                         when clz_tp_cd = 'R' then DECODE(NVL(@[to_dt], 'N'), 'N', --RAIL TIME이 없는 경우 PRD 계산 로직" ).append("\n"); 
		query.append("												   (SELECT DECODE(BK.FULL_RTN_YD_CD, BK.POL_NOD_CD, " ).append("\n"); 
		query.append("													--RETURN CY가 POL_NOD_CD가 같을 경우" ).append("\n"); 
		query.append("													(select PRD_GET_CCT_FNC(skd.pol_nod_cd, SKD.SLAN_CD, SKD.SLAN_DIR_CD, SKD.CGO_TP_CD, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT, SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                                     from (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('HJXX','HJYY','HJZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = @[bkg_no]) skd)," ).append("\n"); 
		query.append("													--RETURN CY가 POL_NOD_CD가 다를 경우" ).append("\n"); 
		query.append("													(SELECT ARR_ST_DT -12/24" ).append("\n"); 
		query.append("												      FROM PRD_PROD_CTL_ROUT_DTL DTL, BKG_BOOKING BK" ).append("\n"); 
		query.append("												     WHERE DTL.PCTL_NO        = BK.PCTL_NO" ).append("\n"); 
		query.append("													   AND DTL.ORG_NOD_CD     = BK.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("													   AND BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("													   AND DTL.NOD_LNK_DIV_CD ='N'" ).append("\n"); 
		query.append("													   AND DTL.MTY_YD_FLG <> 'Y'" ).append("\n"); 
		query.append("													   AND ROWNUM = 1 )) FROM BKG_BOOKING BK WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("													, to_date(@[to_dt], 'yyyymmddhh24mi')) --RAIL TO CCT" ).append("\n"); 
		query.append("						 WHEN CLZ_TP_CD = 'D' THEN (SELECT BKG_GET_DCT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_CD, TO_CHAR(VVD.POL_CLPT_IND_SEQ), BK.POD_CD) " ).append("\n"); 
		query.append("													  FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("													 WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("													   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("													   AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("													   AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("													   AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("														                                        FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("														                                       WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("													                                             AND VVD.POL_CD = VVD2.POL_CD)" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("                         WHEN CLZ_TP_CD = 'V' THEN (SELECT BKG_GET_VRFD_WGT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_CD, TO_CHAR(VVD.POL_CLPT_IND_SEQ), BK.POD_CD) " ).append("\n"); 
		query.append("													  FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("													 WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("													   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("													   AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("													   AND BK.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("													   AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("														                                        FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("														                                       WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("													                                             AND VVD.POL_CD = VVD2.POL_CD)" ).append("\n"); 
		query.append("                                                       AND  (SELECT VPS_ETD_DT" ).append("\n"); 
		query.append("                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                              WHERE VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                                              AND SKD_VOY_NO= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                              AND SKD_DIR_CD= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                              AND VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                              AND CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ ) >=TO_DATE('20160701','YYYYMMDD')--7/1이후 출항부터 적용" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("                         when clz_tp_cd = 'L' then (SELECT TO_DATE(PRD_GET_ERD_FNC(POR_CD, POL_CD, FIRST_VVD" ).append("\n"); 
		query.append("                                                                                         , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                                                WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                                                WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                                                ELSE 'AL' END ),'YYYY-MM-DD HH24:MI') ERD " ).append("\n"); 
		query.append("                                                      FROM (SELECT BK.BKG_NO, BK.POR_CD, VVD.POL_CD, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("                                                                 , DCGO_FLG, RC_FLG, AWK_CGO_FLG, BB_CGO_FLG" ).append("\n"); 
		query.append("                                                              FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("                                                             WHERE BK.BKG_NO   = VVD.BKG_NO(+)" ).append("\n"); 
		query.append("                                                               AND BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                                                               AND VVD.VSL_SEQ = (SELECT MIN(VSL_SEQ) " ).append("\n"); 
		query.append("                                                                                    FROM BKG_VVD " ).append("\n"); 
		query.append("                                                                                   WHERE BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("                                                           )" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("                    end " ).append("\n"); 
		query.append("     , SYS_SET_DT_DESC = case when clz_tp_cd = 'V' -- 첫VVD 없으면 VGM 계산설명 UPDATE" ).append("\n"); 
		query.append("                               and (SELECT VVD.VSL_CD" ).append("\n"); 
		query.append("								      FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								     WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								       AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("								       AND BK.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("								       AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("								  				                                FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("													                           WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("													                             AND VVD.POL_CD = VVD2.POL_CD)" ).append("\n"); 
		query.append("                                   ) IS NULL THEN ( SELECT SYS_SET_DESC" ).append("\n"); 
		query.append("                                                      FROM ( SELECT CASE WHEN VGM_CLZ_TP_CD = 'B' THEN 'ETB '|| VGM_ITVAL_HRS || ' Hour'--ETB" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'D' THEN 'ETD '|| VGM_ITVAL_HRS || ' Hour' --ETD" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'A' THEN 'ETA '|| VGM_ITVAL_HRS || ' Hour' --ETA" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '1DA' THEN '1 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETA - 1" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '2DA' THEN '2 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETA - 2" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '3DA' THEN '3 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETA - 3" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '4DA' THEN '4 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETA - 4" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '1DB' THEN '1 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETB - 1 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '2DB' THEN '2 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETB - 2 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '3DB' THEN '3 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETB - 3 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '4DB' THEN '4 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETB - 4 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '1DD' THEN '1 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETD - 1 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '2DD' THEN '2 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETD - 2 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '3DD' THEN '3 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETD - 3 " ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = '4DD' THEN '4 day before ETA '|| LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0) --ETD - 4" ).append("\n"); 
		query.append("                                                                         WHEN VGM_CLZ_TP_CD = 'Y' AND VGM_CLZ_DY_CD = 'MON' OR VGM_CLZ_DY_CD = 'TUE' OR VGM_CLZ_DY_CD = 'WED' OR VGM_CLZ_DY_CD = 'THU' OR VGM_CLZ_DY_CD = 'FRI' " ).append("\n"); 
		query.append("                                                                             OR VGM_CLZ_DY_CD = 'SAT' OR VGM_CLZ_DY_CD = 'SUN' THEN VGM_CLZ_DY_CD || ' ' || LPAD(VGM_CLZ_DY_HRS/(60),2,0)||':'||LPAD(MOD(VGM_CLZ_DY_HRS,60),2,0)   " ).append("\n"); 
		query.append("                                                                   END SYS_SET_DESC  " ).append("\n"); 
		query.append("                                                                 , DECODE(CLZ_SET.YD_CD,       '*', 2, 1) ORD1" ).append("\n"); 
		query.append("                                                                 --, DECODE(CLZ_SET.VVD_CD,      '*', 2, 1) ORD2" ).append("\n"); 
		query.append("                                                                 , DECODE(CLZ_SET.VSL_SLAN_CD, '*', 2, 1) ORD3" ).append("\n"); 
		query.append("                                                                 , DECODE(CLZ_SET.CONTI_CD,    '*', 2, 1) ORD4 " ).append("\n"); 
		query.append("                                                                 , DECODE(CLZ_SET.DEST_CNT_CD, '*', 2, 1) ORD5  " ).append("\n"); 
		query.append("                                                              FROM BKG_VRFD_WGT_CLZ_SET CLZ_SET " ).append("\n"); 
		query.append("                                                                 , BKG_BOOKING          BKG" ).append("\n"); 
		query.append("                                                             WHERE BKG.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.LOC_CD      = SUBSTR(BKG.POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.YD_CD       = DECODE(CLZ_SET.YD_CD, '*', CLZ_SET.YD_CD, BKG.POL_NOD_CD)" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.VSL_SLAN_CD = DECODE(CLZ_SET.VSL_SLAN_CD, '*', CLZ_SET.VSL_SLAN_CD, (SELECT VVD.SLAN_CD" ).append("\n"); 
		query.append("								                                                                                                                  FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								                                                                                                                 WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								                                                                                                                   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								                                                                                                                   AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("								                                                                                                                   AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                                                                                                   AND ROWNUM = 1))" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.DEST_CNT_CD = DECODE(CLZ_SET.DEST_CNT_CD, '*', CLZ_SET.DEST_CNT_CD, SUBSTR(BKG.POD_NOD_CD, 1, 2))" ).append("\n"); 
		query.append("                                                               --AND CLZ_SET.VVD_CD      = DECODE(CLZ_SET.VVD_CD, '*', CLZ_SET.VVD_CD, 'HCHU0004W')" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.CONTI_CD    = DECODE(CLZ_SET.CONTI_CD,    '*', CLZ_SET.CONTI_CD, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(BKG.POD_NOD_CD,1,5)))" ).append("\n"); 
		query.append("                                                               AND CLZ_SET.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                                             ORDER BY ORD1, ORD3, ORD4, ORD5)" ).append("\n"); 
		query.append("                                                     WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                              else NULL " ).append("\n"); 
		query.append("                    end" ).append("\n"); 
		query.append("     , NTC_FLG = case when clz_tp_cd = 'F' " ).append("\n"); 
		query.append("                       and @[from_dt] IS NULL then 'N'" ).append("\n"); 
		query.append("                      when clz_tp_cd = 'O' " ).append("\n"); 
		query.append("                       and @[to_dt] IS NULL then 'N'" ).append("\n"); 
		query.append("                      else NTC_FLG" ).append("\n"); 
		query.append("                 end                 " ).append("\n"); 
		query.append("     , upd_dt = sysdate" ).append("\n"); 
		query.append("     , upd_usr_id = NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" where bkg_no = @[bkg_no]  " ).append("\n"); 
		query.append("   and clz_tp_cd in ('O', 'F', 'T', 'R', 'D', 'V', 'E', 'M', 'L')" ).append("\n"); 

	}
}