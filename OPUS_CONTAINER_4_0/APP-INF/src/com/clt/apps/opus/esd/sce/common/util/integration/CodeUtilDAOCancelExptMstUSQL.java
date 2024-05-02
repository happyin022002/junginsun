/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeUtilDAOCancelExptMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.17 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeUtilDAOCancelExptMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception master 의 exception status 를 cancel 로 변경한다.
	  * </pre>
	  */
	public CodeUtilDAOCancelExptMstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.util.integration").append("\n"); 
		query.append("FileName : CodeUtilDAOCancelExptMstUSQL").append("\n"); 
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
		query.append("UPDATE SCE_EXPT_MST" ).append("\n"); 
		query.append("SET    COP_EXPT_STS_CD = 'X'" ).append("\n"); 
		query.append(",NTFD_FLG        = 'N'" ).append("\n"); 
		query.append(",UPD_USR_ID = 'SysDthCop'" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_EXPT_STS_CD in ('O','R')" ).append("\n"); 

	}
}