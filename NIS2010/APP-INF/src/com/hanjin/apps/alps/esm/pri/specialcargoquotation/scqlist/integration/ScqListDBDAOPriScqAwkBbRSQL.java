/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqListDBDAOPriScqAwkBbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOPriScqAwkBbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriScqAwkBbVO
	  * 해당 쿼리를 통해 PriScqAwkBbVO 가 생성되지만
	  * 별도의 List 3개와 getter, setter 를 항상 추가해야 함.
	  * private List<PriScqBbCntrVO> priScqBbCntrVOs = null;
	  * private List<PriScqBbCgoDtlVO> priScqBbCgoDtlVos = null;
	  * private List<PriScqBbHandlingCstVO> priScqBbHandlingCstVos = null;
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqListDBDAOPriScqAwkBbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOPriScqAwkBbRSQL").append("\n"); 
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
		query.append("     '' AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    ,'' AS ACT_CUST_NM" ).append("\n"); 
		query.append("    ,'' AS ACT_CUST_SEQ" ).append("\n"); 
		query.append("    ,'' AS APRO_BSRT_AMT" ).append("\n"); 
		query.append("    ,'' AS APRO_EFF_DT" ).append("\n"); 
		query.append("    ,'' AS APRO_EXP_DT" ).append("\n"); 
		query.append("    ,'' AS APRO_OFC_CD" ).append("\n"); 
		query.append("    ,'' AS APRO_RT" ).append("\n"); 
		query.append("    ,'' AS APRO_VOID_RT_AMT" ).append("\n"); 
		query.append("    ,'' AS CGO_TYPE" ).append("\n"); 
		query.append("    ,'' AS CMDT_CD" ).append("\n"); 
		query.append("    ,'' AS CMDT_NM" ).append("\n"); 
		query.append("    ,'' AS CNTR_QTY" ).append("\n"); 
		query.append("    ,'' AS CNTR_TP_SZ" ).append("\n"); 
		query.append("    ,'' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,'' AS CRE_DT" ).append("\n"); 
		query.append("    ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("    ,'' AS CUST_CD" ).append("\n"); 
		query.append("    ,'' AS CUST_CNT_CD" ).append("\n"); 
		query.append("    ,'' AS CUST_NM" ).append("\n"); 
		query.append("    ,'' AS CUST_SEQ" ).append("\n"); 
		query.append("    ,'' AS DE_TERM_CD" ).append("\n"); 
		query.append("    ,'' AS DEL_CD" ).append("\n"); 
		query.append("    ,'' AS DELT_FLG" ).append("\n"); 
		query.append("    ,'' AS FMPERIOD" ).append("\n"); 
		query.append("    ,'' AS GRS_WGI" ).append("\n"); 
		query.append("    ,'' AS GRS_WGT" ).append("\n"); 
		query.append("    ,'' AS OVR_BKWD_LEN" ).append("\n"); 
		query.append("    ,'' AS OVR_FWRD_LEN" ).append("\n"); 
		query.append("    ,'' AS OVR_HGT" ).append("\n"); 
		query.append("    ,'' AS OVR_LF_LEN" ).append("\n"); 
		query.append("    ,'' AS OVR_RT_LEN" ).append("\n"); 
		query.append("    ,'' AS OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("    ,'' AS POD_CD" ).append("\n"); 
		query.append("    ,'' AS POD_SUM" ).append("\n"); 
		query.append("    ,'' AS POD_YD_CD" ).append("\n"); 
		query.append("    ,'' AS POL_CD" ).append("\n"); 
		query.append("    ,'' AS POL_SUM" ).append("\n"); 
		query.append("    ,'' AS POL_YD_CD" ).append("\n"); 
		query.append("    ,'' AS POR_CD" ).append("\n"); 
		query.append("    ,'' AS PROG_DT" ).append("\n"); 
		query.append("    ,'' AS PROG_STS_CD" ).append("\n"); 
		query.append("    ,'' AS PROP_BSRT_AMT" ).append("\n"); 
		query.append("    ,'' AS PROP_EFF_DT" ).append("\n"); 
		query.append("    ,'' AS PROP_EXP_DT" ).append("\n"); 
		query.append("    ,'' AS PROP_RT" ).append("\n"); 
		query.append("    ,'' AS PROP_VOID_RT_AMT" ).append("\n"); 
		query.append("    ,'' AS RCV_TERM_CD" ).append("\n"); 
		query.append("    ,'' AS RQST_OFC_CD" ).append("\n"); 
		query.append("    ,'' AS RQST_SREP_CD" ).append("\n"); 
		query.append("    ,'' AS SCQ_RQST_NO" ).append("\n"); 
		query.append("    ,'' AS SCQ_RQST_NO2" ).append("\n"); 
		query.append("    ,'' AS SCQ_VER_NO" ).append("\n"); 
		query.append("    ,'' AS STS_CD" ).append("\n"); 
		query.append("    ,'' AS SVC_SCP_CD" ).append("\n"); 
		query.append("    ,'' AS TOPERIOD" ).append("\n"); 
		query.append("    ,'' AS TP_CD" ).append("\n"); 
		query.append("    ,'' AS TTL_DIM_HGT" ).append("\n"); 
		query.append("    ,'' AS TTL_DIM_LEN" ).append("\n"); 
		query.append("    ,'' AS TTL_DIM_WDT" ).append("\n"); 
		query.append("    ,'' AS UPD_DT" ).append("\n"); 
		query.append("    ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("    ,'' AS MEAS_SYS_CD" ).append("\n"); 
		query.append("    ,'' AS RQST_USR_NM" ).append("\n"); 
		query.append("    ,'' AS RQST_DT" ).append("\n"); 
		query.append("    ,'' AS APRO_USR_NM" ).append("\n"); 
		query.append("    ,'' AS APRO_DT" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}