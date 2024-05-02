/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchDifferentRHQCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchDifferentRHQCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Office의 Same Or Diff. 여부 확인
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchDifferentRHQCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration ").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchDifferentRHQCheckRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN TPB_GET_HNDL_OFC_FNC('R',STL_RQST_OFC_CD) <> TPB_GET_HNDL_OFC_FNC('R',STL_TO_CLT_CNG_OFC_CD)" ).append("\n"); 
		query.append("THEN 'Y' ELSE 'N' END DIFF_RHQ_CHK" ).append("\n"); 
		query.append("FROM TPB_ADJ_STS" ).append("\n"); 
		query.append("WHERE N3PTY_NO = @[n3pty_no]" ).append("\n"); 

	}
}