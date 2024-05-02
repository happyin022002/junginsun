/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.09.01 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingBkgRfCgo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pwr_spl_cbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vent_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vent_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_RF_CGO_HIS (" ).append("\n"); 
		query.append(" 	BKG_NO" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",   CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	VENT_RTO" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	CLNG_TP_CD" ).append("\n"); 
		query.append(",	HUMID_NO" ).append("\n"); 
		query.append(",   DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" 	@[bkg_no]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[cmdt_desc]" ).append("\n"); 
		query.append(",	@[fdo_temp]" ).append("\n"); 
		query.append(",	@[cdo_temp]" ).append("\n"); 
		query.append(",	@[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",   NVL(@[cntr_vent_tp_cd], 'P')" ).append("\n"); 
		query.append(",	CASE WHEN (@[cntr_vent_tp_cd] = 'P') " ).append("\n"); 
		query.append("	 	THEN @[vent_rto]" ).append("\n"); 
		query.append("		ELSE null" ).append("\n"); 
		query.append("	END " ).append("\n"); 
		query.append(",	CASE WHEN (@[cntr_vent_tp_cd] = 'C') " ).append("\n"); 
		query.append("	 	THEN @[vent_rto]" ).append("\n"); 
		query.append("		ELSE null" ).append("\n"); 
		query.append("	END " ).append("\n"); 
		query.append(",	@[clng_tp_cd]" ).append("\n"); 
		query.append(",	@[humid_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'TMP0000001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_RF_CGO (" ).append("\n"); 
		query.append(" 	BKG_NO" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",   CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	VENT_RTO" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	CLNG_TP_CD" ).append("\n"); 
		query.append(",	HUMID_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" 	@[bkg_no]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[cmdt_desc]" ).append("\n"); 
		query.append(",	@[fdo_temp]" ).append("\n"); 
		query.append(",	@[cdo_temp]" ).append("\n"); 
		query.append(",	@[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",   NVL(@[cntr_vent_tp_cd], 'P')" ).append("\n"); 
		query.append(",	CASE WHEN (@[cntr_vent_tp_cd] = 'P') " ).append("\n"); 
		query.append("	 	THEN @[vent_rto]" ).append("\n"); 
		query.append("		ELSE null" ).append("\n"); 
		query.append("	END " ).append("\n"); 
		query.append(",	CASE WHEN (@[cntr_vent_tp_cd] = 'C') " ).append("\n"); 
		query.append("	 	THEN @[vent_rto]" ).append("\n"); 
		query.append("		ELSE null" ).append("\n"); 
		query.append("	END " ).append("\n"); 
		query.append(",	@[clng_tp_cd]" ).append("\n"); 
		query.append(",	@[humid_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}