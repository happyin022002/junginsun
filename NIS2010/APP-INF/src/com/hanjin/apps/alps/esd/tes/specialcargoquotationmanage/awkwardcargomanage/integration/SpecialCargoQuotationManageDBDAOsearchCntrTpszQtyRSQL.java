/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchCntrTpszQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.19 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchCntrTpszQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrTpszQty
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchCntrTpszQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchCntrTpszQtyRSQL").append("\n"); 
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
		query.append("SELECT B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",B1.OP_CNTR_QTY" ).append("\n"); 
		query.append(",B2.BB_CGO_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUM(A1.OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM BKG_QUANTITY A1" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") B1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUM(A1.OP_CNTR_QTY) AS BB_CGO_QTY" ).append("\n"); 
		query.append("FROM BKG_QTY_DTL A1" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("WHERE B1.CNTR_TPSZ_CD = B2.CNTR_TPSZ_CD" ).append("\n"); 

	}
}