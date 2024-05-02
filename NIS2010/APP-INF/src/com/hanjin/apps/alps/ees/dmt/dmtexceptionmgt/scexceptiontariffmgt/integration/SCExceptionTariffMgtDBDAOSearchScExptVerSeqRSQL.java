/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchScExptVerSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchScExptVerSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCExceptionTariffMgtDBDAOSearchScExptVerSeqRSQL
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchScExptVerSeqRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchScExptVerSeqRSQL").append("\n"); 
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
		query.append("SELECT	NVL(TO_CHAR(MAX(SC_EXPT_VER_SEQ)),'1') AS SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("WHERE	PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("AND     DMDT_EXPT_VER_STS_CD 	= 'A'" ).append("\n"); 
		query.append("AND     SC_EXPT_VER_SEQ = ( SELECT MAX(SC_EXPT_VER_SEQ) FROM DMT_SC_EXPT_VER WHERE	PROP_NO = @[prop_no] )" ).append("\n"); 

	}
}