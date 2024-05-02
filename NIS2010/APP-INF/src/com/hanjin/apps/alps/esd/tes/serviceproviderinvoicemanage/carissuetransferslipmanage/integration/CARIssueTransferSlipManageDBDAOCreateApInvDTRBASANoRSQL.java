/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.11.11 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRBASANo
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoRSQL").append("\n"); 
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
		query.append("select  a.line_seq, b.line_no, c.inv_no, c.iss_dt, c.loc_cd, d.total_amt   from" ).append("\n"); 
		query.append("(select nvl(max(line_seq),0)+1 line_seq from ap_inv_dtrb where csr_no = @[csr_no]) a," ).append("\n"); 
		query.append("(select nvl(max(line_no),0)+1 line_no from ap_inv_dtrb where csr_no = @[csr_no]) b," ).append("\n"); 
		query.append("(select a.attr_ctnt1 inv_no, max(b.attr_ctnt2) iss_dt, substr(yd_cd,1,5) loc_cd" ).append("\n"); 
		query.append("from (select max(attr_ctnt1) attr_ctnt1 from ap_inv_dtrb where csr_no =@[csr_no]) a," ).append("\n"); 
		query.append("ap_inv_dtrb b" ).append("\n"); 
		query.append("where b.csr_no =@[csr_no] and a.attr_ctnt1 = b.attr_ctnt1" ).append("\n"); 
		query.append("group by yd_cd, a.attr_ctnt1) c," ).append("\n"); 
		query.append("(select -sum(inv_amt) total_amt from ap_inv_dtrb where csr_no = @[csr_no]) d" ).append("\n"); 

	}
}