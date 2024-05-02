/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.22 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOTrsPreAudCrteListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudCrteList
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudCrteListDSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_expn_aud_crte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteListDSQL").append("\n"); 
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
		query.append("DELETE FROM EAS_TRSP_AUTO_AUD_CRTE" ).append("\n"); 
		query.append(" WHERE AUD_OFC_CD          = @[i_ofc_cd]" ).append("\n"); 
		query.append("   AND EXPN_AUD_CRTE_TP_CD = @[i_expn_aud_crte_tp_cd]" ).append("\n"); 
		query.append("   AND CRE_USR_ID != 'SYSTEM'" ).append("\n"); 

	}
}