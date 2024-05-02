/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlDocReqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlDocReqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchBlDocReq
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlDocReqRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlDocReqRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(NVL(CUST.CUST_CNT, 0), 0, 'N', 'Y')||'|'||" ).append("\n"); 
		query.append("DECODE(NVL(CNTR.CNTR_CNT, 0), 0, 'N', 'Y')||'|'||" ).append("\n"); 
		query.append("DECODE(NVL(RATE.RATE_CNT, 0), 0, 'N', 'Y')||'|'||" ).append("\n"); 
		query.append("DECODE(NVL(MND.MND_CNT, 0), 0, 'N', 'Y') AS DOC_READY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.BKG_NO," ).append("\n"); 
		query.append("NVL(COUNT(*), 0) CUST_CNT" ).append("\n"); 
		query.append("FROM  BKG_BOOKING A, BKG_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND   TRIM(CUST_NM) IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(") CUST," ).append("\n"); 
		query.append("(SELECT A.BKG_NO," ).append("\n"); 
		query.append("NVL(COUNT(*), 0) CNTR_CNT" ).append("\n"); 
		query.append("FROM  BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(") CNTR," ).append("\n"); 
		query.append("(SELECT A.BKG_NO," ).append("\n"); 
		query.append("DECODE(NVL(B.RT_BL_TP_CD, 'N'), 'C', 1, 'B', 1, COUNT(C.BKG_NO)) RATE_CNT" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("BKG_RATE B," ).append("\n"); 
		query.append("BKG_CHG_RT C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND   A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO, B.RT_BL_TP_CD" ).append("\n"); 
		query.append(") RATE," ).append("\n"); 
		query.append("(SELECT A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("NVL(COUNT(B.BKG_NO), 0) MND_CNT" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   B.PCK_QTY IS NOT NULL" ).append("\n"); 
		query.append("AND   B.ACT_WGT IS NOT NULL" ).append("\n"); 
		query.append("AND   B.CSTMS_DESC IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(") MND," ).append("\n"); 
		query.append("BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = MND.BKG_NO(+)" ).append("\n"); 

	}
}