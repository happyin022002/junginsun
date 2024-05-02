/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.19 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAODgBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgBkgInfoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgBkgInfoVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgBkgInfoVORSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   A.BKG_NO" ).append("\n"); 
		query.append("       , A.BL_NO" ).append("\n"); 
		query.append("       , A.BKG_STS_CD" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.VESSEL_NM " ).append("\n"); 
		query.append("       , A.RCV_TERM_CD" ).append("\n"); 
		query.append("       , A.DE_TERM_CD" ).append("\n"); 
		query.append("       , A.POL_CD" ).append("\n"); 
		query.append("       , A.POL_NOD_CD" ).append("\n"); 
		query.append("       , A.POD_CD" ).append("\n"); 
		query.append("       , A.POD_NOD_CD" ).append("\n"); 
		query.append("       , A.POR_CD" ).append("\n"); 
		query.append("       , A.DEL_CD" ).append("\n"); 
		query.append("       , A.CMDT_CD" ).append("\n"); 
		query.append("       , A.CMDT_NM" ).append("\n"); 
		query.append("       , A.FLEX_HGT_FLG" ).append("\n"); 
		query.append("       , A.SLAN_CD" ).append("\n"); 
		query.append("       , DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("       , B.CORR_N1ST_DT" ).append("\n"); 
		query.append("       , B.CORR_NO" ).append("\n"); 
		query.append("       , B.BDR_FLG" ).append("\n"); 
		query.append("       , C.BKG_NO" ).append("\n"); 
		query.append("       , C.GRS_WGT" ).append("\n"); 
		query.append("       , C.WGT_UT_CD" ).append("\n"); 
		query.append("       , D.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("       , NVL((SELECT 'Y' FROM BKG_IMG_STO K WHERE K.BKG_NO = A.BKG_NO AND K.RIDR_TP_CD ='D' AND ROWNUM =1 ),'N') IMG_FLG" ).append("\n"); 
		query.append("       , A.CRR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.OPR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.SEGR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.PCK_PRE_CHK_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    A.BKG_NO" ).append("\n"); 
		query.append("                  , A.BL_NO" ).append("\n"); 
		query.append("                  , A.BKG_STS_CD" ).append("\n"); 
		query.append("                  , CONCAT(CONCAT(A.VSL_CD, A.SKD_VOY_NO),A.SKD_DIR_CD) VSL_CD" ).append("\n"); 
		query.append("                  , (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD) VESSEL_NM " ).append("\n"); 
		query.append("                  , A.RCV_TERM_CD" ).append("\n"); 
		query.append("                  , A.DE_TERM_CD" ).append("\n"); 
		query.append("                  , A.POL_CD" ).append("\n"); 
		query.append("                  , SUBSTR(A.POL_NOD_CD, 6,2) POL_NOD_CD" ).append("\n"); 
		query.append("                  , A.POD_CD" ).append("\n"); 
		query.append("                  , SUBSTR(A.POD_NOD_CD, 6,2) POD_NOD_CD" ).append("\n"); 
		query.append("                  , A.POR_CD" ).append("\n"); 
		query.append("                  , A.DEL_CD" ).append("\n"); 
		query.append("                  , A.CMDT_CD" ).append("\n"); 
		query.append("                  , B.CMDT_NM" ).append("\n"); 
		query.append("                  , A.CORR_NO" ).append("\n"); 
		query.append("                  , A.FLEX_HGT_FLG" ).append("\n"); 
		query.append("                  , A.SLAN_CD" ).append("\n"); 
		query.append("                  , '' DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("		          , '' CRR_PRE_CHK_CD" ).append("\n"); 
		query.append("		          , '' OPR_PRE_CHK_CD" ).append("\n"); 
		query.append("		          , '' SEGR_PRE_CHK_CD" ).append("\n"); 
		query.append("		          , '' PCK_PRE_CHK_CD" ).append("\n"); 
		query.append("            FROM    BKG_BKG_HIS A" ).append("\n"); 
		query.append("                  , MDM_COMMODITY B" ).append("\n"); 
		query.append("            WHERE   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("            AND     A.CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , CORR_N1ST_DT" ).append("\n"); 
		query.append("                  , CORR_NO" ).append("\n"); 
		query.append("                  , BDR_FLG" ).append("\n"); 
		query.append("            FROM    BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("            WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("         ) B," ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , SUM(GRS_WGT) GRS_WGT" ).append("\n"); 
		query.append("                  , WGT_UT_CD" ).append("\n"); 
		query.append("                  , CORR_NO" ).append("\n"); 
		query.append("            FROM    BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("            WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , WGT_UT_CD" ).append("\n"); 
		query.append("                  , CORR_NO" ).append("\n"); 
		query.append("         ) C," ).append("\n"); 
		query.append("         (  SELECT  BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  , BV.BKG_NO" ).append("\n"); 
		query.append("                  , BK.CORR_NO" ).append("\n"); 
		query.append("            FROM    BKG_BKG_HIS BK" ).append("\n"); 
		query.append("                  , BKG_VVD BV" ).append("\n"); 
		query.append("                  , MDM_VSL_SVC_LANE SL" ).append("\n"); 
		query.append("            WHERE   BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("            AND     BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND     BV.SLAN_CD = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND     SL.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("            AND     SL.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("            AND     BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("WHERE    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND      A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND      A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("AND      B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND      A.CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("AND      A.CORR_NO = D.CORR_NO(+)" ).append("\n"); 
		query.append("AND      B.CORR_NO = C.CORR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   A.BKG_NO" ).append("\n"); 
		query.append("       , A.BL_NO" ).append("\n"); 
		query.append("       , A.BKG_STS_CD" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.VESSEL_NM " ).append("\n"); 
		query.append("       , A.RCV_TERM_CD" ).append("\n"); 
		query.append("       , A.DE_TERM_CD" ).append("\n"); 
		query.append("       , A.POL_CD" ).append("\n"); 
		query.append("       , A.POL_NOD_CD" ).append("\n"); 
		query.append("       , A.POD_CD" ).append("\n"); 
		query.append("       , A.POD_NOD_CD" ).append("\n"); 
		query.append("       , A.POR_CD" ).append("\n"); 
		query.append("       , A.DEL_CD" ).append("\n"); 
		query.append("       , A.CMDT_CD" ).append("\n"); 
		query.append("       , A.CMDT_NM" ).append("\n"); 
		query.append("       , A.FLEX_HGT_FLG" ).append("\n"); 
		query.append("       , A.SLAN_CD" ).append("\n"); 
		query.append("       , A.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("       , B.CORR_N1ST_DT" ).append("\n"); 
		query.append("       , B.CORR_NO" ).append("\n"); 
		query.append("       , B.BDR_FLG" ).append("\n"); 
		query.append("       , C.BKG_NO" ).append("\n"); 
		query.append("       , C.GRS_WGT" ).append("\n"); 
		query.append("       , C.WGT_UT_CD" ).append("\n"); 
		query.append("       , D.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("       , NVL((SELECT 'Y' FROM BKG_IMG_STO K WHERE K.BKG_NO = A.BKG_NO AND K.RIDR_TP_CD ='D' AND ROWNUM =1 ),'N') IMG_FLG" ).append("\n"); 
		query.append("       , A.CRR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.OPR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.SEGR_PRE_CHK_CD" ).append("\n"); 
		query.append("       , A.PCK_PRE_CHK_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    A.BKG_NO" ).append("\n"); 
		query.append("                  , A.BL_NO" ).append("\n"); 
		query.append("                  , A.BKG_STS_CD" ).append("\n"); 
		query.append("                  , CONCAT(CONCAT(A.VSL_CD, A.SKD_VOY_NO),A.SKD_DIR_CD) VSL_CD" ).append("\n"); 
		query.append("                  , (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD) VESSEL_NM " ).append("\n"); 
		query.append("                  , A.RCV_TERM_CD" ).append("\n"); 
		query.append("                  , A.DE_TERM_CD" ).append("\n"); 
		query.append("                  , A.POL_CD" ).append("\n"); 
		query.append("                  , SUBSTR(A.POL_NOD_CD, 6,2) POL_NOD_CD" ).append("\n"); 
		query.append("                  , A.POD_CD" ).append("\n"); 
		query.append("                  , SUBSTR(A.POD_NOD_CD, 6,2) POD_NOD_CD" ).append("\n"); 
		query.append("                  , A.POR_CD" ).append("\n"); 
		query.append("                  , A.DEL_CD" ).append("\n"); 
		query.append("                  , A.CMDT_CD" ).append("\n"); 
		query.append("                  , B.CMDT_NM" ).append("\n"); 
		query.append("                  , A.FLEX_HGT_FLG" ).append("\n"); 
		query.append("                  , A.SLAN_CD" ).append("\n"); 
		query.append("                  , A.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("                  , A.CRR_PRE_CHK_CD" ).append("\n"); 
		query.append("                  , A.OPR_PRE_CHK_CD" ).append("\n"); 
		query.append("                  , A.SEGR_PRE_CHK_CD" ).append("\n"); 
		query.append("                  , A.PCK_PRE_CHK_CD" ).append("\n"); 
		query.append("            FROM    BKG_BOOKING A" ).append("\n"); 
		query.append("                  , MDM_COMMODITY B" ).append("\n"); 
		query.append("            WHERE   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     A.CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , CORR_N1ST_DT" ).append("\n"); 
		query.append("                  , CORR_NO" ).append("\n"); 
		query.append("                  , BDR_FLG" ).append("\n"); 
		query.append("            FROM    BKG_BL_DOC" ).append("\n"); 
		query.append("            WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         ) B," ).append("\n"); 
		query.append("         (  SELECT" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , SUM(GRS_WGT) GRS_WGT" ).append("\n"); 
		query.append("                  , WGT_UT_CD" ).append("\n"); 
		query.append("            FROM    BKG_DG_CGO" ).append("\n"); 
		query.append("            WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("                    BKG_NO" ).append("\n"); 
		query.append("                  , WGT_UT_CD" ).append("\n"); 
		query.append("         ) C," ).append("\n"); 
		query.append("         (  SELECT  BV.VSL_PRE_PST_CD, BV.BKG_NO" ).append("\n"); 
		query.append("            FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("                  , BKG_VVD BV" ).append("\n"); 
		query.append("                  , MDM_VSL_SVC_LANE SL" ).append("\n"); 
		query.append("            WHERE   BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND     BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND     BV.SLAN_CD = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("            AND     SL.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("            AND     SL.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("            AND     BV.VSL_PRE_PST_CD = 'U' " ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("WHERE    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND      A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("AND      B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}