/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderMainDBDAOsearchWorkOrderMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOsearchWorkOrderMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Main List
	  * </pre>
	  */
	public WorkOrderMainDBDAOsearchWorkOrderMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOsearchWorkOrderMainListRSQL").append("\n"); 
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
		query.append("select /*+ index_desc(a XAK3TRS_TRSP_WRK_ORD) */" ).append("\n"); 
		query.append("       to_char(a.locl_cre_dt, 'yyyy-mm-dd') cre_dt," ).append("\n"); 
		query.append("				  a.wo_iss_sts_cd ," ).append("\n"); 
		query.append("				  decode(a.wo_iss_sts_cd,'C','Correction','I','Issued','J'," ).append("\n"); 
		query.append("		      			'Rejected','N','Cancellation','P','Partially Rejected','R','Reissued' ) issue_type_nm," ).append("\n"); 
		query.append("				  a.trsp_wo_ofc_cty_cd ||a.trsp_wo_seq	  trsp_wo_no" ).append("\n"); 
		query.append("  from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append(" where a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("   and nvl(a.wo_opn_flg,'N') != 'Y'" ).append("\n"); 
		query.append("   and nvl(a.delt_flg,'N') != 'Y' --a.delt_flg != 'Y'" ).append("\n"); 
		query.append("   and a.wo_iss_sts_cd in ('I','R')" ).append("\n"); 
		query.append("   and a.inter_use_flg != 'Y'" ).append("\n"); 
		query.append("   and rownum <= 5" ).append("\n"); 
		query.append("   and a.locl_cre_dt >= to_date('20170213', 'yyyyMMdd')" ).append("\n"); 

	}
}