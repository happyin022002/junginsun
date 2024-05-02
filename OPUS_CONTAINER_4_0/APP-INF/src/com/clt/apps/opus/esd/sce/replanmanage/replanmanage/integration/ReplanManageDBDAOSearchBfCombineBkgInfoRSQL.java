/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchBfCombineBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.24 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchBfCombineBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combine 된 booking no 로 combine 되기 이전 booking 정보를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchBfCombineBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchBfCombineBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE TO_BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}