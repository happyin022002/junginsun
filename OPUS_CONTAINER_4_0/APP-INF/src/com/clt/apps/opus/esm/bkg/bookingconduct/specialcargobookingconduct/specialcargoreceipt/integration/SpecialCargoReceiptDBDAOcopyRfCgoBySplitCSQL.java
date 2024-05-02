/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyRfCgoBySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopyRfCgoBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyRfCgoBySplitCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyRfCgoBySplitCSQL").append("\n"); 
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
		query.append("insert into bkg_rf_cgo(BKG_NO " ).append("\n"); 
		query.append(",RC_SEQ " ).append("\n"); 
		query.append(",CNTR_TPSZ_CD " ).append("\n"); 
		query.append(",CNTR_NO " ).append("\n"); 
		query.append(",PCK_TP_CD " ).append("\n"); 
		query.append(",PCK_QTY " ).append("\n"); 
		query.append(",NET_WGT " ).append("\n"); 
		query.append(",GRS_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",CMDT_CD " ).append("\n"); 
		query.append(",CMDT_DESC " ).append("\n"); 
		query.append(",FDO_TEMP " ).append("\n"); 
		query.append(",CDO_TEMP " ).append("\n"); 
		query.append(",CNTR_VENT_TP_CD " ).append("\n"); 
		query.append(",VENT_RTO " ).append("\n"); 
		query.append(",HUMID_NO " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",RF_DCGO_SEQ " ).append("\n"); 
		query.append(",PWR_SPL_CBL_FLG " ).append("\n"); 
		query.append(",VLTG_NO " ).append("\n"); 
		query.append(",CTRL_ATMS_FLG " ).append("\n"); 
		query.append(",MODI_ATMS_FLG " ).append("\n"); 
		query.append(",HUMID_CTRL_FLG " ).append("\n"); 
		query.append(",CNTR_DRN_CD " ).append("\n"); 
		query.append(",CLNG_TP_CD " ).append("\n"); 
		query.append(",RQST_DT " ).append("\n"); 
		query.append(",RQST_USR_ID " ).append("\n"); 
		query.append(",SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",cntr_vol_qty" ).append("\n"); 
		query.append(",SNS_CGO_KND_CD" ).append("\n"); 
		query.append(",OXGN_RTO" ).append("\n"); 
		query.append(",CRBN_DXD_RTO" ).append("\n"); 
		query.append(",CBM_PER_HR_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT NVL(MAX(RC_SEQ), 0)" ).append("\n"); 
		query.append("	FROM   BKG_RF_CGO" ).append("\n"); 
		query.append("	WHERE  BKG_NO = @[targetBkg]) + ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY RC_SEQ " ).append("\n"); 
		query.append(") AS RC_SEQ " ).append("\n"); 
		query.append(",CNTR_TPSZ_CD " ).append("\n"); 
		query.append(",CNTR_NO " ).append("\n"); 
		query.append(",PCK_TP_CD " ).append("\n"); 
		query.append(",PCK_QTY " ).append("\n"); 
		query.append(",NET_WGT " ).append("\n"); 
		query.append(",GRS_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",CMDT_CD " ).append("\n"); 
		query.append(",CMDT_DESC " ).append("\n"); 
		query.append(",FDO_TEMP " ).append("\n"); 
		query.append(",CDO_TEMP " ).append("\n"); 
		query.append(",CNTR_VENT_TP_CD " ).append("\n"); 
		query.append(",VENT_RTO " ).append("\n"); 
		query.append(",HUMID_NO " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",RF_DCGO_SEQ " ).append("\n"); 
		query.append(",PWR_SPL_CBL_FLG " ).append("\n"); 
		query.append(",VLTG_NO " ).append("\n"); 
		query.append(",CTRL_ATMS_FLG " ).append("\n"); 
		query.append(",MODI_ATMS_FLG " ).append("\n"); 
		query.append(",HUMID_CTRL_FLG " ).append("\n"); 
		query.append(",CNTR_DRN_CD " ).append("\n"); 
		query.append(",CLNG_TP_CD " ).append("\n"); 
		query.append(",RQST_DT " ).append("\n"); 
		query.append(",RQST_USR_ID " ).append("\n"); 
		query.append(",SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID " ).append("\n"); 
		query.append(",sysdate CRE_DT " ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append(",nvl((select cntr.CNTR_VOL_QTY " ).append("\n"); 
		query.append("        from bkg_container cntr " ).append("\n"); 
		query.append("       where cntr.bkg_no  = @[targetBkg]" ).append("\n"); 
		query.append("         and cntr.cntr_no = spcl.cntr_no), 1)" ).append("\n"); 
		query.append(", SNS_CGO_KND_CD" ).append("\n"); 
		query.append(", OXGN_RTO" ).append("\n"); 
		query.append(", CRBN_DXD_RTO" ).append("\n"); 
		query.append(", CBM_PER_HR_QTY" ).append("\n"); 
		query.append("from bkg_rf_cgo spcl" ).append("\n"); 
		query.append("where bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rc_seq} != 'all')" ).append("\n"); 
		query.append("	and rc_seq = @[rc_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}