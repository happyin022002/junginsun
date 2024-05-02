/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAOSearchSetUpDBVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.23 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSetupDBDAOSearchSetUpDBVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsl_slan_cd, port_cd가 Pair로 유효한지 체크
	  * </pre>
	  */
	public VskEmailSetupDBDAOSearchSetUpDBVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPortCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslSlanCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration").append("\n"); 
		query.append("FileName : VskEmailSetupDBDAOSearchSetUpDBVerifyRSQL").append("\n"); 
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
		query.append("B.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_PF_SKD A," ).append("\n"); 
		query.append("VSK_PF_CALL_PORT B" ).append("\n"); 
		query.append("WHERE A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.PF_SVC_TP_CD = B.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND A.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.VSL_SLAN_CD = @[vslSlanCd]" ).append("\n"); 
		query.append("AND B.PORT_CD = @[toPortCd]" ).append("\n"); 

	}
}