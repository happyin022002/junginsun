/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOModifyTrsCrteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.22 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOModifyTrsCrteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert 전 이미 저장된 데이터인지 확인한다.
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOModifyTrsCrteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_crte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration ").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOModifyTrsCrteRSQL").append("\n"); 
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
		query.append(" SELECT COUNT(1) AS CNT FROM  EAS_TRSP_AUTO_AUD_CRTE" ).append("\n"); 
		query.append(" WHERE AUD_OFC_CD            = @[aud_ofc_cd]" ).append("\n"); 
		query.append("   AND TRSP_CRR_MOD_CD       = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("   AND CGO_TP_CD             = @[cgo_tp_cd]" ).append("\n"); 
		query.append("   AND EXPN_AUD_CRTE_TP_CD   = @[expn_aud_crte_tp_cd]" ).append("\n"); 

	}
}