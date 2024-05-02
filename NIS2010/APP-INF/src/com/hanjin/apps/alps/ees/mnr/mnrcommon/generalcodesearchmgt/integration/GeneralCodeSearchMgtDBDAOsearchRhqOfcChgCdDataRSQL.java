/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.03.11 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD AS CD_ID, " ).append("\n"); 
		query.append("       UPPR_OFC_CD AS CD_DESC" ).append("\n"); 
		query.append("FROM  MNR_OFC_GEN_INFO MOGI " ).append("\n"); 
		query.append("	WHERE   MOGI.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("	AND   MOGI.COST_CD = 'RHQCHG'" ).append("\n"); 

	}
}