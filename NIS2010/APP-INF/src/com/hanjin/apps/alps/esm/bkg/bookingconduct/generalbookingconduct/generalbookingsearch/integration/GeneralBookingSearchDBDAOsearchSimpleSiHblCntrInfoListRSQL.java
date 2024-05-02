/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchSimpleSiHblCntrInfoListRSQL.java
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

public class GeneralBookingSearchDBDAOsearchSimpleSiHblCntrInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSimpleSiHblCntrInfoList
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchSimpleSiHblCntrInfoListRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchSimpleSiHblCntrInfoListRSQL").append("\n"); 
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
		query.append("-- HBL CNTR" ).append("\n"); 
		query.append("SELECT A.CNTR_NO||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO2||'|'||" ).append("\n"); 
		query.append("A.IBCNTR_SEAL_NO3||'|'||" ).append("\n"); 
		query.append("DECODE(B.PCK_QTY,0,'',RTRIM(TO_CHAR(B.PCK_QTY,'FM999,999,990.999'),'.'))||'|'||" ).append("\n"); 
		query.append("(SELECT PCK_NM" ).append("\n"); 
		query.append("FROM MDM_PCK_TP" ).append("\n"); 
		query.append("WHERE PCK_CD = B.PCK_TP_CD)||'|'||" ).append("\n"); 
		query.append("DECODE(B.CNTR_MF_WGT,0,'',TO_CHAR(B.CNTR_MF_WGT,'FM999,999,999,999,990.999'))||'|'||" ).append("\n"); 
		query.append("B.WGT_UT_CD||'|'||" ).append("\n"); 
		query.append("DECODE(B.MEAS_QTY,0,'',TO_CHAR(B.MEAS_QTY,'FM999,999,990.999'))||'|'||" ).append("\n"); 
		query.append("B.MEAS_UT_CD ATTR_CTNT2" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 1 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 2 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO2," ).append("\n"); 
		query.append("MIN(CASE WHEN A.CNTR_SEAL_SEQ = 3 THEN A.CNTR_SEAL_NO END) AS IBCNTR_SEAL_NO3," ).append("\n"); 
		query.append("MIN(A.CNTR_MF_NO) CNTR_MF_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT SEAL.BKG_NO, SEAL.CNTR_NO, CNTR_SEAL_NO, CNTR_SEAL_SEQ, CNTR_MF_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_SEAL_NO SEAL," ).append("\n"); 
		query.append("(   SELECT B.BKG_NO, B.CNTR_NO, B.CNTR_MF_NO" ).append("\n"); 
		query.append("FROM BKG_HBL A," ).append("\n"); 
		query.append("BKG_CNTR_MF_DESC B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_MF_NO = B.CNTR_MF_NO" ).append("\n"); 
		query.append("AND A.HBL_SEQ = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE SEAL.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("AND SEAL.CNTR_NO(+) = A.CNTR_NO) A" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO, A.CNTR_NO, A.CNTR_MF_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_MF_NO = A.CNTR_MF_NO" ).append("\n"); 

	}
}