/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOremoveWODetailByPayINVSeqDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.20 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOremoveWODetailByPayINVSeqDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeWODetailByPayINVSeqData
	  * </pre>
	  */
	public RepairMgtDBDAOremoveWODetailByPayINVSeqDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOremoveWODetailByPayINVSeqDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_ORD_DTL" ).append("\n"); 
		query.append("WHERE PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("AND   ACCT_CD = '511591'" ).append("\n"); 

	}
}