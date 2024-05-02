/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOArDataInqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOArDataInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOArDataInqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : MakeVoDAOArDataInqRSQL").append("\n"); 
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
		query.append("'' ACCT_YRMON" ).append("\n"); 
		query.append(",      '' JO_CRR_CD" ).append("\n"); 
		query.append(",      '' RLANE_CD" ).append("\n"); 
		query.append(",      '' VSL_CD" ).append("\n"); 
		query.append(",      '' SKD_VOY_NO" ).append("\n"); 
		query.append(",      '' SKD_DIR_CD" ).append("\n"); 
		query.append(",      '' REV_DIR_CD" ).append("\n"); 
		query.append(",      '' JO_CRR_CD_NM" ).append("\n"); 
		query.append(",      '' CSR_LOCL_AMT" ).append("\n"); 
		query.append(",      '' yrmon_type" ).append("\n"); 
		query.append(",      '' yrmon_fr" ).append("\n"); 
		query.append(",      '' yrmon_to" ).append("\n"); 
		query.append(",      '' sum_yn" ).append("\n"); 
		query.append(",      '' RE_DIVR_CD" ).append("\n"); 
		query.append(",      ''LOCL_CURR_CD" ).append("\n"); 
		query.append(",      ''JO_STL_ITM_CD" ).append("\n"); 
		query.append(",      ''JO_BIL_NO" ).append("\n"); 
		query.append(",      ''TRAN_NO" ).append("\n"); 
		query.append(",      ''rev_yrmon" ).append("\n"); 
		query.append(",      ''VVD" ).append("\n"); 
		query.append(",      ''cb_ofc_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}