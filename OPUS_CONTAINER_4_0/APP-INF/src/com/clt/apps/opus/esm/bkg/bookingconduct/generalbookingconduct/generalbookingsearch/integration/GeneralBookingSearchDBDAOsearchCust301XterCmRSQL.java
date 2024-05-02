/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301XterCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : jklim
*@LastVersion : 1.0
* 2014.12.18 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301XterCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301XterCm
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301XterCmRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301XterCmRSQL").append("\n"); 
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
		query.append("SELECT '{I_CM_MARK_DESC'							||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_SEQ:'		||MK_DESC_SEQ				||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_CNTR_NO:'	||NVL(CNTR_NO, '')			||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_HTS_CD:'	||NVL(HAMO_TRF_CTNT, '')	||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_PKG_CD:'	||NVL(PCK_TP_CD, '')		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_PKG_CD_DESC:'	||CMDT_PCK_UT_CD_DESC   ||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_PKG_QTY:'	||NVL(PCK_QTY, 0)		    ||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_WGT_TP:'	||NVL(WGT_UT_CD, '')		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_WGT_QTY:'	||NVL(CNTR_MF_WGT, 0)		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_NET_WGT_TP:'	|| CMDT_NET_WGT_TP_CD	||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_NET_WGT_QTY:'	|| CMDT_NET_WGT_QTY		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_MEA_TP:'	||NVL(MEAS_UT_CD, '')		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_MEA_QTY:'	||NVL(MEAS_QTY, 0)		    ||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_DESC:'	||NVL(CNTR_MF_DESC, '')		||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_DESC_DTL:'||NVL(CNTR_MF_DTL_DESC, '') ||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_MARK:'    ||NVL(CNTR_MF_MK_DESC, '')  ||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_OB_HAUL_TP:'	|| OB_HLG_TP_CD			||CHR(10)||" ).append("\n"); 
		query.append("		'ICMD_IB_HAUL_TP:'	|| IB_HLG_TP_CD			||CHR(10)||" ).append("\n"); 
		query.append("		'}I_CM_MARK_DESC'							||CHR(10) I_CM_MARK_DESC" ).append("\n"); 
		query.append("  FROM	BKG_XTEr_CNTR_MK_DESC" ).append("\n"); 
		query.append(" where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append(" ORDER BY MK_DESC_SEQ" ).append("\n"); 

	}
}