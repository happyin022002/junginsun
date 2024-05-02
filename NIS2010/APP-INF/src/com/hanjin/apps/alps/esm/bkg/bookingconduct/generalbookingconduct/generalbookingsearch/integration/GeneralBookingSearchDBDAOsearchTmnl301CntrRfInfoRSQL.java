/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrRfInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.06.22 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301CntrRfInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301CntrRfInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301CntrRfInfoRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrRfInfoRSQL").append("\n"); 
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
		query.append("	|| 'CNTT:'					|| RF.CNTR_TPSZ_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SEAL:'					 												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                  || decode(BK.RC_FLG,'Y','1','0')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                  || decode(BK.DCGO_FLG,'Y','1','0')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                  || decode(BK.AWK_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                  || decode(BK.BB_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'               || CNTR.CNTR_WGT								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'                || CNTR.WGT_UT_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'					|| RF.FDO_TEMP									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'					|| 'F'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'				|| RF.CDO_TEMP									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN_C:'					|| 'C'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_VOLTAGE:'			|| NVL(RF.VLTG_NO,'0')							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'					|| CASE WHEN NVL(RF.VENT_RTO,0) = 0 THEN 'C'" ).append("\n"); 
		query.append("										WHEN NVL(RF.VENT_RTO,0) > 0 AND NVL(RF.VENT_RTO,0) < 35 THEN 'Q'" ).append("\n"); 
		query.append("										WHEN NVL(RF.VENT_RTO,0) >= 35 AND NVL(RF.VENT_RTO,0) < 65 THEN 'H'" ).append("\n"); 
		query.append("										WHEN NVL(RF.VENT_RTO,0) >= 65 AND NVL(RF.VENT_RTO,0) < 100 THEN 'T'" ).append("\n"); 
		query.append("										WHEN NVL(RF.VENT_RTO,0) = 100 THEN 'O' END		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_NUM:'				|| RF.VENT_RTO						        	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_CMH:'				|| RF.CBM_PER_HR_QTY							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HUMID:'					|| RF.HUMID_NO									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'				|| RF.PWR_SPL_CBL_FLG                           || CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'				|| REPLACE(RF.DIFF_RMK, chr(13)||chr(10), ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'				|| decode(BK.RD_CGO_FLG,'Y','1','0')    		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_DRAIN:'				|| decode(RF.CNTR_DRN_CD,'C','OFF','O','ON','N','N/A','')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVF:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVR:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVH:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVLW:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVRW:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVWGT:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VOID_SLOT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG_REQ:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_LEN:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_WDT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_HGT:'															|| CHR(10)" ).append("\n"); 
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
		query.append("	|| '}CNTR_INFO'																|| CHR(10) CNTR_RF_INFO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_RF_CGO RF" ).append("\n"); 
		query.append("        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO        = RF.BKG_NO" ).append("\n"); 
		query.append("   AND RF.BKG_NO        = CNTR.BKG_NO  (+) " ).append("\n"); 
		query.append("   AND RF.CNTR_NO       = CNTR.CNTR_NO (+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}