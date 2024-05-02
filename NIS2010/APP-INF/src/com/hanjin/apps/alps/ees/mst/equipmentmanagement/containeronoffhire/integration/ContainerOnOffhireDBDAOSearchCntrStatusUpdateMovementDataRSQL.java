/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateMovementDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.11.12 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrStatusUpdateMovementDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrStatusUpdateMovementData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStatusUpdateMovementDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateMovementDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.CNMV_CO_CD" ).append("\n"); 
		query.append(",A.CNMV_CYC_NO" ).append("\n"); 
		query.append(",A.MVMT_STS_CD" ).append("\n"); 
		query.append(",A.MVMT_CRE_TP_CD" ).append("\n"); 
		query.append(",A.ORG_YD_CD CRNT_YD_CD" ).append("\n"); 
		query.append(",A.DEST_YD_CD" ).append("\n"); 
		query.append(",A.INP_YD_CD" ).append("\n"); 
		query.append(",A.CNMV_EVNT_DT" ).append("\n"); 
		query.append(",DECODE(A.CNTR_ACT_CD, 'A', 'Active','Inactive') CNTR_ACT_CD" ).append("\n"); 
		query.append(",A.CNMV_RMK" ).append("\n"); 
		query.append(",A.CNMV_YR" ).append("\n"); 
		query.append(",A.CNMV_ID_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CTM_MOVEMENT A," ).append("\n"); 
		query.append("MST_CONTAINER B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${noExit} == 'A')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${noExit} == 'E')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNMV_CYC_NO BETWEEN B.CNMV_CYC_NO - 2 AND B.CNMV_CYC_NO" ).append("\n"); 
		query.append("ORDER BY A.CNMV_YR, A.CNMV_ID_NO" ).append("\n"); 

	}
}