/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.05.07 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see 
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseInqRSQL(){
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
		query.append("select" ).append("\n"); 
		query.append("'' sch_expense_gbn" ).append("\n"); 
		query.append(",'' sch_expense_from" ).append("\n"); 
		query.append(",'' sch_expense_to" ).append("\n"); 
		query.append(",'' sch_expense_div" ).append("\n"); 
		query.append(",'' sch_lang" ).append("\n"); 
		query.append(",'' sch_expense_group" ).append("\n"); 
		query.append(",'' sch_tic_cd" ).append("\n"); 
		query.append(",'' sch_slay_flg" ).append("\n"); 
		query.append(",'' sch_sls_div" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseInqRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}