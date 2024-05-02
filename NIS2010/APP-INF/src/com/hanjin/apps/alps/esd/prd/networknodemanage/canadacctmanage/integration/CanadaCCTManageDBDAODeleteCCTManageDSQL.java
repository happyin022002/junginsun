/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CanadaCCTManageDBDAODeleteCCTManageDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAODeleteCCTManageDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanadaCCTManageDBDAODeleteCCTManage
	  * </pre>
	  */
	public CanadaCCTManageDBDAODeleteCCTManageDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAODeleteCCTManageDSQL").append("\n"); 
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
		query.append("DELETE PRD_CND_TML_CCT_MGMT" ).append("\n"); 
		query.append(" WHERE POR_CD = @[por_cd]" ).append("\n"); 
		query.append("   AND POL_NOD_CD = @[pol_nod_cd]" ).append("\n"); 
		query.append("   AND POR_NOD_CD = nvl(trim(@[por_nod_cd]),' ')" ).append("\n"); 

	}
}