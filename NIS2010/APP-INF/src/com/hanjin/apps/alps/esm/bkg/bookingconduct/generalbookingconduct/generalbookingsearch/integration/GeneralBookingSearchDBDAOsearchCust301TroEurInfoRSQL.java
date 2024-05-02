/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301TroEurInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.11.05 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301TroEurInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301TroEurInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301TroEurInfoRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301TroEurInfoRSQL").append("\n"); 
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
		query.append("	|| 'CNTT:'					|| tro.CNTR_TPSZ_CD							    || CHR(10)" ).append("\n"); 
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
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'		     													|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'	                       										|| CHR(10)" ).append("\n"); 
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
		query.append("	|| 'TRM_TYPE:'			||dtl.DOR_ADDR_TP_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_WEIGHT:'		||tro.CGO_WGT										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HAULAGE:'		||tro.HLG_TP_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_HMODE:'			||tro.BKG_TRSP_MZD_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_PICKUP_CY:'		||tro.CNTR_PKUP_YD_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_RETURN_CY:'		||tro.CNTR_RTN_DT									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_INSTRUCTION:'	||replace(replace(replace(nvl(tro.SPCL_INSTR_RMK, ' '), chr(13)||chr(10), ' '), chr(13), ' '), chr(10), ' ')|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_DT:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_OFFICE:'	||tro.CRE_OFC_CD									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRM_TRAN_NO:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'USR_ID:'			||tro.UPD_USR_ID									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_RCV_TERM:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_DLV_TERM:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '{CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ADDR:'			||replace(replace(replace(nvl(dtl.DOR_ADDR,' '),chr(13)||chr(10),' '), chr(10),' '), chr(13),' ')|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_LOC:'		||dtl.LOC_CD			                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_POSTAL:'	||dtl.DOR_ZIP_ID		                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_DOOR_DT:'		||to_char(dtl.ARR_DT, 'RRRRMMDDHH24MI')             || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_PERSON:'		||dtl.CNTC_PSON_NM			                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_TEL:'			||dtl.CNTC_PHN_NO				                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_FAX:'			                       			                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_ACTSHIP:'		||dtl.DOR_ADDR								        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRD_REMARK:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_TRO_DTL'															|| CHR(10)" ).append("\n"); 
		query.append("	|| '}CNTR_INFO'																|| CHR(10) TRO_EUR_INFO" ).append("\n"); 
		query.append("  FROM bkg_eur_tro tro, bkg_eur_tro_dtl dtl" ).append("\n"); 
		query.append(" where tro.bkg_no       = dtl.bkg_no" ).append("\n"); 
		query.append("   and tro.tro_seq      = dtl.tro_seq" ).append("\n"); 
		query.append("   and tro.io_bnd_cd    = 'O'" ).append("\n"); 
		query.append("   and tro.io_bnd_cd    = dtl.io_bnd_cd   " ).append("\n"); 
		query.append("   AND tro.BKG_NO       = @[bkg_no]" ).append("\n"); 

	}
}