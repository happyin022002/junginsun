/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetEmptyLoadingQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetEmptyLoadingQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당PORT에서 LOADING 되는 EMTPY 컨테이너 수량
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetEmptyLoadingQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetEmptyLoadingQtyRSQL").append("\n"); 
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
		query.append("SELECT  NVL(COUNT(1),0) QTY  " ).append("\n"); 
		query.append("  FROM BAY_PLAN A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD   = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("   AND A.VOY_NO   = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("   AND A.DIR_CD   = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("   AND A.POL      = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("   AND A.FE       = 'E'" ).append("\n"); 
		query.append("   AND A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.POL      = B.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND B.YD_CD    = @[yd_cd]" ).append("\n"); 
		query.append("   AND A.CALL_IND = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND A.PORT_CD  = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 

	}
}