/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilDBDAOExistsLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.30 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOExistsLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exists Lane
	  * </pre>
	  */
	public OpfUtilDBDAOExistsLaneVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 	VSL_SLAN_CD	AS VAL," ).append("\n"); 
		query.append("VSL_SlAN_NM AS NAME" ).append("\n"); 
		query.append("FROM  	MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE 	NVL(DELT_FLG, 'N') <> 	'Y'" ).append("\n"); 
		query.append("AND		VSL_SLAN_CD			=	@[vsl_slan_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOExistsLaneVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}