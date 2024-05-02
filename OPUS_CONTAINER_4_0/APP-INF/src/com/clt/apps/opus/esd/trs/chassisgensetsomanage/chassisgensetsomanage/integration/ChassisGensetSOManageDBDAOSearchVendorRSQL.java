/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.08.24 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor List Retrieve
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchVendorRSQL").append("\n"); 
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
		query.append("SELECT vndr_seq AS vndr_no" ).append("\n"); 
		query.append("      ,vndr_lgl_eng_nm AS vndr_nm_eng" ).append("\n"); 
		query.append("	  ,NVL(b.curr_cd,a.PAY_CURR_CD) AS vndr_cnt_curr_cd" ).append("\n"); 
		query.append("      ,NVL(A.WO_EDI_USE_FLG, 'N') AS wo_edi_use_flg" ).append("\n"); 
		query.append("  FROM mdm_vendor a" ).append("\n"); 
		query.append("      ,mdm_currency b" ).append("\n"); 
		query.append(" WHERE a.vndr_seq = @[VNDR_SEQ]" ).append("\n"); 
		query.append("   AND a.vndr_cnt_cd = b.cnt_cd(+)" ).append("\n"); 
		query.append("   AND b.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("   AND a.delt_flg = 'N'" ).append("\n"); 

	}
}