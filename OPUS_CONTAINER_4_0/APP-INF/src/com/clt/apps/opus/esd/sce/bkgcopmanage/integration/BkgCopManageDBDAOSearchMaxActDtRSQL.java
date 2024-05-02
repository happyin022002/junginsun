/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchMaxActDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.26 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchMaxActDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mty cargo 를 제외한 가장 마지막에 입수된 actual date 를 cop 별로 조회
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchMaxActDtRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchMaxActDtRSQL").append("\n"); 
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
		query.append("select TO_CHAR(max(ACT_DT), 'YYYYMMDDHH24MISS') as ACT_DT" ).append("\n"); 
		query.append("from sce_cop_dtl" ).append("\n"); 
		query.append("where substr(ACT_CD, 1,1) <> 'M' and ACT_DT is not null and cop_no  = @[cop_no]" ).append("\n"); 

	}
}