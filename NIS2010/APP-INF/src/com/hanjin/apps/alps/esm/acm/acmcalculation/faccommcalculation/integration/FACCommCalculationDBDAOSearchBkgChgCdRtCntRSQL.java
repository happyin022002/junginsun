/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT DECODE(CHG_CD,'SMC','OFT'," ).append("\n"); 
		query.append("                                       'TSC','OFT'," ).append("\n"); 
		query.append("                                       'DTS','OFT'," ).append("\n"); 
		query.append("                                       'TXS','OFT'," ).append("\n"); 
		query.append("                                       'WHC','OFT'," ).append("\n"); 
		query.append("                                       'CPU','OFT'," ).append("\n"); 
		query.append("                                       'MSC','OFT'," ).append("\n"); 
		query.append("                                       'OCR','OFT'," ).append("\n"); 
		query.append("                                       'LWS','OFT'," ).append("\n"); 
		query.append("                                       'HWS','OFT'," ).append("\n"); 
		query.append("                                       'CFC','OFT'," ).append("\n"); 
		query.append("                                       'EMC','OFT'," ).append("\n"); 
		query.append("                                       CHG_CD)  " ).append("\n"); 
		query.append("            ) CNT" ).append("\n"); 
		query.append("   FROM BKG_CHG_RT" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("    AND CHG_CD IN('OFT','SMC','TSC','DTS','TXS','WHC','CPU','MSC','OCR','LWS','HWS','CFC','EMC')" ).append("\n"); 

	}
}