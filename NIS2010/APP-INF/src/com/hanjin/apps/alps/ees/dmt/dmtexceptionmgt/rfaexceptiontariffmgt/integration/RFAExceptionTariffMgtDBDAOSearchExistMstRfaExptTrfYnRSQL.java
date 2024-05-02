/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchExistMstRfaExptTrfYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchExistMstRfaExptTrfYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOSearchExistMstRfaExptTrfYnRSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchExistMstRfaExptTrfYnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration ").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchExistMstRfaExptTrfYnRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(1), 0, 'N', 'Y') AS EXIST_YN" ).append("\n"); 
		query.append("  FROM  DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append(" WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND  DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 

	}
}