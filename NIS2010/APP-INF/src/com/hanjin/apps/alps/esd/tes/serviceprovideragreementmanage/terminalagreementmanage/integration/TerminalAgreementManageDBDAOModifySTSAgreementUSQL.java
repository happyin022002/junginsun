/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOModifySTSAgreementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.09 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOModifySTSAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status Update
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOModifySTSAgreementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOModifySTSAgreementUSQL").append("\n"); 
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
		query.append("UPDATE	TES_TML_AGMT_HDR SET" ).append("\n"); 
		query.append("tml_agmt_sts_cd = 'P'" ).append("\n"); 
		query.append(", agmt_rmk		= @[agmt_rmk]" ).append("\n"); 
		query.append(", upd_usr_id	= @[upd_usr_id]" ).append("\n"); 
		query.append(", upd_dt		= SYSDATE" ).append("\n"); 
		query.append(", locl_upd_dt	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		tml_agmt_seq 		= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND		tml_agmt_ver_no 	= @[tml_agmt_ver_no]" ).append("\n"); 

	}
}