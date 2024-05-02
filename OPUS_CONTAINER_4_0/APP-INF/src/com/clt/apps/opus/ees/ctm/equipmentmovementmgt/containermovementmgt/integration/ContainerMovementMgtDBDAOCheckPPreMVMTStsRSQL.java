/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckPPreMVMTStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.27 
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

public class ContainerMovementMgtDBDAOCheckPPreMVMTStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPPreMVMTSts
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckPPreMVMTStsRSQL(){
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
		query.append("FileName : ContainerMovementMgtDBDAOCheckPPreMVMTStsRSQL").append("\n"); 
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
		query.append("SELECT MVMT_STS_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(ORDER BY CNMV_YR DESC, CNMV_SEQ DESC, CNMV_SPLIT_NO DESC) AS SEQ, CNMV_ID_NO, MVMT_STS_CD" ).append("\n"); 
		query.append("    FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("    WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ORDER BY CNMV_YR DESC, CNMV_SEQ DESC, CNMV_SPLIT_NO DESC)" ).append("\n"); 
		query.append("WHERE SEQ = 2" ).append("\n"); 

	}
}