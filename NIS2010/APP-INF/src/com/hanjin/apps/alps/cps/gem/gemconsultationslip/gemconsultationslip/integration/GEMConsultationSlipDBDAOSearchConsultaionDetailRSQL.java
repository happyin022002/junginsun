/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchConsultaionDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOSearchConsultaionDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 저장후 상세 내역을 조회를 한다.
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchConsultaionDetailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration ").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchConsultaionDetailRSQL").append("\n"); 
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
		query.append("  SUBS_CSR_NO " ).append("\n"); 
		query.append(", SUBS_OFC_CD " ).append("\n"); 
		query.append(", SUBS_CSR_SEQ" ).append("\n"); 
		query.append(", GEN_EXPN_CD " ).append("\n"); 
		query.append(", GEN_EXPN_NM " ).append("\n"); 
		query.append(", INV_LOCL_AMT" ).append("\n"); 
		query.append(", INV_USD_AMT " ).append("\n"); 
		query.append(", INV_SLP_DESC" ).append("\n"); 
		query.append(", CRE_USR_ID  " ).append("\n"); 
		query.append(", CRE_DT      " ).append("\n"); 
		query.append(", UPD_USR_ID  " ).append("\n"); 
		query.append(", UPD_DT " ).append("\n"); 
		query.append(", GEN_EXPN_NM GEN_EXPN     " ).append("\n"); 
		query.append("FROM GEM_SUBS_CSUL_DTL" ).append("\n"); 
		query.append("WHERE SUBS_CSR_NO = @[subs_csr_no]" ).append("\n"); 

	}
}