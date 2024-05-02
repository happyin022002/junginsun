/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostAssignDBDAOSearchCopNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.06.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchCopNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 BKG의 COP NUMBER 가져오기
	  * </pre>
	  */
	public CostAssignDBDAOSearchCopNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchCopNoListRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("--//searchCopNoList(String bkg_no, String bkg_no_split)" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT /*+ LEADING(A1) USE_NL(A2) */" ).append("\n"); 
		query.append("       DISTINCT A2.PCTL_NO COP_NO" ).append("\n"); 
		query.append("           FROM COA_COM_PARA A1, COA_COM_COST_PARA A2" ).append("\n"); 
		query.append("          WHERE A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("            AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       ORDER BY A2.PCTL_NO" ).append("\n"); 

	}
}