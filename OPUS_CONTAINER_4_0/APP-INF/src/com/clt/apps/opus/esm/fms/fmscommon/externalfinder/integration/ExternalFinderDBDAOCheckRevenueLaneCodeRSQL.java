/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalFinderDBDAOCheckRevenueLaneCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.02 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOCheckRevenueLaneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Lane Code
	  * </pre>
	  */
	public ExternalFinderDBDAOCheckRevenueLaneCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select rlane_cd" ).append("\n"); 
		query.append("from mdm_rev_lane" ).append("\n"); 
		query.append("where rlane_cd = @[rlane_cd]" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration ").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOCheckRevenueLaneCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}