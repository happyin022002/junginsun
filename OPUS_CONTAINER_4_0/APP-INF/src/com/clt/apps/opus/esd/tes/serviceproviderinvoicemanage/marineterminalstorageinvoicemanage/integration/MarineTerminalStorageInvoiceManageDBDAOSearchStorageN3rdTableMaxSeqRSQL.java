/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdTableMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.26 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdTableMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorageN3rdTableMaxSeq
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdTableMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdTableMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(TML_IF_SEQ),0) max_n3rd_list_seq" ).append("\n"); 
		query.append("FROM TES_N3RD_PTY_IF" ).append("\n"); 
		query.append("WHERE TML_IF_OFC_CD = @[tml_if_ofc_cd]" ).append("\n"); 

	}
}