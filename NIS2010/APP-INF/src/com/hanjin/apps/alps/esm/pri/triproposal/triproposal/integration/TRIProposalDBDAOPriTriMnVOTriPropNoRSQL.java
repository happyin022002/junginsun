/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriMnVOTriPropNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.11.25 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriMnVOTriPropNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No 생성
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriMnVOTriPropNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriMnVOTriPropNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[cre_usr_id], 0, 3) || TO_CHAR(SYSDATE, 'YY') ||" ).append("\n"); 
		query.append("NVL((SELECT /*+ INDEX_DESC(A XPKPRI_TRI_MN) */" ).append("\n"); 
		query.append("LPAD(SUBSTR(A.TRI_PROP_NO, 6) + 1, 4, '0')" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO LIKE SUBSTR(@[cre_usr_id], 0, 3) || TO_CHAR(SYSDATE, 'YY') || '%'" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'0001') AS NEXT_TRI_PROP_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}