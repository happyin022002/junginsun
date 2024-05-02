/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillEquementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillEquementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBillEquement
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillEquementRSQL(){
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
		params.put("strsp_edi_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillEquementRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append("	  ,A.EQ_TPSZ_CD AS EQ_TPSZ" ).append("\n"); 
		query.append("	  ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("      ,A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,@[strsp_edi_snd_no] AS STRSP_EDI_SND_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}