/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301RcvIdForFullRelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301RcvIdForFullRelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301RcvIdForFullRel
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301RcvIdForFullRelRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301RcvIdForFullRelRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT EDI_RCV_ID, PORT_CD, NOTICE.EDI_ID, EDI_REF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT DISTINCT " ).append("\n"); 
		query.append("		   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("		 , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("		 , '' EDI_ID" ).append("\n"); 
		query.append("	  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("			, BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("			, BKG_BOOKING BK" ).append("\n"); 
		query.append("	 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND BK.FULL_RTN_YD_CD 		= EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("	   AND EY.TRD_PRNR_SUB_LNK_SEQ 	= MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("	   AND MSG.EDI_MSG_TP_ID 		= '301'" ).append("\n"); 
		query.append("	   AND MSG.MSG_TP_DESC	 		= '1'" ).append("\n"); 
		query.append("       AND MSG.EDI_MSG_IND_CD 	 = '4'" ).append("\n"); 
		query.append("     ) EY, BKG_NTC_HIS NOTICE " ).append("\n"); 
		query.append(" WHERE NOTICE.NTC_VIA_CD(+) = 'E'" ).append("\n"); 
		query.append("   AND NOTICE.NTC_KND_CD(+) = 'BT'" ).append("\n"); 
		query.append("   AND EY.EDI_RCV_ID        = NOTICE.EDI_ID(+)" ).append("\n"); 
		query.append("   AND 'R'                   <> NVL(NOTICE.TML_NTC_SND_STS_CD(+), ' ') --R cancel" ).append("\n"); 
		query.append("   AND NOTICE.BKG_NO(+)     = @[bkg_no]" ).append("\n"); 

	}
}