/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterRqstMstForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : jklim
*@LastVersion : 1.0
* 2014.12.17 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterRqstMstForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi 중 master 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterRqstMstForAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterRqstMstForAckRSQL").append("\n"); 
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
		query.append("select  'IB_NO:'            || MST.xter_rqst_no						||CHR(10)||" ).append("\n"); 
		query.append("        'BKG_NO_AUT:'       || BKG_NO							||CHR(10)||" ).append("\n"); 
		query.append("        'BKG_STS:'          || 'Y'  							||CHR(10)||" ).append("\n"); 
		query.append("        'SED_IND:'          || decode(MST.xter_rqst_seq,1,'9','7')  ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_PO_NO:'         || PO_NO  							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_C_ID:'          || CUST_ID  						||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POL_CD:'        || POL_CD 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POL_NM:'        || POL_NM 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POR_CD:'        || POR_CD 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POR_NM:'        || POR_NM 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POD_CD:'        || POD_CD 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POD_NM:'        || POD_NM 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_DEL_CD:'        || DEL_CD 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_DEL_NM:'        || DEL_NM 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_FNLDST_CD:'     || FNL_DEST_CD   					||CHR(10)||    " ).append("\n"); 
		query.append("        'IB_FNLDST_NM:'     || FNL_DEST_NM						||CHR(10)||    " ).append("\n"); 
		query.append("        'IB_ORG_CD:'        || BL_ORG_OF_LOC_CD					||CHR(10)||" ).append("\n"); 
		query.append("        'IB_ORG_NM:'        || ORG_CNT_NM						||CHR(10)||       " ).append("\n"); 
		query.append("        'IB_SHIP_EXP_DT:'   || TO_CHAR(SHP_EXP_DT, 'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SHIP_DT:'       || TO_CHAR(RQST_DEP_DT,'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_VSL_CD:'        || VSL_CD 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_VVD_NM:'        || VSL_NM 							||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SKD_VOYAGE_NO:' || SKD_VOY_NO||SKD_DIR_CD			||CHR(10)||" ).append("\n"); 
		query.append("        'IB_PRE_VSL_NM:'    || MST.PRE_VSL_NM             ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_PRE_VSL_VOY:'   || MST.PRE_VSL_VOY_NO||MST.PRE_VSL_DIR_CD  ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POST_VSL_NM:'   || MST.ON_CRR_VSL_NM          ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POST_VSL_VOY:'  || MST.ON_CRR_VSL_VOY_NO||MST.ON_CRR_VSL_DIR_CD       ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_FRT_TERM:'      || MST.FRT_TERM_CD                                    ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_DEL_ETA:'       || TO_CHAR(MST.RQST_ARR_DT,'YYYYMMDDHH24MI')          ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_CY_CLOSE_DT:'   || TO_CHAR(MISC.CLZ_DT, 'YYYYMMDDHH24MI') ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_PICKUP_CY_NM:'  || BKG_JOIN_FNC(CURSOR((SELECT BXT.PKUP_YD_CD " ).append("\n"); 
		query.append("                                                      FROM BKG_XTER_TRO_DTL BXT " ).append("\n"); 
		query.append("                                                     WHERE BXT.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXT.XTER_RQST_NO = MST.XTER_RQST_NO AND BXT.XTER_RQST_SEQ = MST.XTER_RQST_SEQ)), ',')  ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_RMK:'           || XTER_BKG_RMK1					||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SI_NO:'         || SI_NO							||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  from bkg_xter_rqst_mst MST" ).append("\n"); 
		query.append("       ,BKG_XTER_RQST_MISC MISC" ).append("\n"); 
		query.append(" where MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   and MST.xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and MST.xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID = MISC.XTER_SNDR_ID" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO = MISC.XTER_RQST_NO" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = MISC.XTER_RQST_SEQ" ).append("\n"); 

	}
}