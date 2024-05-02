/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIssueInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.09.25 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIssueInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIssueInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIssueInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_rvis_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIssueInfoRSQL").append("\n"); 
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
		query.append("SELECT r.clt_agn_flg" ).append("\n"); 
		query.append(",r.n3pty_inv_sts_cd" ).append("\n"); 
		query.append(",DECODE(r.clt_agn_flg, 'N','Y', 'N') AS issue_yn" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN r.clt_agn_flg IS NULL OR r.clt_agn_flg!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN r.n3pty_inv_sts_cd!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN r.n3pty_delt_tp_cd!='N' THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTRB(r.n3pty_inv_rvis_cd,1,1)!='O' AND SUBSTRB(r.n3pty_inv_rvis_cd,1,1)!='R'THEN 'N'" ).append("\n"); 
		query.append("WHEN r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS erpif_yn" ).append("\n"); 
		query.append(",r.bil_to_loc_div_cd" ).append("\n"); 
		query.append("FROM tpb_inv_rvis r, tpb_invoice v" ).append("\n"); 
		query.append("WHERE r.n3pty_inv_no = v.n3pty_inv_no" ).append("\n"); 
		query.append("AND r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("AND r.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND r.n3pty_inv_rvis_seq = TO_NUMBER(@[s_n3pty_inv_rvis_seq])" ).append("\n"); 
		query.append("AND r.n3pty_inv_rvis_cd = @[s_n3pty_inv_rvis_cd]" ).append("\n"); 

	}
}