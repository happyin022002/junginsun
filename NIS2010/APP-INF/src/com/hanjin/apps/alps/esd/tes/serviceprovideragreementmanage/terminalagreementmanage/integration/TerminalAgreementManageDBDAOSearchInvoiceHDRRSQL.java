/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchInvoiceHDRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.07 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchInvoiceHDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement 정보로 Invoice Header 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchInvoiceHDRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchInvoiceHDRRSQL").append("\n"); 
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
		query.append("SELECT  d.tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", d.tml_so_seq" ).append("\n"); 
		query.append(", d.tml_so_dtl_seq" ).append("\n"); 
		query.append("FROM    TES_TML_SO_HDR h, TES_TML_SO_DTL d" ).append("\n"); 
		query.append("WHERE   h.tml_so_ofc_cty_cd	= d.tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND     h.tml_so_seq		= d.tml_so_seq" ).append("\n"); 
		query.append("AND     NVL(h.delt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND     d.tml_agmt_ofc_cty_cd	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     d.tml_agmt_seq			= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND     d.tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 

	}
}