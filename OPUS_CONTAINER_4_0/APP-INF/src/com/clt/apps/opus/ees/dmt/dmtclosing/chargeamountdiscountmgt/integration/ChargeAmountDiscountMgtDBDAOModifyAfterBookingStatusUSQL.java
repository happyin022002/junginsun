/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 After Booking DAR 의 상태를 변경하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_apro_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingStatusUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_AFT_BKG_ADJ_RQST SET" ).append("\n"); 
		query.append("	DMDT_EXPT_RQST_STS_CD = @[dmdt_expt_rqst_sts_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	UPD_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 
		query.append("#if(${dmdt_expt_rqst_sts_cd} == 'O' || ${dmdt_expt_rqst_sts_cd} == 'J')" ).append("\n"); 
		query.append(",	AFT_BKG_APRO_NO = ''" ).append("\n"); 
		query.append("#elseif(${dmdt_expt_rqst_sts_cd} == 'A')" ).append("\n"); 
		query.append(",	AFT_BKG_APRO_NO = @[aft_bkg_apro_no]" ).append("\n"); 
		query.append(",	APRO_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	APRO_DT = SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 

	}
}