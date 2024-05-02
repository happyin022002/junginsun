/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
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

public class WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Sheet Format Type
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL").append("\n"); 
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
		query.append("a.trsp_wo_ofc_cty_cd || a.trsp_wo_seq 	trsp_wo_no," ).append("\n"); 
		query.append("a.wo_vndr_seq     vndr_code," ).append("\n"); 
		query.append("a.wo_fmt_tp_cd," ).append("\n"); 
		query.append("(select	intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("where	intg_cd_id = 'CD00879'" ).append("\n"); 
		query.append("and	intg_cd_val_ctnt = a.wo_fmt_tp_cd)	wo_fmt_tp_nm" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("trs_trsp_wrk_ord a" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and  a.wo_fmt_tp_cd is not null" ).append("\n"); 
		query.append("and rownum < 2" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("and   a.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and  (a.trsp_wo_ofc_cty_cd,a.trsp_wo_seq) = ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 

	}
}