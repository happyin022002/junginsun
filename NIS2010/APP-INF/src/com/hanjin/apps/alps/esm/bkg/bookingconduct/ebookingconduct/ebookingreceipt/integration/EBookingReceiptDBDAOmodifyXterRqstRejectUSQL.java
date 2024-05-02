/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOmodifyXterRqstRejectUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOmodifyXterRqstRejectUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyXterRqstReject
	  * </pre>
	  */
	public EBookingReceiptDBDAOmodifyXterRqstRejectUSQL(){
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
		params.put("upld_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("multi_reject",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_upld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOmodifyXterRqstRejectUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST MST SET " ).append("\n"); 
		query.append("	 RJCT_RSN_RMK = CASE WHEN @[multi_reject] = 'Y' THEN " ).append("\n"); 
		query.append("                         (SELECT BHCC.ATTR_CTNT1||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 ' '||@[rjct_rsn_rmk]||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT2||MST.XTER_RQST_NO||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT3||MST.VSL_CD||MST.SKD_VOY_NO||MST.SKD_DIR_CD||' '||MST.VSL_NM||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT4||MST.POR_CD||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT5||MST.POL_CD||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT6||MST.POD_CD||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT7||MST.DEL_CD||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT8||(SELECT CU.USR_EML FROM COM_USER CU WHERE USR_ID = @[upld_usr_id] AND ROWNUM =1 )||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("                                 BHCC.ATTR_CTNT9||CHR(13)||CHR(10)" ).append("\n"); 
		query.append("                          FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                          WHERE HRD_CDG_ID = 'XTER_MULTI_REJECT'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("					ELSE @[rjct_rsn_rmk]" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("	,XTER_RJCT_RSN_CD = @[xter_rjct_rsn_cd]" ).append("\n"); 
		query.append("	,BKG_UPLD_STS_CD = @[bkg_upld_sts_cd]" ).append("\n"); 
		query.append("	,UPD_USR_ID = @[upld_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT = sysdate" ).append("\n"); 
		query.append("	,XTER_RQST_STS_USR_ID = @[upld_usr_id]" ).append("\n"); 
		query.append("	,XTER_RQST_STS_CD = @[bkg_upld_sts_cd]" ).append("\n"); 
		query.append("    ,XTER_RQST_STS_UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND	XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND	XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}