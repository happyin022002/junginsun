/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOsearchAwkDtlCgoQlistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOsearchAwkDtlCgoQlistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Awkward Detail Cargo Quotation List
	  * </pre>
	  */
	public ScqListDBDAOsearchAwkDtlCgoQlistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOsearchAwkDtlCgoQlistRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_QTY," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CMDT_CD = CGO.CMDT_CD" ).append("\n"); 
		query.append("AND ROWNUM <= 1) AS CMDT_NM," ).append("\n"); 
		query.append("TTL_DIM_LEN," ).append("\n"); 
		query.append("TTL_DIM_WDT," ).append("\n"); 
		query.append("TTL_DIM_HGT," ).append("\n"); 
		query.append("OVR_FWRD_LEN," ).append("\n"); 
		query.append("OVR_BKWD_LEN," ).append("\n"); 
		query.append("OVR_LF_LEN," ).append("\n"); 
		query.append("OVR_RT_LEN," ).append("\n"); 
		query.append("OVR_HGT," ).append("\n"); 
		query.append("GRS_WGT," ).append("\n"); 
		query.append("OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("PROP_BSRT_AMT," ).append("\n"); 
		query.append("PROP_VOID_RT_AMT," ).append("\n"); 
		query.append("APRO_BSRT_AMT," ).append("\n"); 
		query.append("APRO_VOID_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_SCQ_AWK_CGO CGO" ).append("\n"); 
		query.append("WHERE SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND SCQ_VER_NO = @[scq_ver_no]" ).append("\n"); 

	}
}