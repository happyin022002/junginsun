/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchThorougputCostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.05 yOng hO lEE
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

public class TerminalAgreementManageDBDAOSearchThorougputCostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Throughput Cost Code Inquiry
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchThorougputCostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchThorougputCostCodeRSQL").append("\n"); 
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
		query.append("#if (${lgscostcdflg} == 'Y')" ).append("\n"); 
		query.append("thrp_lgs_cost_cd	LGS_COST_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("lgs_cost_cd		LGS_COST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_THRP_COST" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd	= SUBSTR(@[tml_agmt_ofc_cty_cd], 1, 3)" ).append("\n"); 
		query.append("AND		tml_agmt_seq		= SUBSTR(@[tml_agmt_ofc_cty_cd], 4, 5)" ).append("\n"); 
		query.append("AND		tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("#if (${lgscostcdflg} == 'Y')" ).append("\n"); 
		query.append("AND		lgs_cost_cd		= @[lgs_cost_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		thrp_lgs_cost_cd = @[lgs_cost_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}