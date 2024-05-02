/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaAmendConfirmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.02 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaAmendConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend 후 Confirm 할때 이전 회차 Amdt Exp Date를 Update 한다.
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaAmendConfirmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaAmendConfirmUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TAA_MN SET" ).append("\n"); 
		query.append("#if (${cfm_flg} == 'Y')" ).append("\n"); 
		query.append("EXP_DT = TO_DATE(@[eff_dt],'YYYYMMDD') - 1" ).append("\n"); 
		query.append(", CFM_EXP_DT = EXP_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("EXP_DT = CFM_EXP_DT" ).append("\n"); 
		query.append(", CFM_EXP_DT = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE TAA_PROP_NO = @[taa_prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("#if (${cfm_flg} == 'Y')" ).append("\n"); 
		query.append("AND   EXP_DT >= TO_DATE(@[eff_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   CFM_EXP_DT IS NOT NULL" ).append("\n"); 
		query.append("AND   EXP_DT <> CFM_EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}