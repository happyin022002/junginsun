/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYAccountCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.09.09 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdockCYAccountCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdockCYAccountCode
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdockCYAccountCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYAccountCodeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(REPLACE(D.TML_CRR_CD,'-',''),NULL,C.ACCT_CD,C.CRR_ACCT_CD)  ACCT_CD," ).append("\n"); 
		query.append("D.LGS_COST_CD              LGS_COST_CD," ).append("\n"); 
		query.append("D.TML_SO_OFC_CTY_CD        TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("D.TML_SO_SEQ               TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_SO_DTL_SEQ           TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("FROM   TES_TML_SO_DTL D, TES_LGS_COST C" ).append("\n"); 
		query.append("WHERE  D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    D.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("AND    ( D.CALC_TP_CD      = 'M' OR D.CALC_COST_GRP_CD = 'SP' )" ).append("\n"); 
		query.append("AND      D.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("ORDER BY TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_DTL_SEQ" ).append("\n"); 

	}
}