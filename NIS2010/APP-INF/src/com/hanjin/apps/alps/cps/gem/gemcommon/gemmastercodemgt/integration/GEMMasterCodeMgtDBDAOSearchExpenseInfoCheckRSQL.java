/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.06 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see 
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseInfoCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 1.공통비용일경우 : TRUE<br>
	  * 	 * 2.관리조직이면서 관리성판촉비일 경우 : TRUE<br>
	  * 	 * 3.영업조직이면서 영업성판촉비일 경우 : TRUE<br>
	  * 	 * 4.그외 FALSE <br>
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseInfoCheckRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT GEN_EXPN_CD ," ).append("\n"); 
		query.append("DELT_FLG" ).append("\n"); 
		query.append("FROM   GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseInfoCheckRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}