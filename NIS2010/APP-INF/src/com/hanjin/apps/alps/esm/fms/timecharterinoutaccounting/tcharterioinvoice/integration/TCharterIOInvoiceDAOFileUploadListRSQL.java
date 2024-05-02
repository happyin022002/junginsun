/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDAOFileUploadListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOFileUploadListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account File Upload 리스트 조회
	  * </pre>
	  */
	public TCharterIOInvoiceDAOFileUploadListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOFileUploadListRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(F XPKFMS_ATCH_FILE) */" ).append("\n"); 
		query.append("       F.ATCH_FILE_OA_LNK_ID ," ).append("\n"); 
		query.append("       F.ATCH_FILE_OA_LNK_SEQ ," ).append("\n"); 
		query.append("       F.FILE_SAV_ID ," ).append("\n"); 
		query.append("       C.FILE_PATH_URL ," ).append("\n"); 
		query.append("       C.FILE_UPLD_NM ," ).append("\n"); 
		query.append("       TO_CHAR (F.UPD_DT, 'YYYY-MM-DD') UPD_DT ," ).append("\n"); 
		query.append("       F.UPD_USR_ID ," ).append("\n"); 
		query.append("       '0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("  FROM FMS_OWNR_ACCT_ATCH_FILE F," ).append("\n"); 
		query.append("       COM_UPLD_FILE C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND F.ATCH_FILE_OA_LNK_ID IN (" ).append("\n"); 
		query.append("                                    select s.ap_slp_tp_cd||s.ap_slp_func_cd||s.ap_slp_ofc_cd||s.ap_slp_iss_dt||s.ap_slp_ser_no||s.ap_slp_seq_no" ).append("\n"); 
		query.append("                                    from fms_csul_slp s" ).append("\n"); 
		query.append("                                    where s.slp_tp_cd||s.slp_func_cd||s.slp_ofc_cd||s.slp_iss_dt||s.slp_ser_no  in ( @[csr_no])" ).append("\n"); 
		query.append("                                    and s.ap_slp_tp_cd is not null   " ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("   AND F.FILE_SAV_ID = C.FILE_SAV_ID " ).append("\n"); 

	}
}