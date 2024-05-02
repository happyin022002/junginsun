/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.12
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2012.01.12 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Wor Order No. 존재여부 체크
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WoVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL").append("\n"); 
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
		query.append("select case when count(trsp_wo_ofc_cty_cd) < 1 or count(trsp_wo_seq) < 1 then 'W/O No. is invalid'" ).append("\n"); 
		query.append("else ''" ).append("\n"); 
		query.append("end err_msg" ).append("\n"); 
		query.append("from trs_trsp_wrk_ord" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and trsp_wo_ofc_cty_cd = @[TrspWoOfcCtyCd]" ).append("\n"); 
		query.append("and trsp_wo_seq = @[TrspWoSeq]" ).append("\n"); 
		query.append("and wo_vndr_seq = @[WoVndrSeq]" ).append("\n"); 
		query.append("and NVL(delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(inter_use_flg, 'N') != 'Y'" ).append("\n"); 

	}
}