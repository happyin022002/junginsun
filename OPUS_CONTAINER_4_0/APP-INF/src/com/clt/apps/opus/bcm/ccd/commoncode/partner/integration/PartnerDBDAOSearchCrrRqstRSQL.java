/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PartnerDBDAOSearchCrrRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.06.14 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YunTaeSeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCrrRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Carrier code를 조회한다
	  * </pre>
	  */
	public PartnerDBDAOSearchCrrRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCrrRqstRSQL").append("\n"); 
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
		query.append("	CRR_CD" ).append("\n"); 
		query.append(", 	CRR_NM" ).append("\n"); 
		query.append(",   BKG_EDI_CD" ).append("\n"); 
		query.append(",   MAPG_CRR_CD" ).append("\n"); 
		query.append(",   DELT_FLG" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   EAI_EVNT_DT" ).append("\n"); 
		query.append(",   EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_CRR_RQST" ).append("\n"); 
		query.append("WHERE RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}