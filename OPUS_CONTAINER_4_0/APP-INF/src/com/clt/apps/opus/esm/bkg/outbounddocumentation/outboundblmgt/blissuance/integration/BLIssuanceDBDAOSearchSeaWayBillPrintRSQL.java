/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchSeaWayBillPrintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchSeaWayBillPrintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sea Waybill 출력시 BKG_INET_BL_PRN_AUTH 테이블에 저장할 데이터를 조회한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchSeaWayBillPrintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchSeaWayBillPrintRSQL").append("\n"); 
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
		query.append("    BK.BKG_NO" ).append("\n"); 
		query.append("    ,BK.BL_NO" ).append("\n"); 
		query.append("    ,BK.VSL_CD" ).append("\n"); 
		query.append("    ,BK.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,BK.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(BL.BL_OBRD_DT,'YYYYMMDD') AS BL_OBRD_DT" ).append("\n"); 
		query.append("    ,S.CUST_CNT_CD  AS SHPR_CNT_CD" ).append("\n"); 
		query.append("    ,S.CUST_SEQ     AS SHPR_SEQ" ).append("\n"); 
		query.append("    ,C.CUST_CNT_CD  AS CNEE_CNT_CD" ).append("\n"); 
		query.append("    ,C.CUST_SEQ     AS CNEE_SEQ" ).append("\n"); 
		query.append("    ,N.CUST_CNT_CD  AS NTFY_CNT_CD" ).append("\n"); 
		query.append("    ,N.CUST_SEQ     AS NTFY_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK  " ).append("\n"); 
		query.append("    ,BKG_BL_DOC BL  " ).append("\n"); 
		query.append("    ,BKG_CUSTOMER S  " ).append("\n"); 
		query.append("    ,BKG_CUSTOMER C  " ).append("\n"); 
		query.append("    ,BKG_CUSTOMER N  " ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD (+)  = 'S'  " ).append("\n"); 
		query.append("AND BK.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD (+)  = 'C'  " ).append("\n"); 
		query.append("AND BK.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("AND N.BKG_CUST_TP_CD (+)  = 'N'" ).append("\n"); 

	}
}