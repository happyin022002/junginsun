/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyStsCdSOHDR
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRUSQL").append("\n"); 
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
		query.append("UPDATE tes_tml_so_hdr SET" ).append("\n"); 
		query.append("	TML_INV_STS_CD = @[tml_inv_sts_cd]," ).append("\n"); 
		query.append("	AP_IF_DT       = DECODE(@[tml_inv_sts_cd],'P',SYSDATE,'')	" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	tml_so_ofc_cty_cd	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND tml_so_seq		= @[tml_so_seq]	" ).append("\n"); 
		query.append("	AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}