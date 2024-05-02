/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultistopLocationInquiryDBDAOsearchMultistopLocationInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.12.11 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultistopLocationInquiryDBDAOsearchMultistopLocationInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMultistopLocationInquiryList
	  * </pre>
	  */
	public MultistopLocationInquiryDBDAOsearchMultistopLocationInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.integration").append("\n"); 
		query.append("FileName : MultistopLocationInquiryDBDAOsearchMultistopLocationInquiryListRSQL").append("\n"); 
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
		query.append("B.TRO_SUB_SEQ	TRSP_RQST_ORD_SUB_SEQ" ).append("\n"); 
		query.append(",	TO_CHAR(B.ARR_DT, 'YYYY-MM-DD HH24:MI:SS') DOR_ARR_DT" ).append("\n"); 
		query.append(",	B.LOC_CD		DOR_LOC_CD" ).append("\n"); 
		query.append(",	B.DOR_ZIP_ID	DOR_PST_CD" ).append("\n"); 
		query.append(",	TRIM(SUBSTR(B.DOR_ADDR , 1,30))	||' '||" ).append("\n"); 
		query.append("TRIM(SUBSTR(B.DOR_ADDR ,31,30))	||' '||" ).append("\n"); 
		query.append("TRIM(SUBSTR(B.DOR_ADDR ,61,30))	||' '||" ).append("\n"); 
		query.append("TRIM(SUBSTR(B.DOR_ADDR ,91,30))		AS DOR_ADDR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_EUR_TRO				A" ).append("\n"); 
		query.append(",	BKG_EUR_TRO_DTL			B" ).append("\n"); 
		query.append(",	BKG_BOOKING				C" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND A.BKG_NO				= B.BKG_NO" ).append("\n"); 
		query.append("AND A.IO_BND_CD			= B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.TRO_SEQ				= B.TRO_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO				= C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO			  = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("AND C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tro_seq} != '')" ).append("\n"); 
		query.append("AND A.TRO_SEQ		  = @[tro_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_tpsz_no} != '')" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD		  = @[cntr_tpsz_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("B.TRO_SUB_SEQ" ).append("\n"); 

	}
}