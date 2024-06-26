/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCEmailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.07.14 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOSearchWorkOrderCCEmailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 vndr_seq 에 해당하는 이메일 정보를 조회한다.
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOSearchWorkOrderCCEmailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOSearchWorkOrderCCEmailListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.TRS_CHK" ).append("\n"); 
		query.append(",   A.MDM_CHK" ).append("\n"); 
		query.append(",   A.TRS_CHK_ORG" ).append("\n"); 
		query.append(",   A.WO_EML" ).append("\n"); 
		query.append(",   A.VNDR_SEQ" ).append("\n"); 
		query.append(",   A.WO_CC_SEQ " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     DECODE(E.WO_EML, NULL, '0', '1' ) TRS_CHK" ).append("\n"); 
		query.append(",   '1' MDM_CHK" ).append("\n"); 
		query.append(",   DECODE(E.WO_EML, NULL, '0', '1' ) TRS_CHK_ORG" ).append("\n"); 
		query.append(",   M.VNDR_EML WO_EML" ).append("\n"); 
		query.append(",   M.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append(",   NVL(E.WO_CC_SEQ, M.VNDR_CNTC_PNT_SEQ) WO_CC_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_VNDR_CNTC_PNT M" ).append("\n"); 
		query.append(",   TRS_TRSP_WRK_ORD_CC_EML E" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    M.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND INSTR(M.VNDR_EML, '@') > 0" ).append("\n"); 
		query.append("AND M.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND M.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND M.VNDR_EML = E.WO_EML(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    '1' TRS_CHK" ).append("\n"); 
		query.append(",   '0' MDM_CHK" ).append("\n"); 
		query.append(",   '1' TRS_CHK_ORG" ).append("\n"); 
		query.append(",   E.WO_EML WO_EML" ).append("\n"); 
		query.append(",   E.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append(",   E.WO_CC_SEQ WO_CC_SEQ " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   TRS_TRSP_WRK_ORD_CC_EML E" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    E.WO_EML IS NOT NULL" ).append("\n"); 
		query.append("AND E.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VNDR_CNTC_PNT M" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("AND M.VNDR_EML = E.WO_EML" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}