/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgQtyDtlForCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.14 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgQtyDtlForCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_qyt_dtl 테이블에서 cntr_tpsz_cd, op_cntr_qty, rcv_term, de_term를 복사를 위해 조회한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgQtyDtlForCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgQtyDtlForCopyRSQL").append("\n"); 
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
		query.append("BKG_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUBST_SEQ" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",DE_TERM_CD" ).append("\n"); 
		query.append(",OP_CNTR_QTY" ).append("\n"); 
		query.append(",DECODE(@[awk_cgo_flg],'Y',AWK_CGO_FLG,'N') AWK_CGO_FLG" ).append("\n"); 
		query.append(",DECODE(@[dcgo_flg],'Y',DCGO_FLG,'N') DCGO_FLG" ).append("\n"); 
		query.append(",DECODE(@[rc_flg],'Y',RC_FLG,'N') RC_FLG" ).append("\n"); 
		query.append(",DECODE(@[bb_cgo_flg],'Y',BB_CGO_FLG,'N') BB_CGO_FLG" ).append("\n"); 
		query.append(",SOC_FLG" ).append("\n"); 
		query.append(",EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DRY_CGO_FLG" ).append("\n"); 
		query.append(",DECODE(@[hngr_flg],'Y',CRR_HNGR_FLG,'N') CRR_HNGR_FLG" ).append("\n"); 
		query.append(",DECODE(@[hngr_flg],'Y',MER_HNGR_FLG,'N') MER_HNGR_FLG" ).append("\n"); 
		query.append(",DECODE(@[hngr_flg],'Y',CRR_HNGR_SGL_BAR_USE_FLG,'N') CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(",DECODE(@[hngr_flg],'Y',CRR_HNGR_DBL_BAR_USE_FLG,'N') CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(",DECODE(@[hngr_flg],'Y',CRR_HNGR_TPL_BAR_USE_FLG,'N') CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_QTY_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}