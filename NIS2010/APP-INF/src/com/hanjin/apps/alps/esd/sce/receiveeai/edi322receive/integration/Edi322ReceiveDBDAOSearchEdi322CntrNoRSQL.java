/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Edi322ReceiveDBDAOSearchEdi322CntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.20 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi322ReceiveDBDAOSearchEdi322CntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi322CntrNo
	  * </pre>
	  */
	public Edi322ReceiveDBDAOSearchEdi322CntrNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.integration").append("\n"); 
		query.append("FileName : Edi322ReceiveDBDAOSearchEdi322CntrNoRSQL").append("\n"); 
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
		query.append("        AND  CNMV_CO_CD = 'SML'" ).append("\n"); 
		query.append("        AND  ROWNUM = 1) B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}