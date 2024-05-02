/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByDifferenceDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByDifferenceDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAS_MNR_PRE_AUD_RTO_CFG에서 사용자 지정 office code 삭제
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByDifferenceDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration ").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByDifferenceDSQL").append("\n"); 
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
		query.append("DELETE EAS_MNR_PRE_AUD_RTO_CFG" ).append("\n"); 
		query.append("WHERE AUD_OFC_CD = @[i_ofc_cd]" ).append("\n"); 

	}
}