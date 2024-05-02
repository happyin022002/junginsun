/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDDAOSearchBlListByPoNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.18 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDDAOSearchBlListByPoNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.
	  * 
	  *  UI_BKG-0943
	  * </pre>
	  */
	public BookingUtilDBDDAOSearchBlListByPoNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDDAOSearchBlListByPoNoRSQL").append("\n"); 
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
		query.append("A.BKG_NO" ).append("\n"); 
		query.append("--,	A.BKG_NO_SPLIT" ).append("\n"); 
		query.append(",	A.PCK_QTY" ).append("\n"); 
		query.append(",	A.PCK_TP_CD" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.ACT_WGT" ).append("\n"); 
		query.append(",	A.WGT_UT_CD" ).append("\n"); 
		query.append(",	A.ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(",	A.HBL_TTL_KNT" ).append("\n"); 
		query.append(",	A.SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append(",	A.BL_OBRD_TP_CD" ).append("\n"); 
		query.append(",	A.BL_OBRD_DT" ).append("\n"); 
		query.append(",	A.AUD_ERR_CTNT" ).append("\n"); 
		query.append(",	A.IB_MF_CFM_FLG" ).append("\n"); 
		query.append(",	A.BIS_SYS_FLG" ).append("\n"); 
		query.append(",	A.ORG_CNT_NM" ).append("\n"); 
		query.append(",	A.POR_CD" ).append("\n"); 
		query.append(",	A.POR_NM" ).append("\n"); 
		query.append(",	A.POL_CD" ).append("\n"); 
		query.append(",	A.POL_NM" ).append("\n"); 
		query.append(",	A.POD_CD" ).append("\n"); 
		query.append(",	A.POD_NM" ).append("\n"); 
		query.append(",	A.DEL_CD" ).append("\n"); 
		query.append(",	A.DEL_NM" ).append("\n"); 
		query.append(",	A.BL_MV_TP_NM" ).append("\n"); 
		query.append(",	A.FNL_DEST_NM" ).append("\n"); 
		query.append(",	A.VSL_NM" ).append("\n"); 
		query.append(",	A.PRE_VSL_NM" ).append("\n"); 
		query.append(",	A.BL_CVRD_TP_CD" ).append("\n"); 
		query.append(",	A.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("--,	A.MST_CVRD_BL_NO_TP" ).append("\n"); 
		query.append("--,	A.MST_CVRD_BL_NO_CHK" ).append("\n"); 
		query.append("--,	A.CDR_VSL_CD" ).append("\n"); 
		query.append("--,	A.CDR_SKD_VOY_NO" ).append("\n"); 
		query.append("--,	A.CDR_SKD_DIR_CD" ).append("\n"); 
		query.append("--,	A.CDR_POL_CD" ).append("\n"); 
		query.append("--,	A.CDR_POD_CD" ).append("\n"); 
		query.append("--,	A.CDR_FLG" ).append("\n"); 
		query.append("--,	A.CDR_CNG_FLG" ).append("\n"); 
		query.append("--,	A.RCDR_DT" ).append("\n"); 
		query.append(",	A.BDR_FLG" ).append("\n"); 
		query.append(",	A.BDR_DT" ).append("\n"); 
		query.append(",	A.BDR_CNG_FLG" ).append("\n"); 
		query.append(",	A.CORR_NO" ).append("\n"); 
		query.append(",	A.CORR_USR_ID" ).append("\n"); 
		query.append(",	A.CORR_OFC_CD" ).append("\n"); 
		query.append(",	A.CORR_N1ST_DT" ).append("\n"); 
		query.append(",	A.CORR_DT" ).append("\n"); 
		query.append(",	A.CORR_RMK" ).append("\n"); 
		query.append(",	A.BKG_CLZ_FLG" ).append("\n"); 
		query.append(",	A.BKG_CLZ_CNG_FLG" ).append("\n"); 
		query.append(",	A.BKG_CLZ_CNG_CFM_FLG" ).append("\n"); 
		query.append(",	A.TTL_PCK_DESC" ).append("\n"); 
		query.append(",	A.CSTMS_DESC" ).append("\n"); 
		query.append(",	A.MK_DESC_CFM_FLG" ).append("\n"); 
		query.append(",	A.PCK_CMDT_DESC" ).append("\n"); 
		query.append(",	A.CNTR_CMDT_DESC" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("--2009-08-18 :  SAM_CNEE_NTFY_FLG = 'N' AND D.CUST_TO_ORD_FLG = 'Y' 일 경우 NOTIFY 외 CONSIGNEE" ).append("\n"); 
		query.append(",	CASE WHEN D.SAM_CNEE_NTFY_FLG = 'N' AND D.CUST_TO_ORD_FLG = 'Y' THEN" ).append("\n"); 
		query.append("(SELECT CUST_NM FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND		BC.BKG_CUST_TP_CD = 'N') ELSE" ).append("\n"); 
		query.append("(SELECT CUST_NM FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND		BC.BKG_CUST_TP_CD = 'C') END CUST_NM" ).append("\n"); 
		query.append(",   D.BL_NO" ).append("\n"); 
		query.append(",   D.BL_TP_CD" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC A" ).append("\n"); 
		query.append(",      BKG_REFERENCE B" ).append("\n"); 
		query.append(",      BKG_BOOKING  D" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--컬럼 name변경 20090727 CUST_REF_NO ==> CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("AND    B.CUST_REF_NO_CTNT = @[cust_ref_no]" ).append("\n"); 
		query.append("AND    B.BKG_REF_TP_CD IN ('BKPO','CMPO','CTPO')" ).append("\n"); 
		query.append("AND    A.BKG_NO = D.BKG_NO" ).append("\n"); 

	}
}