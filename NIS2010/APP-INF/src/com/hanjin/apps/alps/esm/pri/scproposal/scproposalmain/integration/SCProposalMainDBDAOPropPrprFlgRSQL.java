/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCProposalMainDBDAOPropPrprFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.11
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2016.01.11 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPropPrprFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건 
	  * </pre>
	  */
	public SCProposalMainDBDAOPropPrprFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPropPrprFlgRSQL").append("\n"); 
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
		query.append("SELECT PROP_PRPR_FLG " ).append("\n"); 
		query.append("  FROM PRI_SP_HDR HDR" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND PROP_PRPR_FLG = 'N' " ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("               SELECT 1" ).append("\n"); 
		query.append("                 FROM PRI_SP_DUR DUR" ).append("\n"); 
		query.append("                WHERE DUR.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("                  AND DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("                  AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD') " ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}