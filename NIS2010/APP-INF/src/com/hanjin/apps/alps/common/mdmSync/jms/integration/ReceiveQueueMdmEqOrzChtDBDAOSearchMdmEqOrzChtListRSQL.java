/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueMdmEqOrzChtDBDAOSearchMdmEqOrzChtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.09 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmEqOrzChtDBDAOSearchMdmEqOrzChtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_EQ_ORZ_CHT 기존 데이터 유무 확인
	  * </pre>
	  */
	public ReceiveQueueMdmEqOrzChtDBDAOSearchMdmEqOrzChtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueMdmEqOrzChtDBDAOSearchMdmEqOrzChtListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(1) SCC_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = @[scc_cd]" ).append("\n"); 

	}
}