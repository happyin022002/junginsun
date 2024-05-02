/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cstms notice 대상 e-mail 정보 조회
	  * </pre>
	  */
	public UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL").append("\n"); 
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
		query.append("-- 화주-" ).append("\n"); 
		query.append("SELECT B.BKG_NO, A.CUST_NM, B.NTC_EML" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT BKGM.BKG_NO, BCST.CUST_NM, MAX(HIS_SEQ) HIS_SEQ " ).append("\n"); 
		query.append("        FROM   BKG_BOOKING BKGM" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("              ,BKG_NTC_HIS  BNTC" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("        WHERE  BKGM.BL_NO          = @[bkg_no]" ).append("\n"); 
		query.append("        AND    BKGM.BL_NO         = IBD.BL_NO  " ).append("\n"); 
		query.append("        AND    BCST.BKG_NO         = BKGM.BKG_NO " ).append("\n"); 
		query.append("        AND    IBD.CNT_CD = 'US' " ).append("\n"); 
		query.append("        AND    ((BKGM.SAM_CNEE_NTFY_FLG = 'N' AND BKGM.CUST_TO_ORD_FLG = 'N' AND BCST.BKG_CUST_TP_CD IN ('C', 'N')) OR -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                (BKGM.SAM_CNEE_NTFY_FLG = 'Y' AND BCST.BKG_CUST_TP_CD = 'C') OR -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                (BKGM.CUST_TO_ORD_FLG = 'Y'   AND BCST.BKG_CUST_TP_CD = 'N') -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        AND BNTC.BKG_NO            = BCST.BKG_NO" ).append("\n"); 
		query.append("        AND BNTC.BKG_CUST_TP_CD    = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("        AND BNTC.NTC_KND_CD        = 'AN'" ).append("\n"); 
		query.append("        AND BCST.AN_SND_FLG = 'Y'  " ).append("\n"); 
		query.append("        AND BNTC.NTC_VIA_CD ='M' /*MAIL OR FAX*/" ).append("\n"); 
		query.append("        AND IBD.CSTMS_CLR_TP_CD IN ('I','L')" ).append("\n"); 
		query.append("        GROUP BY BKGM.BKG_NO, BCST.CUST_NM,BNTC.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    , BKG_NTC_HIS B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.HIS_SEQ = B.HIS_SEQ" ).append("\n"); 

	}
}