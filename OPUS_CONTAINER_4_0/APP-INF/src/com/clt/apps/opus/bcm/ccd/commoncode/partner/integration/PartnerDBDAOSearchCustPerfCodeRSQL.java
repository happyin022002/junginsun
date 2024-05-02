/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PartnerDBDAOSearchCustPerfCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.02.17 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungHo Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustPerfCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주 그룹 코드로 조회한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustPerfCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustPerfCodeRSQL").append("\n"); 
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
		query.append("CUST_GRP_NM" ).append("\n"); 
		query.append(",   OFC_CD" ).append("\n"); 
		query.append(",   SREP_CD" ).append("\n"); 
		query.append(",   VBS_CLSS_CD" ).append("\n"); 
		query.append(",   NBS_CLSS_CD1" ).append("\n"); 
		query.append(",   NBS_CLSS_CD2" ).append("\n"); 
		query.append(",   NBS_CLSS_CD3" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   DELT_FLG" ).append("\n"); 
		query.append(",   EAI_EVNT_DT" ).append("\n"); 
		query.append(",   EAI_IF_ID" ).append("\n"); 
		query.append(",   CUST_GRP_ABBR_NM" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("WHERE CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}