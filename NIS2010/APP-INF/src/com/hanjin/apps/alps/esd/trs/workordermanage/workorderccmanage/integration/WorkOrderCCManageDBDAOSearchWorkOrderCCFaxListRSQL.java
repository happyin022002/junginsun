/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCFaxListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.12.16 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOSearchWorkOrderCCFaxListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 vndr_seq 에 대한 팩스 정보 목록을 조회한다.
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOSearchWorkOrderCCFaxListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCFaxListRSQL").append("\n"); 
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
		query.append("A.TRS_CHK" ).append("\n"); 
		query.append(",   A.MDM_CHK" ).append("\n"); 
		query.append(",   A.WO_FAX_NO" ).append("\n"); 
		query.append(",   A.VNDR_SEQ" ).append("\n"); 
		query.append(",   A.WO_CC_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(E.WO_FAX_NO, NULL, '0', '1' ) TRS_CHK" ).append("\n"); 
		query.append(",   '1' MDM_CHK" ).append("\n"); 
		query.append(",   M.INTL_FAX_NO || '-' || M.FAX_NO WO_FAX_NO" ).append("\n"); 
		query.append(",   M.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append(",   M.VNDR_CNTC_PNT_SEQ WO_CC_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VNDR_CNTC_PNT M" ).append("\n"); 
		query.append(",   TRS_TRSP_WRK_ORD_CC_FAX E" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND INSTR(M.VNDR_EML, '@') > 0" ).append("\n"); 
		query.append("AND M.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND M.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND M.INTL_FAX_NO = E.WO_FAX_NO(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1' TRS_CHK" ).append("\n"); 
		query.append(",   '0' MDM_CHK" ).append("\n"); 
		query.append(",   E.WO_FAX_NO" ).append("\n"); 
		query.append(",   E.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append(",   E.WO_CC_SEQ WO_CC_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD_CC_FAX E" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("E.WO_FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("AND E.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VNDR_CNTC_PNT M" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("AND M.INTL_FAX_NO = E.WO_FAX_NO" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}