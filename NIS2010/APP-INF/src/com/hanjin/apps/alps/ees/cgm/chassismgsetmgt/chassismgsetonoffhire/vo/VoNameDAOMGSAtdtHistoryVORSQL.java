/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VoNameDAOMGSAtdtHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.26 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOMGSAtdtHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MGSAtdtHistoryINVO / MGSAtdtHistoryMGTVO
	  * </pre>
	  */
	public VoNameDAOMGSAtdtHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo").append("\n"); 
		query.append("FileName : VoNameDAOMGSAtdtHistoryVORSQL").append("\n"); 
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
		query.append("'' AS DTCH_DT" ).append("\n"); 
		query.append(",'' AS DTCH_DT_DAY" ).append("\n"); 
		query.append(",'' AS DTCH_DT_HD" ).append("\n"); 
		query.append(",'' AS DTCH_YD_CD" ).append("\n"); 
		query.append(",'' AS ATCH_YD_CD" ).append("\n"); 
		query.append(",'' AS ATCH_DT" ).append("\n"); 
		query.append(",'' AS ATCH_DT_DAY" ).append("\n"); 
		query.append(",'' AS ATCH_DT_HD" ).append("\n"); 
		query.append(",'' AS CNTR_CHSS" ).append("\n"); 
		query.append(",'' AS EQ_NO" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS ORG_ATCH_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}