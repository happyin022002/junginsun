/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301RcvIdForMtyRelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301RcvIdForMtyRelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301RcvIdForMtyRel
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301RcvIdForMtyRelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301RcvIdForMtyRelRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("		EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("		, EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("		, '' EDI_ID" ).append("\n"); 
		query.append("  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("		, BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("		, BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.MTY_PKUP_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND EDI_MSG_IND_CD = '5'" ).append("\n"); 
		query.append("   AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("   AND EY.TRD_PRNR_SUB_LNK_SEQ IN (SELECT TRD_PRNR_SUB_LNK_SEQ " ).append("\n"); 
		query.append("                                     FROM BKG_EDI_SUB_LNK_MSG " ).append("\n"); 
		query.append("                                    WHERE EDI_MSG_IND_CD = DECODE(@[auto_mnl_flg], 'Y', 1, 2)) --1:auto, 2:manual" ).append("\n"); 
		query.append("#if(${auto_mnl_flg}=='Y')" ).append("\n"); 
		query.append("   AND EY.RCVR_TRD_PRNR_ID NOT IN --301이 나갔으면 EMTPY RELEASE 대상에서 제외" ).append("\n"); 
		query.append("	   (SELECT EY.RCVR_TRD_PRNR_ID" ).append("\n"); 
		query.append("	      FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("	         , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("	         , BKG_VVD VVD" ).append("\n"); 
		query.append("	         , BKG_BOOKING BK" ).append("\n"); 
		query.append("	     WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("	       AND BK.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("	       AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("	       AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("	       AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("	       and EY.TRD_PRNR_SUB_LNK_SEQ in (select TRD_PRNR_SUB_LNK_SEQ " ).append("\n"); 
		query.append("	                                      	 from BKG_EDI_SUB_LNK_MSG " ).append("\n"); 
		query.append("	                                    	where EDI_MSG_IND_CD = decode(@[auto_mnl_flg], 'Y', 1, 2)) --1:auto, 2:manual" ).append("\n"); 
		query.append("	       AND (   (EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD AND MSG.EDI_MSG_IND_CD IN ('1', '2')) --입력된 찾아진 pol과 같거나" ).append("\n"); 
		query.append("	            OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD = 'S' AND MSG.EDI_MSG_IND_CD = '6') --pre t/s port 지정 건이나" ).append("\n"); 
		query.append("	            OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD = 'U' AND MSG.EDI_MSG_IND_CD = '7') --post t/s port 지정 건" ).append("\n"); 
		query.append("    	       )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}