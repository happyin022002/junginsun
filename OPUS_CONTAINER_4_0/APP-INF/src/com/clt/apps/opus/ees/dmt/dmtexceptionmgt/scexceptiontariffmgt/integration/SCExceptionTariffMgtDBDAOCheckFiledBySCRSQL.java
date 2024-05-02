/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOCheckFiledBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.09 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOCheckFiledBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C 가 Filed STS 인지를 체크하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOCheckFiledBySCRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(PROP_NO) CNT" ).append("\n"); 
		query.append("FROM	PRI_SP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	PROP_STS_CD = 'F'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration ").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOCheckFiledBySCRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}