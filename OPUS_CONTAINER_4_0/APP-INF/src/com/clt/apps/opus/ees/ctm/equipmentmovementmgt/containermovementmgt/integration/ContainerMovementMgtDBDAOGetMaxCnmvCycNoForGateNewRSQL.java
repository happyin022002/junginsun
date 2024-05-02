/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT MAX(CNMV_CYC_NO) CNMV_CYC_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT MAX (BC.CNMV_CYC_NO) AS CNMV_CYC_NO" ).append("\n"); 
		query.append("	  FROM BKG_CONTAINER BC, BKG_BOOKING BO" ).append("\n"); 
		query.append("	 WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	   AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("	   AND NVL (BO.BKG_STS_CD, '') <> 'X'" ).append("\n"); 
		query.append("	   AND NVL (BO.BKG_STS_CD, '') <> 'S'" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT MAX (BC.CNMV_CYC_NO) AS CNMV_CYC_NO" ).append("\n"); 
		query.append("	  FROM CTM_BKG_CNTR BC, CTM_BOOKING BO" ).append("\n"); 
		query.append("	 WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	   AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("	   AND BC.CNMV_CYC_NO <> 9998" ).append("\n"); 
		query.append("	   AND NVL (BO.BKG_STS_CD, '') <> 'X'" ).append("\n"); 
		query.append("	   AND NVL (BO.BKG_STS_CD, '') <> 'S'" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}