/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtBkgChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.12 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtBkgChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtBkgChgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCntrRtBkgChgRSQL").append("\n"); 
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
		query.append("#if (${ca_flag} == 'Y')" ).append("\n"); 
		query.append("SELECT T1.BKG_NO" ).append("\n"); 
		query.append(",      T1.RT_SEQ" ).append("\n"); 
		query.append(",      T1.DP_SEQ" ).append("\n"); 
		query.append(",      T1.CHG_CD" ).append("\n"); 
		query.append(",      T1.TRF_ITM_NO" ).append("\n"); 
		query.append(",      T1.CURR_CD" ).append("\n"); 
		query.append(",      T1.CHG_UT_AMT" ).append("\n"); 
		query.append(",      T1.RAT_AS_QTY" ).append("\n"); 
		query.append(",      T1.RAT_UT_CD" ).append("\n"); 
		query.append(",      T1.CHG_AMT" ).append("\n"); 
		query.append(",      T1.FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append(",      T1.FRT_TERM_CD" ).append("\n"); 
		query.append(",      T1.N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append(",      T1.N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append(",      DECODE (T1.N3PTY_CUST_SEQ, 0, '', T1.N3PTY_CUST_SEQ) AS N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(",      T1.CGO_CATE_CD" ).append("\n"); 
		query.append(",      T1.RCV_TERM_CD" ).append("\n"); 
		query.append(",      T1.DE_TERM_CD" ).append("\n"); 
		query.append(",      T1.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",      T1.INV_STS_CD" ).append("\n"); 
		query.append(",      T1.PRN_HDN_FLG" ).append("\n"); 
		query.append(",      T1.AUTO_RAT_CD" ).append("\n"); 
		query.append(",      T1.APLY_XCH_RTO" ).append("\n"); 
		query.append(",      T1.AGMT_RAT_UT_CD" ).append("\n"); 
		query.append(",      T1.CRE_USR_ID" ).append("\n"); 
		query.append(",      T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT_HIS T1" ).append("\n"); 
		query.append("#if (${mst_flag} == 'Y')" ).append("\n"); 
		query.append("WHERE  t1.bkg_no in (SELECT a.bkg_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append(",      (SELECT NVL (b.mst_cvrd_bl_no, a.bl_no) mst_bl_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    a.bkg_no = @[bkg_no]) c" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    (a.bl_no = c.mst_bl_no OR b.mst_cvrd_bl_no = c.mst_bl_no))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE  t1.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    t1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    t1.frt_incl_xcld_div_cd = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT T1.BKG_NO" ).append("\n"); 
		query.append(",      T1.RT_SEQ" ).append("\n"); 
		query.append(",      T1.DP_SEQ" ).append("\n"); 
		query.append(",      T1.CHG_CD" ).append("\n"); 
		query.append(",      T1.TRF_ITM_NO" ).append("\n"); 
		query.append(",      T1.CURR_CD" ).append("\n"); 
		query.append(",      T1.CHG_UT_AMT" ).append("\n"); 
		query.append(",      T1.RAT_AS_QTY" ).append("\n"); 
		query.append(",      T1.RAT_UT_CD" ).append("\n"); 
		query.append(",      T1.CHG_AMT" ).append("\n"); 
		query.append(",      T1.FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append(",      T1.FRT_TERM_CD" ).append("\n"); 
		query.append(",      T1.N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append(",      T1.N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append(",      DECODE (T1.N3PTY_CUST_SEQ, 0, '', T1.N3PTY_CUST_SEQ) AS N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(",      T1.CGO_CATE_CD" ).append("\n"); 
		query.append(",      T1.RCV_TERM_CD" ).append("\n"); 
		query.append(",      T1.DE_TERM_CD" ).append("\n"); 
		query.append(",      T1.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",      T1.INV_STS_CD" ).append("\n"); 
		query.append(",      T1.PRN_HDN_FLG" ).append("\n"); 
		query.append(",      T1.AUTO_RAT_CD" ).append("\n"); 
		query.append(",      T1.APLY_XCH_RTO" ).append("\n"); 
		query.append(",      T1.AGMT_RAT_UT_CD" ).append("\n"); 
		query.append(",      T1.CRE_USR_ID" ).append("\n"); 
		query.append(",      T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT T1" ).append("\n"); 
		query.append("#if (${mst_flag} == 'Y')" ).append("\n"); 
		query.append("WHERE  t1.bkg_no in (SELECT a.bkg_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append(",      (SELECT NVL (b.mst_cvrd_bl_no, a.bl_no) mst_bl_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    a.bkg_no = @[bkg_no]) c" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    (a.bl_no = c.mst_bl_no OR b.mst_cvrd_bl_no = c.mst_bl_no))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE  t1.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    t1.frt_incl_xcld_div_cd = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}