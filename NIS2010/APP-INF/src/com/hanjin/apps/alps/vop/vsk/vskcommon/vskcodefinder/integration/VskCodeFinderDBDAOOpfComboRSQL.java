/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.02 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see 
 * @since J2EE 1.4
 */

public class VskCodeFinderDBDAOOpfComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public VskCodeFinderDBDAOOpfComboRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT   intg_cd_id," ).append("\n"); 
		query.append("intg_cd_val_ctnt," ).append("\n"); 
		query.append("intg_cd_val_dp_desc," ).append("\n"); 
		query.append("intg_cd_val_desc" ).append("\n"); 
		query.append("FROM     com_intg_cd_dtl" ).append("\n"); 
		query.append("where	intg_cd_id = @[cm_code]" ).append("\n"); 
		query.append("AND      (aply_st_dt < TO_CHAR (SYSDATE, 'YYYYMMDD') AND aply_end_dt > TO_CHAR (SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("ORDER BY intg_cd_val_dp_seq" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : BookingComboUtilDBDAOsearchComboRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}