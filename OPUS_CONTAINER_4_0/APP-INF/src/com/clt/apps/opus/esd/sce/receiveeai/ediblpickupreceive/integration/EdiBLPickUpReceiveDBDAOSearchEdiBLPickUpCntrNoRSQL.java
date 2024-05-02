/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveDBDAOSearchEdiBLPickUpCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2014.11.06 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiBLPickUpReceiveDBDAOSearchEdiBLPickUpCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiBLPickUpCntrNo
	  * </pre>
	  */
	public EdiBLPickUpReceiveDBDAOSearchEdiBLPickUpCntrNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration").append("\n"); 
		query.append("FileName : EdiBLPickUpReceiveDBDAOSearchEdiBLPickUpCntrNoRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO,A.CNMV_YR,A.CNMV_ID_NO,A.CNMV_SEQ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("FROM (SELECT CNTR_NO,CNMV_YR,CNMV_ID_NO,CNMV_SEQ,CNMV_CYC_NO" ).append("\n"); 
		query.append("      FROM   MST_CONTAINER M" ).append("\n"); 
		query.append("      WHERE  M.CNTR_NO LIKE @[cntr_no] ||'%'" ).append("\n"); 
		query.append("        AND  ROWNUM = 1" ).append("\n"); 
		query.append("      ORDER BY CNMV_DT DESC) A" ).append("\n"); 
		query.append("    ,(SELECT CNTR_NO" ).append("\n"); 
		query.append("      FROM   CTM_MOVEMENT" ).append("\n"); 
		query.append("      WHERE  CNTR_NO LIKE @[cntr_no] ||'%'" ).append("\n"); 
		query.append("        AND  ROWNUM = 1) B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}