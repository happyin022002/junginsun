/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.06 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTPBIfFlag
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL").append("\n"); 
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
		query.append("SELECT  S.TRSP_SO_OFC_CTY_CD IF_SO_OFC , S.TRSP_SO_SEQ IF_SO_SEQ, NVL(F.IF_FLG,'N') IF_FLG" ).append("\n"); 
		query.append("FROM TRS_N3RD_PTY_IF  F, TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("WHERE S.TRSP_SO_OFC_CTY_CD =	@[TRSP_SO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND S.TRSP_SO_SEQ = 	@[TRSP_SO_SEQ]" ).append("\n"); 
		query.append("AND S.TRSP_SO_OFC_CTY_CD = F.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND S.TRSP_SO_SEQ = F.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("AND NVL(F.CXL_FLG,'N') = 'N'" ).append("\n"); 

	}
}