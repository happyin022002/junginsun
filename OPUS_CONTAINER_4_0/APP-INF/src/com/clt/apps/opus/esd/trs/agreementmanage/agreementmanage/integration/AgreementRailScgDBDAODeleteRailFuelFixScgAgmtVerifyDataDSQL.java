/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRailScgDBDAODeleteRailFuelFixScgAgmtVerifyDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.05.22 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAODeleteRailFuelFixScgAgmtVerifyDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement verify를 위한 temp테이블에 delete
	  * </pre>
	  */
	public AgreementRailScgDBDAODeleteRailFuelFixScgAgmtVerifyDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtRailTmpSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAODeleteRailFuelFixScgAgmtVerifyDataDSQL").append("\n"); 
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
		query.append("DELETE FROM" ).append("\n"); 
		query.append("    TRS_AGMT_RAIL_SCG_RT_TMP" ).append("\n"); 
		query.append("#if (${agmtRailTmpSeq} != '')" ).append("\n"); 
		query.append("WHERE AGMT_RAIL_TMP_SEQ = @[agmtRailTmpSeq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}