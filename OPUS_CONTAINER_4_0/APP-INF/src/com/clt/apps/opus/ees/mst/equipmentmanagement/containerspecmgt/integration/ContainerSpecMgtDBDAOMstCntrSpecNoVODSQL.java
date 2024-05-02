/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstCntrSpecNoVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
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

public class ContainerSpecMgtDBDAOMstCntrSpecNoVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Specification Creation 화면에서 Year 수정시 Spec No 삭제되는 쿼리
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstCntrSpecNoVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstCntrSpecNoVODSQL").append("\n"); 
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
		query.append("DELETE FROM MST_CNTR_SPEC" ).append("\n"); 
		query.append("WHERE	CNTR_SPEC_NO = @[his_cntr_spec_no]" ).append("\n"); 

	}
}