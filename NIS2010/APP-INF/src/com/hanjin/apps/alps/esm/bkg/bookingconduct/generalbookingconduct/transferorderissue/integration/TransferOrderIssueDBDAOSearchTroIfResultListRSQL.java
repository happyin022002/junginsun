/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroIfResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.06.28 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchTroIfResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgTroXterIfVO CustomVO 사용
	  * 2010.10.19 신자영 [CHM-201006495-01] TRO (KOR) Status 변경 (User ID 및 정렬 순서)
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroIfResultListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchTroIfResultListRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("     , TRO.TRO_SEQ" ).append("\n"); 
		query.append("     , TROIF.ORD_NO " ).append("\n"); 
		query.append("     , TO_CHAR(TROIF.IF_DT, 'YYYY-MM-DD HH24:MI') IF_DT " ).append("\n"); 
		query.append("     , DECODE(NVL(TROIF.ACK_STS_CD, 'N'), 'N', 'NO', 'YES') ACK_STS_CD" ).append("\n"); 
		query.append("     , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , TRIM(TROIF.RQST_ORD_MSG) RQST_ORD_MSG" ).append("\n"); 
		query.append("--     , TRO.RQST_USR_ID DOC_USR_ID" ).append("\n"); 
		query.append("     , DECODE(TROIF.CRE_USR_ID, 'MIG_USER', TRO.RQST_USR_ID, TROIF.CRE_USR_ID) DOC_USR_ID" ).append("\n"); 
		query.append("--     , USR.USR_NM" ).append("\n"); 
		query.append("     , DECODE(TROIF.CRE_USR_ID, 'MIG_USER', USR1.USR_NM, USR2.USR_NM) USR_NM" ).append("\n"); 
		query.append("     , DECODE(BK.BKG_STS_CD, 'X', 'CANCEL', 'F', 'FIRM', 'W', 'WAIT', '') BKG_STS_CD " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK " ).append("\n"); 
		query.append("     , BKG_VVD VVD" ).append("\n"); 
		query.append("     , BKG_TRO TRO" ).append("\n"); 
		query.append("     , BKG_TRO_XTER_IF TROIF" ).append("\n"); 
		query.append("     , COM_USER USR1 " ).append("\n"); 
		query.append("     , COM_USER USR2" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO        = TRO.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BK.POL_CD        = VVD.POL_CD   " ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD in ('S', 'T') " ).append("\n"); 
		query.append("   AND TRO.BKG_NO       = TROIF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD    = TROIF.IO_BND_CD(+)" ).append("\n"); 
		query.append("   AND TRO.RTN_TRO_FLG  = TROIF.RTN_TRO_FLG(+)" ).append("\n"); 
		query.append("   AND TRO.TRO_SEQ      = TROIF.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND TRO.RQST_USR_ID  = USR1.USR_ID" ).append("\n"); 
		query.append("   AND TROIF.CRE_USR_ID = USR2.USR_ID(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("   ORDER BY TROIF.IF_SEQ DESC" ).append("\n"); 

	}
}