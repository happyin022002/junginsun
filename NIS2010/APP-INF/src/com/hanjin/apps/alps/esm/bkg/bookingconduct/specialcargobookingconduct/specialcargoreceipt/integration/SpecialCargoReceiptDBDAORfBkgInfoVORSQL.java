/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAORfBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAORfBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RfBkgInfoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAORfBkgInfoVORSQL(){
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
		query.append("FileName : SpecialCargoReceiptDBDAORfBkgInfoVORSQL").append("\n"); 
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
		query.append("select a.BKG_NO" ).append("\n"); 
		query.append(",   a.BL_NO" ).append("\n"); 
		query.append(",	a.BKG_STS_CD" ).append("\n"); 
		query.append(",   a.VSL_CD" ).append("\n"); 
		query.append(",   a.VESSEL_NM" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.POL_CD" ).append("\n"); 
		query.append(",	a.POL_NOD_CD" ).append("\n"); 
		query.append(",	a.POD_CD" ).append("\n"); 
		query.append(",	a.POD_NOD_CD" ).append("\n"); 
		query.append(",   a.POR_CD" ).append("\n"); 
		query.append(",   a.DEL_CD" ).append("\n"); 
		query.append(",   a.CMDT_CD" ).append("\n"); 
		query.append(",   a.CMDT_NM" ).append("\n"); 
		query.append(",   b.CORR_N1ST_DT" ).append("\n"); 
		query.append(",	b.CORR_NO" ).append("\n"); 
		query.append(",   b.BDR_FLG" ).append("\n"); 
		query.append(",   c.BKG_NO" ).append("\n"); 
		query.append(",   c.PCK_QTY" ).append("\n"); 
		query.append(",   c.PCK_TP_CD" ).append("\n"); 
		query.append(",   c.GRS_WGT" ).append("\n"); 
		query.append(",   c.WGT_UT_CD" ).append("\n"); 
		query.append(",	d.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",   NVL(( SELECT 'Y' FROM BKG_VVD WHERE BKG_NO = @[bkg_no] AND POD_CD LIKE 'KR%' AND ROWNUM=1), 'N') AS KR_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y' FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CMDT_CD IN ( SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'RF_CMDT_CHK' )" ).append("\n"); 
		query.append("AND ROWNUM=1 ), 'N') AS CMDT_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("FROM ( SELECT UPPER(A.CSTMS_DESC||B.CMDT_DESC) AS CMDT_DESC" ).append("\n"); 
		query.append("FROM BKG_BL_DOC A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no] ) XX" ).append("\n"); 
		query.append("WHERE XX.CMDT_DESC LIKE '%CRAB%' AND ROWNUM=1 ) ,'N') AS DESC_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y' FROM BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("WHERE IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IMG.RIDR_TP_CD = 'C' AND ROWNUM=1 ),'N') AS CO_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("a.BKG_NO" ).append("\n"); 
		query.append(",   a.BL_NO" ).append("\n"); 
		query.append(",	a.BKG_STS_CD" ).append("\n"); 
		query.append(",   CONCAT(CONCAT(a.VSL_CD, a.SKD_VOY_NO),a.SKD_DIR_CD) VSL_CD" ).append("\n"); 
		query.append(",   (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = a.VSL_CD) VESSEL_NM" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.POL_CD" ).append("\n"); 
		query.append(",	SUBSTR(a.POL_NOD_CD, 6,2) POL_NOD_CD" ).append("\n"); 
		query.append(",	a.POD_CD" ).append("\n"); 
		query.append(",	SUBSTR(a.POD_NOD_CD, 6,2) POD_NOD_CD" ).append("\n"); 
		query.append(",   a.POR_CD" ).append("\n"); 
		query.append(",   a.DEL_CD" ).append("\n"); 
		query.append(",   a.CMDT_CD" ).append("\n"); 
		query.append(",   b.CMDT_NM" ).append("\n"); 
		query.append(",   a.CORR_NO" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS a, MDM_COMMODITY b" ).append("\n"); 
		query.append("where a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and   a.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("and   a.CMDT_CD = b.CMDT_CD" ).append("\n"); 
		query.append(") a," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   CORR_N1ST_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(",   BDR_FLG" ).append("\n"); 
		query.append("from BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append(") b," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   sum(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",   PCK_TP_CD" ).append("\n"); 
		query.append(",   sum(GRS_WGT) GRS_WGT" ).append("\n"); 
		query.append(",   WGT_UT_CD" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append("from bkg_rf_cgo_his" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   PCK_TP_CD" ).append("\n"); 
		query.append(",   WGT_UT_CD" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BV.VSL_PRE_PST_CD, BV.BKG_NO, BK.CORR_NO" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append(",BKG_VVD BV" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE SL" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and   BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BV.SLAN_CD = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND SL.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND SL.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("AND BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("where a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and a.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("and a.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("and a.BKG_NO = d.BKG_NO(+)" ).append("\n"); 
		query.append("and b.BKG_NO = c.BKG_NO(+)" ).append("\n"); 
		query.append("and a.CORR_NO = b.CORR_NO" ).append("\n"); 
		query.append("and b.CORR_NO = c.CORR_NO(+)" ).append("\n"); 
		query.append("and a.CORR_NO = d.CORR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select a.BKG_NO" ).append("\n"); 
		query.append(",   a.BL_NO" ).append("\n"); 
		query.append(",	a.BKG_STS_CD" ).append("\n"); 
		query.append(",   a.VSL_CD" ).append("\n"); 
		query.append(",   a.VESSEL_NM" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.POL_CD" ).append("\n"); 
		query.append(",	a.POL_NOD_CD" ).append("\n"); 
		query.append(",	a.POD_CD" ).append("\n"); 
		query.append(",	a.POD_NOD_CD" ).append("\n"); 
		query.append(",   a.POR_CD" ).append("\n"); 
		query.append(",   a.DEL_CD" ).append("\n"); 
		query.append(",   a.CMDT_CD" ).append("\n"); 
		query.append(",   a.CMDT_NM" ).append("\n"); 
		query.append(",   b.CORR_N1ST_DT" ).append("\n"); 
		query.append(",	b.CORR_NO" ).append("\n"); 
		query.append(",   b.BDR_FLG" ).append("\n"); 
		query.append(",   c.BKG_NO" ).append("\n"); 
		query.append(",   c.PCK_QTY" ).append("\n"); 
		query.append(",   c.PCK_TP_CD" ).append("\n"); 
		query.append(",   c.GRS_WGT" ).append("\n"); 
		query.append(",   c.WGT_UT_CD" ).append("\n"); 
		query.append(",	d.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",   NVL(( SELECT 'Y' FROM BKG_VVD WHERE BKG_NO = @[bkg_no] AND POD_CD LIKE 'KR%' AND ROWNUM=1), 'N') AS KR_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y' FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CMDT_CD IN ( SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'RF_CMDT_CHK')" ).append("\n"); 
		query.append("AND ROWNUM=1 ), 'N') AS CMDT_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("FROM ( SELECT UPPER(A.CSTMS_DESC||B.CMDT_DESC) AS CMDT_DESC" ).append("\n"); 
		query.append("FROM BKG_BL_DOC A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no] ) XX" ).append("\n"); 
		query.append("WHERE XX.CMDT_DESC LIKE '%CRAB%' AND ROWNUM=1 ) ,'N') AS DESC_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(( SELECT 'Y' FROM BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("WHERE IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IMG.RIDR_TP_CD = 'C' AND ROWNUM=1 ),'N') AS CO_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("a.BKG_NO" ).append("\n"); 
		query.append(",   a.BL_NO" ).append("\n"); 
		query.append(",	a.BKG_STS_CD" ).append("\n"); 
		query.append(",   CONCAT(CONCAT(a.VSL_CD, a.SKD_VOY_NO),a.SKD_DIR_CD) VSL_CD" ).append("\n"); 
		query.append(",   (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = a.VSL_CD) VESSEL_NM" ).append("\n"); 
		query.append(",	a.RCV_TERM_CD" ).append("\n"); 
		query.append(",	a.DE_TERM_CD" ).append("\n"); 
		query.append(",	a.POL_CD" ).append("\n"); 
		query.append(",	SUBSTR(a.POL_NOD_CD, 6,2) POL_NOD_CD" ).append("\n"); 
		query.append(",	a.POD_CD" ).append("\n"); 
		query.append(",	SUBSTR(a.POD_NOD_CD, 6,2) POD_NOD_CD" ).append("\n"); 
		query.append(",   a.POR_CD" ).append("\n"); 
		query.append(",   a.DEL_CD" ).append("\n"); 
		query.append(",   a.CMDT_CD" ).append("\n"); 
		query.append(",   b.CMDT_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING a, MDM_COMMODITY b" ).append("\n"); 
		query.append("where a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and   a.CMDT_CD = b.CMDT_CD" ).append("\n"); 
		query.append(") a," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   CORR_N1ST_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(",   BDR_FLG" ).append("\n"); 
		query.append("from BKG_BL_DOC" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(") b," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   sum(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",   PCK_TP_CD" ).append("\n"); 
		query.append(",   sum(GRS_WGT) GRS_WGT" ).append("\n"); 
		query.append(",   WGT_UT_CD" ).append("\n"); 
		query.append("from bkg_rf_cgo" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   PCK_TP_CD" ).append("\n"); 
		query.append(",   WGT_UT_CD" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BV.VSL_PRE_PST_CD, BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_VVD BV" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE SL" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BV.SLAN_CD = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND SL.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND SL.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("AND BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("where a.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and a.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("and a.BKG_NO = d.BKG_NO(+)" ).append("\n"); 
		query.append("and b.BKG_NO = c.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}