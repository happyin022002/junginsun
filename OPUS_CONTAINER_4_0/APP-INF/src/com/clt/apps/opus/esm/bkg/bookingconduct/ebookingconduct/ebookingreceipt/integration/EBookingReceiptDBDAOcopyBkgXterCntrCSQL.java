/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOcopyBkgXterCntrCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.04 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOcopyBkgXterCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * copyBkgXterCntr
	  * </pre>
	  */
	public EBookingReceiptDBDAOcopyBkgXterCntrCSQL(){
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
		query.append("INSERT INTO BKG_XTER_CNTR" ).append("\n");
		query.append("(xter_sndr_id,  xter_rqst_no,  xter_rqst_seq" ).append("\n");
		query.append(", CNTR_NO, cNTR_TpSz_CD," ).append("\n");
		query.append(", pck_qty, Pck_tp_cd" ).append("\n");
		query.append(", meas_qty, meas_ut_cd" ).append("\n");
		query.append(", meas_qty, meas_ut_cd" ).append("\n");
		query.append(", soc_flg, prt_flg)" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("xter_sndr_id,  xter_rqst_no,  xter_rqst_seq+1" ).append("\n");
		query.append(", CNTR_NO, cNTR_TpSz_CD," ).append("\n");
		query.append(", pck_qty, Pck_tp_cd" ).append("\n");
		query.append(", meas_qty, meas_ut_cd" ).append("\n");
		query.append(", meas_qty, meas_ut_cd" ).append("\n");
		query.append(", soc_flg, prt_flg" ).append("\n");
		query.append("FROM	bkg_xter_cntr" ).append("\n");
		query.append("WHERE	xter_rqst_no = @[rqst_no]" ).append("\n");
		query.append("AND	xter_rqst_seq    = @[rqst_seq]" ).append("\n");
		query.append("AND     xter_sndr_id = @[sender_id]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n");
		query.append("FileName : EBookingReceiptDBDAOcopyBkgXterCntrCSQL").append("\n");
		query.append("*/").append("\n");
	}
}