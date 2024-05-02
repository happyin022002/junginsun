/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.07.04 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301CntrInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL").append("\n"); 
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
		query.append("	|| 'CNTT:'					|| CNTR.CNTR_TPSZ_CD							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SEAL:'					|| REPLACE(REPLACE(REPLACE(NVL(" ).append("\n"); 
		query.append("		(  SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("		   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		   WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("		   AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		   ),' '),CHR(32),''),CHR(10),''),CHR(13),'')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RIND:'                  || decode(CNTR.RC_FLG,'Y','1','0')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DIND:'                  || decode(CNTR.DCGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AIND:'                  || decode(CNTR.AWK_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BIND:'                  || decode(CNTR.BB_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_QTY:'               || CNTR.CNTR_WGT								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT_TP:'                || CNTR.WGT_UT_CD								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VGM_VRF_DATE:'          || TO_CHAR(CNTR.VGM_VRFY_DT,'RRRRMMDDHH24MI')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'VGM_WGTQTY:'            || CNTR.VGM_WGT                                 || CHR(10)" ).append("\n"); 
		query.append("	|| 'VGM_WGTCD:'             || CNTR.VGM_WGT_UT_CD                           || CHR(10)" ).append("\n"); 
		query.append("	|| 'VGM_METHOD:'            || CNTR.VGM_MZD_TP_CD                           || CHR(10)" ).append("\n"); 
		query.append("	|| 'VGM_SIGNATURE:'         || REPLACE(REPLACE(REPLACE(CNTR.VGM_VRFY_SIG_CTNT,CHR(13)||CHR(10),' '),CHR(13),' '),CHR(10),' ')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TEMP_C:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TUN_C:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_VOLTAGE:'															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_NUM:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VENT_CMH:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HUMID:'																	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'GENSET:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_REMARK:'																|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RFDRY_IND:'				|| decode(CNTR.RD_CGO_FLG,'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_DRAIN:'																|| CHR(10)" ).append("\n"); 
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
		query.append("	|| '}CNTR_INFO'																|| CHR(10) CNTR_INFO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("--        , BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO   	    = CNTR.BKG_NO" ).append("\n"); 
		query.append("--   AND CNTR.BKG_NO      = SEAL.BKG_NO       (+)" ).append("\n"); 
		query.append("--   AND CNTR.CNTR_NO     = SEAL.CNTR_NO      (+)" ).append("\n"); 
		query.append("--   AND 1                = SEAL.CNTR_SEAL_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.DCGO_FLG    = 'N'" ).append("\n"); 
		query.append("   AND CNTR.RC_FLG      = 'N'" ).append("\n"); 
		query.append("   AND CNTR.AWK_CGO_FLG = 'N'" ).append("\n"); 
		query.append("   AND BK.BKG_NO        = @[bkg_no]" ).append("\n"); 

	}
}