/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCopManageDBDAOCheckCopToBeTroMapgAliveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCheckCopToBeTroMapgAliveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container detach 될 때 호출하여 TRO MAPG가 살아있으면 COP cancel 체크를 skip한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCheckCopToBeTroMapgAliveRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCheckCopToBeTroMapgAliveRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CHK_RSLT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A, SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE A.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 

	}
}