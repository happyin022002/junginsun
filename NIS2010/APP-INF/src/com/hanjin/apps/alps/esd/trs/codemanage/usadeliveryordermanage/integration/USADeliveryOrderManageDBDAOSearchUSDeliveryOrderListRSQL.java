/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2012.05.22 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSDeliveryOrderList
	  * </pre>
	  */
	public USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.integration").append("\n"); 
		query.append("FileName : USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("X.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("X.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("X.BKG_NO BKG_NO," ).append("\n"); 
		query.append("X.BL_NO BL_NO," ).append("\n"); 
		query.append("Y.FCTRY_NM ," ).append("\n"); 
		query.append("Y.ACT_CUST_N1ST_ADDR ," ).append("\n"); 
		query.append("Y.ACT_CUST_ZIP_CD ," ).append("\n"); 
		query.append("Y.CNTC_PSON_NM ," ).append("\n"); 
		query.append("Y.CNTC_PSON_PHN_NO ," ).append("\n"); 
		query.append("Y.CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("Y.DO_RMK," ).append("\n"); 
		query.append("X.PO_NO," ).append("\n"); 
		query.append("X.BKG_SPE," ).append("\n"); 
		query.append("X.FULL_PICKUP_CY," ).append("\n"); 
		query.append("X.MTY_RTN_CY," ).append("\n"); 
		query.append("X.CMDT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CNTR_NO," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("A.BL_NO_TP," ).append("\n"); 
		query.append("REPLACE((SELECT PU.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_REFERENCE PU" ).append("\n"); 
		query.append("WHERE PU.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND PU.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND PU.BKG_REF_TP_CD = 'CTPO' ), CHR(13)||CHR(10), ',') AS PO_No, -- comma 로 처리하기로 협의" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.DCGO_FLG 	= 'Y' THEN 'DG'" ).append("\n"); 
		query.append("WHEN B.BB_CGO_FLG 	= 'Y' THEN 'BB'" ).append("\n"); 
		query.append("WHEN B.AWK_CGO_FLG 	= 'Y' THEN 'AK'" ).append("\n"); 
		query.append("WHEN B.RC_FLG 		= 'Y' THEN 'RF'" ).append("\n"); 
		query.append("WHEN B.RD_CGO_FLG 	= 'Y' THEN 'RD'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END BKG_SPE," ).append("\n"); 
		query.append("A.FULL_PKUP_YD_CD FULL_PICKUP_CY," ).append("\n"); 
		query.append("A.FULL_RTN_YD_CD MTY_RTN_CY," ).append("\n"); 
		query.append("C.CMDT_NM CMDT" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("BKG_CONTAINER B," ).append("\n"); 
		query.append("MDM_COMMODITY C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.CMDT_CD = C.CMDT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($blNoArr.size() > 0)" ).append("\n"); 
		query.append("AND A.BL_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${blNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkgNoArr.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${bkgNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(!($blNoArr.size() > 0) && !($bkgNoArr.size() > 0))" ).append("\n"); 
		query.append("AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.BL_NO," ).append("\n"); 
		query.append("C.EQ_NO," ).append("\n"); 
		query.append("B.FCTRY_NM," ).append("\n"); 
		query.append("B.ACT_CUST_N1ST_ADDR," ).append("\n"); 
		query.append("B.ACT_CUST_ZIP_CD," ).append("\n"); 
		query.append("B.CNTC_PSON_NM," ).append("\n"); 
		query.append("B.CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("B.CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("C.DO_RMK" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("TRS_TRSP_USA_DO_HDR B," ).append("\n"); 
		query.append("TRS_TRSP_USA_DO_DTL C" ).append("\n"); 
		query.append("WHERE A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($blNoArr.size() > 0)" ).append("\n"); 
		query.append("AND A.BL_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${blNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkgNoArr.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO  IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${bkgNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(!($blNoArr.size() > 0) && !($bkgNoArr.size() > 0))" ).append("\n"); 
		query.append("AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.BL_NO = Y.BL_NO(+)" ).append("\n"); 
		query.append("AND X.CNTR_NO = Y.EQ_NO(+)" ).append("\n"); 

	}
}