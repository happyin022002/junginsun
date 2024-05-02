/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBlCustomerInfoInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.10.30 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchBlCustomerInfoInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBlCustomerInfoInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchBlCustomerInfoInterfaceRSQL").append("\n"); 
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
		query.append("SELECT NVL(XS.CUST_SEQ, S.CUST_SEQ) S_CUST_SEQ," ).append("\n"); 
		query.append("       S.CUST_SEQ S_CUST_SEQ_OLD," ).append("\n"); 
		query.append("       NVL(XS.CUST_NM,  MS.CUST_LGL_ENG_NM) S_CUST_NM," ).append("\n"); 
		query.append("       CASE WHEN XS.CUST_SEQ IS NOT NULL THEN 'Y' ELSE 'N' END S_CUST_SUBST_FLG," ).append("\n"); 
		query.append("       NVL(XS.CNT_CD, S.CUST_CNT_CD) S_CUST_CNT_CD," ).append("\n"); 
		query.append("       S.CUST_CNT_CD S_CUST_CNT_CD_OLD," ).append("\n"); 
		query.append("       NVL(XF.CUST_SEQ, F.CUST_SEQ) F_CUST_SEQ," ).append("\n"); 
		query.append("       F.CUST_SEQ F_CUST_SEQ_OLD," ).append("\n"); 
		query.append("       NVL(XF.CUST_NM,  MF.CUST_LGL_ENG_NM) F_CUST_NM," ).append("\n"); 
		query.append("       CASE WHEN XF.CUST_SEQ IS NOT NULL THEN 'Y' ELSE 'N' END F_CUST_SUBST_FLG," ).append("\n"); 
		query.append("       NVL(XF.CNT_CD, F.CUST_CNT_CD) F_CUST_CNT_CD," ).append("\n"); 
		query.append("       F.CUST_CNT_CD F_CUST_CNT_CD_OLD," ).append("\n"); 
		query.append("       NVL(XC.CUST_SEQ, C.CUST_SEQ) C_CUST_SEQ," ).append("\n"); 
		query.append("       C.CUST_SEQ C_CUST_SEQ_OLD," ).append("\n"); 
		query.append("       NVL(XC.CUST_NM,  MC.CUST_LGL_ENG_NM) C_CUST_NM," ).append("\n"); 
		query.append("       CASE WHEN XC.CUST_SEQ IS NOT NULL THEN 'Y' ELSE 'N' END C_CUST_SUBST_FLG," ).append("\n"); 
		query.append("       NVL(XC.CNT_CD, C.CUST_CNT_CD) C_CUST_CNT_CD," ).append("\n"); 
		query.append("       C.CUST_CNT_CD C_CUST_CNT_CD_OLD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST X, " ).append("\n"); 
		query.append("     BKG_XTER_CUST XS, BKG_XTER_CUST XF, BKG_XTER_CUST XC," ).append("\n"); 
		query.append("     BKG_CUSTOMER S, BKG_CUSTOMER F, BKG_CUSTOMER C," ).append("\n"); 
		query.append("     MDM_CUSTOMER MS, MDM_CUSTOMER MF, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE X.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND X.XTER_SNDR_ID = XS.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_NO = XS.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_SEQ = XS.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'S' = XS.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND X.XTER_SNDR_ID = XF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_NO = XF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_SEQ = XF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'F' = XF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND X.XTER_SNDR_ID = XC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_NO = XC.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND X.XTER_RQST_SEQ = XC.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'C' = XC.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND X.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = S.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND X.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'F' = F.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND X.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'C' = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("and s.cust_cnt_cd  = ms.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and s.cust_seq     = ms.cust_seq(+)" ).append("\n"); 
		query.append("and c.cust_cnt_cd  = mc.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and c.cust_seq     = mc.cust_seq(+)" ).append("\n"); 
		query.append("and f.cust_cnt_cd  = mf.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and f.cust_seq     = mf.cust_seq(+)" ).append("\n"); 

	}
}