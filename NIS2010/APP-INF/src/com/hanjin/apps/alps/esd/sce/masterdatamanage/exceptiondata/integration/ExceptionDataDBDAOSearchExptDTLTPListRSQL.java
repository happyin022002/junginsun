/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExptDTLTPListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.15 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExptDTLTPListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select dtl_tp_list
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExptDTLTPListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_expt_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExptDTLTPListRSQL").append("\n"); 
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
		query.append("select distinct EXPT_CD, EXPT_CD_NM" ).append("\n"); 
		query.append("from sce_expt_cd" ).append("\n"); 
		query.append("where substr(EXPT_CD, 4, length(EXPT_CD) ) = '00000' and ACT_FLG = 'Y'" ).append("\n"); 
		query.append("and substr(EXPT_CD, 1, 1 ) = @[f_expt_tp]" ).append("\n"); 
		query.append("and substr(EXPT_CD, 2, length(EXPT_CD) ) <> '0000000'" ).append("\n"); 
		query.append("order by EXPT_CD_NM, EXPT_CD" ).append("\n"); 

	}
}