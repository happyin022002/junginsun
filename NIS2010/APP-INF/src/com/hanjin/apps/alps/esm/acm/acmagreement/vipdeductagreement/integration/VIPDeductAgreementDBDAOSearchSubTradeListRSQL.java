/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VIPDeductAgreementDBDAOSearchSubTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VIPDeductAgreementDBDAOSearchSubTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub trade code list 조회.
	  * </pre>
	  */
	public VIPDeductAgreementDBDAOSearchSubTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration ").append("\n"); 
		query.append("FileName : VIPDeductAgreementDBDAOSearchSubTradeListRSQL").append("\n"); 
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
		query.append("SELECT SUB_TRD_CD" ).append("\n"); 
		query.append("FROM MDM_SUB_TRD" ).append("\n"); 
		query.append("WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("  AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD ASC" ).append("\n"); 

	}
}