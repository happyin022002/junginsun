/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeManagementDBDAOOfcJobListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.officemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManagementDBDAOOfcJobListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OfficeManagementDBDAOOfcJobListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.officemanagement.integration").append("\n"); 
		query.append("FileName : OfficeManagementDBDAOOfcJobListVORSQL").append("\n"); 
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
		query.append("	(select count(ofc_cd) from  com_ofc_role_mtch where ofc_cd = a.ofc_cd and usr_role_cd = @[job_cd2]) check_val_read,         " ).append("\n"); 
		query.append("	(select count(ofc_cd) from  com_ofc_role_mtch where ofc_cd = a.ofc_cd and usr_role_cd = @[job_cd]) check_val,                                                       " ).append("\n"); 
		query.append("	level,	" ).append("\n"); 
		query.append("	ofc_cd," ).append("\n"); 
		query.append("	ar_hd_qtr_ofc_cd," ).append("\n"); 
		query.append("	ofc_eng_nm," ).append("\n"); 
		query.append("	ofc_krn_nm," ).append("\n"); 
		query.append("	prnt_ofc_cd," ).append("\n"); 
		query.append("	ofc_knd_cd," ).append("\n"); 
		query.append("    rep_cust_cnt_cd," ).append("\n"); 
		query.append("    ar_ofc_cd," ).append("\n"); 
		query.append("	'' dummycol," ).append("\n"); 
		query.append("	ofc_tp_cd," ).append("\n"); 
		query.append("	loc_cd" ).append("\n"); 
		query.append("FROM	 mdm_organization a                                            " ).append("\n"); 
		query.append("WHERE nvl(DELT_FLG,'Y') = 'N' --and prnt_ofc_cd='SELHO'" ).append("\n"); 
		query.append("and nvl(clz_dt, sysdate+1) > sysdate                                              " ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD " ).append("\n"); 
		query.append("START WITH OFC_CD='SELHO' " ).append("\n"); 
		query.append("ORDER SIBLINGS BY OFC_KND_CD ASC" ).append("\n"); 

	}
}