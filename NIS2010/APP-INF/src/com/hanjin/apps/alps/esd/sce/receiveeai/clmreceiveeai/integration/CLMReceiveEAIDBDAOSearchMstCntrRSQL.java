/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLMReceiveEAIDBDAOSearchMstCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.05 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLMReceiveEAIDBDAOSearchMstCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST_CONTAINER 를  조회한다. 해당 테이블에 조회 되지 않는 경우는 CLM 을 받지 않는다.
	  * </pre>
	  */
	public CLMReceiveEAIDBDAOSearchMstCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.integration").append("\n"); 
		query.append("FileName : CLMReceiveEAIDBDAOSearchMstCntrRSQL").append("\n"); 
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
		query.append("select cntr_no," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("cnmv_sts_cd" ).append("\n"); 
		query.append("from mst_container" ).append("\n"); 
		query.append("where cntr_no like TRIM(@[cntr_no]) || '%'" ).append("\n"); 

	}
}