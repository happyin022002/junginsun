/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDAOSearchChinaAgentCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.05 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDAOSearchChinaAgentCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중국 Booking Agent 정보 등록 화면
	  * </pre>
	  */
	public BookingMasterMgtDAOSearchChinaAgentCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDAOSearchChinaAgentCodeRSQL").append("\n"); 
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
		query.append("CHN_AGN_CD" ).append("\n"); 
		query.append(",	AGN_NM" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	VNDR_CNT_CD" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",   VNDR_CNT_CD || VNDR_SEQ AS ORIGIN_VNDR" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",   CUST_CNT_CD || CUST_SEQ AS ORIGIN_CUST" ).append("\n"); 
		query.append(",	AUTO_DP_CHK_FLG" ).append("\n"); 
		query.append(",	AGN_EML" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	FINC_OFC_CD" ).append("\n"); 
		query.append(",	AR_OFC_CD" ).append("\n"); 
		query.append(",	DIR_PAY_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",	(SELECT C.OFC_CD  FROM   COM_USER C WHERE  C.USR_ID = A.UPD_USR_ID AND ROWNUM=1) UPD_OFC_CD" ).append("\n"); 
		query.append(",   BKG_BLCK_FLG" ).append("\n"); 
		query.append("FROM BKG_CHN_AGN A" ).append("\n"); 
		query.append("WHERE	1 =1" ).append("\n"); 
		query.append("AND  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${chn_agn_cd} != '')" ).append("\n"); 
		query.append("AND	CHN_AGN_CD = @[chn_agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND	FINC_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND	CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agn_nm} != '')" ).append("\n"); 
		query.append("AND	AGN_NM LIKE '%' ||  @[agn_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OFC_CD,CHN_AGN_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 

	}
}