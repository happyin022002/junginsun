/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyRfCgoByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.08 
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

public class SpecialCargoReceiptDBDAOcopyRfCgoByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyRfCgoByBkg
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyRfCgoByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyRfCgoByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_RF_CGO(BKG_NO" ).append("\n"); 
		query.append("        , RC_SEQ" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , CMDT_CD" ).append("\n"); 
		query.append("        , CMDT_DESC" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , FDO_TEMP" ).append("\n"); 
		query.append("        , CDO_TEMP" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("        , VENT_RTO" ).append("\n"); 
		query.append("        , HUMID_NO" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("        , RF_DCGO_SEQ" ).append("\n"); 
		query.append("        , PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("        , VLTG_NO" ).append("\n"); 
		query.append("        , CTRL_ATMS_FLG" ).append("\n"); 
		query.append("        , MODI_ATMS_FLG" ).append("\n"); 
		query.append("        , HUMID_CTRL_FLG" ).append("\n"); 
		query.append("        , CNTR_DRN_CD" ).append("\n"); 
		query.append("        , CLNG_TP_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , CNTR_VOL_QTY" ).append("\n"); 
		query.append("        , CBM_PER_HR_QTY" ).append("\n"); 
		query.append("        , ATFC_ATMS_FLG)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append("		,(SELECT /*+index_desc (bkg_rf_cgo XPKBKG_RF_CGO)*/" ).append("\n"); 
		query.append("					NVL(SUM(RC_SEQ),0)+RF.RC_SEQ" ).append("\n"); 
		query.append("					FROM BKG_RF_CGO " ).append("\n"); 
		query.append("					WHERE RC_SEQ >= 0" ).append("\n"); 
		query.append("					AND ROWNUM <= 1" ).append("\n"); 
		query.append("					AND BKG_NO = @[mst_bkg_no]) RC_SEQ" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , CMDT_CD" ).append("\n"); 
		query.append("        , CMDT_DESC" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , FDO_TEMP" ).append("\n"); 
		query.append("        , CDO_TEMP" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("        , VENT_RTO" ).append("\n"); 
		query.append("        , HUMID_NO" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("        , RF_DCGO_SEQ" ).append("\n"); 
		query.append("        , PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("        , VLTG_NO" ).append("\n"); 
		query.append("        , CTRL_ATMS_FLG" ).append("\n"); 
		query.append("        , MODI_ATMS_FLG" ).append("\n"); 
		query.append("        , HUMID_CTRL_FLG" ).append("\n"); 
		query.append("        , CNTR_DRN_CD" ).append("\n"); 
		query.append("        , CLNG_TP_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , nvl((select cntr.CNTR_VOL_QTY " ).append("\n"); 
		query.append("                 from bkg_container cntr " ).append("\n"); 
		query.append("                where cntr.bkg_no  = @[mst_bkg_no]" ).append("\n"); 
		query.append("                  and cntr.cntr_no = rf.cntr_no), 1)" ).append("\n"); 
		query.append("        , CBM_PER_HR_QTY" ).append("\n"); 
		query.append("        , ATFC_ATMS_FLG" ).append("\n"); 
		query.append("  FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND (CNTR_NO IS NULL" ).append("\n"); 
		query.append("		OR " ).append("\n"); 
		query.append("		CNTR_NO NOT IN (SELECT NVL(CNTR_NO, 'X')" ).append("\n"); 
		query.append("                         FROM BKG_RF_CGO" ).append("\n"); 
		query.append("						WHERE BKG_NO = @[mst_bkg_no])" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}