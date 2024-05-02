/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyBbCgoBySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopyBbCgoBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyBbCgoBySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyBbCgoBySplitCSQL").append("\n"); 
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
		query.append("insert into bkg_bb_cgo(" ).append("\n"); 
		query.append("BKG_NO " ).append("\n"); 
		query.append(",BB_CGO_SEQ " ).append("\n"); 
		query.append(",RCV_TERM_CD " ).append("\n"); 
		query.append(",DE_TERM_CD " ).append("\n"); 
		query.append(",PCK_QTY " ).append("\n"); 
		query.append(",PCK_TP_CD " ).append("\n"); 
		query.append(",GRS_WGT " ).append("\n"); 
		query.append(",NET_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",DIM_LEN " ).append("\n"); 
		query.append(",DIM_WDT " ).append("\n"); 
		query.append(",DIM_HGT " ).append("\n"); 
		query.append(",CGO_WGT " ).append("\n"); 
		query.append(",STWG_INSTR_DESC " ).append("\n"); 
		query.append(",BB_DCGO_SEQ " ).append("\n"); 
		query.append(",CMDT_CD " ).append("\n"); 
		query.append(",SLNG_PNT_FLG " ).append("\n"); 
		query.append(",GRAV_CTR_DESC " ).append("\n"); 
		query.append(",PCK_DTL_DESC " ).append("\n"); 
		query.append(",CGO_LODG_MZD_CD " ).append("\n"); 
		query.append(",SCR_DNG_CTNT " ).append("\n"); 
		query.append(",SPCL_RQST_DESC " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",RQST_DT " ).append("\n"); 
		query.append(",RQST_USR_ID " ).append("\n"); 
		query.append(",SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CGO_DCHG_MZD_CD" ).append("\n"); 
		query.append(",CGO_DCHG_SD_CD" ).append("\n"); 
		query.append(",CGO_LODG_SD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO " ).append("\n"); 
		query.append(",BB_CGO_SEQ " ).append("\n"); 
		query.append(",RCV_TERM_CD " ).append("\n"); 
		query.append(",DE_TERM_CD " ).append("\n"); 
		query.append(",PCK_QTY " ).append("\n"); 
		query.append(",PCK_TP_CD " ).append("\n"); 
		query.append(",GRS_WGT " ).append("\n"); 
		query.append(",NET_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",DIM_LEN " ).append("\n"); 
		query.append(",DIM_WDT " ).append("\n"); 
		query.append(",DIM_HGT " ).append("\n"); 
		query.append(",CGO_WGT " ).append("\n"); 
		query.append(",STWG_INSTR_DESC " ).append("\n"); 
		query.append(",BB_DCGO_SEQ " ).append("\n"); 
		query.append(",CMDT_CD  " ).append("\n"); 
		query.append(",SLNG_PNT_FLG " ).append("\n"); 
		query.append(",GRAV_CTR_DESC " ).append("\n"); 
		query.append(",PCK_DTL_DESC " ).append("\n"); 
		query.append(",CGO_LODG_MZD_CD " ).append("\n"); 
		query.append(",SCR_DNG_CTNT " ).append("\n"); 
		query.append(",SPCL_RQST_DESC " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",RQST_DT  " ).append("\n"); 
		query.append(",RQST_USR_ID " ).append("\n"); 
		query.append(",SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID " ).append("\n"); 
		query.append(",sysdate CRE_DT " ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append(",CGO_DCHG_MZD_CD" ).append("\n"); 
		query.append(",CGO_DCHG_SD_CD" ).append("\n"); 
		query.append(",CGO_LODG_SD_CD" ).append("\n"); 
		query.append("from bkg_bb_cgo" ).append("\n"); 
		query.append("where bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bb_cgo_seq} != 'all')" ).append("\n"); 
		query.append("	and bb_cgo_seq  = @[bb_cgo_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}