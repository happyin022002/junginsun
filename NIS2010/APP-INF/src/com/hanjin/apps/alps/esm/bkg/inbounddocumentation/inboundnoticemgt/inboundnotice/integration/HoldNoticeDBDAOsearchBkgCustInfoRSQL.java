/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchBkgCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.03.24 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchBkgCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustInfoVO 생성
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchBkgCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchBkgCustInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,A.POD_CD" ).append("\n"); 
		query.append("      ,B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,B.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,B.CUST_SEQ" ).append("\n"); 
		query.append("      ,B.CUST_NM" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               BKGM.BKG_NO" ).append("\n"); 
		query.append("              ,BKGM.POD_CD" ).append("\n"); 
		query.append("              ,BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("              ,BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("              ,BCST.CUST_SEQ" ).append("\n"); 
		query.append("              ,BCST.CUST_NM" ).append("\n"); 
		query.append("        FROM   BKG_BOOKING BKGM" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("        WHERE  BKGM.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("        AND    BCST.BKG_NO         = BKGM.BKG_NO " ).append("\n"); 
		query.append("        AND    ((BKGM.SAM_CNEE_NTFY_FLG = 'N' AND BKGM.CUST_TO_ORD_FLG = 'N' AND BCST.BKG_CUST_TP_CD IN ('C', 'N')) OR -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                (BKGM.SAM_CNEE_NTFY_FLG = 'Y' AND BCST.BKG_CUST_TP_CD = 'C') OR -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                (BKGM.CUST_TO_ORD_FLG = 'Y'   AND BCST.BKG_CUST_TP_CD = 'N') -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("AND    A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 

	}
}