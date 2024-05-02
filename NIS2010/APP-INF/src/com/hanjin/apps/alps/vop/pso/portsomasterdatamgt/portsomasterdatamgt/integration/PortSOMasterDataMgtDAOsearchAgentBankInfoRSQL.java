/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchAgentBankInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.02 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchAgentBankInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAgentBankInfo
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchAgentBankInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("/* 2009.07.02 from spp use @ for separator" ).append("\n"); 
		query.append("vndr_cnt_cd" ).append("\n"); 
		query.append("|| '|$$|'" ).append("\n"); 
		query.append("|| vndr_lgl_eng_nm" ).append("\n"); 
		query.append("|| '|$$|'" ).append("\n"); 
		query.append("|| vndr_locl_lang_nm" ).append("\n"); 
		query.append("|| '|$$|'" ).append("\n"); 
		query.append("|| vndr_abbr_nm" ).append("\n"); 
		query.append("|| '|$$|'" ).append("\n"); 
		query.append("|| loc_cd" ).append("\n"); 
		query.append("|| '|$$|'" ).append("\n"); 
		query.append("|| ofc_cd" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("cnl_agn_bank_desc" ).append("\n"); 
		query.append("FROM   mdm_vendor" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if(${vndr_seq}!='')" ).append("\n"); 
		query.append("and vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and 1=2 --don't make row" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchAgentBankInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}