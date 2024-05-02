/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenDBDAOsearchPkupNtcBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchPkupNtcBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리
	  * </pre>
	  */
	public CsScreenDBDAOsearchPkupNtcBkgInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration ").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchPkupNtcBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BCST.CUST_CNT_CD || BCST.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append(",BCST.CUST_NM" ).append("\n"); 
		query.append(",BKGM.POD_CD" ).append("\n"); 
		query.append(",BKGM.DEL_CD" ).append("\n"); 
		query.append(",BCST.CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(",BCST.CUST_SEQ    AS CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO = @[bkg_no]  --'AARY1050014'" ).append("\n"); 
		query.append("AND  BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( BKGM.SAM_CNEE_NTFY_FLG = 'N'" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD = 'C' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR ( BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR ( BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}