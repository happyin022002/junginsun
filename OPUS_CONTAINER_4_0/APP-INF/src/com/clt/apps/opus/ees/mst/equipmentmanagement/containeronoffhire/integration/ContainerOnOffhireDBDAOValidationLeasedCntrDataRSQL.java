/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOValidationLeasedCntrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOValidationLeasedCntrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Validation Check
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOValidationLeasedCntrDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOValidationLeasedCntrDataRSQL").append("\n"); 
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
		query.append("SELECT MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(SUBSTR(@[cntr_no], 1, 10)) AS RESSTR" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(1)||'' RESSTR" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("##${cntr_no3}" ).append("\n"); 
		query.append("#if ($cntr_no3.length() != 0) " ).append("\n"); 
		query.append("AND   A.CNTR_NO   = MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(SUBSTR(MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no]), 1, 10))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${cntr_no3}" ).append("\n"); 
		query.append("#if ($cntr_no3.length() == 0)" ).append("\n"); 
		query.append("AND   A.CNTR_NO   = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}