/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOSearchSoCode0160ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchSoCode0160ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _COST_SRC_ACCT, _AGMT_RSTR_MGMT 테이블의 데이터 조회
	  * </pre>
	  */
	public CostStructureDBDAOSearchSoCode0160ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_3td",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_4th",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_1st",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_2nd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchSoCode0160ListRSQL").append("\n"); 
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
		query.append("SELECT 	 DECODE(B.LOC_DELT_FLG, 'N', '0', '1') LOC_DELT_FLG" ).append("\n"); 
		query.append(",''IBFLAG" ).append("\n"); 
		query.append(",B.LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",B.N1ST_NOD_CD" ).append("\n"); 
		query.append(",B.N2ND_NOD_CD" ).append("\n"); 
		query.append(",B.N3RD_NOD_CD" ).append("\n"); 
		query.append(",B.N4TH_NOD_CD" ).append("\n"); 
		query.append(",'N' ALL_FLG" ).append("\n"); 
		query.append("#foreach($code IN ${header})" ).append("\n"); 
		query.append(",SUM(DECODE(A.COA_COST_SRC_CD,'$code',DECODE(B.COST_SRC_USE_FLG, 'N', '0', '1'), '0')) $code" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COA_COST_SRC_ACCT A" ).append("\n"); 
		query.append(",COA_AGMT_RSTR_MGMT B" ).append("\n"); 
		query.append("WHERE 	 1=1" ).append("\n"); 
		query.append("AND 	 A.COA_COST_SRC_CD = B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("AND 	 A.COST_ASS_BSE_CD = 'C'" ).append("\n"); 
		query.append("#if (${f_1st} != '')" ).append("\n"); 
		query.append("AND B.N1ST_NOD_CD LIKE @[f_1st]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_2nd} != '')" ).append("\n"); 
		query.append("AND B.N2ND_NOD_CD LIKE @[f_2nd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_3td} != '')" ).append("\n"); 
		query.append("AND B.N3RD_NOD_CD LIKE @[f_3td]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_4th} != '')" ).append("\n"); 
		query.append("AND B.N4TH_NOD_CD LIKE @[f_4th]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY DECODE(B.LOC_DELT_FLG, 'N', '0', '1')" ).append("\n"); 
		query.append(",B.LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",B.N1ST_NOD_CD" ).append("\n"); 
		query.append(",B.N2ND_NOD_CD" ).append("\n"); 
		query.append(",B.N3RD_NOD_CD" ).append("\n"); 
		query.append(",B.N4TH_NOD_CD" ).append("\n"); 

	}
}