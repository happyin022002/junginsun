/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionDBDAOModifyPreventionViewCntUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.18 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreventionDBDAOModifyPreventionViewCntUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회수 업데이트
	  * </pre>
	  */
	public PreventionDBDAOModifyPreventionViewCntUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_prve_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.integration ").append("\n"); 
		query.append("FileName : PreventionDBDAOModifyPreventionViewCntUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CLM_PRVE SET " ).append("\n"); 
		query.append("	CLM_PRVE_READ_KNT = CLM_PRVE_READ_KNT + 1" ).append("\n"); 
		query.append("WHERE	CLM_PRVE_NO = @[clm_prve_no]" ).append("\n"); 

	}
}