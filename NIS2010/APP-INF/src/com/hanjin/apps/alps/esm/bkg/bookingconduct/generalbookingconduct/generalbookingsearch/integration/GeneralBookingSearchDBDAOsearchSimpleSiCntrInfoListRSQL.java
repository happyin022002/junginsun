/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchSimpleSiCntrInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchSimpleSiCntrInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSimpleSiCntrInfoList
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchSimpleSiCntrInfoListRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchSimpleSiCntrInfoListRSQL").append("\n"); 
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
		query.append("SELECT CNTR.CNTR_NO||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO2||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO3||'|'||" ).append("\n"); 
		query.append("DECODE(CNTR.PCK_QTY,0,'',RTRIM(TO_CHAR(CNTR.PCK_QTY,'FM999,999,990.999'),'.'))||'|'||" ).append("\n"); 
		query.append("(SELECT PCK_NM" ).append("\n"); 
		query.append("FROM MDM_PCK_TP" ).append("\n"); 
		query.append("WHERE PCK_CD = CNTR.PCK_TP_CD)||'|'||" ).append("\n"); 
		query.append("DECODE(CNTR.CNTR_WGT,0,'',TO_CHAR(CNTR.CNTR_WGT,'FM999,999,999,999,990.999'))||'|'||" ).append("\n"); 
		query.append("CNTR.WGT_UT_CD||'|'||" ).append("\n"); 
		query.append("DECODE(CNTR.MEAS_QTY,0,'',TO_CHAR(CNTR.MEAS_QTY,'FM999,999,990.999'))||'|'||" ).append("\n"); 
		query.append("CNTR.MEAS_UT_CD ATTR_CTNT2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.BKG_NO," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 1 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 2 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO2," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 3 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO3" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CNTR.BKG_NO, CNTR.CNTR_NO, CNTR_SEAL_SEQ, CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR.BKG_NO = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO = SEAL.CNTR_NO(+) ) A" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO, A.CNTR_NO" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE A.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("ORDER by CNTR.CNTR_DP_SEQ, CNTR.CNTR_NO" ).append("\n"); 

	}
}