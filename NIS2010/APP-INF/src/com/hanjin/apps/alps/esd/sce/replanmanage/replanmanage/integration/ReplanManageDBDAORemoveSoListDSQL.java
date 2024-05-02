/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageDBDAORemoveSoListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.03 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAORemoveSoListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_PLN_SO_LIST 정보를 삭제한다.
	  * </pre>
	  */
	public ReplanManageDBDAORemoveSoListDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAORemoveSoListDSQL").append("\n"); 
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
		query.append("delete from sce_pln_so_list" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("cop_no = @[cop_no]" ).append("\n"); 

	}
}