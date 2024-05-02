/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchSCExceptionVersionSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchSCExceptionVersionSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Tariff 에 최상위 Version Seq. 를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchSCExceptionVersionSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchSCExceptionVersionSeqRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(SC_EXPT_VER_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 

	}
}