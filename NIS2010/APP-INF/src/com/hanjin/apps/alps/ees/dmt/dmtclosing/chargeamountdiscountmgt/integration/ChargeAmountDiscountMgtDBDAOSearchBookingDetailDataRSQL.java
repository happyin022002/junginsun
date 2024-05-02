/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchBookingDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No. 나 B/L No. 로 After Booking Request 정보를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchBookingDetailDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDetailDataRSQL").append("\n"); 
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
		query.append("SELECT	B.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.SLS_OFC_CD" ).append("\n"); 
		query.append(",	B.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	B.FT_DYS" ).append("\n"); 
		query.append(",	B.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	B.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	B.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",	B.BIL_AMT" ).append("\n"); 
		query.append(",	C.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR A" ).append("\n"); 
		query.append(",	DMT_CHG_CALC B" ).append("\n"); 
		query.append(",	DMT_INV_MN C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${bl_no} != '')" ).append("\n"); 
		query.append("A.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.CHG_SEQ = 1" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 

	}
}