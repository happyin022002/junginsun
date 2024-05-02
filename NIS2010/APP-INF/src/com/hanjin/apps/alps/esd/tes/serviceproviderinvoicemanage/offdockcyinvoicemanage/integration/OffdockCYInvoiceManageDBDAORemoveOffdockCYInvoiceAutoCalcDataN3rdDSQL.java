/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataN3rdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.08.28 이정혜
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

public class OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataN3rdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveOffdockCYInvoiceAutoCalcDataN3rd
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataN3rdDSQL(){
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
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataN3rdDSQL").append("\n"); 
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
		query.append("DELETE TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE T.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND T.TML_SO_SEQ = @[tml_so_seq] AND T.CALC_COST_GRP_CD = @[calc_cost_grp_cd]" ).append("\n"); 
		query.append("AND 'A' = (" ).append("\n"); 
		query.append("SELECT D.CALC_TP_CD" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = T.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = T.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND D.CALC_COST_GRP_CD = T.CALC_COST_GRP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}