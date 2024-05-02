/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301TroGeneralInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : jklim
*@LastVersion : 1.0
* 2015.01.08 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301TroGeneralInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301TroGeneralInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301TroGeneralInfoRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301TroGeneralInfoRSQL").append("\n"); 
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
		query.append("	|| 'CNTN:'					                                            	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTT:'					|| dtl.CNTR_TPSZ_CD							    || CHR(10)" ).append("\n"); 
		query.append("    || 'OB_HAUL_TP:'			|| ''	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'IB_HAUL_TP:'			|| ''	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SEAL:'					                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                    				                         	    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                     				                				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                    				                 			    || CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                     				                    			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG_QTY:'                                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG_TP:'                                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_QTY:'                                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEA_TP:'                                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'                 								                || CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'               						                          	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'TUN_C:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'RF_VOLTAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'VENT_UNIT:'																|| CHR(10)" ).append("\n"); 
		query.append("    || 'O2_PC_LVL_QTY:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'CO2_PC_LVL_QTY:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'		     													|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'	                       										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVF:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVR:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVL_UNIT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVH:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'OVH_UNIT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVLW:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVRW:'																	|| CHR(10)" ).append("\n"); 
		query.append("    || 'OVW_UNIT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OVWGT:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VOID_SLOT:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'STWG_REQ:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_LEN:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_LEN_UNIT:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_WDT:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_WDT_UNIT:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TTL_DIM_HGT:'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TTL_DIM_HGT_UNIT:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TYPE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_WEIGHT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HAULAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HMODE:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_PICKUP_CY:'		||dtl.PKUP_YD_CD									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_RETURN_CY:'		||dtl.RTN_YD_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_INSTRUCTION:'	||replace(nvl(tro.diff_rmk, ' '), chr(10), ' ')|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_OFFICE:'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_NO:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'USR_ID:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_RCV_TERM:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_DLV_TERM:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '{CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DIR_IND:'		||tro.io_bnd_cd										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ADDR:'			||replace(nvl(tro.ACT_SHPR_ADDR,' '),chr(10),' ')|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_LOC:'		||tro.DOR_LOC_CD			                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_POSTAL:'	||tro.DOR_PST_NO		                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_DT:'		||to_char(dtl.DOR_ARR_DT, 'RRRRMMDDHH24MI')         || CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DOOR_DT_GTM:'	||to_char(GLOBALDATE_PKG.TIME_CONV_FNC(tro.DOR_LOC_CD,dtl.DOR_ARR_DT,'GMT'), 'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_PERSON:'		||tro.CNTC_PSON_NM			                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_TEL:'			||tro.CNTC_PHN_NO				                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_FAX:'			||tro.CNTC_FAX_NO				                    || CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_EMAIL:'			||''												|| CHR(10)" ).append("\n"); 
		query.append("    || 'TRD_DEPARTURE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ACTSHIP:'		||tro.ACT_SHPR_NM   								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_REMARK:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_INFO'																|| CHR(10) TRO_GEN_INFO" ).append("\n"); 
		query.append("  FROM bkg_tro tro, bkg_tro_dtl dtl" ).append("\n"); 
		query.append(" where tro.bkg_no       = dtl.bkg_no" ).append("\n"); 
		query.append("   and tro.tro_seq      = dtl.tro_seq" ).append("\n"); 
		query.append("   and tro.rtn_tro_flg  = 'N'" ).append("\n"); 
		query.append("   and tro.rtn_tro_flg  = dtl.rtn_tro_flg" ).append("\n"); 
		query.append("   and tro.io_bnd_cd    = 'O'" ).append("\n"); 
		query.append("   and tro.io_bnd_cd    = dtl.io_bnd_cd   " ).append("\n"); 
		query.append("   AND tro.BKG_NO       = @[bkg_no]" ).append("\n"); 

	}
}