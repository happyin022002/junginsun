/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : COPSearchDBDAOSearchSOExistenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.12
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2012.03.12 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchSOExistenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 존재여부를 확인한다. SO 가 실제 존재할 경우에면 COP change 의 validation 을 수행한다.
	  * </pre>
	  */
	public COPSearchDBDAOSearchSOExistenceRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchSOExistenceRSQL").append("\n"); 
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
		query.append("SELECT '1' FROM TRS_TRSP_SVC_ORD WHERE COP_NO = @[cop_no] AND NVL(TRSP_FRST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N' AND CGO_TP_CD = 'F' AND TRSP_SO_TP_CD != 'S' AND NVL(RPLN_UMCH_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' FROM TRS_TRSP_RAIL_BIL_ORD WHERE COP_NO = @[cop_no] AND NVL(TRSP_FRST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N' AND CGO_TP_CD = 'F'" ).append("\n"); 

	}
}