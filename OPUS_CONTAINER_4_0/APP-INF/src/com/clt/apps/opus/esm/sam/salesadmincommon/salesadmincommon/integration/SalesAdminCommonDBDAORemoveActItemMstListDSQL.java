/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAORemoveActItemMstListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.20 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAORemoveActItemMstListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Del 체크가 되어있는 Main type의 삭제용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAORemoveActItemMstListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAORemoveActItemMstListDSQL").append("\n"); 
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
		query.append("DELETE FROM sam_sls_act_tp_mst" ).append("\n"); 
		query.append("WHERE sls_act_tp_cd = @[sls_act_tp_cd]" ).append("\n"); 

	}
}