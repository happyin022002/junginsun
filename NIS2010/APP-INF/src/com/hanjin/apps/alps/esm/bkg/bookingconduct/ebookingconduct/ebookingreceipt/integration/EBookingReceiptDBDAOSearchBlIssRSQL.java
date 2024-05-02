/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBlIssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.01.06 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchBlIssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchBlIss
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBlIssRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchBlIssRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(OBL_ISS_FLG), 'N') OBL_ISS_FLG" ).append("\n"); 
		query.append("  FROM BKG_BL_ISS BL, " ).append("\n"); 
		query.append("       BKG_BOOKING BK," ).append("\n"); 
		query.append("       MDM_ORGANIZATION A," ).append("\n"); 
		query.append("       MDM_LOCATION B," ).append("\n"); 
		query.append("       BKG_XTER_RQST_MST X" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("   AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("   AND X.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND X.XTER_SNDR_ID =@[sender_id]" ).append("\n"); 
		query.append("   AND X.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND X.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   AND ((X.XTER_RQST_VIA_CD = 'WEB' AND B.CNT_CD IN ('CN','MY','IN','TW','PH','LK') AND A.OFC_CD NOT IN ('XMNSC', 'HKGSC', 'SZPSC'))" ).append("\n"); 
		query.append("   OR (X.XTER_RQST_VIA_CD = 'WEB' AND B.CNT_CD NOT IN ('CN','MY','IN','TW','PH','LK') AND NVL(BK.BL_TP_CD,'B') = 'B'  AND NVL(BL.OBL_SRND_FLG, 'N') ='N')" ).append("\n"); 
		query.append("   OR (X.XTER_RQST_VIA_CD = 'WEB' AND A.OFC_CD IN ('XMNSC', 'HKGSC', 'SZPSC') AND NVL(BK.BL_TP_CD,'B') = 'B'  AND NVL(BL.OBL_SRND_FLG, 'N') ='N')" ).append("\n"); 
		query.append("   OR X.XTER_RQST_VIA_CD != 'WEB')" ).append("\n"); 

	}
}