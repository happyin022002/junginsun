/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdi301CntrAwkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchEdi301CntrAwkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301CntrAwkInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdi301CntrAwkInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdi301CntrAwkInfoRSQL").append("\n"); 
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
		query.append("	|| 'CNTN:'					|| RPAD(NVL(Cntr.CNTR_NO, ' '), 11, ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTT:'					|| ak.CNTR_TPSZ_CD								|| CHR(10)" ).append("\n"); 
		query.append("    	|| 'OB_HAUL_TP:'			|| CASE WHEN POL.CONTI_CD <> 'E' THEN DECODE(BK.RCV_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE (SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'O' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1) END	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'IB_HAUL_TP:'			|| CASE WHEN POD.CONTI_CD <> 'E' THEN DECODE(BK.DE_TERM_CD,'D','C','M')" ).append("\n"); 
		query.append("                                            ELSE (SELECT ETRO.HLG_TP_CD FROM BKG_EUR_TRO ETRO WHERE ETRO.BKG_NO = BK.BKG_NO AND ETRO.IO_BND_CD = 'I' AND ETRO.CXL_FLG = 'N' AND ROWNUM = 1) END	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SEAL:'					|| REPLACE(REPLACE(REPLACE(NVL(seal.CNTR_SEAL_NO,' '),CHR(32),''),CHR(10),''),CHR(13),'')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                  || DECODE(Cntr.RC_FLG,'Y','1','0')			    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                  || DECODE(Cntr.DCGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                  || DECODE(Cntr.AWK_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                  || DECODE(Cntr.BB_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG_QTY:'               || cntr.pck_qty                                 || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG_TP:'                || cntr.pck_tp_cd                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_QTY:'               || cntr.meas_qty                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_TP:'                || cntr.meas_ut_cd                              || CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'               || CASE WHEN NVL(AK.GRS_WGT,0) <> 0 THEN AK.GRS_WGT" ).append("\n"); 
		query.append("                                        WHEN NVL(CNTR.CNTR_WGT,0) <> 0 THEN CNTR.CNTR_WGT" ).append("\n"); 
		query.append("                                   ELSE ROUND((SELECT BLD.ACT_WGT/NVL((SELECT SUM(BQ.OP_CNTR_QTY) FROM BKG_QUANTITY BQ WHERE BQ.BKG_NO = BLD.BKG_NO),1) FROM BKG_BL_DOC BLD WHERE BLD.BKG_NO = BK.BKG_NO),3)" ).append("\n"); 
		query.append("                                   END 					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'                || CASE WHEN Cntr.WGT_UT_CD IS NULL THEN (SELECT BLD.WGT_UT_CD FROM BKG_BL_DOC BLD WHERE BLD.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("                                        ELSE Cntr.WGT_UT_CD END					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NET_WGT_QTY:'           || ak.NET_WGT									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NET_WGT_TP:'            || ak.WGT_UT_CD									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN_C:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_VOLTAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'VENT_UNIT:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'O2_PC_LVL_QTY:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'CO2_PC_LVL_QTY:'														|| CHR(10)															" ).append("\n"); 
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'				|| DECODE(bk.RD_CGO_FLG,'N','0','Y','1',BK.RD_CGO_FLG)|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVF:'					|| AK.OVR_FWRD_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVR:'					|| AK.OVR_BKWD_LEN								|| CHR(10)" ).append("\n"); 
		query.append("    || 'OVL_UNIT:'				|| 'CM'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVH:'					|| AK.OVR_HGT									|| CHR(10)" ).append("\n"); 
		query.append("    || 'OVH_UNIT:'				|| 'CM'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVLW:'					|| AK.OVR_LF_LEN								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVRW:'					|| AK.OVR_RT_LEN								|| CHR(10)" ).append("\n"); 
		query.append("    || 'OVW_UNIT:'				|| 'CM'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVWGT:'					|| ROUND(NVL(AK.GRS_WGT, 0) * DECODE(AK.WGT_UT_CD, 'LBS', 0.4536, 1), 3) || CHR(10)" ).append("\n"); 
		query.append("	|| 'VOID_SLOT:'				|| AK.OVR_VOID_SLT_QTY							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG_REQ:'				|| AK.STWG_RQST_DESC							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_LEN:'			|| AK.TTL_DIM_LEN								|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_LEN_UNIT:'		|| 'CM'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_WDT:'			|| AK.TTL_DIM_WDT								|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_WDT_UNIT:'		|| 'CM'											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_HGT:'			|| AK.TTL_DIM_HGT								|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_HGT_UNIT:'		|| 'CM'											|| CHR(10)" ).append("\n"); 
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
		query.append("	|| 'CNTR_RCV_TERM:'			||CNTR.RCV_TERM_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_DLV_TERM:'			||CNTR.DE_TERM_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| '{CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DIR_IND:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ADDR:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_LOC:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_POSTAL:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DOOR_DT_GTM:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_PERSON:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_TEL:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_FAX:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_EMAIL:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DEPARTURE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ACTSHIP:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_REMARK:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_INFO'																CNTR_AWK_INFO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_AWK_CGO AK" ).append("\n"); 
		query.append("        , BKG_CONTAINER cntr" ).append("\n"); 
		query.append("        , BKG_CNTR_SEAL_NO seal" ).append("\n"); 
		query.append("        , MDM_LOCATION POL" ).append("\n"); 
		query.append("        , MDM_LOCATION POD" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO	    = AK.BKG_NO" ).append("\n"); 
		query.append("   AND ak.bkg_no        = Cntr.BKG_NO  (+) " ).append("\n"); 
		query.append("   AND ak.CNTR_NO       = Cntr.CNTR_NO (+) " ).append("\n"); 
		query.append("   AND cntr.BKG_NO      = seal.BKG_NO       (+)" ).append("\n"); 
		query.append("   AND cntr.CNTR_NO     = seal.CNTR_NO      (+)" ).append("\n"); 
		query.append("   AND 1                = seal.CNTR_SEAL_SEQ(+)" ).append("\n"); 
		query.append("   AND bk.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("   AND BK.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("   AND BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 

	}
}