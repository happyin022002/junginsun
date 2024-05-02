/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.02.10 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice Exchange Amount 금액을 수정
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_CONV_AMT A" ).append("\n"); 
		query.append("SET INV_BZC_AMT	=" ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('USD'," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INV_BZC_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_SEQ			= TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD	= TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.SUB_RAIL_SEQ			= SUB_RAIL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("INV_ETC_ADD_AMT =" ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('USD'," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_DTL" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_SEQ			= TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD	= A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.SUB_RAIL_SEQ			= SUB_RAIL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("UPD_USR_ID = @[sUsrId]," ).append("\n"); 
		query.append("LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD				= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	  TRSP_SO_SEQ						= @[trsp_so_seq]" ).append("\n"); 
		query.append("AND	  SUB_RAIL_SEQ IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUB_RAIL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE TRSP_SO_SEQ				= A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   TRSP_SO_OFC_CTY_CD		= A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   PAIR_VNDR_SEQ				= @[railRoadCode]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}