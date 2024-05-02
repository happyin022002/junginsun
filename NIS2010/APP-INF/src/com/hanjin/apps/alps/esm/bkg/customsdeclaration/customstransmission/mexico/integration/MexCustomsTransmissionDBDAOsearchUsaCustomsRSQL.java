/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchUsaCustomsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.25 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchUsaCustomsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO : MxUsaCustomsVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchUsaCustomsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchUsaCustomsRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("IB.IBD_TRSP_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("--BKG_CSTMS_ADV_BL BL," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_IBD IB" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("IB.CNT_CD = 'US'" ).append("\n"); 
		query.append("--AND BL.CNT_CD = IB.CNT_CD" ).append("\n"); 
		query.append("--AND BL.BL_NO = IB.BL_NO" ).append("\n"); 
		query.append("AND IB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND IB.IBD_TRSP_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}