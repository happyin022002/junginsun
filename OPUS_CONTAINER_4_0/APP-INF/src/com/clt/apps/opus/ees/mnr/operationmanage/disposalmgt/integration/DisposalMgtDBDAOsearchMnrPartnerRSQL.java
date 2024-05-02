/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchMnrPartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchMnrPartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchMnrPartnerRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchMnrPartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchMnrPartnerRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	B.CUST_CNT_CD||lpad(B.CUST_SEQ,6,0) CUST_CD" ).append("\n"); 
		query.append("	,B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM 	MNR_PARTNER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE UPPER(A.SP_PTAL_ID) = UPPER(@[sp_ptal_id])" ).append("\n"); 
		query.append("	AND A.MNR_PRNR_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND A.MNR_PRNR_SEQ = B.CUST_SEQ " ).append("\n"); 

	}
}