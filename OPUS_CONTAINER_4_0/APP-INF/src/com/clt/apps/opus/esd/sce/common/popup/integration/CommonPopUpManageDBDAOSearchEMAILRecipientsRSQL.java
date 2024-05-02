/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonPopUpManageDBDAOSearchEMAILRecipientsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOSearchEMAILRecipientsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEMAILRecipients
	  * </pre>
	  */
	public CommonPopUpManageDBDAOSearchEMAILRecipientsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOSearchEMAILRecipientsRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT(CNTC_PSON_EML) CNTC_PSON_EML" ).append("\n"); 
		query.append("FROM  BKG_CNTC_PSON PN, SCE_EXPT_MST EX" ).append("\n"); 
		query.append("WHERE BKG_CNTC_PSON_TP_CD = 'BK'" ).append("\n"); 
		query.append("/* condition - bkg_no */" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	AND EX.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			($ele)" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			,($ele) " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   PN.BKG_NO(+)=EX.BKG_NO" ).append("\n"); 

	}
}