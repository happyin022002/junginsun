/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReplanManageDBDAOSceTroMapgCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.03.13 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSceTroMapgCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/C 의 주요 내역을 비교하여 diff 를 찾는다. diff 발생시에만 booking replan 이 수행된다.
	  * </pre>
	  */
	public ReplanManageDBDAOSceTroMapgCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSceTroMapgCheckRSQL").append("\n"); 
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
		query.append("SELECT  COP_NO" ).append("\n"); 
		query.append("    ,   IO_BND_CD" ).append("\n"); 
		query.append("    ,   AREA_CONTI_CD" ).append("\n"); 
		query.append("    ,   BKG_NO" ).append("\n"); 
		query.append("    ,   TRO_SEQ" ).append("\n"); 
		query.append("    ,   TRO_SUB_SEQ" ).append("\n"); 
		query.append("  FROM SCE_TRO_MAPG" ).append("\n"); 
		query.append(" WHERE COP_NO = @[cop_no]" ).append("\n"); 

	}
}