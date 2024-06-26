/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrAwkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.06.15 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301CntrAwkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301CntrAwkInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301CntrAwkInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrAwkInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTN:'					|| RPAD(NVL(CNTR.CNTR_NO, ' '), 11, ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTT:'					|| AK.CNTR_TPSZ_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SEAL:'					 												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                  || decode(BK.RC_FLG,'Y','1','0')			    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                  || decode(BK.DCGO_FLG,'Y','1','0')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                  || decode(BK.AWK_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                  || decode(BK.BB_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'               || CNTR.CNTR_WGT								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'                || CNTR.WGT_UT_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN_C:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_VOLTAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_NUM:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_CMH:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'				|| 'N'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'				|| decode(BK.RD_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_DRAIN:'				 												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVF:'					|| AK.OVR_FWRD_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVR:'					|| AK.OVR_BKWD_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVH:'					|| AK.OVR_HGT									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVLW:'					|| AK.OVR_LF_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVRW:'					|| AK.OVR_RT_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVWGT:'					|| ROUND(NVL(AK.GRS_WGT, 0) * DECODE(AK.WGT_UT_CD, 'LBS', 0.4536, 1), 3) || CHR(10)" ).append("\n"); 
		query.append("	|| 'VOID_SLOT:'				|| AK.OVR_VOID_SLT_QTY							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG_REQ:'				|| REPLACE(AK.STWG_RQST_DESC, CHR(13)||CHR(10), ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_LEN:'			|| AK.TTL_DIM_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_WDT:'			|| AK.TTL_DIM_WDT								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_HGT:'			|| AK.TTL_DIM_HGT								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TYPE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_WEIGHT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HAULAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HMODE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_PICKUP_CY:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_RETURN_CY:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_INSTRUCTION:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_OFFICE:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_NO:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'USR_ID:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| '{CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ADDR:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_LOC:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_POSTAL:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_PERSON:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_TEL:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_FAX:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DEPARTURE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_INFO'																|| CHR(10) CNTR_AWK_INFO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_AWK_CGO AK" ).append("\n"); 
		query.append("        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO	    = AK.BKG_NO" ).append("\n"); 
		query.append("   AND AK.BKG_NO        = CNTR.BKG_NO  (+) " ).append("\n"); 
		query.append("   AND AK.CNTR_NO       = CNTR.CNTR_NO (+) " ).append("\n"); 
		query.append("   AND AK.CNTR_TPSZ_CD is not null" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}