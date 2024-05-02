/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate logic.
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_TRI_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append(" WHERE TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = (SELECT DISTINCT AMDT_SEQ " ).append("\n"); 
		query.append("					 FROM PRI_TRI_RT B" ).append("\n"); 
		query.append("                    WHERE B.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("                      AND A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("                      AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND B.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}