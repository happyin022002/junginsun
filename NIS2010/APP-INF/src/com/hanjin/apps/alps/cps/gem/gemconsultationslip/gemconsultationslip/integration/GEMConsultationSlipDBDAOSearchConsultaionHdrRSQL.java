/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchConsultaionHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOSearchConsultaionHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HDR 정보를 조회를 한다.
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchConsultaionHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchConsultaionHdrRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append(" SUBS_CSR_NO " ).append("\n"); 
		query.append(",SUBS_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(INP_DT,'YYYY-MM-DD'),'YYYY-MM-DD') INP_DT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(INV_DT,'YYYY-MM-DD'),'YYYY-MM-DD') INV_DT" ).append("\n"); 
		query.append(",PAY_VNDR_NM" ).append("\n"); 
		query.append(",TO_CHAR(APRO_DT ,'YYYY-MM-DD') APRO_DT" ).append("\n"); 
		query.append(",EXPN_DIV_CD" ).append("\n"); 
		query.append(",DECODE(APRO_RSLT_CD,'X','Saved','C','Deleted','P','Submitted','N','Rejected','Y','Approved','E','Error') APRO_RSLT_CD" ).append("\n"); 
		query.append(",INV_CURR_CD" ).append("\n"); 
		query.append(",INV_LOCL_TTL_AMT " ).append("\n"); 
		query.append(",INV_USD_TTL_AMT " ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append("FROM GEM_SUBS_CSUL_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUBS_CSR_NO = @[subs_csr_no]" ).append("\n"); 

	}
}