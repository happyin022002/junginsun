/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalAgreementManageDBDAODeleteAgreement_modifyDelete06DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAODeleteAgreement_modifyDelete06DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteAgreement_modifyDelete06
	  * </pre>
	  */
	public TerminalAgreementManageDBDAODeleteAgreement_modifyDelete06DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("tml_agmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAODeleteAgreement_modifyDelete06DSQL").append("\n"); 
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
		query.append("DELETE	TES_TML_AGMT_EQ_TP_SZ 													" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd = @[tml_agmt_ofc_cty_cd] " ).append("\n"); 
		query.append("AND		tml_agmt_seq		= @[tml_agmt_seq] " ).append("\n"); 
		query.append("AND		tml_agmt_ver_no		= @[tml_agmt_ver_no] 	" ).append("\n"); 
		query.append("AND		tml_agmt_dtl_seq IN (SELECT tml_agmt_dtl_seq " ).append("\n"); 
		query.append("							FROM	TES_TML_AGMT_DTL " ).append("\n"); 
		query.append("							WHERE	tml_agmt_ofc_cty_cd = @[tml_agmt_ofc_cty_cd] " ).append("\n"); 
		query.append("							AND		tml_agmt_seq		= @[tml_agmt_seq] " ).append("\n"); 
		query.append("							AND		tml_agmt_ver_no		= @[tml_agmt_ver_no] 	" ).append("\n"); 
		query.append("							AND		tml_agmt_tp_cd = @[tml_agmt_tp_cd] )" ).append("\n"); 

	}
}