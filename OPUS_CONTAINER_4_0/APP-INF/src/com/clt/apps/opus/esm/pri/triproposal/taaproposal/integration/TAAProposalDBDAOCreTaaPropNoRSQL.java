/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAOCreTaaPropNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.26 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOCreTaaPropNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA_PROP_NO를 생성합니다.
	  * </pre>
	  */
	public TAAProposalDBDAOCreTaaPropNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOCreTaaPropNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[ofc_cd], 0, 3) || SUBSTR(TO_CHAR(SYSDATE, 'YYYY'), -2)" ).append("\n"); 
		query.append("|| LPAD(NVL(MAX(SUBSTR (TAA_PROP_NO, 6, 4)), 0) + 1, 4, '0') TAA_PROP_NO" ).append("\n"); 
		query.append("FROM PRI_TAA_MN" ).append("\n"); 
		query.append("WHERE TAA_PROP_NO LIKE SUBSTR(@[ofc_cd], 0, 3) || SUBSTR(TO_CHAR(SYSDATE, 'YYYY'), -2) || '%'" ).append("\n"); 

	}
}