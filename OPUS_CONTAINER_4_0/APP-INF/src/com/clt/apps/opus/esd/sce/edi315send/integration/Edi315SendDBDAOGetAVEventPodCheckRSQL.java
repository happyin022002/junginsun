/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetAVEventPodCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.03 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetAVEventPodCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAVEventPodCheckRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOGetAVEventPodCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetAVEventPodCheckRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(D XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("       SUBSTR(D.NOD_CD,1, 5) CURR_EVENT_YARD" ).append("\n"); 
		query.append("  FROM SCE_COP_DTL D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND D.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND D.ACT_CD LIKE 'FI%DO'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}