/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOOtsTypeExcludeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOOtsTypeExcludeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (UI_SAR-0161)_Outstanding Type To Exclude  Popup
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOOtsTypeExcludeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOOtsTypeExcludeListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   D.LU_CD" ).append("\n"); 
		query.append(" , D.LU_DESC" ).append("\n"); 
		query.append("FROM SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("WHERE H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("AND   D.LU_TP_CD = 'OTS TYPE'" ).append("\n"); 
		query.append("AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY 1,2" ).append("\n"); 

	}
}