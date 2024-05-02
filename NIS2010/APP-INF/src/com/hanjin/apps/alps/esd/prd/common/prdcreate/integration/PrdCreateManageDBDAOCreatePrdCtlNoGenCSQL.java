/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManagerDBDAOCreatePrdCtlNoGenCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.24 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOCreatePrdCtlNoGenCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreatePrdCtlNoGen
	  * </pre>
	  */
	public PrdCreateManageDBDAOCreatePrdCtlNoGenCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pc_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManagerDBDAOCreatePrdCtlNoGenCSQL").append("\n"); 
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
		query.append("SELECT    @[pc_mode]" ).append("\n"); 
		query.append("|| TO_CHAR (SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("|| LPAD (prd_cop_pcno_seq.NEXTVAL, 9, 0) hd_pctl_no" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}