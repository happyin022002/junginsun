/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OfficeManageDBDAOSearchOfficeListForInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.03.04 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManageDBDAOSearchOfficeListForInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeListForInqiury
	  * </pre>
	  */
	public OfficeManageDBDAOSearchOfficeListForInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : OfficeManageDBDAOSearchOfficeListForInquiryRSQL").append("\n"); 
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
		query.append("SELECT A.ofc_cd" ).append("\n"); 
		query.append(",A.n3pty_ofc_cd" ).append("\n"); 
		query.append(",B.rhq_cd" ).append("\n"); 
		query.append(",B.n3pty_ctrl_ofc_cd" ).append("\n"); 
		query.append(",B.n3pty_ar_ofc_cd" ).append("\n"); 
		query.append(",B.upd_usr_id" ).append("\n"); 
		query.append(",to_char(B.upd_dt, 'YYYY-MM-DD HH24:MI') upd_dt" ).append("\n"); 
		query.append("--	  ,to_char(TPB_GET_LCL_DATE_FNC(B.upd_dt,?), 'YYYY-MM-DD HH24:MI') upd_dt" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC A, TPB_HNDL_OFC B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.ofc_cd = A.n3pty_ofc_cd" ).append("\n"); 
		query.append("AND A.n3pty_ofc_tp_cd = 'G'" ).append("\n"); 
		query.append("AND B.n3pty_ofc_tp_cd = 'T'" ).append("\n"); 
		query.append("AND A.delt_flg = 'N'" ).append("\n"); 
		query.append("AND B.delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND B.rhq_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.ofc_cd = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("AND ( A.ofc_cd LIKE @[s_ofc_cd]||'%' OR B.ofc_cd LIKE @[s_ofc_cd]||'%' OR B.rhq_cd LIKE @[s_ofc_cd]||'%'" ).append("\n"); 
		query.append("OR B.n3pty_ctrl_ofc_cd LIKE @[s_ofc_cd]||'%' OR B.n3pty_ar_ofc_cd LIKE @[s_ofc_cd]||'%' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.rhq_cd, A.n3pty_ofc_cd, A.ofc_cd" ).append("\n"); 

	}
}