/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.08 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Suk Jun Kim
 * @see 
 * @since J2EE 1.4
 */

public class ContainerSpecMgtDBDAORemoveEqPreStatusCodeDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerSpecMgtDBDAORemoveEqStatusCode
	  * </pre>
	  */
	public ContainerSpecMgtDBDAORemoveEqPreStatusCodeDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pre_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MST_CNTR_PRE_STS" ).append("\n"); 
		query.append("WHERE	CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("AND   CNTR_PRE_STS_CD = @[cntr_pre_sts_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.nis2010.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAORemoveEqStatusCodeDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}