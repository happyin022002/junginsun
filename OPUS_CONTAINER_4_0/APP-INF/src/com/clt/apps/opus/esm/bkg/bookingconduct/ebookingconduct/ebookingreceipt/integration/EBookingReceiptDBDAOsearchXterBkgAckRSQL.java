/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterBkgAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("edi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("res_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgAckRSQL").append("\n"); 
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
		query.append("SELECT	'$$$MSGSTART:'||RPAD(LTRIM(edi.SND_ID),20)||" ).append("\n"); 
		query.append("            RPAD(LTRIM(mst.xter_sndr_id),20)||RPAD('APERAK',10)||" ).append("\n"); 
		query.append("        	@[edi_seq]||CHR(10)||" ).append("\n"); 
		query.append("			'IB_BKG_NO:'      ||mst.bkg_no                               ||CHR(10)||" ).append("\n"); 
		query.append("		    'IB_BKG_NO_SPLIT:'||substr(mst.bkg_no, 11, 2)                ||CHR(10)||" ).append("\n"); 
		query.append("	    	'IB_MSG_FLAG:'    ||mst.doc_tp_cd                            ||CHR(10)||" ).append("\n"); 
		query.append("            'IB_CUST_MSG_NO:' ||MST.XTER_RQST_NO                         ||CHR(10)||" ).append("\n"); 
		query.append("            'IB_APK_MSG_NO:'  ||@[edi_seq]          ||CHR(10)||" ).append("\n"); 
		query.append("		    'IB_C_DATE:'      ||TO_CHAR(mst.RQST_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("#if (${res_cd} == 'Reject') " ).append("\n"); 
		query.append("			'IB_R_DATE:'      ||TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("		    'RESPONSE:'       ||(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02193' AND INTG_CD_VAL_CTNT = MST.XTER_RJCT_RSN_CD) || CHR(10)||" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			'IB_R_DATE:'      ||TO_CHAR(mst.UPLD_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("		    'RESPONSE:'       ||CHR(10)||" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            'IB_REQ_CD:'      ||MST.XTER_BKG_RQST_STS_CD                 ||CHR(10)||" ).append("\n"); 
		query.append("            'IB_RES_CD:'      ||@[res_cd]	                             ||CHR(10)||" ).append("\n"); 
		query.append("            'ACK_C_DATE:'     ||TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')    AS FLAT_FILE" ).append("\n"); 
		query.append("   FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("        ,(select hrd.attr_ctnt1 rcv_id, hrd.attr_ctnt2 SND_ID" ).append("\n"); 
		query.append("            from bkg_hrd_cdg_ctnt hrd" ).append("\n"); 
		query.append("           where HRD_CDG_ID = @[hrd_cdg_id]) edi" ).append("\n"); 
		query.append(" where 1 = 1" ).append("\n"); 
		query.append("   and mst.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 
		query.append("   AND mst.xter_sndr_id     = edi.rcv_id" ).append("\n"); 
		query.append("   AND ROWNUM 		        = 1" ).append("\n"); 

	}
}