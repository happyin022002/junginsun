/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ZDAOCstmsClrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.01.07 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ZDAOCstmsClrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ZDAOCstmsClrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : ZDAOCstmsClrVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' as bl_no" ).append("\n"); 
		query.append(",'' as cgo_evnt_nm" ).append("\n"); 
		query.append(",'' as cgor_team_cd" ).append("\n"); 
		query.append(",'' as cstms_clr_cd" ).append("\n"); 
		query.append(",'' as cstms_ds_po_cd" ).append("\n"); 
		query.append(",'' as cstms_loc_cd" ).append("\n"); 
		query.append(",'' as evnt_dt" ).append("\n"); 
		query.append(",'' as evnt_ofc_cd" ).append("\n"); 
		query.append(",'' as evnt_usr_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Return Values */" ).append("\n"); 
		query.append(",'' as cstms_chk" ).append("\n"); 
		query.append(",'' as cstms_chk_cnt" ).append("\n"); 
		query.append(",'' as us_chk" ).append("\n"); 
		query.append(",'' as cnt_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' as his_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}