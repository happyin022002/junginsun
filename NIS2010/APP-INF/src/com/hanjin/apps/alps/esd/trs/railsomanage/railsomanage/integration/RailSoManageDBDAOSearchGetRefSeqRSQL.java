/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailSoManageDBDAOSearchGetRefSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchGetRefSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ref_seq 채번
	  * </pre>
	  */
	public RailSoManageDBDAOSearchGetRefSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchGetRefSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(REF_SEQ)+1 ,1) REF_SEQ" ).append("\n"); 
		query.append("  FROM EQR_REPO_EXE_SO_IF A" ).append("\n"); 
		query.append(" WHERE REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("   AND PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("   AND PLN_SEQ = @[pln_seq]" ).append("\n"); 
		query.append("   AND REF_ID = @[ref_id]" ).append("\n"); 

	}
}