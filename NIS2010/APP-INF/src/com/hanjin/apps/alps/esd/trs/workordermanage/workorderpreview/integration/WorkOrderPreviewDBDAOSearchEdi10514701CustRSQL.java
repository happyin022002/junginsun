/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701CustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.03.17 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi10514701CustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_105147_01_CUST
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701CustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701CustRSQL").append("\n"); 
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
		query.append("SELECT cust.bkg_cust_tp_cd cust_tp" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(cust.cust_nm,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,100)) cust_nm" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(cust.cust_addr,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,100)) cust_addr" ).append("\n"); 
		query.append("--,cust.fax_no cust_fax -- kys 확인하기!!" ).append("\n"); 
		query.append("FROM bkg_customer cust" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND so.bkg_no = cust.bkg_no" ).append("\n"); 
		query.append("--  eNIS 에도 1:1 매칭이 아님. 정정필요시 주석 해제" ).append("\n"); 
		query.append("--	AND so.bkg_no = cust.bkg_no(+)" ).append("\n"); 
		query.append("--	and so.CUST_CNT_CD = cust.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("--	and so.CUST_SEQ = cust.CUST_SEQ(+)" ).append("\n"); 

	}
}