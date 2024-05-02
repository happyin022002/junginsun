/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeManageDBDAOSearchOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManageDBDAOSearchOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeList
	  * </pre>
	  */
	public OfficeManageDBDAOSearchOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration").append("\n"); 
		query.append("FileName : OfficeManageDBDAOSearchOfficeListRSQL").append("\n"); 
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
		query.append("SELECT n3pty_ofc_tp_cd" ).append("\n"); 
		query.append("      ,ofc_cd" ).append("\n"); 
		query.append("      ,rhq_cd" ).append("\n"); 
		query.append("      ,n3pty_ctrl_ofc_cd" ).append("\n"); 
		query.append("      ,n3pty_ofc_cd" ).append("\n"); 
		query.append("      ,n3pty_ar_ofc_cd" ).append("\n"); 
		query.append("      ,delt_flg" ).append("\n"); 
		query.append("      ,cre_usr_id" ).append("\n"); 
		query.append("      ,to_char(cre_dt,'YYYY/MM/DD') AS cre_dt" ).append("\n"); 
		query.append("      ,upd_usr_id" ).append("\n"); 
		query.append("      ,to_char(upd_dt,'YYYY/MM/DD') AS upd_dt" ).append("\n"); 
		query.append("  FROM tpb_hndl_ofc" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${s_n3pty_ofc_tp_cd} != '') " ).append("\n"); 
		query.append("   AND n3pty_ofc_tp_cd = @[s_n3pty_ofc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("   AND rhq_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND ofc_cd = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND ofc_cd LIKE @[s_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY rhq_cd, n3pty_ofc_cd, ofc_cd" ).append("\n"); 

	}
}