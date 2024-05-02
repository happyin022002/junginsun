/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.29 성덕경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEONG DUK KYUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("MNR_CD_DP_DESC AS SHEET1_EV_DESC," ).append("\n"); 
		query.append("MNR_CD_DFLT_PNT_NO AS SHEET1_MAX_PNT_NO" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PRNT_CD_ID = 'CD00003'" ).append("\n"); 
		query.append("ORDER BY MNR_CD_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}