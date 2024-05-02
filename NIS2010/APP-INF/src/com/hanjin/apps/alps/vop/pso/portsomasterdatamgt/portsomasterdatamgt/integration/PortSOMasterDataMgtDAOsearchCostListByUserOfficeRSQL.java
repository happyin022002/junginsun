/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.29 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cost 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("charge_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL").append("\n"); 
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
		query.append("select  @[charge_type] , t2.acct_cd, t2.lgs_cost_cd, lgs_cost_full_nm, decode(t1.lgs_cost_cd, null, '0', '1') as chk" ).append("\n"); 
		query.append("from    pso_inv_ofc_cost t1, tes_lgs_cost t2" ).append("\n"); 
		query.append("where   t1.lgs_cost_cd (+)  = t2.lgs_cost_cd" ).append("\n"); 
		query.append("and     t1.ofc_cd      (+)     = @[ofc_cd]" ).append("\n"); 
		query.append("--and     t2.lgs_cost_subj_cd in ('pt', 'cn')" ).append("\n"); 
		query.append("and     t2.acct_cd          <> '999999'" ).append("\n"); 
		query.append("#if( ${charge_type} == '0')" ).append("\n"); 
		query.append("and t2.acct_cd like '5117%'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '1')" ).append("\n"); 
		query.append("and t2.acct_cd like '5118%'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '2')" ).append("\n"); 
		query.append("and t2.acct_cd like '5119%'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '3')" ).append("\n"); 
		query.append("and t2.acct_cd in ( /*'962111' ,*/ '564611' ) --[2010.03.29:jmh]" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 

	}
}