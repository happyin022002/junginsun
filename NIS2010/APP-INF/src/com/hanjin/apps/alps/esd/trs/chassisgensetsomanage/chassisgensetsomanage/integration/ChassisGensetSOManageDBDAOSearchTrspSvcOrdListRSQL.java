/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchTrspSvcOrdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.01
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2009.08.01 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchTrspSvcOrdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Creation시 S/O Seq 조회
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchTrspSvcOrdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchTrspSvcOrdListRSQL").append("\n"); 
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
		query.append("SELECT a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",a.trsp_so_seq" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("#foreach(${key} in ${so_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("WHERE ( a.trsp_so_ofc_cty_cd = SUBSTR('${key}',1,3) AND a.trsp_so_seq = SUBSTR('${key}',4,11))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("OR( a.trsp_so_ofc_cty_cd = SUBSTR('${key}',1,3) AND a.trsp_so_seq = SUBSTR('${key}',4,11))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}