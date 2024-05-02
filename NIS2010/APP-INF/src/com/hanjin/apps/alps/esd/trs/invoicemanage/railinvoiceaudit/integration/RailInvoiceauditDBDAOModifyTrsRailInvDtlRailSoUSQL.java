/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.11.09 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 테이블에 Invoice정보를 반영
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("SET FINC_VSL_CD =" ).append("\n"); 
		query.append("        	(" ).append("\n"); 
		query.append("        		SELECT" ).append("\n"); 
		query.append("        			VSL_CD FDR_VSL_CD" ).append("\n"); 
		query.append("        		FROM" ).append("\n"); 
		query.append("        			BKG_BOOKING" ).append("\n"); 
		query.append("        		WHERE A.BKG_NO				= BKG_NO" ).append("\n"); 
		query.append("        	)," ).append("\n"); 
		query.append("     FINC_SKD_VOY_NO =" ).append("\n"); 
		query.append("        	(" ).append("\n"); 
		query.append("        		SELECT" ).append("\n"); 
		query.append("        			SKD_VOY_NO FDR_SKD_VOY_NO" ).append("\n"); 
		query.append("        		FROM" ).append("\n"); 
		query.append("        			BKG_BOOKING" ).append("\n"); 
		query.append("        		WHERE A.BKG_NO				= BKG_NO" ).append("\n"); 
		query.append("        	)," ).append("\n"); 
		query.append("     FINC_SKD_DIR_CD =" ).append("\n"); 
		query.append("        	NVL(MAS_REV_DIR_CONV_FNC(A.SLAN_CD, A.POL_CD, A.SKD_DIR_CD, A.POD_CD), A.SKD_DIR_CD)," ).append("\n"); 
		query.append("     UPD_USR_ID	= @[sUsrId]," ).append("\n"); 
		query.append("     LOCL_UPD_DT	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD			= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	  A.TRSP_SO_SEQ					= @[trsp_so_seq]" ).append("\n"); 

	}
}