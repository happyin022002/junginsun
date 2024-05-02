/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerSpecMgtDBDAORemoveCntrTypeSizeCodeBasicForCimDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAORemoveCntrTypeSizeCodeBasicForCimDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST에서 MDM의 CNTR TP/SZ 데이터 변경 시에 동일한 데이터를 CIM에 형성하기위해 CIM_TP_SZ_DP_SEQ 테이블을 삭제한다.
	  * </pre>
	  */
	public ContainerSpecMgtDBDAORemoveCntrTypeSizeCodeBasicForCimDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAORemoveCntrTypeSizeCodeBasicForCimDSQL").append("\n"); 
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
		query.append("DELETE FROM CIM_TP_SZ_DP_SEQ" ).append("\n"); 

	}
}