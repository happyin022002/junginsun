/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.05.27 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DISP_DTL SET" ).append("\n"); 
		query.append("INV_NO = @[inv_no]" ).append("\n"); 
		query.append(",INV_AMT = REPLACE (@[inv_amt], ',', '')" ).append("\n"); 
		query.append(",RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = sysdate" ).append("\n"); 
		query.append(",DISP_RLSE_NO =" ).append("\n"); 
		query.append("(SELECT @[user_ofc_cd]||TO_CHAR(SYSDATE, 'YYYYMMDD')||'-'||LPAD(TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(A.DISP_RLSE_NO,LENGTH(A.DISP_RLSE_NO)-2))),0))+1, 3, 0) AS DISP_RLSE_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL A" ).append("\n"); 
		query.append(", (SELECT @[user_ofc_cd]||TO_CHAR(SYSDATE,'YYYYMMDD')||'-' PRE_DISP_RLSE_NO" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("WHERE A.DISP_RLSE_NO LIKE B.PRE_DISP_RLSE_NO || '%')" ).append("\n"); 
		query.append("WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND DISP_DTL_SEQ = @[disp_dtl_seq]" ).append("\n"); 

	}
}