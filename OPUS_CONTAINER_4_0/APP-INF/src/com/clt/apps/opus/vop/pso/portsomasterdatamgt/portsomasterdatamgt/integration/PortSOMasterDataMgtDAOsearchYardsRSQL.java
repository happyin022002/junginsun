/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchYardsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.03 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchYardsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * yard 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchYardsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchYardsRSQL").append("\n"); 
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
		query.append("SELECT YD_CD, YD_NM" ).append("\n"); 
		query.append("FROM   MDM_YARD" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND	   (NVL(YD_FCTY_TP_MRN_TML_FLG,' ') = 'Y' OR NVL(YD_FCTY_TP_BRG_RMP_FLG,' ') = 'Y' )" ).append("\n"); 
		query.append("AND    LOC_CD =  @[yd_cd]" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}